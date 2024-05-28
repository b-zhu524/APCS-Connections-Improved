package org.apcs.service;

import org.apcs.model.*;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;


import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_3_5_TURBO;

/**
 * contains methods to get requests using LangChain
 */
public class ChatGPTRequests
{
    /**
     * makes a new ChatGPT model and gives inputs of varying difficulties
     * outputs in the form of GameSolutions, which is placed into model
     * called whenever a new game is rendered
     * @return model - a GameModel with GameSolution data from ChatGPT
     */
    public GameModel getGameModel()
    {
        ChatLanguageModel llm = OpenAiChatModel.builder()
                .apiKey(APIKey.OPENAI_KEY)
                .modelName(GPT_3_5_TURBO)
                .temperature(0.9)   // decides the "randomness" of the output
                .build();

        String[] levels = new String[]{"hard", "very hard", "extremely hard", "almost impossible"};

        String text = "Give me four categories of English words. The answer should be a comma separated list." +
                "Example: colors, fruits, synonyms of 'pay', planets. Make it very random and hard to guess.";
        Prompt gptPrompt = new Prompt(text);

        String response = llm.generate(gptPrompt.text());
        String[] categories = getFormattedResponse(response);


        GameSolution solution = new GameSolution();
        for ( int i=0; i<4; i++ )
        {
            String wordsString = "Give me four English words that belong to " + categories[i] +
                    ". The answer should be a comma separated list. Example: word1, word2, word3, word4. Make it random, factual, and "
                    + levels[i] + " to guess.";
            Prompt wordsPrompt = new Prompt(wordsString);
            String wordsResponse = llm.generate(wordsPrompt.text());
            String[] words = getFormattedResponse(wordsResponse);

            Category cat = new Category(words, categories[i], i);
            solution.add(cat);
            System.out.println(cat.getCatName() + " " + cat.getCatInfo());
        }

        GameModel model = new GameModel(solution);

        return model;
    }

    private String[] getFormattedResponse(String response)
    {
        String[] parsedResponse = response.split(",");
        String[] stripped = new String[4];

        for (int i=0; i<4; i++)
        {
            stripped[i] = parsedResponse[i].strip().toUpperCase();
        }
        return stripped;
    }
}
