/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0068.js
*@FileTitle  : Revenue Port Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_fms_0068 : esm_fms_0068 definition of biz script for creation screen
 */
// common global variables 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
        switch(srcName) {
			case "btn_add":
				sheetObject.DataInsert(-1);
                break;
            case "btn_ins":
            	sheetObject.DataInsert();
                break;
            case "btn_del":
            	ComRowHideDelete(sheetObject, "DelChk");
                break;
            case "btn_retrive":
            	if(!initConfirm()) return;
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                form.search_type.value="retrive";
                break;
            case "btn_new":
            	if(!initConfirm()) return;
		 		ComResetAll();
		 		inputReadOnly();
                break;
            case "btn_save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
            case "btn_slanpop":
            	ComOpenPopup("ESM_FMS_0036.do", 620, 440, "setLaneCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0036");
                break;
			case "btn_savetofile":
				if(sheetObject.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}	
                break;
			case "btn_deleteAll":
 				if(ComShowCodeConfirm("FMS00003")) {
					doActionIBSheet(sheetObject, formObject, IBDELETE);
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
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    inputReadOnly();
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
		          var HeadTitle="|Sel|Seq|Service Lane|Revenue Lane|Service Lane Direction|Fin Direction|I/O Code|Start Port|End Port|Used Yn";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          (headCount, 0, 0, true);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flet_ioc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"st_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fnl_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
		                 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"used_yn",  	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 }];
		          InitColumns(cols);
		          SetEditable(1);
//			          SetSheetHeight(420);
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
function doActionIBSheet(sheetObj, formObj, sAction, objNm, row) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       	case IBSEARCH:      
   			if(objNm == "slan_cd") {
   				form.f_cmd.value=SEARCH05;
   				var param=FormQueryString(formObj) + "&lane_cd=" + formObj.slan_cd.value;
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				formObj.slan_cd.value=cdName;
				} else {
					formObj.slan_cd.value="";
					ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS20014", "Lane"));
				}
   			} else if(objNm == "rlane_cd") {
   				form.f_cmd.value=SEARCH07;
   				var param=FormQueryString(formObj) + "&rlane_cd=" + formObj.rlane_cd.value;
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				formObj.rlane_cd.value=cdName;
				} else {
					formObj.rlane_cd.value="";
					ComAlertFocus(formObj.rlane_cd, ComGetMsg("FMS20014", "Lane"));
				}
   			} else if(objNm == "esm064_0001") {
   				formObj.f_cmd.value=SEARCH01;
    			sheetObj.DoSearch("ESM_FMS_0068GS.do", FormQueryString(formObj) );
   			} else {
		       	if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_FMS_0068GS.do", FormQueryString(formObj) );
				}
   			}
            break;
       	case IBROWSEARCH:
       		if(objNm == "slan_cd") {
   				form.f_cmd.value=SEARCH05;
   				var param=FormQueryString(formObj) + "&lane_cd=" + sheetObj.GetCellValue(row, objNm).toUpperCase();
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				sheetObj.SetCellValue(row, objNm,cdName,0);
				} else {
					ComShowMessage(ComGetMsg("FMS20014", "[Service Lane]"));
					sheetObj.SetCellValue(row, objNm,"",0);
 					sheetObj.SelectCell(row, objNm);
				}
   			} else if(objNm == "rlane_cd") {
   				var param="f_cmd=" + SEARCH07 + "&rlane_cd=" + sheetObj.GetCellValue(row, objNm).toUpperCase();
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			var arUsedYn = ComGetEtcData(sXml, "arUsedYn");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				sheetObj.SetCellValue(row, objNm	,cdName,1);
	   				sheetObj.SetCellValue(row, "used_yn",arUsedYn,1);
				} else {
					ComShowMessage(ComGetMsg("FMS20014", "[Revenue Lane]"));
					sheetObj.SetCellValue(row, objNm	,"",0);
	   				sheetObj.SetCellValue(row, "used_yn","",0);
 					sheetObj.SelectCell(row, objNm);
				}
   			} else if(objNm == "st_port_cd") {
   				form.f_cmd.value=SEARCH04;
   				var param=FormQueryString(formObj) + "&loc_cd=" + sheetObj.GetCellValue(row, objNm).toUpperCase();
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				sheetObj.SetCellValue(row, objNm,cdName,0);
				} else {
					ComShowMessage(ComGetMsg("FMS20014", "[Start Port]"));
					sheetObj.SetCellValue(row, objNm,"",0);
 					sheetObj.SelectCell(row, objNm);
				}
   			} else if(objNm == "fnl_port_cd") {
   				form.f_cmd.value=SEARCH04;
   				var param=FormQueryString(formObj) + "&loc_cd=" + sheetObj.GetCellValue(row, objNm).toUpperCase();
    				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
	   			var cdName=ComGetEtcData(sXml, "cdName");
	   			if(typeof cdName != "undefined" && cdName != "" ) {
	   				sheetObj.SetCellValue(row, objNm,cdName,0);
				} else {
					ComShowMessage(ComGetMsg("FMS20014", "[End Port]"));
					sheetObj.SetCellValue(row, objNm,"",0);
 					sheetObj.SelectCell(row, objNm);
				}
   			} else if(objNm == "skd_dir_cd") {
   				var f_query = "";	
   				var tmpSlanCd 		= sheetObj.GetCellValue(row, "slan_cd"); 
   				var tmpSlanDirCd 	= sheetObj.GetCellValue(row, "skd_dir_cd");
   				var tmpRlaneCd 		= sheetObj.GetCellValue(row, "rlane_cd");
   				var tmpUsedYn 		= sheetObj.GetCellValue(row, "used_yn");
   				
   				f_query += "f_cmd=" + SEARCH05; 
   				f_query += "&slan_cd="+tmpSlanCd;	 			
   				f_query += "&slan_dir_cd="+tmpSlanDirCd;
   				f_query += "&rlane_cd="+tmpRlaneCd;
   				f_query += "&used_yn="+tmpUsedYn;	
   				
   				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

   	   			var varSlanDirCd = ComGetEtcData(sXml, "slanDirCd");
   	   			var varRlaneDirCd = ComGetEtcData(sXml, "rlaneDirCd");
   	   			
	   	   		if(typeof varSlanDirCd == "undefined" || ComIsEmpty(varSlanDirCd) ) {
	   				ComShowMessage(ComGetMsg("FMS20014", "[Service Lane Direction]"));
					sheetObj.SetCellValue(row, objNm, "", 0);
					sheetObj.SetCellValue(row, rev_dir_cd, "", 0);
					sheetObj.SelectCell(row, objNm);
					return;
				}
		   	   	if(ComIsEmpty(varRlaneDirCd) ) {
	   				sheetObj.SetCellValue(row, "rev_dir_cd", varSlanDirCd, 1);
					sheetObj.SelectCell(row, "st_port_cd");
				}else{
					sheetObj.SetCellValue(row, "rev_dir_cd", varRlaneDirCd, 1);
					sheetObj.SelectCell(row, "st_port_cd");
				}
   			} else if(objNm == "rev_dir_cd") {
   				var f_query = "";	
   				var tmpSlanCd 		= sheetObj.GetCellValue(row, "slan_cd"); 
   				var tmpSlanDirCd 	= sheetObj.GetCellValue(row, "skd_dir_cd");
   				var tmpRevDirCd 	= sheetObj.GetCellValue(row, "rev_dir_cd");
   				var tmpRlaneCd 		= sheetObj.GetCellValue(row, "rlane_cd");
   				var tmpUsedYn 		= sheetObj.GetCellValue(row, "used_yn");
   				   				
   				f_query += "f_cmd=" + SEARCH06; 
   				f_query += "&slan_cd="+tmpSlanCd;	 			
   				f_query += "&slan_dir_cd="+tmpSlanDirCd;		
   				f_query += "&rlane_dir_cd="+tmpRevDirCd;	
   				f_query += "&rlane_cd="+tmpRlaneCd;	
   				f_query += "&used_yn="+tmpUsedYn;
   				
   				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

   	   			var varRlaneDirCd = ComGetEtcData(sXml, "rlaneDirCd");
	   	   		if(typeof varRlaneDirCd == "undefined" || ComIsEmpty(varRlaneDirCd) ) {
	   				ComShowMessage(ComGetMsg("FMS20014", "[Fin Direction]"));
					sheetObj.SetCellValue(row, objNm, "", 0);
					sheetObj.SelectCell(row, objNm);
				}else{
					sheetObj.SetCellValue(row, objNm, varRlaneDirCd, 1);
				}
   			}
       		break;
		case IBSAVE:        
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value=MULTI;

				if(!sheetObj.IsDataModified()|| (sheetObj.GetSaveString() == "")) {
					ComShowCodeMessage("FMS00007");
					return;
				}
				var param=FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObj.GetSaveString(),"sheet1_");
				var sXml=sheetObj.GetSaveData("ESM_FMS_0068GS.do", param);
			  	sheetObjects[0].LoadSaveData(sXml);
			}
            break;
		case IBDELETE:      
			for(var row=1; row<=sheetObj.LastRow(); row++) {
				sheetObj.SetRowStatus(row,"D");
			}
    		formObj.f_cmd.value=REMOVE;
  	  		sheetObj.DoSave("ESM_FMS_0068GS.do", FormQueryString(formObj));
 			break;
	}
}
/**
  * Handling process for input validation
  */
function validateForm(sheetObj,formObj,sAction) {
	if(sAction == IBSAVE) {
		var idx=0;
		var sourceKey="";
		var targetKey="";
		for(var i=0; i<sheetObj.LastRow(); i++) {
			++idx;
			if(sheetObj.GetCellValue(idx, "ibflag") == "D") {
				continue;
			}
			sourceKey=sheetObj.GetCellValue(idx, "rlane_cd") + sheetObj.GetCellValue(idx, "skd_dir_cd") + sheetObj.GetCellValue(idx, "rev_dir_cd");
			for(var j=idx+1; j<=sheetObj.LastRow(); j++) {
				if(sheetObj.GetCellValue(j, "ibflag") == "D") {
    				continue;
    			}
				targetKey=sheetObj.GetCellValue(j, "rlane_cd") + sheetObj.GetCellValue(j, "skd_dir_cd") + sheetObj.GetCellValue(j, "rev_dir_cd");
				if(sourceKey == targetKey) {
					ComShowCodeMessage("FMS00008", "[Revenue Lane] [Service Lane Direction] [Fin Direction]");
					return false;
				}
			}
		}
	}
    return true;
}
/**
   * Checking Validation of Service Lane, Revenue Lane, Start Port, End Port의 Validation when onChange Event of Sheet1 is occurred<br>
   */
function sheet1_OnChange(sheetObj, row, col, value) {
	if(value == "") {
		return;
	}
	var colName = sheetObj.ColSaveName(col);
	
	switch(colName) {
   		case "slan_cd":  
   			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", row);
   			break;
   		case "rlane_cd": 
   			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "rlane_cd", row);
   			break;
   		case "skd_dir_cd":
   			var tmpSeq = sheetObj.GetCellValue(row, "Seq");
   			var tmpSlanCd = sheetObj.GetCellValue(row, "slan_cd");
   			var tmpRlaneCd = sheetObj.GetCellValue(row, "rlane_cd");
   			if(ComIsEmpty(tmpSlanCd)){
   				ComShowCodeMessage("FMS20014", "[Service Lane]");
   				sheetObj.SelectCell(row, "slan_cd");
   			}else if(ComIsEmpty(tmpRlaneCd)){
   				ComShowCodeMessage("FMS20014", "[Revenue Lane]");
   				sheetObj.SetCellValue(row, "rev_dir_cd", "", 0);
   				sheetObj.SelectCell(row, "rlane_cd");  
   				return; 				
   			}else{
   				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "skd_dir_cd", row);
   			}
   			break;
   		case "rev_dir_cd": 
   			var tmpSeq = sheetObj.GetCellValue(row, "Seq");
   			var tmpSlanCd = sheetObj.GetCellValue(row, "slan_cd");
   			var tmpSkdDirCd = sheetObj.GetCellValue(row, "skd_dir_cd");
   			var tmpRlaneCd = sheetObj.GetCellValue(row, "rlane_cd");
   			
   			if(ComIsEmpty(tmpSlanCd)){
   				ComShowCodeMessage("FMS20014", "[Service Lane]");
   				sheetObj.SetCellValue(row, "rev_dir_cd", "", 0);
   				sheetObj.SelectCell(row, "slan_cd"); 
   				return;
   			}else if(ComIsEmpty(tmpRlaneCd)){
   				ComShowCodeMessage("FMS20014", "[Revenue Lane]");
   				sheetObj.SetCellValue(row, "rev_dir_cd", "", 0);
   				sheetObj.SelectCell(row, "rlane_cd");  
   				return; 				
   			}else if(ComIsEmpty(tmpSkdDirCd)){
   				ComShowCodeMessage("FMS20014", "[Service Lane Direction]");
   				sheetObj.SetCellValue(row, "rev_dir_cd", "", 0);
   				sheetObj.SelectCell(row, "skd_dir_cd"); 
   				return;  				
   			}else{
   				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "rev_dir_cd", row);
   			}
   			break;
   		case "st_port_cd":  
   			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "st_port_cd", row);
   			break;
   		case "fnl_port_cd":  
   			doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "fnl_port_cd", row);
   			break;   		
	}
	
}
/**
 * Checking continueing when other work in case changed data is existing<br>
 **/
function initConfirm() {
	var okYn=true;
 	if(sheetObjects[0].IsDataModified()) {
 		var okYn=ComShowCodeConfirm("FMS00002");
 	}
 	return okYn;
}
/**
 * Setting Lane Code selecting on Land Code Popup to Form item <br>
 * @param {arry} aryPopupData
 */
function setLaneCd(aryPopupData){
	form.slan_cd.value=aryPopupData[0][3];
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
	axon_event.addListenerForm  ('change'			, 'obj_change'		, form); 	//- Code Handling to onChange Event of All Controls
}
/**
 * Only insert Numeric by onkeypress Event of HTML Control<br>
 **/
function obj_deactivate(){
    ComChkObjValid(ComGetEvent());
}

/**
 * Changing Service Lane, Revenue Lane in onchange Event of HTML Control<br>
 */
function obj_change() {
	if((ComGetEvent().name == "slan_cd") && (ComGetEvent().value.length == 3)) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"slan_cd");
	} else if((ComGetEvent().name == "rlane_cd") && (ComGetEvent().value.length == 5)) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"rlane_cd");
	}
}
/**
 * Decide to use/not use relavent Object by condition<br>
 **/
function inputReadOnly() {
	form.search_type.value="retrive";
	form.btn_slanpop.style.cursor="hand";
}
/**
 * Changing Font of slan_cd,rlane_cd,skd_dir_cd<br>
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {

}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
 	
