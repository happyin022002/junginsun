/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : CoMst.js
 *@FileTitle  : MST 공통 자바스크립트
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
=========================================================*/
if (msgs == undefined) {
	msgs = new Array(); 
}
/**
 * IBMulti Combo Item Setting param : comboObj ==> Combo Object param : arrStrNm
 * ==> Combo Item Name Array param : arrStrCd ==> Combo Item Code Array
 */

msgs['MST00001'] = 'Mandatory field is missing. Please input [{?msg1}].';
msgs['MST00002'] = 'Data {?msg1} is duplicated. Please check again.';
msgs['MST00005'] = 'Do you want to delete ?\n';
msgs['MST00009'] = 'Period is invalid.\n';
msgs['MST00010'] = 'There is no selected marking. Please check again.\n';
msgs['MST00011'] = 'Unexpected system error took place during data processing. : {?msg1}\nPlease try again.';
msgs['MST00012'] = 'There is no updated data to save.\n';
msgs['MST01003'] = 'Lease Term error. \nPlease input correct Lease Term.\n';
msgs['MST01006'] = 'Input Date should be earlier than today.\n';
msgs['MST01007'] = 'Auth No. is missing. Please input Auth No..\n';
msgs['MST01009'] = 'Container Serial Range is missing. \nPlease input Container Serial Range.\n';
msgs['MST01011'] = 'Manufacture Date is missing. \nPlease input Manufacture Date.\n';
msgs['MST01012'] = 'Please check out the Pick-Up Qty again !\n';
msgs['MST01017'] = 'Please check out the CODE.\n';
msgs['MST01018'] = 'Please select Agreement No.\n';
msgs['MST01019'] = '{?msg1} is invalid.\n';
msgs['MST01020'] = 'You can input 4 letters only ! : {?msg1}\n';
msgs['MST01021'] = 'You can input 6 letters only ! : {?msg1}\n';
msgs['MST01022'] = 'S/N Range is incorrect. \nPlease check S/N Range again.\n';
msgs['MST01025'] = 'Data was saved successfully.\n';
msgs['MST01026'] = 'Red row indicates validation error. Please check again.\n';
msgs['MST01027'] = 'Red row indicates save error. Please check again.\n';
msgs['MST01029'] = 'In case of OW, Purchase Option should be No.\n';
msgs['MST01030'] = 'Input On-Hire date is more than 90 days prior to the current date.\nPlease check again.\n';

msgs['MST02001'] = 'There is input error in indicated Row. \nPlease delete error data and input correct data.\n';
msgs['MST02002'] = 'Auth vol. is same or greater than Pick up vol.\n';
msgs['MST02003'] = 'Check digit is invalid.\n';
msgs['MST02004'] = 'Status code is invalid.\n';
msgs['MST02005'] = 'Hire date is invalid.\n';
msgs['MST02006'] = 'Container No. is duplicated.\n';
msgs['MST02007'] = 'Term code is {?msg1}. You cannot update this container.\n';
msgs['MST02008'] = 'Error occured when saving.\n';
msgs['MST02009'] = 'S/N Range already exists in container.\n';
msgs['MST02010'] = 'Container No. length error. \nPlease input 11 digit.\n';

msgs['MST02011'] = 'Yard is different from MVMT yard.\n';
msgs['MST02012'] = 'Input date should be same or later than MVMT date or Status Date.\n';
msgs['MST02013'] = 'In case of LSO, MVMT status should be MT or ID or TN.\n';

msgs['MST02014'] = 'Container No. is invalid.\n';
msgs['MST02015'] = 'Please click save button after retrieve.\n';
msgs['MST02016'] = 'Input date should be same or later than Pre ACT date.\n';
msgs['MST02017'] = 'Input date should be same or earlier than Post ACT date.\n';
msgs['MST02018'] = 'You can update only between 6 months before and current day.\n';
msgs['MST02019'] = 'Retrieve option field is missing. Please enter Cntr No. or Delivery Year or TP/SZ.\n';
msgs['MST02020'] = 'Agreement rate doesn\'t exist.\n';
msgs['MST02021'] = 'Please check data again.\n';
msgs['MST02022'] = 'MVMT status is invalid.\n';

msgs['MST02023'] = 'It is {?msg1} container list.\n If you click Save button without delete, all containers will be created automatically as {?msg2} status.';
msgs['MST02024'] = 'If you want to create specific container as {?msg1} status, you have to delete other containers from displayed List.';
msgs['MST02025'] = 'If you want to delete SH term container, please try in CNTR Movement module.';
msgs['MST02026'] = 'CNTR No. does not exist.';
msgs['MST02027'] = 'Different format is loaded. Please check again.';
msgs['MST02028'] = 'You selected {?msg1} container(s).\n Do you want to create LSO as selected container(s)?';
msgs['MST02029'] = '{?msg1}. Max length error. \nPlease input less than 1,000 digits.\n';
msgs['MST02030'] = 'TP/SZ is incorrect. \nPlease check again.\n';

msgs['MST02031'] = 'There are duplicate value of RU Label Type and Value.\n';
msgs['MST02032'] = 'Lessor doesn\'t exist.';
msgs['MST02033'] = 'If there is location information data, it will be deleted. Do you want to load Excel?';
msgs['MST02034'] = '{?msg1} label is still in use. Are you sure to delete the label?';  
msgs['MST02035'] = 'RU Label Value of "{?msg1}" is duplicated. Please check again.';
msgs['MST02036'] = 'Please enter the Container No.\n' 
msgs['MST02037'] = 'Selected TP/SZ is saved only in Master Container info. \nDo you want to continue ?'
msgs['MST02038'] ='Please input Lessor Code.';
msgs['MST02039'] ='The Lessor is invalid !  Please check again.';	
msgs['MST02040']='Please input TP/SZ !';
msgs['MST02041']='Some of Spec No. is not suitable. Please check again.';
msgs['MST02042']='Spec No.({?msg1}) is not suitable. Please check again.';
msgs['MST02043']='All containers listed will be terminated with {?msg1} status! \nIf you do not wish to update all containers, please click \'Cancel\' and make use of \'Delete\' button to remove unwanted containers.';
msgs['MST02044']='On-hire Date should fall between AGMT\'s Effective Date.';
msgs['MST02045']='Status Creation Date should fall between AGMT\'s Effective Date. ';
msgs['MST02046']='Please check today\'s date and Effective Date. ';
msgs['MST02047']='Delivery Date should fall between AGMT\'s Effective Date. ';
msgs['MST02048']='M/Facture Date should be earlier than Delivery Month. ';
msgs['MST02049']='Please input prefix in 4 digits.';
msgs['MST02050']='Newly created containers have exceeded pick-up volume. Please check again.';
msgs['MST02051']='On-hire Date should fall between Pick up Period. \nPlease check again.';
msgs['MST02052']='Input date should be same or later than Pre ACT date.\n';
msgs['MST02053']='Input date should be whithin the On/Off-Hire approval date range.\n'; 
	function MstMakeComboObject(comboObj, arrStrNm, arrStrCd) {
	var itemCnt = comboObj.GetItemCount();

		for ( var i = 0; i < arrStrCd.length; i++) {
			comboObj.InsertItem((i + itemCnt), arrStrNm[i], arrStrCd[i]);
		}
	}

/**
 * converting xml data gotten with GetSearchXml function of IBsheet <br>
 * to String connecting Combo of IBsheet(seperator : '|')<br>
 * frist array is Code, second array is Text <b>Example :</b>
 * 
 * <pre>
 * var sXml = mysheet.GetSearchXml(&quot;aaa.do&quot;);
 * var arrData = ComXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
 * 
 * </pre>
 * 
 * @param {string}
 *            xmlStr mandatory, xml
 * @param {string}
 *            codeCol mandatory, Code
 * @param {string}
 *            textCol mandatory, Text
 * @param {string}
 *            separator optional, separator
 * @return array
 */
function ComMstXml2ComboString(xmlStr, codeCol, textCol, separator) {

	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return "";
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return "";
	}

	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null)
			return;
		var xmlRoot = xmlDoc.documentElement;

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return "";
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return "";
		}

		var textColList = textCol.split("|");
		var textIdx = 0;

		var colListIdx = Array();
		var textListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {

			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}

		}

		for ( var k = 0; k < textColList.length; k++) {
			for ( var i = 0; i < colArr.length; i++) {
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

			for ( var m = 0; m < textListIdx.length; m++) {
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

/**
 * converting xml data gotten with GetSearchXml function of IBsheet <br>
 * to String connecting Combo of IBsheet(seperator : '|')<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mysheet.GetSearchXml(&quot;aaa.do&quot;);
 * var arrData = ComXmlString(xmlStr, nm);
 * 
 * </pre>
 * 
 * @param {string}
 *            xmlStr mandatory, xml
 * @param {string}
 *            Text
 * @return array Code연
 */
function ComXmlString(xmlStr, codeCol) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	if (codeCol == null || codeCol == "") {
		return rtnArr;
	}

	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null)
			return;
		var xmlRoot = xmlDoc.documentElement;

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return rtnArr;
		}

		var colListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
		}

		var sCode = "";
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			sCode += arrData[colListIdx[0]];

			if (i != dataChildNodes.length - 1) {
				sCode += "|";
			}
		}
		
		if(sCode.length > 0 &&  sCode.slice(-1) == "|"){
			sCode = sCode.substring(0,sCode.length-1)
		}
	 
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * converting xml data gotten with GetSearchXml function of IBsheet <br>
 * to String connecting Combo of IBsheet(seperator : '|')<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mysheet.GetSearchXml(&quot;aaa.do&quot;);
 * var arrData = ComXmlString(xmlStr, nm);
 * 
 * </pre>
 * 
 * @param {string}
 *            xmlStr mandatory, xml
 * @param {string}
 *            Text
 * @return array Code
 */
function ComXmlStringOfItmCnt(xmlStr, codeCol, itmcnt) {
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	if (codeCol == null || codeCol == "") {
		return rtnArr;
	}

	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null)
			return;
		var xmlRoot = xmlDoc.documentElement;

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return rtnArr;
		}

		var colListIdx = Array();
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
		}

		var sCode = "";
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			// sCode += arrData[colListIdx[0]];

			// if (i != dataChildNodes.length - 1) {
			// sCode += "|";
			// }
			if (itmcnt == i) {
				sCode = arrData[colListIdx[0]];
			}
		}
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

// ///////////////////////////////////////////////////
function getZeroToNum(xmlStr) {
	// ///////////////////////////////////////////////////
	if (xmlStr == null || xmlStr == "") {
		return 0;
	}

	return xmlStr;
}

// ///////////////////////////////////////////////////
function getRelativeTime(y, m, d, h) {
	// ///////////////////////////////////////////////////
	return shiftTime(getCurrentTime(), y, m, d, h);
}

// ///////////////////////////////////////////////////
function shiftTime(time, y, m, d, h) { // moveTime(time,y,m,d,h)
	// ///////////////////////////////////////////////////
	var date = toTimeObject(time);
	date.setFullYear(date.getFullYear() + y);
	date.setMonth(date.getMonth() + m);
	date.setDate(date.getDate() + d);
	date.setHours(date.getHours() + h);
	return toTimeString(date);
}

// ///////////////////////////////////////////////////
function toTimeObject(time) { // parseTime(time)
	// ///////////////////////////////////////////////////
	// converting Time string to Date object parameter time: Time String
	var year = time.substr(0, 4);
	var month = time.substr(4, 2) - 1; // jan=0,dec=11
	var day = time.substr(6, 2);
	var hour = time.substr(8, 2);
	var min = time.substr(10, 2);

	return new Date(year, month, day, hour, min);
}

// ///////////////////////////////////////////////////
function toTimeString(date) { // formatTime(date)
	// ///////////////////////////////////////////////////
	// converting Date object to Time string
	// parameter date: JavaScript Date Object
	var year = date.getFullYear();
	var month = date.getMonth() + 1; // jan=0,dec=11
	var day = date.getDate();
	var hour = date.getHours();
	var min = date.getMinutes();

	if (("" + month).length == 1) {
		month = "0" + month;
	}
	if (("" + day).length == 1) {
		day = "0" + day;
	}
	if (("" + hour).length == 1) {
		hour = "0" + hour;
	}
	if (("" + min).length == 1) {
		min = "0" + min;
	}

	return ("" + year + month + day + hour + min)
}

// ///////////////////////////////////////////////////
function getCurrentTime() {
	// ///////////////////////////////////////////////////
	// returning current Time
	return toTimeString(new Date());
}

// ///////////////////////////////////////////////////
function getMonthInterval(time1, time2) { // measureMonthInterval(time1,time2)
	// ///////////////////////////////////////////////////
	var date1 = toTimeObject(time1);
	var date2 = toTimeObject(time2);

	var years = date2.getFullYear() - date1.getFullYear();
	var months = date2.getMonth() - date1.getMonth();
	var days = date2.getDate() - date1.getDate();

	return (years * 12 + months + (days >= 0 ? 0 : -1));
}

// ///////////////////////////////////////////////////
function isValidDay(yyyy, mm, dd) {
	// ///////////////////////////////////////////////////
	var m = parseInt(mm, 10) - 1;
	var d = parseInt(dd, 10);

	var end = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
		end[1] = 29;
	}

	return (d >= 1 && d <= end[m]);
}

function sReplace_str(str, s1, s2) {
	for (i = 0; i < str.length; i++)
		str = str.replace(s1, s2);
	return str;
}

function ComXml2ComboItemForLHS(xmlStr, cmbObj, codeCol, textCol, gubun) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}

	try {
		cmbObj.RemoveAll();

		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null)
			return;
		var xmlRoot = xmlDoc.documentElement;

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
		var arrText = textCol.split("|");
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			for ( var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j + 1] = i;
				}
			}
		}

		for ( var i = -1; i < dataChildNodes.length; i++) {
			if (i != -1) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
			}
			var arrData;
			if (i != -1) {
				arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

				var item = "";
				for ( var j = 1; j < colListIdx.length; j++) {
					item += arrData[colListIdx[j]];
					if (j < colListIdx.length - 1) {
						item += "|";
					}
				}
			}
			if (i == -1) {
				if (gubun == 0) {
					cmbObj.InsertItem(0, 'ALL', 'ALL');
				} else {
					cmbObj.InsertItem(0, '', '');
				}
			} else
				cmbObj.InsertItem(i + 1, item, arrData[colListIdx[0]]);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * Button Enable/Disable Setting
 * param : btnNames ==> Button Names
 * param : enable   ==> true : Enable, false : Disable
 */
function MstComBtnControl(bEnable, btnNames) {
	var arrBtnName = btnNames.split("|");
	for ( var i=0 ; i < arrBtnName.length ; i++ ) {
		var btnObj =document.getElementById(arrBtnName[i]);
		ComEnableObject(btnObj ,bEnable);
	}
}


///////////////////////////////////////////////////////////////////////////////////
///////////////////////// For EES_MST_SECRETWEAPON (S) ////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

function MstQexeRun(sheetObj, sCondition) {
	var f_query='';
	// 쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH10 + '&';
	for ( var i=0; i < sCondition.length; i++) {
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'searchcon' + '=' + sCondition[i][2] + '&';
	}
	// 마지막에 &를 없애기 위함
	f_query=MstDelLastDelim(f_query);
 	var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", f_query);
	return sXml;
}

/**
 * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
 * 
 * @param {String}
 *            str 제거 대상 String
 * @return {String} str 제거된 String
 * @author 박명신
 * @version 2009.06.04
 */
function MstDelLastDelim(str) {
	// 마지막에 &를 없애기 위함
	if (str != "") {
		str=str.substr(0, str.length - 1);
	}
	return str;
}

/**
 * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 MESSAGE
 * 값을 리턴한다.
 * 
 * @param {string}
 *            xmlStr 필수,IBSheet를 통해 받아온 xml 문자열
 * @return string, MESSAGE의 값
 */
function MstComGetErrMsg(xmlStr) {
	if (xmlStr == null || xmlStr == "")
		return;
	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null)
			return;
		var msgDataNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
		if (msgDataNode == null)
			return;
		return msgDataNode.firstChild.nodeValue;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * ComXml2ComboString 를 수정
 * 
 * </pre>
 * 
 * @param {string}
 *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string}
 *            codeCol 필수, Combo의 Code컬럼명.
 * @param {string}
 *            textCol 필수, Combo의 Text컬럼명.
 * @return array Code연결 문자열과 Text연결 문자열이 담긴 배열.
 * @see #ComXml2ComboString
 * @author 박명신
 * @version 2009.05.13
 */
function MstXml2ComboString(xmlStr, codeCol, textCol) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        if (xmlRoot == null)  return;
        
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			if (colArr[i] == textCol) {
				colListIdx[1]=i;
			}
		}
		var retStr="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			retStr=arrData[colListIdx[0]] + '|' + arrData[colListIdx[1]];
			rtnArr.push(retStr);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}

function MstComSearchCombo(sheetObj, sCondition) {
	var f_query='';
	// 쿼리 스트링 조합시작
	f_query += 'f_cmd' + '=' + SEARCH10 + '&';
	for ( var i=0; i < sCondition.length; i++) {
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + sCondition[i][0] + '&';
		f_query += 'searchkey' + '=' + sCondition[i][1] + '&';
		f_query += 'searchcon' + '=' + sCondition[i][2] + '&';
	}
	// 마지막에 &를 없애기 위함
	f_query=MstDelLastDelim(f_query);
    var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", f_query);
	var arrXml=sXml.split("|$$|");
	var retValue=new Array();
	for ( var i=0; i < arrXml.length; i++) {
		retValue[i]=MstXml2ComboString(arrXml[i], "cd_id", "cd_desc");
	}
	return retValue;
}

///////////////////////////////////////////////////////////////////////////////////
///////////////////////// For EES_MST_SECRETWEAPON (E) ////////////////////////////
///////////////////////////////////////////////////////////////////////////////////