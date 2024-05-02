/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_0359.js
 *@FileTitle : Transmission Status Cross Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
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
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_BL_Inquiry":
			doActionIBSheet(sheetObject1, document.form, SEARCH13);
			break;
		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, document.form, IBDOWNEXCEL);
			break;
		case "btn_Print1":
			if (sheetObject1.RowCount()== 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0869.do?pgmNo=ESM_BKG_0869", "0869", 1024, 690, false);
			break;
		case "btn_Print2":
			if (sheetObject2.RowCount()== 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/opuscntr/ESM_BKG_5009.do?pgmNo=ESM_BKG_5009", "5009", 1024, 690, false);
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
	for ( var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0); //ADD
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	document.form.vvd.focus();
	clientTimeSet();
}
/**
 * handling search conditions input
 */
function obj_KeyUp() {
	//var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var keyValue=keyCode ? keyCode : which ? which : charCode;
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");	
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * registering initial event 
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//	axon_event.addListener('click', 'chkClick', 'form');	
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerForm('change', 'chkChange2', formObject);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
        
	
	      var HeadTitle1="Seq.|Manifest File No.|M/H|Filer|M.B/L No.|B.POL|V.POL|V.POD|VVD|STS|VSL EDI|B/L EDI|B/L EDI|B/L EDI|Current Stage/Update|Current Stage/Update|B.OFC|CNTR No|MF STS|User Action|";
	      var HeadTitle2="Seq.|Manifest File No.|M/H|Filer|M.B/L No.|B.POL|V.POL|V.POD|VVD|STS|VSL EDI|Sent|VVD|MI Sent Time(EST)| | |B.OFC|CNTR No|MF STS|User Action|";
	      var headCount=ComCountHeadTitle(HeadTitle2);
	
	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	             {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:"ams_file_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"m_f",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"filer",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:109,  Align:"Center",  ColMerge:1,   SaveName:"mbl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"o_pol",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"t_pol",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"t_pod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"t_vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"v_mi",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"mi",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"sent_time",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_stage",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"update_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"b_ofc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mf_sts",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"user_action",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	       
	      InitColumns(cols);
	
	      SetEditable(0);
	      SetCountPosition(0);
	      SetSheetHeight(380);
            }




		break;
	case "sheet2": //sheet2 init
	    with(sheetObj){
        
	      if (location.hostname != "")
	      
	      var HeadTitle1="AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|AMS Filing Status|Current Booking Status|Current Booking Status|Current Booking Status|Current Booking Status|User Action|";
	      var HeadTitle2="Seq.|Manifest File No.|M/H|Filer|M.B/L No.|VVD|B.POL|V.POL|V.POD|C.STS|Current Stage/Update|Current Stage/Update|STS|VVD|V.POL|Filer|User Action|";
	      var headCount=ComCountHeadTitle(HeadTitle2);
	      cnt=0;
	      var prefix="";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	             {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ams_file_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"m_f",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"filer",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:109,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mbl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t_vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"o_pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t_pol",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t_pod",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mf_sts",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_stage",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:prefix+"update_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t_vvd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"t_pol2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"filer2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"user_action", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Status",    Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" } ];
	       
	      InitColumns(cols);
	
	      SetEditable(0);
	      SetSheetHeight(380);
            }


		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		
		ComOpenWait(true);
		
		sheetObj.RemoveAll();
		formObj.f_cmd.value=SEARCH;
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0359GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0)
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		if (arrXml.length > 1) {
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
		}
		clientTimeSet();
		ComOpenWait(false);
		break;
	case SEARCH02: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value=INIT;
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0359GS.do", FormQueryString(formObj));
		var eta=ComGetEtcData(sXml, "eta");
		formObj.eta.value=eta;
		clientTimeSet();
		ComOpenWait(false);
		ComSetFocus(formObj.pod);
		break;
	case IBINSERT: 
		break;
	case IBDOWNEXCEL: 
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		if (sheetObjects[0].RowCount()> 0) {
			sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
		}
		clientTimeSet();
		ComOpenWait(false);
		break;clientTimeSet
	case SEARCH13: //btn_BL_Inquiry
		var selTab=tab1.GetSelectedIndex();
		var sheetObject2=sheetObjects[selTab];
		if (sheetObject2.GetSelectRow()== -1) {
			ComShowMessage(ComGetMsg("BKG01002"));
			return;
		}
		var bl_no=sheetObject2.GetCellValue(sheetObject2.GetSelectRow(), "ams_file_no");
		var param="bl_no=" + bl_no;
		ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=ESM_BKG_0034-01&" + param, "ESM_BKG_0034", 1250, 700, false);
		break;
	}
}

function sheet1_OnDownFinish(downloadType, result) {
	if (sheetObjects[1].RowCount()> 0) {
		sheet2.SetHeaderBackColor("#CCCCCC");
		sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
		sheet2.SetHeaderBackColor("#333333");		
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:		
		if (!ComChkRequired(formObj))
			return false;
		break;
	case IBDOWNEXCEL:
		if (sheetObjects[0].RowCount()== 0 && sheetObjects[1].RowCount()== 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	}
	return true;
}
/**
 * registering IBTab Object as list
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
function initTab(tabObj, tabNo) {
	with (tabObj) {
		var cnt=0;
InsertItem( "Manifest Status", "");
InsertItem( "B/L to be deleted", "");
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	beforetab=nItem;
}
/**
 * retrieving ETA  in case of change event of VVD or POL.
 */
function chkChange2() {
	var srcName=event.srcElement.getAttribute("name");
	if (srcName == "vvd" || srcName == "pol") {		
		if (document.form.vvd.value.length == 9 && document.form.pol.value.length == 5) {
			doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
		} else {
			form.eta.value="";
			if (document.form.vvd.value.length != 9) {
				ComShowCodeMessage('BKG00007');
				return;
			}
			if (srcName == "pol" && document.form.pol.value.length != 5) {
				ComShowCodeMessage('BKG00288');
				return;
			}
			if (srcName == "vvd" && document.form.pol.value == "") {
				document.form.pol.focus();
			}
		}
	}
}
/**
 * handlier after retrieving sheet1 
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sentByMi=0;
	var addedByAi=0;
	var unManifest=0;
	var ManifestTtl=0;
	var targetTtl=0;
	var mf_sts="";
	var seq="";
	var preSeq="";
	with (sheetObj) {
		for ( var i=2; i <= LastRow(); i++) {
			if (GetCellValue(i, "t_vvd") != GetCellValue(i, "vvd"))
 				SetCellFontColor(i, "vvd","#FF0000");// red font
			if (GetCellValue(i, "m_f") == "H") {
				SetCellFontColor(i, "ams_file_no","#0000FF");// blue font
			}
			mf_sts=GetCellValue(i, "mf_sts");
			seq=GetCellValue(i, "seq");
			if (seq != preSeq) {
				if (mf_sts == "Sent By MI") {
					sentByMi++;
					ManifestTtl++;
				} else if (mf_sts == "Added By AI") {
					addedByAi++;
					ManifestTtl++;
				} else if (mf_sts == "Un-Manifested") {
					unManifest++;
				}				
			}
			preSeq=seq;
		}
		document.form.manifestTotal.value=" Manifest TTL [" + ManifestTtl + "]";
		document.form.sentByMiCount.value=" Sent by MI [" + sentByMi + "]";
		document.form.addedByAiCount.value=" Added by AI [" + addedByAi + "]";
		document.form.targetTotal.value=" Target   TTL [" + GetCellValue(LastRow(), "seq") + "]";
		document.form.unManifestCount.value=" Un-Manifest [" + unManifest + "]";
	}
}
/**
 * handlier after retrieving sheet2 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i=2; i <= LastRow(); i++) {
			if (GetCellValue(i, "t_vvd") != GetCellValue(i, "t_vvd2"))
 				SetCellFontColor(i, "t_vvd2","#FF0000");// red font
			if (GetCellValue(i, "t_pol") != GetCellValue(i, "t_pol2"))
 				SetCellFontColor(i, "t_vvd2","#FF0000");// red font
			if (GetCellValue(i, "filer") != GetCellValue(i, "filer2"))
				SetCellFontColor(i, "filer2","#FF0000");// red font
			if (GetCellValue(i, "m_f") == "H") {
 				SetCellFontColor(i, "ams_file_no","#0000FF");// blue font
			}
		}
	}
}
/**
 * show current date
 */
function clientTimeSet() {
	var d=new Date();
	var dStr=formatDate(d, 'yyyy-MM-dd HH:mm');
	form.runtime.value=dStr ;
}
