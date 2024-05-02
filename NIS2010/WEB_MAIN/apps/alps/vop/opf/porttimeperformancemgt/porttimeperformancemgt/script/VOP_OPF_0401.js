/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : VOP_OPF_0401.js
 *@FileTitle : Port Time Performance Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.08
 *@LastModifier : 
 *@LastVersion : 1.15
 * 2012.06.08
 * 1.0 Creation
 * 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
 * 2012.01.31 김민아 [CHM-201215910-01] 2012 Port Time Reduction Project 시스템 개발 (1차) 추가사항(Port time외1건)
 * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
 * 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
 * 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
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
 * @class VOP_OPF_0401 : VOP_OPF_0401 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_0401() {
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

var prefix="sheet1_";

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
	
			case "btn_new":
				UF_reset();
				break;

			case "btn_save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
				
			case "btn_downexcel":
				var vGubun = comboObjects[3].Code;
				var skipCols = "";
				if(vGubun == "KPI" || vGubun == "BASE") { // KPI, Base Line
					skipCols = "sheet1_clpt_ind_seq_view|sheet1_yd_cd|sheet1_act_dep_dt|sheet1_vvd_cd_group|sheet1_vvd_cd";
				}else {
					skipCols = "sheet1_clpt_ind_seq_view|sheet1_yd_cd|sheet1_act_dep_dt|sheet1_vvd_cd_group";
				}
				sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", true, skipCols, "", false, false, "");
				break;
	
			case "btns_port":
		    	var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+formObj.port_cd.value;
				var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
	
				if(rVal){
					sheetObjects[0].RemoveAll();
					formObj.port_cd.value = rVal;
					port_cd_keyup();//RHQ_OFC_CD setting하기				
				} 
				break;
	
			case "btns_slan":
				ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+formObj.slan_cd.value, 420, 480, "slan_cd_pop_event", "0,0", true);
				break;
				
	        case "btns_period": // From 달력버튼
	        	var cal = new ComCalendarFromTo();
	        	cal.endFunction = "cal_end_func";
	        	cal.select(formObj.fr_dt, formObj.to_dt, 'yyyy-MM-dd');
	            break;
	
	        case "btn_dashboard": // Dashboard 버튼
	        	var s_fr_dt = "";
	        	var s_to_dt = "";
	        	var s_kpi_tgt_yr = "";
	        	var s_kpi_ver_seq = "";
	        	var s_rhq_ofc_cd = "";
	        	var s_port_cd = "";
	        	var s_slan_cd = "";

	        	var v_rhq = "";
	        	var v_vps_port_cd = "";
	        	var v_slan_cd = "";
	        	var v_port_kpi_dir_cd = "";
	        	var v_clpt_ind_seq = "";

	        	s_fr_dt = formObj.fr_dt.value;
	        	s_to_dt = formObj.to_dt.value;
	        	s_kpi_tgt_yr = formObj.kpi_tgt_yr.text;
	        	s_kpi_ver_seq = formObj.kpi_ver_seq.text;
	        	s_rhq_ofc_cd = formObj.rhq_ofc_cd.text;
	        	s_port_cd = formObj.port_cd.value;
	        	s_slan_cd = formObj.slan_cd.value;

	        	v_rhq = sheetObj.CellValue(sheetObj.SelectRow, prefix+"rhq");
	        	v_vps_port_cd = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vps_port_cd");
	        	v_slan_cd = sheetObj.CellValue(sheetObj.SelectRow, prefix+"slan_cd");
	        	v_port_kpi_dir_cd = sheetObj.CellValue(sheetObj.SelectRow, prefix+"port_kpi_dir_cd");
	        	v_clpt_ind_seq = sheetObj.CellValue(sheetObj.SelectRow, prefix+"clpt_ind_seq");

	        	if(v_vps_port_cd.length > 5)
	        		v_vps_port_cd = v_vps_port_cd.substr(0, 5);

	        	var param = "?s_fr_dt="+s_fr_dt+"&s_to_dt="+s_to_dt+"&s_kpi_tgt_yr="+s_kpi_tgt_yr;
	        	param = param+"&s_kpi_ver_seq="+s_kpi_ver_seq+"&s_rhq_ofc_cd="+s_rhq_ofc_cd+"&s_port_cd="+s_port_cd;
	        	param = param+"&s_slan_cd="+s_slan_cd+"&v_rhq="+v_rhq;
	        	param = param+"&v_vps_port_cd="+v_vps_port_cd+"&v_slan_cd="+v_slan_cd;
	        	param = param+"&v_port_kpi_dir_cd="+v_port_kpi_dir_cd+"&v_clpt_ind_seq="+v_clpt_ind_seq;
	        	
				var sUrl = "/hanjin/VOP_OPF_9401.do"+param;
				var rVal = ComOpenPopupWithTarget(sUrl, 1024, 800, "", "0,0", true, "yes");

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
 * Calendar From To 선택 후 호출하는 함수
 */
function cal_end_func(){
	sheetObjects[0].RemoveAll();
}

/**
 * Lane Code 선택 후 호출하는 함수
 */
function slan_cd_pop_event(aryPopupData) {
	sheetObjects[0].RemoveAll();
	document.form.slan_cd.value = aryPopupData[0][1];
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	
	document.form.fr_dt.value = frDt;
	document.form.to_dt.value = toDt;
	
	
	// KPI Year Setting
	initDefaultCombo(sheetObjects[0], document.form);
	
	if(document.form.ofc_cd.value=='SELCOL')	
		ComBtnEnable("btn_save");
	else 
		ComBtnDisable("btn_save");
		
		
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
	axon_event.addListenerFormat('beforedeactivate'	, 'obj_deactivate'	, formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  	, 'obj_activate'  	, formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  	, formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           	, 'obj_keyup'     	, formObj);
	axon_event.addListenerForm  ('click'		   	, 'obj_click'	 	, form);
	axon_event.addListenerForm  ('blur'				, 'obj_blur'		, form);
	
}

/**
 * OnBlur
 */
function obj_deactivate(){
	ComChkObjValid(event.srcElement);
}

/**
* OnFocus
*/
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

/**
 * OnKeyPress
 */
function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")

	if (src == "port_cd"){
		ComKeyOnlyAlphabet('upper');
	}else if (src == "slan_cd"){
		ComKeyOnlyAlphabet('uppernum');
	}else if (src == "fr_dt" || src == "to_dt"){
		ComKeyOnlyNumber(this, '');
	} 
	
}

/**
* Form KeyUp
*/
function obj_keyup(){
	ComKeyEnter('lengthnextfocus');

	obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
	case "port_cd":
		if (formObj.port_cd.value.length == 0) {
			sheetObjects[0].RemoveAll();
		}else if (formObj.port_cd.value.length == 5) {
			port_cd_keyup();
		}
		break;
	case "slan_cd":
		if (formObj.slan_cd.value.length == 0) {
			sheetObjects[0].RemoveAll();
		}else if (formObj.slan_cd.value.length == 3) {
			slan_cd_keyup();
		}
		break;
	}
}

function obj_click() {
	var src = window.event.srcElement.getAttribute("name")
	
//	if(src == "gubun") {
//		sheetObjects[0].RemoveAll();
//	}
}

function obj_blur() {
	var obj = window.event.srcElement;
	var src = obj.getAttribute("name")
	
	if(src == "to_dt") {
		setKpiTgtYr(obj.value);
	}
}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
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
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle  = "|RHQ|Port|KPI&\nPerformance|Lane|Dir|Dbl\nCall|Dbl\nCall|VVD|Exp|POB Exp\n(TOR)|KPI\nACHV|Total  \nMoves(+)|Total  \nMoves(-)|F40L|F20L|F40D|F20D|M40L|M20L|M40D|M20D|Steam\nIn|Arrival|Operation|Departure|Port\nTime";
			HeadTitle     += "|G.TMNL\nProductivity|GMPH|NMPH|Twin\nLift|Dual\nCycle|Restow|No of\nG.Crane|Pre-plan\nSending|Work\ncommenced|Work\ncompleted|Yard|act_dep_dt|vvd_group|vsl_cd|voy_no|dir_cd|port_cd";
			
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 10, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, true,	prefix+"ibflag");
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, true, 	prefix+"rhq"				, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  65, daCenter, true, 	prefix+"vps_port_cd"    	, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData  	 ,  80, daCenter, true, 	prefix+"gubun"       		, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter, true, 	prefix+"slan_cd"        	, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  25, daCenter, true, 	prefix+"port_kpi_dir_cd"   	, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtCheckBox,  30, daCenter, false, 	prefix+"clpt_ind_seq_view"	, false, "", dfNone, -1, false, 	false, -1, false, false, false, false);
			InitDataProperty(0, cnt++, dtHidden  ,  30, daCenter, true, 	prefix+"clpt_ind_seq"      	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData  	 ,  70, daCenter, false,	prefix+"vvd_cd"         	, false, "", dfNone, -1, false,	false, -1, false, false);
			InitDataProperty(0, cnt++, dtCheckBox,  40, daCenter, false, 	prefix+"except_cd"        	, false, "", dfNone, -1, true,	false, -1, false, false, "Except the VVD");
			InitDataProperty(0, cnt++, dtCheckBox,  60, daCenter, false, 	prefix+"except_pob_flg"    	, false, "", dfNone, -1, true,	false, -1, false, false, "Except the POB(Select the POB from the TOR data)");
			InitDataProperty(0, cnt++, dtData    ,  40, daCenter,  false, 	prefix+"kpi_achive"        	, false, "", dfNone, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  62, daRight,  false, 	prefix+"ttl_mvs"        	, false, "", dfNullInteger, -1, false,	false, -1, false, false, "Included 20,40 vol.(Double Click)");
			InitDataProperty(0, cnt++, dtHidden  ,  60, daRight,  false, 	prefix+"ttl_mvs2"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"full_l_40"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"full_l_20"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"full_d_40"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"full_d_20"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"et_l_40"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"et_l_20"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"et_d_40"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtHidden  ,  48, daRight,  false, 	prefix+"et_d_20"        	, false, "", dfNullInteger, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  46, daRight,  false, 	prefix+"steam_in_time"  	, false, "", dfNullFloat, 1, false, false, -1, false, false, "ATA - Berth(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  48, daRight,  false, 	prefix+"arrival_time"   	, false, "", dfNullFloat, 1, false, false, -1, false, false, "Berth - Work Start(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix+"operation_time" 	, false, "", dfNullFloat, 1, false, false, -1, false, false, "KPI Avg Moves/GMPH(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix+"departure_time" 	, false, "", dfNullFloat, 1, false, false, -1, false, false, "Work Complete - Unberth(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  45, daRight,  false, 	prefix+"port_time"      	, false, "", dfNullFloat, 1, false, false, -1, false, false, "Stean in+Arrival+Operation+Departure(Hour)");
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix+"gross_tml_prod" 	, false, "", dfNullFloat, 1, false, false, -1, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  43, daRight,  false, 	prefix+"gross_crane_prod" 	, false, "", dfNullFloat, 1, false, false, -1, false, false, "Gross Crane Productivity(Move)");
			InitDataProperty(0, cnt++, dtData    ,  43, daRight,  false, 	prefix+"net_crane_prod" 	, false, "", dfNullFloat, 1, false, false, -1, false, false, "Net Crane Productivity(Move)");
			InitDataProperty(0, cnt++, dtData    ,  43, daRight,  false, 	prefix+"twin_lift"      	, false, "", dfNullInteger, -1, false, false, -1, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  43, daRight,  false, 	prefix+"dual_cycle"     	, false, "", dfNullInteger, -1, false, false, -1, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  50, daRight,  false, 	prefix+"restow"         	, false, "", dfNullInteger, -1, false, false, -1, false, false, "(Move)");
			InitDataProperty(0, cnt++, dtData    ,  50, daRight,  false, 	prefix+"crane_no"     		, false, "", dfNullFloat, 1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, false, 	prefix+"stw_dif_hrs_flg"    , false, "", dfNone, 1, false,	false, -1, false, false, "Pre stowage plan")
			InitDataProperty(0, cnt++, dtData    ,  95, daCenter, false, 	prefix+"work_commenced"		, false, "", dfUserFormat2, -1, false,	false, -1, false)
			InitDataProperty(0, cnt++, dtData    ,  95, daCenter, false, 	prefix+"work_copleted" 		, false, "", dfUserFormat2, -1, false,	false, -1, false)
			
			InitDataProperty(0, cnt++, dtHidden	 ,  65, daCenter, true, 	prefix+"yd_cd"          	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daRight,  true, 	prefix+"act_dep_dt"     	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daCenter, true, 	prefix+"vvd_cd_group"      	, false, "", dfNone);
			
			InitDataProperty(0, cnt++, dtHidden  ,  65, daCenter, true, 	prefix+"vsl_cd"        	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daRight,  true, 	prefix+"skd_voy_no"     	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daCenter, true, 	prefix+"skd_dir_cd"      	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,  60, daCenter, true, 	prefix+"port_cd"      	, false, "", dfNone);

			InitUserFormat2(0, prefix+"work_commenced", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"work_copleted" , "####-##-## ##:##", "-|:" );
			ToolTipOption="balloon:true;width:1000;forecolor:#000000;icon:1";
			WaitImageVisible=false;
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObjects[0].WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0401GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;
			
		case IBSAVE:
			sheetObj.Redraw = false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSave("VOP_OPF_0401GS.do", sParam, -1, false);
			ComOpenWait(false);
			sheetObj.Redraw = true;
			break;			
	}
}

/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
*/ 

function initCombo(comboObj, comboNo) {
	var formObj = document.form

	switch (comboObj.id) {
	case "kpi_tgt_yr":
    	DropHeight = 100;
    	MultiSelect = false;
    	MaxSelect = 1;
    	MaxLength = 4;
        break;
	case "kpi_ver_seq":
		DropHeight = 100;
    	MultiSelect = false;
    	MaxSelect = 1;
    	MaxLength = 2;
        break;
	case "rhq_ofc_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			//ValidChar(2, 0);// 영문대문자만 입력가능
			MaxLength = 5;
			var i = 0;
			InsertItem(i++, "All", " ");
			InsertItem(i++, "HAMRU", "HAMRU");
			InsertItem(i++, "NYCRA", "NYCRA");
			InsertItem(i++, "SELIB", "SELIB");
			InsertItem(i++, "TYOIB", "TYOIB");
			InsertItem(i++, "SHARC", "SHARC");
			InsertItem(i++, "SINRS", "SINRS");
			InsertItem(i++,  "VVOIA", 	"VVOIA");
		}
		// Login Office 의 RHQ가 있으면 그것으로 하고 아니면 첫번째 RHQ를 default로 한다.
		var dfltInx = comboObj.FindIndex(rhqOfcCd, 0);
		comboObj.Text2 = (dfltInx == "-1"?"All":dfltInx);
		break;
		
	case "gubun":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			//ValidChar(2, 0);// 영문대문자만 입력가능
			var i = 0;
			InsertItem(i++, "KPI/PFMC", "KPI_PFMC");
			InsertItem(i++, "Base Line/PFMC", "BASE_PFMC");
			InsertItem(i++, "KPI", "KPI");
			InsertItem(i++, "PFMC", "PFMC");
			InsertItem(i++, "Base Line", "BASE");
		}
		
		comboObj.Code2 = "KPI_PFMC";
		
		break;
				
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if(isNull(formObj.fr_dt.value)){
				ComShowCodeMessage("OPF50009", "Duration");
				formObj.fr_dt.focus();
				return false;
			}else if(isNull(formObj.to_dt.value)){
				ComShowCodeMessage("OPF50009", "Duration");
				formObj.to_dt.focus();
				return false;
			}else if(ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value)<0){
				ComShowCodeMessage("OPF50004", "Duration");
				formObj.fr_dt.focus();
				return false;
			}else if(ComGetDaysBetween(formObj.to_dt.value, ComGetDateAdd(formObj.fr_dt.value, "M", 3, ""))<0){
				ComShowCodeMessage("OPF50022", "Duration", "3 Months");
				formObj.fr_dt.focus();
				return false;
			}
			
			var vGubun = comboObjects[3].Code;
			//if(!formObj.gubun[2].checked) {
			if(vGubun != "PFMC") {
				if(isNull(comboObjects[0].Code)) {
					ComShowCodeMessage("OPF50009", "KPI Year");
					ComSetFocus(comboObjects[0]);
					return false;
				}else if(isNull(comboObjects[1].Code)) {
					ComShowCodeMessage("OPF50009", "KPI Year");
					ComSetFocus(comboObjects[1]);
					return false;
				}
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
	with(sheetObj) {
		if(RowCount > 0) {
//			if(!document.form.gubun[1].checked) { 
//				ColHidden(prefix+"vvd_cd") = false;
//				for(var i = HeaderRows ; i <= LastRow ; i++) {
//					if(CellValue(i, prefix+"slan_cd") == "S.Avg") {
//						CellFont("FontBold", i, prefix+"slan_cd") = true;
//						CellAlign(i, prefix+"slan_cd") = daLeft;
//						for(var j = SaveNameCol(prefix+"slan_cd") ; j <= LastCol ; j++) {
//							CellBackColor(i, j) = RgbColor(232, 231, 236);
//						}
//					}else if(CellValue(i, prefix+"rhq") == "G.Avg") {
//						CellAlign(i, prefix+"rhq") = daLeft;
//						for(var j = 0 ; j <=LastCol ; j++) {
//							CellFont("FontBold", i, j) = true;
//							CellBackColor(i, j) = RgbColor(247, 225, 236);
//						}
//					}
//				}
//			}else {
//				ColHidden(prefix+"vvd_cd") = true;
//			}
		}
	}
}

/**
 * 그리드 클릭시
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);

	with(sheetObj) {
		if(RowCount > 0) {
			if (sName == "sheet1_except_cd") {
				if(sheetObj.CellValue(Row, prefix+"vvd_cd").length != 9){
					sheetObj.CellValue2(Row, prefix+"except_cd") = 1;
				}
			}
			
			if (sName == "sheet1_except_pob_flg") {
				if(sheetObj.CellValue(Row, prefix+"vvd_cd").length != 9){
					sheetObj.CellValue2(Row, prefix+"except_pob_flg") = 1;
				}
			}
		}
	}
}

/**
 * 그리드 더블 클릭시
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);

	with(sheetObj) {
		if(RowCount > 0) {
			if (sName == "sheet1_ttl_mvs") {
				sheetObj.ColHidden(prefix+"ttl_mvs") = true;
				sheetObj.ColHidden(prefix+"ttl_mvs2") = false;
				sheetObj.ColHidden(prefix+"full_l_40") = false;
				sheetObj.ColHidden(prefix+"full_l_20") = false;
				sheetObj.ColHidden(prefix+"full_d_40") = false;
				sheetObj.ColHidden(prefix+"full_d_20") = false;
				sheetObj.ColHidden(prefix+"et_l_40") = false;
				sheetObj.ColHidden(prefix+"et_l_20") = false;
				sheetObj.ColHidden(prefix+"et_d_40") = false;
				sheetObj.ColHidden(prefix+"et_d_20") = false;
			}else if (sName == "sheet1_ttl_mvs2") {
				sheetObj.ColHidden(prefix+"ttl_mvs") = false;
				sheetObj.ColHidden(prefix+"ttl_mvs2") = true;
				sheetObj.ColHidden(prefix+"full_l_40") = true;
				sheetObj.ColHidden(prefix+"full_l_20") = true;
				sheetObj.ColHidden(prefix+"full_d_40") = true;
				sheetObj.ColHidden(prefix+"full_d_20") = true;
				sheetObj.ColHidden(prefix+"et_l_40") = true;
				sheetObj.ColHidden(prefix+"et_l_20") = true;
				sheetObj.ColHidden(prefix+"et_d_40") = true;
				sheetObj.ColHidden(prefix+"et_d_20") = true;
			}
		}
	}
}

/**
 * Port Code Key-in시 5자리 입력 후 호출
 */
function port_cd_keyup(){
	var formObj = document.form;
	sheetObjects[0].WaitImageVisible=false;
	sheetObjects[0].RemoveAll();
	
	formObj.f_cmd.value = SEARCH01;
	var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0401GS.do", FormQueryString(formObj));
	
	if(ComGetEtcData(sRhqXml, "PORT_CD") == ""){
		ComAlertFocus(formObj.port_cd, ComGetMsg("OPF50004", "'Port Code'"));
		formObj.port_cd.value = "";
	}else{
		var rhqOfcCd = ComGetEtcData(sRhqXml, "RHQ_OFC_CD");
		formObj.rhq_ofc_cd.Code2 = rhqOfcCd == "" ? " " : rhqOfcCd; 
		ComKeyEnter('lengthnextfocus');
	}
}

/**
 * LANE COde Key-In시 3자리 완료했을 때 호출하는 함수
 */
function slan_cd_keyup(){
	var formObj = document.form;
	sheetObjects[0].WaitImageVisible=false;
	sheetObjects[0].RemoveAll();

	formObj.f_cmd.value = COMMAND12;
	var lanXml = sheetObjects[0].GetSearchXml("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
	
	var strLanCdDesc = ComGetEtcData(lanXml, "checkLane");

	if(ComTrim(strLanCdDesc) == ""){
		ComAlertFocus(formObj.slan_cd, ComGetMsg("OPF50004", "'Lane Code'"));
		formObj.slan_cd.value = "";
	}else{
		ComKeyEnter('lengthnextfocus');
	}	
}

/**
 * KPI Year OnChange 이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function kpi_tgt_yr_OnChange(comboObj, Code, Text){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	sheetObj.RemoveAll();
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
	var sCode = ComGetEtcData(sXml, "KPI_VER_SEQ");
	setComboItem(comboObjects[1], sCode, comboObjects[1]);
	if(comboObjects[1].GetCount() > 0) {
		comboObjects[1].index = 1;
	}
}

/**
 * RHQ onChange이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function rhq_ofc_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
}

/**
 * KPI Year 셋팅
 * @param sheetObj
 * @param formObj
 */	
function initDefaultCombo(sheetObj, formObj){
	formObj.f_cmd.value = "";
	
	var kpiTgtYrXml = sheetObj.GetSearchXml("VOP_OPF_0410GS.do", FormQueryString(formObj));
	var kpiTgtYrCode = ComGetEtcData(kpiTgtYrXml, "KPI_TGT_YR");
	setComboItem(comboObjects[0], kpiTgtYrCode, comboObjects[0]);
	if(comboObjects[0].GetCount() > 0) {
		setKpiTgtYr(form.to_dt.value);
	}
	
}

function setKpiTgtYr(strToDt) {
	var chgToDt = strToDt.replace(/-/g, "");
	if(chgToDt.length == 8) {
		comboObjects[0].Code = chgToDt.substring(0, 4);
		if(comboObjects[0].Code != chgToDt.substring(0, 4)) {
			comboObjects[0].Index = 0;
		}
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
		comboObj.InsertItem(0, "", "");
		var j = 0 ;
		for (var i = 0 ; i < dataList.length ; i++) {
			j++;
			var comboItem = dataList[i].split(",");			
			comboObj.InsertItem(j, comboItem[1], comboItem[0]);
		}
	}
//	ComSetFocus(oriComboObj);
}

function UF_reset(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.fr_dt.value = frDt;
	formObj.to_dt.value = toDt;
	var dfltInx = comboObjects[2].FindIndex(rhqOfcCd, 0);
	comboObjects[2].Text2 = (dfltInx == "-1"?"All":dfltInx);
	
	formObj.port_cd.value = "";
	formObj.slan_cd.value = "";
//	formObj.gubun[0].checked = true;
	comboObjects[3].Code = "KPI_PFMC";
	sheetObj.RemoveAll();	
}

/**
 * 화면 폼입력값에 Null Check
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
 * onChange이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function gubun_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	

	if("BASE" == Code || "BASE_PFMC" == Code){
		var HeadTitle  = "|RHQ|Port|KPI&\nPerformance|Lane|Dir|Dbl\nCall|Dbl\nCall|VVD|Exp|POB Exp\n(TOR)|B.L\nACHV|Total  \nMoves(+)|Total  \nMoves(-)|F40L|F20L|F40D|F20D|M40L|M20L|M40D|M20D|Steam\nIn|Arrival|Operation|Departure|Port\nTime";
		HeadTitle     += "|G.TMNL\nProductivity|GMPH|NMPH|Twin\nLift|Dual\nCycle|Restow|No of\nG.Crane|Pre-plan\nSending|Work\ncommenced|Work\ncompleted|Yard|act_dep_dt|vvd_group|vsl_cd|voy_no|dir_cd|port_cd";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		sheetObjects[0].InitHeadRow(0, HeadTitle , true);
	}else{
		var HeadTitle  = "|RHQ|Port|KPI&\nPerformance|Lane|Dir|Dbl\nCall|Dbl\nCall|VVD|Exp|POB Exp\n(TOR)|KPI\nACHV|Total  \nMoves(+)|Total  \nMoves(-)|F40L|F20L|F40D|F20D|M40L|M20L|M40D|M20D|Steam\nIn|Arrival|Operation|Departure|Port\nTime";
		HeadTitle     += "|G.TMNL\nProductivity|GMPH|NMPH|Twin\nLift|Dual\nCycle|Restow|No of\nG.Crane|Pre-plan\nSending|Work\ncommenced|Work\ncompleted|Yard|act_dep_dt|vvd_group|vsl_cd|voy_no|dir_cd|port_cd";

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		sheetObjects[0].InitHeadRow(0, HeadTitle , true);
	}
}

/* 개발자 작업  끝 */