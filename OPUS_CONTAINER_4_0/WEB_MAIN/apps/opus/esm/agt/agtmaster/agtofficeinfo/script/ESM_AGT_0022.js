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
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
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
				InitColumnInfo(10, 0 , 0, true);
				// setting function handling header
				InitHeadMode(true, true, false, true, false,false) ;
				var HeadTitle = "Del.|STS|SEQ|Agent|Agent Name|Vendor Code|A/R Office|Del|*|*|";
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//Data  properties    [ROW, COL,   DATATYPE,    WIDTH,   DATAALIGN,  COLMERGE, SAVENAME,						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,  30,      daCenter,   false,    "delflag",					false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtStatus,    30,      daCenter,   false,    "ibflag",					false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtSeq,       60,      daCenter,   true,     "sSeq",						false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtData,      100,      daCenter,   true,     "chn_agn_cd",	true,     "",         dfNone,     0,          false,       true,        2);
				InitDataProperty(0, cnt++ , dtData,     480,      daLeft,     true,     "agn_nm",					false,    "",         dfNone,     0,          true,       true,       50);
				//InitDataProperty(0, cnt++ , dtData,      90,      daCenter,   true,     "vndr_seq",    false,    "",         dfNone,     0,          true,       true,        8);
				InitDataProperty(0, cnt++ , dtData,      110,      daCenter,   true,     "vndr_seq",					false,    "",         dfNone,     0,          true,       true,        6);
				InitDataProperty(0, cnt++ , dtData,      110,      daCenter,   true,     "finc_ofc_cd",				false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtCombo,     20,      daCenter,   true,     "delt_flg",					false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    40,      daCenter,   true,     "bkg_blck_flg",				false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    40,      daCenter,   true,     "old_chn_agn_cd",			false,    "",         dfNone,     0,          false,      false);
				
				InitDataValid(0, "chn_agn_cd", vtEngUpOnly);
				InitDataValid(0, "agn_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); // 한글<>/ 제외
				InitDataValid(0, "vndr_seq", vtNumericOnly);	// Number: : Only Possible to Input
				//InitDataValid(0, "vndr_seq", vtEngUpOther, "0123456789");	// Upper case in English, Number: : Only Possible to Input
				InitDataCombo (0,"delt_flg","Y|N","Y|N","N");
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
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0022GS.do", agtQryStr(formObj));
		break;
		case IBSAVE:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0022GS.do", agtQryStr(formObj));				
		break;
		case IBDOWNEXCEL:        //Excel Download
			sheetObj.SpeedDown2Excel(-1);
		break;            
		case IBINSERT:      // Insert
			newRow = sheetObj.DataInsert();
			sheetObj.CellValue(newRow, 6) = formObj.finc_ofc_cd.value; // Setting Control Office to finc_ofc_cd
		break;
				
	}
}
/**
* Sheet1 OnSearchEnd Event Process <br>
* @param  {object} sheetObj	mandatory	 Sheet Object
* @param  {string} ErrMsg		mandatory String
* @return Null
*/ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	with(sheetObj){
		for (var i = 1; i <= LastRow; i ++){
			if ("Y" == CellValue(i, "delt_flg")){
						RowEditable(i) = false;
			}
		}
	}
}
/**
* Sheet1  OnSaveEnd Event Process <br>
* @param  {object} sheetObj	mandatory	 Sheet Object
* @param  {string} ErrMsg		mandatory String
* @return 없음
*/ 
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	with(sheetObj){
		for (var i = 1; i <= LastRow; i ++){
			if ("Y" == CellValue(i, "delt_flg")){
				RowEditable(i) = false;
			}
		}
	}
}
/**
 * Grid OnChange Event 
 */	
function sheet1_OnChange(sheetObj, Row, Col, Value){
	with(sheetObj) {
		if( ColSaveName(Col) == "delflag" ) {
			if(Value == 1) {
				CellValue2(Row, "delt_flg") = "Y";
			} else {
				CellValue2(Row, "delt_flg") = "N";
			}
		}
		
		if( ColSaveName(Col) == "agn_nm" ) {
			sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
		}
		
//		if( ColSaveName(Col) == "chn_agn_cd" ) {
//			CellValue2(Row, "chn_agn_cd") = Value.substring(3);
//		}
	}
}
    
/**
 * Save button Validation Process
 */	
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
//	alert(Value);
//	Value = trim(Value);
	with(sheetObj) {
		var ibStatus = RowStatus(Row);
            if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
            	
            	if( ColSaveName(Col) == "vndr_seq" ) {
            		if (Value == "") {
            			ComShowMessage(ComGetMsg("AGT10001", "Vendor Code", "", ""));
                        ValidateFail = true;
                        SelectCell(Row, Col);
/*                        
                    } else if( Value.length > 2 ) {
        	            var vndr_seq = Value.substring(2, Value.length);
        	            if(isNumber2(vndr_seq) == false) {
                            ComShowMessage(ComGetMsg("AGT10017", "Vendor Code", "", ""));
                            ValidateFail = true;
                            SelectCell(Row, Col);
        	            }
*/        	            
        	        }
        	    }
            }
            
    	}
	}

//mandatory Insert data duplication Check////////////////////////////
function validateForm(sheetObj,formObj,sAction){
	var sheetObject = sheetObjects[0];
	var empty ="";
	var emptyCheck = "";
	var emptySplit = new Array();
	switch(sAction) {
		case IBSAVE:
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var chn_agn_cd_check1 = sheetObj.CellValue(i,"chn_agn_cd");
//					empty = empty+sheetObj.CellValue(i,"chn_agn_cd")+";";
					
				}else{
					var chn_agn_cd_check2 = sheetObj.CellValue(i,"chn_agn_cd");
				}
				
				if(chn_agn_cd_check1 == chn_agn_cd_check2){
					ComShowMessage(ComGetMsg('AGT00080', '"'+chn_agn_cd_check1+'" '));
					sheetObj.SelectCell(i, "chn_agn_cd");
			        return false;
				}
//				emptyCheck = empty;
			}
//			emptySplit = emptyCheck.split(";");
//			if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
//				for(var k=0;k<emptySplit.length-1; k++){
//					var emptySplitValue1 = emptySplit[k]; 
//					
//					for(h=1;h<k+1; h++){
//						var emptySplitValue2 = emptySplit[h];
//						alert(emptySplitValue1+","+emptySplitValue2);
//						if(emptySplitValue2 != ""){
//							
//							if(emptySplitValue1 == emptySplitValue2){
//								ComShowMessage(ComGetMsg('AGT00080', '"'+emptySplitValue1+'" '));
//						        return false;
//							}
//						}
//					}
//					
//				}
//			}
		break;
	}
	return true;
}
///////////////////////////////////////////////////////////////
	