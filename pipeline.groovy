pipeline {
    agent any

    stages {
        stage('git-pull') {
            steps {
                git branch: 'main', url: 'https://github.com/sumit-189/student-ui-app.git'
            }
        }
        stage('built-stage') {
            steps {
                sh 'mvn clean package '
            }
        }
        stage('test-stage') {
            steps {
                echo 'code-test successfully'
            }
        }
        stage('deploy-stage') {
            steps {
                echo 'code-deploy successfully'
            }
        }
    }
}
