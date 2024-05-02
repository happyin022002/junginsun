/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0078.jsp
*@FileTitle  : Offhire Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn1_Confirm":
            		comPopupOK();
                    break;
            	case "btn1_Close":
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
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
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
			case 1:      //sheet1 init
				with(sheetObj){	        
		       
		        //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		        var HeadTitle="||Offhire Duration|Accident Type";

		        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);

		        var cols = [ {Type:"Radio",     Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"radio",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"check",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"duration",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"flet_offh_rsn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flet_offh_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bunker_vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"from_time",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_time",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_usd_dys",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		         
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
     * @param {String}  gubun     	 gubun value
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		formObj.f_cmd.value=SEARCH;
     			sheetObj.DoSearch("ESM_FMS_0078GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	Inserted value of sheetObj
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
     * Event occurred after Searching <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} ErrMsg     	ErrorMessage
     **/
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
     	var irow=sheetObj.LastRow();
     	sheetObj.GetRowMerge(irows);
    }
