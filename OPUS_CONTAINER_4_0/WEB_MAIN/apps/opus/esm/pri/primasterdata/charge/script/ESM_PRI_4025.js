/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4025.js
*@FileTitle  : Charge Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // Global Variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
    // Define Event Handler that receive & process button click event 
    document.onclick=processButtonClick;
    /**
     * Event Handler : Define the Flow Control of process using button name
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function processButtonClick(){
        /***** When the number of sheet is two or more on each tab, additional sheet variable should be defined */ 
        var sheetObject0=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;
        	switch(srcName) {
        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
     * Register IBSheet Object as item of array 
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory, IBSheet Object
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Register IBMultiCombo Object as item of array 
     * Afterward, when other items should be process in batch, you could add process putting in array 
     * the array defined at the top of this page
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory, IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
    
    /**
     * Initialize and basic option setting Sheet
     * Implement body tag's onLoad event handler 
     * Adding the code that should be preprocessed after loading the screen in browser.
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function loadPage() {
    	for (i=0; i < sheetObjects.length; i++) {
 			// Modifying the Environment setting function name
 			ComConfigSheet(sheetObjects[i]);
 			initSheet(sheetObjects[i], i + 1);
 			// Adding the Environment Setting function
 			ComEndConfigSheet(sheetObjects[i]);
 		}
    	// IBMultiCombo Initialize
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}

    	initControl();
    	initIBComboItem();
 		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
    
    /**
     * Sheet Initialize, Header Definition
     * When Sheet is plural, compose sheet initialize module via adding case-statement
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, Sequence No. of IBSheet Object Tag ID
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
        	case "sheet0":
        		with (sheetObj) {
        			SetVisible(false);
                }
        		break;
            case "sheet1":
                with(sheetObj){
            		SetColProperty("rep_chg_cd", {ComboText:repChgCdText, ComboCode:repChgCdValue} );
            		SetColProperty("frt_chg_tp_cd", {ComboText:frtChgTpCdText, ComboCode:frtChgTpCdValue} );
            		SetColProperty("chg_rev_tp_cd", {ComboText:chgRevTpCdText, ComboCode:chgRevTpCdValue} );
            		SetColProperty("chg_aply_tp_cd", {ComboText:chgAplyTpCdText, ComboCode:chgAplyTpCdValue} );
            		
            	    var HeadTitle1="Seq.|Code|Description|Rep.Charge|Freight/Charge Type|Revenue Class|Charge Character|"+ConstantMgr.getCompanyCode()+" Acct|Auto|Use";

            	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	    InitHeaders(headers, info);

            	    var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",             KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",          KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"chg_nm",          KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rep_chg_cd",      KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"frt_chg_tp_cd",   KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"chg_rev_tp_cd",   KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chg_aply_tp_cd",  KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"co_chg_acct_cd",  KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"auto_rat_flg",    KeyField:0 },
            	                 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",        KeyField:0 } ];
            	       
            	    InitColumns(cols);

            	    SetEditable(0);
//            	    SetCountPosition(0);
            	    SetWaitImageVisible(0);
            	    SetAutoRowHeight(0);
            	    resizeSheet();//SetSheetHeight(440);
            	}
            	break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[1]); }
    
    /**
     * Loading event of HTML control on this page dynamically.
	 * {@link #loadPage} function initialize IBSheet Object via calling this function. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.08.25
	 **/
 	function initControl() {
 		//** Date Separator **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm('keypress', 'obj_keypress', form);
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
 	}
 	
	/**
     * Setting the IBMultiCombo Object using combo item that retrieved  at the open event code
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.12
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(repChgComboValue, repChgComboText, getComboObject(comboObjects, 'rep_chg_cd'),"|","\t");
        ComPriTextCode2ComboItem(frtChgTpComboValue, frtChgTpComboText, getComboObject(comboObjects, 'frt_chg_tp_cd'),"|","\t");
        ComPriTextCode2ComboItem(chgRevTpComboValue, chgRevTpComboText, getComboObject(comboObjects, 'chg_rev_tp_cd'),"|","\t");
        ComPriTextCode2ComboItem(chgAplyTpComboValue, chgAplyTpComboText, getComboObject(comboObjects, 'chg_aply_tp_cd'),"|","\t");
    }
    
 	/**
     * The function called when OnKeyPress event triggered
     * It makes onKeyPress event of HTML Controls could accept specified key value <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.25
     */
 	function obj_keypress() {
 		 switch (event.srcElement.name) {
 			case "chg_cd":
 				ComKeyOnlyAlphabet('upper');
 				break;
 		}
 	}
 	
 	/**
     * Operate Sheet Process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {form} formObj Mandatory, html form object
     * @param {int} sAction Mandatory, Process Flag Constant
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
     	sheetObj.ShowDebugMsg(false);
     	switch(sAction) {
     		case IBSEARCH:
     			ComOpenWait(true);
     			if (!validateForm(sheetObj, formObj, sAction)) {
     				ComOpenWait(false);
     				return false;
 	      		}
 				formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
 				sheetObj.DoSearch("ESM_PRI_4025GS.do", FormQueryString(formObj) );
 				ComOpenWait(false);
 				break;
     	}
    }
    
    /**
	 * Combobox Initialize, Header Definition
     * When Combobox is plural, compose combobox initialize module via adding case-statement <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory, IBMultiCombo Object
     * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID 
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "rep_chg_cd":
				var i=0;
				with (comboObj) {
					SetDropHeight(300);
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
				}
				break;
			case "frt_chg_tp_cd":
				var i=0;
				with (comboObj) {
					SetDropHeight(232);
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
				}
				break;
			case "chg_rev_tp_cd":
				var i=0;
				with (comboObj) {
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
				}
				break;
			case "chg_aply_tp_cd":
				var i=0;
				with (comboObj) {
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
				}
				break;
		}
	}
    
    /**
     * Operate validation process on user input value of form object <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, HTML Tag Object
     * @return void
     * @author 
     * @version 2009.08.25
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
  	 		case IBSEARCH:
  	 			if(!ComIsNull(formObj.chg_cd.value) && formObj.chg_cd.value.length < 2) {
  	 				ComShowCodeMessage('PRI04004', 'Code', '2', '3');
  	 				formObj.chg_cd.focus();
  	 				return false;
  	 			}
  	 			return true;
  	 			break;
     	}
     	return true;
     }