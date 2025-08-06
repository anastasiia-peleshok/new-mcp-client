# MCP Client Application

This is a Spring Boot application that acts as a client for the Model Context Protocol (MCP), leveraging Spring AI to interact with a large language model (LLM), such as OpenAI. It provides REST API endpoints for both streaming and non-streaming interactions with the LLM.

## Features

*   **LLM Integration**: Seamlessly integrates with large language models via Spring AI's `ChatClient`.
*   **Streaming API**: Provides an endpoint for real-time, streaming responses from the LLM, suitable for chatbot-like interactions.
*   **Non-Streaming API**: Offers a standard endpoint for single, complete responses from the LLM.
*   **Environment Variable Configuration**: Securely loads API keys from a `.env` file.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

*   Java 17 or higher
*   Maven 3.x
*   An OpenAI API Key (or a key for another supported LLM)

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/new-mcp-client.git
    cd new-mcp-client
    ```
2.  **Create a `.env` file:**
    Create a file named `.env` in the root directory of the project and add your OpenAI API key:
    ```
    OPENAI_KEY=your_openai_api_key_here
    ```
    Replace `your_openai_api_key_here` with your actual OpenAI API key.

### Running the Application

You can run the application using Maven:

```bash
./mvnw spring-boot:run
```

The application will start on port `8080` by default.

## Usage

The application exposes the following REST API endpoints:

### 1. Streamed Response

*   **Endpoint:** `POST /askStream`
*   **Content Type:** `text/event-stream`
*   **Description:** Sends a user input to the LLM and receives a streamed response. Useful for real-time updates.
*   **Parameters:**
    *   `userInput` (String, Required): The question or prompt to send to the LLM.

**Example using `curl`:**

```bash
curl -X POST "http://localhost:8080/askStream?userInput=Add new book Clean Code?" -H "Content-Type: application/x-www-form-urlencoded"
```

### 2. Single Response

*   **Endpoint:** `POST /ask`
*   **Content Type:** `application/json` (or `text/plain`)
*   **Description:** Sends a user input to the LLM and receives a single, complete response.
*   **Parameters:**
    *   `userInput` (String, Required): The question or prompt to send to the LLM.

**Example using `curl`:**

```bash
curl -X POST "http://localhost:8080/ask?userInput=Add new book Clean Code." -H "Content-Type: application/x-www-form-urlencoded"
```

## Configuration

The application requires an `OPENAI_KEY` environment variable to be set. This is loaded from a `.env` file at the root of the project.

```
OPENAI_KEY=your_openai_api_key_here
``` 