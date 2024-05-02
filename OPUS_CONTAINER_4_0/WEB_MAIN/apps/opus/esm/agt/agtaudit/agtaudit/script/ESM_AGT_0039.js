// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event 
document.onclick = processButtonClick;

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
	    //Changing Start Environment Setting Method's Name
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	    
	    //Adding Last Environment Setting method
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//Date Date Setting	
	var formObj = document.form;
	var today = ComGetNowInfo();
	var frday = ComGetDateAdd(null, "D", -14);
	formObj.search_dt_fr.value = frday;
	formObj.search_dt_to.value = today;
	formObj.ar_ofc_cd.focus();
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//setting height
				style.height = GetSheetHeight(16);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 1000);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(28, 4, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				var HeadTitle1 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|S/A Date|SEQ|BKG_STS|PRE AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
				var HeadTitle2 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|S/A Date|SEQ|BKG_STS|PRE AMT|Common1|Common2|BRKG|CHF|T/S|T/R|SOC|Cross|DOC|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//Data  properties  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtCheckBox,	40,		daCenter,   true,    	"check",    false,		"",			dfNone,		0,			true,		false);
				InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,   true,    	"seq",     	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,   true,    	"bl_no",     false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,   true,    	"bkg_no",    false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		30,		daCenter,   true,    	"io_bnd_cd", false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,   true,    	"vvd",     	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,   true,    	"sail_arr_dt",false,	"",			dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		35,		daCenter,   true,    	"ac_seq",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,   true,    	"bkg_sts_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,70,		daRight,    true,    	"pre_amt",   false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,65,		daRight,    false,    	"comm1",    false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,65,		daRight,    false,    	"comm2",    false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"brkg",     false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"chf",     	false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"ts",     	false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"tr",     	false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"soc",     	false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"cross",    false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,60,		daRight,    false,    	"doc",      false,		"",			dfFloat,	2,			true,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,80,		daRight,    true,    	"usd_amt",   false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		50,		daRight,    true,    	"ex_rate",   false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		40,		daCenter,   true,    	"curr_cd",   false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,80,		daRight,    true,    	"lcl_amt",   false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		45,		daCenter,   true,    	"comm_proc_sts_cd", false,	"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,		500,	daLeft,   	true,    	"comm_proc_sts_rsn", false,	"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,   true,    	"ar_ofc_cd",  false,	"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,   true,    	"agn_cd",   false,		"",			dfNone,		0,			false,		false);

				
                AllowEvent4CheckAll = false;
			}
			break;
	}
}

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
				
			case "btn_showdetail":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				break;

			case "btn_recalculate":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
				break;

			case "btn_save":
				doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;

			case "btn_reject":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC04);
				break;

			case "btn_audit":
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC03);
				break;

			case "btn_cancel":
				doActionIBSheet(sheetObj,formObj,IBCLEAR);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
				
			case "btn_cal_fr":
				var cal = new ComCalendar();
				 cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;

			case "btn_cal_to":
				var cal = new ComCalendar();
				 cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
				sheetObj.RemoveAll();
				break;
				
			case "check_apply":
				auditCnt_Check();
				break;
				
			case "uncheck_apply":
				auditCnt_Uncheck();
				break;
			
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111", "", "");
		} else {
			ComShowMessage(e);
		}
	}
}

/*
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0039GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.ColBackColor("comm_proc_sts_rsn") = sheetObj.RgbColor(255,255,255);

			//Showing the color according to the status
			//Showing Editable/UnEditable for each Amount
			var sts = formObj.sts_cd.value;
			var rows = sheetObj.RowCount;

			for (var i=0; i<rows; i++)
			{
				
				if(sheetObj.CellText(i+2,"comm_proc_sts_cd") == "RM")
				{
					sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(0,0,255); //blue
				}
				comm1 = sheetObj.CellText(i+2,"comm1");
				comm2 = sheetObj.CellText(i+2,"comm2");
				brkg  = sheetObj.CellText(i+2,"brkg");
				chf   = sheetObj.CellText(i+2,"chf");
				ts    = sheetObj.CellText(i+2,"ts");
				tr    = sheetObj.CellText(i+2,"tr");
				soc   = sheetObj.CellText(i+2,"soc");
				cross = sheetObj.CellText(i+2,"cross");
				doc   = sheetObj.CellText(i+2,"doc");
				
				
				if(sts == "1" || sts == "4" || sts == "5" )
				{
					//Request
					if(comm1 == 0)
					{
						sheetObj.CellFontColor(i+2,"comm1") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"comm1") = false;
					}
					if(comm2 == 0)
					{
						sheetObj.CellFontColor(i+2,"comm2") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"comm2") = false;
					}
					if(brkg == 0)
					{
						sheetObj.CellFontColor(i+2,"brkg") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"brkg") = false;
					}
					if(chf == 0)
					{
						sheetObj.CellFontColor(i+2,"chf") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"chf") = false;
					}
					if(ts == 0)
					{
						sheetObj.CellFontColor(i+2,"ts") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"ts") = false;
					}
					if(tr == 0)
					{
						sheetObj.CellFontColor(i+2,"tr") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"tr") = false;
					}
					if(soc == 0)
					{
						sheetObj.CellFontColor(i+2,"soc") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"soc") = false;
					}
					if(cross == 0)
					{
						sheetObj.CellFontColor(i+2,"cross") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"cross") = false;
					}
					if(doc == 0)
					{
						sheetObj.CellFontColor(i+2,"doc") = sheetObj.RgbColor(160,160,160);
						sheetObj.CellEditable(i+2,"doc") = false;
					}
				}else if(sts == "2"){

					sheetObj.CellFontColor(i+2,"comm1") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"comm1") = false;

					sheetObj.CellFontColor(i+2,"comm2") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"comm2") = false;

					sheetObj.CellFontColor(i+2,"brkg") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"brkg") = false;

					sheetObj.CellFontColor(i+2,"chf") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"chf") = false;

					sheetObj.CellFontColor(i+2,"ts") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"ts") = false;

					sheetObj.CellFontColor(i+2,"tr") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"tr") = false;

					sheetObj.CellFontColor(i+2,"soc") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"soc") = false;

					sheetObj.CellFontColor(i+2,"cross") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"cross") = false;

					sheetObj.CellFontColor(i+2,"doc") = sheetObj.RgbColor(160,160,160);
					sheetObj.CellEditable(i+2,"doc") = false;
				}else{
					sheetObj.RowEditable(i+2) = false;
				}

			}
			sheetObj.Redraw = true;

			break;
			
		case IBSEARCH_ASYNC01:	//Detail
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			row = sheetObj.SelectRow;
			
			var bl_no  = sheetObj.CellText(row,"bl_no");
			var bkg_no = sheetObj.CellText(row,"bkg_no");
			var agn_cd = sheetObj.CellText(row,"agn_cd");
			var io_bnd_cd = sheetObj.CellText(row,"io_bnd_cd");
			var seq   = sheetObj.CellText(row,"ac_seq");
			var arOfc = sheetObj.CellText(row,"ar_ofc_cd");
			var sailArrDt = sheetObj.CellValue(row,"sail_arr_dt").replace(/-/g, '');
			
			if(bkg_no == ""){
				ComShowCodeMessage("COM12113", "BKG No for detail information", "", "");
				break;
			}
			var param = "?bl_no=" + bl_no + "&bkg_no=" + bkg_no + "&agn_cd=" + agn_cd + "&io_bnd_cd=" + io_bnd_cd + "&ac_seq=" + seq + "&ar_ofc_cd=" + arOfc + "&sail_arr_dt=" + sailArrDt;
            //window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
            //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
			ComOpenWindowCenter("ESM_AGT_0011.do" + param, "compop1", "800", "600", false);
            break;
			
		case IBSEARCH_ASYNC02:	//Re-calculate
		    if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = REPLY;
			sheetObj.DoSave("ESM_AGT_0039GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBSAVE:	//Save
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0039GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBSEARCH_ASYNC04:	//Reject
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY01;
			sheetObj.DoSave("ESM_AGT_0039GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			ComShowCodeMessage("AGT00087", "", "", "");
			break;
		
		case IBSEARCH_ASYNC03:	//Audit
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			row = sheetObj.SelectRow;
			scnId = "AGTCOMM";
			arOfc = formObj.ar_ofc_cd.value;
			sbOfc = formObj.agn_cd.value;
			acSeq   = sheetObj.CellText(row,"ac_seq");
			//toDt = formObj.search_dt_to.value;
			saDate = formObj.search_dt_to.value;
			
			sts_cd = formObj.sts_cd.value;
			search_dt_fr = formObj.search_dt_fr.value.replace(/-/g, "");
			search_dt_to = formObj.search_dt_to.value.replace(/-/g, "");
			var rArray = getCheckedRows(sheetObj, "check");

			var args = new Array();
  			args["scnId"]		= scnId;
			args["arOfc"]		= arOfc;
			args["sbOfc"]		= sbOfc;
			args["saDate"]		= saDate;
			args["stsCd"]		= sts_cd;
			args["from_date"]	= search_dt_fr;
			args["to_date"]		= search_dt_to;
			args["acSeq"]		= acSeq;
			args["sheet"]		= rArray.toString();
			
			window.showModalDialog("ESM_AGT_0036.do", args, "scroll:no;status:no;help:no");

			doActionIBSheet(sheetObj,formObj,IBSEARCH);
            break;
		
		case IBCLEAR:	//Cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY01;
			sheetObj.DoSave("ESM_AGT_0039GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			ComShowCodeMessage("AGT00088", "", "", "");
			break;
		
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}

/*
 * Inputting the Information of the Optional Rows for Approval.
 */
function getCheckedRows(sheetObj, colName) {
	var colsCnt = sheetObj.LastCol + 1;
	var rows = sheetObj.Rows;
	var rArray = null; //Array having Row data
	var checkRows = sheetObj.CheckedRows(colName);
	var bkg_no;
    var bkg_no_tmp;
    var bkg_no_len = 0;
	
	if(checkRows == 0){  	
		return null;
 	}else{
 		var idx = 0;
  		rArray = new Array(checkRows);
		for(var i=0; i<rows; i++) {
			if(sheetObj.CellText(i,colName) == 1) {				
			    //rArray[idx++] = sheetObj.CellText(i,"bkgNo") + sheetObj.CellText(i,"agnCd") + sheetObj.CellText(i,"bnd") + sheetObj.CellText(i,"acSeq");
			    bkg_no = "";
			    bkg_no_tmp = "";
                bkg_no_len = 0;
                bkg_no_tmp = sheetObj.CellText(i,"bkg_no");
                bkg_no_len = bkg_no_tmp.length;
                
                //if(bkg_no_len > 11){
                    //bkg_no = bkg_no_tmp.substring(0,11);
                    bkg_no = bkg_no_tmp;
                //}else{
                  //  bkg_no = bkg_no_tmp;
                //}
                rArray[idx++] = bkg_no + sheetObj.CellText(i,"agn_cd") + sheetObj.CellText(i,"io_bnd_cd") + sheetObj.CellText(i,"ac_seq");
     		}
  		}
  		
  		return rArray;
  	}
}

/**
 * Retrieving Subject Office On changing A/R Office.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0039FR.do";
    formObj.submit();
}

/**
 * Initializing Grid on Changing the Status.
 */
function sts_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    
    sheetObj.RemoveAll();
    
    var sts_cd = obj.value;
	if(sts_cd == "5"){
		var today = ComGetDateAdd(null, "D", -89);
		formObj.search_dt_fr.value = "2000-01-01";
		formObj.search_dt_to.value = today;
	}else{
		var today = ComGetNowInfo();
		var frday = ComGetDateAdd(null, "D", -14);
		formObj.search_dt_fr.value = frday;
		formObj.search_dt_to.value = today;
	}
}

/*
 * Recalculating USD_AMT, LCL_AMT on Changing the Amount at the Grid
 */
function sheet1_OnChange(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "comm1" || sheetObj.ColSaveName(col) == "comm2" || sheetObj.ColSaveName(col) == "brkg" ||
	    sheetObj.ColSaveName(col) == "chf"   || sheetObj.ColSaveName(col) == "ts"    || sheetObj.ColSaveName(col) == "tr"   || 
	    sheetObj.ColSaveName(col) == "soc"   || sheetObj.ColSaveName(col) == "cross" || sheetObj.ColSaveName(col) == "doc") 
	{
		var pre_amt = sheetObj.CellValue(row, "pre_amt") * 1;
		var comm1_amt = sheetObj.CellValue(row, "comm1") * 1;
		var comm2_amt = sheetObj.CellValue(row, "comm2") * 1;
		var brkg_amt = sheetObj.CellValue(row, "brkg") * 1;
		var chf_amt = sheetObj.CellValue(row, "chf") * 1;
		var ts_amt = sheetObj.CellValue(row, "ts") * 1;
		var tr_amt = sheetObj.CellValue(row, "tr") * 1;
		var soc_amt = sheetObj.CellValue(row, "soc") * 1;
		var cross_amt = sheetObj.CellValue(row, "cross") * 1;
		var doc_amt = sheetObj.CellValue(row, "doc") * 1;
		var exRate = sheetObj.CellValue(row, "ex_rate") * 1; 
		
		var cur_amt = comm1_amt + comm2_amt + brkg_amt + chf_amt + ts_amt + tr_amt + soc_amt + cross_amt + doc_amt;
		var usd_amt = cur_amt - pre_amt;
		var lcl_amt = usd_amt * exRate;
		sheetObj.CellText(row, "usd_amt") = usd_amt;
		sheetObj.CellText(row, "lcl_amt") = lcl_amt;
	}
}

/**
 * Implementing Detail Event on Double Clicking the Column.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	if(sheetObj.ColSaveName(col) == "bl_no" || sheetObj.ColSaveName(col) == "bkg_no"){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	}
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function search_dt_fr_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function search_dt_to_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/**
 * Showing the checked Date when the date is changed 
 */
function search_dt_fr_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowCodeMessage("COM12179", "", "", "");
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = obj.value;
		var toDt = delete_Char(formObj.search_dt_to.value,'-');
		
		if(frDt > toDt){
			obj.value = toDt;

			//TO DATE must be greater than FROM DATE.
			ComShowCodeMessage("COM12133", "End date", "start date", "greater");
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/**
 * Showing the checked Date when the date is changed 
 */
function search_dt_to_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowCodeMessage("COM12179", "", "", "");
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = delete_Char(formObj.search_dt_fr.value,'-');
		var toDt = obj.value;
		
		if(frDt > toDt){
			obj.value = frDt;

			//TO DATE must be greater than FROM DATE.
			ComShowCodeMessage("COM12133", "End date", "start date", "greater");
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/**
 * Setting the user inserted BL NO 
 */
function setBlNo(obj) {
     var form = document.form;
     var bl_no = obj.value.trim().toUpperCase();
     var bl_no_list = form.bl_nos.value.trim().toUpperCase();
     
     if (window.event.keyCode==13) {
         if(bl_no.length > 0) {
 
             if(bl_no_list.length > 0) {
                 form.bl_nos.value = bl_no_list + "," + bl_no;
             } else {
                 form.bl_nos.value = bl_no;
             }
 
             obj.value = "";
         }
     }
 }
 /**
  * Setting the user inserted BL NO 
  */
 function setBlNos(obj) {
      var form = document.form;
      form.bl_nos.value = obj.value.trim().toUpperCase();
  }

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		    case IBSEARCH:	//Retrieve
		    	if(ar_ofc_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "A/R Office", "", "");
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "Subject Office", "", "");
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
		    case IBSEARCH_ASYNC01:	//Detail
				var sRow = sheetObj.SelectRow;
				if(sRow < 2){
					ComShowCodeMessage("COM12113", "row for detail information", "", "");
					return false;
				}	  
				break; 
				
			case IBSEARCH_ASYNC02:	//Re-calculate
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					ComShowCodeMessage("COM12113", "row for re-calculate", "", "");
					return false;
				}
				
				//Approval
				var rows = sheetObj.RowCount;
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellText(i+2,"check") == 1){
				    	status = sheetObj.CellText(i+2,"comm_proc_sts_cd");
				    	if(status == "AS" || status == "IF"){
				    		ComShowCodeMessage("AGT10018", i+1, "Re-calculate", "");
							return false;
						}
		     		}
		  		}
				break; 
			
			case IBSAVE:	//Save
				//Optional
				var modifyCnt = sheetObj.RowCount("U");
				if(modifyCnt < 1){
					ComShowCodeMessage("AGT10010", "", "", "");
					return false;
				}

				//Approval
				var rows = sheetObj.RowCount;
				
				for(var i=0; i<rows; i++) {
					if(sheetObj.CellText(i+2,"check") == 1){
						status = sheetObj.CellText(i+2,"comm_proc_sts_cd");
				    	if(status == "AS" || status == "IF"){
				    		ComShowCodeMessage("AGT10018", i+1, "Save", "");
							return false;
						}
		     		}
		  		}
		  		break; 
				
			case IBSEARCH_ASYNC04:	//Reject
				//Status check
				var status = sts_cd.value;
		  		if(status == "2" || status == "3"){
		  			ComShowCodeMessage("AGT10027", "Reject", "", "");
					return false;
		  		}
		     	
		     	//Optional check
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					ComShowCodeMessage("COM12113", "row for reject", "", "");
					return false;
				}	  
		     	break; 
				
			case IBSEARCH_ASYNC03:	//Audit
				if(ar_ofc_cd.value == ""){
					ComShowCodeMessage("COM12113", "(Approval)A/R Office", "", "");
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowCodeMessage("COM12113", "(Approval)Subject Office", "", "");
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					ComShowCodeMessage("COM12113", "row for audit", "", "");
					return false;
				}
				
				if(checkCnt > 500){
					ComShowCodeMessage("COA10008", "row for audit 500", "", "");
					return false;
				}
				
				//Approval check
				var rows = sheetObj.RowCount;
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellText(i+2,"check") == 1){
				    	status = sheetObj.CellText(i+2,"comm_proc_sts_cd");
				    	if(status != "RS" && status != "RM"){
				    		ComShowCodeMessage("AGT10018", i+1, "Approval", "", "");
							return false;
						}
				    	
				    	var bkg_sts_cd = sheetObj.CellValue(i+2,"bkg_sts_cd");
						
						if(bkg_sts_cd == "A"){
							ComShowCodeMessage("AGT10090", "A", "", "");
							sheetObj.CellValue(i+2,"check") = 0;//
							return false;
						}
				    	
		     		}
		  		}
				break; 	
				
			case IBCLEAR:	//Cancel
				//Status 체크
				var status = sts_cd.value;
		  		if(status != "2"){
		  			ComShowCodeMessage("AGT10027", "Cancel", "", "");
					return false;
		  		}
		     	
		     	//Optional check
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					ComShowCodeMessage("COM12113", "row for cancel", "", "");
					return false;
				}	  
		     	break; 
		}
	}

	return true;
}

/**
 * Checking the number of rows wanted to be checked.
 */
function auditCnt_Check(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	var chkStart = formObj.chkStart.value;
	var chkEnd = formObj.chkEnd.value;

	var sRows = sheetObj.RowCount;
	
	if(sRows > 0){
	    if(chkStart == "" || chkStart == null){
	    	ComShowCodeMessage("AGT10001", "Check Start Row", "", "");
    		formObj.chkStart.focus();
    		return false;
    	}
    	
    	if(chkStart == "0"){
    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
    		formObj.chkStart.focus();
    		return false;
    	}
    	
    	if(chkEnd == "" || chkEnd == null){
    		ComShowCodeMessage("AGT10001", "Check End Row", "", "");
    		formObj.chkEnd.focus();
    		return false;
    	}

    	
    	var numChkStart	= parseInt(chkStart);
    	var numChkEnd	= parseInt(chkEnd);
    	if(numChkStart > numChkEnd){
    		ComShowCodeMessage("COM12142", "Check Start Row", "Check End Row", "");
    		formObj.chkStart.focus();
    		return false;
    	}
    	
    	if(numChkEnd > sheetObj.RowCount){
    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
    		formObj.chkEnd.focus();
    		return false;
    	}
    	
    	if(numChkStart > sheetObj.RowCount){
    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
    		formObj.chkStart.focus();
    		return false;
    	}
    	
    	if(numChkStart > sheetObj.RowCount){
    		ComShowCodeMessage("AGT10001", "number less than end row or equal", "", "");
    		formObj.chkStart.focus();
    		return false;
    	}
    	
		sheetObj.Redraw = false;
    	var i = numChkStart + 1;
    	var max = numChkEnd + 1;
    	var checkd = "";
        while ( i <= max )
        {
         checkd = checkd + "1\r\n";
         sheetObj.RowStatus(i++) = "U";
        }
        sheetObj.Paste2Column(checkd,"|","\r\n","","check",numChkStart);
     sheetObj.Redraw = true;
	}	
}

/**
 * unChecking the number of rows wanted to be checked.
 */
function auditCnt_Uncheck(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	var unchkStart = formObj.unchkStart.value;
	var unchkEnd = formObj.unchkEnd.value;
	
//	var sRows = sheetObj.RowCount;
	
	//if(sRows > 0){
	    if(unchkStart == "" || unchkStart == null){
	    	ComShowCodeMessage("AGT10001", "Uncheck Start Row", "", "");
    		formObj.unchkStart.focus();
    		return false;
    	}
    	
    	if(unchkStart == "0"){
    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
    		formObj.unchkStart.focus();
    		return false;
    	}
    	
    	if(unchkEnd == "" || unchkEnd == null){
    		ComShowCodeMessage("AGT10001", "Uncheck End Row", "", "");
    		formObj.unchkEnd.focus();
    		return false;
    	}
    	
    	if(parseInt(unchkStart) > parseInt(unchkEnd)){
    		ComShowCodeMessage("COM12142", "Uncheck Start Row", "Uncheck End Row", "");
    		formObj.unchkStart.focus();
    		return false;
    	}
    	
    	var i = parseInt(unchkStart) + 1;
    	var max = parseInt(unchkEnd) + 1;
		sheetObj.Redraw = false;
		var checkd = "";
	     while ( i <= max )
	     {
	      checkd = checkd + "0\r\n"
	      sheetObj.RowStatus(i++) = "R";
	     }
	     sheetObj.Paste2Column(checkd,"|","\r\n","","check", unchkStart);
	  sheetObj.Redraw = true;
    	
	

}
	
