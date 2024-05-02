/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0246.js
 *@FileTitle : Detail(Bunker/Canal Fee)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends
 * @class VOP_VSK_0246 : business script for VOP_VSK_0246
 */
function VOP_VSK_0246() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// public variable
var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {

			case "btn_close":
				window.close();
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

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

}

function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// setting height
			style.height = 0;
			// setting width
			SheetWidth = mainTable.clientWidth;

			// setting Host information[mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// Merge kind [Default msNone]
			MergeSheet = msNone;

			// Edit kind [Default false]
			Editable = false;

			// setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "|lmt_tm_scg_rto|eta_speed|add_bunker_consum_qty|add_bunker_consum_amount|next_port_eta_speed|add_bunker_consum_02|add_bunker_amount_02|result|fm_port|to_port|reported_date|nxt_port_eta|remain_dist|remain_spd|wind_dir_scale|sea_dir_scale|supply_bunker_qty|supply_bunker_port|actual_bunker_price|remain_bunker|bunker_consum_by_eta|course_org|canal_tz_surchg_amt|suz_net_tong_wgt|next_port|cts_1st|cts_2nd|cts_3rd";
			var headCount = ComCountHeadTitle(HeadTitle);

			// setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// setting Header Mode
			InitHeadMode(false, false, false, false, false, false);

			// setting Header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			var prefix = "";

			// data property [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 75, daCenter, true,
			// "hdnStatus");
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,	prefix + "ibflag", 						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "lmt_tm_scg_rto",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "eta_speed",									false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "add_bunker_consum_qty",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "add_bunker_consum_amount",	false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "next_port_eta_speed",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "add_bunker_consum_02",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "add_bunker_amount_02",				false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "result",											false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "fm_port",										false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "to_port",										false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "reported_date",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "nxt_port_eta",								false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "remain_dist",								false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "remain_spd",								false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "wind_dir_scale",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "sea_dir_scale",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "supply_bunker_qty",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "supply_bunker_port",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "actual_bunker_price",					false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "remain_bunker",							false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "bunker_consum_by_eta",			false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "course_org",								false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "canal_tz_surchg_amt",				false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "suz_net_tong_wgt",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "next_port",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "cts_1st",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "cts_2nd",						false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, 	true, 	prefix + "cts_3rd",						false, "", dfNone, 0, true);
			
		}
		break;

	}
}

//handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
		case IBSEARCH: // Retrieve
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0246GS.do", sParam);
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	
	if(sheetObj.LastRow!=8){
		return false;
	}
	
	var formObj = document.form;
	with(formObj){
		
		var wgt = sheetObj.CellValue(1, "suz_net_tong_wgt");
		var group1 = false;
		
		// more than 70000 ton in North Bound, then it must belong to 1st group
		if(wgt>=70000 && bound.value=="North Bound"){
			group1 = true;
		}
		
		eta_speed_1.value = sheetObj.CellValue(1, "eta_speed");
		eta_speed_2.value = sheetObj.CellValue(2, "eta_speed");
		eta_speed_3.value = sheetObj.CellValue(3, "eta_speed");
		eta_speed_4.value = sheetObj.CellValue(4, "eta_speed");
		
		if(!group1){
			eta_speed_5.value = sheetObj.CellValue(5, "eta_speed");
			eta_speed_6.value = sheetObj.CellValue(6, "eta_speed");
			eta_speed_7.value = sheetObj.CellValue(7, "eta_speed");
			eta_speed_8.value = sheetObj.CellValue(8, "eta_speed");
		}
		
		add_bunker_consum_qty_1.value = sheetObj.CellValue(1, "add_bunker_consum_qty");
		add_bunker_consum_qty_2.value = sheetObj.CellValue(2, "add_bunker_consum_qty");
		add_bunker_consum_qty_3.value = sheetObj.CellValue(3, "add_bunker_consum_qty");
		add_bunker_consum_qty_4.value = sheetObj.CellValue(4, "add_bunker_consum_qty");
		
		if(!group1){
			add_bunker_consum_qty_5.value = sheetObj.CellValue(5, "add_bunker_consum_qty");
			add_bunker_consum_qty_6.value = sheetObj.CellValue(6, "add_bunker_consum_qty");
			add_bunker_consum_qty_7.value = sheetObj.CellValue(7, "add_bunker_consum_qty");
			add_bunker_consum_qty_8.value = sheetObj.CellValue(8, "add_bunker_consum_qty");
		}
		
		add_bunker_consum_amount_1.value = sheetObj.CellValue(1, "add_bunker_consum_amount");
		add_bunker_consum_amount_2.value = sheetObj.CellValue(2, "add_bunker_consum_amount");
		add_bunker_consum_amount_3.value = sheetObj.CellValue(3, "add_bunker_consum_amount");
		add_bunker_consum_amount_4.value = sheetObj.CellValue(4, "add_bunker_consum_amount");
		
		if(!group1){
			add_bunker_consum_amount_5.value = sheetObj.CellValue(5, "add_bunker_consum_amount");
			add_bunker_consum_amount_6.value = sheetObj.CellValue(6, "add_bunker_consum_amount");
			add_bunker_consum_amount_7.value = sheetObj.CellValue(7, "add_bunker_consum_amount");
			add_bunker_consum_amount_8.value = sheetObj.CellValue(8, "add_bunker_consum_amount");
		}
		
		next_port.value = sheetObj.CellValue(1, "next_port");
		
		if(next_port.value!="EGPSD"){
			next_port_eta_speed_1.value = sheetObj.CellValue(1, "next_port_eta_speed");
			if(!group1){
				next_port_eta_speed_2.value = sheetObj.CellValue(5, "next_port_eta_speed");	
			}
			
			add_bunker_consum_02_1.value = sheetObj.CellValue(1, "add_bunker_consum_02");
			if(!group1){
				add_bunker_consum_02_2.value = sheetObj.CellValue(5, "add_bunker_consum_02");
			}
			
			add_bunker_amount_02_1.value = sheetObj.CellValue(1, "add_bunker_amount_02");
			if(!group1){
				add_bunker_amount_02_2.value = sheetObj.CellValue(5, "add_bunker_amount_02");
			}
		}
		
		result_1.value = sheetObj.CellValue(1, "result");
		result_2.value = sheetObj.CellValue(2, "result");
		result_3.value = sheetObj.CellValue(3, "result");
		result_4.value = sheetObj.CellValue(4, "result");
		
		if(!group1){
			result_5.value = sheetObj.CellValue(5, "result");
			result_6.value = sheetObj.CellValue(6, "result");
			result_7.value = sheetObj.CellValue(7, "result");
			result_8.value = sheetObj.CellValue(8, "result");
		}
		
		reported_date.value = sheetObj.CellValue(1, "reported_date");
		nxt_port_eta.value = sheetObj.CellValue(1, "nxt_port_eta");
		remain_dist.value = sheetObj.CellValue(1, "remain_dist");
		remain_spd.value = sheetObj.CellValue(1, "remain_spd");
		wind_dir_scale.value = sheetObj.CellValue(1, "wind_dir_scale");
		sea_dir_scale.value = sheetObj.CellValue(1, "sea_dir_scale");
		supply_bunker_qty.value = sheetObj.CellValue(1, "supply_bunker_qty");
		supply_bunker_port.value = sheetObj.CellValue(1, "supply_bunker_port");
		actual_bunker_price.value = sheetObj.CellValue(1, "actual_bunker_price");
		remain_bunker.value = sheetObj.CellValue(1, "remain_bunker");
		bunker_consum_by_eta.value = sheetObj.CellValue(1, "bunker_consum_by_eta");
		course_org.value = sheetObj.CellValue(1, "course_org");
		
		cts_1st.value = sheetObj.CellValue(1, "cts_1st");
		cts_2nd.value = sheetObj.CellValue(1, "cts_2nd");
		cts_3rd.value = sheetObj.CellValue(1, "cts_3rd");
		
//		canal_tz_surchg_amt_1.value = sheetObj.CellValue(2, "canal_tz_surchg_amt");
//		canal_tz_surchg_amt_2.value = sheetObj.CellValue(3, "canal_tz_surchg_amt");
//		canal_tz_surchg_amt_3.value = sheetObj.CellValue(4, "canal_tz_surchg_amt");
		
//		canal_tz_surchg_amt_1.value = sheetObj.CellValue(1, "cts_1st");
//		canal_tz_surchg_amt_2.value = sheetObj.CellValue(1, "cts_2nd");
//		canal_tz_surchg_amt_3.value = sheetObj.CellValue(1, "cts_3rd");
		
	}
	
}
