﻿﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSar.js
*@FileTitle  : SAR COMMON SCRIPT
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
		msgs = new Array();
	} 
	msgs['SAR00001']='Failed to create Outstanding.';
	msgs['SAR00002']='B/L No. or Inv No. is duplicated.';		
	msgs['SAR00003']='Period is closed. Please check {?msg1}.';		
	msgs['SAR00004']='Data was saved successfully!';	
	msgs['SAR00005']='Deposit date must be equal to or later than Receipt date.';	
	msgs['SAR00006']='The missing {?msg1} row exists.';	
	msgs['SAR00007']='Total amount must be less than or equal to receipt amount.';	
	msgs['SAR00008']='Receipt amount must be equal to total amount.';
	msgs['SAR00009']='At least one row must exist.';
	msgs['SAR00010']='Total amount must be zero in Offset type.';
	msgs['SAR00011']='Receipt amount must be greater than zero.';
	msgs['SAR00012']='Period is closed as Deposit Date.';	
	msgs['SAR00013']='Please enter {?msg1}.';
	msgs['SAR00014']='{?msg1} is duplicated.';	
	msgs['SAR00015']='Please check all rows to reverse.';
	msgs['SAR00016']='No Ex.Rate available.';	
	msgs['SAR00017']='Please enter OTS data in Offset type.';	
	msgs['SAR00018']='Customer does not exist.';	
	msgs['SAR00019']='Outstanding balance amount has been changed.';	
	msgs['SAR00020']='A/R period is closed.';	
	msgs['SAR00021']='Saving is only possible when the balance amount is zero.\n(Balance = Total AR Offset Amount - Total AP Offset Amount)';
	msgs['SAR00022']='Already selected {?msg1} {?msg2}';
	msgs['SAR00023']='A/P GL date must be equal to or later than deposit date.';	
	msgs['SAR00024']='Original Amount has been changed. Please retry.';
	msgs['SAR00025']='Account exchange rate does not exist.';
	msgs['SAR00026']='Only positive amount is allowed for {?msg1}.';
	msgs['SAR00027']='Only negative amount is allowed for {?msg1}.';
	msgs['SAR00028']='Negative exchange rate is not allowed.';
	msgs['SAR00029']='Please check Account Period.';
	msgs['SAR00030']='There is no data to search.';
	msgs['SAR00031']='Please, {?msg1} !';
	msgs['SAR00032']='Failed to save data !';	
	msgs['SAR00033']='Closed already opened ASA';
	msgs['SAR00034']='Account matrix info does not exist.';
	msgs['SAR00035']='COA combination info does not exist.';
	msgs['SAR00036']='Please check Overdue Unreported OTS.';
	msgs['SAR00037']='{?msg1} should be in the same month.';
	msgs['SAR00038']='Do you want to {?msg1}?';
	msgs['SAR00039']='Vendor info does not exist.';
	msgs['SAR00040']='Pay group info does not exist.';
	msgs['SAR00041']='Failed to interface A/P.';
	msgs['SAR00042']='Please select opened ASA no.';
	msgs['SAR00043']='The ASA No is required to receieve ASA amount as remittance. \nDo you want to save anyway?';
	msgs['SAR00044'] = 'Check period from date - it should be later than previous ASA date';
	msgs['SAR00045'] = 'MI/ML limitation(Office Information)is mandatory item.';	//2014.09.18 add
	msgs['SAR00046'] = 'Amount is over {?msg1} limit.';		//2014.09.18 add
	msgs['SAR00047'] = 'Check ASA Period - Not Opened AR Period ({?msg1})';		//2014.10.06 add
	msgs['SAR00048'] = 'No ASA data exist. Please check again.';
	msgs['SAR00049'] = 'ASA currency is different from receipt currency.';
	msgs['SAR00050'] = 'Check Previous ASA Status - Not Approved ({?msg1})';
	msgs['SAR00051'] = 'Please input Code or Name.';
	msgs['SAR00052'] = '{?msg1} does not exist.';
	msgs['SAR00053'] = 'It is transmitted successfully.';
	msgs['SAR00054'] = 'Check period from(Previous ASA : {?msg1} , Period To : {?msg2})';
	msgs['SAR00055'] = 'Check Previous ASA Status - Not Finished ({?msg1})'; 
	msgs['SAR00056'] = 'Cannot retrieve by Office, please use Send button directly.';
	msgs['SAR00057'] = 'Failed to transmit data.';
	msgs['SAR00058'] = 'Please check mandatory item.';
	msgs['SAR00059'] = 'There is no data to save.';
	msgs['SAR00060'] = 'Cannot use \"Row Delete\" Button. Please enter end date and click \"Save\" button';
	msgs['SAR00061'] = 'It exceeds Outstanding Balance.';
	msgs['SAR00062'] = 'Do you want to reverse the selected B/L?';
	msgs['SAR00063'] = 'Cannot close period {?msg1} ,Zero Balance Accounting Creation is running.';
	msgs['SAR00064'] = 'This B/L No(Invoice No) was settled or does not exist. \nPlease enter customer first.';
	msgs['SAR00065'] = 'There is already approval execution in progress. You cannot execute double.'; 
	msgs['SAR00066'] = 'You cannot modify amount if currency doesn\'t exist in Outstanding.'; 
	msgs['SAR00067'] = 'This [{?msg1}] already exist.';
	msgs['SAR00068'] = 'You cannot finish this ASA No. Because there are no interface with this ASA in SAP module.';
/*	msgs['SAR00069'] = 'B/L No : {?msg1} was(were) already reflected to another ASA.\nPlease check agent collection/refund.'; */
	msgs['SAR00069'] = 'B/L No : {?msg1} was(were) already reflected to another ASA,\nor the balance of B/L No : {?msg1} was(were) changed after collected/refunded in this ASA.\nPlease check current agent collection/refund status or outstanding balance.';
	msgs['SAR00070'] = 'You can input only one B/L to apply the local charge.';
	msgs['SAR00071'] = 'You can not input different local charges.';
	msgs['SAR00072'] = "To retrieve all data, please scroll down to the bottom and click down excel.";
	msgs['SAR00073'] = 'The summary amount should be positive for {?msg1}.';
	msgs['SAR00074'] = 'If S.CUR is same with T.CUR, the EX. Rate should be \"1.000000\".';
	msgs['SAR00075'] = '{?msg1} must be at least {?msg2} months before Adjust Date.';
	msgs['SAR00076'] = 'This customer does not exist or has been deleted.';
	msgs['SAR00077'] = 'The Remark contains some special characters.\nPlease check again.';
	msgs['SAR00078'] = "Period of ({?msg1}) was closed.\nSo System entered 1st day of next opend month.\nIf required, please change 'To Period' date.";
	msgs['SAR00079'] = "There is other {?msg1} execution in progress. Please try again after a few minutes.";
	msgs['SAR00080'] = "Receipt process are running by another user. \nPlease try again later.";
	msgs['SAR00081'] = "After APP Reverse, total amount will be larger than receipt amount. \nPlease try to cancel receipt.";
	
	var ROWMARK="|";
    var FIELDMARK="=";	
	/*
	 * @param {string}
	 *            xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @return array Code연결 문자열과 Text연결 문자열이 담긴 배열.
	 * @see #ComXml2ComboString
	 * @author 박명신
	 * @version 2009.06.01
	 */
	function SarXmlToArray(xmlStr) {
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
	/**
	* VoList를 array[array[name]]형태로 변환 
	* @author jinyoonoh 2014.04.22
	* @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo 
	*/
	function SarXml2ListMap(xmlStr) {
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
	* Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정 
	* @param {form} form html 폼 
	* @param {map} Array[name] 의 값 
	* @author jinyoonoh 2014.04.07 -add
	*/
	function SarMapToForm(form, map) {		
			//사용가능한 컨트롤을 배열로 생성한다.
			var len=form.elements.length;
			for (var i=0; i < len; i++) {
				if (form.elements[i].classid == undefined) {
					var xvalue=map[form.elements[i].name];
					if (xvalue == undefined)
						continue;
					switch (form.elements[i].type) {
					case "button":
					case "reset":
					case "submit":
						break;
					case "radio":
						var eRadio=document.all[form.elements[i].name];
						var idx=0;
						for ( var k=0; k < eRadio.length; k++) {
							if (eRadio[k].value == xvalue) {
								idx=k;
								break;
							}
						}
						eRadio[idx].checked=true;
						break;
					case "checkbox":
						form.elements[i].checked=xvalue;
						break;
					case "select-one":
						var eOpt=form.elements[i].options;
						var idx=0;
						if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
							var opt_len=eOpt.length;
							for ( var k=0; k < opt_len; k++) {
								if (eOpt[k].value == xvalue) {
									idx=k;
									break;
								}
							}
						}
						form.elements[i].selectedIndex=idx;
						break;
					case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
						var eOpt=form.elements[i].options;
						var idx=0;
						if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
							var opt_len=eOpt.length;
							var tvalue=xvalue.split("|");
							var tval_len=tvalue.length;
							for ( var k=0; k < opt_len; k++) {
								for ( var m=0; m < tval_len; m++) {
									if (eOpt[k].value == tvalue[m])
										eOpt[k].selected=true;
								}
							}
						}
						break;
					default:
						var dataformat=form.elements[i].getAttribute("dataformat"); 
					    if(typeof dataformat != "undefined" && dataformat != null) {
						   if(dataformat == "ymd") {
							   if (!ComIsNull(xvalue)  && xvalue.length == 8) {
								   form.elements[i].value=ComGetMaskedValue(xvalue, "ymd");
							   }
						   } else if (dataformat == "float") {
							   if (!ComIsNull(xvalue)) {
								   form.elements[i].value=ComGetMaskedValue(xvalue, "float");
							   }
						   } else if (dataformat == "int") {
							   if (!ComIsNull(xvalue)) {
								   form.elements[i].value=ComGetMaskedValue(xvalue, "int");
							   }
						   } else {
							   form.elements[i].value=xvalue;
						   }						   
					    } else {
						   form.elements[i].value=xvalue;
					    }
					}
				}
			}      	
	}
    /**
     *  <br>
     * ComComboObject에 item 추가  <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = SarGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				SarAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param comboObj
     * @param comboItems (SarGetComboItems 에서 얻은 리턴값)
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @see SarGetComboItems
     */ 	
    function SarAddComboItem(comboObj, comboItems, type, appendStr, appendCode) {
    	var cnt=0;
    	if (appendStr != "" ) { 
    		if ( type == "1" ) {
    			comboObj.InsertItem(0, appendStr + "|", appendCode);
            } else  if ( type == "2" ) {            	
            	comboObj.InsertItem(0, appendCode + "|" + appendStr, appendCode);
            }
    		
    		cnt=1;
    	}
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            if ( type == "1" ) {
            	comboObj.InsertItem(cnt, comboItem[0] , comboItem[0]);    
            } else  if ( type == "2" ) {            	
            	comboObj.InsertItem(cnt, comboItem[0] + "|" + comboItem[1] , comboItem[0]);    
            }
            cnt++;
        }  
    }
    /**
     *  <br>
     * SCO_LU_DTL 테이블의 LU_TP_CD 에 따른 정보를 리턴한다. <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = SarGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				SarAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param sheetObj
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I  
     * @see SarAddComboItem
     */   
    function SarGetComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param="";
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=" + sCondition + param);
    	var comboItems=ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems
    }

    function SarGetAcctCtnt2ComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND02 + "&f_acct_ctnt1=" + sCondition + param);
    	var comboItems = ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems
    }
    
    function SarGetAcctCtnt3ComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND03 + "&f_acct_ctnt1=" + sCondition + param);
    	var comboItems = ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems
    }
    
    function SarGetAcctCtnt4ComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND04 + "&f_acct_ctnt1=" + sCondition + param);
    	var comboItems = ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems
    }
    
    /**
     *  <br>
     * SCO_LU_DTL 테이블의 LU_TP_CD 에 따른 정보를 리턴한다. <br>
     * IBSheet의 InitDataCombo 시 이용한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     SarComSearchCombo(sheetObj, prefix + "attr_cate_nm", "2", " " , " ", "SAR_TAX_CHARGE") ;
     * </pre>
     * @param sheetObj
     * @param ibsheet's columnName
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I  
     * 
     */   
    function SarInitDataCombo(sheetObj, colName, type, appendStr, appendCode, sCondition, param) {
    	if (param == undefined ) param="";
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=" + sCondition + param);
    	var comboString=ComXml2ComboString(sXml, "lu_cd", "lu_desc");
        if ( appendStr != "" ) appendStr=appendStr + "|";
        if ( appendCode != "" ) appendCode=appendCode + "|";
        if (type == "1" )  { //코드만 
        	sheetObj.SetColProperty(colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
        } else if (type == "2" ) {
        	var codeStrTemp=comboString[0].split('|'); // 코드
            var nameStrTemp=comboString[1].split('|'); // 이름
            var fullStrTemp='';  // 코드 + 이름  
            for(var i=0; i<codeStrTemp.length; i++){
                fullStrTemp=fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
                if(i != codeStrTemp.length - 1){
                	fullStrTemp = fullStrTemp + '|' ;
                }
            }
            sheetObj.SetColProperty(colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        }
    } 
    
    function SarInitDataAcctCtnt2Combo(sheetObj, Row, colName, type, appendStr, appendCode, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND02 + "&f_acct_ctnt1=" + sCondition + param);    	
    	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
        if ( appendStr != "" ) appendStr = appendStr + "|";
        if ( appendCode != "" ) appendCode = appendCode + "|";        
        if (type == "1" )  { //코드만 
        	sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
        } else if (type == "2" ) {
        	if(comboString == undefined || comboString == ""){
        		sheetObj.CellComboItem(Row, colName, {ComboText:"", ComboCode:""} );
        	}else {
        		var codeStrTemp = comboString[0].split('|'); // 코드
                var nameStrTemp = comboString[1].split('|'); // 이름                
                var fullStrTemp = '';  // 코드 + 이름  
                for(var i=0; i<codeStrTemp.length; i++){
                    fullStrTemp = fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
                    if(i != codeStrTemp.length - 1){
                    	fullStrTemp = fullStrTemp + '|' ;
                    }
                }
                sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        	}
        }
        
    } 
    
    function SarInitDataAcctCtnt3Combo(sheetObj, Row, colName, type, appendStr, appendCode, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND03 + "&f_acct_ctnt1=" + sCondition + param);    	
    	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
        if ( appendStr != "" ) appendStr = appendStr + "|";
        if ( appendCode != "" ) appendCode = appendCode + "|";        
        if (type == "1" )  { //코드만 
        	sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
        } else if (type == "2" ) {
        	if(comboString == undefined || comboString == ""){
        		sheetObj.CellComboItem(Row, colName, {ComboText:"", ComboCode:""} );
        	}else {
        		var codeStrTemp = comboString[0].split('|'); // 코드
                var nameStrTemp = comboString[1].split('|'); // 이름                
                var fullStrTemp = '';  // 코드 + 이름  
                for(var i=0; i<codeStrTemp.length; i++){
                    fullStrTemp = fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
                    if(i != codeStrTemp.length - 1){
                    	fullStrTemp = fullStrTemp + '|' ;
                    }
                }
                sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
        	}
        }
        
    }
    
    function SarInitDataAcctCtnt4Combo(sheetObj, Row, colName, type, appendStr, appendCode, sCondition, param) {
    	if (param == undefined ) param = "";
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND04 + "&f_acct_ctnt1=" + sCondition + param);    	
    	var comboString = ComXml2ComboString(sXml, "lu_cd", "lu_desc");        
        if ( appendStr != "" ) appendStr = appendStr + "|";
        if ( appendCode != "" ) appendCode = appendCode + "|";        
        if (type == "1" )  { //코드만 
        	sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+comboString[0], ComboCode:appendCode+comboString[1]} );
        } else if (type == "2" ) {
        	if(comboString == undefined || comboString == ""){
        		sheetObj.CellComboItem(Row, colName, {ComboText:"", ComboCode:""} );
        	}else {
        		var codeStrTemp = comboString[0].split('|'); // 코드
                var nameStrTemp = comboString[1].split('|'); // 이름                
                var fullStrTemp = '';  // 코드 + 이름  
                for(var i=0; i<codeStrTemp.length; i++){
                    fullStrTemp = fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i];
                    if(i != codeStrTemp.length - 1){
                    	fullStrTemp = fullStrTemp + '|' ;
                    }
                }
                sheetObj.CellComboItem(Row, colName, {ComboText:appendStr+fullStrTemp, ComboCode:appendCode+comboString[0]} );
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
    function SarShowXmlMessage(sXml) {
    	return ComGetSelectSingleNode(sXml, "MESSAGE");
    }
    /**
     * 팝업에서 전달 받은 데이타를 디버그용으로 새창에 표시해준다. 
     * @author jinyoonoh 2014.04.04
     * @param {string} data 필수
     * @return popup window
     * @version 
     */
    function SarShowPopupData(data) {
        var inHTML="<table border='1' style='border-collapse:collapse;empty-cells:show;width:100%'>";
        inHTML += "<tr>";   
        inHTML += "<th>No.</th>";
        for(var i=0; i <  data[0].length; i++) {          
            inHTML += "<th> " + i +"</th>";
        }       
        inHTML += "</tr>";  
        for(var i=0; i <  data.length; i++) {     
            var row=data[i];
            inHTML += "<tr>";
            inHTML += "<td>" + (i+1) + "</td>";
            for (var j=0; j < row.length; j++) {
                inHTML += "<td style='white-space:nowrap'>" + row[j] +"</td>";
            }       
            inHTML += "</tr>";
        }
        inHTML += "</table>";           
        var win=window.open("about:blank", "_blank", "width=500,height=500,scrollbars=yes,resizable=yes");    
        win.document.body.innerHTML=inHTML;   
    }
    /**
     * IE9 이상시 console.log 이용  하여  디버그   
     * @author jinyoonoh 2014.04.04
     * @param {obj} string, obj 필수
     * @version 
     */    
    function debugConsole(obj) {
    	if(typeof console != "undefined" && typeof console.log != "undefined") {
    		console.log(obj);
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
     * Delete  checked row <br>
     * @param {ibsheet} sheet 
     * @param {int} row
     * @author jinyoonoh
     * @version 2009.05.13
     */
     function SarCheckedRowDelete(sheet, colName) {
    	var sRow=sheet.FindCheckedRow(colName);
 		if (sRow == "") {
 			ComShowCodeMessage("COM12189");
 			return ;
 		}
    	var hRow=sheet.HeaderRows();
    	sheet.SetRedrawSum(0);
    	for (var row=hRow; row <= sheet.RowCount(); row++) {
    		var status=sheet.GetRowStatus(row);
    		if (sheet.GetCellValue(row, colName) == 1) {
    			SarRowDelete(sheet,  row);
    			if (status == "I") {
        			row--;
            	} 
    		}
    	}    
    	sheet1.SetRedrawSum(1);
     }      
     /**
      * Change Cell Edit Mode <br>
      * @param {ibsheet} sheet 
      * @param {String} colName
      *  @param {Boolean} editFlg
      * @author jinyoonoh
      * @version 2013.05.07
      */
     function SarGetCellEditable(sheet, colName, editFlg) {
    	var hRow=sheet1.HeaderRows();
    	for (var row=hRow; row <= sheet.RowCount(); row++) {
    		sheet.SetCellEditable(row, colName,editFlg);
    	}   
     }      
     /**
      * Rd get XML DATA <br>
      * @param {ibsheet} sheet 
      * @param {Number} sheet no
      * @author jinyoonoh
      * @version 2013.05.07
      */
     function SarRdGetDataXml(sheet_obj, no)  {
       //함수 인자 유효성 확인
         if  ((!sheet_obj) || (!sheet_obj.IBSheetVersion)){
        	 return alert("SarRdGetDataXml 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
	     }
       
       var rowXml="";
       var allXml="<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.GetTotalRows()+"'>";
       var rowcount=sheet_obj.RowCount()+ sheet_obj.HeaderRows() - 1;
       for (ir=sheet_obj.HeaderRows(); ir <= rowcount; ir++) {
     	rowXml="<TR>";
     	for (ic=0; ic<= sheet_obj.LastCol(); ic++) {
     	  var  saveName=sheet_obj.ColSaveName(ic);
     	  rowXml += "<"+saveName+"><![CDATA[" + sheet_obj.GetCellValue(ir,ic) + "]]></"+saveName+">";
     	}
     	rowXml += "</TR>";
     	allXml += rowXml;
       }
       allXml += "  </DATA></SHEET" + no + ">";
       return allXml;
     }     
     /**
      * set Report RD rv parameter
      * @author jinyoonoh 2014-06-27 
      * @return
      */
     function SarRdCondAllValue(frm) {     	
     	var vObjects=frm.elements;
     	var vCondStr="";
     	for ( var kdx=0; kdx < vObjects.length; kdx++) {
     		var vObj=vObjects[kdx];
     		var vObjTp=vObj.type;
     		var vObjNm=vObj.name;         	
     		if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
     			continue;
     		}
     		vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
     	} //end for
     	return vCondStr;
     }     
     /**
     * Common RD View Open
     * @author jinyoonoh 2014-06-27 
     */
     function SarRdPopup(width,height) {	
     	var url="STM_SAR_9001.do";		
     	var winName="STM_SAR_9001";
     	var rdWin=ComOpenWindowCenter("about:blank",winName,width,height);	
     	frm.action=url;
     	frm.method="post";
     	frm.target=winName;
     	frm.submit();
     	frm.target="";
     	rdWin.focus();
     	return rdWin;
     }   
     

     /**
      * Check Lookup Data
      * @param {ibsheet} sheet 
      * @param {param} param
      */     
     function chkLookupOneData(sheetObj, param) {
     	if( ComTrim(param) == "") return "";
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + param + "&lu_appl_cd=SAR");
     	if (SARDecideErrXml(sheetObj, sXml)) {
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
      * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
      *
      * @param {string} shtObj 필수, IBSheet Object
      * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
      * @return {Boorean}
      */
     function SARDecideErrXml(shtObj, xmlStr) {
         if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
         if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
             shtObj.LoadSearchData(xmlStr,{Sync:1} );
             return true;    // Error일때
         } else {
             return false;
         }
     }     
     
     /**
      * 특정값을 특정 소숫점 자리만큼 반올림한 값을 리턴한다. <br>
      * 
      * @param {number,object} obj   필수,대상 숫자값 또는 HTML태그(Object)
      * @param {number}        pos   선택,소숫점 아랫자리 개수, default=2
      * @returns number,대상 숫자를 소숫점 자리만큼 반올림한 수
      */
     function SarRound(obj, pos) {
         try {
             //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
             var num = getArgValue(obj);
             if (pos==undefined || pos==null ) pos = 0;
             
             var val = String(num); 
        	 if (isNaN(parseFloat(val))) return ""; 
        	 val = parseFloat(val).toFixed(8);
        	 
        	 return ComRound(parseFloat(val),pos);
         } catch(err) { ComFuncErrMsg(err.message); }
     } 
     
     /**
      * 
      * @param {Number} float or Int
      * @param {Int} 소수점 자리수
      * @return {String} formatting number Str
      */
     function SarMakeNumberFormat(recval,dpPrcsKnt){
    	 var val = String(recval);
    	 if (isNaN(parseFloat(val))) return "";   
    	 val = parseFloat(val).toFixed(8);
    	 recval = ComRound(parseFloat(val),2);
    	 val = String(recval);
    	 var numberFormat = "#,###";
    	 if(ComIsNull(dpPrcsKnt)){ 
    		 dpPrcsKnt = 0;
    	 } 
    	 if(dpPrcsKnt > 0){
    		 numberFormat += '.';
    		 for (var i=1; i<= dpPrcsKnt; i++){
    			 numberFormat += '0';
    		 }
    	 }  
    	 var retVal = ComAddCommaFormat(val, numberFormat);   
    	 return retVal; 
     }
     
     /**
      * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
      * sFormat="#,###"     : 천단위구분만 하는것으로 {@link #ComAddComma} 함수와 동일하다. <br>
      * sFormat="#,###.0"   : 천단위구분과 소숫점한자리를 표시한다. <br>
      * sFormat="#,###.00"  : 천단위구분과 소숫점두자리를 표시한다. <br>
      * sFormat="#,###.000" : 천단위구분과 소숫점세자리를 표시한다. <br>
      * @param {string,object}   obj      필수,숫자문자열 또는 HTML태그(Object)
      * @param {string}          sFormat  숫자 포멧
      * @returns string, 숫자포멧이 설정된 문자열<br>
      *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
      */
      function ComAddCommaFormat(obj,sFormat)
      {
          try {
              //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
              var sVal = getArgValue(obj);

              switch(sFormat)
              {
                  case "#,###" :
                          return ComAddComma(sVal);
                  case "#,###.0" :
                          p = sVal.split(".");
                          p[0] = ComAddComma(p[0]);
                          if      (p.length == 1) return p[0]+".0";
                          else if (p.length == 2) return p[0]+"."+p[1];
                          else return "";
                  case "#,###.00" :
                          p = sVal.split(".");
                          p[0] = ComAddComma(p[0]);
                          if      (p.length == 1) return p[0]+".00";
                          else if (p.length == 2) {
                          	if(p[1].length == 1)
                          		return p[0]+"."+p[1]+"0";
                          	else
                          		return p[0]+"."+p[1];
                          }
                          else return "";
                  case "#,###.000" :
	                      p = sVal.split(".");
	                      p[0] = ComAddComma(p[0]);
	                      if      (p.length == 1) return p[0]+".000";
	                      else if (p.length == 2) {
	                      	if(p[1].length == 1) 
	                      		return p[0]+"."+p[1]+"00";
	                      	else if(p[1].length == 2) 
	                      		return p[0]+"."+p[1]+"0";
	                      	else
	                      		return p[0]+"."+p[1];
	                      }
	                      else return "";
              }
          } catch(err) { ComFuncErrMsg(err.message); }
      }
      
     
     /**
      * popup Resizable controll을 위해 
      */
     function SarOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, sScroll, addHeight, sResizable) {
    	 if (sScroll == undefined || sScroll == null) sScroll = "no";
    	 try {
    		var leftpos = (screen.width - iWidth) / 2;
    		if (leftpos < 0)
    			leftpos = 0;
    		var toppos = (screen.height - iHeight) / 2;
    		if (toppos < 0)
    			toppos = 0;
    		else
    			if(addHeight != undefined) {
    				toppos += addHeight;
    			}

    		if (bModal) {
    			/* LAYER POPUP */
    			return ComOpenWindow(sUrl, sWinName,
    					"scroll:"+sScroll+";status:no;help:no;dialogWidth:" + iWidth
    							+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
    							+ leftpos + ";dialogTop:" + toppos, true);
    			
    		} else {
    			/* WINDOW POPUP */
    			return ComOpenWindow(sUrl, sWinName,
    					"status=no, resizable="+sResizable+", scrollbars="+sScroll+", width=" + iWidth
    							+ ", height=" + iHeight + ", left=" + leftpos
    							+ ", top=" + toppos);
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    }
    
    function SarComOpenWaitRemove(fadeYn){
    	if(fadeYn){
    		ComOpenWait(false);
    	} else {
    		$(".layer_wait_bg,.layer_wait").hide(); 
    	}
    } 
    
    //for wait show/close check
    var isOpenWaitWindow = false;
    
    /**
     * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
     * @param {bool}   hideYn       hide, fade 여부 
     * @return 없음
     * @see #ComOpenWaitCallFunc
     */
    function SarOpenWait(flag, hideYn){
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
     * Thailand Local Charge List
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @return {string}
     */	    
    function SARGetTHLocalChgList(sheetObj) {
    	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_appl_cd=SAR&lu_tp_cd=TH LOCAL CHARGE");
     	     	
    	var comboString=ComXml2ComboString(sXml, "lu_cd", "lu_desc");
    	return comboString[0];
    }    