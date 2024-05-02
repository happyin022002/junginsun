/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_6097.js
 *@FileTitle : RFA Quotation Rate - Origin & Destination
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.25
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
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
function ESM_PRI_6097() {
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

var exTransaction = false;

var beforeIndex = -1;

var curPntViaType = "";
var curOrgDestType = "";

var orgExptLoc; //Origin Exception Location
var destExptLoc; //Destination Exception Location
var stdOriginCode = "";
var stdDestCode = "";	
var v_origin = 'O';
var v_destination = 'D';

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
 * @author 박성수
 * @version 2009.05.01
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
			case "btn_add":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], formObject, IBINSERT);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], formObject, IBDELETE);
				break;
	
			case "btn_ok":
				if (!checkGroupNoCyDoor(v_origin) || !checkGroupNoCyDoor(v_destination)) {
					return false;
				}
				if (!CYDoorCrossCheck()) {
					return false;
				}
				doActionIBSheet(sheetObjects[parseInt(getRtPntNew())], document.form, IBSAVE);
				break;
	
			case "btn_close":
				window.close();
				break;
	
			case "rt_pnt":
				rtPntOnClick();
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
 * @author 박성수
 * @version 2009.05.01
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
 * @author 박성수
 * @version 2009.05.01
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "P") {
		document.form.rt_pnt[0].checked = true;
	} else if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "V") {
		document.form.rt_pnt[1].checked = true;
	} else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "V") {
		document.form.rt_pnt[2].checked = true;
	} else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "P") {
		document.form.rt_pnt[3].checked = true;
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC09);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	
	rtPntOnClick();
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
 * @author 박성수
 * @version 2009.05.01
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			style.height = 140;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(1, 1, 3, 100);
			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq|Term|Trans. Mode";
			var headCount = ComCountHeadTitle(HeadTitle);

			InitColumnInfo(headCount, 0, 0, true);
			InitHeadMode(false, true, true, true, false, false)
			InitHeadRow(0, HeadTitle, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 105, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
			ShowButtonImage = 2;
			EnterBehavior = "tab";

		}
		break;

	case 2: // sheet1 init
		with (sheetObj) {
			style.height = 140;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq";
			var headCount = ComCountHeadTitle(HeadTitle);
			InitColumnInfo(headCount, 0, 0, true);
			InitHeadMode(false, true, true, true, false, false)
			InitHeadRow(0, HeadTitle, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 105, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
			ShowButtonImage = 2;
			EnterBehavior = "tab";

		}
		break;

	case 3: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 140;
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

			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 105, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, "rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rout_via_port_def_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
			ShowButtonImage = 2;
			EnterBehavior = "tab";

		}
		break;

	case 4: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 140;
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

			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|src_info_cd|display_seq|Term|rcv_de_term_nm|Trans. Mode";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 105, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "rcv_de_term_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
			ShowButtonImage = 2;
			EnterBehavior = "tab";

		}
		break;

	case 5: // sheet5 init
		with (sheetObj) {
			// 높이 설정
			style.height = 140;
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

			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Loc Group|src_info_cd|display_seq|Term|Base Port|bse_port_loc_cd|Trans. Mode|org_cy_dor_rt_tp_cd"
					+ "|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt" + "|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt"
					+ "|locl_curr_cd|dr_locl_20ft_amt|rf_locl_20ft_amt|dg_locl_20ft_amt|dr_locl_40ft_amt|rf_locl_40ft_amt|dg_locl_40ft_amt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 105, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "group_no", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtComboEdit, 90, daCenter, false, "bse_port_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "bse_port_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_cy_dor_rt_tp_cd", true, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "base_port_list", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "optm_trsp_mod_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_rout_cmb_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_gline_upd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
			InitDataValid(0, "bse_port_def_cd", vtEngUpOther, "1234567890");
			ShowButtonImage = 2;
			EnterBehavior = "tab";

		}
		break;

	case 6: // sheet6 init
		with (sheetObj) {
			// 높이 설정
			style.height = 140;
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

			var HeadTitle = "|Sel.|Seq.|1|2|3|4|5|6|Location Type|Location Code|Description|Loc Group|src_info_cd|display_seq|Term|Base Port|bse_port_loc_cd|Trans. Mode|dest_cy_dor_rt_tp_cd"
					+ "|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt" + "|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt"
					+ "|locl_curr_cd|dr_locl_20ft_amt|rf_locl_20ft_amt|dg_locl_20ft_amt|dr_locl_40ft_amt|rf_locl_40ft_amt|dg_locl_40ft_amt";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 105, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "group_no", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "display_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtComboEdit, 90, daCenter, false, "bse_port_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "bse_port_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "dest_cy_dor_rt_tp_cd", true, "", dfNone, 0, false, false);			

			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "base_port_list", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "optm_trsp_mod_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_rout_cmb_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, false, "fic_gline_upd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "locl_curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dr_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rf_locl_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "dg_locl_40ft_amt", false, "", dfNone, 0, true, true);

			InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
			InitDataValid(0, "bse_port_def_cd", vtEngUpOther, "1234567890");
			ShowButtonImage = 2;
			EnterBehavior = "tab";
		}
		break;

	case 7: // sheet7 서버통신용
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
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

			var HeadTitle = "1|2";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "data");
			EnterBehavior = "tab";

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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet6_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	changeSelectBackColor4Rate(sheetObj);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet5_OnChange(sheetObj, Row, Col, Value) {
	sheet_OnChange(sheetObj, Row, Col, Value);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet6_OnChange(sheetObj, Row, Col, Value) {
	sheet_OnChange(sheetObj, Row, Col, Value);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var sender = sheetObjects[6];
	if (colName == "rout_pnt_loc_def_cd") {
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4="
					+ formObj.org_dest_tp_cd.value;
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
				// 최종 조회 성공 했다. 이 정보를 바탕으로 'CY 인지 다시 판단을 한다.
				if (!validateCYPortLocation(sheetObj, Row, Value, "L")) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = " ";
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
					sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
				}
			} else {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4="
					+ formObj.org_dest_tp_cd.value;
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
				if (!validateCYPortLocation(sheetObj, Row, Value, "G")) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = " ";
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
					sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
				}
			} else {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
			return false;
		}
	} else if (colName == "rout_pnt_loc_tp_cd") {
		sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var sender = sheetObjects[6];

	if (colName == "rout_via_port_def_cd") {
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "L";
				sheetObj.CellValue2(Row, "rout_via_port_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
				sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
				sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "G";
				sheetObj.CellValue2(Row, "rout_via_port_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
				sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
				sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
			sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
			sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
			return false;
		}
	} else if (colName == "rout_via_port_tp_cd") {
		sheetObj.CellValue2(Row, "rout_via_port_def_nm") = "";
		sheetObj.CellValue2(Row, "rout_via_port_def_cd") = "";
		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
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
 * @author 박성수
 * @version 2009.05.01
 */
	function sheet_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var sender = sheetObjects[6];
        var checkStr = funcChkTypeStatus() ;
		if (colName == "rout_pnt_loc_def_cd") {
			initFicRoute(sheetObj, Row, Col);
			var param = "&cd=" + Value;
				param += "&nm=rpscp";
				param += "&etc1=" + formObj.qttn_no.value;
				param += "&etc2=" + formObj.qttn_ver_no.value;
				param += "&etc3=" + formObj.svc_scp_cd.value;
				param += "&etc4=" + formObj.org_dest_tp_cd.value;
					
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
 					if( !validateCYPortLocation( sheetObj, Row, Value,"L") ){
 						sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
 			    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
 					} 					
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
 					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrData[1];
 					sheetObj.CellValue2(Row, "rcv_de_term_cd") = 'Y';
 					//최종 조회 성공 했다. 이 정보를 바탕으로 'CY 인지 다시 판단을 한다.
 					if( !validateCYPortLocation( sheetObj, Row, Value,"G") ){
 						sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = " ";
 						sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
 			    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
 					}
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else  {
		        // LOCATION GROUP은 IHC가 포함된 곳에는 들어 갈수 없다.
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);	            	
            	return false;
			} 
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06); 
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
    		sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = "";
    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
			if(Value == 'G') {
				sheetObj.CellValue2(Row, "rcv_de_term_cd") = 'Y';
			}
		} else if (colName == "rcv_de_term_cd") {
			if(Value == 'D' && sheetObj.CellValue(Row, "rout_pnt_loc_tp_cd") == 'G') {
				sheetObj.CellValue2(Row, "rcv_de_term_cd") = 'Y';
				ComShowCodeMessage("PRI07021" );
				return false;
			}
			if( !validateCYPortLocation( sheetObj, Row, sheetObj.CellValue(Row, "rout_pnt_loc_def_cd"), sheetObj.CellValue(Row, "rout_pnt_loc_tp_cd")) ){
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
 			} 				
			initFicRoute(sheetObj, Row, Col);
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
		} else if (colName == "bse_port_def_cd") {
	        // LOCATION GROUP은 IHC가 포함된 곳에는 들어 갈수 없다.
            if( Value.length != 5 && ComTrim(Value).length != 0){
 	    		sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
 				initFicRoute(sheetObj, Row, Col); 	    		
	    		sheetObj.SelectCell(Row, "bse_port_def_cd", false);	     
            	return;
            }
			if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //point와 비교
				 return;
			}
			initFicRoute(sheetObj, Row, Col);
			checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
		} else if (colName == "prc_trsp_mod_cd") {
			formObj.rout_tgt_row.value = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
			validateCYPortLocation(sheetObj, Row, sheetObj.CellValue(Row, "rout_pnt_loc_def_cd"), sheetObj.CellValue(Row, "rout_pnt_loc_tp_cd"));
		} else if (colName == "org_cy_dor_rt_tp_cd") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);	
			
		} else if (colName == "dest_cy_dor_rt_tp_cd") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);	
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	sheet2_OnChange(sheetObj, Row, Col, Value)
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet4_OnChange(sheetObj, Row, Col, Value) {
	sheet1_OnChange(sheetObj, Row, Col, Value)
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (colName == "rout_pnt_loc_def_cd") {
		if (sheetObj.CellEditable(Row, "rout_pnt_loc_def_cd")) {
			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
			sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value;

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null) {
				sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = rtnVal.cd;
				sheetObj.CellValue(Row, "rout_pnt_loc_def_nm") = rtnVal.nm;
				if (rtnVal.cd.length == 4) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
				} else if (rtnVal.cd.length == 5) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
				}
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet5_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (colName == "rout_pnt_loc_def_cd") {
		if (sheetObj.CellEditable(Row, "rout_pnt_loc_def_cd")) {
			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
			sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=L&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value;

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null) {
				sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") = rtnVal.cd;
				sheetObj.CellValue(Row, "rout_pnt_loc_def_nm") = rtnVal.nm;
				if (rtnVal.cd.length == 4) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "G";
				} else if (rtnVal.cd.length == 5) {
					sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "L";
				}
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (colName == "rout_via_port_def_cd") {
		if (sheetObj.CellEditable(Row, "rout_via_port_def_cd")) {
			var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
			sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_via_port_tp_cd");

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null) {
				sheetObj.CellValue(Row, "rout_via_port_def_cd") = rtnVal.cd;
				sheetObj.CellValue(Row, "rout_via_port_def_nm") = rtnVal.nm;
				if (rtnVal.cd.length == 4) {
					sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "G";
				} else if (rtnVal.cd.length == 5) {
					sheetObj.CellValue2(Row, "rout_via_port_tp_cd") = "L";
				}
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet3_OnPopupClick(sheetObj, Row, Col) {
	sheet2_OnPopupClick(sheetObj, Row, Col);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet4_OnPopupClick(sheetObj, Row, Col) {
	sheet1_OnPopupClick(sheetObj, Row, Col);
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
 * @author 박성수
 * @version 2009.05.01
 */
function sheet6_OnPopupClick(sheetObj, Row, Col) {
	sheet5_OnPopupClick(sheetObj, Row, Col);
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
 * @author 박성수
 * @version 2009.05.01
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			switch (sAction) {

			case IBSEARCH_ASYNC06:
			case IBSEARCH_ASYNC07:
			case IBSEARCH_ASYNC08:
				break;
			default:
				ComOpenWait(true);
			}
		}
		
        var prc_io_bnd_cd = '';
        var rt_tp_cd_val = getRtPnt();
        if(rt_tp_cd_val == 0) {
        	prc_io_bnd_cd = v_origin;
        } else if(rt_tp_cd_val == 3) {
        	prc_io_bnd_cd = v_destination;
        }		
        
		var sender = sheetObjects[6];
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSAVE: // OK
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// VIA를 변경한다.
			var checkPnt = 0;
			var checkStr = funcChkTypeStatus();
			if (checkStr != "X") {
            	checkPnt = 4;
            	var pntSheet = sheetObjects[checkPnt];
            	var viaSheet = sheetObjects[checkPnt-3];//origin via, 또는 dest via
            	if( pntSheet.IsDataModified ){
            		//1. 유효한 via가 달라 졌는지 확인한다.
            		//1.1 먼저 distinct한 base port code를 모은다.
        			 
         			// 현재 입력된 POINT의 유효한 BASE PORT를 모았다.
         			var basePortLocCdList = getPortLocationList(pntSheet ,"bse_port_def_cd");
         			
         			// VIA의 유효 PORT를 모은다.
         			var viaPortLocCdList =  getPortLocationList(viaSheet ,"rout_via_port_def_cd");
         			var strBasePortCd = basePortLocCdList.join("|");
         			var strViaPortCd = viaPortLocCdList.join("|");
            		//2. 만약 유효한 via가 달라졌다면 via를 모두 삭제 또는 삭제 amend를 하고 new로 via를 insert한다.
         			if( strBasePortCd != strViaPortCd ){
         				deleteAndInsertVia(strBasePortCd, viaSheet, basePortLocCdList, 'V', 'O');
         			}
            	}
            	
            	checkPnt = 5;
            	pntSheet = sheetObjects[checkPnt];
            	viaSheet = sheetObjects[checkPnt-3];//origin via, 또는 dest via
            	if( pntSheet.IsDataModified ){
            		//1. 유효한 via가 달라 졌는지 확인한다.
            		//1.1 먼저 distinct한 base port code를 모은다.
        			 
         			// 현재 입력된 POINT의 유효한 BASE PORT를 모았다.
         			var basePortLocCdList = getPortLocationList(pntSheet ,"bse_port_def_cd");
         			
         			// VIA의 유효 PORT를 모은다.
         			var viaPortLocCdList =  getPortLocationList(viaSheet ,"rout_via_port_def_cd");
         			var strBasePortCd = basePortLocCdList.join("|");
         			var strViaPortCd = viaPortLocCdList.join("|");
            		//2. 만약 유효한 via가 달라졌다면 via를 모두 삭제 또는 삭제 amend를 하고 new로 via를 insert한다.
         			if( strBasePortCd != strViaPortCd ){
         				deleteAndInsertVia(strBasePortCd, viaSheet, basePortLocCdList, 'V', 'D' );
         			}
            	}
			}
			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

			var idx = 0;
			for ( var a = 0; a <= 3; a++) {
				var tpColNm;
				var defColNm;
				idx = a;

				if (idx == 0 || idx == 3) {
					tpColNm = "rout_pnt_loc_tp_cd";
					defColNm = "rout_pnt_loc_def_cd";
				} else if (idx == 1 || idx == 2) {
					tpColNm = "rout_via_port_tp_cd";
					defColNm = "rout_via_port_def_cd";
				}

				var sheetObj = null;
				var ficRtTpCd = document.form.fic_rt_tp_cd.value;
    		    if(idx == 0 && (ficRtTpCd == "A")){
    		    	idx = 4;
    		    } else if(idx == 3 && (ficRtTpCd == "A")){
    		    	idx = 5;
    		    }
				sheetObj = sheetObjects[idx];
				for ( var i = sheetObjects[idx].HeaderRows; sheetObjects[idx].RowCount > 0 && i <= sheetObjects[idx].LastRow; i++) {
					if (sheetObjects[idx].CellValue(i, "n1st_ord_ref") == "" || sheetObjects[idx].CellValue(i, "n2nd_ord_ref") == "") {
						var n1stOrdRef;
						if (sheetObjects[idx].CellValue(i, tpColNm) == "G") {
							n1stOrdRef = 1;
						} else if (sheetObjects[idx].CellValue(i, tpColNm) == "L") {
							n1stOrdRef = 2;
						} else {
							n1stOrdRef = 99;
						}
						sheetObjects[idx].CellValue2(i, "n1st_ord_ref") = n1stOrdRef;
						sheetObjects[idx].CellValue2(i, "n2nd_ord_ref") = sheetObjects[idx].CellValue(i, defColNm);
					}
					if (idx == 4 || idx == 5) {
						sheetObjects[idx].CellValue2(i, "bse_port_loc_cd") = sheetObjects[idx].CellValue(i, 'bse_port_def_cd');
					}
            		if(idx == 4) {
            			if(sheetObjects[idx].CellValue(i, 'org_cy_dor_rt_tp_cd') == 'C') {
            				clearSheetRate(sheetObjects[idx], i);
            			}
            		} else if(idx == 5) {
            			if(sheetObjects[idx].CellValue(i, 'dest_cy_dor_rt_tp_cd') == 'C') {
            				clearSheetRate(sheetObjects[idx], i);
            			}
            		}					
				}

				// 소트시 테이블이 다르기때문에 분류함.
				if (idx == 0 || idx == 3 || idx == 4 || idx == 5) {
					sheetObjects[idx].ColumnSort("rout_pnt_seq|qttn_ver_no", "ASC", "ASC|ASC", true);
				} else if (idx == 1 || idx == 2) {
					sheetObjects[idx].ColumnSort("rout_via_seq|qttn_ver_no", "ASC", "ASC|ASC", true);
				}
				var sXml = ComPriSheet2Xml(sheetObjects[idx]);
				dialogArguments.setSheetXml(sXml, a + 5);
			}
			window.returnValue = "O";
			window.close();
			break;

		case IBCLEAR: // 로딩시 코드조회
			var sXml_Origin_Pri = ""; // 이건 기본으로 조회 해야함. -CD02070
			var sXml_Dest_Pri = ""; // 이건 기본으로 조회 해야함. - CD02071

			// 공통 - type
			sheetObjects[0].InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			sheetObjects[1].InitDataCombo(0, "rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			sheetObjects[2].InitDataCombo(0, "rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			sheetObjects[3].InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			sheetObjects[4].InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
			sheetObjects[5].InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);

			// 공통 term
			formObj.f_cmd.value = SEARCH19;
			var ficRtTpCd = document.form.fic_rt_tp_cd.value;
			var svcScpCd = document.form.svc_scp_cd.value;

			// 이건 CY Only인지 IHC인지에 따라 표준코드를 다르게 조회 한다. CY : CD03076 , IHC : CD03078
			// 이건 CY Only인지 IHC인지에 따라 표준코드를 다르게 조회 한다. CY : CD03075 , IHC : CD03077
			if(ficRtTpCd == "A") {
				stdOriginCode = "CD02070";//"CD03078";정석환 과장님 요청으로 CY를 다시 포함 시킴(원복)
				stdDestCode = "CD02071";	
			}else{
				stdOriginCode = "CD03076";
				stdDestCode = "CD03075";
			}
			sXml_Origin_Pri = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + stdOriginCode);
			sXml_Dest_Pri = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + stdDestCode);

			setIBCombo(sheetObjects[0], sXml_Origin_Pri, "rcv_de_term_cd", false, 0, "Y");
			setIBCombo(sheetObjects[4], sXml_Origin_Pri, "rcv_de_term_cd", true, 0);
			setIBCombo(sheetObjects[3], sXml_Dest_Pri, "rcv_de_term_cd", false, 0, "Y");
			setIBCombo(sheetObjects[5], sXml_Dest_Pri, "rcv_de_term_cd", true, 0);

			// 공통 trans mode
			formObj.f_cmd.value = SEARCH19;
			var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
			setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
			setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
			setIBCombo(sheetObjects[4], sXml, "prc_trsp_mod_cd", true, 0);
			setIBCombo(sheetObjects[5], sXml, "prc_trsp_mod_cd", true, 0);

			break;

		case IBSEARCH: // parent sheet에서 조회
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			// ORIGIN, DESTINATION 에는 TERM항목이 필수로 존재하기 때문에 정렬에 포함해야 함
			var sXml6 = dialogArguments.getSheetXml(5);
			var ficRtTpCd = document.form.fic_rt_tp_cd.value;
			var svcScpCd = document.form.svc_scp_cd.value;
			var sheetObj = null;

			if(ficRtTpCd == "A"){
				sheetObj = sheetObjects[4];
			} else {
				sheetObj = sheetObjects[0];
			}
			sheetObj.LoadSearchXml(sXml6);
			if(ficRtTpCd == 'A'){
				var cnt = sheetObj.HeaderRows;
				var rowCnt = sheetObj.RowCount;
				for ( var idx = cnt; idx < cnt + rowCnt; idx++) {
					formObj.rout_tgt_row.value = idx;
					var preStatus = sheetObj.RowStatus(idx);
					searchFicRoute(sheetObj, document.form, sender, v_origin);
					sheetObj.RowStatus(idx) = preStatus;
				}
			}

			var sXml7 = dialogArguments.getSheetXml(6);
			sheetObjects[1].LoadSearchXml(sXml7);

			var sXml8 = dialogArguments.getSheetXml(7);
			sheetObjects[2].LoadSearchXml(sXml8);

			var sXml9 = dialogArguments.getSheetXml(8);
			if(ficRtTpCd == "A"){
				sheetObj = sheetObjects[5]; // 신규 로직을 위한 grid
			} else {
				sheetObj = sheetObjects[3]; // 기존 grid
			}
			sheetObj.LoadSearchXml(sXml9);
			if(ficRtTpCd == 'A') {
				// 신규 로직에 의해서 GROUP CODE와 RATE등을 읽어 들인다.
				var cnt = sheetObj.HeaderRows;
				var rowCnt = sheetObj.RowCount;
				for ( var idx = cnt; idx < cnt + rowCnt; idx++) {
					formObj.rout_tgt_row.value = idx;
					var preStatus = sheetObj.RowStatus(idx);
					searchFicRoute(sheetObj, document.form, sender, v_destination);
					sheetObj.RowStatus(idx) = preStatus;
				}
			}
			break;

		case IBINSERT: // 입력
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			var idx = sheetObj.DataInsert();
			sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
			sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
			sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
			sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
			sheetObj.CellValue(idx, "org_dest_tp_cd") = curOrgDestType;
			sheetObj.CellValue(idx, "rout_seq") = formObj.rout_seq.value;
			if (curPntViaType == "P") {
				sheetObj.CellValue(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq")) + 1;
				var checkStr = funcChkTypeStatus();
				// ihc logic이 있는 쪽은 default로 Door로 한다.
				if (checkStr == "O" && sheetObj.id == "sheet5") {
					sheetObj.CellValue2(idx, "rcv_de_term_cd") = "D";
				} else if (checkStr == "D" && sheetObj.id == "sheet6") {
					sheetObj.CellValue2(idx, "rcv_de_term_cd") = "D";
				} else {
					sheetObj.CellValue2(idx, "rcv_de_term_cd") = "Y";
				}
			} else if (curPntViaType == "V") {
				sheetObj.CellValue(idx, "rout_via_seq") = parseInt(ComPriGetMax(sheetObj, "rout_via_seq")) + 1;
			}

			sheetObj.CellValue(idx, "src_info_cd") = "NW";
			sheetObj.CellValue(idx, "src_info_nm") = "New";
			if (curPntViaType == "P") {
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
			} else if (curPntViaType == "V") {
				sheetObj.SelectCell(idx, "rout_via_port_def_cd", false);
			}

			break;

		case IBDELETE: // 삭제
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			if (sheetObj.CheckedRows("chk") <= 0) {
				sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
			}
			deleteRowCheck(sheetObj, "chk");

			break;

		case IBSEARCH_ASYNC06: // Search FIC Route
			var cyDorRtTpCdVal = '';
			var Row = formObj.rout_tgt_row.value;
			if(prc_io_bnd_cd == v_origin) {
				cyDorRtTpCdVal = sheetObj.CellValue(Row, "org_cy_dor_rt_tp_cd");
			} else if(prc_io_bnd_cd == v_destination) {
				cyDorRtTpCdVal = sheetObj.CellValue(Row, "dest_cy_dor_rt_tp_cd");
			}
			if(cyDorRtTpCdVal == 'D') {		
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				sParam += "&svc_scp_cd=" + sheetObj.CellValue(Row, "svc_scp_cd");
				sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd");
				sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd");
				sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd");
				sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd");
				sParam += "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
				sParam += "&prc_io_bnd_cd=" + prc_io_bnd_cd;
				var sXml = sender.getSearchXml("ESM_PRI_6097GS.do", sParam);
				var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
				sender.LoadSearchXml(sXml);
				if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { // 서버오류
					disableButton("btn_ok");
				} else {
					enableButton("btn_ok");
				}
	
				if (arr != null && arr.length > 0) {
					sheetObj.CellComboItem(Row, "bse_port_def_cd", " |" + arr[0], " |" + arr[1]);
				}
			}
			break;

		case IBSEARCH_ASYNC07: // Search FIC Route
			if (!validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(false);
				return false;
			}
			var cyDorRtTpCdVal = '';
			var Row = formObj.rout_tgt_row.value;
			if(prc_io_bnd_cd == v_origin) {
				cyDorRtTpCdVal = sheetObj.CellValue(Row, "org_cy_dor_rt_tp_cd");
			} else if(prc_io_bnd_cd == v_destination) {
				cyDorRtTpCdVal = sheetObj.CellValue(Row, "dest_cy_dor_rt_tp_cd");
			}
			if(cyDorRtTpCdVal == 'D') {
				formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				sParam += "&svc_scp_cd=" + sheetObj.CellValue(Row, "svc_scp_cd");
				sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd");
				sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd");
				sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd");
				sParam += "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
				sParam += "&prc_io_bnd_cd=" + prc_io_bnd_cd;
				var sXml = sender.getSearchXml("ESM_PRI_6097GS.do", sParam);
				var saveName = "base_port_list|prc_trsp_mod_cd";
				var saveNameArr = saveName.split("|");
	
				var arrDesc = ComPriXml2Array(sXml, saveName);
				sender.LoadSearchXml(sXml);
				if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { // 서버오류
					disableButton("btn_ok");
				} else {
					enableButton("btn_ok");
				}
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.CellValue2(Row, "base_port_list") = arrDesc[0][0];
					sheetObj.CellValue(Row, "prc_trsp_mod_cd") = arrDesc[0][1];
				}
			}
			break;

		case IBSEARCH_ASYNC08: // Search FIC Route
			searchFicRoute(sheetObj, formObj, sender, prc_io_bnd_cd);
			break;
		
		case IBSEARCH_ASYNC09: //Exception Location
			loadExceptionLocation(v_origin);
			break;	
			
		case IBSEARCH_ASYNC10: //Exception Location
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

function searchFicRoute(sheetObj, formObj, sender, prc_io_bnd_cd) {
	formObj.f_cmd.value = SEARCH01;
	var Row = formObj.rout_tgt_row.value;
	var sParam = FormQueryString(formObj);
	var preRowStatus = sheetObj.RowStatus(Row);

	sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd");
	sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd");
	sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd");
	sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd");
	sParam += "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
	sParam += "&prc_io_bnd_cd=" + prc_io_bnd_cd;
	
	var sXml = sender.getSearchXml("ESM_PRI_6097GS.do", sParam);
	var saveName = "fic_rt_use_sts_cd";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);

	sender.LoadSearchXml(sXml);
	if (sender.EtcData(ComWebKey.Trans_Result_Key) == "F") { // 서버오류
		disableButton("btn_ok");
	} else {
		enableButton("btn_ok");
	}
	
	if(prc_io_bnd_cd == v_origin) {
		if(ComIsNull(sheetObj.CellValue(Row, "org_cy_dor_rt_tp_cd"))) {
			sheetObj.CellValue2(Row, "org_cy_dor_rt_tp_cd") = 'C';
		}
	}	else if(prc_io_bnd_cd == v_destination) {
		if(ComIsNull(sheetObj.CellValue(Row, "dest_cy_dor_rt_tp_cd"))) {
			sheetObj.CellValue2(Row, "dest_cy_dor_rt_tp_cd") = 'C';
		}
	}	

	if (arrDesc != null && arrDesc.length > 0) {
		var data = arrDesc[0][0].split("|");
		sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = data[0];
		sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = data[1];
		sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = data[2];
		if(data[3]) {
			if(prc_io_bnd_cd == v_origin) {
				if(sheetObj.CellValue(Row, "org_cy_dor_rt_tp_cd") == 'D') {
					sheetObj.CellValue2(Row, "group_no") = ComTrim(data[3]);
				}
			} else if(prc_io_bnd_cd == v_destination) {
				if(sheetObj.CellValue(Row, "dest_cy_dor_rt_tp_cd") == 'D') {
					sheetObj.CellValue2(Row, "group_no") = ComTrim(data[3]);
				}				
			}
		}		
		if (data[4]) {
			sheetObj.CellValue2(Row, "dr_20ft_amt") = ComTrim(data[4]);
		}
		if (data[5]) {
			sheetObj.CellValue2(Row, "rf_20ft_amt") = ComTrim(data[5]);
		}
		if (data[6]) {
			sheetObj.CellValue2(Row, "dg_20ft_amt") = ComTrim(data[6]);
		}
		if (data[7]) {
			sheetObj.CellValue2(Row, "dr_40ft_amt") = ComTrim(data[7]);
		}
		if (data[8]) {
			sheetObj.CellValue2(Row, "rf_40ft_amt") = ComTrim(data[8]);
		}
		if (data[9]) {
			sheetObj.CellValue2(Row, "dg_40ft_amt") = ComTrim(data[9]);
		}

		if (data[10]) {
			sheetObj.CellValue2(Row, "locl_curr_cd") = ComTrim(data[10]);
		}
		if (data[11]) {
			sheetObj.CellValue2(Row, "dr_locl_20ft_amt") = ComTrim(data[11]);
		}
		if (data[12]) {
			sheetObj.CellValue2(Row, "rf_locl_20ft_amt") = ComTrim(data[12]);
		}
		if (data[13]) {
			sheetObj.CellValue2(Row, "dg_locl_20ft_amt") = ComTrim(data[13]);
		}
		if (data[14]) {
			sheetObj.CellValue2(Row, "dr_locl_40ft_amt") = ComTrim(data[14]);
		}
		if (data[15]) {
			sheetObj.CellValue2(Row, "rf_locl_40ft_amt") = ComTrim(data[15]);
		}
		if (data[16]) {
			sheetObj.CellValue2(Row, "dg_locl_40ft_amt") = ComTrim(data[16]);
		}
	}
	sheetObj.RowStatus(Row) = preRowStatus;
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

	sheetObj.CellValue2(Row, 'locl_curr_cd') = '';		
	sheetObj.CellValue2(Row, 'dr_locl_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_locl_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_locl_20ft_amt') = '';
	sheetObj.CellValue2(Row, 'dr_locl_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'rf_locl_40ft_amt') = '';
	sheetObj.CellValue2(Row, 'dg_locl_40ft_amt') = '';
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
 * @author 박성수
 * @version 2009.05.01
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC11: // Amend
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
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

		if (sheetObj.CellValue(curRow, "qttn_ver_no") != formObj.qttn_ver_no.value) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
		if (sheetObj.CellValue(curRow, "n1st_cmnc_qttn_ver_no") == formObj.qttn_ver_no.value) {
			ComShowCodeMessage("PRI01011");
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC12: // Amend Cancel
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
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

		if (sheetObj.CellValue(curRow, "qttn_ver_no") != formObj.qttn_ver_no.value) {
			ComShowCodeMessage("PRI00313");
			return false;
		}
		if (sheetObj.CellValue(curRow, "n1st_cmnc_qttn_ver_no") != formObj.qttn_ver_no.value) {
			ComShowCodeMessage("PRI01012");
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC13: // Accept
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
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
			if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
				ComShowCodeMessage("PRI01037");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "qttn_ver_no") != formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_qttn_ver_no") != formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;

	case IBSEARCH_ASYNC14: // Accept Cancel
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
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
			if (sheetObj.CellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
				ComShowCodeMessage("PRI01038");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "qttn_ver_no") != formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_qttn_ver_no") != formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;

	case IBSEARCH: // 조회
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		} else {
			return true;
		}
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
			return false;
		}

		return true;
		break;

	case IBSEARCH_ASYNC15: // 라디오버튼 이동시 Validation
		if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
			return false;
		}
		return true;
		break;

	case IBINSERT: // Row Add
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "qttn_ver_no") != formObj.qttn_ver_no.value) {
			ComShowCodeMessage("PRI00313");
			return false;
		}

		return true;
		break;

	case IBDELETE: // Delete
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
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
			if (sheetObj.CellValue(arrCheckedRows[i], "qttn_ver_no") != formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
			if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW" && sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM" && sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM" && sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_qttn_ver_no") == formObj.qttn_ver_no.value) {
				ComShowCodeMessage("PRI00313");
				return false;
			}
		}

		return true;
		break;
	case IBSEARCH_ASYNC07:
		var Row = sheetObj.SelectRow;
		if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == "" || sheetObj.CellValue(Row, "rcv_de_term_cd") == "" || sheetObj.CellValue(Row, "bse_port_def_cd") == "") {
			// ComShowCodeMessage("PRI01001");
			return false;
		}
		return true;
		break;
	}
}


/**
 * Sheet에서 조회 후, 색상이나 Strike등의 스타일을 처리하는 함수.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
 * @author 박성수
 * @version 2009.05.01
 */
function setSheetStyle(sheetObj, idx) {
	if (idx == null || idx < 0) {
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			setLineEnable(sheetObj, i);
		}
	}
}

/**
 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
 * @author 박성수
 * @version 2009.05.01
 */
function setLineEnable(sheetObj, idx) {
	if (idx <= 0) {
		return false;
	}
}

function rtPntOnClick() {
	var curIndex = parseInt(getRtPnt());
	var curIndex2 = parseInt(getRtPntNew());
	if (beforeIndex != curIndex2) {
		if (beforeIndex >= 0 && !validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
			var tmpIndex = beforeIndex;
			if (beforeIndex == 5) {
				tmpIndex = 3;
			} else if (beforeIndex == 4) {
				tmpIndex = 0;
			}
			document.form.rt_pnt[tmpIndex].checked = true;
			return false;
		}

		if (curIndex == 0) {
			curPntViaType = "P";
			curOrgDestType = "O";
		} else if (curIndex == 1) {
			curPntViaType = "V";
			curOrgDestType = "O";
		} else if (curIndex == 2) {
			curPntViaType = "V";
			curOrgDestType = "D";
		} else if (curIndex == 3) {
			curPntViaType = "P";
			curOrgDestType = "D";
		}

		document.form.org_dest_tp_cd.value = curOrgDestType;
		document.form.pnt_via_tp_cd.value = curPntViaType;

		var objs = document.all.item("sheetLayer");

		document.form.rt_pnt[curIndex].focus();

		var ficRtTpCd = document.form.fic_rt_tp_cd.value;
		var svcScpCd = document.form.svc_scp_cd.value;

		objs[curIndex2].style.display = "inline";
		if (beforeIndex >= 0) {
			objs[beforeIndex].style.display = "none";
		}

		beforeIndex = curIndex2;
	}
}

function getRtPnt() {
	for ( var i = 0; i < document.form.rt_pnt.length; i++) {
		if (document.form.rt_pnt[i].checked) {
			return document.form.rt_pnt[i].value;
		}
	}
}

function getRtPntNew() {
	var rtPnt = -1;
	for ( var i = 0; i < document.form.rt_pnt.length; i++) {
		if (document.form.rt_pnt[i].checked) {
			rtPnt = document.form.rt_pnt[i].value;
			break;
		}
	}

	var ficRtTpCd = document.form.fic_rt_tp_cd.value;
    if(rtPnt== 0 && "A"== ficRtTpCd){
    	rtPnt = 4;
    } else if(rtPnt==3 && "A"== ficRtTpCd){
    	rtPnt = 5;
    }
	return rtPnt;
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Change가 발생한 Row를 초기화 한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 김재연
 * @version 2009.05.19
 */
function initFicRoute(sheetObj, Row, Col) {
	var formObj = document.form;
	var qttn_ver_no = formObj.qttn_ver_no.value;

	sheetObj.Redraw = false;
	var saveName = sheetObj.ColSaveName(Col);
	switch (saveName) {

	case "rout_pnt_loc_def_cd":
		sheetObj.CellComboItem(Row, "bse_port_def_cd", " ", " ");
		formObj.rout_tgt_row.value = Row;
		break;
	case "rcv_de_term_cd":
		sheetObj.CellComboItem(Row, "bse_port_def_cd", " ", " ");
		break;
	case "bse_port_def_cd":
		sheetObj.CellValue2(Row, "prc_trsp_mod_cd") = "";
		sheetObj.CellValue2(Row, "rat_ut_cd") = "";
		sheetObj.CellValue2(Row, "prop_frt_rt_amt") = "";
		sheetObj.CellValue2(Row, "fic_gline_rt_amt") = "";
		sheetObj.CellValue2(Row, "diff_with_gl") = "";
		sheetObj.CellValue2(Row, "base_port_list") = "";
		sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = "";
		sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = "";
		sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = "";
		sheetObj.CellValue2(Row, "fic_gline_upd_dt") = "";
		sheetObj.CellValue2(Row, "group_no") = "";
		sheetObj.CellValue2(Row, "dr_20ft_amt") = "";
		sheetObj.CellValue2(Row, "rf_20ft_amt") = "";
		sheetObj.CellValue2(Row, "dg_20ft_amt") = "";
		sheetObj.CellValue2(Row, "dr_40ft_amt") = "";
		sheetObj.CellValue2(Row, "rf_40ft_amt") = "";
		sheetObj.CellValue2(Row, "dg_40ft_amt") = "";

		sheetObj.CellValue2(Row, "locl_curr_cd") = "";
		sheetObj.CellValue2(Row, "dr_locl_20ft_amt") = "";
		sheetObj.CellValue2(Row, "rf_locl_20ft_amt") = "";
		sheetObj.CellValue2(Row, "dg_locl_20ft_amt") = "";
		sheetObj.CellValue2(Row, "dr_locl_40ft_amt") = "";
		sheetObj.CellValue2(Row, "rf_locl_40ft_amt") = "";
		sheetObj.CellValue2(Row, "dg_locl_40ft_amt") = "";

		break;
	}
	sheetObj.Redraw = true;
}

/**
 * bse_port_def_cd의 validation 확인하는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * checkBasePort(sheetObj, Row, Value)
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function checkBasePort(sheetObj, Row, Value) {
	if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") != "" && sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value) {
		ComShowCodeMessage('PRI01020');
		sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
		sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
		sheetObj.SelectCell(Row, "bse_port_def_cd");
		return false;
	}
	return true;
}

/**
 * location code 유효성 확인하는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param (string) cellTpCdNm 선택한 cell의 tp code
 * @param (string) cellDefCdNm 선택한 cell의 def code
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {

	var formObj = document.form;
	var locCd = sheetObj.CellValue(Row, cellDefCdNm);
	var sender = sheetObjects[6];

	// Location
	if (locCd.length == 5 && isLoc) {
		formObj.f_cmd.value = SEARCH05;
		var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + locCd);
		var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");

		if (arrDesc != null && arrDesc.length > 0) {
			sheetObj.CellValue2(Row, cellTpCdNm) = "L";
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = arrDesc[0][1];
			}
		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
			}
		}
	}
	// Group Location
	else if (locCd.length == 4 && isGrpLoc) {
		formObj.f_cmd.value = COMMAND24;
		var sParam = FormQueryString(formObj) + "&cd=" + locCd;
		sParam += "&etc1=" + PRI_RP_SCP;
		var sXml = sender.GetSearchXml("PRICommonGS.do", sParam);
		var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
		if (arrData != null && arrData.length > 0) {
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
		} else {
			sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
		}
	} else {
		locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
		if (cellDefCdNm == "rout_pnt_loc_def_cd") {
			sheetObj.CellValue2(Row, "rout_pnt_loc_def_nm") = "";
		}
	}
}

/**
 * location code 를 리셋하는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param (string) cellTpCdNm 선택한 cell의 tp code
 * @param (string) cellDefCdNm 선택한 cell의 def code
 * @return 없음
 * @author 김재연
 * @version 2009.07.30
 */
function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
	sheetObj.CellValue2(Row, cellTpCdNm) = "";
	sheetObj.CellValue2(Row, cellDefCdNm) = "";
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 김재연
 * @version 2009.05.20
 */
function sheet5_OnSearchEnd(sheetObj, errMsg) {
	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;
	for ( var i = sRow; i < eRow; i++) {
		// base port list 구성
		var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
		var basePortList = sheetObj.CellValue(i, "base_port_list");
		var preStatus = sheetObj.RowStatus(i);

		if (basePortList != "" && (bsePortDefCd != basePortList)) {
			sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList, " |" + basePortList);
		} else {
			sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd, " |" + bsePortDefCd);
		}
		sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;
		sheetObj.RowStatus(i) = preStatus;

	}

}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 김재연
 * @version 2009.05.20
 */
function sheet6_OnSearchEnd(sheetObj, errMsg) {

	var sRow = sheetObj.HeaderRows;
	var eRow = sRow + sheetObj.RowCount;

	for ( var i = sRow; i < eRow; i++) {
		// base port list 구성
		var prcTrspModCd = sheetObj.CellValue(i, "prc_trsp_mod_cd");
		var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
		var basePortList = sheetObj.CellValue(i, "base_port_list");
		var preStatus = sheetObj.RowStatus(i);
		if (basePortList != "" && (bsePortDefCd != basePortList)) {
			sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList, " |" + basePortList);
		} else {
			sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd, " |" + bsePortDefCd);
		}
		sheetObj.CellValue2(i, "prc_trsp_mod_cd") = prcTrspModCd;
		sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;

		sheetObj.RowStatus(i) = preStatus;
	}
}



function getPortLocationList(pntSheet, colName) {
	var sRow = pntSheet.HeaderRows;
	var eRow = sRow + pntSheet.RowCount;
	var basePortLocCdList = [];
	var checkCnt = 0;
	var qttnVerNo = document.form.qttn_ver_no.value;
	for ( var i = sRow; i < eRow; i++) {
		if (pntSheet.RowStatus(i) == "D" || pntSheet.CellValue(i, "qttn_ver_no") != qttnVerNo) {
			continue;
		}
		if (checkCnt != 0) {
			var strBasePortCd = basePortLocCdList.join("|");
			// 같은 것이 있다면 건너 뛴다.
			if (strBasePortCd.indexOf(pntSheet.CellValue(i, colName)) >= 0) {
				continue;
			}
		}
		basePortLocCdList[checkCnt] = pntSheet.CellValue(i, colName);
		checkCnt++;
	}
	// 현재 입력된 POINT의 유효한 BASE PORT를 모았다.
	basePortLocCdList = basePortLocCdList.sort();
	return basePortLocCdList;
}

function deleteAndInsertVia(strBasePortCd, viaSheet, viaPortLocCdList,  inCurPntViaType, inCurOrgDestType){
	var formObj = document.form;
	if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "" || formObj.svc_scp_cd.value == "") {
		return false;
	}
	// 모든 데이터 삭제를 위한 check
	viaSheet.CheckAll2("chk") = 1;
	var sCheckedRows = viaSheet.FindCheckedRow("chk");
	if (sCheckedRows != "") {
		for ( var i = viaSheet.LastRow; viaSheet.RowCount > 0 && i >= viaSheet.HeaderRows; i--) {
			viaSheet.RowStatus(i) = "D";
		}
	}
	
	if(!ComIsNull(strBasePortCd)) {
	    var prePntViaType = curPntViaType;
	    var preOrgDestType = curOrgDestType;
	    
		document.form.org_dest_tp_cd.value = curOrgDestType;
		document.form.pnt_via_tp_cd.value = curPntViaType;
		
		curPntViaType = inCurPntViaType;
		curOrgDestType = inCurOrgDestType;
	
		var viaLeng = viaPortLocCdList.length;
		viaSheet.SelectRow = viaSheet.LastRow;
	
		for ( var i = 0; i < viaLeng; i++) {
			if(!ComIsNull(viaPortLocCdList[i])) {
				doActionIBSheet(viaSheet, formObj, IBINSERT);
				var selRow = viaSheet.SelectRow;
				viaSheet.CellValue(selRow, "rout_via_port_def_cd") = viaPortLocCdList[i];
			}
		}
		
		curPntViaType = prePntViaType;
		curOrgDestType = preOrgDestType;
	}
}

/**
 * Type과 Service Scope에 따른 리턴
 * 
 */
function funcChkTypeStatus() {
	var ficRtTpCd = document.form.fic_rt_tp_cd.value;
	var rsltVal = 'X';
	if(ficRtTpCd == "A") {
		rsltVal = 'A';
	} 
	return rsltVal;
}

/**
 * CY 에 따른 Location 입력 가능 여부를 check한다.
 * 
 */
function validateCYPortLocation(sheetObj, row, value, locType) {
	var formObj = document.form;
	var ficRtTpCd = formObj.fic_rt_tp_cd.value;
	if (sheetObj.id == "sheet5" || sheetObj.id == "sheet6") {
		searchCYDoorLocationCheck( sheetObj, row, value , locType, sheetObj.id);
	} else if (sheetObj.id == "sheet4" || sheetObj.id == "sheet1") {
		if (!searchCYPortLocation(sheetObj, row, value, locType, ficRtTpCd)) {
			return false;
		}
	}
	return true;
}

//IHC  체크 CY/Door 체크 로직
function searchCYDoorLocationCheck( sheetObj, row, value , locType, sheetID){
	var cy_dor_rt_tp_cd = 'C';
	if(sheetObj.CellValue(row, "rcv_de_term_cd") != 'D') {
		var loc_cd = sheetObj.CellValue(row, "rout_pnt_loc_def_cd");
		if(sheetID == 'sheet5') {
			if(orgExptLoc != null && orgExptLoc !== undefined) {
				for(var i =0; i < orgExptLoc.length; i++) {
					if(loc_cd == orgExptLoc[i]) {
						cy_dor_rt_tp_cd = 'D';
						break;
					}
				}
			}
		} else if(sheetID == 'sheet6') {
			if(destExptLoc != null && destExptLoc !== undefined) {
				for(var i =0; i < destExptLoc.length; i++) {
					if(loc_cd == destExptLoc[i]) {
						cy_dor_rt_tp_cd = 'D';
						break;
					}
				}
			}
		} 
		
		if(cy_dor_rt_tp_cd != 'D') {
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH02;
			var sender = sheetObjects[6];
			var sParam = FormQueryString(formObj);		
			sParam += "&loc_type_cd="+locType+"&loc_cd=" + loc_cd;
			
			var sXml = sender.getSearchXml("ESM_PRI_6097GS.do", sParam);
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
		cy_dor_rt_tp_cd = 'D';
	}
	if(sheetID == 'sheet5') {
		sheetObj.CellValue(row, 'org_cy_dor_rt_tp_cd') = cy_dor_rt_tp_cd;
	} else if(sheetID == 'sheet6') {
		sheetObj.CellValue(row, 'dest_cy_dor_rt_tp_cd') = cy_dor_rt_tp_cd;
	}
}

function searchCYPortLocation(sheetObj, row, value, locType, ficRtTpCd) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH02;
	var sender = sheetObjects[6];
	var sParam = FormQueryString(formObj);
	var loc_cd = sheetObj.CellValue(row, "rout_pnt_loc_def_cd");
	
	sParam += "&loc_type_cd=" + locType;
	sParam += "&loc_cd=" + loc_cd;
	var sXml = sender.getSearchXml("ESM_PRI_6097GS.do", sParam);
	var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
	var arrDesc = ComPriXml2Array(sXml, "loc_cd|call_port_flg");
	if (arrDesc != null && arrDesc.length > 0) {
		var flg = false;
		for ( var i = 0; i < arrDesc.length; i++) {
			var locCd = arrDesc[i][0];
			var callPortFlg = arrDesc[i][1];

			if (callPortFlg == "N") {
				ComShowCodeMessage("PRI07013");
				flg = true;
				break;
			}
		}
		if (flg) {
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
	var sender = sheetObjects[6];
	formObj.f_cmd.value = SEARCH26; 	
	var sXml = sender.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + orgDestTpCd);
	var arrDesc = ComPriXml2Array(sXml, "cd");
	if(orgDestTpCd == v_origin) {
		orgExptLoc = arrDesc;
	} else {
		destExptLoc = arrDesc;
	}
}

/**
 * OK Button Click 이벤트 발생시 호출되는 function <br>
 * <br>
 * <b>Example : checkGroupNoCyDoor()</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return boolean
 * @author 김재연
 * @version 2009.05.20
 */
function checkGroupNoCyDoor(inOrgDestTpcd) {
	var x = 0;
	var sheetObj = null;
	if (inOrgDestTpcd == v_origin) {
		sheetObj = sheetObjects[4];
	} else if (inOrgDestTpcd == v_destination) {
		sheetObj = sheetObjects[5];
	} else {
		return true;
	}

	var sRow = 0;
	var eRow = 0;
	var check = true;
	var cyDoorcheck = true;	
	var isMandatory = true;
	var isPrcTrspModCd = true;	
	
	if (sheetObj.IsDataModified) {
		sRow = sheetObj.HeaderRows;
		eRow = sRow + sheetObj.RowCount;
		var preGroupNo = "";
		var currGroupNo = "";
		var checkCnt = 0;
		var preCyDoorRtTpCdVal = "";
		var cyDoorRtTpCdVal = "";
		var qttnVerNo = document.form.qttn_ver_no.value;		
		for ( var i = sRow; i < eRow; i++) {
			if (sheetObj.RowStatus(i) == "D" || sheetObj.CellValue(i, "qttn_ver_no") != qttnVerNo) {
				continue;
			}
			
			if(inOrgDestTpcd == v_origin) {
				cyDoorRtTpCdVal = ComTrim(sheetObj.CellValue(i, "org_cy_dor_rt_tp_cd"));
			} else if(inOrgDestTpcd == v_destination) {
				cyDoorRtTpCdVal = ComTrim(sheetObj.CellValue(i, "dest_cy_dor_rt_tp_cd"));
			}	
						
			currGroupNo = ComTrim(sheetObj.CellValue(i, "group_no"));
			if(!ComIsNull(preCyDoorRtTpCdVal) && preCyDoorRtTpCdVal != cyDoorRtTpCdVal) {
				cyDoorcheck = false;
				break;
			}					
			if(cyDoorRtTpCdVal == 'D') {							
				// N/A는 오직 1개만 갖을수 있다.
				if (currGroupNo == "N/A" && checkCnt != 0) {
					check = false;
					break;
				}
				if (!ComIsNull(preGroupNo) && preGroupNo != currGroupNo) {
					check = false;
					break;
				}
			}
			
			if(cyDoorRtTpCdVal == 'D' && !ComIsNull(sheetObj.CellValue(i, "rout_pnt_loc_def_cd")) && ComIsNull(sheetObj.CellValue(i, "bse_port_def_cd"))) {
				isMandatory = false;
				break;
			}	
			
			if(cyDoorRtTpCdVal == 'D' && !ComIsNull(sheetObj.CellValue(i, "rout_pnt_loc_def_cd")) && ComIsNull(sheetObj.CellValue(i, "prc_trsp_mod_cd"))) {
				isPrcTrspModCd = false;
				break;
			}					
			preGroupNo = currGroupNo;
			preCyDoorRtTpCdVal = cyDoorRtTpCdVal;
			checkCnt++;
		}
	}
	if (!check) {
		ComShowCodeMessage("PRI00308", "check", "the location group no.");
		return check;
	}
	if (!cyDoorcheck) {
		ComShowCodeMessage("PRI07038");
		return cyDoorcheck;
	}
	if(!isMandatory) {
		ComShowCodeMessage("PRI00316", sheetObj.id == 'sheet5' ? "Origin Via." : "Destinaion Via.");
		return isMandatory;
	}	
	
	if(!isPrcTrspModCd) {
		ComShowCodeMessage("PRI00316", sheetObj.id == 'sheet5' ? "Origin Trans Mode." : "Destinaion Trans Mode.");
		return isPrcTrspModCd;
	}	
	return true;
}

/**
 * Add-On Tariff T/F==>  Please check the Term. Couldn’t insert the CY/CY Term in this screen.
 */
function CYDoorCrossCheck() {
	var rsltVal = true;
	if(funcChkTypeStatus() == 'A') {
		var sheetObj5 = sheetObjects[4];
		var qttnVerNo = document.form.qttn_ver_no.value;
		var org_cy_dor_rt_tp_cd = '';
		var dest_cy_dor_rt_tp_cd = '';
		for ( var i = sheetObj5.HeaderRows; i < sheetObj5.HeaderRows + sheetObj5.RowCount; i++) {
			if (sheetObj5.RowStatus(i) == "D" || sheetObj5.CellValue(i, "qttn_ver_no") != qttnVerNo) {
				continue;
			}
			org_cy_dor_rt_tp_cd = sheetObj5.CellValue(i, 'org_cy_dor_rt_tp_cd');
			break;
		}	
		
		var sheetObj6 = sheetObjects[5];	
		for ( var i = sheetObj6.HeaderRows; i < sheetObj6.HeaderRows + sheetObj6.RowCount; i++) {
			if (sheetObj6.RowStatus(i) == "D" || sheetObj6.CellValue(i, "qttn_ver_no") != qttnVerNo) {
				continue;
			}
			dest_cy_dor_rt_tp_cd = sheetObj6.CellValue(i, 'dest_cy_dor_rt_tp_cd');
			break;
		}	
		
		if(org_cy_dor_rt_tp_cd == dest_cy_dor_rt_tp_cd && org_cy_dor_rt_tp_cd == 'C') {
			ComShowCodeMessage("PRI07029");
			rsltVal = false;
		}
	} 
	return rsltVal;
}
