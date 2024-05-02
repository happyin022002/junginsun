/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1002.js
*@FileTitle  : Pre-Hold Notice Setup copy Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Copy":
            	doActionIBSheet(sheetObject1, formObject, IBSAVE);
            	break;
            case "btn_Close":
            	ComClosePopup(); 
            	break;
            }
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items <br>
     * defining list on the top of source <br>
     * 
     * @param {IBSheet} sheet_obj mandatory, IBSheet control
     * @return 
     */
   function setSheetObject(sheet_obj){
      sheetObjects[sheetCnt++]=sheet_obj;
   }
   /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen. <br>
    * 
    * @return 
    */
   function loadPage() { 
       for(var i=0;i<sheetObjects.length;i++) {
           initSheet(sheetObjects[i],i+1);
       }       
   	    initControl();
   	    document.form.ofc_cd.focus();
   }
    function initControl() {
       axon_event.addListenerFormat("keypress","obj_KeyPress", form);
    }
    /**
     * handling sheet process <br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {object}  formObj  mandatory,HTML Form object
     * @param {string}  sAction  mandatory,Action name 
     * @return 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        case IBSAVE:
        	if (validateForm(sheetObj,formObj,sAction) == false) return; 
        	ComOpenWait(true);
            // exist check
        	formObj.f_cmd.value=SEARCH01;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_1002GS.do", FormQueryString(formObj));
	        if (ComGetEtcData(sXml, "exist") == "yes") {
	        	if (ComShowCodeConfirm("BKG00343") == false) {
	        		ComOpenWait(false);
	        		break;
	        	}
	        }
            formObj.f_cmd.value=MULTI;
            var sParam=FormQueryString(formObj);
            var sXml=sheetObj.GetSaveData("ESM_BKG_1002GS.do", sParam);
            sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
        	break;
        }
    }
    /**
     * setting sheet initial values and header<br>
     * adding case as numbers of counting sheets <br>
     * 
     * @param {ibsheet} sheetObj mandatory, IBSheet object
     * @param {number}  sheetNo  mandatory, IBSheet object no
     * @return 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        // Word Information
        case "sheet1":
        	with (sheetObj) {
	            var HeadTitle1="status";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	             
	            InitColumns(cols);
	            SetEditable(1);
	            SetVisible(false);
        	}
        	break;
        }
    }
    /**
     * Save Complete Event handling <br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {string}  ErrMsg   selection,err Msg
     * @return 
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") { 
    		ComShowCodeMessage("BKG00102");
    		var obj=new Object();
    		obj.ofc_cd=document.form.ofc_cd.value;
    		obj.pod_cd=document.form.pod_cd.value;
    		window.returnValue=obj;
    		ComClosePopup(); 
    	}
    }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj mandatory,IBSheet object
     * @param {object}  formObj  mandatory,HTML Form object
     * @param {string}  sAction  mandatory,Action name 
     * @return boolean Form object
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
       	switch(sAction) {
       	    case IBSAVE:
           		if (!ComChkValid(formObj)) return false;
           		if ( (fm_ofc_cd.value == ofc_cd.value) && 
           			 (fm_pod_cd.value == pod_cd.value)){
           			ComShowCodeMessage("BKG00488");
           			return false;
           		}
           		break;
       	    }
        }
        return true;
    }
	/* Developer Work End */