/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0509.js
*@FileTitle  : Terminal Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class vop_vsk_0007 : business script for vop_vsk_0007
 */

// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var marrPrefix=new Array("t1sheet1_", "t2sheet1_", "t3sheet1_", "t4sheet1_");
var marrTabTitle=new Array("G/Crane", "F/Crane", "Gang Structure", "Berth Window");
var marrWeekNm=new Array("sun", "mon", "tue", "wed", "thu", "fri", "sat");
var mQuestion=true;
var mClearData=true;
var mPreviousTab=0;
var mCheckKey=true;
var mCheckValue=false;
var mEditRow=0;
var arrGCraneCombo=new Array();
var arrSearchCond=new Array("", "", "");
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */


function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     var sheetObject3=sheetObjects[2];
     var sheetObject4=sheetObjects[3];
     var sheetObject5=sheetObjects[4];
     /*******************************************************/
     var formObject=document.form;
	 try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "ComOpenPopupWithTarget":
					var sUrl = "/opuscntr/VOP_VSK_0043.do?port_cd="
						     + formObject.loc_cd.value;
					ComOpenPopup(sUrl, 900, 520, "returnPortHelp", "0,0", true);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
					break;
				case "btn_New":
					clearFormNData();
					moveFocus(beforetab);
					break;
				case "btn_DownExcel":
					if ( sheetObjects[beforetab].id == "t1sheet1") {
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
			        	    }else{
								//sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
							}
					} else if (sheetObjects[beforetab].id == "t2sheet1") {
						if(sheetObject2.RowCount() < 1){//no data
			        	    ComShowCodeMessage("COM132501");
			        	    }else{
								//sheetObject2.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
			        	    }
					} else if (sheetObjects[beforetab].id == "t3sheet1") {
						if(sheetObject3.RowCount() < 1){//no data
			        	    ComShowCodeMessage("COM132501");
			        	    }else{
								//sheetObject3.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject3.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject3),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
			        	    }
					} else if (sheetObjects[beforetab].id == "t4sheet1") {
						if(sheetObject4.RowCount() < 1){//no data
			        	    ComShowCodeMessage("COM132501");
			        	    }else{
								//sheetObject4.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject4.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject4),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
			        	    };
					} 
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * after [Port] Button Click, calling from Pop-up
 * @param rtnObjs
 * @return
 */
function returnPortHelp(rtnObjs){
	var formObj=document.form;
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				formObj.loc_cd.value=rtnDatas;
			}
		}
	}
	
}

/**
* registering initial event 
*/
function initControl() {
	//axon_event.addListener('change', 'gntr_rmk_onchange', 'gntr_rmk', '');
	//axon_event.addListener('change', 'fltg_rmk_onchange', 'fltg_rmk', '');
//	axon_event.addListener('keyup', 'loc_cd_onkeyup', 'loc_cd');
//	axon_event.addListener('keypress', 'loc_cd_onkeypress', 'loc_cd', '');
	axon_event.addListener('blur', 'loc_cd_onblur', 'loc_cd');
	axon_event.addListenerForm  ('blur', 'obj_deactivate', form);
//  axon_event.addListenerFormat('focus', 'obj_activate', form);
//  axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
}

function gntr_rmk_onchange(){
	if(sheetObjects[0].GetSelectRow()> 0){
    	if(document.form.gntr_rmk.value.length > 1000){
    		ComShowCodeMessage("VSK01019", "[Remark(s)]");
    		document.form.gntr_rmk.value="";  
    		return false;
    	}
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "t1sheet1_gntr_rmk",document.form.gntr_rmk.value);
	}
}
function fltg_rmk_onchange(){
	if(sheetObjects[1].GetSelectRow()> 0){
    	if(document.form.fltg_rmk.value.length > 1000){
    		ComShowCodeMessage("VSK01019", "[Remark(s)]");
    		document.form.fltg_rmk.value="";  
    		return false;
    	}
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "t2sheet1_fltg_rmk",document.form.fltg_rmk.value);
	}
}
function dateFormat(n, digits) {
	var zero='';
	n=n.toString();
	if (n.length < digits) {
		for (i=0; i < digits - n.length; i++)
	    zero += '0';
	}
	return zero + n;
}

/**
 * Deleting mask separator in onfocus event
 **/
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}
/**
 * Making mask separator, Checking Validation
 **/
function obj_deactivate(){
	ComChkObjValid(ComGetEvent());
}
/**
 * Handling key press event
 **/
function obj_keypress(){
	switch(ComGetEvent().dataformat){
		case "int":
	        ComKeyOnlyNumber(ComGetEvent());
			break;
		case "float":
	        ComKeyOnlyNumber(ComGetEvent(), ".");
			break;
		default:
	        ComKeyOnlyNumber(ComGetEvent());
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
	for(k=0; k < tabObjects.length; k++){
        initTab(tabObjects[k],k+1);
    }
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	/*for(i=0;i<sheetObjects.length;i++){
    	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
    }*/
	for(var k=0; k<comboObjects.length; k++){
		initCombo(comboObjects[k],k+1);
	}
	
	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	initControl();
	portCdInit();
	document.form.loc_cd.focus();
	t3sheet1.SetMergeCell(0, 2, 2, 1);
	t3sheet1.SetMergeCell(0, 7, 2, 1);
    if(preConds.pop_yn == 'Y') {
   	 //setting initial condition
         if(preConds.loc_cd != '') {	         	
         	if(preConds.loc_cd != '') ComSetObjValue(document.form.loc_cd, preConds.loc_cd);
         	//retrieve
//	         	loc_cd_onkeyup();
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	         }
        }
    }
  /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {
        case "t1sheet1":
            with(sheetObj){
          
        var HeadTitle1="|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|G/Crane Q’ty|G/Crane Q’ty|Remark|upd_usr_id|upd_usr_id";
        var HeadTitle2="|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|Total gang in TMNL|Max gang per Vessel|Remark|upd_usr_id|upd_usr_id";
        var headCount=ComCountHeadTitle(HeadTitle1);
        var prefix="t1sheet1_";

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"},
                { Text:HeadTitle2, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"Text", 		Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_max_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"net_max_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"clr_btwn_leg_wdt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                     {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_rch_row_knt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                     {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_tr_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                     {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_gntr_crn_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"vsl_gntr_crn_max_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"gntr_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
         
        	InitColumns(cols);
        	SetSheetHeight(420);
        	SetEditable(0);
        	SetColProperty(0 ,"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	SetRangeBackColor(1,7,1,9,"#555555");
        }


		break;
        case "t2sheet1":
            with(sheetObj){
           
        	var HeadTitle1="|Port|Seq.|Handling Cargo Weight (Ton)|Handling Cargo Height (M)|Crane Reach (M)|Handling Cost (Remark)|Remark(s)|upd_usr_id|upd_usr_id";
        	var headCount=ComCountHeadTitle(HeadTitle1);
        	var prefix="t2sheet1_";
		
        	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);
		
        	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
        	             {Type:"Text", 		Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_view_seq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_hndl_cgo_wgt", KeyField:0,   CalcLogic:"",   Format:"",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
        	             {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_hndl_cgo_hgt", KeyField:0,   CalcLogic:"",   Format:"",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
        	             {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_rch_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
        	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hndl_cost_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
        	             {Type:"Text",      Hidden:1, Width:105,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fltg_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
        	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
        	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
		
        	InitColumns(cols);
        	SetSheetHeight(420);
        	SetEditable(0);
        	SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N"});                                                                                                                                                                                                                                                                                                                                                                                                                                                  //conversion of function[check again]CLT 					InitDataValid(0, prefix + "loc_cd", vtEngUpOnly);
		}


		break;
		
        case "t3sheet1":
            with(sheetObj){
           
          var HeadTitle1="|Port|Seq.|Gang Working Time|Gang Working Time|Break/Meal Time (Standard)|Break/Meal Time (Standard)|Remark(s)|upd_usr_id|upd_usr_id";
          var HeadTitle2="|Port|Seq.|From|To|From|To|Remark(s)|upd_usr_id|upd_usr_id";
          var headCount=ComCountHeadTitle(HeadTitle1);
          var prefix="t3sheet1_";

          SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"},
                      { Text:HeadTitle2, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                 {Type:"Text", 		Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_view_seq",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_wrk_st_hrmnt",    KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_wrk_end_hrmnt",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_nwork_st_hrmnt",  KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_nwork_end_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"gng_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
                 {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 } ];
           
          InitColumns(cols);
          SetSheetHeight(420);
          SetEditable(0);
          SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|N"});
          SetRangeBackColor(1,3,1,6,"#555555");
          }


		break;
		
        case "t4sheet1":
            with(sheetObj){
	              var HeadTitle1="|loc_cd|TMNL Code|TMNL Name|Lane Code|Bound|Carrier|etb_dy_cd|etb_tm_hrmnt|etd_dy_cd|etd_tm_hrmnt|upd_usr_id|upd_usr_id|brth_seq";
	              for(var weekCnt=0; weekCnt < marrWeekNm.length; weekCnt++){
	            	  HeadTitle1=HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
	            	  HeadTitle1=HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
	              }
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t4sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"loc_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text", 		Hidden:0, Width:110,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",                         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
	                     {Type:"Text",      Hidden:0,  Width:160,   Align:"Left",    ColMerge:0,   SaveName:prefix+"yd_nm",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Popup", 	Hidden:0, Width:90,   Align:"Center",    ColMerge:0,   SaveName:prefix+"ref_slan_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Popup", 	Hidden:0, Width:90,   Align:"Center",    ColMerge:0,   SaveName:prefix+"crr_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_dy_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_tm_hrmnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_dy_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_tm_hrmnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              for(var weekCnt=0; weekCnt < marrWeekNm.length; weekCnt++){
	            	  cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etd_tm_"+marrWeekNm[weekCnt]+"_am",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 });
	            	  cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etd_tm_"+marrWeekNm[weekCnt]+"_pm",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 });
	              }
	              InitColumns(cols);
	              SetEditable(0);
	              SetColProperty(prefix+"etb_tm_hrmnt", {Format:"##:##"} );
	              SetColProperty(prefix+"etd_tm_hrmnt", {Format:"##:##"} );
	              sheetHeaderBackColor(sheetObj, prefix  + "etd_tm_" + marrWeekNm[0] + "_am", prefix  + "etd_tm_" + marrWeekNm[0] + "_pm", "#FF7D7D");
	              sheetHeaderBackColor(sheetObj, prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_am", prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm", "#7D7DFF");
	              SetShowButtonImage(2);
	              SetSheetHeight(420);
          }
		break;
		
        case "sheet1":
            with(sheetObj){
           
         var HeadTitle1="|Value|Name";
         var headCount=ComCountHeadTitle(HeadTitle1);
         var prefix="sheet1_";

         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
         InitHeaders(headers, info);

         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"val" },
             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"name" } ];
          
         InitColumns(cols);
         SetSheetHeight(150);
         SetEditable(1);
                  }
       break;
    }
}

function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
		case "por_rhq":    //R/D Term-post
			var i=0;
			with(comboObj) {
				SetColWidth(0, 90);
				//SetDropHeight(150);
				InsertItem(i++, "ALL", "%");
				SetSelectCode("%");
			}
			break;
	}
}
	// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
    	case SEARCH01:
			formObj.f_cmd.value= SEARCH01;
			var sParam= FormQueryString(formObj)
			var sXml= sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
			var rhqlist=ComGetEtcData(sXml, "rhqlist");
			if(rhqlist){
				var comboObj=comboObjects[0];
				var rhqs=rhqlist.split(":");
				for(var i=0; i<rhqs.length; i++){
					comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
				}
				comboObj.SetDropHeight(comboObj.GetItemCount()*(comboObj.GetItemHeight()+1.5));
			}
			break;        		
		case IBSEARCH:		//조회
			if(validateForm(sheetObj,formObj,sAction)){
				//in case search condition change, and sheet data change
				if(arrSearchCond[0] != ""){
					var changeYn=false;
					if(arrSearchCond[0] != formObj.loc_cd.value)
						changeYn=true;
					if(arrSearchCond[1] != (enablePorRhq.style.display == "inline" ? por_rhq.id: formObj.por_rhq_diable.value))
						changeYn=true;
					if(changeYn){
						removeSheet();
					}
				}
				
				if ( sheetObj.id == "t1sheet1"){
					formObj.f_cmd.value=SEARCH01;
					var arr=new Array("t1sheet1_", "");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				} else if ( sheetObj.id == "t2sheet1"){
					formObj.f_cmd.value=SEARCH02;
					var arr=new Array("t2sheet1_", "");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
					var arrXml=sXml.split("|$$|");
					var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
					if(arrCombo != undefined){
						sheetObj.SetColProperty("t2sheet1_loc_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
					}
					sheetObj.RenderSheet(0);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
					sheetObj.RenderSheet(1);
				} else if ( sheetObj.id == "t3sheet1"){
					formObj.f_cmd.value=SEARCH03;
					var arr=new Array("t3sheet1_", "");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
					var arrXml=sXml.split("|$$|");
					var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
					if(arrCombo != undefined){
						sheetObj.SetColProperty("t3sheet1_loc_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
					}
					sheetObj.RenderSheet(0);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
					sheetObj.RenderSheet(1);
				} else if ( sheetObj.id == "t4sheet1"){
					formObj.f_cmd.value=SEARCH04;
					var arr=new Array("t4sheet1_", "");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(sXml,{Sync:0} );
						sheetObj.RenderSheet(1);
						//sheet coloring

				}
				arrSearchCond[0]=formObj.loc_cd.value;
				arrSearchCond[1]=(enablePorRhq.style.display == "inline" ? por_rhq.id: document.form.por_rhq_diable.value);
			}
			break;
	   }
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj){
   comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt] , "");
				}
            }
         		break;
     }
     tabObj.SetSelectedIndex(0);
}
/**
 * Handling tab click event
 * Activating clicked tab
 */
function tab1_OnChange(tabObj , nItem)
{
	 formObject = document.form;
	 var objs=document.all.item("tabLayer");
	 objs[nItem].style.display="Inline";
	 for(var i = 0; i< objs.length; i++){
    	  if(i != nItem){
        	   objs[i].style.display="none";
        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	  }
	}
	beforetab=nItem;
	if(nItem == 0 || nItem == 3){
		document.all.item("disablePorRhq").style.display="inline";
		document.all.item("enablePorRhq").style.display="none";
		document.form.loc_cd.className="input1";
	}else{
		document.all.item("disablePorRhq").style.display="none";
		document.all.item("enablePorRhq").style.display="inline";
		document.form.loc_cd.className="input";
	}
	moveFocus(nItem);
}
/**
 *	Sheet Event Start
 */
function t1sheet1_OnClick(sheetObj, Row, Col, Value){
	document.form.gntr_rmk.value=sheetObj.GetCellValue(Row, "t1sheet1_gntr_rmk");
	document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_dt");
	document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_usr_id");
}
function t1sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
	ComOpenWait(false);
	if(sheetObj.RowCount()> 0){
		document.form.gntr_rmk.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_gntr_rmk");
		document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_usr_id");
	}
}
function t2sheet1_OnClick(sheetObj, Row, Col, Value){
	document.form.fltg_rmk.value=sheetObj.GetCellValue(Row, "t2sheet1_fltg_rmk");
	document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_dt");
	document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_usr_id");
}
function t2sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
	ComOpenWait(false);
	if(sheetObj.RowCount()> 0){
		document.form.fltg_rmk.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_fltg_rmk");
		document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_usr_id");
	}
}
function t3sheet1_OnClick(sheetObj, Row, Col, Value){
	document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_dt");
	document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_usr_id");
}
function t3sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
	ComOpenWait(false);
	if(sheetObj.RowCount()> 0){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_usr_id");
	}
	
	
}
function t4sheet1_OnClick(sheetObj, Row, Col, Value){
	document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t4sheet1_upd_dt");
	document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t4sheet1_upd_usr_id");
}

//function t4sheet1_OnDblClick(sheetObj, Row, Col){
//	var sheetObj = sheetObjects[3];
//	if(Col > sheetObj.SaveNameCol("t4sheet1_upd_dt"))
//		alert('t');
//		ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0703.do?enableForm=N', 500, 275, "loc_cd:loc_cd", "0,1,1,1,1,1,1", true);
//}

function t4sheet1_OnDblClick(sheetObj, Row, Col){
	if(Col > sheetObj.SaveNameCol("t4sheet1_upd_dt"))
		var targetObjList="loc_cd:loc_cd";
		var v_display="0,0";
		var locCd = document.form.loc_cd.value;
	
		ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0703.do?enableForm=N', 500, 275, targetObjList, v_display, true);
	
//		ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 550, 500, targetObjList, v_display, true);
}

function t4sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
	ComOpenWait(false);
	
	if(sheetObj.RowCount()> 0){
		var prefix="t4sheet1_";
		for(var cnt=1; cnt <= sheetObj.RowCount(); cnt++)
		{
			//AM/PM of start, end
			var amPmS=parseInt(sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
			var amPmE=parseInt(sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2)) <= 12 ? "am" : "pm";
			
			if(sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2) == "00"){
				amPmE = "pm";
			}
			
			var colName3=prefix +  "etd_tm_" + sheetObj.GetCellValue(cnt, prefix + "etb_dy_cd").toLowerCase() + "_"  + amPmS;
			var colName4=prefix +  "etd_tm_" + sheetObj.GetCellValue(cnt, prefix + "etd_dy_cd").toLowerCase() + "_"  + amPmE;
			//sheetSetBackColor(sheetObj, cnt, colName1, colName2);
			sheetSetBackColor(sheetObj, cnt, colName3, colName4);
			sheetSetForeColor(sheetObj, cnt, colName3, colName4);
			for(var col=sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[0] + "_am"); col <= sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm"); col++)
			{
				sheetObj.SetCellValue(cnt, col,"    ");
				
			}
			if(colName3 == colName4){
				sheetObj.SetCellValue(cnt, colName3,sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2) + "/" + sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2));
			} else
			{
				sheetObj.SetCellValue(cnt, colName3,sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2));
				sheetObj.SetCellValue(cnt, colName4,sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2));
			}
//			sheetObj.SetRowStatus(cnt,"R");
		}
	}
	
	
	if(sheetObj.RowCount()> 0){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_usr_id");
	}
}

function sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
		var formObj=document.form;
		if(sheetObj.RowCount()> 0){
			if(document.form.f_cmd.value == SEARCH05){
				if(beforetab == 1){
					sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "t2sheet1_crn_seq",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
					sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(), "t2sheet1_max_hndl_cgo_wgt", true);
				}else if(beforetab == 2){
					sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "t3sheet1_crn_seq",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
					sheetObjects[2].SelectCell(sheetObjects[2].GetSelectRow(), "t3sheet1_gng_wrk_st_hrmnt", true);
				}
			} else if(document.form.f_cmd.value == SEARCH06){
				por_rhq.SetSelectCode(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
				document.form.por_rhq_diable.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val");
		}
	} else{
		if(document.form.f_cmd.value == SEARCH06){
			ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
			ComClearObject(formObj.loc_cd);
			ComClearObject(formObj.por_rhq_diable);
			por_rhq.SetSelectCode("%");
			sheetObjects[0].SetColProperty("t1sheet1_yd_cd", {ComboText:"", ComboCode:""} );
		} else if(document.form.f_cmd.value == SEARCH03){
			ComShowCodeMessage("VSK50028");
			sheetObjects[3].SelectCell(mEditRow, "t4sheet1_slan_cd", true);
		} else if(document.form.f_cmd.value == SEARCH04){
			ComShowCodeMessage("VSK50030");
			sheetObjects[3].SelectCell(mEditRow, "t4sheet1_crr_cd", true);
		}
	}
}
/**
 *	Sheet Event End
 */
/**
 * vsl_opr_tp_cd<br>
 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
 */
function setLaneInfo(aryPopupData, Row, Col, sheetIdx){
	mCheckValue=false;
	sheetObjects[3].SetCellValue(Row,Col,aryPopupData[0][3],0);
}
/**
 * vsl_opr_tp_cd<br>
 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
 */
function setVslOprTpCd(aryPopupData, Row, Col, sheetIdx){
	mCheckValue=false;
	sheetObjects[3].SetCellValue(Row,Col,aryPopupData[0][3],0);
}
/**
 *	Form Event Start
 */
function por_rhq_OnChange(){
	if(document.all.item("enablePorRhq").style.display == "inline" && !mCheckKey){
		document.form.loc_cd.value="";
	}
}
function por_rhq_OnKeyDown(comboObj, KeyCode, Shift){
	if(KeyCode == 13){
		doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
	}
}
function loc_cd_onkeyup(){
	document.form.f_cmd.value=SEARCH06;
	if(document.form.loc_cd.value.length == 5){
		var sXml = sheetObjects[4].GetSearchData("VOP_VSK_0507GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_"));
		sheetObjects[4].LoadSearchData(sXml,{Sync:1} );
	} else if (document.form.loc_cd.value.length == 0) {
		por_rhq.SetSelectCode("%");
		document.form.por_rhq_diable.value="";
	} 
	mCheckKey=true;
}
function loc_cd_onblur(){
	mCheckKey=false;
	loc_cd_onkeypress();
}
function loc_cd_onkeypress(){
	ComKeyOnlyAlphabet('upper');
	if(document.form.loc_cd.value.length == 5 && event.keyCode == 13){
		doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
	}else if(document.form.loc_cd.value == "" && (beforetab == 1 || beforetab == 2) && event.keyCode == 13){
		doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
	}
}
function portCdInit(){
	document.form.f_cmd.value=SEARCH01;
	var arr=new Array("", "");
	document.form.comboCd.value="CD00593,CD02121";
	var sXml=sheetObjects[1].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(arr));
	var arrXml=sXml.split("|$$|");
	if(arrXml.length > 1){
		arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
		sheetObjects[3].SetColProperty("t4sheet1_skd_dir_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
	}
}
/**
 *	Form Event End
 */
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
		switch(sAction) {
			case IBSEARCH:
				if(beforetab == 0 || beforetab == 3){
					if(loc_cd.value == ''){
						ComShowCodeMessage('COM12114','Port');
						loc_cd.focus();
						return false;
					}	
				}
				if(beforetab == 1 || beforetab == 2){
					if(por_rhq.id== ''){
						ComShowCodeMessage('COM12114','RHQ');
						ComAlertFocus(por_rhq, "");
						return false;
					}	
				}
			break;			
		}
	}
    return true;
}

function sheetSetBackColor(sheet, Row, Col, Col2){
	var startRow = sheet.SaveNameCol(Col);
	var endRow=sheet.SaveNameCol(Col2);
	var prefix="t4sheet1_";
	if(startRow <= endRow){
		for(var cnt=startRow; cnt <= endRow; cnt++){
			sheet.SetCellBackColor(Row, cnt,"#0080C0");
		}
	} else{
		for(var cnt=startRow; cnt <= sheet.LastCol(); cnt++){
			sheet.SetCellBackColor(Row, cnt,"#0080C0");
		}
		var newStart=parseInt(sheet.SaveNameCol(prefix + "etd_tm_hrmnt")) + 1;
		for(var cnt=newStart; cnt <= endRow; cnt++){
			sheet.SetCellBackColor(Row, cnt,"#0080C0");
		}
	}
}

function sheetSetForeColor(sheet, Row, Col, Col2){
	var startRow=sheet.SaveNameCol(Col);
	var endRow=sheet.SaveNameCol(Col2);
	sheet.SetCellFontColor(Row, startRow,"#FFFFFF");
	sheet.SetCellFontColor(Row, endRow,"#FFFFFF");
}

function sheetHeaderBackColor(sheet, Col, Col2, bgColor){
	var startCol=sheet.SaveNameCol(Col);
	var endCol=sheet.SaveNameCol(Col2);
	for(var cnt=startCol; cnt <= endCol; cnt++){
		sheet.SetCellBackColor(0, cnt,bgColor);
	}
}

function duplCheck(sheetObj,Row, Col, Value, chkCol){
	var dupRow=sheetObj.ColValueDup(chkCol, true);
	//Checking duplicate except null
	if(sheetObj.id == "t1sheet1"){
		if(dupRow != -1 && sheetObj.GetCellValue(dupRow, chkCol) != '') {
			ComShowCodeMessage('VSK50016'); 
			sheetObj.SetCellValue(Row, Col,"");
			return;
		}
	} else if(sheetObj.id == "t4sheet1"){
		if(dupRow != -1 && sheetObj.GetCellValue(dupRow, chkCol) != '') {
			ComShowCodeMessage('VSK50016');  
			var arrCheckCol=chkCol.split("|");
			for(var cnt=0; cnt < arrCheckCol.length; cnt++){
				sheetObj.SetCellValue(Row, arrCheckCol[cnt],"");
			}
			return;
		}
	}
}

function clearFormNData(){
	var formObject=document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	with(formObject){
		loc_cd.value="";
		por_rhq_diable.value="";
		upd_dt_view.value="";
		upd_id_view.value="";
		gntr_rmk.value="";
		fltg_rmk.value="";
	}
	por_rhq.SetSelectCode("%");
}

function removeSheet(){
	var formObject=document.form
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	with(formObject){
		upd_dt_view.value="";
		upd_id_view.value="";
		gntr_rmk.value="";
		fltg_rmk.value="";
	}
}

function moveFocus(nItem){
	switch(nItem){
		case 0:
//			document.form.loc_cd.focus();
			break;
		case 1:
			ComAlertFocus(por_rhq, "");
			break;
		case 2:
			ComAlertFocus(por_rhq, "");
			break;
		case 3:
//			document.form.loc_cd.focus();
			break;
	}
}

function yardCdCellComboInit(sheetObj, Row){
	with(sheetObj){
		var code=" |" + arrGCraneCombo[0];
		var val=" |" + arrGCraneCombo[1];
			for(var cnt=HeaderRows(); cnt <= RowCount(); cnt++){
				if(cnt != Row && GetRowStatus(cnt) == "R"){
				//deleting code
					code=ComReplaceStr(code, "|" + GetCellValue(cnt, "t1sheet1_yd_cd"), "");
				//finding text
				var sText=sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "Text");
				var arrText=sText.split("|");
				var idx=sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "SelectedIndex");
				//deleting text
				val=ComReplaceStr(val, "|" + arrText[idx], "");
				}
			}
			CellComboItem(Row,"t1sheet1_yd_cd", {ComboText:val, ComboCode:code} );
	}
}

function changeSheet(){
	var statsCnt=0;
	var changeSheet="";
	for(var cnt=0; cnt < sheetObjects.length; cnt++){
		var changeSheetCnt = sheetObjects[cnt].RowCount("I") + sheetObjects[cnt].RowCount("U") + sheetObjects[cnt].RowCount("D");
		if(changeSheetCnt > 0){
			statsCnt += changeSheetCnt;
			changeSheet += changeSheet == "" ? marrTabTitle[cnt] : ", " + marrTabTitle[cnt];
		}
	}
	return statsCnt;
}
/**
 * Pol Code<br>
 * @param {arry} aryPopupData
 */
function setPolCd(aryPopupData){
	document.form.loc_cd.value=aryPopupData[0][2];
}
