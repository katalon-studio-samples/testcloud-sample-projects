import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// YOU CAN SEE THE RESULT ON DEBUG.LOG

WebUI.openBrowser('')

WebUI.navigateToUrl('http://the-internet.herokuapp.com/download')

WebUI.click(findTestObject('Object Repository/Page_The Internet/FileUpload.txt'))

WebUI.delay(10)

String download = System.getProperty("user.home") + File.separator + 'Downloads'

println 'LIST FILE IN Downloads FOLDER - CODE'
CustomKeywords.'test.Utility.listFiles'(download)

println 'FIND FILES IN Downloads FOLDER - COMMAND'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "cmd", "/c", "cd ${download} && dir -s test.txt"])

println 'READ DOWNLOADED FILE'
CustomKeywords.'test.Utility.readFile'(download + File.separator + 'test.txt')

String tmp = "C:\\katalon-agent\\tmp"

println 'MOVE FILE TO TEMP FOLDER'
CustomKeywords.'test.Utility.executeCommand'((String[]) [ "cmd", "/c", "move ${download + File.separator + 'test.txt'} ${tmp}"])

println 'READ DOWNLOADED FILE AFTER MOVE'
CustomKeywords.'test.Utility.readFile'(tmp + File.separator + 'test.txt')