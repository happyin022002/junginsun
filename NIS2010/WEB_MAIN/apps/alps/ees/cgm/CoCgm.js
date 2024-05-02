﻿﻿/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script
프로그램개요  :
작   성   자  :
작   성   일  :
===============================================================================
*/
 
//*************** CGM START ***************//

msgs['CGM00002'] = '{?msg1} update/creation was saved successfully.';
msgs['CGM00003'] = 'Data was saved successfully.';

msgs['CGM00005'] = 'Do you want to delete {?msg1}';
msgs['CGM00006'] = '{?msg1} was deleted successfully.';


msgs['CGM10003'] = '{?msg1} is valid.';
msgs['CGM10004'] = 'Mandatory field is missing. Please enter({?msg1}).';
msgs['CGM10005'] = 'Please check the Verify Result.';

msgs['CGM10007'] = 'Please check the Status.';
msgs['CGM10008'] = 'Please select a row.';
msgs['CGM10009'] = 'Please check the {?msg1}';

msgs['CGM10011'] = 'Period exceeds maximum duration [2 years].';
msgs['CGM10012'] = 'There is no data to search.';
msgs['CGM10013'] = 'To-Be Pool is the same as Current Pool.';
msgs['CGM10014'] = 'Office Code and Yard Code do not match. Please check again.';

msgs['CGM10016'] = 'Please select a valid column.';
msgs['CGM10017'] = '{?msg1} is duplicated.';
msgs['CGM10018'] = '{?msg1} is duplicated. {?msg1}';
msgs['CGM10019'] = 'Please input less number than {?msg1}';
msgs['CGM10020'] = 'Year-Month option is invalid.';
msgs['CGM10021'] = 'Selected Lessors do not match. Please check again.';



msgs['CGM10025'] = 'Invoice No. [{?msg1}] is not found in the imported invoice file.';
msgs['CGM10026'] = 'Please save the Lessor Only data first.';
msgs['CGM10027'] = 'Please input negative amount.';
msgs['CGM10028'] = 'Office does not match. Please check again.';
msgs['CGM10029'] = 'Term does not match. Please check again.';
msgs['CGM10030'] = 'Agreement No. and Reference No. do not match. Please check again.';
msgs['CGM10031'] = 'Chassis Alias No. is duplicated. [{?msg1}]';

msgs['CGM10033'] = "The Model No. cannnot be deleted since it's still effective";

msgs['CGM10035'] = 'After-Agreement No. is the same as Current-Agreement No.';



msgs['CGM10039'] = 'Movement Reason does not match with Chassis In/Out Status. Please check again.';
msgs['CGM10040'] = 'The equipment is already in Attached status.';
msgs['CGM10041'] = 'Currency code is invalid. [{?msg1}]';
msgs['CGM10042'] = 'To-date must be greater than From-date.';

msgs['CGM10044'] = '{?msg1}  lacks or exceeds field length.';
msgs['CGM10045'] = 'The equipment is already in Detached status.';

msgs['CGM10047'] = 'Data was changed. Do you want to save it?';

msgs['CGM10049'] = 'Invoice Reference No. [{?msg1}] is not found in the imported invoice file.';
msgs['CGM10050'] = 'RCV Date cannot be earlier than Issue Date.';
msgs['CGM10051'] = 'Do you want to delete the {?msg1}?';
msgs['CGM10052'] = "You can't delete the Specification No. with registered Equipment.";


msgs['CGM10055'] = "Found Date cannot be earlier than Lost/TLL Date.";
msgs['CGM10056'] = "Lost Date cannot be earlier than the last Status.";
msgs['CGM10057'] = "Lost Date cannot be earlier than the last Status or Movement.";
msgs['CGM10058'] = "Lost/Found Date cannot be later than the Current Date.";
msgs['CGM10059'] = "Inputted Event Date cannot be later than the Current Date.";
msgs['CGM10060'] = "Inputted Event Date cannot be earlier than the last Event Date. ([{?msg1}])";

msgs['CGM10062'] = "On-Hire Date cannot be later than the Current Date.";
msgs['CGM10063'] = "Yard Code and current Location do not match. Please check again.";
msgs['CGM10064'] = "Only the last row can be deleted.";

msgs['CGM10065'] = "You can't input Own Chassis {?msg1} for Leased Chassis On-Hire.";
msgs['CGM10066'] = "You can't input Leased Chassis {?msg1} for Own Chassis On-Hire.";
msgs['CGM10067'] = "You can't input Leased M.G.Set {?msg1} for Own M.G.Set On-Hire.";
msgs['CGM10068'] = "You can't input Own M.G.Set {?msg1} for Leased M.G.Set On-Hire.";
msgs['CGM10069'] = "Off-Hire Date cannot be later than the Current Date.";
msgs['CGM10070'] = "You can't delete the Type/Size with registered Equipment. Please contact system manager for any change.";

msgs['CGM10072'] = "Please check the Agreement Effective Date [{msg1} ~ {msg1}]. !";
msgs['CGM10073'] = "Inputted Agreement [{msg1}] has no Rental Rate for the Chassis/M.G.Set Type/Size [{msg1}].";
msgs['CGM10074'] = "From-Date does not match. Please check again.";
msgs['CGM10075'] = "Inputted On-Hire Month has Charge-Creation History. Please check the On-Hire Date again /or/ cancel the Charge-Creation History if necessary.";
msgs['CGM10076'] = "The Inputted Chassis No. is not registered or not active! Do you want to save?";
msgs['CGM10077'] = "The Inputted M.G. Set No. is not registered or not active.";
msgs['CGM10078'] = "Inputted Chassis/M.G.Set is attached to another Container.";
msgs['CGM10079'] = "Please save the date first.";
msgs['CGM10080'] = "Please input remarks for the change.";
msgs['CGM10081'] = "Please check the attached file. Attached file should be CSV,XLS,ZIP.";
msgs['CGM10082'] = "Attached file exceeds maximum size [50MB].";
msgs['CGM10083'] = "You can't delete a file in process.";
msgs['CGM10084'] = "Please check input date/time.";
msgs['CGM10085'] = "Do you want to fix the actual amount?";

msgs['CGM10086'] = 'Invoice no {?msg1} is duplicated. Please input another number.';

msgs['CGM10087'] = '{?msg1} :  Date format is wrong';
msgs['CGM10088'] = 'From date must be earlier than To date.';

msgs['CGM20003'] = 'Equipment is not found.';
msgs['CGM20004'] = 'Chassis/M.G.Set No. [{?msg1}] is duplicated.';

msgs['CGM20007'] = "Agreement No. ({?msg1}) doesn't exist. ";

msgs['CGM20010'] = 'Type/Size [{?msg1}] is duplicated. ';
msgs['CGM20011'] = 'Specification [{?msg1}] is duplicated.';

msgs['CGM20014'] = 'Selected Pool Code is assigned to other Agreement No. [{?msg1}].';
msgs['CGM20015'] = 'Please check the current status [{?msg1}].';
msgs['CGM20016'] = "You can't delete the Agreement with registered Equipment.";

msgs['CGM20023'] = '[{?msg1}] doesn\'t exist.';
msgs['CGM20024'] = 'Reference No. and SML Agreement No. do not match. Please check again.';
msgs['CGM20025'] = 'The Invoice No. already exists.';
msgs['CGM20026'] = 'You cannot change or delete Agreement Version with Charge-Creation History. Please check Rate Effective Date of the Version again. ';

msgs['CGM20028'] = 'Detach Container Not Found!';
msgs['CGM20029'] = 'Inputted Container is attached to another Chassis.';
msgs['CGM20030'] = 'Chassis and Container Type/Size do not match. Please check again.';
msgs['CGM20031'] = 'Unexpected system error took place during data processing. Please try again later.';
msgs['CGM20032'] = 'ALPS system error took place. Please contact system manager.';
msgs['CGM20034'] = "You can't correct or delete the data created 180 days ago.";
msgs['CGM20035'] = ' Inputted Container/Chassis is attached to another M.G.Set [{?msg1}].';

msgs['CGM20036'] = 'Unexpected system error took place during data processing. (check the file size.(5MB))';

msgs['CGM20037'] = 'BackEndJob Request Fail!';
msgs['CGM20038'] = 'It was already created. Please check it again.';

msgs['CGM20039'] = 'Please input Effective Date !';
msgs['CGM20040'] = 'Please input Expire Date !';
msgs['CGM20041'] = 'Expire date should be greater than effective date !';
msgs['CGM20042'] = '{?msg1} is invalid.\n';
msgs['CGM20043'] = 'You can input 6 letters only ! : {?msg1}\n';
msgs['CGM20044'] = 'S/N Range is incorrect. \nPlease check S/N Range again.\n';
msgs['CGM20045'] = 'Load Excel is completed successfully.';
msgs['CGM20046'] = 'Invalid data is existed.';
msgs['CGM20047'] = 'Do you want to audit the invoice?';
msgs['CGM20048'] = 'Please input End Date.';
msgs['CGM20049'] = 'Inserted Data is not able to move';
msgs['CGM20050'] = 'You can not delete the row from Discrepancy or Invoice Only.';
msgs['CGM20051'] = 'You can not delete as the invoice is already confirmed.';
msgs['CGM20052'] = 'You can confirm only received Invoice. Please check the status.';
msgs['CGM20053'] = '"{?msg1}" status can not be deleted. Please check the status.';
msgs['CGM20054'] = 'Red row indicates validation error. Please check again.\n';
msgs['CGM20055'] = 'Red row indicates save error. Please check again.\n';
msgs['CGM20056'] = 'Version status has changed. Please click {?msg1} button';
msgs['CGM20057'] = 'There are no data to {?msg1}';
msgs['CGM20058'] = 'There is no changed data';
msgs['CGM20059'] = "S/C party can't be inputted here";
msgs['CGM20060'] = 'Pls recheck Seq. {?msg1}. Duplicate data Found! {?msg2}';
msgs['CGM20061'] = 'Do you want to update the data?';
msgs['CGM20062'] = 'Do you want to update to the new version?';
msgs['CGM20063'] = "Failed to {?msg1}. Please try it again.";
msgs['CGM20064'] = 'Will you delete this version?';
msgs['CGM20065'] = 'Data was {?msg1} successfully.';
msgs['CGM20066'] = 'Do you want to {?msg1}?';
msgs['CGM20067'] = 'Data was changed. Do you want to close without saving it?';
msgs['CGM20068'] = 'Pls select one row';
msgs['CGM20069'] = 'Data will be replaced. Do you want to copy?';
msgs['CGM20070'] = 'Same version cannot be copied!';
msgs['CGM20071'] = 'Pls recheck Seq. {?msg1}. Can not select specific type or code when [ALL] is selected at {?msg2}';
msgs['CGM20072'] = 'New S/C Proposal is not amended yet. Please Amend the proposal first.';
msgs['CGM20073'] = 'Effective Date must be earlier than Expire Date.';
msgs['CGM20074'] = 'Please Insert SCC Code at Line {?msg1}';
msgs['CGM20075'] = 'Please Insert Effective Date';
msgs['CGM20076'] = 'There is invoice already imported. Do you want import another invoice?';
msgs['CGM20077'] = 'Please Insert S/C No or Proposal No.';
msgs['CGM20078'] = 'Maximum Period is 12 Months';
msgs['CGM20079'] = '{?msg1} should be same or later than {?msg2}.';

msgs['CGM20080'] = 'Please enter {?msg1} in either English letters or numbers.';
msgs['CGM20081'] = 'At least one row needs to be selected. ';
msgs['CGM20082'] = 'Please check the period.';
msgs['CGM20083'] = '{?msg1} has been duplicated. ';

msgs['CGM20084'] = 'Invalid SCC Code: {?msg1}';         
msgs['CGM20085'] = 'Maximum Period is {?msg1}.';        
msgs['CGM20086'] = '{?msg1} is one select!.';              

msgs['CGM20087'] = 'Can not use "Row Copy" button when no rows in list.';
msgs['CGM20089'] = 'The selected agreement has a newer version. Are you sure to create invoice using the outdated version?';



// Common Code Type 관련 전역변수
var COM_CD_TYPE_CD01948 = "CD01948";	// Lease Term
var COM_CD_TYPE_CD02117 = "CD02117";	// Location
var COM_CD_TYPE_CD01940 = "CD01940";	// TYPE/SIZE
var COM_CD_TYPE_CD01946 = "CD01946";	// REASON
var COM_CD_TYPE_CD01863 = "CD01863";	// REASON
var COM_CD_TYPE_CD02355 = "CD02355";	// OPTION
var COM_CD_TYPE_CD03300 = "CD03300";	// CHASSIS COP INVOICE TYPE CODE

// Comon Validation Result Value
var COM_VALIDATION_TRUE  = "TRUE";
var COM_VALIDATION_FALSE = "FALSE";

// Chassis, Mgset 구분코드
var EQ_KND_CD_CHASSIS	= "Z";
var EQ_KND_CD_MGSET		= "G";

// 버튼 사용여부 Style 정의
var BTN_ENABLE 	= "btn1";
var BTN_DISABLE = "btn1_1";

/* Sheet Select Back Color */
var CGM_SELECT_BACK_COLOR = 10092543;

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
 * <b>Example :</b>
 *
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
 *
 * </pre>
 *
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} codeCol 필수, Combo의 Code컬럼명.
 * @param {string} textCol 필수, Combo의 Text컬럼명. (구분자 '|')
 * @param {string} separator 선택, 구분자
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
 * @author 김창식
 * @version 2009.06.02
 */
function ComCgmXml2ComboString(xmlStr, codeCol, textCol, separator) {

	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}

		var textColList = textCol.split("|");
		var textIdx = 0;

		var colListIdx = Array();
		var textListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {

			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}

			for(var k=0; k < textColList.length; k++){
				if (colArr[i] == textColList[k]) {
					textListIdx[textIdx] = i;
					textIdx = textIdx + 1;
				}
			}
		}

		var sCode = "";
		var sText = "";
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			sCode += arrData[colListIdx[0]];

			for(var m=0; m < textListIdx.length; m++){
				sText += arrData[textListIdx[m]];

				if (m != textListIdx.length - 1) {
					sText += separator;
				}
			}

			if (i != dataChildNodes.length - 1) {
				sCode += "|";
				sText += "|";
			}
		}

		rtnArr.push(sCode);
		rtnArr.push(sText);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

function ComCgmNullToBlank(sStr){
	if( sStr==null || sStr=='null' || sStr=='undefined' || sStr==undefined || typeof sStr=='undefined'){
		return '';
	} else {
		return sStr;
	}
}

function ComCgmNullToZero(sStr){
	if( sStr==null || sStr=='null' || sStr=='' || sStr=='undefined' || sStr==undefined || typeof sStr == 'undefined'){
		return '0';
	} else {
		return sStr;
	}
}

function ComCgmMakeMultiCombo(cmbObj, sCode, sText, sOpt){
	var arrCode = sCode.split("|");
	var arrText = sText.split("|");

	cmbObj.RemoveAll();

	if(sOpt==0){
		for(var i=0; i<arrCode.length; i++){
			cmbObj.InsertItem(i, arrText[i], arrCode[i]);
		}
	} else {
		cmbObj.InsertItem(0,"","");
		for(var i=0; i<arrCode.length; i++){
			cmbObj.InsertItem(i+1, arrText[i], arrCode[i]);
		}
		cmbObj.Index2 = "" ;
	}


}

function ComCgmInitObject(obj,val) {
	alter(val);
    try {
        switch( obj.type ) {
            case "select-one" :
                 obj.selectedIndex='0';
            case "radio" :
            case "checkbox" :
                 obj.checked=false;
                 break;
            case "text" :
            case "password" :
                 obj.value="";
                 break;
            default:
        } // end switch
    } catch(err) { ComFuncErrMsg(err.message); }
}

function ComCgmSetObjectValue(obj,val) {
	try {
        switch( obj.type ) {
            case "select-one" :
                 obj.selectedIndex='0';
            case "radio" :
            case "checkbox" :
            	 if(val==undefined){
            		 obj.checked=true;
            	 } else {
            		 obj.checked=val;
            	 }
                 break;
            case "text" :
            case "password" :
            case "hidden" :
            	 if(val==undefined){
            		 obj.value= "";
            	 } else {
            		 obj.value= val;
            	 }
                 break;
            default:
        } // end switch
    } catch(err) { ComFuncErrMsg(err.message); }
}


function ComCgmEnableObject(obj, bEnable, sStyle)
{
   try {
   	   //disabled나 readOnly 설정하기
       switch( obj.type ) {
           case "password" :
           case "text" :
           case "textarea":
        	   obj.readOnly = !bEnable;
               break;
           default:
               obj.disabled = !bEnable;
       }

		//설정에 따라 css 처리하기
       switch( obj.type ) {
           case "select-one" :
           case "text" :
               if (bEnable){
            	   if(sStyle == undefined){
            		   obj.className = "input";    //흰색바탕
            	   } else {
            		   obj.className = sStyle;
            	   }
               } else {
            	   if(sStyle == undefined){
            		   obj.className = "input2";   //회색바탕
            	   } else {
            		   obj.className = sStyle;
            	   }
               }
               break;

           case "textarea":
               if (bEnable){
            	   if(sStyle == undefined){
            		   obj.className = "textarea";
            	   } else {
            		   obj.className = sStyle;
            	   }
               } else {
            	   if(sStyle == undefined){
            		   obj.className = "textarea2";
            	   } else {
            		   obj.className = sStyle;
            	   }
               }
               break;

			default :
               if (obj.tagName=="IMG") {
                   if (bEnable){
                       obj.style.cursor = "hand";
                       obj.style.filter="";
                   } else {
                       obj.style.cursor = "default";
                       obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                   }
               }
       }

   } catch(err) { ComFuncErrMsg(err.message); }
}

/**
* Action 버튼의 활성/비활성 여부를 가져온다. <br>
* @param  {String} srcName	필수
* @return 사용여부 true/false
* @author 김창식
* @version 2009.06.10
*/
function ComCgmIsActionButtonEnable (srcName){
	 var btnObj = document.getElementById(srcName);

	 if(btnObj.className == BTN_ENABLE){
		 return true;
	 } else {
		 return false;
	 }

}

/**
* Action 버튼의 활성/비활성 여부를 가져온다. <br>
* @param  sheetObj	필수
* @param  TrimComma	필수
* @param  Status	필수
* @author 김창식
* @version 2009.10.20
*/
function ComCgmGetAllSaveText(sheetObj,TrimComma,Status){
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

/**
* 통화숫자 format 형식으로 반환한다. (예:11,222,333.00) <br>
* @param  amount	필수		통화량
* @param  pointLen	필수		소수점 자리수
* @param  Status	필수
* @author 김창식
* @version 2009.10.20
*/
function ComCgmAmountFormat(amount, pointLen){

	var amount = ComReplaceStr(String(ComRound(amount,2)),',','');

	if(amount.indexOf('.') == -1){
		amount += ".";
	}
	amount += "00";

	var pointIdx = amount.indexOf('.');
	amount = amount.substring(0, pointIdx) + "." + amount.substring(pointIdx + 1, pointIdx + pointLen + 1);
	amount = ComAddComma(amount);

	return amount;
}

/**
* IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
* 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
* 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
* bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
* <br><b>Example :</b>
* <pre>
*     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
* </pre>
* @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
* @param {bool}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
* @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
* @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
* @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
* @return string,Sheet의 데이터를 조회XML로 구성한 문자열
*/
function ComCgmMakeSearchXml(sheet_obj, col, saveColName, bRowDel)  {
    try {
        //함수 인자 유효성 확인
        if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
            ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
            return "";
        }

        var allXml = "";
        var sColSep = "^|^";
        var sColOrder = "";
        if (saveColName!=undefined && saveColName != null && saveColName!="") {
            sColOrder = " COLORDER='" + saveColName + "' ";
        }

        allXml = "<?xml version='1.0'  ?>\n"
               + "<SHEET>\n"
                  allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
            if(col != ""){
                var findRows = sheet_obj.FindCheckedRow(col);
                if(findRows != ""){
                    findRows = findRows.substring(0, findRows.length-1); //맨끝의 "|"제거
                    var arrRow = findRows.split("|");
                    var arrCol = saveColName.split("|");

                    var aryTR  = new Array(arrRow.length);
                    var aryTD = new Array(arrCol.length);
                    for(var ir = 0; ir<arrRow.length; ir++){
                        for(var ic = 0; ic<arrCol.length; ic++){
                            //TD-셀의 값을 변수에 저장한다.
                            if(arrCol[ic]=='ibflag'){
                            	aryTD[ic] = "I";
                            } else {
                            	aryTD[ic] = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
                            }
                        }
                        aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                    }
                    if (bRowDel) {
                    	//sheet_obj.Redraw = false;
                    	//sheet_obj.RedrawSum = false;
                        for(var ir = arrRow.length-1; ir>=0; ir--){
                            sheet_obj.RowDelete(arrRow[ir],false);
                        }
                    	//sheet_obj.RedrawSum = true;
                    	//sheet_obj.Redraw = true;
                    }
                    allXml += aryTR.join("\n");
                }
            }

        allXml += "  </DATA>\n"
               +  "</SHEET>";

        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
* IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
* 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
* 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
* bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
* <br><b>Example :</b>
* <pre>
*     sXml = ComMakeSearchXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
* </pre>
* @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
* @param {bool}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
* @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
* @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
* @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
* @return string,Sheet의 데이터를 조회XML로 구성한 문자열
*/
function ComCgmMakeSearchXml2(sheet_obj, col, saveColName, bRowDel, status)
{
    try {
        //함수 인자 유효성 확인
        if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT")
        {
            ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
            return "";
        }

        var allXml = "";
        var sColSep = "^|^";
        var sColOrder = "";
        if (saveColName!=undefined && saveColName != null && saveColName!="")
        {
            sColOrder = " COLORDER='" + saveColName + "' ";
        }

        allXml = "<?xml version='1.0'  ?>\n"
               + "<SHEET>\n"
                  allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
            if(col != "")
            {
                var findRows = sheet_obj.FindCheckedRow(col);
                if(findRows != "")
                {
                    findRows = findRows.substring(0, findRows.length-1); //맨끝의 "|"제거
                    var arrRow = findRows.split("|");
                    var arrCol = saveColName.split("|");

                    var aryTR  = new Array(arrRow.length);
                    var aryTD = new Array(arrCol.length);
                    for(var ir = 0; ir<arrRow.length; ir++)
                    {
                    	if(sheet_obj.cellValue(arrRow[ir],"lse_chg_aud_sts_cd")==status
                    			|| (sheet_obj.cellValue(arrRow[ir],"lse_chg_aud_sts_cd")=="" && status == "I") // chungpa 20100105 null status도 추가함.
                    			)
                    	{
	                        for(var ic = 0; ic<arrCol.length; ic++)
	                        {
	                            //TD-셀의 값을 변수에 저장한다.
	                            if(arrCol[ic]=='ibflag')
	                            {
	                            	aryTD[ic] = "U";
	                            } else
	                            {
	                            	if(sheet_obj.CellValue(arrRow[ir], arrCol[ic]) != null) //chungpa 20100105 null status도 추가함.
	                            		aryTD[ic] = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
	                            	else
	                            		aryTD[ic] = "";
	                            }
	                        }
	                        aryTR[ir] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                    	}
                    }
                    if (bRowDel)
                    {
                    	//sheet_obj.Redraw = false;
                    	//sheet_obj.RedrawSum = false;
                        for(var ir = arrRow.length-1; ir>=0; ir--)
                        {
                        	if(sheet_obj.cellValue(arrRow[ir],"lse_chg_aud_sts_cd")==status
                        		|| (sheet_obj.cellValue(arrRow[ir],"lse_chg_aud_sts_cd")=="" && status == "I") // chungpa 20100105 null status도 추가함.
                        		)
                        	{
                        		sheet_obj.RowDelete(arrRow[ir],false);
                        	}
                        }
                    	//sheet_obj.RedrawSum = true;
                    	//sheet_obj.Redraw = true;
                    }
                    allXml += aryTR.join("\n");
                }
            }

        allXml += "  </DATA>\n"
               +  "</SHEET>";
        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}


//--------------------------------------------------------
//시트 관련   chungpa 20091229 for Default Operation.
//-------------------------------------------------------

/**
* Vo List를 array[array[name]]형태로 변환
* @param {xml} xmlStr 조회 결과 (SC에서 setRsVoList , setRsVo 호출시)
*/
function ComCgmXml2ListMap(xmlStr) {

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

		if (total == 0) {
			return rtnArr;
		}

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
* XML에서 컬럼명에 해당하는 값 가져옴
*/
function DomXml2String(xmlStr, colName) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (colName == null || colName == "") {
		return;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}
		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == colName) {
				colListIdx[0] = i;
			}
		}
		var sName = new Array();
		var cnt = 0;
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			sName[cnt++] = arrData[colListIdx[0]];
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return sName;
}

/** 
* Combo Object 에 값을 추가하는 처리 <br>
* @param  {object} cmbObj	필수 Combo Object
* @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
* @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
* @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
* @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
* @return 없음
* @author 김창식
* @version 2009.07.16
*/ 
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();
	
	if(opt == 0) {
		for (var i = 0; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
   		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
       }
	} else if(opt == 1){
		cmbObj.InsertItem(0,"","");
		for (var i = 0; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
   		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
       }
	}
	
	cmbObj.Index2 = "" ;
}

/**
* Effective Date Validation 처리 부분<br>
*/
function checkEffectiveDate( eff_dt , exp_dt ) {
	/* Effective Date Validation(eff_dt) */
	if( ComGetObjValue(eff_dt) == "" ) {
		ComShowCodeMessage("LSE01010");
		ComSetFocus(eff_dt);
		return false;
	} else if ( !ComIsDate(eff_dt) ) {
		ComShowCodeMessage("LSE01020");
		ComSetObjValue(eff_dt,"");
		ComSetFocus(eff_dt);
		return false;
	}

	/* Effective Date Validation(exp_dt) */
	if( ComGetObjValue(exp_dt) == "" ) {
		ComShowCodeMessage("LSE01011");
		ComSetFocus(exp_dt);
		return false;
	} else if ( !ComIsDate(exp_dt) ) {
		ComShowCodeMessage("LSE01026");
		ComSetObjValue(exp_dt,"");
		ComSetFocus(exp_dt);
		return false;
	}

	/* Effective Date Validation(eff_dt < exp_dt) */
	var vEffDt = ComReplaceStr(ComGetObjValue(eff_dt),"-","");
	var vExpDt = ComReplaceStr(ComGetObjValue(exp_dt),"-","");
	if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
		ComShowCodeMessage("LSE01051");
		ComSetObjValue(exp_dt,"");
		ComSetFocus(exp_dt);
		return false;
	}

	return true;
}

/**
 * 멀티선택 팝업호출
 * @param	{window.event.srcElement.getAttribute("name")}	값을 넘겨 받을 input 명
 * @author 박명신
 * @version 2009.05.27
 * @see #ees_mnr_0122.js
 *
 * 1) 부모 js에서 getCgm_Multi 구현 샘플
 * function getCgm_Multi(rowArray,return_val) {
 *		var formObj = document.form;
 *		var tempText = "";
 *		//초기화
 *		eval("document.form." + return_val + ".value = '';");
 *		for(var i=0; i<rowArray.length; i++) {
 *			tempText +=  rowArray[i] + ',';
 *		}
 *		//마지막에 ,를 없애기 위함
 *		if (tempText != "")
 *	        tempText = tempText.substr(0, tempText.length -1);
 *
 *		eval("document.form." + return_val + ".value = '" + tempText + "';");
 *	}
 * 2) DAO에서 ,넘어온 값을 처리 샘플
 * List<String> tpszCds = new ArrayList();
 * String[] arrYdCd =  eQFlagListINVO.getEqTpszCd().split(",");
 * for(int i = 0; i < arrYdCd.length; i ++){
 * 	tpszCds.add(arrYdCd[i]);
 * }
 * velParam.put("tpszCds", tpszCds);
 *
 * 3) 쿼리문중 foreach 샘플
 *
 * #if (${tpszCds} != '')
 * 	AND	A.EQ_TPSZ_CD IN (
 * 		#foreach ($user_tpszCds IN ${tpszCds})
 * 			#if($velocityCount < $tpszCds.size())
 * 				'$user_tpszCds',
 * 			#else
 * 				'$user_tpszCds'
 * 			#end
 * 		#end
 * 	)
 * #end
 */

function rep_Multiful_inquiry(input_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCgm_Multi";
		var xx1=input_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('EES_CGM_MULTI.do' + param, 400, 330, 'getCgm_Multi', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * 반복문으로  생성된 라스트 Delim을 제거
 * ex)
 * '1,2,3,4,5,' => '1,2,3,4,5'
 * @param {String} str 		제거 대상 String
 * @return {String} str 	제거된 String
 * @author 박명신
 * @version 2009.06.04
 */
function CgmDelLastDelim(str){
	//마지막에 &를 없애기 위함
	if (str != ""){
		 str = str.substr(0, str.length - 1);
	}
	return str;
}