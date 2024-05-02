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
				
			case "btn_rowadd":
			    doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			showErrMessage(getMsg("COM12111", "", ""));
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
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false,false) ;
				
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Del.|STS|SEQ|Office|AR Office|Vendor|Name|Currency";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,  	DATATYPE,   	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   	30,    	daCenter,  	false,    	"",     	false,      "",       	dfNone,   	0,     		true,       true);
				InitDataProperty(0, cnt++ , dtStatus,     	30,    	daCenter,  	false,    	"ibflag",   false,      "",       	dfNone,   	0,     		false,      false);
				InitDataProperty(0, cnt++ , dtSeq,        	50,    	daCenter,   true,    	"seq",   	false,      "",       	dfNone,     0,     		false,      false);
				InitDataProperty(0, cnt++ , dtData, 	    120,    daCenter,   true,    	"ofc_cd",   true,       "",       	dfNone, 	0,     		true,       true,		6);
				InitDataProperty(0, cnt++ , dtData, 	    120,    daCenter,   true,    "ar_ofc_cd",   false,       "",       	dfNone, 	0,     		false,      false);
				InitDataProperty(0, cnt++ , dtPopupEdit, 	120,    daCenter,   true,    	"vndr",     true,      	"",       	dfNone, 	0,     		true,       true,		6);
				InitDataProperty(0, cnt++ , dtData,      	400,    daLeft,     true,    	"name",     false,      "",       	dfNone,     0,     		false,      false,      50);
				InitDataProperty(0, cnt++ , dtCombo,        90,     daCenter,   true,       "curr_cd",   false,      "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"vndr_cd",  true,      	"",       	dfNone, 	0,     		false,      false,		2);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"vndr_seq", true,      	"",       	dfNone, 	0,     		false,      false,		6);
				
				InitDataValid(0, "ofc_cd", vtEngUpOnly, "");	//Upper case in English
                InitDataValid(0, "vndr", vtEngUpOther, "1234567890");	//Upper case in English + Number: : Only Possible to Input
                InitDataCombo(0, "curr_cd", currText, currCode, "USD");
			}
			break;
	}
}

   // handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_046GS.do", agtQryStr(formObj));
			
			break;
			
		case IBSAVE:		//Save
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_046GS.do", agtQryStr(formObj));
			
			formObj.target = "frmHidden";
            formObj.action = "ESM_AGT_046FR.do";
            formObj.submit();
			break;
			
		case IBINSERT:		//Insert
			var Row = sheetObj.DataInsert();
			break;
			
		case IBDOWNEXCEL:	//Excel Download
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}

   /**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (!isNumber(iPage)) {
			return false;
		}
	}

	return true;
}

/**
 * Calling Biz common pop-up from the sheet
 * - comPopupInSheet() call : deliver row, col information to Parameter  
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;

	//Vendor Popup Click
	if (sheetObj.ColSaveName(col) == "vndr") {
        var vndr_cd = sheetObj.CellValue(row,col);
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_0C1";
	    var param = '?vndr_cd=' + vndr_cd;
	    var chkStr = dispaly.substring(0,3);          
        
        if(chkStr == "1,0") {
        	//Radio PopUp  
           	comPopupInSheet('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_046_1', dispaly, row, col);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
        	comPopupInSheet('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row Optional PopUp
        	comPopupInSheet('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }
        */
    }
	
}

/**
 * F.Forwarder(Customer) : In case of single Optional by Radio buttons at Pop-up..
 */
function getESM_AGT_025_1(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    
	var colArray = rowArray[0];
	sheetObj.CellValue(row, col) = colArray[3];
	sheetObj.CellValue(row, col+2) = colArray[4];
}

/**
 * Vendor : In case of single Optional by Radio buttons at Pop-up..
 */
function getESM_AGT_046_1(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    
	var colArray = rowArray[0];
	sheetObj.CellValue2(row, col) = colArray[2];
	sheetObj.CellValue2(row, "vndr_cd") = colArray[7];
	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
	sheetObj.CellValue2(row, "name") = colArray[4];
}

