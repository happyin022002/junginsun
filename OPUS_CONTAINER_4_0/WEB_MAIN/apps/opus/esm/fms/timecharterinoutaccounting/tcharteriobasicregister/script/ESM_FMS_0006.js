/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0006.js
*@FileTitle  : Owner list
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
    * @extends 
    * @class Owner list : Owner list definition of biz script for creation screen
    */
    function esm_fms_0006() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    //no support[check again]CLT 	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	//  common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					ComResetAll();
					sheetObject.RemoveAll();
                break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
				case "btn_savetofile":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}	
                break;
				case "btn_print":
					alert("btn_print");
                break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "ownr_nm");
                break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, "ownr_nm");
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
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
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Handling Sheet1 OnLoadFinish Event
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "flet_ownr_tp_cd");
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
        //Axon Event Handling1. Event catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form Code Handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form Code Handling to onkeypress Event of All Controls having dataformat attribute
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "flet_ownr_tp_cd");
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
           case 1:     //sheet1 init
        	      with(sheetObj){
		               
		            var HeadTitle="|Sel|Seq|Seq|Head Ownership Name|Owner Type";
		
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ownr_seq" },
		                {Type:"Text",      Hidden:0,  Width:520,  Align:"Left",    ColMerge:0,   SaveName:"ownr_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		                {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"flet_ownr_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		            InitColumns(cols);
		            SetEditable(1);
		            SetSelectionMode(smSelectionRow);
//		            SetSheetHeight(530);
		            resizeSheet();
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
    function doActionIBSheet(sheetObj,formObj,sAction,col) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
        		formObj.f_cmd.value=SEARCH;
        		sheetObj.DoSearch("ESM_FMS_0006GS.do", FormQueryString(formObj) );
                break;
           	case IBSAVE:        
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESM_FMS_0006GS.do", FormQueryString(formObj));
                break;
			case IBROWSEARCH:   
				if (col == "flet_ownr_tp_cd") {//Owner Type
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("ESM_FMS_0006GS.do" , FormQueryString(formObj));
		   			var comboCode=ComGetEtcData(sXml, "comboCode");
		   			var comboText=ComGetEtcData(sXml, "comboText");
		   			if(typeof comboCode == "undefined") {
	    				comboCode="";
	    				comboText="";
	    			}
	    			setMakeCombo(sheetObj, comboText, comboCode, col);
	    		}	
        }
    }
     /**
     * Making Type Combo box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   name of Type
     * @param {String}  comboCode   code of Type
     * @param {int}  	col   		column index
     **/
    function setMakeCombo(sheetObj, comboText, comboCode, col) {
    	if(comboText != "" ) {
    		var typeText=comboText.substring(0,comboText.length-1);
    		var typeCode=comboCode.substring(0,comboCode.length-1);
        	sheetObj.SetColProperty(col, {ComboText:typeText, ComboCode:typeCode} );
    	}
    }
     /**
      * Handling process for input validation
      */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//           if (!isNumber(formObj.iPage)) {
//              return false;
//           }
        }
        return true;
    }
	function sheet1_OnPopupClick(sheetObj, Row,Col)
	{
		alert("Popup_Click");
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
