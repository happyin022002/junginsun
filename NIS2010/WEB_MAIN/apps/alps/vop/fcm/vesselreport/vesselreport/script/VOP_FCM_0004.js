/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0004.js
*@FileTitle : Departure Report Item Error Cleansing (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
*
* History
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: 
 ***************************************************************************************/

/**
 * @extends
 * @class VOP_FCM_0004 : VOP_FCM_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0004() {
//	this.setTabObject = setTabObject;

	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
//	this.initCombo 			= initCombo;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.validateForm 		= validateForm;
}

//// 공통전역변수
//var ipageNo = 1;
//
var sheetObjects = new Array();
var sheetCnt = 0;
var dateVal = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Simulation":
			doActionIBSheet(sheetObject, formObject, SEARCH01);
			break;

		case "btn_Close":
			self.close();
			break;

		case "btn_Save":
			doSave(sheetObject, formObject);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	sheetObjects[0].SelectCell(1, 1);
	sheetObjects[1].SelectCell(1, 1);
	sheetObjects[2].SelectCell(1, 1);
}

function initControl() {
	var formObject = document.form;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
//	var prefix = "";
//	sheetObj.prefix = prefix;

	switch (sheetNo) {
	case 1: // IBSheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 200;
//			style.height = 250; // Hidden Haed 노출시 늘려주기 (Local 환경에서만 사용)
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 고정행 일 경우 Count 표시 X
			sheetObj.CountPosition = 0;
			
			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msNone;
			MergeSheet = msHeaderOnly

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(4, 5, 5, 100);
			
			var HeadTitle1 = "CLASSIFI CATION|INFORMATION|INFORMATION|INFORMATION|INFORMATION|INFORMATION|INFORMATION|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|FUEL CONSUM.|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|R.O.B(Sup)|DESTINATION|DESTINATION|DESTINATION|DESTINATION|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|CONDITION|CONDITION|CONDITION|CONDITION|CONDITION|CONDITION|CONDITION|CONDITION|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO";
			var HeadTitle2 = "CLASSIFI CATION|Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Sea Steaming|Harbor/In Port|AVG. HarborInport FOC/HR|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG ①\n(ETA-①)|P.O.B ②\n(②-①)|ANCHOR ③\n(③-①)|ANCHOR AWAY ④\n(④-③)|FIRST LINE ⑤\n(ETB-⑤)|COMM'CED WKG ⑥\n(⑥-⑤)|COMP'TED WKG ⑦\n(⑦-⑥)|LAST LINE ⑧\n(ETD-⑧)|DROP ANCHOR ⑨\n(⑨-⑧)|ANCHOR AWAY ⑩\n(⑩-⑨)|PILOT AWAY ⑪\n(⑪-⑧)|R/UP ENG ⑫\n(⑫-⑪)|R/UP ENG\n(Last Port)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Dep)|Draft(Dep)|Draft(Dep)|Draft(Dep)|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|R/F CNTR|R/F CNTR|R/F CNTR|R/F CNTR";
			var HeadTitle3 = "CLASSIFI CATION|Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|M/E| TTL |TTL|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|F.O BDR|F.O Actual|F.O Sulfur|LS F.O BDR|LS F.O Actual|LS F.O Sulfur|D.O BDR|D.O Actual|D.O Sulfur|LS D.O BDR|LS D.O Actual|LS D.O Sulfur|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG ①\n(ETA-①)|P.O.B ②\n(②-①)|ANCHOR ③\n(③-①)|ANCHOR AWAY ④\n(④-③)|FIRST LINE ⑤\n(ETB-⑤)|COMM'CED WKG ⑥\n(⑥-⑤)|COMP'TED WKG ⑦\n(⑦-⑥)|LAST LINE ⑧\n(ETD-⑧)|DROP ANCHOR ⑨\n(⑨-⑧)|ANCHOR AWAY ⑩\n(⑩-⑨)|PILOT AWAY ⑪\n(⑪-⑧)|R/UP ENG ⑫\n(⑫-⑪)|R/UP ENG\n(Last Port)|FWD|MID|AFT|GM|FWD|MID|AFT|GM|Full|Em'ty|Total|Cargo Weight|Displacement|Disch.|Load|On Board|On Board(Last Port)";
			var HeadTitle4 = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100";
			
			var HeadHidTitle = "|ERR_ITM_CTNT|RCV_DT|RCV_SEQ|DEP_RPT_ERR_TP_CD";
			
			// dtHidden 갯수만큼 설정
			HeadTitle1 = HeadTitle1 + HeadHidTitle;
			HeadTitle2 = HeadTitle2 + HeadHidTitle;
			HeadTitle3 = HeadTitle3 + HeadHidTitle;
			HeadTitle4 = HeadTitle4 + HeadHidTitle;
			
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 7, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SORT=true],[ColumnMove=false], [AllCheck=true], [UserResize=true], [RowMove=false] , [Head3D=true]
			InitHeadMode(false, false, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);
			InitHeadRow(3, HeadTitle4, true, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			for(var i=0;i < 5; i++){
				InitDataProperty(i, 0, dtData,	110,	daCenter,	true,	"left_head",					false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 1, dtData,	70,		daCenter,	true,	"cntr_dzn_capa",				false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 2, dtData,	50,		daCenter,	true,	"vsl_cd",						false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 3, dtData,	50,		daCenter,	true,	"skd_voy_no",					false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 4, dtData,	50,		daCenter,	true,	"vsl_slan_cd",					false, "",	dfNone,			0,	true,	true, 3);
				InitDataProperty(i, 5, dtData,	60,		daCenter,	true,	"lst_dep_port_cd",				false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 6, dtData,	60,		daCenter,	true,	"dep_port_cd",					false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 7, dtData,	65,		daRight,	true,	"nvgt_ml_dist_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 8, dtData,	65,		daRight,	true,	"eng_ml_dist_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 9, dtData,	65,		daRight,	true,	"mnvr_in_ml_dist_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 10, dtData,	65,		daRight,	true,	"mnvr_out_ml_dist_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 11, dtData,	60,		daRight,	true,	"avg_spd_ctnt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 12, dtData,	60,		daRight,	true,	"avg_rpm_pwr_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 13, dtData,	70,		daRight,	true,	"avg_prlr_pch_val",				false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 14, dtData,	60,		daRight,	true,	"sail_tm_hrs",					false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 15, dtData,	50,		daRight,	false,	"arr_foil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 16, dtData,	50,		daRight,	false,	"arr_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 17, dtData,	50,		daRight,	false,	"arr_doil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 18, dtData,	50,		daRight,	false,	"arr_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 19, dtData,	50,		daRight,	false,	"dep_foil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 20, dtData,	50,		daRight,	false,	"dep_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 21, dtData,	50,		daRight,	false,	"dep_doil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 22, dtData,	60,		daRight,	false,	"dep_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 23, dtData,	60,		daRight,	false,	"lst_dep_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 24, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 25, dtData,	69,		daRight,	false,	"lst_dep_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 26, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 27, dtData,	90,		daRight,	false,	"sea_stmng_mn_eng_ttl_qty",		false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 28, dtData,	100,	daRight,	false,	"avg_port_ttl_qty",				false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 29, dtData,	160,	daRight,	false,	"avg_port_ttl_hr_qty",			false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 30, dtData,	50,		daRight,	false,	"sea_mn_foil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 31, dtData,	50,		daRight,	false,	"sea_gnr_foil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 32, dtData,	50,		daRight,	false,	"sea_blr_foil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 33, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 34, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 35, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 36, dtData,	50,		daRight,	false,	"sea_mn_doil_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 37, dtData,	50,		daRight,	false,	"sea_gnr_doil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 38, dtData,	50,		daRight,	false,	"sea_blr_doil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 39, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 40, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 41, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 42, dtData,	50,		daRight,	false,	"port_mn_foil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 43, dtData,	50,		daRight,	false,	"port_gnr_foil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 44, dtData,	50,		daRight,	false,	"port_blr_foil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 45, dtData,	50,		daRight,	false,	"port_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 46, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 47, dtData,	50,		daRight,	false,	"port_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 48, dtData,	50,		daRight,	false,	"port_mn_doil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 49, dtData,	50,		daRight,	false,	"port_gnr_doil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 50, dtData,	50,		daRight,	false,	"port_blr_doil_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 51, dtData,	50,		daRight,	false,	"port_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 52, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 53, dtData,	50,		daRight,	false,	"port_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 54, dtData,	70,		daCenter,	false,	"spl_foil_bdr_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 55, dtData,	70,		daCenter,	false,	"spl_foil_act_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 56, dtData,	70,		daCenter,	false,	"spl_foil_sulp_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 57, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_bdr_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 58, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_act_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 59, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_sulp_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 60, dtData,	70,		daCenter,	false,	"spl_doil_bdr_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 61, dtData,	70,		daCenter,	false,	"spl_doil_act_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 62, dtData,	70,		daCenter,	false,	"spl_doil_sulp_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 63, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_bdr_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 64, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_act_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 65, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_sulp_ctnt",	false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 66, dtData,	65,		daLeft,		true,	"nxt_port_cd",					false, "",	dfNone,			0,	true,	true, 5);
				InitDataProperty(i, 67, dtData,	100,	daRight,	true,	"nxt_port_eta_dt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 68, dtData,	65,		daRight,	true,	"rmn_dist_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 69, dtData,	65,		daRight,	true,	"rmn_avg_spd_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 70, dtData,	105,	daRight,	true,	"sb_eng_dt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 71, dtData,	105,	daRight,	true,	"plt_in_dt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 72, dtData,	105,	daRight,	true,	"bfr_brth_ank_drp_dt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 73, dtData,	110,	daRight,	true,	"bfr_brth_ank_off_dt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 74, dtData,	105,	daRight,	true,	"vps_etb_dt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 75, dtData,	110,	daRight,	true,	"cgo_wrk_st_dt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 76, dtData,	110,	daRight,	true,	"cgo_wrk_end_dt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 77, dtData,	105,	daRight,	true,	"vps_etd_dt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 78, dtData,	110,	daRight,	true,	"aft_unbrth_ank_drp_dt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 79, dtData,	110,	daRight,	true,	"aft_unbrth_ank_off_dt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 80, dtData,	100,	daRight,	true,	"plt_out_dt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 81, dtData,	100,	daRight,	true,	"rup_dt",						false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 82, dtData,	100,	daRight,	true,	"lst_port_rup_dt",				false, "",	dfNone,			0,	false,	false);
				InitDataProperty(i, 83, dtData,	40,		daRight,	false,	"arr_fwddr_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 84, dtData,	40,		daRight,	false,	"arr_mid_drft_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 85, dtData,	40,		daRight,	false,	"arr_aftdr_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 86, dtData,	40,		daRight,	false,	"arr_gm_ctnt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 87, dtData,	40,		daRight,	false,	"dep_fwddr_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 88, dtData,	40,		daRight,	false,	"dep_mid_drft_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 89, dtData,	40,		daRight,	false,	"dep_aftdr_ctnt",				false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 90, dtData,	40,		daRight,	false,	"dep_gm_ctnt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 91, dtData,	50,		daRight,	false,	"fcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 92, dtData,	50,		daRight,	false,	"mcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 93, dtData,	50,		daRight,	false,	"ttl_cntr_obrd_teu_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 94, dtData,	90,		daRight,	false,	"dep_cgo_ctnt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 95, dtData,	90,		daRight,	false,	"dep_dpl_ctnt",					false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 96, dtData,	60,		daRight,	false,	"rf_cntr_dchg_knt_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 97, dtData,	60,		daRight,	false,	"rf_cntr_lod_knt_ctnt",			false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 98, dtData,	70,		daRight,	false,	"rf_cntr_obrd_knt_ctnt",		false, "",	dfNone,			0,	true,	true);
				InitDataProperty(i, 99, dtData,	70,		daRight,	false,	"lst_rf_cntr_obrd_knt_ctnt",	false, "",	dfNone,			0,	false,	false);
				if(i == 0){
					InitDataProperty(i, 100 , dtHidden,	1, daCenter,   false,  "err_itm_ctnt");
					InitDataProperty(i, 101 , dtHidden,	1, daCenter,   false,  "rcv_dt");
					InitDataProperty(i, 102 , dtHidden,	1, daCenter,   false,  "rcv_seq");
					InitDataProperty(i, 103 , dtHidden,	1, daCenter,   false,  "dep_rpt_err_tp_cd");
				}else{
					InitDataProperty(i, 100 , dtHidden);
					InitDataProperty(i, 101 , dtHidden);
					InitDataProperty(i, 102 , dtHidden);
					InitDataProperty(i, 103 , dtHidden);
				}

			}
			
			InitDataValid(0, "vsl_slan_cd",					vtEngUpOther,	"0123456789");
			InitDataValid(0, "nvgt_ml_dist_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "eng_ml_dist_ctnt"	,			vtNumericOther, "-.");
			InitDataValid(0, "mnvr_in_ml_dist_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "mnvr_out_ml_dist_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "avg_spd_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "avg_rpm_pwr_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "arr_foil_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "arr_low_sulp_foil_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "arr_doil_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "arr_low_sulp_doil_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "dep_foil_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "dep_low_sulp_foil_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "dep_doil_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "dep_low_sulp_doil_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "sea_mn_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_gnr_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_blr_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_mn_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "sea_gnr_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "sea_blr_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "sea_mn_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_gnr_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_blr_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "sea_mn_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "sea_gnr_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "sea_blr_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_mn_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_gnr_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_blr_foil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_mn_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_gnr_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_blr_low_sulp_foil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_mn_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_gnr_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_blr_doil_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "port_mn_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_gnr_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "port_blr_low_sulp_doil_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_foil_bdr_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_foil_act_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_foil_sulp_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_foil_bdr_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_foil_act_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_foil_sulp_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_doil_bdr_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_doil_act_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_doil_sulp_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_doil_bdr_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_doil_act_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "spl_low_sulp_doil_sulp_ctnt",	vtNumericOther, "-.");
			InitDataValid(0, "nxt_port_cd",					vtEngUpOnly);
			InitDataValid(0, "rmn_dist_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "rmn_avg_spd_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "arr_fwddr_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "arr_mid_drft_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "arr_aftdr_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "arr_gm_ctnt",					vtNumericOther, "-.");
			InitDataValid(0, "dep_fwddr_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "dep_mid_drft_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "dep_aftdr_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "dep_gm_ctnt",					vtNumericOther, "-.");
			InitDataValid(0, "fcntr_obrd_teu_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "mcntr_obrd_teu_ctnt",			vtNumericOther, "-.");
			InitDataValid(0, "ttl_cntr_obrd_teu_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "dep_cgo_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "dep_dpl_ctnt",				vtNumericOther, "-.");
			InitDataValid(0, "rf_cntr_dchg_knt_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "rf_cntr_lod_knt_ctnt",		vtNumericOther, "-.");
			InitDataValid(0, "rf_cntr_obrd_knt_ctnt",		vtNumericOther, "-.");
			
		}
		break;
		
	case 2:
		with (sheetObj) {
			// 높이 설정
			style.height = 135;
//			style.height = 180; // Hidden Haed 노출시 늘려주기 (Local 환경에서만 사용)
			
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			sheetObj.HeadRowHeight = 20;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 고정행 일 경우 Count 표시 X
			sheetObj.CountPosition = 0;
			
			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msNone;
			MergeSheet = msHeaderOnly
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 0, 0, 100);
			
			var HeadTitle1 = "ERROR\nType|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Sea Steaming|Harbor/In Port|AVG. HarborInport FOC/HR|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG|R/UP ENG (Last Port)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Dep)|Draft(Dep)|Draft(Dep)|Draft(Dep)|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|R/F CNTR|R/F CNTR|R/F CNTR|";
			var HeadTitle2 = "ERROR\nType|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|M/E| TTL |TTL|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|F.O BDR|F.O Actual|F.O Sulfur|LS F.O BDR|LS F.O Actual|LS F.O Sulfur|D.O BDR|D.O Actual|D.O Sulfur|LS D.O BDR|LS D.O Actual|LS D.O Sulfur|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG|R/UP ENG (Last Port)|FWD|MID|AFT|GM|FWD|MID|AFT|GM|Full|Em'ty|Total|Cargo Weight|Displacement|Disch.|Load|On Board|";
			var HeadTitle3 = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|";
	
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 6, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SORT=true],[ColumnMove=false], [AllCheck=true], [UserResize=true], [RowMove=false] , [Head3D=true]
			InitHeadMode(false, false, false, true, false, false)
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	true,	"dep_rpt_err_tp_cd",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"vsl_cd",						false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"skd_voy_no",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"vsl_slan_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"lst_dep_port_cd",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"dep_port_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"nvgt_ml_dist_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"eng_ml_dist_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"mnvr_in_ml_dist_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"mnvr_out_ml_dist_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"avg_spd_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"avg_rpm_pwr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	true,	"avg_prlr_pch_val",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"sail_tm_hrs",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"dep_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	69,		daRight,	false,	"lst_dep_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"sea_stmng_mn_eng_ttl_qty",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	false,	"avg_port_ttl_qty",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	160,	daRight,	false,	"avg_port_ttl_hr_qty",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_bdr_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_act_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_sulp_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_bdr_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_act_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_sulp_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_bdr_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_act_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_sulp_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_bdr_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_act_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_sulp_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daLeft,		true,	"nxt_port_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"nxt_port_eta_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"rmn_dist_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"rmn_avg_spd_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"sb_eng_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"plt_in_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"bfr_brth_ank_drp_dt",			false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"bfr_brth_ank_off_dt",			false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"vps_etb_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"cgo_wrk_st_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"cgo_wrk_end_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"vps_etd_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"aft_unbrth_ank_drp_dt",		false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"aft_unbrth_ank_off_dt",		false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"plt_out_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"rup_dt",						false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"lst_port_rup_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_fwddr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_mid_drft_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_aftdr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_gm_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_fwddr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_mid_drft_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_aftdr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_gm_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"fcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"mcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"ttl_cntr_obrd_teu_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"dep_cgo_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"dep_dpl_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"rf_cntr_dchg_knt_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"rf_cntr_lod_knt_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	false,	"rf_cntr_obrd_knt_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	false,	"right_tab",					false, "",	dfNone,			0,	false,	false);
			
			//Left head
			//InitHeadColumn(0, "qwer|qwer|qwer");
			InitUserFormat2(0, "nxt_port_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "sb_eng_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "plt_in_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "bfr_brth_ank_drp_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "bfr_brth_ank_off_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "vps_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "cgo_wrk_st_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "cgo_wrk_end_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "aft_unbrth_ank_drp_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "aft_unbrth_ank_off_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "plt_out_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "rup_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "lst_port_rup_dt", "####-##-## ##:##", "-|:" );
		}
		break;
		
	case 3:
		with (sheetObj) {
			// 높이 설정
			style.height = 135;
//			style.height = 180; // Hidden Haed 노출시 늘려주기 (Local 환경에서만 사용)

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			sheetObj.HeadRowHeight = 20;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 고정행 일 경우 Count 표시 X
			sheetObj.CountPosition = 0;
			
			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msNone;
			MergeSheet = msHeaderOnly
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 0, 0, 100);
			
			var HeadTitle1 = "Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Rob(Dep)-Last port|Sea Steaming|Harbor/In Port|AVG. HarborInport FOC/HR|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming LS F.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Sea Steaming LS D.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port LS F.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Harbor/In Port LS D.O|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Rob(Sup)|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG|R/UP ENG (Last Port)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Arr)|Draft(Dep)|Draft(Dep)|Draft(Dep)|Draft(Dep)|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|R/F CNTR|R/F CNTR|R/F CNTR|";
			var HeadTitle2 = "Class|Vessel|Voy No.|Lane|Last Port|Dep Port|Miles Obs|Miles Eng|Miles In|Miles Out|SPD|RPM|AVG.\nPro.Pitch|Sailing\nTime|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|M/E| TTL |TTL|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|M/E|G/E|BLR|F.O BDR|F.O Actual|F.O Sulfur|LS F.O BDR|LS F.O Actual|LS F.O Sulfur|D.O BDR|D.O Actual|D.O Sulfur|LS D.O BDR|LS D.O Actual|LS D.O Sulfur|Next Port|ETA|Togo Mile|Togo Spd|S/B ENG|P.O.B|ANCHOR|ANCHOR AWAY|FIRST LINE|COMM'CED WKG|COMP'TED WKG|LAST LINE|DROP ANCHOR|ANCHOR AWAY|PILOT AWAY|R/UP ENG|R/UP ENG (Last Port)|FWD|MID|AFT|GM|FWD|MID|AFT|GM|Full|Em'ty|Total|Cargo Weight|Displacement|Disch.|Load|On Board|";
			var HeadTitle3 = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|";
	
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 6, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SORT=true],[ColumnMove=false], [AllCheck=true], [UserResize=true], [RowMove=false] , [Head3D=true]
			InitHeadMode(false, false, false, true, false, false)
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	true,	"cntr_dzn_capa",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"vsl_cd",						false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"skd_voy_no",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	true,	"vsl_slan_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"lst_dep_port_cd",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"dep_port_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"nvgt_ml_dist_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"eng_ml_dist_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"mnvr_in_ml_dist_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"mnvr_out_ml_dist_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"avg_spd_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"avg_rpm_pwr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	true,	"avg_prlr_pch_val",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	true,	"sail_tm_hrs",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"arr_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_low_sulp_foil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"dep_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"dep_low_sulp_doil_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	69,		daRight,	false,	"lst_dep_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"lst_dep_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"sea_stmng_mn_eng_ttl_qty",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	false,	"avg_port_ttl_qty",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	160,	daRight,	false,	"avg_port_ttl_hr_qty",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_foil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_doil_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"sea_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_foil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_low_sulp_foil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_doil_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_mn_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_gnr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"port_blr_low_sulp_doil_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_bdr_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_act_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_foil_sulp_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_bdr_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_act_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_foil_sulp_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_bdr_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_act_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_doil_sulp_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_bdr_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_act_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daCenter,	false,	"spl_low_sulp_doil_sulp_ctnt",	false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daLeft,		true,	"nxt_port_cd",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"nxt_port_eta_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"rmn_dist_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	65,		daRight,	true,	"rmn_avg_spd_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"sb_eng_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"plt_in_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"bfr_brth_ank_drp_dt",			false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"bfr_brth_ank_off_dt",			false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"vps_etb_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"cgo_wrk_st_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"cgo_wrk_end_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	105,	daRight,	true,	"vps_etd_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"aft_unbrth_ank_drp_dt",		false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"aft_unbrth_ank_off_dt",		false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"plt_out_dt",					false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"rup_dt",						false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	100,	daRight,	true,	"lst_port_rup_dt",				false, "",	dfUserFormat2,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_fwddr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_mid_drft_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_aftdr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"arr_gm_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_fwddr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_mid_drft_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_aftdr_ctnt",				false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	40,		daRight,	false,	"dep_gm_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"fcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"mcntr_obrd_teu_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daRight,	false,	"ttl_cntr_obrd_teu_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"dep_cgo_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	90,		daRight,	false,	"dep_dpl_ctnt",					false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"rf_cntr_dchg_knt_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	60,		daRight,	false,	"rf_cntr_lod_knt_ctnt",			false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	false,	"rf_cntr_obrd_knt_ctnt",		false, "",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	70,		daRight,	false,	"right_tab",					false, "",	dfNone,			0,	false,	false);
			
			//Left head
			//InitHeadColumn(0, "qwer|qwer|qwer");
			InitUserFormat2(0, "nxt_port_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "sb_eng_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "plt_in_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "bfr_brth_ank_drp_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "bfr_brth_ank_off_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "vps_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "cgo_wrk_st_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "cgo_wrk_end_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "aft_unbrth_ank_drp_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "aft_unbrth_ank_off_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "plt_out_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "rup_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "lst_port_rup_dt", "####-##-## ##:##", "-|:" );
		}
		break;
		
	case 4: // IBSheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 70;
//			style.height = 250; // Hidden Haed 노출시 늘려주기 (Local 환경에서만 사용)
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 고정행 일 경우 Count 표시 X
			sheetObj.CountPosition = 0;
			
			// 전체Merge 종류 [선택, Default msNone]
//			MergeSheet = msNone;
			MergeSheet = msHeaderOnly

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 0, 0, 100);
			
			var	HeadTitle1 = "ARR_BLR_FOIL_CSM_QTY|ARR_BLR_LOW_SULP_FOIL_CSM_QTY|ARR_BLST_WGT|ARR_DOIL_CSM_QTY|ARR_ENG_ML|ARR_FRSH_WTR_WGT|ARR_GNR_FOIL_CSM_QTY|ARR_GNR_LOW_SULP_FOIL_CSM_QTY|ARR_LAT|ARR_LON|ARR_LOW_SULP_DOIL_CSM_QTY|ARR_MN_FOIL_CSM_QTY|ARR_MN_LOW_SULP_FOIL_CSM_QTY|ARR_NVGT_ML|ARR_RPM_PWR|ARR_SAIL_HRS|AVG_EXPT_FLG|BLK_CGO_TP_CD1|BLK_CGO_TP_CD2|BLK_CGO_TP_CD3";
				HeadTitle1 = HeadTitle1 + "|BLK_CGO_TP_CD4|BLK_CGO_TP_CD5|BLK_DEP_CGO_TTL_WGT|BLK_HLD_LOAD_QTY1|BLK_HLD_LOAD_QTY2|BLK_HLD_LOAD_QTY3|BLK_HLD_LOAD_QTY4|BLK_HLD_LOAD_QTY5|BLK_HLD_LOAD_QTY6|BLK_HLD_LOAD_QTY7|BLK_HLD_LOAD_QTY8|BLK_HLD_LOAD_QTY9|BLK_LOD_DCHG_STS_CD|CAP_NM|CF_ENG_NM|DEP_ARR_PLT_MGN_HRS|DEP_ARR_PLT_MGN_MNTS|DEP_BLST_WGT|DEP_FRSH_WTR_WGT|DEP_LAT|DEP_LON|DEP_RMK";
				HeadTitle1 = HeadTitle1 + "|DEP_RPM_MAX_PWR|DEP_RPM_MIN_PWR|DEP_RPM_PWR|DEP_RPM_UUSD_FM|DEP_RPM_UUSD_TO|DEP_RSN_FOR_MGN_TM|DEP_STS_CD|DPL_SLG_SP|DPL_SLG_WGT|FO_SLG_WGT|FOIL_PURF_DCHG_ITVAL|GMT_TD_HRS|INCNR_SLG_WGT|NXT_AFTDR_HGT|NXT_BLST_WGT|NXT_DOIL_WGT|NXT_FOIL_WGT|NXT_FRSH_WTR_WGT|NXT_FWDDR_HGT|NXT_GM_HGT|NXT_LOW_SULP_DOIL_WGT|NXT_LOW_SULP_FOIL_WGT|NXT_MID_DRFT_HGT";
				HeadTitle1 = HeadTitle1 + "|PORT_DET_RSN_CD1|PORT_DET_RSN_CD2|PORT_DET_RSN_CD3|PORT_DET_RSN_HRS1|PORT_DET_RSN_HRS2|PORT_DET_RSN_HRS3|REF_NO|RMN_SDG_WGT|RUN_HRS_IN_HV_WE|SEA_DET_RSN_CD1|SEA_DET_RSN_CD2|SEA_DET_RSN_CD3|SEA_DET_RSN_HRS1|SEA_DET_RSN_HRS2|SEA_DET_RSN_HRS3|SEA_DNST|SPL_DOIL_BRG_WGT1|SPL_DOIL_BRG_WGT2|SPL_FOIL_BRG_WGT1|SPL_FOIL_BRG_WGT2|SPL_FRSH_WTR_ACT_WGT";
				HeadTitle1 = HeadTitle1 + "|SPL_LOW_SULP_DOIL_BRG_WGT1|SPL_LOW_SULP_DOIL_BRG_WGT2|SPL_LOW_SULP_FOIL_BRG_WGT1|SPL_LOW_SULP_FOIL_BRG_WGT2|TTL_SLG_WGT";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다 [SORT=true],[ColumnMove=false], [AllCheck=true], [UserResize=true], [RowMove=false] , [Head3D=true]
			InitHeadMode(false, false, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true, false);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_blr_foil_csm_qty",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_blr_low_sulp_foil_csm_qty",	false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_blst_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_doil_csm_qty",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_eng_ml",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_frsh_wtr_wgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_gnr_foil_csm_qty",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_gnr_low_sulp_foil_csm_qty",	false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_lat",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_lon",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_low_sulp_doil_csm_qty",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_mn_foil_csm_qty",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_mn_low_sulp_foil_csm_qty",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_nvgt_ml",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_rpm_pwr",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"arr_sail_hrs",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"avg_expt_flg",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_cgo_tp_cd1",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_cgo_tp_cd2",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_cgo_tp_cd3",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_cgo_tp_cd4",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_cgo_tp_cd5",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_dep_cgo_ttl_wgt",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty1",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty2",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty3",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty4",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty5",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty6",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty7",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty8",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_hld_load_qty9",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"blk_lod_dchg_sts_cd",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"cap_nm",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"cf_eng_nm",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_arr_plt_mgn_hrs",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_arr_plt_mgn_mnts",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_blst_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_frsh_wtr_wgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_lat",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_lon",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rmk",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rpm_max_pwr",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rpm_min_pwr",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rpm_pwr",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rpm_uusd_fm",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rpm_uusd_to",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_rsn_for_mgn_tm",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dep_sts_cd",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dpl_slg_sp",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"dpl_slg_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"fo_slg_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"foil_purf_dchg_itval",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"gmt_td_hrs",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"incnr_slg_wgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_aftdr_hgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_blst_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_doil_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_foil_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_frsh_wtr_wgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_fwddr_hgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_gm_hgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_low_sulp_doil_wgt",			false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_low_sulp_foil_wgt",			false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"nxt_mid_drft_hgt",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_cd1",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_cd2",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_cd3",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_hrs1",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_hrs2",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"port_det_rsn_hrs3",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"ref_no",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"rmn_sdg_wgt",						false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"run_hrs_in_hv_we",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_cd1",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_cd2",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_cd3",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_hrs1",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_hrs2",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_det_rsn_hrs3",					false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"sea_dnst",							false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_doil_brg_wgt1",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_doil_brg_wgt2",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_foil_brg_wgt1",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_foil_brg_wgt2",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_frsh_wtr_act_wgt",				false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_low_sulp_doil_brg_wgt1",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_low_sulp_doil_brg_wgt2",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_low_sulp_foil_brg_wgt1",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"spl_low_sulp_foil_brg_wgt2",		false, "",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++, dtData,	50,		daCenter,	false,	"ttl_slg_wgt",						false, "",	dfNone,	0,	false,	false);
		}
		break;
	}
}


function sheet1_OnSearchEnd(sheetObj){

	with(sheetObj){
		
		sheetObj.HeadRowHeight = 23;
		
		sheetObj.CellValue(HeaderRows + 0,"left_head") = "Dep.Report";
		sheetObj.CellValue(HeaderRows + 1,"left_head") = "Standard";
		sheetObj.CellValue(HeaderRows + 2,"left_head") = "DIFF.";
		sheetObj.CellValue(HeaderRows + 3,"left_head") = "Rate / Range";
		sheetObj.CellValue(HeaderRows + 4,"left_head") = "Error Setting";
		
		var idx = 0;
		for(var i=0; i <= 4; i++){
			idx = HeaderRows + i;
			if(i > 0){
				sheetObj.RowEditable(idx) = false;
			}
			sheetObj.CellFont("FontBold", idx, "left_head") = true;
			sheetObj.CellFontColor(idx, "left_head")	= sheetObj.RgbColor(39, 95, 101);
			sheetObj.CellBackColor(idx, "left_head")	= sheetObj.RgbColor(203,210,248);
			sheetObj.CellBackColor(idx, "dep_port_cd")	= sheetObj.RgbColor(195,195,195);
		}
		
		// Rate / Range 각 항목  기호 적용
		var saveNames = "nvgt_ml_dist_ctnt|eng_ml_dist_ctnt|mnvr_in_ml_dist_ctnt|mnvr_out_ml_dist_ctnt|avg_spd_ctnt|avg_rpm_pwr_ctnt";
		saveNames = saveNames + "|avg_prlr_pch_val|sail_tm_hrs|sea_stmng_mn_eng_ttl_qty|avg_port_ttl_qty|avg_port_ttl_hr_qty";
		saveNames = saveNames + "|fcntr_obrd_teu_qty_ctnt|mcntr_obrd_teu_qty_ctnt|ttl_cntr_obrd_teu_qty_ctnt|dep_cgo_wgt_ctnt";
		saveNames = saveNames + "|fcntr_obrd_teu_ctnt|mcntr_obrd_teu_ctnt|ttl_cntr_obrd_teu_ctnt|dep_cgo_ctnt";
		var saveNamesArray = saveNames.split("|");
		
		for(var i=0; i < saveNamesArray.length; i++){
			sheetObj.CellValue(HeaderRows + 3, saveNamesArray[i]) = applyExpression("", "per", sheetObj.CellValue(HeaderRows + 3, saveNamesArray[i]));
		}
		
		// Rate / Range 각 항목 '-'값 가운데 정렬
		for(var i=0; i <= sheetObj.LastCol; i++){
			if(sheetObj.CellValue(HeaderRows + 3, i) == "-"){
				sheetObj.CellAlign(HeaderRows + 3, i) = daCenter;
			}
		}
		
		// Error Setting 각 항목 기호 적용 
		saveNames = "nvgt_ml_dist_ctnt|eng_ml_dist_ctnt|mnvr_in_ml_dist_ctnt|mnvr_out_ml_dist_ctnt|avg_spd_ctnt|avg_rpm_pwr_ctnt";
		saveNames = saveNames + "|fcntr_obrd_teu_qty_ctnt|mcntr_obrd_teu_qty_ctnt|ttl_cntr_obrd_teu_qty_ctnt|dep_cgo_wgt_ctnt";
		saveNames = saveNames + "|avg_prlr_pch_val|sail_tm_hrs|sea_stmng_mn_eng_ttl_qty|avg_port_ttl_qty|avg_port_ttl_hr_qty";
		saveNames = saveNames + "|fcntr_obrd_teu_ctnt|mcntr_obrd_teu_ctnt|ttl_cntr_obrd_teu_ctnt|dep_cgo_ctnt";
		
		saveNamesArray = saveNames.split("|");
		
		for(var i=0; i < saveNamesArray.length; i++){
			sheetObj.CellValue(HeaderRows + 4, saveNamesArray[i]) = applyExpression("pm", "per", sheetObj.CellValue(HeaderRows + 4, saveNamesArray[i]));
		}
		
		saveNames = "arr_foil_ctnt|arr_low_sulp_foil_ctnt|arr_doil_ctnt|arr_low_sulp_doil_ctnt|dep_foil_ctnt|dep_low_sulp_foil_ctnt|dep_doil_ctnt|dep_low_sulp_doil_ctnt";
		saveNames = saveNames + "|sb_eng_dt|plt_in_dt|vps_etb_dt|vps_etd_dt|rf_cntr_dchg_knt_ctnt|rf_cntr_lod_knt_ctnt|rf_cntr_obrd_knt_ctnt";
		
		saveNamesArray = saveNames.split("|");
		
		for(var i=0; i < saveNamesArray.length; i++){
			sheetObj.CellValue(HeaderRows + 4, saveNamesArray[i]) = applyExpression("pm", "", sheetObj.CellValue(HeaderRows + 4, saveNamesArray[i]));
		}
		
		// ERROR ITEM 항목 BG 적용
		saveNames		= sheetObj.CellValue(HeaderRows, "err_itm_ctnt");
		saveNamesArray	= saveNames.split("|");
		
		for(var i=0; i < saveNamesArray.length; i++){
			sheetObj.CellBackColor(HeaderRows + 0, saveNamesArray[i]) = sheetObj.RgbColor(255,000,000);
		}
		
		// date 형식 항목 변환
		set_DateType(sheetObj);
	}
}

function sheet2_OnSearchEnd(sheetObj){
	with(sheetObj){
		
		var idx = 0;
		for(var i=0; i <= sheetObj.RowCount("R"); i++){
			idx = HeaderRows + i;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(239,240,243);
			sheetObj.CellBackColor(idx, "dep_port_cd") = sheetObj.RgbColor(195,195,195);
		}
	}
}

function sheet3_OnSearchEnd(sheetObj){
	with(sheetObj){
		
		var idx = 0;
		for(var i=0; i <= sheetObj.RowCount("R"); i++){
			idx = HeaderRows + i;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(239,240,243);
			sheetObj.CellBackColor(idx, "dep_port_cd") = sheetObj.RgbColor(195,195,195);
		}
	}
}

function sheet4_OnSearchEnd(sheetObj){
	with(sheetObj){
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case SEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH;
			
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0004GS.do", FormQueryString(formObj));
//			sheetObj.LoadSearchXml(rXml);
//			sheetObj.Redraw = true;
//			ComOpenWait(false);
 			var arrXml = rXml.split("|$$|");
 			var arrCt = arrXml.length;
 			
 			if (arrXml != null && arrCt > 0) {
 				for (var sRstCt=arrCt; sRstCt>0; sRstCt--) {
 					sheetObjects[sRstCt-1].Redraw = false;
 					sheetObjects[sRstCt-1].LoadSearchXml(arrXml[sRstCt-1]);
 					sheetObjects[sRstCt-1].Redraw = true;
 				}
 			}
 			
 			ComOpenWait(false);
			
		}
		break;
		
	case SEARCH01:
		if (validateForm(sheetObj, formObj, sAction)) {
			//view 데이터 정제
			dataFormatChk(sheetObj);
			
//			ComOpenWait(true);
			sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH01;

			var saveStr2 = "";
			if(formObj.call_ui_id.value == "VOP_FCM_0002" &&  sheetObjects[3] != null){
				saveStr2 = sheetObjects[3].GetSaveString(false);
				saveStr2 = "&" + saveStr2;
			}
			
			var saveStr =sheetObj.GetSaveString(false);
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0004GS.do", saveStr + "&" +FormQueryString(formObj) + saveStr2,"",true);
 			var arrXml = rXml.split("|$$|");
 			var arrCt = arrXml.length;
 			
 			if (arrXml != null && arrCt > 0) {
 				for (var sRstCt=arrCt; sRstCt>0; sRstCt--) {
 					sheetObjects[sRstCt-1].Redraw = false;
 					sheetObjects[sRstCt-1].LoadSearchXml(arrXml[sRstCt-1]);
 					sheetObjects[sRstCt-1].Redraw = true;
 				}
 			}
 			
// 			ComOpenWait(false);
 			formObj.sim_chk.value = "Y";
 			sheetObj.SelectCell(1, 1);			
		}
		break;
		
	case SEARCH02:
		if (validateForm(sheetObj, formObj, sAction)) {
			//view 데이터 정제
//			dataFormatChk(sheetObj);
			
			formObj.f_cmd.value = SEARCH02;
			
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0004GS.do", FormQueryString(formObj),"",true);
			var arrXml = rXml.split("|$$|");
			var arrCt = arrXml.length;
			
			if(arrXml != null && arrCt > 0){
				sheetObjects[1].Redraw = false;
				sheetObjects[1].LoadSearchXml(arrXml[0]);
				sheetObjects[1].Redraw = true;
			}
			formObj.sim_chk.value = "N";
		}
		break;
		
	case MULTI:
		// 저장 , History 재조회
		doActionSave(sheetObj, formObj, sAction);
		break;
		
	}
}

function doActionSave(sheetObj, formObj, sAction){
	var sheetID = sheetObj.id;
	
	if(validateForm(sheetObj, formObj, sAction)){
		if (sheetID == "sheet1" && sAction == MULTI){
			// Sheet1 Save
			formObj.f_cmd.value = MULTI;
			
			// update 전 data 정제
			dataFormatChk(sheetObj);
			
			var sParam = ComGetSaveString(sheetObj, true);
			
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj);
			
			var sParam2 = "";
			if(formObj.call_ui_id.value == "VOP_FCM_0002" &&  sheetObjects[3] != null){
				sParam2 = sheetObjects[3].GetSaveString(false);
				sParam2 = "&" + sParam2;
				sParam = sParam + sParam2;
			}
			
 			// date 형식 항목 변환
 			set_DateType(sheetObj);
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_FCM_0004GS.do", sParam);
			ComOpenWait(false);
			
			// SAVE OK 일 경우 저장된 내용 다시 조회.
			var nodeText = FcmGetXmlSelectSingleNodeText(sXml, "TR-ALL");
			if(nodeText == "OK"){
				alert("cleansing complate!");
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
		}
	}
}

function dataFormatChk(sheetObj){
	// date 형식 항목 변환
	var saveNames = "";
	saveNames = "nxt_port_eta_dt|sb_eng_dt|plt_in_dt|bfr_brth_ank_drp_dt|bfr_brth_ank_off_dt|vps_etb_dt|cgo_wrk_st_dt|cgo_wrk_end_dt";
	saveNames = saveNames + "|vps_etd_dt|aft_unbrth_ank_drp_dt|aft_unbrth_ank_off_dt|plt_out_dt|rup_dt|lst_port_rup_dt";
	
	var saveNamesArray = saveNames.split("|");
	for(var i=0; i < saveNamesArray.length; i++){
		sheetObj.CellValue(sheetObj.HeaderRows + 0, saveNamesArray[i]) = ComTrimAll(sheetObj.CellValue(sheetObj.HeaderRows + 0, saveNamesArray[i]), " ", "-", ":");
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		break;
	case SEARCH01:
		break;
	case SEARCH02:
		break;
	case MULTI:
		break;
	}

	return true;
}

/**
 * save
 * @param sheetObj
 * @param formObj
 */
function doSave(sheetObj, formObj){
	var simChk = formObj.sim_chk.value;
	if(simChk == 'Y'){
		doActionIBSheet(sheetObj, formObj, MULTI);
	}else{
		if(confirm("You have not yet simulation. Are you sure you want to save it?")){
			doActionIBSheet(sheetObj, formObj, MULTI);
		}else{
			return;
		}
	}
}

/**
 * 기호 삽입
 * 
 * @param front
 * @param rear
 * @param val
 * @returns
 */
function applyExpression(front, rear, val){
	var str = val;
	
	if(str != null && str != ""){
		if(front == "pm"){	//plus-minus
			str = "± " + str;
		}
		if(rear == "per"){	//percent
			str = str + "%";
		}
	}
	
	return str;
}

/**
 * 날짜 형식 적용
 * 
 * @param sDate
 * @return
 */
function Usr_GetDateTimeSet(sDate){
	var ymd = "";
	var hm = "";
	var rtnVal = "";
	if(sDate.length == 12){
		if(ComIsDateTime2(sDate, "ymdhm")){
			ymd = ComGetMaskedValue(sDate.substring(0, 8), "ymd");
			hm = ComGetMaskedValue(sDate.substring(8, 12), "hm");
			rtnVal = ymd + " " + hm;
		}else{
			rtnVal = sDate;
		}
	}else{
		rtnVal = sDate;
	}
	
	return rtnVal;
}

function set_DateType(sheetObj){
	var saveNames = "nxt_port_eta_dt|sb_eng_dt|plt_in_dt|bfr_brth_ank_drp_dt|bfr_brth_ank_off_dt|vps_etb_dt|cgo_wrk_st_dt|cgo_wrk_end_dt";
	saveNames = saveNames + "|vps_etd_dt|aft_unbrth_ank_drp_dt|aft_unbrth_ank_off_dt|plt_out_dt|rup_dt|lst_port_rup_dt";

	var saveNamesArray = saveNames.split("|");
	for(var i=0; i < saveNamesArray.length; i++){
		sheetObj.CellValue(sheetObj.HeaderRows + 0, saveNamesArray[i]) = Usr_GetDateTimeSet(sheetObj.CellValue(sheetObj.HeaderRows + 0, saveNamesArray[i]));
		sheetObj.CellValue(sheetObj.HeaderRows + 1, saveNamesArray[i]) = Usr_GetDateTimeSet(sheetObj.CellValue(sheetObj.HeaderRows + 1, saveNamesArray[i]));
	}
}

function sheet1_OnBeforeEdit(sheetObj, Row, Col){
	
	var colSaveName = sheetObj.ColSaveName(Col);
	
	switch(colSaveName){
		case "nxt_port_eta_dt":
		case "sb_eng_dt":
		case "plt_in_dt":
		case "bfr_brth_ank_drp_dt":
		case "bfr_brth_ank_off_dt":
		case "vps_etb_dt":
		case "cgo_wrk_st_dt":
		case "cgo_wrk_end_dt":
		case "vps_etd_dt":
		case "aft_unbrth_ank_drp_dt":
		case "aft_unbrth_ank_off_dt":
		case "plt_out_dt":
		case "rup_dt":
		case "lst_port_rup_dt":
		case "nxt_port_eta_dt":
			if(Row == (sheetObj.HeaderRows + 0)){
				dateVal = sheetObj.CellValue(Row, Col);
				sheetObj.CellValue(Row, Col) = ComTrimAll(sheetObj.CellValue(Row, Col), " ", "-", ":");
			}
			break;
	}
}

function sheet1_OnAfterEdit(sheetObj, Row, Col){
	
	var colSaveName = sheetObj.ColSaveName(Col);
	var bData = sheetObj.CellValue(Row, Col);
	var formObject = document.form;
	formObject.sim_chk.value = "N";
	
	switch(colSaveName){
		case "nxt_port_eta_dt":
		case "sb_eng_dt":
		case "plt_in_dt":
		case "bfr_brth_ank_drp_dt":
		case "bfr_brth_ank_off_dt":
		case "vps_etb_dt":
		case "cgo_wrk_st_dt":
		case "cgo_wrk_end_dt":
		case "vps_etd_dt":
		case "aft_unbrth_ank_drp_dt":
		case "aft_unbrth_ank_off_dt":
		case "plt_out_dt":
		case "rup_dt":
		case "lst_port_rup_dt":
		case "nxt_port_eta_dt":
			if(Row == (sheetObj.HeaderRows + 0)){
				sheetObj.CellValue(Row, Col) = Usr_GetDateTimeSet(sheetObj.CellValue(Row, Col));
				if( bData == sheetObj.CellValue(Row, Col) && bData != ""){
					ComShowCodeMessage("FCM00003", sheetObj.CellValue(2, Col));
					sheetObj.CellValue(Row, Col) = dateVal;
				}
				dateVal = "";
			}
			break;
	}
}
