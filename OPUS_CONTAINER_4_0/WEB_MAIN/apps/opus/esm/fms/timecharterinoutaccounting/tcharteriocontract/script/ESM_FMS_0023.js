/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0023.js
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Contract No : Define Biz Script to retrieve Contract No
     */	
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
            switch(srcName) {
                case "btn_Retrieve":
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
        sheet1_OnLoadFinish(sheet1);
        //CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'flet_ctrt_tp_cd', 'flet_ctrt_tp_nm', '1', 'ESM_FMS_0023GS.do', '');
        //CoFmsGetCombo('FORM', document.form, sheetObjects[0], 'CD01513', 'flet_ctrt_tp_cd', 'flet_ctrt_tp_nm');
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	CoFmsGetBizCombo('FORM', document.form, sheetObj, 'flet_ctrt_tp_cd', 'flet_ctrt_tp_nm', '1', 'ESM_FMS_0023GS.do', '');
    	// NYK Modify 2014.10.17
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
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
            case 1:      //t1sheet1 init
                with(sheetObj){
//		              (5, 0, 0, true);
		              var HeadTitle="||Vessel Code|Contract No.|Vessel Name";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:94,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"vsl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
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
       // sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      //조회
        		//if(validateForm(sheetObj,formObj,sAction)){
    			formObj.f_cmd.value=SEARCH;
     			sheetObj.DoSearch("ESM_FMS_0023GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
        	   	//}
                break;
        }
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
 	function sheet1_OnChange(sheetObj,Row,Col,Value){
 		try {
	 		if(sheetObj == null || typeof(sheetObj) !="object") {
	 			return;
	 		}
	 		return;
 		} catch(e) { 
 			if( e == "[object Error]") {
    			return;
    		} else {
    			return;
    		}
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
     * Event occurred after searching by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

  	}
//	// Calculating Sum of only selected Column
//	function chkSum(sheetObj)
//	{
//		var rows = sheetObj.FindCheckedRow("HireChk") ;
//
//		var arrRow = rows.split("|");
//		var sumAmount1 = 0;
//		var amount = 0;
//
//
//		for(i=0; i < arrRow.length-1 ; i++)
//		{
//			amount = sheetObj.CellValue(arrRow[i] , "Amount1");
//			if(amount != "")
//				sumAmount1 += parseInt(amount);
//		}
//
//		sheetObj.SumValue(0,"Amount1") =sumAmount1;
//	}
