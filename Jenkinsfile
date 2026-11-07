#!/user/bin/env groovy
@Library("jenkins-shared-library")_

pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
    //  stage("init"){
    //   steps{
    //     script{
    //     gv=load 'script.groovy'
    //     }
        
    //   }
    // }
    stage("build jar file"){
      when{
    expression{
      BRANCH_NAME=="new"
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
         buildImage 'asifhanif01/java-maven-app:jma-1.3'
          }
          
        }
        
      }
  }
}

