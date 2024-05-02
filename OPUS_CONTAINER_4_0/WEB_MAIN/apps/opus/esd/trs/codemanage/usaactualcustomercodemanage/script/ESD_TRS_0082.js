/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0082.js
 *@FileTitle : USA Actual Customer Code Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-10-16
 *@LastModifier : Kim Jun Ho
 *@LastVersion : 1.0
 * 2007-10-16 Kim Jun Ho
 * History
 * 2010.09.03 최종혁 [CHM-201005753] Actual customer 'Status flag' 변경시 표기사항 일부 변경 요청
 * 2011.03.14 손은주 [CHM-201109256][TRS] Actual customer 상의 중복 Default 지정 Block 요청
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends Bkg
 * @class ESD_TRS_0082 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0082() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH, "btn_retrieve");
				break;
			case "btn_new":
				fn_reset();
				break;
	
			case "btng_downexcel":
				doActionIBSheet(sheetObject3, formObject, IBSEARCH, "EXCEL");
				break;
			case "btng_rowadd1":
				doActionIBSheet(sheetObject1, formObject, IBINSERT, srcName);
				sheetObject2.RemoveAll();
				break;
	
			case "btng_rowadd2":
				var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');
				if (checkList[0] > 0) {
					var checkCustNo = sheetObject1.GetCellValue(checkList[0], 'trsp_act_cust_no');
					if (checkCustNo == '' || checkCustNo == null) {
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, srcName);
					} else {
						doActionIBSheet(sheetObject2, formObject, IBINSERT, srcName);
					}
				}
				break;
			case "btng_save":
				if (sheetObject2.RowCount() == 0) {
					ComShowCodeMessage("TRS90461");
					break;
				}
				doActionIBSheet(sheetObject1, formObject, IBSAVE, "MST");
				doActionIBSheet(sheetObject2, formObject, IBSAVE, "DTL");
				break;
			case 'btng_customer':
				popCustomer();
				break;
	
			case "btns_multiofc":
				openMultipleinquiry('OFC', 'Office');
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, srcName) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH:
		switch (srcName) {
			case "btn_retrieve":
				if (!validateForm(sheetObj, formObj, IBSEARCH, "btn_retrieve")) {
					return false;
				}
				sheetObjects[1].RemoveAll();
				document.form.input_cust_cd.value = document.form.input_cust_cd.value.toUpperCase();
				document.form.input_cust_nm.value = document.form.input_cust_nm.value.toUpperCase();
				document.form.input_cre_ofc_cd.value = document.form.input_cre_ofc_cd.value.toUpperCase();
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				break;
	
			case "DETAIL":
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				break;
	
			case "EXCEL":
				if (!validateForm(sheetObj, formObj, IBSEARCH, "btn_retrieve"))
					return false;
	
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				break;
	
			case "btng_rowadd2":
				var row = sheetObj.GetSelectRow();
				var act_cust_cnt_cd = sheetObj.GetCellValue(row, 'act_cust_cnt_cd');
				var act_cust_bnd_cd = sheetObj.GetCellValue(row, 'act_cust_bnd_cd');
				var dor_nod_cd = sheetObj.GetCellValue(row, 'dor_nod_cd');
	
				var urlStr = 'ibflag=R&act_cust_cnt_cd=' + act_cust_cnt_cd + '&act_cust_bnd_cd=' + act_cust_bnd_cd + '&dor_nod_cd=' + dor_nod_cd + '&row=' + row + '&col=trsp_act_cust_no';
				formObj.f_cmd.value = SEARCH04;
				var opt = { Wait : 0, Sync : 1 };
				sheetObj.DoRowSearch(row, 'ESD_TRS_0082GS.do', urlStr + '&' + TrsFrmQryString(formObj), opt);
				break;
	
			case "cust_name":
				// Actual Customer Name 조회
				var row = sheetObj.GetSelectRow();
				var act_cust_cnt_cd = sheetObj.GetCellValue(row, 'act_cust_cnt_cd');
				var urlStr = 'ibflag=R&act_cust_cnt_cd=' + act_cust_cnt_cd + '&row=' + row + '&col=act_cust_nm';
				formObj.f_cmd.value = SEARCH02;
				var cust_nm = ComSearchEtcData(sheetObj, "ESD_TRS_0082GS.do", urlStr + '&' + TrsFrmQryString(formObj), 'CUST_NM');
				if (cust_nm == "") {
					sheetObj.SetCellValue(row, 'act_cust_cnt_cd', "", 0);
				} else {
					sheetObj.SetCellValue(row, 'act_cust_nm', cust_nm);
				}
				break;
		}
		break;

	case IBSAVE:
		var sheetObject2 = sheetObjects[1];
		if (srcName == "MST") {
			var checkList = sheetObj.FindCheckedRow('ib_chk');
			var checkArray = checkList.split('|');
			if (checkArray == '')
				return false;
			if (!validateForm(sheetObj, formObj, IBSAVE, "MST"))
				return false;
			var checkList = sheetObj.FindCheckedRow('ib_chk').split('|');
			var mst_delt_flg = sheetObj.GetCellValue(checkList, 'delt_flg');
			if (mst_delt_flg == 'Y') {
				var sheet2_rowcount = sheetObject2.RowCount();
				for (i = 1; i < sheet2_rowcount + 1; i++) {
					var dtl_delt_flg = sheetObject2.GetCellValue(i, 'delt_flg');
					if (dtl_delt_flg == 'N') {
						sheetObject2.SetCellValue(i, 'delt_flg', 'Y', 0);
					}
				}
			}
			formObj.f_cmd.value = MULTI;
			formObj.mst_dtl_indicator.value = srcName;
			sheetObj.DoSave("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), 'ib_chk', 0);
		}
		if (srcName == "DTL") {
			if (!validateForm(sheetObj, formObj, IBSAVE, "DTL"))
				return false;
			formObj.f_cmd.value = MULTI;
			formObj.mst_dtl_indicator.value = srcName;
			sheetObj.DoSave("ESD_TRS_0082GS.do", TrsFrmQryString(formObj), -1, 0);
		}
		break;

	// ExcelDownload
	case IBDOWNEXCEL:
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });
		break;

	// ADD Row
	case IBINSERT:
		sheetObj.DataInsert(-1);
		switch (srcName) {
			case "btng_rowadd1":
				var row = sheetObj.GetSelectRow();
				sheetObj.SetCellValue(row, 'act_cust_bnd_cd', 'I', 0)
				sheetObj.SetCellValue(row, 'ib_chk', '1', 0)
				if (sheetObj.rowcount > 1) {
					var checked_loc1 = sheetObj.GetCellValue(row - 1, "dr_loc_value");
					if (checked_loc1 == '' || checked_loc1 == null) {
						ComShowMessage("Input the door location!.");
						sheetObj.RowDelete(row, false);
						sheetObj.SetCellValue(row - 1, 'ib_chk', 1, 0);
						break;
					}
	
					var checkrow1 = sheetObj.GetCellValue(row - 1, 'trsp_act_cust_no');
					var checkrow2 = sheetObj.GetCellValue(row, 'trsp_act_cust_no');
					var chk_cre_row1 = sheetObj.GetCellValue(row - 1, 'cre_dt');
	
					if ((checkrow1 == '' || checkrow1 == null || chk_cre_row1 == '' || chk_cre_row1 == null) || (checkrow1 == checkrow2)) {
						ComShowMessage("You can't add row. Previous input data not saveed.!");
						sheetObj.RowDelete(row, false);
						sheetObj.SetCellValue(row - 1, 'ib_chk', 1, 0);
						break;
					}
				}
				break;
	
			case "btng_rowadd2":
				var row = sheetObj.GetSelectRow();
				var sheetObject1 = sheetObjects[0];
	
				// Master Delete 되면 Detail Row add 불가
				var mst_row = sheetObject1.FindCheckedRow('ib_chk').split('|');
				var mst_delt_flg = sheetObject1.GetCellValue(mst_row, 'delt_flg');
				if (mst_delt_flg == 'Y') {
					ComShowMessage('Please change the master status back to "Live"!!');
					sheetObj.RowDelete(row, false);
					break;
				}
				sheetObj.SetCellValue(row, 'delt_flg', 'N', 0);
				sheetObj.SetCellValue(row, 'trsp_act_cust_seq', row, 0);
	
				var check_cust = sheetObj.GetCellValue(1, 'trsp_act_cust_no');
				if (check_cust.length > 0) {
					var dupcheck1 = sheetObject1.CheckedRows("trsp_act_cust_no");
					if (dupcheck1 > 1) {
						ComShowMessage("You can't add row. Previous data not saveed.!");
						var row = sheetObject1.GetSelectRow();
						sheetObject1.RowDelete(row, false);
						break;
					}
					sheetObj.SetCellValue(row, 'trsp_act_cust_no', sheetObj.GetCellValue(1, 'trsp_act_cust_no'), 0);
				} else {
					if (sheetObject1.RowCount() > 0) {
						for (i = 1; i < sheetObject1.RowCount() + 1; i++) {
							if (sheetObject1.GetCellValue(i, "ib_chk") == 1) {
								var checked_loc = sheetObject1.GetCellValue(i, "dr_loc_value");
								var checked_yard = sheetObject1.GetCellValue(i, "dr_yard_value");
								var checked_cust_no = sheetObject1.GetCellValue(i, "trsp_act_cust_no");
	
								if (checked_loc == '' || checked_yard == "") {
									ComShowMessage("Input the door location!.");
									sheetObj.RemoveAll();
									sheetObject1.SetCellValue(i, "trsp_act_cust_no", '', 0);
								}
							}
						}
						sheetObj.SetCellValue(1, 'trsp_act_cust_no', checked_cust_no, 0);
					}
				}
				break;
			}
		break;
	}
}

/**
 * IBSheet Object를 배열로 등록 comSheetObject(id)에서 호출한다 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
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
	var formObject = document.form;
	formObject.status.focus();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			SetSheetHeight(200);
			var HeadTitle = "Sel|Status|Bound|Door Node|Door Node|Customer Code|Customer Name|trsp_act_cust_no|cre_dt|ibflag|dor_nod_cd";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
			var headers = [{ Text : HeadTitle, Align : "Center" }];
			InitHeaders(headers, info);
			var cols = [
					{ Type : "Radio", 	Hidden : 0, Width : 40, Align : "Center", ColMerge : 1, SaveName : "ib_chk" },
					{ Type : "Combo", 	Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
					{ Type : "Combo", 	Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "act_cust_bnd_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
					{ Type : "Text", 	Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "dr_loc_value", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 5 },
					{ Type : "Text",	Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "dr_yard_value", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 2 },
					{ Type : "Text", 	Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "act_cust_cnt_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1 },
					{ Type : "Text", 	Hidden : 0, Width : 250, Align : "Left", ColMerge : 1, SaveName : "act_cust_nm", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", 	Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "trsp_act_cust_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", 	Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Status", 	Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, 
					{ Type : "Text", 	Hidden : 1, Width : 80, Align : "Center", ColMerge : 0, SaveName : "dor_nod_cd" }
			];
			InitColumns(cols);
			SetEditable(1);
			SetColProperty(0, "dr_loc_value" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			SetColProperty(0, "act_cust_cnt_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			SetColProperty(0, 'act_cust_bnd_cd', { ComboText : act_cust_bnd_cdText, ComboCode : act_cust_bnd_cdCode });
			SetColProperty(0, 'delt_flg', { ComboText : delt_flgText, ComboCode : delt_flgCode });
		}
		break;

	case 2:
		with (sheetObj) {
			var HeadTitle = "Status|Default|Actual Customer Name|Zip Code|Address|TEL No|FAX No|Contact PIC|eMail Address|" + "Remark|Creation Date|Creation Office|Creation User|Update Date|Update User|Deleted Date|Delete Office|Delete User";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle, Align : "Center" }
			];
			InitHeaders(headers, info);

			var cols = [
					{ Type : "Combo", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
					{ Type : "Radio", Hidden : 0, Width : 70, Align : "Center", ColMerge : 1, SaveName : "dflt_act_cust_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50, TrueValue : "Y", FalseValue : "N" },
					{ Type : "Text", Hidden : 0, Width : 220, Align : "Left", ColMerge : 1, SaveName : "act_cust_nm", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_zip_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 10 },
					{ Type : "Text", Hidden : 0, Width : 200, Align : "Left", ColMerge : 1, SaveName : "act_cust_addr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 200 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_phn_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 20 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_fax_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 20 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "cntc_pson_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 1, SaveName : "act_cust_eml", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 600, Align : "Left", ColMerge : 1, SaveName : "act_cust_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1000 },
					{ Type : "Date", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "cre_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 6 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 20 },
					{ Type : "Date", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "upd_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "upd_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 20 },
					{ Type : "Date", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 6 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 20 },
					{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, 
					{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "trsp_act_cust_no" },
					{ Type : "Text", Hidden : 1, Width : 40, Align : "Center", ColMerge : 1, SaveName : "trsp_act_cust_seq" }
			];
			InitColumns(cols);
			SetColProperty('delt_flg', { ComboText : delt_flgText, ComboCode : delt_flgCode });
			SetSheetHeight(200);
			SetEditable(1);
			ComResizeSheet(sheetObj);			
		}
		break;

	case 3: 
		with (sheetObj) {
			var HeadTitle = "Status|Bound|Door|Node|Customer Code|Customer Name|Default|Actual Customer Name|Zip Code|Address|TEL No|FAX No|Contact PIC|eMail Address|" + "Remark|Creation Date|Creation Office|Creation User|Deleted Date|Delete Office|Delete User";
			SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
			var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
			var headers = [
				{ Text : HeadTitle, Align : "Center" }
			];
			InitHeaders(headers, info);
			var cols = [
					{ Type : "Combo", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "delt_flg", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 1 },
					{ Type : "Combo", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_bnd_cd", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "dr_loc_value", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 5 },
					{ Type : "Text", Hidden : 0, Width : 60, Align : "Left", ColMerge : 1, SaveName : "dr_yard_value", KeyField : 1, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 2 },
					{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 1, SaveName : "act_cust_cnt_cd" }, 
					{ Type : "Text", Hidden : 0, Width : 150, Align : "Left", ColMerge : 1, SaveName : "act_cust_nm1" },
					{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "dflt_act_cust_flg" },
					{ Type : "Text", Hidden : 0, Width : 220, Align : "Left", ColMerge : 1, SaveName : "act_cust_nm2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_zip_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 10 },
					{ Type : "Text", Hidden : 0, Width : 200, Align : "Left", ColMerge : 1, SaveName : "act_cust_addr", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 200 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_phn_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 20 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "act_cust_fax_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 20 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "cntc_pson_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 1, SaveName : "act_cust_eml", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 50 },
					{ Type : "Text", Hidden : 0, Width : 600, Align : "Left", ColMerge : 1, SaveName : "act_cust_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 1000 },
					{ Type : "Date", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "cre_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Left", ColMerge : 1, SaveName : "cre_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 6 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Left", ColMerge : 1, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 20 },
					{ Type : "Date", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "delt_dt", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 8 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "delt_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 6 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "delt_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 20 },
					{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }
			];

			InitColumns(cols);
			SetColProperty('delt_flg', { ComboText : "|" + delt_flgText, ComboCode : "|" + delt_flgCode });
			SetColProperty('act_cust_bnd_cd', { ComboText : "|" + act_cust_bnd_cdText, ComboCode : "|" + act_cust_bnd_cdCode });
			SetEditable(0);
			SetVisible(false);
		}
		break;

	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수 IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == MULTI) {
		} else if(1==1) {
			for(var i =1; i < sheetObj.RowCount() + 1; i++ ) {
				if (sheetObj.GetCellValue(i, 'dr_loc_value') != '') {
					getZoneSheetCombo1(sheetObj, formObj, row, col, "dr_yard_value", sheetObj.GetCellValue(i, "dr_loc_value"));
				}
				var dor_loc = sheetObj.GetCellValue(i, 'dr_loc_value');
				var dor_yard = sheetObj.GetCellValue(i, 'dr_yard_value');
				sheetObj.SetCellValue(i, 'dor_nod_cd', dor_loc + dor_yard);
			}
		}
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수 IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	if (errMsg != null && errMsg != '') {
		ComShowMessage(errMsg);
	} else {
		if (formObj.f_cmd.value == MULTI) {
			ComShowCodeMessage('COM12116', 'Save');
		}

		var row = sheetObject1.FindCheckedRow('ib_chk').split('|');
		formObj.sel_trsp_act_cust_no.value = sheetObject1.GetCellValue(row, 'trsp_act_cust_no');
		sheetObj.RemoveAll();
		doActionIBSheet(sheetObj, formObj, IBSEARCH, "DETAIL");

		var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');
		sheetObject1.CellValue2(checkList, 'cre_dt') = formObj.login_date.value;
	}
}

/**
 * Sheet1 Search End Event
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	if (errMsg != null && errMsg != '') {
		if ((formObj.f_cmd.value == SEARCH04) || (formObj.f_cmd.value == SEARCH05)) {
		} else {
			ComShowMessage(errMsg);
		}
		if (formObj.f_cmd.value == SEARCH04) {
			var row = sheetObj.GetSelectRow();
			sheetObj.RowDelete(row, false);
			sheetObj.SetCellValue(row - 1, 'ib_chk', 1, 0)
			formObj.sel_trsp_act_cust_no.value = sheetObj.GetCellValue(row - 1, "trsp_act_cust_no");
			doActionIBSheet(sheetObject2, formObj, IBSEARCH, "DETAIL");
		} else if (formObj.f_cmd.value == SEARCH05) {
			var row = sheetObj.GetSelectRow();
			sheetObj.SetCellValue(row, 'act_cust_cnt_cd', '', 0);
			sheetObj.SetCellValue(row, 'act_cust_nm', '', 0);
		} else if(formObj.f_cmd.value == SEARCH) {
			if(sheetObject1.SearchRows() > 0) {
				sheetObject1.SetCellValue(1, 'ib_chk', 1, 0)
				formObj.sel_trsp_act_cust_no.value = sheetObject1.GetCellValue(1, "trsp_act_cust_no");
				doActionIBSheet(sheetObject2, formObj, IBSEARCH, "DETAIL");
			}			
		}
	} else {
		if (formObj.f_cmd.value == SEARCH04) {
			var row = sheetObj.GetSelectRow();
			sheetObj.SetCellValue(row, 'trsp_act_cust_no', sheetObj.GetEtcData('TEXT'), 0);
			doActionIBSheet(sheetObject2, formObj, IBINSERT, "btng_rowadd2");
		} else if (formObj.f_cmd.value == SEARCH05) {
			doActionIBSheet(sheetObj, formObj, IBSEARCH, "cust_name");
		} else if(formObj.f_cmd.value == SEARCH) {
			if(sheetObject1.SearchRows() > 0) {
				sheetObject1.SetCellValue(1, 'ib_chk', 1, 0)
				formObj.sel_trsp_act_cust_no.value = sheetObject1.GetCellValue(1, "trsp_act_cust_no");
				doActionIBSheet(sheetObject2, formObj, IBSEARCH, "DETAIL");
			}
		}
	}
}

/**
 * 
 */
function sheet1_OnRowSearchEnd(sheetObj, Row) {
	var yardValue = sheetObj.GetCellValue(Row, 'dr_yard_value');
	sheetObj.InitCellProperty(Row, "dr_yard_value", { Type : "Combo" });
	sheetObj.CellComboItem(Row, "dr_yard_value", { ComboText : "|" + yardValue, ComboCode : "|" + yardValue });
	sheetObj.SetCellValue(Row, "dr_yard_value", yardValue, 0);
	sheetObj.SetCellValue(Row, "ibflag", "R")
}

/**
 * Sheet1 Search End Event
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
	var formObject = document.form;
	if (formObject.f_cmd.value == SEARCH03) {
		doActionIBSheet(sheetObj, formObject, IBDOWNEXCEL);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, srcName) {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	switch (sAction) {
	case IBSEARCH:
		switch (srcName) {
			case "btn_retrieve":
				var check_cre_ofc_cd = document.form.input_cre_ofc_cd.value;
				var check_cust_cd = document.form.input_cust_cd.value;
				var check_dor_loc = document.form.dor_loc.value;
				if (ComIsNull(check_cre_ofc_cd) && ComIsNull(check_cust_cd) && ComIsNull(check_dor_loc)) {
					ComShowCodeMessage("TRS90124");
					fn_reset();
					return false;
				}
				break;
		}
		break;

	case IBSAVE:
		switch (srcName) {
			case "MST":
				rowcount = sheetObject1.RowCount();
				for (i = rowcount; i >= 0; i--) {
					if (ComIsNull(sheetObject1.GetCellValue(i, 'act_cust_bnd_cd')) || ComIsNull(sheetObject1.GetCellValue(i, 'dr_loc_value')) || ComIsNull(sheetObject1.GetCellValue(i, 'dr_yard_value'))) {
						sheetObject1.RowDelete(i, false);
					}
				}
				break;
			case "DTL":
				var rowcount = sheetObject2.RowCount();
				if (sAction == IBSAVE) {
					if (rowcount == 0) {
						ComShowCodeMessage(TRS90484);
						return false;
					}
				}
				var check_dflt_flg = sheetObject2.FindCheckedRow('dflt_act_cust_flg').split('|');
				if (check_dflt_flg == '' || check_dflt_flg == null) {
					check_dflt_flg = 0
				}
				var checkList = sheetObject1.FindCheckedRow('ib_chk').split('|');
				var mst_delt_flg = sheetObject1.GetCellValue(checkList, 'delt_flg');
				var dtl_delt_flg = sheetObject2.GetCellValue(check_dflt_flg, 'delt_flg');
				if (dtl_delt_flg == 'Y' && mst_delt_flg != 'Y') {
					ComShowCodeMessage("TRS90483");
					sheetObj.SetCellValue(check_dflt_flg, 'delt_flg', 'N', 0);
					return false;
				}
				break;
		}
		break;
	}
	return true;
}

/**
 * sheet1 Change Event
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'dr_loc_value':
			if (sheetObj.GetCellValue(row, 'dr_loc_value') != '') {
				getZoneSheetCombo1(sheetObj, document.form, row, col, "dr_yard_value", sheetObj.GetCellValue(row, "dr_loc_value"));
				sheetObj.SetCellEditable(row, "dr_yard_value", 1);
			}
			var dor_loc = sheetObj.GetCellValue(row, 'dr_loc_value');
			var dor_yard = sheetObj.GetCellValue(row, 'dr_yard_value');
			sheetObj.SetCellValue(row, 'dor_nod_cd', dor_loc + dor_yard);
			break;
	
		case 'dr_yard_value':
			var dor_loc = sheetObj.GetCellValue(row, 'dr_loc_value');
			var dor_yard = sheetObj.GetCellValue(row, 'dr_yard_value');
			sheetObj.SetCellValue(row, 'dor_nod_cd', dor_loc + dor_yard);
			break;
	
		case 'ib_chk':
			formObject.sel_trsp_act_cust_no.value = sheetObj.GetCellValue(row, "trsp_act_cust_no");
			break;
		case 'act_cust_cnt_cd':
			sheetObj.SetCellValue(row, col, value.toUpperCase(), 0);
			var act_cust_cnt_cd = sheetObj.GetCellValue(row, 'act_cust_cnt_cd');
			if (act_cust_cnt_cd == null)
				break;
			var act_cust_bnd_cd = sheetObj.GetCellValue(row, 'act_cust_bnd_cd');
			var dor_nod_cd = sheetObj.GetCellValue(row, 'dor_nod_cd');
			
			var urlStr = 'ibflag=R&act_cust_cnt_cd=' + act_cust_cnt_cd + '&act_cust_bnd_cd=' + act_cust_bnd_cd + '&dor_nod_cd=' + dor_nod_cd + '&col=act_cust_nm';
			formObject.f_cmd.value = SEARCH05;
			sheetObj.DoRowSearch(row, 'ESD_TRS_0082GS.do', urlStr + '&' + TrsFrmQryString(formObject), { Wait : 0, Sync : 2 });
			sheetObj.SetCellValue(row, 'ib_chk', 1, 0);
			break;
	
		case 'delt_flg':
		case 'act_cust_bnd_cd':
			sheetObj.SetCellValue(row, 'ib_chk', 1, 0);
			break;
	}
}

/**
 * sheet2 Change Event
 */
function sheet2_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case ('act_cust_eml'):
			var eMailchk = new RegExp('^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,6}\\b');
			var aRray = new Array();
			if (value.split(',').length > 1) {
				aRray = value.split(',');
				for ( var e = 0; e < aRray.length; e++) {
					if (!eMailchk.test(aRray[e]) && aRray[e] != '') {
						ComShowCodeMessage('TRS90525');
						sheetObj.SetCellValue(row, 'act_cust_eml', '', 0);
						sheetObj.SelectCell(row, 'act_cust_eml');
					}
				}
			} else if (value.split(';').length > 1) {
				aRray = value.split(';');
				for ( var e = 0; e < aRray.length; e++) {
					if (!eMailchk.test(aRray[e]) && aRray[e] != '') {
						ComShowCodeMessage('TRS90525');
						sheetObj.SetCellValue(row, 'act_cust_eml', '', 0);
						sheetObj.SelectCell(row, 'act_cust_eml');
					}
				}
			} else {
				if (!eMailchk.test(value) && value != '') {
					ComShowCodeMessage('TRS90525');
					sheetObj.SetCellValue(row, 'act_cust_eml', '', 0);
					sheetObj.SelectCell(row, 'act_cust_eml');
				}
			}
			break;
		case ('dflt_act_cust_flg'):
			var l_flg = sheetObj.GetCellValue(row, 'dflt_act_cust_flg');
			for ( var i = 1; i < (sheetObj.RowCount() + 1); i++) {
				sheetObj.SetCellValue(i, 'dflt_act_cust_flg', '', 0);
			}
			if (l_flg == '1') {
				sheetObj.SetCellValue(row, 'dflt_act_cust_flg', 'Y', 0);
			} else {
				sheetObj.SetCellValue(row, 'dflt_act_cust_flg', 'N', 0);
			}
			break;
	}
}

/**
 * sheet click시 일어나는 이벤트
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var colName = sheetObj.ColSaveName(col);
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var formObject = document.form;
	switch (colName) {

	case 'act_cust_bnd_cd':
	case 'dr_loc_value':
	case 'act_cust_cnt_cd':
	case 'delt_flg':
	case 'ib_chk':
	case 'act_cust_nm':
		sheetObj.SetCellValue(row, 'ib_chk', 1, 0);
		var act_cust_no_chk = sheetObject1.GetCellValue(row, "trsp_act_cust_no");
		if (act_cust_no_chk == null || act_cust_no_chk == '') {
			sheetObject2.RemoveAll();
			break;
		}
		// SHEET2 Detail 1번째 row의 cretaion date가 null이면 save가 안된 상태이기 때문에 return.
		var master_save_chk = sheetObject2.GetCellValue(row, "cre_dt");
		if (master_save_chk == null || master_save_chk == '') {
			sheetObject2.RemoveAll();
			break;
		}
		formObject.sel_trsp_act_cust_no.value = sheetObject1.GetCellValue(row, "trsp_act_cust_no");
		doActionIBSheet(sheetObject2, formObject, IBSEARCH, "DETAIL");
		break;
	}

}

/**
 * 조회조건 초기화 - new button Click 시
 */
function fn_reset() {
	var formObject = document.form;
	sheetObjects[2].RemoveAll(); // Excel sheet
	sheetObjects[1].RemoveAll(); // Detail sheet
	sheetObjects[0].RemoveAll(); // Master sheet
	// formObject.dor_nod.RemoveAll();
	formObject.status.value = "A";
	formObject.bound.value = "A";
	formObject.dor_loc.value = "";
	formObject.input_cust_cd.value = "";
	formObject.input_cust_nm.value = "";
	formObject.sel_trsp_act_cust_no.value = "";
	formObject.input_cre_ofc_cd.value = formObject.login_ofc_cd.value;
}

/**
 * Inquiry Option Door Location input, Yard Inquiry
 */
function getComboList(obj) {
	var dorNodObject = eval('dor_nod')
	var formObj = document.form;
	var locValue = obj.value.toUpperCase();
	if (ComTrim(locValue) == '') {
		dorNodObject.RemoveAll();
		return;
	}
	if (obj.name == 'dor_loc') {
		getZoneCombo(dorNodObject, sheetObjects[0], formObj, locValue);
	}
}

/**
 * Customer Popup
 */
function popCustomer() {
	ComOpenPopup('/opuscntr/COM_ENS_041.do', 770, 470, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * customer Popup
 */
function setCustomerPop(rowArray) {
	var formObj = document.form;
	var colArray = '';

	if (rowArray.length > 0) {
		formObj.input_cust_cd.value = rowArray[0][3];
	}

}

function fun_Focus(obj) {
	var val = obj.value;
	obj.value = val;
	obj.select();
}

/**
 * 공통 Multiple popup
 */
function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var rep_cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var cmdt_desc_val = ""; // 향후 사용가능 예정변수
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param = "?returnval=" + obj + "&returntitle=" + obj2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9+ "&pgmNo=ESD_TRS_0082";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[i];
		if (i == rowArray.length - 1) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if (obj == "OFC") {
		formObject.input_cre_ofc_cd.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

// Office의 Text 변경시
function fun_officeText() {
	document.form.input_cre_ofc_cd.value = document.form.input_cre_ofc_cd.value.toUpperCase();
}
