pipeline {
    agent any

    stages {
    
    	stage('Git Checkout'){
            steps{
    		    git 'https://github.com/sibsankarb4/Jenkinsfile-openshift-example'
             }
    	}
    	
        stage ('Compile Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Packaging Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean install package'
                }
            }
        }
    }
}
