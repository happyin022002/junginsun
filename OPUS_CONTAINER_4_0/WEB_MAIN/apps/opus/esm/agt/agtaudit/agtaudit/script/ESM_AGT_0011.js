// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

var IBSHOWDETAIL  = 22; //showdetail

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

	//ESM_AGT_0010 parameters  Retrieve
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
				// setting height
				style.height = GetSheetHeight(7) ;
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, false, false, true, false, false) ;
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "SEQ|Calc. Date|USD Amount|PYMT Amount|Ex. Rate";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,    35,    daCenter,  false,    "ac_seq",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtData,   80,    daCenter,  false,    "cre_dt",       false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++ , dtData,   90,    daRight,   false,    "act_if_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++ , dtData,   90,    daRight,   false,    "act_if_locl_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++ , dtData,   60,    daRight,   false,    "xch_rt",       false,    "",         dfFloat,    2,          false,      false);
				
				CountPosition  = 0 ;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(5);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, false, false, true, false, false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Type|USD Amount|PYMT Amount";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, 				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   100,   daCenter,  false,    "ac_tp_cd",       		false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   100,   daRight,   false,    "act_if_comm_amt",     false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,   100,   daRight,   false,    "act_if_locl_comm_amt",false,    "",         dfFloat,    2,          false,       false);
			
				CountPosition  = 0 ;
			}
			break;
		
		case 3:      //sheet3 init
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(5) ;
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(2, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, false, false, true, false, false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "TP/SZ|QTY";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "cntr_tpsz_cd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "op_cntr_qty",       false,    "",         dfInteger,  0,          false,       false);
				
				CountPosition  = 0 ;
			}
			break;
		
		case 4:      //sheet3 init
			with (sheetObj) {
				// setting height
				style.height = 0
				
				//Whole setting width
				SheetWidth = 0

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(23, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, false, false, true, false, false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "bl_no";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "bl_no",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "por",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "bkg_no",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "pol",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "vendor",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "pre",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "agmt_no",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "post",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "agn_cd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "pod",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "trk_vvd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "del",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "trk_slane",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "gross",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "fdr_vvd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "oft_ppd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "sc_no",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "oft_cct",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "rfa_no",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "charge_ppd",       false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "op_cntr_qty",       false,    "",         dfInteger,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "svc_scp",          false,    "",         dfNone,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,   150,   daCenter,  false,    "charge_cct",       false,    "",         dfInteger,  0,          false,       false);
				
				CountPosition  = 0 ;
			}
			break;
	}
}

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
//	var sheetObject1 = sheetObjects[1];
//	var sheetObject2 = sheetObjects[2];
//	var sheetObjectEtc = sheetObjects[3];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_close":
				window.close();
				break;
				
			case "btn_deductiondetail":
				doActionIBSheet(sheetObject,formObject,IBSHOWDETAIL);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg("COM12111", "", ""));
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
			
			formObj.f_cmd.value = SEARCH;
			//sheetObj.DoSearch4Post("ESM_AGT_011GS.do", agtQryStr(formObj));
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0011GS.do", agtQryStr(formObj));
			
			var arrXml = sXml.split("|$$|");
//			if(arrXml.length>0){
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[2].LoadSearchXml(arrXml[2]);
				sheetObjects[3].LoadSearchXml(arrXml[3]);
   	        break;
			
		case IBSHOWDETAIL:
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			blNo  = formObj.bl_no.value;
			bkgNo = formObj.bkg_no.value;
			agnCd = formObj.agn_cd.value;
			ioBnd = formObj.io_bnd_cd.value;
			seq   = formObj.ac_seq.value;
			arOfc = formObj.ar_ofc_cd.value;
			saDt = formObj.sail_arr_dt.value;
			
			var param = "?blNo=" + blNo + "&bkgNo=" + bkgNo + "&agnCd=" + agnCd + "&ioBnd=" + ioBnd + "&seq=" + seq + "&arOfc=" + arOfc+"&saDt=" + saDt;
            //window.showModalDialog("ESM_AGT_012.do" + param, "", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:655px");
            //window.showModelessDialog("ESM_AGT_012.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
			ComOpenWindowCenter("ESM_AGT_0012.do" + param, "compop2", "1000", "600", false);
            break;
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
		/*
		var blNo = formObj.blNo.value;
		var bkgNo = formObj.bkgNo.value;
		
		if (blNo == null || blNo == "") {
			blNo = bkgNo;
		}
		*/
	}

	return true;
}

function sheet4_OnSearchEnd(sheetObj, ErrMsg)
{
	var formObj = document.form;
	formObj.bl_no_text.value 	= 	sheetObjects[3].CellValue(1, "bl_no");
	formObj.por.value 			= 	sheetObjects[3].CellValue(1, "por");
	formObj.bkg_no_text.value 	= 	sheetObjects[3].CellValue(1, "bkg_no");
	formObj.pol.value 			=	sheetObjects[3].CellValue(1, "pol");
	formObj.vendor.value 		=	sheetObjects[3].CellValue(1, "vendor");
	formObj.pre.value 			=	sheetObjects[3].CellValue(1, "pre");
	formObj.agmt_no.value 		= 	sheetObjects[3].CellValue(1, "agmt_no");
	formObj.post.value 			=	sheetObjects[3].CellValue(1, "post");
	formObj.agn_cd_text.value 	= 	sheetObjects[3].CellValue(1, "agn_cd");
	formObj.pod.value 			=	sheetObjects[3].CellValue(1, "pod");
	formObj.trk_vvd.value 		= 	sheetObjects[3].CellValue(1, "trk_vvd");
	formObj.del.value 			=	sheetObjects[3].CellValue(1, "del");
	formObj.trk_slane.value 	= 	sheetObjects[3].CellValue(1, "trk_slane");
	formObj.gross.value 		=	sheetObjects[3].CellValue(1, "gross");
	formObj.fdr_vvd.value 		= 	sheetObjects[3].CellValue(1, "fdr_vvd");
	formObj.oft_ppd.value 		= 	sheetObjects[3].CellValue(1, "oft_ppd");
	formObj.sc_no.value 		=	sheetObjects[3].CellValue(1, "sc_no");
	formObj.oft_cct.value 		=	sheetObjects[3].CellValue(1, "oft_cct");
	formObj.rfa_no.value 		= 	sheetObjects[3].CellValue(1, "rfa_no");
	formObj.charge_ppd.value 	= 	sheetObjects[3].CellValue(1, "charge_ppd");
	formObj.svc_scp.value 		= 	sheetObjects[3].CellValue(1, "svc_scp");
	formObj.charge_cct.value 	= 	sheetObjects[3].CellValue(1, "charge_cct");
	
	

}
	
