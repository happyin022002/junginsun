/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0518.js
*@FileTitle  : B/L Inquiry by Container 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
 function processButtonClick(){
      /***** using extra sheet valuable if there are more 2 sheets *****/
      var sheetObject1=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_BLInquiry":
				doActionIBSheet(sheetObjects[0],formObject,IBROWSEARCH);
				break;
			case "btn_Excel":
				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				break;
		} // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
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
	//necessary event on the screen
	axon_event.addListenerForm("click","obj_click", document.form);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	if(document.form.cntr_no.value != ""){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
 }
 
  /**
   * setting sheet initial values and header
   * @param sheetObj
   * @param sheetNo
   * @return
   */
 function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
		    with(sheetObj){
			  var HeadTitle="|Seq.|B/L No.|VVD|B/L Type|ETA|POD|DEL|HUB|P/MIB No.|Type|F|O|C";
			  var headCount=ComCountHeadTitle(HeadTitle);
			
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);
			
			  var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
							 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mf_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },							 
							 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibd_trsp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"f_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"c_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			   
			  InitColumns(cols);
			
			  SetEditable(0);
			  SetColProperty("vps_eta_dt", {Format:"####-##-####:##"} );
//			  SetSheetHeight(360);
			  ComResizeSheet(sheetObj);
            }


			break;
	}
}
 
 /**
  * handling data in case of clicking sheet
  */
 function sheet1_OnClick(sheetObj, row, col, val){
	 if(sheetObj.GetCellValue(row, "bl_no") != ""){
		 document.form.bl_no.value=sheetObj.GetCellValue(row, "bl_no");
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
     //sheetObj.ShowDebugMsg = false;
	 sheetObj.SetWaitImageVisible(0);
     switch(sAction) {
        case IBSEARCH:      //retrieve
    	    if(!validateForm(sheetObj,formObj,sAction)) return false;
    		ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0518GS.do", FormQueryString(formObj) );
    		ComOpenWait(false);
            break;
        case IBROWSEARCH:   //B/L Inquiry
        	if ( document.form.bl_no.value == "" ) { 
        		ComShowCodeMessage("BKG04007","Please Mouse-Click One B/L No in the list");
        		return false;
        	}
			ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=ESM_BKG_0034-03&"+FormQueryString(document.form), "ESM_BKG_0034", 1250, 700, false);
            break;
		case IBDOWNEXCEL:
    		ComOpenWait(true);
    		if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
	        }else{
	        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	        }
    		ComOpenWait(false);
			break;
     }
 }
 
 /**
  * handling process for input validation <br>
  * @param sheetObj
  * @param formObj
  * @param sAction
  * @return boolean
  */
 function validateForm(sheetObj,formObj,sAction){
	 switch (sAction) {
	    case IBSEARCH: // retrieve
	    	
	    	if (ComIsNull(formObj.cntr_no)) {
	    		ComShowCodeMessage('BKG00753','Mandatory field is missing. Please enter container no.');
	    		return false;
	    	} 
	    	
			//if(!ComChkRequired(formObj)) return false;
	    	
	        return true;
	        break;
	 }
	 return true;
 }
 
 /**
  * handling button after retrieve
  */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 if(ErrMsg == '' && sheetObj.RowCount()> 0){
		 document.form.bl_no.value=sheetObj.GetCellValue(1, "bl_no");
	 }
 }
