pipeline {
    agent any

    stages {
        stage('git-pull') {
            steps {
                git branch: 'main', url: 'https://github.com/sumit-189/Sumit.git'
            }
        }
        stage('built-stage') {
            steps {
                echo "code-build successfully"
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
