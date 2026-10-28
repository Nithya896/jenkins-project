pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/YOUR_USERNAME/jenkins-project.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh '''
                    scp -o StrictHostKeyChecking=no target/jenkins-project-1.0.jar ec2-user@YOUR_EC2_IP:/home/ec2-user/app.jar
                    ssh -o StrictHostKeyChecking=no ec2-user@YOUR_EC2_IP "nohup java -jar app.jar > app.log 2>&1 &"
                    '''
                }
            }
        }
    }
    post {
        success {
            echo 'Build Success - Payment App Deployed to EC2'
        }
    }
}
