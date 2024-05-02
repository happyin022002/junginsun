/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0005.js
 *@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.21 박희동
 * 1.0 Creation
 * ----------------------------------------------------------------------------------------
 * History
 * 2010.09.07 윤진영 CHM-201005741 JO-Target Voyage Creation 에서 Manual Settle 에 전체 선택 combo box 추가
 * 2010.10.21 이준범 [CHM-201006630-01] Unit Cost Basic Port 컬럼 삭제
 *            기존 Hidden으로 설정 된 컬럼에 대하여 DownExcel 시 보이지 않도록 옵션 변경
 * 2012.02.28 조병연 [CHM-20121640001][ALPS JOO] Account Month가 Closing된 후 Save 및 Delete 기능 비활성화 
 * - Account Month가 Closing된 이후에는 Data 생성 및 삭제 기능들이 비활성화되도록 Logic 추가
 * - 현재 AP Closing Time을 기준으로 하는것을 AR Closing Time으로 변경 (쿼리 변경)
 * - Save, Delete 버튼 비활성화
===========================================================================================*/
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
 * @class fns_joo_0005 : fns_joo_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0005() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//VVD Change시에 해당하는 port를 가져오기 위함
//gBasicPortCombo[Row][portInx][0] ==> Rev. Dir  
//gBasicPortCombo[Row][portInx][1] ==> delt_flg  
//gBasicPortCombo[Row][portInx][2] ==> Basic Ports  
//gBasicPortCombo[Row][portInx][3] ==> ETA  
//gBasicPortCombo[Row][portInx][4] ==> ETD  
var gBasicPortCombo;
//gPairPortCombo[Row][portInx][0] ==> Pair Ports  
//gPairPortCombo[Row][portInx][1] ==> ETA  
//gPairPortCombo[Row][portInx][2] ==> ETD  
var gPairPortCombo;
//gUnitPortCombo[Row][portInx][0] ==> UnitCost Ports  
//gUnitPortCombo[Row][portInx][1] ==> ETD  
var gUnitPortCombo;

//현재 row
var gCurRow;

//VVD
var gVVD;

var prefix="sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName == null || srcName == "re_divr_cd") {
			return;
		}
		
		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;

		case "btn_create":			
			doActionIBSheet(sheetObject1, formObj, IBCREATE);
			break;
			
		case "btn_new":
			sheetObjects[0].RemoveAll();
			formObj.jo_crr_cd.Index2 = -1;
			formObj.proc_jb_flg.checked =false;
			formObj.proc_jb_flg.value = "N";
			formObj.trd_cd.Index2    = -1;
			formObj.rlane_cd.Index2  = -1;
			formObj.re_divr_cd[0].checked = true;
			formObj.acct_yrmon.focus();
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_downexcel":
			sheetObject1.SpeedDown2Excel(0,false,false,"","",false,false,"", false, prefix+"del_chk"+"|"+prefix+"uc_bss_port_cd"+"|"+prefix+"acct_yrmon"+"|"+prefix+"stl_vvd_seq"+"|"+prefix+"trd_cd"+"|"+prefix+"jo_crr_cd"+"|"+prefix+"rlane_cd"+"|"+prefix+"jo_mnu_nm"+"|"+prefix+"re_divr_cd"+"|"+prefix+"jo_mnu_nm1"+"|"+prefix+"stl_tgt_vvd_bss_cd"+"|"+prefix+"rev_yrmon"+"|"+prefix+"pop_flg"+"|"+prefix+"rvs_flg"+"|"+prefix+"uc_bss_port_etd_dt","",false,"",false);
			break;

		case "btn_lskd":
			if (formObj.jo_crr_cd.index == -1){ 
				ComShowCodeMessage('JOO00008');
				return;
			}
			
			if (formObj.trd_cd.index    == -1){
				ComShowCodeMessage('JOO00009');
				return;
			}
			
			if (formObj.rlane_cd.index  == -1){
				ComShowCodeMessage('JOO00010');
				return;
			}

			UF_popLSKD();
			break;

		case "btn_copy":
			if (formObj.jo_crr_cd.index == -1){ 
				ComShowCodeMessage('JOO00008');
				return;
			}
			
			if (formObj.trd_cd.index == -1){
				ComShowCodeMessage('JOO00009');
				return;
			}
			
			if (formObj.rlane_cd.index == -1){
				ComShowCodeMessage('JOO00010');
				return;
			}
			
			UF_copyRow();
			break;

		case "btn_add":
			if (formObj.jo_crr_cd.index == -1){ 
				ComShowCodeMessage('JOO00008');
				return;
			}
			
			if (formObj.trd_cd.index    == -1){
				ComShowCodeMessage('JOO00009');
				return;
			}
			
			if (formObj.rlane_cd.index  == -1){
				ComShowCodeMessage('JOO00010');
				return;
			}
			
			UF_addRow();
			break;

		case "btn_del":
			JooRowHideDelete(sheetObject1, prefix+"del_chk");
			break;

		case "btns_back":
	    	sheetObjects[0].RemoveAll();
			if (formObj.acct_yrmon.value!=""){
				formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);
			}
			
			if (formObj.jo_crr_cd.Code.length == 3 
					&&  formObj.trd_cd.Code.length   == 3
					&&  formObj.rlane_cd.Code.length == 5){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}else{
				doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC05);
			}
			
			
			
			break;

		case "btns_next":
			sheetObjects[0].RemoveAll();
			if (formObj.acct_yrmon.value!=""){
				formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
			}

			if (formObj.jo_crr_cd.Code.length == 3 
					&&  formObj.trd_cd.Code.length   == 3
					&&  formObj.rlane_cd.Code.length == 5){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}else{
				doActionIBSheet(sheetObject1, formObj, IBSEARCH_ASYNC05);
			}
			break;
			
		case "proc_jb_flg":
			if (formObj.proc_jb_flg.checked){
				formObj.proc_jb_flg.value = "Y";
			}else{
				formObj.proc_jb_flg.value = "N";
			}
			
			sheetObjects[0].RemoveAll();
			break;

		//Adjust로 강제생성된 Target VVD를 삭제하기 위해 proc_jb_flg가 Y임에도 jo_stl_cfm_cd가  N인 것들을 삭제시킨다.
		case "btn_enable":
			var sheetObj = sheetObjects[0];
			var cnt = 0;

			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
				if (sheetObj.CellValue(i, prefix+"jo_stl_cfm_cd") == "N" && sheetObj.CellValue(i, prefix+"proc_jb_flg") == "Y"){
					cnt++;
				}
			}
			
			//삭제할 건수가 있으면 Delete버튼을 활성화 시킨다.
			if (cnt >0){
				JooSetBtnClass("C", false);
				JooSetBtnClass("U", false);
				JooSetBtnClass("D", true);
				sheetObj.Editable = true;
				
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
					if (sheetObj.CellValue(i, prefix+"jo_stl_cfm_cd") == "N" && sheetObj.CellValue(i, prefix+"proc_jb_flg") == "Y"){
						sheetObj.CellEditable(i, prefix+"stl_rmk") = false;
						sheetObj.CellEditable(i, prefix+"del_chk") = true;
					}else{
						sheetObj.RowEditable(i) = false;
					}
				}
			}
			break;

			//Adjust로 강제생성된 Target VVD를 삭제하기 위해 proc_jb_flg가 Y임에도 jo_stl_cfm_cd가  N인 것들을 삭제시킨다.
		case "btn_delete":
			doActionIBSheet(sheetObject1, formObj, IBDELETE);
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(crrCombo,abbrSheet,dirSheet) {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1, abbrSheet, dirSheet);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, crrCombo);
    }
    
    gBasicPortCombo = new Array(300);//max row를 300으로 가정    
    gPairPortCombo  = new Array(300);//max row를 300으로 가정
    gUnitPortCombo  = new Array(300);//max row를 300으로 가정
    
    initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  formObj);
    axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);

    axon_event.addListener('click', 'change_event_radio', 're_divr_cd');
    axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    
    formObj.acct_yrmon.focus();
}

/**
 * Form KeyUp
 * @return
 */
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

/**
 * OnBlur
 * @return
 */
function obj_deactivate(){
	var formObj = document.form;
    ComChkObjValid(event.srcElement);

    if (window.event.srcElement.getAttribute("name") == "acct_yrmon"){
    	var acctYrmon = ComReplaceStr(formObj.acct_yrmon.value,"-","");
    	
    	if (ComIsDay(acctYrmon.substring(0,4),acctYrmon.substring(4,6),"01")
    	&&  formObj.jo_crr_cd.Code.length == 3 
		&&  formObj.trd_cd.Code.length   == 3
		&&  formObj.rlane_cd.Code.length == 5){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}else if (ComIsDay(acctYrmon.substring(0,4),acctYrmon.substring(4,6),"01")){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
			
		}
    }
}

/**
 * OnFocus
 * @return
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	//var src = window.event.srcElement.getAttribute("name")
}

function obj_onclick(){
	//var src = window.event.srcElement.getAttribute("name")
}

function acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
}

function change_event_radio(){
	sheetObjects[0].RemoveAll();
//	var formObj = document.form;
//	if (formObj.acct_yrmon.value.length != 0
//	&&  formObj.jo_crr_cd.Code.length == 3 
//	&&  formObj.trd_cd.Code.length   == 3
//	&&  formObj.rlane_cd.Code.length == 5){
//		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param rlaneCd
 * @param skdDirCd
 * @return
 */
function UF_setPortCombo(sheetObj, Row, rlaneCd, skdDirCd){
	var portItems = "";
	for (var inx=0; inx < gBasicPortCombo.length; inx++){
		if ((rlaneCd == gBasicPortCombo[inx][0]) && (skdDirCd == gBasicPortCombo[inx][1])){
			portItems = portItems + gBasicPortCombo[inx][2] +"|";
		}
	}
	if (portItems.length > 0){
		portItems = portItems.substring(0,portItems.length-1);
	}
    sheetObj.CellComboItem(Row, prefix+"stl_bzc_port_cd" , portItems, portItems);
    sheetObj.CellComboItem(Row, prefix+"stl_pair_port_cd", portItems, portItems);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, abbrSheet, dirSheet) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 388;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "STS||VSL|VOY|Dir.|Fin.\nDir|Item|Manual\nSettle|Basic\nPort|Status|Status|Status|Status|Confirm|ETA|ETD|Basic\nPair Port|"+
			                "Pair Port ETA|Pair Port ETD|STL.\nSTS.|Unit Cost\nBasic Port|Unit Cost\nBasic Por ETD|Remark|"+
			                "h_acct_yrmon|h_stl_vvd_seq|h_trd_cd|h_jo_crr_cd|h_rlane_cd|h_jo_mnu_nm|re_divr_cd|jo_mnu_nm1|status|rev_yrmon|pop_flg|rvs_flg|pending_flg|remark";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus  ,  30, daCenter, false, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox,  30, daCenter, false, prefix+"del_chk");
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, false, prefix+"vsl_cd"              , false, "", dfNone, 0, false, true, 4);
			InitDataProperty(0, cnt++, dtData    ,  35, daCenter, false, prefix+"skd_voy_no"          , false, "", dfNone, 0, false, true, 4);
			InitDataProperty(0, cnt++, dtCombo   ,  35, daCenter, false, prefix+"skd_dir_cd"          , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, false, prefix+"rev_dir_cd"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo   ,  45, daCenter, false, prefix+"jo_stl_itm_cd"       , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCheckBox,  65, daCenter, false, prefix+"jo_mnl_cre_flg"      , false, "", dfNone, 0, true , true ,-1,false,true,"",true);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, false, prefix+"stl_bzc_port_cd"     , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCombo   ,  30, daCenter, false, prefix+"agmt_mon_cond_cd"    , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCombo   ,  30, daCenter, false, prefix+"agmt_port_cond_cd"   , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCombo   ,  30, daCenter, false, prefix+"agmt_port_tp_cond_cd", false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtCombo   ,  30, daCenter, false, prefix+"agmt_op_tp_cond_cd"  , false, "", dfNone, 0, false, true );
			
			InitDataProperty(0, cnt++, dtCombo   ,  55, daCenter, false, prefix+"jo_stl_cfm_cd"      , false, "", dfNone       , 0, true , true );
			InitDataProperty(0, cnt++, dtData    , 110, daCenter, false, prefix+"bzc_port_eta_dt"    , false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData    , 110, daCenter, false, prefix+"bzc_port_etd_dt"    , false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData    ,  60, daCenter, false, prefix+"stl_pair_port_cd"   , false, "", dfNone       , 0, false, true );
			InitDataProperty(0, cnt++, dtData    , 110, daCenter, false, prefix+"pair_port_eta_dt"   , false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData    , 110, daCenter, false, prefix+"pair_port_etd_dt"   , false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, false, prefix+"proc_jb_flg"        , false, "", dfNone       , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden  ,  80, daCenter, false, prefix+"uc_bss_port_cd"     , false, "", dfNone       , 0, true , true );
			InitDataProperty(0, cnt++, dtHidden  , 110, daCenter, false, prefix+"uc_bss_port_etd_dt" , false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData    ,  80, daLeft  , false, prefix+"stl_rmk"            , false, "", dfNone       , 0, true , true , 100);

			//hidden
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"acct_yrmon" , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"stl_vvd_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"trd_cd"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"jo_crr_cd"  , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"rlane_cd"   , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"jo_mnu_nm"  , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"re_divr_cd" , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"jo_mnu_nm1" , false, "", dfNone, 0, false, false); //OUS로 변경시 Basic Port에서 RDR/TDR인지 조회한다.
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"stl_tgt_vvd_bss_cd" , false, "", dfNone       , 0, false, true );
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"rev_yrmon"  , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"pop_flg"    , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"rvs_flg"    , false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"pending_flg", false, "", dfNone, 0, false, true );
			InitDataProperty(0, cnt++, dtHidden,0, daLeft, false, prefix+"remark", false, "", dfNone, 0, false, true );

			InitDataCombo(0, prefix+"jo_stl_cfm_cd"     , "YES|PENDING|NO", "Y|P|N");
			InitDataCombo(0, prefix+"skd_dir_cd"        , dirSheet , dirSheet );
			InitDataCombo(0, prefix+"jo_stl_itm_cd"     , abbrSheet, abbrSheet);
			//InitDataCombo(0, prefix+"stl_tgt_vvd_bss_cd", staSheet , staSheet );
			InitDataCombo(0, prefix+"agmt_mon_cond_cd"     , UF_getComboStringForSheet(gMnthCondSheet, gMnthNameSheet), gMnthCondSheet);
			InitDataCombo(0, prefix+"agmt_port_cond_cd"    , UF_getComboStringForSheet(gPortCondSheet, gPortNameSheet), gPortCondSheet);
			InitDataCombo(0, prefix+"agmt_port_tp_cond_cd" , UF_getComboStringForSheet(gPortTypeSheet, gPtTpNameSheet), gPortTypeSheet);
			InitDataCombo(0, prefix+"agmt_op_tp_cond_cd"   , UF_getComboStringForSheet(gOperTypeSheet, gOperNameSheet), gOperTypeSheet);

			InitDataValid(0, prefix+"vsl_cd"    , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"skd_voy_no", vtNumericOnly);//숫자만 올 수 있음
			InitDataValid(0, prefix+"stl_rmk"   , vtEngOther, gVtOther); //영문

			InitUserFormat2(0, prefix+"bzc_port_eta_dt" , "####-##-## ##:##:##", "-|:");
			InitUserFormat2(0, prefix+"bzc_port_etd_dt" , "####-##-## ##:##:##", "-|:");
			InitUserFormat2(0, prefix+"pair_port_eta_dt", "####-##-## ##:##:##", "-|:");
			InitUserFormat2(0, prefix+"pair_port_etd_dt", "####-##-## ##:##:##", "-|:");
			InitUserFormat2(0, prefix+"uc_bss_port_etd_dt", "####-##-## ##:##:##", "-|:");
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	formObj.acct_yrmon.value = formObj.acct_yrmon.value.replace("-",""); 
	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0005GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				if (ComGetEtcData(sXml,"clz_yn") == "C"){
					// 메세지 창(It was closed!!!) 제거
					// ComShowCodeMessage("JOO00177");
					JooSetBtnClass("C", false);
					JooSetBtnClass("U", false);
					sheetObjects[0].Editable = false;
					
				}else{
					JooSetBtnClass("C", true);
					JooSetBtnClass("U", true);
					sheetObjects[0].Editable = true;
					var code = comboObjects[2].Code;
					UF_setAuth(comboObjects[2].GetText(code, 3), comboObjects[2].GetText(code, 1));
				}
				
				// VVD ITEM DUP CHECK
				for (var j = 1; j < sheetObjects[0].RowCount+1; j++) {
					if (sheetObjects[0].CellValue(j, prefix+"remark") == "Y") {
						sheetObjects[0].RowBackColor(j) = sheetObjects[0].RgbColor(0, 151, 215); //아큐아 색
					}
				}	
			}
			break;

		case IBCREATE: //CREATE
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0005GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				if (ComGetEtcData(sXml,"clz_yn") == "C"){
					ComShowCodeMessage("JOO00177");
					JooSetBtnClass("C", false);
					JooSetBtnClass("U", false);
					sheetObjects[0].Editable = false;
				}else{
					JooSetBtnClass("C", true);
					JooSetBtnClass("U", true);
					sheetObjects[0].Editable = true;
					var code = comboObjects[2].Code;
					UF_setAuth(comboObjects[2].GetText(code, 3), comboObjects[2].GetText(code, 1));
				}
			}
			break;
			
		case IBSAVE: //저장
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0005GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var vvditem = ComGetEtcData(sXml, "vvditem");
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				if (vvditem.length > 0) {
				   alert('VVD ITEM DUP!');
				}
	        }
			 sheetObj.LoadSearchXml(sXml);			
           
			ComOpenWait(false);
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				
				var vvditemList = new Array();
	
				vvditemList = vvditem.split("|");
		
				if (vvditem.length < 1) {
					break;
				}
			
				for (var i = 0; i < vvditemList.length; i++ ) {
					
					for (var j = 1; j < sheetObjects[0].RowCount+1; j++) {
				
						if(    (sheetObjects[0].CellValue(j, prefix+"vsl_cd")         == vvditemList[i].substring(0,4))
						    && (sheetObjects[0].CellValue(j, prefix+"skd_voy_no")     == vvditemList[i].substring(4,8))
						    && (sheetObjects[0].CellValue(j, prefix+"skd_dir_cd")     == vvditemList[i].substring(8,9))
						    && (sheetObjects[0].CellValue(j, prefix+"rev_dir_cd")     == vvditemList[i].substring(9,10))
						    && (sheetObjects[0].CellValue(j, prefix+"jo_stl_itm_cd")  == vvditemList[i].substring(10,13)) ) {
							sheetObjects[0].RowBackColor(j) = sheetObjects[0].RgbColor(0, 151, 215); //아큐아 색
						}
					}	
				}
			}	
			break;
			
		//VVD 9자리 입력시 Fin.Dir 을 가져온다.
		case IBSEARCH_ASYNC01: //Port 읽어오기
			formObj.f_cmd.value = SEARCHLIST10;
			formObj.code.value = formObj.jo_crr_cd.Code;
			formObj.name.value = formObj.jo_stl_opt_cd.value; 
			formObj.super_cd1.value = formObj.rlane_cd.Code;
			formObj.super_cd2.value = gVVD;
			
	        var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

	        var basicPorts = ComGetEtcData(sXml, "basicPorts");
	        var pairPorts  = ComGetEtcData(sXml, "pairPorts");
	        var unitPorts  = ComGetEtcData(sXml, "unitPorts");   

	        //gBasicPortCombo[inx][0] ==> rlane_dir_cd
	        //gBasicPortCombo[inx][1] ==> rlane_dir_cd의 delt_flg
	        //gBasicPortCombo[inx][2] ==> basic port
	        //gBasicPortCombo[inx][3] ==> eta
	        //gBasicPortCombo[inx][4] ==> etd
	        gBasicPortCombo[gCurRow] = basicPorts.split("|");

	        //gPairPortCombo[inx][0] ==> pair port
	        //gPairPortCombo[inx][1] ==> eta
	        //gPairPortCombo[inx][2] ==> etd
	        gPairPortCombo[gCurRow]  = pairPorts.split("|");
	        
	        //gUnitPortCombo[inx][0] ==> pair port
	        //gUnitPortCombo[inx][1] ==> etd
	        gUnitPortCombo[gCurRow] = unitPorts.split("|");

	        var cnt = gBasicPortCombo[gCurRow].length;
	        if (gBasicPortCombo[gCurRow] == "" || cnt==0){
	        	ComShowCodeMessage('JOO00031');
    			sheetObj.CellValue2(gCurRow, prefix+"vsl_cd") = "";
    			sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no") = "";
    			sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd") = "";
    			sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
        		return;	        		
	        }

	        var basicPortCombo = "";
	        for (var inx = 0; inx < cnt;  inx++){
	        	gBasicPortCombo[gCurRow][inx] = gBasicPortCombo[gCurRow][inx].split(",");

		        if (inx == cnt -1){
		        	basicPortCombo += gBasicPortCombo[gCurRow][inx][2];
	        	}else{
	        		basicPortCombo += gBasicPortCombo[gCurRow][inx][2]+"|";
	        	}
	        }

	        //항차가 삭제된 것이면 계속갈 것인지 여부를 묻는다. 
	        var deltFlg = gBasicPortCombo[gCurRow][0][1];	        
	        if (deltFlg == "Y"){
	        	if (!ComShowCodeConfirm('JOO00032',gVVD)) {
	    			sheetObj.CellValue2(gCurRow, prefix+"vsl_cd") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"rev_dir_cd") = "";
	    			sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
	        		return;	        		
	        	}
	        }
	        //revenue lane direction setting
			sheetObj.CellValue(gCurRow, prefix+"rev_dir_cd" ) = gBasicPortCombo[gCurRow][0][0];


	        var pairPortCombo = "";
	        cnt = gPairPortCombo[gCurRow].length;
	        for (var inx = 0; inx < cnt;  inx++){
	        	gPairPortCombo[gCurRow][inx] = gPairPortCombo[gCurRow][inx].split(",");

		        if (inx == cnt -1){
		        	pairPortCombo += gPairPortCombo[gCurRow][inx][0];
	        	}else{
	        		pairPortCombo += gPairPortCombo[gCurRow][inx][0]+"|";
	        	}
	        }
			
	        var unitPortCombo = "";
	        cnt = gUnitPortCombo[gCurRow].length;
	        for (var inx = 0; inx < cnt; inx++) {
	        	gUnitPortCombo[gCurRow][inx] = gUnitPortCombo[gCurRow][inx].split(",");
		        if (inx == cnt -1){
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0];
		        }else{
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0]+"|";
		        }
	        }
			
	        //콤보로 변경
	        sheetObj.InitCellProperty(gCurRow, 8, dtCombo, daCenter, prefix+"stl_bzc_port_cd" , "", dfNone);
	        sheetObj.InitCellProperty(gCurRow,16, dtCombo, daCenter, prefix+"stl_pair_port_cd", "", dfNone);
//	        sheetObj.InitCellProperty(gCurRow,20, dtCombo, daCenter, prefix+"uc_bss_port_cd", "", dfNone);
	        
			sheetObj.CellComboItem(gCurRow, prefix+"stl_bzc_port_cd" , basicPortCombo, basicPortCombo, 0);
			sheetObj.CellComboItem(gCurRow, prefix+"stl_pair_port_cd", pairPortCombo , pairPortCombo , 0);
//			sheetObj.CellComboItem(gCurRow, prefix+"uc_bss_port_cd"  , unitPortCombo , unitPortCombo , 0);

			sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd"   ) = "";
			sheetObj.CellValue2(gCurRow, prefix+"bzc_port_eta_dt"   ) = "";
			sheetObj.CellValue2(gCurRow, prefix+"bzc_port_etd_dt"   ) = "";
			sheetObj.CellValue2(gCurRow, prefix+"stl_pair_port_cd"  ) = "";
			sheetObj.CellValue2(gCurRow, prefix+"pair_port_eta_dt"  ) = "";
			sheetObj.CellValue2(gCurRow, prefix+"pair_port_etd_dt"  ) = "";
//			sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = "";
//			sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = "";

	        break;

	    // ITEM을 OUS로 변경할 경우 RDR인지 TDR인지 BASIC PORT를 검색하여 Setting한다. 
		case IBSEARCH_ASYNC02: //OUS TDR/RDR가져오기
			formObj.f_cmd.value = SEARCH01;

			//수정된 것만 가져가는것이 아닌 전체 row를 가져간다. ==> 몇번째 row인지 알기 위함
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0005GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			var joMnuNm = ComGetEtcData(sXml,"jo_mnu_nm");
			var flg = sheetObj.CellValue(gCurRow,prefix+"jo_mnl_cre_flg");
			if (flg=="1"){
				sheetObj.CellValue(gCurRow, prefix+"jo_mnu_nm")="M/S";
			}else{
				sheetObj.CellValue(gCurRow, prefix+"jo_mnu_nm")=joMnuNm;
			}
			sheetObj.CellValue(gCurRow, prefix+"jo_mnu_nm1")=joMnuNm;
			break;

		case IBSEARCH_ASYNC03: //UnitCost Port 읽어오기
			formObj.f_cmd.value = SEARCHLIST14;
			formObj.code.value = formObj.jo_crr_cd.Code;
			formObj.super_cd1.value = formObj.rlane_cd.Code;
			formObj.super_cd2.value = gVVD;

	        var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

	        var unitPorts  = ComGetEtcData(sXml, "unitPorts");   

	        //gUnitPortCombo[Row][portInx][0] ==> pair port
	        //gUnitPortCombo[Row][portInx][1] ==> etd
	        gUnitPortCombo[gCurRow] = unitPorts.split("|");


	        var unitPortCombo = "";
	        var cnt = gUnitPortCombo[gCurRow].length;
	        for (var inx = 0; inx < cnt; inx++) {
	        	gUnitPortCombo[gCurRow][inx] = gUnitPortCombo[gCurRow][inx].split(",");
		        if (inx == cnt -1){
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0];
		        }else{
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0]+"|";
		        }
	        }
//	        sheetObj.InitCellProperty(gCurRow,20, dtCombo, daCenter, prefix+"uc_bss_port_cd", "", dfNone);
//			sheetObj.CellComboItem(gCurRow, prefix+"uc_bss_port_cd"  , unitPortCombo , unitPortCombo , 0);
			//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"  ) = "";
			//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt"  ) = "";
	        break;
	        
		case IBSEARCH_ASYNC04: //Unit Cost Port 읽어오기
			formObj.f_cmd.value = SEARCH09;
			formObj.code.value = formObj.jo_crr_cd.Code;
			formObj.super_cd1.value = formObj.rlane_cd.Code;
			formObj.super_cd2.value = gVVD;
			
	        var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	        var unitPorts  = ComGetEtcData(sXml, "unitPorts");   

	        //항차가 삭제된 것이면 계속갈 것인지 여부를 묻는다. 
	        var deltFlg  = ComGetEtcData(sXml, "deltFlg");
	        var revDirCd = ComGetEtcData(sXml, "revDirCd");
	        if (deltFlg == "Y"){
	        	if (!ComShowCodeConfirm('JOO00032',gVVD)) {
	    			sheetObj.CellValue2(gCurRow, prefix+"vsl_cd") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd") = "";
	    			sheetObj.CellValue2(gCurRow, prefix+"rev_dir_cd") = "";
	    			sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
	        		return;	        		
	        	}
	        }
	        
	        //revenue lane direction setting
			sheetObj.CellValue(gCurRow, prefix+"rev_dir_cd" ) = revDirCd;

	        //gUnitPortCombo[Row][portInx][0] ==> pair port
	        //gUnitPortCombo[Row][portInx][1] ==> etd
	        gUnitPortCombo[gCurRow] = unitPorts.split("|");

	        var unitPortCombo = "";
	        var cnt = gUnitPortCombo[gCurRow].length;
	        for (var inx = 0; inx < cnt; inx++) {
	        	gUnitPortCombo[gCurRow][inx] = gUnitPortCombo[gCurRow][inx].split(",");
		        if (inx == cnt -1){
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0];
		        }else{
		        	unitPortCombo += gUnitPortCombo[gCurRow][inx][0]+"|";
		        }
	        }
//	        sheetObj.InitCellProperty(gCurRow,20, dtCombo, daCenter, prefix+"uc_bss_port_cd", "", dfNone);
//			sheetObj.CellComboItem(gCurRow, prefix+"uc_bss_port_cd"  , unitPortCombo , unitPortCombo , 0);
//			sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"  ) = "";
//			sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt"  ) = "";
	        break;
	        
		case IBDELETE: //삭제
			if (!ComShowCodeConfirm("JOO00135", "selected")){
				return false;
			}
			formObj.f_cmd.value = REMOVE;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			try{
				var sXml = sheetObj.GetSaveXml("FNS_JOO_0005GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			}finally{
				ComOpenWait(false);
			}
			//재조회 ==> dup error인 경우 재조회하면 날아감...
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
				if (ComGetEtcData(sXml,"RTNVAL") == "E"){
					ComShowCodeMessage("JOO00183");
				}else{
					sheetObj.LoadSearchXml(sXml);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}
			break;

		case IBSEARCH_ASYNC05: // AR Closing Time 체크 조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0005GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				if (ComGetEtcData(sXml,"clz_yn") == "C"){
					JooSetBtnClass("C", false);
					JooSetBtnClass("U", false);
					sheetObjects[0].Editable = false;
					
				}else{
					JooSetBtnClass("C", true);
					JooSetBtnClass("U", true);
					sheetObjects[0].Editable = true;
					
				}
			}
			break;

	        
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, crrCombo) {
    var formObj = document.form
    
    switch(comboNo) {
    	//Carrier Code
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
 		    }
            var comboItems = crrCombo.split("|");
            addComboItem(comboObj, comboItems);           	
 			break; 
 			
 		//Trade Code
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
  		    }
  			break;
  			
  		//Rlane Code ==> rlane_cd|jo_stl_opt_cd|re_divr_cd|auth_cd   
    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left|left|left|left");        
 				SetColWidth("35|25|0|0");//code|name|super_cd1|auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			//if(validateForm(sheetObj,formObj,sAction))
			if (sComboObj.id == "trd_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST06;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
			}else if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH08;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
				//rlane_cd|jo_stl_opt_cd|re_divr_cd|auth_cd
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|super_cd1|auth_cd");
			}
														
	        break;
    }
}

/**
 * Carrier 변경시 Reset
 * @param comboObj
 * @param Value
 * @param Text
 * @return
 */
function jo_crr_cd_OnChange(comboObj, Value, Text){
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();

	sheetObjects[0].RemoveAll();
}

/**
 * Trade Focus획득시 Trade Combo List 조회
 * @param comboObj
 * @return
 */
function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH , comboObj ,"trd_cd");
		comboObj.Enable = true;
	}
}

/**
 * Trade 변경시 하위 조회조건 RESET
 * @param comboObj
 * @param Value
 * @param Text
 * @return
 */
function trd_cd_OnChange(comboObj, Value, Text){
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();

	sheetObjects[0].RemoveAll();
}

/**
 * Rlane Focus 획득시 Rlane Combo List 조회 
 * @param comboObj
 * @return
 */
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[1].Code.length < 3){
		ComShowCodeMessage("JOO00009");
		formObj.trd_cd.focus();
		return;
	}

	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1], formObj ,IBSEARCH , comboObj, "rlane_cd");
		comboObj.Enable = true;
	}
}

/**
 * Rlane Code 변경시 RE_DIVR_CD, JO_STL_JB_CD, 권한에 따른 Button Setting 
 * @param comboObj
 * @param code
 * @param text
 * @return
 */
function rlane_cd_OnChange(comboObj, code, text){
	var formObj = document.form;
	//var arrText = text.split("|"); //rlane_cd|jo_stl_opt_cd|re_divr_cd|auth_cd	
	formObj.jo_stl_opt_cd.value = comboObj.GetText(code, 1);

	sheetObjects[0].RemoveAll();
	
	//RE_DIVR_CD를 JOO_CARRIER에서 VENDOR만 있으면 E, CUSTOMER만 있으면 R, 둘다 있으면 A를 return한다.
	var reDivrCd = comboObj.GetText(code, 2);
	UF_setReDivrCd(reDivrCd);
	UF_setAuth(comboObj.GetText(code, 3), comboObj.GetText(code, 1));
}

/**
 * Rlane Code Focus Out일때 조회
 * @param comboObj
 * @return
 */
function rlane_cd_OnBlur(comboObj){
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.Code.length < 3){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Code.length < 3){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Code.length < 5){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			break;
			
		case IBCREATE: //저장용 조회
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.Code.length < 3){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Code.length < 3){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Code.length < 5){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}

			//2010.03.04 DATA가 존재하면 CREATE를 막아놨으나 S/H ADJUSTMENT로 생성된 경우 CREATE를 할 수 없는 맹점이 있다.(PROC_JB_FLG가 Y가 삭제도 안되므로)
			// 수정사항 => CREATE시 기존 DATA를 같이 가져오도록 수정                
//			if (sheetObj.LastRow > 0 && sheetObj.CellValue(sheetObj.LastRow,"sheet1_vsl_cd") != ""){
//				ComShowCodeMessage('JOO00034');
//				return false;
//			}
			
//			if (formObj.jo_stl_opt_cd.value == "C"){
//				ComShowCodeMessage("JOO00150");
//				return false;
//			}
			break;
			
		case IBSAVE:   //저장
			var cnt = 0;
			var revYrmonNull = "";
			
			var pendingList = "";
			var hasPending = false;
			
			for (var inx=1; inx <= sheetObj.LastRow; inx++){
				var ibflag = sheetObj.RowStatus(inx);
				
				if (ibflag == "R")
					continue;
				
				cnt++;
				
				//삭제될 건은 validation check하지 않고 cnt만 증가시킨다.
				if (ibflag == "D")
					continue;
				
				var stlOptCd = formObj.jo_stl_opt_cd.value;
				
				//del_chk 체크만 한 경우를 방지하기 위함 
				if ((ibflag == "I" || ibflag == "U") && sheetObj.CellValue(inx,prefix+"del_chk") == "1"){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}

				if (sheetObj.CellValue(inx, prefix+"vsl_cd").length < 4){
					ComShowCodeMessage('JOO00040',inx);
					sheetObj.SelectCell(inx, prefix+"vsl_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_voy_no").length < 4){
					ComShowCodeMessage('JOO00041',inx);
					sheetObj.SelectCell(inx, prefix+"skd_voy_no", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_dir_cd").length < 1){
					ComShowCodeMessage('JOO00042',inx);
					sheetObj.SelectCell(inx, prefix+"skd_dir_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"rev_dir_cd").length < 1){
					ComShowCodeMessage('JOO00055',inx);
					sheetObj.SelectCell(inx, prefix+"rev_dir_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"jo_stl_itm_cd").length < 3){
					ComShowCodeMessage('JOO00043',inx);
					sheetObj.SelectCell(inx, prefix+"jo_stl_itm_cd", true);
					return false;
				}
				
				var joStlItmCd  = sheetObj.CellValue(inx, prefix+"jo_stl_itm_cd");
				var joMnuNm     = sheetObj.CellValue(inx, prefix+"jo_mnu_nm");

				//P/B, W/R, OTH는 Basic Port가 없어도 된다?
				if (!(joStlItmCd == "P/B" || joStlItmCd == "W/R" || joStlItmCd == "OTH")){
					if (sheetObj.CellValue(inx, prefix+"stl_bzc_port_cd").length == 0){
						ComShowCodeMessage('JOO00044',inx);
						sheetObj.SelectCell(inx, prefix+"stl_bzc_port_cd", true);
						return false;
					}
				}
				
				//Cycle이면 Status는 없어도 된다.
				if (stlOptCd != "C"){
					var mnthCondCd = sheetObj.CellValue(inx,prefix+"mnth_cond_cd");
					if (mnthCondCd == ""){
						ComShowCodeMessage('JOO00019', inx + " Month Option ");
						sheetObj.SelectCell(inx,prefix+"mnth_cond_cd",true);
						return false;
					}
	
					var portCondCd = sheetObj.CellValue(inx,prefix+"port_cond_cd");
					if (portCondCd == ""){
						ComShowCodeMessage('JOO00019', inx + " Port Option ");
						sheetObj.SelectCell(inx,prefix+"port_cond_cd",true);
						return false;
					}
	
					var portTypeCd = sheetObj.CellValue(inx,prefix+"port_type_cd");
					if (portTypeCd == ""){
						ComShowCodeMessage('JOO00019', inx + " Port Type ");
						sheetObj.SelectCell(inx,prefix+"port_type_cd",true);
						return false;
					}
					var operTypeCd = sheetObj.CellValue(inx,prefix+"oper_type_cd");
					if (operTypeCd == ""){
						ComShowCodeMessage('JOO00019', inx + " Operation Type ");
						sheetObj.SelectCell(inx,prefix+"oper_type_cd",true);
						return false;
					}
				}
				
				//P/B, W/R, OTH는 Basic Pair Port 가 없어도 된다? => 그외에 Basic Port와 Basic Pair Port가 같으면 Error Message
				if (!(joStlItmCd == "P/B" || joStlItmCd == "W/R" || joStlItmCd == "OTH")){
					if (sheetObj.CellValue(inx, prefix+"stl_bzc_port_cd") == sheetObj.CellValue(inx, prefix+"stl_pair_port_cd")){
						ComShowCodeMessage('JOO00029', inx);
						sheetObj.SelectCell(inx, prefix+"stl_pair_port_cd", true);
						return false;
					}
				}
				
//				var ucBssPortCd = sheetObj.CellValue(inx, prefix+"uc_bss_port_cd");
				
//				if (ucBssPortCd == ""){
					//S/H, OUS, R/F이고  JO_MNU_NM이 M/S가 아니면서 UNIT_COST 포트가 NULL이면 에러
//					if ((joStlItmCd == "S/H" || joStlItmCd == "OUS" || joStlItmCd == "R/F") && (joMnuNm != "M/S")){
//						ComShowCodeMessage('JOO00035',inx);
//						sheetObj.SelectCell(inx, prefix+"uc_bss_port_cd", true);
//						return false;
//					}
//				}

//				var ucBssPortDt = sheetObj.CellValue(inx, prefix+"uc_bss_port_etd_dt");
				
//				if (ucBssPortDt == ""){
					//S/H, OUS, R/F이고  JO_MNU_NM이 M/S가 아니면서 UNIT_COST 포트가 NULL이면 에러
//					if ((joStlItmCd == "S/H" || joStlItmCd == "OUS" || joStlItmCd == "R/F") && (joMnuNm != "M/S")){
//						ComShowCodeMessage('JOO00154');
//						sheetObj.SelectCell(inx, prefix+"uc_bss_port_etd_dt", true);
//						return false;
//					}
//				}
				
				//REV_YRMON가 없으면 저장못하게 한다. 2009.11.03
				//Insert에만 rev_yrmon가 있으므로(create등) 수정시에는 체크하지 않는다.				
				if (ibflag == "I"){
					var revYrmon = sheetObj.CellValue(inx, prefix+"rev_yrmon");
					var vvd = sheetObj.CellValue(inx, prefix+"vsl_cd") 
					        + sheetObj.CellValue(inx, prefix+"skd_voy_no") 
					        + sheetObj.CellValue(inx, prefix+"skd_dir_cd") 
					        + sheetObj.CellValue(inx, prefix+"rev_dir_cd");
					
					if (ComTrim(revYrmon) == ""){
						revYrmonNull = revYrmonNull + vvd + "("+inx+"),";						
					}
					
					if (sheetObj.CellValue(inx, prefix+"pending_flg") == "Y"){
						if (!hasPending) hasPending = true;
						
			            pendingList = pendingList + vvd + "("+inx+"),";
					}
					
				}
			}
			
			if (ComTrim(revYrmonNull) != ""){
				ComShowCodeMessage('JOO00148', revYrmonNull.substring(0,revYrmonNull.length-1));
				return false;
			}
			
			if (cnt==0){
				ComShowCodeMessage('JOO00036');
				return false;
			}

			if (hasPending){
				pendingList = pendingList.substring(0, pendingList.length-1);		
				ComShowCodeMessage('JOO00182', pendingList);
			}
			break;
			
		case IBDELETE:
			var cnt = 0;
			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
				if (sheetObj.CellValue(i, prefix+"del_chk") == "1"){
					cnt++;
				}
			}
			
			//삭제할 건수가 있으면 Delete버튼을 활성화 시킨다.
			if (cnt == 0){
				ComShowCodeMessage("JOO00093");
				return;
			}
			
			break;
	}
	return true;
}

/**
 * 조회가 끝난 다음
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComChkObjValid(document.form.acct_yrmon);

    //reset
    gBasicPortCombo = new Array(300);//max row를 300으로 가정    
    gPairPortCombo  = new Array(300);//max row를 300으로 가정
    gUnitPortCombo  = new Array(300);//max row를 300으로 가정

    var revYrmonNullList = "";
	var revYrmon = "";
	var hasRevNull = false; //AR_MST_REV_VVD의 Revenue Year Month가 Null인지 Check한다.
	
	//최초에 Delete 버튼을 Disable시킨다.
	JooSetBtnClass("D", false);
	
	var adjCnt = 0;
	
	//PROC_JB_FLG가 Y이면 삭제불가 (JOO_SETTLEMENT에 data가 있다는 뜻임) 
	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		//PROC_JB_FLG가 Y이면 Manual Settle 수정불가 ==> 2009-12-04 
		if (sheetObj.CellValue(inx, prefix+"proc_jb_flg") == "Y"){
			sheetObj.CellEditable(inx, prefix+"del_chk") = false;
			sheetObj.CellEditable(inx, prefix+"jo_mnl_cre_flg") = false;
			//2010.03.29 Reverse가 된 건은 confirm을 수정할 수 있다.
			if (sheetObj.CellValue(inx, prefix+"rvs_flg") == "Y"){
				sheetObj.CellEditable(inx, prefix+"jo_stl_cfm_cd") = true;
			}else{
				sheetObj.CellEditable(inx, prefix+"jo_stl_cfm_cd") = false;
			}
			
			// proc_jb_flg = 'Y' 이고  jo_stl_cfm_cd = 'N'이면 Adjust 에서 강제생성한 Target VVD로 본다.
			if (sheetObj.CellValue(inx, prefix+"jo_stl_cfm_cd") == "N"){
				adjCnt++;
			}
		}else{
			sheetObj.CellEditable(inx, prefix+"del_chk") = true;
			sheetObj.CellEditable(inx, prefix+"jo_stl_cfm_cd") = true;
			if (sheetObj.CellValue(inx, prefix+"jo_stl_itm_cd") == "OTH"){
				sheetObj.CellEditable(inx, prefix+"jo_mnl_cre_flg") = false;
			}else{
				sheetObj.CellEditable(inx, prefix+"jo_mnl_cre_flg") = true;
			}
		}

		if (sheetObj.RowStatus(inx) == "I"){
			revYrmon = ComTrim(sheetObj.CellValue(inx, prefix+"rev_yrmon"));
			if (revYrmon == "" || revYrmon == "null"){
				if (!hasRevNull) 
					hasRevNull = true;
				var vvd = sheetObj.CellValue(inx, prefix+"vsl_cd") 
		        + sheetObj.CellValue(inx, prefix+"skd_voy_no") 
		        + sheetObj.CellValue(inx, prefix+"skd_dir_cd") 
		        + sheetObj.CellValue(inx, prefix+"rev_dir_cd");

				revYrmonNullList = revYrmonNullList + vvd + "("+inx+"),"; 
			}
		}
		
		//Pending 된 VVD이면 색깔을 달리 한다.
		if (sheetObj.CellValue(inx, prefix+"pending_flg") == "Y"){
            sheetObj.RowFontColor(inx) = sheetObj.RgbColor(255, 0 ,0);
		}
		
	}

	//Adjst Cancel 대상이 없으면 권한에 관계없이 버튼 비활성화...있으면 권한에 따라 활성화/비활성화 결정
	if (adjCnt == 0){
		JooSetBtnClass("A", false);
	}else{
		var code = comboObjects[2].Code;
		if (comboObjects[2].GetText(code, 3) == "W"){
			JooSetBtnClass("A", true);
		}else{
			JooSetBtnClass("A", false);
		}
	}
	
	if (hasRevNull){
		revYrmonNullList = revYrmonNullList.substring(0, revYrmonNullList.length-1);		
		ComShowCodeMessage('JOO00148', revYrmonNullList);
	}
}

/**
 * Sheet1_KeyUp
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var sName = sheetObj.ColSaveName(Col);
	var Value = sheetObj.EditValue;

	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
	}

	//4자리 치면 NEXT로 이동
	if (sName == prefix+"skd_voy_no" && Value.length==4){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
}

/**
 * IBSheet의 OnChange Event
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	
	gCurRow = Row;
	
	formObj.curr_row.value = gCurRow - sheetObj.HeaderRows; 

	var vvd = "";
	vvd += sheetObj.CellValue(Row, prefix+"vsl_cd");
	vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
	vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");

	//VVD변경시 (9자리) ==> REV_DIR_CD 조회 및  Port List 조회
	if (sName == prefix+"vsl_cd"){
		if (Value.length < 4){
			ComShowCodeMessage('JOO00037');
			sheetObj.SelectCell(Row, Col, true);
			return;
		}

		if (vvd.length == 9){
			gVVD = vvd;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	if (sName == prefix+"skd_voy_no"){
		if (Value.length < 4){
			ComShowCodeMessage('JOO00038');
			sheetObj.SelectCell(Row, Col, true);
			return;
		}

		if (vvd.length == 9){
			gVVD = vvd;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	if (sName == prefix+"skd_dir_cd"){
		var joStlItmCd = sheetObj.CellValue(Row, prefix+"jo_stl_itm_cd");
		//OUS이면 SKD_DIR에 따라 JO_MNU_NM를 가져오는 logic을 타야 하므로 clear시켜준다.
		if (joStlItmCd == "OUS"){
			sheetObj.CellValue2(Row, prefix+"jo_stl_itm_cd") ="";
		}
		if (vvd.length == 9){
			gVVD = vvd;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	if (sName == prefix+"jo_stl_itm_cd"){
		//Item이 W/R이거나 P/B이면 Mannual settle 체크 못하게
		if (Value=="P/B" || Value=="W/R"){
			sheetObj.CellValue2(Row,prefix+"jo_mnl_cre_flg")="0";
			sheetObj.CellEditable(Row,prefix+"jo_mnl_cre_flg")=false;
			sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = Value;
		//Item이 OTH이면 무조건 jo_mnu_nm = M/S
		}else if (Value=="OTH"){
			sheetObj.CellValue2(Row,prefix+"jo_mnl_cre_flg")="1";
			sheetObj.CellEditable(Row,prefix+"jo_mnl_cre_flg")=false;
			sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = "M/S";
		}else{
			sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = Value;
			sheetObj.CellValue2(Row,prefix+"jo_mnl_cre_flg")="0";
			sheetObj.CellEditable(Row,prefix+"jo_mnl_cre_flg")=true;
			//Cycle은 R로 임의 setting ==> 2009.11.30 박효숙 차장 
			//Cycle 외에는 OUS인 경우는 Basic Port에서 TDR/RDR을 가져온다.
			if (Value=="OUS"){
				if (formObj.jo_stl_opt_cd.value == "C"){
					sheetObj.CellValue2(Row, prefix+"jo_mnu_nm")  = "RDR";
					sheetObj.CellValue2(Row, prefix+"jo_mnu_nm1") = "RDR";
				}else{
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
				}
			}
		}
	}
	
	//Mannual Settle 을 Check할 경우
	if (sName == prefix+"jo_mnl_cre_flg"){
		var flg = Value;//sheetObj.EditValue;
		//Check하면 JO_MNU_NM은 M/S로 Setting
		if (flg == "1"){
			sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = "M/S";
		}else{
			//Uncheck하면 JO_MNU_NM에 ==> OUS인 경우는 RDR/TDR중 가져온 값을 넣고 그외에는 자신의 ITEM을 넣는다.
			var joStlItmCd = sheetObj.CellValue(Row,prefix+"jo_stl_itm_cd");
			if (joStlItmCd == "OUS"){
				var joMnuNm = sheetObj.CellValue(Row,prefix+"jo_mnu_nm1");
				sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = joMnuNm;
			}else{
				sheetObj.CellValue2(Row, prefix+"jo_mnu_nm") = joStlItmCd;
			}
		}
	}
	
	//Basic Port change시 ETA, ETD 세팅한다. 
	if (sName == prefix+"stl_bzc_port_cd"){
		var eta = "";
		var etd = "";
		//VVD가 같고 Port 가 같은 것의 ETA, ETD를 가져온다.
		for (var inx=0; inx<gBasicPortCombo[Row].length; inx++){
			if (Value == gBasicPortCombo[Row][inx][2]){
				eta = gBasicPortCombo[Row][inx][3];
				etd = gBasicPortCombo[Row][inx][4];
				break;
			}
		}

		sheetObj.CellValue(Row, prefix+"bzc_port_eta_dt") = eta;
		sheetObj.CellValue(Row, prefix+"bzc_port_etd_dt") = etd;
	}

	//Pair Port change시 ETA, ETD 세팅한다. 
	if (sName == prefix+"stl_pair_port_cd"){
		var eta = "";
		var etd = "";
		//Port 가 같은 것의 ETA, ETD를 가져온다.
		for (var inx=0; inx<gPairPortCombo[Row].length; inx++){
			if (Value == gPairPortCombo[Row][inx][0]){
				eta = gPairPortCombo[Row][inx][1];
				etd = gPairPortCombo[Row][inx][2];
				break;
			}
		}
		
		sheetObj.CellValue(Row, prefix+"pair_port_eta_dt") = eta;
		sheetObj.CellValue(Row, prefix+"pair_port_etd_dt") = etd;
	}

	//UnitCost Port change시 ETD 세팅한다. 
//	if (sName == prefix+"uc_bss_port_cd"){
//		var etd = "";
		//Port가 같은 것의 ETD를 가져온다.
//		for (var inx=0; inx<gUnitPortCombo[Row].length; inx++){
//			if (Value == gUnitPortCombo[Row][inx][0]){
//				etd = gUnitPortCombo[Row][inx][1];
//				break;
//			}
//		}
		
//		sheetObj.CellValue(Row, prefix+"uc_bss_port_etd_dt") = etd;
//	}
}

/**
 * IBSheet를 Click 한 경우
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	
	gCurRow = Row;
	
	formObj.curr_row.value = gCurRow - sheetObj.HeaderRows; 
	
	//L/SKD 에서 받은 VVD인지를 체크하기 위함
	var pop_flg = sheetObj.CellValue(Row, prefix+"pop_flg");
	
	if (pop_flg == "1"){
		//L/SKD로 POP되어 받아온 VVD는 FIN_DIR을 클릭할 때 모든 데이터(Basic Port List, Pair Port List, UnitCostBasicPort List)를 가져온다.
		if (sName == prefix+"rev_dir_cd"){
			var vvd = "";
			vvd += sheetObj.CellValue(Row, prefix+"vsl_cd");
			vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
			vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
			
			var tmp = sheetObj.GetComboInfo(Row, prefix+"rev_dir_cd", "Code").split("|");
			if (tmp.length <= 1){
				if (vvd.length == 9){
					gVVD = vvd;
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
				}
			}
		}
	}
	
	//조회 모드에서 Unit Cost Basic Port를 수정할 수 있다.
//	if (sName == prefix+"uc_bss_port_cd"){
//		var vvd = "";
//		vvd += sheetObj.CellValue(Row, prefix+"vsl_cd");
//		vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
//		vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");

//		if (vvd.length != 9){		
//			ComShowCodeMessage('JOO00039');
//			sheetObj.SelectCell(Row, prefix+"vsl_cd", true);
//			return;
//		}
		
//		gVVD = vvd;

		//UnitCost Basic Port의 ITEM이 없으면 조회해서 COMBO를 setting한다.
//		var tmp = sheetObj.GetComboInfo(Row, prefix+"uc_bss_port_cd", "Code").split("|");
//		if (tmp.length <= 1)
//			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
//	}
}

function UF_copyRow(){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var arrs = sheetObj.GetSelectionRows(",");
	var rows = arrs.split(",");
	for (var i = rows.length-1; i >= 0; i--){
		sheetObj.SelectCell(rows[i], 7);		
		var row = sheetObj.DataCopy();
		sheetObj.CellValue2(row, prefix+"jo_stl_itm_cd") = ""; 
		sheetObj.CellValue2(row, prefix+"jo_mnu_nm")     = ""; 
		sheetObj.CellValue2(row, prefix+"jo_mnu_nm1")    = "";
		sheetObj.CellValue2(row, prefix+"jo_mnl_cre_flg")= "0";
		sheetObj.CellValue2(row, prefix+"proc_jb_flg")   = "N";//proc_jb_flg는 N으로 한다...
		sheetObj.CellValue2(row, prefix+"rev_yrmon") = "999912"; //copy한 것은 revenue year month가 있다고 봐야한다.
	}
}

function UF_addRow(){
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	
	var row = sheetObject1.DataInsert(-1);

	var reDivrCd = "";
	
	for (var inx=0; inx<formObj.re_divr_cd.length; inx++){
		if (formObj.re_divr_cd[inx].checked){
			reDivrCd = formObj.re_divr_cd[inx].value;
			break;
		}
	}
	
	sheetObject1.CellValue(row, prefix+"acct_yrmon") = ComReplaceStr(formObj.acct_yrmon,"-","");
	sheetObject1.CellValue(row, prefix+"re_divr_cd") = reDivrCd;
	sheetObject1.CellValue(row, prefix+"jo_crr_cd" ) = formObj.jo_crr_cd.Code;
	sheetObject1.CellValue(row, prefix+"trd_cd"    ) = formObj.trd_cd.Code;
	sheetObject1.CellValue(row, prefix+"rlane_cd"  ) = formObj.rlane_cd.Code;

	//초기화
	sheetObject1.CellValue(row, prefix+"skd_dir_cd") = "";
	sheetObject1.CellValue(row, prefix+"rev_dir_cd") = "";
	sheetObject1.CellValue(row, prefix+"jo_stl_itm_cd") = "";
	//sheetObject1.CellValue(row, prefix+"stl_tgt_vvd_bss_cd") = "";
	sheetObject1.CellValue(row, prefix+"proc_jb_flg") = ""; //N은 NULL로 보여줘야함...
	sheetObject1.CellValue(row, prefix+"agmt_mon_cond_cd") = "";
	sheetObject1.CellValue(row, prefix+"agmt_port_cond_cd") = "";
	sheetObject1.CellValue(row, prefix+"agmt_port_tp_cond_cd") = "";
	sheetObject1.CellValue(row, prefix+"agmt_op_tp_cond_cd") = "";
	//2009.11.12 RowAdd한 경우 VVD입력시에 AR_MST_VVD 에서 DEL_FLG를 체크하므로 REV_YRMON는 무조건 있는 것으로 본다.
	sheetObject1.CellValue(row, prefix+"rev_yrmon") = "999912";
	
	sheetObject1.SelectCell(row, prefix+"vsl_cd", true);
	//var rlaneCd  = formObj.rlane_cd.text;
	//var skdDirCd = sheetObject1.CellValue(row, prefix+"rev_dir_cd"); 
	//UF_setPortCombo(sheetObject1, row, rlaneCd, skdDirCd);				
	return row;
}

/**
 * Cycle 인 경우 Long range schedule에서 VVD를 선택하여 가져온다.
 * @return
 */
function UF_popLSKD(){
	var param = "?select_mode=Y";
	var sUrl = "/hanjin/VOP_VSK_0012.do"+param;
	var rVal = ComOpenPopupWithTarget(sUrl, 1040, 690, "", "0,0", true, "yes");

	var sheetObj = sheetObjects[0];
	
	if(rVal){
	    var item = null;
	    var row;
	    //OK눌러서 data가 있는 경우만 sheet를 clear시킴
	    if (rVal.length > 0){
	    	//Cycle인 경우만 해당하므로 
	    	if (document.form.jo_stl_opt_cd.value != "C"){
	    		ComShowCodeMessage("JOO00149");
	    		return;
	    	}else{
	    		//2010.04.07 기존 것을 놔둔다.
//	    		if (sheetObj.RowCount > 0){
//		    		//기존 조회건은 삭제
//		    		for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
//		    			sheetObj.CellValue(i, prefix+"del_chk") = "1";
//		    		}
//					JooRowHideDelete(sheetObj, prefix+"del_chk");
//	    		}else{
//	    			sheetObj.RemoveAll();
//	    		}
	    	}
	    }
	    
	    for(var i=0; i<rVal.length; i++){
	        item = rVal[i];
	        
	        row = UF_addRow();
	        
	        sheetObj.CellValue2(row, prefix+"vsl_cd") = item.vsl_cd;
	        sheetObj.CellValue2(row, prefix+"skd_voy_no") = item.skd_voy_no;
	        sheetObj.CellValue2(row, prefix+"skd_dir_cd") = item.skd_dir_cd;
	        sheetObj.CellValue2(row, prefix+"stl_bzc_port_cd") = item.port_cd;
	        var etbDt = (item.etb_dt).replace("/","");
	        etbDt = etbDt.substring(4,8)+etbDt.substring(0,4)+etbDt.substring(8);
	        var etdDt = (item.etd_dt).replace("/","");
	        etdDt = etdDt.substring(4,8)+etdDt.substring(0,4)+etdDt.substring(8);
	        sheetObj.CellValue2(row, prefix+"bzc_port_eta_dt") = etbDt+"00";
	        sheetObj.CellValue2(row, prefix+"bzc_port_etd_dt") = etdDt+"00";

	        sheetObj.CellValue2(row, prefix+"pop_flg")    = "1";
	        //sheetObj.CellValue2(row, prefix+"rev_dir_cd") = item.vsl_cd;
	        
	        // item 안의 속성을 이용하시면 됩니다.
	        //alert(item.vsl_cd + ":" + item.skd_voy_no + ":" + item.skd_dir_cd + ":" + item.port_cd + ":" + item.clpt_ind_seq);
	    }
	}
}

function UF_setAuth(auth, opt){
	if (auth == null || auth == undefined){
		auth = "R";
	}
	var editable = true;
	if (auth == "R"){
		editable = false;
	}
	JooSetBtnClass("C", editable);
	
	//Cycle이면서 editable이면 Create버튼을 disable 그외는 
//	if (opt == "C" && editable){
//		JooSetBtnClass("U", false);
//	}else{
		JooSetBtnClass("U", editable);
//	}
	
	for (var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Editable = editable;
	}
}

function UF_setReDivrCd(reDivrCd){
	var formObj = document.form;
	var radio = formObj.re_divr_cd;
	
	if (reDivrCd == "A"){
		ComJooRadioDisabled(radio, false);
	}else if (reDivrCd == "R"){
		formObj.re_divr_cd[0].checked = true;
		ComJooRadioDisabled(radio, true);
	}else if (reDivrCd == "E"){
		formObj.re_divr_cd[1].checked = true;
		ComJooRadioDisabled(radio, true);
	}
}


/* 개발자 작업  끝 */