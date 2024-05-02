/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_5027.js
 *@FileTitle : AMS Report Print(Rail AMS)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.09
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.09 김도완
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
 * @author
 */

/**
 * @extends
 * @class esm_bkg_0881 : esm_bkg_0881 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_5027() {
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
var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */

	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_print":
			viewer.print({isServerSide:true});
			break;
		case "btn_close":
			window.close();
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
function loadPage(vvd, pod, del, bl) {
	rdOpen();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}

/*
 * RD 오픈  및 미리보기
 */
function rdOpen() {
	var sXml = "";
	var opener_obj = opener;
	var form1 = opener_obj.document.form;
	var opener_sheet_obj1 = opener_obj.sheet2;

	var customsReplyYn = "[ ]";
	var arrivalYn = "[ ]";
	var exportYn = "[ ]";

	var fromd = "";
	var tod = "";
	if (form1.date_search.checked) {
		if (form1.cust_arr_exp[0].checked) {
			customsReplyYn = "[*]";
		}
		if (form1.cust_arr_exp[1].checked) {
			arrivalYn = "[*]";
		}
		if (form1.cust_arr_exp[2].checked) {
			exportYn = "[*]";
		}
		fromd = form1.fromd.value + " " + form1.fromt.value;
		tod = form1.tod.value + " " + form1.tot.value;

	}
	var pmibTp = form1.pmib_tp.value;
	if (pmibTp == "0") {
		pmibTp = "";
	}
	var vvd = form1.vvd.value;
	if (vvd != "") {
		vvd = opener_sheet_obj1.GetCellValue(1, "vvd");
	}
	sXml = "<?xml version='1.0' ?><SHEET>";
	sXml += RD_GetDataSearchXml(opener_sheet_obj1, 1);
	sXml += "\n<ETC>";
	sXml += "<VVD>" + vvd + "</VVD>";
	sXml += "<POL>" + form1.pol.value + "</POL>";
	sXml += "<POD>" + form1.pod.value + "</POD>";
	sXml += "<HUB>" + form1.hub.value + "</HUB>";
	sXml += "<EQOFC>" + form1.eq_ofc.value + "</EQOFC>";
	sXml += "<BSTF>" + form1.b_stf.value + "</BSTF>";
	sXml += "<LREP>" + form1.l_rep.value + "</LREP>";
	sXml += "<RD>" + form1.rcv_term_cd.value + " / " + form1.de_term_cd.value + "</RD>";
	sXml += "<PMIB>" + pmibTp + "</PMIB>";
	sXml += "<FILER>" + form1.filer.value + "</FILER>";
	sXml += "<CUSTOMSRESULT>" + form1.customs_result_code_grp.value + " / " + form1.customs_result_code.value + "</CUSTOMSRESULT>";
	sXml += "<C>" + customsReplyYn + "</C>";
	sXml += "<A>" + arrivalYn + "</A>";
	sXml += "<E>" + exportYn + "</E>";
	sXml += "<FROMD>" + fromd + "</FROMD>";
	sXml += "<FROMT>" + form1.fromt.value + "</FROMT>";
	sXml += "<TOD>" + tod + "</TOD>";
	sXml += "<TOT>" + form1.tot.value + "</TOT>";
	sXml += "<MBL>" + form1.mbl_no.value + "</MBL>";
	sXml += "<AMSNO>" + form1.ams_file_no.value + "</AMSNO>";
	sXml += "</ETC>";
	sXml += "</SHEET>";

	// alert(sXml);

//	rdObjects[0].AutoAdjust = true; HTML5로 인한 주석처리
	// rdObjects[0].HideToolBar(); HTML5로 인한 주석처리
	// rdObjects[0].HideStatusBar(); HTML5로 인한 주석처리
//	rdObjects[0].ViewShowMode(0); HTML5로 인한 주석처리

//	rdObjects[0].SetBackgroundColor(128, 128, 128); HTML5로 인한 주석처리
//	rdObjects[0].SetPageLineColor(128, 128, 128); HTML5로 인한 주석처리
//	rdObjects[0].ApplyLicense("0.0.0.0"); HTML5로 인한 주석처리
	viewer.setRData(sXml);

	var urlPath = RD_path + 'apps/opus/esm/bkg/customsdeclaration/customsreport/usa/report/ESM_BKG_5027.mrd';
	// urlPath = "http://localhost:9001/opuscntr/apps/opus/esm/bkg/customsdeclaration/customsreport/report/"+mrdName;

	viewer.openFile(urlPath, RDServer,{timeout:1800});
//	rdObjects[0].SetPrint2(4,1,1,100); HTML5로 인한 주석처리
}

