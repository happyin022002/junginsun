/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0904.js
 *@FileTitle : ESM_BKG_0904
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.09.29 이수빈
 * 1.0 Creation
 * ------------------------------------------------------
 * 2011.06.15 김영철 [CHM-201110803-01] Open시 Code Operation을 제외한 전체 항목에 대해 최종 전송 기록을 조회하도록 수정
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
 * @class ESM_BKG_0904 : ESM_BKG_0904 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0904() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initCombo = initCombo;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var check = true;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {	

			case "btn_TEST":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;	
			
			case "btn_EDI":
				doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
				break;	
				
			case "btn_Close":
				window.close();
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
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj; 
}


/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "form_code_opr":
            var i=0;
            with(comboObj) {
            	ColBackColor(0) = "#CCFFFD";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
        case "form_haul_mode":
            with(comboObj) {
            	ColBackColor(0) = "#CCFFFD";
            	DropHeight = 200;
            	MultiSelect = false;
            	MaxSelect = 1;
            }
            break;
    }
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    
	for(i = 0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}

	// 콤보 데이터 생성
	SetComboData(document.form.code_list.value);
	
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetId = sheetObj.id;

		switch (sheetId) {

		case "sheet1":
			with (sheetObj) {

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|bkgNo|codeOpr|termVvd|termPol|termPod|hjsVvd|hjsPol|hjsPod|fwrdAgnCd|tmnlBrthCd|haulMode|tranMode";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, 
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_no",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "code_opr",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "term_vvd",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "term_pol", 	false,	"", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "term_pod",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "hjs_vvd");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "hjs_pol",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "hjs_pod",		false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "fwrd_agn_cd", 	false,	"", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "tmnl_brth_cd", false,	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "haul_mode",	false, 	"", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 18, daCenter, false, "tran_mode", 	false,	"", dfNone, 0, true, true); 
			 
		}
		break;
		
		case "sheet2":
			with (sheetObj) {

		// 높이 설정
		style.height = 100;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msAll;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(5, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false, false);

		var HeadTitle = "|Type/Size|Type/Size|QTY|Gross Weight";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, 
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,	"ibflag");
		InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_type", 	false,	"", dfNone, 0, false, true);
		
		InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cntr_size",	false, 	"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cntr_qty",		false, 	"", dfNone, 0, false, true);
		InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "grs_wgt",		false, 	"", dfNone, 0, true, true); 
		}
		break;		

	}
}

/**
 * Sheet관련 프로세스 처리 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {

		case IBSEARCH: // 조회
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;	
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0904GS.do", FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[0]);
			}
			//IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "form_");
			//alert(sheetObj.EtcData("hjs_pod"));
			formObj.form_hjs_pod.value = sheetObj.EtcData("hjs_pod");
			formObj.form_hjs_pol.value = sheetObj.EtcData("hjs_pol");
			formObj.form_term_pod.value = sheetObj.EtcData("term_pod");
			formObj.form_tmnl_brth_cd.value = sheetObj.EtcData("tmnl_brth_cd");
			formObj.form_term_pol.value = sheetObj.EtcData("term_pol");
			formObj.form_hjs_vvd.value = sheetObj.EtcData("hjs_vvd");
			
			
			formObj.form_code_opr.Code = sheetObj.EtcData("code_opr");
			formObj.form_haul_mode.Code = sheetObj.EtcData("haul_mode");			

			formObj.form_term_vvd.value = sheetObj.EtcData("term_vvd");
			formObj.form_fwrd_agn_cd.value = sheetObj.EtcData("fwrd_agn_cd");
			ComOpenWait(false);
			break;
			
		case IBSEARCH_ASYNC01:	// EDI
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var tempType = "";
			var tempWGT = "";
			//alert(sheetObjects[1].RowCount);
			for ( var i=1 ; i<sheetObjects[0].RowCount+1 ; i++ )
			{
				//alert(sheetObjects[0].CellValue(i,"cntr_type"));
				tempType = tempType + sheetObjects[0].CellValue(i,"cntr_type")+"|";
				if ( sheetObjects[0].CellValue(i,"grs_wgt") == "" )
					tempWGT = tempWGT + "`"+"|";
				else
					tempWGT = tempWGT + sheetObjects[0].CellValue(i,"grs_wgt")+"|";
			}
			tempType = tempType.substring(0,tempType.length-1);
			tempWGT = tempWGT.substring(0,tempWGT.length-1);
			formObj.form_cntr_type.value = tempType;
			formObj.form_grs_wgt.value = tempWGT;
			
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0904GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        
			ComShowMessage(ComResultMessage(sXml));
			//formObj.output.value = ComGetEtcData(sXml, "flatFile");
			ComOpenWait(false); 
			if(State == "S")
			{
				window.dialogArguments.refresh();
				window.close();
				//var opener_obj = opener;
				//var opener_sheet = window.dialogArguments.document.sheet1;
				//doActionIBSheet(sheetObj, formObj, IBSEARCH);;
			}
		break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if(formObj.bkg_no.value != "" && formObj.pol_cd.value != ""){
			return true;
		}else{
			if(formObj.bkg_no.value == ""){
				ComShowCodeMessage('BKG00626', "Booking No.");
			}
			else if(formObj.pol_cd.value == ""){
				ComShowCodeMessage('BKG00626', "POL");
			}
			return false;
		}
		break;
	case IBSEARCH_ASYNC01:
		//alert(formObj.form_term_pol.value);
		if(formObj.form_term_pol.value == "" || formObj.form_term_pol.value.length != 5){
			ComShowCodeMessage('BKG00626', "Terminal POL");
			formObj.form_term_pol.focus();
			return false;
		}
		//if(formObj.form_term_pod.value == "" || formObj.form_term_pod.value.length != 5){
		//	ComShowCodeMessage('BKG00626', "Terminal POD");
		//	formObj.form_term_pod.focus();
		//	return false;
		//}		
		return true;
		break;
	case COMMAND01:	
		return true;
		break;			
	}
}

/**
 * 화면 로드 시 콤보 데이터 생성
 */
function SetComboData(sXml){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
    var arrXml = sXml.split("|$$|");
    var arrCombo;
    
	ComXml2ComboItem(arrXml[0], formObj.form_code_opr, "val", "name");
	ComXml2ComboItem(arrXml[1], formObj.form_haul_mode, "val", "name");
}

/* 개발자 작업 끝 */