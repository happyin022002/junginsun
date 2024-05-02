/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0070.js
*@FileTitle  : Vendor Customer Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
	// common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
     var sheetObject=sheetObjects[0];
     var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
				case "btn_retrieve":
					var tmpAgmtFlg = formObject.agmt_flag.value;
					var tmpCondFlag = formObject.cond_flag.value;
					if(tmpAgmtFlg != "C" || tmpCondFlag == "CM" || tmpCondFlag == "VM" ){
						if (formObject.search_name.value.length < 3) {
							ComAlertFocus(formObject.search_name, ComGetMsg('FMS01331'));
							return;
						}
					}
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
				case "btn_confirm":
					comPopupOK();
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    }
	  /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
        //Axon Event Handling1. Event catch
        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    	var formObj = document.form;
    	var tmpAgmtFlg = formObj.agmt_flag.value;
    	var tmpCondFlag = formObj.cond_flag.value;
        if(tmpAgmtFlg != "C" || tmpCondFlag == "CM" || tmpCondFlag == "VM" ){
        	formObj.search_name.className="input1";
        }

    	formObj.search_name.focus();
    	
        //Hiding National Code Column in case of Vendor
        if (formObj.cond_flag[0].checked) {
        	sheetObjects[0].SetColHidden("cd_cnt",1);
    	}	
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
            case 1:      //sheet1 init
                with(sheetObj){
		              var HeadTitle="||Seq|Vendor/Customer\nName|Vendor/Customer\nCode|Vendor/Customer\nCode";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [
		                     //UI개선(201408 민정호)     
		                     {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     //UI개선(201408 민정호)		                     
		                     {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"check",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cd_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cd_cnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(240);
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
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
        			sheetObj.DoSearch("ESM_FMS_0070GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
        		}
        		break;
        }
    }
    /**
     * Handling process for input validation<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj insert value
     * @return {boolean} bool
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
     /**
      * In case of Clicking Popup on IBSheet Object
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	}	
