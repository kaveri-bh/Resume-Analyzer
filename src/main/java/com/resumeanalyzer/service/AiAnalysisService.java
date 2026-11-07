
package com.resumeanalyzer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AiAnalysisService {

    @Value("${app.groq.api-key:}")
    private String key;

    @Value("${app.groq.model:openai/gpt-oss-120b}")
    private String model;

    private final RestClient http = RestClient.builder()
            .baseUrl("https://api.groq.com/openai/v1")
            .build();

    public String analyze(String resume, String job) {

        if (key != null && !key.isBlank()) {

            try {

                String systemPrompt =
                        "You are a professional AI Resume Analyzer. " +
                        "Analyze the candidate resume against the job description. " +
                        "If no job description is provided, evaluate against a suitable " +
                        "entry-level software developer profile. " +
                        "Never invent experience or qualifications. " +
                        "Provide the output in this format:\n\n" +

                        "1. Overall Estimated Match: NN%\n" +
                        "2. Matching Skills\n" +
                        "3. Missing Skills\n" +
                        "4. Skills to Improve\n" +
                        "5. Improvement Suggestions\n" +
                        "6. Suitable Job Roles\n" +
                        "7. Recommended Job Websites\n\n" +

                        "The overall estimated match percentage MUST be clearly " +
                        "written in the exact format: Overall Estimated Match: NN%. " +
                        "Use a realistic score from 0 to 100. " +
                        "Mention that the score is an estimate, not an employer ATS score.";

                String userPrompt =
                        "JOB DESCRIPTION:\n" +
                        (job == null || job.isBlank()
                                ? "No job description provided. Evaluate for entry-level software jobs."
                                : job) +
                        "\n\nRESUME:\n" +
                        resume.substring(0, Math.min(12000, resume.length()));

                Map<String, Object> body = Map.of(
                        "model", model,
                        "temperature", 0.2,
                        "messages", List.of(
                                Map.of(
                                        "role", "system",
                                        "content", systemPrompt
                                ),
                                Map.of(
                                        "role", "user",
                                        "content", userPrompt
                                )
                        )
                );

                Map result = http.post()
                        .uri("/chat/completions")
                        .header("Authorization", "Bearer " + key)
                        .body(body)
                        .retrieve()
                        .body(Map.class);

                List choices = (List) result.get("choices");

                Map message = (Map) ((Map) choices.get(0))
                        .get("message");

                return String.valueOf(message.get("content"));

            } catch (Exception e) {

                return fallback(resume)
                        + "\n\nAI request failed: "
                        + e.getMessage();
            }
        }

        return fallback(resume)
                + "\n\nGroq API key not configured. "
                + "Please configure GROQ_API_KEY.";
    }

    private String fallback(String resume) {

        String text = resume.toLowerCase();

        String[] allSkills = {
                "java",
                "python",
                "sql",
                "mysql",
                "html",
                "css",
                "javascript",
                "spring boot",
                "rest api",
                "git",
                "react",
                "docker",
                "communication"
        };

        List<String> detectedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String skill : allSkills) {

            if (text.contains(skill)) {
                detectedSkills.add(skill);
            } else {
                missingSkills.add(skill);
            }
        }

        int score = (int) Math.round(
                100.0 * detectedSkills.size() / allSkills.length
        );

        return "1. Overall Estimated Match: " + score + "%\n\n"

                + "2. Matching Skills:\n"
                + String.join(", ", detectedSkills) + "\n\n"

                + "3. Missing Skills:\n"
                + String.join(", ",
                missingSkills.subList(
                        0,
                        Math.min(6, missingSkills.size())
                )) + "\n\n"

                + "4. Skills to Improve:\n"
                + "Practise Spring Boot, REST APIs, SQL and Git.\n\n"

                + "5. Improvement Suggestions:\n"
                + "Add measurable project outcomes, improve your "
                + "technical skills and include GitHub portfolio links.\n\n"

                + "6. Suitable Job Roles:\n"
                + "Java Developer Trainee, Backend Developer Intern, "
                + "Software Engineer Trainee.\n\n"

                + "7. Recommended Job Websites:\n"
                + "LinkedIn Jobs, Naukri, Indeed, Internshala.\n\n"

                + "This is a keyword-based estimate, not an employer ATS score.";
    }

    public int score(String analysis) {

        if (analysis == null || analysis.isBlank()) {
            return 0;
        }

        String[] patterns = {

                "(?i)overall\\s+estimated\\s+match[^\\d%]{0,40}(\\d{1,3})\\s*%",

                "(?i)overall\\s+match[^\\d%]{0,40}(\\d{1,3})\\s*%",

                "(?i)resume\\s+match\\s+estimate[^\\d%]{0,40}(\\d{1,3})\\s*%",

                "(?i)estimated\\s+match[^\\d%]{0,40}(\\d{1,3})\\s*%",

                "(?i)estimate:\\s*(\\d{1,3})\\s*%"
        };

        for (String pattern : patterns) {

            Matcher matcher = Pattern.compile(pattern)
                    .matcher(analysis);

            if (matcher.find()) {

                int value = Integer.parseInt(matcher.group(1));

                return Math.min(100, value);
            }
        }

        return 0;
    }
}
