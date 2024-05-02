/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0019.js
*@FileTitle  : Receivable Charge & Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var comboObjects=new Array();
	var sheetCnt=0;
	var comboCnt=0;
	var lastTaxAmount="";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;
 				case "btn_RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObject1, formObj, IBINSERT);
 					}
                	break;
				case "btn_Delete":
					if ( ComIsBtnEnable(srcName) ) {
						with(sheetObject1) {
							for(var i=LastRow(); i >= HeaderRows(); i--) {
								if(GetCellValue(i, "sheet1_del_chk") == 1) {
									var vDelFlag=GetRowStatus(i)== "I";
		 							SetCellValue(i, "sheet1_del_chk",0,0);
									SetRowHidden(i,vDelFlag);
									SetRowStatus(i,vDelFlag ? "D" : GetRowStatus(i));
								}
							}
						}
 					}
                    break;
				case "btn_new":
					ComResetAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[0].RemoveAll();
					//setDynamicCurrcyList(true);
					ComEnableObject(formObj.to_curr_rt, false);
					//ComEnableObject(formObj.to_curr_cd, false);
					to_curr_cd.SetEnable(0);
					to_curr_cd.SetSelectCode(-1,false);
					//ComEnableObject(formObj.btns_search2,false);
					formObj.to_curr_rt.className="input2";
					//formObj.to_curr_cd.className="input2";
					ComEnableObject(formObj.cust_cnt_cd, false);
					ComEnableObject(formObj.cust_seq, false);
					ComEnableObject(formObj.btns_cust1,false);
					ComEnableObject(formObj.btns_cust2,false);
					formObj.cust_cnt_cd.className="input2";
					formObj.cust_seq.className="input2";
					formObj.inv_tax_rt.disabled=true;
					formObj.inv_tax_rt.value="";
					formObj.tax_amount.disabled=true;
					formObj.tax_amount.value="";
					ComEnableObject(formObj.inv_isu_dt, false);
					ComEnableObject(formObj.inv_due_dt, false);
					ComEnableObject(formObj.btns_calendar2,false);
					ComEnableObject(formObj.btns_calendar3,false);
					formObj.inv_isu_dt.className="input2";
					formObj.inv_due_dt.className="input2";
					// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
					//no support[check again]CLT 	sheet1_OnLoadFinish(sheetObject1);
					break;
				case "btns_calendar1":
 					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.setEndFunction('callbackSetQtyYrmon');
					cal.select(formObj.qty_yrmon, 'yyyy-MM');
             	 	break;
             	case "btns_calendar2":
 					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
						cal.setEndFunction('callbackSetInvIsuDt');
		                cal.select(formObj.inv_isu_dt, "yyyy-MM-dd");
					}
					break;
             	case "btns_calendar3":
 					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
		                cal.select(formObj.inv_due_dt, "yyyy-MM-dd");
					}
					break;
             	case "btns_search1": 	// Form Lessor Search
					openPopup("1");
					break;
				case "btn_preparation":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
					break;
				case "btn_charge":
					//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
					break;
				case "btn_recharge":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
					break;
				case "btn_invoice":
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC06);
					break;
				case "btn_confirm":
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC13);
					break;
				case "btn_print":
					var rdPath='apps/opus/ees/lse/containerrentalcost/receivablerentalcost/report/EES_LSE_0019.mrd';
/*					2016.03.02 - 사용하지 않는 RD -> modified by Jiyeon Jeon
					if(formObj.ofc_cd.value == "HAMUOG") {//(EUR)
						rdPath='apps/opus/ees/lse/containerrentalcost/receivablerentalcost/report/EES_LSE_0019_01.mrd';
					}*/
					var rdParam="/rv VNDR_SEQ["+ ComGetObjValue(formObj.inv_vndr_seq) +"]"
								+ " USR_ID['"+ ComGetObjValue(formObj.usr_id) +"']"
								+ " QTY_YRMON['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.qty_yrmon), "ym") +"']"
							    + " COST_YRMON['"+ ComGetObjValue(formObj.cost_yrmon) +"']"
							    + " INV_NO['"+ ComGetObjValue(formObj.inv_no) +"']"
							    + " INV_ISU_DT['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.inv_isu_dt), "ymd") +"']"
							    + " INV_DUE_DT['"+ ComGetUnMaskedValue(ComGetObjValue(formObj.inv_due_dt), "ymd") +"']";
					var vFeatures="status=no, resizable=no, scrollbars=no, width=" + 700
							  	  + ", height=" + 700 + ", left=" + (screen.width -700) / 2
							  	  + ", top=" + (screen.height -700) / 2;
					formObj.com_mrdPath.value=rdPath;
					formObj.com_mrdArguments.value=rdParam;
					formObj.com_mrdTitle.value="Receivable Invoice Report";
					formObj.com_mrdBodyTitle.value="Receivable Invoice Report";
					ComOpenRDPopup(vFeatures);
					break;
				case "btn_cntr":
					openPopup("3");
					break;
				case "btn_downexcel":
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
					}					
					break;
				case "btns_cust1": //CUST button
//					if(formObj.btns_cust1.style.cursor == "hand") {
						openPopup("5");
//					}
					break;
				case "btns_cust2": //CUST button
//					if(formObj.btns_cust2.style.cursor == "hand") {
						openPopup("6");
//					}
					break;
				case "btn_ChargeCreation":
                	doActionIBSheet(sheetObjects[0], formObj, COMMAND07);
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
    
    function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
		case "to_curr_cd":
			with (comboObj) {
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "200");
				SetEnable(0);
				SetTitle("Code|Name");
				SetMultiSelect(0);
				SetDropHeight(250);
				ValidChar(2);
			}
			break;
		}
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
	 * registering IBMultiCombo Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            if(i!=2) {
            	ComEndConfigSheet(sheetObjects[i]);
            }
        }
        
     // initializing IBMultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
	/**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Axon Control Setting*/
		initControl();
		// setting button befor retrieve
		LseComBtnControl(false, "btn_charge|btn_invoice|btn_confirm|btn_print|btn_cntr|btn_RowAdd|btn_Delete");
		/* retrieving for Preparation */
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		/* retrieving for Invoice Number */
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		/* Focus Setting */
		//setDynamicCurrcyList(true);
		//ComSetFocus(formObj.qty_yrmon);
		//ComEnableObject(formObj.btns_search2,false);
    	
		//ComEnableObject(formObj.to_curr_cd, false);
    	to_curr_cd.SetEnable(0);
		to_curr_cd.SetSelectCode(-1,false);
		
		ComEnableObject(formObj.btns_cust1,false);
		ComEnableObject(formObj.btns_cust2,false);
		ComEnableObject(formObj.btns_calendar2,false);
		ComEnableObject(formObj.btns_calendar3,false);
		formObj.inv_tax_rt.disabled=true;
		formObj.tax_amount.disabled=true;
		/* retrieving for Invoice Number */
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC14);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		//axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
  		//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
		//axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
		//axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
  	}
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=event.srcElement;
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")){
	    	case "qty_yrmon" :
	    		//checking Validation
	           // ComChkObjValid(obj);
	            ComAddSeparator(event.srcElement);
	            break;
	        case "vndr_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        case "cust_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	/**
	 * handling event in case of focus
	 */
	function obj_focus(){
		var obj=event.srcElement;
		if( obj.readOnly ) {
			//ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    ComClearSeparator(event.srcElement);
		}
	}
	/**
	 * Onhandling event in case of Change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
			case "qty_yrmon" :
				if ( ComTrim(obj.value) != "" ) {
					var vQtyYrmon=obj.value;
					ComResetAll();
					ComSetObjValue(formObj.qty_yrmon, vQtyYrmon);
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
  				break;
  			case "inv_isu_dt":	//Invoice Issue Date
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
	        		if(ComIsDate(formObj.inv_isu_dt.value)) {
	        			var addDays=formObj.ofc_cd.value == "HAMUOG" ? 30 : 14;
	        			ComSetObjValue(formObj.inv_due_dt, 	ComGetDateAdd(obj.value, "D", addDays));
	        		}
  				}
				break;
			case "to_curr_rt":	//Exchange Rate
				if ( ComTrim(obj.value) != "" ) {
					if (checkXchRateAvail() == true) {
						
						var strToCurrCd = to_curr_cd.GetSelectText();
						var vChgAmt=Number(ComGetUnMaskedValue(formObj.fm_chg_amt.value, "float")) *
						  Number(ComGetUnMaskedValue(formObj.to_curr_rt.value, "float"));
						//var vTaxAmt=formObj.inv_tax_rt.value == "N" ? 0 : (vChgAmt / 10);
						
						var strloclTax = 0;
						var vTaxAmt = "";
						vTaxAmt = formObj.tax_amount.value;
						if(formObj.inv_tax_rt.value == "N" || formObj.inv_tax_rt.value == "") {
							strloclTax = 0;
							vTaxAmt = 0;
							
						}else {
							strloclTax = Number(formObj.inv_tax_rt.value);
							if(vTaxAmt == "") {
								vTaxAmt = Number(vChgAmt * (strloclTax/100));
							}
							if(isNaN(vTaxAmt) == true || vTaxAmt == "Infinity") {
								vTaxAmt = 0;
							}
						}
						
						formObj.inv_tax_rt.value = strloclTax;
						var vTax = Number(formObj.inv_tax_rt.value);
						var vTtlAmt=vChgAmt + vTaxAmt;
						
						if(strToCurrCd == "KRW") {
							ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2),  "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2),  "float"));
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2),  "float"));
						} else {
							ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
						}
						
						ComSetObjValue(formObj.ttl_curr_cd,	strToCurrCd);
					} else {
						ComShowCodeMessage("LSE01153");
						ComSetFocus(formObj.to_curr_rt);
					}
				}
				break;
  			case "to_curr_cd":	//Currency Code
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
					ComSetFocus(formObj.to_curr_rt);
				} else {
					clearForm(obj.name);
				}
				break;
			case "cust_cnt_cd":	//Customer Code
			case "cust_seq":	//Customer Name
				if ( ComTrim(formObj.cust_seq.value) != "" ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC12);
				}
				break;
			case "tax_amount" :
				if ( ComTrim(formObj.to_chg_amt.value) != "" && ComTrim(formObj.tax_amount.value) != "") {
					
					var vChgAmt= Number(formObj.to_chg_amt.value.replace(/,/g,""));
					var vTaxAmt = Number(formObj.tax_amount.value.replace(/,/g,""));
					var vTaxRt = Number(formObj.inv_tax_rt.value);
					var vLastTaxAmt = lastTaxAmount;
					
					if(vChgAmt < vTaxAmt) {
						ComShowCodeMessage("LSE10019",formObj.to_chg_amt.value);			
						ComSetObjValue(formObj.tax_amount,	vLastTaxAmt);
						return false;
						
					}else{
						var strloclTax = 0;						
						if(formObj.inv_tax_rt.value == "N" || formObj.inv_tax_rt.value == "") {
							strloclTax = 0;
						
						}else {
							strloclTax = Math.round( (vTaxAmt * 100) / vChgAmt);
						}
						
						if(isNaN(strloclTax) == true || strloclTax == "Infinity") {
							strloclTax = 0;
						}
						
						formObj.inv_tax_rt.value = strloclTax;						
						var vTax = Number(formObj.inv_tax_rt.value);
						var vTtlAmt=vChgAmt + vTaxAmt;
						var strToCurrCd = to_curr_cd.GetSelectText();
						
						if(strToCurrCd == "KRW") {
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						} else {
							ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
							ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						}
						ComSetObjValue(formObj.ttl_curr_cd,	strToCurrCd);
						lastTaxAmount = formObj.tax_amount.value;
					}
				}
				break;
			case "inv_tax_rt":	//Customer Code
				if(ComTrim(formObj.inv_tax_rt.value) > 100) {
					ComShowCodeMessage("LSE10016");
					var vChgAmt= Number(formObj.to_chg_amt.value.replace(/,/g,""));
					var vTaxAmt = Number(formObj.tax_amount.value.replace(/,/g,""));
					var vTax = Math.round((vTaxAmt * 100 / vChgAmt));
					if(isNaN(vTax) == true || vTax == "Infinity") {
						vTax = 0;
					}
					formObj.inv_tax_rt.value = vTax;
					return false;
				} 
				
				if ( ComTrim(formObj.to_chg_amt.value) != "" ) {
					//formObj.inv_tax_rt.value == "N" ? 0 : 10;
					var vChgAmt=Number(ComGetUnMaskedValue(formObj.to_chg_amt.value, "float"));
					
					
					var strloclTax = 0;
					var vTaxAmt = 0;
					if(formObj.inv_tax_rt.value == "N" || formObj.inv_tax_rt.value == "") {
						strloclTax = 0;
						vTaxAmt = 0;
						
					}else {
						strloclTax = Number(formObj.inv_tax_rt.value);
						vTaxAmt = Number(vChgAmt * (strloclTax/100));
						if(isNaN(vTaxAmt) == true || vTaxAmt == "Infinity") {
							vTaxAmt = 0;
						}
					}
					
					formObj.inv_tax_rt.value = strloclTax;
					var vTax = Number(formObj.inv_tax_rt.value);
					var vTtlAmt=vChgAmt + vTaxAmt;
					var strToCurrCd = to_curr_cd.GetSelectText();
					
					if(strToCurrCd == "KRW") {
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
					} else {
						ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
						ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
					}
					
					if(formObj.inv_tax_rt.value == "0") {
						formObj.locl_tax_flg.value = "N";
					}else{
						formObj.locl_tax_flg.value = "Y";
					}
					lastTaxAmount = formObj.tax_amount.value;
					ComSetObjValue(formObj.ttl_curr_cd,	strToCurrCd);
				}
				break;
		}
	}
	
	
	/**
	 * handling event in case of Key-Press
	 */
//  	function obj_keypress() {
//		var obj=event.srcElement;
//		switch(obj.dataformat) {
//	        case "ymd":
//	        case "ym":
//	        case "hms":
//	        case "hm":
//	        case "jumin":
//	        case "saupja":
//	        case "int":
//	            ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        default:
//	            ComKeyOnlyNumber(obj);
//	        	break;
//	    }
//  	}
  	/**
  	 * handling event in case of Key-Up
  	 */
//  	function obj_keyup() {
//  		var obj=event.srcElement;
//  		switch(ComGetEvent("name")) {
//  			case "vndr_seq":
//				if ( ComTrim(obj.value) == "" ) {
//  					clearForm(obj.name);
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
//			case "cust_cnt_cd":
//				if ( ComTrim(obj.value) == "" ) {
//  					clearForm(obj.name);
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
//  			case "cust_seq":
//				if ( ComTrim(obj.value) == "" ) {
//  					clearForm(obj.name);
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
//			case "to_curr_rt":
//  			case "to_curr_cd":
//  			case "inv_isu_dt":
//				if ( ComTrim(obj.value) == "" ) {
//  					clearForm(obj.name);
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
//  			default :
//			  	ComKeyEnter('LengthNextFocus');
//  		}
//  	}
   	/**
	 * handling event in case of Key-Down
	 */
//   	function obj_keydown() {
//   		var obj=event.srcElement;
//   		var vKeyCode=event.keyCode;
//   		var formObj=document.form;
//   		if ( vKeyCode == 13 ) {
//   			switch(ComGetEvent("name")) {
//				case "vndr_seq":
//	  				if ( ComTrim(obj.value) == "" ) {
//						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//					}
//					break;
//				case "to_curr_rt":	//Currency Rate
//				case "to_curr_cd":	//Currency Code
//				case "cust_seq"	 :	//Customer Code
//				case "inv_isu_dt":	//Invoice Issue Date
//				case "inv_due_dt":	//Invoice Due Date
//					break;			//do nothing
//				default :
//					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//			}
//   		}
//   	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		             var prefix=sheetId +"_";             
		             var HeadTitle1="|||SEQ|STS|STS|Lessee|Lessee|AGMT No|AGMT No||Term|Effective date|Effective date|Currency|Charge Amount|Credit Amount|Invoice No|Invoice No|Invoice No|Invoice No||||||||||||||||||||";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             (headCount, 0, 0, true);
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		                 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rdo_chk" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq_no" },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lse_cntr_chg_rst_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lse_cntr_chg_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_abbr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_cty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lstm_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ttl_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cr_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_yrmon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"qty_yrmon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_rntl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_isu_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_due_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_if_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"if_err_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"locl_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"locl_curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"locl_tax_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"locl_tax_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"locl_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"locl_ttl_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cfm_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_cre_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cfm_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",  ColMerge:0,   SaveName:prefix+"inv_tax_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		              
		             InitColumns(cols);
		             SetSheetHeight(242);
		             SetEditable(1);
		             SetDataAutoTrim(1);
		             //SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		             SetColHidden(prefix +"rdo_chk",1);
             }
                break;
            case "sheet2":    //sheet2 init
                with (sheetObj) {
		                var prefix=sheetId +"_";               
		                var HeadTitle1="|AGMT No||||Term|TP/SZ|Charge Type|Invoice Amount|Used Days|Qty|Rate|";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		                (headCount, 0, 0, true);
		                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                       {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcv_rntl_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lse_rcv_chg_tp_cd", KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cost_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_dys",           KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_cnt",          KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"chg_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		                       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_yrmon",        KeyField:0,   CalcLogic:"",   Format:"" } ];
		                 
		                InitColumns(cols);
		                SetEditable(0);
		                SetDataAutoTrim(1);
		                SetSheetHeight(165);
                      }
                	break;
               case "sheet3":    //sheet3 init
                with (sheetObj) {
                    //setting Host information [mandatory][HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
               }
                break;
        }
    }
    
    function LseXml2ComboString(xmlStr, codeCol, textCol) {
    	var rtnArr=new Array();
    	if (xmlStr == null || xmlStr == "") {
    		return;
    	}
    	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
    		return;
    	}
    	try {
            var xmlDoc = ComGetXmlDoc(xmlStr);
            if (xmlDoc == null) return;
            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null)  return;
            
    		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    		if (dataNode == null || dataNode.attributes.length < 3) {
    			return;
    		}
    		var col=dataNode.getAttribute("COLORDER");
    		var colArr=col.split("|");
    		var sep=dataNode.getAttribute("COLSEPARATOR");
    		var total=dataNode.getAttribute("TOTAL");
    		var dataChildNodes=dataNode.childNodes;
    		if (dataChildNodes == null) {
    			return;
    		}
    		var colListIdx=Array();
    		for ( var i=0; i < colArr.length; i++) {
    			if (colArr[i] == codeCol) {
    				colListIdx[0]=i;
    			}
    			if (colArr[i] == textCol) {
    				colListIdx[1]=i;
    			}
    		}
    		var retStr="";
    		for ( var i=0; i < dataChildNodes.length; i++) {
    			if (dataChildNodes[i].nodeType != 1) {
    				continue;
    			}
    			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
    			retStr=arrData[colListIdx[0]] + '|' + arrData[colListIdx[1]];
    			rtnArr.push(retStr);
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}
    	return rtnArr;
    }
    
    /**
     * Curr Exchange Rate 정보 조회
     * 
     * @param {String}
     *            xchRt 기준년월
     * @param {String}
     *            currCd Curr 코드
     * @param {String}
     *            xchCurrCd Exchange Curr 코드
     * @param {String}
     *            dpCurrCd DpPrcs를 가져오고 싶은 Curr 코드(없으면 currCd)가져옴
     * @return {String} xchRt
     */
    function LseGetCurrXchRt2(sheetObj, xchRt, currCd, xchCurrCd, xchAmt) {
    	var f_query='';
    	// 쿼리 스트링 조합시작
    	if (xchAmt == undefined) {
    		xchAmt="1";
    	}
    	f_query += 'f_cmd' + '=' + SEARCH16 + '&';
    	f_query += 'xch_rt=' + xchRt + '&';
    	f_query += 'curr_cd=' + currCd + '&';
    	f_query += 'xch_curr_cd=' + xchCurrCd + '&';
    	f_query += 'xch_amt=' + xchAmt + '&';
    	f_query += 'dp_prcs_curr_cd=' + xchCurrCd;
     	var sXml=sheetObj.GetSearchData("MNR_COMGS.do", f_query);
    	return ComGetEtcData(sXml, "XchRt") + ","
    			+ ComGetEtcData(sXml, "DpPrcsKnt");
    }
    
    function to_curr_cd_OnSelect(comboObj, Index, Text, Code) {
    	if(Text != "") {
    		to_curr_cd.SetSelectText(Text, 0);
    	}
    }
    
    /**
	 * chg_curr_cd Change event
	 * @param {IBMultiCombo}  comboObj ComboObject
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */
	function to_curr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		var sheetObj = sheetObjects[0];
		var retVal="";
		var selRow = sheetObj.GetSelectRow();
		var strCurrCd = sheetObj.GetCellValue(selRow,"sheet1_curr_cd");
		retVal=LseGetCurrXchRt2(sheetObjects[0],formObj.inv_isu_dt.value.replace(/-/g,"").substr(0,6),strCurrCd,to_curr_cd.GetSelectCode(),"1");
		retVal=retVal.split(",");
		//formObj.conv_dp_prcs_knt.value=retVal[1];
		formObj.to_curr_rt.value=retVal[0];
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		ComSetFocus(formObj.to_curr_rt);
		to_curr_cd.SetSelectText(newCode, 0);
		
	}
	
	
    
  	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_LSE_0019GS.do",FormQueryString(formObj)+ "&IBPREFIX=sheet1_" );
					}
				}
				break;
			 case IBSEARCH_ASYNC14://sheet Combo data
		   	 	   formObj.f_cmd.value=SEARCH;
		   	 	   var xml=sheetObj.GetSearchData("MNR_COMGS.do", "f_cmd="+SEARCH+"&searchinfo=MdmCurrency&searchkey=&searchcon=COMMON&ibflag=X");
		   	 	   
		   	 	   var arrXml=xml.split("|$$|");
		   	 	   var retValue=new Array();
		   	 	   for ( var i=0; i < arrXml.length; i++) {
		   	 		   var comboList=LseXml2ComboString(arrXml[i], "cd_id", "cd_desc");
		   	 	   }
		   	 	   
		   	 	   var tempText= "";
		   	 	   var sheetComboText = "";
		   	 	   var sheetComboCode = "";
		   	 	   for(var i=0; i < comboList.length;i++){
						//initializing sheet combo
						tempText=comboList[i].split("|");
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						//Disposal Invoice Search Type
						to_curr_cd.InsertItem(i, tempText[0]+"|"+tempText[1], tempText[0]);
		   	 	   }
		   	 	   break; 	
			case IBINSERT:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var prefix=sheetObj.id +"_";
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, prefix +"del_chk",1,0);
						sheetObj.SetCellValue(Row, prefix +"lse_cntr_chg_sts_cd","N",0);
						sheetObj.SetCellValue(Row, prefix +"qty_yrmon",ComGetUnMaskedValue(ComGetObjValue(formObj.qty_yrmon), "ym"),0);
						sheetObj.SelectCell(Row, prefix +"agmt_seq");
					}
				}
				break;
			case IBSEARCH_ASYNC01:	//retrieving for Preparation
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.SetWaitImageVisible(0);
					var param="f_cmd="+SEARCH01+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do",param);
					sheetObj.SetWaitImageVisible(1);
					if(sXml != "") {
						if ( ComGetEtcData(sXml, "exec_flag") != undefined ) {
							var vExecFlag=ComGetEtcData(sXml, "exec_flag");
							// setting button befor retrieve
							LseComBtnControl(vExecFlag == "FALSE", "btn_preparation");
							LseComBtnControl(vExecFlag != "FALSE", "btn_RowAdd|btn_Delete");
						}
					}
				}
				break;
			case IBSEARCH_ASYNC02:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");;
					}
				}
				break;
			case IBSEARCH_ASYNC03:	//saving for in case of Preparation
				if ( validateForm(sheetObj, formObj, sAction) ) {
					ComOpenWait(true, "mainTable");
					var param="f_cmd="+COMMAND01+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					sheetObj.SetWaitImageVisible(0);
					var sXml=""
					setTimeout( function () {
						sXml=sheetObj.GetSaveData("EES_LSE_0019GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						ComOpenWait(false, "mainTable");
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") != undefined ) {
								var errMsg=LseComGetErrMsg(sXml);
								var vResultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
								// setting button befor retrieve
								LseComBtnControl(vResultKey == "F", "btn_preparation");
								LseComBtnControl(vResultKey != "F", "btn_RowAdd|btn_Delete");
								if ( errMsg != "" && errMsg != undefined) {
									ComShowMessage(errMsg);
								}
								if(vResultKey == "S") {
									doActionIBSheet(sheetObj, formObj, IBSEARCH);
								}
							}
						}
					} , 100);
				}
				break;
			case IBSEARCH_ASYNC04:	//saving for in case of Charge Creation 
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						ComOpenWait(true, "mainTable");
						formObj.f_cmd.value=MULTI01;
						var sXml="";
						for(var i=0; i <= sheetObj.RowCount(); i++) {
							if(sheetObj.GetCellValue(i, "sheet1_del_chk")) {
								sheetObj.SetCellValue(i, "sheet1_rdo_chk",1);
								var sParam=sheetObj.GetSaveString(false, true, "sheet1_rdo_chk")
										   + "&IBPREFIX=sheet1_&"+ FormQueryString(formObj);
								sheetObj.SetWaitImageVisible(0);
								sXml=sheetObj.GetSaveData("EES_LSE_0019GS.do", sParam);
								sheetObj.SetWaitImageVisible(1);
								if(/ERROR/.test(sXml)) {
									sheetObj.SetCellValue(i, "sheet1_lse_cntr_chg_rst_cd","Fail",0);
									sheetObj.SetCellFontColor(i, "sheet1_lse_cntr_chg_rst_cd","#FF0000");
								} else {
									sheetObj.SetCellValue(i, "sheet1_del_chk",0,0);
									sheetObj.SetCellValue(i, "sheet1_lse_cntr_chg_rst_cd","OK",0);
									sheetObj.SetCellFontColor(i, "sheet1_lse_cntr_chg_rst_cd","#0000FF");
									doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC07);
								}
								sheetObj.SelectCell(i, "sheet1_del_chk");
							}
						}
						ComOpenWait(false, "mainTable");
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						} else {
							ComShowCodeMessage("LSE10001");
						}
					}
				}
				break;
			case IBSEARCH_ASYNC05:	//saving for in case of RE-Creation
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						ComOpenWait(true, "mainTable");
						formObj.f_cmd.value=MULTI02;
						var sXml="";
						for(var i=0; i <= sheetObj.RowCount(); i++) {
							if(sheetObj.GetCellValue(i, "sheet1_del_chk")) {
								sheetObj.SetCellValue(i, "sheet1_rdo_chk",1);
								var sParam=sheetObj.GetSaveString(false, true, "sheet1_rdo_chk")
										   + "&IBPREFIX=sheet1_&"+ FormQueryString(formObj);
								sheetObj.SetWaitImageVisible(0);
								sXml=sheetObj.GetSaveData("EES_LSE_0019GS.do", sParam);
								sheetObj.SetWaitImageVisible(1);
								if(/ERROR/.test(sXml)) {
									sheetObj.SetCellValue(i, "sheet1_lse_cntr_chg_rst_cd","Fail",0);
									sheetObj.SetCellFontColor(i, "sheet1_lse_cntr_chg_rst_cd","#FF0000");
								} else {
									sheetObj.SetCellValue(i, "sheet1_del_chk",0,0);
									sheetObj.SetCellValue(i, "sheet1_lse_cntr_chg_rst_cd","OK",0);
									sheetObj.SetCellFontColor(i, "sheet1_lse_cntr_chg_rst_cd","#0000FF");
									doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC07);
								}
								sheetObj.SelectCell(i, "sheet1_del_chk");
							}
						}
						ComOpenWait(false, "mainTable");
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						} else {
							ComShowCodeMessage("LSE10001");
						}
					}
				}
				break;
			case IBSEARCH_ASYNC06:	//saving for in case of Invoice Creation
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						if(Number(formObj.tax_amount.value) > 0) {
							formObj.locl_tax_flg.value = "Y";
						}else{
							formObj.locl_tax_flg.value = "N";
						}
						formObj.f_cmd.value=MULTI03;
						sheetObj.DoSave("EES_LSE_0019GS.do", FormQueryString(formObj)+ "&IBPREFIX=sheet2_", -1, false);
					}
				}
				break;
			case IBSEARCH_ASYNC07:	//Callback check
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.SetWaitImageVisible(0);
					var param="f_cmd="+SEARCH02+ "&IBPREFIX=sheet1_&"+ sheetObj.GetSaveString(false, true, "sheet1_rdo_chk");
					var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do", param.replace(/sheet1_/g, ""));
					sheetObj.SetWaitImageVisible(1);
					if(sXml != "") {
						var index=sheetObj.FindCheckedRow("sheet1_rdo_chk").split("|");
						sheetObj.SetCellValue(index[0], "sheet1_inv_chk",0,0);
						sheetObj.SetCellValue(index[0], "sheet1_lse_cntr_chg_sts_cd",ComGetEtcData(sXml, "lse_cntr_chg_sts_cd"),0);
						sheetObj.SetCellValue(index[0], "sheet1_ttl_chg_amt",ComGetEtcData(sXml, "ttl_chg_amt"),0);
						sheetObj.SetCellValue(index[0], "sheet1_cr_amt",ComGetEtcData(sXml, "cr_amt"),0);
						sheetObj.SetCellValue(index[0], "sheet1_curr_cd",ComGetEtcData(sXml, "curr_cd"),0);
						sheetObj.SetCellValue(index[0], "sheet1_rcv_rntl_seq",ComGetEtcData(sXml, "rcv_rntl_seq"),0);
						var vChgStsCd=sheetObj.GetCellValue(index[0], "sheet1_lse_cntr_chg_sts_cd");
			    		sheetObj.SetCellEditable(index[0], "sheet1_del_chk",vChgStsCd != "I");
			    		sheetObj.SetCellEditable(index[0], "sheet1_inv_chk",vChgStsCd == "C");
			    		sheetObj.SetCellEditable(index[0], "sheet1_agmt_seq",0);
					}
				}
				break;
			case IBSEARCH_ASYNC08: 	//Invoice No Setting
				if(validateForm(sheetObj, formObj, sAction)) {
					sheetObj.SetWaitImageVisible(0);
					var param="f_cmd="+SEARCH03+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
					var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do",param);
					sheetObj.SetWaitImageVisible(1);
					if(sXml != "") {
						if ( ComGetEtcData(sXml, "invoice_no") != undefined ) {
							if ( ComGetEtcData(sXml, "invoice_no") != "" ) {
								var vInvoiceNo=ComGetEtcData(sXml, "invoice_no");
								ComSetObjValue(formObj.invoice_no,  vInvoiceNo);
							} else {
								ComShowCodeMessage("LSE01048");
								formObj.invoice_no.value="";
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" && errMsg != undefined) {
								ComShowMessage(errMsg);
							}
							formObj.invoice_no.value="";
						}
					}
				}
				break;
			case IBSEARCH_ASYNC09:	//retrievint for Invoice Summary
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						var param="f_cmd="+SEARCH04+"&cost_yrmon="+ComGetObjValue(formObj.cost_yrmon)
					  			  + "&rcv_rntl_seq="+ ComGetObjValue(formObj.rcv_rntl_seq)+ "&IBPREFIX=sheet2_";
						sheetObj.DoSearch("EES_LSE_0019GS.do", param );
//						var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do", param );
//						if(sXml != null) sheetObj.LoadSearchData(sXml,{Sync:1})
						
						ComEnableObject(formObj.cust_cnt_cd, true);
						ComEnableObject(formObj.cust_seq, true);
						ComEnableObject(formObj.inv_isu_dt, true);
						ComEnableObject(formObj.inv_due_dt, true);
						ComEnableObject(formObj.btns_cust1,true);
						ComEnableObject(formObj.btns_cust2,true);
						ComEnableObject(formObj.btns_calendar2,true);
						ComEnableObject(formObj.btns_calendar3,true);
						formObj.cust_cnt_cd.className="input1";
						formObj.cust_seq.className="input1";
						formObj.inv_isu_dt.className="input1";
						formObj.inv_due_dt.className="input1";
					}
				}
				break;
			case IBSEARCH_ASYNC10:	//retrieving for Form Currency Code
 				if ( validateForm(sheetObj, formObj, sAction) ) {
 					var strToCurrCd = to_curr_cd.GetSelectText();
					//var param="f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(to_curr_cd);
 					var param="f_cmd="+SEARCH07+"&curr_cd="+strToCurrCd; //Park Young Jin
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							var vCurrCode=ComGetEtcData(sXml, "curr_cd");
							
							//ComSetObjValue(formObj.to_curr_cd, vCurrCode);
							to_curr_cd.SetSelectText(vCurrCode, 0);  //Park Young Jin
							//ComSetNextFocus(to_curr_cd);
							to_curr_cd.Focus(); //Park Young Jin
							//formObj.inv_tax_rt.disabled=vCurrCode == "KRW" ? false : true;
							//formObj.inv_tax_rt.value=vCurrCode == "KRW" ? "Y"   : "";
							
							//retrieving for Invoice Amount
							if(formObj.inv_isu_dt.value != "") {
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
							}
						} else {
							ComShowCodeMessage("LSE01048");
							to_curr_cd.SetSelectCode(-1,false);  //Park Young Jin
							//clearForm("to_curr_cd");
							//ComSetFocus(to_curr_cd);
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						to_curr_cd.SetSelectCode(-1,false);
						//clearForm("to_curr_cd");
						//ComSetFocus(to_curr_cd);
					}
				}
				break;
			case IBSEARCH_ASYNC11:	//retrieving for Invoice Amount 
				if ( validateForm(sheetObj, formObj, sAction) ) {
					sheetObj.SetWaitImageVisible(0);
					formObj.f_cmd.value=SEARCH05;
					var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do", FormQueryString(formObj));
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if(ComGetEtcData(sXml, "inv_isu_dt") == undefined) {
							ComShowCodeMessage("LSE01048");
							clearForm("inv_isu_dt");
							ComSetFocus(formObj.inv_isu_dt);
						} else {
							
							ComSetObjValue(formObj.to_curr_rt,	ComGetMaskedValue(LseMakeRound(ComGetEtcData(sXml, "to_curr_rt"),2), "float"));
							ComSetObjValue(formObj.usd_xch_rt,	ComGetMaskedValue(LseMakeRound(ComGetEtcData(sXml, "to_curr_rt"),2), "float"));
							
							//ComSetObjValue(formObj.to_curr_cd,	ComGetEtcData(sXml, "to_curr_cd"));
							to_curr_cd.SetSelectText(ComGetEtcData(sXml, "to_curr_cd"), 0);  //Park Young Jin
							//=========================================================================================
							//if(formObj.inv_no.value == formObj.invoice_no.value) {//Invoice 생성모드
							
							var strToCurrCd = to_curr_cd.GetSelectText(); //Park Young Jin
							var vChgAmt=Number(ComGetUnMaskedValue(ComGetEtcData(sXml, "to_chg_amt"), "float"));
							var strloclTax = 0;
							var vTaxAmt = 0;
							if(formObj.inv_tax_rt.value == "N" || formObj.inv_tax_rt.value == "") {
								strloclTax = 0;
								vTaxAmt = 0;							
							}else {
								strloclTax = Number(formObj.inv_tax_rt.value);
								vTaxAmt = Number(vChgAmt * (strloclTax/100));
								if(isNaN(vTaxAmt) == true || vTaxAmt == "Infinity") {
									vTaxAmt = 0;
								}
							}
							formObj.inv_tax_rt.value = strloclTax;
							var vTax = Number(formObj.inv_tax_rt.value);		
							var vTtlAmt=vChgAmt + vTaxAmt;
							
							if(strToCurrCd == "KRW") {
								ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
							} else {
								ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
								ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
							}
							ComSetObjValue(formObj.ttl_curr_cd,	ComGetEtcData(sXml, "to_curr_cd")); 
							if(ComGetEtcData(sXml, "inv_isu_dt") != ComGetUnMaskedValue(formObj.inv_isu_dt.value, "ymd")) {
								ComShowCodeMessage("LSE01131", formObj.inv_isu_dt.value);
								if(ComGetEtcData(sXml, "inv_isu_dt") != "") {
									ComSetObjValue(formObj.inv_isu_dt,	ComGetEtcData(sXml, "inv_isu_dt"));
									ComSetFocus(formObj.inv_isu_dt);
									ComSetNextFocus(formObj.inv_due_dt);
									//retrieving for Ex,Rate
									doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC11);
								} else {
									clearForm("inv_isu_dt");
									ComSetFocus(formObj.inv_isu_dt);
									break;
								}
							}
							//setting user information
							//setDynamicCurrcyList(false);
							ComEnableObject(formObj.to_curr_rt, true);
							//ComEnableObject(formObj.inv_tax_rt, true);
							
							formObj.inv_tax_rt.disabled=false;
							formObj.inv_tax_rt.readOnly=false;
							formObj.inv_tax_rt.className="input1";
							formObj.tax_amount.disabled=false;
							formObj.tax_amount.readOnly=false;
							formObj.tax_amount.className="input1";
							to_curr_cd.SetEnable(1);
							//ComEnableObject(formObj.to_curr_cd, true);
							//ComEnableObject(formObj.btns_search2,  true);
							formObj.to_curr_rt.className="input1";
							//formObj.to_curr_cd.className="input1";
							//}
							//=========================================================================================
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" && errMsg != undefined) {
							ComShowMessage(errMsg);
						}
						clearForm("inv_isu_dt");
						ComSetFocus(formObj.inv_isu_dt);
					}
				}
				break;
			case IBSEARCH_ASYNC12: // retrieving for Customer Name
				if(validateForm(sheetObj, formObj, sAction)) {
					var actCustCntCd=formObj.cust_cnt_cd.value;
					var actCustSeq=formObj.cust_seq.value;
					formObj.f_cmd.value=SEARCH03;
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);
					sheetObj.SetWaitImageVisible(1);
					if(sXml != "") {
						if ( ComGetEtcData(sXml, "cust_eng_nm") != undefined ) {
							if ( ComGetEtcData(sXml, "cust_eng_nm") != "" ) {
								var vCustNm=ComGetEtcData(sXml, "cust_eng_nm");
								ComSetObjValue(formObj.cust_nm,   vCustNm);
							} else {
								ComShowCodeMessage("LSE01048");
								formObj.cust_seq.value="";
								formObj.cust_nm.value="";
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" && errMsg != undefined) {
								ComShowMessage(errMsg);
							}
							formObj.cust_seq.value="";
							formObj.cust_nm.value="";
						}
					}
				}
				break;
			case IBSEARCH_ASYNC13:	//saving in case of Invoice Confirm
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet2") {
						if(Number(formObj.tax_amount.value) > 0) {
							formObj.locl_tax_flg.value = "Y";
						}else{
							formObj.locl_tax_flg.value = "N";
						}
						formObj.f_cmd.value=MULTI04;
						sheetObj.DoSave("EES_LSE_0019GS.do", FormQueryString(formObj)+ "&IBPREFIX=sheet2_", -1, false);
					}
				}
				break;
			case COMMAND07:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
		        ComOpenWait(true);
		        var sParam="f_cmd="+MULTI05+"&qty_yrmon="+ComGetObjValue(formObj.qty_yrmon);
		        var sXml=sheetObj.GetSaveData("EES_LSE_0019GS.do", sParam );
		        sheetObj.LoadSaveData(sXml, {Sync:1});
		        var BatchStatus = ComGetEtcData(sXml, "BackEndJobKey");
		        ComOpenWait(false);
		        switch(BatchStatus){
					case "4"://작업실행완료						
						//ComShowMessage("Master data creation is running by batch process. It will take several minutes according to the data volume for processing. Please try to retrieve to check the result after certain period.");
						break;
					case "5":// Error 발생
						//ComShowMessage("Port Expense Simulation Excution");
						break;
					case "6"://해당 작업이 진행 중 
						ComShowCodeMessage("LSE10037"); 
						break;
					default: break;							
				}
		        break;
        }
    }
	/**
	 * handling event when changing Sheet.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj=document.form;
		with(sheetObj) {
			var prefix=sheetObj.id +"_";
			var sName=ColSaveName(Col);
			switch(sName) {
				case prefix +"agmt_seq":
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="+ SEARCH03 + "&agmt_cty_cd=HHO"+ "&agmt_seq="+ GetCellValue(Row,Col);
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
 						SetWaitImageVisible(1);
 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
				 				if (ComGetEtcData(sXml, "agmt_seq") != "") {
				 					SetCellValue(Row, Col,ComGetEtcData(sXml, "agmt_seq"),0);
				 					SetCellValue(Row, prefix +"lstm_cd","",0);
				 					SetCellValue(Row, prefix +"lstm_cd",ComGetEtcData(sXml, "lstm_cd"));
		 						} else {
		 							ComShowCodeMessage("LSE01039");
				 					SetCellValue(Row, Col,"");
		 						}
 							} else {
 								var errMsg=LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
			 					SetCellValue(Row, Col,"");
 								SelectCell(Row, Col);
 							}
 						}
					} else {
						SetCellValue(Row, prefix +"lse_cntr_chg_rst_cd","",0);
						SetCellValue(Row, prefix +"vndr_seq","",0);
	 					SetCellValue(Row, prefix +"vndr_abbr_nm","",0);
	 					SetCellValue(Row, prefix +"agmt_cty_cd","",0);
	 					SetCellValue(Row, prefix +"agmt_seq","",0);
	 					SetCellValue(Row, prefix +"agmt_no","",0);
	 					SetCellValue(Row, prefix +"lstm_cd","",0);
	 					SetCellValue(Row, prefix +"eff_dt","",0);
	 					SetCellValue(Row, prefix +"exp_dt","",0);
	 					SetCellValue(Row, prefix +"cost_yrmon","",0);
	 					SetCellValue(Row, prefix +"ref_no","",0);
					}
					break;
				case prefix +"lstm_cd":
					if(GetCellValue(Row,Col) != "") {
						if(/SO|MO/.test(Value) == false) {
							ComShowCodeMessage("LSE10007", "\'SO\',\'MO\'");
		 					SetCellValue(Row, prefix +"agmt_seq","");
						} else {
							var param="f_cmd="+ SEARCH06 +"&agmt_seq="+ GetCellValue(Row, prefix +"agmt_seq")
							+ "&qty_yrmon="+ GetCellValue(Row, prefix +"qty_yrmon");
				        	sheetObj.SetWaitImageVisible(0);
				        	var sXml=sheetObj.GetSearchData("EES_LSE_0019GS.do", param);
							sheetObj.SetWaitImageVisible(1);
							if(sXml != "") {
								if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
					 				if (ComGetEtcData(sXml, "rcv_rntl_seq") == "") {
					 					SetCellValue(Row, prefix +"vndr_seq",ComGetEtcData(sXml, "vndr_seq"),0);
					 					SetCellValue(Row, prefix +"vndr_abbr_nm",ComGetEtcData(sXml, "vndr_abbr_nm"),0);
					 					SetCellValue(Row, prefix +"agmt_cty_cd",ComGetEtcData(sXml, "agmt_cty_cd"),0);
					 					SetCellValue(Row, prefix +"agmt_seq",ComGetEtcData(sXml, "agmt_seq"),0);
					 					SetCellValue(Row, prefix +"agmt_no",ComGetEtcData(sXml, "agmt_no"),0);
					 					SetCellValue(Row, prefix +"lstm_cd",ComGetEtcData(sXml, "lstm_cd"),0);
					 					SetCellValue(Row, prefix +"eff_dt",ComGetEtcData(sXml, "eff_dt"),0);
					 					SetCellValue(Row, prefix +"exp_dt",ComGetEtcData(sXml, "exp_dt"),0);
					 					SetCellValue(Row, prefix +"cost_yrmon",ComGetEtcData(sXml, "cost_yrmon"),0);
					 					SetCellValue(Row, prefix +"ref_no",ComGetEtcData(sXml, "ref_no"),0);
			 						} else {
			 							ComShowCodeMessage("LSE01055");
					 					SetCellValue(Row, prefix +"agmt_seq","");
			 						}
	 							}
							}
						}
					}
					break;
				case prefix +"inv_chk":
					
					var vInvCheck=FindCheckedRow(prefix +"inv_chk").split("|");
					var vRcvRntlNo="";
					var vInvAgmtNo="";
					var vInvLstmCd="";
					clearForm("inv_isu_dt");
					if(vInvCheck.length == 0) {
						
						clearForm("invoice_no");
					} else if(vInvCheck.length == 1) {
						ComSetObjValue(formObj.inv_no, formObj.invoice_no.value);
						if(GetCellValue(vInvCheck[0], "sheet1_vndr_seq") == -1) {
							ComSetObjValue(formObj.inv_vndr_seq, "");
							ComSetObjValue(formObj.inv_vndr_abbr_nm, "");
						}else{
							ComSetObjValue(formObj.inv_vndr_seq, GetCellValue(vInvCheck[0], "sheet1_vndr_seq"));
							ComSetObjValue(formObj.inv_vndr_abbr_nm, GetCellValue(vInvCheck[0], "sheet1_vndr_abbr_nm"));
						}
						ComSetObjValue(formObj.cost_yrmon, GetCellValue(vInvCheck[0], "sheet1_cost_yrmon"));
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq,    "");
						ComSetObjValue(formObj.cust_nm,     "");
					}
					var vVenderSeq=GetCellValue(Row, "sheet1_vndr_seq");
					
					if(Value == 1 && vVenderSeq != formObj.inv_vndr_seq.value) {
						
						ComShowCodeMessage("LSE01110");
						SetCellValue(Row, "sheet1_inv_chk",0,0);
						return;
					} 
					for(var i=0; i < vInvCheck.length; i++) {
						if(vInvCheck[i] != "") {
							vRcvRntlNo += GetCellValue(vInvCheck[i], "sheet1_rcv_rntl_seq") +"|";
							vInvAgmtNo += GetCellValue(vInvCheck[i], "sheet1_agmt_seq") +"|";
							vInvLstmCd += GetCellValue(vInvCheck[i], "sheet1_lstm_cd") +"|";
						}
					}
					ComSetObjValue(formObj.rcv_rntl_seq, vRcvRntlNo.substr(0,vRcvRntlNo.length -1));
					ComSetObjValue(formObj.inv_agmt_seq, vInvAgmtNo.substr(0,vInvAgmtNo.length -1));
					ComSetObjValue(formObj.inv_lstm_cd,  vInvLstmCd.substr(0,vInvLstmCd.length -1));
					if(vInvCheck.length > 0) {
						doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC09);
					} else {
						LseComBtnControl(false, "btn_invoice|btn_confirm|btn_print|btn_cntr");
					}
					break;
				default :
					//do nothing
			}
		}
 	}
	
	
 	/**
	 * handling event in case of Mouse-Move sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			var prefix=sheetObj.id +"_";
			if(MouseRow()>= HeaderRows()&& ColSaveName(MouseCol()) == prefix +"inv_no") {
				//no support[check again]CLT 				MouseToolTipText=GetCellText(MouseRow(), prefix +"if_err_rsn");
			} else {
				//no support[check again]CLT 				MouseToolTipText="";
			}
			var linkFlag=GetCellValue(MouseRow(), MouseCol()) != "";
			SetDataLinkMouse(prefix +"inv_no",linkFlag);
			SetDataLinkMouse(prefix +"inv_cre_usr_id",linkFlag);
		}
	}
	/**
	 * handling event in case of Sort sheet
	 */
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		with(sheetObj) {
			var sName=ColSaveName(Col);
			var prefix=sheetObj.id +"_";
			switch(sName) {
				case prefix +"lse_cntr_chg_rst_cd":
					ColumnSort(prefix +"lse_cntr_chg_sts_cd", SortArrow);
					break;
				case prefix +"agmt_cty_cd":
					ColumnSort(prefix +"agmt_seq", SortArrow);
					break;
				case prefix +"inv_chk":
					ColumnSort(prefix +"inv_no", SortArrow);
					break;
			}
		}
	}
	/**
 	 * handling event in case of Popup-Click sheet<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "sheet1_agmt_seq":		//Agreement No Pop-up
					openPopup("4", Row, Col);
					break;
			}
 		}
    }
	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
//		if(sheetObj.GetMousePointer!= "Hand") return;
		with(sheetObj) {
			switch(sName) {
				case "sheet1_inv_no":
					var vInvIfFlg=GetCellValue(Row, "sheet1_inv_if_flg") == "";
					var vCreOfcCd=GetCellValue(Row, "sheet1_inv_cre_ofc_cd");
					var vCrimFlg=vInvIfFlg && formObj.ofc_cd.value == vCreOfcCd;
					if(vCrimFlg) {//preceding process for INV Confirm
						clearForm("inv_cfrm");
					} else {//handing process INV Interface
						clearForm("invoice_no");
					}
					
					CheckAll("sheet1_inv_chk",0,0);					
					ComSetObjValue(formObj.inv_no, GetCellValue(Row, "sheet1_inv_no"));
					ComSetObjValue(formObj.inv_vndr_seq, GetCellValue(Row, "sheet1_vndr_seq"));
					ComSetObjValue(formObj.inv_vndr_abbr_nm, GetCellValue(Row, "sheet1_vndr_abbr_nm"));
					ComSetObjValue(formObj.cost_yrmon,  GetCellValue(Row, "sheet1_cost_yrmon"));
					ComSetObjValue(formObj.tax_amount,  GetCellValue(Row, "sheet1_locl_tax_amt"));
					
					ComSetObjValue(formObj.rcv_rntl_seq, "");
					ComSetObjValue(formObj.inv_agmt_seq, "");
					ComSetObjValue(formObj.inv_lstm_cd,  "");
					ComSetObjValue(formObj.cust_cnt_cd,   GetCellValue(Row, "sheet1_cust_cnt_cd"));
					ComSetObjValue(formObj.cust_seq,      GetCellValue(Row, "sheet1_cust_seq"));
					ComSetObjValue(formObj.cust_nm,       GetCellValue(Row, "sheet1_cust_eng_nm"));
					
					ComSetObjValue(formObj.inv_isu_dt,   GetCellText(Row, "sheet1_inv_isu_dt"));
					ComSetObjValue(formObj.inv_due_dt,   GetCellText(Row, "sheet1_inv_due_dt"));
					ComSetObjValue(formObj.to_curr_rt,   ComGetMaskedValue(GetCellValue(Row, "sheet1_locl_xch_rt"), "float"));
					
					//ComSetObjValue(formObj.to_curr_cd,   GetCellValue(Row, "sheet1_locl_curr_cd"));
					to_curr_cd.SetSelectText(GetCellValue(Row, "sheet1_locl_curr_cd"), 0); //Park Young Jin
					
					if(GetCellValue(Row, "sheet1_locl_tax_flg") == "N" && GetCellValue(Row, "sheet1_inv_tax_rt") =="0") {
						ComSetObjValue(formObj.inv_tax_rt, "0");
					}else{
						ComSetObjValue(formObj.inv_tax_rt, GetCellValue(Row, "sheet1_inv_tax_rt"));
					}
					//retrieving for Invoice Summary
					var param="f_cmd="+SEARCH04+"&cost_yrmon="+GetCellValue(Row, "sheet1_cost_yrmon")
					+ "&inv_no="+ GetCellValue(Row, Col)+ "&IBPREFIX=sheet2_";
					sheetObjects[1].DoSearch("EES_LSE_0019GS.do", param );
					//retrieving for Invoice Amount
					LseComBtnControl(!vCrimFlg, "btn_print");
					LseComBtnControl(false, "btn_invoice");
					LseComBtnControl(vCrimFlg, "btn_confirm");
					LseComBtnControl(true, "btn_cntr");
				break;
				case "sheet1_inv_cre_usr_id":
					//user information
					ComUserPopup(GetCellValue(Row, Col));
				break;
			}
		}
	}
 	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	with(sheetObj) {
    		var prefix=sheetObj.id +"_";
    		SetColFontColor(prefix +"inv_cre_usr_id","#0000FF");
    		for(var i=0; i <= SearchRows(); i++) {
    			if(GetCellValue(i, prefix +"cfm_flg") == "N") {//Non Inv-IF
    				SetCellFontColor(i, prefix +"inv_no","#858585");
    			} else if(GetCellValue(i, prefix +"if_err_rsn") == "") {//Success Inv-IF
    				SetCellFontColor(i, prefix +"inv_no","#0000FF");
    			} else {//Faile Inv-IF
    				SetCellFontColor(i, prefix +"inv_no","#FF0000");
    			}
    			var vChgStsCd=GetCellValue(i, prefix +"lse_cntr_chg_sts_cd");
    			var vCfrmFlag=GetCellValue(i, prefix +"cfm_flg")
    			SetCellEditable(i, prefix +"del_chk",vChgStsCd != "I");
    			SetCellEditable(i, prefix +"inv_chk",vChgStsCd == "C" || vChgStsCd == "I" && vCfrmFlag == "N");
    		}
    	}
    	
    	sheetObj.SetWaitImageVisible(0);
		ComOpenWait(false);
			
		// setting button befor retrieve
		LseComBtnControl(true, "btn_charge");
		LseComBtnControl(false, "btn_invoice|btn_confirm|btn_print|btn_cntr");
		/* retrieving for Invoice Number */
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
    	/* retrieving for Invoice Summary */
    	clearForm("invoice_no");
    }
    /**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj=document.form;
    		var prefix=sheetObj.id +"_";
    		for(var i=HeaderRows(); i <= SearchRows(); i++) {
    			if(GetCellValue(i, prefix +"rcv_rntl_seq") == "") {
					SetRowBackColor(i,LSE_TOTCOL_BACK_COLOR);
				} else {
					SetCellValue(i, prefix +"cost_yrmon",formObj.cost_yrmon.value);
				}
			}
			// setting button befor retrieve
			if(formObj.inv_no.value == formObj.invoice_no.value) {//Invoice mode
				LseComBtnControl(SearchRows()> 0, "btn_invoice");
				LseComBtnControl(false, "btn_confirm");
				LseComBtnControl(false, "btn_print");
				LseComBtnControl(true, "btn_cntr");
			}
			
			if(SearchRows()> 0) {
				var vInvAmt=Number(GetCellValue(LastRow(), prefix +"cost_amt"));
				ComSetObjValue(formObj.fm_chg_amt,	ComGetMaskedValue(vInvAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			} else {
				ComSetObjValue(formObj.fm_chg_amt,	"0.00");
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			}
			
			var strloclTax = 0;
			var vTaxAmt = "";
			vTaxAmt = Number(ComGetUnMaskedValue(formObj.tax_amount.value, "float"));
			var vChgAmt=Number(ComGetUnMaskedValue(formObj.fm_chg_amt.value, "float")) *
			  Number(ComGetUnMaskedValue(formObj.to_curr_rt.value, "float"));
			if(formObj.inv_tax_rt.value == "N" || formObj.inv_tax_rt.value == "") {
				strloclTax = 0;
				vTaxAmt = 0;
				
			}else {
				strloclTax = Number(formObj.inv_tax_rt.value);
				if(vTaxAmt == "") {
					vTaxAmt = Number(vChgAmt * (strloclTax/100));
				}
				if(isNaN(vTaxAmt) == true || vTaxAmt == "Infinity") {
					vTaxAmt = 0;
				}
			}
			
			formObj.inv_tax_rt.value = strloclTax;			
			//var vTaxAmt=formObj.inv_tax_rt.value == "N" ? 0 : (vChgAmt / 10);
			
			var vTtlAmt=vChgAmt + vTaxAmt;			
			var strToCurrCd = to_curr_cd.GetSelectText(); //Park Young Jin
			if(strToCurrCd == "KRW") {
				ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
			} else {
				ComSetObjValue(formObj.to_chg_amt,	ComGetMaskedValue(vChgAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.tax_amount,	ComGetMaskedValue(vTaxAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.ttl_chg_amt,	ComGetMaskedValue(vTtlAmt.toFixed(2), "float"));
			}
			
			ComSetObjValue(formObj.ttl_curr_cd,	strToCurrCd);
			//================================================================================
			
			if(SearchRows()> 0) {
				var vInvAmt=Number(GetCellValue(LastRow(), prefix +"cost_amt"));
				ComSetObjValue(formObj.fm_chg_amt,	ComGetMaskedValue(vInvAmt.toFixed(2), "float"));
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			} else {
				ComSetObjValue(formObj.fm_chg_amt,	"0.00");
				ComSetObjValue(formObj.fm_curr_cd,	"USD");
			}
			
			lastTaxAmount = formObj.tax_amount.value;
    	}
    }
    
    
    /**
     * handling after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	var strError = "";
    	
    	if(sheetObj.GetEtcData("arIfNo") != undefined) {
	    	if(sheetObj.GetEtcData("arIfNo").indexOf("E::") > -1) { //E::값이 존재한다면 
	    		strError = sheetObj.GetEtcData("arIfNo");
	    		ComShowCodeMessage("LSE10026",strError);
	    		return;
	    	}
    	}
    	
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE01121");
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    	}
    }
    
    
 	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1', true);
    	} else if( type == "3") {
    		var formObj=document.form;
    		ComOpenWindowCenter("/opuscntr/EES_LSE_0044.do?"+ FormQueryString(formObj), "EES_LSE_0044", 900,430, true);
    	} else if( type == "4") {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
    	} else if( type == "5") {
    		var v_cust_cnt_cd=formObj.cust_cnt_cd.value;
			var v_cust_seq=formObj.cust_seq.value;
			var classId="FNS_INV_0013";
			var param='?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			ComOpenWindow('/opuscntr/FNS_INV_0013.do' + param, '', 'width=950,height=650');
    	} else if( type == "6") {
    		var v_cust_cnt_cd=formObj.cust_cnt_cd.value;
			var v_cust_seq=formObj.cust_seq.value;
			//no support[check again]CLT 			var v_cust_nm=sheetObjects[2].UrlEncoding(formObj.cust_nm.value);
			var classId="FNS_INV_0086";
			var param='?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			ComOpenPopup('/opuscntr/FNS_INV_0086.do' + param, 900, 450, 'setPopData_Customer', '1,0', false, false);
    	}
    	return;
    }
    /**
	 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
	 * handling process for Currency Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			//ComSetObjValue(formObj.to_curr_cd, aryPopupData[0][2]);
			to_curr_cd.SetSelectText(aryPopupData[0][2], 0); //Park Young Jin
			//retrieving for Invoice Amount
			if(formObj.inv_isu_dt.value != "") {
				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC11);
			}
		}
	}
	/**
     * handling process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
    	var prefix="sheet1_";
    	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var vLeaseTerm=aryPopupData[0][7];
				if(vLeaseTerm == "SO"||vLeaseTerm == "MO") {
					SetCellValue(Row, prefix +"agmt_seq",aryPopupData[0][5],0);
					SetCellValue(Row, prefix +"lstm_cd","",0);
					SetCellValue(Row,  prefix +"lstm_cd",aryPopupData[0][7]);
				} else {
					ComShowCodeMessage("LSE10007", "\'SO\',\'MO\'");
 					SetCellValue(Row, prefix +"agmt_seq","");
				}
			}
		}
    }
	/**
	 *  handling process for Customer <br>
	 * @param  {array} rowArray
	 */
	function setPopData_Customer(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.cust_cnt_cd.value=colArray[8];
		formObj.cust_seq.value=colArray[9];
		formObj.cust_nm.value=colArray[4];
	}
	/**
	 * checking rates
	 */
	function checkXchRateAvail() {
		var rtnValue=false;
		var formObj=document.form;
		var usdXchRt=formObj.usd_xch_rt.value;
		var invXchRt=formObj.to_curr_rt.value;
		var maxInvXchRt=0;
		var minInvXchRt=0;
		if (!ComIsNull(formObj.usd_xch_rt) && !ComIsNull(formObj.to_curr_rt)) {
			maxInvXchRt=Number(ComReplaceStr(usdXchRt,",","")) * 1.5;
			minInvXchRt=Number(ComReplaceStr(usdXchRt,",","")) * 0.5;
			if (Number(ComReplaceStr(invXchRt,",","")) <= Number(maxInvXchRt) &&
				Number(ComReplaceStr(invXchRt,",","")) >= Number(minInvXchRt)) {
				formObj.to_curr_rt.value=ComAddComma(invXchRt);
				rtnValue=true;
			} else {
				formObj.to_curr_rt.value=ComAddComma(usdXchRt);
			}
		}
		return rtnValue;
	}
	/**
	 * initializing currency code
	 */
	function setDynamicCurrcyList(initFlag) {
		var formObj=document.form;
		var ofcCode=formObj.ofc_cd.value;
		var options=formObj.to_curr_cd.options;
		if(initFlag == true) {
			for(var i=0; i < options.length; i++) {
				options[i]=null;
			}
			options[0]=new Option("","");
			options[1]=new Option("KRW","KRW");
			options[2]=new Option("EUR","EUR");
			options[3]=new Option("USD","USD");
		} else if(initFlag == false) {
			for(var i=0; i < options.length; i++) {
				if(/^HAM*/.test(ofcCode) && options[i].value == "KRW" ||
				   /^SEL*/.test(ofcCode) && options[i].value == "EUR") {
					options[i]=null;
					break;
				}
			}
		}
	}
	/**
	 * handling event in case of calendao select
	 */
	function callbackSetQtyYrmon() {
		var formObj=document.form;
		var vQtyYrmon=formObj.qty_yrmon.value;
		ComResetAll();
		ComSetObjValue(formObj.qty_yrmon, vQtyYrmon);
		try {
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC01);
		} catch(e) {
			//do nothing
		}
	}
	/**
	 * handling event in case of calendao select
	 */
	function callbackSetInvIsuDt() {
		var formObj=document.form;
		try {
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC11);
			if(ComIsDate(formObj.inv_isu_dt.value)) {
				var addDays=formObj.ofc_cd.value == "HAMUOG" ? 30 : 14;
				ComSetObjValue(formObj.inv_due_dt, 	ComGetDateAdd(formObj.inv_isu_dt, "D", addDays));
			}
		} catch(e) {
			//do nothing
		}
	}
    /**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      	
    			case IBSEARCH_ASYNC03:	//retrieving for Preperation
    			case IBSEARCH_ASYNC09:	//retrieving for Invoice Summary
    				return ComChkValid(formObj);
    				break;
    			case IBSEARCH_ASYNC11:	//retrieving for Invoice Amount
    				if(formObj.inv_isu_dt.value == "") {
    					ComShowCodeMessage("LSE01111");
    					ComSetFocus(formObj.inv_isu_dt);
    					return false;
    				} else {
    					return ComChkValid(formObj);
    				}
    				break;
    			case MULTI05:
    				if( ComGetObjText(formObj.qty_yrmon) == "") {
    					ComShowCodeMessage("LSE01043");
    					ComSetFocus(formObj.qty_yrmon);
    					return false;
    				}
    				break;
    			case IBSEARCH_ASYNC12:	//retrieving for Customer Name
    				if(formObj.cust_cnt_cd.value == "") {
    					ComShowCodeMessage("LSE01154");
    					ComSetObjValue(formObj.cust_seq, "");
    					ComSetFocus(formObj.cust_cnt_cd);
    					return false;
    				} else {
    					return ComChkValid(formObj);
    				}
				default :	//do nothing
    		}
    	}
	    with(sheetObj) {
	    	var prefix=sheetObj.id +"_";
    		switch(sAction) {
	    		case IBSEARCH_ASYNC04:	//saving for Charge Creation
	    			if(FindCheckedRow(prefix +"del_chk") == "") {
	    				ComShowMessage(sheetObj.MessageText("UserMsg13"));
	    				return false;
	    			}
	    			//checking whether data duplicate
					var dupRow=ColValueDup("sheet1_agmt_seq|sheet_1_cost_yrmon", false);
					if(dupRow != -1 && GetRowStatus(dupRow) == "I") {
						ComShowCodeMessage("LSE01055");
						SetCellValue(dupRow, prefix +"agmt_seq","");
						return false;
					}
	    			for(var i=0; i <= RowCount(); i++) {
	    				var vChgStsCd=GetCellValue(i, prefix +"lse_cntr_chg_sts_cd");
	    				if(GetCellValue(i, prefix +"del_chk") == 1) {
	    					if(GetRowStatus(i) == "I" && GetCellValue(i, prefix +"agmt_seq") == "") {
	    						ComShowCodeMessage("LSE01006");
		    					SelectCell(i, prefix +"agmt_seq");
		    					return false;
	    					} else if(vChgStsCd == "C") {
		    					ComShowCodeMessage("LSE01058");
		    					SelectCell(i, prefix +"del_chk");
		    					return false;
		    				}
	    				}
	    			}
	    			return true;
	    			break;
	    		case IBSEARCH_ASYNC05:	//saving for RE Creation
	    			if(FindCheckedRow(prefix +"del_chk") == "") {
	    				ComShowMessage("There is no contents to save.");
	    				return false;
	    			}
					//checking whether data duplicate
					var dupRow=ColValueDup("sheet1_agmt_seq|sheet_1_cost_yrmon", false);
					if(dupRow != -1 && GetRowStatus(dupRow) == "I") {
						ComShowCodeMessage("LSE01055");
						SetCellValue(dupRow, prefix +"agmt_seq","");
						return false;
					}
	    			for(var i=0; i <= RowCount(); i++) {
	    				var vChgStsCd=GetCellValue(i, prefix +"lse_cntr_chg_sts_cd");
	    				if(GetCellValue(i, prefix +"del_chk") == 1) {
	    					if(GetRowStatus(i) == "I" && GetCellValue(i, prefix +"agmt_seq") == "") {
	    						ComShowCodeMessage("LSE01006");
		    					SelectCell(i, prefix +"agmt_seq");
		    					return false;
	    					}
	    				}
	    			}
	    			return true;
	    			break;
	    		case IBSEARCH_ASYNC06:	//saving for Invoice Creation
	    		case IBSEARCH_ASYNC13:	//saving for Invoice Confirm
	    			if(formObj.cust_cnt_cd.value == "") {
						ComShowCodeMessage("LSE01154");
    					ComSetFocus(formObj.cust_cnt_cd);
    					return false;
    				} else if(formObj.cust_seq.value == "") {
						ComShowCodeMessage("LSE01155");
    					ComSetFocus(formObj.cust_seq);
    					return false;
    				} else if(formObj.inv_isu_dt.value == "") {
    					ComShowCodeMessage("LSE01111");
    					ComSetFocus(formObj.inv_isu_dt);
    					return false;
    				} else if(formObj.inv_due_dt.value == "") {
    					ComShowCodeMessage("LSE01112");
    					ComSetFocus(formObj.inv_due_dt);
    					return false;
    				}
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
	}
	/**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
			case "invoice_no":
				//setDynamicCurrcyList(true);
				ComSetObjValue(formObj.inv_no, "");
				ComSetObjValue(formObj.inv_vndr_seq, "");
				ComSetObjValue(formObj.inv_vndr_abbr_nm, "");
				ComSetObjValue(formObj.cost_yrmon,  "");
				ComSetObjValue(formObj.rcv_rntl_seq,"");
				ComSetObjValue(formObj.inv_agmt_seq,"");
				ComSetObjValue(formObj.inv_lstm_cd, "");
				ComSetObjValue(formObj.fm_chg_amt,	"");
				ComSetObjValue(formObj.fm_curr_cd,	"");
				ComSetObjValue(formObj.to_curr_rt,	"");
				ComSetObjValue(formObj.usd_xch_rt,	"");
				ComSetObjValue(formObj.to_chg_amt,	"");
				//ComSetObjValue(formObj.to_curr_cd,	"");
				to_curr_cd.SetSelectCode(-1,false); //Park Young Jin
				ComSetObjValue(formObj.inv_isu_dt,	"");
				ComSetObjValue(formObj.inv_due_dt,	"");
				ComSetObjValue(formObj.cust_cnt_cd,	"");
				ComSetObjValue(formObj.cust_seq,	"");
				ComSetObjValue(formObj.cust_nm,	"");
				ComSetObjValue(formObj.tax_amount,	"");
				ComSetObjValue(formObj.ttl_chg_amt,	"");
				ComSetObjValue(formObj.ttl_curr_cd,	"");
				ComSetObjValue(formObj.inv_tax_rt,"");
				ComEnableObject(formObj.inv_tax_rt,false);
				ComEnableObject(formObj.tax_amount,false);
				formObj.inv_tax_rt.readOnly = true;
				formObj.tax_amount.readOnly = true;
				ComEnableObject(formObj.cust_cnt_cd, false);
				ComEnableObject(formObj.cust_seq, false);
				ComEnableObject(formObj.inv_isu_dt,false);
				ComEnableObject(formObj.inv_due_dt,false);
				ComEnableObject(formObj.to_curr_rt, false);
				//ComEnableObject(formObj.to_curr_cd, false);
				to_curr_cd.SetEnable(0); //Park Young Jin
				ComEnableObject(formObj.btns_cust1,false);
				ComEnableObject(formObj.btns_cust2,false);
				//ComEnableObject(formObj.btns_search2,  false);
				ComEnableObject(formObj.btns_calendar2,false);
				ComEnableObject(formObj.btns_calendar3,false);
				formObj.cust_cnt_cd.className="input2";
				formObj.cust_seq.className="input2";
				formObj.inv_isu_dt.className="input2";
				formObj.inv_due_dt.className="input2";
				formObj.inv_tax_rt.className="input2";
				formObj.tax_amount.className="input2";
				formObj.to_curr_rt.className="input2";
				//formObj.to_curr_cd.className="input2";
				formObj.inv_tax_rt.disabled=true;
				formObj.tax_amount.disabled=true;
				sheetObjects[1].RemoveAll();
				break;
			case "to_curr_rt":
			case "to_curr_cd":
			case "inv_isu_dt":
				//setDynamicCurrcyList(true);
				ComSetObjValue(formObj.to_curr_rt,	"");
				ComSetObjValue(formObj.usd_xch_rt,	"");
				ComSetObjValue(formObj.to_chg_amt,	"");
				//ComSetObjValue(formObj.to_curr_cd,	"");
				to_curr_cd.SetSelectCode(-1,false);  //Park Young Jin
				ComSetObjValue(formObj.inv_isu_dt,	"");
				ComSetObjValue(formObj.inv_due_dt,	"");
				ComSetObjValue(formObj.tax_amount,	"");
				ComSetObjValue(formObj.ttl_chg_amt,	"");
				ComSetObjValue(formObj.ttl_curr_cd,	"");
				ComSetObjValue(formObj.inv_tax_rt,"");
				ComEnableObject(formObj.to_curr_rt, true);
				//ComEnableObject(formObj.to_curr_cd, false);
				to_curr_cd.SetEnable(0); //Park Young Jin
				//ComEnableObject(formObj.btns_search2,false);
				formObj.to_curr_rt.className="input2";
				//formObj.to_curr_cd.className="input2";
				formObj.inv_tax_rt.disabled=false;
				formObj.tax_amount.disabled=false;
				ComSetFocus(formObj.inv_isu_dt);
				break;
			case "cust_cnt_cd":
				ComSetObjValue(formObj.cust_cnt_cd, "");
				ComSetObjValue(formObj.cust_seq,  	"");
				ComSetObjValue(formObj.cust_nm,		"");
				break;
			case "cust_seq":
				ComSetObjValue(formObj.cust_seq,  	"");
				ComSetObjValue(formObj.cust_nm,		"");
				break;
			case "inv_cfrm":
				//setDynamicCurrcyList(false);
				ComEnableObject(formObj.to_curr_rt, true);
				//ComEnableObject(formObj.to_curr_cd, true);
				to_curr_cd.SetEnable(1);  //Park Young Jin
				ComEnableObject(formObj.cust_cnt_cd, true);
				formObj.inv_tax_rt.readOnly = false;
				formObj.tax_amount.readOnly = false;
				ComEnableObject(formObj.cust_seq, true);
				ComEnableObject(formObj.inv_isu_dt, true);
				ComEnableObject(formObj.inv_due_dt, true);
				ComEnableObject(formObj.btns_cust1,true);
				ComEnableObject(formObj.btns_cust2,true);
				ComEnableObject(formObj.btns_calendar2,true);
				ComEnableObject(formObj.btns_calendar3,true);
				formObj.inv_tax_rt.disabled=false;
				formObj.tax_amount.disabled=false;
				
				//ComEnableObject(formObj.btns_search2,  true);
				formObj.inv_tax_rt.className="input1";
				formObj.tax_amount.className="input1";
				formObj.to_curr_rt.className="input1";
				//formObj.to_curr_cd.className="input1";
				formObj.cust_cnt_cd.className="input1";
				formObj.cust_seq.className="input1";
				formObj.inv_isu_dt.className="input1";
				formObj.inv_due_dt.className="input1";
				break;
		}
	}
	/* end of developer job */
