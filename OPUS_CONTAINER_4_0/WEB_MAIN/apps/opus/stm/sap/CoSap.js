/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSar.js
*@FileTitle  : SAP COMMON SCRIPT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
	 * @author Cyberlogitec
	 */
	if(msgs == undefined){
		msgs=new Array();
	}	
	msgs['SAP00001']="GL Date ({?msg1}) was already closed at ( {?msg2} ). Input another GL Date.";
	msgs['SAP00002']="There is no currency exchange info. {?msg1} {?msg2}";
	msgs['SAP00003']="The selected invoice type is [{?msg1}].\nYou have to input [{?msg2}] in invoice amount.";
	msgs['SAP00004']="The inputted invoice amount is [{?msg1}].\nYou have to select [{?msg2}] at invoice type.";	
	msgs['SAP00005']="The inputted invoice amount is [{?msg1}].\nYou can't select [{?msg2}] at invoice type.";	
	msgs['SAP00006']="[{?msg1}] should be equal to [{?msg2}]. ";	
	msgs['SAP00007']="[{?msg1}] should start with [{?msg2}]. ";	
	msgs['SAP00008']="[{?msg1}] can't start with [{?msg2}]. ";	
	msgs['SAP00009']="Please select header invoice.";	
	msgs['SAP00010']="Please select {?msg1}.";
	msgs['SAP00011']="Header's Evidence Type is [TAX]. Please add Tax Line.";  
	msgs['SAP00012'] = "Header's Evidence Type is [INVOICES].\nIf the line type is ITEM or MISCELLANEOUS or TAX or WITHHOLDING TAX, Supplier Invoice No is mandatory.";  
	msgs['SAP00013']="Do you want to cancel {?msg1}?";
	msgs['SAP00014']="Data is duplicated.{?msg1}";
	msgs['SAP00015']="There is no data {?msg1}";
	msgs['SAP00016']="Do you want to execute?";
	msgs['SAP00017']="Do you want to {?msg1}?";
	msgs["SAP00018"]="Data was saved successfully.";
	msgs["SAP00019"]="This Office is for Offset. ASA No is mandatory.";
	msgs["SAP00020"]="({?msg1}) was closed.";
	msgs["SAP00021"]="Inv No. {?msg1} is already paid.";
	msgs["SAP00022"]="This account is an unsettled account. You cannot use it.";
	msgs["SAP00023"]="You can't void {?msg1} because this item isn't accounted yet.";
	msgs["SAP00024"]="Do you want to void {?msg1}.";
	msgs['SAP00025']='{?msg1} was voided successfully.';
	msgs['SAP00026']='Failed to void {?msg1}. Please try again.';	
	msgs['SAP00027']='Please add {?msg1} data.';
	msgs["SAP00028"]="You can't {?msg1} because this item was already accounted.";
	msgs["SAP00029"]="Sum of payment amount for Detail must be equal to payment amount for Header.";
	msgs["SAP00030"]="There is no opened period.  You can't apply.";
	msgs["SAP00031"]="You can't use [Row Delete] button. Please use the [Delete] button.";
	msgs["SAP00032"]="You can't {?msg1} row because this Header item was already saved.";
	msgs["SAP00033"]="You can only use unsettled account which is asset accounts.";
	msgs['SAP00034']='Please enter a valid date format for(Date) : ({?msg1})';
	msgs['SAP00035']="You can't apply/unapply.{?msg1}";
	msgs["SAP00036"]="There is no contents to save.";
	msgs["SAP00037"]="The applied amount can't exceed the prepayment amount remaining.\nPlease check the amount.";
	msgs["SAP00038"]="There is no opened period.  You can't unapply.";
	msgs['SAP00039']="[{?msg1}] should be equal to or less than [{?msg2}]. ";	
	msgs['SAP00040']="You can't capture now because unsettled period is open.";
	msgs['SAP00041']="Duplicated Payment Batch Name : [{?msg1}] ";
	msgs["SAP00042"]="There is Batch No in same condition.";
	msgs["SAP00043"]="Please save the batch condition first.";
	msgs["SAP00044"]="Please save the invoice first.";
	msgs["SAP00045"]="Can't delete. Please check data to delete.";
	msgs['SAP00046']='Unexpected system error occurred during data processing';	
	msgs['SAP00047']="There is no data to capture.\nSo this batch's payment status becomes 'CANCELLED NO PAYMENTS'";		
	msgs["SAP00048"]="Can't cancel. Please check data to cancel.";
	msgs["SAP00049"]="You can't {?msg2} because [{?msg1}] paid already.";
	msgs["SAP00050"]="You must input the amount of ASA Invoices.";
	msgs["SAP00051"]="{?msg1} is mandatory item.";
	msgs["SAP00052"]="This invoice data was already transferred to AR outstanding.\nYou can't {?msg1}.";
	msgs["SAP00053"]="Failed to attach file to the email. Please try again.";	
	msgs["SAP00054"] = "If there is manually inputted tax data,\nyou can't use the [Calculate Tax] button.";
	msgs["SAP00055"] = "Line No.[{?msg1}] is tax item. Please use the [Calculate Tax] Button.";
	msgs["SAP00056"] = "Line No.{?msg1}'s amount of tax is invalid.\nPlease use the [Calculate Tax] Button.";
	msgs["SAP00057"] = "Manually inputted tax amount ({?msg1}) is invalid.\nIt should be in the range of ( {?msg2} ) ";
	msgs["SAP00058"] = "Entry tax already exists. You can't select Tax Item.";
	msgs["SAP00059"] = "Tax Code is mandatory when the line type is ITEM.";
	msgs["SAP00060"] = "You must input positive number at Line Amount when the line type is ITEM.";
	msgs["SAP00061"] = "You can't delete because this item was already applied.";
	msgs["SAP00062"] = "There is no tax item. You can't input TAX Line.";
	msgs["SAP00063"] = "You can't unapply because this data {?msg1} was already transmitted.";
	msgs["SAP00064"] = "The ASA No of {?msg1} is Closed. You Can't Cancel.";
	msgs["SAP00065"] = "{?msg1} Activity Place is wrong. Please check the activity place.";
	msgs["SAP00066"] = "{?msg1} Service Lane is wrong. Please check the service lane.";
	msgs["SAP00067"] = "If you want to create CSR of ASA, You need to input the zero in invoice amount.";
	msgs["SAP00068"] = "If you want to create CSR of ASA, You need to input the ASA clearing Acccount(954113) in expense account of line.";
	msgs["SAP00069"] = "You can't use evidence type. Please use 'Invoices' of evidence type."; 
	msgs["SAP00070"] = "Can't cancel. This data is Upstream or AR module's data.";
	msgs["SAP00071"] = "Can't cancel. This data is AR module's data.";
	msgs["SAP00072"] = "This CSR [{?msg1}] was already interfaced to SAKURA.";
	msgs["SAP00073"] = "Company code of Liability Account does not match the Company code of Line({?msg1}) of Expense Account.";
	msgs["SAP00074"] = "Region code of Liability Account does not match the Region code of Line({?msg1}) of Expense Account.";
	msgs["SAP00075"] = "Center code of Liability Account does not match the Center code of Line({?msg1}) of Expense Account.";
	msgs["SAP00076"] = "You can capture one condition [Period or CSR No].";
	msgs["SAP00077"] = "This hold/unhold action will not affect process in SAKURA. Please communicate separately to GLTC for action to be taken in SAKURA.";
	msgs["SAP00078"] = "This invoice type of CSR [{?msg1}] is not contain for prepayment settlement.";
	msgs["SAP00079"] = "Region of ({?msg1})office and country of ({?msg2})vendor are different. Please use the same region.";
	msgs["SAP00080"] = "Month of ASA no and Month of activity date(954113 acct.) are different. Please use the same Month.";
	msgs["SAP00081"] = "In case of [{?msg1}] Payment method, Vendor[{?msg2}] must have Bank account flag. Please use other vendor.";
	msgs["SAP00082"] = "In case of [{?msg1}] Payment method, Currency of CSR and Local Curr of Vendor[{?msg2}] must have same. Please use same Currency.";
	msgs["SAP00083"] = "Supplier Code has no Payment Method.";
	msgs["SAP00084"] = "The ASA No of {?msg1} is Closed. Do you want to reject and reflect cancelled amount to last opened ASA?";
	msgs["SAP00085"] = "Activity Date of Line({?msg1}) is Null ! This data is mandatory item.";
	msgs["SAP00086"] = "Activity Place of Line({?msg1}) is Null ! This data is mandatory item.";
	msgs["SAP00087"] = "Service Lane of Line({?msg1}) is Null ! This data is mandatory item.";
	
    var ROWMARK="|";
    var FIELDMARK="=";
    var FIXEDPRCS=4;
	/*
	 * @param {string}
	 *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @return array Code연결 문자열과 Text연결 문자열이 담긴 배열.
	 * @see #ComXml2ComboString
	 * @author 박명신
	 * @version 2009.06.01
	 */
	function SapXmlToArray(xmlStr) {
		
		var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "") {
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
			var retStr="";
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				rtnArr.push(arrData);
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return rtnArr;
	}	
	/*
	 * @param {string}
	 *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @return ListMap
	 * @see 
	 * @author 박명신
	 * @version 2009.06.01
	 */
    function SapXmlToListMap(xmlStr) {
    	var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}
		try {
			
			var xmlDoc = ComGetXmlDoc(xmlStr);
			if (xmlDoc == null) return;
			var xmlRoot = xmlDoc.documentElement;
			
			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}
			var col=dataNode.getAttribute("COLORDER");
			var colArr=col.split("|");
			var sep=dataNode.getAttribute("COLSEPARATOR");
			var total=dataNode.getAttribute("TOTAL");
			if (total == 0) {
				return rtnArr;
			}
			var dataChileNodes=dataNode.childNodes;
			if (dataChileNodes == null) {
				return rtnArr;
			}
			var cnt = 0;
			for ( var i=0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChileNodes[i].firstChild.nodeValue.split(sep);
				var subDataArr=new Array();
				for ( var j=0; j < arrData.length; j++) {
					subDataArr[colArr[j]]=arrData[j];
				}
				rtnArr[cnt]=(subDataArr);
				cnt++;
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return rtnArr;
		
    }
    /**
     *  <br>
     * ComComboObject에 item 추가  <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = SapGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				SapAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param comboObj
     * @param comboItems (SapGetComboItems 에서 얻은 리턴값)
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @see SapGetComboItems
     */ 	
    function SapAddComboItem(comboObj, comboItems, type, appendStr, appendCode) {
    	var k=0;
    	if (appendStr != "" ) { 
    		comboObj.InsertItem(0, appendStr, appendCode);
    		k=1;
    	}
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
            if ( type == "1" ) {
            	comboObj.InsertItem(k, comboItem[0] , comboItem[0]);    
            } else  if ( type == "2" ) {            	
            	comboObj.InsertItem(k, comboItem[0] + "|" + comboItem[1] , comboItem[0]);    
            }
            k++;
        }        
    }
    /**
     *  <br>
     * SCO_LU_DTL 테이블의 LU_TP_CD 에 따른 정보를 리턴한다. <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = SapGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				SapAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param sheetObj
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 필수 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I 
     * @see SapAddComboItem
     */   
    function SapGetComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param="";
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_appl_cd=SAP" + "&lu_tp_cd=" + sCondition + param );
    	var comboItems=ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems
    }
    /**
     *  <br>
     * SCO_LU_DTL 테이블의 LU_TP_CD 에 따른 정보를 리턴한다. <br>
     * IBSheet의 InitDataCombo 시 이용한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     SapComSearchCombo(sheetObj, prefix + "attr_cate_nm", "2", " " , " ", "SAR_TAX_CHARGE") ;
     * </pre>
     * @param sheetObj
     * @param ibsheet's columnName
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I 
     */   
//SetColProperty(colName, {ComboText:type ,appendStr, ComboCode:appendCode,sCondition} ); // Something went wrong. I just fix it.
    // Fixed by Luc Duong - 08-07-2014 mm-dd-yyyy
    function SapInitDataCombo(sheetObj, colName, type, appendStr, appendCode, sCondition, param, show_col) {
    	if (param == undefined ) param="";
    	if (show_col == undefined ) show_col = 0;
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_appl_cd=SAP" + "&lu_tp_cd=" + sCondition + param);
     	
    	var combo_code=ComGetEtcData(sXml,"combo_code");
		var combo_nm=ComGetEtcData(sXml,"combo_nm");

		//alert(appendStr+combo_tax_nm);
	    if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+combo_nm, ComboCode:appendCode+combo_code} );
        } else if (type == "2" ) {
        	appendStr=appendCode + "\t" + appendStr ;
            sheetObj.SetColProperty(colName, {ComboText:appendStr+combo_nm, ComboCode:appendCode+combo_code, ShowCol:show_col} );
        }	    
	    
    	/*var comboString=ComXml2ComboString(sXml, "lu_cd", "lu_desc");
    	if(comboString == undefined) return;
        if ( appendStr != "" ) appendStr=appendStr + "|";
        if ( appendCode != "" ) appendCode=appendCode + "|";
        if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[1], ComboCode:appendCode+comboString[0]} );
        } else if (type == "2" ) {
        	var codeStrTemp=comboString[0].split('|'); // 코드
            var nameStrTemp=comboString[1].split('|'); // 이름
            var fullStrTemp='';  // 코드 + 이름  
            for(var i=0; i<codeStrTemp.length; i++){
                fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i] + '|' ;
            }
            fullStrTemp = fullStrTemp.replace(/\|$/, '');//Remove last empty item. Luc Duong - 2014-09-03
            sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        }*/
    } 
    /**
     *  <br>
     * Login User의 AP Office 정보 <br>
     * @param sheetObj
     * 
     */   
    function SapGetLoginAPOfc(sheetObj) {
      	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH01);
		var ap_ofc_cd=ComGetEtcData(sXml, "ap_ofc_cd");
		return ap_ofc_cd;
    } 
    /**
     *  <br>
     * Login User의  Local Sysdate <br>
     * @param sheetObj
     * 
     */      
    function SapGetLocDate(sheetObj) {
      	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH02);
		var localTime=ComGetEtcData(sXml, "local_time");
		return localTime;
    } 
    /**
     *  <br>
     * SapGetFunctionalCurrencyCode <br>
     * @param sheetObj
     * 
     */       
    function SapGetFunctionalCurrencyCode(sheetObj) {
    	var rtnArray=new Array(2);
      	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH05);
    	rtnArray[0]=ComGetEtcData(sXml, "curr_cd");
		rtnArray[1]=ComGetEtcData(sXml, "dp_prcs_knt");
		return rtnArray;
    } 
    /**
     * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @return {Boorean}
     */
    function SAPDecideErrXml(shtObj, xmlStr) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
            shtObj.LoadSearchData(xmlStr,{Sync:1} );
            return true;    // Error일때
        } else {
            return false;
        }
    }  
    /**
     * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @return {Boorean}
     */
    function SAPDecideErrXmlSave(shtObj, xmlStr) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
            shtObj.LoadSaveData(xmlStr,{Sync:1} );
            return true;    // Error일때
        } else {
            return false;
        }
    }  
    /**
     *  <br>
     * MDM_CURRENCY 정보를 리턴한다. <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = SapGetCurrComboItems(sheetObj, "");
				SapAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param sheetObj
     * @param sCondition  ( ) 
     * @see SapAddComboItem
     */   
    function SapGetCurrComboItems(sheetObj, sCondition) {
     	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH06 + "&value0=" + sCondition );
    	var comboItems=ComGetEtcData(sXml, "curr_cd_list").split(ROWMARK);	
    	return comboItems
    }  
    /**
     * Location Name 을 리턴한다.<br>
     *
     * @param {String} shtObj 필수, IBSheet Object
     * @param {String} locCd 필수
     * @return {String} locName
     */    
    function SAPGetLocNm(sheetObj, locCd) {
    	if (ComTrim(locCd) == "") return "";
    	if (ComTrim(locCd).length != 5 ) return "";
     	var sXml=sheetObj.GetSearchData("STM_SAP_0023GS.do", "f_cmd=" + SEARCH + "&loc_cd=" + locCd );
		if (SAPDecideErrXml(sheetObj, sXml)) {
			return "";
        } else {
        	if ( ComGetEtcData(sXml, "loc_nm") == "NO_DATA" ) {
        		return "";
        	} else {
        		return ComGetEtcData(sXml, "loc_nm");
        	}        	
        }
    }    
    /**
    * Delete  sheet row <br>
    * @param {ibsheet} sheet 
    * @param {int} row
    * @author jinyoonoh
    * @version 2009.05.13
    */
    function SarRowDelete(sheet,row) {
    	var status=sheet.GetRowStatus(row);
    	if (status == "I") {
    		sheet.RowDelete(row,false);
    	} else {
    		sheet.SetRowHidden(row,1);
    		sheet.SetRowStatus(row,"D");
    	}    	
    }  
    /**
     * 숫자형 데이타에 ComAddComma(obj) 적용 및 소숫점 자릿수에 맞게 0 추가 
     * @param {obj} String : Form Object
     * @param {prcs} String : 소숫점 이하 자릿수 
     */  
    function SAPComAddComma2(obj,prcs)  {
            var sVal=getArgValue(obj);
            if (prcs == null || prcs == "" || prcs == 0 ) {
           	 return ComAddComma(sVal);
            } else {
           	    p=sVal.split(".");
                p[0]=ComAddComma(p[0]);
                if (p.length == 1) {
                	rtnVal=p[0] + "." + ComRpad("0", prcs, "0");
                } else if (p.length == 2) {
                	if(p[1].length == prcs) {
                		rtnVal=p[0]+"."+p[1];	                 		
                	} else {
                		rtnVal=p[0]+"." +p[1] + ComRpad("0", prcs - p[1].length, "0");
                	}
                }
                return rtnVal;
            }             
    }   
    /**
     *  <br>
     * currency 에 따른 정보를 리턴한다. <br>
     * IBSheet의 InitDataCombo 시 이용한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     SAPInitDataCurrCombo(sheetObj, prefix + "curr_cd", "2", " " , " ", "SAR_TAX_CHARGE") ;
     * </pre>
     * @param sheetObj
     * @param ibsheet's columnName
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr
     * @param appendCode 
     * @param sCondition 
     */     
    function SAPInitDataCurrCombo(sheetObj, colName, type, appendStr, appendCode, sCondition) {
      	var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH06 + "&value0=" + sCondition );
    	var comboString=ComXml2ComboString(sXml, "curr_cd", "dp_prcs_knt");
    	if(comboString == undefined) return;
        if ( appendStr != "" ) appendStr=appendStr + "|";
        if ( appendCode != "" ) appendCode=appendCode + "|";
        if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[0]} );
        } else if (type == "2" ) {
        	var codeStrTemp=comboString[0].split('|'); // 코드
            var nameStrTemp=comboString[1].split('|'); // 이름
            var fullStrTemp='';  // 코드 + 이름  
            for(var i=0; i<codeStrTemp.length; i++){
                fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i] + '|' ;
            }
            sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        }
    }  
    /**
     * ETC-DATA의 결과XML을 파싱하여 sheetObject의 특정 Row의 값을 입력하는 함수.
     *
     * @param XmlString, sheetObject, RowNumber, 데이타가없을경우메세지 , pfefix <br>
     * @returns boolean <br>
     */
  function SAPComEtcDataXmlToSheet(xmlStr, sheetObj, row, noDataMessage, prefix){
      if (xmlStr == null || xmlStr == "") {
          alert("[ComEtcDataXmlToSheet Error] XMLStr은 필수값 입니다.");
          return false;
      }
      if (typeof(sheetObj) != "object") {
          alert("[ComEtcDataXmlToSheet Error] SHEET OBJECT가 아닙니다.");
          return false;
      }
      
      var chk_flg=false;
            
	  var xmlDoc = ComGetXmlDoc(xmlStr);
	  if (xmlDoc == null) return false;
	  var xmlRoot = xmlDoc.documentElement;
	
	  var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	  if (etcDataNode == null) return false;
	
	  var etcNodes = etcDataNode.childNodes;
	  if (etcDataNode == null) return false;
	  
	  var xName = "";
	  var xValue = "";
		
	  if(etcNodes.length > 0){
			for ( var i = 0; i < etcNodes.length; i++) {
				if (etcNodes[i].nodeType != 1)
					continue;
				if (etcNodes[i].firstChild == null) {
					return false;
				} else {
					
					xName=prefix + etcNodes[i].attributes[0].nodeValue;
					if(xName == prefix + "ibflag") continue;
			        if(xName == prefix + "Exception") continue;
			        if(xName == prefix + "TRANS_RESULT_KEY") continue;
			          
					xValue = ComTrim(etcNodes[i].firstChild.wholeText) || etcNodes[i].firstChild.nodeValue;
					sheetObj.SetCellValue(row, xName,xValue,0);
					
					chk_flg = true;
				}
			}
			return chk_flg;
		}else{
	        if(noDataMessage != undefined && noDataMessage != '') ComShowMessage(noDataMessage);
	        return false;
	    }
  }	  

  /**
   * COA 조합의 Code Combination 코드를 조회한다. <br>
   * <br><b>Example : </b>
   * <pre>
   *     var cdCmbSeq = SapGetCOAInfo(sheetObj, company, region, center, account, intercom, vvd);			
   * </pre>
   * @param sheetObj, company, region, center, account, intercom, vvd
   * @returns cdCmbSeq
   */   
  function SapGetCOAInfo(sheetObj, company, region, center, account, intercom, vvd) {
      	var param="&value1=" + company +"&value2=" + region +"&value3=" + center  +"&value4=" + account  +"&value5=" + intercom  +"&value6=" + vvd;  
 		var sXml=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + SEARCH08 + param);
		if (SAPDecideErrXml(sheetObj, sXml)) {
			return "ERROR";
	    } else {
	      	return ComGetEtcData(sXml, "cd_cmb_seq") ;      	
	    }	
  }  
  /**
   * 카드번호 조합을 만든다. ####-####-####-#### <br>
   * <br><b>Example : </b>
   * <pre>
   *    SAPChkCardNoValid(event.srcElement, '-');			
   * </pre>
   * @param obj, sDelim
   * @returns string  -Format에 맞게 Mask가 포함된 문자열
   */    
 function SAPChkCardNoValid(obj, sDelim) {
	 var sVal=getArgValue(obj);
	 var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9])');
	 sVal=ComTrimAll(sVal, sDelim);
     var sResultVal=sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3' + sDelim + '$4');
     obj.value=sResultVal;
 }  
 /**
  * 카드번호 조합에서 separater 를 제거한다 ####-####-####-#### <br>
  * <br><b>Example : </b>
  * <pre>
  *    SAPCardNoClearSeparator(event.srcElement, '-');			
  * </pre>
  * @param obj, sDelim
  * @returns string  - Separater를 제거한 문자열
  */ 
 function SAPCardNoClearSeparator(obj, sDelim) {
     try{
         if (typeof(obj) != "object" ) return;
         if (sDelim==undefined || sDelim==null || sDelim=="") 
        	 return;
         obj.value=ComTrimAll(obj.value,sDelim);
     } catch(err) { ComFuncErrMsg(err.message); }
 }
 /**
  * lookup table의 한개 데이타 조회 : validation 시 사용한다. <br>
  * <br><b>Example : </b>
  * <pre>
  *    SAPChkLookupOneData(sheetObj, "&lu_tp_cd=PAYMENT METHOD&lu_cd="+Value);	
  * </pre>
  * @param sheetObj, param
  * @returns ComGetEtcData(sXml, "one_lu_cd")
  */ 
 function SAPChkLookupOneData(sheetObj, param) {
 	if( ComTrim(param) == "") return "";
  	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param);
		if (SAPDecideErrXml(sheetObj, sXml)) {
			return "";
     } else {
     	if ( ComGetEtcData(sXml, "one_lu_cd") == "NO_DATA" ) {
     		return "";
     	} else {
     		return ComGetEtcData(sXml, "one_lu_cd");
     	}        	
     } 
 }    
 /**
	 * 조회한 xml데이터의 MESSAGE를 가져온다.<br>
	 * 
	 * @param {string} sXml 필수
	 * @return xml의 <MESSAGE> Node 값
	 * @version 2009.09.01
	 */
function SapShowXmlMessage(sXml) {
	return ComGetSelectSingleNode(sXml, "MESSAGE");
 } 
/**
 * CCID를 체크 및 등록 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapAddCCID(sheetObj, company, region, center, account, intercom, vvd);	
 * </pre>
 * @param sheetObj, company, region, center, account, intercom, vvd
 * @returns rtnArray[0] 결과메세지 ERROR 일시 상세 ERROR Message, 성공일때 OK 리턴
 * @returns rtnArray[1] add한 CCID Key 값
 */ 
function SapAddCCID(sheetObj, company, region, center, account, intercom, vvd) {
	var rtnArray=new Array(2);
	rtnArray[0]="";
	rtnArray[1]="";
    var param="&sgm_ctnt1=" + company +"&sgm_ctnt2=" + region +"&sgm_ctnt3=" + center  +"&sgm_ctnt4=" + account  +"&sgm_ctnt5=" + intercom  +"&sgm_ctnt6=" + vvd;  
 	var sXml2=sheetObj.GetSearchData("STM_SCO_0050GS.do", "f_cmd=" + MULTI02 + param);
	if (SAPDecideErrXml(sheetObj, sXml2)) {
		sheetObj.SetCellValue(Row, Col, "");
		sheetObj.SelectCell(Row, Col, true, "");
    } else {
    	rtnArray[0]=ComGetEtcData(sXml2, "COA_MSG");
    	rtnArray[1]=ComGetEtcData(sXml2, "COA_KEY");
     }	
	return rtnArray;
} 
/**
 * Supplier Name 을 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetSupplierName(sheetObj, "1", "sup_name", "N");	
 * </pre>
 * @param sheetObj, vndr_seq, vndr_nm, del_flg 
 * @returns vndr_name
 */ 
function SapGetSupplierName(sheetObj, vndr_seq, vndr_nm, del_flg) {
	if( ComTrim(vndr_seq) == "") return "";
    var param="&value0=" + vndr_seq +"&value1=" + vndr_nm +"&value2=" + del_flg;  
 	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND03 + param);
	if (SAPDecideErrXml(sheetObj, sXml2)) {
		return "";
    } else {
    	if (ComGetEtcData(sXml2, "vndr_lgl_eng_nm") == "NO_DATA") {
    		return "";
    	} else {
    		return ComGetEtcData(sXml2, "vndr_lgl_eng_nm");
    	}
    }	
} 
/**
 * Office Data Security가 적용되어 사용 가능한 Office 정보를 확인 및 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetDataSecurityOffice(sheetObj, ofc_cd, security_flag);	
 * </pre>
 * @param sheetObj, ofc_cd, security_flag 
 * @returns ofc_cd
 */ 
function SapGetDataSecurityOffice(sheetObj, ofc_cd, security_flag) {
	if( ComTrim(ofc_cd) == "") return "";
    var param="&value0=" + ofc_cd +"&value1=" + security_flag;  
 	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND07 + param);
	if (SAPDecideErrXml(sheetObj, sXml2)) {
		return "";
    } else {
    	if (ComGetEtcData(sXml2, "ofc_cd") == "NO_DATA") {
    		ComShowCodeMessage("COM132201", "Office Code" );
    		return "";
    	} else {
    		return ComGetEtcData(sXml2, "ofc_cd");
    	}
    }	
} 
/**
 * Activity Place 사용 가능 여부 확인 및 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetActivityPlaceCheck(sheetObj, activity_place);	
 * </pre>
 * @param sheetObj, activity_place 
 * @returns activity_place
 */ 
function SapGetActivityPlaceCheck(sheetObj, activity_place) {
	if( ComTrim(activity_place) == "") return "";
    var param="&value0=" + activity_place;  
 	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND09 + param);
	if (SAPDecideErrXml(sheetObj, sXml2)) {
		return "";
    } else {
    	if (ComGetEtcData(sXml2, "activity_palce") == "NO_DATA") {
    		ComShowCodeMessage("SAP00065", activity_place );
    		return "";
    	} else {
    		return ComGetEtcData(sXml2, "activity_palce");
    	}
    }	
} 
/**
 * Service Lane 사용 가능 여부 확인 및 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetInvoiceServiceLaneCheck(sheetObj, service_lane_cd);	
 * </pre>
 * @param sheetObj, service_lane_cd
 * @returns service_lane_cd
 */ 
function SapGetInvoiceServiceLaneCheck(sheetObj, service_lane_cd) {
	if( ComTrim(service_lane_cd) == "") return "";
    var param="&value0=" + service_lane_cd;  
 	var sXml2=sheetObj.GetSearchData("SAPCommonGS.do", "f_cmd=" + COMMAND10 + param);
	if (SAPDecideErrXml(sheetObj, sXml2)) {
		return "";
    } else {
    	if (ComGetEtcData(sXml2, "service_lane_cd") == "NO_DATA") {
    		ComShowCodeMessage("SAP00066", service_lane_cd );
    		return "";
    	} else {
    		return ComGetEtcData(sXml2, "service_lane_cd");
    	}
    }	
} 
/**
 * Company Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal (검색할코드), argFlag (CODE or NAME) 
 * @returns code or name
 */ 
function SapGetCompany(sheetObj, argVal, argFlag) {
	if( ComTrim(argVal) == "") return "";
 	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL COMPANY&lu_cd=" + argVal );
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ( ComGetEtcData(sXml, "one_lu_desc") == "NO_DATA" ) {
  		return "";
  	} else {
  		if ("CODE" == argFlag) {
      		return ComGetEtcData(sXml, "one_lu_cd");
      	} else {
      		return ComGetEtcData(sXml, "one_lu_desc");
      	}
  	} 
  }
}
/**
 * Region Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal (검색할코드), argFlag (CODE or NAME) 
 * @returns code or name
 */ 
function SapGetRegion(sheetObj, argVal, argFlag) {
	if( ComTrim(argVal) == "") return "";
 	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL REGION&lu_cd=" + argVal );
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ( ComGetEtcData(sXml, "one_lu_desc") == "NO_DATA" ) {
  		return "";
  	} else {
  		if ("CODE" == argFlag) {
      		return ComGetEtcData(sXml, "one_lu_cd");
      	} else {
      		return ComGetEtcData(sXml, "one_lu_desc");
      	}
  	}        	
  } 	
}
/**
 * Center Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal (검색할코드), argFlag (CODE or NAME) 
 * @returns code or name
 */ 
function SapGetCenter(sheetObj, argVal, argFlag) {
	if( ComTrim(argVal) == "") return "";
	var sXml=sheetObj.GetSearchData("STM_SAP_0440GS.do", "f_cmd=" + SEARCH + "&f_center=" + argVal);
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ( ComGetEtcData(sXml, "one_lu_desc") == "NO_DATA" ) {
  		return "";
  	} else {
  		if ("CODE" == argFlag) {
      		return ComGetEtcData(sXml, "ctr_erp_no");
      	} else {
      		return ComGetEtcData(sXml, "ctr_desc");
      	}
  	}   
  }  	
}
/**
 * Account Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal (검색할코드), argFlag (CODE or NAME) 
 * @returns code or name
 */ 
function SapGetAccount(sheetObj, argVal, argFlag) {
 	var sXml=sheetObj.GetSearchData("STM_SAP_0010GS.do", "f_cmd=" + COMMAND05 + "&value0=" + argVal);
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ( ComGetEtcData(sXml, "acct_cd") == "NO_DATA" ) {
  		return "";
  	} else {
  		if ("CODE" == argFlag) {
      		return ComGetEtcData(sXml, "acct_cd");
      	} else {
      		return ComGetEtcData(sXml, "acct_eng_nm");
      	}
  	}   
  }  	
}
/**
 * Inter Company Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal (검색할코드), argFlag (CODE or NAME) 
 * @returns code or name
 */ 
function SapGetInterCompany(sheetObj, argVal, argFlag) {
	if( ComTrim(argVal) == "") return "";
 	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=GL INTER COMPANY&lu_cd=" + argVal );
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ( ComGetEtcData(sXml, "one_lu_desc") == "NO_DATA" ) {
  		return "";
  	} else {
  		if ("CODE" == argFlag) {
      		return ComGetEtcData(sXml, "one_lu_cd");
      	} else {
      		return ComGetEtcData(sXml, "one_lu_desc");
      	}
  	}        	
  } 	
}
/**
 * VVD Name or Code 를 가져온다 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SapGetCompany(sheetObj, "01", "CODE");	
 * </pre>
 * @param sheetObj, argVal1 (검색할코드1), argVal2 (검색할코드2), argFlag (CODE or NAME), argVal3 (검색할코드:acct_cd) 
 * @returns code or name
 */ 
function SapGetVVD(sheetObj, argVal1, argVal2, argFlag, argVal3) {
	if( ComTrim(argVal1) == "") return "";
	if( ComTrim(argVal2) == "") return "";
 	var sXml=sheetObj.GetSearchData("STM_SAP_0470GS.do", "f_cmd=" + SEARCH + "&vvd_cd=" + argVal1 + "&vvd_type=" + argVal2 + "&acct_cd=" + argVal3);
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
  } else {
  	if ("CODE" == argFlag) {
  		return ComGetEtcData(sXml, "vvd_cd");
  	} else {
  		return ComGetEtcData(sXml, "vvd_desc");
  	}
  }	
}


/**
 * IBSheet의 FindText 메소드는 RowStatus가 D 인 rownum 까지 가져오는데 그것을 제외한 rownum 리턴 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SAPFindText(sheetObj, "sup_name", "KIMKILDONG");	
 * </pre>
 * @param sheetObj, colsaveName, argText 
 * @returns searched row num
 */ 
function SAPFindText(sheetObj, saveColName, argText) {
	var returnRow = -1;
	
	for(var i=1; i <=sheetObj.RowCount(); i++ ) {
		if (sheetObj.GetRowStatus(i) != "D") {
			if(sheetObj.GetCellValue(i,saveColName) == argText) {
				returnRow = i;
				break;
			}
		}    		
	}    	
	return returnRow;  	
}

/**
 * IBSheet의 FindText 메소드는 RowStatus가 D 인 rownum 까지 가져오는데 그것을 제외한 rownum 리턴 <br>
 * <br><b>Example : </b>
 * <pre>
 *    SAPFindTextCount(sheetObj, "sup_name", "KIMKILDONG");	
 * </pre>
 * @param sheetObj, colsaveName, argText 
 * @returns searched row num
 */ 
function SAPFindTextCount(sheetObj, saveColName, argText) {
	var rowCnt = 0;
	
	for(var i=1; i <sheetObj.RowCount(); i++ ) {
		if (sheetObj.GetRowStatus(i) != "D") {
			if(sheetObj.GetCellValue(i,saveColName) == argText) {
				rowCnt += 1;
			}
		}    		
	}    	
	return rowCnt;  	
}

//chkLookupOneData
function chkLookupOneData(sheetObj, param) {
	if( ComTrim(param) == "") return "";
	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param + "&lu_appl_cd=SAP");
	if (SAPDecideErrXml(sheetObj, sXml)) {
		return "";
    } else {
    	if ( ComGetEtcData(sXml, "one_lu_cd") == "NO_DATA" ) {
    		return "";
    	} else {
    		return ComGetEtcData(sXml, "one_lu_cd");
    	}        	
    } 
}  

/**
 * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
 * @param {bool}   hideYn       hide, fade 여부 
 * @return 없음
 * @see #ComOpenWaitCallFunc
 */    
var isOpenWaitWindow = false;	//for wait show/close check
function SapOpenWait(flag, hideYn){
    try {
        if(flag == isOpenWaitWindow ) return;
        isOpenWaitWindow = flag;
        if(flag) {
        	var waitW   = 60;
        	var waitH   = 60;
        	var waitImage = "style/images/theme_default/waiting.gif";
        	
        	var ifr = document.getElementById("waitiframe");
        	if (ifr==null){
            	$('<div class="layer_wait"> </div>').appendTo("body");
            	$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");            	
            	//$('<IFRAME id="waitiframe" name="waitiframe" frameBorder="0" name="iFrm" src="'+waitImage+ '"scrolling="no" width="'+waitW + '" height="' + waitH + '"></IFRAME>').appendTo(".layer_wait")
    
            	$("body").prepend("<div class='layer_wait_bg'></div>");        	
        	}

        	//open wait image
        	if(hideYn){
        		$(".layer_wait_bg,.layer_wait").show();
        	} else {
        		$(".layer_wait_bg,.layer_wait").fadeIn(100);
        	}

        	//position center
        	$(".layer_wait").css({
            	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
            	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
        	});
        } else {
        	//close wait image
        	if(hideYn){
        		$(".layer_wait_bg,.layer_wait").hide();
        	} else {
        		$(".layer_wait_bg,.layer_wait").fadeOut(100);
        	}
        }
    } catch(err) {ComFuncErrMsg(err.message); }
    return true;
}  

/**
 * 불확실한 숫자형 데이타을 올바른 금액으로 처리하고, 소숫점 자릿수에 맞게 금액 처리 
 * @param {arg1} String : 계산할 금액
 * @param {prcs} String : 소숫점 이하 자릿수 
 */  
function SAPComRound(arg1, prcs) {
	if (prcs == undefined || prcs == "" ) prcs="0";
	return ComRound(parseFloat(arg1).toFixed(FIXEDPRCS), prcs);          
}   
