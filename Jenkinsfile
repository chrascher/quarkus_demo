pipeline {
    agent any

    tools {
        maven 'maven_3.6.3'
        jdk 'java11'
    }

    stages {
        stage('Introduction and Pre Checks') {
            steps {
                echo 'This is a minimal pipeline.'
                script {
                    sh 'df -h'
                    sh 'java -version'
                }
            }
        }

        stage('Build Project') {
            steps {
                echo 'This is the build step'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Build and Unit Test') {
            steps {
                echo "Build and Unit Test"
                sh "mvn -B -nsu clean install"
            }
            post {
                always {
                    junit "**/surefire-reports/*.xml"
                }
            }
        }
        stage('Build quarkus container image') {
            steps {
                echo "Build and Unit Test"
                sh "mvn -B clean package package -Dquarkus.container-image.build=true -DskipTests=true"
            }
            post {
                always {
                    junit "**/surefire-reports/*.xml"
                }
            }
        }


    }
    post {
        failure {
            echo "Build POST  FAILURE action "
        }
        always {
            echo "Build POST action"
        }
    }
}
