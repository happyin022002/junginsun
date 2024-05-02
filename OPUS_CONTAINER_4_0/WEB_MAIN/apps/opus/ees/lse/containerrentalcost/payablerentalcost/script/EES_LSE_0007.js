/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0007.js
*@FileTitle  : Container Rental Charge Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/

	var sheetObjects=new Array(); 
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0; 
	var usrOfcCd="";
	var backEndJobType;
	var timer;
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
			var srcName=ComGetEvent("name");
			 if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					removePage(formObj);
					// not settion in case of Retrieve buton
					ComSetObjValue(formObj.checkedRows,    "");
					//ComSetObjValue(formObj.checkedChgSeqs, "");
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_New":
					ComResetAll(); 
					ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
					sheetObjects[0].ClearHeaderCheck();
					sheetObjects[1].ClearHeaderCheck();
					sheetObjects[0].SetSheetHeight(190);
					sheetObjects[1].SetSheetHeight(190);
					sheetObjects[2].SetSheetHeight(122);
					ComSetObjValue(formObj.chg_cost_yrmon, ComGetObjValue(formObj.cost_yrmon));
					ComAddSeparator(form.chg_cost_yrmon, "ym");
					comboObjects[0].SetSelectIndex(0);
					comboObjects[1].SetSelectIndex(0);
					ComSetFocus(formObj.vndr_seq);
					break;
				case "btns_calendar":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.chg_cost_yrmon, 'yyyy-MM');
					break;
				case "btns_search":		// Lessor(Service Provider) Pop-up
					openPopupPage("2");
					break;
				case "btns_search2":	// Currency Pop-up
					openPopupPage("4");
					break;
				case "btns_search3":	// Pay Vendor Pop-up
					openPopupPage("5");
					break;
				case "btn_FileImport":	// Lessor Invoice File Import Pop-up
					openPopupPage("1");
					break;
				case "btn_ChgCreate":
					if ( ComShowCodeConfirm("LSE01116") ) {
						removePage(formObj);
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
					}
					break;
				case "btn_ChgDelete":
					if ( ComShowCodeConfirm("LSE01117") ) {
						removePage(formObj);
						doActionIBSheet(sheetObject1, formObj, IBDELETE);
					}
					break;
				case "btn_Audit":
					openPopupPage("3");
					break;
				case "btns_calendar1":
					var cal=new ComCalendar();
	                cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
					break;
				case "btns_calendar2":
					var cal=new ComCalendar();
	                cal.select(formObj.inv_iss_dt, 'yyyy-MM-dd');
					break;
				case "btn_InvoiceCreation":
					if(sheetObject3.RowCount() > 0) {
						if ( ComShowCodeConfirm("LSE01120") ) {
							doActionIBSheet(sheetObject2, formObj, IBSAVE);
						}
					}else{
						ComShowCodeMessage("LSE10009");
						return;
					}
					break;
				case "btn_Office":
					openPopupPage("10");
        			break;
				case "btn_minimize1":	//minimizing sheet 1
					if(sheetObjects[0].GetSheetHeight() == "410") {
						sheetObjects[0].SetSheetHeight(190);
						$('#btn_minimize1').removeClass('btn_up').addClass('btn_down');
					}else{
						sheetObjects[0].SetSheetHeight(410);
						$('#btn_minimize1').removeClass('btn_down').addClass('btn_up');
					}
					
                    break;
                case "btn_minimize2":	//minimizing sheet 2
                	if(sheetObjects[1].GetSheetHeight() == "410") {
						sheetObjects[1].SetSheetHeight(190);
						$('#btn_minimize2').removeClass('btn_up').addClass('btn_down');
					}else{
						sheetObjects[1].SetSheetHeight(410);
						$('#btn_minimize2').removeClass('btn_down').addClass('btn_up');
					}
                    break;
                case "btn_minimize3":	//minimizing sheet 2
                	if(sheetObjects[2].GetSheetHeight() == "410") {
						sheetObjects[2].SetSheetHeight(122);
						$('#btn_minimize3').removeClass('btn_up').addClass('btn_down');
					}else{
						sheetObjects[2].SetSheetHeight(410);
						$('#btn_minimize3').removeClass('btn_down').addClass('btn_up');
					}
                    break;
                case "btn_VaTax":
					openPopupPage("11");
        			break;
                case "btn_WhTax":
					openPopupPage("12");
        			break;
                case "btn_DownExcel01":
        			if(sheetObjects[0].RowCount() < 1){//no data
        				ComShowCodeMessage("COM132501");
        				}else{
        					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
        				}
        		break;
                case "btn_DownExcel02":
                	if(sheetObjects[1].RowCount() < 1){//no data
        				ComShowCodeMessage("COM132501");
        				}else{
        					sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
        				}
        		break;
                case "btn_DownExcel03":
                	if(sheetObjects[2].RowCount() < 1){//no data
        				ComShowCodeMessage("COM132501");
        				}else{
        					sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
        				}
        		break;
                case "btn_ChargeCreation":
                	doActionIBSheet(sheetObject1, formObj, COMMAND07);
        		break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
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
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj=document.form;
		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		/* Axon Control Setting*/
		initControl();
		/* Cost Month Default Value Setting : 전월 */
		ComSetObjValue(formObj.chg_cost_yrmon, ComGetObjValue(formObj.cost_yrmon));
		ComAddSeparator(form.chg_cost_yrmon, "ym");
		usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		//axon_event.addListenerForm('beforedeactivate',		'obj_blur',		formObj); 
  		axon_event.addListenerForm('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerForm('focus',		'obj_focus',	formObj); 
  		axon_event.addListenerFormat('keypress','obj_keypress',	formObj); 
//		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',	'obj_change',	formObj); 
  	}
  	
  	
  	 function keypressFormat() {
  	  	var obj=ComGetEvent();
  	 	if(obj.dataformat == null) return;
  	     switch(ComGetEvent("name")) {    
  	    
  	     case "inv_vat_amt":
  	     case "whld_tax_amt":
  	     case "inv_ttl_amt":
  	    	 ComKeyOnlyNumber();
  	      	break;     	
  		}
  	 }
  	 
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
  		var formObj=document.form;
  		var obj=event.srcElement;
	    switch(ComGetEvent("name")){
	        case "vndr_seq":
	        case "pay_vndr_seq":
	            /* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        case "inv_rcv_dt":
	        	ComChkObjValid(obj);
	        	//if ( ComGetObjValue(formObj.inv_rcv_dt) != "" ) {
	        	//	setInvEffDt(formObj, ComGetObjValue(formObj.inv_rcv_dt));
	        	//}
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
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    ComClearSeparator(event.srcElement);
		}
	}
	/**
	 * handling event in case of Key-Press
	 */
  	function obj_keypress() {
		var obj=event.srcElement;
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
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
	        	if ( obj.name == "cost_ofc_cd" ) {
	        		ComKeyOnlyAlphabet('uppernum');
	        	} else {
	        		ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}
  	/**
  	 * handling event in case of Key-Up
  	 */
  	function obj_keyup() {
  		var obj=event.srcElement;
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
			case "chg_cost_yrmon":
				ComKeyEnter('LengthNextFocus');
  				break;
			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			case "pay_vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.pay_vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  		}
  	}
   	/**
	 * handling event in case of Key-Down
	 */
   	function obj_keydown() {
	   	var formObj=document.form;
		var obj=event.srcElement;
   		var vKeyCode=event.keyCode;
   		switch(ComGetEvent("name")) {
	   		case "inv_rmk":
				// 힌글입력방지
	    		if ( event.keyCode == "229" ) {
	    			event.returnValue=false;
	    			return true;
	    		}
				if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
	  			}
	  			break;
   		}
   	}
	/**
	 * handling event in case of Change
	 */
	function obj_change() {
		var obj=event.srcElement;
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
				case "chg_cost_yrmon":
					sheetObjects[0].RemoveAll();
					removePage(formObj);
					break;
				case "vndr_seq":
					sheetObjects[0].ClearHeaderCheck();
					sheetObjects[0].RemoveAll();
					removePage(formObj);
					doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
				   	break;
	    		case "curr_cd":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;
	    		case "inv_rcv_dt":
	    			//if ( ComGetObjValue(formObj.inv_rcv_dt) != "" ) {
	    			//	setInvEffDt(formObj, ComGetObjValue(obj));
	    			//}
	    			break;
	    		case "cost_ofc_cd":			//Office Code
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
	  				}
					break;
	    		case "pay_vndr_seq":
					doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
				   	break;
	    		case "inv_vat_amt":
	    		case "whld_tax_amt":
	    			formObj.inv_ttl_amt.value = 	parseFloat(ComReplaceStr(isGetNull(formObj.inv_amt.value),",","")) + 
	    													parseFloat(ComReplaceStr(isGetNull(formObj.inv_vat_amt.value),",","")) - 
	    													parseFloat(ComReplaceStr(isGetNull(formObj.whld_tax_amt.value),",",""));
	    			
	    			formObj.inv_ttl_amt.value = ComAddComma(Math.round(formObj.inv_ttl_amt.value * 100)/100);
	    			
	    			break;
			}
		}
	}
	
	
	function isGetNull(obj) {
		var rtn = "";
		if(obj == null || obj == "") {
			rtn = "0.00";
		}else{
			rtn = obj;
		}
		return rtn;
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){		        
				      var HeadTitle1="||Seq.|STS|AGMT No.|Ver|Term|Payment Type|Contract No.|Reference|Effective date|Effective date|Invoice No|Charge AMT|Lessor AMT|Credit AMT|Payable AMT|DIFF. AMT|Register No.|Currency|||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 5, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						             {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"chkbox",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Seq",       Hidden:0, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"seq" },
						             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chg_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lst_ver_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					  	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
						             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"com_ttl_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_ttl_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cr_ttl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pay_rntl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"diff_cost_amt",      KeyField:0,   CalcLogic:"|pay_rntl_cost_amt|-|com_ttl_chg_amt|",    Format:"NullFloat",   PointCount:2, UpdateEdit:0, InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_rgst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_fil_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pdm_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(190);
				      
				      SetColProperty(0 ,"inv_no" , {AcceptKeys:"E|[0123456789 -]" , InputCaseSensitive:1});
		            }
				break;
			case "sheet2":
			    with(sheetObj){
				      var HeadTitle1="||Invoice No.|User ID|Create Date|AGMT No.|Contract No.|Issue Ofc.|Lease Term|Lessor AMT|Per-diem AMT|Credit AMT|Payable AMT|Charge Total|||||V.A.Tax|W.H.Tax|";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chkbox",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"issu_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_ttl_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:1,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"pdm_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cr_ttl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pay_rntl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"com_ttl_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				      		 {Type:"Float",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_vat_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" ,            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				      		 {Type:"Float",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"whld_tax_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat" ,            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				      		 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"" ,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			       
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(190);
		            }
				break;
			case "sheet3":
			    with(sheetObj){
				      var HeadTitle1="|Seq.|Invoice No.|VVD|Cost Code|Cost Name|AGMT No.|Contract No.|Charge Type|TP/SZ|Lessor AMT|Credit AMT|||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"cost_nm",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lse_pay_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_vat_amt",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"whld_tax_amt",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"" ,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
				       
				      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(122);
		            }
				break;
         }
	}
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			case "lstm_cd":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetUseAutoComplete(1);
				}
 	        	break;
		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.SetWaitImageVisible(0);
				/* Lease Term Form Combo Item Setting */
				var strText="ALL|OF|LT|ST|SI|MI|SO";
        		var strCode=" |OF|LT|ST|SI|MI|SO";
        		LseComText2ComboItem(comboObjects[0], strText, strCode, "|");
        		comboObjects[0].SetSelectIndex(0);
        		// 2016.03.11 #9405 - Lease Payment Type 추가 by 전지연
        		formObj.f_cmd.value=SEARCH09;	
    			var intgCdId='CD30090';
    			var param="&intgCdId="+intgCdId;
    			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
    			var chk=xml.indexOf("ERROR");
    			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
    			   sheetObj.LoadSearchData(xml,{Sync:1} );
    			   return;
    		    } 
    			if (xml != "") {
    				var schargeType=ComGetEtcData(xml, "code_nm");
    				var arrchargeType=schargeType.split("@");
    				MakeComboObject(comboObjects[1], arrchargeType, 1, 0);
    			}	
        		/* 초기 Focus Setting */
        		ComSetFocus(formObj.vndr_seq);
		        break;
			case IBSEARCH: 
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						ComSetObjValue(formObj.f_cmd, SEARCH);
 						sheetObj.DoSearch("EES_LSE_0007GS.do", FormQueryString(formObj) );
					} else if ( sheetObj.id="sheet3" ) {
						/*========================================*/
						/* Sheet2 Check box Check 시 Sheet3 Search */
						/*========================================*/
						// Sheet2 Checkbox Row Find. Sheet3 조회조건으로 사용.						
						var chkRows=sheetObjects[1].FindCheckedRow("chkbox");
						var arrChkRow=chkRows.split("|");
						var chgSeqs="";
						var chkPayableAmt = "N";
						var chkPayableAmtCnt = 0;
						if(sheetObjects[1].GetHeaderCheck(0, 1) == "1") {							
							 if(arrChkRow.length == sheetObjects[1].RowCount()){
								 for ( var i=0 ; i < arrChkRow.length ; i++ ) {
									 var payableAmt =sheetObjects[1].GetCellValue(arrChkRow[i], "pay_rntl_cost_amt");
									 if(payableAmt == 0) {
										 	chkPayableAmtCnt = chkPayableAmtCnt +1;
											sheetObjects[1].SetCellValue(arrChkRow[i], "chkbox", 0 ,0);
											chkPayableAmt = "Y";
										}
								 }
								 
								 if(chkPayableAmt == "Y"){
									 ComShowCodeMessage("LSE10029", chkPayableAmtCnt);
									 chkRows=sheetObjects[1].FindCheckedRow("chkbox");
									 arrChkRow=chkRows.split("|");
								 }
								 
								 for ( var i=0 ; i < arrChkRow.length ; i++ ) {
									var chgSeq=sheetObjects[1].GetCellValue(arrChkRow[i], "chg_seq");
									// sheetObjects[2] Sheet에 없는 chg_seq 만 조회하기 위한 조건
									if ( sheetObj.FindText("chg_seq", chgSeq) == -1 ) {
										if ( chgSeqs == "" ) {
											chgSeqs=chgSeq;
										} else {
											chgSeqs=chgSeqs + "|" + chgSeq;
										}
									}
								}
								var sParam="f_cmd="+COMMAND05;
								sParam=sParam + "&chg_seq="+chgSeqs;
								if ( sheetObj.RowCount()> 0 ) {
									// sheet3 에 조회된 내역이 있다면 새로 조회된 내용을 Append.
		 							sheetObj.DoSearch("EES_LSE_0007GS.do", sParam,{Append:true} );
								} else {
									// sheet3 에 조회된 내역이 없을 경우.
		 							sheetObj.DoSearch("EES_LSE_0007GS.do", sParam );
								}
							 }
						}else{
							for ( var i=0 ; i < arrChkRow.length ; i++ ) {
								var chgSeq=sheetObjects[1].GetCellValue(arrChkRow[i], "chg_seq");
								// sheetObjects[2] Sheet에 없는 chg_seq 만 조회하기 위한 조건
								if ( sheetObj.FindText("chg_seq", chgSeq) == -1 ) {
									if ( chgSeqs == "" ) {
										chgSeqs=chgSeq;
									} else {
										chgSeqs=chgSeqs + "|" + chgSeq;
									}
								}
							}
							var sParam="f_cmd="+COMMAND05;
							sParam=sParam + "&chg_seq="+chgSeqs;
							if ( sheetObj.RowCount()> 0 ) {
								// sheet3 에 조회된 내역이 있다면 새로 조회된 내용을 Append.
	 							sheetObj.DoSearch("EES_LSE_0007GS.do", sParam,{Append:true} );
							} else {
								// sheet3 에 조회된 내역이 없을 경우.
	 							sheetObj.DoSearch("EES_LSE_0007GS.do", sParam );
							}
						}
					}
				}
 				break;
			case IBSAVE:        //저장
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						// Charge Creation.
						ComSetObjValue(formObj.f_cmd, COMMAND01);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType=ComGetObjValue(formObj.f_cmd);
						var sParam=FormQueryString(formObj);
						// Check box 선택된 Row 만 Charge Creation.
						var sSheetParam=sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam=ComSetPrifix(sSheetParam, "sheet1_");
						sParam=sParam + "&" + sSheetParam;
 						var sXml=sheetObj.GetSaveData("EES_LSE_0007GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.SetWaitTimeOut(10000);
							timer=setInterval(getBackEndJobStatus, 3000);
						}
					} else if ( sheetObj.id == "sheet2" ) {
						// Invoice Creation.
						ComSetObjValue(formObj.f_cmd, COMMAND06);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType=ComGetObjValue(formObj.f_cmd);
						var sParam=FormQueryString(formObj);
						// Check box 선택된 Row 만 Invoice Creation. sheet2는 Header Data 로 사용됨.
						var sSheetParam=sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam=ComSetPrifix(sSheetParam, "sheet2_");
						sParam=sParam + "&" + sSheetParam;
						// Sub Total 숨기기.
						sheetObjects[2].HideSubSum("ibflag");
						// sheet3는 Invoice Creation 의 Detail Data 로 사용됨.
						var sSheetParam2=sheetObjects[2].GetSaveString(true);
						sSheetParam2=ComSetPrifix(sSheetParam2, "sheet3_");
						sParam=sParam + "&" + sSheetParam2;
 						var sXml=sheetObj.GetSaveData("EES_LSE_0007GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObjects[0].SetWaitImageVisible(0);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.SetWaitTimeOut(10000);
							timer=setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;
			case IBDELETE:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						ComSetObjValue(formObj.f_cmd, COMMAND02);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType=ComGetObjValue(formObj.f_cmd);
						var sParam=FormQueryString(formObj);
						// Check box 선택된 Row 만 Charge Creation.
						var sSheetParam=sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam=ComSetPrifix(sSheetParam, "sheet1_");
						sParam=sParam + "&" + sSheetParam;
 						var sXml=sheetObj.GetSaveData("EES_LSE_0007GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							sheetObj.SetWaitTimeOut(10000);
							timer=setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;
			case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								//ComDebug(ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetObjValue(formObj.gen_pay_term_cd, ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetNextFocus(formObj.vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetObjValue(formObj.gen_pay_term_cd, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetObjValue(formObj.gen_pay_term_cd, "");
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}
				break;
 			case IBSEARCH_ASYNC02:	//조회(Form Curr 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.SetWaitImageVisible(0);
 					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(formObj.curr_cd);
						} else {
							//ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(formObj.curr_cd);
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(formObj.curr_cd);
					}
				}
				break;
			case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param="f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
 					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.cost_ofc_cd.value=ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.cost_ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.cost_ofc_cd.value="";
								ComSetFocus(formObj.cost_ofc_cd);
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.cost_ofc_cd.value="";
							ComSetFocus(formObj.cost_ofc_cd);
						}
					}
				}
	        	break;
			case IBSEARCH_ASYNC04:	//조회(Form Pay Vendor 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.pay_vndr_seq);
						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.pay_vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.pay_vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.pay_vndr_seq, "");
	 							ComSetObjValue(formObj.pay_vndr_nm, "");
	 							ComSetFocus(formObj.pay_vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.pay_vndr_seq, "");
							ComSetFocus(formObj.pay_vndr_seq);
						}
					}
				}
				break;
			case COMMAND07:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
		        ComOpenWait(true);
		        formObj.f_cmd.value=COMMAND07;
		        var sParam = sheetObj.GetSaveString(0);
		        sParam= sParam + "&"+FormQueryString(formObj);
		        var sXml=sheetObj.GetSaveData("EES_LSE_0007GS.do", sParam );
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
			default: 
					break;
				
				break;
		}
	}
	/**
	 * handling process for input validation
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.chg_cost_yrmon) == "" ) {
						ComShowCodeMessage("LSE01098");
						ComSetFocus(formObj.chg_cost_yrmon);
						return false;
					}
					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
				}
				break;
			case IBSAVE:
				if ( sheetObj.id == "sheet1" ) {
					// Charge Creation : Check 된 Row 확인.
					var sRow=sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return false;
					}
					var arrRow=sRow.split("|"); //결과 : "1|3|5|"
					for ( var i=0 ; i < arrRow.length ; i++ ) {
						var chg_sts=sheetObj.GetCellValue(arrRow[i], "chg_sts_cd");
						if ( chg_sts != "N") {
							ComShowCodeMessage("LSE01058");
							return false;
						}
					}
				} else if ( sheetObj.id == "sheet2" ) {
					// Invoice Creation : Check 된 Row 확인.
					var sRow=sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return false;
					}
					if( ComGetObjText(formObj.pay_vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.pay_vndr_seq);
						return false;
					}
					if( ComGetObjText(formObj.inv_rcv_dt) == "" ) {
						ComShowCodeMessage("LSE01123");
						ComSetFocus(formObj.inv_rcv_dt);
						return false;
					}
					if( ComGetObjText(formObj.inv_iss_dt) == "" ) {
						ComShowCodeMessage("LSE01111");
						ComSetFocus(formObj.inv_iss_dt);
						return false;
					}
					/*
					if( ComGetObjText(formObj.vndr_term_nm) == "" ) {
						ComShowCodeMessage("LSE01122");
						ComSetFocus(formObj.vndr_term_nm);
						return false;
					}
 					*/
					if( ComGetObjText(formObj.curr_cd) == "" ) {
						ComShowCodeMessage("LSE01012");
						ComSetFocus(formObj.curr_cd);
						return false;
					}
				}
				break;
			case IBDELETE:
				if ( sheetObj.id == "sheet1" ) {
					// Charge Delete : Check 된 Row 확인.
					var sRow=sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return 0;
					}
					var arrRow=sRow.split("|"); //결과 : "1|3|5|"
					for ( var i=0 ; i < arrRow.length ; i++ ) {
						var chg_sts=sheetObj.GetCellValue(arrRow[i], "chg_sts_cd");
						if ( chg_sts  == "N" ) {
							ComShowCodeMessage("LSE01099");
							return false;
						} else if ( chg_sts  == "I" ) {
							ComShowCodeMessage("LSE01100");
							return false;
						}
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
				}
				break;
			case IBSEARCH_ASYNC04:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.pay_vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.pay_vndr_seq);
						return false;
					}
				}
				break;
			case COMMAND07:
				if( ComGetObjText(formObj.chg_cost_yrmon) == "") {
					ComShowCodeMessage("LSE01098");
					ComSetFocus(formObj.chg_cost_yrmon);
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * Sheet1 OnLoadFinish Event 처리
	 * @param sheetObj
	 * @return
	 */
function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	/**
	 * Sheet1 OnSearchEnd Event 처리
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg == "" ) {
			var formObj=document.form;
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				var chg_sts=sheetObj.GetCellValue(i, "chg_sts_cd");
				if ( chg_sts  == "I") {
					sheetObj.SetCellEditable(i, "chkbox",0);
				} else if ( chg_sts  == "H") {
					sheetObj.SetCellEditable(i, "inv_no",1);
				} else if ( chg_sts  == "C") {
					if ( sheetObj.GetCellValue(i, "inv_fil_flg") == "N" ) {
						sheetObj.SetCellEditable(i, "inv_no",1);
					}
				}
			}
			// 재조회 전 check 된 Row를 재조회 후 재설정. Row Index 로 재설정(Charge Sequence 사용안함).
			var sRows=ComGetObjValue(formObj.checkedRows);
			if ( sRows != "" ) {
				var arrRow=sRows.split("|");
				for ( var i=0 ; i <= arrRow.length-1 ; i++ ) {
					sheetObj.SetCellValue(arrRow[i], "chkbox",1);
				}
			}
			/*
			var chgSeqs=ComGetObjValue(formObj.checkedChgSeqs);
			if ( chgSeqs != "" ) {
				var arrChgSeq=chgSeqs.split("|");
				for ( var i=0 ; i < arrChgSeq.length ; i++ ) {
					for ( var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++ ) {
			if ( sheetObj.GetCellValue(j, "chg_seq") == arrChgSeq[i] ) {
							sheetObj.SetCellValue(j, "chkbox",1);
						}
					}
				}
			}
			*/
		}
	}
	/**
	 * sheet1 Onhandling event in case of Change
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		var sheetObj2=sheetObjects[1];
		switch (colName) {
			case "chkbox":
				checkChargeForAudit(sheetObj, Row, Value);
				break;
			case "inv_no":
				// INVOICE DUP CHECK
				var CheckText = "N";
				if(Value != null || Value != undefined || Value != ""){
					for(var i=1; i<sheetObj.RowCount();i++) {
						if(sheetObj.GetCellValue(i,"inv_no") != "" && i != Row) {
							if(sheetObj.GetCellValue(i,"inv_no") == Value) {
								CheckText = "Y";
								break;
							}
						}
					}
					
					if (CheckText == "Y") {
			        	ComShowCodeMessage('LSE10020');
						sheetObj.SetCellValue(Row, Col,'',0);
						sheetObj.SelectCell(Row, Col, true);
						return false;
		 			}
					
					var sParam="f_cmd="+SEARCH22;
					sParam=sParam + "&inv_no="+Value;
					sParam=sParam + "&mdl_cd="+"LSE";
					sParam=sParam + "&vndr_seq="+formObj.vndr_seq.value;
					sParam=sParam + "&ref_pk="+"";
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do" , sParam);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S" ) {
						//sheetObj.LoadSearchData(sXml,{Sync:1} );
						showErrMessage(ComGetSelectSingleNode(sXml, "MESSAGE"));
						sheetObj.SetCellValue(Row, "inv_no","",0);
						return false;
					} 
				}
				// INVOICE UPDATE
				
				var sParam="f_cmd="+COMMAND04;
				sParam=sParam + "&chg_seq="+sheetObj.GetCellValue(Row, "chg_seq");
				sParam=sParam + "&agmt_cty_cd="+sheetObj.GetCellValue(Row, "agmt_cty_cd");
				sParam=sParam + "&agmt_seq="+sheetObj.GetCellValue(Row, "agmt_seq");
				sParam=sParam + "&inv_no="+Value;
 				var sXml=sheetObj.GetSaveData("EES_LSE_0007GS.do" , sParam);
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S" ) {
					ComShowCodeMessage("LSE01101");
					sheetObj.SetCellValue(Row, "inv_no","",0);
				} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					sheetObj.SetCellValue(Row, "chkbox","0");
					sheetObj.SetCellValue(Row, "chg_sts_cd","C");
					//sheetObj.CellValue(Row, "inv_no")
					//removePage(formObj);
				}
				break;
		}
	}
	/**
	 * Invoice Creation 완료된 건의 Audit 내역을 조회함.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param CellX
	 * @param CellY
	 * @param CellW
	 * @param CellH
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		switch(colName) {
			case "if_rgst_no":
				if ( sheetObj.GetCellValue(Row, "chg_sts_cd") == "I" ) {
					var sParam="?chg_cost_yrmon="   + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-","");
					sParam=sParam + "&vndr_seq="    + ComGetObjValue(formObj.vndr_seq);
					sParam=sParam + "&vndr_nm="     + ComGetObjValue(formObj.vndr_nm);
					sParam=sParam + "&inv_no="      + sheetObj.GetCellValue(Row, "inv_no");
					sParam=sParam + "&chg_seq="     + sheetObj.GetCellValue(Row, "chg_seq");
					sParam=sParam + "&agmt_cty_cd=" + sheetObj.GetCellValue(Row, "agmt_cty_cd");
					sParam=sParam + "&agmt_seq="    + sheetObj.GetCellValue(Row, "agmt_seq");
					sParam=sParam + "&inv_yn=Y";
					ComOpenPopup('/opuscntr/EES_LSE_0007_01.do'+sParam, 920, 550, 'setPopData_Audit', '1,0', true);
				}
				break;
		}
	}
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		switch (colName) {
			case "chkbox":
				var invNo=sheetObj.GetCellValue(Row, "inv_no");
				var payableAmt =sheetObj.GetCellValue(Row, "pay_rntl_cost_amt");
				var chkNo = "N";
				if(sheetObj.GetHeaderCheck(0, 1) == "0") {
					if ( Value == "1" ) {
						if(payableAmt == 0) {
							ComShowCodeMessage("LSE10029");
							sheetObj.SetCellValue(Row, "chkbox", 0 ,0);
							return false;
						}else{
							ComSetObjValue(formObj.pay_vndr_seq, formObj.vndr_seq.value);
							ComSetObjValue(formObj.pay_vndr_nm, formObj.vndr_nm.value);
							doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
						}
					} else {
						while ( sheetObjects[2].FindText("inv_no", invNo) != -1 ) {
							sheetObjects[2].RowDelete(sheetObjects[2].FindText("inv_no", invNo), false);
						}
						
						sheetObjects[1].SetCellValue(Row,"inv_vat_amt","0");
						sheetObjects[1].SetCellValue(Row,"whld_tax_amt","0");
						
						sheet3_ShowSubSum(sheetObjects[2]);
						if  ( sheetObjects[2].RowCount()< 1 ) {
							removePage2(formObj);
						}
					}
				}else{
					sheetObjects[2].RemoveAll();
					
					ComSetObjValue(formObj.pay_vndr_seq, formObj.vndr_seq.value);
					ComSetObjValue(formObj.pay_vndr_nm, formObj.vndr_nm.value);
					doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				}
				break;
		}
	}
	/**
	 * sheet3 OnSearchEnd Event 처리
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg == "" ) {
			var chkRows=sheetObjects[1].FindCheckedRow("chkbox");
			var arrChkRow=chkRows.split("|");		
			if(arrChkRow.length != sheetObjects[1].RowCount()){
				sheetObjects[1].SetHeaderCheck(0, 1, 0, 0);
			}
			
			sheet3_ShowSubSum(sheetObj);
		}
	}
	/**
	 * sheet1 에 checkbox 를 선택하면 Audit 된 내용을 sheet1 의 조회된 Data 를 이용하여 sheet2 에 조회.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function checkChargeForAudit(sheetObj, Row, Value) {
		var formObj=document.form;
		var sheetObj2=sheetObjects[1];
		if ( sheetObj.GetCellValue(Row, "chg_sts_cd") == "C"
			|| sheetObj.GetCellValue(Row, "chg_sts_cd") == "H"
			|| sheetObj.GetCellValue(Row, "chg_sts_cd") == "A") {
			if ( Value == "1" ) {
				if ( sheetObj.GetCellValue(Row, "inv_no") == "" ) {
					return;
				}
				var newRowIdx=sheetObj2.DataInsert(-1);
				sheetObj2.SetCellValue(newRowIdx, "inv_no",sheetObj.GetCellValue(Row, "inv_no"),0);
				sheetObj2.SetCellValue(newRowIdx, "agmt_no",sheetObj.GetCellValue(Row, "agmt_no"),0);
				sheetObj2.SetCellValue(newRowIdx, "lse_ctrt_no",sheetObj.GetCellValue(Row, "lse_ctrt_no"),0);
				sheetObj2.SetCellValue(newRowIdx, "cre_dt",sheetObj.GetCellValue(Row, "cre_dt"),0);
				sheetObj2.SetCellValue(newRowIdx, "cre_usr_id",sheetObj.GetCellValue(Row, "cre_usr_id"),0);
				sheetObj2.SetCellValue(newRowIdx, "issu_ofc_cd",usrOfcCd,0);//"장비주관부서";
				sheetObj2.SetCellValue(newRowIdx, "lstm_cd",sheetObj.GetCellValue(Row, "lstm_cd"),0);
				sheetObj2.SetCellValue(newRowIdx, "agmt_no",sheetObj.GetCellValue(Row, "agmt_no"),0);
				sheetObj2.SetCellValue(newRowIdx, "pay_rntl_cost_amt",sheetObj.GetCellValue(Row, "pay_rntl_cost_amt"),0);
				sheetObj2.SetCellValue(newRowIdx, "com_ttl_chg_amt",sheetObj.GetCellValue(Row, "com_ttl_chg_amt"),0);
				sheetObj2.SetCellValue(newRowIdx, "cr_ttl_amt",sheetObj.GetCellValue(Row, "cr_ttl_amt"),0);
				sheetObj2.SetCellValue(newRowIdx, "inv_ttl_chg_amt",sheetObj.GetCellValue(Row, "inv_ttl_chg_amt"),0);
				sheetObj2.SetCellValue(newRowIdx, "agmt_cty_cd",sheetObj.GetCellValue(Row, "agmt_cty_cd"),0);
				sheetObj2.SetCellValue(newRowIdx, "agmt_seq",sheetObj.GetCellValue(Row, "agmt_seq"),0);
				sheetObj2.SetCellValue(newRowIdx, "chg_seq",sheetObj.GetCellValue(Row, "chg_seq"),0);
				sheetObj2.SetCellValue(newRowIdx, "chg_sts_cd",sheetObj.GetCellValue(Row, "chg_sts_cd"),0);
				sheetObj2.SetCellValue(newRowIdx, "chg_seq",sheetObj.GetCellValue(Row, "chg_seq"),0);
				sheetObj2.SetCellValue(newRowIdx, "chg_sts_cd",sheetObj.GetCellValue(Row, "chg_sts_cd"),0);
				sheetObj2.SetCellValue(newRowIdx, "pdm_amt",sheetObj.GetCellValue(Row, "pdm_amt"),0);
				
				sheetObj2.SetCellValue(newRowIdx, "inv_vat_amt","0",0);	
				sheetObj2.SetCellValue(newRowIdx, "whld_tax_amt","0",0);	
				sheetObjects[1].ClearHeaderCheck();
			} else {
				var delRowIdx=sheetObj2.FindText("agmt_no", sheetObj.GetCellValue(Row, "agmt_no"));
				var invNo=sheetObj2.GetCellValue(delRowIdx, "inv_no");
				sheetObj2.RowDelete(delRowIdx, false);
				while ( sheetObjects[2].FindText("inv_no", invNo) != -1 ) {
					sheetObjects[2].RowDelete(sheetObjects[2].FindText("inv_no", invNo), false);
				}
				sheet3_ShowSubSum(sheetObjects[2]);
				if  ( sheetObjects[2].RowCount()< 1 ) {
					removePage2(formObj);
				}
			}
			sheet2_ShowSubSum(sheetObj2);
		}
	}
	/**
	 * sheet2 sub total 설정
	 * @param sheetObj
	 * @return
	 */
	function sheet2_ShowSubSum(sheetObj) {
		with(sheetObj) {
			HideSubSum("inv_no");
			ColumnSort();
			if(sheetObj.RowCount() > 1) {
				//ShowSubSum([{StdCol:"inv_no", SumCols:"9|10|11|12", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"inv_no=S.Total;usr_id=;cre_dt=;agmt_no=;lse_ctrt_no=;issu_ofc_cd=;lstm_cd="}]);
			}
			var aSubSumRows=FindSubSumRow("inv_no").split("|");
			for (var i=0; i < aSubSumRows.length - 1; i ++) {
				//RowMerge(aSubSumRows[i]) = true;
			}
			// Sum Line Font Bold 처리
			var sSumRow=FindSubSumRow();
			var arrSumRow=sSumRow.split("|");
			for ( var i=0 ; i < arrSumRow.length -1 ; i++ ) {
				SetMergeCell(arrSumRow[i], 2, 1, 7);
 				SetCellFont("FontBold", arrSumRow[i], "inv_no",1);
 				SetCellFont("FontBold", arrSumRow[i], "pay_rntl_cost_amt",1);
 				SetCellFont("FontBold", arrSumRow[i], "com_ttl_chg_amt",1);
 				SetCellFont("FontBold", arrSumRow[i], "cr_ttl_amt",1);
 				SetCellFont("FontBold", arrSumRow[i], "inv_ttl_chg_amt",1);
			}
		}
	}
	/**
	 * sheet3 total 설정
	 * 
	 * @param sheetObj
	 * @return
	 */
	function sheet3_ShowSubSum(sheetObj) {
		var formObj=document.form;
		with(sheetObj) {
			HideSubSum("ibflag");
			if ( sheetObj.RowCount()> 0 ) {
				var amt=parseFloat(sheetObj.ComputeSum("|10|"));
				var crAmt=parseFloat(sheetObj.ComputeSum("|11|"));
				ComSetObjValue(formObj.inv_amt, (amt + crAmt).toFixed(2));
				ComSetObjValue(formObj.cr_amt,  crAmt.toFixed(2));
				ComAddSeparator(form.inv_amt, "float");
				ComAddSeparator(form.cr_amt,  "float");
				ComSetObjValue(formObj.curr_cd,       "USD");
				ComSetObjValue(formObj.vndr_term_nm,  ComGetObjValue(formObj.gen_pay_term_cd));
				//ComSetObjValue(formObj.offc_cd,       "SELCOE"); //ComSetObjValue(formObj., usrOfcCd);
				// 로그인사용자ID로 Setting (2009.12.21 이유목수석 요청)
				ComSetObjValue(formObj.inv_ofc_cd,   usrOfcCd);
				ComSetObjValue(formObj.cost_ofc_cd,  usrOfcCd);
				if(sheetObj.ComputeSum("|16|") == "0") {
					ComSetObjValue(formObj.inv_vat_amt, "0.00")
					var allAmount = 0;
					var intAmount = 0;
					for(var i=0;i<sheetObjects[1].RowCount();i++) {
						if(sheetObjects[1].GetCellValue(i+1,"chkbox",0) == "0") {
							sheetObjects[1].SetCellValue(i+1,"inv_vat_amt","0");
							sheetObjects[1].SetCellFontColor(i+1, "inv_vat_amt","#000000") ;
						}else{
							/*intAmount = sheetObjects[1].GetCellValue(i+1,"inv_vat_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);*/
						}
					}
					
					for(var i=0;i<sheetObjects[1].RowCount();i++) {
						if(sheetObjects[1].GetCellValue(i+1,"chkbox",0) == "1") {
							intAmount = sheetObjects[1].GetCellValue(i+1,"inv_vat_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);
						}
					}
					formObj.inv_vat_amt.value = allAmount.toFixed(2);
					
				}else{
					ComSetObjValue(formObj.inv_vat_amt, sheetObj.ComputeSum("|16|"))
				}
				
				if(sheetObj.ComputeSum("|17|") == "0") {
					ComSetObjValue(formObj.whld_tax_amt, "0.00")
					var allAmount = 0;
					var intAmount = 0;
					for(var i=0;i<sheetObjects[1].RowCount();i++) {
						if(sheetObjects[1].GetCellValue(i+1,"chkbox",0) == "0") {
							sheetObjects[1].SetCellValue(i+1,"whld_tax_amt","0");
							sheetObjects[1].SetCellFontColor(i+1, "whld_tax_amt","#000000") ;
						}else{
							/*intAmount = sheetObjects[1].GetCellValue(i+1,"whld_tax_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);*/
						}
					}
					
					for(var i=0;i<sheetObjects[1].RowCount();i++) {
						if(sheetObjects[1].GetCellValue(i+1,"chkbox",0) == "1") {
							intAmount = sheetObjects[1].GetCellValue(i+1,"whld_tax_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);
						}
					}
					
					formObj.whld_tax_amt.value = allAmount.toFixed(2);
				}else{
					ComSetObjValue(formObj.whld_tax_amt, sheetObj.ComputeSum("|17|"))
				}
				
				if(sheetObj.ComputeSum("|18|") == "0") {
					ComSetObjValue(formObj.inv_ttl_amt, "0.00")
				}else{
					ComSetObjValue(formObj.inv_ttl_amt, sheetObj.ComputeSum("|18|"))
				}
				
				formObj.inv_ttl_amt.value = 	parseFloat(ComReplaceStr(isGetNull(formObj.inv_amt.value),",","")) + 
														parseFloat(ComReplaceStr(isGetNull(formObj.inv_vat_amt.value),",","")) - 
														parseFloat(ComReplaceStr(isGetNull(formObj.whld_tax_amt.value),",",""));
				
				formObj.inv_ttl_amt.value = ComAddComma((Math.round(formObj.inv_ttl_amt.value * 100)/100).toFixed(2));
				
			}
			//ShowSubSum([{StdCol:"ibflag", SumCols:"10|11", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"inv_no=Total;vvd=;acct_cd=;cost_nm=;agmt_no=;lse_ctrt_no=;lse_pay_chg_tp_cd=;cntr_tpsz_cd="}]);
			ReNumberSeq();
			// Sum Line Font Bold 처리
			var sSumRow=FindSubSumRow();
			var arrSumRow=sSumRow.split("|");
			for ( var i=0 ; i < arrSumRow.length -1 ; i++ ) {
				SetMergeCell(arrSumRow[i], 2, 1, 8);
 				SetCellFont("FontBold", arrSumRow[i], "inv_no",1);
 				SetCellFont("FontBold", arrSumRow[i], "ttl_cost_amt",1);
 				SetCellFont("FontBold", arrSumRow[i], "cr_amt",1);
			}
		}
	}
	/**
	 * Pop-up Open
	 * 
	 * @param type
	 * @param Row
	 * @param Col
	 * @param SheetIdx
	 * @return
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.chg_cost_yrmon) == "" ) {
				ComShowCodeMessage("LSE01098");
				return;
			}
			if ( ComGetObjValue(formObj.vndr_seq) == "" ) {
				ComShowCodeMessage("LSE01044");
				ComSetFocus(formObj.vndr_seq);
				return;
			}
			
			ComOpenPopup('/opuscntr/EES_LSE_0008.do?chg_cost_yrmon='+ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-","")+ "&vndr_seq="+ComGetObjValue(formObj.vndr_seq), 820, 430, 'setPopData_InvoiceFileImport', '1,0', true);
		} else if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 710, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "3" ) {
			var invNo="";
			var chgSeq="";
			var agmtCtyCd="";
			var agmtSeq="";
			if ( sheetObj.RowCount()< 1) {
				ComShowCodeMessage("LSE01119");
				return;
			}
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if ( sheetObj.GetCellValue(i, "chg_seq") != "" ) {
					if ( chgSeq == "" ) {
						invNo=sheetObj.GetCellValue(i, "inv_no");
						chgSeq=sheetObj.GetCellValue(i, "chg_seq");
						agmtCtyCd=sheetObj.GetCellValue(i, "agmt_cty_cd");
						agmtSeq=sheetObj.GetCellValue(i, "agmt_seq");
					} else {
						invNo=invNo     + "|" + sheetObj.GetCellValue(i, "inv_no");
						chgSeq=chgSeq    + "|" + sheetObj.GetCellValue(i, "chg_seq");
						agmtCtyCd=agmtCtyCd + "|" + sheetObj.GetCellValue(i, "agmt_cty_cd");
						agmtSeq=agmtSeq   + "|" + sheetObj.GetCellValue(i, "agmt_seq");
					}
				}
			}
			var sParam="?chg_cost_yrmon="+ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-","");
			sParam=sParam + "&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			sParam=sParam + "&vndr_nm="+ComGetObjValue(formObj.vndr_nm);
			sParam=sParam + "&inv_no="+invNo;
			sParam=sParam + "&chg_seq="+chgSeq;
			sParam=sParam + "&agmt_cty_cd="+agmtCtyCd;
			sParam=sParam + "&agmt_seq="+agmtSeq;
			ComOpenPopup('/opuscntr/EES_LSE_0007_01.do'+sParam, 920, 600, 'setPopData_Audit', '1,0', true);
		} else if ( type == "4") {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1,1,1,1,1', true);
		} else if ( type == "5" ) {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 710, 470, 'setPopData_PayVendor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "10" ) {
			var formObj=document.form;
    		var sUrl='/opuscntr/COM_ENS_071.do';
			var iWidth=855;
			var iHeight=435;
			var sTargetObjList="ofc_cd:cost_ofc_cd";
			var sDisplay="1,0,1,1,1,1,1,1";
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}else if ( type == "11") {
			if ( sheetObj.RowCount()< 1) {
				ComShowCodeMessage("LSE01048");
				return;
			}
			ComOpenPopup('/opuscntr/EES_LSE_1003.do?sType=vaTax', 700, 600, '', '1,0', true);
		} else if ( type == "12" ) {
			if ( sheetObj.RowCount()< 1) {
				ComShowCodeMessage("LSE01048");
				return;
			}
			ComOpenPopup('/opuscntr/EES_LSE_1003.do?sType=whTax', 700, 600, '', '1,0', true);
		}
	}
	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_PayVendor(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.pay_vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.pay_vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
	 * Lessor Invoice File Import 완료 후 Pop-up Return Value 처리 부분
	 * 
	 * @return
	 */
	function setPopData_InvoiceFileImport() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		// 기존 check 된 sheet1 Checkbox Row Find
		setCheckedChgSeq(sheetObj);
		// 조회조건과 sheet1을 제외한 페이지 초기화 
		removePage(formObj);
		// sheet1 재조회
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
	/**
	 * Audit 완료 후 Pop-up Return Value 처리 부분
	 * 
	 * @return
	 */
	function setPopData_Audit() {
		var formObj=document.form;
		var sheetObj1=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		var sheetObj3=sheetObjects[2];
		// 기존 check 된 sheet1 Checkbox Row Find
		setCheckedChgSeq(sheetObj1);
		// 조회조건과 sheet1을 제외한 페이지 초기화 
		removePage(formObj);
		// sheet1 재조회
		doActionIBSheet(sheetObj1, formObj, IBSEARCH);
	}
	/**
	 * Currency Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][2]);
		}
	}
	/**
	 * BackEndJob 관련 Status='3, 4, 5' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		// 기존 BackEnd Job Type 설정(Charge Creation/Charge Delete/Invoice Creation)
		var backEndJobName="";
		ComSetObjValue(form.f_cmd, COMMAND03);
 		var sXml=sheetObj.GetSearchData("EES_LSE_0007GS.do", FormQueryString(form));
		if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
			var jobState=ComGetEtcData(sXml, "jb_sts_flg")
			if ( jobState == "3" || jobState == "4" || jobState == "5" ) {
				if ( backEndJobType == COMMAND01 ) {
					backEndJobName="Payable Charge Creation";
				} else if ( backEndJobType == COMMAND02 ) {
					backEndJobName="Payable Charge Delete";
				} else if ( backEndJobType == COMMAND06 ) {
					backEndJobName="Payable Invoice Creation";
				}
				// 재조회 시 Check 설정을 위하여 현재 Check 되어 있는 Row Index 를 구하여 Setting.
				setCheckedChgSeq(sheetObj);
				clearInterval(timer);	
				ComOpenWait(false);
				sheetObj.SetWaitImageVisible(1);
				sheetObj2.SetWaitImageVisible(1);
			}
			if (jobState == "3") {
				ComShowCodeMessage("LSE01134", backEndJobName);
				// Invoice Creation 이 성공할 경우 해당 Row 의 CheckBox 는 Edit 불가이므로 Check 되면 안됨. 따라서, 위에서 Setting 한 값을 초기화 함.
				if ( backEndJobType == COMMAND06 ) {
					ComSetObjValue(formObj.checkedRows,    "");
					//ComSetObjValue(formObj.checkedChgSeqs, "");
				}
			} else if (jobState == "4") {
				// JOB 상태가 '4' 일 경우 Server 에서 EventException 발생하므로 아래 로직은 수행안됨.
				ComShowCodeMessage("LSE01135", backEndJobName);
			} else if (jobState == "5") {
				// JOB 상태가 '5' 인 경우 조회용 JOB 이 아니므로 아래 로직은 수행안됨.
				ComShowCodeMessage("LSE01125");
			}
			if ( jobState == "3" || jobState == "4" || jobState == "5" ) {
				// 조회조건과 sheet1을 제외한 페이지 초기화 
				removePage(formObj);
				// sheet1 재조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		} else {
			// 조회 결과가 'F' 인 경우 (Exception 발생)
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			sheetObj2.SetWaitImageVisible(1);
			clearInterval(timer);
			sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		}
	}
	/**
	 * sheet2, sheet3 초기화 및 하단 Invoice Creation Form 초기화.
	 * 
	 * @param formObj
	 * @return
	 */
	function removePage(formObj) {
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		removePage2(formObj);
	}
	/**
	 * 하단 Invoice Creation Form 부분 초기화.
	 * 
	 * @param formObj
	 * @return
	 */
	function removePage2(formObj) {
		ComSetObjValue(formObj.vndr_term_nm, "");
		ComSetObjValue(formObj.inv_rcv_dt,   "");
		ComSetObjValue(formObj.inv_iss_dt,   "");
		//ComSetObjValue(formObj.inv_eff_dt,   "");
		ComSetObjValue(formObj.inv_ofc_cd,   "");
		ComSetObjValue(formObj.cost_ofc_cd,  "");
		ComSetObjValue(formObj.curr_cd,      "");
		ComSetObjValue(formObj.inv_amt,      "");
		ComSetObjValue(formObj.cr_amt,       "");
		ComSetObjValue(formObj.inv_rmk,      "");
		ComSetObjValue(formObj.pay_vndr_seq, "");
		ComSetObjValue(formObj.pay_vndr_nm, "");
		ComSetObjValue(formObj.inv_vat_amt, "");
		ComSetObjValue(formObj.whld_tax_amt, "");
		ComSetObjValue(formObj.inv_ttl_amt, "");
	}
	/**
	 * CheckBox 선택된 Row 의 Charge Sequence 및 Row Index 구하기.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function setCheckedChgSeq(sheetObj) {
		var formObj=document.form;
		var sRow=sheetObj.FindCheckedRow("chkbox");
		ComSetObjValue(formObj.checkedRows, sRow);
	}
	/**
	 * creating combo object(Spec No * Type/Size)
	 * 2016.03.11 - #9405 LSE Payment Type 추가 by 전지연
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "ALL", "ALL");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex(0 ,true);
	}  
	/* end of developer job */
