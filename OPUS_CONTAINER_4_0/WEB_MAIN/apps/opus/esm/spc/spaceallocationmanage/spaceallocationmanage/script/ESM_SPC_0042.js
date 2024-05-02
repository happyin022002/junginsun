/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0042.js
*@FileTitle  : Control by HO
*@author     : CLT 
*@version    : 1.0  
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var sheetResizeCount = 2;
// index of shown Tp/S (index of sizeColName)
var colSizeIdx = new Array(0, 0, 0, 0, 1, 1, 0, 0);
//Checking if the item is controled or not
var controlCols = new Array(true, true, true, true, true, true, true, false);
var fcastIdx = 0;
var finalIdx = 1;
var modelIdx = 2;
var alocIdx = 3;
var bkgFirmIdx = 4;
var bkgTtlIdx = 5;
var guarIdx = 6;
var baseIdx = 7;
var MasterCnt = 14;			//20160118.MOD : 9->14
var TailCnt = 25;
var ColumnCnt = MasterCnt + TailCnt;
var txtHeadItem = new Array("Forecast", "Final load", "Model", "Allocation", "Booking(Firm)", "Booking(TTL)", "CustomerGuarantee", "Base");
var HeadVolume = new Array("Volume|Volume|Volume|Volume|Volume|WT\n(M/T)", "Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)");
var HeadTypeSize = new Array("TEU|HC|45'|53'|Reefer|WT\n(M/T)", "Total TEU|20'|40'|HC|45'|53'|Reefer|WT\n(M/T)");
var preColName = new Array("fcast", "fnl", "bkg", "asgn", "bkg_aval", "usd_bkg", "gnt", "base");
var sizeColName = new Array(new Array("_ttl_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"),
    new Array("_ttl_qty", "_20ft_qty", "_40ft_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt"));
var HeadMaster1 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|POL|POD|||||| |Load\nQTA|CMPB|Forecast";	//20160118.ADD
var HeadMaster2 = "OCN\nIPC\nT/S|Area\nRHQ|Load\nOffice|POL|POD|||||| |Load\nQTA|CMPB|CMPB";		//20160118.ADD
var txtDelem = "|";
var HeadTail = "";
var syncTarget = new Array(false, true, false, true, false, false, false, false);
// check box name by item shown on data select 
var dataSelectionItemName = new Array("", "chkUSG", "chkMDL", "", "chkBKGF", "", "chkCUS", "");
// weight column list in the top sheet
var weightCols = new Array(8, 10, 17, 19, 21, 24, 26, 28, 30, 32, 34);
//  ocn column list in the top sheet
var ocnCols = new Array(14, 16, 17, 23, 24, 29, 30);
//  ipc column list in the top sheet
var ipcCols = new Array(15, 18, 19, 25, 26, 31, 32);
//  ipc column list in the top sheet
var tsCols = new Array(20, 21, 27, 28, 33, 34);
// existing searching value of Forecast QTY View
var fcastType = null;
document.onclick = processButtonClick;

function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var formObject = document.form;
    var srcName = ComGetEvent("name");
    if (ComGetBtnDisable(srcName)) return false;
    switch (srcName) {
        case "btn_retrieve":
            //            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
            sheetObjects[0].RemoveAll();
            sheetObjects[1].RemoveAll();

            cancelControlOption(sheetObject);
            enableButtons(false);
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
        case "btn_new":
            if (checkModifiedSheet(sheetObjects[1])) {
                if (ComShowConfirm(getMsg("SPC90001")) != 1) {
                    return;
                }
            }
            resetAll();
            cancelControlOption(sheetObject);
            enableButtons(false);
            hiddenMasterCols(sheetObject, formObject, "INIT");
            break;
        case "btn_save":
            doActionIBSheet(sheetObject1, formObject, IBSAVE);
            break;
        case "btn_downexcel":
            if (sheetObject1.RowCount() < 1) { //no data
                ComShowCodeMessage("COM132501");
            } else {
                doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
            }
            break;
        case "btng_bottleneck":
            var param = "";
            var frow = sheetObject.FindText("dataSeq", String(sheet1_SelectedRow));
            var vvd = sheetObject.GetCellValue(frow, "VVD");
            param = param + "&year1=" + sheetObject.GetCellValue(frow, "WEEK").substring(0, 4);
            param = param + "&week1=" + sheetObject.GetCellValue(frow, "WEEK").substring(4);
            param = param + "&lane=" + sheetObject.GetCellValue(frow, "rlane_cd");
            param = param + "&bound=" + sheetObject.GetCellValue(frow, "dir_cd");
            param = param + "&vvd=" + vvd
            param = param + "&popupcheck=Y";
            //            	    	var url="ESM_SPC_0045.do?" + param;
            //    		    		ComOpenWindow(url,  "BOTTLENECK", "height=700px,width=1300px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);
            ComOpenPopup('ESM_SPC_0045_POP.do?' + param, 900, 600, "", "1,0", false);
            break;

        case "btng_skd":
            var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow + "");
            var param = "&vvd=" + (sheetObject.GetCellValue(frow, "VVD") == -1 ? "" : sheetObject.GetCellValue(frow, "VVD"));
            var url = "ESM_SPC_0071.do?" + param;
            //            	    	ComOpenPopup(url, 700, 600, "", "0,0,0,0,0", false);
            ComOpenWindow(url, "", "height=600px,width=700px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);
            break;

        case "btng_bsa":
            var param = "";
            var frow = sheetObject.FindText("dataSeq", String(sheet1_SelectedRow));
            var vvd = sheetObject.GetCellValue(frow, "VVD");
            param = param + "&txtYear=" + sheetObject.GetCellValue(frow, "WEEK").substring(0, 4);
            param = param + "&txtFmWeek=" + sheetObject.GetCellValue(frow, "WEEK").substring(4);
            param = param + "&txtToWeek=" + sheetObject.GetCellValue(frow, "WEEK").substring(4);
            param = param + "&selDir=" + sheetObject.GetCellValue(frow, "dir_cd");
            param = param + "&txtVsl_cd=" + vvd.substring(0, 4);
            param = param + "&txtSkd_voy_no=" + vvd.substring(4, 8);
            param = param + "&txtDir_cd=" + vvd.substring(8);
            param = param + "&hSearchYN=Y";
            var url = "ESM_BSA_0104_POP.do?" + param;
            //            	    	ComOpenPopup(url, "BSA", "height=600px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);
            //            	    	ComOpenPopup(url, 1100, 600, "", "1,0", false);
            ComOpenWindow(url, "", "height=600px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes", false);

            break;
        case "btng_copymodel":
            doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
            break;
        case "btng_controlEdit":
            editControlOption(sheetObject);
            break;
        case "btng_controlSave":
            var rtn = saveControlOption(sheetObject);
            if (rtn || rtn == "OK") {
                var frow = sheetObject.FindText("dataSeq", String(sheet1_SelectedRow));
                sheet1_OnDblClick(sheetObject, frow, 1);
            }
            break;
        case "btng_controlCancel":
            cancelControlOption(sheetObject);
            break;
    }
}

function getVVD() {}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    optionSetting();
    for (i = 0; i < sheetObjects.length; i++) {
        // change the name of start environment setting funtion
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        // Adding last environment setting funtion
        ComEndConfigSheet(sheetObjects[i]);
    }

    setColHiddenSheet1();
    setColHiddenSheet2();

    enableButtons(false);
    document.form.year.focus();
    var formObject = document.form;
    //comObjects[0].SetEnable(0);
    if (document.getElementById("trade").SetEnable == 0) document.getElementById("trade").tabIndex(1);
    if (document.getElementById("subtrade").SetEnable == 0) document.getElementById("subtrade").tabIndex(1);
    var sheetResizeFull = true;
    document_onresize();
    divChkMT.style.display="none";
}

function setColHiddenSheet1() {
    sheet1.RenderSheet(0);
    sheet1.SetColHidden("dataSeq", 1);
    sheet1.RenderSheet(1);
}

function setColHiddenSheet2() {
    sheet2.RenderSheet(0);
    for (var j = 0; j < sizeColName[colSizeIdx[finalIdx]].length + 1; j++) {
        sheet2.SetColHidden(preColName[finalIdx] + sizeColName[colSizeIdx[finalIdx]][j], 1);
    }
    for (var k = 0; k < sizeColName[colSizeIdx[modelIdx]].length + 1; k++) {
        sheet2.SetColHidden(preColName[modelIdx] + sizeColName[colSizeIdx[modelIdx]][k], 1);
    }
    for (var m = 0; m < sizeColName[colSizeIdx[bkgFirmIdx]].length + 1; m++) {
        sheet2.SetColHidden(preColName[bkgFirmIdx] + sizeColName[colSizeIdx[bkgFirmIdx]][m], 1);
    }
    for (var n = 0; n < sizeColName[colSizeIdx[guarIdx]].length + 1; n++) {
        sheet2.SetColHidden(preColName[guarIdx] + sizeColName[colSizeIdx[guarIdx]][n], 1);
    }
    sheet2.RenderSheet(1);
}

function enableButtons(enable) {
    if (enable) {
        ComBtnEnable("btng_controlEdit");
        ComBtnEnable("btng_bottleneck");
        ComBtnEnable("btng_skd");
        ComBtnEnable("btng_bsa");
    } else {
        ComBtnDisable("btng_controlEdit");
        ComBtnDisable("btng_bottleneck");
        ComBtnDisable("btng_skd");
        ComBtnDisable("btng_bsa");
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		with(sheetObj){
			var backColor="#555555";
			var Head1 = "SEQ|Rep.\nTrade|Rep.\nSub\nTrade|Lane|BD|Week|VVD|";
			var HeadTitle0 = Head1+"BSA|BSA|Loadable|Loadable|Loadable|Loadable|Loadable|Load|Load|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|F'CAST|L/F\n(%)|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|BKG|BKG|BKG|BKG|BKG|BKG|Un\nAllocated\nSpace";
			var HeadTitle1 = Head1+"VOL|WGT|VOL|WGT|HC|45|RF|QTA|QTA|OCN|OCN|IPC|IPC|T/S|T/S|L/F\n(%)|OCN|OCN|IPC|IPC|T/S|T/S|OCN|OCN|IPC|IPC|T/S|T/S|Un\nAllocated\nSpace";
			var HeadTitle2 = Head1+"VOL|WGT|VOL|WGT|HC|45|RF|OCN|IPC|VOL|WGT|VOL|WGT|VOL|WGT|L/F\n(%)|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|Un\nAllocated\nSpace| v |v|d|vol|port|hc|45|53'|rf|wgt|flag|status|mty|seq";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ 
			{Type:"Seq",   	Hidden:0,		Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"SEQ",               	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:40,   	Align:"Center",  ColMerge:1,   SaveName:"TRADE",             KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0, 	Width:40,   	Align:"Center",  ColMerge:1,   SaveName:"STRADE",           	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:45,   	Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:55,   	Align:"Center",  ColMerge:1,   SaveName:"WEEK",              	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:90,   	Align:"Center",  ColMerge:1,   SaveName:"VVD",               	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:50,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:50,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"lod_vol",           	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"lod_wgt",           	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"lod_hc",            	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"lod_45",            	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"lod_rf",            	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Float",   Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ocn_vol",     	KeyField:0,   CalcLogic:"",   Format:"",     				PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ocn_wgt",    	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ipc_vol",     	KeyField:0,   CalcLogic:"",   Format:"",     				PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ipc_wgt",     	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ts_vol",      	KeyField:0,   CalcLogic:"",   Format:"Float",       	PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"alloc_ts_wgt",      	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:70,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",       			PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",      Hidden:0,  	Width:80,  	Align:"Right",   ColMerge:1,   SaveName:"unallocated",       	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_spc_flg",      	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },			
			
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_lvl_cd",       	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_40ft_hc_flg",  	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_45ft_hc_flg",  	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_53ft_flg",     	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_rf_flg",       	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ctrl_wgt_flg",      	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"flag",              	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Status",  Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag",            	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:1, 	Width:40,   	Align:"Right",   ColMerge:1,   SaveName:"mty",               	KeyField:0,   CalcLogic:"",   Format:"Integer",     	PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Seq",     Hidden:1, 	Width:20,   	Align:"Center",  ColMerge:1,   SaveName:"dataSeq",           	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_lvl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_40ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_45ft_hc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_53ft_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_rf_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_wgt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"flag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Status",    Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"mty",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			//{Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dataSeq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",    Hidden:0,  	Width:1,    	Align:"Right",   ColMerge:1,   SaveName:"",                  	KeyField:0,   CalcLogic:"",   Format:"",            		PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
			];
			
			InitColumns(cols);
			//SetRangeBackColor(1,  7, 2, 13,backColor);
			//SetRangeBackColor(2, 14, 2, 15,backColor);
			//SetRangeBackColor(1, 16, 2, 28,backColor);
			SetHeaderRowHeight(8);
			SetEditable(0);
			SetFocusEditMode(default_edit_mode);
			SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
		}
		break;
		
		case 2:      //sheet2 init
		with(sheetObj){
			var backColor="#555555";
			var HeadTitle0=HeadMaster1;
			var HeadTitle1=HeadMaster2;
			var HeadTitle2=HeadMaster2;
			HeadTitle0=HeadTitle0 + "|Forecast";
			HeadTitle1=HeadTitle1 + "|Volume";
			HeadTitle2=HeadTitle2 + "|Total TEU";
			
			for(var k=0 ; k < txtHeadItem.length ; k++){
				var colNames=sizeColName[colSizeIdx[k]];
				
				for(var i=0 ; i < colNames.length ; i++){
					HeadTitle0=HeadTitle0 + txtDelem + txtHeadItem[k];
					ColumnCnt=ColumnCnt + 1;
				}
				
				HeadTitle1=HeadTitle1 + txtDelem + HeadVolume[colSizeIdx[k]];
				
				if(k == 3){
					HeadTitle2=HeadTitle2 + txtDelem + "Total TEU|HC|45'|53'|Reefer|WT\n(M/T)";
				} else {
					HeadTitle2=HeadTitle2 + txtDelem + HeadTypeSize[colSizeIdx[k]];
				}	
			}
			
			HeadTitle0=HeadTitle0 + HeadTail;
			HeadTitle1=HeadTitle1 + HeadTail;
			HeadTitle2=HeadTitle2 + HeadTail+"|flg|status|rhq|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|child|leaf|pol|lvl|ts|trd|sub_trd|Remark|Remark|Remark";
			
			//SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			//SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:20, PrevColumnMergeMode:0 } );
			//var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			//var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			//InitHeaders(headers, info);		
			
//			SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:20, PrevColumnMergeMode:0 } );
			SetConfig( { SearchMode:2, MergeSheet:5 , DataRowMerge:0, Page:10 } );							//20160118.MOD
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var colTypeIdx=new Array(0, 0, 0, 0, 1, 1, 0, 0);
			var sizeColType=new Array( new Array("Float", "Integer", "Integer", "Integer", "Integer", "Integer"),
			new Array("Float", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer", "Integer"),
			new Array("Float"  , "Float"  , "Float"  , "Float"  , "Float"  , "Integer"));
			
			var cols = [ 
			//20160118.ADD
			{Type:"Text",    Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d_ioc_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"d_sls_area_cd",               	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"d_sls_ofc_cd",               	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"d_pol_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"d_pod_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sls_area_cd",               	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sls_ofc_cd",               	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:42,   Align:"Center",  ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Int",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Int",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"Integer",    	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",        	KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			for(var j=0 ; j < txtHeadItem.length ; j++){
				var colNames=sizeColName[colSizeIdx[j]];
				var colTypes=sizeColType[colTypeIdx[j]];
				for(var m=0 ; m < colNames.length ; m++){//1
					if(controlCols[j]){
						if(j==alocIdx){
							if(m==0){
								cols.push({Type:"Float",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
							}else{	
								cols.push({Type:"Int",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
							}
						}else{
							if(m==0 && j!=fcastIdx){
								cols.push({Type:"Text",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
							}else{       		            				
								cols.push({Type:"Int",  Hidden:0, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
							}
						}    		            		    
					}else{
						if(j==alocIdx){
							if(m==0){
								cols.push({Type:"Float",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
							}else{    		            				
								cols.push({Type:"Int",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
							}
						}else{
							if(m==0 && j!=fcastIdx){
								cols.push({Type:"Text",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
							}else{    		            				
								cols.push({Type:"Int",  Hidden:1, Width:defaultWidth ,Align:"Right",   ColMerge:0,   SaveName:preColName[j]+colNames[m],   KeyField:0,   CalcLogic:"",   Format:colTypes[m],            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
							}
						}
					} //if end
				} //for end
			} //for end 
			
			cols.push({Type:"Text",      Hidden:1, 	Width:25,   	Align:"Center",  ColMerge:0,   SaveName:"mode",                      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Status",    Hidden:1, 	Width:20,   	Align:"Center",  ColMerge:0,   SaveName:"ibflag",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1,	Width:45,   	Align:"Center",  ColMerge:0,   SaveName:"sls_rhq_cd",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",                  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"dir_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",               	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"ts_flg",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"mnl_flg",                   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"spc_ctrl_ofc_cd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"lvl1",                      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"lvl2",                      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"child_cnt",                 	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"leaf_cnt",                  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"pol_cnt",                   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"lvl",                       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1});
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"tsedit",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"trd_cd",                    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:40,   	Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",                	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:0,  Width:100, 		Align:"Left",    ColMerge:0,   SaveName:"spc_ctrl_aloc_rmk",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:0,  Width:100,  	Align:"Left",    ColMerge:0,   SaveName:"spc_ctrl_aloc_pol_rmk",   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:0,  Width:100,  	Align:"Left",    ColMerge:0,   SaveName:"spc_ctrl_aloc_pod_rmk",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:1, 	Width:20,   	Align:"Center",  ColMerge:0,   SaveName:"mode_rmk",                		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
			cols.push({Type:"Text",      Hidden:0,  Width:1,    	Align:"Right",   ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			
			InitColumns(cols);
			
			for(var i=0 ; i < sizeColName[colSizeIdx[alocIdx]].length + 1 ; i++){
				SetMinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][i],0);
				SetMaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][i],100000);
			}
			
			SetEditable(1);
			//SetEditableColorDiff(1);
			//SetEditableColor("#FFFF80FFFFNAN");
			//SetEditableColor("##FFE400");
			//SetRangeBackColor(1, MasterCnt - 1, 2, ColumnCnt - TailCnt - 1,backColor);
			//SetImageList(0,"img/nolines_plus.gif");
			//SetImageList(1,"img/nolines_minus.gif");
			//SetCellImage(0, "pol_cd",0);
			//SetCellImage(0, "pod_cd",0);
			SetHeaderRowHeight(8);
			SetClipPasteMode(1);
			//SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
			resizeSheet();
			SetFocusEditMode(default_edit_mode);
		}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, code, msg) {
    var formObj = document.form;
    fcastType = formObj.fcast.value;

    var cnt = sheetObj.RowCount();
    var cnt = cnt + 3;

    for (var i = 3; i < cnt; i++) {
        var lod_vol = sheetObj.GetCellValue(i, "lod_vol") * 1;
        var alloc_ipc_vol = sheetObj.GetCellValue(i, "alloc_ipc_vol") * 1;
        var alloc_ts_vol = sheetObj.GetCellValue(i, "alloc_ts_vol") * 1;
        var alloc_ocn_vol = sheetObj.GetCellValue(i, "alloc_ocn_vol") * 1;
        var val = "";
        if (sheetObj.GetCellValue(i, "TRADE").substring(0, 1) == "I") {

            val = lod_vol - alloc_ipc_vol - alloc_ts_vol;

        } else {
            val = lod_vol - alloc_ocn_vol;
        }
        sheetObj.SetCellValue(i, "unallocated", val, 0);
    }
    hiddenMasterCols(sheetObj, formObj, "INIT");
    //Retrieving the bottom data instantly in case numbers of retrieved data counting is 1
    //2016.04.06.MOD performance issue 로 인해 해당 event 삭제
    //if (sheetObj.RowCount() == 1) {
    //    sheet1_OnDblClick(sheet1, sheet1.HeaderRows(), 1);
    //}

}

var rowInfo = "";
var rowArr = "";
var rows = "";
var rowCnt = "";

// Handling the process related with sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheet1.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve

            //sheet1.LoadSearchData("<SHEET><DATA TOTAL=\'3\'><TR>	<TD></TD>	<TD>TPS</TD>	<TD>PS</TD>	<TD>CAXTP</TD>	<TD>E</TD>	<TD>201415</TD>	<TD>NTV30001E</TD>	<TD>400</TD>	<TD>5000</TD>	<TD>350</TD>	<TD>5000</TD>	<TD>0</TD>	<TD>10</TD>	<TD>20</TD>	<TD></TD>	<TD></TD>	<TD>546</TD>	<TD>30</TD>	<TD></TD>	<TD></TD>	<TD>4</TD>	<TD>0</TD>	<TD><![CDATA[136.5%]]></TD>	<TD>180</TD>	<TD>2960</TD>	<TD>20</TD>	<TD>0</TD>	<TD>7</TD>	<TD>0</TD>	<TD>3256.1</TD>	<TD>23612.315</TD>	<TD>64</TD>	<TD>149.6</TD>	<TD></TD>	<TD></TD>	<TD CALCU-LOGIC=\"|lod_vol|-|alloc_ocn_vol||\"></TD>	<TD>NTV3</TD>	<TD>0001</TD>	<TD>E</TD>	<TD>N</TD>	<TD>D</TD>	<TD>Y</TD>	<TD>Y</TD>	<TD>Y</TD>	<TD>Y</TD>	<TD>Y</TD>	<TD>R</TD>	<TD></TD>	<TD></TD></TR></DATA></SHEET>");
            //return;

            if (!validateForm(sheet1, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST01;
            //sheet1.RemoveAll();
            //sheetObj.Reset();
            //sheetObjects[1].RemoveAll();
            formObj.chkTS.checked = true;
            var param = SpcFormString(formObj, "f_cmd,year,week,duration,vvd,fcast,trade,subtrade,lane,bound,office");
            sheet1.DoSearch("ESM_SPC_0042GS.do", param);
            break;
        case IBSAVE: //save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = MULTI;

            //no support[check again]CLT var rows=sheetObj.GetTransColText("U", "mode");

            var statusrow = sheetObj.FindStatusRow("U");
            var statusrowArr = statusrow.split(";");
            var statusrowCnt = statusrowArr.length;
            rowInfo = "";
            rowArr = "";
            rows = "";
            rowCnt = "";
            for (var i = 0; i < statusrowCnt; i++) {
                rows = rows + statusrowArr[i] + "=" + sheetObj.GetCellValue(statusrowArr[i], "mode") + ";";
            }
            rowArr = rows.split(";");
            rowCnt = rowArr.length;
            var chekport = formObj.chkPort.value;
            for (var i = 0; i < rowCnt; i++) {
                rowInfo = rowArr[i].split("=");
                if (sheetObj.GetCellValue(rowInfo[0] * 1, "lvl") * 1 < 3) {
                    //                    		sheetObj.SetRowStatus(rowInfo[0]*1,"I", 0);
                    sheetObj.SetCellValue(rowInfo[0] * 1, "ibflag", "I", 0);
                } else if (rowInfo[1] == "I") {
                    //                    		sheetObj.SetRowStatus(rowInfo[0]*1,"I", 0);
                    sheetObj.SetCellValue(rowInfo[0] * 1, "ibflag", "I", 0);
                }
                if (chekport == "O" && sheet1.GetCellValue(i, "mode_rmk") == 'UPD') {
                    if (sheetObj.GetCellValue(i, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(i, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(i, "ioc_cd") == 'T/S')) {
                        sheetObj.SetCellValue(i, "spc_ctrl_aloc_rmk", "", 0);
                    }
                }
                if (chekport == "L" && sheetObj.GetCellValue(i, "mode_rmk") == 'UPD') {
                    if (sheetObj.GetCellValue(i, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(i, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(i, "ioc_cd") == 'T/S')) {
                        sheetObj.SetCellValue(i, "spc_ctrl_aloc_pol_rmk", "");
                    }
                }
            }
            var param = SpcFormString(formObj, "f_cmd");
            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0042GS.do", param);

            break;
        case IBCOPYROW: // Row copy
            ComOpenWaitCallFunc("copyModelDataToAlloc()", true);
            break;
        case IBDOWNEXCEL: //Excel download
            sheetObj.Down2Excel({ DownRows:"Visible", DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9 });
            break;
    }
}

/*
 * calling after saving
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
        //        		ComShowMessage("saved successfully.");
        ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	

        for (var i = 0; i < rowCnt; i++) {
            rowInfo = rowArr[i].split("=");
            if (rowInfo[1] == "I") {
                sheetObj.SetCellValue(rowInfo[0] * 1, "mode", "R", 0);
                sheetObj.SetCellValue(rowInfo[0] * 1, "ibflag", "R", 0);
            }
        }
        var cnt = sizeColName[colSizeIdx[alocIdx]].length - 1;
        var frow = sheetObjects[0].FindText("dataSeq", String(sheet1_SelectedRow));
        var sumArr = getSum(sheetObj, ":OCN:T-OCN:", preColName[alocIdx]);
        sheet1.SetCellValue(frow, "alloc_ocn_vol", sumArr[0], 0);
        sheet1.SetCellValue(frow, "alloc_ocn_wgt", sumArr[cnt], 0);
        var sumArr = getSum(sheetObj, ":IPC:T-IPC:", preColName[alocIdx]);
        sheet1.SetCellValue(frow, "alloc_ipc_vol", sumArr[0], 0);
        sheet1.SetCellValue(frow, "alloc_ipc_wgt", sumArr[cnt], 0);
        sheet1.SetCellValue(frow, "ibflag", "R", 0);
        var trow = 0;
        for (var r = 0; r < Flags.length; r++) {
            trow = totalRows[Flags[r]];
            if (trow == undefined) {
                continue;
            }
            setTotalRowColor(sheetObj, trow);
        }

        // 상단 데이타 바꾸고 재조회
        sheet1_OnDblClick(sheetObj, sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow + ""), 1);

    } else if (sheetObj.GetEtcData("status") != "OK") {
        ComShowMessage(errMsg);
    }
}

function copyModelDataToAlloc() {
    var sheetObj = sheetObjects[1];
    var rowCnt = sheetObj.RowCount();
    var cols = TypeSizeCnt + 1;
    var vals = new Array(new Array(), new Array());
    var frow = -1;
    var sRow = sheetObj.HeaderRows();
    var eRow = sRow + rowCnt - 1;
    frow = sheetObj.FindText("ioc_cd", "T-", 0, 0);
    if (frow >= 0) {
        eRow = frow - 1;
    }
    frow = -1;
    var sCols = "";
    var eCols1 = "";
    var eCols2 = "";
    for (var c = 0; c < cols; c++) {
        sCols += "|" + preColName[modelIdx] + sizeColName[c];
        eCols1 += "|base" + sizeColName[c];
        eCols2 += "|" + preColName[alocIdx] + sizeColName[c];
    }
    sCols = sCols.substring(1);
    eCols1 = eCols1.substring(1);
    eCols2 = eCols2.substring(1);
    copyData(sheetObj, sRow, eRow, sCols, eCols1, false);
    copyData(sheetObj, sRow, eRow, sCols, eCols2, false);
    for (var r = sRow; r <= eRow; r++) {
        setWarnColorTEU(sheetObj, r, preColName[alocIdx], preColName[guarIdx]);
    }
    frow = -1;
    while ((frow = sheetObj.FindText("", "0", frow + 1)) > 0) {
        setTotalRowColor(sheetObj, frow);
    }
}

var selectedCell_OldValue = 0;

function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col) {
    selectedCell_OldValue = sheetObj.GetCellValue(row, col) * 1;
}

function sheet2_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    var idx = colName.indexOf("_");
    var pre = colName.substring(0, idx);
    var sizeName = colName.substring(idx);
    var orgValue = 0;
    value = value * 1;
    var level = sheetObj.GetCellValue(row, "lvl") * 1;
    if (pre == preColName[alocIdx]) {
        orgValue = sheetObj.GetCellValue(row, preColName[baseIdx] + sizeName) * 1;
        if (level == 1) {
            allocateByOffice(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
        } else if (level == 2) {
            oldValue = selectedCell_OldValue;
            allocateByPol(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
            if (sheetObj.GetCellEditable(row, col)) {
                var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldValue);
                setWarnColorTEU(sheetObj, rtn[0], sizeName);
            }
        } else if (level == 3) {
            if (sheetObj.GetCellEditable(row, col)) {
                var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, selectedCell_OldValue);
                setWarnColorTEU(sheetObj, rtn[0], sizeName);
                setWarnColorTEU(sheetObj, rtn[1], sizeName);
            }
            var ioc_cd = sheetObj.GetCellValue(row, "ioc_cd");
            changeTotalValue(sheetObj, ioc_cd, col, pre, value, selectedCell_OldValue);
            setWarnColorTEU(sheetObj, totalRows[ioc_cd], sizeName);
        }
        setWarnColorTEU(sheetObj, row, sizeName);
    }
    selectedCell_OldValue = value;
    var formObj = document.form;
    var chekport = formObj.chkPort.value;
    var ioc_cd = sheetObj.GetCellValue(row, "ioc_cd");
    var ibflag = sheetObj.GetCellValue(row, "ibflag");
    if (chekport == "O") {
        if (sheetObj.GetCellValue(row, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(row, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(row, "ioc_cd") == 'T/S')) {
            sheetObj.SetCellValue(row, "spc_ctrl_aloc_pod_rmk", sheetObj.GetCellValue(row, "spc_ctrl_aloc_rmk"), 0);
            sheetObj.SetCellValue(row, "mode_rmk", "UPD", 0);
        }
    }
    if (chekport == "L") {
        if (sheetObj.GetCellValue(row, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(row, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(row, "ioc_cd") == 'T/S')) {
            sheetObj.SetCellValue(row, "spc_ctrl_aloc_pod_rmk", sheetObj.GetCellValue(row, "spc_ctrl_aloc_pol_rmk"), 0);
            sheetObj.SetCellValue(row, "mode_rmk", "UPD", 0);
        }
    }
    if (chekport == "D") {
        if (sheetObj.GetCellValue(row, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(row, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(row, "ioc_cd") == 'T/S')) {
            sheetObj.SetCellValue(row, "mode_rmk", "UPD", 0);
        }
    }
}

function sheet2_OnClick(sheetObj, row, col) {
	
	var csName = sheetObj.ColSaveName(col);
    switch (csName) {
        case "d_pol_cd":																						//20160118.MOD
        case "d_pod_cd":
            var chkpod = document.form.chkPod.checked;
            var mark = sheetObj.GetCellValue(row, col);
            var status = sheetObj.GetRowStatus(row);
            if (mark == "+") {
                var startRow = row + 1;
//                var endRow = sheetObj.GetMergedEndCell(row, col - 1).split(",")[0];
                var endRow = sheetObj.FindText("lvl",(csName == "d_pol_cd") ? "1" : "2" ,startRow,-1,1);		//20160118.MOD
                if(endRow==-1) endRow = sheetObj.LastRow();														//20160118.ADD
                for (; startRow <= endRow-1; startRow++) {														//20160118.MOD : endRow-1
                	sheetObj.SetRowHidden(startRow, 0);
                	// data selection에서 pod가 선택되지 않은 경우 pol로 열고 닫을 때 풀림 현상 막음 : 20160120.MOD
                	if (sheetObj.ColSaveName(col) == "d_pol_cd" && (sheetObj.GetCellValue(startRow, "d_pod_cd") == '+' || !chkpod)) {
                        startRow = sheetObj.FindText("lvl", "2" ,startRow+1,-1,1);
                        if(startRow==-1) startRow = sheetObj.LastRow();											//20160118.ADD
                        startRow = startRow-1;
                    }
                }
                sheetObj.SetCellValue(row, col, "-", 0);
                sheetObj.SetCellValue(row, "ibflag", status, 0);
            } else if (mark == "-") {
                var startRow = row + 1;
//              var endRow = sheetObj.GetMergedEndCell(row, col - 1).split(",")[0];
                var endRow = sheetObj.FindText("lvl",(csName == "d_pol_cd") ? "1" : "2" ,startRow,-1,1);		//20160118.MOD
                if(endRow==-1) endRow = sheetObj.LastRow();														//20160118.ADD
                for (; startRow <= endRow-1; startRow++) {														//20160118.MOD
                	if(sheetObj.GetCellValue(startRow, "lvl") > 0){												//20160118.ADD
                		sheetObj.SetRowHidden(startRow, 1);
                	}
                }
                sheetObj.SetCellValue(row, col, "+", 0);
                sheetObj.SetCellValue(row, "ibflag", status, 0);
            }
//            sheetObj.SetDataMerge();																			//20160118.MOD
            break;
    }
}

function sheet1_OnDblClick(sheetObj, row, col) {
    if (sheetObj.GetCellValue(row, "flag") != "R" && sheetObj.GetCellValue(row, "ctrl_40ft_hc_flg") == "N" && sheetObj.GetCellValue(row, "ctrl_45ft_hc_flg") == "N" && sheetObj.GetCellValue(row, "ctrl_53ft_flg") == "N" && sheetObj.GetCellValue(row, "ctrl_rf_flg") == "N" && sheetObj.GetCellValue(row, "ctrl_wgt_flg") == "N") {

        sheetObj.SetCellValue(row, "ibflag", "I", 0);
        sheetObj.SetCellValue(row, "ctrl_40ft_hc_flg", "Y");
        sheetObj.SetCellValue(row, "ctrl_45ft_hc_flg", "Y");
        sheetObj.SetCellValue(row, "ctrl_53ft_flg", "N");
        sheetObj.SetCellValue(row, "ctrl_rf_flg", "Y");
        sheetObj.SetCellValue(row, "ctrl_wgt_flg", "Y");

        var SaveStr = sheetObj.GetSaveString();
        var sXml = sheetObj.GetSaveData("ESM_SPC_0042GS.do", "f_cmd=" + MULTI01 + "&" + SaveStr);
        var rtn = ComGetSelectSingleNode(sXml, "TR-ALL");
        if (rtn || rtn == "OK") {
            sheetObj.SetCellValue(row, "flag", "R");
        }
    }

    var formObj = document.form;
    //sheetObj1.SetEnable(0);
    sheet2.RemoveAll();
    //    		sheetObjects[0] = sheetObjects[0].Reset();
    //sheetObj1.Reset();
    // Changing  cancel status in case of control option is on edit status
    cancelControlOption(sheet1);
    setLod_volValue(sheet1.GetCellValue(row, "lod_vol"));
    // setting selected current row of the top sheet
    setSelectetRow(sheet1, row);
    // creating searching condition to search the bottom sheet
    var param = makeDetailParam(sheet1, row);
    param = param + "&fcast=" + fcastType;
    param = param + "&office=" + comObjects[3].GetSelectCode();
    //sheetObj1.DoSearch("ESM_SPC_0042GS2.do", param );
    var sXml = sheet2.GetSearchData("ESM_SPC_0042GS2.do", param);
    sheet2.LoadSearchData(sXml, { Sync: 1 });
    setVVDValue(sheet1.GetCellValue(row, "VVD"));
    setWeekValue(sheet1.GetCellValue(row, "WEEK"));
    setLod_volValue(sheet1.GetCellValue(row, "lod_vol"));
    // Checking control option according to the result of searching
    checkControlOption();
    // Checking check box related with IOC division of data selection item
    checkSelectionOption(sheet2);
    divChkMT.style.display="none";
    // Displaying selected OCN/IPC of the top sheet according to trade kind
    hiddenMasterCols(sheet1, formObj, sheet1.GetCellValue(row, "TRADE").substring(0, 1));
    // displaying the column by item Type/Size of syncTarget according to control option

    //RenderSheet이동 hiddenSelectionField(CoSpc.js)에 별도로 RenderSheet사용
    hiddenSelectionField(sheet2);
    // Handling row hidden according to data selection
    controlRowFilter(sheet2);

    sheet2.RenderSheet(0);
    checkPortcontrolTree(sheet2);
    sheet2.RenderSheet(1);
    // displaying model performance time on header
    var model_dt = txtHeadItem[modelIdx];
    var colNames = sizeColName[colSizeIdx[modelIdx]];
    var cnt = colNames.length;
    var color = sheet2.GetCellBackColor(0, preColName[modelIdx] + colNames[0]);
    for (var i = 0; i < cnt; i++) {
        sheet2.SetCellText(0, preColName[modelIdx] + colNames[i], model_dt);
    }
    enableButtons(true);
    //sheetObj1.SetEnable(1);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        switch (sAction) {
            case IBSEARCH: //Retrieve
                if (comObjects[0].GetEnable() && formObj.vvd.value == "" && comObjects[0].GetSelectCode() == "") {
                    ComShowMessage(getMsg("SPC90114", "Trade"));
                    comObjects[0].focus();
                    return false;
                }
                if (formObj.vvd.value == "" && comObjects[1].GetSelectCode() == "") {
                    ComShowMessage(getMsg("SPC90114", "SubTrade"));
                    formObj.year.focus();
                    //comObjects[1].focus();
                    return false;
                }
                if (formObj.vvd.value != "" && formObj.vvd.value.length < 9) {
                    ComShowCodeMessage("COM12174", "VVD", "9");
                    formObj.vvd.focus();
                    return false;
                }
                if (comObjects[3].GetSelectCode() == "") {
                    ComShowMessage(getMsg("SPC90114", "ORG"));
                    //comObjects[3].focus();
                    return false;
                }
                break;
            case IBSAVE: //save
                var frow = sheetObjects[0].FindText("dataSeq", String(sheet1_SelectedRow));
                if (frow <= 0) {
                    return false;
                }
                var models = new Array(
                    sheetObjects[0].GetCellValue(frow, "lod_vol") * 1 - sheetObjects[0].GetCellValue(frow, "mty") * 1,
                    sheetObjects[0].GetCellValue(frow, "lod_hc") * 1,
                    sheetObjects[0].GetCellValue(frow, "lod_45") * 1,
                    sheetObjects[0].GetCellValue(frow, "lod_53") * 1,
                    sheetObjects[0].GetCellValue(frow, "lod_rf") * 1,
                    sheetObjects[0].GetCellValue(frow, "lod_wgt") * 1
                );
                var rtn = validAllocationLoadable(sheetObj, formObj, ":OCN:T-OCN:", models, false);
                if (rtn >= 0) {
                    return false;
                }
                return true;
                break;
            case IBINSERT: // Insert
                break;
            case IBCOPYROW: // Row copy
                break;
            case IBDOWNEXCEL: //Excel download
                break;
            case IBLOADEXCEL: // Excel upload
                break;
        }
    }
    return true;
}

function trade_OnChange(comObj, value, text) {
    if (value == "") return;
    // sub_trade initialization
    comObjects[1].SetSelectIndex(0, false);
    // lane initialization
    comObjects[2].SetSelectIndex(0, false);

    var formObj = document.form;
    var trade = formObj.trade.value;

    if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subtrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}

function checkPortcontrolTree(sheetObj) {
    var formObj = document.form;
    var sts1 = formObj.chkOfc.checked;
    var sts2 = formObj.chkPol.checked;
    var sts3 = formObj.chkPod.checked;
    if ((sts1 == true) && (sts2 == true) && (sts3 == true)) {
        sheetObj.SetColHidden("spc_ctrl_aloc_rmk", 1);
        sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk", 1);
        sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk", 0);
    }
    if ((sts1 == true) && (sts2 == false) && (sts3 == false)) {
        sheetObj.SetColHidden("spc_ctrl_aloc_rmk", 0);
        sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk", 1);
        sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk", 1);
        for (var idx = 0; idx <= sheetObj.RowCount(); idx++) {
            if (sheetObj.GetCellValue(idx, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(idx, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(idx, "ioc_cd") == 'T/S')) {
                sheetObj.SetCellValue(idx, "spc_ctrl_aloc_rmk", sheetObj.GetCellValue(idx, "spc_ctrl_aloc_pod_rmk"), 0);
                // T/S, IPC인 경우 전체 Editalble되는 bug 발생 막음.
                //        	    		sheetObj.SetCellValue(idx, "ibflag", "", 0);

            }
        }
    }
    if ((sts1 == true) && (sts2 == true) && (sts3 == false)) {
        sheetObj.SetColHidden("spc_ctrl_aloc_pol_rmk", 0);
        sheetObj.SetColHidden("spc_ctrl_aloc_rmk", 1);
        sheetObj.SetColHidden("spc_ctrl_aloc_pod_rmk", 1);
        for (var idx = 0; idx <= sheetObj.RowCount(); idx++) {
            if (sheetObj.GetCellValue(idx, "sub_trd_cd") != 'IA' && (sheetObj.GetCellValue(idx, "ioc_cd") == 'IPC' || sheetObj.GetCellValue(idx, "ioc_cd") == 'T/S')) {
                sheetObj.SetCellValue(idx, "spc_ctrl_aloc_pol_rmk", sheetObj.GetCellValue(idx, "spc_ctrl_aloc_pod_rmk"), 0);
                // T/S, IPC인 경우 전체 Editalble되는 bug 발생 막음.
                //              			sheetObj.SetCellValue(idx, "ibflag", "", 0);
            }
        }
    }
}

function subtrade_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;
    //comObjects[0].SetSelectCode(comObj.GetText(newCode, 0), false);
    // lane initialization
    comObjects[2].SetSelectIndex(0, false);

    var formObj = document.form;
    var subtrade = formObj.subtrade.value;

    if (subtrade != null && subtrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subtrade.value, true); // 0207 SHKIM
    }
}

function lane_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;
    var repTrade = comObj.GetText(newCode, 0);
    var subTrade = comObj.GetText(newCode, 1);
    //comObjects[0].SetSelectCode(repTrade,false);
    //comObjects[1].SetSelectCode(subTrade,false);
}

function setVVDValue(vvd) {
    document.getElementById("idTxtVVD").value = vvd;
}

function setWeekValue(WEEK) {
    document.getElementById("idTxtWeek").value = WEEK;
}

function setLod_volValue(lod_vol) {
    var formObj = document.form;
    formObj.fm_load.value = lod_vol;
    /*
     *  ComChkObjValid => CoFormControl.js)
     */
    ComChkObjValid(formObj.fm_load);
}

// Displaying selected OCN/IPC of the top sheet according to trade kind
function hiddenMasterCols(sheetObj, formObj, trade) {
    sheet1.RenderSheet(0);
    var checked = formObj.chkWT.checked || trade == "INIT";
    for (var i = 0; checked && i < weightCols.length; i++) {
        sheetObj.SetColHidden(weightCols[i], !checked);
    }
    checked = formObj.chkOCN.checked || trade == "INIT";
    for (var j = 0; j < ocnCols.length; j++) {
        sheetObj.SetColHidden(ocnCols[j], !checked);
    }
    checked = formObj.chkIPC.checked || trade == "INIT";
    for (var k = 0; k < ipcCols.length; k++) {
        sheetObj.SetColHidden(ipcCols[k], !checked);
    }
    // TS 관련 추가
    checked = formObj.chkTS.checked || trade == "INIT";
    for (var k = 0; k < ipcCols.length; k++) {
        sheetObj.SetColHidden(tsCols[k], !checked);
    }
    checked = formObj.chkWT.checked || trade == "INIT";
    for (var m = 0; !checked && m < weightCols.length; m++) {
        sheetObj.SetColHidden(weightCols[m], !checked);
    }
    sheet1.RenderSheet(1);
}

// Win7 End
function initDataValue_trade() {
    var sheetObj = document.getElementById("trade");
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_subtrade() {
    var sheetObj = document.getElementById("subtrade");
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_lane() {
    var sheetObj = document.getElementById("lane");
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_office() {
    var sheetObj = document.getElementById("office");
    with(sheetObj) {
        Index2 = 0;
    }
}

function optionSetting() {
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    SpcSearchOptionDuration("duration", 5, 5);
    SpcSearchOptionTrade("trade", true, true);
    SpcSearchOptionSubTrade("subtrade", true, true);
    SpcSearchOptionLane("lane");
    SpcSearchOptionBound("bound");
    if (document.form.ofc_cd.value == 'SINHO') {
        SpcSearchOptionRhq("office", "", "", "", false, true);
    } else {
        SpcSearchOptionRhq("office", "", "", "", true, true);
    }
}

/**
 * This method counts numbers again.
 * @param Col
 * @param SortArrow
 */
//2014.08.06 김용습 - 정렬시 SEQ. 무너지는 버그 해결하기 위해 추가한 메소드
function sheet1_OnSort(Col, SortArrow) {
    sheet1.ReNumberSeq();
}

/**
 * Editable cell 배경색 변경 부분
 * @param row
 * 2014.09.05 김성욱
 */
function sheet2_OnRowSearchEnd(row) {
// 2015-12-15 KHS : 화면 속도개선이유로 EsmSpc0042ViewAdapter2 에서 처리 하도록 변경  

    //var colNum = sheet2.GetLastChildRow(row); //해당 row의 column 갯수
//    //colNum = sheet2.GetChildNodeCount( row );
//    colNum = 90;
//    var rowNum = sheet2.RowCount(row);
//    rowNum += 3;
//    for (var x = 0; x < colNum; x++) {
//        var isEditable = sheet2.GetCellEditable(rowNum, x); //해당 셀이 수정 가능한지 //sheet2.GetColEditable( x ); //해당 컬럼이 수정 가능한지 
//        if (isEditable == 1) {
//            sheet2.SetCellBackColor(rowNum, x, "#FFFF00");
//        }
//    }
}

function sheet2_OnMouseMove(Button, Shift, X, Y) {
	//마우스 위치를 행과 컬럼과 값 가져오기
	var Row = sheet2.MouseRow();
	var Col = sheet2.MouseCol();
	var sValue = sheet2.GetCellValue(Row, Col);
	
	if(Col == 0 || Col == 1 || Col == 2) {		
		sheet2.SetToolTipText(Row, Col, sValue);
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[1]);
}