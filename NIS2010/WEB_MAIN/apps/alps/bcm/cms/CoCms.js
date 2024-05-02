/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : CoSam.js
*@FileTitle  : Sam common js
*@author     : Hipluscard
*@version    : 1.0 
*@since      : 2017/04/08
=========================================================*/

msgs['CCD00030'] = 'Do you want to create a new customer code?';


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
msgs['SAM00011'] = 'Item \'Named BIZ Customer\' is intended to handle exceptions.\nFor normal case, do not flag \'Y\' since its customer code is not listed in Pricing and Bkg.';
msgs['SAM00013'] = 'No row(s) selected.';
msgs['SAM00014'] = 'Do you want to delete checked row(s)?';
msgs['SAM00015'] = 'If unsaved changes exist on Detail Info, the changed data will be lost. Do you want to delete?';
msgs['SAM00017'] = '{?msg1} doesn\'t exist.';
msgs['SAM00018'] = '{?msg1}\'s input format is invalid.';
msgs['SAM00019'] = '[{?msg2}] is customer [{?msg1}]\'s Primary Sales Rep now, so you can\'t change it to Sub Sales Rep. Please select another Srep Code.';
msgs['SAM00020'] = 'More than one Sales Rep should be inputted.';
msgs['SAM00021'] = 'Unique Primary Sales Rep (Primary Flag: Y) should exist.';
msgs['SAM00022'] = 'In Korea, you must enter Tax Payer ID.';
msgs['SAM00023'] = "Please Select a Row"
msgs['SAM00024'] = "Please upload SEZ Certificate."
msgs['SAM00025'] = "The Customer Group code already exists [{?msg1}]. Please check it again."
msgs['SAM00026'] = '[{?msg2}] is Group customer [{?msg1}]\'s Primary customer code now. Please select another Customer Code.';
msgs['SAM00027'] = 'For updating flag/unflag in No Use, mail to MDM administrator(selxwp@smlines.com) since this value should be modified in MDM.';
msgs['SAM00028'] = "Data exceeded maximum length ({?msg1})."
msgs['SAM00029'] = "Data was saved successfully. \nFor generating customer code in Master data, process next step\" Approval Request\"."
msgs['SAM00030'] = 'In Korea, you must enter Local Language Name.';
msgs['CCD00001'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['CCD00002'] = 'There is no data.';
msgs['CCD00003'] = 'When Activity Type is \'T\', [{?msg1}] can not be blank.';
msgs['CCD00004'] = 'Duplicate data exist in [{?msg1}], Please check it again.';
msgs['CCD00005'] = '[{?msg1}] should be later than [{?msg2}]';
msgs['CCD00006'] = 'This data alreay exists';
msgs['CCD00007'] = 'It is not an e-mail address format. Please check it again.';
msgs['CCD00008'] = 'There should be one Primary Check Flag.';
msgs['CCD00009'] = 'Customer Code has only one Primary Flag.';
msgs['CCD00010'] = 'Selected [{?msg1}] does not match Type Size Code.';
msgs['CCD00011'] = "Data count:[{?msg1}] \nDo you want to down excel?";
msgs['CCD00012'] = "Do you want to delete data?";
msgs['CCD00013'] = 'The location of "{?msg1}" is not defined in location table. Please check location code.';
msgs['CCD00014'] = 'The Code already exist in lease company yard master codes. Please check again.';
msgs['CCD00015'] = 'SCC is not found! If you want to update EQ SCC, please advise MDA administrator.';
msgs['CCD00016'] = 'This code is using in other EQ location hierarchy.\nPlease check this again in the EQ location hierarchy.';
msgs['CCD00017'] = 'This code is using as SCC code of specific Location code(s).\nIf you want to delete this SCC code, SCC of the Location code(s) should be changed first.\nPlease check this again in the Location  area.';
msgs['CCD00018'] = 'This code is using as SCC code of specific Yard code(s).\nIf you want to delete this SCC code, SCC of the Yard code(s) should be changed first.\nPlease check this again in the Yard  area.';
msgs['CCD00019'] = 'There is no data to save.';
msgs['CCD00023'] = 'Do you want to {?msg1}?';
msgs['CCD00024'] = 'The Code already exist in yard master codes. Please check again.';
msgs['CCD00029'] = 'Do you want to really {?msg1}?';
msgs['CCD00032'] = 'Do you want to {?msg1}?';
msgs['CCD00033'] = "{?msg1} doesn't exist.";
msgs['CCD00034'] = "{?msg1} doesn't exist. Do you want to create this code?";
msgs['CCD00038'] = 'Please input {?msg1}.';
msgs['CCD00039'] = 'Customer Code format is incorrect (Alphabet 2 digit + Numeric 1 digit over).';
msgs['CCD00040'] = 'There is no credit information of this customer.';
msgs['CCD00043'] = 'At least 1 item among {?msg1} is needed';
msgs['CCD00050'] = 'This customer code is already being used, so you can not delete.';

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
//		var sXml = sheetObj.GetSearchXml("BCM_CMS_COMGS.do", FormQueryString(formObj));
		var sXml=sheetObj.GetSearchData("BCM_CMS_COMGS.do", FormQueryString(formObj));
		var userAuth = ComGetEtcData(sXml, "result");
	}
	return userAuth;
}

/**
 * 결과 XML로 부터 MESSAGE를 추출하는 함수.
 *
 * @param 결과XML <br>
 * @returns String <br>
 * @author 김영출
 */
function ComResultMessage(xmlStr){
    if (xmlStr == null || xmlStr == '') return '';

    var xValue = '';
      try {
          /* XML Parsing */
          var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
          xmlDoc.async = "false";
          xmlDoc.loadXML(xmlStr);
          /* get message */
          //xValue = xmlDoc.documentElement.getElementsByTagName("MESSAGE").item(0).text
          var el_messages = xmlDoc.documentElement.getElementsByTagName("MESSAGE");
          if(el_messages != null && el_messages.length > 0) {
            xValue = el_messages.item(0).text;
          }else{
            xValue = '';
          }
      } catch(err) {
          xValue = err.message;
      }
    return xValue;
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

/**
 * DATE 값이 변경 되었을 때 값의 유효성을 체크
 */
function checkDateValue(obj) {
	if (!ComIsDate(obj.value)) {
		ComShowCodeMessage("COM12179");
		obj.focus();
		return false;
	}
	return true;
}
/**
 * DATE 값이 변경 되었을 때 값의 유효성을 체크
 */
function checkEmailValue(obj) {
	if (!ComIsEmailAddr(obj.value)) {
		ComShowCodeMessage("CCD00007");
 		obj.focus();
 		return false;
 	}
 	return true;
}

/**
 * Mdm History 팝업 호출<br>
 * <br><b>Example :</b>
 * <pre>
 *     comMdmCallPop(tblNm, mstKey);
 * </pre>
 * @param  tblNm, mstKey
 * @return 없음
 * @author 이남경
 * @version 2009.08.04
 */
function comMdmCallPop(tblNm, mstKey){
	var param = "?pgmNo=BCM_CCD_2004&tbl_nm="+tblNm+"&mst_key="+mstKey;
    var sUrl  = "BCM_CCD_2004.do"+param;
    //ComOpenPopup('ESM_BKG_0566.do'+param, 900, 550, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1', true);  //false
    //ComOpenWindowCenter(sUrl, "BCM_CCD_2004", 1024,710, true);
    ComOpenWindowCenter(sUrl, "BCM_CCD_2004", 1024, 680, true);
}

/**
 * null을 blank("")로 변경<br>
 * @param   String
 * @return  String
 * @author  이남경
 * @version 2009.05.21
 */
  function nullToBlank(val) {
    return (val==null) ? "" : val;
 }