// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

/* 
 * Adding IBSheet Action 
 */
var IBCONFIRM = 21;	//Confirm
var IBCLOSE   = 22;	//Close

/* 
 * Event handler processing by button click event 
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

	//ESM_AGT_010 parameters  Retrieve
    var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
				style.height = 0;
				
				//Whole setting width
				SheetWidth = 0;
	
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;
	
			    //Edit kind [Optional, Default false]
				Editable = true;
	
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
	
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);
	
				//Setting Header Function[Optional][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "apro_no|bl_no|agn_cd|io_bnd_cd|ac_seq|act_if_comm_amt|act_if_locl_comm_amt";
				InitHeadRow(0, HeadTitle, true);
	
				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "apro_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_locl_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				//CountPosition  = 0 ;
			}
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
				//setting height
				style.height = GetSheetHeight(12);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 0, 0, true);
//				InitColumnInfo(7, 0, 0, true);
				//Setting Header Function[Optional][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "STS|BKG No|B/L No|AGN CD|I/O|SEQ|USD Amount|PYMT Amount";
//				var HeadTitle = "BKG No|B/L No|AGN CD|I/O|SEQ|USD Amount|PYMT Amount";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHidden,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++, dtData,    125,   daLeft,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_locl_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ar_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				//CountPosition  = 0 ;
			}
			break;
			
		
		
	}
}

/* Event handler processing by button name */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;	
			case "btn_confirm":
				doActionIBSheet(sheetObject1,formObject,IBCONFIRM);
				break;
				
			case "btn_close":
				doActionIBSheet(sheetObject1,formObject,IBCLOSE);
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
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;

	    	formObj.f_cmd.value = SEARCH;
	    	sheetObj.DoSearch4Post("ESM_AGT_0036GS.do", agtQryStr(formObj));
//			alert(sheetObjects[0].CellValue(1, "apro_no"));
			if(sheetObject.cellValue(1, "apro_no")!=null){
        		formObj.s_apro_no.value = sheetObject.cellValue(1, "apro_no");
        	}

			var bkgNoArray = new Array();
			bkgNoArray = formObj.sheet.value;
			var bkgNoArraySplit = bkgNoArray.split(",");
			var queryVal = "";
			for(j=0;j<bkgNoArraySplit.length; j++){
				if(j < bkgNoArraySplit.length-1){
					queryVal += bkgNoArraySplit[j]+"','";
				}else{
					queryVal += bkgNoArraySplit[j];
				}
			}
			
			formObj.arr_val.value = "'"+queryVal+"'";
			
			formObj.f_cmd.value = SEARCH01;
			
	    		

			sheetObject1.DoSearch("ESM_AGT_0036GS.do", agtQryStr(formObj));
			
			break;
		case IBCONFIRM:
			if(!validateForm(sheetObjects[1],formObj,sAction))	return false;
			formObj.f_cmd.value = MODIFY;
//			alert(agtQryStr(formObj));
//			alert(sheetObject1.GetSaveString(true));
			sheetObject1.DoAllSave("ESM_AGT_0036GS.do", agtQryStr(formObj));
			window.close();
			break;	

		case IBCLOSE:
			window.close();
			break;	
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		    case IBSEARCH:	//Retrieve
				break;
			case IBCONFIRM:	//Approval
				var approvalNo = formObj.s_apro_no.value;
//				alert("approvalNo="+approvalNo);
				if (approvalNo == "") {
					//[COM12114]Please check **
					ComShowMessage(ComGetMsg("COM12114", "Approval No", ""));
					return false;
				}
				
				row = sheetObj.SelectRow;
				if(row < 1){
					//[COM12114]Please check **
					ComShowMessage(ComGetMsg("COM12114", "retrieved data", "", ""));
					return false;
				}	  
				break; 
		}			
	}

	return true;
}

