/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1124.js
*@FileTitle : Neutral Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식 
* 1.0 Creation
* -------------------------------------------------------
* history
* [CHM-201433507] AGMT_VER_NO가 Fix되어 있는 문제 수정, 2014-12-31 by Chang Young Kim
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends 
	 * @class ees_cgm_1124 : ees_cgm_1124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cgm_1124() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject		= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
	}
	
	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var BTN_ENABLE = "btn1";
	var BTN_DISABLE = "btn1_1";
	
	var NO_DATA_FOUND = 0;
	var RETREIVE_SUCCESS = 1
	
	var COST_YRMON_OLD1 = null;	// 사용자가 입력창에 직접 입력할 경우의 old 값 저장
	var COST_YRMON_OLD2 = null;	// 달력창을 선택해서 입력할 경우의 old 값 저장
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * @param 없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
			 
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];	// Hidden Sheet
			 
		/*******************************************************/
		var formObject = document.form;
		
		var comboObjInv  = document.combo_inv.Text;
		var comboObjAgmt = document.combo_agmt.Text;
		var costYrmon	 = formObject.cost_yrmon.value;
		var costOfcCd	 = formObject.cost_ofc_cd.value;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
										
					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {	
												
						// 조회 Action
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
						
						// Form Enable 처리
						doFromControlEnable(true, 'input1');
						
						// 버튼 활성/비활성 처리
						doActionBtnEnable();
						
						document.form.actionflag.value = "SEARCH";
					}
					
					break;
		
				case "btn_New":
					// Control 초기화
					initControl(sheetObject1);
					
					document.form.actionflag.value = "NEW";
					
					break;
									
				case "btn_Save":
									
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
						
						formObject.actionflag.value = "SAVE";
							
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
			
					break;
									
				case "btn_Confirm":
						
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
							
						document.form.actionflag.value = "CONFIRM";
						// Confirm Action
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
						
					}
					
					break;
									
				case "btn_Delete":
					if(document.getElementById("btn_Delete").className != BTN_DISABLE){
						if (ComShowCodeConfirm("CGM00005","the Invoice")){ 
							document.form.actionflag.value = "DELETE";
						
							// 삭제 Action
							doActionIBSheet(sheetObject2, formObject, IBDELETE);
						}
					}
					break;
					
				case "btns_cost_yrmon":
					if(!formObject.cost_yrmon.readOnly){
						// onChange 이벤트를 내기 위해 현재 cost_yrmon 값을 전역변수에 저장
						COST_YRMON_OLD2 = document.form.cost_yrmon.value;
						
						var cal = new ComCalendar();
						cal.setEndFunction("processEndCal");	// Calendar 선택 후의 이벤트를 발생시키기 위해 (onChange Event 대용)
						cal.setDisplayType('month');
						cal.select(formObject.cost_yrmon, "yyyy-MM");
					}
					break;
					
//				case "btns_inv_dt":
//					if(!formObject.inv_dt.readOnly){
//						var cal = new ComCalendar();
//						cal.select(formObject.inv_dt, "yyyy-MM-dd");
//					}
//					break;
					
				case "btns_office":	// Office Code 가져오기 팝업
					if(!formObject.cost_ofc_cd.readOnly){
						ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
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
	
	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * @param  {object} sheetObj	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
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
	 * @version 2009.09.17
	 */
	function loadPage() {

		// axon event 등록
		axon_event.addListenerFormat('keyup', 'obj_keyup', form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('focusout', 'obj_focusout', 'cost_yrmon');
		axon_event.addListener('change', 'obj_change', 'cost_ofc_cd');
		
		for(i=0;i<sheetObjects.length;i++){
			
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			
			initSheet(sheetObjects[i],i+1);
			
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		
		}
		
		//IBMultiCombo초기화
		comboObjects[comboCnt++] = document.combo_inv;
		comboObjects[comboCnt++] = document.combo_agmt;
		
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
	 * @version 2009.09.17
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		sheetObj.WaitImageVisible = false;
		
//		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
		
		doActionIBSheet(sheetObjects[1], document.form, IBRESET);
		
		// sheet 초기화
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		
		// Form 초기화
		initControl(sheetObjects[0]);
		
		sheetObj.WaitImageVisible = true;
	}

	/**
	 * Form의 Conrol 를 초기화 시킨다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function initControl(sheetObj){
		
		var formObj = document.form;
		
		// 현재 날짜 가져오기
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth()+1;
		var date = today.getDate();
		
		var cost_yrmon = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0");
//		var inv_dt = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
		
		// 화면 input tag 초기화
		formObj.cost_yrmon.value = cost_yrmon;
//		formObj.inv_dt.value = inv_dt;
		formObj.vndr_seq.value = "";
		formObj.vndr_lgl_eng_nm.value = "";
		formObj.cost_ofc_cd.value = formObj.ofc_cd.value;
		formObj.diff_rmk.value = "";
		formObj.pool_max_rt_amt.value = "";
		formObj.pool_min_rt_amt.value = "";
		
		// hidden input tag 값 초기화
		formObj.pay_inv_seq.value = "";
		formObj.inv_no.value = "";
		formObj.chss_mgst_inv_sts_cd.value = "";
		formObj.agmt_ofc_cty_cd.value = "";
		formObj.agmt_seq.value = "";
		
		// MultiCombo 초기화
		for(var i=0; i<2; i++){
			comboObjects[i].Text2 = "";
		}
	
		// Form Enable 처리
		doFromControlEnable(true, 'input1');
	
		// 버튼 활성/비활성 처리
		doActionBtnEnable();

		// Sheet 초기화
		for(var i=1; i <= sheetObjects[0].RowCount; i++){
			sheetObjects[0].cellValue2(i,"cost_chss_qty") = "";
			sheetObjects[0].cellValue2(i,"cost_bil_dys") = "";
			sheetObjects[0].cellValue2(i,"cost_amt") = "0";
		}

		// Invoice No. 조회
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);

	}
	
	/**
	 * Form의 Conrol 를 초기화 시킨다. <br>
	 * Cost Month 또는 Invoice No. 가 변경되었을 경우 사용한다.
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function initControl2(){
		
		var formObj = document.form;
		
		// 현재 날짜 가져오기
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth() + 1;
		var date = today.getDate();
		
//		var inv_dt = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
		
		// 화면 input tag 초기화
//		formObj.inv_dt.value = inv_dt;
		formObj.vndr_seq.value = "";
		formObj.vndr_lgl_eng_nm.value = "";
		formObj.cost_ofc_cd.value = formObj.ofc_cd.value;
		formObj.diff_rmk.value = "";
		formObj.pool_max_rt_amt.value = "";
		formObj.pool_min_rt_amt.value = "";
		
		// hidden input tag 값 초기화
		formObj.pay_inv_seq.value = "";
		formObj.chss_mgst_inv_sts_cd.value = "";
		formObj.agmt_ofc_cty_cd.value = "";
		formObj.agmt_seq.value = "";
		
		// MultiCombo 초기화
		comboObjects[1].Text2 = "";
		
		// 버튼 활성/비활성 처리
		doActionBtnEnable();
		
		// sheet 초기화
		for(var i=1; i <= sheetObjects[0].RowCount; i++){
			sheetObjects[0].cellValue2(i,"cost_chss_qty") = "";
			sheetObjects[0].cellValue2(i,"cost_bil_dys") = "";
			sheetObjects[0].cellValue2(i,"cost_amt") = "0";
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 152;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
						
					var HeadTitle1 = "|||Chassis Type|Quantity|Billing Days|Amount (USD)";
						
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true, "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter, true, "dtl_pool_cost_itm_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter, true, "pay_inv_seq");
					
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter, true, "intg_cd_val_dp_desc",	false, "", dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,  true, "cost_chss_qty",		false, "", dfNullInteger,	0,	true,	true, 5);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,  true, "cost_bil_dys",			false, "", dfNullInteger,	0,	true,	true, 5);
					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,  true, "cost_amt",				false, "", dfNullFloat,		2,	true,	true, 12);
					
					CountPosition = 0;

				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 202;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
						
					var HeadTitle1 = "";
						
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOL	TIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter,	true, "ibflag");
				}
				break;

		}
	}

	/**
	 * Sheet관련 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
			
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {	
			case IBSEARCH:	  //조회
				
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				formObj.chss_mgst_inv_knd_cd.value = "NP";
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("EES_CGM_1124GS.do" , FormQueryString(formObj), '', true);
				
				sheetObj.LoadSearchXml(sXml);
				ComOpenWait(false);
				var agmt_ofc_cty_cd = ComGetEtcData(sXml,"agmt_ofc_cty_cd");
				var agmt_seq = "000000" + ComGetEtcData(sXml,"agmt_seq");
				
				// hidden value
				document.form.inv_no.value = ComCgmNullToBlank(sheetObj.EtcData("inv_no"));
				document.form.pay_inv_seq.value = ComCgmNullToBlank(sheetObj.EtcData("pay_inv_seq"));
			
				document.form.chss_mgst_inv_knd_cd.value = ComCgmNullToBlank(sheetObj.EtcData("chss_mgst_inv_knd_cd"));
				document.form.chss_mgst_inv_sts_cd.value = ComCgmNullToBlank(sheetObj.EtcData("chss_mgst_inv_sts_cd"));
				document.form.agmt_ofc_cty_cd.value = ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
				document.form.agmt_seq.value = ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
				
				// text value
				document.form.cost_ofc_cd.value = ComCgmNullToBlank(sheetObj.EtcData("cost_ofc_cd"));
				document.form.diff_rmk.value = ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
				document.form.pool_max_rt_amt.value = ComCgmNullToBlank(sheetObj.EtcData("pool_max_rt_amt"));
				document.form.pool_min_rt_amt.value = ComCgmNullToBlank(sheetObj.EtcData("pool_min_rt_amt"));
				
				document.form.vndr_seq.value = ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
				document.form.vndr_lgl_eng_nm.value = ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
//				document.form.inv_dt.value = ComCgmNullToBlank(sheetObj.EtcData("inv_dt"));
				
				// combo value (Agreement No.)
				if(ComCgmNullToBlank(ComGetEtcData(sXml,"agmt_ofc_cty_cd")) != ''){
					comboObjects[1].Code = agmt_ofc_cty_cd + agmt_seq.substring(agmt_seq.length-6);
				} else {
					comboObjects[1].Code = "";
				}
						
				break;
			
			case IBCLEAR:		//New 초기화
				
				formObj.f_cmd.value = SEARCH02;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				sheetObj.DoSearch("EES_CGM_1124GS.do",FormQueryString(formObj));
				ComOpenWait(false);
				break;
				
			case IBSAVE:		//저장 , Confirm
			
				formObj.f_cmd.value = MULTI;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				formObj.chss_mgst_inv_knd_cd.value = "NP";
				
				formObj.inv_no.value = document.combo_inv.Text;
			
				var sParam = sheetObj.GetSaveString(true);
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
//				prompt("1", sParam); ComOpenWait(false); return;
				var sXml = sheetObj.GetSaveXml("EES_CGM_1124GS.do", sParam);
				
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
						
			case IBDELETE:	  // 삭제
				formObj.f_cmd.value = REMOVE;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("EES_CGM_1124GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
				
			case IBSEARCH_ASYNC01:	// inv_no Combo 조회
			
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1124GS.do", FormQueryString(formObj), '', true);
				
				var sStr = ComGetEtcData(sXml,"comboList");
				var arrStr = sStr.split("@");
					
				MakeComboObject(formObj.combo_inv, arrStr);
								
				break;
			
			case IBSEARCH_ASYNC02:	// agreemnt no Combo 조회
				
				formObj.f_cmd.value = SEARCH01;
				formObj.agmt_lstm_cd.value = "NP";
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
								
				var sStr = ComGetEtcData(sXml,"comboList");
				var arrStr = sStr.split("@");
					
				MakeComboObject2(formObj.combo_agmt, arrStr, 0);
				
				break;
				
			case IBSEARCH_ASYNC04:
				
				var ofcCd = formObj.ofc_cd.value;
				formObj.ofc_cd.value = formObj.cost_ofc_cd.value;
				
				formObj.f_cmd.value = COMMAND01;
				var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj), '', true);
				var sCheckResult = ComGetEtcData(sXml,"checkResult");
				
				if(sCheckResult == COM_VALIDATION_FALSE){
					ComShowCodeMessage('CGM10009','Office');
					formObj.cost_ofc_cd.value = "";
					formObj.cost_ofc_cd.focus();
				}
				
				formObj.ofc_cd.value = ofcCd;
				
				break;
			 case IBRESET:
					var idx = 0
					var sXml2 = document.form2.sXml.value;
					var arrXml = sXml2.split("|$$|");
			
					//agmt_lstm_cd
					if ( arrXml[idx] == null ) {return;}
					var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
					var arrStr1 = new Array();
					var arrStr2 = new Array();
					for ( var i = 0; i < vArrayListData.length; i++) {
						vListData = vArrayListData[i];
						arrStr1[i] = vListData["code1"] + vListData["code2"] + " - " + vListData["desc1"] + "|" + vListData["code4"] + "|" + vListData["desc4"] + "|" + vListData["code6"];
						arrStr2[i] = vListData["code1"] + vListData["code2"];
					}
					// combo control, 결과 문자열, Text Index, Code Index
					//MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);
					MakeComboObject3(formObj.combo_agmt, arrStr1, arrStr2);
					idx++;
  
			 
					break;
		}
	}
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	  * @param  {object} sheetObj	필수	 Sheet Object
	  * @param  {object} formObj	필수 Form Object
	  * @param  {String} sAction	필수 Action Type
	  * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
	  * @author 김창식
	  * @version 2009.09.17
	  */
	 function validateForm(sheetObj,formObj,sAction){
		
		switch(sAction) {
				case IBSEARCH:
					if(document.combo_inv.Text == ''){
						ComShowCodeMessage('CGM10004','Invoice No.');
						return false;
					}	
					
					break;
					
			case IBSAVE:
								
				if(formObj.cost_yrmon.value == ''){
					ComShowCodeMessage('CGM10004','Cost Month');
					formObj.cost_yrmon.focus();
					return false;
			
				} else if(formObj.cost_ofc_cd.value == ''){	
					ComShowCodeMessage('CGM10004','Cost Office');
					formObj.cost_ofc_cd.focus();
					return false;
				
//				} else if(formObj.inv_dt.value == ''){
//					ComShowCodeMessage('CGM10004','Invoice Issue Date');
//					formObj.inv_dt.focus();
//					return false;
				
				} else if(document.combo_inv.Text == ''){
					ComShowCodeMessage('CGM10004','Invoice No.');
					return false;
					
				} else if(document.combo_agmt.Text == ''){
					ComShowCodeMessage('CGM10004','Agreement No.');
					return false;

				}
				
				break;
		 }
		 
		 return true;
	 }

	 /** 
	  * Sheet 의 change 이벤트에 대한 처리  <br>
	  * @param  없음
	  * @return 없음
	  * @author 김창식
	  * @version 2009.09.17
	  */
	 function sheet1_OnChange(sheetObj, Row, Col){
		
		if(sheetObj.ColSaveName(Col) == "cost_chss_qty"  || sheetObj.ColSaveName(Col) == "cost_bil_dys"){
			var costChssQty = sheetObj.cellValue(Row, "cost_chss_qty");
			var costBilDys = sheetObj.cellValue(Row, "cost_bil_dys");
			
			if(costChssQty=='') costChssQty = 0;
			if(costBilDys=='') costBilDys = 0;
			
			if(costChssQty < 0){
				sheetObj.cellValue2(Row, "cost_chss_qty") = Math.abs(sheetObj.cellValue(Row, "cost_chss_qty"));
			}
			
			if(costBilDys < 0){
				sheetObj.cellValue2(Row, "cost_bil_dys") = Math.abs(sheetObj.cellValue(Row, "cost_bil_dys"));
			}
			
			// Amount 의 경우 Credit 항목은 (-)로 표시
			if(sheetObj.cellValue(Row,"dtl_pool_cost_itm_cd") == 'NE'){
				//chungpa 20100309 수식 자동계산 안되게 처리함. sheetObj.cellValue2(Row, "cost_amt") = -1 * Math.abs(costChssQty * costBilDys);
			} else {	
				//chungpa 20100309 수식 자동계산 안되게 처리함. sheetObj.cellValue2(Row, "cost_amt") = Math.abs(costChssQty * costBilDys);
			}
		}
		
		// Amount 의 경우 Credit 항목은 (-)로 표시
		if(sheetObj.ColSaveName(Col) == "cost_amt"){
			if(sheetObj.cellValue(Row,"dtl_pool_cost_itm_cd") == 'NE'){
				//chungpa 20100309 수식 자동계산 안되게 처리함. sheetObj.cellValue2(Row, "cost_amt") = -1 * Math.abs(sheetObj.cellValue(Row, "cost_amt"));
				
				//chungpa 20100413 CREDIT('NE')일 경우 음수처리 나머지 양수처리 start
				sheetObj.cellValue2(Row, "cost_amt") = -1 * Math.abs(sheetObj.cellValue(Row, "cost_amt"));
				//chungpa 20100413 CREDIT('NE')일 경우 음수처리 나머지 양수처리 end
			} else {
				//chungpa 20100309 수식 자동계산 안되게 처리함. sheetObj.cellValue2(Row, "cost_amt") = Math.abs(sheetObj.cellValue(Row, "cost_amt"));
				
				//chungpa 20100413 CREDIT('NE')일 경우 음수처리 나머지 양수처리 start
				sheetObj.cellValue2(Row, "cost_amt") = Math.abs(sheetObj.cellValue(Row, "cost_amt"));
				//chungpa 20100413 CREDIT('NE')일 경우 음수처리 나머지 양수처리 end
			}
		}
		
		dtl_pool_cost_itm_cd
	}

	/** 
	 * Sheet 의 changeSum 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function sheet1_OnChangeSum(sheetObj, Row)
	{
		with(sheetObj){
			SumText(0, "ExpenseDetail") = "Total Amount";
			
			document.form.chg_smry_amt.value = SumValue(0, "cost_amt");
			document.form.inv_smry_amt.value = SumValue(0, "cost_amt");
		}
	}
	 
	 /** 
	  * Object 의 keypress 이벤트에 대한 처리  <br>
	  * @param  없음
	  * @return 없음
	  * @author 김창식
	  * @version 2009.09.17
	  */
	 function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym":
			case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "engup":
				if(obj.name=="cost_ofc_cd") ComKeyOnlyAlphabet('uppernum');
				else ComKeyOnlyAlphabet('upper');
				break;
			case "float":
				ComKeyOnlyNumber(obj, ".");
				break;
		}
	}
	
	/** 
	 * Object 의 keyup 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */	  
	function obj_keyup(){
		var formObj = document.form;
		
		obj = event.srcElement;
		switch(obj.name) {
			case "pool_max_rt_amt":
				
				var strPoolMaxRtAmt = formObj.pool_max_rt_amt.value;
				var arrPoolMax = strPoolMaxRtAmt.split(".");
				
				// 소수점이 2개가 오지 않도록 체크
				if(arrPoolMax.length > 2){
					formObj.pool_max_rt_amt.value = strPoolMaxRtAmt.substring(0,strPoolMaxRtAmt.length-1);
					return;
				}
				
				// 정수 5자리 체크
				if(arrPoolMax[0].length > 5){
					if(arrPoolMax.length == 2){
						formObj.pool_max_rt_amt.value = arrPoolMax[0].substring(0,arrPoolMax[0].length-1) + "." + arrPoolMax[1];
					} else {
						formObj.pool_max_rt_amt.value = arrPoolMax[0].substring(0,arrPoolMax[0].length-1);
					}
					return;
				}
				
				// 소수 2자리 체크
				if(arrPoolMax.length == 2){
					if(arrPoolMax[1].length > 2){
						formObj.pool_max_rt_amt.value = arrPoolMax[0] + "." + arrPoolMax[1].substring(0,arrPoolMax[1].length-1);
						return;
					}
				}
				
				break;
				
			case "pool_min_rt_amt":
				
				var strPoolMinRtAmt = formObj.pool_min_rt_amt.value;
				var arrPoolMin = strPoolMinRtAmt.split(".");
				
				// 소수점이 2개가 오지 않도록 체크
				if(arrPoolMin.length > 2){
					formObj.pool_min_rt_amt.value = strPoolMinRtAmt.substring(0,strPoolMinRtAmt.length-1);
					return;
				}
				
				// 정수 5자리 체크
				if(arrPoolMin[0].length > 5){
					if(arrPoolMin.length == 2){
						formObj.pool_min_rt_amt.value = arrPoolMin[0].substring(0,arrPoolMin[0].length-1) + "." + arrPoolMin[1];
					} else {
						formObj.pool_min_rt_amt.value = arrPoolMin[0].substring(0,arrPoolMin[0].length-1);
					}
					return;
				}
				
				// 소수 2자리 체크
				if(arrPoolMin.length == 2){
					if(arrPoolMin[1].length > 2){
						formObj.pool_min_rt_amt.value = arrPoolMin[0] + "." + arrPoolMin[1].substring(0,arrPoolMin[1].length-1);
						return;
					}
				}
				
				break;
		}
	}
	 
	 /** 
	  * Object 의 activate 이벤트에 대한 처리  <br>
	  * @param  없음
	  * @return 없음
	  * @author 김창식
	  * @version 2009.09.17
	  */
	 function obj_activate(){
		ComClearSeparator(event.srcElement);
		COST_YRMON_OLD1 = document.form.cost_yrmon.value;
	}
	 
	 /** 
	  * Object 의 deactivate 이벤트에 대한 처리  <br>
	  * @param  없음
	  * @return 없음
	  * @author 김창식
	  * @version 2009.09.17
	  */
	 function obj_deactivate(){
		var formObj = document.form;
		
		obj = event.srcElement;
		switch(obj.name) {
			case "cost_yrmon":	
			case "inv_dt":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	 
	/** 
	 * Object 의 focusout 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function obj_focusout(){

		var formObj = document.form;
		
		obj = event.srcElement;
		switch(obj.name) {
			case "cost_yrmon":	
				
				var costYrmon = ComReplaceStr(document.form.cost_yrmon.value,"-","");
				
				if(costYrmon != COST_YRMON_OLD1){
					initControl2();
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
				}
				break;
		}	
	} 
	
	/** 
	 * Object 의 change 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function obj_change(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		obj = event.srcElement;
		switch(obj.name) {
			case "cost_ofc_cd":	
				if(formObj.cost_ofc_cd.value != ''){
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC04);
				}
				break;
		}	
	}
	
	/** 
	 * Calendar 호출 시 change 이벤트를 대용하기 위한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function processEndCal(){
		var formObj = document.form;
		
		var costYrmon = ComReplaceStr(formObj.cost_yrmon.value,"-","");

		if(costYrmon != COST_YRMON_OLD2){
			initControl2();
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
		}
			
	}
	
	/**
	 * Form Control 의 Action 별 Enable 제어 기능을 수행한다. <br>
	 * @param  bEnable	Boolean
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */	 
	function doFromControlEnable(bEnable, sStyle){
		var formObj = document.form;
		
		comboObjects[1].Enable = bEnable;
				
		if(sStyle == undefined){
			ComCgmEnableObject(formObj.cost_yrmon, bEnable);
			ComCgmEnableObject(formObj.cost_ofc_cd, bEnable);
//			ComCgmEnableObject(formObj.inv_dt, bEnable);
		} else {
			ComCgmEnableObject(formObj.cost_yrmon, bEnable, sStyle);
			ComCgmEnableObject(formObj.cost_ofc_cd, bEnable, sStyle);
//			ComCgmEnableObject(formObj.inv_dt, bEnable, sStyle);
		}
				
		ComCgmEnableObject(formObj.btns_cost_yrmon, bEnable);
		ComCgmEnableObject(formObj.btns_office, bEnable);
//		ComCgmEnableObject(formObj.btns_inv_dt, bEnable);
	}
	
	/**
	 * Action 버튼의 활성/비활성을 설정한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.15
	 */	
	function doActionBtnEnable (){
		
		var chssMgstInvStsCd = document.form.chss_mgst_inv_sts_cd.value;
		
		if(chssMgstInvStsCd == ''){
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnDisable("btn_Delete");
			
		} else if(chssMgstInvStsCd == 'H'){
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_Delete");
			
		} else if(chssMgstInvStsCd == 'S'){
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_Delete");
			
		} else if(chssMgstInvStsCd == 'C'){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_Delete");
		}
	}
	
	/** 
	 * Invoice No. MultiCombo 의 change 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function combo_inv_OnChange(comboObj, idx_cd, text){

		var formObj = document.form;
		
		var arrValue = idx_cd.split("|");
		var invNo = arrValue[0];
		var chssMgstInvStsCd = arrValue[1];
	
		formObj.inv_no.value = invNo;
		formObj.chss_mgst_inv_sts_cd.value = chssMgstInvStsCd;
		
		initControl2();
		
		// 입력 또는 선택한 Text 가 MultiCombo에 있는지 체크하여 Enable 처리
		if(text != '' && comboObj.FindIndex (text, 0) != -1){
			// Form Enable 처리
			doFromControlEnable(false, 'input2');
		} else {
			// Form Enable 처리
			doFromControlEnable(true, 'input1');
		}
	}
	
	/** 
	 * Agreement No. MultiCombo 의 change 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function combo_agmt_OnChange(comboObj, idx_cd, text){
	
		var formObj = document.form;
		
		var comboObjAgmt = document.combo_agmt;
		var agmtNo = comboObjAgmt.GetText(idx_cd,0);
		var vndrSeq = comboObjAgmt.GetText(idx_cd,1);
		var vndrNm = comboObjAgmt.GetText(idx_cd,2);
		var currCd = comboObjAgmt.GetText(idx_cd,3);

		formObj.agmt_ofc_cty_cd.value = agmtNo.substring(0, 3);
		formObj.agmt_seq.value = agmtNo.substring(3, 9);
		formObj.agmt_ver_no.value = agmtNo.substring(12, 13);
		formObj.vndr_seq.value = vndrSeq;
		formObj.vndr_lgl_eng_nm.value = vndrNm;
		formObj.curr_cd.value = currCd;
//		alert("agmt_ofc_cty_cd : " + formObj.agmt_ofc_cty_cd.value +
//		"\nagmt_seq : " + formObj.agmt_seq.value +
//		"\nagmt_ver_no : " + formObj.agmt_ver_no.value);
		
	}

	/** 
	 * MultiCombo 의 초기화  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */
	function initCombo(comboObj) {
		switch(comboObj.id) {
			case "combo_inv":
				var cnt=0;
				with(comboObj) {
					Code = "";
					Text = "";
					BackColor = "#CCFFFD";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;
					UseCode = true;
					Enable = true;
					ValidChar(2,3);
					IMEMode = 0;
				}
				break;
			case "combo_agmt":
				with(comboObj) {
					Code = "";
					Text = "";
					BackColor = "#CCFFFD";
					DropHeight = 100;
					MultiSelect = false;
					MaxSelect = 1;
					UseCode = true;
				}
				break;
		}
	}
	
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		for (var i = 0; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
		cmbObj.Index2 = "" ;
	}
	
	function MakeComboObject2(cmbObj, arrStr, col) {
		cmbObj.RemoveAll();
		for (var i = 0; i < arrStr.length; i++ ) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i, arrStr[i], arrCode[col]);
		}
		cmbObj.Index2 = "" ;
	}
	
	function MakeComboObject3(cmbObj, arrStr, arrStr2) {
		cmbObj.RemoveAll();
		for (var i = 0; i < arrStr.length; i++ ) {
			var arrCode = arrStr[i].split("|");
			
			cmbObj.InsertItem(i, arrStr[i], arrStr2[i]);
		}
		cmbObj.Index2 = "" ;
	}
	
	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 (Save, Confirm)<br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {
			ComShowCodeMessage('CGM00003');
			
			// 저장 한 후 Retrieve 처리
			var obj = document.getElementById("btn_Retrieve");
			obj.fireEvent("onclick");
			
			// Invoice No 조회
			var invNo = comboObjects[0].Text;
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			comboObjects[0].Text2 = invNo;
		}
	}
	
	/**
	 * Sheet2 의 OnSaveEnd 이벤트처리 (삭제)<br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.16
	 */
	function sheet2_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {
			ComShowCodeMessage('CGM00006','The Invoice');
			// 삭제 후 초기화 처리
			initControl(sheetObjects[0]);
		}
	} 
	
	/* 개발자 작업  끝 */