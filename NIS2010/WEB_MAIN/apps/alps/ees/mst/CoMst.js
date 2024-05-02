/**
* IBMulti Combo Item Setting
* param : comboObj ==> Combo Object  
* param : arrStrNm ==> Combo Item Name Array
* param : arrStrCd ==> Combo Item Code Array
*/
msgs['MST00001'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['MST00002'] = 'Data {?msg1} is duplicated, Please check data again.';
msgs['MST00005'] = 'Do you want to delete ?\n';
msgs['MST00009'] = 'Period is invalid.\n';
msgs['MST00010'] = 'There is no selected marking, Please check again.\n';
msgs['MST00011'] = 'Unexpected system error took place during data processing. : {?msg1}\nPlease try again.';
msgs['MST00012'] = 'There is no updated data to save.\n';
msgs['MST01003'] = 'Lease Term is error. \nPlease input exact Lease Term.\n';
msgs['MST01006'] = 'Input Date must be earlier than today.\n';
msgs['MST01007'] = 'Authl No. is missing. Please input Authl No..\n';
msgs['MST01009'] = 'Container Serial Range is missing. \nPlease input Container Serial Range.\n';
msgs['MST01011'] = 'Manufacture Date is missing. \nPlease input Manufacture Date.\n';
msgs['MST01012'] = 'Please check up the Pick-Up Qty again!\n';
msgs['MST01017'] = 'Please check up the CODE.\n';
msgs['MST01018'] = 'Please select Agreement No.\n';
msgs['MST01019'] = '{?msg1} is invalid.\n';
msgs['MST01020'] = 'You can input 4 letters only ! : {?msg1}\n';
msgs['MST01021'] = 'You can input 6 letters only ! : {?msg1}\n';
msgs['MST01022'] = 'S/N Range is incorrect. \nPlease check S/N Range again.\n';
msgs['MST01025'] = 'Data was saved successfully.\n';
msgs['MST01026'] = 'Red row indicates validation error. Please check again.\n';
msgs['MST01027'] = 'Red row indicates save error. Please check again.\n';
msgs['MST01029'] = 'In case of OW. Purchase Option must be No.\n';
msgs['MST01030'] = 'Inputted On-hire Date is more than 90 days prior to the current date.\nPlease check again.\n';
msgs['MST01031'] = 'Current status is TN or EN.\nPlease update ID/MT MVMT firstly to create LSO Status.';

msgs['MST02001'] = 'There is inputted error in indicated Row. \nPlease delete error data and enter exact data.\n';
msgs['MST02002'] = 'Auth Vol. is same or later than Pick up vol.\n';
msgs['MST02003'] = 'Check digit is invalid.\n';
msgs['MST02004'] = 'Status code is invalid.\n';
msgs['MST02005'] = 'Hire Date is invalid.\n';
msgs['MST02006'] = 'Container no is duplicated.\n';
msgs['MST02007'] = 'Term Code is {?msg1}. You cannot update this CNTR.\n';
msgs['MST02008'] = 'Error occured saving.\n';
msgs['MST02009'] = 'S/N Range is error. Already exist Container.\n';
msgs['MST02010'] = 'Container No. length error. \nPlease input 11 length.\n';

msgs['MST02011'] = 'Yard is different from MVMT Yard.\n';
msgs['MST02012'] = 'Input Date should be same or later than MVMT Date.\n';
msgs['MST02013'] = 'In case of LSO, MVMT Status must be MT or ID, TN, EN.\n';

msgs['MST02014'] = 'Container No. is invalid.\n';
msgs['MST02015'] = 'Please Save Button click after retrieve.\n';
msgs['MST02016'] = 'Input Date should be same or later than Pre ACT Date.\n';
msgs['MST02017'] = 'Input Date should be same or less than Post ACT Date.\n';
msgs['MST02018'] = 'You can update only  between 6 months ago and today.\n';
msgs['MST02019'] = 'Retrieve option field is missing.  Please enter Cntr No, Delivery Year or TP/SZ.\n';
msgs['MST02020'] = 'Agreement rate not exists.\n';
msgs['MST02021'] = 'Please check data again.\n';
msgs['MST02022'] = 'MVMT Status is invalid.\n';

msgs['MST02023'] = 'It is {?msg1} container list.\n If you click SAVE Botton without deletion, All containers will be created automatically as {?msg2} Status.';
msgs['MST02024'] = 'If you want to create SPECIFIC CONTAINER, As {?msg1} Status you have to DELETE other containers from displayed List.';
msgs['MST02025'] = 'If you want to delete SH term container. you will have to try in CNTR Movement module.';
msgs['MST02026'] = 'CNTR No. is not exist.';
msgs['MST02027'] = 'Different format is loaded. Pleas check in again.';
msgs['MST02028'] = 'You selected {?msg1} container(s).\n Do you want to create as LSO selected container(s)?';
msgs['MST02029'] = 'In case of XX(SOC), MVMT Status must be OP or OC, TN, EN. and BKG is Cancel.\n';
msgs['MST02030'] = 'In case of XX(SOC), Term Status must be SH.\n';
msgs['MST02031'] = 'On-hire date should be later than the last container status date.\n';

function MstMakeComboObject(comboObj, arrStrNm, arrStrCd) {
	var itemCnt = comboObj.GetCount();

	for ( var i = 0 ; i < arrStrCd.length ; i++ ) {
		comboObj.InsertItem((i+itemCnt), arrStrNm[i], arrStrCd[i]);
	}
}

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
function ComMstXml2ComboString(xmlStr, codeCol, textCol, separator) {
	
	var rtnArr = new Array();
	
	if (xmlStr == null || xmlStr == "") {
		return "";
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return "";
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return "";
		}

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
		
		for(var k=0; k < textColList.length; k++){
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

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComXmlString(xmlStr, nm);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
  * @author 박성수
  * @version 2009.04.22
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
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComXmlString(xmlStr, nm);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
  * @author 박성수
  * @version 2009.04.22
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
			
			//sCode += arrData[colListIdx[0]];
			
			//if (i != dataChildNodes.length - 1) {
			//	sCode += "|";
			//}
			if (itmcnt == i){
				sCode = arrData[colListIdx[0]];
			}
		}
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}
 
/////////////////////////////////////////////////////
 function getRelativeTime(y,m,d,h) {                  
 /////////////////////////////////////////////////////
 // 현재 시각과 y년 m월 d일 h시 차이나는 Time을 리턴  
     return shiftTime(getCurrentTime(),y,m,d,h);      
 }
  
 /////////////////////////////////////////////////////
 function shiftTime(time,y,m,d,h) { //moveTime(time,y,m,d,h)
 /////////////////////////////////////////////////////
 // 주어진 Time 과 y년 m월 d일 h시 차이나는 Time을 리턴
     var date = toTimeObject(time);
     date.setFullYear(date.getFullYear() + y); //y년을 더함
     date.setMonth(date.getMonth() + m);       //m월을 더함
     date.setDate(date.getDate() + d);         //d일을 더함
     date.setHours(date.getHours() + h);       //h시를 더함
     return toTimeString(date);
 }

 /////////////////////////////////////////////////////
 function toTimeObject(time) { //parseTime(time)
 /////////////////////////////////////////////////////
 // Time 스트링을 자바스크립트 Date 객체로 변환  parameter time: Time 형식의 String
     var year  = time.substr(0,4);
     var month = time.substr(4,2) - 1; // 1월=0,12월=11
     var day   = time.substr(6,2);
     var hour  = time.substr(8,2);
     var min   = time.substr(10,2);

     return new Date(year,month,day,hour,min);
 }

 /////////////////////////////////////////////////////
 function toTimeString(date) { //formatTime(date)
 /////////////////////////////////////////////////////
 // 자바스크립트 Date 객체를 Time 스트링으로 변환 
 // parameter date: JavaScript Date Object
     var year  = date.getFullYear();
     var month = date.getMonth() + 1; // 1월=0,12월=11이므로 1 더함
     var day   = date.getDate();
     var hour  = date.getHours();
     var min   = date.getMinutes();

     if (("" + month).length == 1) { month = "0" + month; }
     if (("" + day).length   == 1) { day   = "0" + day;   }
     if (("" + hour).length  == 1) { hour  = "0" + hour;  }
     if (("" + min).length   == 1) { min   = "0" + min;   }

     return ("" + year + month + day + hour + min)
 } 
 
/////////////////////////////////////////////////////
 function getCurrentTime() {
 /////////////////////////////////////////////////////
 // 현재 시각을 Time 형식으로 리턴
     return toTimeString(new Date());
 }
 
/////////////////////////////////////////////////////
 function getMonthInterval(time1,time2) { //measureMonthInterval(time1,time2)
 /////////////////////////////////////////////////////
 // 두 Time이 몇 개월 차이나는지 구함
     var date1 = toTimeObject(time1);
     var date2 = toTimeObject(time2);

     var years  = date2.getFullYear() - date1.getFullYear();
     var months = date2.getMonth() - date1.getMonth();
     var days   = date2.getDate() - date1.getDate();

     return (years * 12 + months + (days >= 0 ? 0 : -1) );
 }
 
/////////////////////////////////////////////////////
 function isValidDay(yyyy, mm, dd) {
      /////////////////////////////////////////////////////
      //유효한(존재하는) 일(日)인지 체크
      var m = parseInt(mm,10) - 1;
      var d = parseInt(dd,10);
      
      var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
      if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
           end[1] = 29;
      }
      
      return (d >= 1 && d <= end[m]);
}
 
 function sReplace_str(str, s1, s2)  
 {  
	 for (i=0; i< str.length; i++)  
		 str = str.replace(s1,s2);  
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
			var arrText = textCol.split("|");
			for (var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				for (var j = 0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1] = i;
					}
				}
			}
			
			for (var i = -1; i < dataChildNodes.length; i++) {
			    if (i != -1){
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
			    }
				var arrData;
				if (i != -1){
					arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
					
					var item = "";
					for (var j = 1; j < colListIdx.length; j++) {
						item += arrData[colListIdx[j]];
						if (j < colListIdx.length - 1) {
							item += "|";
						}
					}
				}
                if (i == -1){
                    if (gubun == 0)	{
                	   cmbObj.InsertItem(0 , 'ALL','ALL');
                    } else {
                       cmbObj.InsertItem(0 , '','');	
                    }
                }	
                else
				    cmbObj.InsertItem(i+1, item, arrData[colListIdx[0]]);
			}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
 } 
 