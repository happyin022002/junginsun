/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0014.js
*@FileTitle  : Port charge Invoice Creation ( Invoice > Port charge Invoice Creation ) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_PSO_0014 : business script for VOP_PSO_0014
     */
 
    //public variable
    var sheetObjects				= new Array();
    var sheetCnt					= 0;
    var vndrLglEngNm				= {};//Vendor English Name
    var vndrEngNm					= {};// vendor.vndr_eng_nm
    var tmnlName					= {};//TerminalName
    var costOfc						= {};//CostOffice
    var currCdList					= {};
    var VALIDVVD					= 0;//Flag about invalid VVD
    var gCurrCd						= "";//CurrencyCD of Login User
    var isRClick					= false;//Retrieve flag
    var trxnStats					= new Array();//in case Calculation Button Click, Saving original TRXN state
    var g_isExist					= false;
    var g_isEnterKey				= false;
    var isExistInvNo				= false;
    var leftHeaders 				= [{Text:"Value", Align:"Center"}];
    //NYK Modify 2014.11.03
    var vndrLglEngNmCostCd 			= {};
    var costCdByAccCdList 			= {};
	var accCdByCostCdList 			= {};
	var canalVndrLglEngNmCostCd 	= {};
    var canalCostCdByAccCdList 		= {};
	var canalAccCdByCostCdList 		= {};
	
	//NYK Modify 2014.11.03
	var comboItemsAccountCode		= "";
	var comboItemsAccountText		= "";
	var comboItemsCostCode			= "";
	var comboItemsCostText 			="";
	var comboItemsCanalAccountCode	= "";
	var comboItemsCanalAccountText	= "";
	var comboItemsCanalCostCode		= "";
	var comboItemsCanalCostText 	= "";
	var canalComboDataAll 			= "";//2016.01.13 Add
	
	var oldSpcode 					= "";
	var oldInvNo 					= "";	

	var comboObjects = new Array();
	var comboCnt = 0;
	
//    var g_DefaulDataRowHeight = 20;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return; // 버튼 상태를 확인을 합니다.
    		var srcObj=window.event.srcElement;
	        switch (srcName) {
	        	case "btn_Confirm":
	        	    //환율이 존재한지 체크.
                    if(!f_ExistsExchangeRateYn()){
                        //Yes 누르면 저장할 수 있고요. 아니면 멈춤.
                        if(!ComShowCodeConfirm("PSO01007")){
                            return;
                        }
                    }
                    
	        	    if(!checkCurrency()) return;
                    
	        		//NYK Modify 2014.10.08 INV. Amt == Sheet Total Amount 비교 추가.
	        		if(!checkInvoiceAmount()) return;
	        		
	        		//Adjustment Cost에 입력을 한 경우 Remark 항목 강제 입력 Check.
					if(!checkRemarks()) return;
					
					//AR_MST_REV_VVD Checked.
					if(!checkArMasterRevenueVvd()) return;
					
	        		//for Child Updating
					if(sheetObjects[0].RowCount()> 0 ){
						sheetObjects[1].SetRowStatus(1,"U");
					}
					formObject.updateflag.value		= isRClick;
					formObject.iss_cty_cd.value		= sheetObjects[0].GetCellValue(1, "sheet1_iss_cty_cd");
					formObject.so_seq.value			= sheetObjects[0].GetCellValue(1, "sheet1_so_seq");
	        		formObject.cost_ofc_cd.value	= formObject.cost_ofc.value;
	        			        		
                    
	        		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
	        		break;
		        case "btns_calendar_s":
		        	var cal=new ComCalendar();
		        	cal.setDisplayType('date');
		            //cal.setEndFunction("initCalIssueDate");
		        	cal.select(formObject.iss_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_calendar_r":
		        	var cal=new ComCalendar();
		        	cal.setDisplayType('date');
		        	cal.select(formObject.rcv_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_calendar_e":
		        	var cal=new ComCalendar();
		        	cal.setDisplayType('date');
		        	cal.select(formObject.eff_dt, 'yyyy-MM-dd');
		        	break;
		        case "btns_search"://S/P Code Button 
		        	ComOpenPopup('/opuscntr/VOP_PSO_0205.do', 600, 470, 'setServiceProviderInfo', '0,0', true, true);
		        	break;
		        case "btn_search_cost_ofc"://Cost Office 
					var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
					var classId	= "COM_ENS_071";
					var param	= '?classId='+classId;
					var chkStr	= dispaly.substring(0,3)
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/opuscntr/COM_ENS_071.do' + param,  770,  500, 'getOfcCd', dispaly, true);
					} else {
						return;
					}
			        break;
				case "btn_Retrieve":
					sheetObject1.SetEditable(1);
					formObject.inv_amt.value	="";
					formObject.vat.value		="";
					doActionIBSheet(sheetObject1, document.form, IBSEARCH);
					isRClick=true;
					break;
				case "btn_New":
					ComBtnEnable("btn_Save");
					ComBtnDisable("btn_Confirm");
					ComBtnDisable("btn_Delete");
					ComBtnEnable("btn_RowAdd");
					ComBtnEnable("btn_RowDelete");
					ComBtnEnable("btn_Calculation");
					document.getElementById("btn_Delete").innerHTML="Delete";
					
					formObject.reset();
					ComHiddenResetAll();
					
					ComSetObjValue(formObject.cnt_cd, gCntCd);
					ComSetObjValue(formObject.usr_id, gUsrId);
					
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject1.SetEditable(1);
					InitHeadColumn(leftHeaders, sheetObject2);
					
					setTerminalInfo("DFT_COST");

					setToday(document.form.iss_dt, 'ymd');
					setToday(document.form.rcv_dt, 'ymd');
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
					isRClick		=false;
					isExistInvNo 	= false;
					oldSpcode 		= "";
					oldInvNo 		= "";
					break;
				case "btn_Save":
					if(!checkServiceProvider()) return;
					
					if(!validateDetailForm(document.form, sheetObject1)) return;
					
					//NYK Modify 2014.10.08
					//if(!checkInvoiceAmount()) return;
					if(!checkIoChk()) return;
					
                    //환율이 존재한지 체크.
                    if(!f_ExistsExchangeRateYn()){
                        //Yes 누르면 저장할 수 있고요. 아니면 멈춤.
                        if(!ComShowCodeConfirm("PSO01007")){
                            return;
                        }
                    }
					
                    //Detail 이 존재 할때만 체크 한다.(Master만 저장 할 수 있으므로 체크 필요)
                    if(sheetObject1.RowCount() > 0){
                        //AR_MST_REV_VVD Checked.
                        if(!checkArMasterRevenueVvd()) return;
                    }
                    
					if(!checkCurrency()) return;
					

                    //NYK Modify 2014.10.08
                    //Adjustment Cost에 입력을 한 경우 Remark 항목 강제 입력 Check.
                    if(!checkRemarks()) return;
					                    
                    formObject.updateflag.value=isRClick;
					//var trxCnt = sheetObjects[0].RowCount("I")*1+sheetObjects[0].RowCount("U")*1+sheetObjects[0].RowCount("D")*1 
					for(var i=sheetObject1.HeaderRows(); i<=sheetObject1.RowCount(); i++){
						if(sheetObject1.GetCellValue(i, "sheet1_ibflag") == "" || sheetObject1.GetCellValue(i, "sheet1_ibflag") == "R"){
							sheetObject1.SetRowStatus(i,"U");
						}
					}
					//return;
					//}
					
										
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					break;
					
				case "btn_RowAdd":
					if(!validateForm(sheetObject1,document.form,IBSEARCH)) return;//Checking Inv_no is exist
					sheetObject1.DataInsert(-1);
					sheetObject1.SelectCell(sheetObject1.GetSelectRow(), "sheet1_vvd");//3);
					VALIDVVD=0;//flag clear .
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_vndr_seq",formObject.spcode.value,0);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_yd_cd",formObject.yd_cd.value,0);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_usr_id",formObject.usr_id.value,0);
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_inv_no",formObject.inv_no.value,0);
					
					var tmpCurrCd = formObject.curr_cd.value;
					//var tmpCurrCd = curr_cd.GetSelectCode();
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_curr_cd", tmpCurrCd,0);
					//sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_curr_cd",tmpCurrCd,0); //2016.08.09 Add
					
					//cLEAR
					formObject.vvdband.value="";
					formObject.atd.value=""; 
					formObject.calc_amt_vvd.value="";
					break;
					
				case "btn_RowDelete":
					for( var i=sheetObject1.LastRow(); i>=sheetObject1.HeaderRows(); i-- ) {
						if(sheetObject1.GetCellValue(i, "sheet1_del_chk") == 1){
							//sheetObject1.RowDelete(i, 0);
							sheetObject1.SetRowHidden(i, 1);
							sheetObject1.SetRowStatus(i,"D");
						}
					} 
					/*if(sheetObject1.RowCount("D") > 0 ){
						sheetObject1.RemoveAll();
						formObject.vvdband.value="";
						formObject.atd.value=""; 
						formObject.calc_amt_vvd.value="";
						formObject.calc_amt_ttl.value="";
					}*/
					
					sheetObject1.ShowSum();
					
					setCalcAmtVvd();
					
					
					break;
				case "btn_Delete":
					formObject.isdelete.value='Y';
					formObject.cost_ofc_cd.value=formObject.cost_ofc.value; 
	        		
	        		if("Y" == formObject.existDtlYn.value && sheetObject1.RowCount() > 0){ 
	        			formObject.iss_cty_cd.value=sheetObject1.GetCellValue(1, "sheet1_iss_cty_cd");
	        			formObject.so_seq.value=sheetObject1.GetCellValue(1, "sheet1_so_seq");
						for(var i=sheetObject1.HeaderRows(); i<sheetObject1.RowCount()+sheetObject1.HeaderRows(); i++){
							sheetObject1.SetRowStatus(i,"D");
						}
	        		}
					//Deleting data with set information
					doActionIBSheet(sheetObject1, document.form, IBDELETE);
					break;
					
				case "btn_Calculation":
					var exec=0;
					var tmpInvCurrcd = ComGetObjValue(formObject.curr_cd);
					//trxnStats
					for(var i=sheetObject1.HeaderRows(); i<sheetObject1.RowCount()+sheetObject1.HeaderRows(); i++){
					    
						trxnStats[i]=sheetObject1.GetCellValue(i, "sheet1_ibflag");
						//trxnStats[i] = sheetObject1.RowStatus(i);
						if(sheetObject1.GetCellValue(i, "sheet1_del_chk")==0){//flag clear
							sheetObject1.SetRowStatus(i,"I");
						}
						if(sheetObject1.GetCellValue(i, "sheet1_del_chk")==1){
							exec++;
							
							//invoice currency setting
	                        sheetObject1.SetCellValue(i, "sheet1_curr_cd", tmpInvCurrcd, 0);
						}
					} 
					if(exec == 0){
						ComShowCodeMessage('PSO01006');
						return;
					}	
					//--> Calculation again
					doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC07);
					for(var i=sheetObject1.HeaderRows(); i<sheetObject1.RowCount()+sheetObject1.HeaderRows(); i++){
						sheetObject1.SetRowStatus(i,trxnStats[i]);
					}
					break;
				case "cbx_night":     
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_night",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_holiday":   
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_holiday",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_boat":      
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_boat",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_tugrope":   
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_tugrope",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_buoy":      
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_buoy",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_sanitation":
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_sanitation",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_barge":     
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_barge",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_inspection":
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_inspection",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_newservice":
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_newservice",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_copilot":
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_copilot",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
				case "cbx_others":  //2015.02.10 ADD   
					sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_others",srcObj.checked == 1 ? "Y":"N"  ,0);
					break;
			} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * Checking Invoice Amount value is same as sum of grid amount + VAT
     * @modified : (Invoice Amt) = (Grid Amt) + (V.A.T.)
     *             TTL_LOCL_AMT == LOCL_NET_AMT
     */
    function checkInvoiceAmount(){
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 var invAmt=formObj.inv_amt.value == '' ? 0 : formObj.inv_amt.value.replace(/,/g, '')*1;
    	 var chkamt=sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")*1 + (formObj.vat.value.replace(/,/g, '') == '' ? 0 : formObj.vat.value.replace(/,/g, '')*1);
    	 if(sheetObj.RowCount()== 0) return false;
		 if(formObj.vat.value == ""){
			formObj.vat.value=0;
		 }		
		 if(formObj.whld_tax.value == ""){
			formObj.whld_tax.value=0;
		 }
		 var netAmt=sheetObj.RowCount()> 0 ? sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount") : 0;	//Grid
    	 	 netAmt=Number(netAmt);
    	 var vatAmt=formObj.vat.value == '' ? 0 : formObj.vat.value.replace(/,/g, '');					//V.A.T.
    	 	 vatAmt=Number(vatAmt);
    	 var wtAmt=formObj.whld_tax.value == '' ? 0 : formObj.whld_tax.value.replace(/,/g, '');			//Withholding Tax
    	     wtAmt=Number(wtAmt);
    	 //alert(">> " + "invAmt=" + invAmt + ", netAmt=" + netAmt + ", vatAmt=" + vatAmt + ", wtAmt=" + wtAmt);
    	 //return false;
    	 var ttlLoclAmt=0;
    	 var netLoclAmt=0;
    	 var ddtLoclAmt=0;
    	 for(i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
    		 var amount=Number(sheetObj.GetCellValue(i, "sheet1_amount"));
    		 if(amount > 0){
    			 netLoclAmt += amount;
    		 } else{
    			 ddtLoclAmt += amount;
    		 }
    	 }
    	 formObj.ttl_loc_amt.value=netAmt;	//invAmt - vatAmt;
    	 formObj.net_amt.value=netAmt;
    	 formObj.ddt_amt.value=ddtLoclAmt * -1;
    	 /*
    	 if(vatAmt != 0 && wtAmt != 0){
    		 ComShowCodeMessage("PSO00042");
    		 return false;
    	 }*/	 
    	 //ASCHOI
    	 if(invAmt == (netAmt + vatAmt - wtAmt).toFixed(2)){
    		 return true;
    	 } else {
    		 //ComShowCodeMessage("PSO00043");
    		 ComShowCodeMessage("PSO00047"); //Invoice Amount must be Sum of Cost Amount + VAT - W/T
    		 ComSetFocus(formObj.inv_amt);
    		 return false;
    	 }
    	 if(invAmt != chkamt){
    		 ComShowMessage("Invoice Amount must be equal to sum of amount plus V.A.T");
    		 ComSetFocus(formObj.inv_amt);
    		 return false;
    	 } else{ 
    		 return true;
    	 } 
    }
    /**
     * in case of issue date setting, Retrieving effective date
     * @param 
     * @return
     */
    function returnIssDt(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
    	ComChkObjValid(form.rcv_dt);
    }
    /**
     * Setting S/P Code and S/P Name from popup
     * @param aryPopupData
     * @param row
     * @param col
     * @param sheetIdx
     * @return
     */
    function setServiceProviderInfo(aryPopupData, row, col, sheetIdx){
		var formObj=document.form;
		formObj.spcode.value=aryPopupData[0][1];
		formObj.spname.value=aryPopupData[0][2];
		formObj.spdeleted.value=aryPopupData[0][3];
		formObj.spcalangflg.value = aryPopupData[0][4];//NYK Modify 2014.10.31
		checkServiceProvider();
		
        //NYK Modify 2014.10.31
		//initDefaultAccountAndCostComboItem(sheetObjects[0]);
		
		//Focus to Inv.NO
		ComSetFocus(formObj.inv_no);
		f_ExistsInvNo();
     }
    /*
     * Checking S/P Deleting or not
     */
    function checkServiceProvider(){
    	var formObj=document.form;
		if("Y"==formObj.spdeleted.value){
			// PSO00036 : Please input {?msg1}.
			ComShowCodeMessage("PSO00036", "the correct S/P Code.\n'[" + formObj.spcode.value + "]"+ formObj.spname.value + "' is DELETED");
			return false;
		}
		return true;
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }

    /**
     * registering IBCombo Object as list param : combo_obj adding process for list
     * in case of needing batch processing with other items defining list on the top
     * of source
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }
    /**
     * setting Combo basic info
     * 
     * @param comboObj
     * @param comboIndex Number
     */
    function initCombo(comboObj, comboNo) {
        var formObject = document.form;
        switch (comboObj.options.id) {
            case "curr_cd":
                /*with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    ValidChar(2, 1); // Uppercase
                    SetDropHeight(160);
                    SetMaxLength(3);
                }*/
                break;
        }
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // initializing IBMultiCombo
        /*
        for (var k = 0; k < comboObjects.length; k++) {
            initCombo(comboObjects[k], k + 1);
        }
        */
        
        initControl();
    }
    /**
     * registering initial event
     */
    function initControl(){
        var formObj = document.form;        
    	axon_event.addListenerForm  ('change', 'obj_change', form);
        //axon_event.addListenerForm  ('blur', 'obj_blur', form);
    	ComBtnDisable("btn_Confirm");
		ComBtnDisable("btn_Delete");
		//Setting iss_dt to today
		setToday(document.form.iss_dt, 'ymd');
		setToday(document.form.rcv_dt, 'ymd');
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC06);
		
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
        f_SetTrnsSlp(); //Activate to Transfer Slip Checkbox
        f_SetTitleInControls(); //Invoice No. setTitle
    }

    /**
     * Handling change event
     * @return
     */
    function obj_change(){
  		var formObject=document.form;
  	    var sheetObject=sheetObjects[0];
  	    var sheetObj2=sheetObjects[1];
  	    /*******************************************************/
  	    try {
  			var srcName=ComGetEvent("name");
  	        switch(srcName) {
  	            case "spcode"://Checking vndr_seq is in default setting of user
 	  	          	var dspNm=eval("vndrEngNm._"+formObject.spcode.value);
	  	          	if(typeof dspNm =="undefined"){
	  	          		ComShowMessage("There is no provider code in Default Setting.");
	  	          		formObject.spcode.value="";
	  	          		formObject.spname.value="";
	  	          		ComSetFocus(formObject.spcode);
	  	          	} else{
	  	          		formObject.spname.value=dspNm;
	  	          		formObject.spdeleted.value=eval("vndrEngNm._"+formObject.spcode.value+"_DEL");  	          		
	  	          		checkServiceProvider();
	  	          		//NYK Modify 2014.10.31
	  	          		formObject.spcalangflg.value = eval("vndrEngNm._"+formObject.spcode.value+"_CAL");
	  	          		//if(formObject.spcalangflg.value == "Y"){
	  	          		//initDefaultAccountAndCostComboItem(sheetObject);
	  	          		//}
	  	          		
	  	          		//ComSetFocus(formObject.inv_no);
	  	          		sheetObject.RemoveAll();
	  	          		sheetObject.SetEditable(1);
	  	          		isRClick=false;
	  	          		isExistInvNo=false;
	  	          		//SHEET2 CLEAR
		  	          	sheetObj2.SetCellValue(1, "sheet2_arrtp","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_deptp","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_arrnt","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_depnt","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_arrtuh","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_deptuh","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_arrlh","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_deplh","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_usdhrs","",0);
		  	    		//2015.02.10 NYK ADD.
		  	    		sheetObj2.SetCellValue(1, "sheet2_sdr","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_tier","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_limit_time","",0);
		  	    		sheetObj2.SetCellValue(1, "sheet2_other_value","",0);
	  	          	}
	  	          	f_ExistsInvNo();
  	            	break;
  	            case "inv_no":
  	            	f_ExistsInvNo();
  	          		break;
  	            case "yd_cd":
  	            	ComBtnEnable("btn_Save");
					ComBtnDisable("btn_Confirm");
					ComBtnDisable("btn_Delete");
					formObject.vvdband.value="";
					formObject.atd.value="";
					sheetObject.RemoveAll();
					sheetObjects[1].RemoveAll();
					InitHeadColumn(leftHeaders, sheetObjects[1]);
  	            	//checkbox Clear
  	            	formObject.cbx_night.checked=false;          
  	            	formObject.cbx_holiday.checked=false;
  	            	formObject.cbx_boat.checked=false;
  	            	formObject.cbx_tugrope.checked=false;
  	            	formObject.cbx_buoy.checked=false;
  	            	formObject.cbx_sanitation.checked=false;
  	            	formObject.cbx_barge.checked=false;
  	            	formObject.cbx_inspection.checked=false;
  	            	formObject.cbx_newservice.checked=false;
  	            	formObject.cbx_copilot.checked=false;
  	            	formObject.cbx_others.checked=false;//2015.02.10 ADD 
					sheetObject.SetEditable(1);
					
					setTerminalInfo("DFT_COST");
					
			    	//Setting iss_dt to today
					setToday(document.form.iss_dt, 'ymd');
					setToday(document.form.rcv_dt, 'ymd');
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
					if("Y" != $("#existDtlYn").val()){ 
						isRClick=true;
					}else{
						isRClick=false;
					}
					//SHEET2 CLEAR
	  	          	sheetObj2.SetCellValue(1, "sheet2_arrtp","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_deptp","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_arrnt","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_depnt","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_arrtuh","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_deptuh","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_arrlh","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_deplh","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_usdhrs","",0);
	  	    		//2015.02.10 NYK ADD.
	  	    		sheetObj2.SetCellValue(1, "sheet2_sdr","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_tier","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_limit_time","",0);
	  	    		sheetObj2.SetCellValue(1, "sheet2_other_value","",0);
	  	    		
	  	    		//2016.01.14 NYK Add
	  	    		//터미널을 가지고 Canal 인지 재 탐색 한다.(invoice combo item 재 셋팅)
	  	    		initDefaultAccountAndCostComboItem(sheetObject);
  	            	break;
  	            case "curr_cd":
  	                /*
  	                var tmpInvCurrCd = ComGetObjValue(formObject.curr_cd);
  	                var tmpPsoChgStsCd = ComGetObjValue(formObject.pso_chg_sts_cd);

  	                if(sheetObjects[0].RowCount() > 0 && tmpPsoChgStsCd != "A"){
  	                    var tmpSheetCurrCd = sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_curr_cd");
  	                    
  	                    if(tmpInvCurrCd != tmpSheetCurrCd){
  	                        ComShowCodeMessage("PSO01018");
  	                    }
  	                }*/
  	                break;
  	            default :
  	            	if(srcName == "trns_slp" && srcName != "curr_cd" && srcName.indexOf("cbx")==-1){    
  	            		isRClick=false;
  	            	}
  	            	if(g_isEnterKey)
  	            		g_isEnterKey=false;
  	            	break;
  	        } // end switch isRmkModFlg
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowCodeMessage('VSK00011');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
    /*
    function curr_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) { 
        //initReCalculation("curr_cd");
        var formObject = document.form;
        if(sheetObjects[0].RowCount() <= 0) return;
        
        var tmpPsoChgStsCd = ComGetObjValue(formObject.pso_chg_sts_cd);
        if(tmpPsoChgStsCd == "A") return;
        
        var iStRow = sheetObjects[0].HeaderRows();
        var iEdRow = sheetObjects[0].RowCount();
        
        var tmpSheetCurrCd = sheetObjects[0].GetCellValue(iStRow, "sheet1_curr_cd");
        var tmpFormCurrCd = NewCode; //ComGetObjValue(formObject.curr_cd);
        
        //var iFindIdx = sheetObj.FindText("sheet1_curr_cd", tmpFormCurrCd, iStRow);               
        
        if(!ComIsEmpty(tmpSheetCurrCd) && !ComIsEmpty(tmpFormCurrCd) && tmpSheetCurrCd != tmpFormCurrCd){
            if(!ComShowCodeConfirm("PSO01015")){ //"The currency was changed.\nWould you like to recalculate the detail?"
                comboObj.SetSelectCode(OldCode, 0); //2016.08.18 Add
                //ComSetFocus(formObject.curr_cd);
                return;
            }else{        
                //del_chk checked로 변경
                for (var idx=iStRow; idx <= iEdRow; idx++){
                    var status=sheetObjects[0].GetRowStatus(idx);
                    if (status =="D"){
                        sheetObjects[0].SetCellValue(idx, "sheet1_del_chk", 0, 0);
                        continue;
                    }else{
                        sheetObjects[0].SetCellValue(idx, "sheet1_del_chk", 1, 0);
                    }
                }
                
                for(var i=iStRow; i <= iEdRow; i++){
                    sheetObjects[0].SetCellValue(i, "sheet1_curr_cd", tmpFormCurrCd, 0);
                }
                
                //sheetObjects[0].CheckAll("sheet1_del_chk", 1, 0); // 전체 체크 후에 Calculate Click Event.
                ComFireEvent(formObject.btn_Calculation,"click");
                
            }
        }
    }
    
    function curr_cd_OnFocus(comboObj) { 
        comboObj.SetSelectText(-1);
    }
    
    function curr_cd_OnBlur(comboObj) { 
        var selCurrCd = comboObj.GetSelectCode();
        
        if(ComIsEmpty(selCurrCd)){
            if(sheetObjects[0].RowCount() > 0){
                var tmpSheetCurrCd = sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_curr_cd");
                curr_cd.SetSelectCode(tmpSheetCurrCd);
                
                selCurrCd = comboObj.GetSelectCode();
            }else{
                curr_cd.SetSelectCode(gCurrCd);//terminal에 연결된 디폴트 currency
            }
        }
    }*/

    /**
     * Invoice Currency vs Sheet Currency 비교.
     */
    function checkCurrency(){
        var formObject = document.form;
        //var tmpInvCurrCd = curr_cd.GetSelectCode();
        var tmpInvCurrCd = ComGetObjValue(formObject.curr_cd);
        
        if(ComIsEmpty(tmpInvCurrCd)){
            ComShowCodeMessage("PSO00003", "Currency");
            return false;
        }
        
        var tmpPsoChgStsCd = ComGetObjValue(formObject.pso_chg_sts_cd);
        if(tmpPsoChgStsCd == "A") return false; 
        
        if(sheetObjects[0].RowCount() > 0){
            var iStRow = sheetObjects[0].HeaderRows();
            var iEdRow = sheetObjects[0].RowCount();
            
            var tmpSheetCurrCd = sheetObjects[0].GetCellValue(iStRow, "sheet1_curr_cd");
            
            if(tmpSheetCurrCd != tmpInvCurrCd){
                if(!ComShowCodeConfirm("PSO01015")){ //"The currency was changed.\nWould you like to recalculate the detail?"
                    ComSetObjValue(formObject.curr_cd, tmpSheetCurrCd);
                    //curr_cd.SetSelectCode(tmpSheetCurrCd, 0); //2016.08.18 Add
                    ComSetFocus(formObject.curr_cd);
                    return false;
                }else{        
                    //del_chk checked로 변경
                    for (var idx=iStRow; idx <= iEdRow; idx++){
                        var status=sheetObjects[0].GetRowStatus(idx);
                        if (status =="D"){
                            sheetObjects[0].SetCellValue(idx, "sheet1_del_chk", 0, 0);
                            continue;
                        }else{
                            sheetObjects[0].SetCellValue(idx, "sheet1_del_chk", 1, 0);
                        }
                    }
                    
                    for(var i=iStRow; i <= iEdRow; i++){
                        sheetObjects[0].SetCellValue(i, "sheet1_curr_cd", tmpInvCurrCd, 0);
                    }
                    
                    //sheetObjects[0].CheckAll("sheet1_del_chk", 1, 0); // 전체 체크 후에 Calculate Click Event.
                    //ComFireEvent(formObject.btn_Calculation,"click");
                    
                    var exec=0;
                    //var tmpInvCurrcd = ComGetObjValue(formObject.curr_cd);
                    trxnStats = new Array();
                    for(var i=iStRow; i<=iEdRow; i++){
                        
                        trxnStats[i]=sheetObjects[0].GetCellValue(i, "sheet1_ibflag");

                        if(sheetObjects[0].GetCellValue(i, "sheet1_del_chk")==0){//flag clear
                            sheetObjects[0].SetRowStatus(i,"I");
                        }
                        if(sheetObjects[0].GetCellValue(i, "sheet1_del_chk")==1){
                            exec++;
                            
                            //invoice currency setting
                            //sheetObjects[0].SetCellValue(i, "sheet1_curr_cd", tmpInvCurrCd, 0);
                        }
                    } 
                    if(exec == 0){
                        ComShowCodeMessage('PSO01006');
                        return false;
                    }   
                    //--> Calculation again
                    var calcInfo = doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC07);
                    for(var i=iStRow; i<=iEdRow; i++){
                        sheetObjects[0].SetRowStatus(i,trxnStats[i]);
                    }
                    
                    if(calcInfo == "NO_TARIFF_FOUND"){
                        //이전 Sheet의 Currency로 돌린다.
                        for(var i=iStRow; i <= iEdRow; i++){
                            sheetObjects[0].SetCellValue(i, "sheet1_curr_cd", tmpSheetCurrCd, 0);
                        }
                        
                        return false;
                    }else{
                        //2016.12.19 Add 중복사용체크
                        //var isCheckVal = isDoublePayment(sheetObj);//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC13);
                    }
                    
                }
            }
        }
        return true;
    }
    
    
    //NYK Modify 2014.11.03
    function initDefaultAccountAndCostComboItem(sheetObj){
    	var formObj 	= document.form;
    	var canalFlag 	= formObj.spcalangflg.value;
    	if("Y" == canalFlag && getCanalPort()){
    		initCanalAccountAndCostComboItem("INIT");
    	}else{
    		sheetObj.SetColProperty("sheet1_acct_cd", {ComboText: "|"+comboItemsAccountText, ComboCode: "|"+comboItemsAccountCode} );
    		sheetObj.SetColProperty("sheet1_cost_cd", {ComboText: "|"+comboItemsCostText, ComboCode: "|"+comboItemsCostCode} );
    	}
    }
    
    function getCanalPort(){
    	var formObj 	= document.form;
    	var ydCd 		= formObj.yd_cd.value;
    	var portCd		= ydCd.substring(0, 5);
    	if(gf_GetCanalPort(portCd)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    function initCanalAccountAndCostComboItem(flag, acctCd){
    	var sheetObj 	= sheetObjects[0];
    	switch(flag){
	    	case "INIT": //canal account는 distinct 하게 생성. costcd는 첫번째 cost로만 구성.
	    		canalVndrLglEngNmCostCd 	= {};
	        	canalAccCdByCostCdList 		= {};
	        	canalCostCdByAccCdList 		= {};
	        	comboItemsCanalAccountCode	= "";
	    		comboItemsCanalAccountText	= "";
	    		comboItemsCanalCostCode		= "";
	    		comboItemsCanalCostText 	= "";
	    		if(canalComboDataAll.length > 0 ){    			
	    			var comboItems = canalComboDataAll.split("|");
	    			var tmpAccountCode = "";
	    			
	    			//account 만들기.
	    			for (var i = 0 ; i < comboItems.length ; i++) {
	    				var comboItem = comboItems[i].split("^");
	    				//if(tmpAccountCode != comboItem[0] && tmpCanalAccountCode == comboItem[0]){
	    					if( i == 0 ){
	    						comboItemsCanalAccountCode = comboItem[0];
	        					comboItemsCanalAccountText = comboItem[0]+"\t"+comboItem[1]+"\t"+comboItem[3];
	        					
	        				} else {
	        					comboItemsCanalAccountCode = comboItemsCanalAccountCode + "|" + comboItem[0];
	        					comboItemsCanalAccountText = comboItemsCanalAccountText + "|" + comboItem[0]+"\t"+comboItem[1]+"\t"+comboItem[3];
	        				}	    					
	    					//tmpAccountCode = comboItem[0];//첫번째 Account 코드.
	    				//}    				
	    			}
	    			
	    			//if(ComIsNull(acctCd)) acctCd = tmpCanalAccountCode;     			
	
	    			//위에서 선택된 cost 만들기
	    			var iLoopCnt = 0;
	    			for (var i = 0 ; i < comboItems.length ; i++) {
	    				var comboItem = comboItems[i].split("^");
	    				//if(acctCd == comboItem[0]){
	    					if( iLoopCnt == 0 ){
	    						comboItemsCanalCostCode = comboItem[1];
	    						comboItemsCanalCostText = comboItem[1]+"\t"+comboItem[2];
	    					}else{
	    						comboItemsCanalCostCode = comboItemsCanalCostCode + "|" +comboItem[1]; 
	    						comboItemsCanalCostText = comboItemsCanalCostText + "|" +comboItem[1]+"\t"+comboItem[2]; 
	    					}
	    					
	    					canalCostCdByAccCdList	[comboItem[0]] = comboItem[1]; // key : 511711 / value : PTDUDK.
	    					canalVndrLglEngNmCostCd	[comboItem[1]] = comboItem[2];// key : PTDUDK / value : Port Charge Dockage.
	    					canalAccCdByCostCdList	[comboItem[1]] = comboItem[0]; // key : PTDUDK / value : 511711. 
	    					
	    					iLoopCnt++;
	    				//}
	    			}    			
	    		}
	    		sheetObj.SetColProperty("sheet1_acct_cd", {ComboText: "|"+comboItemsCanalAccountText, ComboCode: "|"+comboItemsCanalAccountCode} );
	    		sheetObj.SetColProperty("sheet1_cost_cd", {ComboText: "|"+comboItemsCanalCostText, ComboCode: "|"+comboItemsCanalCostCode} );
	    		
	    		break;
    	}
    }  
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
      var cnt=0;
	  var sheetid=sheetObj.id;
      switch(sheetid) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="||Seq.|VVD|VVD|VVD|VVD|Port\nSeq.|Cost\nCode|Account\nCode|I/O|Code Description|Tariff Cost|Adjustment\nCost|Amount|Credit|Formula|Formula Expression|Remark(s)|vndrSeq|ydCd|psoChgStsCd|usrId|InvNo|issCtyCd|soSeq|soDtlSeq|atd|invLoclAmt|ttlLocAmt|ttlTaxAmt|whldTaxAmt|currCd|effDt|validvvd|costOfc|night|holiday|boat|tugrope|buoy|sanitation|barge|inspection|newservice|copilot|arrtp|deptp|arrnt|depnt|arrtuh|deptuh|arrlh|deplh|usdhrs|sdr|tier|limitTime|others|other_value|psoTrnsSlpCtnt|issDt|acptDt|ydChgNo|ydChgVerSeq|";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet1_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
			             {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tariff_cost",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"adjcost",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"amount",            KeyField:0,   CalcLogic:"|sheet1_tariff_cost|+|sheet1_adjcost|",Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"credit",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:true },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:true },
			             {Type:"Text",      Hidden:0,  Width:90,  Align:"Left",    ColMerge:1,   SaveName:prefix+"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_chg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"iss_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"atd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_locl_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl_locl_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_tax_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_whld_tax_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"validvvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"night",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"holiday",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"boat",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tugrope",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"buoy",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sanitation",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"barge",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inspection",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"newservice",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"copilot",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"arrtp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"deptp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"arrnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"depnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"arrtuh",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"deptuh",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"arrlh",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"deplh",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usdhrs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sdr",            	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:4,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tier",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"limit_time",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"others",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"other_value",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_trns_slp_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"iss_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acpt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_ver_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dft_io_data",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seqs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty(0, prefix+"vvd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			      SetColProperty(0, prefix+"io"		, {ComboText:"|IN|OUT", ComboCode:"INOUT|IN|OUT"} );
			      SetColProperty(0, prefix+"remark"	, {AcceptKeys:"E|N|[.-_/,() &'`]"});
			      SetCountPosition(0);
			      //SetSheetHeight(260);
			      resizeSheet();
			      }
				break;
		case "sheet2":
		    with(sheetObj){
		      var HeadTitle1="Object||Arr.TP|Dep.TP|Arr.NT|Dep.NT|Arr.TUH|Dep.TUH|Arr.LH|Dep.LH|Used.Hr|Others|Cnl.SDR|Cnl.TIER|Cnl.LT|Condition|Remark(s)|";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet2_"
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0,  Width:107,  Align:"Center",  ColMerge:1,   SaveName:"object",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Status" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"arrtp",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Arrival Tug Power"},
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"deptp",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Departure Tug Power" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"arrnt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Arrival Number of Tug" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"depnt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Departure Number of Tug" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"arrtuh",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Arrival Tug Used Hour" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"deptuh",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Departure Tug Used Hour" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"arrlh",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Arrival Line Handling Hour" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"deplh",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Departure Line Handling Hour" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"usdhrs",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Used Hour" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"other_value",KeyField:0,   CalcLogic:"",   Format:"NullFloat", 	UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Others" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"sdr",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Canal SDR" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"tier",       KeyField:0,   CalcLogic:"",   Format:"NullFloat", 	UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Canal Tier" },
		             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",  ColMerge:1,   SaveName:prefix+"limit_time", KeyField:0,   CalcLogic:"",   Format:"NullFloat", 	UpdateEdit:1,   InsertEdit:1,   EditLen:15	,ToolTip:0,	 ToolTipText:"Canal Limit Time" },
		             {Type:"Float",     Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Condition2", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:0,  Align:"Center",  ColMerge:1,   SaveName:prefix+"Remark",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" } ];
		      InitColumns(cols);
		      //SetSheetHeight(100);
		      //resizeSheet(sheetObj);
		      SetHeaderRowHeight(32);
		      SetDataRowHeight(37);
		      SetEditable(1);
		      //InitHeadColumn(0, "Value", daCenter);
		      InitHeadColumn(leftHeaders, sheetObj);
		      FitColWidth("9|7|7|7|7|7|7|7|7|7|7|7|7|7");//14 Col
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
			break;
		case "sheet3":	//Dummy Sheet
          with(sheetObj){
			    var HeadTitle1="M|F";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			    var prefix="sheet3_";
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			    var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},];
			    InitHeaders(headers, info);
			    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
			    InitColumns(cols);
			    SetSheetHeight(150);
			    SetEditable(1);
			    SetShowButtonImage(1);
			}
			break;			
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var saveObjs=new Array(2);
		saveObjs[0]=sheetObject1;
		saveObjs[1]=sheetObject2;
		sheetObject1.SetWaitImageVisible(0);
		sheetObject2.SetWaitImageVisible(0);
        switch(sAction) {
          case IBSEARCH:      //Retrieving
           		if(!validateForm(sheetObj,formObj,sAction)) return;
           		if ( sheetObj.id == "sheet1"){
           			ComOpenWait(true);
           			formObj.f_cmd.value=SEARCH;
           			formObj.vndr_seq.value=formObj.spcode.value;//Setting vndr_seq
           			
           			var sXml=sheetObj.GetSearchData("VOP_PSO_0014GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), {Sync:2});
           			var existDtlYn=ComGetEtcData(sXml,"EXIST_DTL_YN");
           			
           			formObj.existDtlYn.value = existDtlYn;
           			
           			if("Y" != existDtlYn){
           				//Detail 미존재.
           				initMasterData(sXml);
           				
           				//init
           				sheetObjects[0].RemoveAll();
           				sheetObjects[1].RemoveAll();
           				sheetObjects[0].SetEditable(1);
    					InitHeadColumn(leftHeaders, sheetObjects[1]);
           				
           				ComOpenWait(false);
           			}else{
           				sheetObj.LoadSearchData(sXml,{Sync:1} );
           			}
    				
           			//sheetObj.DoSearch("VOP_PSO_0014GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
           			
           		}
				break;
			case IBSAVE:        //Save
		        if(!validateForm(sheetObj,formObj,sAction)) {
		            return false;
		        }//end if
		        
		        //2016.12.27 Add Double Payment Check.
                if(!isDoublePayment(sheetObject1)) return;
                
	    		formObj.f_cmd.value=MULTI;
	          	var SaveStr=ComGetSaveString(saveObjs);
	          	
	          	if(sheetObjects[0].RowCount() > 0){
	          		formObj.existDtlYn.value = "Y";
	          		if(SaveStr == undefined || SaveStr.length <= 0 ) return;
	          	}else{
	          		formObj.existDtlYn.value = "N";
	          	}
	          	
	          	/*if("Y" == formObj.existDtlYn.value){
	          		if(SaveStr == undefined || SaveStr.length <= 0 ) return;
	          	}*/
	          	
				ComOpenWait(true);
				var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix String array	
				var sXml=sheetObject1.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				var data=ComGetEtcData(sXml,"Exception");
				if(data == null || data==""){
					if( typeof (sXml) == "undefined" ) return;
					var errCode=ComGetEtcData(sXml, "ERRCODE");
					if(errCode == null || errCode==""){
						if(sXml.indexOf("<ERROR>")==-1){
							ComBtnEnable("btn_Confirm");
			              	ComBtnEnable("btn_Delete");
			              	if("Y" == formObj.existDtlYn.value){
			              		//Detail 정보가 존재 할 경우.
			              		doActionIBSheet(sheetObject1, document.form, IBSEARCH);
								isRClick=true;
			              	}else{
			              		//마스터 정보만 입력 한 경우.
			              		initMasterData(sXml);
			              		isRClick=true;
			              	}
						}
					}
				}
				sheetObject1.LoadSaveData(sXml,{Sync:1} );
				
	          	break;
			case IBDELETE:        //Delete or Cancel
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}				
				var SaveStr=ComGetSaveString(sheetObj);
				
				if("Y" == formObj.existDtlYn.value){
	          		if(SaveStr == undefined || SaveStr.length <= 0 ) return false;
	          	}	
				formObj.f_cmd.value=REMOVE;
				
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				
				var delStatus = ComGetSelectSingleNode(sXml, "TR-ALL");				
				sheetObj.LoadSaveData(sXml);
				
				//var retVal=sheetObj.DoSave("VOP_PSO_0014GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				//ComOpenWait(false);
				if("OK" == delStatus){
					var stsCd=formObj.pso_chg_sts_cd.value; 
					if(stsCd=="A"){	//in case Confirm Cancel, after updating, Retrieve again
						document.getElementById("btn_Delete").innerHTML="Delete";
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						sheetObject1.SetEditable(1);
						isRClick=true;
					} else{
						ComBtnEnable("btn_Save");
						ComBtnDisable("btn_Confirm");
						ComBtnDisable("btn_Delete");
						ComBtnEnable("btn_RowAdd");
						ComBtnEnable("btn_RowDelete");
						ComBtnEnable("btn_Calculation");
						formObj.reset();
						sheetObject1.RemoveAll();
						sheetObject2.RemoveAll();
						sheetObject1.SetEditable(1);
						InitHeadColumn(leftHeaders, sheetObject2);
						
						setTerminalInfo("DFT_COST");
						
						//Setting iss_dt to today
						setToday(document.form.iss_dt, 'ymd');
						setToday(document.form.rcv_dt, 'ymd');
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06);
						isRClick=false;
					}
				}
				break;
			case IBSEARCH_ASYNC01://Retrieving Initial Data
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=COMMAND01;//
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml=sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam, {sync:1});
				var comboData=ComGetEtcData(sXml, "ACCTCOSTCDLIST");
				
				comboItemsAccountCode = "";
				comboItemsAccountText="";
				comboItemsCostCode="";
				comboItemsCostText="";
				
				if(comboData.length > 0 ){
					comboItems=comboData.split("|");
					for (var i=0 ; i < comboItems.length ; i++) {
						var comboItem=comboItems[i].split("^");
						if( i == 0 ){
							comboItemsAccountText=comboItem[0]+"\t"+comboItem[1]+"\t"+comboItem[3];
							comboItemsAccountCode=comboItem[0];
							
							comboItemsCostCode=comboItem[1]; 
							comboItemsCostText=comboItem[1]+"\t"+comboItem[2]; 
						} else {
							comboItemsAccountText=comboItemsAccountText + "|" +comboItem[0]+"\t"+comboItem[1]+"\t"+comboItem[3];
							comboItemsAccountCode=comboItemsAccountCode + "|" +comboItem[0];
							comboItemsCostCode=comboItemsCostCode + "|" +comboItem[1]; 
							comboItemsCostText=comboItemsCostText + "|" +comboItem[1]+"\t"+comboItem[2]; 
						}
						
						costCdByAccCdList[comboItem[0]] = comboItem[1]; // key : 511711 / value : PTDUDK. 
						vndrLglEngNmCostCd[comboItem[1]] = comboItem[2];// key : PTDUDK / value : Port Charge Dockage.
						accCdByCostCdList[comboItem[1]] = comboItem[0]; // key : PTDUDK / value : 511711.
				
					}  
				}
				sheetObj.SetColProperty("sheet1_acct_cd", {ComboText: "|"+comboItemsAccountText, ComboCode: "|"+comboItemsAccountCode} );
				sheetObj.SetColProperty("sheet1_cost_cd", {ComboText: "|"+comboItemsCostText, ComboCode: "|"+comboItemsCostCode} );
				
				var canalComboData=ComGetEtcData(sXml, "CANALACCTCOSTCDLIST");
				canalComboDataAll = canalComboData;//전체 데이타를 담아 둔다.
				
				//initCanalAccountAndCostComboItem("INIT");
				
				var ydCdData=ComGetEtcData(sXml, "YDCDLIST");
				if(ydCdData.length > 0 ){
					var selYdCd= document.form.sel_yd_cd;
					ydCdItems=ydCdData.split("|");
					for(var i=0; i < ydCdItems.length; i++){
						var ydCdItem=ydCdItems[i].split("^");
						option=document.createElement("option");
			            option.value=ydCdItem[0];
			            option.appendChild(document.createTextNode(ydCdItem[0]));
			            if(i==0)
			            	option.selected="selected";
			            ydCdItem[1]=ydCdItem[1].replace(/"/gi, "\\\"");
			            eval("tmnlName._"+ydCdItem[0]+"=\""+ydCdItem[1]+"\"");
			            eval("costOfc._"+ydCdItem[0]+"=\""+ydCdItem[2]+"\"");
			            eval("currCdList._"+ydCdItem[0]+"=\""+ydCdItem[3]+"\"");//CURR_CD LIST
			            selYdCd.appendChild(option);
			            formObj.tmnl_nm.value=eval("tmnlName._"+selYdCd.value); 
			            formObj.cost_ofc.value=eval("costOfc._"+selYdCd.value); 
			            gCurrCd=eval("currCdList._"+selYdCd.value); 
					}
				}
				var CurrencyData=ComGetEtcData(sXml, "CURRENCYLIST");
				/*
				if(CurrencyData.length > 0 ){
				    curr_cd.RemoveAll();				    
				    
				    var comboItems=CurrencyData.split("|");
				    
				    for (var i=0 ; i < comboItems.length ; i++) {
                        comboItem=comboItems[i].split("^");
                        curr_cd.InsertItem(-1, comboItem[0], comboItem[0]);
                    }
				    curr_cd.SetSelectCode(gCurrCd, 0); //Setting Curr CD of Terminal CD
				}*/
				
				if(CurrencyData.length > 0 ){
					var currCdObj  = document.form.curr_cd;
					CurrencyItems  = CurrencyData.split("|");
					for(var i=0; i < CurrencyItems.length; i++){
						var CurrencyItem = CurrencyItems[i].split("^");
						option                = document.createElement("option");
						option.value          = CurrencyItem[0];
						option.appendChild(document.createTextNode(CurrencyItem[0]));
						option.title          = CurrencyItem[1];
						option.decimal_point  = CurrencyItem[3];
						if(gCurrCd == CurrencyItem[0]){//Setting Curr CD of Terminal CD
							option.selected  = "selected";
							gCurrCd          = CurrencyItem[0];
						}
						currCdObj.appendChild(option);
					}
				}
				var vendorData=ComGetEtcData(sXml, "VENDORLIST");
				if(vendorData.length > 0 ){
					vendorItems=vendorData.split("|");
					for(var i=0; i < vendorItems.length; i++){
						var vendorItem=vendorItems[i].split("^");
						 eval("vndrEngNm._"+vendorItem[0]+"=\""+vendorItem[1]+"\""); 
						 eval("vndrEngNm._"+vendorItem[0]+"_DEL=\""+vendorItem[2]+"\"");
						 //NYK Modify 2014.11.03
						 eval("vndrEngNm._"+vendorItem[0]+"_CAL = \""+vendorItem[3]+"\"");
					}
				}
				break;		
			case IBSEARCH_ASYNC02: //Confirm Button Click
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}			
				if(!checkInvoiceAmount()) return; 
				
				//2016.12.27 Add Double Payment Check.
                if(!isDoublePayment(sheetObject1)) return;
                
				formObj.f_cmd.value=MULTI02;//[2010.05.11:jmh]
			  	var SaveStr=ComGetSaveString(saveObjs, true, true);
			  	sheetObj.SetShowMsgMode(0);
				if(SaveStr.length <= 0 ) return;
				ComOpenWait(true);
				var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix String array	
				var sXml=sheetObject1.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				var exceptionData=ComGetEtcData(sXml, "Exception");
				if(exceptionData != null ){
					if(exceptionData.length > 0){
						ComBtnEnable("btn_Confirm");
						ComBtnEnable("btn_Save");
					}
					else{//in case of success, Disable to Button
						if(sXml.indexOf("<ERROR>")==-1){
							ComBtnDisable("btn_Confirm");
							ComBtnDisable("btn_Save");
							formObj.pso_chg_sts_cd.value="A";
							document.getElementById("btn_Delete").innerHTML="Confirm Cancel";
						}
					}
				}
				else{//in case of success, Disable to Button
					var errCode=ComGetEtcData(sXml, "ERRCODE");
					if(errCode == null || errCode==""){
						if(sXml.indexOf("<ERROR>")==-1){
							ComBtnDisable("btn_Confirm");
							ComBtnDisable("btn_Save");
							formObj.pso_chg_sts_cd.value="A";
						}
					}
				}
				sheetObjects[2].LoadSaveData(sXml,{Sync:1} );
				sheetObj.SetShowMsgMode(1);
				
			case IBSEARCH_ASYNC03: //VVD Level Check 
				//alert("VVD Level Check");
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				ComOpenWait(true);
				formObj.f_cmd.value	= COMMAND03;//
				var sParam			= FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml			= sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam, {sync:1});
				ComOpenWait(false);
				
				var vvdLeveChek=ComGetEtcData(sXml, "VALIDVVD");
				return vvdLeveChek;
				break;
				
			case IBSEARCH_ASYNC04: //Checking inputted VVD is exist in VSK_VSL_PORT_SKD
				if(!validateForm(sheetObj,formObj,sAction)) return new Array("","","");
				
				ComOpenWait(true);
				formObj.f_cmd.value		= COMMAND04;//
				var sParam				= FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				
				var sXml=sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam, {sync:1});
				ComOpenWait(false);
				
				var flag				= ComGetEtcData(sXml, "ISEXIST");
				var trunPortIndCd		= ComGetEtcData(sXml, "TURNPORTINDCD");
				var trunPortIndIoData	= ComGetEtcData(sXml, "TURNPORTINDIODATA");
				var clptIndSeqs			= ComGetEtcData(sXml, "CLPT_IND_SEQS"); //2016.04.26 Double Calling
				
				//Return String > Array 로 변경한다.
				var arrFlag = [flag, trunPortIndCd, trunPortIndIoData, "", clptIndSeqs];
				//var arrFlag = = new Array();
				
				// 2015.01.29 NYK Modify
				if(trunPortIndCd=="D" || trunPortIndCd=="V" || trunPortIndCd=="F"){
					ComShowMessage("This is Virtual Port. Please Input VVD Again.");
					return arrFlag;
				}
				
				//Checking Yard Skip
    			var skdCngStsCd = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC12);
    			if(skdCngStsCd == "N"){
    				arrFlag[3] = skdCngStsCd;
    				return arrFlag;
    			}
    			
    			
				if(flag =="N"){
					var tmnl_cd=formObj.yd_cd.value;
					ComShowMessage("Not created Actual SKD at [" + tmnl_cd + "] or The carrier code is not ours.");
				}
				
				
				return arrFlag;
				break;
				
			case IBSEARCH_ASYNC05://Processing Auto Calculation
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value			= COMMAND05;
				formObj.rowIdx.value		= sheetObj.GetSelectRow();//index of selected row
				//-----------> Parameter
				formObj.night.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_night");
				formObj.holiday.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_holiday");
				formObj.boat.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_boat");
				formObj.tugrope.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_tugrope");
				formObj.buoy.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_buoy");
				formObj.sanitation.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_sanitation");
				formObj.barge.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_barge");
				formObj.inspection.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_inspection");
				formObj.newservice.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_newservice");
				formObj.copilot.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_copilot");
				formObj.arrtp.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_arrtp");
				formObj.deptp.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_deptp");
				formObj.arrnt.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_arrnt");
				formObj.depnt.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_depnt");
				formObj.arrtuh.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_arrtuh");
				formObj.deptuh.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_deptuh");
				formObj.arrlh.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_arrlh");
				formObj.deplh.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_deplh");
				formObj.usdhrs.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_usdhrs");
				//2015.02.10 ADD
				formObj.sdr.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_sdr");
				formObj.tier.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_tier");
				formObj.limit_time.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_limit_time");
				formObj.others.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_others");
				formObj.other_value.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_other_value");
				
				var sParam					= FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml					= sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam);
				
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );

//				f_dataRowHeight(0);
				ComOpenWait(false);
				var calcInfo	= ComGetEtcData(sXml, "CALCINFO");				
				var valueInfo 	= ComGetEtcData(sXml, "VALUEINFO");//2016.01.13 NYK Add.
				
				setAddInformationValue(valueInfo);//2016.01.13 NYK Add.
				
				return calcInfo;
				break;
				
			case IBSEARCH_ASYNC06://in case Issue Date input, Retrieving Effective Date
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=COMMAND06;//
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml=sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam, {sync:1});
				var effDt=ComGetEtcData(sXml, "EFFDT");
				break;
				
			case IBSEARCH_ASYNC07://Calculating Checked Rows
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				ComOpenWait(true);
				formObj.f_cmd.value	= COMMAND07;//
				var SaveStr			= ComGetSaveString(saveObjs, true, true);
				if(SaveStr.length <= 0 ){
					ComOpenWait(false);
					return;
				}
				var aryPrefix		= new Array("sheet1_");	//prefix String array
				var sXml			= sheetObject1.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				
				var transResultKey   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");//2016.01.13 NYK Add.
				
				if(!ComIsEmpty(transResultKey) && transResultKey == "F"){

                    sheetObject1.LoadSaveData(sXml,{Sync:1});
                    
				    return "NO_TARIFF_FOUND";
				}else{
    				sheetObject1.LoadSaveData(sXml,{Sync:1});
    				
    				setCalcAmtVvd();
    				
        			ComChkObjValid(formObj.calc_amt_vvd);
    		    	ComChkObjValid(formObj.calc_amt_ttl);
    		    	
    				//2016.04.26 Cell ComboItem : Io, clpt_ind_seq
    				initDefaultCellComboItem(sheetObj);
    				return "";
				}
				break;
				
			case IBSEARCH_ASYNC08://Checking inputted Inv_no is exist
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value		= COMMAND08;//
				var SaveStr				= ComGetSaveString(saveObjs);
				var aryPrefix			= new Array("sheet1_");	//prefix String array
				var sXml				= sheetObject1.GetSearchData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix), {sync:1});
				var rtVal				= ComGetEtcData(sXml, "EXIST_YN");
				return rtVal;
				break;

			/*case IBSEARCH_ASYNC09://S/P Code is AccountCode Retrieve.
				formObj.f_cmd.value = COMMAND09;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam);
				var comboData = ComGetEtcData(sXml, "ACCTCOSTCDLIST");
				var comboItemsAccountCode= "";
				var comboItemsAccountText= "";
				var comboItemsCostCode= "";
				var comboItemsCostText ="";
				var comboItemsCostCodeDesc = "";
				
				if(comboData.length > 0 ){
					
					comboItems = comboData.split("|");
					for (var i = 0 ; i < comboItems.length ; i++) {
						
						var comboItem = comboItems[i].split("^");
						if( i == 0 ){
							comboItemsAccountCode = comboItem[0];
							comboItemsAccountText = comboItem[0]+"\t"+comboItem[3];
							comboItemsCostCode = comboItem[1]; 
							comboItemsCostText = comboItem[1];
							comboItemsCostCodeDesc = comboItem[2];
							//무조건 1건의 Account Code 만 적용됨.
							sheetObj.SetColProperty("sheet1_acct_cd", {ComboText: "|"+comboItemsAccountText, ComboCode: "|"+comboItemsAccountCode} );
							//무조건 1번째 Cost Code를 담는다.
							canalCostCdByAccCdList[comboItem[0]] = comboItem[1]; // key : 511711 / value : PTDUDK. 
						} else {
							comboItemsCostCode = comboItemsCostCode + "|" +comboItem[1]; 
							comboItemsCostText = comboItemsCostText + "|" +comboItem[1]; 
						}	
						
						
						canalVndrLglEngNmCostCd[comboItem[1]] = comboItem[2];// key : PTDUDK / value : Port Charge Dockage.
						canalAccCdByCostCdList[comboItem[1]] = comboItem[0]; // key : PTDUDK / value : 511711. 
						
					}  					
				}				
				sheetObj.SetColProperty("sheet1_cost_cd", {ComboText: "|"+comboItemsCostText, ComboCode: "|"+comboItemsCostCode} );
				break;*/
			case IBSEARCH_ASYNC10://저장전에 환율이 존재하는지 체크.
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=COMMAND10;//
				var SaveStr=ComGetSaveString(saveObjs);
				var aryPrefix=new Array("sheet1_");	//prefix String array
				var sXml=sheetObject1.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var rtVal=ComGetEtcData(sXml, "EXIST_RATE_YN");
				return rtVal;
				break;
				
			case IBSEARCH_ASYNC11://Confirm전에 AR_MST_REV_VVD가 존재하는지 체크.
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=COMMAND11;//
				var SaveStr=ComGetSaveString(saveObjs, true, true);
				//var SaveStr=ComGetSaveString(saveObjs);
				var aryPrefix=new Array("sheet1_");	//prefix String array
				var sXml=sheetObject1.GetSaveData("VOP_PSO_0014GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var rtVal=ComGetEtcData(sXml, "EXIST_AR_VVD");
				return rtVal;
				break;
				
			case IBSEARCH_ASYNC12: //유저가 입력한 VVD의 Yard가 스킵인지 확인
				if(!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = COMMAND12;//
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam);
				ComOpenWait(false);
				var skdCngStsCd = ComGetEtcData(sXml, "SKIPYARD");
			    var yard = formObj.yd_cd.value;
				var vvd_cd = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vvd");
				if(skdCngStsCd=="N"){
					//ComShowMessage("This Yard ["+yard+"]" +" is skipped in ["+vvd_cd+"]."+"\n"+"Please Check Vessel Schedule First.");					
					ComShowMessage("Invalid VVD code."+"\n"+"Please check the Vessel Schedule.");					
				}
				return skdCngStsCd;
			break;

            
            case IBSEARCH_ASYNC13: //2016.12.19 Add Double Pay Check : VVD/VENDOR/COST_CD/COST_OFC/YD_CD를 체크해서 동일 Invoice 가 있는지 체크
                if(!validateForm(sheetObj,formObj,sAction)) return;
                ComOpenWait(true);
                formObj.f_cmd.value = COMMAND13;//
                formObj.vndr_seq.value = formObj.spcode.value;
                var SaveStr         = ComGetSaveString(saveObjs, true, true);
                if(SaveStr.length <= 0 ){
                    ComOpenWait(false);
                    return;
                }
                
                var sParam = SaveStr;
                    sParam += "&" + FormQueryString(formObj);
                    sParam += "&" + ComGetPrefixParam("sheet1_");
                
                var sXml = sheetObj.GetSearchData("VOP_PSO_0014GS.do", sParam);
                ComOpenWait(false);
                var checkInv = ComGetEtcData(sXml, "CHECKINV");
                /*if(checkInv!=""){
                    ComShowMessage("The same invoice does exist, Invoice ["+checkInv+"]" +". \nPlease double check the invoice. \nWould you continue to save?");
                }*/
                return  checkInv;
            break;
        }
    }
    function validateDetailForm(formObj, sheetObj){
        //Detail Data를 RowAdd 만 하고 데이타를 넣지 않았을때만 체크.
        if(sheetObj.RowCount() > 0){
            var iStartRow   = sheetObj.HeaderRows();
            var iEndRow     = sheetObj.LastRow();
            
            for(var i=iStartRow;i<iEndRow;i++) {
                var tmpVvd = sheetObj.GetCellValue(i, "sheet1_vvd");
                var tmpClptIndSeq = sheetObj.GetCellValue(i, "sheet1_clpt_ind_seq");
                var tmpCostCd = sheetObj.GetCellValue(i, "sheet1_cost_cd");
                var tmpAcctCd = sheetObj.GetCellValue(i, "sheet1_acct_cd");
                
                if(ComIsEmpty(tmpVvd)){
                    ComShowCodeMessage("PSO00003", "VVD");
                    return false;
                }
                if(ComIsEmpty(tmpClptIndSeq)){
                    ComShowCodeMessage("PSO00003", "Port Seq.");
                    return false;
                }    
                if(ComIsEmpty(tmpCostCd)){
                    ComShowCodeMessage("PSO00003", "Cost Code");
                    return false;
                }   
                if(ComIsEmpty(tmpAcctCd)){
                    ComShowCodeMessage("PSO00003", "Account Code");
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction){
        		case IBSEARCH:
		        	if(spcode.value == ""){
		        		ComShowCodeMessage("PSO00003", "S/P Code");
		        		ComSetFocus(spcode);
		        		return false;
		        	}
		        	else if(inv_no.value == ""){
		        		ComShowCodeMessage("PSO00003", "INV No.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	else if(inv_no.value.trim().length < 3 ){
		        		ComShowMessage("INV No.'s lenght must be greater than 3.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	break;
        		case IBSEARCH_ASYNC02:	//Confirm
        		case IBDELETE:			//Delete or Cancel	
        		case IBSAVE:			//Save
        			if(spcode.value == ""){
		        		ComShowCodeMessage("PSO00003", "S/P Code");
		        		ComSetFocus(spcode);
		        		return false;
		        	}
		        	else if(inv_no.value == ""){
		        		ComShowCodeMessage("PSO00003", "INV No.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	else if(sel_yd_cd.value == ""){
		        		ComShowCodeMessage("PSO00003", "Terminal");
		        		ComSetFocus(sel_yd_cd);
		        		return false;
		        	}
		        	else if(inv_no.value.trim().length < 3 ){
		        		ComShowMessage("INV No.'s length must be greater than 3.");
		        		ComSetFocus(inv_no);
		        		return false;
		        	}
		        	//else if(inv_amt.value == "" || inv_amt.value == "0" || inv_amt.value == "0.00" || inv_amt.value == "0.0"){
		        	else if(inv_amt.value == ""){
		        		ComShowMessage("Invoice Amount must be greater than 0.");
		        		ComSetFocus(inv_amt);
		        		return false;
		        	}	
		        	else if(cost_ofc.value == ""){
		        		ComShowCodeMessage("PSO00003", "Cost Office");
		        		ComSetFocus(cost_ofc);
		        		return false;	
		        	}	
		        	else if(iss_dt.value == ""){
		        		ComShowCodeMessage("PSO00003", "Issue Date");
		        		ComSetFocus(iss_dt);
		        		return false;	
		        	}	
		        	else if(rcv_dt.value == ""){
		        		ComShowCodeMessage("PSO00003", "Receive Date");
		        		ComSetFocus(rcv_dt);
		        		return false;	
		        	}
		        	break;
        	}
        }
        return true;
    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag){
    	var formObj=document.form ;
    	var colName=sheetObj.ColSaveName(Col);
    	if(colName == "sheet1_vvd"){
    		var sheet1_vvd = sheetObj.GetCellValue(Row, "sheet1_vvd");
    		if(sheet1_vvd.length == 9){
    			formObj.vsl_cd.value	= sheet1_vvd.substr(0, 4);
    			formObj.skd_voy_no.value= sheet1_vvd.substr(4, 4);
    			formObj.skd_dir_cd.value= sheet1_vvd.substr(8, 1);
    			
		    	var flag = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
		    	
		    	//flag,trunPortIndCd,trunPortIndIoData,skdCngStsCd, clptIndSeqs
		    	if(flag[0] =="N" || flag[3] == "N"){//flag, skdCngStsCd: Y>통과, N>skip vvd
	    			sheetObj.SetCellValue(Row, "sheet1_vsl_cd"		,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"	,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"	,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_vvd"			,"",0);
		    		switch (colName){//Validation Flag Clear 
			    		case "sheet1_vsl_cd":
			    			VALIDVVD=(VALIDVVD&4) ==4 ?  VALIDVVD - 4 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_voy_no":
			    			VALIDVVD=(VALIDVVD&2) ==2 ?  VALIDVVD - 2 : VALIDVVD;
			    			break;
			    		case "sheet1_skd_dir_cd":
			    			VALIDVVD=(VALIDVVD&1) ==1 ?  VALIDVVD - 1 : VALIDVVD;
			    			break;
			    		default: break;	
		    		}
					sheetObj.SetCellValue(Row, "sheet1_acct_cd"				," ",0);
					sheetObj.SetCellValue(Row, "sheet1_cost_cd"				," ",0);
					sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm"	," ",0);
					sheetObj.SetCellValue(Row, "sheet1_tariff_cost"			,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_adjcost"				,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_amount"				,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_foml1"				,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_foml2"				,"",0);
	    			sheetObj.SetCellValue(Row, "sheet1_io"					,"",0);
		    		sheetObj.SetCellValue(Row, "sheet1_vvd"					,"",0);
		    		sheetObj.SetCellValue(Row, "sheet1_dft_io_data"			,"",0); // 2015.01.30 NYK Add 디폴트 IN 데이타 처리.
		    		sheetObj.SetCellValue(Row, "sheet1_clpt_ind_seq"		,"",0); // 2016.04.26 Double Calling add
		    		sheetObj.SetCellValue(Row, "sheet1_clpt_ind_seqs"		,"",0); // 2016.04.26 Double Calling add
		    		
		    		sheetObj.SelectCell(Row, "sheet1_vvd");
		    		formObj.vvdband.value="";
		    		return false;
		    	} else{
	    			sheetObj.SetCellValue(Row, "sheet1_vsl_cd"			,sheet1_vvd.substr(0, 4),0);
	    			sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"		,sheet1_vvd.substr(4, 4),0);
	    			sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"		,sheet1_vvd.substr(8, 1),0);
	    			sheetObj.SetCellValue(Row, "sheet1_dft_io_data"		,flag[2],0); // 2015.01.30 NYK Add 디폴트 IN 데이타 처리.
			    	if (flag[1] =="D"|| flag[1]=="V"|| flag[1]=="F"){//Turning Port
			    		sheetObj.SetCellValue(Row, "sheet1_vvd"			,"",0);
				    	sheetObj.SetCellValue(Row, "sheet1_vsl_cd"		,"",0);
				    	sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"	,"",0);
				    	sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"	,"",0);
				    	sheetObj.SelectCell(Row, "sheet1_vvd");
				    	formObj.vvdband.value="";
			    	} else{	//valid pass
			    		switch (colName){
				    		case "sheet1_vsl_cd":
				    			VALIDVVD=(VALIDVVD&4) ==4 ?  VALIDVVD : VALIDVVD + 4;
				    			//Clearing
				    			sheetObj.SetCellValue(Row, "sheet1_acct_cd"				," ",0);
				    			sheetObj.SetCellValue(Row, "sheet1_cost_cd"				," ",0);
				    			sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm"	," ",0);
				    			sheetObj.SetCellValue(Row, "sheet1_tariff_cost"			,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_adjcost"				,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_amount"				,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_foml1"				,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_foml2"				,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"			,"",0);
				    			sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"			,"",0);
				    			break;
				    		case "sheet1_skd_voy_no":
				    			VALIDVVD=(VALIDVVD&2) ==2 ?  VALIDVVD : VALIDVVD + 2;
				    			break;
				    		case "sheet1_skd_dir_cd":
				    			VALIDVVD=(VALIDVVD&1) ==1 ?  VALIDVVD : VALIDVVD + 1;
				    			break;
				    		default: break;	
			    		}
			    		formObj.vvdband.value=sheet1_vvd;
			    	}
			    	
			    	//2016.04.26 CLPT_IND_SEQ Combo Item Setting
			    	var clptIndSeqComboItems= flag[4];

			    	var tmpClptIndSeqComboItems = clptIndSeqComboItems.split("|");
			    	var tmpSelClptIndSeqValue = "";
			    	if(tmpClptIndSeqComboItems.length == 1){
			    		sheetObj.InitCellProperty	(Row, "sheet1_clpt_ind_seq"	,{ Type:"Text",Align:"Center"} );
			    		sheetObj.SetCellValue		(Row, "sheet1_clpt_ind_seq", tmpClptIndSeqComboItems[0], 0);
			    		sheetObj.SetCellEditable	(Row, "sheet1_clpt_ind_seq",0);
			    	}else{
			    		sheetObj.InitCellProperty	(Row, "sheet1_clpt_ind_seq"	,{ Type:"Combo",Align:"Center"} );
			    		sheetObj.CellComboItem		(Row, "sheet1_clpt_ind_seq", {ComboText:clptIndSeqComboItems, ComboCode:clptIndSeqComboItems} );
			    		sheetObj.SetCellValue		(Row, "sheet1_clpt_ind_seq", tmpClptIndSeqComboItems[0], 0);
			    		sheetObj.SetCellEditable	(Row, "sheet1_clpt_ind_seq",1);
			    	}
			    	//sheetObj.SetCellValue(Row , "sheet1_clpt_ind_seq", tmpSelClptIndSeqValue, 0);
			    	//sheetObj.SelectCell(Row,"sheet1_cost_cd");
			    	
		    	}
    		} else{
    			sheetObj.SetCellValue(Row, "sheet1_vsl_cd"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_vvd"				,"",0);
    			VALIDVVD=(VALIDVVD&4) ==4 ?  VALIDVVD : VALIDVVD + 4;
    			//Clearing
    			sheetObj.SetCellValue(Row, "sheet1_acct_cd"			," ",0);
    			sheetObj.SetCellValue(Row, "sheet1_cost_cd"			," ",0);
    			sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm"," ",0);
    			sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_adjcost"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_amount"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_skd_voy_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_skd_dir_cd"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_dft_io_data"		,"",0); // 2015.01.30 NYK Add 디폴트 IN 데이타 처리.
	    		sheetObj.SetCellValue(Row, "sheet1_clpt_ind_seq"	,"",0); // 2016.04.26 Double Calling add
	    		sheetObj.SetCellValue(Row, "sheet1_clpt_ind_seqs"	,"",0); // 2016.04.26 Double Calling add
    			formObj.vvdband.value="";
    		}
    	}
	    
    	switch (colName){//Handling Select List
    		case "sheet1_adjcost"://every time adjust amt changes, Updating Form Data
    			formObj.vvdband.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_cd") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_voy_no") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_dir_cd");
        		formObj.atd.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_atd");
        		var adj_amt				= Number(sheetObj.GetCellValue(Row,"sheet1_adjcost"));
        		var cre_ind				= sheetObj.GetCellValue(Row,"sheet1_credit");
        		
        		if (adj_amt >0 && cre_ind =="1"){
        			ComShowCodeMessage("PSO01004");
        			sheetObj.SetCellValue(Row,"sheet1_adjcost","",0);
        		}
        		
        		setCalcAmtVvd();
        		
        		//NYK Modify 2014.11.26
        		//formObj.calc_amt_ttl.value=ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
        		//formObj.calc_amt_ttl.value=Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2);//"sheet1_tariff_cost");
    			ComChkObjValid(formObj.calc_amt_vvd);
    	    	ComChkObjValid(formObj.calc_amt_ttl);
    			break;
    		case "sheet1_io":
    			//Calculating when In/out change
    			if(VALIDVVD == 7|| sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_validvvd")=="" && !formObj.credit_memo.checked){
    				setIoAndClptIndSeqCalc(sheetObj, Row, Col, Value);
    			}
    			break;
    		case "sheet1_credit" :	//Credit
        		var credit=sheetObj.GetCellValue(Row, "sheet1_credit");
        		if(credit == "1"){
    				sheetObj.SetCellValue(Row, "sheet1_tariff_cost","",0);
        			sheetObj.SetCellValue(Row, "sheet1_foml2","",0);
        			sheetObj.SetCellValue(Row, "sheet1_foml1","",0);
        			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no","",0);
	    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq","",0);
	        		
	    			setCalcAmtVvd();	//calc_amt_vvd (Amount of VVD same as selected row) 
	        		
	    			//NYK Modify 2014.11.26
	        		//formObj.calc_amt_ttl.value=ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
	        		//formObj.calc_amt_ttl.value=Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2);	//calc_amt_ttl
	    			ComChkObjValid(formObj.calc_amt_vvd);
	    	    	ComChkObjValid(formObj.calc_amt_ttl);
        		} else {
        			var tmpOriCostCd=sheetObj.GetCellValue(Row,"sheet1_cost_cd");
        			//sheetObj.SetCellValue(Row,"sheet1_cost_cd","",0);
        			sheetObj.SetCellValue(Row,"sheet1_cost_cd",tmpOriCostCd);
        			
        			setCostCalc(sheetObj, Row, Col, tmpOriCostCd);
        		}
        		break;	
	        case "sheet1_cost_cd":	//COST_CD
	        	setCostCalc(sheetObj, Row, Col, Value);
	        	break; 
	        case "sheet1_del_chk":
	        	setCalcAmtVvd();
	        	break;
	        case "sheet1_clpt_ind_seq":
	        	var tmpCostCd = sheetObj.GetCellValue(Row, "sheet1_cost_cd");
	        	if(!ComIsEmpty(tmpCostCd)){
	        		setIoAndClptIndSeqCalc(sheetObj, Row, Col, Value);
	        	}
	        	break;
	        default: 
	        	break;
        }//End of switch(Col)
//	        f_dataRowHeight(0);
    }
    
    function setIoAndClptIndSeqCalc(sheetObj, Row, Col, Value){
    	var formObj = document.form;
    
    	if(sheetObj.GetCellValue(Row, "sheet1_vsl_cd")==""){
			ComShowCodeMessage("PSO00003", "VSL_CD");
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}else if(sheetObj.GetCellValue(Row, "sheet1_skd_voy_no")==""){
			ComShowCodeMessage("PSO00003", "SKD_VOY_NO");
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}else if(sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd")==""){
			ComShowCodeMessage("PSO00003", "SKD_DIR_CD");
			sheetObjects[0].SelectCell(Row,"sheet1_vvd");
		}else{
			formObj.vsl_cd.value		= sheetObj.GetCellValue(Row, "sheet1_vsl_cd");
			formObj.skd_voy_no.value	= sheetObj.GetCellValue(Row, "sheet1_skd_voy_no");
			formObj.skd_dir_cd.value	= sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd");
			formObj.cost_cd.value		= sheetObj.GetCellValue(Row, "sheet1_cost_cd");
    		formObj.acct_cd.value		= sheetObj.GetCellValue(Row, "sheet1_acct_cd");
    		
    		formObj.io_flag.value		= sheetObj.GetCellText(Row, "sheet1_io");
    		formObj.clpt_ind_seq.value	= sheetObj.GetCellValue(Row, "sheet1_clpt_ind_seq"); //2016.04.26 Double Calling Add
    		
    		var isValidVvd	= doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);			
			
    		var credit		= sheetObjects[0].GetCellValue(Row, "sheet1_credit");
			var data="NO_CALCULATION";
			if(credit != "1"){	//Credit Unchecked!
			    data=doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);		//Calculation	
			}   
			//
			var ioCondChk="N";
			if(data=="NO_TARIFF_FOUND"){
				ComShowCodeMessage("PSO00030");
				//Clearing
				sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,"",0);
			} else if(data=="NO_CALCULATION"){
				sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,"",0);
			} else{
    			var calcData=data.split("^");
    			sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,calcData[0],0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,calcData[1],0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,calcData[2],0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,calcData[3],0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,calcData[4],0);
    			ioCondChk=calcData[5];
			}
			
			if(ioCondChk == "Y") {
	    		sheetObj.SetCellEditable(Row,"sheet1_io",1);
	    		
	    		sheetObj.SetCellValue(Row, "sheet1_io_chk"	,"Y",0);
	    	} else {
	    		sheetObj.SetCellEditable(Row,"sheet1_io",0);
	    		
	    		sheetObj.SetCellValue(Row, "sheet1_io_chk"	,"N",0);
	    		sheetObj.SetCellValue(Row, "sheet1_io"		,""	,0);
	    	}
			
			formObj.vvdband.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_cd") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_voy_no") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_dir_cd");
			formObj.atd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_atd");
    		
			setCalcAmtVvd();
			
    		//NYK Modify 2014.11.26
    		//formObj.calc_amt_ttl.value=ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
    		//formObj.calc_amt_ttl.value=Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2);
			ComChkObjValid(formObj.calc_amt_vvd);
	    	ComChkObjValid(formObj.calc_amt_ttl);
		}
    }
    
    function setCostCalc(sheetObj, Row, Col, Value){
    	var formObj = document.form;
    	var ioCondChk="N";
    	var tmpSelAcctCd = "";
    	
    	if(formObj.spcalangflg.value == "Y" && getCanalPort()){
    		tmpSelAcctCd = canalAccCdByCostCdList[Value];
    		sheetObj.SetCellValue(Row, "sheet1_acct_cd"			, canalAccCdByCostCdList[Value], 0);//Value : PTDUDK 에 따른 AccCd 찾기.
    		sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm", canalVndrLglEngNmCostCd[Value], 0);		        		
    	}else{
    		tmpSelAcctCd = accCdByCostCdList[Value];
    		sheetObj.SetCellValue(Row, "sheet1_acct_cd" 		, accCdByCostCdList[Value], 0);//Value : PTDUDK 에 따른 AccCd 찾기.
    		sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm", vndrLglEngNmCostCd[Value], 0);
    	}
    	
    	if(formObj.credit_memo.checked){
			formObj.vsl_cd.value		= sheetObj.GetCellValue(Row, "sheet1_vsl_cd");
			formObj.skd_voy_no.value	= sheetObj.GetCellValue(Row, "sheet1_skd_voy_no");
			formObj.skd_dir_cd.value	= sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd");
    		formObj.cost_cd.value		= sheetObj.GetCellValue(Row, "sheet1_cost_cd");
    		formObj.acct_cd.value		= sheetObj.GetCellValue(Row, "sheet1_acct_cd");//<----?
    		formObj.io_flag.value		= sheetObj.GetCellText(Row, "sheet1_io");
    		formObj.clpt_ind_seq.value	= sheetObj.GetCellValue(Row, "sheet1_clpt_ind_seq"); //2016.04.26 Double Calling Add
    		return;
    	}
    	
    	if((VALIDVVD ==7 || sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_validvvd")=="")){
			formObj.vsl_cd.value		= sheetObj.GetCellValue(Row, "sheet1_vsl_cd");
			formObj.skd_voy_no.value	= sheetObj.GetCellValue(Row, "sheet1_skd_voy_no");
			formObj.skd_dir_cd.value	= sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd");
    		formObj.cost_cd.value		= sheetObj.GetCellValue(Row, "sheet1_cost_cd");
    		formObj.acct_cd.value		= sheetObj.GetCellValue(Row, "sheet1_acct_cd");//<----?
    		formObj.io_flag.value		= sheetObj.GetCellText(Row, "sheet1_io");
    		formObj.clpt_ind_seq.value	= sheetObj.GetCellValue(Row, "sheet1_clpt_ind_seq"); //2016.04.26 Double Calling Add
    		
    		var isValidVvd = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
			
    		//2016.12.19 Add 중복사용체크
    		//var isCheckVal = isDoublePayment(sheetObj);
            
			var credit = sheetObj.GetCellValue(Row, "sheet1_credit");
			var data = "NO_CALCULATION";
			if(credit != "1"){	//Credit Unchecked!
			    data = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);		//Calculation	//[2010.02.24:jmh] Kim
			}  
			
			if(data=="NO_TARIFF_FOUND"){
				ComShowCodeMessage("PSO00030");
				sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,"",0);
				sheetObj.SetCellValue(Row, "sheet1_foml2"			,"",0);
				sheetObj.SetCellValue(Row, "sheet1_foml1"			,"",0);
				sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,"",0);
			} else if(data=="NO_CALCULATION"){
				sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,"",0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,"",0);
			} else{
    			var calcData=data.split("^");
    			sheetObj.SetCellValue(Row, "sheet1_tariff_cost"		,calcData[0],0);
    			sheetObj.SetCellValue(Row, "sheet1_foml2"			,calcData[1],0);
    			sheetObj.SetCellValue(Row, "sheet1_foml1"			,calcData[2],0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_no"		,calcData[3],0);
    			sheetObj.SetCellValue(Row, "sheet1_yd_chg_ver_seq"	,calcData[4],0);
    			ioCondChk=calcData[5];
			}
			
	    	if(ioCondChk == "Y") {
	    		sheetObj.SetCellEditable(Row,"sheet1_io",1);
	    		sheetObj.SetCellValue(Row, "sheet1_io_chk","Y",0);
	    		var vvd_cd 		= sheetObj.GetCellValue(Row, "sheet1_vvd");
	    		var clpt_ind_seq= sheetObj.GetCellValue(Row, "sheet1_clpt_ind_seq");
	    		var acct_cd		= tmpSelAcctCd;
	    		var io_cd		= sheetObj.GetCellValue(Row, "sheet1_io");
	    		var check_ind	= true;      		    	
	    		for(var ii=0;ii<sheetObj.RowCount();ii++){
	    			if (( vvd_cd  		== sheetObj.GetCellValue(ii, "sheet1_vvd")) && 
	    				( clpt_ind_seq	== sheetObj.GetCellValue(ii, "sheet1_clpt_ind_seq")) &&
	    			    ( acct_cd 		== sheetObj.GetCellValue(ii, "sheet1_acct_cd")) && 
	    			    (ii 			!= Row)){	
	    				check_ind=false;
	    				var io_cd=sheetObj.GetCellValue(ii, "sheet1_io");
	    				if (io_cd =="OUT") sheetObj.SetCellValue(Row, "sheet1_io","IN");
	    				if (io_cd =="IN")  sheetObj.SetCellValue(Row, "sheet1_io","OUT");
	    			}	
	    		}
	    		if (check_ind) sheetObj.SetCellValue(Row, "sheet1_io","OUT");
	    	} else {
	    		sheetObj.SetCellValue(Row, "sheet1_io"		,""	,0);
	    		sheetObj.SetCellValue(Row, "sheet1_io_chk"	,"N",0);
	    		
	    		sheetObj.SetCellEditable(Row,"sheet1_io",0);
	    		sheetObj.CellComboItem(Row,"sheet1_io", {ComboText:"|IN|OUT", ComboCode:"INOUT|IN|OUT"} );
	    	}  
	    	
			formObj.vvdband.value	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_cd") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_voy_no") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_dir_cd");
			formObj.atd.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_atd");
    		
	    	setCalcAmtVvd();
    		
			//NYK Modify 2014.11.26
    		//formObj.calc_amt_ttl.value=ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
    		//formObj.calc_amt_ttl.value=Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2);
			ComChkObjValid(formObj.calc_amt_vvd);
	    	ComChkObjValid(formObj.calc_amt_ttl);
	    	
    	}else{
    		if(sheetObj.GetCellValue(Row, "sheet1_vsl_cd")==""){
    			ComShowCodeMessage("PSO00003", "VSL_CD");
    			sheetObj.SelectCell(Row,"sheet1_vvd");
    		}
    		else if(sheetObj.GetCellValue(Row, "sheet1_skd_voy_no")==""){
    			ComShowCodeMessage("PSO00003", "SKD_VOY_NO");
    			sheetObj.SelectCell(Row,"sheet1_vvd");
    		}
    		else if(sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd")==""){
    			ComShowCodeMessage("PSO00003", "SKD_DIR_CD");
    			sheetObj.SelectCell(Row,"sheet1_vvd");
    		}
    		sheetObj.SetCellValue(Row, "sheet1_acct_cd"," ",0);
    		sheetObj.SetCellValue(Row, "sheet1_lgs_cost_full_nm"," ",0);
    		sheetObj.SetCellValue(Row, "sheet1_cost_cd"," ",0);
    		sheetObj.SelectCell(Row,"sheet1_vvd");
    	}
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	var formObj=document.form;
    	if(sheetObj.RowCount()> 0 ){
    		formObj.vvdband.value	= sheetObj.GetCellValue(Row, "sheet1_vsl_cd") + sheetObj.GetCellValue(Row, "sheet1_skd_voy_no") + sheetObj.GetCellValue(Row, "sheet1_skd_dir_cd");
    		formObj.atd.value		= sheetObj.GetCellValue(Row, "sheet1_atd");
    		
    		setCalcAmtVvd();
    		
    		ComChkObjValid(formObj.calc_amt_vvd);
    		
    		//memopad
    		var prefix="sheet1_";
    		var colname=sheetObj.ColSaveName(Col);
    		switch (colname) {
				case prefix+ "foml1":
				case prefix+ "foml2":
					//var tmpValue = sheetObj.GetCellValue(Row, Col);
					if(!ComIsEmpty(Value)){
						ComShowMemoPad(sheetObj, Row, Col, true, 800, null, null,1);
					}
					break;
    		}
    	}
    }
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	//alert("sheet1_OnSelectCell");
    	if(OldRow != NewRow){
    		var formObj=document.form;
    		var sheetObj2=sheetObjects[1];
			formObj.cbx_night.checked		= sheetObj.GetCellValue(NewRow, "sheet1_night") == "Y" ? true : false;
			formObj.cbx_holiday.checked		= sheetObj.GetCellValue(NewRow, "sheet1_holiday") == "Y" ? true : false;
			formObj.cbx_boat.checked		= sheetObj.GetCellValue(NewRow, "sheet1_boat") == "Y" ? true : false;
			formObj.cbx_tugrope.checked		= sheetObj.GetCellValue(NewRow, "sheet1_tugrope") == "Y" ? true : false;
			formObj.cbx_buoy.checked		= sheetObj.GetCellValue(NewRow, "sheet1_buoy") == "Y" ? true : false;
			formObj.cbx_sanitation.checked	= sheetObj.GetCellValue(NewRow, "sheet1_sanitation") == "Y" ? true : false;
			formObj.cbx_barge.checked		= sheetObj.GetCellValue(NewRow, "sheet1_barge") == "Y" ? true : false;
			formObj.cbx_inspection.checked	= sheetObj.GetCellValue(NewRow, "sheet1_inspection") == "Y" ? true : false;
			formObj.cbx_newservice.checked	= sheetObj.GetCellValue(NewRow, "sheet1_newservice") == "Y" ? true : false;
			formObj.cbx_copilot.checked		= sheetObj.GetCellValue(NewRow, "sheet1_copilot") == "Y" ? true : false;
			sheetObj2.SetCellValue(1, "sheet2_arrtp"	, sheetObj.GetCellValue(NewRow, "sheet1_arrtp"),0);
			sheetObj2.SetCellValue(1, "sheet2_deptp"	, sheetObj.GetCellValue(NewRow, "sheet1_deptp"),0);
			sheetObj2.SetCellValue(1, "sheet2_arrnt"	, sheetObj.GetCellValue(NewRow, "sheet1_arrnt"),0);
			sheetObj2.SetCellValue(1, "sheet2_depnt"	, sheetObj.GetCellValue(NewRow, "sheet1_depnt"),0);
			sheetObj2.SetCellValue(1, "sheet2_arrtuh"	, sheetObj.GetCellValue(NewRow, "sheet1_arrtuh"),0);
			sheetObj2.SetCellValue(1, "sheet2_deptuh"	, sheetObj.GetCellValue(NewRow, "sheet1_deptuh"),0);
			sheetObj2.SetCellValue(1, "sheet2_arrlh"	, sheetObj.GetCellValue(NewRow, "sheet1_arrlh"),0);
			sheetObj2.SetCellValue(1, "sheet2_deplh"	, sheetObj.GetCellValue(NewRow, "sheet1_deplh"),0);
			sheetObj2.SetCellValue(1, "sheet2_usdhrs"	, sheetObj.GetCellValue(NewRow, "sheet1_usdhrs"),0);
			//2015.02.10 ADD
			sheetObj2.SetCellValue(1, "sheet2_sdr"		, sheetObj.GetCellValue(NewRow, "sheet1_sdr"),0);
			sheetObj2.SetCellValue(1, "sheet2_tier"		, sheetObj.GetCellValue(NewRow, "sheet1_tier"),0);
			sheetObj2.SetCellValue(1, "sheet2_limit_time",sheetObj.GetCellValue(NewRow, "sheet1_limit_time"),0);
			sheetObj2.SetCellValue(1, "sheet2_other_value",sheetObj.GetCellValue(NewRow, "sheet1_other_value"),0);
			
			formObj.cbx_others.checked		= sheetObj.GetCellValue(NewRow, "sheet1_others") == "Y" ? true : false;
    	}
    	if(sheetObj.ColSaveName(OldCol) == "sheet1_vvd"){
    		var sheet1_vvd=sheetObj.GetCellValue(OldRow, OldCol);
    		if(sheet1_vvd.length == 0){
    		} else if(sheet1_vvd.length != 9){
    			if(OldRow >= sheetObj.HeaderRows()){
    				sheetObj.SetCellValue(OldRow, OldCol,"");
    			}
    			document.form.vvdband.value="";
    		}
    	}
    }
    function sheet2_OnBeforeEdit(sheetObj,Row,Col){
    	var sheetObject1=sheetObjects[0];
    	if(sheetObject1.RowCount()>0){
    		return;
	    	switch(Col){
	    		case 2://arrtp
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 3://deptp
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	    			break;
	    		case 4://arrnt
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 5://depnt
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
	    			break;
	    		case 6://arrtuh
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 7://deptuh
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 8://arrlh
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 9://deplh
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 10://usdhrs
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 11://other_value
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 12://sdr
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 13://tier
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    		case 14://limit_time
	    			sheetObj.InitCellProperty(Row, Col,{ Type:"Float",Align:"Right",Format:"NullFloat"} );
		    		break;
	    	}
    	}
    }
    function sheet2_OnAfterEdit(sheetObj, Row, Col){
    	var formObj=document.form;
    	var prefix="sheet2_";
    	var iMaxLen = 10;
    	switch (sheetObj.ColSaveName(Col)) {
	    	case prefix + "arrtp" :
	    	case prefix + "deptp" :
	    	case prefix + "arrnt" :
	    	case prefix + "depnt" :
	    	case prefix + "arrtuh" :
	    	case prefix + "deptuh" :
	    	case prefix + "arrlh" :
	    	case prefix + "deplh" :
	    	case prefix + "usdhrs" :
	    	case prefix + "other_value" :
	    	case prefix + "tier" :
	    	case prefix + "limit_time" :
				var val=sheetObj.GetCellValue(Row, Col);
				if(!f_SetCipherLess(val, iMaxLen, 3)){
					sheetObj.SetCellValue(Row, Col,"",0);
				}
			break;
	    	case prefix + "sdr" :
				var val=sheetObj.GetCellValue(Row, Col);
				if(!f_SetCipherLess(val, iMaxLen, 4)){
					sheetObj.SetCellValue(Row, Col,"",0);
				}
			break;
    	}    	
    	
		f_SetValuesIntoSheet1(sheetObj, Row, Col);
    }	
    
    
    function sheet2_OnChange(sheetObj,Row,Col) {
    	f_SetValuesIntoSheet1(sheetObj, Row, Col);
    }
//    function sheet2_OnSearchEnd(sheetObj, code, ErrMsg){
//	   if( sheetObj.RowCount() < 1){
//	          InitHeadColumn(leftHeaders,sheetObj);
//	    } else {
//	     InitHeadText(leftHeaders,sheetObj);
//	   }
//    }
//    function sheet2_OnLoadFinish(sheetObj){
//// 	   if( sheetObj.RowCount() < 1){
// 	          InitHeadColumn(leftHeaders,sheetObj);
//// 	    } else {
//// 	     InitHeadText(leftHeaders,sheetObj);
//// 	   }
//     }
    function f_SetValuesIntoSheet1(sheetObj, Row, Col){
    	var sheetObject1=sheetObjects[0];
    	if(sheetObject1.RowCount()>0){
    		var cellVal=sheetObj.GetCellValue(Row, Col)+"";
    		//var dfVal=(cellVal.indexOf(".") == -1 ? "NullInteger" : "NullFloat");
    		var colName=sheetObj.ColSaveName(Col);
    		switch(colName){
	    		case "sheet2_arrtp"://arrtp
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtp", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_arrtp",cellVal,0);
		    		break;
	    		case "sheet2_deptp"://deptp
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptp", "", dfVal);
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_deptp",cellVal,0);
	    			break;
	    		case "sheet2_arrnt"://arrnt
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrnt", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_arrnt",cellVal,0);
		    		break;
	    		case "sheet2_depnt"://depnt
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_depnt", "", dfVal);
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_depnt",cellVal,0);
	    			break;
	    		case "sheet2_arrtuh"://arrtuh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrtuh", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_arrtuh",cellVal,0);
		    		break;
	    		case "sheet2_deptuh"://deptuh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deptuh", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_deptuh",cellVal,0);
		    		break;
	    		case "sheet2_arrlh"://arrlh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_arrlh", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_arrlh",cellVal,0);
		    		break;
	    		case "sheet2_deplh"://deplh
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_deplh", "", dfVal);
		    		sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_deplh",cellVal,0);
		    		break;
	    		case "sheet2_usdhrs"://usdhrs
	    			//sheetObj.InitCellProperty(Row, Col, dtData, daCenter, "sheet2_usdhrs", "", dfVal);
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_usdhrs",cellVal,0);
		    		break;
	    		case "sheet2_other_value"://other_value
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_other_value",cellVal,0);
		    		break;
	    		case "sheet2_sdr"://sdr
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_sdr",cellVal,0);
		    		break;
	    		case "sheet2_tier"://tier
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_tier",cellVal,0);
		    		break;
	    		case "sheet2_limit_time"://limit_time
	    			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "sheet1_limit_time",cellVal,0);
		    		break;
	    		break;
	    	}
    	}    	
    }
    /**
     * Setting Terminal name
     * @param obj
     * @return
     */
    function displayTmnlNm(obj){
    	var formObj=document.form;
    	var dspNm=eval("tmnlName._"+obj.value);
    	dspNm=(typeof dspNm =="undefined") ? "" : dspNm;
    	formObj.tmnl_nm.value=dspNm;
    	var dspVal=eval("costOfc._"+obj.value);
    	dspVal=(typeof dspVal =="undefined") ? "" : dspVal;
    	formObj.cost_ofc.value=dspVal; 
    	var currVal=eval("currCdList._"+obj.value);
    	currVal=(typeof currVal =="undefined") ? "" : currVal;
    	
        gCurrCd = currVal;
    	ComSetObjValue(formObj.curr_cd, gCurrCd);
    	//curr_cd.SetSelectCode(gCurrCd, 0); //2016.08.18 Add
    	
    	f_SetTrnsSlp();
    }
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var sText=sheetObj.GetCellText(Row,Col);
        if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
		ComOpenWait(false);
    	var formObj=document.form;
    	
    	f_SetCostOfc();
    	
    	var stsCd=sheetObj.GetCellValue(1, "sheet1_pso_chg_sts_cd");
		if(typeof stsCd == "string"){
			formObj.pso_chg_sts_cd.value=stsCd; 
			if(stsCd == "A"){
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Confirm");
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDelete");
				ComBtnDisable("btn_Calculation");
				ComBtnEnable("btn_Delete");
				sheetObj.SetEditable(0);
				document.getElementById("btn_Delete").innerHTML="Confirm Cancel";
			}
			else{
				if(sheetObj.RowCount()!= 0)
					ComBtnEnable("btn_Save");
				ComBtnEnable("btn_Confirm");
				ComBtnEnable("btn_Delete");
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_RowDelete");
				ComBtnEnable("btn_Calculation");
				document.getElementById("btn_Delete").innerHTML="Delete";
			}
		}
		if(sheetObj.RowCount() == 0){
			if(!g_isExist)
				ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_Delete");
		}
		else{
			formObj.vvdband.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vsl_cd") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_voy_no") + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_skd_dir_cd");
			formObj.atd.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_atd");
			//formObj.inv_amt.value 		= sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount");
			//var tmpCalcAmtVvd = sheetObj.GetCellValue(sheetObj.SelectRow, "sheet1_amount");
			//formObj.calc_amt_vvd.value 	= ComAddComma(Number(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_amount")).toFixed(2));
    		setCalcAmtVvd();
    		//formObj.calc_amt_ttl.value	= ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
    		//formObj.calc_amt_ttl.value= Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2);
    		var yd_cd 					= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_yd_cd");
    		formObj.yd_cd.value			= yd_cd;
    		//formObj.yd_cd.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_yd_cd");
    		//$("#sel_yd_cd").prepend("<option value='sel_yd_cd' selected>CNSHAM1</option>");
			//formObj.inv_amt.value 	= sheetObj.CellValue(sheetObj.SelectRow, "sheet1_ttl_locl_amt");	//
    		
    		setTerminalInfo();

            var tmpCurrCd               = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_curr_cd");//2016.08.18 Add
    		formObj.curr_cd.value		= tmpCurrCd;
    		//var tmpInvCurrCd = curr_cd.GetSelectCode();//2016.08.18 Add
    		//if(tmpCurrCd != tmpInvCurrCd) curr_cd.SetSelectCode(tmpCurrCd, 0); //2016.08.18 Add
    		
	    	formObj.cost_ofc.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_cost_ofc_cd");
	    	
    		formObj.inv_amt.value		= ComAddComma(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_inv_locl_amt"));	//xxx
    		formObj.vat.value			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_locl_tax_amt");		//VAT
    		formObj.whld_tax.value		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_locl_whld_tax_amt");		//Withholding Tax
    		//formObj.eff_dt.value 		= sheetObj.GetCellValue(sheetObj.SelectRow, "sheet1_eff_dt");
			formObj.trnsf_slp.checked	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_pso_trns_slp_ctnt") == "AR" ? true : false ;
			setDateFormat(formObj.iss_dt, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_iss_dt")	, "ymd");
			setDateFormat(formObj.rcv_dt, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_acpt_dt")	, "ymd");
			
			ComChkObjValid(formObj.inv_amt);
	    	ComChkObjValid(form.vat);
	    	ComChkObjValid(formObj.iss_dt);
	    	ComChkObjValid(form.rcv_dt);
	    	ComChkObjValid(formObj.calc_amt_vvd);
	    	ComChkObjValid(formObj.calc_amt_ttl);
    	
	    	//sheetObj.SetSumText(0,1,"Grand Total");
            sheetObj.SetSumText(0, 2, "Total");
            sheetObj.SetSumBackColor("#F6CEF5");
	    	sheetObj.SetMergeCell(sheetObj.LastRow()+1,0,1,7);
		}
		
		initDefaultAccountAndCostComboItem(sheetObj);
		
		//2016.04.26 Cell ComboItem : Io, clpt_ind_seq
		initDefaultCellComboItem(sheetObj); 	
    	
    }
    
    function setTerminalInfo(flag){
    	var formObj = document.form;
    	
    	var dspNm=eval("tmnlName._"+formObj.yd_cd.value);
		dspNm=(typeof dspNm =="undefined") ? "" : dspNm;
		formObj.tmnl_nm.value=dspNm;
		
		var ofcNm=eval("costOfc._"+formObj.yd_cd.value);
		ofcNm=(typeof ofcNm =="undefined") ? "" : ofcNm;
		formObj.cost_ofc.value=ofcNm;
		
		if(flag == "SEL_COST"){
			f_SetCostOfc();
		}else{
			//Setting Currency Code of User
			var currCdVal=eval("currCdList._"+formObj.yd_cd.value);
			currCdVal=(typeof currCdVal =="undefined") ? "" : currCdVal;
			
			gCurrCd = currCdVal;
			ComSetObjValue(formObj.curr_cd, gCurrCd);
			//curr_cd.SetSelectCode(currCdVal , 0);// 2016.08.18 Add
			
		}
    }
    
  
    function setDateFormat( obj, inDate, format ) {
    	var year=inDate.substring(0, 4);
    	var month=inDate.substring(4, 6);
    	var date=inDate.substring(6, 8);
    	switch(format){
    	case "y" : 
    	case "ym" : 
    	case "ymd" :
    		theDay = year + '-' + month + '-' + date;
    		break;
    	default :
    		theDay = year + '-' + month + '-' + date;
    	break;
    	}
    	obj.value=theDay;
    	return;  
    } 
    
    /**
     * Setting AMT VVD of AMT(VVD/TTL)
     * @return
     */
    function setCalcAmtVvd(){
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	if(sheetObj.RowCount()> 0){
    		var curVvd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_vvd"); //vvd of selected row
    		var curVal=0 ;//sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_amount");
    		var curTtlVal = 0;
	    	for(var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount(); i++){
//	    		if(i==sheetObj.SelectRow) continue;
	    		if(sheetObj.GetCellValue(i, "sheet1_del_chk") == 1) continue;
	    		row=sheetObj.FindText("sheet1_vvd", curVvd, i, -1); //Finding row which have VVD
	    		if(row>0){
	    			curVal += (sheetObj.GetCellValue(row, "sheet1_amount"))*1;
	    			//curTtlVal += (sheetObj.GetCellValue(row, "sheet1_amount"))*1;
	    			i=row;
	    		}
	    	}
	    	//NYK Modify 2014.11.26
    		formObj.calc_amt_vvd.value=ComAddComma(Number(curVal).toFixed(2));
    		//formObj.calc_amt_ttl.value=ComAddComma(Number(curTtlVal).toFixed(2));
    		formObj.calc_amt_ttl.value=ComAddComma(Number(sheetObj.GetCellValue(sheetObj.RowCount()+1, "sheet1_amount")).toFixed(2));
    		
    		//formObj.calc_amt_vvd.value=curVal.toFixed(2);
    		if(sheetObj.RowCount("D") == sheetObj.RowCount()){
    			formObj.vvdband.value="";
    			formObj.atd.value=""; 
    		}
    		
    	}else{
    		formObj.vvdband.value="";
    		formObj.atd.value=""; 
    		formObj.calc_amt_vvd.value="";
    		formObj.calc_amt_ttl.value="";
    	}
    }
    /* 
     * in case Terminal is 'KR', Activating Transfer Slip
     */ 
    function f_SetTrnsSlp(){
    	var formObj=document.form;
    	var nation=formObj.yd_cd.value.substr(0, 2);
    	if(nation == "KR"){
    		formObj.trnsf_slp.disabled=false;
    	} else{
    		formObj.trnsf_slp.disabled=true;    		
    		formObj.trnsf_slp.checked=false;
    	}
    }
	/*
	 * after Checking Invoice No is exist, Retrieving
	 */     
	function f_ExistsInvNo(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
		var sheetObject=sheetObjects[0];
	  	var sheetObj2=sheetObjects[1];
		
	  	var curSpcode = formObj.spcode.value;
	  	var curInvNo = formObj.inv_no.value;
	  	
	  	if(ComIsEmpty(ComTrim(curSpcode)) || ComIsEmpty(ComTrim(curInvNo)) || (curSpcode == oldSpcode && curInvNo == oldInvNo)){ // || isExistInvNo
			return;
		}		
		
		//Checking Invoice No is exist
		var rtlVal = "N";
		rtlVal=doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC08);
		/*******************************************************/
		if(!ComIsEmpty(rtlVal) && "Y"==rtlVal){
			ComShowCodeMessage("PSO00044"); //This Inv No. already exists.
			g_isExist=true;
			ComBtnDisable("btn_Save");
			sheetObject1.SetEditable(1);
			formObj.inv_amt.value="";
			formObj.vat.value="";
			if(!g_isEnterKey){
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			} else{
				g_isEnterKey=false;
			}
			
			setTerminalInfo("SEL_COST");
			/*
			var dspNm=eval("tmnlName._"+formObj.yd_cd.value);
			dspNm=(typeof dspNm =="undefined") ? "" : dspNm;
			formObj.tmnl_nm.value=dspNm;
			var ofcNm=eval("costOfc._"+formObj.yd_cd.value);
			ofcNm=(typeof ofcNm =="undefined") ? "" : ofcNm;
			formObj.cost_ofc.value=ofcNm;
			f_SetCostOfc();
			*/
			isRClick=true;
			isExistInvNo = true;
			oldSpcode = formObj.spcode.value;
			oldInvNo = formObj.inv_no.value;
			return;
		} else{
			g_isExist=false;
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_Delete");
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowDelete");
			ComBtnEnable("btn_Calculation");
			var spCode=formObj.spcode.value;
			var spName=formObj.spname.value;
			var invNo=formObj.inv_no.value;
			formObj.reset();
			formObj.spcode.value=spCode;
			formObj.spname.value=spName;
			formObj.inv_no.value=invNo;
			
			setTerminalInfo("DFT_COST");
			
			//Setting iss_dt to today
			setToday(document.form.iss_dt, 'ymd');
			setToday(document.form.rcv_dt, 'ymd');			

			isExistInvNo = false;

			oldSpcode = formObj.spcode.value;
			oldInvNo = formObj.inv_no.value;
			
			initDefaultAccountAndCostComboItem(sheetObjects[0]);
		}
		sheetObject.RemoveAll();
		//sheetObjects[1].RemoveAll();
		//checkbox CLEAR
		formObj.cbx_night.checked=false;          
		formObj.cbx_holiday.checked=false;
		formObj.cbx_boat.checked=false;
		formObj.cbx_tugrope.checked=false;
		formObj.cbx_buoy.checked=false;
		formObj.cbx_sanitation.checked=false;
		formObj.cbx_barge.checked=false;
		formObj.cbx_inspection.checked=false;
		formObj.cbx_newservice.checked=false;
		formObj.cbx_copilot.checked=false;
		formObj.cbx_others.checked=false;//2015.02.10 ADD
		formObj.vvdband.value="";
		formObj.atd.value="";
		sheetObject.SetEditable(1);//[jmh]?
		isRClick=false;//Clearing public variable
		//SHEET2 CLEAR
		sheetObj2.SetCellValue(1, "sheet2_arrtp","",0);
		sheetObj2.SetCellValue(1, "sheet2_deptp","",0);
		sheetObj2.SetCellValue(1, "sheet2_arrnt","",0);
		sheetObj2.SetCellValue(1, "sheet2_depnt","",0);
		sheetObj2.SetCellValue(1, "sheet2_arrtuh","",0);
		sheetObj2.SetCellValue(1, "sheet2_deptuh","",0);
		sheetObj2.SetCellValue(1, "sheet2_arrlh","",0);
		sheetObj2.SetCellValue(1, "sheet2_deplh","",0);
		sheetObj2.SetCellValue(1, "sheet2_usdhrs","",0);
  		//2015.02.10 NYK ADD.
  		sheetObj2.SetCellValue(1, "sheet2_sdr","",0);
  		sheetObj2.SetCellValue(1, "sheet2_tier","",0);
  		sheetObj2.SetCellValue(1, "sheet2_limit_time","",0);
  		sheetObj2.SetCellValue(1, "sheet2_other_value","",0);
	}
	function getOfcCd(rowArray) {
		var colArray=rowArray[0];
		document.all.cost_ofc.value=(colArray[3]!=undefined&&colArray[3]!=null?colArray[3]:'');
	} 
	function f_SetTitleInControls(){
		var formObj=document.form;
		var msg=ComGetMsg("PSO00045", "Invoice No.", "20");
		formObj.inv_no.title=msg;							//Please input Invoice No. below 20 letters. 
		document.getElementById("td_inv_no").title=msg;	//Please input Invoice No. below 20 letters. 
	}
	
	/*
	 * Setting Cost Office
	 */
	function f_SetCostOfc(){
		if(sheetObjects[0].RowCount() > 0){
			var formObj=document.form;
			var costOfcCdInSheet=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_cost_ofc_cd");
			var ofcNm=eval("costOfc._"+formObj.yd_cd.value);
			ofcNm=(typeof ofcNm =="undefined") ? "" : ofcNm;
			formObj.cost_ofc.value=costOfcCdInSheet != "" ? costOfcCdInSheet : ofcNm;
		}
	}
	/* 
	 * in case IN/OUT is in Condition and data of IO is null, Showing message and focus
	 */
	function checkIoChk() {
		var sheetObj=sheetObjects[0];
		 for(i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
			 //in case io_chk is Y and IO is INOUT, Showing message and focus
			 if(sheetObj.GetCellValue(i,"sheet1_io_chk")=="Y" && sheetObj.GetCellValue(i,"sheet1_io") == "INOUT") {
				 ComShowCodeMessage("PSO00003", "IO");
				 sheetObj.SelectCell(i, "sheet1_io", true);
				 return false;
			 }
		 }
		 return true;
	}
	
	/*
	 * NYK Modify 2014.10.08
	 * Adjustment Cost에 입력을 한 경우 Remark 항목 강제 입력 Check.
	 */
	function checkRemarks(){
		var sheetObj = sheetObjects[0];
		 for(i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
			 //Adjustment Cost에 입력을 한 경우 Remark 항목 강제 입력 Check.
			 if(sheetObj.GetCellValue(i,"sheet1_adjcost")!="" && sheetObj.GetCellValue(i,"sheet1_remark") == "") {
				 ComShowCodeMessage("PSO00036", "Remark(s)");
				 sheetObj.SelectCell(i, "sheet1_remark", true);
				 return false;
			 }
		 }
		 return true;
	}
	
	/* 
	 * in case amount > 0 then Handling credit check to not allow
	 */
	function sheet1_OnBeforeCheck(sheetObj, Row, Col){
		var colSaveName=sheetObj.ColSaveName(Col);
		switch (colSaveName) {
			case "sheet1_credit":
				var adj_amt=Number(sheetObj.GetCellValue(Row, "sheet1_adjcost"))
				if (adj_amt > 0) {
					ComShowCodeMessage("PSO01004");
					sheetObj.SetAllowCheck(false);
				}
				else {
					sheetObj.SetAllowCheck(true);
				}
				break;
			default:
		}
	}
	
	function initMasterData(sXml){
		var formObj = document.form;		
		
		//마스터 정보만 입력 한 경우.
  		var yd_cd				=ComGetEtcData(sXml, "yd_cd");
  		var inv_locl_amt		=ComGetEtcData(sXml, "inv_locl_amt");
  		var locl_tax_amt		=ComGetEtcData(sXml, "locl_tax_amt");
  		var locl_whld_tax_amt	=ComGetEtcData(sXml, "locl_whld_tax_amt");
  		gCurrCd			        =ComGetEtcData(sXml, "curr_cd");
  		var pso_trns_slp_ctnt	=ComGetEtcData(sXml, "pso_trns_slp_ctnt");
  		var pso_chg_sts_cd		=ComGetEtcData(sXml, "pso_chg_sts_cd");
  		var iss_dt				=ComGetEtcData(sXml, "iss_dt");
  		var acpt_dt				=ComGetEtcData(sXml, "acpt_dt");
  		var cost_ofc_cd			=ComGetEtcData(sXml, "cost_ofc_cd");
  		var iss_cty_cd			=ComGetEtcData(sXml, "iss_cty_cd");
  		var so_seq				=ComGetEtcData(sXml, "so_seq");
  		  		
  		if(ComIsEmpty(pso_chg_sts_cd) || "A" != pso_chg_sts_cd){
  			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnEnable("btn_Delete");
			
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowDelete");
			ComBtnEnable("btn_Calculation");
			document.getElementById("btn_Delete").innerHTML="Delete";
  		}
  		
  		formObj.yd_cd.value			= yd_cd;
  		formObj.inv_amt.value		= ComAddComma(inv_locl_amt);	//xxx
  		formObj.vat.value			= locl_tax_amt;		//VAT
  		formObj.whld_tax.value		= locl_whld_tax_amt;		//Withholding Tax
		formObj.curr_cd.value		= gCurrCd;
		//curr_cd.SetSelectCode(gCurrCd , 0);//2016.08.18 Add
		
		formObj.trnsf_slp.checked	= (pso_trns_slp_ctnt == "AR") ? true : false ;
		setDateFormat(formObj.iss_dt, iss_dt, "ymd");
		setDateFormat(formObj.rcv_dt, acpt_dt, "ymd");
		formObj.cost_ofc.value		= cost_ofc_cd;	
		
		formObj.iss_cty_cd.value	= iss_cty_cd;
		formObj.so_seq.value		= so_seq;
		
		ComChkObjValid(formObj.inv_amt);
    	ComChkObjValid(form.vat);
    	ComChkObjValid(formObj.iss_dt);
    	ComChkObjValid(form.rcv_dt);
    	
    	initDefaultAccountAndCostComboItem(sheetObjects[0]);
	} 
	/*
	 *  Setting data with integerPlace and decimalPlace
	 */
	function f_SetCipherLess(val, integerPlace, decimalPlace){
		val = val+"";
		var arrVal=val.split(".");
		if(arrVal.length == 1){
			if(arrVal[0].length > integerPlace){
				ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
				return false;
			}
		} else if(arrVal.length == 2){
			if(arrVal[0].length > integerPlace){
				ComShowCodeMessage("PSO00023", "[The Part Of The Integer]", "[Less Than or Equal To " + integerPlace + "-Digit]");
				return false;
			}
			if(arrVal[1].length > decimalPlace){
				ComShowCodeMessage("PSO00023", "[The Part Of The Decimal]", "[Less Than or Equal To " + decimalPlace + "-Digit]");
				return false;
			}
		}	
		return true;
	}
	
	function f_ExistsExchangeRateYn(){
		var formObj=document.form;
		//Checking Exchange Rate is exist
		var rtlVal=doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		if("Y" == rtlVal){
			return true; // 환율 존재.
		}else{ 
			return false; // 환율 존재하지 않을때 사용자한테 물어봄. 
		}
	}
	
	function checkArMasterRevenueVvd(){
		var formObj=document.form;
		//Checking Exchange Rate is exist
		var rtlVal=doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC11);
		
		if(""!=rtlVal){
			//ar에 vvd가 존재 하지 않음 message를 물어 봄.
			//There is no related revenue VVD, Would you continue?\n{msg}
			/* 2016.04.01 Add.
			if(!ComShowCodeConfirm("PSO01011", "["+rtlVal+"]")){
				return false;
			}else{
				return true;
			}
			*/
			ComShowCodeMessage("PSO01011", "["+rtlVal+"]");
			return false;
		}else{
			return true; //ar에 vvd 가 존재함.
		}
		
	}
	
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0], 150);
	    /*for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }*/
	}
	
	//순서 중요 : inArrNT^inDepNT^inArrTP^inDepTP^inArrTUH^inDepTUH^inArrLH^inDepLH^inUsdhrs^inSDR^inTier^inLimitTm^inOtherValue^
	//         chkBoat^chkBarge^chkBuoy^chkHoliday^chkInspection^chkNight^chkSanit^chkTUGRope^chkNewservice^chkOthers^chkCopilot
	function setAddInformationValue(valueInfo){
		var formObj 		= document.form;
		valueInfo			= valueInfo +""; //강제로 String Type 으로 변경한다.
		var valueData		= valueInfo.split("^");
		var sheetObj		= sheetObjects[0];
		var sheetObj2		= sheetObjects[1];
		
		var inArrNT 		= valueData[0];
		var inDepNT 		= valueData[1];
		var inArrTP 		= valueData[2];
		var inDepTP 		= valueData[3];
		var inArrTUH 		= valueData[4];
		var inDepTUH 		= valueData[5];
		var inArrLH 		= valueData[6];
		var inDepLH 		= valueData[7];
		var inUsdhrs 		= valueData[8];
		var inSDR 			= valueData[9];
		var inTier 			= valueData[10];
		var inLimitTm 		= valueData[11];
		var inOtherValue	= valueData[12];
		var chkBoat 		= valueData[13];
		var chkBarge 		= valueData[14];
		var chkBuoy 		= valueData[15];
		var chkHoliday 		= valueData[16];
		var chkInspection	= valueData[17];
		var chkNight 		= valueData[18];
		var chkSanit 		= valueData[19];
		var chkTUGRope 		= valueData[20];
		var chkNewservice	= valueData[21];
		var chkOthers 		= valueData[22];
		var chkCopilot 		= valueData[23];
		
		
		//1. Row Add 한 Sheet에 데이타 Set.
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_night"		, chkNight		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_holiday"		, chkHoliday	, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_boat"		, chkBoat		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_tugrope"		, chkTUGRope	, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_buoy"		, chkBuoy		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_sanitation"	, chkSanit		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_barge"		, chkBarge		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_inspection"	, chkInspection	, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_newservice"	, chkNewservice	, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_copilot"		, chkCopilot	, 0);
		
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_arrtp"		, inArrTP		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_deptp"		, inDepTP		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_arrnt"		, inArrNT		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_depnt"		, inDepNT		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_arrtuh"		, inArrTUH		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_deptuh"		, inDepTUH		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_arrlh"		, inArrLH		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_deplh"		, inDepLH		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_usdhrs"		, inUsdhrs		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_sdr"			, inSDR			, 0);
		
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_tier"		, inTier		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_limit_time"	, inLimitTm		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_others"		, chkOthers		, 0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_other_value"	, inOtherValue	, 0);
		
		//2. Add Information Sheet 데이타 Set.
		var NewRow = sheetObj.GetSelectRow();
		sheetObj2.SetCellValue(1, "sheet2_arrtp"		,sheetObj.GetCellValue(NewRow, "sheet1_arrtp")		,0);
		sheetObj2.SetCellValue(1, "sheet2_deptp"		,sheetObj.GetCellValue(NewRow, "sheet1_deptp")		,0);
		sheetObj2.SetCellValue(1, "sheet2_arrnt"		,sheetObj.GetCellValue(NewRow, "sheet1_arrnt")		,0);
		sheetObj2.SetCellValue(1, "sheet2_depnt"		,sheetObj.GetCellValue(NewRow, "sheet1_depnt")		,0);
		sheetObj2.SetCellValue(1, "sheet2_arrtuh"		,sheetObj.GetCellValue(NewRow, "sheet1_arrtuh")		,0);
		sheetObj2.SetCellValue(1, "sheet2_deptuh"		,sheetObj.GetCellValue(NewRow, "sheet1_deptuh")		,0);
		sheetObj2.SetCellValue(1, "sheet2_arrlh"		,sheetObj.GetCellValue(NewRow, "sheet1_arrlh")		,0);
		sheetObj2.SetCellValue(1, "sheet2_deplh"		,sheetObj.GetCellValue(NewRow, "sheet1_deplh")		,0);
		sheetObj2.SetCellValue(1, "sheet2_usdhrs"		,sheetObj.GetCellValue(NewRow, "sheet1_usdhrs")		,0);
		//2015.02.10 ADD
		sheetObj2.SetCellValue(1, "sheet2_sdr"			,sheetObj.GetCellValue(NewRow, "sheet1_sdr")		,0);
		sheetObj2.SetCellValue(1, "sheet2_tier"			,sheetObj.GetCellValue(NewRow, "sheet1_tier")		,0);
		sheetObj2.SetCellValue(1, "sheet2_limit_time"	,sheetObj.GetCellValue(NewRow, "sheet1_limit_time")	,0);
		sheetObj2.SetCellValue(1, "sheet2_other_value"	,sheetObj.GetCellValue(NewRow, "sheet1_other_value"),0);
		
		//3. Add Information Check Box 데이타 Set.
		formObj.cbx_night.checked		=sheetObj.GetCellValue(NewRow, "sheet1_night") 		== "Y" ? true : false;
		formObj.cbx_holiday.checked		=sheetObj.GetCellValue(NewRow, "sheet1_holiday") 	== "Y" ? true : false;
		formObj.cbx_boat.checked		=sheetObj.GetCellValue(NewRow, "sheet1_boat") 		== "Y" ? true : false;
		formObj.cbx_tugrope.checked		=sheetObj.GetCellValue(NewRow, "sheet1_tugrope") 	== "Y" ? true : false;
		formObj.cbx_buoy.checked		=sheetObj.GetCellValue(NewRow, "sheet1_buoy") 		== "Y" ? true : false;
		formObj.cbx_sanitation.checked	=sheetObj.GetCellValue(NewRow, "sheet1_sanitation") == "Y" ? true : false;
		formObj.cbx_barge.checked		=sheetObj.GetCellValue(NewRow, "sheet1_barge") 		== "Y" ? true : false;
		formObj.cbx_inspection.checked	=sheetObj.GetCellValue(NewRow, "sheet1_inspection") == "Y" ? true : false;
		formObj.cbx_newservice.checked	=sheetObj.GetCellValue(NewRow, "sheet1_newservice") == "Y" ? true : false;
		formObj.cbx_copilot.checked		=sheetObj.GetCellValue(NewRow, "sheet1_copilot") 	== "Y" ? true : false;
		formObj.cbx_others.checked		=sheetObj.GetCellValue(NewRow, "sheet1_others") 	== "Y" ? true : false;
	}
	
	function initDefaultCellComboItem(sheetObj){
		var iStartRow 	= sheetObj.HeaderRows();
		var iEndRow 	= sheetObj.LastRow();
		
		//Total 이 있으므로 < iEndRow 로 비교 사용.
		for(var i=iStartRow;i<iEndRow;i++) {
			//Inbound/Outbound 구분.
    		if(sheetObj.GetCellValue(i,"sheet1_io_chk")=="Y" || sheetObj.GetCellValue(i, "sheet1_io") !=  "INOUT") {
    			sheetObj.SetCellEditable(i,"sheet1_io",1);
    			sheetObj.CellComboItem(i,"sheet1_io", {ComboText:"IN|OUT", ComboCode:"IN|OUT"} );
	    	} else {
	    		sheetObj.SetCellEditable(i,"sheet1_io",0);
	    		sheetObj.CellComboItem(i,"sheet1_io", {ComboText:"|IN|OUT", ComboCode:"INOUT|IN|OUT"} );
	    	}
    		
    		//2016.04.26 CLPT_IND_SEQ Combo Item Setting
	    	var clptIndSeqComboItems= sheetObj.GetCellValue(i, "sheet1_clpt_ind_seqs");
	    	
	    	var tmpClptIndSeqComboItems = clptIndSeqComboItems.split("|");
	    	if(tmpClptIndSeqComboItems.length == 1){
	    		sheetObj.InitCellProperty	(i, "sheet1_clpt_ind_seq"	,{ Type:"Text",Align:"Center"} );
	    		sheetObj.SetCellEditable	(i, "sheet1_clpt_ind_seq"	, 0);
	    	}else{
	    		//sheetObj.InitCellProperty	(i, "sheet1_clpt_ind_seq"	,{ Type:"Combo",Align:"Center"} );
	    		sheetObj.CellComboItem		(i, "sheet1_clpt_ind_seq"	, {ComboText:clptIndSeqComboItems, ComboCode:clptIndSeqComboItems} );
	    		sheetObj.SetCellEditable	(i, "sheet1_clpt_ind_seq"	, 1);
	    	}
    	}
	}
	
	function isDoublePayment(sheetObj){
	    var formObj = document.form;
        //2016.12.19 Add 중복사용체크
        
	    var checkInv = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC13);
        
	    //message
	    var msg = "The same invoice does exist, Invoice ["+checkInv+"]" +". \nPlease double check the invoice. \nWould you continue to save?";
	    if(!ComIsEmpty(checkInv)){
    	    if(!ComShowConfirm(msg)){
    	        return false; //취소 click
    	    }else{
    	        return true; //확인 click
    	    }
	    }else{
	        return true; //double payment가 아니므로 skip
	    }
	    /*
        if(ComIsEmpty(checkInv)){
            return true; //double payment 미존재
        }else{
            return false; //double payment 존재.
        }*/
        
	}