/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CGM_1211.js
*@FileTitle : Audit Result Update(PopUp)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 김창영
*@LastVersion : 1.0
* 2014.05.27 김창영
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends 
	 * @class ees_cgm_1211 : ees_cgm_1211 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cgm_1211() {
		this.processButtonClick	= tprocessButtonClick;
		this.setSheetObject		= setSheetObject;
		this.loadPage			= loadPage;
		this.initSheet			= initSheet;
		this.initControl		= initControl;
		this.doActionIBSheet	= doActionIBSheet;
		this.validateForm		= validateForm;
		this.sheet1_OnSaveEnd	= sheet1_OnSaveEnd;
	}
	
	/* 개발자 작업 시작 */

	// 공통전역변수

//	var tabObjects = new Array();
//	var tabCnt = 0 ;
//	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 각 Tab 별 Save 상태값 저장 (false:비활성,true:활성)	
//	var TAB_SAVE_STD = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				
				case "btn_loadexcel":
					doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
					break;
	
				case "btn_downexcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					break;
					
				case "btn_new":
					sheetObject1.RemoveAll();
					ComBtnEnable("btn_chk");
					ComBtnEnable("btn_chk");
					break;
					
				case "btn_chk":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
					break;
					
				case "btn_upt":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
				case "btn_Close":
					window.close();
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){

		sheetObjects[sheetCnt++] = sheet_obj;

	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		 
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		
		}
		
//		prompt("parent value" , 
//				document.form.parent_cost_yrmon_seq.value + ", " +          
//				document.form.parent_agmt_ofc_cty_cd.value + ", " +
//				document.form.parent_agmt_seq.value + ", " +
//				document.form.parent_agmt_ref_no.value + ", " +
//				document.form.parent_inv_no.value + ", " +
//				document.form.parent_agmt_ver_no.value);
		
		// vendor Name 가져오기
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch(sheetID) {
		
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "|Sel.|Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Reaudit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.|Row ID for Update";
								
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days|Reaudit Result";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.|Row ID for Update";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable=true, ColumnMove=false, AllCheckEnable=true, UserResize=true, RowMove=false, Head3D=true]
					InitHeadMode(false, true, true, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,  daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,  daCenter,	false, "del_chk",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtDataSeq,		30,  daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70,  daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			90,  daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145, daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150, daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝

					InitDataProperty(0, cnt++ , dtData,			70,  daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			45,  daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45,  daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150, daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55,  daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55,  daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95,  daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60,  daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70,  daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70,  daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50,  daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95,  daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60,  daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80,  daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			250, daLeft,	true, "reaud_rslt",					false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,  daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80,  daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80,  daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100, daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtHidden,		70,  daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70,  daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50,  daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70,  daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100, daCenter,	true, "updt_key",					false, "", dfNone,		0, false, false);
					
					WordWrap = true;
					CountPosition = 2;
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 200;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle1 = "||seq|updt_key|reaud_rslt";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,  daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,  daCenter,	false,"del_chk",	false, "", dfNone,	 0, false, false);
					InitDataProperty(0, cnt++ , dtDataSeq,		30,  daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			200, daCenter,	true, "reaud_rslt",	false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			100, daCenter,	true, "updt_key",	false, "", dfNone,	0, false, false);
					
					WordWrap = true;
					CountPosition = 2;
				}
				break;
				
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
			
		switch(sAction) {
		
			case IBSEARCH_ASYNC01:	// Vendor Code,Name 조회
			
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var text = ComGetEtcData(sXml,"text");
				
				formObj.vndr_lgl_eng_nm.value = text;
				break;
				
			case IBDOWNEXCEL: // EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1,false,true,"","",false,false,"",true,"del_chk");
//				sheetObj.SpeedDown2Excel(1,false,true,"","/apps/alps/ees/cgm/chassismgsetagreementinvoice/chassismgsetinvoice/xml/EES_CGM_1211_FORMAT.xml",false,false,"",true,"del_chk","",false,"",true);
				
				break;
				
			case IBLOADEXCEL: // EXCEL UPLOAD
				sheetObj.RemoveAll();
//				sheetObj.LoadExcel(-1, 1, "", 6);
				sheetObj.LoadExcel();
				
				break;
				
			case IBSEARCH_ASYNC02:	// Button Check
				if(!validateForm(sheetObj,formObj,sAction)) {
					return;
				}
				
				formObj.f_cmd.value = MULTI01;
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
				var sParam = "";
				
				sParam = ComGetSaveString(sheetObj, true, true);
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
//				prompt("체크", sParam); ComOpenWait(false); return;
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1211GS.do", sParam);
//				prompt("After Transaction XML", sXml);
				
				sheetObjects[1].LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
				break;
				
			case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return;
				}
				
				formObj.f_cmd.value = MULTI02;
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
				var sParam = "";
				
				sParam = sheetObj.GetSaveString(false, true, "del_chk"); 
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1211GS.do", sParam);
				
				sheetObjects[0].LoadSaveXml(sXml);

				ComOpenWait(false);

				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * @param  {object}		sheetObj	필수	 Sheet Object
	 * @param  {object}		formObj	필수 Form Object
	 * @param  {String}		sAction	필수 Action Type
	 * @return {boolean}	false => validation 체크 오류, true => validation 체크 성공
	 * @author Chang Young Kim
	 * @version 2014.06.10
	 */   
	function validateForm(sheetObj,formObj,sAction){

		switch(sAction){
			case IBSAVE:	// Update
				
				var strCheckedRows = sheetObj.FindCheckedRow("del_chk");
				
				if(sheetObj.RowCount < 1) {	//전체 데이터 행 개수를 확인한다.
					//msgs['CGM20057'] = 'There are no data to {?msg1}';
					ComShowCodeMessage("CGM20057", "Update");
					return false;
				} else if(strCheckedRows.length == 0) {
					// msgs['CGM10009'] = 'Please check the {?msg1}';
					ComShowCodeMessage("CGM20057", "Sel. and Reaudit Result");
					return false;
				}
				
				break;
			
			case IBSEARCH_ASYNC02:	// Button Check
				if(sheetObj.RowCount < 1) {	//전체 데이터 행 개수를 확인한다.
					// msgs['CGM20057'] = 'There are no data to {?msg1}';
					ComShowCodeMessage('CGM20057', "Check");
					return false;
				}
				
				break;
		}
		
		return true;
	}
	
	/**
	 * Sheet1의 OnSaveEnd (Save) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {
			ComShowCodeMessage('CGM00003');
		}
		ComBtnDisable("btn_upt");
	}
	
	/**
	 * Sheet1의 OnLoadExcel 이벤트 처리 <br>
	 * 
	 * @version 2014.06.24
	 */
	function sheet1_OnLoadExcel() {
		/***** 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
		var sheetObject1 = sheetObjects[0];
		/*********************************************************************/
		var cntWrgInvNo = 0;
		
		
		if(sheetObject1.RowCount > 0) {
			for(var idx = sheetObject1.HeaderRows; idx < sheetObject1.Rows; idx++) {
				if(sheetObject1.CellValue(idx, "inv_no") != document.form.parent_inv_no.value) {
					sheetObject1.CellBackColor(idx, "inv_no") = sheetObject1.RgbColor(252, 210, 9);
					cntWrgInvNo++
				}
				
				// TTL AMT = Rate Sum + Tax Sum - Credit ( Auto Sum )
				sheetObject1.CellValue(idx, "inv_lse_chg_ttl_amt") = 
					ComCgmAmountFormat(parseFloat(sheetObject1.CellValue(idx, "inv_lse_chg_amt")) 
									+ parseFloat(sheetObject1.CellValue(idx, "inv_tax_amt")) 
									- parseFloat(Math.abs(sheetObject1.CellValue(idx, "inv_cr_amt"))),2);
					
				
			}
			
			if(cntWrgInvNo > 0) {
				//msgs['COM132301'] = '{?msg1} and {?msg2} are unmatched. Please check again.';
				ComShowCodeMessage("COM132301", "Selected Invoice No.", "Excel File Invoice No.");
				ComBtnDisable("btn_chk");
				ComBtnDisable("btn_upt");
			} else {
				ComBtnEnable("btn_chk");
				ComBtnEnable("btn_upt");
			}
		}
	}
	
	 /**
	  * (Check Button) sheetObjects[1]에 Load 후 발생 Event<br> 
	  *
	  * @author Chang Young Kim
	  * @version 2014.06.05
	  */   
	 function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		/***** 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*********************************************************************/
		
		if(sheetObject1.RowCount == sheetObject2.RowCount) {
			for(var idx = sheetObject1.HeaderRows; idx < sheetObject1.Rows; idx++) {
				sheetObject1.CellValue2(idx, "del_chk")		= sheetObject2.CellValue(idx - 1, "del_chk");
				sheetObject1.CellValue2(idx, "reaud_rslt")	= sheetObject2.CellValue(idx - 1, "reaud_rslt");
				
				if(sheetObject2.CellValue(idx - 1, "reaud_rslt") != "OK") {
					sheetObject1.CellEditable(idx, "del_chk") = false;
					sheetObject1.RowBackColor(idx) = sheetObject1.RgbColor(192,192,192);
				} else {
					sheetObject1.CellEditable(idx, "del_chk") = true;
					sheetObject1.RowStatus(idx) = "U";
				}
				
				sheetObject1.CellValue2(idx, "updt_key")	= sheetObject2.CellValue(idx - 1, "updt_key");
			}
			
			ComBtnDisable("btn_chk");
			
		} else {
			
		}
		
	 }
	/* 개발자 작업  끝 */