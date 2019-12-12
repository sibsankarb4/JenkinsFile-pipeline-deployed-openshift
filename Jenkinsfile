pipeline {
    agent any

 environment {
    APPLICATION_NAME = 'spring-openshift'
    GIT_REPO="https://github.com/sibsankarb4/Jenkinsfile-openshift-example.git"
    GIT_BRANCH="master"
    STAGE_TAG = "promoteToQA"
    DEV_PROJECT = "sibsber1-23934"
    STAGE_PROJECT = "stage"
    TEMPLATE_NAME = "spring-openshift"
    ARTIFACT_FOLDER = "target"
    PORT = 8081;
}

    stages {
    
    	stage('Git Checkout'){
            steps{
    		    git branch: "${GIT_BRANCH}", url: "${GIT_REPO}"
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
                    sh 'mvn clean package'
                }
            }
        }
    
  
  stage('Create Image Builder') {
    when {
        expression {
            openshift.withCluster() {
            openshift.withProject(DEV_PROJECT) {
                return !openshift.selector("bc", "${TEMPLATE_NAME}").exists();
                }
            }
        }
    }
    steps {
        script {
            openshift.withCluster() {
                openshift.withProject(DEV_PROJECT) {
                    openshift.newBuild("--name=${TEMPLATE_NAME}", "--docker-image=docker.io/openjdk:8", "--binary=true")
                }
            }
        }
    }
}
  
	
 }
}
