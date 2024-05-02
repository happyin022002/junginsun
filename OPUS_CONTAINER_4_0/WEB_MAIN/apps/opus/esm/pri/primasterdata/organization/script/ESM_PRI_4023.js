/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4023.js
*@FileTitle  :  Office Code Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24

=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_4023 : Business Script for ESM_PRI_4023
     */
    function ESM_PRI_4023() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // common global variables
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
     * @version 2009.08.24
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         try {
        	 var srcName=ComGetEvent("name");
        	 if(ComGetBtnDisable(srcName)) return false;
        	 switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowCodeMessage(e);
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
     * @version 2009.08.24
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
     * @version 2009.08.24
     */
    function loadPage() {
    	for (i=0; i < sheetObjects.length; i++) {
 			// Modify Enviroment Setting Function's name
 			ComConfigSheet(sheetObjects[i]);
 			initSheet(sheetObjects[i], i + 1);
 			// Add Environment Setting Function 
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
     * @version 2009.08.24
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with (sheetObj) {
                var HeadTitle1="Seq.|Code|Description|Type|Location|Parent";
                (6, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Seq",       Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:1,   SaveName:"ofc_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
                 
                InitColumns(cols);

                SetEditable(0);
                SetWaitImageVisible(0);
                SetAutoRowHeight(0);
                resizeSheet();//SetSheetHeight(462);
			}
			break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }
    /**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.08.24
	 **/
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm('keypress', 'obj_keypress', form);
// 		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
 	}
 	
 	/**
 	 * HTML Control KeyPress event
 	 **/
 	function obj_keypress() {
 		obj=ComGetEvent();
 		 if ((ComGetEvent("keycode") == 13) && (ComGetEvent("name") == "ofc_cd")) {
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @version 2009.08.24
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
 				sheetObj.DoSearch("ESM_PRI_4023GS.do", FormQueryString(formObj) );
 				ComOpenWait(false);
 				break;
     	}
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.08.24
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
  	 		case IBSEARCH:
  	 			if(!ComIsNull(formObj.ofc_cd.value) && formObj.ofc_cd.value.length < 2) {
  	 				ComShowCodeMessage('PRI04004', 'Code', '2', '6');
  	 				formObj.ofc_cd.focus();
  	 				return false;
  	 			}
  	 			return true;
  	 			break;
     	}
     	return true;
     }
