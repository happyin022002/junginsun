/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : VOP_FCM_0056.js
*@FileTitle      : Standard FOC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.16
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
*
* History
* 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
* 2014.05.28 [CHM-201430380] Standard FOC 칼럼 추가 및 조회 로직 수정
* 2014.06.26 [CHM-201430859] Standard FOC내 previous 칼럼 로직 수정
* 2014.08.22 [CHM-201431484] Previous 칼럼 말풍선 도움말 및 T actal 칼럼 로직 변경
* 2014.12.12 [CHM-201432990] Standard Fuel Consumption By VVD  T/Actual 칼럭 로직 수정
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
 * @class VOP_FCM_0056 : VOP_FCM_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0056() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var HeadTitle1 = "";
var HeadTitle2 = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObj = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		
		case "btn_New":
			formObj.reset();
			for(var i=0; i<sheetObjects.length; i++){
				sheetObjects[i].Redraw = false;
				sheetObjects[i].RemoveAll();
				sheetObjects[i].Redraw = true;
			}
			for(var i=0; i<comboObjects.length; i++){
				comboObjects[i].RemoveAll();
			}
			formObj.vsl_cd.focus();
			break;
			
		case "btn_trnd_line_no":
			if ( sheetObj.RowCount > 0 ) {
				ComOpenPopup('VOP_FCM_0014.do', 950, 650, 'setTrndLineNo', '0,0', true, false);
			} 
			break;
			
		case "btn_vvd":
			var vslCd = formObj.vsl_cd.value;
        	
        	if(vslCd == ""){
        		sUrl = "VOP_VSK_0219.do";
        		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
        	}else{
        		sUrl = "VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
        		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
        	}
			break;
			
		case "btn_Expand":
			var Col  = sheetObj.SaveNameCol(sheetObj.prefix+"opmz_dist");
			var lCol = sheetObj.SaveNameCol(sheetObj.prefix+"act_csm_avg_ttl");
			
			sheetObj.Redraw = false;
			for(var i=Col; i<=lCol; i++){
				sheetObj.ColHidden(i) = false;
			}
			sheetObj.Redraw = true;
			document.getElementById("reduce_div").style.display = "";
			document.getElementById("expand_div").style.display = "none";
			break;
			
		case "btn_Reduce":
			var Col  = sheetObj.SaveNameCol(sheetObj.prefix+"opmz_dist");
			var lCol = sheetObj.SaveNameCol(sheetObj.prefix+"act_csm_avg_ttl");
			
			sheetObj.Redraw = false;
			for(var i=Col; i<=lCol; i++){
				sheetObj.ColHidden(i) = true;
			}
			sheetObj.Redraw = true;
			document.getElementById("reduce_div").style.display = "none";
			document.getElementById("expand_div").style.display = "";
			break;
			
		case "btn_Selection":
			var sRow   = sheetObj.HeaderRows;
			var eRow   = sRow + sheetObj.RowCount;
			var prefix = sheetObj.prefix;
			var rCnt   = 0;
			
			sheetObj.Redraw = false;
			
			for ( var i=eRow-1; i>=sRow; i-- ) {
				if ( sheetObj.CellValue(i, prefix+"sel") == 0 ) {
					// Select 안 된 Row 삭제 
					sheetObj.RowDelete(i, false);
				} else {
					// Select 된 Last Row 정보
					rCnt = rCnt + 1;
				}
			}
			
			var lRow = sheetObj.LastRow - 1;
			
			if ( lRow > sRow && rCnt > 1 ) {
				// Last Row 는 Sel 체크 풀고. Sel, OPT Dis. 입력 불가.
				sheetObj.CellValue2(lRow, prefix+"sel")         = 0;
				sheetObj.CellEditable(lRow, prefix+"sel")       = false;
				sheetObj.CellEditable(lRow, prefix+"opmz_dist") = false;
				
				// Last Row 값 초기화
				for(var i=sheetObj.SaveNameCol(prefix+"init_foil_csm"); i<=sheetObj.LastCol; i++){		
					sheetObj.CellValue2(lRow, i) = "";
				}
			}
			
			ttlRowCalc(sheetObj);
			
			sheetObj.Redraw = true;
			break;
			
		case "btn_Calculation":
			calcEstmCsmWgt();
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObj, formObj, MULTI);
			break;
			
		case "btn_Delete": // Added By 2014.07.08 Lee Byoung Hoon
			processDelete();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBCombo Object를 배열로 등록 param : combo_obj ==> 콤보오브젝트 향후 다른 항목들을 일괄처리할 필요가
 * 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
	
	initControl();
	formObj.vsl_cd.focus();
	// Added By 2014.07.08 Lee Byoung Hoon
	ComBtnDisable("btn_Delete");
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus"		, "obj_activate", formObj);
	axon_event.addListenerForm("keypress"	, "obj_keypress", formObj);
	axon_event.addListenerForm("keyup"		, "obj_keyup"	, formObj);

}

function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;
	
	switch(event.keyCode){
		case 9: // TAB
		case 16: // SHIFT
			return true;
			break;
	}
	
	switch (eleObj.name) {
	    case "vsl_cd":
	    	if(eleObj.value.length == 4){
	    		formObj.skd_voy_no.focus();
	    	}
			break; 
	    case "skd_voy_no":
	    	if(eleObj.value.length == 4){
	    		formObj.skd_dir_cd.focus();
	    	}
			break;

	    case "skd_dir_cd":
	    	if(eleObj.value.length == 1){
	    		formObj.vvd_seq.focus();
	    	}
			break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keypress() {
	var obj = event.srcElement;
	if(event.keyCode==13){
		document.getElementById("btn_Retrieve").fireEvent("onclick");
		return true;
	}
	
	switch (obj.name) {
		case "vsl_cd":
	    	ComKeyOnlyAlphabet('uppernum');
			break;
	    case "skd_voy_no":
	    	ComKeyOnlyNumber(obj);
			break;
	    case "skd_dir_cd":
	    	ComKeyOnlyAlphabet('upper');
			break;
		default:
			ComKeyOnlyAlphabet('upper');
	}
}

/**
 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */ 
function initCombo(comboObj, comboNo) {
	var formObj = document.form;
//	switch(comboObj.id) {
//		case "trnd_line_tp_cd":
//			with (comboObj) {
//				MultiSelect = false;
//			}
//			break;
//	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var prefix = "";//sheetObj.id+"_";
	sheetObj.prefix = prefix;

	switch (sheetNo) {
	
	case 1: // sheet1 init
		with (sheetObj) {
			
			// 높이 설정
	     	style.height = 420;
	     	//전체 너비 설정
	     	SheetWidth = mainTable.clientWidth;
	     	
	     	//Host정보 설정[필수][HostIp, Port, PagePath]
	     	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	     	
	     	//전체Merge 종류 [선택, Default msNone]
	     	MergeSheet = msHeaderOnly;
	     	
	    	//전체Edit 허용 여부 [선택, Default false]
	     	Editable = true;
	     	
	     	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	     	InitRowInfo(2, 1, 3, 100);
	     	
	     	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     	InitHeadMode(true, true, true, true, false, false)
	     	
	     	// 컬럼 추가 - INIT_TACTUAL_SEA_TM_HRS, NVGT_ML_DIST, INIT_TACTUAL_PORT_TIME, ONE_AGO_VOY_DIR, TWO_AGO_VOY_DIR, THREE_AGO_VOY_DIR
	     	// Modify By 2014.08.22 Lee Byoung Hoon
	        HeadTitle1 = "|SEL|VVD_SEQ|CLPT_IND_SEQ|Call\nSEQ|Lane|VVD|V|V|D|Port\nCode|TMNL\nCode|YD|Change\nStatus|Port\nStatus|ETA|ETB|ETD|Standard FOC at SEA|Standard FOC at SEA|Standard FOC at SEA|Standard FOC at SEA|Standard FOC at Harbor /In port|Standard FOC at Harbor /In port|Standard FOC at Harbor /In port|Standard FOC at Harbor /In port|TTL\nFOC|Short\nDistance|Sea\nSpeed|Sea Time|Sea Time|Distance|Distance|Sea Speed|Sea Speed|Previous\nPerformance|Previous\nPerformance|Previous\nPerformance|Save Data|Save Data|Save Data|Save Data|Save Data|Save Data|DEP AVG SPD|SAVE_FLG|Port Time|Port Time|Act Sea Time|FOC/day|FOC/day|FOC|FOC|MNVR_HRS|MNVR_HRS|MNVR_HRS|MNVR_HRS|Consumption|Min Speed|A. BLW ST|Actual Cal|Actual Cal|INIT_TACTUAL_SEA_TM_HRS|NVGT_ML_DIST|INIT_TACTUAL_PORT_TIME|ONE_AGO_VOY_DIR|TWO_AGO_VOY_DIR|THREE_AGO_VOY_DIR"; 
	    	HeadTitle2 = "||VVD_SEQ|CLPT_IND_SEQ|Call\nSEQ|Lane|VVD|V|V|D|Port\nCode|TMNL\nCode|YD|Change\nStatus|Port\nStatus|ETA|ETB|ETD|Initial|RVSD|T/Actual|Actual|Initial|RVSD|T/Actual|Actual|TTL\nFOC|Short\nDistance|Sea\nSpeed|P/F|Short|P/F|Short|P/F|Short|Sea|Port|TTL|S_INIT_FOIL_CSM|S_INIT_PORT_FOIL_CSM|S_OPMZ_DIST|S_OPMZ_SEA_SPD|S_PF_SEA_TM_HRS|S_OPMZ_SEA_TM_HRS|DEP AVG SPD|SAVE_FLG|Port Time|Act Port Time|Act Sea Time|ME|GE|MANU|Port|PF_MNVR_IN_HRS|PF_MNVR_OUT_HRS|DEP_MNVR_IN_HRS|DEP_MNVR_OUT_HRS|Consumption|Min Speed|A. BLW ST|SEA|PORT|INIT_TACTUAL_SEA_TM_HRS|NVGT_ML_DIST|INIT_TACTUAL_PORT_TIME|ONE_AGO_VOY_DIR|TWO_AGO_VOY_DIR|THREE_AGO_VOY_DIR";
	     	
	     	var headCount = ComCountHeadTitle(HeadTitle1);
	     	
	     	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     	InitColumnInfo(headCount, 11, 0, true);
	     	
	     	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     	InitHeadRow(0, HeadTitle1, true);
	     	InitHeadRow(1, HeadTitle2, true);
	     	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	    daCenter,	true,	prefix+"ibflag",					false,	"",      	dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtCheckBox,     30,	    daCenter,	true,	prefix+"sel",						false,	"",      	dfNone,			0,	true,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vvd_seq",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"clpt_ind_seq",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	prefix+"clpt_seq",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"vsl_slan_cd",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",						false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"vsl_cd",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"skd_voy_no",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		20,		daCenter,	true,	prefix+"skd_dir_cd",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"vps_port_cd",				false,	"",			dfNone,			0,	false,	false,	-1,	false, false);
			
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"tml_cd",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"yd_cd",						false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"skd_cng_sts_cd",			false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,	    50,		daCenter,	true,	prefix+"port_skd_sts_cd",			false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    97,		daCenter,	true,	prefix+"vps_eta_dt",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			97,		daCenter,	true,	prefix+"vps_etb_dt",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    97,		daCenter,	true,	prefix+"vps_etd_dt",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtAutoSumEx,	45,		daRight,	true,	prefix+"init_foil_csm",				false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	45,		daRight,	true,	prefix+"rvis_foil_csm",				false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	60,		daRight,	true,	prefix+"trnd_line_foil_csm",		false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	50,		daRight,	true,	prefix+"act_foil_csm",				false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtAutoSumEx,	45,		daRight,	true,	prefix+"init_port_foil_csm",		false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	45,		daRight,	true,	prefix+"rvis_port_foil_csm",		false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	60,		daRight,	true,	prefix+"trnd_line_port_foil_csm",	false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	50,		daRight,	true,	prefix+"act_port_foil_csm",			false,	"",			dfNullFloat,	1,	false,	false,	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtAutoSumEx,	60,		daRight,	true,	prefix+"ttl_foc",					false,	"|"+prefix+"init_foil_csm|+|"+prefix+"init_port_foil_csm|",	dfNullFloat,	1,	false,	false, 	6, false, false);
			
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"opmz_dist",					false,	"",			dfNullFloat,	1,	true,	false,	6,	false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"opmz_sea_spd",				false,	"|"+prefix+"opmz_dist|/|"+prefix+"opmz_sea_tm_hrs|",	dfNullFloat,	2,	false,	false, 	6, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"pf_sea_tm_hrs",				false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"opmz_sea_tm_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"dist_pf_lnk",				false,	"",			dfNullInteger,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"dist_opmz",					false,	"",			dfNullInteger,	1,	false,	false,	-1,	false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"spd_pf_lnk",				false,	"|"+prefix+"dist_pf_lnk|/|"+prefix+"pf_sea_tm_hrs|",	dfNullFloat,	2,	false,	false, 	6, false, false);
			InitDataProperty(0, cnt++ , dtHidden,	    50,		daRight,	true,	prefix+"spd_opmz",					false,	"|"+prefix+"dist_opmz|/|"+prefix+"opmz_sea_tm_hrs|",	dfNullFloat,	2,	false,	false, 	6, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"act_foil_csm_avg",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"act_port_foil_csm_avg",		false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	40,		daRight,	true,	prefix+"act_csm_avg_ttl",			false,	"|"+prefix+"act_foil_csm_avg|+|"+prefix+"act_port_foil_csm_avg|",	dfNullFloat,	2,	false,	false, 	6, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_init_foil_csm",			false,	"",			dfNone,			2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_init_port_foil_csm",		false,	"",			dfNone,			2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_opmz_dist",				false,	"",			dfNone,			1,	false,	false,	6,	false, false);	// FCM_VSL_PORT_STND_FUEL_OIL 저장값 - 비교후 Font color 변경용
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_opmz_sea_spd",			false,	"",			dfNullFloat,	2,	false,	false, 	6,	false, false);	// FCM_VSL_PORT_STND_FUEL_OIL 저장값 - 비교후 Font color 변경용
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_pf_sea_tm_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);	// FCM_VSL_PORT_STND_FUEL_OIL 저장값 - 비교후 Font color 변경용
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"s_opmz_sea_tm_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);	// FCM_VSL_PORT_STND_FUEL_OIL 저장값 - 비교후 Font color 변경용
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"dep_avg_spd",				false,	"",			dfNullFloat,	2,	false,	false, 	6,	false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"save_flg",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"port_time",					false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"act_port_time",				false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"act_opmz_sea_tm_hrs",		false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,	prefix+"foc_day_me",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,	prefix+"foc_day_ge",				false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"foc_manu",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"foc_port",					false,	"",			dfNone,			0,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"pf_mnvr_in_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"pf_mnvr_out_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"dep_mnvr_in_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"dep_mnvr_out_hrs",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"mnvr_csm_wgt",				false,	"",			dfNullFloat,	3,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"op_min_spd",				false,	"",			dfNullFloat,	3,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"op_gnr_spd",				false,	"",			dfNullFloat,	3,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"act_foil_csm_cal",			false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"act_port_foil_csm_cal",		false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			// 컬럼 추가 Add By 2014.08.22 Lee Byoung Hoon
			InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	prefix+"init_tactual_sea_tm_hrs",		false,	"",			dfNullFloat,	2,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"nvgt_ml_dist",				false,	"",			dfNullInteger,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"init_tactual_port_time",				false,	"",			dfNullInteger,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"one_ago_previous",				false,	"",			dfNone,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"two_ago_previous",				false,	"",			dfNone,	1,	false,	false,	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		40,		daRight,	true,	prefix+"three_ago_previous",				false,	"",			dfNone,	1,	false,	false,	-1, false, false);
			
			RowHeight(0)  = 20;
			RowHeight(1)  = 30;
			ExtendLastCol = true;
			
			InitDataCombo(0, prefix+"skd_cng_sts_cd", "|Skip|Add|Phase In|Phase Out", "|S|A|I|O");
			
			// Sheet Init 시 dtHidden 하면 Edit 가 안되서 조회후 숨김
			ColHidden(prefix+"opmz_dist") = true;
			
			// Type 을 dtAutoSumEx 으로 변경하면서 숨김 처리
			ColHidden(prefix+"pf_sea_tm_hrs")         = true;
			ColHidden(prefix+"opmz_sea_tm_hrs")       = true;
			ColHidden(prefix+"dist_pf_lnk")           = true;
			ColHidden(prefix+"dist_opmz")             = true;
			ColHidden(prefix+"act_foil_csm_avg")      = true;
			ColHidden(prefix+"act_port_foil_csm_avg") = true;
			ColHidden(prefix+"act_csm_avg_ttl")       = true;
			
		}
		break;
		
	case 2:
		with (sheetObj) {
			// 높이 설정
	     	style.height = 0;
	     	//전체 너비 설정
	     	SheetWidth = mainTable.clientWidth;
	     	
	     	//Host정보 설정[필수][HostIp, Port, PagePath]
	     	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	     	
	     	//전체Merge 종류 [선택, Default msNone]
	     	MergeSheet = msHeaderOnly;
	     	
	    	//전체Edit 허용 여부 [선택, Default false]
	     	Editable = false;
	     	
	     	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	     	InitRowInfo(1, 1, 3, 100);
	     	
	     	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     	InitHeadMode(true, true, false, true, false, false)
	     	
	        var HeadTitle = "TRND_LINE_SEQ|trnd_line_no|TRND_LINE_USE_TP_CD|TRND_LINE_TP_CD|TRND_LINE_CHT_TP_CD|TRND_LINE_FM_DT|TRND_LINE_TO_DT|VSL_CLSS_CD|VSL_CLSS_SUB_CD|VSL_SLAN_CD|VSL_CD|SKD_DIR_CD|TRND_LINE_TP_SUB_CD|SLP_VAL|N1ST_COEF_VAL|N1ST_VAR_DGR_VAL|N2ND_COEF_VAL|N2ND_VAR_DGR_VAL|trnd_line_cons_val|COEF_OF_DTMN_VAL|FOML_DESC|AVG_GNR_CSM_WGT|AVG_BLR_CSM_WGT|OP_MAX_SPD|OP_MIN_SPD|TRND_LINE_RMK|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|AVG_SLP_RT|AVG_SLP_OPT_RT|APLY_SLP_RT"; 
	     	
	     	var headCount = ComCountHeadTitle(HeadTitle);
	     	
	     	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     	InitColumnInfo(headCount, 0, 0, true);
	     	
	     	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     	InitHeadRow(0, HeadTitle, true);
	     	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_seq"       );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_no"        );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_use_tp_cd" );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_tp_cd"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_cht_tp_cd" );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_fm_dt"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_to_dt"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"vsl_clss_cd"         );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"vsl_clss_sub_cd"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"vsl_slan_cd"         );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"vsl_cd"              );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"skd_dir_cd"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_tp_sub_cd" );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"slp_val"             );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"n1st_coef_val"       );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"n1st_var_dgr_val"    );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"n2nd_coef_val"       );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"n2nd_var_dgr_val"    );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_cons_val"  );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"coef_of_dtmn_val"    );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"foml_desc"           );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"avg_gnr_csm_wgt"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"avg_blr_csm_wgt"     );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"op_max_spd"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"op_min_spd"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_rmk"       );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"cre_usr_id"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"cre_dt"              );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"upd_usr_id"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"upd_dt"              );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"avg_slp_rt"          );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"avg_slp_opt_rt"      );
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"aply_slp_rt"         );
	     	
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	var prefix   = sheetObj.prefix;
	
	switch (sAction) {
		case SEARCH: // VVD 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				
				formObj.f_cmd.value = SEARCH;
				
				var rXml = sheetObj.GetSearchXml("VOP_FCM_0056GS.do", FormQueryString(formObj));
				var xmlArr = rXml.split("|$$|");
				
				var val = "";
				
				if ( val = ComGetEtcData(xmlArr[0], "lane_cd") ) {
					formObj.lane_cd.value = val;
				}
				
				// Load SKD Info.
				sheetObj.Redraw = false;
				sheetObj.LoadSearchXml(xmlArr[0]);
				sheetObj.Redraw = true;
				
				// Load Trend Line Info.
				findSheetObj(sheetObjects, "sheet_trend_line").LoadSearchXml(xmlArr[1]);
				ComOpenWait(false);
			}
			break;
			
		case MULTI:
			if (validateForm(sheetObj, formObj, sAction)) {
				var saveStr = sheetObj.GetSaveString(false, true, sheetObj.prefix+"sel");
				
				if ( saveStr == "" ) {
					return;
				}
				
				ComOpenWait(true);
				
				formObj.f_cmd.value = MULTI;
				
				var rXml = sheetObj.GetSaveXml("VOP_FCM_0056GS.do", "f_cmd=" + formObj.f_cmd.value + "&" + saveStr);
				
				var checkRow = sheetObj.FindCheckedRow(prefix+"sel");
				var arrRow   = checkRow.split("|");
				
				for ( var i=0; i<arrRow.length-1; i++ ) {
					sheetObj.CellValue2(arrRow[i], prefix+"save_flg") = "Y";
					sheetObj.CellValue2(arrRow[i], prefix+"s_init_foil_csm")      = sheetObj.CellValue(arrRow[i], prefix+"init_foil_csm"); 
					sheetObj.CellValue2(arrRow[i], prefix+"s_init_port_foil_csm") = sheetObj.CellValue(arrRow[i], prefix+"init_port_foil_csm"); 
					sheetObj.CellValue2(arrRow[i], prefix+"s_opmz_sea_spd")       = sheetObj.CellValue(arrRow[i], prefix+"opmz_sea_spd"); 
				}
				
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch (sAction) {
		case SEARCH:
			if ( !(		ComChkLen(formObj.vsl_cd.value    , 4) == 2
					&&	ComChkLen(formObj.skd_voy_no.value, 4) == 2
					&&	ComChkLen(formObj.skd_dir_cd.value, 1) == 2)) {
					ComShowMessage("Please check VVD");
					return false;
				}
			break;
			
		case MULTI:
			break;
	}

	return true;
}

/**
 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
 * @param rtnObjs
 * @return
 */
function returnVslCdHelp(rtnObjs){
	var formObj = document.form;
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.vsl_cd.value = rtnDatas[1];
			}
		}
	}
}

/**
 * VVD Code Help (Pop-Up)에서 받은 데이타 처리.
 * @param rtnObjs
 * @return
 */
function returnVvdHelp(rtnObjs){
	var formObj = document.form;
	
	if(rtnObjs){
		var rtnDatas = rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.skd_voy_no.value = rtnDatas[2];
				formObj.skd_dir_cd.value = rtnDatas[3];
				formObj.lane_cd.value    = rtnDatas[5];
			}
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var prefix  = sheetObj.prefix;
	
	var lRow = sheetObj.LastRow - 1;
	var col  = sheetObj.SaveNameCol(prefix+"opmz_dist");
	
	sheetObj.Redraw = false;
	
	// Last Row 는 Sel, OPT Dis. 입력 불가.
	sheetObj.CellEditable(lRow, prefix+"sel") = false;
	sheetObj.CellEditable(lRow, col)          = false;
	
	// 조회 후 전체 선택이 기본값
	sheetObj.CheckAll(prefix+"sel") = 1;
	
	// Last Row 값 초기화
	for ( var i=col; i<=sheetObj.LastCol; i++ ) {
		sheetObj.CellValue2(lRow, i) = "";
	}
	
	var sRow = sheetObj.HeaderRows;
	col = sheetObj.SaveNameCol(prefix+"vps_eta_dt");
	
	for(var i=sRow; i<lRow; i++){
		if ( sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") == "S" ) {
			for ( var j=col; j<=sheetObj.LastCol; j++ ) {
				sheetObj.CellValue2(i, j)   = "";
				sheetObj.CellEditable(i, prefix+"opmz_dist") = false;
			}
		}
		
		if ( sheetObj.CellValue(i, prefix+"save_flg") == "Y" ) {
			if ( sheetObj.CellValue(i, prefix+"s_opmz_sea_tm_hrs") != sheetObj.CellValue(i, prefix+"opmz_sea_tm_hrs") ) {
				sheetObj.CellFontColor(i, prefix+"opmz_sea_spd")    = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix+"opmz_sea_tm_hrs") = sheetObj.RgbColor(255, 0, 0);
			}
		}
	}
	
	// 음수 0 처리
	var mRow = 0;
	
	for(var col=sheetObj.SaveNameCol(prefix+"opmz_dist"); col<=sheetObj.LastCol; col++){
		while ( mRow != -1 ) {
			mRow = sheetObj.FindText(col, "-", mRow, 0);
			
			if ( mRow != -1 ) {
				sheetObj.CellValue(mRow, col) = 0;
				mRow++;
			}
		}
		mRow = 0;
	}
	
	// Total Row 에 Speed 값 계산
	ttlRowCalc(sheetObj);
	
	sheetObj.Redraw = true;
	
	paintVVD(sheetObj);
	
	/*
	 * 조회 된 VSL의 Maneuvering Consumption (Day) 값이 존재하지 않는다면 warning notice
	 * 
	 * Added By 2014.07.09 Lee Byoung Hoon
	 */
	if (sheetObj.LastRow > 2 && (sheetObj.CellValue(2, "mnvr_csm_wgt") == "" || sheetObj.CellValue(2, "mnvr_csm_wgt") == 0)) {
		alert("This Vessel have not Maneuvering Consumption (Day)!");
	}
	
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colSaveName = sheetObj.ColSaveName(Col);
	var formObj     = document.form;
	var prefix      = sheetObj.prefix;
	
	switch(colSaveName){
		case prefix+"opmz_dist":
			sheetObj.Redraw = false;
			ttlRowCalc(sheetObj);
			sheetObj.Redraw = true;
			break;
	}
}

/*
 * VVD별로 구분이 되도록 배경색을 설정한다.
 */
function paintVVD(sheetObj){
	var formObj = document.form;
	var sRow    = sheetObj.HeaderRows;
	var eRow    = sRow + sheetObj.RowCount;
	var prefix  = sheetObj.prefix;
	var vvdSeq  = "";
	
	var editColor   = sheetObj.RgbColor(128, 255, 255);
	var bgRgbColors = new Array(sheetObj.RgbColor(255, 255, 60),
			                    sheetObj.RgbColor(255, 255, 165),
			                    null,
			                    sheetObj.RgbColor(206, 228, 218),
			                    sheetObj.RgbColor(180, 214, 199));
	
	var vvdIdx = ComGetObjValue(formObj.vvd_seq);;
	
	var boundIdx = 2;
	
	if(vvdIdx == 3){
		boundIdx = 1;
	}else if(vvdIdx == 4){
		boundIdx = 0;
	}else if(vvdIdx == 5){
		boundIdx = 0;
	}
	
	var sVvd = sheetObj.CellValue(sRow, prefix+"vvd");
	
	sheetObj.Redraw = false;
	for(var i=sRow; i<eRow; i++){
		
		// Row Color Setting...
		if(sVvd != sheetObj.CellValue(i, prefix+"vvd")){
			boundIdx++;
			sVvd = sheetObj.CellValue(i, prefix+"vvd");
		}
		
		// Row 의 배경색을 Bound 단위로 변경함.
		if(bgRgbColors[boundIdx] != null){
			sheetObj.RowBackColor(i) = bgRgbColors[boundIdx];
		}
		
		sheetObj.CellBackColor(i, "opmz_dist") = editColor;
		
		
		/*
		 * Short Distance 칼럼에 값이 존재 하지 않을 경우 뒤쪽의 Distance - P/F 컬럼의 값을 셋팅하고
		 * Short Distance가 아닌 것을 유저가 인식 할 수 있도록 파란색으로 BOLD 처리
		 * 또한 Short Distance 칼럼 및 뒤쪽의 Distance - P/F 컬럼의 값이 모두 존재하지 않을 경우 배경색을 주황색으로 하여
		 * warning notice가 될 수 있도록 처리
		 * 
		 * Added By 2014.07.08 Lee Byoung Hoon
		 */
		if (i < eRow-1 && (sheetObj.CellValue(i, "opmz_dist") == "" || sheetObj.CellValue(i, "opmz_dist") == 0)) {
			if (sheetObj.CellValue(i, "dist_pf_lnk") != "") {
				sheetObj.CellValue2(i, "opmz_dist") = sheetObj.CellValue(i, "dist_pf_lnk");
				sheetObj.CellFontColor(i, "opmz_dist")    = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFont("FontBold", i, "opmz_dist") = true;
			} else {
				sheetObj.CellBackColor(i, "opmz_dist") = sheetObj.RgbColor(255, 100, 0);
			}
		}
	}
	sheetObj.Redraw = true;
}

/*
 * Trend Line Sheet 조회 이후 설정
 */
function sheet_trend_line_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var prefix  = sheetObj.prefix;
	var row     = sheetObj.RowCount;
	
	if ( row > 0 ) {
		formObj.trnd_line_no.value = sheetObj.CellValue(row, prefix+"trnd_line_no");
		formObj.slip.value         = sheetObj.CellValue(row, prefix+"avg_slp_rt");
		formObj.foml_desc.value    = sheetObj.CellValue(row, prefix+"foml_desc");
	} else {
		formObj.trnd_line_no.value = "";
		formObj.slip.value         = "";
		formObj.foml_desc.value    = "";
	}
	
	/* 
	 * Retrieve 조회 직후 하기 항목 값 셋팅 추가 - Add By 2014.08.22 Lee Byoung Hoon
	 * 
	 * Standard FOC at SEA - T/Actual
	 * Standard FOC at SEA - Actual
	 * Standard FOC at Harbor /In port - T/Actual
	 * Standard FOC at Harbor /In port - Actual
	 */
	var skdSheetObj      = findSheetObj(sheetObjects, "sheet1");
	var trndLineSheetObj = sheetObj;
	
	var coef2      = trndLineSheetObj.CellValue(1, "n1st_coef_val");
	var coef       = trndLineSheetObj.CellValue(1, "n2nd_coef_val");
	var cons       = trndLineSheetObj.CellValue(1, "trnd_line_cons_val");
	var foc_day_ge = parseFloat(trndLineSheetObj.CellValue(1, "avg_gnr_csm_wgt"));;
		
	var checkRow = skdSheetObj.FindCheckedRow(prefix+"sel");
	var arrRow   = checkRow.split("|");
	
	var seaSpeed         = "";
	var calVal      = "";
	var calMEFoc   = "";
	
	var mnvr_in     = "";
	var mnvr_out    = "";
	var consumption = "";
	
	if ( trndLineSheetObj.CellValue(1, prefix+"foml_desc") != "" ) {
		skdSheetObj.Redraw = false;
		
		for ( var i=0; i<arrRow.length-1; i++ ) {
			mnvr_in     = parseFloat(skdSheetObj.CellValue(arrRow[i], "pf_mnvr_in_hrs")); // P/F SKED의 Maneuvering IN
			mnvr_out    = parseFloat(skdSheetObj.CellValue(arrRow[i], "pf_mnvr_out_hrs")); // P/F SKED의 Maneuvering OUT
			consumption = parseFloat(skdSheetObj.CellValue(arrRow[i], "mnvr_csm_wgt")); // Maneuvering Consumption
			
			// Sea Speed = Distance(OBS Mils) / Sea time
			seaSpeed = skdSheetObj.CellValue(arrRow[i], prefix+"nvgt_ml_dist") / skdSheetObj.CellValue(arrRow[i], prefix+"init_tactual_sea_tm_hrs");
			
			// M/E FOC 계산
			calMEFoc = round(calcFoc(coef2, coef, cons, seaSpeed), 8);
			
			// [CHM-201432990] Standard Fuel Consumption By VVD  T/actual 칼럭 로직 수정 - VMS로부터 전달 받은 Actual 값이 존재하지 않을 경우 표시 안 함
			if (skdSheetObj.CellValue(arrRow[i], prefix+"act_foil_csm_cal") != "") {
				// Standard FOC at SEA - T/Actual 셋팅
				skdSheetObj.CellValue2(arrRow[i], prefix+"trnd_line_foil_csm") = round(((calMEFoc + foc_day_ge) * skdSheetObj.CellValue(arrRow[i], prefix+"init_tactual_sea_tm_hrs") / 24), 1);
				
				// Standard FOC at SEA - Actual 셋팅
				skdSheetObj.CellValue2(arrRow[i], prefix+"act_foil_csm") = skdSheetObj.CellValue(arrRow[i], prefix+"act_foil_csm_cal");
			}
			
			// 계산 된 Maneuvering IN
			calVal = parseFloat(skdSheetObj.CellValue(arrRow[i], "dep_mnvr_in_hrs"));
			
			// 계산 된 Maneuvering IN 값이 음수면 P/F SKED의 Maneuvering IN 을 그대로 사용한다.
			if ( calVal != "" && calVal > 0 ) {
				mnvr_in = calVal;
			}
			
			// 계산 된 Maneuvering OUT
			calVal = parseFloat(skdSheetObj.CellValue(arrRow[i], "dep_mnvr_out_hrs"));
			
			// 계산 된 Maneuvering OUT 값이 음수면 P/F SKED의 Maneuvering OUT 을 그대로 사용한다.
			if ( calVal != "" && calVal > 0 ) {
				mnvr_out = calVal;
			}
			
			// [CHM-201432990] Standard Fuel Consumption By VVD  T/actual 칼럭 로직 수정 - VMS로부터 전달 받은 Actual 값이 존재하지 않을 경우 표시 안 함
			if (skdSheetObj.CellValue(arrRow[i], prefix+"act_port_foil_csm_cal") != "") {
				// Standard FOC at Harbor /In port - T/Actual 셋팅
				skdSheetObj.CellValue2(arrRow[i], prefix+"trnd_line_port_foil_csm") = round((((mnvr_in + mnvr_out) * (consumption + foc_day_ge)) / 24), 2) + round((skdSheetObj.CellValue(arrRow[i], "init_tactual_port_time") * (consumption * 0.7 + foc_day_ge) / 24), 2);
				
				// Standard FOC at Harbor /In port - Actual 셋팅
				skdSheetObj.CellValue2(arrRow[i], prefix+"act_port_foil_csm") = skdSheetObj.CellValue(arrRow[i], prefix+"act_port_foil_csm_cal");
			}
		}
		
		skdSheetObj.Redraw = true;
	}
}

/*
 * Calculate Estimated Consumption Weight 
 */
function calcEstmCsmWgt(){
	var skdSheetObj      = findSheetObj(sheetObjects, "sheet1");
	var trndLineSheetObj = findSheetObj(sheetObjects, "sheet_trend_line");
	
	var coef2      = trndLineSheetObj.CellValue(1, "n1st_coef_val");
	var coef       = trndLineSheetObj.CellValue(1, "n2nd_coef_val");
	var cons       = trndLineSheetObj.CellValue(1, "trnd_line_cons_val");
	var foc_day_ge = "";
		
	var prefix   = skdSheetObj.prefix;
	var checkRow = skdSheetObj.FindCheckedRow(prefix+"sel");
	var arrRow   = checkRow.split("|");
	
	var seaTime     = "";	// Sea Time - OPT
	var spd         = "";
	var calVal      = "";
	var calFocVal   = "";
	
	var mnvr_in     = "";
	var mnvr_out    = "";
	var consumption = "";
	
	if ( trndLineSheetObj.CellValue(1, prefix+"foml_desc") != "" ) {
		skdSheetObj.Redraw = false;
		
		for ( var i=0; i<arrRow.length-1; i++ ) {
			if ( skdSheetObj.CellValue(arrRow[i], prefix+"skd_cng_sts_cd") != "S" ) {
				seaTime     = skdSheetObj.CellValue(arrRow[i], prefix+"opmz_sea_tm_hrs") / 24;
				foc_day_ge  = parseFloat(trndLineSheetObj.CellValue(1, "avg_gnr_csm_wgt"));
				mnvr_in     = parseFloat(skdSheetObj.CellValue(arrRow[i], "pf_mnvr_in_hrs"));
				mnvr_out    = parseFloat(skdSheetObj.CellValue(arrRow[i], "pf_mnvr_out_hrs"));
				consumption = parseFloat(skdSheetObj.CellValue(arrRow[i], "mnvr_csm_wgt"));
				
				spd = parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"opmz_sea_spd"));
				
				if ( spd < parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"op_gnr_spd")) ) {
					foc_day_ge = foc_day_ge + (foc_day_ge>6?1.5:1);
				}
				
				if ( spd < parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"op_min_spd")) ) {
					spd = parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"op_min_spd"));
				}
				
				// FOC/day ME 계산
				calFocVal = round(calcFoc(coef2, coef, cons, spd), 8);
				
				// 저장된 SEA - Initial 값 - 미존재
				if ( skdSheetObj.CellValue(arrRow[i], prefix+"s_init_foil_csm") == "" ) {
					skdSheetObj.CellValue2(arrRow[i], prefix+"foc_day_me")    = calFocVal;
					skdSheetObj.CellValue2(arrRow[i], prefix+"foc_day_ge")    = foc_day_ge;
					skdSheetObj.CellValue2(arrRow[i], prefix+"init_foil_csm") = round(((calFocVal + foc_day_ge) * seaTime), 1);
				}
				
				// 저장된 Port - Initial 값 - 미존재
				if ( skdSheetObj.CellValue(arrRow[i], prefix+"s_init_port_foil_csm") == "" ) {
					skdSheetObj.CellValue2(arrRow[i], prefix+"foc_manu") = round((((mnvr_in + mnvr_out) * (consumption + foc_day_ge)) / 24), 2);
					skdSheetObj.CellValue2(arrRow[i], prefix+"foc_port") = round((skdSheetObj.CellValue(arrRow[i], "port_time") * (parseFloat(trndLineSheetObj.CellValue(1, "avg_gnr_csm_wgt")) * 0.7 + foc_day_ge) / 24), 2);
					
					skdSheetObj.CellValue2(arrRow[i], prefix+"init_port_foil_csm") = round(parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"foc_manu")) + parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"foc_port")), 1);
				}
				
				// 저장된 SEA - Initial 값 - 존재
				if ( skdSheetObj.CellValue(arrRow[i], prefix+"s_init_foil_csm") != "" ) {
					
					// RVSD - 존재 하면서 STS - D 가 아닐 경우 수행
					if ( !(skdSheetObj.CellSearchValue(arrRow[i], prefix+"rvis_foil_csm") != "" && skdSheetObj.CellValue(arrRow[i], prefix+"port_skd_sts_cd") == "D") ) {
						skdSheetObj.CellValue2(arrRow[i], prefix+"foc_day_me") = calFocVal;
						skdSheetObj.CellValue2(arrRow[i], prefix+"foc_day_ge") = foc_day_ge;
						
						calVal = round(((calFocVal + foc_day_ge) * seaTime), 1);
						
						if ( calVal == skdSheetObj.CellValue(arrRow[i], prefix+"init_foil_csm") ) {
							skdSheetObj.CellValue2(arrRow[i], prefix+"rvis_foil_csm") = "";
						} else {
							skdSheetObj.CellValue2(arrRow[i], prefix+"rvis_foil_csm") = calVal;
						}
					}
				}
				
				/*
				[CHM-201432990] Standard Fuel Consumption By VVD  T/actual 칼럭 로직 수정 - "Calculation" 버튼을 클릭 했을 때 T/Actual 및 Actual 항목 계산 로직 제거
				// T/Actual 
				skdSheetObj.CellValue2(arrRow[i], prefix+"trnd_line_foil_csm") = round(((calFocVal + foc_day_ge) * skdSheetObj.CellValue(arrRow[i], prefix+"act_opmz_sea_tm_hrs") / 24), 1);
				
				// Actual
				skdSheetObj.CellValue2(arrRow[i], prefix+"act_foil_csm") = skdSheetObj.CellValue(arrRow[i], prefix+"act_foil_csm_cal");
				*/
				
				// 저장된 Port - Initial 값 - 존재
				if ( skdSheetObj.CellValue(arrRow[i], prefix+"s_init_port_foil_csm") != "" ) {
					
					// RVSD - 존재 하면서 STS - D 가 아닐 경우 수행
					if ( !(skdSheetObj.CellSearchValue(arrRow[i], prefix+"rvis_port_foil_csm") != "" && skdSheetObj.CellValue(arrRow[i], prefix+"port_skd_sts_cd") == "D") ) {
						skdSheetObj.CellValue2(arrRow[i], prefix+"foc_manu") = round((((mnvr_in + mnvr_out) * (consumption + foc_day_ge)) / 24), 2);
						skdSheetObj.CellValue2(arrRow[i], prefix+"foc_port") = round((skdSheetObj.CellValue(arrRow[i], "port_time") * (parseFloat(trndLineSheetObj.CellValue(1, "avg_gnr_csm_wgt")) * 0.7 + foc_day_ge) / 24), 2);
						
						calVal = round(parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"foc_manu")) + parseFloat(skdSheetObj.CellValue(arrRow[i], prefix+"foc_port")), 1);
						
						if ( calVal == skdSheetObj.CellValue(arrRow[i], prefix+"init_port_foil_csm") ) {
							skdSheetObj.CellValue2(arrRow[i], prefix+"rvis_port_foil_csm") = "";
						} else {
							skdSheetObj.CellValue2(arrRow[i], prefix+"rvis_port_foil_csm") = calVal;
						}
					}
				}
				
				calVal = parseFloat(skdSheetObj.CellValue(arrRow[i], "dep_mnvr_in_hrs"));
				
				// T/Actual
				if ( calVal != "" && calVal > 0 ) {
					mnvr_in = calVal;
				}
				
				calVal = parseFloat(skdSheetObj.CellValue(arrRow[i], "dep_mnvr_out_hrs"));
				
				if ( calVal != "" && calVal > 0 ) {
					mnvr_out = calVal;
				}
				
				/*
				[CHM-201432990] Standard Fuel Consumption By VVD  T/actual 칼럭 로직 수정 - "Calculation" 버튼을 클릭 했을 때 T/Actual 및 Actual 항목 계산 로직 제거
				skdSheetObj.CellValue2(arrRow[i], prefix+"trnd_line_port_foil_csm") = round((((mnvr_in + mnvr_out) * (consumption + foc_day_ge)) / 24), 2) + round((skdSheetObj.CellValue(arrRow[i], "act_port_time") * (consumption * 0.7 + foc_day_ge) / 24), 2);
				
				// Actual
				skdSheetObj.CellValue2(arrRow[i], prefix+"act_port_foil_csm") = skdSheetObj.CellValue(arrRow[i], prefix+"act_port_foil_csm_cal");
				*/
			}
		}
		
		ttlRowCalc(skdSheetObj);
		
		skdSheetObj.Redraw = true;
	}
}

function setTrndLineNo(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	
	if ( aryPopupData != "" ) {
		var sheetObj = findSheetObj(sheetObjects, "sheet_trend_line");
		var prefix = sheetObj.prefix;
		sheetObj.RemoveAll(); // Remove previous data
		sheetObj.DataInsert(-1);
		
		sheetObj.CellValue2(1, prefix+"trnd_line_seq")   = aryPopupData[0][0];
		sheetObj.CellValue2(1, prefix+"trnd_line_tp_cd") = aryPopupData[0][1];
		if(aryPopupData[0][2]=="ALL"){
			sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = "A";
		}else{
			sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = aryPopupData[0][2];
		}
		sheetObj.CellValue2(1, prefix+"vsl_clss_cd")      = aryPopupData[0][3];
		sheetObj.CellValue2(1, prefix+"vsl_clss_sub_cd")  = aryPopupData[0][4];
		sheetObj.CellValue2(1, prefix+"trnd_line_vsl_cd") = aryPopupData[0][5];
		if(aryPopupData[0][6]=="ALL"){
			sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = "A";
		}else{
			sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = aryPopupData[0][6];
		}
		sheetObj.CellValue2(1, prefix+"trnd_line_tp_sub_cd") = aryPopupData[0][7];
		sheetObj.CellValue2(1, prefix+"n1st_coef_val")       = aryPopupData[0][8];
		sheetObj.CellValue2(1, prefix+"n2nd_coef_val")       = aryPopupData[0][9];
		sheetObj.CellValue2(1, prefix+"trnd_line_cons_val")  = aryPopupData[0][10];
		sheetObj.CellValue2(1, prefix+"foml_desc")           = aryPopupData[0][23];
		sheetObj.CellValue2(1, prefix+"trnd_line_fm_dt")     = aryPopupData[0][11];
		sheetObj.CellValue2(1, prefix+"trnd_line_to_dt")     = aryPopupData[0][12];
		sheetObj.CellValue2(1, prefix+"trnd_line_no")        = aryPopupData[0][14];
		sheetObj.CellValue2(1, prefix+"trnd_line_use_tp_cd") = aryPopupData[0][15];
		sheetObj.CellValue2(1, prefix+"avg_slp_rt")          = aryPopupData[0][22];
		/* Trend Line Inquiry(Pop-up) 화면에서 simulation 계산 시 필수항목인 avg_gnr_csm_wgt 받아 오는 값 추가 - 2014.07.08 Lee Byoung Hoon  */
		sheetObj.CellValue2(1, prefix+"avg_gnr_csm_wgt")          = aryPopupData[0][20];
		
		formObj.trnd_line_no.value = aryPopupData[0][14];
		formObj.slip.value         = aryPopupData[0][22];
		formObj.foml_desc.value    = aryPopupData[0][23];
	}
}

/**
 * 마우스가 이동될 때 이벤트 처리 
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var trndLineSheetObj = findSheetObj(sheetObjects, "sheet_trend_line");
	
	var prefix = sheetObj.prefix;
	var Row    = sheetObj.MouseRow;
	var Col    = sheetObj.MouseCol;
	
	var colNm = sheetObj.ColSaveName(Col);
	
	if ( sheetObj.HeaderRows - 1 < Row ) {
		var textSea  = "";
		var textPort = "";
		
		if ( sheetObj.CellValue(Row, prefix+"foc_day_me") != "" && trndLineSheetObj.CellValue(1, "avg_gnr_csm_wgt") != "" ) {
			textSea  = "ME FOC Q'ty : " + sheetObj.CellValue(Row, prefix+"foc_day_me") + " / G/E FOC Q'ty : " + sheetObj.CellValue(Row, prefix+"foc_day_ge");
		}
		
		if ( sheetObj.CellValue(Row, prefix+"foc_manu") != "" && sheetObj.CellValue(Row, prefix+"foc_port") != "" ) {
			textPort = "Manuv. FOC Q'ty : " + sheetObj.CellValue(Row, prefix+"foc_manu") + " / Port FOC Q'ty : " + sheetObj.CellValue(Row, prefix+"foc_port");
		}
		
		if ( textSea != "" && colNm == prefix+"init_foil_csm" && sheetObj.CellValue(Row, prefix+"init_foil_csm") != "" && sheetObj.CellValue(Row, prefix+"rvis_foil_csm") == "" ){
			sheetObj.MouseToolTipText = textSea;
		} else if ( textSea != "" && colNm == prefix+"rvis_foil_csm" && sheetObj.CellValue(Row, prefix+"rvis_foil_csm") != "" ) {
			sheetObj.MouseToolTipText = textSea;
		} else if ( textPort != "" && colNm == prefix+"init_port_foil_csm" && sheetObj.CellValue(Row, prefix+"init_port_foil_csm") != "" && sheetObj.CellValue(Row, prefix+"rvis_port_foil_csm") == "" ){
			sheetObj.MouseToolTipText = textPort;
		} else if ( textSea != "" && colNm == prefix+"rvis_port_foil_csm" && sheetObj.CellValue(Row, prefix+"rvis_port_foil_csm") != "" ) {
			sheetObj.MouseToolTipText = textPort;
		} else {
			sheetObj.MouseToolTipText = "";
		}
	} else {
		sheetObj.MouseToolTipText = "";
	}
	
	// 이전 3항차 정보 말풍선 표시 기능 추가 - Add By 2014.08.22 Lee Byoung Hoon
	if (colNm == prefix+"act_csm_avg_ttl") {
		var textPreviousDetail = ""  + "\t" + "OBS" + "\t" + "ENG" + "\t" + "Slip" + "\t" + "ManeV" + "\t" + "Port" + "\t" + "Speed" + "\t" + "SEA" + "\t" + "Port"
									+ "\n"
									+ sheetObj.CellValue(Row, prefix+"one_ago_previous")
									+ "\n"
									+ sheetObj.CellValue(Row, prefix+"two_ago_previous")
									+ "\n"
									+ sheetObj.CellValue(Row, prefix+"three_ago_previous");
		sheetObj.ToolTipOption="balloon:true;width:430";
		sheetObj.ToolTipText(Row, Col) = textPreviousDetail;
	}

}

/**
 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
 * 선택된 Row의 init_foil_csm 또는 init_port_foil_csm 컬럼 값이 존재 할 경우 Delete 버튼 활성화하고 존재하지 않을 경우 비활성화 한다.
 * Added By 2014.07.08 Lee Byoung Hoon
 * 
 * @param sheetObj
 * @param OldRow
 * @param OldCol
 * @param NewRow
 * @param NewCol
 */
function sheet1_OnSelectCell (sheetObj, OldRow, OldCol, NewRow, NewCol) {
	var formObj   = document.form;
	
	formObj.selectedRow.value = NewRow;
	
	if (sheetObj.CellValue(NewRow, "init_foil_csm") != "" || sheetObj.CellValue(NewRow, "init_port_foil_csm") != "") {
		ComBtnEnable("btn_Delete");
	} else {
		ComBtnDisable("btn_Delete");
	}
}

/**
 * Delete 버튼에 대한 처리를 한다.
 * Added By 2014.07.08 Lee Byoung Hoon
 */
function processDelete () {
	var sheetObj = sheetObjects[0];
	var formObj   = document.form;
	var selectedRow = formObj.selectedRow.value;
	
	if (sheetObj.CellValue(selectedRow, "rvis_foil_csm") != "" || sheetObj.CellValue(selectedRow, "rvis_port_foil_csm") != "") {
		sheetObj.CellValue2(selectedRow, "rvis_foil_csm") = "";
		sheetObj.CellValue2(selectedRow, "rvis_port_foil_csm") = "";
	} else if (sheetObj.CellValue(selectedRow, "init_foil_csm") != "" || sheetObj.CellValue(selectedRow, "init_port_foil_csm") != "") {
		sheetObj.CellValue2(selectedRow, "init_foil_csm") = "";
		sheetObj.CellValue2(selectedRow, "s_init_foil_csm") = "";
		sheetObj.CellValue2(selectedRow, "init_port_foil_csm") = "";
		sheetObj.CellValue2(selectedRow, "s_init_port_foil_csm") = "";
		
		ComBtnDisable("btn_Delete");
	}
}

function ttlRowCalc(sheetObj) {
	var formObj   = document.form;
	var sRow      = sheetObj.HeaderRows;
	var eRow      = sRow + sheetObj.RowCount - 1;
	var lRow      = sheetObj.LastRow;
	var prefix    = sheetObj.prefix;
	
	var ttlDis    = sheetObj.CellValue(lRow, prefix+"opmz_dist");
	var spd       = "";
	var spdTtl    = 0;
	
	var ttlDisPF  = sheetObj.CellValue(lRow, prefix+"dist_pf_lnk");
	var spdPF     = "";
	var spdTtlPF  = 0;
	
	var ttlDisOPT = sheetObj.CellValue(lRow, prefix+"dist_opmz");
	var spdOPT    = "";
	var spdTtlOPT = 0;
	
	if ( sRow == eRow ) eRow++; 
	
	for (var i=sRow; i<eRow; i++ ) {
		if ( sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S" ) {
			spd    = parseFloat(sheetObj.CellValue(i, prefix+"opmz_sea_spd"));
			spdPF  = parseFloat(sheetObj.CellValue(i, prefix+"spd_pf_lnk"));
			spdOPT = parseFloat(sheetObj.CellValue(i, prefix+"spd_opmz"));
			
			if ( spd != 0 && spd != "" ) {
				spdTtl = spdTtl + ( parseFloat(sheetObj.CellValue(i, prefix+"opmz_dist")) / ttlDis * spd );
			}
			
			if ( spdPF != 0 && spdPF != "" ) {
				spdTtlPF = spdTtlPF + ( parseFloat(sheetObj.CellValue(i, prefix+"dist_pf_lnk")) / ttlDisPF * spdPF );
			}
			
			if ( spdOPT != 0 && spdOPT != "" ) {
				spdTtlOPT = spdTtlOPT + ( parseFloat(sheetObj.CellValue(i, prefix+"dist_opmz")) / ttlDisOPT * spdOPT );
			}
		}
	}
	
	if ( lRow > sRow ) {
		sheetObj.CellValue(lRow, "opmz_sea_spd") = spdTtl;
		sheetObj.CellValue(lRow, "spd_pf_lnk")   = spdTtlPF;
		sheetObj.CellValue(lRow, "spd_opmz")     = spdTtlOPT;
	}
	
	// 음수 0 처리시 하나라도 바뀌면 Total Row 색도 바껴서 원복
	sheetObj.CellFontColor(lRow, prefix+"opmz_sea_spd")    = sheetObj.RgbColor(0, 0, 0);
	sheetObj.CellFontColor(lRow, prefix+"opmz_sea_tm_hrs") = sheetObj.RgbColor(0, 0, 0);
	
	// 컬럼 너비 재조정하기 -- Start
	var rHead = "|";
	
	for ( var i=0; i<ComCountHeadTitle(HeadTitle1); i++ ) {
		rHead = rHead + "|";
	}
	
	sheetObj.InitHeadRow(0, rHead, true);	//	너비 자동 조정 시 Head 길이도 체크하므로 초기화 
	
	sheetObj.FitSize(false, true);			//	너비 자동 조정
	
	sheetObj.InitHeadRow(0, HeadTitle1, true);	//	Head 원복 
	// 컬럼 너비 재조정하기 -- End
}

function sheet1_OnClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var prefix  = sheetObj.prefix;
	var vvd     = sheetObj.CellValue(Row, prefix+"vsl_cd");
	
	if ( vvd != "" && vvd.lenth != 9 ) {
		// SHEET 선택 시 해당 ROW의 VVD를 조회조건의 VVD로 셋팅.
		formObj.vsl_cd.value     = sheetObj.CellValue(Row, prefix+"vsl_cd");
		formObj.skd_voy_no.value = sheetObj.CellValue(Row, prefix+"skd_voy_no");
		formObj.skd_dir_cd.value = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
	}
}
/* 개발자 작업 끝 */