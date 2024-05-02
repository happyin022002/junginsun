/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0203.js
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.11.23 kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.03.15 최 선   1.1 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0203 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0203() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수  */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0; //SHEET를 늘렸다가 줄였다가.
var docObjsep = "";

var isOverplan ="N";

var R = 222;
var G = 251;
var B = 248;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(7);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(27, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
				var HeadTitle1 = "|STS|Kind|Reference No|Requested\nDate|CNTR\nTP/SZ|Quantity|Quantity|Quantity|Quantity|Quantity|Rail ORG|Rail ORG|Rail ORG|Rail DEST|Rail DEST|Rail DEST|Trans.\nMode|Lane|VVD|Reason\nRemark|" ;
				var HeadTitle2 = "|STS|Kind|Reference No|Requested\nDate|CNTR\nTP/SZ|Allocated|Rail Billed|EDI Sent|Remaining|Needed|Loc|Nod|ETD|Loc|Nod|ETA|Trans.\nMode|Lane|VVD|Reason\nRemark|" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	true, 	"chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 	40, 	daCenter, 	true, 	"ibflag");
				InitDataProperty(0, cnt++, dtCombo, 		80,	    daCenter, 	true, 	"so_if_div_cd",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			120,	daCenter, 	true, 	"ref_id", 					false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			80,		daCenter, 	true, 	"so_rqst_dt", 				false, "", dfDateYmd, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtCombo, 		50,		daCenter, 	true, 	"eq_tpsz_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	"allocated", 				false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	"cret_qty", 				false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	"edi_qty", 					false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			80, 	daRight, 	true, 	"remaining_qty", 			false, "", dfInteger, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	true, 	"needed_qty", 				false, "", dfInteger, 	0, true, 	true);
				InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"fm_loc_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtCombo, 		40, 	daCenter, 	true, 	"fm_nod_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	"fm_dt", 					false, "", dfDateYmd, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"to_loc_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	"to_nod_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 			70, 	daCenter, 	true, 	"to_dt", 					false, "", dfDateYmd, 	0, false, 	false);
				InitDataProperty(0, cnt++, dtCombo, 		60, 	daCenter, 	true, 	"trsp_mod_cd",				false, "", dfNone, 		1, false, 	false, 1); //TRSP_MOD_CD
				InitDataProperty(0, cnt++, dtData, 			40, 	daCenter, 	true, 	"slan_cd",					false, "", dfNone, 		1, false, 	false, 3); //Lane
				InitDataProperty(0, cnt++, dtData, 			75, 	daCenter, 	true, 	"vvd_cd",					false, "", dfNone, 		1, false, 	false, 9); //VVD
				InitDataProperty(0, cnt++, dtData,	 		80, 	daLeft,   	true, 	"repo_purp_rmk",			false, "", dfNone, 		1, false, 	false, 100); //Reason Remark

				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, 	true, 	"trsp_cost_dtl_mod_cd",		false, "", dfNone, 		0, false, 	false, 1);
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter, 	true, 	"trsp_crr_mod_cd",			false, "", dfNone, 		1, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 		30, 	daCenter, 	true, 	"curr_dt", 					false, "", dfNone, 		0, false, 	false);
				
				InitDataProperty(0, cnt++, dtHidden, 		80, 	daCenter,	true, 	"repo_pln_id",				false, "", dfNone, 		1, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, 	true, 	"pln_yrwk",					false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, 	true, 	"pln_seq", 					false, "", dfNone, 		0, false, false);
				
				InitDataValid(0, "fm_loc_cd",	vtEngUpOnly, "");
				InitDataValid(0, "to_loc_cd", 	vtEngUpOnly, "");

				InitDataValid(0, "slan_cd", 	vtEngUpOther, "0123456789");
				InitDataValid(0, "vvd_cd", 		vtEngUpOther, "0123456789");
				
				InitDataCombo(0, "eq_tpsz_cd","D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|O7|S2|S4|F2|F4|F5|A2|A4","D2|D4|D5|D7|R2|R5|R9|O2|O4|O5|O7|S2|S4|F2|F4|F5|A2|A4");
				InitDataCombo(0, 'so_if_div_cd', 'Empty Repo', 'R');
				InitDataCombo(0, 'trsp_mod_cd', 'RD', 'R');

				RangeBackColor(1,6, 1,10) = RgbColor(222, 251, 248);   // ENIS
				HeadRowHeight = 10;
			}
		break;
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(36, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
				
				var HeadTitle1 = "|STS|Reference No|Purpose|CNTR No|CNTR\nTP/SZ|Rail ORG|Rail ORG|Rail DEST|Rail DEST|Route\nPlan|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Verify Result|Internal Remark|Remark\n(Special Instruction)";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				//InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "trsp_cost_dtl_mod_name", false, "", dfNone, 0, false, false);
				//InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "suspended_reason", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		120,	daCenter, 	true, "ref_id", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "repo_purp_rmk", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "eq_no", 					false, "", dfEngUpKey, 	1, true, 	true, 11);
				InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, "eq_tpsz_cd", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, "fm_nod_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		30, 	daCenter, 	true, "fm_nod_yard", 			false, "", dfNone,		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, "to_nod_cd", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		30, 	daCenter, 	true, "to_nod_yard", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		50, 	daCenter, 	true, "rout_pln_cd", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		70, 	daCenter, 	true, "lessor", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "lstm_cd", 				false, "", dfNone,		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "ownr_co_cd", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "eq_used", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "movement_sts", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		90, 	daCenter, 	true, "creation_yard", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true, "event_date", 			false, "", dfNone, 		0, false, 	false);
				//InitDataProperty(0, cnt++, dtPopup,80, daCenter, true, "request_sp", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		90, 	daLeft, 	true, "verify_result", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, 	true, "inter_rmk", 				false, "", dfNone, 		0, true,	true, 255);
				
				InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, 	true, "spcl_instr_rmk", 		false, "", dfNone, 		0, true, 	true, 255);
				InitDataProperty(0, cnt++, dtHidden, 	10, 	daCenter, 	true, "trsp_so_ofc_cty_cd",		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	10, 	daCenter, 	true, "cre_usr_id", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden,	10, 	daCenter, 	true, "rail_cmb_thru_tp_cd",	false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	80, 	daCenter,	true, "trsp_mty_rqst_dt",		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden,	10, 	daCenter, 	true, "trsp_mty_cost_mod_cd",	false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	80, 	daCenter, 	true, "repo_pln_id",			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	80, 	daCenter, 	true, "pln_yrwk",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	10, 	daCenter, 	true, "ref_seq",				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, "rout_seq", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, "rout_org_nod_cd", 		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, "rout_dest_nod_cd", 		false, "", dfNone, 		0, false, 	false);

				InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, "inlnd_rout_rmk", 		false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	50, 	daCenter, 	true, "rout_dtl_seq", 			false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	30,		daCenter, 	true, "so_cre_yn", 				false, "", dfNone, 		0, false, 	false);
				InitDataProperty(0, cnt++, dtHidden, 	30, 	daCenter, 	true, "cgo_tp_cd", 				false, "", dfNone, 		0, false, 	false);
			}
		break;
		case 3:      //sheet1 init
			with (sheetObj) {
				style.height = 0; // 높이 설정
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 5, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				InitDataProperty(0, cnt++, dtData,	60, 	daCenter, true, "sep", 				false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,	100, 	daCenter, true, "eq_no", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,	600, 	daCenter, true, "verify_result", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,	90, 	daCenter, true, "verify_yn", 		false, "", dfNone, 		0, false, false);

				InitDataProperty(0, cnt++, dtData, 	80, 	daCenter, true, "lessor", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80,		daCenter, true, "lstm_cd",  		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, 	daCenter, true, "ownr_co_cd", 		false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80,		daCenter, true, "eq_used", 			false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, 	daCenter, true, "movement_sts", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData,	80, 	daCenter, true, "creation_yard", 	false, "", dfNone, 		0, false, false);
				InitDataProperty(0, cnt++, dtData, 	80, 	daCenter, true, "event_date", 		false, "", dfDateYmd, 	0, false, false);
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
				}
			break;

			case "btn_reset":
				formObject.reset();
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject.RemoveEtcData() 
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;

			case "btng_apply": //적용
				if( searchValidation(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "DW", "");
				}
			break;

			case "btng_fillincontainers":
				if( contatnerValidation(sheetObject1, formObject, "chk1") ) {
					popEqFileImport(sheetObject1, formObject);
				}
			break;

			case "btng_verify":
				if( searchVerify(sheetObject1, formObject, "chk1") ) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "VY", "");
				}
			break;

			case "btng_irgadjust":
				doActionPopupOpen(sheetObject1, formObject);
			break;

			case "btng_socreation":
				if( validateForm(sheetObject1, formObject) ) {
					doActionIBSheet(sheetObject1, formObject, IBINSERT, "", "");
				}
			break;

			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_multirefer": //M Reference No
				openMultipleinquiry('REF', 'Reference No');
			break;
			
			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;

			case "btns_calendar":
				getCalendar();
			break;

			case "btns_tvvd": //Trunk VVD Popup창
				openTVVDPopup();
			break;
			
			case "btng_rowadd":
				addOneRow(sheetObject);
			break;
			case "btng_delete":
				deleteCheckedRow(sheetObject);
			break;
			case "btng_save":
				if(validateSave()){
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;

		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj, formObj, sAction, obj, irow) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //조회
			if( obj == "DW" ) {
				formObj.f_cmd.value = SEARCH09;
				//sheetObj.DoSearch4Post("ESD_TRS_02031GS.do", TrsFrmQryString(formObj));
				IBS_DoSearchSax(sheetObj, "ESD_TRS_02031GS.do", TrsFrmQryString(formObj));
			} else if( obj == "VY" ) { //Verify
				formObj.f_cmd.value = SEARCH11;
				sheetObj.DoSearch4Post("ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			} else if( obj == "EQ" ) { //Verify
				formObj.f_cmd.value = SEARCH14;
				sheetObj.DoSearch4Post("ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			} else {
				formObj.f_cmd.value = SEARCH08;
				//sheetObj.DoSearch4Post("ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
				IBS_DoSearchSax(sheetObj, "ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			}
		break;
		
		case IBINSERT:	  //입력
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESD_TRS_0203GS.do", TrsFrmQryString(formObj), "chk1", false, true);
		break;
		
		case IBSAVE:
			formObj.f_cmd.value = MULTI03;
			sheetObj.DoSave("ESD_TRS_0203GS.do",FormQueryString(formObj));
			
		break;
		
		
	}
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "","");
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function searchValidation(sheetObj, formObj, sStatus) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var lvTrspCostModCd = "";
	var lvRefId = "";
	var lvFmNodCd = "";
	var lvToNodCd = "";
	var lvEqTpszCd = "";
	var lvMoreQty = "";
	

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];

		// overplan 도는 조건.  need 가 더 크면 overplan 돔.
		if(  sheetObj.CellValue(fromRow, "needed_qty") > sheetObj.CellValue(fromRow, "remaining_qty") ){
			isOverplan = "Y";
		}

		if( arrRow.length-2 == i ) {
			lvTrspCostModCd = lvTrspCostModCd +""+ sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd");
			lvRefId         = lvRefId         +""+ sheetObj.CellValue(fromRow, "ref_id");
			lvFmNodCd       = lvFmNodCd       +""+ sheetObj.CellValue(fromRow, "fm_nod_cd");
			lvToNodCd       = lvToNodCd       +""+ sheetObj.CellValue(fromRow, "to_nod_cd");
			lvEqTpszCd      = lvEqTpszCd      +""+ sheetObj.CellValue(fromRow, "eq_tpsz_cd");
			lvMoreQty       = lvMoreQty       +""+ ( sheetObj.CellValue(fromRow, "needed_qty") - sheetObj.CellValue(fromRow, "remaining_qty") ) ;
} else {
			lvTrspCostModCd = lvTrspCostModCd +""+ sheetObj.CellValue(fromRow, "trsp_cost_dtl_mod_cd")+",";
			lvRefId         = lvRefId         +""+ sheetObj.CellValue(fromRow, "ref_id")         +",";
			lvFmNodCd       = lvFmNodCd       +""+ sheetObj.CellValue(fromRow, "fm_nod_cd")           +",";
			lvToNodCd       = lvToNodCd       +""+ sheetObj.CellValue(fromRow, "to_nod_cd")           +",";
			lvEqTpszCd      = lvEqTpszCd      +""+ sheetObj.CellValue(fromRow, "eq_tpsz_cd")          +",";
			lvMoreQty       = lvMoreQty       +""+ ( sheetObj.CellValue(fromRow, "needed_qty") - sheetObj.CellValue(fromRow, "remaining_qty") ) + "," ;
		}
	}
	
	if(lvRefId==""){
		errMsg = ComGetMsg("TRS90526");
		ComShowMessage(errMsg);
		return false;
	}
	
	formObj.hid_trsp_cost_mod_cd.value = lvTrspCostModCd;
	formObj.hid_ref_id.value           = lvRefId;
	formObj.hid_fm_nod_cd.value        = lvFmNodCd;
	formObj.hid_to_nod_cd.value        = lvToNodCd;
	formObj.hid_eq_tpsz_cd.value       = lvEqTpszCd;
	formObj.hid_more_qty.value       = lvMoreQty;
	formObj.hid_curr_dt.value       = sheetObj.CellValue(2, "curr_dt");  // 현재 날짜. db에서 최초 조회시 all row 에대해 일괄 값으로 받아옴..


	return true;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 - verify
 */
function searchVerify(sheetObj, formObj, sStatus) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	//데이터 행의 개수 확인
	var fromRow = 0;
	var lvEq_no = "";
	var lvFm_nod_cd = "";
	var lvDtlToNodCd = "";

	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	
	if( arrRow.length-1 > 0 && arrRow.length-1 < 1001 ) {
		for( var i=0; i<arrRow.length-1; i++ ) {
			fromRow = arrRow[i];
			if( sheetObj.CellValue(fromRow, "eq_no") == "" || sheetObj.CellValue(fromRow, "fm_nod_cd") == "" ) {
				sheetObj.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
				sheetObj.RowStatus(arrRow[i]) = "R";
				sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			} else {
				if( arrRow.length-2 == i ) {
					lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no");
					lvFm_nod_cd = lvFm_nod_cd +""+ sheetObj.CellValue(fromRow, "fm_nod_cd");
					lvDtlToNodCd = lvDtlToNodCd +""+ sheetObj.CellValue(fromRow, "to_nod_cd");
				} else {
					lvEq_no = lvEq_no +""+ sheetObj.CellValue(fromRow, "eq_no")+",";
					lvFm_nod_cd = lvFm_nod_cd +""+ sheetObj.CellValue(fromRow, "fm_nod_cd")+",";
					lvDtlToNodCd = lvDtlToNodCd +""+ sheetObj.CellValue(fromRow, "to_nod_cd")+",";
				}
			}
		}
		if( sheetObj.CheckedRows("chk1") < 1 ) {
			errMsg = ComGetMsg("TRS90132");
			ComShowMessage(errMsg);
			return false;
		}
		formObj.eq_no_verify.value = lvEq_no;
		formObj.frm_node_verify.value = lvFm_nod_cd;
		formObj.to_nod_verify.value = lvDtlToNodCd;	
	}else{
		ComShowMessage('Only 1000 rows or less could be imported at a time.');
		return false;
	}
	return true;
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[1];
}

/**
 * Container File import에 대한 유효성검증 프로세스 처리
 */
function contatnerValidation(sheetObj, formObj, sStatus) {
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length - 1; i++ ) {
		if( sheetObj.CellValue(arrRow[i], "eq_no") != "" ) {
			sheetObj.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
		}
	}
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90051");
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}

/*
 * 팝업창에서 사용하는 Sheet 객체(지우면 안됨) contain File Import할 때 사용함.
 */
function getSheetObj() {
	return sheetObjects[1];
}

/**
* file import window 호출
*/
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=395, height=385, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var doc_eq_no = "";
	var bverifychk = false;
	var birgchk = false;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");



	for( var i=0; i<arrRow.length-1; i++ ) {
		doc_eq_no = ComTrimAll(sheetObj.CellValue(arrRow[i], "eq_no"), " ");
		if( sheetObj.CellValue(arrRow[i], "so_cre_yn") != "Y" ) {
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);

			if( sheetObj.CellValue(arrRow[i], "verify_result") == "") errMsg = ComGetMsg("TRS90360");
				else errMsg = ComGetMsg("TRS90078");
			ComShowMessage(errMsg);
			return false;
		}
		if( sheetObj.CellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);

			errMsg = ComGetMsg("TRS90148");
			ComShowMessage(errMsg);
			return false;
		}
		if( doc_eq_no == "" ) {
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			sheetObj.CellValue2(arrRow[i], "lessor") = "";
			sheetObj.CellValue2(arrRow[i], "lstm_cd") = "";
			sheetObj.CellValue2(arrRow[i], "ownr_co_cd") = "";
			sheetObj.CellValue2(arrRow[i], "eq_used") = "";
			sheetObj.CellValue2(arrRow[i], "movement_sts") = "";
			sheetObj.CellValue2(arrRow[i], "creation_yard") = "";
			sheetObj.CellValue2(arrRow[i], "event_date") = "";
		}
	}

	return true;
}

/**
 * Sheet1에서 이벤트를 발생시킴.
 */
var doc_row = 0; //container check..
function sheet2_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "I";
		} else {
			sheetObj.RowStatus(row) = "R";
		}
	} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
		var doc_eq_no = sheetObj.CellValue(row, "eq_no");
		if( doc_eq_no.length >= 10 ) {
			doc_row = row;
			document.form.hid_cntr_no.value = doc_eq_no;
			document.form.hid_cntr_tpsz_cd.value = sheetObj.CellValue(row, "eq_tpsz_cd");
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH, "EQ","");
		} else {
			sheetObj.CellValue(row, "eq_no") = "";
			sheetObj.CellValue2(row, "lessor") = "";
			sheetObj.CellValue2(row, "lstm_cd") = "";
			sheetObj.CellValue2(row, "ownr_co_cd") = "";
			sheetObj.CellValue2(row, "eq_used") = "";
			sheetObj.CellValue2(row, "movement_sts") = "";
			sheetObj.CellValue2(row, "creation_yard") = "";
			sheetObj.CellValue2(row, "event_date") = "";
		}
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90103");
		ComShowMessage(errMsg);
		//원본에서 역순으로 특정 상태의 행을 이동한다.
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var ir = arrRow.length-2; ir >=0 ; ir-- ) {
			//원본에서 지움
			sheetObj.RowDelete(arrRow[ir], false);
		}
		if( validateFormSearch(document.form) ) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "","");
		}
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj,errMsg) {

	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		 // apply 버튼 누를시 overplan 여부에 따라 retrieve 재수행.
		 if( document.form.f_cmd.value == SEARCH09 ) {
		 
			var currRefid= document.form.hid_ref_id.value;
			var moreQty= document.form.hid_more_qty.value;
			var overplanRefid= sheetObj.EtcData('overplan_ref_id');

			var arr_currRefid = currRefid.split(",");
			var arr_moreQty = moreQty.split(",");
			var arr_overplanRefid = overplanRefid.split(",");

			for( var i=0; i<arr_currRefid.length; i++ ) {

				if( arr_overplanRefid[i] != "nl" ) {
					var rRow = sheetObjects[0].FindText("ref_id", arr_currRefid[i]  , 0);
					var iRow = sheetObjects[0].DataInsert(rRow );
					sheetObjects[0].CellValue2(iRow, "chk1") = "Y";
					sheetObjects[0].CellValue2(iRow, "trsp_cost_dtl_mod_name" )	= sheetObjects[0].CellValue(rRow, "trsp_cost_dtl_mod_name");
					sheetObjects[0].CellValue2(iRow, "requested_date" )			= sheetObjects[0].CellValue(rRow, "curr_dt");
					sheetObjects[0].CellValue2(iRow, "ref_id" )					= arr_overplanRefid[i];
					sheetObjects[0].CellValue2(iRow, "eq_tpsz_cd" )				= sheetObjects[0].CellValue(rRow, "eq_tpsz_cd");
					sheetObjects[0].CellValue2(iRow, "allocated" )				= arr_moreQty[i];
					sheetObjects[0].CellValue2(iRow, "cret_qty" )					= 0;
					sheetObjects[0].CellValue2(iRow, "edi_qty" )					= 0;
					sheetObjects[0].CellValue2(iRow, "remaining_qty" )			= arr_moreQty[i];
					sheetObjects[0].CellValue2(iRow, "needed_qty" )				= arr_moreQty[i];
					sheetObjects[0].CellValue2(iRow, "fm_nod_cd" )				= sheetObjects[0].CellValue(rRow, "fm_nod_cd");
					sheetObjects[0].CellValue2(iRow, "to_nod_cd" )				= sheetObjects[0].CellValue(rRow, "to_nod_cd");
					sheetObjects[0].CellValue2(iRow, "trsp_cost_dtl_mod_cd" )		= sheetObjects[0].CellValue(rRow, "trsp_cost_dtl_mod_cd");
					sheetObjects[0].CellValue2(iRow, "curr_dt" )					= sheetObjects[0].CellValue(rRow, "curr_dt");

					sheetObjects[0].CellValue2(rRow, "needed_qty" )				= sheetObjects[0].CellValue(rRow, "remaining_qty");

				}
			}
		}

	}

}

function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		if( document.form.f_cmd.value == SEARCH14 ) {
			sheetObjects[1].CellValue2(doc_row, "eq_no") = "";
			sheetObjects[1].RowStatus(doc_row) = "R";
			sheetObjects[1].CellValue2(doc_row, "chk1") = "0";
			sheetObjects[1].RowBackColor(doc_row) = sheetObjects[1].RgbColor(R,G,B);
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		var bchk = false;
		if( document.form.f_cmd.value == SEARCH14 ) {
			var doc_cntr_no = sheetObjects[2].CellValue(1, "eq_no");
			for( var ir = 1; ir < sheetObjects[1].RowCount+1; ir++ ) {
				if( doc_cntr_no == sheetObjects[1].CellValue(ir, "eq_no") && (ir != doc_row) ) {
					bchk = true;
					break;
				}
			}
			if( bchk ) {
				sheetObjects[1].RowStatus(doc_row) = "R";
				sheetObjects[1].CellValue2(doc_row, "chk1") = "0";
				sheetObjects[1].RowBackColor(doc_row) = sheetObjects[1].RgbColor(R,G,B);
				sheetObjects[1].CellValue2(doc_row, "eq_no") = "";
				sheetObjects[1].CellValue2(doc_row, "lessor") = "";
				sheetObjects[1].CellValue2(doc_row, "lstm_cd") = "";
				sheetObjects[1].CellValue2(doc_row, "ownr_co_cd") = "";
				sheetObjects[1].CellValue2(doc_row, "eq_used") = "";
				sheetObjects[1].CellValue2(doc_row, "movement_sts") = "";
				sheetObjects[1].CellValue2(doc_row, "creation_yard") = "";
				sheetObjects[1].CellValue2(doc_row, "event_date") = "";
				errMsg = "The same Container No exits."; //ComGetMsg("TRS90103"); //--메세지 딴다..
				ComShowMessage(errMsg);
			} else {
				sheetObjects[1].CellValue2(doc_row, "eq_no") = sheetObjects[2].CellValue(1, "eq_no");
				sheetObjects[1].CellValue2(doc_row, "lessor") = sheetObjects[2].CellValue(1, "lessor");
				sheetObjects[1].CellValue2(doc_row, "lstm_cd") = sheetObjects[2].CellValue(1, "lstm_cd");
				sheetObjects[1].CellValue2(doc_row, "ownr_co_cd") = sheetObjects[2].CellValue(1, "ownr_co_cd");
				sheetObjects[1].CellValue2(doc_row, "eq_used") = sheetObjects[2].CellValue(1, "eq_used");
				sheetObjects[1].CellValue2(doc_row, "movement_sts") = sheetObjects[2].CellValue(1, "movement_sts");
				sheetObjects[1].CellValue2(doc_row, "creation_yard") = sheetObjects[2].CellValue(1, "creation_yard");
				sheetObjects[1].CellValue2(doc_row, "event_date") = sheetObjects[2].CellValue(1, "event_date");
			}
			sheetObjects[2].RemoveAll();
			document.form.hid_cntr_no.value = "";
			doc_row = 0;
		} else {
			doSearchVerify(sheetObjects[1], sheetObjects[2]);
		}
	}
}

/*
 * Verify 조회한 결과에 대한 S/O Creation 항목 선택
 */
function doSearchVerify(sheetObj1, sheetObj2) {
	var sRow = sheetObj1.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fromRow = 0;
	var verifyCount = 0;
	
	for( var i=0; i<arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		var lvEa_no = sheetObj1.CellValue(fromRow, "eq_no");
		sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";
		
		for( var z=1; z<(sheetObj2.RowCount+1); z++ ) {
			if( lvEa_no == sheetObj2.CellValue(z, "eq_no") ) {
				sheetObj1.CellValue2(fromRow, "verify_result") = sheetObj2.CellValue(z, "verify_result");
				if( sheetObj2.CellValue(z, "verify_yn") == "N" ) { //S/O Creation 가능
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "Y";
				} else {
					sheetObj1.CellValue2(fromRow, "so_cre_yn") = "";
					sheetObj1.RowStatus(fromRow) = "R";
					sheetObj1.CellValue2(fromRow, "chk1") = "0";
					sheetObj1.RowBackColor(fromRow) = sheetObj1.RgbColor(R,G,B);
				}
				sheetObj2.RowDelete(z, false);
				break;
			}
		}
		
		if( sheetObj1.CellValue(fromRow, "verify_result") == "" ) { //지연요청(이용태)
			sheetObj1.CellValue2(fromRow, "verify_result") = "OK";
		}
		
		if(sheetObj1.CellValue(fromRow, "verify_result") != "OK"){
			verifyCount = verifyCount + 1;
		}
	}
	
	if(verifyCount < 1){
		errMsg = ComGetMsg("TRS90375");
		ComShowMessage(errMsg);	
	}
}

/**
 * 화면을 줄였다가 늘렸다가 된다.
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(20);
	} else {
		objs.style.display = "inline";
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
	}
}

function validateFormSearch(formObj) {
	var lvFrmDate = ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate = ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");

	var lvFrm_node = ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node = ComTrimAll(formObj.to_node.value, " ");
	
	var lvRef_no = ComTrimAll(formObj.refer_no.value, " ");
	var lvCntr_no = ComTrimAll(formObj.cntr_no.value, " ");

	if( lvFrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvRef_no == "" ) //BKG No
		formObj.refer_no.value = "";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value = "";

	if( lvFrmDate == "" && lvToDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //날짜 체크하는 부분
		if( !ComIsDate(lvFrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 14 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvRef_no == "" && lvCntr_no == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}

	if( lvFrm_node == "" ) { //From Node
		formObj.frm_node.value = "";
		formObj.frm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value = "";
		formObj.to_yard.RemoveAll(); // combo 데이터삭제
	}

	if( !ComIsAlphabet(ComTrimAll(lvRef_no, ","), "n") && lvRef_no != "" ) {
		formObj.refer_no.value = "";
		formObj.refer_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value = lvFrmDate; //from Date
	formObj.hid_todate.value = lvToDate; //to Date

	formObj.frm_node.value = lvFrm_node.toUpperCase();
	formObj.to_node.value = lvTo_node.toUpperCase();

	formObj.refer_no.value = lvRef_no.toUpperCase(); //BKG No.
	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	return true;
}

/*
 * IRG Adjuct Pop up을 호출한다.
 */
function doActionPopupOpen(sheetObj, formObject) {
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
	} else {
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var i=0; i<arrRow.length-1; i++ ) {
			if( sheetObj.CellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
				sheetObj.RowStatus(arrRow[i]) = "R";
				sheetObj.CellValue2(arrRow[i], "chk1") = "0";
				sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
			}
		}
		if( sheetObj.RowCount("I") < 1 ) {
			errMsg = ComGetMsg("TRS90148");
			ComShowMessage(errMsg);
		} else {
			var pop_width = 1000;
			var pop_leftloc= window.screenLeft;
			var pop_toploc = window.screenTop-400;
//			ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'top='+pop_toploc +', left='+pop_leftloc+',width='+ pop_width +' , height=475, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0', true);
            ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:1000px;dialogHeight:510px', true);
				
		}
	}
}

/*
 * IBSheet에서 Pop-Up창 띄우기
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	if ( sheetObj.ColSaveName(col) == "p1" ) {
		ComShowCodeMessage('TRS90334')+ row;
	}
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = ComTrimAll(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
	getYardCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
	document.frm_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	getYardCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
	document.to_yard.CODE = lvYard;
}

/**
 * 공통 Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value = reObj;
	} else if( obj == "REF" ) {
		formObject.refer_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value = multiCntrChkDgt(reObj);

	} else {

		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/**
 * 공통 Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_VVD_1";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

function getCOM_ENS_VVD_1(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.trunk_vvd.value = colArray[7] + gubun;
}

/*
 * 멀티 달력 입력 Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value = "";
	}else{
		document.form.to_plandate.value = ComGetDateAdd(obj.value, "D", 14);		
	}
}


//Add Row
function addOneRow(sheetObj)
{
	var Row = sheetObj.DataInsert(-1);
	sheetObj.CellEditable(Row, "so_rqst_dt") 	= true;
	sheetObj.CellEditable(Row, "eq_tpsz_cd") 	= true;
	sheetObj.CellEditable(Row, "allocated") 	= true;
	sheetObj.CellEditable(Row, "vsl_lane_cd") 	= true;
	sheetObj.CellEditable(Row, "vvd_cd") 		= true;
	sheetObj.CellEditable(Row, "fm_loc_cd") 	= true;
	sheetObj.CellEditable(Row, "fm_nod_cd") 	= true;
	sheetObj.CellEditable(Row, "fm_dt") 		= true;
	sheetObj.CellEditable(Row, "to_loc_cd") 	= true;
	sheetObj.CellEditable(Row, "to_nod_cd") 	= true;
	sheetObj.CellEditable(Row, "to_dt") 		= true;	
	sheetObj.CellEditable(Row, "slan_cd") 		= true;
	sheetObj.CellEditable(Row, "vvd_cd") 		= true;
	sheetObj.CellEditable(Row, "repo_purp_rmk") = true;
}

/*
 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
 * DELETE Logic 추가
 * 2013.11.27 by SHIN DONG IL
 */
function deleteCheckedRow(sheetObj){
	var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return;
	}

	// 1.S/O,W/O 발행 건수 체크
	for (var i = 0; i < checkArray.length-1; i++) {
		//S/O가 생성된 건이 존재 할 경우 Delete 불가

		if( sheetObj.CellValue(checkArray[i], "ref_id") != "" && sheetObj.CellValue(checkArray[i], "cret_qty") > 0){
			ComShowCodeMessage("TRS90528","S/O");
			return;
		}
		
		//W/O가 생성된 건이 존재 할 경우 Delete 불가
		if( sheetObj.CellValue(checkArray[i], "ref_id") != "" && sheetObj.CellValue(checkArray[i], "edi_qty") > 0){
			ComShowCodeMessage("TRS90528","EDI");
			return;
		}		
	}
	// 2.체크된 건 중에 신규 Row Add한 건을 삭제
	for(var k = checkArray.length-2; k >= 0; k--){
		if( sheetObj.CellValue(checkArray[k], "ref_id") == "" ) {
			sheetObj.RowDelete(checkArray[k], false);
		}
	}
	
	// 3.체크된 건 중에 신규 Row Add한 건을 삭제 후 남은 체크된 건 삭제.
	if(sheetObj.CheckedRows('chk1') > 0){
		formObj.f_cmd.value = REMOVE01;
		sheetObj.DoSave("ESD_TRS_0012GS.do",FormQueryString(formObj)); 
	}
}

/**
 * Save시 Validation
 */
function validateSave() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var rtnVal = true;
	var add_row_cnt = 0;
	
	//조회된 데이터가 없을 경우
	if(sheetObj.RowCount == 0){
		ComShowMessage("TRS90390");
		rtnVal = false;
	}
	
	//Add Row한 데이터 Validation Check
	for(var i=0 ;i<sheetObj.RowCount ; i++ ){

		if(sheetObj.RowStatus(i+2)=="I"){ //Add Row일 경우만 체크
		
			add_row_cnt++;//Add Row된 수
			
			if(sheetObj.CellValue(i+2,"so_rqst_dt")==""){ // Requested Date
				ComShowCodeMessage("COM12114","Requested Date");
				sheetObj.SelectCell(i+2,"so_rqst_dt");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"allocated") <= 0){// allocated
				ComShowCodeMessage("COM12114","allocated");
				sheetObj.SelectCell(i+2,"allocated");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_loc_cd")==""){// From Location code
				ComShowCodeMessage("COM12114","From Loc");
				sheetObj.SelectCell(i+2,"fm_loc_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_nod_cd")==""){// From node code
				ComShowCodeMessage("COM12114","From Node");
				sheetObj.SelectCell(i+2,"fm_nod_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"fm_dt")==""){// From ETD
				ComShowCodeMessage("COM12114","ETD");
				sheetObj.SelectCell(i+2,"fm_dt");
				rtnVal = false;				
			}else if(sheetObj.CellValue(i+2,"to_loc_cd")==""){//To Location code
				ComShowCodeMessage("COM12114","To Loc");
				sheetObj.SelectCell(i+2,"to_loc_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"to_nod_cd")==""){//To Node code
				ComShowCodeMessage("COM12114","To Node");
				sheetObj.SelectCell(i+2,"to_nod_cd");
				rtnVal = false;				
			}else if(sheetObj.CellValue(i+2,"to_dt")==""){//To ETA
				ComShowCodeMessage("COM12114","ETA");
				sheetObj.SelectCell(i+2,"to_dt");
				rtnVal = false;	
			}else if(sheetObj.CellValue(i+2,"slan_cd")!="" && (sheetObj.CellValue(i+2,"slan_cd")).length != 3){
				ComShowCodeMessage("COM12114","Lane");
				sheetObj.CellValue2(i+2,"slan_cd")="";
				sheetObj.SelectCell(i+2,"slan_cd");
				rtnVal = false;
			}else if(sheetObj.CellValue(i+2,"vvd_cd")!="" && (sheetObj.CellValue(i+2,"vvd_cd")).length != 9){
				ComShowCodeMessage("COM12114","VVD");
				sheetObj.CellValue2(i+2,"vvd_cd")="";
				sheetObj.SelectCell(i+2,"vvd_cd");
				rtnVal = false; 
			}else if(sheetObj.CellValue(i+2,"fm_loc_cd")+sheetObj.CellValue(i+2,"fm_nod_cd") == sheetObj.CellValue(i+2,"to_loc_cd")+sheetObj.CellValue(i+2,"to_nod_cd")){
				ComShowCodeMessage("TRS90053");
				sheetObj.CellValue(i+2,"to_loc_cd") = "";
				sheetObj.CellValue(i+2,"to_nod_cd") = "";
				rtnVal = false;
			}else if(ComGetDaysBetween(sheetObj.CellValue(i+2, "so_rqst_dt"), sheetObj.CellValue(i+2, "fm_dt")) < 0) {
				ComShowCodeMessage("COM12133","From date","greater","or equal to the the requested date");
				sheetObj.CellValue(i+2,"fm_dt") = "";
				rtnVal = false;
			}else if(ComGetDaysBetween(sheetObj.CellValue(i+2, "fm_dt"), sheetObj.CellValue(i+2, "to_dt")) < 0) {
				ComShowCodeMessage("COM12133","To date","greater","or equal to the the from date");
				sheetObj.CellValue(i+2,"to_dt") = "";
				rtnVal = false;
			}			
		}
	}

	// Add  Row가 없을 경우
	if(add_row_cnt == 0){
		ComShowCodeMessage("TRS90381");
		rtnVal = false;		
	}
	
	return rtnVal;
}

/**
 * Grid Change Event
 */
function sheet1_OnChange(sheetObj,row, col, Value){
	var form = document.form;

	if( sheetObj.ColSaveName(col) == "fm_loc_cd" ) {
		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_loc_cd"), " ");
		sheetObj.CellValue2(row, "fm_loc_cd") = lvfm;

		if( lvfm.length == 5 ) {
			if( sheetObj.CellValue(row, "fm_loc_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "fm_nod_cd", lvfm);
			} else {
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";					
			}
		} else {
			if( lvfm.length == 0 ) {
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"fm_loc_cd") = "";
				sheetObj.SelectCell(row,"fm_loc_cd");
				sheetObj.CellComboItem(row, "fm_nod_cd", "", "");
				sheetObj.CellValue2(row, "fm_nod_cd") = "";
			}
		}
	} else if( sheetObj.ColSaveName(col) == "to_loc_cd" ) {
		var lvto = doSepRemove(sheetObj.CellValue(row,"to_loc_cd"), " ");
		sheetObj.CellValue(row,"to_loc_cd") = lvto;

		if( lvto.length == 5 ) {
			if( sheetObj.CellValue(row, "to_loc_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "to_nod_cd", lvto);
			} else {
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			}
		} else {
			if( lvto.length == 0 ) {
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"to_loc_cd") = "";
				sheetObj.SelectCell(row,"to_loc_cd");
				sheetObj.CellComboItem(row, "to_nod_cd", "", "");
				sheetObj.CellValue2(row, "to_nod_cd") = "";
			}
		}
		
	} 

}

/**
 * Grid OnClick Event
 * 
 * @param {Object} sheetObj
 * @param {Object} row
 * @param {Object} col
 * @param {Object} value
 */
function sheet1_OnClick(sheetObj, row , col , value) {
	
	if(sheetObj.RowStatus(row)=="I"){//Add된 Row일 경우만
		if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
			value = doSepRemove(sheetObj.CellValue(row, "fm_loc_cd"), " ");
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "fm_loc_cd") = "";
			}
		} else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
			value = doSepRemove(sheetObj.CellValue(row, "to_loc_cd"), " ");
			if( value.length > 0 ) {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
			} else {
				sheetObj.CellValue2(row, "to_loc_cd") = "";
			}
		}
	}
}

/**
 * 저장후 메세지 표현
 */
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if (errMsg == "") {
		if (formObj.f_cmd.value == "183") { //MULTI03  : Save Button Event
			formObj.refer_no.value = sheetObj.EtcData("ref_id");
			sheetObj.RemoveEtcData();
			ComShowCodeMessage("TRS90511");
			doActionIBSheet(sheetObj, formObj, IBSEARCH, "","");
		}else if (formObj.f_cmd.value == "161") {//REMOVE01 : Delete Button Event 
			ComShowCodeMessage("TRS90331");
			doActionIBSheet(sheetObj, formObj, IBSEARCH, "","");
			sheetObjects[1].RemoveAll();
		}
	}
}