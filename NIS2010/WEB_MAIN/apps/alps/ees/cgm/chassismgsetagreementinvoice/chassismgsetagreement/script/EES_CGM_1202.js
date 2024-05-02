/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1202.js
 *@FileTitle : Agreement Creation and Inquiry
 *Open Issues :
 *Change history : 
 *@LastModifyDate : 2013.03.08
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.08 이영헌
 * 1.0 Creation
 *--------------------------------------------------
 * History
 * 2014-07-18 stStopYdFlg 추가 (Start/Stop Flag), 신용찬
 * 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차 
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
 * @class ees_cgm_1201 : ees_cgm_1201 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1201() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt     = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tabLoad = new Array();
tabLoad[0]= 0;
tabLoad[1]= 0;

//각 Pool Code에 대한 vndr_seq 값 저장
var vndrArr = new Array();
//SCC의 유효성 체크
var sccCount = 0;
//Yard Code의 유무
var yardCd = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (S) */ 
if(window.addEventListener) {
	window.addEventListener("message", receiveMessage, false);
}

if(window.attachEvent) {
	window.attachEvent("onmessage", receiveMessage);
}

if(document.attachEvent) {
	document.attachEvent("onmessage", receiveMessage);
}

// return 처리를 위한 함수 (필수)
function receiveMessage(event) {
	// 리턴 처리 방법
	returnGwLink(event.data)
	
}
/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (E) */

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				// IBSHEET 조회
				if(ComCgmIsActionButtonEnable(srcName)){
 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
 						// Search 실행
 						var result = doActionIBSheet(sheetObject1, formObject, IBSEARCH);

 						if(result){
	 						// Form Control 활성/비활성 처리
//	 						doControlEnable("btn_retrieve");
	 						doControlEnable("btn_new");
	 						
	 						// 버튼 활성/비활성 처리 
		    		    	doActionBtnEnable('R');
 						}
 					}
				}
				break;
	
			case "btn_new":
				if(ComCgmIsActionButtonEnable(srcName)){
 					// Form Control 초기화
					initControl();
 					
					formObject.agmt_ref_no.focus();
					
 					// Form Control Enable 설정
 					doControlEnable("btn_new");

 					// 버튼 활성/비활성 처리
 					formObject.agmt_no.value = "NEW";
    		    	doActionBtnEnable('N');
				}
				break;
				
			case "btn_delete":
				if(ComCgmIsActionButtonEnable(srcName)){
					if(validateForm(sheetObject2,formObject,IBDELETE) != false) {
						if(ComShowCodeConfirm('CGM00005','the Agreement')){
	 					// 삭제 실행
	 					doActionIBSheet(sheetObject2,formObject,IBDELETE);
						}
					}
				}
				break;
				
			case "btn_save":
				if(ComCgmIsActionButtonEnable(srcName)){
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
						if(ComShowCodeConfirm('CGM10047')){
	 						// 저장 실행
	 						doActionIBSheet(sheetObject1,formObject,IBSAVE);
	 					}
					}
				}
				break;
				
			case "btn_versionUp":
				if(ComCgmIsActionButtonEnable(srcName)){
					// Version Up
					doVersionUp();
					
					// Form Control Enable 설정
					doControlEnable("btn_versionUp");
						
					// 버튼 활성/비활성 처리
					doActionBtnEnable('V');
				}
				break;
				
			case "btn_t1RowAdd":
				if(sheetObject1.Enable){
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
				}
				break;
	
			case "btn_t1Delete":
				if(sheetObject1.Enable){
					doActionIBSheet(sheetObject1,formObject,IBRESET);
				}
				break;
				
			case "btn_t2RowAdd":
				if(sheetObject2.Enable){
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
				}
				break;
				
			case "btn_t2Delete":
				if(sheetObject2.Enable){
					doActionIBSheet(sheetObject2,formObject,IBRESET);
				}
				break;
					
			case "btns_Calendar_effDt":
				var cal = new ComCalendarFromTo();
	            cal.select(formObject.agmt_eff_dt,  formObject.agmt_exp_dt,  'yyyy-MM-dd');
				break;
				
			case "btns_agmtno":	// Agreement No 가져오기 팝업
				if(!formObject.agmt_no.readOnly){
					ComOpenPopupWithTarget('/hanjin/EES_CGM_1117.do', 800, 420, "agmt_no:agmt_no", "1,0,1,1,1,1,1,1,1", true);
				}
				break;
				
			case "btns_gwUqDoc":	// 2014-09-24 Chang Young Kim, G/W 링크 호출
				
				var csrGwUrl = formObject.csr_gw_url.value;
				
				// for Local Server Test
				if(csrGwUrl != "null") {
					
					//해당 메인에 포함되는 iframe 동적 생성 (GW 호출하기 위한 IFrame)
					ifrm = document.createElement("IFRAME");
					ifrm.setAttribute("id", "gwrequest");
					ifrm.style.width = 0+"px";
					ifrm.style.height = 0+"px";
					
					// for Local Server Test
					if(!ComIsEmpty(formObject.gw_uq_doc_no.value)) { // 계약문서 번호가 있을 때
						
						var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+formObject.gw_uq_doc_no.value);
						ifrm.setAttribute("src", url);
						document.body.appendChild(ifrm);
						
					} else {
						
						 var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|CHS");
						 ifrm.setAttribute("src", url);
						 document.body.appendChild(ifrm);
						
					}
					
				} else {
					// setting
					formObject.gw_uq_doc_no.value	= "123465";
					formObject.gw_uq_doc_tit_nm.value	= "CHS_DOCU_123456.xlsx";
					
					// button setting
					//doActionBtnEnable('G');
				}
				
				break;
				
			case "btn_gwDelete":	// 2014-09-24 Chang Young Kim, GW_UQ_DOC_NO, GW_UQ_DOC_TIT_NM 개별 삭제 [Update]
				
				if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
					if(!ComIsEmpty(formObject.gw_uq_doc_no.value)) {
						// setting
						formObject.gw_uq_doc_no.value	= "";
						formObject.gw_uq_doc_tit_nm.value	= "";
						
						// 저장 실행
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					} else {
						// msgs['COM130302'] = 'You can\'t delete {?msg1}.';
						ComShowCodeMessage('COM130302','a empty data');
					}
				}
				break;
				
		} // end switch
	}catch(e) {
 		if( e == "[object Error]") {
     		ComShowMessage(OBJECT_ERROR);
 		} else {
     		ComShowMessage(e);
 		}
 	}
}

//GW에서 리턴된 값 화면 적용
function returnGwLink(msg) {
	
	msg = msg.split(",");
	
	var formObj = document.form;
	
	// setting
	ComSetObjValue(formObj.gw_uq_doc_no, msg[0]);
	ComSetObjValue(formObj.gw_uq_doc_tit_nm, msg[1]);

	// button setting
	//doActionBtnEnable('G');
}

/**
* Control 의 Action 별 Enable 제어 기능을 수행한다. <br>
* @param  없음
* @return 없음
* @author 
* @version 2013.03.21
*/     
function doControlEnable(srcName){
	
	var formObj = document.form;
	
	switch(srcName){
		case "btn_retrieve":
			setFormControlEnable(formObj, false);			
	 		break;
	 		
	 	case "btn_new":
	 		setFormControlEnable(formObj, true);
	 		break;
	 			
	 	case "btn_versionUp":
	 		setFormControlEnable(formObj, true);
	        ComCgmEnableObject(formObj.agmt_no, false);
	        ComCgmEnableObject(formObj.btns_agmtno, false);
	        ComCgmEnableObject(formObj.agmt_eff_dt, false);
	        ComCgmEnableObject(formObj.cre_dt, false);
	        ComCgmEnableObject(formObj.agmt_eff_dt, true);
	        ComCgmEnableObject(formObj.agmt_exp_dt, false);
	        ComCgmEnableObject(formObj.btns_Calendar_effDt, true);
	         
	        document.chss_pool_cd.Enable = false;
	        
	        ComCgmEnableObject(formObj.agmt_eff_dt, true, 'input1');
	        ComCgmEnableObject(formObj.agmt_exp_dt, true, 'input1');
	        
	        
	 		break;
	 		
	 	default:	// Load
	 		setFormControlEnable(formObj, false);
	 	    ComCgmEnableObject(formObj.agmt_no, true);
            ComCgmEnableObject(formObj.btns_agmtno, true);
	 		break;
	}
	tRoleApply();
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	 var formObj = document.form;
	 
	 axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	 axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
	 axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
	 axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때
	 axon_event.addListener('change', 'obj_change', 'agmt_no'); 
	 axon_event.addListener('change', 'obj_change', 'pay_term_dys');
	 
	 // Tab Object 초기화
	 for(k=0;k<tabObjects.length;k++){
		 initTab(tabObjects[k],k+1);
	 }
	 
	 for (i = 0; i < sheetObjects.length; i++) {
		// 시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// 마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	 }
	 
	 // IBMultiCombo 초기화
	 comboObjects[comboCnt++] = document.agmt_ver_no;
	 comboObjects[comboCnt++] = document.chss_pool_cd;
	 for(var k=0;k<comboObjects.length;k++){
		 initCombo(comboObjects[k]);
	 }
}
 
 /**
  * Sheet 로딩 후 이벤트 <br>
  * body 태그의 onLoadFinish 이벤트핸들러 구현 <br>
  * @param  sheetObj
  * @return 없음
  * @author 
  * @version 2013.03.21
  */ 
 function t1sheet1_OnLoadFinish(sheetObj) { 
 	var formObj = document.form;
 	 
 	sheetObj.WaitImageVisible = false;
 	// 버튼 활성/비활성 처리
  	doActionBtnEnable('L');
  	doActionIBSheet(sheetObjects[1], formObj, IBCLEAR);
  	
    // Form Control Enable 설정
    doControlEnable("LOAD");
      
   	// Form Object 초기화 및  Control Value Reset 처리
   	initControl();
 	
   	tRoleApply();
 	sheetObj.WaitImageVisible = true; 
 }
 
/**
 * Form의 Conrol 를 초기화 시킨다. <br>
 * @param  없음
 * @return 없음
 * @author 
 * @version 2013.03.21
 */
function initControl() {
	var formObj = document.form;
	
	// Form Object 초기화 
    with(formObj){
    	ComCgmSetObjectValue(agmt_ofc_cty_cd);
    	ComCgmSetObjectValue(agmt_seq);
    	ComCgmSetObjectValue(agmt_no);
    	ComCgmSetObjectValue(agmt_ver_no);
    	ComCgmSetObjectValue(lst_ver_flg);
    	ComCgmSetObjectValue(gw_uq_doc_tit_nm);
		ComCgmSetObjectValue(gw_uq_doc_no);
    	ComCgmSetObjectValue(agmt_ref_no);
    	ComCgmSetObjectValue(cre_dt);
    	ComCgmSetObjectValue(agmt_iss_ofc_cd, ofc_cd.value);
    	ComCgmSetObjectValue(agmt_eff_dt);
    	ComCgmSetObjectValue(agmt_exp_dt);
    	ComCgmSetObjectValue(duration);
    	ComCgmSetObjectValue(ctrt_no);
    	ComCgmSetObjectValue(vndr_seq);
    	ComCgmSetObjectValue(vndr_lgl_eng_nm);
    	ComCgmSetObjectValue(pay_term_dys);
    	ComCgmSetObjectValue(cre_usr_id);
    	
    	diff_rmk.value = "";
    	 
    	ComCgmSetObjectValue(pre_eff_dt);
    	ComCgmSetObjectValue(pre_exp_dt);
    }
    
    // MultiCombo 초기화
    comboObjects[0].RemoveAll();
	for(var i=1; i<comboObjects.length; i++){
		comboObjects[i].Text2 = "";	
	}
    
	// Sheet Object 초기화
	for(var i=0; i<sheetObjects.length; i++){
		sheetObjects[i].RemoveAll();	
	}
		
	// Tab 첫번째로 이동
	tabObjects[0].SelectedIndex = 0;
	
	// 초기 focus
    formObj.agmt_no.focus();
}

/**
* Version Up 기능을 수행한다. <br>
* @param  없음
* @return 없음
* @author 
* @version 2013.03.21
*/
function doVersionUp(){
	var index = comboObjects[0].GetCount(); 
	var agmt_ver_no = index + 1;
	 
	// version 설정
	comboObjects[0].InsertItem(index, agmt_ver_no, agmt_ver_no);
	comboObjects[0].Text2 = agmt_ver_no;
	
	// eff_dt 와 exp_dt 를 저장
    document.form.pre_eff_dt.value = document.form.agmt_eff_dt.value;
    document.form.pre_exp_dt.value = document.form.agmt_exp_dt.value;
	// 수정중
	document.form.pre_agmt_exp_dt.value = document.form.agmt_exp_dt.value;
}

/**
* Action 버튼의 활성/비활성을 설정한다. <br>
* @param  없음
* @return 없음
* @author 
* @version 2013.03.21
*/
function doActionBtnEnable (actionFlag){
	var btnRetrieve = document.getElementById("btn_retrieve");
	var btnNew 	  	= document.getElementById("btn_new");
	var btnSave 	= document.getElementById("btn_save");
	var btnDelete    = document.getElementById("btn_delete");
	var btnVersionUp = document.getElementById("btn_versionUp");
	
	if(actionFlag != "G") { 
		document.form.action_flag.value = actionFlag; // L, R, N, V
	}
	
	switch(actionFlag){
	 	case "L":
	 		btnRetrieve.className = BTN_ENABLE;
			btnNew.className = BTN_ENABLE;
			btnSave.className = BTN_DISABLE;
			btnDelete.className = BTN_DISABLE;
			btnVersionUp.className = BTN_DISABLE;
			ComBtnDisable("btn_t1RowAdd");
			ComBtnDisable("btn_t1Delete");
			ComBtnDisable("btn_t2RowAdd");
			ComBtnDisable("btn_t2Delete");
	 		break;
	 		 
		case "N":
			btnRetrieve.className = BTN_ENABLE;
			btnNew.className = BTN_ENABLE;
			btnSave.className = BTN_ENABLE;
			btnDelete.className = BTN_DISABLE;
			btnVersionUp.className = BTN_DISABLE;
			ComBtnEnable("btn_t1RowAdd");
			ComBtnEnable("btn_t1Delete");
			ComBtnEnable("btn_t2RowAdd");
			ComBtnEnable("btn_t2Delete");
		 	break;
		 		
		case "R":
			var lstVerFlg = document.form.lst_ver_flg.value;
	     	 
			btnRetrieve.className = BTN_ENABLE;
			btnNew.className = BTN_ENABLE;
			ComBtnEnable("btn_t1RowAdd");
			ComBtnEnable("btn_t1Delete");
			ComBtnEnable("btn_t2RowAdd");
			ComBtnEnable("btn_t2Delete");
//			ComBtnDisable("btn_t1RowAdd");
//			ComBtnDisable("btn_t1Delete");
//			ComBtnDisable("btn_t2RowAdd");
//			ComBtnDisable("btn_t2Delete");
			if(lstVerFlg == 'Y'){
//				btnSave.className = BTN_DISABLE;
				btnSave.className = BTN_ENABLE;
				btnDelete.className = BTN_ENABLE;
				btnVersionUp.className = BTN_ENABLE;
	 		} else {
	 			btnSave.className = BTN_DISABLE;
	 			btnDelete.className = BTN_DISABLE;
	 			btnVersionUp.className = BTN_DISABLE;
	 		}
			
		 	break;
	
		case "V":
		 	btnRetrieve.className = BTN_ENABLE;
		 	btnNew.className = BTN_ENABLE;
		 	btnSave.className = BTN_ENABLE;
	 		btnDelete.className = BTN_DISABLE;
		 	btnVersionUp.className = BTN_DISABLE;
		 	ComBtnEnable("btn_t1RowAdd");
		 	ComBtnEnable("btn_t1Delete");
		 	ComBtnEnable("btn_t2RowAdd");
		 	ComBtnEnable("btn_t2Delete");
		 	break;
		 	
	}
	tRoleApply();
}

/**
* Form Control 의 활성/비활성을 설정한다. <br>
* @param  {object} formObj	필수
* @param  {boolean} bEnable	필수
* @return 없음
* @author 
* @version 2013.03.21
*/ 
function setFormControlEnable(formObj, bEnable){
	with(formObj){
		    
		ComCgmEnableObject(agmt_no, 	bEnable);
		// 입력 불가 항목
		ComCgmEnableObject(curr_cd, false);
		ComCgmEnableObject(agmt_iss_ofc_cd, false);
		ComCgmEnableObject(duration, false);
		ComCgmEnableObject(vndr_seq, false);
		ComCgmEnableObject(vndr_lgl_eng_nm, false);
		ComCgmEnableObject(cre_dt, false);
		ComCgmEnableObject(cre_usr_id, false);
		
		   
		// 필수 입력값은 enable 이 true 일 경우 style 을  input1으로 세팅
		if(bEnable){
			ComCgmEnableObject(agmt_eff_dt, bEnable, 'input1');
			ComCgmEnableObject(agmt_exp_dt, bEnable, 'input1');
			ComCgmEnableObject(ctrt_no,		bEnable, 'input1');
			ComCgmEnableObject(agmt_ref_no, bEnable, 'input1');
		} else { 
			ComCgmEnableObject(agmt_eff_dt, bEnable);
			ComCgmEnableObject(agmt_exp_dt, bEnable);
			ComCgmEnableObject(ctrt_no, 	bEnable);
		    ComCgmEnableObject(agmt_ref_no, bEnable);
		}

		// 이미지 버튼 Enable
		ComCgmEnableObject(btns_Calendar_effDt, 	bEnable);
		ComCgmEnableObject(btns_agmtno, bEnable);
		ComCgmEnableObject(pay_term_dys,bEnable);
		
		if(bEnable){
			 ComCgmEnableObject(diff_rmk, bEnable);
		} else {
			 ComCgmEnableObject(diff_rmk, bEnable);
		}
		 
		// MultiCombo Enable
		comboObjects[1].Enable = bEnable;
		 
		// IBSheet Enable
//		for(var i = 0; i < sheetObjects.length; i++){
//		    sheetObjects[i].Enable = bEnable;
//		}
	}
}


/** 
 * Combo Object 초기화  <br>
 * @param  {object} comboObj	필수 Combo Object
 * @return 없음
 * @author 
 * @version 2013.03.21
 */
function initCombo(comboObj) {
    switch(comboObj.id) {
	    case "agmt_ver_no":
	 	 	var cnt=0;
	 	 	with(comboObj) {
	 	 		Code = "";
	 	 		Text = "";
	 	 		DropHeight = 100;
	 	 		MultiSelect = false;
	 	 		MaxSelect = 1;
	 	 		UseCode = true;
	 	 		Enable = true;
	 	 	}
	  	    break;
	  	    
	    case "chss_pool_cd":
	    	var cnt=0;
	    	with(comboObj) {
	    		Code = "";
	    		Text = "";
	    		DropHeight = 100;
	    		MultiSelect = false;
	    		MaxSelect = 1;
	    		UseCode = true;
	    		Enable = true;
	    		comboObj.UseAutoComplete = true;
	    	}
	    	break;
    }
}

/**
* IBTab Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setTabObject(tab_obj){
   tabObjects[tabCnt++] = tab_obj;

}

/**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
           with (tabObj) {

               var cnt  = 0 ;
               InsertTab( cnt++ , "Rental Rate" , -1 );
               InsertTab( cnt++ , "Condition" , -1 );

           }
        break;

    }
}

/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem)
{


   var objs = document.all.item("tabLayer");

   	objs[nItem].style.display = "Inline";
   	objs[beforetab].style.display = "none";

   	//--------------- 요기가 중요 --------------------------//
   	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
   	//------------------------------------------------------//
   	beforetab= nItem;
	

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
		case 1: // t1sheet1 init
			with (sheetObj) {
			
				// 높이 설정
				style.height = 250;
	
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 6, 100);
	
				var HeadTitle = "ibflag||SCC|Amount\nAudit(Y/N)|Pool Usage\nRate|Tax(%)|Remark";
				var headCount = ComCountHeadTitle(HeadTitle);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"loc_cd",			true,	"",	dfNone,	0, true, true, 5);
				InitDataProperty(0,	cnt++,	dtCombo,		110,	daCenter,	false,	"amt_aud_flg",		false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,	dtData,			90,		daCenter,	false,	"chss_pool_rt_amt",	false,	"",	dfFloat, 2, true, true, 5);
				InitDataProperty(0, cnt++,  dtData,			90,  	daCenter,	false,	"chss_pool_tax_rt",	false,	"",	dfFloat, 3, true, true, 5);
				InitDataProperty(0, cnt++,  dtData,			90,		daLeft,		false,	"agmt_rmk",				false,	"",	dfNone,	0, true, true, 1000);
				
				InitDataValid(0, "loc_cd", vtEngUpOnly);
				InitDataCombo(0, "amt_aud_flg",	"Y|N", "Y|N");
				
				ShowButtonImage = 4;
			}
			break;
			
		case 2: // t2sheet1 init
			with (sheetObj) {
			
				// 높이 설정
				style.height = 250;
	
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 6, 100);
	
				var HeadTitle1 = "ibflag||Yard|Yard Name\n(ALPS)|Yard Type|Lessor Location Name|Start/Stop|Domestic|Domestic|On TML Charge|On TML Charge|Billable SPC CNTR SZ name|Remarks|Multi Move\nDeduction";
				var HeadTitle2 = "ibflag||Yard|Yard Name\n(ALPS)|Yard Type|Lessor Location Name|Start/Stop|On TML(Y/N)|PDM(Y/N)|Full(Y/N)|Empty(Y/N)|Billable SPC CNTR SZ name|Remarks|Multi Move\nDeduction";
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
				InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	true,	"del_chk");
				InitDataProperty(0, cnt++,	dtData,			70,	 	daCenter,	true,	"yd_cd",					true,	"",	dfNone,	0, true, true, 7);
				InitDataProperty(0, cnt++,  dtData,			120,  	daLeft,		true,	"yd_nm",					false,	"",	dfNone,	0, false, false, 50);
				InitDataProperty(0, cnt++,  dtCombo,		90,	 	daCenter,	true,	"chss_yd_tp_cd",			false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,  dtData,			170,	daLeft,		true,	"lr_loc_nm",				false,	"",	dfNone,	0, true, true, 100);
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"st_stop_yd_flg",	    	false,	"",	dfNone,	0, true, true);  // 2014-07-17 추가, 신용찬
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"dmst_on_tml_chg_flg",		false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"dmst_pd_chg_flg",			false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"on_tml_chg_flg",			false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"on_tml_mty_chg_flg",		false,	"",	dfNone,	0, true, true);
				InitDataProperty(0, cnt++,  dtData,			200, 	daLeft,		true,	"bilabl_spcl_cntr_tp_nm", 	false,	"",	dfNone,	0, true, true, 100);
				InitDataProperty(0, cnt++,  dtData,			200, 	daLeft,		true,	"agmt_rmk", 				false,	"",	dfNone,	0, true, true, 1000);
				InitDataProperty(0, cnt++,  dtCombo,		100,	daCenter,	true,	"ddct_tp_cd",				false,	"",	dfNone,	0, true, true);
				
				InitDataValid(0, "yd_cd", vtEngUpOther, "1234567890");
				InitDataValid(0, "yd_nm", vtEngUpOther, "1234567890-.,()");
				InitDataCombo(0, "chss_yd_tp_cd", "Rail|Marine|ODCY", "RL|MR|OD");
				
				InitDataCombo(0, "st_stop_yd_flg",	"Y|N", "Y|N");  // 2014-07-17 추가, 신용찬
				
				InitDataCombo(0, "dmst_on_tml_chg_flg",	"Y|N", "Y|N");
				InitDataCombo(0, "dmst_pd_chg_flg",	"Y|N", "Y|N");
				InitDataCombo(0, "on_tml_chg_flg",	"Y|N", "Y|N");
				InitDataCombo(0, "on_tml_mty_chg_flg",	"Y|N", "Y|N");
				InitDataCombo(0, "ddct_tp_cd", "On Terminal 1 Day Deduction|No Deduction",	"1|2");

				
				ShowButtonImage = 4;
			}
			break;
			
		case "sheet":	// Hidden Sheet
        	with (sheetObj) {
            // 높이 설정
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            }
		break;
	}
}


//SHEET 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	
	switch (sAction) {

		// SEARCH LOGIC
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
    	    sheetObj.WaitImageVisible=false;
	 	    ComOpenWait(true);
     		var sXml = sheetObjects[2].GetSearchXml("EES_CGM_1202GS.do" , FormQueryString(formObj), '', true);
     		var arrXml = sXml.split("|$$|");
           	ComOpenWait(false);
     		// Sheet Object Clear
     		for(var k=0; k < sheetObjects.length; k++){
     			sheetObjects[k].RemoveAll();
     		}
     		
     		sheetObjects[0].LoadSearchXml(arrXml[0]);
     		
     		// ETC DATA 값을  FORM OBJECT 에 세팅
     		setEtcDataToForm(formObj, sheetObjects[0]);
     		
     		// 전체 데이터 건수를 가져온다.
     		var dataCount = ComGetTotalRows(arrXml[0]);
     		if(dataCount != null && dataCount > 0){
     			sheetObjects[0].LoadSearchXml(arrXml[0]);
         		sheetObjects[1].LoadSearchXml(arrXml[1]);
     			
         		// Agreement Version MultiCombo 설정
         		var comboItemCnt = comboObjects[0].getCount();
         		
	         	var cols = ComCgmXml2ComboString(arrXml[2], "agmt_ver_no", "agmt_ver_no");
	         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
	         	comboObjects[0].Text2 = ComCgmNullToBlank(sheetObjects[0].EtcData("agmt_ver_no"));
	         	
         		return true;
         	  	
     		} else {
     			
     			return false;
     		}
			break;
			
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1202GS.do", FormQueryString(formObj));
			yardCd = ComGetEtcData(sXml, "yd_cd");
			formObj.scc.value = ComGetEtcData(sXml, "loc_cd");
			formObj.yd_nm.value = ComGetEtcData(sXml, "yd_nm");
			break;
	
		// SAVE LOGIC
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
   		
     		var sParam = "";
         	var sParam1 = sheetObjects[0].GetSaveString(true); 
			var sParam2 = sheetObjects[1].GetSaveString(true);

			sParam1 = ComSetPrifix(sParam1, "t1sheet1_");
			sParam2 = ComSetPrifix(sParam2, "t2sheet1_");

			sParam = sParam + sParam1 + "&";
			sParam = sParam + sParam2 + "&";

			sParam = sParam + FormQueryString(formObj);
    	    sheetObj.WaitImageVisible=false;
	 	    ComOpenWait(true);
     		var sXml = sheetObj.GetSaveXml("EES_CGM_1202GS.do", sParam);
     		ComOpenWait(false);
     		if(formObj.action_flag.value == "N"){
     			formObj.agmt_no.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_no"));
     			formObj.agmt_ofc_cty_cd.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ofc_cty_cd"));
     			formObj.agmt_seq.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_seq"));
     			formObj.lst_ver_flg.value = ComCgmNullToBlank(ComGetEtcData(sXml, "lst_ver_flg"));

     			// Version 정보를 MultiCombo 에 세팅
     			var agmtVerNo = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ver_no"));
     			comboObjects[0].InsertItem(0,agmtVerNo,agmtVerNo);
     			comboObjects[0].Text2 = agmtVerNo;
     		}
     		sheetObj.LoadSaveXml(sXml);
			break;
			
		case IBDELETE:
     		formObj.f_cmd.value = REMOVE;
    	    sheetObj.WaitImageVisible=false;
	 	    ComOpenWait(true);
     		var sXml = sheetObj.GetSaveXml("EES_CGM_1202GS.do", FormQueryString(formObj));
     		sheetObj.LoadSaveXml(sXml);
     		ComOpenWait(false);
     		break;
			
		case IBSEARCH_ASYNC01:	// Vendor Code,Name 조회
    		formObj.f_cmd.value = SEARCH07;
    		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
    		var text = ComCgmNullToBlank(ComGetEtcData(sXml,"text"));
    		var genPayTermCd = ComCgmNullToBlank(ComGetEtcData(sXml,"gen_pay_term_cd"));
    	
    		for(var i=0; i<genPayTermCd.length; i++){
    			if(genPayTermCd.charCodeAt(i) < 48 || genPayTermCd.charCodeAt(i) > 57){
    				genPayTermCd = "0";
    				break;
    			}
    		}
    	
    		formObj.vndr_lgl_eng_nm.value = text;
    		if(text ==""){
    			formObj.vndr_seq.value = "";
    		}
    		formObj.pay_term_dys.value = genPayTermCd;
    		break;
    		
		case IBSEARCH_ASYNC02:	// SCC의 유효성 체크
 	    	formObj.f_cmd.value = SEARCH17;
			sccCount = 0;
    		formObj.eq_orz_cht_chktype.value = "SCC";
 	 		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
 	   		// 데이터 건수
 	        sccCount = ComGetTotalRows(sXml);
 	  	    break;
    		
		case IBINSERT:   // 행추가
 			sheetObj.DataInsert(-1);
 			break;
    
		case IBRESET:	 // 행삭제
			var chkDel = 0;
			for(var i=2 ; i <= sheetObj.RowCount+1 ; i++) {
				if(sheetObj.CellValue(i, "del_chk")){
					chkDel = chkDel+1;
				}
			}
			if(chkDel == 0){
				ComShowMessage("You did'nt check any Rows!");
				break;
			}
			if(ComShowConfirm('Do you want to delete it?')){
				ComRowHideDelete(sheetObj, "del_chk");
			}
			break;
		 case IBCLEAR:
	 		var idx = 0;
	 		var sXml2 = document.form2.sXml.value;
	 		var arrXml = sXml2.split("|$$|");
		 
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 	    var arrStr1 = new Array();
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		    vndrArr[i] = vListData["code2"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject(formObj.chss_pool_cd, arrStr1, 0, 0);
	 		idx++;

	 		break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
* @param  {object} sheetObj	필수	 Sheet Object
* @param  {object} formObj	필수 Form Object
* @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
* @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
* @author 
* @version 2013.03.21
*/   
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:	// 조회
				if(agmt_no.value == ''){
					ComShowCodeMessage('CGM10004','Agreement No.');
					agmt_no.focus();
					return false;
					
				} else {
					return true;
				}
				break;
				
			case IBSAVE:	// 저장
	   	 		var combo_chss_pool_cd = comboObjects[1];
	   	 		var sheet;
	   	 		var t1sheet1RowCnt = sheetObjects[0].RowCount;
	   	 		var t2sheet1RowCnt = sheetObjects[1].RowCount;
	   	 		var cnt;
	   	 		if(t1sheet1RowCnt - sheetObjects[0].RowCount("D") == 0){
	   	 			ComShowCodeMessage('CGM10004','Rental Rate. Tab');
	   	 			return false;
	   	 		}
	   	 		// Form 입력 체크
	   	 		if(agmt_ref_no.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Ref. No.');
	   	 			agmt_ref_no.focus();
	   	 			return false;
	   	 		} else if(agmt_eff_dt.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Agreement Eff. From Date');
	   	 			agmt_eff_dt.focus();
	   	 			return false;
	   	 		} else if(agmt_exp_dt.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Agreement Eff. To Date');
	   	 			agmt_exp_dt.focus();
	   	 			return false;
	   	 		} else if(ctrt_no.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Contract No.');
	   	 			ctrt_no.focus();
	   	 			return false;
	   	 		} else if(vndr_seq.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Lessor');
	   	 			vndr_seq.focus();
	   	 			return false;
	   	 		} else if(combo_chss_pool_cd.Text == ''){
	   	 			ComShowCodeMessage('CGM10004','Pool');
	   	 			chss_pool_cd.focus();
	   	 			return false;
	   	 		} else if(pay_term_dys.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Payment Term');
	   	 			pay_term_dys.focus();
	   	 			return false;
	   	 		}
		   	 	for(var i=1; i <= t1sheet1RowCnt ; i++) {
		   	 		if(sheetObjects[0].CellValue(i,"loc_cd") == ""){
		   	 			ComShowCodeMessage('CGM10004','SCC');
		   	 			return false;
		   	 		}
		   	 		if(sheetObjects[0].CellValue(i,"ibflag") == "I"){
		   	 			for(var j=1; j <= t1sheet1RowCnt ; j++) {
		   	 				if (i==j) continue;
		   	 				if (sheetObjects[0].CellValue(i,"loc_cd") == sheetObjects[0].CellValue(j, "loc_cd")) {
		   	 					ComShowMessage(i + " and " + j + " Row's SCC is duplicated.");
		   	 					return false;
		   	 				}
		   	 			}
		   	 		}
		   	 	}
		   	 	for(var i=2; i <= t2sheet1RowCnt+1 ; i++) {
			   	 	if(sheetObjects[1].CellValue(i,"yd_cd") == ""){
			   	 		ComShowCodeMessage('CGM10004','Yard Code');
		   	 			return false;
		   	 		}
		   	 		if(sheetObjects[1].CellValue(i,"ibflag") == "I"){
		   	 			for(var j=2; j <= t2sheet1RowCnt+1 ; j++) {
		   	 				if (i==j) continue;
		   	 				if (sheetObjects[1].CellValue(i,"yd_cd") == sheetObjects[1].CellValue(j, "yd_cd")) {
		   	 					ComShowMessage(i + " and " + j + " Row's Yard Code is duplicated.");
		   	 					return false;
		   	 				}
		   	 			}
		   	 		}
		   	 	}
		   		if(t2sheet1RowCnt > 0){
		   			formObj.f_cmd.value = SEARCH01;
		   			for(var i=2; i <= t2sheet1RowCnt+1 ; i++){
		   				if(sheetObjects[1].CellValue(i, "ibflag") != "D" ){
			   				cnt = 0;
			   				formObj.chk_yd_cd.value = sheetObjects[1].CellValue(i, "yd_cd");
			   				doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
			   				for (var j=1; j <= t1sheet1RowCnt; j++){
			   					if(sheetObjects[0].CellValue(j, "ibflag") != "D" ){
			   						if(sheetObjects[0].CellValue(j,"loc_cd") == formObj.scc.value){
				   						cnt = cnt + 1;
				   					}
			   					}
			   				}
			   				if(cnt == 0){
			   					ComShowMessage(formObj.chk_yd_cd.value + " is not matched at Rental Rate's SCC.");
			   					return false;
			   				}
		   				}
		   			}
		   		}
	   	 		return true;
	   	 			
	   	 		break;
	   	 		
			case IBDELETE:	// 삭제
	   	 		if(agmt_no.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Agreement No.');
	   	 			agmt_no.focus();
	   	 			return false;
	   	 		} else if(agmt_ver_no.value == ''){
	   	 			ComShowCodeMessage('CGM10004','Version');
	   	 			agmt_ver_no.focus();
	   	 			return false;
	   	 		} else {
	   	 			return true;
	   	 		}
				break;
		}
	}
}

/**
 * ETC 데이터를 Form Tag 에 설정한다. <br>
 * @param  {object} formObj	 필수
 * @param  {object} sheetObj 필수
 * @return 없음
 * @author 
 * @version 2013.03.21
 */
function setEtcDataToForm(formObj, sheetObj){
 	formObj.agmt_ofc_cty_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
	formObj.agmt_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
	formObj.lst_ver_flg.value 		= ComCgmNullToBlank(sheetObj.EtcData("lst_ver_flg"));
	
	formObj.agmt_no.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_no"));
	formObj.gw_uq_doc_tit_nm.value	= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_tit_nm"));
 	formObj.gw_uq_doc_no.value		= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_no"));
	formObj.agmt_eff_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_eff_dt"));
	formObj.agmt_exp_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_exp_dt"));
	formObj.duration.value 			= ComCgmNullToBlank(sheetObj.EtcData("duration"));
	formObj.ctrt_no.value 			= ComCgmNullToBlank(sheetObj.EtcData("ctrt_no"));
	formObj.agmt_ref_no.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_ref_no"));
	formObj.vndr_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
	formObj.vndr_lgl_eng_nm.value 	= ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
	formObj.pay_term_dys.value 		= ComCgmNullToBlank(sheetObj.EtcData("pay_term_dys"));
	formObj.agmt_iss_ofc_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_iss_ofc_cd"));
	formObj.cre_usr_id.value 		= ComCgmNullToBlank(sheetObj.EtcData("cre_usr_id"));
	formObj.cre_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("cre_dt"));
	formObj.diff_rmk.value 			= ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
	
	comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
	comboObjects[1].Text2 = ComCgmNullToBlank(sheetObj.EtcData("chss_pool_cd"));
}

 /** 
  * Object 의 Keypress 이벤트에 대한 처리  <br>
  * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.20
  */ 
 function obj_keypress(){
  	obj = event.srcElement;
  	if(obj.dataformat == null) return;
  	 	
  	window.defaultStatus = obj.dataformat;
  	
  	// 특수문자 아스키값
  	var specChar = '33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|'
  	specChar = specChar + '58|59|60|61|62|63|64|91|92|93|94|95|123|124|125|126';
  	
  	switch(obj.dataformat) {
  	 	case "ym": case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	 		break;
  	 	case "int":
  	    	ComKeyOnlyNumber(obj);
  	        break;
  	 	case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;    
  	    case "eng":
  	        ComKeyOnlyAlphabet(); 
  	        break;
  	    case "engup":
  	        if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
  	        else if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum');
  	        else if(obj.name=="agmt_ref_no") ComKeyOnlyAlphabet('uppernum',specChar);
  	        else if(obj.name=="ctrt_no") ComKeyOnlyAlphabet('uppernum',specChar);
  	        else ComKeyOnlyAlphabet('upper');
  	        break;
  	    case "engdn":
  	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
  	        else ComKeyOnlyAlphabet('lower');
  	        break;
  	}
 }
 
 /** 
  * Object 의 Keydown 이벤트에 대한 처리  <br>
  * 객체가 agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.19
  */ 
 function obj_keydown(){
	var formObj = document.form;
 	obj = event.srcElement;
 	
 	switch(obj.name){
 		case 'agmt_no':
 			var keyValue = null;
         	if(event == undefined || event == null) {
         		keyValue = 13;
         	} else {
         		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 			}
         	
 			if(keyValue != 13) return;
 			
 			var agmtNo = formObj.agmt_no.value;
 	 		var result = true;
 	 		
 	 		if(agmtNo != "" && agmtNo != "NEW"){
 	 			if(agmtNo.length <= 3){
 	 				result = false;
 	 			} else {
 	 				if(ComIsNumber(agmtNo.substring(3))==false){
 	 					result = false;
 	 				}
 	 			}
 	 		} else {
 	 			result = true;
 	 		}
 	 		
 	 		if(!result){
 	 			ComShowCodeMessage('CGM10004','Agreement No.');
 	 			formObj.agmt_no.value="";
 	 			ComSetFocus(formObj.agmt_no);
 	 		} else {
 	 			ComKeyEnter();
 	 		}
 			
 			break;
 	}
 }

 /** 
  * Object 의 activate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.20
  */
 function obj_activate(){
  	ComClearSeparator(event.srcElement);
 }
   
 /** 
  * Object 의 deactivate 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.20
  */
 function obj_deactivate(){
  	var formObj = document.form;
  	obj = event.srcElement;      	
  	 
  	with(formObj){
  		if(obj.name=="agmt_eff_dt" || obj.name=="agmt_exp_dt" || obj.name=="cre_dt"){
  			var preEffDt = ComReplaceStr(pre_eff_dt.value,"-","");
  			var preExpDt = ComReplaceStr(pre_exp_dt.value,"-","");
  			var agmtEffDt = ComReplaceStr(agmt_eff_dt.value,"-","");
  			var agmtExpDt = ComReplaceStr(agmt_exp_dt.value,"-","");
  		    var preAgmtExpDt = ComReplaceStr(pre_agmt_exp_dt.value,"-","");
	        
  			switch(obj.name) {
  				case "agmt_eff_dt":
  					if(agmtEffDt != '' && agmtExpDt != ''){
  						if(agmtEffDt > agmtExpDt){
  							ComShowCodeMessage('COM12133','To date','From date','greater');
  							agmt_eff_dt.value='';
  							agmt_eff_dt.focus();
  						}
  					}
  					break;
  					
  				case "agmt_exp_dt":
  					if(agmtEffDt != '' && agmtExpDt != ''){
  						if(agmtEffDt > agmtExpDt){
  							ComShowCodeMessage('COM12133','To date','From date','greater');
  							agmt_exp_dt.value='';
  							agmt_exp_dt.focus();
  							break;
  						}
  					}
  					if(preAgmtExpDt!= '' && agmtExpDt != ''){
  						if(preAgmtExpDt > agmtExpDt){
  							ComShowCodeMessage('COM12133','Agreement Exp. Date', pre_agmt_exp_dt.value,'greater');
  							agmt_exp_dt.value= pre_agmt_exp_dt.value;
  							agmt_exp_dt.focus();
  							break;
  						}
  					}
  					break;
  			}
  			ComChkObjValid(event.srcElement);
  		}
  	}
 } 
    
 /** 
  * Object 의 change 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 
  * @version 2013.03.20
  */  
 function obj_change(){ 	 
 	var formObj = document.form;
 	var sheetObj = sheetObjects[0];
 	 
 	obj = event.srcElement;
 	switch(obj.name){
 	 	case "agmt_no":
 	 		var agmtNo = formObj.agmt_no.value;
 	 		var result = true;
 	 		
 	 		if(agmtNo != "" && agmtNo != "NEW"){
 	 			if(agmtNo.length <= 3){
 	 				result = false;
 	 			} else {
 	 				if(ComIsNumber(agmtNo.substring(3))==false){
 	 					result = false;
 	 				}
 	 			}
 	 		} else {
 	 			result = true;
 	 		}
 	 		
 	 		if(!result){
 	 			ComShowCodeMessage('CGM10004','Agreement No.');
 	 			formObj.agmt_no.value="";
 	 			ComSetFocus(formObj.agmt_no);
 	 		}
 	 		
 	 		// 버튼 활성/비활성
 	 		if(formObj.action_flag.value == "N"){
 	 			if(agmtNo != "NEW"){
 	 				doActionBtnEnable('L');
 	 			}
 	 		}
 	 		break;
 	 
 	 	case "pay_term_dys":
 	 		if(formObj.pay_term_dys.value !=''){
 	 			formObj.pay_term_dys.value = Math.abs(formObj.pay_term_dys.value)
 	 		}
 	 		break;
 	}
 }

/**
* Agreement Version No 의 Change 이벤트를 정의한다. <br>
* @param  {string} Index_Code 필수
* @param  {string} Text 필수
* @return 없음
* @author 
* @version 2013.03.21
*/
function agmt_ver_no_OnChange(Index_Code, Text){
	var obj = document.getElementById("btn_retrieve");
	obj.fireEvent("onclick");
}

/**
* Pool Code 의 Change 이벤트를 정의한다. <br>
* @param  {string} Index_Code 필수
* @param  {string} Text 필수
* @return 없음
* @author 
* @version 2013.03.21
*/
function chss_pool_cd_OnChange(comboObj, Index_Code, Text){
	var formObject = document.form;
	if(Index_Code != "" && vndrArr[comboObj.index - 1] != ""){
		// Lessor 명칭 가져오기
		formObject.vndr_seq.value = vndrArr[comboObj.index - 1];
		doActionIBSheet(sheetObjects[2], formObject, IBSEARCH_ASYNC01);
	} else {
		// Pool Name 콤보에서 null 값 선택했을 경우 Lessor 명칭을 삭제
		formObject.vndr_seq.value = "";
		formObject.vndr_lgl_eng_nm.value = "";
		formObject.pay_term_dys.value = "";
	}
}

/**
* t2Sheet1 의 Change 이벤트를 정의한다.
* @param SheetObj
* @param Row
* @param Col
* @param Value
*/
function t1sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	if(sheetObj.ColSaveName(Col) == "loc_cd" && sheetObj.CellValue(Row,"loc_cd") != ""){
		formObj.eq_orz_cht_scc_cd.value = sheetObj.CellValue(Row,"loc_cd");
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		if(sccCount==0){
	        ComShowCodeMessage('CGM10009','SCC');
	        sheetObj.CellValue2(Row,"loc_cd") = "";
	        return false;
		}
	}
}

/**
* t2Sheet1 의 Change 이벤트를 정의한다.
* @param SheetObj
* @param Row
* @param Col
* @param Value
*/
function t2sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	var cnt = 0;
	var t1sheet1RowCnt = sheetObjects[0].RowCount;
	if(sheetObj.ColSaveName(Col) == "yd_cd" && sheetObj.CellValue(Row,"yd_cd") != ""){
		formObj.f_cmd.value = SEARCH01;
		formObj.chk_yd_cd.value = sheetObj.CellValue(Row, "yd_cd");
		doActionIBSheet(sheetObj, formObj, SEARCH01);
		if(yardCd == "" || yardCd == "null"){
			ComShowCodeMessage('CGM20023', "Yard Code");
			sheetObj.CellValue2(Row, "yd_cd") = "";
		}else{
			for (var i=1; i <= t1sheet1RowCnt; i++){
				if(sheetObjects[0].CellValue(i, "ibflag") != "D" ){
					if(sheetObjects[0].CellValue(i,"loc_cd") == formObj.scc.value){
   						cnt = cnt + 1;
   					}
				}
			}
			if(cnt == 0){
				ComShowMessage(formObj.chk_yd_cd.value + " is not matched at Rental Rate's SCC.");
				sheetObj.CellValue2(Row, "yd_cd") = "";
			} else {
				sheetObj.CellValue2(Row, "yd_nm") = formObj.yd_nm.value;
			}
		}
	}
}

/**
 * Sheet1 의 OnSaveEnd 이벤트처리 (저장) <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2013.03.21
 */ 
function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObject = document.form;
	 
	if(errMsg =='') {   
		ComShowCodeMessage('CGM00003');
		
		// 조회
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			
		// Form Control 활성/비활성 처리
//		doControlEnable("btn_retrieve");
		doControlEnable("btn_new");
			
		// 버튼 활성/비활성 처리
		doActionBtnEnable('R');
	}
}

/**
 * Sheet2 의 OnSaveEnd 이벤트처리 (삭제) <br>
 * @param  {object} sheetObj	필수	 Sheet Object
 * @param  {string} ErrMsg		필수 String
 * @return 없음
 * @version 2013.03.21
 */
function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObject = document.form;
	if(errMsg =='') {
		ComShowCodeMessage('CGM00003');
		if(comboObjects[0].GetCount() > 1){
			comboObjects[0].Text2 = "";
		    	
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				
			// Form Control Enable 설정
//			doControlEnable("btn_retrieve");
			doControlEnable("btn_new");
				
			// 버튼 활성/비활성 처리
			doActionBtnEnable('R');
		} else {
			
			//Form Control 초기화
			initControl();
				
			// Form Control Enable 설정
			doControlEnable("btn_new");

			// 버튼 활성/비활성 처리
			doActionBtnEnable('L');
		}
	}
}

/** 
* Combo Object 에 값을 추가하는 처리 <br>
* @param  {object} cmbObj	필수 Combo Object
* @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
* @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
* @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
* @return 없음
* @author 
* @version 2013.03.21
*/ 
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0,"","");
	for (var i = 0; i < arrStr.length;i++ ) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
}

/**
* 기능(ex:btn_save)에 권한(trole) 적용  <br>
* @param  없음
* @return 없음
* @author 
* @version 2013.03.21
*/     
function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_delete");
		  ComBtnDisable("btn_save");
		  ComBtnDisable("btn_versionUp");
		  ComBtnDisable("btn_t1RowAdd");
		  ComBtnDisable("btn_t1Delete");
		  ComBtnDisable("btn_t2RowAdd");
		  ComBtnDisable("btn_t2Delete");
		  
		  // 1202은 자체적으로 en/disable시키는 함수가 있다. 따라서 아래를 강제적으로 적용해주어야 함.
	      var btnSave 	  = document.getElementById("btn_save");
	      var btnDelete    = document.getElementById("btn_delete");
	      var btnVersionUp = document.getElementById("btn_versionUp");
		  btnSave.className = BTN_DISABLE;
		  btnDelete.className = BTN_DISABLE;
		  btnVersionUp.className = BTN_DISABLE;
	  }
}
/* 개발자 작업 끝 */
