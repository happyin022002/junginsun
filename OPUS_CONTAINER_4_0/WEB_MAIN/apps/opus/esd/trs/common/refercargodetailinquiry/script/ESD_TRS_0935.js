/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0935.js
*@FileTitle  : BKG CGO SPE Detail Popup - RF
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle  */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btng_apply":
			break;
			case "btn_close":
				ComClosePopup();
				//window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90392" );
			ComShowMessage(errMsg);
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
 	 * initControl
	 **/
	function initControl() {
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);     
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');    
	}
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}
	function manual_click() {
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}
	function bkgno_keyup() {
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value="";
	    else
		form.boo_bl_no.value=form.hdn_boo_bl_no.value;
		*/
	}
	function obj_blur(){
	//    return ComChkObjValid(event.srcElement);
	}
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
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
            	var HeadTitle0="CA|MA|HM|Commodity|Commodity|Nature|Temp|Temp|Humidity (%)|Ventilation|"
            					+"Package|Package|Gross WGT|Gross WGT|Net WGT|Net WGT|Drain|Genset|Volt|Remark";
            	var HeadTitle1="CA|MA|HM|| |Nature|℃|℉|Humidity (%)|%|| || "
            					+"|| |Drain|Genset|Volt|Remark";

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle0, Align:"Center"},
            	                { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_atms_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"modi_atms_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"humid_ctrl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clng_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Float",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cdo_temp",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Float",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fdo_temp",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Int",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"humid_no",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vent_rto",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Float",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Float",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"net_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_drn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pwr_spl_cbl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Int",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vltg_no",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 },
            	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 }  ];
            	 
            		InitColumns(cols);
	            	SetSheetWidth(mainTable.clientWidth);
	            	SetSheetHeight(ComGetSheetHeight(sheetObj,12)) ;
	            	Editable=false;
	            	SetRangeBackColor(1, 6, 1, 15,"#555555");// ENIS
	            	SetRangeBackColor(1, 3, 1, 4,"#555555");// ENIS
            	}
                break;
        }
    }
	/*
	 * handling of Sheet 
	 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESD_TRS_0935GS.do",TrsFrmQryString(formObj) );
		break;
		case IBLOADEXCEL:        
			sheetObj.LoadExcel();
		break;
	}
}
