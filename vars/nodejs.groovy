def call() {
    pipeline {
        agent {
            node { label 'workstation' }
        }

        stages {
            stage('Build') {
                steps {
                    sh 'npm install'
                }
            }

            stage('Unit Tests') {
                steps {
                    echo 'Unit Tests'
                    // sh 'npm test'
                }
            }

            stage('Code Analysis') {
                steps {
                    echo 'sonar'
                    // sh 'sudo sonar-scanner -Dsonar.host.url=http://172.31.40.52:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=cart'
                }
            }

            stage('Security Scans') {
                steps {
                    echo 'Security Scans'
                }
            }

            stage('Publish Artifact') {
                when {
                    expression {
                        env.TAG_NAME ==~ ".*"
                    }
                }
                steps {
                    echo 'Publish Artifacts'
                    sh 'env'
                }
            }
        }
    }
}