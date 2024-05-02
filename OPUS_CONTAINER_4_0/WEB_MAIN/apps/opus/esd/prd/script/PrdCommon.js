/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCommon.js
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : noh seung bae
*@LastVersion : 1.0
* 2009.08.12 noh seung bae
* 1.0 Creation
=========================================================*/

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}

// axon_event.addListenerFormat() 용
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

// axon_event.addListenerFormat() 용 dataformat 속성 처리 함수
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
			ComKeyOnlyNumber(obj);
			break;
		case "int":
			if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
			else ComKeyOnlyNumber(obj);
			break;
		case "float":
			ComKeyOnlyNumber(obj, "-.");
			break;
		case "eng":
			ComKeyOnlyAlphabet(); break;
		case "engup":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "engup2":
			ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			 ComKeyOnlyAlphabet('lowernum');
		case "engdn2":
			ComKeyOnlyAlphabet('lower');
			break;
	}
}

// axon_event.addListener()용 엔터치면 Retrieve 하는 래퍼 함수
function PrdComKeyEnter(){
	ComKeyEnter('search');
}

/**
 * sheetObj.GetSaveXml() 함수로 xml 문자열 값을 이용하여 콤보 박스에 맞는 문자열을 리턴한다.
 * 예) 서울|부산|대구|광주|목포
 */
function PrdComEtcDataToComboString(xml){
	var xmlObject = new ActiveXObject("Msxml2.DOMDocument");
	xmlObject.loadXML(xml);
	var etcNodes = xmlObject.documentElement.childNodes[1];
	var buffer = "";
	for(i=0; i<etcNodes.childNodes.length; i++ ){
		var laneCode = etcNodes.childNodes[i].firstChild.text;
		if(laneCode.length < 3) continue;
		buffer += "|"+ laneCode;
	}
	return buffer.substring(1, buffer.length);
}

var popupArray; // 팝업 호출 후 팝업에서 받은 배열 값 저장 객체
/**
 * html 폼용으로 호출시 PrdComPopup("location", document.form.input1);
 * sheet 폼용으로 호출시 PrdComPopup("location", null, sheetObj, row, "colName");
 */
function PrdComPopup(searchType, formObject, sheetObject, row, colName){
	var paramValue;
	if(sheetObject == null){ // HTML 폼 객체면
		paramValue = formObject.value;
	}else{ // sheet 객체면
		paramValue = sheetObject.CellValue(row, colName);
	}
	var outValue = "";
	if(searchType == "location"){
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + "?loc_cd="+paramValue, 770, 470, 'PrdSetPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		if(popupArray != null){ // 선택 안하고 종료하면 에러난다. 그래서 검사
			outValue = popupArray[0][3];
		}
	}else if(searchType == "yard"){
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + "?node_cd="+paramValue, 770, 470, 'PrdSetPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		if(popupArray != null){
			outValue = popupArray[0][3];
		}
	}else if(searchType == "lane"){
		ComOpenPopup('/opuscntr/COM_ENS_081.do' + "?lane_cd="+paramValue, 770, 470, 'PrdSetPopupArray', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		if(popupArray != null){
			outValue = popupArray[0][3];
		}
	}
	// 폼이나 쉬트 컬럼에 값주기
	if(sheetObject == null){ // HTML 폼이면
		formObject.value = outValue;
	}else{ // sheet 객체면
		sheetObject.CellValue2(row, colName) = outValue;
	}
}

function PrdSetPopupArray(popupArray){
	this.popupArray = popupArray;

	// debug 확인용 TODO 정리 noh
	if(confirm("배열 값을 debug 하시겠습니까?")){
		var ao = popupArray[0];
		for(i=0; i<ao.length; i++){
			ComShowMessage(i + " | "+ao[i]);
		}
	}
}
