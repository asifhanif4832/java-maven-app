#!/user/bin/env groovy
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
         buildImage()
          }
          
        }
        
      }
  }
}

