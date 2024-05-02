/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_lse_0029.js
 *@FileTitle : On Hire Approval creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.06.09 진준성
 * 1.0 Creation
 * =======================================================
 * 2010.12.02 박명신 [CHM-201007443-01] Ref No. 추가
 * 2010.12.15 남궁진호 [CHM-201007751-01]IBSheet Size 수정
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
 * 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
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
 * @class ees_lse_0029 : ees_lse_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_lse_0029() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.setComboObject     = setComboObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
	this.obj_change         = obj_change;
	this.combo1_OnChange    = combo1_OnChange;
	this.combo2_OnChange    = combo2_OnChange;
	this.obj_keypress       = obj_keypress;
	this.validateForm       = validateForm;
	this.sheet1_OnChange    = sheet1_OnChange;
	this.sheet1_OnKeyDown   = sheet1_OnKeyDown;
	this.sheet1_OnPopupClick= sheet1_OnPopupClick;
	this.setPopData_AgreementVer = setPopData_AgreementVer;

}

/* 개발자 작업  */

// 공통전역변수
var vOrcCntrTpszCd = "";

var sheetObjects = new Array();
var sheetCnt = 0;

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;
var arrTpSz  = new Array();
var arrTpSz2 = new Array();
var arrTpSz3 = new Array();

var curRow = 0;
var addColCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObject.pkup_due_dt, "yyyy-MM-dd");
			
			break;

		case "New":
			formObject.loc_cd.readOnly = false;
			formObject.pkup_due_dt.readOnly = false;
			formObject.loc_cd.value           = "";
			comboObjects[0].Text              = "";
			formObject.pkup_due_dt.value      = "";
			formObject.cntr_onh_auth_no.value = "";
			formObject.term.value      = "";
			formObject.titlelist.value = "";
			formObject.reqno.value = "";
			formObject.totalqty.value = "";
			formObject.ord_yr.value = "";
			
			for(var i = 0; i < comboObjects[1].GetCount() ; i++){
				comboObjects[1].CheckIndex(i) = false;
			}

			formObject.tpsz_cd.value = "";
			sheetObject.RemoveAll();

			for(var i=0; i < arrTpSz3.length; i++){
				sheetObjects[0].ColHidden(arrTpSz3[i]) = true
			}
			formObject.apro_rmk.value = "";
			ComBtnEnable("btn1_liftOnCharge");
			ComEnableObject(formObject.btns_search1, true);
			ComEnableObject(formObject.btns_calendar1, true);
			comboObjects[0].Enable = true;
			comboObjects[1].Enable = true;
			
			formObject.pkup_due_dt.value = ComGetDateAdd(null, "D", 30);
			
			break;

		case "Row_Add":
			
			if (sheetObject.FindText("lstm", "OF") > 0) {
			    ComShowCodeMessage("LSE01156", "only ONE as 'OF' term(Input separately 'OF' and others)");				
				break;
			}
			//alert(sheetObject.ColValueDup("lstm"));

			var row = sheetObject.DataInsert();
			sheetObject.CellValue(row ,"agmt_cty_cd")    = "HHO";
			sheetObject.CellValue(row ,"onh_ord_yr")    = formObject.ord_yr.value;
			sheetObject.CellEditable(row ,"agmt_cty_cd") = false;
			sheetObject.CellEditable(row ,"lstm_cd")     = false;
			sheetObject.CellEditable(row ,"lstm")        = false;
			sheetObject.CellEditable(row ,"div_total")   = false;
			if (comboObjects[0].text != "OF"){
				sheetObject.CellEditable(row ,"loc_cod") = false;
				sheetObject.CellEditable(row ,"ecc_cd") = false;
			}else{
				sheetObject.CellEditable(row ,"loc_cod") = true;
				sheetObject.CellEditable(row ,"ecc_cd") = true;
			}

			break;

		case "Delete":
			for(var i = sheetObject.RowCount + 1 ; i > 1; i--){
				if(sheetObject.cellValue(i,1) == "1"){
					sheetObject.RowDelete(i);
				}
			}
			break;

		case "Save":
			if(ComIsBtnEnable("Save")){
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			}
			break;

		case "btns_search1":    // onh_loc_cd Pop-up
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
		break;

		
		case "btn1_liftOnCharge":    // 
		if ( srcObj.style.filter == "" ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		break;
				
		case "chk_cntr_tpsz_cd":
			/* TP/SZ 체크박스 체크시 전체체크,전체해재 기능 */
			if ( srcObj.checked ) {
				comboObjects[1].Code = vOrcCntrTpszCd.replaceStr("|", ",");
			} else {
				comboObjects[1].Code = "";
			}
			break;
		case "btn1_reqList":    // 
			openReqList();
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


function sheet1_OnLoadFinish(){
	 /* IBMulti Combo Item Setting */
    ComBtnDisable("Save");
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	initSheet(sheetObjects[0],1);
	for(var i=0; i < arrTpSz3.length; i++){
		sheetObjects[0].ColHidden(arrTpSz3[i]) = true
	}	
    this.title_color();
    sheetObjects[0].ScrollBar = 3;
    document.form.loc_cd.focus();
		 
}

function loadPage() {
	
	var formObj = document.form;

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);		 
		//sheetObjects[i].Visible = true;
		//sheetObjects[i].ExtendLastCol = true;
	}
	
	/* IBMultiCombo 초기화 */

	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	
	formObj.pkup_due_dt.value = ComGetDateAdd(null, "D", 30);
	
	/* Axon Control Setting*/
	initControl();

	var objs = document.all.item("tabLayer");
	objs.style.display = "Inline";
}

function addZero(i){
	var rtn = i + 100;
	return rtn.toString().substring(1,3);
}

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change',  'obj_change', formObj);     //- 변경될때.
	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
	axon_event.addListenerFormat('keypress','obj_keypress', formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur',  'obj_blur',   formObj);     //- 포커스 나갈때
	axon_event.addListenerFormat('focus', 'obj_focus',  formObj);     //- 포커스 들어갈때
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
	case 1:      //t1sheet1 init
	with (sheetObj) {

		// 높이 설정
		//style.height = 285;
		//전체 너비 설정

		SheetWidth = 984 ;//mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet =  msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo( 2, 1, 13, 100);
		var HeadTitleTemp  = "";
		var HeadTitle2Temp = "";
		
		for(var i=0; i<arrTpSz.length; i++){			
			HeadTitleTemp  = HeadTitleTemp  + "|" + arrTpSz[i] + "|" + arrTpSz[i] + "|" + arrTpSz[i];
			HeadTitle2Temp = HeadTitle2Temp + "|Old|L/On|New";
		}
		var HeadTitle   = "sta| |AGMT No.|AGMT No.|Ref No.|Lease\nTerm |Lessor ABBR|Order\nYear|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|P/Up LOC|Off-Hire LOC|DIV Total" + HeadTitleTemp;
		var HeadTitle2  = "sta| |AGMT No.|AGMT No.|Ref No.|Lease\nTerm |Lessor ABBR|Order\nYear|M/Year|Free Day|P/Up Charge|P/Up Credit|Min O/H Days|P/Up LOC|Off-Hire LOC|Old / New" + HeadTitle2Temp;
		
		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);
		InitHeadRow(1, HeadTitle2, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		//       (DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix])
		InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    daCenter,  true,  "ibflag");
		InitDataProperty(0, cnt++ , dtCheckBox,     20,    daCenter,  true,  "chk",                false,   "",      dfNone,        0,  true,     true);
		InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  true,  "agmt_cty_cd",        false,   "",      dfEngUpKey,    0,  true,     true , 3);
		InitDataProperty(0, cnt++ , dtPopupEdit,    80,    daCenter,  true,  "agmt_seq",           false,   "",      dfNone,        0,  true,     true , 6);
		InitDataProperty(0, cnt++ , dtData,    		100,    daLeft,   true,  "ref_no",             false,   "",      dfNone,        0,  true,     true , 6);
		InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,  "lstm",               false,   "",      dfNone,        0,  false,    true);
		InitDataProperty(0, cnt++ , dtData,         85,    daCenter,  true,  "lstm_cd",            false,   "",      dfNone,        0,  false,    true);
		InitDataProperty(0, cnt++ , dtData,         65,    daCenter,  true,  "onh_ord_yr",         false,   "",      dfNone,        0,  false,    false);
		InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,  "mft_yr",             false,   "",      dfNone,        0,  true,     true , 4);
		InitDataProperty(0, cnt++ , dtData,         65,    daRight,   true,  "free_dys",           false,   "",      dfNullInteger, 0,  true,     true , 5);
		InitDataProperty(0, cnt++ , dtData,         80,    daRight,   true,  "pkup_chg_amt",       false,   "",      dfFloat,       2,  true,     true , 8);
		InitDataProperty(0, cnt++ , dtData,         75,    daRight,   true,  "pkup_chg_cr_amt",    false,   "",      dfFloat,       2,  true,     true , 8);
		InitDataProperty(0, cnt++ , dtData,         85,    daRight,   true,  "min_onh_dys",        false,   "",      dfNullInteger, 0,  true,     true , 5);
		InitDataProperty(0, cnt++ , dtCombo,	    70,	   daCenter,  true,  "ecc_cd",				false,	 "",	  dfNone,	  	 0,	 true,	    true);
		InitDataProperty(0, cnt++ , dtCombo,		80,	   daCenter,  true,  "loc_cod",				false,	 "",	  dfNone,	  	 0,	 true,	    true);
		InitDataProperty(0, cnt++ , dtData,        100,    daCenter,  true,  "div_total",          false,   "",      dfNullInteger, 0,  false,    true);

		for(var i=0; i<arrTpSz2.length; i++){		
		    InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true,  arrTpSz2[i] + "_old", false,   "",      dfInteger, 0,  false,    true , 6);
		    InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true,  arrTpSz2[i] + "_lon", false,   "",      dfFloat,   2,  false,    true , 6);
		    InitDataProperty(0, cnt++ , dtData,         50,    daRight,   true,  arrTpSz2[i] + "_new", false,   "",      dfInteger, 0,  false,    true , 6);
		}
	
		InitDataValid(0, "agmt_seq", vtNumericOnly);
		InitDataValid(0, "mft_yr", vtNumericOnly);
		
		sheetObj.CellBackColor(0, "div_total") = sheetObj.RgbColor(176 , 196 , 222);

		SetMergeCell(0, 2, 2, 2);
		SelectBackColor = LSE_SELECT_BACK_COLOR;
		ShowButtonImage = 1;
		ScrollBar = 0;
		FrozenCols = 7;
	}
	break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSAVE:        //저장
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value = MULTI;
			var sParam = sheetObj.GetSaveString();
			sParam += "&" + FormQueryString(formObj);
			var sXml   = sheetObj.GetSaveXml("EES_LSE_0029GS.do", sParam);
			
			if(ComGetEtcData(sXml, "cntr_onh_auth_no") != undefined ){
			    ComSetObjValue(formObj.cntr_onh_auth_no, ComGetEtcData(sXml, "cntr_onh_auth_no"));
			    sheetObj.LoadSaveXml(sXml);
			    ComBtnDisable("Save");
			    ComBtnDisable("btn1_liftOnCharge");
			    ComShowCodeMessage("LSE10001");
			}else{
				sheetObj.LoadSaveXml(sXml);
			}
		}
	}
	break;

	case IBCREATE:

		comboObjects[0].InsertItem(0, 'OW','OW');
		comboObjects[0].InsertItem(1, 'LP','LP');
		comboObjects[0].InsertItem(2, 'OL','OL');
		comboObjects[0].InsertItem(3, 'LT','LT');
		comboObjects[0].InsertItem(4, 'ST','ST');
		comboObjects[0].InsertItem(5, 'OF','OF');
		comboObjects[0].InsertItem(6, 'SI','SI');

		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		//sheetObj.WaitImageVisible = true;

		if ( sXml2 != "" ) {
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");
			
			arrTpSz   =  vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2  =  vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
			var j = 0;
			for(var i = 0 ; i <  arrTpSz2.length ; i++){
				arrTpSz3[j] = arrTpSz2[i] + "_old";				
				j++;
				arrTpSz3[j] = arrTpSz2[i] + "_lon";
				j++;
				arrTpSz3[j] = arrTpSz2[i] + "_new";
				j++;
			}
		}
		

		break;

	case IBSEARCH_ASYNC02:      //조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
			for(var j = 12 ; j <= arrTpSz3.length + 11 ; j++){
		        if(sheetObj.CellValue( 1 , j ) == "L/On" ){
		        	sheetObj.CellValue( curRow , j ) = 0.00;
		        }
			}
			sheetObj.WaitImageVisible = true;			
			if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
				if(curRow != 0){
					sheetObj.CellValue(curRow , "lstm") = ComGetEtcData(sXml, "lstm_cd");
					sheetObj.CellValue(curRow , "lstm_cd") = ComGetEtcData(sXml, "vndr_abbr_nm");
					sheetObj.CellValue(curRow , "free_dys") = ComGetEtcData(sXml, "lse_free_dys");
					sheetObj.CellValue(curRow , "ref_no") = ComGetEtcData(sXml, "ref_no");
					curRow = 0;
				}
			} else {
				var errMsg = LseComGetErrMsg(sXml);
				if ( errMsg != "" ) {
					ComShowMessage(errMsg);
				}
				if(curRow != 0){
					sheetObj.CellValue2(curRow , "agmt_seq") = "";
					sheetObj.CellValue2(curRow , "lstm")     = "";
					sheetObj.CellValue2(curRow , "lstm_cd")  = "";
					sheetObj.CellValue2(curRow , "free_dys") = "";
					sheetObj.SelectCell(curRow , "agmt_seq" , false);
					curRow = 0;
				}
			}
			ComBtnEnable("Save");
		}
	}

	break;


	case IBSEARCH_ASYNC03:  // Location 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;

			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "lcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "lcc_cd") != "" ) {

						//formObj.loc_cd.value = vLocCd;
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value = "";
						//ComSetFocus(formObj.loc_cd);
					}
				} else {
					var errMsg = LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.loc_cd.value = "";
					ComSetFocus(formObj.loc_cd);
				}
			}
		}
	}
	break;

	case IBSEARCH_ASYNC04:      //DOL List 조회
		row = sheetObj.SelectRow; 
		var vAgmtSeq = sheetObj.cellValue(row,"agmt_seq");
		var vFormLoc = formObj.loc_cd.value;
		
		if(vAgmtSeq != ""){
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_LSE_0029GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			if ( sXml != "" ) {
		        //sheetObj.InitDataCombo(0, "loc_cd", ComGetEtcData(sXml, "loc_cd"), ComGetEtcData(sXml, "agmt_seq"));
				var xmlCnt    = ComGetEtcData(sXml, "total_count");
				var vloccd = "";
		        var comboLoc = ComGetEtcData(sXml, "loc_cod0");
				for(var i = 1 ; i < Number(xmlCnt) ; i++ ){
				     vloccd = ComGetEtcData(sXml, "loc_cod"+ i);
			         if(vloccd > "" ){
			        	comboLoc = comboLoc + "|" + vloccd;  
			         }
				}
		        sheetObj.InitDataCombo(0, "loc_cod", comboLoc, comboLoc);
			}
		}
		formObj.loc_cd.value = vFormLoc;
		break;
		
	case IBSEARCH_ASYNC05:      //ECC List 조회
		row = sheetObj.SelectRow; 
		var vLcccd = formObj.loc_cd.value;

		if(vLcccd != ""){
			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_LSE_0029GS.do", FormQueryString(formObj)+"&lcc_cd="+formObj.loc_cd.value);
			sheetObj.WaitImageVisible = true;
			if ( sXml != "" ) {
				var xmlCnt    = ComGetEtcData(sXml, "total_count");
				var vEcccd = "";
		        var comboEcc = ComGetEtcData(sXml, "ecc_cd0");
				for(var i = 1 ; i < Number(xmlCnt) ; i++ ){
					vEcccd = ComGetEtcData(sXml, "ecc_cd"+ i);
			         if(vEcccd > "" ){
			        	 comboEcc = comboEcc + "|" + vEcccd;  
			         }
				}
		        sheetObj.InitDataCombo(0, "ecc_cd", comboEcc, comboEcc);
			}
		}
		break;
		
	case IBSEARCH:  
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH;						
			formObj.agmt_cty_cd.value = "HHO";			
			var strAgmtSeq = "";
			for(var i = 2 ; i <= sheetObj.RowCount + 1 ; i++){
				if(i == 2){
					strAgmtSeq = sheetObj.cellValue( i , "agmt_seq" );
				}else{
					strAgmtSeq = strAgmtSeq + "|" + sheetObj.cellValue( i , "agmt_seq" );
				}
			}			
			formObj.agmt_seq.value    = strAgmtSeq;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_0029GS.do",FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			
			var strTpSZ   = formObj.tpsz_cd.value;
			var rowCnt    = ComGetEtcData(sXml, "rowCnt");

			for(var i = 0 ; i < Number(rowCnt) ; i++ ){
			     var Row1 = sheetObj.FindText("agmt_seq", LseXmlStringOfItmCnt(sXml, "agmt_seq", i), 0);
			     var strName     = LseXmlStringOfItmCnt(sXml, "cntr_tpsz_cd1", i);
			     var strTpSZCd   = LseXmlStringOfItmCnt(sXml, "cntr_tpsz_cd2", i);
			     var lOnChg      = LseXmlStringOfItmCnt(sXml, "n1st_chg_amt", i);
		         var strOldValue = sheetObj.CellValue( Row1 , strName + "_old" );
		         var OldValue = 0;
		         OldValue     =  Number(strOldValue);
		         if(OldValue > 0 ){
		             if(strTpSZ.indexOf(strTpSZCd) > -1 ){
			             sheetObj.CellValue( Row1 , strName + "_lon" ) = lOnChg;
			         }
		         }
		         OldValue = 0;
			}
			ComBtnEnable("Save");
		}
	}
	break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSAVE:      //저장
			if ( formObj.cntr_onh_auth_no.value != "" ) {
				ComShowCodeMessage("LSE01058");
				return false;
				break;
			}
			if ( formObj.loc_cd.value == "" ) {
				ComShowCodeMessage("LSE01046");
				ComSetFocus(formObj.loc_cd);
				return false;
				break;
			}
			if ( comboObjects[0].text == "" ) {
				ComShowCodeMessage("LSE01009");
				ComSetFocus(comboObjects[0]);
				return false;
				break;
			}
			if ( formObj.pkup_due_dt.value == "" ) {
				ComShowCodeMessage("LSE01049");
				ComSetFocus(formObj.pkup_due_dt);
				return false;
				break;
			}
			if ( formObj.tpsz_cd.value == "" ) {
				ComShowCodeMessage("LSE01015");
				ComSetFocus(comboObjects[1]);
				return false;
				break;
			}
			
			var vRow = sheetObj.FindText("lstm", "OF");
			if(sheetObj.CellText(vRow, "lstm")=="OF" && (sheetObj.CellText(vRow, "loc_cod") == "" || sheetObj.CellText(vRow, "ecc_cd") == "")){
				ComShowCodeMessage("LSE01156", "P/Up LOC, Off-Hire LOC.");
				return false;
				break;
			}

			if (comboObjects[0].text =="OW" || comboObjects[0].text =="LT"  || comboObjects[0].text == "ST"){
				if (formObj.reqno.value == ""){
					ComShowCodeMessage("LSE10008");
					ComSetFocus(comboObjects[0]);
					return false;
					break;
				}
			}
			var oldValue = "";
			var newValue = "";
			for(var i = 2 ; i <= sheetObj.RowCount + 1 ; i++){
				if(sheetObj.cellValue( i , "lstm" ) == ""){
					ComShowCodeMessage("LSE01009");
					sheetObj.SelectCell(i, 3, false);
					return false;
				}
				if(sheetObj.cellValue( i , "lstm" ) != comboObjects[0].Text){
					ComShowCodeMessage("LSE01056");
					sheetObj.SelectCell( i , 3 );
					return false;
				}			
			}
			
			oldValue = "";
			newValue = "";
			var iOldValue = 0;
			var iNewValue = 0;
			var strTpSzOldName = "";
			var strTpSzNewName = "";
			
			if( sheetObj.RowCount == 1 ){
				for(var i = 2 ; i <= sheetObj.RowCount + 1 ; i++){
					for(var j = 12 ; j <= arrTpSz3.length + 13 ; j++){
						 if(sheetObj.cellValue( 1 , j ) == "Old" ){
						     if(sheetObj.ColHidden(j) == false){
							     oldValue = sheetObj.cellValue( i , j );
							     newValue = sheetObj.cellValue( i , j + 2);
							     if( ( oldValue == "" || oldValue <= 0 ) && ( newValue == "" || newValue <= 0 ) ){
							    	 ComShowCodeMessage("LSE01014");
							         sheetObj.SelectCell( i , j );
							         return false;
							     }
							 }
						 }
					}
				}
			}else{
			    for(var i = 0 ; i < arrTpSz2.length ; i++){
				    if( sheetObjects[0].ColHidden(arrTpSz2[i] + "_old") == false ){
					    for(var j = 2 ; j <= sheetObj.RowCount + 1 ; j++){						 
						    strTpSzOldName = arrTpSz2[i] + "_old";
						    oldValue = sheetObj.cellValue( j , strTpSzOldName);
						    strTpSzNewName = arrTpSz2[i] + "_new";
						    newValue = sheetObj.cellValue( j , strTpSzNewName);
						 
					        iOldValue = iOldValue + Number(oldValue);
					        iNewValue = iNewValue + Number(newValue);
   					    }

					    if((iOldValue + iNewValue ) <= 0 ){						
						    ComShowCodeMessage("LSE01014");
						    sheetObj.SelectCell( 2 , strTpSzOldName );
						    return false;
					    }
					    iOldValue = 0;
					    iNewValue = 0;
				    }
			    }			
			}			
			break;
			
			case IBSEARCH: 
			    if ( formObj.loc_cd.value == "" ) {
			    	ComShowCodeMessage("LSE01046");
					ComSetFocus(formObj.loc_cd);
					return false;
					break;
			    }			
			    
			    if ( comboObjects[0].text == "" ) {
					ComShowCodeMessage("LSE01009");
					ComSetFocus(comboObjects[0]);
					return false;
					break;
				}
				if ( formObj.pkup_due_dt.value == "" ) {
					ComShowCodeMessage("LSE01049");
					ComSetFocus(formObj.pkup_due_dt);
					return false;
					break;
				}
			    
			    if ( formObj.tpsz_cd.value == "" ) {
					ComShowCodeMessage("LSE01015");
					ComSetFocus(comboObjects[1]);
					return false;
					break;
				}
			    
			    if (comboObjects[0].Text =="OW" || comboObjects[0].Text =="LT"  || comboObjects[0].Text == "ST"){
					if (formObj.reqno.value == ""){
						ComShowCodeMessage("LSE10008");
						ComSetFocus(comboObjects[0]);
						return false;
						break;
					}
				}
			    
			    if(sheetObj.RowCount  > 0){
			    
			       for(var i = 2 ; i <= sheetObj.RowCount + 1 ; i++){
			    	   if(sheetObj.cellValue( i , "agmt_seq" ) == ""){
			    		  ComShowCodeMessage("LSE01006");
						  sheetObj.SelectCell(i, "agmt_seq", false);
						  return false;
							break;
			    	  }
			      }			
			    }else{
			    	ComShowCodeMessage("LSE01048");				
					return false;
					break; 
			    }
			break;
			}
		}
	}
	return true;
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
	case "combo2":
		with(comboObj) {
			//BackColor = "cyan";
			DropHeight = 150;
			MultiSelect = true;
			MaxSelect = 30;
		}
		break;
	}
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
		var sUrl    = '/hanjin/COM_ENS_051.do';
		var iWidth  = 800;
		var iHeight = 430;
		var sTargetObjList = "lcc_cd:loc_cd";
		var sDisplay = "1,0,1,1,1,1,1,1";

		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
	}else if ( type == "2"){
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
	}
}
 
 /**
  * Agreement Pop-up Return Value 처리 부분<br>
  * @param {arry} returnedValues Pop-up 화면의 Return value array
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  * @param 대상IBSheet의 Sheet Array index
  */
  function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {			
				CellValue(Row, "agmt_seq") = Number(aryPopupData[0][4]);	
				CellValue(Row, "ref_no") = aryPopupData[0][5];	
			}
		}
	}
 
/**
 * combo item change 부분<br>
 * @param type
 * @param object 대상 Object
 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
 */
function combo1_OnChange(comboObj,value,text){
    /*
    if(text == "OW" || text == "LP" || text == "OL" ){
        //pickup due date 필수입력항목설정
        document.form.pkup_due_dt.style.cssText=" width:80; background-color:#CCFFFD;";
    }else{
        //pickup due date 필수입력항목아님설정
        document.form.pkup_due_dt.style.cssText=" width:80;; background-color:White;";
    }*/

    //setComboItem(comboObjects[0],"3");
	var sheetObject = sheetObjects[0];
	
 }

function combo2_OnChange(comboObj,value,text){
	var strTpszCd =  value.replaceStr("|", ",").split(",");
	document.form.tpsz_cd.value = strTpszCd;

	var sTpSz = document.form.tpsz_cd.value;


	for(var i=0; i<arrTpSz.length; i++){
		if(sTpSz.indexOf(arrTpSz[i])>= 0) {
			//컬럼 보이기
			sheetObjects[0].ColHidden(arrTpSz2[i] + "_old")  = false;
			sheetObjects[0].ColHidden(arrTpSz2[i] + "_new")  = false;
			sheetObjects[0].ColHidden(arrTpSz2[i] + "_lon") = false;
		} else {
			//컬럼 숨기기
			sheetObjects[0].ColHidden(arrTpSz2[i]+ "_old")  = true;
			sheetObjects[0].ColHidden(arrTpSz2[i]+ "_new")  = true;
			sheetObjects[0].ColHidden(arrTpSz2[i]+ "_lon") = true;
			
			for(var j = 2; j <= sheetObjects[0].RowCount + 1; j++){
				sheetObjects[0].CellValue(j , arrTpSz2[i]+ "_old" )  = "";
				sheetObjects[0].CellValue(j , arrTpSz2[i]+ "_new" )  = "";
				sheetObjects[0].CellValue(j , arrTpSz2[i]+ "_lon" )  = "";
			}
		}
	}
	var addCnt  = strTpszCd.length;
	var addSize = 0;
	if(document.form.tpsz_cd.value != ""){										
		if(addCnt == 1){
			sheetObjects[0].SheetWidth = 984;
		
		}else if(addCnt > 1){
			sheetObjects[0].SheetWidth = 984;	
		}else{
			var addSize   = Number(addCnt) * 150 ;
			sheetObjects[0].SheetWidth = 780 + addSize;
		}
	}else{
		sheetObjects[0].SheetWidth = 780;
	}
	ComBtnDisable("Save");
}

function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) {
		case "loc_cd":
			ComBtnDisable("Save");
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			
			break;	
			
/*		case "pkup_due_dt":

			if( formObj.pkup_due_dt.length = 8 ){
			   var strAft30 = ComGetDateAdd(null, "D", 30);
			   strAft30 = strAft30.replaceStr("-", "");	
			   
			   if( Number(formObj.pkup_due_dt.value) > Number(strAft30) ){
				   formObj.pkup_due_dt.value = "";
				   ComShowCodeMessage("LSE01156", " Pick-up Due Date less than (Today+30)");
				   ComSetFocus(formObj.pkup_due_dt);
			       return;
			   }		
			}			
			break;	*/
		}
	}
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
		if(obj.name == "loc_cd") {
            ComKeyOnlyAlphabet('uppernum');
    	}else{
    		ComKeyOnlyAlphabet('upper');
    	}
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
 * combo1_OnCheckClick
 * TP/SZ 변경시 이벤트 처리
 * 전체리스트에서 하나라도 체크 해제 되어 있으면 전체체크박스 해제, 전체가 체크되어 있어야 전체체크박스선택
 */
function combo2_OnCheckClick(comboObj, s_index, s_code) {
	/*
    var formObj = document.form;
    var arr_real_cntr_tpsz_cd = vOrcCntrTpszCd.replaceStr("|", ",").split(",")
    var arr_cntr_tpsz_cd      = comboObj.Code.split(",");
    if ( arr_real_cntr_tpsz_cd.length != arr_cntr_tpsz_cd.length) {
        formObj.chk_cntr_tpsz_cd.checked = false;
    } else {
        formObj.chk_cntr_tpsz_cd.checked = true;
    }*/
}
/**
 * sheet1_OnChange
 * 그리드 변경시 이벤트 처리
 * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
 */
function sheet1_OnChange(sheetObj,Row, Col, Value){
	var formObj  = document.form;
	if(Col == 2 || Col == 3){
		if( sheetObj.CellValue(Row , 2) != "" && sheetObj.CellValue(Row , 3) != "" ){
			formObj.agmt_cty_cd.value = sheetObj.CellValue(Row , 2);
			formObj.agmt_seq.value    = sheetObj.CellValue(Row , 3);
			//AGMT NO 중복 체크	
			/*
			var returnMsg = sheetObjects[0].ColValueDupRows("agmt_seq");
			alert(returnMsg);
			if(returnMsg != ""){
				ComShowCodeMessage("LSE01055");
				sheetObj.CellValue2(Row , "agmt_seq") = "";
				sheetObj.CellValue2(Row , "lstm")     = "";
				sheetObj.CellValue2(Row , "lstm_cd")  = "";
				sheetObj.SelectCell(Row , "agmt_seq" , false);
				return;
			}*/			
			
			var agmtNo = sheetObj.CellValue(Row , 2) + sheetObj.CellValue(Row , 3);
			var inPutAgmtNo = "";
			for(var i = 2; i <= sheetObj.RowCount + 1 ; i++){
				if( i != Row){
					inPutAgmtNo = sheetObj.CellValue( i , 2) + sheetObj.CellValue(i , 3);
					if(agmtNo == inPutAgmtNo){
						ComShowCodeMessage("LSE01055");
						sheetObj.CellValue2(Row , "agmt_seq") = "";
						sheetObj.CellValue2(Row , "lstm")     = "";
						sheetObj.CellValue2(Row , "lstm_cd")  = "";
						sheetObj.SelectCell(Row , "agmt_seq" , false);
						return;
					}
				}
			} 			
			curRow = Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);

			if(sheetObj.CellText(Row , "lstm") == "OF"){
				sheetObj.CellEditable(Row ,"loc_cod") = true;
				sheetObj.CellEditable(Row ,"ecc_cd") = true;

				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04); // DOL List			
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05); // ECC List
			}else{
				sheetObj.CellEditable(Row ,"loc_cod") = false;
				sheetObj.CellEditable(Row ,"ecc_cd") = false;
			}
			
			ComBtnDisable("Save");
		}
	}
	var old_sum = 0;
	var new_sum = 0;
	var cValue  = 0;

	if( Col > 10 && Col <= (arrTpSz3.length + 11)  ){
		for(var i = 11 ; i <= (arrTpSz3.length + 11) ; i++ ){
			if( sheetObj.CellValue(1 , i) == "Old" ){
				   cValue = sheetObj.CellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue = 0 ;
				}
				old_sum = Number(old_sum) + Number(cValue);
				
			}else if(sheetObj.CellValue(1 , i) == "New"){
				cValue = sheetObj.CellValue(Row , i);
				if(cValue == null || cValue == ""){
					cValue = 0 ;
				}
				new_sum = Number(new_sum) + Number(cValue);
			}
		}
		old_sum = add_comma(old_sum);
		new_sum = add_comma(new_sum);
		
		sheetObj.CellText(Row , "div_total") = old_sum + " / " + new_sum ;
	}

	if(Col == 8 || Col == 9){
		if(Number(Value) < 0){
			sheetObj.CellValue2(Row , Col) = Number(Value) * -1 ;
		}
	}
}

/**
 * sheet1_OnKeyDown
 * 그리드 변경시 이벤트 처리
 * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
 */
function sheet1_OnKeyDown(sheetObj,Row, Col, keyCode ){
	var formObj  = document.form;
}
 
/**
 * sheet1_OnSaveEnd
 * 그리드 저장후 이벤트 처리
 * 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if ( ErrMsg == "" ) {
		//ComShowCodeMessage("LSE10001");
	} else {
		//ComShowMessage(ErrMsg);
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
		    ComClearSeparator(event.srcElement);
		}
	} 	  
/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_blur(){
	var obj = event.srcElement;

	switch(obj.name){
	case "pkup_due_dt_none":
		//숫자이면서 천단위 구분을 하지 않는다.
		if(  Number(document.form.pkup_due_dt.value)  > 0 ){
		   var strPkupDt = ComGetNowInfo("ymd");		
		   strPkupDt = strPkupDt.replaceStr("-", "");	
		   if(  Number(document.form.pkup_due_dt.value) <  Number(strPkupDt)  ){
			   ComShowCodeMessage("LSE01026");
			   document.form.pkup_due_dt.value = "";
			   ComSetFocus(document.form.pkup_due_dt);
		       return;
		   }		
		   ComChkObjValid(obj);
		}
		break;      
/*	case "pkup_due_dt":
	    var strAft30 = ComGetDateAdd(null, "D", 30);
	    strAft30 = strAft30.replaceStr("-", "");	
	    if( Number(document.form.pkup_due_dt.value) > Number(strAft30) ){
	    	document.form.pkup_due_dt.value = "";
		    ComShowCodeMessage("LSE01156", " Pick-up Due Date less than (Today+30)");
		    ComSetFocus(document.form.pkup_due_dt);
	    }	
		ComChkObjValid(obj);
	    break;*/
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		ComChkObjValid(obj);
		break;
	}
}

/**
 * HTML Control의 Key-Down Event 처리한다.
 */
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;

	switch (obj.name) {           
	case "apro_rmk":		
		if ( event.keyCode == "229" ) {
			event.returnValue = false;
			return true;
		}
		
		if ( ComGetLenByByte(obj) > 400) {			
			ComShowCodeMessage("LSE01024");			
			return false;
		}
	}
}
 /**
  * Sheet의 OnPopupClick Event 처리부분.<br>
  * @param sheetObj
  * @param Row
  * @param Col
  */
 function sheet1_OnPopupClick(sheetObj,Row,Col) {
 	with(sheetObj) {
 		var sName = ColSaveName(Col);

 		switch(sName) {			
 		case "agmt_seq":	//Agreement No Pop-up
 		openPopup("2", Row, Col);
 		break;			
 		}
 	}
 }
  /**
   * 문자열 금액포멧처리<br>
   * @param sheetObj
   * @param Row
   * @param Col
   */
 function add_comma(strNum) {
     if (strNum.length < 1) {
	     return "0";
	 } else {
	     var tm = strNum + "";	     
	     var st = "";
	     var cm = ",";
	     for (var i = tm.length, j = 0; i > 0; i--, j++) {
	         if ((j % 3) == 2) {
	            if(tm.length == j + 1){
	                st = tm.substring(i - 1, i) + st;
	            }else{
	                st = cm + tm.substring(i - 1, i) + st;
	            }
	         } else {
	            st = tm.substring(i - 1, i) + st;
	         }
	     }
	     return st;
     }
 }    
   
   
 function title_color(){
     for(var i=0; i<arrTpSz2.length; i++){			
         sheetObjects[0].CellBackColor(0, arrTpSz2[i] + "_old") =  sheetObjects[0].RgbColor(176 , 196 , 222);
         sheetObjects[0].CellBackColor(0, arrTpSz2[i] + "_lon") =  sheetObjects[0].RgbColor(176 , 196 , 222);
         sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_old") =  sheetObjects[0].RgbColor(176 , 196 , 222);
         sheetObjects[0].CellBackColor(1, arrTpSz2[i] + "_lon") =  sheetObjects[0].RgbColor(176 , 196 , 222);
     }
 }
 
 function openReqList(){
	  var formObj = document.form;
	  var combo =   comboObjects[0];
        var sUrl    = '/hanjin/EES_LSE_0103.do';
		var iWidth  = 1020;
		var iHeight = 420;
		var sTargetObjList = "lcc:loc_cd|term:term|cre_dt:pkup_due_dt|reqno:reqno|titlelist:titlelist|totallist:totalqty|ord_yr:ord_yr";
		var sDisplay = "0,1";
		
		ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		comboObjects[0].Text = ComGetObjValue(formObj.term);
		comboObjects[1].Text = ComReplaceStr(ComGetObjValue(formObj.titlelist), "|", ",");
		var v_totalqty = form.totalqty.value;
		if (v_totalqty.charAt(v_totalqty.length-1) == ","){
			form.totalqty.value = v_totalqty.substr(0, v_totalqty.length - 1);
		}
	 
		if (ComGetObjValue(formObj.term) == "OW" || ComGetObjValue(formObj.term) == "LT" || ComGetObjValue(formObj.term) == "ST"){
			formObj.loc_cd.readOnly = true;
			comboObjects[0].Enable = false;
			formObj.pkup_due_dt.value = ComGetDateAdd(formObj.pkup_due_dt, "D", 30);
			formObj.pkup_due_dt.readOnly = true;
			ComEnableObject(formObj.btns_search1, false);
			ComEnableObject(formObj.btns_calendar1, false);
			comboObjects[1].Enable = false;
		}else {
			formObj.loc_cd.readOnly = false;
			comboObjects[0].Enable = true;
			formObj.pkup_due_dt.value = ComGetDateAdd(null, "D", 30);
			formObj.pkup_due_dt.readOnly = false;
			ComEnableObject(formObj.btns_search1, true);
			ComEnableObject(formObj.btns_calendar1, true);
			comboObjects[1].Enable = true;
		}
            
  }
 
 
/* 개발자 작업  끝 */