/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0001.js
*@FileTitle  : Lease Agreement Creation & Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	// Sheet Object Array
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	/* page setting : retrieve/new inserting/modification */
	var formActionType;
	/* Active status CNTR type/size code string : "|" */
	var orgCntrTpSzCd;
	/* Active status CNTR type/size code array */
	var arrOrgCntrTpSzCd;
	/* page setting code */
	var MODE_CREATE=1001;
	var MODE_MODIFY=1002;
	var MODE_SEARCH=1003;
	var MODE_VRSNUP=1004;
	/* column each tap */
	var t2TabColCnt=0;
	var t3TabColCnt=0;
	var t4TabColCnt=0;
	var t5TabColCnt=0;
	var SEARCH_ENABLE=true;
	var t5sheet1_leftHeaders = [{Text:"Rate/Day", Align:"Left"}];
	
	
	/* common global variables End *****************************************************/
	document.onclick=processButtonClick;
	/**
	 *  Event handler processing by button name
	 */
	function processButtonClick(){
		/**********/
		var sheetObject1=sheetObjects[0];   //t1sheet1. General
		var sheetObject2=sheetObjects[1];   //t2sheet1. Per-diem
		var sheetObject3=sheetObjects[2];   //t3sheet1. Handling Charges
		var sheetObject4=sheetObjects[3];   //t4sheet1. DOL/DOC
		var sheetObject5=sheetObjects[4];   //t4sheet2. Desc.
		var sheetObject6=sheetObjects[5];   //t5sheet1. Penalty
		var sheetObject7=sheetObjects[6];   //t6sheet1. DPP
		/*******************************************************/
		var formObj=document.form;
		//try {
			var srcObj=ComGetEvent();
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_New":
					 t1sheet1.RemoveAll();
					 t2sheet1.RemoveAll();
					 t3sheet1.RemoveAll();
					 t4sheet1.RemoveAll();
					 t5sheet1.RemoveAll();
					 t6sheet1.RemoveAll();

				    ComResetAll();
					/* retrieve Form setting */
					setFormEnable(MODE_SEARCH, formObj);
					/* General Tab - Container Spec No. Column Hidden handling */
					sheetObject1.SetColHidden("cntr_spec_no",1);
					/* Per-diem Tab - Location Column Hidden handling */
					sheetObject2.SetColHidden("loc_cd",0);
					tabObjects[0].SetSelectedIndex(0);
					/* Per-diem Tab - Container TP/SZ Column Hidden handling */
					for ( var i=4 ; i <= sheetObject2.LastCol(); i++ ) {
						sheetObject2.SetColHidden(i,1);
					}
					/* Handling Charges Tab - Container TP/SZ Column Hidden handling */
					for ( var i=5; i <= sheetObject3.LastCol(); i++ ) {
						sheetObject3.SetColHidden(i,1);
					}
					/* DOL/DOC Tab - Container TP/SZ Column Hidden handling */
					for ( var i=4 ; i <= sheetObject4.LastCol(); i++ ) {
						sheetObject4.SetColHidden(i,1);
					}

					/* Penalty Tab - Container TP/SZ Column Hidden handling */
					for ( var i = sheetObject6.FrozenCols ; i <= sheetObject6.LastCol ; i++ ) {
						sheetObject6.ColHidden(i) = true;
					}
						
					formObj.delYn1.value = "N";
					formObj.delYn2.value = "N";
					formObj.delYn3.value = "N";
					formObj.delYn4.value = "N";
					formObj.delYn6.value = "N";
					
					break;
				case "btn_Create":
					ComSetObjValue(formObj.agmt_seq, "");
					/* insert Form setting */
					setFormEnable(MODE_CREATE, formObj);
					break;
				case "btn_Save":
					if ( ComIsBtnEnable(srcName) ) {
						var vSaveMsgCode="";
						if ( formActionType == MODE_CREATE ) {
							vSaveMsgCode="COM12147";
						} else if ( formActionType == MODE_MODIFY ) {
							vSaveMsgCode="COM12154";
						}
						/* confirm window */
						if ( ComShowCodeConfirm(vSaveMsgCode, "Lease Agreement") ) {
							doActionIBSheet(sheetObject1, formObj, IBSAVE);
						}
					}
					break;
				case "btn_VersionUp":
					if ( ComIsBtnEnable(srcName) ) {
						if ( ComShowCodeConfirm("LSE01018") ) {
							openPopupPage("4");
						}
					}
					break;
				case "btns_search1":		// Agreement Pop-up
					if ( srcObj.style.filter == "" ) {
						openPopupPage("1");
					}
					break;
				case "btns_search2":		// Lessor(Service Provider) Pop-up
					if ( srcObj.style.filter == "" ) {
						openPopupPage("2");
					}
					break;
				case "btns_search3":		// Currency Pop-up
					openPopupPage("3");
					break;
				case "btns_calendar1":		// Effective Date (FromTo)
					if ( srcObj.style.filter == "" ) {
						if ( formObj.eff_dt.className == "input2" ) {
							var cal=new ComCalendar();
							cal.setEndFunction('setDuration');
			                cal.select(formObj.exp_dt, 'yyyy-MM-dd');
						} else {
							var cal=new ComCalendarFromTo();
							ComSetObjValue(formObj.f_cmd, "0");
							cal.setEndFunction('setDuration');
							cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
						}
					}
					break;
				case "btns_calendar2":		// Agmt Date
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
		                cal.select(formObj.agmt_dt, 'yyyy-MM-dd');
					}
					break;
				case "btns_calendar3":		// Build Up Date
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
		                cal.select(formObj.bld_up_dt, 'yyyy-MM-dd');
					}
					break;
				case "btns_calendar4":		// Build Down Period
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendar();
		                cal.select(formObj.bld_dwn_end_dt, 'yyyy-MM-dd');	
		                cal.setEndFunction('setAgmtChgVal');
					}
					break;
				case "btn_t1RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBINSERT);
					}
					break;
				case "btn_t1RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 						sheetObject1.CheckAll("del_chk",0);
 						formObj.delYn1.value = "Y";
 					}
					break;
				case "btn_t1LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						 
						if(formObj.delYn1.value == "Y") {
							ComShowCodeMessage("LSE01164");
						}else{
							doActionIBSheet(sheetObject1, formObj, IBLOADEXCEL);
						}
					}
					break;
				case "btn_t1DownExcel":
					if (ComIsBtnEnable(srcName) ) {
						
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
						}
						
					}
					break;
				case "btn_t2RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBINSERT);
					}
					break;
				case "btn_t2RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject2, "del_chk");
 						sheetObject2.CheckAll("del_chk",0);
 						formObj.delYn2.value = "Y";
 					}
					break;
				case "btn_t2LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(formObj.delYn2.value == "Y") {
							ComShowCodeMessage("LSE01164");
						}else{
							doActionIBSheet(sheetObject2, formObj, IBLOADEXCEL);
						}
					}
					break;
				case "btn_t2DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject2, formObj, IBDOWNEXCEL);
						}
					}
					break;
				case "btn_t3RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBINSERT);
					}
					break;
				case "btn_t3RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
						ComRowHideDelete(sheetObject3, "del_chk");
 						sheetObject3.CheckAll("del_chk",0);
 						formObj.delYn3.value = "Y";
 					}
					break;
				case "btn_t3LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(formObj.delYn3.value == "Y") {
							ComShowCodeMessage("LSE01164");
						}else{
							doActionIBSheet(sheetObject3, formObj, IBLOADEXCEL);
						}
					}
					break;
				case "btn_t3DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(sheetObject3.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject3, formObj, IBDOWNEXCEL);
						}
					}
					break;
				case "btn_t4RowAdd":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBINSERT);
					}
					break;
				case "btn_t4RowDelete":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject4, "del_chk");
 						sheetObject4.CheckAll("del_chk",0);
 						formObj.delYn4.value = "Y";
 					}
					
					break;
				case "btn_t4LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(formObj.delYn4.value == "Y") {
							ComShowCodeMessage("LSE01164");
						}else{
							doActionIBSheet(sheetObject4, formObj, IBLOADEXCEL);
						}
					}
					break;
				case "btn_t4DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(sheetObject4.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
						}
					}
					break;
				case "btn_t4RowAdd2":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject5, formObj, IBINSERT);
					}
					break;
				case "btn_t4RowDelete2":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject5, "del_chk");
 						sheetObject5.CheckAll("del_chk",0);
 						delYn42 = true;
 					}
					break;
				case "btn_t6RowAdd2":
					if ( ComIsBtnEnable(srcName) ) {
						if(formObj.agmt_seq.value=="") {
							ComShowCodeMessage("LSE10014");
						} else {
							doActionIBSheet(sheetObject7, formObj, IBINSERT);
						}											
					}
					break;
				case "btn_t6RowDelete2":
					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject7, "del_chk");
 						sheetObject5.CheckAll("del_chk",0);
 						formObj.delYn6.value = "Y";
 					}
					break;
				case "btn_t6LoadExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(formObj.agmt_seq.value=="") {
							ComShowCodeMessage("LSE10014");
						} else {
							if(formObj.delYn6.value == "Y") {
								ComShowCodeMessage("LSE01164");
							}else{
								doActionIBSheet(sheetObject7, formObj, IBLOADEXCEL);
							}							
						}
					}
					break;
				case "btn_t6DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						if(sheetObject7.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							doActionIBSheet(sheetObject7, formObj, IBDOWNEXCEL);
						}
					}
					break;
			} // end switch
		//} catch(e) {
		//	if( e == "[object Error]") {
		//		ComShowMessage(OBJECT_ERROR);
		//	} else {
		//		ComShowMessage(e);
		//	}
		//}
	}
	/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBTab Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
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
		orgCntrTpSzCd=ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd=orgCntrTpSzCd.split("|");
		/* IBTab init */
		for ( var i=0 ; i < tabObjects.length ; i++ ) {
			initTab(tabObjects[i], i+1);
			tabObjects[i].SetSelectedIndex(0);
		}
		/* IBSheet init */
		for ( var j=0 ; j < sheetObjects.length ; j++ ) {
			ComConfigSheet(sheetObjects[j]);
			initSheet(sheetObjects[j], j+1);
			ComEndConfigSheet(sheetObjects[j]);
		}
		resizeSheet();
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	        
	    }
		
//		getLseIbComboList(formObj.s_payment_tp, s_payment_tpCode, s_payment_tpText, 'ALL');
		
		
		/* Axon Control Setting*/
		initControl();
		/* Form Field GetEnable()/Disable Setting*/
		setFormEnable(MODE_SEARCH, formObj);
		t1sheet1_OnLoadFinish(sheetObjects[0]);
		
		formObj.delYn1.value = "N";
		formObj.delYn2.value = "N";
		formObj.delYn3.value = "N";
		formObj.delYn4.value = "N";
		formObj.delYn6.value = "N";
		
	}
  	/* Axon event handling Start ****************************************************************************/
  	function initControl() {
  		var formObj=document.form;
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur',formObj); 
  		axon_event.addListenerForm('blur', 		'obj_blur',		formObj); 
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); 
//  	axon_event.addListenerFormat('keypress','obj_keypress',	formObj); 
//		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',	'obj_change',	formObj); 
		axon_event.addListenerForm('click',		'obj_click',	formObj); 
  	}
  	// 2. event handling function -- Start
  	/**
	 * handling Location blur event
	 */
	function obj_blur() {
		var obj=ComGetEvent();
  	    switch(ComGetEvent("name")){
	        case "agmt_seq":
	        	/* checking number */
	            //if ( !ComChkObjValid(obj, true, false, false) ) {
	            //	ComSetObjValue(obj, "");
	    		//}
	            break;
	        case "vndr_seq":
	            /* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        case "agmt_chg_val":
	        	var sheetObject6=sheetObjects[5];   //t5sheet1. Penalty
	        	if(form.agmt_chg_val.value != "") {	        		
	        		for ( var colIdx=1 ; colIdx <= sheetObject6.LastCol(); colIdx++ ) {
						if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {			
						}else{
							sheetObject6.SetCellValue(1,colIdx,"0");
						}
					}
	        	}else{
	        		for ( var colIdx=1 ; colIdx <= sheetObject6.LastCol(); colIdx++ ) {
						if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {			
						}else{
							sheetObject6.SetCellValue(1,colIdx,"");
						}
					}
	        	}
	        	break;
	        default:
	            /* checking Validation */
	            ComChkObjValid(obj);
	        	break;
	    }
  	}
	/**
	 * handling event in case of focus
	 */
	function obj_focus(){
		var obj=ComGetEvent();
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    /* deleting data unit separator */
//		    ComClearSeparator(ComGetEvent());
		}
		
		switch(ComGetEvent("name")){	
			case "exp_dt":
	    	case "bld_dwn_end_dt":
	    		setAgmtChgVal();
				break;
			default:
				break;
		}
	}
	/**
	 * Handling in case of HTML Control Value change.
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "agmt_seq":
	    			ComSetObjValue(formObj.agmt_ver_seq, "");
	    			if ( SEARCH_ENABLE ) {
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    			}
					break;
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
				   	break;
	    		case "curr_cd":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;
	    		case "eff_dt":    			
	    			setDuration();	    			
	    			break;
	    		case "exp_dt":			
	    			setDuration();
	    			setAgmtChgVal();
	    			break;
	    		case "agmt_chg_val":
	    			sheetObjects[5].SetCellValue(1, "agmt_chg_val",ComGetObjValue(formObj.agmt_chg_val));
	    			break;
		    	case "bld_dwn_end_dt":
		    		setAgmtChgVal();
					break;
			}
	    }else{
	    	if(ComGetEvent("name") == "agmt_seq") {
	    		var sheetObject1=sheetObjects[0];   //t1sheet1. General
	    		var sheetObject2=sheetObjects[1];   //t2sheet1. Per-diem
	    		var sheetObject3=sheetObjects[2];   //t3sheet1. Handling Charges
	    		var sheetObject4=sheetObjects[3];   //t4sheet1. DOL/DOC
	    		var sheetObject5=sheetObjects[4];   //t4sheet2. Desc.
	    		var sheetObject6=sheetObjects[5];   //t5sheet1. Penalty
	    		var sheetObject7=sheetObjects[6];   //t6sheet1. DPP
	    		
	    		t1sheet1.RemoveAll();
				t2sheet1.RemoveAll();
				t3sheet1.RemoveAll();
				t4sheet1.RemoveAll();
				t5sheet1.RemoveAll();
				t6sheet1.RemoveAll();

				ComResetAll();
				/* retrieve Form setting */
				setFormEnable(MODE_SEARCH, formObj);
				/* General Tab - Container Spec No. Column Hidden handling */
				sheetObject1.SetColHidden("cntr_spec_no",1);
				/* Per-diem Tab - Location Column Hidden handling */
				sheetObject2.SetColHidden("loc_cd",0);
				tabObjects[0].SetSelectedIndex(0);
				/* Per-diem Tab - Container TP/SZ Column Hidden handling */
				for ( var i=4 ; i <= sheetObject2.LastCol(); i++ ) {
					sheetObject2.SetColHidden(i,1);
				}
				/* Handling Charges Tab - Container TP/SZ Column Hidden handling */
				for ( var i=5; i <= sheetObject3.LastCol(); i++ ) {
					sheetObject3.SetColHidden(i,1);
				}
				/* DOL/DOC Tab - Container TP/SZ Column Hidden handling */
				for ( var i=4 ; i <= sheetObject4.LastCol(); i++ ) {
					sheetObject4.SetColHidden(i,1);
				}

				/* Penalty Tab - Container TP/SZ Column Hidden handling */
				for ( var i = sheetObject6.FrozenCols ; i <= sheetObject6.LastCol ; i++ ) {
					sheetObject6.ColHidden(i) = true;
				}
	    	} else if(ComGetEvent("name") == "eff_dt" || ComGetEvent("name") == "exp_dt"){
	    		ComSetObjValue(formObj.dt_drtn, "0");
	    	}
	    }
	}
	/**
	 * Handling in case of HTML Control Value change.
	 */
	function obj_click(){
		var obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
			case "dpp_tp_cd":
				with(sheetObjects[6]) {
	    			if ( ComGetObjValue(obj) == "Y" ) {
	    				/* DPP Coverage== 'Y', retrieve move -> data retrieve */
	    				if ( formActionType == MODE_MODIFY ) {
	    					doActionIBSheet(sheetObjects[6], formObj, IBSEARCH);
	    				}
	    				/* DPP Tab ensable */
	    				//tabObjects[0].TabEnable(5)=true;
	    				 tabObjects[0].SetTabDisable(5, false); 
	    			} else {
						/* DPP Tab disable */
	    				tabObjects[0].SetTabDisable(5, true);
						//tabObjects[0].TabEnable(5)=false;
	    				/* DPP Coverage == 'N' -> data delete handling */
						for ( var i=HeaderRows(); i <= LastRow(); i++ ) {
							SetRowStatus(i,"D");
						}
	    			}
	    			tabObjects[0].SetSelectedIndex(0);
				}
    			break;
		}
	 }
	/**
	 * HTML Control handling event in case of Key-Press.
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
//	        	if ( obj.name == "lse_ctrt_no" ) {
//	        		ComKeyOnlyAlphabet("num","45|95");
//	        	//} else if ( obj.name == "ref_no" ) {
//	        	//	ComDebug(event.keyCode);
//	        	//	ComKeyOnlyAlphabet("num","8|32|44|45|46|95");
//	        	} else {
//	        		ComKeyOnlyAlphabet();
//	        	}
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        default:
//        		ComKeyOnlyNumber(obj);
//	        	break;
//	    }
//  	}
  	/**
  	 * HTML Control handling event in case of Key-Up.
  	 */
//  	function obj_keyup() {
//  		var obj=event.srcElement;
//  		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "agmt_seq":
//  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
// 			case "vndr_seq":
//  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
//  					ComSetObjValue(formObj.vndr_nm,"");
//  				} else {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
// 			default:
//  				ComKeyEnter('LengthNextFocus');
//  				break;
//  		}
//  	}
  	/**
   	 * HTML Control handling event in case of Key-Down.
   	 */
//  	function obj_keydown() {
//  		var obj=event.srcElement;
//  		var vKeyCode=event.keyCode;
//  		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//  			case "agmt_seq":
//		  		if ( vKeyCode == 13 ) {
//		  			ComSetObjValue(formObj.agmt_ver_seq, "");
//		  			SEARCH_ENABLE=false;
//		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//		  			SEARCH_ENABLE=true;
//		  		}
//		  		break;
//  			case "lse_vndr_url":
//  				// korean inserting prevention
//        		if ( event.keyCode == "229" ) {
//        			event.returnValue=false;
//        			return true;
//        		}
//        		break;
//  			case "agmt_rmk":
//  				// korean inserting prevention
//        		if ( event.keyCode == "229" ) {
//        			event.returnValue=false;
//        			return true;
//        		}
//  				if ( ComGetLenByByte(obj) > 999) {
//	  				ComShowCodeMessage("LSE01021");
//	  				return false;
//	  			}
//	  			break;
//  		}
//  	}
  	// 2. event handling function -- End
  	/* Axon event handling End ****************************************************************************/
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
			    with(sheetObj){		       
				      var HeadTitle1="||TP/SZ|Spec No.|Qty|REPL Value|PUR OPT Price|PUR OPT Period|Gate In|Gate Out|Remarks||";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				             {Type:"Popup",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"repl_value",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pur_price",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pur_period",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"gate_in",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"gate_out",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"gen_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"" }];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      //SetSheetHeight(230);
				      ComResizeSheet(sheetObj);
				      SetColHidden("cntr_spec_no",1);
				      SetColProperty(0 ,"eq_loc_tp_cd" , {DefaultValue:"SC"});
				      //SetColProperty(0,"gen_rmk",{AcceptKeys:"E|N"});
		      }
			break;
			case "t2sheet1":      // t2sheet1 init
			    with(sheetObj){		       
				      var HeadTitle1="||Level|Place|No. of Box|"+orgCntrTpSzCd;
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, FrozenCol:4};
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				             {Type:"Combo",    		Hidden:1, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
				             {Type:"PopupEdit", 		Hidden:1, Width:105,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"agmt_chg_val",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 } ];
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					      		cols.push({Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
					    	}
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0, 'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
				      SetSheetHeight(230);
//				      SetExtendLastCol(0);
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  SetColHidden('cntr'+i+1+'_n1_amt',1);
				      }	
		           }
			 break;
			case "t3sheet1":      // t3sheet1 init
			    with(sheetObj){		       
				      var HeadTitle1="|||Level|Place";
				      var HeadTitle2="|||Level|Place";
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  HeadTitle1=HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
				    	  HeadTitle2=HeadTitle2 + "|HDL ON|HDL OFF";
				      }
				      t3TabColCnt=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, FrozenCol:4 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val" },
				             {Type:"Combo",    		Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
				             {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  cols.push({Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
				    	  cols.push({Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n2_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
				      }
				      			 
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0,'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
				      SetSheetHeight(230);
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					     SetColHidden("cntr"+i+1+"_n1_amt",1);
					     SetColHidden("cntr"+i+1+"_n2_amt",1);
				      }	
		            }
				break;
			case "t4sheet1":      // t4sheet1 init
			    with(sheetObj){		       
				      var HeadTitle1="||Level|Place";
				      var HeadTitle2="||Level|Place";
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					      HeadTitle1=HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
					      HeadTitle2=HeadTitle2 + "|DOL |DOC ";
				      }
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, SizeMode:2 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
				             {Type:"Combo",    		Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:2 },
				             {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  cols.push({Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_chg_val",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
				      	  cols.push({Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
				      }
				      
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0,'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
				      SetSheetHeight(170);
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					      SetColHidden("cntr"+i+1+"_chg_val",1);
					      SetColHidden("cntr"+i+1+"_n1_amt",1);
				      }	
		            }
				break;
			case "t4sheet2":      // t4sheet2 init
			    with(sheetObj){
				      var HeadTitle1="||LOC|Depot|Address|E-mail|PIC|Contact No.|Turn in Ref. No.";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				             {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"dpt_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:0,   SaveName:"addr_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"lse_pson_ctrt_eml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pson_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_no_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"turn_ref_no_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(130);
				      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		            }
				break;
			case "t5sheet1":      // t5sheet1 init
			    with(sheetObj){		    
				      var HeadTitle1="TP/SZ|"+orgCntrTpSzCd+"||||";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"TP/SZ" } ];
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				            	cols.push({Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
				      }
				      cols.push({Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" });
				      cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"loc_cd" });
				      cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val" });
				      cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"eq_loc_tp_cd" });
				      	 
				      InitColumns(cols);
				      InitHeadColumn(t5sheet1_leftHeaders,sheetObj);
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  SetColHidden("cntr"+i+1+"_n1_amt",1);
				      }	
				      SetCountPosition(0);
				      SetSheetHeight(200);
				      SetColProperty(0 ,"eq_loc_tp_cd" , {DefaultValue:"SC"});
		      }
				break;
             case "t6sheet1":      // t6sheet1 init
            	    with(sheetObj){                 
		               var HeadTitle1="|||TP/SZ|Level|Place|DPP|DPP|DPP|DPP";
		               var HeadTitle2="|||TP/SZ|Level|Place|Free Days|Coverage Amt|Lump Sum Rate|Daily Rate";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },		
		                            {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_rntl_chg_tp_cd",  KeyField:0 },
		                      {Type:"Combo",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Combo",    	Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
		                      {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Int",       Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_dys",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:"n1st_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                      {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                      {Type:"Float",     Hidden:0,  Width:170,  Align:"Right",   ColMerge:1,   SaveName:"n2nd_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
		               
		               InitColumns(cols);
		               SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		               SetColProperty(0, 'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
		               SetEditable(1);
		               SetSheetHeight(240);
                     }
                 break;
         }
     }
		
	
	function DelLastDelim(str) {
		// 마지막에 &를 없애기 위함
		if (str != "") {
			str=str.substr(0, str.length - 1);
		}
		return str;
	}
	
	function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
        	if(i == 3 || i==4) {
        	}else{
            	ComResizeSheet(sheetObjects[i]);
        	}
        }
    }
     /**
      * Tab setting
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                    var cnt=0 ;
					InsertItem( "General", "");
					InsertItem( "Per Diem", "");
					InsertItem( "Handling Charge", "");
					InsertItem( "DOL/DOC", "");
					InsertItem( "Penalty", "");
					InsertItem( "DPP", "");
                 }
                 break;
         }
     }
	function initCombo(comboObj, comboNo) {
		
		switch(comboObj.options.id) {
			//lstm_cd
			case "combo1":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetEditable(0);
					SetUseAutoComplete(1);
				}
		       	break;
		    //cntr_dpc_lvl_cd
			case "combo2":
				with(comboObj) {
					SetDropHeight(250);
					SetEditable(0);
					SetMultiSelect(0);
					SetUseAutoComplete(1);
				}
		       	break;
		    //dpc_val_flg
			case "combo3":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetUseAutoComplete(1);
				}
	        	break;
	        //lse_pay_tp_cd
			 case "lse_pay_tp_cd": 
				   with (comboObj) { 
						SetColAlign(0, "center");
						SetColAlign(1, "left");
						SetColWidth(0, "30");
						SetColWidth(1, "200");
						SetEditable(0);
					    SetDropHeight(250);
					    SetMultiSelect(0);
						SetUseAutoComplete(1);
				   }   
			 break;
		}
	}
	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBCREATE:
			sheetObj.SetWaitImageVisible(0);
				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
		     	var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml != "" ) {
		        	var termNm=ComGetEtcData(sXml, "lease_term_full_nm");
		        	var termCd=ComGetEtcData(sXml, "lease_term_cd");
		        	var arrTermNm=termNm.split("|");
		        	var arrTermCd=termCd.split("|");
		        	var j=0;
		        	for ( var i=0 ; i < arrTermCd.length ; i++ ) {
		        		if ( OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
		        			comboObjects[0].InsertItem(i, arrTermCd[i]+"|"+arrTermNm[i], arrTermCd[i]);
		        		} else {
		        			if ( !(arrTermCd[i] == "OW"
		        				|| arrTermCd[i] == "LP"
		        				|| arrTermCd[i] == "OL"
		        				|| arrTermCd[i] == "LT"
		        				|| arrTermCd[i] == "ST"
		        				|| arrTermCd[i] == "OF") ) {
		        				comboObjects[0].InsertItem(j, arrTermCd[i]+"|"+arrTermNm[i], arrTermCd[i]);
		        				j++;
		        			}
		        		}
		        	}
		        	comboObjects[0].SetColWidth(0, "40");
		        	comboObjects[0].SetColWidth(1, "220");
	        		//comboObjects[0].Index = 1;
		        }
		        // DEPR Level Form Combo Item Setting 
				var strText="Daily|Monthly|Yearly";
        		var strCode="D|M|Y";
       		    LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
		        //DPC_VAL_FLG Level Form Combo Item Setting 
		    	var strText2="Manufacture Date|On-Hire Date";
        		var strCode2="N|Y";
        		LseComText2ComboItem(comboObjects[2], strText2, strCode2, "|");
        		//Container Type/Size Grid Combo Item Setting 
        		if ( orgCntrTpSzCd != "" ) {
       			sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:"|"+orgCntrTpSzCd, ComboCode:"|"+orgCntrTpSzCd} );
        		}
        		
        		/* Lease Payment Type Code Combo Item Setting 
        		   Blueprint(#9405) : LSE Accrual Function - Modification Request / Question & Expected Process*/
				ComSetObjValue(formObj.f_cmd, SEARCH09);
				var intgCdId = 'CD30090';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrCntrMtrlCdNm=sCntrMtrlCdNm.split("@");
					MakeComboObject(comboObjects[3], arrCntrMtrlCdNm, 1, 0);
				}
        		
        		ComSetFocus(formObj.agmt_seq);
        		sheetObj.SetWaitImageVisible(1);
		        break;
		        
			case IBSAVE:      
 			 	if ( validateForm(sheetObj,formObj,sAction) ) {
	            	if ( sheetObj.id == "t1sheet1") {
	            		/* Save Type Setting */
						if ( formActionType == MODE_CREATE ) {
							ComSetObjValue(formObj.f_cmd, ADD);
						} else if ( formActionType == MODE_MODIFY ) {
							ComSetObjValue(formObj.f_cmd, MODIFY);
						} else if ( formActionType == MODE_VRSNUP ) {
							ComSetObjValue(formObj.f_cmd, COMMAND01);
						}
	            		/* Term Value Setting */
						ComSetObjValue(formObj.lstm_cd, 		ComGetObjValue(comboObjects[0]));
						/* DEPR Level Value Setting */
						ComSetObjValue(formObj.cntr_dpc_lvl_cd, ComGetObjValue(comboObjects[1]));
						ComSetObjValue(formObj.dpc_val_flg,     ComGetObjValue(comboObjects[2]));
						/* Payment Type Code Setting*/
						ComSetObjValue(formObj.lse_pay_tp_cd,   ComGetObjValue(comboObjects[3]));
						/* InActive Flag Value Setting */
						if ( formObj.chk_agmt_act_flg.checked ) {
							ComSetObjValue(formObj.agmt_act_flg, "Y");
						} else {
							ComSetObjValue(formObj.agmt_act_flg, "N");
						}
						/* ICF Flag Value Setting */
						if ( formObj.chk_itchg_fee_flg.checked ) {
							ComSetObjValue(formObj.itchg_fee_flg, "Y");
						} else {
							ComSetObjValue(formObj.itchg_fee_flg, "N");
						}
						/* ICF Flag Value Setting */
						if ( formObj.chk_slb_flg.checked ) {
							ComSetObjValue(formObj.slb_flg, "Y");
						} else {
							ComSetObjValue(formObj.slb_flg, "N");
						}												
						var sParam=FormQueryString(formObj);
						if ( formActionType == MODE_CREATE
							|| formActionType == MODE_MODIFY ) {
							if (sheetObjects[0].IsDataModified()== true) {
								if ( validateForm(sheetObjects[0],formObj,sAction) ) {
									for(var i=1;i<=sheetObjects[0].RowCount();i++) {
										if(sheetObjects[0].GetCellValue(i, "loc_cd") == "") {
											return;
										}
									}									
									var sSheetParam=sheetObjects[0].GetSaveString();
									if (sSheetParam == "") {
										return;
									}
									sSheetParam=ComSetPrifix(sSheetParam, "t1sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							
							
							if (sheetObjects[1].IsDataModified()== true) {
								if ( ComGetObjValue(combo1) != "LT" ) {
									var allChgVal = "";
									for(var i=1;i<=sheetObjects[1].RowCount();i++) {
										if(allChgVal.indexOf(sheetObjects[1].GetCellValue(i,"agmt_chg_val")) > 0) {
											ComShowCodeMessage("LSE01060");
											return false;
										}
										allChgVal = allChgVal + "," + sheetObjects[1].GetCellValue(i,"agmt_chg_val");
		 							}								
								}
								if ( validateForm(sheetObjects[1],formObj,sAction) ) {
									if ( ComGetObjValue(combo1) == "LT" ) {
										for(var i=1;i<=sheetObjects[1].RowCount();i++) {
											if(sheetObjects[1].GetCellValue(i, "loc_cd") == "") {
												return;
											}
										}	
			 						} 
									
									var sSheetParam=sheetObjects[1].GetSaveString();
									if (sSheetParam == "") {
										return;
									}
									sSheetParam=ComSetPrifix(sSheetParam, "t2sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							
							
							if (sheetObjects[2].IsDataModified()== true) {
								if ( validateForm(sheetObjects[2],formObj,sAction) ) {
									for(var i=2;i<=sheetObjects[2].RowCount()+1;i++) {
										if(sheetObjects[2].GetCellValue(i, "loc_cd") == "") {
											return;
										}
									}									
									var sSheetParam=sheetObjects[2].GetSaveString();
									if (sSheetParam == "") {
										return;
									}
									sSheetParam=ComSetPrifix(sSheetParam, "t3sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							
							
							if (sheetObjects[3].IsDataModified()== true) {
								if ( validateForm(sheetObjects[3],formObj,sAction) ) {
									for(var i=2;i<=sheetObjects[3].RowCount();i++) {
										if(sheetObjects[3].GetCellValue(i, "loc_cd") == "") {
											return;
										}
									}
									var sSheetParam=sheetObjects[3].GetSaveString();
									if (sSheetParam == "") {
										return;
									}
									
									sSheetParam=ComSetPrifix(sSheetParam, "t4sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							
							
							if (sheetObjects[4].IsDataModified()== true) {
								if ( validateForm(sheetObjects[4],formObj,sAction) ) {
									for(var i=1;i<=sheetObjects[4].RowCount();i++) {
										if(sheetObjects[4].GetCellValue(i, "loc_cd") == "") {
											return;
										}
									}									
									var sSheetParam=sheetObjects[4].GetSaveString();
									if (sSheetParam == "") {
										return;
									}									
									sSheetParam=ComSetPrifix(sSheetParam, "t4sheet2_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							
							if ( sheetObjects[5].GetCellValue(1, "agmt_chg_val") != ComGetObjValue(formObj.agmt_chg_val) ) {
								sheetObjects[5].SetCellValue(1, "agmt_chg_val",ComGetObjValue(formObj.agmt_chg_val));
							}
							
							if (sheetObjects[5].IsDataModified()== true) {
								if ( validateForm(sheetObjects[5],formObj,sAction) ) {
									if ( formObj.bld_dwn_end_dt.className == "input1" ) {
											if ( ComTrim(ComGetObjValue(formObj.agmt_chg_val)) == "" || ComTrim(ComGetObjValue(formObj.bld_dwn_end_dt)) == "") {
											ComShowCodeMessage("LSE01043");
											if ( tabObjects[0].GetSelectedIndex()!= 4 ) {
												tabObjects[0].SetSelectedIndex(4);
											}
											ComSetFocus(formObj.bld_dwn_end_dt);
											return;
										}
									}
									
									/* Penalty new insert -> ibflag="I" setting, "loc_cd"="KRSEL" setting */
									if ( formActionType == MODE_CREATE ) {
										sheetObjects[5].SetRowStatus(sheetObjects[5].LastRow(),"I");
										sheetObjects[5].SetCellValue(1, "loc_cd",ConstantMgr.getBaseLocationCode());
									}else{
										sheetObjects[5].SetCellValue(1, "loc_cd",ConstantMgr.getBaseLocationCode());
									}
									
									var sSheetParam=sheetObjects[5].GetSaveString();
									sSheetParam=ComSetPrifix(sSheetParam, "t5sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
							
							if (sheetObjects[6].IsDataModified()== true) {
								if ( validateForm(sheetObjects[6],formObj,sAction) ) {
									for(var i=sheetObjects[6].RowCount();i>=1;i--) {
										if(sheetObjects[6].GetCellValue(i, "loc_cd") == "") {
											return;
										}
									}
									
									var sSheetParam=sheetObjects[6].GetSaveString();
									if (sSheetParam == "") {
										return;
									}
									sSheetParam=ComSetPrifix(sSheetParam, "t6sheet1_");
									sParam=sParam + "&" + sSheetParam;
								} else {
									return;
								}
							}
						}
						/* Save Action */
						ComOpenWait(true);
						var sXml=sheetObj.GetSaveData("EES_LSE_0001GS.do" , sParam);
						ComOpenWait(false);
						sheetObj.LoadSaveData(sXml);
						
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							/* Return Value Setting & Re-Search Action */
							if ( formActionType == MODE_CREATE ) {
								ComShowCodeMessage("COM12149", "Lease Agreement");
								/* New Agreement Sequence Value Setting */
								ComSetObjValue(formObj.agmt_seq, ComGetEtcData(sXml, "agmt_seq"));
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							} else if ( formActionType == MODE_MODIFY ) {
								ComShowCodeMessage("COM12156", "Lease Agreement");
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							} else if ( formActionType == MODE_VRSNUP ) {
								ComShowCodeMessage("COM12116", "Lease Agreement Version()-Up");
								/* New Agreement Version()Sequence Value Setting */
								ComSetObjValue(formObj.agmt_ver_seq, ComGetEtcData(sXml, "agmt_ver_seq"));
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							}
						}
	            	}
	            	document.form.delYn1.value = "N";
	            	document.form.delYn2.value = "N";
	            	document.form.delYn3.value = "N";
	            	document.form.delYn4.value = "N";
	            	document.form.delYn6.value = "N";
 			 	}
                break;
			case IBSEARCH:      //retrieve
				/* Org CNTR type/size code re-setting : Org CNTR type/size code data delete re-setting in case of Form Data setting  */
				ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "t6sheet1" ) {
						/* DPP Tab */
						ComSetObjValue(formObj.f_cmd, SEARCH01);
	            	} else {
	            		ComSetObjValue(formObj.f_cmd, SEARCH);
	            	}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("EES_LSE_0001GS.do" , FormQueryString(formObj));
					if ( sheetObj.id == "t6sheet1" ) {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						sheetObj.SetWaitImageVisible(1);
					} else {
						var arrXml=sXml.split("|$$|");
						if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
						var vLstmCd=ComGetEtcData(arrXml[0],"lstm_cd");
						var vBldDwnEndDt=ComGetEtcData(arrXml[0],"bld_dwn_end_dt");
						ComSetObjValue(formObj.bld_dwn_end_dt, vBldDwnEndDt);
						if ( vLstmCd != undefined ) {
							if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
								if ( vLstmCd == "OW" || vLstmCd == "LP" || vLstmCd == "OL"
								  || vLstmCd == "LT" || vLstmCd == "ST" || vLstmCd == "OF" ) {
									ComShowCodeMessage("LSE01040");
									ComResetAll();
									/* retrieve Form setting */
									if ( formActionType != MODE_SEARCH ) {
										setFormEnable(MODE_SEARCH, formObj);
									}
									ComOpenWait(false);
									return;
								}
							}
						}
						
						if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
						if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
						if (arrXml.length > 4) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
						if (arrXml.length > 5) sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
						if (arrXml.length > 6) sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
					}
					ComOpenWait(false);
					combo2.SetEnable(1);
					combo3.SetEnable(1);
					lse_pay_tp_cd.SetEnable(1);
					
					combo2.SetEditable(0);
					combo3.SetEditable(0);
					lse_pay_tp_cd.SetEditable(0);
				}
	            break;
			case IBSEARCH_ASYNC01:	//retrieve(Form Lessor No. inserting)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetNextFocus(formObj.vndr_seq);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							ComSetObjValue(formObj.vndr_seq, "");
 							ComSetObjValue(formObj.vndr_nm, "");
 							ComSetFocus(formObj.vndr_seq);
 						}
					} else {
						ComShowCodeMessage("LSE01019");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;
 			case IBSEARCH_ASYNC02:	//retrieve(Form Curr inserting)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
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
 			case IBINSERT:
 				switch (sheetObj.id) {
 					case "t1sheet1":
 						var Row=sheetObj.DataInsert(-1);
 						/*
 						 * General Data new inserting
 						 *  1. "LOC_CD" "KRSEL" inserting
 						 */
 						sheetObj.SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
 						sheetObj.SelectCell(Row, "cntr_tpsz_cd");
 						break;
 					case "t2sheet1":
 						var Row=sheetObj.DataInsert(-1);
 						/*
 						 * Per-diem Data new inserting
 						 */
						if ( ComGetObjValue(combo1) == "LT" ) {
 							sheetObj.SetCellValue(Row, "agmt_chg_val","1",0);
 							sheetObj.SelectCell(Row, "loc_cd");
 							if(sheetObj.FindText("loc_cd","ALL") < 0) {
 									sheetObj.SetCellValue(Row, "loc_cd", "ALL");
 							}else{
 	 							sheetObj.SetCellValue(Row, "loc_cd", "");
 	 						}
 							sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E|N" , InputCaseSensitive:1});
 						} else {
 							sheetObj.SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
 							if ( sheetObj.RowCount()== 1 ) {
 								sheetObj.SetCellValue(Row, "agmt_chg_val","1");
 								sheetObj.SetCellEditable(Row, "agmt_chg_val",0);
 							} else {
 								sheetObj.SelectCell(Row, "agmt_chg_val");
 							}
 						}
 						break;
 					case "t3sheet1":
 						var Row=sheetObj.DataInsert(-1);
 						sheetObj.SetCellValue(Row, "agmt_chg_val","1",0);
 						//sheetObj.SelectCell(Row, "loc_cd");
 						if(sheetObj.FindText("loc_cd","ALL") < 0) {
 							sheetObj.SetCellValue(Row, "loc_cd", "ALL");
 						}else{
 							sheetObj.SetCellValue(Row, "loc_cd", "");
 						}
 						sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E|N" , InputCaseSensitive:1});
 						break;
 					case "t4sheet1":
 						var Row=sheetObj.DataInsert(-1);
 						//sheetObj.SelectCell(Row, "loc_cd");
 						if(sheetObj.FindText("loc_cd","ALL") < 0) {
 							sheetObj.SetCellValue(Row, "loc_cd", "ALL");
 						}else{
 							sheetObj.SetCellValue(Row, "loc_cd", "");
 						}
 						sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E|N" , InputCaseSensitive:1});
 						break;
 					case "t4sheet2":
 						var Row=sheetObj.DataInsert(-1);
 						sheetObj.SelectCell(Row, "loc_cd");
 						break;
 					case "t6sheet1":
 						var Row=sheetObj.DataInsert(-1);
 						sheetObj.SetCellValue(Row, "loc_cd", "ALL");
 						break;
 				}
 				break;
 			case IBDOWNEXCEL:
 				with(sheetObj) {
 					var vSheetName=ComReplaceStr(tabObjects[0].GetTabTitle(tabObjects[0].GetSelectedIndex()),"/","_");
					if ( RowCount() < 1 ) {
						var row=DataInsert(0);
						SetRowHidden(row,1);
						Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false,SheetName:"vSheetName"});
						RowDelete(row, false);
					} else {
						switch (sheetObj.id) {
	 					case "t1sheet1":
	 						Down2Excel({Merge:true,TreeLevel:false,SheetName:"vSheetName",DownCols:"0|2|4|5|6|7|8|9|10"});
	 						break;
	 			        default:
	 						Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false,SheetName:"vSheetName",DownCols: makeHiddenSkipCol(sheetObj)});
	 						break;
						}
					}
 				}
 				break;
 			case IBLOADEXCEL:
 				with(sheetObj) {
 					ComOpenWait(true);
 					var vAppendStartRowIdx=0;
					if ( RowCount()== 0 ) {
						vAppendStartRowIdx=HeaderRows()
					} else {
						vAppendStartRowIdx=LastRow()+1;
					}
					
					
					switch (id) {
	 					case "t1sheet1":
	 						var vAppendFlag=LoadExcel({Append:1});
							break;
	 					case "t2sheet1":
	 						var vAppendFlag=LoadExcel({Append:1});
							/*if ( vAppendFlag ) {
								for ( var idx=LastRow(); idx >= vAppendStartRowIdx ; idx-- ) {
									if ( ComGetObjValue(combo1) == "LT" ) {
			 							sheetObj.SetCellValue(idx, "agmt_chg_val","1",0);
			 							checkDuplicateCol(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"));
			 							setAsyncData(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"), "2");
			 						} else {
			 							sheetObj.SetCellValue(idx, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
			 							checkDuplicateCol(sheetObj, idx, "agmt_chg_val", GetCellValue(idx,"agmt_chg_val"));
			 						}
								}
							}*/
							break;
	 					case "t3sheet1":
	 						var vAppendFlag=LoadExcel({Append:1});
							/*if ( vAppendFlag ) {
								for ( var idx=LastRow(); idx >= vAppendStartRowIdx ; idx-- ) {
		 							sheetObj.SetCellValue(idx, "agmt_chg_val","1",0);
		 							checkDuplicateCol(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"));
		 							setAsyncData(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"), "2");
								}
							}*/
							break;
	 					case "t4sheet1":
	 						var vAppendFlag=LoadExcel({Append:1});
							/*if ( vAppendFlag ) {
								for ( var idx=LastRow(); idx >= vAppendStartRowIdx ; idx-- ) {
									checkDuplicateCol(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"));
									setAsyncData(sheetObj, idx, "loc_cd", GetCellValue(idx,"loc_cd"), "2");
								}
							}*/
							break;
	 					case "t6sheet1":
	 						//t6sheet1.RemoveAll();
	 						var vAppendFlag=LoadExcel({Append:false});
							/*if ( vAppendFlag ) {
								for ( var idx=LastRow(); idx >= vAppendStartRowIdx ; idx-- ) {
									checkDuplicateCol(sheetObj, idx, "cntr_tpsz_cd", GetCellValue(idx,"cntr_tpsz_cd"));
								}
							}*/
							break;
					}
	 				ComOpenWait(false);
	 				switch (id) {
	 					case "t2sheet1":
	 					case "t3sheet1":
	 					case "t4sheet1":
							for ( var idx=LastRow(); idx >= vAppendStartRowIdx ; idx-- ) {
								if ( GetCellValue( idx, "loc_cd") == "" ) {
									ComShowCodeMessage("LSE01037");
									SelectCell(idx,"loc_cd");
									break;
								}
							}
	 						break;
	 				}
 				}
 				break;
		}
	}
	
	function t1sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg))return;
		if(result) {
			var sheet1RowCnt = sheetObjects[0].RowCount()+1;
			for ( var idx=1; idx <= sheetObjects[0].RowCount() ; idx++ ) {
				sheetObjects[0].SetCellValue(idx,"loc_cd",ConstantMgr.getBaseLocationCode(),0);
				checkDuplicateCol(sheetObjects[0], idx, "cntr_tpsz_cd", sheetObjects[0].GetCellValue(idx,"cntr_tpsz_cd"));
			}
			
			document.form.delYn1.value = "N";
		} 
	}
	
	
	function t2sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg))return;
		if(result) {
			for ( var idx=1; idx <= sheetObjects[1].RowCount() ; idx++ ) {
				if ( ComGetObjValue(combo1) == "LT" ) {
					sheetObjects[1].SetCellValue(idx, "agmt_chg_val","1",0);
				
					checkDuplicateCol(sheetObjects[1], idx, "loc_cd", sheetObjects[1].GetCellValue(idx,"loc_cd"));
					setAsyncData(sheetObjects[1], idx, "loc_cd", sheetObjects[1].GetCellValue(idx,"loc_cd"), "2");
				} else {
					sheetObjects[1].SetCellValue(idx, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
					checkDuplicateCol(sheetObjects[1], idx, "agmt_chg_val", sheetObjects[1].GetCellValue(idx,"agmt_chg_val"));
				}
			}
			
			document.form.delYn2.value = "N";
		} 
	}
	
	function t3sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg))return;
		if(result) {
			for ( var idx=2; idx <= sheetObjects[2].RowCount()+1 ; idx++ ) {
				sheetObjects[2].SetCellValue(idx, "agmt_chg_val","1",0);
				checkDuplicateCol(sheetObjects[2], idx, "loc_cd", sheetObjects[2].GetCellValue(idx,"loc_cd"));
				setAsyncData(sheetObjects[2], idx, "loc_cd", sheetObjects[2].GetCellValue(idx,"loc_cd"), "2");
			}
		} 
		
		document.form.delYn3.value = "N";
	}
	
	
	function t4sheet1_OnLoadExcel(sheetObj, result, msg) {
		
		if(isExceedMaxRow(msg))return;
		if(result) {
			for ( var idx=2; idx <= sheetObjects[3].RowCount()+1 ; idx++ ) {
				checkDuplicateCol(sheetObjects[3], idx, "loc_cd", sheetObjects[3].GetCellValue(idx,"loc_cd"));
				setAsyncData(sheetObjects[3], idx, "loc_cd", sheetObjects[3].GetCellValue(idx,"loc_cd"), "2");
			}
		} 
		
		document.form.delYn4.value = "N";
	}
	
	function t6sheet1_OnLoadExcel(sheetObj, result, code, msg) {
		if(isExceedMaxRow(msg))return;
		if(result) {
			for ( var idx=sheetObjects[6].RowCount()+1; idx > 1 ; idx-- ) {
				//checkDuplicateCol(sheetObjects[6], idx, "cntr_tpsz_cd", sheetObjects[6].GetCellValue(idx,"cntr_tpsz_cd"), sheetObjects[6].GetCellValue(idx,"loc_cd"));
			}
		} 
		document.form.delYn6.value = "N";
	}
	
	
	function t6sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		var formObj=document.form;
				
		//sheetObj.SelectCell(Row, "loc_cd");
		var orgSheetCntrTpSzCd = "";
		for ( var colIdx=1 ; colIdx <= sheetObjects[0].RowCount(); colIdx++ ) {
			if(sheetObjects[0].GetCellValue(colIdx,"cntr_tpsz_cd") != "") {
				orgSheetCntrTpSzCd = orgSheetCntrTpSzCd +"|"+sheetObjects[0].GetCellValue(colIdx,"cntr_tpsz_cd");
				//sheetObjects[6].SetColProperty(colIdx, "cntr_tpsz_cd", {ComboText:"|"+orgCntrTpSzCd, ComboCode:"|"+orgCntrTpSzCd} );
			}	
		}
		sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:orgSheetCntrTpSzCd, ComboCode:orgSheetCntrTpSzCd} );
	}
	
	
	/**
	 * Sheet OnPopuphandling event in case of Click.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t6sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				//openPopupPage("5", Row, Col, 6);
				if(slocTpCd == "AL") {
					openLcPopupPage("1", Row, Col, 6);
				}else if(slocTpCd == "CT") {
					openLcPopupPage("2", Row, Col, 6);
				}else if(slocTpCd == "ST") {
					openLcPopupPage("3", Row, Col, 6);
				}else if(slocTpCd == "CN") {
					openLcPopupPage("4", Row, Col, 6);
				}else if(slocTpCd == "RC") {
					openLcPopupPage("5", Row, Col, 6);
				}else if(slocTpCd == "LC") {
					openLcPopupPage("6", Row, Col, 6);
				}else if(slocTpCd == "EC") {
					openLcPopupPage("7", Row, Col, 6);
				}else if(slocTpCd == "SC") {
					openLcPopupPage("8", Row, Col, 6);
				}else if(slocTpCd == "LO") {
					openLcPopupPage("9", Row, Col, 6);
				}
				break;
			case "cntr_tpsz_cd":
				var formObj=document.form;
				if (sheetObj.ColSaveName(Col) != "cntr_tpsz_cd") return;
				var disPlayTpSz=new Array();
				var disPlayTab=new Array();
				
				var prefixValue="";
				var checkedList="";
				for(var x=1 ; x <= sheetObj.RowCount();x++){
					if(sheetObj.GetRowStatus(x) == "D") {
						ComShowCodeMessage("LSE01164");
						return;
					}
					checkedList=checkedList + (sheetObj.GetCellValue(x,"cntr_tpsz_cd") + "|");
				}
				
				checkedList=DelLastDelim(checkedList);
				var param="?checked=" + checkedList + "&returntitle=TP/SZ SELECTION&temp_value1=1&sheet_id=6&sheet_row="+Row;
				ComOpenPopup('EES_LSE_0001_POP.do' + param, 400, 413, 'getLse_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
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
	function t6sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				//checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
			case "eq_loc_tp_cd":
				if(sheetObj.GetCellValue(Row,Col) == "AL") {
					sheetObj.SetCellValue(Row,"loc_cd","ALL");
					sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E" , InputCaseSensitive:1});
				}else{
					sheetObj.SetCellValue(Row,"loc_cd","");
					if(sheetObj.GetCellValue(Row,Col) == "CT" || sheetObj.GetCellValue(Row,Col) == "ST" || sheetObj.GetCellValue(Row,Col) == "CN") {
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E" , InputCaseSensitive:1});
					}else{
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E|N" , InputCaseSensitive:1});
					}
				}
				break;
		}
 	}
	
	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	/**
	 * Lease Agreement Master/General Tab IBSheet Object Search-End Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
		var formObj=document.form;
		if ( ErrMsg == "" ) {
			/* page mode=modification mode */
			if ( formActionType != MODE_MODIFY ) {
				setFormEnable(MODE_MODIFY, formObj);
			}
			
			ComEtcDataToForm(formObj, sheetObj);
			/* InActive CheckBox Setting */
			if ( ComGetObjValue(formObj.agmt_act_flg) == "Y" ) {
				formObj.chk_agmt_act_flg.checked=true;
			} else {
				formObj.chk_agmt_act_flg.checked=false;
			}
			
			/* ICF Flag CheckBox Setting */
			if ( ComGetObjValue(formObj.itchg_fee_flg) == "Y" ) {
				formObj.chk_itchg_fee_flg.checked=true;
			} else {
				formObj.chk_itchg_fee_flg.checked=false;
			}

			/* SLB Flag CheckBox Setting */
			if ( ComGetObjValue(formObj.slb_flg) == "Y" ) {
				formObj.chk_slb_flg.checked=true;
			} else {
				formObj.chk_slb_flg.checked=false;
			}			
			
			comboObjects[0].SetSelectCode(ComGetObjValue(formObj.lstm_cd));
			comboObjects[1].SetSelectCode(ComGetObjValue(formObj.cntr_dpc_lvl_cd));
			comboObjects[2].SetSelectCode(ComGetObjValue(formObj.dpc_val_flg));
			comboObjects[3].SetSelectCode(ComGetObjValue(formObj.lse_pay_tp_cd));
			/* DPP Coverage == 'N' -> DPP Tab disable */
			if ( ComGetObjValue(formObj.dpp_tp_cd) == "Y" ) {
				//if (  tab1.SetTabDisable(5, false)) {
					 tab1.SetTabDisable(5, false);
				//}
			} else {
				//if ( tab1.SetTabDisable(5, true)) {
					 tab1.SetTabDisable(5, true);
				//}
			}
			
			/* Mask add */
			ComAddSeparator(form.eff_dt, "ymd");
			ComAddSeparator(form.exp_dt, "ymd");
			ComAddSeparator(form.agmt_dt, "ymd");
			ComAddSeparator(form.bld_up_dt, "ymd");
			/*comboObjects[1].SetBackColor("#000233");
			comboObjects[2].SetBackColor("#000233");
			comboObjects[1].SetFontColor("#FF0000");*/
			/* Duration calc */
			setDuration();
			/* Lease Term General Sheet Control */
			control_Spec_No(ComGetObjValue(combo1));
			sheetObj.RenderSheet(1);
			tabObjects[0].SetSelectedIndex(0);
			/* Effective Date GetEditable()setting */
			//ComDebug(ComGetObjValue(formObj.agmt_lst_ver_seq));
			//ComDebug(ComGetObjValue(formObj.agmt_ver_seq));
			if ( ComGetObjValue(formObj.agmt_lst_ver_seq) == ComGetObjValue(formObj.agmt_ver_seq) ) {
				if ( ComGetObjValue(formObj.agmt_lst_ver_seq) != "1" ) {
					if ( formObj.eff_dt.className != "input2" ) {
						ComEnableObject(formObj.eff_dt, true);
					}
				} else {
					if ( formObj.eff_dt.className != "input1" ) {
						LseComMndtForm(formObj,"eff_dt");
					}
					if ( formObj.btns_calendar1.style.filter != "" ) {
						ComEnableObject(formObj.btns_calendar1, true);
					}
				}
				if ( formObj.exp_dt.className != "input1" ) {
					LseComMndtForm(formObj,"exp_dt");
				}
				
				if(comboObjects[0].GetSelectCode() == "LT" || comboObjects[0].GetSelectCode() == "ST") {
					if ( formObj.dpc_rto.className != "input1" ) {
						LseComMndtForm(formObj,"dpc_rto");
					}
					
					if ( formObj.max_dpc_rto.className != "input1" ) {
						LseComMndtForm(formObj,"max_dpc_rto");
					}
				}else{
					formObj.dpc_rto.className = "input";
					formObj.max_dpc_rto.className = "input";
				}
				
				LseComBtnControl(false, "btn_Retrieve");
				LseComBtnControl(true,  "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6DownExcel|btn_t6RowAdd2|btn_t6RowDelete2");
			} else {
				if ( formObj.eff_dt.className != "input2" ) {
					ComEnableObject(formObj.eff_dt, true);
				}
				if ( formObj.exp_dt.className != "input2" ) {
					ComEnableObject(formObj.exp_dt, true);
				}
				if ( formObj.btns_calendar1.style.filter == "" ) {
					ComEnableObject(formObj.btns_calendar1, true);
				}
				LseComBtnControl(true, "btn_Retrieve|btn_New|btn_Create|btn_t1DownExcel|btn_t2DownExcel|btn_t3DownExcel|btn_t4DownExcel|btn_t6DownExcel");
				LseComBtnControl(false, "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6RowAdd2|btn_t6RowDelete2");
			}
		} else {
			ComResetAll();
			sheetObj.RenderSheet(1);
			/* retrieve Form setting */
			if ( formActionType != MODE_SEARCH ) {
				setFormEnable(MODE_SEARCH, formObj);
			}
		}
		/* Org CNTR type/size code re-setting : Org CNTR type/size code data delete re-setting in case of Form Data setting  */
		ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
	}
	/**
	 * General Tab IBSheet Object Change Event
	 */
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		switch(colName) {
			case "cntr_tpsz_cd":
				checkDuplicateCol(sheetObj, Row, colName, Value);
				break;
		}
	}
	/**
	 * Sheet OnPopuphandling event in case of Click.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t1sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		switch (sName) {
			case "cntr_spec_no":
				/* Delivery Location Pop-up */
				openPopupPage("6", Row, Col, 0);
				break;
				
			case "cntr_tpsz_cd":
				var formObj=document.form;
				if (sheetObj.ColSaveName(Col) != "cntr_tpsz_cd") return;
				var disPlayTpSz=new Array();
				var disPlayTab=new Array();
				
				var prefixValue="";
				var checkedList="";
				for(var x=1 ; x <= sheetObj.RowCount();x++){
					if(sheetObj.GetRowStatus(x) == "D") {
						ComShowCodeMessage("LSE01164");
						return;
					}
					checkedList=checkedList + (sheetObj.GetCellValue(x,"cntr_tpsz_cd") + "|");
				}
				
				checkedList=DelLastDelim(checkedList);
				var param="?checked=" + checkedList + "&returntitle=TP/SZ SELECTION&temp_value1=1";
				ComOpenPopup('EES_LSE_0001_POP.do' + param, 400, 413, 'getLse_psMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
	 	}
	}
	
	function getLse_psMulti01(aryPopupData,sheet_id,temp_value1,sheet_row){
		//temp value : 0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals=temp_value1.split("|");
		var formObj=document.form;
		var targetSheet=sheetObjects[sheet_id];
		
		var startpoint=targetSheet.RowCount();
		for(var i=startpoint; i >= 1 ; i--){
			if(targetSheet.GetCellValue(i,"cntr_tpsz_cd")	== ""){
				targetSheet.RowDelete(i, false);
			}
		}
		
		for(var j=0; j < aryPopupData.length ; j++){
			var isHaveTpSz=false;
			for(var i=1;i <= targetSheet.RowCount();i++){
				if(targetSheet.GetCellValue(i,"cntr_tpsz_cd") == aryPopupData[j]){
					isHaveTpSz=true;
				}
			}
			
			if(!isHaveTpSz){
				targetSheet.SetCellValue(sheet_row,"cntr_tpsz_cd",aryPopupData[j],0);
				targetSheet.SetCellValue(sheet_row, "loc_cd","ALL",0);
				
			}
		}
		
	}
	
	
	function getLse_psMulti(aryPopupData,sheet_id,temp_value1){
		//temp value : 0 -> cost_dtl_cd,1 -> cost_cd
		var tempVals=temp_value1.split("|");
		var formObj=document.form;
		var targetSheet=sheetObjects[sheet_id];
		
		var startpoint=targetSheet.RowCount();
		for(var i=startpoint; i >= 1 ; i--){
			if(targetSheet.GetCellValue(i,"cntr_tpsz_cd")	== ""){
				targetSheet.RowDelete(i, false);
			}
		}
		
		for(var j=0; j < aryPopupData.length ; j++){
			var isHaveTpSz=false;
			for(var i=1;i <= targetSheet.RowCount();i++){
				if(targetSheet.GetCellValue(i,"cntr_tpsz_cd") == aryPopupData[j]){
					isHaveTpSz=true;
				}
			}
			
			if(!isHaveTpSz){
				var Row=targetSheet.DataInsert(-1);
				/*targetSheet.SetCellValue(Row,"agmt_ofc_cty_cd",formObj.agmt_ofc_cty_cd.value,0);
				targetSheet.SetCellValue(Row,"agmt_seq",formObj.agmt_seq.value,0);
				targetSheet.SetCellValue(Row,"agmt_ver_no",agmt_ver_no.GetSelectCode(),0);*/
				targetSheet.SetCellValue(Row,"cntr_tpsz_cd",aryPopupData[j],0);
				targetSheet.SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
				/*targetSheet.SetCellValue(Row,"cost_cd",tempVals[1],0);
				targetSheet.SetCellValue(Row,"cost_dtl_cd",tempVals[0],0);*/
				targetSheet.InitCellProperty(Row, 'cntr_tpsz_cd',{ Type:"Text",Edit:"0"} );
			}
			}
		
		/*if(targetSheet.RowCount()> 1){
			targetSheet.SelectCell(1, "agmt_rt_amt", false);
		}*/
	}
	
	function setPopupData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                case "loc_cd":                	
                	SetCellValue(Row, Col, aryPopupData[0][3],0);
                	//setAsyncData(sheetObjects[ShtIdx], Row, Col, GetCellValue(Row, Col));
                	if(ShtIdx != 6) {
                		checkDuplicateCol(sheetObjects[ShtIdx], Row, "loc_cd", GetCellValue(Row, Col));
                	}
                }
            }
		}
	}
	
	
	/*function setSTPopupData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                case "loc_cd":                	
                	SetCellValue(Row, Col, aryPopupData[0][3],0);
                }
            }
		}
	}
	
	
	function setCNPopupData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                case "loc_cd":                	
                	SetCellValue(Row, Col, aryPopupData[0][3],0);
                }
            }
		}
	}*/
	
	function setRCCPopData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with(sheetObjects[ShtIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":			
						SetCellValue(Row,Col,aryPopupData[0][11],0);		
						if(ShtIdx != 6) {
							checkDuplicateCol(sheetObjects[ShtIdx], Row, "loc_cd", GetCellValue(Row, Col));
						}
						break;
				}
			}
		}
	}
	
	function setLCCPopData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with(sheetObjects[ShtIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":					
						SetCellValue(Row,Col,aryPopupData[0][10],0);	
						if(ShtIdx != 6) {
							checkDuplicateCol(sheetObjects[ShtIdx], Row, "loc_cd", GetCellValue(Row, Col));
						}
						break;
				}
			}
		}
	}
	
	function setECCPopData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with(sheetObjects[ShtIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":					
						SetCellValue(Row,Col,aryPopupData[0][9],0);			
						if(ShtIdx != 6) {
							checkDuplicateCol(sheetObjects[ShtIdx], Row, "loc_cd", GetCellValue(Row, Col));
						}
						break;
				}
			}
		}
	}
	
	function setSCCPopData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with(sheetObjects[ShtIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						var dupRow=FindText(Col, aryPopupData[0][8]);						
						SetCellValue(Row,Col,aryPopupData[0][8],0);						
						break;
				}
			}
		}
	}
	
	
	function setLOCPopData(aryPopupData, Row, Col, ShtIdx) {
		if (aryPopupData[0].length > 0 ) {
			with(sheetObjects[ShtIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						var dupRow=FindText(Col, aryPopupData[0][3]);						
						SetCellValue(Row,Col,aryPopupData[0][3],0);						
						break;
				}
			}
		}
	}
	
	
	
	function openLcPopupPage(type, Row, Col, SheetIdx) {
		if(type == "2") {
			ComOpenPopup('/opuscntr/COM_ENS_0H1.do', 700, 382, 'setPopupData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "3") {
			ComOpenPopup('/opuscntr/COM_ENS_0I1.do', 750, 380, 'setPopupData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "4") {
			ComOpenPopup('/opuscntr/COM_ENS_0M1.do', 850, 530, 'setPopupData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "5") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setRCCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "6") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setLCCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "7") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setECCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "8") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setSCCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}else if(type == "9") {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setLOCPopData', '1,0,1,1,1,1,1,1', false, false, Row, Col, SheetIdx);
		}
	}
		
	/**
	 * Sheet OnPopuphandling event in case of Click.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t2sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				if(slocTpCd == "AL") {
					openLcPopupPage("1", Row, Col, 1);
				}else if(slocTpCd == "CT") {
					openLcPopupPage("2", Row, Col, 1);
				}else if(slocTpCd == "ST") {
					openLcPopupPage("3", Row, Col, 1);
				}else if(slocTpCd == "CN") {
					openLcPopupPage("4", Row, Col, 1);
				}else if(slocTpCd == "RC") {
					openLcPopupPage("5", Row, Col, 1);
				}else if(slocTpCd == "LC") {
					openLcPopupPage("6", Row, Col, 1);
				}else if(slocTpCd == "EC") {
					openLcPopupPage("7", Row, Col, 1);
				}else if(slocTpCd == "SC") {
					openLcPopupPage("8", Row, Col, 1);
				}else if(slocTpCd == "LO") {
					openLcPopupPage("9", Row, Col, 1);
				}
				//openPopupPage("5", Row, Col, 1);
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
	function t2sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
			case "eq_loc_tp_cd":
				if(sheetObj.GetCellValue(Row,Col) == "AL") {
					sheetObj.SetCellValue(Row,"loc_cd","ALL");
					sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E" , InputCaseSensitive:1});
				}else{
					sheetObj.SetCellValue(Row,"loc_cd","");
					if(sheetObj.GetCellValue(Row,Col) == "CT" || sheetObj.GetCellValue(Row,Col) == "ST" || sheetObj.GetCellValue(Row,Col) == "CN") {
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E" , InputCaseSensitive:1});
					}else{
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E|N" , InputCaseSensitive:1});
					}
					
				}
				break;
		}
 	}
	/**
	 * Sheet OnPopuphandling event in case of Click.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t3sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
		
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				//openPopupPage("5", Row, Col, 2);
				if(slocTpCd == "AL") {
					openLcPopupPage("1", Row, Col, 2);
				}else if(slocTpCd == "CT") {
					openLcPopupPage("2", Row, Col, 2);
				}else if(slocTpCd == "ST") {
					openLcPopupPage("3", Row, Col, 2);
				}else if(slocTpCd == "CN") {
					openLcPopupPage("4", Row, Col, 2);
				}else if(slocTpCd == "RC") {
					openLcPopupPage("5", Row, Col, 2);
				}else if(slocTpCd == "LC") {
					openLcPopupPage("6", Row, Col, 2);
				}else if(slocTpCd == "EC") {
					openLcPopupPage("7", Row, Col, 2);
				}else if(slocTpCd == "SC") {
					openLcPopupPage("8", Row, Col, 2);
				}else if(slocTpCd == "LO") {
					openLcPopupPage("9", Row, Col, 2);
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
	function t3sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
			case "eq_loc_tp_cd":
				if(sheetObj.GetCellValue(Row,Col) == "AL") {
					sheetObj.SetCellValue(Row,"loc_cd","ALL");
					sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E" , InputCaseSensitive:1});
				}else{
					sheetObj.SetCellValue(Row,"loc_cd","");
					if(sheetObj.GetCellValue(Row,Col) == "CT" || sheetObj.GetCellValue(Row,Col) == "ST" || sheetObj.GetCellValue(Row,Col) == "CN") {
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E" , InputCaseSensitive:1});
					}else{
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E|N" , InputCaseSensitive:1});
					}
				}
				break;
		}
 	}
	/**
	 * Sheet OnPopuphandling event in case of Click.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function t4sheet1_OnPopupClick(sheetObj,Row,Col) {
		var sName=sheetObj.ColSaveName(Col);
		var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
		switch (sName) {
			case "loc_cd":
				/* Delivery Location Pop-up */
				//openPopupPage("5", Row, Col, 3);
				if(slocTpCd == "AL") {
					openLcPopupPage("1", Row, Col, 3);
				}else if(slocTpCd == "CT") {
					openLcPopupPage("2", Row, Col, 3);
				}else if(slocTpCd == "ST") {
					openLcPopupPage("3", Row, Col, 3);
				}else if(slocTpCd == "CN") {
					openLcPopupPage("4", Row, Col, 3);
				}else if(slocTpCd == "RC") {
					openLcPopupPage("5", Row, Col, 3);
				}else if(slocTpCd == "LC") {
					openLcPopupPage("6", Row, Col, 3);
				}else if(slocTpCd == "EC") {
					openLcPopupPage("7", Row, Col, 3);
				}else if(slocTpCd == "SC") {
					openLcPopupPage("8", Row, Col, 3);
				}else if(slocTpCd == "LO") {
					openLcPopupPage("9", Row, Col, 3);
				}
				break;
		}
	}
	 /**
		 * Sheet OnPopuphandling event in case of Click.<br>
		 * @param sheetObj
		 * @param Row
		 * @param Col
		 */
		function t4sheet2_OnPopupClick(sheetObj,Row,Col) {
			var sName=sheetObj.ColSaveName(Col);
			var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
			switch (sName) {
				case "loc_cd":
					/* Delivery Location Pop-up */
					openPopupPage("5", Row, Col, 4);
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
	function t4sheet1_OnChange(sheetObj, Row, Col, Value)  {
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "loc_cd":		// Grid Location Code Check
				checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
				setAsyncData(sheetObj, Row, Col, Value);
				break;
			case "eq_loc_tp_cd":
				if(sheetObj.GetCellValue(Row,Col) == "AL") {
					sheetObj.SetCellValue(Row,"loc_cd","ALL");
					sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E" , InputCaseSensitive:1});
				}else{
					sheetObj.SetCellValue(Row,"loc_cd","");
					if(sheetObj.GetCellValue(Row,Col) == "CT" || sheetObj.GetCellValue(Row,Col) == "ST" || sheetObj.GetCellValue(Row,Col) == "CN") {
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E" , InputCaseSensitive:1});
					}else{
						sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E|N" , InputCaseSensitive:1});
					}
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
		function t4sheet2_OnChange(sheetObj, Row, Col, Value)  {
			var sName=sheetObj.ColSaveName(Col);
			switch(sName) {
				case "loc_cd":		// Grid Location Code Check
					checkDuplicateCol(sheetObj, Row, "loc_cd", Value);
					setAsyncData(sheetObj, Row, Col, Value);
					break;
				case "eq_loc_tp_cd":
					if(sheetObj.GetCellValue(Row,Col) == "AL") {
						sheetObj.SetCellValue(Row,"loc_cd","ALL");
						sheetObj.InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0",AcceptKeys:"E" , InputCaseSensitive:1});
					}else{
						sheetObj.SetCellValue(Row,"loc_cd","");
						if(sheetObj.GetCellValue(Row,Col) == "CT" || sheetObj.GetCellValue(Row,Col) == "ST" || sheetObj.GetCellValue(Row,Col) == "CN") {
							sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E" , InputCaseSensitive:1});
						}else{
							sheetObj.InitCellProperty(Row, "loc_cd", {Type:"PopupEdit",Edit:"1",AcceptKeys:"E|N" , InputCaseSensitive:1});
						}
					}
					break;
			}
	 	}
	/**
	 * Penalty Tab IBSheet Object Search-End Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		var formObj=document.form;
		if( sheetObj.RowCount() < 1){
	          InitHeadColumn(t5sheet1_leftHeaders,sheetObj);
		} else {
	     InitHeadText(t5sheet1_leftHeaders,sheetObj);
	    }
		sheetObj.SetCellFontColor(1, 0, "#000000");
		LseComMndtForm(formObj, "agmt_chg_val");
		
		if ( sheetObj.SearchRows()> 0 ) {
			ComSetObjValue(formObj.agmt_chg_val, sheetObj.GetCellValue(1,"agmt_chg_val"));
		} else {
			ComSetObjValue(formObj.agmt_chg_val, "");
			sheetObj.SetCellValue(1, "loc_cd",ConstantMgr.getBaseLocationCode());
			sheetObj.SetRowStatus(1,"R");
		}
		
		if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {
			$("#agmt_chg_val").attr('class', 'input1');
			$("#bld_dwn_end_dt").attr('class', 'input1');
		}else{
			$("#agmt_chg_val").attr('class', 'input');
			$("#bld_dwn_end_dt").attr('class', 'input');
		}
		
		/*for ( var colIdx=1 ; colIdx <= sheetObj.LastCol(); colIdx++ ) {
			if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {
				if(sheetObj.GetCellValue(1,colIdx) == "") {
					sheetObj.SetCellValue(1,colIdx,"0");
				}						
			}
		}*/
	}
	
	function tab1_OnClick(tabObj , nItem) {
		if(sheetObjects[0].LastRow() >= 0) {	
			if(sheetObjects[0].RowCount() > 0) {
				for ( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++ ) {
					if(sheetObjects[0].GetCellValue(i,"cntr_tpsz_cd") == "") {
						ComShowCodeMessage("LSE01015");
						tabObjects[0].SetSelectedIndex(0);
						return false;
					}
				}
			}else if(sheetObjects[0].RowCount() == 0) {
				ComShowCodeMessage("LSE01015");
				tabObjects[0].SetSelectedIndex(0);
				return false;
			}
		}
	}
	
	
	function tab1_OnChange(tabObj , nItem)
	{
		var formObj=document.form;
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		}
		beforetab=nItem;
		resizeSheet();
		if ( formActionType == MODE_MODIFY || formActionType == MODE_CREATE ) {
			switch(nItem) {
				case 1 :	// Per-diem
					//if ( ComGetObjValue(combo1) == "LT" ) {
					//	sheetObjects[1].ColHidden("agmt_chg_val") = true;
					//	sheetObjects[1].ColHidden("loc_cd")       = false;
					//} else {
					//	sheetObjects[1].ColHidden("agmt_chg_val") = false;
					//	sheetObjects[1].ColHidden("loc_cd")       = true;
					//}
					control_Loc(combo1);
					break;
			}
		}
		/* General Tab Container Type/Size Column Show */
		if(beforetab != "5") {
			for ( var Idx=2 ; Idx <= sheetObjects[6].LastRow(); Idx++ ) {
				if(sheetObjects[6].GetCellValue(Idx,"cntr_tpsz_cd") == "") {
					ComShowCodeMessage("LSE01015");
					tabObjects[0].SetSelectedIndex(5);
					return false;
				}	
			}
		}
		
		switch(nItem) {
			case 1 :	// Per-diem
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[1]);
				break;
			case 2 :	// Handling Charges
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[2]);
				break;
			case 3 :	// DOL/DOC
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[3]);
				break;
			case 4 :	// Penalty
				setCntrTypeSizeCol(sheetObjects[0], sheetObjects[5]);
				break;
			case 5 :	// DPP
				//setCntrTypeSizeRow(sheetObjects[0], sheetObjects[6]);
				var targetSheetObj = sheetObjects[6];
				with(targetSheetObj) {
					vStartCntrColIdx=1;					
					targetSheetObj.RenderSheet(0);					
					SetSheetWidth(1100);	 				
					targetSheetObj.RenderSheet(1);
				}
				
				break;
		}
	}
	/*
	 * Lease Term Onhandling event in case of Change
	 */
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		control_Spec_No(ComGetObjValue(comboObj));
		control_Loc(ComGetObjValue(comboObj));
		if ( ComGetObjValue(comboObj) == "ST" || ComGetObjValue(comboObj) == "LT" ) {
			//LseComMndtForm2(true, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
			LseComMndtForm3(true, formObj, "dpc_rto|max_dpc_rto|combo2_text|combo3_text|lse_pay_tp_cd_text");
		} else {
			LseComMndtForm3(false, formObj, "dpc_rto|max_dpc_rto|combo2_text|combo3_text|lse_pay_tp_cd_text");
		}
		
		if ( ComGetObjValue(comboObj) == "ST" || ComGetObjValue(comboObj) == "LT" || ComGetObjValue(comboObj) == "SI" ) {
			$("#agmt_chg_val").attr('class', 'input1');
			$("#bld_dwn_end_dt").attr('class', 'input1');
		}else{
			$("#agmt_chg_val").attr('class', 'input');
			$("#bld_dwn_end_dt").attr('class', 'input');
		}
		
		var sheetObject6=sheetObjects[5];   //t5sheet1. Penalty
		if ( ComGetObjValue(comboObj) == "ST" || ComGetObjValue(comboObj) == "LT" || ComGetObjValue(comboObj) == "SI" ) {
			form.agmt_chg_val.value = "";
			form.bld_dwn_end_dt.value = "";
			for ( var colIdx=1 ; colIdx <= sheetObject6.LastCol(); colIdx++ ) {			
				sheetObject6.SetCellValue(1,colIdx,"0");			
			}
		}else{
			form.agmt_chg_val.value = "";
			form.bld_dwn_end_dt.value = "";
			for ( var colIdx=1 ; colIdx <= sheetObject6.LastCol(); colIdx++ ) {			
				sheetObject6.SetCellValue(1,colIdx,"");
			}
		}
		
		combo1.SetEditable(0);
		combo2.SetEditable(0);
		combo3.SetEditable(0);
		lse_pay_tp_cd.SetEditable(0);
	}
	/**
	 * Sheet Object  Container Type/Size code string return
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function getGeneralCntrTypeSize(sheetObj) {
		var vSelectedCntrTpSz="";
		if ( sheetObj.RowCount()> 0 ) {
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if ( sheetObj.GetRowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {
						vSelectedCntrTpSz=vSelectedCntrTpSz + "|" + sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					} else {
						vSelectedCntrTpSz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}
    /**
	 * Per-diem/Handling Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet Container Type/Size Column
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeCol(sourceSheetObj, targetSheetObj) {
		var vSelectedCntrTpSz=getGeneralCntrTypeSize(sourceSheetObj);
		var vShowSheetWidth=0;
		var vStartCntrColIdx=0;
		
		if ( vSelectedCntrTpSz != "" || vSelectedCntrTpSz == "") {
			with(targetSheetObj) {
				if ( targetSheetObj.id == "t2sheet1" ||  targetSheetObj.id == "t3sheet1") {
					vStartCntrColIdx=5;
				} else if ( targetSheetObj.id == "t4sheet1"){
					vStartCntrColIdx=4;
				} else {
					vStartCntrColIdx=1;
				}
				/* Frozened Column Width calc(Hidden Column except) */
				for ( var colIdx=0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( GetColHidden(colIdx) == false ) {
						vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx);
					}
				}
				targetSheetObj.RenderSheet(0);
				/* General Tab inserted Container Type/Size Column Width calc  */
				var viewColCount = 0;
				for ( var colIdx=vStartCntrColIdx ; colIdx <= LastCol(); colIdx++ ) {
					if ( GetCellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(GetCellValue(0, colIdx)) ) {
							if ( GetColHidden(colIdx) == true ) {
								SetColHidden(colIdx,0);
							}
							vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx);
						} else {
							if ( GetColHidden(colIdx) == false ) {
								SetColWidth(colIdx, 55);
								//for ( var i = HeaderRows ; i <= RowCount+(HeaderRows-1) ; i++ ) {
//								for ( var i=HeaderRows(); i <= LastRow(); i++ ) {
//									SetCellValue(i, colIdx,"",0);
//								}
								SetColHidden(colIdx,1);
							}
						}
					}
					viewColCount += GetColHidden(colIdx);
				}
				SetSheetWidth(120 * (LastCol() - viewColCount + 1));
 				//if ( RowCount()>= 3 ) {
				//	vShowSheetWidth=vShowSheetWidth;
				//} else {
				//	vShowSheetWidth=vShowSheetWidth;
				//}
				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SetSheetWidth(mainTable.clientWidth-20);
				} else {
					SetSheetWidth(vShowSheetWidth);
				}
				targetSheetObj.RenderSheet(1);
			}
		}
		targetSheetObj.SetVisible(1);
		
		
		if ( targetSheetObj.id == "t5sheet1"){
			if(targetSheetObj.RowCount() == 0 && vSelectedCntrTpSz != "") {
				targetSheetObj.DataInsert(-1);
				targetSheetObj.SetCellFontColor(1, 0, "#000000");
				targetSheetObj.SetCellValue(1,0,"Rate/Day");
				
				for ( var colIdx=vStartCntrColIdx ; colIdx <= targetSheetObj.LastCol(); colIdx++ ) {
					if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {						
						targetSheetObj.SetCellValue(1,colIdx,"0");						
					}else{
						targetSheetObj.SetCellValue(1,colIdx,"");						
					}
				}
			}
		}
		
	}
    /**
	 * DPP Tab Container Type/Size Setting
	 * Target Sheet  Container Type/Size Row 
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeRow(sourceSheetObj, targetSheetObj) {
		var formObj=document.form;
		/* Source Sheet Container Type/Size */
		var vGeneralCntrTpSz=getGeneralCntrTypeSize(sourceSheetObj);
		/* Target Sheet Container Type/Size */
		var vDppCntrTpSz=getGeneralCntrTypeSize(targetSheetObj);
		with(targetSheetObj) {
			if ( RowCount()> 0 ) {
				/* Target Sheet Container Type/Size existing -> compare, inserting */
				if ( (vGeneralCntrTpSz != "") && (vGeneralCntrTpSz != vDppCntrTpSz) ) {
					var arrGeneralCntrTpSz=vGeneralCntrTpSz.split("|");
					for ( var i=0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						if ( !vDppCntrTpSz.match(arrGeneralCntrTpSz[i]) ) {
							var Row=DataInsert(-1);
							SetCellValue(Row, "cntr_tpsz_cd",arrGeneralCntrTpSz[i],0);
							//SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
							SetCellValue(Row, "loc_cd","ALL",0);
							InitCellProperty(Row,"loc_cd" , {Type:"Text",Edit:"0"});
							SetCellValue(Row, "cntr_rntl_chg_tp_cd","DPPV",0);
						}
					}
					var arrDppCntrTpSz=vDppCntrTpSz.split("|");
					for ( var i=0 ; i < arrDppCntrTpSz.length ; i++ ) {
						if ( !vGeneralCntrTpSz.match(arrDppCntrTpSz[i]) ) {
							var Row=FindText("cntr_tpsz_cd", arrDppCntrTpSz[i]);
							SetRowHidden(Row,1);
							SetRowStatus(Row,"D");
						}
					}
				}
			} else {
				if ( vGeneralCntrTpSz != "" ) {
					var arrGeneralCntrTpSz=vGeneralCntrTpSz.split("|");
					for ( var i=0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						var Row=DataInsert(-1);
						SetCellValue(Row, "cntr_tpsz_cd",arrGeneralCntrTpSz[i],0);
						//SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
						SetCellValue(Row, "loc_cd","ALL");
						InitCellProperty(Row,"loc_cd" , { Type:"Text",Edit:"0"});
						SetCellValue(Row, "cntr_rntl_chg_tp_cd","DPPV",0);
					}
				}
			}
		}
	}
	/**
	 * Pop-up Open <br>
	 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	 * @param object Object
	 * @param Row Row index
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
				ComOpenPopup('/opuscntr/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 800, 470, 'setPopData_AgreementVer', '1,0', true);
			} else {
				ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 470, 'setPopData_Agreement', '1,0', true);
			}
		} else if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 500, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "3") {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 500, 'setPopData_Currency', '1,0', true);
		} else if ( type == "4") {
			var url='/opuscntr/EES_LSE_0096.do?agmt_cty_cd='+ComGetObjValue(formObj.agmt_cty_cd)+'&agmt_seq='+ComGetObjValue(formObj.agmt_seq);
//			var returnVal=ComOpenWindowCenter(url, "", 520, 300, true);
			ComOpenPopup(url, 520, 300, "setPopData_EffDate", "1,0,1,1,1,1,1", true);
//			if( returnVal != undefined && returnVal != "" ) {
//				setPopData_EffDate(returnVal);
//			}
		} else if ( type == "5" ) {
			ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setPopData_DolDocLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, SheetIdx);
		} else if ( type == "6" ) {
			with(sheetObjects[SheetIdx]) {
				var own_cntr_flg="";
				if ( ComGetObjValue(combo1) == "OW" || ComGetObjValue(combo1) == "LP" || ComGetObjValue(combo1) == "OL" ) {
					own_cntr_flg="O";
				} else if (ComGetObjValue(combo1) == "SH" || ComGetObjValue(combo1) == "SI" || ComGetObjValue(combo1) == "MI" || ComGetObjValue(combo1) == "OF" || ComGetObjValue(combo1) == "ST"){
					own_cntr_flg="S";
				} else {
					own_cntr_flg="L";
				}
				var cntr_tpsz_cd=GetCellValue(Row, "cntr_tpsz_cd");
				if ( cntr_tpsz_cd == "" ) {
					ComShowCodeMessage("LSE01015");
					sheetObjects[0].SelectCell(Row, "cntr_tpsz_cd");
					return;
				}
				
				var strvndr_seq = formObj.vndr_seq.value;
				var strvndr_lgl_eng_nm = formObj.vndr_nm.value;
				var lstm_cd = formObj.lstm_cd.value;
				
				if(strvndr_seq == "") {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				ComOpenPopup('/opuscntr/EES_MST_0022_POP.do?own_cntr_flg='+own_cntr_flg+'&cntr_tpsz_cd='+cntr_tpsz_cd+'&lstm_cd='+lstm_cd+'&active_flag=3'+'&strVndrSeq='+strvndr_seq+'&strVndrNm='+strvndr_lgl_eng_nm, 1250, 650, 'setPopData_CntrSpecNo', '0,0', false, false, Row, Col, SheetIdx);
			}
    	}
	}
	/**
	 * Agreement Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
				if ( aryPopupData[0][6] == "OW" || aryPopupData[0][6] == "LP" || aryPopupData[0][6] == "OL"
				  || aryPopupData[0][6] == "LT" || aryPopupData[0][6] == "ST" || aryPopupData[0][6] == "OF" ) {
					ComShowCodeMessage("LSE01040");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}
			document.form.agmt_seq.value=aryPopupData[0][5];
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	 }
	/**
	 * Agreement Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd))  ) {
				if ( aryPopupData[0][5] == "OW" || aryPopupData[0][5] == "LP" || aryPopupData[0][5] == "OL"
				  || aryPopupData[0][5] == "LT" || aryPopupData[0][5] == "ST" || aryPopupData[0][5] == "OF" ) {
					ComShowCodeMessage("LSE01040");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}
			ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	}
	/**
	 * Lessor(Service Provider) Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
	 * Currency Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][2]);
		}
	}
	/**
	 * Version-Up Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_EffDate(popupData) {
		var formObj=document.form;
		if ( popupData != "" ) {
			var arrPopupData=popupData.split("|");
			ComSetObjValue(formObj.eff_dt, arrPopupData[0]);
			ComSetObjValue(formObj.exp_dt, arrPopupData[1]);
			formActionType=MODE_VRSNUP;
			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
		}
	}
	/**
	 * Location Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						var dupRow=FindText(Col, aryPopupData[0][10]);
						if(sheetIdx != 6) {
							if ( dupRow != -1 && Row != dupRow ) {
								SetCellValue(Row,Col,"",0);
							} else {
								if ( sheetIdx != 1 ) {
									SetCellValue(Row,Col,aryPopupData[0][8],0);
								} else {
									SetCellValue(Row,Col,aryPopupData[0][10],0);
								}
							}
						}else{
							SetCellValue(Row,Col,aryPopupData[0][8],0);
						}
						break;
				}
			}
		}
	}
	
	
	/**
	 * Location Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_DolDocLoc(aryPopupData, Row, Col, sheetIdx) {
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "loc_cd":
						var dupRow=FindText(Col, aryPopupData[0][3]);
						if(sheetIdx != 6) {
							if ( dupRow != -1 && Row != dupRow ) {
								checkDuplicateCol(sheetObjects[sheetIdx], Row, Col, aryPopupData[0][3]);
								SetCellValue(Row,Col,"",0);
							} else {
								SetCellValue(Row,Col,aryPopupData[0][3],0);
							}
						}
						break;
				}
			}
		}
	}
	/**
	 * Container Spec No. Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_CntrSpecNo(aryPopupData, Row, Col, sheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			with(sheetObjects[sheetIdx]) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "cntr_spec_no":
						if ( ComTrim(ComGetObjValue(formObj.vndr_seq)) == ComTrim(aryPopupData[0][7]) ) {
							SetCellValue(Row,Col,aryPopupData[0][2],0);
						} else {
							ComShowCodeMessage("LSE01130");
							SelectCell(Row, Col);
						}
						break;
				}
			}
		}
	}
	/**
	 * Sheet Object Location Code change, Validation handling<br>
	 * @param sheetObj
	 * @param Row Row index
	 * @param Col Col index
	 * @param Value
	 * @param Type
	 */
	function setAsyncData(sheetObj, Row, Col, Value, Type) {
		 if (Type==undefined || Type==null) Type="1";
		 with(sheetObj) {
			 if ( GetCellValue(Row,Col) != "" ) {
				var loc_tp="";
				var loc_col_nm="";
				if (sheetObj==sheetObjects[1]){
					loc_tp="LCC";
					loc_col_nm="lcc_cd";					
					if(Value=="ALL") {
					  return;
					}
				}else{
					loc_tp="SCC";
					loc_col_nm="scc_cd";					
				}
				var param="f_cmd="  + SEARCH21
						 + "&eq_loc_tp_cd=" + sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
						 + "&loc_cd=" + Value
						 + "&loc_tp=" + loc_tp;
				if(sheetObj == sheetObjects[4]) {
					param = param + "&sheet_idx=4"
				}
				
				SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
				SetWaitImageVisible(1);
				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" ) {
						if ( ComGetEtcData(sXml, loc_col_nm) != "" ) {
							var vLccCd=ComGetEtcData(sXml, loc_col_nm);
//							SetCellBackColor(Row, Col,"#000000");
						} else {
							if ( type == "1" ) {
								ComShowCodeMessage("LSE01037");
//								SetCellValue(Row,Col,"",0);
							} else {
								SetCellValue(Row,Col,"",0);
//								SetCellBackColor(Row, Col,"#FFFF00");
							}
						}
					} else {
						if ( Type == "1" ) {
							ComShowCodeMessage("LSE01037");
							SetCellValue(Row,Col,"",0);
							SelectCell(Row,Col);
						} else {
							SetCellValue(Row,Col,"",0);
//							SetCellBackColor(Row, Col,"#FFFF00");
						}
					}
				}
			}
		}
		return;
	}
	/**
	 * Form by page setting, Objects using/unusing handling<br>
	 * @param type
	 * @param formObj
	 */
	function setFormEnable(type, formObj) {
		switch(type) {
			case MODE_SEARCH :
				if ( formActionType != MODE_SEARCH ) {
					formActionType=MODE_SEARCH;
					LseComEnableForm(false, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt");
					LseComMndtForm(formObj,"agmt_seq");
					
					if ( formObj.vndr_seq.className != "input2" ) {
						ComEnableObject(formObj.vndr_seq, false);
					}
					if ( formObj.eff_dt.className != "input2" ) {
						ComEnableObject(formObj.eff_dt, true);
					}
					if ( formObj.exp_dt.className != "input2" ) {
						ComEnableObject(formObj.exp_dt, true);
					}
					if ( formObj.btns_calendar1.style.filter == "" ) {
						ComEnableObject(formObj.btns_calendar1, true);
					}					
					ComEnableManyObjects(true, formObj.btns_search1);
					LseComBtnControl(false, "btn_Save|btn_VersionUp|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6DownExcel");
					LseComBtnControl(true,  "btn_Retrieve|btn_Create");					
				}
				ComSetFocus(formObj.agmt_seq);
				combo1.SetEditable(0);
				combo2.SetEditable(0);
				combo3.SetEditable(0);
				lse_pay_tp_cd.SetEditable(0);
				break
			case MODE_MODIFY :
				if ( formActionType != MODE_MODIFY ) {
					formActionType=MODE_MODIFY;
					//LseComEnableForm(true, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt");
					LseComMndtForm(formObj,"agmt_seq|lse_ctrt_no|ref_no|curr_cd|bld_up_dt|lse_free_dys|lse_pay_term_dys|agmt_dt|lse_vndr_url|dir_itchg_fee_amt|agmt_rmk|lse_pay_tp_cd");
					if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" ) {
						//LseComMndtForm2(true, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
						LseComMndtForm3(true, formObj, "combo2_text|combo3_text|lse_pay_tp_cd_text");
					} else {
						LseComMndtForm3(false, formObj, "combo2_text|combo3_text|lse_pay_tp_cd_text");
					}
					
					$("#bld_up_dt").attr('class', 'input');
					$("#lse_vndr_url").attr('class', 'input');
					$("#agmt_dt").attr('class', 'input');
					$("#lse_pay_term_dys").attr('class', 'input');
					$("#old_agmt_no").attr('class', 'input');
					$("#old_agmt_no").attr("disabled",false);
					$("#old_agmt_no").attr("readonly",false);
					$("#lse_free_dys").attr('class', 'input');
					$("#agmt_rmk").attr('class', 'input');
					$("#dir_itchg_fee_amt").attr('class', 'input');
					$("#agmt_rmk").attr("disabled",false);
					$("#chk_itchg_fee_flg").attr("disabled",false);
					$("#chk_slb_flg").attr("disabled",false);
					$("#agmt_chg_val").attr('class', 'input');
					$("#agmt_chg_val").attr("readonly",false);
					$("#agmt_chg_val").attr("disabled",false);
					$("#bld_dwn_end_dt").attr('class', 'input');
					$("#bld_dwn_end_dt").attr("readonly",false);
					$("#bld_dwn_end_dt").attr("disabled",false);
					
					formObj.dpp_tp_cd[0].disabled = false;
					formObj.dpp_tp_cd[1].disabled = false;
					
					ComEnableObject(formObj.vndr_seq, false);
					ComEnableObject(formObj.btns_search2, false);
					
					ComEnableObject(formObj.btns_calendar2, true);
					ComEnableObject(formObj.btns_calendar3, true);
					ComEnableObject(formObj.btns_calendar4, true);
					ComEnableObject(formObj.btns_search3, true);
					combo1.SetEnable(0);
					combo1.SetEditable(0);
					combo2.SetEditable(0);
					combo3.SetEditable(0);
					lse_pay_tp_cd.SetEditable(0);
				}
				ComSetFocus(formObj.agmt_seq);
				break;
			case MODE_CREATE :
				if ( formActionType != MODE_CREATE ) {
					ComResetAll();
					formActionType=MODE_CREATE;
					LseComEnableForm(true, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd|cre_usr_id|cre_dt");
					LseComMndtForm3(true, formObj, "combo1_text|combo2_text|combo3_text|lse_pay_tp_cd_text");
					comboObjects[0].SetBackColor("#d4f6ff");
					if ( formObj.agmt_seq.className != "input2" ) {
						ComEnableManyObjects(false, formObj.agmt_seq);
					}
			    	
			    	
					ComEnableObject(formObj.btns_search1, false);
					//LseComMndtForm(formObj, "combo1|eff_dt|exp_dt|vndr_seq|lse_ctrt_no|ref_no|curr_cd|agmt_chg_val");
					LseComMndtForm(formObj, "combo1|eff_dt|exp_dt|vndr_seq|lse_ctrt_no|ref_no|curr_cd|agmt_chg_val|bld_dwn_end_dt");
					/* DEPR Level Default Value Setting (Default Value : Daily, N) */
					ComSetObjValue(combo2,"D");
					ComSetObjValue(combo3,"N");
					/* Payment Type Code Default Value Setting (Default Value : NP) */
					ComSetObjValue(lse_pay_tp_cd,"NP");
					/* DEPR option handling */
					//LseComMndtForm2(false, formObj, "dpc_rto|max_dpc_rto|combo2|combo3");
					//LseComMndtForm2(false, formObj, "combo2|combo3");
					/* DPP Type Default Value Setting (Default Value : DDP) */
					formObj.dpp_tp_cd[1].checked=true;
					/* DPP Tab disable */
					tab1.SetTabDisable(5, true);
					ComSetObjValue(formObj.curr_cd, "USD");
					combo1.SetEditable(0);
					combo2.SetEditable(0);
					combo3.SetEditable(0);
					lse_pay_tp_cd.SetEditable(0);
					LseComBtnControl(false, "btn_Retrieve|btn_Create|btn_VersionUp");
					LseComBtnControl(true, "btn_Save|btn_t1RowAdd|btn_t1RowDelete|btn_t1LoadExcel|btn_t1DownExcel|btn_t2RowAdd|btn_t2RowDelete|btn_t2LoadExcel|btn_t2DownExcel|btn_t3RowAdd|btn_t3RowDelete|btn_t3LoadExcel|btn_t3DownExcel|btn_t4RowAdd|btn_t4RowDelete|btn_t4LoadExcel|btn_t4DownExcel|btn_t4RowAdd2|btn_t4RowDelete2|btn_t6LoadExcel|btn_t6DownExcel|btn_t6RowAdd2|btn_t6RowDelete2");
					tabObjects[0].SetSelectedIndex(0);
					doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
				}
				ComSetFocus(combo1);
				break;
		}
		ComEnableObject(formObj.chk_agmt_act_flg, false);
	}
	/**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
   function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( ComGetObjText(formObj.agmt_seq) == "" ) {
					ComShowCodeMessage("LSE01006");
					ComSetFocus(formObj.agmt_seq);
					return false;
				} else {
					if ( !ComChkObjValid(formObj.agmt_seq, true, false, false) ) {
						ComSetFocus(formObj.agmt_seq);
						return false;
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				if( ComGetObjText(formObj.vndr_seq) == "" ) {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				break;
			case IBSAVE:
				switch (sheetObj.id) {
					case "t1sheet1" :
						if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {
							/* Build Down Period. Valiation */
			     			if ( ComGetObjText(formObj.agmt_chg_val) == "" || ComGetObjText(formObj.bld_dwn_end_dt) == "") {
			     				ComShowCodeMessage("LSE10008");
			     				tabObjects[0].SetSelectedIndex(4);
			     				ComSetFocus(formObj.bld_dwn_end_dt);
			     				return false;
			     			}
						}
		     			
		     			/* Modify, Agreement No. Validataion */
		     			if ( formActionType == MODE_MODIFY ) {
		     				if( ComGetObjValue(formObj.agmt_seq) == "" ) {
		         				ComShowCodeMessage("LSE01006");
		         				ComSetFocus(formObj.agmt_seq);
		         				return false;
		         			}
		     			}
		     			/* Lease Term Validataion */
		     			if ( ComGetObjValue(combo1) == "" ) {
		     				ComShowCodeMessage("LSE01009");
		     				ComSetFocus(combo1);
		     				return false;
		     			}

		     			if ( ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "ST" ) {
		     				/* Yearly DEPR Default Value Setting */
		     				if ( ComGetObjValue(formObj.dpc_rto) == "" ) {
			     				//ComSetObjValue(formObj.dpc_rto, "0.0");
			     				ComShowCodeMessage("LSE01145");
			     				ComSetFocus(formObj.dpc_rto);
			     				return false;
			     			} else {
			     				if ( ComChkObjValid(formObj.dpc_rto) == false ) {
			     					ComSetFocus(formObj.dpc_rto);
			     					return false;
			     				}
			     			}
		     				/* MAX DEPR Default Value Setting */
			     			if ( ComGetObjValue(formObj.max_dpc_rto) == "" ) {
			     				//ComSetObjValue(formObj.max_dpc_rto, "0.0");
			     				ComShowCodeMessage("LSE01142");
			     				ComSetFocus(formObj.max_dpc_rto);
			     				return false;
			     			} else {
			     				if ( ComChkObjValid(formObj.max_dpc_rto) == false ) {
			     					ComSetFocus(formObj.max_dpc_rto);
			     					return false;
			     				}
			     			}
			     			/* DEPR Level Valiation */
			     			if ( ComGetObjText(combo2) == "" ) {
			     				ComShowCodeMessage("LSE01144");
			     				ComSetFocus(combo2);
			     				return false;
			     			}
			     			if ( ComGetObjText(combo3) == "" ) {
			     				ComShowCodeMessage("LSE01144");
			     				ComSetFocus(combo3);
			     				return false;
			     			}
		     			}
		     			if ( !checkEffDate() ) {
		     				//ComSetFocus(formObj.exp_dt);
		     				return false;
		     			}
		     			/* Lessor No. Validation */
		     			if ( ComGetObjText(formObj.vndr_seq) == "" ) {
		     				ComShowCodeMessage("LSE01044");
		     				ComSetFocus(formObj.vndr_seq);
		     				return false;
		     			}
		     			/* URL Valiation */
		     			/*
		     			if ( ComGetObjText(formObj.lse_vndr_url) == "" ) {
		     				ComShowCodeMessage("LSE01143");
		     				ComSetFocus(formObj.lse_vndr_url);
		     				return false;
		     			}
		     			*/
		     			/* Contract No. Valiation */
		     			if ( ComGetObjText(formObj.lse_ctrt_no) == "" ) {
		     				ComShowCodeMessage("LSE01052");
		     				ComSetFocus(formObj.lse_ctrt_no);
		     				return false;
		     			}
		     			/* Reference No. Valiation */
		     			if ( ComGetObjText(formObj.ref_no) == "" ) {
		     				ComShowCodeMessage("LSE01093");
		     				ComSetFocus(formObj.ref_no);
		     				return false;
		     			}
		     			/* Pay Term Default Value Setting */
		     			if ( ComGetObjValue(formObj.lse_pay_term_dys) == "" ) {
		     				ComSetObjValue(formObj.lse_pay_term_dys, "0");
		     			}
		     			/* Currency Valiation */
		     			if ( ComGetObjText(formObj.curr_cd) == "" ) {
		     				ComShowCodeMessage("LSE01012");
		     				ComSetFocus(formObj.curr_cd);
		     				return false;
		     			}
		     			/* DII/DIO Fee Default Value Setting */
		     			if ( ComGetObjValue(formObj.dir_itchg_fee_amt) == "" ) {
		     				ComSetObjValue(formObj.dir_itchg_fee_amt, "0");
		     			}
		     			/* Free Days Default Value Setting */
		     			if ( ComGetObjValue(formObj.lse_free_dys) == "" ) {
		     				ComSetObjValue(formObj.lse_free_dys, "0");
		     			}
		     			
		     			/* General Tab Value Check */
		     			if ( sheetObj.RowCount()> 0 ) {
		     				for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
		     					/* Container Type-Size Value Check */
		     					if ( ComTrim(sheetObj.GetCellValue(i, "cntr_tpsz_cd")) ==  "" ) {
		     						ComShowCodeMessage("LSE01015");
		     						sheetObj.SelectCell(i, "cntr_tpsz_cd");
		     						return false;
		     					}
		     					var agmtLstmCd=ComGetObjValue(combo1);
		     					/*
		     					if ( agmtLstmCd == "OW" || agmtLstmCd == "LP" || agmtLstmCd == "OL"
		     					  || agmtLstmCd == "LT" || agmtLstmCd == "OF" ) {
								if ( ComTrim(sheetObj.GetCellValue(i, "qty")) ==  "" ) {
		     							ComShowCodeMessage("LSE01014");
			     						sheetObj.SelectCell(i, "qty");
			     						return false;
		     						}
		     					}
		     					*/
		     					if ( agmtLstmCd == "LT" || agmtLstmCd == "ST"
		     					  || agmtLstmCd == "OF" || agmtLstmCd == "SB" ) {
//		     						var value=ComTrim(sheetObj.GetCellValue(i, "repl_value"));
		     						var value=sheetObj.GetCellValue(i, "repl_value");
		     						if ( value == "" || value*100 == 0 ) {
			     						ComShowCodeMessage("LSE01126");
			     						tabObjects[0].SetSelectedIndex(0);
				     					sheetObj.SelectCell(i, "repl_value");
				     					return false;
			     					}
			     				}
		     				}
		     			} else {
		     				ComShowCodeMessage("LSE01015");
		     				doActionIBSheet(sheetObj, formObj, IBINSERT);
		     				return false;
		     			}
		     			if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {
							/* Build Down Period. Valiation */
			     			if ( ComGetObjText(formObj.agmt_chg_val) == "" || ComGetObjText(formObj.bld_dwn_end_dt) == "") {
			     				ComShowCodeMessage("LSE10008");
			     				tabObjects[0].SetSelectedIndex(4);
			     				ComSetFocus(formObj.bld_dwn_end_dt);
			     				return false;
			     			}
		     			}
						break;
					
					case "t2sheet1" :
						for(var i=1;i<=sheetObjects[1].RowCount()+1;i++) {
							if(sheetObjects[1].GetCellValue(i, "eq_loc_tp_cd") == "") {
								ComShowCodeMessage("LSE10013","Level");
								return;
							}
							
							if(sheetObjects[1].GetCellValue(i, "loc_cd") == "") {
								ComShowCodeMessage("LSE10013","Place");
								return;
							}
						}	
						break;
					case "t3sheet1" :
						for(var i=2;i<=sheetObjects[2].RowCount()+1;i++) {
							if(sheetObjects[2].GetCellValue(i, "eq_loc_tp_cd") == "") {
								ComShowCodeMessage("LSE10013","Level");
								return;
							}
							
							if(sheetObjects[2].GetCellValue(i, "loc_cd") == "") {
								ComShowCodeMessage("LSE10013","Place");
								return;
							}
						}	
						break;
					case "t4sheet1" :
						for(var i=2;i<=sheetObjects[3].RowCount()+1;i++) {
							if(sheetObjects[3].GetCellValue(i, "eq_loc_tp_cd") == "") {
								ComShowCodeMessage("LSE10013","Level");
								return;
							}
							
							if(sheetObjects[3].GetCellValue(i, "loc_cd") == "") {
								ComShowCodeMessage("LSE10013","Place");
								return;
							}
						}	
						break;
					case "t4sheet2":
						for(var i=1;i<=sheetObjects[4].RowCount()+1;i++) {
							
							if(sheetObjects[4].GetCellValue(i, "loc_cd") == "") {
								ComShowCodeMessage("LSE10013","LOC");
								return;
							}
						}		
						break;
					case "t5sheet1" :
						break;
					case "t6sheet1" :
						for(var i=2;i<=sheetObjects[6].RowCount()+1;i++) {
							if(sheetObjects[6].GetCellValue(i, "cntr_tpsz_cd") == "") {
								ComShowCodeMessage("LSE10013","TP/SZ");
								return;
							}
							if(sheetObjects[6].GetCellValue(i, "eq_loc_tp_cd") == "") {
								ComShowCodeMessage("LSE10013","Level");
								return;
							}
							
							if(sheetObjects[6].GetCellValue(i, "loc_cd") == "") {
								ComShowCodeMessage("LSE10013","Place");
								return;
							}
						}		
						
						
						/* Build Down Period. Valiation */
						if ( ComGetObjValue(combo1) == "ST" || ComGetObjValue(combo1) == "LT" || ComGetObjValue(combo1) == "SI" ) {
			     			if ( ComGetObjText(formObj.agmt_chg_val) == "" || ComGetObjText(formObj.bld_dwn_end_dt) == "") {
			     				ComShowCodeMessage("LSE10008");
			     				ComSetFocus(formObj.bld_dwn_end_dt);
			     				return false;
			     			}
						}
						
						var locCheck = "";
						var inPutlocCheck = "";
						for(var i=2; i <= sheetObjects[6].LastRow(); i++){							
							locCheck=sheetObjects[6].GetCellValue(i , "cntr_tpsz_cd") + sheetObjects[6].GetCellValue(i , "eq_loc_tp_cd") + sheetObjects[6].GetCellValue(i , "loc_cd");
							
							for(var j=i+1;  j <= sheetObjects[6].LastRow(); j++){
								inPutlocCheck=sheetObjects[6].GetCellValue(j , "cntr_tpsz_cd") + sheetObjects[6].GetCellValue(j , "eq_loc_tp_cd") + sheetObjects[6].GetCellValue(j , "loc_cd");
								if(locCheck == inPutlocCheck){
									ComShowCodeMessage("LSE01165");
									return;
								}
							}
						}
						
						break;
				}
				break;
		}
		return true;
    }
   
   
   function setAgmtChgVal() {
	   var formObj=document.form;
	   var input1=ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
  		var input2=ComReplaceStr(ComGetObjValue(formObj.bld_dwn_end_dt), "-", "");
  		if(input1 !="" && input2 !="") {
  			var duration=LseComGetMonthsDateDiffNew(input1, input2);
  			if(duration < 0) {
  				duration = 0;
  			}
  			ComSetObjValue(formObj.agmt_chg_val, duration);
  			
  			sheetObjects[5].SetCellValue(1, "agmt_chg_val",ComGetObjValue(formObj.agmt_chg_val));
  		} else {
  			ComSetObjValue(formObj.agmt_chg_val, "0");
  		}
   }
   
	/**
	 * Effective Date inserting, Duration calc handling<br>
	 */
    function setDuration() {
    	var formObj=document.form;
   		var input1=ComReplaceStr(ComGetObjValue(formObj.eff_dt), "-", "");
   		var input2=ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
   		
   		
   		if(input1 !="" && input2 !="") {
   			var duration=LseComGetMonthsDateDiffNew(input1, input2);
   			ComSetObjValue(formObj.dt_drtn, duration);
   		} else {
   			ComSetObjValue(formObj.dt_drtn, "0");
   		}
  			
	
    }
	/**
	 * Effective Date Validation handling<br>
	 */
    function checkEffDate() {
    	var formObj=document.form;
		/* Effective Date Validation(eff_dt) */
		if( ComGetObjValue(formObj.eff_dt) == "" ) {
			ComShowCodeMessage("LSE01010");
			ComSetFocus(formObj.eff_dt);
			return false;
		} else if ( !ComIsDate(formObj.eff_dt) ) {
			ComShowCodeMessage("LSE01020");
			ComSetObjValue(formObj.eff_dt,"");
			ComSetFocus(formObj.eff_dt);
			return false;
		}
		/* Effective Date Validation(exp_dt) */
		if( ComGetObjValue(formObj.exp_dt) == "" ) {
			ComShowCodeMessage("LSE01011");
			ComSetFocus(formObj.exp_dt);
			return false;
		} else if ( !ComIsDate(formObj.exp_dt) ) {
			ComShowCodeMessage("LSE01026");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}
		/* Effective Date Validation(eff_dt < exp_dt) */
		var vEffDt=ComReplaceStr(ComGetObjValue(formObj.eff_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}
		return true;
    }
    
    
    
	/**
	 * Sheet Column data Duplication handling<br>
	 */
	function checkDuplicateCol(sheetObj, Row, colName, Value, Value1) {
		var formObj=document.form;
		
		if ( Value != "" ) {
			if(sheetObj.id != "t6sheet1") {
				var dupRow=sheetObj.FindText(colName, Value);
				if ( dupRow != -1 && Row != dupRow && sheetObj.GetRowStatus(dupRow) != "D" ) {
					if ( sheetObj.id == "t1sheet1" ) {
						ComShowCodeMessage("LSE01008");
						sheetObj.SetCellValue(Row, colName," ",0);
					} else if ( sheetObj.id == "t6sheet1" ) {
						/*ComShowCodeMessage("LSE01008");
						sheetObj.SetCellValue(Row, colName," ",0);
						sheetObj.RowDelete(Row, false);*/
						/*sheetObj.SetCellValue(dupRow,"agmt_chg_dys",sheetObj.GetCellValue(Row, "agmt_chg_dys"),0);
						sheetObj.SetCellValue(dupRow,"n1st_chg_amt",sheetObj.GetCellValue(Row, "n1st_chg_amt"),0);
						sheetObj.SetCellValue(dupRow,"agmt_chg_val",sheetObj.GetCellValue(Row, "agmt_chg_val"),0);
						sheetObj.SetCellValue(dupRow,"n2nd_chg_amt",sheetObj.GetCellValue(Row, "n2nd_chg_amt"),0);
						sheetObj.RowDelete(Row, false);*/
					} else if ( sheetObj.id == "t2sheet1" ) {
						if ( ComGetObjValue(combo1) == "LT" ) {
							ComShowCodeMessage("LSE01059");
						} else {
							ComShowCodeMessage("LSE01060");
						}
						sheetObj.SetCellValue(Row, colName,"",0);
					} else {
						ComShowCodeMessage("LSE01059");
						sheetObj.SetCellValue(Row, colName,"",0);
					}
				}
			}else{
				var dupRow=t6sheet1.FindText(colName, Value);
				//값이 없다면 -1 값이 있다면 이상
				if ( (dupRow != -1 && Row != dupRow && t1sheet1.GetRowStatus(dupRow) != "D")  ) {
					if(sheetObjects[6].GetCellValue(Row,"loc_cd") == sheetObjects[6].GetCellValue(dupRow,"loc_cd")) {
						ComShowCodeMessage("LSE01008");
						sheetObj.RowDelete(Row, false);
					}else{
						var dupRow1=t1sheet1.FindText(colName, Value);
						if(dupRow1 == -1) {
							ComShowCodeMessage("LSE01008");
							sheetObj.RowDelete(Row, false);
						}
					}
				}else{
					var dupRow1=t1sheet1.FindText(colName, Value);
					if(dupRow1 == -1) {
						ComShowCodeMessage("LSE01008");
						sheetObj.RowDelete(Row, false);
					}
				}
			}
		} else {
			if ( sheetObj.id == "t1sheet1" ) {
				sheetObj.SetCellValue(Row, colName," ",0);
			} else {
				sheetObj.SetCellValue(Row, colName,"",0);
			}
		}
	}
	/**
	 * Container Spec No. Cell Control
	 * - Lease Term == 'LT' & 'ST' & 'SI' , Genearl Data  Spec No. inserting.
	 */
	function control_Spec_No(code) {
		var sheetObj=sheetObjects[0];
		if ( code == "LT" || code == "ST"  || code == "SI" ) {
			sheetObj.SetColHidden("cntr_spec_no",0);
		} else {
			sheetObj.SetColHidden("cntr_spec_no",1);
		}
	}
	/**
	 * Per-diem Location/No. of TEU Cell Control
	 * - Lease Term == 'LT' , Per-diem Data Location inserting.
	 * else  No. of TEU inserting.
	 */
	function control_Loc(code) {
		var formObj=document.form;
		if ( ComGetObjValue(combo1) == "LT" ) {
			sheetObjects[1].SetColHidden("agmt_chg_val",1);
			sheetObjects[1].SetColHidden("eq_loc_tp_cd",0);
			sheetObjects[1].SetColHidden("loc_cd",0);
		} else {
			sheetObjects[1].SetColHidden("agmt_chg_val",0);
			sheetObjects[1].SetColHidden("eq_loc_tp_cd",1);
			sheetObjects[1].SetColHidden("loc_cd",1);
		}
	}
	
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}	
	/* end of developer job */
