import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// YOU CAN SEE THE RESULT ON DEBUG.LOG

WebUI.openBrowser('')

WebUI.navigateToUrl('https://getsamplefiles.com/sample-document-files/txt')

WebUI.click(findTestObject('Object Repository/Page_File Samples/a_download file'))

WebUI.delay(15)

String download = System.getProperty("user.home") + File.separator + 'Downloads'

println 'LIST FILE IN Downloads FOLDER - COMMAND'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "/bin/sh", "-c", "cd ${download}; ls"])

println('READ DOWNLOADED FILE')
CustomKeywords.'test.Utility.readFile'("${download}${File.separator}sample.txt")

println('MOVE FILE TO TEMP FOLDER');
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "/bin/sh", "-c", "mv ${download}${File.separator}sample.txt /tmp; cd /tmp; ls"])

println('READ FILE AFTER MOVE FILE')
CustomKeywords.'test.Utility.readFile'("/tmp${File.separator}sample.txt")
