node {
    echo 'Hello from Pipeline'
	
	stage "Checkout"
	git url: "https://github.com/drighart/template.micro.service"
	
	stage "Build/Analyse/Test"
    sh "./gradle clean build"
    archiveUnitTestResults()
    archiveCheckstyleResults()
}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}

def archiveCheckstyleResults() {
    step([$class: "CheckStylePublisher",
          canComputeNew: false,
          defaultEncoding: "",
          healthy: "",
          pattern: "build/reports/checkstyle/main.xml",
          unHealthy: ""])
}
