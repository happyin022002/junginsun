/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_FMS_0090.js
 *@FileTitle : Off-Hire Expenses
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.02.13
 *@LastModifier : 차상영
 *@LastVersion : 1.0
 * 2014.11.01 차상영
 * 1.0 Creation 
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
 * @class ESM_FMS_0090 : ESM_FMS_0090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_FMS_0090() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	
	/** **************************************************** */
	var tabObj    = tabObjects[0];
	var formObj = document.form;
	var selTabIdx = tabObj.SelectedIndex;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_Detail1":
				 if(!validateForm(formObj, COMMAND04)) {
					 return;
				 }				 
				 openDetailPopup(COMMAND04);				 
				break;
			case "btn_Detail3":
				 if(!validateForm(formObj, COMMAND07)) {
					 return;
				 }								 
				 openDetailPopup(COMMAND07);				 
				break;				
			case "btn_Save":
				 if(!validateForm(formObj, MULTI)) {
					 return;
				 }
				doActionIBSheet(sheetObjects[0],formObj,MULTI);
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);		//2018.04.23 저장후 조회 추가
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObjects[0],formObj,IBINSERT);
				break;			
			case "btn_Delete" :
				doActionIBSheet(sheetObjects[0],formObj,IBDELETE);
				break;					
			case "btn_Retrieve" : //Processing & Completed 탭 조회
				doActionIBSheet(sheetObjects[0],formObj,107);
				break;
			case "btn_OffhFmDt": 
				var cal = new ComCalendar();
				cal.select(formObj.vnor_offh_fm_dt, 'yyyy-MM-dd');
				break;
			case "btn_OffhToDt":
				var cal = new ComCalendar();
				cal.select(formObj.vnor_offh_to_dt, 'yyyy-MM-dd');	
				break;
			case "btn_VslCd" :
				ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
        		break;        		
			case "btn_ToNonConfirm1" : 
				doActionIBSheet(sheetObjects[0], formObj, 100);
				break;				
			case "btn_Cnfm" : 
				doActionIBSheet(sheetObjects[1], formObj, 101);
				break;        		        		
			case "btn_Complete" : 
				doActionIBSheet(sheetObjects[1], formObj, 102);
				break;        		        		
			case "btn_ExcelDown1" : 
            	if ( sheetObjects[0].rowCount != 0 ) {
            		sheetObjects[0].Down2Excel(-1);
            	} else {
            		alert("No data found.");
            		return; 
            	}
				break;        		        						
			case "btn_ExcelDown2" : 
            	if ( sheetObjects[1].rowCount != 0 ) {
            		sheetObjects[1].Down2Excel(-1);
            	} else {
            		alert("No data found.");
            		return; 
            	}
				break;        		        		
			case "btn_ToNonConfirm3" : 
				doActionIBSheet(sheetObjects[2], formObj, 103);
				break;        		        		
			case "btn_ToConfirm" : 
				doActionIBSheet(sheetObjects[2], formObj, 104);
				break;        		        		
			case "btn_ExcelDown3" : 
            	if ( sheetObjects[2].rowCount != 0 ) {
            		sheetObjects[2].Down2Excel(-1);
            	} else {
            		alert("No data found.");
            		return; 
            	}      	  		
				break;
			case "btn_New" : 
				ComResetAll();
				break;	
			case "btn_Save3" :
				 if(!validateForm(formObj, MULTI06)) {
					 return;
				 }
				doActionIBSheet(sheetObjects[2],formObj,MULTI06);
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
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }    
	initControl();	
	
	formObj.vnor_offh_fm_dt.value = ComGetDateAdd(null, "M", -1);
	formObj.vnor_offh_to_dt.value = ComGetNowInfo("ymd");
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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

	axon_event.addListenerForm("keypress",		 "obj_keypress",  formObj);
	axon_event.addListenerForm("change",		 "obj_change",	  formObj);
}


function obj_keyup() {
	
}

function obj_keypress() {
	switch(event.srcElement.name){
		case "vsl_cd":
			//영대문자 자동변환
			ComKeyOnlyAlphabet('uppernum');		
			break;
	}
}

function obj_change() {
	switch(event.srcElement.name){
		case "vsl_cd":
			doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);	//Vessel Code 입력 후 Name정보 가져오기
			break;
	}	
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			var prefix = "sheet1_";
		
			// 높이 설정
	    	style.height = 382;
			SheetWidth = mainTable.clientWidth;
	
		 	// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;			
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
	
			var HeadTitle1 = "|Sel.|Vessel|Vessel|Vessel|Type|Place|Item|Period|Period|Period|Period|Ofc|UOM|Value|KIND|OPF File|OPF File|FMS File|FMS File|||Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd|cr_chk_flg|vnor_mn_itm_flg";
			var HeadTitle2 = "|Sel.|VSL|VOY|Dir|Type|Place|Item|From|From|To|To|Ofc|UOM|Value|KIND||Cnt||Cnt|||Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd|cr_chk_flg|vnor_mn_itm_flg";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(headCount, 0, 0, true);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, false, true, false,false);
	        
	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle1, true);
	        InitHeadRow(1, HeadTitle2, true);
	        
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix + "chk",							false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vsl_cd",						true,		"",			dfEngUpKey,	0,			false,	true,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_voy_no",			true,		"",			dfNone,			0,			false,	true,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_dir_cd",				true,		"",			dfEngUpKey,	0,			false,	true,1,true);			
			InitDataProperty(0, cnt++ , dtCombo,		120,			daCenter,	true,	prefix + "vnor_vsl_sts_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_fm_port_cd",		false,	"",			dfEngUpKey,	0,			true,		true,5);
			InitDataProperty(0, cnt++ , dtCombo,		110,		daCenter,	true,	prefix + "vnor_itm_cd",			true,	"",			dfNone,			0,			true,		true);			
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt",		true,		"",			dfDateYmd,	0,			false,	true);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt_hm",true,		"",			dfTimeHm,		0,			false,	true);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt",		true,		"",			dfDateYmd,	0,			false,	true);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt_hm",	true,		"",			dfTimeHm,		0,			false,	true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_ofc_cd",		false,	"",			dfEngUpKey,	0,			true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_ut_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_val",			false,	"",			dfFloat,			2,			true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_flet_add_cd",			false,	"",			dfNone,			0,			true,		true);
			
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_op_lnk",		false,	"",			dfNone,			0,			false,		false);		
			InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,	prefix + "atch_file_op_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_flet_lnk",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "atch_file_flet_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_op_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_flet_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_rmk",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_flet_rmk",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,			daCenter,	true,	prefix + "upd_usr_id",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "upd_dt",					false,	"",			dfNone,			0,			false,		false);			
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "file_set_yn",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_seq",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_itm_seq",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_offh_knd_cd",	false,	"",			dfNone,			0,			true,		true);			
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "cr_chk_flg",	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_mn_itm_flg",	false,	"",			dfNone,			0,			true,		true);
			
			InitDataCombo(0, prefix + "vnor_vsl_sts_cd", "Berth|Entering & Leaving|Dock|Sailing", "BT|IO|LU|SL");			
			InitDataCombo(0, prefix + "vnor_itm_cd", " |Off-Hire Time(LT)|HFO (M/T)|MDO(M/T)|LSFO(M/T)|LSDO(M/T)|Port Charge|Terminal Charge|Others", " |OH|HF|MD|LF|LD|PC|TC|OT");
			InitDataCombo(0, prefix + "vnor_itm_ut_cd", "Hour|MT(Ton)|$(Dollar)", "H|T|D");
			InitDataCombo(0, prefix + "vnor_itm_flet_add_cd", "TC OUT|Manual|OPF", "T|M|O");
			
			InitDataValid(0, prefix + "vsl_cd", vtEngUpOnly);
			
			ShowButtonImage = 2;
		}
		break;
		
	case 2: 
		with (sheetObj) {
			var prefix = "sheet2_";
		
			// 높이 설정
	    	style.height = 382;
			SheetWidth = mainTable.clientWidth;
	
		 	// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
				
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
	
			var HeadTitle1 = "|Sel.|Vessel|Vessel|Vessel|Type|Place|Item|Period|Period|Period|Period|Ofc|UOM|Value|KIND|OPF File|OPF File|FMS File|FMS File|||Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd";
			var HeadTitle2 = "|Sel.|VSL|VOY|Dir|Type|Place|Item|From|From|To|To|Ofc|UOM|Value|KIND||Cnt||Cnt|||Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(headCount, 0, 0, true);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, false, true, false,false);
	        
	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle1, true);
	        InitHeadRow(1, HeadTitle2, true);
	        
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++ ,dtHiddenStatus,	30,		daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix + "chk",							false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vsl_cd",						true,		"",			dfEngUpKey,	0,			false,	false,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_voy_no",			true,		"",			dfNone,			0,			false,	false,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_dir_cd",				true,		"",			dfEngUpKey,	0,			false,	false,1,true);			
			InitDataProperty(0, cnt++ , dtCombo,		120,			daCenter,	true,	prefix + "vnor_vsl_sts_cd",		false,	"",			dfNone,			0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_fm_port_cd",		false,	"",			dfEngUpKey,	0,			false,	false,5);
			InitDataProperty(0, cnt++ , dtCombo,		110,			daCenter,	true,	prefix + "vnor_itm_cd",			false,	"",			dfNone,			0,			false,	false);			
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt",		true,		"",			dfDateYmd,	0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt_hm",true,		"",			dfTimeHm,		0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt",		true,		"",			dfDateYmd,	0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt_hm",	true,		"",			dfTimeHm,		0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_ofc_cd",		false,	"",			dfEngUpKey,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_ut_cd",		false,	"",			dfNone,			0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_val",			false,	"",			dfFloat,			2,			false,	false);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_flet_add_cd",			false,	"",			dfNone,			0,			false,	false);
						
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_op_lnk",		false,	"",			dfNone,			0,			false,		false);		
			InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,	prefix + "atch_file_op_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_flet_lnk",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "atch_file_flet_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_op_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_flet_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_rmk",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_flet_rmk",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,			daCenter,	true,	prefix + "upd_usr_id",				false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "upd_dt",					false,	"",			dfNone,			0,			false,		false);			
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "file_set_yn",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_seq",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_itm_seq",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_offh_knd_cd",	false,	"",			dfNone,			0,			true,		true);			
												
			//InitDataCombo(0, prefix + "vnor_vsl_sts_cd", "정박중|입출항중|입거중|항해중", "BT|IO|LU|SL");
			InitDataCombo(0, prefix + "vnor_vsl_sts_cd", "Berth|Entering & Leaving|Dock|Sailing", "BT|IO|LU|SL");
			InitDataCombo(0, prefix + "vnor_itm_cd", "Off-Hire Time(LT)|HFO (M/T)|MDO(M/T)|LSFO(M/T)|LSDO(M/T)|Port Charge|Terminal Charge|Others", "OH|HF|MD|LF|LD|PC|TC|OT");
			InitDataCombo(0, prefix + "vnor_itm_ut_cd", "Hour|MT(Ton)|$(Dollar)", "H|T|D");
			InitDataCombo(0, prefix + "vnor_itm_flet_add_cd", "TC OUT|Manual|OPF", "T|M|O");
			
			InitDataValid(0, prefix + "vsl_cd", vtEngUpOnly);
			
			ShowButtonImage = 2;						
		}
		break;		
			
	case 3: 
		with (sheetObj) {
			var prefix = "sheet3_";
		
			// 높이 설정
	    	style.height = 382;
			SheetWidth = mainTable.clientWidth;
	
		 	// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
	
			var HeadTitle1 = "|Sel.|Vessel|Vessel|Vessel|Type|Place|Item|Period|Period|Period|Period|Ofc|UOM|Value|KIND|OPF File|OPF File|FMS File|FMS File|||Ind|Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd|flet_ctrt_no|inv_seq";
			var HeadTitle2 = "|Sel.|VSL|VOY|Dir|Type|Place|Item|From|From|To|To|Ofc|UOM|Value|KIND||Cnt||Cnt|||Ind|Remark|Audit Comment|User|Date|File Set YN|vnorSeq|vnorItmSeq|vnor_offh_knd_cd|flet_ctrt_no|inv_seq";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(headCount, 0, 0, true);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(true, true, false, true, false,false);
	        
	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	        InitHeadRow(0, HeadTitle1, true);
	        InitHeadRow(1, HeadTitle2, true);
	        
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	prefix + "chk",							false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vsl_cd",						true,		"",			dfEngUpKey,	0,			false,	false,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_voy_no",			true,		"",			dfNone,		0,			false,	false,4,true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "skd_dir_cd",				true,		"",			dfEngUpKey,	0,			false,	false,1,true);			
			InitDataProperty(0, cnt++ , dtCombo,		120,			daCenter,	true,	prefix + "vnor_vsl_sts_cd",		false,	"",			dfNone,			0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_fm_port_cd",		false,	"",			dfEngUpKey,	0,			false,	false,5);
			InitDataProperty(0, cnt++ , dtCombo,		110,			daCenter,	true,	prefix + "vnor_itm_cd",			false,	"",			dfNone,			0,			false,	false);			
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt",		true,		"",			dfDateYmd,	0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_fm_dt_hm",true,		"",			dfTimeHm,		0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt",		true,		"",			dfDateYmd,	0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	prefix + "vnor_offh_to_dt_hm",	true,		"",			dfTimeHm,		0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_ofc_cd",		false,	"",			dfEngUpKey,	0,			false,	false);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_ut_cd",		false,	"",			dfNone,			0,			false,	true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "vnor_itm_val",			false,	"",			dfFloat,			2,			false,	false);
			InitDataProperty(0, cnt++ , dtCombo,		60,			daCenter,	true,	prefix + "vnor_itm_flet_add_cd",			false,	"",			dfNone,			0,			false,		false);
						
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_op_lnk",		false,	"",			dfNone,			0,			false,		false);		
			InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,	prefix + "atch_file_op_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	20,			daCenter,	true,	prefix + "atch_file_flet_lnk",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	prefix + "atch_file_flet_knt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_op_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "atch_file_flet_lnk_id",	false,	"",			dfNone,			0,			false,		false);
			
			InitDataProperty(0, cnt++ , dtData,		    100,			daCenter,	true,	prefix + "vnor_offh_ind",			false,	"",			dfNone,			0,			false,	false);			
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_rmk",			false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			180,			daLeft,	true,	prefix + "vnor_itm_flet_rmk",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,			daCenter,	true,	prefix + "upd_usr_id",				false,	"",			dfNone,			0,			false,	false);
			InitDataProperty(0, cnt++ , dtData,			100,			daCenter,	true,	prefix + "upd_dt",					false,	"",			dfNone,			0,			false,	false);			
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "file_set_yn",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_seq",				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_itm_seq",			false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "vnor_offh_knd_cd",	false,	"",			dfNone,			0,			true,		true);			
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "flet_ctrt_no",	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,				daCenter,	true,	prefix + "inv_seq",	false,	"",			dfNone,			0,			true,		true);

			//InitDataCombo(0, prefix + "vnor_vsl_sts_cd", "정박중|입출항중|입거중|항해중", "BT|IO|LU|SL");			
			InitDataCombo(0, prefix + "vnor_vsl_sts_cd", "Berth|Entering & Leaving|Dock|Sailing", "BT|IO|LU|SL");
			InitDataCombo(0, prefix + "vnor_itm_cd", "Off-Hire Time(LT)|HFO (M/T)|MDO(M/T)|LSFO(M/T)|LSDO(M/T)|Port Charge|Terminal Charge|Others", "OH|HF|MD|LF|LD|PC|TC|OT");
			InitDataCombo(0, prefix + "vnor_itm_ut_cd", "Hour|MT(Ton)|$(Dollar)", "H|T|D");
			InitDataCombo(0, prefix + "vnor_itm_flet_add_cd", "TC OUT|Manual|OPF", "T|M|O");		
			
			InitDataValid(0, prefix + "vsl_cd", vtEngUpOnly);
			
			ShowButtonImage = 2;
		}
		break;
		
	}
 }


//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
 	sheetObj.ShowDebugMsg = false;
 	
   var aryPrefix1 = new Array("sheet1_");	//prefix 문자열 배열
   var aryPrefix2 = new Array("sheet2_");	//prefix 문자열 배열
   var aryPrefix3 = new Array("sheet3_");	//prefix 문자열 배열
 	
 	switch (sAction) {
 		case IBSEARCH: // 조회부 기본 조회
 			formObj.f_cmd.value = SEARCH;			
 			 			
 			if(formObj.vnor_itm_proc_cd.value == "C"){				//CNFM
 				sheetObjects[0].DoSearch("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix1));
 			}else if(formObj.vnor_itm_proc_cd.value == "N"){	//Non Off-Hire
 				sheetObjects[1].DoSearch("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix2));
 			}else if(formObj.vnor_itm_proc_cd.value == "P"){ 	//Completed			
 				sheetObjects[2].DoSearch("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix3));
 			} 			 			
 			break;
 			
 		case 100:			// btn_ToNonConfirm1
 		    formObj.f_cmd.value = MULTI01;	
 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix1),-1,true);
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			break;
 			
 		case 101:  		// 	btn_Cnfm
 		    formObj.f_cmd.value = MULTI02;	
 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix2),-1,true);
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			break;

 		case 102:  		// 	btn_Complete
 			var selectRow = sheetObj.SelectRow;
 			if (sheetObj.CellValue(selectRow, "sheet2_"+"vnor_itm_flet_rmk") == "") {
 				ComShowCodeMessage("FMS00011", "Remark");
 				break;
 			}
 		    formObj.f_cmd.value = MULTI03;	
 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix2),-1,true);
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			break;

 		case 103:  		// btn_ToNonConfirm3
 			var selectRow = sheetObj.SelectRow;
 			var ind = sheetObj.CellValue(selectRow, "sheet3_"+"vnor_offh_ind");
 			if (sheetObj.CellValue(selectRow, "sheet3_"+"vnor_offh_ind") != "C/C") {
 				ComShowMessage(ind + " Data can not move!");
 				break;
 			}
 		    formObj.f_cmd.value = MULTI04;	
 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix3),-1,true);
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			break;

 		case 104:  		// btn_ToConfirm 	
 			var selectRow = sheetObj.SelectRow;
 			var ind = sheetObj.CellValue(selectRow, "sheet3_"+"vnor_offh_ind");
 			if (sheetObj.CellValue(selectRow, "sheet3_"+"vnor_offh_ind") != "C/C") {
 				ComShowMessage(ind + " Data can not move!");
 				break;
 			}
 		    formObj.f_cmd.value = MULTI05;	
 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix3),-1,true);
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			break;
 			
 		case 105:  		// btn_ExcelDown2 	
 			break;
 			
 		case 106:  		// btn_ExcelDown3 	
 			break;
 			
 		case 107: // Processing&Completed 탭만 조회 			
 			sheetObjects[2].RemoveAll();
 			
 			formObj.f_cmd.value = SEARCHLIST;
 			var aryPrefix = new Array("sheet3_");
 			var sXml = sheetObjects[0].GetSearchXml("ESM_FMS_0090GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
 						
 			sheetObjects[2].LoadSearchXml(sXml);	//Completed
 			
 			break; 			
 			
 		 case MULTI:		// btn_save
  		    formObj.f_cmd.value = MULTI;	

 			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix1),-1,true); 			
 			ComBtnEnable("btn_Detail1");
 			 break;
 		 case MULTI06:		// btn_save3
   		    formObj.f_cmd.value = MULTI06;
  			sheetObj.DoSave("ESM_FMS_0090GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix3),-1,true); 			
  			 break;
  			 
		 case IBROWSEARCH:  		//Vessel Code 입력 후 Name정보 가져오기
			 		
    		if(formObj.vsl_cd.value == "") {
	    		formObj.vsl_eng_nm.value = "";
	    		return;
	    	}
	    	
    		sheetObj.WaitImageVisible = false;
    		
	    	formObj.f_cmd.value = SEARCH01;
	    	var aryPrefix = new Array("sheet3_");
   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
   			
   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
				formObj.vsl_eng_nm.value = vslEngNm;				
			} else {
				formObj.vsl_cd.value = "";
				formObj.vsl_eng_nm.value = "";
				ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
				return;
			}
   			
   			sheetObj.WaitImageVisible = true; 			
		   			
		   	break; 			
	 	case IBINSERT: //row add
	 		var newRow = sheetObj.DataInsert(-1);
	 		ComBtnDisable("btn_Detail1");
		 	break;		
		 	
	 	case IBDELETE: //row delete
	 		var prefix = "sheet1_";
 			if (sheetObj.RowCount == 0){
 				ComShowMessage(ComGetMsg("FMS01170")); //There is no data for delete.
 				return false;
 			}
 			
 			var del_flg = "Y";
 			var checkedRows = sheetObj.FindCheckedRow("sheet1_chk");
 			var arrRow = checkedRows.split("|");	
 			for (i = 0; i < arrRow.length-1; i++) {
 				if (sheetObj.CellValue(arrRow[i], prefix+"vnor_itm_flet_add_cd") == "O") {
 					del_flg = "N";
 				}
 			}
 			if (del_flg == "N") {
 				ComShowMessage("Can not delete OPF Submitted Data!");
 				break;
 			}
 			
        	ComRowHideDelete(sheetObj, prefix+"chk");	         	
	 		break;	 	
	 }
}
 

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;

}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++ , "Confirm" , -1 );
				InsertTab( cnt++ , "Non Confirm" , -1 );  
				InsertTab( cnt++ , "Processing & Completed" , -1 );
            }
         break;
     }
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
 
	switch (comboNo) {
	case 1:
		with (comboObj) {
		    InsertItem(0,"","");		
			InsertItem(1,"Saved","S");
			InsertItem(2,"Approval","A");
			InsertItem(3,"Non Approval","N");
			InsertItem(4,"C/C(Compulsory Confirm)","C");						
		}
		break;
	}
	
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
	
}

/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 data 조회한다.
*/
function tab1_OnClick(tabObj , nItem)
{	
	if ( nItem == 0 ) {	// Confirm		
		form.vnor_itm_proc_cd.value = "C";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
 	} else if ( nItem == 1 ) {		// Non Confirm
		form.vnor_itm_proc_cd.value = "N";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 	} else if ( nItem == 2 ) { 	// 	Processing & Completed
		form.vnor_itm_proc_cd.value = "P";
 	} 	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj, sAction) {
	var tabIdx = tabObjects[0].SelectedIndex;

	switch(sAction) {
		case SEARCH:
		
			break;
		case MULTI :
		case MULTI06 :
			// vnor_itm_flet_rmk : Audit Comment length check (200)
			var prefix   = (sAction==MULTI) ? "sheet1_" : "sheet3_";
			var sheetObj = (sAction==MULTI) ? sheetObjects[0] : sheetObjects[2];
			
			for(var i = 2; i < sheetObj.Rows; i++) {
				if(sheetObj.CellValue(i, prefix + "vnor_itm_flet_rmk").length > 200) {
					ComShowCodeMessage('COM12173', '[Audit Comment]', '200');
					sheetObj.SelectCell(i, prefix + "vnor_itm_flet_rmk");
					return false;
				}
			}
			break;
			
		case COMMAND04 : //CNFM 또는 Processing&Completed 탭에서 detail 버튼 클릭시
		case COMMAND07 :	
			var prefix   = (sAction==COMMAND04) ? "sheet1_" : "sheet3_";
			var sheetObj = (sAction==COMMAND04) ? sheetObjects[0] : sheetObjects[2];
			
			var checkedRows = sheetObj.FindCheckedRow(prefix+"chk") ;
			if(checkedRows == "") {
				 ComShowMessage(ComGetMsg('COM12114',"one at least."));
				 return false;
			}	
			
			var diff = false;
			var arrRow = checkedRows.split("|");
			if((arrRow.length-1) > 1) { //2개 행 이상 선택했을 시, 1개는 그냥 통과
				for(i=0; i<(arrRow.length-1); i++) {
					for(j=i+1; j<(arrRow.length-1); j++) {
						if(!(sheetObj.CellValue(arrRow[i], prefix+"vsl_cd")==sheetObj.CellValue(arrRow[j], prefix+"vsl_cd") && 
								sheetObj.CellValue(arrRow[i], prefix+"vnor_offh_fm_dt")==sheetObj.CellValue(arrRow[j], prefix+"vnor_offh_fm_dt") &&
								sheetObj.CellValue(arrRow[i], prefix+"vnor_offh_fm_dt_hm")==sheetObj.CellValue(arrRow[j], prefix+"vnor_offh_fm_dt_hm") &&
								sheetObj.CellValue(arrRow[i], prefix+"vnor_offh_to_dt")==sheetObj.CellValue(arrRow[j], prefix+"vnor_offh_to_dt") &&
								sheetObj.CellValue(arrRow[i], prefix+"vnor_offh_to_dt_hm")==sheetObj.CellValue(arrRow[j], prefix+"vnor_offh_to_dt_hm")
						)) { //vsl_cd, period 가 다른 경우
							diff = true;
						}
						
					}
				}
			} 
			
			if(diff == true) {
				ComShowMessage(ComGetMsg('COM12114', 'for same data each other.'));
				return false;			
			}
			
			break;
	}
	
	return true;
}
 
 /**
  * t1Sheet1 OnClick 이벤트 처리  
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */ 
 function t1sheet1_OnClick(sheetObj, Row, Col, Value) 
 { 
 	var prefix = "sheet1_"; 
 	var colName = sheetObj.ColSaveName(Col);
 	 	 	
	if(sheetObj.CellValue(Row,prefix+"vnor_seq") == ''){
		return;
	} 	
 	
 	if(colName == prefix+"atch_file_op_lnk"){ 
 		fileUploadPopUp(sheetObj, Row, prefix);
 	}else if(colName == prefix+"atch_file_flet_lnk"){
 		fmsFileUploadPopUp(sheetObj, Row, prefix, "Y"); 		 		 		
 	}
 } 
 
 /**
  * File Upload 팝업 오픈
  */
 function fileUploadPopUp(sheetObj, Row, prefix) {	 
 	var formObj = document.form;
 	var atch_file_lnk_id = "";
 	var sParam = "vsl_cd=" + sheetObj.CellValue(Row, prefix+"vsl_cd");
 	sParam += "&vnor_seq=" + sheetObj.CellValue(Row, prefix+"vnor_seq");
 	sParam += "&vnor_itm_seq=" + sheetObj.CellValue(Row, prefix+"vnor_itm_seq");
 	sParam += "&is_upload_possible=N";
	sParam += "&atch_file_lnk_id=" + sheetObj.CellValue(Row, prefix+"atch_file_op_lnk_id"); 	
 	var fileCount = ComOpenPopupWithTarget('/hanjin/VOP_OPF_0072.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
 } 

 
 /**
  * FMS File Upload 팝업 오픈
  */
 function fmsFileUploadPopUp(sheetObj, Row, prefix, edit_able) {
	 	var atch_file_flet_lnk_id =  '';
	 	var vsl_cd = '';
	 	var vnor_seq = '';
	 	var vnor_itm_seq = '';	 
	 
		atch_file_flet_lnk_id =  sheetObj.CellValue(Row, prefix+"atch_file_flet_lnk_id");
 		vsl_cd =  sheetObj.CellValue(Row,prefix+"vsl_cd");
 		vnor_seq =  sheetObj.CellValue(Row,prefix+"vnor_seq");
 		vnor_itm_seq =  sheetObj.CellValue(Row,prefix+"vnor_itm_seq"); 		
 		
 		if (atch_file_flet_lnk_id == undefined || atch_file_flet_lnk_id == null || ComTrim(atch_file_flet_lnk_id) == ''){
 			atch_file_flet_lnk_id = '';
 		}
 		if (vsl_cd == undefined || vsl_cd == null || ComTrim(vsl_cd) == ''){
 			vsl_cd = '';
 		}
 		if (vnor_seq == undefined || vnor_seq == null || ComTrim(vnor_seq) == ''){
 			vnor_seq = '';
 		}
 		if (vnor_itm_seq == undefined || vnor_itm_seq == null || ComTrim(vnor_itm_seq) == ''){
 			vnor_itm_seq = '';
 		}
 		 		
 		var param = "?atch_file_flet_lnk_id="+atch_file_flet_lnk_id+
 						 "&vsl_cd="+vsl_cd+
 						 "&vnor_seq="+vnor_seq+
 						 "&vnor_itm_seq="+vnor_itm_seq+
 						 "&edit_able="+edit_able+
 						 "&tab_gubun="+prefix+
 						 "&row="+Row
 						 ;					
 		ComOpenPopup("/hanjin/ESM_FMS_0092.do"+param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
 }
 
 
 
 /**
  * t2Sheet1 OnClick 이벤트 처리  
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */ 
 function t2sheet1_OnClick(sheetObj, Row, Col, Value) 
 { 
 	var prefix = "sheet2_"; 
 	var colName = sheetObj.ColSaveName(Col);
 	 	 	
	if(sheetObj.CellValue(Row,prefix+"vnor_seq") == ''){
		return;
	} 	
 	
 	if(colName == prefix+"atch_file_op_lnk"){ 
 		fileUploadPopUp(sheetObj, Row, prefix);
 	}else if(colName == prefix+"atch_file_flet_lnk"){
 		fmsFileUploadPopUp(sheetObj, Row, prefix, "N"); 		 		 		
 	}
 } 
 
 /**
  * t3Sheet1 OnClick 이벤트 처리  
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  * @return
  */ 
 function t3sheet1_OnClick(sheetObj, Row, Col, Value) 
 { 
	 	var prefix = "sheet3_"; 
	 	var colName = sheetObj.ColSaveName(Col);
	 	 	 		 		 	
		if(sheetObj.CellValue(Row,prefix+"vnor_seq") == ''){
			return;
		} 	
	 		 	
	 	if(colName == prefix+"atch_file_op_lnk"){ 
	 		fileUploadPopUp(sheetObj, Row, prefix);
	 	}else if(colName == prefix+"atch_file_flet_lnk"){
	 		fmsFileUploadPopUp(sheetObj, Row, prefix, "N"); 		 		 		
	 	}
 } 
 
 /**
  * FileUpload 호출 뒤에 발생  
  */
 function popupFinish(){
 }
  
/**
  * Vessel Code 입력부분.<br>
  * @param {arry} aryPopupData
  */
function setVslCd(aryPopupData){
	form.vsl_cd.value = aryPopupData[0][2];
	form.vsl_eng_nm.value = aryPopupData[0][3];
}

/**
* t1Sheet1 의 Change 이벤트를 정의한다.
* @param SheetObj
* @param Row
* @param Col
* @param Value
*/
function t1sheet1_OnChange(sheetObj, Row, Col, Value){
	var prefix = "sheet1_"; 
	var colName = sheetObj.ColSaveName(Col);
		
	if(colName == prefix+"chk") { //체크박스 체크시 vessel 과 기간이 동일한 행들 자동체크	
		if(sheetObj.CellValue(Row,prefix+"chk") == 1) {
			 for(var i=sheetObj.HeaderRows; i<sheetObj.Rows; i++) {
				 if(sheetObj.CellValue(i,prefix+"vsl_cd") == sheetObj.CellValue(Row,prefix+"vsl_cd") &&
						 sheetObj.CellValue(i,prefix+"vnor_offh_fm_dt") == sheetObj.CellValue(Row,prefix+"vnor_offh_fm_dt") &&
						 sheetObj.CellValue(i,prefix+"vnor_offh_fm_dt_hm") == sheetObj.CellValue(Row,prefix+"vnor_offh_fm_dt_hm") &&
						 sheetObj.CellValue(i,prefix+"vnor_offh_to_dt") == sheetObj.CellValue(Row,prefix+"vnor_offh_to_dt") &&
						 sheetObj.CellValue(i,prefix+"vnor_offh_to_dt_hm") == sheetObj.CellValue(Row,prefix+"vnor_offh_to_dt_hm") ) 
				 {    
					 sheetObj.CellValue2(i,prefix+"chk") = 1;
				 }
				 
			 }
		 }	 
	 } else {
		// Sheet 변경 사항이 발생하면 Detail 버튼을 비활성화 시킨다.
		 ComBtnDisable("btn_Detail1");
		 
		 if (colName == prefix+"vnor_itm_cd") {
			var cellValue = sheetObj.CellValue(Row, Col);
			if (cellValue == "OH") {
				sheetObj.CellValue2(Row, prefix+"vnor_mn_itm_flg") = "Y";
			} else {
				sheetObj.CellValue2(Row, prefix+"vnor_mn_itm_flg") = "N";
			}
		 }
	 }
}

function openDetailPopup(sAction) {
	
	switch(sAction) {
		case COMMAND04:
		case COMMAND07:
			var prefix   = (sAction==COMMAND04) ? "sheet1_" : "sheet3_";
			var sheetObj = (sAction==COMMAND04) ? sheetObjects[0] : sheetObjects[2];			
			
			var checkedRows = sheetObj.FindCheckedRow(prefix+"chk") ;
			var arrRow = checkedRows.split("|");
//			var params = "pgmNo=ESM_FMS_0091&vsl_cd="+sheetObj.CellValue(arrRow[0],prefix+"vsl_cd")+"&offh_fm_dt="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_fm_dt")+"&offh_fm_dt_hm="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_fm_dt_hm")+"&offh_to_dt="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_to_dt")+"&offh_to_dt_hm="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_to_dt_hm");
			
			if (prefix == "sheet3_" && sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_ind") == "C/C") {
				ComShowMessage("C/C Data can not open detail!");
				break;
			}
			
			var params = "pgmNo=ESM_FMS_0091&vsl_cd="+sheetObj.CellValue(arrRow[0],prefix+"vsl_cd")+
																   "&offh_fm_dt="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_fm_dt")+
																   "&offh_fm_dt_hm="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_fm_dt_hm")+
																   "&offh_to_dt="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_to_dt")+
																   "&offh_to_dt_hm="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_to_dt_hm")+
																   "&vnor_offh_knd_cd="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_knd_cd")+
																   "&cr_chk_flg="+sheetObj.CellValue(arrRow[0],prefix+"cr_chk_flg")+
																   "&vnor_offh_ind="+sheetObj.CellValue(arrRow[0],prefix+"vnor_offh_ind");
			
			if (prefix == "sheet3_") {
				params = params + "&flet_ctrt_no="+sheetObj.CellValue(arrRow[0],prefix+"flet_ctrt_no");
				params = params + "&sheet_no=sheet3";
				params = params + "&inv_seq="+sheetObj.CellValue(arrRow[0],prefix+"inv_seq");
			} else if (prefix == "sheet1_") {
				params = params + "&sheet_no=sheet1";
			}
			
			ComOpenPopup("ESM_FMS_0091.do?"+params, 1035, 690, '',"0,0", true, false, false, 0, 0, "","yes");				 
			break;		
	}	
}


/**
 * DoSearch로 조회 완료후 발생하는 이벤트 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	ErrMsg    	Error메세지
 **/
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var prefix = "sheet1_";	
	if (sheetObj.SearchRows <=0) return;
	
	for (var ir=1; ir<=sheetObj.LastRow; ir++){
		if(sheetObj.CellValue(ir, prefix+"vnor_itm_flet_add_cd") == "O") {			
			sheetObj.CellEditable(ir, prefix+"vnor_vsl_sts_cd") = false;
			sheetObj.CellEditable(ir, prefix+"vnor_fm_port_cd") = false;			
			sheetObj.CellEditable(ir, prefix+"vnor_itm_cd") = false;
			sheetObj.CellEditable(ir, prefix+"vnor_itm_ofc_cd") = false;			
			sheetObj.CellEditable(ir, prefix+"vnor_itm_ut_cd") = false;
			sheetObj.CellEditable(ir, prefix+"vnor_itm_val") = false;			
			sheetObj.CellEditable(ir, prefix+"vnor_itm_flet_add_cd") = false;
			sheetObj.CellEditable(ir, prefix+"vnor_itm_rmk") = false;						
		}				
	}
}

//Ind 선택시
function dmdt_ctrt_expt_tp_cd_OnChange(comboObj, Code, text){
	form.vnor_offh_ind.value = Code;
}

function afterDetailSave() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/* 개발자 작업 끝 */