/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0540.js
 *@FileTitle : Entry Type Set-Up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.19 이수빈
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
 * @class Entry Type Set-Up : Entry Type Set-Up 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0540() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업    */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	
	/** **************************************************** */
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case "btn_RowAdd":
			doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
			break;
		case "btn_Copy":
			doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
			break;
		
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		
		case "btn_New":
			doActionIBSheet(sheetObjects[0], formObject, IBRESET);
			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.pod_cd,"");
			break;
		
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
		
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
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
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//ComBtnDisable("btn_RowAdd");
	ComBtnDisable("btn_Copy");
	ComBtnDisable("btn_Delete");
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	if (document.form.cust_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.pod_cd)) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}	
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1":
		with (sheetObj) {
			
			// 높이 설정
			style.height = 420;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle = "|Sel.|Seq.|Customer\nCode|Customer\nName|S/C No.|POD|DEL|Commodity\nCode|Commodity||CGO\nType|Entry\nType|IT Type|FTZ|HUB|C.LOC||Create Date|Create ID|Create Office|Update Date|Update ID|Update Office|DEL Term|Direct Delivery||";
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "Chk");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cust_cd", true, "", dfNone, 0, false, false, 8);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "cust_nm", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "sc_no", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", true, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", true, "", dfNone, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cmdt_cd", false, "", dfNone, 0, false, false, 6);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cmdt_nm", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "clr_tp_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "cntr_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "etr_tp", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo,	50,	daCenter, false, "it_tp", false,	"", dfNone,	0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, false, "ftz_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,  50, daCenter, false, "hub_loc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData,	50,	daCenter, false, "cstms_loc_cd", false,	"", dfNone,	0, true, true, 5);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "delt_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_dt", false, "", dfUserFormat2, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 65, daLeft, false, "cre_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "cre_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "upd_dt", false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daLeft, false, "upd_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "upd_ofc_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "dir_de_flg", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "delt_dt", false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "delt_usr_id", false, "", dfNone, 0, false, false);
			
			InitDataCombo(0, "cntr_tp_cd", "All|Dry|Reefer", "A|D|R", "A");
			InitDataCombo(0, "etr_tp", "Local|P/MIB", "L|I", "Local");
			InitDataCombo(0, "it_tp", 	" |61(IT)|62(T&E)|63(IE)", 	" |61|62|63");
			InitDataCombo(0, "ftz_flg", "Yes|No", "Y|N", "No");
			
			InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "delt_dt", "####-##-## ##:##", "-|:");
			
			InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "sc_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "cmdt_cd", vtNumericOnly);
//			InitDataValid(0, "pod_cd", vtEngUpOnly);
//			InitDataValid(0, "del_cd", vtEngUpOnly);
			InitDataValid(0, "hub_loc_cd", vtEngUpOnly);
			InitDataValid(0, "cstms_loc_cd", vtEngUpOnly);
			InitDataValid(0, "pod_cd", 			vtEngUpOther, "0123456789");
			InitDataValid(0, "del_cd", 			vtEngUpOther, "0123456789");
			
			InitDataCombo(0, "de_term_cd", "CY|Door", "Y|D"," ");			
			InitDataCombo(0, "dir_de_flg", "N/A|Yes|No", "X|Y|N","X");			
		}
		break;
	}
}

/**
 * 저장 후 재 조회
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(ErrMsg.indexOf("<||>") < 0) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	// 해당 ROW UPDATE 시 UPDATE USER ID, DATE, OFFICE 데이터 세팅
	if (sheetObj.RowStatus(Row) == "U") {
		sheetObj.CellValue2(Row, "upd_usr_id") = formObj.usr_id.value;
		sheetObj.CellValue2(Row, "upd_dt") = setDate();
		sheetObj.CellValue2(Row, "upd_ofc_cd") = userOfficeCode;
	}
	
	// S/C NO. 에 대한 유효성 체크
	if (sheetObj.ColSaveName(Col) == "sc_no") {
		if (Value == "") {
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		if (!ComIsAlphabet(Value.substring(0, 3)) || !ComIsNumber(Value.substring(3))) {
			ComShowCodeMessage('BKG06012', Value); // {?msg1} is invalid.
			sheetObj.CellValue2(Row, Col) = "";
			sheetObj.SelectCell(Row, Col);
			return;
		}
	}
	
	// CUSTOMER CODE 에 대한 CUSTOMER NAME 조회
	if (sheetObj.ColSaveName(Col) == "cust_cd") {
		formObj.f_cmd.value = SEARCH01;
		if (Value == "") {
			sheetObj.CellValue2(Row, "cust_cd") = "";
			sheetObj.CellValue2(Row, "cust_nm") = "";
			return;
		}
		if (!ComIsAlphabet(Value.substring(0, 2)) || !ComIsNumber(Value.substring(2))) {
			ComShowCodeMessage('BKG06012', Value); // {?msg1} is invalid.
			sheetObj.CellValue2(Row, "cust_cd") = "";
			sheetObj.CellValue2(Row, "cust_nm") = "";
			sheetObj.SelectCell(Row, Col);
		} else {
			formObj.strCustCntCd.value = Value.substring(0, 2);
			formObj.strCustSeq.value = Value.substring(2);
		}
		if (formObj.strCustCntCd.value != "") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
	}
	
	// COMMODITY CODE 에 대한 DESCRIPTION 조회
	if (sheetObj.ColSaveName(Col) == "cmdt_cd") {
		formObj.f_cmd.value = SEARCH02;
		formObj.strCmdtCd.value = sheetObj.CellValue(Row, "cmdt_cd");
		
		if (formObj.strCmdtCd.value != "") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		} else {
			sheetObj.CellValue2(Row, "cmdt_nm") = "";
		}
	}
	
	// POD 유효성 체크
	if (sheetObj.ColSaveName(Col) == "pod_cd") {
		formObj.f_cmd.value = SEARCH03;
		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);
		if (formObj.strLocCd.value != "") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		
		formObj.strPod.value = sheetObj.CellValue(Row, "pod_cd");
	}
	// DEL 유효성 체크
	if (sheetObj.ColSaveName(Col) == "del_cd") {
		formObj.f_cmd.value = SEARCH03;
		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);
		if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		formObj.strDel.value = sheetObj.CellValue(Row, "del_cd");
	}
	
	// Entry Type이 Local일 때 IT Type 설정
	if(sheetObj.CellValue(Row, "etr_tp") == "L"){
		sheetObj.CellValue2(Row, "it_tp") = "";
		sheetObj.CellEditable(Row, "it_tp") = false;
	}
	else{
		sheetObj.CellEditable(Row, "it_tp") = true;
	}
	
	//	// 중복 데이터 체크
	// if(sheetObj.ColSaveName(Col) == "cust_cd" || sheetObj.ColSaveName(Col) == "pod_cd" || sheetObj.ColSaveName(Col) ==
	// "del_cd"){
	// if( formObj.strCustSeq.value != "" && formObj.strPod.value != "" && formObj.strDel.value != "" ){
	// formObj.f_cmd.value = SEARCH04;
	// doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
	// formObj.f_cmd.value = "";
	// }
	// }
}

/**
 * 시트의 Row 선택 시 동일한 OFFICE 데이터인지 확인
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (sheetObj.RowStatus(Row) == "I")
		return;
	if (sheetObj.CellValue(Row, "cre_ofc_cd") != userOfficeCode) {
		if (sheetObj.ColSaveName(Col) == "Chk" && Value == '1')
			return;
		ComShowCodeMessage('BKG06030', sheetObj.CellValue(Row, "cre_ofc_cd"));
		sheetObj.SelectCell(0, 0);
		return;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0540GS.do", FormQueryString(formObj));
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0540GS.do", FormQueryString(formObj));
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
			//ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_Copy");
			ComBtnEnable("btn_Delete");
			
			if (sheetObj.TotalRows > 0) {
				for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
					if (sheetObj.CellValue(i, "cre_ofc_cd") != userOfficeCode) {
						sheetObj.CellEditable(i, "Chk") = false;
					}
				}
				sheetObj.SelectCell(0, 0);
			}
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		
		for ( i = 1 ; i < sheetObj.Rowcount + 1 ; i++ ){
			if(sheetObj.CellValue(i, "etr_tp") == "L"){
				sheetObj.CellEditable(i, "it_tp") = false;
			}
			else{
				sheetObj.CellEditable(i, "it_tp") = true;
			}
		}
		ComOpenWait(false);
		break;
	
	case IBROWSEARCH: // Customer Name, Commodity Name 조회
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0540GS.do", FormQueryString(formObj));
		var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		var row = sheetObj.SelectRow;
		if (state == "S") {
			if (formObj.f_cmd.value == SEARCH01) {
				if (sheetObj.CellValue(row, "cust_cd") != "") {
					sheetObj.CellValue2(row, "cust_nm") = ComGetEtcData(sXml, "result");
				}
			} else if (formObj.f_cmd.value == SEARCH02) {
				if (ComGetEtcData(sXml, "result") != undefined) {
					sheetObj.CellValue2(row, "cmdt_nm") = ComGetEtcData(sXml, "result");
				} else {
					ComShowCodeMessage('BKG06012', sheetObj.CellValue(row, "cmdt_cd")); // {?msg1} is invalid.
					sheetObj.CellValue2(row, "cmdt_cd") = "";
					sheetObj.SelectCell(row, "cmdt_cd");
				}
			} else if (formObj.f_cmd.value == SEARCH03) {
				if (ComGetEtcData(sXml, "result") == undefined) {
					var locCd = formObj.strLocCd.value;
					ComShowCodeMessage('BKG06012', locCd); // {?msg1} is invalid.
					if (sheetObj.CellValue(row, "pod_cd") == locCd) {
						sheetObj.CellValue2(row, "pod_cd") = "";
						sheetObj.SelectCell(row, "pod_cd");
					} else {
						sheetObj.CellValue2(row, "del_cd") = "";
						sheetObj.SelectCell(row, "del_cd");
					}
				}
			}
			//				else if(formObj.f_cmd.value == SEARCH04){
			//					if(ComGetEtcData(sXml,"result") != "nodata"){
			//						// Customer Code({?msg1}) is Duplicated !
			// ComShowCodeMessage('BKG06039', sheetObj.CellValue(row, "cust_cd"));
			// sheetObj.CellValue2(row, "del_cd") = "";
			// sheetObj.CellValue2(row, "pod_cd") = "";
			// sheetObj.CellValue2(row, "cust_cd") = "";
			// sheetObj.CellValue2(row, "cust_nm") = "";
			// sheetObj.SelectCell(row, "cust_cd");
			// }
			// }
		} else {
			if (formObj.f_cmd.value == SEARCH01) {
				ComBkgErrMessage(sheetObj, sXml);
				sheetObj.CellValue2(row, "cust_cd") = "";
				sheetObj.CellValue2(row, "cust_nm") = "";
				sheetObj.SelectCell(row, "cust_cd");
			}
		}
		sheetObj.WaitImageVisible = true;
		break;
	
	case IBSAVE: //저장
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESM_BKG_0540GS.do", FormQueryString(formObj), -1, false);
		ComOpenWait(false);
		break;
	
	case IBRESET: //초기화
		formObj.reset();
		sheetObj.RemoveAll();
		break;
	
	case IBINSERT: // 입력
		var row = sheetObj.DataInsert(-1);
		sheetObj.CellValue2(row, "delt_flg") = 'N';
		sheetObj.CellValue2(row, "cre_usr_id") = formObj.usr_id.value;
		sheetObj.CellValue2(row, "cre_dt") = setDate();
		sheetObj.CellValue2(row, "cre_ofc_cd") = userOfficeCode;
		sheetObj.CellValue2(row, "upd_usr_id") = formObj.usr_id.value;
		sheetObj.CellValue2(row, "upd_dt") = setDate();
		sheetObj.CellValue2(row, "upd_ofc_cd") = userOfficeCode;
		sheetObj.CellValue2(row, "del_term") = "";
		sheetObj.CellValue2(row, "direct_d_flg") = "";
		sheetObj.CellEditable(row, "cust_cd") = true;
		sheetObj.CellEditable(row, "pod_cd") = true;
		sheetObj.CellEditable(row, "del_cd") = true;
		sheetObj.CellEditable(row, "cmdt_cd") = true;
		sheetObj.CellEditable(row, "it_tp") = false;
		
		break;
	
	case IBCOPYROW: // 행 복사
		if (sheetObj.CheckedRows("Chk") == 0) {
			ComShowCodeMessage('BKG00567');
			return false;
		}
		var Row;
		var ColName;
		for (i = 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObj.CellValue(i, "Chk") == 1) {
				Row = sheetObj.DataInsert(-1);
				// col 개수 만큼 반복하면서 추가된 row에 데이터 카피
				for (j = 2; j <= sheetObj.LastCol - 2; j++) {
					sheetObj.CellValue2(Row, j) = sheetObj.CellValue(i, j);
					ColName = sheetObj.ColSaveName(j);
					if (ColName == "cust_cd") {
						sheetObj.CellEditable(Row, ColName) = true;
					} else if (ColName == "pod_cd") {
						sheetObj.CellEditable(Row, ColName) = true;
					} else if (ColName == "del_cd") {
						sheetObj.CellEditable(Row, ColName) = true;
					} else if (ColName == "cmdt_cd") {
						sheetObj.CellEditable(Row, ColName) = true;
					} else if (ColName == "clr_tp_seq") {
						sheetObj.CellValue2(Row, ColName) = "";
					}
				}
				sheetObj.ReturnCellData(i, "Chk");
				sheetObj.ReturnCellData(i, "upd_usr_id");
				sheetObj.ReturnCellData(i, "upd_dt");
				sheetObj.ReturnCellData(i, "upd_ofc_cd");
				sheetObj.CellValue2(Row, "cre_usr_id") = formObj.usr_id.value;
				sheetObj.CellValue2(Row, "cre_dt") = setDate();
				sheetObj.CellValue2(Row, "cre_ofc_cd") = userOfficeCode;
				sheetObj.CellValue2(Row, "upd_usr_id") = formObj.usr_id.value;
				sheetObj.CellValue2(Row, "upd_dt") = setDate();
				sheetObj.CellValue2(Row, "upd_ofc_cd") = userOfficeCode;
				
			}
		}
		break;
	
	case IBDELETE:
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		var delCnt = 0;
		for ( var i = 0; i < sheetObj.LastRow + 1; i++) {
			if (sheetObj.CellValue(i, "Chk") == 1 && sheetObj.RowStatus(i) == "U") {
				delCnt++;
				sheetObj.CellValue2(i, "delt_flg") = 'Y';
				sheetObj.CellValue2(i, "delt_usr_id") = formObj.usr_id.value;
				sheetObj.CellValue2(i, "delt_dt") = setDate();
			}
		}
		if (ComShowCodeConfirm('BKG03037')) {
			if (delCnt > 0) {
				ComRowHideDelete(sheetObj, "Chk");
			} else {
				sheetObj.Redraw = false;
				for ( var i = 0; i < sheetObj.LastRow + 1; i++) {
					if (sheetObj.CellValue(i, "Chk") == 1) {
						sheetObj.RowDelete(i, false);
					}
				}
				sheetObj.Redraw = true;
			}
		}
		break;
	
	case IBDOWNEXCEL:
		ComOpenWait(true);
		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		ComOpenWait(false);
		break;
	}
}

/**
 * 현재 날짜,시간 구하기
 */
function setDate() {
	var d = new Date;
	var s = leadingZeros(d.getFullYear(), 4) + '-' + leadingZeros(d.getMonth() + 1, 2) + '-' + leadingZeros(d.getDate(), 2) + ' '
			+ leadingZeros(d.getHours(), 2) + ':' + leadingZeros(d.getMinutes(), 2) + ':';
	return s;
}

/**
 * 한자리 숫자 앞에 '0' 붙이기
 */
function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();
	
	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (formObj.cust_cd.value == "" && formObj.pod_cd.value == "" && formObj.del_cd.value == ""
				&& formObj.cre_ofc_cd.value == "") {
			ComShowCodeMessage('BKG06064'); // Please input Customer Code, POD, DEL or Create Office.
			return false;
		}
		break;
	
	case IBSAVE: // 저장
		if (sheetObj.RowCount <= 0)
			return false;
		if (sheetObj.RowCount("U") + sheetObj.RowCount("D") + sheetObj.RowCount("I") == 0) {
			ComShowCodeMessage('BKG00501');
			return false;
		}
		var cust_cd;
		var sc_no;
		var pod_cd;
		var del_cd;
		var cmdt_cd;
		var cntr_tp_cd;
		var confirmCnt = 0;
		
		for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObj.RowStatus(i) == "D" || sheetObj.RowStatus(i) == "R")
				continue;
			cust_cd = sheetObj.CellValue(i, "cust_cd");
			sc_no = sheetObj.CellValue(i, "sc_no");
			pod_cd = sheetObj.CellValue(i, "pod_cd");
			del_cd = sheetObj.CellValue(i, "del_cd");
			cmdt_cd = sheetObj.CellValue(i, "cmdt_cd");
			cntr_tp_cd = sheetObj.CellValue(i, "cntr_tp_cd");
			
			if (cust_cd != "" && pod_cd != "" && del_cd != "") {
				for ( var j = i + 1; j < sheetObj.RowCount + 1; j++) {
					if (sheetObj.RowStatus(j) == "D")
						continue;
					if (sheetObj.CellValue(j, "cust_cd") == cust_cd && sheetObj.CellValue(j, "sc_no") == sc_no
							&& sheetObj.CellValue(j, "pod_cd") == pod_cd && sheetObj.CellValue(j, "del_cd") == del_cd
							&& sheetObj.CellValue(j, "cmdt_cd") == cmdt_cd && sheetObj.CellValue(j, "cntr_tp_cd") == cntr_tp_cd) {
						// KEY 데이터가 모두 동일하고 create office가 다를 때 업데이트 불가 메세지
						if (sheetObj.CellValue(j, "cre_ofc_cd") != userOfficeCode) {
							// You can’t update the data. Not Create Office [{?msg1}].
							ComShowCodeMessage('BKG06030', sheetObj.CellValue(j, "cre_ofc_cd"));
							return false;
						}
						// KEY 데이터가 모두 동일하고 create office도 같을 때 중복된 데이터 발생, 저장 여부 확인 메세지
						else {
							// Sequence No.[{?msg1}] Duplication occurred. Do you want to save it anyway?
							sheetObj.CellValue2(j, "clr_tp_seq") = sheetObj.CellValue(i, "clr_tp_seq");
							if (ComShowCodeConfirm('BKG06029', sheetObj.CellValue(j, "Seq"))) {
								//sheetObj.CellValue2(j,"clr_tp_seq") = sheetObj.CellValue(i,"clr_tp_seq");
								confirmCnt++;
							} else {
								sheetObj.ReturnCellData(j, "clr_tp_seq");
								return false;
							}
						}
					} else if (sheetObj.CellValue(j, "cust_cd") == cust_cd && sheetObj.CellValue(j, "sc_no") == sc_no
							&& sheetObj.CellValue(j, "pod_cd") == pod_cd && sheetObj.CellValue(j, "del_cd") == del_cd
							&& sheetObj.CellValue(j, "cmdt_cd") == cmdt_cd) {
						// Cargo Type을 제외한 KEY 데이터가 모두 동일하고, 중복된 두개 데이터 중에 Cargo Type이 'All'이 있는 경우 
						if (sheetObj.CellValue(j, "cntr_tp_cd") == "A" || cntr_tp_cd == "A") {
							//  create office가 다를 때 업데이트 불가 메세지
							if (sheetObj.CellValue(j, "cre_ofc_cd") != userOfficeCode) {
								// You can’t update the data. Not Create Office [{?msg1}].
								ComShowCodeMessage('BKG06030', sheetObj.CellValue(j, "cre_ofc_cd"));
								return false;
							}
							// Cargo Type 이 All 이 존재할 경우 중복 메세지 
							else {
								// Sequence No.[{?msg1}] Duplication occurred. Do you want to save it anyway?
								if (ComShowCodeConfirm('BKG06029', sheetObj.CellValue(j, "Seq"))) {
									if (cntr_tp_cd == "A") {
										sheetObj.CellValue2(j, "delt_flg") = 'Y';
										sheetObj.CellValue2(j, "delt_usr_id") = formObj.usr_id.value;
										sheetObj.CellValue2(j, "delt_dt") = setDate();
									} else {
										sheetObj.CellValue2(i, "delt_flg") = 'Y';
										sheetObj.CellValue2(i, "delt_usr_id") = formObj.usr_id.value;
										sheetObj.CellValue2(i, "delt_dt") = setDate();
									}
									confirmCnt++;
								} else {
									return false;
								}
							}
						}
					}
				}
			}
		}
		
		if (confirmCnt == sheetObj.RowCount("I")) {
			return true;
		}
		break;
	
	case IBDELETE:
		if (sheetObj.CheckedRows("Chk") == 0) {
			ComShowCodeMessage('BKG00567');
			return false;
		}
	}
	
	return true;
}

/* 개발자 작업  끝 */