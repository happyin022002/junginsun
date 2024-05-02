/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0518.js
*@FileTitle  : Draft & Weight
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_Downexcel":
// 			sheetObject.Down2Excel({ HiddenColumn:1});
 			sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject),KeyFieldMark:0, SheetDesign:1,Merge:1 });
			break;
		case "btn_ImportFile":
			sheetObject.RemoveAll();
			sheetObject.RenderSheet(0);
 			sheetObject.LoadExcel({ Mode:"HeaderMatch"});
// 			sheetObject.LoadExcel({ Mode:"HeaderSkip", WorkSheetNo:"1", StartRow:"1"});
			sheetObject.RenderSheet(1);
			break;
		case "btn_FileTemplate":
			sheetObject1.DataInsert(-1);
 			sheetObject1.Down2Excel({ HiddenColumn:-1});
//			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * registering initial event
*/
function initControl() {
	axon_event.addListenerForm("focus", "obj_activate");
	axon_event.addListener('keypress', 'eng_keypress', 'vsl_cd', 'vsl_eng_nm', 'crr_cd', 'call_sgn_no', 'lloyd_no');
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');
	axon_event.addListenerForm('keypress', 'enter_keypress');
	axon_event.addListenerForm('keyup', "VskKeyFocus");
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
	        tabIndex=-1;
		      var HeadTitle="|Vessel|Vessel Seq.|Dead Weight Tonnage Weight|Draft Depth";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      var prefix="sheet1_";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mtx_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:400,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dwt_wgt",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:080,  Align:"Right",   ColMerge:0,   SaveName:prefix+"drft_dpth", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(440);
		      resizeSheet();
		      }
			break;
	case 2: // sheet2 init
		 with(sheetObj){
          tabIndex=-1;
	      if (location.hostname != "")
	      var HeadTitle="|Vessel|Vessel Seq.|Dead Weight Tonnage Weight|Draft Depth";
	      var headCount=ComCountHeadTitle(HeadTitle);
	      var prefix="sheet2_";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mtx_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:400,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dwt_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:080,  Align:"Right",   ColMerge:0,   SaveName:prefix+"drft_dpth", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(440);
		//ScrollBar=2;
      }
	break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)){ 
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			var rXml=sheetObj.GetSearchData("VOP_VSK_0518GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			sheetObj.LoadSearchData(rXml,{Sync:1} );
		}
		break;
	case IBSAVE: 
		var sParam=ComGetSaveString(sheetObjects);
		if (sParam == ""){
			return;
		}
		if (validateForm(sheetObj, formObj, IBSAVE)){ //Check Validation 
			formObj.f_cmd.value=MULTI;
			ComOpenWait(true);
 			var sXml=sheetObjects[0].GetSaveData("VOP_VSK_0518GS.do", "f_cmd=" + MULTI + "&" + sParam);
 			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){
				ComOpenWait(false);
			}else{
				ComOpenWait(false);
				var ErrVslCd=ComGetEtcData(sXml, "ErrVslCd");
				
				if(ErrVslCd != undefined){
					ComShowMessage("[ "+ ErrVslCd + " ] not exist in CCD")
				}else{
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					
					ComShowCodeMessage("COM130102", "Data"); // Data Saved Successfully!!
				}
			}
		}
		
		break;
	}	
}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
          	switch (sAction) {
   			case IBSAVE:  
        	 	for(var i=sheetObj.HeaderRows(); i< sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
        	 		if((sheetObj.GetCellValue(i, "sheet1_mtx_seq")) == "" ) {
	        	 		ComShowCodeMessage("COM130403","Vessel seq.");
	        	 		return false;
        	 		}else{
        	 			if(!ComIsNumber(sheetObj.GetCellValue(i, "sheet1_mtx_seq"))){
       	 					ComShowCodeMessage("COM12122","Vessel seq.");
       	 					return false;
       	 				}
        	 		} 
        	 		if ((sheetObj.GetCellValue(i, "sheet1_vsl_cd")) == "" ){
	        	 		ComShowCodeMessage("COM130403","Vessel");
	        	 		return false;
        	 		}
        	 		if ((sheetObj.GetCellValue(i, "sheet1_dwt_wgt")) == "" ){
	        	 		ComShowCodeMessage("COM130403","Dead Weight Tonnage Weight");
	        	 		return false;
        	 		}else{
        	 			if(!ComIsNumber(sheetObj.GetCellValue(i, "sheet1_dwt_wgt"),".")){
       	 					ComShowCodeMessage("COM12122","Dead Weight Tonnage Weight");
       	 					return false;
       	 				}
        	 		}
        	 		if ((sheetObj.GetCellValue(i, "sheet1_drft_dpth")) == "" ){
	        	 		ComShowCodeMessage("COM130403","Draft Depth");
	        	 		return false;
        	 		}else{
        	 			if(!ComIsNumber(sheetObj.GetCellValue(i, "sheet1_drft_dpth"),".")){
	       	 					ComShowCodeMessage("COM12122","Draft Depth");
	       	 					return false;
	       	 			}
        	 		}
        	 	}
        	 	break;
        }
		return true;
     }
/**
 * Handling Enter Key Event
 */
function enter_keypress() {
	VskKeyEnter();
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
