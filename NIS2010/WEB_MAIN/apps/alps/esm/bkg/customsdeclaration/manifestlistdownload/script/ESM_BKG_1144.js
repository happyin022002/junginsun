/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_BKG_1144.js
 *@FileTitle : SNP/Broker Nomination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.26
 *@LastModifier : KIM HYUN HWA
 *@LastVersion : 1.0
 * 2012.03.26 KIM HYUN HWA
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
function ESM_BKG_1144() {
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
	
//	for(i = 0; i < comboObjects.length; i++ ) {
//		initCombo(comboObjects[i], i+1);
//	}

//    ComBtnDisable("btn_Save");    
//    ComBtnDisable("btn_DownExcel");
	ComBtnDisable("btn_Delete");
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	if (document.form.cust_cd.value != "") {
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
			
			var HeadTitle = "|Sel.|Seq.|Customer\nCode|Customer\nName|S/C No.|POD|POD|DEL|DEL|Type|Customs code|Name|cstms_pty_seq|delt_flg|cre_usr_id|cre_ofc_cd|upd_usr_id|upd_ofc_cd";
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
			InitDataProperty(0, cnt++, dtSeq,   30,  daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData,  80,  daCenter, false, "cust_cd",         false,  "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtData,  170, daLeft,   false, "cust_nm",         false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData,  80, daCenter, false, "sc_no",           false,  "", dfNone, 0, true,  true,  9);
			InitDataProperty(0, cnt++, dtData,  55,  daCenter, false, "pod_cd",          false,  "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData,  30,  daCenter, false, "pod_yd_no",       false,  "", dfNone, 0, true,  true, 2);
			InitDataProperty(0, cnt++, dtData,  55,  daCenter, false, "del_cd",          false,  "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData,  30,  daCenter, false, "del_yd_no",       false,  "", dfNone, 0, true,  true, 2);
			InitDataProperty(0, cnt++, dtCombo, 150, daCenter, false, "cstms_pty_tp_cd", true,  "", dfNone, 0, true,  true);
			InitDataProperty(0, cnt++, dtData,  150, daCenter, false, "cstms_pty_id",    true,  "", dfNone, 0, true,  true, 17);
			InitDataProperty(0, cnt++, dtData,  150, daCenter, false, "cstms_pty_nm",    true,  "", dfNone, 0, true,  true, 35);

			InitDataProperty(0, cnt++, dtHidden,  60,  daCenter, false, "cstms_pty_seq",   false,  "", dfNone, 0, true,  true);
			InitDataProperty(0, cnt++, dtHidden,  30,  daCenter, false, "delt_flg",        false, "", dfNone, 0, true,  true);
			InitDataProperty(0, cnt++, dtHidden,  65,  daLeft,   false, "cre_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,  85,  daCenter, false, "cre_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,  65,  daLeft,   false, "upd_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "upd_ofc_cd", false, "", dfNone, 0, false, false);

			
			InitDataValid(0, "cust_cd",  vtEngUpOther, "1234567890");
			InitDataValid(0, "sc_no",    vtEngUpOther, "1234567890");
			InitDataValid(0, "pod_cd", 	 vtEngUpOther, "0123456789");
			InitDataValid(0, "del_cd", 	 vtEngUpOther, "0123456789");
			InitDataValid(0, "cstms_pty_id",  vtEngUpOther, "0123456789");
			InitDataValid(0, "cstms_pty_nm",  vtEngUpOther, "0123456789-_, ");
			InitDataValid(0, "pod_yd_no", 	 vtEngUpOther, "0123456789");
			InitDataValid(0, "del_yd_no", 	 vtEngUpOther, "0123456789");
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
	// 해당 ROW UPDATE 시 UPDATE USER ID,OFFICE 데이터 세팅
	if (sheetObj.RowStatus(Row) == "U") {
		sheetObj.CellValue2(Row, "upd_usr_id") = formObj.usr_id.value;
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
	
	
	// POD 유효성 체크
	if (sheetObj.ColSaveName(Col) == "pod_cd") {
		formObj.f_cmd.value = SEARCH02;
	
		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);
		if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		
		formObj.strPod.value = sheetObj.CellValue(Row, "pod_cd");
	}
	// DEL 유효성 체크
	if (sheetObj.ColSaveName(Col) == "del_cd") {
		formObj.f_cmd.value = SEARCH02;
		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);
		if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
			doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
		}
		formObj.strDel.value = sheetObj.CellValue(Row, "del_cd");
	}
	
	
}

///**
// * 시트의 Row 선택 시 동일한 OFFICE 데이터인지 확인
// */
//function sheet1_OnClick(sheetObj, Row, Col, Value) {
//	if (sheetObj.RowStatus(Row) == "I")
//		return;
//	if (sheetObj.CellValue(Row, "cre_ofc_cd") != userOfficeCode) {
//		if (sheetObj.ColSaveName(Col) == "Chk" && Value == '1')
//			return;
//		ComShowCodeMessage('BKG06030', sheetObj.CellValue(Row, "cre_ofc_cd"));
//		sheetObj.SelectCell(0, 0);
//		return;
//	}
//}

 /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
   */  	
	function sheet1_OnLoadFinish(sheetObj){
		sheetObjects[0].WaitImageVisible = false; 
		doActionIBSheet(sheetObjects[0], document.form, IBRESET);
		sheetObjects[0].WaitImageVisible = true; 
	}

 
/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	
	case IBRESET:

		formObj.reset();
		sheetObj.RemoveAll();	
		
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1144GS.do", FormQueryString(formObj));
		if(sXml.length > 0){

 	         var arrCombo = ComXml2ComboString(sXml, "desc", "val");
 	         if (arrCombo  != undefined ){
		        sheetObj.InitDataCombo(0, "cstms_pty_tp_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
 	         } 
		}
		
		break;
	
	case IBSEARCH: //조회
//		if (!validateForm(sheetObj, formObj, sAction))
//			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1144GS.do", FormQueryString(formObj));
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1144GS.do", FormQueryString(formObj));
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
//			ComBtnEnable("btn_Save");    
//			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_Delete");
			
			if (sheetObj.TotalRows > 0) {
//				for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
//					if (sheetObj.CellValue(i, "cre_ofc_cd") != userOfficeCode) {
//						sheetObj.CellEditable(i, "Chk") = false;
//					}
//				}
				sheetObj.SelectCell(0, 0);
			}
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		ComOpenWait(false);
		break;
	
	case IBROWSEARCH: // Customer Name
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1144GS.do", FormQueryString(formObj));
		var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		var row = sheetObj.SelectRow;

		if (state == "S") {
			if (formObj.f_cmd.value == SEARCH01) {
				
				if (sheetObj.CellValue(row, "cust_cd") != "") {
					sheetObj.CellValue2(row, "cust_nm") = ComGetEtcData(sXml, "result");
				}
			}  else if (formObj.f_cmd.value == SEARCH02) {
			
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
		sheetObj.DoSave("ESM_BKG_1144GS.do", FormQueryString(formObj), -1, false);
		ComOpenWait(false);
		break;
	
	case IBINSERT: // 입력
		var row = sheetObj.DataInsert(-1);
		sheetObj.CellValue2(row, "delt_flg") = 'N';
		sheetObj.CellValue2(row, "cre_usr_id") = formObj.usr_id.value;
		sheetObj.CellValue2(row, "cre_ofc_cd") = userOfficeCode;
		sheetObj.CellValue2(row, "upd_usr_id") = formObj.usr_id.value;
		sheetObj.CellValue2(row, "upd_ofc_cd") = userOfficeCode;
		sheetObj.CellEditable(row, "cust_cd") = true;
		sheetObj.CellEditable(row, "pod_cd") = true;
		sheetObj.CellEditable(row, "del_cd") = true;
		sheetObj.CellEditable(row, "sc_no") = true;

		
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
					} else if (ColName == "sc_no") {
					sheetObj.CellEditable(Row, ColName) = true;
			     	}
				}
				sheetObj.ReturnCellData(i, "Chk");
				sheetObj.ReturnCellData(i, "upd_usr_id");
				sheetObj.ReturnCellData(i, "upd_ofc_cd");
				sheetObj.CellValue2(Row, "cre_usr_id") = formObj.usr_id.value;
				sheetObj.CellValue2(Row, "cre_ofc_cd") = userOfficeCode;
				sheetObj.CellValue2(Row, "upd_usr_id") = formObj.usr_id.value;
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
				sheetObj.CellValue2(i, "upd_usr_id") = formObj.usr_id.value;
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
//	case IBSEARCH: // 조회
//		if (formObj.cust_cd.value == "" && formObj.pod_cd.value == "" && formObj.del_cd.value == ""
//				&& formObj.cre_ofc_cd.value == "") {
//			ComShowCodeMessage('BKG06064'); // Please input Customer Code, POD, DEL or Create Office.
//			return false;
//		}
//		break;
	
	case IBSAVE: // 저장
		if (sheetObj.RowCount <= 0)
			return false;
		if (sheetObj.RowCount("U") + sheetObj.RowCount("D") + sheetObj.RowCount("I") == 0) {
			ComShowCodeMessage('BKG00501');
			return false;
		}
		var cust_cd ="";
		var sc_no ="";
		var pod_cd ="";
		var del_cd ="";
		var pty_tp_cd ="";
		var pty_nm ="";

		var confirmCnt = 0;
		
		for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
			if (sheetObj.RowStatus(i) == "D" )	continue;
			cust_cd = sheetObj.CellValue(i, "cust_cd");
			sc_no = sheetObj.CellValue(i, "sc_no");
			pod_cd = sheetObj.CellValue(i, "pod_cd");
			del_cd = sheetObj.CellValue(i, "del_cd");
			pty_tp_cd = sheetObj.CellValue(i, "cstms_pty_tp_cd");
			pty_nm = sheetObj.CellValue(i, "cstms_pty_nm");
			
			if (cust_cd == "" && sc_no == "" && pod_cd == "" && del_cd == "") {
				ComShowMessage("Please select one among 4 items ( Customer code, S/C No, POD and DEL )");
				return false;
			}
	
			for ( var j = i + 1; j < sheetObj.RowCount + 1; j++) {
					if (sheetObj.RowStatus(j) == "D")	continue;
					
					if (sheetObj.CellValue(j, "cust_cd") == cust_cd && sheetObj.CellValue(j, "sc_no") == sc_no
							&& sheetObj.CellValue(j, "pod_cd") == pod_cd && sheetObj.CellValue(j, "del_cd") == del_cd
							&& sheetObj.CellValue(j, "cstms_pty_tp_cd") == pty_tp_cd 
							&& sheetObj.CellValue(j, "cstms_pty_nm") == pty_nm) {
						
						if(!ComShowCodeConfirm('BKG06029', sheetObj.CellValue(j, "Seq"))){
							return false;
						}
						
					}
				}
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