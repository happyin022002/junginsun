/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2075.js
*@FileTitle  : RFA Proposal Inquiry ? Rate ? Specification
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
    // common global variables
    var LEN_OVER=false;
    var WDT_OVER=false;
    var HGT_OVER=false;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_search":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
     		//Modify Environment Setting Function's name
     		ComConfigSheet (sheetObjects[i] );
     		initSheet(sheetObjects[i],i+1);
     		//Add Environment Setting Function
     		ComEndConfigSheet(sheetObjects[i]);
     	}
    	initControl();
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
     	var sheetId=sheetObj.id;
        switch(sheetId) {
	        case "sheet1":      //hidden 
	            with(sheetObj){	            
			          var HeadTitle="stat|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|rt_seq|rat_ut_cd|cntr_len|cntr_wdt|cntr_hgt|cntr_wgt|act_cgo_len|act_cgo_wdt|act_cgo_hgt|act_cgo_wgt|cgo_spec_rmk";
			          var headCount=ComCountHeadTitle(HeadTitle);
		
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_seq" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_len" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wdt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hgt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_wgt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"act_cgo_len" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"act_cgo_wdt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"act_cgo_hgt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"act_cgo_wgt" },
			                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cgo_spec_rmk" } ];
			           
			          InitColumns(cols);
		
			          SetEditable(0);
			          SetWaitImageVisible(0);
			          SetAutoRowHeight(0);
			          SetSheetHeight(80);
	          		}

	         break;
        }
    }
    /**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.10.20
	 */
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm('focus', 'obj_focus', form);
 		axon_event.addListenerForm('blur', 'obj_blur', form);
 		axon_event.addListenerForm('keyup', 'obj_keyup', form);
 		axon_event.addListenerForm('activate', 'obj_activate', form);
 		axon_event.addListenerForm('click', 'obj_click', form);
 	}
 	/**
     * calling function in case of OnBlur event of IBMultiCombo <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
 	function obj_blur(){
 		srcName=event.srcElement.name;
 		srcValue=event.srcElement.value;
 		switch(srcName) {
 			case "act_cgo_len":
 				calcLength();
 				calcAddDeadSlot();
 				event.srcElement.value=ComAddComma2(event.srcElement, "#,###.00");
 				break;
 			case "act_cgo_wdt":
 				calcWidth();
 				calcAddDeadSlot();
 				event.srcElement.value=ComAddComma2(event.srcElement, "#,###.00");
 				break;
 			case "act_cgo_hgt":
 				calcHeight();
 				calcAddDeadSlot();
 				event.srcElement.value=ComAddComma2(event.srcElement, "#,###.00");
 				break;	
 			case "act_cgo_wgt":
 				calcWeight();
 				calcAddDeadSlot();
 				event.srcElement.value=ComAddComma2(event.srcElement, "#,###.00");
 				break;		
 		} 
 	}
 	/**
     * Calling funciton of OnKeyUp event<br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
  	function obj_keyup() {
  		 switch(event.srcElement.name) {
 			case "act_cgo_len":
 				checkPointCount(event.srcElement);
 				break;
 			case "act_cgo_wdt":
 				checkPointCount(event.srcElement);
 				break;
 			case "act_cgo_hgt":
 				checkPointCount(event.srcElement);
 				break;	
 			case "act_cgo_wgt":
 				checkPointCount(event.srcElement);
 				break;		
 		} 
  	}
  	/**
     * calling function in case of OnFocus event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
   	function obj_focus() {
   		srcName=event.srcElement.name;
  		srcValue=event.srcElement.value;
  		switch(srcName) {
  			case "act_cgo_len":
  				event.srcElement.select();
  				break;
  			case "act_cgo_wdt":
  				event.srcElement.select();
  				break;
  			case "act_cgo_hgt":
  				event.srcElement.select();
  				break;	
  			case "act_cgo_wgt":
  				event.srcElement.select();
  				break;		
  		} 
   	}
   	/**
     * calling function in case of OnActivate event. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
   	function obj_activate() {
   		srcName=event.srcElement.name;
  		srcValue=event.srcElement.value;
  		switch(srcName) {
  		case "act_cgo_len":
  				ComClearSeparator(event.srcElement);
				break;
			case "act_cgo_wdt":
				ComClearSeparator(event.srcElement);
				break;
			case "act_cgo_hgt":
				ComClearSeparator(event.srcElement);
				break;	
			case "act_cgo_wgt":
				ComClearSeparator(event.srcElement);
				break;		
		} 
    }
   	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
	function obj_click() {
		srcName=event.srcElement.name;
		srcValue=event.srcElement.value;
		switch(srcName) {
			case "measuring_unit":
				changeFormValue();
				break;
		} 
	}
	/**
     * Decimal point location validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkPointCount(event.srcElement);
     * </pre>
     * @param {object} obj Mandatory Form object
     * @return void
     * @author 
     * @version 2009.10.20
     */
   	function checkPointCount(obj) {
   		var sVal=obj.value;
   		if(sVal.indexOf(".") < 0) {
			return;
		}
   		var iPointNum="";
		var iNum=sVal;
       	iNum=sVal.split(".")[0];      // the value of Higher Digit than Decimal Point
        iPointNum=sVal.split(".")[1]; //the value of Lower Digit than Decimal point
        if(iNum.length == 0) {
        	iNum="0";
        }
        if(iPointNum.length > 2) {
			iPointNum=iPointNum.substring(0,2);
			obj.value=iNum+"."+iPointNum;
		}
   	}
   	/**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
     	switch(sAction) {
	     	case IBSEARCH:
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	      		}
	    		formObj.f_cmd.value=SEARCH;
	    		var sXml=sheetObj.GetSearchData("ESM_PRI_2075GS.do" , FormQueryString(formObj));
	    		var arrDesc=ComPriXml2Array(sXml, "rat_ut_cd|cntr_len|cntr_wdt|cntr_hgt|cntr_wgt|act_cgo_len|act_cgo_wdt|act_cgo_hgt|act_cgo_wgt|cgo_spec_rmk");
	    		sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(arrDesc != null && arrDesc.length > 0) {
					formObj.type_unit.value=arrDesc[0][0];
					formObj.type_void.value=arrDesc[0][0];
					formObj.cntr_len.value=arrDesc[0][1];
					formObj.cntr_wdt.value=arrDesc[0][2]; 
					formObj.cntr_hgt.value=arrDesc[0][3];
					formObj.cntr_wgt.value=arrDesc[0][4];
					formObj.act_cgo_len.value=arrDesc[0][5];
					formObj.act_cgo_wdt.value=arrDesc[0][6];
					formObj.act_cgo_hgt.value=arrDesc[0][7];
					formObj.act_cgo_wgt.value=arrDesc[0][8];
					formObj.cgo_spec_rmk.value=arrDesc[0][9];
				}
				calcLength();
	  			calcWidth();
	  			calcHeight();
	  			calcWeight();
	  			calcAddDeadSlot();
	  			ComOpenWait(false);
	    		break;
     	}
    }
    /**
     * Calculate length <br>
     * Length over option, Calculate Over Length. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcLength();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function calcLength() {
    	var formObj=document.form;
    	var cntrLen=formObj.cntr_len.value;
    	var actCgoLen=ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var overLen=actCgoLen - cntrLen;
    	if(overLen <= 0) {
    		LEN_OVER=false;
    		return;
    	}
    	LEN_OVER=true;
		formObj.front_len.value=ComAddComma2(ComRound(overLen/2, 2).toString(), "#,###.00");
		formObj.rear_len.value=ComAddComma2(ComRound(overLen/2, 2).toString(), "#,###.00");
    }
    /**
     * Calculate width <br>
     * Width over option, Calculate over width. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcWidth();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function calcWidth() {
    	var formObj=document.form;
    	var cntrWdt=formObj.cntr_wdt.value;
    	var actCgoWdt=ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var overWdt=actCgoWdt - cntrWdt;
    	if(overWdt <= 0) {
    		WDT_OVER=false;
    		return;
    	}
   		formObj.left_wdt.value=ComAddComma2(ComRound(overWdt/2, 2).toString(), "#,###.00");
   		formObj.right_wdt.value=ComAddComma2(ComRound(overWdt/2, 2).toString(), "#,###.00");
   		WDT_OVER=true;
    }
    /**
     * Calculate height <br>
     * Height over Option, Calculate Over height. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcHeight();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function calcHeight() {
    	var formObj=document.form;
    	var cntrHgt=formObj.cntr_hgt.value;
    	var actCgoHgt=ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var overHgt=actCgoHgt - cntrHgt;
    	if(overHgt <= 0) {
    		HGT_OVER=false;
    		return;
    	}
   		formObj.hgt.value=ComAddComma2(ComRound(overHgt, 2).toString(), "#,###.00");
   		HGT_OVER=true;
    }
    /**
     * Calculate weight <br>
     * Weight over option, Calculate over weight. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcHeight();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function calcWeight() {
    	var formObj=document.form;
    	var cntrWgt=formObj.cntr_wgt.value;
    	var actCgoWgt=ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	var overWgt=actCgoWgt - cntrWgt;
    	if(overWgt <= 0) {
    		formObj.wgt.value=".00";
    	} else {
    		formObj.wgt.value=ComAddComma2(ComRound(overWgt, 2).toString(), "#,###.00");
    	}
    }
    /**
     * The function that calculte count of dead slot <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcAddDeadSlot();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function calcAddDeadSlot() {
    	var formObj=document.form;
    	var typeUnit=formObj.type_unit.value;
    	if(HGT_OVER == true ) {
    		if(LEN_OVER == true) {
    			if(WDT_OVER == true) {
    				front_title.innerText="Front (2)";
    				rear_title.innerText="Rear (2)";
    				left_title.innerText="Left (2)";
    				right_title.innerText="Right (2)";
    				height_title.innerText="Height (1)";
    				formObj.add_dead_slot.value=8;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=17;
    				} else {
    					formObj.total_dead_slot2.value=17;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText="Front (1)";
    				rear_title.innerText="Rear (1)";
    				left_title.innerText="Left";
    				right_title.innerText="Right";
    				height_title.innerText="Height (1)";
    				formObj.left_wdt.value=".00";
    	    		formObj.right_wdt.value=".00";
    				formObj.add_dead_slot.value=2;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=5;
    				} else {
    					formObj.total_dead_slot2.value=5;
    				}
    			}
    		} else if(LEN_OVER == false) {
    			if(WDT_OVER == true) {
    				front_title.innerText="Front";
    				rear_title.innerText="Rear";
    				left_title.innerText="Left (1)";
    				right_title.innerText="Right (1)";
    				height_title.innerText="Height (1)";
    				formObj.front_len.value=".00";
    	    		formObj.rear_len.value=".00";
    				formObj.add_dead_slot.value=2;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=5;
    				} else {
    					formObj.total_dead_slot2.value=5;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText="Front";
    				rear_title.innerText="Rear";
    				left_title.innerText="Left";
    				right_title.innerText="Right";
    				height_title.innerText="Height (1)";
    				formObj.front_len.value=".00";
    	    		formObj.rear_len.value=".00";
    	    		formObj.left_wdt.value=".00";
    	    		formObj.right_wdt.value=".00";
    				formObj.add_dead_slot.value=0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=1;
    				} else {
    					formObj.total_dead_slot2.value=1;
    				}
    			}
    		}
    	} else if(HGT_OVER == false) {
    		if(LEN_OVER == true) {
    			if(WDT_OVER == true) {
    				front_title.innerText="Front (1)";
    				rear_title.innerText="Rear (1)";
    				left_title.innerText="Left (1)";
    				right_title.innerText="Right (1)";
    				height_title.innerText="Height";
    				formObj.hgt.value=".00";
    				formObj.add_dead_slot.value=4;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=8;
    				} else {
    					formObj.total_dead_slot2.value=8;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText="Front (1)";
    				rear_title.innerText="Rear (1)";
    				left_title.innerText="Left";
    				right_title.innerText="Right";
    				height_title.innerText="Height";
    				formObj.left_wdt.value=".00";
    	    		formObj.right_wdt.value=".00";
    				formObj.hgt.value=".00";
    				formObj.add_dead_slot.value=0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=2;
    				} else {
    					formObj.total_dead_slot2.value=2;
    				}
    			}
    		} else if(LEN_OVER == false) {
    			if(WDT_OVER == true) {
    				front_title.innerText="Front";
    				rear_title.innerText="Rear";
    				left_title.innerText="Left (1)";
    				right_title.innerText="Right (1)";
    				height_title.innerText="Height";
    				formObj.front_len.value=".00";
    	    		formObj.rear_len.value=".00";
    	    		formObj.hgt.value=".00";
    				formObj.add_dead_slot.value=0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=2;
    				} else {
    					formObj.total_dead_slot2.value=2;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText="Front";
    				rear_title.innerText="Rear";
    				left_title.innerText="Left";
    				right_title.innerText="Right";
    				height_title.innerText="Height";
    				formObj.front_len.value=".00";
    	    		formObj.rear_len.value=".00";
    	    		formObj.left_wdt.value=".00";
    	    		formObj.right_wdt.value=".00";
    	    		formObj.hgt.value=".00";
    				formObj.add_dead_slot.value=0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value=0;
    				} else {
    					formObj.total_dead_slot2.value=0;
    				}
    			}
    		}
    	}
    }
    /**
     * Mapping data from form to sheet <br>
     * <br><b>Example :</b>
     * <pre>
     *    mappingFormToSheet(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function mappingFormToSheet(sheetObj) {
    	var formObj=document.form;
    	var actCgoLen=ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var actCgoWdt=ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var actCgoHgt=ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var actCgoWgt=ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	var cgoSpecRmk=formObj.cgo_spec_rmk.value;
    	if(ComGetObjValue(formObj.measuring_unit) == "M") {
    		sheetObj.SetCellValue(1, "act_cgo_len"	,actCgoLen,0);
    		sheetObj.SetCellValue(1, "act_cgo_wdt"	,actCgoWdt,0);
    		sheetObj.SetCellValue(1, "act_cgo_hgt"	,actCgoHgt,0);
        	sheetObj.SetCellValue(1, "act_cgo_wgt"	,actCgoWgt,0);
        	sheetObj.SetCellValue(1, "cgo_spec_rmk"	,cgoSpecRmk,0);
    	} else if(ComGetObjValue(formObj.measuring_unit) == "I") {
    		sheetObj.SetCellValue(1, "act_cgo_len"	,ComAddComma2(ComRound(actCgoLen/3.28, 2).toString(), "#,###.00"),0);
    		sheetObj.SetCellValue(1, "act_cgo_wdt"	,ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00"),0);
    		sheetObj.SetCellValue(1, "act_cgo_hgt"	,ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00"),0);
        	sheetObj.SetCellValue(1, "act_cgo_wgt"	,ComAddComma2(ComRound(actCgoWgt/2.2, 2).toString(), "#,###.00"),0);
        	sheetObj.SetCellValue(1, "cgo_spec_rmk"	,cgoSpecRmk,0);
    	}
    }
    /**
     * Modify value of form <br>
     * Modify the variance depend on selected basic. <br>
     * <br><b>Example :</b>
     * <pre>
     *    changeFormValue();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function changeFormValue() {
    	var formObj=document.form;
    	var cntrLen=formObj.cntr_len.value;
    	var cntrWdt=formObj.cntr_wdt.value;
    	var cntrHgt=formObj.cntr_hgt.value;
    	var cntrWgt=formObj.cntr_wgt.value;
    	var actCgoLen=ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var actCgoWdt=ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var actCgoHgt=ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var actCgoWgt=ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	if(ComGetObjValue(formObj.measuring_unit) == "M") {
    		len_title.innerText="Length(mm)";
    		wdt_title.innerText="Width(mm)";
    		hgt_title.innerText="Height(mm)";
    		wgt_title.innerText="Weight(kg)";
    		formObj.cntr_len.value=ComRound(cntrLen/3.28, 2);
    		formObj.cntr_wdt.value=ComRound(cntrWdt/3.28, 2);
    		formObj.cntr_hgt.value=ComRound(cntrHgt/3.28, 2);
    		formObj.cntr_wgt.value=ComRound(cntrWgt/2.2, 2);
    		if(ComIsMoneyNumber(actCgoLen), true, true) {
    			formObj.act_cgo_len.value=ComAddComma2(ComRound(actCgoLen/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWdt), true, true) {
    			formObj.act_cgo_wdt.value=ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoHgt), true, true) {
    			formObj.act_cgo_hgt.value=ComAddComma2(ComRound(actCgoHgt/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWgt), true, true) {
    			formObj.act_cgo_wgt.value=ComAddComma2(ComRound(actCgoWgt/2.2, 2).toString(), "#,###.00");
    		}
    	} else if(ComGetObjValue(formObj.measuring_unit) == "I") {
    		len_title.innerText="Length(foot)";
    		wdt_title.innerText="Width(foot)";
    		hgt_title.innerText="Height(foot)";
    		wgt_title.innerText="Weight(lbs)";
    		formObj.cntr_len.value=ComRound(cntrLen*3.28, 2);
    		formObj.cntr_wdt.value=ComRound(cntrWdt*3.28, 2);
    		formObj.cntr_hgt.value=ComRound(cntrHgt*3.28, 2);
    		formObj.cntr_wgt.value=ComRound(cntrWgt*2.2, 2);
    		if(ComIsMoneyNumber(actCgoLen), true, true) {
    			formObj.act_cgo_len.value=ComAddComma2(ComRound(actCgoLen*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWdt), true, true) {
    			formObj.act_cgo_wdt.value=ComAddComma2(ComRound(actCgoWdt*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoHgt), true, true) { 
    			formObj.act_cgo_hgt.value=ComAddComma2(ComRound(actCgoHgt*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWgt), true, true) {
    			formObj.act_cgo_wgt.value=ComAddComma2(ComRound(actCgoWgt*2.2, 2).toString(), "#,###.00");
    		}
    	}
    	calcLength();
		calcWidth();
		calcHeight();
		calcWeight();
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory  
     * @return void
     * @author 
     * @version 2009.10.20
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	    	case IBSEARCH:			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" || formObj.cmdt_hdr_seq.value == "" || formObj.rout_seq.value == "" || formObj.rt_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
				return true;
				break;
    	}	
		return true;
    }
