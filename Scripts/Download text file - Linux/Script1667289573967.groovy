import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// YOU CAN SEE THE RESULT ON DEBUG.LOG

WebUI.openBrowser('')

WebUI.navigateToUrl('http://the-internet.herokuapp.com/download')

WebUI.click(findTestObject('Object Repository/Page_The Internet/a_test.txt'))

WebUI.delay(10)

String download = System.getProperty("user.home") + File.separator + 'Downloads'

println 'LIST FILE IN Downloads FOLDER - COMMAND'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "/bin/sh", "-c", "cd ${download}; ls"])

println('READ DOWNLOADED FILE')
CustomKeywords.'test.Utility.readFile'("${download}${File.separator}test.txt")

println('MOVE FILE TO TEMP FOLDER');
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "/bin/sh", "-c", "mv ${download}${File.separator}test.txt /tmp; cd /tmp; ls"])

println('READ FILE AFTER MOVE FILE')
CustomKeywords.'test.Utility.readFile'("/tmp${File.separator}test.txt")
