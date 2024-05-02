/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0084.jsp
*@FileTitle  : E-mail List Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
	// common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
			case "btn_Confirm":
				//comPopupOK();
				var sRow=sheetObj.FindCheckedRow("check");
	    		if (sRow == "") {
	    			ComShowCodeMessage('COM12189');
	    			return;
	    		}
	    		var aryData=new Array();
	        	var idx=0;
	        	for(var i=0; i<sheetObject.LastRow();i++) {
	        		var row=i+1;
	        		if(sheetObject.GetCellValue(row,"check") == 0) {
	        			continue;
	        		}
	        		var emailData={
	        				cntc_pson_eml : ""
	        		};
	        		emailData.cntc_pson_eml=sheetObject.GetCellValue(row,"cntc_pson_eml");
	        		aryData[idx++]=emailData;
	        	}
				opener.setEmail(aryData);
				ComClosePopup(); 
				break;
	        case "btn_Close":
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
     * registering IBSheet Object as list 
  	 * adding process for list in case of needing batch processing with other items
  	 * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * adding first-served functions after loading screen. 
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
    	}
    	sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Handling Sheet1 OnLoadFinish Event
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
   /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
	    	case 1:
	    	      with(sheetObj){	           
	    		  
		    	      //no support[check again]CLT 	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		    	      var HeadTitle1="|Sel||Seq|Personal Information|E-mail Address";
		    	      var headCount=ComCountHeadTitle(HeadTitle1);
	
		    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	      InitHeaders(headers, info);
	
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		    	             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_eml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		    	       
		    	      InitColumns(cols);
	
		    	      SetEditable(1);
		    	      
		    	      SetSheetHeight(250);
	                  }
	            break;
    	}
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     * @param {String}  gubun     	gubun value
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBSEARCH:      
		        formObj.f_cmd.value=SEARCH;
 	   			sheetObj.DoSearch("ESM_FMS_0084GS.do", FormQueryString(formObj) );
	   			break;
        }
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL - Defined in CoObject.js)
     **/
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }
