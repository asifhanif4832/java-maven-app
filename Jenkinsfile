#!/user/bin/env groovy
@Library("jenkins-shared-library")
def gv
pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
     stage("init"){
      steps{
        script{
        gv=load 'script.groovy'
        }
        
      }
    }
    stage("build jar file"){
      when{
    expression{
      BRANCH_NAME=="jenkins-shared-lib"
    }
  }
      steps{
        script{
       buildJar()
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
         buildImage 'asifhanif01/java-maven-app:jma-1.7'
         dockerLogin()
         dockerPush 'asifhanif01/java-maven-app:jma-1.7'
          }
          
        }
        
      }
    stage("deploy the image"){
      steps{
        script{
          def dockerCMD='docker run -d -p 8080:8080 asifhanif01/java-maven-app:jma-1.7'
          sshagent(credentials: ['ec2-server-key'], executable: '') {
          sh "ssh -o StrictHostKeyChecking=no ec2-user@16.178.244.173 ${dockerCMD}"
          
}
          }
          
        }
        
      }
  }
}

