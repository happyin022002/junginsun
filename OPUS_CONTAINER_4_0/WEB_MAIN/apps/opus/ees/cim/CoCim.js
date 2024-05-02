/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoCim.js
*@FileTitle  : CIM 공통 js 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
//*************** CPR START ***************// 

	if(msgs == undefined){
		msgs = new Array();
	}
	
msgs['CIM21001'] = 'Mandatory field is missing. Please enter [{?msg1}].';
msgs['CIM21004'] = 'Date format is wrong. Please enter valid date format. [{?msg1}]';
msgs['CIM21031'] = 'Maximum period is [12 Months or 26 weeks]';
msgs['CIM21032'] = 'Maximum period is [12 Months or 52 weeks]'; 

msgs['CIM29001'] = 'Mandatory field is missing. Please enter [RCC].';
msgs['CIM29002'] = 'Please input at least one location code.';
msgs['CIM29003'] = 'End week should be later than start week.';
msgs['CIM29004'] = 'End date should be later than start date.';
msgs['CIM29005'] = 'Maximum period is [24].';
msgs['CIM29006'] = 'Please input at least one VVD.';
msgs['CIM29007'] = 'Please input at least one port code.';
msgs['CIM29008'] = '[RCC] code is invalid.';
msgs['CIM29009'] = '[Country] code is invalid.';
msgs['CIM29010'] = '[Port] code is invalid.';
msgs['CIM29011'] = '[POL] code is invalid.';
msgs['CIM29012'] = '[LANE] code is invalid.';
msgs['CIM29013'] = 'Code is invalid.';
msgs['CIM29014'] = 'Mandatory field is missing. Please enter [LCC Code].';
msgs['CIM29015'] = 'Mandatory field is missing. Please enter [ECC Code].';
msgs['CIM29016'] = 'Mandatory field is missing. Please enter [SCC Code].';
msgs['CIM29017'] = 'Mandatory field is missing. Please enter [Yard Code].';
msgs['CIM29018'] = '[LCC] code is invalid.';
msgs['CIM29019'] = '[ECC] code is invalid.';
msgs['CIM29020'] = '[SCC] code is invalid.';
msgs['CIM29021'] = '[Yard] code is invalid.';
msgs['CIM29022'] = 'Maximum Period is [3 Months or 12 weeks].';
msgs['CIM29023'] = '[VVD] code is invalid.';
msgs['CIM29024'] = '[Location] code is invalid.';
msgs['CIM29025'] = 'Maximum period is [3 Months or 12 weeks]';
msgs['CIM29026'] = 'Maximum period is [6 Months]';
msgs['CIM29027'] = 'Please input a POL code.';
msgs['CIM29028'] = '[Trade] code is invalid.';
msgs['CIM29029'] = 'Maximum period is [31 days].';
msgs['CIM29030'] = 'No data found.';
msgs['CIM29031'] = 'Invalid RCC code.';
msgs['CIM29032'] = 'Invalid LCC code.';
msgs['CIM29033'] = 'Invalid ECC code.';
msgs['CIM29034'] = 'Invalid SCC code.';
msgs['CIM29035'] = 'Invalid Port code.';
msgs['CIM29036'] = 'Invalid Yard code.';
msgs['CIM29037'] = 'Invalid Country code.';
msgs['CIM29038'] = 'Certain to Save?';
msgs['CIM29039'] = 'Certain to Delete?';
msgs['CIM29040'] = '동일한 Port_Cd가 존재합니다.';
msgs['CIM29041'] = 'Country 코드는 필수입력 입니다.';
msgs['CIM29042'] = 'BackEndJob Request Fail !';
msgs['CIM29043'] = 'Created BackEndJob File exists already!';
msgs['CIM29044'] = 'Maximum period is [3 Months or 13 weeks]';
msgs['CIM29045'] = 'U/C Flagging not allowed';
msgs['CIM29046'] = 'End year should be later than start year.';

//*************** CPR END ***************//

//*************** CIM START ***************// 
msgs['CIM00005'] = 'Do you want to delete ?\n';
msgs['CIM00008'] = 'Do you want to save ?';
msgs['CIM00010'] = 'There is no selected mark. Please check again.';
msgs['CIM00011'] = 'Unexpected system error took place during data processing. : {?msg1}\nPlease try again.';


msgs['CIM30001'] = 'Maximum period is 12 Months or 12 Weeks.';
msgs['CIM30002'] = 'Mandatory field is missing. Please enter location.';
msgs['CIM30003'] = 'Date format is wrong. Please enter valid date format(YYYY-WW).';
msgs['CIM30004'] = 'Please input at least one among Lane/ VVD/ RU Label / POL/ POD/ DEL fields.';
msgs['CIM30005'] = 'Please input at least one TP/SZ.';
msgs['CIM30006'] = '{?msg1} duplicaton occurred.';
msgs['CIM30008'] = 'There is no data to search.';
msgs['CIM30009'] = 'Total S/Days are only available when smaller than LCC Location by.';
msgs['CIM30010'] = 'Do you want to delete ?';
msgs['CIM30011'] = 'There is no selected mark. Please check again.';
msgs['CIM30013'] = '{?msg1} is invalid.';
msgs['CIM30014'] = 'Mandatory field is missing. Please enter {?msg1}';
msgs['CIM30017'] = 'Invalid location code with HAMUR.';
msgs['CIM30018'] = 'Save cannot be implemented in SCC Level';
msgs['CIM30019'] = 'Data was saved successfully.';
msgs['CIM30020'] = '{?msg1} should be same or later than {?msg2}.';
msgs['CIM30021'] = 'Invalid {?msg1} Code.';
msgs['CIM30022'] = 'Mandatory field is missing. Please input {?msg1}';
msgs['CIM30023'] = 'There is no data to search. Please check period ';
msgs['CIM30024'] = 'Please input RU label.';

msgs['CIM30025'] = 'Data was saved successfully.\n';
msgs['CIM30026'] = 'Red row indicates validation error. Please check again.\n';
msgs['CIM30027'] = 'Red row indicates save error. Please check again.\n';
msgs['CIM30028'] = 'Input Date should be earlier than today.\n';
msgs['CIM30029'] = 'Same event date Found! Please check Duplication !\n';
msgs['CIM30030'] = 'You cannot select more than {?msg1} data.';
msgs['CIM30031'] = 'This is already OK movement. \nDo you really want to delete?';
msgs['CIM30032'] = 'The service is not available now. \nPlease try again later.';
//*************** CIM END ***************//

function CimMakeRDXml(sheet_obj,no){
	  //함수 인자 유효성 확인
	  if (!sheet_obj) {
		  ComFuncErrMsg("CimMakeRDXml function sheet_obj entry in not IBSheet.");
		return "";
	  }
	  var rowXml="";
	  var allXml="<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow()+"'>";
	  var rowcount=sheet_obj.RowCount()+ sheet_obj.HeaderRows() - 1;
	  for (ir=sheet_obj.HeaderRows(); ir <= sheet_obj.LastRow(); ir++) {
		rowXml="<TR>";
		for (ic=0; ic<= sheet_obj.LastCol(); ic++) {
			rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,ic) + "]]></TD>";
		}
		rowXml += "</TR>";
		allXml += rowXml;
	  }
	  allXml += "  </DATA></SHEET" + no + ">";
	  return allXml;
}
function CimMakeRDXml2(sheet_obj,no){
	  //함수 인자 유효성 확인
	  if (!sheet_obj) {
		  ComFuncErrMsg("CimMakeRDXml2 function sheet_obj entry in not IBSheet.");
			return "";
	  }
	  var rowXml="";
	  var allXml="<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow()+"'>";
	  var rowcount=sheet_obj.RowCount()+ sheet_obj.HeaderRows() - 1;
	  for (ir=sheet_obj.HeaderRows(); ir <= sheet_obj.LastRow(); ir++) {
		rowXml="<TR>";
		if(sheet_obj.GetCellValue(ir,0) == "0"){
			  rowXml += "<TD><![CDATA[]]></TD>";
		  }
		  else{
			  rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,0) + "]]></TD>";
		  }
		for (ic=1; ic<= sheet_obj.LastCol(); ic++) {
			rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,ic) + "]]></TD>";
		}
		rowXml += "</TR>";
		allXml += rowXml;
	  }
	  allXml += "  </DATA></SHEET" + no + ">";
	  return allXml;
}
function CimMakeRDXml3(sheet_obj,no){
	  //함수 인자 유효성 확인
	 if (!sheet_obj) {
		  ComFuncErrMsg("CimMakeRDXml3 function sheet_obj entry in not IBSheet.");
			return "";
	  }
	  var rowXml="";
	  var allXml="<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow()+"'>";
	  for (ir=sheet_obj.HeaderRows(); ir <= sheet_obj.RowCount()+1; ir++) {
			rowXml="<TR>";
			if(sheet_obj.GetCellValue(ir,0) == "0"){
				  rowXml += "<TD><![CDATA[]]></TD>";
			  }
			  else{
				  rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,0) + "]]></TD>";
			  }
			for (ic=1; ic<= sheet_obj.LastCol(); ic++) {
				rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir,ic) + "]]></TD>";
			}
			rowXml += "</TR>";
			allXml += rowXml;
	 }
	  allXml += "  </DATA></SHEET" + no + ">";
	  return allXml;
}    
/**
* IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 MESSAGE 값을 리턴한다.
* @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
* @return  string, MESSAGE의 값
*/
function CimComGetErrMsg(xmlStr){
	return ComGetSelectSingleNode(sXml, "MESSAGE");
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
function ComCimXml2ComboString(xmlStr, codeCol, textCol, separator) {

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

		var sCode = "|";
		var sText = "|";
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
				sCode = sCode+"|";
				sText = sText+"|";
			}
		}

		rtnArr.push(sCode);
		rtnArr.push(sText);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}