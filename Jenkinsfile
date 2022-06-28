pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean compile'
            }
        }
        stage ('Test') {
            steps {
                sh './mvnw test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage ('Publish') {
            steps {
                sh './mvnw package'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage ('Install') {
            steps {
                sh './mvnw install'
            }
        }
        /* stage ('Deploy') {
            steps {
                sh './mvnw deploy'
            }
        } */
    }
}