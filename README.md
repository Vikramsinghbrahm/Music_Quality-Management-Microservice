# Music Quality Management Microservice

## Overview

This repository contains a microservice designed for a music streaming platform. The microservice manages user-specific quality settings based on their subscription levels: free, premium, or VIP. The key parameters are 'minBitrate' and 'maxBitrate' representing the minimum and maximum allowed bitrates for music files.

## Project Structure

### 1. QualitySettings Class

The `QualitySettings` class holds the user-specific quality settings with 'minBitrate' and 'maxBitrate' attributes.

### 2. QualityConfiguration Class

The `QualityConfiguration` class, annotated with `@ConfigurationProperties`, manages default 'minBitrate' and 'maxBitrate' values.

### 3. QualityController Class

The `QualityController` class, a Rest Controller, provides a GET endpoint ("/qualitysettings") to retrieve user-specific quality settings.

### 4. application.properties (or application.yml)

The properties file (`application.properties` or `application.yml`) specifies default 'minBitrate' and 'maxBitrate' values.

## How to Use

Provide instructions on how users can utilize the microservice. Include details on how to set it up and integrate it into their projects.

## Contribution

If you want to contribute to this project, follow the guidelines below:

1. Fork the repository
2. Create a new branch for your feature
3. Commit your changes
4. Push to the branch
5. Submit a pull request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
