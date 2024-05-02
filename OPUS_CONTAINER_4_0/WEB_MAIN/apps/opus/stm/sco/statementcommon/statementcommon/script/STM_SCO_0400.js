/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : STM_SCO_0400.js
 *@FileTitle : TES Manual Cancellation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "exe_yrmon_cal":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.exe_yrmon, 'yyyy-MM');
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_new":
				formObj.exe_yrmon.value="";
				formObj.cancel_flg.value="N";
				formObj.vvd.value="";
				formObj.yd_cd.value="";
				formObj.yd_nm.value="";
				sheetObject.RemoveAll();
                break;			
			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;
			case "btn_yard":
				
				var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
				var classId="COM_ENS_061";
				var param='?classId='+classId;
				var chkStr=dispaly.substring(0,3);
				// radio PopUp
				if(chkStr == "1,0") {
					ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 530, 'getYard', dispaly, true);
				} else {
					ComShowMessage(ComGetMsg('SCO00014'));
					return;
				}
				break;	
			case "btn_downexcel":
    	    	if(sheetObject.RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
    	    		}else{
    	    			sheetObjects[0].Down2Excel({ HiddenColumn:1, Merge:1, DownCols:'2|3|4|5|6|7|8|9|10|11|12|13'});
    	    		}					
    	    	break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// sheet 사이즈 고정
	sheetObjects[0].SetExtendLastCol(0);
    initControl();
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
//    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
//    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    switch (sheetNo) {
    	case 1: //t1sheet1 init
		    with(sheetObj){	
	    		var HeadTitle1="||VVD|Yard|Act Month|Vendor|Cost Code|Estimation|Estimation|Actual|Actual|Accrual|Accrual|Cancel\nFlag|rev_yrmon|acct_cd|accl_seq";
	    		var HeadTitle2="||VVD|Yard|Act Month|Vendor|Cost Code|Qty|Amt|Qty|Amt|Qty|Amt|Cancel\nFlag|rev_yrmon|acct_cd|accl_seq";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"CheckBox",	Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vvd",        	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"yard_code",	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_dt",	    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vendor_code",	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cost_code",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"estm_qty",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",  	Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"estm_amt",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"act_qty", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"act_amt", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"accl_qty", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Right",   ColMerge:1,   SaveName:"accl_amt", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cancel_flag", 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",  ColMerge:1,   SaveName:"accl_seq",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			     
			    InitColumns(cols);
			    SetEditable(1);
	    		
			    resizeSheet();
    		}
		break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetID=sheetObj.id;
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("STM_SAC_0020GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			
			break;
			
		case MULTI: // Save
			if (ComShowCodeConfirm("SCO00009", "save?")) {
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	setTimeout( function () {
			    	var sXml=sheetObj.GetSaveData("STM_SAC_0020GS.do", sParam);
			    	ScoOpenWait(false,true); 
					
					if (SCODecideErrXml(sheetObj, sXml)) {
						return;
					} else {
						ComShowCodeMessage("SCO00001");
					}
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
		    	} , 100);
			}
		    break;
		case IBSEARCH_ASYNC04: 	// get YD name
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("STM_SAC_0020GS.do", FormQueryString(formObj));
            var ydNm = ComGetEtcData(sXml, "yd_nm");
            formObj.yd_nm.value = ydNm;
            
            break;			 
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			if (!ComChkValid(formObj)) return false;
			break;
		case MULTI: 			
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SCO00010");
				return false;
			} 
			break;
	}
	return true;
}

/**
 * after search data
 */
//function sheet1_OnSearchEnd(sheetObj, ErrMsg){
//	var cancelFlag;
//	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
//		cancelFlag = sheetObj.GetCellValue(i, "cancel_flag");
//		if(cancelFlag === "N")
//			sheetObj.SetCellValue(i, "Chk", "1");
//	}
//}

/**
 * handling process click event in the ibsheet
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	var cancelFlag = sheetObj.GetCellValue(Row, "cancel_flag");
	var chk = sheetObj.GetCellValue(Row, "Chk");
	/*
	alert("cancelFlag : "+cancelFlag+", chk : "+chk)
	if(cancelFlag === 'Y' && chk === 1) {
		ComShowCodeMessage("COM12114", "Cancel Flag is 'N'");
		sheetObj.SetCellValue(Row, "Chk", "0");
	}
	*/
}

/**
 * getYardName
 * 
 */
function getYardName() {
	var formObj=document.form;
	if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim()=='' || formObj.yd_cd.value.trim().length < 7 ){
		formObj.yd_nm.value = "";
		return false;
	}
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
}


/*
 * @param {String} rowArray row
 */
function getYard(rowArray) {
	var colArray=rowArray[0];
	document.all.yd_cd.value=colArray[3];
	document.all.yd_nm.value=colArray[4];
}


