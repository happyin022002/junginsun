/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1020.js
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.28 김창식
* 1.0 Creation
* ---------------------------------------------------------
* 2014-02-24 Jonghee HAN Lease Agreement Term Code 내 ZP Code 삭제
* 2014-09-24 Chang Young Kim 10만불 비용지급 결재건 3차
===========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * @extends 
	 * @class ees_cgm_1020 : ees_cgm_1020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cgm_1020() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var currCd = "";	// Currency
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;

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
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * @param 없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */  
	function processButtonClick(){
		///***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		  
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		  
		///*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					if(ComCgmIsActionButtonEnable(srcName)){
						if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
							// Search 실행
							var result = doActionIBSheet(sheetObject1, formObject, IBSEARCH);

							if(result){
								// Form Control 활성/비활성 처리
								doControlEnable("btn_Retrieve");
								
								// 버튼 활성/비활성 처리 
								doActionBtnEnable('R');
							}
						}
					}
					break;
	
				case "btn_New":
					if(ComCgmIsActionButtonEnable(srcName)){
						// Form Control 초기화
						initControl();
						
						formObj.agmt_ref_no.focus();
						
						// Form Control Enable 설정
						doControlEnable("btn_New");
	
						// 버튼 활성/비활성 처리
						formObject.agmt_no.value = "NEW";
						doActionBtnEnable('N');
						
						break;
					}
	
				case "btn_Delete":
					if(ComCgmIsActionButtonEnable(srcName)){
						if(validateForm(sheetObject1,formObject,IBDELETE) != false) {
							if(ComShowCodeConfirm('CGM00005','the Agreement')){
								// 삭제 실행
								doActionIBSheet(sheetObject2,formObject,IBDELETE);
							}
						}
					}
					
					break;
	
				case "btn_Save":
					if(ComCgmIsActionButtonEnable(srcName)){
						if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
							if(ComShowCodeConfirm('CGM10047')){
								// 저장 실행
								doActionIBSheet(sheetObject1,formObject,IBSAVE);
								
							}
						}
					}
					break;
	
				case "btn_VersionUp":
					if(ComCgmIsActionButtonEnable(srcName)){
						// Version Up
						doVersionUp();
						
						// Form Control Enable 설정
						doControlEnable("btn_VersionUp");
						
						// 버튼 활성/비활성 처리
						doActionBtnEnable('V');
						
					}
					break;
				
				case "btn_t2RowAdd":
					if(sheetObject5.Enable){
						doActionIBSheet(sheetObject5,formObject,IBINSERT);
					}
					break;
	
				case "btn_t2Delete":
					if(sheetObject5.Enable){
						doActionIBSheet(sheetObject5,formObject,IBRESET);
					}
					break;
					
				case "btn_t3RowAdd":
					if(formObject.eq_rntl_tp_cd(1).checked){	
						if(sheetObject2.Enable){
							doActionIBSheet(sheetObject2,formObject,IBINSERT);
						}
					} else if (formObject.eq_rntl_tp_cd(2).checked){
						if(sheetObject3.Enable){
							doActionIBSheet(sheetObject3,formObject,IBINSERT);
						}
					}
					break;
	
				case "btn_t3Delete":
					if(formObject.eq_rntl_tp_cd(1).checked){
						if(sheetObject2.Enable){
							doActionIBSheet(sheetObject2,formObject,IBRESET);
						}
					} else if (formObject.eq_rntl_tp_cd(2).checked){
						if(sheetObject3.Enable){
							doActionIBSheet(sheetObject3,formObject,IBRESET);
						}
					}
					break;
					
				case "btns_Calendar_agmtDt" :		// Agreement Date
					if(!formObject.agmt_dt.readOnly){
						var cal = new ComCalendar();
						cal.select(formObject.agmt_dt, "yyyy-MM-dd");
					}
					break;
						
				case "btns_Calendar_effDt" :		// Effective Date (From Date)
					if(!formObject.eff_dt.readOnly){
						var cal = new ComCalendar();
						cal.select(formObject.eff_dt, "yyyy-MM-dd");
					}
					break;		
					
				//case "btns_Calendar_expDt" :		// Effective Date (To Date)
				//	if(!formObject.exp_dt.readOnly){
				//		var cal = new ComCalendar();
				//		cal.select(formObject.exp_dt, "yyyy-MM-dd");
				//	}
				//	break;
					
				case "btns_Calendar_agmt_effDt" :		// Agreement Effective Date (From Date)
					if(!formObject.agmt_eff_dt.readOnly){
						var cal = new ComCalendar();
						cal.select(formObject.agmt_eff_dt, "yyyy-MM-dd");
					}
					break;		
					
				case "btns_Calendar_agmt_expDt" :		// Agreement Effective Date (To Date)
					if(!formObject.agmt_exp_dt.readOnly){ 
						var cal = new ComCalendar();
						cal.select(formObject.agmt_exp_dt, "yyyy-MM-dd");
					}
					break;
					
				case "dpp_tp_cd":					// Rental Rate Type Radio Button
				case "drp_off_lmt_tp_cd":			// Fixed Quantity, Guaranted Portion
					doOptionBtnAction(formObject, srcName);
					break;
				
				case "eq_rntl_tp_cd":				// Rental Rate Type Radio Button
					setTab3SheetEnable(formObject);
					break;
					
				case "btns_agmtno":	// Agreement No 가져오기 팝업
					if(!formObject.agmt_no.readOnly){
						ComOpenPopupWithTarget('/hanjin/EES_CGM_1117.do', 800, 420, "agmt_no:agmt_no", "1,0,1,1,1,1,1,1,1", true);
					}
					break;
				
				case "btns_vndr":	// Lessor Code 가져오기 팝업
					if(!formObject.vndr_seq.readOnly){
						ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
					}
					break;	
					
				case "btns_curr_cd":	// Currency 가져오기 팝업
					var currCd = document.getElementById("btns_curr_cd");
					if(!currCd.disabled){
						var param = "curr_cd=&cnt_cd=&curr_desc=";
						ComOpenPopupWithTarget('/hanjin/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 500, 450, "curr_cd:curr_cd", "1,0,1,1,1", true);
					}
					break;
					
				case "btns_gwUqDoc":	// 2014-09-24 Chang Young Kim, G/W 링크 호출 or G/W 계약문서 상세조회
					
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
						formObject.gw_uq_doc_no.value	= "234567";
						formObject.gw_uq_doc_tit_nm.value	= "CHS_DOCU_234567.xlsx";
						
						// button setting
						doActionBtnEnable('G');
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
			 tRoleApply();
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	// GW에서 리턴된 값 화면 적용
	function returnGwLink(msg) {
		
		msg = msg.split(",");
		
		var formObj = document.form;
		
		// setting
		ComSetObjValue(formObj.gw_uq_doc_no, msg[0]);
		ComSetObjValue(formObj.gw_uq_doc_tit_nm, msg[1]);

		// button setting
		doActionBtnEnable('G');
	}
	
	/**
	 * Control 의 Action 별 Enable 제어 기능을 수행한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */	 
	function doControlEnable(srcName){
		
		var formObj = document.form;
		
		switch(srcName){
			case "btn_Retrieve":
				setFormControlEnable(formObj, false);			
				break;
				
			case "btn_New":
				setFormControlEnable(formObj, true);
				doOptionBtnAction(formObj, "dpp_tp_cd");
				break;
					
			case "btn_VersionUp":
				setFormControlEnable(formObj, true);
				ComCgmEnableObject(formObj.agmt_no, false);
				ComCgmEnableObject(formObj.btns_agmtno, false);
				ComCgmEnableObject(formObj.agmt_eff_dt, false);
				ComCgmEnableObject(formObj.agmt_dt, false);
				ComCgmEnableObject(formObj.agmt_exp_dt, true);
				ComCgmEnableObject(formObj.btns_Calendar_agmt_effDt, false);
				ComCgmEnableObject(formObj.btns_Calendar_agmtDt, false);
				ComCgmEnableObject(formObj.btns_Calendar_agmt_expDt, true);
				ComCgmEnableObject(formObj.btns_curr_cd, false);
				 
				document.agmt_lstm_cd.Enable = false;
				document.chss_pool_cd.Enable = false;
				
				ComCgmEnableObject(formObj.vndr_seq, false);
				ComCgmEnableObject(formObj.btns_vndr, false);
				
				doOptionBtnAction(formObj, "dpp_tp_cd");
				ComCgmEnableObject(formObj.agmt_exp_dt, true, 'input1');
				
				
				break;
				
			default:	// Load
				setFormControlEnable(formObj, false);
				ComCgmEnableObject(formObj.agmt_no, true);
				ComCgmEnableObject(formObj.btns_agmtno, true);
//				doOptionBtnAction(formObj, "dpp_tp_cd");
				break;
		}
		tRoleApply();
	}

	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * @param  {object} sheetObj	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function setSheetObject(sheet_obj){

		sheetObjects[sheetCnt++] = sheet_obj;

	}
	 
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function loadPage() {

		var formObj = document.form;
		 
		// axon event 등록
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', form);
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('change', 'obj_change', 'agmt_no'); 
		axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
		axon_event.addListener('change', 'obj_change', 'pay_term_dys'); 
		
		// Tab Object 초기화
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

		// Sheet Object 초기화
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			 
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);

		}

		// IBMultiCombo 초기화
		comboObjects[comboCnt++] = document.agmt_ver_no;
		comboObjects[comboCnt++] = document.agmt_lstm_cd;
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
	 * @author 김창식
	 * @version 2009.10.23
	 */ 
	function t3sheet1_OnLoadFinish(sheetObj) { 
		var formObj = document.form;
		 
		sheetObj.WaitImageVisible = false;
		// 버튼 활성/비활성 처리
		doActionBtnEnable('L');
	 	
	 	// Lease Term Combo Control에  초기값을  설정한다.
//		doActionIBSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC01);
//		 
//		// Pool List MultiCombo Control에  초기값을  설정한다.
//		doActionIBSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC02);
//		 
//		// IBSheet내 Combo 초기화
//		doActionIBSheet(sheetObjects[4],formObj,IBSEARCH_ASYNC03);
//		 
		doActionIBSheet(sheetObjects[4], formObj, IBCLEAR);
//		// Organization 정보에서 Currency 정보를 화면에 표시
//		doActionIBSheet(sheetObjects[5],formObj,IBSEARCH_ASYNC05);
		
		
		 
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
	 * @author 김창식
	 * @version 2009.05.20
	 */
	function initControl(){
		// Form 객체 선언
		formObj = document.form;
		 
		// Form Object 초기화 
		with(formObj){
			ComCgmSetObjectValue(eq_knd_cd);
			ComCgmSetObjectValue(agmt_ofc_cty_cd);
			ComCgmSetObjectValue(agmt_seq);
			ComCgmSetObjectValue(agmt_no);
			ComCgmSetObjectValue(agmt_ver_no);
			ComCgmSetObjectValue(lst_ver_flg);
			ComCgmSetObjectValue(agmt_ref_no);
			ComCgmSetObjectValue(curr_cd);
			ComCgmSetObjectValue(agmt_dt);
			ComCgmSetObjectValue(agmt_iss_ofc_cd, ofc_cd.value);
			ComCgmSetObjectValue(gw_uq_doc_tit_nm);
			ComCgmSetObjectValue(gw_uq_doc_no);
			ComCgmSetObjectValue(eff_dt);
			ComCgmSetObjectValue(exp_dt);
			ComCgmSetObjectValue(agmt_eff_dt);
			ComCgmSetObjectValue(agmt_exp_dt);
			ComCgmSetObjectValue(vndr_seq);
			ComCgmSetObjectValue(vndr_lgl_eng_nm);
			ComCgmSetObjectValue(pay_term_dys);
			
			ComCgmSetObjectValue(dpp_rt_amt,'0');
			ComCgmSetObjectValue(dpp_cvrg_amt,'0');
			ComCgmSetObjectValue(lmsm_amt,'0');
			ComCgmSetObjectValue(onh_hndl_rt_amt,'0');
			ComCgmSetObjectValue(offh_hndl_rt_amt,'0');
			ComCgmSetObjectValue(drp_off_lmt_qty,'0');
			ComCgmSetObjectValue(drp_off_lmt_rto,'0');
			ComCgmSetObjectValue(mon_dpc_rt_amt,'0');
			ComCgmSetObjectValue(max_dpc_rt_amt,'0');
			ComCgmSetObjectValue(init_dpc_rt_amt,'0');
			diff_rmk.value = "";
			 
			ComCgmSetObjectValue(pre_eff_dt);
			ComCgmSetObjectValue(pre_exp_dt);
			 
			ComCgmSetObjectValue(eq_rntl_tp_cd(0));
			ComCgmSetObjectValue(dpp_tp_cd(0));
			ComCgmSetObjectValue(drp_off_lmt_prd_cd(0));
			ComCgmSetObjectValue(drp_off_lmt_tp_cd(0));
			 
			dpp_rt_amt.readOnly	  = false;
			dpp_cvrg_amt.readOnly = false;
			lmsm_amt.readOnly	  = true;
		}

		// Currency 설정
		formObj.curr_cd.value = currCd;
		
		// Visibility 설정
		// Rental Rate Tab 안의  Sheet Objects 활성처리
		setTab3SheetEnable(formObj);
		
		// Fixed Quantity 지정
		document.getElementById("qtyLayer").style.display = "block";
		document.getElementById("rtoLayer").style.display = "none";
			
		// Pool Layer Hidden 처리
		var element = document.getElementById("poolLayer");
		element.style.visibility = "hidden";
		 
		// MultiCombo 초기화
		comboObjects[0].RemoveAll();
 		for(var i=1; i<comboObjects.length; i++){
 			comboObjects[i].Text2 = "";	
 		}
		
 		// Sheet Object 초기화
 		for(var i=0; i<sheetObjects.length; i++){
 			sheetObjects[i].RemoveAll();	
 		}
 		
 		// Sheet Object 값 설정
 		for(var i = 0; i < 10; i++ ){
 			sheetObjects[0].cellValue2(1,i+2) = 0;
 			sheetObjects[3].cellValue2(1,i+2) = 0;
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
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function doVersionUp(){
		var index = comboObjects[0].GetCount(); 
		var agmt_ver_no = index + 1;
		 
		// version 설정
		comboObjects[0].InsertItem(index, agmt_ver_no, agmt_ver_no);
		comboObjects[0].Text2 = agmt_ver_no;
		 
		// eff_dt 와 exp_dt 를 저장
		document.form.pre_eff_dt.value = document.form.eff_dt.value;
		document.form.pre_exp_dt.value = document.form.exp_dt.value;
		// 수정중
		document.form.pre_agmt_exp_dt.value = document.form.agmt_exp_dt.value;
		
		document.form.eff_dt.value = "";
		document.form.exp_dt.value = document.form.agmt_exp_dt.value;
		
		
	}
	  
	/**
	 * Action 버튼의 활성/비활성을 설정한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function doActionBtnEnable (actionFlag){
		var btnRetrieve  = document.getElementById("btn_Retrieve");
		var btnNew	  = document.getElementById("btn_New");
		var btnSave	  = document.getElementById("btn_Save");
		var btnDelete	= document.getElementById("btn_Delete");
		var btnVersionUp = document.getElementById("btn_VersionUp");
		
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
				break;
				 
			case "N":
				btnRetrieve.className = BTN_ENABLE;
				btnNew.className = BTN_ENABLE;
				btnSave.className = BTN_ENABLE;
				btnDelete.className = BTN_DISABLE;
				btnVersionUp.className = BTN_DISABLE;
				break;
					
			case "R":
				var lstVerFlg = document.form.lst_ver_flg.value;
				 
				btnRetrieve.className = BTN_ENABLE;
				btnNew.className = BTN_ENABLE;
				if(lstVerFlg == 'Y'){
					btnSave.className = BTN_DISABLE;
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
				break;
				
			case "G":
				btnRetrieve.className = BTN_ENABLE;
				btnNew.className = BTN_ENABLE;
				btnSave.className = BTN_ENABLE;
				btnDelete.className = BTN_DISABLE;
				btnVersionUp.className = BTN_DISABLE;
				break;
		}
		tRoleApply();
	}
		  
	/**
	 * Form Control 의 활성/비활성을 설정한다. <br>
	 * @param  {object} formObj	필수
	 * @param  {boolean} bEnable	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */ 
	function setFormControlEnable(formObj, bEnable){
		with(formObj){
				
			ComCgmEnableObject(agmt_no,	bEnable);
			
			// 입력 불가 항목
			ComCgmEnableObject(curr_cd, false);
			ComCgmEnableObject(agmt_iss_ofc_cd, false);
			ComCgmEnableObject(vndr_lgl_eng_nm, false);
			ComCgmEnableObject(exp_dt, false);
			
			   
			// 필수 입력값은 enable 이 true 일 경우 style 을  input1으로 세팅
			if(bEnable){
				ComCgmEnableObject(agmt_ref_no, bEnable, 'input1');
				ComCgmEnableObject(agmt_dt,	bEnable, 'input1');
				ComCgmEnableObject(eff_dt,		bEnable, 'input1');
				ComCgmEnableObject(agmt_eff_dt, bEnable, 'input1');
				ComCgmEnableObject(agmt_exp_dt, bEnable, 'input1');
				ComCgmEnableObject(vndr_seq,	bEnable, 'input1');
			} else { 
				ComCgmEnableObject(agmt_ref_no, bEnable);
				ComCgmEnableObject(agmt_dt,	bEnable);
				ComCgmEnableObject(eff_dt,		bEnable);
				ComCgmEnableObject(agmt_eff_dt, bEnable);
				ComCgmEnableObject(agmt_exp_dt, bEnable);
				ComCgmEnableObject(vndr_seq,	bEnable);
				
			}

			// 이미지 버튼 Enable
			ComCgmEnableObject(btns_Calendar_agmtDt,	bEnable);
			ComCgmEnableObject(btns_Calendar_effDt,	bEnable);
			ComCgmEnableObject(btns_Calendar_agmt_effDt,bEnable);
			ComCgmEnableObject(btns_Calendar_agmt_expDt,bEnable);
			ComCgmEnableObject(btns_agmtno, bEnable);
			ComCgmEnableObject(btns_vndr,	bEnable);
			ComCgmEnableObject(btns_curr_cd,bEnable);
			ComCgmEnableObject(pay_term_dys,bEnable);
			 
			// Option Button Enable
			ComCgmEnableObject(eq_rntl_tp_cd(0),	 bEnable);
			ComCgmEnableObject(eq_rntl_tp_cd(1),	 bEnable);
			ComCgmEnableObject(eq_rntl_tp_cd(2),	 bEnable);
			ComCgmEnableObject(dpp_tp_cd(0),		 bEnable);
			ComCgmEnableObject(dpp_tp_cd(1),		 bEnable);
			ComCgmEnableObject(drp_off_lmt_prd_cd(0),bEnable);
			ComCgmEnableObject(drp_off_lmt_prd_cd(1),bEnable);
			ComCgmEnableObject(drp_off_lmt_tp_cd(0), bEnable);
			ComCgmEnableObject(drp_off_lmt_tp_cd(1), bEnable);
			
			// 기타 Text Box
			ComCgmEnableObject(dpp_rt_amt,		bEnable);
			ComCgmEnableObject(dpp_cvrg_amt,	bEnable);
			ComCgmEnableObject(lmsm_amt,		bEnable);
			ComCgmEnableObject(onh_hndl_rt_amt, bEnable);
			ComCgmEnableObject(offh_hndl_rt_amt,bEnable);
			ComCgmEnableObject(drp_off_lmt_qty, bEnable);
			ComCgmEnableObject(drp_off_lmt_rto, bEnable);
			ComCgmEnableObject(mon_dpc_rt_amt,	bEnable);
			ComCgmEnableObject(max_dpc_rt_amt,	bEnable);
			ComCgmEnableObject(init_dpc_rt_amt, bEnable);
			   
			if(bEnable){
				 ComCgmEnableObject(diff_rmk, bEnable);
			} else {
				 ComCgmEnableObject(diff_rmk, bEnable);
			}
			 
			// MultiCombo Enable
			comboObjects[1].Enable = bEnable;
			comboObjects[2].Enable = bEnable;
			 
			// IBSheet Enable
			for(var i = 0; i < sheetObjects.length; i++){
				sheetObjects[i].Enable = bEnable;
			}
		}
	}
	  
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		 
		switch(sheetID) {
			
			case "t3sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height =120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
						
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
	
					 var HeadTitle = "Type/Size||SF2|SL2|TA2|SF4|GN4|GN5|CB4|EG5|EG8|ZT4";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 1, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					 
					InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "title", false, "", dfNone,	  0, true, true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sf2",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sl2",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_ta2",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sf4",	  false, "", dfFloat, 2, true, true);			
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_gn4",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_gn5",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_cb4",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_eg5",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_eg8",	  false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_zt4",	  false, "", dfFloat, 2, true, true);
	
					InitHeadColumn("title","Fixed Rate");
					
					CountPosition = 0;
				}
			   
				break;
	
		   case "t3sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height =120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
	
					var HeadTitle = "||Number of Units|Number of Units|Number of Units|Number of Units|SF2|SL2|TA2|SF4|GN4|GN5|CB4|EG5|EG8|ZT4";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox, 30, daCenter,	true, "del_chk", false,	"", dfNone,	0, true,  true);
					
					InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_fm_title",  false, "", dfNone,		  0, true, false);
					InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_fm_tr_val", false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_to_title",	false, "", dfNone,		  0, true, false);
					InitDataProperty(0, cnt++ , dtData, 50, daCenter, false, "rntl_to_tr_val", false, "", dfNullInteger, 0, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sf2", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sl2", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_ta2", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_sf4", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_gn4", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_gn5", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_cb4", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_eg5", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_eg8", false, "", dfFloat,   2, true, true);
					InitDataProperty(0, cnt++ , dtData, 85, daCenter, false, "eq_tpsz_cd_zt4", false, "", dfFloat,   2, true, true);
	
					CountPosition = 0;
				}
				
				break;
				
		   case "t3sheet3":
				with (sheetObj) {
	
					// 높이 설정
					style.height =120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
	
					var HeadTitle = "||Used Days|Used Days|Used Days|Used Days|SF2|SL2|TA2|SF4|GN4|CB4|GN5|EG5|EG8|ZT4";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox, 30, daCenter,	true, "del_chk", false,	"", dfNone,	0, true,  true);
					
					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_fm_title",  false, "", dfNone,	 	0, true, false);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_fm_tr_val", false, "", dfNullInteger,0, true, true);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_to_title",  false, "", dfNone,	 	0, true, false);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rntl_to_tr_val", false, "", dfNullInteger,0, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sf2", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sl2", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_ta2", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_sf4", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_gn4", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_gn5", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_cb4", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_eg5", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_eg8", false, "", dfFloat,	2, true, true);
					InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "eq_tpsz_cd_zt4", false, "", dfFloat,	2, true, true);
	
					CountPosition = 0;
					 
				}
				
				break;
			
			case "t1sheet1":
				 with (sheetObj) {

					 // 높이 설정
					 style.height = 42;
					 //전체 너비 설정
					 SheetWidth = mainTable.clientWidth;

					 //Host정보 설정[필수][HostIp, Port, PagePath]
					 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					 //전체Merge 종류 [선택, Default msNone]
					 MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					 Editable = true;

					 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					 InitRowInfo( 1, 1, 1, 100);

					 var HeadTitle = "T/S||SF2|SL2|TA2|SF4|GN4|GN5|CB4|EG5|EG8|ZT4";
					 var headCount = ComCountHeadTitle(HeadTitle);

					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 1, true);

					 // 해더에서 처리할 수 있는 각종 기능을 설정한다
					 InitHeadMode(true, true, false, true, false,false);

					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					 InitHeadRow(0, HeadTitle, true);

					 //데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "title", false, "", dfNone,	  0, true, true);
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sf2", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sl2", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_ta2", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_sf4", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_gn4", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_gn5", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_cb4", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_eg5", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_eg8", false, "", dfFloat, 2, true, true);
					 InitDataProperty(0, cnt++, dtData,  85, daCenter, false, "eq_tpsz_cd_zt4", false, "", dfFloat, 2, true, true);
					 
					 InitHeadColumn("title","Initial Value");

					 CountPosition = 0;
					 
				}
				 break;			
			
			case "t2sheet1":
				 with (sheetObj) {
					 // 높이 설정
					 style.height = 102;
					 //전체 너비 설정
					 SheetWidth = mainTable.clientWidth;

					 //Host정보 설정[필수][HostIp, Port, PagePath]
					 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					 //전체Merge 종류 [선택, Default msNone]
					 MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					 Editable = true;

					 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					 InitRowInfo(1, 1, 1, 100);

					 var HeadTitle1 = "||Seq.|Registered State|Surcharge Rate";
					 var headCount = ComCountHeadTitle(HeadTitle1);

					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 0, true);

					 // 해더에서 처리할 수 있는 각종 기능을 설정한다
					 InitHeadMode(true, true, true, true, false,false)

					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					 InitHeadRow(0, HeadTitle1, true);

					 //데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					 InitDataProperty(0, cnt++ , dtCheckBox, 30, daCenter,	true, "del_chk", false,	"", dfNone,	0, true,  true);
					 InitDataProperty(0, cnt++ , dtDataSeq,  50, daCenter,  true, "seq");
					 InitDataProperty(0, cnt++ , dtCombo,   250, daCenter,  true, "ste_cd", false, "", dfNone, 0, true, true);
					 InitDataProperty(0, cnt++ , dtData,	100, daRight,   false, "rgst_scg_rt_amt", false, "", dfNullFloat, 2, true, true);
										
					 CountPosition = 0;
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

	/**
	 * Sheet관련 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:	  //조회
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObjects[5].GetSearchXml("EES_CGM_1020GS.do" , FormQueryString(formObj), '', true);
				var arrXml = sXml.split("|$$|");
				ComOpenWait(false);
				// Sheet Object Clear
				for(var k=0; k < sheetObjects.length; k++){
					sheetObjects[k].RemoveAll();
				}
				// Sheet Object 값 설정
		 		for(var i = 0; i < 10; i++ ){
		 			sheetObjects[0].cellValue2(1,i+2) = 0;
		 			sheetObjects[3].cellValue2(1,i+2) = 0;
		 		}
		 		
				// Depr. For Casualty Value Tab Sheet Object 값 설정
				sheetObjects[3].LoadSearchXml(arrXml[0]);
				
				// ETC DATA 값을  FORM OBJECT 에 세팅
				setEtcDataToForm(formObj, sheetObjects[3]);
				
				// 전체 데이터 건수를 가져온다.
				var dataCount = ComGetTotalRows(arrXml[0]);
				
				if(dataCount != null && dataCount > 0){

					// Rental Rate Tab 안의  sheet 상태 설정 (display 설정)
					setTab3SheetEnable(formObj);
					
					// Rental Rate Tab 안의  Sheet Object 값 설정
					if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'F'){	
						sheetObjects[0].LoadSearchXml(arrXml[2]);
					} else if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'U'){
						sheetObjects[1].LoadSearchXml(arrXml[2]) ;		
					} else if(sheetObjects[3].EtcData("eq_rntl_tp_cd") == 'D'){
						sheetObjects[2].LoadSearchXml(arrXml[2]);
					}
					
					// Surchage Tab Sheet Object 값 설정
					sheetObjects[4].LoadSearchXml(arrXml[1]);	
					
					// Agreement Version MultiCombo 설정
					var comboItemCnt = comboObjects[0].getCount();
					
					var cols = ComCgmXml2ComboString(arrXml[3], "agmt_ver_no", "agmt_ver_no");
					ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
					comboObjects[0].Text2 = ComCgmNullToBlank(sheetObjects[3].EtcData("agmt_ver_no"));
					
					return true;
				 	
				} else {
					
					return false;
				}
				
				break;
				
			case IBSAVE:	 // 저장
			
				formObj.f_cmd.value = MULTI;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString(true); 
				var sParam2 = sheetObjects[1].GetSaveString(true); 
				var sParam3 = sheetObjects[2].GetSaveString(true); 
				var sParam4 = sheetObjects[3].GetSaveString(true); 
				var sParam5 = sheetObjects[4].GetSaveString(true); 

				sParam1 = ComSetPrifix(sParam1, "t3sheet1_");
				sParam2 = ComSetPrifix(sParam2, "t3sheet2_");
				sParam3 = ComSetPrifix(sParam3, "t3sheet3_");
				sParam4 = ComSetPrifix(sParam4, "t1sheet1_");
				sParam5 = ComSetPrifix(sParam5, "t2sheet1_");

				sParam = sParam + sParam1 + "&";
				sParam = sParam + sParam2 + "&";
				sParam = sParam + sParam3 + "&";
				sParam = sParam + sParam4 + "&";
				sParam = sParam + sParam5 + "&";

				sParam = sParam + FormQueryString(formObj);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1020GS.do", sParam);
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
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("EES_CGM_1020GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
			
			
			case IBSEARCH_ASYNC01:	// Term Code MultiCombo 조회
			
				formObj.f_cmd.value = SEARCH;
				formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
									
				var sStr = ComGetEtcData(sXml,"comboList");				
				var arrStr = sStr.split("@");
					
				// combo control, 결과 문자열, Text Index, Code Index
				MakeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0);
				break;
			
			case IBSEARCH_ASYNC02:	// pool List MultiCombo 조회
			
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
								
				var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
			 	ComCgmMakeMultiCombo(comboObjects[2], cols[0], cols[1], 1);
					
				break;		
					
			case IBSEARCH_ASYNC03:	// IBCombo 설정
				formObj.f_cmd.value = SEARCH08;
			 	var xml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
			 	var cols = ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");

			 	sheetObj.InitDataCombo(0, "ste_cd", cols[1], cols[0]);	// IBSheet내 Combo 초기화
			 	
				break;
				
			case IBSEARCH_ASYNC04:	// Vendor Code,Name 조회
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var text = ComCgmNullToBlank(ComGetEtcData(sXml,"text"));
				var payCurrCd = ComCgmNullToBlank(ComGetEtcData(sXml,"pay_curr_cd"));
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
				formObj.curr_cd.value = payCurrCd;
				formObj.pay_term_dys.value = genPayTermCd;
				break;	
				
			case IBSEARCH_ASYNC05:	// Oragnization 정보 조회
				formObj.f_cmd.value = SEARCH09;
				var sXml = sheetObj.getSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);

				formObj.curr_cd.value = ComCgmNullToBlank(ComGetEtcData(sXml, "ar_curr_cd"));	// Currency 
				currCd = ComCgmNullToBlank(ComGetEtcData(sXml, "ar_curr_cd"));		// 전역변수에  Currency 저장
				
				break;
				
			case IBINSERT:   // 행추가

				if(sheetObj.id == 't3sheet2' || sheetObj.id == 't3sheet3'){
 
					var findRow = sheetObj.FindText("rntl_fm_title", "Over") 
					var rowCount = sheetObj.RowCount - sheetObj.RowCount("D");
					var newRow;
					
					if(findRow == -1 || rowCount == 0){
						newRow =  sheetObj.DataInsert();
						sheetObj.CellValue2(newRow, "rntl_fm_title") = "From";
						sheetObj.CellValue2(newRow, "rntl_to_title") = "To";
						
						newRow =  sheetObj.DataInsert();
						sheetObj.CellValue2(newRow, "rntl_fm_title") = "Over";
						sheetObj.CellValue2(newRow, "rntl_to_title") = "To";
						sheetObj.CellValue2(newRow, "rntl_to_tr_val") = "999999";
						sheetObj.CellEditable(newRow, "rntl_to_tr_val") = false;	 
					
					} else {
						//sheetObj.SelectRow = findRow - 1;
						newRow =  sheetObj.DataInsert(findRow - 1);
						sheetObj.CellValue2(newRow, "rntl_fm_title") = "From";
						sheetObj.CellValue2(newRow, "rntl_to_title") = "To";
						
					}
					
				} else if(sheetObj.id == 't2sheet1'){
					var newRow = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(newRow, "ste_cd") = "";
					
				}	
				break;
			
			case IBRESET:	 // 행삭제
				if(sheetObj.id == 't3sheet2' || sheetObj.id == 't3sheet3'){
					var sRow = sheetObj.FindCheckedRow("del_chk");
					var arrRow = sRow.split("|");
									
					for(var i=arrRow.length-2; i>=0; i--){
						var cellText = sheetObj.cellValue(arrRow[i], "rntl_fm_title");
						if(cellText != "Over"){
							sheetObj.CellValue2(arrRow[i], "del_chk")= 0;
							sheetObj.RowHidden(arrRow[i])= true;
							sheetObj.RowStatus(arrRow[i])= "D";
						}
					}
					
				} else {
					ComRowHideDelete(sheetObj, "del_chk");
				}
				break;
			 case IBCLEAR:
				var idx = 0
				var sXml2 = document.form2.sXml.value;
				var arrXml = sXml2.split("|$$|");
		   
				formObj.curr_cd.value = ComGetEtcData(arrXml[0], "ar_curr_cd");	// ComCgmNullToBlank(ComGetEtcData(arrXml[idx], "ar_curr_cd"));	// Currency 
	 			currCd = ComCgmNullToBlank(ComGetEtcData(arrXml[0], "ar_curr_cd"));	
//				ALERT
//				//agmt_lstm_cd
				if ( arrXml[idx] == null ) {return;}
				var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
				var arrStr1 = new Array();
//				for ( var i = 0; i < vArrayListData.length - 1; i++) {
				for ( var i = 0; i < vArrayListData.length; i++) {
					vListData = vArrayListData[i];
				   //2014-02-24 Jonghee HAN Lease Agreement Term Code 내 ZP Code 삭제
					if(vListData["code1"] != "ZP"){
						arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
					}
				}
				// combo control, 결과 문자열, Text Index, Code Index
			 	MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);	 
				idx++;	   
		 
				if ( arrXml[idx] == null ) {return;}
				var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
				var arrStr1 = new Array();
				var arrStr2 = new Array();
				for ( var i = 0; i < vArrayListData.length; i++) {
					vListData = vArrayListData[i];
					arrStr1[i] = vListData["code1"];
					arrStr2[i] = vListData["desc1"];
				}
				// combo control, 결과 문자열, Text Index, Code Index
			 	//MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0); 
			 	MakeComboObject4(comboObjects[2], arrStr1, arrStr2);
				idx++;	   
				
				if ( arrXml[idx] == null ) {return;}
			 	var cols = ComCgmXml2ComboString(arrXml[idx], "code1", "code1|desc1", "\t");

			 	sheetObj.InitDataCombo(0, "ste_cd", cols[1], cols[0]);	// IBSheet내 Combo 초기화
				idx++;	   
  
				break;
		}
	}
	 
	function MakeComboObject4(cmbObj, arrStr, arrStr2) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0,"","");
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i, arrStr[i-1], arrStr2[i-1]);
		}
		cmbObj.Index2 = "" ;
	}
	 
	/**
	 * Tab3 안의 Sheet 의 활성/비활성을 설정한다. <br>
	 * @param  {object} formObj	필수
	 * @param  {boolean} bEnable	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */ 
	function setTab3SheetEnable(formObj){
		 
		var objsheets1 = document.getElementById("t3sheetLayer1");
		var objsheets2 = document.getElementById("t3sheetLayer2");
		var objsheets3 = document.getElementById("t3sheetLayer3");
 		var objButton = document.getElementById("t3ButtonLayer");
 		
		with(formObj){
			if(eq_rntl_tp_cd(0).checked){
				objsheets1.style.display = 'Inline';
				objsheets2.style.display = 'none';
				objsheets3.style.display = 'none';
	 			objButton.style.display = "none";
	 			
			} else if (eq_rntl_tp_cd(1).checked){	
				objsheets1.style.display = 'none';
				objsheets2.style.display = 'Inline';
				objsheets3.style.display = 'none';
	 			objButton.style.display = "Inline";
			
			} else if (eq_rntl_tp_cd(2).checked){
				objsheets1.style.display = 'none';
				objsheets2.style.display = 'none';
				objsheets3.style.display = 'Inline';
	 			objButton.style.display = "Inline";
			}
		}
	} 
 
	/**
	 * Option 버튼의 설정에 따른 동작을 정의한다. <br>
	 * @param  {object} formObj	필수
	 * @param  {string} srcName	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function doOptionBtnAction(formObj, srcName){
		with(formObj){
			switch(srcName){
				case "dpp_tp_cd":
					if(dpp_tp_cd(0).checked){
						dpp_rt_amt.readOnly	  = false;
						dpp_cvrg_amt.readOnly = false;
						lmsm_amt.readOnly	  = true;
						lmsm_amt.value = "0";	
						
						dpp_rt_amt.className = "input";
						dpp_cvrg_amt.className = "input";
						lmsm_amt.className = "input2";
						
					} else if(dpp_tp_cd(1).checked){
						dpp_rt_amt.readOnly	  = true;
						dpp_cvrg_amt.readOnly = true;
						lmsm_amt.readOnly	  = false;
						dpp_rt_amt.value = "0";
						dpp_cvrg_amt.value = "0";
						
						dpp_rt_amt.className = "input2";
						dpp_cvrg_amt.className = "input2";
						lmsm_amt.className = "input";
					}
					
					break;
					
				case "drp_off_lmt_tp_cd":
					
					var qtyLayer = document.getElementById("qtyLayer");
					var rtoLayer = document.getElementById("rtoLayer");
					
					if(drp_off_lmt_tp_cd(0).checked){
						qtyLayer.style.display = "block";
						rtoLayer.style.display = "none";
						drp_off_lmt_rto.value = "0";
					} else if(drp_off_lmt_tp_cd(1).checked){
						qtyLayer.style.display = "none";
						rtoLayer.style.display = "block";
						drp_off_lmt_qty.value = "0";
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
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function setEtcDataToForm(formObj, sheetObj){
		formObj.eq_knd_cd.value		= ComCgmNullToBlank(sheetObj.EtcData("eq_knd_cd"));
		formObj.agmt_ofc_cty_cd.value	= ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
 		formObj.agmt_seq.value			= ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
 		formObj.lst_ver_flg.value		= ComCgmNullToBlank(sheetObj.EtcData("lst_ver_flg"));
 		
 		formObj.agmt_no.value			= ComCgmNullToBlank(sheetObj.EtcData("agmt_no"));
 		formObj.agmt_ref_no.value		= ComCgmNullToBlank(sheetObj.EtcData("agmt_ref_no"));
 		formObj.curr_cd.value			= ComCgmNullToBlank(sheetObj.EtcData("curr_cd"));
 		formObj.agmt_dt.value			= ComCgmNullToBlank(sheetObj.EtcData("agmt_dt"));
 		formObj.agmt_iss_ofc_cd.value	= ComCgmNullToBlank(sheetObj.EtcData("agmt_iss_ofc_cd"));
 		formObj.gw_uq_doc_tit_nm.value	= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_tit_nm"));
 		formObj.gw_uq_doc_no.value		= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_no"));
 		formObj.eff_dt.value			= ComCgmNullToBlank(sheetObj.EtcData("eff_dt"));
 		formObj.exp_dt.value			= ComCgmNullToBlank(sheetObj.EtcData("exp_dt"));
 		formObj.agmt_eff_dt.value		= ComCgmNullToBlank(sheetObj.EtcData("agmt_eff_dt"));
 		formObj.agmt_exp_dt.value		= ComCgmNullToBlank(sheetObj.EtcData("agmt_exp_dt"));
 		formObj.vndr_seq.value			= ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
 		formObj.vndr_lgl_eng_nm.value	= ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
 		formObj.dpp_rt_amt.value		= ComCgmNullToZero(sheetObj.EtcData("dpp_rt_amt"));
 		formObj.dpp_cvrg_amt.value		= ComCgmNullToZero(sheetObj.EtcData("dpp_cvrg_amt"));
 		formObj.lmsm_amt.value			= ComCgmNullToZero(sheetObj.EtcData("lmsm_amt"));
 		formObj.onh_hndl_rt_amt.value	= ComCgmNullToZero(sheetObj.EtcData("onh_hndl_rt_amt"));
 		formObj.offh_hndl_rt_amt.value	= ComCgmNullToZero(sheetObj.EtcData("offh_hndl_rt_amt"));
 		formObj.pay_term_dys.value		= ComCgmNullToBlank(sheetObj.EtcData("pay_term_dys"));
 		formObj.drp_off_lmt_qty.value	= ComCgmNullToZero(sheetObj.EtcData("drp_off_lmt_qty"));
 		formObj.drp_off_lmt_rto.value	= ComCgmNullToZero(sheetObj.EtcData("drp_off_lmt_rto"));
 		formObj.mon_dpc_rt_amt.value	= ComCgmNullToZero(sheetObj.EtcData("mon_dpc_rt_amt"));
 		formObj.max_dpc_rt_amt.value	= ComCgmNullToZero(sheetObj.EtcData("max_dpc_rt_amt"));
 		formObj.init_dpc_rt_amt.value	= ComCgmNullToZero(sheetObj.EtcData("init_dpc_rt_amt"));
 		formObj.diff_rmk.value			= ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
 		
 		comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
 		comboObjects[1].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_lstm_cd"));
 		comboObjects[2].Text2 = ComCgmNullToBlank(sheetObj.EtcData("chss_pool_cd"));
 		
 		if(sheetObj.EtcData("eq_rntl_tp_cd") == 'F'){
 			formObj.eq_rntl_tp_cd[0].checked = true;
 		} else if(sheetObj.EtcData("eq_rntl_tp_cd") == 'U'){
 			formObj.eq_rntl_tp_cd[1].checked = true;
 		} else if(sheetObj.EtcData("eq_rntl_tp_cd") == 'D'){
 			formObj.eq_rntl_tp_cd[2].checked = true;
 		}
 		
		if(sheetObj.EtcData("dpp_tp_cd") == 'G'){
			formObj.dpp_tp_cd(0).checked = true;
 		} else if(sheetObj.EtcData("dpp_tp_cd") == 'L'){
 			formObj.dpp_tp_cd(1).checked = true;
 		}	
 		
 		if(sheetObj.EtcData("drp_off_lmt_prd_cd") == 'M'){
 			formObj.drp_off_lmt_prd_cd(0).checked = true;
 		} else if(sheetObj.EtcData("drp_off_lmt_prd_cd") == 'Y'){
 			formObj.drp_off_lmt_prd_cd(1).checked = true;
 		}	
 		
 		if(sheetObj.EtcData("drp_off_lmt_tp_cd") == 'F'){
 			formObj.drp_off_lmt_tp_cd(0).checked = true;
 		} else if(sheetObj.EtcData("drp_off_lmt_tp_cd") == 'R'){
 			formObj.drp_off_lmt_tp_cd(1).checked = true;
 		}
 		
 		var element = document.getElementById("poolLayer");
 		if(comboObjects[1].Text == "CP"){
 			element.style.visibility = "visible";
 		} else {
 			element.style.visibility = "hidden";
 		}
 		
 		doOptionBtnAction(formObj,"drp_off_lmt_tp_cd");
		 
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
					InsertTab( cnt++ , "Depr. For Casualty Value" , -1 );
					InsertTab( cnt++ , "Surcharge" , -1 );
					InsertTab( cnt++ , "Remark(s)" , -1 );
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
	 * Combo Object 초기화  <br>
	 * @param  {object} comboObj	필수 Combo Object
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.25
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
 			
			case "agmt_lstm_cd":
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
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
	 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
	 * @author 김창식
	 * @version 2009.05.28
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
					var combo_agmt_lstm_cd = comboObjects[1];
					var combo_chss_pool_cd = comboObjects[2];
					var sheet;
					
					// Form 입력 체크
					if(agmt_ref_no.value == ''){
						ComShowCodeMessage('CGM10004','Ref. No.');
						agmt_ref_no.focus();
						return false;
					} else if(agmt_dt.value == ''){
						ComShowCodeMessage('CGM10004','Agreement Date');
						agmt_dt.focus();
						return false;
					} else if(agmt_eff_dt.value == ''){
						ComShowCodeMessage('CGM10004','Agreement Eff. From Date');
						agmt_eff_dt.focus();
						return false;
					} else if(agmt_exp_dt.value == ''){
						ComShowCodeMessage('CGM10004','Agreement Eff. To Date');
						agmt_exp_dt.focus();
						return false;	
					} else if(eff_dt.value == ''){
						ComShowCodeMessage('CGM10004','Rate Eff. From Date');
						eff_dt.focus();
						return false;
					} else if(exp_dt.value == ''){
						ComShowCodeMessage('CGM10004','Rate Eff. To Date');
						exp_dt.focus();
						return false;
					} else if(vndr_seq.value == ''){
						ComShowCodeMessage('CGM10004','Lessor');
						
						vndr_seq.focus();
						return false;
					} else if(combo_agmt_lstm_cd.Text == ''){
						ComShowCodeMessage('CGM10004','Lease Term');
						agmt_lstm_cd.focus();
						return false;
					} else if(combo_agmt_lstm_cd.Text == 'CP' && combo_chss_pool_cd.Text == ''){
						ComShowCodeMessage('CGM10004','Pool');
						chss_pool_cd.focus();
						return false;
					} else if(pay_term_dys.value == ''){
						ComShowCodeMessage('CGM10004','Payment Term');
						pay_term_dys.focus();
						return false;
					} 
					
					// 신규 입력일 경우  eff_dt 와 agmt_eff_dt 가 같은지 체크한다.
					var effDt = ComReplaceStr(eff_dt.value,"-","");
					var expDt = ComReplaceStr(exp_dt.value,"-","");
					var agmtEffDt = ComReplaceStr(agmt_eff_dt.value,"-","");
					var agmtExpDt = ComReplaceStr(agmt_exp_dt.value,"-","");
					
					if(agmt_no.value == 'NEW'){
						if(effDt != agmtEffDt){
							ComShowCodeMessage('CGM10074');
							eff_dt.focus();
							return false
						}
					}
							
					// Rental Rate 가 Fixed 일 경우 입력체크
					if(eq_rntl_tp_cd(0).checked){
						var strRate = "";
						for(var i = 0; i < 10; i++){
							strRate = strRate + sheet.cellValue(1, i+2);
						}
							
						if(strRate == ''){
							ComShowCodeMessage('CGM10004','Fixed Rate');
							tabObjects[0].SelectedIndex = 0; 
							sheetObjects[0].focus();
							sheetObjects[0].SelectCell(1, "eq_tpsz_cd_sf2", true);
							return false;
						}
				
					// Rental Rate 가  Tier Rate(Unit/Day) 일 경우일 경우 입력체크
					} else if(eq_rntl_tp_cd(1).checked){						
						if(sheetObjects[1].RowCount == 0){
							ComShowCodeMessage('CGM10004','Tier Rate');
							tabObjects[0].SelectedIndex = 0; 
							return false;
						} else {
							for(var i = 1; i <= sheetObjects[1].RowCount; i++){
								if(sheetObjects[1].cellValue(i, "rntl_fm_tr_val") == ''){
									ComShowCodeMessage('CGM10004','Tier Rate');
									tabObjects[0].SelectedIndex = 0; 
									sheetObjects[1].focus();
									sheetObjects[1].SelectCell(i, "rntl_fm_tr_val", true);
									return false;
										
								} else if(sheetObjects[1].cellValue(i, "rntl_to_tr_val") == ''){
									if(sheetObjects[1].cellValue(i, "rntl_fm_title") != 'Over'){
										ComShowCodeMessage('CGM10004','Tier Rate');
										tabObjects[0].SelectedIndex = 0; 
										sheetObjects[1].focus();
										sheetObjects[1].SelectCell(i, "rntl_to_tr_val", true);
										return false;
									}
								}
							}	
						 
						}
						
						// from, to 가 공백이 아닐 경우  to 값과 다음 from 값을 비교한다.
						if(sheetObjects[1].RowCount > 1){
							for(var k = 1; k <= sheetObjects[1].RowCount - 1; k++){
								if(sheetObjects[1].cellValue(k, "rntl_to_tr_val") != sheetObjects[1].cellValue(k+1, "rntl_fm_tr_val")-1){
									ComShowCodeMessage('CGM10009','From Number');
									tabObjects[0].SelectedIndex = 0; 
									sheetObjects[1].focus();
									sheetObjects[1].SelectCell(k+1, "rntl_fm_tr_val", true);
									return false;
								}
							}
						}
						
					// Rental Rate 가  Tier Rate (Used Days)일 경우일 경우 입력체크	
					} else if(eq_rntl_tp_cd(2).checked){		
						
						if(sheetObjects[2].RowCount == 0){
							ComShowCodeMessage('CGM10004','Tier Rate');
							tabObjects[0].SelectedIndex = 0; 
							return false;
						} else {
						
							for(var i = 1; i <= sheetObjects[2].RowCount; i++){
								if(sheetObjects[2].cellValue(i, "rntl_fm_tr_val") == ''){
									ComShowCodeMessage('CGM10004','Tier Rate');
									tabObjects[0].SelectedIndex = 0; 
									sheetObjects[2].focus();
									sheetObjects[2].SelectCell(i, "rntl_fm_tr_val", true);
									return false;
										
								} else if(sheetObjects[2].cellValue(i, "rntl_to_tr_val") == ''){
									if(sheetObjects[2].cellValue(i, "rntl_fm_title") != 'Over'){
										ComShowCodeMessage('CGM10004','Tier Rate');
										tabObjects[0].SelectedIndex = 0; 
										sheetObjects[2].focus();
										sheetObjects[2].SelectCell(i, "rntl_to_tr_val", true);
										return false;
									}
								}
							}	
						 
						}
						
						// from, to 가 공백이 아닐 경우  to 값과 다음 from 값을 비교한다.
						if(sheetObjects[1].RowCount > 1){
							for(var k = 1; k <= sheetObjects[1].RowCount - 1; k++){
								if(sheetObjects[1].cellValue(k, "rntl_to_tr_val") != sheetObjects[1].cellValue(k+1, "rntl_fm_tr_val") - 1){
									ComShowCodeMessage('CGM10009','From Number');
									tabObjects[0].SelectedIndex = 0; 
									sheetObjects[1].focus();
									sheetObjects[1].SelectCell(k+1, "rntl_fm_tr_val", true);
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
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.20
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
	 * @author 김창식
	 * @version 2009.06.19
	 */ 
	function obj_keydown(){
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
	 * @author 김창식
	 * @version 2009.05.20
	 */
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}
	  
	/** 
	 * Object 의 deactivate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.20
	 */
	function obj_deactivate(){
		var formObj = document.form;
		obj = event.srcElement;	 	
		 
		with(formObj){
			if(obj.name=='agmt_dt' || obj.name=="eff_dt" || obj.name=="exp_dt" || obj.name=="agmt_eff_dt" || obj.name=="agmt_exp_dt"){
				var effDt = ComReplaceStr(eff_dt.value,"-","");
				var expDt = ComReplaceStr(exp_dt.value,"-","");
				var preEffDt = ComReplaceStr(pre_eff_dt.value,"-","");
				var preExpDt = ComReplaceStr(pre_exp_dt.value,"-","");
				var agmtEffDt = ComReplaceStr(agmt_eff_dt.value,"-","");
				var agmtExpDt = ComReplaceStr(agmt_exp_dt.value,"-","");
				var preAgmtExpDt = ComReplaceStr(pre_agmt_exp_dt.value,"-","");
			
				switch(obj.name) {
					case "eff_dt":	// Agreement From Date
						if(effDt != '' && expDt != ''){
							if(effDt > expDt){
								ComShowCodeMessage('COM12133','To date','From date','greater');
								eff_dt.value='';
								eff_dt.focus();
								break;
							}
						}
					
						if(effDt != "" && preExpDt != ""){
							var nextEffDt = ComReplaceStr(ComGetDateAdd(pre_exp_dt.value,"D",""),"-","");
							
							if(effDt <= preExpDt && effDt <= preEffDt){
								ComShowCodeMessage('COM12133','From date', pre_eff_dt.value,'greater');
								eff_dt.value='';
								eff_dt.focus();
							} else if(effDt > nextEffDt){
								ComShowCodeMessage('CGM10032');
								eff_dt.value = nextEffDt;
								exp_dt.focus();
							}
						}
							
						break;
						
					case "exp_dt":	// Agreement To Date
						if(effDt != '' && expDt != ''){
							if(effDt > expDt){
								ComShowCodeMessage('COM12133','To date','From date','greater');
								exp_dt.value='';
								exp_dt.focus();
								break;
							}
						}
						
						break;	
						
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
						
						if(agmt_exp_dt.value != ''){
							exp_dt.value = agmt_exp_dt.value.substring(0,4) + '-' + agmt_exp_dt.value.substring(4,6) + '-' + agmt_exp_dt.value.substring(6,8);
						} else {
							exp_dt.value = '';
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
	 * @author 김창식
	 * @version 2009.06.03
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
		 
			case "vndr_seq":
				var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
				
				if(vndrSeq != ''){
					// Lessor 명칭 가져오기
					doActionIBSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC04);
				} else {
					// vndr_seq 입력 텍스트에서 삭제할 경우 Lessor 명칭을 삭제
					formObj.vndr_lgl_eng_nm.value = "";
					formObj.pay_term_dys.value = "";
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
	 * Lease Term 의 Change 이벤트를 정의한다. <br>
	 * @param  {int} Index_Code	 필수
	 * @param  {string} Text 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function agmt_lstm_cd_OnChange(Index_Code, Text){
		 
		var element = document.getElementById("poolLayer");
		 
		comboObjects[2].Text2 = "";
		if(Text=='CP'){
			element.style.visibility = "visible";
		} else {
			element.style.visibility = "hidden";
		}
	}
	
	/**
	 * Tab3 의 2번째 Sheet 의 검색완료 후의 이벤트를 정의한다. <br>
	 * @param  {string} ErrMsg 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function t3sheet2_OnSearchEnd(sheetObj, ErrMsg){
		 
		for(var i = 1; i<= sheetObj.RowCount; i++){
			if(i < sheetObj.RowCount){
				sheetObj.CellValue2(i, "rntl_fm_title") = "From";
				sheetObj.CellValue2(i, "rntl_to_title") = "To";
			} else {
				sheetObj.CellValue2(i, "rntl_fm_title") = "Over";
				sheetObj.CellValue2(i, "rntl_to_title") = "To";
				sheetObj.CellEditable(i, "rntl_to_tr_val") = false;	 
			}
			 
			sheetObj.CellEditable(i, "rntl_fm_title") = false; 
			sheetObj.CellEditable(i, "rntl_to_title") = false;	 
		}
		
	}
	
	/**
	 * Tab3 의 3번째 Sheet 의 검색완료 후의 이벤트를 정의한다. <br>
	 * @param  {string} ErrMsg 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function t3sheet3_OnSearchEnd(sheetObj, ErrMsg){
		
		for(var i = 1; i<= sheetObj.RowCount; i++){
			if(i < sheetObj.RowCount){
				sheetObj.CellValue2(i, "rntl_fm_title") = "From";
				sheetObj.CellValue2(i, "rntl_to_title") = "To";
			} else {
				sheetObj.CellValue2(i, "rntl_fm_title") = "Over";
				sheetObj.CellValue2(i, "rntl_to_title") = "To";
				sheetObj.CellEditable(i, "rntl_to_tr_val") = false;	 
			}
			 
			sheetObj.CellEditable(i, "rntl_fm_title") = false; 
			sheetObj.CellEditable(i, "rntl_to_title") = false;
		}
		
	}
	
	/**
	 * Tab2 의 1번째 Sheet 의 Change 이벤트를 정의한다. <br>
	 * @param  {object} sheetObj 필수
	 * @param  {int}	Row 필수
	 * @param  {int}	Col 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function t2sheet1_OnChange(sheetObj, Row, Col){ 
		var targetCol = sheetObj.SaveNameCol("ste_cd");
		 
		if(Col == targetCol){
			var cellText = sheetObj.cellValue(Row, Col);
			if(cellText != ''){
				 
				var rtn = sheetObj.ColValueDup("ste_cd");
			 
				if(rtn != -1){
					ComShowCodeMessage('CGM10017','State Code');
					// 그리드에 포커스 이동
					sheetObj.cellValue2(Row, Col) = "";
					sheetObj.focus();
					sheetObj.SelectCell(Row, Col, true);
				}
			}
		}
	}
	
	/**
	 * Tab3 의 2번째 Sheet 의 Change 이벤트를 정의한다. <br>
	 * @param  {object} sheetObj 필수
	 * @param  {int}	Row 필수
	 * @param  {int}	Col 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function t3sheet2_OnChange(sheetObj, Row, Col){
		 
		var cellValue = sheetObj.cellValue(Row, Col);
		var colSaveName = sheetObj.ColSaveName(Col);
		
		var currRow = Row;
		var fmValue = sheetObj.cellValue(currRow, "rntl_fm_tr_val");
		var toValue = sheetObj.cellValue(currRow, "rntl_to_tr_val");
		 
		switch(colSaveName){
			case "rntl_fm_tr_val":
				
				var toValue = sheetObj.cellValue(currRow, "rntl_to_tr_val");
				
				if(Number(cellValue) >= 999999){
					ComShowCodeMessage('CGM10019','Number 999,999');
					// 그리드에 포커스 이동
					sheetObj.cellValue2(currRow, Col) = "";
					sheetObj.focus();
					sheetObj.SelectCell(currRow, Col, true);
					break;
				}
				
				if(fmValue != '' && toValue != ''){
					if(Number(fmValue) > Number(toValue)){
						ComShowCodeMessage('COM12133','To','From','greater');
						// 그리드에 포커스 이동
						sheetObj.cellValue2(currRow, Col) = "";
						sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
						break;
					}
				}
				
				if(currRow > 1) {
					// 이전 Row 의  To value 값
					var preToValue = sheetObj.cellValue(currRow-1, "rntl_to_tr_val");
					
					if(cellValue!=""){

						if(preToValue != "" && Number(cellValue) != Number(preToValue) + 1 ){
							ComShowCodeMessage('CGM10009','From Number');
							// 그리드에 포커스 이동
							sheetObj.cellValue2(currRow, Col) = "";
							sheetObj.focus();
							sheetObj.SelectCell(currRow, Col, true);
							break;	
						} 
					}
				}
				
				break;
				
			case "rntl_to_tr_val":
				
				if(Number(cellValue) >= 999999){
					ComShowCodeMessage('CGM10019','Number 999,999');
					// 그리드에 포커스 이동
					sheetObj.cellValue2(currRow, Col) = "";
					sheetObj.focus();
					sheetObj.SelectCell(currRow, Col, true);
					break;
				}
				
				if(fmValue != '' && toValue != ''){
					if(Number(fmValue) > Number(toValue)){
						ComShowCodeMessage('COM12133','To','From','greater');
						// 그리드에 포커스 이동
						sheetObj.cellValue2(currRow, Col) = "";
						sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
					}
				}
				break;
		}		 
	}
	
	/**
	 * Tab3 의 3번째 Sheet 의 Change 이벤트를 정의한다. <br>
	 * @param  {object} sheetObj 필수
	 * @param  {int}	Row 필수
	 * @param  {int}	Col 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function t3sheet3_OnChange(sheetObj, Row, Col){
		var cellValue = sheetObj.cellValue(Row, Col);
		var colSaveName = sheetObj.ColSaveName(Col);
		
		var currRow = Row;
		var fmValue = sheetObj.cellValue(currRow, "rntl_fm_tr_val");
		var toValue = sheetObj.cellValue(currRow, "rntl_to_tr_val");
		 
		switch(colSaveName){
			case "rntl_fm_tr_val":
				
				var toValue = sheetObj.cellValue(currRow, "rntl_to_tr_val");
				
				if(Number(cellValue) >= 999999){
					ComShowCodeMessage('CGM10019','Number 999,999');
					// 그리드에 포커스 이동
					sheetObj.cellValue2(currRow, Col) = "";
					sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
						break;
				}
				
				if(fmValue != '' && toValue != ''){
					if(Number(fmValue) > Number(toValue)){
						ComShowCodeMessage('COM12133','To','From','greater');
						// 그리드에 포커스 이동
						sheetObj.cellValue2(currRow, Col) = "";
						sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
					}
				}
				
				if(currRow > 1) {
					// 이전 Row 의  To value 값
					var preToValue = sheetObj.cellValue(currRow-1, "rntl_to_tr_val");
					
					if(cellValue!=""){

						if(preToValue != "" && Number(cellValue) != Number(preToValue) + 1 ){
							ComShowCodeMessage('CGM10009','From Number');
							// 그리드에 포커스 이동
							sheetObj.cellValue2(currRow, Col) = "";
							sheetObj.focus();
							sheetObj.SelectCell(currRow, Col, true);
							break;	
						} 
					}
				}
				
				break;
				
			case "rntl_to_tr_val":
				
				if(Number(cellValue) >= 999999){
					ComShowCodeMessage('CGM10019','Number 999,999');
					// 그리드에 포커스 이동
					sheetObj.cellValue2(currRow, Col) = "";
					sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
						break;
				}
				
				if(fmValue != '' && toValue != ''){
					if(Number(fmValue) > Number(toValue)){
						ComShowCodeMessage('COM12133','To','From','greater');
						// 그리드에 포커스 이동
						sheetObj.cellValue2(currRow, Col) = "";
						sheetObj.focus();
						sheetObj.SelectCell(currRow, Col, true);
					}
				}
				break;
		}		 
	}
	 
	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 (저장) <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.10.07
	 */ 
	function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObject = document.form;
		 
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			
			// 조회
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				
			// Form Control 활성/비활성 처리
			doControlEnable("btn_Retrieve");
				
			// 버튼 활성/비활성 처리
			doActionBtnEnable('R');
		}
	}
	 
	/**
 	 * Sheet2 의 OnSaveEnd 이벤트처리 (삭제) <br>
 	 * @param  {object} sheetObj	필수	 Sheet Object
 	 * @param  {string} ErrMsg		필수 String
 	 * @return 없음
 	 * @version 2009.10.07
 	 */ 
 	function t3sheet2_OnSaveEnd(sheetObj, errMsg) {
 		
 		var formObject = document.form;
 		
 		if(errMsg =='') {
 			
 			ComShowCodeMessage('CGM00003');
 			
 			if(comboObjects[0].GetCount() > 1){
				// 조회
				comboObjects[0].Text2 = "";
					
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
					
				// Form Control Enable 설정
				doControlEnable("btn_Retrieve");
					
				// 버튼 활성/비활성 처리
				doActionBtnEnable('R');
					
			} else {
				
				//Form Control 초기화
				initControl();
					
				// Form Control Enable 설정
				doControlEnable("btn_New");

				// 버튼 활성/비활성 처리
				doActionBtnEnable('L');
			}
		}
	}
	
	/**
	 * Agreement Version No 의 Change 이벤트를 정의한다. <br>
	 * @param  {string} Index_Code 필수
	 * @param  {string} Text 필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.06.09
	 */
	function agmt_ver_no_OnChange(Index_Code, Text){
		var obj = document.getElementById("btn_Retrieve");
		obj.fireEvent("onclick");
	}
	 
	 
	/** 
	 * Combo Object 에 값을 추가하는 처리 <br>
	 * @param  {object} cmbObj	필수 Combo Object
	 * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
	 * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
	 * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.20
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
	 * @author 조재성
	 * @version 2010.03.05
	 */	 
	function tRoleApply() {
		var formObj = document.form;
		
		if(formObj.trole.value == "Authenticated") {
			
		} else {
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_VersionUp");
			ComBtnDisable("btn_t2RowAdd");
			ComBtnDisable("btn_t2Delete");
			ComBtnDisable("btn_t3RowAdd");
			ComBtnDisable("btn_t3Delete");
			
			// 1020은 자체적으로 en/disable시키는 함수가 있다. 따라서 아래를 강제적으로 적용해주어야 함.
			var btnSave	  = document.getElementById("btn_Save");
			var btnDelete	= document.getElementById("btn_Delete");
			var btnVersionUp = document.getElementById("btn_VersionUp");
			btnSave.className = BTN_DISABLE;
			btnDelete.className = BTN_DISABLE;
			btnVersionUp.className = BTN_DISABLE;
		}
	}

	/* 개발자 작업  끝 */