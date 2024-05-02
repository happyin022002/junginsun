/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0051.js
 *@FileTitle : 화면명
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
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
 * @class VOP_FCM_0051 : VOP_FCM_0051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0051() {
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
			if(formObj.trnd_line_tp_cd.Code!=""){
				ComOpenPopup('VOP_FCM_0014.do?trndLineTpCd='+formObj.trnd_line_tp_cd.Code, 950, 650, 'setTrndLineNo', '0,0', true, false);
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
			var Col = sheetObj.SaveNameCol(sheetObj.prefix+"day_csm_wgt");
			sheetObj.Redraw = false;
			for(var i=Col; i<sheetObj.LastCol; i++){
				sheetObj.ColHidden(i) = false;
			}
			sheetObj.Redraw = true;
			document.getElementById("reduce_div").style.display = "";
			document.getElementById("expand_div").style.display = "none";
			break;
			
		case "btn_Reduce":
			var Col = sheetObj.SaveNameCol(sheetObj.prefix+"day_csm_wgt");
			sheetObj.Redraw = false;
			for(var i=Col; i<sheetObj.LastCol; i++){
				sheetObj.ColHidden(i) = true;
			}
			sheetObj.Redraw = true;
			document.getElementById("reduce_div").style.display = "none";
			document.getElementById("expand_div").style.display = "";
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObj, formObj, MULTI);
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
	
	with (formObj.trnd_line_tp_cd) {
 		//MultiSelect = true;
 		MultiSeparator = ",";
 		DropHeight = 320;
 		InsertItem(0, '1 - Design Capa./Lane',		'1');
 		InsertItem(1, '2 - Design Capa./All',		'2' );
 		InsertItem(2, '3 - Vessel/Bound',	'3');
 		InsertItem(3, '4 - Vessel/All', 	'4');
 	}

	initControl();
	formObj.vsl_cd.focus();
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
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("keypress", "obj_keypress", formObj);
	axon_event.addListenerForm("keyup", "obj_keyup", formObj);

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
	switch(comboObj.id) {
		case "trnd_line_tp_cd":
			with (comboObj) {
				MultiSelect = false;
			}
			break;
	}
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
	     	InitRowInfo( 2, 1, 3, 100);
	     	
	     	// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     	InitHeadMode(true, true, false, true, false, false)
	     	
	     
	        var HeadTitle1 = "|SEL|VVD_SEQ|Call\nSEQ|Lane|VVD|Port\nCode|TMNL\nCode|Change\nStatus|ETA|ETB|ETD|Port\nTime|Sea\nTime|Sea\nSpeed|Consumption|Consumption|ROB|ROB|ROB|ORG_ROB|Supply\nQ’ty|Consumption|Consumption|Consumption|Consumption|Port Time|Port Time|Sea Time|Sea Time|Distance|Distance|Sea Speed|Sea Speed"; 
	    	var HeadTitle2 = "|SEL|VVD_SEQ|Call\nSEQ|Lane|VVD|Port\nCode|TMNL\nCode|Change\nStatus|ETA|ETB|ETD|Port\nTime|Sea\nTime|Sea\nSpeed|EST|RFC|FOIL|FOIL_LS|ROB|ORG_ROB|Supply\nQ’ty|FOC/Day|Port|Sea\n(ME)|Sea\n(G/E)|P/F|Act|P/F|Act|P/F|VOSI|P/F|BUFF"; 
	     	
	     	var headCount = ComCountHeadTitle(HeadTitle1);
	     	
	     	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     	InitColumnInfo(headCount, 0, 0, true);
	     	
	     	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     	InitHeadRow(0, HeadTitle1, true);
	     	InitHeadRow(1, HeadTitle2, true);
     

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     	InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	    daCenter,	true,	prefix+"ibflag",			false,	"",      	dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtCheckBox,     30,	    daCenter,	true,	prefix+"Sel",				false,	"",      	dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"vvd_seq",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,	prefix+"clpt_seq",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"slan_cd",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"vvd",				false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"vps_port_cd",		false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"skd_cng_sts_cd",	false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    97,	daCenter,	true,	prefix+"vps_eta_dt",		false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			97,	daCenter,	true,	prefix+"vps_etb_dt",		false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    97,	daCenter,	true,	prefix+"vps_etd_dt",		false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"port_tm_hrs",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"sea_tm_hrs",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"sea_spd",			false,	"",			dfNone,			0,			false,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    50,		daRight,	true,	prefix+"estm_csm_wgt",		false,	"",			dfNullFloat,			1,			true,		false, 	6, false, false);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"avg_csm_wgt",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,	    60,		daRight,	true,	prefix+"dep_foil_wgt",				false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,	    60,		daRight,	true,	prefix+"dep_low_sulp_foil_wgt",				false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,		    60,		daRight,	true,	prefix+"rob",				false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,	    60,		daRight,	true,	prefix+"org_rob",			false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	prefix+"supl_wgt",			false,	"",			dfNullFloat,			1,			true,		false, 	8, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,			100,	daRight,	true,	prefix+"day_csm_wgt",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		    100,	daRight,	true,	prefix+"port_csm_wgt",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,			100,	daRight,	true,	prefix+"sail_me_csm_wgt",	false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,			100,	daRight,	true,	prefix+"sail_gnr_csm_wgt",	false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"pf_port_tm",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"act_port_tm",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,		    70,	daRight,	true,	prefix+"pf_sea_tm",			false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"act_sea_tm",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"pf_port_dist",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,		    70,	daRight,	true,	prefix+"act_port_dist",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"pf_sea_spd",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);
			InitDataProperty(0, cnt++ , dtHidden,			70,	daRight,	true,	prefix+"pf_buff_spd",		false,	"",			dfNullFloat,			0,			true,		false, 	-1, false, false);

			RowHeight(0) = 20;
			RowHeight(1) = 30;
			

			InitDataCombo(0, prefix+"skd_cng_sts_cd", "|Skip|Add|Phase In|Phase Out", "|S|A|I|O");
			
			//ScrollBar = 2;

			// CountPosition = 0;
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
	     	InitRowInfo( 1, 1, 3, 100);
	     	
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
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_no"    );
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
	     	InitDataProperty(0, cnt++, dtData, 50, daLeft, true, prefix+"trnd_line_cons_val"            );
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
	switch (sAction) {
	case SEARCH: // VVD 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0051GS.do", FormQueryString(formObj));
			var xmlArr = rXml.split("|$$|");
			
			var val = "";
			if(val = ComGetEtcData(xmlArr[0], "lane_cd")){
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
			
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			
			var rXml = sheetObj.GetSaveXml("VOP_FCM_0051GS.do");
			
			var val = "";
			if(val = ComGetEtcData(xmlArr[0], "sim_no")){
				formObj.sim_no.value = val;
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
			if (!(ComChkLen(formObj.vsl_cd.value, 4) == 2 && ComChkLen(formObj.skd_voy_no.value, 4) == 2
				&& ComChkLen(formObj.skd_dir_cd.value, 1) == 2)) {
					ComShowMessage("Please check VVD");
					return false;
				}
			break;
		case MULTI:
			break;
	}

	return true;
}

function setTrndLineNo(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	if(aryPopupData!=""){
//		formObj.vsl_clss_cd.value="";
//		formObj.vsl_clss_sub_cd.value="";
//		formObj.vsl_slan_cd.value="";
//		formObj.trnd_line_vsl_cd.value="";
//		formObj.trnd_line_skd_dir_cd.value="";
//		
//		formObj.trnd_line_no.value=aryPopupData[0][14];
//		formObj.trnd_line_use_tp_cd.value=aryPopupData[0][15];
//		formObj.trnd_line_tp_sub_cd.value=aryPopupData[0][7];
//		if(aryPopupData[0][1]=="1" || aryPopupData[0][1]=="2"){
//			formObj.vsl_clss_cd.value=aryPopupData[0][3];
//			if(aryPopupData[0][4]!=""){
//				formObj.vsl_clss_sub_cd.value=aryPopupData[0][4];
//			}
//			if(aryPopupData[0][2]=="ALL"){
//				formObj.vsl_slan_cd.value="A";
//			}else{
//				formObj.vsl_slan_cd.value=aryPopupData[0][2];
//			}
//		}else if(aryPopupData[0][1]=="3" || aryPopupData[0][1]=="4"){
//			formObj.trnd_line_vsl_cd.value=aryPopupData[0][5];
//			if(aryPopupData[0][6]=="ALL"){
//				formObj.trnd_line_skd_dir_cd.value="A";
//			}else{
//				formObj.trnd_line_skd_dir_cd.value=aryPopupData[0][6];
//			}
//		}
//		formObj.trnd_line_fm_dt.value=aryPopupData[0][11];
//		formObj.trnd_line_to_dt.value=aryPopupData[0][12];
//		 
//		formObj.trnd_line_seq.value=aryPopupData[0][0];
		 
		var sheetObj = findSheetObj(sheetObjects, "sheet_trend_line");
		var prefix = sheetObj.prefix;
		sheetObj.RemoveAll(); // Remove previous data
		sheetObj.DataInsert(-1);
		
//		sheetObj.CellValue2(1, prefix+"trnd_line_no") = aryPopupData[0][14];
//		sheetObj.CellValue2(1, prefix+"trnd_line_use_tp_cd") = aryPopupData[0][15];
//		sheetObj.CellValue2(1, prefix+"trnd_line_tp_sub_cd") = aryPopupData[0][7];
//		
//		if(aryPopupData[0][1]=="1" || aryPopupData[0][1]=="2"){
//			sheetObj.CellValue2(1, prefix+"vsl_clss_cd") = aryPopupData[0][3];
//			if(aryPopupData[0][4]!=""){
//				sheetObj.CellValue2(1, prefix+"vsl_clss_sub_cd") = aryPopupData[0][4];
//			}
//			if(aryPopupData[0][2]=="ALL"){
//				sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = "A";
//			}else{
//				sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = aryPopupData[0][2];
//			}
//		}else if(aryPopupData[0][1]=="3" || aryPopupData[0][1]=="4"){
//			sheetObj.CellValue2(1, prefix+"trnd_line_vsl_cd") = aryPopupData[0][5];
//			if(aryPopupData[0][6]=="ALL"){
//				sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = "A";
//			}else{
//				sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = aryPopupData[0][6];
//			}
//		}
//		sheetObj.CellValue2(1, prefix+"trnd_line_fm_dt") = aryPopupData[0][11];
//		sheetObj.CellValue2(1, prefix+"trnd_line_to_dt") = aryPopupData[0][12];
//		sheetObj.CellValue2(1, prefix+"trnd_line_seq") = aryPopupData[0][0];
		
		
		
		
		
		sheetObj.CellValue2(1, prefix+"trnd_line_seq") = aryPopupData[0][0];
		sheetObj.CellValue2(1, prefix+"trnd_line_tp_cd") = aryPopupData[0][1];
		if(aryPopupData[0][2]=="ALL"){
			sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = "A";
		}else{
			sheetObj.CellValue2(1, prefix+"vsl_slan_cd") = aryPopupData[0][2];
		}
		sheetObj.CellValue2(1, prefix+"vsl_clss_cd") = aryPopupData[0][3];
		sheetObj.CellValue2(1, prefix+"vsl_clss_sub_cd") = aryPopupData[0][4];
		sheetObj.CellValue2(1, prefix+"trnd_line_vsl_cd") = aryPopupData[0][5];
		if(aryPopupData[0][6]=="ALL"){
			sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = "A";
		}else{
			sheetObj.CellValue2(1, prefix+"trnd_line_skd_dir_cd") = aryPopupData[0][6];
		}
		sheetObj.CellValue2(1, prefix+"trnd_line_tp_sub_cd") = aryPopupData[0][7];
		sheetObj.CellValue2(1, prefix+"n1st_coef_val") = aryPopupData[0][8];
		sheetObj.CellValue2(1, prefix+"n2nd_coef_val") = aryPopupData[0][9];
		sheetObj.CellValue2(1, prefix+"trnd_line_cons_val") = aryPopupData[0][10];
		sheetObj.CellValue2(1, prefix+"trnd_line_fm_dt") = aryPopupData[0][11];
		sheetObj.CellValue2(1, prefix+"trnd_line_to_dt") = aryPopupData[0][12];
		sheetObj.CellValue2(1, prefix+"trnd_line_no") = aryPopupData[0][14];
		sheetObj.CellValue2(1, prefix+"trnd_line_use_tp_cd") = aryPopupData[0][15];
		
		calcEstmCsmWgt();
	}
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
				formObj.lane_cd.value = rtnDatas[5];
			}
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	var prefix = sheetObj.prefix;
	var rob = "";

	// Backup original ROB.
	for(var i=sRow; i<eRow; i++){
		rob = Number(sheetObj.CellValue(i, prefix+"dep_foil_wgt")) + Number(sheetObj.CellValue(i, prefix+"dep_low_sulp_foil_wgt"));
		sheetObj.CellValue2(i, prefix+"rob") = rob;
		
		// User cannot modify a consumption weight, a supply weight if the departure report exists.  
		if(rob!=""){
			sheetObj.CellValue2(i, prefix+"org_rob") = rob;
			sheetObj.CellValue2(i, prefix + "estm_csm_wgt")="";
			sheetObj.CellEditable(i, prefix+"estm_csm_wgt")=false;
//			sheetObj.CellValue2(i, prefix+"avg_csm_wgt")="";
			sheetObj.CellEditable(i, prefix+"avg_csm_wgt")=false;
			sheetObj.CellEditable(i, prefix+"rob")=false;
			sheetObj.CellEditable(i, prefix+"supl_wgt")=false;
		}
		
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")=="S"){
			sheetObj.CellEditable(i, prefix+"estm_csm_wgt")=false;
			sheetObj.CellEditable(i, prefix+"avg_csm_wgt")=false;
			sheetObj.CellEditable(i, prefix+"rob")=false;
			sheetObj.CellEditable(i, prefix+"supl_wgt")=false;
		}
	}
	
	calcRob(sheetObj);
	
	paintVVD(sheetObj);
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var colSaveName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var prefix = sheetObj.prefix;
	switch(colSaveName){
		case prefix+"supl_wgt":
			calcRob(sheetObj);
			break;
		case prefix+"estm_csm_wgt":
			calcRob(sheetObj);
			break;
	}
}

function calcRob(sheetObj){
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	var prefix = sheetObj.prefix;
	sheetObj.Redraw = false;
	
	// Find Last Departure Reporting Port
	for(var i=sRow; i<eRow; i++){
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")!="S" && sheetObj.CellValue(i, prefix+"org_rob")==""){
			sRow = i;//Find First SKD
			break;
		}
	}
	
	var nextSkdIdx = 0;
	var lastSkdIdx = 0;
	
	var iPrevRob = 0;
	var iCsmWgt = 0;
	var iSuplWgt = 0;
	
	for(var i=sRow; i<eRow; i++){
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")=="S"){
			continue;
		}
		//sheetObj.CellValue2(i+1, prefix+"dep_foil_wgt") = Number(sheetObj.CellValue(i, prefix+"dep_foil_wgt")) - Number(sheetObj.CellValue(i+1, prefix+"estm_csm_wgt")) + Number(sheetObj.CellValue(i+1, prefix+"supl_wgt"));
	
		nextSkdIdx = findNextSkdIdx(sheetObj, i);
		lastSkdIdx = findLastSkdIdx(sheetObj, i);
		
		//ROB = Previous ROB - Consumption(EST or RFC)
		iPrevRob = Number(sheetObj.CellValue(lastSkdIdx, prefix+"rob"));
		
		
		if(FcmIsNull(sheetObj.CellValue(i, prefix+"estm_csm_wgt"))){
			if(FcmIsNull(sheetObj.CellValue(i, prefix+"avg_csm_wgt"))){
				iCsmWgt = Number(sheetObj.CellValue(i, prefix+"avg_csm_wgt"));
			}
		}else{
			iCsmWgt = Number(sheetObj.CellValue(i, prefix+"estm_csm_wgt"));
			
		}
			
		iSuplWgt = Number(sheetObj.CellValue(i, prefix+"supl_wgt"));
		
		sheetObj.CellValue2(i, prefix+"rob") = iPrevRob - iCsmWgt + iSuplWgt;
		
		
		
	}
	sheetObj.Redraw = true;
}

function findNextSkdIdx(sheetObj, currIdx){
	var row = 0;
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	var prefix = sheetObj.prefix;
	for(var i=currIdx+1; i<eRow; i++){
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")!="S"){
			row = i;
			break;
		}
	}
	return row;
}

function findLastSkdIdx(sheetObj, currIdx){
	var row = 0;
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	var prefix = sheetObj.prefix;
	for(var i=currIdx-1; i>=sRow; i--){
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")!="S"){
			row = i;
			break;
		}
	}
	return row;
}

/*
 * VVD별로 구분이 되도록 배경색을 설정한다.
 */
function paintVVD(sheetObj){
	
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	var prefix = sheetObj.prefix;
	var vvdSeq = "";
	sheetObj.Redraw = false;
	for(var i=sRow; i<eRow; i++){
		
		// Set the uncorrectable background color. 
		if(sheetObj.CellValue(i, prefix+"skd_cng_sts_cd")=="S" || sheetObj.CellValue(i, prefix+"org_rob")!=""){
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(240, 240, 240);
		}else{
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 255);
		}
		
		vvdSeq = sheetObj.CellValue(i, prefix+"vvd_seq");
		
		for(var k=0; k<sheetObj.SaveNameCol(prefix+"sea_spd"); k++){
			sheetObj.CellBackColor(i, k) = sheetObj.RgbColor(155+(Number(vvdSeq)*20), 155+(Number(vvdSeq)*20), 255); 
		}
		
	}
	sheetObj.Redraw = true;
}

/*
 * Trend Line Sheet 조회 이후 설정
 */
function sheet_trend_line_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	var prefix = sheetObj.prefix;
	var row = sheetObj.RowCount;
	
	if(row>0){
		formObj.trnd_line_tp_cd.Code = sheetObj.CellValue(row, prefix+"trnd_line_tp_cd");
		formObj.trnd_line_no.value = sheetObj.CellValue(row, prefix+"trnd_line_no");
		
		calcEstmCsmWgt();
	}
}

/*
 * Calculate Estimated Consumption Weight 
 */
function calcEstmCsmWgt(){
	var skdSheetObj = findSheetObj(sheetObjects, "sheet1");
	var trndLineSheetObj = findSheetObj(sheetObjects, "sheet_trend_line");
	var coef2 = trndLineSheetObj.CellValue(1, "n1st_coef_val");
	var coef = trndLineSheetObj.CellValue(1, "n2nd_coef_val");
	var cons = trndLineSheetObj.CellValue(1, "trnd_line_cons_val");
	
	var sRow = skdSheetObj.HeaderRows;
	var eRow = sRow + skdSheetObj.RowCount;
	var prefix = skdSheetObj.prefix;
	skdSheetObj.Redraw = false;
	for(var i=sRow; i<eRow; i++){
		if(skdSheetObj.CellValue(i, prefix+"skd_cng_sts_cd")!="S" && 
				skdSheetObj.CellValue(i, prefix+"org_rob")==""){
			// Estimated Consumption 24 Hours based
			skdSheetObj.CellValue2(i, prefix+"day_csm_wgt") = 
				round(calcFoc(coef2, coef, cons, skdSheetObj.CellValue(i, prefix+"sea_spd")), 1);
			// Estimated Consumption total sea hours
			skdSheetObj.CellValue2(i, prefix+"estm_csm_wgt") = round(calcFoc(
					coef2, coef, cons, skdSheetObj.CellValue(i, prefix+"sea_spd")) * 
					(skdSheetObj.CellValue(i, prefix+"sea_tm_hrs")/24), 1);
		}
	}
	skdSheetObj.Redraw = true;
	calcRob(skdSheetObj);
}

/*
 * Calculate Sheet Data
 */
function calcSheet(){
	var sheetObj = findSheetObj(sheetObjects, "sheet1");
	
	// step 1. Calculate consumption column
	// step 2. Calculate estimation column
	// step 3. Calculate ROB column
}

/* 개발자 작업 끝 */