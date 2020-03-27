#!groovy

pipeline {
   agent any

    stages{
       /* stage('Pull Source') {
            steps {
                git url: 'https://github.com/ahmedeldeeb25/spring-cloud.git/', branch: 'master'
            }
        }*/
        stage("Build"){
            steps{
                echo "start of build stage for main Microservice"
                sh "mvn -f ./main clean install "
            }
        }
        stage("Build Docker images"){
            steps{
                echo "start of build Docker images stage"
                sh "docker-compose build"
            }
        }
    }
}
