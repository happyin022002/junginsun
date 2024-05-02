/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6015.js
*@FileTitle : RFA Quotation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
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
     * @class ESM_PRI_6015 : ESM_PRI_6015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESM_PRI_6015() {
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

var tabDivCount = 5;

var selectedGlineSeq = null;

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
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				break;
	
			case "btn_New":
				removeAll(document.form);
				clearAllTabPages();
				break;
		
            case "btn_Quotation":
				if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC01)) {
					var sUrl = "/hanjin/ESM_PRI_6044.do?";
					sUrl += "&qttn_no=" + formObject.qttn_no_read.value;
					sUrl += "&qttn_ver_no=" + formObject.qttn_ver_no_read.value; 
					sUrl += "&prc_cust_tp_cd=" + formObject.prc_cust_tp_cd_read.value; 
					sUrl += "&eff_dt=" + formObject.eff_dt_read.value;
					sUrl += "&exp_dt=" + formObject.exp_dt_read.value;
					sUrl += "&svc_scp_cd=" + formObject.svc_scp_cd_read.value;
					sUrl += "&svc_scp_nm=" + formObject.svc_scp_nm_read.value;
					sUrl += "&cre_dt=" + formObject.cre_dt_read.value;
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6044", 606, 234, true);
				}
				break;   
				
            case "btns_calendar": //달력버튼
                var cal = new ComCalendarFromTo();
                cal.select(formObject.cre_dt_from, formObject.cre_dt_to, 'yyyy-MM-dd');
                break;	
                
            case "btn_OpenQuotation": //Quotation main link
            	searchMainCreation(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "qttn_no"),sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "qttn_ver_no"));
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
	for(i=0;i<sheetObjects.length;i++){
    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
    	//khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);

    }
	for (var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
    //IBMultiCombo초기화
    for(var k = 0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
	
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
//		var iWidth = window.document.body.clientWidth;
	sheetColResize();
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
	sheetObjects[1].WaitImageVisible = false; 
	doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
	document.form.qttn_srep_cd.RemoveAll();
	document.form.qttn_srep_cd.Enable = false;
	toggleButtons("");
	document.form.qttn_no.focus();
   	sheetObjects[1].WaitImageVisible = true; 
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
			formObj.cust_nm.value = arrDesc[0][1];
		} else {
			ComShowCodeMessage("PRI03004","Customer");
			formObj.cust_seq.value = "";
			formObj.cust_nm.value = "";
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
          
        case "cre_dt_from":
            ComChkObjValid(event.srcElement);   
            break;
        case "cre_dt_to":
            ComChkObjValid(event.srcElement);   
            break;
        case "qttn_ofc_cd":
        	searchSrepCd();
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
	
	formObj.reset();
	
	comboObjects[0].removeAll();
	comboObjects[1].removeAll();
	comboObjects[2].Index = "-1";
	comboObjects[3].Index = "-1";
	comboObjects[4].Index = "-1";
	
	sheetObjects[1].removeAll();
	
	toggleButtons("");
	
	clearAllTabPages();
	
	document.form.qttn_no.focus();
}

/**
 * 화면을 부분 리셋한다.<br>
 * Quotation no를 제외하고 초기화한다.<br>
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
	 		
	formObj.reset();
	
	formObj.qttn_no.value = qttn_no;
	
	comboObjects[0].removeAll();
	comboObjects[1].removeAll();
	comboObjects[2].Index = "-1";
	comboObjects[3].Index = "-1";
	comboObjects[4].Index = "-1";
	
	sheetObjects[1].removeAll();
	
	toggleButtons("");
	
	clearAllTabPages();
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
		}else{
			formObj.qttn_srep_nm.value = "";
		}
		
	}	
}

/**
 * srep combo 초기화시 동작함<br>
 * <br><b>Example :</b>
 * <pre>
 * 		
 * </pre>
 * @param {comboObj} comboObj 
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
 * 		svc_scp_cd_OnChange(comboObj, code, text);
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
		}else{
			formObj.svc_scp_nm.value = "";
		}
		
	}else{
		formObj.svc_scp_nm.value = "";
	}
}

/**
 * service scope combo 초기화시 동작함<br>
 * <br><b>Example :</b>
 * <pre>
 * 		svc_scp_cd_OnClear(comboObj);
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
 * 		svc_scp_cd_OnBlur(comboObj)
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
	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6014GS.do", FormQueryString(formObj) + "&eff_dt=" + formObj.eff_dt_read.value);
		var arrTabCnt = ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|rate_g_cnt|rate_ihc_cnt");
		if (arrTabCnt != null && arrTabCnt.length > 0) {
			for (var i = 0; i < arrTabCnt[0].length; i++) {
				if(i < 4) {
					if (parseInt(arrTabCnt[0][i]) > 0) {
						tabObjects[0].ImageUrl(i) = ICON_URL_EXIST;
					} else {
						tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
					}
				}
				if(i==0) formObj.grp_loc_cnt.value = arrTabCnt[0][i];
				if(i==1) formObj.grp_cmdt_cnt.value = arrTabCnt[0][i];
				if(i==2) formObj.rate_cnt.value = arrTabCnt[0][i];
				if(i==3) formObj.rate_ihc_cnt.value = arrTabCnt[0][i];					
			}
		}
		break;
	
	case IBCLEAR: 
        // 화면 로딩시 Service Scope 조회
		formObj.f_cmd.value = SEARCH01;
		formObj.etc5.value="PRS";
		sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
		formObj.svc_scp_cd.InsertItem(0,'','');
		
	
		// 화면 로딩시customer type 조회
		formObj.f_cmd.value = SEARCH20;
		formObj.cd.value="CD02085";
		
		sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.prc_cust_tp_cd, "cd", "nm");
		//formObj.prc_cust_tp_cd.InsertItem(0,'','|');
		
		//code가 BOTH 인 경우  삭제 후   Text를 ""로 세팅
		var itemindex = formObj.prc_cust_tp_cd.FindIndex("ALL",0);
		
		if(itemindex != "-1") {
			formObj.prc_cust_tp_cd.DeleteItem(itemindex); 
			formObj.prc_cust_tp_cd.InsertItem(0,'','M');
		}
		
		
		// 화면 로딩시 status 조회
	    formObj.f_cmd.value = SEARCH19;
        formObj.cd.value="CD02195";
        sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.qttn_status, "cd", "nm");
        formObj.qttn_status.InsertItem(0,'','');
    
		break;
		
	case IBSEARCH_ASYNC01: // office 입력 후  srep combo LIST
		formObj.qttn_srep_cd.RemoveAll();
		formObj.f_cmd.value = SEARCH15;  
		formObj.etc1.value = formObj.qttn_ofc_cd.value;
		sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",FormQueryString(formObj));
        ComPriXml2ComboItem(sXml, formObj.qttn_srep_cd, "cd", "cd|nm");
        formObj.qttn_srep_cd.InsertItem(0,'','');
		break;
		
		
	case IBCREATE: // QUOTATION NO 입력 후  qttn_ver_no COMBO LIST
		if (!validateForm(sheetObjects[0],document.form,sAction)) return;
		formObj.qttn_ver_no.RemoveAll();
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("ESM_PRI_6014GS.do", sParam);
		var arrData = ComPriXml2Array(sXml, "qttn_ver_no");
		if (arrData != null && arrData.length > 0) {
			ComPriXml2ComboItem(sXml, formObj.qttn_ver_no, "qttn_ver_no", "qttn_ver_no", false);
			formObj.qttn_ver_no.InsertItem(0,'','');
		}
		break;	
	
	case IBSEARCH: // 조회
		if (validateForm(sheetObj,document.form,sAction)) {
			try {
				for (var i = 0; i < sheetObjects.length; i++) {
                	sheetObjects[i].WaitImageVisible = false;
                }
				ComOpenWait(true);
				for (var i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				
				var ele = formObj.elements;
                var re = new RegExp();
                var ename = null;
                re.compile("._read$");
                for (var i = 0, n = ele.length; i < n; i++) {
                    ename = ele.item(i).getAttribute("name")
                    if (re.test(ename)) {
                    	formObj[ename].value = "";
                    }
                }
                if(!ComIsEmpty(formObj.cre_dt_from.value) && setDash(formObj.cre_dt_from.value) != 'undefined')
     				formObj.cre_dt_from.value = setDash(formObj.cre_dt_from.value);
     			if(!ComIsEmpty(formObj.cre_dt_to.value) && setDash(formObj.cre_dt_to.value) != 'undefined')
     				formObj.cre_dt_to.value = setDash(formObj.cre_dt_to.value);
                
                
				formObj.f_cmd.value = SEARCH01;
				formObj.qttn_no.value = formObj.qttn_no.value.toUpperCase();
				sheetObj.DoSearch("ESM_PRI_6015GS.do" , FormQueryString(formObj));
				ComOpenWait(false);
				setTabText();
				searchSrepCd("1")
				
			} catch (e) {
			    if (e == "[object Error]") {
			        ComShowMessage(OBJECT_ERROR);
			    } else {
			        ComShowMessage(e);
			    }
			} finally {
			   ComOpenWait(false);
			}
			
		} 
		
		break;
		
	
	}
}


/**
 * 날짜에 -를 세팅한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *      setDash(date)
 * </pre>
 * @param {string} 날짜 input box의 value
 * @return string
 * @author 이승준
 * @version 2009.05.18
 */
function setDash(value) {
	
   if(ComIsEmpty(value) || value.length == 0) return;
   
   var date = ComTrimAll(value).replace(/-/g, ""); 
 
   var str = "";
   for(var i=0; i<date.length; i++) {
	   if(i == 4 || i == 6) {
		  str += "-" + date.substring(i,i+1);
	   } 
	   else {
		  str += date.substring(i,i+1);
	   }
   }
   
   return str;

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
	
	case "sheet0":
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
			Visible = false;
		}
		break;
		
	case "sheet1":  // Grid 1
        with (sheetObj) {
        	// 높이 설정
			style.height = 147;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Seq.|Quotation No.|Ver. No.|Proposal No.|Copied|Customer Name" +
					"|Req. Office|Sales Rep.|Est.Target MVC|Est.CM|Creation Date|Status" +
					"|cust_cnt_cd|cust_seq|eff_dt|exp_dt|svc_scp_cd|svc_scp_nm|qttn_srep_cd|prc_cust_tp_cd|cntr_lod_ut_cd|qttn_sts_cd";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
            InitDataProperty(0, cnt++, dtDataSeq, 40,daCenter, true, "seq");
            InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "qttn_no", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  60, daCenter, false, "qttn_ver_no", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "prop_no", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  56,  daCenter, false, "iscopy", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  170, daLeft, false, "cust_nm",  	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  70,  daCenter, false, "qttn_ofc_cd", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  70,  daLeft, false, "qttn_srep_nm", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  95,  daRight, false, "estm_mqc_qty", false, "", dfNullInteger, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  85,  daRight, false, "estm_cm_amt", 	false, "", dfNullInteger, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  85,  daCenter, false, "cre_dt", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtData,  60,  daCenter, false, "qttn_sts_nm", 	false, "", dfNone, 0, true, true);
            
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "cust_cnt_cd", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "cust_seq", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "eff_dt", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "exp_dt", 		false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "svc_scp_cd", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "svc_scp_nm", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_srep_cd", 	false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "prc_cust_tp_cd", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "cntr_lod_ut_cd", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  90,  daLeft, false, "qttn_sts_cd", 	false, "", dfNone, 0, true, true);
            
            Ellipsis = true;
            WaitImageVisible = false;
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
            	MaxSelect = 1;
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
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	ValidChar(2, 1);
                MaxLength = 5;      // 5자리만 입력
            	
            	SetColWidth("80|100|0");
            }
            break;
            
        case "svc_scp_cd":
            with(comboObj) {
            	DropHeight = 260;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	ValidChar(2, 0);
                MaxLength = 3;      // 3자리만 입력
            }
            break;
            
        case "prc_cust_tp_cd":
            with(comboObj) {
            	DropHeight = 260;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
            	ValidChar(2, 0);
            }
            break; 
      
        case "qttn_status":
            var i=0;
            with(comboObj) {
            	DropHeight = 260;
            	MultiSelect = false;
            	MaxSelect = 1;
            	UseAutoComplete = true;
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
 * 		var code = getStatus();
 * </pre>
 * @return String <br>
 * @author 이승준
 * @version 2009.06.10
 */ 
function getStatus() {
	return comboObjects[4].Code;
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
		return true;
		break;
		
	case IBCREATE: // New
		if (ComIsEmpty(formObj.qttn_no)) {
			ComPriInputValueFailed("input","Quotation No",formObj.qttn_no);
			return false;
		}
		return true;
		break;
			
	case IBSEARCH_ASYNC01: // gline 카피 클릭 시 하위 데이터가 없는지 체크

		if (ComIsEmpty(formObj.qttn_sts_nm_read)) {
			return false;
		}
		if (formObj.grp_loc_cnt.value == 0  
			&& formObj.grp_cmdt_cnt.value == 0  
			&& formObj.rate_cnt.value == 0) {
			return false;
		} else {
			return true;
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
		var toIndex = getFrameTabId(tabIndex);
		for ( var i = 1; i <= tabDivCount; i++) {
			document.getElementById("tabLayer" + i).style.display = 'none';
		}
		document.getElementById(toIndex.divIndex).style.display = 'inline';
	}
	beforetab = tabIndex;
	loadTabPage(tabIndex);
}
	
/**
 * 2012.09.20일 추가 Tab에 따른 Tab Lay 밑 URL 설정
 * 
 * @param tabIndex
 */
function getFrameTabId(tabIndex) {
	var frameId = "";
	var sUrl = "";
	var divIndex = "";
	switch (tabIndex) {
    	case 0: {
    		frameId = "t1frame";
    		sUrl = "ESM_PRI_6015_01.do";
    		divIndex = "tabLayer1";
    		break;
    	}
    	case 1: {
    		frameId = "t2frame";
    		sUrl = "ESM_PRI_6015_02.do";
    		divIndex = "tabLayer2";
    		break;
    	}
    	case 2: {
    		var index = checkArbiRate();
    		if (index == 0) {
    			frameId = "t3frame";
    			sUrl = "ESM_PRI_6015_03.do";
    			divIndex = "tabLayer3";
    		} else if (index == 1) {
    			frameId = "t4frame";
    			sUrl = "ESM_PRI_6015_04.do";
    			divIndex = "tabLayer4";
    		} else if (index == 2) {
    			frameId = "t5frame";
    			sUrl = "ESM_PRI_6015_05.do";
    			divIndex = "tabLayer5";
    		}
    		break;
    	}
	}
	var obj = new Object({
		'frame' : frameId,
		'url' : sUrl,
		'divIndex' : divIndex
	});
	return obj;
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
	var qttn_no 	= formObj.qttn_no_read.value;
	var qttn_ver_no = formObj.qttn_ver_no_read.value;
	var svc_scp_cd  = formObj.svc_scp_cd_read.value;
	var eff_dt  	= formObj.eff_dt_read.value;
	var exp_dt  	= formObj.exp_dt_read.value;
	var prc_cust_tp_cd = formObj.prc_cust_tp_cd_read.value;
	
	if (tabIndex == null || tabIndex == "") {
		tabIndex = tabObjects[0].SelectedIndex;
	}
	
	var obj = getFrameTabId(tabIndex);
	var objTabWindow = document.getElementById(obj.frame).contentWindow;
	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
		objTabWindow.location.href = obj.url;
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
	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
	}

	for ( var i = 1; i <= tabDivCount; i++) {
		if (document.getElementById("t" + i + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + i + "frame").contentWindow.tabClearSheet();
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
	for ( var i = 0; i < tabDivCount; i++) {
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
	
	switch (mode) {
	case "":		//초기화
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnDisable("btn_Quotation");
		ComBtnDisable("btn_OpenQuotation");
		break;
	case "INIT":		//CREATED
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		if (validateForm(sheetObjects[0],formObj,IBSEARCH_ASYNC01)) {
			ComBtnEnable("btn_Quotation");
			ComBtnEnable("btn_OpenQuotation");
		} else {
			ComBtnDisable("btn_Quotation");
			ComBtnDisable("btn_OpenQuotation");
		}
		if (sheetObjects[1].RowCount > 0) {
			ComBtnEnable("btn_OpenQuotation");
		} else {
			ComBtnDisable("btn_OpenQuotation");
		}
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
	toggleButtons("INIT");
}

/**
 * 메인 화면에서 조회시 첫번째 텝으로 이동시킨다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     reloadTab()
 * </pre>
 * @param 없음  
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function reloadTab() {
	if (tabObjects[0].SelectedIndex == 0) {
		tab1_OnChange(tabObjects[0], 0);
	} else {
		tabObjects[0].SelectedIndex = 0;
	}
}

/**
 * Hinterland 관련<BR>
 * Scope에 따라 적절한 Arbitrary, Rate Tab을 활성화한다.<BR>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * getTabIndex(tabInfo, tabName)
 * </pre>
 * 
 * @param {String} tabInfo Tab Information
 * @param {String} tabName Tab header name want to find.
 * @return Number tab index.
 * @author Hyuk Ryu
 * @version 2012.05.08
 */
function getTabIndex(tabInfo, tabName) {
	var index = -1;
	var tabs = tabInfo.split("|");
	for ( var i = 0; i < tabs.length; i++) {
		if (tabName == tabs[i].split(",")[1]) {
			index = i;
			break;
		}
	}
	return index;
}	

/**
 * Hinterland 관련<BR>
 * 지정한 탭의 enable/disable을 설정한다.<BR>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setTabEnable(tabObj, enable)
 * </pre>
 * 
 * @param {Number} tabIdx Target Tab Index
 * @param {boolean} enable Flag for enable/disable.
 * @return Number tab index.
 * @author Hyuk Ryu
 * @version 2012.05.08
 */
function setTabEnable(tabIdx, enable) {
	if (tabObjects[0].TabEnable(tabIdx) != enable) {
		tabObjects[0].TabEnable(tabIdx) = enable;
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
        formObj.cust_seq.value = rtnVal.custSeq;
        formObj.cust_nm.value = rtnVal.custNm;
    }
}


/**
 * qttn no OnKeyPress 시 호출된다.<br>
 * qttn no에 따른 ver no list를 조회한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     searchQttnVerNo()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function searchQttnVerNo() {
	if(ComIsEmpty(document.form.qttn_no)) return;
	var length = document.form.qttn_no.value.length;
	if(length == 10) {
		 document.form.qttn_no.value =  document.form.qttn_no.value.toUpperCase();
 		if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
 			doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
 		}	
	}
}


/**
 * Office OnBlur 시 호출된다.<br>
 * qttn_ofc_cd 따른 qttn_srep_cd 콤보를 조회한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     searchSrepCd()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function searchSrepCd(type) {
	 if(type == undefined ){
		 type="2";
	 }
	if(ComIsEmpty(document.form.qttn_ofc_cd)) {
		document.form.qttn_srep_cd.Enable = false;
	} else {
		document.form.qttn_srep_cd.Enable = true;
	}    	 
	if( type != "1"){
 		if(ComIsEmpty(document.form.qttn_ofc_cd)) {
			document.form.qttn_srep_cd.RemoveAll();
 		} else {
 			document.form.qttn_ofc_cd.value =  document.form.qttn_ofc_cd.value.toUpperCase();
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 		}
	}
}

/**
 * sheet에서 cell을 클릭한 경우 발생. <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} OldRow 
 * @param {int} OldCol 
 * @param {int} NewRow 
 * @param {int} NewCol 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
 	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(OldRow, NewRow, OldCol, NewCol);
    }
 
 	/**
 * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
 * 선택한 로우에 대한 디테일 정보를 조회한다.<br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} OldRow 
 * @param {int} OldCol 
 * @param {int} NewRow 
 * @param {int} NewCol 
 * @param {String} sAction
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
	function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
         var formObj = document.form;
   
         formObj.qttn_no_read.value = sheetObjects[1].CellValue(NewRow, "qttn_no");
     formObj.qttn_ver_no_read.value = sheetObjects[1].CellValue(NewRow, "qttn_ver_no");
     formObj.qttn_ofc_cd_read.value = sheetObjects[1].CellValue(NewRow, "qttn_ofc_cd");
	 formObj.qttn_srep_cd_read.value = sheetObjects[1].CellValue(NewRow, "qttn_srep_cd");
     
	 formObj.qttn_srep_nm_read.value = sheetObjects[1].CellValue(NewRow, "qttn_srep_nm");
     formObj.eff_dt_read.value = sheetObjects[1].CellValue(NewRow, "eff_dt");
     formObj.exp_dt_read.value = sheetObjects[1].CellValue(NewRow, "exp_dt");
	 formObj.qttn_sts_nm_read.value = sheetObjects[1].CellValue(NewRow, "qttn_sts_nm");
	 
	 formObj.prop_no_read.value = sheetObjects[1].CellValue(NewRow, "prop_no");
     formObj.iscopy_read.value = sheetObjects[1].CellValue(NewRow, "iscopy");
     formObj.svc_scp_cd_read.value = sheetObjects[1].CellValue(NewRow, "svc_scp_cd");
     formObj.svc_scp_nm_read.value = sheetObjects[1].CellValue(NewRow, "svc_scp_nm");
	 formObj.cre_dt_read.value = sheetObjects[1].CellValue(NewRow, "cre_dt");
	 
	 formObj.cust_cnt_cd_read.value = sheetObjects[1].CellValue(NewRow, "cust_cnt_cd");
     formObj.cust_seq_read.value = sheetObjects[1].CellValue(NewRow, "cust_seq");
     formObj.cust_nm_read.value = sheetObjects[1].CellValue(NewRow, "cust_nm");
	 formObj.prc_cust_tp_cd_read.value = sheetObjects[1].CellValue(NewRow, "prc_cust_tp_cd");
	 
	 formObj.estm_mqc_qty_read.value = ComAddComma(sheetObjects[1].CellValue(NewRow, "estm_mqc_qty"));
     formObj.cntr_lod_ut_cd_read.value = sheetObjects[1].CellValue(NewRow, "cntr_lod_ut_cd");
     formObj.estm_cm_amt_read.value = ComAddComma(sheetObjects[1].CellValue(NewRow, "estm_cm_amt"));
	
     clearAllTabPages();
		
	 setTabStyle();
     reloadTab();
    
	 toggleButtons("INIT");
}


/**
 * copy to quotation 시 호출된다.<br>
 * quotation creation main 으로 이동한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *     searchSrepCd()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function searchMainCreation(qttn_no,qttn_ver_no) {
	if(!ComIsEmpty(qttn_no)) {
		window.location.href = "/hanjin/ESM_PRI_6014.do?pgmNo=ESM_PRI_6014&qttn_no="+qttn_no+"&qttn_ver_no="+qttn_ver_no;
	}
}


/**
 * window가 resize 시 sheet col width를 재조정한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *    onResize="cellWidthResize();"
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function sheetColResize() {
	var sheetObj1 = sheetObjects[1];
	sheetObj1.FitColWidth("0|4|8.5|5|8|5|14.5|7|11.5|9.5|8|9|4|0|0|0|0|0|0|0|0|0|0");

}
 	
/**
 * Tab Text변경
 */
function setTabText() {
	var index = checkArbiRate();
	if (index == 0 || index == 2) {
		tabObjects[0].TabText(2) = "Rate";
	} else if (index == 1) {
		tabObjects[0].TabText(2) = "Rate For AEE/AEW";
	} 
}

 /**
 * Hinterland Project에 따른 Arbitrary/Rate 구분
 */
function checkArbiRate() {
	var formObj = document.form;
	var rsltIndex = 0;
	var svcScpCd = formObj.svc_scp_cd_read.value;
	var expDt = ComGetUnMaskedValue(formObj.eff_dt_read.value, "ymd");
	if (ComCheckGuideExcepSvcScpCd(svcScpCd)) {
		rsltIndex = 0;
	} else {
		if (addOnEndExpDt > expDt && expDt > endExpDt && ("AEW" == svcScpCd || "AEE" == svcScpCd)) {
			rsltIndex = 1;
		} else if (addOnEndExpDt <= expDt) {
			rsltIndex = 2;
		} else {
			rsltIndex = 0;
		}
	}
	return rsltIndex;
}