/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_VSK_0032.js
 *@FileTitle : On-Time Ratio
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
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
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        //if (!ComIsBtnEnable(srcName)) return;  
        if(ComGetBtnDisable(srcName)) return false; 
		switch (srcName) {
			case "btn_Retrieve":
				with(formObj){
					if(start_date1.value==""){
						ComShowCodeMessage('VSK00027', "Period1 Start Date");
						start_date1.focus();
						return;
					}else if(end_date1.value==""){
						ComShowCodeMessage('VSK00027', "Period1 End Date");
						end_date1.focus();
						return;
					}else if (end_date1.value < start_date1.value){
						ComShowCodeMessage('VSK00025', 'Period1 End Date' ,'Period1 Start Date');
					   // msgs['VSK00025']='({?msg1}) must be later than ({?msg2}).';
						end_date1.focus();
						return;
					}
//					else if(start_date2.value==""){
//						ComShowCodeMessage('VSK00027', "Period2 Start Date");
//						start_date2.focus();
//						return;
//					}else if(end_date2.value==""){
//						ComShowCodeMessage('VSK00027', "Period2 End Date");
//						end_date2.focus();
//						return;
//					}
					else if(start_date2.value!=""&&end_date2.value==""){
						ComShowCodeMessage('VSK00021', "Period2 End Date");
						end_date2.focus();
						return;	
					
					}else if(end_date2.value!=""&&start_date2.value==""){
						ComShowCodeMessage('VSK00021', "Period2 Start Date");
						start_date2.focus();
						return;		
						
					}else if(start_date2.value!=""&&end_date2.value < start_date2.value){
						ComShowCodeMessage('VSK00025', 'Period2 End Date' ,'Period2 Start Date');
					   // msgs['VSK00025']='({?msg1}) must be later than ({?msg2}).';
						end_date2.focus();
						return;
					}
					// Setting max of period1 end date and period2 end date to sum_date
					if(end_date2.value==""){
						sum_date.value=end_date1.value;
					}else{
						if(end_date2.value > end_date1.value){
							sum_date.value=end_date2.value;
						}else{
							sum_date.value=end_date1.value;
						}
					}
				}
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case "btn_cal11":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.start_date1, 'yyyy-MM');
				break;
			case "btn_cal12":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.end_date1, 'yyyy-MM');
				break;
			case "btn_cal21":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.start_date2, 'yyyy-MM');
				break;
			case "btn_cal22":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.end_date2, 'yyyy-MM');
				break;
			case "btns_search1":
				var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
				
				ComOpenPopup(sUrl, 458, 470, "getSlanCdData", "0,0", true);
				
				break;
			case "btns_search2":
				var sUrl="/opuscntr/VOP_VSK_0219.do";
//				var rVal=ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
//				if(rVal){
//					formObj.vsl_cd.value=rVal;
//				}
				ComOpenPopup(sUrl, 464, 480, "getVslCdData", "0,0", true);
				
				break;
			case "btns_search3":
				var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
//				var rVal=ComOpenPopupWithTarget(sUrl, 628, 620, "", "0,0", true);
//				if(rVal){
//					formObj.vps_port_cd.value=rVal;
//				}
				
				ComOpenPopup(sUrl, 628, 520, "getPortCdData", "0,0", true);
				
				break;
			case "btns_search4":
				var sUrl="/opuscntr/COM_ENS_0N1.do";
				ComOpenPopupWithTarget(sUrl, 526, 520, "3:crr_cd", "0,0", true);
				break;
			case "btn_DownExcel":
				if(sheetObjects[0].RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel({ HiddenColumn:1,Merge:1});
				} 				
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function getVslCdData(obj){
	if(obj){
		var rtnDatas=obj;
		if(rtnDatas){
			if(rtnDatas[0][1].length > 0){
				document.form.vsl_cd.value=rtnDatas[0][1];
			}
		}
	}
}

function getSlanCdData(obj){
	if(obj){
		var rtnDatas=obj[0];
		
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.vsl_slan_cd.value= rtnDatas[1];
			}
		}
	}
}

function getPortCdData(obj){
	if(obj){
		var rtnDatas=obj;
		
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.vps_port_cd.value= rtnDatas;
			}
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	// Initializing date
	var formObj=document.form;
	var today=new Date();
	with (formObj) {
		start_date1.value=ComGetNowInfo("ym", "-");
		end_date1.value=ComGetNowInfo("ym", "-");
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
       
      var HeadTitle1="Port|Period 1|Period 1|Period 1|Period 2|Period 2|Period 2|Diff.|||SUM";
      var HeadTitle2="Port|Call|On-time|Ratio(%)|Call|On-time|Ratio(%)|Ratio(%) |||Ratio(%)";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:107,  Align:"Center",  ColMerge:1,   SaveName:"grp_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:107,  Align:"Right",   ColMerge:1,   SaveName:"ttl_call01",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:107,  Align:"Right",   ColMerge:1,   SaveName:"ontime_call01",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:107,  Align:"Right",   ColMerge:1,   SaveName:"dur_ratio01",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:107,  Align:"Right",   ColMerge:1,   SaveName:"ttl_call02",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:107,  Align:"Right",   ColMerge:1,   SaveName:"ontime_call02",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:107,  Align:"Right",   ColMerge:1,   SaveName:"dur_ratio02",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:107,  Align:"Right",   ColMerge:1,   SaveName:"diff_rat",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"ttl_call03",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"AutoSum",   Hidden:0, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"ontime_call03",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:107,  Align:"Right",   ColMerge:1,   SaveName:"dur_ratio03",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
            //no support[implemented common]CLT 			MessageText("Sum")="Total";
      SetColHidden(8,1);
      SetColHidden(9,1);
      SetSheetHeight(340);
      }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: // Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			if(formObj.ontime_opt.value==""){
				formObj.ontime_opt.value="0";
			}
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0032GS.do", sParam);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			break;
		case SEARCH01: // Lane Code Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			var vsl_slan_cd=ComGetEtcData(sXml, "vsl_slan_cd");
			if(vsl_slan_cd==null){
				ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
			}
			break;
		case SEARCH02: // Vessel Code Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			var vsl_cd=ComGetEtcData(sXml, "vsl_cd");
			if(vsl_cd==null){
				ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.vsl_cd.value="";
				formObj.vsl_cd.focus();
			}
			break;
		case SEARCH03: // Port Code Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH03;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			var vps_port_cd=ComGetEtcData(sXml, "vps_port_cd");
			if(vps_port_cd==null){
				ComShowCodeMessage('VSK00029', formObj.vps_port_cd.value);
				formObj.vps_port_cd.value="";
				formObj.vps_port_cd.focus();
			}
			break;
		case SEARCH04: // Carrier Code Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH04;
			var sParam=FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0032GS.do", sParam);
			ComOpenWait(false);
			var crr_cd=ComGetEtcData(sXml, "crr_cd");
			if(crr_cd==null){
				ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
				formObj.crr_cd.value="";
				formObj.crr_cd.focus();
			}
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}
function initControl(){
	var formObj=document.form;
//	axon_event.addListenerForm("keypress", "enter_keypress", formObj);
    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);
//    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("beforedeactivate", "obj_beforedeactivate", formObj);
//    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
//	axon_event.addListenerForm('change', 'obj_change', form); 		
//	axon_event.addListenerForm('keydown', 'obj_keydown', form); 

}
/**
 * Handling enter key event
 */
function enter_keypress(){
	VskKeyEnter();
}
//function obj_keypress(){
//	var srcName=event.srcElement.name;
//	switch(event.srcElement.name){
//	case "vsl_slan_cd":
//	case "vsl_cd":
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	case "vps_port_cd":
//	case "crr_cd":
//		ComKeyOnlyAlphabet('upper');
//		break;
//	case "start_date1":
//	case "end_date1":
//	case "start_date2":
//	case "end_date2":
//		ComKeyOnlyNumber();
//		break;
//	case "ontime_opt":
//		ComKeyOnlyNumber();
//		break;
//	}
//}

/**
 * Handling focus out event and checking validation
 */
function obj_beforedeactivate() {
	var formObj=document.form;
	var obj=event.srcElement;
	switch (event.srcElement.name) {
		case "start_date1":
		case "end_date1":
		case "start_date2":
		case "end_date2":
//			ComChkObjValid(event.srcElement);
			break;
	}
}
/**
 * Handling foucs in event and Deleting mask separator
 */
function obj_activate() {
	switch (event.srcElement.name) {
		case "start_date1":
		case "end_date1":
		case "start_date2":
		case "end_date2":
//			ComClearSeparator(event.srcElement);
			break;	
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
function obj_keyup(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var obj=event.srcElement;
	switch (event.srcElement.name) {
		case "vsl_slan_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH01);
			}
			break;
		case "vsl_cd":
			if(ComChkLen(obj.value, 4)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
			break;
		case "vps_port_cd":
			if(ComChkLen(obj.value, 5)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH03);
			}
			break;
		case "crr_cd":
			if(ComChkLen(obj.value, 3)==2){
				doActionIBSheet(sheetObj, formObj, SEARCH04);
			}
			break;
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var group=formObj.grp_id;
	sheetObj.SetCellValue(0, 0,group.options[group.selectedIndex].text,0);
	sheetObj.SetCellValue(1, 0,group.options[group.selectedIndex].text,0);
	for(var i=2; i<=sheetObj.LastRow(); i++){
		if(sheetObj.GetCellValue(i, "diff_rat")<0){
 			sheetObj.SetCellFontColor(i, "diff_rat","#FF0000");
		}
	}
	
	// in case total row exist, calculating each item
	with(sheetObj){
		if ( LastRow() > 3 ) {
			SetCellValue(LastRow(), "grp_id", "Total");
		}
		if(GetCellValue(LastRow(), "grp_id")=="Total"){
			// Period Ratio1 
			// expression : Period Ontime1 / Period Call1 * 100
			var zeroVal = 0;
			if(GetCellValue(LastRow(), "ttl_call01")==0){
				SetCellValue(LastRow(), "dur_ratio01",zeroVal.toFixed(1),0);
			}else{
				var tot1 = GetCellValue(LastRow(), "ontime_call01") / GetCellValue(LastRow(), "ttl_call01") * 100;
				SetCellValue(LastRow(), "dur_ratio01",tot1.toFixed(1),0);
			}

			// Period Ratio2
			// expression : Period Ontime2 / Period Call2 * 100
			if(GetCellValue(LastRow(), "ttl_call02")==0){
				SetCellValue(LastRow(), "dur_ratio02",zeroVal.toFixed(1),0);
			}else{
				var tot2 = GetCellValue(LastRow(), "ontime_call02") / GetCellValue(LastRow(), "ttl_call02") * 100;
				SetCellValue(LastRow(), "dur_ratio02",tot2.toFixed(1),0);
			}
			// Diff
			// expression : Period Ratio1 - Period Ratio2
			SetCellValue(LastRow(), "diff_rat", (GetCellValue(LastRow(), "dur_ratio01") - GetCellValue(LastRow(), "dur_ratio02")).toFixed(1),0);
			// Sum
			// expression : Sum Ontime / Sum Call * 100
			if(GetCellValue(LastRow(), "ttl_call03")==0){
				SetCellValue(LastRow(), "dur_ratio03",zeroVal.toFixed(1),0);
			}else{
				var tot3 =GetCellValue(LastRow(), "ontime_call03") / GetCellValue(LastRow(), "ttl_call03") * 100;
				SetCellValue(LastRow(), "dur_ratio03",tot3.toFixed(1),0);
			}
		}	
	}
}
