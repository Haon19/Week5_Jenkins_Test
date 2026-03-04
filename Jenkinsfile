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