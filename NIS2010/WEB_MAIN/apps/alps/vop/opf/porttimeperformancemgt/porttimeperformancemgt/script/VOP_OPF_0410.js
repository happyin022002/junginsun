/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : VOP_OPF_0410.js
 *@FileTitle : Port Time KPI Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2012.02.06
 * 1.0 Creation
 * 2012.02.06 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
 * 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
 * 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
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
 * @class VOP_OPF_0410 : VOP_OPF_0410 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_0410() {
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

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix1="sheet1_";
var tab_chk="";//KPI/BSEL

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
			
		case "btn_creation":
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			break;

		case "btn_new":
			initAll();
			break;
			
		case "btn_delete":
			doActionIBSheet(sheetObj, formObj, IBDELETE);
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;

		case "btn_downExcel":
			if(sheetObj.RowCount == 0) {
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert();
				sheetObjects[1].Down2Excel(-1, false, false, true, "", "", false, false, "", true, "", "", false, false, "");
			}else {
				sheetObj.Down2Excel(1, false, false, true, "", "", false, false, "", true, "sheet1_clpt_ind_seq_view|sheet1_ibflag|sheet1_kpi_tgt_yr|sheet1_kpi_ver_seq|sheet1_chk_val|sheet1_tab_chk", "", false, false, "");
			}
			break;
			
		case "btn_loadExcel":
			removeComboData();
			sheetObj.RemoveAll();
			sheetObj.Redraw = false;
			sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", true, false, "1=>"+prefix1+"rhq_cd|2=>"			+prefix1+"fm_eff_dt_yy|3=>"		+prefix1+"fm_eff_dt_md|" 	 +
																	   "4=>"+prefix1+"to_eff_dt_yy|5=>"		+prefix1+"to_eff_dt_md|6=>"		+prefix1+"vps_port_cd|"  	 +
																	   "7=>"+prefix1+"slan_cd|8=>"			+prefix1+"port_kpi_dir_cd|9=>"	+prefix1+"clpt_ind_seq|" 	 +
																	  "10=>"+prefix1+"ttl_cntr_mv_knt|11=>"	+prefix1+"stm_in_hrs|12=>"		+prefix1+"vsl_arr_hrs|"  	 +
																	  "13=>"+prefix1+"tml_op_hrs|14=>"		+prefix1+"vsl_dep_hrs|15=>"		+prefix1+"port_stay_hrs|"  	 +
																	  "16=>"+prefix1+"grs_tml_prod_hrs|17=>"+prefix1+"grs_crn_prod_hrs|18=>"+prefix1+"net_crn_prod_hrs|" +
																	  "19=>"+prefix1+"twn_lft_hrs|20=>"		+prefix1+"dul_cyc_hrs|21=>"		+prefix1+"rstwg_hrs" );
			sheetObj.Redraw = true;
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
function loadPage() {
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	radioChk(document.form);
	// KPI Year Setting
	initDefaultCombo(sheetObjects[0], document.form);
	
	// Button Setting
	setButtonStatus("INIT");
	
	ComSetFocus(comboObjects[2]);
	
	initControl();
}

/**
* 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
* {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {int}     sheetNo     sheetObjects 배열에서 순번
**/
function initControl() {
	var formObj = document.form;	
 //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('click'		   	, 'obj_click'	 	, form);
}

function obj_click() {
	var src = window.event.srcElement.getAttribute("name")
	var formObj = document.form;	

	if(src == "tab_chk") {
		if(document.form.tab_chk[1].checked){//base line
			tab_chk = "BSEL";
			document.all.kpi_yr.style.display = 'none';
			document.all.bsel_yr.style.display = 'block';
			document.form.kpi_ver_seq.Enable = false;
			sheetObjects[0].RemoveAll();
			initDefaultCombo(sheetObjects[0], document.form);// KPI/BSEL Year Setting
			
		}else if(document.form.tab_chk[0].checked){//KPI
			tab_chk = "KPI";
			document.all.kpi_yr.style.display = 'block';
			document.all.bsel_yr.style.display = 'none';
			document.form.kpi_ver_seq.Enable = true;
			sheetObjects[0].RemoveAll();
			initDefaultCombo(sheetObjects[0], document.form);// KPI/BSEL Year Setting
		}	
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 450;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;//msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "RHQ|Effective date|Effective date|Effective date|Effective date|Port|Lane|Direction|Double\nCall|Double\nCall|Total\nMoves|Steam\nIn|Arrival|Operation|Departure|Port\nTime|G.TMNL\nProductivity|GMPH|NMPH|Twin\nLift|Dual\nCycle|Restow|ibflag|kpi_tgt_yr|kpi_ver_seq|chk_val|tab_chk";
			
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, false, 	prefix1+"rhq_cd"			, false, "", dfNone, 	-1, false, 	false);
			InitDataProperty(0, cnt++, dtData    ,  30, daCenter, false, 	prefix1+"fm_eff_dt_yy"		, false, "", dfNone, 	-1, false, 	false);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, false, 	prefix1+"fm_eff_dt_md"		, false, "", dfDateMd, 	-1, true, 	true);
			InitDataProperty(0, cnt++, dtData    ,  30, daCenter, false, 	prefix1+"to_eff_dt_yy"		, false, "", dfNone,	-1, false, 	false);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, false, 	prefix1+"to_eff_dt_md"		, false, "", dfDateMd, 	-1, true, 	true);
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, false, 	prefix1+"vps_port_cd"		, false, "", dfNone, 	-1, false, 	false);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, false, 	prefix1+"slan_cd"			, false, "", dfNone, 	-1, false, 	false);
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, false, 	prefix1+"port_kpi_dir_cd"	, false, "", dfNone, 	-1, false, 	false);
			InitDataProperty(0, cnt++, dtCheckBox,  57, daCenter, false, 	prefix1+"clpt_ind_seq_view"	, false, "", dfNone,	-1, false, 	false, -1, false, false, false, false);
			InitDataProperty(0, cnt++, dtHidden	 ,  57, daCenter, false,	prefix1+"clpt_ind_seq"		, false, "", dfNullInteger,	-1, false,	false);
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"ttl_cntr_mv_knt"	, false, "", dfInteger, -1, true,	true, 5);
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"stm_in_hrs"  		, false, "", dfFloat, 	 1, true, true,  4, false, true, "ATA - Berth(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"vsl_arr_hrs"  		, false, "", dfFloat,	 1, true, true,  4, false, true, "Berth - Work Start(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  62, daRight,  false, 	prefix1+"tml_op_hrs" 		, false, "", dfFloat,	 1, true, true,  4, false, true, "KPI Avg Moves/GMPH(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix1+"vsl_dep_hrs" 		, false, "", dfFloat,	 1, true, true,  4, false, true, "Work Complete - Unberth(Hour)");
//			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix1+"stm_out_hrs"  		, false, "", dfFloat,	 1, true, true,  4, false, false, "");
			InitDataProperty(0, cnt++, dtData    ,  38, daRight,  false, 	prefix1+"port_stay_hrs"  	, false, "", dfFloat,	 1, true, true,  4, false, true, "Stean in+Arrival+Operation+Departure(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix1+"grs_tml_prod_hrs" 	, false, "", dfFloat,	 1, true, true,  4, false, true, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"grs_crn_prod_hrs" 	, false, "", dfFloat,	 1, true, true,  4, false, true, "Gross Crane Productivity(Move)");
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"net_crn_prod_hrs" 	, false, "", dfFloat,	 1, true, true,  4, false, true, "Net Crane Productivity(Move)");
			InitDataProperty(0, cnt++, dtData    ,  35, daRight,  false, 	prefix1+"twn_lft_hrs"      	, false, "", dfInteger, -1, true, true,  4, false, true, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"dul_cyc_hrs"     	, false, "", dfInteger, -1, true, true,  4, false, true, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"rstwg_hrs"         , false, "", dfInteger, -1, true, true,  4, false, true, "(Move)");
			
			InitDataProperty(0, cnt++, dtHiddenStatus	,  30, daCenter, true, 	prefix1+"ibflag");
			InitDataProperty(0, cnt++, dtHidden			,  30, daCenter, true, 	prefix1+"kpi_tgt_yr"	, false, "", dfNone, -1, false, false);
			InitDataProperty(0, cnt++, dtHidden			,  30, daCenter, true, 	prefix1+"kpi_ver_seq"	, false, "", dfNone, -1, false, false);
			InitDataProperty(0, cnt++, dtHidden			,  30, daCenter, true, 	prefix1+"chk_val"		, false, "", dfNone, -1, false, false);
			InitDataProperty(0, cnt++, dtHidden			,  30, daCenter, true, 	prefix1+"tab_chk"		, false, "", dfNone, -1, false, false);
			
			ToolTipOption="balloon:true;width:1000;forecolor:#000000;icon:1";
			WaitImageVisible=false;
		}
		break;
		
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 450;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;//msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "RHQ|Effective date|Effective date|Effective date|Effective date|Port|Lane|Direction|Double\nCall|Total\nMoves|Steam\nIn|Arrival|Operation|Departure|Port\nTime|G.TMNL\nProductivity|GMPH|NMPH|Twin\nLift|Dual\nCycle|Restow";
			
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    ,  50, daCenter, true, 	prefix1+"rhq"				, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  30, daCenter, true, 	prefix1+"fm_eff_dt_yy"		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, true, 	prefix1+"fm_eff_dt_md"		, false, "", dfDateMd);
			InitDataProperty(0, cnt++, dtData    ,  30, daCenter, true, 	prefix1+"to_eff_dt_yy"		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, true, 	prefix1+"to_eff_dt_md"		, false, "", dfDateMd);
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, true, 	prefix1+"vps_port_cd"		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, true, 	prefix1+"slan_cd"			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, true, 	prefix1+"port_kpi_dir_cd"	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  57, daCenter, true, 	prefix1+"clpt_ind_seq"		, false, "", dfNullInteger);
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"ttl_cntr_mv_knt"	, false, "", dfInteger);
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"stm_in_hrs"  		, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix1+"vsl_arr_hrs"   	, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  62, daRight,  false, 	prefix1+"tml_op_hrs" 		, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix1+"vsl_dep_hrs" 		, false, "", dfFloat, 1);
//			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix1+"stm_out_hrs"  		, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  38, daRight,  false, 	prefix1+"port_stay_hrs"  	, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix1+"grs_tml_prod_hrs" 	, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"grs_crn_prod_hrs" 	, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"net_crn_prod_hrs" 	, false, "", dfFloat, 1);
			InitDataProperty(0, cnt++, dtData    ,  35, daRight,  false, 	prefix1+"twn_lft_hrs"      	, false, "", dfInteger);
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"dul_cyc_hrs"     	, false, "", dfInteger);
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix1+"rstwg_hrs"        	, false, "", dfInteger);
			
		}
		break;
		
	}
}

/**
 * Combo 설정
 * @param comboObj
 * @return
 */
function initCombo(comboObj) {
	with(comboObj) {
		switch(id) {
			case "kpi_tgt_yr":
	        	DropHeight = 100;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	MaxLength = 4;
//	        	UseAutoComplete = true;
	        	ValidChar(0, 1);// 숫자만 입력가능
	        	UseEdit = true;
	            break;
			case "kpi_ver_seq":
				DropHeight = 100;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	MaxLength = 2;
	        	UseAutoComplete = true;
	        	ValidChar(0, 1);// 숫자만 입력가능
	            break;
			case "slan_cd":
				DropHeight = 100;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	MaxLength = 3;
	        	UseAutoComplete = true;
	        	ValidChar(2, 1);// 영문대문자+숫자 입력가능
	            break;
			case "rhq_cd":
				DropHeight = 100;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	MaxLength = 5;
	        	UseAutoComplete = true;
	        	ValidChar(2, 0);// 영문대문자만 입력가능
	            break;
			case "vps_port_cd":
				DropHeight = 100;
	        	MultiSelect = false;
	        	MaxSelect = 1;
	        	MaxLength = 5;
	        	UseAutoComplete = true;
	        	ValidChar(2, 0);// 영문대문자만 입력가능
	            break;
		}
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix1));
			sheetObj.LoadSearchXml(sXml,false);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
			
		case IBCREATE: //생성
			if (!ComShowCodeConfirm("OPF50001")) {
                return false;
            }
			formObj.f_cmd.value = MULTI;
			var kpiTgtYr = comboObjects[0].Code;
			if(isNull(kpiTgtYr)) kpiTgtYr = comboObjects[0].Text;
			
			radioChk(formObj);
			if(tab_chk == "BSEL"){// Baseline 인 경우 데이터를 지우고 새로 생성
				formObj.f_cmd.value = REMOVE;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("VOP_OPF_0410GS.do", sParam);
				formObj.f_cmd.value = MULTI;
			}
				
			for(var i= 1 ; i<=sheetObj.LastRow ; i++){
				sheetObj.CellValue2(i, "sheet1_kpi_tgt_yr") = kpiTgtYr;
				sheetObj.CellValue2(i, "sheet1_tab_chk") = tab_chk;
			}
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sParam = FormQueryString(formObj) + "&" + ComGetSaveString(sheetObj)+ "&" + ComGetPrefixParam(prefix1);
			var sXml = sheetObj.GetSaveXml("VOP_OPF_0410GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
			
		case IBDELETE:
			if (!ComShowCodeConfirm("OPF50002")) {
                return false;
            }
			removeComboData();
			formObj.f_cmd.value = REMOVE;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("VOP_OPF_0410GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
			
		case IBSAVE:
			if(!sheetObj.IsDataModified) {
				ComShowCodeMessage("OPF50029");
				return false;
			}
			if (!ComShowCodeConfirm("OPF50001")) {
                return false;
            }
			formObj.f_cmd.value = MODIFY;
			for(var i= 1 ; i<=sheetObj.LastRow ; i++){
				if(sheetObj.CellValue(i,prefix1+"ibflag")=="U"){
					sheetObj.CellValue(i, "sheet1_tab_chk") = tab_chk;
				}
			}
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sParam = FormQueryString(formObj);
			sheetObj.DoSave("VOP_OPF_0410GS.do", sParam, -1, false);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if(isNull(comboObjects[0].Code)){
				ComShowCodeMessage("OPF50009", "Duration");
				return false;
			}else if(isNull(comboObjects[1].Code)){
				ComShowCodeMessage("OPF50009", "Duration");
				return false;
			}
			break;
			
		case IBCREATE: 	//생성
		case IBSAVE: 	//수정
			var firstRow = sheetObj.HeaderRows;
//			//Month, Day Null 체크
//			for(var i=firstRow ; i<=sheetObj.LastRow ; i++) {
//				if(sheetObj.CellValue(i, prefix1+"fm_eff_dt_md") == "") {
//					ComShowCodeMessage("OPF50009", "Effective date");
//					sheetObj.SelectCell(i, prefix1+"fm_eff_dt_md", true);
//					return;
//				}
//				if(sheetObj.CellValue(i, prefix1+"to_eff_dt_md") == "") {
//					ComShowCodeMessage("OPF50009", "Effective date");
//					sheetObj.SelectCell(i, prefix1+"to_eff_dt_md", true);
//					return;
//				}
//			}
//			
//			//Month Day Format 체크
//			for(var i=firstRow ; i<=sheetObj.LastRow ; i++) {
//				if(!checkMonDayFormat(sheetObj.CellValue(i, prefix1+"fm_eff_dt_md"), sheetObj.CellValue(i, prefix1+"fm_eff_dt_yy"))) {
//					ComShowCodeMessage('COM12187', 'mm-dd');
//					sheetObj.SelectCell(i, prefix1+"fm_eff_dt_md");
//					return;
//				}
//				if(!checkMonDayFormat(sheetObj.CellValue(i, prefix1+"to_eff_dt_md"), sheetObj.CellValue(i, prefix1+"to_eff_dt_yy"))) {
//					ComShowCodeMessage('COM12187', 'mm-dd');
//					sheetObj.SelectCell(i, prefix1+"to_eff_dt_md");
//					return;
//				}
//			}
//			
//			//Effective Date From To 체크
//			for(var i=firstRow ; i<=sheetObj.LastRow ; i++) {
//				if(!checkEffectiveDate(sheetObj, i, sheetObj.SaveNameCol(prefix1+"fm_eff_dt_md"), true)) {
//					return;
//				}
//			}
			
			for(var i=firstRow ; i<=sheetObj.LastRow ; i++) {
				//From Month, Day Null 체크
				if(sheetObj.CellValue(i, prefix1+"fm_eff_dt_md") == "") {
					ComShowCodeMessage("OPF50009", "Effective date");
					sheetObj.SelectCell(i, prefix1+"fm_eff_dt_md", true);
					return;
				}
				//From Month Day Format 체크
				if(!checkMonDayFormat(sheetObj.CellValue(i, prefix1+"fm_eff_dt_md"), sheetObj.CellValue(i, prefix1+"fm_eff_dt_yy"))) {
					ComShowCodeMessage('COM12187', 'mm-dd');
					sheetObj.SelectCell(i, prefix1+"fm_eff_dt_md");
					return;
				}
				
				//To Month, Day Null 체크
				if(sheetObj.CellValue(i, prefix1+"to_eff_dt_md") == "") {
					ComShowCodeMessage("OPF50009", "Effective date");
					sheetObj.SelectCell(i, prefix1+"to_eff_dt_md", true);
					return;
				}
				//To Month Day Format 체크
				if(!checkMonDayFormat(sheetObj.CellValue(i, prefix1+"to_eff_dt_md"), sheetObj.CellValue(i, prefix1+"to_eff_dt_yy"))) {
					ComShowCodeMessage('COM12187', 'mm-dd');
					sheetObj.SelectCell(i, prefix1+"to_eff_dt_md");
					return;
				}
				
				//Effective Date From To 체크
				if(!checkEffectiveDate(sheetObj, i, sheetObj.SaveNameCol(prefix1+"fm_eff_dt_md"), true)) {
					return;
				}
			}
			break;
			
		case IBDELETE: //삭제
			if(isNull(comboObjects[0].Code)){
				ComShowCodeMessage("OPF50009", "Duration");
				return false;
			}else if(isNull(comboObjects[1].Code)){
				ComShowCodeMessage("OPF50009", "Duration");
				return false;
			}
			break;
	}
	return true;
}

/**
 * OnSearchEnd 이벤트
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		if(RowCount > 0) setButtonStatus("ALL");
		else setButtonStatus("")
	}
}

/**
 * OnChange 이벤트
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if(sheetObj.ColSaveName(Col) == prefix1+"fm_eff_dt_md" || sheetObj.ColSaveName(Col) == prefix1+"to_eff_dt_md") {
		var tmpDate = sheetObj.CellValue(Row, Col);
		if(tmpDate != "") {
			if(!checkEffectiveDate(sheetObj, Row, Col, true)) {
				return;
			}
		}
	}
}

/**
 * OnLoadExcel 이벤트
 * @param sheetObj
 */
function sheet1_OnLoadExcel(sheetObj) {
	if(sheetObj.LastRow == 0) return;
	if(checkLoadDate(sheetObj)) {
		setButtonStatus("CRE");
	}
}

/**
 * OnSaveEnd 이벤트
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	if(formObj.f_cmd.value == MULTI) {
		//KPI Year setting
		formObj.f_cmd.value = SEARCH06;
		var kpiTgtYrXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
		var kpiTgtYrCode = ComGetEtcData(kpiTgtYrXml, "KPI_TGT_YR");
		setComboItem(comboObjects[0], kpiTgtYrCode, comboObjects[0]);
		comboObjects[0].index2 = 0;
		
		//KPI Version setting
		if(document.form.tab_chk[0].checked){ // KPI 
			formObj.f_cmd.value = SEARCH01;
			var kpiVerSeqXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
			var kpiVerSeqCode = ComGetEtcData(kpiVerSeqXml, "KPI_VER_SEQ");
			setComboItem(comboObjects[1], kpiVerSeqCode, comboObjects[0]);
			comboObjects[1].index2 = 0;
		}else if(document.form.tab_chk[1].checked){ // base line 은 ver_seq 를 1로 고정
			setComboItem(comboObjects[1], "", "1");
			comboObjects[1].InsertItem(0,"",1);
			comboObjects[1].index2 = 0;
		}
		//Lane 콤보 세팅
		removeComboData();
		setComboData(comboObjects[2], SEARCH02, "LANE_CD", comboObjects[1]);
		//저장 실패한 Row Color 변경
		for(var i=sheetObj.HeaderRows ; i<=sheetObj.LastRow ; i++) {
			if(sheetObj.CellValue(i, "sheet1_chk_val") == "fail") {
				sheetObj.RowBackColor(i) =  sheetObj.RgbColor(247, 225, 236);
				sheetObj.RowEditable(i) = false;
			}
		}
		setButtonStatus("ALL");
	}else if(formObj.f_cmd.value == REMOVE) {
		//KPI Version setting
		if(document.form.tab_chk[0].checked){ // KPI 
			formObj.f_cmd.value = SEARCH01;
			var kpiVerSeqXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
			var kpiVerSeqCode = ComGetEtcData(kpiVerSeqXml, "KPI_VER_SEQ");
			setComboItem(comboObjects[1], kpiVerSeqCode, comboObjects[0]);
			comboObjects[1].index2 = 0;
		}else if(document.form.tab_chk[1].checked){ // base line 은 ver_seq 를 1로 고정
			setComboItem(comboObjects[1], "", "");
			comboObjects[1].InsertItem(0,"",1);
			comboObjects[1].index2 = 0;
		}
		if(comboObjects[1].GetCount() > 0) {
			setComboData(comboObjects[2], SEARCH02, "LANE_CD", comboObjects[1]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else {
			sheetObj.RemoveAll();
			initDefaultCombo(sheetObj, formObj);
			setButtonStatus("");
		}
	}else if(formObj.f_cmd.value == MODIFY) {
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
}

/**
 * KPI Year 셋팅
 * @param sheetObj
 * @param formObj
 */	
function initDefaultCombo(sheetObj, formObj){
	formObj.f_cmd.value = SEARCH06;
	radioChk(formObj);
	var kpiTgtYrXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
	var kpiTgtYrCode = ComGetEtcData(kpiTgtYrXml, "KPI_TGT_YR");
	setComboItem(comboObjects[0], kpiTgtYrCode, comboObjects[0]);
	comboObjects[0].index = 0;
}

/**
 * KPI Year OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function kpi_tgt_yr_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	if(document.form.tab_chk[0].checked){ // KPI 
		if(isNull(Code)){
			removeComboData();
			comboObjects[1].RemoveAll();
			var sXml = sheetObjects[0].GetSearchXml("VOP_OPF_0410GS.do", "f_cmd="+SEARCH01+"&kpi_tgt_yr="+Text);
			var sCode = ComGetEtcData(sXml, "KPI_VER_SEQ");
			setComboItem(comboObjects[1], sCode, comboObjects[0]);
		}else {
			setComboData(comboObjects[1], SEARCH01, "KPI_VER_SEQ", comboObjects[0]);
			comboObjects[1].index = 0;
		}
	}else if(document.form.tab_chk[1].checked){ // base line 은 ver_seq 를 1로 고정
			setComboItem(comboObjects[1], "", "");
			comboObjects[1].InsertItem(0,"",1);
			comboObjects[1].index = 0;
			kpi_ver_seq_OnChange(comboObj, Code, Text);
	}
	ComSetFocus(comboObjects[2]);
}

function kpi_tgt_yr_OnKeyDown(comboObj, KeyCode, Shift) {
	ComOpfSetComboPastePattern(comboObj, KeyCode, Shift, "0");//숫자만 가능
}

/**
 * KPI Version OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function kpi_ver_seq_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	removeComboData();
	setComboData(comboObjects[2], SEARCH02, "LANE_CD", comboObjects[1]);
}

/**
 * Lane OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function slan_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	comboObjects[4].RemoveAll();
	setComboData(comboObjects[3], SEARCH03, "RHQ_CD", comboObjects[2]);
}

/**
 * RHQ OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function rhq_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	setComboData(comboObjects[4], SEARCH04, "PORT_CD", comboObjects[3]);
}

/**
 * Port OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function vps_port_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	
	var formObj = document.form;
	var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0410GS.do", "f_cmd="+SEARCH05+"&port_cd="+Code);
	
	var rhqCd = ComGetEtcData(sRhqXml, "RHQ_OFC_CD");
	formObj.rhq_cd.Code2 = rhqCd == "" ? " " : rhqCd;
	ComSetFocus(comboObj);
}

/**
 * Data를 조회하여 Combo에 셋팅한다.
 * @param comboObj
 * @param cmd
 * @param item
 */
function setComboData(comboObj, cmd, item, oriComboObj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
	formObj.f_cmd.value = cmd;
	var sXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
	var sCode = ComGetEtcData(sXml, item);
	if(cmd == SEARCH01) setComboItem(comboObj, sCode, oriComboObj);
	else setComboItem2(comboObj, sCode, oriComboObj);
}

/**
 * 초기 Combo 및 버튼을 셋팅한다.
 */
function initAll(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].RemoveAll();
	comboObjects[4].RemoveAll();
	sheetObj.RemoveAll();
	
	// KPI Year Setting
	initDefaultCombo(sheetObjects[0], document.form);
	
	// Button Setting
	setButtonStatus("");
	
	ComSetFocus(comboObjects[2]);
}

/**
 * 선택조건인 Combo Data 를 제거한다.
 */
function removeComboData() {
	comboObjects[2].RemoveAll();
	comboObjects[3].RemoveAll();
	comboObjects[4].RemoveAll();
}

/**
 * 화면 폼입력값에 Null Check
 * @param itemValue
 */
function isNull(itemValue){
    if(itemValue==null || itemValue=="" || itemValue=="undefined"){
    	return true;
    }
    else{
    	return false;
    }
}

/**
 * 콤보필드에 데이터를 셋팅한다.
 * @param comboObj
 * @param comboItems
 */
function setComboItem(comboObj,comboItems,oriComboObj) {
	comboObj.RemoveAll();
	if(!isNull(comboItems)) {
		var dataList = comboItems.split("|");
		
		for (var i = 0 ; i < dataList.length ; i++) {
			
			var comboItem = dataList[i].split(",");			
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);
		}
	}
	ComSetFocus(oriComboObj);
}

/**
 * 콤보필드에 데이터를 셋팅한다.
 * 첫 row에 공백을 추가한다.
 * @param comboObj
 * @param comboItems
 */
function setComboItem2(comboObj,comboItems,oriComboObj) {
	comboObj.RemoveAll();
	if(!isNull(comboItems)) {
		var dataList = comboItems.split("|");
		comboObj.InsertItem(0, '', '');
		var j = 0;
		for (var i = 0 ; i < dataList.length ; i++) {
			j += 1;
			var comboItem = dataList[i].split(",");			
			comboObj.InsertItem(j, comboItem[1], comboItem[0]);
		}
	}
	ComSetFocus(oriComboObj);
}

/**
 * User Office Code 에 따라 버튼을 제어한다.
 * @param sts
 */
function setButtonStatus(sts) {
	ComBtnEnable("btn_retrieve");
	ComBtnEnable("btn_new");
	ComBtnEnable("btn_downExcel");
	
	ComBtnDisable("btn_creation");
	ComBtnDisable("btn_delete");
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_loadExcel");
	
	if(userOfcCd == "SELOPA") {
		ComBtnEnable("btn_loadExcel");
		if (sts == "ALL") {
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_save");
		}else if (sts == "CRE") {
			ComBtnEnable("btn_creation");
		}
	}
}

/**
 * Load Excel Data 의 정합성을 체크한다. 
 * @param sheetObj
 */
function checkLoadDate(sheetObj) {
	var cnt = 0;
	var kpiTgtYr = comboObjects[0].Code
	if(isNull(kpiTgtYr)) kpiTgtYr = comboObjects[0].Text;
	with(sheetObj) {
		for(var i =HeaderRows ; i<=LastRow ; i++){
			//Year From 필드 KPI Year 비교 체크 (Null 체크) 
			if(CellValue(i, prefix1+"fm_eff_dt_yy") != kpiTgtYr) {
				CellBackColor(i, prefix1+"fm_eff_dt_yy") = RgbColor(247, 225, 236);
				cnt++;
			}
			//Year To 필드 KPI Year 비교 체크 (Null 체크) 
			if(CellValue(i, prefix1+"to_eff_dt_yy") != kpiTgtYr) {
				CellBackColor(i, prefix1+"to_eff_dt_yy") = RgbColor(247, 225, 236);
				cnt++;
			}
			
			//Year From 필드 Format 체크
			if(!ComIsDate(CellValue(i, prefix1+"fm_eff_dt_yy"), "yyyy")) {
				CellBackColor(i, prefix1+"fm_eff_dt_yy") = RgbColor(247, 225, 236);
				cnt++;
			}
			//Year To 필드 Format 체크
			if(!ComIsDate(CellValue(i, prefix1+"to_eff_dt_yy"), "yyyy")) {
				CellBackColor(i, prefix1+"to_eff_dt_yy") = RgbColor(247, 225, 236);
				cnt++;
			}
						
			//Month Day Format 체크
			if(!checkMonDayFormat(CellValue(i, prefix1+"fm_eff_dt_md"), kpiTgtYr)) {
				CellBackColor(i, prefix1+"fm_eff_dt_md") = RgbColor(247, 225, 236);
			}
			if(!checkMonDayFormat(CellValue(i, prefix1+"to_eff_dt_md"), kpiTgtYr)) {
				CellBackColor(i, prefix1+"to_eff_dt_md") = RgbColor(247, 225, 236);
			}
			
			//Month Day From To 체크
			if(!checkEffectiveDate(sheetObj, i, SaveNameCol(prefix1+"fm_eff_dt_md"), false)) {
				CellBackColor(i, prefix1+"fm_eff_dt_md") = RgbColor(247, 225, 236);
				CellBackColor(i, prefix1+"to_eff_dt_md") = RgbColor(247, 225, 236);
			}
			
			//Direction 체크
			if(!checkDirection(CellValue(i, prefix1+"port_kpi_dir_cd"))) {
				CellBackColor(i, prefix1+"port_kpi_dir_cd") = RgbColor(247, 225, 236);
				cnt++;
			}
			
			//Double Call 체크
			if(!checkDoubleCall(sheetObj, i, CellValue(i, prefix1+"clpt_ind_seq"))) {
				CellBackColor(i, prefix1+"clpt_ind_seq_view") = RgbColor(247, 225, 236);
				cnt++;
			}
			
		}
	}
	return cnt>0?false:true;
}

/**
 * Month, Day 정합성을 체크한다.
 * @param monDay
 * @param kpiTgtYr
 */
function checkMonDayFormat(monDay, kpiTgtYr) {
	var mon = monDay.substring(0,2);
	var day = monDay.substring(2);
	
	if(monDay.length == 0 || monDay.length > 4 || !ComIsMonth(mon) || !ComIsDay(kpiTgtYr, mon, day)) {
		return false;
	}
	return true;
}


/**
 * Effective Date 를 체크한다.
 * @param sheetObj
 * @param selRow
 * @param selCol
 * @param flag : false - Load Excel 시 값만 리턴, true - alert 메세지를 띄우고 값 리턴 
 * @return
 */
function checkEffectiveDate(sheetObj, selRow, selCol, flag) {
	with(sheetObj) {
		var selColNm = ColSaveName(selCol);
		var kpiTgtYr = comboObjects[0].Code
		if(isNull(kpiTgtYr)) kpiTgtYr = comboObjects[0].Text;
		
		var fmMd = CellValue(selRow, prefix1+"fm_eff_dt_md");
		var toMd = CellValue(selRow, prefix1+"to_eff_dt_md");
		
		if(fmMd!="" && toMd!=""){
			if(setString2Date(kpiTgtYr+fmMd) > setString2Date(kpiTgtYr+toMd)) {
				if(flag) {
					if(selColNm == prefix1+"fm_eff_dt_md") {
						ComShowCodeMessage("OPF50033", "From Date", "To Date");
					}else if(selColNm == prefix1+"to_eff_dt_md") {
						ComShowCodeMessage("OPF50013", "To Date", "From Date");
					}
					SelectCell(selRow, selCol, true);
				}
				return false;
			}
		}
	}
	return true;
}

function checkDirection(val) {
	var dirCd = val.toUpperCase();
	if(dirCd == "" || dirCd == "E" || dirCd == "W" || dirCd == "N" || dirCd == "S") {
		return true;
	}else {
		return false;
	}
}

function checkDoubleCall(sheetObj, idx, val) {
	var rtnVal = false;
	if(val == "" || val == 1 || val == 2) {
		rtnVal = true;
	}else {
		rtnVal = false;
	}
	if(val ==2) sheetObj.CellValue2(idx, prefix1+"clpt_ind_seq_view") = 1;
	else sheetObj.CellValue2(idx, prefix1+"clpt_ind_seq_view") = 0;
	
	return rtnVal;
}

/**
 * Date 
 * @param sDate
 */
function setString2Date(sDate){
    sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");  //날짜구분자,시간구분자,스페이스 없애기
    
    var arr = ComNumberArray(7);
    var iLen = sDate.length;
    
    if (iLen>=4) arr[0]  = sDate.substr(0,4);		//year
	if (iLen>=6) arr[1]  = sDate.substr(4,2)-1;		//month
	if (iLen>=8) arr[2]  = sDate.substr(6,2);		//day
	
    if (iLen>=10) arr[3] = sDate.substr(8,2);		//hours
    if (iLen>=12) arr[4] = sDate.substr(10,2);		//minutes
    if (iLen>=14) arr[5] = sDate.substr(12,2);		//seconds
    if (iLen<=17) arr[6] = sDate.substr(14);		//hour
    
    return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
}

/**
 * radio 버튼 선택에 따라 tab_chk 값을 설정한다. 
 * @param formObj
 * @return String tab_chk;
 */
function radioChk(formObj){
	if(formObj.tab_chk[1].checked){//base line
		tab_chk = "BSEL";
	}else if(formObj.tab_chk[0].checked){//KPI
		tab_chk = "KPI";
	}
}

/* 개발자 작업  끝 */