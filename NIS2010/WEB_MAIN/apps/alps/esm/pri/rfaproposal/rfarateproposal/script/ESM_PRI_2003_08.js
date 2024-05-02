/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2003_08.js
 *@FileTitle : RFA Proposal Creation - Rate For AEE, AEW
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.10
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================
* History
* 2014.02.05 서미진 [CHM-201428775] Accept All 클릭 시 경고 문구 추가        
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가                             
* 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
* 2015.05.14 전지예 [CHM-201535967] Rate Accept All 팝업화면 순서 변경
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
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
 * @class Guideline Creation : Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2003_08() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var sheetObjects2 = new Array(); // 신규로 추가된 sheet. 기존 로직 보호 위해
var sheetCnt2 = 0;

var tabLoad = new Array();
tabLoad[0] = 0;
tabLoad[1] = 0;

// Sheet2(Route Group Grid)가 완전히 로드되지 않은경우, OnClick 이벤트를 무시하기 위한 플래그
var LoadingComplete = false;
// 사용자가 작성권자인지를 나타내는 플래그
var bIsReqUsr = false;
// 사용자가 승인권자인지를 나타내는 플래그
var bIsAproUsr = false;

// 현재Rate에 승인된 건수가 몇개인지를 저장하는 변수.
var acptCnt = null;
// 현재Rate에 미승인 건수가 몇개인지를 저장하는 변수.
var notAcptCnt = null;

// Origin Via.가 Mandatory인지 여부.
var isOViaMandatory = false;
// Dest. Via.가 Mandatory인지 여부.
var isDViaMandatory = false;

// 화면 reload시 Sheet1,2,3의 현재 Row 및 key값을 미리 저장하는 변수들. s1:Sheet1, s2:Sheet2, s3:Sheet3
var s1PrevRow = -1;
var s2PrevRow = -1;
var s3PrevRow = -1;
var s1PrevKey = null;
var s2PrevKey = null;
var s3PrevKey = null;

// Main의 Summary테이블에 저정하기 위한 코드값.
var TERMS_TYPE_CODE_GEN = 71;

// ComboBox에는 표시되지 않지만 이행데이타에 존재하는 Rating Unit 코드.
var unusedRatUtCd = "|20|40|CT|DF|DW|HC|UN";
// Group이 삭제된 Row일경우, 팝업창에서 Group을 다시 살리는 action을 했을 경우 이를 기억하기 위한 변수.
var reloadSw = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
 * @version 2012.07.10
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
			if (getButtonTable(srcName).disabled) {
				return false;
			}
		}
		switch (srcName) {
		case "btn_retrieve":
			comUpdateTypeFontStyle();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_acceptall":
			if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
        		if(formObject.amdt_seq.value != '0'){
        			ComShowCodeMessage("PRI07053");
        		}
        		// M/B popup
        		var sUrl = "/hanjin/ESM_PRI_2055.do?" + FormQueryString(formObject);
        		ComOpenWindowCenter(sUrl, "ESM_PRI_2055", 580, 340, true);
        		
//				var sParam = FormQueryString(formObject) + "&n_acpt_cnt=" + notAcptCnt;
//				if (getRateSheet().id == "sheet17") {
//					sParam += "&fic_rt_tp_cd=A";
//				}
//				ComPriOpenWindowCenter("/hanjin/ESM_PRI_2036.do?" + sParam, "ESM_PRI_2036", 1000, 645, false);
				var sParam = FormQueryString(formObject) + "&is_accept_all=Y";
				
                var iWidth = 1018;
                var iHeight = 645;
                var leftpos = (screen.width - iWidth) / 2;
                if (leftpos < 0)
                    leftpos = 0;
                var toppos = (screen.height - iHeight) / 2;
                if (toppos < 0)
                    toppos = 0;

                var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
				ComPriOpenWindow("/hanjin/ESM_PRI_2036.do?" + sParam, "ESM_PRI_2036", sFeatures, iHeight);
			}
			break;

		case "btn_cancel":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			break;

		case "btn_glcopy":
			if (!ComShowCodeConfirm("PRI01009")) {
				return false;
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
			break;

		case "btn_gricalc":
			formObject.f_cmd.value = '';
			if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
				if (funcCheckFicRtTpCdVal() == 'A') {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2035.do?" + FormQueryString(formObject), "ESM_PRI_2035", 1000, 490, false);
				} else {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2033.do?" + FormQueryString(formObject), "ESM_PRI_2033", 1000, 490, false);
				}
			}
			break;

		case "btn_checkduplicate":
			if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
				var sParam = FormQueryString(formObject);
				ComPriOpenWindowCenter("/hanjin/ESM_PRI_2034.do?" + sParam, "ESM_PRI_2034", 1000, 443, false);
			}
			break;

		case "btn_downexcel":
			if (formObject.prop_no.value == "" || formObject.amdt_seq.value == "" || formObject.svc_scp_cd.value == "") {
				return;
			}

			execScript("rtn = msgbox(\"" + ComGetMsg("PRI01080") + "\", 3, \"Download Excel\")", "vbscript");
			if (rtn == 6) {
				doActionIBSheet(sheetObjects[12], document.form, IBDOWNEXCEL);
			} else if (rtn == 7) {
				doActionIBSheet(sheetObjects[13], document.form, IBDOWNEXCEL);
			}
			break;

		case "btn_loadexcel":
			if (formObject.prop_no.value == "" || formObject.amdt_seq.value == "" || formObject.svc_scp_cd.value == "") {
				return;
			}

			execScript("rtn = msgbox(\"" + ComGetMsg("PRI01080") + "\", 3, \"Load Excel\")", "vbscript");
			formObject.f_cmd.value = "";
			if (funcCheckFicRtTpCdVal() == 'A') {
				if (rtn == 6) {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2067.do?" + FormQueryString(formObject), "ESM_PRI_2067", 950, 563, false);
				} else if (rtn == 7) {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2068.do?" + FormQueryString(formObject), "ESM_PRI_2068", 950, 563, false);
				}
			} else {
				if (rtn == 6) {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2065.do?" + FormQueryString(formObject), "ESM_PRI_2065", 950, 563, false);
				} else if (rtn == 7) {
					ComPriOpenWindowCenter("/hanjin/ESM_PRI_2060.do?" + FormQueryString(formObject), "ESM_PRI_2060", 950, 563, false);
				}
			}
			break;

		case "btn_rowadd1":
			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
			break;

		case "btn_rowadd2":
			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
			break;

		case "btn_rowadd3":
			doActionIBSheet(getRateSheet(), document.form, IBINSERT);
			break;

		case "btn_rowcopy1":
			doActionIBSheet(sheetObjects[0], document.form, IBCOPYROW);
			break;

		case "btn_rowcopy2":
			doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
			break;

		case "btn_delete1":
			doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
			break;

		case "btn_delete2":
			doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
			break;

		case "btn_delete3":
			doActionIBSheet(getRateSheet(), document.form, IBDELETE);
			break;

		case "btn_save1":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

			// Rate 수정 시 M/B버튼 활성화 여부 변경
			if (document.form.prc_prop_sts_cd.value == "I" || document.form.prc_prop_sts_cd.value == "R") {
				checkMatchBackEnable();
			}
			break;

		case "btn_save2":
			doActionIBSheet(getRateSheet(), document.form, IBSAVE);

			// Rate 수정 시 M/B버튼 활성화 여부 변경
			if (document.form.prc_prop_sts_cd.value == "I" || document.form.prc_prop_sts_cd.value == "R") {
				checkMatchBackEnable();
			}
			break;

		case "btn_save3":
			doActionIBSheet(getRateSheet(), document.form, IBSAVE);
			
			// Rate 수정 시 M/B버튼 활성화 여부 변경
			if (document.form.prc_prop_sts_cd.value == "I" || document.form.prc_prop_sts_cd.value == "R") {
				checkMatchBackEnable();
			}
			break;

		case "btn_amend3":
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH_ASYNC11);
			break;

		case "btn_amendcancel3":
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH_ASYNC12);
			break;

		case "btn_accept3":
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH_ASYNC13);
			break;

		case "btn_acceptcancel3":
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH_ASYNC14);
			break;

		case "btn_specification":
			if (!checkCmdtEditable() || getRateSheet().CellValue(getRateSheet().SelectRow, "prc_cgo_tp_cd") != "AK") {
				return false;
			}

			ComPriOpenWindowCenter("/hanjin/ESM_PRI_2047.do?" + FormQueryString(formObject) + "&rt_seq=" + getRateSheet().CellValue(getRateSheet().SelectRow, "rt_seq"), "ESM_PRI_2047", 700, 410,
					false);
			break;

		case "btn_calculate":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
			break;
			
		case "btn_mb":
			var sUrl = "/hanjin/ESM_PRI_2055.do?" + FormQueryString(formObject);
			ComOpenWindowCenter(sUrl, "ESM_PRI_2055", 580, 340, true);
			
			break;

		case "btn_schgdetail":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}

			var sUrl = "/hanjin/ESM_PRI_6070.do?" + FormQueryString(formObject);
			sUrl += "&rt_seq=" + getRateSheet().CellValue(getRateSheet().SelectRow, "rt_seq");

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6070", 900, 569, true);
			if (rtnVal == "SUCCESS") {
				doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
			}
			break;

		case "btn_schgadjust":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}

			var sUrl = "/hanjin/ESM_PRI_6073.do?" + FormQueryString(formObject);

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6073", 900, 419, true);
			if (rtnVal == "SUCCESS") {
				doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
			}
			break;

		case "btn_costdetail":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}

			var sUrl = "/hanjin/ESM_PRI_6064.do?" + FormQueryString(formObject);
			sUrl += "&rt_seq=" + getRateSheet().CellValue(getRateSheet().SelectRow, "rt_seq");
			sUrl += "&cost_tp=" + getRdoPRSCostLevel().charAt(0); // C :CM, O:OP
			sUrl += "&revenue="
					+ (parseFloat(ComPriNvl(getRateSheet().CellValue(getRateSheet().SelectRow, "prop_frt_rt_amt"), 0)) + parseFloat(ComPriNvl(getRateSheet().CellValue(getRateSheet().SelectRow,
							"prs_scg_amt"), 0)));
			sUrl += "&cargo=" + getRateSheet().CellValue(getRateSheet().SelectRow, "prc_cgo_tp_cd");
			sUrl += "&per=" + getRateSheet().CellValue(getRateSheet().SelectRow, "rat_ut_cd");
			sUrl += "&contract_ofc=" + parent.document.form.prop_ofc_cd.value;

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6064", 900, 605, true);
			if (rtnVal == "SUCCESS") {
				// doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
				doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
			}
			break;

		case "btn_costbytransmode":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}

			var sUrl = "/hanjin/ESM_PRI_6067.do?" + FormQueryString(formObject);
			sUrl += "&cost_tp=" + getRdoPRSCostLevel().charAt(0); // C :CM, O:OP

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6067", 900, 400, true);
			break;
		case "btn_schgviewall":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}
			var sUrl = "/hanjin/ESM_PRI_6087.do?" + FormQueryString(formObject);
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6087", 1000, 620, true);
			break;

		case "btn_cmpbviewall":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}
			var sUrl = "/hanjin/ESM_PRI_6047.do?" + FormQueryString(formObject);
			sUrl += "&cost_tp=" + getRdoPRSCostLevel().charAt(0); // C :CM, O:OP

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6047", 1000, 435, true);
			break;

		case "btn_cmviewall":
			if (getRateSheet().IsDataModified) {
				ComShowCodeMessage("PRI00309", "Rate");
				return false;
			}

			var sUrl = "";
			var pgmNm = "";

			if (formObject.amdt_seq.value == "0") {
				sUrl = "/hanjin/ESM_PRI_6048.do?" + FormQueryString(formObject);
				pgmNm = "ESM_PRI_6048"
			} else {
				sUrl = "/hanjin/ESM_PRI_6049.do?" + FormQueryString(formObject);
				pgmNm = "ESM_PRI_6049"
			}

			sUrl += "&cost_tp=" + getRdoPRSCostLevel().charAt(0); // C :CM, O:OP

			var rtnVal = ComPriOpenWindowCenter(sUrl, pgmNm, 1000, 520, true);
			if (rtnVal == "SUCCESS") {
				doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
				parent.getPRSCMData();
			}
			break;

		case "rdoPRSCostLevel":
			onCickRdoPRSCostLevel();
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
 * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * initControl()
 * </pre>
 * 
 * @param 없음
 * @return 없음
 * @author 이은섭
 * @version 2009.04.17
 */
function initControl() {
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListener('mouseover', 'btn_calculate_OnMouseOver', 'btn_calculate');
	axon_event.addListener('mouseout', 'btn_calculate_OnMouseOut', 'btn_calculate');
	axon_event.addListenerForm('click', 'obj_click', form);
}

/**
 * Sheet3상단의 PRS Cost Level 라디오 버튼을 클릭했을때의 화면처리.
 * 
 * 
 * @param 없음
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function onCickRdoPRSCostLevel() {
	if (bIsReqUsr || bIsAproUsr) {
		// var sheetObj = sheetObjects[2];
		var sheetObj = getRateSheet();
		if (getRdoPRSCostLevel() == "CM") {
			sheetObj.ColHidden("prs_respb_cm_uc_amt") = false;
			sheetObj.ColHidden("prs_respb_opfit_uc_amt") = true;
			sheetObj.ColHidden("prs_gid_cmpb_amt") = false;
			sheetObj.ColHidden("prs_respb_opb_amt") = true;
			sheetObj.ColHidden("diff") = false;

			btn_cmpbviewall.innerText = "CMPB View All";
			btn_cmviewall.innerText = "CM View All";
		} else if (getRdoPRSCostLevel() == "OP") {
			sheetObj.ColHidden("prs_respb_cm_uc_amt") = true;
			sheetObj.ColHidden("prs_respb_opfit_uc_amt") = false;
			sheetObj.ColHidden("prs_gid_cmpb_amt") = true;
			sheetObj.ColHidden("prs_respb_opb_amt") = false;
			sheetObj.ColHidden("diff") = true;

			btn_cmpbviewall.innerText = "OPB View All";
			btn_cmviewall.innerText = "OP View All";
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
 * @version 2012.07.10
 */
function setSheetObject(sheet_obj) {

	var id = sheet_obj.id;
	var numId = Number(id.substr(5));
	if (numId < 17) {
		sheetObjects[sheetCnt++] = sheet_obj;
	} else {
		sheetObjects2[sheetCnt2++] = sheet_obj;
	}
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
 * @version 2012.07.10
 */
function loadPage() {

	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	// 추가한 sheet 초기화
	for ( var i = 0; i < sheetObjects2.length; i++) {
		ComConfigSheet(sheetObjects2[i]);
		initSheet(sheetObjects2[i], i + 1);
		sheetObjects2[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects2[i]);
	}

	initControl();
	toggleButtons("CLEAR");
	parent.loadTabPage();
	document.form.rdoPRSCostLevel[0].click();
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
 * @version 2012.07.10
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1": // CMDT Group(화면표시)
		with (sheetObj) {
			// 높이 설정
			style.height = 142;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_ctnt_tooltip|Not Deleted Rows|Not Accepted Rows|Accepted Rows|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "blet_dp_seq", true, "", dfNullInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 350, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 130, daLeft, false, "note_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_ctnt_tooltip", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ac_cnt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "org_n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "fic_rt_tp_cd", true, "", dfNone, 0, false, false);

			ToolTipOption = "balloon:true;width:1000;icon:1;title:Commodity Note";
			Ellipsis = true;
			ShowButtonImage = 2;
			AutoRowHeight = false;
			CountPosition = 0;
		}
		break;

	case "sheet2": // Route Group(화면표시)
		with (sheetObj) {
			// 높이 설정
			style.height = 142;
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

			var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|Origin Via|Destination Via|Destination|Route Note|Note Tooltip|Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq|fic_rt_use_sts_cd||||||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rn", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 130, daLeft, false, "note_ctnt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_ctnt_tooltip", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_dp_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "org_n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "optm_trsp_mod_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);

			ToolTipOption = "balloon:true;width:1000;icon:1;title:Route Note";
			Ellipsis = true;
			ShowButtonImage = 2;
			AutoRowHeight = false;
			CountPosition = 0;
		}
		break;

	case "sheet3": // Rate(화면표시)
		with (sheetObj) {
			// 높이 설정
			style.height = 142;
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

			var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|GRI|GRI|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", true, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, false, "curr_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "prop_frt_rt_amt", true, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);

			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_respb_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_respb_opfit_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_respb_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			;
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_gid_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "prs_respb_opb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, "diff", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daRight, false, "prs_pfit_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daRight, false, "prs_pfit_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, false, "prs_upd_dt", false, "", dfDateYmd, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "gri_appl_amt", false, "", dfNullFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, false, "next_n1st_cmnc_amdt_seq", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);

			InitDataCombo(0, "rat_ut_cd", ratUtCdText + unusedRatUtCd, ratUtCdValue + unusedRatUtCd, "D2", "D2", 0, "", "", ratUtCdText);
			InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCddValue, "DR");
			InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");

			Ellipsis = true;
			ShowButtonImage = 2;
			CountPosition = 0;
			FrozenCols = 15;
		}
		break;

	case "sheet17": // Rate(화면표시)
		with (sheetObj) {
			// 높이 설정
			style.height = 142;
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

			var HeadTitle1 = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|Proposal|Proposal|Proposal|C/Offer|C/Offer|C/Offer|C/Offer|Final|Final|Final|Final|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|GRI|GRI|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord|||";
			var HeadTitle2 = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Total|BOF|IHC|Diff.|Total|BOF|IHC|Diff.|Total|BOF|IHC|Diff.|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|GRI|GRI|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord|||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", true, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true, "rat_ut_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 75, daCenter, true, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true, "curr_cd", true, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "prop_frt_rt_amt", true, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "prop_bof_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "fic_prop_rt_amt", false, "", dfFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "diff_prop_rt_amt", false, "", dfNone, 2, false, false, 9);

			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "coffr_bof_amt", false, "", dfNone, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fic_coffr_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "diff_coffr_rt_amt", false, "", dfNone, 2, false, false, 9);

			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fnl_bof_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "fic_fnl_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "diff_fnl_rt_amt", false, "", dfNone, 2, false, false, 9);

			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_respb_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_respb_opfit_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_respb_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_gid_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "prs_respb_opb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "diff", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daRight, false, "prs_pfit_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daRight, false, "prs_pfit_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 65, daCenter, false, "prs_upd_dt", false, "", dfDateYmd, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "gri_appl_amt", false, "", dfNullFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "next_n1st_cmnc_amdt_seq", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "src_info_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "src_info_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_gline_rt_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg", false, "", dfNone, 0, false, false);

			InitDataCombo(0, "rat_ut_cd", ratUtCdText + unusedRatUtCd, ratUtCdValue + unusedRatUtCd, "D2", "D2", 0, "", "", ratUtCdText);
			InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCddValue, "DR");
			InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");

			Ellipsis = true;
			ShowButtonImage = 2;
			CountPosition = 0;
			FrozenCols = 12;
			SetMergeCell(0, 1, 2, 1);
			SetMergeCell(0, 34, 2, 2);
		}
		break;

	case "sheet4": // Grid 1의 Commodity(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet5": // Grid 1의 Actual Customer(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "act_cust_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_cnt_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet6": // Grid 1의 Commodity Note(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_note_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prev_note_conv_mapg_id", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet7": // Grid 2의 Origin Point(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25|bse_port_loc_cd|bse_port_def_cd|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt|group_no|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|locl_curr_cd|dr_locl_20ft_amt|rf_locl_20ft_amt|dg_locl_20ft_amt|dr_locl_40ft_amt|rf_locl_40ft_amt|dg_locl_40ft_amt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "bse_port_loc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "bse_port_def_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "base_port_list");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "optm_trsp_mod_flg");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_rt_use_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_gline_upd_dt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "group_no");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);

		}
		break;

	case "sheet8": // Grid 2의 Origin Via.(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet9": // Grid 2의 Destination Via.(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet10": // Grid 2의 Destination Point(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25|bse_port_loc_cd|bse_port_def_cd|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt|group_no|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|locl_curr_cd|dr_locl_20ft_amt|rf_locl_20ft_amt|dg_locl_20ft_amt|dr_locl_40ft_amt|rf_locl_40ft_amt|dg_locl_40ft_amt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);


			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "bse_port_loc_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "bse_port_def_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "base_port_list");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "optm_trsp_mod_flg");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_rt_use_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "fic_gline_upd_dt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "group_no");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_20ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_40ft_amt");
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);
		}
		break;

	case "sheet11": // Grid 2의 Direct Call(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "status";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			Visible = false;
		}
		break;

	case "sheet12": // Grid 2의 Rnote(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_note_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prev_note_conv_mapg_id", false, "", dfNone, 0, false, false);
		}
		break;

	case "sheet13": // Excel Download용 Sheet(Vertical)
		with (sheetObj) {
			// 높이 설정
			style.height = 300;
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

			// var HeadTitle1 = "Seq.|Commodity Group|Commodity Group|Actual Customer|Actual
			// Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Surcharge(USD)|Surcharge(USD)|Surcharge(USD)";
			// var HeadTitle2 = "Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo
			// Type|Rate|BUC|IFC|PSC";
			var HeadTitle1 = "CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate|Rate|Rate|Rate|Rate|Rate";
			var HeadTitle2 = "CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Cur|Rate|BOF|IHC";
			var headCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "curr_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "prop_frt_rt_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "prop_bof_amt", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "fic_prop_rt_amt", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_usd_amt", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_usd_amt", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_usd_amt", true, "", dfNullFloat, 2, false, false);
		}
		break;

	case "sheet14": // Excel Download용 Sheet(Horizontal)
		with (sheetObj) {
			// 높이 설정
			style.height = 300;
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

			// var HeadTitle1 = "Seq.|Commodity Group|Commodity Group|Actual Customer|Actual
			// Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)";
			// var HeadTitle2 = "Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 40'|Dry
			// 40HC|Dry
			// 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF
			// 40HC|RD
			// 40HC";
			var HeadTitle1 = "CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
			var HeadTitle2 = "CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC";
			var headCount = ComCountHeadTitle(HeadTitle2);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry20", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40hc", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry45", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rf40hc", true, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rd40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry20", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry45", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rf40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rd40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry20", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry45", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rf40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rd40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry20", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry45", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rf40hc", true, "", dfNullFloat, 2, false, false);
			// InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rd40hc", true, "", dfNullFloat, 2, false, false);

		}
		break;

	case "sheet15": // Commodity Note Conversion(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 130;

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

			var HeadTitle = "|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass"
					+ "|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type"
					+ "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
			// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "chg_rule_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "rt_appl_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "rt_op_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daRight, true, "frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "pay_term_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_rat_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_prc_cgo_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bkg_imdg_clss_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_ts_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "bkg_vvd_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_soc_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_por_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_pol_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_pod_def_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_del_def_cd", false, "", dfNone, 0, true, true, 5);
            InitDataProperty(0, cnt++ ,dtData,150, daCenter, true, "bkg_esvc_tp_cd", false,	"",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "bkg_yd_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_cmdt_def_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bkg_min_cgo_wgt", false, "", dfFloat, 2, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bkg_max_cgo_wgt", false, "", dfFloat, 2, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "bkg_dir_call_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "bkg_hngr_bar_tp_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_mapg_id");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "svc_scp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "prop_no");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "chg_rule_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_chg_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_rule_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_hdr_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_cmdt_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_por_tp_cd");

			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pol_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pod_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_del_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_ts_port_tp_cd");

			// ///////////////////////////////////////////////////////////////////////////////////////
			// STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_por_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pol_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pod_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_del_cnt_cd");
		}
		break;

	case "sheet16": // Route Note Conversion(Hidden)
		with (sheetObj) {
			// 높이 설정
			style.height = 130;

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

			var HeadTitle = "|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass"
					+ "|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type"
					+ "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
			// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "chg_rule_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "rt_appl_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "rt_op_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daRight, true, "frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "pay_term_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_rat_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_prc_cgo_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bkg_imdg_clss_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_slan_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_ts_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, true, "bkg_vvd_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "bkg_soc_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_por_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_pol_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_pod_def_cd", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bkg_del_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++ ,dtData,150, daCenter, true, "bkg_esvc_tp_cd", false,	"",	dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "bkg_yd_cd", false, "", dfNone, 0, true, true, 7);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_cmdt_def_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bkg_min_cgo_wgt", false, "", dfFloat, 2, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bkg_max_cgo_wgt", false, "", dfFloat, 2, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "bkg_dir_call_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "bkg_hngr_bar_tp_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_mapg_id");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "svc_scp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "prop_no");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "chg_rule_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_chg_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_rule_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_hdr_seq");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "note_conv_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_cmdt_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_por_tp_cd");

			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pol_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pod_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_del_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_ts_port_tp_cd");

			// ///////////////////////////////////////////////////////////////////////////////////////
			// STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_por_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pol_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_pod_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "bkg_del_cnt_cd");
		}
		break;
	case "sheet18": // Excel Download용 Sheet(Horizontal) - Rate of Including IHC인경우
		with (sheetObj) {
			style.height = 300;
			SheetWidth = mainTable.clientWidth;

			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;

			Editable = true;

			InitRowInfo(3, 1, 3, 100);

			var HeadTitle1 = "CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
			var HeadTitle2 = "CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 20'|Dry 20'|Dry 40'|Dry 40'|Dry 40'|Dry 40HC|Dry 40HC|Dry 40HC|Dry 45'|Dry 45'|Dry 45'|RF 40HC|RF 40HC|RF 40HC|RD 40HC|RD 40HC|RD 40HC";
			var HeadTitle3 = "CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC";
			var headCount = ComCountHeadTitle(HeadTitle3);

			InitColumnInfo(headCount, 0, 0, true);

			InitHeadMode(false, true, true, true, false, false)

			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			InitHeadRow(2, HeadTitle3, false);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry20", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry20", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry20", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry40", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry40", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry45", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry45", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry45", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rf40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_rf40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_rf40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rd40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_rd40hc", false, "", dfNullFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_rd40hc", false, "", dfNullFloat, 2, false, false);

			sheetObj.SetMergeCell(1, 1, 2, 1);
			sheetObj.SetMergeCell(1, 2, 2, 1);
			sheetObj.SetMergeCell(1, 3, 2, 1);
			sheetObj.SetMergeCell(1, 4, 2, 1);
			sheetObj.SetMergeCell(1, 6, 2, 1);
			sheetObj.SetMergeCell(1, 7, 2, 1);
			sheetObj.SetMergeCell(1, 8, 2, 1);
			sheetObj.SetMergeCell(1, 9, 2, 1);
			sheetObj.SetMergeCell(1, 10, 2, 1);
			sheetObj.SetMergeCell(1, 11, 2, 1);
			sheetObj.SetMergeCell(1, 12, 2, 1);
			sheetObj.SetMergeCell(1, 13, 2, 1);
			sheetObj.SetMergeCell(1, 14, 2, 1);
			sheetObj.SetMergeCell(1, 15, 2, 1);
			sheetObj.SetMergeCell(1, 16, 1, 3);
			sheetObj.SetMergeCell(1, 19, 1, 3);
			sheetObj.SetMergeCell(1, 22, 1, 3);
			sheetObj.SetMergeCell(1, 25, 1, 3);
			sheetObj.SetMergeCell(1, 28, 1, 3);
			sheetObj.SetMergeCell(1, 31, 1, 3);

		}
		break;

	}
}

/**
 * OnBeforeEdit 이벤트 발생시 호출되는 function <br>
 * Route Group에 수정사항이 있을 경우, CMDT Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	if (!checkCmdtEditable()) {
		ComShowCodeMessage("PRI00309", "Route Detail");
		return false;
	}
}

/**
 * OnAfterEdit 이벤트 발생시 호출되는 function <br>
 * Route Group에 수정사항이 있을 경우, CMDT Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	if (!checkCmdtEditable()) {
		sheetObj.ReturnCellData(Row, Col);
		return false;
	}
}

/**
 * OnBeforeEdit 이벤트 발생시 호출되는 function <br>
 * CMDT Group에 수정사항이 있을 경우, Route Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
	if (!checkRouteEditable()) {
		ComShowCodeMessage("PRI00309", "Commodity Group");
		return false;
	}
}

/**
 * OnAfterEdit 이벤트 발생시 호출되는 function <br>
 * CMDT Group에 수정사항이 있을 경우, Route Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet2_OnAfterEdit(sheetObj, Row, Col) {
	if (!checkRouteEditable()) {
		sheetObj.ReturnCellData(Row, Col);
		return false;
	}
}

/**
 * OnBeforeEdit 이벤트 발생시 호출되는 function <br>
 * CMDT Group에 수정사항이 있을 경우, Route Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet3_OnBeforeEdit(sheetObj, Row, Col) {
	if (!checkRouteEditable()) {
		ComShowCodeMessage("PRI00309", "Commodity Group");
		return false;
	}
}

/**
 * OnAfterEdit 이벤트 발생시 호출되는 function <br>
 * CMDT Group에 수정사항이 있을 경우, Route Group을 수정할수 없도록 막는다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet3_OnAfterEdit(sheetObj, Row, Col) {
	if (!checkRouteEditable()) {
		sheetObj.ReturnCellData(Row, Col);
		return false;
	}
}

/**
 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
 * Check할 경우, 하위 Grid들도 모두 체크되고, Uncheck할 경우, 상위 Grid의 Check도 풀리도록 한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);

	if (colName == "chk") {
		ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
	}
}

/**
 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
 * Check할 경우, 하위 Grid들도 모두 체크되고, Uncheck할 경우, 상위 Grid의 Check도 풀리도록 한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);

	if (colName == "chk") {
		ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
	}
}

/**
 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
 * Check할 경우, 하위 Grid들도 모두 체크되고, Uncheck할 경우, 상위 Grid의 Check도 풀리도록 한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet3_OnBeforeCheck(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);

	if (colName == "chk") {
		ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
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
 * @version 2012.07.10
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);

	// Cargo type 변경시 Rating Unit이 적당한지 체크
	if (colName == "prc_cgo_tp_cd") {
		if (Value == "AK") {
			var validPerClass = "D,A,F,O,Q,S,P";
			var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
			if (validPerClass.indexOf(perClass) < 0) {
				ComShowCodeMessage("PRI08003");
				sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
			}
		}
	}

	// Rating Unit 변경시 이에 맞게 Cargo type을 default setting한다.
	if (colName == "rat_ut_cd") {
		var validPerClass = "A,F,O,Q,S,P";
		var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
		if (perClass == "") {
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
	}

	// Proposal amount 변경시 PRS관련 값들을 재 계산해준다.
	if (colName == "prop_frt_rt_amt") {
		var scgAmt = sheetObjects[2].CellValue(Row, "prs_scg_amt");
		var respbCmUcAmt = sheetObjects[2].CellValue(Row, "prs_respb_cm_uc_amt");
		var respbOpfitUcAmt = sheetObjects[2].CellValue(Row, "prs_respb_opfit_uc_amt");
		var pfitCmUcAmt = sheetObjects[2].CellValue(Row, "prs_pfit_cm_uc_amt");

		if (Value != null && Value != "" && scgAmt != null && scgAmt != "") {
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbCmUcAmt);
			} else {
				sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = "";
			}
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbOpfitUcAmt);
			} else {
				sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = "";
			}
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(pfitCmUcAmt);
			} else {
				sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = "";
			}
		} else {
			sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") = "";
			sheetObjects[2].CellValue(Row, "prs_respb_opb_amt") = "";
			sheetObjects[2].CellValue(Row, "prs_pfit_cmpb_amt") = "";
		}

		if (sheetObjects[2].CellValue(Row, "prs_gid_cmpb_amt") != "" && sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt") != "") {
			sheetObjects[2].CellValue(Row, "diff") = parseFloat(sheetObjects[2].CellValue(Row, "prs_respb_cmpb_amt")) - parseFloat(sheetObjects[2].CellValue(Row, "prs_gid_cmpb_amt"));
		} else {
			sheetObjects[2].CellValue(Row, "diff") = "";
		}
	}
}

/**
 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
 * @version 2012.07.10
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
	doRowChange1(OldRow, NewRow, OldCol, NewCol);
}

/**
 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
 * @version 2012.07.10
 */
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
	doRowChange2(OldRow, NewRow, OldCol, NewCol);
}

/**
 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
 * @version 2012.07.10
 */
function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Sheet1에서 Accept된 데이터건수와 Accept되지 않은 데이터 건수를 가져와 합산한다. S/C의 경우 General/Special Type정보 가져올때 건수를 조회하지만, RFA는 Type이 따로 없으므로 이와 같은 방법을 사용한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (sheetObj.RowCount > 0) {
			notAcptCnt = sheetObj.ComputeSum("|13|");
			acptCnt = sheetObj.ComputeSum("|14|");
		}

		toggleButtons("INIT");
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Origin Point
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		origin_desc.innerHTML = "";
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			var sStr = "";
			if (sheetObj.RowStatus(i) == "D") {
				continue;
			}
			if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
				continue;
			}

			sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");

			if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
				sStr += "(" + arrTermOrg[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
			}
			if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
				sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
			}
			if ((sheetObj.CellValue(i, "loc_grd_cnt_cd") != null && sheetObj.CellValue(i, "loc_grd_cnt_cd") != "")
					|| (sheetObj.CellValue(i, "loc_grd_cd") != null && sheetObj.CellValue(i, "loc_grd_cd") != "")) {
				sStr += "(" + sheetObj.CellValue(i, "loc_grd_cnt_cd") + sheetObj.CellValue(i, "loc_grd_cd") + ")";
			}

			if (document.form.amdt_seq.value != "0") {
				if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr = "<s>" + sStr + "</s>";
				}
				if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr += "(Deleted)";
				}
				if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
					sStr = "<font color='red'>" + sStr + "</font>";
				}
			}

			sStr += "<br>";
			origin_desc.innerHTML += sStr;
		}
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Origin Via.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		ovia_desc.innerHTML = "";
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			var sStr = "";
			if (sheetObj.RowStatus(i) == "D") {
				continue;
			}
			if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
				continue;
			}

			sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");

			if (document.form.amdt_seq.value != "0") {
				if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr = "<s>" + sStr + "</s>";
				}
				if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr += "(Deleted)";
				}
				if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
					sStr = "<font color='red'>" + sStr + "</font>";
				}
			}

			sStr += "<br>";
			ovia_desc.innerHTML += sStr;
		}
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Dest. Via.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		dvia_desc.innerHTML = "";
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			var sStr = "";
			if (sheetObj.RowStatus(i) == "D") {
				continue;
			}
			if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
				continue;
			}

			sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");

			if (document.form.amdt_seq.value != "0") {
				if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr = "<s>" + sStr + "</s>";
				}
				if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr += "(Deleted)";
				}
				if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
					sStr = "<font color='red'>" + sStr + "</font>";
				}
			}

			sStr += "<br>";
			dvia_desc.innerHTML += sStr;
		}
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Dest. Point
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		dest_desc.innerHTML = "";
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			var sStr = "";
			if (sheetObj.RowStatus(i) == "D") {
				continue;
			}
			if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
				continue;
			}

			sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");

			if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
				sStr += "(" + arrTermDest[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
			}
			if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
				sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
			}
			if ((sheetObj.CellValue(i, "loc_grd_cnt_cd") != null && sheetObj.CellValue(i, "loc_grd_cnt_cd") != "")
					|| (sheetObj.CellValue(i, "loc_grd_cd") != null && sheetObj.CellValue(i, "loc_grd_cd") != "")) {
				sStr += "(" + sheetObj.CellValue(i, "loc_grd_cnt_cd") + sheetObj.CellValue(i, "loc_grd_cd") + ")";
			}

			if (document.form.amdt_seq.value != "0") {
				if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr = "<s>" + sStr + "</s>";
				}
				if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
					sStr += "(Deleted)";
				}
				if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
					sStr = "<font color='red'>" + sStr + "</font>";
				}
			}

			sStr += "<br>";
			dest_desc.innerHTML += sStr;
		}
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Sheet13(Excel Download용) 그리드에 데이터가 로드된 경우, 이를 엑셀파일형식으로 다운로드 한다. 속도문제로 300건이 넘을경우 Speed옵션을 사용한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet13_OnSearchEnd(sheetObj, ErrMsg) {
	if (funcCheckFicRtTpCdVal() == 'A') {
		sheetObj.ColHidden('prop_bof_amt') = false;
		sheetObj.ColHidden('fic_prop_rt_amt') = false;
	} else {
		sheetObj.ColHidden('prop_bof_amt') = true;
		sheetObj.ColHidden('fic_prop_rt_amt') = true;
	}
	if (ErrMsg == "") {
		if (sheetObj.RowCount > 300) {
			sheetObj.SpeedDown2Excel(-1);
		} else {
			sheetObj.Down2Excel(-1);
		}
		sheetObj.RemoveAll();
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Sheet14(Excel Download용) 그리드에 데이터가 로드된 경우, 이를 엑셀파일형식으로 다운로드 한다. 속도문제로 200건이 넘을경우 Speed옵션을 사용한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet14_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (sheetObj.RowCount > 200) {
			sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, '', '', false, '', true);
		} else {
			sheetObj.Down2Excel(-1);
		}
		sheetObj.RemoveAll();
	}
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Sheet18(Excel Download용) 그리드에 데이터가 로드된 경우, 이를 엑셀파일형식으로 다운로드 한다. 속도문제로 200건이 넘을경우 Speed옵션을 사용한다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.06.22
 */
function sheet18_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (sheetObj.RowCount > 200) {
			sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, '', '', false, '', true);
		} else {
			sheetObj.Down2Excel(-1);
		}
		sheetObj.RemoveAll();
	}
}

/**
 * OnPopupClick 이벤트 발생시 호출되는 function <br>
 * Sheet1 Popup버튼 클릭시 팝업화면 호출. 팝업화면에서 수정된 결과는 해당 sheet의 내용을 조합하여 Sheet1에 다시 Update해준다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	// Route쪽에 수정사항이 있으면 이벤트를 무시하고 리턴한다.
	if (!checkCmdtEditable()) {
		return false;
	}

	if (colName == "prc_cmdt_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_2023.do?" + FormQueryString(document.form);
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2023", 794, 265, true);
		if (rtnVal == "O") {
			setSheet1RowData(sheetObj, 3, Row, "prc_cmdt_def_nm");
		}
	}

	if (colName == "cust_lgl_eng_nm") {
		var sCustType = parent.getCustTpCd();
		if (sCustType != "N") {
			return false;
		}

		var sUrl = "/hanjin/ESM_PRI_2082.do?" + FormQueryString(document.form);
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2082", 700, 249, true);
		if (rtnVal == "O") {
			setSheet1RowData(sheetObj, 4, Row, "cust_lgl_eng_nm");
		}
	}

	if (colName == "note_ctnt") {
		var sUrl = "/hanjin/ESM_PRI_2022.do?" + FormQueryString(document.form) + "&select_row=" + sheetObjects[0].SelectRow;
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2022", 900, 650, true);

		if (rtnVal == "O") {
			for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				var sNoteCtnt = "";

				for ( var j = sheetObjects[5].HeaderRows; j <= sheetObjects[5].LastRow; j++) {
					if (sheetObjects[5].CellValue(j, "amdt_seq") != formObj.amdt_seq.value) {
						continue;
					}
					if (sheetObjects[5].RowStatus(j) == "D") {
						continue;
					}
					/*
					 * AD인 항목도 표시해도 관계없음. if (sheetObjects[5].CellValue(j, "src_info_cd") == "AD") { continue; }
					 */

					if (sheetObjects[5].CellValue(j, "cmdt_hdr_seq") == sheetObj.CellValue(i, "cmdt_hdr_seq")) {
						sNoteCtnt += sheetObjects[5].CellValue(j, "note_ctnt");
					}
				}

				var prevStatus = sheetObj.RowStatus(i);
				sheetObj.CellValue2(i, "note_ctnt") = sNoteCtnt;
				sheetObj.CellValue2(i, "note_ctnt_tooltip") = sNoteCtnt;
				// Note의 변경된 내용을 Tooltip에도 적용한다.
				setNoteTooltip(sheetObj, i);
				sheetObj.RowStatus(i) = prevStatus;
			}
		}
	}
}

/**
 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
 * @version 2012.07.10
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	// Route가 모두 로드되지 않았으면, 이벤트를 무시한다.
	if (!LoadingComplete) {
		return;
	}

	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	// CMDT 쪽에 수정된 내용이 있다면 return.
	if (!checkRouteEditable()) {
		return false;
	}
	var sUrl = "/hanjin/ESM_PRI_2028.do?" + FormQueryString(document.form);

	if (colName == "org_rout_pnt_loc_def_cd") {
		sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2028", 980, 324, true);

		if (rtnVal == "O") {
			setSheet2RowData(sheetObj, Row, Col);
		}
	}
	if (colName == "org_rout_via_port_def_cd") {
		sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2028", 980, 324, true);

		if (rtnVal == "O") {
			setSheet2RowData(sheetObj, Row, Col);
		}
	}
	if (colName == "dest_rout_via_port_def_cd") {
		sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2028", 980, 324, true);

		if (rtnVal == "O") {
			setSheet2RowData(sheetObj, Row, Col);
		}
	}
	if (colName == "dest_rout_pnt_loc_def_cd") {
		sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2028", 980, 324, true);

		if (rtnVal == "O") {
			setSheet2RowData(sheetObj, Row, Col);
		}
	}

	if (colName == "note_ctnt") {
		sUrl = "/hanjin/ESM_PRI_2024.do?" + FormQueryString(document.form);
		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_2024", 900, 540, true);

		if (rtnVal == "O") {
			var prevStatus = sheetObj.RowStatus(Row);
			var sNoteCtnt = "";

			for ( var i = sheetObjects[11].HeaderRows; i <= sheetObjects[11].LastRow; i++) {
				if (sheetObjects[11].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
					continue;
				}
				if (sheetObjects[11].RowStatus(i) == "D") {
					continue;
				}
				/*
				 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[11].CellValue(i, "src_info_cd") == "AD") { continue; }
				 */

				sNoteCtnt += sheetObjects[11].CellValue(i, "note_ctnt");

			}

			sheetObj.CellValue2(Row, "note_ctnt") = sNoteCtnt;
			sheetObj.CellValue2(Row, "note_ctnt_tooltip") = sNoteCtnt;
			setNoteTooltip(sheetObj, Row);
			sheetObj.RowStatus(Row) = prevStatus;
		}
	}
}

/**
 * 팝업화면에서 변경된 내용을 Sheet1에 반영한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetIdx 필수 Sheet번호
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function setSheet1RowData(sheetObj, sheetIdx, Row, Col) {
	var formObj = document.form;
	var prevStatus = sheetObj.RowStatus(Row);
	var sNm = "";

	for ( var i = sheetObjects[sheetIdx].HeaderRows; i <= sheetObjects[sheetIdx].LastRow; i++) {
		if (sheetObjects[sheetIdx].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
			continue;
		}
		if (sheetObjects[sheetIdx].CellValue(i, "prop_no") == formObj.prop_no.value && sheetObjects[sheetIdx].CellValue(i, "amdt_seq") == formObj.amdt_seq.value
				&& sheetObjects[sheetIdx].CellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value && sheetObjects[sheetIdx].CellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
			if (sheetObjects[sheetIdx].RowStatus(i) == "D") {
				continue;
			}
			/*
			 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[sheetIdx].CellValue(i, "src_info_cd") == "AD") { continue; }
			 */
			sNm += sheetObjects[sheetIdx].CellValue(i, Col);
			sNm += " / ";
		}
	}
	if (sNm != "") {
		var lastIdx = sNm.lastIndexOf("/");
		sNm = sNm.substring(0, lastIdx - 1);
	}

	sheetObj.CellValue2(Row, Col) = sNm;
	sheetObj.RowStatus(Row) = prevStatus;
}

/**
 * 팝업화면에서 변경된 내용을 Sheet2에 반영한다.<br>
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
 * @version 2012.07.10
 */
function setSheet2RowData(sheetObj, Row, Col) {
	if (sheetObj.SelectRow != Row) {
		sheetObj.SelectCell(Row, 0);
	}
	var formObj = document.form;
	var prevStatus = sheetObj.RowStatus(Row);
	var sCd = "";
	for ( var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
		if (sheetObjects[6].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
			continue;
		}
		if (sheetObjects[6].RowStatus(i) == "D") {
			continue;
		}
		/*
		 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[6].CellValue(i, "src_info_cd") == "AD") { continue; }
		 */
		sCd += sheetObjects[6].CellValue(i, "rout_pnt_loc_def_cd");
		sCd += ", ";
	}
	if (sCd != "") {
		var lastIdx = sCd.lastIndexOf(",");
		sCd = sCd.substring(0, lastIdx);
	}
	sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sCd;

	sCd = "";
	for ( var i = sheetObjects[7].HeaderRows; i <= sheetObjects[7].LastRow; i++) {
		if (sheetObjects[7].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
			continue;
		}
		if (sheetObjects[7].RowStatus(i) == "D") {
			continue;
		}
		/*
		 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[7].CellValue(i, "src_info_cd") == "AD") { continue; }
		 */
		sCd += sheetObjects[7].CellValue(i, "rout_via_port_def_cd");
		sCd += ", ";
	}
	if (sCd != "") {
		var lastIdx = sCd.lastIndexOf(",");
		sCd = sCd.substring(0, lastIdx);
	}
	sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sCd;

	sCd = "";
	for ( var i = sheetObjects[8].HeaderRows; i <= sheetObjects[8].LastRow; i++) {
		if (sheetObjects[8].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
			continue;
		}
		if (sheetObjects[8].RowStatus(i) == "D") {
			continue;
		}
		/*
		 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[8].CellValue(i, "src_info_cd") == "AD") { continue; }
		 */
		sCd += sheetObjects[8].CellValue(i, "rout_via_port_def_cd");
		sCd += ", ";
	}
	if (sCd != "") {
		var lastIdx = sCd.lastIndexOf(",");
		sCd = sCd.substring(0, lastIdx);
	}
	sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sCd;

	sCd = "";
	for ( var i = sheetObjects[9].HeaderRows; i <= sheetObjects[9].LastRow; i++) {
		if (sheetObjects[9].CellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
			continue;
		}
		if (sheetObjects[9].RowStatus(i) == "D") {
			continue;
		}
		/*
		 * AD된것도 보여줘도 관계없다고 합니다. 2009-06-04 18:16 이수희 과장님 if (sheetObjects[9].CellValue(i, "src_info_cd") == "AD") { continue; }
		 */
		sCd += sheetObjects[9].CellValue(i, "rout_pnt_loc_def_cd");
		sCd += ", ";
	}
	if (sCd != "") {
		var lastIdx = sCd.lastIndexOf(",");
		sCd = sCd.substring(0, lastIdx);
	}
	sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sCd;
	// route의 ihc값을 update한다.
	if (updateRouteMinValue(sheetObj, Row)) {
		updateRateIhcValue(sheetObj, Row);
	}
	sheetObj.RowStatus(Row) = prevStatus;
}

/**
 * rate의 ihc값을 update한다. <br>
 * <b>Example : updateRateIhcValue(sheetObj,20)</b>
 * 
 * <pre>
 * </pre>
 * 
 * @author 이은섭
 * @version 2012.06.08
 */
function updateRateIhcValue(routeSheet, Row) {
	var formObj = document.form;

	var sheet17 = sheetObjects2[0];
	var prc_prop_sts_cd = document.form.prc_prop_sts_cd.value;
	var ficRtUseStsCd = routeSheet.CellValue(Row, 'fic_rt_use_sts_cd');
	var ficGlineRtAmt = '';
	if (prc_prop_sts_cd == 'I') {
		sheet17.Redraw = false;
		for ( var i = sheet17.HeaderRows; i < sheet17.HeaderRows + sheet17.RowCount; i++) {
			if (funcChkTypeStatus() != "X" && (ficRtUseStsCd == '1' || ficRtUseStsCd == '2' || ficRtUseStsCd == '3')) {
				continue;
			}

			if (sheet17.RowStatus(i) == "D" || sheet17.CellValue(i, 'n1st_cmnc_amdt_seq') != formObj.amdt_seq.value || sheet17.CellValue(i, "src_info_cd") == "AD") {
				continue;
			}

			if (sheet17.CellValue(i, 'curr_cd') != 'USD') {
				sheet17.CellValue2(i, 'curr_cd') = 'USD';
			}

			var prcCgoTpCd = sheet17.CellValue(i, "prc_cgo_tp_cd");
			var currCd = sheet17.CellValue(i, "curr_cd");
			var ratUtCd = sheet17.CellValue(i, 'rat_ut_cd');

			if (ratUtCd == "D2" || ratUtCd == "R2") {
				ficGlineInfo = funcFicGlineRtAmt(routeSheet, 20, prcCgoTpCd, currCd);
			} else if (ratUtCd == "D4" || ratUtCd == "D5" || ratUtCd == "R4" || ratUtCd == "R5") {
				ficGlineInfo = funcFicGlineRtAmt(routeSheet, 40, prcCgoTpCd, currCd);
			} else {
				ficGlineInfo[0] = "N/A";
				ficGlineInfo[1] = "";
				ficGlineInfo[2] = "";
			}
			if (ficGlineInfo[0] == '' || ficGlineInfo[0] == 'N/A') {
				sheet17.CellValue2(i, 'fic_gline_rt_amt') = 'N/A';
				sheet17.CellValue(i, 'fic_prop_rt_amt') = 0;
				sheet17.CellValue2(i, 'diff_prop_rt_amt') = 'N/A';
			} else {
				sheet17.CellValue2(i, 'fic_gline_rt_amt') = ficGlineInfo[0];
				sheet17.CellValue2(i, 'fic_prop_rt_amt') = 0;
				sheet17.CellValue(i, 'fic_prop_rt_amt') = ficGlineInfo[0];
			}
			sheet17.CellValue2(i, 'fic_rt_use_sts_cd') = ficGlineInfo[1];
			sheet17.CellValue2(i, 'optm_trsp_mod_flg') = ficGlineInfo[2];
		}
		sheet17.Redraw = true;
	}
}

/**
 * route group에 ihc값을 update함. <br>
 * <b>Example : selectMinValue(sheetObj,20)</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return boolean true : ihc가 변경 되었음. false : ihc가 변경되지 않았음.
 * @author 송민석
 * @version 2012.06.08
 */
function updateRouteMinValue(routeSheet, Row) {

	var bReturn = false;
	var pointSheet = null;

	// 최소값 선정 및 선정된 값이 기존 최소값과 다르다면 ROUTE에 UPDATE하고 RATE의 IHC값을 변경시킴
	// 'A' 이면서 'AEW 일때.
	var checkScope = funcChkTypeStatus();
	if (checkScope == "D") {
		pointSheet = sheetObjects[9];
	} else if (checkScope == "O") {// 'A' 이면서 AEE 일때.
		pointSheet = sheetObjects[6];
	} else {
		return bReturn;
	}

	var min20FtRow = selectMinValue(pointSheet, 20);
	var min40FtRow = selectMinValue(pointSheet, 40);

	var route_fic_rt_use_sts_cd = routeSheet.CellValue(Row, "fic_rt_use_sts_cd");
	var route_optm_trsp_mod_flg = routeSheet.CellValue(Row, "optm_trsp_mod_flg");
	var route_dr_20ft_amt = routeSheet.CellValue(Row, "dr_20ft_amt");
	var route_rf_20ft_amt = routeSheet.CellValue(Row, "rf_20ft_amt");
	var route_dg_20ft_amt = routeSheet.CellValue(Row, "dg_20ft_amt");
	var route_dr_40ft_amt = routeSheet.CellValue(Row, "dr_40ft_amt");
	var route_rf_40ft_amt = routeSheet.CellValue(Row, "rf_40ft_amt");
	var route_dg_40ft_amt = routeSheet.CellValue(Row, "dg_40ft_amt");

	var point_fic_rt_use_sts_cd = pointSheet.CellValue(min20FtRow, "fic_rt_use_sts_cd");
	var point_optm_trsp_mod_flg = pointSheet.CellValue(min20FtRow, "optm_trsp_mod_flg");
	var point_dr_20ft_amt = pointSheet.CellValue(min20FtRow, "dr_20ft_amt");
	var point_rf_20ft_amt = pointSheet.CellValue(min20FtRow, "rf_20ft_amt");
	var point_dg_20ft_amt = pointSheet.CellValue(min20FtRow, "dg_20ft_amt");
	var point_dr_40ft_amt = pointSheet.CellValue(min40FtRow, "dr_40ft_amt");
	var point_rf_40ft_amt = pointSheet.CellValue(min40FtRow, "rf_40ft_amt");
	var point_dg_40ft_amt = pointSheet.CellValue(min40FtRow, "dg_40ft_amt");

	var point_locl_curr_cd = pointSheet.CellValue(min20FtRow, "locl_curr_cd");
	var point_dr_locl_20ft_amt = pointSheet.CellValue(min20FtRow, "dr_locl_20ft_amt");
	var point_rf_locl_20ft_amt = pointSheet.CellValue(min20FtRow, "rf_locl_20ft_amt");
	var point_dg_locl_20ft_amt = pointSheet.CellValue(min20FtRow, "dg_locl_20ft_amt");
	var point_dr_locl_40ft_amt = pointSheet.CellValue(min40FtRow, "dr_locl_40ft_amt");
	var point_rf_locl_40ft_amt = pointSheet.CellValue(min40FtRow, "rf_locl_40ft_amt");
	var point_dg_locl_40ft_amt = pointSheet.CellValue(min40FtRow, "dg_locl_40ft_amt");

	if (route_dr_20ft_amt != point_dr_20ft_amt || route_rf_20ft_amt != point_rf_20ft_amt || route_dg_20ft_amt != point_dg_20ft_amt || route_dr_40ft_amt != point_dr_40ft_amt
			|| route_rf_40ft_amt != point_rf_40ft_amt || route_dg_40ft_amt != point_dg_40ft_amt) {
		routeSheet.CellValue2(Row, "fic_rt_use_sts_cd") = point_fic_rt_use_sts_cd;
		routeSheet.CellValue2(Row, "optm_trsp_mod_flg") = point_optm_trsp_mod_flg;
		routeSheet.CellValue2(Row, "dr_20ft_amt") = point_dr_20ft_amt;
		routeSheet.CellValue2(Row, "rf_20ft_amt") = point_rf_20ft_amt;
		routeSheet.CellValue2(Row, "dg_20ft_amt") = point_dg_20ft_amt;
		routeSheet.CellValue2(Row, "dr_40ft_amt") = point_dr_40ft_amt;
		routeSheet.CellValue2(Row, "rf_40ft_amt") = point_rf_40ft_amt;
		routeSheet.CellValue2(Row, "dg_40ft_amt") = point_dg_40ft_amt;

		routeSheet.CellValue2(Row, "locl_curr_cd") = point_locl_curr_cd;
		routeSheet.CellValue2(Row, "dr_locl_20ft_amt") = point_dr_locl_20ft_amt;
		routeSheet.CellValue2(Row, "rf_locl_20ft_amt") = point_rf_locl_20ft_amt;
		routeSheet.CellValue2(Row, "dg_locl_20ft_amt") = point_dg_locl_20ft_amt;
		routeSheet.CellValue2(Row, "dr_locl_40ft_amt") = point_dr_locl_40ft_amt;
		routeSheet.CellValue2(Row, "rf_locl_40ft_amt") = point_rf_locl_40ft_amt;
		routeSheet.CellValue2(Row, "dg_locl_40ft_amt") = point_dg_locl_40ft_amt;

		bReturn = true;
	}
	return bReturn;
}

/**
 * 최소값을 선정해서 그 row 값을 return함. <br>
 * <b>Example : selectMinValue(sheetObj,20)</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return rowNum
 * @author 송민석
 * @version 2012.06.08
 */
function selectMinValue(sheetObj, cntrTpSize) {

	var rowNum = -1;

	var sRow = 0;
	var eRow = 0;
	var check = true;
	if (sheetObj.IsDataModified) {
		sRow = sheetObj.HeaderRows;
		eRow = sRow + sheetObj.RowCount;
		var colName = "dr_20ft_amt";
		var preValue = 0;
		var currValue = 0;
		var checkCnt = 0;
		var amdtSeq = document.form.amdt_seq.value;

		if (cntrTpSize == 40) {
			colName = "dr_40ft_amt"
		}
		for ( var iIdx = sRow; iIdx < eRow; iIdx++) {
			if (sheetObj.RowStatus(iIdx) == "D" || sheetObj.CellValue(iIdx, "amdt_seq") != amdtSeq || sheetObj.CellValue(iIdx, "src_info_cd") == "AD") {
				continue;
			}
			currValue = parseFloat(sheetObj.CellValue(iIdx, colName));
			if (checkCnt == 0) {
				rowNum = iIdx;
				preValue = currValue;
				
			} else {
				if (currValue < preValue) {
					rowNum = iIdx;
					preValue = currValue;
					
				}
			}
			checkCnt++;
		}
	}

	return rowNum;
}

// Row이동시 Validation결과 등에 따라 이동을 실행하고 취소하는 등의 처리를 위해 잠시 이벤트를 off하기 위해 사용하는 변수.
// 사용하지않고 행이동 등을 처리할시 이벤트가 중첩하여 발생하여 꼬이는 현상이 나타난다.
var isFiredNested = false;
// GRI Calc등 전체화면 재조회시 이전에 선택되어진 행을 찾아가기 위해 잠시 이벤트를 off하기 위해 사용하는 변수.
// 이를 사용하지 않고도 처리가능하나, 같은 그리드가 2번 조회되는 등의 문제가 발생한다.
var isFiredNestedExt = false;
// Row이동시 변경된 내용을 저장할때, Confirm메시지를 표시하지 않기 위한 지시자.
var supressConfirm = false;
/**
 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
 * CMDT Group 그리드에서 Row이동 이벤트가 발생한 경우, 일단 선택된 행을 원래대로(OldRow) 돌려놓고, Validation등을 수행한 후, 이동가능할 경우에만 해당 행(NewRow)으로 수동으로 이동시켜준다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이은섭
 * @version 2012.07.10
 */
function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
	var formObj = document.form;

	// 중첩으로 발생한 이벤트이거나, 같은 행을 선택한 경우에는 처리하지 않는다.
	if (!isFiredNested && (OldRow != NewRow)) {
		// CMDT Group 관련 그리드에 수정사항이 있을경우, 그에 대한 validation을 수행하는 블럭.
		if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified || sheetObjects[4].IsDataModified || sheetObjects[5].IsDataModified) {
			// 일단 이벤트를 끄고, Selected Row를 OldRow로 돌려놓고 시작한다.
			isFiredNested = true;
			sheetObjects[0].SelectCell(OldRow, OldCol, false);
			isFiredNested = false;

			if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
				// 저장 Validation에 이상이 없고, RowAdd나 RowCopy 액션이 아니면 해당 행(NewRow)으로 이동한다.
				if (sAction != IBINSERT && sAction != IBCOPYROW) {
					isFiredNested = true;
					sheetObjects[0].SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				}
			} else {
				// Validation Error가 발생한 경우, OldRow에서 이동하지 않는다.
				isFiredNested = true;
				sheetObjects[0].SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			}
		}

		// Route Group의 OldRow에 수정된 사항이 있을 경우, 이를 처리하는 블럭.
		if (sheetObjects[1].IsDataModified
		// || sheetObjects[2].IsDataModified
		|| getRateSheet().IsDataModified || sheetObjects[6].IsDataModified || sheetObjects[7].IsDataModified || sheetObjects[8].IsDataModified || sheetObjects[9].IsDataModified
				|| sheetObjects[10].IsDataModified || sheetObjects[11].IsDataModified || sheetObjects[15].IsDataModified) {
			// 이벤트를 끄고, Selected Row를 OldRow로 돌려놓고 시작한다.
			isFiredNested = true;
			sheetObjects[0].SelectCell(OldRow, OldCol, false);
			isFiredNested = false;

			var rslt = false;
			if (ComShowCodeConfirm("PRI00006")) {
				// 저장 수행. 저장할지를 물어보는 Confirm는 표시하지 않는다.
				supressConfirm = true;
				// var rslt = doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
				var rslt = doActionIBSheet(getRateSheet(), document.form, IBSAVE);
				supressConfirm = false;
			}
			if (rslt) {
				// 저장결과가 성공이면 NewRow로 이동한다. 단 RowAdd나 RowCopy일 경우에는 이동하지 않는다.
				if (sAction != IBINSERT && sAction != IBCOPYROW) {
					isFiredNested = true;
					sheetObjects[0].SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				}
			} else {
				// 저장결과가 실패이면 다시 OldRow로 돌아간다.
				isFiredNested = true;
				sheetObjects[0].SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			}
		}

		// RowAdd 액션일 경우
		if (sAction == IBINSERT) {
			isFiredNested = true;
			var idx = sheetObjects[0].DataInsert();
			isFiredNested = false;
			return idx;
			// RowCopy 액션일 경우
		} else if (sAction == IBCOPYROW) {
			isFiredNested = true;
			var idx = sheetObjects[0].DataCopy();
			isFiredNested = false;
			return idx;
			// 일반 Row이동일 경우 이동된 NewRow에 대한 하위그리드 조회를 실행한다.
		} else {
			formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(NewRow, "cmdt_hdr_seq");
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		}
	}
}

/**
 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
 * Route Group 그리드에 대한 이벤트를 처리한다. doRowChange1 함수 참조.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이은섭
 * @version 2012.07.10
 */
function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
	var formObj = document.form;
	var adjNewRow = NewRow;

	if (!isFiredNested && !isFiredNestedExt && (OldRow != NewRow)) {
		if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
				&& (sheetObjects[1].IsDataModified || getRateSheet().IsDataModified || sheetObjects[6].IsDataModified || sheetObjects[7].IsDataModified || sheetObjects[8].IsDataModified
						|| sheetObjects[9].IsDataModified || sheetObjects[10].IsDataModified || sheetObjects[11].IsDataModified || sheetObjects[15].IsDataModified)) {
			isFiredNested = true;
			sheetObjects[1].SelectCell(OldRow, OldCol, false);
			isFiredNested = false;

			var rslt = false;
			if (ComShowCodeConfirm("PRI00006")) {
				supressConfirm = true;
				adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows);
				rslt = doActionIBSheet(getRateSheet(), document.form, IBSAVE);
				supressConfirm = false;
			}
			if (rslt) {
				if (sAction != IBINSERT && sAction != IBCOPYROW) {
					isFiredNested = true;
					sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				}
			} else {
				isFiredNested = true;
				sheetObjects[1].SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				return -1;
			}
		}

		if (sAction == IBINSERT) {
			if (sheetObjects[1].CellValue(sheetObjects[1].HeaderRows, 'rout_seq') == '') {
				sheetObjects[1].RemoveAll();
			}
			isFiredNested = true;
			var idx = sheetObjects[1].DataInsert();
			isFiredNested = false;
			return idx;
		} else if (sAction == IBCOPYROW) {
			isFiredNested = true;
			var idx = sheetObjects[1].DataCopy();
			isFiredNested = false;
			return idx;
		} else {
			LoadingComplete = false;
			formObj.rout_seq.value = sheetObjects[1].CellValue(adjNewRow, "rout_seq");
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
			LoadingComplete = true;
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
 * @version 2012.07.10
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}

		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH_ASYNC02: // Cancel All
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (!ComShowCodeConfirm("PRI01010")) {
				return false;
			}

			formObj.f_cmd.value = MODIFY11;
			var sParam = FormQueryString(formObj);

			// 재조회를 위해 Sheet1,2,3의 현재 선택된 Row를 기억한다.
			saveCurRowPos();

			var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);

			// 재조회
			reloadPagePostTr();

			ComShowCodeMessage("PRI00109");
			break;

		case IBSEARCH_ASYNC03: // Guideline Copy
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			formObj.f_cmd.value = SEARCH12;
			var sParam = FormQueryString(formObj);

			// Copy할 Guideline에 포함되어 있는 Group Location이나 Group Commodity가
			// 현재 Proposal에 미리 Copy되어 있는지를 확인한다.
			var cXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", sParam);
			var arrCnt = ComPriXml2Array(cXml, "etc1|etc2");
			if (arrCnt != null && arrCnt.length > 0) {
				var locCnt = arrCnt[0][0];
				var cmdtCnt = arrCnt[0][1];

				if (locCnt > 0) {
					ComShowCodeMessage("PRI01027");
					return false;
				}
				if (cmdtCnt > 0) {
					ComShowCodeMessage("PRI01028");
					return false;
				}
			} else {
				ComShowMessage(OBJECT_ERROR);
				return false;
			}

			// 재조회를 위해 Sheet1,2,3의 현재 선택된 Row를 기억한다.
			saveCurRowPos();

			formObj.f_cmd.value = MODIFY12;
			var sParam = FormQueryString(formObj);

			// Guideline Copy 실행
			var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);

			// 재조회
			reloadPagePostTr();

			if (sheetObjects[0].RowCount <= 0) {
				ComShowCodeMessage("PRI01016");
			} else {
				ComShowCodeMessage("PRI01017");
			}
			break;

		case IBSEARCH_ASYNC11: // Amend
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			var checkedCnt = sheetObj.CheckedRows("chk");
			if (checkedCnt == 1) {
				var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
				sheetObj.SelectRow = curRow;
				sheetObj.CellValue2(curRow, "chk") = "0";
			}
			// Amend 처리하고 해당 Row들에 대해 색상/취소선등을 처리한다.
			var idx = doRowAmend(sheetObj, "AM");
			setSheet3Style(sheetObj, idx - 1);
			setSheet3Style(sheetObj, idx);

			// Amend시 클리어되어야 할 항목들
			sheetObj.CellValue(idx, "prop_frt_rt_amt") = 0.00;
			sheetObj.CellValue(idx, "coffr_frt_rt_amt") = "";
			sheetObj.CellValue(idx, "fnl_frt_rt_amt") = "";
			sheetObj.CellValue(idx, "prs_scg_amt") = "";
			sheetObj.CellValue(idx, "prs_respb_cm_uc_amt") = "";
			sheetObj.CellValue(idx, "prs_respb_opfit_uc_amt") = "";
			sheetObj.CellValue(idx, "prs_respb_cmpb_amt") = "";
			sheetObj.CellValue(idx, "prs_gid_cmpb_amt") = "";
			sheetObj.CellValue(idx, "prs_respb_opb_amt") = "";
			sheetObj.CellValue(idx, "diff") = "";
			sheetObj.CellValue(idx, "prs_pfit_cm_uc_amt") = "";
			sheetObj.CellValue(idx, "prs_pfit_cmpb_amt") = "";
			sheetObj.CellValue(idx, "prs_upd_dt") = "";
			sheetObj.CellValue(idx, "gri_appl_tp_cd") = "";
			sheetObj.CellValue(idx, "gri_appl_amt") = "";
			sheetObj.CellValue(idx, "acpt_usr_id") = "";

			// 추가 2012.06.14 수정
			if (sheetObj.id == 'sheet17') {
				calcRate2(sheetObj, idx);
				sheetObj.CellValue2(idx, "coffr_bof_amt") = "";
				sheetObj.CellValue2(idx, "fic_coffr_rt_amt") = "";
				sheetObj.CellValue2(idx, "diff_coffr_rt_amt") = "";

				sheetObj.CellValue2(idx, "fnl_bof_amt") = "";
				sheetObj.CellValue2(idx, "fic_fnl_rt_amt") = "";
				sheetObj.CellValue2(idx, "diff_fnl_rt_amt") = "";
			}

			break;

		case IBSEARCH_ASYNC12: // Amend Cancel
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			var checkedCnt = sheetObj.CheckedRows("chk");
			if (checkedCnt == 1) {
				var curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
				sheetObj.SelectRow = curRow;
				sheetObj.CellValue2(curRow, "chk") = "0";
			}

			// Amend Cancel 처리하고 해당 Row들에 대해 색상/취소선등을 처리한다.
			var prevIdx = doRowAmendCancel(sheetObj);
			setSheet3Style(sheetObj, prevIdx);

			break;

		case IBSEARCH_ASYNC13: // Accept
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (!ComShowCodeConfirm("PRI00008")) {
				return false;
			}

			if (sheetObj.CheckedRows("chk") <= 0) {
				sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
			}

			var sCheckedRows = sheetObj.FindCheckedRow("chk");
			var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
			for ( var i = 0; i < arrCheckedRows.length; i++) {
				// Returned 상태일 경우, C/Offer 금액을 Final 금액으로 세팅한다.
				if (formObj.prc_prop_sts_cd.value == "R") {
					sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "coffr_frt_rt_amt");

					// 2012.06.14일 추가
					sheetObj.CellValue(arrCheckedRows[i], "fnl_bof_amt") = sheetObj.CellValue(arrCheckedRows[i], "coffr_bof_amt");
					sheetObj.CellValue(arrCheckedRows[i], "fic_fnl_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "fic_coffr_rt_amt");
					sheetObj.CellValue(arrCheckedRows[i], "diff_fnl_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "diff_coffr_rt_amt");

					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "A";
					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Accepted";
					// Requested 상태일 경우, Proposal 금액을 Final 금액으로 세팅한다.
				} else if (formObj.prc_prop_sts_cd.value == "Q") {
					sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "prop_frt_rt_amt");
					sheetObj.CellValue(arrCheckedRows[i], "fnl_bof_amt") = sheetObj.CellValue(arrCheckedRows[i], "prop_bof_amt");
					sheetObj.CellValue(arrCheckedRows[i], "fic_fnl_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "fic_prop_rt_amt");
					sheetObj.CellValue(arrCheckedRows[i], "diff_fnl_rt_amt") = sheetObj.CellValue(arrCheckedRows[i], "diff_prop_rt_amt");

					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "A";
					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Accepted";
				}
			}

			formObj.f_cmd.value = MODIFY01;
			var sParam = FormQueryString(formObj);
			// Check된 항목에 대해서만 Query String 을 생성한다.
			var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
			if (sSheetParam == "") {
				return false;
			}
			sParam += "&" + sSheetParam;

			saveCurRowPos();

			// 저장이 완료된 후, CMDT 및 Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
			var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);
			sheetObj.LoadSaveXml(sXml, false, "chk");

			restylingPagePostTr();
			setSheet3Style(sheetObj, -1);
			sheetObj.CheckAll2("chk") = 0;

			ComShowCodeMessage("PRI00108");
			break;

		case IBSEARCH_ASYNC14: // Accept Cancel
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (!ComShowCodeConfirm("PRI00009")) {
				return false;
			}

			if (sheetObj.CheckedRows("chk") <= 0) {
				sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
			}

			var sCheckedRows = sheetObj.FindCheckedRow("chk");
			var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
			for ( var i = 0; i < arrCheckedRows.length; i++) {
				// C/Offer 금액이 존재할 경우, Returned상태로 되돌리고,
				if (sheetObj.CellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != null && sheetObj.CellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != "") {
					sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = "";

					// 2012.06.14일 추가
					if (sheetObj.id == 'sheet17') {
						sheetObj.CellValue(arrCheckedRows[i], "fnl_bof_amt") = "";
						sheetObj.CellValue(arrCheckedRows[i], "fic_fnl_rt_amt") = "";
						sheetObj.CellValue(arrCheckedRows[i], "diff_fnl_rt_amt") = "";
					}

					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "R";
					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Returned";
					// 그렇지 않을 경우, Initial 상태로 되돌린다.
				} else {
					sheetObj.CellValue(arrCheckedRows[i], "fnl_frt_rt_amt") = "";

					// 2012.06.14일 추가
					if (sheetObj.id == 'sheet17') {
						sheetObj.CellValue(arrCheckedRows[i], "fnl_bof_amt") = "";
						sheetObj.CellValue(arrCheckedRows[i], "fic_fnl_rt_amt") = "";
						sheetObj.CellValue(arrCheckedRows[i], "diff_fnl_rt_amt") = "";
					}

					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") = "I";
					sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_nm") = "Initial";
				}
			}

			formObj.f_cmd.value = MODIFY02;
			var sParam = FormQueryString(formObj);
			// Check된 항목에 대해서만 Query String 을 생성한다.
			var sSheetParam = sheetObj.GetSaveString(false, false, "chk");
			if (sSheetParam == "") {
				return false;
			}
			sParam += "&" + sSheetParam;

			saveCurRowPos();

			var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);
			sheetObj.LoadSaveXml(sXml, false, "chk");
			// 저장이 완료된 후, CMDT 및 Route Group 에 대한 정보를 재조회해 style처리(폰트색상, 취소선)를 한다.
			restylingPagePostTr();
			setSheet3Style(sheetObj, -1);
			sheetObj.CheckAll2("chk") = 0;

			ComShowCodeMessage("PRI00109");
			break;

		case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
			var sXml = "";

			isOViaMandatory = false;
			isDViaMandatory = false;

			// 현재 Service Scope의 O.Via, D.Via가 Mandatory인지를 조회한다.
			formObj.f_cmd.value = COMMAND17;
			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
			arrTemp = ComPriXml2Array(sXml, "cd|nm");
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

		case IBSEARCH: // 조회
			if (!validateForm(sheetObj, document.form, sAction)) {
				ComShowCodeMessage("PRI01007");
				return false;
			}

			if (sheetObj.id == "sheet1") {
				for ( var i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}

				for ( var i = 0; i < sheetObjects2.length; i++) {
					sheetObjects2[i].RemoveAll();
				}

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");

				if (arrXml.length > 0)
					sheetObjects[0].LoadSearchXml(arrXml[0]); // Grid1.
				if (arrXml.length > 1)
					sheetObjects[3].LoadSearchXml(arrXml[1]); // Hidden. Grid1의 Commodity
				if (arrXml.length > 2)
					sheetObjects[4].LoadSearchXml(arrXml[2]); // Hidden. Grid1의 Actual Customer
				if (arrXml.length > 3)
					sheetObjects[5].LoadSearchXml(arrXml[3]); // Hidden. Grid1의 Commodity Note
				if (arrXml.length > 4)
					sheetObjects[14].LoadSearchXml(arrXml[4]); // Hidden. Grid1의 Commodity Note Conversion

			} else if (sheetObj.id == "sheet2") {
				for ( var i = 1; i < sheetObjects.length; i++) {
					if (i == 3 || i == 4 || i == 5 || i == 14) {
						continue;
					}
					sheetObjects[i].RemoveAll();
				}
				sheetObjects2[0].RemoveAll();

				origin_desc.innerHTML = "";
				ovia_desc.innerHTML = "";
				dvia_desc.innerHTML = "";
				dest_desc.innerHTML = "";
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "blet_dp_seq"));
			} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
				for ( var i = 2; i < sheetObjects.length; i++) {
					if (i == 3 || i == 4 || i == 5 || i == 14) {
						continue;
					}
					sheetObjects[i].RemoveAll();
				}
				sheetObjects2[0].RemoveAll();
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					getRateSheet().LoadSearchXml(arrXml[0]); // Grid3.
				if (arrXml.length > 1)
					sheetObjects[6].LoadSearchXml(arrXml[1]); // Hidden. Grid2의 Origin Point.
				if (arrXml.length > 2)
					sheetObjects[7].LoadSearchXml(arrXml[2]); // Hidden. Grid2의 Origin Via.
				if (arrXml.length > 3)
					sheetObjects[8].LoadSearchXml(arrXml[3]); // Hidden. Grid2의 Destination Via.
				if (arrXml.length > 4)
					sheetObjects[9].LoadSearchXml(arrXml[4]); // Hidden. Grid2의 Destination Point.
				if (arrXml.length > 5)
					sheetObjects[11].LoadSearchXml(arrXml[5]); // Hidden. Grid2의 Route Note.
				if (arrXml.length > 6)
					sheetObjects[15].LoadSearchXml(arrXml[6]); // Hidden. Grid2의 Route Note Conversion.
				if (arrXml.length > 7) {// Hidden. Grid2의 Route 의addon, ihc rate
					// arrXml[7]; //파싱해서 route에 넣는다.
					if (funcChkTypeStatus() != 'X') {
						var addonIhcRate = ComPriXml2Array(
								arrXml[7],
								"fic_rt_use_sts_cd|optm_trsp_mod_flg|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|locl_curr_cd|dr_locl_20ft_amt|rf_locl_20ft_amt|dg_locl_20ft_amt|dr_locl_40ft_amt|rf_locl_40ft_amt|dg_locl_40ft_amt");

						var routeHeaderSheet = sheetObjects[1];
						var routeSelRow = routeHeaderSheet.SelectRow;
						var routeStatus = routeHeaderSheet.RowStatus(routeSelRow);

						routeHeaderSheet.CellValue2(routeSelRow, "fic_rt_use_sts_cd") = addonIhcRate[0][0];
						routeHeaderSheet.CellValue2(routeSelRow, "optm_trsp_mod_flg") = addonIhcRate[0][1];
						if ("0000000000000000000000" == addonIhcRate[0][2]) {
							routeHeaderSheet.CellValue2(routeSelRow, "dr_20ft_amt") = "";
						} else {
							routeHeaderSheet.CellValue2(routeSelRow, "dr_20ft_amt") = addonIhcRate[0][2]
						}
						routeHeaderSheet.CellValue2(routeSelRow, "rf_20ft_amt") = addonIhcRate[0][3];
						routeHeaderSheet.CellValue2(routeSelRow, "dg_20ft_amt") = addonIhcRate[0][4];
						routeHeaderSheet.CellValue2(routeSelRow, "dr_40ft_amt") = addonIhcRate[0][5];
						routeHeaderSheet.CellValue2(routeSelRow, "rf_40ft_amt") = addonIhcRate[0][6];
						routeHeaderSheet.CellValue2(routeSelRow, "dg_40ft_amt") = addonIhcRate[0][7];

						routeHeaderSheet.CellValue2(routeSelRow, "locl_curr_cd") = addonIhcRate[0][8];
						routeHeaderSheet.CellValue2(routeSelRow, "dr_locl_20ft_amt") = addonIhcRate[0][9];
						routeHeaderSheet.CellValue2(routeSelRow, "rf_locl_20ft_amt") = addonIhcRate[0][10];
						routeHeaderSheet.CellValue2(routeSelRow, "dg_locl_20ft_amt") = addonIhcRate[0][11];
						routeHeaderSheet.CellValue2(routeSelRow, "dr_locl_40ft_amt") = addonIhcRate[0][12];
						routeHeaderSheet.CellValue2(routeSelRow, "rf_locl_40ft_amt") = addonIhcRate[0][13];
						routeHeaderSheet.CellValue2(routeSelRow, "dg_locl_40ft_amt") = addonIhcRate[0][14];

						routeHeaderSheet.RowStatus(routeSelRow) = routeStatus;

					}

				}

				setSheet3Style(sheetObj, -1);

			}
			break;

		case IBSAVE: // 저장
			// CMDT가 모두 삭제된 CMDT_HDR은 삭제처리한다.
			if (sheetObj.id == "sheet1") {
				var arrTgt = new Array();
				for ( var i = sheetObjects[0].LastRow; sheetObjects[0].RowCount > 0 && i >= sheetObjects[0].HeaderRows; i--) {
					if (isCMDTGroupDeleted(i)) {
						continue;
					}

					var iCnt = getAmendValidRowCountCond(sheetObjects[3], "cmdt_hdr_seq", sheetObjects[0].CellValue(i, "cmdt_hdr_seq"), formObj.amdt_seq.value);
					if (iCnt <= 0) {
						arrTgt.push(i);
					}
				}

				if (arrTgt.length > 0) {
					if (ComShowCodeConfirm("PRI00349")) {
						return;
					} else {
						for ( var i = 0; i < arrTgt.length; i++) {
							sheetObjects[0].SelectRow = arrTgt[i];
							doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
						}
					}
				}
				// Route Point가 모두 삭제된 Route는 삭제처리한다.
			} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
				if (sheetObjects[1].RowCount > 0 && !isRouteGroupDeleted()) {
					var iCntOri = getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value);
					var iCntOVia = getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value);
					var iCntDVia = getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value);
					var iCntDest = getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value);

					if (iCntOri <= 0 && iCntOVia <= 0 && iCntDVia <= 0 && iCntDest <= 0) {
						if (ComShowCodeConfirm("PRI00350")) {
							return;
						}
						doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
					} else {
						if (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") == "-1") {
							sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "org_n1st_cmnc_amdt_seq");
						}
					}
				}
			}
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			if (sheetObj.id == "sheet1") {
				// Bullet No.의 유효성을 검사한다.
				if (!validateBulletNo(sheetObj, document.form, sAction)) {
					return false;
				}

				// Source가 GC나 PC인 데이타가 수정된 경우 GM, PM으로 변경한다.
				for ( var a = 3; a <= 5; a++) {
					for ( var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
						// src_info_cd가 GC(Guideline Copy)인 경우, 수정되면 GM(Guideline Modification)으로 바꿔준다.
						if (sheetObjects[a].RowStatus(i) == "U" && sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].CellValue(i, "src_info_cd") == "GC") {
							sheetObjects[a].CellValue(i, "src_info_cd") = "GM";
							sheetObjects[a].CellValue(i, "src_info_nm") = "Guideline (M)";
						}

						// src_info_cd가 PC(Previous Contract)인 경우, 수정되면 PM(Previous Contract Modification)으로 바꿔준다.
						if (sheetObjects[a].RowStatus(i) == "U" && sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].CellValue(i, "src_info_cd") == "PC") {
							sheetObjects[a].CellValue(i, "src_info_cd") = "PM";
							sheetObjects[a].CellValue(i, "src_info_nm") = "Prev. RFA (M)";
						}
					}
				}

				formObj.f_cmd.value = MULTI01;
				var sParam = FormQueryString(formObj);
				var sParamSheet1 = sheetObjects[0].GetSaveString();
				if (sParamSheet1 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
				}
				var sParamSheet4 = sheetObjects[3].GetSaveString();
				if (sParamSheet4 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
				}
				var sParamSheet5 = sheetObjects[4].GetSaveString();
				if (sParamSheet5 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
				}
				var sParamSheet6 = sheetObjects[5].GetSaveString();
				if (sParamSheet6 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
				}
				var sParamSheet15 = sheetObjects[14].GetSaveString();
				if (sParamSheet15 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet15, "sheet15_");
				}

				if (!supressConfirm && !ComPriConfirmSave()) {
					return false;
				}

				saveCurRowPos();
				isFiredNested = true;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);
				sheetObjects[14].LoadSaveXml(sXml);
				sheetObjects[5].LoadSaveXml(sXml);
				sheetObjects[4].LoadSaveXml(sXml);
				sheetObjects[3].LoadSaveXml(sXml);
				sheetObjects[0].LoadSaveXml(sXml);
				isFiredNested = false;

				if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified || sheetObjects[4].IsDataModified || sheetObjects[5].IsDataModified || sheetObjects[14].IsDataModified) {
					return false;
				} else {
					if (reloadSw) { // 삭제된 CMDT Group을 복원한 경우 reload한다.
						saveCurRowPos();
						reloadPagePostTr();
						reloadSw = false;
					} else {
						restylingPagePostTr(true);
					}

					ComPriSaveCompleted();
					return true;
				}
			} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
				for ( var a = 2; a <= 11; a++) {
					if (a == 3 || a == 4 || a == 5) {
						continue;
					}
					// Source가 GC나 PC인 데이타가 수정된 경우 GM, PM으로 변경한다.
					for ( var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
						// Proposal단계이고 src_info_cd가 GC(Guideline Copy)인 경우, 수정되면 GM(Guideline Modification)으로 바꿔준다.
						if (sheetObjects[a].RowStatus(i) == "U" && sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].CellValue(i, "src_info_cd") == "GC") {
							sheetObjects[a].CellValue(i, "src_info_cd") = "GM";
							sheetObjects[a].CellValue(i, "src_info_nm") = "Guideline (M)";
						}

						// Proposal단계이고 src_info_cd가 PC(Previous Contract)인 경우, 수정되면 PM(Previous Contract Modification)으로 바꿔준다.
						if (sheetObjects[a].RowStatus(i) == "U" && sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].CellValue(i, "src_info_cd") == "PC") {
							sheetObjects[a].CellValue(i, "src_info_cd") = "PM";
							sheetObjects[a].CellValue(i, "src_info_nm") = "Prev. RFA (M)";
						}
					}
				}
				for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
					// C/Offer 금액이 입력되었을 경우, prc_prog_sts_cd를 Returned로 변경해준다.
					if (sheetObj.RowStatus(i) == "U" && bIsAproUsr && formObj.prc_prop_sts_cd.value == "Q" && sheetObj.CellValue(i, "prc_prog_sts_cd") == "I"
							&& sheetObj.CellValue(i, "coffr_frt_rt_amt") != null && sheetObj.CellValue(i, "coffr_frt_rt_amt") != "") {
						sheetObj.CellValue(i, "prc_prog_sts_cd") = "R";
						sheetObj.CellValue(i, "prc_prog_sts_nm") = "Returned";
					}

					// C/Offer 금액이 Clear되었을 경우, prc_prog_sts_cd를 Initial로 변경해준다.
					if (sheetObj.RowStatus(i) == "U" && bIsAproUsr && formObj.prc_prop_sts_cd.value == "Q" && sheetObj.CellValue(i, "prc_prog_sts_cd") == "R"
							&& (sheetObj.CellValue(i, "coffr_frt_rt_amt") == null || sheetObj.CellValue(i, "coffr_frt_rt_amt") == "")) {
						sheetObj.CellValue(i, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue(i, "prc_prog_sts_nm") = "Initial";
					}

					// GRI Calc.가 적용된 Rate가 수정된 경우, 상태를 A에서 M으로 변경.
					if (sheetObj.RowStatus(i) == "U" && sheetObj.CellValue(i, "gri_appl_tp_cd") == "A") {
						sheetObj.CellValue(i, "gri_appl_tp_cd") = "M";
					}

					if (sheetObj.id == 'sheet17') {
						if (sheetObj.CellEditable(i, 'fic_prop_rt_amt')) {
							if (sheetObj.CellValue(i, 'fic_prop_rt_amt') == 0) {
								ComShowCodeMessage('PRI07022');
								return false;
							}
						}
					}
				}

				formObj.f_cmd.value = MULTI02;
				var sParam = FormQueryString(formObj);
				var sParamSheet2 = sheetObjects[1].GetSaveString();
				if (sParamSheet2 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				}
				var sParamSheet3 = getRateSheet().GetSaveString();
				if (sParamSheet3 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
				}
				
				for ( var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
					var beforeRowSts = sheetObjects[6].RowStatus(i);
					sheetObjects[6].CellValue2(i, 'bse_port_loc_cd') = sheetObjects[6].CellValue(i, "bse_port_def_cd");
					sheetObjects[6].RowStatus(i) = beforeRowSts;
				}
					
				var sParamSheet7 = sheetObjects[6].GetSaveString();
				if(sParamSheet7 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
				}
				
				var sParamSheet8 = sheetObjects[7].GetSaveString();
				if (sParamSheet8 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
				}
				var sParamSheet9 = sheetObjects[8].GetSaveString();
				if (sParamSheet9 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
				}
				for ( var i = sheetObjects[9].HeaderRows; i <= sheetObjects[9].LastRow; i++) {
					var beforeRowSts = sheetObjects[9].RowStatus(i);
					sheetObjects[9].CellValue2(i, 'bse_port_loc_cd') = sheetObjects[9].CellValue(i, "bse_port_def_cd");
					sheetObjects[9].RowStatus(i) = beforeRowSts;
				}
				var sParamSheet10 = sheetObjects[9].GetSaveString();
				if (sParamSheet10 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet10, "sheet10_");
				}
				
				var sParamSheet12 = sheetObjects[11].GetSaveString();
				if (sParamSheet12 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet12, "sheet12_");
				}
				var sParamSheet16 = sheetObjects[15].GetSaveString();
				if (sParamSheet16 != "") {
					sParam += "&" + ComPriSetPrifix(sParamSheet16, "sheet16_");
				}

				if (!supressConfirm && !ComPriConfirmSave()) {
					return false;
				}
				saveCurRowPos();
				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_07GS.do", sParam);
				sheetObjects[15].LoadSaveXml(sXml);
				sheetObjects[11].LoadSaveXml(sXml);
				sheetObjects[9].LoadSaveXml(sXml);
				sheetObjects[8].LoadSaveXml(sXml);
				sheetObjects[7].LoadSaveXml(sXml);
				sheetObjects[6].LoadSaveXml(sXml);
				// sheetObjects[2].LoadSaveXml(sXml);
				getRateSheet().LoadSaveXml(sXml);
				sheetObjects[1].LoadSaveXml(sXml);

				if (sheetObjects[1].IsDataModified
				// || sheetObjects[2].IsDataModified
				|| getRateSheet().IsDataModified || sheetObjects[6].IsDataModified || sheetObjects[7].IsDataModified || sheetObjects[8].IsDataModified || sheetObjects[9].IsDataModified
						|| sheetObjects[11].IsDataModified || sheetObjects[15].IsDataModified) {
					return false;
				} else {
					if (reloadSw) { // 삭제된 Route Group을 복원한 경우 reload한다.
						saveCurRowPos();
						reloadPagePostTr(1);
						reloadSw = false;
					} else {
						restylingPagePostTr();
					}

					ComPriSaveCompleted();
					return true;
				}
			}
			return true;
			break;

		case IBDOWNEXCEL:
			if (!validateForm(sheetObj, document.form, sAction)) {
				ComShowCodeMessage('PRI01007');
				return false;
			}

			if (sheetObj.id == "sheet13") {
				formObj.f_cmd.value = SEARCH10;
				sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj));
			} else if (sheetObj.id == "sheet14") {
				formObj.f_cmd.value = SEARCH11;
				if (funcCheckFicRtTpCdVal() == 'A') {
					sheetObj = sheetObjects2[1]; // sheet18
				}
				sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj));
			}

			break;

		case IBINSERT: // Row Add
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			if (sheetObj.id == "sheet1") {

				// RowAdd시 Row가 이동하므로 doRowChange함수를 이용한다.
				var idx = doRowChange1(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
				if (idx < 0) {
					return false;
				}

				sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "blet_dp_seq") = getNextBletDpSeq();
				sheetObj.CellValue(idx, "nd_cnt") = 1;
				sheetObj.CellValue(idx, "na_cnt") = 1;
				sheetObj.CellValue(idx, "fic_rt_tp_cd") = funcCheckFicRtTpCdVal();

				// 화면에서 증가시킨 cmdt_hdr_seq와 실제 저장된 cmdt_hdr_seq 중 큰것을 선택
				var cmdtHdrSeq1 = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
				formObj.f_cmd.value = SEARCH08;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
				var cmdtHdrSeq2 = parseInt(ComGetEtcData(sXml, "cmdt_hdr_seq"));
				if (cmdtHdrSeq1 > cmdtHdrSeq2) {
					sheetObj.CellValue(idx, "cmdt_hdr_seq") = cmdtHdrSeq1;
				} else {
					sheetObj.CellValue(idx, "cmdt_hdr_seq") = cmdtHdrSeq2;
				}

				for ( var i = 1; i < sheetObjects.length; i++) {
					if (i == 3 || i == 4 || i == 5 || i == 14) {
						continue;
					}
					sheetObjects[i].RemoveAll();
				}
				sheetObjects2[0].RemoveAll();

				formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
				origin_desc.innerHTML = "";
				ovia_desc.innerHTML = "";
				dvia_desc.innerHTML = "";
				dest_desc.innerHTML = "";

				sheet1_OnPopupClick(sheetObj, idx, 8);
			} else if (sheetObj.id == "sheet2") {
				var idx = doRowChange2(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
				if (idx < 0) {
					return false;
				}

				// Route Seq.를 LastRow + 1로 설정한다.
				var rn = "";
				if (sheetObj.RowCount == 1) {
					rn = sheetObjects[0].SelectRow + ".1";
				} else {
					var lastRow = idx == sheetObj.LastRow ? sheetObj.LastRow - 1 : sheetObj.LastRow;
					var arrRn = sheetObj.CellValue(lastRow, "rn").split(".");
					arrRn[1] = parseInt(arrRn[1]) + 1;
					rn = arrRn.join(".");
				}
				sheetObj.CellValue(idx, "rn") = rn;
				sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "org_n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;

				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "cmdt_hdr_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
				sheetObj.CellValue(idx, "rout_seq") = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
				sheetObj.CellValue(idx, "nd_cnt") = 1;
				sheetObj.CellValue(idx, "na_cnt") = 1;

				for ( var i = 2; i < sheetObjects.length; i++) {
					if (i == 3 || i == 4 || i == 5 || i == 14) {
						continue;
					}
					sheetObjects[i].RemoveAll();
				}
				sheetObjects2[0].RemoveAll();

				formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
				origin_desc.innerHTML = "";
				ovia_desc.innerHTML = "";
				dvia_desc.innerHTML = "";
				dest_desc.innerHTML = "";

				sheet2_OnPopupClick(sheetObj, idx, 8);
			} else if (sheetObj.id == "sheet3") {
				var idx = sheetObj.DataInsert();

				sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
				sheetObj.CellValue(idx, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
				sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;
				sheetObj.CellValue(idx, "prop_frt_rt_amt") = 0.00;

				sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
				sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
				sheetObj.CellValue(idx, "src_info_cd") = "NW";
				sheetObj.CellValue(idx, "src_info_nm") = "New";
				sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;

				setSheet3Style(sheetObj, idx);

				sheetObj.SelectCell(idx, "rat_ut_cd", false);
			} else if (sheetObj.id == "sheet17") {
				/**
				 * 2012.06.07일 추가<br>
				 * Rate Of Including IHC를 선택후 <br>
				 * Rate를 Row_add 할 경우 Route의 Error 값이 1,2,3 일겨우는 입력 못하게 막는다.
				 */
				var sheetObj2 = sheetObjects[1];
				var sheetObj2_fic_rt_use_sts_cd = sheetObj2.CellValue(sheetObj2.selectRow, "fic_rt_use_sts_cd");
				if (funcChkTypeStatus() != "X" && (sheetObj2_fic_rt_use_sts_cd == "1" || sheetObj2_fic_rt_use_sts_cd == "2" || sheetObj2_fic_rt_use_sts_cd == "3")) {
					ComShowCodeMessage("PRI07019");
					return false;
				}
				var idx = sheetObj.DataInsert();
				sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
				sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
				sheetObj.CellValue(idx, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
				sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;

				sheetObj.CellValue(idx, "prc_prog_sts_cd") = "I";
				sheetObj.CellValue(idx, "prc_prog_sts_nm") = "Initial";
				sheetObj.CellValue(idx, "src_info_cd") = "NW";
				sheetObj.CellValue(idx, "src_info_nm") = "New";
				sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
				sheetObj.CellValue(idx, "exp_dt") = formObj.exp_dt.value;
				setSheet3Style(sheetObj, idx);

				sheetObj.SelectCell(idx, "rat_ut_cd", false);
				calcRate2(sheetObj, idx);
			}

			break;

		case IBCOPYROW: // Row Copy
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (sheetObj.id == "sheet1") {
				var prevCmdtHdrSeq = sheetObj.CellValue(sheetObj.SelectRow, "cmdt_hdr_seq");

				// RowCopy시 Row가 이동하므로 doRowChange함수를 이용한다.
				var idx = doRowChange1(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
				if (idx < 0) {
					return false;
				}

				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;

				var cmdtHdrSeq1 = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
				formObj.f_cmd.value = SEARCH08;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
				var cmdtHdrSeq2 = parseInt(ComGetEtcData(sXml, "cmdt_hdr_seq"));
				if (cmdtHdrSeq1 > cmdtHdrSeq2) {
					sheetObj.CellValue(idx, "cmdt_hdr_seq") = cmdtHdrSeq1;
				} else {
					sheetObj.CellValue(idx, "cmdt_hdr_seq") = cmdtHdrSeq2;
				}

				var newCmdtHdrSeq = sheetObj.CellValue(idx, "cmdt_hdr_seq");

				sheetObj.CellValue(idx, "cmdt_hdr_seq") = newCmdtHdrSeq;
				formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");

				sheetObj.CellValue(idx, "blet_dp_seq") = getNextBletDpSeq();
				sheetObj.CellEditable(idx, "blet_dp_seq") = true;

				// Sheet4(CMDT)를 Copy.
				for ( var i = sheetObjects[3].LastRow; i >= sheetObjects[3].HeaderRows; i--) {
					if (sheetObjects[3].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
						if (sheetObjects[3].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							continue;
						}
						if (sheetObjects[3].CellValue(i, "src_info_cd") == "AD") {
							continue;
						}

						sheetObjects[3].SelectCell(i, 0);
						var insIdx = sheetObjects[3].DataCopy();
						sheetObjects[3].CellValue(insIdx, "cmdt_hdr_seq") = newCmdtHdrSeq;

						sheetObjects[3].CellValue(insIdx, "prc_prog_sts_cd") = "I";
						sheetObjects[3].CellValue(insIdx, "prc_prog_sts_nm") = "Initial";
						sheetObjects[3].CellValue(insIdx, "src_info_cd") = "NW";
						sheetObjects[3].CellValue(insIdx, "src_info_nm") = "New";
						sheetObjects[3].CellValue(insIdx, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[3].CellValue(insIdx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects[3].CellValue(insIdx, "exp_dt") = formObj.exp_dt.value;
					}
				}

				// Sheet5(Actual Customer)를 Copy.
				for ( var i = sheetObjects[4].LastRow; i >= sheetObjects[4].HeaderRows; i--) {
					if (sheetObjects[4].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
						if (sheetObjects[4].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							continue;
						}
						if (sheetObjects[4].CellValue(i, "src_info_cd") == "AD") {
							continue;
						}

						sheetObjects[4].SelectCell(i, 0);
						var insIdx = sheetObjects[4].DataCopy();
						sheetObjects[4].CellValue(insIdx, "cmdt_hdr_seq") = newCmdtHdrSeq;

						sheetObjects[4].CellValue(insIdx, "prc_prog_sts_cd") = "I";
						sheetObjects[4].CellValue(insIdx, "prc_prog_sts_nm") = "Initial";
						sheetObjects[4].CellValue(insIdx, "src_info_cd") = "NW";
						sheetObjects[4].CellValue(insIdx, "src_info_nm") = "New";
						sheetObjects[4].CellValue(insIdx, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[4].CellValue(insIdx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects[4].CellValue(insIdx, "exp_dt") = formObj.exp_dt.value;
					}
				}

				// Sheet6(Commodity Note)를 Copy.
				for ( var i = sheetObjects[5].LastRow; i >= sheetObjects[5].HeaderRows; i--) {
					if (sheetObjects[5].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
						if (sheetObjects[5].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							continue;
						}
						if (sheetObjects[5].CellValue(i, "src_info_cd") == "AD") {
							continue;
						}

						sheetObjects[5].SelectCell(i, 0);
						var insIdx = sheetObjects[5].DataCopy();
						sheetObjects[5].CellValue(insIdx, "cmdt_hdr_seq") = newCmdtHdrSeq;

						var prevNoteConvMapgId = sheetObjects[5].CellValue(i, "note_conv_mapg_id");

						// 새로운 note_conv_mapg_id를 채번.
						formObj.f_cmd.value = COMMAND38;
						var sXml = sheetObjects[5].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
						var sysGuid = ComGetEtcData(sXml, "SYS_GUID");
						sheetObjects[5].CellValue(insIdx, "note_conv_mapg_id") = sysGuid;

						// Conversion도 함께 Copy한다.
						for ( var j = sheetObjects[14].LastRow; j >= sheetObjects[14].HeaderRows; j--) {
							if (sheetObjects[14].CellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
								sheetObjects[14].SelectCell(j, 0);
								var convIdx = sheetObjects[14].DataCopy();
								sheetObjects[14].CellValue(convIdx, "note_conv_mapg_id") = sysGuid;
								sheetObjects[14].CellValue(convIdx, "eff_dt") = formObj.eff_dt.value;
								sheetObjects[14].CellValue(convIdx, "exp_dt") = formObj.exp_dt.value;
							}
						}

						sheetObjects[5].CellValue(insIdx, "prc_prog_sts_cd") = "I";
						sheetObjects[5].CellValue(insIdx, "prc_prog_sts_nm") = "Initial";
						sheetObjects[5].CellValue(insIdx, "src_info_cd") = "NW";
						sheetObjects[5].CellValue(insIdx, "src_info_nm") = "New";
						sheetObjects[5].CellValue(insIdx, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[5].CellValue(insIdx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects[5].CellValue(insIdx, "exp_dt") = formObj.exp_dt.value;
					}
				}

				for ( var i = 1; i < sheetObjects.length; i++) {
					if (i == 3 || i == 4 || i == 5 || i == 14) {
						continue;
					}
					sheetObjects[i].RemoveAll();
				}
				sheetObjects2[0].RemoveAll();

				formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
				origin_desc.innerHTML = "";
				ovia_desc.innerHTML = "";
				dvia_desc.innerHTML = "";
				dest_desc.innerHTML = "";

				// 새로 Copy한 row의 Note Tooltip을 세팅한다.
				setNoteTooltip(sheetObj, idx);
			}
			// Route Group Copy. 자세한 내용은 CMDT Group Copy의 주석 참조.
			if (sheetObj.id == "sheet2") {
				var prevRoutSeq = sheetObj.CellValue(sheetObj.SelectRow, "rout_seq");

				var idx = doRowChange2(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
				if (idx < 0) {
					return false;
				}

				var rn = "";
				if (sheetObj.RowCount == 1) {
					rn = sheetObjects[0].SelectRow + ".1";
				} else {
					var lastRow = idx == sheetObj.LastRow ? sheetObj.LastRow - 1 : sheetObj.LastRow;
					var arrRn = sheetObj.CellValue(lastRow, "rn").split(".");
					arrRn[1] = parseInt(arrRn[1]) + 1;
					rn = arrRn.join(".");
				}
				sheetObj.CellValue(idx, "rn") = rn;

				sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;

				var newRoutSeq = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
				sheetObj.CellValue(idx, "rout_seq") = newRoutSeq;
				formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");

				formObj.f_cmd.value = COMMAND38;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				var sysGuid = ComGetEtcData(sXml, "SYS_GUID");

				var prevNoteConvMapgId = "";

				// sheetObjects[6,7,8,9,10,11] copy
				for ( var a = 6; a <= 11; a++) {
					if (sheetObjects[a].RowCount <= 0) {
						continue;
					}
					for ( var i = sheetObjects[a].LastRow; i >= sheetObjects[a].HeaderRows && sheetObjects[a].RowCount > 0; i--) {
						if (sheetObjects[a].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							sheetObjects[a].RowDelete(i, false);
							continue;
						}
						if (sheetObjects[a].CellValue(i, "src_info_cd") == "AD") {
							sheetObjects[a].RowDelete(i, false);
							continue;
						}

						var colName = "";
						if (a == 6 || a == 9) {
							colName = "rout_pnt_seq";
						} else if (a == 7 || a == 8) {
							colName = "rout_via_seq";
						} else if (a == 11) {
							colName = "rout_note_seq";
							prevNoteConvMapgId = sheetObjects[a].CellValue(i, "note_conv_mapg_id");
							sheetObjects[a].CellValue(i, "note_conv_mapg_id") = sysGuid;
						}
						sheetObjects[a].CellValue(i, "rout_seq") = newRoutSeq;
						if (colName != "") {
							sheetObjects[a].CellValue(i, colName) = i;
						}
						sheetObjects[a].CellValue(i, "prc_prog_sts_cd") = "I";
						sheetObjects[a].CellValue(i, "prc_prog_sts_nm") = "Initial";
						sheetObjects[a].CellValue(i, "src_info_cd") = "NW";
						sheetObjects[a].CellValue(i, "src_info_nm") = "New";
						sheetObjects[a].CellValue(i, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects[a].CellValue(i, "exp_dt") = formObj.exp_dt.value;

						sheetObjects[a].RowStatus(i) = "I";
					}
				}

				// Route Note Conversion
				for ( var i = sheetObjects[15].LastRow; i >= sheetObjects[15].HeaderRows && sheetObjects[15].RowCount > 0; i--) {
					if (sheetObjects[15].CellValue(i, "note_conv_mapg_id") == prevNoteConvMapgId) {
						sheetObjects[15].CellValue(i, "note_conv_mapg_id") = sysGuid;
						sheetObjects[15].CellValue(i, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[15].CellValue(i, "exp_dt") = formObj.exp_dt.value;
						sheetObjects[15].RowStatus(i) = "I";
					} else {
						sheetObjects[15].RowDelete(i, false);
					}
				}
				if (funcCheckFicRtTpCdVal() == 'G') {
					for ( var i = sheetObjects[2].LastRow; i >= sheetObjects[2].HeaderRows && sheetObjects[2].RowCount > 0; i--) {
						if (sheetObjects[2].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							sheetObjects[2].RowDelete(i, false);
							continue;
						}
						if (sheetObjects[2].CellValue(i, "src_info_cd") == "AD") {
							sheetObjects[2].RowDelete(i, false);
							continue;
						}

						sheetObjects[2].CellValue(i, "rout_seq") = newRoutSeq;
						sheetObjects[2].CellValue(i, "rt_seq") = i;
						sheetObjects[2].CellValue(i, "prc_prog_sts_cd") = "I";
						sheetObjects[2].CellValue(i, "prc_prog_sts_nm") = "Initial";
						sheetObjects[2].CellValue(i, "src_info_cd") = "NW";
						sheetObjects[2].CellValue(i, "src_info_nm") = "New";
						sheetObjects[2].CellValue(i, "eff_dt") = formObj.eff_dt.value;
						sheetObjects[2].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects[2].CellValue(i, "exp_dt") = formObj.exp_dt.value;

						// Row Copy시 Clear되어야하는 항목
						sheetObjects[2].CellValue(i, "coffr_frt_rt_amt") = "";
						sheetObjects[2].CellValue(i, "fnl_frt_rt_amt") = "";

						sheetObjects[2].CellValue(i, "prs_scg_amt") = "";
						sheetObjects[2].CellValue(i, "prs_respb_cm_uc_amt") = "";
						sheetObjects[2].CellValue(i, "prs_respb_opfit_uc_amt") = "";
						sheetObjects[2].CellValue(i, "prs_respb_cmpb_amt") = "";
						sheetObjects[2].CellValue(i, "prs_gid_cmpb_amt") = "";
						sheetObjects[2].CellValue(i, "prs_respb_opb_amt") = "";
						sheetObjects[2].CellValue(i, "diff") = "";
						sheetObjects[2].CellValue(i, "prs_pfit_cm_uc_amt") = "";
						sheetObjects[2].CellValue(i, "prs_pfit_cmpb_amt") = "";
						sheetObjects[2].CellValue(i, "prs_upd_dt") = "";
						sheetObjects[2].CellValue(i, "gri_appl_tp_cd") = "";
						sheetObjects[2].CellValue(i, "gri_appl_amt") = "";
						sheetObjects[2].CellValue(i, "acpt_usr_id") = "";

						sheetObjects[2].RowStatus(i) = "I";
					}
					setSheet3Style(sheetObjects[2], -1);
					setNoteTooltip(sheetObj, idx);
				}
				if (funcCheckFicRtTpCdVal() == 'A') {
					for ( var i = sheetObjects2[0].LastRow; i >= sheetObjects2[0].HeaderRows && sheetObjects2[0].RowCount > 0; i--) {
						if (sheetObjects2[0].CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
							sheetObjects2[0].RowDelete(i, false);
							continue;
						}
						if (sheetObjects2[0].CellValue(i, "src_info_cd") == "AD") {
							sheetObjects2[0].RowDelete(i, false);
							continue;
						}

						sheetObjects2[0].CellValue(i, "rout_seq") = newRoutSeq;
						sheetObjects2[0].CellValue(i, "rt_seq") = i;
						sheetObjects2[0].CellValue(i, "prc_prog_sts_cd") = "I";
						sheetObjects2[0].CellValue(i, "prc_prog_sts_nm") = "Initial";
						sheetObjects2[0].CellValue(i, "src_info_cd") = "NW";
						sheetObjects2[0].CellValue(i, "src_info_nm") = "New";
						sheetObjects2[0].CellValue(i, "eff_dt") = formObj.eff_dt.value;
						sheetObjects2[0].CellValue(i, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObjects2[0].CellValue(i, "exp_dt") = formObj.exp_dt.value;

						// Row Copy시 Clear되어야하는 항목
						sheetObjects2[0].CellValue(i, "coffr_frt_rt_amt") = "";
						sheetObjects2[0].CellValue(i, "coffr_bof_amt") = "";
						sheetObjects2[0].CellValue(i, "fic_coffr_rt_amt") = "";
						sheetObjects2[0].CellValue(i, "diff_coffr_rt_amt") = "";

						sheetObjects2[0].CellValue(i, "fnl_frt_rt_amt") = "";
						sheetObjects2[0].CellValue(i, "fnl_bof_amt") = "";
						sheetObjects2[0].CellValue(i, "fic_fnl_rt_amt") = "";
						sheetObjects2[0].CellValue(i, "diff_fnl_rt_amt") = "";

						sheetObjects2[0].CellValue(i, "prs_scg_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_respb_cm_uc_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_respb_opfit_uc_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_respb_cmpb_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_gid_cmpb_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_respb_opb_amt") = "";
						sheetObjects2[0].CellValue(i, "diff") = "";
						sheetObjects2[0].CellValue(i, "prs_pfit_cm_uc_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_pfit_cmpb_amt") = "";
						sheetObjects2[0].CellValue(i, "prs_upd_dt") = "";
						sheetObjects2[0].CellValue(i, "gri_appl_tp_cd") = "";
						sheetObjects2[0].CellValue(i, "gri_appl_amt") = "";
						sheetObjects2[0].CellValue(i, "acpt_usr_id") = "";

						sheetObjects2[0].RowStatus(i) = "I";
					}
					setSheet3Style(sheetObjects2[0], -1);
					setNoteTooltip(sheetObj, idx);
				}

			}
			break;

		case IBDELETE: // Delete
			if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (sheetObj.CheckedRows("chk") <= 0) {
				sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
			}

			var sCheckedRows = sheetObj.FindCheckedRow("chk");
			var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");

			if (sheetObj.id == "sheet1") {
				var ficRtTpCdVal = funcCheckFicRtTpCdVal();

				// Sheet3 ~ Sheet12을 처리
				for ( var a = 2; a <= 11; a++) {
					var convIdx;
					if (a == 5) {
						convIdx = 14;
					} else if (a == 11) {
						convIdx = 15;
					} else {
						convIdx = -1;
					}

					var delSheetObj = sheetObjects[a];
					if (a == 2 && ficRtTpCdVal == "A") {
						delSheetObj = getRateSheet();
					}

					// 삭제할 Row와 현재 선택된 Row가 다를 경우, sheet4~6을 제외하곤 처리하지 않는다.
					// (이미 다른 CMDT Group의 데이타가 로드되어 있으므로... sheet4~6은 CMDT Group전체의 데이타가 로드되어 있으므로 처리해야함.)
					if (sheetObj.CellValue(sheetObj.SelectRow, "chk") == "0" && a != 3 && a != 4 && a != 5) {
						continue;
					}

					// 기존 Amend를 모두 Cancel한다.
					if (formObj.amdt_seq.value != "0") {
						for ( var i = delSheetObj.HeaderRows; delSheetObj.RowCount > 0 && i <= delSheetObj.LastRow; i++) {
							// Sheet4~6중 CMDT Group의 체크된 항목과 같은 CMDT_HDR_SEQ를 가진 항목들은 기존 Amend를 Cancel처리한다.
							if (a == 3 || a == 4 || a == 5) {
								var bExist = false;
								var curCmdtHdrSeq = delSheetObj.CellValue(i, "cmdt_hdr_seq");
								for ( var k = 0; k < arrCheckedRows.length; k++) {
									if (sheetObj.CellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
										bExist = true;
									}
								}
								if (!bExist) {
									continue;
								}
							}

							if (delSheetObj.CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
								delSheetObj.SelectRow = i + 1;

								var newNoteConvMapgId = "";
								var prevNoteConvMapgId = "";
								if (a == 5 || a == 11) {
									newNoteConvMapgId = delSheetObj.CellValue(delSheetObj.SelectRow, "note_conv_mapg_id");
									prevNoteConvMapgId = delSheetObj.CellValue(delSheetObj.SelectRow - 1, "note_conv_mapg_id");
								}

								// Amend Cancel
								var prevIdx = doRowAmendCancel(delSheetObj);

								if (a == 2) {
									setSheet3Style(delSheetObj, prevIdx);
								}

								// CMDT & Route Note 인 경우, Cancel시 Conversion도 함께 처리해준다.
								if (a == 5 || a == 11) {
									// 원복될 이전Seq Note의 note_conv_mapg_id를 현재 값으로 바꿔준다.
									delSheetObj.CellValue2(prevIdx, "note_conv_mapg_id") = newNoteConvMapgId;
									// Amend Cancel시 삭제될(Cancel될) Row의 Conversion은 삭제한다.
									for ( var j = sheetObjects[convIdx].LastRow; sheetObjects[convIdx].RowCount > 0 && j >= sheetObjects[convIdx].HeaderRows; j--) {
										if (sheetObjects[convIdx].RowStatus(j) == "D") {
											continue;
										}
										if (sheetObjects[convIdx].CellValue(j, "note_conv_mapg_id") == newNoteConvMapgId) {
											sheetObjects[convIdx].RowDelete(j, false);
										}
									}
									// 원복될 이전Seq Note의 Conversion은 다시 Copy해 초기상태로 만들어 놓는다.
									for ( var j = sheetObjects[convIdx].LastRow; sheetObjects[convIdx].RowCount > 0 && j >= sheetObjects[convIdx].HeaderRows; j--) {
										if (sheetObjects[convIdx].RowStatus(j) == "D") {
											continue;
										}
										if (sheetObjects[convIdx].CellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
											sheetObjects[convIdx].SelectCell(j, 0);
											var copiedIdx = sheetObjects[convIdx].DataCopy();

											sheetObjects[convIdx].CellValue2(copiedIdx, "note_conv_mapg_id") = newNoteConvMapgId;
											sheetObjects[convIdx].CellValue2(copiedIdx, "amdt_seq") = formObj.amdt_seq.value;
											if (sheetObjects[convIdx].CellValue(copiedIdx, "exp_dt") == formObj.pre_exp_dt.value) {
												sheetObjects[convIdx].CellValue2(copiedIdx, "exp_dt") = formObj.exp_dt.value;
											}
										}
									}
								}
							}
						}
					}

					// 새로 Amend Delete 또는 Delete한다.
					for ( var i = delSheetObj.LastRow; delSheetObj.RowCount > 0 && i >= delSheetObj.HeaderRows; i--) {
						if (a == 3 || a == 4 || a == 5) {
							var bExist = false;
							var curCmdtHdrSeq = delSheetObj.CellValue(i, "cmdt_hdr_seq");
							for ( var k = 0; k < arrCheckedRows.length; k++) {
								if (sheetObj.CellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
									bExist = true;
								}
							}
							if (!bExist) {
								continue;
							}
						}

						// Amend Delete
						if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
							delSheetObj.SelectRow = i;
							delSheetObj.CellValue2(delSheetObj.SelectRow, "chk") = "0";

							var idx = doRowAmend(delSheetObj, "AD");

							if (a == 2) {
								setSheet3Style(delSheetObj, idx - 1);
								setSheet3Style(delSheetObj, idx);
							}

							// CMDT & Route Note인 경우 해당 Conversion도 함께 삭제한다.
							if (a == 5 || a == 11) {
								delSheetObj.CellValue2(idx - 1, "note_conv_mapg_id") = delSheetObj.CellValue(idx, "prev_note_conv_mapg_id");
								delSheetObj.RowStatus(idx - 1) = "R";

								for ( var j = sheetObjects[convIdx].LastRow; sheetObjects[convIdx].RowCount > 0 && j >= sheetObjects[convIdx].HeaderRows; j--) {
									if (sheetObjects[convIdx].RowStatus(j) == "D") {
										continue;
									}
									if (sheetObjects[convIdx].CellValue(j, "note_conv_mapg_id") == delSheetObj.CellValue(idx, "note_conv_mapg_id")) {
										sheetObjects[convIdx].RowDelete(j, false);
									}
								}
							}

							// Route Group의 데이타들은 RowStatus를 R로 바꿔준다.
							// 그래야 CMDT Group과 Route Group에 동시에 수정사항이 발생하지 않는다.
							if (a != 3 && a != 4 && a != 5) {
								delSheetObj.RowStatus(idx - 1) = "R";
								delSheetObj.RowStatus(idx) = "R";
							}
							// Row Delete
						} else if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
								&& (delSheetObj.CellValue(i, "src_info_cd") == "NW" || delSheetObj.CellValue(i, "src_info_cd") == "GC" || delSheetObj.CellValue(i, "src_info_cd") == "GM"
										|| delSheetObj.CellValue(i, "src_info_cd") == "PC" || delSheetObj.CellValue(i, "src_info_cd") == "PM")) {
							// CMDT & Route Note인 경우 해당 Conversion도 함께 삭제한다.
							if (a == 5) {
								for ( var j = sheetObjects[14].LastRow; sheetObjects[14].RowCount > 0 && j >= sheetObjects[14].HeaderRows; j--) {
									if (sheetObjects[14].CellValue(j, "note_conv_mapg_id") == sheetObjects[5].CellValue(i, "note_conv_mapg_id")) {
										sheetObjects[14].RowDelete(j, false);
									}
								}
							}
							if (a == 11) {
								for ( var j = sheetObjects[15].LastRow; sheetObjects[15].RowCount > 0 && j >= sheetObjects[15].HeaderRows; j--) {
									if (sheetObjects[15].CellValue(j, "note_conv_mapg_id") == delSheetObj.CellValue(i, "note_conv_mapg_id")) {
										sheetObjects[15].RowDelete(j, false);
									}
								}
							}

							// 그냥 Delete해도 관계가 없나?
							delSheetObj.RowDelete(i, false);
						}
					}
				}

				// Sheet2를 Delete 처리
				if (sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
					for ( var i = sheetObjects[1].LastRow; sheetObjects[1].RowCount > 0 && i >= sheetObjects[1].HeaderRows; i--) {
						if (sheetObjects[1].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
							sheetObjects[1].RowDelete(i, false);
						} else {
							setHdrLineDeleted(sheetObjects[1], i);
							sheetObjects[1].RowStatus(i) = "R";
						}
					}
				}

				// Sheet1를 Delete 처리
				for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
					if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
						sheetObj.CellValue2(arrCheckedRows[i], "chk") = 0;
						setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
					}
				}
				deleteRowCheck(sheetObj, "chk");

			} else if (sheetObj.id == "sheet2") {
				// Sheet3, Sheet7 ~ Sheet12을 처리
				if (sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
					var ficRtTpCdVal = funcCheckFicRtTpCdVal();
					for ( var a = 2; a <= 11; a++) {
						if (a == 3 || a == 4 || a == 5) {
							continue;
						}
						var delSheetObj = sheetObjects[a];
						if (a == 2 && ficRtTpCdVal == "A") {
							delSheetObj = getRateSheet();
						}
						// 기존 Amend를 모두 Cancel한다.
						if (formObj.amdt_seq.value != "0") {
							for ( var i = delSheetObj.HeaderRows; delSheetObj.RowCount > 0 && i <= delSheetObj.LastRow; i++) {
								if (delSheetObj.CellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
									delSheetObj.SelectRow = i + 1;

									var newNoteConvMapgId = "";
									var prevNoteConvMapgId = "";
									if (a == 11) {
										newNoteConvMapgId = delSheetObj.CellValue(delSheetObj.SelectRow, "note_conv_mapg_id");
										prevNoteConvMapgId = delSheetObj.CellValue(delSheetObj.SelectRow - 1, "note_conv_mapg_id");
									}

									var prevIdx = doRowAmendCancel(delSheetObj);

									if (a == 2) {
										setSheet3Style(delSheetObj, prevIdx);
									}
									// Route Note인 경우, Conversion도 처리.
									if (a == 11) {
										delSheetObj.CellValue2(prevIdx, "note_conv_mapg_id") = newNoteConvMapgId;
										for ( var j = sheetObjects[15].LastRow; sheetObjects[15].RowCount > 0 && j >= sheetObjects[15].HeaderRows; j--) {
											if (sheetObjects[15].RowStatus(j) == "D") {
												continue;
											}
											if (sheetObjects[15].CellValue(j, "note_conv_mapg_id") == newNoteConvMapgId) {
												sheetObjects[15].RowDelete(j, false);
											}
										}
										for ( var j = sheetObjects[15].LastRow; sheetObjects[15].RowCount > 0 && j >= sheetObjects[15].HeaderRows; j--) {
											if (sheetObjects[15].RowStatus(j) == "D") {
												continue;
											}
											if (sheetObjects[15].CellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
												sheetObjects[15].SelectCell(j, 0);
												var copiedIdx = sheetObjects[15].DataCopy();

												sheetObjects[15].CellValue2(copiedIdx, "note_conv_mapg_id") = newNoteConvMapgId;
												sheetObjects[15].CellValue2(copiedIdx, "amdt_seq") = formObj.amdt_seq.value;
												if (sheetObjects[15].CellValue(copiedIdx, "exp_dt") == formObj.pre_exp_dt.value) {
													sheetObjects[15].CellValue2(copiedIdx, "exp_dt") = formObj.exp_dt.value;
												}
											}
										}
									}
								}
							}
						}
						// 새로 Amend Delete 또는 Delete한다.
						for ( var i = delSheetObj.LastRow; delSheetObj.RowCount > 0 && i >= delSheetObj.HeaderRows; i--) {
							if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
								delSheetObj.SelectRow = i;
								delSheetObj.CellValue2(delSheetObj.SelectRow, "chk") = "0";

								var idx = doRowAmend(delSheetObj, "AD");

								if (a == 2) {
									setSheet3Style(delSheetObj, idx - 1);
									setSheet3Style(delSheetObj, idx);
								}
								// Route Note인 경우, Conversion도 처리.
								if (a == 11) {
									delSheetObj.CellValue2(idx - 1, "note_conv_mapg_id") = delSheetObj.CellValue(idx, "prev_note_conv_mapg_id");
									delSheetObj.RowStatus(idx - 1) = "R";

									for ( var j = sheetObjects[15].LastRow; sheetObjects[15].RowCount > 0 && j >= sheetObjects[15].HeaderRows; j--) {
										if (sheetObjects[15].RowStatus(j) == "D") {
											continue;
										}
										if (sheetObjects[15].CellValue(j, "note_conv_mapg_id") == delSheetObj.CellValue(idx, "note_conv_mapg_id")) {
											sheetObjects[15].RowDelete(j, false);
										}
									}
								}

								// delSheetObj.RowStatus(idx - 1) = "R";
								// delSheetObj.RowStatus(idx) = "R";
							} else if (delSheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
									&& (delSheetObj.CellValue(i, "src_info_cd") == "NW" || delSheetObj.CellValue(i, "src_info_cd") == "GC" || delSheetObj.CellValue(i, "src_info_cd") == "GM"
											|| delSheetObj.CellValue(i, "src_info_cd") == "PC" || delSheetObj.CellValue(i, "src_info_cd") == "PM")) {
								if (a == 11) {
									for ( var j = sheetObjects[15].LastRow; sheetObjects[15].RowCount > 0 && j >= sheetObjects[15].HeaderRows; j--) {
										if (sheetObjects[15].CellValue(j, "note_conv_mapg_id") == delSheetObj.CellValue(i, "note_conv_mapg_id")) {
											sheetObjects[15].RowDelete(j, false);
										}
									}
								}

								// 그냥 Delete해도 관계가 없나?
								delSheetObj.RowDelete(i, false);
							}
						}
					}
				}

				// Sheet2를 Delete 처리
				for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
					if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
						sheetObj.CellValue2(arrCheckedRows[i], "chk") = 0;
						setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
					}
				}
				deleteRowCheck(sheetObj, "chk");

			} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
				for ( var i = arrCheckedRows.length - 1; i >= 0; i--) {
					if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
						sheetObj.SelectRow = arrCheckedRows[i];
						sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";

						var idx = doRowAmend(sheetObj, "AD");
						setSheet3Style(sheetObj, idx - 1);
						setSheet3Style(sheetObj, idx);
					}
				}
				deleteRowCheck(sheetObj, "chk");
			}

			if (sheetObjects[1].SelectRow == -1 || sheetObjects[1].RowHidden(sheetObjects[1].SelectRow)) {
				origin_desc.innerHTML = "";
				ovia_desc.innerHTML = "";
				dvia_desc.innerHTML = "";
				dest_desc.innerHTML = "";
			}
			break;
		case IBSEARCH_ASYNC04:
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			// ///////////////////////
			// MQC Estimate를 저장 했는지 검사후 저장하지 않은 데이터가 있다면 입력 popup을 띄운다.
			// ////////////////////////

			formObj.f_cmd.value = SEARCH02;

			var sPropNo = formObj.prop_no.value;
			var sAmdtSeq = formObj.amdt_seq.value;

			var sParam = "frm_prop_no=" + sPropNo + "&frm_amdt_seq=" + sAmdtSeq + "&f_cmd=" + SEARCH02;

			var sXml = sheetObj.GetSearchXml("ESM_PRI_6091GS.do", sParam);
			var arrData = ComPriXml2Array(sXml, "prop_no");

			// MQC Estimate를 저장 했는지 검사후 저장하지 않은 데이터가 있다면 입력 popup을 띄운다.
			if (arrData != null && arrData != undefined && arrData.length > 0) {
				// if (sheetObjects[2].IsDataModified) {
				if (getRateSheet().IsDataModified) {
					ComShowCodeMessage("PRI00309", "Rate");
					ComOpenWait(false);
					return;
				}
				var pgmNo = "ESM_PRI_6091";
				var pgmUrl = "/hanjin/ESM_PRI_6091.do"

				var sPropNo = formObj.prop_no.value;
				var sAmdtSeq = formObj.amdt_seq.value;
				var sIsReqUsr = formObj.is_req_usr.value;
				var sIsAproUsr = formObj.is_apro_usr.value;
				var prc_prop_sts_cd = formObj.prc_prop_sts_cd.value;

				var tgt_mvc_qty = parent.document.form.tgt_mvc_qty.value;
				var cntr_lod_ut_cd = parent.document.form.cntr_lod_ut_cd.Code;
				var cntr_lod_ut_text = parent.document.form.cntr_lod_ut_cd.Text;

				var fic_rt_tp_cd = funcCheckFicRtTpCdVal();

				var sParam = "frm_prop_no=" + sPropNo + "&frm_amdt_seq=" + sAmdtSeq + "&frm_tgt_mvc_qty=" + tgt_mvc_qty + "&frm_cntr_lod_ut_cd=" + cntr_lod_ut_cd + "&frm_cntr_lod_ut_text="
						+ cntr_lod_ut_text + "&is_req_usr=" + sIsReqUsr + "&is_apro_usr=" + sIsAproUsr + "&prc_prop_sts_cd=" + prc_prop_sts_cd + "&fic_rt_tp_cd=" + fic_rt_tp_cd;

				var rtnVal = ComOpenWindowCenter(pgmUrl + "?" + sParam, pgmNo, 500, 390, true);

				if (rtnVal == "SUCCESS") {
					var obj = document.getElementById("btn_calculate");
					obj.fireEvent("onclick");
				}
			} else {
				formObj.f_cmd.value = SEARCH02;
				var param = FormQueryString(formObj);

				// ComOpenWait(true);
				formObj.f_cmd.value = SEARCH04;
				param = FormQueryString(formObj);
				sXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", param);
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'F') {
					sheetObj.LoadSearchXml(sXml);
				} else {
					ComBtnDisable("btn_calculate");
					ComBtnDisable("btn_mb");
					initBatchJobMonitor();
					calcStatusStr = getScheduleUtilStatusStr("1");
					PRE_STATUS = "1"
					monitoringBatchJob();
				}
				// ComOpenWait(false);
			}
			break;
		case IBSEARCH_ASYNC08: // font type
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.getSearchXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
			setTypeFontStyle(sXml);
			break;

		case IBSEARCH_ASYNC09: // max commodity seq 조회
			formObj.f_cmd.value = SEARCH08;
			var sXml = sheetObj.getSaveXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
			var cmdt_hdr_seq = ComGetEtcData(sXml, "cmdt_hdr_seq");
			if (cmdt_hdr_seq) {
				return cmdt_hdr_seq;
			} else {
				return false;
			}
			break;

		case IBSEARCH_ASYNC10: // change currency
			formObj.f_cmd.value = SEARCH09;
			var sXml = sheetObj.getSaveXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml, "local_fic_gline_rt_amt");
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

function funcSelectedRadio() {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH07;
	var sXml = sheetObjects[0].getSearchXml("ESM_PRI_2003_08GS.do", FormQueryString(formObj));
	var arrDesc = ComPriXml2Array(sXml, "intg_cd_val_ctnt|font_style|tot_cnt");
	var g = false;
	var a = false;

	if (arrDesc != null && arrDesc.length > 0) {
		for ( var i = 0; i < arrDesc.length; i++) {
			if (arrDesc[i][0] == 'G' && arrDesc[i][2] > 0) {
				g = true;
			} else if (arrDesc[i][0] == 'A' && arrDesc[i][2] > 0) {
				a = true;
			}
		}
	}
	// 라이디오 버튼 셀렉트
	if (!g && a) {
		formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[0].value;
		formObj.fic_rt_tp_cd[1].checked = true;
		formObj.fic_rt_tp_cd[1].fireEvent('onclick');
	} else {
		formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[1].value;
		formObj.fic_rt_tp_cd[0].checked = true;
		formObj.fic_rt_tp_cd[0].fireEvent('onclick');
	}
}

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
 * @version 2012.07.10
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC02: // Cancel all
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObjects[0].RowCount <= 0) {
			return false;
		}
		// 승인권자가 아니거나, 상태가 Requested가 아닌 경우.
		if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
			return false;
		}
		// Accept된 항목이 하나도 없을 경우
		if (parseInt(acptCnt) <= 0) {
			ComShowCodeMessage("PRI00330");
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC03: // Guideline Copy
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObjects[0].RowCount > 0) {
			ComShowCodeMessage("PRI01005");
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC11: // Amend
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}
		// 상위의 Route Group이 삭제된 경우.
		if (isRouteGroupDeleted4Rate()) {
			return false;
		}

		// CMDT Group에 수정사항이 있는 경우.
		if (!checkRouteEditable()) {
			ComShowCodeMessage("PRI00309", "Commodity Group");
			return false;
		}

		var checkedCnt = sheetObj.CheckedRows("chk");
		if (checkedCnt > 1) {
			ComShowCodeMessage("PRI00310");
			return false;
		}
		var curRow = -1;
		if (checkedCnt == 1) {
			curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
		} else if (checkedCnt == 0) {
			curRow = sheetObj.SelectRow;
		}

		if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
		if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
			ComShowCodeMessage("PRI01011");
			return false;
		}

		/**
		 * 2012.06.20일 추가 9011648
		 */
		if (sheetObj.id = 'sheet17') {
			var sheetObj2 = sheetObjects[1];
			var sheetObj2_fic_rt_use_sts_cd = sheetObj2.CellValue(sheetObj2.selectRow, "fic_rt_use_sts_cd");
			if (funcChkTypeStatus() != "X" && (sheetObj2_fic_rt_use_sts_cd == "1" || sheetObj2_fic_rt_use_sts_cd == "2" || sheetObj2_fic_rt_use_sts_cd == "3")) {
				ComShowCodeMessage("PRI07019");
				return false;
			}
		}

		return true;
		break;

	case IBSEARCH_ASYNC12: // Amend Cancel
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}
		// 상위의 Route Group이 삭제된 경우.
		if (isRouteGroupDeleted4Rate()) {
			return false;
		}

		// CMDT Group에 수정사항이 있는 경우.
		if (!checkRouteEditable()) {
			ComShowCodeMessage("PRI00309", "Commodity Group");
			return false;
		}

		var checkedCnt = sheetObj.CheckedRows("chk");
		if (checkedCnt > 1) {
			ComShowCodeMessage("PRI00310");
			return false;
		}
		var curRow = -1;
		if (checkedCnt == 1) {
			curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
		} else if (checkedCnt == 0) {
			curRow = sheetObj.SelectRow;
		}

		// Amend된 행이 아닌경우
		if (sheetObj.CellValue(curRow, "src_info_cd") != "AM" && sheetObj.CellValue(curRow, "src_info_cd") != "AD") {
			ComShowCodeMessage("PRI00313");
			return false;
		}
		if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
		if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
			ComShowCodeMessage("PRI01012");
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC13: // Accept
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		// 승인권자나 작성권자가 아니거나, Accept할 수 있는 상태(Requested, Returned)가 아닌 경우.
		if ((!bIsAproUsr && !bIsReqUsr) || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
			return false;
		}

		var sCheckedRows = sheetObj.FindCheckedRow("chk");
		var arrCheckedRows = new Array();
		if (sCheckedRows == "") {
			arrCheckedRows.push(sheetObj.SelectRow);
		} else {
			arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
		}
		for ( var i = 0; i < arrCheckedRows.length; i++) {
			// 이미 Accept된 행인 경우.
			if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
				ComShowCodeMessage("PRI01037");
				return false;
			}
			// 현재 Seq.의 데이터가 아닌 경우 또는 승인권한없는 작성권자가 Returned상태가 아닌 경우에 Accept하려고 한 경우.
			if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value || (bIsReqUsr && !bIsAproUsr && sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "R")) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;

	case IBSEARCH_ASYNC14: // Accept Cancel
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		// 승인권자가 아니거나, Accept할 수 있는 상태(Requested, Returned)가 아닌 경우.
		if (!bIsAproUsr || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
			return false;
		}

		var sCheckedRows = sheetObj.FindCheckedRow("chk");
		var arrCheckedRows = new Array();
		if (sCheckedRows == "") {
			arrCheckedRows.push(sheetObj.SelectRow);
		} else {
			arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
		}
		for ( var i = 0; i < arrCheckedRows.length; i++) {
			// Cancel하려는 행이 Accepted상태가 아닌 경우.
			if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
				ComShowCodeMessage("PRI01038");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;

	case IBSEARCH: // 조회
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		} else {
			return true;
		}
		break;

	case IBSAVE: // 저장
		if (sheetObj.id == "sheet1") {
			if (formObj.prc_prop_sts_cd.value != "I") {
				return false;
			}

			if (!sheetObjects[0].IsDataModified && !sheetObjects[3].IsDataModified && !sheetObjects[4].IsDataModified && !sheetObjects[5].IsDataModified && !sheetObjects[14].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}

			// Route Group쪽에 수정사항이 있는 경우.
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D" && !checkCmdtEditable()) {
				ComShowCodeMessage("PRI00309", "Route Detail");
				return false;
			}

			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[3].IsDataModified && sheetObjects[3].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[4].IsDataModified && sheetObjects[4].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[5].IsDataModified && sheetObjects[5].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[14].IsDataModified && sheetObjects[14].GetSaveString() == "") {
				return false;
			}

		} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
			// RFA의 경우 Initial뿐만 아니라 C/Offer를 위해 Requested나 Returned상태에서도 저장가능.
			if (formObj.prc_prop_sts_cd.value != "I" && formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R") {
				return false;
			}
			// CMDT Group이 삭제된 경우 수정불가
			if (isCMDTGroupDeleted()) {
				return false;
			}

			if (!sheetObjects[1].IsDataModified
			// && !sheetObjects[2].IsDataModified
			&& !getRateSheet().IsDataModified && !sheetObjects[6].IsDataModified && !sheetObjects[7].IsDataModified && !sheetObjects[8].IsDataModified && !sheetObjects[9].IsDataModified
					&& !sheetObjects[11].IsDataModified && !sheetObjects[15].IsDataModified && !sheetObjects2[0].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}

			// CMDT Group에 수정사항이 있는 경우 수정불가
			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}

			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[6].IsDataModified && sheetObjects[6].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[7].IsDataModified && sheetObjects[7].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[8].IsDataModified && sheetObjects[8].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[9].IsDataModified && sheetObjects[9].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[11].IsDataModified && sheetObjects[11].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[15].IsDataModified && sheetObjects[15].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects2[0].IsDataModified && sheetObjects2[0].GetSaveString() == "") {
				return false;
			}

			// Origin, O.Via, D.Via, Dest. 필수입력체크. Route그룹이 삭제된 경우는 체크하지 않음.
			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
					&& getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value) <= 0) {
				ComShowCodeMessage("PRI00316", "Origin");
				return false;
			}
			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") != "-1" && isOViaMandatory
					&& getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value) <= 0) {
				ComShowCodeMessage("PRI00316", "O.Via");
				return false;
			}
			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") != "-1" && isDViaMandatory
					&& getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value) <= 0) {
				ComShowCodeMessage("PRI00316", "D.Via");
				return false;
			}
			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
					&& getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value) <= 0) {
				ComShowCodeMessage("PRI00316", "Dest.");
				return false;
			}

			// Route Group이 삭제되지 않은 경우 해당 Rate가 존재하는 체크.
			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "n1st_cmnc_amdt_seq") != "-1"
					&& getAmendValidRowCount(getRateSheet(), formObj.amdt_seq.value) <= 0) {
				ComShowCodeMessage("PRI01125");
				return false;
			}

			// Rating Unit, Cargo Type 별로 중복이 있는지 체크.
			var dupRow = ComPriAmendDupCheck(sheetObj, "rat_ut_cd|prc_cgo_tp_cd", formObj.amdt_seq.value);
			if (dupRow >= 0) {
				sheetObj.SelectRow = dupRow;
				ComShowCodeMessage("PRI00302");
				return false;
			}

			// Rate값에 0보다 작은 수가 있는지 체크.
			for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
				// 2011.04.20 이행지 [선조치 후CSR] Delete시 0이하의 마이너스 값 체크시 수정가능한 항목들만 체크하도록 변경
				if (sheetObj.CellEditable(i, "prop_frt_rt_amt") == true && sheetObj.RowStatus(i) != "D" && sheetObj.CellValue(i, "prop_frt_rt_amt") <= 0.00) {
					sheetObj.SelectCell(i, "prop_frt_rt_amt", false);
					ComShowCodeMessage("PRI00321", "Rate", "0.00");
					return false;
				}
			}

		}

		return true;
		break;

	case IBDOWNEXCEL: // 엑셀조회
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		} else {
			return true;
		}
		break;

	case IBINSERT: // Row Add
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}

		if (sheetObj.id == "sheet1") {
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D" && !checkCmdtEditable()) {
				ComShowCodeMessage("PRI00309", "Route Detail");
				return false;
			}
		} else if (sheetObj.id == "sheet2") {
			if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
				return false;
			}
			if (isCMDTGroupDeleted()) {
				return false;
			}

			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}
		} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
			if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
				return false;
			}
			if (isRouteGroupDeleted4Rate(true)) {
				return false;
			}

			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}

			if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;

	case IBCOPYROW: // Row Copy
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0 || sheetObj.SelectRow <= 0) {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}

		if (sheetObj.id == "sheet1") {
			if (isCMDTGroupDeleted()) {
				return false;
			}
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D" && !checkCmdtEditable()) {
				ComShowCodeMessage("PRI00309", "Route Detail");
				return false;
			}
		} else if (sheetObj.id == "sheet2") {
			if (isRouteGroupDeleted()) {
				return false;
			}
			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}
		}

		return true;
		break;

	case IBDELETE: // Delete
		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		if (formObj.prc_prop_sts_cd.value != "I") {
			return false;
		}

		if (sheetObj.id == "sheet1") {
			if (isCMDTGroupDeleted()) {
				return false;
			}
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D" && !checkCmdtEditable()) {
				ComShowCodeMessage("PRI00309", "Route Detail");
				return false;
			}
		} else if (sheetObj.id == "sheet2") {
			if (isRouteGroupDeleted()) {
				return false;
			}
			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}
		} else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
			if (isRouteGroupDeleted4Rate(true)) {
				return false;
			}
			if (!checkRouteEditable()) {
				ComShowCodeMessage("PRI00309", "Commodity Group");
				return false;
			}

			var sCheckedRows = sheetObj.FindCheckedRow("chk");
			var arrCheckedRows = new Array();
			if (sCheckedRows == "") {
				arrCheckedRows.push(sheetObj.SelectRow);
			} else {
				arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
			}

			for ( var i = 0; i < arrCheckedRows.length; i++) {
				if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW" && sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
						&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM" && sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
						&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM" && sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
			}
		}

		return true;
		break;
	case IBSEARCH_ASYNC04: // CALCULATE

		// if ( sheetObjects[2].IsDataModified ) {
		if (getRateSheet().IsDataModified) {
			ComShowCodeMessage("PRI00309", "Rate");
			return false;
		}
		return true;
		break;

	}
}

/**
 * CMDT Group의 Bullet No. 유효성 검증.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true : Bullet No.값이 유효할 경우<br>
 *          false : Bullet No.값이 유효하지 않을 경우
 * @author 이은섭
 * @version 2012.07.10
 */
function validateBulletNo(sheetObj, formObj, sAction) {
	// Bullet No. 중복여부 검사.
	var rowDup = sheetObj.ColValueDup("blet_dp_seq", false);
	if (rowDup >= 0) {
		ComShowCodeMessage("PRI00332", "Bullet No.");
		return false;
	}

	// Bullet No.의 사용가능한 시작 번호 및 연속성 점검을 위한 준비작업.
	// 삭제된 행이나 이번 시퀀스에 추가된 CMDT Group이 아닌 것들은 제외하고,
	// CMDT Group의 모든 row별로, 사용자가 입력한 Bullet No.에서 DB에서 가져온 Max Bullet No.를 뺀 값인 dpSeq를 Array의 [dpSeq]번째 요소로 담으면,
	// 그 Array는 0번째 요소부터 Array.length - 1 번째 요소까지 연속된 정수를 가지게 된다.(오류없이 입력된 경우)
	// 그렇지 않은 경우 Validation Error를 return한다.
	var arrChk = new Array();
	for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		if (sheetObj.RowStatus(i) == "D") {
			continue;
		}
		if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
			continue;
		}
		if (parseInt(sheetObj.CellValue(i, "blet_dp_seq")) == 0) {
			ComShowCodeMessage("PRI01048", "Bullet No.", parseInt(sheetObj.EtcData("max_blet_dp_seq")) + 1);
			return false;
		}

		var dpSeq = parseInt(sheetObj.CellValue(i, "blet_dp_seq")) - parseInt(sheetObj.EtcData("max_blet_dp_seq")) - 1;
		arrChk[dpSeq] = dpSeq;
	}
	// Array에 담긴 값이 없거나, Array의 0번째 요소가 0이 아닌 경우.(Bullet No.가 Max Bullet No. 부터 연속되지 않았다는...)
	if (arrChk.length > 0 && arrChk[0] != 0) {
		ComShowCodeMessage("PRI01048", "Bullet No.", parseInt(sheetObj.EtcData("max_blet_dp_seq")) + 1);
		return false;
	}
	// Array의 값이 연속된 값인지(입력한 Bullet No.가 연속된 값인지)를 확인.
	for ( var i = 0; i < arrChk.length; i++) {
		if (arrChk[i] == null || arrChk[i] == undefined || arrChk[i] != i) {
			ComShowCodeMessage("PRI01049", "Bullet No.");
			return false;
		}
	}
	return true;
}

/**
 * CMDT Group Sheet들이 수정가능한지, 즉 Route Group 쪽에 수정사항이 있는지를 반환
 * 
 * @returns bool <br>
 *          true : 수정가능. Route Group에 수정사항 없음.<br>
 *          false : 수정불가. Route Group에 수정사항 있음.
 * @author 이은섭
 * @version 2012.07.10
 */
function checkCmdtEditable() {
	if (sheetObjects[1].IsDataModified
	// || sheetObjects[2].IsDataModified
	|| getRateSheet().IsDataModified || sheetObjects[6].IsDataModified || sheetObjects[7].IsDataModified || sheetObjects[8].IsDataModified || sheetObjects[9].IsDataModified
			|| sheetObjects[11].IsDataModified || sheetObjects[15].IsDataModified) {
		return false;
	}
	return true;
}

/**
 * Route Group Sheet들이 수정가능한지, 즉 CMDT Group 쪽에 수정사항이 있는지를 반환
 * 
 * @returns bool <br>
 *          true : 수정가능. CMDT Group에 수정사항 없음.<br>
 *          false : 수정불가. CMDT Group에 수정사항 있음.
 * @author 이은섭
 * @version 2012.07.10
 */
function checkRouteEditable() {
	if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified || sheetObjects[4].IsDataModified || sheetObjects[5].IsDataModified || sheetObjects[14].IsDataModified) {
		return false;
	}
	return true;
}

/**
 * 재조회 후, 기존 선택된 행을 찾아가기 위해 현재 Row위치를 전역변수에 저장. reloadPagePostTr 함수와 같이 사용.
 * 
 * @returns 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function saveCurRowPos() {
	s1PrevRow = sheetObjects[0].SelectRow;
	s2PrevRow = sheetObjects[1].SelectRow;
	// s3PrevRow = sheetObjects[2].SelectRow;
	s3PrevRow = getRateSheet().SelectRow;
	s1PrevKey = sheetObjects[0].CellValue(s1PrevRow, "cmdt_hdr_seq");
	s2PrevKey = sheetObjects[1].CellValue(s2PrevRow, "rout_seq");
	// s3PrevKey = sheetObjects[2].CellValue(s3PrevRow, "rt_seq");
	s3PrevKey = getRateSheet().CellValue(s3PrevRow, "rt_seq");
}

/**
 * 타입 폰트 스타일 변경
 */
function comUpdateTypeFontStyle() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC08);
}

/**
 * 재조회. saveCurRowPos를 미리 호출하고 사용해야 기존 선택된 행을 찾아간다.
 * 
 * @param {int} sheetNo 선택 0:CMDT부터 1:Route부터 재조회. Default는 0.
 * @returns 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function reloadPagePostTr(sheetNo) {
	if (sheetNo == null || sheetNo == "" || sheetNo < 0) {
		sheetNo = 0;
	}

	// 수정이 있음을 Main에 Notify.
	updateSummary();
	// Type 폰트 스타일
	comUpdateTypeFontStyle();

	// 하위그리드들이 이벤트를 타고 재조회 되는걸 막기위해 이벤트 플래그를 off한다.
	isFiredNested = true;
	isFiredNestedExt = true;

	if (sheetNo == 0) {
		// Sheet1 재조회.
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		if (sheetObjects[0].RowCount > 0) {
			// 미리 저장된 Sheet1의 선택된 Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
			if (s1PrevRow > sheetObjects[0].LastRow) {
				s1PrevRow = sheetObjects[0].LastRow;
			} else if (s1PrevRow <= 0) {
				s1PrevRow = 1;
			}
			// 미리 저장된 Row로 강제 이동한다.
			sheetObjects[0].SelectRow = s1PrevRow;
			sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, false);
		} else {
			isFiredNested = false;
			isFiredNestedExt = false;
			return;
		}
	}

	// Sheet1의 이벤트를 다시 On.
	isFiredNested = false;

	// Sheet1 OnSelectCell 이벤트 처리자를 호출하여, Sheet2를 조회.
	doRowChange1(-1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, IBSEARCH);
	if (sheetObjects[1].RowCount > 0) {
		// 미리 저장된 Sheet2의 선택된 Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
		if (s2PrevRow > sheetObjects[1].LastRow) {
			s2PrevRow = sheetObjects[1].LastRow;
		} else if (s2PrevRow <= 0) {
			s2PrevRow = 1;
		}
		// 미리 저장된 Row로 강제 이동한다.
		sheetObjects[1].SelectRow = s2PrevRow;
		sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, false);
	} else {
		isFiredNestedExt = false;
		return;
	}

	// Sheet2의 이벤트를 다시 On.
	isFiredNestedExt = false;

	// Sheet2 OnSelectCell 이벤트 처리자를 호출하여, Sheet3를 조회.
	doRowChange2(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);

	// if (sheetObjects[2].RowCount > 0) {
	// // 미리 저장된 Sheet3의 선택된 Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
	// if (s3PrevRow > sheetObjects[2].LastRow) {
	// s3PrevRow = sheetObjects[2].LastRow;
	// } else if (s3PrevRow <= 0) {
	// s3PrevRow = 1;
	// }
	// // 미리 저장된 Row로 강제 이동한다.
	// sheetObjects[2].SelectRow = s3PrevRow;
	// sheetObjects[2].SelectCell(sheetObjects[2].SelectRow, sheetObjects[2].SelectCol, false);
	// } else {
	// return;
	// }

	if (getRateSheet().RowCount > 0) {
		// 미리 저장된 Sheet3의 선택된 Row가 FirstRow와 LastRow를 벗어나지 않도록 조정.
		if (s3PrevRow > getRateSheet().LastRow) {
			s3PrevRow = getRateSheet().LastRow;
		} else if (s3PrevRow <= 0) {
			s3PrevRow = 1;
		}
		// 미리 저장된 Row로 강제 이동한다.
		getRateSheet().SelectRow = s3PrevRow;
		getRateSheet().SelectCell(getRateSheet().SelectRow, getRateSheet().SelectCol, false);
	} else {
		return;
	}
}

/**
 * 재조회가 없는 CUD후, CMDT & Route Group의 폰트색상 및 취소선표시 등을 처리.
 * 
 * @param {boolean} reloadAll 선택 CMDT Group그리도 전체 행에 대해 처리할지 여부. Default는 false.
 * @returns 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function restylingPagePostTr(reloadAll) {
	var formObj = document.form;
	updateSummary();
	// Type 폰트 스타일
	comUpdateTypeFontStyle();

	if (formObj.amdt_seq.value == "0") {
		return true;
	}

	var cmdtCurRow = sheetObjects[0].SelectRow;
	var routCurRow = sheetObjects[1].SelectRow;

	sheetObjects[sheetObjects.length - 1].WaitImageVisible = false;

	formObj.f_cmd.value = SEARCH15;
	var param = FormQueryString(formObj);
	if (reloadAll) { // CMDT전체에 대해 조회.
		param += "&reload_all=Y";
	} else { // 현재 선택된 row만 조회.
		param += "&reload_all=N";
	}
	var sXml = sheetObjects[sheetObjects.length - 1].GetSearchXml("ESM_PRI_2003_07GS.do", param);
	// arrXml의 0번째 요소 : CMDT Group XML, 1번째 요소 : Route Group XML
	var arrXml = sXml.split("|$$|");

	// CMDT Group 그리드에 대해 스타일 적용
	if (arrXml.length > 0) {
		// nd_cnt : 삭제되지 않은 하위항목 수
		// na_cnt : Accept되지 않은 하위항목 수
		// cmdt_hdr_seq
		// up_cnt : 수정(Amend)한 하위항목 수
		var arrTemp = ComPriXml2Array(arrXml[0], "nd_cnt|na_cnt|cmdt_hdr_seq|up_cnt");

		if (arrTemp != null && arrTemp.length > 0) {
			for ( var i = 0; i < arrTemp.length; i++) {
				var ndCnt = parseInt(arrTemp[i][0]);
				var naCnt = parseInt(arrTemp[i][1]);
				var upCnt = parseInt(arrTemp[i][3]);
				cmdtCurRow = sheetObjects[0].FindText("cmdt_hdr_seq", arrTemp[i][2]);
				if (cmdtCurRow < 0) {
					continue;
				}

				// 하위항목이 모두 삭제된 경우 취소선 처리.
				if (ndCnt == 0) {
					sheetObjects[0].CellFont("FontStrikethru", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol) = true;
				} else {
					sheetObjects[0].CellFont("FontStrikethru", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol) = false;
				}

				// Accept되지 않는 하위항목이 존재하는 경우 font-color = red
				if (naCnt == 0) {
					if (upCnt == 0) {
						sheetObjects[0].RowFontColor(cmdtCurRow) = sheetObjects[0].RgbColor(0, 0, 0);
					} else {
						sheetObjects[0].RowFontColor(cmdtCurRow) = sheetObjects[0].RgbColor(0, 0, 255);
					}
				} else {
					sheetObjects[0].RowFontColor(cmdtCurRow) = sheetObjects[0].RgbColor(255, 0, 0);
				}
			}
		}
	}

	// 기존 선택된 row와 현재 선택된 row가 다를 경우 Sheet2 재조회.
	if (s1PrevKey != sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq")) {
		doRowChange1(-1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, IBSEARCH);
	} else {
		// Route Group 그리드에 대해 스타일 적용
		if (arrXml.length > 1) {
			var arrTemp = ComPriXml2Array(arrXml[1], "nd_cnt|na_cnt|up_cnt");

			if (arrTemp != null && arrTemp.length > 0) {
				var ndCnt = parseInt(arrTemp[0][0]);
				var naCnt = parseInt(arrTemp[0][1]);
				var upCnt = parseInt(arrTemp[0][2]);

				// 하위항목이 모두 삭제된 경우 취소선 처리.
				if (ndCnt == 0) {
					sheetObjects[1].CellFont("FontStrikethru", routCurRow, 1, routCurRow, sheetObjects[1].LastCol) = true;
				} else {
					sheetObjects[1].CellFont("FontStrikethru", routCurRow, 1, routCurRow, sheetObjects[1].LastCol) = false;
				}

				// Accept되지 않는 하위항목이 존재하는 경우 font-color = red
				if (naCnt == 0) {
					// 하위에 수정된 항목이 존재하고, 그 항목들이 모두 Accept되었을 경우, font-color : blue
					if (upCnt == 0) {
						sheetObjects[1].RowFontColor(routCurRow) = sheetObjects[1].RgbColor(0, 0, 0);
					} else {
						sheetObjects[1].RowFontColor(routCurRow) = sheetObjects[1].RgbColor(0, 0, 255);
					}
				} else {
					sheetObjects[1].RowFontColor(routCurRow) = sheetObjects[1].RgbColor(255, 0, 0);
				}
			}
		}

		// 기존 선택된 row와 현재 선택된 row가 다를 경우 Sheet3 재조회.
		if (s2PrevKey != sheetObjects[1].CellValue(routCurRow, "rout_seq")) {
			doRowChange2(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);
		}
	}

	sheetObjects[sheetObjects.length - 1].WaitImageVisible = true;
	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
	changeSelectBackColor4Rate(sheetObjects[0]);
	changeSelectBackColor4Rate(sheetObjects[1]);
}

/**
 * 주어진 Seq.에 해당하는 행으로 찾아간다. Accept All, Check Duplicate등의 화면에서 항목 더블클릭 하면 이동.
 * 
 * @param {int} cmdtHdrSeq 선택 CMDT_HDR_SEQ. Default는 1.
 * @param {int} routeSeq 선택 ROUT_HDR_SEQ. Default는 1.
 * @param {int} rtSeq 선택 RT_SEQ. Default는 1.
 * @returns 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function moveRowPosTo(cmdtHdrSeq, routeSeq, rtSeq) {
	if (cmdtHdrSeq != null && cmdtHdrSeq != "" && cmdtHdrSeq != undefined) {
		s1PrevRow = sheetObjects[0].FindText("cmdt_hdr_seq", cmdtHdrSeq);
		s2PrevRow = 1;
	} else {
		s1PrevRow = 1;
		s2PrevRow = 1;
	}
	sheetObjects[0].SelectRow = s1PrevRow;
	sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, false);
	doRowChange1(-1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, IBSEARCH);

	if (routeSeq != null && routeSeq != "" && routeSeq != undefined) {
		s2PrevRow = sheetObjects[1].FindText("rout_seq", routeSeq);
	} else {
		s2PrevRow = 1;
	}
	sheetObjects[1].SelectRow = s2PrevRow;
	sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, false);
	doRowChange2(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);

	if (rtSeq != null && rtSeq != "" && rtSeq != undefined) {
		// s3PrevRow = sheetObjects[2].FindText("rt_seq", rtSeq);
		s3PrevRow = getRateSheet().FindText("rt_seq", rtSeq);
	} else {
		s3PrevRow = 1;
	}
	// sheetObjects[2].SelectRow = s3PrevRow;
	// sheetObjects[2].SelectCell(sheetObjects[2].SelectRow, sheetObjects[2].SelectCol, false);
	getRateSheet().SelectRow = s3PrevRow;
	getRateSheet().SelectCell(getRateSheet().SelectRow, getRateSheet().SelectCol, false);

}

/**
 * 선택된 PRSCostLevel 코드를 반환.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function getRdoPRSCostLevel() {
	for ( var i = 0; i < document.form.rdoPRSCostLevel.length; i++) {
		if (document.form.rdoPRSCostLevel[i].checked) {
			return document.form.rdoPRSCostLevel[i].value;
		}
	}
}

/**
 * Max + 1 Bullet No.를 반환
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function getNextBletDpSeq() {
	return Math.max(parseInt(ComPriGetMax(sheetObjects[0], "blet_dp_seq")), parseInt(sheetObjects[0].EtcData("max_blet_dp_seq"))) + 1;
}

/**
 * 선택된 Row에 대해 Amend or Amend Delete 실행. 팝업화면에서도 이 함수를 호출하여 사용한다.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function doRowAmend(sheetObj, sAction) {
	var idx = sheetObj.DataCopy();
	var prevIdx = idx - 1;

	sheetObj.CellValue2(idx, "eff_dt") = document.form.eff_dt.value;
	sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = document.form.amdt_seq.value;
	sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
	sheetObj.CellValue2(idx, "prc_prog_sts_nm") = "Initial";
	sheetObj.CellValue2(idx, "src_info_cd") = sAction;
	if (sAction == "AM") {
		sheetObj.CellValue2(idx, "src_info_nm") = "Amend";
	} else if (sAction == "AD") {
		sheetObj.CellValue2(idx, "src_info_nm") = "Delete";
	}

	if (document.form.dur_dup_flg.value == "Y") {
		sheetObj.CellValue2(prevIdx, "exp_dt") = document.form.pre_exp_dt.value;
	}
	sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.pre_amdt_seq.value;

	sheetObj.RowStatus(prevIdx) = "R";
	sheetObj.RowStatus(idx) = "U";

	return idx;
}

/**
 * 선택된 Row에 대해 Amend Cancel 실행. 팝업화면에서도 이 함수를 호출하여 사용한다.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function doRowAmendCancel(sheetObj) {
	var idx = sheetObj.SelectRow;
	var prevIdx = idx - 1;

	if (sheetObj.CellValue(idx, "ibflag") != "I") {
		if (document.form.dur_dup_flg.value == "Y") {
			sheetObj.CellValue2(prevIdx, "exp_dt") = document.form.exp_dt.value;
		}
		sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value;
		// 이 부분은 Amend와 Amend Cancel을 반복할 경우, 저장이 안되는 경우를 위한 코드.
		// 이는 IBSheet에서 Amend Cancel시 다시 원복된 값이 조회당시 값과 같다고 인식해서 row의 status를 R로 인식하는 문제.
		if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
			sheetObj.RowStatus(prevIdx) = "U";
		}
	}
	sheetObj.RowDelete(idx, false);

	return prevIdx;
}

/**
 * 특정 row, 또는 Sheet전체에 대해 setLineStyle, setLineEnable함수를 호출하여 라인의 스타일(폰트색상, 취소선 등)을 만들어준다. setLineStyle은 메인화면의 함수를 팝업들이 공통적으로 같이 이용하며, setLineEnable은 각 화면이나 팝업별로 따로 구현되어
 * 있다.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function setSheet3Style(sheetObj, idx) {
	if (idx == null || idx < 0) {
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			setLineStyle(sheetObj, i);
			setLineEnable(sheetObj, i);
		}
	} else {
		setLineStyle(sheetObj, idx);
		setLineEnable(sheetObj, idx);
	}
}

/**
 * CMDT & Route Group 데이터가 삭제된 경우 삭제표시를 한다.(Amend Seq. 1 이상인 경우에만) n1st_cmnc_amdt_seq를 -1로 박아주는 것은 서버에서 그룹단위로 삭제됨을 인식하여 처리하기 위함.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function setHdrLineDeleted(sheetObj, idx) {
	sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = "-1";
	sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
	sheetObj.RowFontColor(idx) = sheetObj.RgbColor(255, 0, 0);
}

/**
 * 주어진 로우에 대해 스타일(색상, 취소선 등)을 적용한다.
 * 
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function setLineStyle(sheetObj, idx) {
	if (idx <= 0) {
		return false;
	}

	if (sheetObj.RowStatus(idx) == "D") {
		sheetObj.RowHidden(idx) = true;
	}

	// Sheet3(Rate)일 경우, diff값이 음수인 경우, font-color를 red로 변경한다.(PRS요청)
	if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
		if (sheetObj.CellValue(idx, "diff") < 0) {
			sheetObj.CellFontColor(idx, "diff") = sheetObj.RgbColor(255, 0, 0);
		}
	}

	// Proposal단계 일 경우 색상처리를 하지 않는다.
	if (document.form.amdt_seq.value == "0") {
		return true;
	}

	// 이전Seq의 데이터는 Amend된 데이터로 간주하고, 취소선을 긋고, Row를 수정불가로 한다.
	// 다만 RFA는 RowEditable메쏘드를 이용해 전체 Row를 Uneditable로 처리하고,
	// S/C의 경우는 Note쪽에서 Conversion화면을 띠워야 하므로 루프를 돌면서 컬럼단위로 Uneditable 처리한다.
	if (sheetObj.CellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
		sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
		sheetObj.RowEditable(idx) = false;

		return true;
	} else {
		sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
		sheetObj.RowEditable(idx) = true;
	}

	// 이번 회차의 데이타(Insert or Amend)는 font-color를 red로 표시.
	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255, 0, 0);
	} else {
		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0, 0, 0);
	}

	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
	changeSelectBackColor4Rate(sheetObj);
}

/**
 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리. 이 함수는 Sheet3(Rate)를 위한 것이고, 각 팝업마다 같은 이름의 함수들이 각 sheet에 맞게 정의되어 있다.
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
 * @author 이은섭
 * @version 2012.07.10
 */
function setLineEnable(sheetObj, idx) {
	if (idx <= 0) {
		return false;
	}

	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value && document.form.prc_prop_sts_cd.value == "I" && sheetObj.CellValue(idx, "src_info_cd") != "AD") {
		sheetObj.CellEditable(idx, "rat_ut_cd") = true;
		sheetObj.CellEditable(idx, "prc_cgo_tp_cd") = true;
		sheetObj.CellEditable(idx, "curr_cd") = true;
		sheetObj.CellEditable(idx, "prop_frt_rt_amt") = true;
		sheetObj.CellEditable(idx, "fic_prop_rt_amt") = true;
	} else {
		sheetObj.CellEditable(idx, "rat_ut_cd") = false;
		sheetObj.CellEditable(idx, "prc_cgo_tp_cd") = false;
		sheetObj.CellEditable(idx, "curr_cd") = false;
		if ((bIsReqUsr) && document.form.prc_prop_sts_cd.value == "R" && sheetObj.CellValue(idx, "prc_prog_sts_cd") == "R") {
			sheetObj.CellEditable(idx, "prop_frt_rt_amt") = true;
			sheetObj.CellEditable(idx, "fic_prop_rt_amt") = true;
		} else {
			sheetObj.CellEditable(idx, "prop_frt_rt_amt") = false;
			sheetObj.CellEditable(idx, "fic_prop_rt_amt") = false;
		}
	}

	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q" && sheetObj.CellValue(idx, "prc_prog_sts_cd") != "A") {
		sheetObj.CellEditable(idx, "coffr_frt_rt_amt") = true;
		sheetObj.CellEditable(idx, "fic_coffr_rt_amt") = true;
	} else {
		sheetObj.CellEditable(idx, "coffr_frt_rt_amt") = false;
		sheetObj.CellEditable(idx, "fic_coffr_rt_amt") = false;
	}

	sheetObj.MinimumValue(idx, "prop_frt_rt_amt") = 0.00;
	sheetObj.MinimumValue(idx, "coffr_frt_rt_amt") = 0.00;
}

/**
 * Note Tooltip의 내용을 세팅한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} idx 필수 해당 셀의 Row Index
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function setNoteTooltip(sheetObj, idx) {
	sheetObj.ToolTipText(idx, "note_ctnt") = sheetObj.CellValue(idx, "note_ctnt_tooltip");
}

/**
 * Sheet Data를 XML형태로 변환하여 넘겨준다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {int} sheetNo sheet번호
 * @author 이은섭
 * @version 2012.07.10
 */
function getSheetXml(sheetNo) {
	var formObj = document.form;
	var sXml = "";
	var sCol = "";
	var sValue = "";

	if (sheetNo == 3 || sheetNo == 4) {
		sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
		sValue = formObj.prop_no.value + "|" + formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
	}
	sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
	return sXml;
}

/**
 * XML형태의 데이타를 Sheet에 Load한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {int} sheetNo sheet번호
 * @author 이은섭
 * @version 2012.07.10
 */
function setSheetXml(sXml, sheetNo) {
	var formObj = document.form;
	var sCol = "";
	var sValue = "";
	var bAppendMode = 0;

	if (sheetNo == 3 || sheetNo == 4) {
		bAppendMode = 1;
		sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
		sValue = formObj.prop_no.value + "|" + formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
	}

	ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
}

function updateSummary() {
	var termTpCd = TERMS_TYPE_CODE_GEN;

	var rtn = null;
	try {
		rtn = parent.comUpdateProposalStatusSummary(termTpCd, document.form.svc_scp_cd.value);
	} catch (e) {
	}

	return rtn;
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
 * @version 2012.07.10
 */
function toggleButtons(mode) {
	switch (mode) {
	case "CLEAR":
		ComBtnDisable("btn_retrieve");
		ComBtnDisable("btn_acceptall");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_glcopy");
		ComBtnDisable("btn_gricalc");
		ComBtnDisable("btn_checkduplicate");
		ComBtnDisable("btn_downexcel");
		ComBtnDisable("btn_loadexcel");

		ComBtnDisable("btn_rowadd1");
		ComBtnDisable("btn_rowadd2");
		ComBtnDisable("btn_rowadd3");
		ComBtnDisable("btn_rowcopy1");
		ComBtnDisable("btn_rowcopy2");
		ComBtnDisable("btn_delete1");
		ComBtnDisable("btn_delete2");
		ComBtnDisable("btn_delete3");
		ComBtnDisable("btn_save1");
		ComBtnDisable("btn_save2");
		ComBtnDisable("btn_save3");
		ComBtnDisable("btn_amend3");
		ComBtnDisable("btn_amendcancel3");
		ComBtnDisable("btn_accept3");
		ComBtnDisable("btn_acceptcancel3");
		ComBtnDisable("btn_specification");

        ComBtnDisable("btn_mb");
		ComBtnDisable("btn_calculate");
		ComBtnDisable("btn_schgdetail");
		ComBtnDisable("btn_schgviewall");
		ComBtnDisable("btn_schgadjust");
		ComBtnDisable("btn_costdetail");
		ComBtnDisable("btn_costbytransmode");
		ComBtnDisable("btn_cmpbviewall");
		ComBtnDisable("btn_cmviewall");

		// sheetObjects[2].ColHidden("prs_scg_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_cm_uc_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_opfit_uc_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_cmpb_amt") = true;
		// sheetObjects[2].ColHidden("prs_gid_cmpb_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_opb_amt") = true;
		// sheetObjects[2].ColHidden("diff") = true;

		getRateSheet().ColHidden("prs_scg_amt") = true;
		getRateSheet().ColHidden("prs_respb_cm_uc_amt") = true;
		getRateSheet().ColHidden("prs_respb_opfit_uc_amt") = true;
		getRateSheet().ColHidden("prs_respb_cmpb_amt") = true;
		getRateSheet().ColHidden("prs_gid_cmpb_amt") = true;
		getRateSheet().ColHidden("prs_respb_opb_amt") = true;
		getRateSheet().ColHidden("diff") = true;

		sheetObjects[12].ColHidden("buc_usd_amt") = true;
		sheetObjects[12].ColHidden("ifc_usd_amt") = true;
		sheetObjects[12].ColHidden("psc_usd_amt") = true;

		sheetObjects[13].ColHidden("buc_dry20") = true;
		sheetObjects[13].ColHidden("buc_dry40") = true;
		sheetObjects[13].ColHidden("buc_dry40hc") = true;
		sheetObjects[13].ColHidden("buc_dry45") = true;
		sheetObjects[13].ColHidden("buc_rf40hc") = true;
		sheetObjects[13].ColHidden("buc_rd40hc") = true;
		sheetObjects[13].ColHidden("ifc_dry20") = true;
		sheetObjects[13].ColHidden("ifc_dry40") = true;
		sheetObjects[13].ColHidden("ifc_dry40hc") = true;
		sheetObjects[13].ColHidden("ifc_dry45") = true;
		sheetObjects[13].ColHidden("ifc_rf40hc") = true;
		sheetObjects[13].ColHidden("ifc_rd40hc") = true;
		sheetObjects[13].ColHidden("psc_dry20") = true;
		sheetObjects[13].ColHidden("psc_dry40") = true;
		sheetObjects[13].ColHidden("psc_dry40hc") = true;
		sheetObjects[13].ColHidden("psc_dry45") = true;
		sheetObjects[13].ColHidden("psc_rf40hc") = true;
		sheetObjects[13].ColHidden("psc_rd40hc") = true;
		break;
	case "INIT":
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_downexcel");
		if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
			if (sheetObjects[0].RowCount <= 0) {
				ComBtnEnable("btn_glcopy");
			} else {
				ComBtnDisable("btn_glcopy");
			}
			ComBtnEnable("btn_checkduplicate");
			ComBtnEnable("btn_gricalc");
			ComBtnEnable("btn_loadexcel");
		} else {
			ComBtnDisable("btn_checkduplicate");
			ComBtnDisable("btn_glcopy");
			ComBtnDisable("btn_gricalc");
			ComBtnDisable("btn_loadexcel");
		}

		if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
			ComBtnEnable("btn_acceptall");
			ComBtnEnable("btn_cancel");
		} else {
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancel");
		}

		if (bIsReqUsr || bIsAproUsr) {
			// sheetObjects[2].ColHidden("prs_scg_amt") = false;
			// sheetObjects[2].ColHidden("prs_respb_cm_uc_amt") = false;
			// sheetObjects[2].ColHidden("prs_respb_opfit_uc_amt") = false;
			// sheetObjects[2].ColHidden("prs_respb_cmpb_amt") = false;
			// sheetObjects[2].ColHidden("prs_gid_cmpb_amt") = false;
			// sheetObjects[2].ColHidden("prs_respb_opb_amt") = false;
			// sheetObjects[2].ColHidden("diff") = false;

			getRateSheet().ColHidden("prs_scg_amt") = false;
			getRateSheet().ColHidden("prs_respb_cm_uc_amt") = false;
			getRateSheet().ColHidden("prs_respb_opfit_uc_amt") = false;
			getRateSheet().ColHidden("prs_respb_cmpb_amt") = false;
			getRateSheet().ColHidden("prs_gid_cmpb_amt") = false;
			getRateSheet().ColHidden("prs_respb_opb_amt") = false;
			getRateSheet().ColHidden("diff") = false;

			sheetObjects[12].ColHidden("buc_usd_amt") = false;
			sheetObjects[12].ColHidden("ifc_usd_amt") = false;
			sheetObjects[12].ColHidden("psc_usd_amt") = false;

			sheetObjects[13].ColHidden("buc_dry20") = false;
			sheetObjects[13].ColHidden("buc_dry40") = false;
			sheetObjects[13].ColHidden("buc_dry40hc") = false;
			sheetObjects[13].ColHidden("buc_dry45") = false;
			sheetObjects[13].ColHidden("buc_rf40hc") = false;
			sheetObjects[13].ColHidden("buc_rd40hc") = false;
			sheetObjects[13].ColHidden("ifc_dry20") = false;
			sheetObjects[13].ColHidden("ifc_dry40") = false;
			sheetObjects[13].ColHidden("ifc_dry40hc") = false;
			sheetObjects[13].ColHidden("ifc_dry45") = false;
			sheetObjects[13].ColHidden("ifc_rf40hc") = false;
			sheetObjects[13].ColHidden("ifc_rd40hc") = false;
			sheetObjects[13].ColHidden("psc_dry20") = false;
			sheetObjects[13].ColHidden("psc_dry40") = false;
			sheetObjects[13].ColHidden("psc_dry40hc") = false;
			sheetObjects[13].ColHidden("psc_dry45") = false;
			sheetObjects[13].ColHidden("psc_rf40hc") = false;
			sheetObjects[13].ColHidden("psc_rd40hc") = false;
		} else {
			// sheetObjects[2].ColHidden("prs_scg_amt") = true;
			// sheetObjects[2].ColHidden("prs_respb_cm_uc_amt") = true;
			// sheetObjects[2].ColHidden("prs_respb_opfit_uc_amt") = true;
			// sheetObjects[2].ColHidden("prs_respb_cmpb_amt") = true;
			// sheetObjects[2].ColHidden("prs_gid_cmpb_amt") = true;
			// sheetObjects[2].ColHidden("prs_respb_opb_amt") = true;
			// sheetObjects[2].ColHidden("diff") = true;

			getRateSheet().ColHidden("prs_scg_amt") = true;
			getRateSheet().ColHidden("prs_respb_cm_uc_amt") = true;
			getRateSheet().ColHidden("prs_respb_opfit_uc_amt") = true;
			getRateSheet().ColHidden("prs_respb_cmpb_amt") = true;
			getRateSheet().ColHidden("prs_gid_cmpb_amt") = true;
			getRateSheet().ColHidden("prs_respb_opb_amt") = true;
			getRateSheet().ColHidden("diff") = true;

			sheetObjects[12].ColHidden("buc_usd_amt") = true;
			sheetObjects[12].ColHidden("ifc_usd_amt") = true;
			sheetObjects[12].ColHidden("psc_usd_amt") = true;

			sheetObjects[13].ColHidden("buc_dry20") = true;
			sheetObjects[13].ColHidden("buc_dry40") = true;
			sheetObjects[13].ColHidden("buc_dry40hc") = true;
			sheetObjects[13].ColHidden("buc_dry45") = true;
			sheetObjects[13].ColHidden("buc_rf40hc") = true;
			sheetObjects[13].ColHidden("buc_rd40hc") = true;
			sheetObjects[13].ColHidden("ifc_dry20") = true;
			sheetObjects[13].ColHidden("ifc_dry40") = true;
			sheetObjects[13].ColHidden("ifc_dry40hc") = true;
			sheetObjects[13].ColHidden("ifc_dry45") = true;
			sheetObjects[13].ColHidden("ifc_rf40hc") = true;
			sheetObjects[13].ColHidden("ifc_rd40hc") = true;
			sheetObjects[13].ColHidden("psc_dry20") = true;
			sheetObjects[13].ColHidden("psc_dry40") = true;
			sheetObjects[13].ColHidden("psc_dry40hc") = true;
			sheetObjects[13].ColHidden("psc_dry45") = true;
			sheetObjects[13].ColHidden("psc_rf40hc") = true;
			sheetObjects[13].ColHidden("psc_rd40hc") = true;
		}

		ComBtnDisable("btn_rowadd1");
		ComBtnDisable("btn_rowadd2");
		ComBtnDisable("btn_rowadd3");
		ComBtnDisable("btn_rowcopy1");
		ComBtnDisable("btn_rowcopy2");
		ComBtnDisable("btn_delete1");
		ComBtnDisable("btn_delete2");
		ComBtnDisable("btn_delete3");
		ComBtnDisable("btn_save1");
		ComBtnDisable("btn_save2");
		ComBtnDisable("btn_save3");
		ComBtnDisable("btn_amend3");
		ComBtnDisable("btn_amendcancel3");
		ComBtnDisable("btn_accept3");
		ComBtnDisable("btn_acceptcancel3");
		ComBtnEnable("btn_specification");

		ComBtnDisable("btn_mb");
		ComBtnDisable("btn_calculate");
		ComBtnDisable("btn_schgdetail");
		ComBtnDisable("btn_schgviewall");
		ComBtnDisable("btn_schgadjust");
		ComBtnDisable("btn_costdetail");
		ComBtnDisable("btn_costbytransmode");
		ComBtnDisable("btn_cmpbviewall");
		ComBtnDisable("btn_cmviewall");

		// Grid Button Setting
		if (document.form.prc_prop_sts_cd.value == "I") {
			if (bIsReqUsr || bIsAproUsr) {
				ComBtnEnable("btn_rowadd1");
				ComBtnEnable("btn_rowadd2");
				ComBtnEnable("btn_rowadd3");
				ComBtnEnable("btn_rowcopy1");
				ComBtnEnable("btn_rowcopy2");
				ComBtnEnable("btn_delete1");
				ComBtnEnable("btn_delete2");
				ComBtnEnable("btn_delete3");
				ComBtnEnable("btn_save1");
				ComBtnEnable("btn_save2");
				ComBtnEnable("btn_save3");
				ComBtnEnable("btn_amend3");
				ComBtnEnable("btn_amendcancel3");

				ComBtnEnable("btn_calculate");
				checkMatchBackEnable();
				ComBtnEnable("btn_schgdetail");
				ComBtnEnable("btn_schgviewall");
				ComBtnEnable("btn_schgadjust");
				ComBtnEnable("btn_costdetail");
				ComBtnEnable("btn_costbytransmode");
				ComBtnEnable("btn_cmpbviewall");
				ComBtnEnable("btn_cmviewall");
			}
		} else if (document.form.prc_prop_sts_cd.value == "Q") {
			if (bIsAproUsr) {
				ComBtnEnable("btn_save2");
				ComBtnEnable("btn_save3");
				ComBtnEnable("btn_accept3");
				ComBtnEnable("btn_acceptcancel3");

				ComBtnEnable("btn_schgdetail");
				ComBtnEnable("btn_schgviewall");
				ComBtnEnable("btn_costdetail");
				ComBtnEnable("btn_costbytransmode");
				ComBtnEnable("btn_cmpbviewall");
				ComBtnEnable("btn_cmviewall");
			}
			if (bIsReqUsr) {
				ComBtnEnable("btn_schgdetail");
				ComBtnEnable("btn_schgviewall");
				ComBtnEnable("btn_costdetail");
				ComBtnEnable("btn_costbytransmode");
				ComBtnEnable("btn_cmpbviewall");
				ComBtnEnable("btn_cmviewall");
			}
		} else if (document.form.prc_prop_sts_cd.value == "R") {
			if (bIsAproUsr) {
				// Nothing
			}
			if (bIsReqUsr) {
				ComBtnEnable("btn_save2");
				ComBtnEnable("btn_save3");

				ComBtnEnable("btn_calculate");
				checkMatchBackEnable();
				ComBtnEnable("btn_schgdetail");
				ComBtnEnable("btn_schgviewall");
				ComBtnEnable("btn_schgadjust");
				ComBtnEnable("btn_costdetail");
				ComBtnEnable("btn_costbytransmode");
				ComBtnEnable("btn_cmpbviewall");
				ComBtnEnable("btn_cmviewall");
			}
		} else {
			ComBtnEnable("btn_schgdetail");
			ComBtnEnable("btn_schgviewall");
			ComBtnEnable("btn_costdetail");
			ComBtnEnable("btn_costbytransmode");
			ComBtnEnable("btn_cmpbviewall");
			ComBtnEnable("btn_cmviewall");
		}

		break;
	case "READONLY":
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_acceptall");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_glcopy");
		ComBtnDisable("btn_gricalc");
		ComBtnEnable("btn_checkduplicate");
		ComBtnEnable("btn_downexcel");
		ComBtnDisable("btn_loadexcel");

		ComBtnDisable("btn_rowadd1");
		ComBtnDisable("btn_rowadd2");
		ComBtnDisable("btn_rowadd3");
		ComBtnDisable("btn_rowcopy1");
		ComBtnDisable("btn_rowcopy2");
		ComBtnDisable("btn_delete1");
		ComBtnDisable("btn_delete2");
		ComBtnDisable("btn_delete3");
		ComBtnDisable("btn_save1");
		ComBtnDisable("btn_save2");
		ComBtnDisable("btn_save3");
		ComBtnDisable("btn_amend3");
		ComBtnDisable("btn_amendcancel3");
		ComBtnDisable("btn_accept3");
		ComBtnDisable("btn_acceptcancel3");
		ComBtnEnable("btn_specification");

        ComBtnDisable("btn_mb");
		ComBtnDisable("btn_calculate");
		ComBtnDisable("btn_schgdetail");
		ComBtnEnable("btn_schgviewall");
		ComBtnDisable("btn_schgadjust");
		ComBtnDisable("btn_costdetail");
		ComBtnDisable("btn_costbytransmode");
		ComBtnDisable("btn_cmpbviewall");
		ComBtnDisable("btn_cmviewall");

		// sheetObjects[2].ColHidden("prs_scg_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_cm_uc_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_opfit_uc_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_cmpb_amt") = true;
		// sheetObjects[2].ColHidden("prs_gid_cmpb_amt") = true;
		// sheetObjects[2].ColHidden("prs_respb_opb_amt") = true;
		// sheetObjects[2].ColHidden("diff") = true;

		getRateSheet().ColHidden("prs_scg_amt") = true;
		getRateSheet().ColHidden("prs_respb_cm_uc_amt") = true;
		getRateSheet().ColHidden("prs_respb_opfit_uc_amt") = true;
		getRateSheet().ColHidden("prs_respb_cmpb_amt") = true;
		getRateSheet().ColHidden("prs_gid_cmpb_amt") = true;
		getRateSheet().ColHidden("prs_respb_opb_amt") = true;
		getRateSheet().ColHidden("diff") = true;

		sheetObjects[12].ColHidden("buc_usd_amt") = true;
		sheetObjects[12].ColHidden("ifc_usd_amt") = true;
		sheetObjects[12].ColHidden("psc_usd_amt") = true;

		sheetObjects[13].ColHidden("buc_dry20") = true;
		sheetObjects[13].ColHidden("buc_dry40") = true;
		sheetObjects[13].ColHidden("buc_dry40hc") = true;
		sheetObjects[13].ColHidden("buc_dry45") = true;
		sheetObjects[13].ColHidden("buc_rf40hc") = true;
		sheetObjects[13].ColHidden("buc_rd40hc") = true;
		sheetObjects[13].ColHidden("ifc_dry20") = true;
		sheetObjects[13].ColHidden("ifc_dry40") = true;
		sheetObjects[13].ColHidden("ifc_dry40hc") = true;
		sheetObjects[13].ColHidden("ifc_dry45") = true;
		sheetObjects[13].ColHidden("ifc_rf40hc") = true;
		sheetObjects[13].ColHidden("ifc_rd40hc") = true;
		sheetObjects[13].ColHidden("psc_dry20") = true;
		sheetObjects[13].ColHidden("psc_dry40") = true;
		sheetObjects[13].ColHidden("psc_dry40hc") = true;
		sheetObjects[13].ColHidden("psc_dry45") = true;
		sheetObjects[13].ColHidden("psc_rf40hc") = true;
		sheetObjects[13].ColHidden("psc_rd40hc") = true;
		break;
	}

	onCickRdoPRSCostLevel();
}

/**
 * 탭안의 화면이 로드되었을때 상위에서 호출하는 함수. 초기값을 세팅하고 화면을 조회한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sCtrtEffDt, sCtrtExpDt) {
	var formObject = document.form;
	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq
			|| formObject.prc_prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
		formObject.prop_no.value = sPropNo;
		formObject.amdt_seq.value = sAmdtSeq;
		formObject.svc_scp_cd.value = sSvcScpCd;
		formObject.pre_amdt_seq.value = sPreAmdtSeq;
		formObject.prc_prop_sts_cd.value = sPropStsCd;
		formObject.eff_dt.value = sEffDt;
		formObject.exp_dt.value = sExpDt;
		formObject.pre_exp_dt.value = sPreExpDt;
		formObject.is_req_usr.value = sIsReqUsr;
		formObject.is_apro_usr.value = sIsAproUsr;
		formObject.dur_dup_flg.value = sDurDupFlg;
		bIsReqUsr = sIsReqUsr;
		bIsAproUsr = sIsAproUsr;
		
		formObject.ctrt_eff_dt.value = sCtrtEffDt;
        formObject.ctrt_exp_dt.value = sCtrtExpDt;

		if (formObject.amdt_seq.value == "0") {
			hiddenButton("btn_amend3");
			hiddenButton("btn_amendcancel3");
		} else {
			showButton("btn_amend3");
			showButton("btn_amendcancel3");
		}

		// doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);
		doActionIBSheet(getRateSheet(), document.form, IBSEARCH_ASYNC20);

		var sCustType = parent.getCustTpCd();
		// Customer Type이 N일 경우, Actual Customer Type Enable
		if (sCustType == "N") {
			sheetObjects[0].InitDataProperty(0, 9, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
		} else {
			sheetObjects[0].InitDataProperty(0, 9, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
		}
		// O.Via 필수여부
		if (isOViaMandatory) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
		} else {
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
		}

		// D.Via 필수여부
		if (isDViaMandatory) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
		} else {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
		}

		// Radio Checked
		funcSelectedRadio();
		comUpdateTypeFontStyle();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}

		/* Calculate Button 관련 로직 시작 */
		initBatchJobMonitor();
		monitoringBatchJob();

	}
}

/**
 * 화면의 모든 내용을 초기화하는 함수로, 상위프레임에서 호출된다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function tabClearSheet() {
	var formObject = document.form;

	formObject.prop_no.value = "";
	formObject.amdt_seq.value = "";
	formObject.svc_scp_cd.value = "";
	formObject.pre_amdt_seq.value = "";
	formObject.prc_prop_sts_cd.value = "";
	formObject.eff_dt.value = "";
	formObject.exp_dt.value = "";
	formObject.pre_exp_dt.value = "";
	formObject.cmdt_hdr_seq.value = "";
	formObject.rout_seq.value = "";

	bIsReqUsr = false;
	bIsAproUsr = false;

	for ( var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].RemoveAll();
	}
	sheetObjects2[0].RemoveAll();

	origin_desc.innerHTML = "";
	ovia_desc.innerHTML = "";
	dvia_desc.innerHTML = "";
	dest_desc.innerHTML = "";

	var ficRtTpCd1 = document.getElementById("fic_rt_tp_cd1");
	var ficRtTpCd2 = document.getElementById("fic_rt_tp_cd2");
	ficRtTpCd1.style.fontWeight = "";
	ficRtTpCd1.style.color = "";
	ficRtTpCd2.style.fontWeight = "";
	ficRtTpCd2.style.color = "";

	toggleButtons("CLEAR");
	initBatchJobMonitor();
}

var enableFlag = true;
function tabEnableSheet(flag) {
	var formObject = document.form;
	enableFlag = flag;
	sheetObjects[0].Editable = flag;
	sheetObjects[1].Editable = flag;
	// sheetObjects[2].Editable = flag;
	getRateSheet().Editable = flag;

	if (enableFlag) {
		toggleButtons("INIT");
	} else {
		toggleButtons("READONLY");
	}
}

/**
 * CMDT Group의 Row가 삭제되었는지 확인. RowStatus와 취소선 여부로 판별한다.
 * 
 * @param
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function isCMDTGroupDeleted(row) {
	if (row == null || row == "" || row == undefined) {
		row = sheetObjects[0].SelectRow;
	}
	return (sheetObjects[0].RowStatus(row) == "D" || sheetObjects[0].CellFont("FontStrikethru", row, "prc_cmdt_def_nm"))
}

/**
 * Route Group의 Row가 삭제되었는지 확인. RowStatus와 취소선 여부로 판별한다.
 * 
 * @param
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function isRouteGroupDeleted(row) {
	if (row == null || row == "" || row == undefined) {
		row = sheetObjects[1].SelectRow;
	}
	return (sheetObjects[1].RowStatus(row) == "D" || sheetObjects[1].CellFont("FontStrikethru", row, "org_rout_pnt_loc_def_cd") || sheetObjects[1].CellFont("FontStrikethru", row,
			"dest_rout_pnt_loc_def_cd"))
}

/**
 * Route Group의 Row가 삭제되었는지 확인. 각 세부그리드의 Row수를 Count하여 판별하며, paramter로 주어지는 showMsg에 따라 메시지를 출력한다.
 * 
 * @param
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function isRouteGroupDeleted4Rate(showMsg) {

	if (showMsg == null || showMsg == "" || showMsg == undefined) {
		showMsg = false;
	}
	if (getAmendValidRowCount(sheetObjects[6], document.form.amdt_seq.value) <= 0) {
		if (showMsg) {
			ComShowCodeMessage("PRI00316", "Origin");
		}
		return true;
	}
	if (isOViaMandatory && getAmendValidRowCount(sheetObjects[7], document.form.amdt_seq.value) <= 0) {
		if (showMsg) {
			ComShowCodeMessage("PRI00316", "O.Via");
		}
		return true;
	}
	if (isDViaMandatory && getAmendValidRowCount(sheetObjects[8], document.form.amdt_seq.value) <= 0) {
		if (showMsg) {
			ComShowCodeMessage("PRI00316", "D.Via");
		}
		return true;
	}
	if (getAmendValidRowCount(sheetObjects[9], document.form.amdt_seq.value) <= 0) {
		if (showMsg) {
			ComShowCodeMessage("PRI00316", "Dest.");
		}
		return true;
	}
	return false;
}

/**
 * calculate 버튼에 마우스가 over됐을때 상태 Text를 보여준다..<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} e 필수, Event Object
 * @return 없음
 * @author 송민석
 * @version 2009.10.01
 */
function btn_calculate_OnMouseOver(e) {
	var parentObj = document.getElementById("btn_calculate");
	openDynamicPopup(-12, parentObj.clientHeight * -1 - 2, 100, 20, parentObj);
}

/**
 * calculate 버튼에 마우스가 over됐을때 상태 Text를 감춰준다..<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} e 필수, Event Object
 * @return 없음
 * @author 송민석
 * @version 2009.10.01
 */
function btn_calculate_OnMouseOut(e) {
	if (oPopup != null) {
		oPopup.hide();
	}
}
var oPopup = null;
var calcStatusStr = "Nothing";
var timeID = "";
var PRE_STATUS = "";
/**
 * calculate 버튼에 마우스가 over됐을때 보여줄 Text Div 생성 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} x 필수, x좌표
 * @param {object} y 필수, y좌표
 * @param {object} width 필수, 넓이
 * @param {object} height 필수, 높이
 * @param {object} parentObj 필수, parent Object
 * @return object, div object
 * @author 송민석
 * @version 2009.10.01
 */
function openDynamicPopup(x, y, width, height, parentObj) {
	if (oPopup == null) {
		oPopup = window.createPopup();
		var oPopBody = oPopup.document.body;
		oPopBody.style.backgroundColor = "lightyellow";
		oPopBody.style.border = "solid black 1px";
		oPopBody.style.padding = "2px"
		oPopBody.style.fontFamily = "Tahoma,verdana,arial,dotum,gulim";
		oPopBody.style.fontSize = "12px"

	}
	oPopup.document.body.innerHTML = calcStatusStr;
	oPopup.show(x, y, width, height, parentObj);
	return oPopup;

}

/**
 * 현재 batch 수행상태에 따라 버튼의 활성,비활시 시키고 <br>
 * 수행상태 Text를 변화시킨다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {string} sXml, sheet를 이용해 조회된 조회 xml
 * @return 없음
 * @author 송민석
 * @version 2009.10.01
 */
function updateMonitoringValue(sXml) {
	var status = ComGetEtcData(sXml, "BATCH_STATUS");
	var jobid = ComGetEtcData(sXml, "JOB_ID");
	var isFinish = false;
	calcStatusStr = getScheduleUtilStatusStr(status); // +"/jobid="+jobid+"/status="+status+"/PRE_STATUS="+PRE_STATUS ;
	if (((jobid == undefined || jobid == "") && status == "0") // 최초 실행시 버튼이 비활성화 되는것을 막고
			|| (status == "4" // direct로 Batch Job을 실행시킬때 생기는 Delay로 몇초간은 상태가 Nothing으로 return되는것을 대비
					|| status == "5" || status == "6" || status == "7" || status == "10" || status == "90" || status == "99")) { // 수행 성공과 무관하게 수행 종료 버튼 활성화

		if (document.form.prc_prop_sts_cd.value == "I") {
			if (bIsReqUsr || bIsAproUsr) {
				ComBtnEnable("btn_calculate");
				/* match back Button 활성여부 */
				checkMatchBackEnable();
			} else {
				ComBtnDisable("btn_mb");
				ComBtnDisable("btn_calculate");
			}
		} else if (document.form.prc_prop_sts_cd.value == "R") {
			if (bIsReqUsr) {
				ComBtnEnable("btn_calculate");
				/* match back Button 활성여부 */
				checkMatchBackEnable();
			} else {
				ComBtnDisable("btn_mb");
				ComBtnDisable("btn_calculate");
			}
		} else {
			ComBtnDisable("btn_mb");
			ComBtnDisable("btn_calculate");
		}

		// 성공일경우 Rate Sheet를 Retrieve 시킨다.
		if ((PRE_STATUS == "1" || PRE_STATUS == "0") && status == "4") {
			doActionIBSheet(getRateSheet(), document.form, IBSEARCH);
			parent.getPRSCMData();
		}
		isFinish = true;
	} else {
		ComBtnDisable("btn_mb");
		ComBtnDisable("btn_calculate");
		isFinish = false;
	}
	PRE_STATUS = status;
	return isFinish;

}

/**
 * calculate 수행여부에 따라 버튼의 활성,비활성 시킨다 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {string} sXml, sheet를 이용해 조회된 조회 xml
 * @return 없음
 * @author 전지예
 * @version 2015.04.23
 */
function checkMatchBackEnable() {
	 var formObj = document.form;
    var sheetObj = sheetObjects[0];
    formObj.f_cmd.value = SEARCH24;
    
	var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do", FormQueryString(formObj));
	var status = ComGetEtcData(sXml, "CAL_STATUS");
	
	if(status == "CALCULATED") {
		ComBtnEnable("btn_mb");
	} else {
		ComBtnDisable("btn_mb");
	}
}

function monitoringBatchJob() {
	// 개발시에는 모니터링을 하지 않는다.
	if (ComPriIsLocalhost() == true) {
		return;
	}
	if (parent.sheetObjects[1].RowCount == 0) {
		getScheduleUtilStatusStr("0");
		ComBtnDisable("btn_mb");
		ComBtnDisable("btn_calculate");
		return;
	}
	var sheetObj = sheetObjects[15];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH05;
	// var svc_scp_cd = parent.sheetObjects[1].CellValue(parent.sheetObjects[1].SelectRow,"svc_scp_cd");
	// var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svc_scp_cd);
	var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_07GS.do", FormQueryString(formObj));
	if (updateMonitoringValue(sXml) == false) {
		timeID = setTimeout(monitoringBatchJob, 3000);
	}

	/*
	 * status 0 <NULL> 알수없음 status 1 RUNNING 수행중 status 3 STARTING 시작(시스템) status 4 SUCCESS 성공 status 5 FAILURE 실패 status 6 TERMINATED 강제종료 status 7 ON_ICE 논리삭제 status 8
	 * INACTIVE 실행대기 status 9 ACTIVATED 활성화(시스템) status 10 RESTART 시작시에러 status 11 ON_HOLD 일시정지 status 12 QUE_WAIT 로드밸런싱 대기
	 * 
	 */

}

/**
 * 메인페이지에서 retrieve,new 됐을때 호출된다.<BR>
 * batch job 관련 초기화 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 * @author 송민석
 * @version 2009.11.25
 */
function initBatchJobMonitor() {
	if (timeID != "") {
		clearTimeout(timeID)
	}
	PRE_STATUS = "";
}

/**
 * TYPE RADIO 버튼의 폰트색을 변경하는 function <br>
 * 1) ALL ACCEPT일 경우는 파란색 <br>
 * 2) AMEND할 건수가 존재할 경우 빨간색 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setTypeFontStyle(sXml);
 * </pre>
 * 
 * @param {object} sXml 필수 Xml Object
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function setTypeFontStyle(sXml) {
	var arrDesc = ComPriXml2Array(sXml, "intg_cd_val_ctnt|font_style|tot_cnt");
	var ficRtTpCd1 = document.getElementById("fic_rt_tp_cd1");
	var ficRtTpCd2 = document.getElementById("fic_rt_tp_cd2");

	if (arrDesc != null && arrDesc.length > 0) {
		for ( var i = 0; i < arrDesc.length; i++) {
			var obj;
			if (arrDesc[i][0] == 'G') {
				obj = ficRtTpCd1;
			} else if (arrDesc[i][0] == 'A') {
				obj = ficRtTpCd2;
			}

			if (arrDesc[i][1] == "blue") {
				obj.style.fontWeight = "bold";
				obj.style.color = "blue";
			} else if (arrDesc[i][1] == "red") {
				obj.style.fontWeight = "bold";
				obj.style.color = "red";
			} else if (arrDesc[i][1] == "bold") {
				obj.style.fontWeight = "bold";
				obj.style.color = "black";
			} else {
				obj.style.fontWeight = "";
				obj.style.color = "black";
			}
		}
	}
}

/**
 * OnClick 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function obj_click() {
	var formObj = document.form;
	if (event.srcElement.name == "fic_rt_tp_cd") {
		if (formObj.fic_rt_tp_cd[0].checked) {
			formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[0].value;
			isOViaMandatory = false;
			isDViaMandatory = false;
		} else if (formObj.fic_rt_tp_cd[1].checked) {
			formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[1].value;
		}
		sheetObjects[1].Reset();
		initSheet(sheetObjects[1], 0);

		controlSheetDisplay();
		var btnRetrieve = document.getElementById('btn_retrieve');
		btnRetrieve.fireEvent('onclick');
	}
}

/**
 * 조건에 맞는 Sheet를 표현하는 function <br>
 * <br>
 * <b>Example : controlSheetDisplay()</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function controlSheetDisplay() {
	var formObj = document.form;
	var svcScpCd = formObj.svc_scp_cd.value;
	var mainTable = document.getElementsByName("mainTable");

	if (formObj.fic_rt_tp_cd[1].checked) {
		mainTable[2].style.display = "none";
		mainTable[3].style.display = "";
	} else {
		mainTable[2].style.display = "";
		mainTable[3].style.display = "none";
	}

	if (formObj.fic_rt_tp_cd[1].checked) {
		if ("AEE" == svcScpCd) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtData, 165, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
		} else if ("AEW" == svcScpCd) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtData, 165, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
		}
	} else {
		// O.Via 필수여부
		if (isOViaMandatory) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
		} else {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("org_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
		}
		// D.Via 필수여부
		if (isDViaMandatory) {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
		} else {
			sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dest_rout_via_port_def_cd"), dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
		}
	}
}

/**
 * 조건에 맞는 Sheet를 표현하는 function <br>
 * <br>
 * <b>Example : sheet2_OnSearchEnd(sheetObj, ErrMsg)</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.SearchRows;
	var ficRtUseStsCd = "";
	var data = null;
	// 2012.06.08수정
	var chkTypeStatus = funcChkTypeStatus();
	for ( var i = sRow; i < eRow; i++) {
		if (chkTypeStatus == 'X') {
			sheetObj.CellValue2(i, "fic_rt_use_sts_cd") = 'X';
			sheetObj.CellValue2(i, "optm_trsp_mod_flg") = 'N';
			sheetObj.CellValue2(i, "dr_20ft_amt") = '';
			sheetObj.CellValue2(i, "rf_20ft_amt") = '';
			sheetObj.CellValue2(i, "dg_20ft_amt") = '';
			sheetObj.CellValue2(i, "dr_40ft_amt") = '';
			sheetObj.CellValue2(i, "rf_40ft_amt") = '';
			sheetObj.CellValue2(i, "dg_40ft_amt") = '';

			sheetObj.CellValue2(i, "locl_curr_cd") = '';
			sheetObj.CellValue2(i, "dr_locl_20ft_amt") = '';
			sheetObj.CellValue2(i, "rf_locl_20ft_amt") = '';
			sheetObj.CellValue2(i, "dg_locl_20ft_amt") = '';
			sheetObj.CellValue2(i, "dr_locl_40ft_amt") = '';
			sheetObj.CellValue2(i, "rf_locl_40ft_amt") = '';
			sheetObj.CellValue2(i, "dg_locl_40ft_amt") = '';
			sheetObj.RowStatus(i) = "R";
		}
	}
}

/**
 * Per/Cgo Type/Cur 변경시 Total 금액은 0으로 변환.
 */
function calcRate2(sheetObj, Row) {
	var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");
	var prcCgoTpCd = sheetObj.CellValue(Row, "prc_cgo_tp_cd");
	var currCd = sheetObj.CellValue(Row, "curr_cd");

	var ficGlineInfo = new Array();
	if (ratUtCd == "D2" || ratUtCd == "R2") {
		ficGlineInfo = funcFicGlineRtAmt(sheetObj, 20, prcCgoTpCd, currCd);
	} else if (ratUtCd == "D4" || ratUtCd == "D5" || ratUtCd == "R4" || ratUtCd == "R5") {
		ficGlineInfo = funcFicGlineRtAmt(sheetObj, 40, prcCgoTpCd, currCd);
	} else {
		ficGlineInfo[0] = "N/A";
		ficGlineInfo[1] = "";
		ficGlineInfo[2] = "";
	}
	if (ficGlineInfo[0] != 'N/A') {
		ficGlineInfo[0] = Number(ficGlineInfo[0]);
	}
	sheetObj.CellValue2(Row, "fic_gline_rt_amt") = ficGlineInfo[0];
	sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = ficGlineInfo[1];
	sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = ficGlineInfo[2];
	sheetObj.CellValue2(Row, "prop_frt_rt_amt") = 0.00;

	if (ficGlineInfo[0] == '' || ficGlineInfo[0] == 'N/A') {
		sheetObj.CellValue(Row, "fic_prop_rt_amt") = 0.00;
	} else {
		sheetObj.CellValue(Row, "fic_prop_rt_amt") = ficGlineInfo[0];
	}

	var nFicPropRtAmt = Number(sheetObj.CellValue(Row, "fic_prop_rt_amt"));
	nFicPropRtAmt = nFicPropRtAmt * 100;
	nFicPropRtAmt = nFicPropRtAmt.toFixed();

	var nPropFrtRtAmt = Number(sheetObj.CellValue(Row, "prop_frt_rt_amt"));
	nPropFrtRtAmt = nPropFrtRtAmt * 100;
	nPropFrtRtAmt = nPropFrtRtAmt.toFixed();

	var sFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
	if (sFicGlineRtAmt == 'N/A') {
		sheetObj.CellValue2(Row, "diff_prop_rt_amt") = "N/A";
	} else {
		var nFicGlineRtAmt = Number(sFicGlineRtAmt);
		nFicGlineRtAmt = nFicGlineRtAmt * 100;
		nFicGlineRtAmt = nFicGlineRtAmt.toFixed();
		sheetObj.CellValue2(Row, "diff_prop_rt_amt") = ComAddComma2(((nFicPropRtAmt - nFicGlineRtAmt) / 100).toString(), '#,###.00');
	}

	sheetObj.CellValue2(Row, "prop_bof_amt") = ComGetMaskedValue((nPropFrtRtAmt - nFicPropRtAmt) / 100, "float");
}

/**
 * 2012.06.07일 부로 사용.
 */
function funcFicGlineRtAmt(sheetObj1, ratUtCd, prcCgoTpCd, currCd) {
	var ficGlineInfo = new Array();
	var formObj = document.form;
	var rsltAmt = 0;
	var sheetObj = sheetObjects[1];
	var Row = sheetObj.SelectRow;
	var vLocCurrCd = sheetObj.CellValue(Row, "locl_curr_cd");

	if (vLocCurrCd == currCd) {
		if (ratUtCd == 20) {
			if (prcCgoTpCd == "DR") {
				rsltAmt = sheetObj.CellValue(Row, "dr_locl_20ft_amt");
			} else if (prcCgoTpCd == "DG") {
				rsltAmt = sheetObj.CellValue(Row, "dg_locl_20ft_amt");
			} else if (prcCgoTpCd == "RF") {
				rsltAmt = sheetObj.CellValue(Row, "rf_locl_20ft_amt");
			} else {
				rsltAmt = -1;
			}
		} else if (ratUtCd == 40) {
			if (prcCgoTpCd == "DR") {
				rsltAmt = sheetObj.CellValue(Row, "dr_locl_40ft_amt");
			} else if (prcCgoTpCd == "DG") {
				rsltAmt = sheetObj.CellValue(Row, "dg_locl_40ft_amt");
			} else if (prcCgoTpCd == "RF") {
				rsltAmt = sheetObj.CellValue(Row, "rf_locl_40ft_amt");
			} else {
				rsltAmt = -1;
			}
		}
	} else {
		if (ratUtCd == 20) {
			if (prcCgoTpCd == "DR") {
				rsltAmt = sheetObj.CellValue(Row, "dr_20ft_amt");
			} else if (prcCgoTpCd == "DG") {
				rsltAmt = sheetObj.CellValue(Row, "dg_20ft_amt");
			} else if (prcCgoTpCd == "RF") {
				rsltAmt = sheetObj.CellValue(Row, "rf_20ft_amt");
			} else {
				rsltAmt = -1;
			}
		} else if (ratUtCd == 40) {
			if (prcCgoTpCd == "DR") {
				rsltAmt = sheetObj.CellValue(Row, "dr_40ft_amt");
			} else if (prcCgoTpCd == "DG") {
				rsltAmt = sheetObj.CellValue(Row, "dg_40ft_amt");
			} else if (prcCgoTpCd == "RF") {
				rsltAmt = sheetObj.CellValue(Row, "rf_40ft_amt");
			} else {
				rsltAmt = -1;
			}
		}
	}
	var ficRtUseStsCd = sheetObj.CellValue(Row, "fic_rt_use_sts_cd");
	var optmTrspModFlg = sheetObj.CellValue(Row, "optm_trsp_mod_flg");
	if (rsltAmt == -1 || rsltAmt == '') {
		ficGlineInfo[0] = "N/A";
		if (rsltAmt == -1) {
			ficGlineInfo[1] = "";
			ficGlineInfo[2] = "";
		} else {
			ficGlineInfo[1] = ficRtUseStsCd;
			ficGlineInfo[2] = optmTrspModFlg;
		}
		return ficGlineInfo;
	}

	var minAmt = Number.MAX_VALUE;
	minAmt = Number(rsltAmt);
	if (ficRtUseStsCd != "S") {
		minAmt = "N/A";
	}
	if (rsltAmt != 'N/A' && currCd != 'USD' && vLocCurrCd != currCd) {
		formObj.fic_gline_rt_amt.value = minAmt;
		formObj.curr_cd.value = currCd;
		minAmt = doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
	}
	ficGlineInfo[0] = minAmt;
	ficGlineInfo[1] = ficRtUseStsCd;
	ficGlineInfo[2] = optmTrspModFlg;
	return ficGlineInfo;
}

/**
 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
 * @version 2012.07.10
 */
function sheet17_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Origin Point
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 이은섭
 * @version 2012.07.10
 */
function sheet17_OnSearchEnd(sheetObj, ErrMsg) {
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;

	sheetObj.Redraw = false;
	for ( var i = sRow; i < eRow; i++) {
		var ficGlineRtAmt = sheetObj.CellValue(i, "fic_gline_rt_amt"); // GuideLine 금약
		var fnlFrtRtAmt = parseFloat(sheetObj.CellValue(i, "fnl_frt_rt_amt")); // final Total 금액
		var coffrFrtRtAmt = parseFloat(sheetObj.CellValue(i, "coffr_frt_rt_amt")); // C.offer Total 금액
		var ficPropRtAmt = parseFloat(sheetObj.CellValue(i, "fic_prop_rt_amt")); // Proposal IHc 금액
		var propFrtRtAmt = parseFloat(sheetObj.CellValue(i, "prop_frt_rt_amt")); // Proposal Total 금액

		if (ficGlineRtAmt == "" || ficGlineRtAmt == "N/A") {
			ficGlineRtAmt = "N/A";
			sheetObj.CellValue2(i, "fic_gline_rt_amt") = ficGlineRtAmt;
			sheetObj.CellValue2(i, "diff_prop_rt_amt") = ficGlineRtAmt;
		}

		// Proposal TOTAL 금액이 없을 경우 0으로 인식해줌.
		if (isNaN(propFrtRtAmt)) {
			propFrtRtAmt = 0;
		}

		// Proposal IHC금액이 공백이거나, 0인경우 Proposal Diff 금액을 N/A로 설정.
		if (isNaN(ficPropRtAmt)) {
			ficPropRtAmt = 0;
			sheetObj.CellValue2(i, "diff_prop_rt_amt") = 'N/A';
		}

		// Proposal IHC 금액이 0보다 큰경우,
		// Guide Line 금액이 N/A 가 아닌경우 Proposal Diff 를 계산
		// Guide Line 금액이 N/A 인 경우 Proposal Diff를 N/A로 설정.
		//  
		if (ficPropRtAmt >= 0) {
			if (ficGlineRtAmt != "N/A") {
				sheetObj.CellValue2(i, "diff_prop_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficPropRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2), 2)).toString(), "#,###.00");
			} else {
				sheetObj.CellValue2(i, "diff_prop_rt_amt") = "N/A";
			}
		}

		// Proposal bof 금액 설정 = Proposal Total 금액 - Proposal IHc 금액
		sheetObj.CellValue2(i, "prop_bof_amt") = propFrtRtAmt - ficPropRtAmt;

		// Final Total 금액이 있는 경우 Final Diff, Final Bof 설정
		if (!isNaN(fnlFrtRtAmt)) {
			var ficFnlRtAmt = sheetObj.CellValue(i, "fic_fnl_rt_amt"); // Final IHC 금액
			// final Ihc 금액이 존재하는 경우 처리.
			if (ficFnlRtAmt != '') {
				ficFnlRtAmt = parseFloat(ficFnlRtAmt);
				sheetObj.CellValue2(i, "fnl_bof_amt") = ComGetMaskedValue(ComTrunc(ComTrunc(fnlFrtRtAmt, 2) - ComTrunc(ficFnlRtAmt, 2), 2), "float");

				if (ficFnlRtAmt > 0) {
					if (ficGlineRtAmt != "N/A") {
						sheetObj.CellValue2(i, "diff_fnl_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficFnlRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2), 2)).toString(), "#,###.00");
					} else {
						sheetObj.CellValue2(i, "diff_fnl_rt_amt") = "N/A";
					}
				} else {
					sheetObj.CellValue2(i, "diff_fnl_rt_amt") = 'N/A';
				}
			}
		}

		// C.Off Total 금액이 있는 경우 C.Off Diff, C.Off Bof 설정
		if (!isNaN(coffrFrtRtAmt)) {
			var ficCoffrRtAmt = sheetObj.CellValue(i, "fic_coffr_rt_amt"); // C.offer IHC 금액
			// C.offer Ihc 금액이 존재하는 경우 처리.
			if (ficCoffrRtAmt != '') {
				ficCoffrRtAmt = parseFloat(ficCoffrRtAmt);
				sheetObj.CellValue2(i, "coffr_bof_amt") = ComGetMaskedValue(ComTrunc(ComTrunc(coffrFrtRtAmt, 2) - ComTrunc(ficCoffrRtAmt, 2), 2), "float");

				if (ficFnlRtAmt > 0) {
					if (ficGlineRtAmt != "N/A") {
						sheetObj.CellValue2(i, "diff_coffr_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficCoffrRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2), 2)).toString(), "#,###.00");
					} else {
						sheetObj.CellValue2(i, "diff_coffr_rt_amt") = "N/A";
					}
				} else {
					sheetObj.CellValue2(i, "diff_coffr_rt_amt") = 'N/A';
				}
			}
		}
		sheetObj.RowStatus(i) = "R";
	}
	sheetObj.Redraw = true;
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
 * @version 2012.07.10
 */
function sheet17_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	switch (colName) {
	case "fic_gline_rt_amt": // Guide Line 금액
		var ficGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
		if (ficGlineRtAmt == "N/A") {
			sheetObj.CellValue2(Row, "prop_frt_rt_amt") = 0.00;
			sheetObj.CellValue2(Row, "prop_bof_amt") = 0;
			sheetObj.CellValue2(Row, "fic_prop_rt_amt") = 0;
			sheetObj.CellValue2(Row, "diff_prop_rt_amt") = "N/A";
		} else {
			sheetObj.CellValue2(Row, "prop_frt_rt_amt") = ficGlineRtAmt;
			sheetObj.CellValue2(Row, "prop_bof_amt") = 0.00;
			sheetObj.CellValue2(Row, "fic_prop_rt_amt") = ficGlineRtAmt;
			sheetObj.CellValue2(Row, "diff_prop_rt_amt") = 0.00;
		}
		break;
	case "prc_cgo_tp_cd": // Cargo type 변경시 Rating Unit이 적당한지 체크
		if (Value == "AK") {
			var validPerClass = "D,A,F,O,Q,S,P";
			var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
			if (validPerClass.indexOf(perClass) < 0) {
				ComShowCodeMessage("PRI08003");
				sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
			}
		}
		calcRate2(sheetObj, Row);
		break;
	case "rat_ut_cd": // Rating Unit 변경시 이에 맞게 Cargo type을 default setting한다.
		var validPerClass = "A,F,O,Q,S,P";
		var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
		if (perClass == "") {
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
		calcRate2(sheetObj, Row);
		break;
	case "curr_cd":
		calcRate2(sheetObj, Row);
		break;

	case "fic_prop_rt_amt": // Proposal IHC 금액
		var sFicPropRtAmt = sheetObj.CellValue(Row, "fic_prop_rt_amt");
		if (!sFicPropRtAmt) {
			return false;
		}
		var nFicPropRtAmt = Number(sFicPropRtAmt);
		nFicPropRtAmt = nFicPropRtAmt * 100;
		nFicPropRtAmt = nFicPropRtAmt.toFixed();

		var sFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
		if (sFicGlineRtAmt != "N/A") {
			var nFicGlineRtAmt = Number(sFicGlineRtAmt);
			nFicGlineRtAmt = nFicGlineRtAmt * 100;
			nFicGlineRtAmt = nFicGlineRtAmt.toFixed();
			sheetObj.CellValue2(Row, "diff_prop_rt_amt") = ComAddComma2(((nFicPropRtAmt - nFicGlineRtAmt) / 100).toString(), "#,###.00");
		}

		var sPropFrtRtAmt = sheetObj.CellValue(Row, "prop_frt_rt_amt");
		var nPropFrtRtAmt = Number(sPropFrtRtAmt);
		nPropFrtRtAmt = nPropFrtRtAmt * 100;
		nPropFrtRtAmt = nPropFrtRtAmt.toFixed();
		sheetObj.CellValue2(Row, "prop_bof_amt") = ComGetMaskedValue((nPropFrtRtAmt - nFicPropRtAmt) / 100, "float");
		break;

	case "prop_frt_rt_amt": // Proposal amount 변경시 PRS관련 값들을 재 계산해준다.
		var sPropFrtRtAmt = sheetObj.CellValue(Row, "prop_frt_rt_amt");
		if (Value != null && Value != "") {
			var nPropFrtRtAmt = Number(sPropFrtRtAmt);
			var sFicPropRtAmt = sheetObj.CellValue(Row, "fic_prop_rt_amt"); // Proposal IHC 금액
			var nFicPropRtAmt = Number(sFicPropRtAmt);

			// 부동소수점 제어를 위해 정수형 변경후 처리
			nPropFrtRtAmt = nPropFrtRtAmt * 100;
			nPropFrtRtAmt = nPropFrtRtAmt.toFixed();
			nFicPropRtAmt = nFicPropRtAmt * 100;
			nFicPropRtAmt = nFicPropRtAmt.toFixed();
			// Proposal Bof 금액
			sheetObj.CellValue2(Row, "prop_bof_amt") = ComGetMaskedValue((nPropFrtRtAmt - nFicPropRtAmt) / 100, "float");
		}

		var scgAmt = sheetObj.CellValue(Row, "prs_scg_amt");
		var respbCmUcAmt = sheetObj.CellValue(Row, "prs_respb_cm_uc_amt");
		var respbOpfitUcAmt = sheetObj.CellValue(Row, "prs_respb_opfit_uc_amt");
		var pfitCmUcAmt = sheetObj.CellValue(Row, "prs_pfit_cm_uc_amt");

		if (Value != null && Value != "" && scgAmt != null && scgAmt != "") {
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObj.CellValue(Row, "prs_respb_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbCmUcAmt);
			} else {
				sheetObj.CellValue(Row, "prs_respb_cmpb_amt") = "";
			}
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObj.CellValue(Row, "prs_respb_opb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(respbOpfitUcAmt);
			} else {
				sheetObj.CellValue(Row, "prs_respb_opb_amt") = "";
			}
			if (respbCmUcAmt != null && respbCmUcAmt != "") {
				sheetObj.CellValue(Row, "prs_pfit_cmpb_amt") = parseFloat(Value) + parseFloat(scgAmt) - parseFloat(pfitCmUcAmt);
			} else {
				sheetObj.CellValue(Row, "prs_pfit_cmpb_amt") = "";
			}
		} else {
			sheetObj.CellValue(Row, "prs_respb_cmpb_amt") = "";
			sheetObj.CellValue(Row, "prs_respb_opb_amt") = "";
			sheetObj.CellValue(Row, "prs_pfit_cmpb_amt") = "";
		}

		if (sheetObj.CellValue(Row, "prs_gid_cmpb_amt") != "" && sheetObj.CellValue(Row, "prs_respb_cmpb_amt") != "") {
			sheetObj.CellValue(Row, "diff") = parseFloat(sheetObj.CellValue(Row, "prs_respb_cmpb_amt")) - parseFloat(sheetObj.CellValue(Row, "prs_gid_cmpb_amt"));
		} else {
			sheetObj.CellValue(Row, "diff") = "";
		}
		break;

	case "fic_coffr_rt_amt": // C.Off IHC 금액
		var sFicCoffrRtAmt = sheetObj.CellValue(Row, "fic_coffr_rt_amt");
		if (sFicCoffrRtAmt == '' || sFicCoffrRtAmt == null) {
			sheetObj.CellValue2(Row, "coffr_frt_rt_amt") = '';
			sheetObj.CellValue2(Row, "coffr_bof_amt") = '';
			sheetObj.CellValue2(Row, "diff_coffr_rt_amt") = '';
		} else {
			var nFicCoffrRtAmt = Number(sFicCoffrRtAmt);
			nFicCoffrRtAmt = nFicCoffrRtAmt * 100;
			nFicCoffrRtAmt = nFicCoffrRtAmt.toFixed();

			var sFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
			if (sFicGlineRtAmt != "N/A") {
				var nFicGlineRtAmt = Number(sFicGlineRtAmt);
				nFicGlineRtAmt = nFicGlineRtAmt * 100;
				nFicGlineRtAmt = nFicGlineRtAmt.toFixed();
				sheetObj.CellValue2(Row, "diff_coffr_rt_amt") = ComAddComma2(((nFicCoffrRtAmt - nFicGlineRtAmt) / 100).toString(), "#,###.00");
			}

			var sCoffrFrtRtAmt = sheetObj.CellValue(Row, "coffr_frt_rt_amt");
			var nCoffrFrtRtAmt = Number(sCoffrFrtRtAmt);
			nCoffrFrtRtAmt = nCoffrFrtRtAmt * 100;
			nCoffrFrtRtAmt = nCoffrFrtRtAmt.toFixed();
			sheetObj.CellValue2(Row, "coffr_bof_amt") = ComGetMaskedValue((nCoffrFrtRtAmt - nFicCoffrRtAmt) / 100, "float");
		}
		break;

	case "coffr_frt_rt_amt": // C.Offer amount 변경시 PRS관련 값들을 재 계산해준다.
		var sCoffrFrtRtAmt = sheetObj.CellValue(Row, "coffr_frt_rt_amt");
		if (sCoffrFrtRtAmt == '' || sCoffrFrtRtAmt == null) {
			sheetObj.CellValue2(Row, "coffr_bof_amt") = '';
			sheetObj.CellValue2(Row, "fic_coffr_rt_amt") = '';
			sheetObj.CellValue2(Row, "diff_coffr_rt_amt") = '';
		} else {
			var sFicCoffrRtAmt = sheetObj.CellValue(Row, "fic_coffr_rt_amt"); // C.Offer IHC 금액
			if (sFicCoffrRtAmt == '' || sFicCoffrRtAmt == null) {
				sFicCoffrRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
				if (sFicCoffrRtAmt == 'N/A') {
					sFicCoffrRtAmt = 0;
				}
				sheetObj.CellValue(Row, "fic_coffr_rt_amt") = sFicCoffrRtAmt;
			} else {
				var nFicCoffrRtAmt = Number(sFicCoffrRtAmt);
				var nCoffrFrtRtAmt = Number(sCoffrFrtRtAmt);
				// 부동소수점 제어를 위해 정수형 변경후 처리
				nFicCoffrRtAmt = nFicCoffrRtAmt * 100;
				nFicCoffrRtAmt = nFicCoffrRtAmt.toFixed();
				nCoffrFrtRtAmt = nCoffrFrtRtAmt * 100;
				nCoffrFrtRtAmt = nCoffrFrtRtAmt.toFixed();
				// C.Offer Bof 금액
				sheetObj.CellValue2(Row, "coffr_bof_amt") = ComGetMaskedValue((nCoffrFrtRtAmt - nFicCoffrRtAmt) / 100, "float");
			}
		}
		break;
	}

}

/**
 * Rate 대상 Sheet를 조회한다. <br>
 * <b>Example : getRateSheet()</b>
 * 
 * @return sheetObj
 */
function getRateSheet() {
	var formObj = document.form;
	if (formObj.fic_rt_tp_cd[1].checked) {
		return sheetObjects2[0];
	} else {
		return sheetObjects[2];
	}
}

/**
 * Type과 Service Scope에 따른 리턴
 * 
 */
function funcChkTypeStatus() {
	var rdFicRtTpCd = document.form.fic_rt_tp_cd[1].checked;
	var svcScpCd = document.form.svc_scp_cd.value;
	var rsltVal = 'X';
	if (rdFicRtTpCd) {
		if (svcScpCd == 'AEE') {
			rsltVal = 'O';
		} else if (svcScpCd == 'AEW') {
			rsltVal = 'D';
		}
	}
	return rsltVal;
}

/**
 * 선택한 라디오의 value 조회
 */
function funcCheckFicRtTpCdVal() {
	var rdFicRtTpCd = document.form.fic_rt_tp_cd[1].checked;
	if (rdFicRtTpCd) {
		return document.form.fic_rt_tp_cd[1].value;
	} else {
		return document.form.fic_rt_tp_cd[0].value;
	}
	return rsltVal;
}

/* 개발자 작업 끝 */