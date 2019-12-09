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
              
                    sh 'mvn clean compile'
               
            }
        }

        stage ('Testing Stage') {

            steps {
            
                    sh 'mvn test'
              
            }
        }


        stage ('Packaging Stage') {
            steps {
               
                    sh 'mvn clean package'
             
            }
        }
    }
}
