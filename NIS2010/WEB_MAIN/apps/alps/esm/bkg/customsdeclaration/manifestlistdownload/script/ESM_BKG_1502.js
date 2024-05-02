/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_1502.js
*@FileTitle : B/L Inquiry(Japan 24HR)
*Open Issues :
*Change history :
*	2017.08.08 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.08.08
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2013.07.05 김상수
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
	 * @class ESM_BKG_1502 : ESM_BKG_1502 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1502() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
		this.frmObj_OnChange    = frmObj_OnChange;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;

	var searchCount = 0;    // 최초조회인지 알기위하여 사용됨
	var saveCount = 0;    // 저장여부를 알기위하여 사용됨


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {

				case "btn_shpr":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "shpr");
				break;

				case "btn_cnee":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "cnee");
				break;

				case "btn_ntfy":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "ntfy");
				break;

				case "tab2btn_rowadd":
					var newRowIdx = shtObj.DataInsert(-1);
					shtObj.CellValue2(newRowIdx, "bl_no") = frmObj.org_bl_no.value;
					shtObj.SelectCell(newRowIdx, "cntr_no");
				break;

				case "tab2btn_delete":
					ComRowHideDelete(shtObj, "del_chk");
				break;

				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;

				case "btn_new":
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					frmObj.pod_split_no.className = "input";
					frmObj.pod_split_no.disabled = false;
					ComResetAll();
					shtObj.RemoveEtcData();
					sheetObjects[1].RemoveEtcData();

				break;

				case "btn_save":
					// shipper의 전화번호, 국가코드, 이름, 주소를 필수값으로 설정
					// notify의 전화번호, 국가코드, 이름, 주소를 필수값으로 설정
					// consignee의 이름을 필수 값으로 설정
					frmObj.shpr_phn_no.setAttribute("required", "");
					frmObj.ntfy_phn_no.setAttribute("required", "");
					frmObj.shpr_cnt_cd.setAttribute("required", "");
					frmObj.ntfy_cnt_cd.setAttribute("required", "");
					frmObj.shpr_nm.setAttribute("required", "");
					frmObj.cnee_nm.setAttribute("required", "");
					frmObj.ntfy_nm.setAttribute("required", "");
					frmObj.shpr_addr.setAttribute("required", "");
					frmObj.ntfy_addr.setAttribute("required", "");
					
					doActionIBSheet(shtObj, frmObj, IBSAVE);
					
					// T/Status, 삭제 코드, 삭제 사유의 필수값 설정 해제
					// shipper의 전화번호, 국가코드, 이름, 주소의 필수값 설정 해제
					// notify의 전화번호, 국가코드, 이름, 주소의 필수값 설정 해제
					// consignee의 이름의 필수값 설정 해제
					frmObj.t_cmr_kind.removeAttribute("required");
					frmObj.del_cd.removeAttribute("required");
					frmObj.del_reason.removeAttribute("required");
					frmObj.shpr_phn_no.removeAttribute("required");
					frmObj.ntfy_phn_no.removeAttribute("required");
					frmObj.shpr_nm.removeAttribute("required");
					frmObj.cnee_nm.removeAttribute("required");
					frmObj.ntfy_nm.removeAttribute("required");
					frmObj.shpr_addr.removeAttribute("required");
					frmObj.ntfy_addr.removeAttribute("required");
				break;

				case "btn_transmit":
					frmObj.t_cmr_kind.setAttribute("required", "");
					doActionIBSheet(shtObj, frmObj, COMMAND01);
					frmObj.t_cmr_kind.removeAttribute("required");
				break;

				case "btn_new_transmit":
					// T/Status를 필수값으로 설정
					frmObj.t_cmr_kind.setAttribute("required", "");
					
					
					if(frmObj.t_cmr_kind.value == 1) {
						// 삭제 코드를 필수값으로 설정
						frmObj.del_cd.setAttribute("required", "");
					}
					
					
					if(frmObj.del_cd.value == 5 && frmObj.t_cmr_kind.value == 1) {
						// 삭제 사유를 필수값으로 설정
						frmObj.del_reason.setAttribute("required", "");
					}
					
					// shipper의 전화번호, 국가코드, 이름, 주소를 필수값으로 설정
					// notify의 전화번호, 국가코드, 이름, 주소를 필수값으로 설정
					// consignee의 이름을 필수 값으로 설정
					frmObj.shpr_phn_no.setAttribute("required", "");
					frmObj.ntfy_phn_no.setAttribute("required", "");
					frmObj.shpr_cnt_cd.setAttribute("required", "");
					frmObj.ntfy_cnt_cd.setAttribute("required", "");
					frmObj.shpr_nm.setAttribute("required", "");
					frmObj.cnee_nm.setAttribute("required", "");
					frmObj.ntfy_nm.setAttribute("required", "");
					frmObj.shpr_addr.setAttribute("required", "");
					frmObj.ntfy_addr.setAttribute("required", "");
					
					doActionIBSheet(shtObj, frmObj, COMMAND11);
					
					// T/Status, 삭제 코드, 삭제 사유의 필수값 설정 해제
					// shipper의 전화번호, 국가코드, 이름, 주소의 필수값 설정 해제
					// notify의 전화번호, 국가코드, 이름, 주소의 필수값 설정 해제
					// consignee의 이름의 필수값 설정 해제
					frmObj.t_cmr_kind.removeAttribute("required");
					frmObj.del_cd.removeAttribute("required");
					frmObj.del_reason.removeAttribute("required");
					frmObj.shpr_phn_no.removeAttribute("required");
					frmObj.ntfy_phn_no.removeAttribute("required");
					frmObj.shpr_nm.removeAttribute("required");
					frmObj.cnee_nm.removeAttribute("required");
					frmObj.ntfy_nm.removeAttribute("required");
					frmObj.shpr_addr.removeAttribute("required");
					frmObj.ntfy_addr.removeAttribute("required");
				break;
				
				case "btn_close":   // close
					if (saveCount > 0) {
						// 저장이 한번이라도 되었으면 부모창 재조회
						var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
						opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, SEARCH01);
					}
					window.close();
				break;

			} // end switch

//		} catch(e) {
//			if (e == "[object Error]") {
//				ComShowMessage(OBJECT_ERROR);
//			} else {
//				ComShowMessage(e);
//			}
//		}
	}


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tabObj){
		tabObjects[tabCnt++] = tabObj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var k=0; k<tabObjects.length; k++){
			initTab(tabObjects[k], k+1);
		}
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		document.form.t_cmr_kind.value = tCmrKind;    // JSP에서 선언된 전역변수
		document.form.pol_split_no.value = polSplitNo;    // JSP에서 선언된 전역변수
		document.form.pod_split_no.value = podSplitNo;    // JSP에서 선언된 전역변수

		ComBtnDisable("btn_save");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_new_transmit")
		ComBtnDisable("tab2btn_rowadd");
		ComBtnDisable("tab2btn_delete");

		initControl();

		if (document.form.bl_no.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}


	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		with (tabObj) {
			var cnt = 0 ;
			InsertTab(cnt++, " Customer ", -1);
			InsertTab(cnt++, " Container ", -1);
			InsertTab(cnt++, " Marks & Desc ", -1);
		}
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		var cnt = 0;
		with (shtObj) {

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			document.form.pagerows.value = 500;

			// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
			InitHeadMode(true, false, true, true, false, false);

			// Enter키를 눌렀을때 Tab키처럼 작동
			EditEnterBehavior = "tab";

			// Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
			InitComboNoMatchText(true);

			ShowButtonImage = 3;
			WaitImageVisible = false;
			CountPosition = 0;

			switch (shtObj.id) {

				case "tab2sheet1":
					// 높이 설정
					style.height = GetSheetHeight(12);;

					// 전체 너비 설정
					SheetWidth = tab2MainTable.clientWidth;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 13, 500);
					document.form.pagerows.value = 500;

					// 컬럼 헤더타이틀
					var HeadTitle = "|Sel.|Seq.|Container|Type|Seal No.|P|R / D|R / D|Empty/Full|Supplied|bl_no";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtDummyCheck,   40,     daCenter,    false,    "del_chk");
					InitDataProperty(0, cnt++, dtSeq,          40,     daCenter,    false,    "seq");
					InitDataProperty(0, cnt++, dtData,         130,    daCenter,    false,    "cntr_no",            true,     "",      dfNone,    0,     true,    true,    14);
					InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "cntr_tpsz_cd",       false,    "",      dfNone,    0,     true,    true,    2);
					InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "cntr_seal_no",       false,    "",      dfNone,    0,     true,    true,    20);
					InitDataProperty(0, cnt++, dtCombo,        50,     daCenter,    false,    "prt_flg");
					InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "rcv_term_cd",        false,    "",      dfNone,    0,     true,    true,    1);
					InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "de_term_cd",         false,    "",      dfNone,    0,     true,    true,    1);
					InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "full_mty_cd");
					InitDataProperty(0, cnt++, dtCombo,        100,    daCenter,    false,    "jp_cntr_ownr_cd");

					InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    false,    "bl_no");

					InitDataValid(0, "cntr_no", vtEngUpOther, "0123456789");
					InitDataValid(0, "cntr_tpsz_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "cntr_seal_no", vtEngUpOther, "0123456789");
					InitDataValid(0, "rcv_term_cd", vtEngUpOther);
					InitDataValid(0, "de_term_cd", vtEngUpOther);
					InitDataCombo(0, "prt_flg", "N|Y", "N|Y", "N", "N");
					InitDataCombo(0, "full_mty_cd", "Empty|Full", "E|F", "Empty", "E");
					InitDataCombo(0, "jp_cntr_ownr_cd", "Shipper|Carrier", "1|2", "Shipper", "1");

					CountPosition = 0;
					WaitImageVisible = false;
					HeadRowHeight = 24;
				break;

				case "tab3sheet1":    // Hidden
					// 높이 설정
					style.height = 0;

					// 전체 너비 설정
					SheetWidth = tab3MainTable.clientWidth;

					// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
					InitRowInfo(1, 1, 3, 500);
					document.form.pagerows.value = 500;

					// 컬럼 헤더타이틀
					var HeadTitle = "|bl_no|bl_seq|cmdt_hs_cd|diff_rmk|bl_desc";

					// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

					// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// Enter키를 눌렀을때 Tab키처럼 작동
					EditEnterBehavior = "tab";

					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,    40,     daCenter,    false,    "ibflag");    // [필수]
					InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "bl_no");
					InitDataProperty(0, cnt++, dtData,      50,     daCenter,    false,    "bl_seq");
					InitDataProperty(0, cnt++, dtData,      80,     daCenter,    false,    "cmdt_hs_cd");
					InitDataProperty(0, cnt++, dtData,      200,    daCenter,    false,    "diff_rmk");
					InitDataProperty(0, cnt++, dtData,      200,    daCenter,    false,    "bl_desc");
				break;
			}
		}
	}


	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);    // 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case IBSEARCH:    // 조회
				if (!ComChkValid(frmObj)) return;
				ComOpenWait(true);
				var tempBlNo = frmObj.bl_no.value;
				var tempTCmrKind = frmObj.t_cmr_kind.value;
				var tempDelCd = frmObj.del_cd.value;
				var tempDelReason = frmObj.del_reason.value;
				var tempPolSplitNo = frmObj.pol_split_no.value;
				var tempPodSplitNo = frmObj.pod_split_no.value;
				var tempDelTrasmitFlag = frmObj.del_trasmit_flag.value;

				frmObj.f_cmd.value = SEARCH;
				var xmlArr = shtObj.GetSearchXml("ESM_BKG_1502GS.do", FormQueryString(frmObj)).split("|$$|");
				ComResetAll();    //기본 object 초기화
				shtObj.RemoveEtcData();
				sheetObjects[1].RemoveEtcData();

				if (ComGetEtcData(xmlArr[0], "TRANS_RESULT_KEY") == "F") {
					shtObj.LoadSearchXml(xmlArr[0]);
				} else if (parseInt(ComGetEtcData(xmlArr[0], "data_rows")) < 1) {
					ComShowCodeMessage("COM130401");    // There is no data to search.
				} else if (ComGetEtcData(xmlArr[1], "TRANS_RESULT_KEY") == "F") {
					sheetObjects[1].LoadSearchXml(xmlArr[1]);
				} else {
					shtObj.LoadSearchXml(xmlArr[0]);
					sheetObjects[1].LoadSearchXml(xmlArr[1]);
				}
				frmObj.bl_no.value = tempBlNo;
				frmObj.org_bl_no.value = tempBlNo;
				frmObj.t_cmr_kind.value = tempTCmrKind;
				frmObj.del_cd.value = tempDelCd;
				frmObj.del_reason.value = tempDelReason;
				frmObj.pol_split_no.value = tempPolSplitNo;
				frmObj.pod_split_no.value = tempPodSplitNo;
				frmObj.del_trasmit_flag.value = tempDelTrasmitFlag;
				ComOpenWait(false);
			break;

			case SEARCH01:     // Customer 정보 조회
				if (frmObj[CondParam + "_cnt_cd"].value == "") {
					ComSetFocus(frmObj[CondParam + "_cnt_cd"]);
					return;
				} else if (frmObj[CondParam + "_seq"].value == "") {
					ComSetFocus(frmObj[CondParam + "_seq"]);
					return;
				}
				var xmlStr = shtObj.GetSearchXml("ESM_BKG_1502GS.do", "f_cmd=" + SEARCH01 + "&cust_cnt_cd=" + frmObj[CondParam + "_cnt_cd"].value + "&cust_seq=" + frmObj[CondParam + "_seq"].value);
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
					shtObj.LoadSearchXml(xmlStr);
				} else {
					var custNm = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
					var custAddr = ComGetEtcData(xmlStr, "bzet_addr");
					if (custNm != undefined) frmObj[CondParam + "_nm"].value = custNm;
					if (custAddr != undefined) frmObj[CondParam + "_addr"].value = custAddr;
				}
			break;

			case IBSAVE:    // 저장
				var cnee_name = frmObj.cnee_nm.value.toUpperCase().replace(/ /g,'');
				var cnee_phn_val = ComTrimAll(frmObj.cnee_phn_no.value," ","-",".");
				var shpr_phn_val = ComTrimAll(frmObj.shpr_phn_no.value," ","-",".");
				var ntfy_phn_val = ComTrimAll(frmObj.ntfy_phn_no.value," ","-",".");
				var cnee_phn_cpt = frmObj.cnee_phn_no.getAttribute("caption");
				var shpr_phn_cpt = frmObj.shpr_phn_no.getAttribute("caption");
				var ntfy_phn_cpt = frmObj.ntfy_phn_no.getAttribute("caption");	
				
				// Consignee Name이 To Order가 아닌 경우
				if (cnee_name.indexOf('TOORDER') < 0 ) {
					if (cnee_phn_val == ""){
						// Consignee Phone Number를 필수값으로 설정
						frmObj.cnee_phn_no.setAttribute("required", "");
					} else if ( isNaN(cnee_phn_val) ) {
						// Consignee Phone Number가 숫자가 아닌 경우 알림
						ComShowCodeMessage('BKG06012', cnee_phn_cpt);
						frmObj.cnee_phn_no.value = "";
						frmObj.cnee_phn_no.focus();
						return false;
					} else if (frmObj.cnee_addr.value == "") {
						// Consignee Address를 필수값으로 설정
						frmObj.cnee_addr.setAttribute("required", "");
					} else if (frmObj.cnee_cnt_cd.value == "") {
						// Consignee Country Code를 필수값으로 설정
						frmObj.cnee_cnt_cd.setAttribute("required", "");
					}
				// Consignee Name이 To Order인 경우
				} else {
					// Consinee Phone Number, Address, Country Code의 필수값 지정 해제 
					frmObj.cnee_phn_no.removeAttribute("required");
					frmObj.cnee_addr.removeAttribute("required");
					frmObj.cnee_cnt_cd.removeAttribute("required");
				}
				
				// Shipper Phone Number가 숫자가 아닌 경우 알림
				if (isNaN(shpr_phn_val)) {
					ComShowCodeMessage('BKG06012', shpr_phn_cpt);
					frmObj.shpr_phn_no.value = "";
					frmObj.shpr_phn_no.focus();
					return false;
				// Notify Phone Number가 숫자가 아닌 경우 알림
				} else if (isNaN(ntfy_phn_val)) {
					ComShowCodeMessage('BKG06012', ntfy_phn_cpt);
					frmObj.ntfy_phn_no.value = "";
					frmObj.ntfy_phn_no.focus();
					return false;
				}				
				
				if (!ComChkValid(frmObj)) return;
				var shtObj2 = sheetObjects[1];
				if (frmObj.onchange_flag.value != "Y" && !shtObj.IsDataModified && !shtObj2.IsDataModified) {
					ComShowCodeMessage("COM130503");    // "There is no updated data to save."
					return;
				}
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				if (shtObj.RowCount > 0 && shtObj.GetSaveString(true) == "") {    // Sheet1의 Mandatory Check 용도
					if (tabObjects[0].SelectedIndex != 1) tabObjects[0].SelectedIndex = 1;
					return;
				}
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI01;
				frmObj.bl_no.value = frmObj.org_bl_no.value;    // 저장 전 사용자 실수를 막기 위하여, 조회되었던 bl_no로 원복
				var saveStringArr = new Array();
				saveStringArr[0] = ComSetPrifix(shtObj.GetSaveString(), "container_");
				saveStringArr[1] = ComSetPrifix(shtObj2.GetSaveString(), "markdesc_");
				shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_BKG_1502GS.do", FormQueryString(frmObj) + "&" + saveStringArr[0] + "&" + saveStringArr[1]));
				ComOpenWait(false);
			break;

			case COMMAND01:    // EDI Transmit
				if (!ComChkValid(frmObj)) return;
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				frmObj.bl_no.value = frmObj.org_bl_no.value;    // 저장 전 사용자 실수를 막기 위하여, 조회되었던 bl_no로 원복
				var xmlStr = shtObj.GetSaveXml("ESM_BKG_1502GS.do", FormQueryString(frmObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;

			case COMMAND11:    // New_EDI Transmit
				var cnee_name = frmObj.cnee_nm.value.toUpperCase().replace(/ /g,'');
				var cnee_phn_val = ComTrimAll(frmObj.cnee_phn_no.value," ","-",".");
				var shpr_phn_val = ComTrimAll(frmObj.shpr_phn_no.value," ","-",".");
				var ntfy_phn_val = ComTrimAll(frmObj.ntfy_phn_no.value," ","-",".");
				var cnee_phn_cpt = frmObj.cnee_phn_no.getAttribute("caption");
				var shpr_phn_cpt = frmObj.shpr_phn_no.getAttribute("caption");
				var ntfy_phn_cpt = frmObj.ntfy_phn_no.getAttribute("caption");	
	
				// Consignee Name이 To Order가 아닌 경우
				if (cnee_name.indexOf('TOORDER') < 0 ) {
					if (cnee_phn_val == ""){
						// Consignee Phone Number를 필수값으로 설정
						frmObj.cnee_phn_no.setAttribute("required", "");
					} else if ( isNaN(cnee_phn_val) ) {
						// Consignee Phone Number가 숫자가 아닌 경우 알림
						ComShowCodeMessage('BKG06012', cnee_phn_cpt);
						frmObj.cnee_phn_no.value = "";
						frmObj.cnee_phn_no.focus();
						return false;
					} else if (frmObj.cnee_addr.value == "") {
						// Consignee Address를 필수값으로 설정
						frmObj.cnee_addr.setAttribute("required", "");
					} else if (frmObj.cnee_cnt_cd.value == "") {
						// Consignee Country Code를 필수값으로 설정
						frmObj.cnee_cnt_cd.setAttribute("required", "");
					}
				// Consignee Name이 To Order인 경우
				} else {
					// Consinee Phone Number, Address, Country Code의 필수값 지정 해제 
					frmObj.cnee_phn_no.removeAttribute("required");
					frmObj.cnee_addr.removeAttribute("required");
					frmObj.cnee_cnt_cd.removeAttribute("required");
				}
				
				// Shipper Phone Number가 숫자가 아닌 경우 알림
				if (isNaN(shpr_phn_val)) {
					ComShowCodeMessage('BKG06012', shpr_phn_cpt);
					frmObj.shpr_phn_no.value = "";
					frmObj.shpr_phn_no.focus();
					return false;
				// Notify Phone Number가 숫자가 아닌 경우 알림
				} else if (isNaN(ntfy_phn_val)) {
					ComShowCodeMessage('BKG06012', ntfy_phn_cpt);
					frmObj.ntfy_phn_no.value = "";
					frmObj.ntfy_phn_no.focus();
					return false;
				}
				
				// 공통 유효성 검증
				if (!ComChkValid(frmObj)) return;
				
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND11;
				frmObj.bl_no.value = frmObj.org_bl_no.value;    // 저장 전 사용자 실수를 막기 위하여, 조회되었던 bl_no로 원복
				var xmlStr = shtObj.GetSaveXml("ESM_BKG_1502GS.do", FormQueryString(frmObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.RequestTimeOut = 20000;
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;
			
		}
	}


	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * (***** 기본 Event (중요) *****)
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs = document.all.item("tabLayer");
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
		beforetab = nItem;
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function tab2sheet1_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		//조회된 ETC데이터를 Form내의 각각 오브젝트에 setting
		ComEtcDataToForm(document.form, shtObj);
	}


	/**
	 * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 저장 후 메시지
	 */
	function tab2sheet1_OnSaveEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		if (document.form.f_cmd.value == MULTI01) {
			saveCount++;    // 저장여부를 알기위하여 사용됨
			ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		} else {
			ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.

		}
		// 저장 후 재조회
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {ErrMsg} String : 조회 후 메시지
	 */
	function tab3sheet1_OnSearchEnd(shtObj, ErrMsg) {
		if (ErrMsg != "") return;
		if (searchCount < 1) {
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_transmit");
			ComBtnEnable("btn_new_transmit")
			ComBtnEnable("tab2btn_rowadd");
			ComBtnEnable("tab2btn_delete");
		}
		searchCount++;

		document.form.cmdt_hs_cd.value = shtObj.CellValue(shtObj.HeaderRows, "cmdt_hs_cd");
		document.form.diff_rmk.value = shtObj.CellValue(shtObj.HeaderRows, "diff_rmk");
		document.form.bl_desc.value = shtObj.CellValue(shtObj.HeaderRows, "bl_desc");
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var shtObj2 = sheetObjects[1];
		var elementName = window.event.srcElement.getAttribute("name");
		with (document.form) {
			switch (elementName) {

				case "t_cmr_kind":
					if (t_cmr_kind.value == "1") {    // CMR(Del) 선택시
						del_trasmit_flag.value = "Y";
						document.getElementById("del").style.display = "block";
						if(del_cd.value == "5") {
							document.getElementById("del_reason").style.display = "block";
						}
					} else {
						del_trasmit_flag.value = "";
						document.getElementById("del").style.display = "none";
						document.getElementById("del_reason").style.display = "none";
					}
				break;
				
				case "del_cd":
					if(del_cd.value == "5") {
						document.getElementById("del_reason").style.display = "block";
					} else {
						document.getElementById("del_reason").style.display = "none";
					}
				break;

				case "pod_postfix":
					if (ComTrim(pod_postfix.value) == "") {
						pod_cd.value = "";
					} else {
						pod_cd.value = pod_prefix.value + pod_postfix.value;
					}
				break;

				case "cmdt_hs_cd":
					shtObj2.CellValue2(shtObj2.HeaderRows, "cmdt_hs_cd") = cmdt_hs_cd.value;
				break;

				case "diff_rmk":
					shtObj2.CellValue2(shtObj2.HeaderRows, "diff_rmk") = diff_rmk.value;
				break;

				case "bl_desc":
					shtObj2.CellValue2(shtObj2.HeaderRows, "bl_desc") = bl_desc.value;
				break;

				default:
					onchange_flag.value = "Y";    // 저장시 HTML의 Object내의 value들이 변경되었는지 감지
				break;
			}
		}
	}


	/**
	 * Back End Job 호출함수
	 */
	function getBackEndJobStatus() {
		var shtObj = sheetObjects[0];
		var xmlStr = shtObj.GetSearchXml("ESM_BKG_1502GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			ComOpenWait(false);
			shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_BKG_1502GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey));
			clearInterval(timer);
			backEndJobKey = "";

		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}


/* 개발자 작업 끝 */
