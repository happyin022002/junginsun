/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0012_01.js
*@FileTitle  : Long Range SKD  Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var iframeid='';
var dataStartCol=7;
var dataStartRow=7;
var visibleHeaderRows=4;
var tailerColCount=4; // cre_dt, cre_usr_id, upd_dt, upd_usr_id 
var dataSetCnt=3;
var portNum=0;
var vvdMap; // vvdMap reference id created by (0010)
var select_yn;
var pop_yn;
var cssmLength = 0;
var cssmWidth = 0;
var maxLength = 0;

//row position of header
var row_skd_dir_cd=0;
var row_yd_cd=1;
var row_yd_ind_seq=2;
var row_vps_port_cd=3;
var row_port_ind_seq=4;
var row_day=5;
var row_hour=6;

var gHeadColumn1	= "";

// Event handler processing by button click event */
document.onclick=processButtonClick;
var opener;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
//	var sheetObject1 = sheetObjects[1];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
//		case "btn_Retrieve":
//			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
//			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	opener = window.dialogArguments;
	if (!opener)
		opener = parent;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], '', '', '', '', '', '', '');
		ComEndConfigSheet(sheetObjects[i]);
		
	}
	initControl();
	loadParentInfo();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7) {
	var cnt		= 0;
	var sheetId	= sheetObj.id;
	
	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
	        tabIndex		= -1;
	        
	        if(HeadCol1 == null || HeadCol1 == undefined){
	        	HeadCol1	= "";
	        }
	        
	        gHeadColumn1	= HeadCol1;
	        
	        var HeadTitle1	= "| | | | | |"+HeadCol1+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle2	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol2+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle3	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol3+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle4	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol4+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle5	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol5+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle6	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol6+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var HeadTitle7	= "| | |VSL\nCD|VOY\nNO|CSSM\nVOY|DIR"+HeadCol7+"|RMK|cre_dt|cre_usr_id|upd_dt|upd_usr_id";
	        var headCount	= ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCols:dataStartCol, DataRowMerge:0 } );
	    	
	        var info    	= { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0};
	        var headers 	= new Array(6);
			
			headers[row_skd_dir_cd]   = {Text:HeadTitle1, Align:"Center", RowMerge:1}; // skd_dir_cd
			headers[row_vps_port_cd]  = {Text:HeadTitle2, Align:"Center", RowMerge:0}; // vps_port_cd
			headers[row_day]          = {Text:HeadTitle3, Align:"Center", RowMerge:0}; // day
			headers[row_hour]         = {Text:HeadTitle4, Align:"Center", RowMerge:0}; // hour
			headers[row_port_ind_seq] = {Text:HeadTitle5, Align:"Center", RowMerge:0}; // port_ind_seq
			headers[row_yd_cd]        = {Text:HeadTitle6, Align:"Center", RowMerge:1}; // yd_cd
			headers[row_yd_ind_seq]   = {Text:HeadTitle7, Align:"Center", RowMerge:0}; // yd_ind_seq
			
	        InitHeaders(headers, info);
	        
	        var cols = new Array();
	        for(var i = 0; i < dataSetCnt; i++) {
	        	cnt = 0;
	        	cols[cnt++] = {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" };
				cols[cnt++] = {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd" };
				cols[cnt++] = {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pf_skd_tp_cd" };
				cols[cnt++] = {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:1,   SaveName:"VVD1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
				cols[cnt++] = {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"VVD2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
				cols[cnt++] = {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"VVD3",   	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
				cols[cnt++] = {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:1,   SaveName:"VVD4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };

				portNum		= parseInt(ComCountHeadTitle(HeadCol1)-1)/3;
		        for(var j = 0 ; j < portNum; j++){
			        cols[cnt++] = {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ETB"+j,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
			        cols[cnt++] = {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ETD"+j,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
			        cols[cnt++] = {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"clpt_ind_seq"+j,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
		        }
		        cols[cnt++] = {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:1,   SaveName:"vps_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
		        cols[cnt++] = {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
		        cols[cnt++] = {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
		        cols[cnt++] = {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
		        cols[cnt++] = {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 };
	        }
	        InitColumns			(cols);
	    	
	        SetEditable			(0);
	        SetWaitImageVisible	(0);
	        
	        SetRowHidden		(row_vps_port_cd , 1);
	        SetRowHidden		(row_port_ind_seq, 1);
	        SetRowHidden		(row_yd_ind_seq  , 1);
	        
	        SetRowHeight(1,20);
	        SetRowHeight(2,20);
	        SetRowHeight(3,20);
	        SetRowHeight(4,20);
	        SetRowHeight(5,20);
	        SetRowHeight(6,20);
	        
	        //no support[check again]CLT 		MultiSelection=false;
	        //no support[check again]CLT 		FrozenRows=visibleHeaderRows;
	        //no support[implemented common]CLT 		SelectHighLight=false;
//	        SetFrozenRows(visibleHeaderRows); // This one occurs error: Could not bind data which has hidden row.
	        SetExtendLastCol(0);
	        SetCountPosition(0);
	        //no support[check again]CLT 		SetExcelColDialog(false); // blocking Ctrl+P in sheet
	        SetVisible(false);
    	}
		break;
	}
}
// registering initial event
function initControl() {
	var formObj=document.form;
}
//// handling sheet process
//function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = false;
//	switch (sAction) {
//
//	case IBSEARCH: // Retrieve
//		break;
//		
//	}
//}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
}

function loadXml(id, xmlStr, HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7){
	iframeid			= id;
	sheetObjects[0] 	= sheetObjects[0].Reset();
    ComConfigSheet 		(sheetObjects[0]);
    initSheet			(sheetObjects[0], HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7);
    ComEndConfigSheet	(sheetObjects[0]);
	sheetObjects[0].LoadSearchData(xmlStr, {Sync:1});
	
	var portNum			= parseInt(ComCountHeadTitle(HeadCol1)-1);
	var etbStartIdx 	= 7;
	
	for (var ydRow = 0; ydRow < portNum; ydRow = ydRow + 3) {
		sheetObjects[0].SetMergeCell(row_yd_cd, etbStartIdx+ydRow, 1, 3); // PORT Row
	}	
}

function resetSheet(){
	sheetObjects[0] = sheetObjects[0].Reset();
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	var width	= 0;
	var height	= 0;
	var portNum	= parseInt((sheetObj.LastCol()-tailerColCount-dataStartCol)/3);
	var totRows	= sheetObj.SearchRows() + visibleHeaderRows;
	// Handling scroll in case grid has more than 15 rows
	if(totRows > 14){
//		height= 14 * 20;
		height 	= ComGetSheetHeight(sheetObj, 14);
	}else{
//		height= totRows * 20;
		height 	= ComGetSheetHeight(sheetObj, totRows);
	}
	
	/**==========================================================================
	 * Auto Focusing and Display proforma type code
	 * ==========================================================================
	 */
	var searchRowCount 	= 0;
	var rowIndex 		= 0;
	searchRowCount 		= sheetObj.SearchRows();
	
	if (searchRowCount > 0) {
		rowIndex = sheetObj.LastRow();
		var vslSlanCd 	= sheetObj.GetCellValue(rowIndex, "vsl_slan_cd");
		var pfSkdTpCd 	= sheetObj.GetCellValue(rowIndex, "pf_skd_tp_cd");
		var pfTypes		= vslSlanCd + "/" + pfSkdTpCd;
		
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD1", pfTypes);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD2", pfTypes);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD3", pfTypes);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD4", pfTypes);
	}
	/**==========================================================================
	 * ==========================================================================
	 */	

//:2016-10-06:///////////////////////////////////////////////////////////////////
//	for(var i=dataStartRow; i<sheetObj.LastRow(); i++){
//		var cssmStr = sheetObj.GetCellValue(i, "VVD3");
//		cssmLength = cssmStr.length;
//		if(cssmLength > maxLength){
//			maxLength = cssmLength;
//			cssmWidth = 8*maxLength;
//			sheetObj.SetColWidth("VVD3", cssmWidth);
//		}
//	}
//////////////////////////////////////////////////////////////////////////////////	
	
	
	sheetObj.RenderSheet(0);
//	sheetObj.SetColWidth("VVD2", 0);
	if(portNum<=11){ 	// Controling grid width in case count of port <= 11
		width=138 + sheetObj.GetColWidth("VVD2") + ( portNum * 68 ) + 2; // 138=[vsl_cd(44) + skd_voy_no(44) + RMK(50)] // 2 : grid boundary value
		if(totRows > 14){
			// to blocking scroll, width Add
			width	= width + 20;
		}
		//sheetObj.style.width=width;
	}else{
		height		= height + 21; // to blocking scroll, height Add
		//sheetObj.style.width="100%";	
	}
	
	sheetObj.SetSheetHeight(height + 2);// grid boundary value
	sheetObj.SetVisible(true);
	sheetObj.RenderSheet(1);
	if ($('#DIV_sheet1').children('.GridMain').length > 1) { // When the library is fixed, These lines can be deleting.
		$('#DIV_sheet1').children('.GridMain').first().remove();
	}
	opener.setSize(iframeid, height);
	opener.postProcess(iframeid);
	
	
	//:2016-11-01-- Apply to merge column 'TERMINAL' --://
	var portNum			= parseInt(ComCountHeadTitle(gHeadColumn1)-1);
	var etbStartIdx 	= 7;
	
	for (var ydRow = 0; ydRow < portNum; ydRow = ydRow + 3) {
		sheetObjects[0].SetMergeCell(row_yd_cd, etbStartIdx+ydRow, 1, 3); // PORT Row
	}	
	//:------------------------------------------------://
	
	
//	loadPage();
	
	//:2016-10-06://///////////
	//sheetObj.FitSize(0, 1);
	//sheetObj.FitColWidth();
	//sheetObj.FitColWidth("10|20|30|40");
	sheetObj.ColWidth("VVD2")	= 0;
	sheetObj.ColWidth("VVD3")	= 0;
	///////////////////////////
		
}

function sheet1_OnClick(sheetObj, Row, Col, Value){
	var formObj=opener.document.form;
	if(Col>=dataStartCol && Value!=undefined && ComTrim(Value)!=""){
		formObj.cre_dt.value=sheetObj.GetCellValue(Row, "cre_dt");
		formObj.cre_usr_id.value=sheetObj.GetCellValue(Row, "cre_usr_id");
		formObj.upd_dt.value=sheetObj.GetCellValue(Row, "upd_dt");
		formObj.upd_usr_id.value=sheetObj.GetCellValue(Row, "upd_usr_id");
		selectVVD(sheetObj, Row, Col);
	}else{
		formObj.cre_dt.value="";
		formObj.cre_usr_id.value="";
		formObj.upd_dt.value="";
		formObj.upd_usr_id.value="";
	}
}
function sheet1_OnDblClick(sheetObj, Row, Col, Value, CellX, CellY){
	if(Col > sheetObj.LastCol() - tailerColCount || ComTrim(Value) == ""){
		return;
	}
	var colSaveName=sheetObj.ColSaveName(Col);
	// when VVD double click, VOP_VSK_0019 popup open
	if(colSaveName=="VVD1" || colSaveName=="VVD2" || colSaveName=="VVD3" || colSaveName=="VVD4"){
		ComOpenWait(true);
		popupVVDInquiry(sheetObj.GetCellValue(Row, "VVD1"), sheetObj.GetCellValue(Row, "VVD2"), sheetObj.GetCellValue(Row, "VVD4"));
		ComOpenWait(false);
	}
	// when Port SKD double click, VOP_VSK_0250 popup open
	if( Value!="" && (colSaveName.indexOf("ETB") > -1 || colSaveName.indexOf("ETD") > -1)){
		ComOpenWait(true);
		popupPortSkdInquiry(sheetObj, Row, Col);
		ComOpenWait(false);
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}

function selectVVD(sheetObj, Row, Col){
	var formObj=document.form;
	if(select_yn!="Y"){
		return false;
	}
	var dir_cd=sheetObj.GetCellValue(row_skd_dir_cd, Col);
	var oldPos=0;
	// in case a port already selected, canceling selection
	for(var i=0; i<sheetObj.LastCol(); i++){
		if(dir_cd == sheetObj.GetCellValue(row_skd_dir_cd, i)){
			if(sheetObj.GetCellFontColor(Row, i) == "#FFFFFF"){
				sheetObj.SetCellFontColor(Row, i,"");
				sheetObj.SetCellFontColor(Row, i+1,"");
				sheetObj.SetCellBackColor(Row, i,"#FFFFFF");
				sheetObj.SetCellBackColor(Row, i+1,"#FFFFFF");
				oldPos=i;
				removeVVD(sheetObj, Row, i);
				break;
			}
		}
	}
	// displaying selected port
	var col=Col;
	if(Col%3==2){
		col=Col - 1;
	}
	if(oldPos!=col){
		sheetObj.SetCellFontColor(Row, col,"#FFFFFF");
		sheetObj.SetCellFontColor(Row, col+1,"#FFFFFF");
		sheetObj.SetCellBackColor(Row, col,"#000001");
		sheetObj.SetCellBackColor(Row, col+1,"#000001");
		putVVD(sheetObj, Row, col);
	}
}
function removeVVD(sheetObj, Row, Col){
var vvd=sheetObj.GetCellValue(Row, "VVD1") + sheetObj.GetCellValue(Row, "VVD2") + sheetObj.GetCellValue(row_skd_dir_cd, Col);
	var pos=vvdMap.exist(vvd);
	if(pos!=-1){
		vvdMap.remove(pos);
	}
}
function putVVD(sheetObj, Row, Col){
	var skdInfo=new Object();
	var vvd=sheetObj.GetCellValue(Row, "VVD1") + sheetObj.GetCellValue(Row, "VVD2") + sheetObj.GetCellValue(row_skd_dir_cd, Col);
	skdInfo.vsl_cd=sheetObj.GetCellValue(Row, "VVD1");
	skdInfo.skd_voy_no=sheetObj.GetCellValue(Row, "VVD2");
	skdInfo.skd_dir_cd=sheetObj.GetCellValue(row_skd_dir_cd, Col);
	skdInfo.port_cd=sheetObj.GetCellValue(row_vps_port_cd, Col);
	skdInfo.clpt_ind_seq=sheetObj.GetCellValue(row_port_ind_seq, Col);
	//	skdInfo.etb_dt = sheetObj.CellValue(Row, Col);
	//	skdInfo.etd_dt = sheetObj.CellValue(Row, Col+1);
	
	//::FOR.NYK.START::by dongsoo:2014-09-25:://
	//::etd선택시 etb선택되지 않는 문제 해결
	
	var colName = sheetObj.ColSaveName(Col).substring(0,3);
	if (colName == "ETB") {
	skdInfo.etb_dt=sheetObj.GetCellValue(Row+2, Col);
	skdInfo.etd_dt=sheetObj.GetCellValue(Row+2, Col+1);
	} else if (colName == "ETD") {
		skdInfo.etb_dt=sheetObj.GetCellValue(Row+2, Col-1);
		skdInfo.etd_dt=sheetObj.GetCellValue(Row+2, Col);
	}
	//::FOR.NYK.FINISH::by dongso:2014-09-25:://

	vvdMap.put(vvd, skdInfo);
}
function loadParentInfo(){
	var info=opener.getSubInfo();
	vvdMap=info.vvdMap;
	select_yn=info.select_yn;
	pop_yn=info.pop_yn;
}
function Down2Excel(Mode, UseOpenFile) {
	return sheetObjects[0].Down2Excel({
//		HiddenColumn: 1,
		DownRows:"Visible",
		SheetName: "Long Range SKD",
//		Xml: sheetObjects[0].GetSearchData("/opuscntr/apps/opus/vop/vsk/scheduleplanningoperation/vesselschedulemgt/script/VOP_VSK_0012_01.xml"),
		AutoSizeColumn: 1,
		DebugMode:1
		,DownCols: makeHiddenSkipCol(sheetObjects[0])
		,Merge:1
	});
}
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
	// Coloring selected VVD
	if(OldRow >= sheetObj.HeaderRows()){
		sheetObj.SetCellBackColor(OldRow, "VVD1","");
		sheetObj.SetCellBackColor(OldRow, "VVD2","");
		sheetObj.SetCellBackColor(OldRow, "VVD3","");
		sheetObj.SetCellBackColor(OldRow, "VVD4","");

		sheetObj.SetCellBackColor(NewRow, "VVD1","#8080FF");
		sheetObj.SetCellBackColor(NewRow, "VVD2","#8080FF");
		sheetObj.SetCellBackColor(NewRow, "VVD3","#8080FF");
		sheetObj.SetCellBackColor(NewRow, "VVD4","#8080FF");

	}
	// Showing selected VVD and Lane, P/F Type Code
	if(OldRow >= sheetObj.HeaderRows()){
		var pfTypes=sheetObj.GetCellValue(NewRow, "vsl_slan_cd") + "/" + sheetObj.GetCellValue(NewRow, "pf_skd_tp_cd")
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD1",pfTypes,0);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD2",pfTypes,0);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD3",pfTypes,0);
		sheetObj.SetCellValue(row_skd_dir_cd, "VVD4",pfTypes,0);

	}
}
function popupVVDInquiry(vslCd, skdVoyNo, skdDirCd){
	var skdVoyNo1="";
	var skdVoyNo2="";
	var skdDirCd1="";
	var skdDirCd2="";
	var sUrl="/opuscntr/VOP_VSK_0019_POP.do?pop_mode=Y&vsl_cd=" + vslCd;
	if(skdVoyNo.indexOf("/")>-1){
		skdVoyNo1=skdVoyNo.substring(0, 4);
		skdVoyNo2=skdVoyNo.substring(5, 9);
	}else{
		skdVoyNo1=skdVoyNo;
		skdVoyNo2=skdVoyNo;
	}
	// VOP_VSK_0019 popup
	if(skdDirCd.indexOf("/")>-1){
		skdDirCd1=skdDirCd.substring(0, 1);
		skdDirCd2=skdDirCd.substring(2, 3);
	}else{
		skdDirCd1=skdDirCd;
	}
	var vvd=vslCd + skdVoyNo1 + skdDirCd1;
	if(ComShowConfirm("Do you want to open 'Vessel SKD Inquiry by VVD(" + vvd + ")'?")){
		sUrl=sUrl + "&skd_voy_no=" + skdVoyNo1 + "&skd_dir_cd=" + skdDirCd1;
		ComOpenPopupWithTarget(sUrl, 1024, 660, "", "0,0", false);	
	}else if(skdDirCd2!=""){
		vvd=vslCd + skdVoyNo2 + skdDirCd2;
		if(ComShowConfirm("Do you want to open 'Vessel SKD Inquiry by VVD(" + vvd + ")'?")){
			sUrl=sUrl + "&skd_voy_no=" + skdVoyNo2 + "&skd_dir_cd=" + skdDirCd2;
			ComOpenPopupWithTarget(sUrl, 1024, 660, "", "0,0", false);
		}
	}
}
function popupPortSkdInquiry(sheetObj, Row, Col){
	
	var vslCd		= sheetObj.GetCellValue(Row				, "VVD1");
	var skdVoyNo	= sheetObj.GetCellValue(Row				, "VVD2");
	var skdDirCd	= sheetObj.GetCellValue(row_skd_dir_cd	, Col	);
	var vpsPortCd	= sheetObj.GetCellValue(row_vps_port_cd	, Col	);
	var clptIndSeq	= sheetObj.GetCellValue(row_port_ind_seq, Col	);
	var clptSeq		= sheetObj.GetCellValue(Row + 1			, Col	);
	
	//alert('Row ['+Row+'] > Col ['+Col+']'); //sheetObj.GetCellValue(Row, Col));
	//alert(sheetObj.ColSaveName(Col));
	
	var colName			= sheetObj.ColSaveName(Col);
	var clptIndSeqColId	= 0;
	if(colName.indexOf("ETB")>-1){
		clptIndSeqColId	= Col+2;
	}else if(colName.indexOf("ETD")>-1){
		clptIndSeqColId	= Col+1;
	}
	
	var newClptIndSeq	= sheetObj.GetCellValue(Row			, clptIndSeqColId);
	
	//alert(sheetObj.GetCellValue(Row, clptIndSeqColId));
	
//	var ydCd = sheetObj.CellValue(5, Col);
//	var callYdIndSeq = sheetObj.CellValue(6, Col);
	var tmpSkdDirCd=sheetObj.GetCellValue(Row, "VVD4");
	var skdVoyNo1="";
	var skdVoyNo2="";
	var skdDirCd1="";
	var skdDirCd2="";
	if(skdVoyNo.indexOf("/")>-1){
		skdVoyNo1=skdVoyNo.substring(0, 4);
		skdVoyNo2=skdVoyNo.substring(5, 9);
	}else{
		skdVoyNo1=skdVoyNo;
		skdVoyNo2=skdVoyNo;
	}
	if(tmpSkdDirCd.indexOf("/")>-1){
		skdDirCd1=tmpSkdDirCd.substring(0, 1);
		skdDirCd2=tmpSkdDirCd.substring(2, 3);
	}else{
		skdDirCd1=tmpSkdDirCd;
	}
	// in case one VVD has two skd_voy_no, Dividing as dir_cd
	if(skdDirCd==skdDirCd1){
		skdVoyNo=skdVoyNo1;
		skdDirCd=skdDirCd1;
	}else if(skdDirCd==skdDirCd2){
		skdVoyNo=skdVoyNo2;
		skdDirCd=skdDirCd2;
	}else{
		return;
	}
	var sUrl="/opuscntr/VOP_VSK_0250.do?vsl_cd=" + vslCd 
					+ "&skd_voy_no=" + skdVoyNo
					+ "&skd_dir_cd=" + skdDirCd
					+ "&vps_port_cd=" + vpsPortCd
					+ "&clpt_ind_seq=" + newClptIndSeq;
					//:2015-11-25://+ "&clpt_seq=" + clptSeq;
	
	//::FOR.NYK.START::by dongsoo:2014-09-25:://
	ComOpenPopup(sUrl, 400, 450, "", "1,0,1,1,1,1,1", false,false,null,null,null,"VOP_VSK_0012_01_Detail_POPUP");
	//::FOR.NYK.FINISH::by dongso:2014-09-25:://
}