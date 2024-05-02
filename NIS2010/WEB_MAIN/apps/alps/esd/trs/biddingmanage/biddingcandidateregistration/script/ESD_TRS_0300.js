/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_TRS_0300.js
 *@FileTitle : Note Conversion Location Group Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.08.21
 *@LastModifier : 전윤주
 *@LastVersion : 1.0
 * 2009.05.06 전윤주
 * 1.0 Creation
=========================================================
 * History
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
 * @class ESD_TRS_0300 : ESD_TRS_0300 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0300() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업   */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
//var comboObjects = new Array();
var comboCnt = 0;

var processFlag = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_add":
			doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
			break;

		case "btn_del":
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
			
		case "btn_add2":
			doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
			break;

		case "btn_del2":
			doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
			break;

		case "btn_retrieve2":
			// Select Sheet1
			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
			break;

		case "btn_new":
			doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
			break;

		case "btn_save2":
			doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
			break;
			
		case "btns_office": //M CNTR
			if( validation_check() ) {
				var ofc_cd = formObject.spot_bid_ofc_cd.value;
				ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd='+ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:410px;dialogHeight:400px', true);
			}
		break;
		case "btng_provider":
			if(processFlag) return;
			rep_OnPopupClick();
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

function initControl() {
	formObj = document.form;
	axon_event.addListenerForm('activate', 'obj_activate', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
}

/**
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	// loadPage Retrieve
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * IBSHEET COMBO를 LOAD하는 함수<br>
 * <br><b>Example :</b>
 * <pre>
 * 		initCombo(comboObj, comboNo)
 * </pre>
 * @return 없음
 * @author 이승준
 * @version 2009.06.10
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "prc_ctrt_tp_cd":
		var i = 0;
		with (comboObj) {
			DropHeight = 100;
			UseAutoComplete = true;
			ValidChar(2, 0); // 영문대문자만 입력
			MaxLength = 1; // 1자리만 입력
		}
		break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet0": //hidden 
		with (sheetObj) {
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
		}
		break;

	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 438;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle = "|Sel.|Seq.|S/O Office|Transmode|From|From|Via|Via|Door|Door|To|To|||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "ibcheck");
			InitDataProperty(0, cnt++, dtSeq,   30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData,  80, daCenter, false, "spot_bid_ofc_cd", true, "", dfNone, 0, false, true, 6, false);
			InitDataProperty(0, cnt++, dtCombo,100, daCenter, false, "trsp_crr_mod_cd", true, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 60, daCenter,	true, "fm_loc_value",	false, "", dfEngUpKey, 0, false, true, 5, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 40, daLeft,		true, "fm_yard_value",	false, "", dfNone, 0, false, true, 2, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter,	true, "via_loc_value",	false, "", dfEngUpKey, 0, false, true, 5, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 40, daLeft,		true, "via_yard_value",	false, "", dfNone, 0, false, true, 2, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter,	true, "dor_loc_value",	false, "", dfEngUpKey, 0, false, true, 5, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 40, daLeft,		true, "dor_yard_value", false, "", dfNone, 0, false, true, 2, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter,	true, "to_loc_value",	false, "", dfEngUpKey, 0, false, true, 5, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 40, daLeft,		true, "to_yard_value",	false, "", dfNone, 0, false, true, 2, false, true, "", false);
			InitDataProperty(0, cnt++, dtHidden,80, daCenter,		false, "spot_bid_cnddt_term_seq", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 60, daCenter,	true, "fm_nod_cd",		false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter,	true, "via_nod_cd",	false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter,	true, "dor_nod_cd",	false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter,	true, "to_nod_cd",		false);

			InitDataCombo(0, 'trsp_crr_mod_cd', trsp_crr_mod_cdText, trsp_crr_mod_cdCode);
		}
		break;

	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 438;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Sel.|Seq.|S/P Code|S/P Name|E-Mail|SPP|Update User|Update Date||";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "ibcheck");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "vndr_seq", true, "", dfNone, 0, false, true, 6);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "vndr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 200, daLeft, false, "spot_bid_vndr_eml", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "sp_ptal_exist_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "upd_usr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,80, daCenter, false, "upd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,80, daCenter, false, "spot_bid_cnddt_term_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "upd_usr_id", false, "", dfNone, 0, false, false);

			//InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789"); // 영문대문자,숫자만 입력 
			ShowButtonImage = 2;
			
			//sheetObj.ShowButtonImage = 2;
			//sheetObj.CountPosition = 0;
			
			//sheetObj.ImageList(0) = "/hanjin/img/button/btns_multisearch.gif";
			//sheetObj.PopupButtonImage(1,10) =  0;
			
			//PopupImage  =  "img/btns_multisearch.gif";
			ShowButtonImage = 1;
			ImageList(0) = "img/button/btns_multisearch.gif";
			//ImageList(1) = "img/btns_minus.gif";
			//ImageList(2) = "img/alps/button/btns_multisearch.gif";
			//특정컬럼에 팝업버튼 이미지 변경
			//PopupButtonImage(0, "vndr_seq") = 0;
			PopupButtonImage(0, "spot_bid_vndr_eml") = 0;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBCLEAR:
		if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
			if (ComShowCodeConfirm("PRI00006")) {
				supressConfirm = true;
				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
				supressConfirm = false;
			} else {

				formObj.reset();
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			}
		} else {
			formObj.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		}
		break;

	case IBSEARCH: //조회            	
		try {
			for ( var i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].WaitImageVisible = false;
			}
			if (validateForm(sheetObj, document.form, sAction)) {
				ComOpenWait(true);
				if (sheetObj.id == "sheet1") {
					/*for ( var i = 0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}*/
					
					sheetObjects[1].RemoveAll();

					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESD_TRS_0300GS.do", FormQueryString(formObj));
				} else if (sheetObj.id == "sheet2") {
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch("ESD_TRS_0300GS.do", FormQueryString(formObj));
				}
			}
			ComOpenWait(false);
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		} finally {
			ComOpenWait(false);
		}

		break;

	case IBSAVE: //저장            
		/*if (!validateForm(sheetObj, document.form, sAction)) {
			return false;
		}
		eventStatus = "IBSAVE";
		formObj.f_cmd.value = MULTI01;

		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[0].GetSaveString();
		if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
			return;
		}
		sParam += "&" + ComPriSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");

		var sParamSheet2 = sheetObjects[1].GetSaveString();
		if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
			return;
		}
		sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
		if (!supressConfirm && !ComPriConfirmSave()) {
			return false;
		}

		try {
			for ( var i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].WaitImageVisible = false;
			}
			ComOpenWait(true);

			var sXml = "";
			sXml = sheetObj.GetSaveXml("ESD_TRS_0300GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
			sheetObjects[0].LoadSaveXml(sXml);
			ComOpenWait(false);

		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		} finally {
			ComOpenWait(false);
		}

		if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
			return false;
		} else {
			ComPriSaveCompleted();
			if (getValidRowCount(sheetObjects[0]) >= 1 && getValidRowCount(sheetObjects[1]) <= 0) {
				doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
			}
			return true;
		}

		eventStatus = "";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		*/
		
		if (sheetObj.id == "sheet1") {
			
			/* validate 단일 복합 구분*/
			/*var saveCnt = deleteRowCheck(sheetObj, "ibcheck");
			if (saveCnt > 0 && sheetObj.id == "sheet1") {
				for ( var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
					sheetObjects[1].CellValue(i, "chk") = "1";
				}
				deleteRowCheck(sheetObjects[1], "chk");
			}
			
			for(var i=0; i<sheetObj.length)
			if(){
				
			}
			else{
				
			}*/
			

			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}

			for (var idx=0; idx<arrRow.length-1; idx++){
				var trsp_crr_mod_cd = sheetObj.CellValue( arrRow[idx] ,"trsp_crr_mod_cd" );
				if( !(trsp_crr_mod_cd == "") ){
					
					var fm_loc_value	= sheetObj.CellValue( arrRow[idx] ,"fm_loc_value" );
					var via_loc_value	= sheetObj.CellValue( arrRow[idx] ,"via_loc_value" );
					var dor_loc_value	= sheetObj.CellValue( arrRow[idx] ,"dor_loc_value" );
					var to_loc_value	= sheetObj.CellValue( arrRow[idx] ,"to_loc_value" );
					
					// Door with Fm between TO
					if(trsp_crr_mod_cd == "TD" || trsp_crr_mod_cd == "RD" || trsp_crr_mod_cd == "WD"){	// 단일운송
						// FM between TO
						if( (fm_loc_value != "" || via_loc_value != "" || dor_loc_value != "" || to_loc_value != "") && (fm_loc_value == "" || to_loc_value == "") ){
							ComShowCodeMessage('TRS90704');
							return;
						}
					}
					else{	// 복합운송
						// all or not
						if( (fm_loc_value != "" || via_loc_value != "" || dor_loc_value != "" || to_loc_value != "") && (fm_loc_value == "" || via_loc_value == "" || dor_loc_value == "" || to_loc_value == "") ){
							ComShowCodeMessage('TRS90705');
							return;
						}
					}
				}
			}
			document.form.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0300GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
			//doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else if(sheetObj.id == "sheet2"){

			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var arrRow = checkList.split("|");
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			
			document.form.f_cmd.value = SEARCH07;

			var spot_bid_ofc_cd_tmp = document.form.spot_bid_ofc_cd_tmp.value;
			var queryString = "ctrl_ofc_cd="+spot_bid_ofc_cd_tmp+"&"+TrsFrmQryString(document.form);
			sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

			var ofc_cd = sheetObj.EtcData('OFC_CD');
			sheetObj.RemoveEtcData();
			if(ofc_cd == '' || ofc_cd == undefined){
				//sheetObj.CellValue2(row, colName) = '';
				ComShowCodeMessage('TRS90706');
				return;
			}

			document.form.f_cmd.value = MULTI11;
			sheetObj.DoSave("ESD_TRS_0300GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
		}
		break;

	case IBINSERT: // Row Add
		if (validateForm(sheetObj, document.form, sAction)) {
			if (sheetObj.id == "sheet1") {
				/*var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
				if (idx < 0) {
					return false;
				}
				//contract type
				sheetObj.CellValue(idx, "prc_ctrt_tp_cd") = getPrcCtrtTpCd();
				sheetObjects[1].RemoveAll();
				sheetObj.SelectCell(idx, "note_conv_grp_loc_cd");*/
				
                var row = sheetObj.DataInsert(-1);
    			sheetObj.InitCellProperty(row, 'fm_yard_value', dtCombo);
    			sheetObj.InitCellProperty(row, 'via_yard_value', dtCombo);
    			sheetObj.InitCellProperty(row, 'dor_yard_value', dtCombo);
    			sheetObj.InitCellProperty(row, 'to_yard_value', dtCombo);

    			sheetObj.CellEditable(row,'fm_yard_value') = false;
    			sheetObj.CellEditable(row,'via_yard_value') = false;
    			sheetObj.CellEditable(row,'dor_yard_value') = false;
    			sheetObj.CellEditable(row,'to_yard_value') = false;
				//formObject.sheet1.CellValue2(Row, "save") = "N"; 
				//formObject.sheet1.SelectCell(Row, "vndr_seq");
				//formObject.sheet1.CellValue2(Row, "radio") = "1";
                //sheetObj.RowEditable(Row) = true;
                
                
                
                /*sheetObj.CellEditable(Row,'spot_bid_ofc_cd') = true;
                sheetObj.CellEditable(Row,'trsp_crr_mod_cd') = true;

                sheetObj.CellEditable(Row,'fm_nod_cd') = true;
                sheetObj.CellEditable(Row,'via_nod_cd') = true;
                sheetObj.CellEditable(Row,'dor_nod_cd') = true;
                sheetObj.CellEditable(Row,'to_nod_cd') = true;*/

    			document.form.spot_bid_cnddt_term_seq.value = "";
				document.form.spot_bid_ofc_cd_tmp.value = "";
                sheetObjects[1].RemoveAll();
			}
			if (sheetObj.id == "sheet2") {
				//var idx = sheetObj.DataInsert(-1);
				//sheetObj.CellValue(idx, "prc_ctrt_tp_cd") = getPrcCtrtTpCd();
				//sheetObj.CellValue(idx, "note_conv_grp_loc_cd") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_conv_grp_loc_cd");
				//sheetObj.SelectCell(idx, "loc_cd");
				if(document.form.spot_bid_cnddt_term_seq.value != ""){
					var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue(Row,'spot_bid_cnddt_term_seq') = document.form.spot_bid_cnddt_term_seq.value;
				}else{
					
				}
			}
		}
		break;

	case IBDELETE: // Delete                
		/*if (!validateForm(sheetObj, document.form, sAction)) {
			return false;
		}
		if (sheetObj.CheckedRows("chk") <= 0) {
			sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		}
		var delCnt = deleteRowCheck(sheetObj, "chk");
		if (delCnt > 0 && sheetObj.id == "sheet1") {
			for ( var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
				sheetObjects[1].CellValue(i, "chk") = "1";
			}
			deleteRowCheck(sheetObjects[1], "chk");
		}*/
		
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var arrRow = checkList.split("|");
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		
		if(sheetObj.id == "sheet1") {
			document.form.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESD_TRS_0300GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else if(sheetObj.id == "sheet2"){
			document.form.f_cmd.value = MULTI12;
			sheetObj.DoSave("ESD_TRS_0300GS.do", TrsFrmQryString(document.form), 'ibcheck', false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이승준
 * @version 2009.04.17
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		return true;
		break;

	case IBSAVE: // 저장
		if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
			ComShowCodeMessage("PRI00301");
			return false;
		}

		if (sheetObjects[0].IsDataModified && sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_conv_grp_loc_cd") == "") {
			
			return false;
		}

		if (sheetObjects[0].IsDataModified) {
			var rowM = sheetObjects[0].ColValueDup("prc_ctrt_tp_cd|note_conv_grp_loc_cd", false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet", rowM);
				return false;
			}
		}

		if (sheetObjects[1].IsDataModified) {
			var rowD = sheetObjects[1].ColValueDup("prc_ctrt_tp_cd|note_conv_grp_loc_cd|loc_cd", false);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet", rowD);
				return false;
			}
		}

		//sheet1에서 하나라도 저장했는지 체크
		if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
			
			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
			return false;
		}

		//sheet2에서 하나라도 저장했는지 체크
		//                if (getValidRowCount(sheetObjects[0]) >= 1 && (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0)) {
		//                    ComShowCodeMessage("PRI00319", "Location Type");
		//                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
		//                    return false;
		//                }

		if (!isDeleted(sheetObjects[0]) && getValidRowCount(sheetObjects[1]) <= 0 && sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_conv_grp_loc_cd") != "") {
			ComShowCodeMessage("PRI00319", "Location Group");
			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
			return false;
		}
		return true;
		break;

	case IBINSERT: // Row Add
		return true;
		break;

	case IBDELETE: // Delete
		return true;
		break;
	}

	return true;
}

/**
 * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
 * chg_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {object} comboObj 필수 IBMultiCombo Object
 * @param {string} code 필수 선택된 항목의 value
 * @param {string} text 필수 선택된 항목의 text
 * @returns 없음
 * @author 이승준
 * @version 2009.07.20
 */
function prc_ctrt_tp_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	if (text != null && !ComIsEmpty(text)) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * OnPopupClick 이벤트 발생시 호출되는 function <br>
 * Location PopUp을 호출한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	switch (colName) {
	case "loc_cd":
		/*var sUrl = "/hanjin/ESM_PRI_4026.do";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.cd;
			sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
		}*/
		break;
		
	case "vndr_seq":
		/*var sUrl = "/hanjin/ESM_PRI_4026.do";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.cd;
			sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
		}*/
		if (sheetObj.ColSaveName(Col) == "vndr_seq") {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
		}
		break;
		
	case "spot_bid_vndr_eml":
		/*var sUrl = "/hanjin/ESM_PRI_4026.do";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.cd;
			sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
		}
		if (sheetObj.ColSaveName(Col) == "vndr_seq") {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
		}*/
		openMultipleinquiry('spot_bid_vndr_eml', 'E-Mail', Row);
		break;
	}
}

/**
* 공통 Trunk VVD popup
*/
function openMultipleinquiry(obj, obj2, Row) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var x10 = Row;
	var openver_val = sheetObjects[1].CellValue(Row, "spot_bid_vndr_eml");
	var x11 = openver_val;	// openerval
	var x12 = ";";	// token
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returnrow="+x10+"&openerval="+x11+"&token="+x12;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1', false, false, Row);
}

/**
* Location : 팝업에서 단일 선택을 한경우..
*/
function getTRS_ENS_906(rowArray, obj, row) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ";";
		}
	}
	if( obj == "spot_bid_vndr_eml" ) {
		//formObject.trunk_vvd.value = reObj;
		sheetObjects[1].CellValue(row, "spot_bid_vndr_eml") = reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value = multiCntrChkDgt(reObj);
	} else if( obj == "FVD" ) {
		formObject.txt_feeder_vvd.value = reObj;
	} else if( obj == "ZIP" ) {
		formObject.zip_code.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}


/**
* 콜백 함수. <br>
* @param  {Array} aryPopupData	필수	 Array Object
* @param  {Int} row				필수 선택한 Row
* @param  {Int} col				필수 선택한 Column
* @param  {Int} sheetIdx		필수 Sheet Index
* @return 없음
* @author 
* @version 2013.03.21
*/   
function callBackLocation(aryPopupData, row, col, sheetIdx){
   var sheetObj = sheetObjects[1];
   var vndrSeq = "";
   var vndrNm = "";
   var i = 0;

   for(i = 0; i < aryPopupData.length; i++){
	   vndrSeq = vndrSeq + aryPopupData[i][2];
	   vndrNm = vndrNm + aryPopupData[i][4];
   }
   sheetObj.CellValue2(row, "vndr_seq") = vndrSeq;
   sheetObj.CellValue2(row, "vndr_nm") = vndrNm;
   
   getSheetVendorSeq(sheetObj, document.form, vndrSeq, row);
}

/**
 * sheet에서 데이터가 변경시 호출된다. <br>
 * <br><b>Example :</b>
 * <pre>
 *    
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 
 * @param {int} Col 
 * @param {String} Value 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	if (!checkNode(sheetObj, row, colName, value)) return;
//	formObject.TRSP_SO_EQ_KIND.value = '';
	if(value.length == 5) {
		formObject.f_cmd.value = SEARCH01;
		switch(colName){
			case 'fm_loc_value':
				if(sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') == 'CN'){
//					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=fm_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'fm_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'fm_yard_value') = true;

				fm_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();

				if(fm_yard_value == '' || fm_yard_value == undefined){
					ComShowCodeMessage('TRS90074');
					sheetObj.CellValue2(row, colName) = '';
					sheetObj.CellEditable(row,'fm_yard_value') = false;
					return;
				}
				sheetObj.CellComboItem(row, 'fm_yard_value', " |"+fm_yard_value, " |"+fm_yard_value);
				break;

			case 'to_loc_value':
				if(sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') == 'CF'){
//					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=to_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'to_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'to_yard_value') = true;
				
				to_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				
				if(to_yard_value == '' || to_yard_value == undefined){
					ComShowCodeMessage('TRS90074');
					sheetObj.CellValue2(row, colName) = '';
					sheetObj.CellEditable(row,'to_yard_value') = false;
					return;
				}
				sheetObj.CellComboItem(row, 'to_yard_value', " |"+to_yard_value, " |"+to_yard_value);
				break;

			case 'via_loc_value':
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=via_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'via_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'via_yard_value') = true;
				
				via_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				
				if(via_yard_value == '' || via_yard_value == undefined){
					ComShowCodeMessage('TRS90074');
					sheetObj.CellValue2(row, colName) = '';
					sheetObj.CellEditable(row,'via_yard_value') = false;
					return;
				}
				sheetObj.CellComboItem(row, 'via_yard_value', " |"+via_yard_value, " |"+via_yard_value);
				break;

			case 'dor_loc_value':
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "isZone=Y&col=dor_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'dor_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'dor_yard_value') = true;
				
				dor_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				
				if(dor_yard_value == '' || dor_yard_value == undefined){
					ComShowCodeMessage('TRS90074');
					sheetObj.CellValue2(row, colName) = '';
					sheetObj.CellEditable(row,'dor_yard_value') = false;
					return;
				}
				sheetObj.CellComboItem(row, 'dor_yard_value', " |"+dor_yard_value, " |"+dor_yard_value);
				break;
		}
	}else if(value.length == 2)
	{
		removeYard(sheetObj, row, colName, value);
		formObject.f_cmd.value = SEARCH02;
		switch(colName){
			case 'fm_loc_value':
				var queryString = "col=fm_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

				var cntCd = sheetObj.EtcData('CNT_CD');
				sheetObj.RemoveEtcData();
				if(!checkCountry(cntCd)){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'fm_yard_value') = false;
				break;

			case 'to_loc_value':
				var queryString = "col=to_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

				var cntCd = sheetObj.EtcData('CNT_CD');
				sheetObj.RemoveEtcData();
				if(!checkCountry(cntCd)){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'to_yard_value') = false;
				break;

			case 'via_loc_value':
				var queryString = "col=via_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

				var cntCd = sheetObj.EtcData('CNT_CD');
				sheetObj.RemoveEtcData();
				if(!checkCountry(cntCd)){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'via_yard_value') = false;
				break;

			case 'dor_loc_value':
				var queryString = "col=dor_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);

				var cntCd = sheetObj.EtcData('CNT_CD');
				sheetObj.RemoveEtcData();
				if(!checkCountry(cntCd)){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'dor_yard_value') = false;
				break;
		}
	}

	switch(colName){
		/*case 'ctrl_ofc_div_cd':
		case 'fm_loc_value':
		case 'to_loc_value':
		case 'via_loc_value':
		case 'dor_loc_value':
			setControlOfficeSettring(sheetObj, row);
			break;
		case 'delcheck':
			if (value == '1'){
				sheetObj.CellValue2(row, 'delt_flg') = 'Y';
			}else{
				sheetObj.CellValue2(row, 'delt_flg') = 'N';
			}
			if(sheetObj.CellValue(row, 'org_delt_flg') == sheetObj.CellValue(row, 'delt_flg')){
				sheetObj.RowStatus(row) = 'R';
			}
			break;
		case 'cgo_tp_cd':
			if(value=='F'){
				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', ""+F_trsp_cost_dtl_mod_cdText, ""+F_trsp_cost_dtl_mod_cdCode);
				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', ""+trsp_crr_mod_cdText, ""+trsp_crr_mod_cdCode);
			}else if(value=='M'){
				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', ""+M_trsp_cost_dtl_mod_cdText, ""+M_trsp_cost_dtl_mod_cdCode);
				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', ""+M_trsp_crr_mod_cdText, ""+M_trsp_crr_mod_cdCode);
			}
			break;*/
		case 'spot_bid_ofc_cd':
			value = value.toUpperCase();
			sheetObj.CellValue2(row, colName) = value;
			if(ComTrim(value) != ''){
				
				// 권한 5. Login 오피스 기준 상위 오피스가 하위 오피스 등록 권한을 가지며 동일한 레벨의 오피스 data는 등록 및 수정 불가
				/*
				var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
				document.form.old_ofc_cd.value = prm_office;
				createHttpRequest();
				request.open("GET", url, false);
				request.onreadystatechange = subCntorlOffice;
				request.send(null);
				//document.form.spot_bid_ofc_cd.disabled = true;
				*/
				
				/*
				formObject.f_cmd.value = SEARCH11;
				formObject.old_ofc_cd.value = SEARCH11;
				var prm_office = doSepRemove(document.form.spot_bid_ofc_cd.value.toUpperCase(), " "); //input text
				var queryString = "ctrl_so_office="+prm_office+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0002GS.do", queryString);
				
				//var ofc_cd = sheetObj.EtcData('OFFICE');
				var ofc_cd = sheetObj.EtcData('OFFICE');
				*/
				
				//alert(sheetObj.CellValue(row, 'OFFICE'));
				//alert(sheetObj.CellValue(row, 'OFFICE'));
				//alert(ofc_cd);
				
				/*
				formObject.f_cmd.value = SEARCH06;
				var queryString = "ctrl_ofc_cd="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				//sheetObj.DoSearch("ESD_TRS_0079GS.do", queryString);
				
				var ofc_cd = sheetObj.EtcData('OFC_CD');
				sheetObj.RemoveEtcData();
				if(ofc_cd == '' || ofc_cd == undefined){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				*/
				formObject.f_cmd.value = SEARCH07;
				var queryString = "ctrl_ofc_cd="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				//sheetObj.DoSearch("ESD_TRS_0079GS.do", queryString);
				
				var ofc_cd = sheetObj.EtcData('OFC_CD');
				sheetObj.RemoveEtcData();
				if(ofc_cd == '' || ofc_cd == undefined){
					sheetObj.CellValue2(row, colName) = '';
					ComShowCodeMessage('TRS90706');
					return;
				}
			}
			break;

		case 'trsp_crr_mod_cd':
			if(ComTrim(value) != ''){

				// TRANSMODE 에 따른 VIA 비활성화처리
				if(value == "TD" || value == "RD" || value == "WD"){	// 단일운송
					sheetObj.CellValue2(row, 'via_loc_value') = '';
					sheetObj.CellValue2(row, 'via_yard_value') = '';
					sheetObj.CellEditable(row,'via_loc_value') = false;
					sheetObj.CellEditable(row,'via_yard_value') = false;
				}else{
					sheetObj.CellEditable(row,'via_loc_value') = true;
					sheetObj.CellEditable(row,'via_yard_value') = true;
				}
			}
			break;
	}

	switch(colName){
		case('fm_loc_value'):
		case('fm_yard_value'):
			sheetObj.CellValue2(row, 'fm_nod_cd') = sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
			break;
		case('to_loc_value'):
		case('to_yard_value'):
			sheetObj.CellValue2(row, 'to_nod_cd') = sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
			break;
		case('via_loc_value'):
		case('via_yard_value'):
			sheetObj.CellValue2(row, 'via_nod_cd') = sheetObj.CellValue(row, 'via_loc_value')+sheetObj.CellValue(row, 'via_yard_value');
			break;
		case('dor_loc_value'):
		case('dor_yard_value'):
			sheetObj.CellValue2(row, 'dor_nod_cd') = sheetObj.CellValue(row, 'dor_loc_value')+sheetObj.CellValue(row, 'dor_yard_value');
			break;
	}
}

// SO Office의 값을 가지고 온다.
function checkSpotBidOfcCd() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.spot_bid_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

/**
 * sheet에서 데이터가 변경시 호출된다. <br>
 * <br><b>Example :</b>
 * <pre>
 *    
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 
 * @param {int} Col 
 * @param {String} Value 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	var formObj = document.form
	switch (colname) {
	case('vndr_seq'):
		//Vendor Code Validation 추가 2013.11.13 조인영
		if(Value == "") {
			sheetObj.CellValue2(Row, 'vndr_seq') 		= '';
			sheetObj.CellValue2(Row, 'vndr_nm') 		= '';
			sheetObj.CellValue2(Row, 'spot_bid_vndr_eml')	= '';
			sheetObj.CellValue2(Row, 'sp_ptal_exist_flg')	= '';
			return false;
		}
		if(!ComIsNumber(Value)) {
			ComShowCodeMessage('COM12122', 'S/P Code');
			sheetObj.SelectCell(Row, 'vndr_seq');
			return false;
			}
		if(Value.length > 6){
			ComShowCodeMessage('COM131901', 'S/P Code');
			sheetObj.SelectCell(Row, 'vndr_seq');
			return false;
		}
		getSheetVendorSeq(sheetObj, formObj, Value, Row);
		break;
	}
}

function getSheetVendorSeq(sheetObj, formObj, vndr_seq, row){
	
	var returnFlg = false;
	formObj.f_cmd.value = SEARCH11;
	formObj.combo_svc_provider.value = vndr_seq; 
		//get_only_num(vndr_seq);
	sheetObj.RemoveEtcData();
	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));

	var vendorNoList 	= sheetObj.EtcData('vndr_no');
	var vendorNmList 	= sheetObj.EtcData('vndr_nm_eng');
	var vendorEmlList 	= sheetObj.EtcData('vndr_eml');
	var spPtalExistFlg 	= sheetObj.EtcData('sp_ptal_exist_flg');
	var cnddtVndrFlg 	= sheetObj.EtcData('cnddt_vndr_flg');			// VNDR_SEQ 중복여부
	//var vendorCurr 		= sheetObj.EtcData('vndr_cnt_curr_cd');
	//var hzdMtrlFlg		= sheetObj.EtcData('hzd_mtrl_flg');
	//var ovwtTriAxlFlg 	= sheetObj.EtcData('ovwt_tri_axl_flg');
	if (vendorNoList == undefined || vendorNoList == '' || cnddtVndrFlg == 'Y'){
		//formObj.combo_svc_provider.value 				= '';
		sheetObj.CellValue2(row, 'vndr_seq') 			= '';
		sheetObj.CellValue2(row, 'vndr_nm') 			= '';
		sheetObj.CellValue2(row, 'spot_bid_vndr_eml')	= '';
		sheetObj.CellValue2(row, 'sp_ptal_exist_flg')	= '';
		//sheetObj.CellValue2(row, 'default_curr') 	= '';
		//sheetObj.CellValue2(row, 'hzd_mtrl_flg') 	= '';
		//sheetObj.CellValue2(row, 'ovwt_tri_axl_flg')= '';
		
		if(cnddtVndrFlg == 'Y'){
			ComShowMessage("Duplicate S/P Code");
		}
		returnFlg = false;
	}else{
		//sheetObj.CellValue2(row, 'vndr_seq') 		 = ComTrim(vendorNoList);
		sheetObj.CellValue2(row, 'vndr_seq')		 = ComLpad(vendorNoList, 6, "0");
		sheetObj.CellValue2(row, 'vndr_nm') 		 = vendorNmList;
		sheetObj.CellValue2(row, 'spot_bid_vndr_eml')= vendorEmlList;
		sheetObj.CellValue2(row, 'sp_ptal_exist_flg')= spPtalExistFlg;
		//sheetObj.CellValue2(row, 'default_curr') 	 = vendorCurr;
		//sheetObj.CellValue2(row, 'hzd_mtrl_flg') 	 = hzdMtrlFlg;
		//sheetObj.CellValue2(row, 'ovwt_tri_axl_flg') = ovwtTriAxlFlg;
		returnFlg = true;

	}

	/*if(vendorCurr == undefined || vendorCurr == ''){
		sheetObj.CellValue2(row, 'default_curr') = defaultLoginOfficeCurr;
	}*/
	return returnFlg;
}

/**
 * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
 * <br><b>Example :</b>
 * <pre>
 *      locationCellClear(sheetObj,Row)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */
function locationCellClear(sheetObj, Row) {
	sheetObj.CellValue2(Row, "loc_cd") = "";
	sheetObj.CellValue2(Row, "loc_des") = "";
	sheetObj.SelectCell(Row, "loc_cd");
}

/**
 * sheet에서 cell을 클릭한 경우 발생. <br>
 * <br><b>Example :</b>
 * <pre>
 *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} OldRow 
 * @param {int} OldCol 
 * @param {int} NewRow 
 * @param {int} NewCol 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	//doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
}

var isFiredNested = false;
var supressConfirm = false;

/**
 * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
 * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
 * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} OldRow 
 * @param {int} OldCol 
 * @param {int} NewRow 
 * @param {int} NewCol 
 * @param {String} sAction
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
	var formObj = document.form;
	var adjNewRow = NewRow;
	if (!isFiredNested && (OldRow != NewRow)) {
		if (sheetM.IsDataModified) {
			isFiredNested = true;
			sheetM.SelectCell(OldRow, OldCol, false);
			isFiredNested = false;
			if (validateForm(sheetM, document.form, IBSAVE)) {
				isFiredNested = true;
				sheetM.SelectCell(NewRow, NewCol, false);
				isFiredNested = false;
			} else {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			}
		}
		if (sheetD.IsDataModified) {
			isFiredNested = true;
			sheetM.SelectCell(OldRow, OldCol, false);
			isFiredNested = false;

			var rslt = false;
			if (ComShowCodeConfirm("PRI00006")) {
				supressConfirm = true;
				adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
				var rslt = doActionIBSheet(sheetM, document.form, IBSAVE);
				supressConfirm = false;
			}
			if (rslt) {
				isFiredNested = true;
				sheetM.SelectCell(adjNewRow, NewCol, false);
				isFiredNested = false;
			} else {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			}
		}
		if (appendRow) {
			isFiredNested = true;
			var idx = sheetM.DataInsert(-1);
			isFiredNested = false;
			return idx;
		} else {
			formObj.f_cmd.value = SEARCH02;
			formObj.note_conv_grp_loc_cd.value = sheetM.CellValue(NewRow, "note_conv_grp_loc_cd");
			if (formObj.note_conv_grp_loc_cd.value == "undefined" || ComIsEmpty(formObj.note_conv_grp_loc_cd.value)) {
				formObj.note_conv_grp_loc_cd.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_conv_grp_loc_cd");
			}

			try {
				ComOpenWait(true);
				sheetD.DoSearch("ESD_TRS_0300GS.do", FormQueryString(formObj));
				ComOpenWait(false);

			} catch (e) {
				if (e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e);
				}
			} finally {
				ComOpenWait(false);
			}
		}
	}
}

/**
 * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
 * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {String} Row 
 * @param {String} Col 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
	/*var colName = sheetObj.ColSaveName(Col);

	if (colName == "chk") {
		ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
	}*/
}
/**
 * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
 * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {String} Row 
 * @param {String} Col 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
	/*var colName = sheetObj.ColSaveName(Col);

	if (colName == "chk") {
		ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
	}*/
}


/**
 * sheet0 COLUMN double click시 발생하는 EVENT
 */
//function sheet1_OnDblClick(sheetObj, row, col) {
function sheet1_OnClick(sheetObj, row, col) {
	//CHM-201535825 Surcharge confirm 대상 추가
	/*if (sheetObject.CellValue(row, 'rate_cfm_target_cnt')>0  ) {
		popUpRate(sheetObject, row, col);
	}else if (sheetObject.CellValue(row, 'scg_rate_cfm_target_cnt')>0  ) {
		popUpScgRate(row, col);
	}*/
	if(sheetObj.RowStatus(row) != "I" && col > 1){
		document.form.spot_bid_cnddt_term_seq.value = sheetObj.CellValue(row, 'spot_bid_cnddt_term_seq');
		document.form.spot_bid_ofc_cd_tmp.value = sheetObj.CellValue(row, 'spot_bid_ofc_cd');
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
}

/**
 * Sheet1에서 Delete 이벤트를 발생시킴.
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	//if( errMsg.length > 0 ) {
	if( errMsg != null && errMsg != '' ){
		//ComShowMessage(errMsg);
	} else {
		
		// 저장시 체크로직에 의한 Msg 1.Save 2. Not Save
		ComShowCodeMessage('TRS90511');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * Sheet1에서 Delete 이벤트를 발생시킴.
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
}


//Office의 Text 변경시
function fun_officeText() {
	document.form.spot_bid_ofc_cd.value = document.form.spot_bid_ofc_cd.value.toUpperCase();
	//document.form.chk_office.checked = false;
}

//Include Check Bok를 Click했을 때
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.spot_bid_ofc_cd.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.spot_bid_ofc_cd.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		document.form.spot_bid_ofc_cd.disabled = false;
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
		document.form.spot_bid_ofc_cd.disabled = true;
	} else {
		document.form.spot_bid_ofc_cd.value = document.form.old_ofc_cd.value;
		document.form.spot_bid_ofc_cd.disabled = false;
	}
}

//Include Office를 처리하기 위한 Logic
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

//Office의 값을 가지고 온다.
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.spot_bid_ofc_cd.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

//Office-PopUp Validation Checked
function validation_check() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.spot_bid_ofc_cd.value.toUpperCase(), " "); //input text
	var aoffice = prm_office.split(",");
	if( prm_office == "" ) {
		document.form.spot_bid_ofc_cd.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
		return false;
	} else {
		if( aoffice.length == 1 ) {
			return true;
		} else {
			ComShowMessage("You can inquire the 'Office Help' popup for one office code at a time");
			return false;
		}
	}
}

function checkNode(sheetObj, row, colName, value)
{
	if (colName != 'fm_loc_value' && colName != 'to_loc_value' && colName != 'via_loc_value' && colName != 'dor_loc_value' )
	{
		return true;
	}

	if(value.length != 2 && value.length != 5)
	{
		switch(colName){
			case 'fm_loc_value':
				sheetObj.CellValue2(row, 'fm_loc_value')="";
				break;
			case 'to_loc_value':
				sheetObj.CellValue2(row, 'to_loc_value')="";
				break;
			case 'via_loc_value':
				sheetObj.CellValue2(row, 'via_loc_value')="";
				break;
			case 'dor_loc_value':
				sheetObj.CellValue2(row, 'dor_loc_value')="";
				break;
		}
		removeYard(sheetObj, row, colName, value);
		return false;
	}

	return true;
}

function removeYard(sheetObj, row, col, value){
	switch(col){
			case 'fm_loc_value':
				sheetObj.CellValue2(row, 'fm_yard_value')="";
				sheetObj.CellComboItem(row, 'fm_yard_value', '', '');
				break;
			case 'to_loc_value':
				sheetObj.CellValue2(row, 'to_yard_value')="";
				sheetObj.CellComboItem(row, 'to_yard_value', '', '');
				break;
			case 'via_loc_value':
				sheetObj.CellValue2(row, 'via_yard_value')="";
				sheetObj.CellComboItem(row, 'via_yard_value', '', '');
				break;
			case 'dor_loc_value':
				sheetObj.CellValue2(row, 'dor_yard_value')="";
				sheetObj.CellComboItem(row, 'dor_yard_value', '', '');
				break;
		}
}

function setControlOfficeSettring(sheetObj, row){
	var value = sheetObj.CellValue(row, 'ctrl_ofc_div_cd');
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH03;
	var selectColumnName = '';
	if(value == 'F') selectColumnName = 'fm_loc_value';
	else if(value == 'T') selectColumnName = 'to_loc_value';
	else if(value == 'V') selectColumnName = 'via_loc_value';
	else if(value == 'D') selectColumnName = 'dor_loc_value';
	var locationValue = sheetObj.CellValue(row, selectColumnName);

	if(locationValue.length == 5){
		var queryString = "col=ctrl_ofc_cd&row="+row+"&searchStr="+locationValue+"&"+TrsFrmQryString(formObject);
			sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	}else{
		sheetObj.CellValue2(row, 'ctrl_ofc_cd') = '';
	}
}

function checkCountry(value)
{
	if(value == '' || value == undefined)
	{
		ComShowCodeMessage('TRS90115');
		return false;
	}else{
		return true;
	}
}

function checkLocation(value)
{
	if(value == '' || value == undefined)
	{
		ComShowCodeMessage('TRS90074');
		return false;
	}else{
		return true;
	}
}

//control s/o office code return value.
function rtn_office_code(obj) {
	document.form.spot_bid_ofc_cd.value = obj;
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'wo_no':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case 'vndr_seq':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;

			case 'search_fm_loc':
			case 'search_via_loc':
			case 'search_to_loc':
			case 'search_door_loc':
				getComboList(obj);
				break;

			case 'tvvd_no':
			case 'fvvd_no':
			case 'bkg_no':
			case 'bl_no':
			case 'eq_no':
			case 'so_no':
			case 'wo_no':
			case 'mty_rfrn_no':
				obj.value = obj.value.toUpperCase();
				break;
		}
	}
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick()
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		formObj.vndr_seq.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}
/**
 * sheet 위에서 마우스가 욺직일때 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long}	X			X 좌표
 * @param {long}	Y			Y 좌표
 * @return
 */	
function sheet2_OnMouseMove(t1sheet2, Button, Shift, X, Y) {
	var row = t1sheet2.MouseRow;
	var col = t1sheet2.MouseCol;
	if (t1sheet2.ColSaveName(col) == "vndr_nm" && row >= 1
			&& t1sheet2.CellValue(row, "vndr_nm") != null
			&& t1sheet2.CellValue(row, "vndr_nm") != '') {
		t1sheet2.ToolTipText(row, col) = t1sheet2.CellValue(row, "vndr_nm");
	}else if (t1sheet2.ColSaveName(col) == "spot_bid_vndr_eml" && row >= 1
			&& t1sheet2.CellValue(row, "spot_bid_vndr_eml") != null
			&& t1sheet2.CellValue(row, "spot_bid_vndr_eml") != '') {
		t1sheet2.ToolTipText(row, col) = t1sheet2.CellValue(row, "spot_bid_vndr_eml");
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	
	if( errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH01) {
			if(sheetObj.RowCount > 0){
				document.form.spot_bid_cnddt_term_seq.value = sheetObj.CellValue(1, 'spot_bid_cnddt_term_seq');
				document.form.spot_bid_ofc_cd_tmp.value = sheetObj.CellValue(1, 'spot_bid_ofc_cd');
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			}
		}
	}
}

/* 개발자 작업  끝 */