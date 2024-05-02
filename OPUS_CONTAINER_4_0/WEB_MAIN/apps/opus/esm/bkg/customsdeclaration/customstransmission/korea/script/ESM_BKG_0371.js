/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0371.jsp
*@FileTitle  : MRN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_new":
				formObj.rad_kind[0].checked = true;
				radKindChange();
				ComResetAll();
				ComShowObject(formObj.start_num, false);
				ComShowObject(formObj.sel_type, false);
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				ComBtnDisable("btn_save_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_automrn");
				break;
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			case "btn_save_3G":
				formObj.ff_div.value = "3G";
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_save":
				formObj.ff_div.value = "4G";
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			case "btn_delete":
				doActionIBSheet(sheetObj ,formObj, IBDELETE);
				break;
			case "btn_downexcel":
				if (sheetObj.RowCount() < 1) {//no data
					ComShowCodeMessage("COM132501");
				} else {
					sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", true, "Sel");
				}
				break;
			case "btn_calendar":
				var cal = new ComCalendarFromTo();
				cal.select(formObj.from_dt, formObj.to_dt, "yyyy-MM-dd");
				break;
			case "rad_kind":
				radKindChange();
				break;
			case "btn_automrn":
				if (formObj.start_num.value == "") {
					formObj.start_num.focus();
					ComShowCodeMessage("COM130201", "Start Number");
					return;
				}
				if (sheetObj.CheckedRows("Sel") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				var startNum = ComLtrim(formObj.start_num.value, "0");
				var selType = formObj.sel_type.value;
				var mrnNoPrefix = ComGetNowInfo("yy").substring(2, 4) + "NYKS" + selType;
				var kk = 0;
				with (sheetObj) {
					ReDraw = false;
					for (var i=HeaderRows(); i<=LastRow(); i++) {
						if (GetCellValue(i, "Sel") ==  1) {
							SetCellValue(i, "mrn_no", mrnNoPrefix + ComLpad(parseInt(startNum) + parseInt(kk++), 3, 0));
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
							// SetCellValue(i, "mrn_chk_no", selType);
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
						} else {
							SetCellValue(i, "mrn_no", "");
						}
					}
					ReDraw = true;
				}
				break;
			} // end switch

		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}


	function radKindChange() {
		var formObj = document.form;
		if (formObj.rad_kind[0].checked) {
			formObj.vvd.readOnly = false;
			formObj.vvd.className = "input1";
			formObj.vvd.setAttribute("required", "");
			formObj.from_dt.value = "";
			formObj.from_dt.removeAttribute("required");
			formObj.from_dt.className = "input2";
			formObj.from_dt.readOnly = true;
			formObj.to_dt.value = "";
			formObj.to_dt.removeAttribute("required");
			formObj.to_dt.className = "input2";
			formObj.to_dt.readOnly = true;
			formObj.to_dt.readOnly = true;
			formObj.btn_calendar.disabled = true;
		} else {
			formObj.btn_calendar.disabled = false;
			formObj.from_dt.readOnly = false;
			formObj.from_dt.className = "input1";
			formObj.from_dt.setAttribute("required", "");
			formObj.to_dt.readOnly = false;
			formObj.to_dt.className = "input1";
			formObj.to_dt.setAttribute("required", "");
			formObj.vvd.value = "";
			formObj.vvd.removeAttribute("required");
			formObj.vvd.className = "input2";
			formObj.vvd.readOnly = true;
		}
	}


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();

		var formObj = document.form;
		ComShowObject(formObj.start_num, false);
		ComShowObject(formObj.sel_type, false);
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
		ComBtnDisable("btn_save_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_automrn");
	}


	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage} 함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 *
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {int} sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		axon_event.addListenerForm("change", "formObj_OnChange", document.form);
		axon_event.addListener ("keydown", "ComKeyEnter", 'form');
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj) {
				var HeadTitle1="|Sel.|MRN|MRN|Port|Bound|Lane|VVD|Call Sign|ETA|ETD";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 } ;
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",   Hidden:1, Width:0,   Align:"Center", SaveName:"ibflag" },
							{Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", SaveName:"Sel" },
							{Type:"Text",     Hidden:0, Width:140, Align:"Center", SaveName:"mrn_no",      KeyField:1, EditLen:10, AcceptKeys:"E|N", InputCaseSensitive:1 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"mrn_chk_no",  Edit:0 },
							{Type:"Text",     Hidden:0, Width:95,  Align:"Center", SaveName:"port_cd",     Edit:0 },
							{Type:"Text",     Hidden:0, Width:60,  Align:"Center", SaveName:"io_bnd_cd",   Edit:0 },
							{Type:"Text",     Hidden:0, Width:75,  Align:"Center", SaveName:"lane",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:145, Align:"Center", SaveName:"vvd",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:100, Align:"Center", SaveName:"call_sgn_no", Edit:0 },
							{Type:"Text",     Hidden:0, Width:135, Align:"Center", SaveName:"vps_eta_dt",  Edit:0 },
							{Type:"Text",     Hidden:0, Width:135, Align:"Center", SaveName:"vps_etd_dt",  Edit:0 } ];
				InitColumns(cols);

				SetEditable(1);
				SetSheetHeight(410);
				SetWaitImageVisible(0);
			}
		break;
		}
	}


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //조회
				if (!ComChkValid(formObj)) return;
				if (!validateForm(sheetObj, formObj, sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.RemoveAll();
				sheetObj.DoSearch("ESM_BKG_0371GS.do", FormQueryString(formObj), {Sync:1});
				ComOpenWait(false);
			break;

			case IBSAVE:        //저장
				if (!ComShowCodeConfirm("BKG95003", "save")) return;   // Do you want to ...?
				if (sheetObj.CheckedRows("Sel") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				if (sheetObj.GetSaveString(0, 1, "Sel") == "") return;   // Sheet1의 Mandatory Check 용도
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var params = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(0, 1, "Sel"), "sheet_");
				sheetObj.DoSave("ESM_BKG_0371GS.do", {Param:params, Quest:0, Sync:1});
				ComOpenWait(false);
			break;

			case IBDELETE:      // 삭제
				if (!ComShowCodeConfirm("BKG95003", "delete")) return;   // Do you want to ...?
				if (sheetObj.CheckedRows("Sel") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				if (sheetObj.GetSaveString(0, 1, "Sel") == "") return;   // Sheet1의 Mandatory Check 용도
				ComOpenWait(true);
				formObj.f_cmd.value = REMOVE;
				var params = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(0, 1, "Sel"), "sheet_");
				sheetObj.DoSave("ESM_BKG_0371GS.do", {Param:params, Quest:0, Sync:1});
				ComOpenWait(false);
			break;
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with(formObj) {
			var radKind = ComGetObjValue(formObj.elements["rad_kind"]);
			if (radKind == "eta") {
				if (ComGetDaysBetween(formObj.from_dt.value, formObj.to_dt.value) > 90) {
					ComShowMessage("Date exceeds maximum duration (90 days)");
					// ComShowCodeMessage("BKG08257", "3");
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * handling event after searching.
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		sheetObj.SetHeaderCheck(0, "Sel", 0);
		var formObj = document.form;
		if (formObj.mrn_yn.value == "Y") {
			ComBtnDisable("btn_automrn");
			ComShowObject(formObj.start_num, false);
			ComShowObject(formObj.sel_type, false);
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			ComBtnDisable("btn_save_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			ComBtnDisable("btn_save");
			ComBtnEnable("btn_delete");
		} else {
			if (formObj.crr_cd.value == "H") {
				ComBtnEnable("btn_automrn");
				ComShowObject(formObj.start_num, true);
				ComShowObject(formObj.sel_type, true);
			} else {
				ComBtnDisable("btn_automrn");
				ComShowObject(formObj.start_num, false);
				ComShowObject(formObj.sel_type, false);
			}
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			ComBtnEnable("btn_save_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_delete");
		}
		if (form.mrn_yn.value == "Y") {
			sheetObj.SetColEditable("mrn_no", 0);
		} else {
			sheetObj.SetColEditable("mrn_no", 1);
		}
	}


	/**
	 * handling event after saving.
	 */
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		if (document.form.f_cmd.value == REMOVE) {
			ComShowCodeMessage("COM130303", "Data");    // '{?msg1} was deleted successfully.';
		} else {
			ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		}
		// Retrieve after saving
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function formObj_OnChange() {
		var formObj = document.form;
		switch (ComGetEvent("name")) {
			case "io_bnd_cd":
				if (formObj.io_bnd_cd.value == "O") {
					formObj.sel_type.value = "E";
				} else {
					formObj.sel_type.value = "I";
				}
			break;
		}
	}
