/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0657.js
*@FileTitle  : SC Commodity PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
		         var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
   	try {
   		var srcName=ComGetEvent("name");
           switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);								
				break; 
				case "btn_Select":
					comPopupSend(sheetObject, formObject);	
				break;
				case "btn_Close":
					ComClosePopup(); 
				break;
           } // end switch
   	}catch(e) {
   		if( e == "[object Error]") {
   			ComShowCodeMessage("COM12111");    
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
	if (parent.getSvcScpCd != undefined) {
		document.form.svc_scp_cd.value = parent.getSvcScpCd();
		document.form.ui_id.value = "ESM_BKG_0079";
	}
	if (document.form.lodg_due_dt.value != ""){
		document.form.ui_id.value = "ESM_PRI_6001";
	}
   
	initControl();
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
function initControl() {
   //axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- in case of typing keyboard
   axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
	}
/**
* setting sheet initial values and header
* @param sheetObj
* @param sheetNo
* @return
*/
   function initSheet(sheetObj,sheetNo) {
       var cnt=0;
       switch(sheetNo) {
           case 1:      //sheet1 init
        	   with(sheetObj){
	        	   var HeadTitle1="|Code|SC Description|Cmdt|HS Code Description|Scope";
	
	        	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	   InitHeaders(headers, info);
	
	        	   var cols = [ {Type:"Radio",     Hidden:0, Width:25,    Align:"Center",  ColMerge:0,   SaveName:"chk" },
	        	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"grp_cmdt_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:60,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	        	   InitColumns(cols);
	        	   SetEditable(1);
	        	   SetWaitImageVisible(0);
	        	   SetSheetHeight(240);
        	   }
               break;
       }
   }
   /**
    * handling sheet process
    * @param sheetObj
    * @param formObj
    * @param sAction
    * @return void
    */
   function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
       switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0657GS.do", FormQueryString(formObj) );
				break;
       }
   }
   
   function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		ComOpenWait(false);
   }
   
	//double click -> select
   function sheet1_OnDblClick(sheetObj , row, col) {  
  	 	var formObj=document.form;
  	 	sheetObj.SetCellValue(row,"chk","1",0);
  	 	comPopupSend(sheetObj, formObj);
   }     
   /**
   * sending screen information to main
   */     
	function comPopupSend(sheetObj, formObj){
		var calllFunc=formObj.calllFunc.value;
		var rArray=getCheckedRowByName(sheetObj,"chk");
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}else{
			if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
			else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
			ComClosePopup(); 
		}
	}     
