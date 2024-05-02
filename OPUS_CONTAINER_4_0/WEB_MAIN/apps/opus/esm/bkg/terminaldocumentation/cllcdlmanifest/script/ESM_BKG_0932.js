/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0932.js
 *@FileTitle  : Container Loading List(KOREA)_Summary
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/    

var sheetObjects=new Array();
var sheetCnt=0;
var state="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Special_CGO":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;
		case "btn_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;
		case "btn_Pdf_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND04);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		case "btns_search1":
			popSelect("TO");
			break;
		case "btns_search2":
			popSelect("FM");
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	if(document.form.in_cll_type.value == "LOCAL"){
		document.form.in_by_type_temp[2].disabled=true;
		sheetObjects[0].SetColHidden("ts_20",1);
		sheetObjects[0].SetColHidden("ts_40",1);
		sheetObjects[0].SetColHidden("ts_40h",1);
		sheetObjects[0].SetColHidden("ts_45",1);
		sheetObjects[0].SetColHidden("mty_20",1);
		sheetObjects[0].SetColHidden("mty_40",1);
		sheetObjects[0].SetColHidden("mty_40h",1);
		sheetObjects[0].SetColHidden("mty_45",1);
		sheetObjects[1].SetColHidden("ts_dg_20",1);
		sheetObjects[1].SetColHidden("ts_dg_40",1);
		sheetObjects[1].SetColHidden("ts_dg_40h",1);
		sheetObjects[1].SetColHidden("ts_rf_20",1);
		sheetObjects[1].SetColHidden("ts_rf_40",1);
		sheetObjects[1].SetColHidden("ts_rf_40h",1);
		sheetObjects[1].SetColHidden("ts_ot_20",1);
		sheetObjects[1].SetColHidden("ts_ot_40",1);
		sheetObjects[1].SetColHidden("ts_ot_40h",1);
		sheetObjects[1].SetColHidden("ts_fr_20",1);
		sheetObjects[1].SetColHidden("ts_fr_40",1);
		sheetObjects[1].SetColHidden("ts_fr_40h",1);
		sheetObjects[1].SetColHidden("mt_dg_20",1);
		sheetObjects[1].SetColHidden("mt_dg_40",1);
		sheetObjects[1].SetColHidden("mt_dg_40h",1);
		sheetObjects[1].SetColHidden("mt_rf_20",1);
		sheetObjects[1].SetColHidden("mt_rf_40",1);
		sheetObjects[1].SetColHidden("mt_rf_40h",1);
		sheetObjects[1].SetColHidden("mt_ot_20",1);
		sheetObjects[1].SetColHidden("mt_ot_40",1);
		sheetObjects[1].SetColHidden("mt_ot_40h",1);
		sheetObjects[1].SetColHidden("mt_fr_20",1);
		sheetObjects[1].SetColHidden("mt_fr_40",1);
		sheetObjects[1].SetColHidden("mt_fr_40h",1);
	}else if(document.form.in_cll_type.value == "TS"){
		sheetObjects[0].SetColHidden("local_20",1);
		sheetObjects[0].SetColHidden("local_40",1);
		sheetObjects[0].SetColHidden("local_40h",1);
		sheetObjects[0].SetColHidden("local_45",1);
		sheetObjects[0].SetColHidden("mty_20",1);
		sheetObjects[0].SetColHidden("mty_40",1);
		sheetObjects[0].SetColHidden("mty_40h",1);
		sheetObjects[0].SetColHidden("mty_45",1);
		sheetObjects[1].SetColHidden("local_dg_20",1);
		sheetObjects[1].SetColHidden("local_dg_40",1);
		sheetObjects[1].SetColHidden("local_dg_40h",1);
		sheetObjects[1].SetColHidden("local_rf_20",1);
		sheetObjects[1].SetColHidden("local_rf_40",1);
		sheetObjects[1].SetColHidden("local_rf_40h",1);
		sheetObjects[1].SetColHidden("local_ot_20",1);
		sheetObjects[1].SetColHidden("local_ot_40",1);
		sheetObjects[1].SetColHidden("local_ot_40h",1);
		sheetObjects[1].SetColHidden("local_fr_20",1);
		sheetObjects[1].SetColHidden("local_fr_40",1);
		sheetObjects[1].SetColHidden("local_fr_40h",1);
		sheetObjects[1].SetColHidden("mt_dg_20",1);
		sheetObjects[1].SetColHidden("mt_dg_40",1);
		sheetObjects[1].SetColHidden("mt_dg_40h",1);
		sheetObjects[1].SetColHidden("mt_rf_20",1);
		sheetObjects[1].SetColHidden("mt_rf_40",1);
		sheetObjects[1].SetColHidden("mt_rf_40h",1);
		sheetObjects[1].SetColHidden("mt_ot_20",1);
		sheetObjects[1].SetColHidden("mt_ot_40",1);
		sheetObjects[1].SetColHidden("mt_ot_40h",1);
		sheetObjects[1].SetColHidden("mt_fr_20",1);
		sheetObjects[1].SetColHidden("mt_fr_40",1);
		sheetObjects[1].SetColHidden("mt_fr_40h",1);
	}else if(document.form.in_cll_type.value == "EMPTY"){
		document.form.in_by_type_temp[2].disabled=true;
		sheetObjects[0].SetColHidden("local_20",1);
		sheetObjects[0].SetColHidden("local_40",1);
		sheetObjects[0].SetColHidden("local_40h",1);
		sheetObjects[0].SetColHidden("local_45",1);
		sheetObjects[0].SetColHidden("ts_20",1);
		sheetObjects[0].SetColHidden("ts_40",1);
		sheetObjects[0].SetColHidden("ts_40h",1);
		sheetObjects[0].SetColHidden("ts_45",1);
		sheetObjects[1].SetColHidden("local_dg_20",1);
		sheetObjects[1].SetColHidden("local_dg_40",1);
		sheetObjects[1].SetColHidden("local_dg_40h",1);
		sheetObjects[1].SetColHidden("local_rf_20",1);
		sheetObjects[1].SetColHidden("local_rf_40",1);
		sheetObjects[1].SetColHidden("local_rf_40h",1);
		sheetObjects[1].SetColHidden("local_ot_20",1);
		sheetObjects[1].SetColHidden("local_ot_40",1);
		sheetObjects[1].SetColHidden("local_ot_40h",1);
		sheetObjects[1].SetColHidden("local_fr_20",1);
		sheetObjects[1].SetColHidden("local_fr_40",1);
		sheetObjects[1].SetColHidden("local_fr_40h",1);
		sheetObjects[1].SetColHidden("ts_dg_20",1);
		sheetObjects[1].SetColHidden("ts_dg_40",1);
		sheetObjects[1].SetColHidden("ts_dg_40h",1);
		sheetObjects[1].SetColHidden("ts_rf_20",1);
		sheetObjects[1].SetColHidden("ts_rf_40",1);
		sheetObjects[1].SetColHidden("ts_rf_40h",1);
		sheetObjects[1].SetColHidden("ts_ot_20",1);
		sheetObjects[1].SetColHidden("ts_ot_40",1);
		sheetObjects[1].SetColHidden("ts_ot_40h",1);
		sheetObjects[1].SetColHidden("ts_fr_20",1);
		sheetObjects[1].SetColHidden("ts_fr_40",1);
		sheetObjects[1].SetColHidden("ts_fr_40h",1);
	}
	initControl();
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // -
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // -

	ComBtnDisable("btn_print");
}

function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
        	var HeadTitle1="POD|MLB|Local|Local|Local|Local|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Weight(KGS)|VGM(KGS)";
        	var HeadTitle2="POD|MLB|20|40|40H|45|20|40|40H|45|20|40|40H|45|Weight(KGS)|VGM(KGS)";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"gubun_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gubun_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"local_20",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"local_40",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"local_40h",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"local_45",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"ts_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"ts_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"ts_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"ts_45",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"mty_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"mty_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"mty_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"mty_45",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"wgt_mt",     KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:100,   Align:"Center",   ColMerge:1,   SaveName:"vgm_mt",     KeyField:0,   CalcLogic:"",   Format:"Integer", PointCount:3,   UpdateEdit:0,   InsertEdit:0 }];
      		InitColumns(cols);
      		SetEditable(1);
      		SetRangeBackColor(1,2,1,18,"#555555");
      		SetSheetHeight(185);
      		SetSheetWidth(730);
      		SetCountPosition(0);
            
        }
		break;
	case "sheet2": // sheet2 init
	    with(sheetObj){
		      var HeadTitle1="POD|MLB|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|Local|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|T/S|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Empty|Empty";
		      var HeadTitle2="POD|MLB|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T|DG|DG|DG|RF|RF|RF|FR|FR|FR|O/T|O/T|O/T";
		      var HeadTitle3="POD|MLB|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H|20|40|40H";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"},
		                      { Text:HeadTitle3, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:"gubun_cd2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gubun_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_dg_20",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_dg_40",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_dg_40h",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_rf_20",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_rf_40",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_rf_40h",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_fr_20",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_fr_40",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_fr_40h",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_ot_20",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_ot_40",   KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"local_ot_40h",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_dg_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_dg_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_dg_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_rf_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_rf_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_rf_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_fr_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_fr_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_fr_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_ot_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_ot_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"ts_ot_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_dg_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_dg_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_dg_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_rf_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_rf_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_rf_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_fr_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_fr_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_fr_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_ot_20",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_ot_40",      KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",   ColMerge:1,   SaveName:"mt_ot_40h",     KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	      	InitColumns(cols);
	      	SetEditable(1);
	      	SetRangeBackColor(1,0,2,37,"#555555");
	      	SetSheetHeight(230);
	      	SetSheetWidth(730);
	      	SetCountPosition(0);
            
        }
		break;
	case "sheet6": // sheet6 init
	    with(sheetObj){
		      var HeadTitle1="|Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"class_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unno",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vent",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vo_id",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stow",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_bkg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
		      SetCountPosition(0);
              
        }
		break;
	case "sheet7": // sheet7 init
	    with(sheetObj){
		      var HeadTitle1="POD|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
		      var HeadTitle2="POD|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"AutoSum",   Hidden:0, Width:135,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb45",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(180);
		      SetCountPosition(0);
              
        }
		break;
	case "sheet8": // sheet8 init
	    with(sheetObj){
		      var HeadTitle1="CGO TYPE|POD|MLB|CNTR|TYPE|DETAIL";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_cgo_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"e_mlb",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"e_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_tp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_detail",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
		      
        }
		break;
	case "sheet9": // sheet9 init
	    with(sheetObj){
		      var HeadTitle1="Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"class_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unno",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vent",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vo_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stow",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_bkg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
        }
		break;
	case "sheet10": // sheet10 init
	    with(sheetObj){
		      var HeadTitle1="|Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"class_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unno",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vent",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vo_id",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stow",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_bkg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
        }
		break;
	case "sheet11": // sheet11 init
	    with(sheetObj){
		      var HeadTitle1="POD|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
		      var HeadTitle2="POD|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"AutoSum",   Hidden:0, Width:135,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dg_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rf_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_20",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_40",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ak_45",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bb45",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
        }
		break;
	case "sheet12": // sheet12 init
	    with(sheetObj){
		      var HeadTitle1="CGO TYPE|POD|MLB|CNTR|TYPE|DETAIL";
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_cgo_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"e_mlb",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"e_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_tp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"e_detail",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
    	}
	    break;
	case "sheet13": // sheet13 init
	    with(sheetObj){
		      var HeadTitle1="Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"class_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"unno",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vent",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vo_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stow",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_bkg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(200);
        }
		break;
	case "sheet14":
	    with(sheetObj){
		      var HeadTitle1="Seq.|Container No.|TP|BKG No.|F/M|Seal No.|Weight|R/D|TS|Special Cargo|Special Cargo|Stow|PC|POD|MLB|A.POD|T/S VVD";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mty_bkg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:15 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bl_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ts_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cll_rmk1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cll_rmk2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"kr_tml_prct_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ts_vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(302);
        }
		break;
	}
}
/**
 * handling sheet process
 */ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // search
		formObj.f_cmd.value=SEARCH;
		sheetObj.WaitImageVisible = false;
		//sheetObjects[1].SetWaitImageVisible(0);
		sheetObjects[1].WaitImageVisible=false;
		ComOpenWait(true);
		var inByType="";
		var radios = document.getElementsByName("in_by_type_temp");
//		for (var i = 0, length = radios.length; i < length; i++) {
//		    if (radios[i].checked) {
//		        // do whatever you want with the checked radio
//		        alert(radios[i].value);
//
//		        // only one radio can be logically checked, don't check the rest
//		        break;
//		    }
//		}
		if(radios[0].checked){
			inByType="P";
		}
		else if (radios[1].checked){
			inByType="M";
		}
//		if (radios(0).checked)
//			inByType="P";
//		// else if (formObj.in_by_type_temp(1).checked)
//		// inByType = "A";
//		else if (radios(1).checked)
//			inByType="M";
		formObj.in_by_type.value=inByType;
		sXml=sheetObj.GetSearchData("ESM_BKG_0932GS.do",FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		}
		if (arrXml.length > 1) {
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObj);
		state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			if (document.form.vvd_cd_nm.value != "") {
				ComBtnEnable("btn_print");
			}
			if (sheetObjects[0].RowCount() > 0) {
				// sheetObj.DataInsert(-1);
				var lo_20=0, lo_40=0, lo_40h=0, lo_45=0;
				var ts_20=0, ts_40=0, ts_40h=0, ts_45=0;
				var mt_20=0, mt_40=0, mt_40h=0, mt_45=0;
//				var sm_20=0, sm_40=0, sm_40h=0, sm_45=0;
				var wgt=0;
				
				for ( var i=2; i < sheetObjects[0].RowCount() + 2; i++) {
					lo_20=lo_20 + sheetObjects[0].GetCellValue(i, "local_20")
												* 1;
					lo_40=lo_40 + sheetObjects[0].GetCellValue(i, "local_40")
												* 1;
					lo_40h=lo_40h + sheetObjects[0].GetCellValue(i, "local_40h")
												* 1;
					lo_45=lo_45 + sheetObjects[0].GetCellValue(i, "local_45")
												* 1;
					ts_20=ts_20 + sheetObjects[0].GetCellValue(i, "ts_20") * 1;
					ts_40=ts_40 + sheetObjects[0].GetCellValue(i, "ts_40") * 1;
					ts_40h=ts_40h + sheetObjects[0].GetCellValue(i, "ts_40h")
												* 1;
					ts_45=ts_45 + sheetObjects[0].GetCellValue(i, "ts_45") * 1;
					mt_20=mt_20 + sheetObjects[0].GetCellValue(i, "mty_20") * 1;
					mt_40=mt_40 + sheetObjects[0].GetCellValue(i, "mty_40") * 1;
					mt_40h=mt_40h + sheetObjects[0].GetCellValue(i, "mty_40h")	* 1;
					mt_45=mt_45 + sheetObjects[0].GetCellValue(i, "mty_45") * 1;
//					sm_20=sm_20 + sheetObjects[0].GetCellValue(i, "sum_20") * 1;
//					sm_40=sm_40 + sheetObjects[0].GetCellValue(i, "sum_40") * 1;
//					sm_40h=sm_40h + sheetObjects[0].GetCellValue(i, "sum_40h")
//												* 1;
//					sm_45=sm_45 + sheetObjects[0].GetCellValue(i, "sum_45") * 1;
					wgt=wgt + sheetObjects[0].GetCellValue(i, "wgt_mt") * 1;
				}
				
				if(formObj.in_cll_type.value == "LOCAL"){
					formObj.local_20.value=lo_20;
					formObj.local_40.value=lo_40 + lo_40h + lo_45;
					formObj.local.value=lo_20 + lo_40 + lo_40h + lo_45;
				}else if(formObj.in_cll_type.value == "TS"){
					formObj.ts_20.value=ts_20;
					formObj.ts_40.value=ts_40 + ts_40h + ts_45;
					formObj.ts.value=ts_20 + ts_40 + ts_40h + ts_45;
				}else if(formObj.in_cll_type.value == "EMPTY"){
					formObj.mt_20.value=mt_20;
					formObj.mt_40.value=mt_40 + mt_40h + mt_45;
					formObj.mt.value=mt_20 + mt_40 + mt_40h + mt_45;
				}
			}
			var status1=false;
			var iii=2;
			for ( var ii=0; ii < sheetObjects[0].RowCount(); ii++, iii++) {
				if (sheetObjects[0].GetCellValue(iii, "gubun_cd2") != "") {
					status1=true;
					break;
				}
			}
			if (!status1) {
				sheetObjects[0].SetColHidden("gubun_cd2",1);
			} else {
				sheetObjects[0].SetColHidden("gubun_cd2",0);
			}
			var status2=false;
			var iii=3;
			for ( var ii=0; ii < sheetObjects[1].RowCount(); ii++) {
				if (sheetObjects[1].GetCellValue(iii, "gubun_cd") != "") {
					status2=true;
					break;
				}
			}
			if (!status2) {
				sheetObjects[1].SetColHidden("gubun_cd",1);
			} else {
				sheetObjects[1].SetColHidden("gubun_cd",0);
			}
		}
		ComOpenWait(false);
		break;
		
	case COMMAND01: // 입력
		var sUrl = "/opuscntr/ESM_BKG_0925.do?pgmNo=ESM_BKG_0925&vvd="
				+ formObj.in_vvd_cd.value + "&vps_etd_dt="
				+ formObj.vps_etd.value.substring(0, 10) + "&loc_cd="
				+ formObj.in_pol_cd.value + "&loc_yd_cd="
				+ formObj.in_pol_yd_cd.value + "&disc_load_cd=L";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0925", 600, 400, false);
		break;
		
	case COMMAND02: // special CGO
		var sUrl="/opuscntr/ESM_BKG_0933.do?inVvdCd=" + formObj.in_vvd_cd.value
				+ "&inPolCcd=" + formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		location.href=sUrl;
		break;
	case COMMAND03: // Print
		ComOpenWindowCenter("/opuscntr/ESM_BKG_5007.do?pgmNo=ESM_BKG_5007","5007", 1020, 690, false);
		break;
	case COMMAND04:  //PDF Pring
		formObj.f_cmd.value=SEARCH01;
		sheetObj.SetWaitImageVisible(0);
		sheetObjects[1].SetWaitImageVisible(0);
		
		ComOpenWait(true);
		// LOCAL
		var inByType="LOCAL";
		formObj.in_by_type.value=inByType;
		
		var sXml=sheetObjects[2].GetSearchData("ESM_BKG_0932GS.do",FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[5].LoadSearchData(arrXml[0],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObjects[5]);
		state=sheetObjects[2].GetEtcData("TRANS_RESULT_KEY");
		
		if (state == "S") {
			var d2=0;
			var d4=0;
			var d5=0;
			var d7=0;
			var d8=0;
			var d9=0;
			var dw=0;
			var dx=0;
			var r2=0;
			var r4=0;
			var r5=0;
			var f2=0;
			var f4=0;
			var f5=0;
			var o2=0;
			var o4=0;
			var o5=0;
			var s2=0;
			var s4=0;
			var t2=0;
			var t4=0;
			var a2=0;
			var a4=0;
			var p2=0;
			var p4=0;
			var z2=0;
			var z4=0;
			var d3=0;
			var r9=0;
			var etc=0;
			var totalTpSize=0;
			var local=0;
			var localFull=0;
			var localEmpty=0;
			var ts=0;
			var tsFull=0;
			var tsEmpty=0;
			var wgt=0;
			var cntrNo="";
			for ( var i=1; i <= sheetObjects[2].RowCount(); i++) {
				if (sheetObjects[2].GetCellValue(i, "seq") == "") {
					sheetObjects[2].SetRowEditable(i,0);
				}
				if (sheetObjects[2].GetCellValue(i, "tp") == "D2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d2=d2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d4=d4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D5") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d5=d5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D7") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d7=d7 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D8") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d8=d8 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D9") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d9=d9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "DW") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						dw=dw + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "DX") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						dx=dx + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "R2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						r2=r2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "R4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						r4=r4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "R5") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						r5=r5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "F2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						f2=f2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "F4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						f4=f4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "F5") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						f5=f5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "O2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						o2=o2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						o4=o4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						o5=o5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "S2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						s2=s2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "S4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						s4=s4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "T2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						t2=t2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "T4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						t4=t4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "A2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						a2=a2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
					}
					wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "A4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						a4=a4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "P2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						p2=p2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "P4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						p4=p4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "Z2") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						z2=z2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "Z4") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						z4=z4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "D3") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						d3=d3 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[2].GetCellValue(i, "tp") == "R9") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						r9=r9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
					}
				}
				else {
					if (sheetObjects[2].GetCellValue(i, "tp") != ""){
						if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
							etc=etc + 1;
							totalTpSize=totalTpSize + 1;
							cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
							wgt=wgt + sheetObjects[2].GetCellValue(i, "wgt") * 1;
						}
					}
				}
			}
			cntrNo="";
			for ( var i=1; i <= sheetObjects[2].RowCount(); i++) {
				if (sheetObjects[2].GetCellValue(i, "ts") == "TS" || sheetObjects[2].GetCellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						ts=ts + 1;
						if (sheetObjects[2].GetCellValue(i, "mty_bkg_cd") == "F")
							tsFull=tsFull + 1;
						else
							tsEmpty=tsEmpty + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
					}
				}
				if (sheetObjects[2].GetCellValue(i, "ts") == "" && sheetObjects[2].GetCellValue(i, "seq") != "") {
					if (cntrNo != sheetObjects[2].GetCellValue(i, "cntr_no")) {
						local=local + 1;
						if (sheetObjects[2].GetCellValue(i, "mty_bkg_cd") == "F")
							localFull=localFull + 1;
						else
							localEmpty=localEmpty + 1;
						cntrNo=sheetObjects[2].GetCellValue(i, "cntr_no");
					}
				}				
			}
			// alert(wgt);
			formObj.local_d2.value=d2;
			formObj.local_d4.value=d4;
			formObj.local_d5.value=d5;
			formObj.local_d7.value=d7;
			formObj.local_d8.value=d8;
			formObj.local_d9.value=d9;
			formObj.local_dw.value=dw;
			formObj.local_dx.value=dx;
			formObj.local_r2.value=r2;
			formObj.local_r4.value=r4;
			formObj.local_r5.value=r5;
			formObj.local_f2.value=f2;
			formObj.local_f4.value=f4;
			formObj.local_f5.value=f5;
			formObj.local_o2.value=o2;
			formObj.local_o4.value=o4;
			formObj.local_o5.value=o5;
			formObj.local_s2.value=s2;
			formObj.local_s4.value=s4;
			formObj.local_t2.value=t2;
			formObj.local_t4.value=t4;
			formObj.local_a2.value=a2;
			formObj.local_a4.value=a4;
			formObj.local_p2.value=p2;
			formObj.local_p4.value=p4;
			formObj.local_z2.value=z2;
			formObj.local_z4.value=z4;
			formObj.local_d3.value=d3;
			formObj.local_r9.value=r9;
			formObj.local_etc.value=etc;
			formObj.local_totalTpSize.value=totalTpSize;
			formObj.local_local.value=local;
			formObj.local_localFull.value=localFull;
			formObj.local_localEmpty.value=localEmpty;
			formObj.local_ts.value=ts;
			formObj.local_tsFull.value=tsFull;
			formObj.local_tsEmpty.value=tsEmpty;
			formObj.local_wgt.value=wgt;
			formObj.local_wgt.value=ComGetMaskedValue(formObj.local_wgt.value, 'int');
			for ( var i=1; i <= sheetObjects[2].RowCount(); i++) {
				if (sheetObjects[2].GetCellValue(i, "tp") == "") {
					sheetObjects[2].SetRowBackColor(i,"#C0C0C0");
				}
			}
		}
		// T/S
		formObj.f_cmd.value=SEARCH01;
		inByType="TS";
		formObj.in_by_type.value=inByType;
		// alert();
		sXml=sheetObjects[6].GetSearchData("ESM_BKG_0932GS.do",FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[6].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[7].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[8].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[9].LoadSearchData(arrXml[0],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObjects[9]);
		state=sheetObjects[6].GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			var d2=0;
			var d4=0;
			var d5=0;
			var d7=0;
			var d8=0;
			var d9=0;
			var dw=0;
			var dx=0;
			var r2=0;
			var r4=0;
			var r5=0;
			var f2=0;
			var f4=0;
			var f5=0;
			var o2=0;
			var o4=0;
			var o5=0;
			var s2=0;
			var s4=0;
			var t2=0;
			var t4=0;
			var a2=0;
			var a4=0;
			var p2=0;
			var p4=0;
			var z2=0;
			var z4=0;
			var d3=0;
			var r9=0;
			var etc=0;
			var totalTpSize=0;
			var local=0;
			var localFull=0;
			var localEmpty=0;
			var ts=0;
			var tsFull=0;
			var tsEmpty=0;
			var wgt=0;
			var cntrNo="";
			for ( var i=1; i <= sheetObjects[6].RowCount(); i++) {
				if (sheetObjects[6].GetCellValue(i, "seq") == "") {
					sheetObjects[6].SetRowEditable(i,0);
				}
				if (sheetObjects[6].GetCellValue(i, "tp") == "D2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d2=d2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d4=d4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D5") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d5=d5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D7") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d7=d7 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D8") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d8=d8 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D9") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d9=d9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						gt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "DW") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						dw=dw + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "DX") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						dx=dx + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "R2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						r2=r2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "R4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						r4=r4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "R5") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						r5=r5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "F2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						f2=f2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "F4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						f4=f4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "F5") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						f5=f5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "O2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						o2=o2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						o4=o4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						o5=o5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "S2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						s2=s2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "S4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						s4=s4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "T2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						t2=t2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "T4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						t4=t4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "A2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						a2=a2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
					}
					wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "A4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						a4=a4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "P2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						p2=p2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "P4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						p4=p4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "Z2") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						z2=z2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "Z4") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						z4=z4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "D3") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						d3=d3 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObjects[6].GetCellValue(i, "tp") == "R9") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						r9=r9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
					}
				}
				else {
					if (sheetObjects[6].GetCellValue(i, "tp") != ""){
						if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
							etc=etc + 1;
							totalTpSize=totalTpSize + 1;
							cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
							wgt=wgt + sheetObjects[6].GetCellValue(i, "wgt") * 1;
						}
					}
				}
			}
			cntrNo="";
			for ( var i=1; i <= sheetObjects[6].RowCount(); i++) {
				if (sheetObjects[6].GetCellValue(i, "ts") == "TS"|| sheetObjects[6].GetCellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						ts=ts + 1;
						if (sheetObjects[6].GetCellValue(i, "mty_bkg_cd") == "F")
							tsFull=tsFull + 1;
						else
							tsEmpty=tsEmpty + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
					}
				}
				if (sheetObjects[6].GetCellValue(i, "ts") == "" && sheetObjects[6].GetCellValue(i, "seq") != "") {
					if (cntrNo != sheetObjects[6].GetCellValue(i, "cntr_no")) {
						local=local + 1;
						if (sheetObjects[6].GetCellValue(i, "mty_bkg_cd") == "F")
							localFull=localFull + 1;
						else
							localEmpty=localEmpty + 1;
						cntrNo=sheetObjects[6].GetCellValue(i, "cntr_no");
					}
				}				
			}
			// alert(wgt);
			formObj.ts_d2.value=d2;
			formObj.ts_d4.value=d4;
			formObj.ts_d5.value=d5;
			formObj.ts_d7.value=d7;
			formObj.ts_d8.value=d8;
			formObj.ts_d9.value=d9;
			formObj.ts_dw.value=dw;
			formObj.ts_dx.value=dx;
			formObj.ts_r2.value=r2;
			formObj.ts_r4.value=r4;
			formObj.ts_r5.value=r5;
			formObj.ts_f2.value=f2;
			formObj.ts_f4.value=f4;
			formObj.ts_f5.value=f5;
			formObj.ts_o2.value=o2;
			formObj.ts_o4.value=o4;
			formObj.ts_o5.value=o5;
			formObj.ts_s2.value=s2;
			formObj.ts_s4.value=s4;
			formObj.ts_t2.value=t2;
			formObj.ts_t4.value=t4;
			formObj.ts_a2.value=a2;
			formObj.ts_a4.value=a4;
			formObj.ts_p2.value=p2;
			formObj.ts_p4.value=p4;
			formObj.ts_z2.value=z2;
			formObj.ts_z4.value=z4;
			formObj.ts_d3.value=d3;
			formObj.ts_r9.value=r9;
			formObj.ts_etc.value=etc;
			formObj.ts_totalTpSize.value=totalTpSize;
			formObj.ts_local.value=local;
			formObj.ts_localFull.value=localFull;
			formObj.ts_localEmpty.value=localEmpty;
			formObj.ts_ts.value=ts;
			formObj.ts_tsFull.value=tsFull;
			formObj.ts_tsEmpty.value=tsEmpty;
			formObj.ts_wgt.value=wgt;
			formObj.ts_wgt.value=ComGetMaskedValue(formObj.ts_wgt.value, 'int');
			for ( var i=1; i <= sheetObjects[6].RowCount(); i++) {
				if (sheetObjects[6].GetCellValue(i, "tp") == "") {
					sheetObjects[6].SetRowBackColor(i,"#C0C0C0");
				}
			}
		}
		var radios = document.getElementsByName("in_by_type_temp");
		var inByType="";
		if (radios[0].checked)
			inByType="P";
		else if (radios[1].checked)
			inByType="M";
		formObj.in_by_type.value=inByType;
		// Print_Preview
		formObj.f_cmd.value=SEARCH02;
		formObj.in_sort_type.value="5";
		
		var xml13=sheetObjects[10].GetSearchData("ESM_BKG_0932GS.do",FormQueryString(formObj));
		sheetObjects[10].LoadSearchData(xml13,{Sync:1} );

		ComEtcDataToForm(formObj, sheetObjects[10]);
		state=sheetObjects[10].GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			var d2=0;
			var d4=0;
			var d5=0;
			var d7=0;
			var d8=0;
			var d9=0;
			var dw=0;
			var dx=0;
			var r2=0;
			var r4=0;
			var r5=0;
			var f2=0;
			var f4=0;
			var f5=0;
			var o2=0;
			var o4=0;
			var o5=0;
			var s2=0;
			var s4=0;
			var t2=0;
			var t4=0;
			var a2=0;
			var a4=0;
			var p2=0;
			var p4=0;
			var z2=0;
			var z4=0;
			var d3=0;
			var r9=0;
			var etc=0;
			var totalTpSize=0;
			var local=0;
			var localFull=0;
			var localEmpty=0;
			var ts=0;
			var tsFull=0;
			var tsEmpty=0;
			var wgt=0;
			for ( var i=1; i <= sheetObjects[10].RowCount(); i++) {
				
				if (sheetObjects[10].GetCellValue(i, "seq") == "") {
					sheetObjects[10].SetRowEditable(i,0);
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D2") {
					d2=d2 + 1;
					totalTpSize=totalTpSize + 1;
					gt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D4") {
					d4=d4 + 1;
					totalTpSize=totalTpSize + 1;
					gt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D5") {
					d5=d5 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D7") {
					d7=d7 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D8") {
					d8=d8 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D9") {
					d9=d9 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "DW") {
					dw=dw + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "DX") {
					dx=dx + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "R2") {
					r2=r2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "R4") {
					r4=r4 + 1;lESM_BKG_0932.do
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "R5") {
					r5=r5 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "F2") {
					f2=f2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "F4") {
					f4=f4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "F5") {
					f5=f5 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "O2") {
					o2=o2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "O4") {
					o4=o4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "O5") {
					o5=o5 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "S2") {
					s2=s2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "S4") {
					s4=s4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "T2") {
					t2=t2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "T4") {
					t4=t4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "A2") {
					a2=a2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "A4") {
					a4=a4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "P2") {
					p2=p2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "P4") {
					p4=p4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "Z2") {
					z2=z2 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "Z4") {
					z4=z4 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "D3"){
					d3=d3 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else if(sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "R9"){
					r9=r9 + 1;
					totalTpSize=totalTpSize + 1;
					wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
				}
				else{ 
					if(sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") != ""){
						etc=etc + 1;
						totalTpSize=totalTpSize + 1;
						wgt=wgt + sheetObjects[10].GetCellValue(i, "bl_wgt") * 1;
					}
				}
				if (formObj.in_cll_type.value == "TS") {
					if (sheetObjects[10].GetCellValue(i, "seq") != "") {
						ts=ts + 1;
						if (sheetObjects[10].GetCellValue(i, "mty_bkg_cd") == "F")
							tsFull=tsFull + 1;
						else
							tsEmpty=tsEmpty + 1;
					}
				} else {
					if (sheetObjects[10].GetCellValue(i, "ts_flg") == "TS"|| sheetObjects[10].GetCellValue(i, "ts_flg") == "TT") {
						ts=ts + 1;
						if (sheetObjects[10].GetCellValue(i, "mty_bkg_cd") == "F")
							tsFull=tsFull + 1;
						else
							tsEmpty=tsEmpty + 1;
					}
					if (sheetObjects[10].GetCellValue(i, "ts_flg") == ""
						&& sheetObjects[10].GetCellValue(i, "seq") != "") {
						local=local + 1;
						if (sheetObjects[10].GetCellValue(i, "mty_bkg_cd") == "F")
							localFull=localFull + 1;
						else
							localEmpty=localEmpty + 1;
					}
				}
			}
			formObj.preview_d2.value=d2;
			formObj.preview_d4.value=d4;
			formObj.preview_d5.value=d5;
			formObj.preview_d7.value=d7;
			formObj.preview_d8.value=d8;
			formObj.preview_d9.value=d9;
			formObj.preview_dw.value=dw;
			formObj.preview_dx.value=dx;
			formObj.preview_r2.value=r2;
			formObj.preview_r4.value=r4;
			formObj.preview_r5.value=r5;
			formObj.preview_f2.value=f2;
			formObj.preview_f4.value=f4;
			formObj.preview_f5.value=f5;
			formObj.preview_o2.value=o2;
			formObj.preview_o4.value=o4;
			formObj.preview_o5.value=o5;
			formObj.preview_s2.value=s2;
			formObj.preview_s4.value=s4;
			formObj.preview_t2.value=t2;
			formObj.preview_t4.value=t4;
			formObj.preview_a2.value=a2;
			formObj.preview_a4.value=a4;
			formObj.preview_p2.value=p2;
			formObj.preview_p4.value=p4;
			formObj.preview_z2.value=z2;
			formObj.preview_z4.value=z4;
			formObj.preview_d3.value=d3;
			formObj.preview_r9.value=r9;
			formObj.preview_etc.value=etc;
			formObj.preview_totalTpSize.value=totalTpSize;
			formObj.preview_local.value=local;
			formObj.preview_localFull.value=localFull;
			formObj.preview_localEmpty.value=localEmpty;
			formObj.preview_ts.value=ts;
			formObj.preview_tsFull.value=tsFull;
			formObj.preview_tsEmpty.value=tsEmpty;
			formObj.preview_wgt.value=wgt;
			formObj.preview_wgt.value=ComGetMaskedValue(formObj.preview_wgt.value, 'int');
			
			for ( var i=1; i <= sheetObjects[10].RowCount(); i++) {
				if (sheetObjects[10].GetCellValue(i, "cntr_tpsz_cd") == "") {
					sheetObjects[10].SetRowBackColor(i,"#C0C0C0");
				}
			}
		}
		
		ComOpenWait(false);
		ComOpenWindowCenter("/opuscntr/ESM_BKG_5007.do?pgmNo=ESM_BKG_5007&typecode=ALL","5007", 1020, 690, false);
		
		break;
	case IBSAVE: // save
		formObj.f_cmd.value=MULTI;
		formObj.set_to.value=formObj.setText1.value;
		formObj.set_fm.value=formObj.setText2.value;
		sheetObj.DoAllSave("ESM_BKG_0932GS.do", FormQueryString(formObj));
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //search
		return true;
		break;
	case IBSAVE: // save
		return true;
		break;
	case IBDELETE: // delete
		return true;
		break;
	}
}
/**
 * gubun媛믪뿉 �곕씪 議고쉶 諛⑸쾿 蹂�꼍
 * 
 * @param gubun
 *            gubun
 */
function goBySearch(gubun) {
	if (gubun == "P" || gubun == "A" || gubun == "M") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		ComBtnEnable("btn_print");
	} else {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
		ComBtnDisable("btn_print");
	}
	if (gubun == "P") {
		document.all["1pod"].style.display="inline";
		document.all["2pod"].style.display="inline";
		document.all["1apod"].style.display="none";
		document.all["2apod"].style.display="none";
		document.all["1mlb"].style.display="none";
		document.all["2mlb"].style.display="none";
//		sheetObjects[0].SetColProperty(0,)
	}
	if (gubun == "A") {
		document.all["1pod"].style.display="none";
		document.all["2pod"].style.display="none";
		document.all["1apod"].style.display="inline";
		document.all["2apod"].style.display="inline";
		document.all["1mlb"].style.display="none";
		document.all["2mlb"].style.display="none";
	}
	if (gubun == "M") {
		document.all["1pod"].style.display="none";
		document.all["2pod"].style.display="none";
		document.all["1apod"].style.display="none";
		document.all["2apod"].style.display="none";
		document.all["1mlb"].style.display="inline";
		document.all["2mlb"].style.display="inline";
	}
}

/**
 * pop select
 */
function popSelect(param) {
	if(param==null || param==""){
		param = "ALL";
	}
	var sUrl="/opuscntr/ESM_BKG_1056.do?pgmNo=ESM_BKG_1056&typecode="+param;
	ComOpenWindowCenter(sUrl, "ESM_BKG_1056", 800, 350, false);
}