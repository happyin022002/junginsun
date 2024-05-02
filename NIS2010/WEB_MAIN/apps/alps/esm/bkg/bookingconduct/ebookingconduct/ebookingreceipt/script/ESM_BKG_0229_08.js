/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_08.js
 *@FileTitle : e-Booking & SI Process Detail(DANGER)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.25
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.25 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
 2011.01.21 김영철 [] eBooking DG Tab 화면 오류 수정 ( Flash Point에 마이너스 값이 수동으로 입력시 입력되지 않아 수정함. )
 2011.10.05  정선용 [CHM-201113554-01]	[ALPS] E-BKG UNNO Seq 항목 추가 요청
 2011.11.14  정선용 [CHM-201114020-01]	(BASF) Dagerous Cargo MIG 로직 요청
 2011.12.06 정선용 [CHM-201114705-01]_BASF_Flat File 추가(Emergency Contact )
 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class esm_bkg_0229_08 : esm_bkg_0229_08 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_08() {
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

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isCopy = "false";

var dgPosition = 0;

var cntrTpsz_cd = "";
var cntrTpsz_id = "";

var prefix = "t8sheet1_";
var max_dcgo_seq = 0;
var add_cntr_cnt = 0; //jsy, 신규 cntr 추가시 1씩 증가
var max_dcgo_seq_cnt = 0; //jsy , dcgo_seq의 갯수 (sheet의 갯수)

var div1sheet1 = null;
var div2sheet1 = null;
var sheetObject1 = null;

//dg_rider 
var alpsCheckBoxString = '';
var xterCheckBoxString = '';
var ebkgDgSeqProblem = null;
var BKG_DIV_NAME = "_Bkg_div1_";
var BKG_FRAME_NAME = "_Bkg_iframe1_";
var BKG_DIV_NAME2 = "_Bkg_div2_";
var BKG_FRAME_NAME2 = "_Bkg_iframe2_";

var iframeW = 190;
var iframeH = 100;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetIdx = 0;
	div1sheet1 			= sheetObjects[sheetIdx++];
	div2sheet1 			= sheetObjects[sheetIdx++];
	var sheetObject = sheetObjects[sheetIdx++];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case IBCLEAR:
			doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
			break;

		case "btn_cancelcopydata":
			parent.document.form.dangerTabCancel.value = "Y";
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
			isCopy = "false";
			top.isCopyAllRequested = false;
			break;

		case "btn_datacopytoalps":
//			doSaveCopy();
			if (isCopy == "false") {
				dataCopy();
			}
			doSaveCopy();
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
			break;
		case "restrictions_btn":
				if(document.getElementById("bkg_no").value != ""){
					var imdg_un_no = document.getElementById("imdg_un_no").value;//sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no");
					var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;//sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "imdg_un_no_seq");
					var pol_cd = document.getElementById("pol_cd").value;
					var pod_cd = document.getElementById("pod_cd").value;	 								
					ComOpenWindowCenter("VOP_SCG_0021.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&slan_cd=", "VOP_SCG_0021", 1000, 600, true);
				}
			break;
			
		case "pre_checking_reports_btn":
				if(document.getElementById("bkg_no").value != ""){	 								
					ComOpenPopup("VOP_SCG_0069.do", 940, 950, "VOP_SCG_0069", "0,0,1,1,1,1,1", true);
				} 								 
			break;	
		case "btn_dgRider":
			doSaveCopy();
			// dg rider cgo seq 생성
			createDgRiderCntrHtml();
			showDgRider();
			break;		
		case "btn_dgRider2":
			
			showDgRider2();
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetIdx = 0;
    div1sheet1 			= sheetObjects[sheetIdx++];
    div2sheet1 			= sheetObjects[sheetIdx++];
    sheetObject1 			= sheetObjects[sheetIdx++];
    // DIV 초기화
    divLayer_Config();
	doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);
	initControl();
}

function initControl() {
 	var formObject = document.form;
 	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
 	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);

	applyShortcut();
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
		sheetObj.SheetWidth = 390;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 4, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(29, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|bkg_no|dcgo_seq|dg_cntr_seq|cntr_cgo_seq|cntr_no||max_dg_cntr_seq|max_cntr_cgo_seq|out_imdg_pck_qty1|out_imdg_pck_cd1|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtStatus, 50, daLeft, false, "ibflag");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "dcgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "dg_cntr_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cntr_cgo_seq");
			
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cntr_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cntr_tpsz_cd");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "max_dg_cntr_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "max_cntr_cgo_seq");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_un_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_un_no_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_clss_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_lmt_qty_flg");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "grs_wgt", false, "", dfNullFloat, 3);
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "net_wgt", false, "", dfNullFloat, 3);
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "wgt_ut_cd");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "flsh_pnt_cdo_temp", false, "", dfNullFloat, 3);
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "prp_shp_nm");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "hzd_desc");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_pck_grp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "mrn_polut_flg");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "emer_cntc_phn_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "emer_cntc_phn_no_ctnt");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "emer_cntc_pson_nm");

			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "dcgo_sts_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "spcl_stwg_rqst_desc");
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "imdg_comp_grp_cd");
			
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "out_imdg_pck_qty1", false, "", dfNullFloat, 3);
			sheetObj.InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "out_imdg_pck_cd1");

			sheetObj.CountPosition = 0;
		//}
		break;
	case "div1sheet1": //sheet1 init
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 150;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);
			//InitHeadMode(true, true, true, true, false,false)
			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";

			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(12, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "del_chk", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cargo_contain", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtImage, 5, daCenter, true, "multiPopup", false, "", dfNone, 0, true, true);

			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cargo_cnt");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");

			sheetObj.ImageList(0) = "img/alps/button/btns_multisearch.gif";
			sheetObj.ImageList(1) = "img/alps/button/btng_minus.gif";

			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
			sheetObj.FocusEditMode = 0;
		//}
		break;
	case "div2sheet1": //sheet1 init
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 150;
			//전체 너비 설정
		sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);
			//InitHeadMode(true, true, true, true, false,false)
			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";

			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(12, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "del_chk", false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 150, daCenter, false, "cargo_contain", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtImage, 5, daCenter, true, "multiPopup", false, "", dfNone, 0, true, true);

			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cargo_cnt");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");

			sheetObj.ImageList(0) = "img/alps/button/btns_multisearch.gif";
			sheetObj.ImageList(1) = "img/alps/button/btng_minus.gif";

			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
			sheetObj.FocusEditMode = 0;
		//}
		break;		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: //조회
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
			var formObj2 = document.form2;
			for ( var i = 0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("flsh_pnt_cdo_temp") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value = makeComma(formObj.elements[i].value);// ComAddComma3(formObj.elements[i].value, "#,###.00");
				}
				if (formObj.elements[i].name.indexOf("grs_wgt") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value = makeComma(formObj.elements[i].value);// ComAddComma3(formObj.elements[i].value, "#,###.000");
				}
				if (formObj.elements[i].name.indexOf("net_wgt") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value = makeComma(formObj.elements[i].value);// ComAddComma3(formObj.elements[i].value, "#,###.000");
				}
			}
			for ( var j = 0; j < formObj2.elements.length; j++) {
				if (formObj2.elements[j].name.indexOf("flsh_pnt_cdo_temp") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value = makeComma(formObj2.elements[j].value);// ComAddComma3(formObj2.elements[j].value, "#,###.00");
				}
				if (formObj2.elements[j].name.indexOf("grs_wgt") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value = makeComma(formObj2.elements[j].value);// ComAddComma3(formObj2.elements[j].value, "#,###.000");
				}
				if (formObj2.elements[j].name.indexOf("net_wgt") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value = makeComma(formObj2.elements[j].value);// ComAddComma3(formObj2.elements[j].value, "#,###.000");
				}
			}

			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			sheetObjects[2].LoadSearchXml(arrXml[0]);
			alpsCheckBoxString = ComGetEtcData(arrXml[0], "alpsCheckBoxString");
			xterCheckBoxString = ComGetEtcData(arrXml[0], "xterCheckBoxString");
			ebkgDgSeqProblem = ComGetEtcData(arrXml[0], "EBKG_DG_SEQ");
			if (sheetObjects[2].RowCount > 0) {
				//이 max_dcgo_seq 는 잘못 가져올수 있음 dcgo_seq가 이빨빠진 값일때. 밑에서 다시 체크함.
				max_dcgo_seq = sheetObjects[2].CellValue(sheetObjects[2].LastRow, "dcgo_seq");
			}
//			alert(arrXml.length);
			sheetObjects[0].LoadSearchXml(arrXml[2]);
			sheetObjects[1].LoadSearchXml(arrXml[3]);
			
			/* 값이 있을 경우 버튼 색 변화 */
			getBtnObject("btn_dgRider").style.color 		= (sheetObjects[0].TotalRows>0)     ?"blue":"#737373";
			getBtnObject("btn_dgRider2").style.color 		= (sheetObjects[1].TotalRows>0)     ?"blue":"#737373";
						
			// 이미지 변경하기
			sheetObjects[0].CellImage(row, "multiPopup") = 1;
			if (sheetObjects[0].RowCount > 0) {
				for ( var row = 1; row <= sheetObjects[0].LastRow; row++) {				
					if (sheetObjects[0].CellValue(row, "cargo_cnt") > 1) {
						sheetObjects[0].CellImage(row, "multiPopup") = 0;
					} else {
						sheetObjects[0].CellImage(row, "multiPopup") = 1;
					}
				}
			} 
			if (sheetObjects[1].RowCount > 0) {
				for ( var row = 1; row <= sheetObjects[1].LastRow; row++) {					
					if (sheetObjects[1].CellValue(row, "cargo_cnt") > 1) {
						sheetObjects[1].CellImage(row, "multiPopup") = 0;
					} else {
						sheetObjects[1].CellImage(row, "multiPopup") = 1;
					}
				}
			}			
		}
		max_dcgo_seq_cnt = sheetObjects[2].RowCount;
		for(var i=1;i<sheetObjects[2].Rows;i++){
			if(max_dcgo_seq<parseInt(sheetObjects[2].CellValue(i, "dcgo_seq"))){
				// 이값도 데이터의갯수와 다를수 있음, 이빨 빠진경우. 
				max_dcgo_seq = parseInt(sheetObjects[2].CellValue(i, "dcgo_seq"));
			}
		}
		if(parent.document.form.dangerTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			parent.document.form.dangerTabCancel.value = "N";
		}
		if(top.document.form.tabload8.value == "COPY"){
			dataCopy();
		} else {
			compareItem();			
		}

		if(parent.frames("t1frame").document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoalps");
		}
		top.document.form.tabload8.value = "LOAD";
		break;
		
	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_08.do";
		formObj.submit();
		parent.tabObjects[0].TabBackColor(7) = "#96c792";
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		var formObj2 = document.form2;
		// DHTML 테이블 생성
		var ins_tables = document.getElementById("INS_TABLES");
		ins_tables.innerHTML = "";
		var insTableDiv = "";

		var maxSeq = 0;
//		alert('formObj.elements.length:'+formObj.elements.length);
		for ( var k = 0; k < formObj.elements.length; k++) {
//			alert('formObj.elements[k].name:'+formObj.elements[k].name+' value:'+formObj.elements[k].value);
//			if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) { //jsy
			if ((formObj.elements[k].name).indexOf("dcgo_seq__") == 0) {
				if (eval(formObj.elements[k].value) > maxSeq)
					maxSeq = formObj.elements[k].value;
			}
		}
		// 컨테이너 비교
		var obj = null;
		var objNm = null;
		var objVal = null;
		
		var obj2 = null;
		var objNm2 = null;
		var objVal2 = null;

		var isInsert = "false";
		if (maxSeq > 0) {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "hidden" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					// 컨테이너번호
					if (objNm == "cntr_no_cmpr") {
						for ( var j = 0; j < formObj.elements.length; j++) {
							if (formObj.elements[j].type == "hidden" && (formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								objVal2 = formObj.elements[j].value;

								if (objNm2 == "cntr_no_cmpr") {
									if (objVal == objVal2) {
										isInsert = "false";
										break;
									} else {
										isInsert = "true";
									}
								}
							}
						}
						if (isInsert == "true") {
							maxSeq++;
							var insTableDiv = createTable(maxSeq);						
							ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
							createCntr(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							//delete 된건지 확인 필요 jsy 
							if( !checkDel(objVal2) ) {
								updateCntr(obj2[1], obj[1]);
							}
						}
					}
				}
			}
		} else {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv = createTable(maxSeq);
						ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}
		
		// dg rider copy
		
		if(div2sheet1.TotalRows>0){
			for(var i=1;i<div2sheet1.TotalRows + 1;i++){
				var isInsert = "true";
				for(var j=1;j<div1sheet1.TotalRows + 1;j++){
					if(div1sheet1.CellValue(j, "file_sav_id")==div2sheet1.CellValue(i, "file_sav_id")){						
						isInsert = "false"
						break;
					} else {
						isInsert = "true";
					}
				}

				if(isInsert=="true"){
					var newRow = div1sheet1.DataInsert(-1);
					div1sheet1.RowStatus(newRow) 					= "U";
                    div1sheet1.CellValue2(newRow, "file_nm"      )   = div2sheet1.CellValue(i, "file_nm"      );
                    div1sheet1.CellValue2(newRow, "file_size"    )   = div2sheet1.CellValue(i, "file_size"    );
                    div1sheet1.CellValue2(newRow, "cargo_contain")   = div2sheet1.CellValue(i, "cargo_contain");
                    div1sheet1.CellValue2(newRow, "file_path"    )   = div2sheet1.CellValue(i, "file_path"    );
                    div1sheet1.CellValue2(newRow, "ridr_tp_cd"   )   = div2sheet1.CellValue(i, "ridr_tp_cd"   );
                    div1sheet1.CellValue2(newRow, "file_sav_id"  )   = div2sheet1.CellValue(i, "file_sav_id"  );
                    div1sheet1.CellValue2(newRow, "img_seq"      )   = div2sheet1.CellValue(i, "img_seq"      );
                    div1sheet1.CellValue2(newRow, "cargo_cnt"    )   = div2sheet1.CellValue(i, "cargo_cnt"    );
                    div1sheet1.CellValue2(newRow, "dcgo_seq"     )   = div2sheet1.CellValue(i, "dcgo_seq"     );
                    div1sheet1.CellImage(newRow, "multiPopup") = 1;
				}
			}
		}

		parent.tabObjects[0].TabBackColor(7) = "#fff270";
		compareItem();
		initControl();
		break;
		
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		
		var params = getSaveStringForUpload();
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_08GS.do", params);
		
		if(ComBkgErrMessage(sheetObjects[2], sXml)) {
			sheetObj.LoadSaveXml(sXml);
			// 에러없으면 다시 조회
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
//	if (!sheetObj.IsDataModified) {
//		ComShowCodeMessage("BKG00743");
//		return false;
//	}
	if (!ComChkValid(formObj))
		return false;
	if(!chkUnNoSeq() ) 
		return false;
	return true;
}

function chkUnNoSeq() {
 	var formObj=document.form;
//	var maxSeq = 0;

	for ( var k = 0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("imdg_un_no_seq__") == 0) {
			if ( (formObj.elements[k].value == null) || (formObj.elements[k].value == '') ) {
//				maxSeq = formObj.elements[k].value;
				ComShowMessage(msgs['BKG02093']);
				return false;				
			} 
		}		
	}
	return true;
}
/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * Validate 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동
 * Focus 이동까지 한 후 return false
 */
function validateForUpload() {
	return validateForm(sheetObjects[2], document.form, IBSAVE);
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	// form 데이타를 sheet로 copy
	doSaveCopy();
	var formObj = document.form;
	var params = FormQueryString(formObj);
	if (sheetObjects[2].RowCount>=1) {
		params = params+ "&" + "f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), prefix);
	}
	params = params + "&"+ComSetPrifix(sheetObjects[0].GetSaveString(true), "dg_rider_");
	return (params);
}

 /**
  * e-Booking Upload Copy 팝업에서 [OK]버튼 클릭시
   */
function dataCopy() {
	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");
}

function doSaveCopy(){
 	var formObj=document.form;
	var sheetObj = sheetObjects[2];
	var maxSeq = 0;
	var maxCntrSeq = "1";
	
	for ( var k = 0; k < formObj.elements.length; k++) {
//		if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) { //jsy cntr_seq__ 는 중복되는 값이 있을수 있음 
		if ((formObj.elements[k].name).indexOf("dcgo_seq__") == 0 && !checkDelDcgoSeq(formObj.elements[k].value)) {
//          alps 의 갯수를 세는것 으로 변경 jsy			
//			if (eval(formObj.elements[k].value) > maxSeq)
//				maxSeq = formObj.elements[k].value;
			maxSeq++;
			if(sheetObj.CellValue(i, "max_dg_cntr_seq") > Number(maxCntrSeq))
				maxCntrSeq = sheetObj.CellValue(i, "max_dg_cntr_seq");
		}
	}
	// [Data Copy to ALPS]에 의해 생긴 New 
	for (var i = sheetObj.RowCount; i<maxSeq; i++) {
		sheetObj.DataInsert(-1); //마지막 행에 생성하기
//		alert('doSaveCopy:'+sheetObjects[2].RowCount);
	}
 	var obj=null;
 	var objNm=null;
 	var objSeq=null;
 	var objVal=null;
 	var cntrNo=null;
 	var ibflag=null;
 	
 	var newObjSeq=null;
 	var sheetRow=0;

 	for(var i=0; i<formObj.elements.length; i++) {
 		if ((formObj.elements[i].name).indexOf("__") > 0) {
 			obj = (formObj.elements[i].name).split("__");
 			objNm = obj[0];
 			objSeq = obj[1];
 			if( (i ==0 && sheetRow==0) || (objSeq != newObjSeq && objNm == "dcgo_seq" && !checkDelDcgoSeq(formObj.elements[i].value) ) || sheetObjects[2].RowStatus(sheetRow)== 'D' )  {
 				newObjSeq = obj[1];
 				sheetRow++;
 			}
 			objVal = formObj.elements[i].value;
 			if (sheetObjects[2].CellValue(sheetRow,"bkg_no") == "") {
 				sheetObjects[2].CellValue2(sheetRow,"bkg_no") = formObj.bkg_no.value;
 			}
 			if ( objNm == "dcgo_seq" && !checkDelDcgoSeq(formObj.elements[i].value) &&  sheetObjects[2].RowStatus(sheetRow)!= 'D' )			sheetObjects[2].CellValue2(sheetRow,"dcgo_seq") 			= objVal;
 			if ( objNm == "cntr_no" )			sheetObjects[2].CellValue2(sheetRow,"cntr_no") 			= ComTrimAll(objVal);
 			//add jsy 2011.10.24
 			if ( objNm == "cntr_seq" )			sheetObjects[2].CellValue2(sheetRow,"dg_cntr_seq")      = objVal;
 			/*if ( objNm == "cntr_seq" ){
                if(sheetObjects[2].CellValue(sheetRow,"ibflag") == "I" && ebkgDgSeqProblem == "ON") {
                    sheetObjects[2].CellValue2(sheetRow,"dg_cntr_seq")          = parseInt(objVal) + parseInt(maxCntrSeq); 
                } else {
                    sheetObjects[2].CellValue2(sheetRow,"dg_cntr_seq")          = objVal; 
                }
 			}*/
 			if ( objNm == "cntr_cgo_seq" )		sheetObjects[2].CellValue2(sheetRow,"cntr_cgo_seq") 		= objVal;
 			
 			if ( objNm == "cntr_tpsz_cd" )		sheetObjects[2].CellValue2(sheetRow,"cntr_tpsz_cd") 		= objVal;
 			if ( objNm == "imdg_un_no" )		sheetObjects[2].CellValue2(sheetRow,"imdg_un_no") 			= objVal;
 			if ( objNm == "imdg_un_no_seq" )	sheetObjects[2].CellValue2(sheetRow,"imdg_un_no_seq") 		= objVal;
 			if ( objNm == "imdg_clss_cd" )		sheetObjects[2].CellValue2(sheetRow,"imdg_clss_cd") 		= objVal;
 			if ( objNm == "imdg_lmt_qty_flg")	sheetObjects[2].CellValue2(sheetRow,"imdg_lmt_qty_flg") 	= objVal;
 			if ( objNm == "grs_wgt" ) 			sheetObjects[2].CellValue2(sheetRow,"grs_wgt") 				= objVal;
 			if ( objNm == "net_wgt" ) 			sheetObjects[2].CellValue2(sheetRow,"net_wgt") 				= objVal;
 			if ( objNm == "wgt_ut_cd" ) 		sheetObjects[2].CellValue2(sheetRow,"wgt_ut_cd") 			= objVal;
 			if ( objNm == "flsh_pnt_cdo_temp" ) sheetObjects[2].CellValue2(sheetRow,"flsh_pnt_cdo_temp") 	= objVal;
 			if ( objNm == "prp_shp_nm" ) 		sheetObjects[2].CellValue2(sheetRow,"prp_shp_nm") 			= objVal;
 			if ( objNm == "hzd_desc" ) 			sheetObjects[2].CellValue2(sheetRow,"hzd_desc") 			= objVal;
 			if ( objNm == "imdg_pck_grp_cd" ) 	sheetObjects[2].CellValue2(sheetRow,"imdg_pck_grp_cd") 		= objVal;
 			if ( objNm == "mrn_polut_flg" ) 	sheetObjects[2].CellValue2(sheetRow,"mrn_polut_flg") 		= objVal;
 			if ( objNm == "emer_cntc_phn_no" ) 	sheetObjects[2].CellValue2(sheetRow,"emer_cntc_phn_no") 	= objVal;
 			if ( objNm == "emer_cntc_phn_no_ctnt" ) 	sheetObjects[2].CellValue2(sheetRow,"emer_cntc_phn_no_ctnt") 	= objVal;
 			if ( objNm == "emer_cntc_pson_nm" )	sheetObjects[2].CellValue2(sheetRow,"emer_cntc_pson_nm") 	= objVal;
 			if ( objNm == "dcgo_sts_cd" )		sheetObjects[2].CellValue2(sheetRow,"dcgo_sts_cd") 			= objVal;
 			if ( objNm == "spcl_stwg_rqst_desc")sheetObjects[2].CellValue2(sheetRow,"spcl_stwg_rqst_desc")	= objVal;
 			if ( objNm == "imdg_comp_grp_cd")   sheetObjects[2].CellValue2(sheetRow,"imdg_comp_grp_cd")   	= objVal; //2011.09.30 add 			
 			if ( objNm == "out_imdg_pck_qty1")  sheetObjects[2].CellValue2(sheetRow,"out_imdg_pck_qty1")    = objVal; //2015.12.18 add
 		}
 	}
}

function compareItem() {
	var obj = null;
	var objNm = null;
	var objVal = null;
	var obj2 = null;
	var objNm2 = null;
	var objVal2 = null;
	var formObj  = document.form;
	var formObj2 = document.form2;	
	var sameCntr = "false";
	for ( var i = 0; i < formObj2.elements.length; i++) {
		if (formObj2.elements[i].type == "hidden"
				&& (formObj2.elements[i].name).indexOf("__") > 0) {
			obj = (formObj2.elements[i].name).split("__");
			objNm = obj[0];
			objVal = formObj2.elements[i].value;
			if (objNm == "cntr_no_cmpr") {
				for ( var j = 0; j < formObj.elements.length; j++) {
					if (formObj.elements[j].type == "hidden"
							&& (formObj.elements[j].name).indexOf("__") > 0) {
						obj2 = (formObj.elements[j].name).split("__");
						objNm2 = obj2[0];
						objVal2 = formObj.elements[j].value;

						if (objNm2 == "cntr_no_cmpr") {
							if (objVal == objVal2) {
								sameCntr = "true";
								break;
							} else {
								sameCntr = "false";
							}
						}
					}
				}
				if (sameCntr == "true") {
					if( !checkDel(objVal2) ) {
						compareCntr(obj2[1], obj[1]);
					}
				}
			}
		}
	}	
}

function createTable(seq) {
	var insTableDiv = "";
	insTableDiv = insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv = insTableDiv + "</div>\n";
	return insTableDiv;
}

function createCntr(leftSeq, rightSeq) {
	var formObj2 = document.form2;
	var tabSeq = "table_" + leftSeq;
	var dyntbl1 = document.getElementById(tabSeq);
	dyntbl1.innerHTML = "";
	var oCell1 = "";	

	oCell1 = oCell1 + "<table id=\"table" + leftSeq + "\" class=\"search\" border=\"0\">\n";
	
	//동일 여부를 비교하는 seq	
	oCell1 = oCell1 + "	<input type=\"hidden\" id=\"cntr_no_cmpr__" + leftSeq+"\" name=\"cntr_no_cmpr__" + leftSeq + "\" value=\""
//			+ eval("formObj2.cntr_no__" + rightSeq).value
			+ eval("formObj2.cntr_no_cmpr__" + rightSeq).value + "\">\n";
	
	add_cntr_cnt++; //신규 추가 jsy
	oCell1 = oCell1 + "<input type=\"hidden\" name=\"dcgo_seq__" + leftSeq + "\" value=\""
//			+ parseInt(parseInt(eval("formObj2.dcgo_seq__" + rightSeq).value) + parseInt(max_dcgo_seq)) + "\">\n";
	        + parseInt( parseInt(add_cntr_cnt) + parseInt(max_dcgo_seq)) + "\">\n";

	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "<td width=\"30\" valign=\"top\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
			//+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	        + "\" style=\"width:25;text-align:center;\" class=\"input\" value=\""  
	        + eval("formObj2.cntr_seq__" + rightSeq).value
	        + "\" readOnly></td>\n";
	oCell1 = oCell1 + "<td>\n";	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">\n";
	oCell1 = oCell1 + "<tr class=\"h23\">\n";		
	oCell1 = oCell1 + "		<td width=\"60\" colspan=\"2\">CNTR No.</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" colspan=\"2\">&nbsp;\n";
	oCell1 = oCell1 + "		  <select name=\"cntr_no__"
			+ leftSeq
			+ "\" style=\"width:105;\" class=\"input\" onChange=\"changeCntrNo(this,'"
			+ leftSeq + "')\">\n";

	var cntrTpsz_cdArr = cntrTpsz_cd.split("|");
	var cntrTpsz_idArr = cntrTpsz_id.split("|");
	for ( var j = 0; j < cntrTpsz_cdArr.length; j++) {
		if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
			continue;
		if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		}
	}

	//시작=========================================================================================================
	oCell1 = oCell1 + "		  </select>&nbsp;<input type=\"text\" dataformat='eng' name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" style=\"width:40;\" maxlength=\"2\" dataformat=\"etc\" class=\"input\" value=\""
			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\">";
	oCell1 = oCell1 + "</td>\n";	
	oCell1 = oCell1 + "<td width=\"\">\n";
	oCell1 = oCell1 + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\"><tr>"
	oCell1 = oCell1 + "<td class=\"btn2_left\"></td>"
	oCell1 = oCell1 + "<a href=\"javascript:btn_Restriction('"+ leftSeq + "');\"><td class=\"btn2\">Restriction</td></a>\n";
	oCell1 = oCell1 + "<td class=\"btn2_right\"></td>"
	oCell1 = oCell1 + "<td class=\"btn2_left\"></td>"
	oCell1 = oCell1 + "<a href=\"javascript:btn_PreChecking('"+ leftSeq + "');\"><td class=\"btn2\">Pre Checking</td></a>"
	oCell1 = oCell1 + "<td class=\"btn2_right\"></td>"
	oCell1 = oCell1 + "</tr></table>";
	oCell1 = oCell1 + "</td>\n"; 
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>";
	//1줄=========================================================================================================	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"27\">Seq.</td>\n";
	oCell1 = oCell1 + "		<td width=\"40\">&nbsp;<input type=\"text\" name=\"cntr_cgo_seq__" + leftSeq
			+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\""
			+ eval("formObj2.cntr_cgo_seq__" + rightSeq).value + "\"></td>\n";
	oCell1 = oCell1 + "		<td width=\"48\">UN No.</td>\n";
	oCell1 = oCell1 + "		<td width=\"100\">&nbsp;<input type=\"text\" required caption=\"UN No.\" dataformat='yy' name=\"imdg_un_no__" + leftSeq
			+ "\" style=\"width:40;\" maxlength=\"4\" class=\"input\" value=\""
			+ eval("formObj2.imdg_un_no__" + rightSeq).value + "\">&nbsp;"
			+ "<input name=\"imdg_un_no_seq__"+leftSeq+ "\" value=\""
			+ eval("formObj2.imdg_un_no_seq__" + rightSeq).value+"\" type=\"text\" style=\"width:20;\" class=\"input2\" readonly>"
			+ "<a href=\"javascript:comBkgCallPop0204_position('" + leftSeq + "');\">"
			+ "<img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a></td>\n";
	oCell1 = oCell1 + "		<td width=\"75\">IMDG Class</td>\n";
	oCell1 = oCell1 + "		<td width=\"60\">&nbsp;<input type=\"text\" dataformat='float' name=\"imdg_clss_cd__" + leftSeq
			+ "\" style=\"width:29;\" maxlength=\"3\" class=\"input2\" value=\""
			+ eval("formObj2.imdg_clss_cd__" + rightSeq).value + "\" readOnly>"
			+ "&nbsp;<input name=\"imdg_comp_grp_cd__"+leftSeq+"\" type=\"text\" style=\"width:20;\" class=\"input2\" value=\"" 
			+ eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value+"\" maxlength=\"1\" readonly>"
			+"</td>\n";
	oCell1 = oCell1 + "		<td width=\"\">Status&nbsp;<input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:55;color:blue\" class=\"input2\" value=\"New\"></td>\n";
			+ oCell1 + "	</tr></table>\n";
	//2줄=========================================================================================================
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">"
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"140\">Proper Shipping Name</td>\n";
	oCell1 = oCell1 + "		<td width=\"\"><input type=\"text\" name=\"prp_shp_nm__" + leftSeq + "\" dataformat='etc'"
			+ "\" style=\"width:298px;\" class=\"input\" value=\""
			+ eval("formObj2.prp_shp_nm__" + rightSeq).value + "\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>HAZ. Contents</td>\n";
	oCell1 = oCell1 + "		<td><textarea dataformat='etc' name=\"hzd_desc__" + leftSeq + "\" style=\"width:298px;height:40;\">"
			+ eval("formObj2.hzd_desc__" + rightSeq).value
			+ "</textarea></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//3줄=========================================================================================================	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">\n"
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"\">Flash Point</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" dataformat='signedfloat' name=\"flsh_pnt_cdo_temp__" + leftSeq
			+ "\" maxlength=\"7\" dataformat=\"float\" pointcount=\"2\" style=\"width:50;text-align:right\" maxlength=\"7\" class=\"input\" value=\""
			+ eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value
			+ "\">&nbsp;C&nbsp;&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"\">&nbsp;&nbsp;Packing Group</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" name=\"imdg_pck_grp_cd__" + leftSeq
			+ "\" style=\"width:30;\" maxlength=\"1\" class=\"input2\" value=\""
			+ eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value
			+ "\" readOnly>&nbsp;&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"\">Marine Pollutant</td>\n";
	oCell1 = oCell1 + "		<td width=\"\">\n";
	oCell1 = oCell1 + "		  <select name=\"mrn_polut_flg__" + leftSeq + "\" style=\"width:60;\">\n";

	var mrn1 = (eval("formObj2.mrn_polut_flg__" + rightSeq).value == "Y")?"selected":"";	
	var mrn2 = (eval("formObj2.mrn_polut_flg__" + rightSeq).value == "N")?"selected":"";

	oCell1 = oCell1 + "		    <option value=\"Y\" " + mrn1 + ">Yes</option>\n";
	oCell1 = oCell1 + "		    <option value=\"N\" " + mrn2 + ">No</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//4줄=========================================================================================================
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";
	oCell1 = oCell1 + " <tr class=\"h23\">\n";
	oCell1 = oCell1 + " 	<td width=\"85\">Gross Weight</td>\n";
	oCell1 = oCell1 + " 	<td width=\"160\" class=\"stm\"><input type=\"text\" dataformat='float' name=\"grs_wgt__" + leftSeq
			+ "\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" style=\"width:80;text-align:right\" class=\"input\" value=\""
			+ eval("formObj2.grs_wgt__" + rightSeq).value
			+ "\">&nbsp;<input type=\"text\" dataformat='engup' name=\"wgt_ut_cd__" + leftSeq
			+ "\" style=\"width:40;\" class=\"input2\" value=\""
			+ eval("formObj2.wgt_ut_cd__" + rightSeq).value + "\" readOnly></td>\n";
	oCell1 = oCell1 + " 	<td width=\"70\">Net Weight</td>\n";
	oCell1 = oCell1 + " 	<td width=\"\" class=\"stm\" colspan=\"2\"><input type=\"text\" dataformat='float' name=\"net_wgt__" + leftSeq
			+ "\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" style=\"width:80;text-align:right\" class=\"input\" value=\""
			+ eval("formObj2.net_wgt__" + rightSeq).value
			+ "\">&nbsp;<input type=\"text\" dataformat='engup' style=\"width:40;\" class=\"input2\" value=\""
			+ eval("formObj2.wgt_ut_cd__" + rightSeq).value + "\" readOnly></td>\n";
	oCell1 = oCell1 + " </tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//5줄=========================================================================================================	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"140\">Package quantity</td>"
			+ "<td width=\"\"><input type=\"text\" dataformat='float' name=\"out_imdg_pck_qty1__" + leftSeq
			+ "\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" style=\"width:80;text-align:right\" class=\"input\" value=\""
			+ eval("formObj2.out_imdg_pck_qty1__" + rightSeq).value
			+ "\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"140\">Contact Person</td>"
			+ "<td width=\"\"><input type=\"text\" dataformat='etc' name=\"emer_cntc_pson_nm__" + leftSeq
			+ "\" style=\"width:298;\" maxlength=\"100\" dataformat=\"engup\" class=\"input\" value=\""
			+ eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value
			+ "\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//5줄=========================================================================================================	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"140\">Emergency Contact</td>"
			+ "<td width=\"\"><input type=\"text\" dataformat='etc' name=\"emer_cntc_phn_no_ctnt__" + leftSeq
			+ "\" style=\"width:298;\" maxlength=\"100\" dataformat=\"engup\" class=\"input\" value=\""
			+ eval("formObj2.emer_cntc_phn_no_ctnt__" + rightSeq).value
			+ "\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"140\">Contact Person</td>"
			+ "<td width=\"\"><input type=\"text\" dataformat='etc' name=\"emer_cntc_pson_nm__" + leftSeq
			+ "\" style=\"width:298;\" maxlength=\"100\" dataformat=\"engup\" class=\"input\" value=\""
			+ eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value
			+ "\"></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//6줄=========================================================================================================	
	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"85\">Cargo Status</td>\n";
	oCell1 = oCell1 + "		<td width=\"160\">\n";
	oCell1 = oCell1 + "		  <select name=\"dcgo_sts_cd__" + leftSeq + "\" style=\"width:80;\" class=\"input\">\n";
	
	var dcgo1 = (eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "G")?"selected":"";
	var dcgo2 = (eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "L")?"selected":"";
	var dcgo3 = (eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "P")?"selected":"";
	var dcgo4 = (eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "S")?"selected":"";
	
	oCell1 = oCell1 + "		    <option value=\"G\" " + dcgo1 + ">Gas</option>\n";
	oCell1 = oCell1 + "		    <option value=\"L\" " + dcgo2 + ">Liquid</option>\n";
	oCell1 = oCell1 + "		    <option value=\"P\" " + dcgo3 + ">Paste</option>\n";
	oCell1 = oCell1 + "		    <option value=\"S\" " + dcgo4 + ">Sold</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "		<td width=\"75\">Limited Q'ty</td>\n";
	oCell1 = oCell1 + "		<td width=\"\">\n";
	oCell1 = oCell1 + "		  <select name=\"imdg_lmt_qty_flg__" + leftSeq
			+ "\" style=\"width:73;\" class=\"input\">\n";
	
	var imdg1 = (eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value == "Y")?"selected":"";
	var imdg2 = (eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value == "N")?"selected":"";
	
	oCell1 = oCell1 + "		    <option value=\"Y\" " + imdg1 + ">Yes</option>\n";
	oCell1 = oCell1 + "		    <option value=\"N\" " + imdg2 + ">No</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "</table>\n";
	//7줄=========================================================================================================	
	oCell1 = oCell1 + "<table class=\"search\" border=\"0\" width=\"100%\">";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"68\" valign=\"top\">Remark(s)</td>\n";
	oCell1 = oCell1 + "		<td width=\"250\"><textarea dataformat='etc' name=\"spcl_stwg_rqst_desc__"+ leftSeq
			+ "\" style=\"width:250;height:40;\">"
			+ eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value + " </textarea></td>\n";
	oCell1 = oCell1 + " <td width=\"85\">"
//			+ "				<table><tr class=\"h23\" bgcolor=\"\"><td width=\"\">D/G Rider&nbsp;</td>"
//			+ "				<td><a href=\"javascript:comBkgCallPop0207_position('D', '" + leftSeq + "');\">"
//			+ "					<img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a><br></td>\n"
//			+ "				</tr></table>\n";
	        + "\n";
	oCell1 = oCell1 + "		<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">\n";
	oCell1 = oCell1 + "		  <tr>\n";
	oCell1 = oCell1 + "		    <td class=\"btn2_left\"></td>\n";
	oCell1 = oCell1 + "		    <a href=\"javascript:btn_delete('table" + leftSeq + "', '" + leftSeq + "');\">"
			+ "					<td class=\"btn2\">Delete</td></a>\n";
	oCell1 = oCell1 + "		    <td class=\"btn2_right\"></td>\n";
	oCell1 = oCell1 + "		  </tr>\n";
	oCell1 = oCell1 + "		</table></td>\n";
	oCell1 = oCell1 + "	</tr></table>\n";
	oCell1 = oCell1 + "	<tr class=\"height_10\"><td colspan=\"8\"></td></tr>\n";
	oCell1 = oCell1 + "</table>\n";
//	ale"rt(oCell1);
	dyntbl1.innerHTML = oCell1;
}

function updateCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;

	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;

	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value = eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	
	if (eval("formObj2.imdg_un_no__" + rightSeq).value != null && eval("formObj2.imdg_un_no__" + rightSeq).value != '')
		eval("formObj.imdg_un_no__" + leftSeq).value = eval("formObj2.imdg_un_no__" + rightSeq).value;

	if (eval("formObj2.imdg_un_no_seq__" + rightSeq).value != null && eval("formObj2.imdg_un_no_seq__" + rightSeq).value != '')
		eval("formObj.imdg_un_no_seq__" + leftSeq).value = eval("formObj2.imdg_un_no_seq__" + rightSeq).value;
	
	if (eval("formObj2.imdg_clss_cd__" + rightSeq).value != null && eval("formObj2.imdg_clss_cd__" + rightSeq).value != '')
		eval("formObj.imdg_clss_cd__" + leftSeq).value = eval("formObj2.imdg_clss_cd__" + rightSeq).value;

	if (eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value != null && eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value != '')
		eval("formObj.imdg_comp_grp_cd__" + leftSeq).value = eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value;

	if (eval("formObj2.prp_shp_nm__" + rightSeq).value != null && eval("formObj2.prp_shp_nm__" + rightSeq).value != '')
		eval("formObj.prp_shp_nm__" + leftSeq).value = eval("formObj2.prp_shp_nm__" + rightSeq).value;
	
	if (eval("formObj2.hzd_desc__" + rightSeq).value != null && eval("formObj2.hzd_desc__" + rightSeq).value != '')
		eval("formObj.hzd_desc__" + leftSeq).value = eval("formObj2.hzd_desc__" + rightSeq).value;
	
	if (eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value != null && eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value != '')
		eval("formObj.flsh_pnt_cdo_temp__" + leftSeq).value = eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value;
	
	if (eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value != null && eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value != '')
		eval("formObj.imdg_pck_grp_cd__" + leftSeq).value = eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value;
	
	if (eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value != null && eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value != '')
		eval("formObj.emer_cntc_pson_nm__" + leftSeq).value = eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value;
	
	if (eval("formObj2.out_imdg_pck_qty1__" + rightSeq).value != null && eval("formObj2.out_imdg_pck_qty1__" + rightSeq).value != '')
		eval("formObj.out_imdg_pck_qty1__" + leftSeq).value = eval("formObj2.out_imdg_pck_qty1__" + rightSeq).value;
	
	if (eval("formObj2.mrn_polut_flg__" + rightSeq).value != null && eval("formObj2.mrn_polut_flg__" + rightSeq).value != '') {
		for ( var i = 0; i < eval("formObj.mrn_polut_flg__" + leftSeq).length; i++) {
			if (eval("formObj.mrn_polut_flg__" + leftSeq)[i].value == eval("formObj2.mrn_polut_flg__"
					+ rightSeq).value) {
				eval("formObj.mrn_polut_flg__" + leftSeq).selectedIndex = i;
				break;
			}
		}
	}

	if (eval("formObj2.dcgo_sts_cd__" + rightSeq).value != null && eval("formObj2.dcgo_sts_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.dcgo_sts_cd__" + leftSeq).length; j++) {
			if (eval("formObj.dcgo_sts_cd__" + leftSeq)[j].value == eval("formObj2.dcgo_sts_cd__"
					+ rightSeq).value) {
				eval("formObj.dcgo_sts_cd__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}

	if (eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value != null && eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value != '') {
		for ( var k = 0; k < eval("formObj.imdg_lmt_qty_flg__" + leftSeq).length; k++) {
			if (eval("formObj.imdg_lmt_qty_flg__" + leftSeq)[k].value == eval("formObj2.imdg_lmt_qty_flg__"
					+ rightSeq).value) {
				eval("formObj.imdg_lmt_qty_flg__" + leftSeq).selectedIndex = k;
				break;
			}
		}
	}
}

function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj = document.form;
	var formObj2 = document.form2;
	var tmp = eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color = "blue"
	} else {
		tmp.style.color = "#606060";
	}	
}

function compareCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;
	
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 		+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 		+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_un_no__" 			+ leftSeq).value, eval("formObj2.imdg_un_no__" 			+ rightSeq).value, ("formObj2.imdg_un_no__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_clss_cd__" 		+ leftSeq).value, eval("formObj2.imdg_clss_cd__" 		+ rightSeq).value, ("formObj2.imdg_clss_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.prp_shp_nm__" 			+ leftSeq).value, eval("formObj2.prp_shp_nm__" 			+ rightSeq).value, ("formObj2.prp_shp_nm__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.hzd_desc__" 			+ leftSeq).value, eval("formObj2.hzd_desc__" 			+ rightSeq).value, ("formObj2.hzd_desc__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.flsh_pnt_cdo_temp__" 	+ leftSeq).value, eval("formObj2.flsh_pnt_cdo_temp__" 	+ rightSeq).value, ("formObj2.flsh_pnt_cdo_temp__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_pck_grp_cd__" 		+ leftSeq).value, eval("formObj2.imdg_pck_grp_cd__" 	+ rightSeq).value, ("formObj2.imdg_pck_grp_cd__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.mrn_polut_flg__" 		+ leftSeq).value, eval("formObj2.mrn_polut_flg__" 		+ rightSeq).value, ("formObj2.mrn_polut_flg__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.emer_cntc_pson_nm__" 	+ leftSeq).value, eval("formObj2.emer_cntc_pson_nm__" 	+ rightSeq).value, ("formObj2.emer_cntc_pson_nm__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.dcgo_sts_cd__" 			+ leftSeq).value, eval("formObj2.dcgo_sts_cd__" 		+ rightSeq).value, ("formObj2.dcgo_sts_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_lmt_qty_flg__" 	+ leftSeq).value, eval("formObj2.imdg_lmt_qty_flg__" 	+ rightSeq).value, ("formObj2.imdg_lmt_qty_flg__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.grs_wgt__" 				+ leftSeq).value, eval("formObj2.grs_wgt__" 			+ rightSeq).value, ("formObj2.grs_wgt__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.net_wgt__" 				+ leftSeq).value, eval("formObj2.net_wgt__" 			+ rightSeq).value, ("formObj2.net_wgt__"			+ rightSeq));
	setCntrDiffCheckColor(ComTrim(eval("formObj.spcl_stwg_rqst_desc__" 	+ leftSeq).value), ComTrim(eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value), ("formObj2.spcl_stwg_rqst_desc__"+ rightSeq));
	setCntrDiffCheckColor(ComTrim(eval("formObj.out_imdg_pck_qty1__" 	+ leftSeq).value), ComTrim(eval("formObj2.out_imdg_pck_qty1__" + rightSeq).value), ("formObj2.out_imdg_pck_qty1__"+ rightSeq));	
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_un_no__" + leftSeq).value != eval("formObj2.imdg_un_no__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_un_no__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_clss_cd__" + leftSeq).value != eval("formObj2.imdg_clss_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_clss_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.prp_shp_nm__" + leftSeq).value != eval("formObj2.prp_shp_nm__" + rightSeq).value) {
//		var tmp = eval("formObj2.prp_shp_nm__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.hzd_desc__" + leftSeq).value != eval("formObj2.hzd_desc__" + rightSeq).value) {
//		var tmp = eval("formObj2.hzd_desc__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.flsh_pnt_cdo_temp__" + leftSeq).value != eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value) {
//		var tmp = eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_pck_grp_cd__" + leftSeq).value != eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_pck_grp_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.mrn_polut_flg__" + leftSeq).value != eval("formObj2.mrn_polut_flg__" + rightSeq).value) {
//		var tmp = eval("formObj2.mrn_polut_flg__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.emer_cntc_pson_nm__" + leftSeq).value != eval("formObj2.emer_cntc_pson_nm__" + rightSeq).value) {
//		var tmp = eval("formObj2.emer_cntc_pson_nm__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.dcgo_sts_cd__" + leftSeq).value != eval("formObj2.dcgo_sts_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.dcgo_sts_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_lmt_qty_flg__" + leftSeq).value != eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_lmt_qty_flg__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.spcl_stwg_rqst_desc__" + leftSeq).value != eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value) {
//		var tmp = eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq);
//		tmp.style.color = "blue";
//	}
}

function form_onChange(){
	var obj = document.getElementById(srcName);
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	var obj = document.getElementById(srcName);
	
	if (srcName.indexOf("grs_wgt") == 0) obj.value = makeComma(srcValue.replace(/,/g, ""));
	if (srcName.indexOf("net_wgt") == 0) obj.value = makeComma(srcValue.replace(/,/g, ""));

	compareItem();
}

function deleteAllTable() {
	var formObj = document.form;
	for ( var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}

function btn_deleteTable(tableId) {
	var formObj = document.form;
	var seq = 1;
	var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount = tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}

//	for ( var i = 0; i < formObj.elements.length; i++) {
//		var objNm = (formObj.elements[i].name).split("__");
//		if (objNm[0] == "cntr_seq") {
//			formObj.elements[i].value = seq++;
//		}
//	}
}

var delete_comp_data = ''; //jsy
var delete_dcgo_seq = ''; //jsy
function btn_delete(tableId, seq) {
	var formObj = document.form;
	delete_dcgo_seq = delete_dcgo_seq  + eval("formObj.dcgo_seq__" + seq).value+"|";
//	doSaveCopy();
	for (var i=1; i<sheetObjects[2].RowCount+1; i++) {
		if (sheetObjects[2].CellValue(i, "dcgo_seq") == eval("formObj.dcgo_seq__" + seq).value) {
			sheetObjects[2].RowStatus(i) = "D";
			delete_comp_data = delete_comp_data  + eval("formObj.cntr_no_cmpr__" + seq).value+"|";
			break;
		}
	}
	btn_deleteTable(tableId);
	doSaveCopy();
}

function checkDel(objVal2) {
	var obj = delete_comp_data.split('|');
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i] == objVal2) {
			return true;
		}
	}
	return false;
}

function checkDelDcgoSeq(objVal) {
	var obj = delete_dcgo_seq.split('|');
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i] == objVal) {
			return true;
		}
	}
	return false;
}

function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id = obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value = obj_id;
	}
}

function btn_Restriction(seq) {
	var formObj = document.form;
	var t1formObj = parent.frames("t1frame").document.form;

	var bkg_no 			= t1formObj.bkg_no.value;
	var imdg_un_no 		= eval("formObj.imdg_un_no__" + seq).value;
	var imdg_un_no_seq 	= eval("formObj.imdg_un_no_seq__" + seq).value;
	var vsl_cd 			= t1formObj.bkg_trunk_vvd.value.substring(0,4);
	var skd_voy_no 		= t1formObj.bkg_trunk_vvd.value.substring(4,8);
	var skd_dir_cd 		= t1formObj.bkg_trunk_vvd.value.substring(8,9); 
	var pol_cd 			= t1formObj.bkg_pol_cdvalue;
	var pod_cd 			= t1formObj.bkg_pod_cdvalue;	
	var slan_cd = "";
		 
	ComOpenWindowCenter("VOP_SCG_0021.do?bkg_no="+bkg_no+"&imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd+"&slan_cd="+slan_cd, "VOP_SCG_0021", 1020, 660, true);
}

function btn_PreChecking(seq) {
//	var iWidth = 1000;
//	var iHeight = 670;
//	var leftpos = (screen.width - iWidth) / 2;
//	if (leftpos < 0)
//		leftpos = 0;
//	var toppos = (screen.height - iHeight) / 2;
//	if (toppos < 0)
//		toppos = 0;
//	var formObj = document.form;
//	var param = "?bkgNo=" + formObj.bkg_no.value;
//	ComOpenWindow("/hanjin/VOP_SCG_0069.do" + param, "PopupVopScg0069",
//			"status=no, resizable=no, scrollbars=yes, width=" + iWidth
//					+ ", height=" + iHeight + ", left=" + leftpos + ", top="
//					+ toppos, false);
//	ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 700, "VOP_SCG_0069", "0,0,1,1,1,1,1", true, null, null, null, null, null, "yes");
}

/**
 * Making parameter of Pre-Checking
 */
function makePreChkParam() {     	  
	var formObj = document.form;
	var t1formObj = parent.frames("t1frame").document.form;

	var bkg_no 			= t1formObj.bkg_no.value;
	var vsl_cd 			= t1formObj.bkg_trunk_vvd.value.substring(0,4);
	var skd_voy_no 		= t1formObj.bkg_trunk_vvd.value.substring(4,8);
	var skd_dir_cd 		= t1formObj.bkg_trunk_vvd.value.substring(8,9); 
	var pol_cd 			= t1formObj.bkg_pol_cdvalue;
	var pod_cd 			= t1formObj.bkg_pod_cdvalue;	
	var slan_cd = "";
	  		
	var sParam = "";   		  		
	sParam += "rgn_shp_opr_cd=";
	sParam += "cgo_opr_cd=HJS";
	sParam += "&bkg_no=" + t1formObj.bkg_no.value;
	sParam += "&vsl_cd=" + t1formObj.bkg_trunk_vvd.value.substring(0,4);
	sParam += "&skd_voy_no=" + t1formObj.bkg_trunk_vvd.value.substring(4,8);
	sParam += "&skd_dir_cd=" + t1formObj.bkg_trunk_vvd.value.substring(8,9); 
//	sParam += "&crr_cd=" + document.getElementById("crr_cd").value;
	sParam += "&slan_cd=";
	sParam += "&pol_cd=" + t1formObj.bkg_pol_cdvalue;
	sParam += "&pod_cd=" + t1formObj.bkg_pod_cdvalue;   		
	return sParam;   		
}     
 
function loadCntrTpsz(cd, id) {
	cntrTpsz_cd = cd;
	cntrTpsz_id = id;
}

//function makeComma(obj) {
//	var arrVal = obj.value.split(".");
//	if (arrVal.length > 1) {
//		if (arrVal[1].length > 2) {
//			arrVal[1] = arrVal[1].substring(0, 2);
//		}
//		srcValue = makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
//	} else {
//		srcValue = makeCommaRun(arrVal[0]) + ".000";
//	}
//	return srcValue;
//}

function makeComma(srcValue) {
	var arrVal = srcValue.split(".");

	if (arrVal.length > 1) {
		srcValue = makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue = makeCommaRun(arrVal[0]) + ".000";
	}
	
	return srcValue;
}

function makeCommaRun(srcValue) {
	srcValue = srcValue.replace(/-\D/g, "");
//	if ( srcValue.substr(0, 1) == "-" ) {
//		srcValue = "-" + srcValue.replace(/\D/g, "");
//	} else {
//		srcValue = srcValue.replace(/\D/g, "");
//	}
	if (srcValue.length > 9) {
		srcValue = srcValue.substring(0, 9);
	}
	l = srcValue.length - 3;
	while (l > 0) {
		srcValue = srcValue.substr(0, l) + "," + srcValue.substr(l);
		l -= 3;
	}
	return srcValue;
}

function comBkgCallPop0204_position(pos) {
	var formObj = document.form;
	dgPosition = pos;
	var param = "?imdg_un_no=" + eval("formObj.imdg_un_no__" + pos).value;
	//ComOpenPopup("ESM_BKG_0204.do" + param, 900, 400, "setCallBack0204","1,0,1,1,1,1,1,1", false);
	
	ComOpenPopup("ESM_BKG_0204.do"+param, 900, 470, "setCallBack0204", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
}

function setCallBack0204(aryPopupData) {
	var formObj = document.form; 
	eval("formObj.imdg_un_no__" + dgPosition).value = aryPopupData[0][2];
	eval("formObj.imdg_un_no_seq__" + dgPosition).value = aryPopupData[0][3];
	eval("formObj.imdg_clss_cd__" + dgPosition).value = aryPopupData[0][4];
	eval("formObj.imdg_comp_grp_cd__" + dgPosition).value = aryPopupData[0][5];
	eval("formObj.prp_shp_nm__" + dgPosition).value = aryPopupData[0][7];
	eval("formObj.imdg_pck_grp_cd__" + dgPosition).value = aryPopupData[0][6];
}

function comBkgCallPop0207_position(cd, pos) {
	var bkg_no = parent.frames("t1frame").document.form.bkg_no.value;
	ComOpenPopup("ESM_BKG_0207.do?bkg_no="+bkg_no+"&ridr_tp_cd=D", 525, 520, "", "0,0,1,1,1,1,1", true);
//	var formObj = document.form;
//	dgPosition = pos;
//	var param = "?bkg_no=" + formObj.bkg_no.value + "&ridr_tp_cd=" + cd;
//	ComOpenWindow("/hanjin/ESM_BKG_0207.do" + param, "PopupEsmBkg0207",
//			"dialogWidth:525px; dialogHeight:550px", true);
}

function showDgRider() {
	if (document.all.dgRider.style.visibility == 'hidden')
		document.all.dgRider.style.visibility = 'visible';
	else {
		hiddenSelectForm();
		document.all.dgRider.style.visibility = 'hidden';	
	}		
}

function showDgRider2() {
	if (document.all.dgRider2.style.visibility == 'hidden')
		document.all.dgRider2.style.visibility = 'visible';
	else {
		hiddenSelectForm2();
		document.all.dgRider2.style.visibility = 'hidden';	
	}		
}

/**
 * 마우스 다운 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
var current_Row = 0;
var current_Equal = false;
function div1sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

	var m_row = sheetObjects[0].MouseRow;
	var m_col = sheetObjects[0].MouseCol;

	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 130;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe01.document.getElementById('ContainerList').innerHTML = alpsCheckBoxString;
				//보여주기 
				showSelectForm(gtop, gleft);
			} else {
				//감추기 
				hiddenSelectForm();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm();
		}
	} catch (ex) {
		bkg_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}

function div2sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

	var m_row = sheetObjects[1].MouseRow;
	var m_col = sheetObjects[1].MouseCol;

	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 200;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe02.document.getElementById('ContainerList').innerHTML = xterCheckBoxString;
				//보여주기 
				showSelectForm2(gtop, gleft);

			} else {
				//감추기 
				hiddenSelectForm2();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm2();
		}
	} catch (ex) {
		bkg_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}

/**
 * alps
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck();

			if (count_checked > 1) {
				sheetObjects[0].CellImage(current_Row, "multiPopup") = 0;
			} else {
				sheetObjects[0].CellImage(current_Row, "multiPopup") = 1;
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm', ex);
		return false;
	}
}
 
/**
 * e-svc
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm2() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd2))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck2();

			if (count_checked2 > 1) {
				sheetObjects[1].CellImage(current_Row, "multiPopup") = 0;
			} else {
				sheetObjects[1].CellImage(current_Row, "multiPopup") = 1;
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm2', ex);
		return false;
	}
}
 
/**
 * alps
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked = 0;
function setMultiSelectCheck() {
	try {
		var t_ck = iframe01.document.getElementsByName('t_check');
		var t_nm = iframe01.document.getElementsByName('t_name');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked++;
			}
		}

		sheetObjects[0].CellValue2(current_Row, "dcgo_seq") = r_value;
		sheetObjects[0].CellValue2(current_Row, "cargo_contain") = r_text;
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck', ex);
		return false;
	}
}

/**
 * e-svc
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked2 = 0;
function setMultiSelectCheck2() {
	try {
		var t_ck = iframe02.document.getElementsByName('t_check2');
		var t_nm = iframe02.document.getElementsByName('t_name2');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked2 = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked2++;
			}
		}

		sheetObjects[1].CellValue2(current_Row, "dcgo_seq") = r_value;
		sheetObjects[1].CellValue2(current_Row, "cargo_contain") = r_text;
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck2', ex);
		return false;
	}
}

/**
 * 멀티 SELECT 이벤트 DIV Layer창 생성 
 * 
 */
function divLayer_Config() {
	var iframeHTML = 'apps/alps/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargorider/jsp/ESM_BKG_0207.HTML';

	//alsp
	var _divWait = document.createElement("<div id='" + BKG_DIV_NAME + "'  name='div01'  style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;'/>");
	document.body.insertBefore(_divWait);

	var _frameWait = document.createElement("<IFRAME id='" + BKG_FRAME_NAME + "' name='iframe01' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
	_divWait.appendChild(_frameWait);
	//e-svc
	var _divWait2 = document.createElement("<div id='" + BKG_DIV_NAME2 + "'  name='div02'  style='position:absolute; cursor:wait; left:550px; top:0px; width:190px; height:100%; z-index:999; visibility:hidden;'/>");
	document.body.insertBefore(_divWait2);
	
	var _frameWait2 = document.createElement("<IFRAME id='" + BKG_FRAME_NAME2 + "' name='iframe02' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
	_divWait2.appendChild(_frameWait2);
}
 
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm(topPos, leftPos) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {

		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}

		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.CellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}
 
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm2(topPos, leftPos) {
	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {
		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}

		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.CellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck2(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}

/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck(_check) {
	try {
		var t_nm = iframe01.document.getElementsByName('t_check');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck', ex);
		return false;
	}
}
 
/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck2(_check) {
	try {
		var t_nm = iframe02.document.getElementsByName('t_check2');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck2', ex);
		return false;
	}
}

function createDgRiderCntrHtml() {
	var oCell1 = "";	
	oCell1 = oCell1 + "<table width=\'100%\' class=\'grid2\' border=\'0\' id= \'t_table\'>\n";
	var selectedRowCnt = 0;
	var cntrList ="";
	if(sheetObjects[2].RowCount >= 1) {		
		for ( var row = 1; row <= sheetObjects[2].LastRow; row++) {
//			if( sheetObjects[2].CellValue(row, "cntr_no" ) !="") {
				if( (sheetObjects[2].CellValue(row, "cntr_no").length > 0 &&  cntrList.indexOf(sheetObjects[2].CellValue(row, "cntr_no" )) < 0 ) ||
						sheetObjects[2].CellValue(row, "cntr_no").length == 0	) {
					
					cntrList = cntrList + sheetObjects[2].CellValue(row,"cntr_no");
					selectedRowCnt++;
					oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10%\' align=\'center\'>";
					oCell1 = oCell1 + "<input type=\'checkbox\' name=\'t_check\'  value=\'"+sheetObjects[2].CellValue(row,"dcgo_seq")+"\'></td>";
					oCell1 = oCell1 + "<td width=\'90%\' align=\'center\'>"+sheetObjects[2].CellValue(row,"cntr_no")+" / "+ sheetObjects[2].CellValue(row,"cntr_cgo_seq")+"</td>";
					oCell1 = oCell1 + "<input type=\'hidden\' name=\'t_name\' value=\'"+sheetObjects[2].CellValue(row,"cntr_no")+" / "+ sheetObjects[2].CellValue(row,"cntr_cgo_seq")+"\'></tr>";
				}
//			} 
		}
		if( selectedRowCnt == 0 ){
			oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10%\' align=\'center\'>";
			oCell1 = oCell1 + "no data... </td></tr>";
		}
	} else {
		oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10%\' align=\'center\'>";
		oCell1 = oCell1 + "no data... </td></tr>";
	}
	oCell1 = oCell1 + "</table>";
	alpsCheckBoxString = oCell1;	
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function div1sheet1_OnClick(sheetObj, Row, Col, Value) {
	 if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

function div2sheet1_OnClick(sheetObj, Row, Col, Value) {
	 if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}