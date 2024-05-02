// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
				
			case "btng_rowadd":
			    doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ShowErrMessage(getMsg("COM12111", "", ""));
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
	    //khlee-Changing Start Environment Setting Method's Name
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	    
	    //khlee-Adding Last Environment Setting method
		ComEndConfigSheet(sheetObjects[i]);
	}
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
				style.height = GetSheetHeight(15) ;
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			   //Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 16, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// setting function handling header
				InitHeadMode(true, true, false, true, false, false) ;

				var HeadTitle = "STS|Vessel|Agent Code|A/R Office|*|Vendor Code|Customer Code|Delete";

				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   			KEYFIELD, CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtStatus,   50,    daCenter,  false,    "ibflag",			false,    "",         dfNone,		0,     		false,      true);
				InitDataProperty(0, cnt++, dtData,     120,    daCenter,  true,     "vsl_cd",			true,     "",         dfNone,		0,     		false,      true,		4);
				InitDataProperty(0, cnt++, dtData,     150,   daCenter,  true,     "agn_cd",			false,    "",         dfNone,		0,     		true,       true,		6);
				InitDataProperty(0, cnt++, dtData,     150,   daCenter,  true,     "agn_finc_ofc_cd",	false,    "",         dfNone,		0,     		false,      false,		6);
				InitDataProperty(0, cnt++, dtHidden,   100,   daCenter,  true,     "agn_vndr_cnt_cd",	false,    "",         dfNone,		0,     		false,      false);
				InitDataProperty(0, cnt++, dtData,     200,   daCenter,  true,     "agn_vndr_seq",		false,    "",         dfNone,		0,     		true,       true,		6);
				InitDataProperty(0, cnt++, dtData,     200,   daCenter,  true,     "cust_cd",			false,    "",         dfNone,		0,     		true,       true,		8);
				InitDataProperty(0, cnt++, dtCombo,    60,    daCenter,  false,    "delt_flg",			false,    "",         dfNone,		0,     		true,       true);
				
				InitDataValid(0, "vsl_cd", vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
                InitDataValid(0, "agn_cd", vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
//                InitDataValid(0, "agn_vndr_seq", vtEngUpOther, "1234567890");//Upper case in English + Number: : Only Possible to Input
                InitDataValid(0, "agn_vndr_seq", vtNumericOnly, "");
                InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");//Upper case in English + Number: : Only Possible to Input
                InitDataCombo(0, "delt_flg", "Y|N", "Y|N","N");
			}
			break;
	}
}

   // handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:	  //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0024GS.do", agtQryStr(formObj));
			break;
			
		case IBSAVE:		//Save
			if(!validateForm(sheetObj,formObj,sAction))	return false;

			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0024GS.do", agtQryStr(formObj));
			break;
			
		case IBINSERT:	  //Insert
			var Row = sheetObj.DataInsert();
			sheetObj.CellValue2(Row, "agn_finc_ofc_cd") = formObj.agn_finc_ofc_cd.value;
			sheetObj.SelectCell(Row, "vsl_cd");	
			break;
			
		case IBDOWNEXCEL:  //Excel Download
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}
	
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	var Row = sheetObj.SelectRow;
	switch(sAction) {
		case IBSAVE:
			var cust_cd = sheetObj.CellValue(Row, "cust_cd");
			var agn_vndr_seq = sheetObj.CellValue(Row, "agn_vndr_seq");
			
			if (agn_vndr_seq == "") {
				ComShowMessage(ComGetMsg("AGT10001", "Vendor Code", "", ""));
				ValidateFail = true;
				SelectCell(Row, "agn_vndr_seq");
			}
			
			if (cust_cd == "") {
				ComShowCodeMessage("AGT10001", "Customer Code", "", "");
				ValidateFail = true;
				SelectCell(Row, "cust_cd");
			}
		
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var vsl_cd_check1 = sheetObj.CellValue(i,"vsl_cd");
				}else{
					var vsl_cd_check2 = sheetObj.CellValue(i,"vsl_cd");
				}
				if(vsl_cd_check1 == vsl_cd_check2){
					ComShowMessage(ComGetMsg('AGT00080', '"'+vsl_cd_check1+'" '));
					sheetObj.SelectCell(i, "vsl_cd");
			        return false;
				}
			}
		break;
	}
		
	return true;
//	with(formObj){
//	    if (!ComIsNumber(iPage)) {
//	        return false;
//	    }
//	}
//
//	return true;
}

function sheet1_OnChange(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "cust_cd") {
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		var custCd = sheetObj.CellValue(row, col);
		if(!ComIsAlphabet(custCd.substring(0,2)) || !ComIsNumber(custCd.substring(2))){
			ComShowCodeMessage('AGT00081', 'Customer CD','','');
			sheetObj.CellValue2(row, col) = "";
		}
	}
}

//Save 
//function sheet1_OnSaveEnd(sheetObj, ErrMsg){
//	if(ErrMsg == ""){
//		ComShowMessage(ComGetMsg('AGT00079','Success!'));
//	}else{
//		ComShowMessage(ComGetMsg('AGT00079','Fail!'));
//	}
//}
	