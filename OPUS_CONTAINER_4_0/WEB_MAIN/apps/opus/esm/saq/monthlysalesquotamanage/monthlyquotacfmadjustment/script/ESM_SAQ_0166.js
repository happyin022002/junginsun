/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0166.js
*@FileTitle  : VVD Mapping - VVD Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/*******************************************************/
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		var srcObj=ComGetEvent();
		if(ComGetBtnDisable(srcName))
			return false;
		switch(srcName) {
		    case "btn_go_retrieve":
			    doActionIBSheet(sheetObj,formObj,IBSEARCH);
			    break;
			case "btn_ok":
			    comPopupOK();
			    break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			//ComShowMessage(OBJECT_ERROR);
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(){
	$('input[unselectable="on"]').prop('onmousedown', 'return false;').attr('onmousedown', 'return false;');
    var sheetObj=sheetObjects[0];
	var formObj=document.form;
	for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    setLane_cd();
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}	
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
		case 1:      
		    with(sheetObj){
	        
	      var HeadTitle="|Lane|Group|Month|Week|VVD|Supply";

	      

	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio" },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"group",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"week",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"bsa",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(420);
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	      SetEditable(1);
	            }


			break;
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
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieve
			formObj.f_cmd.value=SEARCHLIST;
			sheetObj.DoSearch("ESM_SAQ_0166GS.do", saqFormString(formObj) );
			break;
	}
}
// lane_cd setting
function setLane_cd() {
	var formObj=document.form;
	var obj=formObj.rlane_cd;
    var params="rlse_ver_no=" + formObj.mqtaRlseVerNo.value
                + "&year="       + formObj.year.value
                + "&qtr_cd="     + formObj.bse_qtr_cd.value
                + "&trd_cd="     + formObj.trd_cd.value
                + "&dir_cd="     + formObj.dir_cd.value
                + "&lane_cd="     + formObj.rlane.value;                
               
	getSelectCodeList(obj, "SaqMappingVVD", params, true, new Option('', ''));
	obj.value=formObj.rlane.value;
}
