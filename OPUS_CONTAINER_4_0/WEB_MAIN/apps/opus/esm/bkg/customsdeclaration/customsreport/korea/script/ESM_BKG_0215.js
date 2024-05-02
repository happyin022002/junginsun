/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0215.js
*@FileTitle  : : DownLoad History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/22
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
function esm_bkg_0215()
{
	this.processButtonClick=processButtonClick;
	this.funcChangeSearchOption=funcChangeSearchOption;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.setComboObject=setComboObject;
	this.initCombo=initCombo;
	this.cboMsgTp_OnChange=cboMsgTp_OnChange;
	this.cboTp_OnChange=cboTp_OnChange;
	this.validateForm=validateForm;
}
//public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_retrieve":	// search
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break; 
		case "btn_downexcel":	// down load excel
			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
		case "rad_mrn":			// selection of MRN 
			sheetObject1.RemoveAll();
			//searching mrn_no 
			formObject.txt_mrn.readOnly=false;
			formObject.txt_vvd.readOnly=true;
			formObject.txt_pol.readOnly=true;
			formObject.txt_pod.readOnly=true;
			formObject.date_from.readOnly=true;
			formObject.date_to.readOnly=true;
			formObject.txt_mrn.value='';
			formObject.txt_vvd.value='';
			formObject.txt_pol.value='';
			formObject.txt_pod.value='';
			formObject.date_from.value='';
			formObject.date_to.value='';
			formObject.txt_mrn.className="input1";
			formObject.txt_vvd.className="input2";
			formObject.txt_pol.className="input2";
			formObject.txt_pod.className="input2";
			formObject.date_from.className="input2";
			formObject.date_to.className="input2";
			formObject.rad_vvd.checked=false;
			formObject.rad_dat.checked=false;
			formObject.txt_mrn.focus();
			break;
		case "rad_vvd":			// selecting VVD
			sheetObject1.RemoveAll();
			//searching vvd, pol, pod
			formObject.txt_mrn.readOnly=true;
			formObject.txt_vvd.readOnly=false;
			formObject.txt_pol.readOnly=false;
			formObject.txt_pod.readOnly=false;
			formObject.date_from.readOnly=true;
			formObject.date_to.readOnly=true;
			formObject.txt_mrn.value='';
			formObject.txt_vvd.value='';
			formObject.txt_pol.value='';
			formObject.txt_pod.value='';
			formObject.date_from.value='';
			formObject.date_to.value='';
			formObject.txt_mrn.className="input2";
			formObject.txt_vvd.className="input1";
			formObject.txt_pol.className="input1";
			formObject.txt_pod.className="input1";
			formObject.date_from.className="input2";
			formObject.date_to.className="input2";
			formObject.rad_mrn.checked=false;
			formObject.rad_dat.checked=false;
			formObject.txt_vvd.focus();			
			break;
		case "rad_dat":			// selecting DATE 
			sheetObject1.RemoveAll();
			// searching date
			formObject.txt_mrn.readOnly=true;
			formObject.txt_vvd.readOnly=true;
			formObject.txt_pol.readOnly=true;
			formObject.txt_pod.readOnly=true;
			formObject.date_from.readOnly=false;
			formObject.date_to.readOnly=false;
			formObject.txt_mrn.value='';
			formObject.txt_vvd.value='';
			formObject.txt_pol.value='';
			formObject.txt_pod.value='';
			formObject.txt_mrn.className="input2";
			formObject.txt_vvd.className="input2";
			formObject.txt_pol.className="input2";
			formObject.txt_pod.className="input2";
			formObject.date_from.className="input1";
			formObject.date_to.className="input1";
			formObject.rad_mrn.checked=false;
			formObject.rad_vvd.checked=false;
			//formObject.date_from.value = time.now();
			var now=new Date();
			var year=now.getFullYear();
			var month=now.getMonth() + 1;	// January=0,December=11, plus 1
			var day=now.getDate();
			if(month < 10) month='0' + month;
			if(day < 10) day='0' + day;
			var dateval='' + year + '-' + month + '-' + day;
			formObject.date_from.value=dateval;
			formObject.date_to.value=dateval;
			formObject.date_from.focus();
			break;
		case "btn_calendar":		// Calendar event 
			formObject.txt_mrn.readOnly=true;
			formObject.txt_vvd.readOnly=true;
			formObject.txt_pol.readOnly=true;
			formObject.txt_pod.readOnly=true;
			formObject.date_from.readOnly=false;
			formObject.date_to.readOnly=false;
			formObject.txt_mrn.className="input2";
			formObject.txt_vvd.className="input2";
			formObject.txt_pol.className="input2";
			formObject.txt_pod.className="input2";
			formObject.date_from.className="input1";
			formObject.date_to.className="input1";
			formObject.rad_mrn.checked=false;
			formObject.rad_vvd.checked=false;
			formObject.rad_dat.checked=true;
			var cal=new ComCalendarFromTo();
			cal.select(formObject.date_from, formObject.date_to, 'yyyy-MM-dd');
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
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */ 
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
	    with(sheetObj){
	        (12, 0, 0, true);
	        var HeadTitle="|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
	        var prefix="";
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
						 {Type:"Text",      Hidden:0, Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mrn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"userid",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"blcount", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	        InitColumns(cols);	
	        SetEditable(0);
	        SetWaitImageVisible(0);
	        SetSheetHeight(440);
		}
	    break;
	}
}

// handling of Sheet 
function doActionIBSheet(sheetObj,formObj,sAction) {
	var formObject=document.form;
	switch(sAction) {
	case IBSEARCH:      //search
		formObj.f_cmd.value=SEARCH;
		var ret=ComGetPrefixParam("sheet1_");
		if(validateForm(sheetObj, formObject,sAction)) {
			ComOpenWait(true);
 			sheetObj.DoSearch("ESM_BKG_0215GS.do", FormQueryString(formObj) );
		}
		break;
	case IBDOWNEXCEL:      // down load excel
// 		sheetObj.Down2Excel({ HiddenColumn:1});
 		if(sheetObj.RowCount() < 1){//no data	
 			ComShowCodeMessage("COM132501");
 		}else{	
 			 sheetObj.Down2Excel({ HiddenColumn:1 , SheetDesign:1});
 		}	

		break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction)
{
	if(formObj.rad_mrn.checked)
	{
		if(formObj.txt_mrn.value == '')
		{
			ComShowCodeMessage("BKG00888", "MRN");
			formObj.txt_mrn.focus();
			return false;
		}
	}
	else if(formObj.rad_vvd.checked)
	{
		if(formObj.txt_vvd.value == '')
		{
			ComShowCodeMessage("BKG00888", "VVD");
			formObj.txt_vvd.focus();
			return false;
		}
		if(formObj.txt_pol.value == '' && formObj.txt_pod.value == '')
		{
			ComShowCodeMessage("BKG00888", "POL or POD");
			formObj.txt_pol.focus();
			return false;
		}
	}
	else if(formObj.rad_dat.checked)
	{
		if(formObj.date_from.value == '')
		{
			ComShowCodeMessage("BKG00888", "Date");
			formObj.date_from.focus();
			return false;
		}
		if(formObj.date_to.value == '')
		{
			ComShowCodeMessage("BKG00888", "Date");
			formObj.date_to.focus();
			return false;
		}
		if(formObj.date_from.value.length == 10)
		{
			if(formObj.date_to.value.length == 10)
			{
				if(!ComIsDate(formObj.date_from.value))
				{
					ComShowCodeMessage("COM12132");
					formObj.date_from.focus();
					return false;
				}
				else if(!ComIsDate(formObj.date_to.value))
				{
					ComShowCodeMessage("COM12132");
					formObj.date_to.focus();
					return false;
				}
				if(ComChkPeriod(formObj.date_from.value, formObj.date_to.value) < 1)
				{
					ComShowCodeMessage("COM132002");
					formObj.date_from.focus();
					return false;
				}
				var days=ComGetDaysBetween(formObj.date_from.value, formObj.date_to.value);
				if(days > 7)
				{
					ComShowCodeMessage("COM132001", days, "7");
					formObj.date_from.focus();
					return false;
				}
			}
			else
			{
				ComShowCodeMessage("COM12132");
				formObj.date_to.focus();
				return false;
			}
		}
		else
		{
			ComShowCodeMessage("COM12132");
			formObj.date_from.focus();
			return false;
		}
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
} 