pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }

        stage('Build & Test & Coverage') {
            steps {
                dir('Maven') {
                    sh 'mvn -B clean verify'
                }
            }
            post {
                always {
                    junit 'Maven/target/surefire-reports/*.xml'
                }
                success {
                    recordCoverage(
                            tools: [jacoco(pattern: 'Maven/target/site/jacoco/jacoco.xml')]
                    )
                }
            }
        }
        stage('Test') {
            steps{
                bat 'mvn test'
            }
            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
        stage('Package') {
            steps {
                dir('Maven') {
                    sh 'mvn -B -DskipTests package'
                }
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'Maven/target/*.jar', fingerprint: true
        }
    }
}