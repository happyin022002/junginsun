/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0744.js
*@FileTitle  : Direct NVO AMS File No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // Common global variable

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
 function processButtonClick(){
     /* */
     var sheetObject1=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_RowAdd":
				if(ComIsBtnEnable("btn_RowAdd")){
					sheetObjects[0].DataInsert(-1);
				} 					
				break;
			case "btn_Delete":
				if(ComIsBtnEnable("btn_Delete")){
					//ComRowHideDelete(sheetObject1,"del_chk");
					var iRow = sheetObject1.GetSelectRow();
					sheetObject1.SetRowHidden(iRow, 1);
					sheetObject1.SetRowStatus(iRow,"D");
				}
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_Save":
				if(ComIsBtnEnable("btn_Save")){
					validateForm(sheetObject1);
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				} 					 					
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;	
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");     
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
	var formObj=document.form;
	
	initControl();
	if(formObj.bdr_flg.value == "Y"&&formObj.ca_flg.value == "N"){
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Save");
	}
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}
 /**
  *  setting event
  */
 function initControl() {
 	var formObject=document.form;
 }
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="||House B/L No.|SCAC|Piece";
				var headCount=ComCountHeadTitle(HeadTitle1);
	
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Radio", 	Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"usa_cstms_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"scac_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"E|N", InputCaseSensitive:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
				 
				InitColumns(cols);
	
				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetSheetHeight(162);
			}


			break;
		}
}
// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
      case IBSEARCH:      //retrieve
	   	 formObj.f_cmd.value=SEARCH;
	   	 var sXml=sheetObj.DoSearch("ESM_BKG_0744GS.do" , FormQueryString(formObj));
   	 break;
      case IBSAVE:        //
       	formObj.f_cmd.value=MULTI;
      		var params=FormQueryString(formObj)
      		params=params + "&" + sheetObj.GetSaveString(true);
      		var sXml=sheetObj.GetSaveData("ESM_BKG_0744GS.do", params);
      		sheetObj.LoadSaveData(sXml);
			break;
    }
}

/*
 * handling process for input validation
 */
function validateForm(sheetObj){
	 for ( i=sheetObj.LastRow(); i > 0 ; i-- ){
		 if(ComIsNull(sheetObj.GetCellValue(i, "usa_cstms_file_no"))){
			 sheetObj.RowDelete(i,false);
		 }
	 }    	 
}   
/**
 * sheet1 OnClick event
*/
function sheet1_OnClick(sheet , row, col, value) {  
	sheet.SetCellValue(row,"del_chk",1);
}
/**
 * event after saving
 */ 	
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	document.form.total_pieces.value=sheetObj.ComputeSum("|pck_qty|"); 		
		if (Code >= 0) {
		ComBkgSaveCompleted();			
	}
}     
/**
* event after retrieving
*/ 	
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	sheetObj.SetColBackColor("usa_cstms_file_no","#CCFFFD");
	document.form.total_pieces.value=sheetObj.ComputeSum("|pck_qty|");
	if(document.form.total_pieces.value==-1){
		document.form.total_pieces.value=0;
	}
	document.form.hbl_ttl_knt.value=sheetObj.GetEtcData("hbl_count");
}
