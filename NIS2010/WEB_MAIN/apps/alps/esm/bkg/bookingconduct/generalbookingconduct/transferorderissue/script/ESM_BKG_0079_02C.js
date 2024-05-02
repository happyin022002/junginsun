/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0079_02c.js
 *@FileTitle : TRO(Transportation Request Order) for Inland Haulage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 이남경
 *@LastVersion : 1.0
 * 2009.07.07 이남경
 * 1.0 Creation
===============================================================================
 * History
 * 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2011.02.21 이일민 [CHM-201108826] [BKG/DOC] TRO M/H 에 대한 Return / Pick up CY 란에 대해 Validation 추가 요청
 * 2011.06.03 채창호 [CHM-201111295] 구주 TRO/O 화면 Term관련 Pop-up warning msg
 * 2011.07.18 채창호 [CHM-201112283]: [BKG] 구주 TRO 화면에서의 Validation 강화 요청
 * 2011.10.04 전성진 [CHM-201112283] [BKG] 구주 TRO 화면에서의 Validation 강화 요청
 * 2011.10.14 전성진 [CHM-201113553-01] 금액의 소수점 자리수 변경
 * 2011.11.28 금병주 [CHM-201114706-01] [BKG_1139 :U/I제출] EUR TRO Notice 전송 Pop-up
 * 2011.12.02 금병주 [CHM-201114805] [BKG] 구주 TRO M/H 상 CNTR 중복 confirm 에 대한 Validation 추가 요청
 * 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
 * 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
 * 2012.10.04 조정민 [CHM-201220238] [BKG] [EUR TRO] ADD,Copy CNTR에 Optimum조회추가 & 금액읽어오는 로직 & 버튼색깔 보완
 * 2012.10.29 조정민 [CHM-201220788] [EUR TRO] Manifested Amount Hiding, Speical Instruction 공간확대
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
 * @class esm_bkg_0079_02c : esm_bkg_0079_02c 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0079_02c() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.obj_keypress_loc = obj_keypress_loc;
	this.obj_keyup_loc = obj_keyup_loc;
	this.initCombo = initCombo;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initSearchVal = initSearchVal;
	this.initControl = initControl;
	this.tro_seq_OnChange = tro_seq_OnChange;
	// 2011.12.02 dcgo_seq_OnChange 함수 추가 kbj
	this.dcgo_seq_OnChange = dcgo_seq_OnChange;
	this.dcgo_seq_OnCheckClick = dcgo_seq_OnCheckClick;
	this.rc_seq_OnChange = rc_seq_OnChange;
	this.awk_cgo_seq_OnChange = awk_cgo_seq_OnChange;
	this.obj_change_loc = obj_change_loc;
	this.hlg_tp_cd_OnChange = hlg_tp_cd_OnChange;
	this.dor_addr_tp_cd_OnChange = dor_addr_tp_cd_OnChange;
	this.bkg_trsp_mzd_cd_OnChange = bkg_trsp_mzd_cd_OnChange;
	this.changeTroSeqProc = changeTroSeqProc;
	this.changeTroSeqProc_dtl = changeTroSeqProc_dtl;
	this.changeEnabled_dtl_PrevNext = changeEnabled_dtl_PrevNext;
	this.changeDtlColor = changeDtlColor;
	this.changeMasterColor = changeMasterColor;
	this.changeEnabeld_haulage_dtl = changeEnabeld_haulage_dtl;
	this.changeEnabeld_haulage_master = changeEnabeld_haulage_master;
	this.changeEnabled_master = changeEnabled_master;
	this.changeEnabled_master_control = changeEnabled_master_control;
	this.changeEnabled_dtl = changeEnabled_dtl;
	this.changeEnabeld_btn_t2cT1Revenue = changeEnabeld_btn_t2cT1Revenue;
	this.deleteDtl = deleteDtl;
	this.copyRow = copyRow;
	this.copyAllRow_dtl = copyAllRow_dtl;
	this.addRow = addRow;
	this.setDataCopy = setDataCopy;
	this.setDataCopy_dtl = setDataCopy_dtl;
	this.copyTrodgseq = copyTrodgseq;
	this.setDefaultInsertRow = setDefaultInsertRow;
	this.setDefaultInsertRow_Dtl = setDefaultInsertRow_Dtl;
	this.changeTroQtyColor = changeTroQtyColor;
	this.changeSumTroQty = changeSumTroQty;
	this.plusMinusSumTroQty = plusMinusSumTroQty;
	this.checkCopySumTroqty = checkCopySumTroqty;
	this.clearHaulageData_master = clearHaulageData_master;
	this.clearFormData_master = clearFormData_master;
	this.clearHaulageData_dtl = clearHaulageData_dtl;
	this.clearFormData_dtl = clearFormData_dtl;
	this.setDataToForm_TroMst = setDataToForm_TroMst;
	this.setFormToData_TroMst = setFormToData_TroMst;
	this.setAllDataToData_TroDtl = setAllDataToData_TroDtl;
	this.setDataToAllData_TroDtl = setDataToAllData_TroDtl;
	this.setEtcDataToForm_bkg = setEtcDataToForm_bkg;
	this.setDataToForm_Tro_dg_seq = setDataToForm_Tro_dg_seq;
	this.setFormToData_Tro_dg_seq = setFormToData_Tro_dg_seq;
	this.comboCodeToSheet = comboCodeToSheet;
	this.getPrevMaxTroSeq = getPrevMaxTroSeq;
	this.getPrevMaxTroSubSeq = getPrevMaxTroSubSeq;
	this.findRow_dtl = findRow_dtl;
	this.findRow_dtl_curr = findRow_dtl_curr;
	this.findRow_dtl_max = findRow_dtl_max;
	this.setAddRemarkText = setAddRemarkText;
	this.changeDisplayBtn = changeDisplayBtn;
	this.setChangeAllComboBackColor = setChangeAllComboBackColor;
	this.setComboBackColor = setComboBackColor;
	this.changeAllCellEditable = changeAllCellEditable;
	this.checkTdDisabled = checkTdDisabled;
	this.checkInputDisabled = checkInputDisabled;
	this.changeMasterColor = changeMasterColor;
	this.changeEnabled_master_control = changeEnabled_master_control;
	this.changeEnabled_master = changeEnabled_master;
	this.validateForm = validateForm;
	this.checkDtl = checkDtl;
	this.checkMaster = checkMaster;
	this.chkMandatoryItem = chkMandatoryItem;
	this.chkMandatoryDate = chkMandatoryDate;
	this.getCOM_ENS_061_1 = getCOM_ENS_061_1;
	this.comBkgCallPop0703 = comBkgCallPop0703;
	this.comBkgCallPop0906 = comBkgCallPop0906;
	this.comBkgCallPop0921 = comBkgCallPop0921;
	this.setCntrNoCallBack = setCntrNoCallBack;
	this.setT1RevenueCallBack = setT1RevenueCallBack;
	this.setConfirmCallBack = setConfirmCallBack;
	this.ComEnableObject_loc = ComEnableObject_loc;
	this.ComEnableManyObjects_loc = ComEnableManyObjects_loc;
	this.ComClassNameManyObjects_loc = ComClassNameManyObjects_loc;
	this.ComEnableManyIBCombo = ComEnableManyIBCombo;
	this.ComEnableManyTd = ComEnableManyTd;
	this.delComma_loc = delComma_loc;
	this.delMask_loc = delMask_loc;
	this.changeMask_hm_loc = changeMask_hm_loc;
	this.changeMask_ymd_loc = changeMask_ymd_loc;
	this.changeComma_loc = changeComma_loc;
	this.Comma_Input = Comma_Input;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var arrData = new Array();

// ---------------------------------
// 순서에 관계없이 명칭을 사용하기 위해, 전역변수화
var x_sheetObject2 = null;
var x_sheetObject3 = null;
var x_sheetObject4 = null;
var x_sheetObject5 = null;
var x_sheetObjMsg = null;

var x_oldTroSeq = ""; // 이전에 선택된 tro_seq 값
var x_cancelAllFlg = "N"; // Y:cancelAll 처리됨
var tab_alert_msg = false; // 메세지 표시유무
var glineRevAmtFlg = "N";
var t1RevClickFlg = false;
var pass_flg = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != "btn_splitPop") {
			if (layList.style.display == "") {
				layList.style.display = "none";
			}
		}

		switch (srcName) {
		case "btn_splitPop":
			doActionIBSheet(x_sheetObjMsg, formObject, COMMAND03);
			break;

		case "btn_Danger":
			if (checkTdUnLink(srcName))	return false;
			var bkgNo = formObject.bkg_no.value;
			var caFlg = formObject.ca_flg.value;
			comBkgCallPop0200(bkgNo, caFlg);
			break;
		case "btn_Reefer":
			if (checkTdUnLink(srcName))	return false;
			var bkgNo = formObject.bkg_no.value;
			var caFlg = formObject.ca_flg.value;
			comBkgCallPop0498(bkgNo, caFlg);
			break;
		case "btn_Awkward":
			if (checkTdUnLink(srcName))	return false;
			var bkgNo = formObject.bkg_no.value;
			var caFlg = formObject.ca_flg.value;
			comBkgCallPop0055(bkgNo, caFlg);
			break;

		case "btn_t2cAdd":
			if (checkTdDisabled(srcName)) return false;
			if (x_sheetObject2.RowCount <= 0) {
				callShowMessageAddCNTR();
				return false;
			}
			addRow(x_sheetObject3);
			doActionIBSheet(x_sheetObject2, formObject, COMMAND05);
			
			break;

		case "btn_t2cDelete":
			if (checkTdDisabled(srcName)) return false;
			if (x_sheetObject2.RowCount <= 0) {
				callShowMessageAddCNTR();
				return false;
			}
			
			if (getTroSubSeqCount(formObject.tro_seq.Code) < 2) return false;
			
			if (!ComShowCodeConfirm("COM12194", "")) {
				return false;
			}
			//2) save & delete : call
			deleteDtl();
			doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y");
			doActionIBSheet(x_sheetObject2, document.form, COMMAND05);
			break;

		case "btn_t2cPrevious":
			changeTroSeqProc_dtl("P");
			break;

		case "btn_t2cNext":
			changeTroSeqProc_dtl("N");
			break;

		case "btn_t2cRetrieve":
			if (checkTdDisabled(srcName)) return false;
			pass_flg = true;
			formObject.curr_tro_seq.value = ""; // default 순번 clear
			formObject.curr_tro_sub_seq.value = ""; // default 순번 clear : sub
			formObject.optm_sts_cd.value = ""; // default 순번 clear : sub
			
			doActionIBSheet(x_sheetObject2, formObject, IBSEARCH);
			

			break;

		case "btn_t2cSave":
			if (checkTdDisabled(srcName)) return false;
			doActionIBSheet(x_sheetObject2, formObject, IBSAVE);
			break;

		case "btn_t2cSaveSeq": //단건 Seq만 저장
			doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "C");
			break;

		case "btn_t2cConfirm":
			if (checkTdDisabled(srcName)) return false;
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			var routeModifyFlag = nullToBlank(formObject.routeModifyFlag.value);
			var io_bnd_cd = nullToBlank(formObject.io_bnd_cd.value); // hidden

			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			if (routeModifyFlag == "Y") {
				ComShowCodeMessage("BKG08208");
				ComSetFocus(bkg_no);
				return false;
			}
//			if (formObject.optm_sts_cd.Code != "Y" && formObject.not_optm_rsn.value == "" && formObject.hlg_tp_cd.Code == "C"){
//				ComShowCodeMessage("BKG95054");
//				return false;
//			}
//			if (formObject.bkg_trsp_mzd_cd.Text == "" && formObject.hlg_tp_cd.Code == "C") {
//				ComShowCodeMessage("BKG02117");
//				return false;
//			}
//			if(checkNotExistDoor() > 0 && formObject.hlg_tp_cd.Code == "C") {
//				ComShowCodeMessage("BKG02118");
//				return false;
//			}
			
			comBkgCallPop0906('setConfirmCallBack', bkg_no, io_bnd_cd);
			break;

		case "btn_t2cCancelFrustrate":
			if (checkTdDisabled(srcName)) return false;
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			var io_bnd_cd = nullToBlank(formObject.io_bnd_cd.value); // hidden
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			//1) 저장
			doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "CF");

			// 2) 팝업
			// comBkgCallPop0703('setCxlFrustCallBack', bkg_no, io_bnd_cd); //후속처리로 변경할 것!!!!!!!
			break;

		case "btn_t2cAddCNTR":
			if (checkTdDisabled(srcName)) return false;
			var bResult = checkAddSumTroqty();
			if (!bResult) {
				ComShowCodeMessage("BKG00420");
				return false;
			}
			addRow(x_sheetObject2);
			doActionIBSheet(x_sheetObject2, document.form, COMMAND05);
			

			if(formObject.hlg_tp_cd.Code == "M" && formObject.io_bnd_cd.value=="I" && formObject.cfm_flg.value == "Yes"){
				ComEnableManyTd(true, "btn_t2cDropOff");
			}else{
				ComEnableManyTd(false, "btn_t2cDropOff");
			}
			break;

		case "btn_t2cCopyCNTR":
			if (checkTdDisabled(srcName)) return false;
			if (x_sheetObject2.RowCount <= 0) {
				callShowMessageAddCNTR();
				return false;
			}
			var bResult = checkCopySumTroqty(x_sheetObject2);
			if (!bResult) {
				return false;
			}
			copyRow(x_sheetObject2);
			break;

		case "btn_t2cTROCopy":
			if (checkTdDisabled(srcName)) return false;
			var bkgNo = nullToBlank(formObject.bkg_no.value);
			var bkgNoOld = nullToBlank(formObject.oldBkgNo.value);
			if (bkgNo == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkgNo != bkgNoOld) {
				ComShowCodeMessage("BKG00048", bkgNoOld, bkgNo);
				ComSetFocus(bkg_no);
				return false;
			}
			var boundCd = nullToBlank(formObject.io_bnd_cd.value);
			var troSeq = nullToBlank(formObject.tro_seq.Text);
			var uiId = "ESM_BKG_0079_02C";
			comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq, uiId);
			break;

		case "btn_t2cTRONotice":
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			var boundCd = nullToBlank(formObject.io_bnd_cd.value);
			formObject.eml.value = nullToBlank(formObject.cntc_eml.value);
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			//2011.11.28
			var sUrl = "/hanjin/ESM_BKG_1139.do?pgmNo=ESM_BKG_1139&ui_id=ESM_BKG_0079_02C&bkg_no=" + bkg_no + "&io_bnd_cd=" + boundCd;
			if(boundCd == "O"){
				ComOpenWindowCenter(sUrl, "ESM_BKG_1139", 600, 300, false);
			} else {
				ComOpenWindowCenter(sUrl, "ESM_BKG_1139", 600, 450, false);
			}
			break;

		case "btn_t2cMulti":
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			var cntr_no = nullToBlank(formObject.cntr_no.value);
			var boundCd = nullToBlank(formObject.io_bnd_cd.value);
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			comBkgCallPop0921('setMultiCallBack', bkg_no, cntr_no, boundCd);
			break;

		case "btn_t2cT1Revenue":
			t1RevClickFlg = true;
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			if(formObject.cntr_no.value =="" && formObject.io_bnd_cd.value == 'I'){
				ComShowCodeMessage("BKG01101","CNTR NO");
				return false;
			}
			//과거데이터를 위해 Confirm 또는 Cancel 된 경우 validation 예외처리
			if(formObject.cxl_flg.value != "Y" && formObject.cfm_flg.value != "Yes") {
				if(formObject.hlg_tp_cd.Code == "C") {
					if (formObject.bkg_trsp_mzd_cd.Text == "") {
						ComShowCodeMessage("BKG02117");
						ComSetFocus(bkg_no);
						return false;
					}
					if (formObject.cntr_tpsz_cd.value == "") {
						ComShowCodeMessage("BKG00887", "TP/SZ");
						return false;
					}
				}
			}

			var currTroSeq = document.form.tro_seq.Text;
			var currTroSubSeq_v = document.form.tro_sub_seq.value;
			setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");
			
//			입력한 detail 데이터 처리 후에 체크해야하기 때문에 setDataToAllData_TroDtl 다음에 위치함
			if(formObject.cxl_flg.value != "Y" && formObject.cfm_flg.value != "Yes") {
				if(!checkExistDoor(formObject.tro_seq.Code) && formObject.hlg_tp_cd.Code == "C") {
					ComShowCodeMessage("BKG02118");
					return false;
				}
			}
			var t1_doc_flg = nullToBlank(formObject.t1_doc_flg.value);
			var cstms_clr_no = nullToBlank(formObject.cstms_clr_no.value);
			var all_in_rt_cd = nullToBlank(formObject.all_in_rt_cd.value);
			var curr_cd = nullToBlank(formObject.curr_cd.value);
			var trns_rev_amt = nullToBlank(formObject.trns_rev_amt.value);
			var non_trns_rev_amt = nullToBlank(formObject.non_trns_rev_amt.value);
			var add_rev_amt = nullToBlank(formObject.add_rev_amt.value);
			var add_rev_chg_cd = nullToBlank(formObject.add_rev_chg_cd.value);
			var add_rev_amt2 = nullToBlank(formObject.add_rev_amt2.value);
			var add_rev_chg_cd2 = nullToBlank(formObject.add_rev_chg_cd2.value);
			var add_rev_amt3 = nullToBlank(formObject.add_rev_amt3.value);
			var add_rev_chg_cd3 = nullToBlank(formObject.add_rev_chg_cd3.value);
			var add_rev_rmk = nullToBlank(formObject.add_rev_rmk.value);
			var cxl_flg = nullToBlank(formObject.cxl_flg.value);
			var vat_flg = nullToBlank(formObject.vat_flg.value);
			var term = nullToBlank(formObject.term.value);
			var hlg_tp_cd = nullToBlank(formObject.hlg_tp_cd.Text);
			var io_bnd_cd = nullToBlank(formObject.io_bnd_cd.value);
			var cfm_flg = (nullToBlank(formObject.cfm_flg.value)== "Yes") ? "Y" : "N";
			var so_flg = (nullToBlank(formObject.so_no.value) == "") ? "N" : "Y";
			var cntr_tpsz_cd = nullToBlank(formObject.cntr_tpsz_cd.value);
			var bse_port_loc_cd = (formObject.io_bnd_cd.value == "O") ? nullToBlank(formObject.pol_code.value): nullToBlank(formObject.pod_cd.value);
			var pnt_loc_cd = (formObject.io_bnd_cd.value == "O") ? findDoorLoc(true) : findDoorLoc(false);
			var trsp_mode_cd = nullToBlank(formObject.bkg_trsp_mzd_cd.Code);
			var rf_flag = (formObject.rc_seq.Code == "") ? "N" : "Y";
			var awk_flag = (formObject.awk_cgo_seq.index > 0) ? "Y" : "N";
			var dg_flag = (formObject.dcgo_seq.Code == "") ? "N" : "Y";
			var cfm_dt = nullToBlank(formObject.cfm_dt.value);
			var optm_sts_cd = nullToBlank(formObject.optm_sts_cd.Code);
			var cntr_no = nullToBlank(formObject.cntr_no.value);
			var cgo_wgt = nullToBlank(formObject.cgo_wgt.value).replace(/,/gi, '');;

			comBkgCallPop0317('setT1RevenueCallBack', bkg_no, t1_doc_flg, cstms_clr_no, all_in_rt_cd, curr_cd
					                                , trns_rev_amt, non_trns_rev_amt, add_rev_amt, add_rev_chg_cd, add_rev_rmk, cxl_flg
					                                , term, vat_flg, hlg_tp_cd, io_bnd_cd, so_flg
					                                , cntr_tpsz_cd, bse_port_loc_cd, pnt_loc_cd, trsp_mode_cd
					                                , rf_flag, awk_flag, dg_flag, cfm_dt, optm_sts_cd, cntr_no, cgo_wgt
					                                , add_rev_amt2, add_rev_chg_cd2 , add_rev_amt3, add_rev_chg_cd3);
			break;
			
			
		case "btn_t2cDropOff":
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}

			
			var param = "";
			param += "?popup=yes"
			param += "&bkg_no=" + bkg_no;
			param += "&cntr_no=" + nullToBlank(formObject.cntr_no.value);
//			ComOpenPopup("/hanjin/EES_DOD_0001.do" + param, 850, 700, '', '1,0,1,1,1,1,1,1,1,1,1,1', true); 
			
//			ComOpenWindowCenter("EES_DOD_0001.do"+param, "", '1024', '700', false, "yes");
			ComOpenWindowCenter2("/hanjin/EES_DOD_0001.do" + param, "Amend Reason", 1024, 700, false, "scrollbars=yes,resizable=yes");
			break;

//		case "btns_t2cSearchCntrNo":
//			if (checkInputDisabled("cntr_no")) return false;
//			var bkg_no = nullToBlank(formObject.bkg_no.value);
//			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
//			var io_bnd_cd = nullToBlank(formObject.io_bnd_cd.value); // hidden
//			if (bkg_no == "") {
//				ComShowCodeMessage("BKG00255");
//				ComSetFocus(bkg_no);
//				return false;
//			}
//			if (bkg_no != bkg_no_old) {
//				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
//				ComSetFocus(bkg_no);
//				return false;
//			}
//			comBkgCallPop0907('setCntrNoCallBack', bkg_no, io_bnd_cd);
//			break;

		case "btns_repCommodity":
			if (checkInputDisabled("rep_cmdt_cd")) return false;
			break;

		case "btns_popLocation":
			if (checkInputDisabled("zn_cd")) return false;
			// var cnt_cd = formObject.por_cd.value.substr(0,2); //국가코드 -> 사용않함
			var cnt_cd = "";
			var node_cd = "";
			var dor_loc_cd = formObject.dor_loc_cd.value;
			var zn_cd = formObject.zn_cd.value;
			if (dor_loc_cd.length == 5 && zn_cd.length == 2) {
				node = dor_loc_cd + zn_cd;
			}
			var param = "";
			param += "?cnt_cd=" + cnt_cd;
			param += "&loc_cd=" + dor_loc_cd;
			param += "&ofc_cd=" + "N";
			param += "&node_cd=" + node_cd;
			param += "&mode=" + "zone";
			param += "&mode_only=" + "Y";
			ComOpenPopup("/hanjin/COM_ENS_061.do" + param, 780, 470, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
			break;

		case "btns_Address":
			if (checkInputDisabled("dor_addr_1")) return false;
			var conti_cd = document.form.conti_cd.value; // hidden : 대륙코드
			var cnt_cd = document.form.por_cd.value.substr(0, 2); // 국가코드 -> 사용않함
			var dor_loc_cd = document.form.dor_loc_cd.value;
			var act_shpr_cnt_cd = document.form.cust_cnt_cd.value;
			var act_shpr_seq = document.form.cust_seq.value;
			var act_shpr_nm = document.form.cust_nm.value;
			var arrAct_shpr_nm = act_shpr_nm.split(" ");
			act_shpr_nm = arrAct_shpr_nm[0];
			var bkg_no = nullToBlank(formObject.bkg_no.value);
			var bkg_no_old = nullToBlank(formObject.oldBkgNo.value);
			if (bkg_no == "") {
				ComShowCodeMessage("BKG00255");
				ComSetFocus(bkg_no);
				return false;
			}
			if (bkg_no != bkg_no_old) {
				ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
				ComSetFocus(bkg_no);
				return false;
			}
			comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
			break;

		case "btns_calendar":
			if (checkInputDisabled("cntr_rtn_dt")) return false;
			var cal = new ComCalendar();
			cal.select(formObject.cntr_rtn_dt, 'yyyy-MM-dd');
			break;
		case "btns_calendar_2":
			if (checkInputDisabled("cntr_pkup_dt")) return false;
			var cal = new ComCalendar();
			cal.select(formObject.cntr_pkup_dt, 'yyyy-MM-dd');
			break;
		case "btns_calendar_3":
			if (checkInputDisabled("arr_dt")) return false;
			var cal = new ComCalendar();
			cal.select(formObject.arr_dt, 'yyyy-MM-dd');
			break;

		} // end switch
	} catch (e) {
		ComShowMessage(e);
	}
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
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;

	// 버튼링크/버튼 출력처리 ------------->
	changeDisplayBtn("btn_Danger", "N");
	changeDisplayBtn("btn_Reefer", "N");
	changeDisplayBtn("btn_Awkward", "N");
	// <----------------------------------

	for ( var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	//**************************************************************
	x_sheetObject5 = sheetObjects[0]; // sum_qty 화면
	x_sheetObject2 = sheetObjects[1]; // tro all hidden
	x_sheetObject3 = sheetObjects[2]; // tro_dtl all hidden
	x_sheetObject4 = sheetObjects[3]; // tro_dg_seq all hidden
	x_sheetObjMsg = sheetObjects[4]; // msg hidden
	// **************************************************************

	// ---------------
	// IBMultiCombo 초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	ComEnableManyIBCombo(false, "#CCFFFD", formObj.optm_sts_cd);
	//---------------
	// iframe 생성
	// CofigIframe();

	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
	axon_event.addListenerForm('keyup', 'obj_keyup_loc', document.form);
	axon_event.addListenerForm('change', 'obj_change_loc', document.form);
	axon_event.addListenerForm('keydown', 'check_Enter', document.form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	if (formObj.bkg_no.value != "" || formObj.bl_no.value != "") {
		formObj.curr_tro_seq.value = ""; // default 순번 clear
		formObj.curr_tro_sub_seq.value = ""; // default 순번 clear : sub
		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);
	} else {
		//Search버튼만 enabled
		ComEnableManyTd(true, "btn_t2cRetrieve", "btn_t2cTRONotice");
		ComEnableManyTd(false, "btn_t2cSave", "btn_t2cSaveSeq", "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cAddCNTR", "btn_t2cCopyCNTR", "btn_t2cDeleteCNTR", "btn_t2cAdd", "btn_t2cDelete", "btn_t2cPrevious", "btn_t2cNext");
	}

	if(document.form.io_bnd_cd.value=="I"){
		eval('DIV_btn_t2cDropOff').style.display = 'block';
	}
	//------------------------------------------------>
	// setInquiryDisableButton 이벤트 호출
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
}

function initControl() {
	applyShortcut();
}

/** 
 * 업무 자바스크립트 OnKeyPress 이벤트 처리 
 */
function obj_keypress_loc() {
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");

	switch (event.srcElement.dataformat) {
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		//영문 대문자만 입력하기
		ComKeyOnlyAlphabet('upper');
		break;
	case "int":
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "uppernum":
		//영문 대문자+숫자
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "tel":
		// 숫자+"-"입력하기
		ComKeyOnlyNumber(event.srcElement, " -");
		break;
	case "ymd":
	case "hm":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
		ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
		break;
	}
}
function obj_keyup_loc() {
	var formObj = document.form;

	with (formObj) {
		//textarea : enter 제외
		if (event.srcElement.type == "textarea") {
			return;
		}
		if (window.event.keyCode == 13) {
			formObj.curr_tro_seq.value = ""; // default 순번 clear
			formObj.curr_tro_sub_seq.value = ""; // default 순번 clear : sub

			return;
		}

		switch (event.srcElement.name) {
		case "cgo_wgt":
			cgo_wgt.value = changeComma_loc(cgo_wgt.value, 0, 9, 3);
			break;
		}

		var srcName = event.srcElement.getAttribute("name");
		var srcValue = event.srcElement.getAttribute("value");
		switch (event.srcElement.dataformat) {
		case "ymd":
			formObj.elements[srcName].value = changeMask_ymd_loc(event.srcElement, "-");
			if (formObj.elements[srcName].value.length == 10) {
				if (!ComChkObjValid(event.srcElement, true, true, false)) return false; // eval("formObj."+srcName)
				break;
			}
			break;
		case "hm":
			formObj.elements[srcName].value = changeMask_hm_loc(event.srcElement, ":");
			if (formObj.elements[srcName].value.length == 5) {
				if (!ComChkObjValid(event.srcElement, true, true, false)) return false; // eval("formObj."+srcName)
				break;
			}
			break;
		}
	}
}

function initCombo(comboObj, comboNo) {
	with (comboObj) {
		MultiSeparator = "|";

		switch (comboObj.id) {
		case "tro_seq":
			SetColWidth("46");
			break;

		case "dcgo_seq":
			SetColWidth("40|280");
			SetTitle("seq|Remark");
			// 2011.12.02
			MultiSelect = false;
			break;

		case "rc_seq":
			SetColWidth("40|380");
			SetTitle("seq|Remark");
			break;

		case "awk_cgo_seq":
			SetColWidth("70");
			break;

		case "hlg_tp_cd":
			comboObj.InsertItem(-1, "C", "C"); // "Carrier Haulage"
			comboObj.InsertItem(-1, "M", "M"); // "Merchant Haulage"
			break;

		case "bkg_trsp_mzd_cd":
			break;

		case "dor_addr_tp_cd":
			comboObj.InsertItem(-1, "", "");
			comboObj.InsertItem(-1, "Door", "D");
			comboObj.InsertItem(-1, "Customs", "C");
			break;
			
		case "optm_sts_cd":
			comboObj.InsertItem(-1, "", "");
			comboObj.InsertItem(-1, "N/A", "A");
			comboObj.InsertItem(-1, "Y", "Y");
			comboObj.InsertItem(-1, "N", "N");
			break;			
			
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "t2csheet2": //t2csheet2 init : all-master <hidden>  
		with (sheetObj) {
			// 높이 설정
//			style.height = 150;
//			style.height = 1;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = " |";
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = " | |rqst_sub_seq|cntr_no|cntr_tpsz_cd|hlg_tp_cd|cgo_wgt|cntr_pkup_yd_cd|cntr_rtn_yd_cd";
			HeadTitle += "|cntr_rtn_dt|cntr_rtn_dt_hhmi|tro_cmdt_cd|rep_cmdt_cd|rep_cmdt_nm|bkg_trsp_mzd_cd|cntr_pkup_dt|cntr_pkup_dt_hhmi";
			HeadTitle += "|spcl_instr_rmk|optm_sts_cd|not_optm_rsn|cfm_flg|cfm_dt|cfm_ofc_cd|cfm_usr_id|cfm_usr_nm|so_no|so_dt|so_ofc_cd|so_usr_id|so_usr_nm|cntr_prt_flg|t1_doc_flg";
			HeadTitle += "|cstms_clr_no|all_in_rt_cd|curr_cd|trns_rev_amt|non_trns_rev_amt|add_rev_amt|add_rev_chg_cd|add_rev_chg_cd2|add_rev_amt2|add_rev_chg_cd3|add_rev_amt3|vat_flg|cxl_flg|cntr_tpsz_cd_old|hlg_tp_cd_old|rc_seq|awk_cgo_seq|eur_trns_tp_cd";
			HeadTitle += "|split_rmk|add_rev_rmk|org_trns_mod_cd|dest_trns_mod_cd";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false); // test grid용

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "tro_seq", false, "", dfNone, 0, true); // dtHidden

			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "rqst_sub_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "cxl_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_tpsz_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "hlg_tp_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cgo_wgt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_pkup_yd_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_rtn_yd_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_rtn_dt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_rtn_dt_hhmi", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "tro_cmdt_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "rep_cmdt_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "rep_cmdt_nm", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "bkg_trsp_mzd_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_pkup_dt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_pkup_dt_hhmi", false, "", dfNone, 0, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "spcl_instr_rmk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "optm_sts_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "not_optm_rsn", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cfm_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cfm_dt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cfm_ofc_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cfm_usr_id", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cfm_usr_nm", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "so_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "so_dt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "so_ofc_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "so_usr_id", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "so_usr_nm", false, "", dfNone, 0, true);

			// (hidden)KeyCode-->
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_prt_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "t1_doc_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cstms_clr_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "all_in_rt_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "curr_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "trns_rev_amt", false, "", dfNullFloat, 2, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "non_trns_rev_amt", false, "", dfNullFloat, 2, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_amt", false, "", dfNullFloat, 2, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_chg_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_amt2", false, "", dfNullFloat, 2, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_chg_cd2", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_amt3", false, "", dfNullFloat, 2, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "add_rev_chg_cd3", false, "", dfNone, 0, true);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "vat_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "cntr_tpsz_cd_old", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "hlg_tp_cd_old", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "rc_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "awk_cgo_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "eur_trns_tp_cd", false, "", dfNone, 0, true);

			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "split_rmk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "add_rev_rmk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "org_trns_mod_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "dest_trns_mod_cd", false, "", dfNone, 0, true);

			// hidden-Grid Speed Option 처리----------->
			sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
			CountPosition = 0;
			// <---------------------------------------

			WaitImageVisible = false;
		}
		break;

	case "t2csheet3": //t2csheet3 init : all-detail <hidden>   			
		with (sheetObj) {
			// 높이 설정
//			style.height = 120;
//			style.height = 1;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = " | |tro_seq|tro_sub_seq|dor_addr_tp_cd|dor_loc_cd|zn_cd|lod_ref_no|dor_pst_no|dor_addr_1|dor_addr_2";
			HeadTitle += "|dor_addr_3|dor_addr_4|arr_dt|arr_dt_hhmi|cntc_pson_nm|cntc_phn_no|cntc_eml|cxl_flg"; // 20 cols
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daLeft, false, "ibflag");
			// InitDataProperty(0, cnt++ , dtDummyCheck, 30, daLeft, false, "del_chk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtDummyCheck, 30, daLeft, false, "chk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "tro_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "tro_sub_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_addr_tp_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "dor_loc_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "zn_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "lod_ref_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_pst_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_addr_1", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_addr_2", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_addr_3", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "dor_addr_4", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "arr_dt", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "arr_dt_hhmi", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "cntc_pson_nm", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "cntc_phn_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "cntc_eml", false, "", dfNone, 0, true);
			// hidden 처리할 것!!!!!!!
			InitDataProperty(0, cnt++, dtData, 60, daLeft, false, "cxl_flg", false, "", dfNone, 0, true);

			// hidden-Grid Speed Option 처리----------->
			sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
			CountPosition = 0;
			// <---------------------------------------

			WaitImageVisible = false;
		}
		break;

	case "t2csheet4": //t2csheet4 init : tro_dg_seq all <hidden>  
		with (sheetObj) {
			// 높이 설정
//			 style.height = 150;
//			style.height = 1;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = " | | | "; // 4 cols
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false); // test grid용

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 27, daCenter, false, "del_chk");
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "tro_seq", false, "", dfNone, 0, false); // dtHidden
			InitDataProperty(0, cnt++, dtData, 30, daLeft, false, "tro_dcgo_seq", false, "", dfNone, 0, false);

			// hidden-Grid Speed Option 처리----------->
			sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
			CountPosition = 0;
			// <---------------------------------------

			WaitImageVisible = false;
		}
		break;

	case "t2csheet5": //t2csheet5 init : sum_qty grid
		with (sheetObj) {
			//높이 설정
			style.height = 102;
			// 전체 너비 설정 
			// SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "TP/SZ|Total Qty|C/H|M/H"; // 4 cols
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false); // test grid용

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "total_qty", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 52, daRight, false, "tro_qty_ch", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 52, daRight, false, "tro_qty_mh", false, "", dfNullInteger, 0, false, false);

			// hidden-Grid Speed Option 처리----------->
			sheetObj.SpeedOption = "NOPROGRESSTICK, NOFIT, NOSUM, NOSEQ, NOCALC, NOROWHEIGHT, NOMERGEROW, NOCOMBO";
			CountPosition = 0;
			// <---------------------------------------

			WaitImageVisible = false;
		}
		break;

	case "t2cmsgsheet1": //t2cmsgsheet1 init : msg 전용 grid
		with (sheetObj) {
			// 높이 설정
//			 style.height = 150;
			// 전체 너비 설정
			// SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");

			WaitImageVisible = false;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, delFlg, trspChgFlg) {
	//   sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case COMMAND03: //booking split no조회 
		formObj.f_cmd.value = COMMAND03;
		var param = "f_cmd=" + COMMAND03 + "&bkg_no=" + formObj.bkg_no.value;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_02CGS.do", param);
		var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -23);
		break;

	case COMMAND04: //container별 cago weight 조회 
		formObj.f_cmd.value = COMMAND04;
		var param = "f_cmd=" + COMMAND04 + "&bkg_no=" + formObj.bkg_no.value + "&cntr_no=" + formObj.cntr_no.value;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_02CGS.do", param);
		sheetObj.LoadSearchXml(sXml);

		// 01. cgo_wgt 변경
		var boundCd = formObj.io_bnd_cd.value;
		var cntrNo = formObj.cntr_no.value;

		// if ("I" == boundCd && cntrNo.length >= 11) {
		if ("I" == boundCd && cntrNo.trim() != "") {
			var t_cgo_wgt = nullToBlank(ComGetEtcData(sXml, "cgo_wgt"));
			if ("" == t_cgo_wgt) {
				var bResult = ComShowCodeMessage("BKG00379"); // return 필수.
			}
			formObj.cgo_wgt.value = t_cgo_wgt;
			ComSetFocus(formObj.cgo_wgt);
		}

		//02. tpsz 변경
		var preVal_type = formObj.cntr_tpsz_cd.value;
		var nxtVal_type = nullToBlank(ComGetEtcData(sXml, "cntr_tpsz_cd"));
		var preVal_hlg = formObj.hlg_tp_cd.Code;
		var nxtVal_hlg = formObj.hlg_tp_cd.Code;

		formObj.cntr_tpsz_cd.value = nxtVal_type;
		changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1"); // change : plus/minus
		break;

	case IBSEARCH:
		if (!validateForm(sheetObj, formObj, sAction)) return;

		initSearchVal(); // 전역변수등 clear[load상태로]

		formObj.f_cmd.value = SEARCH;
		ComOpenWait(true);
		var parm = "f_cmd=" + SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&io_bnd_cd=" + formObj.io_bnd_cd.value;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_02CGS.do", parm);
		var arrXml = sXml.split("|$$|");
		ComOpenWait(false); // 대기창 사라짐

		if (ComGetEtcData(arrXml[0], "DataYn") == "N") {
			x_sheetObjMsg.LoadSearchXml(arrXml[0]);
			formObj.bkg_no.value = formObj.oldBkgNo.value;
			formObj.bl_no.value = formObj.oldBlNo.value;
			return;
		}

		x_sheetObject2.RemoveAll();
		//(정보 조회 all): Start------------------------------------------>
		if (arrXml.length > 0) 
		{
			x_sheetObject4.LoadSearchXml(arrXml[2]);
			ComBkgXml2ComboItem(arrXml[3], formObj.dcgo_seq, "display_nm", "dg_seq");
			ComBkgXml2ComboItem(arrXml[4], formObj.rc_seq, "display_nm", "rf_seq");
			ComBkgXml2ComboItem(arrXml[5], formObj.awk_cgo_seq, "awk_seq", "awk_seq");
			ComBkgXml2ComboItem(arrXml[7], formObj.bkg_trsp_mzd_cd, "val", "desc");
			ComBkgXml2ComboItem(arrXml[0], formObj.tro_seq, "tro_seq", "tro_seq");
     		arrData = ComBkgXml2ComboString(arrXml[8], "val", "name");

			x_sheetObject2.LoadSearchXml(arrXml[0]);
			setEtcDataToForm_bkg(formObj, x_sheetObject2);

			// max_tro_seq_old : setting
			var max_tro_seq_old = x_sheetObject2.CellValue(x_sheetObject2.RowCount, "tro_seq");
			formObj.max_tro_seq_old.value = (nullToBlank(max_tro_seq_old.trim()) == "") ? "0" : max_tro_seq_old;

			setDataToForm_TroMst(x_sheetObject2.CellValue(1, "tro_seq"));
		}

		x_sheetObject3.RemoveAll();
		if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) 
		{
			x_sheetObject3.LoadSearchXml(arrXml[1]);
		}
		setAllDataToData_TroDtl(formObj.tro_seq.text, 1);  //nRow_tro_sub_seq : 1
		
		//<--------------------------------------------(정보 조회 all): End 
		x_sheetObject5.RemoveAll();
		if (ComGetTotalRows(arrXml[6]) > 0) 
		{
			x_sheetObject5.LoadSearchXml(arrXml[6]);
			changeTroQtyColor(x_sheetObject5);
		}
		
		// tot tro_seq가 '0'이면, default seq Add
		if (formObj.tro_seq_maxcnt.value == "0") {
			addRow(x_sheetObject2);
		} else {
			if (formObj.curr_tro_seq.value != "") {
				formObj.tro_seq.Text = formObj.curr_tro_seq.value;				 //default seq set : onchange!!!!!!!!
				// formObj.tro_sub_seq.Text = formObj.curr_tro_sub_seq.value;	 //default suvseq set : onchange!!!!!!!! ????????????????
			}
		}

		// 2010.2.18 by 신자영 
		if ('X' == ComGetObjValue(formObj.bkg_sts_cd)) {
			ComEnableManyTd(false, "btn_t2cRetrieve", "btn_t2cSave", "btn_t2cSaveSeq", "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cTRONotice", "btn_t2cAddCNTR", "btn_t2cCopyCNTR");
		} else {
			ComEnableManyTd(true, "btn_t2cRetrieve", "btn_t2cSave", "btn_t2cSaveSeq", "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cTRONotice", "btn_t2cAddCNTR", "btn_t2cCopyCNTR");
		}
		if(formObj.hlg_tp_cd.Code == "M" && formObj.io_bnd_cd.value=="I" && formObj.cfm_flg.value == "Yes"){
			ComEnableManyTd(true, "btn_t2cDropOff");
		}else{
			ComEnableManyTd(false, "btn_t2cDropOff");
		}
//		changeEnabeld_btn_t2cT1Revenue();
		ComSetObjValue(formObj.modify_flag, "N");
		// ------------------------------------------------>
		// setInquiryDisableButton 이벤트 호출
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}

		if(formObj.optm_sts_cd.Code == "" && formObj.hlg_tp_cd.Code == "C" 
			&& formObj.cxl_flg.value != "Y" && ComIsEmpty(formObj.so_no.value) && formObj.cfm_flg.value != "Yes") {
			doActionIBSheet(x_sheetObject2, formObj, COMMAND05);
		}
		
		//2) C/A 버튼 Control                
		parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"),
							 ComGetEtcData(arrXml[0], "ca_flg"),
							 ComGetEtcData(arrXml[0], "bdr_flg"), 
							 ComGetEtcData(arrXml[0], "ca_exist_flg"), 
							 ComGetEtcData(arrXml[0], "bl_no"));
		
		// non_rt_sts_cd 가 "R" 일 때 Tro Confirm 버튼 항목을 비활성화	(구주는 버튼)
		// aloc_sts_cd 가 "S" 일 때 Tro Confirm 항목을 비활성화
		if("R"== document.form.non_rt_sts_cd.value||"S"== document.form.aloc_sts_cd.value){
			if("R"== document.form.non_rt_sts_cd.value){
				ComShowMessage("TRO cannot be confirmed under ‘R’ status of BKG.");
			}
			if("S"== document.form.aloc_sts_cd.value){
				ComShowMessage("TRO cannot be confirmed under when its status is standby.");
			}
			ComBtnDisable("btn_t2cConfirm");
		}else{
			ComBtnEnable("btn_t2cConfirm");
		}

		break;

	case IBSAVE:
		//(저장전)---------------------------->
		// alert(delFlg);
		var currTroSeq = formObj.tro_seq.Text;
		var currTroSubSeq_v = formObj.tro_sub_seq.value;

		setFormToData_Tro_dg_seq(currTroSeq);
		x_sheetObject4.ColumnSort("tro_seq|tro_dcgo_seq");

		setFormToData_TroMst(currTroSeq);
		setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");
		x_sheetObject3.ColumnSort("tro_seq|tro_sub_seq"); // dtl-all grid(hidden) 저장전, Sorting
		
		if (delFlg == "C" || delFlg == "Y") {
			for ( var i = 1; i <= x_sheetObject2.RowCount; i++) {
				if (x_sheetObject2.CellValue(i, "tro_seq") != currTroSeq) {
					//							x_sheetObject2.CellValue2(i, "ibflag") = "R";
					x_sheetObject2.RowStatus(i) = "R";
				}
			}
			for ( var i = 1; i <= x_sheetObject3.RowCount; i++) {
				if (x_sheetObject3.CellValue(i, "tro_seq") != currTroSeq) {
					//							x_sheetObject3.CellValue2(i, "ibflag") = "R";
					x_sheetObject3.RowStatus(i) = "R";
				}
			}
/*			for ( var i = 1; i <= x_sheetObject4.RowCount; i++) {
				if (x_sheetObject4.CellValue(i, "tro_seq") != currTroSeq) {
						x_sheetObject4.CellValue2(i, "ibflag") = "R";
						x_sheetObject4.RowStatus(i) = "R";
				}
			} */
		} 
		for ( var i = 1; i <= x_sheetObject4.RowCount; i++) {
			//	     		    	x_sheetObject4.CellValue2(i, "ibflag") = "I";
			x_sheetObject4.RowStatus(i) = "I";
		}
		// T1 Revenue 상에 Arbitrary charge 존재하지만 Pop up 으로 Open 하여 입력 하지 않은 경우 메시지 출력
//		if("I"== document.form.io_bnd_cd.value) {
//			doActionIBSheet(x_sheetObject2, formObj, COMMAND06);
//		}
//		if("I"== document.form.io_bnd_cd.value && !t1RevClickFlg && "Y"== glineRevAmtFlg){
//			ComShowCodeMessage("BKG08299");
//			return false;
//		}
		//<-----------------------------(저장전)  
		if (!validateForm(sheetObj, formObj, sAction, delFlg)) return false;

		// (containerVO)----------------------------------------->
		formObj.f_cmd.value = MULTI;
		// formObj.f_del_flg.value = delFlg; //delete event 구분
		formObj.curr_tro_seq.value = formObj.tro_seq.Text; // default 순번 setting
		formObj.curr_tro_sub_seq.value = formObj.tro_sub_seq.value; // default 순번 setting : sub
		var sheetSaveObjects = new Array();
		sheetSaveObjects[0] = x_sheetObject2;
		sheetSaveObjects[1] = x_sheetObject3;
		sheetSaveObjects[2] = x_sheetObject4;
		var sParam1 = ComSetPrifix(x_sheetObject2.GetSaveString(true), "t2asheet2_");
		var sParam2 = ComSetPrifix(x_sheetObject3.GetSaveString(true), "t2asheet3_");
		var sParam3 = ComSetPrifix(x_sheetObject4.GetSaveString(true), "t2asheet4_");
		var sParam = "f_cmd=" + MULTI 
					+ "&bkg_no=" + formObj.bkg_no.value 
					+ "&oldBkgNo=" + formObj.oldBkgNo.value 
					+ "&io_bnd_cd=" + formObj.io_bnd_cd.value 
					+ "&f_del_flg=" + formObj.f_del_flg.value 
					+ "&curr_tro_seq=" + formObj.curr_tro_seq.value 
					+ "&curr_tro_sub_seq=" + formObj.curr_tro_sub_seq.value
					;
		sParam += "&" + sParam1;
		sParam += "&" + sParam2;
		sParam += "&" + sParam3;
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_02CGS.do", sParam);
		formObj.post_flg.value = nullToBlank(ComGetEtcData(sXml, "post_flg"));
		sheetSaveObjects[0].LoadSaveXml(sXml);
		// <------------------------------------------(containerVO)
		document.form.arb_rev_flg.value ="N";
		break;

	case COMMAND02: //bkg_no별 Fax/Email 전송  
		// if(!validateForm(sheetObj, formObj, sAction, sCmd)){
		// return false;
		// }

		// ComOpenWait(true);

		formObj.f_cmd.value = COMMAND02;

		// 2011.11.28
		var sParam = "f_cmd=" + COMMAND02 
					+ "&bkg_no=" + formObj.bkg_no.value 
					+ "&io_bnd_cd=" + formObj.io_bnd_cd.value 
					+ "&eml=" + formObj.eml.value 
					+ "&fax_no=" + formObj.fax_no.value 
					+ "&bl_no=" + formObj.bl_no.value
					+ "&cmdt=" + formObj.cmdt.value
					+ "&receiver=" + formObj.receiver.value
					+ "&other=" + formObj.other.value
					+ "&cust_ntc=" + formObj.cust_ntc.value
					+ "&slct_cntr=" + formObj.slct_cntr.value;
			
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_02CGS.do", sParam);
		sheetObj.LoadSaveXml(sXml);
		// ComOpenWait(false); //대기창 사라짐

		if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
			ComShowCodeMessage("BKG00497"); // Email
			// ComShowCodeMessage("BKG00496"); //Fax
		} else if (ComGetEtcData(sXml, "SuccessYn") == "YM") {
			ComShowCodeMessage("BKG00497"); // Email
		} else if (ComGetEtcData(sXml, "SuccessYn") == "YF") {
			ComShowCodeMessage("BKG00496"); // Fax
		}
		break;
		
  	case COMMAND05:      //corridor pair의 유무를 확인	
		var formObject = document.form;
  		if(formObject.curr_cd.value != "" && formObject.cxl_flg.value != "Y" 
  			&& ComIsEmpty(formObject.so_no.value) && formObject.cfm_flg.value != "Yes"){
  			
  			if(formObject.non_trns_rev_amt.value != "" || formObject.trns_rev_amt.value != ""){
  				ComShowCodeMessage("BKG02201");
  				formObject.curr_cd.value == ""
  				formObject.non_trns_rev_amt.value = "" ;
  				formObject.trns_rev_amt.value = "";
  			}
  		}
  		//haulage가 C일 경우에만 로직 적용
  		if(formObject.hlg_tp_cd.Text == "M"){
  			setRevenueColor();
  			return false;
  		}
  		var currTroSeq = formObject.tro_seq.Text;
//		var currTroSubSeq_v = formObject.tro_sub_seq_currcnt.value;
		var currTroSubSeq_v = formObject.tro_sub_seq.value;
		setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");
  		formObject.optm_flag.value = 'Y';
  		formObject.bse_port_loc_cd.value  = (formObject.io_bnd_cd.value == "O") ? nullToBlank(formObject.pol_code.value): nullToBlank(formObject.pod_cd.value);
  		formObject.pnt_loc_cd.value = (formObject.io_bnd_cd.value == "O") ? findDoorLoc(true) : findDoorLoc(false);
  		formObject.trsp_mode_cd.value = nullToBlank(formObject.bkg_trsp_mzd_cd.Code);
  		formObject.rf_flag.value = (formObject.rc_seq.Code == "") ? "N" : "Y";
  		formObject.awk_flag.value = (formObject.awk_cgo_seq.index > 0) ? "Y" : "N";
  		formObject.dg_flag.value = (formObject.dcgo_seq.Code == "") ? "N" : "Y";

  		formObject.f_cmd.value = SEARCH;
		var param =  FormQueryString(formObject)+ "&trsp_chg_flg=" + nullToBlank(trspChgFlg) ;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0317GS.do", param);
		if (sXml != "") {
			formObject.optm_sts_cd.Code =  ComGetEtcData(sXml, "optm_sts_cd");
			ComSetObjValue(formObject.chk_trsp_mod_cd, ComGetEtcData(sXml, "trsp_mod_cd"));
			ComSetObjValue(formObject.manifest_flag, ComGetEtcData(sXml, "manifest_flag"));
			
//			if(!ComIsEmpty(ComGetEtcData(sXml, "all_in_rt_cd")))
			ComSetObjValue(formObject.all_in_rt_cd, ComGetEtcData(sXml, "all_in_rt_cd"));

			if (formObject.optm_sts_cd.Code == "Y" && ComGetEtcData(sXml, "gline_rev_amt") != ""){
				ComSetObjValue(formObject.curr_cd, ComGetEtcData(sXml, "gline_curr_cd"));
				if(formObject.manifest_flag.value == "M")
					ComSetObjValue(formObject.trns_rev_amt, ComGetEtcData(sXml, "gline_rev_amt"));
				else
					ComSetObjValue(formObject.non_trns_rev_amt, ComGetEtcData(sXml, "gline_rev_amt"));
				
			}
		}
		if (ComIsEmpty(trspChgFlg)) {
			formObject.bkg_trsp_mzd_cd.Code2 = formObject.chk_trsp_mod_cd.value;
		}
		setRevenueColor();
		
	    break;
	    
	    	    
  	case COMMAND06:    		
  		// T1 Revenue 상에 Arbitrary charge 존재하지만 Pop up 으로 Open 하여 입력 하지 않은 경우 메시지 출력을 위한 작업	
		var formObject = document.form;
  		var currTroSeq = formObject.tro_seq.Text;
		var currTroSubSeq_v = formObject.tro_sub_seq.value;
		setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");
  		formObject.optm_flag.value = 'Y';
  		formObject.bse_port_loc_cd.value  = (formObject.io_bnd_cd.value == "O") ? nullToBlank(formObject.pol_code.value): nullToBlank(formObject.pod_cd.value);
  		formObject.pnt_loc_cd.value = (formObject.io_bnd_cd.value == "O") ? findDoorLoc(true) : findDoorLoc(false);
  		formObject.trsp_mode_cd.value = nullToBlank(formObject.bkg_trsp_mzd_cd.Code);
  		formObject.rf_flag.value = (formObject.rc_seq.Code == "") ? "N" : "Y";
  		formObject.awk_flag.value = (formObject.awk_cgo_seq.index > 0) ? "Y" : "N";
  		formObject.dg_flag.value = (formObject.dcgo_seq.Code == "") ? "N" : "Y";

  		formObject.f_cmd.value = SEARCH01;
		var param =  FormQueryString(formObject)+ "&trsp_chg_flg=" + nullToBlank(trspChgFlg) ;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0317GS.do", param);
		if (sXml != "") {
			//Arbitrary charge 존재하는지 체크
			if(ComGetEtcData(sXml, "gline_rev_amt") != "" && undefined != ComGetEtcData(sXml, "gline_rev_amt")){
				//Arbitrary charge 적용 하였는지 계속 체크
				if(ComGetEtcData(sXml, "gline_rev_amt") != formObject.trns_rev_amt.value && ComGetEtcData(sXml, "gline_rev_amt") != formObject.non_trns_rev_amt.value){
					glineRevAmtFlg ="Y";	
				}else{
					glineRevAmtFlg ="N";
				}
			}else{
				glineRevAmtFlg ="N";	
			}
		}
		
	    break;


	}

	return true;
}

//재조회전, 초기화작업 
function initSearchVal() {
	var formObj = document.form;

	// page 전역변수 clear -> OnLoad상태로
	x_oldTroSeq = "";
	x_cancelAllFlg = "N"; // Y:cancelAll 처리됨

	formObj.post_flg.value = "N"; // 초기화
}

//######################[1. Event]############################################################
/**
 * Tro master : tro_seq 콤보 선택변경시, 이벤트처리
 */
function tro_seq_OnChange(comboObj, idx_cd, text) {
    pass_flg = true;
	changeTroSeqProc();
	pass_flg = false;
	if(document.form.hlg_tp_cd.Code == "M" && document.form.io_bnd_cd.value=="I" && document.form.cfm_flg.value == "Yes"){
		ComEnableManyTd(true, "btn_t2cDropOff");
	}else{
		ComEnableManyTd(false, "btn_t2cDropOff");
	}
}

/**
 * Tro master : cntr_no_sel 콤보 선택변경시, 이벤트처리
 */
function cntr_no_sel_OnChange(comboObj, idx_cd, text) {
	var formObj = document.form;
	formObj.cntr_no.value = text;
	if(text!=""){
		if(x_sheetObject5.SearchRows!=0 && !pass_flg){
			doActionIBSheet(x_sheetObjMsg, formObj, COMMAND04);
			doActionIBSheet(x_sheetObject2, formObj, COMMAND05); //optm_sts_cd 설정
		}
	}
	pass_flg = false;

}


//2011.12.05 변경시 validate 추가 kbj
/** 
 * Tro master : dcgo_seq 콤보 선택변경시, 이벤트처리
 * cancele일경우 무조건 재선택 가능함 
 */
function dcgo_seq_OnChange(comboObj, idx_cd, text) {
	if(idx_cd.split("|")[0] != ''){
		var objForm = document.form;
		var sheetObj1 = x_sheetObject4;
		var sheetObj2 = x_sheetObject2; 
		var selectedId = idx_cd.split("|")[0];
		var sTroSeq = document.tro_seq.Text;
		var sDcgoSeq = sheetObj1.CellValue(sTroSeq, "tro_dcgo_seq");
		var chkRow = new Array();
		var chkTro = new Array();
		
		//dcgo_seq로 tro_seq 가져오기
		for(var i = 1; i <= sheetObj1.RowCount; i++){
			if(selectedId == sheetObj1.CellValue(i,"tro_dcgo_seq")){
				chkTro.push(sheetObj1.CellValue(i,"tro_seq"));
			}
		}
		//가져온 tro_seq를 가진 idx 가져오기
		for(var i=0; i < chkTro.length; i++){
			for(var j=1;j<=sheetObj2.RowCount;j++){
				if(chkTro[i]==sheetObj2.CellValue(j,"tro_seq")){
					chkRow.push(sheetObj2.FindText("tro_seq", chkTro[i], j ));
				}
			}
		}
		//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
		for(var i=0; i< chkRow.length ;i++){ 
			if(sheetObj2.CellValue(chkRow[i],"cxl_flg") == "Y" || sheetObj2.CellValue(chkRow[i],"eur_trns_tp_cd") == "FR"){
				isCancel = true; 
			}else{
				isCancel = false; 
				break;
			}
		} 
		//선택한 id와 세팅된 dcgo seq가 다를경우만 아래 로직을 탐
		if(selectedId != sDcgoSeq ){
			if(sheetObj1.FindText("tro_dcgo_seq",selectedId) == -1 || isCancel ){
				setAddRemarkText(comboObj, idx_cd, text, "N");
				setComboBackColor(comboObj);
			}else{ 
				ComShowCodeMessage("BKG02102") 
				comboObj.Index = '';
				return;
			}
		}
	}

	doActionIBSheet(x_sheetObject2, objForm, COMMAND05); //optm_sts_cd 설정
}

/** 
 * Tro master : dcgo_seq 멀티콤보 체크시, 이벤트처리
 */
function dcgo_seq_OnCheckClick(comboObj, idx_cd, text) {
	var formObj = document.form;
	setAddRemarkText(comboObj, idx_cd, text, "Y");
	setComboBackColor(formObj.dcgo_seq);
}

/**
 * Tro master : rc_seq 멀티콤보 change시, 이벤트처리
 */
function rc_seq_OnChange(comboObj, idx_cd, text) {

	if(comboObj.Index > 0){
		var objForm = document.form;
		var selectedId = idx_cd.split("|")[0];
		var sheetObj = x_sheetObject2;
		var sTroSeq = document.tro_seq.Text;
		var sRCSeq = sheetObj.CellValue(sTroSeq, "rc_seq");
		var chkRow = new Array();
		
		//rc_seq로 idx 가져오기
		
		for(var i = 1; i <= sheetObj.RowCount; i++){
			if(sheetObj.FindText("rc_seq", selectedId, i ) != -1){
				chkRow.push(sheetObj.FindText("rc_seq", selectedId, i ));
			}
		}
		//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
		for(var i=0; i< chkRow.length ;i++){
			
			if(sheetObj.CellValue(chkRow[i],"cxl_flg") == "Y" || sheetObj.CellValue(chkRow[i],"eur_trns_tp_cd") == "FR"){
				isCancel = true; 
			}else{
				isCancel = false; 
				break;
			}
		} 
		//선택한 id와 세팅된 rc seq가 다를경우만 아래 로직을 탐
		if(selectedId != sRCSeq ){
			if(sheetObj.FindText("rc_seq",selectedId) == -1 || isCancel ){
				setAddRemarkText(comboObj, idx_cd, text, "N");
				setComboBackColor(comboObj);
			}else{ 
				ComShowCodeMessage("BKG02102") 
				comboObj.Index = '';
				return;
			}
		}
	}
	
	doActionIBSheet(x_sheetObject2, objForm, COMMAND05); //optm_sts_cd 설정
}

/**
 * Tro master : awk_cgo_seq 멀티콤보 change시, 이벤트처리
 */
function awk_cgo_seq_OnChange(comboObj, idx_cd, text) {
	if(comboObj.Index > 0){
		var objForm = document.form;
		var selectedId = idx_cd.split("|")[0];
		var sheetObj = x_sheetObject2;
		var sTroSeq = document.tro_seq.Text;
		var sAwkSeq = sheetObj.CellValue(sTroSeq, "awk_cgo_seq");
		var chkRow = new Array();
		//rc_seq로 idx 가져오기
		for(var i = 1; i <= sheetObj.RowCount; i++){
			if(sheetObj.FindText("rc_seq", selectedId, i ) != -1){
				chkRow.push(sheetObj.FindText("awk_cgo_seq", selectedId, i ));
			}
		}
		//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
		for(var i=0; i< chkRow.length ;i++){ 
			if(sheetObj.CellValue(chkRow[i],"cxl_flg") == "Y" || sheetObj.CellValue(chkRow[i],"eur_trns_tp_cd") == "FR"){
				isCancel = true; 
			}else{
				isCancel = false; 
				break;
			}
		} 
		//선택한 id와 세팅된 awk cgo seq가 다를경우만 아래 로직을 탐
		if(selectedId != sAwkSeq ){
			if(sheetObj.FindText("awk_cgo_seq",selectedId) == -1 || isCancel ){
				setAddRemarkText(comboObj, idx_cd, text, "N");
				setComboBackColor(comboObj);
			}else{ 
				ComShowCodeMessage("BKG02102") 
				comboObj.Index = '';
				return;
			}
		}
	}
	
	doActionIBSheet(x_sheetObject2, objForm, COMMAND05); //optm_sts_cd 설정
}

/**
 * 저장완료시, 재조회
 */
function t2csheet2_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj = document.form;

	if (ErrMsg.length > 9 && ErrMsg.substr(0, 9) == "[SUCCESS]") {
	  pass_flg = true;
		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH); // 재조회 call
	} else {
		var strPostFlg = nullToBlank(formObj.post_flg.value); // postFlg == "CF"이면 -> cancel/frustrate 처리, else->재조회
		if (strPostFlg == "CF") {
			var bkg_no = nullToBlank(formObj.bkg_no.value);
			var io_bnd_cd = nullToBlank(formObj.io_bnd_cd.value); // hidden
			comBkgCallPop0703("setCxlFrustCallBack", bkg_no, io_bnd_cd); // cancel/frustrate popup call
		}
	}
}
/**
 * Tro master : TP/SZ change시, 이벤트처리
 */
function obj_change_loc() {
	var formObj = document.form;
	var elementNm = event.srcElement.name;

	switch (elementNm) {
	case "cntr_tpsz_cd":
		var preVal_type = formObj.cntr_tpsz_cd_old.value;
		var nxtVal_type = formObj.cntr_tpsz_cd.value;
		var preVal_hlg = formObj.hlg_tp_cd_old.value;
		var nxtVal_hlg = formObj.hlg_tp_cd.Code;

		changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1"); // change : plus/minus
		//D,R이 아니면 Mode공백처리
		if(formObj.cntr_tpsz_cd.value == 'D2' || formObj.cntr_tpsz_cd.value == 'D4' || formObj.cntr_tpsz_cd.value == 'D5' 
			|| formObj.cntr_tpsz_cd.value == 'R2' || formObj.cntr_tpsz_cd.value == 'R4' || formObj.cntr_tpsz_cd.value == 'R5'){
			doActionIBSheet(x_sheetObject2, formObj, COMMAND05);
		}else{
			formObj.bkg_trsp_mzd_cd.Text = "";
			doActionIBSheet(x_sheetObject2, formObj, COMMAND05);
		}
		
		break;

	case "cntr_no":
			
		doActionIBSheet(x_sheetObjMsg, formObj, COMMAND04);
		doActionIBSheet(x_sheetObject2, formObj, COMMAND05); //optm_sts_cd 설정
		
		break;
		
	case "dor_loc_cd":
		doActionIBSheet(x_sheetObject2, formObj, COMMAND05); //optm_sts_cd 설정

		break;
		
		
	}
}
/**
 * Tro master : dor_addr_tp_cd 멀티콤보 change시, 이벤트처리
 */
function dor_addr_tp_cd_OnChange(comboObj, idx_cd, text) {
	
	var formObj = document.form;
	doActionIBSheet(x_sheetObject2, formObj, COMMAND05); //optm_sts_cd 설정
}
/**
* Tro master : bkg_trsp_mzd_cd 멀티콤보 change시, 이벤트처리
*/
function bkg_trsp_mzd_cd_OnChange(comboObj, idx_cd, text) {
	
	var formObj = document.form;
	doActionIBSheet(x_sheetObject2, formObj, COMMAND05, "", "Y"); //optm_sts_cd 설정
}
/**
 * Tro master : hlg_tp_cd 멀티콤보 change시, 이벤트처리
 */
function hlg_tp_cd_OnChange(comboObj, idx_cd, text) {
	var formObj = document.form;
	var sheetObj = x_sheetObject2;

	// ----------------------
	// qtySum 관련 처리
	if ("Y" == formObj.cxl_flg.value) {
		//Cancel/Delete 건은, troqty sum수량에 포함않됨
		return;
	}
	var preVal_type = formObj.cntr_tpsz_cd_old.value;
	var nxtVal_type = formObj.cntr_tpsz_cd.value;
	var preVal_hlg = formObj.hlg_tp_cd_old.value;
	var nxtVal_hlg = formObj.hlg_tp_cd.Code;

	if (nxtVal_type.trim() != "" && (nxtVal_hlg != preVal_hlg)) {
		var bResult = changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1"); // change : plus/minus
		if (!bResult) {
			return;
		}
	}

	//----------------------
	// Haulage change color
	changeEnabeld_haulage_master(); // master
	changeEnabeld_haulage_dtl(); // dtl

	// ----------------------
	// Haulage change default val : (신규건만)
	if (formObj.new_row_flg.value == "Y") {
		clearFormData_master(nxtVal_hlg);
		clearFormData_dtl(nxtVal_hlg);
	}
	
//	changeEnabeld_btn_t2cT1Revenue(sheetObj);
	
	// Clear T1 & Revenue in case of haulage = "M"
//	if (text == "M") {
//		clearFormData_t1Revenue();
//	}

	//C/H인 경우에만 optm로직적용
	if(formObj.hlg_tp_cd.Text == "C"){
		doActionIBSheet(x_sheetObject2, formObj, COMMAND05); //optm_sts_cd 설정

	}else{
		formObj.optm_sts_cd.Text = "";
		formObj.bkg_trsp_mzd_cd.Text = "";
	}

	if(formObj.hlg_tp_cd.Code == "M" && formObj.io_bnd_cd.value=="I" && formObj.cfm_flg.value == "Yes"){
		ComEnableManyTd(true, "btn_t2cDropOff");
	}else{
		ComEnableManyTd(false, "btn_t2cDropOff");
	}
	
}

// Clearing T1 & Revenue data.
function clearFormData_t1Revenue() {
	var formObj = document.form;
	with(formObj) {
		all_in_rt_cd.value = "Y";
		vat_flg.value = "N";
		t1_doc_flg.value = "N";
		add_rev_chg_cd.value = "";
		add_rev_amt.value = "";
		add_rev_chg_cd2.value = "";
		add_rev_amt2.value = "";
		add_rev_chg_cd3.value = "";
		add_rev_amt3.value = "";
		
		add_rev_rmk.value = "";
		trns_rev_amt.value = "";
		non_trns_rev_amt.value = "";
	}
}

// control btn_t2cT1Revenue
function changeEnabeld_btn_t2cT1Revenue() {
	var formObj = document.form;
	if (formObj.hlg_tp_cd.Text == "M") {
		ComEnableManyTd(false, "btn_t2cT1Revenue");
		document.getElementById("btn_t2cT1Revenue").style.color = "";
	} else {
		ComEnableManyTd(true, "btn_t2cT1Revenue");
	}
}

/**
 * Tro master/detatil : tro_seq 콤보 선택변경시 처리 
 */
function changeTroSeqProc() {
	var formObj = document.form;
	var comboObj = document.tro_seq;

	// ----------------------
	// 1) 변경되어 선택된 tro_seq 조회
	var currTroSeq = comboObj.Text;
	var currTroSubSeq = formObj.tro_sub_seq_currcnt.value;

	// ----------------------
	// 2) tro-master
	if (x_oldTroSeq != "") {
		setFormToData_TroMst(x_oldTroSeq);
	}
	setDataToForm_TroMst(currTroSeq);

	// ----------------------
	// 3) tro-detail
	if (x_oldTroSeq != "") {
		setDataToAllData_TroDtl(x_oldTroSeq, currTroSubSeq);
	}
	setAllDataToData_TroDtl(currTroSeq, 1);

	// ----------------------
	// 4) tro/tro-detail 화면변경사항 저장시 사용을 위해, x_oldTroSeq 유지
	x_oldTroSeq = comboObj.Text; // currTroSeq

	
//	changeEnabeld_btn_t2cT1Revenue();
	
}

/**
 * Tro dtl : prev/next 버튼클릭시, 이벤트처리
 */
function changeTroSeqProc_dtl(gubun) {
	var formObj = document.form;
	var comboObj = document.tro_seq;

	with (formObj) {
		var currTroSeq = comboObj.Text;
		var currTroSubSeq = tro_sub_seq_currcnt.value;

		// -------------------------
		// 1) 이동할 dtl 순번 get
		var n_tro_sub_seq_currcnt = parseInt(tro_sub_seq_currcnt.value);
		var n_tro_sub_seq_maxcnt = parseInt(tro_sub_seq_maxcnt.value);
		var n_t_tro_sub_seq = null;

		if (gubun == "P") {
			n_t_tro_sub_seq = n_tro_sub_seq_currcnt - 1;
		} else if (gubun == "N") {
			n_t_tro_sub_seq = n_tro_sub_seq_currcnt + 1;
		}

		//-------------------------
		// 2) dtl 저장/이동 call
		setDataToAllData_TroDtl(currTroSeq, currTroSubSeq);
		setAllDataToData_TroDtl(currTroSeq, n_t_tro_sub_seq);
	}
}

/**
 * Tro-dtl : dtl Prev/Dtl disabled 처리 
 */
function changeEnabled_dtl_PrevNext() {
	var formObj = document.form;

	with (formObj) {
		var n_tro_sub_seq_currcnt = parseInt(tro_sub_seq_currcnt.value);
		var n_tro_sub_seq_maxcnt = parseInt(tro_sub_seq_maxcnt.value);
		var n_t_tro_sub_seq = null;

		if (n_tro_sub_seq_maxcnt <= 1 || nullToBlank(tro_sub_seq_currcnt.value) == "") {
			ComEnableManyTd(false, "btn_t2cPrevious", "btn_t2cNext");
		} else if (n_tro_sub_seq_currcnt <= 1) {
			ComEnableManyTd(false, "btn_t2cPrevious");
			ComEnableManyTd(true, "btn_t2cNext");
		} else if (n_tro_sub_seq_currcnt == n_tro_sub_seq_maxcnt) {
			ComEnableManyTd(true, "btn_t2cPrevious");
			ComEnableManyTd(false, "btn_t2cNext");
		} else {
			ComEnableManyTd(true, "btn_t2cPrevious", "btn_t2cNext");
		}
	}
}

/**
 * Tro-Dtl : Dtl 수정불가 처리 
 */
function changeDtlColor() {
	var formObj = document.form;

	// -------------------------------------------
	// 1) cxl_flg input_hidded: Master 수정 불가/가능 처리
	var so_flg = (nullToBlank(formObj.so_no.value) == "") ? "N" : "Y";

	// if (formObj.cxl_flg.value == "Y" || formObj.cfm_flg.value == "Yes") {
	if (formObj.cxl_flg.value == "Y" || so_flg == "Y" || formObj.cfm_flg.value == "Yes") {
		changeEnabeld_haulage_dtl(); // Haulage change color
		changeEnabled_dtl(false);
	} else {
		changeEnabled_dtl(true);
		changeEnabeld_haulage_dtl(); // Haulage change color
	}

	//-------------------------------------------
	// 2) Add/Del, Enabled 변경
	// if (formObj.cfm_flg.value == "Yes" || formObj.so_no.value != "") {
	if (so_flg == "Y" || formObj.cfm_flg.value == "Yes") {
		ComEnableManyTd(false, "btn_t2cAdd", "btn_t2cDelete");
	}

	//-------------------------------------------
	// 3) Prev/Next, Enabled 변경
	changeEnabled_dtl_PrevNext();
}

/**
 * Tro-Master : Master 수정불가 처리 
 */
function changeMasterColor() {
	var formObj = document.form;

	// -------------------------------------------
	// 1) Master 수정 불가/가능 처리
	var p_cxl_flg = formObj.cxl_flg.value;
	var p_cfm_flg = (formObj.cfm_flg.value == "Yes") ? "Y" : "N";
	var p_so_no_flg = (nullToBlank(formObj.so_no.value) == "") ? "N" : "Y";
	changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg);

	// -------------------------------------------
	// 2) 콤보항목값 존재시, 배경색 변경
	setChangeAllComboBackColor();

	// ----------------------
	// 3) tro_seq별 SaveSeq 버튼 상태 제어
	// copyCntr/addCntr 된 건중, max_seq+1 보다 큰 seq건은, saveSeq버튼 disabled -> SaveAll 해야함.
	var t_max_tro_seq_old = (nullToBlank(formObj.max_tro_seq_old.value) == "") ? "0" : formObj.max_tro_seq_old.value;
	var t_currTroSeq = formObj.tro_seq.Text;
	if (parseInt(t_currTroSeq) > parseInt(t_max_tro_seq_old) + 1) {
		ComEnableManyTd(false, "btn_t2cSaveSeq");
	} else {
		ComEnableManyTd(true, "btn_t2cSaveSeq");
	}
}

/**
 * Tro-Master : 수정불가 일괄처리 제어  
 */
function changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
	var formObj = document.form;
	var p_eur_trns_tp_cd = formObj.eur_trns_tp_cd.value;

	// canceled : display
	if (p_cxl_flg == "Y") {
		document.all.canceled.innerHTML = '<font color="red">Canceled</font>';
	} else if (p_eur_trns_tp_cd == "FR") {
		document.all.canceled.innerHTML = '<font color="red">Frustrate</font>';
	} else {
		document.all.canceled.innerHTML = '';
	}
	//eur_trns_tp_cd

	// master all : disabled
	// if (p_cxl_flg == "Y" || p_cfm_flg == "Y") {
	// confirm 이후 변경 불가
	if (p_cxl_flg == "Y" || p_so_no_flg == "Y" || p_cfm_flg == "Y") {
		changeEnabeld_haulage_master(); // Haulage change color
		changeEnabled_master(false);
	} else {
		changeEnabled_master(true);
		changeEnabeld_haulage_master(); // Haulage change color
	}
}

/**
 * Tro-Dtl : Halage OnChange시, 컨트롤 변경 처리 
 */
function changeEnabeld_haulage_dtl() {
	var formObj = document.form;
	var haulage = formObj.hlg_tp_cd.Text;

	with (formObj) {
		if (haulage == "C") {
			ComClassNameManyObjects_loc("input1",	dor_loc_cd, zn_cd, dor_pst_no, dor_addr_1, dor_addr_2, arr_dt, arr_dt_hhmi); // className : 필수
			ComClassNameManyObjects_loc("input", 	dor_addr_3, cntc_pson_nm, cntc_phn_no, cntc_eml); // className : 선택
			ComEnableManyObjects_loc(true,	 		dor_loc_cd, zn_cd, btns_popLocation, dor_pst_no,
											 		dor_addr_1, dor_addr_2, dor_addr_3, btns_Address, 
											 		arr_dt, btns_calendar_3, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml); // 활성
			ComEnableManyIBCombo	(true, "#CCFFFD", dor_addr_tp_cd); // 활성
		} else if (haulage == "M") {
			ComClassNameManyObjects_loc("input",	dor_loc_cd, zn_cd, dor_pst_no, 
													dor_addr_1, dor_addr_2, dor_addr_3,  
													arr_dt, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml); // className : 선택
			ComEnableManyObjects_loc(true, 			dor_addr_1, dor_addr_2, dor_addr_3); // 활성
			ComEnableManyObjects_loc(false, 		dor_loc_cd, zn_cd, btns_popLocation, dor_pst_no, 
													dor_addr_1, dor_addr_2, dor_addr_3, btns_Address, 
													arr_dt, btns_calendar_3, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml); // 비활성
			ComEnableManyIBCombo	(false, 	"", dor_addr_tp_cd); // 비활성
		}
	}
}

/**
 * Tro-Master : Halage OnChange시, 컨트롤 변경 처리 
 */
function changeEnabeld_haulage_master() {
	var formObj = document.form;
	var haulage = formObj.hlg_tp_cd.Text;

	with (formObj) {
		if (haulage == "C") {
			ComClassNameManyObjects_loc("input1", cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm); // className : 필수
			if (io_bnd_cd.value == "I") {
				ComClassNameManyObjects_loc("input1", cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi); // className : 필수
				ComClassNameManyObjects_loc("input", cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi); // className : 선택
				ComEnableManyObjects_loc(true, cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi); // 활성
				ComEnableManyObjects_loc(false, cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi); // 비활성
			} else {
				ComClassNameManyObjects_loc("input", cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi); // className : 선택
				ComClassNameManyObjects_loc("input1", cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi); // className : 필수
				ComEnableManyObjects_loc(false, cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi); // 비활성
				ComEnableManyObjects_loc(true, cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi); // 활성
			}
			ComEnableManyObjects_loc(true, cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm, btns_repCommodity, 
											btn_t2cAdd, btn_t2cDelete); // 활성
			// ComEnableManyIBCombo (true, "#CCFFFD", bkg_trsp_mzd_cd); //활성
			ComEnableManyIBCombo(true, "", bkg_trsp_mzd_cd); // 활성
		} else if (haulage == "M") {
			ComClassNameManyObjects_loc("input", cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm); // className : 선택
			if (io_bnd_cd.value == "I") {
				ComClassNameManyObjects_loc("input1", 	cntr_pkup_dt, cntr_pkup_dt_hhmi, 
														cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi); // className : 필수
				ComClassNameManyObjects_loc("input", 	cntr_pkup_yd_cd);								// className : 선택
			} else {
				ComClassNameManyObjects_loc("input1", 	cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi, 
														cntr_rtn_dt, cntr_rtn_dt_hhmi); // className : 필수
				ComClassNameManyObjects_loc("input", cntr_rtn_yd_cd); // className : 선택
			}
			ComEnableManyObjects_loc(true, 	cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi, 
											cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi); // 활성 
			ComEnableManyObjects_loc(false, cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm, btns_repCommodity, 
											btn_t2cAdd, btn_t2cDelete); // 비활성
			ComEnableManyIBCombo(false, "", bkg_trsp_mzd_cd); // 비활성
		}
	}
}

/**
 * Tro-Master : 수정불가 처리 
 */
function changeEnabled_master(bFlag) {
	var formObj = document.form;
	with (formObj) {
		ComEnableManyObjects_loc(bFlag, rqst_sub_seq, cntr_no, cntr_tpsz_cd, cgo_wgt, cntr_pkup_yd_cd, cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi, 
										tro_cmdt_cd, rep_cmdt_nm, rep_cmdt_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi, spcl_instr_rmk, 
									     btns_repCommodity, btns_calendar, btns_calendar_2);
		ComEnableManyIBCombo(bFlag, cntr_no_sel, "", dcgo_seq, rc_seq, awk_cgo_seq, hlg_tp_cd, bkg_trsp_mzd_cd);
		// ComEnableManyTd(bFlag, "btn_t2cCopyCNTR");  
		
		if (formObj.io_bnd_cd.value == "I") {
			ComEnableManyIBCombo(false, "", dcgo_seq, rc_seq, awk_cgo_seq);
		}
	}
}

/**
 * Tro-Dtl : 수정불가 처리 
 */
function changeEnabled_dtl(bFlag) {
	var formObj = document.form;
	with (formObj) {
		ComEnableManyObjects_loc(bFlag, dor_loc_cd, zn_cd, lod_ref_no, dor_pst_no, 
										dor_addr_1, dor_addr_2, dor_addr_3, 
										arr_dt, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml, not_optm_rsn,
										btns_popLocation, btns_Address, btns_calendar_3);
		ComEnableManyIBCombo(bFlag, "", dor_addr_tp_cd);
		ComEnableManyTd(bFlag, "btn_t2cAdd", "btn_t2cDelete");
	}
}

//######################[2. Button Proc : Add/Copy/Cancel/Confirm/Sumqty]#####################
/**
 * delete_dtl
 */
function deleteDtl() {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;

	var tro_seq = formObj.tro_seq.Text;
	var tro_sub_seg = formObj.tro_sub_seq.value;

	var nSRow = findRow_dtl_curr(tro_seq, tro_sub_seg, "V");

	// 1) tro-detail : del
	// sheetObj.CellValue2(nSRow, "ibflag") = "D";
	sheetObj.RowStatus(nSRow) = "D";
}

/**     
 *  Copy시, 처리로직 제어 
 */
function copyRow(sheetObj) {
	var formObj = document.form;

	// CancelSeq 된 건, copy 사용불가 check
	if (formObj.cxl_flg.checked) {
		ComShowCodeMessage("BKG02022"); // "TP/SZ is full over!"
		return;
	}

	sheetObj.ReDraw = false;
	if (sheetObj.id == "t2csheet2") // master
	{
		var strCopyCnt = formObj.tro_copy_cnt.value;
		if (strCopyCnt == "") {
			strCopyCnt = "1"; // 없으면, default : 1
		}
		var nCopyCnt = parseInt(strCopyCnt);

		var nCopyRow = sheetObj.FindText("tro_seq", formObj.tro_seq.Text);
		for ( var i = 0; i < nCopyCnt; i++) {
			addRow(sheetObj, "C", nCopyRow);
		}
	}
	//2010.2.20 BY 신자영   Cntr_seq값에 따라 변경 
	ComSetObjValue(formObj.tro_seq, ComGetObjValue(formObj.tro_seq_maxcnt));
	tro_seq_OnChange(formObj.tro_seq, '', '');

	sheetObj.ReDraw = true;
}

/** 
 *  CopyCNTR시, dtl AllCopy 처리로직 제어 
 */
function copyAllRow_dtl(sheetObj, newTroSeq, sheetObj_copy, copyTroSeq) {
	var formObj = document.form;

	// sheetObj_copy.CheckAll2("chk") = 0; //hidden chk : check clear
	for ( var i = 1; i <= sheetObj_copy.RowCount; i++) {
		if (sheetObj_copy.CellValue(i, "chk") == 1) {
			sheetObj_copy.CellValue2(i, "chk") = 0;
		}
	}

	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	while (nRow > -1) {
		nRow = sheetObj_copy.FindText("tro_seq", copyTroSeq, nStartRow);
		if (nRow > -1) {
			sheetObj_copy.CellValue2(nRow, "chk") = 1; // maxcount 용
			nStartRow = nRow + 1;
		}
	}

	//max sub_seq : get
	var sRow = sheetObj_copy.FindCheckedRow("chk");
	var arrRow = sRow.split("|");
	for ( var idx = 0; idx <= arrRow.length - 2; idx++) 
	{
		addRow(sheetObj, "C", arrRow[idx], newTroSeq, sheetObj_copy); // arrRow[idx]:copyRow, sheetObj:x_sheetObject3, sheetObj_copy:x_sheetObject3
	}
}

/**     
 * AddRow시, 처리로직 제어 
 */
function addRow(sheetObj, NCflag, nCopyRow, newCopyTroSeq, sheetObj_copy) { //newCopyTroSeq -> dtl-all-copy 에서만 사용됨 
	var formObj = document.form;
	if (NCflag == null) {
		NCflag = "N"; // N:New, C:Copy
	}

	if (sheetObj.id == "t2csheet2") // master
	{
		if (NCflag == "C")
		{
			//pre_master/dtl : store
			if (x_oldTroSeq != "") {
				setFormToData_TroMst(x_oldTroSeq); // tro-master : store
				var currTroSubSeq_v = formObj.tro_sub_seq.value;
				setDataToAllData_TroDtl(x_oldTroSeq, currTroSubSeq_v, "V"); // tro-dtl : store
			}

			//master : add
			var nNewRow = sheetObj.DataInsert(-1); // add row : master
			var copyTroSeq = sheetObj.CellValue(nCopyRow, "tro_seq");

			// master : copy
			var newTroSeq = setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow); // default setting : master
			setDataCopy(sheetObj, nNewRow, nCopyRow); // copy data : master

			// tro_seq combo : copy
			formObj.tro_seq.InsertItem(-1, newTroSeq, newTroSeq); // form tro_seq combo : add
			ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount);

			// dg_seq : copy
			//copyTrodgseq(copyTroSeq, newTroSeq);

			// dtl_all : copy -> call
			copyAllRow_dtl(x_sheetObject3, newTroSeq, x_sheetObject3, copyTroSeq);

			// sum-qty : change
			var PM_gubun = "P"; // P:Plus, M:Minus
			var p_Row = nNewRow;
			var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
			var p_currVal_hlg = sheetObj.CellValue(p_Row, "hlg_tp_cd");
			plusMinusSumTroQty(p_currVal_type, p_currVal_hlg, "1", PM_gubun);
		} 
		else 
		{
			var nNewRow = sheetObj.DataInsert(-1); // add row : master
			var newTroSeq = setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow); // default setting : master

			formObj.tro_seq.InsertItem(-1, newTroSeq, newTroSeq); // form tro_seq combo : add
			formObj.tro_seq.Text2 = newTroSeq; // form tro_seq combo : change
			ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount);

			changeTroSeqProc(); // store/display/old_tro_seq : change

			addRow(x_sheetObject3); // add row : dtl

			// sum-qty : change
			var PM_gubun = "P"; // P:Plus, M:Minus
			var p_Row = nNewRow;
			var p_currVal_type = sheetObj.CellValue(p_Row, "cntr_tpsz_cd");
			var p_currVal_hlg = sheetObj.CellValue(p_Row, "hlg_tp_cd");
			// alert("^^p_currVal_type, p_currVal_hlg, p_Row->"+p_currVal_type+","+p_currVal_hlg+","+p_Row);
			plusMinusSumTroQty(p_currVal_type, p_currVal_hlg, "1", PM_gubun);
		}
	} 
	else if (sheetObj.id == "t2csheet3") // dtl
	{
		if (NCflag == "C") 
		{
			if (newCopyTroSeq != null) // dtl all : copy
			{
				var nNewRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(nNewRow, "tro_seq") = newCopyTroSeq; // 신규Copy한, tro_seq 의 값
				sheetObj.CellValue2(nNewRow, "tro_sub_seq") = sheetObj_copy.CellValue(nCopyRow, "tro_sub_seq");
				// sheetObj.CellValue2(nNewRow, "del") = sheetObj_copy.CellValue(nCopyRow, "del"); //'N';
				setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy);
			}
		} else {
			var currTroSeq = formObj.tro_seq.Text;
			var currTroSubSeq_v = formObj.tro_sub_seq.value;

			// 1) dtl : store
			if (x_oldTroSeq != "") {
				setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");
			}

			//2) insert data : defalut 
			var nNewRow = sheetObj.DataInsert(-1);
			setDefaultInsertRow_Dtl(sheetObj, nNewRow, currTroSeq); // dtl : add

			// 3) display
			var currTroSeq_new = sheetObj.CellValue(nNewRow, "tro_seq");
			var currTroSubSeq_new_v = sheetObj.CellValue(nNewRow, "tro_sub_seq");
			setAllDataToData_TroDtl(currTroSeq_new, currTroSubSeq_new_v, "V");
		}
	}
	
	if("R"== document.form.non_rt_sts_cd.value || "S"== document.form.aloc_sts_cd.value){
		ComBtnDisable("btn_t2cConfirm");
	}else{
		ComBtnEnable("btn_t2cConfirm");
	}
}

/**     
 * [tro_master]AddRow한 행에, 값을 Copy 한다.
 */
function setDataCopy(sheetObj, nNewRow, nCopyRow) {
	var formObj = document.form;
	var sheetObj = x_sheetObject2;

	// alert("nNewRow,nCopyRow->"+nNewRow+","+nCopyRow);
	sheetObj.CellValue2(nNewRow, "hlg_tp_cd") = sheetObj.CellValue(nCopyRow, "hlg_tp_cd");
	sheetObj.CellValue2(nNewRow, "rqst_sub_seq") = sheetObj.CellValue(nCopyRow, "rqst_sub_seq");
	// 2010.04.15 container no도 제외
	// sheetObj.CellValue2(nNewRow, "cntr_no") = sheetObj.CellValue(nCopyRow, "cntr_no");
	sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd") = sheetObj.CellValue(nCopyRow, "cntr_tpsz_cd");
	sheetObj.CellValue2(nNewRow, "cgo_wgt") = sheetObj.CellValue(nCopyRow, "cgo_wgt");
	sheetObj.CellValue2(nNewRow, "cntr_pkup_yd_cd") = sheetObj.CellValue(nCopyRow, "cntr_pkup_yd_cd");
	sheetObj.CellValue2(nNewRow, "cntr_rtn_yd_cd") = sheetObj.CellValue(nCopyRow, "cntr_rtn_yd_cd");
	sheetObj.CellValue2(nNewRow, "cntr_rtn_dt") = sheetObj.CellValue(nCopyRow, "cntr_rtn_dt");
	sheetObj.CellValue2(nNewRow, "cntr_rtn_dt_hhmi") = sheetObj.CellValue(nCopyRow, "cntr_rtn_dt_hhmi");
	sheetObj.CellValue2(nNewRow, "tro_cmdt_cd") = sheetObj.CellValue(nCopyRow, "tro_cmdt_cd");
	sheetObj.CellValue2(nNewRow, "rep_cmdt_nm") = sheetObj.CellValue(nCopyRow, "rep_cmdt_nm");
	sheetObj.CellValue2(nNewRow, "rep_cmdt_cd") = sheetObj.CellValue(nCopyRow, "rep_cmdt_cd");
	sheetObj.CellValue2(nNewRow, "bkg_trsp_mzd_cd") = sheetObj.CellValue(nCopyRow, "bkg_trsp_mzd_cd");
	sheetObj.CellValue2(nNewRow, "cntr_pkup_dt") = sheetObj.CellValue(nCopyRow, "cntr_pkup_dt");
	sheetObj.CellValue2(nNewRow, "cntr_pkup_dt_hhmi") = sheetObj.CellValue(nCopyRow, "cntr_pkup_dt_hhmi");
	sheetObj.CellValue2(nNewRow, "spcl_instr_rmk") = sheetObj.CellValue(nCopyRow, "spcl_instr_rmk");
	// 2010.02.25 copy CNTR --> S/O, confirm info는 do not copy, preset
	// sheetObj.CellValue2(nNewRow, "cfm_flg") = sheetObj.CellValue(nCopyRow, "cfm_flg");
	// sheetObj.CellValue2(nNewRow, "cfm_dt") = sheetObj.CellValue(nCopyRow, "cfm_dt");
	// sheetObj.CellValue2(nNewRow, "cfm_ofc_cd") = sheetObj.CellValue(nCopyRow, "cfm_ofc_cd");
	// sheetObj.CellValue2(nNewRow, "cfm_usr_id") = sheetObj.CellValue(nCopyRow, "cfm_usr_id");
	// sheetObj.CellValue2(nNewRow, "so_no") = sheetObj.CellValue(nCopyRow, "so_no");
	// sheetObj.CellValue2(nNewRow, "so_dt") = sheetObj.CellValue(nCopyRow, "so_dt");
	// sheetObj.CellValue2(nNewRow, "so_ofc_cd") = sheetObj.CellValue(nCopyRow, "so_ofc_cd");
	// sheetObj.CellValue2(nNewRow, "so_usr_id") = sheetObj.CellValue(nCopyRow, "so_usr_id");
	sheetObj.CellValue2(nNewRow, "cntr_prt_flg") = sheetObj.CellValue(nCopyRow, "cntr_prt_flg");
	sheetObj.CellValue2(nNewRow, "t1_doc_flg") = sheetObj.CellValue(nCopyRow, "t1_doc_flg");
	sheetObj.CellValue2(nNewRow, "cstms_clr_no") = sheetObj.CellValue(nCopyRow, "cstms_clr_no");
	sheetObj.CellValue2(nNewRow, "all_in_rt_cd") = sheetObj.CellValue(nCopyRow, "all_in_rt_cd");
	sheetObj.CellValue2(nNewRow, "curr_cd") = sheetObj.CellValue(nCopyRow, "curr_cd");
	sheetObj.CellValue2(nNewRow, "trns_rev_amt") = sheetObj.CellValue(nCopyRow, "trns_rev_amt");
	sheetObj.CellValue2(nNewRow, "non_trns_rev_amt") = sheetObj.CellValue(nCopyRow, "non_trns_rev_amt");
	sheetObj.CellValue2(nNewRow, "add_rev_amt") = sheetObj.CellValue(nCopyRow, "add_rev_amt");
	sheetObj.CellValue2(nNewRow, "add_rev_chg_cd") = sheetObj.CellValue(nCopyRow, "add_rev_chg_cd");
	sheetObj.CellValue2(nNewRow, "add_rev_am2t") = sheetObj.CellValue(nCopyRow, "add_rev_amt2");
	sheetObj.CellValue2(nNewRow, "add_rev_chg_cd2") = sheetObj.CellValue(nCopyRow, "add_rev_chg_cd2");
	sheetObj.CellValue2(nNewRow, "add_rev_amt3") = sheetObj.CellValue(nCopyRow, "add_rev_amt3");
	sheetObj.CellValue2(nNewRow, "add_rev_chg_cd3") = sheetObj.CellValue(nCopyRow, "add_rev_chg_cd3");

	sheetObj.CellValue2(nNewRow, "vat_flg") = sheetObj.CellValue(nCopyRow, "vat_flg");
	//sheetObj.CellValue2(nNewRow, "rc_seq") = sheetObj.CellValue(nCopyRow, "rc_seq");
	//sheetObj.CellValue2(nNewRow, "awk_cgo_seq") = sheetObj.CellValue(nCopyRow, "awk_cgo_seq");
	// hidden
	sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd_old") = sheetObj.CellValue(nCopyRow, "cntr_tpsz_cd_old");
	sheetObj.CellValue2(nNewRow, "hlg_tp_cd_old") = sheetObj.CellValue(nCopyRow, "hlg_tp_cd_old");

	sheetObj.CellValue2(nNewRow, "optm_sts_cd") = sheetObj.CellValue(nCopyRow, "optm_sts_cd");
		
	sheetObj.CellValue2(nNewRow, "cxl_flg") = "N";
}

/**     
 * [tro_dtl]AddRow한 행에, 값을 Copy 한다.
 */
function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
	var formObj = document.form;
	if (sheetObj_copy == null) {
		sheetObj_copy = sheetObj;
	}
	sheetObj.CellValue2(nNewRow, "dor_addr_tp_cd") = sheetObj_copy.CellValue(nCopyRow, "dor_addr_tp_cd");
	sheetObj.CellValue2(nNewRow, "dor_loc_cd") = sheetObj_copy.CellValue(nCopyRow, "dor_loc_cd");
	sheetObj.CellValue2(nNewRow, "zn_cd") = sheetObj_copy.CellValue(nCopyRow, "zn_cd");
	sheetObj.CellValue2(nNewRow, "lod_ref_no") = sheetObj_copy.CellValue(nCopyRow, "lod_ref_no");
	sheetObj.CellValue2(nNewRow, "dor_pst_no") = sheetObj_copy.CellValue(nCopyRow, "dor_pst_no");
	sheetObj.CellValue2(nNewRow, "dor_addr_1") = sheetObj_copy.CellValue(nCopyRow, "dor_addr_1");
	sheetObj.CellValue2(nNewRow, "dor_addr_2") = sheetObj_copy.CellValue(nCopyRow, "dor_addr_2");
	sheetObj.CellValue2(nNewRow, "dor_addr_3") = sheetObj_copy.CellValue(nCopyRow, "dor_addr_3");
	sheetObj.CellValue2(nNewRow, "dor_addr_4") = sheetObj_copy.CellValue(nCopyRow, "dor_addr_4");
	sheetObj.CellValue2(nNewRow, "arr_dt") = sheetObj_copy.CellValue(nCopyRow, "arr_dt");
	sheetObj.CellValue2(nNewRow, "arr_dt_hhmi") = sheetObj_copy.CellValue(nCopyRow, "arr_dt_hhmi");
	sheetObj.CellValue2(nNewRow, "cntc_pson_nm") = sheetObj_copy.CellValue(nCopyRow, "cntc_pson_nm");
	sheetObj.CellValue2(nNewRow, "cntc_phn_no") = sheetObj_copy.CellValue(nCopyRow, "cntc_phn_no");
	sheetObj.CellValue2(nNewRow, "cntc_eml") = sheetObj_copy.CellValue(nCopyRow, "cntc_eml");
	// sheetObj.CellValue2(nNewRow, "cxl_flg") = "N";

	sheetObj.CellValue2(nNewRow, "cntr_tpsz_cd_old") = sheetObj_copy.CellValue(nCopyRow, "cntr_tpsz_cd"); // copy 시에는, new -> old 로 함
	sheetObj.CellValue2(nNewRow, "tro_qty_old") = sheetObj_copy.CellValue(nCopyRow, "tro_qty"); // copy 시에는, tro_qty -> tro_qty_old 로 함
}

/**     
 * [tro_master_multicombo]AddRow한 행에, 값을 Copy 한다.
 */
function copyTrodgseq(copy_tro_seq, new_tro_seq) {
	var sheetObj = x_sheetObject4;

	// 1) dtl check (tro_seq)
	sheetObj.CheckAll2("del_chk") = 0; // hidden chk : check clear

	// 2) copy_tro_seq 항목을 checking
	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	while (nRow > -1) {
		nRow = sheetObj.FindText("tro_seq", copy_tro_seq, nStartRow);
		if (nRow > -1) {
			sheetObj.CellValue2(nRow, "del_chk") = 1;
			nStartRow = nRow + 1;
		}
	}

	//3) sheetObj.copy 
	var sRow = sheetObj.FindCheckedRow("del_chk");
	var arrRow = sRow.split("|");
	for ( var idx = 0; idx <= arrRow.length - 2; idx++) 
	{
		var nNewRow = sheetObj.DataInsert(-1);
		sheetObj.CellValue2(nNewRow, "tro_seq") = new_tro_seq;
		sheetObj.CellValue2(nNewRow, "tro_dcgo_seq") = sheetObj.CellValue(arrRow[idx], "tro_dcgo_seq");
	}
}

/**     
 * [tro_master]AddRow한 행에, 특정항목의 default값을 설정한다.
 */
function setDefaultInsertRow(sheetObj, nRow, NCflag, nCopyRow) {
	var formObj = document.form;
	var prevMaxTroSeq = "";

	prevMaxTroSeq = getPrevMaxTroSeq(sheetObj, nRow, "tro_seq");

	// -------------------------------------------
	// 2) tro-master : New 기준 grid 초기값 setting
	with (formObj) {
		sheetObj.CellValue2(nRow, "tro_seq") = parseInt(prevMaxTroSeq) + 1; // new tro_seq : max+1
		sheetObj.CellValue2(nRow, "hlg_tp_cd") = "C";
		sheetObj.CellValue2(nRow, "cxl_flg") = "N";
		// sheetObj.CellValue2(nRow, "rqst_sub_seq") = "001";
		sheetObj.CellValue2(nRow, "rqst_sub_seq") = "1";
		sheetObj.CellValue2(nRow, "cntr_tpsz_cd") = getDefaultVal_tpsz();
		if (term.value == "D") {
			sheetObj.CellValue2(nRow, "all_in_rt_cd") = "Y";
		} else {
			sheetObj.CellValue2(nRow, "all_in_rt_cd") = "N";
		}
		sheetObj.CellValue2(nRow, "vat_flg") = "N";

		sheetObj.CellValue2(nRow, "hlg_tp_cd_old") = sheetObj.CellValue(nRow, "hlg_tp_cd"); // !!!!!!!!!!!!!!
		sheetObj.CellValue2(nRow, "cntr_tpsz_cd_old") = sheetObj.CellValue(nRow, "cntr_tpsz_cd"); // !!!!!!!!!!!!!!
		sheetObj.CellValue2(nRow, "bkg_trsp_mzd_cd") = (formObj.io_bnd_cd.value=="O")?formObj.org_trns_mod_cd.value:formObj.dest_trns_mod_cd.value;
		clearHaulageData_master(sheetObj, nRow, "C"); // 비활성 항목 : data clear_master
	}

	return sheetObj.CellValue(nRow, "tro_seq");
}

/**     
 * [tro_dtl]AddRow한 행에, 특정항목의 default값을 설정한다.
 */
function setDefaultInsertRow_Dtl(sheetObj, nRow, currTroSeq) {
	var formObj = document.form;
	var prevMaxTroSubSeq = "";

	prevMaxTroSubSeq = getPrevMaxTroSubSeq(sheetObj, currTroSeq, "tro_sub_seq");

	with (formObj) {
		sheetObj.CellValue2(nRow, "tro_seq") = currTroSeq;
		sheetObj.CellValue2(nRow, "tro_sub_seq") = parseInt(prevMaxTroSubSeq) + 1; // new tro_sub_seq : max+1

		clearHaulageData_dtl(sheetObj, nRow, "C"); // 비활성 항목 : data clear_dtl
	}
}

/** 
 * 조회시, qtysum color 초기화 
 */
function changeTroQtyColor(sheetObj_qty) {
	var formObj = document.form;

	for ( var i = 1; i <= sheetObj_qty.RowCount; i++) {
		var cntr_tpsz_cd = sheetObj_qty.CellValue(i, "cntr_tpsz_cd");
		var n_totQty = parseInt(sheetObj_qty.CellValue(i, "total_qty"));
		var n_currTroqty_CH = parseInt(sheetObj_qty.CellValue(i, "tro_qty_ch"));
		var n_currTroqty_MH = parseInt(sheetObj_qty.CellValue(i, "tro_qty_mh"));
		var n_currTroqty = n_currTroqty_CH + n_currTroqty_MH;

		if (n_totQty > n_currTroqty) {
			sheetObj_qty.CellFontColor(i, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
			sheetObj_qty.CellFontColor(i, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
		} else if (n_totQty == n_currTroqty) {
			sheetObj_qty.CellFontColor(i, "tro_qty_ch") = sheetObj_qty.RgbColor(0, 0, 0);
			sheetObj_qty.CellFontColor(i, "tro_qty_mh") = sheetObj_qty.RgbColor(0, 0, 0);
		} else if (nullToBlank(sheetObj_qty.CellValue(i, "tro_qty_ch")) != "" || nullToBlank(sheetObj_qty.CellValue(i, "tro_qty_mh")) != "") {
			if (nullToBlank(sheetObj_qty.CellValue(i, "tro_qty_ch")) != "") {
				sheetObj_qty.CellFontColor(i, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
			}
			if (nullToBlank(sheetObj_qty.CellValue(i, "tro_qty_mh")) != "") {
				sheetObj_qty.CellFontColor(i, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
			}
			//callShowMessageBiggerQty("TP/SZ:"+sheetObj_qty.CellValue(i, "cntr_tpsz_cd"));
		}
	}
}

/**     
 * [tro_dtl]변경시, sumqty 출력변경 : All(P/M)
 */
function changeSumTroQty(preVal_type, preVal_hlg, preTroQty, nxtVal_type, nxtVal_hlg, nxtTroQty) {
	var formObj = document.form;
	var sheetObj_qty = x_sheetObject5;
	var bTotSumChange_flg = false;
	if (preVal_type != nxtVal_type) {
		bTotSumChange_flg = true;
	}

	sheetObj_qty.ReDraw = false;

	// 1) next qty (+)처리
	var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
	if (nSRow > -1) 
	{
		var tro_qty_colid = null;
		var n_totQty = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
		var n_currTroqty_ch = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_ch"));
		var n_currTroqty_mh = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_mh"));
		var n_currTroqty = null;
		if (nxtVal_hlg == "C") {
			n_currTroqty = n_currTroqty_ch;
			tro_qty_colid = "tro_qty_ch";
		} else if (nxtVal_hlg == "M") {
			n_currTroqty = n_currTroqty_mh;
			tro_qty_colid = "tro_qty_mh";
		}
		var n_t_chgTroqty = null;
		if (bTotSumChange_flg) {
			n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh) + parseInt(nxtTroQty);
		} else {
			n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh);
		}

		//*) 색상변경 : 체크추가 -------->
		if (n_totQty > n_t_chgTroqty) {
			sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
			sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
		} else if (n_totQty == n_t_chgTroqty) {
			sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(0, 0, 0);
			sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(0, 0, 0);
		} else {
			if ((preVal_hlg != nxtVal_hlg) && (x_sheetObject2.CellValue(1, "tro_seq") == 1) && (x_sheetObject2.CellValue(1, "ibflag") == "I")) {
				// 첫 row가 insert일 때 (최초 생성일 때) haulage 변경에 한해서 validation skip
			} else {
				callShowMessageBiggerQty("TP/SZ:" + sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));

				formObj.cntr_tpsz_cd.value = preVal_type; // 변경전 값으로 재변경
				formObj.hlg_tp_cd.Code2 = preVal_hlg; // 변경전 값으로 재변경 : 콤보 -> onchange call 않함
				if (preVal_hlg != nxtVal_hlg) {
					formObj.hlg_tp_cd.focus();
				} else {
					formObj.cntr_tpsz_cd.focus();
				}
				sheetObj_qty.ReDraw = true;
				return false;
			}
		}
		//<-------------------

		// 값 변경
		sheetObj_qty.CellValue2(nSRow, tro_qty_colid) = n_currTroqty + parseInt(nxtTroQty);

		// 2) pre qty (-)처리
		var nSRow = 0;
		if (sheetObj_qty.RowCount == 1) {
			nSRow = 1;
		} else {
			nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", preVal_type);
		}
		if (nSRow > -1) 
		{
			var n_totQty = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
			var n_currTroqty_ch = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_ch"));
			var n_currTroqty_mh = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_mh"));

			var n_currTroqty = null;

			// haulage 변경시 이전 값이 없으면 반대로 지정
			if (preVal_hlg == "" && preVal_hlg != nxtVal_hlg) {
				if (nxtVal_hlg == "C") {
					preVal_hlg = "M";
				} else
					preVal_hlg = "C";
			}

			if (preVal_hlg == "C") {
				n_currTroqty = n_currTroqty_ch;
				tro_qty_colid = "tro_qty_ch";
			} else if (preVal_hlg == "M") {
				n_currTroqty = n_currTroqty_mh;
				tro_qty_colid = "tro_qty_mh";
			}

			var n_t_chgTroqty = null;
			if (bTotSumChange_flg) {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh) - parseInt(preTroQty);
			} else {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh);
			}

			//값 변경
			sheetObj_qty.CellValue2(nSRow, tro_qty_colid) = n_currTroqty - parseInt(preTroQty);

			// 색상 변경
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(0, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(0, 0, 0);
			}
		}

		//3) currVal -> oldVal 
		formObj.cntr_tpsz_cd_old.value = nxtVal_type;
		formObj.hlg_tp_cd_old.value = nxtVal_hlg;
	} else {
		ComShowCodeMessage("BKG00297"); // 등록할 수 없는 TP/SZ

		formObj.cntr_tpsz_cd.value = preVal_type;
		formObj.cntr_tpsz_cd.focus();
	}
	sheetObj_qty.ReDraw = true;

	return true;
}

/**     
 * [tro_dtl]변경시, sumqty 출력변경 : Option(P/M)
 */
function plusMinusSumTroQty(nxtVal_type, nxtVal_hlg, nxtTroQty, PM_gubun) {
	var formObj = document.form;
	var sheetObj_qty = x_sheetObject5;
	if (preVal_type != nxtVal_type) {
		bTotSumChange_flg = true;
	}

	sheetObj_qty.ReDraw = false;
	if ("P" == PM_gubun) {
		var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
		if (nSRow > -1) 
		{
			var n_totQty = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
			var n_currTroqty_ch = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_ch"));
			var n_currTroqty_mh = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_mh"));

			var tro_qty_colid = null;
			var n_currTroqty = null;
			if (nxtVal_hlg == "C") {
				n_currTroqty = n_currTroqty_ch;
				tro_qty_colid = "tro_qty_ch";
			} else if (nxtVal_hlg == "M") {
				n_currTroqty = n_currTroqty_mh;
				tro_qty_colid = "tro_qty_mh";
			}
			var n_t_chgTroqty = null;
			if (bTotSumChange_flg) {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh) + parseInt(nxtTroQty);
			} else {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh);
			}

			//*) 색상변경 : 체크추가 -------->
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(0, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(0, 0, 0);
			} else {
				callShowMessageBiggerQty("TP/SZ:" + sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));

				var preVal_type = formObj.cntr_tpsz_cd_old.value;
				var preVal_hlg = formObj.hlg_tp_cd_old.value;
				formObj.cntr_tpsz_cd.value = preVal_type; // 변경전 값으로 재변경
				formObj.hlg_tp_cd.Code2 = preVal_hlg; // 변경전 값으로 재변경 : 콤보 -> onchange call
				if (preVal_hlg != nxtVal_hlg) {
					formObj.hlg_tp_cd.focus();
				} else {
					formObj.cntr_tpsz_cd.focus();
				}
				sheetObj_qty.ReDraw = true;
				return;
			}
			//<-------------------

			// 값 변경
			sheetObj_qty.CellValue2(nSRow, tro_qty_colid) = n_currTroqty + parseInt(nxtTroQty);
		}
	} else if ("M" == PM_gubun) {
		var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
		if (nSRow > -1) 
		{
			var n_totQty = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
			var n_currTroqty_ch = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_ch"));
			var n_currTroqty_mh = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_mh"));

			var tro_qty_colid = null;
			var n_currTroqty = null;
			if (nxtVal_hlg == "C") {
				n_currTroqty = n_currTroqty_ch;
				tro_qty_colid = "tro_qty_ch";
			} else if (nxtVal_hlg == "M") {
				n_currTroqty = n_currTroqty_mh;
				tro_qty_colid = "tro_qty_mh";
			}
			var n_t_chgTroqty = null;
			if (bTotSumChange_flg) {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh) - parseInt(nxtTroQty);
			} else {
				n_t_chgTroqty = (n_currTroqty_ch + n_currTroqty_mh);
			}

			//값 변경
			sheetObj_qty.CellValue2(nSRow, tro_qty_colid) = n_currTroqty - parseInt(nxtTroQty);

			// 색상 변경
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(255, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(255, 0, 0);
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_ch") = sheetObj_qty.RgbColor(0, 0, 0);
				sheetObj_qty.CellFontColor(nSRow, "tro_qty_mh") = sheetObj_qty.RgbColor(0, 0, 0);
			}
		}
	}
	sheetObj_qty.ReDraw = true;
}

/**
 * CopyCNTR 전, troqty 수량초과 체크 
 */
function checkCopySumTroqty(sheetObj) {
	var formObj = document.form;
	var sheetObj_qty = x_sheetObject5;

	if (sheetObj.id == "t2csheet2") 
	{
		var nCopyCnt = formObj.tro_copy_cnt.value;
		if (nCopyCnt == "") {
			nCopyCnt = 1; // 없으면, default : 1
		}

		var cntr_tpsz_cd_copy = formObj.cntr_tpsz_cd.value;
		var nSRow = sheetObj_qty.FindText("cntr_tpsz_cd", cntr_tpsz_cd_copy);
		if (nSRow > -1) {
			var totqty = parseInt(sheetObj_qty.CellValue(nSRow, "total_qty"));
			var n_currTroqty_CH = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_ch"));
			var n_currTroqty_MH = parseInt(sheetObj_qty.CellValue(nSRow, "tro_qty_mh"));
			var n_currTroqty = n_currTroqty_CH + n_currTroqty_MH;
			// var changeTroqty = n_currTroqty + 1;
			var changeTroqty = n_currTroqty + parseInt(nCopyCnt);

			if (totqty < changeTroqty) {
				callShowMessageBiggerQty("TP/SZ:" + sheetObj_qty.CellValue(nSRow, "cntr_tpsz_cd"));
				return false;
			}
		}
	}

	return true;
}

/**
 * AddCNTR 전, troqty 총수량초과 체크   
 */
function checkAddSumTroqty() {
	var formObj = document.form;
	var sheetObj_qty = x_sheetObject5;

	var bResult = false; // 수량추가 가능 flag
	for ( var i = 1; i <= sheetObj_qty.RowCount; i++) 
	{
		var n_totQty = parseInt(sheetObj_qty.CellValue(i, "total_qty"));
		var n_currTroqty_CH = parseInt(sheetObj_qty.CellValue(i, "tro_qty_ch"));
		var n_currTroqty_MH = parseInt(sheetObj_qty.CellValue(i, "tro_qty_mh"));
		var n_currTroqty = n_currTroqty_CH + n_currTroqty_MH;

		if (n_totQty > n_currTroqty) {
			bResult = true;
			break;
		}
	}

	return bResult;
}

/**
 * TP/SZ default값 get  
 */
function getDefaultVal_tpsz() {
	var formObj = document.form;
	var sheetObj_qty = x_sheetObject5;
	var strTpsz = "";

	if (sheetObj_qty.RowCount == 1) {
		strTpsz = sheetObj_qty.CellValue(1, "cntr_tpsz_cd");
	}

	return strTpsz;
}

//######################[3. Data Display/Store (Master/Detail)]###############################
/**
 * 비활성 항목 : sheet data clear master
 */
function clearHaulageData_master(sheetObj, nRow, haulage) {
	var objForm = document.form;

	with (objForm) {
		sheetObj.CellValue2(nRow, "tro_cmdt_cd") = cmdt_cd.value; // Booking : cmdt_cd
		sheetObj.CellValue2(nRow, "rep_cmdt_cd") = bkg_rep_cmdt_cd.value; // Booking : cmdt_cd
		sheetObj.CellValue2(nRow, "rep_cmdt_nm") = bkg_rep_cmdt_nm.value; // Booking : cmdt_nm

		if (haulage == "C") {
			//default val set
			if (x_sheetObject5.RowCount == 1 && x_sheetObject5.CellValue(1, "total_qty") == 1) {
				//sheetObj.CellValue2(nRow, "cgo_wgt")       = act_wgt.value;    // Booking : estimagted weight 
				//콤마 등 변환
				var t_cgo_wgt = act_wgt.value;
				t_cgo_wgt = delComma_loc(t_cgo_wgt, 0, 9, 3);
				sheetObj.CellValue2(nRow, "cgo_wgt") = t_cgo_wgt;
			}
			//clear 
			if (io_bnd_cd.value == "I") {
				sheetObj.CellValue2(nRow, "cntr_pkup_yd_cd") = pickup_cy.value; 		// Booking : pickup_cy
				sheetObj.CellValue2(nRow, "cntr_pkup_dt") = pkup_dt.value; 				// Booking : pickup_dt
				sheetObj.CellValue2(nRow, "cntr_pkup_dt_hhmi") = pkup_dt_hhmi.value; 	// Booking : pickup_hhmi
				sheetObj.CellValue2(nRow, "cntr_pkup_yd_cd") = pickup_cy.value; 		// Booking : pickup_cy
				sheetObj.CellValue2(nRow, "cntr_rtn_yd_cd") = "";						// Booking : return_yd 
				sheetObj.CellValue2(nRow, "cntr_rtn_dt") = ""; 							// Booking : return_dt
				sheetObj.CellValue2(nRow, "cntr_rtn_dt_hhmi") = "";						// Booking : return_hhmi
			} else {
				sheetObj.CellValue2(nRow, "cntr_pkup_yd_cd") = ""; 						// Booking : pkup_yd
				sheetObj.CellValue2(nRow, "cntr_pkup_dt") = ""; 						// Booking : pickup_dt
				sheetObj.CellValue2(nRow, "cntr_pkup_dt_hhmi") = "";	 				// Booking : pickup_hhmi
				sheetObj.CellValue2(nRow, "cntr_rtn_yd_cd") = return_cy.value;			// Booking : return_yd
				sheetObj.CellValue2(nRow, "cntr_rtn_dt") = rtn_dt.value; 				// Booking : return_dt
				sheetObj.CellValue2(nRow, "cntr_rtn_dt_hhmi") = rtn_dt_hhmi.value; 		// Booking : return_hhmi
			}
		} else if (haulage == "M") {
			//default val set
			sheetObj.CellValue2(nRow, "cntr_pkup_yd_cd") = pickup_cy.value; 			// Booking : pickup_cy
			sheetObj.CellValue2(nRow, "cntr_pkup_dt") = pkup_dt.value; 					// Booking : pickup_dt
			sheetObj.CellValue2(nRow, "cntr_pkup_dt_hhmi") = pkup_dt_hhmi.value; 		// Booking : pickup_hhmi
			sheetObj.CellValue2(nRow, "cntr_rtn_yd_cd") = return_cy.value; 				// Booking : return_yd
			sheetObj.CellValue2(nRow, "cntr_rtn_dt") = rtn_dt.value; 					// Booking : return_dt
			sheetObj.CellValue2(nRow, "cntr_rtn_dt_hhmi") = rtn_dt_hhmi.value;			// Booking : return_hhmi

			// clear
			sheetObj.CellValue2(nRow, "cgo_wgt") = "";
		}
	}
}

/** 
 * 비활성 항목 : form data clear master
 */
function clearFormData_master(haulage) {
	var objForm = document.form;

	with (objForm) {
		tro_cmdt_cd.value = cmdt_cd.value; // Booking : cmdt_cd
		rep_cmdt_cd.value = bkg_rep_cmdt_cd.value; // Booking : cmdt_cd
		rep_cmdt_nm.value = bkg_rep_cmdt_nm.value; // Booking : cmdt_nm

		if (haulage == "C") {
			//default val set
			// cgo_wgt.value = t_cgo_wgt; //Booking : estimagted weight
			// 콤마 등 변환
			var t_cgo_wgt = act_wgt.value;
			t_cgo_wgt = changeComma_loc(t_cgo_wgt, 0, 9, 3);
			cgo_wgt.value = t_cgo_wgt;

			// clear
			if (io_bnd_cd.value == "I") {
				cntr_pkup_yd_cd.value = pickup_cy.value;			// Booking : pickup_cy
				cntr_pkup_dt.value = pkup_dt.value; 				// Booking : pickup_dt
				cntr_pkup_dt_hhmi.value = pkup_dt_hhmi.value; 		// Booking : pickup_hhmi
				cntr_rtn_yd_cd.value = ""; 							// Booking : return_yd
				cntr_rtn_dt.value = ""; 							// Booking : return_dt
				cntr_rtn_dt_hhmi.value = "";						// Booking : return_hhmi
			} else {
				cntr_pkup_yd_cd.value = ""; 						// Booking : pkup_yd
				cntr_pkup_dt.value = ""; 							// Booking : pickup_dt
				cntr_pkup_dt_hhmi.value = ""; 						// Booking : pickup_hhmi
				cntr_rtn_yd_cd.value = return_cy.value; 			// Booking : return_yd
				cntr_rtn_dt.value = rtn_dt.value; 					// Booking : return_dt
				cntr_rtn_dt_hhmi.value = rtn_dt_hhmi.value; 		// Booking : return_hhmi
			}
		} else if (haulage == "M") {
			//default val set
			cntr_pkup_yd_cd.value = pickup_cy.value; 				// Booking : pickup_cy
			cntr_pkup_dt.value = pkup_dt.value; 					// Booking : pickup_dt
			cntr_pkup_dt_hhmi.value = pkup_dt_hhmi.value; 			// Booking : pickup_hhmi
			cntr_rtn_yd_cd.value = return_cy.value; 				// Booking : return_yd
			cntr_rtn_dt.value = rtn_dt.value; 						// Booking : return_dt
			cntr_rtn_dt_hhmi.value = rtn_dt_hhmi.value; 			// Booking : return_hhmi
			// clear
			cgo_wgt.value = "";
		}
	}
}

/** 
 * 비활성 항목 : sheet data clear master
 */
function clearHaulageData_dtl(sheetObj, nRow, haulage) {
	var objForm = document.form;

	with (objForm) {
		if (io_bnd_cd.value == "O") {
			if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Food Grade, Hide ";
				}
			} 
			else if (fd_grd_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Food Grade ";
				}
			} 
			else if (spcl_hide_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Hide ";
				}
			}
		}

		if (haulage == "C") {
			//default val set
			sheetObj.CellValue2(nRow, "dor_addr_tp_cd") = "D"; // default : Door
			if (term.value == "D") {
				if (io_bnd_cd.value == "O") {
					sheetObj.CellValue2(nRow, "dor_loc_cd") = por_cd.value.substr(0, 5);
				} else if (io_bnd_cd.value == "I") {
					sheetObj.CellValue2(nRow, "dor_loc_cd") = del_cd.value.substr(0, 5);
				}
			}
			if (sheetObj.CellValue(nRow, "zn_cd").trim() == "") {
				sheetObj.CellValue2(nRow, "zn_cd") = "01";
			}
		} else if (haulage == "M") {
			//clear 
			sheetObj.CellValue2(nRow, "dor_loc_cd") = "";
			sheetObj.CellValue2(nRow, "zn_cd") = "";
		}
	}
}

/** 
 * 비활성 항목 : form data clear master
 */
function clearFormData_dtl(haulage) {
	var objForm = document.form;

	with (objForm) {
		if (io_bnd_cd.value == "O") {
			if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Food Grade, Hide ";
				}
			} 
			else if (fd_grd_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Food Grade ";
				}
			} 
			else if (spcl_hide_flg.value == "Y") {
				if (spcl_instr_rmk.value == "") {
					spcl_instr_rmk.value = "Hide ";
				}
			}
		}
		if (haulage == "C") {
			//default val set		        
			if (term.value == "D") {
				if (io_bnd_cd.value == "O") {
					dor_loc_cd.value = por_cd.value.substr(0, 5);
				} else if (io_bnd_cd.value == "I") {
					dor_loc_cd.value = del_cd.value.substr(0, 5);
				}
			}
			if (zn_cd.value.trim() == "") {
				zn_cd.value = "01";
			}
		} else if (haulage == "M") {
			//clear 
			dor_loc_cd.value = "";
			zn_cd.value = "";
		}
	}
}

/** 
 * Tro-Master 출력 (Sheet -> Form : Display)
 */
function setDataToForm_TroMst(tro_seq) {
	var objForm = document.form;
	var sheetObj = x_sheetObject2;

	// -----------------------------------
	// 1) tro_seq Value에 해당하는 row로 초기화
	var nRow = sheetObj.FindText("tro_seq", tro_seq);

	// -----------------------------------
	// 2) 출력
	with (objForm) {
		tro_seq.Text2 = sheetObj.CellValue(nRow, "tro_seq");
		if (x_oldTroSeq == "") {
			x_oldTroSeq = tro_seq.Text;
		}
		ComSetObjValue(tro_seq_maxcnt, sheetObj.RowCount);

		var t_new_row_flg = (nullToBlank(sheetObj.CellValue(nRow, "ibflag")) == "I") ? "Y" : "N";
		ComSetObjValue(new_row_flg, t_new_row_flg);

		ComSetObjValue(rqst_sub_seq, nullToBlank(sheetObj.CellValue(nRow, "rqst_sub_seq")));
		ComSetObjValue(cntr_no, nullToBlank(sheetObj.CellValue(nRow, "cntr_no")));
		ComboList(arrData);
		ComSetObjValue(cntr_no_sel, nullToBlank(sheetObj.CellValue(nRow, "cntr_no")));
		ComSetObjValue(cntr_tpsz_cd, nullToBlank(sheetObj.CellValue(nRow, "cntr_tpsz_cd")));
		hlg_tp_cd.Code2 = nullToBlank(sheetObj.CellValue(nRow, "hlg_tp_cd"));

		// 콤마 등 변환
		var t_cgo_wgt = nullToBlank(sheetObj.CellValue(nRow, "cgo_wgt"));
		t_cgo_wgt = changeComma_loc(t_cgo_wgt, 0, 9, 3);
		ComSetObjValue(cgo_wgt, t_cgo_wgt);

		ComSetObjValue(cgo_wgt_tp, wgt_ut_cd.value); // Booking : estimagted weight tp

		ComSetObjValue(cntr_pkup_yd_cd, nullToBlank(sheetObj.CellValue(nRow, "cntr_pkup_yd_cd")));
		ComSetObjValue(cntr_rtn_yd_cd, nullToBlank(sheetObj.CellValue(nRow, "cntr_rtn_yd_cd")));
		ComSetObjValue(cntr_rtn_dt, nullToBlank(sheetObj.CellValue(nRow, "cntr_rtn_dt")));
		ComSetObjValue(cntr_rtn_dt_hhmi, nullToBlank(sheetObj.CellValue(nRow, "cntr_rtn_dt_hhmi")));
		ComSetObjValue(tro_cmdt_cd, nullToBlank(sheetObj.CellValue(nRow, "tro_cmdt_cd")));
		ComSetObjValue(rep_cmdt_cd, nullToBlank(sheetObj.CellValue(nRow, "rep_cmdt_cd")));
		ComSetObjValue(rep_cmdt_nm, nullToBlank(sheetObj.CellValue(nRow, "rep_cmdt_nm")));
		bkg_trsp_mzd_cd.Code2 = nullToBlank(sheetObj.CellValue(nRow, "bkg_trsp_mzd_cd"));
		optm_sts_cd.Code = nullToBlank(sheetObj.CellValue(nRow, "optm_sts_cd"));
		ComSetObjValue(not_optm_rsn, nullToBlank(sheetObj.CellValue(nRow, "not_optm_rsn")));
		ComSetObjValue(cntr_pkup_dt, nullToBlank(sheetObj.CellValue(nRow, "cntr_pkup_dt")));
		ComSetObjValue(cntr_pkup_dt_hhmi, nullToBlank(sheetObj.CellValue(nRow, "cntr_pkup_dt_hhmi")));
		ComSetObjValue(spcl_instr_rmk, nullToBlank(sheetObj.CellValue(nRow, "spcl_instr_rmk")));

		var t_cfm_flg_nm = (nullToBlank(sheetObj.CellValue(nRow, "cfm_flg")) == "Y") ? "Yes" : "No";
		if (sheetObj.CellValue(nRow, "split_rmk") != "") t_cfm_flg_nm = "Moved to " + sheetObj.CellValue(nRow, "split_rmk");
		ComSetObjValue(cfm_flg, t_cfm_flg_nm);

		ComSetObjValue(cfm_dt, nullToBlank(sheetObj.CellValue(nRow, "cfm_dt")));
		ComSetObjValue(cfm_ofc_cd, nullToBlank(sheetObj.CellValue(nRow, "cfm_ofc_cd")));
		ComSetObjValue(cfm_usr_id, nullToBlank(sheetObj.CellValue(nRow, "cfm_usr_id")));
		ComSetObjValue(cfm_usr_nm, nullToBlank(sheetObj.CellValue(nRow, "cfm_usr_nm")));
		ComSetObjValue(so_no, nullToBlank(sheetObj.CellValue(nRow, "so_no")));
		ComSetObjValue(so_dt, nullToBlank(sheetObj.CellValue(nRow, "so_dt")));
		ComSetObjValue(so_ofc_cd, nullToBlank(sheetObj.CellValue(nRow, "so_ofc_cd")));
		ComSetObjValue(so_usr_id, nullToBlank(sheetObj.CellValue(nRow, "so_usr_id")));
		ComSetObjValue(so_usr_nm, nullToBlank(sheetObj.CellValue(nRow, "so_usr_nm")));

		ComSetObjValue(cntr_prt_flg, nullToBlank(sheetObj.CellValue(nRow, "cntr_prt_flg")));
		if (cntr_prt_flg.value == "Y") {
			document.getElementById("btn_t2cMulti").style.color = "#0000ff";
		} else {
			document.getElementById("btn_t2cMulti").style.color = "";
		}

		ComSetObjValue(t1_doc_flg, nullToBlank(sheetObj.CellValue(nRow, "t1_doc_flg")));
		ComSetObjValue(cstms_clr_no, nullToBlank(sheetObj.CellValue(nRow, "cstms_clr_no")));
		ComSetObjValue(all_in_rt_cd, nullToBlank(sheetObj.CellValue(nRow, "all_in_rt_cd")));
		ComSetObjValue(curr_cd, nullToBlank(sheetObj.CellValue(nRow, "curr_cd")));

		// ComSetObjValue(trns_rev_amt, nullToBlank(sheetObj.CellValue(nRow, "trns_rev_amt")));
		// 콤마 등 변환
		var t_trns_rev_amt = nullToBlank(sheetObj.CellValue(nRow, "trns_rev_amt"));
		
		t_trns_rev_amt = changeComma_loc(t_trns_rev_amt, 0, 9, 2);
		ComSetObjValue(trns_rev_amt, t_trns_rev_amt);

		var t_non_trns_rev_amt = nullToBlank(sheetObj.CellValue(nRow, "non_trns_rev_amt"));
		t_non_trns_rev_amt = changeComma_loc(t_non_trns_rev_amt, 0, 9, 2);
		ComSetObjValue(non_trns_rev_amt, t_non_trns_rev_amt);

		var t_add_rev_amt = nullToBlank(sheetObj.CellValue(nRow, "add_rev_amt"));
		t_add_rev_amt = changeComma_loc(t_add_rev_amt, 0, 9, 2);
		ComSetObjValue(add_rev_amt, t_add_rev_amt);
		
		var t_add_rev_amt2 = nullToBlank(sheetObj.CellValue(nRow, "add_rev_amt2"));
		t_add_rev_amt2 = changeComma_loc(t_add_rev_amt2, 0, 9, 2);
		ComSetObjValue(add_rev_amt2, t_add_rev_amt2);
				
		var t_add_rev_amt3 = nullToBlank(sheetObj.CellValue(nRow, "add_rev_amt3"));
		t_add_rev_amt3 = changeComma_loc(t_add_rev_amt3, 0, 9, 2);
		ComSetObjValue(add_rev_amt3, t_add_rev_amt3);
		
		var t_add_rev_rmk = nullToBlank(sheetObj.CellValue(nRow, "add_rev_rmk"));
		ComSetObjValue(add_rev_rmk, t_add_rev_rmk);

		ComSetObjValue(add_rev_chg_cd, nullToBlank(sheetObj.CellValue(nRow, "add_rev_chg_cd")));
		ComSetObjValue(add_rev_chg_cd2, nullToBlank(sheetObj.CellValue(nRow, "add_rev_chg_cd2")));
		ComSetObjValue(add_rev_chg_cd3, nullToBlank(sheetObj.CellValue(nRow, "add_rev_chg_cd3")));
		ComSetObjValue(vat_flg, nullToBlank(sheetObj.CellValue(nRow, "vat_flg")));

		setRevenueColor();

		ComSetObjValue(cxl_flg, nullToBlank(sheetObj.CellValue(nRow, "cxl_flg")));
		ComSetObjValue(cntr_tpsz_cd_old, nullToBlank(sheetObj.CellValue(nRow, "cntr_tpsz_cd_old")));
		ComSetObjValue(hlg_tp_cd_old, nullToBlank(sheetObj.CellValue(nRow, "hlg_tp_cd_old")));
		ComSetObjValue(eur_trns_tp_cd, nullToBlank(sheetObj.CellValue(nRow, "eur_trns_tp_cd")));

		rc_seq.Text2 = nullToBlank(sheetObj.CellValue(nRow, "rc_seq"));
		ComSetObjValue(awk_cgo_seq, nullToBlank(sheetObj.CellValue(nRow, "awk_cgo_seq")));

		// -----------------------------------
		// 2-1) dgco_seq 화면출력
		setDataToForm_Tro_dg_seq(sheetObj.CellValue(nRow, "tro_seq"));
	}

	//-----------------------------------
	// 3) Color
	changeMasterColor();
	
	t1RevClickFlg = false;
}

/** 
 * Tro-Master Temp 저장 (Form ->Sheet  : Store)
 */
function setFormToData_TroMst(prev_tro_seq) {
	var objForm = document.form;
	var sheetObj = x_sheetObject2;

	// -----------------------------------
	// 1) tro_seq Value에 해당하는 row : delete 처리
	var nRow = sheetObj.FindText("tro_seq", prev_tro_seq);

	sheetObj.Redraw = false; // ----------------->
	// -----------------------------------
	// 2) Store(Update)
	with (objForm) {
		sheetObj.CellValue2(nRow, "tro_seq") = prev_tro_seq;
		sheetObj.CellValue2(nRow, "rqst_sub_seq") = ComGetObjValue(rqst_sub_seq);
		objForm.cntr_no.value = ComGetObjValue(cntr_no_sel);
		sheetObj.CellValue2(nRow, "cntr_no") = ComGetObjValue(cntr_no);
		sheetObj.CellValue2(nRow, "cntr_tpsz_cd") = ComGetObjValue(cntr_tpsz_cd);
		sheetObj.CellValue2(nRow, "hlg_tp_cd") = hlg_tp_cd.Code;

		// 콤마 등 변환
		// var t_cgo_wgt = nullToBlank(ComGetObjValue(cgo_wgt));
		var t_cgo_wgt = ComGetObjValue(cgo_wgt);
		t_cgo_wgt = delComma_loc(t_cgo_wgt);
		sheetObj.CellValue2(nRow, "cgo_wgt") = t_cgo_wgt;

		sheetObj.CellValue2(nRow, "cntr_pkup_yd_cd") = ComGetObjValue(cntr_pkup_yd_cd);
		sheetObj.CellValue2(nRow, "cntr_rtn_yd_cd") = ComGetObjValue(cntr_rtn_yd_cd);
		sheetObj.CellValue2(nRow, "cntr_rtn_dt") = ComGetObjValue(cntr_rtn_dt);
		sheetObj.CellValue2(nRow, "cntr_rtn_dt_hhmi") = ComGetObjValue(cntr_rtn_dt_hhmi);
		sheetObj.CellValue2(nRow, "tro_cmdt_cd") = ComGetObjValue(tro_cmdt_cd);
		sheetObj.CellValue2(nRow, "rep_cmdt_nm") = ComGetObjValue(rep_cmdt_nm);
		sheetObj.CellValue2(nRow, "rep_cmdt_cd") = ComGetObjValue(rep_cmdt_cd);
		sheetObj.CellValue2(nRow, "optm_sts_cd") = optm_sts_cd.Code;
		sheetObj.CellValue2(nRow, "not_optm_rsn") = ComGetObjValue(not_optm_rsn);
		sheetObj.CellValue2(nRow, "bkg_trsp_mzd_cd") = bkg_trsp_mzd_cd.Code;
		sheetObj.CellValue2(nRow, "cntr_pkup_dt") = ComGetObjValue(cntr_pkup_dt);
		sheetObj.CellValue2(nRow, "cntr_pkup_dt_hhmi") = ComGetObjValue(cntr_pkup_dt_hhmi);
		sheetObj.CellValue2(nRow, "spcl_instr_rmk") = ComGetObjValue(spcl_instr_rmk);
		sheetObj.CellValue2(nRow, "cfm_flg") = (ComGetObjValue(cfm_flg) == "Yes") ? "Y" : "N";
		sheetObj.CellValue2(nRow, "cfm_dt") = ComGetObjValue(cfm_dt);
		sheetObj.CellValue2(nRow, "cfm_ofc_cd") = ComGetObjValue(cfm_ofc_cd);
		sheetObj.CellValue2(nRow, "cfm_usr_id") = ComGetObjValue(cfm_usr_id);
		sheetObj.CellValue2(nRow, "cfm_usr_nm") = ComGetObjValue(cfm_usr_nm);
		sheetObj.CellValue2(nRow, "so_no") = ComGetObjValue(so_no);
		sheetObj.CellValue2(nRow, "so_dt") = ComGetObjValue(so_dt);
		sheetObj.CellValue2(nRow, "so_ofc_cd") = ComGetObjValue(so_ofc_cd);
		sheetObj.CellValue2(nRow, "so_usr_id") = ComGetObjValue(so_usr_id);
		sheetObj.CellValue2(nRow, "so_usr_nm") = ComGetObjValue(so_usr_nm);
		sheetObj.CellValue2(nRow, "cntr_prt_flg") = ComGetObjValue(cntr_prt_flg);
		sheetObj.CellValue2(nRow, "t1_doc_flg") = ComGetObjValue(t1_doc_flg);
		sheetObj.CellValue2(nRow, "cstms_clr_no") = ComGetObjValue(cstms_clr_no);
		sheetObj.CellValue2(nRow, "all_in_rt_cd") = ComGetObjValue(all_in_rt_cd);
		sheetObj.CellValue2(nRow, "curr_cd") = ComGetObjValue(curr_cd);
		
		var t_trns_rev_amt = ComGetObjValue(trns_rev_amt);
		t_trns_rev_amt = delComma_loc(t_trns_rev_amt);
		sheetObj.CellValue2(nRow, "trns_rev_amt") = t_trns_rev_amt;
		
		var t_non_trns_rev_amt = ComGetObjValue(non_trns_rev_amt);
		t_non_trns_rev_amt = delComma_loc(t_non_trns_rev_amt);
		sheetObj.CellValue2(nRow, "non_trns_rev_amt") = t_non_trns_rev_amt;

		var t_add_rev_amt = ComGetObjValue(add_rev_amt);
		t_add_rev_amt = delComma_loc(t_add_rev_amt);
		sheetObj.CellValue2(nRow, "add_rev_amt") = t_add_rev_amt;

		sheetObj.CellValue2(nRow, "add_rev_chg_cd") = ComGetObjValue(add_rev_chg_cd);
		
		var t_add_rev_amt2 = ComGetObjValue(add_rev_amt2);
		t_add_rev_amt2 = delComma_loc(t_add_rev_amt2);
		sheetObj.CellValue2(nRow, "add_rev_amt2") = t_add_rev_amt2;

		sheetObj.CellValue2(nRow, "add_rev_chg_cd2") = ComGetObjValue(add_rev_chg_cd2);
		
		
		var t_add_rev_amt3 = ComGetObjValue(add_rev_amt3);
		t_add_rev_amt3 = delComma_loc(t_add_rev_amt3);
		sheetObj.CellValue2(nRow, "add_rev_amt3") = t_add_rev_amt3;

		sheetObj.CellValue2(nRow, "add_rev_chg_cd3") = ComGetObjValue(add_rev_chg_cd3);
		
		sheetObj.CellValue2(nRow, "add_rev_rmk") = ComGetObjValue(add_rev_rmk);
		sheetObj.CellValue2(nRow, "vat_flg") = ComGetObjValue(vat_flg);

		sheetObj.CellValue2(nRow, "cxl_flg") = ComGetObjValue(cxl_flg);
		sheetObj.CellValue2(nRow, "cntr_tpsz_cd_old") = ComGetObjValue(cntr_tpsz_cd_old);
		sheetObj.CellValue2(nRow, "hlg_tp_cd_old") = ComGetObjValue(hlg_tp_cd_old);

		sheetObj.CellValue2(nRow, "rc_seq") = rc_seq.Text;
		sheetObj.CellValue2(nRow, "awk_cgo_seq") = ComGetObjValue(awk_cgo_seq);

		// -----------------------------------
		// 2-1) dg_seq Store
		setFormToData_Tro_dg_seq(prev_tro_seq);
	}

	sheetObj.Redraw = true; // <------------------
}

/** 
 * Tro-Detail 출력 ( HiddenSheet -> Sheet : Display ) 
 */
// function setAllDataToData_TroDtl(tro_seq, nRow_tro_sub_seq) {
function setAllDataToData_TroDtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	if (ValRow_gubun == null) {
		ValRow_gubun = "R"; // R:row, V:val
	}

	//-----------------------------------
	// 1) tro_seq Value에 해당하는 row로 초기화
	// var nRow = findRow_dtl(tro_seq, nRow_tro_sub_seq);
	var nRow = findRow_dtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun);

	if(nRow < 0) return;
	// -----------------------------------
	// 2) 출력
	with (formObj) {
		var sRow = sheetObj.FindCheckedRow("chk");
		var arrRow = sRow.split("|");
		var n_tro_sub_seq_maxcnt = arrRow.length - 1;

		ComSetObjValue(tro_sub_seq_currcnt, nRow_tro_sub_seq);
		ComSetObjValue(tro_sub_seq_maxcnt, n_tro_sub_seq_maxcnt);
		ComSetObjValue(tro_sub_seq, nullToBlank(sheetObj.CellValue(nRow, "tro_sub_seq")));
		dor_addr_tp_cd.Code2 = nullToBlank(sheetObj.CellValue(nRow, "dor_addr_tp_cd"));
		ComSetObjValue(dor_loc_cd, nullToBlank(sheetObj.CellValue(nRow, "dor_loc_cd")));
		ComSetObjValue(zn_cd, nullToBlank(sheetObj.CellValue(nRow, "zn_cd")));
		ComSetObjValue(lod_ref_no, nullToBlank(sheetObj.CellValue(nRow, "lod_ref_no")));
		ComSetObjValue(dor_pst_no, nullToBlank(sheetObj.CellValue(nRow, "dor_pst_no")));
		ComSetObjValue(dor_addr_1, nullToBlank(sheetObj.CellValue(nRow, "dor_addr_1")));
		ComSetObjValue(dor_addr_2, nullToBlank(sheetObj.CellValue(nRow, "dor_addr_2")));
		ComSetObjValue(dor_addr_3, ComLtrim(nullToBlank(sheetObj.CellValue(nRow, "dor_addr_3")),' '));
		ComSetObjValue(dor_addr_4, nullToBlank(sheetObj.CellValue(nRow, "dor_addr_4")));
		ComSetObjValue(arr_dt, nullToBlank(sheetObj.CellValue(nRow, "arr_dt")));
		ComSetObjValue(arr_dt_hhmi, nullToBlank(sheetObj.CellValue(nRow, "arr_dt_hhmi")));
		ComSetObjValue(cntc_pson_nm, nullToBlank(sheetObj.CellValue(nRow, "cntc_pson_nm")));
		ComSetObjValue(cntc_phn_no, nullToBlank(sheetObj.CellValue(nRow, "cntc_phn_no")));
		ComSetObjValue(cntc_eml, nullToBlank(sheetObj.CellValue(nRow, "cntc_eml")));
		// ComSetObjValue(cxl_flg, nullToBlank(sheetObj.CellValue(nRow, "cxl_flg")));
	}

	//-----------------------------------
	// 3) Color
	changeDtlColor();
}

/** 
 * Tro-Detail Temp 저장   ( Sheet -> HidenSheet : Store )
 */
function setDataToAllData_TroDtl(prev_tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	if (ValRow_gubun == null) {
		ValRow_gubun = "R"; // R:row, V:val
	}

	//-----------------------------------
	// 1) tro_seq Value에 해당하는 row로 초기화
	var nRow = findRow_dtl_curr(prev_tro_seq, nRow_tro_sub_seq, ValRow_gubun);

	// -----------------------------------
	// 2) 출력
	with (formObj) {
		sheetObj.CellValue2(nRow, "tro_seq") = prev_tro_seq;
		sheetObj.CellValue2(nRow, "tro_sub_seq") = ComGetObjValue(tro_sub_seq);
		sheetObj.CellValue2(nRow, "dor_addr_tp_cd") = dor_addr_tp_cd.Code;
		sheetObj.CellValue2(nRow, "dor_loc_cd") = ComGetObjValue(dor_loc_cd);
		sheetObj.CellValue2(nRow, "zn_cd") = ComGetObjValue(zn_cd);
		sheetObj.CellValue2(nRow, "lod_ref_no") = ComGetObjValue(lod_ref_no);
		sheetObj.CellValue2(nRow, "dor_pst_no") = ComGetObjValue(dor_pst_no);
		sheetObj.CellValue2(nRow, "dor_addr_1") = ComGetObjValue(dor_addr_1);
		sheetObj.CellValue2(nRow, "dor_addr_2") = ComGetObjValue(dor_addr_2);
		
		sheetObj.CellValue2(nRow, "dor_addr_3") = ComGetObjValue(dor_addr_3);
		sheetObj.CellValue2(nRow, "dor_addr_4") = ComGetObjValue(dor_addr_4);
		sheetObj.CellValue2(nRow, "arr_dt") = ComGetObjValue(arr_dt);
		sheetObj.CellValue2(nRow, "arr_dt_hhmi") = ComGetObjValue(arr_dt_hhmi);
		sheetObj.CellValue2(nRow, "cntc_pson_nm") = ComGetObjValue(cntc_pson_nm);
		sheetObj.CellValue2(nRow, "cntc_phn_no") = ComGetObjValue(cntc_phn_no);
		sheetObj.CellValue2(nRow, "cntc_eml") = ComGetObjValue(cntc_eml);
		// sheetObj.CellValue2(nRow, "cxl_flg") = ComGetObjValue(cxl_flg);
	}
}

//######################[4. Data Display/Store (Etc : Header/Combo)]##########################
/**
 * Header 출력(Booking 정보) 
 * : ComEtcDataToForm()함수대신, EtcData를 화면에 View
 */
function setEtcDataToForm_bkg(formObj, sheetObj) {
	//------------------------------
	// sheetEtcData -> Form
	// IBS_EtcDataToForm(formObj, sheetObj); //form의 나머지 default값이 초기화됨.
	with (formObj) 
	{
		por_nod_cd.value = nullToBlank(sheetObj.EtcData("por_nod_cd"));
		skd_dir_cd.value = nullToBlank(sheetObj.EtcData("skd_dir_cd"));
		cust_seq.value = nullToBlank(sheetObj.EtcData("cust_seq"));
		fd_grd_flg.value = nullToBlank(sheetObj.EtcData("fd_grd_flg"));
		spcl_hide_flg.value = nullToBlank(sheetObj.EtcData("spcl_hide_flg"));
		pol_code.value = nullToBlank(sheetObj.EtcData("pol_code"));
		bkg_sts_cd.value = nullToBlank(sheetObj.EtcData("bkg_sts_cd"));
		cmdt_nm.value = nullToBlank(sheetObj.EtcData("cmdt_nm"));
		// bl_tp_cd.value = nullToBlank(sheetObj.EtcData("bl_tp_cd"));
		bkg_no.value = nullToBlank(sheetObj.EtcData("bkg_no"));
		bl_no.value = nullToBlank(sheetObj.EtcData("bl_no"));
		cust_cnt_cd.value = nullToBlank(sheetObj.EtcData("cust_cnt_cd"));
		cust_nm.value = nullToBlank(sheetObj.EtcData("cust_nm"));
		bkg_rep_cmdt_cd.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_cd"));
		cmdt_cd.value = nullToBlank(sheetObj.EtcData("cmdt_cd"));
		wgt_ut_cd.value = nullToBlank(sheetObj.EtcData("wgt_ut_cd"));
		pickup_cy.value = nullToBlank(sheetObj.EtcData("pickup_cy"));
		conti_cd.value = nullToBlank(sheetObj.EtcData("conti_cd"));
		del_cd.value = nullToBlank(sheetObj.EtcData("del_cd"));
		act_wgt.value = nullToBlank(sheetObj.EtcData("act_wgt"));
		term.value = nullToBlank(sheetObj.EtcData("term"));
		por_cd.value = nullToBlank(sheetObj.EtcData("por_cd"));
		pod_cd.value = nullToBlank(sheetObj.EtcData("pod_cd"));
		skd_voy_no.value = nullToBlank(sheetObj.EtcData("skd_voy_no"));
		etb_dt.value = nullToBlank(sheetObj.EtcData("etb_dt"));
		bkg_rep_cmdt_nm.value = nullToBlank(sheetObj.EtcData("bkg_rep_cmdt_nm"));
		vsl_cd.value = nullToBlank(sheetObj.EtcData("vsl_cd"));
		bkg_cgo_tp_cd.value = nullToBlank(sheetObj.EtcData("bkg_cgo_tp_cd"));
		// rd_cgo_flg.value = nullToBlank(sheetObj.EtcData("rd_cgo_flg"));
		// bb_cgo_flg.value = nullToBlank(sheetObj.EtcData("bb_cgo_flg"));
		// dor_arr_dt.value = nullToBlank(sheetObj.EtcData("dor_arr_dt"));
		// dor_arr_dt_hhmi.value = nullToBlank(sheetObj.EtcData("dor_arr_dt_hhmi"));
		rtn_dt.value = nullToBlank(sheetObj.EtcData("rtn_dt"));
		rtn_dt_hhmi.value = nullToBlank(sheetObj.EtcData("rtn_dt_hhmi"));
		pkup_dt.value = nullToBlank(sheetObj.EtcData("pkup_dt"));
		pkup_dt_hhmi.value = nullToBlank(sheetObj.EtcData("pkup_dt_hhmi"));
		org_trns_mod_cd.value = nullToBlank(sheetObj.EtcData("org_trns_mod_cd"));
		dest_trns_mod_cd.value = nullToBlank(sheetObj.EtcData("dest_trns_mod_cd"));

		non_rt_sts_cd.value = nullToBlank(sheetObj.EtcData("non_rt_sts_cd"));
		aloc_sts_cd.value = nullToBlank(sheetObj.EtcData("aloc_sts_cd"));
		
		var boundCd = io_bnd_cd.value;
		if (boundCd != "") {
			io_bnd_cd_disp.value = boundCd + "/B";
		}

		var t_pkupCy = nullToBlank(sheetObj.EtcData("pickup_cy"));
		pickup_cy.value = t_pkupCy;
		var t_returnCy = nullToBlank(sheetObj.EtcData("return_cy"));
		return_cy.value = t_returnCy;

		if (boundCd == "I") {
			document.all.cyHeader.innerHTML = "P/UP CY";

			if (t_pkupCy.length >= 7) {
				formObj.cy1.value = t_pkupCy.substr(0, 5);
				formObj.cy2.value = t_pkupCy.substr(5, 2);
			} else {
				formObj.cy1.value = t_pkupCy;
				formObj.cy2.value = "";
			}
		} else {
			document.all.cyHeader.innerHTML = "Return CY";

			// Receiving Term : 'D'이외의 경우, 경고메세지 출력
			if ("D" != formObj.term.value) {
				ComShowCodeMessage("BKG02021"); // "Receiving Term is not 'D' !"
			}
			if (t_returnCy.length >= 7) {
				formObj.cy1.value = t_returnCy.substr(0, 5);
				formObj.cy2.value = t_returnCy.substr(5, 2);
			} else {
				formObj.cy1.value = t_returnCy;
				formObj.cy2.value = "";
			}
		}

		//------------------------------
		// hidden에 조회된 booking코드 보관
		oldBkgNo.value = nullToBlank(sheetObj.EtcData("bkg_no"));
		oldBlNo.value = nullToBlank(sheetObj.EtcData("bl_no"));
		ca_flg.value = nullToBlank(sheetObj.EtcData("ca_flg"));

		// checkbox 출력 재처리 -------------------------->
		var t_dcgo_flg = nullToBlank(sheetObj.EtcData("dcgo_flg"));
		var t_rc_flg = nullToBlank(sheetObj.EtcData("rc_flg"));
		var t_awk_cgo_flg = nullToBlank(sheetObj.EtcData("awk_cgo_flg"));
		var t_hcdg = nullToBlank(sheetObj.EtcData("hcdg"));
		dcgo_flg.checked = (t_dcgo_flg == "Y") ? true : false;
		rc_flag.checked = (t_rc_flg == "Y") ? true : false;
		awk_cgo_flg.checked = (t_awk_cgo_flg == "Y") ? true : false;
		hcdg.checked = (t_hcdg == "Y") ? true : false;
		// <---------------------------checkbox 출력 재처리

		// 버튼링크/버튼 출력처리 -------------------------->
		changeDisplayBtn("btn_Danger", t_dcgo_flg);
		changeDisplayBtn("btn_Reefer", t_rc_flg);
		changeDisplayBtn("btn_Awkward", t_awk_cgo_flg);
		// <----------------------------------------------

		// Search 완료후, 버튼 enabled
		if (formObj.oldBkgNo.value != "") {
			//ComEnableManyTd(true,  "btn_t2cRetrieve");
			ComEnableManyTd(true, 	"btn_t2cSave", "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cTRONotice", 
									"btn_t2cAddCNTR", "btn_t2cCopyCNTR", "btn_t2cDeleteCNTR", 
									"btn_t2cAdd", "btn_t2cDelete", 
									"btn_t2cPrevious", "btn_t2cNext");
		}
	}
}

/** 
 * Tro-Mastr dgco_seq 출력 : (multi콤보값) 
 */
function setDataToForm_Tro_dg_seq(tro_seq) {
	var objForm = document.form;
	var sheetObj = x_sheetObject4;
	var comboObj_1 = objForm.dcgo_seq;
	var cellId = "tro_dcgo_seq";

	var nRow = 0; // findRow
	var nStartRow = 0;
	var strCode_1 = ""; // code 초기화

	while (nRow > -1) {
		nRow = sheetObj.FindText("tro_seq", tro_seq, nStartRow);
		if (nRow > -1) {
			if (strCode_1 == "") {
				strCode_1 += sheetObj.CellValue(nRow, cellId);
			} else {
				strCode_1 += "|" + sheetObj.CellValue(nRow, cellId);
			}
		}
		nStartRow = nRow + 1;
	}

	//해당 tro_seq의 spcl_cgo_seq 를 각각 화면에 체크 출력 
	comboObj_1.Text2 = strCode_1;
}

/** 
 * Tro-Mastr dgco_seq Store_pre : (multi콤보값) 
 */
function setFormToData_Tro_dg_seq(prev_tro_seq) {
	var objForm = document.form;
	var sheetObj = x_sheetObject4;
	var comboObj_1 = objForm.dcgo_seq;

	// 1) prev_tro_seq 항목을 삭제 flag setting
	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	while (nRow > -1) 
	{
		nRow = sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
		if (nRow > -1) 
		{
			sheetObj.CellValue2(nRow, "del_chk") = 1;
			nStartRow = nRow + 1;
		}
	}

	//2) prev_tro_seq 항목을 삭제 : 체크선택된 행을 모두 화면에서 삭제(서버에도 않보냄)        
	var sRow = sheetObj.FindCheckedRow("del_chk");
	var arrRow = sRow.split("|");
	for ( var idx = arrRow.length - 2; idx >= 0; idx--) 
	{
		sheetObj.RowDelete(arrRow[idx], false);
	}

	//3) comboObj.Text를 parsing
	comboCodeToSheet(sheetObj, comboObj_1, prev_tro_seq);
}

/** 
 * Tro-Mastr spcl_cgo_seq Store : (multi콤보값) 
 */
function comboCodeToSheet(sheetObj, comboObj, prev_tro_seq) {
	var strText = comboObj.Text;
	if (strText != "") {
		var arrComboSeq = strText.split("|");
		for ( var i = 0; i < arrComboSeq.length; i++) {
			var nNewRow = sheetObj.DataInsert(-1); // 신규행 추가
			sheetObj.CellValue2(nNewRow, "tro_seq") = prev_tro_seq;
			sheetObj.CellValue2(nNewRow, "tro_dcgo_seq") = arrComboSeq[i];
		}
	}
}

//######################[5. Etc]##############################################################
// addRow prev MaxSeq get
function getPrevMaxTroSeq(sheetObj, nRow, colId) 
{
	var prevMaxTroSeq = 0;
	if (nRow > 1) {
		prevMaxTroSeq = sheetObj.CellValue(nRow - 1, colId);
	}
	return prevMaxTroSeq;
}

// addRow prev MaxSeq get 
function getPrevMaxTroSubSeq(sheetObj, tro_seq, colId) 
{
	var formObj = document.form;

	// sheetObj.CheckAll2("chk") = 0; //hidden chk : check clear
	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.CellValue(i, "chk") == 1) {
			sheetObj.CellValue2(i, "chk") = 0;
		}
	}

	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	while (nRow > -1) {
		nRow = sheetObj.FindText("tro_seq", tro_seq, nStartRow);
		if (nRow > -1) {
			sheetObj.CellValue2(nRow, "chk") = 1; // maxcount 용
			nStartRow = nRow + 1;
		}
	}

	//max sub_seq : get
	var prevMaxTroSubSeq = "0";
	var sRow = sheetObj.FindCheckedRow("chk");
	if (sRow != "") {
		var arrRow = sRow.split("|");
		for ( var idx = 0; idx <= arrRow.length - 2; idx++)
		{
			var currVal = sheetObj.CellValue(arrRow[idx], colId);
			if (parseInt(currVal) > parseInt(prevMaxTroSubSeq)) {
				prevMaxTroSubSeq = currVal;
			}
		}
	}

	return prevMaxTroSubSeq;
}

// dtl : tro_sub_seq_maxcount, nSRow_dtl get
function findRow_dtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	var nSRow = -1;
	if (ValRow_gubun == null) {
		ValRow_gubun = "R"; // R:row, V:val
	}

	sheetObj.ColumnSort("tro_seq|tro_sub_seq");

	// sheetObj.CheckAll2("chk") = 0; //hidden chk : check clear
	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.CellValue(i, "chk") == 1) {
			sheetObj.CellValue2(i, "chk") = 0;
		}
	}

	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	var nChkRowCnt = 0;
	while (nRow > -1) {
		nRow = sheetObj.FindText("tro_seq", tro_seq, nStartRow);
		if (nRow > -1) {
			sheetObj.CellValue2(nRow, "chk") = 1; // maxcount 용

			if (ValRow_gubun == "R") {
				nChkRowCnt++;
				if ((nSRow == -1) && (nChkRowCnt == nRow_tro_sub_seq)) {
					nSRow = nRow;
				}
			}

			nStartRow = nRow + 1;
		}
	}

	if (ValRow_gubun == "V") {
		nSRow = -1; // 초기화
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			var t_tro_seq = sheetObj.CellValue(i, "tro_seq");
			var t_tro_sub_seq = sheetObj.CellValue(i, "tro_sub_seq");
			if ((t_tro_seq == tro_seq) && (t_tro_sub_seq == nRow_tro_sub_seq)) {
				nSRow = i;
				break;
			}
		}
	}

	return nSRow;
}

// dtl : nSRow_dtl get
function findRow_dtl_curr(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	if (ValRow_gubun == null) {
		ValRow_gubun = "R"; // R:row, V:val
	}

	if (ValRow_gubun == "R") {
		sheetObj.ColumnSort("tro_seq|tro_sub_seq");

		var nCnt = 0;
		var nSRow = 0;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "tro_seq") == tro_seq) {
				nCnt++;
				if (nCnt == nRow_tro_sub_seq) {
					nSRow = i;
					break;
				}
			}
		}
	} else if (ValRow_gubun == "V") {
		var nSRow = 0;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			var t_tro_seq = sheetObj.CellValue(i, "tro_seq");
			var t_tro_sub_seq = sheetObj.CellValue(i, "tro_sub_seq");
			if ((t_tro_seq == tro_seq) && (t_tro_sub_seq == nRow_tro_sub_seq)) {
				nSRow = i;
				break;
			}
		}
	}

	return nSRow;
}

// dtl : tro_sub_seq_maxcount get
function findRow_dtl_max(tro_seq) {
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	var nSRow = -1;
	var nMaxCnt = 0;

	sheetObj.ColumnSort("tro_seq|tro_sub_seq");

	// sheetObj.CheckAll2("chk") = 0; //hidden chk : check clear
	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.CellValue(i, "chk") == 1) {
			sheetObj.CellValue2(i, "chk") = 0;
		}
	}

	var nRow = 0; // findRow
	var nStartRow = 0; // find Start Index
	while (nRow > -1) {
		nRow = sheetObj.FindText("tro_seq", tro_seq, nStartRow);
		if (nRow > -1) {
			sheetObj.CellValue2(nRow, "chk") = 1; // maxcount 용
			nStartRow = nRow + 1;
		}
	}

	var sRow = sheetObj.FindCheckedRow("chk");
	var arrRow = sRow.split("|");
	var nMaxCnt = arrRow.length - 1;

	return nMaxCnt;
}

/**
 * 멀티콤보의 Text에서, remark 내용분리하여 textarea에 add 
 */
function setAddRemarkText(comboObj, idx_cd, text, chk_gubun) {
	if (chk_gubun == "Y") {
		if (comboObj.CheckIndex(idx_cd)) { //멀티콤보 : checkbox 체크여부  
			if (comboObj) {
				var arrComboText = text.split("|"); // textarea에 remark추가
				var objRemark = document.form.spcl_instr_rmk;
				if (objRemark.value != "") {
					objRemark.value += " ";
				}
				objRemark.value += arrComboText[1];
			}
		}
	} else {
		var arrComboText = text.split("|"); // textarea에 remark추가
		if (!ComIsNull(arrComboText[1]) && !(arrComboText[1])) {
			var objRemark = document.form.spcl_instr_rmk;
			if (objRemark.value != "") {
				objRemark.value += " ";
			}
			objRemark.value += arrComboText[1];
		}
	}
}

/**
 * 존재여부 flag에 따라, 버튼 change 출력처리 
 */
function changeDisplayBtn(btnNm, link_flag) {
	if ("Y" == link_flag) {
		document.getElementById(btnNm).style.color = "#0000ff";
	} else {
		document.getElementById(btnNm).style.color = "";
	}
}
/**
 * Td 버튼 Link가능상태 체크용 
 */
function checkTdUnLink(btnNm) {
	return !(document.getElementById(btnNm).style.color == "#0000ff");
}

/** 
 * (All)콤보 배경색 변경 
 */
function setChangeAllComboBackColor() {
	var formObj = document.form;
	setComboBackColor(formObj.dcgo_seq);
	setComboBackColor(formObj.rc_seq);
	setComboBackColor(formObj.awk_cgo_seq);
}

/** 
 * (특정)콤보 배경색 변경 
 */
function setComboBackColor(comboObj) {
	if ("" != comboObj.Text) {
		comboObj.BackColor = "#ff0000";
		comboObj.fontcolor = "#ffffff";
	} else {
		comboObj.BackColor = "#ffffff";
		comboObj.fontcolor = "#606060";
	}
}

/**     
 *  지정한 cell의 구간만 editable속성을 일괄 변경 
 */
function changeAllCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
	for ( var i = nSCol; i <= nECol; i++) {
		sheetObj.CellEditable(nRow, i) = bFlag;
	}
}

/**
 * Td 버튼 Disabled 상태 체크용 
 */
function checkTdDisabled(srcName) {
	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
}

/**
 * img 버튼 Disabled 상태 체크용 : 이전 input tag check
 */
function checkInputDisabled(srcName) {
	return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
}

//######################[6. Check/Link/Popup]#################################################
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction, delFlg) {
	if (delFlg == null) {
		delFlg = "N";
	}

	with (formObj) 
	{
		switch (sAction) {
		case IBSEARCH:
			if (bkg_no.value == "" && bl_no.value == "") {
				//ComShowCodeMessage("BKG00255");
				// ComSetFocus(bkg_no);
				return false;
			}
			break;

		case IBSAVE:
			if (bkg_no.value != oldBkgNo.value) {
				ComShowCodeMessage("BKG00448");
				ComSetFocus(bkg_no);
				return false;
			}

			formObj.f_del_flg.value = delFlg; // event 구분 (delete:Y, cancel/frust:R, save:N)

			// 0) 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
			// if (delFlg == "N") {
				// if (!ComChkValid(formObj)) return false;
			// }

			// 1) Dtl : check
			// alert(delFlg);
			if (delFlg != 'CF') {
				if (!checkDtl(x_sheetObject3)) {
					return false;
				}
				//2) Master : check
				if (!checkMaster(x_sheetObject2)) {
					return false;
				}
			}
			if (delFlg == "N" && !ComShowCodeConfirm("COM12147", "")) {
				return false;
			} else if (delFlg == "C" && !ComShowCodeConfirm("COM12147", "Current Troseq")) {
				return false;
				// } else if (delFlg == "CF" && !ComShowCodeConfirm("COM12147", "(Cancel/Frustrate)")) {
				// return false;
			}

			for ( var i = 1; i <= x_sheetObject2.RowCount; i++) {
				if ("Y" != x_sheetObject2.RowStatus(i) && "R" != x_sheetObject2.RowStatus(i)) {
					if (!ComIsEmpty(x_sheetObject2.CellValue(i, "cntr_pkup_yd_cd")) && 2 != ComChkLenByByte(x_sheetObject2.CellValue(i, "cntr_pkup_yd_cd"), 7)) {
						ComShowCodeMessage("BKG01078", x_sheetObject2.CellValue(i, "cntr_pkup_yd_cd"));
						ComSetFocus(cntr_pkup_yd_cd);
						return false;
					}
					if (!ComIsEmpty(x_sheetObject2.CellValue(i, "cntr_rtn_yd_cd")) && 2 != ComChkLenByByte(x_sheetObject2.CellValue(i, "cntr_rtn_yd_cd"), 7)) {
						ComShowCodeMessage("BKG01078", x_sheetObject2.CellValue(i, "cntr_rtn_yd_cd"));
						ComSetFocus(cntr_rtn_yd_cd);
						return false;
					}
				}
			}	

			for ( var i = 1; i <= x_sheetObject3.RowCount; i++) {
				var emlArr = null;
				if(x_sheetObject3.CellValue(i, "cntc_eml") != ""){
					emlArr = x_sheetObject3.CellValue(i, "cntc_eml").split(";");
					for(var j = 0; j < emlArr.length; j++){
						if(emlArr[j].trim().length > 1 && !ComIsEmailAddr(emlArr[j])){
	    					ComShowCodeMessage("BKG40021" , emlArr[j]);
	    					return false;
						}
					}
	            }
			}
			break;
		}
	}
	return true;
}

/**
 * DATE항목 range validation check : message 존재여부 check 
 * getExistTodayChkMsgYn(t_all_dt, null, "M", 6);
 * getExistTodayChkMsgYn("200911301122", "2009-12-30", "M", 6);
 * sFlag : Y/M/D
 */
function getExistTodayChkMsgYn(t_all_dt, fromDt, sFlag, nVal) {
	var strExistMsgYn = "N";
	if (t_all_dt == "") 
	{
		return strExistMsgYn;
	}

	var toDay = ComGetNowInfo("ymd");
	var toHm = ComGetNowInfo("hm");
	if (nullToBlank(fromDt) == "") {
		fromDt = toDay;
	}
	var t_fromDt = ComReplaceStr(fromDt, "-", "") + ComReplaceStr(toHm, ":", "");
	var t_toDt = "";

	// 구간 check------->
	if (nullToBlank(sFlag) != "") {
		var toDt = ComGetDateAdd(fromDt, sFlag, nVal, "-", true); // 오늘+6개월후의 날짜
		t_toDt = ComReplaceStr(toDt, "-", "") + ComReplaceStr(toHm, ":", "");
	}
	//<----------------
	// pickup date관련 validation skip 2010.03.16
	if ( (t_fromDt != "" && t_all_dt <= t_fromDt) || 
		 (t_toDt != "" && t_all_dt > t_toDt) ) {
		strExistMsgYn = "Y";
	}

	return strExistMsgYn;
}

/**
 * Dtl Grid : 저장전, 필수입력등 일괄 체크  
 */
function checkDtl(sheetObj) {
	var formObj = document.form;
	var sheetObjMst = x_sheetObject2;
	var strCurrTroSeq = formObj.tro_seq.Text;
	var boundCd = formObj.io_bnd_cd.value;
	var delFlg = formObj.f_del_flg.value;
	var strMsgExistYn_arrDt = "N";

	var oldTroSeq = "";
	var t_tro_seq = "";
	var nTroSubCnt = 0;
	for ( var i = 1; i <= sheetObj.RowCount; i++) 
	{
		var t_tro_seq = sheetObj.CellValue(i, "tro_seq");
		var nSRow = sheetObjMst.FindText("tro_seq", t_tro_seq);
		if (i == 1) {
			oldTroSeq = t_tro_seq;
		}
		if (t_tro_seq == oldTroSeq) {
			nTroSubCnt++;
		} else {
			nTroSubCnt = 1;
		}
		var t_ibflag = sheetObj.CellValue(i, "ibflag");
		var t_cxl_flg = sheetObjMst.CellValue(nSRow, "cxl_flg");
		var t_cfm_flg = sheetObjMst.CellValue(nSRow, "cfm_flg");
		// var so_flg = (nullToBlank(sheetObjMst.CellValue(nSRow, "so_no")) == "")? "N" : "Y";

		if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
			 (delFlg == "Y" && (t_tro_seq != strCurrTroSeq)) || 
			 (t_cxl_flg == "Y") || 
			 (t_cfm_flg == "Y") || 
			 (t_ibflag == "D")) 
		{
			oldTroSeq = t_tro_seq;
			continue;
		}

		var t_cntr_pkup_dt = ComReplaceStr(nullToBlank(sheetObjMst.CellValue(nSRow, "cntr_pkup_dt")), "-", "");
		var t_cntr_pkup_dt_hhmi = ComReplaceStr(nullToBlank(sheetObjMst.CellValue(nSRow, "cntr_pkup_dt_hhmi")), ":", "");
		var t_cntr_rtn_dt = ComReplaceStr(nullToBlank(sheetObjMst.CellValue(nSRow, "cntr_rtn_dt")), "-", "");
		var t_cntr_rtn_dt_hhmi = ComReplaceStr(nullToBlank(sheetObjMst.CellValue(nSRow, "cntr_rtn_dt_hhmi")), ":", "");
		var t_dor_arr_dt = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "arr_dt")), "-", "");
		var t_dor_arr_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "arr_dt_hhmi")), ":", "");
		var t_pkup_dt = t_cntr_pkup_dt + t_cntr_pkup_dt_hhmi;
		var t_rtn_dt = t_cntr_rtn_dt + t_cntr_rtn_dt_hhmi;
		var t_arr_dt = t_dor_arr_dt + t_dor_arr_dt_hhmi;
		var etb_dt = formObj.etb_dt.value;

		// --------------------->
		var haulage = sheetObjMst.CellValue(nSRow, "hlg_tp_cd");
		if (haulage == "C") 
		{
			//dor_addr_tp_cd
			if (!chkMandatoryItem(sheetObj, i, "dor_addr_tp_cd", t_tro_seq, nTroSubCnt, "Type")) {
				return false;
			}
			//Location 
			if (!chkMandatoryItem(sheetObj, i, "dor_loc_cd", t_tro_seq, nTroSubCnt, "Location")) {
				return false;
			}
			if (!chkMandatoryItem(sheetObj, i, "zn_cd", t_tro_seq, nTroSubCnt, "Location Zone Code")) {
				return false;
			}
			//Zip
			if (!chkMandatoryItem(sheetObj, i, "dor_pst_no", t_tro_seq, nTroSubCnt, "Zip")) {
				return false;
			}
			//dor_addr_1 : company 
			if (!chkMandatoryItem(sheetObj, i, "dor_addr_1", t_tro_seq, nTroSubCnt, "Company")) {
				return false;
			}
			//dor_addr_2
			if (!chkMandatoryItem(sheetObj, i, "dor_addr_2", t_tro_seq, nTroSubCnt, "Address")) {
				return false;
			}

			//-------------->
			// Arrival dt
			// 01. 필수입력 check
			if (!chkMandatoryDate(sheetObj, i, "arr_dt", "arr_dt_hhmi", t_tro_seq, nTroSubCnt, "Door Arrival Date")) {
				return false;
			}

			//02. rtn_dt 보다 작거나같다 check [O/B 일때만] 
			if (boundCd == "O" && (t_arr_dt != "" && t_rtn_dt != "" && t_arr_dt > t_rtn_dt)) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + ", SubSeq:" + nTroSubCnt + "] Door Arrival Date", "or equal to the Return Date", "earlier");
				return false;
			}

			//03. etb_dt 보다 작거나같다 check [O/B 일때만] 
			if (boundCd == "O" && (t_arr_dt != "" && etb_dt != "" && t_arr_dt > etb_dt)) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + ", SubSeq:" + nTroSubCnt + "] Door Arrival Date", "or equal to the ETB Date", "earlier");
				return false;
			}

			//02-2. pkup_dt 보다 크거나같다 check [I/B 일때만] 
			if (boundCd == "I" && (t_arr_dt != "" && t_pkup_dt != "" && t_arr_dt < t_pkup_dt)) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + ", SubSeq:" + nTroSubCnt + "] Door Arrival Date", "or equal to the P/Up Date", "greater");
				return false;
			}

			//04. toDay check : warning msg 
			if (getExistTodayChkMsgYn(t_arr_dt, null, "M", 6) == "Y") {
				strMsgExistYn_arrDt = "Y";
			}
			//<-------------
		}
		oldTroSeq = t_tro_seq;
		// <---------------------------
		

	}
	if (strMsgExistYn_arrDt == "Y") {
		ComShowMessage("Door Arrival Date must be between the current date and the current date + 6 months ! \n" + 
					   "( today < input date <= today+6months )");
	}

	return true;
}

/**
 * Master Grid : 저장전, 필수입력등 일괄 체크  
 */
function checkMaster(sheetObj) {
	var formObj = document.form;
	var boundCd = formObj.io_bnd_cd.value;
	var strCurrTroSeq = formObj.tro_seq.Text;
	var delFlg = formObj.f_del_flg.value;
	var strMsgExistYn_pkupDt = "N";
	var strMsgExistYn_rtnDt = "N";

	for ( var i = 1; i <= sheetObj.RowCount; i++) 
	{
		var t_tro_seq = sheetObj.CellValue(i, "tro_seq");
		var t_cxl_flg = sheetObj.CellValue(i, "cxl_flg");
		var t_cfm_flg = sheetObj.CellValue(i, "cfm_flg");
		// var so_flg = (nullToBlank(sheetObj.CellValue(i, "so_no")) == "")? "N" : "Y";
		var t_ibflag = sheetObj.CellValue(i, "ibflag");

		// 01. cancel이 아니면서, saveSeq/request/confirm 대상건만 check 로직 수행함
		if ((delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
			(delFlg == "Y" && (t_tro_seq != strCurrTroSeq)) || 
			(t_cxl_flg == "Y") || 
			(t_cfm_flg == "Y") || 
			(t_ibflag == "D")) 
		{
			continue;
		}

		//------------------------>  
		var haulage = sheetObj.CellValue(i, "hlg_tp_cd");

		// TP/SZ
		if (!chkMandatoryItem(sheetObj, i, "cntr_tpsz_cd", t_tro_seq, null, "TP/SZ")) {
			return false;
		}

		if (haulage == "C") 
		{
			//Cargo Weight
			if (!chkMandatoryItem(sheetObj, i, "cgo_wgt", t_tro_seq, null, "Cargo Weight")) {
				return false;
			}
			//Commodity
			if (!chkMandatoryItem(sheetObj, i, "tro_cmdt_cd", t_tro_seq, null, "Commodity")) {
				return false;
			}
			//Rep Commodity
			if (!chkMandatoryItem(sheetObj, i, "rep_cmdt_cd", t_tro_seq, null, "Rep Commodity code")) {
				return false;
			}
			if (!chkMandatoryItem(sheetObj, i, "rep_cmdt_nm", t_tro_seq, null, "Rep Commodity name")) {
				return false;
			}
			//Trans Mode
			if (!chkMandatoryItem(sheetObj, i, "bkg_trsp_mzd_cd", t_tro_seq, null, "Trans Mode")) {
				return false;
			}

			if (boundCd == "I") {
				// P/Up CY 
				if (!chkMandatoryItem(sheetObj, i, "cntr_pkup_yd_cd", t_tro_seq, null, "P/Up CY")) {
					return false;
				}
				//P/Up Date
				if (!chkMandatoryDate(sheetObj, i, "cntr_pkup_dt", "cntr_pkup_dt_hhmi", t_tro_seq, null, "P/Up Date")) {
					return false;
				}
			} else {
				//Return CY
				if (!chkMandatoryItem(sheetObj, i, "cntr_rtn_yd_cd", t_tro_seq, null, "Return CY")) {
					return false;
				}
				//Return Date
				if (!chkMandatoryDate(sheetObj, i, "cntr_rtn_dt", "cntr_rtn_dt_hhmi", t_tro_seq, null, "Return Date")) {
					return false;
				}
			}

			//Revenue
			// var t_all_in_rt_cd = nullToBlank(sheetObj.CellValue(i, "all_in_rt_cd"));
			var t_curr_cd = nullToBlank(sheetObj.CellValue(i, "curr_cd"));
			var t_trns_rev_amt = nullToBlank(sheetObj.CellValue(i, "trns_rev_amt"));
			var t_non_trns_rev_amt = nullToBlank(sheetObj.CellValue(i, "non_trns_rev_amt"));
			var t_add_rev_amt = nullToBlank(sheetObj.CellValue(i, "add_rev_amt"));
			if (formObj.all_in_rt_cd.value != "Y" && t_curr_cd.trim() == "") {
				ComShowCodeMessage("COM12200", "[CNTR Seq:" + t_tro_seq + "] T1Revenue::Currency");
				return false;
			}
			// non manifest구분에 따른 컬럼 변경 2010.02.19 cateshin
			// if (t_all_in_rt_cd != "Y" && (t_trns_rev_amt.trim() == "" || t_trns_rev_amt.trim() == ".00")) {
			// ComShowCodeMessage("COM12200", "[CNTR Seq:"+t_tro_seq+"] T1Revenue::Revenue(IHC)");
			// return false;
			// }

			if (formObj.all_in_rt_cd.value == "" 
					|| ((formObj.all_in_rt_cd.value == "N" || formObj.all_in_rt_cd.value == "M") && (t_non_trns_rev_amt.trim() == "" || t_non_trns_rev_amt.trim() == ".00"))) {
				ComShowCodeMessage("COM12200", "[CNTR Seq:" + t_tro_seq + "] T1Revenue::Revenue(IHC)");
				return false;
			} 
			if (!checkExistDoor(t_tro_seq)) {
				ComShowCodeMessage("BKG02118", "[CNTR Seq:" + t_tro_seq + "]");
				return false;
			}

		} else if (haulage == "M") {
			if (boundCd == "I") {
				//Return CY
				if (!chkMandatoryItem(sheetObj, i, "cntr_rtn_yd_cd", t_tro_seq, null, "Return CY")) {
					return false;
				}
			} else {
				// P/Up CY 
				if (!chkMandatoryItem(sheetObj, i, "cntr_pkup_yd_cd", t_tro_seq, null, "P/Up CY")) {
					return false;
				}
			}
			//P/Up Date
			if (!chkMandatoryDate(sheetObj, i, "cntr_pkup_dt", "cntr_pkup_dt_hhmi", t_tro_seq, null, "P/Up Date")) {
				return false;
			}
			//Return Date
			if (!chkMandatoryDate(sheetObj, i, "cntr_rtn_dt", "cntr_rtn_dt_hhmi", t_tro_seq, null, "Return Date")) {
				return false;
			}
		}

		var t_cntr_pkup_dt = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "cntr_pkup_dt")), "-", "");
		var t_cntr_pkup_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "cntr_pkup_dt_hhmi")), ":", "");
		var t_cntr_rtn_dt = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "cntr_rtn_dt")), "-", "");
		var t_cntr_rtn_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(i, "cntr_rtn_dt_hhmi")), ":", "");
		var t_pkup_dt = t_cntr_pkup_dt + t_cntr_pkup_dt_hhmi;
		var t_rtn_dt = t_cntr_rtn_dt + t_cntr_rtn_dt_hhmi;
		var etb_dt = formObj.etb_dt.value;

		// -------------------
		// pkup date : check
		// 01. etb_dt 보다 작거나같다 check [O/B 일때만]
		if (boundCd == "O" && (t_pkup_dt != "" && etb_dt != "" && t_pkup_dt > etb_dt)) {
			ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + "] P/Up Date", "or equal to the ETB Date", "earlier");
			return false;
		}

		//02. toDay check : warning msg 
		if (getExistTodayChkMsgYn(t_pkup_dt, null, null, null) == "Y") {
			strMsgExistYn_pkupDt = "Y";
		}

		//-------------------
		// rtn date : check
		// 01. etb_dt 보다 작거나같다 check [O/B 일때만]
		if (boundCd == "O" && (t_rtn_dt != "" && etb_dt != "" && t_rtn_dt > etb_dt)) {
			ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + "] Return Date", "or equal to the ETB Date", "earlier");
			return false;
		}

		//02. pkup_dt 보다 작거나같다 check 
		if (t_rtn_dt != "" && t_pkup_dt != "" && t_rtn_dt < t_pkup_dt) {
			ComShowCodeMessage("COM12133", "[CNTR Seq:" + t_tro_seq + "] Return Date", "or equal to the P/Up Date", "greater");
			return false;
		}

		//03. toDay check : warning msg 
		if (getExistTodayChkMsgYn(t_rtn_dt, null, null, null) == "Y") {
			strMsgExistYn_rtnDt = "Y";
		}
		//<------------------------
		
		if("I"== document.form.io_bnd_cd.value) {
			doActionIBSheet(x_sheetObject2, formObj, COMMAND06);
		}
		if("I"== document.form.io_bnd_cd.value && !t1RevClickFlg && "Y"== glineRevAmtFlg){
			ComShowCodeMessage("BKG08299");
			return false;
		}
		
	}
	if (strMsgExistYn_pkupDt == "Y") {
		ComShowCodeMessage("COM12133", "P/Up Date", "the current date", "greater");
	}
	if (strMsgExistYn_rtnDt == "Y") {
		ComShowCodeMessage("COM12133", "Return Date", "the current date", "greater");
	}

	return true;
}

/**
 * master/dtl 필수입력메세지 처리
 */
function chkMandatoryItem(sheetObj, nRow, colId, currTroSeq, nTroSubCnt, caption) 
{
	var t_val = nullToBlank(sheetObj.CellValue(nRow, colId));
	if (t_val.trim() == "") {
		if (nTroSubCnt == null) {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + "] " + caption);
		} else {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + ", SubSeq:" + nTroSubCnt + "] " + caption);
		}
		return false;
	}

	return true;
}

/**
 * master/dtl DATE항목 필수입력메세지 처리
 */
function chkMandatoryDate(sheetObj, nRow, colId_d, colId_h, currTroSeq, nTroSubCnt, caption) 
{
	var t_dt = ComReplaceStr(nullToBlank(sheetObj.CellValue(nRow, colId_d)), "-", "");
	var t_dt_hhmi = ComReplaceStr(nullToBlank(sheetObj.CellValue(nRow, colId_h)), ":", "");
	var t_all_dt = t_dt + t_dt_hhmi;

	if (t_dt == "") {
		if (nTroSubCnt == null) {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + "] " + caption + "(day)");
		} else {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + ", SubSeq:" + nTroSubCnt + "] " + caption + "(day)");
		}
		return false;
	}
	if (t_dt_hhmi == "") {
		if (nTroSubCnt == null) {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + "] " + caption + "(hour)");
		} else {
			ComShowCodeMessage("COM12200", "[CNTR Seq:" + currTroSeq + ", SubSeq:" + nTroSubCnt + "] " + caption + "(hour)");
		}
		return false;
	}

	return true;
}

/**
 * Location 공통팝업창 선택값 setting 
 */
function getCOM_ENS_061_1(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	var nod_cd = aryPopupData[0][3];
	if (nod_cd.length == 7) {
		formObj.dor_loc_cd.value = nod_cd.substr(0, 5);
		formObj.zn_cd.value = nod_cd.substr(5, 7);
//		Address 항목을 1개로 병합 dorAddr3 + getSearchCountryName
//		formObj.dor_addr_3.value = aryPopupData[0][4];
		var dorAddr3 = aryPopupData[0][4];
		var countrycd = aryPopupData[0][10];
		if(dorAddr3.length > 0 ){
			dorAddr3 = dorAddr3 + " ";
		}
		getSearchCountryName(countrycd,dorAddr3);
	}
	doActionIBSheet(x_sheetObject2, formObj, COMMAND05); 
}
/**
 * MDM_COUNTRY 이름값을 얻어옴  setting 
 */
function getSearchCountryName(cnt_cd, dorAddr3) {
	var formObj = document.form;
	var param = "f_cmd=" + SEARCH01 + "&input_text=" + cnt_cd;
	var sXml = x_sheetObject2.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	if (output_text.length > 0) {
		formObj.dor_addr_4.value = dorAddr3 + output_text;
		formObj.dor_addr_3.value = ' ';
	} else {
		formObj.dor_addr_3.value = ' ';
		formObj.dor_addr_4.value = '';
	}
}
/**
 * Booking TRO_Multi Cancel/Frustrate 선택 팝업 호출. <br>
 */
function comBkgCallPop0703(callback_func, bkg_no, io_bnd_cd) {
	var param = "?bkg_no=" + bkg_no + "&io_bnd_cd=" + io_bnd_cd;
	ComOpenPopup('ESM_BKG_0703.do' + param, 702, 345, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', true);
}

/**
 * Booking TRO-Confirm 선택 팝업 호출. <br>
 */
function comBkgCallPop0906(callback_func, bkg_no, io_bnd_cd) {
	 
	var param = "?bkg_no=" + bkg_no + "&io_bnd_cd=" + io_bnd_cd;
	// modal창에 window 객체 추가 kbj
	ComOpenPopup('ESM_BKG_0906.do' + param, 702, 425, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', true, false,0,0,0,window);
}

/**
 * Booking TRO-Multi 선택 팝업 호출. <br>
 */
function comBkgCallPop0921(callback_func, bkg_no, cntr_no, boundCd) {
	var param = "?bkg_no=" + bkg_no + "&cntr_no=" + cntr_no + "&bound_cd=" + boundCd;
	ComOpenPopup('ESM_BKG_0921.do' + param, 322, 320, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', false);
}

///**
// * CntrNo 팝업창 선택값 setting
// */
//function setCntrNoCallBack(aryPopupData, row, col, sheetIdx) {
//	var formObj = document.form;
//	formObj.cntr_no.value = aryPopupData[0][2];
//
//	// cgo_wgt/tpsz 변경 : tpsz추가
//	doActionIBSheet(x_sheetObjMsg, formObj, COMMAND04);
//	doActionIBSheet(x_sheetObject2, formObj, COMMAND05); 
//}

function setT1RevenueCallBack(aryPopupData) {
	var formObj = document.form;
	// var t_bkg_no = nullToBlank(aryPopupData[0][1]);
	var t_t1_doc_flg = nullToBlank(aryPopupData[0][2]);
	var t_cstms_clr_no = nullToBlank(aryPopupData[0][3]);
	var t_all_in_rt_cd = nullToBlank(aryPopupData[0][4]);
	var t_curr_cd = nullToBlank(aryPopupData[0][5]);
	var t_trns_rev_amt = nullToBlank(aryPopupData[0][6]);
	var t_non_trns_rev_amt = nullToBlank(aryPopupData[0][7]);
	var t_add_rev_amt = nullToBlank(aryPopupData[0][8]);
	var t_add_rev_chg_cd = nullToBlank(aryPopupData[0][9]);
	var t_cxl_flg = nullToBlank(aryPopupData[0][10]);
	var t_vat_flg = nullToBlank(aryPopupData[0][11]);
	var t_add_rev_rmk = nullToBlank(aryPopupData[0][12]);
	var t_arb_rev_flg = nullToBlank(aryPopupData[0][15]);
	var t_add_rev_amt2 = nullToBlank(aryPopupData[0][16]);
	var t_add_rev_chg_cd2 = nullToBlank(aryPopupData[0][17]);
	var t_add_rev_amt3 = nullToBlank(aryPopupData[0][18]);
	var t_add_rev_chg_cd3 = nullToBlank(aryPopupData[0][19]);
	
	formObj.arb_rev_flg.value = t_arb_rev_flg;
	with (formObj) {
		t1_doc_flg.value = t_t1_doc_flg;
		cstms_clr_no.value = t_cstms_clr_no;
		all_in_rt_cd.value = t_all_in_rt_cd;
		curr_cd.value = t_curr_cd;
		trns_rev_amt.value = (t_trns_rev_amt == "Yes") ? "" : t_trns_rev_amt ;
		non_trns_rev_amt.value = t_non_trns_rev_amt;
		add_rev_amt.value = t_add_rev_amt;
		add_rev_chg_cd.value = t_add_rev_chg_cd;
		add_rev_amt2.value = t_add_rev_amt2;
		add_rev_chg_cd2.value = t_add_rev_chg_cd2;
		add_rev_amt3.value = t_add_rev_amt3;
		add_rev_chg_cd3.value = t_add_rev_chg_cd3;
		add_rev_rmk.value = t_add_rev_rmk;
		cxl_flg.value = t_cxl_flg;
		vat_flg.value = t_vat_flg;

		// 입력값이 존재하면(필수입력체크), red color change
		// if (t1_doc_flg.value == "Y") {
		setRevenueColor();
	}

//	setDataToForm_TroMst(x_oldTroSeq);
}

function setActCustCallBack(aryPopupData) {
	var formObj = document.form;
	// var p_loc_cd = nullToBlank(aryPopupData[0][1]);
	// var p_zn_cd = nullToBlank(aryPopupData[0][2]);
	var p_act_shpr_nm = nullToBlank(aryPopupData[0][3]);
	var p_cntc_pson_nm = nullToBlank(aryPopupData[0][7]);
	var p_cntc_phn_no = nullToBlank(aryPopupData[0][8]);
	var addr = nullToBlank(aryPopupData[0][10]);
	var p_dor_zip_id = nullToBlank(aryPopupData[0][11]);

	var nAddr = addr.length;
	var addr_1 = ""; // 50
	var addr_2 = ""; // 100
	var addr_3 = ""; // 150
	// var addr_4 = ""; //120

	if (nAddr > 100) {
		addr_1 = addr.substr(0, 50);
		addr_2 = addr.substr(50, 50);
		if (nAddr > 150) {
			addr_3 = addr.substr(100, 50);
		} else {
			addr_3 = addr.substr(100, nAddr);
		}
	} else if (nAddr > 50) {
		addr_1 = addr.substr(0, 50);
		addr_2 = addr.substr(50, nAddr);
	} else {
		addr_1 = addr.substr(0, nAddr);
	}

	//formObj.dor_loc_cd.value   = p_loc_cd; 
	// formObj.zn_cd.value = p_zn_cd;
	formObj.dor_addr_1.value = p_act_shpr_nm;
	formObj.dor_addr_2.value = addr_1;
	if(addr_2 != null && addr_2.length > 0){
		formObj.dor_addr_3.value = addr_2;
	}
//	formObj.dor_addr_4.value = addr_3;
	formObj.dor_pst_no.value = p_dor_zip_id;
	formObj.cntc_pson_nm.value = p_cntc_pson_nm;
	formObj.cntc_phn_no.value = p_cntc_phn_no;
}

function setCxlFrustCallBack(aryPopupData) {
	var formObj = document.form;
	pass_flg = true;
	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH); // 재조회
}

function setConfirmCallBack(aryPopupData) {
	var formObj = document.form;
	pass_flg = true;
	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH); // 재조회
}

function sendFaxEmail(fax, email, cmdt, receiver, other, cust_ntc, slct_cntr) {
	var formObj = document.form;
	formObj.fax_no.value = fax;
	formObj.eml.value = email;
	formObj.cmdt.value = cmdt;
	formObj.receiver.value = receiver;
	formObj.other.value = other;
	formObj.cust_ntc.value = cust_ntc;
	formObj.slct_cntr.value = slct_cntr;
	if (formObj.cntc_eml.value != email) {
		formObj.cntc_eml.value = email;
	}
	doActionIBSheet(x_sheetObjMsg, formObj, COMMAND02);
}

//#############################(7. Util/Etc)##################################################
function ComEnableObject_loc(obj, bEnable) 
{
	try {
		//disabled나 readOnly 설정하기
		switch (obj.type) {
		case "password":
		case "textarea":
		case "text":
			obj.readOnly = !bEnable;
			break;
		default:
			obj.disabled = !bEnable;
		}

		//설정에 따라 css 처리하기
		switch (obj.type) {
		case "select-one":
		case "text":
			if (bEnable) {
				//if (obj.className=="input2_1"){	      //회색바탕 - 필수입력
				if (obj.className == "input2_2") { //회색바탕 - 필수입력 (일반fontcolor)
					obj.className = "input1"; // 흰색바탕 - 필수입력
				} else if (obj.className == "input2") { //흰색 입력바탕
					obj.className = "input"; // 흰색바탕
				}
			} else {
				if (obj.className == "input1") { //필수 입력바탕
					// obj.className = "input2_1"; //회색바탕
					obj.className = "input2_2"; // 회색바탕
				} else if (obj.className == "input") { //흰색 입력바탕
					obj.className = "input2"; // 회색바탕
				}
			}
			break;

		case "textarea":
			if (bEnable) {
				obj.className = "textarea";
			} else {
				obj.className = "textarea2";
			}
			break;

		default:
			if (obj.tagName == "IMG" || obj.tagName == "img") {
				if (bEnable) {
					obj.style.cursor = "hand";
					obj.style.filter = "";
				} else {
					obj.style.cursor = "default";
					obj.style.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
				}
			}
		}
	} catch (err) { ComFuncErrMsg(err.message); }
}

function ComEnableManyObjects_loc(bEnable, objs) {
	try {
		var args = arguments;

		if (args.length < 2) return;
		for ( var i = 1; i < args.length; i++) {
			if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
		}
	} catch (err) { ComFuncErrMsg(err.message); }
}

function ComClassNameManyObjects_loc(p_className, objs) {
	try {
		var args = arguments;

		if (args.length < 2) return;
		for ( var i = 1; i < args.length; i++) {
			if (args[i].tagName != undefined) {
				args[i].className = p_className;
			}
		}
	} catch (err) { ComFuncErrMsg(err.message); }
}

/**
 * IBMultiCombo 일괄 Enable/Disable 처리  
 */
function ComEnableManyIBCombo(bEnable, bgColor, objs) {
	try {
		var args = arguments;

		if (args.length < 2) return;
		for ( var i = 1; i < args.length; i++) {
			if (args[i].tagName != undefined) {
				args[i].Enable = bEnable;
				if (bgColor.length > 0) {
					args[i].BackColor = bgColor;
				}
			}
		}
	} catch (err) { ComFuncErrMsg(err.message); }
}

/**
 * IBMultiCombo 일괄 Enable/Disable 처리  
 */
function ComEnableManyTd(bEnable, objs) {
	try {
		var args = arguments;

		if (args.length < 2) return;
		for ( var i = 1; i < args.length; i++) {
			if (bEnable == true) {
				ComBtnEnable(args[i]);
			} else {
				ComBtnDisable(args[i]);
			}
		}
	} catch (err) { ComFuncErrMsg(err.message); }
}

/*
 * 천단위 콤마(,) 제거
 * @author : Lee Nam Kyung
 */
function delComma_loc(txtVal) {
	var comma = /,/gi;
	var temp = txtVal;
	temp = temp.replace(comma, '');

	return temp;
}

/*
 * (-) 제거
 * @author : Lee Nam Kyung
 */
function delMask_loc(objTxt, gubun) {
	var mask = "";
	if (gubun == "-") {
		mask = /-/gi;
	} else if (gubun == ":") {
		mask = /:/gi;
	}
	var temp = objTxt.value;
	temp = temp.replace(mask, '');
	return temp;
}

function changeMask_hm_loc(objTxt, gubun) {
	var strTemp = delMask_loc(objTxt, gubun);
	var strHH = "";
	var strMI = "";
	var strgubun_1 = "";

	if (strTemp.length > 4) {
		strTemp = strTemp.substring(0, 4);
	}
	if (strTemp.length > 2) {
		strHH = strTemp.substring(0, 2);
		strgubun_1 = gubun;
		strMI = strTemp.substring(2, strTemp.length);
	} else {
		strHH = strTemp.substring(0, strTemp.length);
		strgubun_1 = "";
		strMI = "";
	}

	return strHH + strgubun_1 + strMI;
}

function changeMask_ymd_loc(objTxt, gubun) {
	var strTemp = delMask_loc(objTxt, gubun);
	var strYYYY = "";
	var strMM = "";
	var strDD = "";
	var strgubun_1 = "";
	var strgubun_2 = "";

	if (strTemp.length > 8) {
		strTemp = strTemp.substring(0, 8);
	}
	if (strTemp.length > 6) {
		strYYYY = strTemp.substring(0, 4);
		strgubun_1 = gubun;
		strMM = strTemp.substring(4, 6);
		strgubun_2 = gubun;
		strDD = strTemp.substring(6, strTemp.length);
	} else if (strTemp.length > 4) {
		strYYYY = strTemp.substring(0, 4);
		strgubun_1 = gubun;
		strMM = strTemp.substring(4, strTemp.length);
		strgubun_2 = "";
		strDD = "";
	} else {
		strYYYY = strTemp.substring(0, strTemp.length);
		strgubun_1 = "";
		strMM = "";
		strgubun_2 = "";
		strDD = "";
	}

	return strYYYY + strgubun_1 + strMM + strgubun_2 + strDD;
}

/*
 * 소숫점포함 콤마(,) 붙이기
 * pCnt     : 소숫점위 자릿수(콤마제외)
 * nAccount : 소숫점 아래 자릿수
 * @author : Lee Nam Kyung
 */
// function changeComma_loc(objTxt, term1, pCnt, nAccount)
function changeComma_loc(txtVal, term1, pCnt, nAccount) 
{
	var strResult = "";
	var comma = /,/gi;
	
	// var temp = objTxt.value;
	var temp = txtVal;
	temp = temp.replace(comma, '');
	temp = temp.replace('-', '');

	if (temp.indexOf('.') != -1) // 소수점이 있는 경우
	{
		var jum_up = temp.substring(0, temp.indexOf('.'));
		if (jum_up.length > pCnt) {
			jum_up = jum_up.substring(0, pCnt);
		}
		var jum_down = temp.substring(temp.indexOf('.') + 1, temp.length);
		if (jum_down.length > nAccount) {
			jum_down = jum_down.substring(0, nAccount);
		}

		jum_up = parseInt(jum_up) + '';
		if (jum_up == 'NaN') jum_up = '';

		if (term1 == 0) {
			//objTxt.value = Comma_Input(jum_up)+"."+jum_down;
			strResult = Comma_Input(jum_up) + "." + jum_down;
		} else {
			//objTxt.value = jum_up+'.'+jum_down;
			strResult = jum_up + '.' + jum_down;
		}
	} else {
		temp = parseInt(temp) + '';
		if (temp.length > pCnt) {
			temp = temp.substring(0, pCnt);
		}
		if (temp == 'NaN') temp = '';

		if (term1 == 0) {
			//objTxt.value = Comma_Input(temp);
			strResult = Comma_Input(temp);
		} else {
			//objTxt.value = temp;
			strResult = temp;
		}
	}

	return strResult;
}
/*
 * 천단위 콤마(,) 붙이기
 * @author : Lee Nam Kyung
 */
function Comma_Input(txtNumber) 
{
	var v = txtNumber;
	var vlen = v.length;
	var c = 1;
	var tmp = new Array();
	var comma = ',';
	var pas = "";

	for (i = vlen; i > -1; i--) {
		c++;
		if ((c % 3 == 0) && (i != vlen - 1)) {
			tmp[i] = v.charAt(i) + comma;
		} else {
			tmp[i] = v.charAt(i);
		}
	}
	for (i = 0; i < tmp.length; i++) {
		pas = pas + tmp[i];
	}

	return pas;
}

function callShowMessageAddCNTR() {
	ComShowCodeMessage("COM12130", "click event", "AddCNTR button");
}
function callShowMessageBiggerQty(strMsgTitle) {
	ComShowCodeMessage("COM12133", "[" + strMsgTitle + "] Total Qty", "or equal to the BKG Qty", "lesser");
}
/**
 * check_Enter  
 * 조회조건 에터키 이력시 조회
 * @param 
 * @return 
 */
function check_Enter() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (event.keyCode == 13) {
		if (event.srcElement.name == "bkg_no" || event.srcElement.name == "bl_no") {
			formObj.elements[srcName].value = srcValue.toUpperCase();
			pass_flg = true;
			doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
		}
	}
}
/**
 * HTML Control의 onblur이벤트 <br>
 **/
function obj_deactivate() {
	if (event.srcElement.name != "bkg_no" && event.srcElement.name != "bl_no") {
		if (eval('document.form.' + event.srcElement.name).value.length > 0) {
			ComSetObjValue(document.form.modify_flag, "Y");
		}
	} else {
		var formObj = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcValue = window.event.srcElement.getAttribute("value");
		formObj.elements[srcName].value = srcValue.toUpperCase();
	}
}
/**
 * searchData : 탭이동시 검색수행
 * bkgNo : 
 * 0079에서 실행
 */
function searchData(bkgNo) {
	var formObj = document.form;
	ComSetObjValue(formObj.bkg_no, bkgNo);
	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
}
/**
 * checkModify: 탭이동시 저장여부
 * param : 
 * 0079에서 실행
 */
function checkModify() {
	var formObj = document.form;
	if (ComGetObjValue(formObj.modify_flag) == "Y") {
		tab_alert_msg = false;
		if (!ComShowConfirm(ComGetMsg("BKG00350")))
			return false; // Are you sure to save the changes?
		doActionIBSheet(x_sheetObject2, formObj, IBSAVE);
	}
}
/**
 * setInquiryDisableButton 이벤트 호출 .<br>
 * ComBtnDisable 을 했을경우 비활성화
 * @param 
 */
function setInquiryDisableButton() {
	ComBtnDisable("btn_t2cSave");
	ComBtnDisable("btn_t2cSaveSeq");
	ComBtnDisable("btn_t2cConfirm");
	ComBtnDisable("btn_t2cCancelFrustrate");
	ComBtnDisable("btn_t2cTROCopy");
	ComBtnDisable("btn_t2cTRONotice");
	ComBtnDisable("btn_t2cAddCNTR");
	ComBtnDisable("btn_t2cCopyCNTR");

	ComBtnDisable("btn_t2cAdd");
	ComBtnDisable("btn_t2cDelete");
}
/**
 * Author: Du Phan
 * validateRemark method .<br>
 * ItemName: diff_rmk 
 * ItemType: TextArea
 * Purpose: Can input only 4000 characters at Remark
 * @param 
 */
function validateSpecialInstruction(item) {
	var lengthOfText = item.value.length;
	if (lengthOfText > 4000) 
	{
		ComShowCodeMessage("BKG01137", "4000");
		var stringAfterCut = item.value.substring(0, 4000);
		document.getElementById("spcl_instr_rmk").value = stringAfterCut;
	}
}

/**
 * Checking whether or not exists door type.
 * @param String tro_seq
 */
function checkExistDoor(tro_seq) {
	var bExistDoor = false;
	var dorAddrTpCd = "";
	var ibFlg = "";
	var strTroSubSeq = "";
	var arrTroSubSeq = null;

	strTroSubSeq = "" + ComFindAll(x_sheetObject3, "tro_seq", tro_seq);
	arrTroSubSeq = strTroSubSeq.split("|");

	for(j = 0 ; j < arrTroSubSeq.length ; j++) {
		dorAddrTpCd = x_sheetObject3.CellValue(arrTroSubSeq[j], "dor_addr_tp_cd");
		ibFlg = x_sheetObject3.RowStatus(arrTroSubSeq[j]);
		
		if(dorAddrTpCd == "D" && ibFlg != "D" ) {
			bExistDoor = true;
			break;
		}
	}

	return bExistDoor;
}

/**
 * Find door location.
 * @param boolean bFirst 
 */
function findDoorLoc(bFirst) {
	var locCd = "";
	var strResult = "" + ComFindAll(x_sheetObject3,"tro_seq", document.form.tro_seq.Code);
	var arrResult = strResult.split("|");
	var firstLocCd = "";
	var lastLocCd = "";
	var rn = 0;
	var troSeq = document.form.tro_seq.Code;
	var bFirstFind = true;

	for (var i = 0 ; i < arrResult.length ; i++) {
		rn = Number(arrResult[i]);
		
		if(x_sheetObject3.CellValue(rn, "dor_addr_tp_cd") == "D") {
			if(bFirstFind) {
				firstLocCd = x_sheetObject3.CellValue(rn, "dor_loc_cd");
				bFirstFind = false;
			}
			lastLocCd  = x_sheetObject3.CellValue(rn, "dor_loc_cd");
		}
	}
	
	if(bFirst) {
		locCd = firstLocCd;
	} else {
		locCd = lastLocCd;
	}

	return locCd;
}
 
function setRevenueColor(){
	
	var formObj = document.form;
	var strMandatoryFlg = "N";
	
	if (!ComIsEmpty(formObj.trns_rev_amt.value) 
			|| !ComIsEmpty(formObj.non_trns_rev_amt.value) 
			|| !ComIsEmpty(formObj.add_rev_amt.value)
			|| !ComIsEmpty(formObj.add_rev_amt2.value)
			|| !ComIsEmpty(formObj.add_rev_amt3.value)) {
		strMandatoryFlg = "Y";
	}
	if (strMandatoryFlg == "Y") {
		document.getElementById("btn_t2cT1Revenue").style.color = "#0000ff";
	} else {
		document.getElementById("btn_t2cT1Revenue").style.color = "";
	}
}
/**
 * get TRO SUB SEQ count except deleted.
 * @param String tro_seq
 */
function getTroSubSeqCount(tro_seq) {
	var rtn = 0;
	var formObj = document.form;
	var sheetObj = x_sheetObject3;
	
	var rows = "" + ComFindAll(sheetObj, "tro_seq", tro_seq);
	var arrRows = rows.split("|");
	
	for (var i = 0 ; i < arrRows.length; i++) {
		if(sheetObj.RowStatus(arrRows[i]) != "D") {
			rtn += 1;
		}
	}
	
	return rtn;
}

function ComboList(arrVal){
	var objCbo = comboObjects[1];
	objCbo.RemoveAll(); 

	var arr_value = arrVal[0].split("|");
	if (arr_value.length >1){
		for(var i = 0; i < arr_value.length; i++) {
			objCbo.InsertItem(i, arr_value[i],arr_value[i]); 
		 }
		for (var j = x_sheetObject2.HeaderRows  ; j < x_sheetObject2.Rows; j++) {
			if(document.tro_seq.Text!=x_sheetObject2.CellValue(j,"tro_seq")){
				if(x_sheetObject2.CellValue(j,"cntr_no")!=""
					&&( x_sheetObject2.CellValue(j,"cxl_flg") != "Y"
						 && x_sheetObject2.CellValue(j,"eur_trns_tp_cd") != "FR")){
					if(x_sheetObject2.CellValue(document.tro_seq.Text,"cxl_flg")!= "Y" && x_sheetObject2.CellValue(document.tro_seq.Text,"eur_trns_tp_cd") != "FR"){
						objCbo.DeleteItem(x_sheetObject2.CellValue(j,"cntr_no"));
					}
				}

			}
		}
	}
	
}
/* 개발자 작업  끝 */