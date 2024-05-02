/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6005.js
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_PRI_6005 : ESM_PRI_6005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6005() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;
	
	var subDataCnt = 0;
	var isAproUsr = true;
	
	var selectedGlineSeq = null;
	
	//ver no combo 선택 여부
	var isSelectedVerno = false;
	
	var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";
	var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @param 없음
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
	
			case "btn_New":
				removeAll(document.form);
				clearAllTabPages();
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
				
			case "btn_Delete":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				break;
	
			case "btn_Cancel":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
				break;
				
			case "btn_Copy":
				if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC03)) {
					var sUrl = "/hanjin/ESM_PRI_6008.do?" + FormQueryString(document.form);
					ComPriOpenWindowCenter(sUrl, "ESM_PRI_6008", 500, 258, true);
				}

				break;
				
			case "btn_Version":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
				break;	
				
            case "btns_calendar": //달력버튼
//    			if (comboObjects[0].Code == "") {
//    				ComShowCodeMessage('PRI08002');
//    				return false;
//    			}

                var cal = new ComCalendarFromTo();
                cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
                break;
                
            case "btn_Proposal":
            	if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC06)) {
					var sUrl = "/hanjin/ESM_PRI_6033.do?" + FormQueryString(document.form);
					ComPriOpenWindowCenter(sUrl, "ESM_PRI_6033", 606,260, true);
				}

				break;	
	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
     * IBSheet tab Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setTabObject(tab_obj);
     * </pre>
     * @param {tab Object} tab_obj 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	
	/**
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function loadPage() {
		for (var i = 0; i < sheetObjects.length; i++) {
			initSheet(sheetObjects[i], i + 1);
		}
	
		for (var k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		
//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		
	    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
		
		preWidth = window.document.body.clientWidth;
		
		document.form.estm_mqc_qty.value = "1";

	}
	
	
	/**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function loadComboList() {
    	sheetObjects[0].WaitImageVisible = false; 
    	
		toggleButtons("");
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		
		document.form.qttn_no.focus();
		
	   	sheetObjects[0].WaitImageVisible = true; 
    }
	
	
	/**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "qttn_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                } 
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            
            default:
        }
    }    
	
	/**
     * 고객명을 조회하여 세팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setCustomerName(formObj)
     * </pre>
     * @param {form} formObj
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */ 
	function setCustomerName(formObj) {
		
		if(!ComIsEmpty(formObj.cust_cnt_cd) && !ComIsEmpty(formObj.cust_seq)) {
			form.etc1.value = formObj.cust_cnt_cd.value;
			form.etc2.value = formObj.cust_seq.value;
			form.etc3.value = "N";
			//SC RFA 구분
			form.etc5.value = "";
			
			formObj.f_cmd.value = COMMAND07;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", sParam);
			var arrDesc = ComPriXml2Array(sXml, "cd|nm");
			if (arrDesc != null && arrDesc.length > 0) {
				formObj.prc_cust_tp_cd.Code2 = arrDesc[0][0];
				formObj.cust_nm.value = arrDesc[0][1];
			} else {
				ComShowCodeMessage("PRI03004","Customer");
				formObj.cust_seq.value = "";
				formObj.cust_nm.value = "";
				formObj.prc_cust_tp_cd.Index2 = "-1";
				formObj.cust_seq.focus();
			}
		}
	}
	
	/**
     * Onbeforedeactivate  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0]; 
        var sheetObj1 = sheetObjects[0];    
        var eleName = event.srcElement.name;

        switch(eleName){
            case "cust_cnt_cd":
                ComChkObjValid(event.srcElement);
                break;          
            case "cust_seq":
                var custSeq = formObj.cust_seq.value;

                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value = ComLpad(custSeq, 6, "0");

                }
                
                setCustomerName(formObj);
                
                break;
              
            case "eff_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "exp_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "estm_mqc_qty":
                ComChkObjValid(event.srcElement);   
                break;              
            	
            default:
                ComChkObjValid(event.srcElement);       
        }
        
    }    

	/**
     * 화면을 전체 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function removeAll(formObj) {
 		
 		var auth = formObj.authCode.value;
 		
 		var srep_cd_hidden = formObj.srep_cd_hidden.value;
 		var qttn_ofc_cd_hidden = formObj.qttn_ofc_cd_hidden.value;
 		
 		formObj.reset();
 		
 		if(!ComIsEmpty(formObj.qttn_no.value)) formObj.qttn_no.value = "";
 		
 		formObj.authCode.value = auth;
 		
 		formObj.srep_cd_hidden.value = srep_cd_hidden;
 		formObj.etc1.value = qttn_ofc_cd_hidden;
 		formObj.qttn_ofc_cd_hidden.value = qttn_ofc_cd_hidden;
 		formObj.qttn_ofc_cd.value = qttn_ofc_cd_hidden;

        formObj.estm_mqc_qty.value = "0";
   
        formObj.grp_loc_cnt.value = "0";
        formObj.grp_cmdt_cnt.value = "0";
        formObj.rate_cnt.value = "0";
        formObj.rate_g_cnt.value = "0";
        formObj.rate_s_cnt.value = "0";
       
 		comboObjects[0].removeAll();
 		comboObjects[1].Index = "-1";
 		comboObjects[2].Index = "-1";
 		comboObjects[3].Index = "-1";
// 		comboObjects[4].Index = "-1";
 		comboObjects[4].Text2 = "FEU";
 		
 		//페이지별 권한을 재조회한다.
		formObj.authCode.value = checkAuthSvcScope("");
		
		//세션 정보로 srep combo list를 조회한 후 세팅한다.
		formObj.f_cmd.value = SEARCH15;  
		  
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.qttn_srep_cd, "cd", "cd|nm");
        formObj.qttn_srep_cd.Code2 = formObj.srep_cd_hidden.value;
        formObj.qttn_srep_nm.value = formObj.qttn_srep_cd.GetText(formObj.srep_cd_hidden.value,1);
 		
 		toggleButtons("");
 		
 		clearAllTabPages();
 		
 		document.form.estm_mqc_qty.value = "1";
 		
 		document.form.qttn_no.focus();
 	}
 	
 	/**
     * 화면을 부분 리셋한다.<br>
     * Quotation no, authCode를 제외하고 초기화한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll2(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function removeAll2(formObj) {
 		
 		var qttn_no = formObj.qttn_no.value;
 		var auth = formObj.authCode.value;
 		
 		var srep_cd_hidden = formObj.srep_cd_hidden.value;
 		var qttn_ofc_cd_hidden = formObj.qttn_ofc_cd_hidden.value;
 		
 		formObj.reset();
 		
 		if(!ComIsEmpty(formObj.qttn_no.value)) formObj.qttn_no.value = "";
 		
 		formObj.qttn_no.value = qttn_no;
 		formObj.authCode.value = auth;
 		
 		formObj.srep_cd_hidden.value = srep_cd_hidden;
 		formObj.etc1.value = qttn_ofc_cd_hidden;
 		formObj.qttn_ofc_cd_hidden.value = qttn_ofc_cd_hidden;
 		
 		
 		
 		formObj.estm_mqc_qty.value = "";
 		
 		formObj.grp_loc_cnt.value = "0";
        formObj.grp_cmdt_cnt.value = "0";
        formObj.rate_cnt.value = "0";
        formObj.rate_g_cnt.value = "0";
        formObj.rate_s_cnt.value = "0";
 		
 		comboObjects[0].removeAll();
 		comboObjects[1].Index = "-1";
 		comboObjects[2].Index = "-1";
 		comboObjects[3].Index = "-1";
// 		comboObjects[4].Index = "-1";
 		comboObjects[4].Text2 = "TEU";
 		
 		//페이지별 권한을 재조회한다.
		formObj.authCode.value = checkAuthSvcScope("");
		
		//세션 정보로 srep combo list를 조회한 후 세팅한다.
		formObj.f_cmd.value = SEARCH15;  
		  
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.qttn_srep_cd, "cd", "cd|nm");
        formObj.qttn_srep_cd.Code2 = formObj.srep_cd_hidden.value;
        formObj.qttn_srep_nm.value = formObj.qttn_srep_cd.GetText(formObj.srep_cd_hidden.value,1);
        
 		
 		toggleButtons("");
 		
 		clearAllTabPages();
 		
 		document.form.estm_mqc_qty.value = "1";
 		
 		document.form.qttn_no.focus();
 	}
 	
 	
 	/**
     * srep combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function qttn_srep_cd_OnChange(comboObj, code, text) {
  		
  		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
 	 			
			var formObj = document.form;
			
			var arrText = text.split("|");
			
			if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
				
				formObj.qttn_srep_nm.value = formObj.qttn_srep_cd.GetText(code,1);
				
				formObj.qttn_srep_nm.focus();
			}
 			
  		}	
 	}
  	
  	/**
     * srep combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function qttn_srep_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.qttn_srep_nm.value = "";
		
		comboObj.Index2 = -1;
	}
  	
  	/**
     * srep combo 포커스 아웃시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function qttn_srep_cd_OnBlur(comboObj) {
  		
		var formObj = document.form;
			
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			
			var text = comboObj.GetText(code, 1);
			
			if (text != null && text != "" && text != formObj.qttn_srep_nm.value) {
				
				formObj.qttn_srep_nm.value = comboObj.GetText(code, 1);
				
				formObj.qttn_srep_nm.focus();
			}
		}
	}
 	
 	
  	/**
     * service scope combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function svc_scp_cd_OnChange(comboObj, code, text) {
  		
  		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
 	 			
			var formObj = document.form;
			
			var arrText = text.split("|");
			
			if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
				
				formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);
				
				formObj.svc_scp_nm.focus();
			}
 			
  		}	
 	}
  	
  	/**
     * service scope combo 초기화시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	}
  	
  	/**
     * service scope combo 포커스 아웃시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnBlur(comboObj) {
  		
		var formObj = document.form;
			
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			
			var text = comboObj.GetText(code, 1);
			
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
				
				formObj.svc_scp_nm.focus();
			}
		}
	}
  	
  	
  	
  	/**
     * 이벤트가 발생시 rct_ofc_cd 콤보를 조회하고 hidden 값으로 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSalesRepCd()
     * </pre>
     * @param 없음
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
    function setSalesRepCd() {
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH15;  
    	
    	formObj.etc1.value = formObj.qttn_ofc_cd.value; 
		  
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.qttn_srep_cd, "cd", "cd|nm");
        
		//조회한 히든 값으로 세팅
		comboObjects[1].Code  		= formObj.qttn_srep_cd_hidden.value;
		var code = formObj.qttn_srep_cd.FindIndex(formObj.qttn_srep_cd.Code, 0);
		formObj.qttn_srep_nm.value = formObj.qttn_srep_cd.GetText(code,1);
    }
    
    
    /**
     * 이벤트가 발생시 svc scope에 따른 권한을 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		checkAuthSvcScope()
     * </pre>
     * @param 없음
     * @return 권한 유형 있음 : A , 없음 : X   
     * @author 이승준
     * @version 2009.06.10
     */
    function checkAuthSvcScope(svc_scp_cd) {
    	var formObj = document.form;
    	formObj.f_cmd.value = "";  
    	
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_6005GS.do",FormQueryString(formObj)+ "&svc_scp_cd="+svc_scp_cd);
        
        return ComGetEtcData(sXml, "auth_type")
        
    }
    

    
    /**
     * Cmdt seq 별 rate data가 있는지 체크한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		checkExistRate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function checkExistRate() {
    	
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH05;  
    	
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_6005GS.do",FormQueryString(formObj));
        
        return ComGetEtcData(sXml, "cnt_non_rate")
        
    }
 	
	
    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		
		case IBSEARCH_ASYNC20: // 화면 로딩시 Tab Count 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
			var arrTabCnt = ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|rate_cnt|rate_g_cnt|rate_s_cnt");
			if (arrTabCnt != null && arrTabCnt.length > 0) {
				for (var i = 0; i < arrTabCnt[0].length; i++) {
					if(i < 3) {
						if (parseInt(arrTabCnt[0][i]) > 0) {
							tabObjects[0].ImageUrl(i) = ICON_URL_EXIST;
						} else {
							tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
						}
					}
					
					if(i==0) formObj.grp_loc_cnt.value = arrTabCnt[0][i];
					if(i==1) formObj.grp_cmdt_cnt.value = arrTabCnt[0][i];
					if(i==2) formObj.rate_cnt.value = arrTabCnt[0][i];
					if(i==3) formObj.rate_g_cnt.value = arrTabCnt[0][i];
					if(i==4) formObj.rate_s_cnt.value = arrTabCnt[0][i];
				}
			}
			break;
		
		case IBCLEAR: 
			
			// 온로딩시  sales rep combo 조회
			formObj.f_cmd.value = SEARCH15;  
			  
	        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
	        ComPriXml2ComboItem(sXml, formObj.qttn_srep_cd, "cd", "cd|nm");
	        formObj.qttn_srep_cd.Code2 = formObj.srep_cd_hidden.value;
	        formObj.qttn_srep_nm.value = formObj.qttn_srep_cd.GetText(formObj.srep_cd_hidden.value,1);
	        
	        
	        // 화면 로딩시 Service Scope 조회
 			formObj.f_cmd.value = SEARCH01;
 			formObj.etc5.value="PRS";
 			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 			ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
 			
 			
 			// 화면 로딩시customer type 조회
//			formObj.f_cmd.value = SEARCH20;
////			formObj.cd.value="CD02085";
//			formObj.cd.value="CD01714";
//			
//			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
//			ComPriXml2ComboItem(sXml, formObj.prc_cust_tp_cd, "cd", "nm");
//			//formObj.prc_cust_tp_cd.InsertItem(0,'','|');
//			
//			//code가 BOTH 인 경우  삭제 후   Text를 ""로 세팅
//			var itemindex = formObj.prc_cust_tp_cd.FindIndex("BOTH",0);
			
			
			// 화면 로딩시customer type 조회
			formObj.f_cmd.value = SEARCH20;
			formObj.cd.value="CD01714";
			
			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, formObj.prc_cust_tp_cd, "cd", "cd|nm");
			
			
			
			// 화면 로딩시 est MQC 조회
		    formObj.f_cmd.value = SEARCH19;
            formObj.cd.value="CD00897";
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
            ComPriXml2ComboItem(sXml, formObj.cntr_lod_ut_cd, "cd", "nm");
            formObj.cntr_lod_ut_cd.Text2 = 'FEU';
//            formObj.cntr_lod_ut_cd.InsertItem(0,'','');
            
            
            if (formObj.qttn_no.value != "") {  // Inquiry 에서 넘어오는 경우 해당 quotation No로 조회함.
            	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
            	//만약 inquiry에서 version no가 넘어 왔다면 해당 version을 select함.
            	if( formObj.inquiry_qttn_ver_no.value != ""){
            		formObj.qttn_ver_no.Code2=formObj.inquiry_qttn_ver_no.value; 
            		isSelectedVerno = true;
            	}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
	        
			break;
			
		case IBCREATE: // QUOTATION NO 입력 후 조회시 qttn_ver_no COMBO LIST
			
			if (!validateForm(sheetObjects[0],document.form,sAction)) return;
			
			formObj.qttn_ver_no.RemoveAll();
			
			formObj.f_cmd.value = SEARCH01;
			
			formObj.qttn_no.value = formObj.qttn_no.value.toUpperCase();
			
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", sParam);
			var arrData = ComPriXml2Array(sXml, "qttn_ver_no");
			
			//qttn ver max +1 add version 
			var max_attn_ver_no = "";

			if (arrData != null && arrData.length > 0) {
				ComPriXml2ComboItem(sXml, formObj.qttn_ver_no, "qttn_ver_no", "qttn_ver_no", false);

				//add version 
				var max_qttn_ver_no = arrData[0][0]; 
					
				var no = 0;
				no = parseInt(max_qttn_ver_no.substr(1,1))+1;
				max_qttn_ver_no = "Q" + no;
				
				formObj.max_qttn_ver_no.value = max_qttn_ver_no;
			}
			
//			toggleButtons("CLEAR");
			
			break;
		
		case IBSEARCH: // 조회
			if (!validateForm(sheetObjects[0],document.form,sAction)) {
//				ComShowCodeMessage('PRI08001');
				return false;
			}
			
			try {
				ComOpenWait(true);
			
				if(!isSelectedVerno) 
					doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				
				isSelectedVerno = false;


				//페이지별 권한을 재조회한다.
				formObj.svc_scp_cd.Index = "-1";
				formObj.authCode.value = checkAuthSvcScope("");
				
				formObj.f_cmd.value = SEARCH01;
			
				formObj.qttn_no.value = formObj.qttn_no.value.toUpperCase();
				
				var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
					
					
					
				var arrData = ComPriXml2Array(sXml, "qttn_no|qttn_ver_no|eff_dt|exp_dt|svc_scp_cd|cust_cnt_cd|cust_seq" +
													"|cntr_lod_ut_cd|estm_mqc_qty|estm_cm_amt|prc_cust_tp_cd|qttn_srep_cd" +
													"|prop_no|prs_xch_rt_yrmon|qttn_ofc_cd|qttn_sts_cd|cre_usr_id|cre_dt" +
													"|qttn_sts_nm|iscopy|cust_nm|need_calc");
				
				
				if (arrData != null && arrData.length > 0) {
					formObj.qttn_no.value = arrData[0][0];
					formObj.qttn_no_hidden.value = arrData[0][0];
					formObj.qttn_ver_no.Code2 = arrData[0][1];
					formObj.qttn_ver_no_hidden.value = arrData[0][1];
					
					formObj.eff_dt.value = arrData[0][2];
					formObj.exp_dt.value = arrData[0][3];
					
					formObj.svc_scp_cd.Code = arrData[0][4];
					var code = formObj.svc_scp_cd.FindIndex(formObj.svc_scp_cd.Code, 0);
					formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);
					
					formObj.cust_cnt_cd.value = arrData[0][5];
					formObj.cust_seq.value = arrData[0][6];
					
					
					formObj.cntr_lod_ut_cd.Code2 = arrData[0][7];
					
					formObj.estm_mqc_qty.value = ComAddComma(arrData[0][8]);
					formObj.estm_cm_amt.value = ComAddComma(arrData[0][9]);
					
					formObj.prc_cust_tp_cd.Code = arrData[0][10];
					
					
					formObj.qttn_srep_cd_hidden.value = arrData[0][11];
				
					formObj.prop_no.value = arrData[0][12];
					
					//formObj.prs_xch_rt_yrmon.value = arrData[0][13];
					
					formObj.qttn_ofc_cd.value = arrData[0][14];
	
					//STATUS
					formObj.qttn_sts_cd.value = arrData[0][15];
					
					formObj.cre_dt.value = arrData[0][17];
					
					formObj.qttn_sts_nm.value = arrData[0][18];
					
					formObj.isCopy.value = arrData[0][19];
					formObj.cust_nm.value = arrData[0][20];
					// GENERAL이나 SPECIAL RATE에 데이터가 존재 하는데 CALCULATE 를 실행 하지 않은 데이터가 있는지 검사한다.
					// need_calc가 'Y'이면  ADD VERSION, COPY TO PROPOSAL을 하지 못한다.(비활성화 시킨다.)
					//checkNeedCalc();

					
					//조회된 ofc_cd로 sales rep combo List을  조회한다.
					setSalesRepCd();
					
					
					//조회된 svc scope 별 권한 을 조회한다. 없을 경우  조회모드로 세팅
					//기존 권한이 A인 경우만 SCOPE별 권한이 있는지 체크
					if(formObj.authCode.value == 'A') {
						formObj.authCode.value = checkAuthSvcScope(arrData[0][4]);
					} 
					//S인 경우는 조회된 SALE REP CODE, OFFICE가 사용자의 SALE REP CODE, OFFICE와 같은지 체크
					else if(formObj.authCode.value == 'S') {
						if(formObj.srep_cd_hidden.value != formObj.qttn_srep_cd_hidden.value || 
								formObj.qttn_ofc_cd_hidden.value != formObj.qttn_ofc_cd.value) {
							formObj.authCode.value = "X";
						} 
					}
					
					enableAllTabPages();
	
				} else {
					
					ComShowCodeMessage('PRI00018');
					formObj.qttn_no.focus();
					
					formObj.gline_cnt.value = "0";
					
					removeAll2(formObj);
					
					clearAllTabPages();
				}
				
				
				if (tabObjects[0].SelectedIndex == 0) {
					tab1_OnChange(tabObjects[0], 0);
				} else {
					tabObjects[0].SelectedIndex = 0;
				}
				
				
				setTabStyle();
				
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}	
			
			if(formObj.authCode.value == 'A' || formObj.authCode.value == 'S') {
				popGLCopy(formObj);
			}
			
			break;
			
	
		case IBSAVE: // Save
			if (!validateForm(sheetObjects[0],document.form,sAction)) {
				return false;
			}
			
			if (!ComPriConfirmSave()) {
				return false;
			}
			
			formObj.estm_mqc_qty.value = ComGetUnMaskedValue(formObj.estm_mqc_qty.value, "int");
		
			try {
				ComOpenWait(true);
			
				formObj.f_cmd.value = MULTI01;
				sXml = sheetObj.GetSaveXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSaveXml(sXml);
				
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}
			
			ComPriSaveCompleted();
			
			var arrData = ComPriXml2Array(sXml, "qttn_no|qttn_ver_no");

			if (arrData != null && arrData.length > 0) {
				formObj.qttn_no.value = arrData[0][0];
				formObj.qttn_no_hidden.value = arrData[0][0];
				
				//version combo setting
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				
				formObj.qttn_ver_no.Code2 = arrData[0][1];
				formObj.qttn_ver_no_hidden.value = arrData[0][1];
				
			}
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			
			break;
			
		case IBSEARCH_ASYNC01: // Delete
			if (!validateForm(sheetObjects[0],document.form,sAction)) {
				return false;
			}
			if (!ComPriConfirmDeleteAll()) {
				return false;
			}
			
			try {
				ComOpenWait(true);
			
				formObj.f_cmd.value = MULTI02;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSaveXml(sXml);
				
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}	
			
			ComPriProcessSuccess("Delete");
			
			removeAll(formObj);
			break;
			
		case IBSEARCH_ASYNC02: // Cancel
			
			if (!validateForm(sheetObjects[0],document.form,sAction)) {
				return;
			}
			if (!ComPriProcessYn("cancel")) {
				return;
			}
			
//			if(!ComShowCodeConfirm("PRI03007","Cancel")) return;
			
			try {
				ComOpenWait(true);
			
				formObj.f_cmd.value = MULTI03;
	
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSaveXml(sXml);
				
				ComOpenWait(false);

			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}	
			
			
			ComPriProcessSuccess("Cancel");
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			break;
						
		case IBSEARCH_ASYNC04: // add version
			if (!validateForm(sheetObjects[0],document.form,sAction)) {
				return false;
			}
			if (!ComPriProcessYn("add version")) {
				return;
			}
			
			try {
				ComOpenWait(true);
			
				//콤보에 max verion 세팅
				addVersion(formObj);
	
				formObj.f_cmd.value = MULTI04;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSaveXml(sXml);
				
			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}	
			
			ComPriProcessSuccess("Add version");
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			break;
			
		}
	}
     
     function checkNeedCalc(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
		var arrData = ComPriXml2Array(sXml, "terms|cnt|note");
 
		if (arrData != null && arrData.length > 0 && arrData[0][1] != "0") {
			 ComShowCodeMessage("PRI03027", arrData[0][2],"Copy to Proposal");
			 return false;
		} 
		return true;
     }
	
	/**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */  
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
		
		case "sheet1":
			with (sheetObj) {
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle = "status";
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				WaitImageVisible = false;
//				Visible = false;
			}
			break;
		}
	}
	
	/**
     * Tab 기본 설정 탭의 항목을 설정한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initTab(tabObj, tabNo);
     * </pre>
     * @param {tabObj} tabObj 필수 IBSheet tabObj
     * @param {int} tabNo 탭 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt = 0;
				InsertTab(cnt++, "Loc. Group ", 0);
				InsertTab(cnt++, "CMDT Group ", 1);
				InsertTab(cnt++, "Rate", 2);
				
				ShowIcon = true;
				UseLargeIcon = false;
				
				ImageUrl(0) = ICON_URL_NOT_EXIST;
				ImageUrl(1) = ICON_URL_NOT_EXIST;
				ImageUrl(2) = ICON_URL_NOT_EXIST;
				
			}
			break;
		}
	}
	
	/**
     * IBSHEET COMBO를 LOAD하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * 		initCombo(comboObj, comboNo)
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "qttn_ver_no":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	UseEdit = false;
	            	ValidChar(2, 1);
	                MaxLength = 2;      // 2자리만 입력
	            }
	            break;
	        
	        case "qttn_srep_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);
	                MaxLength = 5;      // 5자리만 입력
	            	
	            	SetColWidth("46|140|0");
	            }
	            break;
	            
	        case "svc_scp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	                MaxLength = 3;      // 3자리만 입력
	            }
	            break;
	            
	        case "prc_cust_tp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	                MaxLength = 1;      
	            }
	            break;     
	            
	        case "cntr_lod_ut_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
//	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	                MaxLength = 3;   
	            }
	            break;    
	    }
	}
	
	/**
     * comboObjects[0]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getQttnVerNo();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getQttnVerNo() {
		return comboObjects[0].Code;
	}
	
	/**
     * comboObjects[1]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getQttnSrepCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getQttnSrepCd() {
		return comboObjects[1].Code;
	}
	
	/**
     * comboObjects[2]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getSvcScpCd() {
		return comboObjects[2].Code;
	}
	
	/**
     * comboObjects[3]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrcCustTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrcCustTpCd() {
		return comboObjects[3].Code;
	}
	
	/**
     * comboObjects[4]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getCntrLodUtCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getCntrLodUtCd() {
		return comboObjects[4].Code;
	}
	
	
	/**
     * qttn_ver_no combo 변경시 활성화됨<br>
     * qttn_ver_no로 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function qttn_ver_no_OnChange(comboObj, code, text) {
  		
  		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
 	 		if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
 	 			isSelectedVerno = true;
 	 	 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 	 		} else {
 	 			comboObjects[0].Index = "-1";
 	  		}
  		}	
 	}
	
  	/**
     * add version 버튼 클릭시 호출된다.<br>
     * Quotation version no 의 최대값 + 1을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 		addVersion(formObj)
     * </pre>
     * @param {form} formObj    
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
	function addVersion(formObj) {
		
		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
		
		formObj.qttn_no_from.value = formObj.qttn_no_hidden.value;
		formObj.qttn_ver_no_from.value = formObj.qttn_ver_no_hidden.value;
		
		//add version flag
		var max_qttn_ver_no = formObj.max_qttn_ver_no.value;
		
		//combo item insert
		comboObjects[0].InsertItem(-1,max_qttn_ver_no, max_qttn_ver_no);
		comboObjects[0].Code2 = max_qttn_ver_no;
		
	}
	
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (ComIsEmpty(formObj.qttn_no)) {
				ComPriInputValueFailed("input","Quotation No",formObj.qttn_no);
				return false;
			}
			return true;
			break;
			
		case IBCREATE: // New
//			if (ComIsEmpty(formObj.qttn_no)) {
//				ComPriInputValueFailed("input","Quotation No",formObj.qttn_no);
//				return false;
//			}
			return true;
			break;
	
		case IBSAVE: // Save
			
			if ( formObj.qttn_sts_cd.value == "P" || formObj.qttn_sts_cd.value == "C") {
				return false;
			}
			
			if (ComIsEmpty(getQttnSrepCd())) {
				ComPriInputValueFailed("select","Sales Rep",comboObjects[1]);
				return false;
			}
			
			if (formObj.eff_dt.value == "") {
				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
				return false;
			}
			if (formObj.exp_dt.value == "") {
				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
				return false;
			}
			if (formObj.eff_dt.value > formObj.exp_dt.value) {
				ComShowCodeMessage('PRI00305', '[Duration]');
				return false;
			}
			if (ComIsEmpty(getSvcScpCd())) {
				ComPriInputValueFailed("select","Service Scope",comboObjects[2]);
				return false;
			}
			
			//조회된 svc scope 별 권한 을 조회한다. 없을 경우  조회모드로 세팅
			//기존 권한이 A인 경우만 SCOPE별 권한이 있는지 체크
			var auth = checkAuthSvcScope(getSvcScpCd())
			if( auth == 'S'){
				if(formObj.qttn_ofc_cd_hidden.value != formObj.qttn_ofc_cd.value) {
					ComShowCodeMessage("PRI01033", "Request Office");
					return false;
				}

			}else if( auth != 'A') {
				ComShowCodeMessage("PRI01033", "Service Scope");
				return false;
			}
			
//			//기존 권한이 A인 경우만 SCOPE별 권한이 있는지 체크
//			if(formObj.authCode.value == 'A') {
//				if(checkAuthSvcScope(getSvcScpCd()) != "A") {
//					ComShowCodeMessage("PRI01033", "Service Scope");
//					return false;
//				}
//			} 
//			//S인 경우는 조회된 SALE REP CODE, OFFICE가 사용자의 SALE REP CODE, OFFICE와 같은지 체크
//			else if(formObj.authCode.value == 'S') {
//				if(formObj.srep_cd_hidden.value != getQttnSrepCd() || 
//						formObj.qttn_ofc_cd_hidden.value != formObj.qttn_ofc_cd.value) {
//					ComShowCodeMessage("PRI01033", "Request Office or Sales Rep.");
//					return false;
//				}
//			}
			
			
			if (ComIsEmpty(formObj.cust_cnt_cd)) {
				ComPriInputValueFailed("input","Customer",formObj.cust_cnt_cd);
				return false;
			}
			if (ComIsEmpty(formObj.cust_seq)) {
				ComPriInputValueFailed("input","Customer",formObj.cust_seq);
				return false;
			}
			if (ComIsEmpty(getPrcCustTpCd())) {
 				ComPriInputValueFailed("select","Customer Type",comboObjects[3]);
				return false;
			}
//			if (ComIsEmpty(formObj.estm_mqc_qty)) {
// 				ComPriInputValueFailed("Est. MQC을","입력",formObj.estm_mqc_qty);
//				return false;
//			}
			if (ComIsEmpty(getCntrLodUtCd())) {
 				ComPriInputValueFailed("select","Est. MQC",comboObjects[4]);
				return false;
			}
			
			return true;
			break;
			
		case IBSEARCH_ASYNC01: // delete
			
			if (formObj.qttn_sts_cd.value == "N") {
//				ComShowCodeMessage('PRI08015');
				return true;
			} 
			
			return true;
			break;	
			
	
		case IBSEARCH_ASYNC02: // cancel
			if (formObj.qttn_sts_cd.value == "N") {
//				ComShowCodeMessage('PRI08015');
				return true;
			}
			
			return true;
			break;
			
			
		case IBSEARCH_ASYNC03: // gline 카피 클릭 시 하위 데이터가 없는지 체크

			if (formObj.qttn_sts_cd.value == "N") {
//				ComShowCodeMessage('PRI08015');
			
//				setTabStyle();
				
				if (formObj.grp_loc_cnt.value == 0  
					&& formObj.grp_cmdt_cnt.value == 0  
					&& formObj.rate_cnt.value == 0) {
					
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			} 
			
			return true;
			break;
			
			
		case IBSEARCH_ASYNC04: // add version
			if (ComIsEmpty(formObj.qttn_sts_cd)) {
//				ComShowCodeMessage('PRI08015');
				return false;
			}
			
			setTabStyle();
			
			if (getIsEmptyDetail(formObj)) {
				return false;
			} 
			
			if(formObj.rate_cnt.value != 0) {
//				if(!ComIsEmpty(checkExistRate())) {
				if(parseInt(checkExistRate()) > 0) {
					ComShowCodeMessage('PRI03021');
//					if (tabObjects[0].SelectedIndex != 2) {
//						tab1_OnChange(tabObjects[0], 0);
//					} 
					
//					document.getElementById("t3frame").contentWindow.tabEnableSheet(flag);
					
					return false;
				}
			}
			
			return true;
			break;	
			
			
		case IBSEARCH_ASYNC06: // copy to proposal
			
			if (ComIsEmpty(formObj.qttn_sts_cd)) {
//				ComShowCodeMessage('PRI08015');
				return false;
			}
			
			setTabStyle();
			
			if (getIsEmptyDetail(formObj)) {
				return false;
			} 
			
			if(formObj.rate_cnt.value != 0) {
//				if(!ComIsEmpty(checkExistRate())) {
				if(parseInt(checkExistRate()) > 0) {
					ComShowCodeMessage('PRI03021');
//					if (tabObjects[0].SelectedIndex != 2) {
//						tab1_OnChange(tabObjects[0], 0);
//					} 
					
//					document.getElementById("t3frame").contentWindow.tabEnableSheet(flag);
					
					return false;
				}
			}
			
			//check cal

			if(checkNeedCalc() == false ){
				return false;
			}
	
			
			return true;
			break;
			
		}
		
	}
	
	/**
     * 하위 탭  데이터 존재 여부 리턴 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     getIsEmptyDetail(formObj)
     * </pre>
     * @param {form} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function getIsEmptyDetail(formObj) {
		if (formObj.grp_loc_cnt.value == 0  
				&& formObj.grp_cmdt_cnt.value == 0  
				&& formObj.rate_cnt.value == 0) {
			return true;
		} else {
			return false;
		} 
	}
	
	
	
	/**
     * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		tab1_OnChange(tabObj, tabIndex)
     * </pre>
     * @param {tabObj} sheet tabObj  
     * @param {int} tabIndex 
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
	function tab1_OnChange(tabObj, tabIndex) {
		if (beforetab != tabIndex) {
		    var objs = document.all.item("tabLayer");

		    objs[tabIndex].style.display = "inline";
		    objs[beforetab].style.display = "none";
		    
		    //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		}

	    beforetab = tabIndex;
	    loadTabPage(tabIndex);
	}
	
	/**
     * 메인 조회 후 각 탭의 요소를 활성화 시킨다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		loadTabPage(tabIndex)
     * </pre>
     * @param {int} tabIndex 
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
	function loadTabPage(tabIndex) {
		var formObj = document.form;
		var qttn_no 	= formObj.qttn_no.value;
		var qttn_ver_no = getQttnVerNo();
		var svc_scp_cd  = getSvcScpCd();
		var eff_dt  	= formObj.eff_dt.value;
		var exp_dt  	= formObj.exp_dt.value;
//		var gline_cnt  	= formObj.gline_cnt.value;
		var prc_cust_tp_cd = getPrcCustTpCd();
		
		if (tabIndex == null || tabIndex == "") {
			tabIndex = tabObjects[0].SelectedIndex;
		}
		
		var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
		
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			var sUrl = "";
			switch (tabIndex) {
			case 0:
				sUrl = "ESM_PRI_6005_01.do"; 
				break;
			case 1:
				sUrl = "ESM_PRI_6005_02.do"; 
				break;
			case 2:
				sUrl = "ESM_PRI_6005_03.do"; 
				break;
			
			}
			objTabWindow.location.href = sUrl;
			return true;
		}
		
		objTabWindow.tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, prc_cust_tp_cd, isAproUsr);
	
	}
	
	/**
     * 각 탭의 요소를 초기화 시킨다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		clearAllTabPages()
     * </pre>
     * @param {int} tabIndex 
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
	function clearAllTabPages() {
		for (var i = 0; i < tabObjects[0].GetCount(); i++) {
			tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
			}
		}
	}
	
	/**
     * 메인 조회 후 모든 탭을 활성화 시킨다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		enableAllTabPages(flag)
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */
	function enableAllTabPages(flag) {
		if (flag == null || flag == "") {

			if (isAproUsr) {
				flag = true;
			} else {
				flag = false;
			}
		}
		
		for (var i = 0; i < tabObjects[0].GetCount(); i++) {
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
			}
		}
	}
	
	
	/**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function toggleButtons(mode) {
 
		var formObj = document.form;
		var auth = formObj.authCode.value;

		switch (mode) {

		case "":		//초기화
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			if(auth == "S" || auth == "A")
				ComBtnEnable("btn_Save");
			else
				ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Cancel");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Version");
			ComBtnDisable("btn_Proposal");			
			break;
			
		case "N":		//CREATED
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			
			if(auth == "S" || auth == "A") {
				ComBtnEnable("btn_Save");
				ComBtnEnable("btn_Delete");
				ComBtnEnable("btn_Cancel");
				if (validateForm(sheetObjects[0],formObj,IBSEARCH_ASYNC03)) {
					ComBtnEnable("btn_Copy");
				} else {
					ComBtnDisable("btn_Copy");
				}
				ComBtnEnable("btn_Version");
				if (getIsEmptyDetail(formObj)  ) // calculate 수행후 가능
					ComBtnDisable("btn_Proposal");
				else 
					ComBtnEnable("btn_Proposal");
			} else {
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Cancel");
				ComBtnDisable("btn_Copy");
				ComBtnDisable("btn_Version");
				ComBtnDisable("btn_Proposal");
			}
			break;
			
		case "C":		//CANCELED
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Cancel");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Version");
			ComBtnDisable("btn_Proposal");
			break;	
			
		case "P":		//PROPOSED
			ComBtnEnable("btn_Retrieve");
			ComBtnEnable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Cancel");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Version");
			ComBtnDisable("btn_Proposal");
			break;
	
		}
	
	}

	

	/**
     * 하위 탭에 데이터 유무에 따라 탭 스타일을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setTabStyle()
     * </pre>
     * @param 없음  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function setTabStyle() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
		// GENERAL이나 SPECIAL RATE에 데이터가 존재 하는데 CALCULATE 를 실행 하지 않은 데이터가 있는지 검사한다.
		// need_calc가 'Y'이면  ADD VERSION, COPY TO PROPOSAL을 하지 못한다.(비활성화 시킨다.)
		//checkNeedCalc();		
		toggleButtons(document.form.qttn_sts_cd.value);
	}
	
	/**
     * 팝업 화면에서 메인화면을 다시 조회하기 위한 함수.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchMain(qttn_no)
     * </pre>
     * @param {String} qttn_no  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function searchMain(qttn_no) {
		
		removeAll(document.form);

		document.form.qttn_no.value = qttn_no;
		
		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	 /**
	   * PRS CM Data를 조회한다.<br>
	   * <br><b>Example :</b>
	   * <pre>
	   *  getPRSCMData();
	   * </pre>
	   * @return 없음
	   * @author 이승준
	   * @version 2009.05.07
	   */      
	   function getPRSCMData(){
	       var formObj = document.form;
	       var sheetObj = sheetObjects[0];
	       
	       formObj.f_cmd.value = SEARCH01;

	       var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", FormQueryString(formObj));
		   var arrData = ComPriXml2Array(sXml, "estm_mqc_qty|estm_cm_amt");
	       
		   if (arrData !=null && arrData.length > 0){
//		        formObj.estm_mqc_qty.value = ComAddComma(arrData[0][0]);
		        formObj.estm_cm_amt.value = ComAddComma(arrData[0][1]);

		   }
	   }
	
	/**
     * copy to proposal 에서 카피 후 proposal 화면으로 링크한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchMainProposal(prop_no)
     * </pre>
     * @param {String} prop_no     신규 생성된 proposal no
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function searchMainProposal(prop_no) {
		
		if(!ComIsEmpty(prop_no)) {
			window.location.href = "/hanjin/ESM_PRI_0003.do?pgmNo=ESM_PRI_0003&cond_prop_no="+prop_no;
		}
	}
	
	/**
     * customer 공통 팝업을 호출한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     popupCustomer()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupCustomer() {
 	
 		var formObj = document.form;
 		
 		var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 460, true);
 		
        if (rtnVal != null){
            formObj.cust_cnt_cd.value = rtnVal.custCntCd;
            formObj.cust_seq.value = rtnVal.custCd.substr(2,6);
            formObj.cust_nm.value = rtnVal.custNm;
            setCustomerName(formObj);
        }
    }
 	
 	/**
     * save end 시 하위 데이터가 없을 경우 gl copy popup 호출한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     popGLCopy(formObj)
     * </pre>
     * @param {form} formObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popGLCopy(formObj) {
 		if (validateForm(sheetObjects[0],formObj,IBSEARCH_ASYNC03)) {
			var sUrl = "/hanjin/ESM_PRI_6008.do?" + FormQueryString(formObj);
//			alert(sUrl)
			ComPriOpenWindowCenter(sUrl, "ESM_PRI_6008", 500, 258, true);
		}

 	}
 	
 	/**
     * ComOpenWait 함수를 호출한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     callComOpenWait(flag)
     * </pre>
     * @param {String} flag true,false
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function callComOpenWait(flag) {
 		ComOpenWait(flag);
 	}
	

	/* 개발자 작업  끝 */