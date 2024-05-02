/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0012.jsp
*@FileTitle  : Long Range SKD  Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class LRS Creation : LRS Creation
 */
var Map=function()
{
    var mapVal={};    // private
    var pos=new Array();
    this.get=function( key )
    {
        return mapVal[ key ];
    }
    this.getPos=function( n )
    {
        return mapVal[ pos[n] ];
    }
    this.remove=function( n )
    {
    	var oldSize=pos.length;
        var ary=new Array();
        for( var i=0; i<oldSize; i++ )
        {
            if( i != n )
            {
                ary.push( pos[i] );
            }
        }
        pos=ary;
    }
    this.put=function( key, val )
    {
        mapVal[key]=val;
        var flg=true;
        for( var i=0; i<pos.length; i++ )
        {
            if( key == pos[i] )
                flg=false;
        }
        if( flg )
            pos.push( key );
    }
    this.size=function()
    {
        return pos.length;
    }
    this.exist=function( key )
    {
    	var idx=-1;
    	for(var i=0; i<pos.length; i++){
    		if(key == pos[i]){
    			idx=i;
    			break;
    		}
    	}
    	return idx;
    }
}
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var arrXml=new Array();
var searchComplete;
var subGridHeight;
var vvdMap=new Map();
var slanObj1;
var slanObj2;
var vslEngNmEtcData="";
var portNMEtcData="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
//	var sheetObject1 = sheetObjects[1];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btns_search1":	// Lane Code Retrieve			
			var v_display="0,0";
			var laneCd = formObj.vsl_slan_cd_1.value;
			ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "getLanecd", v_display, true);
			break;
		case "btns_search2": // Vessel Code Retrieve
			var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value;
			ComOpenPopup(sUrl, 464, 500, "callBackVslCd", "0,0", true);
			break;
			
		case "btns_back1":
			with(formObj) {
				start_year.value=parseInt(start_year.value) - 1;
				start_date.value=ComGetMaskedValue(startQuarterDay(start_year.value, start_qt.value), "ymd");
				start_date.blur();
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "btns_next1":
			with(formObj) {
				// as start_year increasing, end_year increase at the same time
				// start_date > end_date
				start_year.value=parseInt(start_year.value)+1;
    			start_date.value=ComGetMaskedValue(startQuarterDay(start_year.value,start_qt.value), "ymd");
				if(start_date.value > end_date.value){
					end_year.value=parseInt(end_year.value)+1;
        			end_date.value=ComGetMaskedValue(endQuarterDay(end_year.value, end_qt.value), "ymd");
				}
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "btns_back2":
			with(formObj){
				// as end_year decreasing, start_year decrease at the same time
				// end_date < start_date
				end_year.value=parseInt(end_year.value)-1;
    			end_date.value=ComGetMaskedValue(endQuarterDay(end_year.value,end_qt.value), "ymd");
				if(end_date.value < start_date.value){
					start_year.value=parseInt(start_year.value)-1;
        			start_date.value=ComGetMaskedValue(startQuarterDay(start_year.value,start_qt.value), "ymd");
				}
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "btns_next2":
			with(formObj) {
				end_year.value=parseInt(end_year.value) + 1;
				end_date.value=ComGetMaskedValue(endQuarterDay(end_year.value,end_qt.value), "ymd");
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
		
		case "btns_calendar1":
			var cal=new ComCalendar();
			cal.select(formObj.start_date, 'yyyy-MM-dd');
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "btns_calendar2":
			var cal=new ComCalendar();
			cal.select(formObj.end_date, 'yyyy-MM-dd');
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "btn_Retrieve":
			
			if(checkPeriod(formObj)){
				if(slanObj1.style.display=="block" && formObj.vsl_slan_cd_1.value==""){
					doActionIBSheet(sheetObject1, formObj, SEARCH03);
				}else{
					doActionIBSheet(sheetObject1, formObj, SEARCH02);
				}
			}
			break;
			
		case "btn_New":
			slanObj1.style.display="block";
			slanObj2.style.display="none";
			with (formObj) {
				vsl_slan_cd.value="";
				vsl_slan_cd_1.value="";
				tmp_vsl_slan_cd.value="";
				setCurrentPeriod();
				vsl_cd.value="";
				tmp_vsl_cd.value="";
				cre_dt.value="";
				cre_usr_id.value="";
				upd_dt.value="";
				upd_usr_id.valur="";
				vsl_slan_cd_1.focus();
			}
			vslEngNmEtcData="";
			portNmEtcData="";
			deleteSheet();
			break;
		case "btn_EMail":
			var sheetDiv=document.getElementById("sheet_div");
			var iframes=sheetDiv.getElementsByTagName("iframe");
			if(iframes.length>0){
//				formObj.com_subject.value="Long Range SKD Inquiry [" + formObj.vsl_slan_cd.value + "]";
				formObj.com_subject.value="Long Range SKD [" + formObj.vsl_slan_cd.value + "]";
		    	formObj.com_content.value="Lane : " + formObj.vsl_slan_cd.value;
		    	formObj.com_content.value += "<br>Period : From " + formObj.start_date.value + " To " + formObj.end_date.value;
				ComSendMailModal();
			}
			break;
		case "btn_DownExcel":
			$("iframe[name^='IBSheetDown']").remove();
			var data = [];
			
			var localFrames = document.form.getElementsByTagName("iframe");
			for(var i=0; i<arrXml.length-1; i++){
			    data.push(localFrames[i].contentWindow.Down2Excel());
			}
			 
			if(sheetObjects[0].RowCount() > 0){
 				data.push(sheetObjects[0].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"Remark"}));
			}
			if(sheetObjects[1].RowCount() > 0){
 				data.push(sheetObjects[1].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"VesselCode"}));
			}
			if(sheetObjects[2].RowCount() > 0){
 				data.push(sheetObjects[2].Down2Excel({DebugMode:1, HiddenColumn:1, Merge:1, AutoSizeColumn: 1, SheetName:"PortCode"}));
			}
			
			Grids["g_down2ExcelBuffer"] = data.join("\x03");
			
			sheetObjects[0].Down2ExcelBuffer(false);
			break;
		case "btn_OK":
			var vvdArr=new Array();
			for(var i=0; i<vvdMap.size(); i++){
				vvdArr.push(vvdMap.getPos(i));
			}
			//window.returnValue=vvdArr;
			ComPopUpReturnValue(vvdArr);
			ComClosePopup(); 
			break;
		case "btn_Close":
			ComClosePopup(); 
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

function getLanecd( rtnVal ){
	var formObj=document.form;
	var rVal = rtnVal[0];
	if( rVal.length > 0  ){
		formObj.vsl_slan_cd_1.value = rVal[1];
	}
}

function callBackVslCd(rVal) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if(rVal){
		formObj.vsl_cd.value=rVal[0][1];
		if(formObj.vsl_cd.value == ""){
			formObj.tmp_vsl_cd.value = "";
			if(slanObj2.style.display == "block"){
				initVslSlanCd("1");
			}
			return false;
		}
		if(formObj.vsl_cd.value!=formObj.tmp_vsl_cd.value){
			if(doActionIBSheet(sheetObj, formObj, SEARCH01)){
				// in case vsl_slan_cd is not selected and vssel code Retrieve Result is true, then Retrieving lane list
				if(slanObj2.style.display == "block" ||
					(slanObj1.style.display == "block" && formObj.vsl_slan_cd_1.value=="")
				){
					doActionIBSheet(sheetObj, formObj, SEARCH03);
				}
			}else{
				initVslSlanCd("1");
				formObj.vsl_cd.focus();
				return false;
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
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i]);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	setCurrentPeriod();
	formObj.vsl_slan_cd_1.select();
	slanObj1=document.getElementById("span_vsl_slan_cd_1");
	slanObj2=document.getElementById("span_vsl_slan_cd_2");
	initVslSlanCd("1");
}
function initPage(){
	var formObj=document.form;
	formObj.cre_dt.value='';
	formObj.cre_usr_id.value='';
	formObj.upd_dt.value='';
	formObj.upd_usr_id.value='';
	for(var i = vvdMap.size(); i >= 0 ; i--) {
		vvdMap.remove(i);
	}
	sheetObjects[2].RemoveAll();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // Remark Grid
		  with(sheetObj){
		    	tabIndex=-1;
			   var HeadTitle="Remark(s)|Remark(s)|Remark(s)";
			   var headCount=ComCountHeadTitle(HeadTitle);
		
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
		
			   var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"VVD",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"RMK",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1, MultiLineText:1 } ];
			    
			   InitColumns(cols);
			   SetEditable(0);
			   SetWaitImageVisible(0);
			   resizeSheet();
	      }
		break;
	case "sheet2": // Vessel Names
		  with(sheetObj){
			    tabIndex=-1;
			   
			   var HeadTitle="Vessel Code|Vessel Name";
			   var headCount=ComCountHeadTitle(HeadTitle);
		
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
		
			   var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			    
			   InitColumns(cols);
		
			   SetEditable(0);
			   SetWaitImageVisible(0);
			   SetSheetHeight(200);
			   SetVisible(false);
	      }
		break;
	case "sheet3": // Port Names
		  with(sheetObj){
			    tabIndex=-1;
			   if (location.hostname != "")
			   var HeadTitle="Port Code|Port Name";
			   var headCount=ComCountHeadTitle(HeadTitle);
			   (headCount, 0, 0, false);
		
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
		
			   var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"port_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			    
			   InitColumns(cols);
		
			   SetEditable(0);
			   SetWaitImageVisible(0);
			   SetSheetHeight(200);
			   SetVisible(false);
	      }
		break;
	}
}

// registering initial event
function initControl() {
	var formObj	= document.form;
	axon_event.addListenerForm("blur"	, "obj_deactivate"	, formObj);
	axon_event.addListenerForm("change"	, "obj_change"		, formObj);
	axon_event.addListenerForm("keyup"	, "obj_keyup"		, formObj);

	$(document.form.vsl_cd).on('blur', function(){
		obj_deactivate();
	});
}

function obj_keyup() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	
	if (ComChkLen(srcValue, srcMaxLength) == "2")
	{
		if (srcName == "vsl_slan_cd_1")
			formObj.vsl_cd.focus();
		else (srcName == "vsl_cd")
			formObj.btn_Retrieve.focus();
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	
	sheetObj.ShowDebugMsg(false);
	
	switch (sAction) {
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		ComOpenWait(true);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0012GS.do" , sParam);
		ComOpenWait(false);
		var vsl_slan_nm=ComGetEtcData(sXml, "vsl_slan_nm");
		if(!vsl_slan_nm){
			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
			formObj.tmp_vsl_slan_cd.value="";
			formObj.vsl_slan_cd.value="";
			formObj.vsl_slan_cd_1.value="";
			formObj.vsl_slan_cd_1.focus();
		}else{
			formObj.tmp_vsl_slan_cd.value=formObj.vsl_slan_cd.value;
			ComSetNextFocus();
		}
//		initPage();
		break;
		
	case SEARCH01: // Vessel Code Retrieve
			formObj.f_cmd.value=SEARCH01;
			var sParam=FormQueryString(formObj);
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0012GS.do", sParam);
			ComOpenWait(false);
			var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
			if(!vsl_eng_nm){
				ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value='';
				formObj.vsl_cd.value='';
				return false;
			}else{
				//ComSetNextFocus();
				formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
//				formObj.vsl_cd.focus();
				return true;
			}
	//		initPage();
			break;
			
	case SEARCH02: // Long Range SKD Inquiry
		if(slanObj1.style.display=="block"){
			formObj.vsl_slan_cd.value=formObj.vsl_slan_cd_1.value;
		}else if(slanObj2.style.display=="block"){
			formObj.vsl_slan_cd.value=formObj.vsl_slan_cd_2.value;
		}
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value=SEARCH02;
			initPage();
			var sParam=FormQueryString(formObj);
			ComOpenWait(true);
 			var sXml=sheetObj.GetSearchData("VOP_VSK_0012GS.do", sParam);
			arrXml=sXml.split("|$$|");
			deleteSheet();
//			if(VskGetErrorXml(sXml)){
			if (isXmlValid(sXml)) {
				ComOpenWait(false);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}else{
				vslEngNmEtcData=ComGetEtcData(arrXml[0], "vsl_eng_nms");
				portNmEtcData=ComGetEtcData(arrXml[0], "port_nms");
				// Initializing searchComplete as number of grid
				searchComplete=new Array();
				subGridHeight=new Array();
				for(var idx=1; idx<arrXml.length; idx++){
					searchComplete[idx]=false;
					subGridHeight[idx]=0;
				}
				// arrXml[0] : ETC data, then starting as 1
				//::2015-04-19:://for(var idx=1; idx<arrXml.length; idx++){
				for(var idx=(arrXml.length-1); idx>=1; idx--){
					// sheet1 : remark grid
					var sheetid="sheet" + (idx+1);
					ComSheetObject4VSK("sheet_div" , sheetid, idx);
				}
			}
		}
		break;
		
	case SEARCH03: // Vessel Code Retrieve in case of Lane Code is null
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
		formObj.vsl_slan_cd.value="";
		formObj.f_cmd.value=SEARCH03;
		var sParam=FormQueryString(formObj);
		ComOpenWait(true);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0012GS.do", sParam);
		ComOpenWait(false);
		var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		if(!vsl_eng_nm){
			ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
			formObj.tmp_vsl_cd.value="";
			formObj.vsl_cd.value="";
		}else{
			var vsl_slan_cd_arr=ComGetEtcData(sXml, "vsl_slan_cd_arr");
			var spanObj=null;
			initVslSlanCd("2");
			var comboObj=formObj.vsl_slan_cd_2;
			comboObj.options.length=0;
			comboObj.options.add(new Option("ALL", ""));
			if(vsl_slan_cd_arr){
				vsl_slan_cd_arr=vsl_slan_cd_arr.split("|");
				for(var i=1; i<vsl_slan_cd_arr.length; i++){ // i=0일때는 그냥 공백이므로 제외
					comboObj.options.add(new Option(vsl_slan_cd_arr[i], vsl_slan_cd_arr[i]));	
				}
			}
			formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
			formObj.vsl_cd.focus();
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(ComChkLen(vsl_slan_cd.value, 3)==2 || ComChkLen(vsl_cd.value, 4)==2){
			return true;
		}else{
			ComShowCodeMessage('VSK00027', 'Lane Code or Vessel Code');
			return false;
		}
	}
}
/**
 * Handling change event
 */
function obj_change() {
	
	var formObj		= document.form;
	var sheetObj	= sheetObjects[0];
	
	//alert(ComGetEvent("name"));
	
	switch (ComGetEvent("name")) {
		case "start_qt":
			formObj.start_date.value=ComGetMaskedValue(startQuarterDay(
					parseInt(formObj.start_year.value), formObj.start_qt.value), "ymd");
			if(formObj.start_date.value > formObj.end_date.value){
				formObj.end_qt.value=formObj.start_qt.value;
				formObj.end_date.value=ComGetMaskedValue(endQuarterDay(
						parseInt(formObj.end_year.value), formObj.end_qt.value), "ymd");
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "end_qt":
			formObj.end_date.value=ComGetMaskedValue(endQuarterDay(
					parseInt(formObj.end_year.value), formObj.end_qt.value), "ymd");
			if(formObj.start_date.value > formObj.end_date.value){
				formObj.start_qt.value=formObj.end_qt.value;
				formObj.start_date.value=ComGetMaskedValue(startQuarterDay(
						parseInt(formObj.start_year.value), formObj.start_qt.value), "ymd");
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "start_date":
			controlYearQuarterByDate(formObj, "start_date");
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
		case "end_date":
			controlYearQuarterByDate(formObj, "end_date");
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
			
			break;
			
		case "start_year":
			with(formObj) {
				if (start_year.value > end_year.value) {	    			
					end_year.value = start_year.value;
				}
				
				/** Setup Lane Combo **/
				fnSetupLaneCodeCombo();
		    }
			break;
		case "end_year":
			with(formObj) {
			if (start_year.value > end_year.value) {	    			
				start_year.value = end_year.value;
			}
			
			/** Setup Lane Combo **/
			fnSetupLaneCodeCombo();
	    }
			break;
	}
}

function controlYearQuarterByDate(formObj, objName){
	switch(objName){
		case "start_date":
			var start_date=formObj.start_date.value;
			if(ComIsDate(start_date)){
				start_date=ComGetUnMaskedValue(start_date, "ymd");
				formObj.start_year.value=start_date.substring(0, 4);
				formObj.start_qt.value=checkQuarter(start_date);
			}
			break;
		case "end_date":
			var end_date=formObj.end_date.value;
			if(ComIsDate(end_date)){
				end_date=ComGetUnMaskedValue(end_date, "ymd");
				formObj.end_year.value = end_date.substring(0, 4);
				formObj.end_qt.value=checkQuarter(end_date);
			}
			break;
	}
}

/**
 * Handling Enter key event
 */
//function enter_keypress(){
//	VskKeyEnter();
//}
function obj_deactivate() {
	
	var formObj		= document.form;
	var sheetObj	= sheetObjects[0];
	var obj 		= ComGetEvent();
	
	switch(ComGetEvent("name")){
	
		case "start_date":
			ComChkObjValid(ComGetEvent()); // when focus out, checking period
			controlYearQuarterByDate(formObj, "start_date");
			
			var startDate = ComReplaceStr(formObj.start_date.value, "-", "");
			var endDate   = ComReplaceStr(formObj.end_date.value, "-", "");
			if (endDate < startDate) {
				
				formObj.end_date.value = startDate;
				controlYearQuarterByDate(formObj, "end_date");
				formObj.end_year.value = parseInt(formObj.start_year.value);
				formObj.end_date.value = ComGetMaskedValue(endQuarterDay(formObj.end_year.value, formObj.end_qt.value), "ymd");
				
			}
			
			break;
			
		case "end_date":
			ComChkObjValid(ComGetEvent()); // when focus out, checking period
			controlYearQuarterByDate(formObj, "end_date");
			
			var startDate = ComReplaceStr(formObj.start_date.value, "-", "");
			var endDate   = ComReplaceStr(formObj.end_date.value, "-", "");
			
			if (endDate < startDate) {
				
				formObj.start_date.value = endDate;
				controlYearQuarterByDate(formObj, "start_date");
				formObj.start_year.value = parseInt(formObj.end_year.value);
				formObj.start_date.value = ComGetMaskedValue(startQuarterDay(formObj.start_year.value, formObj.start_qt.value), "ymd");
				
			}		
			
			break;
			
		case "vsl_slan_cd_1":
			if(formObj.vsl_slan_cd_1.value!="" &&
					formObj.vsl_slan_cd_1.value!=formObj.tmp_vsl_slan_cd.value){
				formObj.vsl_slan_cd.value=formObj.vsl_slan_cd_1.value;
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
			
		case "vsl_cd":
			
			//alert('obj.value >> '+obj.value);
			
			if(obj.value==""){
				formObj.tmp_vsl_cd.value="";
				if(slanObj2.style.display == "block"){
					initVslSlanCd("1");
				}
				return false;
			}
			
			//alert('formObj.tmp_vsl_cd.value >> '+formObj.tmp_vsl_cd.value);
			
			if(obj.value!=formObj.tmp_vsl_cd.value){
				if(doActionIBSheet(sheetObj, formObj, SEARCH01)){
					
					// in case vsl_slan_cd is not selected and vssel code Retrieve Result is true, then Retrieving lane list
					//::2015-08-25:by TOP:://if(slanObj2.style.display == "block" || (slanObj1.style.display == "block" && formObj.vsl_slan_cd_1.value=="")){
						
					if(obj.value != "" || slanObj2.style.display == "block" || (slanObj1.style.display == "block" && formObj.vsl_slan_cd_1.value=="")){
						doActionIBSheet(sheetObj, formObj, SEARCH03);
					}
				}else{
					initVslSlanCd("1");
					formObj.vsl_cd.focus();
					return false;
				}
			}
			break;
	}
}

/**
 * Returning Start Date per Quarter
 */
function startQuarterDay(year, Quarter) {
	switch (Quarter) {
	case "1":
		return year + "0101";
		break;
	case "2":
		return year + "0401";
		break;
	case "3":
		return year + "0701";
		break;
	case "4":
		return year + "1001";
		break;
	}
	return true;
}
/**
 * Returning Last Date per Quarter
 */
function endQuarterDay(year, Quarter) {
	switch (Quarter) {
	case "1":
		return year + "0331";
		break;
	case "2":
		return year + "0630";
		break;
	case "3":
		return year + "0930";
		break;
	case "4":
		return year + "1231";
		break;
	}
	return true;
}

function ComSheetObject4VSK(objectid, sheetid, idx){
    try {
    	var target=document.getElementById(objectid);
    	var $wrapper = $(target).find('#mainTb');
    	if(!target){
    		return null;
    	}
//    	var ifr=document.createElement('<iframe name="ifr_' + sheetid + '" id="ifr_' + sheetid + '" frameborder="no" scrolling="no" width="100%" height="0" src="VOP_VSK_0012_01.do" onload=postLoad("ifr_' + sheetid + '",' + idx + ')></iframe>');
//    	target.appendChild(ifr);
    	var $mIframe = $('<iframe name="ifr_' + sheetid + '" id="ifr_' + sheetid + '" frameborder="no" scrolling="no" width="100%" height="0" src="VOP_VSK_0012_01.do" onload=postLoad("ifr_' + sheetid + '",' + idx + ')></iframe>');
//    	target.appendChild($mIframe[0]);
    	$wrapper.after($mIframe);
    	
    } catch(err) { ComFuncErrMsg(err.message); }
}

function postLoad(frameid, idx){
	var ifrObj=document.getElementById(frameid);
	var HeadCol1=ComGetEtcData(arrXml[0], "HeadTitle1_" + (idx));          
    var HeadCol2=ComGetEtcData(arrXml[0], "HeadTitle2_" + (idx));          
    var HeadCol3=ComGetEtcData(arrXml[0], "HeadTitle3_" + (idx));          
    var HeadCol4=ComGetEtcData(arrXml[0], "HeadTitle4_" + (idx));
    var HeadCol5=ComGetEtcData(arrXml[0], "HeadTitle5_" + (idx));
    var HeadCol6=ComGetEtcData(arrXml[0], "HeadTitle6_" + (idx));
    var HeadCol7=ComGetEtcData(arrXml[0], "HeadTitle7_" + (idx));
    // Header Title and Remark Information are in arrXml[0]
    // SKD Information is in arrXml[1]
    //
    //
    // grid id
    // sheet1, sheet2, sheet3, sheet4 (sheet1-remark)
    //
    // frameid, idx
    // [ifr_sheet2 : 1], [ifr_sheet3 : 2], [ifr_sheet4 : 3]
    //
    // result xml(arrXml) array
    // arrXml[0], arrXml[1], arrXml[2], arrXml[3] (arrXml[0]-remark)
    window.frames[frameid].loadXml(idx, arrXml[idx], HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7);
}
function setSize(frameid, height){
//	var ifrObj = document.getElementById('ifr_sheet' + (frameid+1));
	//ifrObj.height = rows * 20 + 10;
	//ifrObj.height = height + 10;
	subGridHeight[frameid]=height + 10;	
}
function deleteSheet(){
	var sheetDiv=document.getElementById("sheet_div");
	var iframes=sheetDiv.getElementsByTagName("iframe");
	// sheet object delete
	for(var idx=0; idx<iframes.length; idx++){
		window.frames['ifr_sheet' + (idx+2)].resetSheet();
	}
	// iframe delete
	for(var idx=iframes.length; idx>0; idx--){
		sheetDiv.removeChild(iframes[idx-1]);
	}
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
}
function getSubInfo(){
	var formObj=document.form;
	var info=new Object();
	info.vvdMap=vvdMap;
	info.select_yn=formObj.select_yn.value;
	info.pop_yn=formObj.pop_yn.value;
	return info;
}
function postProcess(idx){
	var formObj=document.form;
	searchComplete[idx]=true;
	var flag=true;
	for(var idx=1; idx<searchComplete.length; idx++){
		flag=flag && searchComplete[idx];
	}
	// after loading grid, start processing(handling height, etc.)
	if(flag){
		// Remark
		ComOpenWait(true);
		sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		ComOpenWait(false);
		for(var idx=1; idx<subGridHeight.length; idx++){
			document.getElementById('ifr_sheet' + (idx+1)).height=subGridHeight[idx];
		}
		if("Y"!=formObj.pop_yn.value){
//			parent.syncHeight();
		}
		var vslEngNms=vslEngNmEtcData.split(";");
		var portNms=portNmEtcData.split(";");
		var Row;
		var vslEngNm;
		var portNm;
		for(var i=0; i<vslEngNms.length; i++){
			Row=sheetObjects[1].DataInsert();
			vslEngNm=vslEngNms[i].split("|");
			sheetObjects[1].SetCellValue(Row, 0,vslEngNm[0],0);
			sheetObjects[1].SetCellValue(Row, 1,vslEngNm[1],0);
		}
		for(var i=0; i<portNms.length; i++){
			Row=sheetObjects[2].DataInsert();
			portNm=portNms[i].split("|");
			sheetObjects[2].SetCellValue(Row, 0,portNm[0],0);
			sheetObjects[2].SetCellValue(Row, 1,portNm[1],0);
		}
		sheetObjects[2].DataInsert(); // this is for preventing the last row missing when excel download. It seems IBsheet's bug.
		// Only VesselCode Sort
		sheetObjects[1].ColumnSort("vsl_cd");
		// Sort of the PortCode is in SchedulePlanningOperationSC. (IBsheet's bug)
		//sheetObjects[2].ColumnSort("port_cd"); 
	}

	resizeSheet();
	if (sheetObjects[0].GetSheetHeight() < 160) {
		sheetObjects[0].SetSheetHeight(160);
	}	
}

function checkPeriod(formObj){
	var startDate=ComReplaceStr(formObj.start_date.value, "-", "");
	var endDate=ComReplaceStr(formObj.end_date.value, "-", "");
	var tmpDate=ComGetDateAdd(startDate, "Y", 1);
    // By Hwang 7.16  	
	if(ComChkPeriod(startDate, endDate) < 1){
		ComShowCodeMessage("VSK57101", "Start date", "End date");
		return false;
	} else {
		if(ComChkPeriod(endDate, tmpDate)==1){			
			return true;
		}else{
			ComShowCodeMessage("VSK00105", "1 year");
			return false;
		}
	}
}
/**
 * Returning last date of quarter
 * @param date
 * @return
 */
function checkQuarter(date){
	var month_date=date.substring(4, 8);
	if(month_date <= "0331"){
		return "1";
	}else if(month_date <= "0630"){
		return "2";
	}else if(month_date <= "0930"){
		return "3";
	}else{
		return "4";
	}
}
// Setting current year
function setCurrentPeriod(){
	var today=new Date();
	var formObj=document.form;
	with (formObj) {
		var nowDate=ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		start_year.value=today.getFullYear();
		end_year.value=today.getFullYear();
		var quarter=checkQuarter(nowDate);
		start_qt.value=quarter;
		end_qt.value=quarter;
		start_date.value=ComGetMaskedValue(startQuarterDay(
				parseInt(start_year.value), quarter), "ymd");
		end_date.value=ComGetMaskedValue(endQuarterDay(
				parseInt(end_year.value), quarter), "ymd");
	}	
}
/**
 * type 1 : vsl_slan_cd_1(input) activating
 * type 2 : vsl_slan_cd_2(combo) activating
 */
function initVslSlanCd(type) {
	var formObj=document.form;
	if(type=="1"){
		slanObj1.style.display="block";
		slanObj2.style.display="none";
	}else if(type=="2"){
		slanObj1.style.display="none";
		slanObj2.style.display="block";
	}
	formObj.vsl_slan_cd_1.value="";
	formObj.vsl_slan_cd_2.value="";
	formObj.vsl_slan_cd.value="";
}

function isXmlValid(xmlStr) {
	try {
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
        if(xmlRoot.nodeName == "ERROR"){
        	return true;
        }
        return false;
	} catch (err) {
		return false;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

function fnSetupLaneCodeCombo(){
	
	var formObj		= document.form;
	var sheetObj	= sheetObjects[0];
	
	if(formObj.vsl_cd.value != "" && formObj.vsl_cd.value.length == 4){
		doActionIBSheet(sheetObj, formObj, SEARCH03);
	}
}
