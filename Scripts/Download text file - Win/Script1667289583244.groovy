import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// YOU CAN SEE THE RESULT ON DEBUG.LOG

WebUI.openBrowser('')

WebUI.navigateToUrl('https://getsamplefiles.com/sample-document-files/txt')

WebUI.click(findTestObject('Object Repository/Page_File Samples/a_download file'))

WebUI.delay(15)

String download = System.getProperty("user.home") + File.separator + 'Downloads'

println 'LIST FILE IN Downloads FOLDER - CODE'
CustomKeywords.'test.Utility.listFiles'(download)

println 'FIND FILES IN Downloads FOLDER - COMMAND'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "cmd", "/c", "cd ${download} && dir -s sample.txt"])

println 'READ DOWNLOADED FILE'
CustomKeywords.'test.Utility.readFile'(download + File.separator + 'sample.txt')

String tmp = "C:\\katalon-agent\\tmp"

println 'MOVE FILE TO TEMP FOLDER'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "cmd", "/c", "move ${download + File.separator + 'sample.txt'} ${tmp}"])

println 'READ DOWNLOADED FILE AFTER MOVE'
CustomKeywords.'test.Utility.readFile'(tmp + File.separator + 'sample.txt')