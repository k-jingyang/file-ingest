## FileIngest
Spring Batch application to parse a file, and populate the data into a database. 

This application will be containerised using Jib and deployed on Kubernetes as a CronJob

### Technology
This project is to experiment with
- Kotlin
- jOOQ 
    - MyBatis implementation included, which is to replace jOOQ in actual deployment
- GitLab CI/CD