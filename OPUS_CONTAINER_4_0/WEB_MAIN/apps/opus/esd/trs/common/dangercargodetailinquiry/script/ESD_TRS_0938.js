/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0938.js
*@FileTitle  : BKG CGO SPE Detail Popup - DG
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
 * @class ESD_TRS_0938 : 
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
			case "btng_apply":
			break;
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
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}
/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
//    ComKeyOnlyAlphabet('uppernum');
}
/**
 * BKG Creation <br>
 **/
function manual_click() {
    //Activating Bkg_no to edit mode when manual check box is checked
//    form.boo_bkg_no.readOnly =!form.manual.checked;
}
/**
 * Processing when booking number of tap BKG Creation is changed
 **/
function bkgno_keyup() {
    //Handling bl_no comparing with the saved data
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value="";
    else
	form.boo_bl_no.value=form.hdn_boo_bl_no.value;
	*/
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){
//    return ComChkObjValid(event.srcElement);
}
/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
//    ComClearSeparator(event.srcElement);
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
//    ComKeyOnlyNumber(event.srcElement);
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
	      var HeadTitle0="Cargo\nSEQ|HCDG|UN No|IMO\nClass|Gross WGT\n(Kg)|Net WGT\n(Kg)|Prop. Ship NM|HAZ Contents|Flash Point\n(℃)|Control Temp\n(℃)|Emergency Temp(℃)|"
	      +"Packing Group|Sub\nLabel|EMS No|LTD QTY|Marine\nPollutant|ERG|PSA\nGroup|Cargo\nStatus|Emergency Contact\nPhone No|Certificate No|IMO Class 1 Only|IMO Class 1 Only|"
	      +"IMO Class 7 Only (Radioactive Commodities)|IMO Class 7 Only (Radioactive Commodities)|IMO Class 7 Only (Radioactive Commodities)|"
	      +"Outer Package|Outer Package|Outer Package|Inner Package|Inner Package|Inner Package|Remark";
	      var HeadTitle1="Cargo\nSEQ|HCDG|UN No|IMO\nClass|Gross WGT\n(Kg)|Net WGT\n(Kg)|Prop. Ship NM|HAZ Contents|Flash Point\n(℃)|Control Temp\n(℃)|Emergency Temp(℃)|"
	      +"Packing Group|Sub\nLabel|EMS No|LTD QTY|Marine\nPollutant|ERG|PSA\nGroup|Cargo\nStatus|Emergency Contact\nPhone No|Certificate No|Detail of CNEE|Net Explosive\nWGT (kg)|"
	      +"Schedule|Activity|Activity|1st QTY|Type|Type|1st QTY|Type|Type|Remark";

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle0, Align:"Center"},
	                  { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"certi_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_desc2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
	             {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } ];
	       
	      		InitColumns(cols);
	      		SetEditable(0);
	            SetRangeBackColor(1, 19, 1, 32,"#555555");
//	            SetSheetHeight(ComGetSheetHeight(sheetObj, 12))
	            resizeSheet();
	      }


		break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("ESD_TRS_0938GS.do", TrsFrmQryString(formObj) );
		break;
		case IBLOADEXCEL:        //Excel upload
 			sheetObj.LoadExcel();
		break;
	}
}


//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
}