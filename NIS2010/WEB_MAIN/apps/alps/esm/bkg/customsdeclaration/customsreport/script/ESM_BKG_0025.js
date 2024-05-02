/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0025.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0025() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var rdObjects = new Array();
var rdCnt = 0; 

var headCount;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_excel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "1|19|21|23|25|27|30|32|34|36|38", "0");
			break;
		case "btn_listPrint":
			if (sheetObject.RowCount == 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/hanjin/ESM_BKG_0023.do?pgmNo=ESM_BKG_0023" + "&vvd_cd=" + formObject.vvd_cd.value + "&pod_cd=" + formObject.pod_cd.value
					+ "&del_cd=" + formObject.del_cd.value + "&bl_no=" + formObject.sch_bl_no.value, "0023", 1024, 768, false);
			break;
		case "btn_previewPrint":
			if (sheetObject.CheckedRows("chk") == 0) {
				ComShowCodeMessage('BKG00333');
				return;
			}
			bl_no = "";
			var vStart = true;
			var vComma = false;
			for ( var i = 1; i < sheetObject.RowCount + 1; i++) {
				if (vStart) {
					bl_no = "(";
				}
				if (sheetObject.CellValue(i, "chk") == "1") {
					if (vComma) {
						bl_no += ",";
					}
					bl_no += "'" + sheetObject.CellValue(i, "bl_no") + "'";
					vComma = true;
				}
				if (i == sheetObject.RowCount) {
					bl_no += ")";
				}
				vStart = false;
			}
			formObject.com_mrdPath.value = "apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0026.mrd";
			var strArg = "/rv form_blNo[" + bl_no + "] form_ofcCd[" + formObject.ofc_cd.value + "]";
			formObject.com_mrdArguments.value = strArg;
			ComOpenRDPopup();
			break;
		case "btn_fax":
			doActionIBSheet(sheetObject, formObject, MODIFY01);
			break;
		case "btn_mail":
			if (validateForm(sheetObject, formObject, MODIFY02)) {
				// B/L 체크가 여러개이고 mail addr가 여러개의 경우만 팝업
				if (sheetObject.CheckedRows("eml_flg1") + sheetObject.CheckedRows("eml_flg2") + sheetObject.CheckedRows("eml_flg3")
						+ sheetObject.CheckedRows("eml_flg4") + sheetObject.CheckedRows("eml_flg5") > 1) {
					var returnObj = ComOpenPopupWithTarget("/hanjin/ESM_BKG_1061.do?pgmNo=ESM_BKG_1061", 550, 200, "", "none", true);
					if (returnObj == undefined || returnObj == null) break;
					formObject.attach_flg.value = returnObj.attach_flg;
					formObject.attach_max_cnt.value = returnObj.attach_max_cnt;
				 	doActionIBSheet(sheetObject, formObject, MODIFY02);
				} else {
					doActionIBSheet(sheetObject, formObject, MODIFY02);
				}
			}
			break;
		case "btn_anSetup": //Code Validate
			//지금까지 수정한거 저장
			doActionIBSheet(sheetObject, formObject, MULTI);
			var vvd = formObject.vvd_cd.value;
			var pod_cd = formObject.pod_cd.value;
			var del_cd = formObject.del_cd.value;
			var bl_no = formObject.sch_bl_no.value;

			var iWidth = 1040;
			var iHeight = 700;
			var leftpos = (screen.width - iWidth) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - iHeight) / 2;
			if (toppos < 0)
				toppos = 0;
			var autoSearchFlg = "N";
			if (sheetObject.RowCount > 0 || vvd != "" || bl_no != "") autoSearchFlg = "Y";
			var url = "ESM_BKG_1054.do&mainPage=true&pgmNo=ESM_BKG_1054-1&autoSearchFlg="+ autoSearchFlg +"&";
			if (bl_no == "") {
				url = url + "&sch_tp=V" + "&vvd=" + vvd + "&pod_cd=" + pod_cd + "&del_cd=" + del_cd;
			} else {
				url = url + "&sch_tp=B" + "&bl_no=" + bl_no;
			}
			var sFeatures = "status=no, width=" + iWidth + ", height=" + iHeight + ", resizable=yes, scrollbars=yes, left=" + leftpos
					+ ", top=" + toppos;
			var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, "0672", sFeatures);
			winObj.focus();
			break;

		case "btn_history":
			var vvd = formObject.vvd_cd.value;
			var pod_cd = formObject.pod_cd.value;
			var del_cd = formObject.del_cd.value;
			var bl_no = formObject.sch_bl_no.value;

			var iWidth = 1040;
			var iHeight = 700;
			var leftpos = (screen.width - iWidth) / 2;
			if (leftpos < 0)
				leftpos = 0;
			var toppos = (screen.height - iHeight) / 2;
			if (toppos < 0)
				toppos = 0;
			var autoSearchFlg = "N";
			if (sheetObject.RowCount > 0 || vvd != "" || bl_no != "") autoSearchFlg = "Y";
			var url = "ESM_BKG_0001.do&pgmNo=ESM_BKG_0001&autoSearchFlg="+ autoSearchFlg +"&";
			if (bl_no == "") {
				url = url + "&sch_tp=V" + "&vvd=" + vvd + "&pod_cd=" + pod_cd + "&del_cd=" + del_cd;
			} else {
				url = url + "&sch_tp=B" + "&bl_no=" + bl_no;
			}
			var sFeatures = "status=no, width=" + iWidth + ", height=" + iHeight + ", resizable=yes, scrollbars=yes, left=" + leftpos
					+ ", top=" + toppos;
			var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, "0001", sFeatures);
			winObj.focus();
			break;
		case "btn_arrival":
			var vChkRows = sheetObject.FindCheckedRow("chk");
			if (vChkRows == "") {
				ComShowCodeMessage("BKG00333");
				return;
			} else {
				var iRow = vChkRows.split("|")[0];
				var param = "?pgmNo=ESM_BKG_0020&vvd_cd=" + formObject.vvd_cd.value + "&eta_dt=" + sheetObject.CellValue(iRow, "eta_dt");
				ComOpenWindowCenter("/hanjin/ESM_BKG_0020.do" + param, "0020", 450, 220, true);
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
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
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	// 2017.10.20 한국, 베트남 이외 팩스 전송 안되게 처리
	if(!(strCnt_cd == "KR" || strCnt_cd == "VN")){
		tabObjects[0].TabEnable(1) = false;
	}
	
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param tab_obj 탭오브젝트
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * @param tabObj 탭오브젝트
 * @param tabNo 탭번호
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Pick up Data", -1);
			InsertTab(cnt++, "Fax", -1);
			InsertTab(cnt++, "E-Mail", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param tabObj 탭오브젝트
 * @param nItem 탭번호
 */
function tab1_OnChange(tabObj, nItem) {
	with (sheetObjects[0]) {
		switch (nItem) {
		case 0:
			ComBtnEnable("btn_arrival");
			ComBtnDisable("btn_fax");
			ComBtnDisable("btn_mail");

			ColHidden("por_cd") = false;
			ColHidden("pol_cd") = false;
			ColHidden("pod_cd") = false;
			ColHidden("del_cd") = false;
			ColHidden("hub_loc_cd") = false;
			ColHidden("trsp_mod_id") = false;
			ColHidden("it_chk") = false;
			ColHidden("bl_cntr_cnt") = false;
			ColHidden("it_no_cntr_cnt") = false;
			ColHidden("p_mib_no") = false;
			ColHidden("ibd_loc_gds_desc") = false;
			ColHidden("avc_note_tp_id") = false;
			ColHidden("fax_ofc_cd") = false;
			// ColHidden("mtch_flg") = false;
			// ColHidden("cust_seq") = false;
			// ColHidden("cust_nm") = false;

			ColHidden("fax_flg1") = true;
			ColHidden("fax_no1") = true;
			ColHidden("fax_flg2") = true;
			ColHidden("fax_no2") = true;
			ColHidden("fax_flg3") = true;
			ColHidden("fax_no3") = true;
			ColHidden("fax_flg4") = true;
			ColHidden("fax_no4") = true;
			ColHidden("fax_flg5") = true;
			ColHidden("fax_no5") = true;
			ColHidden("fax_snd_dt") = true;
			ColHidden("fax_snd_usr_id") = true;
			ColHidden("fax_snd_usr_nm") = true;

			ColHidden("eml_flg1") = true;
			ColHidden("ntc_eml1") = true;
			ColHidden("eml_flg2") = true;
			ColHidden("ntc_eml2") = true;
			ColHidden("eml_flg3") = true;
			ColHidden("ntc_eml3") = true;
			ColHidden("eml_flg4") = true;
			ColHidden("ntc_eml4") = true;
			ColHidden("eml_flg5") = true;
			ColHidden("ntc_eml5") = true;
			ColHidden("eml_snd_dt") = true;
			ColHidden("eml_snd_usr_id") = true;
			ColHidden("eml_snd_usr_nm") = true;
			break;

		case 1:
			ComBtnDisable("btn_arrival");
			ComBtnEnable("btn_fax");
			ComBtnDisable("btn_mail");

			ColHidden("por_cd") = true;
			ColHidden("pol_cd") = true;
			ColHidden("pod_cd") = true;
			ColHidden("del_cd") = true;
			ColHidden("hub_loc_cd") = true;
			ColHidden("trsp_mod_id") = true;
			ColHidden("it_chk") = true;
			ColHidden("bl_cntr_cnt") = true;
			ColHidden("it_no_cntr_cnt") = true;
			ColHidden("p_mib_no") = true;
			ColHidden("ibd_loc_gds_desc") = true;
			ColHidden("avc_note_tp_id") = true;
			ColHidden("fax_ofc_cd") = true;

			ColHidden("fax_flg1") = false;
			ColHidden("fax_no1") = false;
			ColHidden("fax_flg2") = false;
			ColHidden("fax_no2") = false;
			ColHidden("fax_flg3") = false;
			ColHidden("fax_no3") = false;
			ColHidden("fax_flg4") = false;
			ColHidden("fax_no4") = false;
			ColHidden("fax_flg5") = false;
			ColHidden("fax_no5") = false;
			ColHidden("fax_snd_dt") = false;
			ColHidden("fax_snd_usr_id") = false;
			ColHidden("fax_snd_usr_nm") = false;

			ColHidden("eml_flg1") = true;
			ColHidden("ntc_eml1") = true;
			ColHidden("eml_flg2") = true;
			ColHidden("ntc_eml2") = true;
			ColHidden("eml_flg3") = true;
			ColHidden("ntc_eml3") = true;
			ColHidden("eml_flg4") = true;
			ColHidden("ntc_eml4") = true;
			ColHidden("eml_flg5") = true;
			ColHidden("ntc_eml5") = true;
			ColHidden("eml_snd_dt") = true;
			ColHidden("eml_snd_usr_id") = true;
			ColHidden("eml_snd_usr_nm") = true;

			break;

		case 2:
			ComBtnDisable("btn_arrival");
			ComBtnDisable("btn_fax");
			ComBtnEnable("btn_mail");

			ColHidden("por_cd") = true;
			ColHidden("pol_cd") = true;
			ColHidden("pod_cd") = true;
			ColHidden("del_cd") = true;
			ColHidden("hub_loc_cd") = true;
			ColHidden("trsp_mod_id") = true;
			ColHidden("it_chk") = true;
			ColHidden("bl_cntr_cnt") = true;
			ColHidden("it_no_cntr_cnt") = true;
			ColHidden("p_mib_no") = true;
			ColHidden("ibd_loc_gds_desc") = true;
			ColHidden("avc_note_tp_id") = true;
			ColHidden("fax_ofc_cd") = true;

			ColHidden("fax_flg1") = true;
			ColHidden("fax_no1") = true;
			ColHidden("fax_flg2") = true;
			ColHidden("fax_no2") = true;
			ColHidden("fax_flg3") = true;
			ColHidden("fax_no3") = true;
			ColHidden("fax_flg4") = true;
			ColHidden("fax_no4") = true;
			ColHidden("fax_flg5") = true;
			ColHidden("fax_no5") = true;
			ColHidden("fax_snd_dt") = true;
			ColHidden("fax_snd_usr_id") = true;
			ColHidden("fax_snd_usr_nm") = true;

			ColHidden("eml_flg1") = false;
			ColHidden("ntc_eml1") = false;
			ColHidden("eml_flg2") = false;
			ColHidden("ntc_eml2") = false;
			ColHidden("eml_flg3") = false;
			ColHidden("ntc_eml3") = false;
			ColHidden("eml_flg4") = false;
			ColHidden("ntc_eml4") = false;
			ColHidden("eml_flg5") = false;
			ColHidden("ntc_eml5") = false;
			ColHidden("eml_snd_dt") = false;
			ColHidden("eml_snd_usr_id") = false;
			ColHidden("eml_snd_usr_nm") = false;

			break;
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 400;

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
			InitRowInfo(1, 1, 4, 100);

			var HeadTitle1 = "|Sel.|Seq.|B/L NO.|POR|POL|POD|DEL|HUB|T/M|IT CHK|ACI|BKG|P/MIB No.|LOCATION OF GOODS|A/N Type|Office|Code\nValidate|Code|Consignee Name|"
					+ "|Consignee||Consignee#2||Broker/Agent #1||Broker/Agent #2||A. Notify|Result Date|Sent ID|User Name|"
					+ "|Consignee||Consignee#2||Broker/Agent #1||Broker/Agent #2||A. Notify|Result Date|Sent ID|User Name"

			headCount = ComCountHeadTitle(HeadTitle1) + 26;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다[소트 ][컬럼 이동 ][전체 CheckBox][컬럼 너비 변경][행 이동 가능 ][셀의 모양의 입체]
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			// InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "hub_loc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "trsp_mod_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "it_chk", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_cntr_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "it_no_cntr_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "p_mib_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, true, "ibd_loc_gds_desc", false, "", dfNone, 0, true, true, 100);
			// COMBO
			InitDataProperty(0, cnt++, dtCombo, 120, daLeft, true, "avc_note_tp_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "fax_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "chk_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cust_seq", false, "", dfNone, 0, false, true);
			// Consignee Name
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "cust_nm", false, "", dfNone, 0, false, true);
			// Fax No
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "fax_flg1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fax_no1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "fax_flg2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fax_no2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "fax_flg3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "fax_no3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "fax_flg4", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "fax_no4", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "fax_flg5", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fax_no5", false, "", dfNone, 0, true, true);
			// Result Date
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "fax_snd_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "fax_snd_usr_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "fax_snd_usr_nm", false, "", dfNone, 0, false, true);
			// E-mail
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "eml_flg1", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "ntc_eml1", false, "", dfEngKey, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "eml_flg2", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "ntc_eml2", false, "", dfEngKey, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "eml_flg3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, true, "ntc_eml3", false, "", dfEngKey, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "eml_flg4", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, true, "ntc_eml4", false, "", dfEngKey, 0, true, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, true, "eml_flg5", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "ntc_eml5", false, "", dfEngKey, 0, true, true);
			// Result Date
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eml_snd_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "eml_snd_usr_id", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 90, daLeft, true, "eml_snd_usr_nm", false, "", dfNone, 0, false, true);
			// HIDDEN
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "chk_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_snd_flg1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_snd_flg2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_snd_flg3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_snd_flg4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_snd_flg5", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_snd_flg1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_snd_flg2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_snd_flg3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_snd_flg4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_snd_flg5", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cust_cntc_tp_cd1", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cust_cntc_tp_cd2", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cust_cntc_tp_cd3", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cust_cntc_tp_cd4", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cust_cntc_tp_cd5", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eta_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "input_vvd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "input_eta_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "val_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "bkg_cust_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "eml_proc_sts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "fax_proc_sts_cd", false, "", dfNone, 0, false, true);

			InitDataValid(0, "p_mib_no", vtEngUpOther, "1234567890");

			InitDataValid(0, "fax_no1", vtNumericOther, "-");
			InitDataValid(0, "fax_no2", vtNumericOther, "-");
			InitDataValid(0, "fax_no3", vtNumericOther, "-");
			InitDataValid(0, "fax_no4", vtNumericOther, "-");
			InitDataValid(0, "fax_no5", vtNumericOther, "-");
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	formObj.f_cmd.value = sAction;
	switch (sAction) {
	case INIT:
		//AN Type 콤보
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0025GS.do", FormQueryString(formObj));
		var arrCombo = ComXml2ComboString(sXml, "attr_ctnt2", "attr_ctnt1");
		sheetObj.InitDataCombo(0, "avc_note_tp_id", arrCombo[0], arrCombo[1]);
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0025GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		break;
	case SEARCH01: //Customer Code 넣고 Name 가져오기
		var param = FormQueryString(formObj) + "&cust_seq=" + sheetObj.CellValue(sheetObj.SelectRow, "cust_seq");
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0025GS.do", param);
		sheetObj.CellValue2(sheetObj.SelectRow, "cust_nm") = ComGetEtcData(sXml, "cust_nm");
		break;
	case MODIFY: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			if (sheetObj.IsDataModified) {
				sheetObj.DoSave("ESM_BKG_0025GS.do", FormQueryString(formObj), -1, false);
			} else {
				ComShowCodeMessage('BKG00743');
			}
			ComOpenWait(false);
		}
		break;
	case MULTI: //Code Validate
		if (sheetObj.IsDataModified) {
			formObj.f_cmd.value = MODIFY;
			sheetObj.GetSaveXml("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
		}
		break;
	case MODIFY01: //Fax
		if (validateForm(sheetObj, formObj, sAction)) {
			var sXml;
			ComOpenWait(true);
			if (sheetObj.IsDataModified) {
				// 변경된게 있으면 일단 저장
				formObj.f_cmd.value = MODIFY;
				sXml = sheetObj.GetSaveXml("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
			}
			if (ComBkgErrMessage(sheetObj, sXml)) {
				for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
					if (sheetObj.CellValue(i, "fax_flg1") + sheetObj.CellValue(i, "fax_flg2") + sheetObj.CellValue(i, "fax_flg3")
							+ sheetObj.CellValue(i, "fax_flg4") + sheetObj.CellValue(i, "fax_flg5") > 0) {
						sheetObj.RowStatus(i) = "U";
					} else {
						sheetObj.RowStatus(i) = "R";
					}
				}
				// 팩스전송
				formObj.f_cmd.value = MODIFY01;
				sXml = sheetObj.GetSaveXml("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.loadSaveXml(sXml)
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
			}
			ComOpenWait(false);
		}
		break;
	case MODIFY02: //Mail
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			var sXml;
			if (sheetObj.IsDataModified) {
				// 변경된게 있으면 일단 저장
				formObj.f_cmd.value = MODIFY;
				sXml = sheetObj.GetSaveXml("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
			}
			if (ComBkgErrMessage(sheetObj, sXml)) {
				for ( var i = 1; i < sheetObj.RowCount + 1; i++) {
					if (sheetObj.CellValue(i, "eml_flg1") + sheetObj.CellValue(i, "eml_flg2") + sheetObj.CellValue(i, "eml_flg3")
							+ sheetObj.CellValue(i, "eml_flg4") + sheetObj.CellValue(i, "eml_flg5") > 0) {
						sheetObj.RowStatus(i) = "U";
					} else {
						sheetObj.RowStatus(i) = "R";
					}
				}
				// 메일전송
				formObj.f_cmd.value = MODIFY02;
				sXml = sheetObj.GetSaveXml("ESM_BKG_0025GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false));
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.loadSaveXml(sXml)
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
			}
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * sheet1 조회후실행
 * @param sheetObj 시트오브젝트
 * @param ErrMsg 에러메시지
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for (i = 1; i < RowCount + 1; i++) {
			//전체 체크박스 Disabled
			if (CellValue(i, "chk_flg") == 'N') {
				RowBackColor(i) = RgbColor(255, 236, 208);
				CellEditable(i, "fax_flg1") = false;
				CellEditable(i, "fax_flg2") = false;
				CellEditable(i, "fax_flg3") = false;
				CellEditable(i, "fax_flg4") = false;
				CellEditable(i, "fax_flg5") = false;
				CellEditable(i, "eml_flg1") = false;
				CellEditable(i, "eml_flg2") = false;
				CellEditable(i, "eml_flg3") = false;
				CellEditable(i, "eml_flg4") = false;
				CellEditable(i, "eml_flg5") = false;
			} else {
				//팩스 체크박스 Disabled(Do Not Send)
				if (CellValue(i, "fax_snd_flg1") == 'N') {
					CellEditable(i, "fax_flg1") = false;
				}
				if (CellValue(i, "fax_snd_flg2") == 'N') {
					CellEditable(i, "fax_flg2") = false;
				}
				if (CellValue(i, "fax_snd_flg3") == 'N') {
					CellEditable(i, "fax_flg3") = false;
				}
				if (CellValue(i, "fax_snd_flg4") == 'N') {
					CellEditable(i, "fax_flg4") = false;
				}
				if (CellValue(i, "fax_snd_flg5") == 'N') {
					CellEditable(i, "fax_flg5") = false;
				}
				//메일 체크박스 Disabled(Do Not Send)
				if (CellValue(i, "eml_snd_flg1") == 'N') {
					CellEditable(i, "eml_flg1") = false;
				}
				if (CellValue(i, "eml_snd_flg2") == 'N') {
					CellEditable(i, "eml_flg2") = false;
				}
				if (CellValue(i, "eml_snd_flg3") == 'N') {
					CellEditable(i, "eml_flg3") = false;
				}
				if (CellValue(i, "eml_snd_flg4") == 'N') {
					CellEditable(i, "eml_flg4") = false;
				}
				if (CellValue(i, "eml_snd_flg5") == 'N') {
					CellEditable(i, "eml_flg5") = false;
				}
			}
			// Target B/L No.의 BKG Container 수와 ACI에 전송된 Container수 Unmatch : 노란색
			if (CellValue(i, "bl_cntr_cnt") != CellValue(i, "it_no_cntr_cnt")) {
				CellBackColor(i, "bl_cntr_cnt") = RgbColor(255, 255, 204);
				CellBackColor(i, "it_no_cntr_cnt") = RgbColor(255, 255, 204);
			}
			if (CellValue(i, "p_mib_no") != "") {
				if (CellValue(i, "p_mib_no").substring(CellValue(i, "p_mib_no").length - 3) == "...") {
					CellEditable(i, "p_mib_no") = false;
				}
			}
			// Send 결과에 따른 글자색(성공:파랑, 실패:빨강, 진행중:꽃분홍)
			if (CellValue(i, "eml_proc_sts_cd") == "3") {
				// 성공
				CellFontColor(i, "eml_snd_dt") = RgbColor(0,0,255);
				CellFontColor(i, "eml_snd_usr_id") = RgbColor(0,0,255);
				CellFontColor(i, "eml_snd_usr_nm") = RgbColor(0,0,255);
			} else if (CellValue(i, "eml_proc_sts_cd") == "4") {
				// 실패
				CellFontColor(i, "eml_snd_dt") = RgbColor(255,0,0);
				CellFontColor(i, "eml_snd_usr_id") = RgbColor(255,0,0);
				CellFontColor(i, "eml_snd_usr_nm") = RgbColor(255,0,0);
			} else {
				// 진행중
				CellFontColor(i, "eml_snd_dt") = RgbColor(255,0,192);
				CellFontColor(i, "eml_snd_usr_id") = RgbColor(255,0,192);
				CellFontColor(i, "eml_snd_usr_nm") = RgbColor(255,0,192);
			}
			if (CellValue(i, "fax_proc_sts_cd") == "5") {
				// 성공
				CellFontColor(i, "fax_snd_dt") = RgbColor(0,0,255);
				CellFontColor(i, "fax_snd_usr_id") = RgbColor(0,0,255);
				CellFontColor(i, "fax_snd_usr_nm") = RgbColor(0,0,255);
			} else if (CellValue(i, "fax_proc_sts_cd") == "6") {
				// 실패
				CellFontColor(i, "fax_snd_dt") = RgbColor(255,0,0);
				CellFontColor(i, "fax_snd_usr_id") = RgbColor(255,0,0);
				CellFontColor(i, "fax_snd_usr_nm") = RgbColor(255,0,0);
			} else {
				// 진행중
				CellFontColor(i, "fax_snd_dt") = RgbColor(255,0,192);
				CellFontColor(i, "fax_snd_usr_id") = RgbColor(255,0,192);
				CellFontColor(i, "fax_snd_usr_nm") = RgbColor(255,0,192);
			}
		}
	}
}

/**
 * 첫번째 체크박스 클릭 시 
 * @param sheetObj 시트오브젝트
 * @param row Row Index
 * @param col Column Index
 */
function sheet1_OnBeforeCheck(sheetObj, row, col) {
	var value = "";
	if (col == 1) {
		if (sheetObj.CellValue(row, "chk") == "0") {
			sheetObj.CellValue2(row, "fax_flg1") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg1"), value)
			sheetObj.CellValue2(row, "fax_flg2") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg2"), value)
			sheetObj.CellValue2(row, "fax_flg3") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg3"), value)
			sheetObj.CellValue2(row, "fax_flg4") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg4"), value)
			sheetObj.CellValue2(row, "fax_flg5") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg5"), value)
			sheetObj.CellValue2(row, "eml_flg1") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg1"), value)
			sheetObj.CellValue2(row, "eml_flg2") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg2"), value)
			sheetObj.CellValue2(row, "eml_flg3") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg3"), value)
			sheetObj.CellValue2(row, "eml_flg4") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg4"), value)
			sheetObj.CellValue2(row, "eml_flg5") = "1";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg5"), value)
		} else {
			sheetObj.CellValue2(row, "fax_flg1") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg1"), value)
			sheetObj.CellValue2(row, "fax_flg2") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg2"), value)
			sheetObj.CellValue2(row, "fax_flg3") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg3"), value)
			sheetObj.CellValue2(row, "fax_flg4") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg4"), value)
			sheetObj.CellValue2(row, "fax_flg5") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("fax_flg5"), value)
			sheetObj.CellValue2(row, "eml_flg1") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg1"), value)
			sheetObj.CellValue2(row, "eml_flg2") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg2"), value)
			sheetObj.CellValue2(row, "eml_flg3") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg3"), value)
			sheetObj.CellValue2(row, "eml_flg4") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg4"), value)
			sheetObj.CellValue2(row, "eml_flg5") = "0";
			sheet1_OnChange(sheetObj, row, sheetObj.SaveNameCol("eml_flg5"), value)
		}
	}
}

/**
 * 헤더를 클릭한 경우
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	// 헤더를 클릭한 경우
	if (sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol) == "Sel.") {
		// 체크를 한 경우
		if (sheetObj.CheckAll("chk") == 0) {
			sheetObj.CheckAll("fax_flg1") = "1";
			sheetObj.CheckAll("fax_flg2") = "1";
			sheetObj.CheckAll("fax_flg3") = "1";
			sheetObj.CheckAll("fax_flg4") = "1";
			sheetObj.CheckAll("fax_flg5") = "1";
			sheetObj.CheckAll("eml_flg1") = "1";
			sheetObj.CheckAll("eml_flg2") = "1";
			sheetObj.CheckAll("eml_flg3") = "1";
			sheetObj.CheckAll("eml_flg4") = "1";
			sheetObj.CheckAll("eml_flg5") = "1";
		} else {
			sheetObj.CheckAll("fax_flg1") = "0";
			sheetObj.CheckAll("fax_flg2") = "0";
			sheetObj.CheckAll("fax_flg3") = "0";
			sheetObj.CheckAll("fax_flg4") = "0";
			sheetObj.CheckAll("fax_flg5") = "0";
			sheetObj.CheckAll("eml_flg1") = "0";
			sheetObj.CheckAll("eml_flg2") = "0";
			sheetObj.CheckAll("eml_flg3") = "0";
			sheetObj.CheckAll("eml_flg4") = "0";
			sheetObj.CheckAll("eml_flg5") = "0";
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj 시트오브젝트
 * @param formObj 폼오브젝트
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		if (ComIsNull(formObj.sch_bl_no) && (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pod_cd))) {
			ComShowCodeMessage('BKG00626', '(VVD and POD) or (B/L No.)');
			return false;
		}
		break;
	case MODIFY01: //Fax
		if (sheetObj.CheckedRows("fax_flg1") + sheetObj.CheckedRows("fax_flg2") + sheetObj.CheckedRows("fax_flg3")
				+ sheetObj.CheckedRows("fax_flg4") + sheetObj.CheckedRows("fax_flg5") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		break;
	case MODIFY02: //Mail
		if (sheetObj.CheckedRows("eml_flg1") + sheetObj.CheckedRows("eml_flg2") + sheetObj.CheckedRows("eml_flg3")
				+ sheetObj.CheckedRows("eml_flg4") + sheetObj.CheckedRows("eml_flg5") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		break;
	}
	return true;
}

/**
 * 셀의 값이 바뀌었을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row Row Index
 * @param col Col Index
 * @param value 변경된 값
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "cust_seq") {
		if (sheetObj.CellValue(row, "cust_seq").length < 8) {
			ComShowCodeMessage("BKG00381");
			sheetObj.SelectCell(row, "cust_seq");
			return false;
		}
		doActionIBSheet(sheetObj, document.form, SEARCH01);
	}
	if (sheetObj.ColSaveName(col) == "fax_no1" || sheetObj.ColSaveName(col) == "fax_no2" || sheetObj.ColSaveName(col) == "fax_no3"
			|| sheetObj.ColSaveName(col) == "fax_no4" || sheetObj.ColSaveName(col) == "fax_no5") {
		if (sheetObj.CellEditable(row, col - 1)) {
			if (sheetObj.CellValue(row, col) != "") {
				sheetObj.CellValue2(row, col - 1) = "1";
			} else {
				sheetObj.CellValue2(row, col - 1) = "0";
			}
		}
	}
	if (sheetObj.ColSaveName(col) == "ntc_eml1" || sheetObj.ColSaveName(col) == "ntc_eml2" || sheetObj.ColSaveName(col) == "ntc_eml3"
			|| sheetObj.ColSaveName(col) == "ntc_eml4" || sheetObj.ColSaveName(col) == "ntc_eml5") {
		if (sheetObj.CellValue(row, col) != "" && !ComIsEmailAddr(sheetObj.CellValue(row, col))) {
			ComShowCodeMessage("BKG40021", sheetObj.CellValue(row, col));
			sheetObj.SelectCell(row, col);
			return;
		}
		if (sheetObj.CellEditable(row, col - 1)) {
			if (sheetObj.CellValue(row, col) != "") {
				sheetObj.CellValue2(row, col - 1) = "1";
			} else {
				sheetObj.CellValue2(row, col - 1) = "0";
			}
		}
	}
	if (sheetObj.ColSaveName(col) == "fax_flg1" || sheetObj.ColSaveName(col) == "fax_flg2" || sheetObj.ColSaveName(col) == "fax_flg3"
			|| sheetObj.ColSaveName(col) == "fax_flg4" || sheetObj.ColSaveName(col) == "fax_flg5"
			|| sheetObj.ColSaveName(col) == "eml_flg1" || sheetObj.ColSaveName(col) == "eml_flg2"
			|| sheetObj.ColSaveName(col) == "eml_flg3" || sheetObj.ColSaveName(col) == "eml_flg4"
			|| sheetObj.ColSaveName(col) == "eml_flg5") {
		if (sheetObj.CellValue(row, col + 1) == "") {
			sheetObj.CellValue2(row, col) = "0";
		}
	}
}

/**
 * Arrival Info. 버튼 클릭시
 * @param vvd VVD
 * @param eta ETA
 * @param antype ANTYPE
 */
function setAnType(vvd, eta, antype) {
	for ( var iChk = 1; iChk < sheetObjects[0].RowCount + 1; iChk++) {
		if (sheetObjects[0].CellValue(iChk, "chk") == "1" && sheetObjects[0].CellValue(iChk, "chk_flg") == "Y") {
			if (vvd != "") {
				sheetObjects[0].CellValue2(iChk, "input_vvd_cd") = vvd;
			}
			if (eta != "") {
				sheetObjects[0].CellValue2(iChk, "input_eta_dt") = eta;
			}
			if (antype != "") {
				sheetObjects[0].CellValue2(iChk, "avc_note_tp_id") = antype;
			}
		}
	}
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	if (col > 2) {
		var bl_no = sheetObj.CellValue(row, "bl_no");
		ComOpenWindowCenter("/hanjin/ESM_BKG_0029.do?pgmNo=ESM_BKG_0029_2&type=edit&bl_no=" + bl_no, "0029", 1020, 660);
	}
}

/**
 * 조회조건 입력 후 자동으로 다음항목으로 이동
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 조회조건 입력 후 엔터키 누르면 자동조회
 */
function obj_KeyDown() {
	var srcName = window.event.srcElement.getAttribute("name");
	switch (srcName) {
	case "vvd_cd":
	case "pod_cd":
	case "del_cd":
	case "sch_bl_no":
	case "mtch_flg":
		ComKeyEnter();
		break;
	}
}