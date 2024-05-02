/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0127.js
 *@FileTitle  : ESM_BKG_0127
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/09
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_save": // update
			doActionIBSheet(sheetObject, formObject, MODIFY01);
			break;
		case "btn_datadl": // insert
			doActionIBSheet(sheetObject, formObject, MODIFY);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, MULTI05);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록<br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화<br>
 * body 태그의 onLoad 이벤트핸들러 구현<br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("click", "obj_click", document.form);
}

/**
 * handling buttons on loading
 */
function SetButtonStatus(){
		// Customs Common Code 테이블의 EU Staff 인 경우에만 Data Delete 버튼 활성화
		if(sheetObjects[0].GetCellValue(1, "na_stf_flg")=="Y"){
			document.getElementById("btn_delete").style.display='';
		}else{
			document.getElementById("btn_delete").style.display='none';
		}
	}

/**
 * 시트 초기설정값, 헤더 정의<br>
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			 var HeadTitle=  "|Seq|Sel.|B/L No|BKG No.|DEL CD|I/F|DUV|Manifest\nID" +
					  "|Shipper|Shipper CNPJ&CPF In\nBKG>Import info.|Shipper  CNPJ&CPF In\nBr Manifest|Consignee|Consignee CNPJ&CPF In\nBKG>Import info.|Consignee CNPJ&CPF In\nBr Manifest|Notify|Notify CNPJ&CPF In\nBKG>Import info.|Notify CNPJ&CPF In\nBr Manifest" +
					  "|DDE/SD|Hide|Container|Package|Package|Weight|Weight|Measure|Measure|NCM Code|NCM Code|NCM Multi Flag|NCM Multi Code" +
					  "|Description for Customs|Booking Commodity|hidden|hidden|hidden|hidden|search_bkg_cgo_tp_cd|OFT|OTH|diff_shpr_tax_no_flag|diff_cnee_tax_no_flag|diff_ntfy_tax_no_flag|CUST_TO_ORD_FLG|na_stf_flg";
			  var headCount=ComCountHeadTitle(HeadTitle);

			  SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

			  var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];

			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						   {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_group" },
						   {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check",                  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bl_no",                  Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",                 Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"del_cd",                 Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"if_flag",                Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"br_duv",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
						   {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"br_mid",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
						   {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"shipper_cust_nm",        Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ob_shpr_tax_no",         Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"shpr_tax_no",            Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"consignee_cust_nm",      Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ob_cnee_tax_no",         Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cnee_tax_no",            Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"notify_cust_nm",         Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ob_ntfy_tax_no",         Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_tax_no",            Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
						   {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"brz_decl_no",            Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
						   {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hide_check",             Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",                Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",                Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",              Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"weight",                 Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",              Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"measure",                Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",             Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

						   {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ncm_no",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
						   {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ncm_multi_pop",          Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ncm_multi_flg",          Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ncm_multi_no",           Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

						   {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cstms_desc",             Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"booking_cmdt_nm",        Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_seq",            Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"vvd_cd",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"pol_cd",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd",                 Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"search_bkg_cgo_tp_cd",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"oft",                    Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cap",                    Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"diff_shpr_tax_no_flag",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"diff_cnee_tax_no_flag",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"diff_ntfy_tax_no_flag",  Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cust_to_ord_flg",        Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						   {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"na_stf_flg",             Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
						  ];
			 InitColumns(cols);

			 ComResizeSheet(sheetObj);
			 SetEditable(1);
			 SetWaitImageVisible(0);
			 SetShowButtonImage(1);
			 SetColProperty(0 ,"ncm_no" , {AcceptKeys:"N"});
			 SetDataLinkMouse("ncm_multi_pop",1);
			 SetImageList(1,"img/button/btns_multisearch.gif");
		}
		break;
	}
}

/**
 * 서버로직 처리
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param Row
 * @param Col
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction, Row, Col))
			return;
		ComOpenWait(true);
		setTimeout( function () {
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("ESM_BKG_0127GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml);
			ComOpenWait(false);
		} , 100);
		break;

	case SEARCH02: // 그리드에서 NCM Code 직접입력시 조회
		if (!validateForm(sheetObj, formObj, sAction, Row, Col))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchData("ESM_BKG_0127GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		var brz_cmdt_cd = ComGetEtcData(sXml, "brz_cmdt_cd");
		var cstms_desc = ComGetEtcData(sXml, "cmdt_desc");
		if (brz_cmdt_cd == "") {
			ComShowCodeMessage("BKG06012", "NCM code");
			sheetObj.SetCellValue(Row, "ncm_no", "");
			return;
		} else {
			sheetObj.SetCellBackColor(Row, "ncm_no", "#FFFFFF");
			sheetObj.SetCellValue(Row, "cstms_desc", cstms_desc);
			sheetObj.SetCellValue(Row, "ncm_multi_flg", "N");
			sheetObj.SetCellValue(Row, "ncm_multi_no", brz_cmdt_cd);
		}
		break;

	case MODIFY: // Data DownLoad
		if (!validateForm(sheetObj, formObj, sAction, Row, Col))
			return;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "check") == 1) {
				if (sheetObj.GetCellValue(i, "if_flag") == "N") {
					sheetObj.SetRowStatus(i, "I");
				} else {
					sheetObj.SetRowStatus(i, "U");
				}
			} else {
				sheetObj.SetRowStatus(i, "");
			}
		}
		formObj.f_cmd.value = MODIFY;
		var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);

		ComOpenWait(true);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0127GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
		ComOpenWait(false);
		break;

	case MODIFY01: // Save
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = MODIFY01;
		var sParam = sheetObjects[0].GetSaveString() + "&" + FormQueryString(formObj);
		ComOpenWait(true);
		var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0127GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
		ComOpenWait(false);
		break;

	case IBSAVE: // Transmit
		if (!validateForm(sheetObj, formObj, sAction)) return false;
		if (!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) return false;
		formObj.f_cmd.value = MULTI;
		var sParam = "";
		var sParamSheet = sheetObj.GetSaveString(0, 1, "check");
		if (sParamSheet != "") sParam = "&" + sParamSheet;
		sParam += "&" + FormQueryString(formObj);
		ComOpenWait(true, true);
		var sXml = sheetObj.GetSaveData("ESM_BKG_0127GS.do", sParam)
		var key = ComGetEtcData(sXml, "KEY");
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0127GS.do", FormQueryString(formObj));
		break;

	case MULTI05: // 데이터 삭제
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "check") == 1) {
				sheetObj.SetRowStatus(i, "D");
			} else {
				sheetObj.SetRowStatus(i, "");
			}
		}
		formObj.f_cmd.value=MULTI05;
		var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0127GS.do", sParam);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		doActionIBSheet(sheetObj,form,IBSEARCH); // 데이터 삭제 후 재조회함
		break;
	}
}

/**
 * 화면 IO TYPE을 체크한다.
 *
 * @param formObj
 * @param polCntCd
 * @param podCntCd
 * @return
 */
function ioTypeCheck(formObj, polCntCd, podCntCd) {
	if (polCntCd == "BR") {
		formObj.io_type[0].checked = true;
		sheetObjects[0].SetColHidden("brz_decl_no", 0);
	} else if (podCntCd == "BR") {
		formObj.io_type[1].checked = true;
		sheetObjects[0].SetColHidden("brz_decl_no", 1);
	}
	changeSheetTitle();
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, Row, Col) {
	var sheet1RowCnt = sheetObj.RowCount();
	var vvdCd = formObj.vvd_cd.value;
	var blNo = formObj.bl_no.value;

	switch (sAction) {

		case IBSEARCH:  // 조회
			// 기본포멧체크
			if (!ComChkValid(formObj))
				return false;
			// 라디오버튼 클릭시 체크
			if (vvdCd == "" && blNo == "") {
				ComShowCodeMessage("BKG01090", "VVD", "B/L No"); // Please inpout {?msg1} or {?msg2}
				ComSetFocus(formObj.vvd_cd);
				return false;
			}
			if (vvdCd != "" && blNo == "") {
				var polVal = formObj.pol_cd.value;
				var podVal = formObj.pod_cd.value;
				if (polVal == "" && podVal == "") {
					ComShowCodeMessage("BKG01090", "POL", "POD");
					ComSetFocus(formObj.pol_cd);
					return false;
				}
			}
			break;

		case SEARCH02: // ncm 직접 입력 시 정합성 체크를 위한 조회
			if (sheetObj.GetCellValue(Row, "ncm_no") == "")
				return false;
			break;

		case MODIFY:  // data download
			if (sheet1RowCnt == 0) {
				ComShowCodeMessage('BKG00889'); //No data found.
				return false;
			}
			var iFFlagCnt = 0;
			var checkCnt = 0;
			var cntrChkRow = 0;
			var cmChkRow = 0;
			var blNo = "";
			for ( var i = 1; i <= sheet1RowCnt; i++) {
				if (blNo == sheetObj.GetCellValue(i, "bl_no") ) {
					sheetObj.SetCellValue(i, "check", 1);
				}

				if (sheetObj.GetCellValue(i, "check") == 1) {
					checkCnt++;
					if (sheetObj.GetCellValue(i, "if_flag") == "Y") {
						iFFlagCnt++;
					}
					if (cntrChkRow == 0 && sheetObj.GetCellValue(i, "cntr_no") == "") {
						cntrChkRow = i;
					}
					if (cmChkRow == 0 && sheetObj.GetCellValue(i, "cntr_mf_seq") == "") {
						cmChkRow = i;
					}
					blNo = sheetObj.GetCellValue(i, "bl_no");
				}
			}
			if (checkCnt == 0) {
				ComShowCodeMessage('BKG01097'); // Please check Select box of the target B/L No
				return false;
			}
			if (cntrChkRow > 0) {
				ComShowCodeMessage("BKG00443"); // Container No. is invalid.
				sheetObj.SelectCell(cntrChkRow, "cntr_no");
				return false;
			}
			if (cmChkRow > 0) {
				ComShowCodeMessage("BKG08062", "C/M Data"); // [{?msg1}] does not exist. Please check B/L No. again.
				sheetObj.SelectCell(cmChkRow, "weight");
				return false;
			}
			if (iFFlagCnt > 0) {
				if (!ComShowCodeConfirm("BKG01094")) { // You selected already downloaded B/L. Do you want to continue?
					return false;
				}
			} else if (!ComShowCodeConfirm("BKG01087")) { // Do you want to download selected B/L?
				return false;
			}
			break;

	case MODIFY01: // save
		if (sheet1RowCnt == 0) {
			ComShowCodeMessage('BKG00889'); //No data found.
			return false;
		}
		var cnt = 0;
		for ( var i = 1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "if_flag") == "Y") {
				cnt++;
			}
		}
		if (cnt == 0) {
			ComShowCodeMessage('BKG01095'); // There is no data I/F is \"Y\"
			return false;
		}
		if (!sheetObj.IsDataModified()) {
			ComShowCodeMessage('BKG00260'); // Data NOT Changed
			return false;
		}
		for ( var i = 1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "if_flag") != "Y" || sheetObj.GetRowStatus(i) == "R") {
				continue;
			}
			if (sheetObj.GetCellValue(i, "cntr_mf_seq") == "") {
				ComShowCodeMessage("BKG00445", "C/M Data"); // Please input {?msg1}.
				return false;
			}
		}

		if (!ComShowConfirm(ComGetMsg("BKG00254"))) { // Data Changed. Do you want to save it ?
			return false;
		}
		break;

	case IBSAVE:  // Transmit Validation
		if (sheet1RowCnt == 0) {
			ComShowCodeMessage("BKG01096");
			return false;
		}
		var searchIoType = formObj.search_io_type.value;

		var polCd = formObj.pol_cd.value;
		var podCd = formObj.pod_cd.value;
		var polCountry = polCd.substr(0, 2);
		var podCountry = podCd.substr(0, 2);
		var ifFlagYCnt = 0;
		var ifFlagNCnt = 0;
		var checkCnt = 0;
		var updateCnt = 0;
		var excludeTargetRow = 0;
		for ( var i = 1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "check") == "1") {
				checkCnt++;
				if (sheetObj.GetCellValue(i, "if_flag") == "Y") {
					ifFlagYCnt++;
				}
				if (excludeTargetRow == 0 && sheetObj.GetCellValue(i, "if_flag") == "N") {
					excludeTargetRow = i;
				}
			}
		}
		if (checkCnt == 0) {
			// ComShowMessage("전송할 row를 먼저 체크해 주세요");
			ComShowCodeMessage('BKG01097');
			return false;
		}
		if (ifFlagYCnt == 0) {
			// ComShowMessage("I/F 값이 Y인 데이타가 없습니다.");
			ComShowCodeMessage("BKG01095");
			return false;
		}
		if (excludeTargetRow > 0) {
			// ComShowMessage("You can't transmit without download!");
			ComShowCodeMessage("BKG01095");
			sheetObj.SelectCell(excludeTargetRow, "if_flag");
			return false;
		}
		/*
		 * 20100511 경종윤 O/B 이고 POL country가 "BR"이 아닌경우 I/B 이고 POD country가 "BR"이 아닌경우 CNPJ/CPF, DDE/SD, NCM 입력 validation 을 하지 않음
		 */
		var validationFlag = true;
		if ((searchIoType == "O" && polCountry != "BR") || (searchIoType == "I" && podCountry != "BR")) {
			validationFlag = false;
		}

		var targetColGubunName="";
		var targetColName="";
		var targetColOrgName="";
		var setColGubun="";

		for ( var i = 1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "check") == 1) {
				var bl_no = sheetObj.CellSearchValue(i,"bl_no");
				if (sheetObj.GetRowStatus(i) == "U")
				{
					ComShowCodeMessage("BKG01099", bl_no); //Data is under editing. You can’t transmit[B/L No :  {?msg1} ]
					return false
				}
				if (sheetObj.CellSearchValue(i,"search_bkg_cgo_tp_cd") != "P" && validationFlag) { // Cargo Type != Empty

					if (sheetObj.GetCellValue(i, "cntr_no") == "") {
						ComShowCodeMessage("BKG01100", "Container", bl_no); //Missing [{?msg1}].  You can’t transmit[B/L No :  {?msg2} ]
						sheetObj.SelectCell(i, "cntr_no");
						return false;
					}
					if (sheetObj.GetCellValue(i, "ncm_no") == "") {
						ComShowCodeMessage("BKG01100", "NCM Code", bl_no);
						sheetObj.SelectCell(i, "ncm_no");
						return false;
					}
					if (sheetObj.GetCellValue(i, "pck_qty") == "") {
						ComShowCodeMessage("BKG01100", "Package", bl_no);
						sheetObj.SelectCell(i, "pck_qty");
						return false;
					}
					if (sheetObj.GetCellValue(i, "weight") == "") {
						ComShowCodeMessage("BKG01100", "Weight", bl_no);
						sheetObj.SelectCell(i, "weight");
						return false;
					}
					if (sheetObj.GetCellValue(i, "measure") == "") {
						ComShowCodeMessage("BKG01100", "Measure", bl_no);
						sheetObj.SelectCell(i, "measure");
						return false;
					}
					if (formObj.io_type[0].checked) {
						if (sheetObj.GetCellValue(i, "shpr_tax_no") == "") {
							ComShowCodeMessage("BKG01100", "Shipper CNPJ/CPF", bl_no);
							sheetObj.SelectCell(i, "shpr_tax_no");
							return false;
						}
						if (sheetObj.GetCellValue(i, "brz_decl_no") == "") {
							ComShowCodeMessage("BKG01100", "DDE/SD", bl_no);
							sheetObj.SelectCell(i, "brz_decl_no");
							return false;
						}
					} else {
						// Inbound
						if (sheetObj.GetCellValue(i, "cust_to_ord_flg") == "Y" && sheetObj.GetCellValue(i, "ntfy_tax_no") == "") {
							ComShowCodeMessage("BKG01100", "Notify CNPJ/CPF", bl_no);
							sheetObj.SelectCell(i, "ntfy_tax_no");
							return false;
						} else if (sheetObj.GetCellValue(i, "cust_to_ord_flg")  == "N" && sheetObj.GetCellValue(i, "cnee_tax_no")  == "") {
							ComShowCodeMessage("BKG01100", "Consignee CNPJ/CPF", bl_no);
							sheetObj.SelectCell(i, "cnee_tax_no");
							return false;
						}
					}
				}
			}
		}
		break;

	case MULTI05 : // Data Delete 버튼 클릭 시
		if (sheetObj.CheckedRows("check") <= 0 ) {
			ComShowCodeMessage("COM12189"); // 'Nothing selected';
			return false;
		}
		if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
		break;
	} // end switch
	return true;
}

/**
 * BackEndJob 실행결과조회<br>
 *
 * @param sheetObj
 * @param sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchData("ESM_BKG_0127GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// ComShowMessage("doActionValidationResult "+sJbStsFlg);
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG00101');
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * IBSheet에 셀 클릭시 팝업 처리
 *
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var ifFlag = sheetObj.GetCellValue(Row, "if_flag");
	switch (colName) {
	case "ncm_no":
		if (ifFlag == "N") {
			ComShowMessage("You can’t save data. Please download B(s)/L first.");
			return false;
		}

		var sUrl = "/opuscntr/ESM_BKG_0745_P.do?page_gubun=popup&ncm_no=" + sheetObj.GetCellValue(Row, 'ncm_no');
		var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0745_P", 1024, 520, true);
		if (rtnVal != null) {
			sheetObj.SetCellValue(Row, 'ncm_no', rtnVal.cd);
			sheetObj.SetCellValue(Row, 'cstms_desc', rtnVal.nm);
			sheetObj.SetCellValue(Row, "ncm_multi_flg", "N");
			sheetObj.SetCellValue(Row, "ncm_multi_no", brz_cmdt_cd);
		}
		break;
	}
}
/**
 * 시트를 클릭했을 때 처리
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	with (sheetObj) {
		switch (ColSaveName(col)) {
			case "check":
				ReDraw = false;
				// 선택된 row의 seq와 같은 row index를 검색 (Merge된 CheckBox에 체크/체크해제시 버그 보완수정)
				// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
				var sameRows = ComFindAll(sheetObj, "bl_group", GetCellValue(row, "bl_group")).toString().split("|");
				// 검색된 row index들에 대한 처리
				for (var i in sameRows) SetCellValue(sameRows[i], "check", value);
				ReDraw = true;
				break;

			case "shipper_cust_nm":
			case "consignee_cust_nm":
			case "notify_cust_nm":
			case "cstms_desc":
			case "booking_cmdt_nm":
				/* 긴 문자열 MemoPad 처리 */
				if (GetCellValue(row, col) != "") {
					ComShowMemoPad(sheetObj, null, null, true, 250, 80);
				}
				break;

			case "hide_check":
				var rowCnt = RowCount();
				var keyBlNo = GetCellValue(row, "bl_no");
				var hideCheck = GetCellValue(row, "hide_check");
				for (i = 1; i <= rowCnt; i++) {
					if (hideCheck == 1) {
						if (i == row)
							continue;
						if (keyBlNo == GetCellValue(i, "bl_no")) {
							SetCellValue(i, "hide_check", 1);
						}
					} else if (hideCheck == 0) {
						if (i == row)
							continue;
						if (keyBlNo == GetCellValue(i, "bl_no")) {
							SetCellValue(i, "hide_check", 0);
						}
					}
				}
				break;

			case "ncm_multi_pop":
				var ifFlag = GetCellValue(row, "if_flag");
				if (ifFlag == "N") {
					ComShowMessage("You can’t save data. Please download B(s)/L first.");
					return false;
				} else {
					var param = "";
					param = param + '?bl_no=' + GetCellValue(row, "bl_no");
					param = param + '&cntr_no=' + GetCellValue(row, "cntr_no");
					param = param + '&cntr_mf_seq=' + GetCellValue(row, "cntr_mf_seq");
					param = param + '&ncm_multi_no=' + GetCellValue(row, "ncm_multi_no");
					param = param + '&openner_sheet_ncm_no=' + GetCellValue(row, "ncm_no");
					param = param + '&org_sheet=' + "0";
					param = param + '&org_row=' + row;
					ComOpenPopup('/opuscntr/ESM_BKG_1154.do' + param, 1024, 520, '', 'none', false);
				}
				break;
		} // end switch
	}
}
/**
 * Booking Creation 화면 이동
 * @param sheetObj Sheet
 * @param Row Row Index
 * @param Col Col Index
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var srcCol = sheetObj.ColSaveName(Col);
	if (srcCol != "bl_no" && srcCol != "bkg_no")
		return;
	ComBkgCall0079(sheetObj.GetCellValue(Row, "bl_no"));
}

/**
 * 시트 Change 이벤트
 *
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var rowCnt = sheetObj.RowCount();
	var ifFlag = sheetObj.GetCellValue(row, "if_flag");
	var check = sheetObj.GetCellValue(row, "check");
	var keyBlNo = sheetObj.GetCellValue(row, "bl_no");
	var hideCheck = sheetObj.GetCellValue(row, "hide_check");
	var colSaveName = sheetObj.ColSaveName(col);
	switch (colSaveName) {
	case "ncm_no":
		formObject.brz_cmdt_cd.value = value;
		doActionIBSheet(sheetObj, formObject, SEARCH02, row, col);
		break;
	case "ncm_multi_flg":
		if (sheetObj.GetCellValue(row, "ncm_multi_flg") == "Y") {
			sheetObj.SetCellBackColor(row, "ncm_no", "#FCC4F5");
		}
		break;
		// 어차피 같은 BL No 이면 첫번째꺼만 가져가면 되므로 필요없는 로직임
//    case "shpr_tax_no":
//    case "cnee_tax_no":
//    case "ntfy_tax_no":
//    case "brz_decl_no":
//    case "br_duv":
//    case "br_mid":
//        for (i = 1; i <= rowCnt; i++) {
//            if (i == row)
//                continue;
//            if (keyBlNo == sheetObj.GetCellValue(i, "bl_no")) {
//                sheetObj.SetCellValue(i, col, value);
//            }
//        }
//        break;

	} // end switch
}
/**
 * Click 이벤트 Catch
 */
function obj_click() {
	var formObj = document.form;
	var srcObj = ComGetEvent();
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.checked;
	if (srcName == "io_type") {
		changeSheetTitle();
	}
}

/**
 * sheet header(Carriage Date) 타이틀 변경
 *
 * @param dType
 */
function changeSheetTitle() {
	var formObj = document.form;
	if (formObj.io_type[0].checked) {
		sheetObjects[0].SetCellValue(0, "cap", "OTH", 0);
	} else {
		sheetObjects[0].SetCellValue(0, "cap", "DTH", 0);
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	sheetObj.CheckAll("check", 0);
	sheetObj.CheckAll("hide_check", 1);

	var formObj = document.form;
	var polCntCd = formObj.pol_cd.value.substring(0, 2);
	var podCntCd = formObj.pod_cd.value.substring(0, 2);
	var custToOrdFlg = "";

	if (ErrMsg == "" || ErrMsg == "0") {

//        sheetObj.RenderSheet(0);

		// IO TYPE 설정(조회 후 한번더 설정함)
		ioTypeCheck(formObj, polCntCd, podCntCd);

		var olbBlNo = "";
		var currBlNo = ""
		var sheetMaxCnt = sheetObj.RowCount();

		for ( var i = 1; i <= sheetMaxCnt; i++) {

			if (formObj.io_type[0].checked) {
				// O/B 일 경우
				// shiper CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
				if ((sheetObj.GetCellValue(i, "ob_shpr_tax_no") == "" && sheetObj.GetCellValue(i, "shpr_tax_no") == "")
				|| (sheetObj.GetCellValue(i, "ob_shpr_tax_no") == "" && sheetObj.GetCellValue(i, "shpr_tax_no") != "")) {
					sheetObj.SetCellValue(i, "diff_shpr_tax_no_flag", "Y", 0);
				} else if (sheetObj.GetCellValue(i, "ob_shpr_tax_no") != "" && (sheetObj.GetCellValue(i, "ob_shpr_tax_no") != sheetObj.GetCellValue(i, "shpr_tax_no"))) {
					sheetObj.SetCellFontColor(i, "ob_shpr_tax_no", "#FF0000");
					sheetObj.SetCellFontColor(i, "shpr_tax_no", "#FF0000");
					sheetObj.SetCellValue(i, "diff_shpr_tax_no_flag", "Y", 0);
				}
			} else {
				// I/B 일 경우
				custToOrdFlg = sheetObj.GetCellValue(i, "cust_to_ord_flg");

				if (custToOrdFlg == "N") { // B/L Type : Straight
					// consignee CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
					if ((sheetObj.GetCellValue(i, "ob_cnee_tax_no") == "" && sheetObj.GetCellValue(i, "cnee_tax_no") == "")
							|| (sheetObj.GetCellValue(i, "ob_cnee_tax_no") == "" && sheetObj.GetCellValue(i, "cnee_tax_no") != "")) {
						sheetObj.SetCellValue(i, "diff_cnee_tax_no_flag", "Y", 0);
					} else if (sheetObj.GetCellValue(i, "ob_cnee_tax_no") != "" && (sheetObj.GetCellValue(i, "ob_cnee_tax_no") != sheetObj.GetCellValue(i, "cnee_tax_no"))) {
						if (sheetObj.GetCellValue(i, "cust_to_ord_flg") == "N") {
							sheetObj.SetCellFontColor(i, "ob_cnee_tax_no", "#FF0000");
							sheetObj.SetCellFontColor(i, "cnee_tax_no", "#FF0000");
						}
						sheetObj.SetCellValue(i, "diff_cnee_tax_no_flag", "Y", 0);
					}

				} else { // B/L Type : Order

					// notyfy CNPJ No 항목이, O/B 데이터(BKG_XPT_IMP_LIC) 와 BKG_CSTMS_BRZ_BL 테이블 상의 CNEE_TAX_NO 와 다를 경우 빨간색으로 표기함
					if ((sheetObj.GetCellValue(i, "ob_ntfy_tax_no") == "" && sheetObj.GetCellValue(i, "ntfy_tax_no") == "")
							|| (sheetObj.GetCellValue(i, "ob_ntfy_tax_no") == "" && sheetObj.GetCellValue(i, "ntfy_tax_no") != "")) {
						sheetObj.SetCellValue(i, "diff_ntfy_tax_no_flag", "Y", 0);
					} else if (sheetObj.GetCellValue(i, "ob_ntfy_tax_no") != "" && (sheetObj.GetCellValue(i, "ob_ntfy_tax_no") != sheetObj.GetCellValue(i, "ntfy_tax_no"))) {
						if (sheetObj.GetCellValue(i, "cust_to_ord_flg") == "Y") {
							sheetObj.SetCellFontColor(i, "ob_ntfy_tax_no", "#FF0000");
							sheetObj.SetCellFontColor(i, "ntfy_tax_no", "#FF0000");
						}
						sheetObj.SetCellValue(i, "diff_ntfy_tax_no_flag", "Y", 0);
					}
				}
			}

			if (sheetObj.GetCellValue(i, "oft") == "Y") {
				sheetObj.SetCellFontColor(i, "oft", "#0000FF");
			} else {
				sheetObj.SetCellFontColor(i, "oft", "#FF0000");
			}
			if (sheetObj.GetCellValue(i, "cap") == "Y") {
				sheetObj.SetCellFontColor(i, "cap", "#0000FF");
			} else {
				sheetObj.SetCellFontColor(i, "cap", "#FF0000");
			}

			if (sheetObj.GetCellValue(i, "if_flag") == "N") {
				sheetObj.SetCellEditable(i, "shpr_tax_no", 0);
				sheetObj.SetCellEditable(i, "cnee_tax_no", 0);
				sheetObj.SetCellEditable(i, "ntfy_tax_no", 0);
				sheetObj.SetCellEditable(i, "brz_decl_no", 0);
				sheetObj.SetCellEditable(i, "ncm_no", 0);
				sheetObj.SetCellEditable(i, "br_duv", 0);
				sheetObj.SetCellEditable(i, "br_mid", 0);
			}
			if (sheetObj.GetCellValue(i, "ncm_multi_flg") == "Y") {
				sheetObj.SetCellBackColor(i, "ncm_no", "#FCC4F5");
			}

			sheetObj.SetRowStatus(i, "R");

		} // end for(i)

		// 조회시 io_type값을 셋팅한다.
		if (formObj.io_type[0].checked) {
			formObj.search_io_type.value = "O";
		} else {
			formObj.search_io_type.value = "I";
		}

//        sheetObj.RenderSheet(1);

	}
	SetButtonStatus();
}

/**
 *
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {

	if (ErrMsg == "" || ErrMsg == "0") {
		if (document.form.f_cmd.value == MODIFY || document.form.f_cmd.value == MODIFY01) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
}
