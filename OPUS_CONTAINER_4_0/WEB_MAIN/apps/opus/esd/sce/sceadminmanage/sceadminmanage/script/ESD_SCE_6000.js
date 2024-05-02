/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_6000.js
*@FileTitle  : SCE Admin
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Global Variable
var sheetObjects=new Array();
var sheetCnt=0;
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
        
    }
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,"","");	 
}
function processButtonClick(){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btns_calendar1":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal=new ComCalendarFromTo();
				cal.displayType="date";
				cal.select(formObj.tml_fm_dt, formObj.tml_to_dt, 'yyyy-MM-dd');						
			  break;
			case "btns_calendar2":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal=new ComCalendarFromTo();
				cal.displayType="date";
				cal.select(formObj.rpln_fm_dt, formObj.rpln_to_dt, 'yyyy-MM-dd');						
			break;
			case "btns_calendar3":
				//cal = new calendarPopupFromTo();
				//cal.displayType = "date";
				//cal.select(formObj.bkg_cre_dt1, 'bkg_cre_dt1',formObj.bkg_cre_dt2, 'bkg_cre_dt2', 'yyyy-MM-dd');
				var cal=new ComCalendarFromTo();
				cal.displayType="date";
				cal.select(formObj.mst_fm_dt, formObj.mst_to_dt, 'yyyy-MM-dd');						
			break;			
			case "btn_retrieve":
				var ibtask="";
				if (beforetab == 0) { // terminal change
					ComClearSeparator(document.form.tml_fm_dt);
					ComClearSeparator(document.form.tml_to_dt);
					ibtask=IBSEARCH_ASYNC01;
				} else if (beforetab == 1) { // Cop Replan Fail
					ComClearSeparator(document.form.rpln_fm_dt);
					ComClearSeparator(document.form.rpln_to_dt);
					ibtask=IBSEARCH_ASYNC03;
				} else if (beforetab ===2) { // mst cop no diff
					ComClearSeparator(document.form.mst_fm_dt);
					ComClearSeparator(document.form.mst_to_dt);
					ibtask=IBSEARCH_ASYNC05;
				} else if (beforetab == 3) { // cntrDiff
					ComClearSeparator(document.form.cdiff_fm_dt);
					ComClearSeparator(document.form.cdiff_to_dt);
					ibtask=IBSEARCH_ASYNC06;
				} else if (beforetab == 4) { //tro val
					ibtask=IBSEARCH_ASYNC07;
				} else if (beforetab == 5) { //tro val
					ComClearSeparator(document.form.act_fm_dt);
					ComClearSeparator(document.form.act_to_dt);
					ibtask=IBSEARCH_ASYNC08;
				} 
				doActionIBSheet(sheetObjects[beforetab],formObj,ibtask);
				break;
			case "btn_new":
				sheetObjects[beforetab].RemoveAll();
				formObj.reset();
				break;
			case "btn_diff":
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC09);
				break;
			case "btn_terminalChange":
				ComClearSeparator(document.form.fm_dt);
				ComClearSeparator(document.form.to_dt);
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC02);
				break;
			case "btn_manualReplan":
//				ComClearSeparator(document.form.fm_dt);
//				ComClearSeparator(document.form.to_dt);
				doActionIBSheet(sheetObjects[beforetab], formObj, IBSEARCH_ASYNC04);
				break;				
			case "btn_RowAdd":
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				sheetObjects[beforetab].DataInsert(-1);
				break;
			case "btn_RowDelete":
				sheetObjects[beforetab].RowDelete(sheetObjects[beforetab].RowCount(), false);
			break;
			case "btn_download":
 				sheetObjects[beforetab].Down2Excel();
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
		} else {
			ComShowMessage(e.message);
		}
	}
}
function initControl() {
	var formObject=document.form;
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
    case 1:	  //IBSheet1 init
    	with(sheetObj){
			var HeadTitle0="  |  |Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|BKG NO|CNTR NO|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_rcv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_dtl_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"err_msg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(500);
	}
	break;
    case 2:	  //IBSheet1 init
    	with(sheetObj){
			var HeadTitle0="  |By BKG INFO|RegenPC|COP NO|BKG NO|MST COP NO|PCTL NO|RESULT";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_info",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"regen_pc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mst_cop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"pctl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rpln_rslt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            for(var i=0; i<1; i++){
            	DataInsert(-1);
			}
			
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(500);
		}
	break;
	case 3:	  //IBSheet1 init
		 with(sheetObj){
		    var HeadTitle0="BKG No|CNTR No|TPSZ|CNMV YR|COP NO|COP STS|PCTL NO|MST COP NO|Vsl|Voy|Dir|POR|POL|POD|DEL|IB TRO|OB TRO|COP UPD RMK";
		
		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
		
		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle0, Align:"Center"} ];
		    InitHeaders(headers, info);
		
		    var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_yr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cop_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pctl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mst_cop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trnk_skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trnk_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ib_tro_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_tro_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cop_upd_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		     
		    InitColumns(cols);
		    SetEditable(0);
		    SetSheetHeight(500);
    	}
    break;
    case 4:	  //IBSheet1 init
    	with(sheetObj){
			var HeadTitle0="  |  |Evnt Rmk|Evnt Tp|BKG No|Cntr No|TPSZ|BKG_CRE_DT(KOR)|CNTR_CRE_DT(KOR)|SI FLG|XTER SI CD"
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_evnt_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_evnt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"si_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"xter_si_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(500);
		}
	break;
    case 5:	  //IBSheet1 init
		with(sheetObj){
			var HeadTitle0="Date|No|Vsl|Voy|Dir|Vps Port|Clpt|Node|COP No|Status|Err Msg|Cre Usr Id|Cre Dt|Upd Usr Id|Upd Dt" ;
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_rcv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_if_dtl_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"err_msg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			SetEditable(0);
			SetSheetHeight(500);
		}
	break;
	case 6:	  //IBSheet1 init
		with(sheetObj){
			var HeadTitle0="Act Rcv Dt|Act Rcv No|BKG No.|CNTR No.|Act Dt|Sts|Node|Rcv Tp|Umch Tp Cd|Umch Chk Dt|Vsl|Voy No|Dir|Err Message|Event Seq";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_rcv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"act_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_sts_mapg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_rcv_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_umch_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"umch_chk_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"err_msg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cop_evnt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			SetEditable(0);
			SetSheetHeight(500);
		}
		break;
	}
}

function resizeSheet(){
	for(i=0;i<sheetObjects.length;i++){
		ComResizeSheet(sheetObjects[i]);
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	switch (sAction) {
		case IBCLEAR:      //retrieving	  
			formObj.tml_fm_dt.value=ComGetNowInfo();
			formObj.tml_to_dt.value=ComGetNowInfo();
			formObj.rpln_fm_dt.value=ComGetNowInfo();
			formObj.rpln_to_dt.value=ComGetNowInfo();
			formObj.mst_fm_dt.value=ComGetNowInfo();
			formObj.mst_to_dt.value=ComGetNowInfo();
			formObj.cdiff_fm_dt.value=ComGetNowInfo();
			formObj.cdiff_to_dt.value=ComGetNowInfo();
			formObj.act_fm_dt.value=ComGetNowInfo();
			formObj.act_to_dt.value=ComGetNowInfo();
			sheetObj.RemoveAll();
			break;
		case IBSEARCH: // retrieving
		// formObj.f_cmd.value = MULTI01 ;
		// sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		case IBSEARCH_ASYNC01: // tmlChgRslt
			formObj.f_cmd.value=SEARCH01;
 			sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj) );
			break;
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value=MODIFY01;
			sheetObj.DoSave("ESD_SCE_6000GS.do",FormQueryString(formObj));
		case IBSEARCH_ASYNC03: // CopReplan Fail 에서 cop replan list 조회
			formObj.f_cmd.value=SEARCH02;
			if (validateForm(sheetObj, formObj, sAction)) {
 				sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj) );
			}
			ComAddSeparator(formObj.rpln_fm_dt);
			ComAddSeparator(formObj.rpln_to_dt);
			break;
		case IBSEARCH_ASYNC04: // CopReplan Fail 에서 cop replan
			formObj.f_cmd.value=MODIFY02; 
			sheetObj.DoAllSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		case IBSEARCH_ASYNC05: // Mst cop no
			formObj.f_cmd.value=SEARCH03;
 			sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj) );
			break;
		case IBSEARCH_ASYNC06: // Cntr Diff
			ComClearSeparator(formObj.cdiff_fm_dt);
			ComClearSeparator(formObj.cdiff_to_dt);
			formObj.f_cmd.value=SEARCH04;
 			sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj) );
			break;	
		case IBSEARCH_ASYNC07: // tro
			formObj.f_cmd.value=SEARCH05;
//			sheetObj.DoSearch4Post("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;
		case IBSEARCH_ASYNC08: // act rcv if
			formObj.f_cmd.value=SEARCH06;
 			sheetObj.DoSearch("ESD_SCE_6000GS.do", FormQueryString(formObj) );
			break;		
		case IBSEARCH_ASYNC09: // CopReplan Fail 에서 cop replan
			formObj.f_cmd.value=MODIFY03; 
			sheetObj.DoSave("ESD_SCE_6000GS.do", FormQueryString(formObj));
			break;			
	}
}
function validateForm(sheetObj,formObj,sAction){
	var result=false;
	with(formObj){
		switch(sAction) {
			case IBSEARCH_ASYNC03:
				if (!ComIsEmpty(formObj.rpln_cntr_no) && ComIsEmpty(formObj.rpln_fm_dt) && ComIsEmpty(formObj.rpln_to_dt)) {
//					alert("When Cntr_no is not null, then from ~ to date must be filled in!");
					ComShowMessage(msgs['SCE60001']);
					return false;
				} else if (ComIsEmpty(formObj.rpln_bkg_no) && ComIsEmpty(formObj.rpln_bl_no) && ComIsEmpty(formObj.rpln_cntr_no) && ComIsEmpty(formObj.rpln_cop_no)) {
					ComShowMessage(msgs['SCE60002']); // At least one of following conditions should be filled in to retrieve. 
					return false;
				} 
		}
		return true;
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
     var cnt=0 ;
     switch(tabNo) {
         case 1:
            with (tabObj) {
				InsertItem( "TmlChgRslt" , "");
				InsertItem( "CopReplan Fail" , "");
				InsertItem( "MST_COP_NO Diff" , "");
				InsertItem( "CntrDiff" , "");
				InsertItem( "TRO Val" , "");
				InsertItem( "Actual Mapping" , "");
            }
         break;
    }
}
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.tml_fm_dt);
	ComAddSeparator(document.form.tml_to_dt);
}	
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.rpln_fm_dt);
	ComAddSeparator(document.form.rpln_to_dt);
}
function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.mst_fm_dt);
	ComAddSeparator(document.form.mst_to_dt);
}
function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.cdiff_fm_dt);
	ComAddSeparator(document.form.cdiff_to_dt);
}
function t6sheet1_OnSearchEnd(sheetObj, ErrMsg){
	ComAddSeparator(document.form.act_fm_dt);
	ComAddSeparator(document.form.act_to_dt);
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
//	resizeSheet();
	beforetab=nItem;
}
//setting checkdit of Container No.
function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo=obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=cntrNo;
		return;
	}
	ComChkObjValid(obj, 'eng_num', true, 10);
	var sum=0;
 	cntrNo=cntrNo.toUpperCase();
	//for(var i=0;i<10;i++){
	//	sum = sum + ComGetCntrChkDgt( cntrNo.charAt(i),i);
	//}
	sum=ComGetCntrChkDgt( cntrNo.substr(0,10));
//alert("  "+	cntrNo.substr(0,10));
//alert('sum:'+sum);		
	var mod=sum % 11;
	if (mod == 10) mod=0;
	if( isNaN(mod)){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=obj.value;
	}else{
		obj.value=cntrNo.substr(0,10);
		document.getElementById(bitTarget).value=mod;
		document.getElementById(valueTarget).value=obj.value + mod;
	}
}
