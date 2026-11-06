pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
    stage("build jar file"){
      steps{
        script{
          echo 'building the jar file'
          sh 'mvn package'
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
          echo 'building the docker image'
          withCredentials([usernamePassword(credentialsId:'jenkins-pipeline' , passwordVariable:'PASS', usernameVariable:'USER')]){
            sh 'docker build -t asifhanif01/java-maven-app:jma-1.1 .'
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh 'docker push asifhanif01/java-maven-app:jma-1.1'
          }
          
        }
        
      }
    }
    stage("test"){
      steps{
        echo 'testing the application'
      }
    }
    stage("deploy"){
      steps{
        echo 'deploying the application'
      }
    }
  }
}
