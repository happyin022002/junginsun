/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0072.js
 *@FileTitle  : Block Stowage Code Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/22
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_new":
				formObject.reset();
				sheetObject1.RemoveAll();
				break;
			case "btn_downexcel":
				if (sheetObject1.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				}
				break;
			case "btn_port_code":
				selectPort(formObject);
				break;	
			case "btn_lane_code":
				selectLane(formObject);
				break;		
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'))
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'port_code', 'hub_code', 'lane_code', 'bs_code', 'dest');
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
		case "sheet1":
			with (sheetObj) {
				var HeadTitle1 = "|NO.|Port|Lane|Hub|BS Code|DEST";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [    
				            {Type:"Status",    Hidden:1, Width:0,     Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					        {Type:"Seq",       Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"port_code",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"lane_code",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"hub_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bs_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dest",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
		         		];
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
			}
			break;
	}
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			if(!validateForm(sheetObj, formObj, sAction)) return;
			
			ComOpenWait(true);
			setTimeout(function() {
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESD_PRD_0072GS.do", PrdFQString(formObj), { Sync : 2 });
				ComOpenWait(false);
			}, 100);
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
	}
}

/**
 * handling popup open
 */
function selectPort(fromObject) {
	var param = '?loc_cd=' + fromObject.port_code.value;
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 480, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
/**
 * handling after popup open
 */
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	document.form.port_code.value = cArray[3];
}

/**
 * 
 * @return
 */
function selectLane(fromObject) {
	var param = '?&lane_cd=' + fromObject.lane_code.value;
	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 400, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
/**
 * 
 * @return
 */
function getLane(rowArray) {
	var colArray = rowArray[0];
	document.form.lane_code.value = colArray[3];
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	var resultFlg = true;
	switch(sAction) {
		case IBSEARCH:
			resultFlg = ComChkValid(formObj);
			break;
	}
	return resultFlg;
}
