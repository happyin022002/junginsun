﻿/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2069.js
 *@FileTitle : RFA Proposal & Amendment Creation - Rate Tab(Add-On Tariff Management) (V Type)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.26
 *@LastModifier : 이은섭
 *@LastVersion : 1.1
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
 * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2069() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var bIsReqUsr = false;
var bIsAproUsr = false;
var timerID = "";
var jobKey = "";

var isOViaMandatory = false;
var isDViaMandatory = false;


var bBackEndJob = false;

var v_origin = 'O';
var v_destination = 'D';

var orgExptLoc; //Origin Exception Location
var destExptLoc; //Destination Exception Location

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var rateGuideObj = new Object({
	'origin' : {
		"fic_gline_rt_amt" : "fic_org_gline_rt_amt",
		"fic_rt_use_sts_cd" : "fic_org_rt_use_sts_cd",
		"optm_trsp_mod_flg" : "org_optm_trsp_mod_flg",
		"group_no" : "org_group_no",
		"fic_prop_rt_amt" : "fic_org_prop_rt_amt",
		"base_port_list" : "org_base_port_list",
		"fic_rout_cmb_tp_cd" : "fic_org_rout_cmb_tp_cd",
		"fic_gline_upd_dt" : "fic_org_gline_upd_dt",
		"bse_port_loc_cd" : "org_bse_port_loc_cd",
		"dr_20ft_amt" : "org_dr_20ft_amt",
		"rf_20ft_amt" : "org_rf_20ft_amt",
		"dg_20ft_amt" : "org_dg_20ft_amt",
		"dr_40ft_amt" : "org_dr_40ft_amt",
		"rf_40ft_amt" : "org_rf_40ft_amt",
		"dg_40ft_amt" : "org_dg_40ft_amt",
		"cy_dor_rt_tp_cd" : "org_cy_dor_rt_tp_cd"
	},
	'destination' : {
		"fic_gline_rt_amt" : "fic_dest_gline_rt_amt",
		"fic_rt_use_sts_cd" : "fic_dest_rt_use_sts_cd",
		"optm_trsp_mod_flg" : "dest_optm_trsp_mod_flg",
		"group_no" : "dest_group_no",
		"fic_prop_rt_amt" : "fic_dest_prop_rt_amt",
		"base_port_list" : "dest_base_port_list",
		"fic_rout_cmb_tp_cd" : "fic_dest_rout_cmb_tp_cd",
		"fic_gline_upd_dt" : "fic_dest_gline_upd_dt",
		"bse_port_loc_cd" : "dest_bse_port_loc_cd",
		"dr_20ft_amt" : "dest_dr_20ft_amt",
		"rf_20ft_amt" : "dest_rf_20ft_amt",
		"dg_20ft_amt" : "dest_dg_20ft_amt",
		"dr_40ft_amt" : "dest_dr_40ft_amt",
		"rf_40ft_amt" : "dest_rf_40ft_amt",
		"dg_40ft_amt" : "dest_dg_40ft_amt",
		"cy_dor_rt_tp_cd" : "dest_cy_dor_rt_tp_cd"	
	}
});



/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
			if (getButtonTable(srcName).disabled) {
				return false;
			}
		}

		switch (srcName) {
			case "btn_template":
				downform.submit();
				break;
	
			case "btn_openfile":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
				break;
	
			case "btn_check":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, document.form, IBSAVE);
				break;
	
			case "btn_close":
				window.close();
				break;

		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setSheetObject(sheetObj);
 * </pre>
 * 
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * loadPage();
 * </pre>
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	bIsReqUsr = document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
	bIsAproUsr = document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;

	toggleButtons("INIT");

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	
	/* 예의 지역 조회*/
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC12);	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC13);	
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * initSheet(sheetObj, 1);
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function initSheet(sheetObj, sheetNo) {
	var formObj = document.form;
	var cnt = 0;

	switch (sheetObj.id) {
	case "sheet1": 
		with (sheetObj) {
			// 높이 설정
			style.height = 440;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
			
			var HeadTitle1 = "||cmdt_rout|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Destination|Rate|Rate|Rate|Rate|Rate|Rate|Rate";
				HeadTitle1 += "|fic_org_gline_rt_amt|fic_org_rt_use_sts_cd|org_optm_trsp_mod_flg|org_base_port_list|fic_org_rout_cmb_tp_cd|fic_org_gline_upd_dt|org_bse_port_loc_cd|org_dr_20ft_amt|org_rf_20ft_amt|org_dg_20ft_amt|org_dr_40ft_amt|org_rf_40ft_amt|org_dg_40ft_amt";
				HeadTitle1 += "|fic_dest_gline_rt_amt|fic_dest_rt_use_sts_cd|dest_optm_trsp_mod_flg|dest_base_port_list|fic_dest_rout_cmb_tp_cd|fic_dest_gline_upd_dt|dest_bse_port_loc_cd|dest_dr_20ft_amt|dest_rf_20ft_amt|dest_dg_20ft_amt|dest_dr_40ft_amt|dest_rf_40ft_amt|dest_dg_40ft_amt";
				HeadTitle1 += "|org_rout_pnt_loc_tp_cd|dest_rout_pnt_loc_tp_cd|org_cy_dor_rt_tp_cd|dest_cy_dor_rt_tp_cd";
			 	
			var HeadTitle2 = "||cmdt_rout|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Loc Group|Term|Transmode|Code|Code|Code|Description|Loc Group|Term|Transmode|PER|Cargo Type|Cur|Rate|BOF|OIH|DIH";
				HeadTitle2 += "|fic_org_gline_rt_amt|fic_org_rt_use_sts_cd|org_optm_trsp_mod_flg|org_base_port_list|fic_org_rout_cmb_tp_cd|fic_org_gline_upd_dt|org_bse_port_loc_cd|org_dr_20ft_amt|org_rf_20ft_amt|org_dg_20ft_amt|org_dr_40ft_amt|org_rf_40ft_amt|org_dg_40ft_amt";
				HeadTitle2 += "|fic_dest_gline_rt_amt|fic_dest_rt_use_sts_cd|dest_optm_trsp_mod_flg|dest_base_port_list|fic_dest_rout_cmb_tp_cd|fic_dest_gline_upd_dt|dest_bse_port_loc_cd|dest_dr_20ft_amt|dest_rf_20ft_amt|dest_dg_20ft_amt|dest_dr_40ft_amt|dest_rf_40ft_amt|dest_dg_40ft_amt";			
				HeadTitle2 += "|org_rout_pnt_loc_tp_cd|dest_rout_pnt_loc_tp_cd|org_cy_dor_rt_tp_cd|dest_cy_dor_rt_tp_cd";
							
			var headCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "h_seq");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cmdt_rout");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cmdt_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cust_seq", false, "", dfNone, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_group_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "org_rcv_de_term_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "org_prc_trsp_mod_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "dest_group_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "dest_rcv_de_term_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "dest_prc_trsp_mod_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, false, "rat_ut_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "prc_cgo_tp_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "prop_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "prop_bof_amt", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fic_org_prop_rt_amt", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fic_dest_prop_rt_amt", false, "", dfNullFloat, 2, true, true);

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_org_gline_rt_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_org_rt_use_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "org_optm_trsp_mod_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "org_base_port_list");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_org_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_org_gline_upd_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "org_bse_port_loc_cd");

			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_dg_40ft_amt", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_dest_gline_rt_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_dest_rt_use_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "dest_optm_trsp_mod_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "dest_base_port_list");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_dest_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "fic_dest_gline_upd_dt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "dest_bse_port_loc_cd");

			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_dg_40ft_amt", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_rout_pnt_loc_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_rout_pnt_loc_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "org_cy_dor_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "dest_cy_dor_rt_tp_cd", false, "", dfNone, 0, true, true);
			
			ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
			InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "cust_seq", vtEngUpOther, "0123456789");
			InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
			InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD", "USD");
			
			ShowButtonImage = 2;
			HeadRowHeight = DataRowHeight;
		}
		break;
	case "sheet2": // hidden
		with (sheetObj) {
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			var HeadTitle = "status";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
			// SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			Visible = false;
		}
		break;
	case "sheet3": // guide-line sheet
		with (sheetObj) {
			// 높이 설정
			style.height = 150;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "h_seq|cmdt_dp_seq|rout_dp_seq|group_no|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|cy_dor_rt_tp_cd|cmdt_rout";
				HeadTitle1 += "|loc_curr_cd|loc_dr_20ft_amt|loc_rf_20ft_amt|loc_dg_20ft_amt|loc_dr_40ft_amt|loc_rf_40ft_amt|loc_dg_40ft_amt";
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "h_seq", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cmdt_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "group_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "base_port_list");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "optm_trsp_mod_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rt_use_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_gline_upd_dt");
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "cy_dor_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cmdt_rout");
			
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "loc_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_loc_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_loc_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_loc_40ft_amt", false, "", dfNone, 0, true, true);					
		}
		break;
	case "sheet4": // guide-line sheet
		with (sheetObj) {
			// 높이 설정
			style.height = 150;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "h_seq|cmdt_dp_seq|rout_dp_seq|group_no|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|cy_dor_rt_tp_cd|cmdt_rout";
				HeadTitle1 += "|loc_curr_cd|loc_dr_20ft_amt|loc_rf_20ft_amt|loc_dg_20ft_amt|loc_dr_40ft_amt|loc_rf_40ft_amt|loc_dg_40ft_amt";			
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "h_seq", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cmdt_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "group_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "base_port_list");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "optm_trsp_mod_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rt_use_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_gline_upd_dt");
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "cy_dor_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cmdt_rout");
			
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "loc_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_loc_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dr_loc_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "rf_loc_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, false, "dg_loc_40ft_amt", false, "", dfNone, 0, true, true);		
		}
		break;	
	}
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	if (!isClear && KeyCode == 9) {
		while (true) {
			Col++;
			if (Col > sheetObj.LastCol) {
				Row++;
				Col = 1;
			}
			if (Row > sheetObj.LastRow) {
				Row = sheetObj.HeaderRows;
			}
			if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255, 0, 0)) {
				sheetObj.SelectCell(Row, Col, false);
				break;
			}
		}
	}
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당 code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	if (colName == 'cmdt_dp_seq' || colName == 'rout_dp_seq') {
		if (colName == 'cmdt_dp_seq') {
			if (!funcDupCheckCmdtSeq(sheetObj, Row, Value)) {
				ComShowCodeMessage("PRI00303", 'CMDT Seq', Value);
				return false;
			}
		}
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		sheet1_OnLoadExcel(sheetObj);
		ComOpenWait(false);
	} else if (colName == "prc_cgo_tp_cd") {
		if (Value == "AK") {
			var validPerClass = "A,F,O,Q,S,P";
			var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
			if (validPerClass.indexOf(perClass) < 0) {
				ComShowCodeMessage("PRI08003");
				sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
			}
		} else {
			sheetObj.CellValue2(Row, "prop_frt_rt_amt") = 0.00;
			funcGuideLineAmount(sheetObj, Row, v_origin);
			funcGuideLineAmount(sheetObj, Row, v_destination);
		}
	} else if (colName == "rat_ut_cd") {
		var validPerClass = "A,F,O,Q,S,P";
		var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
		if (perClass == "") {
			funcGuideLineAmount(sheetObj, Row, v_origin);
			funcGuideLineAmount(sheetObj, Row, v_destination);
			return;
		}
		if (perClass == "D") {
			sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "DR"
		} else if (perClass == "R") {
			sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "RF"
		} else if (validPerClass.indexOf(perClass) >= 0) {
			sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "AK"
		} else {
			if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
				ComShowCodeMessage("PRI08003");
				sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
			}
		}
		sheetObj.CellValue2(Row, "prop_frt_rt_amt") = 0.00;
		funcGuideLineAmount(sheetObj, Row, v_origin);
		funcGuideLineAmount(sheetObj, Row, v_destination);
	} else if (colName == "prc_cmdt_def_cd") {
		if (Value.length == 6) {
			formObj.f_cmd.value = SEARCH08;
			var param = "&cd=" + Value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = COMMAND29;
			var param = "&cd=" + Value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH10;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
			sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
			sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
			return false;
		}
	} else if (colName == "cust_seq") {
		if (Value.length > 2 && Value.length <= 8) {
			Value = Value.substring(0, 2) + ComLpad(Value.substring(2, 8), 6, "0");
			sheetObj.CellValue2(Row, Col) = Value;

			formObj.f_cmd.value = COMMAND07;
			var param = "&etc1=" + Value.substring(0, 2) + "&etc2=" + Value.substring(2, 8);
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != undefined && arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = "";
				sheetObj.CellValue2(Row, "cust_seq") = "";
				sheetObj.SelectCell(Row, "cust_seq", false);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = "";
			sheetObj.CellValue2(Row, "cust_seq") = "";
			sheetObj.SelectCell(Row, "cust_seq", false);
			return false;
		}
	} else if (colName == "org_rout_pnt_loc_def_cd") {
		if(sheetObj.CellValue(Row, "org_rcv_de_term_nm") == '' ) {
			sheetObj.CellValue2(Row, "org_rcv_de_term_nm") = 'D';
		}
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData !=undefined &&  arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_tp_cd") = "L";
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				if(!searchCYDoorLocationCheck(sheetObj, Row, Value,"L", v_origin) ){
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				} 					
			} else {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = '';
				sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=O";
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_tp_cd") = "G";
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				sheetObj.CellValue2(Row, "org_rcv_de_term_nm") = 'Y';
				if(!searchCYDoorLocationCheck(sheetObj, Row, Value,"G", v_origin) ){
					sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				}
			} else {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = '';
				sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = '';
			sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
			initFicRoute(sheetObj, Row, Col);
			return false;
		}
		initFicRoute(sheetObj, Row, Col);
	} else if (colName == "dest_rout_pnt_loc_def_cd") {
		if(sheetObj.CellValue(Row, "dest_rcv_de_term_nm") == '' ) {
			sheetObj.CellValue2(Row, "dest_rcv_de_term_nm") = 'D';
		}
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_tp_cd") = "L";
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				if(!searchCYDoorLocationCheck(sheetObj, Row, Value,"L", v_destination) ){
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				} 					
			} else {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = '';
				sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_tp_cd") = "G";
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				sheetObj.CellValue2(Row, "dest_rcv_de_term_nm") = 'Y';
				if(!searchCYDoorLocationCheck(sheetObj, Row, Value,"G", v_destination) ){
					sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				}
			} else {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = '';
				sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = '';
			sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
			initFicRoute(sheetObj, Row, Col);
			return false;
		}
		initFicRoute(sheetObj, Row, Col);
	} else if (colName == 'org_prc_trsp_mod_nm') {
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
	} else if (colName == 'dest_prc_trsp_mod_nm') {
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC09);
	} else if (colName == "org_rcv_de_term_nm") {
		if(Value == 'D' && sheetObj.CellValue(Row, "org_rout_pnt_loc_tp_cd") == 'G') {
			sheetObj.CellValue2(Row, "org_rcv_de_term_nm") = 'Y';
			ComShowCodeMessage("PRI07021" );
			return false;
		}
		if( !searchCYDoorLocationCheck(sheetObj, Row, sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd"), "L", v_origin) ){
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		} 	
		
		initFicRoute(sheetObj, Row, Col);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
	} else if (colName == "dest_rcv_de_term_nm") {
		if(Value == 'D' && sheetObj.CellValue(Row, "dest_rout_pnt_loc_tp_cd") == 'G') {
			sheetObj.CellValue2(Row, "dest_rcv_de_term_nm") = 'Y';
			ComShowCodeMessage("PRI07021" );
			return false;
		}
		
		if( !searchCYDoorLocationCheck(sheetObj, Row, sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd"), "L", v_destination) ){
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		} 	
		initFicRoute(sheetObj, Row, Col);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC10);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
	} else if (colName == "org_rout_via_port_def_cd") {
		if (sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd') != '') {
			initFicRoute(sheetObj, Row, Col);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		}
	} else if (colName == "dest_rout_via_port_def_cd") {
		if (sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd') != '') {
			initFicRoute(sheetObj, Row, Col);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC11);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
		}
	} else if (colName == "prop_frt_rt_amt" || colName == rateGuideObj.origin.fic_prop_rt_amt || colName == rateGuideObj.destination.fic_prop_rt_amt) {
		setBofCalculate(sheetObj, Row);
	} else if(colName == "org_cy_dor_rt_tp_cd" ) {
		if(Value == 'C') {
			clearCYGuideRate(sheetObj, Row, v_origin)
		}
	} else if(colName == "dest_cy_dor_rt_tp_cd" ) {
		if(Value == 'C') {
			clearCYGuideRate(sheetObj, Row, v_destination)
		}
	} else if (colName == "curr_cd") {
		funcGuideLineAmount(sheetObj, Row, v_origin);
		funcGuideLineAmount(sheetObj, Row, v_destination);		
	}
}

function clearCYGuideRate(sheetObj, Row, inOrgDestTpCd) {
	var rateObj;
	
	if(inOrgDestTpCd == v_origin) {
		rateObj = rateGuideObj.origin;
	} else {
		rateObj = rateGuideObj.destination;
	}
	var cmdtRoutVal = sheetObj.CellValue(Row, 'cmdt_rout');
	var r = sheetObj.FindText('cmdt_rout', cmdtRoutVal);
	for(var i = r; i < sheetObj.Rows; i++) {
		if(cmdtRoutVal != sheetObj.CellValue(i, 'cmdt_rout') || sheetObj.CellValue(i, rateObj.cy_dor_rt_tp_cd) == '') {
			break;
		}
		sheetObj.CellValue(i, rateObj.fic_gline_rt_amt) = 'N/A';
		sheetObj.CellValue(i, rateObj.fic_rt_use_sts_cd) = '';
		sheetObj.CellValue(i, rateObj.optm_trsp_mod_flg) = '';
		sheetObj.CellValue(i, rateObj.fic_prop_rt_amt) = '0';
		sheetObj.CellValue(i, rateObj.base_port_list) = '';
		sheetObj.CellValue(i, rateObj.bse_port_loc_cd) = '';
		sheetObj.CellValue(i, rateObj.dr_20ft_amt) = '';
		sheetObj.CellValue(i, rateObj.rf_20ft_amt) = '';
		sheetObj.CellValue(i, rateObj.dg_20ft_amt) = '';
		sheetObj.CellValue(i, rateObj.dr_40ft_amt) = '';
		sheetObj.CellValue(i, rateObj.rf_40ft_amt) = '';
		sheetObj.CellValue(i, rateObj.dg_40ft_amt) = '';
	}
}

function setBofCalculate(sheetObj, Row) {
	try {
		var propFrtRtAmt = parseFloat(sheetObj.CellValue(Row, "prop_frt_rt_amt")); // Proposal Total 금액
		var ficPropRtAmt = parseFloat(sheetObj.CellValue(Row, rateGuideObj.origin.fic_prop_rt_amt)); // Proposal IHc 금액
		var dest_ficPropRtAmt = parseFloat(sheetObj.CellValue(Row, rateGuideObj.destination.fic_prop_rt_amt)); // Proposal IHc 금액
		if (!isNaN(propFrtRtAmt)) {
			if (isNaN(propFrtRtAmt)) {
				propFrtRtAmt = 0;
			}
			
			if (isNaN(ficPropRtAmt)) {
				ficPropRtAmt = 0;
			}
			
			if (isNaN(dest_ficPropRtAmt)) {
				dest_ficPropRtAmt = 0;
			}
			sheetObj.CellValue2(Row, "prop_bof_amt") =  ComGetMaskedValue(ComTrunc(propFrtRtAmt - (ficPropRtAmt + dest_ficPropRtAmt), 2), "float");
		}
	} catch(err) {
		alert(err.description);
	}
}

/**
 * OnDblClick 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (colName == "prc_cmdt_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
		sUrl += "&grp_cd=" + PRI_RP_SCP + "&commodity_cmd=CRG&prc_cmdt_tp_cd=C";
		sUrl += "&prc_cmdt_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = rtnVal.nm;
		}
	} else if (colName == "cust_lgl_eng_nm") {
		var sUrl = "/hanjin/ESM_PRI_4014.do?" + FormQueryString(document.form);
		sUrl += "&is_popup=true&nmd_cust_flg=N&cust_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 640, 460, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "cust_seq") = rtnVal.custCntCd + ComLpad(rtnVal.custSeq, 6, "0");
			sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = rtnVal.custNm;
		}
	} else if (colName == "org_rout_pnt_loc_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
		sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=O";
		sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = rtnVal.nm;
		}
	} else if (colName == "dest_rout_pnt_loc_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
		sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=L&org_dest_cd=D";
		sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = rtnVal.nm;
		}
	}
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 이은섭
 * @version 2012.10.11
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
				var sXml = "";
				isOViaMandatory = false;
				isDViaMandatory = false;
	
				formObj.f_cmd.value = COMMAND17;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				var arrTemp = ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for ( var i = 0; i < arrTemp.length; i++) {
						var pptCd = arrTemp[i][1];
						if (pptCd == "ROVA") {
							isOViaMandatory = true;
						} else if (pptCd == "RDVA") {
							isDViaMandatory = true;
						}
					}
				}
				break;
			case IBSEARCH_ASYNC06: // Search FIC Route
				funcGetBasePortList(sheetObj, formObj, sheetObj.SelectRow, v_origin);
				break;
			case IBSEARCH_ASYNC07: // Search FIC Route
				funcGetBasePortTrspModeCd(sheetObj, formObj, sheetObj.SelectRow, v_origin);
				break;
			case IBSEARCH_ASYNC08: // Guide Line 정보 조회
				rate_setting(sheetObj, formObj, sheetObj.SelectRow, false, v_origin);
				sheetObjects[2].ColumnSort('h_seq', "ASC");
				var org_seq = sheetObjects[0].CellValue(sheetObj.SelectRow, "cmdt_rout");
				for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
					if (org_seq == sheetObjects[0].CellValue(i, "cmdt_rout")) {
						funcGuideLineAmount(sheetObj, i, v_origin);
					}
				}
				break;
			case IBSEARCH_ASYNC09: // Guide Line 정보 조회
				rate_setting(sheetObj, formObj, sheetObj.SelectRow, false, v_destination);
				sheetObjects[3].ColumnSort('h_seq', "ASC");
				var org_seq = sheetObjects[0].CellValue(sheetObj.SelectRow, "cmdt_rout");
				for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
					if (org_seq == sheetObjects[0].CellValue(i, "cmdt_rout")) {
						funcGuideLineAmount(sheetObj, i, v_destination);
					}
				}
				break;
			case IBSEARCH_ASYNC10: // Search FIC Route
				funcGetBasePortList(sheetObj, formObj, sheetObj.SelectRow, v_destination);
				break;	
				
			case IBSEARCH_ASYNC11: // Search FIC Route
				funcGetBasePortTrspModeCd(sheetObj, formObj, sheetObj.SelectRow, v_destination);
				break;		
	
			case IBSEARCH_ASYNC02: // Open
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					var sFileNm = strFilePath.substring(0, strFilePath.lastIndexOf("."));
					if (sFileNm.substring(sFileNm.length - 1, sFileNm.length) == "H") {
						ComShowCodeMessage("PRI01117");
						return;
					}
					sheetObj.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObj.RowCount > 0) {
					toggleButtons("LOAD");
	
					for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
						var custSeq = sheetObj.CellValue(i, "cust_seq");
						if (custSeq != null && custSeq.length > 2 && custSeq.length < 8) {
							custSeq = custSeq.substring(0, 2) + ComLpad(custSeq.substring(2, 8), 6, "0");
							sheetObj.CellValue2(i, "cust_seq") = custSeq;
						}
					}
				} else {
					toggleButtons("INIT");
				}
				if (strFilePath != "<USER_CANCEL>") {
					ComShowCodeMessage("PRI01045", "Loading file");
				}
				break;
	
			case IBSEARCH_ASYNC01: // Check
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
	
				break;
	
			case IBSAVE: // Save
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
	
				if (!ComPriConfirmSave()) {
					return false;
				}
				var svcScpCd = formObj.svc_scp_cd.value;
				for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
					sheetObj.CellValue2(i, rateGuideObj.origin.fic_rout_cmb_tp_cd) = sheetObjects[2].CellValue(sheetObjects[2].FindText('h_seq', sheetObj.CellValue(i, 'h_seq')), 'fic_rout_cmb_tp_cd');
					sheetObj.CellValue2(i, rateGuideObj.destination.fic_rout_cmb_tp_cd) = sheetObjects[3].CellValue(sheetObjects[3].FindText('h_seq', sheetObj.CellValue(i, 'h_seq')), 'fic_rout_cmb_tp_cd');
					
					sheetObj.CellValue2(i, rateGuideObj.origin.bse_port_loc_cd) = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
					sheetObj.CellValue2(i, rateGuideObj.destination.bse_port_loc_cd) = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
					
					if(sheetObj.CellValue(i, rateGuideObj.origin.cy_dor_rt_tp_cd) == 'C') {
						sheetObj.CellValue2(i, rateGuideObj.origin.fic_rt_use_sts_cd) = '';
						sheetObj.CellValue2(i, rateGuideObj.origin.optm_trsp_mod_flg) = '';
					}
					if(sheetObj.CellValue(i, rateGuideObj.destination.cy_dor_rt_tp_cd) == 'C') {
						sheetObj.CellValue2(i, rateGuideObj.destination.fic_rt_use_sts_cd) = '';
						sheetObj.CellValue2(i, rateGuideObj.destination.optm_trsp_mod_flg) = '';
					}
				}
	
				// BackendJob으로 돌리려면.. 이쪽 로직을...
				if (bBackEndJob) {
					formObj.f_cmd.value = MODIFY01;
					var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2069GS.do", sParam);
					jobKey = ComGetEtcData(sXml, "JOB_KEY");
					if (sXml.indexOf("ERROR") >= 0) {
						sheetObj.LoadSaveXml(sXml);
						return false;
					} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
						ComShowCodeMessage("PRI00201");
						return false;
					} else {
						timerID = setInterval(getJobStatus, 2000);
					}
				} else {
					formObj.f_cmd.value = MODIFY02;
					var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2069GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
	
					if (sXml.indexOf("ERROR") >= 0) {
						return false;
					}
					ComPriSaveCompleted();
					window.close();
					opener.saveCurRowPos();
					opener.reloadPagePostTr();
				}
	
				break;
	
			case IBCLEAR: // 화면 로딩시
				var sXml = "";
				var arrTemp = new Array();
	
				// per combo
				formObj.f_cmd.value = SEARCH03;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
	
				// 공통 cargo
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
				setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
	
				// 공통 Term Origin
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);
	
				// 공통 Term Destination
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);
	
				// 공통 Trans. Mode
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObj, sXml, "org_prc_trsp_mod_nm", true, 0);
				setIBCombo(sheetObj, sXml, "dest_prc_trsp_mod_nm", true, 0);
	
				break;
			case IBSEARCH_ASYNC12: //Exception Location
				loadExceptionLocation(v_origin);
				break;	
			case IBSEARCH_ASYNC13: //Exception Location
				loadExceptionLocation(v_destination);
				break;	
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

function getJobStatus() {
	var jobStatus = null;

	form.f_cmd.value = SEARCHLIST18;
	var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
	jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");

	if (jobStatus == "3") {
		clearInterval(timerID);

		opener.saveCurRowPos();
		opener.reloadPagePostTr();

		ComPriSaveCompleted();

		window.close();
	} else if (jobStatus == "4") {
		clearInterval(timerID);

		ComShowCodeMessage("PRI00201");
		return false;
	}
}

var isClear = true;

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * if (validateForm(sheetObj, document.form, IBSAVE)) {
 * 	로직처리;
 * }
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이은섭
 * @version 2009.08.27
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC01: // Check
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}

		isClear = true;

		var prevCmdtRow = sheetObj.HeaderRows;
		var prevRouteRowOPnt = sheetObj.HeaderRows;
		var prevRouteRowOVia = sheetObj.HeaderRows;
		var prevRouteRowDVia = sheetObj.HeaderRows;
		var prevRouteRowDPnt = sheetObj.HeaderRows;
		var prevRouteRowRate = sheetObj.HeaderRows;

		var chkMdtryCmdt = true;
		var chkMdtryOrgPnt = true;
		var chkMdtryOrgVia = true;
		var chkMdtryDestVia = true;
		var chkMdtryDestPnt = true;
		var chkMdtryRate = true;
		var sheetObject2 = sheetObjects[1];

		ComOpenWait(true);
		clearTooltip();

		var cmdtCode = null;
		var cmdtDesc = null;

		var custCode = null;
		var custDesc = null;

		var orgPntCode = null;
		var orgPntDesc = null;
		var orgPntTerm = null;
		var orgPntTrans = null;

		var orgViaCode = null;

		var destViaCode = null;

		var destPntCode = null;
		var destPntDesc = null;
		var destPntTerm = null;
		var destPntTrans = null;

		var perTypeCode = null;
		var cargoTypeCode = null;
		var currCd = null;
		var propRate = 0;
		var ficOrgPropRtAmt = 0;

		var validPerClass = "A,F,O,Q,S,P";
		var perClass = null;

		for ( var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount; i < n; i++) {
			// Commodity Group Mendatory Check.
			if (sheetObj.CellValue(i, "cmdt_dp_seq") != "") {
				if (!chkMdtryCmdt) {
					add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
					isClear = false;
					prevCmdtRow = i;
				} else {
					chkMdtryCmdt = false;
					prevCmdtRow = i;
				}
			}

			// Commodity Check.
			cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
			cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");

			if (!ComIsNull(cmdtCode) || !ComIsNull(cmdtDesc)) {
				chkMdtryCmdt = true;
				if (cmdtCode != "") {
					if (cmdtCode.length != 4 && cmdtCode.length != 5 && cmdtCode.length != 6) {
						add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "4 or 5 or 6"));
						isClear = false;
					}
					var cmdt_rout = sheetObj.CellValue(i, "cmdt_rout");
					if(!ComIsNull(cmdt_rout)) {
						var s = cmdt_rout.split("|");
						if(ComIsNull(s[0])) {
							add2Tooltip(i, "cmdt_dp_seq", ComGetMsg("PRI00316", "CMDT Seq."));
							isClear = false;
						}
					}
				} else if (cmdtCode == "" && cmdtDesc != "") {
					add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
					isClear = false;
				}
			}
			
			if(!ComIsNull(sheetObj.CellValue(i, "cmdt_dp_seq"))) {
				if(ComIsNull(sheetObj.CellValue(i, "rout_dp_seq"))) {
					add2Tooltip(i, "rout_dp_seq", ComGetMsg("PRI00316", "Route Seq."));
					isClear = false;
				}
			}

			// Actual Customer Check.
			custCode = sheetObj.CellValue(i, "cust_seq");
			custDesc = sheetObj.CellValue(i, "cust_lgl_eng_nm");
			if (custCode != "") {
				if (custCode.length <= 2 || custCode.length > 8) {
					add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
					isClear = false;
				}
			} else if (custCode == "" && custDesc != "") {
				add2Tooltip(i, "cust_seq", ComGetMsg("PRI00335", "Customer Code"));
				isClear = false;
			}

			// Origin Point Mendatory Check.
			if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
				if (!chkMdtryOrgPnt) {
					add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
					add2Tooltip(prevRouteRowOPnt, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
					isClear = false;
					prevRouteRowOPnt = i;
				} else {
					chkMdtryOrgPnt = false;
					prevRouteRowOPnt = i;
				}
			}

			// Origin Point Check.
			orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
			orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
			orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
			orgPntTrans = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");

			if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "" || orgPntTrans != ""
					|| sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
				chkMdtryOrgPnt = true;

				if (orgPntCode != "") {
					if (orgPntCode.length != 4 && orgPntCode.length != 5) {
						add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
						isClear = false;
					}
				} else {
					add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Origin Code"));
					isClear = false;
				}

				if (orgPntTerm == "") {
					if (sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "") {
						add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
						isClear = false;
					} else {
						add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
						isClear = false;
					}
				}

				if (orgPntTrans == "" && sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
					add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
					isClear = false;
				}
			}

			// Origin Via Check.
			orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");

			if (orgViaCode != "") {
				chkMdtryOrgVia = true;
				if (orgViaCode.length != 4 && orgViaCode.length != 5) {
					add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
					isClear = false;
				}
			}


			// Destination Via Check.
			destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");

			if (destViaCode != "") {
				chkMdtryDestVia = true;
				if (destViaCode.length != 4 && destViaCode.length != 5) {
					add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
					isClear = false;
				}
			}

			// Destination Point Mendatory Check.
			if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
				if (!chkMdtryDestPnt) {
					add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
					add2Tooltip(prevRouteRowDPnt, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
					isClear = false;
					prevRouteRowDPnt = i;
				} else {
					chkMdtryDestPnt = false;
					prevRouteRowDPnt = i;
				}
			}

			// Destination Point Check.
			destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
			destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
			destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
			destPntTrans = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");

			if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "" || destPntTrans != ""
					|| sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
				chkMdtryDestPnt = true;
				if (destPntCode != "") {
					if (destPntCode.length != 4 && destPntCode.length != 5) {
						add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
						isClear = false;
					}
				} else {
					add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Destination Code"));
					isClear = false;
				}

				if (destPntTerm == "") {
					if (sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "") {
						add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
						isClear = false;
					} else {
						add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
						isClear = false;
					}
				}

				if (destPntTrans == "" && sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
					add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
					isClear = false;
				}
			}

			// Rate Mendatory Check.
			if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
				if (!chkMdtryRate) {
					add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "prop_frt_rt_amt", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, rateGuideObj.origin.fic_prop_rt_amt, ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, rateGuideObj.destination.fic_prop_rt_amt, ComGetMsg("PRI00316", "Rate"));
					isClear = false;
					prevRouteRowRate = i;
				} else {
					chkMdtryRate = false;
					prevRouteRowRate = i;
				}
			}
			
			
			

			// Rate & Surcharge Check.
			perTypeCode = sheetObj.CellValue(i, "rat_ut_cd");
			cargoTypeCode = sheetObj.CellValue(i, "prc_cgo_tp_cd");
			currCd = sheetObj.CellValue(i, "curr_cd");
			
			propRate = sheetObj.CellValue(i, "prop_frt_rt_amt");
			ficOrgPropRtAmt = sheetObj.CellValue(i, rateGuideObj.origin.fic_prop_rt_amt);
			ficDestPropRtAmt = sheetObj.CellValue(i, rateGuideObj.destination.fic_prop_rt_amt);
			
			if (perTypeCode != "" || cargoTypeCode != "" || propRate != "" || currCd != "") {
				chkMdtryRate = true;
				if (perTypeCode == "") {
					add2Tooltip(i, "rat_ut_cd", ComGetMsg("PRI00335", "PER"));
					isClear = false;
				}
				if (cargoTypeCode == "") {
					add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI00335", "Cargo Type"));
					isClear = false;
				}
				
				if(currCd == "") {
					add2Tooltip(i, "curr_cd", ComGetMsg("PRI00335", "CUR"));
					isClear = false;
				}
				
				if (propRate == "") {
					add2Tooltip(i, "prop_frt_rt_amt", ComGetMsg("PRI00335", "Rate"));
					isClear = false;
				} else if (propRate != "" && parseFloat(propRate) <= 0.00) {
					add2Tooltip(i, "prop_frt_rt_amt", ComGetMsg("PRI00321", "Rate", "0"));
					isClear = false;
				} else if (propRate != "" && parseFloat(propRate) >= 9999999.99) {
					add2Tooltip(i, "prop_frt_rt_amt", ComGetMsg("PRI00336", "Rate", "9999999.99"));
					isClear = false;
				} else {
				}

				var OrgCyDorRtTpCdVal = funcGetCYDorRtTpCd(sheetObj.CellValue(i, "cmdt_rout"), v_origin);
				var DestCyDorRtTpCdVal = funcGetCYDorRtTpCd(sheetObj.CellValue(i, "cmdt_rout"), v_destination);
				
				
				if(!ComIsNull(ficOrgPropRtAmt) && parseFloat(ficOrgPropRtAmt) <= 0.00 && OrgCyDorRtTpCdVal == 'D') {
					add2Tooltip(i, rateGuideObj.origin.fic_prop_rt_amt, ComGetMsg("PRI00321", "Rate", "0"));
					isClear = false;
				} else if(!ComIsNull(ficOrgPropRtAmt) && parseFloat(ficOrgPropRtAmt) >= 9999999.99 && OrgCyDorRtTpCdVal == 'D') {
					add2Tooltip(i, rateGuideObj.origin.fic_prop_rt_amt, ComGetMsg("PRI00336", "Rate", "9999999.99"));
					isClear = false;
				}
				
				if(!ComIsNull(ficDestPropRtAmt) && parseFloat(ficDestPropRtAmt) <= 0.00 && DestCyDorRtTpCdVal == 'D') {
					add2Tooltip(i, rateGuideObj.destination.fic_prop_rt_amt, ComGetMsg("PRI00321", "Rate", "0"));
					isClear = false;
				} else if(!ComIsNull(ficDestPropRtAmt) && parseFloat(ficDestPropRtAmt) >= 9999999.99 && DestCyDorRtTpCdVal == 'D') {
					add2Tooltip(i, rateGuideObj.destination.fic_prop_rt_amt, ComGetMsg("PRI00336", "Rate", "9999999.99"));
					isClear = false;
				}
				
				if (perTypeCode != "" && cargoTypeCode != "") {
					if (cargoTypeCode == "AK") {
						perClass = perTypeCode.charAt(0);
						if (validPerClass.indexOf(perClass) < 0) {
							add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI08003"));
							isClear = false;
						}
					}
				}
			}

			/**
			 * MDM_LOCATION CALL_PORT_FLG='Y'인경우는 입력 불가 <BR>
			 * 단 Term이 Door인 경우는 제외.
			 */
			var org_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
			var org_rcv_de_term_nm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
			var org_prc_trsp_mod_nm = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");
			var org_rout_via_port_def_cd = sheetObj.CellValue(i, "org_rout_via_port_def_cd");

			var dest_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
			var dest_rcv_de_term_nm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
			var dest_prc_trsp_mod_nm = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");
			var dest_rout_via_port_def_cd = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
			
			var org_cy_dor_rt_tp_cd =  sheetObj.CellValue(i, 'org_cy_dor_rt_tp_cd');
			var dest_cy_dor_rt_tp_cd =  sheetObj.CellValue(i, 'dest_cy_dor_rt_tp_cd');
			// 같은 LOCATION GROUP만 여러건 넣을수 있다. ROUTE POPUP에서 서로 다른 LOCATION을 넣으려 할때
			if (!ComIsNull(org_rout_pnt_loc_def_cd)) {
				var checkGroupCyDoor = CheckGroupNoCyDoor(i, sheetObj.CellValue(i, rateGuideObj.origin.group_no), sheetObj.CellValue(i, rateGuideObj.origin.cy_dor_rt_tp_cd), v_origin);
				if (!checkGroupCyDoor[1]) {
					if(checkGroupCyDoor[0] == 1 || checkGroupCyDoor[0] == 3 ) {
						add2Tooltip(i, rateGuideObj.origin.group_no, ComGetMsg("PRI07019"));
						isClear = false;
					} else if(checkGroupCyDoor[0] == 2 ) {
						add2Tooltip(i, 'org_rout_pnt_loc_def_cd', ComGetMsg("PRI07038"));
						isClear = false;
					}
				}

				if (ComIsNull(org_rcv_de_term_nm)) {
					add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00316", 'Origin Term'));
					isClear = false;
				}
				
				if (ComIsNull(org_rout_via_port_def_cd) && org_cy_dor_rt_tp_cd == 'D') {
					add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", 'Origin Via'));
					isClear = false;
				}
				
				if (ComIsNull(org_prc_trsp_mod_nm) && org_cy_dor_rt_tp_cd == 'D') {
					add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00316", 'Origin Transmode'));
					isClear = false;
				}
				if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, true, v_origin, org_rout_pnt_loc_def_cd, org_rcv_de_term_nm, org_prc_trsp_mod_nm, org_rout_via_port_def_cd)) {
					add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
					add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00302"));
					add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
					add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00302"));
					isClear = false;
				}
			} else {
				if (!ComIsNull(org_rout_via_port_def_cd)) {
					add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", 'Origin Code'));
					isClear = false;
				}
			}

			// 같은 LOCATION GROUP만 여러건 넣을수 있다. ROUTE POPUP에서 서로 다른 LOCATION을 넣으려 할때
			if (dest_rout_pnt_loc_def_cd != '') {
				var checkGroupCyDoor = CheckGroupNoCyDoor(i, sheetObj.CellValue(i, rateGuideObj.destination.group_no), sheetObj.CellValue(i, rateGuideObj.destination.cy_dor_rt_tp_cd), v_destination);
				if (!checkGroupCyDoor[1]) {
					if(checkGroupCyDoor[0] == 1 || checkGroupCyDoor[0] == 3 ) {
						add2Tooltip(i, rateGuideObj.destination.group_no, ComGetMsg("PRI07019"));
						isClear = false;
					} else if(checkGroupCyDoor[0] == 2 ) {
						add2Tooltip(i, 'dest_rout_pnt_loc_def_cd', ComGetMsg("PRI07038"));
						isClear = false;
					}
				}

				if (ComIsNull(dest_rcv_de_term_nm)) {
					add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", 'Destination Term'));
					isClear = false;
				}
				if (ComIsNull(dest_rout_via_port_def_cd)  && dest_cy_dor_rt_tp_cd == 'D') {
					add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", 'Destination Via.'));
					isClear = false;
				}
				if (ComIsNull(dest_prc_trsp_mod_nm)  && dest_cy_dor_rt_tp_cd == 'D') {
					add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00316", 'Destination Transmode'));
					isClear = false;
				}

				if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, true, v_destination, dest_rout_pnt_loc_def_cd, dest_rcv_de_term_nm, dest_prc_trsp_mod_nm, dest_rout_via_port_def_cd)) {
					add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
					add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00302"));
					add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
					add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00302"));
					isClear = false;
				}
			} else {
				if (!ComIsNull(dest_rout_via_port_def_cd)) {
					add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", 'Origin Code'));
					isClear = false;
				}
			}

			if (!ComIsNull(sheetObj.CellValue(i, 'rat_ut_cd')) && !ComIsNull(sheetObj.CellValue(i, 'prc_cgo_tp_cd'))) {
				if (!funcDupCheckPerCargoType(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, sheetObj.CellValue(i, 'rat_ut_cd'), sheetObj.CellValue(i, 'prc_cgo_tp_cd'))) {
					add2Tooltip(i, "rat_ut_cd", ComGetMsg("PRI00302"));
					add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI00302"));
					isClear = false;
				}
			}
			
			if(sheetObj.CellValue(i, 'org_cy_dor_rt_tp_cd') == sheetObj.CellValue(i, 'dest_cy_dor_rt_tp_cd') && sheetObj.CellValue(i, 'org_cy_dor_rt_tp_cd') == 'C') {
				add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI07029"));
				add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI07029"));
				add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI07029"));
				
				add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI07029"));
				add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI07029"));
				add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI07029"));
				isClear = false;
			}
		}
		if (!chkMdtryCmdt) {
			add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
			isClear = false;
		}
		if (!chkMdtryOrgPnt) {
			add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
			add2Tooltip(prevRouteRowOPnt, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
			isClear = false;
		}
		if (!chkMdtryDestPnt) {
			add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
			add2Tooltip(prevRouteRowDPnt, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Term"));
			isClear = false;
		}
		if (!chkMdtryRate) {
			add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
			add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
			add2Tooltip(prevRouteRowRate, "prop_frt_rt_amt", ComGetMsg("PRI00316", "Rate"));
			add2Tooltip(prevRouteRowRate, rateGuideObj.origin.fic_prop_rt_amt, ComGetMsg("PRI00316", "Rate"));
			add2Tooltip(prevRouteRowRate, rateGuideObj.destination.fic_prop_rt_amt, ComGetMsg("PRI00316", "Rate"));
			isClear = false;
		}

		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
		var sXml = sheetObject2.GetSearchXml("ESM_PRI_2069GS.do", sParam);
		var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");

		if (arrErr != null && arrErr.length > 0) {
			isClear = false;
			var msg = ComGetMsg("PRI00315");
			for ( var i = 0; i < arrErr.length; i++) {
				add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
			}
		}
		ComOpenWait(false);
		document.body.scroll = "no";
		if (isClear) {
			toggleButtons("CHECK");
			return true;
		} else {
			toggleButtons("LOAD");
			return false;
		}
		break;

	case IBSAVE: // 저장
		return true;
		break;
	case IBSEARCH_ASYNC07:
		return true;
		break;
	}
}

function clearTooltip() {
	var sheetObj = sheetObjects[0];
	var n = sheetObj.Rows;
	var m = sheetObj.LastCol;
	var i = sheetObj.HeaderRows;
	var j = 0;
	for (i = sheetObj.HeaderRows; i < n; i++) {
		for (j = 0; j <= m; j++) {
			if (sheetObj.ToolTipText(i, j) != "") {
				if (sheetObj.CellEditable(i, j)) {
					sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
				} else {
					sheetObj.CellBackColor(i, j) = sheetObj.UnEditableColor;
				}
				sheetObj.ToolTipText(i, j) = "";
			}
		}
	}
}

function add2Tooltip(row, col, msg) {
	var sheetObj = sheetObjects[0];

	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255, 0, 0);
	sheetObj.ToolTipText(row, col) += "\n- " + msg;
}

/**
 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {string} mode 필수 사용자 권한이나 모드
 * @author 이은섭
 * @version 2012.10.11
 */
function toggleButtons(step) {
	switch (step) {
	case "INIT":
		ComBtnEnable("btn_openfile");
		ComBtnDisable("btn_check");
		ComBtnDisable("btn_save");
		break;
	case "LOAD":
		ComBtnEnable("btn_openfile");
		ComBtnEnable("btn_check");
		ComBtnDisable("btn_save");
		break;
	case "CHECK":
		ComBtnEnable("btn_openfile");
		ComBtnEnable("btn_check");
		ComBtnEnable("btn_save");
		break;
	}
}
/**
 * Excel Load후 처리 이벤트 1, Guide Line 정보 조회 2, rout_pnt_loc_def_cd 당 Base port editable 처리 여부 체크
 */
function sheet1_OnLoadExcel(obj) {
	obj.Redraw = false;
	var formObj = document.form;
	var headerRows = obj.HeaderRows;
	var rows = obj.Rows;
	var cmdt_dp_seq = "";
	var rout_dp_seq = "";
	var before_cmdt_dp_seq = "";
	var before_rout_dp_seq = "";
	
	var orgRcvCdArray = new Array();
	var orgRcvTextArray = new Array();
	
	var destRcvCdArray = new Array();
	var destRcvTextArray = new Array();
	
	for ( var i = obj.HeaderRows; i < rows; i++) {
		cmdt_dp_seq = obj.CellValue(i, 'cmdt_dp_seq');
		rout_dp_seq = obj.CellValue(i, 'rout_dp_seq');
		if(i == obj.HeaderRows) {
			orgRcvCdArray = obj.GetComboInfo(obj.HeaderRows, 'org_rcv_de_term_nm', 'Code').split("|");
			orgRcvTextArray = obj.GetComboInfo(obj.HeaderRows, 'org_rcv_de_term_nm', 'Text').split("|");
			destRcvCdArray = obj.GetComboInfo(obj.HeaderRows, 'dest_rcv_de_term_nm', 'Code').split("|");
			destRcvTextArray = obj.GetComboInfo(obj.HeaderRows, 'dest_rcv_de_term_nm', 'Text').split("|");
		}

		if (cmdt_dp_seq != '') {
			before_cmdt_dp_seq = cmdt_dp_seq;
		}
		if (rout_dp_seq != '') {
			before_rout_dp_seq = rout_dp_seq;
		}
		if(ComIsNull(obj.CellValue(i, 'curr_cd'))) {
			obj.CellText(i, 'curr_cd') = '';
		}
		
		if(ComIsNull(obj.CellValue(i,"org_rcv_de_term_nm"))) {
			var orgRcvDeTemText = obj.CellText(i,"org_rcv_de_term_nm");
			for(var g = 0; g < orgRcvTextArray.length; g++) {
				if(!ComIsNull(orgRcvTextArray[g]) && ComTrimAll(orgRcvDeTemText.toUpperCase()) == ComTrimAll(orgRcvTextArray[g].toUpperCase())) {
					obj.CellValue2(i, 'org_rcv_de_term_nm') = orgRcvCdArray[g];
					break;
				}
			}
		}
		
		if(ComIsNull(obj.CellValue(i,"dest_rcv_de_term_nm"))) {
			var destRcvDeTemText = obj.CellText(i,"dest_rcv_de_term_nm");
			for(var g = 0; g < destRcvTextArray.length; g++) {
				if(!ComIsNull(destRcvTextArray[g]) && ComTrimAll(destRcvDeTemText.toUpperCase()) == ComTrimAll(destRcvTextArray[g].toUpperCase())) {
					obj.CellValue2(i, 'dest_rcv_de_term_nm') = destRcvCdArray[g];
					break;
				}
			}
		}
		obj.CellValue2(i, 'h_seq') = i - headerRows + 1;
		obj.CellValue2(i, 'cmdt_rout') = before_cmdt_dp_seq + "|" + before_rout_dp_seq;
	}

	// Addon , IHC 값을 조회한다.
	funcSearchGuidelineRates(obj, formObj);
	obj.Redraw = true;
}
/**
 * ORG_CY_DOR_RT_TP_CD, DEST_CY_DOR_RT_TP_CD 생성
 */
function setCyDoorRtTpCd(sheetObj, Row, inOrgDestTpCd) {
	var rout_pnt_loc_def_cd = '';
	if(inOrgDestTpCd == v_origin) {
		rout_pnt_loc_def_cd = sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd');
	} else {
		rout_pnt_loc_def_cd = sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd');
	}
	var locType='G';
	if(rout_pnt_loc_def_cd.length > 4) {
		locType = 'L';
	}
	searchCYDoorLocationCheck(sheetObj, Row, rout_pnt_loc_def_cd, locType, inOrgDestTpCd);	
}

/**
 * Origin Guide 정보 조회
 */
function sheet3_OnSearchEnd(sheetObj) {
	sheetObjects[0].Redraw = false;
	var obj = sheetObjects[0];
	var headerRows = obj.HeaderRows;
	var rows = obj.Rows;
	var formObj = document.form;
	for ( var i = headerRows; i < rows; i++) {
		if (obj.CellValue(i, 'rat_ut_cd') == '') {
			continue;
		}
		funcGuideLineAmount(sheetObjects[0], i, v_origin);
	}
	
	headerRows = sheetObj.HeaderRows;
	rows = sheetObj.Rows;
	var h_seq_row = '';
	for ( var i = headerRows; i < rows; i++) {
		h_seq_row = obj.FindText("h_seq", sheetObj.CellValue(i, "h_seq"));
		obj.CellValue2(h_seq_row, rateGuideObj.origin.group_no) = sheetObj.CellValue(i, "group_no");
		
		setCyDoorRtTpCd(obj, h_seq_row, v_origin);
		sheetObj.CellValue2(i, 'cy_dor_rt_tp_cd') = obj.CellValue(h_seq_row, 'org_cy_dor_rt_tp_cd');
	}
	sheetObjects[0].Redraw = true;
}


/**
 * Dest Guide 정보 조회
 */
function sheet4_OnSearchEnd(sheetObj) {
	sheetObjects[0].Redraw = false;
	var obj = sheetObjects[0];
	var headerRows = obj.HeaderRows;
	var rows = obj.Rows;
	var formObj = document.form;
	for ( var i = headerRows; i < rows; i++) {
		if (obj.CellValue(i, 'rat_ut_cd') == '') {
			continue;
		}
		funcGuideLineAmount(sheetObjects[0], i, v_destination);
	}
	headerRows = sheetObj.HeaderRows;
	rows = sheetObj.Rows;
	var h_seq_row = '';
	for ( var i = headerRows; i < rows; i++) {
		h_seq_row = obj.FindText("h_seq", sheetObj.CellValue(i, "h_seq"));
		obj.CellValue2(h_seq_row, rateGuideObj.destination.group_no) = sheetObj.CellValue(i, "group_no");
		
		setCyDoorRtTpCd(obj, h_seq_row, v_destination);
		sheetObj.CellValue2(i, 'cy_dor_rt_tp_cd') = obj.CellValue(h_seq_row, 'dest_cy_dor_rt_tp_cd');
	}
	sheetObjects[0].Redraw = true;
}

/**
 * Addon, IHC 금액 전체를 조회 한다.
 */
function funcSearchGuidelineRates(sheetObj, formObj) {
	var sheetParam = funcGetSaveParamsFromSheet(sheetObj, formObj, v_origin);
	formObj.f_cmd.value = SEARCH02;
	var sParam = FormQueryString(formObj);
	sheetObjects[2].DoSearch("ESM_PRI_2069GS.do", sParam + "&" + sheetParam + "&in_org_dest_tp_cd=" + v_origin);
	
	sheetParam = funcGetSaveParamsFromSheet(sheetObj, formObj, v_destination);
	sheetObjects[3].DoSearch("ESM_PRI_2069GS.do", sParam + "&" + sheetParam + "&in_org_dest_tp_cd=" + v_destination);
}

/**
 * 
 */
function funcGetSaveParamsFromSheet(sheetObj, formObj, inOrgDestTpCd) {
	var sheetParam = "";
	var orgParamCols = "ibflag|h_seq|cmdt_dp_seq|rout_dp_seq|org_rout_pnt_loc_def_cd|org_rout_via_port_def_cd|org_rcv_de_term_nm|org_prc_trsp_mod_nm";
	var destParamCols = "ibflag|h_seq|cmdt_dp_seq|rout_dp_seq|dest_rout_pnt_loc_def_cd|dest_rout_via_port_def_cd|dest_rcv_de_term_nm|dest_prc_trsp_mod_nm";

	var arrParamCols = [];
	var colSize = 0;
	var checkColName = "";
	var keyStr = "";
	var rowCount = sheetObj.HeaderRows + sheetObj.Rows;

	if (inOrgDestTpCd == v_origin) {
		arrParamCols = orgParamCols.split("|");
		checkColName = "org_rout_pnt_loc_def_cd";
	} else {
		arrParamCols = destParamCols.split("|");
		checkColName = "dest_rout_pnt_loc_def_cd";
	}
	colSize = arrParamCols.length;
	for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
		if (sheetObj.CellValue(i, checkColName) != '') {
			for ( var iCol = 0; iCol < colSize; iCol++) {
				if (sheetObj.CellValue(i, "h_seq") == undefined) {
					break;
				}
				if (arrParamCols[iCol] == "cmdt_dp_seq") {
					keyStr = sheetObj.CellValue(i, "cmdt_rout");
					keyStr = keyStr.split("|");
					sheetParam = sheetParam + "&cmdt_dp_seq=" + keyStr[0];
					sheetParam = sheetParam + "&rout_dp_seq=" + keyStr[1];
				} else if (arrParamCols[iCol] != "rout_dp_seq") {
					sheetParam = sheetParam + "&" + arrParamCols[iCol] + "=" + sheetObj.CellValue(i, arrParamCols[iCol]);
				}
			}
		}
	}
	return sheetParam;
}

/**
 * Guide의 최저 금액을 구해 Sheet1에 추가
 */
function funcGuideLineAmount(targetSheet, Row, inOrgDestTpCd) {
	var formObj = document.form;
	var svcScpCd = formObj.svc_scp_cd.value;
	var sheetObj;
	var rateSheet; 
	if(inOrgDestTpCd == v_origin) {
		sheetObj = sheetObjects[2];
		rateSheet = rateGuideObj.origin;
	} else {
		sheetObj = sheetObjects[3];
		rateSheet = rateGuideObj.destination;
	}
	
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	var amart_arr = new Array();
	var ratUtCd = targetSheet.CellValue(Row, 'rat_ut_cd');
	var prcCgoTpCd = targetSheet.CellValue(Row, 'prc_cgo_tp_cd');
	var ficGlineInfo = new Array();
	var minAmt = '';
	var minLocAmt = '';
	var cmdtSeqRoutDpSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	if (cmdtSeqRoutDpSeq == undefined) {
		return;
	}
	
	var findRow = sheetObj.FindText("cmdt_rout", cmdtSeqRoutDpSeq);
	if (findRow > -1) {
		for ( var i = findRow; i < r; i++) {
			if (sheetObj.CellValue(i, 'cmdt_rout') == cmdtSeqRoutDpSeq) {
				var rsltAmt = '';
				var rsltLocAmt = '';
				var locCurrCd = sheetObj.CellValue(i, "loc_curr_cd");
				var ficRtUseStsCd = sheetObj.CellValue(i, "fic_rt_use_sts_cd");
				var optmTrspModFlg = sheetObj.CellValue(i, "optm_trsp_mod_flg");
				if (ratUtCd == 'D2' || ratUtCd == 'R2') {
					if (prcCgoTpCd == "DR") {
						rsltAmt = sheetObj.CellValue(i, "dr_20ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "dr_loc_20ft_amt");
					} else if (prcCgoTpCd == "DG") {
						rsltAmt = sheetObj.CellValue(i, "dg_20ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "dg_loc_20ft_amt");
					} else if (prcCgoTpCd == "RF") {
						rsltAmt = sheetObj.CellValue(i, "rf_20ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "rf_loc_20ft_amt");
					} else {
						rsltAmt = -1;
					}
				} else if (ratUtCd == 'D4' || ratUtCd == 'R4' || ratUtCd == 'D5' || ratUtCd == 'R5') {
					if (prcCgoTpCd == "DR") {
						rsltAmt = sheetObj.CellValue(i, "dr_40ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "dr_loc_40ft_amt");
					} else if (prcCgoTpCd == "DG") {
						rsltAmt = sheetObj.CellValue(i, "dg_40ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "dg_loc_40ft_amt");
					} else if (prcCgoTpCd == "RF") {
						rsltAmt = sheetObj.CellValue(i, "rf_40ft_amt");
						rsltLocAmt = sheetObj.CellValue(i, "rf_loc_40ft_amt");
					} else {
						rsltAmt = -1;
					}
				} else {
					rsltAmt = "N/A";
					ficRtUseStsCd = "";
					optmTrspModFlg = "";
					rsltLocAmt = 'N/A';
				}

				if (ficRtUseStsCd != "S" || ComIsEmpty(rsltAmt)) {
					rsltAmt = "N/A";
					minAmt = "N/A";
					minLocAmt = "N/A";
				}
				if ((rsltAmt != -1 && rsltAmt != "N/A" && rsltAmt != '') && minAmt != 'N/A') {
					if (parseFloat(minAmt) <= parseFloat(rsltAmt)) {
						ficGlineInfo[0] = minAmt;
						ficGlineInfo[1] = ficRtUseStsCd;
						ficGlineInfo[2] = optmTrspModFlg;
						ficGlineInfo[3] = minLocAmt;
					} else {
						minAmt = rsltAmt;
						minLocAmt = rsltLocAmt;
						ficGlineInfo[0] = minAmt;
						ficGlineInfo[1] = ficRtUseStsCd;
						ficGlineInfo[2] = optmTrspModFlg;
						ficGlineInfo[3] = rsltLocAmt;
					}
				} else {
					ficGlineInfo[0] = "N/A";
					ficGlineInfo[1] = ficRtUseStsCd;
					ficGlineInfo[2] = optmTrspModFlg;
					ficGlineInfo[3] = "N/A";
				}

			} else {
				break;
			}
		}
	}
	if (ficGlineInfo.length > 0) {
		if (ratUtCd != '' && prcCgoTpCd != '') {
			targetSheet.CellValue2(Row, rateSheet.fic_gline_rt_amt) = ficGlineInfo[0];
			if (ficGlineInfo[0] == 'N/A') {
				targetSheet.CellValue(Row, rateSheet.fic_prop_rt_amt) = 0.00;
			} else {
				if(targetSheet.CellValue(Row, 'curr_cd') == 'USD') {
					targetSheet.CellValue(Row, rateSheet.fic_prop_rt_amt) = ficGlineInfo[0];
				} else {
					if(targetSheet.CellValue(Row, 'curr_cd') == locCurrCd) {
						targetSheet.CellValue(Row, rateSheet.fic_prop_rt_amt) = ficGlineInfo[3];
					} else {
						targetSheet.CellValue(Row, rateSheet.fic_prop_rt_amt) = changeCurrency(ficGlineInfo[0], targetSheet.CellValue(Row, 'curr_cd'));
					}
				}
			}
			targetSheet.CellValue(Row, rateSheet.fic_rt_use_sts_cd) = ficGlineInfo[1];
			targetSheet.CellValue(Row, rateSheet.optm_trsp_mod_flg) = ficGlineInfo[2];
		} else {
			targetSheet.CellValue2(Row, rateSheet.fic_prop_rt_amt) = '';
			targetSheet.CellValue2(Row, rateSheet.fic_gline_rt_amt) = '';
			targetSheet.CellValue2(Row, rateSheet.fic_rt_use_sts_cd) = '';
			targetSheet.CellValue2(Row, rateSheet.optm_trsp_mod_flg) = '';
			targetSheet.CellValue2(Row, "prc_cgo_tp_cd") = '';
		}
	}
}

/**
 * 환율 변환 처리.
 */
function changeCurrency(inFicGlineRtAmt, inCurrCd) {
	var rsltVal = 0.00;
	if(!ComIsNull(inCurrCd)) {
		var params = "f_cmd=" + SEARCH09;
			params += "&fic_gline_rt_amt=" + inFicGlineRtAmt;
			params += "&curr_cd=" + inCurrCd;
		var sXml = sheetObjects[1].getSaveXml("ESM_PRI_2003_13GS.do", params);
		rsltVal = ComGetEtcData(sXml, "local_fic_gline_rt_amt");
	}
	return rsltVal;
}


/*
 * 
 */
function initFicRoute(sheetObj, Row, Col) {
	var formObj = document.form;
	var saveName = sheetObj.ColSaveName(Col);
	sheetObj.Redraw = false;
	switch (saveName) {
	case "org_rout_pnt_loc_def_cd":
		if (sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellValue2(Row, "org_cy_dor_rt_tp_cd") = "";	
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
			sheetObj.CellValue2(Row, rateGuideObj.origin.group_no) = '';
			sheetObj.CellValue2(Row, "org_rcv_de_term_nm") = '';
			sheetObj.CellValue2(Row, "org_prc_trsp_mod_nm") = '';
		}
		sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = '';
		sheetObj.CellValue(Row, rateGuideObj.origin.base_port_list) = '';
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		break;
	case "dest_rout_pnt_loc_def_cd":
		if (sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellValue2(Row, "dest_cy_dor_rt_tp_cd") = "";	
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
			sheetObj.CellValue2(Row, rateGuideObj.destination.group_no) = '';
			sheetObj.CellValue2(Row, "dest_rcv_de_term_nm") = '';
			sheetObj.CellValue2(Row, "dest_prc_trsp_mod_nm") = '';
		}
		
		sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = '';
		sheetObj.CellValue(Row, rateGuideObj.destination.base_port_list) = '';
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC10);
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
		break;
	case "org_rout_via_port_def_cd":
		sheetObj.CellValue2(Row, rateGuideObj.origin.group_no) = "";
		sheetObj.CellValue2(Row, "org_prc_trsp_mod_nm") = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.fic_gline_rt_amt) = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.base_port_list) = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.optm_trsp_mod_flg) = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.fic_rout_cmb_tp_cd) = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.fic_rt_use_sts_cd) = "";
		sheetObj.CellValue2(Row, rateGuideObj.origin.fic_gline_upd_dt) = "";
		break;
	case "dest_rout_via_port_def_cd":
		sheetObj.CellValue2(Row, rateGuideObj.destination.group_no) = "";
		sheetObj.CellValue2(Row, "dest_prc_trsp_mod_nm") = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.fic_gline_rt_amt) = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.base_port_list) = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.optm_trsp_mod_flg) = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.fic_rout_cmb_tp_cd) = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.fic_rt_use_sts_cd) = "";
		sheetObj.CellValue2(Row, rateGuideObj.destination.fic_gline_upd_dt) = "";
		break;
	}
	sheetObj.Redraw = true;
}

/**
 * IBSEARCH_ASYNC06
 */
function funcGetBasePortList(sheetObj, formObj, Row, inOrgDestTpCd) {
	var sender = sheetObjects[1];
	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	if (inOrgDestTpCd == v_origin) {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "org_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "org_prc_trsp_mod_nm") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "org_prc_trsp_mod_nm");
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "dest_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm");
	}
	sParam += "&prc_io_bnd_cd="  + inOrgDestTpCd;
	var sXml = sender.getSearchXml("ESM_PRI_2030GS.do", sParam);
	var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
}

/**
 * IBSEARCH_ASYNC07
 */
function funcGetBasePortTrspModeCd(sheetObj, formObj, Row, inOrgDestTpCd) {
	var sender = sheetObjects[1];
	formObj.f_cmd.value = SEARCH01;
	var rateSheet;
	var sParam = FormQueryString(formObj);
	if (inOrgDestTpCd == v_origin) {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "org_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "org_rout_via_port_def_cd") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
		
		rateSheet = rateGuideObj.origin;
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "dest_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "dest_rout_via_port_def_cd") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
		
		rateSheet = rateGuideObj.destination;
	}
	sParam += "&prc_io_bnd_cd="  + inOrgDestTpCd;	
	var sXml = sender.getSearchXml("ESM_PRI_2030GS.do", sParam);
	var saveName = "base_port_list|prc_trsp_mod_cd";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		sheetObj.CellValue2(Row, rateSheet.base_port_list) = arrDesc[0][0];
		if (inOrgDestTpCd == v_origin) {
			sheetObj.CellValue(Row, "org_prc_trsp_mod_nm") = arrDesc[0][1];
		} else {
			sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm") = arrDesc[0][1];
		}
	}
}

/**
 * 가이드라인 정보 조회. , IBSEARCH_ASYNC08
 */
function rate_setting(sheetObj, formObj, Row, insertFlag, inOrgDestTpCd) {
	var sender = sheetObjects[1];
	var pointSheet;
	
	if (inOrgDestTpCd == v_origin) {
		pointSheet = sheetObjects[2];
	} else if (inOrgDestTpCd == v_destination) {
		pointSheet = sheetObjects[3];
	} 

	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	if (inOrgDestTpCd == v_origin) {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '') {
			if (!insertFlag) {
				pointSheet.RowDelete(pointSheet.FindText('h_seq', sheetObj.CellValue(Row, "h_seq")), false);
			}
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "org_prc_trsp_mod_nm");
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '') {
			if (!insertFlag) {
				pointSheet.RowDelete(pointSheet.FindText('h_seq', sheetObj.CellValue(Row, "h_seq")), false);
			}
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm");
	}
	sParam += "&prc_io_bnd_cd="  + inOrgDestTpCd;
	var cmdtRoutSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	var arr_seq = cmdtRoutSeq.split("|");
	var sRow;
	if (insertFlag) {
		sRow = pointSheet.DataInsert();
	} else {
		sRow = pointSheet.FindText('h_seq', sheetObj.CellValue(Row, "h_seq"));
		if (sRow == -1) {
			sRow = pointSheet.DataInsert();
		}
	}
	pointSheet.CellValue2(sRow, 'cmdt_dp_seq') = arr_seq[0];
	pointSheet.CellValue2(sRow, 'rout_dp_seq') = arr_seq[1];
	pointSheet.CellValue2(sRow, 'cmdt_rout') = cmdtRoutSeq;	
	pointSheet.CellValue2(sRow, 'h_seq') = sheetObj.CellValue(Row, "h_seq");
	if (inOrgDestTpCd == v_origin) {
		pointSheet.CellValue2(sRow, 'cy_dor_rt_tp_cd') = sheetObj.CellValue(Row, "org_cy_dor_rt_tp_cd");
	} else {
		pointSheet.CellValue2(sRow, 'cy_dor_rt_tp_cd') = sheetObj.CellValue(Row, "dest_cy_dor_rt_tp_cd");
	}

	var sXml = sender.getSearchXml("ESM_PRI_2030GS.do", sParam);
	var saveName = "fic_rt_use_sts_cd";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		var data = arrDesc[0][0].split("|");
		pointSheet.CellValue2(sRow, "fic_rt_use_sts_cd") = data[0];
		pointSheet.CellValue2(sRow, "fic_rout_cmb_tp_cd") = data[1];
		pointSheet.CellValue2(sRow, "optm_trsp_mod_flg") = data[2];
		if (inOrgDestTpCd == v_origin) {
			pointSheet.CellValue2(sRow, "group_no") = ComTrim(data[3]);
			sheetObj.CellValue2(Row, rateGuideObj.origin.group_no) = ComTrim(data[3]);
		} else {
			pointSheet.CellValue2(sRow, "group_no") = ComTrim(data[3]);
			sheetObj.CellValue2(Row, rateGuideObj.destination.group_no) = ComTrim(data[3]);
		}
		if (data[4]) {
			pointSheet.CellValue2(sRow, "dr_20ft_amt") = data[4];
		}
		if (data[5]) {
			pointSheet.CellValue2(sRow, "rf_20ft_amt") = data[5];
		}
		if (data[6]) {
			pointSheet.CellValue2(sRow, "dg_20ft_amt") = data[6];
		}
		if (data[7]) {
			pointSheet.CellValue2(sRow, "dr_40ft_amt") = data[7];
		}
		if (data[8]) {
			pointSheet.CellValue2(sRow, "rf_40ft_amt") = data[8];
		}
		if (data[9]) {
			pointSheet.CellValue2(sRow, "dg_40ft_amt") = data[9];
		}
		if (data[10]) {
			pointSheet.CellValue2(sRow, "loc_curr_cd") = data[10];
		}
		if (data[11]) {
			pointSheet.CellValue2(sRow, "dr_loc_20ft_amt") = data[11];
		}
		if (data[12]) {
			pointSheet.CellValue2(sRow, "rf_loc_20ft_amt") = data[12];
		}
		if (data[13]) {
			pointSheet.CellValue2(sRow, "dg_loc_20ft_amt") = data[13];
		}
		if (data[14]) {
			pointSheet.CellValue2(sRow, "dr_loc_40ft_amt") = data[14];
		}
		if (data[15]) {
			pointSheet.CellValue2(sRow, "rf_loc_40ft_amt") = data[15];
		}
		if (data[16]) {
			pointSheet.CellValue2(sRow, "dg_loc_40ft_amt") = data[16];
		}
	}

	saveName = "base_port_list|prc_trsp_mod_cd";
	saveNameArr = saveName.split("|");
	arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		pointSheet.CellValue2(sRow, "base_port_list") = arrDesc[0][0];
		pointSheet.CellValue2(sRow, "prc_trsp_mod_cd") = arrDesc[0][1];
	}
	
	if(pointSheet.CellValue(sRow, 'cy_dor_rt_tp_cd') == 'C') {
		clearSheetRate(pointSheet, sRow);
	}
	return true;
}


/**
 * Guide 금액 정보를 조기화.
 */
function clearSheetRate(sheetObj, Row) {
	sheetObj.CellValue2(Row, 'base_port_list') = '';
	sheetObj.CellValue2(Row, 'optm_trsp_mod_flg') = '';
	sheetObj.CellValue2(Row, 'fic_rout_cmb_tp_cd') = '';
	sheetObj.CellValue2(Row, 'fic_rt_use_sts_cd') = '';
	sheetObj.CellValue2(Row, 'fic_gline_upd_dt') = '';
	sheetObj.CellValue2(Row, 'dr_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dr_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'loc_curr_cd') = '';
	sheetObj.CellValue2(Row, 'dr_loc_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_loc_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_loc_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dr_loc_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_loc_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_loc_40ft_amt') = '';
}

/**
 * 그룹 체크
 */
function CheckGroupNoCyDoor(Row, group_no, cyDoorRtTpCd, inOrgDestTpCd) {
	var returnData = new Array();
	var sheetObj;
	if(inOrgDestTpCd == v_origin) {
		sheetObj = sheetObjects[2];
	} else {
		sheetObj = sheetObjects[3];
	}
	
	var formObj = document.form;
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	var amart_arr = new Array();
	var cmdtSeqRoutDpSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	var findRow = sheetObj.FindText("cmdt_rout", cmdtSeqRoutDpSeq);

	var chk = 0;
	if (findRow > -1) {
		for ( var i = findRow; i < r; i++) {
			if (sheetObj.CellValue(i, 'cmdt_rout') == cmdtSeqRoutDpSeq) {
				if(cyDoorRtTpCd == 'D') {
					if (group_no != sheetObj.CellValue(i, 'group_no')) {
						returnData.push(1);
						returnData.push(false);
						return returnData;
					}
					if (sheetObj.CellValue(i, 'group_no') == 'N/A') {
						chk++;
					}
				}
				if (cyDoorRtTpCd != sheetObj.CellValue(i, 'cy_dor_rt_tp_cd') && sheetObj.CellValue(i, 'cy_dor_rt_tp_cd') != '') {
					returnData.push(2);
					returnData.push(false);
					return returnData;
				}
			} else {
				break;
			}
		}
	}
	if (chk > 1) {
		returnData.push(3);
		returnData.push(false);
		return returnData;
	}
	returnData.push(0);
	returnData.push(true);
	return returnData;
}

/**
 * Per, Cargo Type 중복 체크
 * 
 */
function funcDupCheckPerCargoType(sheetObj, cmdtRoutVal, inRow, ratUtCd, cargoType) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	var findRow = sheetObj.FindText("cmdt_rout", cmdtRoutVal);

	for ( var i = findRow; i < r; i++) {
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_rout') != cmdtRoutVal) {
			break;
		}

		if (sheetObj.CellValue(i, 'rat_ut_cd') == ratUtCd && sheetObj.CellValue(i, 'prc_cgo_tp_cd') == cargoType) {
			return false;
		}
	}
	return true;
}

/**
 * Origin, Destination의 중복 체크
 */
function funcDupCheckIHC(sheetObj, cmdtRoutVal, inRow, ihcFlag, originDestGubun, routPntLocDefCd, rcvDeTermCd, prcTrspModCd, basePortCd) {

	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;

	var svcScpCd = document.form.svc_scp_cd.value;
	var findRow = sheetObj.FindText("cmdt_rout", cmdtRoutVal);

	for ( var i = findRow; i < r; i++) {
		var sheet_routPntLocDefCd = '';
		var sheet_rcvDeTermCd = '';
		var sheet_prcTrspModCd = '';
		var sheet_basePortCd = '';
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_rout') != cmdtRoutVal) {
			break;
		}
		if (originDestGubun == 'O') {
			sheet_routPntLocDefCd = sheetObj.CellValue(i, 'org_rout_pnt_loc_def_cd');
			sheet_rcvDeTermCd = sheetObj.CellValue(i, 'org_rcv_de_term_nm');
			sheet_prcTrspModCd = sheetObj.CellValue(i, 'org_prc_trsp_mod_nm');
			sheet_basePortCd = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
		} else {
			sheet_routPntLocDefCd = sheetObj.CellValue(i, 'dest_rout_pnt_loc_def_cd');
			sheet_rcvDeTermCd = sheetObj.CellValue(i, 'dest_rcv_de_term_nm');
			sheet_prcTrspModCd = sheetObj.CellValue(i, 'dest_prc_trsp_mod_nm');
			sheet_basePortCd = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
		}

		if (ihcFlag) {
			if (sheet_routPntLocDefCd == routPntLocDefCd && sheet_rcvDeTermCd == rcvDeTermCd && sheet_prcTrspModCd == prcTrspModCd && sheet_basePortCd == basePortCd) {
				return false;
			}
		} else {
			if (sheet_routPntLocDefCd == routPntLocDefCd && sheet_rcvDeTermCd == rcvDeTermCd && sheet_prcTrspModCd == prcTrspModCd) {
				return false;
			}
		}
	}
	return true;
}

/**
 * IHC가 아닌쪽에 동일한 Router에 동일한 Via가 존재 여부 체크
 */
function funcDupCheckVia(sheetObj, cmdtRoutVal, inRow, originDestGubun, routViaPortDefCd) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	var findRow = sheetObj.FindText("cmdt_rout", cmdtRoutVal);

	var svcScpCd = document.form.svc_scp_cd.value;
	for ( var i = findRow; i < r; i++) {
		var sheet_routPntLocDefCd = '';
		var sheet_rcvDeTermCd = '';
		var sheet_prcTrspModCd = '';
		var sheet_basePortCd = '';
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_rout') != cmdtRoutVal) {
			break;
		}
		if (originDestGubun == 'O') {
			sheet_basePortCd = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
		} else {
			sheet_basePortCd = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
		}

		if (sheet_basePortCd == routViaPortDefCd) {
			return false;
		}
	}
	return true;
}

function funcDupCheckCmdtSeq(sheetObj, inRow, cmdtSeqVal) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	for ( var i = h; i < r; i++) {
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_dp_seq') == cmdtSeqVal) {
			return false;
		}
	}
	return true;
}

/**
 * 예외 지역 조회
 */
function loadExceptionLocation(orgDestTpCd) {
	var formObj = document.form;
	var sender = sheetObjects[1];
	formObj.f_cmd.value = SEARCH26; 	
	var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + orgDestTpCd);
	var arrDesc = ComPriXml2Array(sXml, "cd");
	if(orgDestTpCd == v_origin) {
		orgExptLoc = arrDesc;
	} else {
		destExptLoc = arrDesc;
	}
}



//IHC  체크 CY/Door 체크 로직
function searchCYDoorLocationCheck( sheetObj, row, value , locType, inOrgDestTpCd){
	//먼저 call port flag가 'Y'인지 검사를 해서 'Y'가 아니라면 못들어 간다.
	var cy_dor_rt_tp_cd = 'C';
	var loc_cd = value;
	if(loc_cd.length >= 4) {
		if(inOrgDestTpCd == v_origin) {
			if(sheetObj.CellValue(row, "org_rcv_de_term_nm") != 'D') {
				if(orgExptLoc != null && orgExptLoc !== undefined) {
					for(var i =0; i < orgExptLoc.length; i++) {
						if(loc_cd == orgExptLoc[i]) {
							cy_dor_rt_tp_cd = 'D';
							break;
						}
					}
				}
			} else {
				cy_dor_rt_tp_cd = 'D';
			}
		} else {
			if(sheetObj.CellValue(row, "dest_rcv_de_term_nm") != 'D') {
				if(destExptLoc != null && destExptLoc !== undefined) {
					for(var i =0; i < destExptLoc.length; i++) {
						if(loc_cd == destExptLoc[i]) {
							cy_dor_rt_tp_cd = 'D';
							break;
						}
					}
				}
			} else {
				cy_dor_rt_tp_cd = 'D';
			}
		}
			
		if(cy_dor_rt_tp_cd != 'D') {
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH02;
			var sender = sheetObjects[1];
			var sParam = FormQueryString(formObj);		
			sParam += "&loc_type_cd="+locType+"&loc_cd=" + loc_cd;
			var sXml = sender.getSearchXml("ESM_PRI_2030GS.do", sParam);
			var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
			var arrDesc = ComPriXml2Array(sXml, "loc_cd|call_port_flg");
			if(arrDesc!=null && arrDesc.length > 0){
				loc_cd = arrDesc[0][0];
				var callPortFlg = arrDesc[0][1];
				if(callPortFlg == 'Y') {
					cy_dor_rt_tp_cd = 'C';
				} else {
					cy_dor_rt_tp_cd = 'D';
				}
			}
		}
	} else {
		cy_dor_rt_tp_cd = '';
	}
	if(inOrgDestTpCd == v_origin) {
		sheetObj.CellValue(row, 'org_cy_dor_rt_tp_cd') = cy_dor_rt_tp_cd;
	} else if(inOrgDestTpCd == v_destination) {
		sheetObj.CellValue(row, 'dest_cy_dor_rt_tp_cd') = cy_dor_rt_tp_cd;
	}
	return true;
}

function funcGetCYDorRtTpCd(cmdtRoutVal, inOrgDestTpCd) {
	var sheetObj;
	if(inOrgDestTpCd == v_origin) {
		sheetObj = sheetObjects[2];
	} else {
		sheetObj = sheetObjects[3];
	}
	var returnVal = "";
	var r = sheetObj.FindText('cmdt_rout', cmdtRoutVal);
	for(var i = r; i < sheetObj.Rows; i++) {
		if(cmdtRoutVal != sheetObj.CellValue(i, 'cmdt_rout') || ComIsNull(sheetObj.CellValue(i, 'cy_dor_rt_tp_cd'))) {
			break;
		}
		returnVal = sheetObj.CellValue(i, 'cy_dor_rt_tp_cd');
		break;
	}
	return returnVal;	
}