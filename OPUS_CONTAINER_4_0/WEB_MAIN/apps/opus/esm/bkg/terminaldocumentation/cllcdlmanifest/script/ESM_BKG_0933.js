/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0933.jsp
*@FileTitle  : Container Loading List(KOREA)_Print Preview_Special Cargo 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/  

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
//Event handler processing by button click event */
 document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_Print":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_close":
			ComClosePopup();
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
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
			var HeadTitle1="|Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID(FEU)|STOW|";

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cs2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stow",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mty_bkg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			InitColumns(cols);
			SetSheetHeight(200);
			SetEditable(1);
			SetCountPosition(0);
		    }

		break;
	case "sheet2": // sheet1 init
	    with(sheetObj){
        
			var HeadTitle1="POD|DG|DG|DG|RF|RF|RF|AK|AK|AK|BB|BB|BB";
			var HeadTitle2="POD|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H|20FT|40FT|40H";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
			                { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ 
			            {Type:"Text",   Hidden:0, Width:135,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			SetSheetHeight(180);
			Editable=true;
			SetRangeBackColor(1,1,1,12,"#555555");
			SetCountPosition(0);
            }
		break;
	case "sheet4": // sheet1 init
	    with(sheetObj){
        
			var HeadTitle1="Seq.|CGO TYPE|BKG No.|TS|POD|MLB|CS1|Container No.|TP|CS2|WGT|CLASS|UNNO.|MP|SG|LQ|TEMP|VENT|REMARK(DG&AK)|VOID|STOW|";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

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
			SetSheetHeight(200);
			SetEditable(1);
			SetCountPosition(0);
		    
            }


		break;
	case "sheet3": // sheet1 init
	    with(sheetObj){
       
			var HeadTitle1="CGO TYPE|POD|MLB|CNTR|TYPE|DETAIL";

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

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
			SetSheetHeight(200);
			SetEditable(1);
			SetCountPosition(0);
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
		//var formObject=document.form;
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		sheetObjects[1].SetWaitImageVisible(0);
		ComOpenWait(true);
//		var inByType="";
//		if (formObj.in_by_type_temp[0].checked)
//			inByType="ALL";
//		else if (formObj.in_by_type_temp[1].checked)
//			inByType="LOCAL";
//		else if (formObj.in_by_type_temp[2].checked)
//			inByType="TS";
		formObj.in_by_type.value=formObj.in_cll_type.value;
		//parameter changed[check again]CLT 		
		var sXml=sheetObj.GetSearchData("ESM_BKG_0933GS.do",
				FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[0],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObj);
		state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
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
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "seq") == "") {
					sheetObj.SetRowEditable(i,0);
				}
				if (sheetObj.GetCellValue(i, "tp") == "D2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d2=d2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d4=d4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D5") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d5=d5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D7") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d7=d7 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D8") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d8=d8 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D9") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d9=d9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "DW") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						dw=dw + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "DX") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						dx=dx + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "R2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						r2=r2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "R4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						r4=r4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "R5") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						r5=r5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "F2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						f2=f2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "F4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						f4=f4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "F5") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						f5=f5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "O2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						o2=o2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "O4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						o4=o4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "O5") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						o5=o5 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "S2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						s2=s2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						gt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "S4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						s4=s4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "T2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						t2=t2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "T4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						t4=t4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "A2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						a2=a2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
					}
					wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
				}
				else if (sheetObj.GetCellValue(i, "tp") == "A4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						a4=a4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "P2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						p2=p2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "P4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						p4=p4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "Z2") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						z2=z2 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "Z4") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						z4=z4 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "D3") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						d3=d3 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else if (sheetObj.GetCellValue(i, "tp") == "R9") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						r9=r9 + 1;
						totalTpSize=totalTpSize + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
						wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
					}
				}
				else {
					if (sheetObj.GetCellValue(i, "tp") != ""){
						if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
							etc=etc + 1;
							totalTpSize=totalTpSize + 1;
							cntrNo=sheetObj.GetCellValue(i, "cntr_no");
							wgt=wgt + sheetObj.GetCellValue(i, "wgt") * 1;
						}
					}
				}
			}
			cntrNo="";
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "ts") == "TS"
					|| sheetObj.GetCellValue(i, "ts") == "TT") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						ts=ts + 1;
						if (sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
							tsFull=tsFull + 1;
						else
							tsEmpty=tsEmpty + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
					}
				}
				if (sheetObj.GetCellValue(i, "ts") == ""
					&& sheetObj.GetCellValue(i, "seq") != "") {
					if (cntrNo != sheetObj.GetCellValue(i, "cntr_no")) {
						local=local + 1;
						if (sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
							localFull=localFull + 1;
						else
							localEmpty=localEmpty + 1;
						cntrNo=sheetObj.GetCellValue(i, "cntr_no");
					}
				}				
			}
			//alert(wgt);
			formObj.d2.value=d2;
			formObj.d4.value=d4;
			formObj.d5.value=d5;
			formObj.d7.value=d7;
			formObj.d8.value=d8;
			formObj.d9.value=d9;
			formObj.dw.value=dw;
			formObj.dx.value=dx;
			formObj.r2.value=r2;
			formObj.r4.value=r4;
			formObj.r5.value=r5;
			formObj.f2.value=f2;
			formObj.f4.value=f4;
			formObj.f5.value=f5;
			formObj.o2.value=o2;
			formObj.o4.value=o4;
			formObj.o5.value=o5;
			formObj.s2.value=s2;
			formObj.s4.value=s4;
			formObj.t2.value=t2;
			formObj.t4.value=t4;
			formObj.a2.value=a2;
			formObj.a4.value=a4;
			formObj.p2.value=p2;
			formObj.p4.value=p4;
			formObj.z2.value=z2;
			formObj.z4.value=z4;
			formObj.d3.value=d3;
			formObj.r9.value=r9;
			formObj.etc.value=etc;
			formObj.totalTpSize.value=totalTpSize;
			formObj.local.value=local;
			formObj.localFull.value=localFull;
			formObj.localEmpty.value=localEmpty;
			formObj.ts.value=ts;
			formObj.tsFull.value=tsFull;
			formObj.tsEmpty.value=tsEmpty;
			formObj.wgt.value=wgt;
			formObj.wgt.value=ComGetMaskedValue(formObj.wgt.value, 'int');
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "tp") == "") {
					sheetObj.SetRowBackColor(i,"#C0C0C0");
				}
			}
		}
		ComOpenWait(false);
		break;
	case COMMAND01: // �낅젰
		// alert("111");
		ComOpenWindowCenter("/opuscntr/ESM_BKG_5008.do?pgmNo=ESM_BKG_5008",
				"5008", 900, 660, false);
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


function goBySearch(gubun) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}


function goSearch() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}