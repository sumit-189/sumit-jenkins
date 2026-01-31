pipeline {
    agent any

    stages {
        stage('git-pull') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('built-stage') {
            steps {
                sh '/opt/maven/bin/mvn clean package'

            }
        }
        stage('test-stage') {
            steps {
                sh '''mvn clean verify  sonar:sonar \\
                 -Dsonar.projectKey=my-project \\
                  -Dsonar.host.url=http://172.31.33.233:9000 \\
                  -Dsonar.login=a30da74f07576363909e98591c0311f998ff42cb'''
            }
        }
        stage('deploy-stage') {
            steps {
                echo 'code-deploy successfully'
            }
        }
    }
}
