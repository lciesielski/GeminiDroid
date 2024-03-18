package com.example.geminipro;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ChatSession;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;

import java.io.IOException;
import java.io.InputStream;

public class GeminiPro {

    private final static String TAG = "GEMINI_PRO_CLASS";
    private static Context mainActivity;

    private final String projectId = "turnkey-guild-417609";
    private final String location = "europe-west3";
    private final String modelName = "gemini-1.0-pro";

    public GeminiPro (Context mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void chatDiscussion() throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream is = GeminiPro.mainActivity.getResources().openRawResource(R.raw.settings);
                    GoogleCredentials credentials = GoogleCredentials.fromStream(is).createScoped("https://www.googleapis.com/auth/cloud-platform");
                    credentials.refreshIfExpired();

                    try (VertexAI vertexAI = new VertexAI(projectId, location, credentials)) {
                        GenerateContentResponse response;

                        GenerativeModel model = new GenerativeModel(modelName, vertexAI);
                        // Create a chat session to be used for interactive conversation.
                        ChatSession chatSession = model.startChat();

                        response = chatSession.sendMessage("Hello.");
                        Log.d(TAG, "> Hello.");
                        Log.d(TAG, "< " + ResponseHandler.getText(response));

                        response = chatSession.sendMessage("What are all the colors in a rainbow?");
                        Log.d(TAG, "> What are all the colors in a rainbow?");
                        Log.d(TAG, "< " + ResponseHandler.getText(response));

                        response = chatSession.sendMessage("Why does it appear when it rains?");
                        Log.d(TAG, "> Why does it appear when it rains?");
                        Log.d(TAG, "< " + ResponseHandler.getText(response));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
