package Resources;

public class Payloads {
    public String CreateCollectionPayload(String CollectionName){
        return "{\n" +
                "  \"collection\": {\n" +
                "    \"variables\": [],\n" +
                "    \"info\": {\n" +
                "      \"name\": \""+CollectionName+"\",\n" +
                "      \"description\": \"This is just a sample collection.\",\n" +
                "      \"schema\": \"https://schema.getpostman.com/json/collection/v2.0.0/collection.json\"\n" +
                "    },\n" +
                "    \"item\": [\n" +
                "          {\n" +
                "            \"name\": \"Sample POST Request\",\n" +
                "            \"request\": {\n" +
                "              \"url\": \"echo.getpostman.com/post\",\n" +
                "              \"method\": \"POST\",\n" +
                "              \"header\": [\n" +
                "                {\n" +
                "                  \"key\": \"Content-Type\",\n" +
                "                  \"value\": \"application/json\",\n" +
                "                  \"description\": \"\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"body\": {\n" +
                "                \"mode\": \"raw\"\n" +
                "              },\n" +
                "              \"description\": \"This is a sample POST Request\"\n" +
                "            },\n" +
                "            \"response\": []\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"Sample GET Request\",\n" +
                "            \"request\": {\n" +
                "              \"url\": \"echo.getpostman.com/get\",\n" +
                "              \"method\": \"GET\",\n" +
                "              \"header\": [],\n" +
                "              \"body\": {\n" +
                "                \"mode\": \"formdata\",\n" +
                "                \"formdata\": []\n" +
                "              },\n" +
                "              \"description\": \"This is a sample GET Request\"\n" +
                "            },\n" +
                "            \"response\": []\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "  }\n";
    }
    public String CreateCollectionInValidPayload(String CollectionName){
        return "{\n" +
                "  \"collection\": {\n" +
                "    \"variables\": [],\n" +
                "    \"info\": {\n" +
                "      \"name\": \""+CollectionName+"\",\n" +
                "      \"description\": \"This is just a sample collection.\",\n" +
                "      \"schema\": \"https://schema.getpostman.com/json/collection/v2.0.0/collection.json\"\n" +
                "    },\n" +
                "    \"tem\": [\n" +
                "          {\n" +
                "            \"name\": \"Sample POST Request\",\n" +
                "            \"request\": {\n" +
                "              \"url\": \"echo.getpostman.com/post\",\n" +
                "              \"method\": \"POST\",\n" +
                "              \"header\": [\n" +
                "                {\n" +
                "                  \"key\": \"Content-Type\",\n" +
                "                  \"value\": \"application/json\",\n" +
                "                  \"description\": \"\"\n" +
                "                }\n" +
                "              ],\n" +
                "              \"body\": {\n" +
                "                \"mode\": \"raw\"\n" +
                "              },\n" +
                "              \"description\": \"This is a sample POST Request\"\n" +
                "            },\n" +
                "            \"response\": []\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"Sample GET Request\",\n" +
                "            \"request\": {\n" +
                "              \"url\": \"echo.getpostman.com/get\",\n" +
                "              \"method\": \"GET\",\n" +
                "              \"header\": [],\n" +
                "              \"body\": {\n" +
                "                \"mode\": \"formdata\",\n" +
                "                \"formdata\": []\n" +
                "              },\n" +
                "              \"description\": \"This is a sample GET Request\"\n" +
                "            },\n" +
                "            \"response\": []\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "  }\n";
    }
    public String UpdateCollectionPayload(String CollectionName){
        return "{\n" +
                "  \"collection\": {\n" +
                "    \"variables\": [],\n" +
                "    \"info\": {\n" +
                "      \"name\": \""+CollectionName+"\",\n" +
                "      \"_postman_id\": \"1d3daef4-2037-4584-ab86-bafd8c8f8a55\",\n" +
                "      \"description\": \"This is just a sample collection.\",\n" +
                "      \"schema\": \"https://schema.getpostman.com/json/collection/v2.0.0/collection.json\"\n" +
                "    },\n" +
                "    \"item\": [\n" +
                "      {\n" +
                "        \"name\": \"Sample GET Request\",\n" +
                "        \"request\": {\n" +
                "          \"url\": \"echo.getpostman.com/get\",\n" +
                "          \"method\": \"GET\",\n" +
                "          \"header\": [],\n" +
                "          \"body\": {\n" +
                "            \"mode\": \"formdata\",\n" +
                "            \"formdata\": []\n" +
                "          },\n" +
                "          \"description\": \"This is a sample GET Request\"\n" +
                "        },\n" +
                "        \"response\": []\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Sample POST Request\",\n" +
                "        \"request\": {\n" +
                "          \"url\": \"echo.getpostman.com/post\",\n" +
                "          \"method\": \"POST\",\n" +
                "          \"header\": [],\n" +
                "          \"body\": {\n" +
                "            \"mode\": \"formdata\",\n" +
                "            \"formdata\": []\n" +
                "          },\n" +
                "          \"description\": \"This is the sample POST Request\"\n" +
                "        },\n" +
                "        \"response\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
    public String UpdateCollectionInValidPayload(String CollectionName){
        return "{\n" +
                "  \"collection\": {\n" +
                "    \"variables\": [],\n" +
                "    \"info\": {\n" +
                "      \"name\": \""+CollectionName+"\",\n" +
                "      \"_postman_id\": \"1d3daef4-2037-4584-ab86-bafd8c8f8a55\",\n" +
                "      \"description\": \"This is just a sample collection.\",\n" +
                "      \"schema\": \"https://schema.getpostman.com/json/collection/v2.0.0/collection.json\"\n" +
                "    },\n" +
                "    \"tem\": [\n" +
                "      {\n" +
                "        \"name\": \"Sample GET Request\",\n" +
                "        \"request\": {\n" +
                "          \"url\": \"echo.getpostman.com/get\",\n" +
                "          \"method\": \"GET\",\n" +
                "          \"header\": [],\n" +
                "          \"body\": {\n" +
                "            \"mode\": \"formdata\",\n" +
                "            \"formdata\": []\n" +
                "          },\n" +
                "          \"description\": \"This is a sample GET Request\"\n" +
                "        },\n" +
                "        \"response\": []\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Sample POST Request\",\n" +
                "        \"request\": {\n" +
                "          \"url\": \"echo.getpostman.com/post\",\n" +
                "          \"method\": \"POST\",\n" +
                "          \"header\": [],\n" +
                "          \"body\": {\n" +
                "            \"mode\": \"formdata\",\n" +
                "            \"formdata\": []\n" +
                "          },\n" +
                "          \"description\": \"This is the sample POST Request\"\n" +
                "        },\n" +
                "        \"response\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
}
