// --------------------------------------------------------
// 메세지 관련
// 샘플 msgs["SPP01001"] = "{?msg1} {?msg2}하십시오.";
// -------------------------------------------------------
	msgs["SPP00001"] = "Data was saved successfully.";
	msgs["SPP00002"] = "Data was requested successfully.";
    msgs["SPP01000"] = "Do you want to initialize?";
    msgs["SPP01001"] = "Do you want to save changes?";
    msgs["SPP01002"] = "There is no related {?msg1}data!";    
    msgs["SPP01003"] = "지금은 사용하실 수가 없습니다.";  //debug용    
    msgs["SPP01004"] = "There is no contents to save.";   
    msgs["SPP01005"] = "Please check currency. It is already existed!"; 
	msgs["SPP01006"] = "[{?msg1}] is different from [{?msg2}].";
	msgs["SPP01007"] = "[{?msg1}] Value is Empty.";	
    msgs["SPP01008"] = "There is contents to save. First, save contents!"; 
    msgs["SPP01009"] = "Do you want to request contents finally?";  
    //msgs["SPP01010"] = "Data saved successfully.";
    //msgs["SPP01011"] = "Data requested successfully.";
    msgs["SPP01012"] = "Saving has been failed.";
    msgs["SPP01013"] = "End date must be greater than start date.";  //CoCalendar.js 에 설정되어 있는 메시지. 코드화 되어 있지 않아 추가했음.
    msgs["SPP01014"] = "Advance Payment Status is not Approved.";
    msgs["SPP01015"] = "No Data! Not [Row Add].";
    msgs["SPP01016"] = "Invoice Status is not Approved.";
    msgs["SPP01017"] = "MSA Status is not Ready.";
    msgs["SPP01018"] = "{?msg1} should be {?msg2} letters length.";
    msgs['SPP00019'] = 'Vessel Code should be 4 letters length.';
    msgs['SPP00020'] = "Vessel Code doesn't exist.";
    msgs['SPP00021'] = 'Port Code should be 5 letters length.';
    msgs['SPP00022'] = "Port Code doesn't exist.";
    msgs['SPP00023'] = 'Lane Code should be 3 letters length.';
    msgs['SPP00024'] = "Lane Code doesn't exist.";
    msgs['SPP00025'] = "Can’t  request  this invoice due to not  upload  file that copied actual invoice of Owners account.";
    msgs['SPP01026'] = 'This file is invalid. Please select the other files.';
    msgs["SPP00027"] = "Please select {?msg1} !";
    msgs["SPP00028"] = "You can not input this invoice due to the same vessel in this month.please input next month.";
    msgs["SPP01029"] = "[{?msg1}] must be between 0 and 99.";
    msgs["SPP01030"] = "Failed to save data. Please try again.";
	msgs["SPP01031"] = "Failed to request data. Please try again.";
	msgs["SPP01032"] = "Mandatory field is missing. Please enter [{?msg1}].";
	msgs["SPP01033"] = "Port Status is 'SKIP'.";
	
    
//*************** PSO FUNCUTION START ***************//

/**
 * SPP Common javascript
 * @class 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function CoSpp() {    
    this.ComCodeMsgByInitialize 	= ComCodeMsgByInitialize;
    this.ComCodeMsgBySave 			= ComCodeMsgBySave;
    this.ComCodeMsgByNoRelatedData 	= ComCodeMsgByNoRelatedData;
    this.ComCodeMsgByNoUsed 		= ComCodeMsgByNoUsed;
    this.ComCodeMsgByNoContentsSave = ComCodeMsgByNoContentsSave;
    this.ComCodeMsgByUnMatchData 	= ComCodeMsgByUnMatchData;
    this.ComCodeMsgByEmptyData 		= ComCodeMsgByEmptyData;
    this.openCalendar 				= openCalendar;
    this.ComSaveXml2ScssTF 			= ComSaveXml2ScssTF;
    this.ComSaveXml2Message 		= ComSaveXml2Message;
    this.ComSaveXml2IsTagExist 		= ComSaveXml2IsTagExist;
    this.ComShowFocusCursor 		= ComShowFocusCursor;
    this.ComNullToBlank 			= ComNullToBlank;
    this.ComNullToValue 			= ComNullToValue;
    this.ComClearFormSeparator 		= ComClearFormSeparator;
    this.ComSetFormSeparator 		= ComSetFormSeparator;
    this.getEngMonthName 			= getEngMonthName;
    this.getPos 					= getPos;
    this.selectRowNum 				= selectRowNum;
    this.ComRowDelete 				= ComRowDelete;
    this.setToday 					= setToday;
    this.checkFromTo				= checkFromTo;
    this.SppComXml2ComboItem		= SppComXml2ComboItem;
    this.SppComText2ComboItem		= SppComText2ComboItem;
    this.SppComMakeComboObject    	= SppComMakeComboObject;
    this.initToolTipDiv				= initToolTipDiv;
    
}

/**
* Do you want to initialize?
*/
function ComCodeMsgByInitialize(){
	return ComShowCodeConfirm('SPP01000');
}

/**
* Do you want to save changes?
*/
function ComCodeMsgBySave(){
	 return ComShowCodeConfirm('SPP01001');
}

/**
* There is no related data!
* @param msg1
*/
function ComCodeMsgByNoRelatedData(msg1){
	ComShowCodeMessage('SPP01002', msg1);
}

/**
* 지금은 사용하실 수가 없습니다.
*/
function ComCodeMsgByNoUsed(){
	ComShowCodeMessage('SPP01003');
}

/**
* There is no contents to save. 
*/
function ComCodeMsgByNoContentsSave(){
	ComShowCodeMessage('SPP01004');
}

/**
* [{?msg1}] is different from [{?msg2}].
* @param msg1
* @param msg1
*/
function ComCodeMsgByUnMatchData(msg1, msg2){
	ComShowCodeMessage('SPP01006', msg1, msg2);
}

/**
* [{?msg1}] Value is Empty.
* @param msg1
*/
function ComCodeMsgByEmptyData(msg1){
	ComShowCodeMessage('SPP01007', msg1);
}

/**
* Data was saved successfully.
*/
function ComCodeMsgBySaveSuccess(){
	ComShowCodeMessage('SPP00001');
}

/**
* Data was requested successfully.
*/
function ComCodeMsgByRequestSuccess(){
	ComShowCodeMessage('SPP00002');
}

/**
* Failed to save data. Please try again.
*/
function ComCodeMsgBySaveFailed(){
	ComShowCodeMessage('SPP01030');
}

/**
* Failed to request data. Please try again.
*/
function ComCodeMsgByRequestFailed(){
	ComShowCodeMessage('SPP01031');
}

/**
* [{?msg1}] must be between 0 and 99.
* @param msg1
*/
function ComCodeMsgByInvalidRangeData(msg1){
	ComShowCodeMessage('SPP01029', msg1);
}

/**
* Mandatory field is missing. Please enter [{?msg1}].
* @param msg1
*/
function ComCodeMsgByMandatoryFieldMiss(msg1){
	ComShowCodeMessage('SPP01032', msg1);
}

/**
* save 저장 후 반환되는 xml 로 부터 성공 여부 체크
* @param xml 저장 결과
* @param tagName xml 에서 찾고자 하는 tag name
* @param 찾고자 하는 순번
* @return true/false
*/
function ComSaveXml2ScssTF(sXml, tagName, idx) {
    var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    xmlDoc.async="false";
    xmlDoc.loadXML(sXml);

    var dataNode = xmlDoc.documentElement.getElementsByTagName(tagName).item(idx);
	
    if(dataNode !== undefined && dataNode !==null && dataNode.text == "OK") {
    	//ComShowMessage("DownLoad Successfully");
    	return true;
    } else {
    	//ComShowMessage("DownLoad Fail");
    	return false;
    }
    return true;
}

/**
* save 저장 후 반환되는 xml 로 부터 반환 메시지
* @param xml 저장 결과
* @param tagName xml 에서 찾고자 하는 tag name
* @param 찾고자 하는 순번
* @return 메시지
*/
function ComSaveXml2Message(sXml, tagName, idx) {
    var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    xmlDoc.async="false";
    xmlDoc.loadXML(sXml);

    var dataNode = xmlDoc.documentElement.getElementsByTagName(tagName).item(idx);
	
    if(dataNode !== undefined && dataNode !==null) {
    	return ComReplaceStr(dataNode.text,"<||>","\n");
    }else{
    	return "";
    }
}

/**
* save 저장 후 반환되는 xml 로 부터 해당 태그가 있는지 체크
* @param xml 저장 결과
* @param tagName xml 에서 찾고자 하는 tag name
* @return true/false
*/
function ComSaveXml2IsTagExist(sXml, tagName) {
    var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    xmlDoc.async="false";
    xmlDoc.loadXML(sXml);
    var dataNodeObj = xmlDoc.selectSingleNode("/"+tagName);

    if(dataNodeObj != undefined && dataNodeObj != null) {
    	return true;
    }else{
    	return false;
    }
}

/**
* form object(특히 input box) 에서 특정 event 로 인해서 사라진 포커스를 보여줌.
* @param obj 대입되는 값
* @return original 값
*/
function ComShowFocusCursor(obj){
	var tmp=obj.value; 
	obj.value=""; 
	obj.select(); 
	obj.value=tmp; 
}

/**
* 대입되는 값이 null 이거나 blank 일 경우 blank 반환
* @param obj 대입되는 값
* @return blank or object
*/
function ComNullToBlank(obj){
	if(obj==undefined || obj==null || obj==""){
		return "";
	}else{
		return obj;
	}	
}

/**
* 대입되는 값이 null 이거나 blank 일 경우 특정 반환값 returnVal 반환
* @param obj 대입되는 값
* @param returnVal 특정 반환값
* @return object or 특정값
*/
function ComNullToValue(obj, returnVal){
	if(obj==undefined || obj==null || obj==""){
		return returnVal;
	}else{
		return obj;
	}
}

/**
 * 폼의 모든 element 의 마스크를 제거한다.
 * @param formObj 폼 object
 */
function ComClearFormSeparator(formObj){
      len = formObj.elements.length;
        for (i = 0; i < len; i++) {
        	ComClearSeparator(formObj.elements[i]);
        } 	
}

/**
* 폼의 모든 element 의 마스크를 셋팅한다.
* @param formObj 폼 object
*/
function ComSetFormSeparator(formObj){
     len = formObj.elements.length;
       for (i = 0; i < len; i++) {
	        	ComAddSeparator(formObj.elements[i]);
	   }	
}

/**
* 입력월 ==> 영문 월   ex(12 -> DEC)
* |JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC
* @param {string} month 월   
*/
function getEngMonthName(month) {
	var mon  = ComParseInt(month);	
	switch (mon) {
	case 1:
		return "JAN";
		break;
	case 2:
		return "FEB";	
		break;
	case 3:
		return "MAR";
		break;
	case 4:
		return "APR";
		break;
	case 5:
		return "MAY";
		break;
	case 6:
		return "JUN";
		break;
	case 7:
		return "JUL";
		break;
	case 8:
		return "AUG";
		break;
	case 9:
		return "SEP";
		break;
	case 10:
		return "OCT";
		break;
	case 11:
		return "NOV";
		break;
	case 12:
		return "DEC";
		break;
	default:
		return "";
		break;
	}
}

/**
* 객체 위치 취득 
* @param {htmlObj} Html object    
*/
function getPos(obj){
	 var xy = { x: 0, y: 0 };	 
	 while (obj) {
		 xy.x += obj.offsetLeft; 
		 xy.y += obj.offsetTop;		 
		 obj = obj.offsetParent;
	 }	 
	 return xy;
}

/**
* 체크된 행번호 Array취득 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} chkColName 선택 컬럼명
*/
function selectRowNum(sheet , chkColName) {
	
	var sRow = "";
	if (!ComIsNull(chkColName)) {
		sRow = sheet1.FindCheckedRow(chkColName);
	} else {
		sRow = sheet1.FindCheckedRow("delChk");
	}
	
	if (ComIsNull(sRow)) {
		return null;
	}
	
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	//마지막 빈공백 요소 제거 
	arrRow.pop();
	
	return arrRow;
}

/**
* 추가(I)한 행은 실제 삭제, 그외의 행(R/U)은 숨기기 처리 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} col 컬럼명
*/
function ComRowDelete(sheet, col) {
	//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
	var sRow = sheet.FindCheckedRow(col);
	if (sRow == "") {
		ComShowCodeMessage("COM12189");  //Nothing selected
		return ;
	}
	
	if(!ComShowCodeConfirm("COM12165", "")) return;  //Do you want to delete {?msg1}?
	
	//가져온 행을 배열로 만들기 
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	
	for (var idx=arrRow.length-2; idx>=0; idx--){
		var row = arrRow[idx];		
		var status = sheet.RowStatus(row);
		
		if (status == "I") {
			sheet.RowDelete(row,false);
		} else {
			sheet.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
			sheet.RowHidden(row)= true;		//2.행 숨기기		
			sheet.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		}
	}
	
	return arrRow -1 ;
}

/**
* 형식에 따른 오늘의 날짜 구하기 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} col 컬럼명
*/
function setToday( obj, format )
{
  var today = new Date();
  var year = today.getFullYear();
  var month = today.getMonth()+1;
  if( (''+month).charAt(1) == '' ) month = '0' + month;
  var date = today.getDate();
  if( (''+date).charAt(1) == '' ) date = '0' + date;
  var hour = today.getHours();
  if( (''+hour).charAt(1) == '' ) hour = '0' + hour;
  var minute = today.getMinutes();
  if( (''+minute).charAt(1) == '' ) minute = '0' + minute;
  var sec = today.getSeconds();
  if( (''+sec).charAt(1) == '' ) sec = '0' + sec;
  
  var theDay = year;
  switch(format){
	  case "y" : 
		  theDay = theDay;
		  break;
	  case "m" : 
		  theDay = month;
		  break;	  
	  case "ym" : 
		  theDay += '-' + month;
		  break;
	  case "ymd" :
		  theDay += '-' + month + '-' + date;
		  break;
	  default :
		  theDay += '-' + month + '-' + date;
	  	  break;
  }
  obj.value  = theDay;
  return;  
}

/**
 * from date 와 to date 에 입력한 날짜의 유효성 체크. from 값이 to 값보다 항상 작게 입력. <br>
 * @param {object} fromDObj - from date Object
 * @param {object} toDObj - to date Object
 */        
function checkFromTo(fromDObj, toDObj){
    var tmpInterval = ComGetDaysBetween(fromDObj, toDObj);
    if(!ComIsDate(fromDObj)||!ComIsDate(toDObj)){
      ComShowCodeMessage('COM12132');  //Please enter a valid date format: YYYY-MM-DD
      return;
    }else{
      if(tmpInterval<0){
    	ComShowCodeMessage('SPP01013');  //End date must be greater than start date.
        toDObj.focus();
        return;
      }
    }                                
}

/**
 * IBMulti Combo Item Setting
 * XML의 ETC Data에 담겨진 Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
 * param : sXml     ==> IBSheet 결과 XML
 * param : comboObj ==> Combo Object  
 * param : sTextNm  ==> Combo Item Text Name in XML ETC Date
 * param : sCodeNm  ==> Combo Item Code Name in XML ETC Date
 * delim : delim    ==> Combo Item Text/Code Name Delimeter
 * CoLse.js 참조 : LseComXml2ComboItem()
 */
function SppComXml2ComboItem(sXml, comboObj, sTextNm, sCodeNm, delim) {
 	var strText = ComGetEtcData(sXml, sTextNm);
     var strCode = ComGetEtcData(sXml, sCodeNm);

     SppComText2ComboItem(comboObj, strText, strCode, delim);
}
 
/**
 * IBMulti Combo Item Setting
 * Combo Item의 Text와 Code를 Delimeter로 split하여 그 배열로 Combo Item 생성
 * param : comboObj ==> Combo Object  
 * param : sTextNm ==> Combo Item Text
 * param : sCodeNm ==> Combo Item Code
 * delim : delim   ==> Combo Item Text/Code Delimeter
 * CoLse.js 참조 : LseComText2ComboItem()
 */
function SppComText2ComboItem(comboObj, strText, strCode, delim) {
    var arrStrText = strText.split(delim);
    var arrStrCode = strCode.split(delim);

    SppComMakeComboObject(comboObj, arrStrText, arrStrCode);
} 
  
/**
 * IBMulti Combo Item Setting
 * param : comboObj ==> Combo Object  
 * param : arrStrNm ==> Combo Item Text Array
 * param : arrStrCd ==> Combo Item Code Array
 * CoLse.js 참조 : LseComMakeComboObject()
 */
function SppComMakeComboObject(comboObj, arrStrText, arrStrCode) {
  	var itemCnt = comboObj.GetCount();

  	for ( var i = 0 ; i < arrStrCode.length ; i++ ) {
  		comboObj.InsertItem((i+itemCnt), arrStrText[i], arrStrCode[i]);
  	}
}  

/**
 * ToolTip div 만들기
 * @param ToolTip div 명
 * @return true/false
 */ 
function initToolTipDiv(divObjName){
    try {
	    if (document.getElementById(divObjName)!=null) return true;
		//ToolTip DIV 만들기
	    var tmpStyle = "";
	    tmpStyle    += "border:1 solid #000000;position:absolute;z-index:10;";
	    tmpStyle    += "font-size:10;padding:1;font-family:Arial;color:#000000;background:#FFFFD0;";
	    var _divToolTip = document.createElement("<div id='"+divObjName+"' style='"+tmpStyle+"' />");
	    document.body.insertBefore(_divToolTip);
	    return true;
    } catch(err) { ComFuncErrMsg(err.message); return false;}    
}

 /**
 * File Upload 팝업호출
 * @param {String} clmFileTpCd (UI_ID 4자리) + (일련번호2자리) 
 * @param {String} cgoClmRefNo 클레임번호 CC20090001
 * 
 * ex)Salvage  UI_CNI_0013 
 * popupFileUpload("001301" , "CC20090001");
 */
 function popupFileUpload(clmFileTpCd , cgoClmRefNo) {	
 	var url = "EXP_SPP_0007.do?clm_file_tp_cd=" + clmFileTpCd + "&cgo_clm_ref_no=" + cgoClmRefNo;
 	var winName = "EXP_SPP_0007";
 	var reqWin = openWinCenter(url,winName,640,425);
 	reqWin.focus();
 	return reqWin;
 }
 /**
 * 파일업로드 리스트를 조회한다.
 * sample)
 *  //파일 리스트 조회
 *	var fileSeq = ComGetEtcData(sXml,"file_seq");
 *	if(fileSeq != "" && fileSeq != null){
 *		var fileXml = SearchFileUpload(sheetObj,fileSeq);
 *		sheetObjects[10].LoadSearchXml(fileXml);
 *	}
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 * @param   {String} 	sheetObj    필수,IBSheet Object ID
 * @return  {Xml}       sXml        조회 xml
 */
 function SearchFileUpload(sheetObj,fileSeq){
	var sParam = "f_cmd="+SEARCH;
	sParam += "&file_seq=" + fileSeq;

	var sXml = sheetObj.GetSearchXml("SPP_INTGS.do","" ,sParam,true);
 	return sXml;
 }

 /**
 * 선택된 파일업로드 리스트를 삭제.
 * sample)
 * RemoveFileUpload(sheetObj);
 * @param {Ibsheet} 	sheetObj    필수,IBSheet Object ID
 */
 function RemoveFileUpload(sheetObj){
 	//빈데이타는 미리 삭제한다.
	var sRow = sheetObj.FindCheckedRow("del_chk");
	if (sRow != ""){
		//가져온 행을 배열로 만들기
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비
		//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
		for (var idx=arrRow.length - 2; idx>=0; idx--){
			var row = arrRow[idx];
			if(sheetObj.CellValue(row,"org_file_nm") == ""){
				sheetObj.RowDelete(row, false);  	//완전 삭제
			}
		}
	}

	var SaveStr = sheetObj.GetSaveString(false, true, "del_chk");
	var sParam = "f_cmd=" + REMOVE;
	sParam = sParam + '&' + SaveStr;

	//해당 쉬트에서 삭제
	MnrRowDelete(sheetObj,"del_chk");
	//서버에서 삭제
	//변경 사항이 있는경우만
	if(SaveStr != ""){
		var sXml = sheetObj.GetSearchXml("SPP_INTGS.do","" ,sParam,true);
	}
 }
 
 /**
  * 숫자체크 
  */    
 function Numberchk(inputValue){
 	var myregexp = /^[0-9]+$/;

     if( myregexp.test(inputValue) ){
     	return true;
     }else{
     	return false;
     }       
 } 

//*************** PSO FUNCUTION END ***************//
