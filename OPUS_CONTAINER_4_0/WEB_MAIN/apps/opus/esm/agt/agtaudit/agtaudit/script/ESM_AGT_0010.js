// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

/* 
 *Event handler processing by button click event 
 */
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
	
	// Setting S/A Date Unit 
	var formObj = document.form;
	var today = ComGetNowInfo();
	var frday = ComGetDateAdd(null, "D", -7);
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
				style.height = GetSheetHeight(15);
				
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
				InitColumnInfo(39, 4, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle1 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|BKG STS||||||||||PRE AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
				var HeadTitle2 = "STS|CHK|No.|B/L No.|BKG No.|BND|VVD|PORT|S/A Date|SEQ|BKG STS||||||||||PRE AMT|Common1|Common2|BRKG|CHF|T/S|T/R|SOC|Cross|DOC|USD AMT|Ex. Rate|Cur|PYMT AMT|Status|Remarks";
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//Data  properties    [ROW, COL,   DATATYPE,	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,30,	daCenter,  	true,    	"ibflag",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtCheckBox, 	40,		daCenter,   true,    	"check",  	false,		"",			dfNone,		0,			true,		false);
				InitDataProperty(0, cnt++, dtSeq,		30,		daCenter,   true,    	"seq",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		90,		daCenter,   true,    	"bl_no",   	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		90,		daCenter,   true,    	"bkg_no",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		30,		daCenter,   true,    	"io_bnd_cd",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		80,		daCenter,   true,    	"vvd",    	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,	    50,		daCenter,   true,    	"port",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		70,		daCenter,   true,    	"sail_arr_dt", 	false,		"",			dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		35,		daCenter,   true,    	"ac_seq",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		60,		daCenter,   true,    	"bkg_sts_cd",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcommon1",	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcommon2",	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pbrkg",  	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pchf",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pts",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"ptr",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"psoc",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pcross", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	60,		daRight,    true,    	"pdoc",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	70,		daRight,    true,    	"pre_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	65,		daRight,    false,    	"comm1", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	65,		daRight,    false,    	"comm2", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"brkg",   	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"chf",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"ts",     	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"tr",     	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"soc",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"cross",  	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	60,		daRight,    false,    	"doc",    	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	80,		daRight,    true,    	"usd_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtData,		70,		daRight,    true,    	"ex_rate", 	false,		"",			dfFloat,	4,			false,		false);
				InitDataProperty(0, cnt++, dtData,		40,		daCenter,   true,    	"curr_cd",   	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtAutoSumEx,	80,		daRight,    true,    	"lcl_amt", 	false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++, dtData,		45,		daCenter,   true,    	"comm_proc_sts_cd", 	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtData,		500,	daLeft,   	true,    	"comm_proc_sts_rsn", 	false,		"",			dfNone,		0,			true,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"ar_ofc_cd",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"agn_cd",  	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++, dtHidden,	50,		daCenter,   true,    	"scp",  	false,		"",			dfNone,		0,			false,		false);
				
				RangeBackColor(1,19,1,27) = RgbColor(222, 251, 248);   // OPUS
			}
			break;
	}
}

/* 
 * Event handler processing by button name 
 */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_showdetail":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;

			case "btn_recalculate":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
				break;

			case "btn_exrateinput":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);
				break;

			case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
				
			case "btn_cal_fr":
	         	var cal = new ComCalendar();
				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
	            break;

            case "btn_cal_to":
             	var cal = new ComCalendar();
                cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
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
			    if(formObj.bl.value.trim().length > 0){
		    		setBlNoRetrieve(formObj.bl);
		    	}
	    	sheetObj.Redraw = false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
			
		case IBSEARCH_ASYNC01:	//Detail
		
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			var row = sheetObj.SelectRow;
			var bl_no  = sheetObj.CellValue(row,"bl_no");
			var bkg_no = sheetObj.CellValue(row,"bkg_no");
			var agn_cd = sheetObj.CellValue(row,"agn_cd");
			var io_bnd_cd = sheetObj.CellValue(row,"io_bnd_cd");
			var seq   = sheetObj.CellValue(row,"ac_seq");
			var arOfc = sheetObj.CellValue(row,"ar_ofc_cd");
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
			sheetObj.Redraw = false;
			formObj.f_cmd.value = REPLY;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBSEARCH_ASYNC04:	//ex.Rate Input
		    if(!validateForm(sheetObj,formObj,sAction))	return false;
			sheetObj.Redraw = false;
			formObj.f_cmd.value = MODIFY01;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBSEARCH_ASYNC03:	//Request

			if(!validateForm(sheetObj,formObj,sAction))	return false;
			sheetObj.Redraw = false;
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0010GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,2) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			sheetObj.Redraw = true;
			break;
		
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
	
	var rows = sheetObj.RowCount;
	for(var i=0; i<rows; i++){
		sts = sheetObj.CellValue(i+2,"comm_proc_sts_cd");
		
		if(sts == "CE"){
			sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(255,0,0); //red
		}else if(sts == "IC" || sts == "CA"){
			sheetObj.RowFontColor(i+2) = sheetObj.RgbColor(0,0,255); //blue
		}
	}
}

/**
 * Implementing Detail event on Deouble Clicking the Row.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
		
	//Detail Pop-up Retrieve
	if(sheetObj.ColSaveName(col) == "bl_no" || sheetObj.ColSaveName(col) == "bkg_no"){
		doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	}
	
	//VVD Currency Common Pop-up Retrieve
	if (sheetObj.ColSaveName(col) == "ex_rate") {
        var vvd  = sheetObj.CellValue(row, "vvd");
        vvd = vvd.substring(0,9);
        var port = sheetObj.CellValue(row, "port");
        var curr_cd = sheetObj.CellValue(row, "curr_cd");
        var io_bnd_cd  = sheetObj.CellValue(row, "io_bnd_cd");
        var scp  = sheetObj.CellValue(row, "scp");
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
        var classId = "ESM_AGT_0047"; //"COM_ENS_0F1";
	    var param = '?vvd_cd=' + vvd + '&port_cd=' + port + '&locl_curr_cd=' + curr_cd + '&io_bnd_cd=' + io_bnd_cd + '&svc_scp_cd=' + scp+'&chg_curr_cd=USD';
		var chkStr = dispaly.substring(0,3) ;         
        
        if(chkStr == "1,0") {
        	//Radio PopUp  
//           	ComOpenPopup('/opuscntr/COM_ENS_0F1.do' + param, 770, 470, 'getCOM_ENS_0F1_2', dispaly, true, false, row, col);
           	ComOpenPopup('/opuscntr/ESM_AGT_0047.do' + param, 770, 470, '', dispaly, true, false, row, col);
        } 
    }
}

//Modifying Ex.Rate Value
//function getCOM_ENS_0F1_2(rowArray, row, col){
//	var sheetObject = sheetObjects[0];
//	var colArray = rowArray[0];
//	sheetObject.CellValue(row, "ex_rate") = colArray[10];
//}

/**
 * Retrieving Subject Office On changing A/R Office.
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
    
    //Sub Office ComboBox Setting
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0010FR.do";
    formObj.submit();
}

/**
 * Grid Initialization on changing Subject Office.
 */
function agn_cd_OnChange(obj){
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
}

/**
 * Initializing Grid and Setting the Retrieve Date on Changing Status
 */
function sts_cd_OnChange(obj){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
	
	//Grid Reset
	sheetObj.RemoveAll();
	
	//Retrieve date setting
	var sts_cd = obj.value;
	if(sts_cd == "4"){
		var today = ComGetDateAdd(null, "D", -90);
		formObj.search_dt_fr.value = "2000-01-01";
		formObj.search_dt_to.value = today;
	}else{
		var today = ComGetNowInfo();
		var frday = ComGetDateAdd(today, "D", -6);
		formObj.search_dt_fr.value = frday;
		formObj.search_dt_to.value = today;
	}
	
	//Status setting
	var optLen = formObj.sts_dv.options.length - 1;
	for(var i = optLen; i >= 0; i--){
		formObj.sts_dv.remove(i);
	}
	
	if(sts_cd == "0" || sts_cd == "3" || sts_cd == "4"){
		//created, S/A, Old
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '0';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CS';
		addOpt.value = '1';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CE';
		addOpt.value = '2';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'CA';
		addOpt.value = '3';
		
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'IC';
		addOpt.value = '4';
	}

	if(sts_cd == "1"){
		//requested(RS,RM)
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '5';
	}
	 
	if(sts_cd == "2"){
	 	//audited(AS)
	 	addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '6';
	}

	if(sts_cd == "5"){ 
		//interfaced(IF)
		addOpt = document.createElement('OPTION');
		formObj.sts_dv.add(addOpt);
		addOpt.innerText = 'ALL';
		addOpt.value = '7';
	}
	 
}

/*
 * Setting Text to Whole Optional on Focusing.
 */
function search_dt_fr_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/*
 * Setting Text to Whole Optional on Focusing.
 */
function search_dt_to_onfocus(obj){
	delete_Char(obj,'-');	//Insert값에서 '-'를 없앤다.
	obj.select();	//Insert값을 Whole Optional한다.
}

/**
 * Showing the checked Date when the date is changed 
 */
function search_dt_fr_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = obj.value;
		var toDt = delete_Char(formObj.search_dt_to.value,'-');
		
		if(frDt > toDt){
			obj.value = toDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
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
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = delete_Char(formObj.search_dt_fr.value,'-');
		var toDt = obj.value;
		
		if(frDt > toDt){
			obj.value = frDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
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
		    		//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
		    		formObj.ar_ofc_cd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "Subject Office", "", ""));
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
		    case IBSEARCH_ASYNC01:	//Detail
				var sRow = sheetObj.SelectRow;
				if(sRow < 2){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "BKG No for detail information", "", ""));
					return false;
				}	  
				break; 
				
			case IBSEARCH_ASYNC02:	//Re-calculate
				//Status check
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowMessage(ComGetMsg("AGT10027", "Re-calculate", "", ""));
					return false;
	     		}
	  		
				//Optional number check
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "row for re-calculate", "", ""));
					return false;
				}
				
				//200 check
				if(checkCnt > 200){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", ""));
					return false;
				}
				
				break; 
			
			case IBSEARCH_ASYNC04:	//ex.Rate Input
				//Status check
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowMessage(ComGetMsg("AGT10027", "ex.Rate Input", "", ""));
					return false;
	     		}
	     		
	     		//Optional check
				var checkCnt = sheetObj.CheckedRows("check");
				if(checkCnt < 1){
					//Please select **.
		    		ComShowMessage(ComGetMsg("COM12113", "row for ex.Rate Input", "", ""));
					return false;
				}
	  		
				break; 
			
			case IBSEARCH_ASYNC03:	//Request
				//Status check
				var checkCnt = sheetObj.RowCount;
//				alert("checkCnt="+checkCnt)
				var status = formObj.sts_cd.value;
				if(status == "1" || status == "2") {
			    	ComShowCodeMessage("AGT10027", "Request", "", "");
					return false;
	     		}
				
				for(var j=0; j<checkCnt ; j++){
					if(sheetObj.CellValue(j+2,"check") == 1){
//					alert("1="+sheetObj.CellValue(j+2,"comm_proc_sts_cd"));
					if(sheetObj.CellValue(j+2,"comm_proc_sts_cd") == "CE"){
//						alert("2="+sheetObj.CellValue(j+2,"comm_proc_sts_cd"));
						ComShowCodeMessage("AGT10027", "Request", "", "");
						return false;
					}
					
				}
				}
//    	  		var totCount = chkEnd - chkStart;
//            	CreateVBArray( totCount, 1, "@");
//            	
//            	for(var i=0; i<=totCount; i++) {
//            	    SetVBValue(i, 1, "1");
//            	}
//            	
//            	var vbArray = GetVBArray();
//              sheetObj.Paste2ColumnVBArray(vbArray, "@", "1|check", chkStart);
          
				//process check
				var rows = sheetObj.RowCount;
				CreateVBArray( rows, 1, "@");
				
				var checkRowCnt = 0;
				var checkRowCntTmp = 0;
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	//ex_rate
						ex_rate = sheetObj.CellValue(i+2,"ex_rate");
						if(ex_rate == 0){
							checkRowCntTmp++;
						}
						checkRowCnt++;
				    }
				    if((i+2 == rows+1) && (checkRowCnt == checkRowCntTmp)){
				    	ComShowCodeMessage("AGT00089", "Exchange Rate", "", "");
					    return false;
				    }

				}
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	//ex_rate
						ex_rate = sheetObj.CellValue(i+2,"ex_rate");
						if(ex_rate == 0){
							sheetObj.CellValue2(i+2,"check") = 0;
						}
				    }
				}
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+2,"check") == 1){
				    	
				    	status = sheetObj.CellValue(i+2,"comm_proc_sts_cd");

				    	if(status != "CS"){
//				    		ComShowCodeMessage("AGT10028", i+1, "Request", "");
//							return false;
//                          sheetObj.CellValue(i+2,"check") = 0;
                            SetVBValue(i, 1, "0");
						}
						var blNo = sheetObj.CellValue(i+2,"bl_no");
						
						if(blNo == ""){
							ComShowCodeMessage("AGT10028", i+1, "Request! Because B/L No does not exist.", "");
							sheetObj.CellValue(i+2,"check") = 0;
							SetVBValue(i, 1, "0");
							return false;
                            
						}
						var bkg_sts_cd = sheetObj.CellValue(i+2,"bkg_sts_cd");
						
						if(bkg_sts_cd == "A"){
							ComShowCodeMessage("AGT10090", "A", "", "");
							sheetObj.CellValue(i+2,"check") = 0;//
							SetVBValue(i, 1, "0");
							return false;
                            
						}
						lcl_amt = sheetObj.CellValue(i+2,"lcl_amt");
						if(lcl_amt == 0){
//						    sheetObj.CellValue(i+2,"check") = 0;
                          SetVBValue(i, 1, "0");
						}
		     		}
		  		}
				
		  		var vbArray = GetVBArray();
		  		sheetObj.Paste2ColumnVBArray(vbArray, "@", "1|check", 1);
		  		var checkCnt = sheetObj.CheckedRows("check");
		  		//500 check
				if(checkCnt > 500){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "under 500 B/Ls at a time when you request.", "", "");
					return false;
				}
				
				break;
				
//				var checkCnt = sheetObj.CheckedRows("check");
//				if(checkCnt < 1){
//					//Please select **.
//		    		ComShowMessage(ComGetMsg("COM12113", "row for request", "", ""));
//					return false;
//				}
				
				 
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

	    	var i = numChkStart;
	    	var max = numChkEnd;
	    	var checkd = "";
	    	sheetObj.Redraw = false;
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
	    	
	    	var i =  parseInt(unchkStart);
	    	var max =  parseInt(unchkEnd);
	    	var checkd = "";
	    	sheetObj.Redraw = false;
	    	while ( i <= max )
		    {
		    	checkd = checkd + "0\r\n"
		    	sheetObj.RowStatus(i++) = "R";
		    }
		    sheetObj.Paste2Column(checkd,"|","\r\n","","check", unchkStart);
	    	sheetObj.Redraw = true;

}
function setBlNos(obj) {
     var form = document.form;
     form.bl_nos.value = obj.value.trim().toUpperCase();
}
/**
 * Retrieving after Setting BL NO on Clicking Retrieve Button.
 */
function setBlNoRetrieve(obj) {
    var form = document.form;
    var bl_no = obj.value.trim().toUpperCase();
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
            form.bl_nos.value = bl_no_list + "," + bl_no;
        } else {
            form.bl_nos.value = bl_no;
        }

        obj.value = "";
}
