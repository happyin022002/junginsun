/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0936.js
*@FileTitle  : BKG CGO SPE Detail Popup - AK
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0936 : 
 */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	/***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_close":
				ComClosePopup(); 
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90392" );
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	initControl();
}
/**
 * Loading the event of HTML Control <br>
 *  Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
			      var HeadTitle0="Package|Package|Gross WGT|Gross WGT|Net WGT|Net WGT|Commodity|Commodity|Total Dimension (cm)|Total Dimension (cm)|Total Dimension (cm)"
			      +"|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Over Dimension (cm)|Stowage Request|Void Space\n(FEU)|Remark";
			      var HeadTitle1="||||||||Length|Width|Height"
			      +"|Front|Rear|Height|Left|Right|Stowage Request|Void Space\n(FEU)|Remark";
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                  { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"net_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ttl_dim_len",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ttl_dim_wdt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ttl_dim_hgt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ovr_fwrd_len",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ovr_bkwd_len",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ovr_hgt",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ovr_lf_len",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ovr_rt_len",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"stwg_rqst_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ovr_void_slt_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(0);
			            SetRangeBackColor(1, 8, 1, 15,"#555555");// ENIS
			            SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
	      }


		break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("ESD_TRS_0936GS.do", TrsFrmQryString(formObj) );
		break;
		case IBLOADEXCEL:        //Excel upload
 			sheetObj.LoadExcel();
		break;
	}
}
