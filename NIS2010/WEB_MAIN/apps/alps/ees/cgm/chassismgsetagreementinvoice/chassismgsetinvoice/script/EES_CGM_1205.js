/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1205.js
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.21 조경완 
* 1.0 Creation
* -------------------------------------------------------------
* history
* 2013.06.26 조경완 [CHM-201324911-01] ALPS-CHSS-COPS 기능 Trouble Shooting을 위한 CSR
* 2013.08.23 조경완 [CHM-201326006-01] ALPS-CHSS-COPS DUMMY YARD로 IN/Out된 CHSS의 로직 변경
* 2014-08-20 Chang Young Kim
*  [CHM-201431524] COPS Invoice Audit 시, Charge Creation때, File Import 추가 수정 건
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends 
	 * @class ees_cgm_1205 : ees_cgm_1205 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cgm_1205() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.loadPage				= loadPage;
		this.initSheet				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
		this.fn_actvOrInactvByInvTp	= fn_actvOrInactvByInvTp;
	}
	
  	/* 개발자 작업	*/



	// 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	tabLoad[2]= 0;
	tabLoad[3]= 0;
	
	// 각 Tab 별 Save 상태값 저장 (false:비활성,true:활성)	
	var TAB_SAVE_STD = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 최초조회 Boolean [fn_actvOrInactvByInvTp 참조]
//	var boolFirstSrch = false;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				
				case "btn_downExcel":
					
					/*
					 * 2015.04.09 [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
					 * Coincidence, Discrepancy, Invoice Only 3개탭을 동시에 ExcelDown 할수 있게~
					 * by Chang Young Kim, order 임동빈 부장
					 */
					
					// Boolean Confirm
					var bExcelDownFlg = false;
					
					// msgs['CGM20066'] = 'Do you want to {?msg1}?';
					bExcelDownFlg = ComShowCodeConfirm("CGM20066", "\n Confirm : [Coincidence, Discrepancy, Invoice Only]\n Cancel   : [Selected Tab]\nDownload Excel");
					
					if(bExcelDownFlg){ // User가 "Confirm" 선택
						// tabObjects[0].GetCount()-1 : 마지막 Tab(Min Commitment/MH Credit)은 ExcelDown 대상이 아님
						for(var idx=0; idx < tabObjects[0].GetCount()-1; idx++) {
							// Row가 있는 sheet만 ExcelDown
							if(sheetObjects[idx].RowCount > 0) {
								doActionIBSheet(sheetObjects[idx], formObject, "IBDOWNEXCELALL");
							}
						}
					} else { // User가 "Cancel" 선택
						doActionIBSheet(sheetObjects[tabObjects[0].SelectedIndex], formObject, "IBDOWNEXCEL");
					}
					
					break;
	
				case "btn_save":
					
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
					
					break;
					
				case "btn_remove":
					
					// IBDELETE : Concidence, Discrepancy, Invoice Only, Min Commitment/MH Credit 목록 지우기
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					
					break;
					
				case "btn_coin":
					// 1 : Discrepency, 2 : Invoice Only
					if(tabObjects[0].SelectedIndex == 1 || tabObjects[0].SelectedIndex == 2){
						
						var strCheckedRows = sheetObjects[tabObjects[0].SelectedIndex].FindCheckedRow("del_chk");
						var strStatusRows = sheetObjects[tabObjects[0].SelectedIndex].FindStatusRow("I|U");		 
						
						var arrCheckedRows = strCheckedRows.split("|"); // Check 된 Row 추출
						var arrStatusRows = strStatusRows.split(";");	// 상태가 입력(I,U) 인 상태인 Row 추출
						
						// 체크된 Row 가 없으면 메시지 출력 후 반환 
						if(strCheckedRows == ""){
							ComShowCodeMessage('CGM10008');
							return;
						}
						// Save 버튼을 클릭했는지 체크
						if(tabObjects[0].SelectedIndex == 1){
							// Discrepancy 행 추가 후 저장을 하지 않았을때 처리 하지 않도록..
							//if(TAB2_SAVE_STD){
							//	ComShowCodeMessage('CGM10026','Discrepancy');
							//	return;
							//}
						} else if(tabObjects[0].SelectedIndex == 2){
							// Invoice Only 행 추가 후 저장을 하지 않았을때 처리 하지 않도록..
							var tmpFindRows = sheetObjects[2].FindStatusRow('I');
							if(tmpFindRows != "")
							{
								ComShowCodeMessage('CGM10026','Invoice Only');
								return;
							}
						}
						
						var sColNms = "";
						
						// 이동시키려는 data name 을 설정
						if(tabObjects[0].SelectedIndex == 1){
							sColNms = sColNms + "ibflag|inv_no|agmt_no|inv_ref_no|eq_no|inv_cust_eq_no|eq_tpsz_cd|chg_cd|chg_seq|inv_eq_onh_loc_nm|";
							sColNms = sColNms + "inv_eq_onh_dt|inv_eq_offh_dt|inv_bil_st_dt|inv_bil_end_dt|inv_gate_act_id|inv_bil_mod_rmk|vndr_pay_chg_rmk|exempt|inv_lse_use_dys|";
							sColNms = sColNms + "vndr_pay_chg_cmt_ctnt|vndr_pay_chg_cr_sty_ctnt|vndr_pay_chg_cr_due_ctnt|inv_bil_ut_dys|inv_lse_rt_amt|inv_tax_rt_amt|inv_lse_chg_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_ttl_amt|";
							sColNms = sColNms + "lse_chg_aud_sts_cd|pay_lse_chg_sts_cd|lse_chg_aud_rslt_rsn_nm|eq_fm_mvmt_dt|eq_fm_yd_cd|eq_fm_mvmt_cd|";
							sColNms = sColNms + "eq_to_mvmt_dt|eq_to_yd_cd|eq_to_mvmt_cd|eq_mty_mvmt_dt|eq_mty_mvmt_yd_cd|eq_to_sc_no|eq_to_bkg_no|eq_to_bkg_term_cd|lse_use_dys|lse_bil_ut_dys|lse_rt_amt|";
							sColNms = sColNms + "lse_tax_rt_amt|lse_chg_amt|lse_tax_amt|lse_chg_ttl_amt|inv_sc_no|inv_bkg_no|inv_bkg_term_cd|diff_bil_ut|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|lse_chg_aud_rslt_rsn_cd|";
							sColNms = sColNms + "pay_lse_use_dys|pay_bil_ut_dys|pay_lse_rt_amt|pay_tax_rt_amt|pay_lse_chg_amt|pay_tax_amt|pay_lse_chg_ttl_amt|pay_cr_amt|cost_yrmon_seq|inv_eq_no";
						} else if(tabObjects[0].SelectedIndex == 2){
							sColNms = sColNms + "ibflag|inv_no|agmt_no|inv_ref_no|eq_no|inv_cust_eq_no|eq_tpsz_cd|chg_cd|chg_seq|inv_eq_onh_loc_nm|";
							sColNms = sColNms + "inv_eq_onh_dt|inv_eq_offh_dt|inv_bil_st_dt|inv_bil_end_dt|inv_gate_act_id|inv_bil_mod_rmk|vndr_pay_chg_rmk|exempt|inv_lse_use_dys|";
							sColNms = sColNms + "vndr_pay_chg_cmt_ctnt|vndr_pay_chg_cr_sty_ctnt|vndr_pay_chg_cr_due_ctnt|inv_bil_ut_dys|inv_lse_rt_amt|inv_tax_rt_amt|inv_lse_chg_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_ttl_amt|";
							sColNms = sColNms + "lse_chg_aud_sts_cd|pay_lse_chg_sts_cd|lse_chg_aud_rslt_rsn_nm|eq_fm_mvmt_dt|eq_fm_yd_cd|eq_fm_mvmt_cd|";
							sColNms = sColNms + "eq_to_mvmt_dt|eq_to_yd_cd|eq_to_mvmt_cd|eq_mty_mvmt_dt|eq_mty_mvmt_yd_cd|eq_to_sc_no|eq_to_bkg_no|eq_to_bkg_term_cd|lse_use_dys|lse_bil_ut_dys|lse_rt_amt|";
							sColNms = sColNms + "lse_tax_rt_amt|lse_chg_amt|lse_tax_amt|lse_chg_ttl_amt|inv_sc_no|inv_bkg_no|inv_bkg_term_cd|diff_bil_ut|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|lse_chg_aud_rslt_rsn_cd|";
							sColNms = sColNms + "pay_lse_use_dys|pay_bil_ut_dys|pay_lse_rt_amt|pay_tax_rt_amt|pay_lse_chg_amt|pay_tax_amt|pay_lse_chg_ttl_amt|pay_cr_amt|cost_yrmon_seq|inv_eq_no";						}
						
						// 선택한 Sheet의 데이터를 Concidency Sheet 로 이동
						var sXml = ComCgmMakeSearchXml(sheetObjects[tabObjects[0].SelectedIndex], "del_chk",sColNms, true);
						//기존 Start
						//sheetObjects[0].LoadSearchXml(sXml, true);
						//기존 End
							
						//chungpa 20100111 신규 start
						sheetObjects[5].removeAll();
						sheetObjects[5].LoadSearchXml(sXml, true);
						sheetObjects[5].Copy2SheetCol(
								sheetObjects[0]		//TargetSheet IBSheet 필수  붙여넣기 할 타겟 IBSheet 오브젝트 
								,""//sColNms //SrcColumns String 선택  복사할 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
								,"" //DestColumns String 선택  붙여넣을 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
								,-1 //StartRow Long 선택  복사할 대상시트의 시작 Row Index,Default=-1(데이터 첫행 의미)  
								,-1 //EndRow Long 선택  복사할 대상시트의 마지막 Row Index, Default=-1(데이터 마지막행 의미)  
								,-1 //DestRow Long 선택  붙여넣기대상Sheet의 시작 Row Index, Default=-1 
								,2 //AddType Long 선택  붙여넣기 유형, Default=0(overwrite)  1:insert 2:append 
								,true//useSameSaveName Boolean 선택  컬럼 매핑시 각 시트의 SaveName을 비교할지 여부, Default=false  
								,true//raiseChangeEvent Boolean 선택 OnChange Event를 발생할지 여부, Default=false 
								,""//SrcCheckCol Long / String 선택  복사Sheet에서 특정컬럼을 기준으로 체크된 행만 복사	// Default=""(모든 Row 의미)  
								,""///DestCheckCol Long / String 선택  붙여넣기대상Sheet에서 특정컬럼을 기준으로 체크된 행만 붙여넣는다., Default=""(모든 Row 의미) 

						);
						
						var tmpFindRows_C = sheetObjects[0].FindStatusRow('I');
						
						if(tmpFindRows_C != "")
						{
							var tVars_C = tmpFindRows_C.split(";");	// 상태가 입력(I) 인 상태인 Row 추출
							for(var i=0; i < tVars_C.length -1; i++){
								sheetObjects[0].RowStatus(tVars_C[i])= "U";		//3.트랜잭션 상태 "U"로 만들기
							}							
						}
						
						//chungpa 20100111 신규 end

						// Concidency 로 이동한 후 Save 버튼을 활성화
						TAB_SAVE_STD = true;
						doActionBtnEnable(tabObjects[0].SelectedIndex);	
						
						// Coincidence Tab의 하단 폼 값들을 세팅함
						fn_CoincidenceTabFormValue();

						// Descrepancy 탭을 선택 했을 경우
						if(tabObjects[0].SelectedIndex == 1){
							if(sheetObjects[1].RowCount > 0){
								var invLseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_ttl_amt|"),',',''));
								var lseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_ttl_amt|"),',',''));
								var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
								var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
								var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
								var lseTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_tax_amt|"),',',''));
								
								formObject.lse_chg_amt1.value = ComCgmAmountFormat(invLseChgAmtTtl, 2);
								formObject.inv_lse_chg_amt1.value = ComCgmAmountFormat(lseChgAmtTtl, 2);
								formObject.diff1.value = ComCgmAmountFormat(lseChgAmtTtl - invLseChgAmtTtl ,2);
								
								formObject.lse_chg_amt2.value = ComCgmAmountFormat(invLseChgAmt, 2);
								formObject.inv_lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt, 2);
								formObject.diff2.value = ComCgmAmountFormat(lseChgAmt - invLseChgAmt, 2);
								
								formObject.lse_chg_amt3.value = ComCgmAmountFormat(invTaxAmt, 2);
								formObject.inv_lse_chg_amt3.value = ComCgmAmountFormat(lseTaxAmt, 2);
								formObject.diff3.value = ComCgmAmountFormat(lseTaxAmt - invTaxAmt, 2);
							} else {
								formObject.lse_chg_amt1.value = '0.00';
								formObject.inv_lse_chg_amt1.value = '0.00';
								formObject.diff1.value = '0.00';
								
								formObject.lse_chg_amt2.value = '0.00';
								formObject.inv_lse_chg_amt2.value = '0.00';
								formObject.diff2.value = '0.00';
								
								formObject.lse_chg_amt3.value = '0.00';
								formObject.inv_lse_chg_amt3.value = '0.00';
								formObject.diff3.value = '0.00';
							}	
						
						// Invoice Only 탭을 선택했을 경우
						} else if(tabObjects[0].SelectedIndex == 2){
							
							if(sheetObjects[2].RowCount > 0){
								var invLseChgAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_lse_chg_amt|"),',',''));
								var invTaxAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_tax_amt|"),',',''));
								
								formObject.lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt,2);
								formObject.inv_lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt,2);
								formObject.inv_tax_amt4.value = ComCgmAmountFormat(invTaxAmt,2);
							} else {
								formObject.lse_chg_amt4.value = '0.00';
								formObject.inv_lse_chg_amt4.value = '0.00';
								formObject.inv_tax_amt4.value = '0.00';
							}
						}
						
						sheetObjects[tabObjects[0].SelectedIndex].CheckAll(1) = 0;	   //모두 선택 취소하기
					}
					else if(tabObjects[0].SelectedIndex == 3) {
						// Min Commitment/MH Credit 탭의 20, 40, 45 항목의 Monthly Payout Total 값이 있는지의 Count와 사이즈의 array
						var arrMPT = [];
						var strCoinVal = null; 
						// Coincidence Tab의 데이터 초기화
						sheetObject1.removeAll();
						
						for(idx = 0; idx < 3; idx++) {
							arrMPT[idx] = sheetObjects[3].CellValue(0, idx + 5).substring(0, 2);
							
							// Invoice Type이 Min. Commitment인 경우 
							if(formObject.parent_chss_cop_inv_tp_cd.value == "CMT") {
								// 13 Minimum Usage Fee란의 값이 0이 아닐 때 Coincidence탭에 해당 Size를 RowAdd 하고 Rate Sum 값으로 표시
								if(sheetObjects[3].CellValue(13, idx + 5) != 0) {
									doActionIBSheet(sheetObject1,formObject,IBINSERT);
									sheetObject1.CellValue2(sheetObject1.LastRow, "eq_tpsz_cd") = arrMPT[idx];
									sheetObject1.CellValue2(sheetObject1.LastRow, "inv_lse_chg_amt") = sheetObjects[3].CellValue(13, idx + 5);
									sheetObject1.CellValue2(sheetObject1.LastRow, "pay_lse_chg_amt") = sheetObjects[3].CellValue(13, idx + 5);
								}
							} 
							// Invoice Type이 MH Credit인 경우
							else if(formObject.parent_chss_cop_inv_tp_cd.value == "MCD") {
								// 17 MH Credit Total 값이 0이 아닐 때 Coincidence탭에 해당 Size를 RowAdd 하고 Rate Sum 값으로 표시
								if(sheetObjects[3].CellValue(17, idx + 5) != 0) {
									doActionIBSheet(sheetObject1,formObject,IBINSERT);
									sheetObject1.CellValue2(sheetObject1.LastRow, "eq_tpsz_cd") = arrMPT[idx];
									sheetObject1.CellValue2(sheetObject1.LastRow, "inv_lse_chg_amt") = sheetObjects[3].CellValue(17, idx + 5);
									sheetObject1.CellValue2(sheetObject1.LastRow, "pay_lse_chg_amt") = sheetObjects[3].CellValue(13, idx + 5);
								}
							}
						}
						
						// Coincidence 탭 선택
						tabObjects[0].SelectedIndex = 0;
						doActionBtnEnable(tabObjects[0].SelectedIndex);
						
						// Coincidence Tab의 하단 폼 값들을 세팅함
						fn_CoincidenceTabFormValue();
						
					}
					break;
					
				case "btn_coin_back":

					var strCheckedRows = sheetObjects[tabObjects[0].SelectedIndex].FindCheckedRow("del_chk");
					var strStatusRows = sheetObjects[tabObjects[0].SelectedIndex].FindStatusRow("I|U");		 
					
					var arrCheckedRows = strCheckedRows.split("|"); // Check 된 Row 추출
					var arrStatusRows = strStatusRows.split(";");	// 상태가 입력(I,U) 인 상태인 Row 추출

					// 체크된 Row 가 없으면 메시지 출력 후 반환 
					if(strCheckedRows == ""){
						ComShowCodeMessage('CGM10008');
						return;
					}

					for(var i = 0; i < arrCheckedRows.length-1 ; i++){   // modified by yongchan shin, 2014-03-19 (arrCheckedRows.length --> arrCheckedRows.length-1)
						if(sheetObjects[0].CellValue(arrCheckedRows[i], "lse_chg_aud_sts_cd") == ""){
							ComShowCodeMessage('CGM20049');
							sheetObjects[0].SelectCell(arrCheckedRows[i], "del_chk");
							return;
						}
					}	

					//--------------------
					// Sheet 이동
					//-------------------
					var sColNms = "";
					
					// 이동시키려는 data name 을 설정
					sColNms = sColNms + "ibflag|inv_no|agmt_no|inv_ref_no|eq_no|inv_cust_eq_no|eq_tpsz_cd|chg_cd|chg_seq|inv_eq_onh_loc_nm|";
					sColNms = sColNms + "inv_eq_onh_dt|inv_eq_offh_dt|inv_bil_st_dt|inv_bil_end_dt|inv_gate_act_id|inv_bil_mod_rmk|vndr_pay_chg_rmk|exempt|inv_lse_use_dys|";
					sColNms = sColNms + "vndr_pay_chg_cmt_ctnt|vndr_pay_chg_cr_sty_ctnt|vndr_pay_chg_cr_due_ctnt|inv_bil_ut_dys|inv_lse_rt_amt|inv_tax_rt_amt|inv_lse_chg_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_ttl_amt|";
					sColNms = sColNms + "lse_chg_aud_sts_cd|pay_lse_chg_sts_cd|lse_chg_aud_rslt_rsn_nm|eq_fm_mvmt_dt|eq_fm_yd_cd|eq_fm_mvmt_cd|";
					sColNms = sColNms + "eq_to_mvmt_dt|eq_to_yd_cd|eq_to_mvmt_cd|eq_mty_mvmt_dt|eq_mty_mvmt_yd_cd|eq_to_sc_no|eq_to_bkg_no|eq_to_bkg_term_cd|lse_use_dys|lse_bil_ut_dys|lse_rt_amt|";
					sColNms = sColNms + "lse_tax_rt_amt|lse_chg_amt|lse_tax_amt|lse_chg_ttl_amt|inv_sc_no|inv_bkg_no|inv_bkg_term_cd|diff_bil_ut|";
					sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|lse_chg_aud_rslt_rsn_cd|";
					sColNms = sColNms + "pay_lse_use_dys|pay_bil_ut_dys|pay_lse_rt_amt|pay_tax_rt_amt|pay_lse_chg_amt|pay_tax_amt|pay_lse_chg_ttl_amt|pay_cr_amt|cost_yrmon_seq|inv_eq_no";					
					
					var sXml = ComCgmMakeSearchXml2(sheetObjects[0], "del_chk",sColNms, true, 'D');
					

					//기존 Start
					//sheetObjects[1].LoadSearchXml(sXml, true);
					//기존 End
					//chungpa 20100111 신규 start
					
					sheetObjects[6].removeAll();
					sheetObjects[6].LoadSearchXml(sXml, true);
					sheetObjects[6].Copy2SheetCol(
							sheetObjects[1]		//TargetSheet IBSheet 필수  붙여넣기 할 타겟 IBSheet 오브젝트 
							,""//sColNms //SrcColumns String 선택  복사할 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
							,"" //DestColumns String 선택  붙여넣을 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
							,-1 //StartRow Long 선택  복사할 대상시트의 시작 Row Index,Default=-1(데이터 첫행 의미)  
							,-1 //EndRow Long 선택  복사할 대상시트의 마지막 Row Index, Default=-1(데이터 마지막행 의미)  
							,-1 //DestRow Long 선택  붙여넣기대상Sheet의 시작 Row Index, Default=-1 
							,2 //AddType Long 선택  붙여넣기 유형, Default=0(overwrite)  1:insert 2:append 
							,true//useSameSaveName Boolean 선택  컬럼 매핑시 각 시트의 SaveName을 비교할지 여부, Default=false  
							,false//raiseChangeEvent Boolean 선택 OnChange Event를 발생할지 여부, Default=false 
							,""//SrcCheckCol Long / String 선택  복사Sheet에서 특정컬럼을 기준으로 체크된 행만 복사	// Default=""(모든 Row 의미)  
							,""///DestCheckCol Long / String 선택  붙여넣기대상Sheet에서 특정컬럼을 기준으로 체크된 행만 붙여넣는다., Default=""(모든 Row 의미) 
					
					);	
										
					//chungpa 20100111 신규 end

					var sXml2 = ComCgmMakeSearchXml2(sheetObjects[0], "del_chk",sColNms, true, 'I');
					
					//chungpa 20100111 신규 start
					sheetObjects[7].removeAll();
					sheetObjects[7].LoadSearchXml(sXml2, true);
					sheetObjects[7].Copy2SheetCol(
							sheetObjects[2]		//TargetSheet IBSheet 필수  붙여넣기 할 타겟 IBSheet 오브젝트 
							,""//sColNms //SrcColumns String 선택  복사할 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
							,"" //DestColumns String 선택  붙여넣을 대상 컬럼의 Index 또는 SaveName을 "|"로 연결한 문자열, Default=""(전체컬럼을 의미) 
							,-1 //StartRow Long 선택  복사할 대상시트의 시작 Row Index,Default=-1(데이터 첫행 의미)  
							,-1 //EndRow Long 선택  복사할 대상시트의 마지막 Row Index, Default=-1(데이터 마지막행 의미)  
							,-1 //DestRow Long 선택  붙여넣기대상Sheet의 시작 Row Index, Default=-1 
							,2 //AddType Long 선택  붙여넣기 유형, Default=0(overwrite)  1:insert 2:append 
							,true//useSameSaveName Boolean 선택  컬럼 매핑시 각 시트의 SaveName을 비교할지 여부, Default=false  
							,false//raiseChangeEvent Boolean 선택 OnChange Event를 발생할지 여부, Default=false 
							,""//SrcCheckCol Long / String 선택  복사Sheet에서 특정컬럼을 기준으로 체크된 행만 복사	// Default=""(모든 Row 의미)  
							,""///DestCheckCol Long / String 선택  붙여넣기대상Sheet에서 특정컬럼을 기준으로 체크된 행만 붙여넣는다., Default=""(모든 Row 의미) 
						
					);
					
					var tmpFindRows1 = sheetObjects[1].FindStatusRow('I');
					if(tmpFindRows1 != "")
					{
						var tVars1 = tmpFindRows1.split(";");	// 상태가 입력(I) 인 상태인 Row 추출
						for(var i=0; i < tVars1.length -1; i++){
							sheetObjects[1].RowStatus(tVars1[i])= "U";		//3.트랜잭션 상태 "U"로 만들기
						}							
					}
					
					var tmpFindRows = sheetObjects[2].FindStatusRow('I');
					if(tmpFindRows != "")
					{
						var tVars = tmpFindRows.split(";");	// 상태가 입력(I) 인 상태인 Row 추출
						for(var i=0; i < tVars.length -1; i++){
							//sheetObjects[2].cellValue2(tVars[i],"ibflag") = "U";
							sheetObjects[2].RowStatus(tVars[i])= "U";		//3.트랜잭션 상태 "U"로 만들기
						}							
					}
					// chungpa 20100126 Invoice Only 가 'U'로 보이나 'I'로 처리되는 오동작 패치 end
					
					//chungpa 20100111 신규 end
					// Discrepancy, Invoice Only 로 이동한 후 Save 버튼을 활성화
					TAB_SAVE_STD = true;
					doActionBtnEnable(tabObjects[0].SelectedIndex);	
					
					//--------------------
					// 계산식
					//-------------------
					// Considency Tab
					if(sheetObjects[0].RowCount > 0){
						var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
						var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
						var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
						var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

						formObject.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
						formObject.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
						formObject.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
						formObject.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
						
					} else {
						formObject.inv_smry_amt.value = '0.00';  
						formObject.pay_chg_smry_amt.value = '0.00';
						formObject.tax_smry_amt.value = '0.00';
						formObject.cr_smry_amt.value = '0.00';
					}
					
					// Discrepancy Tab
					if(sheetObjects[1].RowCount > 0){
						var invLseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_ttl_amt|"),',',''));
						var lseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_ttl_amt|"),',',''));
						var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
						var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
						var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
						var lseTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_tax_amt|"),',',''));
						
						formObject.lse_chg_amt1.value = ComCgmAmountFormat(invLseChgAmtTtl, 2);
						formObject.inv_lse_chg_amt1.value = ComCgmAmountFormat(lseChgAmtTtl, 2);
						formObject.diff1.value = ComCgmAmountFormat(lseChgAmtTtl - invLseChgAmtTtl ,2);
						
						formObject.lse_chg_amt2.value = ComCgmAmountFormat(invLseChgAmt, 2);
						formObject.inv_lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt, 2);
						formObject.diff2.value = ComCgmAmountFormat(lseChgAmt - invLseChgAmt, 2);
						
						formObject.lse_chg_amt3.value = ComCgmAmountFormat(invTaxAmt, 2);
						formObject.inv_lse_chg_amt3.value = ComCgmAmountFormat(lseTaxAmt, 2);
						formObject.diff3.value = ComCgmAmountFormat(lseTaxAmt - invTaxAmt, 2);
					} else {
						formObject.lse_chg_amt1.value = '0.00';
						formObject.inv_lse_chg_amt1.value = '0.00';
						formObject.diff1.value = '0.00';
						
						formObject.lse_chg_amt2.value = '0.00';
						formObject.inv_lse_chg_amt2.value = '0.00';
						formObject.diff2.value = '0.00';
						
						formObject.lse_chg_amt3.value = '0.00';
						formObject.inv_lse_chg_amt3.value = '0.00';
						formObject.diff3.value = '0.00';
					}	
					
					// Invoice Only Tab
					if(sheetObjects[2].RowCount > 0){
						var invLseChgAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_lse_chg_amt|"),',',''));
						var invTaxAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_tax_amt|"),',',''));
						
						formObject.lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt,2);
						formObject.inv_lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt,2);
						formObject.inv_tax_amt4.value = ComCgmAmountFormat(invTaxAmt,2);
					} else {
						formObject.lse_chg_amt4.value = '0.00';
						formObject.inv_lse_chg_amt4.value = '0.00';
						formObject.inv_tax_amt4.value = '0.00';
					}
					sheetObjects[tabObjects[0].SelectedIndex].CheckAll(1) = 0;	   //모두 선택 취소하기
					
					//전체 Save 한 후 Lessor Only 로 Back 한 Data 는 Add 된 Row 더라도 수정/삭제 가능하도록
					//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
					t1sheet1_enableEditingWhenLseChgAudStsCdIsNull();
					//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.	
					break;
	
				case "btn_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
	
				case "btn_delete":
					doActionIBSheet(sheetObject1,formObject,IBRESET);
					break;
		
				case "btn_soCreate":
					if(validateForm(sheetObject3,formObject,IBCREATE) != false) {
						if(TAB_SAVE_STD){
							//msgs['CGM10079'] = "Please save the date first.";
							ComShowCodeMessage('CGM10079');
							return;
						}
						
						doActionIBSheet(sheetObject1,formObject,IBCREATE);
					}
					break;
					
				case "btns_inv_dt":
					var cal = new ComCalendar();
					cal.select(formObject.inv_dt, "yyyy-MM-dd");
					break;
					
				case "btn_Close":
					window.close();
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){

		sheetObjects[sheetCnt++] = sheet_obj;

	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {

		// 이벤트 등록
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
		 
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		
		}
		
		for(k=0;k<tabObjects.length;k++){

			initTab(tabObjects[k],k+1);
		}
		
		// 현재 날짜 가져오기
		var sysDate   = new Date();
		var year = sysDate.getFullYear();
		var month = sysDate.getMonth()+1;
		var date = sysDate.getDate();

		var today = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");
		
		// 오늘 날짜 설정 (Issue Date)
		document.form.inv_dt.value = today;
		
		// vendor Name 가져오기
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

		// 각 Tab 별 Save 상태값 저장 (false:비활성,true:활성)
		TAB_SAVE_STD = false;
		
		// 버튼 활성/비활성화  초기화
		doActionBtnEnable(tabObjects[0].SelectedIndex);
		
		// IBSEARCH			: Concidence, Discrepancy, Invoice Only 목록 가져오기
		// IBSEARCH_ASYNC04	: Min Commitment/MH Credit 목록 가져오기
//		if(boolFirstSrch) {
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		} else {
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC04);
//		}
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch(sheetID) {

			case "t1sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);

					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 2;
				}
				break;

			// Coin, Back 기능 수행에 필요(중요)								
			case "t1sheet1_tmp":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
				  //데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);
					
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 2;
				}
				break;
				
			case "t2sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 302;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);
					
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 2;
				}
				break;

			// Coin, Back 기능 수행에 필요(중요)				
			case "t2sheet1_tmp":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);
					
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 2;
				}
				break;
				
//			case "t3sheet1":
//				with (sheetObj) {
//					// 높이 설정
//					style.height = 292;
//					//전체 너비 설정
//					SheetWidth = mainTable.clientWidth;
//
//					//Host정보 설정[필수][HostIp, Port, PagePath]
//					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//					//전체Merge 종류 [선택, Default msNone]
//					MergeSheet = msHeaderOnly;
//
//					//전체Edit 허용 여부 [선택, Default false]
//					Editable = true;
//
//					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//					InitRowInfo(1, 1, 3, 100);
//
//					var HeadTitle1 = "|Seq.|Chassis No.|Agreement No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Off-Hire\nLoc.|Off-Hire\nDate";
//					HeadTitle1 += "|Used days|Rate|Charge\nTotal|Status|Event Date|";
//
//					var headCount = ComCountHeadTitle(HeadTitle1);
//
//					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//					InitColumnInfo(headCount, 0, 0, true);
//
//					// 해더에서 처리할 수 있는 각종 기능을 설정한다
//					InitHeadMode(true, true, true, true, false,false)
//
//					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//					InitHeadRow(0, HeadTitle1, true);
//
//					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, true,   "ibflag");
//					InitDataProperty(0, cnt++ , dtDataSeq, 	30,	daCenter, true, "seq");
//					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true,	"eq_no",  			  false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true,	"agmt_no",			  false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"eq_tpsz_cd", 	  	  false, "", dfNone,	0, false, false);
//
//					InitDataProperty(0, cnt++ , dtData,45,	daCenter, true,	"lse_chg_aud_sts_cd", false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,50,	daCenter, true,	"chg_cd", 			  false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd",	  false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt", 		  false, "", dfDateYmd, 0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd",	 false, "", dfNone,	0, false, false);
//
//					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt",		  false, "", dfDateYmd, 0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"lse_use_dys",		false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",  	  false, "", dfFloat,	2, false, false);
//					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",  	  false, "", dfFloat,	2, false, false);
//
//					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"eq_aset_sts_cd",	  false, "", dfNone,	0, false, false);
//					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"sts_evnt_dt",  	  false, "", dfDateYmd, 0, false, false);
//
//					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter,	true, "chg_seq");
//					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
//					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");
//
//					WordWrap = true;
//					CountPosition = 0;
//				}
//				break;

			case "t4sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 302;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
						
					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);
					
					//InitDataCombo(0, "chg_cd", "CRD|TAX|PDM|RTL", "CRD|TAX|PDM|RTL"
					//		,'','',0,'','',"CRD|TAX|PDM");
		
					WordWrap = true;
					CountPosition = 2;
				}
				break; 

			// Coin, Back 기능 수행에 필요(중요)	
			case "t4sheet1_tmp":  
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
						
					var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
					HeadTitle1 += "|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result|Audit Result";
					HeadTitle1 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var HeadTitle2 = "||Seq.|Invoice No.|AGMT No.|Ref No.|Chassis No.|Container No.|Size|Charge Type|Charge Seq.|On-Hire Loc.|On-Hire Date|Off-Hire Date|Billing Start Date|Billing End Date|Gate Activity ID|Bill To Mode|Vendor\nRemarks|Exempt|Used Days|Vendor\nComments|Credit\nStyle|Credit\nDue|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|Credit|TTL AMT";
					HeadTitle2 += "|Origin\nAudit\nResult|Final\nAudit\nResult|Audit Reason|Audit Detail|FM Date|FM Yard|FM MVMT|TO Date|TO Yard|TO MVMT|Empty Date|Empty Yard|To S/C No.|To BKG No.|To BKG Term|Used Days|Bill Days|Rate|Tax(%)|Rate Sum|Tax Sum|TTL AMT|SC No.|BKG No.|BKG Term|Diff Bill Days";
					HeadTitle2 += "|Agreement Office City Code|Agreement Seq.|Agreement Version No.|Lease Charge Audit Result Reason Code|Payable Lease Use Days|Payable Bill Unit Days|Payable Lease Rate Amt.|Payable Tax Rate Amt.|Payable Lease Charge Amt.|Payable Tax Amt.|Payable Lease Charge Total Amt.|Payable Credit Amt.|Cost Year Month Seq.|Invoice Eq No.";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true, "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,	daCenter,	false,"del_chk",false, "", dfNone,	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,		30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_no",						false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "agmt_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_ref_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_no",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			90, daCenter,	true, "inv_cust_eq_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "eq_tpsz_cd",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "chg_cd",						false, "", dfNone,		0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "chg_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,	true, "inv_eq_onh_loc_nm",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_onh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_eq_offh_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_st_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_bil_end_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_gate_act_id",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "inv_bil_mod_rmk",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			160,daCenter,	true, "vndr_pay_chg_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "exempt",						false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_lse_use_dys",			false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 시작
					InitDataProperty(0, cnt++ , dtData,			120, daCenter,	true, "vndr_pay_chg_cmt_ctnt",		false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_sty_ctnt",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "vndr_pay_chg_cr_due_ctnt",	false, "", dfNone,		0, false, false);
					// [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정 끝
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "inv_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_rt_amt",				false, "", dfFloat,		3, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_tax_amt",				false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "inv_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "lse_chg_aud_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			45, daCenter,	true, "pay_lse_chg_sts_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			150,daCenter,	true, "lse_chg_aud_rslt_rsn_nm",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true, "pay_chg_aud_rmk",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_fm_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_fm_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_mvmt_dt",				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_yd_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			55, daCenter,	true, "eq_to_mvmt_cd",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_dt",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_mty_mvmt_yd_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "eq_to_sc_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "eq_to_bkg_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "eq_to_bkg_term_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_use_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			70, daCenter,	true, "lse_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_rt_amt",					false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			50, daCenter,	true, "lse_chg_ttl_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "inv_sc_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			95, daCenter,	true, "inv_bkg_no",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true, "inv_bkg_term_cd",			false, "", dfNone,		0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true, "diff_bil_ut",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ofc_cty_cd",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_seq",					false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		80, daCenter,	true, "agmt_ver_no",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true, "lse_chg_aud_rslt_rsn_cd",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_lse_use_dys",			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "pay_bil_ut_dys",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_rt_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_rt_amt",				false, "", dfFloat,		3, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_amt",			false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_tax_amt",				false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_lse_chg_ttl_amt",		false, "", dfFloat,		2, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "pay_cr_amt",					false, "", dfFloat,		2, false, true);
					InitDataProperty(0, cnt++ , dtHidden,		50, daCenter,	true, "cost_yrmon_seq",				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,		70, daCenter,	true, "inv_eq_no",					false, "", dfNone,		0, false, false);

					
					WordWrap = true;
					CountPosition = 2;
				}
				break;
				
			case "sheet":	// Hidden Sheet
				with (sheetObj) {
					// 높이 설정
					style.height = 202;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
						
					var HeadTitle1 = "";
						
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOL	TIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter,	true, "ibflag");
				}
			
				break;
			
			// Min Commitment/MH Credit
			case "t5sheet1":  
				with (sheetObj) {
					// 높이 설정
					style.height = 402;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
						
					var HeadTitle = "Stat|No.|Item Code|Item|Item|20'|40'|45'|||||";
								
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					// ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
					InitHeadMode(false, false, false, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
						
					//데이터속성	[ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,                   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daRight,	true,		"seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		"cmmt_cr_cd",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"intg_cd_val_dp_desc",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		true,		"intg_cd_val_desc",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			136,	daRight,	true,		"cmmt_20ft_amt",			false,		"",			dfFloat,	2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			136,	daRight,	true,		"cmmt_40ft_amt",			false,		"",			dfFloat,	2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			136,	daRight,	true,		"cmmt_45ft_amt",			false,		"",			dfFloat,	2,			false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"agmt_ofc_cty_cd",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"agmt_seq",					false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"agmt_ver_no",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"cost_yrmon",				false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"cost_yrmon_seq",			false,		"",			dfNone,		0,			false,		false);
					
					WordWrap = true;
					CountPosition = 0;
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		// ExcelDown시 Tab name
		var sTabCaption = null;
		
		switch(sheetObj.id) {
		case "t1sheet1":
			sTabCaption = "Coincidence";
			break;
			
		case "t2sheet1":
			sTabCaption = "Discrepancy";
			break;
			
		case "t4sheet1":
			sTabCaption = "Invoice Only";
			break;
		}
		
		switch(sAction) {
			case IBSEARCH:		//조회 [Coincidence, Discrepancy, Invoice Only]
				
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
						 
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
//				prompt("IBSEARCH", FormQueryString(formObj)); ComOpenWait(false); return;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1205GS.do" , FormQueryString(formObj), '', true);
				var arrXml = sXml.split("|$$|");
				
				// tab1 Sheet Object
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				
				if(sheetObjects[0].RowCount > 0){
					var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
					var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
					var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
					var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

					formObj.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
					formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
					formObj.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
					formObj.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
					
					// chungpa 20100105 back error fix start
					/*
					 * 2015.04.08 [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
					 * Coincidence탭의 Original Audit Result(lse_chg_aud_sts_cd)가 "C"인 데이터를 Invoice Only탭으로 옮길 수 있게~
					 * by Chang Young Kim, order 임동빈 부장
					 */ 
					for(var i=2; i<2+sheetObjects[0].RowCount; i++)
					{
						if(sheetObjects[0].CellValue(i,"lse_chg_aud_sts_cd") == "C") //C만 고정.
							sheetObjects[0].CellEditable(i, "del_chk") = false;
					}
					
				} else {
					formObj.inv_smry_amt.value = '0.00';  
					formObj.pay_chg_smry_amt.value = '0.00';
					formObj.tax_smry_amt.value = '0.00';
					formObj.cr_smry_amt.value = '0.00';
				}
				
				// tab2 Sheet Object
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				
				if(sheetObjects[1].RowCount > 0){
					var invLseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_ttl_amt|"),',',''));
					var lseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_ttl_amt|"),',',''));
					var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
					var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
					var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
					var lseTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_tax_amt|"),',',''));
					
					formObj.lse_chg_amt1.value = ComCgmAmountFormat(invLseChgAmtTtl, 2);
					formObj.inv_lse_chg_amt1.value = ComCgmAmountFormat(lseChgAmtTtl, 2);
					formObj.diff1.value = ComCgmAmountFormat(lseChgAmtTtl - invLseChgAmtTtl ,2);
					
					formObj.lse_chg_amt2.value = ComCgmAmountFormat(invLseChgAmt, 2);
					formObj.inv_lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt, 2);
					formObj.diff2.value = ComCgmAmountFormat(lseChgAmt - invLseChgAmt, 2);
					
					formObj.lse_chg_amt3.value = ComCgmAmountFormat(invTaxAmt, 2);
					formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(lseTaxAmt, 2);
					formObj.diff3.value = ComCgmAmountFormat(lseTaxAmt - invTaxAmt, 2);
				} else {
					formObj.lse_chg_amt1.value = '0.00';
					formObj.inv_lse_chg_amt1.value = '0.00';
					formObj.diff1.value = '0.00';
					
					formObj.lse_chg_amt2.value = '0.00';
					formObj.inv_lse_chg_amt2.value = '0.00';
					formObj.diff2.value = '0.00';
					
					formObj.lse_chg_amt3.value = '0.00';
					formObj.inv_lse_chg_amt3.value = '0.00';
					formObj.diff3.value = '0.00';
				}

				sheetObjects[2].LoadSearchXml(arrXml[2]);
				
				if(sheetObjects[2].RowCount > 0){
					var invLseChgAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_lse_chg_amt|"),',',''));
					var invTaxAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_tax_amt|"),',',''));
					
					formObj.lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt,2);
					formObj.inv_lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt,2);
					formObj.inv_tax_amt4.value = ComCgmAmountFormat(invTaxAmt,2);
				} else {
					formObj.lse_chg_amt4.value = '0.00';
					formObj.inv_lse_chg_amt4.value = '0.00';
					formObj.inv_tax_amt4.value = '0.00';
				}
				
				if(!ComIsEmpty(arrXml[3])){
					sheetObjects[3].LoadSearchXml(arrXml[3]);
				}
				
				ComOpenWait(false);
				
				//Save하고 난 이후에도 lse_chg_aud_sts_cd가 null인 경우에는 편집 가능하게 설정한다. 
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				t1sheet1_enableEditingWhenLseChgAudStsCdIsNull();
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.	
				
				break;
				
			// 2014.09.15 Chang Young Kim [CHM-201431710] [S]
			case IBSEARCH_ASYNC04:		//조회 [Min Commitment/MH Credit]
				
				formObj.f_cmd.value = SEARCH04;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
						 
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
//				prompt("IBSEARCH_ASYNC04", FormQueryString(formObj)); ComOpenWait(false); return;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1205GS.do" , FormQueryString(formObj), '', true);
				
				// tab4 Sheet Object
				sheetObj.LoadSearchXml(sXml);
				
				ComOpenWait(false);
				
				break;
				
			case IBSEARCH_ASYNC05:		//저장 [Min Commitment/MH Credit]
				
				formObj.f_cmd.value = MULTI03;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				
				var sParam = "";
				var sParam4 = sheetObj.GetSaveString(false);
				
				sParam = sParam + ComSetPrifix(sParam4, "t5sheet1");
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
//				prompt("IBSEARCH_ASYNC05", sParam); ComOpenWait(false); return;
				var sXml = sheetObj.GetSaveXml("EES_CGM_1205GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
				
				ComOpenWait(false);	
				
				break;
			// 2014.09.15 Chang Young Kim [CHM-201431710] [E]
				
			case IBSAVE:		//저장
				
				formObj.f_cmd.value = MULTI01;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			
				var strStatusRow = "";
				var sParam = "";
				
				strStatusRow = sheetObjects[0].FindStatusRow("I|U");
				
				var sParam1 = sheetObjects[0].GetSaveString(false); 
				sParam = sParam + ComSetPrifix(sParam1, "t1sheet1");
				sParam = sParam + "&";
//				prompt("1", sParam); return;
				var sParam2 = sheetObjects[1].GetSaveString(false);
				sParam = sParam + ComSetPrifix(sParam2, "t2sheet1");
				sParam = sParam + "&";
				
				var sParam3 = sheetObjects[2].GetSaveString(false);
				sParam = sParam + ComSetPrifix(sParam3, "t4sheet1");
				
				// CMT : Min Commitment, MCD : MH Credit
				if(formObj.parent_chss_cop_inv_tp_cd.value == "CMT" || 
						formObj.parent_chss_cop_inv_tp_cd.value == "MCD") {
					var sParam4 = sheetObjects[3].GetSaveString(false);
					sParam = sParam + ComSetPrifix(sParam4, "t5sheet1");
				}
				
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);		
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1205GS.do", sParam);
				
				sheetObjects[0].LoadSaveXml(sXml);

				ComOpenWait(false);

				t1sheet1_enableEditingWhenLseChgAudStsCdIsNull();
				
				break;
				
			case IBCREATE:		// Payable Amount Confirm
				formObj.f_cmd.value = MULTI02;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				
				var sParam = sheetObjects[0].GetSaveString(false);
				//var sParam = ComCgmGetAllSaveText(sheetObjects[0], true);
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
				var strStatusRow = sheetObjects[0].FindStatusRow("I|U");

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
				var sXml = sheetObjects[0].GetSaveXml("EES_CGM_1205GS.do", sParam);
				sheetObjects[0].LoadSaveXml(sXml);
				
				ComOpenWait(false);	
				
				if(strStatusRow != ''){
					var arrStatusRow = strStatusRow.split(';');
					for(var i=0; i < arrStatusRow.length -1; i++){
						sheetObjects[0].cellValue2(arrStatusRow[i],"ibflag") = "I";
//						sheetObjects[0].CellEditable(arrStatusRow[i],"pay_chg_aud_rmk") = true;
					}	
				}
				
				formObj.lse_chg_sts_cd.value = 'S';
				doActionBtnEnable(tabObjects[0].SelectedIndex);
				
				break;
				
			case IBDELETE:
				formObj.f_cmd.value = REMOVE;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
//				prompt('Min Commitment/MH Credit Delete', FormQueryString(formObj)); ComOpenWait(0); return;
				var sXml = sheetObjects[0].GetSaveXml("EES_CGM_1205GS.do", FormQueryString(formObj));
					
				var arrXml = sXml.split("|$$|");
				
				// tab1 Sheet Object
				//sheetObjects[4].LoadSaveXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");	// Hidden Sheet 를 사용하기 위해 
				sheetObjects[0].LoadSaveXml(arrXml[0]);
				
				if(sheetObjects[0].RowCount > 0){
					var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
					var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
					var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
					var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

					formObj.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
					formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
					formObj.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
					formObj.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
					
				} else {
					formObj.inv_smry_amt.value = '0.00';  
					formObj.pay_chg_smry_amt.value = '0.00';
					formObj.tax_smry_amt.value = '0.00';
					formObj.cr_smry_amt.value = '0.00';
				}
				
				// tab2 Sheet Object
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				
				if(sheetObjects[1].RowCount > 0){
					var invLseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_ttl_amt|"),',',''));
					var lseChgAmtTtl = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_ttl_amt|"),',',''));
					var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
					var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
					var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
					var lseTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_tax_amt|"),',',''));
					
					formObj.lse_chg_amt1.value = ComCgmAmountFormat(invLseChgAmtTtl, 2);
					formObj.inv_lse_chg_amt1.value = ComCgmAmountFormat(lseChgAmtTtl, 2);
					formObj.diff1.value = ComCgmAmountFormat(lseChgAmtTtl - invLseChgAmtTtl ,2);
					
					formObj.lse_chg_amt2.value = ComCgmAmountFormat(invLseChgAmt, 2);
					formObj.inv_lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt, 2);
					formObj.diff2.value = ComCgmAmountFormat(lseChgAmt - invLseChgAmt, 2);
					
					formObj.lse_chg_amt3.value = ComCgmAmountFormat(invTaxAmt, 2);
					formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(lseTaxAmt, 2);
					formObj.diff3.value = ComCgmAmountFormat(lseTaxAmt - invTaxAmt, 2);
				} else {
					formObj.lse_chg_amt1.value = '0.00';
					formObj.inv_lse_chg_amt1.value = '0.00';
					formObj.diff1.value = '0.00';
					
					formObj.lse_chg_amt2.value = '0.00';
					formObj.inv_lse_chg_amt2.value = '0.00';
					formObj.diff2.value = '0.00';
					
					formObj.lse_chg_amt3.value = '0.00';
					formObj.inv_lse_chg_amt3.value = '0.00';
					formObj.diff3.value = '0.00';
				}		

				sheetObjects[2].LoadSearchXml(arrXml[2]);
				
				if(sheetObjects[2].RowCount > 0){
					var invLseChgAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_lse_chg_amt|"),',',''));
					var invTaxAmt = Number(ComReplaceStr(sheetObjects[2].ComputeSum("|inv_tax_amt|"),',',''));
					
					formObj.lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt,2);
					formObj.inv_lse_chg_amt4.value = ComCgmAmountFormat(invLseChgAmt,2);
					formObj.inv_tax_amt4.value = ComCgmAmountFormat(invTaxAmt,2);
				} else {
					formObj.lse_chg_amt4.value = '0.00';
					formObj.inv_lse_chg_amt4.value = '0.00';
					formObj.inv_tax_amt4.value = '0.00';
				}
				
				if(formObj.parent_chss_cop_inv_tp_cd.value == "CMT" || 
						formObj.parent_chss_cop_inv_tp_cd.value == "MCD") {
					sheetObjects[3].LoadSearchXml(arrXml[3]);
				}
					
				ComOpenWait(false);	
				
				
				break;
				
			case IBINSERT:	  // 행추가
				var newRow = sheetObj.DataInsert(-1);
				/*실시간 combobox 적용 start*/
				sheetObj.InitCellProperty(newRow,"chg_cd",dtComboEdit);
				fn_comboSetting(sheetObj, newRow, "chg_cd", formObj.parent_chss_cop_inv_tp_cd.value);
				/*실시간 combobox 적용 end*/
				
				//cost_yrmon_seq value setting 
				sheetObj.cellValue2(newRow, "cost_yrmon_seq")	= document.form.parent_cost_yrmon_seq.value;
				sheetObj.cellValue2(newRow, "agmt_no")			= document.form.parent_agmt_ofc_cty_cd.value + document.form.parent_agmt_seq.value;
				sheetObj.cellValue2(newRow, "inv_ref_no")		= document.form.parent_agmt_ref_no.value;
				sheetObj.cellValue2(newRow, "inv_no")			= document.form.parent_inv_no.value;
				/* 2014.08.04 Chang Young Kim Added In accordance with the "미확정 CHM" (S) */
				sheetObj.cellValue2(newRow, "agmt_ofc_cty_cd")	= document.form.parent_agmt_ofc_cty_cd.value;
				sheetObj.cellValue2(newRow, "agmt_seq")			= document.form.parent_agmt_seq.value;
				sheetObj.cellValue2(newRow, "agmt_ver_no")		= document.form.parent_agmt_ver_no.value;
				/* 2014.08.04 Chang Young Kim Added In accordance with the "미확정 CHM" (E) */
				
				// Invoice Only 의 Charge Type 에 따라 입력항목 활성/비활성 설정
				/*
				1. ROW ADD
 					1) PDM,ONT
 					   Rate Sum,Tax Sum,TTL Amt - 3개만 입력가능
					   샤시, 컨테이너 번호 입력가능하게 풀어줌.
 					2) CRD	   
 					   Credit 만 입력 가능
 					3) TAX	   
 					   TAX	만 입력 가능
				*/
				/*
				 * t1sheet1_OnChange로 이동시킴 2015.02.16 Chang Young Kim 
				sheetObj.CellEditable(newRow, "eq_no") = false;		
				
				sheetObj.CellEditable(newRow, "inv_lse_rt_amt") = false; 
				sheetObj.CellEditable(newRow, "inv_tax_rt_amt") = false; 
				sheetObj.CellEditable(newRow, "inv_lse_chg_amt")= false;
				sheetObj.CellEditable(newRow, "inv_tax_amt")	= false;				
				sheetObj.CellEditable(newRow, "inv_cr_amt")	= true;   // credit 만 입력 가능
				sheetObj.CellEditable(newRow, "inv_lse_chg_ttl_amt")= false; 
				*/
				
				TAB_SAVE_STD = true;	// Save 버튼 활성화
				doActionBtnEnable(tabObjects[0].SelectedIndex);	
				
				// Chassis No. Required
				sheetObj.ColBackColor("eq_no") = sheetObj.RgbColor(204, 255, 253);
				
				break;
				
			case IBRESET:		// 행삭제
				
				var strCheckedRows = sheetObj.FindCheckedRow("del_chk");		// Check 된 Row 추출
				var strStatusRows = sheetObj.FindStatusRow("I");				// 상태가 입력(I) 인 상태인 Row 추출
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				var strStatusRows2 = sheetObj.FindStatusRow("U");				// 상태가 입력(U) 인 상태인 Row 추출
				var arrStatusRows2 = strStatusRows2.split(";");
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.
				
				//chungpa 20100111 전체 save후 co-in back한 데이터(이건 'R') 중 lse_chg_aud_sts_cd is null인 것은 delete가능하게. start
				var strStatusRows3 = sheetObj.FindStatusRow("R");				// 상태가 입력(U) 인 상태인 Row 추출
				var arrStatusRows3 = strStatusRows3.split(";");
				//chungpa 20100111 전체 save후 co-in back한 데이터(이건 'R') 중 lse_chg_aud_sts_cd is null인 것은 delete가능하게. end
				var arrCheckedRows = strCheckedRows.split("|");
				var arrStatusRows = strStatusRows.split(";");
				
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				var checkDeleteStatus = false;
				for(var i=arrCheckedRows.length-2; i >= 0; i--){
					for(var k=arrStatusRows2.length-2; k>=0; k-- ){
						if(arrCheckedRows[i] == arrStatusRows2[k]){
							if(sheetObj.CellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd") == '' ) 
							{
								sheetObj.RowHidden(arrCheckedRows[i])= true;	//2.행 숨기기
								sheetObj.RowStatus(arrCheckedRows[i])= "D";		//3.트랜잭션 상태 "삭제"로 만들기
								//alert("chungpa1>>>>"+ sheetObj.CellValue(arrCheckedRows[i],"inv_no") + " ::"+ sheetObj.CellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd"));
								checkDeleteStatus = true;
							}else{
								ComShowCodeMessage("CGM20050");
								sheetObj.SelectCell(arrCheckedRows[i], "del_chk");
								return;
							}	
							break;
						}
					}
				}				
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.
				
				//chungpa 20100111 전체 save후 co-in back한 데이터(이건 'R') 중 lse_chg_aud_sts_cd is null인 것은 delete가능하게. start
				var checkDeleteStatus = false;
				if(ComShowCodeConfirm("CGM00005", "Selected Rows?")){
					for(var i=arrCheckedRows.length-2; i >= 0; i--){
						for(var k=arrStatusRows3.length-2; k>=0; k-- ){
							if(arrCheckedRows[i] == arrStatusRows3[k]){
								if(sheetObj.CellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd") == '' ) 
								{
									sheetObj.RowHidden(arrCheckedRows[i])= true;	//2.행 숨기기
									sheetObj.RowStatus(arrCheckedRows[i])= "D";		//3.트랜잭션 상태 "삭제"로 만들기
									//alert("chungpa1>>>>"+ sheetObj.CellValue(arrCheckedRows[i],"inv_no") + " ::"+ sheetObj.CellValue(arrCheckedRows[i],"lse_chg_aud_sts_cd"));
									checkDeleteStatus = true;
								}
								break;
							}
						}
					}				
					//chungpa 20100111 전체 save후 co-in back한 데이터(이건 'R') 중 lse_chg_aud_sts_cd is null인 것은 delete가능하게. end
					
					// Check 된 Row 와 상태가 입력(I) 인 상태인 Row 를 비교하여 삭제처리 수행
					for(var i=arrCheckedRows.length-2; i >= 0; i--){
						
						sheetObj.CellValue2(arrCheckedRows[i], "del_chk")= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
						
						for(var k=arrStatusRows.length-2; k>=0; k-- ){	
	
							if(arrCheckedRows[i] == arrStatusRows[k]){
								sheetObj.RowHidden(arrCheckedRows[i])= true;	//2.행 숨기기
								sheetObj.RowStatus(arrCheckedRows[i])= "D";		//3.트랜잭션 상태 "삭제"로 만들기
								break;
							}
						}
					}
				}
				// 삭제처리 후 Invoice Only 탭의 각 Row의 상태가 (I,U)일  경우 save 버튼 비활성화
				if(sheetObj.FindStatusRow("I|U")=='' && sheetObjects[1].FindStatusRow("I|U")=='' && sheetObjects[0].FindStatusRow("I")==''){
					TAB_SAVE_STD = false;	// Save 버튼 비활성화
					doActionBtnEnable(tabObjects[0].SelectedIndex);	
				}
				
				if(sheetObjects[0].RowCount > 0){
					var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
					var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
					var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
					var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

					formObj.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
					formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
					formObj.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
					formObj.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
					
				} else {
					formObj.inv_smry_amt.value = '0.00';  
					formObj.pay_chg_smry_amt.value = '0.00';
					formObj.tax_smry_amt.value = '0.00';
					formObj.cr_smry_amt.value = '0.00';
				}

				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				if(checkDeleteStatus == true)
				{
					TAB_SAVE_STD = true;	// Save 버튼 활성화
					doActionBtnEnable(tabObjects[0].SelectedIndex);						
				}
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.
				break;
			
			case IBSEARCH_ASYNC01:	// Vendor Code,Name 조회
			
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var text = ComGetEtcData(sXml,"text");
				
				formObj.vndr_lgl_eng_nm.value = text;
				break;
				
			case "IBDOWNEXCELALL":
				
				sheetObj.SpeedDown2Excel(-1,true,true,"","/apps/alps/ees/cgm/chassismgsetagreementinvoice/chassismgsetinvoice/xml/EES_CGM_1205_FORMAT.xml",false,false,sTabCaption,true,"del_chk");
				
				break;
			
			case "IBDOWNEXCEL":
				
				sheetObj.SpeedDown2Excel(-1,false,true,"","/apps/alps/ees/cgm/chassismgsetagreementinvoice/chassismgsetinvoice/xml/EES_CGM_1205_FORMAT.xml",false,false,sTabCaption,true,"del_chk");
				
				break;
				
		}
	}
	
	/**
	 * Action 버튼의 활성/비활성을 설정한다. <br>
	 * @param  int tabIndex
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	
	function doActionBtnEnable (tabIndex){

		var formObj = document.form; 
//		alert("formObj.lse_chg_sts_cd.value : " + formObj.lse_chg_sts_cd.value);
		// 현재의 Charge Header의 상태값이 C (Invoice Confirm) 일 경우
		// 모든 버튼을 비활성화 시킨다.
		if(formObj.lse_chg_sts_cd.value == 'C'){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_coin");
			ComBtnDisable("btn_coin_back");
			ComBtnDisable("btn_soCreate");
			ComBtnDisable("btn_remove");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_delete");
			
			return;
		}	
		
		// 현재의 Charge Header의 상태값이 S (P.Amt Confirm) 일 경우
		// 삭제 버튼만 활성화 시키고 나머지는 비활성화 시킨다.
		if(formObj.lse_chg_sts_cd.value == 'S'){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_coin");
			ComBtnDisable("btn_coin_back");
			ComBtnDisable("btn_soCreate");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_delete");
			
			if(tabIndex == 0){
				ComBtnEnable("btn_remove");
			} else {
				ComBtnDisable("btn_remove");
			}
			return;
		}
		
		// Invoice Type이 'CMT', 'MCD'인 경우 btn_add, btn_delete 비활성화
		if(document.form.parent_chss_cop_inv_tp_cd.value == 'CMT' ||
				document.form.parent_chss_cop_inv_tp_cd.value == 'MCD') {
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_delete");
		}
		 
		switch(tabIndex){
			case 0:	// Tab Index = 0
				ComBtnDisable("btn_coin");
				
				// Invoice Type이 'UNR'이 아닌경우 btn_coin_back 비활성화
				if(document.form.parent_chss_cop_inv_tp_cd.value != 'UNR') {
					ComBtnDisable("btn_coin_back");
				} else {
					ComBtnEnable("btn_coin_back");
				}
				
				ComBtnEnable("btn_soCreate");
				ComBtnDisable("btn_remove");
				if(TAB_SAVE_STD){
					ComBtnEnable("btn_save");
				} else {
					ComBtnDisable("btn_save");
				}
				break;
				
			case 1:	// Tab Index = 1
				ComBtnEnable("btn_coin");
				ComBtnDisable("btn_coin_back");
				ComBtnDisable("btn_soCreate");
				ComBtnDisable("btn_remove");
				if(TAB_SAVE_STD){
					ComBtnEnable("btn_save");
				} else {
					ComBtnDisable("btn_save");
				}
				break;
				
			case 2:	// Tab Index = 2
				ComBtnEnable("btn_coin");
				ComBtnDisable("btn_coin_back");
				ComBtnDisable("btn_soCreate");
				ComBtnDisable("btn_remove");
				if(TAB_SAVE_STD){
					ComBtnEnable("btn_save");
				} else {
					ComBtnDisable("btn_save");
				}
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_delete");

				break;
				
			case 3: // Tab Index = 3
				ComBtnEnable("btn_coin");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_soCreate");
				ComBtnDisable("btn_remove");
				break;
				
			case 5:	// save 버튼 활성
				ComBtnEnable("btn_save");
				break;
			
			case 6:	// save 버튼 비활성  
				ComBtnDisable("btn_save");
				break;
				
			default:	// Form Load 시 기본설정 (Loading시 -1값으로 세팅)
				ComBtnDisable("btn_coin");
				ComBtnEnable("btn_soCreate");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_remove");
				break;
		}
	}
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "Coincidence" , -1 );
					InsertTab( cnt++ , "Discrepancy" , -1 );
					InsertTab( cnt++ , "Invoice Only" , -1 );
					InsertTab( cnt++ , "Min Commitment/MH Credit" , -1 );

				}
				break;
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem){

		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;

	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {object} formObj	필수 Form Object
	 * @param  {String} sAction	필수 Action Type
	 * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
	 * @author 김창식
	 * @version 2009.09.09
	 */   
	function validateForm(sheetObj,formObj,sAction){

		switch(sAction){
			case IBSAVE:	// 저장
			
//				if(tabObjects[0].SelectedIndex == 2){
					var strStatusRows = sheetObj.FindStatusRow("I");
					var arrStatusRows = strStatusRows.split(";");
				
					// Invoice Only Tab 에서 필수입력항목 체크한다
					for(var i=0; i<arrStatusRows.length-1; i++){
						
						// Charge Code가 CRD/TAX/CMT/MCD 일 때는 특정 CHSS/CNTR에 대응할 수 있는 비용이 아님 
						if(sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'PDM' ||
//							sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'CMT' ||
//							sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'MCD' ||
							sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'MIG' ||
							sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'RSH' ||
							sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'CSH') {
							if(ComTrim(sheetObj.cellValue(arrStatusRows[i],"eq_no"))==""){
								ComShowCodeMessage('CGM10004','Chassis No.');
								sheetObj.SelectCell(arrStatusRows[i], "eq_no", true);
								return false;
							}
						}	
						
						if(ComTrim(sheetObj.cellValue(arrStatusRows[i],"inv_ref_no"))==""){
							ComShowCodeMessage('CGM10004','Invoice Reference No.');
							sheetObj.SelectCell(arrStatusRows[i], "inv_ref_no", true);
							return false;
							
						} else if(ComTrim(sheetObj.cellValue(arrStatusRows[i],"inv_no"))==""){
							if(sheetObj.cellValue(arrStatusRows[i],"chg_cd") == "CRD")
							{
								//chungpa 20091223 CRD일경우, inv_no체크 안함.
								
								//chungpa 20100321 CRD일경우, inv_no체크 함. 변경됨.
								ComShowCodeMessage('CGM10004','Invoice No.');
								sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
								return false;
							}else
							{
								ComShowCodeMessage('CGM10004','Invoice No.');
								sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
								return false;
							}
						} else if(ComTrim(sheetObj.cellValue(arrStatusRows[i],"inv_lse_chg_amt"))==""){
							ComShowCodeMessage('CGM10004','Invoice Total');
							sheetObj.SelectCell(arrStatusRows[i], "inv_lse_chg_amt", true);
							return false;
						}
					}
					

					for(var i=0; i<arrStatusRows.length-1; i++){
						var invNo = sheetObj.cellValue(arrStatusRows[i],"inv_no");
						var invRefNo = sheetObj.cellValue(arrStatusRows[i],"inv_ref_no");
						
						// Invoice Only Tab 에서 Credit 입력값중 Invoice No 가 Concidence Tab 에 있는 Invoice Reference No 에 속하는지 체크.
						var concidenceRow = sheetObjects[0].FindText("inv_ref_no", invRefNo);
						if(concidenceRow == -1){
							// Concidence 에 Invoice Reference No 의 값을 없을 경우
							ComShowCodeMessage('CGM10049',invRefNo);
							sheetObj.SelectCell(arrStatusRows[i], "inv_ref_no", true);
							return false;
						} else {
							sheetObj.cellValue2(arrStatusRows[i], "agmt_ofc_cty_cd") = sheetObjects[0].cellValue(concidenceRow,"agmt_ofc_cty_cd");
							sheetObj.cellValue2(arrStatusRows[i], "agmt_seq") = sheetObjects[0].cellValue(concidenceRow,"agmt_seq");
							sheetObj.cellValue2(arrStatusRows[i], "agmt_ver_no") = sheetObjects[0].cellValue(concidenceRow,"agmt_ver_no");
							sheetObj.cellValue2(arrStatusRows[i], "agmt_lstm_cd") = sheetObjects[0].cellValue(concidenceRow,"agmt_lstm_cd");
						}
						
						// Invoice Only Tab 에서 Credit 입력값중 Invoice No 가 Concidence Tab 에 있는 Invoice No 에 속하는지 체크.
						// Credit 입력일 경우에만 체크한다.
						//if(sheetObj.cellValue(arrStatusRows[i], "chg_cd")=='CRD'){
							if(sheetObjects[0].FindText("inv_no", invNo) == -1){
								if(sheetObj.cellValue(arrStatusRows[i],"chg_cd") == "CRD")
								{
									//chungpa 20091223 CRD일경우, inv_no체크 안함.
								}else
								{
									ComShowCodeMessage('CGM10025',invNo);
									sheetObj.SelectCell(arrStatusRows[i], "inv_no", true);
									return false;
								}
							}
						//}
//					}
				}
				
				break;
				
			case IBCREATE:
				if(form.inv_dt.value == ''){
					ComShowCodeMessage('CGM10004',"Issue Date");
					form.inv_dt.focus();
					return false;
				}
				
				break;
		}
		
		return true;
	}
	
	/**
	 * 탭 (tab1) 의 click 이벤트를 정의한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	 
	function tab1_OnClick(tabObj, tabIndex){
		doActionBtnEnable(tabIndex);
	}

//	/**
//	 * sheet Object (Discrepancy) 의 click 이벤트를 정의한다. <br>
//	 * @param  없음
//	 * @return 없음
//	 * @author 김창식
//	 * @version 2009.09.09
//	 */	 
//	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
//		
//		if(sheetObj.ColSaveName(Col) == 'pay_chg_aud_rmk'){
//			TAB_SAVE_STD = true;	// Save 버튼 활성화
//			doActionBtnEnable(tabObjects[0].SelectedIndex);	
//		}
//	}

	/**
	 * sheet Object (Invoice Only) 의 click 이벤트를 정의한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	 
	function t1sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var formObj = document.form;
		
		if(sheetObj.ColSaveName(Col) == "inv_ref_no"){
			var findRow = sheetObjects[0].FindText("inv_ref_no", sheetObj.cellValue(Row,"inv_ref_no"),-1);
			
			if(findRow!=-1){
				sheetObj.cellValue2(Row,"agmt_ofc_cty_cd") = sheetObjects[0].cellValue(findRow,"agmt_ofc_cty_cd"); 
				sheetObj.cellValue2(Row,"agmt_seq") = sheetObjects[0].cellValue(findRow,"agmt_seq"); 
				sheetObj.cellValue2(Row,"agmt_ver_no") = sheetObjects[0].cellValue(findRow,"agmt_ver_no"); 
			}
		}
		
		// CHG_CD 값에 따라 변경  항목 Editable 설정
		/*
		1. ROW ADD
				1) PDM,ONT
					Rate Sum,Tax Sum,TTL Amt - 3개만 입력가능
					샤시, 컨테이너 번호 입력가능하게 풀어줌.
				2) CRD
					Credit 만 입력 가능
				3) TAX	   
					TAX	만 입력 가능
		*/
		if(sheetObj.ColSaveName(Col) == "chg_cd"){
			with(sheetObj) {
				
				cellValue2(Row, "inv_tax_amt") = 0;
				cellValue2(Row, "inv_cr_amt") = 0;
				if(sheetObj.cellValue(Row, "chg_cd") == 'CRD'){
					
					sheetObj.CellEditable(Row, "eq_no")		= false;
					sheetObj.CellEditable(Row, "inv_cust_eq_no") = false;	
					sheetObj.CellEditable(Row, "inv_cr_amt")	= true;
					sheetObj.CellEditable(Row, "inv_tax_amt")	= false;
					sheetObj.CellEditable(Row, "inv_lse_chg_amt")= false;
					sheetObj.CellEditable(Row, "inv_lse_chg_ttl_amt")= false;
					
					/*
					sheetObj.CellEditable(newRow, "eq_no") = false;		
					
					sheetObj.CellEditable(newRow, "inv_lse_rt_amt") = false; 
					sheetObj.CellEditable(newRow, "inv_tax_rt_amt") = false; 
					sheetObj.CellEditable(newRow, "inv_lse_chg_amt")= false;
					sheetObj.CellEditable(newRow, "inv_tax_amt")	= false;				
					sheetObj.CellEditable(newRow, "inv_cr_amt")	= true;   // credit 만 입력 가능
					sheetObj.CellEditable(newRow, "inv_lse_chg_ttl_amt")= false;
					*/
					
					// chd_cd(Charge Type) 변경시 유효값 초기화
					cellValue2(Row, "eq_no") = "";				// Chassis No.
					cellValue2(Row, "inv_cust_eq_no") = "";		// Container No.
					cellValue2(Row, "inv_tax_amt") = 0;
					cellValue2(Row, "inv_lse_chg_amt") = 0;
					
				} else if(sheetObj.cellValue(Row, "chg_cd") == 'TAX'){
					
					sheetObj.CellEditable(Row, "eq_no") = false;
					sheetObj.CellEditable(Row, "inv_cr_amt") = false;
					sheetObj.CellEditable(Row, "inv_tax_amt") = true;
					sheetObj.CellEditable(Row, "inv_lse_chg_amt") = false;
					
					sheetObj.cellValue2(Row, "inv_cr_amt") = 0;
					sheetObj.cellValue2(Row, "inv_lse_chg_amt") = 0;
	/*	수정전 원본, 2014-03-26			
				} else if(sheetObj.cellValue(Row, "chg_cd") == 'PDM'){
					
					sheetObj.CellEditable(Row, "eq_no") = true;
					sheetObj.CellEditable(Row, "inv_cr_amt") = false;
					sheetObj.CellEditable(Row, "inv_tax_amt") = false;
					sheetObj.CellEditable(Row, "inv_lse_chg_amt") = true;
					
					sheetObj.cellValue2(Row, "inv_cr_amt") = 0;
					sheetObj.cellValue2(Row, "inv_tax_amt") = 0;
				}
	*/
				} else if(sheetObj.cellValue(Row, "chg_cd") == 'CMT' || sheetObj.cellValue(Row, "chg_cd") == 'MCD') {
					sheetObj.CellEditable(Row, "eq_no")		= false;
					sheetObj.CellEditable(Row, "inv_cust_eq_no") = false;
					
					sheetObj.CellEditable(Row, "inv_lse_rt_amt")	 = false; // Invoice Rate
					sheetObj.CellEditable(Row, "inv_tax_rt_amt")	 = false; // Invoice Tax(%)
					sheetObj.CellEditable(Row, "inv_cr_amt")		 = false; // Invoice Credit
					sheetObj.CellEditable(Row, "inv_tax_amt")		 = false; // Invoice Tax Sum
					sheetObj.CellEditable(Row, "inv_lse_chg_amt")	 = false; // Invoice Rate Sum
					sheetObj.CellEditable(Row, "inv_lse_chg_ttl_amt")= false; // Invoice TTL AMT
					
				} else { //PDM,ONT, MIG, RSH, CSH
					sheetObj.CellEditable(Row, "eq_no")		  = true;
					sheetObj.CellEditable(Row, "inv_cust_eq_no") = true;
					
					sheetObj.CellEditable(Row, "inv_lse_rt_amt")	 = false;
					sheetObj.CellEditable(Row, "inv_tax_rt_amt")	 = false;
					sheetObj.CellEditable(Row, "inv_lse_chg_amt")	 = true;
					sheetObj.CellEditable(Row, "inv_tax_amt")		 = true;
					sheetObj.CellEditable(Row, "inv_cr_amt")		 = false;
					sheetObj.CellEditable(Row, "inv_lse_chg_ttl_amt")= true;

				}
			}
			
		}
		
		// CRD 값 변경시 무조건 (-)형태로 표시
		if(sheetObj.ColSaveName(Col) == "inv_cr_amt" ){
			if(sheetObj.cellValue(Row, "chg_cd") == 'CRD'){
				sheetObj.cellValue2(Row, "inv_cr_amt") = -1 * Math.abs(sheetObj.cellValue(Row, "inv_cr_amt"));
			}
		}
		
		// Tax, Credit, Invoice Total 이  변경될 경우 아래 TextBox에 계산값 입력
		if(sheetObj.ColSaveName(Col) == "inv_lse_chg_amt" || 
				sheetObj.ColSaveName(Col) == "inv_tax_amt" || sheetObj.ColSaveName(Col) == "inv_cr_amt"  ){
			
			var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
			var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
			var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
			var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

			formObj.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
			formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
			formObj.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
			formObj.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
		}
		
		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
		else if(sheetObj.ColSaveName(Col) == "chg_cd"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "inv_ref_no"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "inv_no"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "eq_no"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "inv_cr_amt"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "inv_tax_amt"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}else if(sheetObj.ColSaveName(Col) == "inv_lse_chg_amt"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);				
		}
		
		if(sheetObj.CellValue(Row, "lse_chg_aud_sts_cd") == "D" || sheetObj.CellValue(Row, "lse_chg_aud_sts_cd") == "I"){
			sheetObj.RowStatus(Row) = "U";
			
		}
		//chungpa 20091223 check inv no,inv ref no
//		t4sheet1_ChkInvNo(sheetObj,Row,Col,Value);
	}
	

	/**
	 * Sheet1 의 OnSaveEnd (Save) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
	function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save 버튼 비활성화
			document.form.lse_chg_sts_cd.value='A';
			if(sheetObjects[0].RowCount > 0){
				var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
				var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
				var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
				var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));
				
				document.form.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
				document.form.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
				document.form.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
				document.form.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);

				/*
				 * 2015.04.08 [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
				 * Coincidence탭의 Original Audit Result(lse_chg_aud_sts_cd)가 "C"인 데이터를 Invoice Only탭으로 옮길 수 있게~
				 * by Chang Young Kim, order 임동빈 부장
				 */
				for(var i=2; i<2+sheetObjects[0].RowCount; i++)
				{
					if(sheetObjects[0].CellValue(i,"lse_chg_aud_sts_cd") == "C") //C만 고정.
						sheetObjects[0].CellEditable(i, "del_chk") = false;
				}
			}else{
				document.form.inv_smry_amt.value = '0.00';  
				document.form.pay_chg_smry_amt.value = '0.00'; 
				document.form.tax_smry_amt.value = '0.00'; 
				document.form.cr_smry_amt.value = '0.00'; 
			}
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
 
	/**
	 * Sheet1 의 OnSaveEnd (Save) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
//	function sheet1_OnSaveEnd(sheetObj, errMsg) {
//		if(errMsg =='') {   
//			ComShowCodeMessage('CGM00003');
//			TAB_SAVE_STD = false;	// Save 버튼 비활성화
//			document.form.lse_chg_sts_cd.value='A';
//			doActionBtnEnable(tabObjects[0].SelectedIndex);	
//		}
//	}	 
	 
	/**
	 * Sheet2 의 OnSaveEnd (Save) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
	function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save 버튼 비활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}	
	
	/**
	 * Sheet4 의 OnSaveEnd (Save) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
	function t4sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save 버튼 비활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}		
	 
	/** 
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.11
	 */ 
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
		 		
		window.defaultStatus = obj.dataformat;
		 	 
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "int":
				ComKeyOnlyNumber(obj);
				break;
			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
		 		ComKeyOnlyAlphabet('upper');
		 		break;
		 	case "engdn":
		 		ComKeyOnlyAlphabet('lower');
		 		break;
		}
	}
	
	/** 
	 * Object 의 activate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.11
	 */
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}
	
	/** 
	 * Object 의 deactivate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.11
	 */
	function obj_deactivate(){
		var formObj = document.form;
		obj = event.srcElement;	 	
		
		if(obj.name == 'inv_dt'){
			ComChkObjValid(event.srcElement);
		}
	} 
	 
	/**
	 * t1sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
	 * @author 조재성
	 * @version 2009.12.16
	 */	  
//	function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
//		var formObj = document.form;
//		if(Col == 3) // chassis
//		{
//	 		var eqNo = sheetObj.CellValue(Row,Col);
//			if(eqNo != "")
//			{
// 		 		var pgmNo = 'EES_CGM_1003';
// 		 		var pgmUrl = '/hanjin/EES_CGM_1003.do';
// 		 		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
// 				var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 				ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);				
//			}
//		}
//	}
//	/**
//	 * t2sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
//	 * @author 조재성
//	 * @version 2009.12.16
//	 */	  
//	function t2sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
//		if(Col == 3) // chassis
//		{
//	 		var eqNo = sheetObj.CellValue(Row,Col);
//			if(eqNo != "")
//			{
// 		 		var pgmNo = 'EES_CGM_1003';
// 		 		var pgmUrl = '/hanjin/EES_CGM_1003.do';
// 		 		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
// 				var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 				ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);				
//			}
//		}	
//	}

//	/**
//	 * t4sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
//	 * @author 조재성
//	 * @version 2009.12.16
//	 */	  
//	function t4sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
//	  	if(Col == 3) // Customer chassis
//		{
//	 		var eqNo = sheetObj.CellValue(Row,Col);
//			if(eqNo != "")
//			{
// 		 		var pgmNo = 'EES_CGM_1003';
// 		 		var pgmUrl = '/hanjin/EES_CGM_1003.do';
// 		 		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
// 				var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 				ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);				
//			}
//		}else if(Col == 4) // SML chassis
//		{
//	 		var eqNo = sheetObj.CellValue(Row,Col);
//			if(eqNo != "")
//			{
// 		 		var pgmNo = 'EES_CGM_1003';
// 		 		var pgmUrl = '/hanjin/EES_CGM_1003.do';
// 		 		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
// 				var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
// 				ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);				
//			}
//		}
//	}	
//	 
//	 
	/**
	 * Sheet4 의 cell을 edit 할 경우 <br>
	 * @author 조재성
	 * @version 2009.08.12
	 */   
//	function t4sheet1_ChkInvNo(sheetObj, Row, Col,Value)
//	{
//		var formObj = document.form;
//		var t1sheet1 = sheetObjects[0];
//		var t2sheet1 = sheetObjects[1];
//		var t4sheet1 = sheetObjects[2];
//		
//		var target = sheetObj.CellValue(Row,Col);
//		if(target == null || target == "")	return;
//		
//		if(sheetObj.ColSaveName(Col) == "inv_ref_no") // Invoice Reference No.
//		{
//			//sheet1
//			for(var i=0; i< t1sheet1.RowCount-1; i++) //RowCount-1 의 이유> 방금 add된 데이터라 비교하면 안됨.
//			{
//				if(target == t1sheet1.CellValue(i+2, "inv_ref_no") ) // i+2의 이유> 헤더가 2Row를 차지한다. 
//				{
//					return true;
//				}
//			}			
//			//sheet2			
//			for(var i=0; i< t2sheet1.RowCount-1; i++)
//			{
//				if(target == t2sheet1.CellValue(i+2, "inv_ref_no") )
//				{
//					return true;
//				}
//			}
//			//sheet4			
//			for(var i=0; i< t4sheet1.RowCount-1; i++)
//			{
//				if(target == t4sheet1.CellValue(i+2, "inv_ref_no") )
//				{
//					return true;
//				}
//			}
//			ComShowCodeMessage("CGM20023", "Invoice Reference No.("+target+")");			
//			sheetObj.CellValue2(Row,Col) = "";
//			sheetObj.SelectCell(Row, Col);
//			return false;
//		}else if(sheetObj.ColSaveName(Col) == "inv_no") // Invoice No.
//		{
//			if(t4sheet1.CellValue(Row, "chg_cd") != "CRD") // CRD체크
//			{
//				//check.
//				for(var i=0; i< t1sheet1.RowCount-1; i++)
//				{
//					if(target == t1sheet1.CellValue(i+2, "inv_no") )
//					{
//						return true;
//					}
//				}			
//				for(var i=0; i< t2sheet1.RowCount-1; i++)
//				{
//					if(target == t2sheet1.CellValue(i+2, "inv_no") )
//					{
//						return true;
//					}
//				}			
//				for(var i=0; i< t4sheet1.RowCount-1; i++)
//				{
//					if(target == t4sheet1.CellValue(i+2, "inv_no") )
//					{
//						return true;
//					}
//				}
//				ComShowCodeMessage("CGM20023", "Invoice No.("+target+")");
//				sheetObj.CellValue2(Row,Col) = "";
//				sheetObj.SelectCell(Row, Col);
//				return false;
//			}else
//			{
//				return true; //CRD이면 invoice no 체크 안함.
//			}
//		}
//	}
	 
 /**
  * Save하고 난 이후에도 lse_chg_aud_sts_cd가 null인 경우에는 편집 가능하게 설정한다. <br> 
  *
  * @author 조재성
  * @version 2010.01.04
  */   
function t1sheet1_enableEditingWhenLseChgAudStsCdIsNull(sheetObj, Row, Col,Value) {
	sheetObjects[0].Editable = true;
	for(var i=2; i<2+sheetObjects[0].RowCount; i++)
	{
		if(sheetObjects[0].cellvalue(i,"lse_chg_aud_sts_cd") == '')
		{
			sheetObjects[0].RowEditable(i) = true;
			
			// Invoice Only 의 Charge Type 에 따라 입력항목 활성/비활성 설정
			if(sheetObjects[0].cellValue(i, "chg_cd") == 'CRD'){
				sheetObjects[0].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
//				sheetObjects[0].CellEditable(i, "inv_ref_no") = true;
//				sheetObjects[0].CellEditable(i, "inv_no") = true;
				sheetObjects[0].CellEditable(i, "eq_no") = false;
				sheetObjects[0].CellEditable(i, "inv_cr_amt") = true;
				sheetObjects[0].CellEditable(i, "inv_tax_amt") = false;
				sheetObjects[0].CellEditable(i, "inv_lse_chg_amt") = false;
				
			} else if(sheetObjects[0].cellValue(i, "chg_cd") == 'TAX'){
				sheetObjects[0].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
//				sheetObjects[0].CellEditable(i, "inv_ref_no") = true;
//				sheetObjects[0].CellEditable(i, "inv_no") = true;
				sheetObjects[0].CellEditable(i, "eq_no") = false;
				sheetObjects[0].CellEditable(i, "inv_cr_amt") = false;
				sheetObjects[0].CellEditable(i, "inv_tax_amt") = true;
				sheetObjects[0].CellEditable(i, "inv_lse_chg_amt") = false;
/*				
			} else if(sheetObjects[0].cellValue(i, "chg_cd") == 'PDM'){
				sheetObjects[0].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
//				sheetObjects[0].CellEditable(i, "inv_ref_no") = true;
//				sheetObjects[0].CellEditable(i, "inv_no") = true;
				sheetObjects[0].CellEditable(i, "eq_no") = false; // PDM일때 원래 eq_no는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
				sheetObjects[0].CellEditable(i, "inv_cr_amt") = false;
				sheetObjects[0].CellEditable(i, "inv_tax_amt") = false;
				sheetObjects[0].CellEditable(i, "inv_lse_chg_amt") = true;
			}
*/
			} else if(sheetObjects[0].cellValue(i, "chg_cd") == 'CMT' || sheetObjects[0].cellValue(i, "chg_cd") == 'MCD') {
				sheetObjects[0].CellEditable(i, "eq_no")		= false;
				sheetObjects[0].CellEditable(i, "inv_cust_eq_no") = false;
				
				sheetObjects[0].CellEditable(i, "inv_lse_rt_amt")		= false; // Invoice Rate
				sheetObjects[0].CellEditable(i, "inv_tax_rt_amt")		= false; // Invoice Tax(%)
				sheetObjects[0].CellEditable(i, "inv_cr_amt")			= false; // Invoice Credit
				sheetObjects[0].CellEditable(i, "inv_tax_amt")			= false; // Invoice Tax Sum
				sheetObjects[0].CellEditable(i, "inv_lse_chg_amt")		= false; // Invoice Rate Sum
				sheetObjects[0].CellEditable(i, "inv_lse_chg_ttl_amt")	= false; // Invoice TTL AMT
				
			} else { //PDM, ONT, CMT, MCD, MIG, RSH, CSH
				
				sheetObjects[0].CellEditable(i, "inv_lse_rt_amt")		= false; 
				sheetObjects[0].CellEditable(i, "inv_tax_rt_amt")		= false; 
				sheetObjects[0].CellEditable(i, "inv_lse_chg_amt")		= true;
				sheetObjects[0].CellEditable(i, "inv_tax_amt")			= true;
				sheetObjects[0].CellEditable(i, "inv_cr_amt")			= false;   
				sheetObjects[0].CellEditable(i, "inv_lse_chg_ttl_amt")	= true;	
				
			}	
			
			/*실시간 combobox 적용 end*/
			doActionBtnEnable(tabObjects[0].SelectedIndex);	  
		}	
		else
		{
			//기존 데이터는 편집 불가.
		}
	}
 }

/**
 * 
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(ErrMsg.length == 0) { // Retrieve Success
		// Parent에서 받은 Invoice Type 별 Tab 활성/비활성 Control
		if(!ComIsEmpty(document.form.parent_chss_cop_inv_tp_cd.value)) {
			fn_actvOrInactvByInvTp(document.form.parent_chss_cop_inv_tp_cd.value, sheetObj.Rowcount);
		} 
		
		// Chassis No. Required
//		sheetObj.ColBackColor("eq_no") = sheetObj.RgbColor(204, 255, 253);
	}
}

/**
 * Min Commitment/MH Credit 탭의 조회 후
 * 
 * @param Object sheetObj
 * @param String ErrMsg
 * @author Chnag Young Kim
 * @version 2014.09.20
 */
function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//	alert(typeof ErrMsg + " ErrMsg : " + ErrMsg);
	if(ErrMsg.length == 0) { // Retrieve Success
			
		with(sheetObj) {
			for(idx = 1; idx <= RowCount; idx++) { // Whole row loop
				if(ComTrim(CellValue(idx, "intg_cd_val_dp_desc")).length == 1 && ComTrim(CellValue(idx, "intg_cd_val_dp_desc")) != "A" ) { // When the basic argument, intg_cd_val_dp_desc.length == 1 일 때
					CellEditable(idx, "cmmt_20ft_amt") = true;
					CellEditable(idx, "cmmt_40ft_amt") = true;
					CellEditable(idx, "cmmt_45ft_amt") = true;
				}
				
				if(idx <= 10 && idx != 3 && idx != 4) {
					InitCellProperty(idx, "cmmt_20ft_amt", dtData, daRight, "cmmt_20ft_amt", "", dfInteger);
					InitCellProperty(idx, "cmmt_40ft_amt", dtData, daRight, "cmmt_40ft_amt", "", dfInteger);
					InitCellProperty(idx, "cmmt_45ft_amt", dtData, daRight, "cmmt_45ft_amt", "", dfInteger);
				}
			}
		}
	}
	
}

/**
 * Min Commitment/MH Credit 탭의 Grid 데이터 변경 시점에
 * 
 * @param Object sheetObj
 * @param String Row
 * @param String Col
 * @param String Value
 * @author Chnag Young Kim
 * @version 2014.09.20
 */
function t5sheet1_OnChange(sheetObj, Row, Col, Value) {
//	alert(" Row : " + Row + "\nCol : " + Col + "\nValue : " + Value);
	var tmpExcsBllngDays = 0;
	
	with(sheetObj) {
		CellValue2(7, Col)	= parseFloat(CellValue( 5, Col)) - parseFloat(CellValue( 6, Col));			// G=E-F
		CellValue2(8, Col)	= parseFloat(CellValue( 1, Col)) * parseFloat(CellValue( 2, Col));			// H=A*B
		CellValue2(9, Col)	= parseFloat(CellValue( 8, Col)) - parseFloat(CellValue( 6, Col));			// I=H-F
		tmpExcsBllngDays	= parseFloat(CellValue( 7, Col)) - parseFloat(CellValue( 9, Col));			// J=G-I 
		if(tmpExcsBllngDays > 0) {
			CellValue2(10, Col)	= tmpExcsBllngDays;
		} else {
			CellValue2(10, Col)	= 0
		}
		CellValue2(11, Col)	= parseFloat(CellValue( 7, Col)) -(parseFloat(CellValue( 9, Col)) * 1.1);	// K=G-(I*1.1)
		CellValue2(12, Col)	= parseFloat(CellValue(10, Col)) - parseFloat(CellValue(11, Col));			// L=J-K
		CellValue2(13, Col)	= parseFloat(CellValue( 3, Col)) * parseFloat(CellValue( 8, Col));			// M=C*H
		CellValue2(14, Col)	= parseFloat(CellValue( 3, Col)) * parseFloat(CellValue( 6, Col)) * (-1);	// N=C*F*-1
		CellValue2(15, Col)	= parseFloat(CellValue( 4, Col)) * parseFloat(CellValue(11, Col));			// O=D*K
		CellValue2(16, Col)	= parseFloat(CellValue( 3, Col)) * parseFloat(CellValue(12, Col));			// P=C*L
		CellValue2(17, Col)	= parseFloat(CellValue(14, Col)) + parseFloat(CellValue(11, Col)) + parseFloat(CellValue(12, Col)); // Q=N+K+L
		CellValue2(18, Col)	= parseFloat(CellValue(13, Col)) + parseFloat(CellValue(17, Col));			// R=M+Q
	}
	
	TAB_SAVE_STD = true;	// Save 버튼 활성화
	doActionBtnEnable(tabObjects[0].SelectedIndex);
}
 
/**
 * Parent에서 받은 Invoice Type 별 Tab 활성/비활성 Control
 * 
 * @param String chssCopInvTpCd
 * @author Chang Young Kim
 * @version 2014.09.15
 */
function fn_actvOrInactvByInvTp(strChssCopInvTpCd, nT1sheet1Row) {
	tabObj0 = tabObjects[0];
	
	switch(strChssCopInvTpCd) {
		case "UNR":		// Usage/Rebill
			tabObj0.TabEnable(3) = false;
			break;
		case "CMT":		// Min Commitment
		case "MCD":		// MH Credit
			tabObj0.TabEnable(1) = false;
			tabObj0.TabEnable(2) = false;
			if(nT1sheet1Row > 0) {
				tabObj0.SelectedIndex = 0;
			} else {
				tabObj0.SelectedIndex = 3;
			}
			
			doActionBtnEnable(tabObj0.SelectedIndex);
			
			break;
		case "MIG":		// Repo(Migration)
		case "RSH":		// Revenue Sharing
		case "CSH":		// Cost Sharing
			tabObj0.TabEnable(1) = false;
			tabObj0.TabEnable(2) = false;
			tabObj0.TabEnable(3) = false;
		default:
			break;
	}
}

/**
 * Row Add시 Parent에서 받은 Invoice Type 별로 콤보값 세팅
 * 
 * @param Object sheetObj
 * @param int nRow
 * @param String strCmbNm
 * @param String strChssCopInvTpCd
 * @author Chang Young Kim
 * @version 2015.02.16
 */
function fn_comboSetting(sheetObj, nRow, strCmbNm, strChssCopInvTpCd) {
	with(sheetObj) {
		switch(strChssCopInvTpCd) {
			case "UNR":		// Usage/Rebill
				CellComboItem(nRow, strCmbNm, "CRD|TAX|PDM|ONT", "CRD|TAX|PDM|ONT");
				cellValue2(nRow, "chg_cd") = "CRD";
				break;
			case "CMT":		// Min Commitment
			case "MCD":		// MH Credit
			case "MIG":		// Repo(Migration)
			case "RSH":		// Revenue Sharing
			case "CSH":		// Cost Sharing
				CellComboItem(nRow, strCmbNm, strChssCopInvTpCd, strChssCopInvTpCd);
				CellValue2(nRow, "chg_cd") = strChssCopInvTpCd;
				break;
			default:
				break;
		}
	}
}

/**
 * Coincidence Tab의 하단 폼 값들을 세팅함
 * 
 * @author Chang Young Kim
 * @version 2015.03.19
 */
function fn_CoincidenceTabFormValue() {
	var formObject = document.form;
	
	if(sheetObjects[0].RowCount > 0){
		var invTtlAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_ttl_amt|"),',',''));
		var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_tax_amt|"),',',''));
		var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_cr_amt|"),',',''));
		var payLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|pay_lse_chg_amt|"),',',''));

		formObject.inv_smry_amt.value = ComCgmAmountFormat(payLseChgAmt, 2);  
		formObject.pay_chg_smry_amt.value = ComCgmAmountFormat(payLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);
		formObject.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
		formObject.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
		
	} else {
		formObject.inv_smry_amt.value = '0.00';  
		formObject.pay_chg_smry_amt.value = '0.00';
		formObject.tax_smry_amt.value = '0.00';
		formObject.cr_smry_amt.value = '0.00';
	}
}
	/* 개발자 작업  끝 */