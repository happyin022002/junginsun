/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoSco.js
*@FileTitle  : SCO COMMON SCRIPT
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
	
	msgs['SCO00001'] = 'Data was saved successfully!';
	msgs['SCO00002'] = 'There is no data!';
	msgs['SCO00003'] = 'Failed to save data. Please contact system administrator!';	
	msgs['SCO00004'] = 'Please {?msg1} {?msg2}.';
	msgs['SCO00005'] = "You must retrieve first before adding row.";
	msgs['SCO00006'] = 'Only positive amount is allowed for {?msg1}.';
	msgs['SCO00007'] = 'Only negative amount is allowed for {?msg1}.';
	msgs['SCO00008'] = "There is no data {?msg1}";
	msgs['SCO00009'] = "Do you want to {?msg1}?";
	msgs["SCO00010"] = "There is no content to save.";
	msgs['SCO00011'] = 'To date must be equal to or later than From date.';
	msgs['SCO00012'] = "Data is duplicated.{?msg1}";
	msgs['SCO00013'] = "please setup office information first in A/R Invoice module(FNS_INV_0073)";
	msgs['SCO00014'] = "There is a lack of data for pop-up display.";
	msgs['SCO00015'] = 'It is transmitted successfully.';
	msgs['SCO00016'] ="When you choose 'DocType', you can retrieve 1 month data. In other case, you can retrieve 10 days data.";
	msgs['SCO00017'] = "To retrieve all data, please scroll down to the bottom and click 'Down Excel'.";
	var ROWMARK="|";
    var FIELDMARK="=";	
    /**
     *  <br>
     * ComComboObject에 item 추가  <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = ScoGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				ScoAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param comboObj
     * @param comboItems (ScoGetComboItems 에서 얻은 리턴값)
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @see ScoGetComboItems
     */ 	
    function ScoAddComboItem(comboObj, comboItems, type, vacantRow) {
    	var cnt=0;
    	if (vacantRow == "Y" ) { 
    		comboObj.InsertItem(0, "", "");
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
     *     var currComboItems = ScoGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				ScoAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param sheetObj
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I  
     * @see ScoAddComboItem
     */   
    function ScoGetLookupComboItems(sheetObj, sCondition, param) {
    	if (param == undefined ) param="";
     	var sXml=sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_tp_cd=" + sCondition + param);
    	var comboItems=ComGetEtcData(sXml, "lu_cd_list").split(ROWMARK);	
    	return comboItems;
    }
    /**
     *  <br>
     * General Combo Return <br>
     * jsp에서 ComComboObject() 함수 사용시 <br>
     * <br><b>Example : </b>
     * <pre>
     *     var currComboItems = ScoGetComboItems(sheetObj, "SAR_TAX_CHARGE");
				ScoAddComboItem(comboObjects[0], currComboItems, "1", "ALL", "ALL") 				
     * </pre>
     * @param sheetObj
     * @param url  ex) STMCommonGS.do
     * @param fCmd ex) COMMAND01
     * @param sCondition  ("&lu_tp_cd= ?" ) 
     * @param listName    ex) lu_cd_list
     * @see ScoAddComboItem
     */   
    function ScoGetComboItems(sheetObj, url, fCmd, sCondition, listName) {
    	var sXml=sheetObj.GetSearchData(url, "f_cmd=" + fCmd + sCondition);
		var sStr=ComGetEtcData(sXml, listName);
		var arrStr=sStr.split("|");	
		return arrStr
    }
    /**
     * create combo box<br>
     * <br><b>Example : </b>
     * <pre>
     *    MakeOfcComboObject(cmbObj, arrStr, div);
     * </pre>
     * @param object cmbObj
     * @param String arrStr
     * @author Park hee Jin
     * @version 2014.03.24
     */
    function MakeComboObject(cmbObj, arrStr, vacantRow) {
    	var cnt=0;
    	if (vacantRow == "Y") {
    		cmbObj.InsertItem(0, "", "");
    		cnt=1;
    	}
    	for (var i=1; i < arrStr.length; i++ ) {
    		var arrStr2=arrStr[i].split("^");
    		var code=arrStr2[0];
    		cmbObj.InsertItem(cnt, code, arrStr[i]);
    		cnt++;
    	}
    	cmbObj.SetDropHeight(190);
    }
    
    
    /**
     *  <br>
     * SCO_LU_DTL 테이블의 LU_TP_CD 에 따른 정보를 리턴한다. <br>
     * IBSheet의 InitDataCombo 시 이용한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     ScoInitDataCombo(sheetObj, prefix + "attr_cate_nm", "2", " " , " ", "SAR_TAX_CHARGE") ;
     * </pre>
     * @param sheetObj
     * @param ibsheet's columnName
     * @param type ( 1: code, 2 : code, name )
     * @param appendStr (ALL, SELECT 등 문자열 추가시 codedesc)
     * @param appendCode (ALL, SELECT 등 문자열 추가시 추가된 code)
     * @param sCondition  (SCO_LU_DTL 테이블의 LU_TP_CD ) 
     * @param param       (추가적으로 조회조건을 추가할 경우 SCO_LU_DTL 테이블의 컬럼명을 기준으로 한다. 필수는 아님.  ) 예) &attr_ctnt1=I 
     */   
    function ScoInitDataCombo(sheetObj, colName, type, appendStr, appendCode, sCondition, param, showCol) {
    	if (param == undefined ) param = "";
    	if (showCol == undefined ) showCol = 0;
    	var sXml = sheetObj.GetSearchData("STMCommonGS.do", "f_cmd=" + COMMAND01 + "&lu_appl_cd=SCO" + "&lu_tp_cd=" + sCondition + param);
    	
    	var combo_code = ComGetEtcData(sXml,"combo_code");
		var combo_nm = ComGetEtcData(sXml,"combo_nm");
		
		if (type == "1" )  { //코드만 
        	sheetObj.InitDataCombo(0, colName, appendStr + combo_nm, appendCode + combo_code);
        } else if (type == "2" ) {
        	appendStr = appendCode + "\t" + appendStr ;
            sheetObj.InitDataCombo(0, colName, appendStr +  combo_nm, appendStr +  combo_code, "","",showCol);
        } 
       
    }  
    
    /**
     * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @return {Boorean}
     */
    function SCODecideErrXml(shtObj, xmlStr) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
            shtObj.LoadSearchXml(xmlStr);
            return true;    // Error일때
        } else {
            return false;
        }
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
    function ScoAddComboItem2(comboObj, comboItems, type, appendStr, appendCode) {
    	var k = 0;
    	if (appendStr != "" ) { 
    		comboObj.InsertItem(0, appendStr, appendCode);
    		k = 1;
    	}
    	
    	
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
            if ( type == "1" ) {
            	comboObj.InsertItem(k, comboItem[0] , comboItem[0]);    
            } else  if ( type == "2" ) {            	
            	comboObj.InsertItem(k, comboItem[0] + "|" + comboItem[1] , comboItem[0]);    
            }
            k++;
        }        
    }     
    
    /**
     * Xml에서 데이타가 있는지 없는지만 판단 <br>
     * true ==> 데이타 없음 / false ==> 데이타 있음 <br>
     * <b>Example :</b>
     * 
     * <pre>
     * if (ScoIsEmptyXml(xmlStr)) {
     * 	//do anything
     * }
     * </pre>
     * 
     * @param {Xml}
     *            xmlStr 필수,조회결과 xml
     * @return {bool} true ==> 데이타 없음 / false ==> 데이타 있음
     */
    function ScoIsEmptyXml(xmlStr) { 
    	var rtnArr=new Array();
    	if (xmlStr == null || xmlStr == "") {
    		return true;
    	}
    	try {
    		var xmlDoc = ComGetXmlDoc(xmlStr);
    		if (xmlDoc == null) return;
    		var xmlRoot = xmlDoc.documentElement;
    		if (xmlRoot == null) {
    			return true;
    		}
    		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    		if (dataNode == null || dataNode.attributes.length < 3) {
    			return true;
    		}
    		var dataChildNodes=dataNode.childNodes;
    		if (dataChildNodes == null) {
    			return true;
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return false;
    }
    
    /**
     * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
     * @param {bool}   hideYn       hide, fade 여부 
     * @return 없음
     * @see #ComOpenWaitCallFunc
     */
    function ScoOpenWait(flag, hideYn){
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
	 * 조회한 xml데이터의 MESSAGE를 가져온다.<br>
	 * 
	 * @param {string} sXml 필수
	 * @return xml의 <MESSAGE> Node 값
	 * @version 2009.09.01
	 */
    function ScoShowXmlMessage(sXml) {
    	return ComGetSelectSingleNode(sXml, "MESSAGE");
    }
