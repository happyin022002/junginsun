/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : VOP_FCM_0083.js
 *@FileTitle : Departure Report Error Rate Setting
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.00
 *@LastVersion : 1.0
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
 * @class VOP_FCM_0083 : VOP_FCM_0083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0083() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_vslpop":
			openVslCdHelp(sheetObject);
			break;
				
		case "btn_Row_Delete":
			ComRowHideDelete(sheetObject, "del_chk");
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 /**
  * Vessel Code Help 파일을 오픈한다
  */
 function openVslCdHelp(sheetObj){
 	var sUrl = "VOP_VSK_0219.do?vsl_cd="+document.form.vsl_cd.value+"&inc_del_vsl_pop=Y";
 	ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
 }
 
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

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	document.form.vsl_cd.focus();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
}

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;

	switch (event.srcElement.name) {
	case "vsl_cd":
		if(val.length==4){
			sheetObj = sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keypress() {
	var obj = event.srcElement;
	switch (obj.name) {
	case "vsl_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			// 높이 설정
			style.height = 444;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(4, 1, 10, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

             var HeadTitle = "|SEL|Vessel\nCD|SPECIFICATION|SPECIFICATION|SPECIFICATION|SPECIFICATION|SPECIFICATION|SPECIFICATION|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE|PERFORMANCE" +
					"|PERFORMANCE|PERFORMANCE|PERFORMANCE|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|R.O.B|FUEL CONSUM|FUEL CONSUM|FUEL CONSUM|TIME" +
					"|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME|TIME"+
					"|TIME|TIME|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO|CARGO";
			
			
			var HeadTitle1 = "|SEL|Vessel\nCD|Vessel's Full\nName|Design\nCapa|Main Engine|Main Engine|Main Engine|Main Engine|Miles Obs|Miles Eng|Miles In|Miles Out|SPD" +
					"|RPM|AVG\nPro.Pitch|Sailing\nTime|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Arr)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Rob(Dep)|Sea\nSteaming|Harbor/\nIn Port|AVG.FOC/HR\nHarbor/Inport|S/B ENG" +
					"|P.O.B|ANCHOR|ANCHOR\nAWAY|FIRST\nLINE|COMM'CED\nWKG|COMP'TED\nWKG|LAST\nLINE|DROP\nANCHOR|ANCHOR\nAWAY|PILOT\nAWAY"+
					"|R/UP\nENG|On Board CNTR|On Board CNTR|On Board CNTR|On Board CNTR|R/F CNTR|R/F CNTR|R/F CNTR";
			
			var HeadTitle2 = "|SEL|Vessel\nCD|Vessel's Full\nName|Design\nCapa|Type|RPM|Power(KW)|Power(BHP)|Miles Obs|Miles Eng|Miles In|Miles Out|SPD" +
			"|RPM|AVG\nPro.Pitch|Sailing\nTime|F.O|LS F.O|D.O|LS D.O|F.O|LS F.O|D.O|LS D.O|M/E|TTL|TTL.|S/B ENG" +
			"|P.O.B|ANCHOR|ANCHOR\nAWAY|FIRST\nLINE|COMM'CED\nWKG|COMP'TED\nWKG|LAST\nLINE|DROP\nANCHOR|ANCHOR\nAWAY|PILOT\nAWAY"+
			"|R/UP\nENG|FULL|EM'TY|TOTAL|WGT|DISH|LOAD|ON Board";
			
			var HeadTitle3 = "||Vessel\nCD|Vessel's Full\nName|Design\nCapa|Type|RPM|Power(KW)|Power(BHP)|+>E%>-|+>E%>-|+>E%>-|+>E%>-|+>E%>-" +
			"|+>E%>-|+>E%>-|+>E%>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>E%>-|+>E%>-|+>E%>-|+>diff>-" +
			"|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-|+>diff>-"+
			"|+>diff>-| +>diff>-| +>diff>-| +>diff>-| +>diff>-| +>diff>-| +>diff>-| +>diff>-";
			
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 3, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);
			InitHeadRow(2, HeadTitle2, true);
			InitHeadRow(3, HeadTitle3, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtDelCheck,		25,		daCenter,	true,	"del_chk",					false,	"",			dfNone,			        0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"vsl_cd",					false,	"",			dfEngUpKey,		        0,			false,		true,4);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"vsl_eng_nm",				false,	"",			dfNone,		        	0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"cntr_vsl_clss_capa",		false,	"",			dfNone,			        0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"mn_eng_tp_desc",			false,	"",			dfNone,		         	0,			false,		false,50,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"tbcgr_rpm_pwr",			false,	"",			dfNone,			        0,			false,		false,6);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"mn_eng_bhp_pwr",			false,	"",			dfNone,		         	0,			false,		false,6);
			InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"mn_eng_rpm_pwr",			false,	"",			dfNone,			        0,			false,		false,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"nvgt_ml_dist_rt",			false,	"",			dfNullFloat,			1,			true,		true,10);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"eng_ml_dist_rt",			false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"mnvr_in_ml_dist_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"mnvr_out_ml_dist_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"avg_spd_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"avg_rpm_pwr_rt",			false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"prlr_pch_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"sail_tm_rt",			    false,	"",			dfNullFloat,	        1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"arr_foil_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"arr_low_sulp_foil_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"arr_doil_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"arr_low_sulp_doil_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dep_foil_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dep_low_sulp_foil_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dep_doil_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dep_low_sulp_doil_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);			
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"sea_stmng_mn_eng_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"port_ttl_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"port_ttl_hr_rt_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"sb_eng_dt_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"plt_in_dt_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"bfr_brth_ank_drp_dt_rt",	false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"bfr_brth_ank_off_dt_rt",	false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"vps_etb_dt_rt",			false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"cgo_wrk_st_dt_rt",			false,	"",			dfNullFloat,		    1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"cgo_wrk_end_dt_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"vps_etd_dt_rt",			false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"aft_unbrth_ank_drp_dt_rt",	false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"aft_unbrth_ank_off_dt_rt",	false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"plt_out_dt_rt",			false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"rup_dt_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"fcntr_obrd_teu_rt",		false,	"",			dfNullFloat,		    1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"mcntr_obrd_teu_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"ttl_cntr_obrd_teu_rt",		false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"dep_cgo_rt",			    false,	"",			dfNullFloat,			1,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"rf_cntr_dchg_knt_rt",		false,	"",			dfNullFloat,			0,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"rf_cntr_lod_knt_rt",		false,	"",			dfNullFloat,			0,			true,		true,6);
			InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"rf_cntr_obrd_knt_rt",		false,	"",			dfNullFloat,			0,			true,		true,6);
			
		}
		
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	case IBSEARCH: // 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var rXml = sheetObj.GetSearchXml("VOP_FCM_0083GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchXml(rXml);
		ComOpenWait(false);
		break;

	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
			var SaveStr = ComGetSaveString(sheetObjects);
			var sXml = sheetObj.GetSaveXml("VOP_FCM_0083GS.do", SaveStr + "&" + FormQueryString(formObj));
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComOpenWait(false);
		}
		break;

	case IBDELETE:
		ComOpenWait(true);
		formObj.f_cmd.value = REMOVE;
		var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
		var SaveStr = ComGetSaveString(sheetObjects);
	    var sXml = sheetObj.GetSaveXml("VOP_FCM_0083GS.do", SaveStr + "&" + FormQueryString(formObj));
	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		ComOpenWait(false);
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
		
		case IBSAVE:
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "ibflag")!="R" && sheetObj.CellValue(i, "vsl_cd")==""){
					ComShowMessage("Please check "+i+"th row");
					return false;
				}
			}
		break;
	}
	return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	switch (sheetObj.ColSaveName(Col)) {
		case "vsl_cd" :
			if(Value!=""){
				var formObj = document.form;				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_FCM_0083GS.do?vsl_cd="+Value+"&f_cmd="+formObj.f_cmd.value);
				var fcmExist = ComGetEtcData(sXml, "fcm_exist");
				if(fcmExist=="Y"){
					ComShowMessage("This vessel info was already existed.");
					sheetObj.CellValue2(Row, Col)="";
					sheetObj.SelectCell(Row, Col, true);
					sheetObj.CellValue(Row, "vsl_eng_nm")="";
					sheetObj.CellValue(Row, "dwt_wgt")="";
					sheetObj.CellValue(Row, "grs_rgst_tong_wgt")="";
					sheetObj.CellValue(Row, "net_rgst_tong_wgt")="";
					sheetObj.CellValue(Row, "lloyd_no")="";
					sheetObj.CellValue(Row, "cntr_vsl_clss_capa")="";
				}else{
					var mdmExist = ComGetEtcData(sXml, "mdm_exist");
					if(mdmExist=="N"){
						ComShowMessage("This vessel doesn't exist in MDM or isn't appropriate.");
						sheetObj.CellValue2(Row, Col)="";
						sheetObj.SelectCell(Row, Col, true);
						sheetObj.CellValue(Row, "vsl_eng_nm")="";
						sheetObj.CellValue(Row, "dwt_wgt")="";
						sheetObj.CellValue(Row, "grs_rgst_tong_wgt")="";
						sheetObj.CellValue(Row, "net_rgst_tong_wgt")="";
						sheetObj.CellValue(Row, "lloyd_no")="";
						sheetObj.CellValue(Row, "cntr_vsl_clss_capa")="";
					}else{
						if(mdmExist=="C"){
							ComShowMessage("This Vessel Code is not SML operation and please check it again.");
						}
						var data = ComGetEtcData(sXml, "data");
						var dataItem = data.split("");
						sheetObj.CellValue(Row, "vsl_eng_nm")=dataItem[0];
						sheetObj.CellValue(Row, "dwt_wgt")=dataItem[1];
						sheetObj.CellValue(Row, "grs_rgst_tong_wgt")=dataItem[2];
						sheetObj.CellValue(Row, "net_rgst_tong_wgt")=dataItem[3];
						sheetObj.CellValue(Row, "lloyd_no")=dataItem[4];
						sheetObj.CellValue(Row, "cntr_vsl_clss_capa")=dataItem[5];
												
						sheetObj.CellValue(Row, "ownr_nm")=dataItem[6];
						sheetObj.CellValue(Row, "vsl_bld_dt")=dataItem[7];
						sheetObj.CellValue(Row, "vsl_dznd_capa")=dataItem[8];
						sheetObj.CellValue(Row, "bse_14ton_vsl_capa")=dataItem[9];
						sheetObj.CellValue(Row, "fm_dt")=dataItem[10];
						sheetObj.CellValue(Row, "to_dt")=dataItem[11];
					}
				}
				ComOpenWait(false);
			}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	notifyUnregFleetVessl(sheetObj);
}

/*
 * Fleet Management에 등록되지 않는 Vessel을 notify 한다.
 */
function notifyUnregFleetVessl(sheetObj){
	var list = new Array();
	var start = sheetObj.HeaderRows;
	var end = start + sheetObj.SearchRows;
	for(var k=start; k<end; k++){
		if(sheetObj.CellValue(k, "ownr_nm")==""){
			list.push(sheetObj.CellValue(k, "vsl_cd"));
		}
	}
	if(list.length>0){
		ComShowMessage("***** Unregistered Vessel *****\n" + list.join("\t"));
	}
}

/* 개발자 작업 끝 */