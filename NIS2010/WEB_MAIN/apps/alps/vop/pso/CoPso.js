/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoPso.js
 *@FileTitle : Pso Common javascript
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 박명종
 *@LastVersion : 1.0
 * 2009.06.08 박명종
 * 1.0 Creation 
 * 
 * 2014.03.12 박다은   CHM-201429104 	   [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
 * 2014.05.30 박다은 [CHM-201430063] Invoice Issued date alc Received date 입력 오류 방지을 위한 로직 변경 개발 요청
 * 2016.03.14 CHM-201640418 승인 단계에서 파일 첨부 기능 추가
=========================================================*/

//--------------------------------------------------------
//메세지 관련
//샘플 msgs["GEM01001"] = "{?msg1} {?msg2}하십시오.";
//-------------------------------------------------------
// ----------------------------------------------
// Common  Common message
// ----------------------------------------------
msgs["PSO00001"] = "{?msg1} data is invalid.";  	//{?msg1} 데이터가 유효하지 않습니다.
msgs["PSO00002"] = "{?msg1} is duplicated."; 	//{?msg1} 입력 데이터가 중복되었습니다.
msgs["PSO00003"] = "Please fill all required entry fields {?msg1}."; 	//{?msg1} 필수항목을 입력하여 주시기 바랍니다
msgs["PSO00004"] = "Please check '{?msg1} Range' on rate type."; 	//{?msg1} range를 확인하여  주시기 바랍니다
msgs["PSO00005"] = "{?msg1} Please input Currency [{?msg1}].";// {?msg1} Currency를 선택해 주시기 바랍니다
msgs["PSO00006"] = "'Terminal Code' is mandatory field. Please enter '{?msg1} Terminal Code'."; //{?msg1} 터미널을 1개만 선택해 주시기 바랍니다
msgs["PSO00007"] = "'Port Code' was mandatory, Please enter {?msg1} 'Port Code'."; 	//{?msg1} port를 선택해 주시기 바랍니다
msgs["PSO00008"] = "Please select {?msg1} Terminal Code."; 	//{?msg1} 터미널을 선택해 주시기 바랍니다
msgs["PSO00009"] = "Please select {?msg1} date."; 		//{?msg1} 날짜를 선택해 주시기 바랍니다
msgs["PSO00010"] = "Please select {?msg1} cost code.";	//{?msg1} cost cd를 선택해 주시기 바랍니다
msgs["PSO00011"] = "Please select {?msg1} service provider."; //{?msg1} service provider를 선택해 주시기 바랍니다
msgs["PSO00012"] = "Please select {?msg1} version."; 	//{?msg1} ver를 선택해 주시기 바랍니다
msgs["PSO00013"] = "Please select {?msg1} currency."; //{?msg1} Currency를 선택해 주시기 바랍니다
msgs["PSO00014"] = "{?msg1} data is invalid."; 			//{?msg1} Invalid Code
msgs["PSO00015"] = "Do you want to confirm {?msg1} ?"; 			//Will You Confirm?
msgs["PSO00016"] = "Do you want to reject?";  			//Will You Reject?
msgs["PSO00017"] = "Please input one or more data on base."; //Base에는 최소 한건의 데이터를 입력하셔야 합니다.
msgs["PSO00018"] = "{?msg1} should be bigger than {?msg2}."; //{?msg1} 값은 {?msg2} 값보다 커야 합니다.
msgs["PSO00019"] = "Please use function of Copy after Retrive.";		 //데이터를 조회후 복사기능을 이용하십시오.
msgs["PSO00020"] = "Are you sure to delete this data?";	//Are you sure to delete this?
msgs["PSO00021"] = "This Service Provider is not available.."; //There is no Service Provider like this.
msgs["PSO00022"] = "Please select {?msg1}.";		//{?msg1} 를 선택해 주시기 바랍니다
msgs["PSO00023"] = "Please input {?msg2} as {?msg1}"; //{?msg1}을(를) {?msg2}(으)로 입력해 주시기 바랍니다
msgs["PSO00024"] = "Object was already inputted rate type as [Fixed] and can't change rate type.";//동일 Object에 Fixed 타입의 데이터가 이미 입력되었습니다. 따라서 {?msg1} 변경이 불가능합니다.
msgs["PSO00025"] = "This data is already input to {?msg1}."; //This data is already input to {?msg1}.
msgs["PSO00026"] = "Please input [{?msg1}]data only."; //[{?msg1}] 이러한 데이터만 입력해주십시오.
msgs["PSO00027"] = "Unexpected system error tool place during data processing.: {?msg1}"; //처리 오류가 발생하였습니다 : {?msg1}
msgs["PSO00028"] = "If it is changed into rate type, The other rows will be deleted except for frist row ?"; //Rate Type을 Fixed로 변경하면 첫째행을 제외한 나머지는 삭제됩니다. 계속 하시겠습니까???
msgs["PSO00029"] = "If there are a lot of data, it can take long time to save data.";
msgs["PSO00030"] = "There is no tariff.";//Tariff를 발견하지 못했을 경우 0014화면
msgs["PSO00031"] = "There is no Vessel Code.";//0010 Vessel Code 가 Missing 된 경우
msgs["PSO00032"] = "There is no Voyage No.";//0010 Voyage No 가 Missing 된 경우
msgs["PSO00033"] = "There is no Direction Code.";//0010 Direction Code 가 Missing 된 경우
msgs["PSO00034"] = "There is no changed Data.";//저장시, 변경 Data가 없을 경우
msgs["PSO00035"] = "Please input date that is less than the date of the next tariff data.";//Tariff Value Management (VOP_PSO_0037)
msgs["PSO00036"] = "Please input {?msg1}.";		//{?msg1} 를 입력해 주시기 바랍니다
msgs["PSO00037"] = "There are changed data. Would you save them?";		//변경된 데이터가 있는 경우, 저장 여부 확인
msgs["PSO00038"] = "{?msg1} Processing...";//Batch Processing 이 진행 중임을 표시 
msgs["PSO00039"] = "Please select the row that you want to proceed.";//Expense Creation 
msgs["PSO00040"] = "It is not permitted to input {?msg1}."; 
msgs["PSO00041"] = "Would you {?msg1}?"; 
msgs["PSO00042"] = "Please input only one of [VAT] and [W/T]"; 
msgs["PSO00043"] = "Invoice Amount must be Sum of Cost Amount + VAT  or  Sum of Cost Amount - W/T"; 
msgs["PSO00044"] = "This Inv No. already exists."; 
msgs["PSO00045"] = "Please input {?msg1} below {?msg2} letters.";	//data를 몇자이하로 입력 
msgs["PSO00046"] = '{?msg1} should be greater than or equal to the {?msg2}.';
msgs["PSO00047"] = "Invoice Amount must be Sum of Cost Amount + VAT - W/T"; 


msgs["PSO01001"] = "This application was already confirmed.";//VOP_PSO_0018 Confirm버튼클릭시 이미 처리된 경우
msgs["PSO01002"] = "This application was rejected successfully.";//VOP_PSO_0018 Reject버튼 클릭시 성공 메시지
msgs["PSO01003"] = "This application was confirmed successfully..";//VOP_PSO_0018 Confirm 버튼 클릭시 성공 메시지
msgs["PSO01004"] = "Please input the (-) amount in case of credit memo.";//Credit Memo 사용은 (-) 금액일때만 가능

msgs["PSO09012"] = "Do you want to delete {?msg2} ID of {?msg1} ?"; //{?msg1}의 ID:{?msg2} 을 삭제하시겠습니까?
msgs["PSO09013"] = "Invoice Count : {?msg1}\nAre you sure to proceed?";


msgs["PSO09014"] = "There is no data changed.";
msgs["PSO09015"] = "{?msg1} Data Changed. Do you want to save it?";
msgs["PSO09016"] = "There is files that you don't save. Do you want to close popup?";
msgs["PSO09017"] = "Please select data to save.";
msgs["PSO09018"] = "No Selected Row.";
msgs["PSO09019"] = "Attached File is deleted due to storage server capacity.";




/**
 * Pso Common javascript
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CoPso() {    
	this.validateForm = validateForm;
}

/**
* VoList를 array[array[name]]형태로 변환 
* @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo 
*/
function ComXml2ListMap(xmlStr) {

	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return rtnArr;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return rtnArr;
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}

			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

			var subDataArr = new Array();

			for ( var j = 0; j < arrData.length; j++) {
				subDataArr[colArr[j]] = arrData[j];
			}

			rtnArr[i] = (subDataArr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
* Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정 
* @param {form} form html 폼 
* @param {map} Array[name] 의 값 
*/
function ComMapToForm(form, map) {		
	//사용가능한 컨트롤을 배열로 생성한다.
	var len = form.elements.length;
	for (var i = 0; i < len; i++) {
		if (form.elements[i].classid == undefined) {
			var xvalue = map[form.elements[i].name];
			if (xvalue == undefined)
				continue;
			switch (form.elements[i].type) {
			case "button":
			case "reset":
			case "submit":
				break;
			case "radio":
				var eRadio = document.all[form.elements[i].name];
				var idx = 0;
				for ( var k = 0; k < eRadio.length; k++) {
					if (eRadio[k].value == xvalue) {
						idx = k;
						break;
					}
				}
				eRadio[idx].checked = true;
				break;
			case "checkbox":
				form.elements[i].checked = xvalue;
				break;
			case "select-one":
				var eOpt = form.elements[i].options;
				var idx = 0;
				if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
					var opt_len = eOpt.length;
					for ( var k = 0; k < opt_len; k++) {
						if (eOpt[k].value == xvalue) {
							idx = k;
							break;
						}
					}
				}
				form.elements[i].selectedIndex = idx;
				break;
			case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
			var eOpt = form.elements[i].options;
			var idx = 0;
			if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
				var opt_len = eOpt.length;
				var tvalue = xvalue.split("|");
				var tval_len = tvalue.length;
				for ( var k = 0; k < opt_len; k++) {
					for ( var m = 0; m < tval_len; m++) {
						if (eOpt[k].value == tvalue[m])
							eOpt[k].selected = true;
					}
				}
			}
			break;
			default:
				form.elements[i].value = xvalue;
			}
		}
	}      	

}


/**
* Array의 값에 중복 된 데이타 여부 
* @param {form} form html 폼 
* @param {map} Array[name] 의 값
* @return 중복 true 미중복 false 
*/
function ComIsDupData(arr) {		

	for( var i = 0 ; i < arr.length ;  i++ ) {
		var a = arr[i];
		for( var j = i+1 ; j < arr.length ;  j++ ) {			
			var b = arr[j];
			if ( a == b ) {
				return true;
			}
		}
	}

	return false;

}


/**
*  iframe height자동으로 늘어나고 줄어들기
* @param {string} iframe 이름  
*/
function resizeIframe(iFrameName) {
	var limit = 500;
	var objFrame = window.parent.document.getElementById(iFrameName);   
	var objBody = objFrame.contentWindow.document.body; 
	ifrmHeight = objBody.scrollHeight + (objBody.offsetHeight - objBody.clientHeight);   

	if (ifrmHeight > limit ) {
		objFrame.style.height = ifrmHeight;
	} else {
		objFrame.style.height = limit;
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
* Status가 "D"가 아닌 row의 갯수를 가져온다 <br>
* <br><b>Example :</b>
* <pre>
*     rowCnt = SheetRowCount(sheetObj);
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @return int sheet내의 유효한 row수
* @author 박성수
* @version 2009.05.13
*/
function SheetRowCount(sheetObj) {
	return (sheetObj.RowCount - sheetObj.RowCount("D"));
}




/**
* Select된 행번호 Array취득 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} chkColName 선택 컬럼명
* @return 행번호 [1,3,7]
               * @author 진윤오
               * @version 2009.05.13
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
* 행을 삭제 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} col 컬럼명
* @return 행번호 [1,3,7]
               * @author 진윤오
               * @version 2009.05.13
               */
               function ComRowDelete(sheet, col) {
	//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheet.FindCheckedRow(col);
if (sRow == "") return ;


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
* 시트 첫번째 행번호  <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {int} 시작 행 Index 해더가 2행이면 2  , 1행이면 1  
* @return 행번호 삭제가 아니 행번호
* @author 진윤오
* @version 2009.05.13
*/
function FirstRowNum(sheet , rowIdx) {

	var idx = 1;

	if (rowIdx != null && rowIdx > 0) {
		idx = rowIdx;
	}

	for ( var i = 0; i < sheet.RowCount; i++) {
		var row =  i + idx;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		} else {
			return row;
		}
	}

}

/**
* 콤보 박스 내용 복사   <br>
* @param {combo} combo1 원본
* @param {combo} combo2 대상  
* @author 진윤오
* @version 2009.05.13
*/
function comboCopy(combo1, combo2) {
	combo2.length = 0;

	for ( var i = 0; i < combo1.length; i++) {
		var val = combo1.options[i].value;
		var txt = combo1.options[i].text;
		ComAddComboItem(combo2 , val , txt);
	}

	combo2.value = combo1.value;
}

/**
* 윈도우 Center에서 열기   <br>
* @param {string} url url
* @param {string} winName 타겟  
* @param {int} width 타겟
* @param {int} height 타겟 
* @author 진윤오
* @version 2009.05.13
*/
function openWinCenter(url,winName,width,height) {
	var left = (screen.width - width)/2;    
	if(left < 0) {
		left = 0;
	}
	var top  = (screen.height- width)/2;   
	if( top < 0 ) {
		top = 0;
	}

	var feature = 
		"status=no, resizable=no, scrollbars=no, width="+width+", height="+height+", left="+left+", top="+top;

	return window.open(url,winName,feature);

}



/**
* 절대값   <br>
* @param {number} num number
* @author 진윤오
* @version 2009.05.13
*/
function abs(num) {	


	if (num < 0 ) {		
		return ( num * -1);
	}

	return num;

}

/**
* 절대값   <br>
* @param {obj} checkbox
* @return checked value '1,2,3'  콤마(,) 로분리
* @author 진윤오
* @version 2009.05.13
*/
function checkBoxValue(obj) {
	var txt = "";
	if (obj.length) {
		var checked = 0;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].checked) {
				txt += "," + obj[i].value;
				checked++;
			}
		}		

		if (checked > 0) {
			return txt.substring(1 ,txt.length);
		} else {
			return "";
		}

	} else {
		if (obj.checked) {
			return obj.value;
		}
	}

	return txt;
}


/**
* HO, HQ 체크 박스 설정 
* @param {value} 선택된 체크 박스구분
*/
function setHOHQ(obj, lvlName) {
	var colName = obj.name;
	var colValue = obj.value;

	var c1 = eval("document.all."+colName+"[0].checked");
	var c2 = eval("document.all."+colName+"[1].checked");
	if ( c1 && c2 ) {
		if (colValue == "N") {
			eval("document.all."+colName+"[1].checked = false;");
		} else if (colValue == "Y") {
			eval("document.all."+colName+"[0].checked = false;");
		}		
	} else if(!c1 && !c2) {
		// HO & HQ를 선택하지 않았을경우 BU Office정보를 Reset.
		var objLvl1 = eval(lvlName+1);
		objLvl1.options[0] = new Option("", "", true, true);
	}
}

/**
 * BUOffice의 HO or HQ 구분
 * @author choijungmi
 */
function isHoHqGubun(url, command, sheetObj, hohq, lvl, colName){	 
	comLevelChange(url, command, sheetObj, hohq, lvl, colName);
}

/**
* Ho or Hq 선택여부 Check
* @author choijungmi
* @param colName
* @return
*/
function isRadioUnselected(colName) {
	var isChecked = false;

	var c = document.getElementsByName(colName);
	var k = 0;
	for (var i = 0; i < c.length; i++)	{
		if(c[i].checked == true) {
			k = k + 1;      
		}
	}
	if(k > 0) isChecked = true; 

	return isChecked;
}

/**
* BUOffice값의 Level값에 따라 변경
* url : CPS_GEM_0011.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
* 
* @author choijungmi
* @param url
* @param command
* @param sheetObj
* @param hohq
* @param lvl
* @param colName 
* 
*/
function selLevelChange(url, command, sheetObj, hohq, lvl, colName) {
	if(lvl == "2") {
		var objLvl2 = eval(colName+2);
		if(!isRadioUnselected(hohq)) {
			// HO or HQ를 선택하세요.
			ComShowCodeMessage("GEM01038","a office type");
			objLvl2.options[0] = new Option("", "", true, true);		
			return;
		}
	}
	comLevelChange(url, command, sheetObj, hohq, lvl, colName);
}

function selLevelChange2(url, command, sheetObj, hohq, lvl, colName) {
	if(lvl == "2") {
		var objLvl2 = eval(colName+2);
		if(!isRadioUnselected(hohq)) {
			// HO or HQ를 선택하세요.
			ComShowCodeMessage("GEM01038","a office type");
			objLvl2.options[0] = new Option("", "", true, true);		
			return;
		}
	}
}

/**
* BUOffice값의 Level값에 따라 변경
* url : CPS_GEM_0011.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
* 
* @author choijungmi
* @param url
* @param command
* @param sheetObj
* @param hohq
* @param lvl
* @param colName
*/
function comLevelChange(url, command, sheetObj, hohq, lvl, colName) {
	var objLvl1 = eval(colName+1);
	var objLvl2 = eval(colName+2);
	var objLvl3 = eval(colName+3);

	if(lvl == "1") {		
		objLvl2.length = 1;
		objLvl3.length = 1;

		objLvl2.options[0] = new Option("", "", true, true);
		objLvl3.options[0] = new Option("", "", true, true);

		//doActionIBSheet(SEARCHLIST01);
		comDoAction(url, command, sheetObj, hohq, lvl, colName);
	} else if(lvl == "2") {
		objLvl3.length = 1;
		objLvl3.options[0] = new Option("", "", true, true);

		//doActionIBSheet(SEARCHLIST02);
		comDoAction(url, command, sheetObj, hohq, lvl, colName);
	}
}

/**
* 공통 Search를 위한 doActionIBSheet() 역할
* url : GEM_COMMONGS.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
* 
* @author choijungmi
* @param url
* @param command
* @param sheetObj
* @param hohq
* @param lvl
* @param colName
* 
*/
function comDoAction(url, command, sheetObj, hohq, lvl, colName) {
	//alert(url+"=="+command+"=="+sheetObj+"=="+lvl+"=="+colName);

	var schHohq = "";
	var c = document.getElementsByName(hohq);
	for (var i = 0; i < c.length; i++)	{
		if(c[i].checked == true) {
			schHohq = c[i].value;
			break;
		}
	}

	var objLvl1 = eval(colName+1);
	var objLvl2 = eval(colName+2);
	var objLvl3 = eval(colName+3);

	// LEVEL 조회
	var sXml = eval(sheetObj).GetSearchXml(url+"?f_cmd="+eval(command)+"&sch_hohq_gbn="+schHohq+"&sch_lvl1="+objLvl1.value+"&sch_lvl2="+objLvl2.value);

	if(lvl == "1") {
		// Major
		var etcData = ComGetEtcData(sXml, "searchMajorList");

		if (!ComIsNull(etcData)) {
			var comboListData = etcData.split("|");

			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = objLvl2;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");

				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
		}
	} else if(lvl == "2") {
		// Minor
		var etcData = ComGetEtcData(sXml, "searchMinorList");
		if (!ComIsNull(etcData)) {
			var comboListData = etcData.split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = objLvl3;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");

				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
		}
	}
}

/**
* Do you want to initialize?
*/
function ComCodeMsgByInitialize()
{
	return ComShowCodeConfirm('GEM00011');
}

/**
 * Do you want to save changes?
 */
function ComCodeMsgBySave()
{
	return ComShowCodeConfirm('GEM00012');
}

/**
 * There is no related data!
 */
function ComCodeMsgByNoRelatedData()
{
	ComShowCodeMessage('GEM00013');
}

/**
* 지금은 사용하실 수가 없습니다.
*/
function ComCodeMsgByNoUsed()
{
	ComShowCodeMessage('GEM01027');
}



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

	var theDay = year
	switch(format){
	case "y" : 
		theDay;
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
 * 해당 입력박스의 keycode를 확인하여 영 소문자는 Upper로 변경
 * @return
 */
function toUpper()
{
	try {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var bCanNum  = false;
		if(keyValue >= 97 && keyValue <= 122){                  //소문자
			event.keyCode = keyValue + 65 - 97;
		event.returnValue = true;
		} 
		else {
			event.returnValue = true;
		}
		return true;
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
*==============================================================================================
*/
/**
 * VOP_VSK-0202 Lance Code Help 팝업 창 오픈 
 */
function openLaneCode(){
	ComOpenPopup('/hanjin/VOP_VSK_0202.do', 420, 470, 'setLaneCode', '0,0', false, false);
}

function setLaneCode(aryPopupData, row, col, sheetIdx){
	document.form.vsl_slan_cd.value = aryPopupData[0][1];
} 
/**
*================================================================================================= 
*/

/**
 * 
 */

/**
 * Action 버튼의 활성/비활성 여부를 가져온다. <br>
 * @param  sheetObj	필수
 * @param  TrimComma	필수
 * @param  Status	필수
 * @author 김창식 (CoCgm.js)
 * @version 2009.10.20
 */ 
function ComPsoGetAllSaveText(sheetObj,TrimComma,Status){
	if (TrimComma==undefined || TrimComma==null) TrimComma = false;
	if (Status==undefined || Status==null) Status = "ibflag";

	var arrSave = new Array();

	for(var i = 0 ; i <= sheetObj.LastCol;i++){
		arrSave[i] = sheetObj.ColSaveName(i);
	}

	var str = sheetObj.GetRangeText(sheetObj.HeaderRows ,0,sheetObj.LastRow,sheetObj.LastCol,"|","^");

	if(TrimComma)
		str = str.replace(/\,/gi, "");

	var arrStr = str.split("^");

	for(var i=0 in arrStr){
		var arrCol = arrStr[i].split("|");
		for(var j=0 in arrCol){
			if(arrSave[j] == Status){
				switch(arrCol[j]) {
				case "INS": arrCol[j] = "I"; break;
				case "UPD": arrCol[j] = "U"; break;
				case "DEL": arrCol[j] = "D"; break;
				default:    arrCol[j] = "R"; break;
				}
			}

			arrCol[j] = arrSave[j]+"="+arrCol[j];
		}

		arrStr[i] =  arrCol.join("&");
	} 

	return  arrStr.join("&");
}


/** Copy&Paste시 입력문자 제약유지 기능, 멀티콤보에 숫자만 입력 가능하게 수정
 *  combo1_OnKeyDown()에서 호출
 *  @param allowedPattern : 영문대문자(A), 영문소문자(a), 숫자(0), 한글(가)
 *  	-> 영문대문자 및 숫자 입력 가능 : "A|0"    ('|' 로 연결)	
 *  	-> 영문대소문자, 한글 입력 가능 : "A|a|가" ('|' 로 연결)	
 */ 
function gf_SetComboPastePattern(comboObj, KeyCode, Shift, allowedPattern){

	if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
		comboObj.Style = 0;		//Enabled
		return;
	}
	
	var ok = true;
	allowedPattern = "|" + allowedPattern + "|";
	var ENG_CAPITAL = allowedPattern.indexOf("|A|")  > -1 ? true : false;
	var ENG_SMALL 	= allowedPattern.indexOf("|a|")  > -1 ? true : false;
	var DIGIT 		= allowedPattern.indexOf("|0|")  > -1 ? true : false;
	var HANGUL 		= allowedPattern.indexOf("|가|") > -1 ? true : false;

	if(Shift == 2){		//KeyCode와 동시에 Ctrl키를 누른 경우	
		var val = window.clipboardData.getData('Text');	//ClipBoard
		for(i=0; i<val.length; i++){
			if(val.charCodeAt(i) >= 65 && val.charCodeAt(i) <= 90){					//영대문자
				ok = ENG_CAPITAL;
			} else if(val.charCodeAt(i) >= 97 && val.charCodeAt(i) <= 122){			//영소문자
				ok = ENG_SMALL;
			} else if(val.charCodeAt(i) >= 48 && val.charCodeAt(i) <= 57){			//숫자
				ok = DIGIT;
			} else if(val.charCodeAt(i) >= 44032 && val.charCodeAt(i) <= 55203){	//한글
				ok = HANGUL;
			} else{
				ok = false;
			}
			
			if(ok == false){
				break;
			}
		}
	} else{				//KeyCode만 누른 경우	
		if(DIGIT && !ENG_CAPITAL && !ENG_SMALL && !HANGUL){		//오직 숫자만 입력받는 경우 (IBCombo 자체에 숫자만 입력받는 기능이 없으므로, 나머지 제약은 AXON 이용)
			if((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105)){
				ok = DIGIT;
			} else{
				ok = false;
			}
		}
	}	
	
	if(ok == true){
		comboObj.Style = 0;		//Enabled
	} else{			
		comboObj.Style = 1;		//Disabled
	}	
}

/** Copy&Paste, Drag&Drop시 입력문자 제약유지 기능, 일반 HTML Controls
 *  obj_paste() and obj_drop()에서 호출
 *  @param allowedPattern : 영문대문자(A), 영문소문자(a), 숫자(0), 한글(가)
 *  	-> 영문대문자 및 숫자 입력 가능 : "A|0"    ('|' 로 연결)	
 *  	-> 영문대소문자, 한글 입력 가능 : "A|a|가" ('|' 로 연결)	
 */ 
function gf_SetControlPastePattern(event, allowedPattern){
	
	var ok = true;
	allowedPattern = "|" + allowedPattern + "|";
	var ENG_CAPITAL = allowedPattern.indexOf("|A|")  > -1 ? true : false;
	var ENG_SMALL 	= allowedPattern.indexOf("|a|")  > -1 ? true : false;
	var DIGIT 		= allowedPattern.indexOf("|0|")  > -1 ? true : false;
	var HANGUL 		= allowedPattern.indexOf("|가|") > -1 ? true : false;
	
	var val = "";
	if(event.type == "paste"){
		val = window.clipboardData.getData('Text');	//ClipBoard
	} else if(event.type == "drop"){
		val = event.dataTransfer.getData("Text");	//Drag & Drop
	}
	
	for(i=0; i<val.length; i++){
		if(val.charCodeAt(i) >= 65 && val.charCodeAt(i) <= 90){					//영대문자
			ok = ENG_CAPITAL;
		} else if(val.charCodeAt(i) >= 97 && val.charCodeAt(i) <= 122){			//영소문자
			ok = ENG_SMALL;
		} else if(val.charCodeAt(i) >= 48 && val.charCodeAt(i) <= 57){			//숫자
			ok = DIGIT;
		} else if(val.charCodeAt(i) >= 44032 && val.charCodeAt(i) <= 55203){	//한글
			ok = HANGUL;
		} else{
			ok = false;
		}
		
		if(ok == false){
			break;
		}
	}
	
	event.returnValue = ok;
}	

 
/*
 * 입력가능 문자열 체크
 */ 
function gf_CheckString(val, allowedPattern){
		
	var ok = true;
	allowedPattern = "|" + allowedPattern + "|";
	var ENG_CAPITAL = allowedPattern.indexOf("|A|")  > -1 ? true : false;
	var ENG_SMALL 	= allowedPattern.indexOf("|a|")  > -1 ? true : false;
	var DIGIT 		= allowedPattern.indexOf("|0|")  > -1 ? true : false;
	var HANGUL 		= allowedPattern.indexOf("|가|") > -1 ? true : false;
	
	for(i=0; i<val.length; i++){
		if(val.charCodeAt(i) >= 65 && val.charCodeAt(i) <= 90){					//영대문자
			ok = ENG_CAPITAL;
		} else if(val.charCodeAt(i) >= 97 && val.charCodeAt(i) <= 122){			//영소문자
			ok = ENG_SMALL;
		} else if(val.charCodeAt(i) >= 48 && val.charCodeAt(i) <= 57){			//숫자
			ok = DIGIT;
		} else if(val.charCodeAt(i) >= 44032 && val.charCodeAt(i) <= 55203){	//한글
			ok = HANGUL;
		} else{
			ok = false;
		}
		
		if(ok == false){
			break;
		}
	}
	
	return ok;
}

/*
 * VVD Copy&Paste
 */  
function gf_PasteVVD(event, vslObj, voyObj, dirObj){
	var vsl_cd     = "";
	var skd_voy_no = "";
	var skd_dir_cd = "";
	var clipboard  = "";
	var srcObj = event.srcElement;

	if(event.type == "paste"){
		clipboard = window.clipboardData.getData('Text');	//ClipBoard
	}
	
	if(clipboard != ""){
		//Vessel
		if(srcObj == vslObj){
			vsl_cd 	   = clipboard.substr(0, 4);
			skd_voy_no = clipboard.substr(4, 4);
			skd_dir_cd = clipboard.substr(8, 1);

			if(gf_CheckString(vsl_cd, "A|0") == true && vsl_cd != ""){
				vslObj.value = vsl_cd;
			} else{
				event.returnValue = false;
			}
			
			if(gf_CheckString(skd_voy_no, "0") == true && skd_voy_no != ""){
				voyObj.value = skd_voy_no;
			} else{
				event.returnValue = false;
			}
			
			if(gf_CheckString(skd_dir_cd, "A") == true && skd_dir_cd != ""){
				dirObj.value = skd_dir_cd;
			} else{
				event.returnValue = false;
			}
		//Voyage		
		} else if(srcObj == voyObj){
			skd_voy_no = clipboard.substr(0, 4);
			skd_dir_cd = clipboard.substr(4, 1);
			
			if(gf_CheckString(skd_voy_no, "0") == true && skd_voy_no != ""){
				voyObj.value = skd_voy_no;
			} else{
				event.returnValue = false;
			}
			
			if(gf_CheckString(skd_dir_cd, "A") == true && skd_dir_cd != ""){
				dirObj.value = skd_dir_cd;
			} else{
				event.returnValue = false;
			}
		//Direction
		} else if(srcObj == dirObj){
			skd_dir_cd = clipboard.substr(0, 1);
			
			if(gf_CheckString(skd_dir_cd, "A") == true && skd_dir_cd != ""){
				dirObj.value = skd_dir_cd;
			} else{
				event.returnValue = false;
			}
		}
	}
}

/*
 * sleep
 * @param msecs : milli sec 
 */
function gf_Sleep(msecs){
	var start = new Date().getTime();
	var cur = start;
	while(cur - start < msecs){
		cur = new Date().getTime();
	}
}

/**
 * HeaderCheckbox in Sheet 초기화
 *
 * @param {ibsheet}     sheetObj  필수, IBSheet Object ID
 * @param {string}  	rows      필수, Header가 2행 이상이면 "0,1" -> comma로 구분
 * @param {int,string}  col       필수, 대상이 되는 기준 컬럼의 인덱스 또는 SaveName
 * @return
 */
function gf_SetHeadCheck(sheetObj, rows, col){

	if(typeof(sheetObj) == "string"){ 
		sheetObj = eval(sheetObj);
	}
		
	var chkFlag = (sheetObj.RowCount == 0 || sheetObj.FindText(col, "0") > -1) ? false : true;	//DataRow가 없거나, Unchecked행이 있으면 false
	rows = ComTrim(rows);
	if(rows != ""){
		var arrRow = rows.split(",");
		for(i=0; i<arrRow.length; i++){
			sheetObj.HeadCheck(arrRow[i], col) = chkFlag;
		}
	}
} 
 
/**
 * HeaderCheckbox in All Sheets 초기화
 *
 * @param {json in array} objHeadCheck	필수 HeadCheck가 있는 sheet 정보
 * objHeadCheck = [
 *                 {"sheetObj" : "sheetObjects[0]", "rows" : "0,1", "col" : "sheet1_del_chk"}
 *                ,{"sheetObj" : "sheetObjects[1]", "rows" : "0,1", "col" : "sheet2_del_chk"}                   
 *                ,{"sheetObj" : "sheetObjects[3]", "rows" : "0",   "col" : "sheet4_del_chk"}                 
 *                ,{"sheetObj" : "sheetObjects[4]", "rows" : "0",   "col" : "sheet5_del_chk"}              
 *                ];
 */ 
function gf_SetHeadUnCheckAll(objHeadCheck){
	 
	for(i=0; i<objHeadCheck.length; i++){
		var sheetObj = eval(objHeadCheck[i].sheetObj);
		var rows     = objHeadCheck[i].rows;  
		var col      = objHeadCheck[i].col;  
				
		rows = ComTrim(rows);
		if(rows != ""){
			var arrRow = rows.split(",");
			for(j=0; j<arrRow.length; j++){
				sheetObj.HeadCheck(arrRow[j], col) = false;
			}
		}
	}
} 

/**
 * 문자가 제한된 길이를 초과하였는지 체크하는 함수
 *
 * @param  {string}   	str  		필수, 문자열
 * @param  {int}  		limit_size  필수, 제한된길이
 * @return {boolean}				제한된 길이를 초과하면 true, 그렇지않으면 false
 */
function gf_CheckOverLengthString(str, limit_size){
	
	var han_size = (escape(str)+"%u").match(/%u/g).length-1;   
	var size = (str.length + han_size); 
	
	return size > limit_size;
}