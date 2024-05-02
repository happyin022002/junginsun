/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0515.js
*@FileTitle : Optimized Distance Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
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
 * @class VOP_VSK_0515 : VOP_VSK_0515 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0515() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initCombo   = initCombo;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;


var uploadObjects = new Array();
var uploadCnt = 0;

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

		case "btn_fm_port_cd":
			sUrl = "/hanjin/VOP_VSK_0043.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
			if (rVal) {
				formObject.fm_port_cd.value = rVal;
			}
			break;
			
		case "btn_to_port_cd":
			sUrl = "/hanjin/VOP_VSK_0043.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
			if (rVal) {
				formObject.to_port_cd.value = rVal;
			}
			break;

		case "btn_period":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fm_date, formObject.to_date, 'yyyy-MM-dd');
			break;
		
		case "btn_RowAdd":
			formObject.to_yd_grp_cd.RemoveAll();
			formObject.to_port_cd.value = "";
			
			// 조회 결과값이 없을 때, Sheet내용을 삭제하고 RowAdd 
			if(sheetObjects[0].CellValue(2, "sheet_fm_port_cd") == ""){
				sheetObjects[0].RemoveAll();
			}
			
			var row = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue2(row, "sheet_fm_port_cd") = formObject.fm_port_cd.value;
			sheetObjects[0].CellValue2(row, "sheet_fm_yd_grp_cd") = formObject.fm_yd_grp_cd.Text;
			sheetObjects[0].CellText(row, "delt_flg") = "N";
			sheetObjects[0].SelectCell(row, "sheet_to_port_cd", false);
			break;
		
		case "btn_RowDelete":
			ComRowHideDelete(sheetObjects[0],"del_chk");
			break;
		
		case "btn_DownExcel":
			sheetObjects[0].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
			break;
			
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
//		case "btn_Retrieve2":
//			doActionIBSheet(sheetObject, formObject, MULTI01);
//			break;
			
		case "btn_YdGroup":
			ComOpenWindowCenter("/hanjin/VOP_VSK_9515.do?" + "port_cd=" + formObject.fm_port_cd.value, "VOP_VSK_9515", 600, 520, false, "yes");	
			break;
			
		case "btn_SlipCalc":
			doActionIBSheet(sheetObject, formObject, SEARCH03);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_New":
			formObject.reset();
			sheetObject.RemoveAll();
			formObject.fm_yd_grp_cd.RemoveAll();
			formObject.to_yd_grp_cd.RemoveAll();
			formObject.fm_date.value = ComGetDateAdd(null, "M", -1);
			formObject.to_date.value = ComGetNowInfo();
			formObject.fm_yd_grp_cd.Enable = true;
			ComBtnDisable("btn_RowAdd");
			break;
			
		case "rdo_tran":
			doActionIBSheet(sheetObject, formObject, COMMAND12);
			break;
			
		case "btns_search1":
			if(!document.getElementById(srcName).disabled){
				var sUrl = "/hanjin/VOP_VSK_0202.do?intg_cd_id=CD00717";
				var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "", "0,0", true);
				if(rVal){
					formObject.vsl_slan_cd.value = rVal;
				}
			}
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(uploadObj) {
	uploadObj.AutoConfirm = "UP_OVERWRITE_YES DELETE_YES";
	uploadObjects[uploadCnt++] = uploadObj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
    
    //UPLOAD 환경 설정
    for(var i=0;i<uploadObjects.length;i++){
	    //1. 기본 환경 설정
	    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_VSK_0515GS.do");
	}
    
	

	initControl();
	
	document.form.fm_date.value = ComGetDateAdd(null, "M", -1);
    document.form.to_date.value = ComGetNowInfo();
    document.form.fm_port_cd.focus();
    ComBtnDisable("btn_RowAdd");
    
    var formObj = document.form;
    
	formObj.fm_port_cd.className = "input1";
	//formObj.to_port_cd.className = "input1";
	formObj.fm_port_cd.readOnly = false;
	formObj.to_port_cd.readOnly = false;
	//formObj.fm_date.className = "input1";
	//formObj.to_date.className = "input1";
	formObj.fm_date.readOnly = false;
	formObj.to_date.readOnly = false; 
	
	//Using type, class
	formObj.fm_yd_grp_cd.Enable = "true";
	formObj.to_yd_grp_cd.Enable = "true";
	
	formObj.vsl_slan_cd.className = "input2";
	formObj.vsl_slan_cd.value = "";
	formObj.vsl_slan_cd.readOnly = true;
	
	ComEnableObject(document.all.btn_fm_port_cd, true);
	ComEnableObject(document.all.btn_to_port_cd, true);
	ComEnableObject(document.all.btns_search1, false);
	
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
	axon_event.addListenerForm('focus', 'obj_focus', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  form);
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);

}

/**
 * obj_deactivate
 * @param 
 * @return
 */
function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}

/**
 * obj_activate
 * @param 
 * @return
 */
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

/**
 * 화면 폼의 데이터 값에 커서를 두는 이벤트
 * @param 
 * @return
 */
function obj_blur(){
	var srcName = event.srcElement.name;
	
	switch(srcName){
		case "fm_date":
		case "to_date":
			ComChkObjValid(event.srcElement);
			break;
	}
}



/**
 * 화면 폼에 포커스를 주는 이벤트
 * @param 
 * @return
 */
function obj_focus(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/** 
 * Object 의 Keypress 이벤트에 대한 처리  <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * @param  없음
 * @return 없음
 * @author 임예지
 * @version 2014.10.25
 */ 
function obj_keyup(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var obj = event.srcElement;
 	switch(event.srcElement.name) {
  	
		case "vsl_slan_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH09);
			}
			break;
	
 	}
} 

/**
 * 화면 폼의 데이터 값의 데이터 유형을 설정
 * @param 
 * @return
 */
function obj_keypress(){
	var formObj = document.form;
	switch (event.srcElement.name) {

	    case "fm_port_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	break;
	    	
	    case "to_port_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	break;
	    	
	    case "vsl_slan_cd":
	    	ComKeyOnlyAlphabet('uppernum');
	    	break;
			
	    case "fm_date":
	    	ComKeyOnlyNumber(formObj.fm_date);
			break;
			
	    case "to_date":
	    	ComKeyOnlyNumber(formObj.to_date);
			break;
	}
}

/**
 * 화면 폼의 데이터 값이 변경되면 발생하는 이벤트
 * @param 
 * @return
 */
function obj_change(){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
    var obj = event.srcElement;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
        
            case "fm_port_cd":
            	if(!isCheckfmPortCd(sheetObj, formObj)) return false;
            	formObj.port_cd.value = formObj.fm_port_cd.value;
            	doActionIBSheet(sheetObj, formObj, SEARCH02);
            	sheetObjects[0].RemoveAll();
            	formObj.to_port_cd.value = "";
            	formObj.to_yd_grp_cd.RemoveAll();
            	break;
            	
            case "to_port_cd":
            	if(!isChecktoPortCd(sheetObj, formObj)) return false;
            	formObj.port_cd.value = formObj.to_port_cd.value;
            	doActionIBSheet(sheetObj, formObj, SEARCH05);
            	break;
            	
            case "fm_date":
            	formObj.fm_date.value = ComGetMaskedValue(formObj.fm_date.value, "ymd");
            	break;
            	
            case "to_date":
            	formObj.to_date.value = ComGetMaskedValue(formObj.to_date.value, "ymd");
            	break;
            	
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 405;
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
			InitRowInfo(2, 1, 3, document.form.pagerows.value);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|Sel.|SEQ|Fm Port|YD|To Port|YD|Time Diff.\n(Hrs)|Distance|Distance|Distance|Distance|Distance|Range|Range|Slip|Slip|Slip|||||||UPD\nDate|UPD\nID|||||||";
			var HeadTitle2 = "|Sel.|SEQ|Fm Port|YD|To Port|YD|Time Diff.\n(Hrs)|ATLAS|OPT|OPT\nFile|VMS\n(AVG)|VMS\n(Short)|Min|Max|Slip\n(AVG)|Count|Variation|||||||UPD\nDate|UPD\nID|||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag",					false,	"",      	dfNone,			0,			true,		true);
            InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,	true,	"del_chk",					false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq");
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"sheet_fm_port_cd",  		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtComboEdit,	40,		daCenter,	true,	"sheet_fm_yd_grp_cd",  		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtPopupEdit,	70,		daCenter,	true,	"sheet_to_port_cd",			true,	"",			dfNone,			0,			true,		true, 		5);
			InitDataProperty(0, cnt++ , dtComboEdit,	40,		daCenter,	true,	"sheet_to_yd_grp_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"gmt_td_hrs",				false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,	"stnd_dist",				false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"opmz_dist",				true,	"",			dfFloat,		1,			true,		true, 		7);
            InitDataProperty(0, cnt++ , dtData,			80,     daLeft,	    true,   "file_nm", 	    		    false,     "",      dfNone,      0,     false,   false, 200);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"vms_avg_dist",				false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"vms_shtg_dist",			false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"rng_min_dist",				true,	"",			dfFloat,		1,			true,		true, 		7);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"rng_max_dist",				true,	"",			dfFloat,		1,			true,		true, 		7);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"avg_slp_rt",				false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"slp_knt",					false,	"",			dfFloat,		1,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"var_slp_rt",				false,	"",			dfFloat,		1,			false,		false);
            
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"delt_flg",  				false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"pre_sheet_fm_yd_grp_cd",  	false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"pre_sheet_to_yd_grp_cd",  	false,	"",			dfNone,			0,			true,		true);
			
            InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   true,   "file_set_yn",		        true,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	0,      daLeft,	    true,   "file_sav_id", 		    	true,     "",      dfNone,      0,     true,    true);
            
            InitDataProperty(0, cnt++ , dtHidden,		0,    	daCenter,   true,   "cre_usr_id", 	 		 	false,  "",      	dfNone,      0,     false,   false);
			InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"upd_dt",  					false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"upd_usr_id",  				false,	"",			dfNone,			0,			true,		true);
			
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_vsl_cd", 			false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_skd_voy_no", 		false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_skd_dir_cd", 		false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_pasg_pln_dt",		false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_dep_port_cd", 	false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_arr_port_cd", 	false,     "",      dfNone,      0,     true,    true);
            InitDataProperty(0, cnt++ , dtHidden,   	50,      daLeft,	true,   "vms_shtg_vps_eta_dt", 		false,     "",      dfNone,      0,     true,    true);


			
			InitDataValid(0, "sheet_to_port_cd", vtEngUpOther, "");
			FitColWidth();

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
    
    switch(comboObj.id) {
    	case "fm_yd_grp_cd":
    		with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("center");        
				SetColWidth("35");
				DropHeight = 100;
	    	}
    		break;
    		
    	case "to_yd_grp_cd":
    		with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("center");        
				SetColWidth("35");
				DropHeight = 100;
	    	}
    		break;
    		
    }
}

/**
 * Sheet관련 프로세스 처리
 * param : sheetObj, formObj, sAction, Row, Value
 */ 
function doActionIBSheet(sheetObj, formObj, sAction, Row, Value) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	var sheetID = sheetObj.id;
	
	switch (sAction) {
	
	case IBSEARCH: // 조회
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}
		break;
	
//	case MULTI01: // 조회
//		if(validateForm(sheetObj,formObj,sAction)){
//			ComOpenWait(true);
//			formObj.f_cmd.value = MULTI01;
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
//			ComOpenWait(false);
//		}
//		break;

	case SEARCH01: //Port Code Check
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
			return sXml;
		break;
		
	case SEARCH02: //From YD Group Code Check		
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
			setFromYdCdCombo(sXml);
		break;
		
	case SEARCH03: // Slip Calc.정보를 조회
		
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH03;
			
			var Cnt = sheetObj.RowCount;
			
			for(var i=2; i<= Cnt + 1; i++){
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj) + "&sheet_to_port_cd=" + sheetObj.CellValue(i, "sheet_to_port_cd"));
				sheetObj.CellValue2(i, "avg_slp_rt") = ComGetEtcData(sXml, "avg_slp_rt");
				sheetObj.CellValue2(i, "slp_knt") = ComGetEtcData(sXml, "slp_knt");
				sheetObj.CellValue2(i, "var_slp_rt") = ComGetEtcData(sXml, "var_slp_rt");
			}
			
		}
		ComOpenWait(false);
		break;
		
	case SEARCH04: // Sheet의 To Port를 입력하는 순간, 관련된 Distance 정보를 조회한다.
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH04;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj) + "&sheet_to_port_cd=" + Value);
			ComOpenWait(false);
			sheetObj.CellValue2(Row, "gmt_td_hrs") = ComGetEtcData(sXml, "gmt_td_hrs");
			sheetObj.CellValue2(Row, "stnd_dist") = ComGetEtcData(sXml, "stnd_dist");
			sheetObj.CellValue2(Row, "vms_avg_dist") = ComGetEtcData(sXml, "vms_avg_dist");
	 		sheetObj.CellValue2(Row, "vms_shtg_dist") = ComGetEtcData(sXml, "vms_shtg_dist");

		break;

	case SEARCH05: //To YD Group Code Check		
			formObj.f_cmd.value = SEARCH05;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
			setToYdCdCombo(sXml);
		break;
	
	case SEARCH06: //Sheet To YD Group Code Check		
			formObj.f_cmd.value = SEARCH06;
			formObj.port_cd.value = sheetObj.CellValue(Row, "sheet_to_port_cd");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
			var comboStr = ComXml2ComboString(sXml, "sheet_to_yd_grp_cd", "sheet_to_yd_grp_cd");
			if(comboStr == undefined){
				sheetObj.InitDataCombo(0, "sheet_to_yd_grp_cd", "", "", "");
			} else {
				sheetObj.InitDataCombo(0, "sheet_to_yd_grp_cd", "", "", "");
				sheetObj.CellComboItem(sheetObj.SelectRow, "sheet_to_yd_grp_cd", comboStr[0], comboStr[1], 0);
			}
		break;
		
	case SEARCH07: //Sheet_to_port Code Check
		formObj.f_cmd.value = SEARCH07;
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj) + "&sheet_to_port_cd=" + Value);
		return sXml;
		break;
		
	case SEARCH08: //Sheet From YD Group Code Check		
		formObj.f_cmd.value = SEARCH08;
		formObj.port_cd.value = sheetObj.CellValue(Row, "sheet_fm_port_cd");
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj));
		var comboStr = ComXml2ComboString(sXml, "sheet_fm_yd_grp_cd", "sheet_fm_yd_grp_cd");
		if(comboStr == undefined){
			sheetObj.InitDataCombo(0, "sheet_fm_yd_grp_cd", "", "", "");
		} else {
			sheetObj.InitDataCombo(0, "sheet_fm_yd_grp_cd", comboStr[0], comboStr[1], "");
			sheetObj.CellComboItem(sheetObj.SelectRow, "sheet_fm_yd_grp_cd", comboStr[0], comboStr[1], 0);
		}
		break;
	
	case SEARCH09: // Lane Code 조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH09;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", sParam);
			ComOpenWait(false);
			var vsl_slan_cd = ComGetEtcData(sXml, "vsl_slan_cd");
			
			
			if(vsl_slan_cd==null){
				ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
				formObj.vsl_slan_cd.value = "";
				formObj.vsl_slan_cd.focus();
			}
		break;

	case SEARCH10: // VMS(Short) target search
		if(sheetObj.CellValue(Row, "vms_shtg_dist") != 0){
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0515GS.do", FormQueryString(formObj) + "&sheet_fm_port_cd=" + sheetObj.CellValue(Row, "sheet_fm_port_cd") + "&sheet_to_port_cd=" + sheetObj.CellValue(Row, "sheet_to_port_cd") + "&vms_shtg_dist=" +sheetObj.CellValue(Row, "vms_shtg_dist"));
			ComOpenWait(false);
			sheetObj.CellValue2(Row, "vms_shtg_vsl_cd") = ComGetEtcData(sXml, "vms_shtg_vsl_cd");
			sheetObj.CellValue2(Row, "vms_shtg_skd_voy_no") = ComGetEtcData(sXml, "vms_shtg_skd_voy_no");
			sheetObj.CellValue2(Row, "vms_shtg_skd_dir_cd") = ComGetEtcData(sXml, "vms_shtg_skd_dir_cd");
	 		sheetObj.CellValue2(Row, "vms_shtg_pasg_pln_dt") = ComGetEtcData(sXml, "vms_shtg_pasg_pln_dt");
			sheetObj.CellValue2(Row, "vms_shtg_dep_port_cd") = ComGetEtcData(sXml, "vms_shtg_dep_port_cd");
	 		sheetObj.CellValue2(Row, "vms_shtg_arr_port_cd") = ComGetEtcData(sXml, "vms_shtg_arr_port_cd");
	 		sheetObj.CellValue2(Row, "vms_shtg_vps_eta_dt") = ComGetEtcData(sXml, "vms_shtg_vps_eta_dt");

		}else{
			ComShowCodeMessage('VSK00021', 'VMS Short data');
		}

	break;
		
	case IBSAVE:
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = MULTI;			
			var SaveStr = ComGetSaveString(sheetObj);
			if(SaveStr == undefined || SaveStr.length <= 0 ) return;

			var dataChangeFlag = false;
        	var Cnt = sheetObj.RowCount;	            	

        	for(var i=1; i<=Cnt + 1; i++){
			   //Insert & Delete 일 경우 서비스를 호출한다.
			   if(sheetObj.CellValue(i,"ibflag") == "I" || sheetObj.CellValue(i,"ibflag") == "D" || sheetObj.CellValue(i,"ibflag") == "U"){
				   dataChangeFlag = true;
				   break;
			   }
			}
        	
        	if (!dataChangeFlag) {
        		ComShowCodeMessage("VSK02008");
        		return; //바뀐 데이터가 없을 경우 리턴한다.
        	}
        	
			//Delete처리를 위해 Save로직을 실행하기전에 첫번째 행을 선택해 준다. 
			sheetObj.SelectCell(Row, "sheet_to_port_cd", false);
			
			ComOpenWait(true);
			
			//1.IBUpload에 파일 추가하기
			var upObj = uploadObjects[0];	
			upObj.Files="";					//먼저기존파일을 모두 지운후 추가함
			setFileUpload(sheetObj, upObj);	//Sheet의 추가 파일정보를 IBUpload로 Copy
			
			
			if (upObj.LocalFiles == "") {
				/*******파일이 없는 경우 IBSheet 이용하기********/
				
				//2.IBSheet 데이터 QueryString으로 묶기
				var sParam = ComGetSaveString(sheetObj);					
				if (sParam == "") return;
				
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj);
				
				ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
				
				//4. 서버에 request전달하고, reponse 받기
				var sXml = sheetObj.GetSaveXml("VOP_VSK_0515GS.do", SaveStr + "&" + FormQueryString(formObj));
			    ComOpenWait(false);
				if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
					sheetObj.LoadSaveXml(sXml);
					ComShowCodeMessage("VSK02009");
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
			
			} else {
				/*******파일이 있는 경우 IBUpload 이용하기********/

				//2.IBSheet 데이터 QueryString으로 묶기
				var sParam = ComGetSaveString(sheetObj, true);
				if (sParam == "") return;

				//3.Form 데이터 QueryString으로 묶기				
				sParam += "&" + FormQueryString(formObj);
				
				ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지
				
				//4. 서버에 request전달하고, reponse 받기
				upObj.ExtendParam = sParam;
				
				upObj.ParamDecoding = true;

				var sXml = upObj.DoUpload(true);
			}
			

			

			if (sXml.length > 0) sheetObj.LoadSaveXml(sXml);
			
			ComOpenWait(false);
			
			

		}
		break;
		
	case COMMAND12:        	// Sheet Change(Coastal SKD/Recovery Plan)
		if(formObj.rdo_tran[0].checked){
			formObj.fm_port_cd.className = "input1";
    		formObj.to_port_cd.className = "input";
    		formObj.fm_port_cd.readOnly = false; 
    		formObj.to_port_cd.readOnly = false;
    		
    		//Using type, class
    		formObj.fm_yd_grp_cd.Enable = "true";
    		formObj.to_yd_grp_cd.Enable = "true";
    		
    		formObj.vsl_slan_cd.className = "input2";
    		formObj.vsl_slan_cd.value = "";
    		formObj.vsl_slan_cd.readOnly = true;
    		
    		ComEnableObject(document.all.btn_fm_port_cd, true);
    		ComEnableObject(document.all.btn_to_port_cd, true);
    		ComEnableObject(document.all.btns_search1, false);
    		
    		//
			
		} else {
			//ComShowCodeMessage('VSK57022');
			//formObj.rdo_tran[0].checked = 'true';
			//break;
			formObj.fm_port_cd.className = "input2";
    		formObj.to_port_cd.className = "input2";
    		formObj.fm_port_cd.value = "";
    		formObj.to_port_cd.value = "";
    		formObj.fm_port_cd.readOnly = true;
    		formObj.to_port_cd.readOnly = true;
//    		formObj.fm_date.className = "input2";
//    		formObj.to_date.className = "input2";
//    		formObj.fm_date.value = "";
//    		formObj.to_date.value = "";
//    		formObj.fm_date.readOnly = true;
//    		formObj.to_date.readOnly = true; 
    		
    		//Using type, class
    		formObj.fm_yd_grp_cd.Enable = "false";
    		formObj.fm_yd_grp_cd.Text = "";
    		formObj.to_yd_grp_cd.Enable = "false";
    		formObj.to_yd_grp_cd.Text = "";
    		
    		formObj.vsl_slan_cd.className = "input1";
    		formObj.vsl_slan_cd.readOnly = false;
    		
    		ComEnableObject(document.all.btn_fm_port_cd, false);
    		ComEnableObject(document.all.btn_to_port_cd, false);
    		ComEnableObject(document.all.btns_search1, true);

		}
		
		break;
	
	}
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj,formObj,sAction
 * @return true
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

		case IBSEARCH:
			// from port의 값이 null일경우 체크
			if(formObj.rdo_tran[0].checked){
				if(formObj.fm_port_cd.value==""){
					ComShowCodeMessage('VSK00027', 'Port');
					formObj.fm_port_cd.focus();
					return false;
				}
			}
			
			// from port의 값이 MDM에 존재하기 않을경우 체크
			if(formObj.rdo_tran[0].checked){
				var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
				var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
				if(chkPort != "X"){
					formObj.fm_port_cd.value = "";
					ComShowCodeMessage("VSK00029", formObj.fm_port_cd.value);
					formObj.fm_port_cd.focus();
					formObj.fm_yd_grp_cd.RemoveAll();
					return false;
				}
			}
			
			// fm_dt to_dt보다 앞선일자가 아니면 오류
			if(!checkPeriod(formObj.fm_date, formObj.to_date)){
				ComShowCodeMessage("VSK00025", "End date", "start date");
				formObj.to_date.focus();
				return false;
			}
			break;
			
		case SEARCH03:
			if(formObj.fm_date.value=="" || formObj.to_date.value==""){
				ComShowCodeMessage('VSK01017', 'Period');
				formObj.fm_date.focus();
				return false;
			}
			
			break;
			
		case IBSAVE:
			
			// Duplication Check
			var Cnt = sheetObj.RowCount;
        	for(var i=2; i<=Cnt+2; i++){
        		for(var j=i+1; j<=Cnt+1; j++){
        			if(sheetObj.CellValue(i,"sheet_fm_port_cd")+sheetObj.CellValue(i,"sheet_fm_yd_grp_cd") + sheetObj.CellValue(i,"sheet_to_port_cd") + sheetObj.CellValue(i,"sheet_fm_port_cd")+sheetObj.CellValue(i,"sheet_to_yd_grp_cd") == sheetObj.CellValue(i,"sheet_fm_yd_grp_cd") + sheetObj.CellValue(j,"sheet_to_port_cd") + sheetObj.CellValue(j,"sheet_to_yd_grp_cd")){
        				ComShowCodeMessage("VSK00002", "To Port & YD");
        				sheetObj.SelectCell(j,"sheet_to_yd_grp_cd", false)
        				return false;
        			}	
        		}
			}

        	// Min_Range > Max_Range Check
        	for(var i=Cnt+1; i>=1; i--){   			
    			if(sheetObj.CellValue(i,"ibflag") == "U" || sheetObj.CellValue(i,"ibflag") == "I"){
        			if(sheetObj.CellValue(i,"rng_min_dist") > sheetObj.CellValue(i,"rng_max_dist")){
        				ComShowCodeMessage("VSK02010", "To Port & YD");
        				sheetObj.SelectCell(i,"rng_min_dist", false)
        				return false;
        			}
    			}
        	}
        	
        	//1.Save시 From and To yard port validation
        	for(var i=1; i<=Cnt+1; i++){
    	 		if(sheetObj.CellValue(i, "sheet_to_port_cd") == sheetObj.CellValue(i, "sheet_fm_port_cd")){
    	 			//2.From Yard Group code는 All이 될수 없음
    	 			if(sheetObj.CellValue(i, "sheet_fm_yd_grp_cd") == "All"){
    	 				if(sheetObj.CellValue(i, "sheet_to_yd_grp_cd") != ""){
    	 					ComShowCodeMessage("VSK02012");
    	 					sheetObj.CellValue(i, "sheet_to_yd_grp_cd") = "";
    	 					sheetObj.CellValue(i, "sheet_fm_yd_grp_cd") = "";
    			 			return false;
    	 				}
    	 			}
    	 			
    	 			//2.From and To Yard Group code는 동일할 수 없음
    	 			if(sheetObj.CellValue(i, "sheet_to_yd_grp_cd")!="All" && sheetObj.CellValue(i, "sheet_fm_yd_grp_cd")!="All" && sheetObj.CellValue(i, "sheet_to_yd_grp_cd") == sheetObj.CellValue(i, "sheet_fm_yd_grp_cd")){
    	 				ComShowCodeMessage("VSK02011");
    	 				sheetObj.CellValue(i, "sheet_to_yd_grp_cd") = "";
    		 			return false;
    	 			}

    	 			//3.To Yard Group Code는 All이 될수 없음
    	 			if(sheetObj.CellValue(i, "sheet_fm_yd_grp_cd") != ""){
    	 				if(sheetObj.CellValue(i, "sheet_to_yd_grp_cd") == "All"){
    	 					ComShowCodeMessage("VSK02012");
    	 					sheetObj.CellValue(i, "sheet_to_yd_grp_cd") = "";
    			 			return false;
    	 				}
    	 			}
    	 		}
        	}
			break;

	}
	return true;
}

/**
 * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
 * @param {shtObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 */
function sheet1_OnChange(shtObj, Row, Col, Value) {
	var formObj = document.form;
	if (Value == "") return;
	switch (shtObj.ColSaveName(Col)) {
	
	 	case "sheet_to_port_cd" :   
	 		//1.MDM에 To Port Code가 존재하는지 확인한다.
	 		if(!isCheckSheetToPortCd(shtObj, formObj, Row, Value)) return false;
	 		
	 		if(formObj.fm_port_cd.value != Value){
		 		//2.To Port의 YD 코드를 조회한다.
		 		formObj.port_cd.value = Value;
		 		doActionIBSheet(shtObj, formObj, SEARCH06, Row);

		 		//3.Time Diff 및 Distance관련 데이터를 조회한다.
		 		doActionIBSheet(shtObj, formObj, SEARCH04, Row, Value);
		 		shtObj.FocusEditMode = -1;
	 		}
		 	
	 		if(shtObj.CellValue(Row, "sheet_to_port_cd") == shtObj.CellValue(Row, "sheet_fm_port_cd")){
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd") == shtObj.CellValue(Row, "sheet_fm_yd_grp_cd")){
	 				ComShowCodeMessage("VSK02007");
	 				shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
		 			return false;
	 			}
	 		}
            break;	
            
	 	case "sheet_fm_yd_grp_cd" : 
	 		if(shtObj.CellValue(Row, "sheet_to_port_cd") == shtObj.CellValue(Row, "sheet_fm_port_cd")){
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd")=="All" && shtObj.CellValue(Row, "sheet_fm_yd_grp_cd")=="All"){
	 				ComShowCodeMessage("VSK02012");
 					shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") = "";
 					shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
 					return false;
	 			}
	 			
	 			//2.From Yard Group code는 All이 될수 없음
	 			if(shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") == "All"){
 					ComShowCodeMessage("VSK02012");
 					shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") = "";
 					return false;
	 			}
	 			
	 			//2.From and To Yard Group code는 동일할 수 없음
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd") == shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") && shtObj.CellValue(Row, "sheet_to_yd_grp_cd")!="All" && shtObj.CellValue(Row, "sheet_fm_yd_grp_cd")!='All'){
	 				ComShowCodeMessage("VSK02011");
	 				shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") = "";
	 				shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
		 			return false;
	 			}
	 		}
	 		break;
	 		
	 	case "sheet_to_yd_grp_cd" :
	 		//1. From and To Port code가 동일할 경우 Yard Code에 대한 Validation : 돟일한 Yard Group code는 사용 불가
	 		if(shtObj.CellValue(Row, "sheet_to_port_cd") == shtObj.CellValue(Row, "sheet_fm_port_cd")){
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd")=="All" && shtObj.CellValue(Row, "sheet_fm_yd_grp_cd")=="All"){
	 				ComShowCodeMessage("VSK02012");
 					shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") = "";
 					shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
 					return false;
	 			}
	 			
	 			//2.From and To Yard Group code는 동일할 수 없음
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd") == shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") && shtObj.CellValue(Row, "sheet_to_yd_grp_cd")!="All" && shtObj.CellValue(Row, "sheet_fm_yd_grp_cd")!='All'){
	 				ComShowCodeMessage("VSK02011");
	 				shtObj.CellValue(Row, "sheet_fm_yd_grp_cd") = "";
	 				shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
		 			return false;
	 			}

	 			//3.To Yard Group Code는 All이 될수 없음
	 			if(shtObj.CellValue(Row, "sheet_to_yd_grp_cd") == "All"){
 					ComShowCodeMessage("VSK02012");
	 				shtObj.CellValue(Row, "sheet_to_yd_grp_cd") = "";
		 			return false;
	 			}
	 		}
	 		break;
	}
}	

/**
 * MDM에 From Port Code가 존재하는지 확인한다.
 * @param sheetObj, formObj
 */
function isCheckfmPortCd(sheetObj, formObj){
	if(formObj.fm_port_cd.value == null || formObj.fm_port_cd.value == undefined || formObj.fm_port_cd.value == "") return false;
	if(ComChkLen(formObj.fm_port_cd, 5) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
		if(chkPort != "X"){
			formObj.fm_port_cd.value = "";
			ComShowCodeMessage("VSK00029", formObj.fm_port_cd.value);
			formObj.fm_port_cd.focus();
			formObj.fm_yd_grp_cd.RemoveAll();
		}else{
			return true;
		}
	}else{
		ComShowCodeMessage("COM12114", "Port Code");
		formObj.fm_port_cd.value = "";
		formObj.fm_port_cd.focus();
		formObj.fm_yd_grp_cd.RemoveAll();
	}
}

/**
 * MDM에 To Port Code가 존재하는지 확인한다.
 * @param sheetObj, formObj
 */
function isChecktoPortCd(sheetObj, formObj){
	if(formObj.fm_port_cd.value==""){
		ComShowCodeMessage('VSK00027', 'Port');
		formObj.to_port_cd.value = "";
		formObj.fm_port_cd.focus();
		return false;
	}
	if(formObj.to_port_cd.value == null || formObj.to_port_cd.value == undefined || formObj.to_port_cd.value == "") return false;
	if(ComChkLen(formObj.to_port_cd, 5) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
		if(chkPort != "X"){
			ComShowCodeMessage("VSK00029", formObj.to_port_cd.value);
			formObj.to_port_cd.value = "";
			formObj.to_port_cd.focus();
			formObj.to_yd_grp_cd.RemoveAll();
		}else{
			return true;
		}
	}else{
		ComShowCodeMessage("COM12114", "Port Code");
		formObj.to_port_cd.value = "";
		formObj.to_port_cd.focus();
		formObj.to_yd_grp_cd.RemoveAll();
	}
}


/**
 * MDM에 Sheet To Port Code가 존재하는지 확인한다.
 * @param sheetObj, formObj, Row
 */
function isCheckSheetToPortCd(sheetObj, formObj, Row, Value){
	if(ComChkLen(sheetObj.CellValue(Row, "sheet_to_port_cd"), 5) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH07, "", Value);
		var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
		if(chkPort != "X"){
			ComShowCodeMessage("VSK00029", sheetObj.CellValue(Row, "sheet_to_port_cd"));
			sheetObj.CellValue(Row, "sheet_to_port_cd") = "";
		}else{
			return true;
		}
	}else{
		ComShowCodeMessage("COM12114", "Port Code");
		sheetObj.CellValue(Row, "sheet_to_port_cd") = "";
	}
}

/**
 * Period를 체크한다.
 * @param fromDate, toDate
 * @return true
 */
function checkPeriod(fromDate, toDate){
	var fmDt = ComReplaceStr(fromDate.value, "-", "");
	var toDt = ComReplaceStr(toDate.value, "-", "");
	
	if(ComChkPeriod(fmDt, toDt) < 1){
		return false;
	}else{
		return true;
	}
}

/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return null
 */
function getComboObject(comboId){
	var cnt = comboObjects.length;
	
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].id == comboId){
				return comboObjects[i];
			}
		}
	}
	return null;
}

/**
 * From Yard Code Combo를 Setting.
 * @param sXml
 */
function setFromYdCdCombo(sXml){
	var sheetObj = sheetObjects[0];
	var formObject = document.form;
	var fmYdGrpCd = ComGetEtcData(sXml, "fm_yd_grp_cd");

	if(fmYdGrpCd == ""){
		comboObjects[0].RemoveAll();
		formObject.fm_yd_grp_cd.Enable = false;
	} else {
		var fmYdGrpCdArr = fmYdGrpCd.split("|");
		formObject.fm_yd_grp_cd.Enable = true;
		appendMultiComboItem(getComboObject("fm_yd_grp_cd"), fmYdGrpCdArr, fmYdGrpCdArr, "");
	}

}

/**
 * To Yard Code Combo를 Setting.
 * @param sXml
 */
function setToYdCdCombo(sXml){
	var sheetObj = sheetObjects[0];
	var formObject = document.form;
	var toYdGrpCd = ComGetEtcData(sXml, "to_yd_grp_cd");
	
	if(toYdGrpCd == ""){
		comboObjects[1].RemoveAll();
		formObject.to_yd_grp_cd.Enable = false;
	} else {
		var toYdGrpCdArr = toYdGrpCd.split("|");
		formObject.to_yd_grp_cd.Enable = true;
		appendMultiComboItem(getComboObject("to_yd_grp_cd"), toYdGrpCdArr, toYdGrpCdArr, "");	
	}

}

/**
 * Mutil Combo에 item을 추가한다.
 * @param comboObj, optionCds, optionTxts, selCode
 */
function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
	
	comboObj.RemoveAll();
	
	for(var i=0; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionTxts[i], optionCds[i]);
	}
	
	comboObj.Index = 0;
}

/**
 * Row선택시, 해당 Row의 Updated Date 및 Updated UserId를 보여준다.
 * @param sheetObj, OldRow, OldCol, NewRow, NewCol
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){

	var formObj = document.form;
	document.form.upd_dt.value = sheetObj.CellValue(NewRow, "upd_dt");
	document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "upd_usr_id");
	
	
	//Sheet가 선택되면 From Port의 콤보를 조회한다.
	if(sheetObj.CellValue(NewRow, "sheet_fm_port_cd") != ""){
		if(NewCol == 4){
			doActionIBSheet(sheetObj, formObj, SEARCH08, NewRow);
		}
	}else{
			sheetObj.CellValue(NewRow, "sheet_fm_yd_grp_cd") = "";
			return false;
		}
	//Sheet가 선택되면  To Port의 콤보를 조회한다.
	if(sheetObj.CellValue(NewRow, "sheet_to_port_cd") != ""){
		if(NewCol == 6){
		doActionIBSheet(sheetObj, formObj, SEARCH06, NewRow);
		}
	}else{
		sheetObj.CellValue(NewRow, "sheet_to_yd_grp_cd") = "";
		return false;
	}
	
}

/**
 * Sheet에 있는 To Port 컬럼 클릭 시, 해당 팝업을 띄운다.
 * @param sheetObj, Row, Col
 */
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var sUrl = "/hanjin/VOP_VSK_0043.do";
	var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);

	if(rVal){
		sheetObj.CellValue(Row, "sheet_to_port_cd") = rVal;
	}
	
}

/**
 * 조회가 끝난 뒤 시트상에 발생하는 이벤트를 정의한다.
 * @param sheetObj, ErrMsg, formObj
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg, formObj){
	var formObj = document.form;
	ComBtnEnable("btn_RowAdd");
}

/**
 * From Port Code의 그룹의 값이 변경되면 Sheet의 내용을 삭제한다.
 * @param 
 */
function fm_yd_grp_cd_OnChange(){
	sheetObjects[0].RemoveAll();
}


//function sheet1_OnClick(sheetObj, Row, Col){
//	
//	var colSaveName = sheetObj.ColSaveName(Col);
//	
//	switch(colSaveName){
//	
//		case "vms_shtg_dist":
//			if(sheetObj.CellValue(Row, Col) == '0'){
//				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, "arr_rmk1"));
//				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
//				if(rVal || rVal==''){
//					sheetObj.CellValue2(Row, "arr_rmk1") = rVal;
//				}
//			}		
//			break;
//		
//	}
//	
//}


function sheet1_OnDblClick(sheetObj, row, col, value){
	var colSaveName = sheetObj.ColSaveName(col);
	var Value = sheetObj.CellValue(row, col);
	var formObj = document.form;
	//var textFileFlg = sheetObj.CellValue(row, "vms_shtg_dist");
	if(colSaveName == "vms_shtg_dist" && sheetObj.CellValue(row, "vms_shtg_dist") != 0){
		
		doActionIBSheet(sheetObj, formObj, SEARCH10, row, value);
		var sParam = "vsl_cd="+sheetObj.CellValue(row, "vms_shtg_vsl_cd") + "&skd_voy_no="+sheetObj.CellValue(row, "vms_shtg_skd_voy_no") + "&skd_dir_cd="+sheetObj.CellValue(row, "vms_shtg_skd_dir_cd")
						+ "&pasg_pln_dt="+sheetObj.CellValue(row, "vms_shtg_pasg_pln_dt") + "&dep_port_cd="+sheetObj.CellValue(row, "vms_shtg_dep_port_cd") + "&arr_port_cd="+sheetObj.CellValue(row, "vms_shtg_arr_port_cd")+ "&vps_eta_dt="+sheetObj.CellValue(row, "vms_shtg_vps_eta_dt");
		
//		alert(sParam);
		
		ComOpenPopup("VOP_VSK_9004.do?"+sParam, 900,570, "", "0,0", true);
	}else if(colSaveName == "vms_shtg_dist" && sheetObj.CellValue(row, "vms_shtg_dist") == 0 ){
		ComShowCodeMessage('VSK00021', 'VMS Short data');
	}
	
	//var textFileFlg2 = sheetObj.CellValue(row, "opmz_dist");
	if(colSaveName == "opmz_dist"){
		selectFile(sheetObj, false);			
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		//if(sheetObj.CellText(row, "file_nm") == "" 
		//	|| sheetObj.RowStatus(row) == "I" 
		//	|| sheetObj.CellValue(row, "file_set_yn") == "") {
		//  selectFile(sheetObj, false);
		//	return;
		//}
		return;
		//ComOpenPopup("VOP_VSK_9004.do?pageId=OPF0052&fmYdCd="+sheetObj.CellValue(sheetObj.SelectRow, "sheet_fm_port_cd")+"&fmYdGrpCd="+sheetObj.CellValue(sheetObj.SelectRow, "sheet_fm_yd_grp_cd")+"&toYdCd="+sheetObj.CellValue(sheetObj.SelectRow, "sheet_to_port_cd")+"&toYdGrpCd="+sheetObj.CellValue(sheetObj.SelectRow, "sheet_to_yd_grp_cd"), 505, 350, "setFileUpload", "none", false, "","","","","Damage_Creation");
		//ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=SDR&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", false, "","","","","Damage_Creation");
	}
	
	if(colSaveName == "file_nm"){
//		alert(sheetObj.CellText(row, "file_sav_id"));
		parent.location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(row, "file_sav_id");
		return;
	}

	
	return;
}




/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet}   sheetObj    IBSheet Object
 * @param {ibupload}  upObj    	  IBUpload Object
 **/
function setFileUpload(sheetObj, upObj) {	
	for (var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++){ 
		var fileSetYn = sheetObj.CellValue(rowIdx, "file_set_yn");
		//파일 경로 가져오기
		if(fileSetYn == 'Y') {
			var sFile = sheetObj.CellValue(rowIdx, "file_sav_id");		
			if (sFile=="") ComShowCodeMessage('VSK50003', 'Data');	//'{?msg1} is not available.'
			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
	}

	return; 
}

/**
 * 파일 선택하기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
 **/
function selectFile(sheetObj, addRowFlag){
	if(addRowFlag) {
		sheetObj.DataInsert(-1,0);								//File Add인 경우 New Row 생성
	} else {
	
		var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
		
		if(filePath.indexOf("\\") !=-1) {
			with(sheetObj) {
				CellValue2(SelectRow, "file_set_yn") = "Y";				//로컬파일 선택여부 설정
				CellValue2(SelectRow, "file_sav_id") = filePath;			//파일 로컬경로 설정
	
				fileName = filePath.substr(filePath.lastIndexOf("\\")+1);
				CellValue2(SelectRow, "file_nm")= fileName;			    //파일명 설정
				
				CellFontUnderline(SelectRow, "file_nm") = false;			//다운로드 링크 해제
			}
		}
	}
}


/* 개발자 작업 끝 */