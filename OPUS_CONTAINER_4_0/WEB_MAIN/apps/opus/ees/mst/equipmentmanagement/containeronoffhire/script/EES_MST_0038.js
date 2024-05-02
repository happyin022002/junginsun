/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0038.js
*@FileTitle  : Sales Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0038 : business script for ees_mst_0038
     */
// common static variable
var sheetObjects=new Array();
var sheetCnt=0;
// Combo Object Array
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
		        var sheetObject1=sheetObjects[0];
	            var formObject=document.form;
        /*******************************************************/
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
							case "btn_retrieve":
								// mandatory Check  
								if(!checkItem(formObject)) return;
								doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
							break;
							case "btn_new":
			   				    ComResetAll();
								sheetObject1.RemoveAll();
							break;
							case "btn_ok":
								if(sheetObject1.RowCount()== 0){
									ComClosePopup(); 
								}else{
									comPopupOK();
								}
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
	  * mandatory checking
	  */
	function checkItem(formObj){
		var inputYn='N'
		if( formObj.cntr_no.value.trim().length == 0  &&
			formObj.de_yrmon.value.trim().length == 0 &&
			comboObjects[0].GetSelectText()== '')
		{
			ComShowCodeMessage("MST02019");
			return false;
		}
		if(formObj.de_yrmon.value.trim().length > 0 && formObj.de_yrmon.value.trim().length < 4){
			ComShowCodeMessage("MST01019", formObj.de_yrmon.value.trim());
			formObj.de_yrmon.value='';
			formObj.de_yrmon.focus();
			return false;
		}
		return true;
	}
    /**
     * registering IBsheet Object as list
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
        //IBsheet initailizing하기
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
 		for ( k=0 ; k < comboObjects.length ; k++ ) {
 	        initCombo(comboObjects[k], k+1);
 	    }
		initControl();
    }
      /**
       * initControl
      */      
  	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress',	form);				//- when key down
		axon_event.addListener('keypress', 'cntr_no_keypress', 'cntr_no');
		axon_event.addListener("change", "de_yrmon_change","de_yrmon");
		axon_event.addListener("change", "cntr_no_change","cntr_no");
	}
    /**
     * obj_keypress
    */   
 	function obj_keypress(){
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
         	case "int":
    	        //number inserting
				ComKeyOnlyNumber(event.srcElement);
    	        break;
	    }        
	}
    /**
     * cntr_no_keypress
    */   	
	function cntr_no_keypress(){
		var formObj=document.form;
		if(formObj.cntr_no.value.trim().length == 10){
			ComSetFocus(formObj.de_yrmon);
		}
	}
    /**
     * cntr_no_change
    */  
	function cntr_no_change(){
		var formObj=document.form;
		if(formObj.cntr_no.value.trim().length != 10){
			ComShowCodeMessage("MST01020", formObj.cntr_no.value.trim());
			ComSetFocus(formObj.cntr_no);
			return;
		}
	}
    /**
     * de_yrmon_change
    */   	
	function de_yrmon_change() {
		var formObj=document.form;
		if(formObj.de_yrmon.value.trim().length > 0){		
			if(!ComIsNumber(formObj.de_yrmon)){
				ComShowCodeMessage("MST01019", formObj.de_yrmon.value.trim());
				formObj.de_yrmon.value='';
				formObj.de_yrmon.focus();
				return;
			}
		}
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
            case "sheet1":      // t1sheet1 init
                with(sheetObj){
               
              var HeadTitle1="|Lot No|AGMT No|Serial Range";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sStatus" },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"lot_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"serial_range",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"de_yrmon",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lot_pln_yr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lot_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lot_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lot_cntr_pfx_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_ser_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_ser_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(0); 
              SetSheetHeight(380);
                    }


                break;
        }
    }
  	/**
  	 * setting combo initial values and header
  	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
  	 * 
  	 */
  	function initCombo(comboObj, comboNo) {
  	    switch(comboObj.options.id) {
  	        case "combo1":
  	        	with(comboObj) {
  	            	SetDropHeight(200);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetMultiSeparator(",");
  	            	SetBackColor("white");
  	            }
  	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
  	        	break;
  	    }
  	}
  // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if (sheetObj.id == "sheet1")
				{
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					formObj.f_cmd.value=SEARCH;
 	 				xml=sheetObj.GetSearchData("EES_MST_0038GS.do", FormQueryString(formObj));
            		sheetObj.LoadSearchData(xml,{Sync:1} );
            		ComOpenWait(false);
				}
				break;
			case IBCREATE:
	      		formObj.f_cmd.value=SEARCH02;
	         	sheetObj.SetWaitImageVisible(0);
 	         	var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(1);
    			var chk=sXml.indexOf("ERROR");
    			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    			   sheetObj.LoadSearchData(sXml,{Sync:1} );
    			   return;
    			}		        
	            if ( sXml != "" ) {
		            var sCntrTpSzNm=ComGetEtcData(sXml,"cntr_tpsz_nm");
		            var sCntrTpSzCd=ComGetEtcData(sXml,"cntr_tpsz_cd");
		            var arrCntrTpSzNm=sCntrTpSzNm.split("|");
		            var arrCntrTpSzCd=sCntrTpSzCd.split("|");
		      		comboObjects[0].InsertItem(0, "", "");
		            MstMakeComboObject(comboObjects[0], arrCntrTpSzNm, arrCntrTpSzCd);
		            // setting default value
//		            comboObjects[0].Index = 0; 
		      		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObjects[0]);
	            }
	            break;					
        }
    }
    /**
     * handling double click event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnDblClick(SheetObj, Row, Col)
	{   
		if(sheetObj.RowCount()== 0){
			ComClosePopup(); 
		}else{
			comPopupOK();
		}
	}
	/**
  	 * combo1_OnChange
  	 */
  	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
  		var formObj=document.form;
  		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
  	}
  	/**
  	 * combo1_OnKeyDown
  	 */
  	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
  		with(comboObj) {
  			if ( KeyCode == 8 || KeyCode == 46 ) {
  				for ( i=0 ; i < GetItemCount() ; i++ ) {
  					if ( CheckIndex(i) ) {
  						CheckIndex(i)=false;
  					}
  				}
  			}
  		}
  	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        /*
        with(formObj){
            if (!isNumber(formObj.iPage)) {
                return false;
            }
        */
        return true;
    }
