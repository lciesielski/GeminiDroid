# GeminiDroid
Sample repository to use Vertex AI, instead of Google AI Studio - which is not available in EU... yet

### Settings file
In [GeminiPro.java](https://github.com/lciesielski/GeminiDroid/blob/master/app/src/main/java/com/example/geminipro/GeminiPro.java#L38) class on line 38 settings file from `res\raw` folder is expected (you can see tree on a screenshoot below).
This settings file is generated from CLI `gcloud` 

To generate it you should run command `gcloud auth application-default login`

Which after succesfull login should generate JSON file and print it's location in CMD

---

![image](https://github.com/lciesielski/GeminiDroid/assets/72916944/0c8612b2-fe61-4d00-bd27-57e29bf7a0d5)
