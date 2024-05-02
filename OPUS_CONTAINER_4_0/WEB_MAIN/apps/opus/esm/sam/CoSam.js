/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSam.js
*@FileTitle  : Sam common js
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
msgs['SAM00001'] = 'No {?msg1} selected. Please check a {?msg2}.';
msgs['SAM00002'] = '{?msg1} must be at least {?msg2} characters long.';
msgs['SAM00003'] = '{?msg1} must not be over {?msg2} characters long.';
msgs['SAM00004'] = 'Customer Office is different from Customer performance group Office.\nDo you want to Apply?';
msgs['SAM00005'] = 'Please select at least one among [Customer Name], [Sales Office], [Sales Rep.], and [Creation Date].'; 
msgs['SAM00006'] = 'There is no data to save.';
msgs['SAM00007'] = 'Duplicate data exist in [{?msg1}], Please check it again.';
msgs['SAM00008'] = 'Do you want to delete?';
msgs['SAM00009'] = '[{?msg1}] is mandatory field. Please input the data.';
msgs['SAM00010'] = 'Data was changed. Do you want to save?';
msgs['SAM00011'] = 'Please define Main Type data first.';
msgs['SAM00013'] = 'No row(s) selected.';
msgs['SAM00014'] = 'Do you want to delete checked row(s)?';
msgs['SAM00015'] = 'If unsaved changes exist on Detail Info, the changed data will be lost. Do you want to delete?';
msgs['SAM00017'] = '{?msg1} doesn\'t exist.';
msgs['SAM00018'] = '{?msg1}\'s input format is invalid.';
msgs['SAM00019'] = '[{?msg2}] is customer [{?msg1}]\'s Primary Sales Rep now, so you can\'t change it to Sub Sales Rep. Please select another Srep Code.';
msgs['SAM00020'] = 'More than one Sales Rep should be inputted.';
msgs['SAM00021'] = 'Unique Primary Sales Rep (Primary Flag: Y) should exist.';

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
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
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
* User Auth 확인<br>
* @author 서미진
* @version 2011.08.01
*/
function checkUserAuth(formObj, sheetObj) {	
	if(formObj.usr_id.value.length>0){
		formObj.f_cmd.value = SEARCH01;
//		var sXml = sheetObj.GetSearchXml("ESM_SAM_COMGS.do", FormQueryString(formObj));
		var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do", FormQueryString(formObj));
		var userAuth = ComGetEtcData(sXml, "result");
	}
	return userAuth;
}

/**
 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
 *
 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
 * @param {string} sPrefix 필수, Prefix.
 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
 * @author 박성수
 * @version 2009.04.22
 */
function ComSamSetPrefix(sStr, sPrefix) {
    if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
        return sStr;
    }
    var regexp=RegExp(/&/g);
    sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
    return sStr;
}

if(msgs == undefined){
	msgs = new Array();
}
