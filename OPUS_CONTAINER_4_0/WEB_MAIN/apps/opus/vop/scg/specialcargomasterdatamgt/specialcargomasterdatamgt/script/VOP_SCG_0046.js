/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vms_scg_0046.js
*@FileTitle  : No. & Symbols in SEG Table/Mixed STWG (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vms_scg_0046 : business javascript for vms_scg_0046 
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
				case "btn_RowAdd":
					var row=sheetObject.DataInsert(-1);
					sheetObject.SetCellValue(row,"imdg_segr_tp_cd",ComGetObjValue(imdg_segr_tp_cd));
					sheetObject.SelectCell(row, 2);
					break;
				case "btn_RowInsert":
					var row=sheetObject.DataInsert();
					sheetObject.SetCellValue(row,"imdg_segr_tp_cd",ComGetObjValue(imdg_segr_tp_cd));
					sheetObject.SelectCell(row, 2);
					break; 
				case "btn_RowCopy":
					var row=sheetObject.DataCopy();
					sheetObject.SelectCell(row, 2);
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject, "del_chk");
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         sheet1_OnLoadFinish(sheet1);
     }
     function sheet1_OnLoadFinish(sheetObj) {
         //Initializing html control event
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
         	case 1:      //t1sheet1 init
         		with (sheetObj) {
	                var HeadTitle="|Sel.|No.|Numbers & symbols|Description";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           Wrap:1 },
	                       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE",             Wrap:1 },
	                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1,     Wrap:1, InputCaseSensitive:1 },
	                       {Type:"Text",      Hidden:0,  Width:640,  Align:"Left",    ColMerge:1,   SaveName:"imdg_segr_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:350,   Wrap:1 },
	                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"imdg_segr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	                       {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } ];
	                 
	                InitColumns(cols);
	     			SetEditable(1);
	                //SetSheetHeight(420);
	     			resizeSheet();
                }
         		break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	      	case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
		        		formObj.f_cmd.value=SEARCH;
		        		sheetObj.DoSearch("VOP_SCG_0046GS.do", FormQueryString(formObj) );
					}
				}			
	    	   	break;
			case IBSAVE:        //save
	 			if(!validateForm(sheetObj,formObj,sAction))return;
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
        		formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("VOP_SCG_0046GS.do", FormQueryString(formObj), '-1', false);
				break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	if (sAction == IBSAVE) {
 			var dupRow = sheetObj.ColValueDupRows("imdg_segr_cd", false, true);
 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.GetRowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);
				}
				return;
			}
    	}
     	return true;
     }
     function initCombo(comboObj, comboNo) {
    	 switch(comboObj.options.id) {
    	 case "imdg_segr_tp_cd":
    		 var i=0;
    		 with(comboObj) {
				 SetColWidth(0, "30");
				 SetColWidth(1, "470");
    			 InsertItem(i++, "C|The general provisions for segregation between the various classes of DG",	"C");
    			 InsertItem(i++, "P|Permitted mixed stowage for goods of class 1",	"P");
    			 Code="C";
    			 SetSelectIndex(0);
    			 document.form.imdg_segr_tp_nm.value="The general provisions for segregation between the various classes of DG";
//    			 combo_OnChange(comboObj, "C|The general provisions for segregation between the various classes of DG")
    		 }
    		 break;
    	 }
     }
     //business javascript OnKeyPress event Catch
     function initControl() {
//         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	 axon_event.addListener('change', 'combo_OnChange', 'imdg_segr_tp_cd');     
     }
     /**
      * Handling business javascript OnChange event
      */
     //Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
//     function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
     function imdg_segr_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	 var formObj=document.form;
    	 if(newCode != "") {
//    		 var arrText=newCode.split("|");
    		 formObj.imdg_segr_tp_nm.value=comboObj.GetText(newCode,1);
             doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 }
     }
