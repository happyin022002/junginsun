﻿/*============================================================================ 
* Copyright(c)	 * 2009 CyberLogitec 
* @FileName : VOP_VSK_0028.js 
* @FileTitle : Report data
* Open Issues :
* Change history :
* @LastModifyDate : 2013.03.08
* @LastModifier : 정상기
* @LastVersion : 1.0
* History 
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.05.03 진마리아 CHM-201109190-01 Report data Creation내 정시로직 변경 
* 2012.08.14 진마리아 CHM-201219281-01 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
* 2011.05.03 진마리아 CHM-201109190-01 Report data Creation내 정시로직 변경 
* 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  
* 2013.03.04 정상기   CHM-201323034    On-Time Delay Time에 따른 Reason/Remark 사유입력 체크로직 변경
* 2015.01.26 강지혜   CHM-201533844    컬럼추가 및 헤더 조건 항목 순서 변경 , (VVD) delete button 기능 checkbox로 선택기능 변경
* 									->arr2 컬럼 항목들을 Berth 로 변경사용 ( (ATD-ATB) - (ETD-ETB) 로 계산 )  
* =========================================================================== */


/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class VOP_VSK_0028 : VOP_VSK_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0028() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.validateForm 		= validateForm;
}

/* 개발자 작업 */
// 현재 포커스를 가지고 있는 객체명 변수
var focusObj 		= null;
// 공통전역변수
var sheetObjects 	= new Array();
var sheetCnt 		= 0;
var tmpExit 		= 0;
var grd_vvd 		= "";
var backValue 		= null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btns_search1":
			openLandCdHelp(sheetObject1);
			break;
		
		case "btn_search2":
			if(ComChkLen(formObj.vsl_cd.value, 4) != 2){
				openVslCdHelp(formObj, sheetObject1);
			}else{ // if(ComChkLen(formObj.voy_no.value, 4) !=2){
				openVoyNoHelp(formObj, sheetObject1);
				if(ComChkLen(formObj.voy_no.value, 4)==2){
					formObj.dir_cd.focus();
				}
			}
			break;

		case "btns_calendar":
        	var cal = new ComCalendar();
        	cal.setDisplayType('month');
            cal.select(formObj.act_inp_yrmon, "yyyy-MM");
        	break;

		case "btn_Retrieve":
			formObj.conv_clpt_seq.value = "";
			if(formObj.lan_cd.value == "" ) 
			{ 
					if (formObj.vsl_cd.value == "" )
					{
						ComShowCodeMessage("VSK00027", "LANE Code OR VVD");
						formObj.lan_cd.focus();
					}else{
						doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					}						
				//if(formObj.vsl_cd.value != "")	formObj.voy_no.focus();
				//else							formObj.lan_cd.focus();
				 
			}else if(formObj.act_inp_yrmon.value == ""){
				ComShowCodeMessage("VSK00027", "Month");
			}else if(formObj.vsl_cd.value == ""){
				if (formObj.lan_cd.value == "" )
				{
					ComShowCodeMessage("VSK00027", "LANE Code OR VVD");
					formObj.lan_cd.focus();
				}else{
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				}		
				
			}else{
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}
			break;

		case "btn_New":
			doNew();
			sheetObj.CheckAll("del_flag") = 0;
			formObj.lan_cd.focus();
			break;

		case "btn_Save":
			if(ComShowCodeConfirm('COM12147', 'data')){
				if(checkOption(sheetObject1, formObj, IBSAVE)){
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
				}	
			}
			break;
			
		case "btn_Update":
			if(checkOption(sheetObject1, formObj, MULTI) && ComShowCodeConfirm('COM12154', 'data')){
				doActionIBSheet(sheetObject1, formObj, MULTI);
			}
			break;

		case "btn_Delete":
			//if(	checkOption(sheetObject1, formObj, IBDELETE) && ComShowCodeConfirm('COM12165', 'data')){
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
			//}
			formObj.vsl_cd.focus();
			break;

		case "btn_VVD_Delete":
			if(	checkOption(sheetObject1, formObj, REMOVE01) && ComShowCodeConfirm('COM12171', "VVD : " + grd_vvd)){
				doHidden(sheetObject1);
			}
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
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();
	formObj.lan_cd.focus();

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 450;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet =  msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 1, 8, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, false, true, false, false)
			InitHeadMode(false, false, true, false, false, false)

			//SelectionMode = smSelectionList;
			
			var HeadTitle1 = "| |VVD|||||||||Port|Flag|Proforma SKD|Proforma SKD|Proforma SKD|Actual SKD|Actual SKD|Actual SKD|Delay\nOption|Delay|Delay|Delay|Delay|Delay|Delay|Saved\nMonth|Delay\nOption|Departure Delay|Departure Delay|Departure Delay|Departure Delay|Departure Delay|Departure Delay";
			var HeadTitle2 = "| |VVD|||||||||Port|Flag|bfr-ETD|ETB|ETD|bfr-ATD|ATB|ATD|Arrival|ARR|ARR|ARR|Berth|Berth|Berth|Saved\nMonth|Departure|DEP1|DEP1|DEP1|DEP2|DEP2|DEP2";
			var HeadTitle3 = "| |VVD|||||||||Port|Flag|bfr-ETD|ETB|ETD|bfr-ATD|ATB|ATD|Arrival|HR|CD|RMK|HR|CD|RMK|Saved\nMonth|Departure|HR|CD|RMK|HR|CD|RMK";
			
			var addHeadTitle1 = "|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport|pf_etb_dt_bak|pf_etd_dt_bak|act_crr_cd|vvd_flg|on_flg";
			var addHeadTitle2 = "|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport|pf_etb_dt_bak|pf_etd_dt_bak|act_crr_cd|vvd_flg|on_flg";
			var addHeadTitle3 = "|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport|pf_etb_dt_bak|pf_etd_dt_bak|act_crr_cd|vvd_flg|on_flg";
			
			HeadTitle1 = HeadTitle1 + addHeadTitle1;
			HeadTitle2 = HeadTitle2 + addHeadTitle2;
			HeadTitle3 = HeadTitle3 + addHeadTitle3;
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);


			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			var Rowcnt = 0;
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(Rowcnt, cnt++, dtHiddenStatus, 	0, 	daCenter, true,		"ibflag");
			InitDataProperty(Rowcnt, cnt++, dtCheckBox,		20,		daCenter, true,		"del_flag");
 			InitDataProperty(Rowcnt, cnt++, dtData, 		80, 	daCenter, true, 	"vvd",					false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"act_inp_yrmon",		false, "", dfNone, 0, true, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"arr_rmk1",				false, "", dfNone, 0, true, 	true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"arr_rmk2",				false, "", dfNone, 0, true, 	true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"dep_rmk1",				false, "", dfNone, 0, true, 	true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"dep_rmk2",				false, "", dfNone, 0, true, 	true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"init_arr_dlay_hrs",	false, "", dfNone, 0, true, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"init_dep_dlay_hrs",	false, "", dfNone, 0, true, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		10, 	daCenter, true, 	"turn_port_ind_cd",		false, "", dfNone, 0, true, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"vps_port_cd",			false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		70, 	daCenter, true, 	"rst_flg",				false, "", dfNone, 0, false, 	false);

			//::2013-04-15:://
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		100, 	daCenter, true,		"bfr_pf_etd_dt", 		false, "", dfUserFormat2, 0, true, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		110, 	daCenter, true,		"pf_etb_dt", 			false, "", dfUserFormat2, 0, true, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		110, 	daCenter, true,		"pf_etd_dt", 			false, "", dfUserFormat2, 0, true, false);

			//::2015.02 kjh modify:://
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		100, 	daCenter, true,		"bfr_act_dep_dt", 		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		110, 	daCenter, true,		"act_brth_dt", 			false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		110, 	daCenter, true,		"act_dep_dt", 			false, "", dfUserFormat2, 0, false, false);

			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"arr_dlay_opt",			false, "", dfInteger, 0, true, false, 4);
			InitDataProperty(Rowcnt, cnt++, dtData, 		30, 	daCenter, true,		"arr_dlay_hrs1", 		false, "", dfInteger, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtCombo, 		50, 	daCenter, true,		"arr_dlay_rsn_cd1", 	false, "", dfNone, 0, true, true);
			InitDataProperty(Rowcnt, cnt++, dtImage, 		40, 	daCenter, true,		"btn_arr_rmk1", 		false, "", dfNone, 0, false, false);
			//InitDataProperty(Rowcnt, cnt++, dtHidden, 		65, 	daCenter, true,		"arr_dlay_hrs2", 		false, "", dfInteger, 0, true, true);
			//InitDataProperty(Rowcnt, cnt++, dtHidden, 		65, 	daCenter, true,		"arr_dlay_rsn_cd2", 	false, "", dfNone, 0, true, true);
			//InitDataProperty(Rowcnt, cnt++, dtHidden, 		65, 	daCenter, true,		"btn_arr_rmk2", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		30, 	daCenter, true,		"dep_dlay_hrs1", 		false, "", dfInteger, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtCombo, 		50, 	daCenter, true,		"dep_dlay_rsn_cd1", 	false, "", dfNone, 0, true, true);
			InitDataProperty(Rowcnt, cnt++, dtImage, 		40, 	daCenter, true,		"btn_dep_rmk1", 		false, "", dfNone, 0, false, false);
			
			
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true,		"rst_inp_yrmon", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		65, 	daCenter, true, 	"dep_dlay_opt",			false, "", dfInteger, 0, true, false, 4);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true,		"arr_dlay_hrs2", 		false, "", dfInteger, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true,		"arr_dlay_rsn_cd2", 	false, "", dfNone, 0, true, true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"btn_arr_rmk2", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true,		"dep_dlay_hrs2", 		false, "", dfInteger, 0, true, true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true,		"dep_dlay_rsn_cd2", 	false, "", dfNone, 0, true, true);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"btn_dep_rmk2", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"vsl_cd", 				false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"skd_voy_no",			false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"sub_trd_dir_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"clpt_ind_seq", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"clpt_seq", 			false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"skd_dir_cd", 			false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"skd_cng_sts_cd", 		false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"vskd_rslt_xcld_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"conti_cd", 			false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"conti_firstport",	 	false, "", dfNone, 0, false, false);
			
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		105, 	daCenter, true,		"pf_etb_dt_bak", 		false, "", dfUserFormat2, 0, true, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		105, 	daCenter, true,		"pf_etd_dt_bak", 		false, "", dfUserFormat2, 0, true, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"act_crr_cd", 			false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"vvd_flg", 				false, "", dfNone, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		40, 	daCenter, true,		"on_flg", 				false, "", dfNone, 0, false, false);
			
			InitUserFormat2(0,"pf_etd_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"bfr_pf_etd_dt"	, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"pf_etb_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"act_brth_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"act_dep_dt"		, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"bfr_act_dep_dt"	, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"pf_etd_dt_bak"	, "####-##-## ##:##", "-|:" );
			InitUserFormat2(0,"pf_etb_dt_bak"	, "####-##-## ##:##", "-|:" );
			
			SelectHighLight = false;
			ImageList(0) = "img/btns_search.gif";
			UnEditableColor = RgbColor(0, 0, 0);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg 		= false;
	sheetObj.WaitImageVisible 	= false;
	
	switch (sAction) {

	case IBSEARCH: // 조회
		//alert(IBSEARCH);
		formObj.f_cmd.value 		= SEARCH;
		var sParam 					= FormQueryString(formObj);
		ComOpenWait(true);
		//alert('ComOpenWait');
		var sXml 					= sheetObj.GetSearchXml("VOP_VSK_0028GS.do", sParam);
		//alert('ComOpenWait');
		ComOpenWait(false);
		
		var exist 					= ComGetEtcData(sXml, "exist");

		formObj.exist.value 		= exist;
		tmpExit 					= 0;

		var dlayRsnCd 				= ComGetEtcData(sXml, "dlay_rsn_cd");	// Delay Reason Code
		var dlayRsnNm 				= ComGetEtcData(sXml, "dlay_rsn_nm");	// Delay Reason Name
		var tmpCode = "";
		var tmpRsn = "";
		
		var code1 = ["SBW","SMT","SVD","SDA","WAD","WPG","WPC","WPV","WMT","WCA","WIO","WNH","OTH","BTT","BLS","BDA","BNS","BCW","BCM","BRB","BSP"];
		var code2 = dlayRsnCd.split('|');
		var code3 = dlayRsnNm.split('|');
			
		for(i=0; i<=code1.length; i++){			for(j=0; j<code2.length; j++){
				if(code1[i] == code2[j]){
					if( tmpCode == "" || tmpCode == null ){
						tmpCode += code2[j];
						tmpRsn += code3[j];
					}else{
						tmpCode += "|" + code2[j];
						tmpRsn += "|" + code3[j];
					}
					
				}
			}
		}
		
		formObj.dlay_rsn_cd.value 	= tmpCode;
		formObj.dlay_rsn_nm.value 	= tmpRsn;
		
		dlayRsnCd = tmpCode;
		dlayRsnNm = tmpRsn;
		
		setEventHandle();
		
		sheetObj.InitDataCombo(0, "arr_dlay_rsn_cd1", " |"+dlayRsnNm, " |"+dlayRsnCd, " ", " ");
		sheetObj.InitDataCombo(0, "arr_dlay_rsn_cd2", " |"+dlayRsnNm, " |"+dlayRsnCd, " ", " ");
		sheetObj.InitDataCombo(0, "dep_dlay_rsn_cd1", " |"+dlayRsnNm, " |"+dlayRsnCd, " ", " ");
		sheetObj.InitDataCombo(0, "dep_dlay_rsn_cd2", " |"+dlayRsnNm, " |"+dlayRsnCd, " ", " ");

		sheetObj.CheckAll("del_flag") = 0;
		
		sheetObj.Redraw 			= false;
		
		sheetObj.LoadSearchXml(sXml);
		sheetObj.Redraw 			= true;
		
		break;

	case SEARCH01: // lane Code 조회
		formObj.f_cmd.value = COMMAND12;
		var sParam = FormQueryString(formObj);
		sParam = sParam + "&vsl_slan_cd=" + formObj.lan_cd.value; 
		ComOpenWait(true);
		
		var laneCd = document.form.lan_cd.value
		var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
		var checkLane = ComGetEtcData(sXml, "checkLane");
		ComOpenWait(false);
		if(checkLane == undefined){
			  sheetObj.LoadSearchXml(sXml);
			  formObj.lan_cd.value = "";	
			  formObj.lan_cd.focus();
		  }else{
			  var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
			
			  if(vslSlanNm == ""){
				  ComShowCodeMessage('VSK00021', formObj.lan_cd.value);
				  formObj.lan_cd.value = "";	
				  formObj.lan_cd.focus();
			  }else{
				 // formObj.skd_dir_cd.focus();
				  formObj.vsl_cd.focus();
			  }
		  }

		return true;
		break;		
		
	case SEARCH02: // Vessel Code 조회
		formObj.f_cmd.value = COMMAND16;
		var sParam = FormQueryString(formObj);
		ComOpenWait(true);
		// var sXml = sheetObj.getSearchXml("VSK_GLOGS.do?op_=0219", sParam);
		var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
		var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
		ComOpenWait(false);
		
		if(!vsl_eng_nm){ // undefined
    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
    		doNew();
			formObj.tmp_vsl_cd.value = "";
			formObj.vsl_cd.value = "";
			formObj.vsl_cd.focus();
			return false;
    	}else{
    		formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
    		formObj.voy_no.focus();
    	}
		return true;
		break;
		
	case IBSAVE: // 저장
		formObj.f_cmd.value = ADD;
		
		
//		var sParam = "f_cmd=" + ADD + "&" + ComGetSaveString(sheetObj);
//		ComOpenWait(true);
//		var sXml = sheetObj.GetSaveXml("VOP_VSK_0028GS.do", sParam);
//		ComOpenWait(false);
//		
//		if(!VskGetErrorXml(sXml)){
//			ComShowCodeMessage('COM130102', 'Data');
//			btn_Retrieve.fireEvent("onclick");
//		}else{
//			sheetObj.LoadSaveXml(sXml);
//		}
//		
		break;

	case IBDELETE: // 삭제
		formObj.f_cmd.value = REMOVE;
	
		if(!ComShowCodeConfirm("VSK00005")){
			return false;
		}
		
		var delCnt = 0;
		var failStr = "";
		var sParam = FormQueryString(formObj);
		
		for( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow ; i++ ){
			
			if( sheetObj.CellValue( i, "del_flag") == "1"){
				
				if(sheetObj.CellValue( i , "rst_inp_yrmon" ) != ""){
					sheetObj.CellValue2(i, "ibflag") = "D";
					delCnt++;
				}else{
					failStr += sheetObj.CellValue( i , "VVD" ) + "[" + sheetObj.CellValue( i , "vps_port_cd" ) + "]" + "\n";
					
				}
			}else{
				sheetObj.CellValue2(i, "ibflag") = ""; 
			}
		}
		
		if( delCnt > 0 ){
			
			ComOpenWait(true); 
			
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0028GS.do", sParam +"&" + ComGetSaveString(sheetObj) );
			ComOpenWait(false);
			
			if(!VskGetErrorXml(sXml)){
				ComShowCodeMessage('COM12167', 'Data');
				btn_Retrieve.fireEvent("onclick");
			}else{
				sheetObj.LoadSaveXml(sXml);	
				
			}
		}else{
			
			ComShowCodeMessage('VSK00021' , 'Saved data');
			btn_Retrieve.fireEvent("onclick");

		}
		delCnt = 0;
		break;

	case REMOVE01: // VVD 삭제
		formObj.f_cmd.value = REMOVE;
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0028GS.do", sParam);
		ComOpenWait(false);
		
		if(!VskGetErrorXml(sXml)){
			ComShowCodeMessage('COM12167', 'Data');
			btn_Retrieve.fireEvent("onclick");
		}else{
			sheetObj.LoadSaveXml(sXml);
		}
		break;
		
	case MULTI:
		formObj.f_cmd.value = MULTI;
		// 2015.01.06 kjh  저장시 saved month가 저장안되는 현상으로 수정 //
		if( formObj.m_act_inp_yrmon.value != "" ){
			var actYrmn = formObj.m_act_inp_yrmon.value;
			var str = actYrmn.replace("-", "");
			for(var i=sheetObj.HeaderRows; i< sheetObj.LastRow+1; i++){
				
				sheetObj.CellValue( i , "act_inp_yrmon" ) =  str;
			}
		}
		//
		var sParam = "f_cmd=" + MULTI + "&" + ComGetSaveString(sheetObj);
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("VOP_VSK_0028GS.do", sParam);
 		ComOpenWait(false);
		
		if(!VskGetErrorXml(sXml)){
			ComShowCodeMessage('COM130102', 'Data');
			btn_Retrieve.fireEvent("onclick");
		}else{
			sheetObj.LoadSaveXml(sXml);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}

/**
 * 이벤트 컨드롤 정의
 */
function initControl(){
	var formObj = document.form;
    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("blur", "obj_beforedeactivate", formObj);
    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
    
    axon_event.addListenerForm("keypress", "enter_keypress", formObj);	// -
																		// Enter
																		// 키 처리
    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);		// -
																		// 자동포커스
																		// 처리
    axon_event.addListenerForm('keydown', 'obj_keydown', form); 	// - form 전체
																	// 컨트롤
																	// onkeydownup
																	// 이벤트에 코드
																	// 처리
 	setToday(document.form.act_inp_yrmon, "ym");// 올해 설정

}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

function obj_change(){
	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
		case "start_date":
		case "end_date":
			sheetObjects[0].RemoveAll();
			break;
		default:
			break;
	}	
}


function obj_keypress(){
	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
   	   case "lan_cd":
  	   case "vsl_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "dir_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		case "voy_no":
			ComKeyOnlyNumber();
			break;
			
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 */
function obj_beforedeactivate() {

	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;
	
	switch (event.srcElement.name) {
	}
}

 
function obj_keyup(){
	
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;
			
	switch (event.srcElement.name) {
		case "lan_cd":
			if(val==""){
				doNew();
				break;
			}
			
			if(!obj || val=="" || ComChkLen(val, 3)!=2){
				break;
			} else {
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
			}
			break;
			
		case "dir_cd":
			formObj.dir_cd.focus();
			break;

		case "vsl_cd":
			if(val==""){
				doNew();
				break;
			}
			
			if(!obj || val=="" || ComChkLen(val, 4)!=2){
				break;
			}
			if(formObj.tmp_vsl_cd.value != obj.value){
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
			break;
			
	}
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_activate() {
	
	if(event.srcElement.name){
		focusObj = event.srcElement.name;
	}else{
		focusObj = "";
	}
	
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
		case "start_date":
		case "end_date":
			ComClearSeparator(event.srcElement);
			break;	
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
 

function obj_keydown(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	if(focusObj=="vsl_cd"){
		var ctrl = event.ctrlKey;
		var code = event.keyCode;
		if(ctrl && code == 86){ 
			var clipData = window.clipboardData.getData('Text');
			if(clipData!=null && clipData.length==9){
				clipData = clipData.toUpperCase();
				formObj.vsl_cd.value = clipData.substring(0, 4);
				// if(isCheckVslCd(sheetObj, formObj)){
				if(doActionIBSheet(sheetObj, formObj, SEARCH02)){
					formObj.voy_no.value = clipData.substring(4, 8);
					formObj.dir_cd.value = clipData.substring(8, 9);
				}
			}
			event.returnValue = false;
		}
	}
}


/**
 * Lane Code Help 파일을 오픈한다
 */  
function openLandCdHelp(sheetObj){
   var targetObjList = "sheet1_vsl_slan_cd:lan_cd";
   var v_display = "0,0";
   var laneCd = document.form.lan_cd.value;
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
} 


/**
 * Vessel Code Help 화면을 오픈한다.
 */
function openVslCdHelp(formObj, sheetObj){
	//var sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
	// var sUrl = "/hanjin/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
	var sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value + "&inc_del_vsl_pop=Y";
	var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
	if(rVal){
		formObj.vsl_cd.value = rVal;
	}
}

/**
 * Voyage No Help 화면을 오픈한다.
 */
function openVoyNoHelp(formObj, sheetObj){
	//var sUrl = "/hanjin/VOP_VSK_0230.do?op_=0230&ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	// var sUrl = "/hanjin/VOP_VSK_0230.do?f_cmd=" + COMMAND17 +
	// "&ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	var sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	ComOpenPopupWithTarget(sUrl, 306, 420, "skd_voy_no:voy_no|sub_trd_dir_cd:dir_cd", "0,0", true);
}

function setEventHandle(){
	
	// exist = 0 이면 기존재하는 데이터를 불러온것
	// exist = 1이면 port skd 를 이용해서 새로 생성한 것
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var exist = formObj.exist.value;

	if(exist == "1"){
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Update");
		sheetObj.Editable = true;
	}else if(exist == ""){
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Update");
		sheetObj.Editable = false;
	}
}

function isEditMode(){
	var exist = document.form.exist.value;
	if(exist=="1"){
		// Vessel Port Skd를 이용해서 새로 생성한 경우에는 Edit Mode를 false로 설정한다.
		// 즉, 최초로 데이터를 생성한 경우에는 데이터를 수정하지 못하도록 한다.
		return false;
	}else{
		// 이미 생성되어 있는 Report Data는 수정이 가능하다.
		return true;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMSg) {
	
	var formObj 	= document.form;
	var dlayRsnNm 	= formObj.dlay_rsn_nm.value;
	var dlayRsnCd 	= formObj.dlay_rsn_cd.value;
	
	var firstRow 	= 0;
	var endRow 		= 0;
	var vvd 		= "";
	var vvdClrChk 	= "0";

	with(sheetObj){
		// 데이터가 있으면...
		if(RowCount > 0){
			
			firstRow 	= HeaderRows;
			endRow 		= HeaderRows + RowCount - 1;
			Redraw 		= false;

			for (var i=firstRow; i<=endRow; i++){
                
				//alert('vvd = ['+vvd+'], cell.i vvd = ['+CellValue(i, "vvd")+']');
				/*****************************************
				 * VSK_VSL_SKD_RSLT.VSKD_RSLT_XCLD_CD
				 * ---------------------------------------
				 * "A"	: Arrival
				 * "D"	: Departure
				 * "S"	: Skip Calling
				 * "N"	: Normal (None Arrival/Departure/Skip)
				 *****************************************
				 */
				
				if (vvd == CellValue(i, "vvd") ) {
					CellValue2		(i, "vskd_rslt_xcld_cd") 	= "N";
					CellBackColor	(i, "vvd") 					= CellBackColor(i-1, "vvd"); 
					CellBackColor	(i, "vps_port_cd") 			= CellBackColor(i-1, "vps_port_cd"); 
					
                   if (i == endRow) {
						CellValue2	(i, "vskd_rslt_xcld_cd") 	= "D";
	                    CellValue2	(i, "vvd_flg") 				= "L"; // VVD Last Port
                   }
                   
                } else {
                	vvd = CellValue(i, "vvd");
                    CellValue2(i, "vvd_flg") =  "F"; // VVD First Port
                    if (vvdClrChk == "0") {
                    	vvdClrChk = "1";  
                    	CellBackColor(i, "vvd") 		= RgbColor(202, 255, 112);	 
                    	CellBackColor(i, "vps_port_cd") = RgbColor(202, 255, 112);	 
                    	
                    } else {
                    	vvdClrChk = "0";
                    	CellBackColor(i, "vvd") 		= RgbColor(255, 255, 255);	
                    	CellBackColor(i, "vps_port_cd") = RgbColor(255, 255, 255);	 
                    }
                    if("S"== CellValue(i, "skd_cng_sts_cd")){
						CellValue2(i, "vskd_rslt_xcld_cd") = "S";
					} else {
						CellValue2(i, "vskd_rslt_xcld_cd") = "A";
					}
	    			if (i > firstRow) {
						CellValue2(i-1, "vskd_rslt_xcld_cd") = "D";
	                    CellValue2(i-1, "vvd_flg") =  "L"; // VVD Last Port
	    			}
			    }
			}   
			
			// 이미 생성되어 있는 정시 실적 데이터가 아닌 경우
			if(!isEditMode()){
				//alert('sheet1_OnSearchEnd - calRsltCstSkdDlayHr start');
				calRsltCstSkdDlayHr(formObj, sheetObj);
				//alert('sheet1_OnSearchEnd - calRsltCstSkdDlayHr end');
			}
			//alert('sheet1_OnSearchEnd - comparePfActSkd start');
			comparePfActSkd(sheetObj);
			//alert('sheet1_OnSearchEnd - comparePfActSkd end');
			
			for(var i=firstRow; i<=endRow; i++){
				// SKIP Port 인 경우 비활성화 표시
				if("S" == CellValue(i, "skd_cng_sts_cd")){
					CellBackColor(i, "act_brth_dt") = RgbColor(240, 240, 240);
					CellBackColor(i, "act_dep_dt")  = RgbColor(240, 240, 240);
				}

				if("F" == CellValue(i, "vvd_flg")){
					//::jskjskjsk::2013-04-12:://InitCellProperty(i, "arr_dlay_opt" , dtNull, daNull, "arr_dlay_opt" , "", dfNone);
					//::jskjskjsk::2013-04-12:://InitCellProperty(i, "arr_dlay_hrs1", dtNull, daNull, "arr_dlay_hrs1", "", dfNone);
					//::jskjskjsk::2013-04-12:://InitCellProperty(i, "arr_dlay_hrs2", dtNull, daNull, "arr_dlay_hrs2", "", dfNone);

					//::jskjskjsk::2013-04-12:://CellEditable	(i, "arr_dlay_opt"		) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "arr_dlay_hrs1"		) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "arr_dlay_rsn_cd1"	) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "btn_arr_rmk1"		) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "arr_dlay_hrs2"		) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "arr_dlay_rsn_cd2"	) = false;
					//::jskjskjsk::2013-04-12:://CellEditable	(i, "btn_arr_rmk2"		) = false;
					
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "arr_dlay_opt"		) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "arr_dlay_hrs1"		) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "arr_dlay_rsn_cd1"	) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "btn_arr_rmk1"		) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "arr_dlay_hrs2"		) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "arr_dlay_rsn_cd2"	) = RgbColor(240, 240, 240);
					//::jskjskjsk::2013-04-12:://CellBackColor	(i, "btn_arr_rmk2"		) = RgbColor(240, 240, 240);
	    			
	    			//::jskjskjsk::2013-04-12:://CellEditable	(i, "pf_etb_dt"			) = false;
	    			//::jskjskjsk::2013-04-12:://CellBackColor	(i, "pf_etb_dt"			) = RgbColor(240, 240, 240);
	    			//::jskjskjsk::2013-04-12:://CellFontColor	(i, "pf_etb_dt"			) = RgbColor(240, 240, 240);
	    			
	    			//::jskjskjsk::2013-04-12:://CellEditable	(i, "act_brth_dt"		) = false;
	    			//::jskjskjsk::2013-04-12:://CellBackColor	(i, "act_brth_dt"		) = RgbColor(240, 240, 240);
	    			//::jskjskjsk::2013-04-12:://CellFontColor	(i, "act_brth_dt"		) = RgbColor(240, 240, 240);
				}

				if("L" == CellValue(i, "vvd_flg")){
    				//InitCellProperty(i, "dep_dlay_opt" , dtNull, daNull, "dep_dlay_opt" , "", dfNone);
    				//InitCellProperty(i, "dep_dlay_hrs1", dtNull, daNull, "dep_dlay_hrs1", "", dfNone);
    				//InitCellProperty(i, "dep_dlay_hrs2", dtNull, daNull, "dep_dlay_hrs2", "", dfNone);
    				//CellEditable	(i, "dep_dlay_opt"		) = false;
    				//CellEditable	(i, "dep_dlay_hrs1"		) = false;
    				//CellEditable	(i, "dep_dlay_rsn_cd1"	) = false;
    				//CellEditable	(i, "btn_dep_rmk1"		) = false;
    				//CellEditable	(i, "dep_dlay_hrs2"		) = false;
    				//CellEditable	(i, "dep_dlay_rsn_cd2"	) = false;
    				//CellEditable	(i, "btn_dep_rmk2"		) = false;
	    			//CellBackColor	(i, "dep_dlay_opt"		) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "dep_dlay_hrs1"		) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "dep_dlay_rsn_cd1"	) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "btn_dep_rmk1"		) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "dep_dlay_hrs2"		) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "dep_dlay_rsn_cd2"	) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "btn_dep_rmk2"		) = RgbColor(240, 240, 240);
	    			//CellBackColor	(i, "pf_etd_dt"			) = RgbColor(240, 240, 240);
	    			//CellFontColor	(i, "pf_etd_dt"			) = RgbColor(240, 240, 240);
				}
 			}
			
			//alert('sheet1_OnSearchEnd - controlDelayData start');
			controlDelayData(sheetObj);
			//alert('sheet1_OnSearchEnd - controlDelayData end');
			Redraw = true;
		}else{
		}
	}
}

function calRsltCstSkdDlayHr(formObj, sheetObj){

	var start 	= sheetObj.HeaderRows;
	var end		= sheetObj.HeaderRows + sheetObj.RowCount;

	// 운하를 제외한 각 지역(Conti Code)의 첫번째 port 체크
	checkContiFirstPort(sheetObj);
	
	var arrDlayHrs1;
	var depDlayHrs1;
	
	var gap;
	var sameDate;

	for(var Row=start; Row<end; Row++){
	
		if(sheetObj.CellValue(Row, "rst_flg")== "U" ) {	
			// 첫번째 Port의 경우
			
			if(sheetObj.CellValue(Row, "vvd_flg") == "F" )	{
				
				/************************************************************************
				 * FIRST PORT ARRIVAL DELAY 계산로직추가
				 * 2013-04-16
				 * ----------------------------------------------------------------------
				 * PF .FIRST PORT ARRIVAL DELAY : 직전PORT PF .ETB - FIRST PORT PF .ETD
				 * ACT.FIRST PORT ARRIVAL DELAY : 직전PORT ACT.ETB - FIRST PORT ACT.ETD
				 ************************************************************************
				 */
				//alert(getFirstPortArrivalDelay	(sheetObj, Row));
				arrDlayHrs1 = getFirstPortArrivalDelay	(sheetObj, Row);					
				depDlayHrs1 = getDepartureDelay			(sheetObj, Row);
				
				if(!isEditMode()&& (tmpExit == 0)){
					//sameDate = isSameDate(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"));
					// gap = compareDate(sheetObj.CellValue(Row, "pf_etb_dt"),
					// sheetObj.CellValue(Row, "act_brth_dt"));
					//alert('compareDate1 >> ['+compareDate1(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"))+']');
					gap = compareDate1(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"));
					// ETB-48HRS < ATB < ETB+ 24HRS 
					// ==>
					// ::2013-03-29:: ETB-24HRS < ATB < ETB+ 24HRS
					if(gap == 0){
						// pf 데이터 백업
						sheetObj.CellValue2	(Row, "pf_etb_dt_bak"	) = sheetObj.CellValue(Row, "pf_etb_dt");
						sheetObj.ToolTipText(Row, "pf_etb_dt"		) = ComGetMaskedValue(sheetObj.CellValue(Row, "pf_etb_dt_bak"), "ymdhm");
						
						/*************************************************************************************
						 * 2013/04/01 :: ON-TIME RULE 변경 (AS-IS -48 < * < +24)
						 * PF ETB와 ATB의 시간차이가 -24 < * < +24 이내인경우
						 * PF ETB를 ATB로 REPLACE 처리함
						 */
						arrDlayHrs1 = "0";
						sheetObj.CellValue2	(Row, "pf_etb_dt"		) = sheetObj.CellValue(Row, "act_brth_dt");
						sheetObj.CellValue2	(Row, "on_flg"			) = "0"; 
						sheetObj.CellFont	("FontBold", Row, "pf_etb_dt") = true;
					}else{
						sheetObj.CellFont	("FontBold", Row, "pf_etb_dt") = false;
						sheetObj.CellValue2	(Row, "on_flg")    = "1";
					}
				}				
			
			}else{ // 첫번째 Port가 아닌 경우
			
				arrDlayHrs1 = getArrivalDelay	(sheetObj, Row);
				depDlayHrs1 = getDepartureDelay	(sheetObj, Row);
				
				if(!isEditMode()&& (tmpExit == 0)){
					//sameDate = isSameDate(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"));
					// gap = compareDate(sheetObj.CellValue(Row, "pf_etb_dt"),
					// sheetObj.CellValue(Row, "act_brth_dt"));
					gap = compareDate1(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"));
					// ETB-48HRS < ATB < ETB+ 24HRS 
					// ==>
					// ::2013-03-29:: ETB-24HRS < ATB < ETB+ 24HRS
					if(gap == 0){
						// pf 데이터 백업
						sheetObj.CellValue2	(Row, "pf_etb_dt_bak"	) = sheetObj.CellValue(Row, "pf_etb_dt");
						sheetObj.ToolTipText(Row, "pf_etb_dt"		) = ComGetMaskedValue(sheetObj.CellValue(Row, "pf_etb_dt_bak"), "ymdhm");
						
						/*************************************************************************************
						 * 2013/04/01 :: ON-TIME RULE 변경 (AS-IS -48 < * < +24)
						 * PF ETB와 ATB의 시간차이가 -24 < * < +24 이내인경우
						 * PF ETB를 ATB로 REPLACE 처리함
						 */
						arrDlayHrs1 = "0";
						sheetObj.CellValue2	(Row, "pf_etb_dt"		) = sheetObj.CellValue(Row, "act_brth_dt");
						sheetObj.CellValue2	(Row, "on_flg"			) = "0"; 
						sheetObj.CellFont	("FontBold", Row, "pf_etb_dt") = true;
					}else{
						sheetObj.CellFont	("FontBold", Row, "pf_etb_dt") = false;
						sheetObj.CellValue2	(Row, "on_flg")    = "1";
					}
				}
				
//				if(sheetObj.CellValue(Row, "vvd_flg") == "L" ){
//					depDlayHrs1 = "0";
//				}
				
			}
			
			with(sheetObj){
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_opt") 		= "0";				
				CellValue2(Row, "dep_dlay_opt") 		= "0";
				CellValue2(Row, "arr_dlay_hrs1") 		= arrDlayHrs1;
				CellValue2(Row, "dep_dlay_hrs1") 		= depDlayHrs1;
				CellValue2(Row, "arr_dlay_hrs2") 		= "0";
				CellValue2(Row, "dep_dlay_hrs2") 		= "0";
				CellValue2(Row, "init_arr_dlay_hrs") 	= CellValue(Row, "arr_dlay_hrs1");
				CellValue2(Row, "init_dep_dlay_hrs") 	= CellValue(Row, "dep_dlay_hrs1");
			}
		}
	}
	//alert( sheetObj.CellValue( sheetObj.HeaderRows + sheetObj.RowCount -1 , "dep_dlay_hrs1" ));
}

function checkContiFirstPort(sheetObj){
	
	var start 	= sheetObj.HeaderRows;
	var end 	= sheetObj.HeaderRows + sheetObj.RowCount;
	
	with(sheetObj){
		for(var Row=start; Row<end; Row++){
			if(CellValue(Row, "vvd_flg") == "F"){
				continue;
			}
			if(	"EGSUZ"!=CellValue(Row, "vps_port_cd") && "PAPAC" != CellValue(Row, "vps_port_cd") && CellValue(Row-1, "conti_cd")!=CellValue(Row, "conti_cd")){
				CellValue2(Row, "conti_firstport") = "Y";
			}
		}
	}
}

function getFirstPortArrivalDelay(sheetObj, Row){
	var pfEtb 	= sheetObj.CellValue(Row	, "pf_etb_dt"		);
	var pfEtd 	= sheetObj.CellValue(Row	, "bfr_pf_etd_dt"	);
	var actEtb 	= sheetObj.CellValue(Row	, "act_brth_dt"		);
	var actEtd 	= sheetObj.CellValue(Row	, "bfr_act_dep_dt"	);
	
	/*
	 * =============== 시간차를 구하는 방식 ===============
	 * 
	 * vo1 : 연속된 두 port 중 선행 port 정보 vo2 : 연속된 두 port 중 후행 port 정보
	 * 
	 * P/F 스케쥴 Arrival 소요 시간 = vo2의 P/F ETB - vo1의 P/F ETD Actual 스케쥴 Arrival 소요
	 * 시간 = vo2의 ACT Berth Date - vo1의 ACT Departure Date
	 * 
	 * >>> 시간차 = Actual 스케쥴 Arrival 소요 시간 - P/F 스케쥴 Arrival 소요 시간
	 * 
	 * 만약 P/F 스케쥴 Arrival 소요 시간이 커서 시간차가 음수가 나오는 경우, (Exclude 방식에서 볼때) 지연이 발생하지
	 * 않은 것으므로 시간차는 0으로 감안한다.
	 * 
	 */
	
	// 시간차를 구하기 위한 4항목(위의 시간차 구하는 방식 참고)의 시간 정보중 하나라도 없는 경우 시간차는 0이 된다.
	if( 		pfEtd	== null || pfEtd.length		== 0 
			|| 	pfEtb 	== null || pfEtb.length		== 0 
			|| 	actEtd 	== null || actEtd.length	== 0
			|| 	actEtb 	== null || actEtb.length	== 0
	){
		return "0";
	}
	
	var pfEtbDt 	= getDate(pfEtb);
	var pfEtdDt 	= getDate(pfEtd);
	var actEtbDt 	= getDate(actEtb);
	var actEtdDt 	= getDate(actEtd);
	
	// Hour로 환산한 P/F Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var pfArrTimeByHour = Math.round( (pfEtbDt - pfEtdDt) / (1000 * 60 * 60.0) );
	
	// Hour로 환산한 Actual Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var actArrTimeByHour = Math.round( (actEtbDt - actEtdDt) / (1000 * 60 * 60.0) );
	
	////alert('PORT ['+sheetObj.CellValue(Row,'vps_port_cd')+'] pfArrTimeByHour ['+pfArrTimeByHour+'] actArrTimeByHour ['+actArrTimeByHour+']');

	var delay = actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : actArrTimeByHour - pfArrTimeByHour;
	
	return delay;
}

function getArrivalDelay(sheetObj, Row){
	var pfEtb 	= sheetObj.CellValue(Row	, "pf_etb_dt"	);
	var pfEtd 	= sheetObj.CellValue(Row-1	, "pf_etd_dt"	);
	var actEtb 	= sheetObj.CellValue(Row	, "act_brth_dt"	);
	var actEtd 	= sheetObj.CellValue(Row-1	, "act_dep_dt"	);
	
	/*
	 * =============== 시간차를 구하는 방식 ===============
	 * 
	 * vo1 : 연속된 두 port 중 선행 port 정보 vo2 : 연속된 두 port 중 후행 port 정보
	 * 
	 * P/F 스케쥴 Arrival 소요 시간 = vo2의 P/F ETB - vo1의 P/F ETD Actual 스케쥴 Arrival 소요
	 * 시간 = vo2의 ACT Berth Date - vo1의 ACT Departure Date
	 * 
	 * >>> 시간차 = Actual 스케쥴 Arrival 소요 시간 - P/F 스케쥴 Arrival 소요 시간
	 * 
	 * 만약 P/F 스케쥴 Arrival 소요 시간이 커서 시간차가 음수가 나오는 경우, (Exclude 방식에서 볼때) 지연이 발생하지
	 * 않은 것으므로 시간차는 0으로 감안한다.
	 * 
	 */
	
	// 시간차를 구하기 위한 4항목(위의 시간차 구하는 방식 참고)의 시간 정보중 하나라도 없는 경우 시간차는 0이 된다.
	if( 		pfEtd	== null || pfEtd.length		== 0 
			|| 	pfEtb 	== null || pfEtb.length		== 0 
			|| 	actEtd 	== null || actEtd.length	== 0
			|| 	actEtb 	== null || actEtb.length	== 0
	){
		return "0";
	}
	
	var pfEtbDt 	= getDate(pfEtb);
	var pfEtdDt 	= getDate(pfEtd);
	var actEtbDt 	= getDate(actEtb);
	var actEtdDt 	= getDate(actEtd);
	
	// Hour로 환산한 P/F Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var pfArrTimeByHour = Math.round( (pfEtbDt - pfEtdDt) / (1000 * 60 * 60.0) );
	
	// Hour로 환산한 Actual Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var actArrTimeByHour = Math.round( (actEtbDt - actEtdDt) / (1000 * 60 * 60.0) );
	
	////alert('PORT ['+sheetObj.CellValue(Row,'vps_port_cd')+'] pfArrTimeByHour ['+pfArrTimeByHour+'] actArrTimeByHour ['+actArrTimeByHour+']');

	var delay = actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : actArrTimeByHour - pfArrTimeByHour;
	
	return delay;
}


function getDepartureDelay(sheetObj, Row){
	var pfEtb 	= sheetObj.CellValue(Row, "pf_etb_dt"	);
	var pfEtd 	= sheetObj.CellValue(Row, "pf_etd_dt"	);
	var actEtb 	= sheetObj.CellValue(Row, "act_brth_dt"	);
	var actEtd 	= sheetObj.CellValue(Row, "act_dep_dt"	);
	
	/*
	 * =============== 시간차를 구하는 방식 ===============
	 * 
	 * P/F 스케쥴 Arrival 소요 시간 = P/F ETD - P/F ETB Actual 스케쥴 Arrival 소요 시간 = ACT
	 * Departure Date - ACT Berth Date
	 * 
	 * >>> 시간차 = Actual 스케쥴 Arrival 소요 시간 - P/F 스케쥴 Arrival 소요 시간
	 * 
	 * 만약 P/F 스케쥴 Arrival 소요 시간이 커서 시간차가 음수가 나오는 경우, (Exclude 방식에서 볼때) 지연이 발생하지
	 * 않은 것으므로 시간차는 0으로 감안한다.
	 * 
	 */
	
	// 시간차를 구하기 위한 4항목(위의 시간차 구하는 방식 참고)의 시간 정보중 하나라도 없는 경우 시간차는 0이 된다.
	if( pfEtd==null || pfEtd.length==0 
			|| pfEtb == null || pfEtb.length==0 
			|| actEtd == null || actEtd.length==0
			|| actEtb == null || actEtb.length==0
			){
		return "0";
	}
	
	var pfEtbDt 	= getDate(pfEtb);
	var pfEtdDt 	= getDate(pfEtd);
	var actEtbDt 	= getDate(actEtb);
	var actEtdDt 	= getDate(actEtd);
	
	// Hour로 환산한 P/F Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var pfArrTimeByHour = Math.round( (pfEtdDt - pfEtbDt) / (1000 * 60 * 60.0) );
	
	// Hour로 환산한 Actual Arrival 소요 시간
	// 0.5시간(30분)은 1시간으로 반올림한다.
	var actArrTimeByHour = Math.round( (actEtdDt - actEtbDt) / (1000 * 60 * 60.0) );
	var delay = actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : actArrTimeByHour - pfArrTimeByHour;
	return delay;
	
}

function getDate(str){
	var date 	= null;
	var year 	= str.substring(0, 4);
	var month 	= ComParseInt(str.substring(4, 6)) - 1;
	var day 	= str.substring(6, 8);
	var hour 	= str.substring(8, 10);
	var minute 	= str.substring(10, 12);
	date 		= new Date(year, month, day, hour, minute);
	return date;
}

/**
 * Proforma와 Actual의 각 ETB/ETD를 비교하여 지연된 Proforma 항목을 표시해준다.
 * 
 * 
 */
function comparePfActSkd(sheetObj){
	var start 	= sheetObj.HeaderRows;
	var end 	= sheetObj.HeaderRows + sheetObj.RowCount;
	
	for(var Row=start; Row<end; Row++){
		
		//::jskjskjsk::2013-04-12:://if(sheetObj.CellValue(Row, "vvd_flg") != "F"   ){// 맨 처음 ETB는 처리하지 않음
		if(compareDate1(sheetObj.CellValue(Row, "pf_etb_dt"), sheetObj.CellValue(Row, "act_brth_dt"))==1){
			sheetObj.CellBackColor	(Row, "pf_etb_dt"	) = sheetObj.RgbColor(0, 255, 255);
			sheetObj.CellValue2		(Row, "on_flg"		) = "1"; 
		}else{
			sheetObj.CellBackColor	(Row, "pf_etb_dt"	) = sheetObj.RgbColor(255, 255, 255);
			sheetObj.CellValue2		(Row, "on_flg"		) = "0"; 

            if (sheetObj.CellValue	(Row, "arr_dlay_hrs1") > 0  ) {
            	sheetObj.CellValue2	(Row, "on_flg"		) = "1";
            }
			
			
		}
		//::jskjskjsk::2013-04-12:://}
		
		//if(sheetObj.CellValue(Row, "vvd_flg") != "L"  ){// 마지막 ETD는 처리하지 않음
			if(compareDate1(sheetObj.CellValue(Row, "pf_etd_dt"), sheetObj.CellValue(Row, "act_dep_dt"))==1){
				sheetObj.CellBackColor(Row, "pf_etd_dt") = sheetObj.RgbColor(0, 255, 255);
			}else{
				sheetObj.CellBackColor(Row, "pf_etd_dt") = sheetObj.RgbColor(255, 255, 255);
			}
		//}
	}
		
}


 /**
  * 두 날짜를 비교한다.
  * srcDate1 == srcDate2 이면 0
  * srcDate1 > srcDate2 이면 -1
  * srcDate1 < srcDate2 이면 1 
  */
  function compareDate(srcDate1, srcDate2){
		var date1 = getDate(srcDate1);
		var date2 = getDate(srcDate2);
		if(date2-date1>0){
			return 1;
		}else if(date2-date1<0){
			return -1;
		}else{
			return 0;
		}
	}
 
 
  /**
   * 두 날짜를 비교한다.
   * srcDate1 == srcDate2 이면 0
   * srcDate1 > srcDate2 이면 -1
   * srcDate1 < srcDate2 이면 1 
   */
  function compareDate1 (srcDate1, srcDate2){
  	var date1 = getDate(srcDate1);
  	var date2 = getDate(srcDate2);
  	var rtn = 1;
    if (srcDate1 == ""|| srcDate2 == "") {
    	rtn = 2;
    } else {
     	if(date2 > date1 ){
     		if ( Math.floor( (date2 - date1) / (1000 * 60 * 60.0) )  >= 24 ) {
    			rtn = 1; 
    		} else {
    			rtn = 0;
    		}
      		
      	}else if(date2 < date1){
      		
      		//on-time 기준변경::2013-03-29 -48~<ON-TIME<+24 ==> -24~<ON-TIME<+24
    		if ( Math.floor( (date1 - date2) / (1000 * 60 * 60.0) )  >= 24 ) {
    			rtn = 1; 
    		} else {
    			rtn = 0;
    		}
      	}else{
      		rtn = 0;
      	}   	
    }
    return rtn;	
    
  }

 
/**
 * 두 날짜가 같은 날(YYYY-MM-DD)인지 비교한다.
 * 같은 날이면 true 반환
 * 다른 날이면 false 반환
 */
function isSameDate(srcDate1, srcDate2){
	srcDate1 = srcDate1.substring(0, 8)+"0000";
	srcDate2 = srcDate2.substring(0, 8)+"0000";
	var date1 = getDate(srcDate1);
	var date2 = getDate(srcDate2);
	if(date2-date1==0){
		return true;
	}else{
		return false;
	}
}

 /**
  * 비교란 팝업 오픈 
 */
function sheet1_OnClick(sheetObj, Row, Col){
	
	var colSaveName = sheetObj.ColSaveName(Col);
	
	switch(colSaveName){
	
		case "btn_arr_rmk1":
			if(sheetObj.CellValue(Row, Col) == '0'){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, "arr_rmk1"));
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal==''){
					sheetObj.CellValue2(Row, "arr_rmk1") = rVal;
				}
			}		
			break;
		
		case "btn_arr_rmk2":
			if(sheetObj.CellValue(Row, Col) == '0'){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, "arr_rmk2"));
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal==''){
					sheetObj.CellValue2(Row, "arr_rmk2") = rVal;
				}
			}	
			break;
			
		case "btn_dep_rmk1":
			if(sheetObj.CellValue(Row, Col) == '0'){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, "dep_rmk1"));
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal==''){
					sheetObj.CellValue2(Row, "dep_rmk1") = rVal;
				}
			}		
			break;
			
		case "btn_dep_rmk2":
			if(sheetObj.CellValue(Row, Col) == '0'){
				var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + escape(sheetObj.CellValue(Row, "dep_rmk2"));
				var rVal = ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				if(rVal || rVal==''){
					sheetObj.CellValue2(Row, "dep_rmk2") = rVal;
				}
			}	
			break;
		case "vvd":
			if(sheetObj.CellValue(Row, Col) != ""){
				grd_vvd    = sheetObj.CellValue(Row, "vvd") ;
			}	
			break;
	}
	
}


/**
* ETB, ETD 변경에 따른 정시율 계산
*/
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj 	= document.form;
	var colSaveName = sheetObj.ColSaveName(Col);
	var start 		= sheetObj.HeaderRows;
	var end 		= sheetObj.HeaderRows + sheetObj.RowCount;
	
	switch(colSaveName){
		case "pf_etb_dt":
		case "pf_etd_dt":
			for(var i=start; i< end; i++){
				if (sheetObj.CellValue(i, "vvd") == sheetObj.CellValue(Row, "vvd") ) {  
			  	   sheetObj.CellValue(i, "rst_flg") = "U";  
				}   
				else {
				   sheetObj.CellValue(i, "rst_flg") = "C";	
				}
			}
			tmpExit = 1;
			calRsltCstSkdDlayHr(formObj, sheetObj);
			comparePfActSkd(sheetObj);
			controlDelayData(sheetObj);
			break;
		
//		case "del_flag":
//			
//			break;
	}
}

/**
* 정시율 관련 날짜 백업 
*/
function sheet1_OnBeforeEdit(sheetObj, Row, Col){
	backValue = sheetObj.CellValue(Row, Col);
}

/**
* arr_dlay_opt 변경에 따른 정시율 재계산  
*/
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var colSaveName = sheetObj.ColSaveName(Col);
	switch(colSaveName){
		case "arr_dlay_opt":
			
			// 첫줄은 경우 처리하지 않는다.
			//::jskjskjsk::2013-04-12:://if (sheetObj.CellValue(Row, "vvd_flg") == "F" ) {
			//::jskjskjsk::2013-04-12:://	return;
			//::jskjskjsk::2013-04-12:://}

			var hrs1;
			var hrs2;
			var initValue;
			var oldValue;
			var newValue;
			
			hrs1 = sheetObj.CellValue(Row, "arr_dlay_hrs1").parseInt();
			hrs2 = sheetObj.CellValue(Row, "arr_dlay_hrs2").parseInt();
			
			initValue = sheetObj.CellValue(Row, "init_arr_dlay_hrs").parseInt();
			if(backValue==""){
				oldValue = 0;
			}else{
				oldValue = backValue.parseInt();
			}
			
			newValue = sheetObj.CellValue(Row, Col).parseInt();
			
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}
			
			var realValue = newValue - oldValue;
			
			// 스케쥴 상의 허락된 시간까지만 조정이 가능함
			if(newValue > initValue){
				ComShowCodeMessage("VSK00073");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}else{
				// arr_dlay_opt의 시간을 늘린 경우(realValue가 양수)에는 hrs2 의 시간을 줄인 후에 hrs2가 0이 되면, hrs1에서 줄인다.
				// arr_dlay_opt의 시간을 줄인 경우(realValue가 음수)에는 hrs1 의 시간을 늘인다.
				
				if(realValue<0){
					sheetObj.CellValue2(Row, "arr_dlay_hrs1") = hrs1 - realValue;
				}else if(realValue<=hrs2){
					sheetObj.CellValue2(Row, "arr_dlay_hrs2") = hrs2 - realValue;
					// sheetObj.CellValue2(Row, "arr_dlay_opt") = newValue;
				}else{
					sheetObj.CellValue2(Row, "arr_dlay_hrs1") = hrs1 - (realValue - hrs2);
					sheetObj.CellValue2(Row, "arr_dlay_hrs2") = 0;
				}
			}
			
			if (sheetObj.CellValue2(Row, "arr_dlay_hrs1") = "0") {
				sheetObj.CellValue2(Row, "on_flg") = "0";  	 
			} else {
				sheetObj.CellValue2(Row, "on_flg") = "1";	
			}
	
			controlDelayData(sheetObj);
			sheetObj.SelectCell(Row, Col, false);
			break;
			
		case "arr_dlay_hrs2":
			
			// 첫번째 줄은 처리하지 않는다.
			if(sheetObj.CellValue(Row, "vvd_flg") == "F" ) {
				return;
			}
			
			var oldValue;
			var newValue;
			
			if(backValue==""){
				oldValue = 0;
			}else{
				oldValue = backValue.parseInt();
			}
			
			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}
			
			var realValue = newValue - oldValue;
			
			var hrs1 = sheetObj.CellValue(Row, "arr_dlay_hrs1").parseInt();
			var hrs2 = sheetObj.CellValue(Row, "arr_dlay_hrs2").parseInt();
			
			if(realValue<=hrs1){
				sheetObj.CellValue2(Row, "arr_dlay_hrs1") = hrs1 - realValue;
			}else{
				ComShowCodeMessage("VSK00073");
				sheetObj.CellValue2(Row, "arr_dlay_hrs2") = oldValue;
				return;
			}
			
			controlDelayData(sheetObj);
			sheetObj.SelectCell(Row, Col, false);
			break;
			
		case "dep_dlay_opt":
			
			// 마지막줄은 경우 처리하지 않는다.
			//if (sheetObj.CellValue(Row, "vvd_flg") == "L" ) {
			//return;
			//}
			
			var initValue;
			var oldValue;
			var newValue;
			
			initValue = sheetObj.CellValue(Row, "init_dep_dlay_hrs").parseInt();
			if(backValue==""){
				oldValue = 0;
			}else{
				oldValue = backValue.parseInt();
			}
			
			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}
			
			var realValue = newValue - oldValue;
			
			// 스케쥴 상의 허락된 시간까지만 조정이 가능함
			if(newValue > initValue){
				//alert("입려할 수 있는 시간의 범위를 초과하였습니다. " + initValue + "까지의 시간을 입력할 수 있습니다.");
				ComShowCodeMessage("VSK00073");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}else{
				// dep_dlay_opt의 시간을 늘린 경우(realValue가 양수)에는 hrs2 의 시간을 줄인 후에 hrs2가 0이 되면, hrs1에서 줄인다.
				// dep_dlay_opt의 시간을 줄인 경우(realValue가 음수)에는 hrs1 의 시간을 늘인다.
				
				var hrs1 = sheetObj.CellValue(Row, "dep_dlay_hrs1").parseInt();
				var hrs2 = sheetObj.CellValue(Row, "dep_dlay_hrs2").parseInt();
				
				if(realValue<0){
					sheetObj.CellValue2(Row, "dep_dlay_hrs1") = hrs1 - realValue;
				}else if(realValue<=hrs2){
					sheetObj.CellValue2(Row, "dep_dlay_hrs2") = hrs2 - realValue;
					// sheetObj.CellValue2(Row, "arr_dlay_opt") = newValue;
				}else{
					sheetObj.CellValue2(Row, "dep_dlay_hrs1") = hrs1 - (realValue - hrs2);
					sheetObj.CellValue2(Row, "dep_dlay_hrs2") = 0;
				}
			}
			
			controlDelayData(sheetObj);
			sheetObj.SelectCell(Row, Col, false);
			break;
			
		case "dep_dlay_hrs2":
			
			// 마지막 줄은 처리하지 않는다.
			//if (sheetObj.CellValue(Row, "vvd_flg") == "L" ) {
			//return;
			//}
			
			var oldValue;
			var newValue;
			
			if(backValue==""){
				oldValue = 0;
			}else{
				oldValue = backValue.parseInt();
			}
			
			newValue = sheetObj.CellValue(Row, Col).parseInt();
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.CellValue2(Row, Col) = oldValue;
				return;
			}
			
			var realValue = newValue - oldValue;
			
			var hrs1 = sheetObj.CellValue(Row, "dep_dlay_hrs1").parseInt();
			var hrs2 = sheetObj.CellValue(Row, "dep_dlay_hrs2").parseInt();
			
			if(realValue<=hrs1){
				sheetObj.CellValue2(Row, "dep_dlay_hrs1") = hrs1 - realValue;
			}else{
				//alert("입력할 수 있는 시간의 범위를 초과하였습니다.");
				ComShowCodeMessage("VSK00073");
				sheetObj.CellValue2(Row, "dep_dlay_hrs2") = oldValue;
				return;
			}
			
			controlDelayData(sheetObj);
			sheetObj.SelectCell(Row, Col, false);
			break;
			
	}
}

/**
* 정시율 계산  
*/
function controlDelayData(sheetObj){
	var start 	= sheetObj.HeaderRows;
	var end 	= sheetObj.HeaderRows + sheetObj.RowCount;

	// Delay Hour가 0인 경우 그 와 연관되는 Reason Code 와 Remark Button을 초기화시킨다.
	with(sheetObj){
		Redraw = false;
		////Redraw = true;
		
		/**************************************************************
		 * Arrival Delay:Remark 입력 필수항목 조건변경::2013-02-26
		 * ------------------------------------------------------------
		 * [AS-IS]
		 * (Pf.ETB-Pf.ETD) (Ps.ETB - Ps.ETD) 0 이상이면 Remark 필수항목 
		 * 
		 * [TO-BE]
		 * as-is에서 이전24시간 이후48시간 이내의 지연은 정시로 간주한다는 Rule을
		 * 적용하여 -24< Arr.Delay < 48 범위를 벗어난 경우만 Remark 필수항목
		 * 
		 * [TO-BE::2013-03-29]
		 * as-is에서 이전24시간 이후24시간 이내의 지연은 정시로 간주한다는 Rule을
		 * 적용하여 -24< Arr.Delay < 24 범위를 벗어난 경우만 Remark 필수항목
		 * 
		 **************************************************************/
		
		for(var Row=start; Row<end; Row++){
			
			//2013-02-26 주석처리함.
			//if(CellValue(Row, "on_flg") == "0"){
			//	CellValue2(Row, "arr_dlay_rsn_cd1") = "";
			//	CellValue2(Row, "arr_rmk1") = "";
			//	CellValue2(Row, "btn_arr_rmk1") = 1;
			//}else{
			//	CellValue2(Row, "btn_arr_rmk1") = 0;	//Remark 입력을 위한 Search 팝업이미지 Visible//
			//}
			
			if(CellValue(Row, "arr_dlay_hrs1") == 0){
				CellValue2(Row, "arr_dlay_rsn_cd1"	) = "";
				CellValue2(Row, "arr_rmk1"			) = "";
				CellValue2(Row, "btn_arr_rmk1"		) = 1;
			}else{
				CellValue2(Row, "btn_arr_rmk1"		) = 0;	//Remark 입력을 위한 Search 팝업이미지 Visible//
			}			
			////alert('Row = ['+Row+'], on_flg = ['+CellValue(Row, "on_flg")+'], arr_dlay_hrs1 = ['+CellValue(Row, "arr_dlay_hrs1")+'], btn_arr_rmk1 = ['+CellValue(Row, "btn_arr_rmk1")+']');
			
			if(CellValue(Row, "arr_dlay_hrs2") == "0"){
				CellValue2(Row, "arr_dlay_rsn_cd2"	) = "";
				CellValue2(Row, "arr_rmk2"			) = "";
				CellValue2(Row, "btn_arr_rmk2"		) = 1;
			}else{
				CellValue2(Row, "btn_arr_rmk2"		) = 0;
			}
			
			if(CellValue(Row, "dep_dlay_hrs1") == "0"){
				CellValue2(Row, "dep_dlay_rsn_cd1"	) = "";
				CellValue2(Row, "dep_rmk1"			) = "";
				CellValue2(Row, "btn_dep_rmk1"		) = 1;
			}else{
				CellValue2(Row, "btn_dep_rmk1"		) = 0;
			}
			
			if(CellValue(Row, "dep_dlay_hrs2") == "0"){
				CellValue2(Row, "dep_dlay_rsn_cd2"	) = "";
				CellValue2(Row, "dep_rmk2"			) = "";
				CellValue2(Row, "btn_dep_rmk2"		) = 1;
			}else{
				CellValue2(Row, "btn_dep_rmk2"		) = 0;
			}
			
			if (CellValue(Row, "vvd_flg") == "F") {
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_opt"		) = "";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_hrs1"		) = "";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_rsn_cd1"	) = "";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "btn_arr_rmk1"		) = "1";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_hrs2"		) = "";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "arr_dlay_rsn_cd2"	) = "";
				//::jskjskjsk::2013-04-12:://CellValue2(Row, "btn_arr_rmk2"		) = "1";
			}
//			if (CellValue(Row, "vvd_flg") == "L") {
//				CellValue2(Row, "dep_dlay_opt"		) = "";
//				CellValue2(Row, "dep_dlay_hrs1"		) = "";
//				CellValue2(Row, "dep_dlay_rsn_cd1"	) = "";
//				CellValue2(Row, "btn_dep_rmk1"		) = "1";
//				CellValue2(Row, "dep_dlay_hrs2"		) = "";
//				CellValue2(Row, "dep_dlay_rsn_cd2"	) = "";			
//				CellValue2(Row, "btn_dep_rmk2"		) = "1";
//			}
		}
		Redraw = true;
	}
	
	// 정시 실적 데이터를 최초 생성하는 경우(즉, Save 버튼이 활성화 된 경우)에는
	// 모든 Row를 Insert Status 상태로 변경한다.
	// therefore, 모든 P/F는 변경 불가능 상태이다.(UpdateEdit 속성만 true이므로)
	
//	if(!isEditMode()){
//		for(var Row=start; Row<end; Row++){
//			if (sheetObj.CellValue(Row, "ibflag") != "D") {
//				sheetObj.RowStatus(Row) = "U";	
//			}
//		}
//	}
}

/**
* 정시율 Validation  
*/
function checkOption(sheetObj, formObj, sAction){
	var check = true;
	
	switch(sAction){
		case IBSAVE:

			if(sheetObj.RowCount>0){
				check = true;
				// Actual Schedule이 비어있는 경우 Save 되지 않는다.
				
				// 단, SKIP PORT와 마지막 ATD는 예외로 한다.
				var startRow 	= sheetObj.HeaderRows;
				var endRow 		= sheetObj.HeaderRows + sheetObj.RowCount - 1;
				
				if(check){
					for(var Row=startRow; Row<=endRow; Row++){
						if(sheetObj.CellValue(Row, "act_brth_dt")==""){// SKIP PORT가 아닌데 ATB가 없으면 오류
							if(sheetObj.CellValue(Row, "act_crr_cd")!="SML" && (sheetObj.CellValue(Row, "vps_port_cd")=="EGSUZ" || sheetObj.CellValue(Row, "vps_port_cd")=="PAPAC")){ //타선사의 Canal은 Actual SKD 필수 아님
								check = true;
							}else if(sheetObj.CellValue(Row, "skd_cng_sts_cd")!="S"){
								ComShowMessage("[ATB/" + sheetObj.CellValue(Row, "vps_port_cd") + "] " + ComGetMsg("VSK00074"));
								check = false;
								break;
							}
						}
						
						if(sheetObj.CellValue(Row, "act_dep_dt")==""){// SKIP PORT가 아닌데 ATD가 없으면 오류. 마지막 ROW 제외
							if(sheetObj.CellValue(Row, "act_crr_cd") !="SML" && (sheetObj.CellValue(Row, "vps_port_cd")=="EGSUZ" || sheetObj.CellValue(Row, "vps_port_cd")=="PAPAC")){ //타선사의 Canal은 Actual SKD 필수 아님
								check = true;
							}else if(Row!=endRow && sheetObj.CellValue(Row, "skd_cng_sts_cd")!="S"){
								ComShowMessage("[ATD/" + sheetObj.CellValue(Row, "vps_port_cd") + "] " + ComGetMsg("VSK00074"));
								check = false;
								break;
							}
						}
					}
				}
			}else{
				check = false;
			}
			break;
			
		case IBDELETE:
			if(sheetObj.RowCount > 0 && formObj.vsl_cd.value!="" && formObj.voy_no.value!="" && formObj.dir_cd.value!=""){
				check = true;
			}else{
				check = false;
			}
			break;

		case REMOVE01:
			if(sheetObj.RowCount > 0 && grd_vvd !="" ){
				check = true;
			}else{
				check = false;
			}
			break;
			
			
		/**************************************************************
		 * Arrival Delay:Remark 입력 필수항목 조건변경::2013-02-26
		 * ------------------------------------------------------------
		 * [AS-IS]
		 * (Pf.ETB-Pf.ETD) (Ps.ETB - Ps.ETD) 0 이상이면 Remark 필수항목 
		 * 
		 * [TO-BE]
		 * as-is에서 이전24시간 이후48시간 이내의 지연은 정시로 간주한다는 Rule을
		 * 적용하여 -24< Arr.Delay < 48 범위를 벗어난 경우만 Remark 필수항목
		 * 
		 * [TO-BE::2013-03-29]
		 * as-is에서 이전24시간 이후24시간 이내의 지연은 정시로 간주한다는 Rule을
		 * 적용하여 -24< Arr.Delay < 24 범위를 벗어난 경우만 Remark 필수항목
		 **************************************************************/	
		//Save 버튼클릭시 실행로직임(update아님, update기능삭제됨)//
		case MULTI:		
			with(sheetObj){
				
				if(RowCount == 0){
					check = false;
					break;
				}
				
				// Delay CD가 있는 경우는 Delay Hour가 0보다 커야한다.
				for(var i=HeaderRows; i<=LastRow; i++){
					
					if(i!=HeaderRows && CellValue(i, "ibflag") != "D" ){
						
						//::2013-02-26:주석처리함::체크로직변경:://
						////check = compareOption(CellValue(i, "on_flg"), CellValue(i, "arr_dlay_rsn_cd1"));
						check = compareOption2(CellValue(i, "arr_dlay_hrs1"), CellValue(i, "arr_dlay_rsn_cd1"));
						
						if(!check) {
							break;
						}
						//check = compareOption(CellValue(i, "arr_dlay_hrs2"), CellValue(i, "arr_dlay_rsn_cd2"));
						//if(!check) break;
					}
				}
			
				// Actual Schedule이 비어있는 경우 Save 되지 않는다.
				// 단, SKIP PORT와 마지막 ATD는 예외로 한다.
				var startRow 	= sheetObj.HeaderRows;
				var endRow 		= sheetObj.HeaderRows + sheetObj.RowCount - 1;
				if(check){
					for(var Row=startRow; Row<=endRow; Row++){
						if (sheetObj.CellValue(Row, "ibflag")!="D") {
							
							//alert('act_brth_dt ['+sheetObj.CellValue(Row, "act_brth_dt")+']');
							//alert('skd_cng_sts_cd ['+sheetObj.CellValue(Row, "skd_cng_sts_cd")+']');
							//alert('act_brth_dt ['+sheetObj.CellValue(Row, "act_brth_dt")+']');
							
							if(sheetObj.CellValue(Row, "act_brth_dt")==""){// SKIP PORT가 아닌데 ATB가 없으면 오류
								if(sheetObj.CellValue(Row, "act_crr_cd") !="SML" && (sheetObj.CellValue(Row, "vps_port_cd")=="EGSUZ" || sheetObj.CellValue(Row, "vps_port_cd")=="PAPAC")){ //타선사의 Canal은 Actual SKD 필수 아님
									check = true;
								}else if(sheetObj.CellValue(Row, "skd_cng_sts_cd")!="S"){
									ComShowMessage("[ATB/" + sheetObj.CellValue(Row, "vvd") +"/" + sheetObj.CellValue(Row, "vps_port_cd") + "] " + ComGetMsg("VSK00074"));
									check = false;
									break;
								}
							}
							
							//::2013-04-16:://if(sheetObj.CellValue(Row, "act_dep_dt")==""){// SKIP PORT가 아닌데 ATD가 없으면 오류. 마지막 ROW 제외
							if(sheetObj.CellValue(Row, "act_dep_dt")=="" && sheetObj.CellValue(Row, "vvd_flg")!="L"){// SKIP PORT가 아닌데 ATD가 없으면 오류. 마지막 ROW 제외
								
								if(sheetObj.CellValue(Row, "act_crr_cd") !="SML" && (sheetObj.CellValue(Row, "vps_port_cd")=="EGSUZ" || sheetObj.CellValue(Row, "vps_port_cd")=="PAPAC")){ //타선사의 Canal은 Actual SKD 필수 아님
									check = true;
								}else if(Row!=endRow && sheetObj.CellValue(Row, "skd_cng_sts_cd")!="S"){
									ComShowMessage("[ATD/" + sheetObj.CellValue(Row, "vvd") +"/" + sheetObj.CellValue(Row, "vps_port_cd") + "] " + ComGetMsg("VSK00074"));
									check = false;
									break;
								}
							}
						}
					}
				}
				
			}
		}
		return check;
}


/**
* 날짜 Validation  
*/
function compareOption(on_flg, delayCd){
	var check = true;
	if((on_flg=="0" || on_flg=="") && delayCd != ""){
		//alert("Delay Reason Code는 0보다 큰 Delay Hour를 가져야 합니다.");
		ComShowCodeMessage("VSK00075");
		check = false;
	}else if(delayCd == "" && (on_flg!="0" && on_flg!="")){
		//alert("Delay Hour는 Delay Reason Code를 가져야 합니다.");
		ComShowCodeMessage("VSK00076");
		check = false;
	}
	return check;
}

/**
* 날짜 Validation  
*/
function compareOption2(arrDlayHrs1, delayCd){
	var check = true;
	
	if(arrDlayHrs1 == 0 && delayCd != ""){
		//alert("Delay Reason Code는 0보다 큰 Delay Hour를 가져야 합니다.");
		//Delay reason code must have delay hour where is bigger than '0'.
		ComShowCodeMessage("VSK00075");
		check = false;
	}else if(delayCd == "" && arrDlayHrs1 > 0){
		//alert("Delay Hour는 Delay Reason Code를 가져야 합니다.");
		//If any delay hour, Please be sure to input delay reason.
		ComShowCodeMessage("VSK00076");
		check = false;
	}
	return check;
}

/**
* 초기화   
*/
function doNew(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.lan_cd.value = "";
	formObj.vsl_cd.value = "";
	formObj.tmp_vsl_cd.value = "";
	formObj.voy_no.value = "";
	formObj.dir_cd.value = "";
// formObj.vsl_slan_cd.value = "";
	formObj.conv_clpt_seq.value = "";
// formObj.act_year.value = "";
// formObj.act_month.value = "";
// formObj.act_crr_cd.value = "";
	
	ComBtnEnable("btn_Save");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_VVD_Delete");
	
// ComBtnEnable("btn_Conversion");
	
	sheetObj.RemoveAll();
}

/**
* VVD Delete 구현 Row Hidden
*/
function doHidden(sheetObj){
 	var formObj = document.form;
	var start = sheetObj.HeaderRows;
	var end = sheetObj.HeaderRows + sheetObj.RowCount;
	var vvd = "";
	var vvdClrChk = "";
	sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비
	for(var i=start; i< end; i++){
		if (sheetObj.CellValue(i, "vvd") == grd_vvd ) {  
			sheetObj.CellValue2(i, "ibflag") = "D";  
	  	    sheetObj.RowHidden(i)= true;
		}   
        if (sheetObj.CellValue(i, "ibflag") != "D") {
			if (vvd == sheetObj.CellValue(i, "vvd") ) {
	        	sheetObj.CellBackColor(i, "vvd") = sheetObj.CellBackColor(i-1, "vvd"); 
	        	sheetObj.CellBackColor(i, "vps_port_cd") = sheetObj.CellBackColor(i-1, "vps_port_cd"); 
	        } else {
	        	vvd = sheetObj.CellValue(i, "vvd");
	            if (vvdClrChk == "0") {
	            	vvdClrChk = "1";  
	            	sheetObj.CellBackColor(i, "vvd") 		= sheetObj.RgbColor(202, 255, 112);	 
	            	sheetObj.CellBackColor(i, "vps_port_cd") = sheetObj.RgbColor(202, 255, 112);	 
	            	
	            } else {
	            	vvdClrChk = "0";
	            	sheetObj.CellBackColor(i, "vvd") 		= sheetObj.RgbColor(255, 255, 255);	
	            	sheetObj.CellBackColor(i, "vps_port_cd") = sheetObj.RgbColor(255, 255, 255);	 
	            }
	        }
        }	
        
	} 
	sheetObj.RedrawSum = true;	//합계 계산하기
}


function del_list(sheetObj){
	
	var formObj = document.form;
	var start = sheetObj.HeaderRows;
	var end = sheetObj.HeaderRows + sheetObj.RowCount;
	var vvd = "";
	
	for(var i=start; i< end; i++){
		 if (sheetObj.CellValue(i, "ibflag") == "D") {
			 
		 }
	}
}



