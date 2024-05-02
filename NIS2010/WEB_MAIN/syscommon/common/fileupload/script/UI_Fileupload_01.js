var uploadObjects = new Array(); 
var uploadCnt=0;

document.onclick = processButtonClick

/**
 * It sets a Upload Object.
 * @param uploadObj
 * @return
 */
function setUploadObject(uploadObj){
	uploadObjects[uploadCnt++] = uploadObj;
}

/**
 * It loads a Upload Object.
 * @return
 */
function loadPage(){
	for(var i=0;i<uploadObjects.length;i++){
		popupConfigUpload(uploadObjects[i],"/hanjin/FileUpload.do");
	}	
}

/**
 * It configures a popup Upload.
 * @param uploadObj
 * @param sPageUrl
 * @return
 */
function popupConfigUpload(uploadObj, sPageUrl){
	
	var comFileMaxCount = document.getElementById("comFileMaxCount").value;
//	if(document.form.usrFileCnt.value != "") comFileMaxCount = document.form.usrFileCnt.value;
	
	
	var maxFileSize = document.getElementById("maxFileSize").value/1000;
	
    try {
    	ComConfigUpload(uploadObj, sPageUrl);
		uploadObj.ViewIcon("DETAIL");
		
		uploadObj.SetLimit(comFileMaxCount, maxFileSize, maxFileSize);
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 * @return
 */
function processButtonClick(){ 
	
	var srcName = window.event.srcElement.getAttribute("name"); 
	switch(srcName) {  
		case "btn2_Upload_File": 
			doActionUpload();
			break;
		case "btn2_Add_File":
			addFile();
			break;
	}
}

/**
 * It uploads a file.
 * @param sAction
 * @return
 */
function doActionUpload(sAction){
	
	var upObj = uploadObjects[0];
	if(document.form.usrFileCnt.value != ''){
		if(upObj.FileCount > parseInt(document.form.usrFileCnt.value)){
			alert("The number of files that can be uploaded is " + document.form.usrFileCnt.value);
			return;
		}
	}
	
	upObj.ParamDecoding = true;
	upObj.ParamUTF8 = true;
	
	upObj.ExtendParam = FormQueryStringEnc(document.form, upObj);
	var sXml = upObj.DoUpload(true);
	var etcValue = ComGetEtcData(sXml, "KEYS");
	if(etcValue != undefined){
		if(document.getElementById("flag").value == "1"){
			window.returnValue = etcValue+"<>"+upObj.LocalFiles;
		} else{
			window.returnValue = etcValue;
		}
	} else{
		window.returnValue = sXml;
	}
	window.close();
}

/**
 * It adds a file to IBUpload.
 * @return
 */
function addFile(){
	var upObj = uploadObjects[0];
	upObj.AddFile();
}
