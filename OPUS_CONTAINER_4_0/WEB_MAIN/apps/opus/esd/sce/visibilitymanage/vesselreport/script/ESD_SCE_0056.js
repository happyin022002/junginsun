/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0056.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var focusField="";
document.onclick=processButtonClick;

function processButtonClick() {
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				if (ComIsEmpty(formObj.s_bkg_no) && ComIsEmpty(formObj.s_cntr_no)) {
					if ( ComIsEmpty(formObj.fm_dt) ) {
						ComShowMessage("you must enter ETA Date.");
						formObj.fm_dt.focus();
						return;
					}
					if ( ComIsEmpty(formObj.to_dt) ) {
						ComShowMessage("you must enter ETA Date.");
						formObj.to_dt.focus();
						return;
					}
				}
				if(ComGetDaysBetween(formObj.fm_dt , formObj.to_dt) < 0) {
					ComShowCodeMessage("TRS90118");
					formObj.fm_dt.focus();
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && !ComIsEmpty(formObj.s_pol_pod) && ComIsEmpty(formObj.s_rail_dest) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 30 ) {
					ComShowMessage("Possible inquiry period is limited to 30 days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && ComIsEmpty(formObj.s_neweq_office) && ComIsEmpty(formObj.s_vvd) && ComIsEmpty(formObj.s_rail_dest) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 21) {
					ComShowMessage("Possible inquiry period is limited to 21 Days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && !ComIsEmpty(formObj.s_neweq_office) && ComIsEmpty(formObj.s_rail_dest) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 30 ) {
					ComShowMessage("Possible inquiry period is limited to 30 days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && ComIsEmpty(formObj.s_pol_pod) && !ComIsEmpty(formObj.s_vvd) && ComIsEmpty(formObj.s_rail_dest) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 21 ) {
					ComShowMessage("Possible inquiry period is limited to 21 days.");
					return false;
				} else if ( !ComIsEmpty(formObj.fm_dt) && !ComIsEmpty(formObj.to_dt) && !ComIsEmpty(formObj.s_rail_dest) && ComGetDaysBetween(formObj.fm_dt.value , formObj.to_dt.value) > 56 ) {
					ComShowMessage("Possible inquiry period is limited to 56 days(8 weeks).");
					return false;
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,'RTV');
				break;
			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;
	  		case "btn_clm":
		  		goESD_SCE_0044(sheetObj);
				break;
	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
	  		case "btn_downonly":	
				doActionIBSheet(sheetObj,formObj,IBSEARCH,'XLS');
				break;
	  		case "btn_downcsv":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;
			case "btn_calendar":
					cal=new ComCalendarFromTo();
	  				cal.displayType="date";
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				break;
			case "btns_multiinput" :
				    openESD_SCE_0048();
				break;
			case "btn_close" :
					ComClosePopup(); 
				break;
			case "btn_send": 				
				 doActionIBSheet(sheetObj,formObj,MODIFY);			
				 break;
			case "btng_provider":
				rep_OnPopupClick();
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");
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
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function loadPage() {
	var formObject=document.form;
	formObject.f_cmd.value=SEARCH05;   
	var sXml=sheetObjects[0].GetSearchData("ESD_SCE_0057GS.do",SceFrmQryString(formObject));
	var vals=ComGetEtcData(sXml, "ALL_COL");
	var iCheckRow='';
	if(vals != undefined && vals != "") {	// exists setup info
		formObject.RptInfoCtnt.value=vals;
		var RptInfoCtnt=formObject.RptInfoCtnt.value;
	   	for(var a = 0; a < RptInfoCtnt.length; a++) {
	   		var RptInfoCtnt2=RptInfoCtnt.substring(a, a+1);
	   		if(RptInfoCtnt2 == "1") {
	   			iCheckRow=iCheckRow + '|' +formObject.iCheckRow.value.split('|')[a];
			}
	   	}
		iCheckRow=iCheckRow + '|'
	}
	addColDesc('', '', '', iCheckRow);
}   

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var  xs1=document.form.coldesc1.value;
	var  xs2=document.form.coldesc2.value;
	var  xs3=document.form.iCheckRow.value;
	var  xs4=document.form.chkcnt.value;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
		    with(sheetObj) {
	        	var aryRows;
	        	if (xs3.length > 0) {
	        		aryRows=xs3.split("|");
	        	} else {
	        		aryRows=new Array();
	        	}
	        	var HeadTitle1="CHK|SEQ|BKG|Container|324 EDI Status|324 EDI\nSend Date/Time|B/L No.|Unmatch List|BKG|BKG|COP|COP|TY/SZ|MVMT|MVMT Yard|MVMT DT|"
	        		          +"DUP|VVD|Lane|ETA|SPE|Rail DEST|CSTMS\nCLR LOC|EQ Office|Term|Add|S/P|S/P|Rail|Rail|Rail|Truck(Shuttle)|Truck(Shuttle)|Truck(Shuttle)|"
	        		          +"Truck(Additional)|Truck(Additional)|Truck(Additional)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|Truck(Door)|"
	        		          +"COP Status|From|Guide|P/UP Node|AVL Date|Free Date|F|O|C|CM|P/UP NO.|P/UP Office|P/UP End|S/C NO.|CNEE|CNEE Address|SHPR|SHPR Address|"
	        		          +"NTFY|NTFY Address|Filer|IT NO.|IT Date|PO NO.|Seal NO.|Weight|CLM|CLM|CLM|CLM|Remark|Internal Hold|Internal Hold";
	        	var HeadTitle2="CHK|SEQ|BKG|Container|324 EDI Status|324 EDI\nSend Date/Time|B/L No.|Unmatch List|POD|DEL|POD|DEL|TY/SZ|MVMT|MVMT Yard|MVMT DT|"
	        		          +"DUP|VVD|Lane|ETA|SPE|Rail DEST|CSTMS\nCLR LOC|EQ Office|Term|Add|Code|Name|Plan|S/O|W/O|Plan|S/O|W/O|Plan|S/O|W/O|Plan|S/O|W/O|"
	        		          +"DR_WK|DR_FM|DR_TO|DR_S/P|DR_S/P Name|COP Status|From|Guide|P/UP Node|AVL Date|Free Date|F|O|C|CM|P/UP NO.|P/UP Office|P/UP End|S/C NO.|CNEE|CNEE Address|"
	        		          +"SHPR|SHPR Address|NTFY|NTFY Address|Filer|IT NO.|IT Date|PO NO.|Seal NO.|Weight|CLM Status|CLM Location|CLM ST|CLM Date|Remark|Flag|Remarks";

	        	SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:0, HeaderCheck:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, //0
	        	             {Type:"Seq",       Hidden:0, Width:30,    Align:"Left",    ColMerge:1,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //1
	        	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //2
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //3
	        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_snd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //4
	        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //5
	        	             
	        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //6
	        	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"unmatch_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //7
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //8
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //9
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cop_pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //10
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cop_del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //11
				             
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tpsz",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //12
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //13
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_yd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //14
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mvmt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //15
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dup_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //16
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //17
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //18
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eta",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //19
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"spe",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //20
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_dest",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //21
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //22
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //23
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"term",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //24
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"add_trsp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //25
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //26
				             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"vndr_name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //27
				             
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rl_so_pln_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //28
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rl_so_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //29
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rl_wo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //30
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ts_so_pln_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //31
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ts_so_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //32
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ts_wo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //33
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tc_so_pln_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //34
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tc_so_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //35
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tc_wo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //36
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_so_pln_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //37
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_so_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //38
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_wo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //39
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dr_wo_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //40
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_fm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //41
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_to",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //42
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_sp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //43
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dr_sp_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //44
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cop_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //45
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"frm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //46
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"guide",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //47
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pkup_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //48
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pkup_aval_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //49
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pkup_free_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //50
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"f",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //51
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"o",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //52
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //53
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dspo_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //54
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //55
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //56
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pkup_end",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //57
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //58
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //59
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"cnee_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //60
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"shpr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //61
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"shpr_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //62
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //63
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //64
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"filer",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //65
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"it_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //66
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"it_date",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //67
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"po_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //68
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //69
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //70
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"clm_crnt_sts",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //71
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"clm_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //72
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_state",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //73
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"clm_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //74
				             {Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cntr_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //75
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"do_hld_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //76
				             {Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, //77
				             {Type:"Status",    Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 }]; //78
	        	for(var k = 2; k <= 77; k++) {
	        		SetColHidden(k,1);
	        	}
	        	var tmp_col_ndx = 0;
	        	for( var k = 0; k < aryRows.length; k++) {
	        		tmp_col_ndx = Number(aryRows[k]) + 1;
	        		if (aryRows[k] == '0') SetColHidden(0,0);
	        		if (aryRows[k] == '1') SetColHidden(1,0);
	        		if (aryRows[k] == '2') SetColHidden(2,0);
	        		if (aryRows[k] == '3') SetColHidden(3,0);
					if (aryRows[k] == '4') SetColHidden(4,0);
					if (aryRows[k] == '5') SetColHidden(5,0);
					if (aryRows[k] == '6') SetColHidden(6,0);
					if (aryRows[k] == '7') SetColHidden(7,0);
					if (aryRows[k] == '8') SetColHidden(8,0);
					if (aryRows[k] == '9') SetColHidden(9,0);
					if (aryRows[k] == '10') SetColHidden(10,0);
					if (aryRows[k] == '11') SetColHidden(11,0);
					if (aryRows[k] == '12') SetColHidden(12,0);
					if (aryRows[k] == '13') SetColHidden(13,0);
					if (aryRows[k] == '14') SetColHidden(14,0);
					if (aryRows[k] == '15') SetColHidden(15,0);
					if (aryRows[k] == '16') SetColHidden(16,0);
					if (aryRows[k] == '17') SetColHidden(17,0);
					if (aryRows[k] == '18') SetColHidden(18,0);
					if (aryRows[k] == '19') SetColHidden(19,0);
					if (aryRows[k] == '20') SetColHidden(20,0);
					if (aryRows[k] == '21') SetColHidden(21,0);
					if (aryRows[k] == '22') SetColHidden(22,0);
					if (aryRows[k] == '23') SetColHidden(23,0);
					if (aryRows[k] == '24') SetColHidden(24,0);
					if (aryRows[k] == '25') SetColHidden(25,0);
					if (aryRows[k] == '26') SetColHidden(26,0);
					if (aryRows[k] == '27') SetColHidden(27,0);
					if (aryRows[k] == '28') SetColHidden(28,0);
					if (aryRows[k] == '29') SetColHidden(29,0);
					if (aryRows[k] == '30') SetColHidden(30,0);
					if (aryRows[k] == '31') SetColHidden(31,0);
					if (aryRows[k] == '32') SetColHidden(32,0);
					if (aryRows[k] == '33') SetColHidden(33,0);
					if (aryRows[k] == '34') SetColHidden(34,1);//Truck(Additional) Plan
					if (aryRows[k] == '35') SetColHidden(35,1);//Truck(Additional) S/O
					if (aryRows[k] == '36') SetColHidden(36,1);//Truck(Additional) W/O
					if (aryRows[k] == '37') SetColHidden(37,0);
					if (aryRows[k] == '38') SetColHidden(38,0);
					if (aryRows[k] == '39') SetColHidden(39,0);
					if (aryRows[k] == '40') SetColHidden(40,0);
					if (aryRows[k] == '41') SetColHidden(41,0);
					if (aryRows[k] == '42') SetColHidden(42,0);
					if (aryRows[k] == '43') SetColHidden(43,0);
					if (aryRows[k] == '44') SetColHidden(44,0);
					if (aryRows[k] == '45') SetColHidden(45,0);
					if (aryRows[k] == '46') SetColHidden(46,0);
					if (aryRows[k] == '47') SetColHidden(47,0);
					if (aryRows[k] == '48') SetColHidden(48,0);
					if (aryRows[k] == '49') SetColHidden(49,0);
					if (aryRows[k] == '50') SetColHidden(50,0);
					if (aryRows[k] == '51') SetColHidden(51,0);
					if (aryRows[k] == '52') SetColHidden(52,0);
					if (aryRows[k] == '53') SetColHidden(53,0);
					if (aryRows[k] == '54') SetColHidden(54,0);
					if (aryRows[k] == '55') SetColHidden(55,0);
					if (aryRows[k] == '56') SetColHidden(56,0);
					if (aryRows[k] == '57') SetColHidden(57,0);
					if (aryRows[k] == '58') SetColHidden(58,0);
					if (aryRows[k] == '59') SetColHidden(59,0);
					if (aryRows[k] == '60') SetColHidden(60,0);
					if (aryRows[k] == '61') SetColHidden(61,0);
					if (aryRows[k] == '62') SetColHidden(62,0);
					if (aryRows[k] == '63') SetColHidden(63,0);
					if (aryRows[k] == '64') SetColHidden(64,0);
					if (aryRows[k] == '65') SetColHidden(65,0);
					if (aryRows[k] == '66') SetColHidden(66,0);
					if (aryRows[k] == '67') SetColHidden(67,0);
					if (aryRows[k] == '68') SetColHidden(68,0);
					if (aryRows[k] == '69') SetColHidden(69,0);
					if (aryRows[k] == '70') SetColHidden(70,0);
					if (aryRows[k] == '71') SetColHidden(71,0);
					if (aryRows[k] == '72') SetColHidden(72,0);
					if (aryRows[k] == '73') SetColHidden(73,0);
					if (aryRows[k] == '74') SetColHidden(74,0);
					if (aryRows[k] == '75') SetColHidden(75,0);
					if (aryRows[k] == '76') SetColHidden(76,0);
					if (aryRows[k] == '77') SetColHidden(77,0);
	        	}
	 
	        	InitColumns(cols);
	        	SetColWidth("seq", 30);
	        	resizeSheet(); 
			}
		    break;
		case 9:	  //IBSheet1 init
		    with(sheetObj) {
				var varNewTitle1=xs1.replace(/,/g, '|');
	        	var varNewTitle2=xs2.replace(/,/g, '|');
	        	var aryTitle1;
	        	var aryTitle2;
	        	var aryRows;
	        	if (xs3.length > 0) {
	        		aryRows=xs3.split("|");
	        	} else {
	        		aryRows=new Array();
	        	}
	        	if (varNewTitle1.length > 0) {
	        		aryTitle1=varNewTitle1.split("|");
	        	} else {
	        		aryTitle1=new Array();
	        	}
	        	if (varNewTitle2.length > 0) {
	        		aryTitle2=varNewTitle2.split("|");
	        	} else {
	        		aryTitle2=new Array();
	        	}
	        	varNewTitle1='';
	        	varNewTitle2='';
	        	if(aryTitle1.length > 0) {
	        		for( var k = 0; k < aryTitle1.length; k++) {
	        			if(k == 0) varNewTitle1=aryTitle1[k];
	        			else varNewTitle1=varNewTitle1 + '|' + aryTitle1[k];
	        		}
	        	}
	        	if(aryTitle2.length > 0) {
	        		for( var k = 0; k < aryTitle2.length; k++) {
	        			if(k==0) varNewTitle2=aryTitle2[k];
	        			else varNewTitle2=varNewTitle2 + '|' + aryTitle2[k];
	        		}
	        	}
	        	if(varNewTitle1 != '') {
	        		varNewTitle1=varNewTitle1;
	        	}
	        	if(varNewTitle2 != '') {
	        		varNewTitle2=varNewTitle2;
	        	}
	        	var colCnt1=aryTitle1.length;
	        	var colcount1=colCnt1;
			    var colCnt2=aryTitle2.length;
			    var colcount2=colCnt2;
			    var HeadTitle1="SEQ|"+varNewTitle1;
			    var HeadTitle2="SEQ|"+varNewTitle2;
		
			    SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},
			                { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            for( var k = 0; k < aryRows.length; k++) {
	            	cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            	cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    
				    cols.push({Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				    cols.push({Type:"Text",      Hidden:0,  Width:280,  Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	            }
	 
	            InitColumns(cols);

	            SetEditable(0);
	      	}
		    break;

	}
}

// handling process of sheet
function doActionIBSheet(sheetObj,formObj,sAction, loc) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBROWSEARCH:
	       if(validateForm(sheetObj,formObj,sAction)) {
	    	   formObj.f_cmd.value=SEARCH01;
	    	   sheetObj.DoSearch("ESD_SCE_0056GS.do", SceFrmQryString(formObj) );
               formObj.totcnt.value=0;
               if(sheetObj.GetEtcData("totcnt")>0) {
            	   formObj.totcnt.value=" " + sheetObj.GetEtcData("totcnt");
               }
	       }
	       break;
	   case IBSEARCH:	  //retrieving
		   var newForm="";
	       if(validateForm(sheetObj,formObj,sAction)) {	        	
	    	   if(loc == "RTV" ) {
	    		   formObj.f_cmd.value=SEARCHLIST;
	    		   formObj.target="_self";
	    		   sheetObj.DoSearch("ESD_SCE_0056GS.do", SceFrmQryString(formObj) );
	    	   } else if (loc == "XLS") {
	    		   formObj.f_cmd.value=SEARCH03;
	    		   formObj.target="_blank"; 
	    		   formObj.action="ESD_SCE_0205.do";
	    		   formObj.submit();
	    	   }
	       }
	       break;
	    case MODIFY:	  //EDI 324 Send
	    	if(validateForm(sheetObj,formObj,sAction)) {
	    		formObj.f_cmd.value = MODIFY;
	    		ComOpenWait(true);  
	    		var varRtn = sheetObj.DoSave("ESD_SCE_0056GS.do", SceFrmQryString(formObj),"chk");	 
	    		if(!varRtn) {
	    			ComOpenWait(false); 
	    		}
	    	}
	         
	        break;    
	   case IBDOWNEXCEL:		// excel down
		   if(sheetObj.RowCount() < 1) {//no data
			   ComShowCodeMessage("COM132501");
		   } else {
			   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		   }
		   break;
	   case IBSEARCH_ASYNC01:      // csv down
		   var downCols = "";
		   for(var k = 2; k <= 77; k++) { //77
			   if(k== 34 || k == 35 || k == 36 ) {
				   continue;
			   } else {
				   downCols += k +"|";   
			   }
		   }
		   sheetObj.Down2Text({ DownCols: downCols, ColDelim:"",FileName:"USIOR",DownHeader:true,DownCombo:"CODE"});
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
	var result=true;
	switch (sAction) {
		case IBSEARCH:
			// checking mandatory input item
			if(!chkEssItems(formObj)) {
            		result=false;
			}
			// checking date format
			else if(!ComIsEmpty(formObj.fm_dt)&&!ComIsEmpty(formObj.to_dt)) {
				if(!ComIsDate(formObj.fm_dt)) {
			        ComShowCodeMessage("SCE90003","Date");
			        formObj.fm_dt.focus();
			        result=false;
			    }
			    else if(!ComIsDate(formObj.to_dt)) {
			        ComShowCodeMessage("SCE90003","Date");
			        formObj.to_dt.focus();
			        result=false;
			    }
			}
			break;
		case MODIFY:
			var totalRow = sheetObj.RowCount() + 2;
			var chkCount = 0;
			    for( i = 0; i < totalRow; i++) {
			    	 if (sheetObj.GetCellValue(i, "chk") == "1") {
			      		 if (sheetObj.GetCellValue(i ,"vndr_seq") != "104779") {
			    			 chkCount++;
			    		 }
			    	 }
			    }
			    if (chkCount > 0 ) {
			    	ComShowMessage("324 EDI only can be available to BNSF(S/P : 104779).");
			    	result = false;
			    }
			break;	
		default:
			break;
	}
	return result;
}

function chkEssItems(formObj) {
	var result = true;
	if(ComIsEmpty(formObj.fm_dt)) {
	   if (!ComIsEmpty(formObj.s_bkg_no) || !ComIsEmpty(formObj.s_cntr_no)) { // if bkg_no is not empty or cntr_no is not empty even though date is empty ----- OK
	   } else if(!ComIsEmpty(formObj.s_vvd)&&!ComIsEmpty(formObj.s_pol_pod)) {
	   } else {
    		ComShowCodeMessage("COM12140", "Period", "start date & end date");
    		formObj.fm_dt.focus();
    		result=false;
	   }
	} else if(ComIsEmpty(formObj.to_dt)&&(ComIsEmpty(formObj.s_vvd)||ComIsEmpty(formObj.s_pol_pod))) {
	   if (!ComIsEmpty(formObj.s_bkg_no) || !ComIsEmpty(formObj.s_cntr_no)) { // if bkg_no is not empty or cntr_no is not empty even though date is empty ----- OK
	   } else if(!ComIsEmpty(formObj.s_vvd)&&!ComIsEmpty(formObj.s_pol_pod)) {
	   } else {
   			ComShowCodeMessage("COM12140", "Period", "start date & end date");
    		formObj.to_dt.focus();
    		result=false;
	   }
	}
	return result;
}

function chkDateKind(formObj) {
	var result=true;
	if(!ComIsEmpty(formObj.date_kind)) {
		if(!ComIsDate(formObj.fm_dt)) {
			ComShowCodeMessage("SCE90003","Date");
			formObj.fm_dt.focus();
			result = false;
		} else if(!ComIsDate(formObj.to_dt)) {
			ComShowCodeMessage("SCE90003","Date");
			formObj.to_dt.focus();
			result = false;
		}
	}
	return result;
}

function chgDateKind(val) {
	var formObj=document.form;
	if(val=="") {
		formObj.fm_dt.value="";
		formObj.to_dt.value="";
		formObj.fm_dt.readOnly=true;
		formObj.to_dt.readOnly=true;
	} else {
		formObj.fm_dt.readOnly=false;
		formObj.to_dt.readOnly=false;
	}
}

var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    var formObj=document.form;
    selectVal=SceFrmQryString(formObj);
    ++iPageNo;
//method change[check again]CLT
    sheetObj.DoSearch("ESD_SCE_0056GS.do", selectVal+"&"+ "cur_page=" + iPageNo, {Append:true});
}

function goESD_SCE_0044(sheetObj) {
	var row=sheetObj.GetSelectRow();
	if(row < 0) {
		ComShowCodeMessage("SCE90018");
  		return;
  	}
	var cntrNO=sheetObj.GetCellValue(row, "cntr_no");
	var tpszCd=sheetObj.GetCellValue(row, "tpsz");
  	newForm="<form name='form1' method='post'>";
	newForm += "  <input type='hidden' name='cntr_no' value='" + cntrNO + "'>";
	newForm += "  <input type='hidden' name='tpsz_cd' value='" + tpszCd + "'>";
    newForm += "</form>";
    document.all.new_form.innerHTML=newForm;
    var formObj=document.form1;
    var paramUrl="cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
    var newWin =  ComOpenWindow("ESD_SCE_0044.do?"+paramUrl,  "clm_win",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:525px" , true);
}

function getCenterXY(w, h) {
	var height=screen.availHeight;
	var width=screen.availWidth;
	var leftpos=width/2 - w/2;
	var toppos=height/2 - h/2;
	if(leftpos<0) leftpos=0;
	if(toppos<0) toppos=0;
	return "left=" + leftpos + ", top=" + toppos;
}

function openColumnList() {
	var formObject=document.form;
	var newWin =  ComOpenWindow("ESD_SCE_0057.do",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:360px" , true);
}

function addColDesc(coldesc1, coldesc2, chkcnt, iCheckRow) {
	if(coldesc1 != '') {
        document.getElementById('coldesc1').value=coldesc1;
	}
	if(coldesc2 != '') {
        document.getElementById('coldesc2').value=coldesc2;
	}
	if(chkcnt != '') {
        document.getElementById('chkcnt').value=chkcnt;
	}
	if(iCheckRow != '') {
        document.getElementById('iCheckRow').value=iCheckRow;
	}
	
	initCustmSheet();
}

/** 
 * unmatch flag='Y' fontcolor=red
*/
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
      var rowCount=sheetObj.RowCount();
		var routFlag='';
		for(i = 0 + parseInt(sheetObj.HeaderRows()); i < rowCount + parseInt(sheetObj.HeaderRows()); i++) {
			routFlag=sheetObj.GetCellValue(i, "unmatch_flg");
			if(routFlag=='Y') {
				sheetObj.SetRowBackColor(i,"#FF0000");
				for(var j = 1; j < 68; j++) // checking total count of sheet cell
//parameter changed[check again]CLT
					sheetObj.SetCellFont("FontSize", i, j,9);
			}
		}		
		sheetObj.SetHeaderCheck(0,0,1);
		sheetObj.CheckAll("chk",1,0);	
  }

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
} 

function initCustmSheet() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}

//BKG_NO, BL_NO, CNTR_NO 입력 받는 메소드(POP UP 에서 호출한다.)
function openAddPaste(dist) {
	var formObject=document.form;
	var s_neweq_office=formObject.s_neweq_office.value;
	if (dist == 's_neweq_office' | dist == 's_rail_dest') {
		var newWin =  ComOpenWindow("ESD_SCE_0064.do?dist="+dist,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px" , true);
    } else {
    	var newWin =  ComOpenWindow("ESD_SCE_0064.do?dist="+dist,  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px" , true);
    }
}

function addValueNo(dist, multi_value) {
	var multis=multi_value.split('\n');
	multi_value='';
	for(var i = 0; i < multis.length; i++) {
		if(multis[i] != '') {
			if(i == 0) {
				multi_value=multis[i];
			} else {
				multi_value=multi_value + ',' + multis[i];
			}
   		}
	}
	if(multi_value != '') {
		document.getElementById(dist).value=multi_value;
	}
}

function sheet1_OnSaveEnd(code,msg) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	 
	ComOpenWait(false);  
	doActionIBSheet(sheetObj,formObj,IBSEARCH,'RTV');
}

/**
 * rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * enter check
 */
function enterCheck(obj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (ComGetEvent("keycode") == 13) {
		switch (ComGetEvent("name")) {
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}

/**
 * Pop-up call rep_commodity
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_rep";
	var xx1 = "";
	var xx2 = "";
	var xx3 = "";
	var xx4 = "";
	var xx5 = "";
	var xx6 = "";
	var xx7 = "";
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 478, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}