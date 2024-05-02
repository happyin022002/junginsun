/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0263
*@FileTitle  : Self Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/


//===================================================================================
//global variable
//===================================================================================
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var intervalId;
var intervalTime = 2000;
var processCnt = 0;
//variable
//column variable
//===================================================================================
//initializing page
//===================================================================================
/** 
* registering IBSheet Object sheetObjects as list <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return 
* @see #
* @author 
* @version 
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen.. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  
* @return 
* @see #
* @author 
* @version 
*/ 
function loadPage() {
	var form=document.form;
    //initializing IBSheet 
    sheet1=sheetObjects[0];
    sheetCnt=sheetObjects.length ;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);  
    }
//    sheet1.SetWaitImageVisible(0); XXX
    //initializing html control
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
//    window.attachEvent("onbeforeunload",reloadOpener);
    form.bl_no.value=form.bl_no_org.value;
    doActionIBSheet(sheet1, form, IBSEARCH);    
}
/** 
* initializing sheet <br>
* adding first-served functions after loading screen.. <br>
* adding case as numbers of counting sheets. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : sheet Object
* @param {int} sheetNo : sequence 
* @return 
* @see #
* @author 
* @version 
*/ 
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		    var HeadTitle1="Error\nKind|Description|Booking|Contract|mtch_umch_tp_cd|Audit Result";
		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    InitHeaders(headers, info);
		    var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"umch_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"umch_tp_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:385,  Align:"Left",    ColMerge:0,   SaveName:"bkg_itm_log",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1, MultiLineText:1 },
		              {Type:"Text",      Hidden:0,  Width:385,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_itm_log",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1, MultiLineText:1 },
		              {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mtch_umch_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mtch_umch_tp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		     
		    InitColumns(cols);
		    SetSheetHeight(560);
//		    SetWaitImageVisible(0); XXX
		    SetEditable(0);
	      	}
	      	break;
	}
}
//===================================================================================
//handling button event
//===================================================================================
document.onclick=processButtonClick;
/** 
* Event handler processing by button name 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param    
* @return 
* @see #
* @author 
* @version 
*/ 
function processButtonClick(){
	var form=document.form;
    try {
	    var srcName=ComGetEvent("name");
	    switch(srcName) {
	    	case "btn_Retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			doActionIBSheet(sheet1, form, IBSEARCH);
	    		}
	    		break;
			case "btn_New":
				//alert("btn_New");
				//form.bl_no.value = form.bl_no_org.value;
				form.bl_no.value="";
				form.audit_result.value="";
				sheet1.RemoveAll();
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
}
//===================================================================================
//Axson Event Handler
//===================================================================================
/** 
*  Onbeforedeactivate of Object (event handler) <br>
* checking validation with dataformat of object   <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param   
* @return 
* @see #
* @author 
* @version 2009.10.29
*/ 
function obj_deactivate() {
	var formObj=event.srcElement;
    var srcName=formObj.getAttribute("name");
    switch(srcName) {
    	case "bl_no":
			break;
		default :
			ComChkObjValid(formObj);
			break;
	}
}
//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
*  OnSearchEnd event handler after searching sheet1 data <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : sheet Object  
* @param  {string} errMsg : error Message
* @return 
* @see #
* @author 
* @version 
*/ 
function sheet1_OnSearchEnd(sheetObj, Code, errMsg) {
	ComOpenWait(false);
	var form=document.form;
	sheet1.SetSheetFontName("Arial");
	sheet1.SetColFontColor("bkg_itm_log","#FF0000");
	if (errMsg == "") {
    	if(sheet1.RowCount()> 0) {
    		var cellFont="Lucida Console";
    		var cellFontSize=12;
    	    var startRow=sheet1.HeaderRows();
    		var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
    		var tmpStr="";
    		for(var i=startRow; i < endRow; i++) {
    			sheet1.SetRowHeight(i,0);
    			tmpStr="";
    			tmpStr=sheet1.GetCellValue(i, "bkg_itm_log") + "\n";
    			sheet1.SetCellValue(i, "bkg_itm_log",tmpStr);
    			tmpStr="";
    			tmpStr=sheet1.GetCellValue(i, "ctrt_itm_log") + "\n";
    			sheet1.SetCellValue(i, "ctrt_itm_log",tmpStr);
    			sheet1.SetCellFont("FontName", i, "bkg_itm_log", i, "bkg_itm_log", cellFont);
				sheet1.SetCellFont("FontName", i, "ctrt_itm_log", i, "ctrt_itm_log", cellFont);
				sheet1.SetCellFont("FontSize", i, "bkg_itm_log", i, "bkg_itm_log", cellFontSize);
				sheet1.SetCellFont("FontSize", i, "ctrt_itm_log", i, "ctrt_itm_log", cellFontSize);
    		}
    	}
    }
}   
//===================================================================================
//server searching/saving
//===================================================================================
/** 
* doActionIBSheet which is calling function of server<br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : sheet Object  
* @param  {object} formObj : form Object
* @param  {sAction} sAction : value which is used set to f_cmd of form  
* @return 
* @see #
* @author 
* @version 
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
//        case IBSEARCH: // search
//        	var params="f_cmd=" + SEARCH + "&bl_no=" + formObj.bl_no.value;
//	    	ComOpenWait(true);
//	    	sheet1.SetWaitImageVisible(0);
// 			var sXml=sheet1.GetSearchData("ESM_BKG_0263GS.do?", params);
//			if(ComGetEtcData(sXml, "auditResultNm") != undefined){
//				formObj.audit_result.value=ComGetEtcData(sXml, "auditResultNm");
//			}
//			sheet1.LoadSearchData(sXml,{Sync:1});
//			if(ComGetEtcData(sXml, "result") != undefined){
//				ComShowMessage(ComGetEtcData(sXml, "result"));
//			}
//			break;

	    case IBSEARCH: // 조회
	    
	    	var params = "f_cmd=" + SEARCH + "&bl_no=" + formObj.bl_no.value + "&ca_flg=" + formObj.ca_flg.value ;
	    	ComOpenWait(true);
//	    	sheet1.WaitImageVisible = false;
//	    	sheet1.SetWaitImageVisible(1); XXX
//			var sXml = sheet1.GetSearchXml("ESM_BKG_0263GS.do?", params);
			var sXml=sheet1.GetSearchData("ESM_BKG_0263GS.do", params);
	
			if (ComGetEtcData(sXml, "jobID")) {
				ComSetObjValue(formObj.key, ComGetEtcData(sXml, "jobID"));
	            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
			} else {
				ComOpenWait(false);
			}
			break;
			
		case SEARCH01: // BackEndJob 결과 조회
	    	ComSetObjValue(formObj.f_cmd,SEARCH01);
	    	params = FormQueryString(formObj);
	    	var sXml = sheet1.GetSearchData("ESM_BKG_0263GS.do", params);
			if (ComGetEtcData(sXml, "result") || ComGetEtcData(sXml, "auditResultNm")) {
		    	if (ComGetEtcData(sXml, "auditResultNm")) {
					ComSetObjValue(formObj.audit_result, ComGetEtcData(sXml, "auditResultNm"));
				}
				if (ComGetEtcData(sXml, "result")) {
					ComShowMessage(ComGetEtcData(sXml, "result"));
				}
				sheet1.LoadSearchData(sXml);
	    		clearInterval(intervalId);
				ComOpenWait(false);
			}
		    break;
	}
}
/** 
* handling process for input validateForm <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : sheet Object  
* @param  {object} formObj : form Object
* @param  {sAction} sAction : value which is used set to f_cmd of form  
* @return 
* @see #
* @author 
* @version 
*/ 
function validateForm(sheetObj, formObj, sAction){
	var form=document.form;
	var blNoObj=form.bl_no;
	var blNoCaption=blNoObj.caption;
	var blNoVal=blNoObj.value; 
	switch (sAction) {
	    case IBSEARCH: //search
	    	if(blNoVal.length < blNoObj.maxLength) {
				ComShowCodeMessage("BKG95018", blNoCaption, blNoObj.maxLength);
				ComSetFocus(blNoObj);
				return false;
	    	}
	    	break;
    }
    return true;
}
function reloadOpener() {
	if (opener && opener.document && opener.document.getElementById("btn_t10retrieve")) {
		opener.document.getElementById("btn_t10retrieve").fireEvent("onclick");
	}
}

//BackEndJob 결과 조회용 루프 함수
function callIntervalBackEndJob() {
	if (300==processCnt++) {  //intervalTime(2초) * 300 = 10분
		clearInterval(intervalId);
		ComOpenWait(false);
	}
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}
