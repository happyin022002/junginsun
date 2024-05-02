/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0059.js
 *@FileTitle : VSL SKD Delete & Closing(CCA)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.13
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.08.07 유혁
 * 1.0 Creation
 * 
 * History
 * 2011.04.13 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
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
 * @class VOP_VSK_0059 : VOP_VSK_0059 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0059() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var existEmptyPf = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
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
			
		case "btn_SkdClosing":
			if(checkSelection(sheetObject1)){
				if(checkStatus(sheetObject1)=="ACT"){
					if(ComShowConfirm(ComGetMsg("VSK00103"))){
						var result = doActionIBSheet(sheetObject1, formObj, MULTI01);
						if(result){
							changeStatus(sheetObject1);
						}
					}
				}else{
					ComShowCodeMessage("VSK00015");
				}
			}else{
				ComShowCodeMessage('VSK00010');
			}
			break;
			
		case "btn_SkdActivate":
			if(ComShowConfirm(ComGetMsg("VSK00014"))){
				var result = doActionIBSheet(sheetObject1, formObj, MULTI03);
				// 삭제시 오류가 없으면 주어진 조건값으로 재조회를 실행
				if(result){
					doActionIBSheet(sheetObj, formObj, IBSEARCH);	
				}
			}
			break;

		case "btns_search1":
			openLandCd();
			break;

		case "btns_search2":
			openVslCd();
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	formObj.vsl_slan_cd.focus();
	
//	formObj.vsl_slan_cd.value = "ASH";
//	formObj.tmp_vsl_slan_cd.value = "ASH";
//	formObj.vsl_cd.value = "KABM";

}

function initPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
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
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
			InitHeadMode(false, false, true, false, false, false);

			SelectionMode = smSelectionList;

			var HeadTitle1 = "|Sel.|Vessel Code|Voyage No.|Direction|Vessel Name|Lane|Status|Status|Created Date|First Port ETA|||";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "sheet1_";

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					prefix + "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, prefix
					+ "Sel");
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, prefix
					+ "skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, true, prefix
					+ "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix
					+ "vsl_slan_cd", false, "", dfNone, 0, false, false);	
			InitDataProperty(0, cnt++, dtCombo, 75, daCenter, true, prefix
					+ "skd_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenter, true, prefix
					+ "vir_skd_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix
					+ "cre_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix
					+ "n1st_port_brth_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix
					+ "turn_skd_voy_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix
					+ "turn_skd_dir_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 85, daCenter, true, prefix
					+ "skd_sts_mnl_flg", false, "", dfNone, 0, false, false);
			//InitDataProperty(0, cnt++, dtData, 30, daCenter, true, prefix
			//		+ "hisflag", false, "", dfNone, 0, false, false);
			
			InitDataCombo(0, "sheet1_skd_sts_cd", "Closed|Booking|Booking| ", "CLO|BKG|BKGNOD|ACT");
			InitDataCombo(0, "sheet1_vir_skd_sts_cd", "Closed|Booking|Booking| ", "CLO|BKG|BKGNOD|ACT");
			
			
			EditableColorDiff = false;
			
			ColHidden("sheet1_vir_skd_sts_cd") = true;

			sheetObj.ImageList(0) = "img/btns_search.gif";
			SelectHighLight = false;


		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction)){
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw = false;
			sheetObj.DoSearch("VOP_VSK_0059GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			sheetObj.Redraw = true;
			ComOpenWait(false);
		}
		break;

	case IBDELETE: // 저장
		
		var SaveStr = ComGetSaveString(sheetObjects);
		
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0059GS.do", FormQueryString(formObj) + "&" + SaveStr);
		ComOpenWait(false);
		
		var laneData = ComGetEtcData(sXml, "lane").split("|");
		var vvdData = ComGetEtcData(sXml, "vvd").split("|");
		var hisData = ComGetEtcData(sXml, "his").split("|");
		
		var turnVoyData = ComGetEtcData(sXml, "turn_voy").split("|");
		var turnDirData = ComGetEtcData(sXml, "turn_dir").split("|");
		
		if(vvdData!=""){
			
			var sUrl = "/hanjin/VOP_VSK_0249.do?";
			
			for(var i=0; i<vvdData.length-1; i++){
				//sUrl = sUrl + "&bkg_vvd=" + vvdData[i] + "&his_vvd=" + hisData[i];
				sUrl = sUrl + "&lane_vvd=" + laneData[i] + "&bkg_vvd=" + vvdData[i] + "&his_vvd=" + hisData[i] + "&turn_voy=" + turnVoyData[i] + "&turn_dir=" + turnDirData[i] + "&aft_vsl_slan_cd=" + formObj.vsl_slan_cd.value;
			}
			
			var rVal = ComOpenPopupWithTarget(sUrl, 524, 322, "", "0,0", true);
		}else{
			sheetObj.LoadSaveXml(sXml);	
		}
		
		if(!VskGetErrorXml(sXml)){
			doActionIBSheet(sheetObj, formObj, IBSEARCH);	
		}
		
		break;
		
	case MULTI01: // Manual Close

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0059GS.do", sParam + "&" + ComGetSaveString(sheetObj));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		
		if(VskGetErrorXml(sXml)){
			return false;
		}else{
			return true;
		}

		break;
		
	case SEARCH01: // Lane Code 조회
		formObj.f_cmd.value = SEARCH01;
		if ( sheetObj.id == "sheet1"){
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0059GS.do" , sParam);
			ComOpenWait(false);
			
			var vsl_slan_nm = ComGetEtcData(sXml, "vsl_slan_nm");
			
			if(!vsl_slan_nm){
				// MESSAGE 태그가 있으면 해당 오류 메시지를 출력함 
				var message = VskGetXmlNodeValue(sXml, "MESSAGE");
				if(message!=""){
					sheetObj.LoadSearchXml(sXml);
				}else{
					ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
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
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI03;
		//var sParam = FormQueryString(formObj);
		var prefix = "sheet1_";
		var sParam = "f_cmd=" + MULTI03 + "&" +
						prefix + "vsl_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "vsl_cd") + "&" +
						prefix + "skd_voy_no=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "skd_voy_no") + "&" +
						prefix + "skd_dir_cd=" + sheetObj.CellValue(sheetObj.SelectRow, prefix + "skd_dir_cd");
	
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0059GS.do", sParam);
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		
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
//		if ( (formObj.vsl_slan_cd.value == "" || ComChkLen(formObj.vsl_slan_cd.value, 3)!=2)
//				&& (formObj.vsl_cd.value == "" || ComChkLen(formObj.vsl_cd.value, 4)!=2)
//				) {
		if(formObj.vsl_slan_cd.value == "" && formObj.vsl_cd.value == ""){
			ComShowCodeMessage('VSK00027', 'Lane CD or Vessel CD');
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.focus();
			return false;
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

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('focus', "obj_activate", formObj);
	axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
	axon_event.addListenerForm('keypress', 'eng_keypress', formObj); // - 영문자 입력하기
	axon_event.addListenerForm('keypress', 'num_keypress', formObj); // - 숫자 입력하기
	axon_event.addListenerForm('keypress', 'enter_keypress', formObj); // - Enter 키처리
	axon_event.addListenerForm('keyup', "VskKeyFocus", formObj); // - 자동포커스 처리
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
			//if(obj.value=="" || ComChkLen(obj.value, 3)!=2){
			if(obj.value==""){
				formObj.tmp_vsl_slan_cd.value = "";
				break;
			}
			if(formObj.tmp_vsl_slan_cd.value != obj.value){
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
				if(sheetObj.RowCount>0){
					sheetObj.RemoveAll();
				}
				//formObj.vsl_cd.value = "";
			}
			break;
		case "vsl_cd":
			if(obj.value==""){
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

function sheet1_OnSearchEnd(sheetObj) {
	
	with(sheetObj){
		if(RowCount > 0){
			for(var i=HeaderRows; i<HeaderRows+RowCount; i++){
				if(CellValue(i, 7)=="CLO"){
					RowEditable(i) = false;
					RowBackColor(i) = RgbColor(240, 240, 240);
				}else if(CellValue(i, 7)=="BKG"){
					RowBackColor(i) = RgbColor(255, 255, 153);
				}else if(CellValue(i, 7)=="BKGNOD"){
					RowEditable(i) = false;
					RowBackColor(i) = RgbColor(255, 168, 80);	// 지우지 못하는 Booking VVD
				}
			}
		}
	}
}

function changeStatus(sheetObj){

	var dataRows = sheetObj.RowCount;
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+dataRows; i++){
		
		if(sheetObj.CellValue(i, 1)==1){
			if(sheetObj.CellValue(i, "sheet1_skd_sts_cd")!="CLO"){
				sheetObj.CellValue2(i, "sheet1_skd_sts_cd") = "CLO";
				sheetObj.CellValue2(i, "sheet1_skd_sts_mnl_flg") = "Y";
				sheetObj.CellValue2(i, 1) = 0;
				sheetObj.CellValue2(i, 0) = 'R';
				
				// CCA에서는 0018화면과 다르게 Manual/Auto Close 구분을 하지 않는다.
				// 따라서, 모든 Close는 수정불가 상태로 변경해준다.
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(240, 240, 240);
				sheetObj.RowEditable(i) = false;
			}
			
//			// 0018 화면에서는 Manual Open 기능을 제공하지 않는다.
//			// 아래의 코드는 Manual Open 을 사용하게 될 경우를 위하여 남겨둔다.
//			else if(sheetObj.CellValue(i, "sheet1_skd_sts_cd")=="CLO"){
//				sheetObj.CellValue2(i, "sheet1_skd_sts_cd") = "ACT";
//				sheetObj.CellValue2(i, "sheet1_skd_sts_mnl_flg") = "N";
//				sheetObj.CellValue2(i, 1) = 0;
//				sheetObj.CellValue2(i, 0) = 'R';
//				
//				// CCA에서는 0018화면과 다르게 Manual/Auto Close 구분을 하지 않는다.
//				// 따라서, 모든 Close는 수정불가 상태로 변경해준다.
//				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 255);
//			}
			
		}
	}
}

function checkSelection(sheetObj){
	
	var check = false;
	
	var dataRows = sheetObj.RowCount;
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+dataRows; i++){
		if(sheetObj.CellValue(i, 1)==1){
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
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+dataRows; i++){
		if(sheetObj.CellValue(i, 1)==1){
			count++;
			if(sheetObj.CellValue(i, "sheet1_skd_sts_cd")=="CLO"){
				status = status + 1;
			}else if((sheetObj.CellValue(i, "sheet1_skd_sts_cd")=="ACT" || sheetObj.CellValue(i, "sheet1_skd_sts_cd")=="RDY") && 
					(sheetObj.CellValue(i, "sheet1_vir_skd_sts_cd")=="ACT" || sheetObj.CellValue(i, "sheet1_vir_skd_sts_cd")=="RDY")){
				status = status + 2;
			}else{
				status = 0;
				break;;
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
	
	// 선택한 VVD 단건에 대한 버튼 핸들링
	var skd_sts_cd = sheetObj.CellValue(NewRow, "sheet1_skd_sts_cd");
	
	// SKD Activate 버튼이 있는 경우
	if("Y"==formObj.availActivate.value) {
		if( skd_sts_cd=="CLO"){
			ComBtnEnable("btn_SkdActivate");
		}else{
			ComBtnDisable("btn_SkdActivate");
		}
	}
	
}

/* 개발자 작업 끝 */