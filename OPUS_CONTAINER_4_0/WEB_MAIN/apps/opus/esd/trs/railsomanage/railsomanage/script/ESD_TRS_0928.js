/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0928.js
*@FileTitle  : IRG Adjust Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
/**
 * @extends Bkg
 * @class ESD_TRS_0928 : IRG Adjust
 */
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
//var calPop = new ComCalendarGrid();
var sheetObjects=new Array();
var sheetCnt=0;
var initFlag=1;
var opener_obj = opener;
if(!opener_obj) {
	opener_obj = parent;
}
var opensheetObject;
var docObjcheck = opener_obj.docObjsep; 
if(opener_obj.form.rail_billing_type.value=="M"){
	opensheetObject = opener_obj.sheetObjects[1]; //PARENT GRID	
}else{
	opensheetObject = opener_obj.sheetObjects[0]; //PARENT GRID
};

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	IBS_Sheet2SheetStatus2(opensheetObject, "chk1");
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
	        
			      var HeadTitle="Seq|R/D Term|POL/POD|From Node|From Node|To Node|To Node|IRG|Route Plan|Reference No|Remark|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives|Alternatives";
			      var HeadTitle1="Seq|R/D Term|POL/POD|Loc|Node|Loc|Node|IRG|Route Plan|Reference No|Remark|Alt|rout_org|rout_dest|rout_seq|Prio|IRG|From Node|From Node|To Node|To Node|Plan|Ref No|Remark|NEW_RAIL_CMB_THRU_TP";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:1,   SaveName:"seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:57,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcvde_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"polpod",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:1,   SaveName:"irg",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rout_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo", 	Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irg_dropdownlist",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"new_rout_org",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"new_rout_dest",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"new_rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"new_prio_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:1,   SaveName:"new_irg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"new_fm_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"new_fm_nod_yard",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"new_to_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"new_to_nod_yard",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"new_rout_pln_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"new_ref_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"new_inlnd_rout_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"new_rail_cmb_thru_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"from_node",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_node",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"prio_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"key_org",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"key_dest",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_nod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_nod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
//			      SetSheetHeight(350);
			      resizeSheet();
			      SetRangeBackColor(1, 2, 1, 36,"#555555");
	            }
		break;
		case 2:      //sheet1 init
		    with(sheetObj){
	        
			      var HeadTitle="seq|s_SEQ|Priority|IRG|Route Plan|Reference No|Remark|ROUT_ORG_NOD|ROUT_DEST_NOD|ROUT_SEQ|RAIL_CMB_THRU_TP|RTR";
		
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"key_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"alt_sub_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prio_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ref_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"inlnd_rout_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rtr",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:1,   SaveName:"irg",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_nod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ic_1",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ic_2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
		
			      SetEditable(1);
			      SetSheetHeight(320);
	            }
		break;
	}
}
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
			case "btn_ok":
				IBS_Sheet3SheetStatus2(sheetObject, opensheetObject, formObject, "chk1");
			break;
			case "btn_close":
				ComClosePopup(); 
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function doActionIBSheet(sheetObj, formObj, sAction, chk) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
		if (chk =='M')
		{
			formObj.f_cmd.value=SEARCH04;
 			sheetObj.DoSearch("ESD_TRS_0928GS.do", TrsFrmQryString(formObj),{Sync:2} );
		} else if ( chk =='D')	{
			formObj.f_cmd.value=SEARCH15;
 			sheetObj.DoSearch("ESD_TRS_0928GS_1.do", TrsFrmQryString(formObj) + "&"+ sheetObjects[0].GetSaveString(true),{Sync:2});
		}
		break;
	}
}
//opensheetObject, "chk1"
function IBS_Sheet2SheetStatus2(fromSheet, sStatus) {
	objInit();
	
	//함수 인자 유효성 확인
	if (typeof fromSheet != "object"){
		return false;
	}
	var docSeperate="";
	var docParameter="";
	var key_org="";
	var key_dest="";
	var doc_cgo_tp_cd="";
	var sRow=fromSheet.FindCheckedRow(sStatus);
	var arrRow=sRow.split("|");
	var trsp_bnd_cd="";
	var bkg_rcvde_term_cd="";
	var i=0,j=0;	
	for( var ir=0; ir < arrRow.length; ir++ ) {
		if( docObjcheck == "I" ) {
			key_org=fromSheet.GetCellValue(arrRow[ir], "pod_cd")+fromSheet.GetCellValue(arrRow[ir], "pod_cd_yard");
			key_dest=fromSheet.GetCellValue(arrRow[ir], "del_nod_cd")+fromSheet.GetCellValue(arrRow[ir], "del_nod_cd_yard");
			if( key_org == "" ) key_org="M";
			if( key_dest == "" ) key_dest="M";
			trsp_bnd_cd=fromSheet.GetCellValue(arrRow[ir],"trsp_bnd_cd");
			bkg_rcvde_term_cd=fromSheet.GetCellValue(arrRow[ir],"bkg_rcvde_term_cd");
		} else if( docObjcheck == "O" ) {
			key_org=fromSheet.GetCellValue(arrRow[ir], "por_nod_cd")+fromSheet.GetCellValue(arrRow[ir], "por_nod_cd_yard");
			key_dest=fromSheet.GetCellValue(arrRow[ir], "pol_cd")+fromSheet.GetCellValue(arrRow[ir], "pol_cd_yard");
			trsp_bnd_cd=fromSheet.GetCellValue(arrRow[ir],"trsp_bnd_cd");
			bkg_rcvde_term_cd=fromSheet.GetCellValue(arrRow[ir],"bkg_rcvde_term_cd");
		} else if( docObjcheck == "C" ) {
			doc_cgo_tp_cd=fromSheet.GetCellValue(arrRow[0], "cgo_tp_cd");
			if( doc_cgo_tp_cd == "M" ) {
				key_org="M"; 
				key_dest="M"; 
    		    trsp_bnd_cd='M';
    		    bkg_rcvde_term_cd='M'
			} else {
				key_org=fromSheet.GetCellValue(arrRow[ir], "podpor_cd") +fromSheet.GetCellValue(arrRow[ir], "podpor_yard")  ;
				key_dest=fromSheet.GetCellValue(arrRow[ir], "poldel_cd") + fromSheet.GetCellValue(arrRow[ir], "poldel_yard");
				trsp_bnd_cd=fromSheet.GetCellValue(arrRow[ir],"trsp_bnd_cd");
				bkg_rcvde_term_cd=fromSheet.GetCellValue(arrRow[ir],"bkg_rcvde_term_cd");
			}
		} else {
			doc_cgo_tp_cd="M";
			key_org="M"; 
			key_dest="M"; 
   		    trsp_bnd_cd='M';
   		    bkg_rcvde_term_cd='M'			
		}
		docSeperate=trsp_bnd_cd +","+bkg_rcvde_term_cd +","+ fromSheet.GetCellValue(arrRow[ir], "fm_nod_cd") + fromSheet.GetCellValue(arrRow[ir], "fm_nod_yard") +","+ fromSheet.GetCellValue(arrRow[ir], "to_nod_cd") + fromSheet.GetCellValue(arrRow[ir], "to_nod_yard") +","+ fromSheet.GetCellValue(arrRow[ir], "rout_org_nod_cd") +","+ fromSheet.GetCellValue(arrRow[ir], "rout_dest_nod_cd") +","+ fromSheet.GetCellValue(arrRow[ir], "rout_seq") +","+ fromSheet.GetCellValue(arrRow[ir], "cgo_tp_cd") +","+ key_org +","+ key_dest;
		HPut(ir, docSeperate);
	}
	for( var y=0; y < nodeCount; y++ ) {
		for( var x=y+1; x < nodeCount; x++ ) {
			if( HGet(y) == HGet(x) ) {
				HDel(x);
			}
		}
	}
	for( var y=0; y < nodeCount; y++ ) {
		if( HGet(y) != null ) {
			docParameter=docParameter + HGet(y) + "|";
		}
	}
	docParameter=docParameter.substring(0,docParameter.length-1);
	document.form.hid_parameter.value=docParameter;
	document.form.empty_yn.value=doc_cgo_tp_cd;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH,'M');    
	if( sheetObjects[0].RowCount() > 0 ){
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH,'D');	
		for ( i=1; i < sheetObjects[0].RowCount()+1 ; i++ ) {
			var alt_list="";
			var alt_code="";
			for ( j=0; j < sheetObjects[1].RowCount(); j++ ) {
				if(  sheetObjects[0].GetCellValue(i+1, "seq") ==  sheetObjects[1].GetCellValue(j+1, "key_seq") )   {
					alt_list=alt_list + " " + "\t" + sheetObjects[1].GetCellValue(j+1, "prio_seq") + "\t" + sheetObjects[1].GetCellValue(j+1, "irg") + "\t" +  sheetObjects[1].GetCellValue(j+1, "rout_pln_cd") + "\t" + sheetObjects[1].GetCellValue(j+1, "ref_no") + "\t" + sheetObjects[1].GetCellValue(j+1, "inlnd_rout_rmk") + "\t" + sheetObjects[1].GetCellValue(j+1, "rtr") + "|";
					alt_code=alt_code + sheetObjects[1].GetCellValue(j+1, "alt_sub_seq")+ "|";
				}
				var selected_rout_org=sheetObjects[1].GetCellValue(j+1, "rout_org_nod_cd");
				var selected_rout_dest=sheetObjects[1].GetCellValue(j+1, "rout_dest_nod_cd");
				var selected_rout_seq=sheetObjects[1].GetCellValue(j+1, "rout_seq");
				if (   sheetObjects[0].GetCellValue(i+1, "rout_org_nod_cd")  == selected_rout_org
						& sheetObjects[0].GetCellValue(i+1, "rout_dest_nod_cd") == selected_rout_dest
						& sheetObjects[0].GetCellValue(i+1, "rout_seq")		  == selected_rout_seq	)
				{
					var rowIrgrout=j+1;
				}
			}
			alt_list = alt_list.substring(0,alt_list.length-1);
			alt_code = alt_code.substring(0,alt_code.length-1);
			sheetObjects[0].CellComboItem(i+1,"irg_dropdownlist", {ComboText:alt_list, ComboCode:alt_code} );
			initFlag=0;  
			if (rowIrgrout ==0  ){
				showerr('No IRG candidates.');
				return;
			}
			sheetObjects[0].SetCellValue(i+1 , "irg_dropdownlist",sheetObjects[1].GetCellValue( rowIrgrout, "alt_sub_seq") );// DROPDOWN LIST 초기값 할당.
		}
	}
}
function IBS_Sheet3SheetStatus2(fromSheet, toSheet, formObj, sStatus) {
	objInit();
	if (typeof fromSheet != "object" ){
		return false;
	}
	if (typeof toSheet != "object"){
		return false;
	}
	var sRow=toSheet.FindCheckedRow(sStatus);
	var arrRow=sRow.split("|");
	var docSeperate="";
	var docSeperate1="";
	var docInterchange1="";
	var docInterchange2="";
	var rcvde_term="";
	for( var ir=0; ir < arrRow.length; ir++ ) {
		HPut(ir, arrRow[ir]);
	}
	/* 
	TERM,  FROM_NODE,  TO_NODE,  ROUT_ORG,  ROUT_DEST,  ROUT_SEQ
	*/
	for( var i=0; i < fromSheet.RowCount(); i++ ) {
		var bnd=fromSheet.GetCellValue(i+2, "trsp_bnd_cd");
		var cgo_tp=fromSheet.GetCellValue(i+2, "cgo_tp_cd");
		if (cgo_tp =='M'  )	{
			docSeperate=fromSheet.GetCellValue(i+2, "bkg_rcvde_term_cd") + fromSheet.GetCellValue(i+2, "from_node") + fromSheet.GetCellValue(i+2, "to_node") + fromSheet.GetCellValue(i+2, "rout_org_nod_cd") + fromSheet.GetCellValue(i+2, "rout_dest_nod_cd") + fromSheet.GetCellValue(i+2, "rout_seq");
		} else {
			docSeperate=fromSheet.GetCellValue(i+2, "bkg_rcvde_term_cd") + fromSheet.GetCellValue(i+2, "from_node") + fromSheet.GetCellValue(i+2, "to_node") + fromSheet.GetCellValue(i+2, "rout_org_nod_cd") + fromSheet.GetCellValue(i+2, "rout_dest_nod_cd") + fromSheet.GetCellValue(i+2, "rout_seq") + fromSheet.GetCellValue(i+2, "polpod");
		}
		if( fromSheet.GetCellValue(i+2, "new_fm_nod_cd") != "" && fromSheet.GetCellValue(i+2, "new_to_nod_cd") != "" ) {
			for( var v=0; v < nodeCount; v++ ) {
				if( HGet(v) != null ) {
					if (toSheet.GetCellValue(HGet(v), "bkg_rcvde_term_cd") == 'D') rcvde_term='DOOR'
				     else rcvde_term="CY";
					if (docObjcheck == 'C')	{   // correction 
						if (  bnd =='I' ) {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq") + toSheet.GetCellValue(HGet(v), "podpor_cd") + toSheet.GetCellValue(HGet(v), "podpor_yard");
						} else if (  bnd =='O' ) {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq") + toSheet.GetCellValue(HGet(v), "poldel_cd") + toSheet.GetCellValue(HGet(v), "poldel_yard");
						} else {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq");
						}
					} else {  
						if (  bnd =='I' ) {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq") + toSheet.GetCellValue(HGet(v), "pod_cd") + toSheet.GetCellValue(HGet(v), "pod_cd_yard");
						} else if (  bnd =='O' ) {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq") + toSheet.GetCellValue(HGet(v), "pol_cd") + toSheet.GetCellValue(HGet(v), "pol_cd_yard");
						} else {
							docSeperate1=rcvde_term + toSheet.GetCellValue(HGet(v), "fm_nod_cd") + toSheet.GetCellValue(HGet(v), "fm_nod_yard") + toSheet.GetCellValue(HGet(v), "to_nod_cd") + toSheet.GetCellValue(HGet(v), "to_nod_yard") + toSheet.GetCellValue(HGet(v), "rout_org_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_dest_nod_cd") + toSheet.GetCellValue(HGet(v), "rout_seq");
						}					
					}
					if( docSeperate == docSeperate1 ) {
						toSheet.SetCellValue(HGet(v), "fm_nod_cd",fromSheet.GetCellValue(i+2, "new_fm_nod_cd"),0);
						toSheet.SetCellValue(HGet(v), "fm_nod_yard",fromSheet.GetCellValue(i+2, "new_fm_nod_yard"),0);
						toSheet.SetCellValue(HGet(v), "to_nod_cd",fromSheet.GetCellValue(i+2, "new_to_nod_cd"),0);
						toSheet.SetCellValue(HGet(v), "to_nod_yard",fromSheet.GetCellValue(i+2, "new_to_nod_yard"),0);
						toSheet.SetCellValue(HGet(v), "rout_org_nod_cd",fromSheet.GetCellValue(i+2, "new_rout_org"),0);
						toSheet.SetCellValue(HGet(v), "rout_dest_nod_cd",fromSheet.GetCellValue(i+2, "new_rout_dest"),0);
						toSheet.SetCellValue(HGet(v), "rout_seq",fromSheet.GetCellValue(i+2, "new_rout_seq"),0);
						toSheet.SetCellValue(HGet(v), "rout_pln_cd",fromSheet.GetCellValue(i+2, "new_rout_pln_cd"),0);
						toSheet.SetCellValue(HGet(v), "ref_no",fromSheet.GetCellValue(i+2, "new_ref_no"),0);
						toSheet.SetCellValue(HGet(v), "inlnd_rout_rmk",fromSheet.GetCellValue(i+2, "new_inlnd_rout_rmk"),0);
						toSheet.SetCellValue(HGet(v), "rail_cmb_thru_tp_cd",fromSheet.GetCellValue(i+2, "new_rail_cmb_thru_tp_cd"),0);
						toSheet.SetCellValue(HGet(v), "interchange1_loc",fromSheet.GetCellValue(i+2, "interchange1_loc"),0);
						toSheet.SetCellValue(HGet(v), "interchange1_nod",fromSheet.GetCellValue(i+2, "interchange1_nod"),0);
						toSheet.SetCellValue(HGet(v), "interchange2_loc",fromSheet.GetCellValue(i+2, "interchange2_loc"),0);
						toSheet.SetCellValue(HGet(v), "interchange2_nod",fromSheet.GetCellValue(i+2, "interchange2_nod"),0);
						HDel(v);
					}
				}
			}
		}
	}
	ComClosePopup(); 
}
/**
 * Event of Sheet1
 */
function sheet1_OnChange(sheetObj, row , col, value) {
	var irglist_sheet=sheetObj;
	var altlist_sheet=sheetObjects[1];
	var selectedRow=0;
	if( initFlag ==0 &&  sheetObj.ColSaveName(col) == "irg_dropdownlist" ) {
		for( var i=0 ; i<altlist_sheet.RowCount();i++  )	{
			if( altlist_sheet.GetCellValue( i+1 , "key_seq") == irglist_sheet.GetCellValue( row, "seq")  && altlist_sheet.GetCellValue( i+1 , "alt_sub_seq") == value ) {
				selectedRow=i+1;
				break;
			}
		}
		var prio_seq=altlist_sheet.GetCellValue( selectedRow, "prio_seq")    ;
		var irg=altlist_sheet.GetCellValue( selectedRow, "irg");
		var rout_pln_cd=altlist_sheet.GetCellValue( selectedRow, "rout_pln_cd");
		var ref_no=altlist_sheet.GetCellValue( selectedRow, "ref_no");
		var inlnd_rout_rmk=altlist_sheet.GetCellValue( selectedRow, "inlnd_rout_rmk");
		var rout_org_nod_cd=altlist_sheet.GetCellValue( selectedRow, "rout_org_nod_cd");
		var rout_dest_nod_cd=altlist_sheet.GetCellValue( selectedRow, "rout_dest_nod_cd");
		var rout_seq=altlist_sheet.GetCellValue( selectedRow, "rout_seq");
		var rail_cmb_thru_tp_cd=altlist_sheet.GetCellValue( selectedRow, "rail_cmb_thru_tp_cd");
		var rtr_flag=altlist_sheet.GetCellValue( selectedRow, "rtr");
		var fm_nod_cd=altlist_sheet.GetCellValue( selectedRow, "fm_nod").substring(0, 5);
		var fm_nod_yard=altlist_sheet.GetCellValue( selectedRow, "fm_nod").substring(5);
		var to_nod_cd=altlist_sheet.GetCellValue( selectedRow, "to_nod").substring(0, 5);
		var to_nod_yard=altlist_sheet.GetCellValue( selectedRow, "to_nod").substring(5);
		var ic1_cd=altlist_sheet.GetCellValue( selectedRow, "ic_1").substring(0, 5);
		var ic1_nod=altlist_sheet.GetCellValue( selectedRow, "ic_1").substring(5);
		var ic2_cd=altlist_sheet.GetCellValue( selectedRow, "ic_2").substring(0, 5);
		var ic2_nod=altlist_sheet.GetCellValue( selectedRow, "ic_2").substring(5);
		if ( selectedRow == 0 )  
		{
			ComShowMessage('No IRG selected.' + rail_cmb_thru_tp_cd );
			irglist_sheet.SetCellValue( row , "irg_dropdownlist","No IRG",0);
			return;
		} else if (  rtr_flag == "NRD" || rail_cmb_thru_tp_cd.length < 1 ) {
			ComShowMessage("Please do COP Change for all motor transportation instead of doing IRG Adjust.");
			return;
		} else if ( rtr_flag =="RTR" ) {
			errMsg=ComGetMsg("TRS90363");
			ComShowMessage(errMsg);
			return;
		}
		irglist_sheet.SetCellValue( row , "new_prio_seq",prio_seq,0);
		irglist_sheet.SetCellValue( row , "new_irg",irg,0);
		irglist_sheet.SetCellValue( row , "new_rout_pln_cd",rout_pln_cd,0);
		irglist_sheet.SetCellValue( row , "new_ref_no",ref_no,0);
		irglist_sheet.SetCellValue( row , "new_inlnd_rout_rmk",inlnd_rout_rmk,0);
		irglist_sheet.SetCellValue( row , "new_rout_org",rout_org_nod_cd,0);
		irglist_sheet.SetCellValue( row , "new_rout_dest",rout_dest_nod_cd,0);
		irglist_sheet.SetCellValue( row , "new_rout_seq",rout_seq,0);
		irglist_sheet.SetCellValue( row , "new_rail_cmb_thru_tp_cd",rail_cmb_thru_tp_cd,0);
		irglist_sheet.SetCellValue( row , "new_fm_nod_cd",fm_nod_cd,0);
		irglist_sheet.SetCellValue( row , "new_fm_nod_yard",fm_nod_yard,0);
		irglist_sheet.SetCellValue( row , "new_to_nod_cd",to_nod_cd,0);
		irglist_sheet.SetCellValue( row , "new_to_nod_yard",to_nod_yard,0);
		irglist_sheet.SetCellValue( row , "interchange1_loc",ic1_cd,0);
		irglist_sheet.SetCellValue( row , "interchange1_nod",ic1_nod,0);
		irglist_sheet.SetCellValue( row , "interchange2_loc",ic2_cd,0);
		irglist_sheet.SetCellValue( row , "interchange2_nod",ic2_nod,0);
		var docParameter=irg;
		var doc_irg="";
		var doc_count=2;
		var arrParameter=docParameter.split("-");
		var arr_rd_param=docParameter.split("RD/");	
		for( var ir=0; ir < arrParameter.length; ir++ ) {
			if( arrParameter[ir].indexOf("RD/") > 0 ) {
				if( doc_count == arr_rd_param.length ) {
					doc_irg=doc_irg + arrParameter[ir-1]+"-"+arrParameter[ir]+"-"+arrParameter[ir+1];
				} else {
					doc_irg=doc_irg + arrParameter[ir-1]+"-"+arrParameter[ir]+"-";
				}
				doc_count++;
			}
		}
		irglist_sheet.SetCellValue( row , "new_irg",doc_irg,0);
	}
}
/**
 * General processing method working when there is an error of inquiring result
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
	}
}


//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
}
