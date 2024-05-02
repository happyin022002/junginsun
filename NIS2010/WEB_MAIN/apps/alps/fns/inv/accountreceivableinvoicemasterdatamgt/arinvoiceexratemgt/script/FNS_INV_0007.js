/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_inv_0007.js
 *@FileTitle : Ex. Rate Entry by Customer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.27 김세일
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
	 * @class fns_inv_0007 : fns_inv_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0007() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var retrieveFlg = 0;
	
	
	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
				case "btn_retrieve":
					form.dispaly.disabled=false;
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break; 
		
				case "btn_new":
					form.exrate_btn.style.display = "none";
					form.dispaly.checked = false;
		
					retrieveFlg == 1;
					form.dispaly.disabled=true;
					sheetObject1.RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBRESET);
					break; 
		
				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;
		
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1,false,false,true,'','',false,false,'',false,"DelChk");
		
					break; 
		
				case "btn_add":
					if (retrieveFlg == 1) {
						doActionIBSheet(sheetObject1,document.form,IBINSERT);
					}	
					break;  
		
				case "btn_copy":
					sheetObject1.DataCopy();
					break; 
		
				case "btn_del":
					ComRowHideDelete(sheetObject1, "DelChk");
					break;                                         
		
				case "btns_calendar": //달력버튼
				var cal = new ComCalendar();
				cal.setDisplayType('month');
		
				cal.select(formObject.fm_dt, 'yyyy-MM');
				break;
		
				case "exrate_btn":   
					if(form.dispaly.checked) {
						if (retrieveFlg == 1) {
		
							var iCheckRow = sheetObject1.FindCheckedRow("DelChk"); 
							if (iCheckRow== "") {
								ComShowCodeMessage("INV00025");
								return false;
							}
		
							doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC02);
						}	
					}	
					break;
		
				case "btn_custNm":
					var Row = 1;
					var Col = 1;
					param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.cust_seq.value+'&cust_cnt_cd='+formObject.cust_cnt_cd.value;
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 	
		
		document.form.cust_cnt_cd.focus();
		
	}
	
		
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
			case 1:      //sheet1 init
			with (sheetObj) {
		
				// 높이 설정
				style.height = 440;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(18, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
		
				var HeadTitle = "|Sel.|Seq|From Date|To Date|Currency|Bound|Ex. Rate|Updated By|Updated Date";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 40,daCenter, false, "DelChk");  
				InitDataProperty(0, cnt++ , dtSeq,    		 55,   daCenter,  false,     "Seq");
				InitDataProperty(0, cnt++ , dtPopupEdit, 	110,  daCenter,  false,     "fm_dt",   		false,          "",      dfDateYmd,    	0,     false,       true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  	 110,  daCenter,   false,     "to_dt",    		false,          "",      dfDateYmd,    	0,     false,       true);
		
				InitDataProperty(0, cnt++ , dtCombo,    	110,   daCenter,  false,     "chg_curr_cd",    	false,          "",      dfNone,     		0,     false,       true);
				InitDataProperty(0, cnt++ , dtCombo,    	110,   daCenter,  false,     "io_bnd_cd",   			false,          "",      dfNone,      	0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,  		110,   daRight,	   false,     "inv_xch_rt",    		false,          "",      dfNullFloat,   6,     true,       true);
				InitDataProperty(0, cnt++ , dtData,    		110,   daCenter,  false,     "upd_usr_id",   	false,          "",      dfNone,      	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,    		110,   daCenter,  false,     "upd_dt",   false,          "",      dfNone,     0,     false,       false);                      
				InitDataProperty(0, cnt++ , dtHidden, 	   	0,   daCenter,  false,     "xch_rt_rvs_flg",   		false,          "",      dfNone,     		0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,  		0,   daRight,   false,     "ivs_xch_rt",   false,          "",      dfNullFloat,   6,     false,       true);
		
		
		
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "xch_rt_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "cust_seq");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "locl_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "ar_ofc_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "pre_inv_xch_rt");
		
				InitDataCombo(0,  "chg_curr_cd",  "CHF|GBP|NOK|USD",  "1|2|3|4",  "CHF",  "1");  
				InitDataCombo(0,  "io_bnd_cd",   "O/B|I/B",  "O|I"); 													
		
				PopupImage  =  "img/btns_calendar.gif";																																	
				InitComboNoMatchText(true);	
				WaitImageVisible = false; 
			}
			break;	
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0007GS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
		
			MakeComboObject2(formObj.ar_ofc_cd2, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(var i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ar_ofc_cd2.text = ar_ofc_cd;
					formObj.ar_ofc_cd.value = ar_ofc_cd;
		
					formObj.ar_ofc_cd_1.value = ar_ofc_cd;
					formObj.locl_curr_cd_1.value = arrStr2[4];				        
		
					formObj.locl_curr_cd.value = arrStr2[4];
					formObj.ar_ctrl_ofc_cd.value = arrStr2[5];
					formObj.loc_cd.value = arrStr2[6].substring(0,2);						        
				}
			}
		
			//====== combo list ====================//
			var comboValues = ComGetEtcData(sXml, "currInfo");	
			addCellComboItem(sheetObj,comboValues,"chg_curr_cd",false);						
			//====== combo list ====================//
		
			var ret = ComGetNowInfo("ym" )      //결과 : 2008-11
			formObj.fm_dt.value = ret;
			
			ComOpenWait(false);
			break;
		
			case IBSEARCH:      //조회
			retrieveFlg = 1;
			formObj.f_cmd.value = SEARCH01;
			if(validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);			
			sheetObj.DoSearch("FNS_INV_0007GS.do",FormQueryString(formObj));
			ComOpenWait(false);
			break;
			
			case IBSEARCH_ASYNC02:      //조회				
			if(validateForm(sheetObj,formObj,sAction)){
			} else {	
				var v_custCntCd = formObj.cust_cnt_cd.value;
				var v_custSeq = formObj.cust_seq.value;
				var v_mon = formObj.fm_dt.value;
		
				var param = '?pgmNo=FNS_INV_0089&cust_cnt_cd='+v_custCntCd+'&cust_seq='+v_custSeq+'&mon='+v_mon;
				ComOpenPopup('/hanjin/FNS_INV_0089.do' + param, 600, 420, 'getPopMulti', '0,0', false, false, "", "", 0);
			}		
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) return;
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0008GS.do", FormQueryString(formObj),-1,false); 						
			
			ComOpenWait(false);
			break;
		
			case IBINSERT:      // 입력
			var sheetIdx = sheetObj.DataInsert(-1);
			if (document.form.io_bnd_cd.value =="I") {
				sheetObj.CellText(sheetIdx,"io_bnd_cd") = "I/B";
			} else {
				sheetObj.CellText(sheetIdx,"io_bnd_cd") = "O/B";
			}
			sheetObj.CellText(sheetIdx,"xch_rt_tp_cd") = "I";
			sheetObj.CellText(sheetIdx,"cust_cnt_cd") = document.form.cust_cnt_cd.value;
			sheetObj.CellText(sheetIdx,"cust_seq") = document.form.cust_seq.value;
			sheetObj.CellText(sheetIdx,"locl_curr_cd") = document.form.locl_curr_cd.value;
			sheetObj.CellText(sheetIdx,"ar_ofc_cd") = document.form.ar_ofc_cd.value;
		
			break;
		
			case IBRESET: // New
			var ret = ComGetNowInfo("ym" )      //결과 : 2008-11
			formObj.fm_dt.value = ret;
			formObj.io_bnd_cd.value="";
			formObj.cust_cnt_cd.value="";
			formObj.cust_seq.value = "";
			formObj.cust_nm.value = "";
			formObj.io_bnd_cd.value="";
		
			formObj.ar_ofc_cd2.text = formObj.ar_ofc_cd_1.value;
			formObj.locl_curr_cd.value = formObj.locl_curr_cd_1.value;
			
			break;	
	
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //조회
			if (formObj.cust_cnt_cd.value.trim() == ""){
				ComShowCodeMessage("INV00004");
				formObj.cust_cnt_cd.focus();
				return true;
			}
			if (formObj.cust_seq.value.trim() == ""){
				ComShowCodeMessage("INV00004");
				formObj.cust_seq.focus();
				return true;
			}
			if (formObj.cust_nm.value == "") {
				ComShowCodeMessage("INV00054");
				formObj.cust_cnt_cd.focus();
				return true;
	
			}
	
			break;
	
			case IBSAVE:        //저장
			var cnt = sheetObj.RowCount;
			if (cnt < 1) {
				ComShowCodeMessage("INV00001");
				return true;
			}
			fn_ComGetMaskedValue();
			
			for (var i=1; i<=sheetObj.RowCount; i++) {				
				
				if (sheetObj.RowStatus(i) == "I") {
					var fmDt = sheetObj.CellValue(i,"fm_dt");
					var toDt = sheetObj.CellValue(i,"to_dt");
					var fmDt1 = formObj.fm_dt.value;
					if (fmDt > toDt) {
						ComShowCodeMessage("INV00024",i+" Line");
						return true;
					}
					
					if(document.form.ar_ofc_cd.value != 'DXBSC'){							
						
						var Sdate = new Date(fmDt.substring(0,4), fmDt.substring(5,7)-1, fmDt.substring(8,10));
						var Edate = new Date(toDt.substring(0,4),toDt.substring(5,7)-1, toDt.substring(8,10));
						
						var interval = Edate - Sdate;
						var day = 1000*60*60*24;
		
						if (parseInt(interval/day)>31) {	        			 
							ComShowCodeMessage("INV00024",i+" Line");
							return true;
						}					
					}
					
					
					if (sheetObj.CellValue(i,"chg_curr_cd").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					}
					
					if (sheetObj.CellValue(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellValue(i,"inv_xch_rt"),",")) == 0 ) {
							return true;
						}
					}
				} else if (sheetObj.RowStatus(i) == "U") {
					
					if (sheetObj.CellValue(i,"pre_inv_xch_rt").trim() != ""&&sheetObj.CellValue(i,"pre_inv_xch_rt").trim() != "0"){
						if (!ComShowCodeConfirm("INV00126")){
							return false;
						}
					}
					
					if (sheetObj.CellValue(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellValue(i,"inv_xch_rt"),",")) == 0 ) {
							return true;
						}
					}
	
				}	
	
			}
			break;
	
			case IBSEARCH_ASYNC02:        //저장
			var cnt = sheetObj.RowCount;
			if (cnt < 1) {
				ComShowCodeMessage("INV00048");
				return true;
			}
			fn_ComGetMaskedValue();
	
			for (var i=1; i<=sheetObj.RowCount; i++) {
				if (sheetObj.RowStatus(i) == "I") {
					var fmDt = sheetObj.CellText(i,"fm_dt");
					var toDt = sheetObj.CellText(i,"to_dt");
					var fmDt1 = formObj.fm_dt.value;
					if (fmDt > toDt) {
						ComShowCodeMessage("INV00024",i+" Line");
						return true;
					}
					if (sheetObj.CellText(i,"chg_curr_cd").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					}
	
					if (sheetObj.CellText(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellText(i,"inv_xch_rt"),",")) == 0 ) {
							return true;
						}
					}
				} else if (sheetObj.RowStatus(i) == "U") {	           	 		
	
					if (sheetObj.CellText(i,"inv_xch_rt").trim() == ""){
						ComShowCodeMessage("INV00041",i+" Line");
						return true;
					} else {
						if (RateCheck(sheetObj, i, ComTrimAll(sheetObj.CellText(i,"inv_xch_rt"),",")) == 0 ) {
							return true;
						}
					}
	
				}	
	
			}
			break;
	
			}
	
		}
	
		return;
	}
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.cust_cnt_cd.value = colArray[8];
		document.form.cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_cust_nm();
	}
	
	/**
	 * 그리드의 달력버튼 클릭시 실행 달력을 띄워준다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1);
	 * </pre>
	 * @param object sheetObj
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnPopupClick(sheetObj, row,col){
		if (sheetObj.ColSaveName(col) == "fm_dt") {
			var cal = new ComCalendarGrid("fm_dt");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
		if (sheetObj.ColSaveName(col) == "to_dt") {
			var cal = new ComCalendarGrid("to_dt");
			cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		}
	
	}
	
	/**
	 * 그리드 날짜 항목 입력시 날짜 validation한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1);
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		if (sheetObjects[0].ColSaveName(Col) == "fm_dt"||sheetObjects[0].ColSaveName(Col) == "to_dt"){
			if(sheetObj.CellValue(Row,"fm_dt")!=""&&sheetObj.CellValue(Row,"to_dt")!=""){
				if(sheetObj.CellValue(Row,"fm_dt") > sheetObj.CellValue(Row,"to_dt")){
					ComShowCodeMessage("INV00024",Row+" Line");
					sheetObj.SelectCell(Row,"fm_dt");
				}
			}
		}
	}
	
	/**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.DropHeight = 190;
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_value = arrStr2[1];
			var ar_ofc_cd = arrStr2[1]+"|"+arrStr2[4]+"|"+arrStr2[5];
			cmbObj.InsertItem(i-1, ar_ofc_value, arrStr[i]);
		}
	}      
	
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd2_OnChange(document.form,'HAMSC','HAMSC');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd2_OnChange(comboObj,value,text) {
		var arrStr = comboObj.Code.split("^");
		var ar_ofc_cd = arrStr[1];
		document.form.ar_ofc_cd.value = ar_ofc_cd;
		document.form.locl_curr_cd.value = arrStr[4];
		document.form.ar_ctrl_ofc_cd.value = arrStr[5];
		document.form.loc_cd.value = arrStr[6].substring(0,2);
		sheetObjects[0].RemoveAll();        
	}
	
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다.
	 */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
	
		comboValues = "|"+" "+comboValues;
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if ((comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1&&(comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboTxt);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboTxt);
		}
	}
	
	/**
	 * Customer Code 입력시 Customer Name을 가져온다.<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_cust_nm();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function fn_cust_nm(){
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "" )){
			form.cust_seq.value = ComLpad(form.cust_seq.value.trim(), 6, "0");			
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			if (cust_nm == undefined) {
				form.cust_nm.value="";
				ComShowCodeMessage("INV00008");
				form.cust_seq.value="";	
				form.cust_seq.focus();				
				return;
			} else { 	
				form.cust_nm.value=cust_nm;
			}
		}
	
	}
	
	/**
	 * 경리환율을 조회하여 입력한 항목과 비교한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   RateCheck(shhetObjects[0], 1, '0.1111');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */	
	function RateCheck(sheetObj, Row, Value) {
		
		var effDt = sheetObj.CellText(Row,"fm_dt").substring(0,7);
		document.form.eff_dt.value = ComReplaceStr(effDt,"-",""); 
		document.form.curr_cd.value = sheetObj.CellValue(Row,"chg_curr_cd");
			
		//20100226 정영한 DXBSC 일 경우 경리환율을 체크하는 로직 삭제. 즉 기간에 상관없이 입력 가능
		if(document.form.ar_ofc_cd.value=='DXBSC'){
			return 1;
		}else{			
			document.form.f_cmd.value = SEARCH04;
		
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
			var valRate = Value/usd_locl_xch_rt;
			
			if(usd_locl_xch_rt == "") {
				ComShowCodeMessage("INV00001",Row+" Line");
				return 0;
			} 
			
			if((valRate > 1.5) ||((valRate < 0.5))) {
				ComShowCodeMessage("INV00016",Row+" Line");
				return 0;
			} else {
				//2010-01-28 이상희 과장 삭제
				//if (fn_CheckDigit(sheetObj, Row, Value)== 0 ) {
				//	return 0;
				//} else {
				return 1;
				//}	
			}
		}
	
	}
	
	/**
	 * fm_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('20090101');
	 * </pre>
	 * @param String value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function fn_ComGetMaskedValue(value) {
	
		var value = form.fm_dt.value;
		value = ComReplaceStr(value,"-","");
		
		if (value=="") return;
		
		if (value.length < 6) {
			ComShowCodeMessage("INV00024");
			return;
		} 
	
		if (value.substring(4,6) > 12) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(4,6) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		var ret = ComGetMaskedValue(value, "ym")  ;     
		form.fm_dt.value = ret;
	}
	
	/**
	 * sheet 의 환율 입력시 checkdigit 하여 Validation 한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_CheckDigit(sheetObjects[0], 1, '0.1111');
	 * </pre>
	 * @param object sheetObj
	 * @param number row
	 * @param string Value
	 * @return number
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	
	/*2010-01-28 이상희 과장 삭제
	      function fn_CheckDigit(sheetObj, Row, Value) {
	    	  var digitVal = ComReplaceStr(ComReplaceStr(Value,".",""),"0",""); 
			  var digitNum = 0;
			  for (var i = 0; i < digitVal.length ; i++) {
				  digitNum = parseInt(digitNum) + parseInt(digitVal.substring(i,i+1));
			  }
	
			  if (digitNum != sheetObj.CellValue(Row,"check_digit")) {
				  ComShowCodeMessage("INV00023");
	
				  return 0;
			  }  else {
				  return 1;
			  }
	      }
	 */
	
	/**
	 * form.dispaly 체크박스에 따라 버튼을 세팅한다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_buttonChk();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function fn_buttonChk() {
		if (document.form.dispaly.checked) {
			form.exrate_btn.style.display = "";
		} else {
			form.dispaly.checked = false;
			form.exrate_btn.style.display = "none";
		}
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	}
	
	/**
	 * Sheet retrieve 종료시 Sheet산 Col Copy<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObjects[0],'');
	 * </pre>
	 * @param object sheetObj
	 * @param string ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){      		
		sheetObj.Copy2SheetCol(sheetObj,"inv_xch_rt","pre_inv_xch_rt") 
	}


/* 개발자 작업  끝 */