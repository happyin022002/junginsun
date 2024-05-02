/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : VOP_OPF_0406.js
 *@FileTitle : Port Time Activity Report by VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.04
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2012.02.15
 * 1.0 Creation
 * 2012.02.15 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
 * 2012.05.04 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
 * 2012-07-30 김상근 [CHM-201219138] [TOR] Port Time Activity Report by VVD 의 항목 계산수식 변경 및 Header 풍선도움말 삭제
 * 2012.10.22 김영오 [CHM-201220650] [TOR]: Port Time Activity Report by VVD  항목  추가
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
 * @class VOP_OPF_0406 : VOP_OPF_0406 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_OPF_0406() {
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

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
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

		case "btn_downexcel":
			sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", true, "", "", false, false, "");
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
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           , 'obj_keyup'     ,  formObj);
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
 * OnKeyUp
 */
function obj_keyup(){
	ComKeyEnter('lengthnextfocus');

	obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
	case "port_cd":
		if (formObj.port_cd.value.length == 5) {
			port_cd_keyup();
		}
		break;
	case "slan_cd":
		if (formObj.slan_cd.value.length == 3) {
			slan_cd_keyup();
		}
		break;
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
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1  = "Port Time Activity Report|Port Time Activity Report|Port Time Activity Report|Port Time Activity Report|Port Time Activity Report|Port Time Activity Report"
							+ "|Drifting / Anchor|Drifting / Anchor|Drifting / Anchor|Drifting / Anchor|Drifting / Anchor|Drifting / Anchor"
							+ "|Steam In|Steam In|Steam In"
							+ "|Arrival|Arrival|Arrival|Arrival|Arrival|Arrival|Arrival|Arrival"
							+ "|Operation"
							+ "|Departure|Departure|Departure|Departure|Departure|Departure"
							+ "|Container Handling Type|Container Handling Type|Container Handling Type|Pilot on board(VMS)|Pilot on board(VMS)|Pre-plan\nSending|Update date(L)";
			var HeadTitle2  = "RHQ|Port|Lane|VVD|Call\nSeq|Total\nMoves"
//							+ "|Drifting Start\n(BBO)|Drifting End\n(BBO)|Anchor Drop\n(VMS)|Anchor Away\n(VMS)|Anchor Drop\n(BBO)|Anchor Away\n(BBO)"
							+ "|Drifting Start\n(BBO)|Drifting\nEnd(BBO)|Anchor Drop\n(VMS)|Anchor\nAway(VMS)|Anchor Drop\n(BBO)|Anchor\nAway(BBO)"
							+ "|Pilot\non board|Sailing\nIn|Mooring (All\nlines fast)"
							+ "|Gangway\ndown|Safety\nnet|Quarantine\non board|Immigration/Agent\non board|Customs\nInspection on board|Lasher\non board|Gang move\nto berth|Gantry\ncrane ready"
							+ "|Operation"
							+ "|Lashing\nsinged off|Pilot\non board|Agent\noff-board|Gangway\nup|Tug boat\nready|Unmooring (All\nlines release)"
							+ "|Twin\nLift|Dual\nCycle|Restow|Stream in|Departure|Pre-plan\nSending|Port time activity\ncreation";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount+21, 6, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1 , true);
			InitHeadRow(1, HeadTitle2 , true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData    ,  45, daCenter, true, 	prefix+"rhq"						, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  65, daCenter, true, 	prefix+"yd_cd"	  	 	 			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  35, daCenter, true, 	prefix+"slan_cd"        			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData  	 ,  70, daCenter, false,	prefix+"vvd"         				, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData  	 ,  30, daCenter, false,	prefix+"clpt_ind_seq"         		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  50, daRight,  false, 	prefix+"tdr_mvs"        			, false, "", dfInteger);
			
			InitDataProperty(0, cnt++, dtData    ,  98, daRight,  false, 	prefix+"drifting_start_bbo"  		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"drifting_end_bbo"  			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  98, daRight,  false, 	prefix+"anchor_drop_vms"  			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  70, daRight,  false, 	prefix+"anchor_away_vms"  			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  98, daRight,  false, 	prefix+"anchor_drop_bbo"  			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  70, daRight,  false, 	prefix+"anchor_away_bbo"  			, false, "", dfTimeHm);
			
			InitDataProperty(0, cnt++, dtData    ,  57, daRight,  false, 	prefix+"pilot_on_board_arr"  		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  55, daRight,  false, 	prefix+"sailing_in"   				, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix+"mooring_all_lines_fast" 	, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"gangway_down" 				, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  55, daRight,  false, 	prefix+"safety_net"      			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix+"quarantine_on_board" 		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    , 120, daRight,  false, 	prefix+"immigration_agent_on_board" , false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    , 120, daRight,  false, 	prefix+"customs_inspection_on_board", false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"lasher_on_board"      		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix+"gang_move_to_berth"     	, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  75, daRight,  false, 	prefix+"gantry_crane_ready"         , false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix+"operation"  				, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  65, daRight,  false, 	prefix+"lashing_singed_off"   		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  57, daRight,  false, 	prefix+"pilot_on_board_dep" 		, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"agent_off_board" 			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"gangway_up"      			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  60, daRight,  false, 	prefix+"tug_boat_ready" 			, false, "", dfTimeHm);
			InitDataProperty(0, cnt++, dtData    ,  95, daRight,  false, 	prefix+"unmooring_all_lines_release", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  55, daRight,  false, 	prefix+"twin_lift" 					, false, "", dfFloat );
			InitDataProperty(0, cnt++, dtData    ,  40, daRight,  false, 	prefix+"dual_cycle"      			, false, "", dfFloat );
			InitDataProperty(0, cnt++, dtData    ,  50, daRight,  false, 	prefix+"restow"     				, false, "", dfFloat );
			
			//2012.10.22 김영오 [CHM-201220650] [TOR]: Port Time Activity Report by VVD  항목  추가
			InitDataProperty(0, cnt++, dtData    ,  95, daCenter, false,	prefix+"plt_in_dt" 					, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  95, daCenter, false,	prefix+"plt_out_dt" 				, false, "", dfNone);
			InitDataProperty(0, cnt++, dtData    ,  55, daCenter, true,	    prefix+"stw_dif_hrs_flg" 			, false, "", dfNone, 1, false,	false, -1, false, false, "Pre stowage plan")
			InitDataProperty(0, cnt++, dtData    ,  95, daCenter, false,	prefix+"port_tm_act_upd_dt" 		, false, "", dfNone);
			
			//2012.05.04 조경완  [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건  - Remark 정보를 보여주기 위해 추가
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"pilot_on_board_arr_rmk"     , false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"sailing_in_rmk"     		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"mooring_all_lines_fast_rmk" , false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"gangway_down_rmk"		 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"safety_net_rmk" 			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"quarantine_on_board_rmk" 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"immigration_agent_on_board_rmk" , false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"customs_on_board_rmk" 		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"lasher_on_board_rmk" 		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"gang_move_to_berth_rmk" 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"gantry_crane_ready_rmk" 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"operation_rmk" 				, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"lashing_singed_off_rmk" 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"pilot_on_board_dep_rmk" 	, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"agent_off_board_rmk" 		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"gangway_up_rmk" 			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"tug_boat_ready_rmk" 		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"unmooring_release_rmk" 		, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"twin_lift_rmk" 				, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"dual_cycle_rmk" 			, false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden  ,   0, daCenter, false,	prefix+"restow_rmk" 				, false, "", dfNone);
			
			setMergeCell(0, 23, 2, 1);
			ToolTipOption="balloon:true;width:1000;forecolor:#000000;icon:1";
			
			SelectHighLight = false;
			
		}
		break;

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
			sheetObjects[0].WaitImageVisible=false;
			sheetObj.Redraw = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_OPF_0406GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);
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
	case "rhq_ofc_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = false;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);// 영문대문자만 입력가능
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
			}else if(ComGetDaysBetween(formObj.to_dt.value, ComGetDateAdd(formObj.fr_dt.value, "M", 2, ""))<0){
				ComShowCodeMessage("OPF50022", "Duration", "2 Months");
				formObj.fr_dt.focus();
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
		if(RowCount > 0) {
			for(var i = HeaderRows ; i <= LastRow ; i++) {
				//회색
				if(CellValue(i, prefix+"vvd") == "S.Avg") {
					CellFont("FontBold", i, prefix+"vvd") = true;
					CellAlign(i, prefix+"vvd") = daLeft;
					for(var j = SaveNameCol(prefix+"vvd") ; j <= LastCol ; j++) {
						CellBackColor(i, j) = RgbColor(232, 231, 236);
					}
				}else {
					//노랑
					for(var j = SaveNameCol(prefix+"pilot_on_board_arr") ; j <= SaveNameCol(prefix+"unmooring_all_lines_release") ; j++) {
						if(ColSaveName(j) != prefix+"operation"){
							if(CellValue(i, j) == "Combined") {
								CellBackColor(i, j) = RgbColor(255, 255, 204);
								/* 2012.08.02 Remove yellow color.
								if(ColSaveName(j-1) != prefix+"tdr_mvs"){
									if(CellValue(i, j-1) != "Combined") {
										if(ColSaveName(j-1) == prefix+"operation") {
											if(CellValue(i, j-2) != "Combined") {
												CellBackColor(i, j-2) = RgbColor(255, 255, 0);
											}
										}else {
											CellBackColor(i, j-1) = RgbColor(255, 255, 0);
										}
									}
								}
								*/
							}
						}
					}
					//2012.05.04 조경완  [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건  
					for(var k = SaveNameCol(prefix+"pilot_on_board_arr_rmk") ; k <= SaveNameCol(prefix+"restow_rmk") ; k++) {
						if(CellValue(i, k) != "N" && CellValue(i, k) != "" && CellValue(i, k) != "N/N"){
							if(k == SaveNameCol(prefix+"twin_lift_rmk")||k == SaveNameCol(prefix+"dual_cycle_rmk")||k == SaveNameCol(prefix+"restow_rmk")){
								if(CellValue(i, k-21)!= 0){
									CellFontColor(i, k-21) = RgbColor(255, 0, 0);
								}
							}else{
								CellFontColor(i, k-21) = RgbColor(255, 0, 0);
							}
						}
					}
				}
			}
			//분홍
			if(RowCount > 1) {
				CellAlign(LastRow, prefix+"rhq") = daLeft;
				for(var j = 0 ; j <=LastCol ; j++) {
					CellFont("FontBold", LastRow, j) = true;
					CellBackColor(LastRow, j) = RgbColor(247, 225, 236);
				}
			}
			
		}
	}
}

/**
 * OnMouseMove 이벤트
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	with(sheetObj) {
		//2012.05.04 조경완  [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건  - Remark 값을 텍스트 풍선으로 보여줌
		if(MouseCol > 11){
			if(CellValue(MouseRow, MouseCol+21) != "N" && CellValue(MouseRow, MouseCol+21) != "" && CellValue(MouseRow, MouseCol+21) != "N/N" ){
				if(ColSaveName(MouseCol) ==  prefix+"twin_lift"||ColSaveName(MouseCol) ==  prefix+"dual_cycle"||ColSaveName(MouseCol) ==  prefix+"restow"){
					if(CellValue(MouseRow, MouseCol) != 0){
						MouseToolTipText = CellValue(MouseRow, MouseCol+21);
					}else{
						MouseToolTipText = "";
					}
				}else{
					MouseToolTipText = CellValue(MouseRow, MouseCol+21);
				}
			}else{
				MouseToolTipText = "";
			}
		} 
		else{
			MouseToolTipText = "";
		}
	}
}


/**
 * Port Code Key-in시 5자리 입력 후 호출
 */
function port_cd_keyup(){
	var formObj = document.form;
	sheetObjects[0].WaitImageVisible=false;
	
	formObj.f_cmd.value = SEARCH01;
	var sRhqXml = sheetObjects[0].GetSearchXml("VOP_OPF_0406GS.do", FormQueryString(formObj));
	
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
 * RHQ onChange이벤트
 * @param comboObj
 * @param Code
 * @param Text
 */
function rhq_ofc_cd_OnChange(comboObj, Code, Text){
	sheetObjects[0].RemoveAll();
	document.form.port_cd.value = "";
}

/**
 * 화면 초기화
 */
function UF_reset(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.fr_dt.value = frDt;
	formObj.to_dt.value = toDt;
	var dfltInx = comboObjects[0].FindIndex(rhqOfcCd, 0);
	comboObjects[0].Text2 = (dfltInx == "-1"?"All":dfltInx);
	
	formObj.port_cd.value = "";
	formObj.slan_cd.value = "";
	sheetObj.RemoveAll();	
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
/* 개발자 작업  끝 */