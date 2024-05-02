/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0047.js
 *@FileTitle : Pick-up Status by Auth No
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 진준성
 *@LastVersion : 1.0
 * 2009.06.30 진준성
 * 1.0 Creation
 * 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
 * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
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
 * @class EES_LSE_0047 : EES_LSE_0047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_LSE_0047() {
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
	this.obj_keypress       = obj_keypress;
	this.validateForm       = validateForm;
	this.loc_tp_OnChange    = loc_tp_OnChange;
	this.sheet1_OnSort      = sheet1_OnSort;
	this.sheet1_OnDblClick  = sheet1_OnDblClick;
	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
	this.combo1_OnBlur 			= combo1_OnBlur;
	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
	this.combo2_OnCheckClick 	= combo2_OnCheckClick;	
	this.combo2_OnBlur 			= combo2_OnBlur;	
	this.combo2_OnKeyDown 		= combo2_OnKeyDown;	
}

/* 개발자 작업	*/

//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

//Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

var arrTpSz  = new Array();
var arrTpSz2 = new Array();


//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
	axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
}

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcObj  = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

		case "btns_search1":   // onh_loc_cd Pop-up
		if ( srcObj.style.filter == "" ) {
			openPopup("1");
		}
		break;

		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObject.period_stdt, "yyyy-MM-dd");
			break;

		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendarFromTo();
				cal.select(formObject.period_stdt, formObject.period_eddt, 'yyyy-MM-dd');				
			}
			break;			
		case "btns_calendar3":
			var cal = new ComCalendar();
			cal.select(formObject.pkup_due_dt, "yyyy-MM-dd");
			break;

		case "btns_search2":			 
			if ( srcObj.style.filter == "" ) {
				openPopup("2");
			}
			break;	

		case "btn_Retrieve":
			if ( srcObj.style.filter == "" ) {
				sheetObject1.RemoveAll();	
				sheetObject2.RemoveAll();	
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			}
			break; 

		case "btn_New":			
			sheetObject1.RemoveAll();
			sheetShowInit();
			sheetObject2.RemoveAll();
			formObject.loc_cd.value = "";
			formObject.loc_tp[0].selected = true;
			formObject.period_stdt.value = "";
			formObject.period_eddt.value = "";
			formObject.auth_no.value = "";
			for(var i = 1 ; i < comboObjects[0].GetCount(); i++ ){
				comboObjects[0].CheckIndex(i)=false;
			}
			formObject.lstm_cd.value = "";
			for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
				comboObjects[1].CheckIndex(i)=false;
			}
			comboObjects[0].CheckIndex(0) = true;
			comboObjects[1].CheckIndex(0) = true;
			formObject.cntr_tpsz_cd.value = "";
			formObject.agmt_seq.value = "";
			formObject.vndr_seq.value = "";
			formObject.vndr_abbr_nm.value = "";
			formObject.vndr_nm.value = "";
			formObject.pkup_due_dt.value = "";
			formObject.new_van_tp_cd[0].checked = true;
			formObject.period_stdt.focus();
			break;

		case "btn_Save":
			alert(srcName);
			break; 

		case "btn_Detail":
			alert(srcName);
			break; 				
		case "btn_downexcel_summary":
			if(sheetObject1.RowCount > 0){
				//sheetObject1.SpeedDown2Excel(-1);  
				sheetObject1.Down2Excel(-1, false, false, true);  
			}
			break; 			
		case "btn_downexcel_detail":
			if(sheetObject2.RowCount > 0){
				sheetObject2.SpeedDown2Excel(-1);  
			}
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();

	/* IBMultiCombo 초기화 */
	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
		initCombo(comboObjects[k], k+1);
	}
	sheetShowInit();
}

function sheet1_OnLoadFinish(){
	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);		
	initSheet(sheetObjects[0],1);
	comboObjects[0].CheckIndex(0) = true;
	comboObjects[1].CheckIndex(0) = true;				
	document.form.period_stdt.focus();
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
	case "sheet1":      //sheet2 init
	with (sheetObj) {

		// 높이 설정
		//style.height = 250;
		//전체 너비 설정
		SheetWidth =  984;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 10, 100);
		var HeadTitleTemp  = "";
		for(var i=0; i<arrTpSz.length; i++){	
			HeadTitleTemp = HeadTitleTemp + "|" + arrTpSz[i];
		}
		var HeadTitle = "|Auth No.|AGMT No.|Lessor|Contract No|Ref. No|Division|Total" + HeadTitleTemp;
		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, false, true, false,false);

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,   0, daCenter,	 true,  "Status");
		InitDataProperty(0, cnt++ , dtData,         120, daCenter,	 true,  "auth_no",   false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,          80, daCenter,	 true,  "agmt_no",   false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,         120, daCenter,	 true,  "vndr_abbr_nm",   false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,          80, daCenter,	 true,  "ctrt_no",   false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,          90, daCenter,	 true,  "ref_no",    false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,          60, daCenter, 	 false, "divsion",   false,	"",	dfNone,		0,	true, true);
		InitDataProperty(0, cnt++ , dtData,          50, daRight,	 true,  "qty_total", false,	"",	dfNullInteger,	0,	true, true);
		for(var i=0; i<arrTpSz2.length; i++){	
			InitDataProperty(0, cnt++ , dtData,          50, daRight,	 true, arrTpSz2[i] + "", false,	"",	dfNullInteger,  0,	true, true);
		}		
		SelectBackColor = LSE_SELECT_BACK_COLOR;
		FrozenCols = 8;
	}
	break;
	case "sheet2":      //sheet1 init
	with (sheetObj) {

		// 높이 설정
		style.height = 180;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 3, 100);

		var HeadTitle = "|Seq.|CNTR No.|TP/SZ|Auth No.|Due Date|AGMT No.|Lessor|On-hire\nLoc.|On-hire\nDate|MVMT|MVMT\nDate|F/days|Div|Off-hire\nLoc.|Off-hire\nDate|Using\ndays|Min\nDays";

		var headCount = ComCountHeadTitle(HeadTitle);

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, false, true, false,false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,	daCenter,	true,		"Status");
		InitDataProperty(0, cnt++ , dtSeq,          30, daCenter,   true,       "seq");
		InitDataProperty(0, cnt++ , dtData,		    80, daCenter,	true,		"cntr_no",		false,	"",		dfNone,		  0,	true,		true); 
		InitDataProperty(0, cnt++ , dtData,		    45,	daCenter,	true,		"cntr_tpsz_cd", false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    115,daCenter,	true,		"cntr_auth_no", false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    65,	daCenter,	true,		"due_dt",       false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    70, daCenter,	true,		"agmt_no",  	false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    50,	daCenter,	true,		"lessor",       false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    55,	daCenter,	true,		"on_hire_loc",  false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    65,	daCenter,	true,		"on_hire_dt",   false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    40,	daCenter,	true,		"mvnt", 	    false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    65,	daCenter,	true,		"mvmt_dt", 	    false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    50,	daRight,	true,		"f_days",		false,	"",		dfNullInteger,0,	true,		true);                
		InitDataProperty(0, cnt++ , dtData,		    35,	daCenter,	true,		"div",          false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    65,	daCenter,	true,		"off_hire_loc", false,	"",		dfNone,		  0,	true,		true);                
		InitDataProperty(0, cnt++ , dtData,		    65,	daCenter,	true,		"off_hire_dt",  false,	"",		dfNone,		  0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    40,	daRight,	true,		"using_day",   	false,	"",		dfNullInteger,0,	true,		true);
		InitDataProperty(0, cnt++ , dtData,		    35,	daRight,	true,		"min_days",   	false,	"",		dfNullInteger,0,	true,		true);

		SelectBackColor = LSE_SELECT_BACK_COLOR;
	}
	break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

	switch(sAction) {
	case IBSEARCH:      //조회
	if(validateForm(sheetObj,formObj,sAction)){
		formObj.f_cmd.value = SEARCH;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSearch("EES_LSE_0047GS.do",FormQueryString(formObj));                        
		ComOpenWait(false);
		
		var lRow = sheetObj.LastRow; 

		var authVol = "";
		var pickVol = "";
		var hiddenCnt = 0;
		var strCntrTpszCd = formObj.cntr_tpsz_cd.value ;

		for(var i = 0 ; i < arrTpSz2.length ; i++){
			authVol= sheetObjects[0].CellValue(lRow -2 ,arrTpSz2[i]);
			pickVol= sheetObjects[0].CellValue(lRow -1 ,arrTpSz2[i]);                	
			if( comboObjects[1].CheckIndex(0) == true ){
				if( Number(authVol) <= 0 && Number(pickVol) <= 0 ){
					sheetObjects[0].ColHidden(arrTpSz2[i]) = true;
					hiddenCnt++;
				}else{
					sheetObjects[0].ColHidden(arrTpSz2[i]) = false;
				}                 	
			}else{
				if( 0 <= strCntrTpszCd.indexOf(arrTpSz[i])) {                		
					if( Number(authVol) <= 0 && Number(pickVol) <= 0 ){
						sheetObjects[0].ColHidden(arrTpSz2[i]) = true;
						hiddenCnt++;
					}else{
						sheetObjects[0].ColHidden(arrTpSz2[i]) = false;
					}                    
				}else{
					sheetObjects[0].ColHidden(arrTpSz2[i]) = true;
					hiddenCnt++;
				}
			}
		}

		if(  ((arrTpSz2.length - hiddenCnt) * 50) +  610  > 984 ){
			sheetObjects[0].SheetWidth = 984;
		}else{	
			sheetObjects[0].SheetWidth = ((arrTpSz2.length - hiddenCnt) * 50) +  610 ;
		}
		if(sheetObjects[0].RowCount > 0){
			sheetObjects[0].RowBackColor(sheetObjects[0].LastRow)   = LSE_TOTCOL_BACK_COLOR;
			sheetObjects[0].RowBackColor(sheetObjects[0].LastRow-1) = LSE_TOTCOL_BACK_COLOR;
			sheetObjects[0].RowBackColor(sheetObjects[0].LastRow-2) = LSE_TOTCOL_BACK_COLOR;
			if(sheetObjects[0].CellValue(sheetObjects[0].LastRow , 1) == "G.TTL" ){
				sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow -2 , 1, 3, 5);
			}
		}
	}

	break;

	case IBSEARCH_ASYNC01:      //조회
	if(validateForm(sheetObj,formObj,sAction)){            	
		sheetObj.RemoveAll();
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.DoSearch("EES_LSE_0047GS2.do",FormQueryString(formObj));
		ComOpenWait(false);
	}
	break;

	case IBSEARCH_ASYNC02:      //조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if(sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));

			if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
				formObj.vndr_seq.value = ComGetEtcData(sXml, "vndr_seq");
				formObj.vndr_abbr_nm.value = ComGetEtcData(sXml, "vndr_abbr_nm");			        	
				formObj.vndr_nm.value = ComGetEtcData(sXml, "vndr_lgl_eng_nm");
			} else {
				ComShowCodeMessage("LSE01007");
				formObj.agmt_seq.value = "";
				formObj.vndr_seq.value = "";
				formObj.vndr_abbr_nm.value = "";		        	
				formObj.vndr_nm.value = "";
				ComSetFocus(formObj.agmt_seq);			        	
			}
		}
	}
	break;

	case IBCREATE:
		formObj.f_cmd.value = SEARCH02;
		sheetObj.WaitImageVisible = false;
		var sXml2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		if ( sXml2 != "" ) {
			comboObjects[1].InsertItem(0 , 'ALL','ALL'); 
			LseComXml2ComboItem(sXml2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
			vOrcCntrTpszCd = ComGetEtcData(sXml2, "cntr_tpsz_cd");        
			formObj.tysz.value = vOrcCntrTpszCd;	
			arrTpSz   =  vOrcCntrTpszCd.replaceStr("|", ",").split(",");
			arrTpSz2  =  vOrcCntrTpszCd.toLowerCase().replaceStr("|", ",").split(",");
		}
		break;

	case IBSEARCH_ASYNC03:	        
		/* Lease Term Form Combo Item Setting */
		ComSetObjValue(formObj.f_cmd, SEARCH01);
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		if ( sXml != "" ) {
			comboObjects[0].InsertItem(0 , 'ALL','ALL'); 
			LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");	        	
		}
		vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");

		break;		

	case IBSEARCH_ASYNC04:	// Location 조회
	if(validateForm(sheetObj,formObj,sAction)) {
		if ( sheetObj.id == "sheet1") {
			var vLocTp = formObj.loc_tp[formObj.loc_tp.selectedIndex].text;
			var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
			+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
			sheetObj.WaitImageVisible = false; 						
			var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);

			if ( sXml != "" ) {
				if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
					if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
						var vLocCd = "";
						switch (vLocTp) {
						case "RCC":
							vLocCd = ComGetEtcData(sXml, "rcc_cd");
							break;

						case "LCC":
							vLocCd = ComGetEtcData(sXml, "lcc_cd");
							break;															
						}
						formObj.loc_cd.value = vLocCd;
						ComSetFocus(formObj.period_stdt);
					} else {
						ComShowCodeMessage("LSE01037");
						formObj.loc_cd.value = "";
						ComSetFocus(formObj.loc_cd);
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
		var sUrl    = "";
		var iWidth  = 800;
		var iHeight = 430;
		var sTargetObjList = "";
		var sDisplay = "1,0,1,1,1,1,1,1";

		if(formObj.loc_tp.value == "R"){
			sTargetObjList = "rcc_cd:loc_cd";
			sUrl    = '/hanjin/COM_ENS_051.do';
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}else if(formObj.loc_tp.value == "L"){
			sTargetObjList = "lcc_cd:loc_cd";
			sUrl    = '/hanjin/COM_ENS_051.do';
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}
	} else if ( type == "2") {
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
	}	
}

/**
* Currency Pop-up Return Value 처리 부분<br>
* @param {arry} returnedValues Pop-up 화면의 Return value array
* @param Row 대상Object가 IBSheet일 경우 해당 Row index
* @param Col 대상Object가 IBSheet일 경우 해당 Col index
* @param 대상IBSheet의 Sheet Array index
*/
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(sheetObj){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:      //조회			      

			var periodStdt = formObj.period_stdt.value;
			periodStdt = periodStdt.replaceStr("-","");
			var periodEtdt = formObj.period_eddt.value;			          
			periodEtdt = periodEtdt.replaceStr("-","");			          
			if ( periodStdt == "" ) {
				ComShowCodeMessage("LSE01010");
				ComSetFocus(formObj.period_stdt);
				return false;
				break;
			}
			if ( periodEtdt == "" ) {
				ComShowCodeMessage("LSE01011");
				ComSetFocus(formObj.period_eddt);
				return false;
				break;
			}			            
			if ( Number(periodStdt) > Number(periodEtdt)) {
				ComShowCodeMessage("LSE01051");
				ComSetFocus(formObj.period_stdt);
				return false;
				break;
			}			            
			if(formObj.cntr_tpsz_cd.value == ""  && comboObjects[1].CheckIndex(0) == false ){
				ComShowCodeMessage("LSE01015");		
				formObj.combo2.focus();
				return false;
				break;
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
		if(obj.name=="auth_no"){
			ComKeyOnlyAlphabet('uppernum','45');
		}else if(obj.name == "loc_cd") {
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
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "period_stdt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;      
	case "period_eddt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "btns_calendar3":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;
	case "pkup_due_dt":
		//숫자이면서 천단위 구분을 하지 않는다.
		ComChkObjValid(obj);
		break;    		

	case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.vndr_seq.value = "";
			document.form.vndr_abbr_nm.value = "";
			document.form.vndr_nm.value = "";    			
		}
		break;
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		break;
	}
}

/**
 * HTML Control의 Value가 변경되었을 경우 처리한다.
 */
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;
	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
		switch(obj.name) {
		case "agmt_seq": 	 

			if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
			}
			break; 	    	
		case "loc_cd":		//Location Code
		if ( ComTrim(obj.value) != "" ) {
			if(document.form.loc_tp.value == "R" || document.form.loc_tp.value == "L"){
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
			}
		}
		break;
		case "period_stdt":		//Location Code
		if(formObj.period_eddt.value != ""){
			checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
		}
		break;      

		case "period_eddt":		//Location Code
		checkEffectiveDate( formObj.period_stdt , formObj.period_eddt ) ;
		break;     
		
		case "loc_tp":
     	   formObj.loc_cd.value = "";
     	   formObj.loc_cd.focus();
        break;
		
		}	    		
	}
}
/**
 * sheet1_OnDblClick
 * 그리드 더블클릭시 이벤트 처리
 * SUMMARY 에 해당하는 DETAIL 조회
 */
function sheet1_OnDblClick(Row, Col, CellX, CellY, CellW, CellH) {
	var formObj  = document.form;
	var sheetObject1 = sheetObjects[0];
	var sRow = sheetObject1.SelectRow ;
	var lRow = sheetObject1.LastRow -3;
	if(sRow > lRow){ 		   
		return;
	}

	if(sheetObject1.SelectCol == 1){        	
		formObj.detail_auth_no.value      =  sheetObject1.CellValue( sheetObject1.SelectRow , "auth_no" );        	
		formObj.detail_agmt_cty_cd.value  = "";
		formObj.detail_agmt_seq.value     = "";
		formObj.detail_cntr_tpsz_cd.value = "";
		formObj.detail_divsionvalue       = sheetObject1.CellValue( sheetObject1.SelectRow , "divsion" );
	}else if(sheetObject1.SelectCol > 1 && sheetObject1.SelectCol < 8){

		formObj.detail_auth_no.value      =  sheetObject1.CellValue( sheetObject1.SelectRow , "auth_no" );
		var strAgmtNo                     =  sheetObject1.CellValue( sheetObject1.SelectRow , "agmt_no" );
		var strAgmtCtyCd                  =  strAgmtNo.substr(0,3);
		var strAgmtSeq                    =  strAgmtNo.substr(3);
		strAgmtSeq                        =  Number(strAgmtSeq);
		formObj.detail_agmt_cty_cd.value  = strAgmtCtyCd;
		formObj.detail_agmt_seq.value     = strAgmtSeq;        	
		formObj.detail_cntr_tpsz_cd.value = "";
		formObj.detail_divsion.value      = sheetObject1.CellValue( sheetObject1.SelectRow , "divsion" );
	}else if( sheetObject1.SelectCol > 7){
		formObj.detail_auth_no.value      =  sheetObject1.CellValue( sheetObject1.SelectRow , "auth_no" );
		var strAgmtNo                     =  sheetObject1.CellValue( sheetObject1.SelectRow , "agmt_no" );
		var strAgmtCtyCd                  =  strAgmtNo.substr(0,3);
		var strAgmtSeq                    =  strAgmtNo.substr(3);
		strAgmtSeq                        =  Number(strAgmtSeq);
		formObj.detail_agmt_cty_cd.value  = strAgmtCtyCd;
		formObj.detail_agmt_seq.value     = strAgmtSeq;        	
		formObj.detail_cntr_tpsz_cd.value = sheetObject1.CellValue( 0 , sheetObject1.SelectCol );
		formObj.detail_divsion.value      = sheetObject1.CellValue( sheetObject1.SelectRow , "divsion" );
	}

	sheetObjects[1].RemoveAll();
	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);

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
			DropHeight = 250;
			MultiSelect = true;
			//MaxSelect = 1;
			MultiSeparator = ",";
			Style = 0;
			UseAutoComplete = true;
			//영문(대)+특수문자 - Lease Term
			ValidChar(2,2);
		}

		break;

	case "combo2":
		with(comboObj) {
			DropHeight = 200;
			MultiSelect = true;
			//MaxSelect = 1;
			MultiSeparator = ",";
			Style = 0;
			UseAutoComplete = true;
			//영문(대)+특수문자,숫자 - TP/SZ
			ValidChar(2,3);
		}
		break;
	}
} 	 

/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}


/**
 * combo1_OnBlur
 */
function combo1_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}    	
		formObj.lstm_cd.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.lstm_cd.value = ""; 
	}else{
	    formObj.lstm_cd.value = ComGetObjValue(comboObj);
	}
}


/**
 * combo1_OnKeyDown
 */
function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}else if(KeyCode == 13){
 		    sheetObjects[0].RemoveAll(); 
 		    sheetObjects[1].RemoveAll(); 	
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}
	}
}

/**
 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
 * @return
 */
function combo2_OnCheckClick(comboObj, index, code) {
	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * combo2_OnBlur
 */
function combo2_OnBlur(comboObj, Index_Code, Text) {
	var formObj = document.form;
	if( comboObj.CheckIndex(0)){
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = false;
		}    	
		formObj.cntr_tpsz_cd.value = "";
	}else if(comboObj.Text == ""){
		comboObj.CheckIndex(0) = true;
		formObj.cntr_tpsz_cd.value = "";
	}else{
	    formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}
}

/**
 * combo2_OnKeyDown
 */
function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
	with(comboObj) {
		//alert(KeyCode);
		if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
			comboObj.Text = "";
		}else if(KeyCode == 13){
 		    sheetObjects[0].RemoveAll(); 
 		    sheetObjects[1].RemoveAll(); 	
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}
	}
}

/**
 * sheet TY/SZ 초기화 처리 
 */
function sheetShowInit(){
	for(var i=0; i<arrTpSz2.length; i++){
		sheetObjects[0].ColHidden(arrTpSz2[i]) = false;
	}
	sheetObjects[0].SheetWidth = 984;
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
 /**
 * Key-Down Event 처리
 */
 function obj_keydown() {
 	var obj      = event.srcElement;
 	var vKeyCode = event.keyCode;
 	var formObj  = document.form;
 	var srcObj  = window.event.srcElement;
 	if ( vKeyCode == 13 ) {
 		switch(obj.name) {
 		    case "aaa":
 		    default :
 			    if ( srcObj.style.filter == "" ) {
 				    sheetObjects[0].RemoveAll();				
 				    sheetObjects[1].RemoveAll();
 				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 			    }
 	    }
 	}
 }
/* 개발자 작업  끝 */
