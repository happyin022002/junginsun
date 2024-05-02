/*=========================================================
*Copyright(c) 2010 CyberLogitec 
*@FileName : VOP_PSO_0038.js
*@FileTitle : Tariff Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.01.14 정명훈
* 1.0 Creation
* 
* * History
* 2010.10.15 진마리아 CHM-201006351-01 신규 Object 및 로직 수정(DATE, DAY)
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
* 2011.03.30 진마리아 (CHM-201006692-01 관련) Locl Curr 가 섞였을 때, total 값을 표시하지 않는다.
* 2011.04.12 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완 - vsl popup 호출로직 수정
* 2014.07.15 이윤정 [CHM-201430821] Tariff Simulation By Port내 Auto I/F Object 칼럼 표시 Object 제한 
* 2016.07.09 CHM-201641447 PSO Auto Audit - Audit Tool(Tariff Simulation) 추가
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
 * @class VOP_PSO_0038 : VOP_PSO_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0038() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

var ABC     = "*";
var LANE    = "lane";
var ROWMARK = "|";
var FIELDMARK = ",";
var conditionXML = "";	//페이지로딩시 조회조건 세팅용 쿼리 결과
var accountList = "";	//Port변경시 Tariff에 등록된 Account 쿼리 결과
var arrFormulaNo = new Array();	//페이지로딩시 Formula_No IN (1, 2) 가져옴 
var gHeadRowHeight = 30;		//Head Row Height
var gDataRowHeight1 = 30;		//Data Row Height
var gDataRowHeight2 = 20;		//Data Row Height
var gColCountInSheet = [0,0,0,0,0,0];	//Sheets의 컬럼카운트 
var tmpCurrType = "1";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_port_cd":
				var sUrl = "/hanjin/VOP_VSK_0043.do";
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 510, "", "0,0", true);
				if(rVal){
					formObject.port_cd.value = rVal;
					loadTerminal();				//COMBO YARD
					f_ClearSheets();
					formObject.yard_cd.focus();
				}
				break;
				
			case "btn_vvd_search":
				var vsl_cd = formObject.vsl_cd.value;
            	var sUrl = "";
            	
            	if(vsl_cd == ""){
            		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
            		ComOpenPopup(sUrl, 460, 493, "getVslCdData", "0,0", true);
            	}else{
            		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
            		ComOpenPopup(sUrl, 340, 393, "getVvdData", "0,0", true);
            	}
			break;	
				
			case "btns_Calendar1" :		// Issue Date
				var cal = new ComCalendar();
				cal.setEndFunction("searchProvider");	//Callback Function
				cal.select(formObject.issue_date, 'yyyy-MM-dd');
			break;
			
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				changeInOut();
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;

			case "btn_Calculation":
				if(sheetObject1.RowCount == 0 && sheetObject2.RowCount == 0){
					return;
				}
				//강제Trxn설정 
				for(var i=sheetObject1.HeaderRows ; i<sheetObject1.RowCount+sheetObject1.HeaderRows; i++){
					sheetObject1.RowStatus(i) = "U";
				}
				for(var i=sheetObject2.HeaderRows ; i<sheetObject2.RowCount+sheetObject2.HeaderRows; i++){
					sheetObject2.RowStatus(i) = "U";
				}
				doActionIBSheet(sheetObject1,formObject,COMMAND02);
				checkInOutValue();
				break;
		} 
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
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	initControl(sheetObjects[0]);
	searchVslClass();
}

function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	setToday(formObj.issue_date);
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm  ('change', 'obj_change', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('paste', 'obj_paste', form); 
	axon_event.addListenerForm  ('drop', 'obj_drop', form);
	axon_event.addListenerForm  ('click', 'obj_click', form);
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	switch(comboObj.id) {  
		case "yard_cd":		//Yard 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				UseCode = true;
				SetColAlign("center|left");        
				SetColWidth("50|300");
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자
				MaxLength = 2;
			}
		break; 
		
		case "acct_cd":		//Account 
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
				MaxLength = 6;
				SetColWidth("50|300");
			}
		break; 	
	
		case "cost_cd":		//Cost 
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,0);	//영문대문자
				MaxLength = 6;
			}
		break; 	
		
		case "vndr_seq":		//Service Provider 
			with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;
				UseCode = true;
				DropHeight = 190;
				ValidChar(2,1);	//영문대문자,숫자 (숫자만은 안 됨)
				MaxLength = 10;
			}
		break; 
		
//		case "cntr_vsl_clss_capa":		//Vessel Class
//			with (comboObj) {
//				MultiSelect = false;
//				UseAutoComplete = true;	
//				SetColAlign("left");        
//				SetColWidth("50");
//				DropHeight = 160;
//			}
//		break; 
	}
}

function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	
	switch(sheetid) {
		
		case "sheet1":	//Objects (Auto)
			with (sheetObj) {
				// 높이 설정
				//style.height = 145;
				style.height = 2 * gHeadRowHeight + 6 * gDataRowHeight2 + 8;
				MultiSelection = false;
				
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
				
				var HeadTitle1 = "|Auto I/F Object|Auto I/F Object|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
				var HeadTitle2 = "|Object Name|Object Value|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
				var headCount = ComCountHeadTitle(HeadTitle1);
				gColCountInSheet[0] = headCount;
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				var prefix = "sheet1_";
				
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,		160,		daLeft,	true,		prefix+"obj_list_nm",   	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,		60,		daRight,	true,		prefix+"dflt_val",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,		prefix+"obj_list_no",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,		prefix+"pso_obj_list_tp_cd",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,		prefix+"pso_meas_ut_cd",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,		prefix+"pso_meas_ut_nm",			false,	"",			dfNone,			0,		true,  true);
				
				CountPosition = 0;
				ShowButtonImage = 1;
				HeadRowHeight = gHeadRowHeight;
				DataRowHeight = gDataRowHeight2;
				
			}
		break;
		
		case "sheet2":	//Objects (Manual)				
			with (sheetObj) {
				// 높이 설정
				style.height = 2 * gHeadRowHeight + 6 * gDataRowHeight2 + 8;
				MultiSelection = false;
				
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
				
				var HeadTitle1 = "|Manual Object|Manual Object|no|val|pso_meas_ut_cd|pso_meas_ut_nm|obj_list_nm_ord";
				var HeadTitle2 = "|Object Name|Object Value|no|val|pso_meas_ut_cd|pso_meas_ut_nm|obj_list_nm_ord";
				var headCount = ComCountHeadTitle(HeadTitle1);
				gColCountInSheet[1] = headCount;
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				var prefix = "sheet2_";
				
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		prefix+"obj_list_nm",   	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		prefix+"dflt_val",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"obj_list_no",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"pso_obj_list_tp_cd",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"pso_meas_ut_cd",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"pso_meas_ut_nm",			false,	"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		160,	daLeft,		true,		prefix+"obj_list_nm_ord",   	false,	"",			dfNone,			0,		false,  false);
				
				CountPosition = 0;
				ShowButtonImage = 1;
				HeadRowHeight = gHeadRowHeight;
				DataRowHeight = gDataRowHeight2;
			}
		break;
		
		case "sheet3":	//Calculated Result
		with (sheetObj) {
			// 높이 설정
			style.height = 2 * gHeadRowHeight + 6 * gDataRowHeight2 + 8;
			MultiSelection = false;
			
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
			
			var HeadTitle1 = "|Calculated Result|Calculated Result|Calculated Result";
			var HeadTitle2 = "|Account CD|CUR|Tariff Cost";
			var headCount = ComCountHeadTitle(HeadTitle1);
			gColCountInSheet[2] = headCount;
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var prefix = "sheet3_";
			
			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			160,	daCenter,	true,		prefix+"acct_cd",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"curr_cd",   	false,	"",			dfNone,			0,		true,  true);
			InitDataProperty(0, cnt++ , dtAutoSum,		60,		daRight,	true,		prefix+"tariff_cost",	false,	"",			dfNumber,			0,		true,  true);
//			dtAutoSum
			CountPosition = 0;
			ShowButtonImage = 1;
			HeadRowHeight = gHeadRowHeight;
			DataRowHeight = gDataRowHeight2;
		}
		break;
		
		case "sheet4":	//Tariff Cost Detail
			with (sheetObj) {
				// 높이 설정
//				style.height = gHeadRowHeight + gDataRowHeight1 + 2;
style.height = 200;		
				MultiSelection = false;
				SelectHighLight = false;
				
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
				
				var HeadTitle1 = "|Account|Cost|Service\nProvider|Service\nProvider|CUR|Tariff Cost|Invoice AMT|Diff.|Formula|Formula Expression|Invoice Total|Total I|Total O|USD AMT";
				var headCount = ComCountHeadTitle(HeadTitle1);
				gColCountInSheet[3] = headCount;
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet4_";
				
				//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	10,		daCenter,	true,		prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"acct_cd",   	false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"lgs_cost_cd",   false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vndr_seq",   	false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vndr_lgl_eng_nm",   	false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"curr_cd",   	false,		"",			dfNone,			0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		prefix+"tariff_amount", false,		"",			dfNumber,		4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		prefix+"locl_amt",		false,		"",			dfNumber,		4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,		prefix+"diff",			false,		"|sheet4_tariff_amount| - |sheet4_locl_amt|",			dfNumber,		4,		true,  		true, 		14);
				InitDataProperty(0, cnt++ , dtData,			160,	daLeftTop,	true,		prefix+"runtime_formula_desc",   	false,		"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtData,			160,	daLeftTop,	true,		prefix+"display_formula_desc",  false,		"",			dfNone,			0,		true,  true);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"inv_total",   	false,		"",			dfNumber,	4,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"total_i",   	false,		"",			dfNumber,	4,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"total_o",   	false,		"",			dfNumber,	4,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,			150,	daRight,	true,		prefix+"tariff_usd_amount", false,		"",			dfNumber,		4,		true,  		true, 		14);
				CountPosition = 0;
				ShowButtonImage = 1;
				HeadRowHeight = gHeadRowHeight;
				DataRowHeight = gDataRowHeight1;
			}
			break;	
			
		case "sheet5":	//Invoice Detail
			with (sheetObj) {
				// 높이 설정
//				style.height = gHeadRowHeight + 4*gDataRowHeight2 + 4;
style.height = 200;				
				MultiSelection = false;

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle1 = "|Account|Cost|Invoice No.|Service Provider|Service Provider|Currency|I/O|Tariff Cost|Adjustment Cost|Invoice Amount|Formula|Formula|Remark|Invoice Total|Total I|Total O";
				var headCount = ComCountHeadTitle(HeadTitle1);
				gColCountInSheet[4] = headCount;

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, true, true, false, false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet5_";

				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	10,		daCenter,	true,		prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"acct_cd",   	false,		"",			dfNone,		0,		true,  		true,		-1,		false,		false,		"",		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"lgs_cost_cd",   false,		"",			dfNone,		0,		true,  		true,		-1,		false,		false,		"",		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix+"inv_no",   		false,		"",			dfNone,		0,		true,  		true,		-1,		false,		false,		"",		false);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"vndr_seq",   	false,		"",			dfNone,		0,		true,  		true,		-1,		false,		false,		"",		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix+"vndr_nm",   	false,		"",			dfNone,		0,		true,  		true,		-1,		false,		false,		"",		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		prefix+"curr_cd",		false,		"",			dfNone,		0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	false,		prefix+"dp_io_bnd_cd",	false,		"",			dfNone,		0,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"calc_amt",   	false,		"",			dfNumber,	4,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"adj_amt",   	false,		"",			dfNumber,	4,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"locl_amt",   	false,		"",			dfNumber,	4,		true,  		true);
				InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		false,		prefix+"xpr_desc",   	false);
				InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		false,		prefix+"foml_desc",   	false);
				InitDataProperty(0, cnt++ , dtData,			50,		daLeft,		false,		prefix+"rmk",   		false,		"",			dfNone,		0,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"inv_total",   	false,		"",			dfNumber,	4,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"total_i",   	false,		"",			dfNumber,	4,		false, 		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"total_o",   	false,		"",			dfNumber,	4,		false, 		false);

				CountPosition = 0;
				ShowButtonImage = 1;
				HeadRowHeight = gHeadRowHeight;
				DataRowHeight = gDataRowHeight2;
			}
			break;
		case "sheet6":	//Dummy, 초기화하지 않음
			with (sheetObj) {
			// 높이 설정
			style.height = 0;
			
			MultiSelection = false;

			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|yd_chg_no|yd_chg_ver_seq|curr_cd|acct_cd|cost_cd|vndr_seq|vndr_lgl_eng_nm|upd_usr_id|upd_dt";
			var headCount = ComCountHeadTitle(HeadTitle1);
//			gColCountInSheet[6] = headCount;

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(false, false, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet6_";

			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	10,		daCenter,	true,	prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"yd_chg_no",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"yd_chg_ver_seq",   	false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"curr_cd",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"acct_cd",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"cost_cd",   	false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vndr_seq",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vndr_lgl_eng_nm",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"upd_usr_id",   		false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"upd_dt",   			false,		"",			dfNone,			0,		true,  		true,		-1,		false,		false,		"",		false);
			
			CountPosition = 0;
			ShowButtonImage = 1;
			HeadRowHeight = gHeadRowHeight;
			DataRowHeight = gDataRowHeight2;
			}
		break;				
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
		//	if(!checkVvd2()) return;	2015.05.07 막음 //Check VVD
			f_ClearSheets();
			searchVersion();	
			
			if(sheetObjects[5].RowCount>0){
				var aryPrefix = new Array( "sheet1_", "sheet2_", "sheet5_" );        
				if( !validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH;
				
				ComOpenWait(true);
				
				sheetObjects[0].Redraw = false;
				sheetObjects[1].Redraw = false;
				sheetObjects[4].Redraw = false;
				
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[1].WaitImageVisible = false;
				sheetObjects[4].WaitImageVisible = false;
				
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects[5], true, true) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
	
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[4].LoadSearchXml(arrXml[2]);
				
//				 [CHM-201430821] Tariff Simulation By Port내 Auto I/F Object 칼럼 표시 Object 제한 
				for(k=0;k<sheetObjects[0].RowCount+2;k++){	
					if(   sheetObjects[0].CellValue(k,3) == '18'
						||sheetObjects[0].CellValue(k,3) == '19'
						||sheetObjects[0].CellValue(k,3) == '20'
						||sheetObjects[0].CellValue(k,3) == '21'
						||sheetObjects[0].CellValue(k,3) == '22'
						||sheetObjects[0].CellValue(k,3) == '42'
						||sheetObjects[0].CellValue(k,3) == '45'
						||sheetObjects[0].CellValue(k,3) == '46'
						||sheetObjects[0].CellValue(k,3) == '53'
						||sheetObjects[0].CellValue(k,3) == '54'
						||sheetObjects[0].CellValue(k,3) == '73'
						||sheetObjects[0].CellValue(k,3) == '74'
						||sheetObjects[0].CellValue(k,3) == '81'
						||sheetObjects[0].CellValue(k,3) == '82'
						||sheetObjects[0].CellValue(k,3) == '83'
						||sheetObjects[0].CellValue(k,3) == '87'
						||sheetObjects[0].CellValue(k,3) == '98'
						||sheetObjects[0].CellValue(k,3) == '99'
						||sheetObjects[0].CellValue(k,3) == '102'
						||sheetObjects[0].CellValue(k,3) == '103'
						||sheetObjects[0].CellValue(k,3) == '104'
						||sheetObjects[0].CellValue(k,3) == '105'
						||sheetObjects[0].CellValue(k,3) == '106'
						||sheetObjects[0].CellValue(k,3) == '107'
						||sheetObjects[0].CellValue(k,3) == '108'
						||sheetObjects[0].CellValue(k,3) == '117'
						||sheetObjects[0].CellValue(k,3) == '139'
						||sheetObjects[0].CellValue(k,3) == '140'
						||sheetObjects[0].CellValue(k,3) == '141'
						||sheetObjects[0].CellValue(k,3) == '142'
						||sheetObjects[0].CellValue(k,3) == '143'
						||sheetObjects[0].CellValue(k,3) == '144'
						||sheetObjects[0].CellValue(k,3) == '151'
						||sheetObjects[0].CellValue(k,3) == '164'
						||sheetObjects[0].CellValue(k,3) == '165'
						)
						sheetObjects[0].RowHidden(k)=true  ;

				}
//				 [CHM-201430821] IN/OUT Object 에 관해선 젤 위에 보이도록 처리
				for(j=0;j<sheetObjects[1].RowCount+2;j++){
					if(sheetObjects[1].CellValue(j,3) == '77'||sheetObjects[1].CellValue(j,3) == '89'){
						sheetObjects[1].CellValue2(j,7) = " "+sheetObjects[1].CellValue(j,1);
					}else{
						sheetObjects[1].CellValue2(j,7) = sheetObjects[1].CellValue(j,1);	
					}
						
					


					if(   sheetObjects[1].CellValue(j,3) == '18'
						||sheetObjects[1].CellValue(j,3) == '19'
						||sheetObjects[1].CellValue(j,3) == '20'
						||sheetObjects[1].CellValue(j,3) == '21'
						||sheetObjects[1].CellValue(j,3) == '22'
						||sheetObjects[1].CellValue(j,3) == '42'
						||sheetObjects[1].CellValue(j,3) == '45'
						||sheetObjects[1].CellValue(j,3) == '46'
						||sheetObjects[1].CellValue(j,3) == '53'
						||sheetObjects[1].CellValue(j,3) == '54'
						||sheetObjects[1].CellValue(j,3) == '73'
						||sheetObjects[1].CellValue(j,3) == '74'
						||sheetObjects[1].CellValue(j,3) == '81'
						||sheetObjects[1].CellValue(j,3) == '82'
						||sheetObjects[1].CellValue(j,3) == '83'
						||sheetObjects[1].CellValue(j,3) == '87'
						||sheetObjects[1].CellValue(j,3) == '98'
						||sheetObjects[1].CellValue(j,3) == '99'
						||sheetObjects[1].CellValue(j,3) == '102'
						||sheetObjects[1].CellValue(j,3) == '103'
						||sheetObjects[1].CellValue(j,3) == '104'
						||sheetObjects[1].CellValue(j,3) == '105'
						||sheetObjects[1].CellValue(j,3) == '106'
						||sheetObjects[1].CellValue(j,3) == '107'
						||sheetObjects[1].CellValue(j,3) == '108'
						||sheetObjects[1].CellValue(j,3) == '117'
						||sheetObjects[1].CellValue(j,3) == '139'
						||sheetObjects[1].CellValue(j,3) == '140'
						||sheetObjects[1].CellValue(j,3) == '141'
						||sheetObjects[1].CellValue(j,3) == '142'
						||sheetObjects[1].CellValue(j,3) == '143'
						||sheetObjects[1].CellValue(j,3) == '144'
						||sheetObjects[1].CellValue(j,3) == '151'
						||sheetObjects[1].CellValue(j,3) == '164'
						||sheetObjects[1].CellValue(j,3) == '165'
						)
						sheetObjects[1].RowHidden(j)=true  ;

				}
				
				
//				[CHM-201430821] Object Name 순으로 정렬 (IN/OUT 우선순위 부여)
				sheetObjects[0].ColumnSort("sheet1_obj_list_nm");
				sheetObjects[1].ColumnSort("sheet2_obj_list_nm_ord");
				sheetObjects[4].ColumnSort("sheet5_acct_cd");
				
				sheetObjects[0].Redraw = true;
				sheetObjects[1].Redraw = true;
				sheetObjects[4].Redraw = true;
	
				sheetObjects[0].WaitImageVisible = true;
				sheetObjects[1].WaitImageVisible = false;
				sheetObjects[4].WaitImageVisible = false;
				
				ComOpenWait(false);
			}else
				ComShowMessage("There is no data on the compulsory conditions.");
		break;
		
		case IBSEARCH_ASYNC01:	//초기 조회조건 Setting   
			var prefix = "sheet1_";
			var aryPrefix = new Array( "sheet1_" );
			formObj.f_cmd.value = SEARCHLIST01;
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
	
			conditionXML = sheetObjects[5].GetSearchXml("VOP_PSO_0002GS.do", param );
			var arrXml = conditionXML.split("|$$|");
			
			//콤보필드를 초기화시킨다. (Account)
			formObj.acct_cd.RemoveAll();	
			//콤보필드를 초기화시킨다. (Cost)
			formObj.cost_cd.RemoveAll();
			//콤보필드를 초기화시킨다. (Service Provider)
			formObj.vndr_seq.RemoveAll();
			
			//
			var arrFormula4Loading = ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			var k = 0;
			for(i=0; i<arrFormula4Loading.length; i++){
				arrKeyVal = arrFormula4Loading[i].split("|@DELIM|");
				for(j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k] = arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
	
		break;
		
		
		case IBCLEAR:  
			//Port
			formObj.port_cd.value = "";
			//Yard
			formObj.yard_cd.RemoveAll();
			//Account
			formObj.acct_cd.RemoveAll();
			formObj.account_nm.value = "";
			//Cost
			formObj.cost_cd.RemoveAll();
			formObj.lgs_cost_nm.value = "";
			//Service Provider
			formObj.vndr_seq.RemoveAll();
			formObj.vndr_lgl_eng_nm.value = "";
			//Issue Date
			setToday(formObj.issue_date);
			//VVD
			formObj.vsl_cd.value = "";
			formObj.skd_voy_no.value = "";
			formObj.skd_dir_cd.value = "";
			//CLASS
//			formObj.cntr_vsl_clss_capa.RemoveAll();
			//Sheets	
			f_ClearSheets();
		break;        

	
		case COMMAND05:	//Port Code [keyup:5자리]  
		    formObj.f_cmd.value = COMMAND05;	//
		//port 변경시
		formObj.acct_cd.RemoveAll();
		formObj.account_nm.value = "";
		formObj.cost_cd.RemoveAll();
		formObj.lgs_cost_nm.value = "";
		formObj.vndr_seq.RemoveAll();
		formObj.vndr_lgl_eng_nm.value = "";
		
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0002GS.do", param );
			var isPort = ComGetEtcData(sXml, "isPort");	//O or X
			if(isPort == "O"){
				rVal = formObj.port_cd.value;
				loadTerminal();
				formObj.yard_cd.focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value = "";
				formObj.port_cd.focus();
			}
		break;
		
		case COMMAND02:      // Calculation Button Click
			//if(!checkVvd2()) return;	//Check VVD 2015.05.07 막음
			var aryPrefix = new Array( "sheet4_");
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = COMMAND02;
			
			ComOpenWait(true);
			sheetObjects[0].WaitImageVisible = false;
			
			var saveObjs = new Array(2);
			
			saveObjs[0] = sheetObjects[0];
			saveObjs[1] = sheetObjects[1];
			
			//UOM에 따라 작은따옴표를 붙여야 하므로 f_ComGetSaveString() 호출
			var SaveStr = f_ComGetSaveString(saveObjs); // 배열입니다.
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects[5], true, true) + "&" + ComGetPrefixParam(aryPrefix));
//			alert("<sXml>\n" + sXml);	//[jmh] X
			//if(sXml == ""){//에러 시	//[jmh] O
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){//에러 시		//[jmh] X
				ComOpenWait(false);
				sheetObjects[3].LoadSearchXml(sXml);	//[jmh] X
//				sheetObjects[3].CellValue2(1, "sheet4_runtime_formula_desc") = "";
//				sheetObjects[3].CellValue2(1, "sheet4_display_formula_desc") = "";	 
//				sheetObjects[3].CellValue2(1, "sheet4_calc_amt") = 0;
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				return;
			}
			sheetObjects[3].LoadSearchXml(sXml);
			
			ComOpenWait(false);
		break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
			//Port
			if(formObj.port_cd.value.length < 5){
				ComShowCodeMessage('PSO00007');
				formObj.port_cd.focus();
				return false;
			}	
	
			//Yard
			if( formObj.yard_cd.Code == ''){
				ComShowCodeMessage('PSO00008');
				formObj.yard_cd.focus();
				return false;
			}	
			
			//Account
			if( formObj.acct_cd.Code == ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//필수항목
				formObj.acct_cd.focus();
	
				return false;
			}					
	
			//Cost
			if( formObj.cost_cd.Code == ''){
				ComShowCodeMessage('PSO00003', "[Cost CD]");	//필수항목
				formObj.cost_cd.focus();
				
				return false;
			}	
	
			//Service Provider
			if(formObj.vndr_seq.Code == ''){
				ComShowCodeMessage('PSO00011');
				formObj.vndr_seq.focus();
	
				return false;
			}	
	
			//Issue Date
			if(formObj.issue_date.value == ''){
				ComShowCodeMessage('PSO00009');
				formObj.issue_date.focus();
				return false;
			}	

		break;
	}
	return true;
}


function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			if(obj.name=="vndr_seq"){
				//ComKeyOnlyNumber(obj,",");
				ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
			} else {
				ComKeyOnlyNumber(obj);
			}
			break;
        case "int":
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;	
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			if(obj.name=="vsl_cd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_change(){
	var formObj = document.form;
	obj = event.srcElement;   
	
	with(formObj){
		switch(obj.name) {

			case "port_cd":	// Port
				
			break;

			case "issue_date":	// Issue Date
				searchProvider();
			break;
			
			case "vsl_cd":		//OnPaste시에 OnChange 발생 안 함
			case "skd_voy_no":	//
			case "skd_dir_cd":	//
				
			break;
		}
	}		
}


function obj_click(){
	var formObj = document.form;
	obj = event.srcElement;      	

	if(obj.name == "currType"){
		if(tmpCurrType == "" || tmpCurrType != obj.value){
			
			var sheetObj3 = sheetObjects[2];
			var sheetObj4 = sheetObjects[3];
			var acctCd = "";
			var vndrSeq = "";
			var acctCdArr = new Array();
			var currCdArr = new Array();
			var oldAmt = 0;
			var prefix = sheetObj4.id + "_";
		
			if(sheetObj4.RowCount > 0){
				
				//Tariff Cost Detail(sheet4)의 Calculated AMT를 account별로 합산하여 sheet3의 Tariff Cost로 가져온다.
				
				for(var Row=sheetObj4.HeaderRows; Row<sheetObj4.HeaderRows + sheetObj4.RowCount; Row++){
					acctCd = sheetObj4.CellValue(Row, prefix + "acct_cd");
					currCd = sheetObj4.CellValue(Row, prefix + "curr_cd");
					if(acctCdArr[acctCd]){
						oldAmt = Number(acctCdArr[acctCd]);
					}else{
						oldAmt = 0;
					}
					if(document.form.currType[0].checked){
						acctCdArr[acctCd] = oldAmt + Number(sheetObj4.CellValue(Row, prefix+"tariff_amount"));
						currCdArr[acctCd] = sheetObj4.CellValue(Row, prefix+"curr_cd");
					}else{
						acctCdArr[acctCd] = oldAmt + Number(sheetObj4.CellValue(Row, prefix+"tariff_usd_amount"));
						currCdArr[acctCd] = "USD";
					}
					
				}
				
				prefix = sheetObj3.id + "_";
				sheetObj3.RemoveAll();
				var total = 0;
				var row;
				var oldCurr = null;
				var newCurr;
				var mixCurr = false;
				
				for(var Row in acctCdArr){
					row = sheetObj3.DataInsert(-1);
					sheetObj3.CellValue(row, prefix+"acct_cd") = Row;
					sheetObj3.CellValue(row, prefix+"tariff_cost") = acctCdArr[Row];
					sheetObj3.CellValue(row, prefix+"curr_cd") = currCdArr[Row];
					newCurr = currCdArr[Row];
					if(oldCurr != null){
						if(newCurr != oldCurr){
							mixCurr = true;
						}
					}
					oldCurr = newCurr;
				}
				if(mixCurr){
					sheetObj3.CellValue(sheetObj3.LastRow, prefix+"tariff_cost") = "-";
				}
			}
			tmpCurrType = obj.value;
		}
	}
}

function obj_blur(){

	var formObj = document.form;
	obj = event.srcElement;      	

	with(formObj){

		switch(obj.name) {

//			case "port_cd":		//영문대문자가 아니면 Clear
//				var val = obj.value; 
//				for(var i=0; i<val.length; i++) {
//					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
//						formObj.port_cd.value = "";
//						formObj.port_cd.focus();
//						break;
//					}
//				}
//			break;
			
			case "issue_date":	//Issue Date
				ComChkObjValid(event.srcElement);
			break;
		}	
	}
}

function obj_keyup(){
	var eleObj = event.srcElement;
	var formObj = document.form;

	switch (eleObj.name) {
		case "port_cd":
			if(eleObj.value.length == 5){
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			} else{
				formObj.yard_cd.RemoveAll();
			}
			break;
	
		case "vsl_cd":
			if (eleObj.value.length == 4) {
				formObj.skd_voy_no.focus();
			}	
			break;
			
		case "skd_voy_no":
			if (eleObj.value.length == 4) {
				formObj.skd_dir_cd.focus();
			}
			break;
	}
}

function obj_paste(){
	var eleObj = event.srcElement;
	var formObj = document.form;

	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");		//영대문자
		break;
		
		case "vsl_cd":
			//gf_SetControlPastePattern(event, "A");		//영대문자
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;

		case "skd_voy_no":
			//gf_SetControlPastePattern(event, "0");		//숫자
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;
		
		case "skd_dir_cd":
			//gf_SetControlPastePattern(event, "A");		//영대문자
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;
		
		case "issue_date":
			gf_SetControlPastePattern(event, "0");		//숫자
		break;
	}
}

//Drag & Drop으로 값을 입력하는 것은 배제함
function obj_drop(){
	event.returnValue = false;
}

/**
 * 화면 로딩시 콤보조회 
 */
function sheet1_OnLoadFinish(sheetObj){
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);

	f_InitSheets();
	formObj.port_cd.focus();
	
	/** Test **********************************/
//	formObj.vsl_cd.value = "HNPT";
//	formObj.skd_voy_no.value = "0080";
//	formObj.skd_dir_cd.value = "E";
	/** Test **********************************/
}
 
/**
 * 'IN', 'OUT' 선택시, locl_amt 조정해주기
 */
function sheet2_OnChange(sheetObj,Row,Col,Value) {
	 
	var formObj = document.form;
	var prefix = "sheet2_";
	var sheetObj4 = sheetObjects[3];
	var iprefix = sheetObj4.id + "_";
	var inValue = "";
	var outValue = "";
	sheetObj.ShowDebugMsg = false;
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "dflt_val" :
			var obj_list_no = sheetObj.CellValue(Row, prefix + "obj_list_no");	//IN=77, OUT=89
			var obj_list_value = sheetObj.CellValue(Row, prefix + "dflt_val");
			for(j=sheetObj.HeaderRows; j<sheetObj.HeaderRows + sheetObj.RowCount; j++){
				if(sheetObj.CellValue(j, prefix+"obj_list_no")=="77"){
					inValue = sheetObj.CellValue(j, prefix+"dflt_val");
				}if(sheetObj.CellValue(j, prefix+"obj_list_no")=="89"){
					outValue = sheetObj.CellValue(j, prefix+"dflt_val");
				}
			}
			if(obj_list_no == "77" || obj_list_no == "89"){
				for(i=sheetObj4.HeaderRows; i<sheetObj4.HeaderRows + sheetObj4.RowCount; i++){
					if(sheetObj4.CellValue(i,iprefix+"total_i")>0 && sheetObj4.CellValue(i,iprefix+"total_o")>0){
						if(obj_list_no == "77" && obj_list_value == "Y"){
							if(outValue == "Y"){
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
							}else{
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_i");
							}
						}else if(obj_list_no == "77" && obj_list_value == "N"){
							if(outValue == "Y"){
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_o");
							}else{
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
							}
						}else if(obj_list_no == "89" && obj_list_value == "Y"){
							if(inValue == "Y"){
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
							}else{
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_o");
							}
						}else if(obj_list_no == "89" && obj_list_value == "N"){
							if(inValue == "Y"){
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_i");
							}else{
								sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
							}
						}
					}else{
						sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
					}
				}	
			}		
 		break;
	}
}

/*
 * 조회 후처리
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	//Object Sheet의 Column Type을 바꾼다.
	f_SetCellProperty(sheetObjects[0], "sheet1_");
	f_SetCellProperty(sheetObjects[1], "sheet2_");
}
 
function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
	sheetObj.MouseToolTipText="";
	var Row = sheetObj.MouseRow;
	var Col = sheetObj.MouseCol;
	if (Row >= sheetObj.HeaderRows && Col == "8") {
		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, Col);
		sheetObj.ToolTipOption="balloon:true;width:320";
		sheetObj.MousePointer = "Hand";
	}else if (Row >= sheetObj.HeaderRows && Col == "9") {
		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, Col);
		sheetObj.ToolTipOption="balloon:true;width:320";
		sheetObj.MousePointer = "Hand";
	}
}

function sheet5_OnMouseMove(sheetObj, Button, Shift, X, Y){
	sheetObj.MouseToolTipText="";
	var Row = sheetObj.MouseRow;
	var Col = sheetObj.MouseCol;
	if (Row >= sheetObj.HeaderRows && Col == "10") {
		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, Col);
		sheetObj.ToolTipOption="balloon:true;width:320";
		sheetObj.MousePointer = "Hand";
	}else if (Row >= sheetObj.HeaderRows && Col == "11") {
		sheetObj.MouseToolTipText = sheetObj.CellValue(Row, Col);
		sheetObj.ToolTipOption="balloon:true;width:320";
		sheetObj.MousePointer = "Hand";
	}
}

/**
 * Yard
 */
function yard_cd_OnChange(){
	var formObj = document.form;
	f_ClearSheets(); 
	
	var portCd = formObj.port_cd.value;
	addComboItemAccount();
}

function yard_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");	//영문대문자,숫자만 입력 가능	
} 

function acct_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
}

function vndr_seq_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");	//숫자만 입력 가능
}

function cost_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");	//영문대문자만 입력 가능	
}  

/*
 * 해당 Port의 Yard 조회
 */
function loadTerminal() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	sheetObj.ShowDebugMsg = false;
	
	//콤보필드를 초기화시킨다.
	formObj.yard_cd.RemoveAll();
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
	var comboItems = ComGetEtcData(sXml, "lane").split(ROWMARK);
	addComboItem(formObj.yard_cd, comboItems);
}

/**
 * 콤보필드에 데이터를 추가해준다. (Currency, Yard)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i = 0 ; i < comboItems.length ; i++) {
		var comboItem = comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}


/**
 * 콤보필드에 데이터를 추가해준다. (Account)
 */	 
function addComboItemAccount() {
	var formObj = document.form;  
	formObj.acct_cd.UseCode = true;
	formObj.acct_cd.RemoveAll();
	searchAccount();
	var strAccount = ComGetEtcData(accountList, "account");
	if(strAccount == ""){
		formObj.acct_cd.RemoveAll();
		return;
	}	
	var comboItems = strAccount.split(ROWMARK);
	var comboItem = "";
	if(comboItems.length>1){
		formObj.acct_cd.InsertItem(-1, "ALL|", " ");	//ALL
	}
	for (var i = 0 ; i < comboItems.length ; i++) {
		comboItem = comboItems[i].split(FIELDMARK);
			formObj.acct_cd.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
	}
	for(var i = 0 ; i < formObj.acct_cd.GetCount() ; i++) {
			formObj.acct_cd.CheckIndex(i) = true;
	}
	formObj.acct_cd.Index = 0;
	setMultiCombo(formObj.acct_cd, formObj.acct_cd.Index);
	acct_cd_OnCheckClick(formObj.acct_cd, formObj.acct_cd.Index);
}
 
/**
 * 콤보필드에 데이터를 추가해준다. (Cost)
 */	
function addComboItemCost() {
	 var formObj = document.form;  
	formObj.cost_cd.UseCode = true;
	formObj.cost_cd.RemoveAll();
	searchCost();
	var strCost = ComGetEtcData(costList, "cost");
	if(strCost == ""){
		formObj.cost_cd.RemoveAll();
		return;
	}	
	var comboItems = strCost.split(ROWMARK);
	var comboItem = "";
	if(comboItems.length>1){
		formObj.cost_cd.InsertItem(-1, "ALL|", " ");	//ALL
	}
	for (var i = 0 ; i < comboItems.length ; i++) {
		comboItem = comboItems[i].split(FIELDMARK);
			formObj.cost_cd.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
	}
	formObj.cost_cd.Index = 0;
	setMultiCombo(formObj.cost_cd, formObj.cost_cd.Index);
	cost_cd_OnCheckClick(formObj.cost_cd, formObj.cost_cd.Index);
}
 
 /**
  * 콤보필드에 데이터를 추가해준다. (Provider)
  */	
 function addComboItemProvider() {
 	 var formObj = document.form;  
 	formObj.vndr_seq.UseCode = true;
 	formObj.vndr_seq.RemoveAll();
 	searchProvider();
 	var strVndr = ComGetEtcData(vndrList, "vndr");
 	if(strVndr == ""){
 		formObj.vndr_seq.RemoveAll();
 		return;
 	}	
 	var comboItems = strVndr.split(ROWMARK);
 	var comboItem = "";
 	if(comboItems.length>1){
 		formObj.vndr_seq.InsertItem(-1, "ALL|", " ");	//ALL
 	}
 	for (var i = 0 ; i < comboItems.length ; i++) {
 		comboItem = comboItems[i].split(ABC);
 			formObj.vndr_seq.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
 	}
 	formObj.vndr_seq.Index = 0;
 	setMultiCombo(formObj.vndr_seq, formObj.vndr_seq.Index);
 }
 
/**
 * YD_CHG_NO 조회 (Tariff는 있지만, A/M Type의 Object를 가져올 수 없는 경우가 있으므로, 따로 조회)
 */
function searchVersion(){
	 
	var formObj = document.form;
	formObj.f_cmd.value = COMMAND01;
	
	var port_cd = formObj.port_cd.value;
	var yard_cd = formObj.yard_cd.Code;
	var acct_cd = formObj.acct_cd.Code;
	var cost_cd = formObj.cost_cd.Code;
	var vndr_seq = formObj.vndr_seq.Code;
	var issue_date = formObj.issue_date.value;
	
	if(port_cd == "" || yard_cd == "" || acct_cd == "" || cost_cd == "" || vndr_seq == "" || issue_date == ""){
		return;
	}

	//Combo OnChange 발생시, Focus 잃지 않게 하기 (초기화되지 않은 Dummy Sheet 이용)
	var searchVersionXML = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet6_"));
	sheetObjects[5].LoadSearchXml(searchVersionXML);
}

/*
 * Tariff에 사용하는 Searvice Provider 조회하기
 */ 
function searchProvider(){
	//f_ClearSheets();
	var formObj = document.form;
	formObj.f_cmd.value = COMMAND03;
	formObj.vndr_lgl_eng_nm.value = "";
	vndrList = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
	formObj.vndr_seq.Index = 0;
}
 
/*
 * Tariff에 사용하는 Account 조회하기
 */ 
function searchAccount(){
	var formObj = document.form;
	formObj.f_cmd.value = COMMAND05;
	formObj.account_nm.value = "";
	accountList = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
	formObj.acct_cd.Index = 0;
} 
 
 /*
  * Tariff에 사용하는 Cost 조회하기
  */ 
 function searchCost(){
 	var formObj = document.form;
 	formObj.f_cmd.value = SEARCH02;
 	formObj.lgs_cost_nm.value = "";
 	costList = sheetObjects[sheetObjects.length-1].GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
 	formObj.cost_cd.Index = 0;
 } 
 
/*
 * UOM에 따라 Range의 Type변경
 */ 
// 2010.10.15 진마리아 CHM-201006351-01 신규 Object 및 로직 수정(DATE, DAY) 
function f_SetCellProperty(sheetObj, prefix){
	//sheetObj.InitDataValid(0, prefix + "dflt_val", vtEngUpOther, "-,.:0123456789");	//얘를 쓰면 TIME에서 에러남 
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		var uom = sheetObj.CellValue(i, prefix + "pso_meas_ut_cd");
		var objNo = Number(sheetObj.CellValue(i, prefix + "obj_list_no"));
		
		if(uom == "12"){		//FLAG		
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtCombo, daCenter,  prefix + "dflt_val" , "", dfNone);
			sheetObj.CellComboItem(i, prefix + "dflt_val", " |Y|N", " |Y|N");	//Text, Code (Code에 공백 한칸을 넣으면, Empty로 올라감)
		} else if(uom == "15"){	//TIME
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daCenter,  prefix + "dflt_val" , "", dfTimeHm);
		} else if(uom == "14"){	//CODE
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daRight,  prefix + "dflt_val" , "", dfEngUpKey);
		} else if(uom == "11"){	//N/A
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daRight,  prefix + "dflt_val" , "", dfEngUpKey);			
		} else if(uom == "16"){	//DATE
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daCenter,  prefix + "dflt_val" , "", dfDateYmd);			
		} else if(uom == "17"){	//DAY
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daCenter,  prefix + "dflt_val" , "", dfEngUpKey);			
		} else{					//Others (Number)
			sheetObj.InitCellProperty(i, prefix + "dflt_val", dtData, daRight,  prefix + "dflt_val" , "", dfNumber);
		}
		
		if(objNo >= 18 && objNo <= 22){	//Constant..
			sheetObj.CellEditable(i, prefix + "dflt_val") = false;
		} else{
			sheetObj.CellEditable(i, prefix + "dflt_val") = true;
		}
	}	
}

/*
 * 모든 Sheet 지우기
 */
function f_InitSheets(){
 	var formObj = document.form;
 	//Sheets	
 	for(var i=0; i<sheetObjects.length; i++){
 		sheetObjects[i].RemoveAll();
 	}

	//Color (initsheet에서 잘 안 됨)
//	sheetObjects[3].ColFontColor("sheet4_curr_cd") = sheetObjects[3].WebColor("#0000FF");
//	sheetObjects[3].ColFontColor("sheet4_calc_amt") = sheetObjects[3].RgbColor(0, 0, 255);
//	sheetObjects[3].CellFont("FontColor", sheetObjects[3].HeaderRows, "sheet4_locl_amt") = sheetObjects[3].RgbColor(0, 0, 255);
//	sheetObjects[3].CellFont("FontColor", sheetObjects[3].HeaderRows, "sheet4_rmk") = sheetObjects[3].RgbColor(0, 0, 255);
//
//	//Bold
//	sheetObjects[2].CellFont("FontBold", sheetObjects[2].HeaderRows, "sheet3_curr_cd") = true;
//	sheetObjects[2].CellFont("FontBold", sheetObjects[2].HeaderRows, "sheet3_calc_amt") = true;
//	sheetObjects[2].CellFont("FontBold", sheetObjects[2].HeaderRows, "sheet3_locl_amt") = true;
//	sheetObjects[2].CellFont("FontBold", sheetObjects[2].HeaderRows, "sheet3_rmk") = true;
}
 
/*
 * 
 */
function f_ClearSheets(){
	var formObj = document.form;
	f_InitSheets();

	var sheetObjs = [sheetObjects[3]];
	var colCount  = [gColCountInSheet[3]];
	for(var i=0; i < sheetObjs.length; i++){
		for(var col=0; col < colCount[i]; col++){
			sheetObjs[i].CellValue2(sheetObjs[i].HeaderRows, col) = "";
		}
	}
}

/**
 * VVD관련 데이터 설정 
 * @param obj
 * @return
 */
function getVslCdData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.vsl_cd.value = rtnDatas[1];
			}
		}
	}
}

function getVvdData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.skd_voy_no.value = rtnDatas[2];
				document.form.skd_dir_cd.value = rtnDatas[3];
			}
		}
	}
} 

function checkVvd(){
	return;
	var formObj = document.form;
	formObj.f_cmd.value = COMMAND04;
	
	var port_cd = formObj.port_cd.value;
	var yard_cd = formObj.yard_cd.Code;
	var vsl_cd = formObj.vsl_cd.value;
	var skd_voy_no = formObj.skd_voy_no.value;
	var skd_dir_cd = formObj.skd_dir_cd.value;
	
	if(port_cd != "" && yard_cd != "" && vsl_cd != "" && skd_voy_no != "" && skd_dir_cd != ""){
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
		var isValidVVD = ComGetEtcData(sXml, "isValidVVD");
		if(isValidVVD != "TRUE"){
			ComShowCodeMessage("PSO00001", "[VVD]");
			formObj.skd_dir_cd.value = "";	//Direction만 지움
		}
	}	
}

function checkVvd2(){
	var formObj = document.form;
	formObj.f_cmd.value = COMMAND04;
	
	var port_cd = formObj.port_cd.value;
	var yard_cd = formObj.yard_cd.Code;
	var vsl_cd = formObj.vsl_cd.value;
	var skd_voy_no = formObj.skd_voy_no.value;
	var skd_dir_cd = formObj.skd_dir_cd.value;
	
	if(port_cd != "" && yard_cd != "" && vsl_cd != "" && skd_voy_no != "" && skd_dir_cd != ""){
		var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", FormQueryString(formObj));
		var isValidVVD = ComGetEtcData(sXml, "isValidVVD");
		if(isValidVVD != "TRUE"){
			ComShowCodeMessage("PSO00001", "[VVD]");
			return false;
			//formObj.skd_dir_cd.value = "";	//Direction만 지움
		}
	}	
	return true;
}

/*
 * UOM Type에 따라 작은따옴표를 붙여서 서버로 전송
 */
function f_ComGetSaveString(sheetObjs){
	try{   	
		var colArr   = new Array();
		var rowArr   = new Array();
		var sheetArr = new Array();
		var colName  = "";
		var colValue = "";
		
		var name_ibflag			    = "";	
		var name_obj_list_nm        = "";
		var name_dflt_val           = "";
		var name_obj_list_no        = "";
		var name_pso_obj_list_tp_cd = "";
		var name_pso_meas_ut_cd     = "";	//11:N/A (BLANK), 12:FLAG, 13:CBM, 14:CODE, 15:TIME	 
		var name_pso_meas_ut_nm     = "";

		var val_ibflag			    = "";
		var val_obj_list_nm         = "";
		var val_dflt_val            = "";
		var val_obj_list_no         = "";
		var val_pso_obj_list_tp_cd  = "";
		var val_pso_meas_ut_cd      = "";
		var val_pso_meas_ut_nm      = "";
		
		if(sheetObjs.constructor != Array) sheetObjs = new Array(sheetObjs);
		
		for(var i=0; i < sheetObjs.length ; i++){
			var sheetObj = sheetObjs[i];
			rowArr = new Array();
			for(var row=sheetObj.HeaderRows; row < sheetObj.RowCount + sheetObj.HeaderRows && sheetObj.RowCount > 0; row++){
				var colCnt = 0;
				colArr = new Array();
				for(var col=0; col < gColCountInSheet[i]; col++){
					colName  = sheetObj.ColSaveName(col);
					colValue = sheetObj.CellValue(row, col);
					if(colName == "sheet" + (i+1) + "_ibflag"){
						name_ibflag = colName;
						val_ibflag = colValue;
					} else if(colName == "sheet" + (i+1) + "_obj_list_nm"){
						name_obj_list_nm = colName;	
						val_obj_list_nm = colValue;						
					} else if(colName == "sheet" + (i+1) + "_dflt_val"){
						name_dflt_val = colName;
						colValue = ComReplaceStr(colValue, "'", "");
						val_dflt_val = colValue;						
					} else if(colName == "sheet" + (i+1) + "_obj_list_no"){
						name_obj_list_no = colName;
						val_obj_list_no = colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_obj_list_tp_cd"){
						name_pso_obj_list_tp_cd = colName; 
						val_pso_obj_list_tp_cd = colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_meas_ut_cd"){
						name_pso_meas_ut_cd = colName;
						val_pso_meas_ut_cd = colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_meas_ut_nm"){
						name_pso_meas_ut_nm = colName;
						val_pso_meas_ut_nm = colValue;						
					}
				}
				
	    		//if(val_dflt_val != ""){	//값을 입력한 경우만..
		    		if(val_pso_meas_ut_cd == 14){			//CODE
		    			val_dflt_val = "'" + val_dflt_val + "'";
		    		} else if(val_pso_meas_ut_cd == 12){	//FLAG	('Y')
		    			val_dflt_val = "'" + val_dflt_val + "'";
		    		} else if(val_pso_meas_ut_cd == 11){	//N/A
		    			//val_dflt_val = "'" + val_dflt_val + "'";
		    		} else if(val_pso_meas_ut_cd == 15){	//TIME	('0915')
		    			//val_dflt_val = "'" + val_dflt_val + "'";
		    		} else if(val_pso_meas_ut_cd == 16){	//DATE	('20100128')
		    			val_dflt_val = "TO_DATE(" + "'" + val_dflt_val + "'" + ", 'YYYYMMDD')";
		    		} else if(val_pso_meas_ut_cd == 17){	//DAY	('SAT')
		    			val_dflt_val = "'" + val_dflt_val + "'";
		    		}
	    		//}
				
				colArr[colCnt++] = name_ibflag 				+ "=" + sheetObj.UrlEncoding(val_ibflag);
				colArr[colCnt++] = name_obj_list_nm 		+ "=" + sheetObj.UrlEncoding(val_obj_list_nm);
				colArr[colCnt++] = name_dflt_val 			+ "=" + sheetObj.UrlEncoding(val_dflt_val);
				colArr[colCnt++] = name_obj_list_no 		+ "=" + sheetObj.UrlEncoding(val_obj_list_no);
				colArr[colCnt++] = name_pso_obj_list_tp_cd 	+ "=" + sheetObj.UrlEncoding(val_pso_obj_list_tp_cd);
				colArr[colCnt++] = name_pso_meas_ut_cd 		+ "=" + sheetObj.UrlEncoding(val_pso_meas_ut_cd);
				colArr[colCnt++] = name_pso_meas_ut_nm 		+ "=" + sheetObj.UrlEncoding(val_pso_meas_ut_nm);
				
				rowArr[row-sheetObj.HeaderRows] = colArr.join("&");

			}
//			alert(rowArr.join("&"));
			sheetArr[i] = rowArr.join("&");
		}
		
		var xxx = sheetArr.join("&");
//		ComDebug("[Debug] \n" + sheetArr.length + "\n" + xxx);
		return xxx;
		
	} catch(err) { ComFuncErrMsg(err.message); }
}

 function setMultiCombo(comboObj, index) {
	  //All 인 경우
	     if(index==0) {
	      //checked
	      	if(comboObj.CheckIndex(index)) {
	      		for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	      			comboObj.CheckIndex(i) = true;
	      		}
	      	} else {
	      		for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	      			comboObj.CheckIndex(i) = false;
	      		}
	      	}
	  //All 이 아닌 경우
	     } else {
	    	 var checkCnt = 0;
	    	 for(var i = 1 ; i < comboObj.GetCount () ; i++) {
	    		 if(comboObj.CheckIndex(i)) {
	    			 checkCnt++;
	    		 }
	    	 }
	    	 if(checkCnt == comboObj.GetCount ()-1) {
	    		 comboObj.CheckIndex(0) = true;
	    	 }else{
	    		 comboObj.CheckIndex(0) = false;
	    	 }
	     }
	 }

 
 function acct_cd_OnCheckClick(comboObj, Index){
	 formObj.cost_cd.RemoveAll();
	 formObj.vndr_seq.RemoveAll();
	 setMultiCombo(comboObj, Index);
//	 f_ClearSheets();
	 //Cost Combo Setting
	 addComboItemCost();
 }
 
 function cost_cd_OnCheckClick(comboObj, Index){
	 formObj.vndr_seq.RemoveAll();
	 setMultiCombo(comboObj, Index);
//	 f_ClearSheets();
	 //Vndr Combo Setting
	 addComboItemProvider();
 }
 
 function vndr_seq_OnCheckClick(comboObj, Index){
	 setMultiCombo(comboObj, Index);
//	 f_ClearSheets();
 }
 
 function searchVslClass(){
	var sheetObj = sheetObjects[5];
	formObj.f_cmd.value = SEARCH03;
	var sParam = FormQueryString(formObj);
	var sXml = sheetObj.GetSearchXml("VOP_PSO_0038GS.do", sParam);
	var comboItems1 = ComGetEtcData(sXml, "vsl" ).split(ROWMARK); //Account
//	addComboItem(formObj.cntr_vsl_clss_capa,comboItems1);
 }

function sheet4_OnSearchEnd(sheetObj, ErrMsg){
	var sheetObj3 = sheetObjects[2];
	var sheetObj5 = sheetObjects[4];
	var acctCd = "";
	var vndrSeq = "";
	var oPrefix = sheetObj.id + "_";
	var iPrefix = sheetObj5.id + "_";
	var acctCdArr = new Array();
	var currCdArr = new Array();
	var oldAmt = 0;
	//sheet4를 acct_cd 순서대로 정렬 -> sheet3은 자동정렬됨
	sheetObj.ColumnSort(oPrefix + "acct_cd");

	//Invoice Detail(sheet5)의 account별 total 금액을 Tariff Cost Detail(sheet4)의 Invoice AMT로 가져온다.
	for(var oRow=sheetObj.HeaderRows; oRow<sheetObj.HeaderRows+sheetObj.RowCount; oRow++){
		acctCd = sheetObj.CellValue(oRow, oPrefix + "acct_cd");
		vndrSeq = sheetObj.CellValue(oRow, oPrefix + "vndr_seq");
		for(var iRow=sheetObj5.HeaderRows; iRow<sheetObj5.HeaderRows+sheetObj5.RowCount; iRow++){
			if(acctCd==sheetObj5.CellValue(iRow, iPrefix+"acct_cd") &&
					vndrSeq==sheetObj5.CellValue(iRow, iPrefix+"vndr_seq")){
				sheetObj.CellValue2(oRow, oPrefix+"locl_amt") = sheetObj5.CellValue(iRow, iPrefix+"inv_total");
				sheetObj.CellValue2(oRow, oPrefix+"inv_total") = sheetObj5.CellValue(iRow, iPrefix+"inv_total");
				sheetObj.CellValue2(oRow, oPrefix+"total_i") = sheetObj5.CellValue(iRow, iPrefix+"total_i");
				sheetObj.CellValue2(oRow, oPrefix+"total_o") = sheetObj5.CellValue(iRow, iPrefix+"total_o");
				break;
			}
		}
	}

	//Tariff Cost Detail(sheet4)의 Calculated AMT를 account별로 합산하여 sheet3의 Tariff Cost로 가져온다.
	var prefix = sheetObj.id + "_";
	for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+sheetObj.RowCount; Row++){
		acctCd = sheetObj.CellValue(Row, oPrefix + "acct_cd");
		vndrSeq = sheetObj.CellValue(Row, oPrefix + "vndr_seq");
		currCd = sheetObj.CellValue(Row, oPrefix + "curr_cd");
		if(acctCdArr[acctCd]){
			oldAmt = Number(acctCdArr[acctCd]);
		}else{
			oldAmt = 0;
		}
		if(document.form.currType[0].checked){
			acctCdArr[acctCd] = oldAmt + Number(sheetObj.CellValue(Row, prefix+"tariff_amount"));
			currCdArr[acctCd] = sheetObj.CellValue(Row, prefix+"curr_cd");
		}else{
			acctCdArr[acctCd] = oldAmt + Number(sheetObj.CellValue(Row, prefix+"tariff_usd_amount"));
			currCdArr[acctCd] = "USD";
		}
		
		
	}
	
	prefix = sheetObj3.id + "_";
	sheetObj3.RemoveAll();
	var total = 0;
	var row;
	var oldCurr = null;
	var newCurr;
	var mixCurr = false;
	
	for(var Row in acctCdArr){
		row = sheetObj3.DataInsert(-1);
		sheetObj3.CellValue(row, prefix+"acct_cd") = Row;
		sheetObj3.CellValue(row, prefix+"tariff_cost") = acctCdArr[Row];
		sheetObj3.CellValue(row, prefix+"curr_cd") = currCdArr[Row];
		newCurr = currCdArr[Row];
		if(oldCurr != null){
			if(newCurr != oldCurr){
				mixCurr = true;
			}
		}
		oldCurr = newCurr;
	}
	if(mixCurr){
		sheetObj3.CellValue(sheetObj3.LastRow, prefix+"tariff_cost") = "-";
	}
}

//IN,OUT 선택시 sheet4의 Invoice AMT 값을 변화시켜준다.
function checkInOutValue(){
	var sheetObj = sheetObjects[1];
	var sheetObj4 = sheetObjects[3];
	var prefix = sheetObj.id + "_";
	var iprefix = sheetObj4.id + "_";
	var inValue = "";
	var outValue = "";
	sheetObj.ShowDebugMsg = false;
	for(j=sheetObj.HeaderRows; j<sheetObj.HeaderRows + sheetObj.RowCount; j++){
		if(sheetObj.CellValue(j, prefix+"obj_list_no")=="77"){
			inValue = sheetObj.CellValue(j, prefix+"dflt_val");
		}if(sheetObj.CellValue(j, prefix+"obj_list_no")=="89"){
			outValue = sheetObj.CellValue(j, prefix+"dflt_val");
		}
	}
	if(inValue == "Y" && outValue == "Y"){
		for(i=sheetObj4.HeaderRows; i<sheetObj4.HeaderRows + sheetObj4.RowCount; i++){
			sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
		}
	}else if(inValue == "Y" && outValue == "N"){
		for(i=sheetObj4.HeaderRows; i<sheetObj4.HeaderRows + sheetObj4.RowCount; i++){
			if(sheetObj4.CellValue(i,iprefix+"total_i")>0 && sheetObj4.CellValue(i,iprefix+"total_o")>0){
			sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_i");
			}else{
				sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
			}
		}
	}else if(inValue == "N" && outValue == "Y"){
		for(i=sheetObj4.HeaderRows; i<sheetObj4.HeaderRows + sheetObj4.RowCount; i++){
			if(sheetObj4.CellValue(i,iprefix+"total_i")>0 && sheetObj4.CellValue(i,iprefix+"total_o")>0){
				sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"total_o");
			}else{
				sheetObj4.CellValue(i,iprefix+"locl_amt") = sheetObj4.CellValue(i,iprefix+"inv_total");
			}			
		}
	}
}

//acct_cd가 all일 때는 IN & OUT 의 value는 "Y"
function changeInOut(){
	var formObj = document.form;
	var sheetObj2 = sheetObjects[1];
	var prefix = "sheet2_";
	sheetObj2.ShowDebugMsg = false;
	if(formObj.acct_cd.text.substring(0,3)=="ALL"){
		for(var i=sheetObj2.HeaderRows; i<sheetObj2.HeaderRows + sheetObj2.RowCount; i++){
			if(sheetObj2.CellValue(i, prefix+"obj_list_no")=="77" || sheetObj2.CellValue(i, prefix+"obj_list_no")=="89"){
				sheetObj2.CellValue(i, prefix+"dflt_val")="Y";
			}
		}
	}else return false;
}

/*
 * EAS Auto Audit 화면에서 팝업으로 호출한 경우 조건 세팅
 */
function simSearchAudit(pPortCd, pYardCd, pAcctCd, pCostCd, pVvd, pVndrSeq, pIssueDate){
//	ComShowMessage("Tariff Simulation");
	//port_cd, yard_cd, acct_cd, cost_cd, vsl_cd, skd_voy_no, skd_dir_cd, issue_date, vndr_seq 세팅
	var formObj = document.form;
	formObj.port_cd.value = pPortCd;
	loadTerminal();//COMBO YARD
	f_ClearSheets();
	
	document.getElementById("yard_cd").Code2 = pYardCd.substr(5, 2);
	
	formObj.vsl_cd.value = pVvd.substr(0, 4);
	formObj.skd_voy_no.value = pVvd.substr(4, 4);
	formObj.skd_dir_cd.value = pVvd.substr(8, 1);
	formObj.issue_date.value = pIssueDate;
	
	document.getElementById("acct_cd").InsertItem(0, pAcctCd, pAcctCd); 	
	document.getElementById("cost_cd").InsertItem(0, pCostCd, pCostCd);	
	document.getElementById("vndr_seq").InsertItem(0, pVndrSeq, pVndrSeq);
	document.getElementById("acct_cd").Index2 = 0;
	document.getElementById("cost_cd").Index2 = 0;
	document.getElementById("vndr_seq").Index2 = 0;
	
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	changeInOut();
}
 /* 개발자 작업  끝 */