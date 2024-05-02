/**
 * @fileoverview Off-Dock CY Invoice Creation & Correction 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_0004 : Off-Dock CY Invoice Creation & Correction 화면에서 사용하는 업무 스크립트를 정의한다.
 * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
 * 2011.11.21 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완(수정)
 * 2012.01.05 박성호 [CHM-201215476] [TES]  Invoice Issue Date & Receiving Date 관련 Logic 변경
 * 2015.08.24 김영신 [CHM-201536553] ODCY, MR Storage관련 로직 및 UI 변경 요청건 
 */
function ESD_TES_0004() { 
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/*  공통전역변수 ------------------------------------------------------------- */
// 위 기본정보, 아래 SHEET의 저장상태  
var save_conf_01 = false; // vndr_seq와 inv_no가 db에 저장된 상태
var confirm_done = false; // CONFIRM을 한 상태

var enable_sheet_01 = false;
var enable_sheet_02 = false;
var enable_sheet_03 = false;
var enable_sheet_04 = false;
var enable_sheet_05 = false;

var comboObjects = new Array();
var comboCnt = 0;

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;

var CNTR_TPSZ_CD;
var OT_A_LGS_COST_CD;
var OS_A_LGS_COST_CD;

var cntr_list_onchange_cnt = 1; // 1로 초기화
var cnt = 0;

var curr_chk = false;

var whld_tax_readonly_mode = true;

var def_curr_cd = '';

/**
 * Coincidence tab 에서 하단 total 등 summary 부분 숨기기 또는 보여주기 기능
 * @return
 */
function showSummary() {
	var div01 = document.all.SearchLayer01.style.display;
	var div02 = document.all.SearchLayer02.style.display;
	var obj = event.srcElement;
	if (div01 == "inline") {
		obj.src = "/hanjin/img/bu_prev01.gif";
		document.all.SearchLayer01.style.display = "none";
		document.all.SearchLayer02.style.display = "none";
	} else {
		obj.src = "/hanjin/img/bu_next01.gif";
		document.all.SearchLayer01.style.display = "inline";
		document.all.SearchLayer02.style.display = "inline";
	}
}

/**
 * [Hold] 체크박스 체크 여부에 따라 [hld_rmk] 값 세팅
 * @return
 */
function setHldRmk() {
	var formObj = document.form;
	if (formObj.hld_flg.checked == false) {
		formObj.hld_rmk.value = '';
	}
}


/**
 * agreement의 currency code와 so header의 currency code를 비교 확인.
 * @return
 */
function validateAgmtCurrCD() {
	tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

/**
 * calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치여부 체크
 * @return
 */
function isValidAgmtCurrCD() {
	// calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치하는지 여부를 파악...
	var formObj = document.form;
	// ComShowMessage(formObj.agmtCurrCd.value + ' / ' + formObj.curr_cd.Code);
	if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
		ComShowMessage(ComGetMsg('TES40039')); // ComShowMessage('so header의 currency code가 선택되지 않았습니다.');
		return false;
	}
	if (formObj.curr_cd.Code != main_hidden.CellValue(1, 'curr_cd')) {
		ComShowMessage(ComGetMsg('TES40040')); // ComShowMessage('so header의  currency code가 저장되지 않았습니다.');
		return false;
	}
	if (formObj.to_prd_dt.value == null || formObj.to_prd_dt.value.trim() == '') {
		ComShowMessage(ComGetMsg('TES40038')); // ComShowMessage('so header의 Period의 마지막값이 입력되지 않았습니다.');
		return false;
	}
	if (formObj.to_prd_dt.value != main_hidden.CellValue(1, 'to_prd_dt')) {
		ComShowMessage(ComGetMsg('TES40037')); // ComShowMessage('so header의 Period 마지막 날짜가 저장되지 않았습니다.');
		return false;
	}
	if (formObj.agmtCurrCd.value == null
			|| formObj.agmtCurrCd.value.trim() == '') {
		ComShowMessage(ComGetMsg('TES40030')); // ComShowMessage('agreement의 currency code를 가져올 수 없습니다.');
		tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
		return false;
	} else {
		if (formObj.agmtCurrCd.value.trim() != formObj.curr_cd.Code.trim()) {
			// ComShowMessage('(' + formObj.agmtCurrCd.value + '/' +
			// formObj.curr_cd.Code + ') Currency가 AGMT에 지정된 값과 다릅니다.'); //
			return false;
		}
	}
	return true;
}


/**
 * agreement의 status 가져오기
 * @return
 */
function validateAgmtSts() {
	tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|to_prd_dt', '');
}

/**
 * agreement status 의 유효성 검사.
 * @return {boolean} 
 */
function isValidAgmtSts() {
	/***************************************************************************
	 * --Cost Cal 시 Effective Date가 Inv Date(ATB or Issue Date) or To Period 에
	 * 해당하는 --Agreement를 List Up한 후 그중 최종 버전(ST)이 'C'이면 계산을 진행하고 'P' 상태이면
	 * --"Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오."라는 메시지를 띄우고 Rate 계산을 하지 않도록
	 * 함 --Agreement가 존재하지 않으면, 즉, EX가 0이면 "Agreement가 존재하지 않습니다.Agreement 담당자에게
	 * 문의하십시오." --라는 메시지를 띄우고 Rate 계산을 하지 않도록 함
	 **************************************************************************/
	var formObj = document.form;
	var tmp = '';
	tmp = formObj.agmtSts.value;
		
	if (tmp != undefined && tmp != null && tmp.trim() != '') {
		tmp = tmp.split('|');
		if (tmp.length > 0) {
			if (tmp[0] != null && !isNaN(tmp[0])) {
				if (parseInt(tmp[0]) > 0) {
					if (tmp[1] != undefined && tmp[1] != null) {
						if (tmp[1].trim() == 'C') {
							// 오케바리 : 계산을 진행
							return true;
						} else if (tmp[1].trim() == 'P') {
							ComShowMessage(ComGetMsg('TES40004')); // ComShowMessage('Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오.');
							return false;
						} else {
							ComShowMessage(ComGetMsg('TES40003')); // ComShowMessage('Agreement status가 조회되지 않습니다. Agreement 담당자에게 문의하십시오.');
							return false;
						}
					}
				} else if (parseInt(tmp[0]) == 0) {
					ComShowMessage(ComGetMsg('TES40005')); // ComShowMessage('Agreement가 존재하지 않습니다.Agreement 담당자에게 문의하십시오.');
					return false;
				} else {
					ComShowMessage(ComGetMsg('TES22030')); // ComShowMessage('[ERR-Agreement_01]');
					return false;
				}
			} else {
				ComShowMessage(ComGetMsg('TES22030')); // ComShowMessage('[ERR-Agreement_02]');
				return false;
			}
		} else {
			ComShowMessage(ComGetMsg('TES22030')); // ComShowMessage('[ERR-Agreement_03]');
			return false;
		}
	} else {
		ComShowMessage(ComGetMsg('TES22030')); // ComShowMessage('[ERR-Agreement_04]');
		return false;
	}
	return true;
}

 /**
  * [Error Inv. No.]유효성 체크
  * @return
  */
function validateErrInvNo() {
	var formObj = document.form;
	formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
	if (formObj.err_inv_no.value != null
			&& formObj.err_inv_no.value.trim() != '') {
		tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
	}
}

/**
 * [Cost OFC] 유효성 여부와 Cost OFC Code 가져오기
 * @return
 */
function validateCostOFC() {
	var formObj = document.form;
	if (formObj.cost_ofc_cd.value == null
			|| formObj.cost_ofc_cd.value.trim() == '') {
		formObj.cost_ofc_cd_hidden.value = '';
		formObj.is_valid_cost_ofc_cd.value = '';
		return false;
	}
	if (formObj.cost_ofc_cd.readOnly == false) {
		if ((formObj.cost_ofc_cd_hidden.value == null || formObj.cost_ofc_cd_hidden.value
				.trim() == '')
				|| formObj.cost_ofc_cd.value.trim() != formObj.cost_ofc_cd_hidden.value
						.trim()) {
			formObj.cost_ofc_cd_hidden.value = '';
			formObj.is_valid_cost_ofc_cd.value = '';
			tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
		}
	}
}

/**
 * [Yard Code] 유효성 여부와 Yard Code 가져오기
 * @return
 */
function validateYardCode() {
	var formObj = document.form;
	if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
		formObj.yd_cd_hidden.value = '';
		formObj.is_valid_yd_cd.value = '';
		return false;
	}
	if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value
			.trim() == '')
			|| formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
		formObj.is_valid_yd_cd.value = '';
		tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
	}
}

/**
 * [S/P Code] 유효성 여부와 S/P Name 가져오기
 * @return
 */
function validateVndrSeq() {
	var formObj = document.form;
	if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
		formObj.vndr_seq_hidden.value = '';
		formObj.is_valid_vndr_seq.value = '';
		return false;
	}
	if ( (formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '')
			|| formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
		formObj.vndr_seq_hidden.value = '';
		formObj.is_valid_vndr_seq.value = '';
		tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq','checkValidVndrCode');
	}
}

/**
 * [Cost OFC] 수정가능한 상태로 세팅하기
 * @return
 */
function setCostOfcReadOnlyFalse() {
	var formObj = document.form;
	if (confirm_done == false) {
		formObj.cost_ofc_cd.readOnly = false;
	}
	if (formObj.cost_ofc_cd.value != null && formObj.cost_ofc_cd.value.trim() != '') {
		formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;
		formObj.is_valid_cost_ofc_cd.value = 'Y';
	}
}

 /**
  * [Error Inv. No.] 유효성 여부에 따른 처리.
  * @return
  */
function checkValidErrInvNo() {
	var formObj = document.form;
	// ComShowMessage('checkValidErrInvNo -
	// is_valid_err_inv_no:'+formObj.is_valid_err_inv_no.value);
	if (formObj.is_valid_err_inv_no.value != undefined
			&& formObj.is_valid_err_inv_no.value != null
			&& formObj.is_valid_err_inv_no.value.trim() == 'Y') {
		// ComShowMessage('ERR_INV_NO 오케바리');
	} else {
		formObj.is_valid_err_inv_no.value = '';
		ComShowMessage(ComGetMsg('TES40058', 'ERR INV.NO')); // ComShowMessage('존재하지 않는 ERR INV.NO입니다.');
	}
}

/**
 * [Cost OFC] 유효성 여부에 따른 처리.
 * @return
 */
function checkValidCostOfc() {
	var formObj = document.form;
	var tmp = '';
	if (formObj.is_valid_cost_ofc_cd.value != undefined
			&& formObj.is_valid_cost_ofc_cd.value != null
			&& formObj.is_valid_cost_ofc_cd.value.trim() != '') {
		tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
		if (tmp.length > 0) {
			formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
			if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y') {
				if (tmp[1] != undefined && tmp[1] != null && tmp[1].trim() != '') {
					if (tmp[1].trim() != 'Y') {
						ComShowMessage(ComGetMsg('TES21036')); // ComShowMessage('CostOFC와 불일치하는 Yard Code입니다.');
						// formObj.yd_cd.focus();
					}
				} else {
					ComShowMessage(ComGetMsg('TES21037')); // ComShowMessage('CostOFC의 해당 Yard Code를 확인하는중 오류가 발생했습니다.');
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				ComShowMessage(ComGetMsg('TES21038')); // ComShowMessage('유효하지 않은 CostOFC입니다.');
			}
		} else {
			formObj.is_valid_cost_ofc_cd.value = '';
			ComShowMessage(ComGetMsg('TES21038')); // ComShowMessage('유효하지 않은 CostOFC입니다.');
		}
	} else {
		formObj.is_valid_cost_ofc_cd.value = '';
		ComShowMessage(ComGetMsg('TES21038')); // ComShowMessage('유효하지 않은 CostOFC입니다.');
	}
}

/**
* [Yard Code] 유효성 여부에 따른 처리 - NEW2 버튼 클릭 시에만 사용.
 * @return
 */
function checkValidYardCode2() {
	checkValidYardCode('NEW2');
}

/**
* [Yard Code] 유효성 여부에 따른 처리.
* @return
*/
function checkValidYardCode(type) {

	var formObj = document.form;
	var tmp = '';
	var tmp_yd_cd_hidden = '';
	
	if (formObj.is_valid_yd_cd.value != undefined
			&& formObj.is_valid_yd_cd.value != null
			&& formObj.is_valid_yd_cd.value.trim() != '') {
		tmp = formObj.is_valid_yd_cd.value.split('--');
		if (tmp.length > 0) {
			formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');

			if (formObj.is_valid_yd_cd.value != null
					&& formObj.is_valid_yd_cd.value == 'Y') {
				if (formObj.yd_cd.value != null
						&& formObj.yd_cd.value.trim() != ''
						&& formObj.yd_cd_hidden.value != formObj.yd_cd.value) {
					if (sheetObjects[5].RowCount > 0
							&& formObj.yd_cd.value.trim() != sheetObjects[5].CellValue(1, 'yd_cd').trim()
							&& (sheetObjects[0].RowCount > 0
									|| sheetObjects[1].RowCount > 0
									|| sheetObjects[2].RowCount > 0
									|| sheetObjects[3].RowCount > 0 || sheetObjects[4].RowCount > 0)) {
						// if (!confirm('Yard Code가 변경되었습니다. \n\n Coincidence, Discrepancy, Cost Calc.(SR by FD)와 Cost Calc.(SR by FP) Tab의 모든 Data를 삭제할까요?'))
						if (!confirm(ComGetMsg('TES23062'))) {
							formObj.yd_cd.value = formObj.yd_cd_hidden.value;
							return false;
						} else {
							// ComShowMessage('sheet들 다 지우고, yd, cost_ofc, calcStorageComboItems 수정하기');
							ComShowMessage(ComGetMsg('TES23004'));
							removeOffdockCYInvoice01();
							removeOffdockCYInvoice02();
						}
					}
				}

				tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
				formObj.yd_cd_hidden.value = formObj.yd_cd.value;
				formObj.yd_nm.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
				formObj.yd_chr_cd.value = (tmp[3] != undefined && tmp[3] != null ? tmp[3] : '');
				formObj.yd_fcty_tp_mrn_tml_flg.value = (tmp[4] != undefined && tmp[4] != null ? tmp[4] : '');
				formObj.yd_fcty_tp_cy_flg.value = (tmp[5] != undefined && tmp[5] != null ? tmp[5] : '');
				formObj.yd_fcty_tp_cfs_flg.value = (tmp[6] != undefined && tmp[6] != null ? tmp[6] : '');
				formObj.yd_fcty_tp_rail_rmp_flg.value = (tmp[7] != undefined && tmp[7] != null ? tmp[7] : '');
				formObj.yd_oshp_cd.value = (tmp[8] != undefined && tmp[8] != null ? tmp[8] : '');
				formObj.calcTerminalComboItems.value = (tmp[11] != undefined && tmp[11] != null ? tmp[11] : '');
				formObj.calcStorageComboItems.value = (tmp[12] != undefined && tmp[12] != null ? tmp[12] : '');
				formObj.calcTerminalComboItemsDesc.value = (tmp[16] != undefined && tmp[16] != null ? tmp[16] : '');
				formObj.calcStorageComboItemsDesc.value = (tmp[17] != undefined && tmp[17] != null ? tmp[17] : '');

				if (sheetObjects[5].RowCount == 0
						|| ((formObj.yd_cd != undefined
								&& formObj.yd_cd.value != null
								&& formObj.yd_cd.value != ''
								&& tmp_yd_cd_hidden != undefined
								&& tmp_yd_cd_hidden != null
								&& tmp_yd_cd_hidden != '' && formObj.yd_cd.value != tmp_yd_cd_hidden) || (formObj.cost_ofc_cd_hidden != undefined
								&& formObj.cost_ofc_cd_hidden.value != null
								&& formObj.cost_ofc_cd_hidden.value != ''
								&& formObj.cost_ofc_cd != undefined
								&& formObj.cost_ofc_cd.value != null
								&& formObj.cost_ofc_cd.value != '' && formObj.cost_ofc_cd_hidden.value != formObj.cost_ofc_cd.value))) {
					tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
				} else {
					// 조회만 하는 경우 기본으로 수행
					setCostOfcReadOnlyFalse();
				}
				
				if( type != undefined && type != null && type != '' && type == 'NEW2' ){
					tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("cost_ofc_cd|vndr_seq|inv_no"));
				} else {
					tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
				}
				
				if (sheetObjects[2].RowCount > 0) {
					setCalcTerminalManualCostCode(sheetObjects[2]);
				}
				if (sheetObjects[3].RowCount > 0) {
					setCalcStorageManualCostCode(sheetObjects[3]);
				}
				if (sheetObjects[4].RowCount > 0) {
					setCalcStorageManualCostCode(sheetObjects[4]);
				}
			} else {
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_nm.value = '';
				ComShowMessage(ComGetMsg('TES10066'));
			}
		} else {
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_nm.value = '';
			ComShowMessage(ComGetMsg('TES10066'));
		}
	} else {
		formObj.is_valid_yd_cd.value = '';
		formObj.yd_cd_hidden.value = '';
		formObj.yd_nm.value = '';
		ComShowMessage(ComGetMsg('TES10066'));
	}

}

/**
 * [S/P Code] 유효성 여부에 따른 처리.
 * @return
 */
function checkValidVndrCode() {
	var formObj = document.form;
	var tmp = '';
	if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
		tmp = formObj.is_valid_vndr_seq.value.split('|');
		if (tmp.length > 0) {
			formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
			if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
				formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
				formObj.vndr_seq_nm.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
				formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
				formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
				formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
				formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowMessage(ComGetMsg('TES21040')); // ComShowMessage('유효하지 않은 VNDR Code입니다.');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowMessage(ComGetMsg('TES21040')); // ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
	} else {
		formObj.is_valid_vndr_seq.value = '';
		formObj.vndr_seq_hidden.value = '';
		ComShowMessage(ComGetMsg('TES21040')); // ComShowMessage('유효하지 않은 VNDR
											// Code입니다.');
	}
}

/**
 * 공통코드 세팅
 * @return
 */
function setCommonCode() {
	var formObj = document.form;
	var tmp = '';
	if (formObj.tmp_common_code.value != undefined && formObj.tmp_common_code.value != null && formObj.tmp_common_code.value.trim() != '') {
		tmp = formObj.tmp_common_code.value.split('--');
		if (tmp.length > 0) {
			for ( var i = 0; i < tmp.length; i++) {
				tmp[i] = (tmp[i] != undefined && tmp[i] != null ? tmp[i] : '');
			}
			CNTR_TPSZ_CD = tmp[0];
			OT_A_LGS_COST_CD = tmp[3];
			OS_A_LGS_COST_CD = tmp[4];
		}
	}

	sheetObjects[1].InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);
	sheetObjects[2].InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);
	sheetObjects[2].InitDataCombo(0, "lgs_cost_cd", OT_A_LGS_COST_CD, OT_A_LGS_COST_CD);
	sheetObjects[3].InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);
	sheetObjects[3].InitDataCombo(0, "lgs_cost_cd", OS_A_LGS_COST_CD, OS_A_LGS_COST_CD);
	sheetObjects[4].InitDataCombo(0, "lgs_cost_cd", OS_A_LGS_COST_CD, OS_A_LGS_COST_CD);

	/*
	 * Summary에서 수정mode로 들어온 경우 반드시 TES공통CODE를 다 가져와서 SHEET의 COMBO에 초기화 한 다음에 자동
	 * 조회를 한다.
	 */
	var formObj = document.form;
	if (!ComIsNull(formObj.inv_no_tmp.value)) {
		formObj.inv_no.value = formObj.inv_no_tmp.value;
		formObj.vndr_seq.value = vndr_seq;
		retrieve('Y');
	}
}

//사용안함
//function setPeriodFromTo() {
//	/* from 한달전 ~ to 오늘 */
//	var formObj = document.form;
//	var to_dt = new String(formObj.DB_DATE.value).substring(0, 8);
//	var fr_dt;
//	if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8 && !isNaN(to_dt)) {
//		fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6, 8);
//		if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
//			if (fr_dt.substring(6, 8) > getEndDay(fr_dt.substring(0, 4), fr_dt .substring(4, 6))) {
//				fr_dt = fr_dt.substring(0, 6) + getEndDay(fr_dt.substring(0, 4), fr_dt.substring(4, 6));
//			}
//			formObj.fm_eff_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
//			formObj.to_eff_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
//		}
//	}
//}

/**
 * [S/P Code]와 [Inv. No.] readonly 속성 제어
 * @param {string}	READONLY_YN		Y or N
 * @return
 */
function setHeaderKeyValueReadonly(READONLY_YN) {

	var formObj = document.form;

	if (READONLY_YN != undefined && READONLY_YN != null
			&& READONLY_YN.trim() == 'Y') {
		formObj.vndr_seq.readOnly = true;
		formObj.inv_no.readOnly = true;
	} else {
		formObj.vndr_seq.readOnly = false;
		formObj.inv_no.readOnly = false;
	}
}

/**
 * [Period] readonly 속성 제어
 * @param READONLY_YN
 * @return
 */
function setPeriodReadonly(READONLY_YN) {

	var formObj = document.form;

	if (READONLY_YN != undefined && READONLY_YN != null && READONLY_YN.trim() == 'Y') {
		formObj.fm_prd_dt.readOnly = true;
		formObj.to_prd_dt.readOnly = true;
	} else {
		formObj.fm_prd_dt.readOnly = false;
		formObj.to_prd_dt.readOnly = false;
	}
}

/**
 * Calculated AMT 계산
 * @param 	{sheet}	sheetObj			ibsheet
 * @param 	{string}colnm				column name
 * @return	{int}	tot_inv_amt_val		Calculated AMT
 */
function getShtTotCalcAmt(sheetObj, colnm) {

	var tot_inv_amt_val = 0;

	// for (var i=1; i<sheetObj.Rows; i++)
	for ( var i = sheetObj.HeaderRows; i < (sheetObj.HeaderRows + sheetObj.RowCount); i++) {
		if (sheetObj.RowSumable(i) && sheetObj.CellValue(i, colnm) != null
				&& sheetObj.CellValue(i, colnm).trim() != ''
				&& sheetObj.CellValue(i, colnm) != undefined
				&& !isNaN(parseFloat(sheetObj.CellValue(i, colnm)))
				&& sheetObj.RowStatus(i) != 'D') {
			// tot_inv_amt_val = Number(tot_inv_amt_val) +
			// Number(parseFloat(sheetObj.CellValue(i,colnm)));
			tot_inv_amt_val = Number(tot_inv_amt_val)
					+ Number(sheetObj.CellValue(i, colnm));
			result1 = Math.round(Number(tot_inv_amt_val) * 1000) / 1000
					+ Math.round(Number(sheetObj.CellValue(i, colnm)) * 1000)
					/ 1000;
		}
	}
	tot_inv_amt_val = Math.round(Number(tot_inv_amt_val) * 1000) / 1000;
	tot_inv_amt_val = tes_chkAmtFmt(tot_inv_amt_val, document.form.curr_cd.Code);

	return tot_inv_amt_val;
}

function getShtTotGstAmt(sheetObj, colnm) {
	
	var tot_gst_amt = 0;
	
	for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++) {
		if (sheetObj.RowSumable(i) && sheetObj.CellValue(i,colnm)!=null && sheetObj.CellValue(i,colnm).trim()!='' && 
			sheetObj.CellValue(i,colnm)!=undefined && !isNaN(parseFloat(sheetObj.CellValue(i,colnm))) && sheetObj.RowStatus(i)!='D') {
			tot_gst_amt = Number(tot_gst_amt) + Number(sheetObj.CellValue(i,colnm));
		}
	}	
	return tes_chkAmtFmt(tot_gst_amt.toFixed(2),document.form.curr_cd.Code);

}
//사용안함
//function matchManualStorageCostCode(src) {
//	if (src == undefined || src == null || src.trim() == '') {
//		return false;
//	}
//	var formObj = document.form;
//	var arr_cost_cd;
//	if (formObj.calcStorageComboItems.value != null
//			&& formObj.calcStorageComboItems.value.trim() != '') {
//		arr_cost_cd = formObj.calcStorageComboItems.value.split('|');
//	}
//	for ( var i = 0; arr_cost_cd != null && i < arr_cost_cd.length; i++) {
//		if (src == arr_cost_cd[i]) {
//			return true; // 하나라도 발견되면 바로 return...
//		}
//	}
//	return false;
//}
//
//function getShtColMaxSeq(sheetObj, colnm) {
//
//	var curr_max_seq = 0;
//
//	for (i = 1; i < sheetObj.Rows; i++) // 제목은 제외
//	{
//		if (sheetObj.CellValue(i, colnm) != null
//				&& sheetObj.CellValue(i, colnm).trim() != ''
//				&& sheetObj.CellValue(i, colnm) != undefined
//				&& !isNaN(parseInt(sheetObj.CellValue(i, colnm), 10))
//				&& parseInt(sheetObj.CellValue(i, colnm), 10) > curr_max_seq
//				&& parseInt(sheetObj.CellValue(i, colnm), 10) > 0) {
//			curr_max_seq = parseInt(sheetObj.CellValue(i, colnm), 10);
//		}
//	}
//
//	return curr_max_seq;
//}
//
//function setShtStatus(sheetObj, sts_colnm, to_sts) {
//	if (sheetObj.RowCount > 0) {
//		if (sts_colnm != null && sts_colnm != undefined
//				&& sts_colnm.trim() != '' && to_sts != null
//				&& to_sts != undefined && to_sts.trim() != '') {
//			for (i = 1; i < sheetObj.Rows; i++) // 제목은 제외
//			{
//				sheetObj.CellValue2(i, sts_colnm) = to_sts;
//			}
//		}
//	}
//}
//
//function setShtStatus2(sheetObj, to_sts) {
//	if (sheetObj.RowCount > 0) {
//		if (to_sts != null && to_sts != undefined && to_sts.trim() != '') {
//			for (i = 1; i < sheetObj.Rows; i++) // 제목은 제외
//			{
//				sheetObj.RowStatus(i) = to_sts;
//			}
//		}
//	}
//}
//
//function setShtEditable(sheetObj, sts_colnm, to_sts) {
//	// setShtEditable(sheetObj, 'COL_NM', 'Y')
//	if (sts_colnm != null && sts_colnm != undefined && sts_colnm.trim() != ''
//			&& to_sts != null && to_sts != undefined && to_sts.trim() != '') {
//		for (i = 1; i < sheetObj.Rows; i++) // 제목은 제외
//		{
//			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'M') {
//				sheetObj.CellEditable(i, sts_colnm) = (to_sts != null
//						&& to_sts == 'Y' ? false : true);
//			}
//		}
//	}
//}

 /**
  * Cost Calc. tab 들에서 Row Add 할때 각 셀의 Editable 설정.
  * @param {sheet}		sheetObj	컨트롤 하고자 하는 ibsheet
  * @param {int}		rownum		add 된 row number
  * @param {string}		colnms		column name
  * @param {string}		to_sts		Y or N
  * @param {string}		EXCEPTION	
  * @return
  */
function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
	// 수동입력 rowadd를 할때마다 실행..
	if (rownum == null || rownum == undefined || colnms == null
			|| colnms == undefined || to_sts == null || to_sts == undefined) {
		return false;
	}

	var arr_colnms = colnms.split('|');

	for ( var i = 0; i < arr_colnms.length; i++) {
		if (EXCEPTION != undefined && EXCEPTION == 'EXCEPTION') {
			sheetObj.CellEditable(rownum, arr_colnms[i]) = (to_sts != null && to_sts == 'Y' ? true : false);
		} else {
			if (sheetObj.CellValue(rownum, 'calc_tp_cd') == 'M') {
				sheetObj.CellEditable(rownum, arr_colnms[i]) = (to_sts != null && to_sts == 'Y' ? true : false);
			}
		}
	}
}

/**
 * TPB popup창에서 입력이 완료되면 해당 row를 disable한다.
 * @param {sheet}	sheetObj	컨트롤 하고자 하는 ibsheet
 * @param {int}		rownum		add 된 row number
 * @param {string}	colnms		column name
 * @param {string}	to_sts		Y or N
 * @return
 */
function setShtCellsEditable2(sheetObj, rownum, colnms, to_sts) {
	if (rownum == null || rownum == undefined || colnms == null
			|| colnms == undefined || to_sts == null || to_sts == undefined) {
		return false;
	}

	var arr_colnms = colnms.split('|');

	for ( var i = 0; arr_colnms != null && i < arr_colnms.length; i++) {
		sheetObj.CellEditable(rownum, arr_colnms[i]) = (to_sts != null
				&& to_sts == 'Y' ? true : false);
	}
}

/**
 * COIN sheet의 data가 채워지면 sheet하단에 통계항목을 계산하여 설정
 * @return
 */
function setCoinShtStat() {

	// COIN sheet의 data가 채워지면 sheet하단에 통계항목을 계산하여 설정...

	var formObj = document.form;

	// 초기화
	formObj.sht_01_ttl_box.value = 0;
	formObj.sht_01_full.value = 0;
	formObj.sht_01_mt.value = 0;
	formObj.sht_01_ts_same_yard.value = 0;
	formObj.sht_01_D2.value = 0;
	formObj.sht_01_D2.value = 0;
	formObj.sht_01_D4.value = 0;
	formObj.sht_01_D5.value = 0;
	formObj.sht_01_D7.value = 0;
	formObj.sht_01_D8.value = 0;
	formObj.sht_01_D9.value = 0;
	formObj.sht_01_DW.value = 0;
	formObj.sht_01_DX.value = 0;
	formObj.sht_01_R2.value = 0;
	formObj.sht_01_R4.value = 0;
	formObj.sht_01_R5.value = 0;
	formObj.sht_01_R7.value = 0;
	formObj.sht_01_R8.value = 0;
	formObj.sht_01_R9.value = 0;			
	formObj.sht_01_F2.value = 0;
	formObj.sht_01_F4.value = 0;
	formObj.sht_01_F5.value = 0;
	formObj.sht_01_O2.value = 0;
	formObj.sht_01_O4.value = 0;
	formObj.sht_01_O5.value = 0;
	formObj.sht_01_O7.value = 0;
	formObj.sht_01_S2.value = 0;
	formObj.sht_01_S4.value = 0;
	formObj.sht_01_T2.value = 0;
	formObj.sht_01_T4.value = 0;
	formObj.sht_01_A2.value = 0;
	formObj.sht_01_A4.value = 0;
	formObj.sht_01_A5.value = 0;
	formObj.sht_01_P2.value = 0;
	formObj.sht_01_P4.value = 0;
	//formObj.sht_01_Z2.value = 0;
	//formObj.sht_01_Z4.value = 0;
	formObj.sht_01_C2.value = 0;
	formObj.sht_01_C4.value = 0;

	// 계산하여 설정-----------------------------------------------------------
	formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount; // 총수

	for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
		if (sheetObjects[0].CellValue(i, "cntr_sty_cd") != undefined
				&& sheetObjects[0].CellValue(i, "cntr_sty_cd") != null
				&& sheetObjects[0].CellValue(i, "cntr_sty_cd").trim() != '') {
			try {
				with (formObj) {
					if (sheetObjects[0].CellValue(i, "cntr_sty_cd") == 'F') {
						sht_01_full.value++;
					} else if (sheetObjects[0].CellValue(i, "cntr_sty_cd") == 'M') {
						sht_01_mt.value++;
					}
				}
			} catch (e) {
				// ComShowMessage(e); //여길 그냥 통과해야 한다..
			}
		}
		if (sheetObjects[0].CellValue(i, "sam_locl_ts_ind_cd") != undefined
				&& sheetObjects[0].CellValue(i, "sam_locl_ts_ind_cd") != null
				&& sheetObjects[0].CellValue(i, "sam_locl_ts_ind_cd").trim() != '') {
			try {
				with (formObj) {
					if (sheetObjects[0].CellValue(i, "sam_locl_ts_ind_cd") == 'T') {
						sht_01_ts_same_yard.value++;
					}
				}
			} catch (e) {
				// ComShowMessage(e); //여길 그냥 통과해야 한다..
			}
		}
	}

	// Type/Size code별 갯수 구하기
	for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
		if (sheetObjects[0].CellValue(i, "cntr_tpsz_cd") != undefined
				&& sheetObjects[0].CellValue(i, "cntr_tpsz_cd") != null
				&& sheetObjects[0].CellValue(i, "cntr_tpsz_cd").trim() != '') {
			try {
				with (formObj) {
					eval('sht_01_' + sheetObjects[0].CellValue(i, "cntr_tpsz_cd")).value++;
				}
			} catch (e) {
				// ComShowMessage(e); //오류시에도 여길 그냥 통과해야 한다..
			}
		}
	}

}

/**
 * COIN, DSCP, CALC.TMNL, CALC.ByDay sheet의 data를 삭제할 때 'sht_01'로 시작하는 컴포넌트의 값 삭제
 * @return
 */
function initCoinShtStat() {

	var formObj = document.form;
	var numOfEle = formObj.elements.length;
	for ( var i = 0; i < numOfEle; i++) {
		if (formObj.elements[i].name.length >= 6 && formObj.elements[i].name.substring(0, 6) == 'sht_01') {
			formObj.elements[i].value = '';
		}
	}
}

/**
 * 사용하는곳 안보임(2010-02-08)
 * @return
 */
//function getCalcCostSts() {
//
//	var formObj = document.form;
//
//	formObj.f_cmd.value = SEARCH01;
//	var savexml = sheetObjects[6].GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4'));
//	sheetObjects[6].LoadSaveXml(savexml, true);
//}

/**
 * [Total AMT] 세팅
 * total_amt = ttl_inv_amt + vat_amt - whld_tax_amt (readOnly)
 * @return
 */
function set_total_amount() {
	var formObj = document.form;
	var ttl_inv_amt = 0;
	var vat_amt = 0;
	var whld_tax_amt = 0;

	if (formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined) {
		ttl_inv_amt = ComTrimAll( formObj.ttl_inv_amt.value, "," );
	}
	if (formObj.vat_amt.value != '' || formObj.vat_amt != undefined) {
		vat_amt = ComTrimAll( formObj.vat_amt.value, "," );
	}
	if (formObj.whld_tax_amt.value != '' || formObj.vat_amt != undefined) {
		whld_tax_amt = ComTrimAll( formObj.whld_tax_amt.value, "," );
	}

	// 2008-09-19 소수점 계산 버그로 *100 /100 추가
	// formObj.total_amt.value = tes_chkAmtFmt( (Number(ttl_inv_amt) +
	// Number(vat_amt) - Number(whld_tax_amt)), formObj.curr_cd.Code);
	// formObj.total_amt.value = tes_chkAmtFmt( (Number(ttl_inv_amt*100) +
	// Number(vat_amt*100) - Number(whld_tax_amt*100))/100,
	// formObj.curr_cd.Code);
	// 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
	formObj.total_amt.value = tes_chkAmtFmt(tes_round((Number(ttl_inv_amt)
			+ Number(vat_amt) - Number(whld_tax_amt)), 2), formObj.curr_cd.Code);
}

function set_vat_amount(){
    var formObj = document.form;
    var ttl_inv_amt = 0;
    var whld_tax_amt = 0;
    
    var ida_cgst_amt = 0;
    var ida_sgst_amt = 0;
    var ida_igst_amt = 0;
    var ida_ugst_amt = 0;

    if(formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined){
        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
    }
    if(formObj.whld_tax_amt.value != '' || formObj.whld_tax_amt != undefined){
        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
    }
    if(formObj.ida_cgst_amt.value !== '' || formObj.ida_cgst_amt != undefined){
    	ida_cgst_amt = ComTrimAll(formObj.ida_cgst_amt.value, ",");
    }
    if(formObj.ida_sgst_amt.value !== '' || formObj.ida_sgst_amt != undefined){
    	ida_sgst_amt = ComTrimAll(formObj.ida_sgst_amt.value, ",");
    }
    if(formObj.ida_igst_amt.value !== '' || formObj.ida_igst_amt != undefined){
    	ida_igst_amt = ComTrimAll(formObj.ida_igst_amt.value, ",");
    }
    if(formObj.ida_ugst_amt.value !== '' || formObj.ida_ugst_amt != undefined){
    	ida_ugst_amt = ComTrimAll(formObj.ida_ugst_amt.value, ",");
    }
    
    formObj.vat_amt.value = tes_chkAmtFmt( tes_round( (Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt)), 2 ), formObj.curr_cd.Code );
    formObj.total_amt.value = tes_chkAmtFmt( tes_round( (Number(ttl_inv_amt) + Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt) - Number(whld_tax_amt)), 2 ), formObj.curr_cd.Code );
    
}

/**
 * reject 시 호출되는 함수
 * @return
 */
function rjctInv() {

	var formObj = document.form;

	formObj.tml_inv_rjct_sts_cd.value = 'RJ';
	formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm('RJ');

	doActionRejectHiddenSheet(sheetObjects[6], formObj, IBSAVE);
}

/**
 * 특정 element를 수정 가능 상태로 설정
 * @return
 */
function enableForm() {

	var formObj = document.form;

	setHeaderKeyValueReadonly('N');
	
	formObj.yd_cd.readOnly = false;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = false;
	formObj.to_prd_dt.readOnly = false;
	formObj.iss_dt.readOnly = false;
	formObj.ttl_inv_amt.readOnly = false;
	formObj.rcv_dt.readOnly = false;
	
	formObj.vat_amt.readOnly = false;
	formObj.err_inv_no.readOnly = false;
	comboObjects[0].Enable = true;
	checkWhldTaxAmtMode();
	setElementDiabled('checkbox', 'hld_flg', 'N');
	setElementDiabled('checkbox', 'TMNL', 'N');
	setElementDiabled('checkbox', 'StorageDay', 'N');
	setElementDiabled('radio', 'CostCalcMethod', 'N');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'N');}
		
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
	
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = false;
		formObj.ida_cgst_amt.readOnly = false;
		formObj.ida_sgst_amt.readOnly = false;
		formObj.ida_igst_amt.readOnly = false;
		formObj.ida_ugst_amt.readOnly = false;
	}
}

 /**
  * 특정 element를 수정 불가능 상태로 설정 
  * @return
  */
function disableForm() {

	var formObj = document.form;

	setHeaderKeyValueReadonly('N'); // KEY값: VNDR_SEQ와 INV_NO는 살려둔다.
	formObj.reset();
	formObj.yd_cd.readOnly = true;
	formObj.vndr_seq_nm.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;
	comboObjects[0].Enable = false;
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
	
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = true;
		formObj.ida_cgst_amt.readOnly = true;
		formObj.ida_sgst_amt.readOnly = true;
		formObj.ida_igst_amt.readOnly = true;
		formObj.ida_ugst_amt.readOnly = true;
		
		tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt"));
	}
}

/**
 * 특정 element를 수정 가능 상태로 설정 
 * @param {string}	YN_KEEP_KEY_VALUE	reset후에 재설정 여부
 * @return
 */
function enablePage(YN_KEEP_KEY_VALUE) {

	var formObj = document.form;

//	var temp_vndr_seq = '';
//	var temp_vndr_seq_nm = '';
//	var temp_is_valid_vndr_seq = '';
//	var temp_yd_cd = '';
//	var temp_inv_no = '';
//	var temp_curr_cd = '';
//	var temp_fm_prd_dt = '';
//	var temp_to_prd_dt = '';
//	var temp_iss_dt = '';
//	var temp_rcv_dt = '';
//
//	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null
//			&& YN_KEEP_KEY_VALUE == 'Y') {
//		temp_vndr_seq = formObj.vndr_seq.value;
//		temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
//		temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
//		temp_yd_cd = formObj.yd_cd.value;
//		temp_inv_no = formObj.inv_no.value;
//		temp_fm_prd_dt = formObj.fm_prd_dt.value;
//		temp_to_prd_dt = formObj.to_prd_dt.value;
//		temp_curr_cd = comboObjects[0].Code;
//		temp_iss_dt = formObj.iss_dt.value;
//		temp_rcv_dt = formObj.rcv_dt.value;
//	}
//
//	formObj.reset();
//
//	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
//		// 반드시 reset후에 다시 설정한다.
//		formObj.vndr_seq.value = temp_vndr_seq;
//		formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
//		formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
//		formObj.inv_no.value = temp_inv_no;
//		formObj.yd_cd.value = temp_yd_cd;
//		formObj.inv_ofc_cd.value = inv_ofc_cd; // session에서 불러온 값
//		formObj.fm_prd_dt.value = temp_fm_prd_dt;
//		formObj.to_prd_dt.value = temp_to_prd_dt;
//		comboObjects[0].Code = temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd
//				: def_curr_cd;
//		formObj.iss_dt.value = temp_iss_dt;
//		formObj.rcv_dt.value = temp_rcv_dt;
//
//		if (formObj.yd_cd.value != null && formObj.yd_cd.value.trim() != '') {
//			// <주> setHdSheet2Form()가 반드시 먼저 실행이 되어서 main_hidden의 결과가 form에 다
//			// 반영되어야 yd_cd를 가지고 조회가 가능 한다.
//			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
//		}
//	}

	setHeaderKeyValueReadonly('N');
	formObj.yd_cd.readOnly = false;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = false;
	formObj.to_prd_dt.readOnly = false;
	formObj.iss_dt.readOnly = false;
	formObj.ttl_inv_amt.readOnly = false;
	formObj.rcv_dt.readOnly = false;
	formObj.vat_amt.readOnly = false;
	formObj.err_inv_no.readOnly = false;
	comboObjects[0].Enable = true;
	checkWhldTaxAmtMode();
	setElementDiabled('checkbox', 'hld_flg', 'N');
	setElementDiabled('checkbox', 'TMNL', 'N');
	setElementDiabled('checkbox', 'StorageDay', 'N');
	setElementDiabled('radio', 'CostCalcMethod', 'N');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'N');}
	setSheetsEnable(-1, false);
		
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
	
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = false;
		formObj.ida_cgst_amt.readOnly = false;
		formObj.ida_sgst_amt.readOnly = false;
		formObj.ida_igst_amt.readOnly = false;
		formObj.ida_ugst_amt.readOnly = false;
		
		ComEnableManyObjects(true, formObj.dbt_note_no, formObj.ida_cgst_amt, formObj.ida_sgst_amt, formObj.ida_igst_amt, formObj.ida_ugst_amt);
	}
}

/**
* 특정 element를 수정 불가능 상태로 설정 
* @param {string}	YN_KEEP_KEY_VALUE	reset후에 재설정 여부
* @return
*/
function disablePage(YN_KEEP_KEY_VALUE) {

	var formObj = document.form;

	var temp_vndr_seq = '';
	var temp_vndr_seq_nm = '';
	var temp_is_valid_vndr_seq = '';
	var temp_inv_no = '';
	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null
			&& YN_KEEP_KEY_VALUE == 'Y') {
		temp_vndr_seq = formObj.vndr_seq.value;
		temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
		temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
		temp_inv_no = formObj.inv_no.value;
	}

	formObj.reset();

	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null
			&& YN_KEEP_KEY_VALUE == 'Y') {
		// 반드시 reset후에 다시 설정한다.
		formObj.vndr_seq.value = temp_vndr_seq;
		formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
		formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
		formObj.inv_no.value = temp_inv_no;
	}

	setHeaderKeyValueReadonly('N');
	formObj.yd_cd.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E") {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	
	setSheetsEnable(-1, false);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	sheetObjects[6].RemoveAll();
	sheetObjects[7].RemoveAll();
	sheetObjects[8].RemoveAll();
	// comboObjects[0].Code = '';
	comboObjects[0].Code = def_curr_cd;
	comboObjects[0].Enable = false;
		
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
}

/**
 * New2버튼 클릭 시 발생
 * 해더부분 값을 제외한 나머지 값 삭제
 * 해더부분 수정 불가능 상태로 설정 
 * @return
 */
function disablePage2() {

	// 김부장님은 말하셨지 inv hdr 입력form 상단의 왼쪽은 다 살려라~~~

	var formObj = document.form;

	var temp_vndr_seq = '';
	var temp_vndr_seq_nm = '';
	var temp_is_valid_vndr_seq = '';
	var temp_yd_cd = '';
	var temp_curr_cd = '';
	var temp_fm_prd_dt = '';
	var temp_to_prd_dt = '';
	var temp_iss_dt = '';
	var temp_rcv_dt = '';
	temp_vndr_seq = formObj.vndr_seq.value;
	temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
	temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
	temp_yd_cd = formObj.yd_cd.value;
	temp_fm_prd_dt = formObj.fm_prd_dt.value;
	temp_to_prd_dt = formObj.to_prd_dt.value;
	temp_curr_cd = comboObjects[0].Code;
	temp_iss_dt = formObj.iss_dt.value;
	temp_rcv_dt = formObj.rcv_dt.value;

	formObj.reset();

	// 반드시 reset후에 다시 설정한다.
	formObj.vndr_seq.value = temp_vndr_seq;
	formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
	formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
	formObj.yd_cd.value = temp_yd_cd;
	formObj.inv_ofc_cd.value = inv_ofc_cd; // session에서 불러온 값
	formObj.fm_prd_dt.value = temp_fm_prd_dt;
	formObj.to_prd_dt.value = temp_to_prd_dt;
	comboObjects[0].Code = temp_curr_cd != null && temp_curr_cd != '' ? temp_curr_cd : def_curr_cd;
	comboObjects[0].Enable = false;
	formObj.iss_dt.value = temp_iss_dt;
	formObj.rcv_dt.value = temp_rcv_dt;

	if (formObj.yd_cd.value != null && formObj.yd_cd.value.trim() != '') {
		// <주> setHdSheet2Form()가 반드시 먼저 실행이 되어서 main_hidden의 결과가 form에 다 반영되어야 yd_cd를 가지고 조회가 가능 한다.
		tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', "checkValidYardCode2");
	}

	setHeaderKeyValueReadonly('N');
	formObj.yd_cd.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	setSheetsEnable(-1, false);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	sheetObjects[6].RemoveAll();
	sheetObjects[7].RemoveAll();
	sheetObjects[8].RemoveAll();
	formObj.inv_no.focus();
		
	//tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt|inv_no"));
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = true;
		formObj.ida_cgst_amt.readOnly = true;
		formObj.ida_sgst_amt.readOnly = true;
		formObj.ida_igst_amt.readOnly = true;
		formObj.ida_ugst_amt.readOnly = true;
		
		tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt"));
	}
}

/**
 * reject 후 모든 데이터 화면에서 삭제
 * @return
 */
function disableAftRjct() {

	var formObj = document.form;

	setHeaderKeyValueReadonly('N'); // header의 key값(vnrd_seq와 inv_no)를 활성화 한다
	formObj.reset();
	formObj.yd_cd.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;	
	
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	setSheetsEnable(-1, false);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	// rjct_hidden은 RemoveAll()대상에서 제외
	sheetObjects[7].RemoveAll();
	sheetObjects[8].RemoveAll();
	comboObjects[0].Code = '';
	comboObjects[0].Enable = false;
		
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
	
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = true;
		formObj.ida_cgst_amt.readOnly = true;
		formObj.ida_sgst_amt.readOnly = true;
		formObj.ida_igst_amt.readOnly = true;
		formObj.ida_ugst_amt.readOnly = true;
		
		ComEnableManyObjects(false, formObj.dbt_note_no, formObj.ida_cgst_amt, formObj.ida_sgst_amt, formObj.ida_igst_amt, formObj.ida_ugst_amt);
	}
}

/**
 * confirm 후 모든 element readonly 상태로 세팅
 * @return
 */
function disableAftConf() {

	var formObj = document.form;

	setHeaderKeyValueReadonly('N'); // header의 key값(vnrd_seq와 inv_no)를 활성화 한다
	formObj.yd_cd.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;	
	
	comboObjects[0].Enable = false;
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E" || ida_ofc_cd == 'Y') {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	disableSheetEditable(sheetObjects[0]);
	disableSheetEditable(sheetObjects[1]);
	disableSheetEditable(sheetObjects[2]);
	disableSheetEditable(sheetObjects[3]);
	disableSheetEditable(sheetObjects[4]);	
	
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
	
	if(ida_ofc_cd == 'Y'){
		formObj.dbt_note_no.readOnly = true;
		formObj.ida_cgst_amt.readOnly = true;
		formObj.ida_sgst_amt.readOnly = true;
		formObj.ida_igst_amt.readOnly = true;
		formObj.ida_ugst_amt.readOnly = true;
		
		ComEnableManyObjects(false, formObj.dbt_note_no, formObj.ida_cgst_amt, formObj.ida_sgst_amt, formObj.ida_igst_amt, formObj.ida_ugst_amt);
	}
}

/**
 * disable 된 sheet 를 editable 로 변경
 * @param sheet
 * @return
 */
function disableSheetEditable(sheet) {
	for ( var i = 1; sheet != null && i <= sheet.Rows; i++) {
		sheet.RowEditable(i) = false;
	}
}

/**
 * TPB popup창에서 입력이 완료되면 해당 row를 disable한다.
 * @param {int}		sheet_idx	선택된 sheet index
 * @param {sheet}	sheet		ibsheet
 * @param {int}		row_num		선택된 sheet rownum
 * @return
 */
function disableTPBrow(sheet_idx, sheet, row_num) {
	if (sheet_idx != null && sheet != null) {
		if (sheet.CellValue(row_num, 'n3pty_flg') != undefined
				&& sheet.CellValue(row_num, 'n3pty_flg') == 'Y') {
			if (sheet_idx == '3') {
				setShtCellsEditable2(
						sheet,
						row_num,
						'lgs_cost_cd|inv_xch_rt|calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_amt',
						'N');
			} else if (sheet_idx == '4') {
				setShtCellsEditable2(
						sheet,
						row_num,
						'lgs_cost_cd|inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt',
						'N');
			} else if (sheet_idx == '5') {
				setShtCellsEditable2(
						sheet,
						row_num,
						'lgs_cost_cd|ovr_vol_qty|stk_vol_qty|diff_vol_qty|inv_vol_qty|fp_teu_qty|inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt',
						'N');
			}
		}
	}
}

/**
 * Calc. tab을 조회나 저장후 TPB I/F data가 있는 경우 disable한다.
 * @param {int}		sheet_idx	선택된 sheet index
 * @param {sheet}	sheet		ibsheet
 * @return
 */
function checkTPBdataEditable(sheet_idx, sheet) {
	for ( var i = sheet.HeaderRows; sheet_idx != null && sheet != null
			&& i < (sheet.HeaderRows + sheet.RowCount); i++) {
		if (sheet.CellValue(i, 'n3pty_flg') != null
				&& sheet.CellValue(i, 'n3pty_flg').trim() == 'Y') {
			// sheet.CellEditable(i,'lgs_cost_cd') = false;
			// sheet.RowEditable(i) = false;
			// sheet.CellEditable(i,'n3pty_flg') = true;
			if (sheet_idx == '3') {
				setShtCellsEditable2(sheet, i,
						'inv_xch_rt|calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_amt',
						'N');
			} else if (sheet_idx == '4') {
				setShtCellsEditable2(
						sheet,
						i,
						'inv_xch_rt|stay_dys||free_dys|paid_day|free_dy_xcld_dys|ovr_dys|ctrt_rt|inv_amt',
						'N');
			} else if (sheet_idx == '5') {
				setShtCellsEditable2(
						sheet,
						i,
						'ovr_vol_qty||inv_vol_qty||fp_teu_qty||inv_vol_qty|fp_teu_qty|ctrt_rt|inv_xch_rt',
						'N');
			}
		} else {
			if (sheet.CellValue(i, "calc_tp_cd") == "M" || sheet.CellValue(i, "calc_tp_cd") == "S") {
				sheet.CellEditable(i, 'lgs_cost_cd') = true;
			} else {
				sheet.CellEditable(i, 'lgs_cost_cd') = false;
			}
		}
		/*
		 * if (sheet.CellValue(i,'calc_tp_cd')=='M'){ //lgs_cost_cd의 활성/비활성화 여부는
		 * 수동계산만 대상입니다. if (sheet.CellValue(i,'n3pty_flg')!=null &&
		 * sheet.CellValue(i,'n3pty_flg').trim()=='Y'){
		 * //sheet.CellEditable(i,'lgs_cost_cd') = false;
		 * sheet.RowEditable(row_num) = false;
		 * sheet.CellEditable(row_num,'n3pty_flg') = true; } else {
		 * sheet.CellEditable(i,'lgs_cost_cd') = true; } }
		 */
	}
}

/**
 * 화면에 보이는 sheet와 해당 tab을 활성화/비활성화 여부 설정
 * @param {int}		to_sht_idx		선택된 sheet index
 * @param {boolean}	ENABLE_SHEETS	활성화/비활성화 여부
 * @return
 */
function setSheetsEnable(to_sht_idx, ENABLE_SHEETS) {

	if (!ENABLE_SHEETS) {
		// 모든 tab 비활성화 == tabObj 비활성화
		tabObjects[0].Enable = false;
		return false;
	}

	var currSelIdx = tabObjects[0].SelectedIndex;

	tabObjects[0].Enable = true; // 현재는 하나의 tab만 있다. -> 활성화

	// 이제는 모든 tab(1~5)은 다 기본적으로 활성화되어있구 calc_tmnl과 calc_fd만 선택적으로 비활성화 여부를 확인하여
	// 수행한다.
	var enable_tab_03 = false; // calc_tmn 활성여부
	var enable_tab_04 = false; // calc_fd 활성여부

	// CALC_TMNL과 CALC_FD TAB은 현재 저장된 조건에서 사용하는지를 확인합니다.
	var calc_arr = getCostCalcShtToSaveArr('N');
	for ( var i = 0; calc_arr != null && i < calc_arr.length; i++) {
		if (calc_arr[i] == 2) {
			enable_tab_03 = true;
		}
		if (calc_arr[i] == 3) {
			enable_tab_04 = true;
		}
	}

	/***************************************************************************
	 * 이 넘의 OFF-DOCK에서는 특정 TAB을 조건에 따라 활성/비활성화 하는 것이 있어서, 완전 단순 STORAGE에 비해 추가
	 * 작업이 필요하당.. SHEETOBJ.TabEnable(IDX)를 이용해서 특정 TAB을 비활성화 하면 현재 선택된 TAB이 다음의
	 * 활성화된 TAB으로 자동 이동하는 현상이 있어서 currSelIdx으로 재설정 작업을 합니다. 믿거나 말거나 참고하셔요.
	 **************************************************************************/
	if (tabObjects[0].TabEnable(2) != enable_tab_03) {
		tabObjects[0].TabEnable(2) = enable_tab_03;
		sheetObjects[2].Editable = enable_tab_03;
		sheetObjects[2].Enable = enable_tab_03;
	}
	if (tabObjects[0].TabEnable(3) != enable_tab_04) {
		tabObjects[0].TabEnable(3) = enable_tab_04;
		sheetObjects[3].Editable = enable_tab_04;
		sheetObjects[3].Enable = enable_tab_04;
	}

	if (to_sht_idx != undefined && to_sht_idx != null && to_sht_idx != '' && (to_sht_idx >= 0 && to_sht_idx <= 4)) {
		tabObjects[0].SelectedIndex = to_sht_idx;
	} else {
		if (!tabObjects[0].TabEnable(currSelIdx)) {
			tabObjects[0].SelectedIndex = 0;
		} else {
			tabObjects[0].SelectedIndex = currSelIdx;
		}
	}

	enable_sheet_01 = tabObjects[0].TabEnable(0);
	enable_sheet_02 = tabObjects[0].TabEnable(1);
	enable_sheet_03 = tabObjects[0].TabEnable(2);
	enable_sheet_04 = tabObjects[0].TabEnable(3);
	enable_sheet_05 = tabObjects[0].TabEnable(4);
}

/**
 * 한개의 sheet와 해당 tab을 활성화/비활성화 여부 설정
 * @param {int}		currIdx		선택된 tab index
 * @param {boolean}	enable		활성화/비활성화 여부
 * @return
 */
function setIndvSheetEnable(currIdx, enable) {
	tabObjects[0].Enable = true;				// 현재는 하나의 tab만 있다. -> 활성화
	tabObjects[0].TabEnable(currIdx) = enable;
	sheetObjects[currIdx].Editable = enable;	// tabObj의 index와 sheetObj의 index가 동일하다는 전제로 작업 -> 달라질 경우 이부분을 수정해야한다.
}

/**
 * [Cost Calc. Method] 라디오버튼 활성화/비활성화 여부 설정
 * @return
 */
function setRadioOptionEnable() {
	var formObj = document.form;

	if (formObj.TMNL.checked != true && formObj.StorageDay.checked != true) {
		// setElementChecked('radio','CostCalcMethod','N'); //CHECK된 상태를 풀기
		setElementDiabled('radio', 'CostCalcMethod', 'Y'); // 비활성화
	} else {
		setElementDiabled('radio', 'CostCalcMethod', 'N'); // 활성화
	}
}

/**
 * Save 버튼 클릭 시 발생
 * 필수입력값 체크
 * @return
 */
function fnChkForm() {

	var formObj = document.form;
	if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '') {
		// ComShowMessage("VNDR Code값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES23007', 'VNDR Code'));
		formObj.vndr_seq.focus();
		return false;
	} else if (formObj.is_valid_vndr_seq.value == null
			|| formObj.is_valid_vndr_seq.value != 'Y') {
		// ComShowMessage("VNDR Code값이 유효하지 않았습니다.");
		ComShowMessage(ComGetMsg('TES23008', 'VNDR Code'));
		formObj.vndr_seq.focus();
		return false;
	} else if (formObj.inv_no.value == null || formObj.inv_no.value == '') {
		// ComShowMessage("Inv No값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Inv No'));
		formObj.inv_no.focus();
		return false;
	} else if (formObj.yd_cd.value == null || formObj.yd_cd.value == '') {
		// ComShowMessage("Yard Code값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Yard Code'));
		formObj.yd_cd.focus();
		return false;
	} else if (formObj.is_valid_yd_cd.value == null
			|| formObj.is_valid_yd_cd.value != 'Y') {
		// ComShowMessage("Yard Code값이 유효하지 않았습니다.");
		ComShowMessage(ComGetMsg('TES23008', 'Yard Code'));
		formObj.yd_cd.focus();
		return false;
	} else if (formObj.inv_ofc_cd.value == null
			|| formObj.inv_ofc_cd.value == '') {
		// ComShowMessage("Inv OFC값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Inv OFC'));
		return false;
	} else if (formObj.cost_ofc_cd.value == null
			|| formObj.cost_ofc_cd.value == '') {
		// ComShowMessage("Cost OFC값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Cost OFC'));
		formObj.cost_ofc_cd.focus();
		return false;
	} else if (formObj.is_valid_cost_ofc_cd.value == null
			|| formObj.is_valid_cost_ofc_cd.value != 'Y') {
		// ComShowMessage("Cost OFC값이 유효하지 않았습니다.");
		ComShowMessage(ComGetMsg('TES23008', 'Cost OFC'));
		formObj.cost_ofc_cd.focus();
		return false;
	} else if (formObj.curr_cd.Code == null || formObj.curr_cd.Code == '') {
		// ComShowMessage("Currency값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Currency'));
		return false;
	} else if (formObj.fm_prd_dt.value == null || formObj.fm_prd_dt.value == '') {
		// ComShowMessage("Period 시작값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'FromPeriod'));
		formObj.fm_prd_dt.focus();
		return false;
	} else if (formObj.to_prd_dt.value == null || formObj.to_prd_dt.value == '') {
		// ComShowMessage("Period 마지막값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'ToPeriod'));
		formObj.to_prd_dt.focus();
		return false;
	} else if (!validateDateObj(formObj.fm_prd_dt)) {
		formObj.fm_prd_dt.focus();
		return false;
	} else if (!validateDateObj(formObj.to_prd_dt)) {
		formObj.to_prd_dt.focus();
		return false;
	} else if (formObj.ttl_inv_amt.value == null
			|| formObj.ttl_inv_amt.value == '') {
		// ComShowMessage("Inv AMT값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Inv AMT'));
		formObj.ttl_inv_amt.focus();
		return false;
	} else if (formObj.iss_dt.value == null || formObj.iss_dt.value == '') {
		// ComShowMessage("Issue Date값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Issue Date'));
		formObj.iss_dt.focus();
		return false;
	} else if (formObj.rcv_dt.value == null || formObj.rcv_dt.value == '') {
		// ComShowMessage("RCV Date값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'RCV Date'));
		formObj.rcv_dt.focus();
		return false;
	} else if (formObj.iss_dt.value != null
			&& formObj.iss_dt.value.trim() != ''
			&& formObj.rcv_dt.value != null
			&& formObj.rcv_dt.value.trim() != '' && !isValIssRcv()) {
		ComShowMessage('Issue date must be earlier than RCV date.'); // ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
		return false;
	} else if (!isValIssSys(formObj.iss_dt)){ 	
		return false;
	} else if (!isValIssSys(formObj.rcv_dt)){ 	
		return false;	
	} else if ((formObj.err_inv_no.value == null || formObj.err_inv_no.value != '')
			&& (formObj.is_valid_err_inv_no.value == null || formObj.is_valid_err_inv_no.value != 'Y')) {
		ComShowMessage(ComGetMsg('TES40063', 'ERR INV.NO')); // ComShowMessage('확인되지 않는 ERR INV.NO입니다.');
		formObj.err_inv_no.focus();
		return false;
	}
	if (formObj.hld_flg.checked == true) {
		if (formObj.hld_rmk.value == null || formObj.hld_rmk.value == '') {
			// ComShowMessage("Hold의 Remarks값이 입력되지 않았습니다.\n\n'Remarks' button을 click하여 입력하십시오.");
			ComShowMessage(ComGetMsg('TES23005'));
			return false;
		}
		formObj.hld_flg.value = 'Y';
	} else {
		formObj.hld_flg.value = 'N';
		formObj.hld_rmk.value = '';
	}
	
//    if (formObj.ap_rvs_cng_flg.checked == true) {
//    	formObj.ap_rvs_cng_flg.value = 'Y';
//    } else {
//    	formObj.ap_rvs_cng_flg.value = '';
//    }
    
	if (formObj.TMNL.checked == true || formObj.StorageDay.checked == true) {
		if (formObj.CostCalcMethod[0].checked == false
				&& formObj.CostCalcMethod[1].checked == false) {
			ComShowMessage(ComGetMsg('TES40011')); // ComShowMessage("Cost Calc. Method 중 하나를 선택해야 합니다. ");
			return false;
		}
	}

	return true;
}

/**
 * 검색된 sheet의 data로 form 세팅
 * @param {string}	MODE	상태(save, confirm...)
 * @return
 */
function setHdSheet2Form(MODE) {
	var formObj = document.form;
	if (sheetObjects[5].RowCount == 1) {
		formObj.tml_so_ofc_cty_cd.value = sheetObjects[5].CellValue(1, 'tml_so_ofc_cty_cd');
		formObj.tml_so_seq.value = sheetObjects[5].CellValue(1, 'tml_so_seq');
		if (MODE != undefined && MODE != null && MODE == 'CONFIRM') {
			// formObj.confirm_mode.value = '';
			// ComShowMessage('setHdSheet2Form - CONFIRM');
		} else {
			// formObj.inv_ofc_cd.value = sheetObjects[5].CellValue(1, 'inv_ofc_cd'); //session에 있는 값으로 무조건 채워넣기로 합니다.
			formObj.cost_ofc_cd.value = sheetObjects[5].CellValue(1, 'cost_ofc_cd');
			formObj.cost_ofc_cd_hidden.value = sheetObjects[5].CellValue(1, 'cost_ofc_cd');
			formObj.vndr_seq.value = tes_lpad(sheetObjects[5].CellValue(1, 'vndr_seq'), 6, '0'); // 2008-01 lpad추가
			formObj.yd_cd.value = sheetObjects[5].CellValue(1, 'yd_cd');
			formObj.yd_cd_hidden.value = sheetObjects[5].CellValue(1, 'yd_cd');
			formObj.yd_nm.value = sheetObjects[5].CellValue(1, 'yd_nm');
			formObj.fm_prd_dt.value = sheetObjects[5].CellValue(1, 'fm_prd_dt');
			formObj.to_prd_dt.value = sheetObjects[5].CellValue(1, 'to_prd_dt');
			formObj.inv_no.value = sheetObjects[5].CellValue(1, 'inv_no');
			formObj.iss_dt.value = sheetObjects[5].CellValue(1, 'iss_dt');
			formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[5].CellValue( 1, 'ttl_inv_amt'), sheetObjects[5].CellValue(1, 'curr_cd'));
			formObj.rcv_dt.value = sheetObjects[5].CellValue(1, 'rcv_dt');
			formObj.hld_rmk.value = sheetObjects[5].CellValue(1, 'hld_rmk');
			if (sheetObjects[5].CellValue(1, 'hld_flg') != undefined
					&& sheetObjects[5].CellValue(1, 'hld_flg') == 'Y') {
				formObj.hld_flg.checked = true;
			} else {
				formObj.hld_flg.checked = false;
			}
		}
		formObj.vat_amt.value = tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'vat_amt'), sheetObjects[5].CellValue(1, 'curr_cd'));
		formObj.curr_cd.Code = sheetObjects[5].CellValue(1, 'curr_cd');
		formObj.curr_cd_tmp.value = sheetObjects[5].CellValue(1, 'curr_cd');
		resetSheetDataProperty(comboObjects[0].Code);
		formObj.tml_inv_tp_cd.value = sheetObjects[5].CellValue(1, 'tml_inv_tp_cd');
		var inv_sts_cd = sheetObjects[5].CellValue(1, 'tml_inv_sts_cd');
		formObj.tml_inv_sts_cd.value = inv_sts_cd;
		if (inv_sts_cd != undefined && inv_sts_cd == 'R') {
			inv_sts_cd = 'RC'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'C') {
			inv_sts_cd = 'CF'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'P') {
			inv_sts_cd = 'AP'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'A') {
			inv_sts_cd = 'AR'
		}
		formObj.tml_inv_sts_cd2.value = inv_sts_cd;
		formObj.tml_inv_sts_cd2.title = tes_getInvStsFullNm(inv_sts_cd);
		var rjct_sts_cd = sheetObjects[5].CellValue(1, 'tml_inv_rjct_sts_cd');
		formObj.tml_inv_rjct_sts_cd.value = (rjct_sts_cd != null
				&& rjct_sts_cd.trim() != '' ? rjct_sts_cd : 'NL'); // 기본으로  NL(정상)으로  설정
		formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_sts_cd != null
				&& rjct_sts_cd.trim() != '' ? rjct_sts_cd : 'NL');
		formObj.inv_rjct_rmk.value = sheetObjects[5].CellValue(1, 'inv_rjct_rmk');
		formObj.err_inv_no.value = sheetObjects[5].CellValue(1, 'err_inv_no');
		formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'whld_tax_amt'), sheetObjects[5].CellValue(1, 'curr_cd'));
		
		//India GST Amount
		formObj.dbt_note_no.value			= sheetObjects[5].CellValue(1, 'dbt_note_no' );
        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_cgst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_sgst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_igst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));
        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObjects[5].CellValue(1, 'ida_ugst_amt' ),sheetObjects[5].CellValue(1,'curr_cd'));

		/**
		 * form에서 ttl_inv_amt, vat_amt, whld_tax_amt값들이 다 설정이 마친뒤에
		 * set_total_amount()를 호출해야 정상 동작합니다. 꼭~
		 */
		set_total_amount();

		// radio button 설정 관련....
		var tml_cost_grp_cd = sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');
		var tml_calc_ind_cd = sheetObjects[5].CellValue(1, 'tml_calc_ind_cd');
		var sto_dys_ind_cd = sheetObjects[5].CellValue(1, 'sto_dys_ind_cd');
		// ComShowMessage('tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
		// 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
		formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
		formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
		formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;

		/***********************************************************************
		 * tml_cost_grp_cd - Cost Group Code : 'TM' : Terminal 'TP' : Terminal &
		 * Storage by Free Pool 'TD' : Terminal & Storage by Free Day 'SP' :
		 * Storage by Free Pool 'SD' : Storage by Free Day
		 * 
		 * tml_calc_ind_cd - Calculation Indicator : 'TP' : Throuput 'SP' :
		 * Seperate
		 * 
		 * sto_dys_ind_cd - Storage Days Indicator : 'IO' : Gate In & Out Date
		 * 기준 'DT : Date 기준
		 **********************************************************************/
		// ComShowMessage(tml_cost_grp_cd + ' => ' + tml_cost_grp_cd.length + '
		// - ' + tml_cost_grp_cd.substring(0,1) + ' / ' +
		// tml_cost_grp_cd.substring(1,2));
		// 초기화 먼저..
		setElementChecked('checkbox', 'TMNL', 'N');
		setElementChecked('checkbox', 'StorageDay', 'N');
		setElementChecked('radio', 'CostCalcMethod', 'N');

		// 불러온 값으로 다시 설정...
		if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.trim().length == 2) {
			if (tml_cost_grp_cd.trim().substring(0, 1) == 'T') {
				formObj.TMNL.checked = true;
			} else if (tml_cost_grp_cd.trim().substring(0, 1) == 'S') {
				formObj.TMNL.checked = false;
			}
			if (tml_cost_grp_cd.trim().substring(1, 2) == 'D') {
				formObj.StorageDay.checked = true;
			} else if (tml_cost_grp_cd.trim().substring(1, 2) == 'P') {
				formObj.StorageDay.checked = false;
			}
		}
		if (formObj.TMNL.checked == true || formObj.StorageDay.checked == true) {
			setElementDiabled('radio', 'CostCalcMethod', 'N');
		} else {
			setElementDiabled('radio', 'CostCalcMethod', 'Y');
		}
		if (tml_calc_ind_cd != undefined && tml_calc_ind_cd.trim().length == 2) {
			if (tml_calc_ind_cd.trim() == 'TP') {
				formObj.CostCalcMethod[0].checked = true;
			} else if (tml_calc_ind_cd.trim() == 'SP') {
				formObj.CostCalcMethod[1].checked = true;
			}
		}

		if (sheetObjects[2].RowCount > 0) {
			setElementDiabled('checkbox', 'TMNL', 'Y');
			setElementDiabled('radio', 'CostCalcMethod', 'Y');
		}
		if (sheetObjects[3].RowCount > 0) {
			setElementDiabled('checkbox', 'StorageDay', 'Y');
			setElementDiabled('radio', 'CostCalcMethod', 'Y');
		}
		
		formObj.mvmt_gate_in_dt.value = sheetObjects[5].CellValue(1, 'mvmt_gate_in_dt');
		formObj.mvmt_gate_out_dt.value = sheetObjects[5].CellValue(1, 'mvmt_gate_out_dt');

	} else if (sheetObjects[5].RowCount > 0) {
		// ComShowMessage('ERR');
		ComShowMessage(ComGetMsg('TES22507', 'ERR'));
		return false;
	} else {
		// ComShowMessage('ERR2');
		ComShowMessage(ComGetMsg('TES22507', 'ERR'));
		return false;
	}
}

/**
 * 조회 시 필수입려값 체크
 * @return
 */
function fnChkSearchForm() {

	var formObj = document.form;

	if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '') {
		// ComShowMessage("VNDR Code값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES23007', 'VNDR Code'));
		formObj.vndr_seq.focus();
		return false;
	} else if (formObj.inv_no.value == null || formObj.inv_no.value == '') {
		// ComShowMessage("Inv No값이 입력되지 않았습니다.");
		ComShowMessage(ComGetMsg('TES21026', 'Inv No'));
		formObj.inv_no.focus();
		return false;
	}

	return true;
}

/**
 * 파라메터로 받은 element disable 여부 설정
 * @param {string}	eleTp			element타입
 * @param {string}	eleNm			element이름
 * @param {string}	ELE_DISABLED	disable 여부
 * @return
 */
function setElementDiabled(eleTp, eleNm, ELE_DISABLED) {
	if (eleNm == undefined || eleNm == null || eleNm.trim() == ''
			|| eleTp == undefined || eleTp == null || eleTp.trim() == ''
			|| ELE_DISABLED == undefined || ELE_DISABLED == null
			|| ELE_DISABLED.trim() == '') {
		return false;
	}
	var formObj = document.form;

	var numOfEle = formObj.elements.length;
	for ( var i = 0; i < numOfEle; i++) {
		if (formObj.elements[i].type == eleTp && formObj.elements[i].name == eleNm) {
			formObj.elements[i].disabled = (ELE_DISABLED == 'Y' ? true : false);
		}
	}
}

/**
* 파라메터로 받은 element 체크 여부 설정
* @param {string}	eleTp			element타입
* @param {string}	eleNm			element이름
* @param {string}	ELE_CHECKED		체크 여부
* @return
*/
function setElementChecked(eleTp, eleNm, ELE_CHECKED) {
	if (eleNm == undefined || eleNm == null || eleNm.trim() == ''
			|| eleTp == undefined || eleTp == null || eleTp.trim() == ''
			|| ELE_CHECKED == undefined || ELE_CHECKED == null
			|| ELE_CHECKED.trim() == '') {
		return false;
	}
	var formObj = document.form;

	var numOfEle = formObj.elements.length;
	for ( var i = 0; i < numOfEle; i++) {
		if (formObj.elements[i].type == eleTp
				&& formObj.elements[i].name == eleNm) {
			formObj.elements[i].checked = (ELE_CHECKED == 'Y' ? true : false);
		}
	}
}

/**
 * form 에서 element유형 과 element명이 일치하는 element의 갯수 구하기
 * @param {form}	formObj		form
 * @param {string}	eleTp		element타입
 * @param {string}	eleNm		element이름
 * @return
 */
function getElementCnt(formObj, eleTp, eleNm) {

	var cnt = 0;
	var element;
	var numOfEle = formObj.elements.length;
	for ( var i = 0; i < numOfEle; i++) {
		if (formObj.elements[i].type == eleTp
				&& formObj.elements[i].name == eleNm) {
			cnt++;
		}
	}

	return cnt;
}

/**
 * 넘겨받은 배열을 "&" 문자로 연결해서 리턴한다.
 * @param params
 * @return
 */
function getSaveString(params) {
	var saveString = null;
	if (params == null) {
		saveString = "";
	} else {
		saveString = params.join("&");
	}
	
	return saveString;
}

/**
 * [Period] 변경 시 발생
 * Period 를 변경하면 기존 계산된 값(존재할경우) 초기화
 * @return
 */
function period_ChkMod() {
	var formObj = document.form;
	if (hasAutoCalcData(sheetObjects[2]) || hasAutoCalcData(sheetObjects[3])
			|| hasAutoCalcData(sheetObjects[4])) {
		if (formObj.fm_prd_dt.value != sheetObjects[5].CellValue(1, 'fm_prd_dt')
				|| formObj.to_prd_dt.value != sheetObjects[5].CellValue(1,
						'to_prd_dt')) {
			// if (confirm('Cal Tab의 Auto Calculation 결과가 clear됩니다. 계속 진행하시겠습니까?')){
			if (confirm(ComGetMsg('TES40009'))) {
				removeAutoCalcDataAll();
			} else {
				formObj.fm_prd_dt.value = sheetObjects[5].CellValue(1,
						'fm_prd_dt');
				formObj.to_prd_dt.value = sheetObjects[5].CellValue(1,
						'to_prd_dt');
				return false;
			}
		}
	}
	return false;
}

/**
 * [Period] 유효성 체크
 * @param {string]	obj		날짜
 * @return
 */
function validateDateObj(obj) {
	if (obj.readOnly == true) {
		return false;
	}
	obj.value = obj.value.trim();
	if (obj.value == null || obj.value.trim() == '') {
		return false;
	}
	if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
		ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이 잘못되었습니다.');
		obj.focus();
		return false;
	}
	var formObj = document.form;
	if (formObj.fm_prd_dt.value != null && formObj.fm_prd_dt.value.trim() != ''
			&& formObj.to_prd_dt.value != null
			&& formObj.to_prd_dt.value.trim() != ''
			&& !isValFmTo(formObj.fm_prd_dt.value, formObj.to_prd_dt.value)) {
		ComShowMessage(ComGetMsg('TES24012')); // ComShowMessage('시작일이 마지막일보다 작아야 합니다.');
		return false;
	}
	return true;
}

/**
 * 입력받은 시작일과 마지막일의 유효성 체크
 * 마지막일은 시작일보다 작으면 false 그렇지 않으면 true.
 * @param {string}	fmDt	시작일
 * @param {string}	toDt	마지막일
 * @return
 */
function isValFmTo(fmDt, toDt) {
	if (fmDt == undefined || fmDt == null || fmDt.trim() == ''
			|| toDt == undefined || toDt == null || toDt.trim() == '') {
		return false;
	}
	var str_fmDt = fmDt.replace(/-/gi, '');
	var str_toDt = toDt.replace(/-/gi, '');
	if (isNaN(str_fmDt) || isNaN(str_toDt) || str_fmDt.trim().length != 8 || str_toDt.trim().length != 8) {
		return false;
	}
	if (parseInt(str_toDt, 10) - parseInt(str_fmDt, 10) <= 0) {
		return false;
	}
	return true;
}

/**
* [Issue DT], [RCV Date] 유효성 체크
* @param {string]	obj		날짜
* @return
*/
function validateDateObj2(obj) {
	if (obj.readOnly == true) {
		return false;
	}
	obj.value = obj.value.trim();
	if (obj.value == null || obj.value.trim() == '') {
		return false;
	}
	if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
		ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이 잘못되었습니다.');
		obj.focus();
		return false;
	}
	var formObj = document.form;
	if (formObj.iss_dt.value != null && formObj.iss_dt.value.trim() != ''
			&& formObj.rcv_dt.value != null
			&& formObj.rcv_dt.value.trim() != '' && !isValIssRcv()) {
		ComShowMessage('Issue date must be earlier than RCV date.'); // ComShowMessage('Issue date이 RCV
																		// date보다 작아야 합니다.');
		return false;
	}
	return true;
}

/**
 * 입력받은 Issue DT 는 RCV Date 유효성 체크
 * RCV Date 가 Issue DT 보다 작으면 false 그렇지 않으면 true  
 * @return
 */
function isValIssRcv() {
	var str_issDt = document.form.iss_dt.value.replace(/-/gi, '');
	var str_rcvDt = document.form.rcv_dt.value.replace(/-/gi, '');
	if (isNaN(str_issDt) || isNaN(str_rcvDt) || str_issDt.trim().length != 8
			|| str_rcvDt.trim().length != 8) {
		return false;
	}
	if (parseInt(str_issDt, 10) - parseInt(str_rcvDt, 10) > 0) {
		return false;
	}
	return true;
}

/**
 * Issue DT와 User Office의 Local Sysdate와의 유효성 체크
 * 입력받은 Issue DT가 Storage Invoice Creation화면이 loadPage될 때의 
 * User Office의 Sysdate보다 크면 false 그렇지 않으면 true
 * @return
 */
function isValIssSys(obj){
	var str_tgtDt = obj.value.replace(/-/gi,'');
	var str_sysDt = new String(db_date).substring(0,8);
	if ((str_tgtDt!=null && str_tgtDt.trim()!="") && (isNaN(str_tgtDt) || isNaN(str_sysDt) || str_tgtDt.trim().length!=8 || str_sysDt.trim().length!=8)) {
		ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
		return false;
	}

	if (parseInt(str_tgtDt,10) - parseInt(str_sysDt,10) > 0){
		if (obj.name == 'iss_dt'){
			ComShowMessage('Issued DT error.');
		} else if (obj.name == 'rcv_dt'){
			ComShowMessage('Received DT error.');
		}
		return false;
	}
	return true;
}

/**
 * Period 형식 체크
 * @param {string}	prd_dt	날짜
 * @return
 */
function checkPeriodFormat(prd_dt) {
	var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
	if (!tes_checkFormat2(prd_dt, date_regexp)) {
		return false;
	} else {
		return true;
	}
}

/**
 * [Cost Group] 선택 값에 따라 tml_cost_grp_cd(TM, TP, SD, SP) 값 설정하고
 * [Cost Calc. Method] 선택 값에 따라 tml_calc_ind_cd(TP, SP), sto_dys_ind_cd(IO, DT) 값 설정하고
 * @return
 */
function setCalcCostCond() {

	var formObj = document.form;

	var tml_cost_grp_cd = '';
	var sto_dys_ind_cd = '';

	tml_cost_grp_cd = 'SD';

	if (formObj.TMNL.checked == true) {
		tml_cost_grp_cd = 'TM';
		if (formObj.StorageDay.checked == true) {
			tml_cost_grp_cd = 'TD';
		} else {
			tml_cost_grp_cd = 'TP';
		}
	} else {
		tml_cost_grp_cd = '';
		if (formObj.StorageDay.checked == true) {
			tml_cost_grp_cd = 'SD';
		} else {
			tml_cost_grp_cd = 'SP';
		}
	}

	if (formObj.CostCalcMethod[0].checked == true) {
		tml_calc_ind_cd = 'TP';
		sto_dys_ind_cd = 'IO';
	} else if (formObj.CostCalcMethod[1].checked == true) {
		tml_calc_ind_cd = 'SP';
		sto_dys_ind_cd = 'DT';
	} else {
		tml_calc_ind_cd = '';
	}

	formObj.tml_inv_tp_cd.value = 'OF';
	formObj.tml_cost_grp_cd.value = tml_cost_grp_cd;
	formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
	formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;
	// ComShowMessage(formObj.tml_cost_grp_cd.value + ' / ' +
	// formObj.sto_dys_ind_cd.value);
}

var arr_sht_chk = new Array(); // 전역변수 : 이미 확인된 sheet idx들

/**
 * 이미 확인된 sheet 를 전역변수 arr_sht_chk 에 저장.
 * @param {int}	currShtIdx	확인된 sheet index
 * @return
 */
function setChkCostCalcSht(currShtIdx) {

	if (arr_sht_chk != null) {
		var hasSht = false;
		for ( var m = 0; arr_sht_chk != null && m < arr_sht_chk.length; m++) {
			if (arr_sht_chk[m] == currShtIdx) {
				hasSht = true;
				break;
			}
		}
		if (!hasSht) { // 없으면 추가
			arr_sht_chk[arr_sht_chk.length] = currShtIdx; // 여기는 이미 확인한 넘들만 들어온당..
		}
	}
}

/**
 * Cost Group에서 선택된 조건에 따라 row가 있고 저장해야할 sheet의 idx 배열 구하기
 * @param ROWCOUNT_CHK_YN
 * @return
 */
function getCostCalcShtToSaveArr(ROWCOUNT_CHK_YN) {

	if (sheetObjects[5].RowCount == 0) {
		return false;
	}

	var arr_sht_to_go = new Array();
	var tml_cost_grp_cd = sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');

	if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.trim().length == 2) {
		if (tml_cost_grp_cd.trim().substring(0, 1) == 'T') { // TMNL
			if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN.trim() == 'Y') {
				if (sheetObjects[2].RowCount > 0 && sheetObjects[2].IsDataModified) {
					arr_sht_to_go[arr_sht_to_go.length] = 2;
				}
			} else {
				arr_sht_to_go[arr_sht_to_go.length] = 2;
			}
		}
		if (tml_cost_grp_cd.trim().substring(1, 2) == 'D') { // By Day
			if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN.trim() == 'Y') {
				if (sheetObjects[3].RowCount > 0 && sheetObjects[3].IsDataModified) {
					arr_sht_to_go[arr_sht_to_go.length] = 3;
				}
			} else {
				arr_sht_to_go[arr_sht_to_go.length] = 3;
			}
		}
	} else {
		return false;
	}

	return arr_sht_to_go;
}

/**
 * 이미 확인된 sheet idx를 담은 전역변수 arr_sht_chk 초기화
 * @return
 */
function init_Arr_sht_chk() {
	for ( var i = 0; arr_sht_chk != null && i < arr_sht_chk.length; i++) {
		arr_sht_chk[i] = '';
	}
}

/**
 * CostCalc. sheet(들) 저장시 다른 sheet에 확인할게 있는지 confirm 및 이동
 * @param {int}	currShtIdx	선택된 sheet index
 * @return
 */
function chkCostCalcSaveSts(currShtIdx) {

	/* CostCalc. sheet(들) 저장시 다른 sheet에 확인할게 있는지 confirm 및 이동.... */

	if (sheetObjects[5].RowCount == 0) {
		return false;
	}

	// 확인했는지 전역변수를 설정
	setChkCostCalcSht(currShtIdx);

	var arr_sht = new Array();
	var toShtIdx = -1; // 이동한 sheet의 idx 초기화

	var arr_sht = getCostCalcShtToSaveArr('Y'); // Cost Group에서 선택된 조건에 따라 저장할
												// sheet의 idx 배열을 return...

	for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
		if (arr_sht[i] != currShtIdx) {
			toShtIdx = parseInt(arr_sht[i], 10);
			break;
		}
	}

	for ( var j = 0; arr_sht_chk != null && j < arr_sht_chk.length; j++) {
		if (arr_sht_chk[j] == toShtIdx) {
			// ComShowMessage('[2] 이미 확인 -> 저장시작!');
			return true; // 이미 확인된 sheet는 완전 통과
		}
	}

	// ComShowMessage("currShtIdx:"+currShtIdx+" - toShtIdx:"+toShtIdx);
	if (toShtIdx < 0) { // 다른sheet으로 이동할 필요가 없다는 표시
		return true; // 그냥 바로 저장을 수행
	} else {
		// if (!confirm('\n저장전에 계산을 확인할 SHEET가 있습니다.\n\n이동하겠습니까?\n')) {
		if (!confirm(ComGetMsg('TES24013'))) {
			return false;
		}
		tabObjects[0].SelectedIndex = toShtIdx;
	}

}

/**
 * confirm 완료 후일 경우 confirm 상태임을 알리는 메세지 띄운다
 * @param 	{string}	ALMSG_YN	confirm 완료 여부
 * @return
 */	
function chk_conf(ALMSG_YN) {
	if (confirm_done) {
		if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
			ComShowMessage(ComGetMsg('TES24044')); // ComShowMessage('confirm 완료 상태');
		}
		return false;
	}
	return true;
}

/**
 * reject 완료 후일 경우 reject 상태임을 알리는 메세지 띄운다
 * @param {string}	ALMSG_YN	confirm 완료 여부
 * @return
 */
function chk_rjct(ALMSG_YN) {
	if (sheetObjects[6].RowCount > 0
			&& sheetObjects[6].CellValue(1, 'tml_inv_rjct_sts_cd') != undefined
			&& sheetObjects[6].CellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
		if (ALMSG_YN != undefined && ALMSG_YN == 'Y') {
			ComShowMessage(ComGetMsg('TES40035')); // ComShowMessage('reject된  상태!');
		}
		return false;
	}
	return true;
}

/**
 * 조회
 * @param {string}	REMOVE_YN	삭제여부
 * @return
 */
function retrieve(REMOVE_YN) {
	try {

		var formObj = document.form;
		if (fnChkSearchForm()) {

			cntr_list_onchange_cnt = 1;
			if (REMOVE_YN != undefined && REMOVE_YN.trim() == 'Y') {

				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
				sheetObjects[6].RemoveAll();
				sheetObjects[7].RemoveAll();
				sheetObjects[8].RemoveAll();

			}

			formObj.t3sht_tot_inv_amt.value = '';
			formObj.t4sht_tot_inv_amt.value = '';
			formObj.t5sht_tot_inv_amt.value = '';

			// main hidden sheet - 기본정보조회
			doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH);

		}
	} catch (e) {
	}
}

/**
 * COIN,DSCP sheet 조회
 * @return
 */
function retrieveCntrList() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); // COIN,DSCP - 조회
}

/**
 * FP sheet 조회
 * @return
 */
function retrievePoolDtlList() {
	doActionIBSheet5(sheetObjects[4], document.form, IBSEARCH); // FP만 - 조회
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 * @return
 */
function processButtonClick() {

	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var sheetObject4 = sheetObjects[4];
	var sheetObject5 = sheetObjects[5]; // main_hidden
	var sheetObject6 = sheetObjects[6]; // rjct_hidden
	var sheetObject7 = sheetObjects[7]; // conf_hidden
	var sheetObject8 = sheetObjects[8]; // dupchk_hidden

	/** **************************************************** */
	var formObj = document.form;

	try {

		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
		case "btn_pre_inquiry_cond":
			var url_str = 'ESD_TES_0013.do';
			url_str += '?pgmNo=ESD_TES_0013';
			url_str += '&pre_cond_inv_no='+document.form.pre_cond_inv_no.value;
			url_str += '&pre_cond_inv_date_type='+document.form.pre_cond_inv_date_type.value;
			url_str += '&pre_cond_fm_prd_dt='+document.form.pre_cond_fm_prd_dt.value;
			url_str += '&pre_cond_to_prd_dt='+document.form.pre_cond_to_prd_dt.value;
			url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
			url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
			url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
			url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
			url_str += '&pre_cond_tml_inv_sts_cd='+document.form.pre_cond_tml_inv_sts_cd.value;
			url_str += '&pre_cond_csr_no='+document.form.pre_cond_csr_no.value;
			url_str += '&pre_cond_csr_status='+document.form.pre_cond_csr_status.value;
			url_str += '&pre_cond_tml_inv_rjct_sts_cd='+document.form.pre_cond_tml_inv_rjct_sts_cd.value;
			location.href = url_str;
		break;
		
		case "btn_retrieve":
			retrieve('Y');
			break;

		case "btn_vndr":

			if (formObj.vndr_seq.readOnly == true) {
				return false;
			}
			// if (!chk_rjct('Y')){ return false; }

			var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
			var classId = "COM_ENS_0C1";
			var param = '?classId=' + classId;
			var chkStr = dispaly.substring(0, 3);

			// radio PopUp
			if (chkStr == "1,0") {
				ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 620, 480, 'getVender', dispaly, true);
			} else {
				ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을 띄우기dispaly속성 정보가  부족합니다.");
				return;
			}
			break;

		case "btn_yard":
			if (formObj.yd_cd.readOnly == true) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (!chk_conf('Y')) {
				return false;
			}

			var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
			var classId = "COM_ENS_061";
			var param = '?classId=' + classId;
			var chkStr = dispaly.substring(0, 3)

			// radio PopUp
			if (chkStr == "1,0") {
				ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 480, 'getYard',
						dispaly, true);
			} else {
				ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
				return;
			}
			break;

		case "btn_cost_ofc_cd":
			if (formObj.cost_ofc_cd.readOnly == true) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (!chk_conf('Y')) {
				return false;
			}

			var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1'; // "1,0,1,1,0,1,1,1";
			var classId = "COM_ENS_071";
			var param = '?classId=' + classId;
			var chkStr = dispaly.substring(0, 3)

			// radio PopUp
			if (chkStr == "1,0") {
				ComOpenPopup('/hanjin/COM_ENS_071.do' + param, 775, 455,
						'getOfcCd', dispaly, true);
			} else {
				ComShowMessage(ComGetMsg('TES21906')); // ComShowMessage("팝업을
													// 띄우기dispaly속성 정보가
													// 부족합니다.");
				return;
			}
			break;

		case "btn_new":
			try {
				tes_removeTESCommonALLIframes();
				tes_removeTESInvoiceCommonALLIframes();
			} catch (e){
			}			
			cntr_list_onchange_cnt = 1;
			confirm_done = false;
			save_conf_01 = false;
			tes_new0004();
			document.form.vndr_seq.focus();
			break;

		case "btn_copy":
			cntr_list_onchange_cnt = 1;
			confirm_done = false;
			save_conf_01 = false;
			disablePage2();
			if (document.form.vndr_seq.value != null
					&& document.form.vndr_seq.value != '') {
				document.form.inv_no.focus();
			} else {
				document.form.vndr_seq.focus();
			}
			break;

		case "btn_save":
			if (!chk_rjct('Y')) {
				return false;
			}
			if (!chk_conf('Y')) {
				return false;
			}
			if (fnChkForm()) {
				try {
					setCalcCostCond();
				} catch (e) {
					ComShowMessage(e);
					return false;
				}
				doActionMainHiddenSheet(sheetObject5, formObj, IBSAVE);
				cntr_list_onchange_cnt = 1;
			}
			break;

		case "btns_calendar1":
			if (!chk_conf('Y')) {
				return false;
			}
			if (formObj.fm_prd_dt.readOnly == true) {
				return false;
			} 
			if (!chk_rjct('Y')) {
				return false;
			}
			
			var cal = new ComCalendar();
	
			cal.select(formObj.fm_prd_dt, 'yyyy-MM-dd');
			break;

		case "btns_calendar2":
			if (!chk_conf('Y')) {
				return false;
			}
			if (formObj.to_prd_dt.readOnly == true) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var cal = new ComCalendar();
			cal.select(formObj.to_prd_dt, 'yyyy-MM-dd');
			break;

		case "btns_calendar3":
			if (!chk_conf('Y')) {
				return false;
			}
			if (formObj.iss_dt.readOnly == true) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var cal = new ComCalendar();
			cal.select(formObj.iss_dt, 'yyyy-MM-dd');
			break;

		case "btns_calendar4":
			if (!chk_conf('Y')) {
				return false;
			}
			if (formObj.rcv_dt.readOnly == true) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var cal = new ComCalendar();
			cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
			break;

		case "btns_calendar5":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var cal = new ComCalendar();
			cal.select(formObj.cal5, 'yyyy-MM-dd');
			break;

		case "btns_remarks":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			
			if (formObj.hld_flg.checked == true) {
				ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk', 300, 150, '', display, true);
			}
			break;

		case "t1btng_listclear":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.RowCount > 0 || sheetObject1.RowCount > 0
					|| sheetObject2.RowCount > 0 || sheetObject3.RowCount > 0) {
				/* 동시에 COIN, DSCP, CALC.TMNL, CALC.BYDAY sheet의 data를 삭제해야합니다. */
				// if (confirm('Coincidence, Discrepancy, Cost Calc.(TMNL), Cost
				// Calc.(SR by FD) Tab의 모든 Data를 삭제할까요?')){
				if (confirm(ComGetMsg('TES24053'))) {
					removeOffdockCYInvoice01();
				}
			} else {
				ComShowMessage(ComGetMsg('TES23015')); // ComShowMessage('삭제할 data가
													// 없습니다.');
			}
			break;

		case "t1btng_fileimport":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (formObj.vndr_seq.value == undefined
					|| formObj.vndr_seq.value == null
					|| formObj.vndr_seq.value.trim() == ''
					|| formObj.yd_cd.value == undefined
					|| formObj.yd_cd.value == null
					|| formObj.yd_cd.value.trim() == '') {
				ComShowMessage(ComGetMsg('TES40025', 'VNDR Code/YD_CD')); // ComShowMessage('VNDR
																		// Code/YD_CD를
																		// 입력하십시오.');
				return false;
			}
			if (formObj.fm_prd_dt.value == undefined
					|| formObj.fm_prd_dt.value == null
					|| formObj.fm_prd_dt.value.trim() == ''
					|| formObj.to_prd_dt.value == undefined
					|| formObj.to_prd_dt.value == null
					|| formObj.to_prd_dt.value.trim() == '') {
				ComShowMessage(ComGetMsg('TES24016')); // ComShowMessage('Period
													// 시작일과 종료일을 입력하십시오.');
				return false;
			}
			if (!checkPeriodFormat(formObj.fm_prd_dt.value)
					|| !tes_isValidDateObject(formObj.fm_prd_dt.value, '-')) {
				ComShowMessage(ComGetMsg('TES24011')); // ComShowMessage('날짜 형식이
													// 잘못되었습니다.');
				formObj.fm_prd_dt.focus();
				return false;
			}
			if (!checkPeriodFormat(formObj.to_prd_dt.value)
					|| !tes_isValidDateObject(formObj.to_prd_dt.value, '-')) {
				ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이
													// 잘못되었습니다.');
				formObj.to_prd_dt.focus();
				return false;
			}
			var tml_cost_grp_cd;
			var tml_calc_ind_cd;
			var sto_dys_ind_cd;
			if (sheetObjects[5].RowCount == 1) {
				tml_cost_grp_cd = sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');
				tml_calc_ind_cd = sheetObjects[5].CellValue(1, 'tml_calc_ind_cd');
				sto_dys_ind_cd = sheetObjects[5].CellValue(1, 'sto_dys_ind_cd');
			} else {
				ComShowMessage(ComGetMsg('TES23017')); // ComShowMessage('기본정보 오류!!');
				return false;
			}
			var url = 'ESD_TES_9140FileImportPopup.screen';
			url = url + '?tml_so_ofc_cty_cd='
					+ sheetObjects[5].CellValue(1, 'tml_so_ofc_cty_cd')
					+ '&tml_so_seq=' + sheetObjects[5].CellValue(1, 'tml_so_seq');
			url = url + '&vndr_seq=' + formObj.vndr_seq.value + '&yd_cd='
					+ formObj.yd_cd.value + '&inv_no=' + formObj.inv_no.value;
			url = url + '&fm_prd_dt=' + formObj.fm_prd_dt.value + '&to_prd_dt='
					+ formObj.to_prd_dt.value + '&rcv_dt='
					+ formObj.rcv_dt.value;
			url = url + '&tml_cost_grp_cd=' + tml_cost_grp_cd
					+ '&tml_calc_ind_cd=' + tml_calc_ind_cd
					+ '&sto_dys_ind_cd=' + sto_dys_ind_cd;
			url = url + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;

			window.showModalDialog(url, window, "dialogWidth:610px; dialogHeight:470px; help:no; status:no; resizable:yes;");
			break;

		case "t1btng_save":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.RowCount > 0) {
				/* 동시에 COIN과 DSCP sheet를 저장해야합니다. */
				var params = new Array();
				params[0] = sheetObjects[0].GetSaveString(false, false);
				params[1] = sheetObjects[1].GetSaveString(false, false);
				var sheets = new Array();
				sheets[0] = sheetObjects[0];
				sheets[1] = sheetObjects[1];

				// 대상 sheet의 변경 여부를 확인한당.
				if (!tes_isModified(sheets, params)) {
					ComShowMessage(ComGetMsg('TES23018')); // ComShowMessage("[1] 변경된 내역이 없습니다.");
					break;
				}

				// 수정 가능 data가 수정되었는지 여부 확인 및 계산된 data삭제하기
				if (t1sheet1_ChkMod()) {
					// if (confirm('Cal Tab의 Auto Calculation Data가 clear됩니다.
					// 그래도 수정하시겠습니까?')){
					if (confirm(ComGetMsg('TES24070'))) {
						removeAutoCalcData();
					} else {
						return false;
					}
				}

				var formObj = document.form;
				doActionIBSheet(sheetObject, formObj, IBSAVE);
			}
			break;

		case "t1btng_downexcel":
			doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
			break;

		case "t1btng_todiscrepancy":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var iCheckRow = '';
			if (sheetObject.RowCount > 0) {
				iCheckRow = sheetObject.FindCheckedRow('chk');

				if (iCheckRow != undefined && iCheckRow != null && iCheckRow != '') {
					var arrRow = iCheckRow.split("|");
					
					if (iCheckRow != null && arrRow.length > 1) {
						for ( var idx = 0; idx < arrRow.length - 1; idx++) {
							sheetObject.CellValue2(arrRow[idx], 'vrfy_rslt_ind_cd') = 'DC';
							sheetObject.CellValue2(arrRow[idx], 'modi_flg') = '';
						}

//						tes_copy_rows_to(sheetObject, sheetObject1, 'chk', sheetObject.GetSaveString(false, false, 'chk'), true);
						tes_copy_rows_to2(sheetObject1, sheetObject.GetSaveString(false, false, 'chk'), true);
						
						sheetObject1.ColumnSort("dscr_ind_cd", "ASC");
						for ( var i = (arrRow.length - 2); arrRow != null && i >= 0; i--) {
							sheetObject.RowDelete(arrRow[i], false);
						}
						setCoinShtStat();
					}
				} else {
					ComShowMessage(ComGetMsg('TES23019')); // ComShowMessage('선택된 row가 없습니다.');
				}
			}
			break;

		case "t1btng_costcalc":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}

			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.Enable == false) {
				return false;
			}

			if (sheetObject.RowCount > 0) {

				curr_chk = false; // reset

				if (sheetObjects[5].RowCount == 1) {
					if (sheetObjects[5].CellValue(1, 'curr_cd') != document.form.curr_cd.Code) {
						ComShowMessage(ComGetMsg('TES40002', 'Currency'));
						return false;
					}
				} else {
					return false;
				}

				// 계산에서 Type/Size 값은 필수 항목
				for ( var i = sheetObject.HeaderRows; i < (sheetObject.HeaderRows + sheetObject.RowCount); i++) {
					if (sheetObject.CellValue(i, 'cntr_tpsz_cd') == null
							|| sheetObject.CellValue(i, 'cntr_tpsz_cd').trim() == '') {
						ComShowMessage(ComGetMsg('TES40016', 'Type/Size')); // ComShowMessage('Type/Size을 다 입력하십시오.');
						return false;
					}
				}

				// 계산에서 F/M 값은 필수 항목
				for ( var i = sheetObject.HeaderRows; i < (sheetObject.HeaderRows + sheetObject.RowCount); i++) {
					if (sheetObject.CellValue(i, 'cntr_sty_cd') == null
							|| sheetObject.CellValue(i, 'cntr_sty_cd').trim() == '') {
						ComShowMessage(ComGetMsg('TES40016', 'F/M')); // ComShowMessage('F/M을 다 입력하십시오.');
						return false;
					}
				}

				// 계산에서 DG 값은 필수 항목 - TML 계산시 DCGO_CLSS_CD는 ROW를 분리하는 기준이면서
				// RVIS_VOL의 기준이 되므로 반드시 필수값으로 받아야한다.
				for ( var j = sheetObject.HeaderRows; j < (sheetObject.HeaderRows + sheetObject.RowCount); j++) {
					if (sheetObject.CellValue(j, 'dcgo_clss_cd') == null
							|| sheetObject.CellValue(j, 'dcgo_clss_cd').trim() == '') {
						ComShowMessage(ComGetMsg('TES40016', 'DG')); // ComShowMessage('DG를 다 입력하십시오.');
						return false;
					}
				}

				// COIN과 DSCP에 아직 DB에 저장하지 않은 ROW를 확인하고 전부 저장된 상태이면 CALC를 허용한다.
				var sheets = new Array();
				sheets[0] = sheetObjects[0];
				sheets[1] = sheetObjects[1];
				if (!tes_isAllDataSaved(sheets)) {
					ComShowMessage(ComGetMsg('TES23020')); // ComShowMessage('아직 저장하지 않은 data가 있습니다. 먼저 저장하십시오.');
					return false;
				}

				var params = new Array();
				params[0] = sheetObjects[0].GetSaveString(false, false);
				params[1] = sheetObjects[1].GetSaveString(false, false);
				if (tes_isModified(sheets, params)) {
					ComShowMessage(ComGetMsg('TES23021')); // ComShowMessage('수정한 data가 있습니다. 먼저 저장하십시오.');
					return false;
				}

				if (formObj.fm_prd_dt.value == undefined
						|| formObj.fm_prd_dt.value == null
						|| formObj.fm_prd_dt.value.trim() == '') {
					ComShowMessage(ComGetMsg('TES23022')); // ComShowMessage('Period의 시작일을 입력하셔야 합니다.');
					return false;
				} else {
					if (!checkPeriodFormat(formObj.fm_prd_dt.value)
							|| !tes_isValidDateObject(formObj.fm_prd_dt.value,
									'-')) {
						ComShowMessage(ComGetMsg('TES23011')); // ComShowMessage('날짜 형식이 잘못되었습니다.');
						formObj.fm_prd_dt.focus();
						return false;
					}
				}

				var cost_calc_tmnl = false;
				var cost_calc_day = false;
				var cost_calc_pool = true;
				var curr_tab_idx = 0;

				if (formObj.TMNL.checked == true) {
					cost_calc_tmnl = true;
					curr_tab_idx = 2;
				} else {
					cost_calc_tmnl = false;
				}
				if (formObj.StorageDay.checked == true) {
					cost_calc_day = true;
					if (formObj.TMNL.checked == false) {
						curr_tab_idx = 3;
					}
				} else {
					cost_calc_day = false;
					if (formObj.TMNL.checked == false) {
						curr_tab_idx = 4;
					}
				}

				if (!cost_calc_tmnl && !cost_calc_day) {
					ComShowMessage(ComGetMsg('TES23023')); // ComShowMessage('계산 방식을 정하지 않았습니다.');
					return false;
				}
				
				if (isAutoCalcDataExisting()) {
					// if (confirm('Cal Tab의 Auto Calculation Data가 clear됩니다. 그래도 수정하시겠습니까?')){
					if (confirm(ComGetMsg('TES24070'))) {
						removeAutoCalcData();
					} else {
						return false;
					}
				}

				// agreement의 status를 검사하여 계산을 허용하고 아니면 거부한다.
				if (!isValidAgmtSts()) {
					return false;
				}

				setSheetsEnable(curr_tab_idx, true);

				doActionIBSheetCalc(sheetObject2, formObj, IBSEARCH);

			} else {
				ComShowMessage(ComGetMsg('TES23024')); // ComShowMessage('처리할 data가 없습니다.');
			}
			break;

		case "t2btng_listclear":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.RowCount > 0 || sheetObject1.RowCount > 0
					|| sheetObject2.RowCount > 0 || sheetObject3.RowCount > 0) {
				/* 동시에 COIN, DSCP, CALC.TMNL, CALC.BYDAY sheet의 data를 삭제해야합니다. */
				// if (confirm('Coincidence, Discrepancy, Cost Calc.(TMNL), Cost
				// Calc.(SR by FD) Tab의 모든 Data를 삭제할까요?')){
				if (confirm(ComGetMsg('TES23053'))) {
					removeOffdockCYInvoice01();
				}
			} else {
				ComShowMessage(ComGetMsg('TES23015')); // ComShowMessage('삭제할 data가 없습니다.');
			}
			break;

		case "t2btng_coincidence":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
		
			var iCheckRow = '';
			var needDigit = false;
			
			if (sheetObject1.RowCount > 0) {
				iCheckRow = sheetObject1.FindCheckedRow('chk');
				if (iCheckRow != undefined && iCheckRow != null
						&& iCheckRow != '') {
					var arrRow = iCheckRow.split("|");
					if (iCheckRow != null && arrRow.length > 1) {

						for ( var idx = 0; idx < arrRow.length - 1; idx++) {
							sheetObject1.CellValue2(arrRow[idx], 'vrfy_rslt_ind_cd') = 'CO';
							sheetObject1.CellValue2(arrRow[idx], 'modi_flg') = 'Y';
							
							if( sheetObject1.CellValue(arrRow[idx], 'cntr_no').length <= 10){
								needDigit = true;
							} 
							
						}
						
						if(needDigit){
							alert("Wrong Container NO exists, Please click CHK Dgit before verify process.");
							return false;
						}
						
//						tes_copy_rows_to(sheetObject1, sheetObject, 'chk', sheetObject1.GetSaveString(false, false, 'chk'), true);
						tes_copy_rows_to2(sheetObject, sheetObject1.GetSaveString(false, false, 'chk'), true);
						
						setCoinShtStat();
						for ( var i = (arrRow.length - 2); arrRow != null
								&& i >= 0; i--) {
							sheetObject1.RowDelete(arrRow[i], false);
						}
					}
				} else {
					ComShowMessage(ComGetMsg('TES23019')); // ComShowMessage('선택된 row가 없습니다.');
				}
			}
			break;
			
		case "t2btng_chkdgit":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			var iCheckRow = '';
			if (sheetObject1.RowCount > 0) {
				doActionIBSheet2(sheetObject1,formObj,IBSEARCH_ASYNC01);
			}
			break;			
			

		case "t2btng_reject":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			
			ComOpenPopup('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 300, 150, '', display, true );
			break;

		case "t2btng_print":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			// ComShowMessage('t2btng_print');
			// return;
			if (sheetObject1.RowCount > 0) {
				printDiscrepancyContainerList();
			} else {
				ComShowMessage(ComGetMsg('TES23026')); // ComShowMessage('출력할 data가
													// 없습니다.');
				return false;
			}
			break;

		case "t2btng_downexcel":
			doActionIBSheet2(sheetObject1, formObj, IBDOWNEXCEL);
			break;

		case "t2btng_rowadd":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			doActionIBSheet2(sheetObject1, formObj, IBINSERT);
			break;

		case "t3btng_costCal":
		     var param = "?yd_cd="+formObj.yd_cd.value +"&vndr_seq="+formObj.vndr_seq.value+"&vndr_seq_nm="+formObj.vndr_seq_nm.value+"&fm_prd_dt="+formObj.fm_prd_dt.value+"&to_prd_dt="+formObj.to_prd_dt.value+"&prgm_id=ESD_TES_0004_1&cost_cd_inv_tp_cd=OT";

		   //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
		    ComOpenPopup("ESD_TES_9001.do" + param,   820,    670,     "setCostCode2",  "1,0,1,1,1,1,1", true,   false,    null, null,  null,     'Cost Calculation','no');
		    break;	
     	
		case "t3btng_listclear":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.RowCount > 0 || sheetObject1.RowCount > 0
					|| sheetObject2.RowCount > 0 || sheetObject3.RowCount > 0) {
				/* 동시에 COIN, DSCP, CALC.TMNL, CALC.BYDAY sheet의 data를 삭제해야합니다. */
				// if (confirm('Coincidence, Discrepancy, Cost Calc.(TMNL), Cost
				// Calc.(SR by FD) Tab의 모든 Data를 삭제할까요?')){
				if (confirm(ComGetMsg('TES23053'))) {
					removeOffdockCYInvoice01();
				}
			} else {
				ComShowMessage(ComGetMsg('TES23015')); // ComShowMessage('삭제할 data가
													// 없습니다.');
			}
			break;

		case "t3btng_rowadd":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet3(sheetObject2, formObj, IBINSERT);
			break;

		case "t3btng_rowdel":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet3(sheetObject2, formObj, IBDELETE);
			break;

		case "t3btng_save":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			
			for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
				 var costCd = sheetObject2.CellValue(i,'lgs_cost_cd');
				 var calRmk = sheetObject2.CellValue(i,'calc_rmk').trim();
				 
				//2011.05.11 COST_CD가 'SVSCRF','TMRFGO','TMRFMO','TMRFPL','TMRFPT','TMRFXX'이면 TYPE/SIZE를 넣어야한다.
				// CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13
				 var tpsz = sheetObject2.CellValue(i,'cntr_tpsz_cd').trim();
				// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
				 if(sheetObject2.RowStatus(i) != 'D' && CostCdValidForCalcTpSz(costCd, tpsz) == false /*&& (sheetObject2.CellValue(i,'vol_tr_ut_cd')=="C" || sheetObject2.CellValue(i,'vol_tr_ut_cd')=="")*/){
					 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
					 return false;
				 }	

				 if(costCd == undefined || costCd == null || costCd == ''){
					 ComShowMessage("Not Selected cost code");
					 return false;
				 }
				 
				 if (sheetObject2.RowStatus(i) != 'D' && CostCdValidForCalcTpSz(costCd, tpsz) == undefined) {
					 // TES: AGMT에서 minus rate 허용 (CGSLSL) ( CHM-201431680 )
					 // UOM이 C인경우만, cntr tpsz입력 mandatory - (YSY B : 4347.09.22)
					// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
					 //if ( sheetObject2.CellValue(i, 'vol_tr_ut_cd') == "C" ) { 
						 if(tpsz == undefined || tpsz == null || tpsz == '') {
							 ComShowMessage("Not Selected Type/Size");
							 return false;
						 }
					 //}
				 }
				 
//				 if(CostCdValidForCalcRemark('OF1',costCd,calRmk) == false){
//					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
//					 return false;
//				 }	
				 //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
				 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, OF 화면에서 Y인 경우는 Remark값이 필수 
				 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && calRmk.length < 10) {
					 ComShowMessage(ComGetMsg('TES10128'));
					 return false;
				 }
				 
				 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
					 return false;
				 }
				 
//				 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0)){
//					 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//						 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//						 return false;
//					 }
//				 }				 
				 
//				 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }	
				 
			}
			
			doActionIBSheet3(sheetObject2, formObj, IBSAVE);
			break;

		case "t3btng_totalamount":
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			var url_str = 'ESD_TES_9050Popup.screen';
			url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
			url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
			// window.open(url_str, 'popup_rev_calc_vol', 'width=600px, height=400px, location=0, status=0, resizable=1');
			window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			break;

		case "t3btng_confirm":
			if (confirm_done) {
				ComShowMessage(ComGetMsg('TES23027')); // ComShowMessage('이미 confirm되어 있습니다.');
				return false;
			}
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			
			//2011.05.11 COST_CD가 'SVSCRF','TMRFGO','TMRFMO','TMRFPL','TMRFPT','TMRFXX'이면 TYPE/SIZE를 넣어야한다.
			// CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13
			for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
				
				 var costCd = sheetObject2.CellValue(i,'lgs_cost_cd');
				 var tpsz = sheetObject2.CellValue(i,'cntr_tpsz_cd').trim();
				 var calRmk = sheetObject2.CellValue(i,'calc_rmk').trim();
				 
				// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
				 if(CostCdValidForCalcTpSz(costCd, tpsz) == false  /*&& (sheetObject2.CellValue(i,'vol_tr_ut_cd')=="C" || sheetObject2.CellValue(i,'vol_tr_ut_cd')=="")*/){
					 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
					 return false;
				 }
				 
//				 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0)){
//					 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//						 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//						 return false;
//					 }
//				 }				 
				 
//				 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }	
				 //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
				 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, OF 화면에서 Y인 경우는 Remark값이 필수 
				 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && calRmk.length < 10) {
					 ComShowMessage(ComGetMsg('TES10128'));
					 return false;
				 }
				 
				 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
					 return false;
				 }
				 
				 //[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화 
				 if(sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGSC' || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGWC'
					 || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGPF' || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGXX'){
					 if(sheetObject2.CellValue(i,'n3pty_flg') == '' || sheetObject2.CellValue(i,'n3pty_flg') != 'Y'){
						 ComShowMessage(ComGetMsg('TES21702'));
						 return false;
					 }
				 }
				 
			}
			
			doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
			break;

		case "t4btng_costCal":
		     var param = "?yd_cd="+formObj.yd_cd.value +"&vndr_seq="+formObj.vndr_seq.value+"&vndr_seq_nm="+formObj.vndr_seq_nm.value+"&fm_prd_dt="+formObj.fm_prd_dt.value+"&to_prd_dt="+formObj.to_prd_dt.value+"&prgm_id=ESD_TES_0004_2&cost_cd_inv_tp_cd=OS";
		     
		   //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
		    ComOpenPopup("ESD_TES_9001.do" + param,   820,    670,     "setCostCode",  "1,0,1,1,1,1,1", true,   false,    null, null,  null,     'Cost Calculation','no');
		    break;			
      	
		case "t4btng_listclear":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject.RowCount > 0 || sheetObject1.RowCount > 0
					|| sheetObject2.RowCount > 0 || sheetObject3.RowCount > 0) {
				/* 동시에 COIN, DSCP, CALC.TMNL, CALC.BYDAY sheet의 data를 삭제해야합니다. */
				// if (confirm('Coincidence, Discrepancy, Cost Calc.(TMNL), Cost
				// Calc.(SR by FD) Tab의 모든 Data를 삭제할까요?')){
				if (confirm(ComGetMsg('TES23053'))) {
					removeOffdockCYInvoice01();
				}
			} else {
				ComShowMessage(ComGetMsg('TES23015')); // ComShowMessage('삭제할 data가
													// 없습니다.');
			}
			break;

		case "t4btng_rowadd":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet4(sheetObject3, formObj, IBINSERT);
			break;

		case "t4btng_rowdel":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet4(sheetObject3, formObj, IBDELETE);
			break;

		case "t4btng_save":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			
			for(var i = sheetObject3.HeaderRows; i<sheetObject3.HeaderRows + sheetObject3.RowCount; i++){
				 var costCd = sheetObject3.CellValue(i,'lgs_cost_cd');
				 var calRmk = sheetObject3.CellValue(i,'calc_rmk').trim();

//				 if(CostCdValidForCalcRemark('OF2',costCd,calRmk) == false){
//					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
//					 return false;
//				 }

				 if(sheetObject3.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
					 return false;
				 }

//				 if(sheetObject3.CellValue(i,'calc_tp_cd') == "M" && (sheetObject3.CellValue(i,'ovr_dys')==null || sheetObject3.CellValue(i,'ovr_dys')==0)){
//						 ComShowMessage("Plz, input Over Days. Zero or Null does not allow.");
//						 return false;
//				 }
				 
//				 if( sheetObject3.CellValue(i,'calc_tp_cd') == "M" && (sheetObject3.CellValue(i,'ctrt_rt')==null || sheetObject3.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }	
				 
			}
			
			doActionIBSheet4(sheetObject3, formObj, IBSAVE);
			break;

		case "t4btng_totalamount":
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			var url_str = 'ESD_TES_9050Popup.screen';
			url_str = url_str + '?tml_so_ofc_cty_cd='
					+ formObj.tml_so_ofc_cty_cd.value;
			url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
			// window.open(url_str, 'popup_rev_calc_vol', 'width=600px,
			// height=400px, location=0, status=0, resizable=1');
			window
					.showModalDialog(url_str, window,
							"dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			break;

		case "t4btng_confirm":
			if (confirm_done) {
				ComShowMessage(ComGetMsg('TES23027')); // ComShowMessage('이미
													// confirm되어 있습니다.');
				return false;
			}
			// ComShowMessage("t4btng_confirm");
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			
			
			for(var i = sheetObject3.HeaderRows; i<sheetObject3.HeaderRows + sheetObject3.RowCount; i++){
//				 if(sheetObject3.CellValue(i,'calc_tp_cd') == "M" && (sheetObject3.CellValue(i,'ovr_dys')==null || sheetObject3.CellValue(i,'ovr_dys')==0)){
//					 ComShowMessage("Plz, input Over Days. Zero or Null does not allow.");
//					 return false;
//				 }
				 
//				 if( sheetObject3.CellValue(i,'calc_tp_cd') == "M" && (sheetObject3.CellValue(i,'ctrt_rt')==null || sheetObject3.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }	
				
				//[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화 
				if(sheetObject3.CellValue(i,'lgs_cost_cd') == 'TMVGSC' || sheetObject3.CellValue(i,'lgs_cost_cd') == 'TMVGWC'
					|| sheetObject3.CellValue(i,'lgs_cost_cd') == 'TMVGPF' || sheetObject3.CellValue(i,'lgs_cost_cd') == 'TMVGXX'){
					if(sheetObject3.CellValue(i,'n3pty_flg') == '' || sheetObject3.CellValue(i,'n3pty_flg') != 'Y'){
						ComShowMessage(ComGetMsg('TES21702'));
						return false;
					}
				}	 
			}
						
			
			doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
			break;

		case "t5btng_listclear":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (sheetObject4.RowCount > 0) {
				/* CALC.ByPool sheet의 data를 삭제해야합니다. */
				// if (confirm('Cost Calc.(SR by FP) Tab의 모든 Data를 삭제할까요?')){
				if (confirm(ComGetMsg('TES40012'))) {
					removeOffdockCYInvoice02();
				}
			} else {
				ComShowMessage(ComGetMsg('TES23015')); // ComShowMessage('삭제할 data가 없습니다.');
			}
			break;
			
		case "t5btng_rowadd":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet5(sheetObject4, formObj, IBINSERT);
			break;

		case "t5btng_rowdel":
			if (!chk_conf('Y')) {
				return false;
			}
			doActionIBSheet5(sheetObject4, formObj, IBDELETE);
			break;

		case "t5btng_save":		
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}

			for(var i = sheetObject4.HeaderRows; i<sheetObject4.HeaderRows + sheetObject4.RowCount; i++){
				 var costCd = sheetObject4.CellValue(i,'lgs_cost_cd');
				 var calRmk = sheetObject4.CellValue(i,'calc_rmk').trim();
												 
//				 if(CostCdValidForCalcRemark('OF3',costCd,calRmk) == false){
//					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
//					 return false;
//				 }
				 if(sheetObject4.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
					 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
					 return false;
				 }

//				 if(sheetObject4.CellValue(i,'calc_tp_cd') == "M" && sheetObject4.CellValue(i,'ovr_vol_qty')==null || sheetObject4 .CellValue(i,'ovr_vol_qty')==0){
//						 ComShowMessage("Plz, input Over Vol. Zero or Null does not allow.");
//						 return false;
//				 }
			 
//				 if( sheetObject4.CellValue(i,'calc_tp_cd') == "M" && (sheetObject4.CellValue(i,'ctrt_rt')==null || sheetObject4.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }		
				 
			}
			
			doActionIBSheet5(sheetObject4, formObj, IBSAVE);
			break;

		case "t5btng_fileimport":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (formObj.vndr_seq.value == undefined
					|| formObj.vndr_seq.value == null
					|| formObj.vndr_seq.value.trim() == ''
					|| formObj.yd_cd.value == undefined
					|| formObj.yd_cd.value == null
					|| formObj.yd_cd.value.trim() == '') {
				ComShowMessage(ComGetMsg('TES40025', 'VNDR Code/YD_CD')); // ComShowMessage('VNDR Code/YD_CD를 입력하십시오.');
				return false;
			}
			if (formObj.fm_prd_dt.value == undefined
					|| formObj.fm_prd_dt.value == null
					|| formObj.fm_prd_dt.value.trim() == ''
					|| formObj.to_prd_dt.value == undefined
					|| formObj.to_prd_dt.value == null
					|| formObj.to_prd_dt.value.trim() == '') {
				ComShowMessage(ComGetMsg('TES24016')); // ComShowMessage('Period 시작일과 종료일을 입력하십시오.');
			}
			if (sheetObjects[5].RowCount == 1) { // currency가 저장되었는지 확인
				if (sheetObjects[5].CellValue(1, 'curr_cd') != document.form.curr_cd.Code) {
					ComShowMessage(ComGetMsg('TES40002', 'Currency'));
					return false;
				}
			} else {
				return false;
			}
			var url = 'ESD_TES_9150FileImportPopup.screen';
			url = url + '?tml_so_ofc_cty_cd='
					+ sheetObjects[5].CellValue(1, 'tml_so_ofc_cty_cd')
					+ '&tml_so_seq=' + sheetObjects[5].CellValue(1, 'tml_so_seq');
			url = url + '&vndr_seq=' + formObj.vndr_seq.value + '&yd_cd='
					+ formObj.yd_cd.value + '&fm_prd_dt='
					+ formObj.fm_prd_dt.value + '&to_prd_dt='
					+ formObj.to_prd_dt.value;
			url = url + '&curr_cd=' + formObj.curr_cd.Code;
			window.showModalDialog(url, window, "dialogWidth:410px; dialogHeight:465px; help:no; status:no; resizable:yes;");
			break;

		case "t5btng_totalamount":
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			var url_str = 'ESD_TES_9050Popup.screen';
			url_str = url_str + '?tml_so_ofc_cty_cd='
					+ formObj.tml_so_ofc_cty_cd.value;
			url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
			// window.open(url_str, 'popup_rev_calc_vol', 'width=600px,
			// height=400px, location=0, status=0, resizable=1');
			window
					.showModalDialog(url_str, window,
							"dialogWidth:610px; dialogHeight:420px; help:no; status:no; resizable:yes;");
			break;

		case "t5btng_reject":
			if (!chk_conf('Y')) {
				return false;
			}
			if (!chk_rjct('Y')) {
				return false;
			}
			if (!save_conf_01) {
				return false;
			}
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			
			ComOpenPopup('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 300, 150, '', display, true);
			break;

		case "t5btng_confirm":
			if (confirm_done) {
				ComShowMessage(ComGetMsg('TES23027')); // ComShowMessage('이미
													// confirm되어 있습니다.');
				return false;
			}
			// ComShowMessage("t5btng_confirm");
			if (sheetObject5.RowCount != 1) {
				return false;
			}
			
			for(var i = sheetObject4.HeaderRows; i<sheetObject4.HeaderRows + sheetObject4.RowCount; i++){
//				 if(sheetObject4.CellValue(i,'ovr_vol_qty')==null || sheetObject4 .CellValue(i,'ovr_vol_qty')==0){
//						 ComShowMessage("Plz, input Over Vol. Zero or Null does not allow.");
//						 return false;
//				 }
				 
//				 if( sheetObject4.CellValue(i,'calc_tp_cd') == "M" && (sheetObject4.CellValue(i,'ctrt_rt')==null || sheetObject4.CellValue(i,'ctrt_rt')==0.00)){
//					 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//					 return false;
//				 }	 
				 
			}
			
			doActionConfirmHiddenSheet(sheetObject7, formObj, IBSAVE);
			break;

		} // end switch
	} catch (e) {
		ComShowMessage(e);
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('TES23028')); // ComShowMessage("지금은 사용하실 수가  없습니다 ");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * vender name 설정
 * @param rowArray
 * @return
 */
function getVender(rowArray) {
	var colArray = rowArray[0];
	document.all.vndr_seq.value = (colArray[2] != undefined
			&& colArray[2] != null ? colArray[2] : '');
	document.all.vndr_seq_nm.value = (colArray[4] != undefined
			&& colArray[4] != null ? colArray[4] : '');
	
	var idaGstRgstSte = colArray[10];
	if(idaGstRgstSte == 'R'){
		document.all.ida_gst_rgst_ste.value = "Registered";
	} else if(idaGstRgstSte == 'U') {
		document.all.ida_gst_rgst_ste.value = "Unregistered";
	} else if(idaGstRgstSte == 'C') {
		document.all.ida_gst_rgst_ste.value = "Composite";
	}
	
	document.all.ida_gst_rgst_no.value=colArray[11];
	document.all.ida_ste_cd.value=colArray[12];
	document.all.ida_ste_nm.value=colArray[13];
}

/**
 * yard name 설정
 * @param rowArray
 * @return
 */
function getYard(rowArray) {
	var colArray = rowArray[0];
	document.all.yd_cd.value = colArray[3];
	document.all.yd_nm.value = colArray[4];
	document.all.yd_cd_hidden.value = colArray[3];
	if (colArray[3] != undefined && colArray[3] != null
			&& colArray[3].trim() != '') {
		// checkValidYardCode()에서 yd_cd가 있다면 MDM_YARD의 OFC_CD를 가져와서 넣어준다.
		tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
	}
}

/**
 * Cost OFC 설정
 * @param rowArray
 * @return
 */
function getOfcCd(rowArray) {
	var colArray = rowArray[0];
	document.all.cost_ofc_cd.value = (colArray[3] != undefined
			&& colArray[3] != null ? colArray[3] : '');
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function setSheetObject(sheet_obj) {
	// ComShowMessage('setSheetObject');
	sheetObjects[sheetCnt++] = sheet_obj;
	sheetObjectsMap[sheet_obj.id]= sheet_obj;
}

/**
 * checked 여부 확인
 * @param {sheet}	shtObj	ibsheet
 * @param {string}	chk_nm	check box name
 * @return
 */
function confirmChecked(shtObj, chk_nm) {

	/*
	 * 넘어온 sheet에서 checkbox를 찾아서 checked되었는지 확인... 인자: 해당 sheet, checkbox명
	 */

	var chk_nm = (chk_nm == null && chk_nm == undefined) ? 'chk' : chk_nm; // checkbox명을 별도로 지정하지 않으면 'chk'이라고  한다.
	if (shtObj.RowCount > 0) {
		for ( var i = 1; i < shtObj.Rows; i++) // 제목은 제외
		{
			if (shtObj.CellValue(i, chk_nm) == 1) {
				return true; // 한개라도 checked된게 있으면 true를 return...
			}
		}
	}
	return false;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @return
 */
function loadPage() {
	disableForm();

	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
	try {
		tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
		tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
		tes_getInputValue('DB_DATE', SEARCH06, '');
	} catch (e) {
	}
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	try {
		//login user의 default office와 로그인한 office가 같은지 체크 
    	if(document.form.pre_cond_inv_no.value == ''){
    		tes_getInputValue('chk_ofc_cd', SEARCH25, '', 'checkLoginOfc');  
    	}
		tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');
	} catch (e) {
	}

	//document.form.vndr_seq.focus();
	document.form.tml_inv_rjct_sts_cd.value = document.form.tml_inv_rjct_sts_cd.value != null ? document.form.tml_inv_rjct_sts_cd.value: '';
	document.form.tml_inv_rjct_sts_cd.title = document.form.tml_inv_rjct_sts_cd.value != null ? tes_getInvRejectStsFullNm(document.form.tml_inv_rjct_sts_cd.value): '';

	//India Info Display
	if(ida_ofc_cd == 'Y'){
		document.all.IndiaLayer01.style.display = "inline";
		document.all.IndiaLayer02.style.display = "inline";
		
	} else {
		document.all.IndiaLayer01.style.display = "none";
		document.all.IndiaLayer02.style.display = "none";
		
	}
}

/**
 * [W.H.T] readonly 여부 사용할 전역변수 값 설정
 * @return
 */
function setWhldTaxAmtMode() {
	var formObj = document.form;
	var tmp = '';
	tmp = formObj.whld_tax_amt_mode.value;
	if (tmp != undefined && tmp != null && tmp.trim() == 'Y') {
		whld_tax_readonly_mode = false;
	} else {
		whld_tax_readonly_mode = true;
	}
}

/**
 * [W.H.T] readonly 여부 설정
 * @param {string}	YN_SET_BACKCOLOR	back color 설정 여부
 * @return
 */
function checkWhldTaxAmtMode(YN_SET_BACKCOLOR) {
	var formObj = document.form;
	formObj.whld_tax_amt.readOnly = whld_tax_readonly_mode;
	if (YN_SET_BACKCOLOR != undefined && YN_SET_BACKCOLOR.trim() == 'Y') {
		tes_setBackColorAllTextTypeReadonly(setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
	}
}

/**
 * [Currency] 따라 sheet data 속성 설정
 * @return
 */
function setCalcColFormat() {
	resetSheetDataProperty(comboObjects[0].Code);
}

/**
 * IBCombo Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {combo}	combo_obj	combo object
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo 기본 설정 Combo의 항목을 설정한다.
 * @param {combo}	comboObj	combo object
 * @param {int}		comboNo		combo index
 * @param {string}	combo_val	combo value
 * @param {string}	def_val		default value
 * @return
 */
function initCombo(comboObj, comboNo, combo_val, def_val) {
	var cnt = 0;
	switch (comboNo) {
	case 1:
		with (comboObj) {
			SetColAlign("center");
			SetColWidth("90");
			DropHeight = 150;

			var tmp = '';
			if (combo_val != undefined && combo_val != null) {
				tmp = combo_val.split('|');
			}
			for ( var i = 0; combo_val != undefined && combo_val != null
					&& tmp != null && i < tmp.length; i++) {
				InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
			}

			if (ComIsNull(inv_no)) { // 생성화면에서 바로 사용할 경우만 default값으로 설정한다.
				if (def_val != undefined && def_val != null
						&& def_val.trim() != '') {
					Code = def_val;
					def_curr_cd = def_val != undefined && def_val != '' ? def_val
							: '';
				} else {
					Code = '';
				}
			} else { // Summary화면에서 수정하기 위해 넘어온 경우... 혹 main_hidden이 먼저 완료되었을
						// 경우 뒷북으로 다시 재설정한다.
				if (sheetObjects[5].RowCount > 0
						&& (document.form.curr_cd.Code == null || document.form.curr_cd.Code == '')) {
					document.form.curr_cd.Code = sheetObjects[5].CellValue(1,
							'curr_cd');
					def_curr_cd = sheetObjects[5].CellValue(1, 'curr_cd') != null
							&& sheetObjects[5].CellValue(1, 'curr_cd') != '' ? sheetObjects[5]
							.CellValue(1, 'curr_cd')
							: '';
				}
			}
		}
		break;
	}
}

/**
* 시트 초기설정값, 헤더 정의
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
* @param {sheet}	sheetObj	ibsheet
* @param {int}		sheetNo		sheet index
* @return
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	 switch(sheetNo) {
     case 1:   //t1sheet1 init
         with (sheetObj) {
			style.height = GetSheetHeight(15);
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
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(28, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "||Seq.|CNTR No.|Type/Size|Gate In|Gate Out|F/M|I/O|DG|B/B|Mode|Verify\nResult|Remarks|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, false,	"ibflag", false, "");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, "chk", false, "", dfNone, 0, false, false, 6);
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cntr_no", false, "", dfNone, 0, false, false, 3);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, false, 1);

			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "inv_gate_in_dt", false, "", dfUserFormat2, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "inv_gate_out_dt", false, "", dfUserFormat2, 0, false, false, 6);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "cntr_sty_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "io_bnd_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "dcgo_clss_cd", false, "", dfNone, 0, true, true, 1);

			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "bb_cgo_flg", false, "", dfNone, 0, true, true, 9);
			/* [CHM-201537696]ODCY Invoice에서 CTM의 Mode와 I/O 구분 Verify 기준으로 가지고 오기 2015-09-09(조아영D) */
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false, "tml_trns_mod_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "dscr_ind_cd", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cntr_rmk", false, "", dfNone, 0, true, true, 500);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "tml_so_cntr_list_seq", false, "", dfInteger, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no", false, "", dfNone, 0, false, false, 9);

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no_split", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "vrfy_rslt_ind_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "modi_flg", false, "", dfNone, 0, false, false, 6);
			// DISCREPANCY와 model이 동일하여 빈값으로 설정함
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "gate_in_td_dys", false, "", dfInteger, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "gate_out_td_dys", false, "", dfInteger, 0, false, false, 9);

			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "inv_stay_dys", false, "", dfInteger, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "mvmt_gate_in_dt", false, "", dfUserFormat2, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false,"mvmt_gate_out_dt", false, "", dfUserFormat2, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "mvmt_stay_dys", false, "", dfInteger, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "stay_diff_dys", false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "awk_cgo_flg", false, "", dfNone, 0, true, true,9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "rc_flg", false, "", dfNone, 0, true, true,9);

			InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "mvmt_gate_in_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "mvmt_gate_out_dt", "####-##-## ##:##", "-|:");

			InitDataCombo(0, "cntr_sty_cd", cntr_sty_cdCode, cntr_sty_cdCode);
			InitDataCombo(0, "io_bnd_cd", io_bnd_cdCode, io_bnd_cdCode);
			InitDataCombo(0, "dcgo_clss_cd", dcgo_clss_cdCode, dcgo_clss_cdCode);
			InitDataCombo(0, "bb_cgo_flg", 'Y|N', 'Y|N');
			/* [CHM-201537696]ODCY Invoice에서 CTM의 Mode와 I/O 구분 Verify 기준으로 가지고 오기 2015-09-09(조아영D) */
			InitDataCombo(0, "tml_trns_mod_cd", tml_trns_mod_cdCode, tml_trns_mod_cdCode);

			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case 2: // t2sheet1 init
		with (sheetObj) {
			style.height = GetSheetHeight(15);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(25, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle0 = "|Discrepancy Type||Seq.|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O\|Remarks";
			var HeadTitle1 = "|Discrepancy Type||Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle0, true);
			InitHeadRow(1, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCombo, 150, daLeft, true, "dscr_ind_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "cntr_no", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 50, daCenter, false,
					"cntr_sty_cd", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false,
					"mvmt_gate_in_dt", false, "", dfUserFormat2, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false,
					"inv_gate_in_dt", false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"gate_in_td_dys", false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 95, daCenter, false,
					"mvmt_gate_out_dt", false, "", dfUserFormat2, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 95, daCenter, false,
					"inv_gate_out_dt", false, "", dfUserFormat2, 0, false,
					false);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"gate_out_td_dys", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cntr_rmk",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"tml_so_cntr_list_seq", false, "", dfInteger, 0, false,
					false, 9);

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no",
					false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,
					"bkg_no_split", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false,
					"vrfy_rslt_ind_cd", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"modi_flg", false, "", dfNone, 0, false, false, 9);
			// COINCIDENCE와 model이 동일하여 빈값으로 설정함..
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"bb_cgo_flg", false, "", dfNone, 0, false, false, 9);

			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"dcgo_clss_cd", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"io_bnd_cd", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false,
					"awk_cgo_flg", false, "", dfNone, 0, true, true,9);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "rc_flg",
					false, "", dfNone, 0, true, true,9);
			/* [CHM-201537696]ODCY Invoice에서 CTM의 Mode와 I/O 구분 Verify 기준으로 가지고 오기 2015-09-09(조아영D) */
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"tml_trns_mod_cd", false, "", dfNone, 0, false, false, 9);

			InitUserFormat2(0, "inv_gate_in_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "inv_gate_out_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "mvmt_gate_in_dt", "####-##-## ##:##", "-|:");
			InitUserFormat2(0, "mvmt_gate_out_dt", "####-##-## ##:##", "-|:");

			InitDataCombo(
					0,
					"dscr_ind_cd",
					"Discrepancy by Detail Data|Duplicate|SML List Only|Discrepancy by Period|Not in SML Source|Double Billing|Different Date|Another Movement",
					"DD|DP|HO|PD|NH|DB|DF|AM");
			InitDataCombo(0, "cntr_sty_cd", cntr_sty_cdCode, cntr_sty_cdCode);
			InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);

			HeadRowHeight = 10;
			RangeBackColor(1, 7, 1, 8) = RgbColor(222, 251, 248); // ENIS
			RangeBackColor(1, 10, 1, 11) = RgbColor(222, 251, 248); // ENIS

			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case 3: // t3sheet1 init
		with (sheetObj) {
			style.height = GetSheetHeight(15);
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
			if(ida_ofc_cd == 'Y'){
				InitRowInfo(2, 1, 5, 100);
			} else {
				InitRowInfo(1, 1, 5, 100);
			}

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			// 컬럼 데이타 변경(추가, 삭제)시 function resetSheetDataProperty(CURR_CD) 컬럼 번호
			// 수정 확인 ( ctrt_rt, inv_amt )
			InitColumnInfo(55, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|Type/Size|Mode|Calculated\nVol.|Reefer|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
			if(ida_ofc_cd == 'Y'){
				var HeadTitle1 = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|Type/Size|Mode|Calculated\nVol.|Reefer|Year\nMonth|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";
			}
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			if(ida_ofc_cd == 'Y'){
				InitHeadRow(1, HeadTitle1, true);
			}

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,"ibflag");
			InitDataProperty(0, cnt++, dtCombo, 150, daLeft, true,"calc_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true,"lgs_cost_cd", false, "", dfNone, 0, false, false);
			if(ida_ofc_cd == 'Y'){
            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
            } else {
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
            }
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true,"cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true,"tml_trns_mod_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,"calc_vol_qty", false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "rc_flg",false, "", dfNone, 0, false, false);
			// manual input 비용 계산 적용 년월 칼럼 추가 ( 4342. 01. 19 - 이경한 과장 요청 CSR
			// TMNL 추가 )
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,"rev_yrmon", false, "", dfDateYm, 0, false, false);
			InitDataProperty(0, cnt++, dtPopup, 80, daCenter, true,"rvis_vol_qty", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true,"vol_tr_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "ctrt_rt",false, "", dfFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd",false, "", dfNone, 0, false, false);		
			InitDataProperty(0, cnt++, dtData, 60, daRight, true,"inv_xch_rt", false, "", dfFloat, 5, false, false, 15);
					
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,"rf_mntr_dys", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "inv_amt",false, "", dfFloat, 2, false, false);
			if(ida_ofc_cd == 'Y'){
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_cgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_sgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_igst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_ugst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_gst_rto" , false, "", dfFloat, 2, false, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_gst_amt" , false, "", dfFloat, 2, false, true);
            } else {
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_amt", false, "", dfFloat, 2, false, false);  
            }			
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "calc_rmk",false, "", dfNone, 0, true, true);						
			InitDataProperty(0, cnt++, dtPopup, 50, daLeft, true, "n3pty_flg",false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden,  20, daLeft, false, "semi_auto_calc_flg", false, "", dfNone, 0, true, true);
						
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false,
					"calc_amt", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false,
					"tml_agmt_ofc_cty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_ver_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_so_dtl_seq", false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"calc_cost_grp_cd", false, "", dfNone, 0, false, false, 9);
			InitDataProperty(0, cnt++, dtHidden, 125, daLeft, false,
					"lgs_cost_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "cntr_no",
					false, "", dfNone, 0, false, false);
			// TMNL, ByDay, ByPool과 model이 동일하여 빈값으로 채우준당
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"dcgo_ind_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "free_dys",
					false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "inv_amt2",
					false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "ovr_dys",
					false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "paid_day",
					false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "stay_dys",
					false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, false,
					"diff_vol_qty", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"fp_calc_prd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"fp_teu_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"inv_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"ovr_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"stk_vol_qty", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "wrk_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "acct_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "curr_chk",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "plug_term",
					false, "", dfNone, 0, false, false);
			// InitDataProperty(0, cnt++ , dtHidden, 20, daLeft, false,
			// "tmp_dtl_seq", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"rmk_chk_flg", false, "", dfNone, 0, false, false);

			InitDataCombo(0, "calc_tp_cd",
					"Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
			InitDataCombo(0, "lgs_cost_cd", OT_A_LGS_COST_CD, OT_A_LGS_COST_CD);
			InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);
			InitDataCombo(0, "vol_tr_ut_cd", vol_tr_ut_cdCode, vol_tr_ut_cdCode);
			InitDataCombo(0, "rc_flg", "Y|N", "Y|N");
			InitDataCombo(0, "tml_trns_mod_cd", tml_trns_mod_cdCode, tml_trns_mod_cdCode);
			if(ida_ofc_cd == 'Y'){
            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
            }

			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case 4: // t4sheet1 init
		with (sheetObj) {
			style.height = GetSheetHeight(15);
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
			if(ida_ofc_cd == 'Y'){
				InitRowInfo(2, 1, 5, 100);
			} else {
				InitRowInfo(1, 1, 5, 100);
			}

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			// 컬럼 데이타 변경(추가, 삭제)시 function resetSheetDataProperty(CURR_CD) 컬럼 번호
			// 수정 확인 ( ctrt_rt, inv_amt )
			InitColumnInfo(54, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\Month|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|3rd Party";
			if(ida_ofc_cd == 'Y'){
				var HeadTitle1 = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|CNTR No.|Type/\nSize|I/O|DG.|Year\Month|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|3rd Party";
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			if(ida_ofc_cd == 'Y'){
				InitHeadRow(1, HeadTitle1, true);
			}

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCombo, 150, daLeft, true, "calc_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "lgs_cost_cd", false, "", dfNone, 0, false, false);
			if(ida_ofc_cd == 'Y'){
            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
            } else {
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
            }
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtCombo, 30, daCenter, true, "io_bnd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 30, daCenter, true,	"dcgo_ind_cd", false, "", dfNone, 0, false, false);
			// manual input 비용 계산 적용 년월 칼럼 추가 ( 4342. 01. 14 - 이경한 과장 요청 CSR )
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rev_yrmon", false, "", dfDateYm, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "stay_dys", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "free_dys", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "paid_day", false, "", dfInteger, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "free_dy_xcld_dys", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "ovr_dys", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 35, daCenter, true, "vol_tr_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "ctrt_rt", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "inv_xch_rt", false, "", dfFloat, 5, false, false, 15);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "inv_amt", false, "", dfFloat, 2, false, false);
			if(ida_ofc_cd == 'Y'){
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_cgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_sgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_igst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_ugst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_gst_rto" , false, "", dfFloat, 2, false, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_gst_amt" , false, "", dfFloat, 2, false, true);
            } else {
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_amt", false, "", dfFloat, 2, false, false);  
            }
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "calc_rmk", false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtPopup, 50, daLeft, true, "n3pty_flg",	false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtHidden,  20, daLeft, true, "semi_auto_calc_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false, "calc_amt", false, "", dfFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false,
					"tml_agmt_ofc_cty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_ver_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 125, daLeft, false,
					"lgs_cost_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"calc_cost_grp_cd", false, "", dfNone, 0, false, false, 9);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_so_dtl_seq", false, "", dfNone, 0, false, false);
			// TMNL, ByDay, ByPool과 model이 동일하여 빈값으로 채우준당
			InitDataProperty(0, cnt++, dtHidden, 20, daRight, false,
					"calc_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daRight, false,
					"rvis_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daRight, false,
					"diff_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"fp_calc_prd_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"fp_teu_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"inv_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"ovr_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"stk_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "wrk_dt",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "acct_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "curr_chk",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 35, daCenter, false,
					"ovr_dys2", false, "", dfInteger, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "rc_flg",
					false, "", dfNone, 0, false, false);
			// InitDataProperty(0, cnt++ , dtHidden, 20, daLeft, false,
			// "tmp_dtl_seq", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false,
					"rmk_chk_flg", false, "", dfNone, 0, false, false);

			InitDataCombo(0, "calc_tp_cd",
					"Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
			InitDataCombo(0, "lgs_cost_cd", OS_A_LGS_COST_CD, OS_A_LGS_COST_CD);
			InitDataCombo(0, "cntr_tpsz_cd", CNTR_TPSZ_CD, CNTR_TPSZ_CD);
			InitDataCombo(0, "io_bnd_cd", io_bnd_cdCode, io_bnd_cdCode);
			InitDataCombo(0, "vol_tr_ut_cd", vol_tr_ut_cdCode, vol_tr_ut_cdCode);
			InitDataCombo(0, "dcgo_ind_cd", dcgo_clss_cdCode, dcgo_clss_cdCode);
			if(ida_ofc_cd == 'Y'){
            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
            }

			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case 5: // t5sheet1 init
		with (sheetObj) {
			style.height = GetSheetHeight(15);
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
			if(ida_ofc_cd == 'Y'){
				InitRowInfo(2, 1, 5, 100);
			} else {
				InitRowInfo(1, 1, 5, 100);
			}

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			// 컬럼 데이타 변경(추가, 삭제)시 function resetSheetDataProperty(CURR_CD) 컬럼 번호
			// 수정 확인 ( ctrt_rt, inv_amt )
			InitColumnInfo(51, 3, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks";

			if(ida_ofc_cd == 'Y'){
				var HeadTitle1 = "|Calculated Type|Cost Code|HSN/SAC|Goods/\nServices|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks";
			}
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			if(ida_ofc_cd == 'Y'){
				InitHeadRow(1, HeadTitle1, true);
			}

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 150, daLeft, true,
					"calc_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true,
					"lgs_cost_cd", false, "", dfNone, 0, false, false);
			if(ida_ofc_cd == 'Y'){
            	InitDataProperty(0, cnt++ , dtData, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, true, true);
            	InitDataProperty(0, cnt++ , dtCombo, 70, daCenter,  true,  "ida_pay_tp_cd", false, "", dfNone, 0, true, true);
            } else {
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_sac_cd", false, "", dfNone, 0, false, false);
            	InitDataProperty(0, cnt++ , dtHidden, 70, daCenter,  true, "ida_pay_tp_cd", false, "", dfNone, 0, false, false);
            }
			InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "wrk_dt",
					false, "", dfDateYmd, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true,
					"stk_vol_qty", false, "", dfFloat, 2, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daRight, true,
					"inv_vol_qty", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 37, daRight, true,
					"diff_vol_qty", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true,
					"fp_teu_qty", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 45, daRight, true,
					"ovr_vol_qty", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtCombo, 35, daRight, true,
					"vol_tr_ut_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "ctrt_rt",
					false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true,
					"inv_xch_rt", false, "", dfFloat, 5, false, false, 15);
			InitDataProperty(0, cnt++, dtData, 60, daRight, true, "inv_amt",
					false, "", dfFloat, 2, false, false);
			if(ida_ofc_cd == 'Y'){
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_cgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_sgst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_igst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_ugst_rto", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
                InitDataProperty(0, cnt++, dtData, 50, daRight, false, "ida_gst_rto" , false, "", dfFloat, 2, false, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ida_gst_amt" , false, "", dfFloat, 2, false, true);
            } else {
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_cgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_sgst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_igst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_ugst_amt", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_rto", false, "", dfFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daRight, true, "ida_gst_amt", false, "", dfFloat, 2, false, false);  
            }
			
			InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "calc_rmk",
					false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 60, daRight, false,
					"calc_amt", false, "", dfFloat, 2, false, false);
			InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false,
					"tml_agmt_ofc_cty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_agmt_ver_no", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 125, daLeft, false,
					"lgs_cost_cd2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"calc_cost_grp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"tml_so_dtl_seq", false, "", dfInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"fp_calc_prd_cd", false, "", dfNone, 0, false, false);
			// TMNL, ByDay, ByPool과 model이 동일하여 빈값으로 채우준당
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"calc_vol_qty", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "cntr_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"io_bnd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"rvis_vol_qty", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false,
					"dcgo_ind_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "free_dys",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "inv_amt2",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "ovr_dys",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "paid_day",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "stay_dys",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "acct_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daLeft, false, "curr_chk",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false, "rc_flg",
					false, "", dfNone, 0, false, false);
			// manual input 비용 계산 적용 년월 칼럼 추가 ( 4342. 01. 14 - 이경한 과장 요청 CSR )
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false,
					"rev_yrmon", false, "", dfDateYm, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false,
					"rmk_chk_flg", false, "", dfDateYm, 0, false, false);

			InitDataCombo(0, "calc_tp_cd",
					"Auto Calculated Cost|Manual Input Cost", "A|M");
			InitDataCombo(0, "lgs_cost_cd", OS_A_LGS_COST_CD, OS_A_LGS_COST_CD);
			InitDataCombo(0, "vol_tr_ut_cd", vol_tr_ut_cdCode, vol_tr_ut_cdCode);
			if(ida_ofc_cd == 'Y'){
            	InitDataCombo(0 , "ida_pay_tp_cd", "Goods|Services", "G|S");
            }

			CountFormat = "[SELECTDATAROW / ROWCOUNT]";
		}
		break;

	case 6: // main_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(45, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|"
						  + "fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|"
						  + "pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|"
						  +"inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt|mvmt_gate_in_dt|mvmt_gate_out_dt"
						  + "dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cost_ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_no", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vndr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "curr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ttl_inv_amt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vat_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ttl_calc_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "fm_prd_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_rmk", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "to_prd_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_cost_grp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_calc_ind_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "sto_dys_ind_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "iss_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "rcv_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "eff_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_due_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_flg", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_inv_rjct_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_cfm_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_rjct_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_rjct_rmk", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_usr_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_usr_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dup_tp_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "err_inv_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "whld_tax_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ap_rvs_cng_flg", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "mvmt_gate_in_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "mvmt_gate_out_dt", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dbt_note_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_cgst_amt", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_sgst_amt", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_igst_amt", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "ida_ugst_amt", false, "", dfFloat, 2, true, true);
		}
		break;

	case 7: // rjct_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_no|vndr_seq|tml_inv_rjct_sts_cd|inv_rjct_rmk";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vndr_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_inv_rjct_sts_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"inv_rjct_rmk", false, "", dfNone, 0, true, true);

		}
		break;

	case 8: // conf_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_no|vndr_seq|tml_inv_sts_cd|inv_cfm_dt";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vndr_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_inv_sts_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_cfm_dt",
					false, "", dfNone, 0, true, true);

		}
		break;

	case 9: // dupchk_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(35, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "tml_so_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_ofc_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"cost_ofc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_no",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vndr_seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "yd_nm",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "curr_cd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"ttl_inv_amt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "vat_amt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"ttl_calc_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "fm_prd_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_flg",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "hld_rmk",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "to_prd_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_inv_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_cost_grp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_calc_ind_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"sto_dys_ind_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "iss_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "rcv_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "eff_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_due_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "pay_flg",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_inv_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"tml_inv_rjct_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "inv_cfm_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"inv_rjct_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"inv_rjct_rmk", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_usr_id",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "cre_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_usr_id",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "upd_dt",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false, "dup_tp_cd",
					false, "", dfNone, 0, true, true);

		}
		break;

	case 10: // rvis_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(26, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "|tml_so_ofc_cty_cd|tml_so_seq|tml_so_dtl_seq|tml_so_dtl_seq2|tml_so_rvis_list_seq|tml_inv_tp_cd|calc_cost_grp_cd|tml_rvis_tp_cd|lgs_cost_cd"
					+ "|cntr_no|cntr_tpsz_cd|cntr_sty_cd|tml_rvis_ind_flg|rvis_gate_in_flg|rvis_gate_out_flg|inv_gate_in_dt|inv_gate_out_dt|bkg_no|bkg_no_split|"
					+ "vsl_cd|skd_voy_no|skd_dir_cd|cuz_cntr_no|rhnd_rsn_cd|rvis_rmk";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false,
					"rvis_ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_so_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_so_dtl_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_so_dtl_seq2", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_so_rvis_list_seq", false, "", dfNone, 0, true,
					true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_inv_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_calc_cost_grp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_rvis_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_lgs_cost_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_cntr_sty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_tml_rvis_ind_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_rvis_gate_in_flg", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_rvis_gate_out_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_inv_gate_in_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_inv_gate_out_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_bkg_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_bkg_no_split", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_vsl_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_skd_voy_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_skd_dir_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_cuz_cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_rhnd_rsn_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daLeft, false,
					"rvis_rvis_rmk", false, "", dfNone, 0, true, true);
		}
		break;

	case 11: // trd_if_hidden
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(43, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "STS|calc_cost_grp_cd|tml_if_ofc_cd|tml_if_seq|tml_n3pty_if_sts_cd|"
					+ "tml_inv_tp_cd|inv_no|vndr_seq|yd_cd|lgs_cost_cd|acct_cd|"
					+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|tml_so_dtl_seq|tml_so_dtl_seq3|n3pty_bil_tp_cd|"
					+ "cntr_no|cntr_tpsz_cd|bkg_no|bkg_no_split|finc_vsl_cd|"
					+ "finc_skd_voy_no|finc_skd_dir_cd|vndr_cust_div_cd|vndr_cnt_cd|n3pty_vndr_seq|"
					+ "cust_cnt_cd|cust_seq|n3pty_ofc_cd|curr_cd|if_amt|"
					+ "if_rmk|cxl_flg|calc_tp_cd|ioc_cd|lane_cd|"
					+ "io_bnd_cd|fm_tr_vol_val|to_tr_vol_val|n3rd_if_rmk";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false,
					"n3rd_ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_calc_cost_grp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_if_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_if_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_n3pty_if_sts_cd", false, "", dfNone, 0, false,
					true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_inv_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_inv_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_lgs_cost_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_acct_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_ofc_cty_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_cntr_list_seq", false, "", dfNone, 0, false,
					true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_dtl_seq", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tmp_dtl_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tmp_tpb_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_bil_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cntr_tpsz_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_bkg_no_split", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_vsl_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_skd_voy_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_skd_dir_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_cust_div_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_cnt_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_vndr_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cust_cnt_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cust_seq", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_curr_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_if_amt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cxl_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_calc_tp_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_ioc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_lane_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_io_bnd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_fm_tr_vol_val", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_to_tr_vol_val", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vvd_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"tmp_tpb_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"n3rd_if_rmk", false, "", dfNone, 0, false, true);

		}
		break;

	case 12: // trd_if_hidden_2
		with (sheetObj) {
			style.height = GetSheetHeight(5);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(43, 1, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "STS|calc_cost_grp_cd|tml_if_ofc_cd|tml_if_seq|tml_n3pty_if_sts_cd|"
					+ "tml_inv_tp_cd|inv_no|vndr_seq|yd_cd|lgs_cost_cd|acct_cd|"
					+ "tml_so_ofc_cty_cd|tml_so_seq|tml_so_cntr_list_seq|tml_so_dtl_seq|tml_so_dtl_seq3|n3pty_bil_tp_cd|"
					+ "cntr_no|cntr_tpsz_cd|bkg_no|bkg_no_split|finc_vsl_cd|"
					+ "finc_skd_voy_no|finc_skd_dir_cd|vndr_cust_div_cd|vndr_cnt_cd|n3pty_vndr_seq|"
					+ "cust_cnt_cd|cust_seq|n3pty_ofc_cd|curr_cd|if_amt|"
					+ "if_rmk|cxl_flg|calc_tp_cd|ioc_cd|lane_cd|"
					+ "io_bnd_cd|fm_tr_vol_val|to_tr_vol_val|n3rd_if_rmk";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false,
					"n3rd_ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_calc_cost_grp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_if_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_if_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_n3pty_if_sts_cd", false, "", dfNone, 0, false,
					true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_inv_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_inv_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_lgs_cost_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_acct_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_ofc_cty_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_cntr_list_seq", false, "", dfNone, 0, false,
					true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tml_so_dtl_seq", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tmp_dtl_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_tmp_tpb_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_bil_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cntr_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cntr_tpsz_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_bkg_no_split", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_vsl_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_skd_voy_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_finc_skd_dir_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_cust_div_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vndr_cnt_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_vndr_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cust_cnt_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cust_seq", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_n3pty_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_curr_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_if_amt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_cxl_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_calc_tp_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_ioc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_lane_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_io_bnd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_fm_tr_vol_val", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_to_tr_vol_val", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false,
					"n3rd_vvd_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"tmp_tpb_seq", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"n3rd_if_rmk", false, "", dfNone, 0, false, true);

		}
		break;

	}
}

/**
 * Off-dock CY Invoice Terminal의 manual cost_cd를 조회
 * @return
 */
function getCalcTerminalManualCostCode() {
	// Off-dock CY Invoice Terminal의 manual cost_cd를 조회
	document.form.yd_chr_inv_tp_cd.value = 'OT';
	tes_getInputValue('calcTerminalComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * Off-dock CY Invoice Storage의 manual cost_cd를 조회
 * @return
 */
function getCalcStorageManualCostCode() {
	// Off-dock CY Invoice Storage의 manual cost_cd를 조회
	document.form.yd_chr_inv_tp_cd.value = 'OS';
	tes_getInputValue('calcStorageComboItems', SEARCH08, 'yd_chr_inv_tp_cd|yd_fcty_tp_cfs_flg|yd_fcty_tp_rail_rmp_flg|yd_oshp_cd', '');
}

/**
 * Terminal Cost Code 설정
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function setCalcTerminalManualCostCode(sheet) {
	var formObj = document.form;
	for ( var i = 1; i <= sheet.RowCount; i++) {
		if (sheet.CellValue(i, 'calc_tp_cd') == 'M' || sheet.CellValue(i, 'calc_tp_cd') == 'S') {
			org_val = sheet.CellValue(i, 'lgs_cost_cd');
			org_sts = sheet.RowStatus(i);
			sheet.CellComboItem(i, 'lgs_cost_cd',
					formObj.calcTerminalComboItemsDesc.value,
					formObj.calcTerminalComboItems.value);
			sheet.CellValue2(i, 'lgs_cost_cd') = sheet.CellValue(i,
					'lgs_cost_cd2');
			if (sheet.CellValue(i, 'lgs_cost_cd') == null
					|| sheet.CellValue(i, 'lgs_cost_cd').trim() == '') {
				sheet.CellValue2(i, 'lgs_cost_cd') = org_val;
			}
			sheet.RowStatus(i) = org_sts;
		}
	}
}

/**
* Free Pool & Day Cost Code 설정
* @param {sheet}	sheet	ibsheet
* @return
*/
function setCalcStorageManualCostCode(sheet) {
	var formObj = document.form;
	for ( var i = 1; i <= sheet.RowCount; i++) {
		if (sheet.CellValue(i, 'calc_tp_cd') == 'M' || sheet.CellValue(i, 'calc_tp_cd') == 'S') {
			org_val = sheet.CellValue(i, 'lgs_cost_cd');
			org_sts = sheet.RowStatus(i);
			sheet.CellComboItem(i, 'lgs_cost_cd',
					formObj.calcStorageComboItemsDesc.value,
					formObj.calcStorageComboItems.value);
			sheet.CellValue2(i, 'lgs_cost_cd') = sheet.CellValue(i,
					'lgs_cost_cd2');
			if (sheet.CellValue(i, 'lgs_cost_cd') == null
					|| sheet.CellValue(i, 'lgs_cost_cd').trim() == '') {
				sheet.CellValue2(i, 'lgs_cost_cd') = org_val;
			}
			sheet.RowStatus(i) = org_sts;
		}
	}
}

/**
 * 동시에 COIN, DSCP, CALC.TMNL, CALC.ByDay sheet의 data를 삭제
 * @return
 */
function removeOffdockCYInvoice01() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	sheetObj.ShowDebugMsg = false;

	/* 동시에 COIN, DSCP, CALC.TMNL, CALC.ByDay sheet의 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE01;
	var param = sheetObj.GetSaveString();
	var sXml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
	sheetObj.LoadSaveXml(sXml, true);

	/*
	 * var sxml0 = sheetObj.EtcData("sxml0"); var sxml1 =
	 * sheetObj.EtcData("sxml1"); var sxml2 = sheetObj.EtcData("sxml2"); var
	 * sxml3 = sheetObj.EtcData("sxml3"); sheetObjects[0].RemoveEtcData();
	 * sheetObjects[0].LoadSearchXml(sxml0); sheetObjects[1].LoadSearchXml(sxml1);
	 * sheetObjects[2].LoadSearchXml(sxml2); sheetObjects[3].LoadSearchXml(sxml3);
	 */
	sXml = null; // sxml0=null; sxml1=null; sxml2=null; sxml3=null;
	initCoinShtStat();
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();

	setElementDiabled('checkbox', 'TMNL', 'N');
	setElementDiabled('checkbox', 'StorageDay', 'N');
	setElementDiabled('radio', 'CostCalcMethod', 'N');
}

 /**
  * CALC.ByPool sheet의 data를 삭제
  * @return
  */
function removeOffdockCYInvoice02() {
	var formObj = document.form;
	var sheetObj = sheetObjects[4];
	sheetObj.ShowDebugMsg = false;

	/* CALC.ByPool sheet의 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE02;
	var param = sheetObj.GetSaveString();
	var sXml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_Z2|sht_01_Z4|sht_01_C2|sht_01_C4'));
	sheetObj.LoadSaveXml(sXml, true);
	/*
	 * var sxml0 = sheetObj.EtcData("sxml0"); sheetObjects[0].RemoveEtcData();
	 * sheetObjects[0].LoadSearchXml(sxml0);
	 */
	sXml = null; // sxml0=null;
	sheetObjects[4].RemoveAll();
}

/**
 * 수정 가능 data가 수정되었는지 여부 확인
 * @return
 */
function t1sheet1_ChkMod() {
	if (sheetObjects[0].RowCount > 0
			&& (hasAutoCalcData(sheetObjects[2]) || hasAutoCalcData(sheetObjects[3]))) { // DISCREPANCY는 검사에서 제외
		for ( var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++) {
			if (sheetObjects[0].CellValue(i, 'ibflag') == 'U'
					&& (sheetObjects[0].CellValue(i, 'cntr_sty_cd') != sheetObjects[0]
							.CellSearchValue(i, 'cntr_sty_cd')
							|| sheetObjects[0].CellValue(i, 'io_bnd_cd') != sheetObjects[0]
									.CellSearchValue(i, 'io_bnd_cd')
							|| sheetObjects[0].CellValue(i, 'dcgo_clss_cd') != sheetObjects[0]
									.CellSearchValue(i, 'dcgo_clss_cd') || sheetObjects[0]
							.CellValue(i, 'bb_cgo_flg') != sheetObjects[0]
							.CellSearchValue(i, 'bb_cgo_flg'))) {
				return true;
			}
		}
	}
	return false;
}

/**
 * CalcTMNL, CalcByDay, CalcByPool sheet의 data가 존재하는지 확인
 * @return
 */
function hasAllCalcData() {
	var sheet_obj;
	// CalcTMNL, CalcByDay, CalcByPool sheet의 data가 존재하는지 확인
	for ( var i = 3; i <= 5; i++) {
		sheet_obj = eval('document.t' + i + 'sheet1');
		if (sheet_obj != null && sheet_obj.RowCount > 0) {
			return true;
		}
	}
	return false;
}

/**
 * Calculated Type 이 Auto 여부 리턴
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function hasAutoCalcData(sheetObj) {
	if (sheetObj.RowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i < (sheetObj.HeaderRows + sheetObj.RowCount); i++) {
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'A') {
				return true;
			}
		}
	}
	return false;
}

/**
* Calculated Type 이 Manual 여부 리턴
* @param {sheet}	sheetObj	ibsheet
* @return
*/
function hasManualCalcData(sheetObj) {
	if (sheetObj.RowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i < (sheetObj.HeaderRows + sheetObj.RowCount); i++) {
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'M') {
				return true;
			}
		}
	}
	return false;
}

/**
 * 자동계산이 되어있는 상태에서 다시 자동계산을 할 경우 기존 데이터를 삭제한다.
 * @return
 */
function removeAutoCalcData() {
	// Calc.TMNL과 Calc.ByDay sheet에서 자동계산된 ROW만 삭제하기
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount - 1); i >= sheetObjects[2].HeaderRows; i--) {
			if (sheetObjects[2].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[2].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[2].RowDelete(i, false);
			}
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount - 1); i >= sheetObjects[3].HeaderRows; i--) {
			if (sheetObjects[3].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[3].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[3].RowDelete(i, false);
			}
		}
	}

	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	sheetObjects[2].ShowDebugMsg = false;

	/* Calc.TMNL과 Calc.ByDay sheet의 자동 계산 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE03;
	var sXml = sheetObjects[2].GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
	
	var arrXml = sXml.split("|$$|"); 

	sheetObjects[2].LoadSaveXml(arrXml[0], true);	
	sXml = null;
}

 /**
  * 미사용 Function (2010-03-26)
  * Calc.ByPool sheet에서 자동계산된 ROW만 삭제하기
  * @return
  */
function removeAutoCalcData2() {
	// Calc.ByPool sheet에서 자동계산된 ROW만 삭제하기
	if (sheetObjects[4].RowCount > 0) {
		for ( var i = (sheetObjects[4].HeaderRows + sheetObjects[4].RowCount - 1); i >= sheetObjects[4].HeaderRows; i--) {
			if (sheetObjects[4].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[4].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[4].RowDelete(i, false);
			}
		}
	}

	var formObj = document.form;
	var sheetObj = sheetObjects[4];
	sheetObjects[4].ShowDebugMsg = false;

	/* Calc.ByPool sheet의 자동 계산 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE05;
	var sXml = sheetObjects[4].GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
	sheetObjects[4].LoadSaveXml(sXml, true);
	sXml = null;
}

/**
 * Calc.TMNL, Calc.ByDay, Calc.ByPool sheet에서 자동계산된 ROW만 삭제하기
 * @return
 */
function removeAutoCalcDataAll() {
	// Calc.TMNL, Calc.ByDay, Calc.ByPool sheet에서 자동계산된 ROW만 삭제하기
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount - 1); i >= sheetObjects[2].HeaderRows; i--) {
			if (sheetObjects[2].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[2].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[2].RowDelete(i, false);
			}
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount - 1); i >= sheetObjects[3].HeaderRows; i--) {
			if (sheetObjects[3].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[3].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[3].RowDelete(i, false);
			}
		}
	}
	if (sheetObjects[4].RowCount > 0) {
		for ( var i = (sheetObjects[4].HeaderRows + sheetObjects[4].RowCount - 1); i >= sheetObjects[4].HeaderRows; i--) {
			if (sheetObjects[4].CellValue(i, 'calc_tp_cd') != undefined
					&& sheetObjects[4].CellValue(i, 'calc_tp_cd') == 'A') {
				sheetObjects[4].RowDelete(i, false);
			}
		}
	}

	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	sheetObjects[2].ShowDebugMsg = false;

	/* Calc.TMNL, Calc.ByDay, Calc.ByPool sheet의 자동 계산 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE04;
	var sXml = sheetObjects[2].GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
//	sheetObjects[2].LoadSaveXml(sXml, true);
	
	sXml = null;
}

/**
 * Calc.TMNL, Calc.ByDay, Calc.ByPool sheet에서 계산된 ROW 삭제하기
 * @return
 */
function removeCalcDataAll() {
	// Calc.TMNL, Calc.ByDay, Calc.ByPool sheet에서 계산된 ROW 삭제하기
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount - 1); i >= sheetObjects[2].HeaderRows; i--) {
			sheetObjects[2].RowDelete(i, false);
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount - 1); i >= sheetObjects[3].HeaderRows; i--) {
			sheetObjects[3].RowDelete(i, false);
		}
	}
	if (sheetObjects[4].RowCount > 0) {
		for ( var i = (sheetObjects[4].HeaderRows + sheetObjects[4].RowCount - 1); i >= sheetObjects[4].HeaderRows; i--) {
			sheetObjects[4].RowDelete(i, false);
		}
	}

	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	sheetObjects[2].ShowDebugMsg = false;

	/* Calc.TMNL, Calc.ByDay, Calc.ByPool sheet의 계산 data를 삭제해야합니다. */
	formObj.f_cmd.value = REMOVE06;
	sheetObjects[2].GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A4|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
}
 
/**
 * Container List(CO, DC), COst Calc. List(TMNL, FD, FP) Sheet 관련 프로세스 처리
  * @param {sheet}	sheetObj	ibsheet
  * @param {form}	formObj		form object
  * @param {int}	sAction		실행할 액션 구분 값
 * @return
 */
function doActionIBSheetAllSheets(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	 
	switch (sAction) {

	case IBSEARCH: // 조회
	
	    if (!validateForm(sheetObj,formObj,sAction)){
	        return false;
	    }
		var arr_sht = getCostCalcShtToSaveArr('N'); // Cost Group에서 선택된 조건에 따라 저장할 sheet의 idx 배열을 return
		formObj.f_cmd.value = SEARCHLIST03;
		var sXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
		}
		break;

	case IBSAVE: // 저장
		break;

	}
}

/**
 * Coincidence Sheet, Discrepancy Sheet 관련 프로세스 처리
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		실행할 액션 구분 값
 * @param {string}	SKIP_CHK	변경여부 체크 or not
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction, SKIP_CHK) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value = SEARCHLIST;
		var sXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
		}		

		break;

	case IBSAVE: // 저장
		if (!checkPeriodModified()) {
			return false;
		}
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		/* 동시에 COIN과 DSCP sheet를 저장해야합니다. */

		var params = new Array();
		// 특수문자를 변환문자로 치환. 두번째 인자 true  (2010-04-28) 
		params[0] = sheetObjects[0].GetSaveString(false, true);
		params[1] = sheetObjects[1].GetSaveString(false, true);
		
		//document.write("<br><br>at GetSaveString => "+params[0]);
				
		// 대상 sheet의 변경 여부를 확인한당.
		var sheets = new Array();
		sheets[0] = sheetObjects[0];
		sheets[1] = sheetObjects[1];

		if (!tes_isModified(sheets, params)) {
			ComShowMessage(ComGetMsg('TES23018')); // ComShowMessage("변경된 내역이 없습니다.");
			break;
		}

		// 수정 가능 data가 수정되었는지 여부 확인 및 계산된 data삭제하기
		if (t1sheet1_ChkMod()) {
			// if (confirm('Cal Tab의 Auto Calculation Data가 clear됩니다. 그래도 수정하시겠습니까?')){
			if (confirm(ComGetMsg('TES24070'))) {
				removeAutoCalcData();
			} else {
				return false;
			}
		}

		formObj.f_cmd.value = MULTI; // removeAutoCalcData()내부에서 f_cmd를 조작하니 반드시 다시 'MULTI'로 재조정해야 한다.
		var sXml = sheetObjects[0].GetSaveXml("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
		}

		break;

	case IBINSERT:
		var Row = sheetObj.DataInsert();
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

/**
 * 두번째 탭 Sheet 관련 프로세스 처리
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		실행할 액션 구분 값
 * @return
 */	
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBINSERT:
		var Row = sheetObj.DataInsert(-1);
		break;
		
	case IBSEARCH_ASYNC01:
        formObj.f_cmd.value = SEARCH10;
        var param = sheetObj.GetSaveString(true,false);
        var searchXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
        sheetObj.RemoveAll();
		if (searchXml!=null && searchXml!='') sheetObj.LoadSearchXml(searchXml);
		break;		
		
	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

/**
 * CostCalc. button을 click하면 Cost Group의 선택 조건에 따라 CALC.TMNL tab과 CALC.FD tab만 자동 계산한다. (CALC.FP는 제외)
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		실행할 액션 구분 값
 * @return
 */
function doActionIBSheetCalc(sheetObj, formObj, sAction) {
	/**
	 * CostCalc. button을 click하면 Cost Group의 선택 조건에 따라 CALC.TMNL tab과 CALC.FD
	 * tab만 자동 계산한다. (CALC.FP는 제외)
	 */
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCHLIST01; // cost calc 실행하고 결과 불러오기
		var sXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i+2].LoadSearchXml(arrXml[i], true, 1); 
		}
		break;
	}
}

/**
 * 세번째  탭 Sheet 관련 프로세스 처리
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form object
 * @param {int}		sAction		실행할 액션 구분 값
 * @param {string}	SKIP_CHK	변경여부 체크 or not
 * @return
 */
function doActionIBSheet3(sheetObj, formObj, sAction, SKIP_CHK) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCHLIST02; // DTL 전체 조회
		var sXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
  		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i+2].LoadSearchXml(arrXml[i]); 
		}				
		break;

	case IBSAVE: // 저장
		if (!checkPeriodModified()) {
			return false;
		}
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		// 유효성 확인...
		var colnms = 'lgs_cost_cd';
		var arr_colnms = colnms.split('|');
		var pass = true;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'M' && (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U')) {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 19 - 이경한과장 요청 TMNL 추가)
				if (sheetObj.CellValue(i, 'rev_yrmon') == null || sheetObj.CellValue(i, 'rev_yrmon').trim() == "") {
					ComShowMessage("Please input Year-Month(YYYYMM).");
					return false;
				}
				// Manual Input Amount가 0인 경우 ( 4342. 01. 19 - 이경한과장 )
				// Amount Check Integer체크하던것을 Float으로 변경 ( 2009-02-13 - 이경한과장 )
				if (sheetObj.CellValue(i, 'inv_amt') == null || parseFloat(sheetObj.CellValue(i, 'inv_amt').trim()) == 0) {
					ComShowMessage("Please input Amount.");
					return false;
				}
				for ( var j = 0; j < arr_colnms.length; j++) {
					if (sheetObj.CellValue(i, arr_colnms[j]) == null || sheetObj.CellValue(i, arr_colnms[j]).trim() == '') {
						pass = false;
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
					} else {
						if (pass) {
							sheetObj.RowFontColor(i) = sheetObj.DataFontColor;
						}
					}
				}
			}
			
			
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'S' && (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U')) {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 19 - 이경한과장 요청 TMNL 추가)
				if (sheetObj.CellValue(i, 'rev_yrmon') == null || sheetObj.CellValue(i, 'rev_yrmon').trim() == "") {
					ComShowMessage("Please input Year-Month(YYYYMM).");
					return false;
				}
				// Manual Input Amount가 0인 경우 ( 4342. 01. 19 - 이경한과장 )
				// Amount Check Integer체크하던것을 Float으로 변경 ( 2009-02-13 - 이경한과장 )
				if (sheetObj.CellValue(i, 'inv_amt') == null || parseFloat(sheetObj.CellValue(i, 'inv_amt').trim()) == 0) {
					ComShowMessage("Please input Amount.");
					return false;
				}

			}
			
		}
		if (!pass) {
			ComShowMessage(ComGetMsg('TES23029')); // ComShowMessage('유효하지 않은 column이 있습니다.');
			return false;
		}

		/* 동시저장 : CALC. TMNL & FD */
		var arr_sht = getCostCalcShtToSaveArr('Y'); // Cost Group에서 선택된 조건에 따라 row가 있고 수정된 저장할 sheet의 idx 배열을 return...

		formObj.f_cmd.value = MULTI01;
		var params = new Array();
		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
			// 특수문자를 변환문자로 치환. 두번째 인자 true  (2010-04-23) 
			params[i] = sheetObjects[arr_sht[i]].GetSaveString(false, true);
		}

		// 대상 sheet의 변경 여부를 확인한당.
		var sheets = new Array();
		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
			sheets[i] = sheetObjects[arr_sht[i]];
		}

		// RVIS_HIDDEN : RVIS sheet의 data를 변경내역 추가 확인 하기
		// sheets[sheets.length] = sheetObjects[9]; //rvis_hidden
		// params[params.length] = sheetObjects[9].GetSaveString(false ,false);

		// N3RD_HIDDEN : N3RD sheet의 data를 변경내역 추가 확인 하기
		// sheets[sheets.length] = sheetObjects[10]; //n3rd_hidden
		// params[params.length] = sheetObjects[10].GetSaveString(false ,false);

		if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK.trim() == '' || SKIP_CHK != 'Y') {
			if (!tes_isModified(sheets, params)) {
				ComShowMessage(ComGetMsg('TES23018')); // ComShowMessage("[3] 변경된 내역이 없습니다.");
				break;
			}
			if (!chkCostCalcSaveSts(2)) {
				return false;
			}
		}
		var sXml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));

		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i+2].LoadSearchXml(arrXml[i]); 
		}			
		break;

	case IBINSERT:
        // CHM-201640694 Cost Calculation Tab에서 Multi-Row Add기능 추가 - 2016-04-01
		for (var i = 0; i < formObj.t3rowsadd.value; i++) {
			var Row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(Row, "calc_cost_grp_cd") = "TM";
			sheetObj.CellValue2(Row, "calc_tp_cd") = "M";
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
			sheetObj.CellValue2(Row, "tml_trns_mod_cd") = "";
			sheetObj.CellValue2(Row, "io_bnd_cd") = "";
			sheetObj.CellValue2(Row, "vol_tr_ut_cd") = "";
			sheetObj.CellComboItem(Row, 'lgs_cost_cd',
			formObj.calcTerminalComboItemsDesc.value,
			formObj.calcTerminalComboItems.value);
			sheetObj.CellValue2(Row, "lgs_cost_cd") = "";
			sheetObj.CellValue2(Row, "inv_xch_rt") = 1;
			sheetObj.CellValue2(Row, "rc_flg") = "N";
			// sheetObj.CellValue2(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
			// 1;
			setShtCellsEditable(sheetObj,Row,'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt|rc_flg','Y');
			// setShtCellsEditable(sheetObj,Row,'rvis_vol_qty','N');
			sheetObj.CellValue2(Row, "ida_pay_tp_cd") = "S";
		}
		break;

	case IBDELETE:
		if (sheetObj.RowCount > 0) {
			var Row = sheetObj.SelectRow;
			var calc_tp_cd = sheetObj.CellValue(Row, "calc_tp_cd");
			//if (calc_tp_cd != null && (calc_tp_cd.trim() == 'M' || calc_tp_cd.trim() == 'S')) {
			if (calc_tp_cd != null) {	//[CHM-201538267]ODCY Invoice에서 Auto Calculated된 Row삭제 가능하도록 로직 수정(MR과 일치)
				if (sheetObj.CellValue(Row, "tml_so_dtl_seq") == null
						|| sheetObj.CellValue(Row, "tml_so_dtl_seq").trim() == ''
						|| parseInt(sheetObj.CellValue(Row, "tml_so_dtl_seq"),
								10) == 0) {
					sheetObj.RowDelete(Row, false);
				} else {
					sheetObj.RowStatus(Row) = 'D';
					sheetObj.RowHidden(Row) = true;
					sheetObj.CellValue2(Row, "inv_amt") = 0; // 어짜피 지울넘...
																// 숨기더라도 총액 계산에
																// 반영되므로 0으로
																// 만들어야 합당...
				}
				document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(sheetObj, 'inv_amt');
			}
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

/**
 * 네번째 탭 Sheet 관련 프로세스 처리
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		실행할 액션 구분 값
 * @param {string}	SKIP_CHK	변경여부 체크 or not
 * @return
 */
function doActionIBSheet4(sheetObj, formObj, sAction, SKIP_CHK) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		break;

	case IBSAVE: // 저장
		if (!checkPeriodModified()) {
			return false;
		}
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		// 유효성 확인...
		var colnms = 'lgs_cost_cd';
		var arr_colnms = colnms.split('|');
		var pass = true;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'M'
					&& (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U')) {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 14 - 이경한과장
				// 요청 )
				if (sheetObj.CellValue(i, 'rev_yrmon') == null
						|| sheetObj.CellValue(i, 'rev_yrmon').trim() == "") {
					ComShowMessage("Please input Year-Month(YYYYMM).");
					return false;
				}
				// Manual Input Amount가 0인 경우 ( 4342. 01. 19 - 이경한과장 )
				// Amount Check Integer체크하던것을 Float으로 변경 ( 2009-02-13 - 이경한과장 )
				if (sheetObj.CellValue(i, 'inv_amt') == null
						|| parseFloat(sheetObj.CellValue(i, 'inv_amt').trim()) == 0) {
					ComShowMessage("Please input Amount.");
					return false;
				}
				for ( var j = 0; j < arr_colnms.length; j++) {
					if (sheetObj.CellValue(i, arr_colnms[j]) == null
							|| sheetObj.CellValue(i, arr_colnms[j]).trim() == '') {
						pass = false;
						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
					} else {
						if (pass) {
							sheetObj.RowFontColor(i) = sheetObj.DataFontColor;
						}
					}
				}
			}
		}
		if (!pass) {
			ComShowMessage(ComGetMsg('TES23029')); // ComShowMessage('유효하지 않은
												// column이 있습니다.');
			return false;
		}

		/* 동시저장 */
		var arr_sht = getCostCalcShtToSaveArr(); // Cost Group에서 선택된 조건에 따라 저장할 sheet의 idx 배열을 return...
		formObj.f_cmd.value = MULTI01;
		var params = new Array();
		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
			// 특수문자를 변환문자로 치환. 두번째 인자 true  (2010-04-23) 
			params[i] = sheetObjects[arr_sht[i]].GetSaveString(false, true);
		}

		// 대상 sheet의 변경 여부를 확인한당.
		var sheets = new Array();
		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
			sheets[i] = sheetObjects[arr_sht[i]];
		}

		// RVIS_HIDDEN : RVIS sheet의 data를 변경내역 추가 여부 확인
		// sheets[sheets.length] = sheetObjects[9]; //rvis_hidden
		// params[params.length] = sheetObjects[9].GetSaveString(false ,false);

		// N3RD_HIDDEN : N3RD sheet의 data를 변경내역 추가 확인 하기
		// sheets[sheets.length] = sheetObjects[10]; //n3rd_hidden
		// params[params.length] = sheetObjects[10].GetSaveString(false ,false);

		if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK.trim() == '' || SKIP_CHK != 'Y') {
			if (!tes_isModified(sheets, params)) {
				ComShowMessage(ComGetMsg('TES23018')); // ComShowMessage("[4] 변경된
													// 내역이 없습니다.");
				break;
			}
			if (!chkCostCalcSaveSts(3)) {
				return false;
			}
		}
		var sXml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		
  		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i+2].LoadSearchXml(arrXml[i]); 
		}		
		
//		sheetObj.LoadSaveXml(sXml, true);
//		var sxml0;
//		var sxml1;
//
//		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
//			if (i == 0) {
//				sxml0 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
//			} else if (i == 1) {
//				sxml1 = sheetObj.EtcData(eval(new String('sxml' + new String(i))));
//			}
//		}
//		sheetObj.RemoveEtcData();
//
//		for ( var i = 0; arr_sht != null && i < arr_sht.length; i++) {
//			sheetObjects[arr_sht[i]].LoadSearchXml(eval('sxml' + new String(i)));
//		}
//		sXml = null;
//		sxml0 = null;
//		sxml1 = null;
		break;

	case IBINSERT:
        // CHM-201640694 Cost Calculation Tab에서 Multi-Row Add기능 추가 - 2016-04-01
		for (var i = 0; i < formObj.t4rowsadd.value; i++) {
			var Row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(Row, "calc_cost_grp_cd") = "SD";
			sheetObj.CellValue2(Row, "calc_tp_cd") = "M";
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
			sheetObj.CellValue2(Row, "io_bnd_cd") = "";
			sheetObj.CellValue2(Row, "dcgo_ind_cd") = "";
			sheetObj.CellValue2(Row, "vol_tr_ut_cd") = "";
			sheetObj.CellComboItem(Row, 'lgs_cost_cd',
			formObj.calcStorageComboItemsDesc.value,
			formObj.calcStorageComboItems.value);
			sheetObj.CellValue2(Row, "lgs_cost_cd") = "";
			sheetObj.CellValue2(Row, "inv_xch_rt") = 1;
			// sheetObj.CellValue2(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
			// 1;
			// Manual Input Year Month 컬럼 추가 ( 4342. 01. 15 - 이경한과장 요청 CSR )
			setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
			setShtCellsEditable(sheetObj, Row, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
			sheetObj.CellValue2(Row, "ida_pay_tp_cd") = "S";
		}
		break;

	case IBDELETE:
		if (sheetObj.RowCount > 0) {
			var Row = sheetObj.SelectRow;
			var calc_tp_cd = sheetObj.CellValue(Row, "calc_tp_cd");
			//if (calc_tp_cd != null && (calc_tp_cd.trim() == 'M' || calc_tp_cd.trim() == 'S')) {
			if (calc_tp_cd != null) {	//[CHM-201538267]ODCY Invoice에서 Auto Calculated된 Row삭제 가능하도록 로직 수정(MR과 일치)
				if (sheetObj.CellValue(Row, "tml_so_dtl_seq") == null
						|| sheetObj.CellValue(Row, "tml_so_dtl_seq").trim() == ''
						|| parseInt(sheetObj.CellValue(Row, "tml_so_dtl_seq"),
								10) == 0) {
					sheetObj.RowDelete(Row, false);
				} else {
					sheetObj.RowStatus(Row) = 'D';
					sheetObj.RowHidden(Row) = true;
					sheetObj.CellValue2(Row, "ovr_dys") = 1;
					sheetObj.CellValue2(Row, "inv_amt") = 0; // 어짜피 지울넘...
																// 숨기더라도 총액 계산에
																// 반영되므로 0으로
																// 만들어야 합당...
				}
				document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(
						sheetObj, 'inv_amt');
			}
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;

	}
}

 /**
  * 다섯번째 탭 Sheet 관련 프로세스 처리
  * @param {ibsheet}sheetObj 	IBSheet Object
  * @param {form} 	formObj		Form Object
  * @param {int}	sAction		실행할 액션 구분 값
  * @param {string}	SKIP_CHK	변경여부 체크 or not
  * @return
  */
function doActionIBSheet5(sheetObj, formObj, sAction, SKIP_CHK) {	
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCHLIST02;
		formObj.dtl_by_pool_only_mode.value = 'Y';
		var sXml = sheetObj.GetSearchXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		sheetObj.LoadSearchXml(sXml);
//		var sxml0 = sheetObj.EtcData('sxml0');
//		sheetObj.RemoveEtcData();
//		sheetObjects[4].LoadSearchXml(sxml0);
//		sXml = null;
//		sxml0 = null;
		formObj.dtl_by_pool_only_mode.value = ''; // 다시 초기화..
		break;

	case IBSAVE: // 저장
		if (!checkPeriodModified()) {
			return false;
		}
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}

		// 유효성 확인...
		var colnms = 'lgs_cost_cd';
		var arr_colnms = colnms.split('|');
		var pass = true;

		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'M' && (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U')) {ComGetMsg('TES23045')
				
				//Cost Code 는 필수 입력값 - 추가 09.09.17
				if (sheetObj.CellValue(i, 'lgs_cost_cd') == null || sheetObj.CellValue(i, 'lgs_cost_cd').trim() == "") {
					ComShowMessage( ComGetMsg('TES23045') );
					return false;
				}
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 15 - 이경한과장 요청 )
				if (sheetObj.CellValue(i, 'wrk_dt') == null || sheetObj.CellValue(i, 'wrk_dt').trim() == "") {
					ComShowMessage(ComGetMsg('TES40025', 'Date'));		//ComShowMessage("Please input Date.");
					return false;
				}
				// Manual Input Amount가 0인 경우 ( 4342. 01. 19 - 이경한과장 )
				// Amount Check Integer체크하던것을 Float으로 변경 ( 4342. 02. 13 - 이경한과장 )
				if (sheetObj.CellValue(i, 'inv_amt') == null || parseFloat(sheetObj.CellValue(i, 'inv_amt').trim()) == 0) {
					ComShowMessage(ComGetMsg('TES40025', 'Amount'));		//ComShowMessage("Please input Amount.");
					return false;
				}
				 				
//				for ( var j = 0; j < arr_colnms.length; j++) {
//					if (sheetObj.CellValue(i, arr_colnms[j]) == null || sheetObj.CellValue(i, arr_colnms[j]).trim() == '') {
//						pass = false;
//						sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
//					} else {
//						if (pass) {
//							sheetObj.RowFontColor(i) = sheetObj.DataFontColor;
//						}
//					}
//				}
			}
		}
//		if (!pass) {
//			ComShowMessage(ComGetMsg('TES23029')); // ComShowMessage('[lgs_cost_cd] 유효하지 않은 column이 있습니다.');
//			return false;
//		}

		// FP는 여러 CALC.TAB중 FP하나만 저장한다.
		var params = new Array();
		// 특수문자를 변환문자로 치환. 두번째 인자 true  (2010-04-23) 
		params[0] = sheetObjects[4].GetSaveString(false, true);

		var sheets = new Array();
		sheets[0] = sheetObjects[4];

		formObj.f_cmd.value = MULTI01;
		formObj.dtl_by_pool_only_mode.value = 'Y';

		// N3RD_HIDDEN : N3RD sheet의 data를 변경내역 추가 확인 하기
		// sheets[sheets.length] = sheetObjects[11]; //n3rd_hidden
		// params[params.length] = sheetObjects[11].GetSaveString(false ,false);

		if (SKIP_CHK == undefined || SKIP_CHK == null || SKIP_CHK.trim() == '' || SKIP_CHK != 'Y') {
			if (!tes_isModified(sheets, params)) {
				ComShowMessage(ComGetMsg('TES23018')); // ComShowMessage("[5] 변경된 내역이 없습니다.");
				break;
			}
		}
		var sXml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", getSaveString(params) + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		sheetObj.LoadSaveXml(sXml, true);
		formObj.dtl_by_pool_only_mode.value = '';
		
//		var sxml0 = sheetObj.EtcData("sxml0");
//		// ComShowMessage('sxml0:\n\n'+sxml0);
//		sheetObj.RemoveEtcData();
//		sheetObjects[4].LoadSearchXml(sxml0);
//		formObj.dtl_by_pool_only_mode.value = ''; // 다시 초기화...
//		sXml = null;
//		sxml0 = null;
		break;

	case IBINSERT:
        // CHM-201640694 Cost Calculation Tab에서 Multi-Row Add기능 추가 - 2016-04-01
		for (var i = 0; i < formObj.t5rowsadd.value; i++) {
			var Row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(Row, "calc_cost_grp_cd") = "SP";
			sheetObj.CellValue2(Row, "calc_tp_cd") = "M";
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
			sheetObj.CellValue2(Row, "io_bnd_cd") = "";
			sheetObj.CellValue2(Row, "fp_calc_prd_cd") = "D";
			sheetObj.CellValue2(Row, "inv_xch_rt") = 1;
			// sheetObj.CellValue2(Row,"tmp_dtl_seq") = getMaxTmpDtlSeq(sheetObj) +
			// 1;
			setShtCellsEditable(sheetObj,Row,'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt','Y');
			sheetObj.CellComboItem(Row, 'lgs_cost_cd', formObj.calcStorageComboItemsDesc.value, formObj.calcStorageComboItems.value);
			sheetObj.CellValue2(Row, "lgs_cost_cd") = "";
			sheetObj.CellValue2(Row, "ida_pay_tp_cd") = "S";
		}
		t5sheet1_ShowSubSum(sheetObj);
		t5sheet1_TotCalcAmt(sheetObj);
		break;

	case IBDELETE:
		if (sheetObj.RowCount > 0) {
			var Row = sheetObj.SelectRow;
			var calc_tp_cd = sheetObj.CellValue(Row, "calc_tp_cd");
			//if (calc_tp_cd != null && calc_tp_cd.trim() == 'M') {
			if (calc_tp_cd != null) {	//[CHM-201538267]ODCY Invoice에서 Auto Calculated된 Row삭제 가능하도록 로직 수정(MR과 일치)
				if (sheetObj.CellValue(Row, "tml_so_dtl_seq") == null
						|| sheetObj.CellValue(Row, "tml_so_dtl_seq").trim() == ''
						|| parseInt(sheetObj.CellValue(Row, "tml_so_dtl_seq"),
								10) == 0) {
					sheetObj.RowDelete(Row, false);
				} else {
					sheetObj.RowStatus(Row) = 'D';
					sheetObj.RowHidden(Row) = true;
					sheetObj.CellValue2(Row, "inv_amt") = 0; // 어짜피 지울넘...
																// 숨기더라도 SUBSUM
																// 계산에 반영되므로 0으로
																// 만들어야 합당...
				}
				t5sheet1_ShowSubSum(sheetObj);
				t5sheet1_TotCalcAmt(sheetObj);
			}
		}
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

/**
 * Main Hidden Sheet 관련 프로세스 처리
 * @param {sheet}	sheetObj	ibsheet
 * @param {form}	formObj		form
 * @param {int}		sAction		action code
 * @return
 */
function doActionMainHiddenSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
		
	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
	
		if (sheetObj.RowCount == 0) { // 현재 조회된 header의 결과가 없으므로 =>> 입력
			// 일단 조회 -> row가 있으면 중복msg + 중단 아니면 계속 save처리

			if (fnChkSearchForm()) { // vndr_seq와 inv_no값이 입력되었는지 확인
				formObj.f_cmd.value = SEARCH;
				sheetObjects[8].RemoveAll();
				sheetObjects[8].DoSearch4Post("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
				
				if (sheetObjects[8].RowCount == 0) {
					formObj.f_cmd.value = ADD;
				} else if (sheetObjects[8].RowCount == 1) {
					if (sheetObjects[8].CellValue(1, 'tml_inv_tp_cd') == 'TM') {
						ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice')); // ComShowMessage('[D] Terminal invoice와 중복됩니다.');
						sheetObjects[5].RemoveAll();
						return false;
					} else if (sheetObjects[8].CellValue(1, 'tml_inv_tp_cd') == 'ST') {
						ComShowMessage(ComGetMsg('TES23030', 'Storage invoice')); // ComShowMessage('[D] Storage invoice와 중복됩니다.');
						sheetObjects[5].RemoveAll();
						return false;
					} else if (sheetObjects[8].CellValue(1, 'tml_inv_tp_cd') == 'ON') {
						ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice')); // ComShowMessage('[D] On-dock invoice와 중복됩니다.');
						sheetObjects[5].RemoveAll();
						return false;
					}
					if (!confirm(ComGetMsg('TES24071'))) {
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
						sheetObjects[3].RemoveAll();
						sheetObjects[4].RemoveAll();
						sheetObjects[5].RemoveAll();
						sheetObjects[6].RemoveAll();
						sheetObjects[7].RemoveAll();
						sheetObjects[8].RemoveAll();
						return false;
					} else {
						// main hidden sheet - 기본정보조회
						try {
							formObj.f_cmd.value = SEARCH;
							sheetObjects[5].DoSearch4Post("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));

							if (sheetObjects[5].RowCount == 1) {

								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH); // COIN,DSCP - 조회
								setCalcCostCond();
								doActionIBSheet3(sheetObjects[2], formObj, IBSEARCH); // Calc.XXX - 조회

								var cost_calc_tmnl = false;
								var cost_calc_day = false;
								var cost_calc_pool = true;
								var curr_tab_idx = 0;

								if (formObj.TMNL.checked == true) {
									cost_calc_tmnl = true;
								} else {
									cost_calc_tmnl = false;
								}
								if (formObj.StorageDay.checked == true) {
									cost_calc_day = true;
								} else {
									cost_calc_day = false;
								}

								// 예외 - DISCREPANCY가 있을 경우...
								if (sheetObjects[1].RowCount > 0) {
									curr_tab_idx = 1;
								}

								setSheetsEnable(curr_tab_idx, true);
							}
							break;
						} catch (e) {
							ComShowMessage(e);
							sheetObjects[0].RemoveAll();
							sheetObjects[1].RemoveAll();
							sheetObjects[2].RemoveAll();
							sheetObjects[3].RemoveAll();
							sheetObjects[4].RemoveAll();
							sheetObjects[5].RemoveAll();
							sheetObjects[6].RemoveAll();
							sheetObjects[7].RemoveAll();
							sheetObjects[8].RemoveAll();
							return false;
						}
					}
				} else {
					// rowcount가 음수가 나오면 sheet가 미친겁니다...
					ComShowMessage(ComGetMsg('TES23031')); // ComShowMessage('[ERR1] - 복수개의 HEADER가 조회되었습니다. 관리자에게 문의하십시오.');
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					sheetObjects[4].RemoveAll();
					sheetObjects[5].RemoveAll();
					sheetObjects[6].RemoveAll();
					sheetObjects[7].RemoveAll();
					sheetObjects[8].RemoveAll();
					return false;
				}
			} else {
				ComShowMessage(ComGetMsg('TES23032', 'VNDR Code', 'Inv.No')); // ComShowMessage('VNDR Code와 Inv.No값을 입력하셔야 합니다.');
				return false;
			}
		} else if (sheetObj.RowCount == 1) { // 이미 조회된 header의 결과가 존재 =>> 수정
			if (formObj.vndr_seq.value == sheetObj.CellValue(1, 'vndr_seq')
					&& formObj.inv_no.value == sheetObj.CellValue(1, 'inv_no')) {
				formObj.f_cmd.value = MODIFY;
			} else {
				ComShowMessage(ComGetMsg('TES21035'));
				return false;
			}
		} else {
			ComShowMessage(ComGetMsg('TES23031')); // ComShowMessage('[ERR2] - 복수개의 HEADER가 조회되었습니다. 관리자에게  문의하십시오.');
			return false;
		}

		/** 여기까지 왔으면 저장하겠다는 강력한 의지를 보이는것 => 저장 * */
		formObj.ttl_inv_amt.value = tes_deleteComma(formObj.ttl_inv_amt.value);
		formObj.vat_amt.value = tes_deleteComma(formObj.vat_amt.value);
		formObj.whld_tax_amt.value = tes_deleteComma(formObj.whld_tax_amt.value);

		var param = sheetObj.GetSaveString();
		var savexml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		sheetObj.LoadSaveXml(savexml, true);
		break;

	case IBINSERT:
		var Row = sheetObj.DataInsert();
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		sheetObj.SpeedDown2Excel(-1);
		break;
	}
}

 /**
  * Reject Hidden Sheet 관련 프로세스 처리
  * @param {sheet}	sheetObj	ibsheet
  * @param {form}	formObj		form
  * @param {int}	sAction		action code
  * @return
  */
function doActionRejectHiddenSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH:
		break;

	case IBSAVE:
		formObj.f_cmd.value = MODIFY01;
		var savexml = sheetObj.GetSaveXml("ESD_TES_0004GS.do",tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		sheetObj.LoadSaveXml(savexml, true);
		break;
	}
}

/**
 * [Each. Rate] 유효성 체크
 * @param {sheet}	sheets	Cost Calc. sheets
 * @return
 */
function checkInvXchRt(sheets) {
	var returnValue = true;
	var curr_cd_hdr = document.form.curr_cd.Code;
	for ( var i = 0; i < sheets.length; i++) {
		for ( var j = sheets[i].HeaderRows; sheets[i] != null
				&& sheets[i].RowCount > 0
				&& j < (sheets[i].HeaderRows + sheets[i].RowCount); j++) {
			if (sheets[i].CellValue(j, 'calc_tp_cd') == 'A') {
				if (curr_cd_hdr != undefined
						&& curr_cd_hdr != null
						&& curr_cd_hdr != ''
						&& sheets[i].CellValue(j, 'curr_cd') != undefined
						&& sheets[i].CellValue(j, 'curr_cd') != null
						&& sheets[i].CellValue(j, 'curr_cd') != ''
						&& sheets[i].CellValue(j, 'curr_cd') != curr_cd_hdr
						&& parseFloat(sheets[i].CellValue(j, 'inv_xch_rt')) <= 0) {
					sheets[i].CellBackColor(j, 'inv_xch_rt') = sheets[i]
							.RgbColor(255, 153, 153);
					returnValue = false;
				}
			}
		}
	}
	return returnValue;
}

/**
 * Confirm  Hidden Sheet 관련 프로세스 처리
  * @param {sheet}	sheetObj	ibsheet
  * @param {form}	formObj		form
  * @param {int}	sAction		action code
  * @return
  */
function doActionConfirmHiddenSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // confirm확인
		break;

	case IBSAVE: // 저장
		// CostCalc.XXX에 아직 DB에 저장하지 않은 ROW를 확인하고 전부 저장된 상태이면 CONFIRM을 허용한다.
		if (sheetObjects[2].RowCount <= 0 && sheetObjects[3].RowCount <= 0 && sheetObjects[4].RowCount <= 0) {
			ComShowMessage(ComGetMsg('TES23033')); // ComShowMessage('confirm할 계산 // data가 없습니다.');
			return false;
		}

		var sheets = new Array();
		sheets[0] = sheetObjects[0];
		sheets[1] = sheetObjects[1];

		var params = new Array();
		params[0] = sheetObjects[0].GetSaveString(false, false);
		params[1] = sheetObjects[1].GetSaveString(false, false);

		if (tes_isModified(sheets, params)) {
			// if (!confirm('Coincidence/Discrepancy의 tab에 수정한 data가 있습니다. 무시하고 confirm을 하겠습니까?')){
			if (!confirm(ComGetMsg('TES23034'))) {
				return false;
			}
		}

		var sheets2 = new Array();
		sheets2[0] = sheetObjects[2];
		sheets2[1] = sheetObjects[3];
		sheets2[2] = sheetObjects[4];

		if (!checkInvXchRt(sheets2)) {
			ComShowMessage(ComGetMsg('TES21026', 'Exch.Rate')); // ComShowMessage('이런! 빼묵지 말구.. 잘 좀 넣어봐...');
			return false;
		}

		// INV AMT의 일치여부
		if (formObj.ttl_inv_amt.value == null || formObj.ttl_inv_amt.value.trim() == '') {
			formObj.ttl_inv_amt.value = 0;
		}
		var ttl_inv_amt = tes_deleteComma(formObj.ttl_inv_amt.value);
		if (isNaN(parseFloat(tes_deleteComma(formObj.ttl_inv_amt.value)))) {
			ComShowMessage(ComGetMsg('TES24008', 'INV AMT')); // ComShowMessage('INV AMT가 유효하지 않습니다.');
			return false;
		}

		var total_inv_amt = 0;
		var TMNL_check = false;
		var StorageByDay_check = false;
		var StorageByPool_check = true; // Pool은 무조건 TRUE
		var tml_cost_grp_cd = sheetObjects[5].CellValue(1, 'tml_cost_grp_cd');
		var tml_calc_ind_cd = sheetObjects[5].CellValue(1, 'tml_calc_ind_cd');
		var sto_dys_ind_cd = sheetObjects[5].CellValue(1, 'sto_dys_ind_cd');
		if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.trim().length == 2) {
			if (tml_cost_grp_cd.trim().substring(0, 1) == 'T') {
				TMNL_check = true;
			}
			if (tml_cost_grp_cd.trim().substring(1, 2) == 'D') {
				StorageByDay_check = true;
			}
		} else {
			ComShowMessage(ComGetMsg('TES24036')); // ComShowMessage('Cost Group Code에 오류 발생!');
			return false;
		}

		if (TMNL_check) {
			if (formObj.t3sht_tot_inv_amt.value != null
					&& formObj.t3sht_tot_inv_amt.value.trim() != '') {
				total_inv_amt = total_inv_amt
						+ parseFloat(tes_deleteComma(formObj.t3sht_tot_inv_amt.value))
						* 1000000;
			}
		}
		if (StorageByDay_check) {
			if (formObj.t4sht_tot_inv_amt.value != null
					&& formObj.t4sht_tot_inv_amt.value.trim() != '') {
				total_inv_amt = total_inv_amt
						+ parseFloat(tes_deleteComma(formObj.t4sht_tot_inv_amt.value))
						* 1000000;
			}
		}
		if (StorageByPool_check) {
			if (formObj.t5sht_tot_inv_amt.value != null
					&& formObj.t5sht_tot_inv_amt.value.trim() != '') {
				total_inv_amt = total_inv_amt
						+ parseFloat(tes_deleteComma(formObj.t5sht_tot_inv_amt.value))
						* 1000000;
			}
		}
		total_inv_amt /= 1000000;
		// ComShowMessage('ttl_inv_amt:'+ttl_inv_amt+' /
		// total_inv_amt:'+total_inv_amt + '\n\n'
		// +parseFloat(tes_deleteComma(formObj.t3sht_tot_inv_amt.value)) + '\n'
		// +parseFloat(tes_deleteComma(formObj.t4sht_tot_inv_amt.value)) + '\n'
		// +parseFloat(tes_deleteComma(formObj.t5sht_tot_inv_amt.value)));
		if (ttl_inv_amt != total_inv_amt) {
			ComShowMessage(ComGetMsg('TES24037', 'INV AMT', 'AMT')); // ComShowMessage('( '+ttl_inv_amt+' / '+total_inv_amt+' ) - 저장된 INV AMT와 계산된 AMT가 일치하지 않습니다.');
			return false;
		}
		
		if(ida_ofc_cd == 'Y'){
			var ttl_cgst_amt = parseFloat(tes_deleteComma(formObj.ida_cgst_amt.value));
			var total_cgst_amt = 0;
			if (formObj.t3sht_tot_cgst_amt.value!=undefined && formObj.t3sht_tot_cgst_amt.value!=null &&
					formObj.t3sht_tot_cgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t3sht_tot_cgst_amt.value))){
				total_cgst_amt = total_cgst_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_cgst_amt.value))*1000000;
			}
			if (formObj.t4sht_tot_cgst_amt.value!=undefined && formObj.t4sht_tot_cgst_amt.value!=null &&
					formObj.t4sht_tot_cgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t4sht_tot_cgst_amt.value))){
				total_cgst_amt = total_cgst_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_cgst_amt.value))*1000000;
			}
			if (formObj.t5sht_tot_cgst_amt.value!=undefined && formObj.t5sht_tot_cgst_amt.value!=null &&
					formObj.t5sht_tot_cgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t5sht_tot_cgst_amt.value))){
				total_cgst_amt = total_cgst_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_cgst_amt.value))*1000000;
			}			
			total_cgst_amt /= 1000000;

			if(ttl_cgst_amt != total_cgst_amt) {
			   	ComShowMessage(ComGetMsg('TES21056')); 
				return false;
			}
			
			var ttl_sgst_amt = parseFloat(tes_deleteComma(formObj.ida_sgst_amt.value));
			var total_sgst_amt = 0;
			if (formObj.t3sht_tot_sgst_amt.value!=undefined && formObj.t3sht_tot_sgst_amt.value!=null &&
					formObj.t3sht_tot_sgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t3sht_tot_sgst_amt.value))){
				total_sgst_amt = total_sgst_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_sgst_amt.value))*1000000;
			}
			if (formObj.t4sht_tot_sgst_amt.value!=undefined && formObj.t4sht_tot_sgst_amt.value!=null &&
					formObj.t4sht_tot_sgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t4sht_tot_sgst_amt.value))){
				total_sgst_amt = total_sgst_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_sgst_amt.value))*1000000;
			}
			if (formObj.t5sht_tot_sgst_amt.value!=undefined && formObj.t5sht_tot_sgst_amt.value!=null &&
					formObj.t5sht_tot_sgst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t5sht_tot_sgst_amt.value))){
				total_sgst_amt = total_sgst_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_sgst_amt.value))*1000000;
			}
			total_sgst_amt /= 1000000;
			
			if(ttl_sgst_amt != total_sgst_amt) {
			   	ComShowMessage(ComGetMsg('TES21057')); 
				return false;
			}
			
			var ttl_igst_amt = parseFloat(tes_deleteComma(formObj.ida_igst_amt.value));
			var total_igst_amt = 0;
			if (formObj.t3sht_tot_igst_amt.value!=undefined && formObj.t3sht_tot_igst_amt.value!=null &&
					formObj.t3sht_tot_igst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t3sht_tot_igst_amt.value))){
				total_igst_amt = total_igst_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_igst_amt.value))*1000000;
			}
			if (formObj.t4sht_tot_igst_amt.value!=undefined && formObj.t4sht_tot_igst_amt.value!=null &&
					formObj.t4sht_tot_igst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t4sht_tot_igst_amt.value))){
				total_igst_amt = total_igst_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_igst_amt.value))*1000000;
			}
			if (formObj.t5sht_tot_igst_amt.value!=undefined && formObj.t5sht_tot_igst_amt.value!=null &&
					formObj.t5sht_tot_igst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t5sht_tot_igst_amt.value))){
				total_igst_amt = total_igst_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_igst_amt.value))*1000000;
			}
			total_igst_amt /= 1000000;
			
			if(ttl_igst_amt != total_igst_amt) {
			   	ComShowMessage(ComGetMsg('TES21058')); 
				return false;
			}
			
			var ttl_ugst_amt = parseFloat(tes_deleteComma(formObj.ida_ugst_amt.value));
			var total_ugst_amt = 0;
			if (formObj.t3sht_tot_ugst_amt.value!=undefined && formObj.t3sht_tot_ugst_amt.value!=null &&
					formObj.t3sht_tot_ugst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t3sht_tot_ugst_amt.value))){
				total_ugst_amt = total_ugst_amt + parseFloat(tes_deleteComma(formObj.t3sht_tot_ugst_amt.value))*1000000;
			}
			if (formObj.t4sht_tot_ugst_amt.value!=undefined && formObj.t4sht_tot_ugst_amt.value!=null &&
					formObj.t4sht_tot_ugst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t4sht_tot_ugst_amt.value))){
				total_ugst_amt = total_ugst_amt + parseFloat(tes_deleteComma(formObj.t4sht_tot_ugst_amt.value))*1000000;
			}
			if (formObj.t5sht_tot_ugst_amt.value!=undefined && formObj.t5sht_tot_ugst_amt.value!=null &&
					formObj.t5sht_tot_ugst_amt.value.trim()!='' && !isNaN(tes_deleteComma(formObj.t5sht_tot_ugst_amt.value))){
				total_ugst_amt = total_ugst_amt + parseFloat(tes_deleteComma(formObj.t5sht_tot_ugst_amt.value))*1000000;
			}
			total_ugst_amt /= 1000000;
			
			if(ttl_ugst_amt != total_ugst_amt) {
			   	ComShowMessage(ComGetMsg('TES21059')); 
				return false;
			}
		}
		
		if (!isValIssSys(formObj.iss_dt)){ 	
			return false;
		}else if (!isValIssSys(formObj.rcv_dt)){ 	
			return false;
		}

		/***********************************************************************
		 * 일단 HDR, CALC 정보를 저장한다. CNTR_LIST빼고 - <주> 일단 임시로 나눠서 저장하지만 하나로 묶어서 전부
		 * 저장할 수 있게 변경해야 한데이.
		 **********************************************************************/
		doActionMainHiddenSheet(sheetObjects[5], formObj, IBSAVE); // hdr 정보 저장
		doActionIBSheet3(sheetObjects[2], formObj, IBSAVE, 'Y'); // calc list (TMNL,ByDay) 정보 저장
		doActionIBSheet5(sheetObjects[4], formObj, IBSAVE, 'Y'); // calc list (ByPool) 정보 저장
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		// confirm한다 -> 더 이상 저장/수정 불가 .. 조회만 가능
		formObj.confirm_mode.value = 'CONFIRM';
		formObj.f_cmd.value = MULTI02;
		var param = sheetObj.GetSaveString();
		var savexml = sheetObj.GetSaveXml("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
		sheetObj.LoadSaveXml(savexml, true);
		break;

	}
}

/**
 * 저정되어있는 period 와 sheet period 의 일치 여부 체크
 * @return
 */
function checkPeriodModified() {

	var formObj = document.form;
	// if
	// (formObj.fm_prd_dt.value.trim().replace(/-/gi,'')!=sheetObjects[5].CellValue(1,"fm_prd_dt").trim().replace(/-/gi,'')
	// ||
	// formObj.to_prd_dt.value.trim().replace(/-/gi,'')!=sheetObjects[5].CellValue(1,"to_prd_dt").trim().replace(/-/gi,''))
	if (formObj.fm_prd_dt.value.trim() != sheetObjects[5].CellValue(1, "fm_prd_dt").trim()
			|| formObj.to_prd_dt.value.trim() != sheetObjects[5].CellValue(1, "to_prd_dt").trim()) {
		ComShowMessage(ComGetMsg('TES24038')); // ComShowMessage('Period의 날짜가 저장된 날짜와 다름니다.\n\nPeriod를 저장하시거나 수정하셔야 합니다.');
		return false;
	}
	return true;
}

/**
 * main hidden sheet 조회가 완료되고 발생하는 이벤트
 * @param {ibsheet}	main_hidden main hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */	
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {

	var formObj = document.form;

	if (main_hidden.RowCount == 1) {	
		// session의 inv_ofc_cd와 so hdr의 inv_ofc_cd가 동일한지 확인하는 부분...
		if (formObj.inv_ofc_cd == undefined 
				|| formObj.inv_ofc_cd.value == null 
				|| formObj.inv_ofc_cd.value.trim() == '') {
			ComShowMessage('No Inv OFC data is found in the session');
			return false;
		}
		if (main_hidden.CellValue(1, 'inv_ofc_cd') == undefined
				|| main_hidden.CellValue(1, 'inv_ofc_cd') == null
				|| main_hidden.CellValue(1, 'inv_ofc_cd').trim() == '') {
			ComShowMessage('No Inv OFC data is retrieved');
			return false;
		}
		if (main_hidden.CellValue(1, 'inv_ofc_cd') != formObj.inv_ofc_cd.value) {
			ComShowMessage("No authority to correct/delete the invoice - Invoice office mismatch!");
			return false;
		}

		if (main_hidden.CellValue(1, 'tml_inv_tp_cd') != 'OF') {
			setHeaderKeyValueReadonly('N');
			setSheetsEnable(-1, false);
			formObj.reset();
			if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'TM') {
				ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice')); // 'Terminal invoice와  중복됩니다.'
			} else if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'ST') {
				ComShowMessage(ComGetMsg('TES23030', 'Storage invoice')); // 'Storage invoice와 중복됩니다.'
			} else if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'ON') {
				ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice')); // 'On-dock invoice와 중복됩니다.');
			} else {
				ComShowMessage(ComGetMsg('TES21034')); // '저장된 data가 없습니다.'
			}
			return;
		}

		if (main_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'C') {
			if (confirm(ComGetMsg('TES23039'))) {	// '[1]confirm된 상태입니다. confirm상태를 해제하고 수정을 하시겠습니까?'
				formObj.f_cmd.value = MULTI03; // reject상태가 'RJ'이면 'RL'로 설정한다.
				var param = main_hidden.GetSaveString();
				var savexml = sheetObjects[7].GetSaveXml("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
				sheetObjects[7].LoadSaveXml(savexml, true);
				return false;
			} else {
				tes_new0004();
				return false;
			}
		} else if (main_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined
				&& main_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'A') {
			tes_new0004();
			ComShowMessage(ComGetMsg('TES24040')); // 'Approval Request 처리된 상태입니다.'
			return false;
		} else if (main_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined
				&& main_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'P') {
			tes_new0004();
			ComShowMessage(ComGetMsg('TES24041')); // ComShowMessage('A/P Interface 처리된 상태입니다.');
			return false;
		} else if (main_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined && main_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'R') {
			// 통과
		} else {
			tes_new0004();
			ComShowMessage(ComGetMsg('TES40051')); // 유효하지 않는 invoice 상태입니다. 관리자에게 문의하십시오.');
			return false;
		}

		if (main_hidden.CellValue(1, 'tml_inv_rjct_sts_cd') != undefined
				&& main_hidden.CellValue(1, 'tml_inv_rjct_sts_cd').trim() == 'RJ') {
			// if (confirm('[1]reject된 상태입니다. reject상태를 해제하고 수정을 하시겠습니까?')){
			if (confirm(ComGetMsg('TES23042'))) {
				formObj.f_cmd.value = MULTI04; // reject상태를 'NL'로 설정한다.
				var param = main_hidden.GetSaveString();
				var savexml = sheetObjects[6].GetSaveXml("ESD_TES_0004GS.do", param + '&' + tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
				sheetObjects[6].LoadSaveXml(savexml, true);
				return false;
			} else {
				tes_new0004();
				return false;
			}
		}

		confirm_done = false;
		
		formObj.reset();
		
		enableForm();
		setHeaderKeyValueReadonly('Y');
		
		save_conf_01 = true; // 상위 기본 정보 저장이 확인된 경우만 활성화
		setHdSheet2Form(); // 검색된 sheet의 data로 form을 채운다.

		if (formObj.yd_cd.value != null && formObj.yd_cd.value.trim() != '') {
			// <주> setHdSheet2Form()가 반드시 먼저 실행이 되어서 main_hidden의 결과가 form에 다 반영되어야 yd_cd를 가지고 조회가 가능 한다.
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
		}
		// agreement의 status를 가져온다
		validateAgmtSts();
		
		// 저장된 결과에 대해..처리..
		var cost_calc_tmnl = false;
		var cost_calc_day = false;
		var cost_calc_pool = true;
		var curr_tab_idx = 0;

		if (formObj.TMNL.checked == true) {
			cost_calc_tmnl = true;
		} else {
			cost_calc_tmnl = false;
		}
		if (formObj.StorageDay.checked == true) {
			cost_calc_day = true;
		} else {
			cost_calc_day = false;
		}

		setSheetsEnable(-1, true);

		//필요없는듯해서 일단 주석 이정혜
		//tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
		validateVndrSeq();
		
		/**
		 * 	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
		 *  Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아위한 button활성화 (2009-10-15)
		 */
		 try {
			 for (var i = 0; i < formObj.elements.length; i++){
				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
				 {
					 with (formObj) {
						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
							 document.all.PreInquiryCondLayer01.style.display = "inline";
							 break;
						 }
					 }
				 }
			 }
		 } catch(e){}
		 
        if (main_hidden.CellValue(1, 'ap_rvs_cng_flg')=='Y'){
        	formObj.ap_rvs_cng_flg.checked = true;
        } else {
        	formObj.ap_rvs_cng_flg.checked = false;
        }
	        
		// 반드시 form설정이 마친 다음에 sheet들을 조회하는것을 실행하셩
		doActionIBSheetAllSheets(sheetObjects[0], formObj, IBSEARCH);
		init_Arr_sht_chk();
		tes_getInputValue('DB_DATE', SEARCH06, '','');
	} else if (main_hidden.RowCount > 1) {
		ComShowMessage(ComGetMsg('TES24043')); // ComShowMessage('[ERR] 복수개의 header data가 조회되었습니다. 관리자에게 문의하십시오.');
		tes_new0004();
		return false;
	} else if(formObj.is_dup_inv_no.value == 'Y'){ 
		ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No is duplicated in ERP(A/P). \n\nPlz, change to another Invoice No.');
        setInitComponent("N");
		return false;
	} else if (main_hidden.RowCount == 0) {
		// if (!confirm('invoice가 없습니다. 새로 생성하시겠습니까?')){
		if (!confirm(ComGetMsg('TES40031'))) {
			tes_new0004('Y');
			setSheetsEnable(-1, false);
			if (document.form.vndr_seq.value != null
					&& document.form.vndr_seq.value != '') {
				document.form.inv_no.focus();
			} else {
				document.form.vndr_seq.focus();
			}
			return false;
		} else {
			enablePage('Y');
			if (document.form.vndr_seq.value != null
					&& document.form.vndr_seq.value != '') {
				document.form.inv_no.focus();
			} else {
				document.form.vndr_seq.focus();
			}
		}
	} else {
		// 음수가 나오면 SHEET가 진짜 미친겁니다.
	}
}

/**
 * main hidden sheet 저장 완료되고 발생하는 이벤트
 * @param {ibsheet}	main_hidden main hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */	
function main_hidden_OnSaveEnd(main_hidden, ErrMsg) {

	if (ErrMsg != null && ErrMsg.trim() != "") {
		return false;
	} // -> confirm하는 경우 다른 data를 저장을 하는데 invoice오류로 main관련된 event가 실행되는것을 막기 위함...

	var formObj = document.form;
	tes_getInputValue('DB_DATE', SEARCH06, '','');
	if (main_hidden.RowCount == 1) {

		if (main_hidden.CellValue(1, 'tml_inv_tp_cd') != 'OF') {
			setHeaderKeyValueReadonly('N');
			setSheetsEnable(-1, false);
			formObj.reset();
			if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'TM') {
				ComShowMessage(ComGetMsg('TES23030', 'Terminal invoice')); // ComShowMessage('Terminal invoice 와 중복됩니다.');
			} else if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'ST') {
				ComShowMessage(ComGetMsg('TES23030', 'Storage invoice')); // ComShowMessage('Storage invoice 와 중복됩니다.');
			} else if (main_hidden.CellValue(1, 'tml_inv_tp_cd') == 'ON') {
				ComShowMessage(ComGetMsg('TES23030', 'On-dock invoice')); // ComShowMessage('On-dock invoice 와 중복됩니다.');
			} else {
				ComShowMessage(ComGetMsg('TES21034')); // ComShowMessage('[3] 저장된 data 가 없습니다.');
			}
			return;
		}

		if (main_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined
				&& main_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'C') {
			// if (confirm('[2] confirm된 상태입니다. confirm상태를 해제하고 수정을 하시겠습니까?')){
			if (confirm(ComGetMsg('TES23039'))) {
				formObj.f_cmd.value = MULTI03;
				var savexml = sheetObjects[7].GetSaveXml("ESD_TES_0004GS.do",tesFrmQryStr(formObj,'tmp_common_code|calcTerminalComboItems|calcStorageComboItems|sht_01_ttl_box|sht_01_full|sht_01_mt|sht_01_ts_same_yard|sht_01_D2|sht_01_D4|sht_01_D5|sht_01_D7|sht_01_D8|sht_01_D9|sht_01_DW|sht_01_DX|sht_01_R2|sht_01_R4|sht_01_R5|sht_01_R7|sht_01_R8|sht_01_R9|sht_01_F2|sht_01_F4|sht_01_F5|sht_01_O2|sht_01_O4|sht_01_O5|sht_01_S2|sht_01_S4|sht_01_T2|sht_01_T4|sht_01_A2|sht_01_A4|sht_01_A5|sht_01_P2|sht_01_P4|sht_01_C2|sht_01_C4'));
				sheetObjects[7].LoadSaveXml(savexml, true);
				return;// false;
			} else {
				tes_new0004();
				return;// false;
			}
		} else {
			confirm_done = false;
			enableForm();
			setHeaderKeyValueReadonly('Y');
		}

		save_conf_01 = true; // 상위 기본 정보 저장이 확인된 경우만 활성화

		// 검색된 sheet의 data로 form을 채운다.
		if (formObj.confirm_mode.value != undefined
				&& formObj.confirm_mode.value == 'CONFIRM') {
			setHdSheet2Form('CONFIRM');
		} else {
			setHdSheet2Form('SAVE');
		}

		if (formObj.yd_cd.value != null && formObj.yd_cd.value.trim() != '') {
			// <주> setHdSheet2Form()가 반드시 먼저 실행이 되어서 main_hidden의 결과가 form에 다
			// 반영되어야 yd_cd를 가지고 조회가 가능 한다.
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
		}

		// agreement의 currency code와 so header의 currency code를 비교 확인하기
		validateAgmtCurrCD();

		// agreement의 status를 가져온다
		validateAgmtSts();

		// 저장된 결과에 대해..처리..
		var cost_calc_tmnl = false;
		var cost_calc_day = false;
		var cost_calc_pool = true;
		var curr_tab_idx = 0;

		if (formObj.TMNL.checked == true) {
			cost_calc_tmnl = true;
		} else {
			cost_calc_tmnl = false;
		}
		if (formObj.StorageDay.checked == true) {
			cost_calc_day = true;
		} else {
			cost_calc_day = false;
		}

		setSheetsEnable(-1, true);

		tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));

	} else if (main_hidden.RowCount > 1) {
		ComShowMessage(ComGetMsg('TES24043')); // ComShowMessage('[ERR] 복수개의 header
											// data가 조회되었습니다. 관리자에게 문의하십시오.');
		tes_new0004();
		return false;
	} else {
		setHeaderKeyValueReadonly('N');
		setSheetsEnable(-1, false);
		// formObj.reset();
		ComShowMessage(ComGetMsg('TES21034')); // ComShowMessage('[4] 저장된 data가
											// 없습니다.');
		return false;
	}
}

/**
 * reject hidden sheet 조회가 완료되고 발생하는 이벤트
 * @param {ibsheet}	rjct_hidden reject hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */	
function rjct_hidden_OnSaveEnd(rjct_hidden, ErrMsg) {

	var formObj = document.form;

	if (rjct_hidden.RowCount == 1) {
		// formObj.f_cmd_rjct.value = ''; //반드시 다시 초기화해야한다.
		main_hidden.CellValue2(1, 'tml_inv_rjct_sts_cd') = rjct_hidden.CellValue(1, 'tml_inv_rjct_sts_cd');
		main_hidden.CellValue2(1, 'inv_rjct_dt') = rjct_hidden.CellValue(1,'inv_rjct_dt');
		main_hidden.CellValue2(1, 'inv_rjct_rmk') = rjct_hidden.CellValue(1,'inv_rjct_rmk');
		if (rjct_hidden.CellValue(1, 'tml_inv_rjct_sts_cd') != undefined
				&& rjct_hidden.CellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
			document.form.tml_inv_rjct_sts_cd.value = rjct_hidden.CellValue(1,'tml_inv_rjct_sts_cd');
			document.form.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_hidden.CellValue(1, 'tml_inv_rjct_sts_cd'));
			disableAftRjct();
			ComShowMessage(ComGetMsg('TES23063')); // ComShowMessage('reject처리가
												// 완료되었습니다.');
		} else {
			enableForm();
			retrieve();
		}
	} else if (rjct_hidden.RowCount > 1) {
		ComShowMessage(ComGetMsg('TES40047')); // ComShowMessage('[ERR] 복수개의 rjct header data가 조회되었습니다. 관리자에게 문의하십시오.');
		tes_new0004();
		return false;
	} else {
		return false;
	}
}

 /**
  * conf hidden sheet 조회가 완료되고 발생하는 이벤트
  * @param {ibsheet}	rjct_hidden reject hidden sheet
  * @param {string}	ErrMsg		error message
  * @return
  */	
function conf_hidden_OnSaveEnd(conf_hidden, ErrMsg) {

	var formObj = document.form;

	if (conf_hidden.RowCount == 1) {
		main_hidden.CellValue2(1, 'tml_inv_sts_cd') = conf_hidden.CellValue(1,'tml_inv_sts_cd');
		main_hidden.CellValue2(1, 'inv_cfm_dt') = conf_hidden.CellValue(1,'inv_cfm_dt');
		formObj.tml_inv_sts_cd.value = conf_hidden.CellValue(1,'tml_inv_sts_cd');
		var inv_sts_cd = conf_hidden.CellValue(1, 'tml_inv_sts_cd');
		if (inv_sts_cd != undefined && inv_sts_cd == 'R') {
			inv_sts_cd = 'RC'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'C') {
			inv_sts_cd = 'CF'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'P') {
			inv_sts_cd = 'AP'
		} else if (inv_sts_cd != undefined && inv_sts_cd == 'A') {
			inv_sts_cd = 'AR'
		}
		formObj.tml_inv_sts_cd2.value = inv_sts_cd;
		formObj.tml_inv_sts_cd2.title = tes_getInvStsFullNm(inv_sts_cd);
		
		if (conf_hidden.CellValue(1, 'tml_inv_sts_cd') != undefined && conf_hidden.CellValue(1, 'tml_inv_sts_cd').trim() == 'C') {
			confirm_done = true;
			ComShowMessage(ComGetMsg('TES24044')); // ComShowMessage('confirm처리 완료 상태');
			disableAftConf();
		} else {
			confirm_done = false;
			enableForm();
			// ComShowMessage('confirm -> 정상 복구');
			retrieve();
		}
		//setHeaderKeyValueReadonly('N');
		//tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
	} else if (conf_hidden.RowCount > 1) {
		ComShowMessage(ComGetMsg('TES40046')); // ComShowMessage('[ERR] 복수개의 conf data가 조회되었습니다. 관리자에게 문의하십시오.');
		tes_new0004();
		return false;
	} else {
		return false;
	}
}

/**
 * 첫번째 탭(Coincidence) sheet 위에서 마우스가 욺직일때 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		Button		마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int}		Shift		Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {long}	X			X 좌표
 * @param {long}	Y			Y 좌표
 * @return
 */	
function t1sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
	var row = t1sheet1.MouseRow;
	var col = t1sheet1.MouseCol;
	if (t1sheet1.ColSaveName(col) == "dscr_ind_cd" && row >= 1
			&& t1sheet1.CellValue(row, "dscr_ind_cd") != null
			&& t1sheet1.CellValue(row, "dscr_ind_cd") != '') {
		// t1sheet1.MouseToolTipText =
		// tes_getInvVerifyResultFullNm(t1sheet1.CellValue(row,"dscr_ind_cd"));
		t1sheet1.ToolTipText(row, col) = tes_getInvVerifyResultFullNm(t1sheet1.CellValue(row, "dscr_ind_cd"));
	}
}

/**
 * 첫번째 탭(Coincidence) sheet 조회시 발생하는 이벤트
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
	setCoinShtStat();
	if (confirm_done) {
		disableSheetEditable(t1sheet1);
	}
	t1sheet1_SetChkBoxDisabled();
}
 /**
  * 첫번째 탭(Coincidence) sheet 저장시 발생하는 이벤트
  * @param {sheet}	t1sheet1	Coincidence sheet
  * @param {string}	ErrMsg		error message
  * @return
  */
function t1sheet1_OnSaveEnd(t1sheet1, ErrMsg) {
	setCoinShtStat();
	if (confirm_done) {
		disableSheetEditable(t1sheet1);
	}
	t1sheet1_SetChkBoxDisabled();
}

/**
 * 첫번째 탭(Coincidence) sheet check box disable
 * @return
 */
function t1sheet1_SetChkBoxDisabled() {
	var DISABLE_YN;
	if (isAutoCalcDataExisting()) {
		DISABLE_YN = 'Y';
	} else {
		DISABLE_YN = 'N';
	}
	DISABLE_YN = 'N'; // => INITSHEET에서 'chk'를 수정 불가하므로 여기서 푸는것으로 변경
	if (sheetObjects[0].RowCount > 0) {
		for ( var i = 1; i <= sheetObjects[0].RowCount; i++) {
			// 변환문자를 특수 문자로 치환. (2010-04-28)
			sheetObjects[0].CellValue2(i, "cntr_rmk") = ComToString( sheetObjects[0].CellValue(i, "cntr_rmk") );
			
			// sheetObjects[0].CellEditable(i,'chk') = false;
			if (DISABLE_YN != null && DISABLE_YN == 'Y') {
				sheetObjects[0].CellEditable(i, 'chk') = false;
			} else {
				sheetObjects[0].CellEditable(i, 'chk') = (sheetObjects[0].CellValue(i, 'modi_flg') == 'Y' ? true : false);
			}
		}
	}
}

/**
 * 두번째 탭(Discrepancy) sheet check box disable
 * @return
 */
function t2sheet1_SetChkBoxDisabled() {
	var DISABLE_YN;
	if (isAutoCalcDataExisting()) {
		DISABLE_YN = 'Y';
	} else {
		DISABLE_YN = 'N';
	}
	if (sheetObjects[1].RowCount > 0) {
		for ( var i = sheetObjects[1].HeaderRows; i < (sheetObjects[1].HeaderRows + sheetObjects[1].RowCount); i++) {
			// 변환문자를 특수 문자로 치환. (2010-04-28)
			sheetObjects[1].CellValue2(i, "cntr_rmk") = ComToString( sheetObjects[1].CellValue(i, "cntr_rmk") );
			// sheetObjects[1].CellEditable(i,'chk') =
			// (DISABLE_YN!=null&&DISABLE_YN=='Y'?false:true);
			
			//[CHM-201536553]GIO방식에서 Actual Movement Date 없는 것은 Coincidence로 넘기지 못하도록 로직수정
			if (document.form.CostCalcMethod[0].checked == true) { // TP
				if(sheetObjects[1].CellValue(i, 'mvmt_gate_in_dt') == null || sheetObjects[1].CellValue(i, 'mvmt_gate_in_dt') == ''
					|| sheetObjects[1].CellValue(i, 'mvmt_gate_out_dt') == null || sheetObjects[1].CellValue(i, 'mvmt_gate_out_dt') == ''){
					DISABLE_YN = 'Y';
				}
			}	
			
			if (DISABLE_YN != null && DISABLE_YN == 'Y') {
				sheetObjects[1].CellEditable(i, 'chk') = false;
			} else {
				// 2017.06.29 옮길수 있도록 주석처리 
//				if (document.form.yd_cd.value != null
//						&& document.form.yd_cd.value != undefined
//						&& document.form.yd_cd.value.substring(0, 2) == 'US') {
//					sheetObjects[1].CellEditable(i, 'chk') = (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'DB' ? false : true);
//				}
			}
		}
	}
}

/**
 * 자동 계산된 데이터 있는지 체크
 * 단 삭제 모드에서는 체크 안함
 * @return
 */
function isAutoCalcDataExisting() {
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = sheetObjects[2].HeaderRows; i < (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount); i++) {
			if (sheetObjects[2].CellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[2].CellValue(i, 'ibflag') != 'D') {
				// CALC tab(TMNL)에서 자동계산row가 발견되었다는 말... (단, (저장용 임시)삭제는 제외)
				return true;
			}
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = sheetObjects[3].HeaderRows; i < (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount); i++) {
			if (sheetObjects[3].CellValue(i, 'calc_tp_cd') == 'A' && sheetObjects[3].CellValue(i, 'ibflag') != 'D') {
				// CALC tab(ByDay)에서 자동계산row가 발견되었다는 말... (단, (저장용 임시)삭제는 제외)
				return true;
			}
		}
	}
	return false;
}

/**
 * 자동 계산된 데이터 있는지 체크
 * @return
 */
function isModAutoCalcDataExisting() {
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = sheetObjects[2].HeaderRows; i < (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount); i++) {
			if (sheetObjects[2].CellValue(i, 'calc_tp_cd') == 'A'
					&& sheetObjects[2].CellValue(i, 'ibflag') != 'R') {
				return true;
			}
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = sheetObjects[3].HeaderRows; i < (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount); i++) {
			if (sheetObjects[3].CellValue(i, 'calc_tp_cd') == 'A'
					&& sheetObjects[3].CellValue(i, 'ibflag') != 'R') {
				return true;
			}
		}
	}
	return false;
}

/**
 * 자동계산가능여부
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function isAutoCalcDataMod(sheetObj) {
	if (sheetObjects[2].RowCount > 0) {
		for ( var i = sheetObjects[2].HeaderRows; i < (sheetObjects[2].HeaderRows + sheetObjects[2].RowCount); i++) {
			if (// sheetObj.CellValue(i,'ibflag')!='I' ||
			(sheetObjects[2].CellValue(i, "tml_so_dtl_seq") != null
					&& sheetObjects[2].CellValue(i, "tml_so_dtl_seq").trim() != '' && parseInt(
					sheetObjects[2].CellValue(i, "tml_so_dtl_seq"), 10) > 0)) { // 하나라도 발견되면 TRUE값을 RETURN한다. -> 수정/저장 상태가 DB에 반영된 상태이니 COIN/DSCP의 DATA를 수정할 수 없다는  말...
				return true;
			}
		}
	}
	if (sheetObjects[3].RowCount > 0) {
		for ( var i = sheetObjects[3].HeaderRows; i < (sheetObjects[3].HeaderRows + sheetObjects[3].RowCount); i++) {
			if (// sheetObj.CellValue(i,'ibflag')!='I' ||
			(sheetObjects[3].CellValue(i, "tml_so_dtl_seq") != null
					&& sheetObjects[3].CellValue(i, "tml_so_dtl_seq").trim() != '' && parseInt(
					sheetObjects[3].CellValue(i, "tml_so_dtl_seq"), 10) > 0)) { // 하나라도 발견되면 TRUE값을 RETURN한다. -> 수정/저장 상태가 DB에 반영된 상태이니 COIN/DSCP의 DATA를 수정할 수 없다는  말...
				return true;
			}
		}
	}
	return false;
}

/**
 * 첫번째 tab Coincidence sheet change event 발생시 수정 가능 data가 수정되었는지 여부 확인 및 계산된 data삭제하기
 * @param {sheet}	t1sheet1	Coincidence sheet
 * @param {int}		row			선택된 row
 * @param {int}		col			선택된 col
 * @return
 */
function t1sheet1_OnChange(t1sheet1, row, col) {
	if (cntr_list_onchange_cnt == 1) { // 너무나 후륭한 K.부장님이 딱 한번만 확인하란당.
		// 수정 가능 data가 수정되었는지 여부 확인 및 계산된 data삭제하기
		if (t1sheet1_ChkMod()) {
			cntr_list_onchange_cnt++;
			// if (confirm('Cal Tab의 Auto Calculation Data가 clear됩니다. 그래도
			// 수정하시겠습니까?')){
			if (confirm(ComGetMsg('TES24070'))) {
				removeAutoCalcData();
			} else {
				return false;
			}
		}
	}
}

/**
 * 두번째 tab Discrepancy sheet 조회시 발생하는 이벤트
 * @param {sheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t2sheet1);
		return true;
	}
	// t2sheet1.ColumnSort("dscr_ind_cd|cntr_tpsz_cd|cntr_sty_cd","ASC");
	t2sheet1_SetChkBoxDisabled();

	t2sheet1_ChkSrc();
	
	if(document.form.f_cmd.value==SEARCH10){
		retrieve();
	}
}

/**
* 두번째 tab Discrepancy sheet 저장시 발생하는 이벤트
* @param {sheet}	t2sheet1	Discrepancy sheet
* @param {string}	ErrMsg		error message
* @return
*/
function t2sheet1_OnSaveEnd(t2sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t2sheet1);
	}
	// t2sheet1.ColumnSort("dscr_ind_cd|cntr_tpsz_cd|cntr_sty_cd","ASC");
	t2sheet1_SetChkBoxDisabled();

	t2sheet1_ChkSrc();
}

/**
 * DSCR_IND_CD - Discrepancy 발생원인 - 에 따라 Gate In, Out 컬럼 속성 설정
 * @return
 */
function t2sheet1_ChkSrc() {
	for ( var i = sheetObjects[1].HeaderRows; i < (sheetObjects[1].HeaderRows + sheetObjects[1].RowCount); i++) {
		if (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'DD') {
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_in_dt') = sheetObjects[1].RgbColor(255, 153, 153);
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_out_dt') = sheetObjects[1].RgbColor(255, 153, 153);
		} else if (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'PD') {
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_in_dt') = sheetObjects[1].RgbColor(255, 153, 153);
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_out_dt') = sheetObjects[1].RgbColor(255, 153, 153);
		} else if (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'NH') {
			sheetObjects[1].CellBackColor(i, 'cntr_no') = sheetObjects[1].RgbColor(255, 153, 153);
			sheetObjects[1].CellBackColor(i, 'cntr_tpsz_cd') = sheetObjects[1].RgbColor(255, 153, 153);
		} else if (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'DB') {
			sheetObjects[1].CellBackColor(i, 'cntr_no') = sheetObjects[1].RgbColor(255, 153, 153);
		} else if (sheetObjects[1].CellValue(i, 'dscr_ind_cd') == 'AM') {
			sheetObjects[1].CellBackColor(i, 'cntr_no') = sheetObjects[1].RgbColor(255, 153, 153);
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_in_dt') = sheetObjects[1].RgbColor(255, 153, 153);
			sheetObjects[1].CellBackColor(i, 'mvmt_gate_out_dt') = sheetObjects[1].RgbColor(255, 153, 153);
		}
	}
}

/**
 * 두번째 tab - Discrepancy sheet 더블클릭 시 발생하는 이벤트
 * @param {sheet}	sheetObj	Discrepancy sheet
 * @param {int}		row			선택된 row
 * @param {int}		col			선택된 col
 * @return
 */
function t2sheet1_OnDblClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "dscr_ind_cd") {
		var count = 0;
		var chkrow = "";

		while (true) {
			checkrow = sheetObj.FindText("dscr_ind_cd", sheetObj.CellText(row,
					col), count, -1);
			if (checkrow == "-1")
				break;
			if (chkrow != "") {
				chkrow = checkrow + "|" + chkrow;
			} else {
				chkrow = checkrow;
			}
			count = checkrow + 1;
		}

		chkrow = new String(chkrow);
		var arr = chkrow.split('|');
		var doit = false;

		for ( var i = 0; i < arr.length; i++) {
			if (sheetObj.CellValue(arr[i], "chk") == 0) {
				doit = true;
				break;
			}
		}
		for ( var i = 0; i < arr.length; i++) {
			if (doit) {
				sheetObj.CellValue2(arr[i], "chk") = 1;
			} else {
				sheetObj.CellValue2(arr[i], "chk") = 0;
			}
		}
	}
}

/**
 * curr cd 변경되면 Cost Calc.(SR by FD)와 Cost Calc.(SR by FP) Tab의 모든 Data를 삭제여부 확인
 * @param Index_Code
 * @param Text
 * @return
 */
function curr_cd_OnChange(Index_Code, Text) {
	// ComShowMessage('curr_cd_OnChange:'+comboObjects[0].Code);
	var formObj = document.form;
	var main_sheet_obj = sheetObjects[5];
	if (main_sheet_obj.RowCount == 1) {
		if ((main_sheet_obj.CellValue(1, 'curr_cd') != comboObjects[0].Code)
				|| (formObj.curr_cd_tmp.value != undefined
						&& formObj.curr_cd_tmp.value != null
						&& formObj.curr_cd_tmp.value != '' && formObj.curr_cd_tmp.value != comboObjects[0].Code)) {
			resetInputValue();
		}
		if (hasAllCalcData()) {
			if (formObj.curr_cd_tmp.value != comboObjects[0].Code) {
				// if (!confirm('Currency가 변경되었습니다. \n\n Cost Calc.(SR by FD)와 Cost Calc.(SR by FP) Tab의 모든 Data를 삭제할까요?')){
				if (!confirm('Currency code has been changed. ' + ComGetMsg('TES40039'))) {
					comboObjects[0].Code = formObj.curr_cd_tmp.value;
				} else {
					removeCalcDataAll();
					resetSheetDataProperty(comboObjects[0].Code);
				}
			}
		}
		formObj.curr_cd_tmp.value = comboObjects[0].Code;
	}
}

/**
 * [Inv Amt], [TAX] 초기화
 * @return
 */
function resetInputValue() {
	var formObj = document.form;
	formObj.ttl_inv_amt.value = '';
	formObj.vat_amt.value = '';
}

/**
 * [Currency] 따라 sheet data 속성 설정
 * @param {string}		CURR_CD		Currency code
 * @return
 */
function resetSheetDataProperty(CURR_CD) {
	if (CURR_CD != undefined && tes_isNoDecimalPointCurrCD(CURR_CD)) {
		sheetObjects[2].InitDataProperty(0, 12, dtData, 60, daRight, true, "ctrt_rt", false, "", dfInteger, 0, false, false);
		sheetObjects[2].InitDataProperty(0, 16, dtData, 70, daRight, true, "inv_amt", false, "", dfInteger, 0, false, false);
		sheetObjects[3].InitDataProperty(0, 16, dtData, 60, daRight, true, "ctrt_rt", false, "", dfInteger, 0, false, false);
		sheetObjects[3].InitDataProperty(0, 19, dtData, 70, daRight, true, "inv_amt", false, "", dfInteger, 0, false, false);
		sheetObjects[4].InitDataProperty(0, 12, dtData, 60, daRight, true, "ctrt_rt", false, "", dfInteger, 0, false, false);
		sheetObjects[4].InitDataProperty(0, 15, dtData, 70, daRight, true, "inv_amt", false, "", dfInteger, 0, false, false);
	} else {
		sheetObjects[2].InitDataProperty(0, 12, dtData, 60, daRight, true, "ctrt_rt", false, "", dfFloat, 2, false, false);
		sheetObjects[2].InitDataProperty(0, 16, dtData, 70, daRight, true, "inv_amt", false, "", dfFloat, 2, false, false);
		sheetObjects[3].InitDataProperty(0, 16, dtData, 60, daRight, true, "ctrt_rt", false, "", dfFloat, 2, false, false);
		sheetObjects[3].InitDataProperty(0, 19, dtData, 70, daRight, true, "inv_amt", false, "", dfFloat, 2, false, false);
		sheetObjects[4].InitDataProperty(0, 12, dtData, 60, daRight, true, "ctrt_rt", false, "", dfFloat, 2, false, false);
		sheetObjects[4].InitDataProperty(0, 15, dtData, 70, daRight, true, "inv_amt", false, "", dfFloat, 2, false, false);
	}
}

/**
 * Cost Calc.(TMNL) sheet 데이터 변경 시 발생
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			해당 셀의 Row Index
 * @param {int}		Col			해당 셀의 Column Index
 * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @return
 */
function t3sheet1_OnChange(t3sheet1, Row, Col, Value) {
	var formObj = document.form;
	var sName = t3sheet1.ColSaveName(Col);
	var rate = t3sheet1.CellValue(Row,'ctrt_rt');
	var inv_xch_rt = t3sheet1.CellValue(Row,'inv_xch_rt');
	var rvis_qty = t3sheet1.CellValue(Row,'rvis_vol_qty');
	var tmp;
	if (sName == "inv_amt") {
		document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
		
		//금액이 변경되면 India GST 금액도 변경
		t3sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
    	
		t3sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t3sheet1.CellValue(Row,'ida_cgst_rto')) 
    	                                        + parseFloat(t3sheet1.CellValue(Row,'ida_sgst_rto'))
    	                                        + parseFloat(t3sheet1.CellValue(Row,'ida_igst_rto'))
    	                                        + parseFloat(t3sheet1.CellValue(Row,'ida_ugst_rto'));
		t3sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t3sheet1.CellValue(Row,'ida_cgst_amt')) 
    											+ parseFloat(t3sheet1.CellValue(Row,'ida_sgst_amt'))
    											+ parseFloat(t3sheet1.CellValue(Row,'ida_igst_amt'))
    											+ parseFloat(t3sheet1.CellValue(Row,'ida_ugst_amt'));
    	
		document.form.t3sht_tot_cgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_cgst_amt');
		document.form.t3sht_tot_sgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_sgst_amt');
		document.form.t3sht_tot_igst_amt.value = getShtTotGstAmt(t3sheet1,'ida_igst_amt');
		document.form.t3sht_tot_ugst_amt.value = getShtTotGstAmt(t3sheet1,'ida_ugst_amt');
	}
	if (sName == "rvis_vol_qty" || sName == "calc_vol_qty"
			|| sName == "ctrt_rt" || sName == "inv_xch_rt"
			|| sName == "vol_tr_ut_cd") {
		// inv_xch_rt는 음수불가
		t3sheet1.CellValue(Row, 'inv_xch_rt') = Math.abs(t3sheet1.CellValue( Row, 'inv_xch_rt'));
		if (t3sheet1.CellValue(Row, 'inv_xch_rt') > 0) {
			t3sheet1.CellBackColor(Row, 'inv_xch_rt') = t3sheet1.RgbColor(0, 0, 0);
		}
		// row별로 amt계산하기..
		t3sheet1_RecalcCalcAmt(t3sheet1, Row);
	}

	// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
	 if( sName == 'cntr_tpsz_cd' && t3sheet1.CellValue(Row,'cntr_tpsz_cd')!='' && CostCdValidForCalcTpSz(t3sheet1.CellValue(Row,'lgs_cost_cd'), t3sheet1.CellValue(Row,'cntr_tpsz_cd')) == false 
			 	/*&& (t3sheet1.CellValue(Row,'vol_tr_ut_cd')=="C" || t3sheet1.CellValue(Row,'vol_tr_ut_cd')=="")*/){
		 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
		 t3sheet1.CellValue(Row,'cntr_tpsz_cd') = '';
	 }	
	 
	 if(sName == "rvis_vol_qty"){
		/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
		if(t3sheet1.CellValue(Row,'plug_term') > 0){
			if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
				t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
	    	}else{
	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
	    	}
		} else {
	    	if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
	    	}else{
	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
	    	}
		}	            
     }else if(sName == 'ctrt_rt'){
    	/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
 		if(t3sheet1.CellValue(Row,'plug_term') > 0){
 			if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
 				t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
 	    	}else{
 	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
 	    	}
 		} else {
 	    	if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
 	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
 	    	}else{
 	    		t3sheet1.CellValue(Row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys')));
 	    	}
 		}	 
     }else if(sName == 'lgs_cost_cd'){
    	 //2011.04.11 lgs_cost_cd가 TMRFMO인 경우는 rf_mntr_dys 입력가능하도록 만들어 준다.
         if(t3sheet1.CellValue(Row,'lgs_cost_cd')=='TMRFMO'){
             setShtCellsEditable(t3sheet1,Row,'rf_mntr_dys','Y');
         }else{
         	setShtCellsEditable(t3sheet1,Row,'rf_mntr_dys','N');
         }
         
         //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
         if(t3sheet1.CellValue(Row,'lgs_cost_cd') != '' && t3sheet1.CellValue(Row,'lgs_cost_cd') != null){
         	checkValidForRemark(t3sheet1.CellValue(Row,'lgs_cost_cd'), Row, '2') ;
         }  
     }else if(sName == 'rf_mntr_dys'){ 
         if(t3sheet1.CellValue(Row,'plug_term') > 0){
            if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'calc_amt');
                }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }else {
            	t3sheet1.CellValue(Row,'inv_xch_rt') = Math.abs(t3sheet1.CellValue(Row,'inv_xch_rt'));
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'inv_xch_rt') * t3sheet1.CellValue(Row,'calc_amt');
                }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'ctrt_rt') *  t3sheet1.CellValue(Row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }
         } else {
         	if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'calc_amt');
                }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'rvis_vol_qty') *  t3sheet1.CellValue(Row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }else {
            	t3sheet1.CellValue(Row,'inv_xch_rt') = Math.abs(t3sheet1.CellValue(Row,'inv_xch_rt'));
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'inv_xch_rt') * t3sheet1.CellValue(Row,'calc_amt');
                }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'rvis_vol_qty') *  t3sheet1.CellValue(Row, 'ctrt_rt') *  t3sheet1.CellValue(Row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }
         } 
     }else if(sName == 'inv_xch_rt'){
    	 if(t3sheet1.CellValue(Row,'plug_term') > 0){
            if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'calc_amt');
                }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }else {
            	t3sheet1.CellValue(Row,'inv_xch_rt') = Math.abs(t3sheet1.CellValue(Row,'inv_xch_rt'));
                if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'inv_xch_rt') * t3sheet1.CellValue(Row,'calc_amt');
                }else if(sheetObj.CellValue(Row,'calc_tp_cd') == 'M' || sheetObj.CellValue(Row,'calc_tp_cd') == 'S'){
                	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'ctrt_rt') *  t3sheet1.CellValue(Row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
                }
            }
    	 } else {
	      	if(t3sheet1.CellValue(Row,'inv_xch_rt')==0){
	             if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
	             	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'calc_amt');
	             }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
	             	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'rvis_vol_qty') *  t3sheet1.CellValue(Row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
	             }
	         }else {
	         	t3sheet1.CellValue(Row,'inv_xch_rt') = Math.abs(t3sheet1.CellValue(Row,'inv_xch_rt'));
	             if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'A'){
	             	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row, 'inv_xch_rt') * t3sheet1.CellValue(Row,'calc_amt');
	             }else if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M' || t3sheet1.CellValue(Row,'calc_tp_cd') == 'S'){
	             	t3sheet1.CellValue(Row,'inv_amt') = t3sheet1.CellValue(Row,'rvis_vol_qty') *  t3sheet1.CellValue(Row, 'ctrt_rt') *  t3sheet1.CellValue(Row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,t3sheet1.CellValue(Row,'lgs_cost_cd'),t3sheet1.CellValue(Row,'rf_mntr_dys'));
	             }
	         }
      	 } 
     }else if(sName == 'calc_vol_qty'){
         if(t3sheet1.CellValue(Row,'calc_tp_cd') == 'M'){
        	 t3sheet1.CellValue(Row,'rvis_vol_qty') = t3sheet1.CellValue(Row,'calc_vol_qty');
         }
     }else if(sName == 'ida_sac_cd'){//India GST
    	 checkValidSacCd(t3sheet1.CellValue(Row,'ida_sac_cd'), Row, '2');  	
     }else if(sName == 'ida_cgst_rto' || sName == 'ida_sgst_rto' || sName == 'ida_igst_rto' || sName == 'ida_ugst_rto'){
 	
		t3sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t3sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t3sheet1.CellValue(Row,'inv_amt') * t3sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
		
		t3sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t3sheet1.CellValue(Row,'ida_cgst_rto')) 
		                                        + parseFloat(t3sheet1.CellValue(Row,'ida_sgst_rto'))
		                                        + parseFloat(t3sheet1.CellValue(Row,'ida_igst_rto'))
		                                        + parseFloat(t3sheet1.CellValue(Row,'ida_ugst_rto'));
		t3sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t3sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t3sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t3sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t3sheet1.CellValue(Row,'ida_ugst_amt'));
		
		document.form.t3sht_tot_cgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_cgst_amt');
		document.form.t3sht_tot_sgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_sgst_amt');
		document.form.t3sht_tot_igst_amt.value = getShtTotGstAmt(t3sheet1,'ida_igst_amt');
		document.form.t3sht_tot_ugst_amt.value = getShtTotGstAmt(t3sheet1,'ida_ugst_amt'); 	
	}else if(sName == 'ida_cgst_amt' || sName == 'ida_sgst_amt' || sName == 'ida_igst_amt' || sName == 'ida_ugst_amt'){
		t3sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t3sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t3sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t3sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t3sheet1.CellValue(Row,'ida_ugst_amt'));
		
		document.form.t3sht_tot_cgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_cgst_amt');
		document.form.t3sht_tot_sgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_sgst_amt');
		document.form.t3sht_tot_igst_amt.value = getShtTotGstAmt(t3sheet1,'ida_igst_amt');
		document.form.t3sht_tot_ugst_amt.value = getShtTotGstAmt(t3sheet1,'ida_ugst_amt'); 	
	}
}

function checkValidSacCd(idaSacCd, row, sheet){
	document.form.ida_sac_cd.value = idaSacCd;
   	document.form.chg_row.value = row;
   	document.form.chg_sheet.value = sheet;

   	tes_getInputValue('valid_ida_sac_cd', SEARCH27, 'ida_sac_cd', 'getSacCd');   
}

function getSacCd(){
	if(document.form.valid_ida_sac_cd.value == 'Y'){
		tes_getInputValue('ida_gst_rto', SEARCH26, 'cost_ofc_cd|vndr_seq|ida_sac_cd', 'getIdaGstRto'); 
	} else {
		ComShowMessage(ComGetMsg('TES21060'));	//ComShowMessage('This Service Accounting Code is not valid code. Please check it again.');
		return false;
	}
}

function getIdaGstRto() {
	var formObj = document.form;
	var chgRow = formObj.chg_row.value;
	var chgSheet = formObj.chg_sheet.value;
	
	if(formObj.ida_gst_rto.value != null && formObj.ida_gst_rto.value != '') {
		var tmpInfo = formObj.ida_gst_rto.value;
		var tmp = tmpInfo.split("|");
		
		if(chgSheet == '2'){
			sheetObjects[2].CellValue(chgRow, 'ida_cgst_rto') = tmp[0];
    		sheetObjects[2].CellValue(chgRow, 'ida_sgst_rto') = tmp[1];
    		sheetObjects[2].CellValue(chgRow, 'ida_igst_rto') = tmp[2];
    		sheetObjects[2].CellValue(chgRow, 'ida_ugst_rto') = tmp[3];
		} else if(chgSheet == '3') {
			sheetObjects[3].CellValue(chgRow, 'ida_cgst_rto') = tmp[0];
    		sheetObjects[3].CellValue(chgRow, 'ida_sgst_rto') = tmp[1];
    		sheetObjects[3].CellValue(chgRow, 'ida_igst_rto') = tmp[2];
    		sheetObjects[3].CellValue(chgRow, 'ida_ugst_rto') = tmp[3];
		} else if(chgSheet == '4') {
			sheetObjects[4].CellValue(chgRow, 'ida_cgst_rto') = tmp[0];
    		sheetObjects[4].CellValue(chgRow, 'ida_sgst_rto') = tmp[1];
    		sheetObjects[4].CellValue(chgRow, 'ida_igst_rto') = tmp[2];
    		sheetObjects[4].CellValue(chgRow, 'ida_ugst_rto') = tmp[3];
		}
	}
}
/**
 * 
 * @param vndr_seq
 * @param lgs_cost_cd
 * @param rf_mntr_dys
 * @param edi_flg
 * @return
 */
function calc_rf_mntr_dys(vndr_seq, lgs_cost_cd, rf_mntr_dys){
	/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 (금액 계산을 위해) return한다. **/		
	try {
		if ((vndr_seq!=null && vndr_seq!=undefined && vndr_seq=='180020') &&
			(lgs_cost_cd!=null && lgs_cost_cd!=undefined && lgs_cost_cd=='TMRFMO')) {
			if (rf_mntr_dys!=null && rf_mntr_dys.trim()!='' && rf_mntr_dys!=undefined && !isNaN(rf_mntr_dys)){
				return rf_mntr_dys;
			}
		}else if(lgs_cost_cd!=null && lgs_cost_cd!=undefined && lgs_cost_cd=='TMRFMO'){
			if (rf_mntr_dys!=null && rf_mntr_dys.trim()!='' && rf_mntr_dys!=undefined && !isNaN(rf_mntr_dys) && rf_mntr_dys !='0' ){
				return rf_mntr_dys;
			}
		}
		
	} catch(e){
		return 1;
	}
	return 1;
}

/**
 * Cost Calc.(TMNL) sheet row별로 Amount 계산하기
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			해당 셀의 Row Index	
 * @return
 */
function t3sheet1_RecalcCalcAmt(sheetObj, Row) {
	if (sheetObj.RowCount > 0) {
		if (sheetObj.CellValue(Row, 'calc_tp_cd') == 'A') {
			if (sheetObj.CellValue(Row, 'rvis_vol_qty') != null
					&& sheetObj.CellValue(Row, 'rvis_vol_qty').trim() != ''
					&& !isNaN(sheetObj.CellValue(Row, 'rvis_vol_qty'))
					&& sheetObj.CellValue(Row, 'ctrt_rt') != null
					&& sheetObj.CellValue(Row, 'ctrt_rt').trim() != ''
					&& !isNaN(sheetObj.CellValue(Row, 'ctrt_rt'))) {
				sheetObj.CellValue(Row, 'inv_amt') = (parseInt(sheetObj
						.CellValue(Row, 'rvis_vol_qty'), 10) * parseFloat(sheetObj
						.CellValue(Row, 'ctrt_rt')));
			}
			if (sheetObj.CellValue(Row, 'curr_cd') != undefined
					&& sheetObj.CellValue(Row, 'curr_cd') != null
					&& sheetObj.CellValue(Row, 'curr_cd') != ''
					&& document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& document.form.curr_cd.Code != sheetObj.CellValue(Row,
							'curr_cd')
					&& !isNaN(sheetObj.CellValue(Row, 'inv_xch_rt'))
					&& parseFloat(sheetObj.CellValue(Row, 'inv_xch_rt')) > 0) {
				sheetObj.CellValue(Row, 'inv_amt') = parseFloat(sheetObj
						.CellValue(Row, 'inv_amt'))
						* parseFloat(sheetObj.CellValue(Row, 'inv_xch_rt'));
			}
		} else if (sheetObj.CellValue(Row, 'calc_tp_cd') == 'M' || sheetObj.CellValue(Row, 'calc_tp_cd') == 'S') {
			if (sheetObj.CellValue(Row, 'calc_vol_qty') != null
					&& sheetObj.CellValue(Row, 'calc_vol_qty').trim() != ''
					&& !isNaN(sheetObj.CellValue(Row, 'calc_vol_qty'))
					&& sheetObj.CellValue(Row, 'ctrt_rt') != null
					&& sheetObj.CellValue(Row, 'ctrt_rt').trim() != ''
					&& !isNaN(sheetObj.CellValue(Row, 'ctrt_rt'))) {
				if (sheetObj.CellValue(Row, 'rvis_vol_qty') != null
						&& sheetObj.CellValue(Row, 'rvis_vol_qty').trim() != ''
						&& !isNaN(sheetObj.CellValue(Row, 'rvis_vol_qty'))
						&& sheetObj.CellValue(Row, 'rvis_vol_qty') > 0) {
					sheetObj.CellValue2(Row, 'calc_vol_qty') = sheetObj
							.CellValue(Row, 'rvis_vol_qty').trim();

				}
				sheetObj.CellValue(Row, 'inv_amt') = (parseInt(sheetObj
						.CellValue(Row, 'calc_vol_qty'), 10) * parseFloat(sheetObj
						.CellValue(Row, 'ctrt_rt')));
			}
			if (document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& !isNaN(sheetObj.CellValue(Row, 'inv_xch_rt'))
					&& parseFloat(sheetObj.CellValue(Row, 'inv_xch_rt')) > 0) {
				sheetObj.CellValue(Row, 'inv_amt') = parseFloat(sheetObj
						.CellValue(Row, 'inv_amt'))
						* parseFloat(sheetObj.CellValue(Row, 'inv_xch_rt'));
			}
		}
		if ((sheetObj.CellValue(Row, 'cntr_tpsz_cd') != undefined
				&& sheetObj.CellValue(Row, 'cntr_tpsz_cd') != null && sheetObj
				.CellValue(Row, 'cntr_tpsz_cd').trim() != '')
				&& (sheetObj.CellValue(Row, 'vol_tr_ut_cd') != undefined
						&& sheetObj.CellValue(Row, 'vol_tr_ut_cd') != null && sheetObj
						.CellValue(Row, 'vol_tr_ut_cd').trim() != '')) {
			sheetObj.CellValue(Row, 'inv_amt') = sheetObj.CellValue(Row,
					'inv_amt')
					* tes_getTEUconv(sheetObj.CellValue(Row, 'vol_tr_ut_cd'),
							sheetObj.CellValue(Row, 'cntr_tpsz_cd'));
		}
	}
}

/**
 * Cost Calc.(TMNL) sheet 클릭 시 발생
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {int}		Row			해당 셀의 Row Index
 * @param {int}		Col			해당 셀의 Column Index
 * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @return
*/
function t3sheet1_OnClick(t3sheet1, Row, Col, Value) {
	if (t3sheet1.ColSaveName(Col) == 'calc_rmk') {
		// ComShowMessage(' cell value:' + t3sheet1.CellValue(Row,'ctrt_rt') + '
		// / ' + t3sheet1.CellValue(Row,'inv_amt') );
	}
}

/**
 * Cost Calc.(TMNL) sheet 저장 시 발생
 * @param {sheet}	t1sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSaveEnd(t3sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t3sheet1);
	}

	init_Arr_sht_chk();

	// CostCalc.TMNL의 manual cost code를 조회한다.
	var formObj = document.form;

	if (formObj.calcTerminalComboItems.value == null
			|| formObj.calcTerminalComboItems.value.trim() == '') {
		// getCalcTerminalManualCostCode();
	}

	if (t3sheet1.RowCount > 0) {

		t1sheet1_SetChkBoxDisabled();
		t2sheet1_SetChkBoxDisabled();

		document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1,
				'inv_amt');
		
		document.form.t3sht_tot_cgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_cgst_amt');
		document.form.t3sht_tot_sgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_sgst_amt');
		document.form.t3sht_tot_igst_amt.value = getShtTotGstAmt(t3sheet1,'ida_igst_amt');
		document.form.t3sht_tot_ugst_amt.value = getShtTotGstAmt(t3sheet1,'ida_ugst_amt');

		setElementDiabled('checkbox', 'TMNL', 'Y');
		setElementDiabled('radio', 'CostCalcMethod', 'Y');

		for ( var i = 1; i <= t3sheet1.RowCount; i++) {
			if (t3sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t3sheet1.CellValue(i, "curr_cd") != undefined
						&& t3sheet1.CellValue(i, "curr_cd") != null
						&& t3sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t3sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t3sheet1.CellValue(i, "calc_tp_cd") == "M") {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 19 - 이경한과장 요청 TMNL 추가)
				setShtCellsEditable( t3sheet1, i, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|inv_amt|inv_xch_rt', 'Y');
			} else if (t3sheet1.CellValue(i, "calc_tp_cd") == "S") {
				// 양부장님 요청 semi updated 추가)
				setShtCellsEditable( t3sheet1, i, 'rev_yrmon', 'Y', 'EXCEPTION');
//				setShtCellsEditable(t3sheet1, i, 'rvis_vol_qty', 'N','EXCEPTION');
			}
		}

		setCalcTerminalManualCostCode(t3sheet1);

		checkTPBdataEditable('3', t3sheet1);

	} else {
		document.form.t3sht_tot_inv_amt.value = 0;
		setElementDiabled('checkbox', 'TMNL', 'N');
		// setElementDiabled('radio','CostCalcMethod','Y');
	}
}

/**
 * 입력하신 Currency Code는 Agreement의 currency 와 일치하는지 여부
 * @param {sheet}	sheetObj	ibsheet
 * @return
 */
function currChk(sheetObj) {
	var retval = false;
	for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0
			&& i < (sheetObj.HeaderRows + sheetObj.RowCount); i++) {
		if (sheetObj.CellValue(i, 'curr_chk') == 'N') {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 153, 153);
			retval = true;
		}
	}
	return retval;
}

/**
 * Cost Calc.(TMNL) sheet 조회시 발생하는 이벤트
 * @param {sheet}	t3sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t3sheet1);
	}

	init_Arr_sht_chk();

	// CostCalc.TMNL의 manual cost code를 조회한다.
	var formObj = document.form;
	if (formObj.calcTerminalComboItems.value == null
			|| formObj.calcTerminalComboItems.value.trim() == '') {
		// getCalcTerminalManualCostCode();
	}

	if (t3sheet1.RowCount > 0) {

		/*
		 * if (currChk(t3sheet1)){ ComShowMessage('입력하신 Currency Code는
		 * Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시
		 * 계산해주십시오.'); curr_chk = true; removeAutoCalcData(); return false; }
		 */

		// t1sheet1_SetChkBoxDisabled();
		// t2sheet1_SetChkBoxDisabled();
		document.form.t3sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(
				t3sheet1, 'inv_amt'));
		
		document.form.t3sht_tot_cgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_cgst_amt');
		document.form.t3sht_tot_sgst_amt.value = getShtTotGstAmt(t3sheet1,'ida_sgst_amt');
		document.form.t3sht_tot_igst_amt.value = getShtTotGstAmt(t3sheet1,'ida_igst_amt');
		document.form.t3sht_tot_ugst_amt.value = getShtTotGstAmt(t3sheet1,'ida_ugst_amt');

		setElementDiabled('checkbox', 'TMNL', 'Y');
		setElementDiabled('radio', 'CostCalcMethod', 'Y');

		for ( var i = 1; i <= t3sheet1.RowCount; i++) {
			// 변환문자를 특수 문자로 치환. (2010-04-23)
			t3sheet1.CellValue2(i, "calc_rmk") = ComToString( t3sheet1.CellValue(i, "calc_rmk") );
			
			if (t3sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t3sheet1.CellValue(i, "curr_cd") != undefined
						&& t3sheet1.CellValue(i, "curr_cd") != null
						&& t3sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t3sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t3sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t3sheet1.CellValue(i, "calc_tp_cd") == "M") {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 19 - 이경한과장
				// 요청 TMNL 추가)
				setShtCellsEditable( t3sheet1, i, 'lgs_cost_cd|cntr_tpsz_cd|rev_yrmon|io_bnd_cd|calc_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
				
			} else if (t3sheet1.CellValue(i, "calc_tp_cd") == "S") {
				// 양부장님 요청 semi updated 추가)
				setShtCellsEditable( t3sheet1, i, 'rev_yrmon', 'Y', 'EXCEPTION');
//				setShtCellsEditable(t3sheet1, i, 'rvis_vol_qty', 'N','EXCEPTION');
			}
			
			if (t3sheet1.CellValue(i, "rvis_vol_qty") > 0) {
				setShtCellsEditable(t3sheet1, i, 'cntr_tpsz_cd', 'N');
			}
			
			//lgs_cost_cd=='TMRFMO' 이면 입력활성화
            if(t3sheet1.CellValue(i,'lgs_cost_cd')=='TMRFMO'){
                setShtCellsEditable(t3sheet1,i,'rf_mntr_dys','Y');
            }else{
            	setShtCellsEditable(t3sheet1,i,'rf_mntr_dys','N');
            }			
		}

		setCalcTerminalManualCostCode(t3sheet1);

		checkTPBdataEditable('3', t3sheet1);

	} else {
		document.form.t3sht_tot_inv_amt.value = 0;
		setElementDiabled('checkbox', 'TMNL', 'N');
		// setElementDiabled('radio','CostCalcMethod','Y');
	}
}

/**
 * Cost Calc.(TMNL) sheet 팝업 클릭 시 발생하는 이벤트 - Revised Volumn 입력 화면 뜬다
 * @param {sheet}	sheetObj	Cost Calc.(TMNL) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;
	if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
		if (sheetObj.CellValue(row, 'calc_tp_cd') == 'M'
				&& (sheetObj.CellValue(row, 'tml_so_dtl_seq') == ''
						|| sheetObj.CellValue(row, 'tml_so_dtl_seq') == null || sheetObj
						.CellValue(row, 'tml_so_dtl_seq') == 0)) {
			ComShowMessage('You have to Revised Vol. Input after save calculated result.');
			return false;

		}

		if (formObj.CostCalcMethod[0].checked == true) { // TP
			if (sheetObj.CellValue(row, 'lgs_cost_cd') == undefined
					|| sheetObj.CellValue(row, 'lgs_cost_cd') == null
					|| sheetObj.CellValue(row, 'lgs_cost_cd').trim() == '') {
				ComShowMessage(ComGetMsg('TES23045')); // ComShowMessage('Cost
													// Code를 선택하십시오.');
				return false;
			}
			if(sheetObj.CellValue(row, 'cntr_tpsz_cd') == undefined
					|| sheetObj.CellValue(row, 'cntr_tpsz_cd') == null
					|| sheetObj.CellValue(row, 'cntr_tpsz_cd').trim() == ''){
			    ComShowMessage("Not Selected Type/Size");
			    return false;
			} else if (sheetObj.CellValue(row,'cntr_tpsz_cd').trim()!=sheetObj.CellSearchValue(row,'cntr_tpsz_cd').trim()) {
				ComShowMessage(ComGetMsg('TES22042',sheetObj.CellSearchValue(row,'cntr_tpsz_cd').trim()));
				return false;
			}
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			if(CostCdValidForCalcTpSz(sheetObj.CellValue(row, 'lgs_cost_cd'), sheetObj.CellValue(row, 'cntr_tpsz_cd')) == false){
				 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
				 return false;
			}
			if (sheetObj.CellValue(row,'lgs_cost_cd')=="TMRFMO"){
				var url_str = 'ESD_TES_9034Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='
						+ formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='
						+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='
						+ sheetObj.CellValue(row, 'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='
						+ sheetObj.CellValue(row, 'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='
						+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='
						+ sheetObj.CellValue(row, 'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='
						+ sheetObj.CellValue(row, 'rc_flg');
				url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
				url_str = url_str + '&calcTerminalComboItems='
						+ formObj.calcTerminalComboItems.value;
				url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
				url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
				url_str = url_str + '&sheet_curr_row=' + row;
				url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value;
				url_str = url_str + '&to_prd_dt=' + formObj.to_prd_dt.value;
				url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
				// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YSY B 요청)
				var dialogHeight = "";
				if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
					dialogHeight = "520px";
				} else {
					dialogHeight = "420px";
				}
//				window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:420px; help:no; status:no; resizable:yes;");
				window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
			} else {
				var url_str = 'ESD_TES_9030Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='
						+ formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='
						+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='
						+ sheetObj.CellValue(row, 'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='
						+ sheetObj.CellValue(row, 'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='
						+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='
						+ sheetObj.CellValue(row, 'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='
						+ sheetObj.CellValue(row, 'rc_flg');
				url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
				url_str = url_str + '&calcTerminalComboItems='
						+ formObj.calcTerminalComboItems.value;
				url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
				url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
				url_str = url_str + '&sheet_curr_row=' + row;
				url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value;
				url_str = url_str + '&to_prd_dt=' + formObj.to_prd_dt.value;
				url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;

				// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YSY B 요청)
				var dialogHeight = "";
				if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
					dialogHeight = "520px";
				} else {
					dialogHeight = "420px";
				}
//				window.showModalDialog(url_str, window, "dialogWidth:620px; dialogHeight:420px; help:no; status:no; resizable:yes;");
				window.showModalDialog(url_str, window, "dialogWidth:620px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
			}
		} else if (formObj.CostCalcMethod[1].checked == true) { // Separate
			if (sheetObj.CellValue(row, 'lgs_cost_cd') == undefined
					|| sheetObj.CellValue(row, 'lgs_cost_cd') == null
					|| sheetObj.CellValue(row, 'lgs_cost_cd').trim() == '') {
				ComShowMessage(ComGetMsg('TES23045')); // ComShowMessage('Cost
													// Code를 선택하십시오.');
				return false;
			}
			if (sheetObj.CellValue(row,'lgs_cost_cd')=="TMRFMO"){
				var url_str = 'ESD_TES_9034Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='
						+ formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='
						+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='
						+ sheetObj.CellValue(row, 'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='
						+ sheetObj.CellValue(row, 'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='
						+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='
						+ sheetObj.CellValue(row, 'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='
						+ sheetObj.CellValue(row, 'rc_flg');
				url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
				url_str = url_str + '&calcTerminalComboItems='
						+ formObj.calcTerminalComboItems.value;
				url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
				url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
				url_str = url_str + '&sheet_curr_row=' + row;
				url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value;
				url_str = url_str + '&to_prd_dt=' + formObj.to_prd_dt.value;
				url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
				// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YSY B 요청)
				var dialogHeight = "";
				if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
					dialogHeight = "520px";
				} else {
					dialogHeight = "420px";
				}
//				window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:420px; help:no; status:no; resizable:yes;");
				window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
			} else {
				var url_str = 'ESD_TES_9240Popup.screen';
				url_str = url_str + '?tml_so_ofc_cty_cd='
						+ formObj.tml_so_ofc_cty_cd.value;
				url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
				url_str = url_str + '&tml_so_dtl_seq='
						+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
				url_str = url_str + '&calc_tp_cd='
						+ sheetObj.CellValue(row, 'calc_tp_cd');
				url_str = url_str + '&param_lgs_cost_cd='
						+ sheetObj.CellValue(row, 'lgs_cost_cd');
				url_str = url_str + '&param_cntr_tpsz_cd='
						+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
				url_str = url_str + '&param_dcgo_clss_cd='
						+ sheetObj.CellValue(row, 'dcgo_ind_cd');
				url_str = url_str + '&param_rc_flg='
						+ sheetObj.CellValue(row, 'rc_flg');
				url_str = url_str + '&ot_a_lgs_cost_cd=' + OT_A_LGS_COST_CD;
				url_str = url_str + '&calcTerminalComboItems='
						+ formObj.calcTerminalComboItems.value;
				url_str = url_str + '&cntr_tpsz_cd=' + CNTR_TPSZ_CD;
				url_str = url_str + '&cntr_sty_cdCode=' + cntr_sty_cdCode;
				url_str = url_str + '&sheet_curr_row=' + row;
				url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value; // 2007-12-06 김부장 요청으로 Separate의 RVIS Vol.기준을 변경위해 넘기는 인자 추가
				url_str = url_str + '&to_prd_dt=' + formObj.to_prd_dt.value;
				url_str = url_str + '&inv_no=' + formObj.inv_no.value;
				url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
				url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
				url_str = url_str + '&rvis_vol_qty=' + sheetObj.CellValue(row,'rvis_vol_qty');
				// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YSY B 요청)
				var dialogHeight = "";
				if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
					dialogHeight = "530px";
				} else {
					dialogHeight = "430px";
				}
//				window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:430px; help:no; status:no; resizable:yes;");
				window.showModalDialog(url_str, window, "dialogWidth:610px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
			}
		}
	} else if (sheetObj.ColSaveName(col) == "n3pty_flg") {
		if (sheetObj.CellValue(row, 'tml_so_dtl_seq') == ''
				|| sheetObj.CellValue(row, 'tml_so_dtl_seq') == null
				|| sheetObj.CellValue(row, 'tml_so_dtl_seq') == 0) {
			ComShowMessage('You have to 3rd party Input after save calculated result.');
			return false;

		}

		if (sheetObj.CellValue(row, 'calc_cost_grp_cd') == null
				|| sheetObj.CellValue(row, 'calc_cost_grp_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES24046')); // ComShowMessage('Cost Group
												// code가 누락되었습니다.');
			return false;
		}
		if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
			ComShowMessage(ComGetMsg('TES40041', 'Currency code')); // ComShowMessage('Currency
																	// code가
																	// 누락되었습니다.');
			return false;
		}
		if (sheetObj.CellValue(row, 'lgs_cost_cd') == undefined
				|| sheetObj.CellValue(row, 'lgs_cost_cd') == null
				|| sheetObj.CellValue(row, 'lgs_cost_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES23045')); // ComShowMessage('Cost Code를
												// 선택하십시오.');
			return false;
		}
		/** 2007-11-01 금액이 음수인 경우 TPB popup을 띄우지 않는다 * */
		if (sheetObj.CellValue(row, 'inv_amt') != undefined
				&& sheetObj.CellValue(row, 'inv_amt') != null
				&& sheetObj.CellValue(row, 'inv_amt') < 0) {
			return false;
		}
		var url_str = 'ESD_TES_9233Popup.screen';
		url_str = url_str + '?tml_so_ofc_cty_cd='
				+ formObj.tml_so_ofc_cty_cd.value;
		url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
		url_str = url_str + '&tml_so_dtl_seq='
				+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
		url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
		url_str = url_str + '&calc_cost_grp_cd='
				+ sheetObj.CellValue(row, 'calc_cost_grp_cd');
		url_str = url_str + '&calc_tp_cd='
				+ sheetObj.CellValue(row, 'calc_tp_cd');
		url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
		url_str = url_str + '&inv_no=' + formObj.inv_no.value;
		url_str = url_str + '&inv_ofc_cd=' + formObj.inv_ofc_cd.value;
		url_str = url_str + '&param_lgs_cost_cd='
				+ sheetObj.CellValue(row, 'lgs_cost_cd');
		url_str = url_str + '&param_cntr_tpsz_cd='
				+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
		url_str = url_str + '&curr_cd=' + formObj.curr_cd.Code;
		url_str = url_str + '&inv_amt=' + sheetObj.CellValue(row, 'inv_amt');
		url_str = url_str + '&param_rc_flg='
				+ sheetObj.CellValue(row, 'rc_flg');
		url_str = url_str + '&sheet_curr_row=' + row;
		url_str = url_str + '&sheet_idx=3';
		url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
		url_str = url_str + '&ctrt_rt=' + sheetObj.CellValue(row, 'ctrt_rt');
		url_str = url_str + '&inv_xch_rt='
				+ sheetObj.CellValue(row, 'inv_xch_rt');
		url_str = url_str + '&rvis_vol_qty='
				+ sheetObj.CellValue(row, 'rvis_vol_qty');

		window.showModalDialog(url_str, window, "dialogWidth:710px; dialogHeight:440px; help:no; status:no; resizable:yes;");
	}
}

/**
 * Cost Calc.(SR by FD) sheet 팝업 클릭 시 발생하는 이벤트 - 3rd Party Interface 입력 화면 뜬다
 * @param {sheet}	sheetObj	Cost Calc.(SR by FD) sheet
 * @param {int}		row			selected row
 * @param {int}		col			selected col
 * @return
 */
function t4sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;
	if (sheetObj.ColSaveName(col) == "n3pty_flg") {
		if (sheetObj.CellValue(row, 'tml_so_dtl_seq') == ''
				|| sheetObj.CellValue(row, 'tml_so_dtl_seq') == null
				|| sheetObj.CellValue(row, 'tml_so_dtl_seq') == 0) {
			ComShowMessage('You have to 3rd party Input after save calculated result.');
			return false;

		}

		if (sheetObj.CellValue(row, 'calc_cost_grp_cd') == null
				|| sheetObj.CellValue(row, 'calc_cost_grp_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES24046')); // ComShowMessage('Cost Group
												// code가 누락되었습니다.');
			return false;
		}
		if (sheetObj.CellValue(row, 'lgs_cost_cd') == undefined
				|| sheetObj.CellValue(row, 'lgs_cost_cd') == null
				|| sheetObj.CellValue(row, 'lgs_cost_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES23045')); // ComShowMessage('Cost Code를
												// 선택하십시오.');
			return false;
		}
		if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
			ComShowMessage(ComGetMsg('TES40041', 'Currency code')); // ComShowMessage('Currency
																	// code가
																	// 누락되었습니다.');
			return false;
		}
		if ((sheetObj.CellValue(row, 'calc_tp_cd') != null && sheetObj
				.CellValue(row, 'calc_tp_cd') == 'A')
				&& (sheetObj.CellValue(row, 'cntr_no') == undefined
						|| sheetObj.CellValue(row, 'cntr_no') == null || sheetObj
						.CellValue(row, 'cntr_no').trim() == '')) {
			ComShowMessage(ComGetMsg('TES23047')); // ComShowMessage('cntr_no가
												// 누락되었습니다.');
			return false;
		}
		/** 2007-11-01 금액이 음수인 경우 TPB popup을 띄우지 않는다 * */
		if (sheetObj.CellValue(row, 'inv_amt') != undefined
				&& sheetObj.CellValue(row, 'inv_amt') != null
				&& sheetObj.CellValue(row, 'inv_amt') < 0) {
			return false;
		}
		var url_str = 'ESD_TES_9233Popup.screen';
		url_str = url_str + '?tml_so_ofc_cty_cd='
				+ formObj.tml_so_ofc_cty_cd.value;
		url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
		url_str = url_str + '&tml_so_dtl_seq='
				+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
		url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
		url_str = url_str + '&calc_cost_grp_cd='
				+ sheetObj.CellValue(row, 'calc_cost_grp_cd');
		url_str = url_str + '&calc_tp_cd='
				+ sheetObj.CellValue(row, 'calc_tp_cd');
		url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
		url_str = url_str + '&inv_no=' + formObj.inv_no.value;
		url_str = url_str + '&param_lgs_cost_cd='
				+ sheetObj.CellValue(row, 'lgs_cost_cd');
		url_str = url_str + '&param_cntr_tpsz_cd='
				+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
		url_str = url_str + '&curr_cd=' + formObj.curr_cd.Code;
		url_str = url_str + '&sheet_curr_row=' + row;
		url_str = url_str + '&sheet_idx=4';
		url_str = url_str + '&param_cntr_no='
				+ sheetObj.CellValue(row, 'cntr_no'); // ByDay는 cntr_no가 반드시
														// 필요하다.
		url_str = url_str + '&inv_amt=' + sheetObj.CellValue(row, 'inv_amt');
		url_str = url_str + '&yd_cd=' + formObj.yd_cd.value;
		url_str = url_str + '&ctrt_rt=' + sheetObj.CellValue(row, 'ctrt_rt');
		url_str = url_str + '&inv_xch_rt='
				+ sheetObj.CellValue(row, 'inv_xch_rt');

		// 4341.12.23 3rd Parth Interface Amount 산출 로직 변경(전나영 차장님 CSR)
		url_str = url_str + '&ovr_dys=' + sheetObj.CellValue(row, 'ovr_dys');

		window
				.showModalDialog(url_str, window,
						"dialogWidth:730px; dialogHeight:440px; help:no; status:no; resizable:yes;");
	}
}

/**
 * Cost Calc.(SR by FD) sheet 저장시 발생하는 이벤트
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSaveEnd(t4sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t4sheet1);
	}

	init_Arr_sht_chk();

	// CostCalc.Storage의 manual cost code를 조회한다.
	var formObj = document.form;
	if (formObj.calcStorageComboItems.value == null
			|| formObj.calcStorageComboItems.value.trim() == '') {
		// getCalcStorageManualCostCode();
	}

	if (t4sheet1.RowCount > 0) {
		setElementDiabled('checkbox', 'StorageDay', 'Y');
		setElementDiabled('radio', 'CostCalcMethod', 'Y');

		// t1sheet1_SetChkBoxDisabled();
		// t2sheet1_SetChkBoxDisabled();

		for ( var i = 1; i <= t4sheet1.RowCount; i++) {
			if (t4sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t4sheet1.CellValue(i, "curr_cd") != undefined
						&& t4sheet1.CellValue(i, "curr_cd") != null
						&& t4sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t4sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t4sheet1.CellValue(i, "calc_tp_cd") == "M") {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 14 - 이경한과장
				// 요청 )
				setShtCellsEditable( t4sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
				setShtCellsEditable( t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
			} else if (t4sheet1.CellValue(i, "calc_tp_cd") == "S") {
				// 양부장님 요청
				// 요청 )
				setShtCellsEditable( t4sheet1, i, 'ovr_dys', 'Y',"EXCEPTION");
				setShtCellsEditable( t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
			}
		}

		setCalcStorageManualCostCode(t4sheet1);

		checkTPBdataEditable('4', t4sheet1);

	} else {
		document.form.t4sht_tot_inv_amt.value = 0;
		setElementDiabled('checkbox', 'StorageDay', 'N');
	}

}

/**
* Cost Calc.(SR by FD) sheet 조회시 발생하는 이벤트
* @param {ibsheet}	t4sheet1	Cost Calc.(SR by FP)sheet
* @param {string}	ErrMsg		error message
* @return
*/
function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t4sheet1);
	}

	init_Arr_sht_chk();

	// CostCalc.Storage의 manual cost code를 조회한다.
	var formObj = document.form;
	if (formObj.calcStorageComboItems.value == null
			|| formObj.calcStorageComboItems.value.trim() == '') {
		// getCalcStorageManualCostCode();
	}

	if (t4sheet1.RowCount > 0) {
		/*
		 * if (currChk(t4sheet1)){ if (!curr_chk){ ComShowMessage('입력하신 Currency
		 * Code는 Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시
		 * 계산해주십시오.'); } removeAutoCalcData(); return false; }
		 */
		setElementDiabled('checkbox', 'StorageDay', 'Y');
		setElementDiabled('radio', 'CostCalcMethod', 'Y');

		// t1sheet1_SetChkBoxDisabled();
		// t2sheet1_SetChkBoxDisabled();

		document.form.t4sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t4sheet1, 'inv_amt'));
		
		document.form.t4sht_tot_cgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_cgst_amt');
		document.form.t4sht_tot_sgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_sgst_amt');
		document.form.t4sht_tot_igst_amt.value = getShtTotGstAmt(t4sheet1,'ida_igst_amt');
		document.form.t4sht_tot_ugst_amt.value = getShtTotGstAmt(t4sheet1,'ida_ugst_amt');

		for ( var i = 1; i <= t4sheet1.RowCount; i++) {
			// 변환문자를 특수 문자로 치환. (2010-04-23)
			t4sheet1.CellValue2(i, "calc_rmk") = ComToString( t4sheet1.CellValue(i, "calc_rmk") );
			
			if (t4sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t4sheet1.CellValue(i, "curr_cd") != undefined
						&& t4sheet1.CellValue(i, "curr_cd") != null
						&& t4sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t4sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t4sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t4sheet1.CellValue(i, "calc_tp_cd") == "M") {
				// Manual Input 비용 계산 적용 Year Month 컬럼 추가 ( 4342. 01. 16 - 이경한과장
				// 요청 )
				setShtCellsEditable( t4sheet1, i, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
				setShtCellsEditable( t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N');
			} else if (t4sheet1.CellValue(i, "calc_tp_cd") == "S") {
				// 양부장님 요청
				// 요청 )
				setShtCellsEditable( t4sheet1, i, 'ovr_dys', 'Y',"EXCEPTION");
				setShtCellsEditable( t4sheet1, i, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
			}
		}

		setCalcStorageManualCostCode(t4sheet1);

		checkTPBdataEditable('4', t4sheet1);

	} else {
		document.form.t4sht_tot_inv_amt.value = 0;
		setElementDiabled('checkbox', 'StorageDay', 'N');
	}
}

  /**
   * Cost Calc.(SR by FD) sheet 데이터 변경 시 발생하는 이벤트
   * @param {sheet}		t4sheet1	Cost Calc.(SR by FD) sheet
   * @param {int}		Row			해당 셀의 Row Index
   * @param {int}		Col			해당 셀의 Column Index
   * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
   * @return
   */  
function t4sheet1_OnChange(t4sheet1, Row, Col, Value) {
	var sName = t4sheet1.ColSaveName(Col);
	if (sName == "stay_dys" || sName == "free_dys" || sName == "paid_day"
			|| sName == "free_dy_xcld_dys" || sName == "ovr_dys"
			|| sName == "ctrt_rt" || sName == 'vol_tr_ut_cd') {
		if (isNaN(t4sheet1.CellValue(Row, 'free_dys'))
				|| parseInt(t4sheet1.CellValue(Row, 'free_dys'), 10) < 0) {
			t4sheet1.CellValue2(Row, 'free_dys') = 0;
		}
		if (isNaN(t4sheet1.CellValue(Row, 'paid_day'))
				|| parseInt(t4sheet1.CellValue(Row, 'paid_day'), 10) < 0) {
			t4sheet1.CellValue2(Row, 'paid_day') = 0;
		}
		if (isNaN(t4sheet1.CellValue(Row, 'free_dy_xcld_dys'))
				|| parseInt(t4sheet1.CellValue(Row, 'free_dy_xcld_dys'), 10) < 0) {
			t4sheet1.CellValue2(Row, 'free_dy_xcld_dys') = 0;
		}
		t4sheet1_RecalcCalcAmt(t4sheet1, Row);
	}
	if (sName == "inv_xch_rt") {
		t4sheet1.CellValue(Row, 'inv_xch_rt') = Math.abs(t4sheet1.CellValue(
				Row, 'inv_xch_rt'));
		if (t4sheet1.CellValue(Row, 'inv_xch_rt') > 0) {
			t4sheet1.CellBackColor(Row, 'inv_xch_rt') = t4sheet1.RgbColor(0, 0,
					0);
		}
		if (t4sheet1.CellValue(Row, 'calc_tp_cd') == 'A') {
			if (t4sheet1.CellValue(Row, 'curr_cd') != undefined
					&& t4sheet1.CellValue(Row, 'curr_cd') != null
					&& t4sheet1.CellValue(Row, 'curr_cd') != ''
					&& document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& document.form.curr_cd.Code != t4sheet1.CellValue(Row,
							'curr_cd')
					&& !isNaN(t4sheet1.CellValue(Row, 'inv_xch_rt'))
					&& Number(t4sheet1.CellValue(Row, 'inv_xch_rt')) > 0) {
				t4sheet1.CellValue(Row, 'inv_amt') = Number(t4sheet1.CellValue(
						Row, 'ovr_dys'))
						* Number(t4sheet1.CellValue(Row, 'ctrt_rt'))
						* Number(t4sheet1.CellValue(Row, 'inv_xch_rt'));
			}
		} else if (t4sheet1.CellValue(Row, 'calc_tp_cd') == 'M') {
			if (document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& !isNaN(t4sheet1.CellValue(Row, 'inv_xch_rt'))
					&& Number(t4sheet1.CellValue(Row, 'inv_xch_rt')) > 0) {
				t4sheet1.CellValue(Row, 'inv_amt') = Number(t4sheet1.CellValue(
						Row, 'ovr_dys'))
						* Number(t4sheet1.CellValue(Row, 'ctrt_rt'))
						* Number(t4sheet1.CellValue(Row, 'inv_xch_rt'));
			}
		}
	}
	if (sName == "inv_amt") {
		document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(t4sheet1, 'inv_amt');
		
		//금액이 변경되면 India GST 금액도 변경
		t4sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
    	
		t4sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t4sheet1.CellValue(Row,'ida_cgst_rto')) 
    	                                        + parseFloat(t4sheet1.CellValue(Row,'ida_sgst_rto'))
    	                                        + parseFloat(t4sheet1.CellValue(Row,'ida_igst_rto'))
    	                                        + parseFloat(t4sheet1.CellValue(Row,'ida_ugst_rto'));
		t4sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t4sheet1.CellValue(Row,'ida_cgst_amt')) 
    											+ parseFloat(t4sheet1.CellValue(Row,'ida_sgst_amt'))
    											+ parseFloat(t4sheet1.CellValue(Row,'ida_igst_amt'))
    											+ parseFloat(t4sheet1.CellValue(Row,'ida_ugst_amt'));
    	
		document.form.t4sht_tot_cgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_cgst_amt');
		document.form.t4sht_tot_sgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_sgst_amt');
		document.form.t4sht_tot_igst_amt.value = getShtTotGstAmt(t4sheet1,'ida_igst_amt');
		document.form.t4sht_tot_ugst_amt.value = getShtTotGstAmt(t4sheet1,'ida_ugst_amt');
	}
	
	//[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
	if(sName == "lgs_cost_cd") {
        if(t4sheet1.CellValue(Row,'lgs_cost_cd') != '' && t4sheet1.CellValue(Row,'lgs_cost_cd') != null){
        	checkValidForRemark(t4sheet1.CellValue(Row,'lgs_cost_cd'), Row, '3') ;
        } 
	}
	
	//India GST
    if(sName == 'ida_sac_cd'){
    	checkValidSacCd(t4sheet1.CellValue(Row,'ida_sac_cd'), Row, '3');  	
    }
	
    if(sName == 'ida_cgst_rto' || sName == 'ida_sgst_rto' || sName == 'ida_igst_rto' || sName == 'ida_ugst_rto'){
	
		t4sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t4sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t4sheet1.CellValue(Row,'inv_amt') * t4sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
		
		t4sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t4sheet1.CellValue(Row,'ida_cgst_rto')) 
		                                        + parseFloat(t4sheet1.CellValue(Row,'ida_sgst_rto'))
		                                        + parseFloat(t4sheet1.CellValue(Row,'ida_igst_rto'))
		                                        + parseFloat(t4sheet1.CellValue(Row,'ida_ugst_rto'));
		t4sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t4sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t4sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t4sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t4sheet1.CellValue(Row,'ida_ugst_amt'));
		
		document.form.t4sht_tot_cgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_cgst_amt');
		document.form.t4sht_tot_sgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_sgst_amt');
		document.form.t4sht_tot_igst_amt.value = getShtTotGstAmt(t4sheet1,'ida_igst_amt');
		document.form.t4sht_tot_ugst_amt.value = getShtTotGstAmt(t4sheet1,'ida_ugst_amt'); 	
	}
    
    if(sName == 'ida_cgst_amt' || sName == 'ida_sgst_amt' || sName == 'ida_igst_amt' || sName == 'ida_ugst_amt'){
    	t4sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t4sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t4sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t4sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t4sheet1.CellValue(Row,'ida_ugst_amt'));

		document.form.t4sht_tot_cgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_cgst_amt');
		document.form.t4sht_tot_sgst_amt.value = getShtTotGstAmt(t4sheet1,'ida_sgst_amt');
		document.form.t4sht_tot_igst_amt.value = getShtTotGstAmt(t4sheet1,'ida_igst_amt');
		document.form.t4sht_tot_ugst_amt.value = getShtTotGstAmt(t4sheet1,'ida_ugst_amt'); 	    	
    }
}

/**
 * [Inv Amt] 계산
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FD) sheet
 * @param {int}		Row			해당 셀의 Row Index
 * @return
 */
function t4sheet1_RecalcCalcAmt(t4sheet1, Row) {
	if (t4sheet1.RowCount > 0) {
		if (t4sheet1.CellValue(Row, 'stay_dys') == -1) {
			t4sheet1.RowFontColor(Row) = t4sheet1.RgbColor(255, 0, 0);
		} else {
			t4sheet1.RowFontColor(Row) = t4sheet1.DataFontColor;
		}

		if (t4sheet1.CellValue(Row, "calc_tp_cd") == "A") {
			t4sheet1.CellValue2(Row, 'ovr_dys') = Number(t4sheet1.CellValue(Row, 'ovr_dys2'))
					- Number(t4sheet1.CellValue(Row, 'paid_day'))
					- Number(t4sheet1.CellValue(Row, 'free_dy_xcld_dys'));
		} else if (t4sheet1.CellValue(Row, "calc_tp_cd") == "M" || t4sheet1.CellValue(Row, "calc_tp_cd") == "S") {
			t4sheet1.CellValue2(Row, 'ovr_dys') = Number(t4sheet1.CellValue(Row, 'stay_dys'))
					- Number(t4sheet1.CellValue(Row, 'free_dys'))
					- Number(t4sheet1.CellValue(Row, 'paid_day'))
					- Number(t4sheet1.CellValue(Row, 'free_dy_xcld_dys'));
		}
		var ovr_dys = Number(t4sheet1.CellValue(Row, 'ovr_dys'));
		if (isNaN(ovr_dys) || parseInt(ovr_dys, 10) < 0) {
			ovr_dys = 0;
			t4sheet1.CellValue2(Row, 'ovr_dys') = 0;
		}
		t4sheet1.CellValue(Row, 'inv_amt') = Number(ovr_dys)
				* Number(t4sheet1.CellValue(Row, 'ctrt_rt'))
				* (Number(t4sheet1.CellValue(Row, 'inv_xch_rt')) > 0 ? Number(t4sheet1
						.CellValue(Row, 'inv_xch_rt'))
						: 1);
		/*
		 * if (t4sheet1.CellValue(Row,'calc_tp_cd')=='A') { if
		 * (t4sheet1.CellValue(Row,'curr_cd')!=undefined &&
		 * t4sheet1.CellValue(Row,'curr_cd')!=null &&
		 * t4sheet1.CellValue(Row,'curr_cd')!='' &&
		 * document.form.curr_cd.Code!=undefined &&
		 * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
		 * document.form.curr_cd.Code!=t4sheet1.CellValue(Row,'curr_cd') &&
		 * !isNaN(t4sheet1.CellValue(Row,'inv_xch_rt')) &&
		 * Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0) {
		 * t4sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
		 * Number(t4sheet1.CellValue(Row,'ctrt_rt')) *
		 * (Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t4sheet1.CellValue(Row,'inv_xch_rt')):1); } }
		 * else if (t4sheet1.CellValue(Row,'calc_tp_cd')=='M'){ if
		 * (document.form.curr_cd.Code!=undefined &&
		 * document.form.curr_cd.Code!=null && document.form.curr_cd.Code!='' &&
		 * !isNaN(t4sheet1.CellValue(Row,'inv_xch_rt')) &&
		 * Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0) {
		 * t4sheet1.CellValue(Row,'inv_amt') = Number(ovr_dys) *
		 * Number(t4sheet1.CellValue(Row,'ctrt_rt')) *
		 * (Number(t4sheet1.CellValue(Row,'inv_xch_rt'))>0?Number(t4sheet1.CellValue(Row,'inv_xch_rt')):1); } }
		 */

		if ((t4sheet1.CellValue(Row, 'cntr_tpsz_cd') != undefined
				&& t4sheet1.CellValue(Row, 'cntr_tpsz_cd') != null && t4sheet1
				.CellValue(Row, 'cntr_tpsz_cd').trim() != '')
				&& (t4sheet1.CellValue(Row, 'vol_tr_ut_cd') != undefined
						&& t4sheet1.CellValue(Row, 'vol_tr_ut_cd') != null && t4sheet1
						.CellValue(Row, 'vol_tr_ut_cd').trim() != '')) {
			t4sheet1.CellValue(Row, 'inv_amt') = t4sheet1.CellValue(Row,
					'inv_amt')
					* tes_getTEUconv(t4sheet1.CellValue(Row, 'vol_tr_ut_cd'),
							t4sheet1.CellValue(Row, 'cntr_tpsz_cd'));
		}
	}
}

/**
 * Cost Calc.(SR by FP) sheet 시 팝업 클릭 시 발생하는 이벤트 - 3rd Party Interface 입력 화면 뜬다
 * @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
 * @param {int}		row			해당 셀의 Row Index
 * @param {int}		col			해당 셀의 Column Index
 * @return
 */
function t5sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;
	if (sheetObj.ColSaveName(col) == "n3pty_flg") {
		if (sheetObj.CellValue(row, 'calc_cost_grp_cd') == null
				|| sheetObj.CellValue(row, 'calc_cost_grp_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES24046')); // ComShowMessage('Cost Group
												// code가 누락되었습니다.');
			return false;
		}
		if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
			ComShowMessage(ComGetMsg('TES40041', 'Currency code')); // ComShowMessage('Currency
																	// code가
																	// 누락되었습니다.');
			return false;
		}
		if (sheetObj.CellValue(row, 'lgs_cost_cd') == undefined
				|| sheetObj.CellValue(row, 'lgs_cost_cd') == null
				|| sheetObj.CellValue(row, 'lgs_cost_cd').trim() == '') {
			ComShowMessage(ComGetMsg('TES23045')); // ComShowMessage('Cost Code를
												// 선택하십시오.');
			return false;
		}
		/** 2007-11-01 금액이 음수인 경우 TPB popup을 띄우지 않는다 * */
		if (sheetObj.CellValue(row, 'inv_amt') != undefined
				&& sheetObj.CellValue(row, 'inv_amt') != null
				&& sheetObj.CellValue(row, 'inv_amt') < 0) {
			return false;
		}
		var url_str = 'ESD_TES_9233Popup.screen';
		url_str = url_str + '?tml_so_ofc_cty_cd='
				+ formObj.tml_so_ofc_cty_cd.value;
		url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
		url_str = url_str + '&tml_so_dtl_seq='
				+ sheetObj.CellValue(row, 'tml_so_dtl_seq');
		url_str = url_str + '&tml_inv_tp_cd=' + formObj.tml_inv_tp_cd.value;
		url_str = url_str + '&calc_cost_grp_cd='
				+ sheetObj.CellValue(row, 'calc_cost_grp_cd');
		url_str = url_str + '&calc_tp_cd='
				+ sheetObj.CellValue(row, 'calc_tp_cd');
		url_str = url_str + '&vndr_seq=' + formObj.vndr_seq.value;
		url_str = url_str + '&inv_no=' + formObj.inv_no.value;
		url_str = url_str + '&param_lgs_cost_cd='
				+ sheetObj.CellValue(row, 'lgs_cost_cd');
		url_str = url_str + '&param_cntr_tpsz_cd='
				+ sheetObj.CellValue(row, 'cntr_tpsz_cd');
		url_str = url_str + '&curr_cd=' + formObj.curr_cd.Code;
		url_str = url_str + '&sheet_curr_row=' + row;
		url_str = url_str + '&sheet_idx=5';
		window.showModalDialog(url_str, window, "dialogWidth:730px; dialogHeight:440px; help:no; status:no; resizable:yes;");
	}
}

/**
* Cost Calc.(SR by FP) sheet 조회시 발생하는 이벤트
* @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
* @param {string}	ErrMsg		error message
* @return
*/
function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t5sheet1);
	}

	init_Arr_sht_chk();

	var formObj = document.form;

	if (t5sheet1.RowCount > 0) {
		/*
		 * if (currChk(t5sheet1)){ ComShowMessage('입력하신 Currency Code는
		 * Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시
		 * 계산해주십시오.'); removeAutoCalcData2(); return false; }
		 */
		setPeriodReadonly('Y');

		for ( var i = 1; i <= t5sheet1.RowCount; i++) {

			// 변환문자를 특수 문자로 치환. (2010-04-23)
			t5sheet1.CellValue2(i, "calc_rmk") = ComToString( t5sheet1.CellValue(i, "calc_rmk") );

			if (t5sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t5sheet1.CellValue(i, "curr_cd") != undefined
						&& t5sheet1.CellValue(i, "curr_cd") != null
						&& t5sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t5sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t5sheet1.CellValue(i, "calc_tp_cd") == "M") {
				setShtCellsEditable( t5sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt', 'Y');
			}
		}

		t5sheet1_MonthlyRowManage(t5sheet1);

		t5sheet1_ShowSubSum(t5sheet1);

		setCalcStorageManualCostCode(t5sheet1);

		t5sheet1_TotCalcAmt(t5sheet1);

		t5sheet1_ChkDifferVol2(t5sheet1);

		checkTPBdataEditable('5', t5sheet1);

	} else {
		document.form.t5sht_tot_inv_amt.value = 0;
		setPeriodReadonly('N');
	}
}

/**
* Cost Calc.(SR by FP) sheet 저장시 발생하는 이벤트
* @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
* @param {string}	ErrMsg		error message
* @return
*/	
function t5sheet1_OnSaveEnd(t5sheet1, ErrMsg) {
	if (confirm_done) {
		disableSheetEditable(t5sheet1);
	}

	init_Arr_sht_chk();

	// CostCalc.Storage의 manual cost code를 조회한다.
	var formObj = document.form;

	if (formObj.calcStorageComboItems.value == null
			|| formObj.calcStorageComboItems.value.trim() == '') {
		// getCalcStorageManualCostCode();
	}

	if (t5sheet1.RowCount > 0) {
		/*
		 * if (currChk(t5sheet1)){ ComShowMessage('입력하신 Currency Code는
		 * Agreement의 currency 와 일치하지 않아Calculation Data를 삭제합니다. 확인 후 다시
		 * 계산해주십시오.'); removeAutoCalcData2(); return false; }
		 */
		setPeriodReadonly('Y');

		t5sheet1_ShowSubSum(t5sheet1);

		for ( var i = 1; i <= t5sheet1.RowCount; i++) {
			if (t5sheet1.CellValue(i, "calc_tp_cd") == "A") {
				if (t5sheet1.CellValue(i, "curr_cd") != undefined
						&& t5sheet1.CellValue(i, "curr_cd") != null
						&& t5sheet1.CellValue(i, "curr_cd") != ''
						&& formObj.curr_cd.Code != undefined
						&& formObj.curr_cd.Code != null
						&& formObj.curr_cd.Code != ''
						&& t5sheet1.CellValue(i, "curr_cd") != formObj.curr_cd.Code) {
					setShtCellsEditable(t5sheet1, i, 'inv_xch_rt', 'Y', 'EXCEPTION');
				}
			} else if (t5sheet1.CellValue(i, "calc_tp_cd") == "M") {
				setShtCellsEditable( t5sheet1, i, 'lgs_cost_cd|wrk_dt|stk_vol_qty|inv_vol_qty|diff_vol_qty|fp_teu_qty|ovr_vol_qty|vol_tr_ut_cd|ctrt_rt|inv_amt|calc_rmk|n3pty_flg|inv_xch_rt', 'Y');
			}
		}

		setCalcStorageManualCostCode(t5sheet1);

		t5sheet1_TotCalcAmt(t5sheet1);

		t5sheet1_ChkDifferVol2(t5sheet1);

		checkTPBdataEditable('5', t5sheet1);

	} else {
		document.form.t5sht_tot_inv_amt.value = 0;
		setPeriodReadonly('N');
	}

}

/**
  * Cost Calc.(SR by FP) sheet 데이터 변경 시 발생하는 이벤트
  * @param {sheet}		t4sheet1	Cost Calc.(SR by FP) sheet
  * @param {int}		Row			해당 셀의 Row Index
  * @param {int}		Col			해당 셀의 Column Index
  * @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
  * @return
*/  
function t5sheet1_OnChange(t5sheet1, Row, Col, Value) {
	// Manual Input Year Month 컬럼 추가 ( 4342. 01. 16 - 이경한과장 요청 CSR )
	// FP 탭에서는 Date 컬럼이 비용 계산 적용 년월이라서 CSR 발행시 효과적인 사용을 위해 rev_yrmon에 셋팅
	if (t5sheet1.CellValue(Row, 'calc_tp_cd') == 'M'
			&& t5sheet1.ColSaveName(Col) == 'wrk_dt') {
		if (t5sheet1.CellValue(Row, 'wrk_dt') != null
				|| t5sheet1.CellValue(Row, 'wrk_dt').trim() == '') {
			t5sheet1.CellValue(Row, 'rev_yrmon') = t5sheet1.CellValue(Row,
					'wrk_dt').substring(0, 6);
		}
	}

	var sName = t5sheet1.ColSaveName(Col);
	if (sName == "inv_vol_qty" || sName == "fp_teu_qty" || sName == "ctrt_rt"
			|| sName == "inv_xch_rt") {
		// inv_xch_rt는 음수불가
		t5sheet1.CellValue2(Row, 'inv_xch_rt') = Math.abs(t5sheet1.CellValue(
				Row, 'inv_xch_rt'));
		if (t5sheet1.CellValue(Row, 'inv_xch_rt') > 0) {
			t5sheet1.CellBackColor(Row, 'inv_xch_rt') = t5sheet1.RgbColor(0, 0,
					0);
		}
		// row별로 amt계산하기..
		t5sheet1_RecalcCalcAmt(t5sheet1, Row);
	}
	if (sName == "inv_amt") {
		//금액이 변경되면 India GST 금액도 변경
		t5sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
    	
		t5sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t5sheet1.CellValue(Row,'ida_cgst_rto')) 
    	                                        + parseFloat(t5sheet1.CellValue(Row,'ida_sgst_rto'))
    	                                        + parseFloat(t5sheet1.CellValue(Row,'ida_igst_rto'))
    	                                        + parseFloat(t5sheet1.CellValue(Row,'ida_ugst_rto'));
		t5sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t5sheet1.CellValue(Row,'ida_cgst_amt')) 
    											+ parseFloat(t5sheet1.CellValue(Row,'ida_sgst_amt'))
    											+ parseFloat(t5sheet1.CellValue(Row,'ida_igst_amt'))
    											+ parseFloat(t5sheet1.CellValue(Row,'ida_ugst_amt'));
		t5sheet1_TotCalcAmt(t5sheet1);
	}
	t5sheet1_ShowSubSum(t5sheet1);
	
	//[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
	if(sName == "lgs_cost_cd") {
        if(t5sheet1.CellValue(Row,'lgs_cost_cd') != '' && t5sheet1.CellValue(Row,'lgs_cost_cd') != null){
        	checkValidForRemark(t5sheet1.CellValue(Row,'lgs_cost_cd'), Row, '4') ;
        } 
	}
	
	if(sName == 'ida_sac_cd'){//India GST
    	checkValidSacCd(t5sheet1.CellValue(Row,'ida_sac_cd'), Row, '4');  	
    }
	if(sName == 'ida_cgst_rto' || sName == 'ida_sgst_rto' || sName == 'ida_igst_rto' || sName == 'ida_ugst_rto'){
	
		t5sheet1.CellValue(Row,'ida_cgst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_cgst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_sgst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_sgst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_igst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_igst_rto'))/100,2);
		t5sheet1.CellValue(Row,'ida_ugst_amt') = tes_round((t5sheet1.CellValue(Row,'inv_amt') * t5sheet1.CellValue(Row,'ida_ugst_rto'))/100,2);
		
		t5sheet1.CellValue(Row,'ida_gst_rto') = parseFloat(t5sheet1.CellValue(Row,'ida_cgst_rto')) 
		                                        + parseFloat(t5sheet1.CellValue(Row,'ida_sgst_rto'))
		                                        + parseFloat(t5sheet1.CellValue(Row,'ida_igst_rto'))
		                                        + parseFloat(t5sheet1.CellValue(Row,'ida_ugst_rto'));
		t5sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t5sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t5sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t5sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t5sheet1.CellValue(Row,'ida_ugst_amt'));
		
		document.form.t5sht_tot_cgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_cgst_amt');
		document.form.t5sht_tot_sgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_sgst_amt');
		document.form.t5sht_tot_igst_amt.value = getShtTotGstAmt(t5sheet1,'ida_igst_amt');
		document.form.t5sht_tot_ugst_amt.value = getShtTotGstAmt(t5sheet1,'ida_ugst_amt'); 	
	}
	
	if(sName == 'ida_cgst_amt' || sName == 'ida_sgst_amt' || sName == 'ida_igst_amt' || sName == 'ida_ugst_amt'){
		t5sheet1.CellValue(Row,'ida_gst_amt') = parseFloat(t5sheet1.CellValue(Row,'ida_cgst_amt')) 
												+ parseFloat(t5sheet1.CellValue(Row,'ida_sgst_amt'))
												+ parseFloat(t5sheet1.CellValue(Row,'ida_igst_amt'))
												+ parseFloat(t5sheet1.CellValue(Row,'ida_ugst_amt'));

		document.form.t5sht_tot_cgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_cgst_amt');
		document.form.t5sht_tot_sgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_sgst_amt');
		document.form.t5sht_tot_igst_amt.value = getShtTotGstAmt(t5sheet1,'ida_igst_amt');
		document.form.t5sht_tot_ugst_amt.value = getShtTotGstAmt(t5sheet1,'ida_ugst_amt'); 	
	}
}

/**
* [Inv Amt] 계산
* @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
* @param {int}		Row			해당 셀의 Row Index
* @return
*/     
function t5sheet1_RecalcCalcAmt(t5sheet1, Row) {
	if (t5sheet1.RowCount > 0) {
		t5sheet1.CellValue2(Row, 'ovr_vol_qty') = t5sheet1.CellValue(Row,
				'inv_vol_qty')
				- t5sheet1.CellValue(Row, 'fp_teu_qty');
		t5sheet1.CellValue2(Row, 'diff_vol_qty') = t5sheet1.CellValue(Row,
				'stk_vol_qty')
				- t5sheet1.CellValue(Row, 'inv_vol_qty');
		var ovr_vol_qty = t5sheet1.CellValue(Row, 'ovr_vol_qty');
		if (isNaN(ovr_vol_qty) || parseInt(ovr_vol_qty, 10) < 0) {
			ovr_vol_qty = 0;
			t5sheet1.CellValue2(Row, 'ovr_vol_qty') = 0;
		}
		t5sheet1.CellValue(Row, 'inv_amt') = ovr_vol_qty
				* t5sheet1.CellValue(Row, 'ctrt_rt');

		if (t5sheet1.CellValue(Row, 'calc_tp_cd') == 'A') {
			if (t5sheet1.CellValue(Row, 'curr_cd') != undefined
					&& t5sheet1.CellValue(Row, 'curr_cd') != null
					&& t5sheet1.CellValue(Row, 'curr_cd') != ''
					&& document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& document.form.curr_cd.Code != t5sheet1.CellValue(Row,
							'curr_cd')
					&& !isNaN(t5sheet1.CellValue(Row, 'inv_xch_rt'))
					&& parseFloat(t5sheet1.CellValue(Row, 'inv_xch_rt')) > 0) {
				t5sheet1.CellValue(Row, 'inv_amt') = parseFloat(t5sheet1
						.CellValue(Row, 'inv_amt'))
						* parseFloat(t5sheet1.CellValue(Row, 'inv_xch_rt'));
			}
		} else if (t5sheet1.CellValue(Row, 'calc_tp_cd') == 'M') {
			if (document.form.curr_cd.Code != undefined
					&& document.form.curr_cd.Code != null
					&& document.form.curr_cd.Code != ''
					&& !isNaN(t5sheet1.CellValue(Row, 'inv_xch_rt'))
					&& parseFloat(t5sheet1.CellValue(Row, 'inv_xch_rt')) > 0) {
				t5sheet1.CellValue(Row, 'inv_amt') = parseFloat(t5sheet1
						.CellValue(Row, 'inv_amt'))
						* parseFloat(t5sheet1.CellValue(Row, 'inv_xch_rt'));
			}
		}
		t5sheet1_ChkDifferVol(t5sheet1, Row);
	}
}

/**
* invoice vol.과 diff vol.의 차이 나면 해당 셀의 row 색 붉은색으로 설정
* @param {sheet}	t5sheet1	ibsheet
* @param {int}		Row			해당 셀의 Row Index
* @return
*/ 
function t5sheet1_ChkDifferVol(t5sheet1, Row) {
	var diff_vol_qty = parseFloat(t5sheet1.CellValue(Row, 'diff_vol_qty'));
	var inv_vol_qty = parseFloat(t5sheet1.CellValue(Row, 'inv_vol_qty'));
	var result = (diff_vol_qty / inv_vol_qty);
	if (result > 0.01) {
		t5sheet1.RowFontColor(Row) = t5sheet1.RgbColor(255, 0, 0);
	} else {
		t5sheet1.RowFontColor(Row) = t5sheet1.DataFontColor;
	}
}

/**
* invoice vol.과 diff vol.의 차이 나면 전체 셀의 row 색 붉은색으로 설정
* @param {sheet}	t5sheet1	ibsheet
* @return
*/
function t5sheet1_ChkDifferVol2(t5sheet1) {
	// invoice vol.과 diff vol.의 차이가 0.01 이상 나면 해당 row 전체에 씨뻘건 표시 한데이..
	if (t5sheet1.RowCount > 0) {
		var diff_vol_qty = 0;
		var inv_vol_qty = 0;
		var result = 0;
		for ( var i = 1; i <= t5sheet1.RowCount; i++) {
			diff_vol_qty = parseFloat(t5sheet1.CellValue(i, 'diff_vol_qty'));
			inv_vol_qty = parseFloat(t5sheet1.CellValue(i, 'inv_vol_qty'));
			result = (Math.abs(diff_vol_qty) / Math.abs(inv_vol_qty));
			if (result > 0.01) {
				t5sheet1.RowFontColor(i) = t5sheet1.RgbColor(255, 0, 0);
			} else {
				t5sheet1.RowFontColor(i) = t5sheet1.DataFontColor;
			}
		}
	}
}

/**
* Cost Calc.(SR by FP) sheet 클릭 시 발생하는 이벤트
* @param {sheet}	t4sheet1	Cost Calc.(SR by FP) sheet
* @param {int}		Row			해당 셀의 Row Index
* @param {int}		Col			해당 셀의 Column Index
* @param {string}	Value		변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
* @return
*/  
function t5sheet1_OnClick(t5sheet1, Row, Col, Value) {
	if (t5sheet1.ColSaveName(Col) == 'calc_rmk') {
		// ComShowMessage(' cell value:' + t5sheet1.CellValue(Row,'lgs_cost_cd')
		// );
	}
}

/**
* Cost Calc.(SR by FP) sheet 소계와 누계를 계산하여 표시한다.
* @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
* @return
*/
function t5sheet1_ShowSubSum(t5sheet1) {
	t5sheet1.HideSubSum(); // 반드시 다 없애고 다시 subsum을 실행해야 잔여 subsum row가 없어진당. 젠장 넘 훌륭한 SHEET땜시...
	t5sheet1.ShowSubSum("calc_tp_cd", "6|7|8|9|10|12|13", -1, false, false, -1, "calc_tp_cd=%s;lgs_cost_cd=TTL");
}

/**
* Cost Calc.(SR by FP) sheet [Calculated AMT] 계산
* @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
* @return
*/
function t5sheet1_TotCalcAmt(t5sheet1) {
	document.form.t5sht_tot_inv_amt.value = tes_chkAmtFmt(getShtTotCalcAmt(t5sheet1, 'inv_amt'));
	
	document.form.t5sht_tot_cgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_cgst_amt');
	document.form.t5sht_tot_sgst_amt.value = getShtTotGstAmt(t5sheet1,'ida_sgst_amt');
	document.form.t5sht_tot_igst_amt.value = getShtTotGstAmt(t5sheet1,'ida_igst_amt');
	document.form.t5sht_tot_ugst_amt.value = getShtTotGstAmt(t5sheet1,'ida_ugst_amt');
}

/**
* Cost Calc.(SR by FP) sheet 
* @param {sheet}	t5sheet1	Cost Calc.(SR by FP) sheet
* @return
*/
function t5sheet1_MonthlyRowManage(t5sheet1) {
	for ( var i = 0; i < t5sheet1.RowCount; i++) {
		if (t5sheet1.CellValue(i, "calc_tp_cd") == "A") {
			if (t5sheet1.CellValue(i, "fp_calc_prd_cd") == "M") {
				t5sheet1.InitCellProperty(i, 'wrk_dt', dtData, daCenter, 'wrk_dt', '', dfDateYm);
			}
		}
	}
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 
 * 배열은 소스 상단에 정의
 * @param tab_obj
 * @return
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
	// ComShowMessage("setTabObject" + tabCnt);
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function initTab(tabObj, tabNo) {
	// ComShowMessage("initTab - " + tabNo);
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "  Coincidence  ", -1);
			InsertTab(cnt++, "  Discrepancy  ", -1);
			InsertTab(cnt++, "Cost Calc.(TMNL)", -1);
			InsertTab(cnt++, "Cost Calc.(SR by FD)", -1);
			InsertTab(cnt++, "Cost Calc.(SR by FP)", -1);
		}
		break;
	}

	// vndr_seq와 inv_no가 저장된것이 확인되면 (COIN과 DISCP)sheet를 활성화한다.
	if (!save_conf_01) {
		tabObj.Enable = false;
	} else {
		tabObj.Enable = true;
	}
}

/**
 * Tab 변경 시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 * @param {tab}		tabObj		tab object
 * @param {int}		nItem		이전 tab index
 * @return
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

/**
 * 첫번째 tab 클릭 시 발생하는 이벤트
 * @param {tab}		tabObj		tab object
 * @param {int}		tabNo		tab index
 * @return
 */
function tab1_OnClick(tabObj, tabNo) {
	if (save_conf_01) {
		// ComShowMessage("tab1_OnClick nItem:"+tabNo);
		switch (tabNo) {
		case 2:
			setCalcTerminalManualCostCode(sheetObjects[2]);
			break;
		case 3:
			setCalcStorageManualCostCode(sheetObjects[3]);
			break;
		case 4:
			setCalcStorageManualCostCode(sheetObjects[4]);
			break;
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		실행할 액션 구분 값
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

/**
 * 두번째 tab 에서 프린트 버튼 클릭 시 보고서 띄운다
 * @return
 */
function printDiscrepancyContainerList() {
	var fromObj = new Array();
	var rdObj = new Array();
	var paramObj = new Array();
	fromObj[0] = document.form;
	// rdObj[0] = sheetObjects[0];
	// RD_path = "http://yoo:7001/hanjin/";
	// RD로 보내기 위한 설정
	paramObj[0] = "1";
	paramObj[1] = "";
	paramObj[2] = "N";
	paramObj[3] = RD_path + "apps/alps/esd/tes/serviceproviderinvoicemanage/offdockcyinvoicemanage/report/ESD_TES_0807.mrd";
//	paramObj[3] = "http://localhost:7001/hanjin/apps/alps/esd/tes/serviceproviderinvoicemanage/offdockcyinvoicemanage/report/ESD_TES_807.mrd";
	paramObj[4] = rdObj;
	paramObj[5] = fromObj;
	
	rdObjModaless(RdReport, paramObj, 1100, 900);
}

function tes_allComEnableObj0004(formObj, type) {
	formObj.reset();
	var numOfEle = formObj.elements.length;
	for (var i = 0; i < numOfEle; i++){
		ComEnableObject(formObj.elements[i], type);
	}
	comboObjects[0].Enable = false;
}

/**
 * 
 * @param {form}	formObj		form object
 * @return
 */
function tes_initComp0004(formObj){
	tes_allComEnableObj0004(formObj, false);
	
	ComEnableObject(formObj.vndr_seq, true);
	ComEnableObject(formObj.inv_no, true);
	
	formObj.vndr_seq.readOnly = false;
	formObj.inv_no.readOnly = false;
}

/**
 * 화면초기화
 * @param {string}	YN_KEEP_KEY_VALUE		
 * @return
 */
function tes_new0004(YN_KEEP_KEY_VALUE) {

	var formObj = document.form;

	var temp_vndr_seq = '';
	var temp_vndr_seq_nm = '';
	var temp_is_valid_vndr_seq = '';
	var temp_inv_no = '';
	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
		temp_vndr_seq = formObj.vndr_seq.value;
		temp_vndr_seq_nm = formObj.vndr_seq_nm.value;
		temp_is_valid_vndr_seq = formObj.is_valid_vndr_seq.value;
		temp_inv_no = formObj.inv_no.value;
	}

	formObj.reset();

	if (YN_KEEP_KEY_VALUE != undefined && YN_KEEP_KEY_VALUE != null && YN_KEEP_KEY_VALUE == 'Y') {
		// 반드시 reset후에 다시 설정한다.
		formObj.vndr_seq.value = temp_vndr_seq;
		formObj.vndr_seq_nm.value = temp_vndr_seq_nm;
		formObj.is_valid_vndr_seq.value = temp_is_valid_vndr_seq;
		formObj.inv_no.value = temp_inv_no;
	}

	setHeaderKeyValueReadonly('N');
	formObj.yd_cd.readOnly = true;
	formObj.cost_ofc_cd.readOnly = true;
	formObj.fm_prd_dt.readOnly = true;
	formObj.to_prd_dt.readOnly = true;
	formObj.iss_dt.readOnly = true;
	formObj.ttl_inv_amt.readOnly = true;
	formObj.rcv_dt.readOnly = true;
	formObj.vat_amt.readOnly = true;
	formObj.err_inv_no.readOnly = true;
	formObj.whld_tax_amt.readOnly = true;
	setElementDiabled('checkbox', 'hld_flg', 'Y');
	setElementDiabled('checkbox', 'TMNL', 'Y');
	setElementDiabled('checkbox', 'StorageDay', 'Y');
	setElementDiabled('radio', 'CostCalcMethod', 'Y');
	if(conti_cd=="E") {setElementDiabled('checkbox', 'ap_rvs_cng_flg', 'Y');}
	setSheetsEnable(-1, false);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	sheetObjects[5].RemoveAll();
	sheetObjects[6].RemoveAll();
	sheetObjects[7].RemoveAll();
	sheetObjects[8].RemoveAll();
	// comboObjects[0].Code = '';
	comboObjects[0].Code = def_curr_cd;
	comboObjects[0].Enable = false;
	
	tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
}

/**
 * 문자열을 구분자 "|" 로 배열을 반환
 * @param {string}	strEleNums	
 * @return
 */
function setEleNums(strEleNums){
	var eleNums = new Array();
	eleNums = strEleNums.split("|");
	return eleNums;	
}
 
/**
 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
 */
function validateInvDupChk() {
	var formObj = document.form;
	if (formObj.inv_no.value==null || formObj.inv_no.value.trim()==''){
		formObj.is_dup_inv_no.value = '';
		formObj.inv_no_hidden.value = '';
		return false;
	}
	
	if ((formObj.inv_no_hidden.value==null || formObj.inv_no_hidden.value.trim()=='') || formObj.inv_no.value.trim()!=formObj.inv_no_hidden.value.trim()){
		formObj.is_dup_inv_no.value = '';
		formObj.inv_no_hidden.value = '';
		tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
	}
}	

/**
 *  Inv_no Dup Validation 함수
 */
function checkInvDup(){
	var formObj = document.form;
	var tmp = '';
	if (formObj.is_dup_inv_no.value!=undefined && formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value.trim()!=''){
		tmp = formObj.is_dup_inv_no.value;
		if (tmp.length > 0){
			formObj.is_dup_inv_no.value = (tmp!=undefined&&tmp!=null?tmp:'');
			if (formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value == 'Y'){
				//formObj.is_dup_inv_no.value = '';
				//formObj.inv_no_hidden.value = '';
				ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
			}
		}
	}
}  

/**
 * 
 * @param sheetObj
 */
function setCostCode(sheetObj){
	if (sheetObj.CheckedRows("sel") < 1) {
		return;
	}
	var targetSheetObj = sheetObjectsMap['t4sheet1']; 
	var idx;
	for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
		if( !sheetObj.CellValue(i,"sel")) continue;
		idx = targetSheetObj.DataInsert(-1);    	
		targetSheetObj.CellValue2(idx,"calc_tp_cd")      =  sheetObj.CellValue(i,"calc_tp_cd");       
		targetSheetObj.CellValue2(idx,"lgs_cost_cd")     =  sheetObj.CellValue(i,"lgs_cost_cd");      
		targetSheetObj.CellValue2(idx,"cntr_tpsz_cd")    =  sheetObj.CellValue(i,"cntr_tpsz_cd");     
		targetSheetObj.CellValue2(idx,"io_bnd_cd")       =  sheetObj.CellValue(i,"io_bnd_cd");        
		targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd");      
		targetSheetObj.CellValue2(idx,"rc_flg")          =  sheetObj.CellValue(i,"rc_flg");           
		targetSheetObj.CellValue2(idx,"tml_wrk_dy_cd")   =  sheetObj.CellValue(i,"tml_wrk_dy_cd");    
		targetSheetObj.CellValue2(idx,"ioc_cd")          =  sheetObj.CellValue(i,"ioc_cd");           
		targetSheetObj.CellValue2(idx,"tml_trns_mod_cd") =  sheetObj.CellValue(i,"tml_trns_mod_cd");  
		targetSheetObj.CellValue2(idx,"lane_cd")         =  sheetObj.CellValue(i,"lane_cd");          
		targetSheetObj.CellValue2(idx,"tier")            =  sheetObj.CellValue(i,"tier");             
		targetSheetObj.CellValue2(idx,"calc_vol_qty")    =  sheetObj.CellValue(i,"calc_vol_qty");     
		targetSheetObj.CellValue2(idx,"rvis_vol_qty")    =  sheetObj.CellValue(i,"rvis_vol_qty");     
		targetSheetObj.CellValue2(idx,"stay_dys")        =  sheetObj.CellValue(i,"stay_days");        
		targetSheetObj.CellValue2(idx,"vol_tr_ut_cd")    =  sheetObj.CellValue(i,"vol_tr_ut_cd");     
		targetSheetObj.CellValue2(idx,"ctrt_rt")         =  sheetObj.CellValue(i,"ctrt_rt");          
		targetSheetObj.CellValue2(idx,"inv_amt")         =  sheetObj.CellValue(i,"inv_amt");          
		targetSheetObj.CellValue2(idx,"curr_cd")         =  sheetObj.CellValue(i,"curr_cd");  
		
		targetSheetObj.CellValue2(idx,'inv_xch_rt')       = sheetObj.CellValue(i,"inv_xch_rt");

		// 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
		targetSheetObj.CellValue2(idx, "tml_agmt_ofc_cty_cd")	= sheetObj.CellValue(i, "tml_agmt_ofc_cty_cd");      
		targetSheetObj.CellValue2(idx, "tml_agmt_seq")			= sheetObj.CellValue(i, "tml_agmt_seq");      
		targetSheetObj.CellValue2(idx, "tml_agmt_ver_no")		= sheetObj.CellValue(i, "tml_agmt_ver_no");      
		targetSheetObj.CellValue2(idx, "rmk_chk_flg")			= sheetObj.CellValue(i, "rmk_chk_flg");      
	    
		targetSheetObj.CellValue2(idx, "calc_cost_grp_cd") = "SD";
		targetSheetObj.CellValue2(idx,'semi_auto_calc_flg') = 'Y';
		
//		setShtCellsEditable(targetSheetObj, idx, 'lgs_cost_cd|rev_yrmon|stay_dys|ctrt_rt|inv_amt|inv_xch_rt', 'Y');
//		setShtCellsEditable(targetSheetObj, idx, 'free_dys|paid_day|free_dy_xcld_dys', 'N');    

		// [CHM-201431680] TES AGMT에서 minus rate 허용 (CGSLSL) (YSY B 4347-09-15)
		// [CHM-201431721] TES: Off-Dock CY_Semi Update시 tp/sz 오류 수정 저장 가능하도록 cntr_tpsz_cd 추가 (YSY B 4347-09-15) 
		setShtCellsEditable( targetSheetObj, idx, 'cntr_tpsz_cd|ovr_dys', 'Y',"EXCEPTION");
		setShtCellsEditable( targetSheetObj, idx, 'free_dys|paid_day|free_dy_xcld_dys', 'N', "EXCEPTION");
		
    }
}

/**
 * 
 * @param sheetObj
 */
function setCostCode2(sheetObj){
	if (sheetObj.CheckedRows("sel") < 1) {
		return;
	}
	var vvd_hidden     = sheetObjects[4];
//    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden);
	var targetSheetObj = sheetObjectsMap['t3sheet1']; 
	var idx;
	for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
		if( !sheetObj.CellValue(i,"sel")) continue;  
		idx = targetSheetObj.DataInsert(-1);
    	
		targetSheetObj.CellValue2(idx,"calc_tp_cd")      =  sheetObj.CellValue(i,"calc_tp_cd");       
		targetSheetObj.CellValue2(idx,"lgs_cost_cd")     =  sheetObj.CellValue(i,"lgs_cost_cd");      
		targetSheetObj.CellValue2(idx,"cntr_tpsz_cd")    =  sheetObj.CellValue(i,"cntr_tpsz_cd");     
//	    targetSheetObj.CellValue2(idx,"io_bnd_cd")       =  io_hidden;      

		if((sheetObj.CellValue(i,"dcgo_ind_cd"))=='ALL'){
			sheetObj.CellValue(i,"dcgo_ind_cd")='';
			targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd");
		}
	    
		if(sheetObj.CellValue(i,"lane_cd")=='Sam'){
			sheetObj.CellValue(i,"lane_cd")='';  
		}
		
		if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Same'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='S';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Mother'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='V';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Rail'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='R';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Truck'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='T';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Barge'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='B';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Other'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='O';
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Feeder'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='F';
		}
	    
		targetSheetObj.CellValue2(idx,"rc_flg")          =  sheetObj.CellValue(i,"rc_flg");           
		targetSheetObj.CellValue2(idx,"tml_wrk_dy_cd")   =  sheetObj.CellValue(i,"tml_wrk_dy_cd");    
		targetSheetObj.CellValue2(idx,"ioc_cd")          =  sheetObj.CellValue(i,"ioc_cd");       
		targetSheetObj.CellValue2(idx,"tml_trns_mod_cd") =  sheetObj.CellValue(i,"tml_trns_mod_cd");  
		targetSheetObj.CellValue2(idx,"lane_cd")         =  sheetObj.CellValue(i,"lane_cd");          
		targetSheetObj.CellValue2(idx,"tier")            =  sheetObj.CellValue(i,"tier");             
		targetSheetObj.CellValue2(idx,"calc_vol_qty")    =  sheetObj.CellValue(i,"calc_vol_qty");     
		targetSheetObj.CellValue2(idx,"rvis_vol_qty")    =  sheetObj.CellValue(i,"rvis_vol_qty");     
		targetSheetObj.CellValue2(idx,"stay_days")       =  sheetObj.CellValue(i,"stay_days");        
		targetSheetObj.CellValue2(idx,"vol_tr_ut_cd")    =  sheetObj.CellValue(i,"vol_tr_ut_cd");     
		targetSheetObj.CellValue2(idx,"ctrt_rt")         =  sheetObj.CellValue(i,"ctrt_rt");          
		targetSheetObj.CellValue2(idx,"inv_amt")         =  sheetObj.CellValue(i,"inv_amt");          
		targetSheetObj.CellValue2(idx,"curr_cd")         =  sheetObj.CellValue(i,"curr_cd");  
		targetSheetObj.CellValue2(idx,"tml_crr_cd")      = '';
		targetSheetObj.CellValue2(idx,'calc_cost_grp_cd') = 'TM';
		targetSheetObj.CellValue2(idx,'inv_xch_rt')       = sheetObj.CellValue(i,"inv_xch_rt");
		targetSheetObj.CellValue2(idx,'semi_auto_calc_flg') = 'Y';

		// 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
		targetSheetObj.CellValue2(idx, "tml_agmt_ofc_cty_cd")	= sheetObj.CellValue(i, "tml_agmt_ofc_cty_cd");      
		targetSheetObj.CellValue2(idx, "tml_agmt_seq")			= sheetObj.CellValue(i, "tml_agmt_seq");      
		targetSheetObj.CellValue2(idx, "tml_agmt_ver_no")		= sheetObj.CellValue(i, "tml_agmt_ver_no");     
		targetSheetObj.CellValue2(idx, "rmk_chk_flg")			= sheetObj.CellValue(i, "rmk_chk_flg");   

//        targetSheetObj.CellValue2(idx,'vsl_cd')           = vvd_hidden.CellValue(vvd_row, 'vvd_vsl_cd');
//        targetSheetObj.CellValue2(idx,'skd_voy_no')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_voy_no');
//        targetSheetObj.CellValue2(idx,'skd_dir_cd')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_dir_cd');
//        targetSheetObj.CellValue2(idx,'atb_dt')           = vvd_hidden.CellValue(vvd_row, 'vvd_atb_dt');
		
//    	setShtCellsEditable(targetSheetObj,idx,'lgs_cost_cd|rev_yrmon|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg','Y');
		// [CHM-201431680] TES AGMT에서 minus rate 허용 (CGSLSL) (YSY B 4347-09-15)
		// [CHM-201431721] TES: Off-Dock CY_Semi Update시 tp/sz 오류 수정 저장 가능하도록 cntr_tpsz_cd 추가 (YSY B 4347-09-15) 
		setShtCellsEditable( targetSheetObj, idx, 'cntr_tpsz_cd|rev_yrmon', 'Y', 'EXCEPTION');
    }
}

function checkLoginOfc(){	
	var formObj = document.form;
	
	if(formObj.chk_ofc_cd.value == "N"){
		if(ComShowConfirm(ComGetMsg('TES21053'))){  
			formObj.vndr_seq.focus();
			return;
		} else {
			ComShowMessage(ComGetMsg('TES21054'));
			setHeaderKeyValueReadonly('Y');
			
			return false;
		}
	} else {
		formObj.vndr_seq.focus();
	}
}
