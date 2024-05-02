/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0074.js
 *@FileTitle : (Korea)Security Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.23
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.09.23 최도순
 * 1.0 Creation
 * History
 * -------------------------------------------------------- 
 * 2011.12.05 권 민 [CHM-201114691] AR INV내  (Korea) Security Creation 기능 보완 요청
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
	 * @class FNS_INV_0074 : FNS_INV_0074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0074() {
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
	
	// 공통전역변수 추가	2011.12.08 By Kwon Min
	var totSheetRow	= 0;	// 총 시트 로우 갯수
	
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
		var sheetObject = sheetObjects[0];
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
		
				case "btn_new":
					sheetObject.RemoveAll();
					ComResetAll();
					break;
		
				case "btn_downexcel":
					sheetObject.Down2Excel(-1,false,false,true,'','',false,false,'',false,"DelChk");
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
		
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
		
				case "btn_copy":
					var Row = sheetObject.DataCopy();
					sheetObject.CellValue(Row,"scr_seq") = "";
					break;
		
				case "btn_del":
					//ComRowHideDelete(sheetObject, "DelChk");
					RowDelete(sheetObject, "DelChk");
					break; 
		
				case "btn_cust":
					var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y';
					var Row = 1;
					var Col = 1;
					ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
					break; 
				case "btn_custNm":
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
		document.form.cust_cnt_cd.focus();
	
		//initControl();
	
		ComBtnDisable("btn_copy");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_add");
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
				style.height = 380;
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
		
				var HeadTitle = "|Sel.|SEQ|Security|CURR|Amount|USD Amount|KRW Amount|FM Date|To Date|Remark||||||||| ";
				var headCount = ComCountHeadTitle(HeadTitle);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,    40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++, 	dtCheckBox, 40,daCenter, false, "DelChk");
				InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "scr_seq", 			false, 		"", 	dfNone, 		0, 	false, 	false);
				InitDataProperty(0, cnt++ , dtCombo,    120,    daLeft,  false,    "cust_scr_div_cd",  		true,     	"",     dfNone,			0, 	true, 	true);
				InitDataProperty(0, cnt++ , dtCombo,    60,    daCenter,  false,    "cr_curr_cd",      	true,     	"",     dfNone,			0, 	true, 	true);
				InitDataProperty(0, cnt++ , dtData,     110,    daRight,  false,    "cust_scr_amt",   true,     	"",     dfNullFloat,	2,	true,	true,	13);
				InitDataProperty(0, cnt++ , dtAutoSum,     110,     daRight,  false,    "cust_scr_usd_amt",    false,     	"",     dfNullFloat,	2,	false,	false,	8);
				InitDataProperty(0, cnt++ , dtAutoSum,     110,     daRight,  false,    "cust_scr_krw_amt",    false,     	"",     dfNullInteger,	0,	false,	false,	8);
		
				InitDataProperty(0, cnt++ , dtPopupEdit,    100,    daCenter,  false,    "scr_st_dt",    	true,    	"",     dfDateYmd,		0, 	true, 	true);
				InitDataProperty(0, cnt++ , dtPopupEdit,    100,    daCenter,  false,    "scr_end_dt",    	true,     	"",     dfDateYmd,		0, 	true, 	true);
				InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "scr_rmk",    			false,     	"",     dfNone,			0,	true,	true,	50);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cust_cnt_cd",    		true,      	"",     dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cust_seq",    		true,      	"",     dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cr_st_dt",    		false,      "",     dfDateYmd,		0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cr_end_dt",    		false,      "",     dfDateYmd,		0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cr_amt",    			false,      "",     dfNullFloat,	2,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "cr_curr",    			false,      "",     dfNone,			0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "ob_cr_term_dys",    	false,      "",     dfNullInteger,	0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "ib_cr_term_dys",    	false,      "",     dfNullInteger,	0,	false,	false);
				InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "ar_ofc_cd",    		false,      "",     dfNone,			0,	false,	false);
		
				InitDataCombo(0, "cust_scr_div_cd", "C: Credit Insurance|J: Joint Guarantee|B: Bill|G: Bank Guarantee|R: Real Estate|O: Other|P: Profit Bond|N: Non-Security", "C|J|B|G|R|O|P|N");
				InitDataCombo(0, "cr_curr_cd", "KRW|USD", "KRW|USD");
		
				PopupImage  =  "img/btns_calendar.gif";
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
	
			case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_INV_0074GS.do", FormQueryString(formObj));
				
				if(sheetObj.TotalRows != 0){	// 데이터가 있을 때만 처리 2011.12.08 By Kwon Min
					IBS_CopyRowToForm(sheetObj,formObj, 1,"frm_") ;
				
					formObj.frm_cr_st_dt.value = sheetObj.CellText(1,"cr_st_dt");
					formObj.frm_cr_end_dt.value = sheetObj.CellText(1,"cr_end_dt");
					formObj.frm_cr_amt.value = sheetObj.CellText(1,"cr_amt");
				}
				
				ComOpenWait(false);
			}
			
			// 조회된 로우 표시	2011.12.07 by Kwon Min 
			totSheetRow	= sheetObj.TotalRows;
			//alert("조회 totSheetRow : " + totSheetRow);
			break;
		
			case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0074GS.do", FormQueryString(formObj)); 
			ComOpenWait(false);
		
			break;
		
			case IBINSERT:      // 입력
			var sheetIdx = sheetObj.DataInsert(-1);
			
			// 기존 로우 수에 추가된 로우 수 더하기
			totSheetRow++;
			//alert("추가 totSheetRow : " + totSheetRow);
			sheetObj.CellValue(sheetIdx,"cust_cnt_cd") = formObj.cust_cnt_cd.value;
			sheetObj.CellValue(sheetIdx,"cust_seq") = formObj.cust_seq.value;
			sheetObj.CellValue(sheetIdx,"ar_ofc_cd") = formObj.frm_ar_ofc_cd.value;
			sheetObj.CellValue(sheetIdx,"scr_st_dt") = ComGetNowInfo("ymd");
			sheetObj.CellValue(sheetIdx,"scr_end_dt") = ComGetNowInfo("ymd");
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
				case IBSEARCH:        //조회				
		
				if( formObj.cust_cnt_cd.value.trim() == "") {
					ComShowCodeMessage("INV00004");
					formObj.cust_cnt_cd.focus();
					return;
				} 
		
				if( formObj.cust_seq.value.trim() == "") {
					ComShowCodeMessage("INV00004");
					formObj.cust_seq.focus();
					return;
				} 
		
				break;
		
				case IBSAVE:        //저장
				var usdAmt = 0 ;
				var krwAmt = 0 ;
				var T=Number('1e'+1);
				
				var crFlg			= formObj.cr_flg.value;
				var frmCrStDt		= formObj.frm_cr_st_dt.value;
				var frmCrEndDt		= formObj.frm_cr_end_dt.value;
				
				if(crFlg == 'N' || frmCrStDt == '' || frmCrEndDt == ''){
					ComShowCodeMessage("INV00152");
					return;
				}
				
				// 저장 시 Grid To Date 와 Credit FM/TO 에서 TO Date 와 비교 후 다른 Date Count 2011.12.05 By Kwon Min 
				var dateCheckCnt	= 0;

				if(totSheetRow != 0){	// 전체 로우가 0 이 아닐 때만 validation check
					for (var i=1; i<=sheetObj.RowCount; i++) {
			
						if(sheetObj.RowStatus(i) != "D"){
							if( sheetObj.CellValue(i,"scr_st_dt").replace("-","")<=formObj.frm_cr_end_dt.value.replace("-","") &&
									sheetObj.CellValue(i,"scr_end_dt").replace("-","") >=formObj.frm_cr_st_dt.value.replace("-","")){
								if(document.form.frm_cr_curr.value=="USD"){
									usdAmt = usdAmt + parseFloat(sheetObj.CellValue(i,"cust_scr_usd_amt"));
								}else if(document.form.frm_cr_curr.value=="KRW"){
									krwAmt = krwAmt + parseFloat(sheetObj.CellValue(i,"cust_scr_krw_amt"));
								}
							}
						}
	
						// 기존 Insert 상태에만 check 하던 것을 Update 상태에도 check - 2011.12.05 by Kwon Min
						if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U") {
							var fmDt = sheetObj.CellText(i,"scr_st_dt");
							var toDt = sheetObj.CellText(i,"scr_end_dt");
							if(fmDt==""){
								ComShowCodeMessage("INV00004");
								sheetObj.SelectCell(i,"scr_st_dt");
								return;
							}
							if (toDt==""){
								ComShowCodeMessage("INV00004");
								sheetObj.SelectCell(i,"scr_end_dt");
								return;
							}
							if (fmDt > toDt) {
								ComShowCodeMessage("INV00024");
								return;
							}
							
							// Grid To Date 와 Credit FM/TO 에서 TO Date 와 비교 후 다르면 ++ 2011.12.05 By Kwon Min
							// 2011.12.13 첫번째 담보만 체크
							if(i == 1){	
								if(frmCrEndDt != toDt){
									dateCheckCnt++;
								}
							}
							
							if(sheetObj.CellValue(i,"cr_curr_cd")=="USD"){
								RateCheck2(sheetObj, i, "");
							}else if(sheetObj.CellValue(i,"cr_curr_cd")=="KRW"){
								RateCheck(sheetObj, i, "");
							}
						} 
			
					}
				
					// 2011.12.05 By Kwon Min
					if(dateCheckCnt > 0){
						ComShowCodeMessage("INV00151");
						return;
					}
					
					var sVal = (usdAmt)* T / T;
					var sVal2 = (krwAmt)* T / T;
					var posV = Math.pow(10, 2)
					sVal = Math.round(sVal*posV)/posV;	      
			
					if(document.form.frm_cr_curr.value=="USD"){
						if(sVal != formObj.frm_cr_amt.value.replace(/,/g,"")){
							ComShowCodeMessage("INV00081");
							return;
						}
					}else if(document.form.frm_cr_curr.value=="KRW"){
						if(sVal2 != formObj.frm_cr_amt.value.replace(/,/g,"")){
							ComShowCodeMessage("INV00081");
							return;
						}
					}
				}
				break;
			}
		}     
	
		return true;
	}
	
	
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		with(sheetObj){
			var sName = ColSaveName(Col);

			if(sName == "scr_st_dt"){
				var cal = new ComCalendarGrid("scr_st_dt");
				cal.endFunction ="ComCalendar_tmpEndFunction2";
				cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
			}
			if(sName == "scr_end_dt"){
				var cal2 = new ComCalendarGrid("scr_end_dt");
				// To Date 입력 시 FM Date 와 크기 비교 2011.12.05 By Kwon Min
				cal2.endFunction ="ComCalendar_compareFunction";
				cal2.select(sheetObj, Row, Col, 'yyyy-MM-dd');					
			}	
		}		
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			ComBtnEnable("btn_copy");
			ComBtnEnable("btn_del");			
		}
	
		ComBtnEnable("btn_add");
	}
	
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}
	
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		var sName = sheetObj.ColSaveName(Col);
		
		if(sName == "cr_curr_cd"||sName == "cust_scr_amt"||sName == "scr_st_dt"){
			if(sheetObj.CellValue(Row,"cr_curr_cd")=="KRW"&&sheetObj.CellValue(Row,"cust_scr_amt")!=""){
				RateCheck(sheetObj, Row, Value);
				sheetObj.CellValue(Row,"cust_scr_krw_amt") = sheetObj.CellValue(Row,"cust_scr_amt");
			}
			if(sheetObj.CellValue(Row,"cr_curr_cd")=="USD"){
				RateCheck2(sheetObj, Row, Value);
				sheetObj.CellValue(Row,"cust_scr_usd_amt") = sheetObj.CellValue(Row,"cust_scr_amt");
			}
		}
		if (sName == "scr_st_dt"){
			sheetObj.SelectCell(Row, "scr_end_dt",true,Value) 
		}
	
	}
	
	function RateCheck(sheetObj, Row, Value) {
		document.form.f_cmd.value = SEARCH04;
	
		var effDt = sheetObj.CellText(Row,"scr_st_dt").substring(0,7);
		document.form.eff_dt.value = ComReplaceStr(effDt,"-",""); 
		document.form.curr_cd.value = "KRW";
		document.form.locl_curr_cd.value = "USD";
	
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
	
		if(usd_locl_xch_rt ==""){
			ComShowCodeMessage("INV00001");
		}
	
		sheetObj.CellValue(Row,"cust_scr_usd_amt") = usd_locl_xch_rt*parseFloat(sheetObj.CellValue(Row,"cust_scr_amt"));		 	
	}
	
	function RateCheck2(sheetObj, Row, Value) {
		document.form.f_cmd.value = SEARCH04;
	
		var effDt = sheetObj.CellText(Row,"scr_st_dt").substring(0,7);
		document.form.eff_dt.value = ComReplaceStr(effDt,"-",""); 
		document.form.curr_cd.value = "USD";
		document.form.locl_curr_cd.value = "KRW";
	
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
	
		if(usd_locl_xch_rt ==""){
			ComShowCodeMessage("INV00001");
		}
	
		sheetObj.CellValue(Row,"cust_scr_krw_amt") = usd_locl_xch_rt*parseFloat(sheetObj.CellValue(Row,"cust_scr_amt"));		 	
	}
	
	function ComCalendar_tmpEndFunction2(){
		sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, "scr_end_dt",true, sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"scr_st_dt")); 
	
		if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cr_curr_cd")=="KRW"&&sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"cust_scr_locl_amt")!=""){
			RateCheck(sheetObjects[0], sheetObjects[0].SelectRow, "");
		}
	}
	
	// FM Date 와 To Date 비교 Function 2011.12.05 By Kwon Min
	function ComCalendar_compareFunction(){
		var scrStDt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"scr_st_dt");
		var scrEndDt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"scr_end_dt");
		
		if(scrStDt > scrEndDt){
			ComShowCodeMessage("INV00024");
			// 잘못 입력했으로 FM Date 로 입력
			sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, "scr_end_dt",true, sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"scr_st_dt"));
			return;
		}
	}
	
	//actual cust change 후 이벤트 처리 
	function fn_cust_chg(){
		if(form.cust_seq.value!=''){
			form.cust_seq.value = ComLpad(form.cust_seq.value.trim(), 6, "0");
		} 
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		var frm_ar_ofc_cd = "";
		var frm_cr_st_dt = "";
		var frm_cr_end_dt = "";
		var frm_cr_curr = "";
		var frm_cr_amt = "";
		var frm_ob_cr_term_dys = "";
		var frm_ib_cr_term_dys = "";
		var frm_cr_flg = "";
		
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			frm_ar_ofc_cd = ComGetEtcData(sXml,"cr_clt_ofc_cd");
			frm_cr_st_dt = ComGetEtcData(sXml,"cr_st_dt");
			frm_cr_end_dt = ComGetEtcData(sXml,"cr_end_dt");
			frm_cr_curr = ComGetEtcData(sXml,"cr_curr_cd");
			frm_cr_amt = ComGetEtcData(sXml,"cr_amt");
			frm_ob_cr_term_dys = ComGetEtcData(sXml,"ob_cr_term_dys");
			frm_ib_cr_term_dys = ComGetEtcData(sXml,"ib_cr_term_dys");
			cr_flg = ComGetEtcData(sXml,"cr_flg");
			
			if (cust_nm == undefined) {
				form.cust_lgl_eng_nm.value="";
				form.cust_seq.value="";
				form.frm_ar_ofc_cd.value="";    
				form.frm_cr_st_dt.value="";    
				form.frm_cr_end_dt.value="";    
				form.frm_cr_curr.value="";    
				form.frm_cr_amt.value="";    
				form.frm_ob_cr_term_dys.value="";    
				form.frm_ib_cr_term_dys.value="";
				ComShowCodeMessage("INV00008");
				form.cust_cnt_cd.focus();
				return;   	    		  
			}else{
				form.cust_lgl_eng_nm.value=cust_nm;
				form.frm_ar_ofc_cd.value=frm_ar_ofc_cd;
				form.frm_cr_st_dt.value=ComGetMaskedValue(frm_cr_st_dt, "ymd");    
				form.frm_cr_end_dt.value=ComGetMaskedValue(frm_cr_end_dt, "ymd"); 
				form.frm_cr_curr.value=frm_cr_curr;    
				form.frm_cr_amt.value=ComAddComma(frm_cr_amt);    
				form.frm_ob_cr_term_dys.value=frm_ob_cr_term_dys;    
				form.frm_ib_cr_term_dys.value=frm_ib_cr_term_dys;
				form.cr_flg.value=cr_flg;
				
				// customer 조회 후 하단 정보 동시 조회 처리 2011.12.05 by Kwon Min
				var sheetObject	= sheetObjects[0];
				var formObject	= document.form;
				
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				
				// customer 조회 후 비신용 화주 이면 에러메시지 띄워준다. 
				// CR_FLG 가 'N' 라도 Credit FM/TO 값이 없으면 에러메시지 띄워준다. 2011.12.05 by Kwon Min
				//alert(form.cr_flg.value + " | " + form.frm_cr_st_dt.value + " | " + form.frm_cr_end_dt.value);
				if(form.cr_flg.value == 'N' || form.frm_cr_st_dt.value == '' || form.frm_cr_end_dt.value == ''){
					ComShowCodeMessage("INV00152");
				}
			}
		}
	}   
	
	function checkCustLeng(value){    	  
		if(value.length==2){
			form.cust_seq.focus(); 
		}
	}
	
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.cust_cnt_cd.value = colArray[8];
		document.form.cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_cust_chg();
	}
	

	// ComRowHideDelete 함수에 총계 처리 부분이 없어서 생성	2011.12.06 By Kwon Min
	function RowDelete(sheetObj, col, isMsg){
		
		if (isMsg==undefined || isMsg==null) isMsg = true;
		var org_col = col;

		//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
		col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);

		//컬럼 인자의 유효성 확인하기
		if (col< 0 || col > sheetObj.LastCol) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
			return -1;
		}
		
		//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
		var sRow = sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		
		//가져온 행을 배열로 만들기 
		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
		
		sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

		//기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
		if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
			}
		} else {
			//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row = arrRow[idx];

				if(sheetObj.RowStatus(row) == "U" || sheetObj.RowStatus(row) == "I"){	// totSheetRow 감소
					totSheetRow--;
				}
				
				sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowSumable(row) = false;	//3.합계에서 제외	2011.12.06 추가 By Kwon Min
				sheetObj.RowStatus(row)= "D";		//4.트랜잭션 상태 "삭제"로 만들기
			}
			//alert("삭제 totSheetRow : " + totSheetRow);
		}

		sheetObj.RedrawSum = true;	//합계 계산하기
		
		return arrRow.length-1;
	}
/* 개발자 작업  끝 */