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
	

	//ESM_AGT_011 parameters  Retrieve
	
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
				style.height = GetSheetHeight(7);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;
				
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional][Default msNone]
				MergeSheet = msHeaderOnly;

			    //Edit kind[Optional][Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 3, 0, true);

				//Setting Header Function[Optional][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//				var HeadTitle = "CHG|Cur|Rate|Rated As|Per|Amount|USD AMT|I/N|P/C|Third|Payer|CGO|Term|Term";
				var HeadTitle = "CHG|Cur|Rate|Rated As|Per|Amount|USD AMT|I/N|Payer|CGO|Term|Term";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   40,    daCenter,  false,    "chg_cd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   40,    daCenter,  false,    "curr_cd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   75,    daRight,   false,    "chg_ut_amt",   false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,   60,    daRight,   false,    "rat_as_qty", false,    "",         dfFloat,    3,          false,      false);
				InitDataProperty(0, cnt++, dtData,   30,    daCenter,  false,    "rat_ut_cd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   75,    daRight,   false,    "chg_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden, 70,    daRight,   false,    "chg_amt_rt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,   30,    daCenter,  false,    "incl_oft_flg",     false,    "",         dfNone,     0,          false,      false);
//				InitDataProperty(0, cnt++, dtData,   30,    daCenter,  false,    "pc",     false,    "",         dfNone,     0,          false,      false);
//				InitDataProperty(0, cnt++, dtData,   40,    daCenter,  false,    "third",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   70,    daCenter,  false,    "cust_payer",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   30,    daCenter,  false,    "cgo_cate_cd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   70,    daCenter,  false,    "rcv_term_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   10,    daCenter,  false,    "de_term_cd",  false,    "",         dfNone,     0,          false,      false);
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
				InitColumnInfo(2, 0, 0, true);

				//Setting Header Function[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false,false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Cur|Amount";
				InitHeadRow(0, HeadTitle, true);
				
				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    95,    daCenter,  false,    "curr_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daRight,   false,    "chg_amt",       false,    "",         dfFloat,    0,          false,      false);	//2008.9.25 이현수 추가 SAVENAME=>gross
				//InitDataProperty(0, cnt++, dtHidden,    5,    daRight,   false,     "grsnetgubun",      false,    "",         dfNone,    0,          false,      false);	//2008.9.25 이현수 추가 SAVENAME=>grsnetgubun
				CountPosition  = 0 ;
			}
			break;
			
		case 3:      //sheet3 init
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(3);
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

				//Setting Header Function[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false,false) ;

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				//var HeadTitle = "Amt-Type|Office|Payer";
				var HeadTitle = "Collection  Office|Collection  Office|Payer";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   80,    daRight,   false,    "rate_type",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   70,    daCenter,  false,    "office_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   70,    daCenter,  false,    "cust_payer",       false,    "",         dfNone,     0,          false,      false);
				CountPosition  = 0 ;
			}
			break;
			
		case 4:      //sheet4 init
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(8);
				
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

				//Setting Header Function[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Charge|Per|Cur|Per AMT|USD AMT";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    70,    daCenter,   false,   "chg_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    40,    daCenter,   false,   "bkg_agmt_ut_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    60,    daCenter,   false,   "curr_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daRight,    false,   "chg_ddct_locl_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 80,    daRight,    false,   "chg_ddct_amt",       false,    "",         dfFloat,    2,          false,      false);
				CountPosition  = 0 ;
			}
			break;
			
		case 5:      //sheet5 init
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(7);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			   //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100"C:/Documents and Settings/Administrator/Local Settings/Temporary Internet Files/Content.IE5/CGKR7W3A/btn_close[1].gif"]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);

				//Setting Header Function[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Item|From|To|O/D|S/A date|Amount";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    150,   daLeft,    false,    "stnd_cost_nm",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    45,    daCenter,  false,    "nod_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    45,    daCenter,  false,    "to_nod_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    30,    daCenter,  false,    "cre_usr_id",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  70,    daCenter,  false,    "sail_arr_dt",       false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 60,    daRight,   false,    "usd_uc_amt",       false,    "",         dfFloat,    4,          false,      false);
				CountPosition  = 0 ;
			}
			break;
			
			case 6:      //sheet5 init		
			with (sheetObj) {
				// setting height
				style.height = GetSheetHeight(0);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			   //Edit kind [Optional, Default false]
				Editable = false;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100"C:/Documents and Settings/Administrator/Local Settings/Temporary Internet Files/Content.IE5/CGKR7W3A/btn_close[1].gif"]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);

				//Setting Header Function[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Grsnetgubun|Actpcd";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//				InitDataProperty(0, cnt++, dtData,    80,   daCenter,    false,    "grsnetcd",       false,    "",         dfNone,     0,          false,      false);
//				InitDataProperty(0, cnt++, dtData,    2,    daCenter,  false,    "acttpcd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,   daCenter,    false,    "grsnet_gubun",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    2,    daCenter,  false,    "ac_tp_cd",       false,    "",         dfNone,     0,          false,      false);
//				InitDataProperty(0, cnt++, dtData,    2,    daCenter,  false,    "frc_flg",       false,    "",         dfNone,     0,          false,      false);
				CountPosition  = 0 ;
			}
			break;
			    
	}
}

/* Event handler processing by button name */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var sheetObject6 = sheetObjects[5];
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
//			case "btn_detail":
//				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
//				break;

			case "btn_close":
				window.close();
				
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

//    var sheetObj2 = sheetObjects[1]; 
//    var sheetObj3 = sheetObjects[2];
//    var sheetObj4 = sheetObjects[3];
//    var sheetObj5 = sheetObjects[4];
//   	var sheetObj6 = sheetObjects[5];		
   	   
	switch(sAction) {
	    case IBSEARCH:		//Retrieve

			if(!validateForm(sheetObj,formObj,sAction)) return false;

			formObj.f_cmd.value = SEARCH;

//			sheetObj.DoSearch4Post("ESM_AGT_012GS.do", agtQryStr(formObj));
			
			
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0012GS.do", agtQryStr(formObj));
//			alert(sXml);
			
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			sheetObjects[2].LoadSearchXml(arrXml[2]);
			sheetObjects[3].LoadSearchXml(arrXml[3]);
			sheetObjects[4].LoadSearchXml(arrXml[4]);
			sheetObjects[5].LoadSearchXml(arrXml[5]);
			
			//Calculating Net Ocean Revenue 
			var row1 = sheetObjects[0].RowCount;
			var oftAmt		= 0;
			var rateFrcAmt	= 0;
			var rateErcAmt	= 0;
			var rateGriAmt	= 0;
			var ddctFrcAmt	= 0;
			var arOfc		= formObj.ar_ofc_cd.value
			var saDt		= formObj.sail_arr_dt.value

			for(var i=1; i<=row1; i++)
			{
				if(sheetObjects[0].CellValue(i,0) == "OFT"){
					oftAmt = oftAmt + (sheetObjects[0].CellValue(i,"chg_amt_rt") * 1);
				}

				if(sheetObjects[0].CellValue(i,"chg_cd") == "FRC"){
					rateFrcAmt = rateFrcAmt + sheetObjects[0].CellValue(i,"chg_amt_rt") * 1;

				}
				if ( sheetObjects[0].CellValue(i,"chg_cd") == "ERC"
				  && sheetObjects[0].CellValue(i,"incl_oft_flg") == "N"
				  && saDt >= '20100101'
				  )
				{
					rateErcAmt = rateErcAmt + sheetObjects[0].CellValue(i,"chg_amt_rt") * 1;
				}
				if ( sheetObjects[0].CellValue(i,"chg_cd") == "GRI"
				  && sheetObjects[0].CellValue(i,"incl_oft_flg") == "N"
				  && saDt >= '20100401'
				  )
				{
					rateGriAmt = rateGriAmt + sheetObjects[0].CellValue(i,"chg_amt_rt") * 1;
				}
			}

			var row2 = sheetObjects[3].FindText(0, "TOTAL", 0, 2, false);
			for(var i=1; i<row2; i++){
				if(sheetObjects[3].CellValue(i,"chg_cd") == "FRC"){
					ddctFrcAmt = ddctFrcAmt + sheetObjects[3].CellValue(i,"chg_ddct_amt") * 1;
				}
			}
			
			var chargeAmt = sheetObjects[3].CellValue(row2,4) * 1;
			var row3 = sheetObjects[4].FindText(0, "TOTAL", 0, 2, false);
			var costAmt = sheetObjects[4].CellValue(row3,5) * 1;
			
			//Gross Ocean Revenu setting
			var row4 = sheetObjects[1].RowCount + 1;
			var row6 = sheetObjects[5].RowCount + 1;
			var grossAmt = 0;
			//Gross or Net 
			var grsnetgubun = ""; //grs_net_div_cd
//			var frc_flg = "";
			
			//var actpcd = ""; //ac_tp_cd
			
			case IBSHOWDETAIL:
			if(!validateForm(sheetObj,formObj,sAction))	return false;
		
			//Gross & Net classification
			for(var i=0; i<row6; i++){
//				frc_flg = sheetObjects[5].CellValue(i,2);
				if(sheetObjects[5].CellValue(i,0) == "G"){
					grsnetgubun = sheetObjects[5].CellValue(i,0);

				}else if(sheetObjects[5].CellValue(i,0) == "N" || sheetObjects[5].CellValue(i,0) == ""){
					//grsnetgubun = sheetObjects[5].CellValue(i,0);
					grsnetgubun = "N";
				}
				
				//actpcd = sheetObjects[5].CellValue(i,1);
			}	//End 
			
			//calculating Gross Ocean Revenue.
			for(var i=0; i<row4; i++){
				if(sheetObjects[1].CellValue(i,0) == "Gross Rev(USD)"){
					
					grossAmt = grossAmt + (sheetObjects[1].CellValue(i,"chg_amt") * 1);
					//alert("grossAmt == " + grossAmt);
				}
			} 
							
			if(grossAmt == null) grossAmt = 0;	

			if(oftAmt == null) oftAmt = 0;
			if(rateFrcAmt == null) rateFrcAmt = 0;
			if(rateErcAmt == null) rateErcAmt = 0;
			if(rateGriAmt == null) rateGriAmt = 0;
			if(ddctFrcAmt == null) ddctFrcAmt = 0;
			if(chargeAmt == null) chargeAmt = 0;
			if(costAmt == null) costAmt = 0;
//			if(frc_flg == null) frc_flg = "N";

			//alert(actpcd);
			if(grsnetgubun == "G"){  
				formObj.grsnetcd.value = grsnetgubun;
				//if(actpcd == "G" || actpcd == "C"){ 
					//formObj.grsnetOcnRev.value = new Number(grossAmt-(chargeAmt+costAmt)).toFixed(2);
				//}else{
					formObj.grsnetOcnRev.value = new Number(grossAmt).toFixed(2);
				//}
				ComAddSeparator(formObj.grsnetOcnRev);
				break;
			}else if(grsnetgubun == "N" ||grsnetgubun == ""){
				formObj.grsnetcd.value = "N";
				//alert (frc_flg+' '+rateFrcAmt+' '+ddctFrcAmt);
/*				if (frc_flg != "Y") {  
					rateFrcAmt = 0; 
					ddctFrcAmt = 0;
				}*/
				//if(actpcd == "G" || actpcd == "C"){ 
					//formObj.grsnetOcnRev.value = new Number(oftAmt-(chargeAmt+costAmt)).toFixed(2);
				formObj.grsnetOcnRev.value = new Number(oftAmt-(chargeAmt+costAmt)+rateGriAmt+rateErcAmt+rateFrcAmt+ddctFrcAmt).toFixed(2);
				//}else{
					//formObj.grsnetOcnRev.value = new Number(oftAmt).toFixed(2);
				//}
				ComAddSeparator(formObj.grsnetOcnRev);
				break;
			}


//		case IBSEARCH_ASYNC01:	//Detail
//			if(!validateForm(sheetObj,formObj,sAction))	return false;
//			
//			blno  = formObj.blNo.value;
//			bkgno = formObj.bkgNo.value;
//			agncd = formObj.agnCd.value;
//			iobnd = formObj.ioBnd.value;
//			acseq = formObj.seq.value;
//			arofc = formObj.arOfc.value;
//			
//			var param = "?blNo=" + blno + "&bkgNo=" + bkgno + "&agnCd=" + agncd + "&ioBnd=" + iobnd + "&seq=" + acseq + "&arOfc=" + arofc;
//            //window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:655px");
//            //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
//            pop_center_open("ESM_AGT_011.do" + param, "compop", "800", "600", false);
//            break;
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
	}

	return true;
}
	
