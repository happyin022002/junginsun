/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0018.js
 *@FileTitle : VSL SKD Delete & Closing
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.13
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.08.07 유혁
 * 1.0 Creation
 * 
 * History
 * 2010.12.08 진마리아 CHM-201007135-01 Actaul Carrier update 로직 변경 요청건
 * 2011.04.13 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
 * 2013.09.25 정상기    CHM-201326839    SKD Activate - status가 Ready 인 경우 Activate 는 조건에 관계 없이 무조건 가능하도록 수정
 * 2014.09.11  임예지     CHM-201431767	 스케줄 Hold 및 Open 기능 삭제
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
 * @class VOP_VSK_0018 : VOP_VSK_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0018() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.setTabObject 		= setTabObject;
	this.validateForm 		= validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var existEmptyPf = false;
var saveRows = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 	= sheetObjects[0];

	/** **************************************************** */
	var formObj 		= document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			existEmptyPf = false;
			saveRows = new Array();
//			sheetObject1.ShowButtonImage = 0;
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;

		case "btn_Delete":
			if(checkSelection(sheetObject1)){
				if(ComShowConfirm(ComGetMsg("VSK00088"))){
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
			
		case "btn_Save":
			if(saveRows.length>0){
				if(ComShowConfirm(ComGetMsg("COM130504"))){
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
				}
			}else{
				ComShowCodeMessage('VSK00012');
			}
			break;

		// 2014.09.11 CHM-201431767	 스케줄 Hold 및 Open 기능 삭제
		/*case "btn_SkdHolding":
			if(checkSelection(sheetObject1)){
				var status = checkStatus(sheetObject1);
				if(status=="ACT"){
					if(ComShowConfirm(ComGetMsg("VSK00087"))){
						var result = doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
						}
					}
				}else if(status=="BKG"){
					ComShowCodeMessage("VSK00042", "Booking states");
				}else{
					ComShowCodeMessage("VSK00015");
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;*/
			
		/*case "btn_SkdOpen":
			if(checkSelection(sheetObject1)){
				if(checkStatus(sheetObject1)=="CLO"){
					if(ComShowConfirm(ComGetMsg("VSK00014"))){
						var result = doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
						}
					}
				}else{
					ComShowCodeMessage("VSK00016");
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;*/
		
		case "btn_SkdActivate":
			if(ComShowConfirm(ComGetMsg("VSK00014"))){
				var result = doActionIBSheet(sheetObject1, formObj, MULTI03);
				// 삭제시 오류가 없으면 주어진 조건값으로 재조회를 실행
				if(result){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
			break;
			
		case "btn_BookingList":
			openBookingList(sheetObject1);
			break;

		case "btns_search1":
			openLandCd();
			break;

		case "btns_search2":
			openVslCd();
			break;
			
		case "btn_period":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	formObj.vsl_slan_cd.focus();
	
	//현재일자~+30일로 셋팅 ::2013-03-05
	//:://document.form.fm_dt.value = ComGetNowInfo();	
	//:://document.form.to_dt.value = ComGetDateAdd(document.form.fm_dt.value, "d", "89", "-", true);	//ComGetDateAdd(sDate, sFlag, iVal, sDelim, isFull)//
}

//function initPage() {
//	var formObj = document.form;
//
//	for (i = 0; i < sheetObjects.length; i++) {
//		ComConfigSheet(sheetObjects[i]);
//		initSheet(sheetObjects[i], i + 1);
//		ComEndConfigSheet(sheetObjects[i]);
//	}
//}

function clearPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].RemoveAll();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

//			tabIndex = -1;

			// 높이 설정
			style.height = 460;
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
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			InitHeadMode(true, false, true, false, false, false);

			SelectionMode = smSelectionList;

			var HeadTitle1 = "|Sel.|VVD|VVD|VVD|VSL Name|Lane|P/F SKD\nType|Status|VirStatus|Created\nDate|Start\nDate|Carrier|Carrier|turn_skd_voy_no|turn_skd_dir_cd|skd_sts_mnl_flg|org_skd_sts";
			var HeadTitle2 = "|Sel.|VSL|VOY NO.|DIR|VSL Name|Lane|P/F SKD\nType|Status|VirStatus|Created\nDate|Start\nDate|CURT|ACT|turn_skd_voy_no|turn_skd_dir_cd|skd_sts_mnl_flg|org_skd_sts";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var prefix = "sheet1_";

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix + "Sel");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "vsl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "skd_dir_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 315, daLeft, true, prefix + "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix + "vsl_slan_cd", false, "", dfNone, 0, false, false);	
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "pf_skd_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, prefix + "skd_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenter, true, prefix + "vir_skd_sts_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "cre_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "n1st_port_brth_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "cur_crr_cd", false, "", dfNone, 0, false, false);
//			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, prefix + "act_crr_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 70, daCenter, true, prefix + "act_crr_cd", false, "",  dfEngUpKey, 0, true, true, 3);
//			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix + "act_crr_cd_pop", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix + "turn_skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix + "turn_skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix + "skd_sts_mnl_flg", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix + "org_skd_sts_cd", false, "", dfNone, 0, false, false);
			
			InitDataCombo(0, "sheet1_skd_sts_cd", "Closed|Ready|Booking|Booking| ", "CLO|RDY|BKG|BKGNOD|ACT");
			InitDataCombo(0, "sheet1_vir_skd_sts_cd", "Closed|Booking|Booking| ", "CLO|BKG|BKGNOD|ACT");
			InitDataValid(0, prefix+"act_crr_cd", vtEngUpOnly);
			
			RowHeight(0) = 20;
			RowHeight(1) = 20;
			
			ImageList(0) = "img/btns_search.gif";
			
			EditableColorDiff = false;
			ColHidden("sheet1_vir_skd_sts_cd") = true;
			SelectHighLight = false;
			FocusAfterProcess = false;
		}
		break;
	}
}

// Booking이 걸려있는 VVD인 경우, ETA가 현재일(SYSDATE) 기준 3일 이내이면 삭제가 불가능하다.
// Virtual Port에 Booking이 걸려있는 VVD 경우에는, 3일 제한없이 삭제가 가능하다. 단 VOP_VSK_0249 팝업 화면을 통해 사유를 등록해야 한다.

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw 	= false;
			ComOpenWait(true);
			
			//alert(FormQueryString(formObj));
			
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0018GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
		}
		break;

	case IBDELETE: // 삭제
		
		var SaveStr = ComGetSaveString(sheetObjects);
		
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0018GS.do", FormQueryString(formObj) + "&" + SaveStr);
		ComOpenWait(false);
		
		var laneData = ComGetEtcData(sXml, "lane").split("|");
		var vvdData = ComGetEtcData(sXml, "vvd").split("|");
		var hisData = ComGetEtcData(sXml, "his").split("|");
		
		var turnVoyData = ComGetEtcData(sXml, "turn_voy").split("|");
		var turnDirData = ComGetEtcData(sXml, "turn_dir").split("|");
		
		if(vvdData!=""){
			
			var sUrl = "/hanjin/VOP_VSK_0249.do?";
			
			for(var i=0; i<vvdData.length-1; i++){
				sUrl = sUrl + "&lane_vvd=" + laneData[i] + "&bkg_vvd=" + vvdData[i] + "&his_vvd=" + hisData[i] + "&turn_voy=" + turnVoyData[i] + "&turn_dir=" + turnDirData[i] + "&aft_vsl_slan_cd=" + formObj.vsl_slan_cd.value;
			}
			
			var rVal = ComOpenPopupWithTarget(sUrl, 524, 322, "", "0,0", true);
		}else{
			sheetObj.LoadSaveXml(sXml);	
		}
		
		// 삭제시 오류가 없으면 주어진 조건값으로 재조회를 실행
		if(!VskGetErrorXml(sXml)){
			doActionIBSheet(sheetObj, formObj, IBSEARCH);	
		}
		
		break;
		
	case MULTI01: // Manual Close
		
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0018GS.do", sParam + "&" + ComGetSaveString(sheetObj));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		
		if(VskGetErrorXml(sXml)){
			return false;
		}else{
			return true;
		}

		break;
		
	case IBSAVE: // Save
		
		var dataRows = sheetObj.RowCount;
		
		// 시트의 모든 행을 Read 표기한다.
//		for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
//			sheetObj.RowStatus(Row) = "R";
//		}
		
		// P/F SKD TYPE, ACT_CRR_CD를 수정한 행을 Update 표기한다.
		// saveRows 배열에는 수정한 Row 의 값이 들어있다.
//		for(var i=0; i<saveRows.length; i++){
//			sheetObj.RowStatus(saveRows[i]) = "U";
//		}
		
		formObj.f_cmd.value = MULTI02;
		var sParam = FormQueryString(formObj);
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0018GS.do", sParam + "&" + ComGetSaveString(sheetObj));
		ComOpenWait(false);
		sheetObj.LoadSaveXml(sXml);
		
		// 정상 처리되었으면 중복 실행을 막기 위해서 Read 표기로 바꾼다.
		if(!VskGetErrorXml(sXml)){
			for(var i=0; i<saveRows.length; i++){
				sheetObj.RowStatus(saveRows[i]) = "R";
				setRowDisplay(sheetObj, saveRows[i], "R");
			}
			saveRows = new Array();
		}
		break;

	case SEARCH01: // Lane Code 조회
		formObj.f_cmd.value = SEARCH01;
		if ( sheetObj.id == "sheet1"){
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0018GS.do" , sParam);
			ComOpenWait(false);
			
			var vsl_slan_nm = ComGetEtcData(sXml, "vsl_slan_nm");
			if(!vsl_slan_nm){
				// MESSAGE 태그가 있으면 해당 오류 메시지를 출력함 
				var message = VskGetXmlNodeValue(sXml, "MESSAGE");
				if(message!=""){
					sheetObj.LoadSearchXml(sXml);
				}else{
					ComShowCodeMessage("VSK00021", formObj.vsl_slan_cd.value);
				}
				formObj.tmp_vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
				return false;
			}else{
				formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
				formObj.vsl_cd.focus();
			}
		}
		break;

	case SEARCH02: // Vessel Code 조회
		//formObj.f_cmd.value = SEARCH;
		formObj.f_cmd.value = COMMAND16;
		if ( sheetObj.id == "sheet1"){
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
			ComOpenWait(false);
			
			var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
			
	    	if(!vsl_eng_nm){ // undefined
	    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value = "";
				formObj.vsl_cd.value = "";
				formObj.vsl_cd.focus();
				return false;
	    	}else{
	    		formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
	    		formObj.vsl_cd.focus();
	    	}
		}
		break;
	
	case MULTI03: // btn_SkdActivate 클릭
		var prefix = "sheet1_";
		var sParam = "f_cmd=" + MULTI03 + "&" +
						prefix + "vsl_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "vsl_cd") + "&" +
						prefix + "skd_voy_no=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "skd_voy_no") + "&" +
						prefix + "skd_sts_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "skd_sts_cd") + "&" +
						prefix + "org_skd_sts_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "org_skd_sts_cd") + "&" +
						prefix + "skd_dir_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "skd_dir_cd");

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI03;
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0018GS.do", sParam);
		ComOpenWait(false);
		sheetObj.LoadSearchXml(sXml);
		
		if(VskGetErrorXml(sXml)){
			return false;
		}else{
			return true;
		}
		break;
		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	 with (formObj) {
		
		//::2014-01-02:Removing Mandatory Item "Lane/Vessel"::// 
		if((formObj.vsl_slan_cd.value == "" && formObj.vsl_cd.value == "") && (formObj.fm_dt.value == "" || formObj.to_dt.value == "")){
			ComShowCodeMessage("VSK00027", "Lane CD, Vessel CD or Period");
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.focus();
			return false;
		}
		
		
	 	if(formObj.vsl_slan_cd.value == "" && formObj.vsl_cd.value == ""){
			
			if (ComIsNull(formObj.fm_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(From)");
				formObj.fm_dt.focus();
				return false;
			} else if (ComIsNull(formObj.to_dt.value)) {
				ComShowCodeMessage('VSK00027', "Period(To)");
				formObj.to_dt.focus();
				return false;
			}
			
			//3개월 Validation Rule
			if(!VskCheckSpecificMonthPeriod(formObj.fm_dt, formObj.to_dt, 3)){
				ComShowCodeMessage("VSK00105", "3 months");
				return false;
			}		
	 	}
		
	}
	return true;
}

/**
 * Lane Code Help 파일을 오픈한다
 */
function openLandCd() {
	var formObj = document.form;
	var sUrl = "/hanjin/VOP_VSK_0202.do";
	var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
	if(rVal){
		formObj.tmp_vsl_slan_cd.value = rVal;
		formObj.vsl_cd.focus();
	}
}

function openVslCd() {
	var formObj = document.form;
	var sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value + "&inc_del_vsl_pop=Y";
	var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
	if (rVal) {
		formObj.vsl_cd.value = rVal;
	}
	
}

function openBookingList(sheetObj){
	var selectRow = sheetObj.SelectRow;
	if(selectRow==-1){
		return;
	}
	var vvd = sheetObj.CellValue(selectRow, 2) + sheetObj.CellValue(selectRow, 3) + sheetObj.CellValue(selectRow, 4);
	var sUrl = "/hanjin/VOP_VSK_0229.do?vsl_cd=" + sheetObj.CellValue(selectRow, 2)
				+ "&skd_voy_no=" + sheetObj.CellValue(selectRow, 3)
				+ "&skd_dir_cd=" + sheetObj.CellValue(selectRow, 4);
	var rVal = ComOpenPopupWithTarget(sUrl, 406, 485, "", "0,0", true);
}

function initControl() {
	var formObj = document.form;
	
	axon_event.addListenerForm('deactivate'	, 'obj_deactivate'	, formObj);
	axon_event.addListenerForm('focus'		, 'obj_activate'	, formObj);
	axon_event.addListenerForm('keypress'	, 'eng_keypress'	, formObj); // - 영문자 입력하기
	axon_event.addListenerForm('keypress'	, 'num_keypress'	, formObj); // - 숫자 입력하기
	axon_event.addListenerForm('keypress'	, 'enter_keypress'	, formObj); // - Enter 키처리
	axon_event.addListenerForm('keyup'		, "VskKeyFocus"		, formObj); // - 자동포커스 처리
	
	axon_event.addListenerForm('activate'	, 'obj_activate_dt'	, form);
	axon_event.addListenerForm('blur'		, 'obj_blur'		, form);
}

function obj_activate(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문 입력 처리한다. <br>
 **/
function eng_keypress() {
	 var name = event.srcElement.name;
	switch(name){
		case "vsl_slan_cd":
		case "vsl_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	 VskKeyEnter();
}

/**
 * HTML Control의 포커스를 잃었을때 발생하는 이벤트를 처리한다.
 */
function obj_deactivate() {
	var formObj = document.form;
	var obj = event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(obj.value==""){
				clearPage();
				formObj.tmp_vsl_slan_cd.value = "";
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(sheetObj.RowCount>0){
					sheetObj.RemoveAll();
				}
			}
			break;
		case "vsl_cd":
			if(obj.value==""){
				clearPage();
				formObj.tmp_vsl_cd.value = "";
				break;
			}
			if(!obj || ComChkLen(obj.value, 4)!=2){
				break;
			}
			if(formObj.tmp_vsl_cd.value != obj.value){
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH02);
				if(sheetObj.RowCount>0){
					sheetObj.RemoveAll();
				}
			}
			break;
	}
}

function obj_activate_dt() {
	var srcName = event.srcElement.name;
	
	switch(srcName){
		case "fm_dt":
		case "to_dt":
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			event.srcElement.select();
			break;
	}
}

function obj_blur(){
	var srcName = event.srcElement.name;
	
	switch(srcName){
		case "fm_dt":
		case "to_dt":
			ComChkObjValid(event.srcElement);
			break;
	}
} 
 
function sheet1_OnSearchEnd(sheetObj) {
	with(sheetObj){
		for(var Row=HeaderRows; Row<RowCount+HeaderRows; Row++){
			
			if(CellValue(Row, "sheet1_skd_sts_cd")=="CLO" && CellValue(Row, "sheet1_skd_sts_mnl_flg")=="N"){
//				RowEditable(Row) = false;
				CellEditable(Row, "sheet1_Sel") = false;
				RowBackColor(Row) = RgbColor(240, 240, 240);
			}else if(CellValue(Row, "sheet1_skd_sts_cd")=="BKG"){
				RowBackColor(Row) = RgbColor(255, 255, 153);
			}else if(CellValue(Row, "sheet1_skd_sts_cd")=="BKGNOD"){
//				RowEditable(Row) = false;
				CellEditable(Row, "sheet1_Sel") = false;
				RowBackColor(Row) = RgbColor(255, 168, 80);	// 지우지 못하는 Booking VVD //주황색
			}else if(CellValue(Row, "sheet1_vir_skd_sts_cd")=="BKG"){
				RowBackColor(Row) = RgbColor(255, 255, 153);
			}else if(CellValue(Row, "sheet1_vir_skd_sts_cd")=="BKGNOD"){
//				RowEditable(Row) = false;
				CellEditable(Row, "sheet1_Sel") = false;
				RowBackColor(Row) = RgbColor(255, 168, 80);	// 지우지 못하는 Booking VVD
			}
			
			if(CellValue(Row, "sheet1_pf_skd_tp_cd")==""){
				InitCellProperty(Row , "sheet1_pf_skd_tp_cd", dtImage, daCenter, "sheet1_pf_skd_tp_cd", "", dfNull);
				CellImage(Row, "sheet1_pf_skd_tp_cd") = 0;
//				existEmptyPf = true;
			}
		}
	}
}

function changeStatus(sheetObj){
	var dataRows = sheetObj.RowCount;
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
		
		if(sheetObj.CellValue(Row, 1)==1){
			if(sheetObj.CellValue(Row, "sheet1_skd_sts_cd")!="CLO"){
				sheetObj.CellValue2(Row, "sheet1_skd_sts_cd") = "CLO";
				sheetObj.CellValue2(Row, "sheet1_skd_sts_mnl_flg") = "Y";
				sheetObj.CellValue2(Row, 1) = 0;
				sheetObj.RowStatus(Row) = "R";
			}else if(sheetObj.CellValue(Row, "sheet1_skd_sts_cd")=="CLO"){
				sheetObj.CellValue2(Row, "sheet1_skd_sts_cd") = "ACT";
				sheetObj.CellValue2(Row, "sheet1_skd_sts_mnl_flg") = "N";
				sheetObj.CellValue2(Row, 1) = 0;
				sheetObj.RowStatus(Row) = "R";
			}
		}
	}
}

function checkSelection(sheetObj){
	var check = false;
	var dataRows = sheetObj.RowCount;
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
		if(sheetObj.CellValue(Row, 1)==1){
			check = true;
			break;
		}
	}
	return check;
}

function checkStatus(sheetObj){
	var dataRows = sheetObj.RowCount;
	var status = 0;
	var count = 0;
	
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
		if(sheetObj.CellValue(Row, 1)==1){
			count++;
			if(sheetObj.CellValue(Row, "sheet1_skd_sts_cd")=="CLO"){
				status = status + 1;
			}else if((sheetObj.CellValue(Row, "sheet1_skd_sts_cd")=="ACT" || sheetObj.CellValue(Row, "sheet1_skd_sts_cd")=="RDY") && 
					(sheetObj.CellValue(Row, "sheet1_vir_skd_sts_cd")=="ACT" || sheetObj.CellValue(Row, "sheet1_vir_skd_sts_cd")=="RDY")){
				status = status + 2;
			}else if(sheetObj.CellValue(Row, "sheet1_skd_sts_cd")=="BKG" || sheetObj.CellValue(Row, "sheet1_vir_skd_sts_cd")=="BKG"){
				return "BKG";
			}else{
				status = 0;
				break;
			}
		}
	}
	
	// 체크한 VVD의 갯수 : count
	// 체크한 VVD가 Closed 상태인 경우 status + 1
	// 체크한 VVD가 Closed 상태가 아닌경우(Non Booking) status + 2
	
	// status / count 가 1이면 Closed 상태만 체크한것임
	// status / count 가 2이면 Closed가 아닌 상태만 체크한것임
	// status / count 가 1이나 2가 아니면 여러 상태를 체크한 것임 ==> 오류메시지 발생시킴
		
	if(status/count==1){
		return "CLO";
	}else if(status/count==2){
		return "ACT";
	}else{
		return "";
	}
	
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	var formObj = document.form;
//	alert(CellValue(NewRow, "sheet1_vir_skd_sts_cd"));
	// 선택한 VVD 단건에 대한 버튼 핸들링
	var skd_sts_cd 		= sheetObj.CellValue(NewRow, "sheet1_skd_sts_cd");
	var skd_sts_mnl_flg = sheetObj.CellValue(NewRow, "sheet1_skd_sts_mnl_flg");
	var vir_skd_sts_cd 	= sheetObj.CellValue(NewRow, "sheet1_vir_skd_sts_cd");
	var org_skd_sts_cd 	= sheetObj.CellValue(NewRow, "sheet1_org_skd_sts_cd");
	
	//alert('org_skd_sts_cd ['+org_skd_sts_cd+']');
	
	if( (skd_sts_cd=="BKG" || skd_sts_cd=="BKGNOD") ){
		ComBtnEnable("btn_BookingList");
		//|| (vir_skd_sts_cd=="BKG" || vir_skd_sts_cd=="BKGNOD") ){
	}else{
		ComBtnDisable("btn_BookingList");
	}
	
	// SKD Activate 버튼이 있는 경우
	if("Y" == formObj.availActivate.value) {
		////::2013-06-03::////if( skd_sts_cd == "CLO" && skd_sts_mnl_flg == "N" ){
		//2014-02-12//AUTO CLOSE BATCH중지// 
		//2014-08-20//MANUAL FLAG Y일 경우에도 ACTIVATE 버튼 ENABLE되도록 처리.
		//if( (skd_sts_cd == "CLO" && skd_sts_mnl_flg == "N") || skd_sts_cd == "RDY" || org_skd_sts_cd == "RDY" ){
		if( skd_sts_cd == "CLO"  || skd_sts_cd == "RDY" || org_skd_sts_cd == "RDY" ){

			ComBtnEnable("btn_SkdActivate");
		}else{
			ComBtnDisable("btn_SkdActivate");
		}
	}
	
	// 이전 OldCol이 ACT_CRR_CD인 경우 //????
//	if("sheet1_act_crr_cd"==sheetObj.ColSaveName(OldCol) && OldRow!=sheetObj.HeaderRows-1){
//		sheetObj.ShowButtonImage = 0;
//		sheetObj.InitCellProperty(OldRow, OldCol, dtData, daCenter, "sheet1_act_crr_cd", "", dfNull);
//	}
	
}


function sheet1_OnClick(sheetObj, Row, Col){
	var formObj = document.form;
	var colSaveName = sheetObj.ColSaveName(Col);
	
	switch(colSaveName){

		case "sheet1_pf_skd_tp_cd":
			if(sheetObj.CheckedRows("sheet1_Sel")>0){
				ComShowMessage("SKD Deletion/Closing and ACT CRR update can not be used at the same time.");
				break;
			}
			if(sheetObj.CellValue(Row, Col) == "0"){
				var sUrl = "/hanjin/VOP_VSK_0212.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenWait(true);
				var pfSkdTpCd = ComOpenPopupWithTarget(sUrl, 306, 407, "", "0,0", true);
				ComOpenWait(false);
				if(pfSkdTpCd){
					sheetObj.InitCellProperty(Row , Col, dtNull, daCenter, "sheet1_pf_skd_tp_cd", "", dfNull);
					sheetObj.CellValue(Row, Col) = pfSkdTpCd;
					
					saveRows.push(Row);
				}
			}		
			break;
			
//		case "sheet1_act_crr_cd":
//			
//			if(sheetObj.ShowButtonImage=="2"){
//				var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX";
//				ComOpenWait(true);
//				var newActCrrCd = ComOpenPopupWithTarget(sUrl, 550, 406, "", "0,0", true);
//				ComOpenWait(false);
//				if(newActCrrCd){
//					sheetObj.CellValue(Row, Col) = newActCrrCd;
//					saveRows.push(Row);
//				}
//			}else{
//				// ACT_CRR_CD 항목을 선택한 경우
//				sheetObj.ShowButtonImage = 2;
//				sheetObj.InitCellProperty(Row, Col, dtPopup, daCenter, "sheet1_act_crr_cd");
//			}
//			break;
			
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colSaveName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	switch(colSaveName){
		case "sheet1_pf_skd_tp_cd":
			setRowDisplay(sheetObj, Row, sheetObj.RowStatus(Row));
			break;
		case "sheet1_act_crr_cd":
			if(sheetObj.CheckedRows("sheet1_Sel")>0){
				if(Value != sheetObj.CellSearchValue(Row, Col)){
					ComShowMessage("SKD Deletion/Closing and ACT CRR update can not be used at the same time.");
					sheetObj.CellValue(Row, Col) = sheetObj.CellSearchValue(Row, Col);
					return false;
				}
			}
			if(Value!=""){
				searchCrrCd(sheetObj, formObj, Row, Col, Value);
			}
			setRowDisplay(sheetObj, Row, sheetObj.RowStatus(Row));
			break;
		case "sheet1_Sel":
			if(Value == 1){
				checkFontBold(sheetObj);
			}
		default:
	}
}

/**
 * sheet의 특정 Row에 대해 각 status 별 디스플레이 상태를 조정한다.
 */
function setRowDisplay(sheetObj, Row, Status){
	 with(sheetObj){
		switch(Status){
			case "U":
				sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellFont("FontBold", Row, 0, Row, sheetObj.LastCol) = true;
				break;
			default: // 기본상태, "R" 상태
			sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellFont("FontBold", Row, 0, Row, sheetObj.LastCol) = false;
		}
	}
}
 
 /*
  * 직접 입력한 act_crr_cd을 확인 
  */
function searchCrrCd(sheetObj, formObj, Row, Col, Value){
	ComOpenWait(true);
	formObj.f_cmd.value = SEARCH03;
	var prefix = "sheet1_";
	var sParam = "f_cmd=" + SEARCH03 + "&" + "crrCd=" + Value;
	var sXml = sheetObj.GetSearchXml("VOP_VSK_0018GS.do", sParam);
	ComOpenWait(false);
	
	var crr_cd = ComGetEtcData(sXml, "crr_cd");
	if(crr_cd == "null"){
		ComShowCodeMessage("VSK50030");
		sheetObj.CellValue(Row, Col) = sheetObj.CellSearchValue(Row, Col);
	}else{
		saveRows.push(Row);
	}
}
  
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var sUrl = "/hanjin/VOP_VSK_0252.do?code_type=CD0XXXX";
	ComOpenWait(true);
	var newActCrrCd = ComOpenPopupWithTarget(sUrl, 550, 406, "", "0,0", true);
	ComOpenWait(false);
	if(newActCrrCd){
		sheetObj.CellValue(Row, "sheet1_act_crr_cd") = newActCrrCd;
		saveRows.push(Row);
	}
}

function checkFontBold(sheetObj){
	var dataRows = sheetObj.RowCount;
	var count = 0;
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
		if(sheetObj.CellFont("FontBold", Row, 0, Row, sheetObj.LastCol)){
			count = 1;
		}
	}
	if(count == 1){
		ComShowMessage("SKD Deletion/Closing and ACT CRR update can not be used at the same time.");
		for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+dataRows; Row++){
			sheetObj.CellValue(Row, "sheet1_Sel") = 0;
		}
	}
}

	
/* 개발자 작업 끝 */