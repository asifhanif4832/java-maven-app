// #!/user/bin/env groovy
// @Library("jenkins-shared-library")_
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
    stage ("incrementing the jar file"){
      steps{
        script{
          echo "incrementing the iamge"
          sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit'
          def matcher=readFile('pom.xml')=~ '<version>(.+)</version>'
          def version=matcher[0][1]
          env.Image_Name="${version}-${env.BUILD_NUMBER}"
           }
      }
    }
    stage("build jar file"){
      steps{
        script{
        echo 'building the image'
          sh 'mvn clean package'
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
          withCredentials([usernamePassword(credentialsId:'jenkins-pipeline', passwordVariable:'PASS', usernameVariable:'USER')]){
            sh "docker build -t asifhanif01/java-maven-app:${env.Image_Name} ."
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh "docker push asifhanif01/java-maven-app:${env.Image_Name}"
          }
          
        }
        
      }
  }
}
}
