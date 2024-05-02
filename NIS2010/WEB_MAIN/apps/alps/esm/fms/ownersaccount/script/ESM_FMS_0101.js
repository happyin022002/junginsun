/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_FMS_0101.js
*@FileTitle : O/A Inquiry for Cancellation
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
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
	 * @author 
	 */

	/**
	 * @extends 
	 * @class ESM_FMS_0101 : ESM_FMS_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_FMS_0101() {
		this.processButtonClick			= processButtonClick;
		this.setSheetObject				= setSheetObject;
		this.loadPage					= loadPage;
		this.initSheet					= initSheet;
		this.initControl				= initControl;
		this.doActionIBSheet			= doActionIBSheet;
		this.obj_activate				= obj_activate;
		this.obj_deactivate				= obj_deactivate;
		this.obj_keypress				= obj_keypress;
		this.eng_keypress				= eng_keypress;
		this.obj_change					= obj_change;
		this.validateForm				= validateForm;
		this.setVslCd					= setVslCd;
		this.chkPeriod					= chkPeriod;
		this.setFocus					= setFocus;
		this.setServiceProviderInfo		= setServiceProviderInfo;
		this.setItemNm					= setItemNm;
	}
	
	/* 개발자 작업	*/

	// 공통전역변수 

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var prefix = "sheet_";
	
	//Action 정의
	var IBCANCEL		= 95;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
					fnReset();
					break;

				case "btn_cancel":
					
					if(validateForm(sheetObject,formObject,IBCANCEL)) {
						ComOpenPopup("ESM_FMS_0095.do?popup=yes&s_flg=ESM_FMS_0101", 1024, 590, "", "0,0,1,1,1,1", true);
					} 
					
					break;
					
				case "btn_vndr_pop":
					//ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setServiceProviderInfo', '0,0', true, true);
					ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 450, '2:supplier|4:splr_nm', '1,0,1,1,1', true);
					break;
					
				case "btn_csrDt1":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.csr_fr_dt, 'yyyy-MM-dd');
					break;
					
				case "btn_csrDt2":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(form.csr_to_dt, 'yyyy-MM-dd');
					break;
					
				case "item_name":
					ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=OW", 550, 455, "setItemNm", "0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0076");
					break;
					
				case "btn_vslPop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
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
		
		sheetObjects[0].ExtendLastCol = true;
		
		fnReset();
		initControl();
	}
	
	/**
	 * 조회조건 및 Sheet 초기화
	 */
	function fnReset() {
		var formObj		= document.form;
		var sheetObj	= sheetObjects[0];
		
		// 현재월
		var sysDate	= new Date();
		
		var tYear	= sysDate.getFullYear();
		var tMonth	= sysDate.getMonth()+1;
		var tDate	= sysDate.getDate();
		
		var toDate = ComLpad(tYear, 4, "0") + "-" + ComLpad(tMonth, 2, "0") + "-" + ComLpad(tDate, 2, "0");
		var beforeDate = ComGetDateAdd(toDate, 'Y', -3);
		
		// Sheet Object Initialization
		sheetObj.RemoveAll();
		
		// Search Condition Object Initialization
		formObj.supplier.value = "";
		formObj.splr_nm.value = "";
		formObj.csr_fr_dt.value = beforeDate;
		formObj.csr_to_dt.value = toDate;
		formObj.acct_itm_nm.value = "";
		formObj.acct_cd.value = "";
		formObj.acct_itm_seq.value = "";
		formObj.chk_item_name.disabled = true;
		formObj.chk_item_name.checked = true;
		formObj.vsl_cd.value = "";
		formObj.vsl_eng_nm.value = "";
		formObj.csr_no.value = "";
		
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:	  //sheetOACncl
				with (sheetObj) {
					
					// 높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone] // msPrevColumnMerge + msHeaderOnly
					MergeSheet =  msNone;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(false, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false);

					var HeadTitle = "||CSR Slip No.|O/A Item|VVD|Port|Invoice No.|Invoice Date|Currency|Amount|Description|Attch|Settlement|";

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					cnt = 0;
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	prefix + "ibflag");
					InitDataProperty(0, cnt++, dtCheckBox,		30,		daCenter,	false,	prefix + "chk");
					InitDataProperty(0, cnt++, dtData,			170,	daCenter,	false,	prefix + "csr_no",				false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			250,	daLeft,		false,	prefix + "acct_itm_nm",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "vvd_cd",				false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,	false,	prefix + "oa_loc_cd",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "to_inv_no",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			90,		daCenter,	false,	prefix + "oa_inv_dt",			false,	"",	dfDateYmd,	2, false, false);
					InitDataProperty(0, cnt++, dtData,			60,		daCenter,	false,	prefix + "csr_curr_cd",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData,			70,		daRight,	false,	prefix + "csr_amt",				false,	"",	dfFloat,	2, false, false);
					InitDataProperty(0, cnt++, dtData,			450,	daLeft,		false,	prefix + "csr_desc",			false,	"",	dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopup,			100,	daCenter,	false,	prefix + "atch_file_oa_lnk_cnt",false,	"",	dfNone,		0, true, true);
					InitDataProperty(0, cnt++, dtData,			120,	daCenter,	false,	prefix + "oa_stl_sts_cd",		false,	"",	dfNone,		0, false, false);
					
					//InitDataProperty(0, cnt++, dtHidden,        50,     daCenter,   false,	prefix + "atch_file_oa_lnk_id", false,  "", dfNone,     0, false, true);
					
					ShowButtonImage = 2;
					FocusAfterProcess = false;
				}
				break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj	IBSheet Object
	 * @param {int}	 sheetNo	 sheetObjects 배열에서 순번
	 **/
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate', form);	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('keypress'			, 'obj_keypress'  , form);	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		
		axon_event.addListenerForm  ('change',		'obj_change',	form);	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
		axon_event.addListenerFormat('focus',		'obj_activate',	form);
		
		axon_event.addListener      ('blur',		'obj_blur',			'csr_fr_dt', 'csr_to_dt');
		axon_event.addListener      ('keypress',	'engnum_keypress',	'vsl_cd', 'csr_no'); // 입력 시 영문 대문자/숫자만 입력하기
	}

	/**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,objNm,row) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:	// 조회
				if(objNm == "vsl_cd") {
					formObj.f_cmd.value = SEARCH01;
					
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
					var vslEngNm = ComGetEtcData(sXml, "vslEngNm");

					if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
						formObj.vsl_eng_nm.value = vslEngNm;
					} else {
						formObj.vsl_cd.value = "";
						// 존재하지 않는 Vessel Code입니다
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
						return;
					}
					
				} else if(objNm == "supplier") { // Supplier Onchange
					
					var param = "f_cmd=" + SEARCH02 + "&s_value=" + formObj.supplier.value;
					
					var sXml = sheetObjects[0].GetSaveXml("FMS_COMGS.do", param);
					var payTerm = ComGetEtcData(sXml, "pay_term");
					
					if(typeof payTerm != "undefined" && payTerm != "") {
						var tmpArr = payTerm.split(":");
						document.form.splr_nm.value = tmpArr[1];
						
					}else{
						formObj.supplier.value = "";
						// 존재하지 않는 Supplier입니다
						ComAlertFocus(formObj.supplier, ComGetMsg("FMS00006", "Supplier"));
						return;
					}
				} else {
					if(validateForm(sheetObj,formObj,sAction,objNm)) {
						formObj.f_cmd.value = SEARCH;
//						alert(FormQueryString(formObj)); return;
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0101GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
						
						if (sXml.length > 0) {
							sheetObj.LoadSearchXml(sXml);
						}
					}
				}
				break;
				
			case IBSEARCH_ASYNC01: // VVD Validation Check
				
				formObj.f_cmd.value = COMMAND01;
				
				var ibflag;
				
				for(var row=1; row<=sheetObj.LastRow; row++) {
					ibflag = sheetObj.CellValue(row, prefix + "ibflag");
					
					if(ibflag == "U") {
						
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0101GS.do?vvd_cd="+sheetObj.CellValue(row, prefix + "vvd") + "&f_cmd=" + formObj.f_cmd.value);
					}
					
					if(CoFmsShowXmlMessage(sXml) != "") {
						sheetObj.CellValue2(row, prefix + "vvd") = "";
						ComShowMessage(CoFmsShowXmlMessage(sXml));
						sheetObj.SelectCell(row, prefix + "vvd");
						return false;
					}
				}
				
				return true;
				break;
		}
	}
	
	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	/**
	 * HTML Control의 onblur이벤트에서 Effective Date의 Validation을 체크한다.<br>
	 **/
	function obj_deactivate(){
		
		if((event.srcElement.name == "supplier")) {
			ComChkObjValid(event.srcElement, true, false, false);
		} else {
			ComChkObjValid(event.srcElement);
		}
		
	}
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력가능하게 처리한다.<br>
	 **/
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
	 **/
	//* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
	function engnum_keypress() {
		//영대문자 자동변환
		ComKeyOnlyAlphabet('uppernum');
	}
	
	/**
	 * HTML Control의 onchange이벤트에서 Vessel Code, Location변경 시 Validtion을 체크하다.<br>
	 **/
	function obj_change() {
		var formObj = document.form;
//		alert("obj_change : " + event.srcElement.name);
		
		if(event.srcElement.name == "vsl_cd") {
			
			sheetObjects[0].RemoveAll();
			formObj.vsl_eng_nm.value = "";
			
			if(!ComIsEmpty(formObj.vsl_cd.value)) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "vsl_cd");
			} else {
				formObj.vsl_cd.value = "";
			}
			
		} else if(event.srcElement.name == "supplier") {
			sheetObjects[0].RemoveAll();
			formObj.splr_nm.value = "";
			
			if(!ComIsEmpty(formObj.supplier.value)) {
				
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH , "supplier");
			} else {
				formObj.supplier.value = "";
			}
		}
	}
	
	function obj_blur(){
		var formObj = document.form;

		if(!ComIsEmpty(formObj.csr_fr_dt) && !ComIsEmpty(formObj.csr_to_dt)) {
			if(!chkPeriod(formObj.csr_fr_dt, formObj.csr_to_dt)) {
				ComSetObjValue(formObj.csr_to_dt, "");
				setFocus("csr_to_dt");
			}
		}
		
	}
	
	/**
	 * 화면 폼입력값에 대한 Validation을 체크한다.<br>
	 */
	function validateForm(sheetObj,formObj,sAction,objNm){
		
		
		
		if(sAction == IBSEARCH) {
			
			if(!ComIsEmpty(formObj.csr_fr_dt) && ComIsEmpty(formObj.csr_to_dt)) {
				// msgs['COM132201'] = '{?msg1} is invalid.';
				ComShowCodeMessage("COM132201", "CSR Date");
				setFocus("csr_to_dt");
				return false;
			} else if (ComIsEmpty(formObj.csr_fr_dt) && !ComIsEmpty(formObj.csr_to_dt)) {
				// msgs['COM132201'] = '{?msg1} is invalid.';
				ComShowCodeMessage("COM132201", "CSR Date");
				setFocus("csr_fr_dt");
				return false;
			}
			
			if (!ComChkValid(formObj)) return false;
			
		} else if(sAction == IBCANCEL) {
			
			if(sheetObj.RowCount <= 0) {
				// msgs['FMS01230'] = 'Please operate Retrieve first.';
				ComShowCodeMessage("FMS01230");
				return false;
			}
			
			if(sheetObj.CheckedRows(prefix + "chk") == 0) {
				// msgs['COM14004'] = 'No Selected Row';
				ComShowCodeMessage("COM14004");
				return false;
			}
			
			// 조회된 전체의 체크된 Row 중 첫번째 Currency
			var strFirstChkRowsCurr = null;
			
			// 조회된 전체의 체크된 Row 중 첫번째 Currency를 구한다.
			for(var idx = 1; idx <= sheetObj.RowCount; idx++) {
				if(sheetObj.CellValue(idx, prefix + "chk")) {
					strFirstChkRowsCurr = sheetObj.CellValue(idx, prefix + "csr_curr_cd");
					break;
				}
			}
			
			// 체크된 Row중 서로 다른 Currency를 가진 Row가 있는지 찾아서 Return false;
			for(var idx = 1; idx <= sheetObj.RowCount; idx++) {
				if(sheetObj.CellValue(idx, prefix + "chk")) {
					
					if(strFirstChkRowsCurr != sheetObj.CellValue(idx, prefix + "csr_curr_cd")) {
						//msgs['COM12113'] = 'Please select {?msg1}';
						ComShowCodeMessage("COM12113", "the same type of currency");
						return false;
					} 
				}
			}
			
		}
		
		 return true;
	}

	/**
	 * Vessel Code 팝업창에서 선택한 Vessel정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
	}
	
	/**
	 * Effective Date obj_deactivate에서 호출
	 * Maximum duration 3년 처리
	 */
	function chkPeriod(fmDtObj, toDtObj) {
		
		var chkFlag = true;
		
		var fmDt	= ComReplaceStr(fmDtObj.value, "-", "");
		var toDt	= ComReplaceStr(toDtObj.value, "-", "");
		
		var tmpDt	= ComGetDateAdd(fmDt, 'Y', 3);
						
		if(ComChkPeriod(toDt, tmpDt) < 1){
			// msgs['COM132001'] = '{?msg1} exceeds maximum duration {?msg2}.';
			ComShowMessage(ComGetMsg("COM132001","Period","3 year"));
			chkFlag = false;
		}
		
		return chkFlag;
	}
	
	/**
	 * Move Focus in Object
	 */
	function setFocus(name) {
		ComSetFocus(eval("document.form."+name));
		eval("document.form."+name).select();
	}
	
	/**
	 * S/P Code의 Input Text에 Popup에서 설정한 S/P Code 및 S/P Name 를 셋팅한다.
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param sheetIdx
	 * @return
	 */
	function setServiceProviderInfo(aryPopupData, row, col, sheetIdx) {
		var formObj = document.form;
		formObj.supplier.value = aryPopupData[0][1];
		formObj.splr_nm.value = aryPopupData[0][2];

	}
	
	/**
	 * O/A Item 조회조건 CallBack Function.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setItemNm(aryPopupData, row, col, sheetIdx){
		
		var strAcctItmNm = "";
		var strAcctCd = "";
		var strAcctItmSeq = "";
				
		for (var i = 0; i < aryPopupData.length;i++ ) {
			strAcctItmNm += aryPopupData[i][2] + ",";
			strAcctCd += aryPopupData[i][3] + ",";
			strAcctItmSeq += aryPopupData[i][4] + ",";
		}
		
		if(aryPopupData.length > 0) {
			strAcctItmNm	= strAcctItmNm.substr(0,strAcctItmNm.length -1);
			strAcctCd		= strAcctCd.substr(0,strAcctCd.length -1);
			strAcctItmSeq	= strAcctItmSeq.substr(0,strAcctItmSeq.length -1);
		}
		
		form.acct_itm_nm.value = strAcctItmNm;
		form.acct_cd.value = strAcctCd;
		form.acct_itm_seq.value = strAcctItmSeq;
		
		form.chk_item_name.disabled = false;
		form.chk_item_name.checked = true;
	}

	/**
	 * Item 체크 해제
	 */	
	function setItemNameClear(){
		form.acct_itm_nm.value = "";
		form.acct_cd.value = "";
		form.acct_itm_seq.value = "";		
	}
		
	/**
	 * .<br>
	 * 
	 * @param {int} Row 행번호
	 * @param {int} Col 컬럼번호
	 */
	function sheetOACncl_OnPopupClick(sheetObj, Row, Col) {
		switch (sheetObj.ColSaveName(Col)) {

			case prefix + "atch_file_oa_lnk_cnt":
				var editable = "Y";

				var csrNo = sheetObj.CellValue(Row, prefix + "csr_no");

				fmsFileUploadPopUp(sheetObj, Row, editable, csrNo);
				break;

		}
	}

	/** 
	 * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 * @param {int} x 필수, X 좌표
	 * @param {int} y 필수, Y 좌표
	 * @return 없음
	 */   
	function sheetOACncl_OnMouseMove(sheetObj, button, shift, x, y){
		with(sheetObj){

			if(ColSaveName(MouseCol) == prefix + "atch_file_oa_lnk_cnt") {
				if(sheetObj.CellEditable(sheetObj.MouseRow, sheetObj.MouseCol)) {
					sheetObj.MousePointer = "Hand";
				} 
//				sheetObj.MousePointer = "Hand";
			} else {
				MousePointer = "Default";
			} 	
		}
	}
	
	
	/**
	 * FMS File Upload 팝업 오픈
	 */
	function fmsFileUploadPopUp(sheetObj, Row, edit_able, csr_no) {
		var atch_file_flet_lnk_id =  '';	 
		 
		atch_file_flet_lnk_id =  sheetObj.CellValue(Row, prefix + "atch_file_oa_lnk_id");	
		
		if (atch_file_flet_lnk_id == undefined || atch_file_flet_lnk_id == null || ComTrim(atch_file_flet_lnk_id) == ''){
			atch_file_flet_lnk_id = '';
		}
		if (csr_no == undefined || csr_no == null || ComTrim(csr_no) == ''){
			csr_no = '';
		}
		 		
		var param = "?atch_file_flet_lnk_id=" + atch_file_flet_lnk_id+
						 "&csr_no=" + csr_no +
						 "&edit_able=" + edit_able +
						 "&tab_gubun="+ prefix +
						 "&row=" + Row
						 ;					
		ComOpenPopup("/hanjin/ESM_FMS_0092.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
	}

	/* 개발자 작업  끝 */