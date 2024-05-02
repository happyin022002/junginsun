/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4020.js
*@FileTitle  : Currency Code Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

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
     * @version 2009.10.09
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
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
     * @version 2009.10.09
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
     * @version 2009.10.09
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
     * @version 2009.10.09
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
	        		var HeadTitle1="Code|Description|Country Code";
	
	        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        		InitHeaders(headers, info);
	
	        		var cols = [ {Type:"Text",     Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
	        		             {Type:"Text",     Hidden:0,  Width:450,  Align:"Left",    ColMerge:1,   SaveName:"curr_desc" },
	        		             {Type:"Text",     Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd" } ];
	           
	        		InitColumns(cols);
	
	        		SetEditable(0);
//	        		SetCountPosition(0);
	        		SetWaitImageVisible(0);
	                SetAutoRowHeight(0);
	                resizeSheet();//SetSheetHeight(440);
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
 	 * @version 2009.10.09
 	 */
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm('keypress', 'obj_keypress', form);
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
 	}
 	
 	/** 
	 * Object 's Keypress Event Handler <br>
	 * Checking validtaion by object's dataformat <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2009.10.09
	 */
 	function obj_keypress() {
 		 switch (event.srcElement.name) {
 			case "curr_cd":
 				ComKeyOnlyAlphabet('upper');
 				break;
 			case "cnt_cd":
 				ComKeyOnlyAlphabet('upper');
 				break;	
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
     * @version 2009.10.09
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBSEARCH:
	        	ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
				sheetObj.DoSearch("ESM_PRI_4020GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;
        }
    }
