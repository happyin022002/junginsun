// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;
var IBDETAILSEARCH     = 20; //corrct

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

				case "btn_ok":
					  comPopupOK();
				  break;

				case "btn_close":
					  window.close();
				  break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
    			showErrMessage(getMsg("COM12111", "", "", ""));
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
        
        //ESM_AGT_003 parameters  Retrieve
        var formObject = document.form;
      	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
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
					style.height = GetSheetHeight(10) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle = "STS|No|CHK|Type|Description";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ ,dtHiddenStatus,30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  false,    "",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   40,    daCenter,  false,    "check",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "cntr_tp_cd",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daLeft,    false,    "cntr_tp_desc",     false,          "",       dfNone,          0,     false,       false);

					CountPosition = 0 ;
				}
				break;
		}
	}

  // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //Retrieve
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch4Post("ESM_AGT_050GS.do", agtQryStr(formObj));				
    			break;
		
		}
	}

