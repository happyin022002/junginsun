var userFileCnt=0; //사용자 파일 Cnt
var userAllFileAttachSize=0 //사용자 첨부 파일 총 크기.
var uploadObjects = new Array(); 
var uploadCnt=0;
function checkData(){
	if(document.getElementsByName("com_from")[0].value == ""){
		alert("Please Insert a from");
		return false;
	}
	if(document.getElementsByName("com_recipient")[0].value == ""){
		alert("Please Insert a recipient");
		return false;
	}
	if(document.getElementsByName("com_subject")[0].value == ""){
		alert("Please Insert a subject");
		return false;
	}
	return true;
}

function doMail(){
	for (var instanceName in CKEDITOR.instances) {
		CKEDITOR.instances[instanceName].updateElement();
	}

	if(checkData()){
		setReportFileThatWillAttachMail();
		setPreFileInfoThatWillAttachMail();
		doActionUpload();
	}
}

//끝에 있는 세미콜론 제거
function deleteEndSemicolon(sentence){
	if(sentence.length > 0){
		sentence = sentence.substr(0,sentence.length-1);
	}
	return sentence;
}

//Report 첨부 파일을 첨부한다.
function setReportFileThatWillAttachMail(){
	var reportForLoop = document.getElementsByName("com_reportForLoop");
	var aliveReportCheckBox = "";
	for(var i=0;i < reportForLoop.length;i++){
		var chkBoxStatus = document.getElementById("reportFileCheckBox"+i).status;
		if(chkBoxStatus == true){
			aliveReportCheckBox = aliveReportCheckBox+i+";";
		}
	}

	aliveReportCheckBox = deleteEndSemicolon(aliveReportCheckBox);
	
	var arrayAliveReportCheckBox = aliveReportCheckBox.split(";");

	//체크된 것들의 순서를 읽어서 해당 mrd 정보를 매핑한다.
	var arrayLineTemplateMrd = "";
	var arrayLineTemplateMrdArguments = "";
	var arrayLineExportFileName = "";
	var arrayLineExportFileType = "";
	for(var i=0;i < arrayAliveReportCheckBox.length;i++){
		var chkIdx = arrayAliveReportCheckBox[i];
		var mrdValue = document.getElementById("com_mrdPath"+chkIdx).value;
		arrayLineTemplateMrd = arrayLineTemplateMrd + mrdValue+";";
		var mrdParamValue = document.getElementById("com_mrdArguments"+chkIdx).value;
		arrayLineTemplateMrdArguments = arrayLineTemplateMrdArguments + mrdParamValue+";";
		var rdExportFileName = document.getElementById("com_rdExportFileName"+chkIdx).value;
		arrayLineExportFileName = arrayLineExportFileName + rdExportFileName+";";
		var rdExportFileType = document.getElementById("com_rdExportFileType"+chkIdx).value;
		arrayLineExportFileType = arrayLineExportFileType + rdExportFileType+";";
	}
	
	document.getElementById("com_templateMrd").value = arrayLineTemplateMrd;
	document.getElementById("com_templateMrdArguments").value = arrayLineTemplateMrdArguments;
	document.getElementById("com_rdExportFileName").value = arrayLineExportFileName;
	document.getElementById("com_rdExportFileType").value = arrayLineExportFileType;
}

//프로그램에서 미리 정의한 사용자 첨부 파일을 메일에 첨부한다.
function setPreFileInfoThatWillAttachMail(){
	var preFileForLoop = document.getElementById("com_PreFileForLoop").value;
	if(preFileForLoop == "" || preFileForLoop == " "){
		return;
	}
	preFileForLoop = preFileForLoop.substring(0, preFileForLoop.length-1);
	var arrayFileLoop = preFileForLoop.split(";");
	var preFullFileKeys = "";
	for(var i=0;i < arrayFileLoop.length;i++){
		var preFileIndex = arrayFileLoop[i];
		var preFileKey = document.getElementById("fileInfoObj"+preFileIndex).value;
		preFullFileKeys = preFullFileKeys + preFileKey;
		preFullFileKeys = preFullFileKeys + ";";		
	}
	document.getElementById("com_fileKey").value = preFullFileKeys;
}

function checkKey(mailKey){
	if(mailKey==undefined){
		mailKey = document.getElementById("com_mailKey").value;
	}
	var parentMailKeyFlag = document.getElementById("com_mailKeyFlag");
	if(parentMailKeyFlag == "[object]" && mailKey != "" && mailKey != "null" && mailKey != "undefined" && mailKey != " "){
		if(parentMailKeyFlag.value =="true"){
			parent.comMailKeyReturn(mailKey);
			parent.mailClose();
		} else {
			parent.mailClose();
		}
	} else if(mailKey != "" && mailKey != "null" && mailKey != "undefined" && mailKey != " "){
		parent.mailClose();
	}
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick()
 {
    var formObject = document.form;
 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

 		if(srcName==null) return false;

		switch(srcName) 
		{
			case "btn_Attach":
				addFile();
				break;
			case "btn_Close":
				parent.mailClose();
				break;
			} // end switch

		if(srcName.length > 11 && srcName.substring(0, 11)=="btn_Delete_"){
			var idx = srcName.substring(11);
			var fileItem = document.getElementById("fileItem");

			var trs = fileItem.rows;
			for(var i=0; i<trs.length; i++){
				if(trs[i].id == "tr_" + idx){
					fileItem.deleteRow(i);
					break;
				}
			}
		} 
		
 	}catch(e) {
 		alert(e.message);
 	}
 }

 //업로드 Object 에 파일을 첨부한다.
function addFile(){
	var upObj = uploadObjects[0];
	var fileLocation = upObj.AddFile();
	var fileSize = upObj.GetFileSize(fileLocation);
	
	//파일 중복 업로드 체크
	for(var i=0;i<userFileCnt;i++){
		var userFileLoc = document.getElementById("userFileFullLocation"+i).value;
		if(fileLocation == userFileLoc){
			return;
		}
	}
	
	//파일 선택 안했을 경우 체크
	if(fileLocation == "" || fileLocation == " "){
		return
	}
	
	//파일하나의 사이즈 제한.
	if(fileSize > 5000000){		
		alert("File isn't over the size of 5MB ["+fileSize+"]");
		return;
	}
	
	userAllFileAttachSize = userAllFileAttachSize+fileSize;
	
	//총 파일의 사이즈 제한.
	if(userAllFileAttachSize > 5000000){
		alert("Sum of Attached File isn't over the size of 5MB ["+userAllFileAttachSize+"]");
		userAllFileAttachSize = userAllFileAttachSize-userAllFileAttachSize;
		return;
	}
	
	var arrFileLoction = fileLocation.lastIndexOf("\\");
	var fileName = fileLocation.substring(arrFileLoction+1);
	var userFileDelButton = document.createElement("<input type=\"button\" name=\"userFileDelButton"+userFileCnt+"\" value=\"Del\" onclick=deleteUserAttachFile("+userFileCnt+")>"); 
	document.getElementById("userAttachFile").insertBefore(userFileDelButton);
	var fileButton = document.createElement("<input type=\"button\" name=\"userFileButton"+userFileCnt+"\" value=\""+fileName+"\" >"); 
	document.getElementById("userAttachFile").insertBefore(fileButton);
	var fileFullLocation = document.createElement("<input type=\"hidden\" name=\"userFileFullLocation"+userFileCnt+"\" value=\""+fileLocation+"\" >"); 
	document.getElementById("userAttachFile").insertBefore(fileFullLocation);
	
	userFileCnt = userFileCnt+1;
}

//레포트를 미리보기 할때 특정 레포트의 값을 설정한다.
function setReportMeta(idx){
	document.getElementById("com_mrdPath").value = document.getElementById("com_mrdPath"+idx).value;
	document.getElementById("com_mrdArguments").value = document.getElementById("com_mrdArguments"+idx).value;
}

//체크 박스에 따라 pdf 첨부 파일 버튼을 활성화 하거나 비활성화 한다.
function changeStatusReportFileButton(idx){
	var chkBoxStatus = document.getElementById("reportFileCheckBox"+idx).status;
	if(chkBoxStatus == true){
		 document.getElementById("reportFileButton"+idx).disabled = false;
	} else{
		 document.getElementById("reportFileButton"+idx).disabled = true;
	}
}

//선택한 사용자 첨부 파일을 삭제한다.
function deleteUserAttachFile(idx){
	
	var parentNode = document.getElementById("userAttachFile");
	var toRemoveFileButton = document.getElementById("userFileButton"+idx);
	var toRemoveDelButton = document.getElementById("userFileDelButton"+idx);
	var toRemoveFileFullLocation = document.getElementById("userFileFullLocation"+idx).value;
	parentNode.removeChild(toRemoveFileButton);
	parentNode.removeChild(toRemoveDelButton);
	
	var upObj = uploadObjects[0];
	upObj.DeleteFile(toRemoveFileFullLocation);
	var toRemoveFileSize = upObj.GetFileSize(toRemoveFileFullLocation);
	userAllFileAttachSize = userAllFileAttachSize-toRemoveFileSize;
}

/**
 * It sets a Upload Object.
 * @param uploadObj
 * @return
 */
function setUploadObject(uploadObj){
	uploadObjects[uploadCnt++] = uploadObj;
	loadPage();
}

/**
 * It loads a Upload Object.
 * @return
 */
function loadPage(){
	for(var i=0;i<uploadObjects.length;i++){
		popupConfigUpload(uploadObjects[i],"/hanjin/MailGS.do");
	}	
}


/**
 * It configures a popup Upload.
 * @param uploadObj
 * @param sPageUrl
 * @return
 */
function popupConfigUpload(uploadObj, sPageUrl){	
    try {
    	ComConfigUpload(uploadObj, sPageUrl);
		uploadObj.SetLimit(100, 5000, 5000);
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * It uploads a file.
 * @param sAction
 * @return
 */
function doActionUpload(){
	var upObj = uploadObjects[0];

	upObj.ParamDecoding = true;
	upObj.ParamUTF8 = true;
	upObj.ExtendParam = FormQueryStringEnc(document.formMail, upObj);
	if(upObj.FileCount == 0){
    	formMail.method = "post";
    	formMail.action = "/hanjin/Mail.do";
		formMail.submit();
	} else{
		var sXml = upObj.DoUpload(true);
		var etcValue = ComGetEtcData(sXml, "mailKey");
		checkKey(etcValue);
	}
}

/**
 * Delete a pre user File Object.
 * @param idx
 * @return
 */
function deletePreFileInfo(idx){
	var parentNode = document.getElementById("userAttachFile");
	var toRemoveInfoDelButton = document.getElementById("fileInfoDelButton"+idx);
	var toRemoveInfoButton = document.getElementById("fileInfo"+idx);
	var toRemoveInfoObject = document.getElementById("fileInfoObj"+idx);
	parentNode.removeChild(toRemoveInfoDelButton);
	parentNode.removeChild(toRemoveInfoButton);
	parentNode.removeChild(toRemoveInfoObject);	
	var preFileForLoop = document.getElementById("com_PreFileForLoop").value;
	var toDeleteIndex = preFileForLoop.indexOf(idx)
	document.getElementById("com_PreFileForLoop").value =preFileForLoop.substring(0,toDeleteIndex)+preFileForLoop.substring(toDeleteIndex+2);
}
