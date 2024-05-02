/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N003.js
 *@FileTitle : Canada Export: Amendment Transmit (AI)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_n003() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var end_no = 0;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH);
			break;
		case "btn_New":
			formObject.reset();

			//US AMS Main Menu : VVD 입력시
			ComClearManyObjects(document.form.vvd_cd,"");
			ComClearManyObjects(document.form.pol_cd,"");
			ComClearManyObjects(document.form.pod_cd,"");
			
			sheetObject.RemoveAll();
			break;
		case "btn_downexcel":
			if (sheetObject.RowCount < sheetObject.TotalRows) {
				ComOpenWait(true);
				end_no = sheetObject.TotalRows;
				sheetObject.TopRow = sheetObject.RowCount;
				ComOpenWait(false);
			}
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_Print":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				if (sheetObject.RowCount < sheetObject.TotalRows) {
					ComOpenWait(true);
					end_no = sheetObject.TotalRows;
					sheetObject.TopRow = sheetObject.RowCount;
					ComOpenWait(false);
				}
				ComOpenWindowCenter("/hanjin/ESM_BKG_0871.do?pgmNo=ESM_BKG_0871", "0871", 1024, 768, false);
			}
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI02);
			break;
		case "btn_StartAI":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_SelectAll":
			sheetObjects[0].CheckReverse("chk");
			break;

		case "btn_BlInquiry":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, "bl_no");
			}
			break;
		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.s_snd_dt, formObject.e_snd_dt, 'yyyy-MM-dd');
			break;
		case "btn_DeleteAI":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;		
        case "ai_div":
        	
        	if ( sheetObject.TotalRows > 0 )
        		doActionIBSheet(sheetObject, formObject, SEARCH);
        	
        	if ( formObject.ai_div[0].checked ) {
        		formObject.ai_type.disabled = false;
        		formObject.sts_div.disabled = true;
        		ComBtnEnable("btn_StartAI");
    			ComBtnDisable("btn_DeleteAI");
        		sheetObjects[0].ColHidden("ai_type") = false;
        		sheetObjects[0].ColHidden("action_code") = false;  		
        	} else if ( formObject.ai_div[1].checked ) {
        		formObject.ai_type.disabled = true;
        		formObject.sts_div.disabled = false;
        		ComBtnDisable("btn_StartAI");     
        		ComBtnEnable("btn_DeleteAI");
        		sheetObjects[0].ColHidden("ai_type") = true;
        		sheetObjects[0].ColHidden("action_code") = true;  		
        	}	
        	
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}



/**
 * Change 이벤트를 처리한다.<br>
 * 
 * @return 없슴
 * @author 
 * @version 2009.07.09
 */
function obj_click() {
	var formObject = document.form;
	    switch(event.srcElement.name) {
			case "ai_div":
				if ( formObject.ai_div[0].checked ) {
					document.getElementById('ai_type').style.background="#FFFFFF";
					document.getElementById('sts_div').style.background="#CCCCCC";					
				} else {
					document.getElementById('ai_type').style.background="#CCCCCC";					
					document.getElementById('sts_div').style.background="#FFFFFF";					
				} 
			break;				
	    }
 }
/**
 * Change 이벤트를 처리한다.<br>
 * 
 * @return 없슴
 * @author 
 * @version 2009.07.09
 */
function obj_change() {
	var formObject = document.form;
	    switch(event.srcElement.name) {
			case "sts_div":
				if (formObject.sts_div.value == "A" ) { 
					ComBtnEnable("btn_DeleteAI");
				} else { // D
					ComBtnDisable("btn_DeleteAI");
				}
				doActionIBSheet(sheetObjects[0], formObject, SEARCH);				
		    break;
	    }
 }   	

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
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
	
	var formObject = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	formObject.vvd_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener("change","obj_change", "sts_div");
	axon_event.addListenerForm('click', 'obj_click', formObject); // click
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd_cd)){
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	}

	//Immediate Delete & AI Disabled
	formObject.ai_type.disabled = false;
	formObject.sts_div.disabled = true;
	ComBtnEnable("btn_StartAI");
	ComBtnDisable("btn_DeleteAI");
	document.getElementById('ai_type').style.background="#FFFFFF";
	document.getElementById('sts_div').style.background="#CCCCCC";
	
	//Origin office 권한 없음
	if ( formObject.pgmNo.value == "ESM_BKG_0028_1" || formObject.pgmNo.value == "ESM_BKG_0028_3") {
		formObject.ai_div[1].disabled = true;
	}
	
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 404;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			EditableColorDiff = true;
			Editable = true;
			UnEditableColor = rgbColor(255,255,255);

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);

			var HeadTitle1 = " ||Seq.|AI Type|Manifest File No.|M/H|B.Filer|Master B/L No.|ERR|B.STS|T.VVD|T.BDR|C/A No.|B.POL|B.POD|VSL EDI|B/L EDI|B/L EDI|B/L EDI|C.Filer|C.STS|Action Code||bkg_no|full_mty_cd|cstms_trsm_sts_cd|pol_cd|pod_cd|bkg_del_cd|save_chk";
			var HeadTitle2 = " ||Seq.|AI Type|Manifest File No.|M/H|B.Filer|Master B/L No.|ERR|B.STS|T.VVD|T.BDR|C/A No.|B.POL|B.POD|VSL EDI|Sent|VVD|Sent Time|C.Filer|C.STS|Action Code||bkg_no|full_mty_cd|cstms_trsm_sts_cd|pol_cd|pod_cd|bkg_del_cd|save_chk";  

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, true, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox,20,daCenter, true,  "chk",               false, "", dfNone, 0, true, false);
			InitDataProperty(0, cnt++, dtDataSeq, 30,daCenter, true,  "Seq",               false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,   60, daCenter, true,  "ai_type",           false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   100,daCenter, true,  "bl_no",             false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   30, daCenter, true,  "mh",                false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "cstms_file_cd",     false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   100,daCenter, true,  "mbl_no",            false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "error",             false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "bkg_sts_cd",        false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   90, daCenter, true,  "t_vvd_cd",          false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "bdr_flg",           false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   80, daCenter, true,  "ca_no",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData,   60, daCenter, true,  "bkg_pol_cd",        false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   60, daCenter, true,  "bkg_pod_cd",        false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   50, daCenter, true,  "v_mi",              false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, false, "b_mi",              false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   90, daCenter, false, "b_vvd_cd",          false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   110,daCenter, false, "mi_snd_dt",         false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "cstms_file_tp_cd",  false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   40, daCenter, true,  "mf_sts_cd",         false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData,   80, daCenter, true,  "action_code",       false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "action_desc",       false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "bkg_no",            false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "full_mty_cd",       false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "cstms_trsm_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "pol_cd",            false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "pod_cd",            false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "bkg_del_cd",        false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, true, "save_chk",          false, "", dfNone, 0, true, false);//1건씩 처장하기위함
			
			ColHidden("save_chk") = true;
			sheetObj.DataLinkMouse("error") = true;
			CountFormat = "[SELECTDATAROW / TOTALROWS]";
			
		}
		break;
	case "sheet2": //sheet1 init
		with (sheetObj) {// 높이 설정
			style.height = 100;
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
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle = "|RESULT";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "bl_no", false, "", dfNone, 0, false, false);
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_N003GS.do", FormQueryString(formObj));
			end_no = 0;
			ComOpenWait(false);
		}
		break;

	case MULTI: //Start AI
		if (!validateForm(sheetObj, formObj, sAction)) return;
			
		if (sheetObj.CheckedRows("chk") < 1 ) {
			return;
		}
		
		var strResult = "";
		ComOpenWait(true);
			
		var arrRows = sheetObj.FindCheckedRow("chk").split("|");
		//@ 1건씩 필요한 데이타만 네트워크 처리하기 위해 별도의 check 칼럼을 체크한다.
		sheetObj.CheckAll2("save_chk") = "0";//모두 uncheck 한다.
		sheetObj.CellValue2(arrRows[0],"save_chk") = "1"; 
		var sParam = sheetObj.GetSaveString(false,true,"save_chk") + "&f_cmd=" + MULTI + "&cnt_cd=" + formObj.cnt_cd.value;
		var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_N003GS.do", sParam);
		
		if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
			sheetObj.CellValue2(arrRows[0], "chk") = "0";
			//@ 처리 후 다음 건 처리  
			if (sheetObj.CheckedRows("chk") > 0) {
				doActionIBSheet(sheetObj, formObj, MULTI);
			} else {
				ComShowCodeMessage("BKG00166");
				doActionIBSheet(sheetObj, formObj, SEARCH);
			}
		} else {
			sheetObj.LoadSearchXml(sXml);
			strResult = "F";
		}
		
		ComOpenWait(false);

		break;
	case IBSEARCHAPPEND: // 페이징 조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_N003GS.do", CondParam, "page_no=" + PageNo + "&end_no=" + end_no, true);
		break;
		
	case MULTI01: //Delete&AI		
		if (!validateForm(sheetObj, formObj, sAction)) return;
		
		if (sheetObj.CheckedRows("chk") < 1 ) {
			return;
		}
		var strResult = "";
		ComOpenWait(true);
		
		var arrRows = sheetObj.FindCheckedRow("chk").split("|");
		//@ 1건씩 필요한 데이타만 네트워크 처리하기 위해 별도의 check 칼럼을 체크한다.
		sheetObj.CheckAll2("save_chk") = "0";//모두 uncheck 한다.
		sheetObj.CellValue2(arrRows[0],"save_chk") = "1"; 
		var sParam = sheetObj.GetSaveString(false,true,"save_chk")+ "&f_cmd=" + MULTI01 + "&" + FormQueryString(formObj) + "&bl_no=" + sheetObj.CellValue(arrRows[0], "bl_no");
		var sXml = sheetObjects[1].GetSaveXml("ESM_BKG_N003GS.do", sParam);
		
		if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
			sheetObj.CellValue2(arrRows[0], "chk") = "0";
			//@ 처리 후 다음 건 처리  
			if (sheetObj.CheckedRows("chk") > 0) {
				doActionIBSheet(sheetObj, formObj, MULTI01);
			} else {
				ComShowCodeMessage("BKG00166");
				doActionIBSheet(sheetObj, formObj, SEARCH);
			}
		} else {
			sheetObj.LoadSearchXml(sXml);
			strResult = "F";
		}
		
		ComOpenWait(false);
		break;
		
		case MULTI02:    // Save 현재 저장 기능 없음.
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("COM130503");    // "There is no updated data to save."
				return;
			}
			if (sheetObj.RowCount() > 0 && sheetObj.GetSaveString(true) == "") return;    // Sheet1의 Mandatory Check 용도
			if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_BKG_N003GS.do", {Param:FormQueryString(formObj), Quest:0, Sync:1});
			ComOpenWait(false);
		break;	
		
	}
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 * @return
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	
	sheet1_OnClick(sheetObj, 2, 1);
	for ( var i = 2; i < sheetObj.RowCount + 2; i++) {
		// Origin의 경우 BDR이면 체크하지 못함
		if (formObj.customs.value == "Origin") {
			if (sheetObj.CellValue(i, "bdr_flg") == "Y") {
				sheetObj.CellEditable(i, "chk") = false;
				sheetObj.CellBackColor(i, "chk") = sheetObj.RgbColor(239,240,243);
			}
		}
		// 에러가 있으면 체크불가(단, B.STS:X/S/A는 제외)
		if (sheetObj.CellValue(i, "bkg_sts_cd") != 'X' && sheetObj.CellValue(i, "bkg_sts_cd") != 'S'
				&& sheetObj.CellValue(i, "bkg_sts_cd") != 'A' && sheetObj.CellValue(i, "error") != "") {
			sheetObj.CellEditable(i, "chk") = false;
			sheetObj.CellBackColor(i, "chk") = sheetObj.RgbColor(239, 240, 243);
		}
		if (sheetObj.CellValue(i, "mh") == "H") {
			sheetObj.CellFontColor(i, "bl_no") = sheetObj.RgbColor(0, 0, 255);
		}
		if (sheetObj.CellValue(i, "b_mi") == "N") {
			sheetObj.CellFontColor(i, "b_mi") = sheetObj.RgbColor(255, 0, 0);
		}
		if (sheetObj.CellValue(i, "t_vvd_cd") != sheetObj.CellValue(i, "b_vvd_cd")) {
			sheetObj.CellFontColor(i, "b_vvd_cd") = sheetObj.RgbColor(255, 0, 0);
		}
		if (sheetObj.CellValue(i, "mf_sts_cd") == "A") {
			sheetObj.CellFontColor(i, "mf_sts_cd") = sheetObj.RgbColor(0, 0, 255);
		} else if (sheetObj.CellValue(i, "mf_sts_cd") == "D") {
			sheetObj.CellFontColor(i, "mf_sts_cd") = sheetObj.RgbColor(255, 0, 0);
		}
		sheetObj.ColFontColor("error") = sheetObj.RgbColor(255, 0, 0);
		sheetObj.CellFontUnderline(i, "error") = true;
	}
}
 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		if (ComIsNull(formObj.mbl_no) && ComIsNull(formObj.bkg_no) 
				&& (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pol_cd))
				&& (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pod_cd))
				&& (!formObj.snd_dt_flg.checked)) {
			ComShowCodeMessage('BKG00406');
			return false;
		}
		if (formObj.snd_dt_flg.checked) {
			var diffDate = ComGetDaysBetween(formObj.s_snd_dt, formObj.e_snd_dt);
			var year = formObj.s_snd_dt.value.substring(0, 4);
			var month = formObj.s_snd_dt.value.substring(5, 7);
			var lastDay = ComGetLastDay(year, parseInt(month));			
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_snd_dt.select();
				return false;
			}
		}
		break;
	case COMMAND01:
		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	case MULTI01:		
	case MULTI:
		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		//체크된 항목이 없을경우
		if (sheetObj.CheckedRows("chk") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		break;
	}
	return true;
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var bl_no = sheetObj.CellValue(row, "bl_no");
	var params = "?type=edit&bl_no=" + bl_no;
	params = params + "&pgmNo=ESM_BKG_N004";
	ComOpenWindowCenter("/hanjin/ESM_BKG_N004.do" + params, "0029", 1020, 660);
}

/**
 * 조회조건 입력 후 자동으로 다음항목으로 이동
 */
function obj_KeyUp() {
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * MouseDown된 셀과 MouseUp된 셀이 동일할때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnClick(sheetObj, row, col) {
	document.form.action_desc.value = sheetObj.CellValue(row, "action_desc");
}

/**
 * 마우스가 Sheet 위에서 움직일 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "error") {
			sheetObj.ToolTipText(row, col) = error_desc(sheetObj.CellValue(row, "error"));
		}
	}
}
var vStartRow = 2;
/**
 * 헤더를 클릭한 경우(소트시)
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var col = sheetObj.MouseCol
	if (sheetObj.MouseRow == 0 || sheetObj.MouseRow == 1) {
		if (sheetObj.RowCount < sheetObj.TotalRows) {
			ComOpenWait(true);
			end_no = sheetObj.TotalRows;
			sheetObj.TopRow = sheetObj.RowCount;
			sheetObj.TopRow = 0;
			sheetObj.ColumnSort(col);
			ComOpenWait(false);
		}
	} else {
		if (Shift != 1) {
			vStartRow = sheetObj.MouseRow;
		}
	}
}

/**
 * shift누르고 시트 지정하면 셀렉트되게
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y) {
	if (Shift == 1) {
		for ( var i = vStartRow; i <= sheetObj.SelectRow; i++) {
			if (sheetObj.CellEditable(i, "chk")) {
				sheetObj.CellValue2(i, "chk") = "1";
			}
		}
	}
}

/**
 * 에러코드를 받아 에러메시지리턴
 * @param error_type
 * @return error_desc
 */
function error_desc(error_type) {
	var error_desc;
	switch (error_type) {
	case "B":
		error_desc = "B/L No.is not Assigned";
		break;
	case "S":
		error_desc = "BKG Status is not Firmed";
		break;
	case "H":
		error_desc = "H.B/L & AMS File No.is missing for Filer Type '01'";
		break;
	case "C":
		error_desc = "Container No.or Seal No. is missing";
		break;
	case "P":
		error_desc = "Piece count un-match (M.B/L & H.B/L TTL vs. C/M Sum ) or C/M is missing";
		break;
	case "F":
		error_desc = "Filer Type is missing";
		break;
	case "A":
		error_desc = "Consignee(or Notify in case of “To Order”) information is missing";
		break;
	}
	return error_desc;
}