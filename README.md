<img width="1216" height="1003" alt="Screenshot 2025-12-27 at 5 18 37 PM" src="https://github.com/user-attachments/assets/9c58b311-ed02-410d-8077-c186e4f15835" /># Java gRPC Examples

A comprehensive collection of gRPC examples in Java demonstrating both simple and advanced gRPC patterns including unary, server streaming, client streaming, bidirectional streaming, interceptors, and deadlines.

## 🚀 Features

- **Calculator Service**: Simple arithmetic operations demonstrating unary RPC calls
- **Greeting Service**: Advanced patterns including:
  - Unary RPC
  - Server streaming
  - Client streaming  
  - Bidirectional streaming
  - Custom interceptors (logging, header validation)
  - Deadline handling
- **Protocol Buffers**: Type-safe service definitions
- **Interceptors**: Request/response logging and header validation
- **Error Handling**: Proper exception handling and timeout management

## 📋 Prerequisites

- **Java**: JDK 17 or higher
- **Maven**: 3.6+ 
- **Protocol Buffers**: Automatically handled by Maven plugin

## 🛠️ Setup

1. Clone the repository:
```bash
git clone <your-repo-url>
cd java-grpc-emaples
```

2. Compile the project:
```bash
mvn clean compile -s settings.xml
```

This will:
- Download all dependencies
- Generate Java classes from `.proto` files
- Compile the source code

## 🎯 Running the Examples

### Calculator Service

The Calculator service demonstrates basic unary RPC calls for arithmetic operations.

**Start the Calculator Server** (Terminal 1):
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="calculator.server.CalculatorServer"
```

Server will start on port **50052**.

**Run the Calculator Client** (Terminal 2):
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="calculator.client.CalculatorClient" -Dexec.args="add 10 20"
```

Expected output:
```
Calling add operation...
10 + 20 = 30
Shutting down channel...
```

### Greeting Service

The Greeting service demonstrates various gRPC patterns.

**Start the Greeting Server** (Terminal 1):
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.server.GreetingServer"
```

Server will start on port **50051**.

**Run Greeting Client Operations** (Terminal 2):

- **Simple unary call:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet"
```

- **Server streaming:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_many_times"
```

- **Client streaming:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_long"
```

- **Bidirectional streaming:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_everyone"
```

- **With deadline:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_with_deadline"
```

## 📁 Project Structure

```
java-grpc-emaples/
├── src/main/
│   ├── java/
│   │   ├── calculator/
│   │   │   ├── client/
│   │   │   │   └── CalculatorClient.java
│   │   │   └── server/
│   │   │       ├── CalculatorServer.java
│   │   │       └── CalculatorServiceImpl.java
│   │   ├── greeting/
│   │   │   ├── client/
│   │   │   │   ├── GreetingClient.java
│   │   │   │   ├── AddHeaderInterceptor.java
│   │   │   │   └── LogInterceptor.java
│   │   │   └── server/
│   │   │       ├── GreetingServer.java
│   │   │       ├── GreetingServiceImpl.java
│   │   │       ├── HeaderCheckInterceptor.java
│   │   │       └── LogInterceptor.java
│   │   └── utils/
│   │       └── Sleeper.java
│   └── proto/
│       ├── calculator/
│       │   └── calculator.proto
│       └── greeting/
│           └── greeting.proto
├── pom.xml
├── settings.xml
└── README.md
```

## 🔧 Technologies Used

- **Java 17**: Programming language
- **gRPC 1.77.0**: RPC framework
- **Protocol Buffers 3.25.8**: Serialization format
- **Maven**: Build tool
- **Guava**: Google's core libraries for Java

## 📝 Protocol Buffer Definitions

### Calculator Service
```protobuf
service CalculatorService {
  rpc Add(CalculatorRequest) returns (CalculatorResponse);
}
```

### Greeting Service  
```protobuf
service GreetingService {
  rpc Greet(GreetingRequest) returns (GreetingResponse);
  rpc GreetManyTimes(GreetingRequest) returns (stream GreetingResponse);
  rpc LongGreet(stream GreetingRequest) returns (GreetingResponse);
  rpc GreetEveryone(stream GreetingRequest) returns (stream GreetingResponse);
}
```

## 🎓 Learning Resources

This project demonstrates:
- **Unary RPC**: Single request, single response
- **Server Streaming RPC**: Single request, stream of responses
- **Client Streaming RPC**: Stream of requests, single response
- **Bidirectional Streaming RPC**: Stream of requests and responses
- **Interceptors**: Cross-cutting concerns like logging and authentication
- **Deadlines**: Timeout handling for RPC calls

## 🐛 Troubleshooting

**Issue: Port already in use**
```bash
# Find and kill the process using the port
lsof -ti:50051 | xargs kill -9  # For Greeting server
lsof -ti:50052 | xargs kill -9  # For Calculator server
```

**Issue: Proto files not generating**
```bash
# Explicitly generate proto files
mvn clean protobuf:compile protobuf:compile-custom -s settings.xml
```

**Issue: Compilation errors**
```bash
# Clean rebuild
mvn clean install -s settings.xml
```

## 📄 License

This project is available for educational purposes.

## 🤝 Contributing

Feel free to fork this repository and submit pull requests for any improvements!

---

**Happy gRPC coding! 🚀**

1. **Extension Pack for Java** (`vscjava.vscode-java-pack`)
   - Includes: Java language support, debugging, testing, Maven support
   
2. **Language Support for Java(TM) by Red Hat** (`redhat.java`)
   - IntelliSense, code navigation, refactoring

3. **Debugger for Java** (`vscjava.vscode-java-debug`)
   - Debugging support

4. **Maven for Java** (`vscjava.vscode-maven`)
   - Maven project management

### Install Extensions

```bash
code --install-extension vscjava.vscode-java-pack
code --install-extension redhat.java
```

## Build the Project

Due to your Cisco Maven mirror configuration, use the local settings file:

```bash
mvn clean compile -s settings.xml
```

Or to use your global Maven settings (requires Cisco VPN):

```bash
mvn clean compile
```

## Running the Application

### Option 1: Using VS Code (Recommended)

The project includes launch configurations in `.vscode/launch.json`:

1. **Run gRPC Server**
   - Open Command Palette (Cmd+Shift+P)
   - Select "Run and Debug" or press F5
   - Choose "Run gRPC Server"
   - Server starts on `localhost:50051`

2. **Run gRPC Client**
   - Open a new terminal or debug session
   - Choose "Run gRPC Client"
   - Requires command-line arguments (see below)

### Option 2: Using Maven

**Start the Server:**
```bash
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.server.GreetingServer"
```

**Run the Client:**
```bash
# Simple greeting
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet"

# Server streaming
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_many_times"

# Client streaming
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_long"

# Bidirectional streaming
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_everyone"

# With deadline
mvn exec:java -s settings.xml -Dexec.mainClass="greeting.client.GreetingClient" -Dexec.args="greet_with_deadline"
```

### Option 3: Using Command Line

First, package the application:
```bash
mvn clean package -s settings.xml
```

Then run:
```bash
# Server
java -cp target/classes:target/lib/* greeting.server.GreetingServer

# Client
java -cp target/classes:target/lib/* greeting.client.GreetingClient greet
```

## Available RPC Methods

| Method | Type | Description |
|--------|------|-------------|
| `Greet` | Unary | Simple request-response |
| `GreetManyTimes` | Server Streaming | Server sends multiple responses |
| `LongGreet` | Client Streaming | Client sends multiple requests |
| `GreetEveryone` | Bidirectional Streaming | Both send multiple messages |
| `GreetWithDeadline` | Unary with Deadline | Request with timeout |

## Project Dependencies

```xml
<dependencies>
    <!-- gRPC dependencies -->
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-netty-shaded</artifactId>
        <version>1.77.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-protobuf</artifactId>
        <version>1.77.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-stub</artifactId>
        <version>1.77.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-services</artifactId>
        <version>1.77.0</version>
    </dependency>
    <dependency>
        <groupId>javax.annotation</groupId>
        <artifactId>javax.annotation-api</artifactId>
        <version>1.3.2</version>
    </dependency>
</dependencies>
```

## Maven Plugins

```xml
<!-- OS Maven Plugin - Detects OS for platform-specific binaries -->
<extension>
    <groupId>kr.motd.maven</groupId>
    <artifactId>os-maven-plugin</artifactId>
    <version>1.7.1</version>
</extension>

<!-- Protobuf Maven Plugin - Generates Java code from .proto files -->
<plugin>
    <groupId>org.xolstice.maven.plugins</groupId>
    <artifactId>protobuf-maven-plugin</artifactId>
    <version>0.6.1</version>
</plugin>

<!-- Build Helper Maven Plugin - Adds generated sources to classpath -->
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>3.3.0</version>
</plugin>
```

## Features Implemented

- ✅ Unary RPC
- ✅ Server-side streaming RPC
- ✅ Client-side streaming RPC
- ✅ Bidirectional streaming RPC
- ✅ Deadline/Timeout handling
- ✅ Interceptors (logging, header manipulation)
- ✅ Protocol Buffer reflection service
- ✅ Graceful shutdown

## Troubleshooting

### Maven Repository Issues

If you see errors about `engci-maven-master.cisco.com`:

1. **Use the local settings.xml**: Always add `-s settings.xml` to Maven commands
2. **Connect to Cisco VPN**: If you need to use internal artifacts
3. **Temporarily rename global settings**: `mv ~/.m2/settings.xml ~/.m2/settings.xml.bak`

### Compilation Errors

If you see "invalid target release: 24":
- The project is configured for Java 17
- Make sure your `JAVA_HOME` points to JDK 17 or higher

### gRPC Server Won't Start

- Check if port 50051 is already in use: `lsof -i :50051`
- Kill existing process: `kill -9 <PID>`

### Proto Files Not Generated

Run the protobuf plugin explicitly:
```bash
mvn protobuf:compile protobuf:compile-custom -s settings.xml
```

## Development Tips

1. **Auto-reload in VS Code**: The project is configured with automatic build updates
2. **View generated code**: Check `target/generated-sources/protobuf/`
3. **Debug mode**: Use VS Code's debug configurations with breakpoints
4. **Testing**: Use tools like `grpcurl` for testing the server:
   ```bash
   grpcurl -plaintext localhost:50051 list
   grpcurl -plaintext -d '{"first_name":"Test"}' localhost:50051 greeting.GreetingService/Greet
   ```

## License

This is a sample project for learning gRPC with Java.
## Code Snippet
<img width="1216" height="1003" alt="Screenshot 2025-12-27 at 5 18 37 PM" src="https://github.com/user-attachments/assets/dc5edce3-d290-4ea5-b7b6-c54b15093a48" />

