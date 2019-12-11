pipeline {
    agent any

	
	stages {    
	stage("Env Variables") {
            steps {
                sh 'export PATH=$PATH:usr/local/apache-maven/apache-maven-3.0.5/bin:/usr/bin/oc'
            }
        }
	    
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
    
     		
   stage('OC Create Image Builder') {
      when {
        expression {
          openshift.withCluster() {
            return !openshift.selector("bc", "Jenkinsfile-openshift-example").exists();
          }
        }
      }
      steps {
        script {
          openshift.withCluster() {
            openshift.newBuild("--name=Jenkinsfile-openshift-example", "--image-stream=redhat-openjdk18-openshift:1.1", "--binary")
          }
        }
      }
    }	
	
 }
}
