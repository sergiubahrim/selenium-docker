pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat instead of sh for windows
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {

                sh "docker build -t='sergiubahrim/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {

			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push sergiubahrim/selenium-docker:latest"
			    }
            }
        }
    }
}