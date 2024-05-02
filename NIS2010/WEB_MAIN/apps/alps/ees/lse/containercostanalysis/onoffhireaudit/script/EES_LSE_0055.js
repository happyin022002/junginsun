/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName :EES_LSE_0055.js
 *@FileTitle : On off Hire Audit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.19
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.06.19 진준성
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
 * @class EES_LSE_0055 : EES_LSE_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0055() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
	this.obj_change         = obj_change;
	this.t1sheet1_OnChange  = t1sheet1_OnChange;
	this.sheet1OnSearchEnd  = sheet1OnSearchEnd;
	this.t5sheet1_OnSearchEnd  = t5sheet1_OnSearchEnd;
}

/* 개발자 작업  */

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1    = sheetObjects[0];
	var tabSheetObject1 = sheetObjects[1];
	var tabSheetObject2 = sheetObjects[2];
	var tabSheetObject3 = sheetObjects[3];
	var tabSheetObject4 = sheetObjects[4];
	var tabSheetObject5 = sheetObjects[5];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var srcObj  = window.event.srcElement;
		switch(srcName) {

		case "btn_retrieve":
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_audit");

			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();

			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			break;

		case "btn_DownExcel1":			
			tabSheetObject1.SpeedDown2Excel(-1);			
			break;			
		
		case "btn_DownExcel2":			
			tabSheetObject2.SpeedDown2Excel(-1);			
			break;
		case "btn_DownExcel3":			
			tabSheetObject3.SpeedDown2Excel(-1);			
			break;
		case "btn_DownExcel4":			
			tabSheetObject4.SpeedDown2Excel(-1);			
			break;
			
		case "btn_file":
			if ( srcObj.style.filter == "" ) {
				if( formObject.vndr_seq.value == "" ){
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObject.vndr_seq);
					return;
				}
				ComBtnDisable("btn_save");
				setNew("Y");
				openPopup("3");
			}
			break;
		case "btn_audit":
			if ( srcObj.style.filter == "" ) {
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
			    doActionIBSheet(sheetObjects[5],formObject,IBSEARCH_ASYNC04);
			    ComBtnEnable("btn_save");
			}
			break;

		case "btn_save":
			if(ComIsBtnEnable("btn_save")){
				doActionIBSheet(sheetObjects[1],formObject,IBSAVE);
			}
			break;

		case "btn_new":
			setNew();
			ComBtnDisable("btn_save");
			break;

		case "btns_calendar1":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendarFromTo();
				cal.select(formObject.search_stdt, formObject.search_endt, 'yyyy-MM-dd');
			}
			break;

		case "btns_search1":
			if ( srcObj.style.filter == "" ) {
				openPopup("2");
			}
			break;

		case "btns_search2":
			if ( srcObj.style.filter == "" ) {
				openPopup("1");
			}
			break;
		case "btn_rowInsertCoincidence":
			if(ComIsBtnEnable("btn_rowInsertCoincidence")){
			    var iRow = tabSheetObject1.DataInsert(-1);

			    tabSheetObject1.CellValue(iRow ,"ref_no" ) = sheetObject1.CellValue(1 , "ref_no");
			    tabSheetObject1.CellValue(iRow ,"vndr_seq" ) = formObject.vndr_seq.value;
			    tabSheetObject1.CellValue(iRow ,"audit_type" ) = "C";
			    tabSheetObject1.CellValue(iRow ,"lse_aud_tp_cd" ) = "C";
			    tabSheetObject1.CellValue(iRow ,"agmt_cty_cd" )   = "HHO";
			}
			break;

		case "btn_rowDeleteCoincidence":
			if(ComIsBtnEnable("btn_rowDeleteCoincidence")){
			    var checkRows    = tabSheetObject1.FindCheckedRow(1);
			    if(checkRows == ""){
			        return;
			    }
			    checkRows = checkRows.substr( 0 , checkRows.length -1 );

			    var arryCheckRow = checkRows.split("|");
			    for( var i = arryCheckRow.length ; i > 0 ; i--){
				    tabSheetObject1.RowDelete(arryCheckRow[i-1] , false);
			    }
			}
			break;
		case "btn_coincidenceDiscrepancy":
			var checkRows = tabSheetObject1.FindCheckedRow(1);
			rowDataShift( tabSheetObject2 , "D" );
			break;
		case "btn_coincidenceSML":
			rowDataShift( tabSheetObject3 , "H"  );
			break;
		case "btn_coincidenceLessor":
			rowDataShift( tabSheetObject4 , "L"  );
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

 /**
 * IBMultiCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
 function setComboObject(combo_obj){
 	comboObjects[comboCnt++] = combo_obj;
 }

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	

	/* Axon Control Setting*/
	initControl();
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_audit");
	
	/* IBMultiCombo 초기화 */

	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	ComSetFocus(document.form.vndr_seq);
}

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj); //- 변경될때.
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('keypress','obj_keypress', formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur',  'obj_blur',   formObj); //- 포커스 나갈때
	axon_event.addListenerFormat('focus', 'obj_focus',  formObj); //- 포커스 들어갈때
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch(sheetID) {
	case "sheet1":      //sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 240;
		//전체 너비 설정
		SheetWidth = 984;//mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		var HeadTitle1 = "|Seq.|AGMT No.|Contract No.|CNTR No.|TP/SZ|Lease Term|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC||||||";
		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,   0, daCenter, true,   "ibflag");
		InitDataProperty(0, cnt++ , dtSeq,           70, daCenter, true,   "seq");
		InitDataProperty(0, cnt++ , dtData,         110, daCenter, true,   "agmt_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         110, daCenter, true,   "ref_no",         false, "",   dfNone,   0,  false,    false);		
		InitDataProperty(0, cnt++ , dtData,         110, daCenter, false,  "cntr_no",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,          60, daCenter, true,   "cntr_tpsz_cd",   false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,          80, daCenter, true,   "lstm_cd",        false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         105, daCenter, true,   "lr_onh_dt",      false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         105, daCenter, true,   "lr_onh_loc_cd",  false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         105, daCenter, true,   "lr_offh_dt",     false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         105, daCenter, true,   "lr_offh_loc_cd", false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "agmt_cty_cd",    false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "agmt_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "vndr_seq",       false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "bil_fm_dt",      false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "bil_to_dt",      false, "",   dfNone,   0,  false,    false);
		InitDataProperty(0, cnt++ , dtHidden,         0, daCenter, true,   "onf_hir_sts_cd",  false, "",   dfNone,   0,  false,    false);
		SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "t1sheet1":      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 260;
		//전체 너비 설정
		SheetWidth = 790;// mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
		var HeadTitle1 = "|Sel|Seq.|AGMT No.||Contract No.|Term|CNTR No.|TP/SZ|Original\nStatus|SML Record|SML Record|SML Record|SML Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|Remark(s)||||";
		var HeadTitle2 = "|Sel|Seq.|AGMT No.||Contract No.|Term|CNTR No.|TP/SZ|Original\nStatus|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|Remark(s)||||";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

	    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    InitDataProperty(0, cnt++ , dtHiddenStatus,  0, daCenter, true,   "ibflag");
	    InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, true,   "chk",            false,  "",   dfNone,    0, true,     true);
	    InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, true,   "seq");
	    InitDataProperty(0, cnt++ , dtData,         40, daCenter, true,   "agmt_cty_cd",    false,  "",   dfNone,    0, false,   false, 3);
	    InitDataProperty(0, cnt++ , dtData,         40, daCenter, true,   "agmt_seq",       false,  "",   dfNone,    0, true,    true , 6);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "ref_no",         false,  "",   dfNone,    0, false,   false, 10);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "lstm_cd",        false,  "",   dfNone,    0, true,    true , 2);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "cntr_no",        false,  "",   dfNone,    0, true,    true , 11);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "cntr_tpsz_cd",   false,  "",   dfNone,    0, true,    true , 2);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "audit_type");
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_dt",         false,  "",   dfDateYmd, 0, true,    true);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_loc_cd",     false,  "",   dfNone,    0, true,    true , 5);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_dt",        false,  "",   dfDateYmd, 0, true,    true);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_loc_cd",    false,  "",   dfNone,    0, true,    true , 5);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_dt",      false,  "",   dfDateYmd, 0, true,    true);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_loc_cd",  false,  "",   dfNone,    0, true,    true , 5);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_dt",     false,  "",   dfDateYmd, 0, true,    true);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_loc_cd", false,  "",   dfNone,    0, true,    true , 5);	    
	    InitDataProperty(0, cnt++ , dtData,        300, daLeft,   true,   "audit_remark",   false,  "",   dfNone,    0, true,    true , 400);
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "lse_aud_tp_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "onf_hir_sts_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "vndr_seq");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_no");

	    SelectBackColor = LSE_SELECT_BACK_COLOR;
	    SetMergeCell(0, 3, 2, 2);
	    InitDataValid(0, "agmt_seq"      , vtNumericOnly);
	    InitDataValid(0, "lstm_cd"       , vtEngUpOnly);
	    InitDataValid(0, "cntr_no"       , vtEngUpOther , "0123456789");
	    InitDataValid(0, "cntr_tpsz_cd"  , vtEngUpOther , "0123456789");
	    InitDataValid(0, "onh_loc_cd"    , vtEngUpOther , "0123456789");
	    InitDataValid(0, "offh_loc_cd"   , vtEngUpOther , "0123456789");
	    InitDataValid(0, "lr_onh_loc_cd" , vtEngUpOther , "0123456789");
	    InitDataValid(0, "lr_offh_loc_cd", vtEngUpOther , "0123456789");
	    InitDataValid(0, "audit_remark"  , vtEngOther , "0123456789 -,._");
	}
	break;


	case "t2sheet1":      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 260;
		//전체 너비 설정
		SheetWidth = 790;// mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
		var HeadTitle1 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|SML Record|SML Record|SML Record|SML Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		var HeadTitle2 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, false, true, true, false, false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

	    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    InitDataProperty(0, cnt++ , dtHiddenStatus,  0, daCenter, true,   "ibflag");
	    InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, true,   "chk",            false,  "",   dfNone,    0, true,     true);
	    InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, true,   "seq");
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "agmt_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "ref_no",         false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "lstm_cd",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "cntr_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "cntr_tpsz_cd",   false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_dt",         false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_loc_cd",     false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_dt",        false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_loc_cd",    false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_dt",      false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_loc_cd",  false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_dt",     false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_loc_cd", false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "lse_aud_tp_cd");
	    InitDataProperty(0, cnt++ , dtData,       30, daCenter, true,   "onf_hir_sts_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "vndr_seq");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_cty_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_seq");
	    SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "t3sheet1":      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 260;
		//전체 너비 설정
		SheetWidth = 790;// mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
		var HeadTitle1 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|SML Record|SML Record|SML Record|SML Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		var HeadTitle2 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, false, true, true, false, false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

	    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    InitDataProperty(0, cnt++ , dtHiddenStatus,  0, daCenter, true,   "ibflag");
	    InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, true,   "chk",            false,  "",   dfNone,    0, true,     true);
	    InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, true,   "seq");
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "agmt_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "ref_no",         false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "lstm_cd",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "cntr_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "cntr_tpsz_cd",   false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_dt",         false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_loc_cd",     false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_dt",        false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_loc_cd",    false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_dt",      false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_loc_cd",  false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_dt",     false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_loc_cd", false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "lse_aud_tp_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "onf_hir_sts_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "vndr_seq");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_cty_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_seq");
	    SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "t4sheet1":      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 260;
		//전체 너비 설정
		SheetWidth = 790;// mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 3, 100);
		var HeadTitle1 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|SML Record|SML Record|SML Record|SML Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record|||||";
		var HeadTitle2 = "||Seq.|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|||||";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, false, true, true, false, false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

	    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    InitDataProperty(0, cnt++ , dtHiddenStatus,  0, daCenter, true,   "ibflag");
	    InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, true,   "chk",            false,  "",   dfNone,    0, true,     true);
	    InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, true,   "seq");
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "agmt_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "ref_no",         false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "lstm_cd",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "cntr_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "cntr_tpsz_cd",   false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_dt",         false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "onh_loc_cd",     false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_dt",        false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "offh_loc_cd",    false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_dt",      false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_onh_loc_cd",  false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_dt",     false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "lr_offh_loc_cd", false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "lse_aud_tp_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "onf_hir_sts_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "vndr_seq");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_cty_cd");
	    InitDataProperty(0, cnt++ , dtHidden,       30, daCenter, true,   "agmt_seq");
	    SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;

	case "t5sheet1":      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 260;
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
		var HeadTitle1 = "|Seq.|AUDIT Type|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|SML Record|SML Record|SML Record|SML Record|Lessor Record|Lessor Record|Lessor Record|Lessor Record||||";
		var HeadTitle2 = "|Seq.|AUDIT Type|AGMT No.|Contract No.|Term|CNTR No.|TP/SZ|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC|On-hire Date|On-hire LOC|Off-hire Date|Off-hire LOC||||";

		var headCount = ComCountHeadTitle(HeadTitle1);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    InitDataProperty(0, cnt++ , dtHiddenStatus,  0, daCenter, true,   "ibflag");
	    InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, true,   "seq");
	    InitDataProperty(0, cnt++ , dtData,         30, daCenter, true,   "lse_aud_tp_cd");
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "agmt_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "ref_no",         false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "lstm_cd",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         80, daCenter, true,   "cntr_no",        false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         50, daCenter, true,   "cntr_tpsz_cd",   false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "onh_dt",         false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "onh_loc_cd",     false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "offh_dt",        false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "offh_loc_cd",    false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "lr_onh_dt",      false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "lr_onh_loc_cd",  false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "lr_offh_dt",     false,  "",   dfDateYmd, 0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "lr_offh_loc_cd", false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "onf_hir_sts_cd", false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "vndr_seq",       false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "agmt_cty_cd",    false,  "",   dfNone,    0, false,    false);
	    InitDataProperty(0, cnt++ , dtData,         85, daCenter, true,   "agmt_seq",       false,  "",   dfNone,    0, false,    false);
	}
	break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {
	case IBSEARCH:      //조회
	formObj.f_cmd.value = SEARCH;
	if(validateForm(sheetObj,formObj,sAction)){

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("EES_LSE_0055GS.do" , FormQueryString(formObj));
		//ComOpenWait(false);

		var arrXml = sXml.split("|$$|");
		//ComOpenWait(true);
        for( var i = 0 ; i < arrXml.length ; i++ ){
        	sheetObjects[i].WaitImageVisible = false;
            sheetObjects[i].LoadSearchXml(arrXml[i]);
        }
        ComOpenWait(false);
	}
	break;

	case IBSAVE:        //저장
	
	sheetObj.WaitImageVisible = false;
	ComOpenWait(true);
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "t1sheet1") {

			formObj.f_cmd.value = MULTI;
			var sParam1 = sheetObjects[1].GetSaveString(true);
			var sParam2 = sheetObjects[2].GetSaveString(true);
			var sParam3 = sheetObjects[3].GetSaveString(true);
			var sParam4 = sheetObjects[4].GetSaveString(true);
			sParam = sParam1 +  "&" + sParam2 +  "&" + sParam3 +  "&" + sParam4 +  "&" + FormQueryString(formObj);
			var sXml   = sheetObj.GetSaveXml("EES_LSE_0055GS.do", sParam);
			sheetObjects[1].LoadSaveXml(sXml);
		}
	}
	ComOpenWait(false);
	sheetObj.WaitImageVisible = true;
	break;

	case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
	if ( validateForm(sheetObj, formObj, sAction) ) {
		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
		sheetObj.WaitImageVisible = true;

		if ( sXml != "" ) {
			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				ComSetFocus(formObj.vndr_nm);
                doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			} else {
				ComShowCodeMessage("LSE01019");
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value  = "";
				ComSetFocus(formObj.vndr_seq);
			}
		} else {
			ComShowCodeMessage("LSE01019");
			formObj.vndr_seq.value = "";
			formObj.vndr_nm.value  = "";
			ComSetFocus(formObj.vndr_seq);
		}
	}
	break;

	case IBSEARCH_ASYNC02:      //AGMT NO 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		formObj.f_cmd.value = SEARCH03;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;
		if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
			formObj.lstm_cd.value = ComGetEtcData(sXml, "lstm_cd");
		} else {
			var errMsg = LseComGetErrMsg(sXml);
			if ( errMsg != "" ) {
				ComShowMessage(errMsg);
			}
			formObj.agmt_seq.value = "";
			formObj.lstm_cd.value = "";
		}
	}
	break;

	case IBSEARCH_ASYNC03:      //Version List 조회
	    if(validateForm(sheetObj,formObj,sAction)){
		    formObj.f_cmd.value = SEARCH01;
		    sheetObj.WaitImageVisible = false;
		    var sXml = sheetObj.GetSearchXml("EES_LSE_0055GS.do", FormQueryString(formObj));
		    sheetObj.WaitImageVisible = true;
		    if ( sXml != "" ) {
			    ComXml2ComboItem(sXml, comboObjects[0], "aud_ver_seq", "audit_version");
			    sheetObjects[0].RemoveAll();
			    sheetObjects[1].RemoveAll();
			    sheetObjects[2].RemoveAll();
			    sheetObjects[3].RemoveAll();
			    sheetObjects[4].RemoveAll();
			    sheetObjects[5].RemoveAll();
		    }
	    }
	break;

	case IBSEARCH_ASYNC04:	//Audit & Result
	    formObj.f_cmd.value = SEARCH02;
	    if(validateForm(sheetObj,formObj,sAction)){
		    formObj.ref_no.value = sheetObjects[0].CellValue(1 , "ref_no");
		    sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
		    var sXml = sheetObj.GetSearchXml("EES_LSE_0055GS.do" , FormQueryString(formObj));
		    var arrXml = sXml.split("|$$|");
		    for( var i = 0 ; i < arrXml.length ; i++ ){
		        sheetObjects[i + 1].LoadSearchXml(arrXml[i]);
		    }
		    ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
	    }
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
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt  = 0 ;
			InsertTab( cnt++ , "Coincidence" , -1 );
			InsertTab( cnt++ , "Discrepancy" , -1 );
			InsertTab( cnt++ , "SML Only" , -1 );
			InsertTab( cnt++ , "Lessor Only" , -1 );
			//InsertTab( cnt++ , "Total" , -1 );
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
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //조회

			    if ( formObj.vndr_seq.value == ""  ) {
				    ComShowCodeMessage("LSE01044");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
			    }
			    if ( comboObjects[0].text == "" ) {
				    ComShowCodeMessage("LSE01085");
				    ComSetFocus(formObj.aud_ver_seq);
				    return false;
				    break;
			    }

			    return true;
			break;

			case IBSEARCH_ASYNC04:
				if ( formObj.vndr_seq.value == ""  ) {
				    ComShowCodeMessage("LSE01044");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
			    }
				if ( comboObjects[0].text == "" ) {
				    ComShowCodeMessage("LSE01085");
				    ComSetFocus(formObj.aud_ver_seq);
				    return false;
				    break;
			    }

				var periodStdt = formObj.search_stdt.value;
    			periodStdt = periodStdt.replaceStr("-","");
    			var periodEtdt = formObj.search_endt.value;
    			periodEtdt = periodEtdt.replaceStr("-","");

    			if ( periodStdt == "" ) {
    				ComShowCodeMessage("LSE01010");
    				ComSetFocus(formObj.search_stdt);
    				return false;
    				break;
    			}
    			if ( periodEtdt == "" ) {
    				ComShowCodeMessage("LSE01011");
    				ComSetFocus(formObj.search_endt);
    				return false;
    				break;
    			}
    			if ( Number(periodStdt) > Number(periodEtdt)) {
    				ComShowCodeMessage("LSE01051");
    				ComSetFocus(formObj.search_stdt);
    				return false;
    				break;
    			}

				if(sheetObjects[0].RowCount <= 0){
					ComShowCodeMessage("LSE01048");
				    ComSetFocus(formObj.vndr_seq);
				    return false;
				    break;
				}
				return true;
			break;

			case IBSAVE:
				var chkValidate = true;
				for(var i = 2 ; i <= sheetObjects[1].LastRow ; i++ ){
					if(sheetObjects[1].CellValue(i , "agmt_seq") == ""){
			        	//alert("1");
						ComShowCodeMessage("LSE01006");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "agmt_seq");
			        	break;
			        	return false;
			        }
			        if(sheetObjects[1].CellValue(i , "lstm_cd") == ""){
			        	//alert("2");
			        	ComShowCodeMessage("LSE01009");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "lstm_cd");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "lstm_cd").length != 2){
			        	//alert("3");
			        	ComShowCodeMessage("LSE01056");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "lstm_cd");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "cntr_no") == ""){
			        	//alert("4");
			        	ComShowCodeMessage("LSE01064");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "cntr_no");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "cntr_no").length != 11){
			        	//alert("5");
			        	ComShowCodeMessage("LSE01074");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "cntr_no");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "cntr_tpsz_cd") == ""){
			        	//alert("6");
			        	ComShowCodeMessage("LSE01015");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "cntr_tpsz_cd");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "cntr_tpsz_cd").length != 2){
			        	//alert("7");
			        	ComShowCodeMessage("LSE01038");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "cntr_tpsz_cd");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "onh_dt") == ""){
			        	//alert("8");
			        	ComShowCodeMessage("LSE01063");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "onh_dt");
			            break;
			            return false;
			        }
			        if(sheetObjects[1].CellValue(i , "onh_loc_cd").length > 5){
			        	//alert("10");
			        	ComShowCodeMessage("LSE01037");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "onh_loc_cd");
			            break;
			            return false;
			        }

			        // 2010.03.29 by 정필성 차장님 : Audit Type 이 On Hire Audit 일 경우 offh_dt 검증 삭제
			        /*
			        if(document.form.audit_tp[1].checked == true){
			        	if(sheetObjects[1].CellValue(i , "offh_dt") != ""){
			            	//alert("11-1");
			            	ComShowCodeMessage("LSE01089");
			        	    chkValidate = false;
			        	    sheetObjects[1].SelectCell(i , "offh_dt");
			        	    break;
			        	    return false;
			        	}
			        }else
			        */
			        if( document.form.audit_tp[2].checked == true ){
			            if(sheetObjects[1].CellValue(i , "offh_dt") == ""){
			            	//alert("11");
			            	ComShowCodeMessage("LSE01088");
			        	    chkValidate = false;
			        	    sheetObjects[1].SelectCell(i , "offh_dt");
			        	    break;
			        	    return false;
			        	}

			            if(sheetObjects[1].CellValue(i , "offh_loc_cd").length > 5){
			               //alert("13");
			               ComShowCodeMessage("LSE01037");
			        	   chkValidate = false;
			        	   sheetObjects[1].SelectCell(i , "offh_loc_cd");
			               break;
			               return false;
			            }
			        }

			        if(sheetObjects[1].CellValue(i , "lr_onh_dt") == ""){
			        	//alert("14");
			        	ComShowCodeMessage("LSE01063");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "lr_onh_dt");
			            break;
			            return false;
			        }

			        if(sheetObjects[1].CellValue(i , "lr_onh_loc_cd").length > 5){
			        	//alert("16");
			        	ComShowCodeMessage("LSE01037");
			        	chkValidate = false;
			        	sheetObjects[1].SelectCell(i , "lr_onh_loc_cd");
			            break;
			            return false;
			        }

			        // 2010.03.29 by 정필성 차장님 : Audit Type 이 On Hire Audit 일 경우 lr_offh_dt 검증 삭제
			        /*
			        if(document.form.audit_tp[1].checked == true){
			        	if(sheetObjects[1].CellValue(i , "lr_offh_dt") != ""){
			            	//alert("17-1");
			            	ComShowCodeMessage("LSE01087");
			                chkValidate = false;
			                sheetObjects[1].SelectCell(i , "lr_offh_dt");
			                break;
			                return false;
			            }
			        }else
			        */
			        if ( document.form.audit_tp[2].checked == true ) {
			            if(sheetObjects[1].CellValue(i , "lr_offh_dt") == ""){
			            	//alert("17");
			            	ComShowCodeMessage("LSE01088");
			                chkValidate = false;
			                sheetObjects[1].SelectCell(i , "lr_offh_dt");
			                break;
			                return false;
			            }
			            if(sheetObjects[1].CellValue(i , "lr_offh_loc_cd").length > 5){
			            	//alert("19");
			            	ComShowCodeMessage("LSE01037");
			                chkValidate = false;
			                sheetObjects[1].SelectCell(i , "lr_offh_loc_cd");
			                break;
			                return false;
			            }
			        }

	                var onhDt     =  sheetObjects[1].CellValue(i , "onh_dt");
	                var lrOnhDt   =  sheetObjects[1].CellValue(i , "lr_onh_dt");
	                var offhDt    =  sheetObjects[1].CellValue(i , "offh_dt");
	                var lrOffhDdt =  sheetObjects[1].CellValue(i , "lr_offh_dt");

	                var searchStdt = formObj.search_stdt.value.replaceStr("-" , "");;
	                var searchEndt = formObj.search_endt.value.replaceStr("-" , "");;

	                // 2010.03.29 BY 정필성 차장님 : On-Hire Audit 일 경우 On-Hire Date 만 검증
	                if ( document.form.audit_tp[1].checked == true ) {
		                if(Number(onhDt) > Number(searchEndt)){
		                	//alert("20-1");
		                	ComShowCodeMessage("LSE01086");
		                	chkValidate = false;
		                	sheetObjects[1].SelectCell(i , "onh_dt");
				            break;
				            return false;
		                }
	                }

	                // 2010.03.29 BY 정필성 차장님 : Off-Hire Audit 일 경우 Off-Hire Date 만 검증
	                if ( document.form.audit_tp[2].checked == true ) {
		                if ( offhDt != "" ) {
		                    if( Number(searchStdt) > Number(offhDt) || Number(offhDt) > Number(searchEndt) ){
		                	    ComShowCodeMessage("LSE01087");
		                	    chkValidate = false;
		                	    sheetObjects[1].SelectCell(i , "offh_dt");
				                break;
				                return false;
		                   }
		                }
	                }

	                if ( sheetObjects[1].CellValue(i , "onh_dt") != "" && sheetObjects[1].CellValue(i , "offh_dt") != "" ) {

	                	if(Number(onhDt) > Number(offhDt)){
	                	    ComShowCodeMessage("LSE01086");
	                	    chkValidate = false;
	                	    sheetObjects[1].SelectCell(i , "onh_dt");
			                break;
			                return false;
	                    }
	                }

	                if ( document.form.audit_tp[1].checked == true ) {
		                if(onhDt != lrOnhDt ){
		                	ComShowCodeMessage("LSE01086");
		                	chkValidate = false;
		                	sheetObjects[1].SelectCell(i , "onh_dt");
				            break;
				            return false;
		                }
	                }

	                if ( document.form.audit_tp[2].checked == true ) {
                        if(offhDt != lrOffhDdt){
                        	//alert("21");
                        	ComShowCodeMessage("LSE01087");
	                	    chkValidate = false;
	                	    sheetObjects[1].SelectCell(i , "offh_dt");
	                	    break;
	                	    return false;
                        }
	                }
			    }

			    if(chkValidate == true){
			        return true;
			    }else{
			        return false;
			    }
			break;
			}
		}
	}
	return true;
}
function obj_keypress() {
	var obj = event.srcElement;
	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	default:
		ComKeyOnlyNumber(obj);
	break;
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_blur(){
	var obj = event.srcElement;

	switch(obj.name){
	case "search_stdt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "search_endt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "vndr_seq":
	    if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
	    	document.form.vndr_nm.value = ""
		}
		break;
	case "agmt_seq":
	    if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
	        document.form.lstm_cd.value = "";
		}
		break;

	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		break;
	}
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_focus(){
	var obj  = event.srcElement;
	if( obj.readOnly ) {
		ComSetNextFocus(obj);
	} else {
		//마스크구분자 없애기
		if(obj.name == "period_stdt" ||  obj.name == "period_eddt"){
		    if(obj.value.length == 10 ){
		         ComClearSeparator(event.srcElement);
			}
		}    
	}
}

function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) {
		case "agmt_seq":
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
			break;

		case "search_stdt":		//Location Code
	        if(formObj.search_endt.value != ""){
	            checkEffectiveDate( formObj.search_stdt , formObj.search_endt ) ;
	        }
	        break;

	    case "search_endt":		//Location Code
            checkEffectiveDate( formObj.search_stdt , formObj.search_endt ) ;
            break;

		case "vndr_seq":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();

			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
			break;
		}
	}
}

/**
 * 마지막 일자 구하기
 */
function GetLastDay(yyyy, mm) {
	var m = parseInt(mm,10) - 1;
	var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if ((yyyy % 4 == 0 && yyyy % 100 != 0) || yyyy % 400 == 0) {
		end[1] = 29;
	}
	return end[m];
}
/**
 * Pop-up Open 부분<br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
 * @param object 대상 Object
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 */
function openPopup(type, Row, Col) {
	var formObj = document.form;
	if ( type == "1" ) {
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setAgmtNo', '1,0', true);
	}else if ( type == "2" ) {
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	}else if ( type == "3" ) {
		ComOpenPopup('/hanjin/EES_LSE_0056.do', 820, 450, '', '1,0,1,1,1,1,1,1', false);
	}
}
/**
 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
 * @param {arry} returnedValues Pop-up 화면의 Return value array
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
 * @param 대상IBSheet의 Sheet Array index
 */
function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj = sheetObjects[SheetIdx];
	var formObj  = document.form;

	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
		formObj.vndr_nm.value  = aryPopupData[0][4];
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
	}
}
 /**
  * Agmt No(Service Provider) Pop-up Return Value 처리 부분<br>
  * @param {arry} returnedValues Pop-up 화면의 Return value array
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  * @param 대상IBSheet의 Sheet Array index
  */
function setAgmtNo(aryPopupData, Row, Col, SheetIdx) {
	document.form.agmt_seq.value = aryPopupData[0][4];
	document.form.lstm_cd.value  = aryPopupData[0][6];
}

/**
*  import한 파일 저장후 재조회 0056에서 호출
*/
function searchForSave(){
	var formObj = document.form;
	formObj.search_stdt.value   = "";
	formObj.search_endt.value   = "";

	formObj.agmt_seq.value      = "";
	formObj.lstm_cd.value       = "";
	//formObj.audit_tp[0].checked = true;
	formObj.audit_tp[1].checked = true;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	comboObjects[0].CheckIndex(0) = true;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}

/**
* 콤보 초기설정값, 헤더 정의
* param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initCombo(comboObj, comboNo) {
	switch(comboObj.id) {
	case "combo1":
		with(comboObj) {
			//BackColor = "cyan";
			DropHeight = 150;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	}
}

/**
* 화면을 초기화한다.
*/
function setNew(importYN){
	var sheetObject1    = sheetObjects[0];
	var tabSheetObject1 = sheetObjects[1];
	var tabSheetObject2 = sheetObjects[2];
	var tabSheetObject3 = sheetObjects[3];
	var tabSheetObject4 = sheetObjects[4];
	var tabSheetObject5 = sheetObjects[5];
	var formObject = document.form;
    sheetObject1.RemoveAll();
    tabSheetObject1.RemoveAll();
    tabSheetObject2.RemoveAll();
    tabSheetObject3.RemoveAll();
    tabSheetObject4.RemoveAll();
    tabSheetObject5.RemoveAll();
    formObject.search_stdt.value   = "";
    formObject.search_endt.value   = "";

    if(importYN != "Y" ){
        formObject.vndr_seq.value      = "";
        formObject.vndr_nm.value       = "";
        comboObjects[0].RemoveAll();
    }
    formObject.agmt_seq.value      = "";
    formObject.lstm_cd.value       = "";
    formObject.ref_no.value      = "";
    //formObject.audit_tp[0].checked = true;
    formObject.audit_tp[1].checked = true;
	ComEnableObject(formObject.vndr_seq, true);
	formObject.vndr_seq.className = "input1";
	ComEnableObject(formObject.btns_search1, true);
	ComEnableObject(formObject.agmt_seq, true);
	ComEnableObject(formObject.btns_search2, true);
	ComEnableObject(formObject.btns_calendar1, true);
	ComEnableObject(formObject.search_stdt, true);
	ComEnableObject(formObject.search_endt, true);
	formObject.search_stdt.className = "input1";
	formObject.search_endt.className = "input1";
	formObject.audit_tp[0].disabled = true;
	formObject.audit_tp[1].disabled = false;
	formObject.audit_tp[2].disabled = false;
	comboObjects[0].Enable = true;
    ComSetFocus(document.form.vndr_seq);
}

/**
* t5sheet1_OnSearchEnd
* 그리드 조회 후 이벤트 처리
* 그리드 hidden 그리드의 조회내용을 lse_aud_tp_cd에 따라 각시트에 분배한다.
*/
function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComBtnEnable("btn_save");
}
/**
* rowDataShift
* 각 그리드에서 Coincidence 로 행이동
*/
function rowDataShift( shiftObj , tabGubun){

	var checkRows    = shiftObj.FindCheckedRow(1);
	if(checkRows == ""){
	    return;
	}

	var checkRows = shiftObj.FindCheckedRow(1);
	if(checkRows.length > 0){
	  checkRows = checkRows.substr( 0 , checkRows.length -1 );
	}
	var arryCheckRow = checkRows.split("|");
	var iRow;

	for( var i = arryCheckRow.length ; i > 0 ; i--){

		iRow = sheetObjects[1].DataInsert(-1);

		sheetObjects[1].CellValue( iRow , "agmt_no")        = shiftObj.CellValue(arryCheckRow[i-1] , "agmt_no");
		sheetObjects[1].CellValue( iRow , "ref_no")         = shiftObj.CellValue(arryCheckRow[i-1] , "ref_no");
		sheetObjects[1].CellValue( iRow , "lstm_cd")        = shiftObj.CellValue(arryCheckRow[i-1] , "lstm_cd");
		sheetObjects[1].CellValue( iRow , "cntr_no")        = shiftObj.CellValue(arryCheckRow[i-1] , "cntr_no");
		sheetObjects[1].CellValue( iRow , "cntr_tpsz_cd")   = shiftObj.CellValue(arryCheckRow[i-1] , "cntr_tpsz_cd");
		sheetObjects[1].CellValue( iRow , "onh_dt")         = shiftObj.CellValue(arryCheckRow[i-1] , "onh_dt");
		sheetObjects[1].CellValue( iRow , "onh_loc_cd")     = shiftObj.CellValue(arryCheckRow[i-1] , "onh_loc_cd");
		sheetObjects[1].CellValue( iRow , "offh_dt")        = shiftObj.CellValue(arryCheckRow[i-1] , "offh_dt");
		sheetObjects[1].CellValue( iRow , "offh_loc_cd")    = shiftObj.CellValue(arryCheckRow[i-1] , "offh_loc_cd");
		sheetObjects[1].CellValue( iRow , "lr_onh_dt")      = shiftObj.CellValue(arryCheckRow[i-1] , "lr_onh_dt");
		sheetObjects[1].CellValue( iRow , "lr_onh_loc_cd")  = shiftObj.CellValue(arryCheckRow[i-1] , "lr_onh_loc_cd");
		sheetObjects[1].CellValue( iRow , "lr_offh_dt")     = shiftObj.CellValue(arryCheckRow[i-1] , "lr_offh_dt");
		sheetObjects[1].CellValue( iRow , "lr_offh_loc_cd") = shiftObj.CellValue(arryCheckRow[i-1] , "lr_offh_loc_cd");
		sheetObjects[1].CellValue( iRow , "onf_hir_sts_cd") = shiftObj.CellValue(arryCheckRow[i-1] , "onf_hir_sts_cd");
		sheetObjects[1].CellValue( iRow , "lse_aud_tp_cd")  = "C";
		sheetObjects[1].CellValue( iRow , "audit_type")       = tabGubun;
		sheetObjects[1].CellValue( iRow , "vndr_seq")       = shiftObj.CellValue(arryCheckRow[i-1] , "vndr_seq");
		sheetObjects[1].CellValue( iRow , "agmt_cty_cd")    = shiftObj.CellValue(arryCheckRow[i-1] , "agmt_cty_cd");
		sheetObjects[1].CellValue( iRow , "agmt_seq")       = shiftObj.CellValue(arryCheckRow[i-1] , "agmt_seq");

		shiftObj.RowDelete(arryCheckRow[i-1] , false);
	}
}
/**
* t1sheet1_OnSaveEnd
* 그리드 저장후 이벤트 처리
* 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
*/

function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj  = document.form;
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
	} else {
		ComShowMessage(ErrMsg);
	}
	ComEnableObject(formObj.vndr_seq, false);
	formObj.vndr_seq.className = "input2";
	ComEnableObject(formObj.btns_search1, false);
	ComEnableObject(formObj.agmt_seq, false);
	ComEnableObject(formObj.btns_search2, false);
	ComEnableObject(formObj.btns_calendar1, false);
	ComEnableObject(formObj.search_stdt, false);
	ComEnableObject(formObj.search_endt, false);
	formObj.search_stdt.className = "input2";
	formObj.search_endt.className = "input2";
	formObj.audit_tp[0].disabled = true;
	formObj.audit_tp[1].disabled = true;
	formObj.audit_tp[2].disabled = true;
	comboObjects[0].Enable = false;
}

/**
* sheet1_OnSearchEnd
* 그리드 조회 후 이벤트 처리
* 그리드 hidden 그리드의 조회내용을 lse_aud_tp_cd에 따라 각시트에 분배한다.
*/

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj  = document.form;
	var strBilFmDt = sheetObjects[0].CellValue(1 , "bil_fm_dt");
	var strBilToDt = sheetObjects[0].CellValue(1 , "bil_to_dt");
	var strAuditType = sheetObjects[0].CellValue(1 , "onf_hir_sts_cd");

	if(strBilFmDt != "" && strBilToDt != ""){
		formObj.search_stdt.value  = strBilFmDt;
		formObj.search_endt.value  = strBilToDt;
		ComBtnDisable("btn_audit");
		if(strAuditType == "N"){
		    formObj.audit_tp[1].checked = true;
		}else if(strAuditType == "F"){
		    formObj.audit_tp[2].checked = true;
		}
		ComEnableObject(formObj.vndr_seq, false);
		formObj.vndr_seq.className = "input2";
		ComEnableObject(formObj.btns_search1, false);
		ComEnableObject(formObj.agmt_seq, false);
		ComEnableObject(formObj.btns_search2, false);
		ComEnableObject(formObj.btns_calendar1, false);
		ComEnableObject(formObj.search_stdt, false);
		ComEnableObject(formObj.search_endt, false);
		formObj.search_stdt.className = "input2";
		formObj.search_endt.className = "input2";
		formObj.audit_tp[0].disabled = true;
		formObj.audit_tp[1].disabled = true;
		formObj.audit_tp[2].disabled = true;
		comboObjects[0].Enable = false;

	}else{
		ComBtnEnable("btn_audit");
		ComEnableObject(formObj.vndr_seq, true);
		formObj.vndr_seq.className = "input1";
		ComEnableObject(formObj.btns_search1, true);
		ComEnableObject(formObj.agmt_seq, true);
		ComEnableObject(formObj.btns_search2, true);
		ComEnableObject(formObj.btns_calendar1, true);
		ComEnableObject(formObj.search_stdt, true);
		ComEnableObject(formObj.search_endt, true);
		document.form.search_stdt.className = "input1";
		document.form.search_endt.className = "input1";
		formObj.audit_tp[0].disabled = true;
		formObj.audit_tp[1].disabled = false;
		formObj.audit_tp[2].disabled = false;
		comboObjects[0].Enable = true;
	}
}

/**
* t1sheet1_OnChange
* 그리드 변경시 이벤트 처리
* 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
*/
/*
function t1sheet1_OnChange(sheetObj,Row, Col, Value){
	var formObj  = document.form;
}*/

/**
* combo item change 부분<br>
* @param type
* @param object 대상 Object
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
*/
function aud_ver_seq_OnChange(comboObj,value,text){
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
}
/* 개발자 작업  끝 */