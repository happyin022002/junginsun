/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName 		: STM_SCO_0060.js
*@FileTitle 	: AP Finance Direction Conversion
*Open Issues 	:
*Change history :
*@LastModifyDate: 2011-02-22
*@LastModifier 	: 
*@LastVersion 	: 1.0
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
				OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
// The common variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var vslCombo="";
var vvdCombo="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName){
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				ComResetAll();
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "pop_slan":
				ComOpenPopup("COM_ENS_081.do", 830, 410, "setServiceLaneCode", "1,0,1,1,1,1", false, false, 0, 0, 0, "COM_ENS_081");
				break;
            case "btn_rlane_search":
            	var objEvt = ComGetEvent();
            	if(objEvt.style.cursor == "default") return;
            	var sUrl="/opuscntr/COM_COM_0011.do?rlane_cd=" + formObject.s_rlane_cd.value +"&mdm_yn=Y&main_page=false";
            	var rVal=ComOpenPopup(sUrl, 770, 420, "get_rLaneCd", "1,0,1", true);
    			break;
		} // end switch
	}catch(e){
		if( e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		} else{
			ComShowMessage(e.message);
		}
	}
}
/**
* Setting Service Lane Code
*/
function setServiceLaneCode(aryPopupData, Row, Col, sheetIdx) {
	form.s_slan_cd.value=aryPopupData[0][3];
	if(form.s_rlane_cd.value != "" && form.s_rlane_cd.value.substring(0,3) != form.s_slan_cd.value) 
	{
		form.s_rlane_cd.value="";
	}
}
/**
* Setting Revenue Lane Code
*/
function get_rLaneCd(rowArray) {
	var sheetObj=sheetObjects[0];
    var formObj=document.form;
   	var colArray=rowArray[0];
	formObj.s_rlane_cd.value=colArray[2];
	formObj.s_slan_cd.value=colArray[2].substring(0,3);
}
/**
 * registering IBCombo Object as list
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// sheet 사이즈 고정
	//sheetObjects[0].SetExtendLastCol(0);
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	//initializing the event of HTML control
	initControl();   
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo){
	var cnt=0;
	switch(sheetNo){
		case 1:      //sheet1 init
			with(sheetObj){
		    	var HeadTitle="|Service Lane Code|Revenue Lane Code|Revenue Lane Name|Revenue Direction|I/O Code|Revenue Port|Del Flag|Direction Change Code|I/O Code(Old)|Revenue Port(Old)";
		    	var headCount=ComCountHeadTitle(HeadTitle);

		    	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
		        

		    	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		    	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"slan_cd",      	   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",  	ColMerge:1,   SaveName:"rlane_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"finc_rev_dir_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",     	Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rev_ipt_ocn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		    	             {Type:"PopupEdit", Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rev_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		    	             {Type:"Combo",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dir_cng_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1,  Width:0,  Align:"Center",  ColMerge:1,   SaveName:"h_rev_ipt_ocn_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		    	             {Type:"Text",      Hidden:1,  Width:0,  Align:"Center",  ColMerge:1,   SaveName:"h_rev_port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 }];
		    
		    	InitColumns(cols);

		    	SetEditable(1);
		    	
		    	SetColProperty(0 ,"rev_ipt_ocn_cd",		{AcceptKeys:"E" , InputCaseSensitive:1});
		    	SetColProperty(0 ,"rev_port_cd",		{AcceptKeys:"E|N" , InputCaseSensitive:1});
		    	
//		    	SetColProperty("rev_ipt_ocn_cd", {ComboText:"OO|IA|IE|IM", ComboCode:"OO|IA|IE|IM"} );
		    	SetColProperty("delt_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );

		    	resizeSheet();	//SetSheetHeight(380);
			}
			break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

/**
 * Handling the process about the sheet <br>
 **/
function doActionIBSheet(sheetObj,formObj,sAction,row,col){
	sheetObj.ShowDebugMsg(false);
	switch(sAction){
		case IBSEARCH:      //Retrieving
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
			var sXml=sheetObj.GetSearchData("STM_SCO_0060GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			break;
		case IBSAVE:        //Saving
			if(ComShowConfirm(ComGetMsg("COM130101", "data"))){
				if (sheetObj.RowCount()== 0 || !sheetObj.IsDataModified()){
					ComShowCodeMessage("SCO00010");
					return; 
				}
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				// 2014.12.31 no need check because change query.
//				if (!chkDuplicateData(sheetObj)) {
//					return false;
//				}
				
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj);
				if (sheetObj.RowCount()== 0 || (!sheetObj.IsDataModified()&& sParam == "")){
					ComShowCodeMessage("SCO00010");
					return; 
				}
				sParam += "&" + FormQueryString(formObj);
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSaveData("STM_SCO_0060GS.do", sParam);
				var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if (sXml.length > 0){
					if (result == 'S'){
			 			ComShowCodeMessage("SCO00001");
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					} else{
//parameter changed[check again]CLT
//					ComShowMessage(ComGetSelectSingleNode(sXml, "MESSAGE"));
						sheetObj.LoadSaveData(sXml);
					}
				}
			}
			break;
		case SEARCH02:
			formObj.f_cmd.value=SEARCH02;
			var val=sheetObj.GetCellValue(row, col);
			var params=FormQueryString(formObj) + "&rev_port_cd=" + val;
//parameter changed[check again]CLT
			var sXml=sheetObj.GetSearchData("STM_SCO_0060GS.do", params);
			var state=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (state == 'S') {
				if(ComGetEtcData(sXml, "result") == null || ComGetEtcData(sXml, "result") == ''){
					ComShowCodeMessage("COM132201", "Revenue Port");
					sheetObj.SetCellValue(row, "rev_port_cd","",0);
					sheetObj.SelectCell(row, "rev_port_cd");
					return;
				}
			}
			break;
	}
}
/**
 * Removing IBSheet Row
 **/
function rowRemove(sheetObj){
	ComRowHideDelete(sheetObj, "DelChk");
}
/**
 * Loading the event of HTML control in the page dynamically.
 **/
function initControl(){
	DATE_SEPARATOR="-";
	//handling the occurring beforedeactivate event to the all fields  
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); 	
	//handling the occurring beforeactivate event to the all fields that contain dataformat attribute  
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); 	
	//handling the occurring keypress event to the all fields that contain dataformat attribute   
//	axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form);
	// handling the occurring keypress event to s_slan_cd and s_rlane_cd
//	axon_event.addListener  ('keypress', 'engnum_keypress' , 's_slan_cd', 's_rlane_cd');
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * handling process for input validation <br>
 **/
function validateForm(sheetObj,formObj,sAction){
	if(sAction == IBSEARCH){
		if (!ComChkValid(formObj)) return false;
	}else if(sAction == IBSAVE){
		for(var ir=1; ir<=sheetObj.LastRow(); ir++){
			if(sheetObj.GetCellValue(ir,"ibflag") == 'U' && (sheetObj.GetCellValue(ir,"rev_ipt_ocn_cd") == "" || sheetObj.GetCellValue(ir,"rev_port_cd") == "")){
				ComShowCodeMessage("COM130403", "Revenue Port");
				sheetObj.SelectCell(ir,"rev_ipt_ocn_cd");
				return false;
			}
		}
	}
	return true;
}

/**
 * Calling this function in case of changing the cell value in sheet
 **/
function sheet1_OnChange(sheetObj, row, col, val) {
	var formObject=document.form;
	var col_save_name=sheetObj.ColSaveName(col);
	if(sheetObj.ColSaveName(col) == "rev_port_cd" && sheetObj.GetCellValue(row, "rev_port_cd") != "") {
		var revPortCd=sheetObj.GetCellValue(row, "rev_port_cd");
		if(revPortCd.length != 5){
			ComShowCodeMessage("COM132201", "Revenue Port");
			sheetObj.SetCellValue(row, "rev_port_cd","",0);
			sheetObj.SelectCell(row, "rev_port_cd");
			return;
		}
		doActionIBSheet(sheetObj, document.form, SEARCH02, row, col);
	}
}

/**
 * Program Name Data List OpenWindow. <br>
 * @param {int}	Row	행번호
 * @param {int}	Col	컬럼번호
 **/
function sheet1_OnPopupClick(sheetObj,Row,Col){
    switch (sheetObj.ColSaveName(Col)) {
   		case "rev_port_cd" :
   			var sUrl="/opuscntr/COM_ENS_051.do";
            var rVal=ComOpenPopup(sUrl, 870, 460, "getLocCode", '0,0,1,1,1,1,1,1', true, false, Row, Col, 0);
   			break;
    }
}

function getLocCode(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	sheetObject.SetCellValue(row,col,aryPopupData[0][3]);
}

// check duplicate.
//function chkDuplicateData(sheetObj) {
//	var dupSourceRow;
//	var dupTargetRow;
//	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow()-1; i++ ){		
//		for(var k=i+1; k<=sheetObj.LastRow(); k++ ){
//			dupSourceRow = sheetObj.GetCellValue(i, "slan_cd") + "," + sheetObj.GetCellValue(i, "rlane_cd") + "," + sheetObj.GetCellValue(i, "finc_rev_dir_cd") + "," + sheetObj.GetCellValue(i, "rev_ipt_ocn_cd") + "," + sheetObj.GetCellValue(i, "rev_port_cd");
//			dupTargetRow = sheetObj.GetCellValue(k, "slan_cd") + "," + sheetObj.GetCellValue(k, "rlane_cd") + "," + sheetObj.GetCellValue(k, "finc_rev_dir_cd") + "," + sheetObj.GetCellValue(k, "rev_ipt_ocn_cd") + "," + sheetObj.GetCellValue(k, "rev_port_cd");
//			if(dupSourceRow == dupTargetRow) {				
//				ComShowCodeMessage('COM12115', dupTargetRow);
//				sheetObj.SelectCell(k, "rev_ipt_ocn_cd");
//				return false;
//			} 
//		}
//	}
//	
//	return true;
//}