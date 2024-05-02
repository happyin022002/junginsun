/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0019.js
 *@FileTitle : Detail_Yearly Expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block
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
 * @class Expense Code Inquiry : Expense Code Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0019(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;	
	
	this.initProperty = initProperty;
	this.initKeySetting = initKeySetting;
	this.isHeaderSetting = isHeaderSetting;
	this.setInSheetRowReset = setInSheetRowReset;
	this.setAtSheetRowReset = setAtSheetRowReset;
	this.getBackEndJobStatus = getBackEndJobStatus;
	this.comShowBackEndErrorMsg = comShowBackEndErrorMsg;
	this.getBackEndJobLoadFileByYearly = getBackEndJobLoadFileByYearly;
	this.getBackEndJobLoadFileByRequestInitial = getBackEndJobLoadFileByRequestInitial;
	this.getBackEndJobLoadFileByRequestRqstNo = getBackEndJobLoadFileByRequestRqstNo;
	
	// sheet
	this.sheet1_OnChange = sheet1_OnChange;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnPopupClick = sheet1_OnPopupClick;
		
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;
var frm = null;
var sheet1 = null;
var sheet2 = null;
var sheet3 = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var combo2 = null;
var combo3 = null;
var comboCnt = 0;
var curYear = "";
var loginYear = "";

var timer;
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
  comboObjects[comboCnt++] = combo_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(year) {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheet2 = sheetObjects[1];
	sheet3 = sheetObjects[2];
	sheetCnt = sheetObjects.length ;
	
	// 시트의 초기화
	for(i=0;i<sheetCnt;i++){
		//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
	}

	// combo
	combo1 = comboObjects[0];
	combo2 = comboObjects[1];
	combo3 = comboObjects[2];
	comboCnt = comboObjects.length;
	
	// IBMultiCombo초기화
    for(var k=0; k<comboObjects.length; k++){
        initCombo(comboObjects[k]);
    }    
	
    // html컨트롤 이벤트초기화
    initControl();
        
    // Popup오픈시 화면에 전달하려는 값을 Set
	if(frm.popup.value == "Y") {
		// Year
		if(frm.popYear.value != "") {
			frm.sch_yrmon.value = frm.popYear.value;
		}
		
		// Language
		if(frm.popLang.value != "") {
			if(frm.popLang.value == "K") {
				frm.sch_lang[0].checked = true;
				frm.sch_lang[1].checked = false;
			} else {
				frm.sch_lang[0].checked = false;
				frm.sch_lang[1].checked = true;
			}
		}
	}
	
    // 현재년도 설정
    if (frm.sch_yrmon.value == "") {
    	frm.sch_yrmon.value = year;
    }
    curYear   = frm.sch_yrmon.value;
    loginYear = year;
        
	// 초기Data조회
	doActionIBSheet(IBSEARCH);
	
	// Sheet를 초기화한후 다시 변경해야함.
	initProperty(INIT);
}

/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	
    if (comboObj.id == "combo3") {
    	comboObj.MultiSelect = true;
    } else {
    	comboObj.MultiSelect = false;
    }  
	
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 190;
}

/**
* 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
* 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetObj.id) {
		case "sheet1":
			with (sheetObj) {

				// 높이 설정
				style.height = 150;
				   
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 18, 100);
				
				var HeadTitle1 = "|Year|1st Group CD|1st Group Name|2nd Group CD|2nd Group Name|Expense CD|Expense Name|Item_No|Item_DESC|TIC|Office|RHQ|CUR|UNIT|Salary|Company|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|INT_TTL|ADD_TTL|TRN_TTL|GRD_TTL|CAL_BASIS|Requester's Opinion";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 2, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
					
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"pln_yrmon",			false,		"",			dfNone);            
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"lvl1_code",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"lvl1_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"lvl2_code",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"lvl2_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"lvl4_code",			false,		"",			dfNone);  
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"lvl4_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"gen_expn_itm_no",		false,		"",			dfNone);  
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"gen_expn_itm_desc",	false,		"",			dfNone);  
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"lvl4_tic",				false,		"",			dfNone);    
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone);    
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"rhq",					false,		"",			dfNone);    
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"locl_curr_cd",			false,		"",			dfNone);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"rqst_ut_val",			false,		"",			dfInteger);    
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"saly_flg",				false,		"",			dfNone);    
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_co_div_cd",		false,		"",			dfNone);  
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jan",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"feb",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"mar",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"apr",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"may",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jun",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jul",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"aug",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"sep",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"oct",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"nov",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"dec",					false,		"",			dfFloat,	3);    
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"int_ttl",				false,		"",			dfFloat,	3);  
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"add_ttl",				false,		"",			dfFloat,	3);  
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"trn_ttl",				false,		"",			dfFloat,	3);  
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"grd_ttl",				false,		"",			dfFloat,	3);  
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"cal_basis",			false,		"",			dfNone);  
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"apro_opin_rmk",		false,		"",			dfNone);
			}
			break;
		case "sheet2":
			with (sheetObj) {

				// 높이 설정
				style.height = 150;
				   
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 18, 100);
				
				//alert("sheet2 : "+schYear +"=="+ loginYear);
				
				var HeadTitle1 = "|CC|CUR|UNIT|Year|OFC|COM|RHQ l BU|Region|Salary|Expense Code|Expense Code\nName|TIC|1st Group|2nd Group|Ex. Rate |Ex. Rate |Ex. Rate |Performance (USD)|Performance (USD)|Performance (USD)|Assigned(USD)|Assigned(USD)|Next Year Planning(USD)|Next Year Planning(USD)|Next Year Planning(USD)|Next Year Planning(USD)|Next Year Planning(LCL)|Next Year Planning(LCL)|Next Year Planning(LCL)|Next Year Planning(LCL)|Performance (LCL)|Performance (LCL)|Performance (LCL)|Performance (LCL)|Performance (LCL)|Assigned (LCL)|Assigned (LCL)|Assigned (LCL)"
				var HeadTitle2 = "|CC|CUR|UNIT|Year|OFC|COM|RHQ l BU|Region|Salary|Expense Code|Expense Code\nName|TIC|1st Group|2nd Group|2008|2008|2009|2006|2007|2008| 2008| 2008|RQST|RQST|RQST|RQST| RQST| RQST| RQST| RQST|2008|2008|2008|2007|2006|2008|2007|2006"
				var HeadTitle3 = "|CC|CUR|UNIT|Year|OFC|COM|RHQ l BU|Region|Salary|Expense Code|Expense Code\nName|TIC|1st Group|2nd Group|Plan|Average|Plan|ER.Rate\n(Acct.) |ER.Rate\n(Acct.)|ER.Rate\n(Plan,Acct.)|This year\nER.Rate\n(Plan)|Next year\nER.Rate\n(Plan)|COM\n(Final)|TIC|RHQ l BU|OFC|COM\n(Final)|TIC|RHQ l BU|OFC|EST.\n(A+B)|JAN:AUG\nPFM.(A)|SEP:DEC\nPlan(B)|2007|2006|2008|2007|2006"

				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 2, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);
					
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_expn",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"locl_curr_cd",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"rqst_ut_val",			false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"yrmon",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_cd",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_co_div_cd",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"rhq_ofc_cd",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"rgn_ofc_flg",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"sls_ofc_flg",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"gen_expn_cd",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"expn_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"tic_cd",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"lvl1_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"lvl2_name",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"ex_rate_plan_pre",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"ex_rate_avg",			false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"ex_rate_plan",			false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_usd_amt1",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_usd_amt2",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_usd_amt3",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"assi_usd_amt1",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"assi_usd_amt2",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_usd_com_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_usd_tic_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_usd_rhq_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_usd_ofc_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_lcl_com_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_lcl_tic_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_lcl_rhq_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"plan_lcl_ofc_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_lcl_est_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_lcl_pfm_amt",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_lcl_plan_amt",	false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_lcl_amt3",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"perf_lcl_amt2",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"assi_lcl_amt3",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"assi_lcl_amt2",		false,		"",			dfFloat,	3);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"assi_lcl_amt1",		false,		"",			dfFloat,	3);
				
				sheetObj.HeadRowHeight = 30;				
			}
			break;
		case "sheet3":
			with (sheetObj) {

				// 높이 설정
				style.height = 100;
				   
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 18, 100);
				
				var HeadTitle1 = "|RQST_NO|OFC_STS|RHQlBU_STS|TIC_STS|COM_STS|OFC_CD|RHQ_OFC|CUR_CD|UNIT|Expense_CODE|EXPN_Name|TIC_OFC|ITEM|ITEM_DESCRIPTION|MM1|MM2|MM3|MM4|MM5|MM6|MM7|MM8|MM9|MM10|MM11|MM12|OFC_TOTAL|RHQ_TOTAL|TIC_TOTAL|COM_TOTAL|CALCULATION_BASIS|OPINION|CREATOR";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 2, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
					
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"gen_expn_rqst_no",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_sts",					false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"rhqlbu_sts",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"tic_sts",					false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"com_sts",					false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"ofc_cd",					false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"rhq_ofc_cd",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"locl_curr_cd",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"rqst_ut_val",				false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"gen_expn_cd",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"expn_abbr_nm",				false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"tic_cd",					false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"gen_expn_itm_no",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"gen_expn_itm_desc",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jan_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"feb_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"mar_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"apr_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"may_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jun_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"jul_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"aug_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"sep_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"oct_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"nov_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"dec_amt",					false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"ofc_total",				false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"rhqlbu_total",				false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"tic_total",				false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daRight,	true,		"com_total",				false,		"",			dfInteger);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"gen_expn_calc_bss_desc",	false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daLeft,		true,		"rqst_opin_rmk",			false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				100,		daCenter,	true,		"cre_usr_id",				false,		"",			dfNone);
				
			}
			break;
   }
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	switch (sAction) {
		case IBSEARCH: //Open시
			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm));
			var arrXml = sXml.split("|$$|");		
			//alert(arrXml);
			var langDiv = getColNameValue("sch_lang");
			
			// ---------------------------------
			// BU Office List(LEVEL2)
			// ---------------------------------
			var comboListData = ComGetEtcData(arrXml[0], "searchBUOfficeList").split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl1;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
			
			// ---------------------------------
			// Tic Code 
			// ---------------------------------
			var comboTicData = ComGetEtcData(arrXml[0], "ticList").split("|");
	   		if(typeof comboTicData != "undefined" && comboTicData != "") {	
				var ticCd = frm.sch_tic_cd;
				ticCd.length = 0;
				ComAddComboItem(ticCd,"","");
				
				for(var i=0 ; i < comboTicData.length ; i++ ) {
					ComAddComboItem(ticCd,comboTicData[i],comboTicData[i]);
				}
	   		}
	   		
			// ---------------------------------
  			// Expense Form ~ To 
  			// ---------------------------------
  			var arrTempData = ComXml2ListMap(arrXml[0]);
  			combo1.InsertItem(0, "|", "");
  			combo2.InsertItem(0, "|", "");
			var k1 = 1;
			var k2 = 1;
  			for(var i=0 ; i < arrTempData.length ; i++ ) {
  				var tempData = arrTempData[i];
  				
  				if(langDiv == "K") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
  			}
  			
  			combo1.Code = "";
  			combo2.Code = "";
  			  			  			
			// ---------------------------------
			// Group Expense 
			// ---------------------------------
			var arrTempData = ComXml2ListMap(arrXml[1]);	
			combo3.InsertItem(0,"Select All","");
			var k = 1;
			for(var i=0 ; i < arrTempData.length ; i++ ) {
				var tempData = arrTempData[i];
				
				if(langDiv == "K") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo3.Code = "";
			
			// ---------------------------------
			// Open시 권한에 의한 BU정보 컨트롤 Start..
			// Open시 권한에 의한 BU정보 컨트롤 End..
			// ---------------------------------
			isOfficeAuthCheck();
					
	 	   	break;
	 	   	
		case SEARCHLIST01: // LEVEL3 조회
			frm.f_cmd.value = SEARCHLIST01;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
			
			// ---------------------------------
			// Major List(LEVEL3)
			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMajorList").split("|");
			//alert("comboListData : "+comboListData);
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl2;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
			
			break;
		case SEARCHLIST02: // LEVEL4 조회
			frm.f_cmd.value = SEARCHLIST02;
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
			
			// ---------------------------------
			// Minor List(LEVEL4)
			// ---------------------------------
			var comboListData = ComGetEtcData(sXml, "searchMinorList").split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = frm.sch_lvl3;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
				
			break;
		case SEARCHLIST03: // Expense조회
			frm.f_cmd.value = SEARCHLIST01;
			frm.sch_expense_from.value = combo1.Code;
			frm.sch_expense_to.value = combo2.Code;
		
			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
			
			var langDiv = getColNameValue("sch_lang");
			var preCombo1 = combo1.Code;
			var preCombo2 = combo2.Code;
			
			// ---------------------------------
			// Expense Form ~ To 
			// ---------------------------------
			combo1.RemoveAll(); 
			combo2.RemoveAll();
			var arrTempData = ComXml2ListMap(sXml);	
			combo1.InsertItem(0, "|", "");
			combo2.InsertItem(0, "|", "");
			var k1 = 1;
			var k2 = 1;
			for(var i=0 ; i < arrTempData.length ; i++ ) {
				var tempData = arrTempData[i];
				  				
				if(langDiv == "K") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo1.Code = preCombo1;
			combo2.Code = preCombo2;
				
			break;
		case SEARCHLIST04: // Group Expense
			frm.f_cmd.value = SEARCHLIST04;
			
			var sXml = sheet1.GetSearchXml("CPS_GEM_0013GS.do", FormQueryString(frm));
			
			var langDiv = getColNameValue("sch_lang");
			var preCombo1 = combo3.Code;
			combo3.RemoveAll();
			
			// ---------------------------------
			// Group Expense 
			// ---------------------------------
			var arrTempData = ComXml2ListMap(sXml);
			combo3.InsertItem(0,"Select All","");
			var k = 1;
			for(var i=0 ; i < arrTempData.length ; i++ ) {
				var tempData = arrTempData[i];
				
				if(langDiv == "K") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo3.Code = preCombo1;			
			break;
		
	}
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	//axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	//axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
	switch (event.srcElement.name) {    
	    case "sch_yrmon":
	    	ComKeyOnlyNumber(event.srcElement);
	    	//if(event.keyCode == 13) {doActionIBSheet(IBSEARCH);}
			break;
	}	
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_deactivate(){
	switch(event.srcElement.name){
		case "sch_yrmon":
			//헤더시트값변경을 위한 호출
			initProperty(SEARCH);
			break;
	}
}

/**
 * HTML Control Foucs in
 */
function obj_activate(){
   ComClearSeparator(event.srcElement);
}
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		//alert("srcName : "+srcName);
		switch (srcName) {
			case "sch_yrmon_cal":
				var cal = new ComCalendar();
				cal.setDisplayType('year');
				cal.select(frm.sch_yrmon, 'yyyy');
	            break;
			case "btn_New":
				// Do you want to initialize?
				if(!ComCodeMsgByInitialize()) return;
				ComResetAll();
				newButtonClear();
				break;
			case "btn_DownExcel":
				//if (!ComChkValid(frm)) return false;
				if(validateForm(SEARCHLIST)) {
					var strCond = getColNameValue("sch_condition");
					var strTarget = getColNameValue("sch_target");
					
					frm.sch_expense_from.value = combo1.Code;
					frm.sch_expense_to.value = combo2.Code;
					frm.sch_expense_group.value = combo3.Code;
					
					if(strCond == "R" && strTarget == "EI") {
						// sheet2
						frm.f_cmd.value = SEARCHLIST04;
						var sXml = sheet2.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
						var arrXml = sXml.split("|$$|");
						
						var backendJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
						if (backendJobKey.length > 0) {
							frm.backendjob_key.value = backendJobKey;
							sheet2.WaitImageVisible = false;
							ComOpenWait(true);			
							//getBackEndJobStatus();
							sheet2.RequestTimeOut = 10000;
							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}
					} else if(strCond == "R" && strTarget == "ED") {
						// sheet3
						frm.f_cmd.value = SEARCHLIST06;
						var sXml = sheet3.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
						var arrXml = sXml.split("|$$|");
						
						var backendJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
						if (backendJobKey.length > 0) {
							frm.backendjob_key.value = backendJobKey;
							sheet3.WaitImageVisible = false;
							ComOpenWait(true);			
							//getBackEndJobStatus();
							sheet3.RequestTimeOut = 10000;
							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}
					} else {
						// sheet1
						frm.f_cmd.value = SEARCHLIST01;
						var sXml = sheet1.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
						var arrXml = sXml.split("|$$|");
						
						var backendJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
						if (backendJobKey.length > 0) {
							frm.backendjob_key.value = backendJobKey;
							sheet1.WaitImageVisible = false;
							ComOpenWait(true);			
							//getBackEndJobStatus();
							sheet1.RequestTimeOut = 10000;
							timer=setInterval(getBackEndJobStatus, 3000); //3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						}
					}
				}				
				break;
				
			case "btn_Popup":
				/*
				var param = "popup=Y";
					param +="&popYear=2010";
					param +="&popLang=E";
					param +="&popBuCd=Y";
					param +="&popOfcCd=ATLBB";
					param +="&popExpnCd=213001";
					
				var url = "CPS_GEM_0019.do?"+param;
				var winName = "CPS_GEM_0019";
				
				var win = ComOpenWindowCenter(url,winName,1040,700, false);
				win.focus();					
				break;
				*/
			case "btn_Close":	
				self.close();	
				break;
			case "chk_commit":
				
				if ( frm.chk_commit.checked ) {
					frm.usr_tic_cd.value = "";
					frm.auth_flg.value = "YNYY"; 
				} else {
					frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
					frm.auth_flg.value = "YNYN";
				}
				
				break;					
		} // end switch
	} catch (e){
		if (e == "[object Error]"){
			// GEM01027	ENG	W	지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}
	}
}

//===================================================================================
//Private function
//===================================================================================
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction){
	if (!ComChkValid(frm)) return false;
	
	if(sAction == SEARCHLIST) {
		/*
		if(frm.sch_yrmon.value != '') {
			ComShowCodeMessage("GEM00003","Year");
			return false;
		}
		*/
		var fromCd = combo1.Code;
		var toCd = combo2.Code;		
		if(parseInt(toCd.replace(/-/g, '')) < parseInt(fromCd.replace(/-/g, ''))) {
			// GEM01038	ENG	W	검색값의 범위입력 오류!
			ComShowCodeMessage("GEM01037");
			combo1.focus();
			return false;
		}		
	}
	return true;
}

/**
* 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
* @return
*/
function initProperty(sAction) {
	switch (sAction) {		
		case INIT: //Init시
			// Header Color지정
			var iColor1= sheet2.RgbColor(255, 190, 255);
			var iColor2= sheet2.RgbColor(255, 192, 255);
			var iColor3= sheet2.RgbColor(255, 193, 255);
			var iColor4= sheet2.RgbColor(255, 194, 255);
			
			// Sheet2의 Header의 색상을 변경
			for (var i=1; i < sheet2.HeaderRows; i++) {    	
		    	if(i == 2) sheet2.RowBackColor(i) = iColor1;
		    }
			
			// sch_condition이 Yearly Expense인경우 sch_target의 Detail for RQST NO 를 disabled시킴.
			var c = document.getElementsByName("sch_target");
			for (var i = 0; i < c.length; i++)	{
				if(c[i].value == "ED") {
					c[i].disabled = true;
				} else {
					c[i].disabled = false;
				}
			}
			
			// LEVEL과 STATUS의 값을 초기화
			isCondChange("sch_app_div_gbn","CO");
			isCondChange("sch_status","AP");
						
			// Popup오픈시 화면에 전달하려는 값을 Set
			if(frm.popup.value == "Y") {
				// Condition
				frm.sch_condition[1].checked = true;
				isCondition();
				
				// Office
				if(frm.popOfcCd.value != "") {
					//isOfficeAuthCheck();
				}
				
  				// Expnese
  				if(frm.popExpnCd.value != "") {
	  				combo1.Code = frm.popExpnCd.value;
	  				combo2.Code = frm.popExpnCd.value;
  				}
  			}
			
			// sheet2의 Header Setting
			isHeaderSetting();
			break;
		case SEARCH: //년도변경시
			// sheet2의 Header Setting
			isHeaderSetting();
			
			break;
	}
}

function isHeaderSetting(){
	// 1.Sheet2의 Header Setting
	schYear = frm.sch_yrmon.value;
	loginYear = schYear - 1; 
	//alert("ibsearch : "+schYear +"=="+ loginYear);
	
	// 16.
	sheet2.CellValue2(1,15) = schYear - 1;
	sheet2.CellValue2(1,16) = schYear - 1;
	sheet2.CellValue2(1,17) = schYear;
	
	// 17.
	sheet2.CellValue2(1,18) = loginYear - 2;
	sheet2.CellValue2(1,19) = loginYear - 1;
	sheet2.CellValue2(1,20) = loginYear;
	
	// 18.
	sheet2.CellValue2(1,21) = " "+loginYear;
	sheet2.CellValue2(1,22) = " "+loginYear;
	
	// 21.
	sheet2.CellValue2(1,31) = loginYear;
	sheet2.CellValue2(1,32) = loginYear;
	sheet2.CellValue2(1,33) = loginYear;
	
	sheet2.CellValue2(1,34) = loginYear - 1;
	sheet2.CellValue2(1,35) = loginYear - 2;
	sheet2.CellValue2(2,34) = loginYear - 1;
	sheet2.CellValue2(2,35) = loginYear - 2;
	
	// 22.
	sheet2.CellValue2(1,36) = loginYear;
	sheet2.CellValue2(1,37) = loginYear - 1;
	sheet2.CellValue2(1,38) = loginYear - 2;
	
	sheet2.CellValue2(2,36) = loginYear;
	sheet2.CellValue2(2,37) = loginYear - 1;
	sheet2.CellValue2(2,38) = loginYear - 2;
}

/**
 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
 */
function getBackEndJobStatus() {
	var strCond = getColNameValue("sch_condition");
	var strTarget = getColNameValue("sch_target");
	if(strCond == "R" && strTarget == "EI") {
		// sheet2
		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet2.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		//alert("sheet2 :::>> jobState : "+jobState);
	
		if(jobState == "3") {
	    	//alert("sheet2 jobState : "+jobState);
	    	getBackEndJobLoadFileByRequestInitial();
	    	clearInterval(timer);
	    	//alert("sheet2 clear end");
	    } else if(jobState == "4") {
	    	// BackEndJob을 실패 하였습니다.
	    	comShowBackEndErrorMsg('GEM01059');
	    } else if(jobState == "5") {
	    	// 이미 BackEndJob 결과 파일을 읽었습니다.
	    	comShowBackEndErrorMsg('GEM01060');
	    }
	} else if(strCond == "R" && strTarget == "ED") {
		// sheet3
		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet3.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		//alert("sheet3 :::>> jobState : "+jobState);
	
		if(jobState == "3") {
	    	//alert("sheet3 jobState : "+jobState);
	    	getBackEndJobLoadFileByRequestRqstNo();
	    	clearInterval(timer);
	    	//alert("sheet3 clear end");
	    } else if(jobState == "4") {
	    	// BackEndJob을 실패 하였습니다.
	    	comShowBackEndErrorMsg('GEM01059');
	    } else if(jobState == "5") {
	    	// 이미 BackEndJob 결과 파일을 읽었습니다.
	    	comShowBackEndErrorMsg('GEM01060');
	    }
	} else {
		// sheet1
		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet1.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		//alert("sheet1 :::>> jobState : "+jobState);
	
		if(jobState == "3") {
	    	//alert("sheet1 jobState : "+jobState);
	    	getBackEndJobLoadFileByYearly();
	    	clearInterval(timer);
	    	//alert("sheet1 clear end");
	    } else if(jobState == "4") {
	    	// BackEndJob을 실패 하였습니다.
	    	comShowBackEndErrorMsg('GEM01059');
	    } else if(jobState == "5") {
	    	// 이미 BackEndJob 결과 파일을 읽었습니다.
	    	comShowBackEndErrorMsg('GEM01060');
	    }
	}
}

/**
 * BackEedJob 관련 Error 처리결과를 메세지로 보여준다.
 * @param errCode
 * @return
 */
function comShowBackEndErrorMsg(errCode) {
	ComShowCodeMessage(errCode);
	clearInterval(timer);
	ComOpenWait(false);
}

/**
 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Yearly Expense)
 */
function getBackEndJobLoadFileByYearly() {
	// sheet1
	frm.f_cmd.value = SEARCHLIST03;
	var sXml = sheet1.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
	var arrXml = sXml.split("|$$|");
	//alert("arrXml : "+arrXml);
	if(arrXml.length > 0) {
		sheet1.LoadSearchXml(arrXml[0]);
	}
	ComOpenWait(false);
	
	if (sheet1.RowCount <= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		var condVal = getColNameValue("sch_condition");
		var targetVal = getColNameValue("sch_target");
		var columnSkipList = "";
		if(condVal == "Y" && targetVal == "EI") {
			columnSkipList = "30|31|32";
			//sheet1.SpeedDown2Excel(1,false,false,"","apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0019_04.xml",false,false,"Yearly Expense",true,columnSkipList);
			sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Yearly Expense",true,columnSkipList);
		} else {
			//sheet1.SpeedDown2Excel(1,false,false,"","apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0019_01.xml",false,false,"Yearly Expense",true,columnSkipList);
			sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Yearly Expense",true,columnSkipList);
		}
	}
}
 
/**
 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
 */
function getBackEndJobLoadFileByRequestInitial() {
	// sheet2
	frm.f_cmd.value = SEARCHLIST05;
	var sXml = sheet2.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
	var arrXml = sXml.split("|$$|");
	//alert("arrXml : "+arrXml);
	if(arrXml.length > 0) {
		sheet2.LoadSearchXml(arrXml[0]);
	}
	ComOpenWait(false);
	
	if (sheet2.RowCount <= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		var columnSkipList = "";		
		//sheet2.SpeedDown2Excel(1,false,false,"","apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0019_02.xml",false,false,"Request Expense Initial",true,columnSkipList);
		sheet2.SpeedDown2Excel(1,false,false,"","",false,false,"Request Expense Initial",true,columnSkipList);
	}
}
 
/**
 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Detail)
 */
function getBackEndJobLoadFileByRequestRqstNo() {
	// sheet3
	frm.f_cmd.value = SEARCHLIST07;
	var sXml = sheet3.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm),-1,false);
	var arrXml = sXml.split("|$$|");
	//alert("arrXml : "+arrXml);
	if(arrXml.length > 0) {
		sheet3.LoadSearchXml(arrXml[0]);
	}
	ComOpenWait(false);
	
	if (sheet3.RowCount <= 0 ) {
		// There is no related data!
		ComCodeMsgByNoRelatedData();
		return;
	} else {
		var columnSkipList = "";		
		//sheet3.SpeedDown2Excel(1,false,false,"","apps/alps/cps/gem/gemplanningperformance/gemplanningperformance/script/CPS_GEM_0019_03.xml",false,false,"Request Expense Detail",true,columnSkipList);
		sheet3.SpeedDown2Excel(1,false,false,"","",false,false,"Request Expense Detail",true,columnSkipList);
	}
}
 
/**
* New버튼 클릭시 초기화 이벤트
*/
function newButtonClear() {
	// 초기Data조회
	//doActionIBSheet(IBSEARCH);
	
	// Target
	// Sheet를 초기화한후 다시 변경해야함.
	initProperty(INIT);
	
	// ---------------------------------
	// Open시 권한에 의한 BU정보 컨트롤 Start..
	// Open시 권한에 의한 BU정보 컨트롤 End..
	// ---------------------------------
	isOfficeAuthCheck();
	
	/*
	// app_div_gubun
	var colName = "sch_app_div_gbn";
	var c1 = document.getElementsByName(colName);	
    for (var i = 0; i < c1.length; i++)	{
		var subCol = colName+"["+i+"]";
		eval('document.all.'+subCol+'.checked = false');
		eval('document.all.'+subCol+'.disabled = false');
	}
    
	// Status
	var colName = "sch_status";
	var c2 = document.getElementsByName(colName);
    for (var i = 0; i < c2.length; i++)	{
		var subCol = colName+"["+i+"]";
		eval('document.all.'+subCol+'.checked = false');
		eval('document.all.'+subCol+'.disabled = false');
	}
	*/
}

/**
* 검색 언어 선택시 Expense, Accout, Group Expense의 값을 변경
*/
function isLangCheck(val) {
	// group expense
	doActionIBSheet(SEARCHLIST03);
	doActionIBSheet(SEARCHLIST04);
}

/**
 * 검색조건에 Condition에 따라 변함.
 * @param val
 * @return
 */
function isCondition(val) {
	var colValue = getColNameValue("sch_condition");
	var c = document.getElementsByName("sch_target");
	if(colValue == "R") {
		for (var i = 0; i < c.length; i++)	{
			if(c[i].value == "EI" || c[i].value == "ED") {
				c[0].checked = true;
				c[i].disabled = false;
			} else {
				c[i].checked = false;
				c[i].disabled = true;
			}
		}
		isCondChange("sch_app_div_gbn","");
		isCondChange("sch_status","");
		
		var nYear = parseInt(curYear,10) +  1;
		
		frm.sch_yrmon.value = nYear ;
		isHeaderSetting();
	} else {
		for (var i = 0; i < c.length; i++)	{
			if(c[i].value == "PE") {
				c[i].checked = true;
			} else {
				c[i].checked = false;
			}
			
			if(c[i].value == "ED") {
				c[i].disabled = true;
			} else {
				c[i].disabled = false;
			}
		}
		isCondChange("sch_app_div_gbn","CO");
		isCondChange("sch_status","AP");
		frm.sch_yrmon.value =  curYear;
		isHeaderSetting();
	}	
}

/**
 * sch_condition가 변경될때마다 LEVEL과 STATUS의 값이 Default Setting됨.
 * @param colName
 * @param chkValue
 * @return
 */
function isCondChange(colName, chkValue) {
	//alert("isCondChange  : "+colName+"=="+chkValue);

	var strCond = getColNameValue("sch_condition");
	var strTarget = getColNameValue("sch_target");
	
	var c = document.getElementsByName(colName);
	if(strCond != "R") {
		for (var i = 0; i < c.length; i++)	{
			if(c[i].value == chkValue) {
				c[i].checked = true;
				c[i].disabled = true;
			} else {
				c[i].checked = false;
				c[i].disabled = true;
			}
		}
	} else isTargetChange();
}

/**
 * sch_target이 변경될때마다 LEVEL과 STATUS의 값이 Default Setting됨.
 * @param colName
 * @param chkValue
 * @return
 */
function isTargetChange(colName, chkValue) {
	var strCond = getColNameValue("sch_condition");
	var strTarget = getColNameValue("sch_target");
	
	if(strCond == "R") {
		if(strTarget == "EI") {
			// sch_target이 변경될때마다 LEVEL값이 활성화
			var c = document.getElementsByName("sch_app_div_gbn");
			for (var i = 0; i < c.length; i++)	{
				c[0].checked = true;
				c[i].disabled = false;
			}
			
			// sch_target이 변경될때마다 STAUS값이 비활성화
			var d = document.getElementsByName("sch_status");
			for (var i = 0; i < d.length; i++)	{
				d[i].checked = true;
				d[i].disabled = true;
			}
		} else if(strTarget == "ED") {
			// sch_target이 변경될때마다 LEVEL값이 활성화
			var c = document.getElementsByName("sch_app_div_gbn");
			for (var i = 0; i < c.length; i++)	{
				c[0].checked = true;
				c[i].disabled = false;
			}
			
			// sch_target이 변경될때마다 STATUS값이 활성화
			var d = document.getElementsByName("sch_status");
			for (var i = 0; i < d.length; i++)	{
				d[0].checked = true;
				d[i].disabled = false;
			}
		}
	}
}
 
/**
 *  권한에 따라 Office코드를 제어한다.
 */
function isOfficeAuthCheck() {
	frm.f_cmd.value = SEARCHLIST08;
	var sXml = sheet1.GetSearchXml("CPS_GEM_0019GS.do", FormQueryString(frm));
	var arrXml = sXml.split("|$$|");
	
	// ---------------------------------
	// Open시 권한에 의한 BU정보 컨트롤 Start..
	// Open시 권한에 의한 BU정보 컨트롤 End..
	// ---------------------------------
	var authFlg  = "";
	if (arrXml.length > 0) {
		// =========================================================
		// 2009.10.26일 권한 변경 추가
		// =========================================================		
		var list = ComXml2ListMap(arrXml[0]);
		var officeLevelVo  = list[0];			
		authFlg  = officeLevelVo["auth_flg"];
		
		if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
			goNoAuthority();
			return;
	    }
		// 사무국
		if ( authFlg == "YNYN" || authFlg == "YNYY") {				
			//사무국인경우 수퍼유저가 아니경우 비용팀으로 권한 설정
			if (authFlg == "YNYY") {
				if ( frm.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
					authFlg = "YNYN";
				} else {
					var sp_commit = document.getElementById("sp_commit");
					sp_commit.style.display = "inline";
				}					
				
			}
		}				
		
		//권한 설정
		frm.auth_flg.value = authFlg;    					

		//=========================================================    
				
		
	}
	
	// 로그인 사용자 오피스 정보
	if (arrXml.length > 1) {
		var list = ComXml2ListMap(arrXml[1]);
		if (list.length > 0) {
			var officeHierarchyVO  = list[0];
			var level1   = officeHierarchyVO["level1"];
			var level2   = officeHierarchyVO["level2"];
			var level3   = officeHierarchyVO["level3"];
			var level4   = officeHierarchyVO["level4"];
			var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
								
			if ("N" == rgnOfcFlg) {
				frm.sch_hohq_gbn[0].checked = true;
				frm.sch_hohq_gbn[1].checked = false;
			} else {
				frm.sch_hohq_gbn[0].checked = false;
				frm.sch_hohq_gbn[1].checked = true;					
			}
		}
		
		/*	
		1.[성공] 조회된 정보와 조직의 권한에 따른 Request Office Setup
		  1.1.[집행단위:YNNN] 
		    1.1.1.[BU항목] 비활성화
		    1.1.2.[HO항목] 비활성화
		    1.1.3.[HQ항목] 비활성화
		    1.1.4.[BU조직항목] 비활성화
		    1.1.5.[Major조직L항목] 비활성화
		    1.1.6.[Minor조직항목] 비활성화
		  1.2.[지역그룹:YYNN]
		    1.2.1.[BU항목] 비활성화
		    1.2.2.[HO항목] 비활성화
		    1.2.3.[HQ항목] 비활성화
		    1.2.4.[BU조직항목] 비활성화
		    1.2.5.[Major조직항목] 비활성화
		    1.2.6.[Minor조직항목] 활성화
		  1.3.[BU CTRL:YYYN]
		    1.3.1.[BU항목] 비활성화
		    1.3.2.[HO항목] 활성화
		    1.3.3.[HQ항목] 활성화
		    1.3.4.[BU조직항목] 활성화
		    1.3.5.[Major조직항목] 활성화
		    1.3.6.[Minor조직항목] 활성화
		  1.4.[비용주관팀:YNYN][사무국:YNYY]
		    1.4.1.[BU항목] 비활성화
		    1.4.2.[HO항목] 활성화
		    1.4.3.[HQ항목] 활성화
		    1.4.4.[BU조직항목] 활성화
		    1.4.5.[Major조직항목] 활성화
		    1.4.6.[Minor조직항목] 활성화
		*/
		// 집행단위
		if ( authFlg == "YNNN" ) {
			ComEnableObject(frm.sch_lvl1, false);
			ComEnableObject(frm.sch_lvl2, false);
			ComEnableObject(frm.sch_lvl3, false);		
			frm.sch_hohq_gbn[0].disabled=true;
			frm.sch_hohq_gbn[1].disabled=true;			
			
			ComSetObjValue(frm.sch_lvl1,level2);
			
			// LV2
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');
			ComSetObjValue(frm.sch_lvl2,level3);
			
			// LV3
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');			
			ComSetObjValue(frm.sch_lvl3,level4);
	    // 지역그룹				
		} else if ( authFlg == "YYNN" ) {
			ComEnableObject(frm.sch_lvl1, false);
			ComEnableObject(frm.sch_lvl2, false);
			ComEnableObject(frm.sch_lvl3, true);				
			frm.sch_hohq_gbn[0].disabled=true;
			frm.sch_hohq_gbn[1].disabled=true;	
			
			ComSetObjValue(frm.sch_lvl1,level2);
			
			// LV2
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sch_hohq_gbn','1','document.form.sch_lvl');
			ComSetObjValue(frm.sch_lvl2,level3);
			
			// LV3
			selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sch_hohq_gbn','2','document.form.sch_lvl');			
			ComSetObjValue(frm.sch_lvl3,level4);
		// BU	
		} else if ( authFlg == "YYYN" ) {
			ComEnableObject(frm.sch_lvl1, true);
			ComEnableObject(frm.sch_lvl2, true);
			ComEnableObject(frm.sch_lvl3, true);
			
			frm.sch_hohq_gbn[0].checked = false;
			frm.sch_hohq_gbn[1].checked = false;
			
			frm.sch_lvl1.value = "";
			frm.sch_lvl2.value = "";
			frm.sch_lvl3.value = "";
			
		// 사무국
		} else if ( authFlg == "YNYN" || authFlg == "YNYY") {					
			ComEnableObject(frm.sch_lvl1, true);
			ComEnableObject(frm.sch_lvl2, true);
			ComEnableObject(frm.sch_lvl3, true);
			
			frm.sch_hohq_gbn[0].checked = false;
			frm.sch_hohq_gbn[1].checked = false;
			
			frm.sch_lvl1.value = "";
			frm.sch_lvl2.value = "";
			frm.sch_lvl3.value = "";
			
		} else {
			ComEnableObject(frm.sch_lvl1, false);
			ComEnableObject(frm.sch_lvl2, false);
			ComEnableObject(frm.sch_lvl3, false);		
			frm.sch_hohq_gbn[0].disabled=true;
			frm.sch_hohq_gbn[1].disabled=true;					
		}
		
		//권한 설정
		frm.auth_flg.value = authFlg;
	}
}
 
//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	sheetObj의 선택된 Row
 * @param {ibsheet} col     	sheetObj의 선택된 Col
 **/
function sheet2_OnClick(sheetObj, row, col, value) {
	//alert(sheetObj+"=="+row+"=="+col+"=="+value);
}

/**
 * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
 * @param comboObj
 * @param index_cd
 * @param text
 * @return
 */
function combo1_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	combo2.focus();
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo2_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	combo3.focus();
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
/*
function combo3_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_tic_cd');
}
*/

//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
* MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
* @return
*/
function combo3_OnCheckClick(comboObj, index, code) {
	if(index==0) {
	   	//checked
	   	var bChk = comboObj.CheckIndex(index);
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = bChk;
		}
    } else {
    		comboObj.CheckIndex(0) = false;
    }
}     
/* 개발자 작업 끝 */