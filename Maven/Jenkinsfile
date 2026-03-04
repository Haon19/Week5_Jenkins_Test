pipeline {
    agent any
    tools { maven 'Maven3'; jdk 'JDK17' }

    stages {
        stage('Checkout') { steps { checkout scm } }

        stage('Build & Test & Coverage') {
            steps {
                dir('Maven') {
                    // Generates surefire XML + jacoco.xml (because 'report' is bound to verify)
                    sh 'mvn -B clean verify'
                }
            }
            post {
                always {
                    // Publish JUnit results for the "Test Result" link
                    junit 'Maven/target/surefire-reports/*.xml'
                }
                success {
                    // Publish code coverage for the "Coverage" link
                    publishCoverage adapters: [
                            jacocoAdapter('Maven/target/site/jacoco/jacoco.xml')
                    ], sourceCodeRetention: 'ARCHIVE', failNoReports: true
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
    }

    post {
        always {
            archiveArtifacts artifacts: 'Maven/target/*.jar', fingerprint: true
        }
    }
}
