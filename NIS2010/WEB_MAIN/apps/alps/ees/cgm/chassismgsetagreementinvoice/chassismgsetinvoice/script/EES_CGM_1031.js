/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1031.js
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class ees_cgm_1031 : ees_cgm_1031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_cgm_1031() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
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

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
	
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
		    switch(srcName) {
		    	
		    	case "btn_downExcel":
		    		if(tabObjects[0].SelectedIndex == 0){
		    			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].SelectedIndex == 1){
		    			doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].SelectedIndex == 2){
		    			doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
		    		} else if(tabObjects[0].SelectedIndex == 3){
		    			doActionIBSheet(sheetObject4, formObject, IBDOWNEXCEL);
		    		}
		    		
					break;
	
				case "btn_save":
					if(validateForm(sheetObject4,formObject,IBSAVE) != false) {
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
					break;
	
				case "btn_coin":
					
					if(tabObjects[0].SelectedIndex == 1 || tabObjects[0].SelectedIndex == 3){
						
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
						} else if(tabObjects[0].SelectedIndex == 3){
							// Invoice Only 행 추가 후 저장을 하지 않았을때 처리 하지 않도록..
							var tmpFindRows = sheetObjects[3].FindStatusRow('I');
							if(tmpFindRows != "")
							{
								ComShowCodeMessage('CGM10026','Invoice Only');
								return;
							}
						}
						
						var sColNms = "";
						
						// 이동시키려는 data name 을 설정
						if(tabObjects[0].SelectedIndex == 1){
							sColNms = sColNms + "ibflag|eq_no|inv_no|agmt_no|inv_ref_no|eq_tpsz_cd|lse_chg_aud_sts_cd|chg_cd|eq_onh_loc_cd|";
							sColNms = sColNms + "eq_onh_dt|eq_bil_st_dt|eq_offh_loc_cd|eq_offh_dt|lse_rt_amt|";
							sColNms = sColNms + "lse_chg_amt|inv_bil_st_dt|inv_bil_end_dt|";
							sColNms = sColNms + "inv_eq_onh_loc_nm|inv_eq_offh_loc_nm|inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|";
							sColNms = sColNms + "inv_lse_chg_amt|intg_cd_val_dp_desc|pay_chg_aud_rmk|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq"; // chungpa 20100104 chg_seq 추가
							
						} else if(tabObjects[0].SelectedIndex == 3){
							sColNms = sColNms + "ibflag|seq|inv_cust_eq_no|eq_no|inv_ref_no|";
							sColNms = sColNms + "inv_no|chg_cd|inv_bil_st_dt|inv_bil_end_dt|inv_eq_onh_loc_nm|";
							sColNms = sColNms + "inv_eq_offh_loc_nm|inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_amt|";
							sColNms = sColNms + "aud_umch_eq_sts_evnt_yd_cd|aud_umch_eq_sts_evnt_dt|intg_cd_val_dp_desc|pay_chg_aud_rmk|";
							sColNms = sColNms + "lse_chg_aud_sts_cd|agmt_no|eq_tpsz_cd|";
							sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq"; // chungpa 20100104 chg_seq 추가
						}
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
								,false//raiseChangeEvent Boolean 선택 OnChange Event를 발생할지 여부, Default=false 
								,""//SrcCheckCol Long / String 선택  복사Sheet에서 특정컬럼을 기준으로 체크된 행만 복사	// Default=""(모든 Row 의미)  
								,""///DestCheckCol Long / String 선택  붙여넣기대상Sheet에서 특정컬럼을 기준으로 체크된 행만 붙여넣는다., Default=""(모든 Row 의미) 

						);						
						//chungpa 20100111 신규 end

						
						// Concidency 로 이동한 후 Save 버튼을 활성화
						TAB_SAVE_STD = true;
						doActionBtnEnable(tabObjects[0].SelectedIndex);	
						
						//--------------------
						// 계산식
						//-------------------
						// Considency Tab
		         		if(sheetObjects[0].RowCount > 0){
		         			
		         			var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
		         			var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
		         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         		var lseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
			         		
			         		formObject.inv_smry_amt.value = ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);   
			         		formObject.pay_chg_smry_amt.value = ComCgmAmountFormat(lseChgAmt,2);
			         		formObject.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
			         		formObject.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
			         		
		         		} else {
		         			formObject.inv_smry_amt.value = '0.00';  
			         		formObject.pay_chg_smry_amt.value = '0.00';
			         		formObject.tax_smry_amt.value = '0.00';
			         		formObject.cr_smry_amt.value = '0.00';
		         		}
		         		
		         		// Descrepancy 탭을 선택 했을 경우
						if(tabObjects[0].SelectedIndex == 1){
							
							if(sheetObjects[1].RowCount > 0){
								var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
			         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
			         			var invCrAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
			         			
			         			formObject.lse_chg_amt.value = ComCgmAmountFormat(lseChgAmt,2);
			         			formObject.inv_lse_chg_amt.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
			         			formObject.diff.value = ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
							} else {
								formObject.lse_chg_amt.value = '0.00';
								formObject.inv_lse_chg_amt.value = '0.00';
				         		formObject.diff.value = '0.00';
							}	
						
						// Invoice Only 탭을 선택했을 경우
						} else if(tabObjects[0].SelectedIndex == 3){
							
							if(sheetObjects[3].RowCount > 0){
								var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
			         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
			         			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
			         			
			         			formObject.lse_chg_amt3.value = '0.00';
			         			formObject.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
			         			formObject.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
							} else {
								formObject.lse_chg_amt3.value = '0.00';
								formObject.inv_lse_chg_amt3.value = '0.00';
								formObject.diff3.value = '0.00';
							}
						}
					}
					sheetObjects[tabObjects[0].SelectedIndex].CheckAll(1) = 0;       //모두 선택 취소하기
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
		    		
		    		//--------------------
					// Sheet 이동
					//-------------------
		    		var sColNms = "";
					
					// 이동시키려는 data name 을 설정
					sColNms = sColNms + "ibflag|eq_no|inv_no|agmt_no|inv_ref_no|eq_tpsz_cd|lse_chg_aud_sts_cd|chg_cd|eq_onh_loc_cd|eq_onh_dt|";
					sColNms = sColNms + "eq_bil_st_dt|eq_offh_loc_cd|eq_offh_dt|lse_rt_amt|lse_chg_amt|";
					sColNms = sColNms + "inv_bil_st_dt|inv_bil_end_dt|inv_eq_onh_loc_nm|inv_eq_offh_loc_nm|";
					sColNms = sColNms + "inv_lse_use_dys|inv_lse_rt_amt|inv_tax_amt|inv_cr_amt|inv_lse_chg_amt|pay_chg_aud_rmk|";
					sColNms = sColNms + "agmt_ofc_cty_cd|agmt_seq|agmt_ver_no|agmt_lstm_cd|chg_seq"; // chungpa 20100104 chg_seq 추가
		    		
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
					//기존 Start
					//sheetObjects[3].LoadSearchXml(sXml2, true);
					//기존 End
					//chungpa 20100111 신규 start
					sheetObjects[7].removeAll();
					sheetObjects[7].LoadSearchXml(sXml2, true);
					sheetObjects[7].Copy2SheetCol(
							sheetObjects[3]		//TargetSheet IBSheet 필수  붙여넣기 할 타겟 IBSheet 오브젝트 
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
				    
					// chungpa 20100126 Invoice Only 가 'U'로 보이나 'I'로 처리되는 오동작 패치 start
					var tmpFindRows = sheetObjects[3].FindStatusRow('I');
					if(tmpFindRows != "")
					{
						var tVars = tmpFindRows.split(";");	// 상태가 입력(I,U) 인 상태인 Row 추출
						for(var i=0; i < tVars.length -1; i++){
							//sheetObjects[3].cellValue2(tVars[i],"ibflag") = "U";
							sheetObjects[3].RowStatus(tVars[i])= "U";		//3.트랜잭션 상태 "U"로 만들기
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
	         			
	         			var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
	         			var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
	         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
		         		var lseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
		         		
		         		formObject.inv_smry_amt.value = ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);   
		         		formObject.pay_chg_smry_amt.value = ComCgmAmountFormat(lseChgAmt,2);
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
						var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
	         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
	         			var invCrAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
	         			
	         			formObject.lse_chg_amt.value = ComCgmAmountFormat(lseChgAmt,2);
	         			formObject.inv_lse_chg_amt.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         			formObject.diff.value = ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
					} else {
						formObject.lse_chg_amt.value = '0.00';
						formObject.inv_lse_chg_amt.value = '0.00';
		         		formObject.diff.value = '0.00';
					}	
	         		
	         		// Invoice Only Tab
	         		if(sheetObjects[3].RowCount > 0){
						var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
	         			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
	         			
	         			formObject.lse_chg_amt3.value = '0.00';
	         			formObject.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         			formObject.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
					} else {
						formObject.lse_chg_amt3.value = '0.00';
						formObject.inv_lse_chg_amt3.value = '0.00';
						formObject.diff3.value = '0.00';
					}
	         		sheetObjects[tabObjects[0].SelectedIndex].CheckAll(1) = 0;       //모두 선택 취소하기
	         		
					//전체 Save 한 후 Lessor Only 로 Back 한 Data 는 Add 된 Row 더라도 수정/삭제 가능하도록
	         		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
					t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
					//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.	
					break;
	
				case "btn_add":
					doActionIBSheet(sheetObject4,formObject,IBINSERT);
					break;
	
				case "btn_delete":
					doActionIBSheet(sheetObject4,formObject,IBRESET);
					break;
		
				case "btn_soCreate":
					if(validateForm(sheetObject4,formObject,IBCREATE) != false) {
						if(TAB_SAVE_STD){
							ComShowCodeMessage('CGM10079','Concidence');
	    					return;
						}
						
						doActionIBSheet(sheetObject1,formObject,IBCREATE);
					}
					break;
					
				case "btn_remove":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
        
        // 버튼 활성/비활성화  초기화
        doActionBtnEnable(tabObjects[0].SelectedIndex);	
        
        // vendor Name 가져오기
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);

        // Concidence, Despanc, Charge Only, Invoice Only 목록 가져오기
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		// 각 Tab 별 Save 상태값 저장 (false:비활성,true:활성)
		TAB_SAVE_STD = false;
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

	                var HeadTitle1 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Loc.|Off-hHire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,   "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter, true, "seq");
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true,	"eq_no",      		 false, "", dfNone,  	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_no",     		 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true,	"agmt_no",   		 false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	100,daCenter, true,	"inv_ref_no",   	 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"eq_tpsz_cd",  	     false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"lse_chg_aud_sts_cd",false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"chg_cd",   		 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd", 	 false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt",  		 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_bil_st_dt", 	 false, "", dfDateYmd, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd", 	 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt",  		 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_st_dt",	 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_end_dt",	 false, "", dfDateYmd,	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_eq_onh_loc_nm", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"inv_eq_offh_loc_nm",false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"inv_lse_use_dys",   false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_lse_rt_amt",    false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_tax_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_cr_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_lse_chg_amt",   false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"pay_chg_aud_rmk",	 false, "", dfNone, 	0, false, true);

					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					
				
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 0;
	    		}
	            break;

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

	                var HeadTitle1 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Loc.|Off-hHire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,   "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter, true, "seq");
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true,	"eq_no",      		 false, "", dfNone,  	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_no",     		 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true,	"agmt_no",   		 false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	100,daCenter, true,	"inv_ref_no",   	 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"eq_tpsz_cd",  	     false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"lse_chg_aud_sts_cd",false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"chg_cd",   		 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd", 	 false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt",  		 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_bil_st_dt", 	 false, "", dfDateYmd, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd", 	 false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt",  		 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_st_dt",	 false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_end_dt",	 false, "", dfDateYmd,	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_eq_onh_loc_nm", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"inv_eq_offh_loc_nm",false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"inv_lse_use_dys",   false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_lse_rt_amt",    false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_tax_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_cr_amt",   	 false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_lse_chg_amt",   false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"pay_chg_aud_rmk",	 false, "", dfNone, 	0, false, true);

					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 0;
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

	                var HeadTitle1 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Lo.|Off-Hire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Audit Result|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,   "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter, true, "seq");
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true, "eq_no",      		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true, "inv_no",     		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true, "agmt_no",   		  false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	100,daCenter, true, "inv_ref_no",   	  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true, "eq_tpsz_cd",  		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true, "lse_chg_aud_sts_cd", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"chg_cd",   		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd", 	  false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt",  		  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_bil_st_dt", 	  false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd", 	  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt",  		  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",   	  false, "", dfFloat, 	2, false, false);

					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",   	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_st_dt",	  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_end_dt",	  false, "", dfDateYmd,	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_eq_onh_loc_nm",  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"inv_eq_offh_loc_nm", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"inv_lse_use_dys",    false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_lse_rt_amt",     false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_tax_amt",   	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_cr_amt",    	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_lse_chg_amt",    false, "", dfFloat, 	2, false, false);
					
					InitDataProperty(0, cnt++ , dtData,	150, daLeft,  true, "intg_cd_val_dp_desc",false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"pay_chg_aud_rmk",	  false, "", dfNone, 	0, true, false);
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 0;
				}
	            break;

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

	                var HeadTitle1 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Rate|Charge\nTotal|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|||||";

	                var HeadTitle2 = "||Seq.|Chassis No.|Invoice No.|Agreement No.|Reference No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Billing Start\nDate|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle2 += "|Rate|Charge\nTotal|Start\nDate|End\nDate|On-Hire Lo.|Off-Hire Loc.|Used\nDays|Rate|Tax|Credit|Invoice\nTotal|Audit Result|Remark(s)|||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true,   "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter, true, "seq");
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true, "eq_no",      		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true, "inv_no",     		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true, "agmt_no",   		  false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	100,daCenter, true, "inv_ref_no",   	  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true, "eq_tpsz_cd",  		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true, "lse_chg_aud_sts_cd", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"chg_cd",   		  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd", 	  false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt",  		  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_bil_st_dt", 	  false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd", 	  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt",  		  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",   	  false, "", dfFloat, 	2, false, false);

					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",   	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_st_dt",	  false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_bil_end_dt",	  false, "", dfDateYmd,	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	70,	daCenter, true,	"inv_eq_onh_loc_nm",  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"inv_eq_offh_loc_nm", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"inv_lse_use_dys",    false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_lse_rt_amt",     false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"inv_tax_amt",   	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_cr_amt",    	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"inv_lse_chg_amt",    false, "", dfFloat, 	2, false, false);
					
					InitDataProperty(0, cnt++ , dtData,	150, daLeft,  true, "intg_cd_val_dp_desc",false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"pay_chg_aud_rmk",	  false, "", dfNone, 	0, true, false);
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");

					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 0;
				}
	            break;
	            
	        case "t3sheet1":
	        	with (sheetObj) {
	                // 높이 설정
	                style.height = 292;
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

	                var HeadTitle1 = "|Seq.|Chassis No.|Agreement No.|Type/\nSize|Audit\nStatus|Charge\nType|On-Hire Loc.|On-Hire Date|Off-Hire\nLoc.|Off-Hire\nDate";
	                HeadTitle1 += "|Used days|Rate|Charge\nTotal|Status|Event Date|";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter, true,   "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,  	30,	daCenter, true, "seq");
					InitDataProperty(0, cnt++ , dtData,	80,	daCenter, true,	"eq_no",   			  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	95,	daCenter, true,	"agmt_no", 			  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	45,	daCenter, true,	"eq_tpsz_cd",  	   	  false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,45,	daCenter, true,	"lse_chg_aud_sts_cd", false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,50,	daCenter, true,	"chg_cd",  			  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_loc_cd",      false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_onh_dt",  		  false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_loc_cd",     false, "", dfNone, 	0, false, false);

					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"eq_offh_dt", 		  false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daCenter, true,	"lse_use_dys",        false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	40,	daRight,  true,	"lse_rt_amt",   	  false, "", dfFloat, 	2, false, false);
					InitDataProperty(0, cnt++ , dtData,	55,	daRight,  true,	"lse_chg_amt",   	  false, "", dfFloat, 	2, false, false);

					InitDataProperty(0, cnt++ , dtData,	50,	daCenter, true,	"eq_aset_sts_cd",	  false, "", dfNone, 	0, false, false);
					InitDataProperty(0, cnt++ , dtData,	75,	daCenter, true,	"sts_evnt_dt",   	  false, "", dfDateYmd, 0, false, false);

					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					//InitDataCombo(0, "AuditStatus", "C|I|D", "C|I|D");
					//InitDataCombo(0, "ChargeType", "RTL|HON|HOF", "RTL|HON|HOF");

					WordWrap = true;
					CountPosition = 0;
				}
	            break;

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
	                    
	                var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
	                HeadTitle1 += "|Invoice|Invoice|Invoice|Invoice||||||||";
	                    		
	                var HeadTitle2 = "||Seq.|Customer\nChassis No.|SML Chassis No.|Invoice\nReference No.|Invoice No.|Charge\nType|Start Date|End Date|On-Hire\nLoc.|Off-Hire\nLoc.|Used Days|Rate|Tax|Credit|Invoice\nTotal";
	                HeadTitle2 += "|Yard|Event Date|Audit Result|Remark(s)||||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                    
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true, "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk",false, "", dfNone, 	 0, true, true);
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk",false, "", dfNone, 	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,   	30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,	 80, daCenter,	true, "inv_cust_eq_no",   	false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 80, daCenter,	true, "eq_no",   			false, "", dfNone, 	 0, false, true);
					InitDataProperty(0, cnt++ , dtData,	 95, daCenter,	true, "inv_ref_no",   		false, "", dfNone, 	 0, false, true);
											
					InitDataProperty(0, cnt++ , dtData,	 70, daCenter,	true, "inv_no", 	   		false, "", dfNone, 	 0, false, true);
					InitDataProperty(0, cnt++ , dtData, 55, daCenter,	true, "chg_cd",   			false, "", dfNone, 	 0, false, true, 3);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_bil_st_dt",  	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_bil_end_dt",	  	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_eq_onh_loc_nm", 	false, "", dfNone, 	 0, false, false);
											
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_eq_offh_loc_nm", false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 40, daCenter,	true, "inv_lse_use_dys",  	false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 40, daRight,	true, "inv_lse_rt_amt",   	false, "", dfFloat,  2, false, false);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_tax_amt",   		false, "", dfFloat,  2, false, true);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_cr_amt",   		false, "", dfFloat,  2, false, true);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_lse_chg_amt",  	false, "", dfFloat,  2, false, true);

					InitDataProperty(0, cnt++ , dtData,	 60, daCenter,	true, "aud_umch_eq_sts_evnt_yd_cd", false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "aud_umch_eq_sts_evnt_dt", 	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	150, daLeft,	true, "intg_cd_val_dp_desc", 		false, "", dfNone,	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,	true, "pay_chg_aud_rmk",			false, "", dfNone, 	 0, true, true);
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "lse_chg_aud_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "eq_tpsz_cd");
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					
					
					//InitDataCombo(0, "chg_cd", "CRD|TAX|PDM|RTL", "CRD|TAX|PDM|RTL"
					//		,'','',0,'','',"CRD|TAX|PDM");
		
					WordWrap = true;
					CountPosition = 0;
				}
	            break; 

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
	                    
	                var HeadTitle1 = "||Seq.|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice";
	                HeadTitle1 += "|Invoice|Invoice|Invoice|Invoice||||||||";
	                    		
	                var HeadTitle2 = "||Seq.|Customer\nChassis No.|SML Chassis No.|Invoice\nReference No.|Invoice No.|Charge\nType|Start Date|End Date|On-Hire\nLoc.|Off-Hire\nLoc.|Used Days|Rate|Tax|Credit|Invoice\nTotal";
	                HeadTitle2 += "|Yard|Event Date|Audit Result|Remark(s)||||||||";

					var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                    
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, true, "ibflag");
					//InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,false,	"del_chk",false, "", dfNone, 	 0, true, true);
					InitDataProperty(0, cnt++ , dtDummyCheck,		30,	daCenter,false,	"del_chk",false, "", dfNone, 	 0, true, true);
					InitDataProperty(0, cnt++ , dtDataSeq,   	30, daCenter,	true, "seq");
					InitDataProperty(0, cnt++ , dtData,	 80, daCenter,	true, "inv_cust_eq_no",   	false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 80, daCenter,	true, "eq_no",   			false, "", dfNone, 	 0, false, true);
					InitDataProperty(0, cnt++ , dtData,	 95, daCenter,	true, "inv_ref_no",   		false, "", dfNone, 	 0, false, true);
											
					InitDataProperty(0, cnt++ , dtData,	 70, daCenter,	true, "inv_no", 	   		false, "", dfNone, 	 0, false, true);
					InitDataProperty(0, cnt++ , dtData, 55, daCenter,	true, "chg_cd",   			false, "", dfNone, 	 0, false, true, 3);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_bil_st_dt",  	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_bil_end_dt",	  	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_eq_onh_loc_nm", 	false, "", dfNone, 	 0, false, false);
											
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "inv_eq_offh_loc_nm", false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 40, daCenter,	true, "inv_lse_use_dys",  	false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 40, daRight,	true, "inv_lse_rt_amt",   	false, "", dfFloat,  2, false, false);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_tax_amt",   		false, "", dfFloat,  2, false, true);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_cr_amt",   		false, "", dfFloat,  2, false, true);
					InitDataProperty(0, cnt++ , dtData,	 55, daRight,	true, "inv_lse_chg_amt",  	false, "", dfFloat,  2, false, true);

					InitDataProperty(0, cnt++ , dtData,	 60, daCenter,	true, "aud_umch_eq_sts_evnt_yd_cd", false, "", dfNone, 	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	 75, daCenter,	true, "aud_umch_eq_sts_evnt_dt", 	false, "", dfDateYmd,0, false, false);
					InitDataProperty(0, cnt++ , dtData,	150, daLeft,	true, "intg_cd_val_dp_desc", 		false, "", dfNone,	 0, false, false);
					InitDataProperty(0, cnt++ , dtData,	100, daLeft,	true, "pay_chg_aud_rmk",			false, "", dfNone, 	 0, true, true);
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "lse_chg_aud_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "eq_tpsz_cd");
					
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, true, "agmt_lstm_cd");
					InitDataProperty(0, cnt++ , dtHidden, 30, daCenter, 	true, "chg_seq");
					

					
					//InitDataCombo(0, "chg_cd", "CRD|TAX|PDM|RTL", "CRD|TAX|PDM|RTL"
					//		,'','',0,'','',"CRD|TAX|PDM");
		
					WordWrap = true;
					CountPosition = 0;
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
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOL	TIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter,	true, "ibflag");
				}
            
	        	break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	        
		switch(sAction) {
	    	case IBSEARCH:      //조회
	    		
		    	formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	     			     
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1031GS.do" , FormQueryString(formObj), '', true);
         		var arrXml = sXml.split("|$$|");
         		
         		// tab1 Sheet Object
         		sheetObjects[0].LoadSearchXml(arrXml[0]);
         		

         		
         		if(sheetObjects[0].RowCount > 0){
         			var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
         			var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         		var lseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
	         		
	         		formObj.inv_smry_amt.value = ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);  
	         		formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.tax_smry_amt.value = ComCgmAmountFormat(taxSmryAmt,2);
	         		formObj.cr_smry_amt.value = ComCgmAmountFormat(-1 * Math.abs(crSmryAmt),2);
         			
	         		// chungpa 20100105 back error fix start
	         		for(var i=2; i<2+sheetObjects[0].RowCount; i++)
	         		{
	         			if(sheetObjects[0].CellValue(i,"lse_chg_aud_sts_cd") == "C") //C만 고정.
	         				sheetObjects[0].CellEditable(i, "del_chk") = false;
	         		}
	         		// chungpa 20100105 back error fix end
         		} else {
         			formObj.inv_smry_amt.value = '0.00';  
	         		formObj.pay_chg_smry_amt.value = '0.00';
	         		formObj.tax_smry_amt.value = '0.00';
	         		formObj.cr_smry_amt.value = '0.00';
         		}
         		
         		// tab2 Sheet Object
         		sheetObjects[1].LoadSearchXml(arrXml[1]);
         		
         		if(sheetObjects[1].RowCount > 0){
         			var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
         			
	         		formObj.lse_chg_amt.value = ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff.value = ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt.value = '0.00';
	         		formObj.inv_lse_chg_amt.value = '0.00';
	         		formObj.diff.value = '0.00';
         		}
         		
         		// tab3 Sheet Object
         		sheetObjects[2].LoadSearchXml(arrXml[2]);
         		
         		if(sheetObjects[2].RowCount > 0){
         			var lseChgAmt = ComReplaceStr(sheetObjects[2].ComputeSum("|lse_chg_amt|"),',','');
         			
	         		formObj.lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt2.value = '0.00';
	         		formObj.diff2.value = ComCgmAmountFormat(lseChgAmt,2);
         		} else {
         			formObj.lse_chg_amt2.value = '0.00';
	         		formObj.inv_lse_chg_amt2.value = '0.00';
	         		formObj.diff2.value = '0.00';
         		}	
         		
         		// tab4 Sheet Object
         		sheetObjects[3].LoadSearchXml(arrXml[3]);
         		
         		if(sheetObjects[3].RowCount > 0){
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
         			
	         		formObj.lse_chg_amt3.value = '0.00';
	         		formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt3.value = '0.00';
	         		formObj.inv_lse_chg_amt3.value = '0.00';
	         		formObj.diff3.value = '0.00';
         		}
         		
         		ComOpenWait(false);
         		
				//Save하고 난 이후에도 lse_chg_aud_sts_cd가 null인 경우에는 편집 가능하게 설정한다. 
         		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.	
         		
         		break;

	    	case IBSAVE:        //저장
	            
		    	formObj.f_cmd.value = MULTI01;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	    	
	     		var strStatusRow = "";
	     		var sParam = "";
	         	/*
				if(tabObjects[0].SelectedIndex == 0){
					var sParam1 = sheetObjects[0].GetSaveString(false); 
					sParam = ComSetPrifix(sParam1, "t1sheet1");
					strStatusRow = sheetObjects[0].FindStatusRow("I|U");
				} else if(tabObjects[0].SelectedIndex == 1){
					var sParam2 = sheetObjects[1].GetSaveString(false);		
					sParam = ComSetPrifix(sParam2, "t2sheet1");
				} else if(tabObjects[0].SelectedIndex == 3){
					var sParam3 = sheetObjects[3].GetSaveString(false);
					sParam = ComSetPrifix(sParam3, "t4sheet1");
				}
				*/
	     		
	     		strStatusRow = sheetObjects[0].FindStatusRow("I|U");
	     		
	     		var sParam1 = sheetObjects[0].GetSaveString(false); 
				sParam = sParam + ComSetPrifix(sParam1, "t1sheet1");
				sParam = sParam + "&";
				
				var sParam2 = sheetObjects[1].GetSaveString(false);		
				sParam = sParam + ComSetPrifix(sParam2, "t2sheet1");
				sParam = sParam + "&";
				
				var sParam3 = sheetObjects[3].GetSaveString(false);
				sParam = sParam + ComSetPrifix(sParam3, "t4sheet1");
	     		
				sParam = sParam + "&";
				sParam = sParam + FormQueryString(formObj);
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);		
				
				var sXml = sheetObj.GetSaveXml("EES_CGM_1031GS.do", sParam);
				
				
				//if(tabObjects[0].SelectedIndex == 0){
				//	sheetObjects[0].LoadSaveXml(sXml);
					if(strStatusRow != ''){
						var arrStatusRow = strStatusRow.split(';');
						for(var i=0; i < arrStatusRow.length -1; i++){
							sheetObjects[0].cellValue2(arrStatusRow[i],"ibflag") = "I";
							sheetObjects[0].CellEditable(arrStatusRow[i],"pay_chg_aud_rmk") = true;
						}	
					}
				//} else if(tabObjects[0].SelectedIndex == 1){
				//	sheetObjects[1].LoadSaveXml(sXml);
				//} else if(tabObjects[0].SelectedIndex == 3){
					sheetObjects[3].LoadSaveXml(sXml);
				//}
	    		
				ComOpenWait(false);
				
				//Save하고 난 이후에도 lse_chg_aud_sts_cd가 null인 경우에는 편집 가능하게 설정한다. 
         		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
				t4sheet1_enableEditingWhenLseChgAudStsCdIsNull();
				//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.					
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
				
	     		var sXml = sheetObjects[0].GetSaveXml("EES_CGM_1031GS.do", sParam);
	     		sheetObjects[2].LoadSaveXml(sXml);
	     		
				ComOpenWait(false);	
				
	     		if(strStatusRow != ''){
					var arrStatusRow = strStatusRow.split(';');
					for(var i=0; i < arrStatusRow.length -1; i++){
						sheetObjects[0].cellValue2(arrStatusRow[i],"ibflag") = "I";
						sheetObjects[0].CellEditable(arrStatusRow[i],"pay_chg_aud_rmk") = true;
					}	
				}
	     		
	    		break;
	    		
	    	case IBDELETE:
	    		formObj.f_cmd.value = REMOVE;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	     		
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);	
				
	     		var sXml = sheetObjects[0].GetSaveXml("EES_CGM_1031GS.do", FormQueryString(formObj));
	     			
	     		var arrXml = sXml.split("|$$|");
         		
         		// tab1 Sheet Object
	     		//sheetObjects[4].LoadSaveXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");	// Hidden Sheet 를 사용하기 위해 
         		sheetObjects[0].LoadSaveXml(arrXml[0]);
         		
         		if(sheetObjects[0].RowCount > 0){
         			var taxSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_tax_amt|"),',',''));
         			var crSmryAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_cr_amt|"),',',''));
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|inv_lse_chg_amt|"),',',''));
	         		var lseChgAmt = Number(ComReplaceStr(sheetObjects[0].ComputeSum("|lse_chg_amt|"),',',''));
	         		
	         		formObj.inv_smry_amt.value = ComCgmAmountFormat(invLseChgAmt + taxSmryAmt - Math.abs(crSmryAmt),2);  
	         		formObj.pay_chg_smry_amt.value = ComCgmAmountFormat(lseChgAmt,2);
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
         			var lseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|lse_chg_amt|"),',',''));
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt = Number(ComReplaceStr(sheetObjects[1].ComputeSum("|inv_cr_amt|"),',',''));
         			
	         		formObj.lse_chg_amt.value = ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff.value = ComCgmAmountFormat(lseChgAmt - (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt.value = '0.00';
	         		formObj.inv_lse_chg_amt.value = '0.00';
	         		formObj.diff.value = '0.00';
         		}
         		
         		// tab3 Sheet Object
         		sheetObjects[2].LoadSearchXml(arrXml[2]);
         		
         		if(sheetObjects[2].RowCount > 0){
         			var lseChgAmt = ComReplaceStr(sheetObjects[2].ComputeSum("|lse_chg_amt|"),',','');
         			
	         		formObj.lse_chg_amt2.value = ComCgmAmountFormat(lseChgAmt,2);
	         		formObj.inv_lse_chg_amt2.value = '0.00';
	         		formObj.diff2.value = ComCgmAmountFormat(lseChgAmt,2);
         		} else {
         			formObj.lse_chg_amt2.value = '0.00';
	         		formObj.inv_lse_chg_amt2.value = '0.00';
	         		formObj.diff2.value = '0.00';
         		}	
         		
         		// tab4 Sheet Object
         		sheetObjects[3].LoadSearchXml(arrXml[3]);
         		
         		if(sheetObjects[3].RowCount > 0){
         			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
         			
	         		formObj.lse_chg_amt3.value = '0.00';
	         		formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
         		} else {
         			formObj.lse_chg_amt3.value = '0.00';
	         		formObj.inv_lse_chg_amt3.value = '0.00';
	         		formObj.diff3.value = '0.00';
         		}	
	         		
         		ComOpenWait(false);	
	     		
	    		break;

	    	case IBINSERT:      // 행추가
	    		var newRow = sheetObj.DataInsert(-1);
	    		/*실시간 combobox 적용 start*/
	    		sheetObj.InitCellProperty(newRow,"chg_cd",dtComboEdit);
                sheetObj.CellComboItem(newRow, "chg_cd", "CRD|TAX|PDM","CRD|TAX|PDM");
	    		sheetObj.cellValue2(newRow, "chg_cd") = "CRD";
	    		/*실시간 combobox 적용 end*/
	    		
	    		//cost_yrmon_seq value setting 
	    		//sheetObj.cellValue2(newRow, "cost_yrmon_seq") 	= document.form.parent_cost_yrmon_seq.value;
	    		sheetObj.cellValue2(newRow, "agmt_no") 			= document.form.parent_agmt_ofc_cty_cd.value + document.form.parent_agmt_seq.value;
	    		sheetObj.cellValue2(newRow, "inv_ref_no") 		= document.form.parent_agmt_ref_no.value;
	    		sheetObj.cellValue2(newRow, "inv_no") 			= document.form.parent_inv_no.value;	    		
	    		
	    		sheetObj.CellEditable(newRow, "eq_no") = false;
	    		
	    		TAB_SAVE_STD = true;	// Save 버튼 활성화
	    		doActionBtnEnable(tabObjects[0].SelectedIndex);	   		
	    		
	    		// Invoice Only 의 Charge Type 에 따라 입력항목 활성/비활성 설정
	    		sheetObj.CellEditable(newRow, "inv_cr_amt") = true;
	    		sheetObj.CellEditable(newRow, "inv_tax_amt") = false; 
	    		sheetObj.CellEditable(newRow, "inv_lse_chg_amt") = false; 
	    		
	            break;
	            
	    	case IBRESET:	 	// 행삭제
	    		
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
	    					}
	    					break;
	    				}
	    			}
	    		}	    		
	    		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.
	    		
	    		//chungpa 20100111 전체 save후 co-in back한 데이터(이건 'R') 중 lse_chg_aud_sts_cd is null인 것은 delete가능하게. start
	    		var checkDeleteStatus = false;
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

	    		// 삭제처리 후 Invoice Only 탭의 각 Row의 상태가 (I,U)일  경우 save 버튼 비활성화
	    		if(sheetObj.FindStatusRow("I|U")=='' && sheetObjects[1].FindStatusRow("I|U")=='' && sheetObjects[0].FindStatusRow("I")==''){
	    			TAB_SAVE_STD = false;	// Save 버튼 활성화
	    			doActionBtnEnable(tabObjects[0].SelectedIndex);	
	    		}
	    		
	    		// Invoice Only 의 계산식
	    		if(sheetObjects[3].RowCount > 0){
	    			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
         			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
         			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
         			
	         		formObj.lse_chg_amt3.value = '0.00';
	         		formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
	         		formObj.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
				} else {
					formObj.lse_chg_amt3.value = '0.00';
					formObj.inv_lse_chg_amt3.value = '0.00';
					formObj.diff3.value = '0.00';
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
	        	
	    	case IBDOWNEXCEL:
	    		sheetObj.SpeedDown2Excel(1,false,true,"","",false,false,"",true,"del_chk");
	    		break;
	    		
	    }
	}
	
	/**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.09
     */	
    function doActionBtnEnable (tabIndex){
    	
    	var formObj = document.form; 
    	
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
    	
    	// 현재의 Charge Header의 상태값이 C (P.Amt Confirm) 일 경우
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
    	 
    	switch(tabIndex){
    		case 0:	// Tab Index = 0
    			ComBtnDisable("btn_coin");
    			ComBtnEnable("btn_coin_back");
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
    			ComBtnDisable("btn_coin");
    			ComBtnDisable("btn_coin_back");
    			ComBtnDisable("btn_soCreate");
    			ComBtnDisable("btn_remove");
    			if(TAB_SAVE_STD){
    				ComBtnEnable("btn_save");
    			} else {
    				ComBtnDisable("btn_save");
    			}
    			break;
    			
    		case 3:	// Tab Index = 3
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
	                InsertTab( cnt++ , "SML Only" , -1 );
	                InsertTab( cnt++ , "Lessor Only" , -1 );

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
        	
        		if(tabObjects[0].SelectedIndex == 3){
	        		var strStatusRows = sheetObj.FindStatusRow("I");
	        		var arrStatusRows = strStatusRows.split(";");
	        	
	        		// Invoice Only Tab 에서 필수입력항목 체크한다
	        		for(var i=0; i<arrStatusRows.length-1; i++){
	        			
	        			if(sheetObj.cellValue(arrStatusRows[i],"chg_cd") == 'PDM'){
	        				if(ComTrim(sheetObj.cellValue(arrStatusRows[i],"eq_no"))==""){
	        					ComShowCodeMessage('CGM10004','SML Chassis No.');
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
	        		}
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
 
	/**
	 * sheet Object (Discrepancy) 의 click 이벤트를 정의한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	 
	function t1sheet1_OnChange(sheetObj, Row, Col, Value)  {
		
		if(sheetObj.ColSaveName(Col) == 'pay_chg_aud_rmk'){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
		
	/**
	 * sheet Object (Discrepancy) 의 click 이벤트를 정의한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	 
	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
		
		if(sheetObj.ColSaveName(Col) == 'pay_chg_aud_rmk'){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
	 
	/**
	 * sheet Object (Invoice Only) 의 click 이벤트를 정의한다. <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.09
	 */	 
	function t4sheet1_OnChange(sheetObj, Row, Col, Value)  {
		 
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
		if(sheetObj.ColSaveName(Col) == "chg_cd"){
			if(sheetObj.cellValue(Row, "chg_cd") == 'CRD'){
				
				sheetObj.CellEditable(Row, "eq_no") = false;
				sheetObj.CellEditable(Row, "inv_cr_amt") = true;
				sheetObj.CellEditable(Row, "inv_tax_amt") = false;
				sheetObj.CellEditable(Row, "inv_lse_chg_amt") = false;
				
				sheetObj.cellValue2(Row, "inv_tax_amt") = 0;
				sheetObj.cellValue2(Row, "inv_lse_chg_amt") = 0;
				
			} else if(sheetObj.cellValue(Row, "chg_cd") == 'TAX'){
				
				sheetObj.CellEditable(Row, "eq_no") = false;
				sheetObj.CellEditable(Row, "inv_cr_amt") = false;
				sheetObj.CellEditable(Row, "inv_tax_amt") = true;
				sheetObj.CellEditable(Row, "inv_lse_chg_amt") = false;
				
				sheetObj.cellValue2(Row, "inv_cr_amt") = 0;
				sheetObj.cellValue2(Row, "inv_lse_chg_amt") = 0;
				
			} else if(sheetObj.cellValue(Row, "chg_cd") == 'PDM'){
				
				sheetObj.CellEditable(Row, "eq_no") = true;
				sheetObj.CellEditable(Row, "inv_cr_amt") = false;
				sheetObj.CellEditable(Row, "inv_tax_amt") = false;
				sheetObj.CellEditable(Row, "inv_lse_chg_amt") = true;
				
				sheetObj.cellValue2(Row, "inv_cr_amt") = 0;
				sheetObj.cellValue2(Row, "inv_tax_amt") = 0;
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
			
			var invLseChgAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_lse_chg_amt|"),',',''));
 			var invTaxAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_tax_amt|"),',',''));
 			var invCrAmt = Number(ComReplaceStr(sheetObjects[3].ComputeSum("|inv_cr_amt|"),',',''));
 			
 			formObj.lse_chg_amt3.value = '0.00';
     		formObj.inv_lse_chg_amt3.value = ComCgmAmountFormat(invLseChgAmt + invTaxAmt - Math.abs(invCrAmt),2);
     		formObj.diff3.value = ComCgmAmountFormat( -1 * (invLseChgAmt + invTaxAmt - Math.abs(invCrAmt)),2);
		}
		
		// 기본 Row의 데이터를 수정할 경우 Save 버튼 활성화 처리
		if(sheetObj.ColSaveName(Col) == "pay_chg_aud_rmk"){
			TAB_SAVE_STD = true;	// Save 버튼 활성화
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
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
		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.		
		
		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null start.
		if(sheetObj.ColSaveName(Col) == "del_chk" ){
			//Row delte에서 처리함.
		}
		//chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null end.
		
		//chungpa 20091223 check inv no,inv ref no
		t4sheet1_ChkInvNo(sheetObj,Row,Col,Value);
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
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}
	 
	/**
	 * Sheet1 의 OnSaveEnd (P.Amt Confirm) 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.10
	 */ 
	function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			document.form.lse_chg_sts_cd.value='S';
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
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
			TAB_SAVE_STD = false;	// Save 버튼 비활성화
			document.form.lse_chg_sts_cd.value='A';
			doActionBtnEnable(tabObjects[0].SelectedIndex);	
		}
	}	 
	 
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
    function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	var formObj = document.form;
    	if(Col == 3) // chassis
    	{
      		var eqNo = sheetObj.CellValue(Row,Col);
    		if(eqNo != "")
    		{
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);    			
    		}
    	}
    }
    /**
     * t2sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 조재성
     * @version 2009.12.16
     */      
    function t2sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	if(Col == 3) // chassis
    	{
      		var eqNo = sheetObj.CellValue(Row,Col);
    		if(eqNo != "")
    		{
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);    			
    		}
    	}	
    }
    /**
     * t3sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 조재성
     * @version 2009.12.16
     */      
    function t3sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
     	if(Col == 2) // chassis
    	{
      		var eqNo = sheetObj.CellValue(Row,Col);
    		if(eqNo != "")
    		{
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);    			
    		}
    	}
    }
    /**
     * t4sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
     * @author 조재성
     * @version 2009.12.16
     */      
    function t4sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
       	if(Col == 3) // Customer chassis
    	{
      		var eqNo = sheetObj.CellValue(Row,Col);
    		if(eqNo != "")
    		{
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);    			
    		}
    	}else if(Col == 4) // SML chassis
    	{
      		var eqNo = sheetObj.CellValue(Row,Col);
    		if(eqNo != "")
    		{
  		  		var pgmNo = 'EES_CGM_1003';
  		  		var pgmUrl = '/hanjin/EES_CGM_1003.do';
  		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
  		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+eqNo ;   
  		    	ComOpenPopup("alpsMain.screen?parentPgmNo="+parentPgmNo+src, 1024, 700, "", "1,0", true, false);    			
    		}
    	}
    }    
     
     
    /**
     * Sheet4 의 cell을 edit 할 경우 <br>
     * @author 조재성
     * @version 2009.08.12
     */   
    function t4sheet1_ChkInvNo(sheetObj, Row, Col,Value)
    {
    	var formObj = document.form;
    	var t1sheet1 = sheetObjects[0];
    	var t2sheet1 = sheetObjects[1];
    	var t3sheet1 = sheetObjects[2];
    	var t4sheet1 = sheetObjects[3];
    	
    	var target = sheetObj.CellValue(Row,Col);
    	if(target == null || target == "")	return;
		
    	if(Col == 5) // Invoice Reference No.
    	{
    		//check.
    		//sheet1
    		for(var i=0; i< t1sheet1.RowCount-1; i++) //RowCount-1 의 이유> 방금 add된 데이터라 비교하면 안됨.
    		{
    			if(target == t1sheet1.CellValue(i+2, 6) ) // i+2의 이유> 헤더가 2Row를 차지한다. 
    			{
    				return true;
    			}
    		}    		
    		//sheet2    		
    		for(var i=0; i< t2sheet1.RowCount-1; i++)
    		{
    			if(target == t2sheet1.CellValue(i+2, 6) )
    			{
    				return true;
    			}
    		}
    		//sheet4    		
    		for(var i=0; i< t4sheet1.RowCount-1; i++)
    		{
    			if(target == t4sheet1.CellValue(i+2, 5) )
    			{
    				return true;
    			}
    		}
    		ComShowCodeMessage("CGM20023", "Invoice Reference No.("+target+")");    		
    		sheetObj.CellValue2(Row,Col) = "";
    		return false;
    	}else if(Col == 6) // Invoice No.
    	{
    		if(t4sheet1.CellValue(Row, 7) != "CRD") // CRD체크
    		{
	    		//check.
	    		for(var i=0; i< t1sheet1.RowCount-1; i++)
	    		{
	    			if(target == t1sheet1.CellValue(i+2, 4) )
	    			{
	    				return true;
	    			}
	    		}    		
	    		for(var i=0; i< t2sheet1.RowCount-1; i++)
	    		{
	    			if(target == t2sheet1.CellValue(i+2, 4) )
	    			{
	    				return true;
	    			}
	    		}    		
	    		for(var i=0; i< t4sheet1.RowCount-1; i++)
	    		{
	    			if(target == t4sheet1.CellValue(i+2, 6) )
	    			{
	    				return true;
	    			}
	    		}
	    		ComShowCodeMessage("CGM20023", "Invoice No.("+target+")");
	    		sheetObj.CellValue2(Row,Col) = "";
	    		return false;
    		}else
    		{
    			return true; //CRD이면 invoice no 체크 안함.
    		}
    	}
    }
     
 /**
  * Save하고 난 이후에도 lse_chg_aud_sts_cd가 null인 경우에는 편집 가능하게 설정한다. <br> 
  * chungpa 20100104 cell editable when lse_chg_aud_sts_cd is null
  *
  * @author 조재성
  * @version 2010.01.04
  */   
 function t4sheet1_enableEditingWhenLseChgAudStsCdIsNull(sheetObj, Row, Col,Value)
 {     
	sheetObjects[3].Editable = true;
	for(var i=2; i<2+sheetObjects[3].RowCount; i++)
	{
		if(sheetObjects[3].cellvalue(i,"lse_chg_aud_sts_cd") == '')
		{
			sheetObjects[3].RowEditable(i) = true;
			
    		// Invoice Only 의 Charge Type 에 따라 입력항목 활성/비활성 설정
			if(sheetObjects[3].cellValue(i, "chg_cd") == 'CRD'){
				sheetObjects[3].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
				sheetObjects[3].CellEditable(i, "inv_ref_no") = true;
				sheetObjects[3].CellEditable(i, "inv_no") = true;
				sheetObjects[3].CellEditable(i, "eq_no") = false;
				sheetObjects[3].CellEditable(i, "inv_cr_amt") = true;
				sheetObjects[3].CellEditable(i, "inv_tax_amt") = false;
				sheetObjects[3].CellEditable(i, "inv_lse_chg_amt") = false;
			} else if(sheetObjects[3].cellValue(i, "chg_cd") == 'TAX'){
				sheetObjects[3].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
				sheetObjects[3].CellEditable(i, "inv_ref_no") = true;
				sheetObjects[3].CellEditable(i, "inv_no") = true;
				sheetObjects[3].CellEditable(i, "eq_no") = false;
				sheetObjects[3].CellEditable(i, "inv_cr_amt") = false;
				sheetObjects[3].CellEditable(i, "inv_tax_amt") = true;
				sheetObjects[3].CellEditable(i, "inv_lse_chg_amt") = false;
			} else if(sheetObjects[3].cellValue(i, "chg_cd") == 'PDM'){
				sheetObjects[3].CellEditable(i, "chg_cd") = false; //  원래 chg_cd는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
				sheetObjects[3].CellEditable(i, "inv_ref_no") = true;
				sheetObjects[3].CellEditable(i, "inv_no") = true;
				sheetObjects[3].CellEditable(i, "eq_no") = false; // PDM일때 원래 eq_no는 수정가능해야 하나, 키이기 때문에 수정불가능으로 표시함.
				sheetObjects[3].CellEditable(i, "inv_cr_amt") = false;
				sheetObjects[3].CellEditable(i, "inv_tax_amt") = false;
				sheetObjects[3].CellEditable(i, "inv_lse_chg_amt") = true;
			}
    		/*실시간 combobox 적용 start*/ //키이기 때문에 콤보박스 구성 안 해줌.
			//sheetObjects[3].InitCellProperty(i,"chg_cd",dtComboEdit);
			//sheetObjects[3].CellComboItem(i, "chg_cd", "CRD|TAX|PDM","CRD|TAX|PDM");
			
    		/*실시간 combobox 적용 end*/
    		doActionBtnEnable(tabObjects[0].SelectedIndex);	  
		}	
		else
		{
			//기존 데이터는 편집 불가.
			//sheetObjects[3].RowEditable(i) = false;
		}
	}
 }
	/* 개발자 작업  끝 */