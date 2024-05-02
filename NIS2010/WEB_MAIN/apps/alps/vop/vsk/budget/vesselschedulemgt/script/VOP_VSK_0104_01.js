/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0104_01.js
 *@FileTitle : Budget L/R SKD Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.22
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.02.10 진마리아
 * 1.0 Creation
 * 
 * History
 * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
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
 * @class LRS Creation : LRS Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0104_01() {
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
var iframeid = '';

var dataStartCol = 6;
var dataStartRow = 7;
var visibleHeaderRows = 4;
var tailerColCount = 4; // cre_dt, cre_usr_id, upd_dt, upd_usr_id 
var dataSetCnt = 3;
var portNum = 0;

var vvdMap; // 부모창(0010)에 의해 생성된 vvdMap에 대한 참조자.
var select_yn;
var pop_yn;

//헤더 항목의 row 위치
var row_skd_dir_cd = 0;
var row_yd_cd = 1;
var row_yd_ind_seq = 2;
var row_vps_port_cd = 3;
var row_port_ind_seq = 4;
var row_day = 5;
var row_hour = 6;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
//	var sheetObject1 = sheetObjects[1];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
//		case "btn_Retrieve":
//			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
//			break;

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

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], '', '', '', '', '', '', '');
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	loadParentInfo();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7) {

	var cnt = 0;
	var sheetId = sheetObj.id;
	
	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			
			tabIndex = -1;
			
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			//InitRowInfo(4, 1, 3, 100);
			InitRowInfo(dataStartRow, dataSetCnt, 1, 100);
			
			var HeadTitle1 = "| | | | | "+HeadCol1+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle2 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol2+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle3 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol3+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle4 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol4+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle5 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol5+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle6 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol6+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			var HeadTitle7 = "| | |VSL\nCD|VOY.\nNO.|DIR"+HeadCol7+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(headCount, 4, 0, true);
			InitColumnInfo(headCount, dataStartCol, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(row_skd_dir_cd		, HeadTitle1, true);		// skd_dir_cd
			InitHeadRow(row_vps_port_cd		, HeadTitle2, false, true);	// vps_port_cd
			InitHeadRow(row_day				, HeadTitle3, false);		// day
			InitHeadRow(row_hour			, HeadTitle4, false);		// hour
			InitHeadRow(row_port_ind_seq	, HeadTitle5, false, true);	// port_ind_seq
			InitHeadRow(row_yd_cd			, HeadTitle6, true);		// yd_cd
			InitHeadRow(row_yd_ind_seq		, HeadTitle7, false, true);	// yd_ind_seq

            for(var i = 0 ; i < dataSetCnt ; i++){
            	cnt = 0;
            	
            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(i, cnt++ , dtHiddenStatus,	30,	daCenter,	true,			"ibflag");
    			
    			InitDataProperty(i, cnt++ , dtHidden,   44,	daCenter,	true,			"vsl_slan_cd");
    			InitDataProperty(i, cnt++ , dtHidden,   44,	daCenter,	true,			"pf_skd_tp_cd");
    			InitDataProperty(i, cnt++ , dtData,     44,	daCenter,	true,			"VVD1",					false,	"",		dfNone,				0,			false, 	false);
    			InitDataProperty(i, cnt++ , dtData,		44,	daCenter,	true,			"VVD2",					false,	"",		dfNone,				0,			false, 	false);
    			InitDataProperty(i, cnt++ , dtData,		44,	daCenter,	true,			"VVD3",					false,	"",		dfNone,				0,			false, 	false);
    	    	portNum = parseInt(ComCountHeadTitle(HeadCol1)-1)/3;
    	    	
    			for(var j = 0 ; j < portNum ; j++){
    				InitDataProperty(i, cnt++ , dtData,		34,	daCenter,	false,		"ETB"+j,  			false,	"",		dfNone,				0,			false,	false);
    				InitDataProperty(i, cnt++ , dtData,		34,	daCenter,	false,		"ETD"+j,  			false,	"",		dfNone,				0,			false,	false);
    				InitDataProperty(i, cnt++ , dtHidden,		0,		daCenter,	false,		"pseudo"+j,			false,	"",		dfNone,				0,			false,	false);
    			}
    			InitDataProperty(i, cnt++ , dtData,		50,	daCenter,	true,		"vps_rmk",							false,	"",		dfNone,				0,			false,		false);
    			InitDataProperty(i, cnt++ , dtHidden,		10,	daLeft,	false,		"cre_dt",					false,	"",		dfNone,				0,			false,		false);
    			InitDataProperty(i, cnt++ , dtHidden,		10,	daLeft,	false,		"cre_usr_id",			false,	"",		dfNone,				0,			false,		false);
    			InitDataProperty(i, cnt++ , dtHidden,		10,	daLeft,	false,		"upd_dt",				false,	"",		dfNone,				0,			false,		false);
    			InitDataProperty(i, cnt++ , dtHidden,		10,	daLeft,	false,		"upd_usr_id",			false,	"",		dfNone,				0,			false,		false);
    		}
    		
    		CountPosition = 0;
    		
    		RowHeight(1) = 20;
    		RowHeight(2) = 20;
    		RowHeight(3) = 20;
    		RowHeight(4) = 20;
    		RowHeight(5) = 20;
    		RowHeight(6) = 20;
    		
    		MultiSelection = false;
    		WaitImageVisible = false;
    		FrozenRows = visibleHeaderRows;
    		SelectHighLight = false; // 팝업모드에서 하이라이트 기능이 방해됨
    		FocusAfterProcess = false;
    		SetExcelColDialog(false); // 시트에서 Ctrl+P 눌렀을때 컬럼선택 다이얼로그 안뜨게함.
    	}
		break;
	}
}

// 이벤트 등록
function initControl() {
	var formObj = document.form;
}

//// Sheet관련 프로세스 처리
//function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = false;
//	switch (sAction) {
//
//	case IBSEARCH: // 조회
//		break;
//		
//	}
//}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
}

function loadXml(id, xmlStr, HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7){
	iframeid = id;
	sheetObjects[0].Reset();
    ComConfigSheet (sheetObjects[0]);
    initSheet(sheetObjects[0], HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7);
    ComEndConfigSheet(sheetObjects[0]);
	
	sheetObjects[0].LoadSearchXml(xmlStr);
}

function resetSheet(){
	sheetObjects[0].Reset();
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var width = 0;
	var height = 0;
	var portNum = parseInt((sheetObj.LastCol-tailerColCount-dataStartCol)/3);
	var totRows = sheetObj.SearchRows + visibleHeaderRows;
	
	// 그리드가 일정 Row 이상(현재 15줄이상) 이면 상하 스크롤 처리하도록 한다. 
	if(totRows > 14){
		height = 14 * 20;
	}else{
		height = totRows * 20;
	}
	
	sheetObj.Redraw = false;
	sheetObj.ColWidth("VVD2") = 0;
	
	if(portNum<=11){ 	// 포트의 수가 11개 이하이면 그리드의 좌우 크기를 딱 맞게 조절한다.
		width = 138 + sheetObj.ColWidth("VVD2") + ( portNum * 68 ) + 2; // 138 = [vsl_cd(44) + skd_voy_no(44) + RMK(50)] // 2 : 그리드 경계값
		if(totRows > 14){
			// 상하스크롤이 생기는 경우이므로 width 추가
			width = width + 20;
		}
		sheetObj.style.width = width;
	}else{
		height = height + 21; // 좌우 스크롤바용 height 추가
		sheetObj.style.width = "100%";	
	}
	
	sheetObj.style.height = height + 2; // 그리드 경계값
	
	sheetObj.Redraw = true;
	
	parent.setSize(iframeid, height);
	parent.postProcess(iframeid);
	
}

function sheet1_OnClick(sheetObj, Row, Col, Value){
	var formObj = parent.document.form;
	if(Col>=dataStartCol && Value!=undefined && ComTrim(Value)!=""){
		formObj.cre_dt.value = sheetObj.CellValue(Row, "cre_dt");
		formObj.cre_usr_id.value = sheetObj.CellValue(Row, "cre_usr_id");
		formObj.upd_dt.value = sheetObj.CellValue(Row, "upd_dt");
		formObj.upd_usr_id.value = sheetObj.CellValue(Row, "upd_usr_id");
		selectVVD(sheetObj, Row, Col);
	}else{
		formObj.cre_dt.value = "";
		formObj.cre_usr_id.value = "";
		formObj.upd_dt.value = "";
		formObj.upd_usr_id.value = "";
	}
}

//function sheet1_OnDblClick(sheetObj, Row, Col){
//	
//	var Value = sheetObj.CellValue(Row, Col);
//	if(Col > sheetObj.LastCol-tailerColCount || ComTrim(Value)==""){
//		return;
//	}
//
//	var colSaveName = sheetObj.ColSaveName(Col);
//	
//	// VVD 더블클릭시 VOP_VSK_0107 팝업
//	if(colSaveName=="VVD1" || colSaveName=="VVD2" || colSaveName=="VVD3"){
//		ComOpenWait(true);
//		popupVVDInquiry(sheetObj.CellValue(Row, "VVD1"), sheetObj.CellValue(Row, "VVD2"), sheetObj.CellValue(Row, "VVD3"));
//		ComOpenWait(false);
//	}
//	
//	// Port SKD 더블클릭시 VOP_VSK_0250 팝업
//	if( Value!="" && (colSaveName.indexOf("ETB") > -1 || colSaveName.indexOf("ETD") > -1)){
//		ComOpenWait(true);
//		popupPortSkdInquiry(sheetObj, Row, Col);
//		ComOpenWait(false);
//	}
//}

function selectVVD(sheetObj, Row, Col){
	var formObj = document.form;
	if(select_yn!="Y"){
		return false;
	}
	
	var dir_cd = sheetObj.CellValue(row_skd_dir_cd, Col);
	var oldPos = 0;
	
	// 해당 VVD에서 어떤 port가 이미 선택되어 있는 경우, 선택 해제시킨다.
	for(var i=0; i<sheetObj.LastCol; i++){
		if(dir_cd == sheetObj.CellValue(row_skd_dir_cd, i)){
			if(sheetObj.CellFontColor(Row, i) == sheetObj.RgbColor(255, 255, 255)){
				sheetObj.CellFontColor(Row, i) = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellFontColor(Row, i+1) = sheetObj.RgbColor(0, 0, 0);
				sheetObj.CellBackColor(Row, i) = sheetObj.RgbColor(255, 255, 255);
				sheetObj.CellBackColor(Row, i+1) = sheetObj.RgbColor(255, 255, 255);
				oldPos = i;
				removeVVD(sheetObj, Row, i);
				break;
			}
		}
	}
	
	// 새로 선택한 port를 표시한다.
	var col = Col;
	if(Col%3==2){
		col = Col - 1;
	}
	
	if(oldPos!=col){
		sheetObj.CellFontColor(Row, col) = sheetObj.RgbColor(255, 255, 255);
		sheetObj.CellFontColor(Row, col+1) = sheetObj.RgbColor(255, 255, 255);
		sheetObj.CellBackColor(Row, col) = sheetObj.RgbColor(0, 0, 1);
		sheetObj.CellBackColor(Row, col+1) = sheetObj.RgbColor(0, 0, 1);
		putVVD(sheetObj, Row, col);
	}
	
}

function removeVVD(sheetObj, Row, Col){
	var vvd = sheetObj.CellValue(Row, "VVD1") + sheetObj.CellValue(Row, "VVD2") + sheetObj.CellValue(row_skd_dir_cd, Col);
	var pos = vvdMap.exist(vvd);
	if(pos!=-1){
		vvdMap.remove(pos);
	}
}

function putVVD(sheetObj, Row, Col){
	var skdInfo = new Object();
	var vvd = sheetObj.CellValue(Row, "VVD1") + sheetObj.CellValue(Row, "VVD2") + sheetObj.CellValue(row_skd_dir_cd, Col);
	
	skdInfo.vsl_cd = sheetObj.CellValue(Row, "VVD1");
	skdInfo.skd_voy_no = sheetObj.CellValue(Row, "VVD2");
	skdInfo.skd_dir_cd = sheetObj.CellValue(row_skd_dir_cd, Col);
	skdInfo.port_cd = sheetObj.CellValue(row_vps_port_cd, Col);
	skdInfo.clpt_ind_seq = sheetObj.CellValue(row_port_ind_seq, Col);
	
//	skdInfo.etb_dt = sheetObj.CellValue(Row, Col);
//	skdInfo.etd_dt = sheetObj.CellValue(Row, Col+1);
	
	skdInfo.etb_dt = sheetObj.CellValue(Row+2, Col);
	skdInfo.etd_dt = sheetObj.CellValue(Row+2, Col+1);
	
	vvdMap.put(vvd, skdInfo);
}

function loadParentInfo(){
	var info = parent.getSubInfo();
	vvdMap = info.vvdMap;
	select_yn = info.select_yn;
	pop_yn = info.pop_yn;
}

function Down2Excel(Mode, UseOpenFile){
	sheetObjects[0].Down2Excel(Mode, UseOpenFile, false, true, "", "apps/alps/vop/vsk/budget/vesselschedulemgt/script/VOP_VSK_0104_01.xml", false, false, "Long Range SKD", true, "", "", false, false, "");
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	// 어떤 VVD를 선택했는지 알아볼수 있도록 VVD에 배경색을 입힌다.
	if(OldRow >= sheetObj.HeaderRows){
		sheetObj.CellBackColor(OldRow, "VVD1") = sheetObj.RgbColor(0, 0, 0);
		sheetObj.CellBackColor(OldRow, "VVD2") = sheetObj.RgbColor(0, 0, 0);
		sheetObj.CellBackColor(OldRow, "VVD3") = sheetObj.RgbColor(0, 0, 0);
		
		sheetObj.CellBackColor(NewRow, "VVD1") = sheetObj.RgbColor(128, 128, 255);
		sheetObj.CellBackColor(NewRow, "VVD2") = sheetObj.RgbColor(128, 128, 255);
		sheetObj.CellBackColor(NewRow, "VVD3") = sheetObj.RgbColor(128, 128, 255);
	}
	
	// 선택한 VVD의 Lane 정보와 P/F Type Code를 보여준다.
	if(OldRow >= sheetObj.HeaderRows){
		var pfTypes = sheetObj.CellValue(NewRow, "vsl_slan_cd") + "/" + sheetObj.CellValue(NewRow, "pf_skd_tp_cd")
		sheetObj.CellValue2(row_skd_dir_cd, "VVD1") = pfTypes;
		sheetObj.CellValue2(row_skd_dir_cd, "VVD2") = pfTypes;
		sheetObj.CellValue2(row_skd_dir_cd, "VVD3") = pfTypes;
	}
}

function popupVVDInquiry(vslCd, skdVoyNo, skdDirCd){
	var skdVoyNo1 = "";
	var skdVoyNo2 = "";
	var skdDirCd1="";
	var skdDirCd2="";
	var sUrl = "/hanjin/VOP_VSK_0107.do?pop_mode=Y&vsl_cd=" + vslCd;
	
	if(skdVoyNo.indexOf("/")>-1){
		skdVoyNo1 = skdVoyNo.substring(0, 4);
		skdVoyNo2 = skdVoyNo.substring(5, 9);
	}else{
		skdVoyNo1 = skdVoyNo;
		skdVoyNo2 = skdVoyNo;
	}
	
	// VOP_VSK_0107 팝업
	if(skdDirCd.indexOf("/")>-1){
		skdDirCd1 = skdDirCd.substring(0, 1);
		skdDirCd2 = skdDirCd.substring(2, 3);
	}else{
		skdDirCd1 = skdDirCd;
	}
	
	var vvd = vslCd + skdVoyNo1 + skdDirCd1;
	
	if(ComShowConfirm("Do you want to open 'Vessel SKD Inquiry by VVD(" + vvd + ")'?")){
		sUrl = sUrl + "&skd_voy_no=" + skdVoyNo1 + "&skd_dir_cd=" + skdDirCd1;
		ComOpenPopupWithTarget(sUrl, 1024, 613, "", "0,0", true);	
	}else if(skdDirCd2!=""){
		vvd = vslCd + skdVoyNo2 + skdDirCd2;
		if(ComShowConfirm("Do you want to open 'Vessel SKD Inquiry by VVD(" + vvd + ")'?")){
			sUrl = sUrl + "&skd_voy_no=" + skdVoyNo2 + "&skd_dir_cd=" + skdDirCd2;
			ComOpenPopupWithTarget(sUrl, 1024, 613, "", "0,0", true);
		}
	}
			
}

function popupPortSkdInquiry(sheetObj, Row, Col){
	
	var vslCd = sheetObj.CellValue(Row, "VVD1");
	var skdVoyNo = sheetObj.CellValue(Row, "VVD2");
	var skdDirCd = sheetObj.CellValue(row_skd_dir_cd, Col);
	var vpsPortCd = sheetObj.CellValue(row_vps_port_cd, Col);
	var clptIndSeq = sheetObj.CellValue(row_port_ind_seq, Col);
	var clptSeq = sheetObj.CellValue(Row+1, Col);
//	var ydCd = sheetObj.CellValue(5, Col);
//	var callYdIndSeq = sheetObj.CellValue(6, Col);
	
	var tmpSkdDirCd = sheetObj.CellValue(Row, "VVD3");
	var skdVoyNo1 = "";
	var skdVoyNo2 = "";
	var skdDirCd1 = "";
	var skdDirCd2 = "";
	
	if(skdVoyNo.indexOf("/")>-1){
		skdVoyNo1 = skdVoyNo.substring(0, 4);
		skdVoyNo2 = skdVoyNo.substring(5, 9);
	}else{
		skdVoyNo1 = skdVoyNo;
		skdVoyNo2 = skdVoyNo;
	}
	
	if(tmpSkdDirCd.indexOf("/")>-1){
		skdDirCd1 = tmpSkdDirCd.substring(0, 1);
		skdDirCd2 = tmpSkdDirCd.substring(2, 3);
	}else{
		skdDirCd1 = tmpSkdDirCd;
	}
	
	// 하나의 VVD가 두 skd_voy_no로 이루어진 경우 dir_cd에 맞게 나누어줌.
	if(skdDirCd==skdDirCd1){
		skdVoyNo = skdVoyNo1;
		skdDirCd = skdDirCd1;
	}else if(skdDirCd==skdDirCd2){
		skdVoyNo = skdVoyNo2;
		skdDirCd = skdDirCd2;
	}else{
		return;
	}
	
	var sUrl = "/hanjin/VOP_VSK_0250.do?vsl_cd=" + vslCd 
					+ "&skd_voy_no=" + skdVoyNo
					+ "&skd_dir_cd=" + skdDirCd
					+ "&vps_port_cd=" + vpsPortCd
					+ "&clpt_seq=" + clptSeq;
	var rVal = ComOpenPopupWithTarget(sUrl, 400, 415, "", "0,0", true);
	
}