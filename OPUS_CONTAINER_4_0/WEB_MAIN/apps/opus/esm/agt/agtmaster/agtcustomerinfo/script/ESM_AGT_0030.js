// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	/***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;

			case "btn2_Row_Add":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;

			case "btn2_Row_Copy":
				doActionIBSheet(sheetObject,formObject,IBCOPYROW);
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
				style.height = GetSheetHeight(16) ;
				//Whole setting width
				SheetWidth = mainTable.clientWidth;
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;
				//Edit kind [Optional, Default false]
				Editable = true;
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(16, 0 , 0, true);
				// setting function handling header
				InitHeadMode(true, true, false, true, false,false) ;
				var HeadTitle = "Del.|STS|SEQ|F/Forwarder|Name|Shipper|Name";
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//Data  properties    [ROW, COL,   DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",               false,    "",          dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",         false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,     "sSeq",           false,    "",          dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  true,     "cust_cd_seq",    true,    "",           dfNone,     0,          true,       true,       8);
				InitDataProperty(0, cnt++ , dtData,       220,   daLeft,    true,     "cust_nm",        false,    "",          dfNone,     0,          true,      true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  true,     "shpr_cd_seq",    true,    "",           dfNone,     0,          true,       true,       8);
				InitDataProperty(0, cnt++ , dtData,       210,   daLeft,    true,     "shpr_nm",        false,    "",          dfNone,     0,          true,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "fac_ofc_cd",     false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_cnt_cd",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_seq",       false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_cnt_cd",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_seq",       false,    "",          dfNone,     0,          false,      true);
				
					
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_cnt_cd2",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_seq2",       false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_cnt_cd2",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_seq2",       false,    "",          dfNone,     0,          false,      true);
					
				InitDataValid(0, "cust_cd_seq", vtEngUpOther, "0123456789");	// Upper case in English, Number: : Only Possible to Input
				InitDataValid(0, "shpr_cd_seq", vtEngUpOther, "0123456789");	// Upper case in English, Number: : Only Possible to Input

				//CountPosition  = 0 ;
				style.height = GetSheetHeight(13) ;

			}
		break;
	}
}
/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var newRow = -1;

	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0030GS.do", agtQryStr(formObj));
		break;

		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0030GS.do", agtQryStr(formObj));
		break;

		case IBDOWNEXCEL:        //Excel Download
			sheetObj.SpeedDown2Excel(-1);
		break;
				
		case IBINSERT:      // Insert
			if(!chkValidSearch()) return false;
			newRow = sheetObj.DataInsert();
			sheetObj.CellValue(newRow, "fac_ofc_cd") = formObj.fac_ofc_cd.value; // Retrieve 조건의 Office 를 fac_ofc_cd로 설정한다.
		break;

		case IBCOPYROW:        //Row Copy
			sheetObj.DataCopy();
		break;

	}
}

/**
 * Checking mandatoryInsert on Retrieving
 */
function chkValidSearch(){
	var formObj = document.form;
	if (formObj.fac_ofc_cd.value == "") {
		ComShowMessage(ComGetMsg("AGT10001", "Office", "", ""));
		formObj.fac_ofc_cd.focus();
		return false;
	}else {
		return true;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	if (formObj.fac_ofc_cd.value == "") {
		ComShowMessage(ComGetMsg("AGT10001", "Office", "", ""));
		formObj.fac_ofc_cd.focus();
		return false;
	}else {
		return true;
	}
}

/**
 * Grid Insert OnChange Event 
 */
//	function sheet1_OnChange(sheetObj, Row, Col, Value) {
//
//	    with(sheetObj) {
//
//	        var saveNm = ColSaveName(Col);
//
//            if( ColSaveName(Col) == "cust_cd_seq" || ColSaveName(Col) == "shpr_cd_seq" ) {
//
//                var form1 = document.hiddenF;
//                
////               Value = trim(Value);
//                Value = Value;
//
//               if( checkCustomer(Value) == true ) {
//                   form1.f_cmd.value = SEARCH01;
//                   form1.cust_cd.value = Value;
//                   form1.sheetId.value = sheetObj.id;
//                   form1.row.value = Row;
//                   form1.colNm1.value = ColSaveName(Col);
//                   form1.colNm2.value = ColSaveName(Col+1);
//                   form1.target = "frmHidden";
//                   form1.action = "ESM_AGT_CHKCUST.do";
//                   form1.submit();
//
//                   //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
//               } else {
//    			   CellValue2(Row, Col) = "";
//    			   CellValue2(Row, Col+1) = "";
//                   SelectCell(Row, Col);
//               }
//           }
//	    }
//	}

/**
 * Grid Insert OnChange Event
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {

    with(sheetObj) {

        var saveNm = ColSaveName(Col);

        if( ColSaveName(Col) == "cust_cd_seq" ) {

            var form1 = document.hiddenF;

           if( Value.trim() != "" ) {

               if( !/[A-Z]{2}[0-9]{6}/.test(Value) && "000000" != Value && "*000000" != Value ) {
    			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
    			   CellValue2(Row, Col) = "";
    			   CellValue2(Row, parseInt(Col)+1) = "";
                   SelectCell(Row, Col);
               } else {

                   var seq = Value.trim().substring(2);

                   if( seq == 999999 ) {

                       CellValue2(Row, parseInt(Col)+1) = "";

                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value.trim();
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(parseInt(Col)+1);

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       DoRowSearch("ESM_AGT_COM.do", agtQryStr(form1));
                       CellValue2(Row, parseInt(Col)+1) = EtcData("cust_nm");
                   }
               }
           } else {
               CellValue2(Row, parseInt(Col)+1) = "";
           }
       } else if( ColSaveName(Col) == "shpr_cd_seq" ) {

           var form1 = document.hiddenF;

           if( Value.trim() != "" && Value.trim() != "*" ) {

               if( !/[A-Z]{2}[0-9]{6}/.test(Value) && "000000" != Value && "*000000" != Value ) {
    			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
    			   CellValue2(Row, Col) = "";
    			   CellValue2(Row, parseInt(Col)+1) = "";
                   SelectCell(Row, Col);
               } else {

                   var seq = Value.trim().substring(2);

                   if( seq == 999999 ) {

                       CellValue2(Row, parseInt(Col)+1) = "";

                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value.trim();
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(parseInt(Col)+1);

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       DoRowSearch("ESM_AGT_COM.do", agtQryStr(form1));
                       CellValue2(Row, parseInt(Col)+1) = EtcData("cust_nm");
                   }
               }
           } else {
               CellValue2(Row, parseInt(Col)+1) = "";
           }
       }
    }
}


/**
 * Customer Retrieve pop-up open
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	if ( sheetObj.ColSaveName(Col) == "cust_cd_seq" || sheetObj.ColSaveName(Col) == "shpr_cd_seq" ) {
		var ofc_cd = sheetObj.CellValue(Row, "fac_ofc_cd");
		var cust_cd = sheetObj.CellValue(Row, Col);
		
		var width = 775;
		var height = 482;
		var func = "sheet1_setFFCntSeq";
		var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
		var chkStr = dispaly.substring(0,3) ;
		if(ofc_cd == "") {
			ofc_cd = document.form.fac_ofc_cd.value;
		}
		if(ofc_cd == "") {
			if(!chkValidSearch()) return false;
		}
		url = "?ofc_cd="+ofc_cd;
		ComOpenPopup('/opuscntr/COM_ENS_041.do' + url, 770, 470, 'sheet1_setFFCntSeq', dispaly, true, false, Row, Col, 0);
    }
}

/**
 * Save button Validation Process
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
	Value = trim(Value);
	with(sheetObj) {
		var ibStatus = RowStatus(Row);
		if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
			if ( ColSaveName(Col) == "cust_cd_seq" ) {
				if( checkCustomer(Value) == false ) {
					ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
					ValidateFail = true;
					SelectCell(Row, Col);
				}
			} else if( ColSaveName(Col) == "shpr_cd_seq" ) {
				if( checkCustomer(Value) == false ) {
					ComShowMessage(ComGetMsg("AGT10017", "Shipper", "", ""));
					ValidateFail = true;
					SelectCell(Row, Col);
				}
			}
		}
	}
}

/**
* Setting Returned value after Retrieving Customer
*/
function sheet1_setFFCntSeq(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	    
//	var cnt_cd = colArray[3].substring(0, 2);
//	var cust_seq = colArray[3].substring(2);
    	
	if(sheetObj.ColSaveName(col) == "cust_cd_seq"){
		sheetObj.CellValue(row, "cust_cd_seq") = colArray[3];
		sheetObj.CellValue(row, "cust_nm") = colArray[4];
	}
    	
	if(sheetObj.ColSaveName(col) == "shpr_cd_seq"){
		sheetObj.CellValue(row, "shpr_cd_seq") = colArray[3];
		sheetObj.CellValue(row, "shpr_nm") = colArray[4];
	}
}

/**
 * Office Retrieve pop-up open
 */
function openWindowOffice(formObj) {
		
	var url = "COM_ENS_071.do";
	var width = 775;
	var height = 460;
	var func = "setOffice";
	var display = "1,0,1";

	ComOpenPopup(url, width, height, func, display, true);
	
//	ComOpenPopup('/opuscntr/COM_ENS_071.do', width, height, 'setOffice', dispaly, true, false, Row, Col, 0);
}

/**
 * Setting Returned Value after Retrieving Office.
 */
function setOffice(rowArray, row, col) {
	var colArray = rowArray[0];
	document.form.fac_ofc_cd.value = colArray[3];
}