def call() {
    node('workstation') {

        if (env.cibuild == "java") {
            stage('Build') {
                sh 'mvn package'
            }
        }

        stage('Unit tests') {
            echo 'unit tests'
            sh 'ls -ltr'
        }

        stage('Code Analysis') {
            echo 'sonar'
            // sh 'sonar-scanner -Dsonar.host.url=http://172.31.83.175:9000 -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.projectKey=frontend -Dsonar.qualitygate.wait=true'
        }

        stage('Security Scans') {
            echo 'Security Scans'
        }

        if (env.TAG_NAME ==~ ".*") {
            stage('Publish a Artifact') {
                echo 'Publish a Artifact'
            }
        }
    }
}
