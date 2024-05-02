/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0059.js
*@FileTitle  : Ship Yard Registration / Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Ship Yard Select ? Pop up : Ship Yard Select ? Pop up definition of biz script for creation screen
     */
    function esm_fms_0059() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    //no support[check again]CLT 	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
    	this.initSheet=initSheet;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.checkYardSequence=checkYardSequence;
    	this.initConfirm=initConfirm;
    }
    //  common global variables 
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
     				if(!initConfirm()) return;
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
     				break;
     			case "btn_save":
     				doActionIBSheet(sheetObject,formObject,IBSAVE);
     				break;
     			case "btn_add":
					var row=sheetObject.DataInsert(-1);
     				break;
     			case "btn_ins":
					var row=sheetObject.DataInsert();
					break;
     			case "btn_del":
     				ComRowHideDelete(sheetObject, "DelChk");
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
     * Registering IBSheet Object as Array
     * In case there is needs to do batch processing, process saving as Array can be added
     * defining array on the top of source
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
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
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
         switch(sheetObj.id) {
         	case "sheet1":      //t1sheet1 init
         	    with(sheetObj){
		              var HeadTitle1="|Sel|Seq|Ship Yard Name|Ship Yard Name|Delt Yn";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"yd_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:"shp_yd_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , EditLen:50},
		                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"delt_yn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
//		              SetSheetHeight(520);
		              resizeSheet();		              
                    }
         		break;
         }
    }
    /**
     * Handling sheet process<br>
     */
 	function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch(sAction) {
 			case IBSEARCH:      
 					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_FMS_0059GS.do", FormQueryString(formObj) );
 					break;
 			case IBSAVE:        
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if(!checkYardSequence(sheetObjects[0])) return;
 					formObj.f_cmd.value=MULTI;
		  	  		sheetObj.DoSave("ESM_FMS_0059GS.do", FormQueryString(formObj));
		  	  		ComOpenWait(false);
 				}
 				break;
 			case IBINSERT:      
 				break;
 		}
 	}
 	
 	/**
     * Registering IBTabl Object as Array
     * In case there is needs to do batch processing, process saving as Array can be added
     * defining array on the top of source
     */
 	function setTabObject(tab_obj){
 		tabObjects[tabCnt++]=tab_obj;
 	}
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL)
     **/
 	function validateForm(sheetObj,formObj,sAction){
    	var row1;
    	var row2;
    	if (!ComChkValid(formObj)) return false;
    	if (sAction == IBSAVE) {
	    	for(var i=1; i<sheetObj.LastRow(); i++) {
	    		if(sheetObj.GetCellValue(i, "ibflag") == "D") {
	    			continue;
	    		}
	    		row1=sheetObj.GetCellValue(i, "shp_yd_nm");
	    		for(var j=i+1; j<=sheetObj.LastRow(); j++) {
	    			row2=sheetObj.GetCellValue(j, "shp_yd_nm");
	    			if(sheetObj.GetCellValue(j, "ibflag") == "D") {
		    			continue;
		    		}
	    			if(row1.trim() == row2.trim()) {
	    				ComShowCodeMessage("FMS00008", "shp_yd_nm");
	    				sheetObj.SelectCell(j, "shp_yd_nm");
	    				return false; 
	    			}
	    		}
	    	}
    	}
        return true;
 	}
    /**
     * Checking Yard Sequence existing<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {boolean} true : deletable, false : undeletable
     */
 	function checkYardSequence(sheetObj) {
    	for(var i=1; i<sheetObj.LastRow(); i++) {
    		if(sheetObj.GetCellValue(i, "ibflag") == "D") {
    			if(sheetObj.GetCellValue(i, "delt_yn") == "N") {
	    			ComShowCodeMessage("FMS01255");
    				//sheetObj.SelectCell(i, "shp_yd_nm");
	    			return false;
	    			break;
	    		}
    		}
    	}
        return true;
 	}
    /**
     * Checking Going ahead in case changed data is existing <br>
     **/
    function initConfirm() {
     	var okYn=true;
     	if(sheetObjects[0].IsDataModified()) {
     		var okYn=ComShowCodeConfirm("FMS00002");
     	}
     	return okYn;
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
