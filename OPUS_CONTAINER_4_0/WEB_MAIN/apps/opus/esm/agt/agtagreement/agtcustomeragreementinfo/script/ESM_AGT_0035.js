// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
	    /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
		var sheetObject = sheetObjects[0];
//        var array = new Array();
        
		/*******************************************************/
		var formObject = document.form;
        
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				 case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				 case "btn_ok":
    				popUpOk(sheetObject,formObject);
					break;
					
				 case "btn_close":
					self.close();
					break;
					
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;	
					
				case "btng_rowclear":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
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
		    doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);    
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
					style.height = GetSheetHeight(8) ;
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
					InitColumnInfo(5, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Rdo.|Del.|STS|No|Location";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC,     DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,   30,    daCenter,  false,    "radio",     false,          "",       dfNone,	    0,          true,       true);
					InitDataProperty(0, cnt++ , dtDelCheck,     30,    daCenter,  false,    "check",     false,          "",       dfNone,   	0,          true,       true);
					InitDataProperty(0, cnt++ , dtStatus,       30,    daCenter,  false,    "",          false,          "",       dfNone,   	0,          false,      true);
					InitDataProperty(0, cnt++ , dtSeq,          50,    daCenter,   true,    "",          false,          "",       dfNone,      0,          true,       true);
					InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,    "rout_info_cd",    false,          "",       dfNone,      0,          true,       true,     6);

                    InitDataValid(0, "rout_info_cd", vtEngUpOnly);
				}
				break;

		}
	}

    // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
        var newRow = -1;
        
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0035GS.do", agtQryStr(formObj));			
				break;
				
			case IBINSERT:      // Insert
				sheetObj.DataInsert(); 
				break;
				
			case IBCLEAR:      // Delete
				sheetObj.RowDelete(); 
				break;
								
		}
	}
	
	// Checking whether Data is inserted or not.
	function popUpOk(sheetObj,formObj) {
        if(checkData(sheetObj,formObj)==false) {
            return false;
        }
	    comPopupOK();
	}
	
	// Checking whether Data is inserted or not.
	function checkData(sheetObj,formObj) {
	   	var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var value = "";

		if(rows == 0) {
		    showErrMessage(getMsg("AGT10004", "", "", ""));
		    return false;
		} else {
    		for(var i = 1; i < rows; i++) {
  			    value = trim(sheetObj.CellValue(i, 4));
                if(value == null || value.length == 0) {
                    showErrMessage(getMsg("AGT10001", "Location", "", ""));
                    sheetObj.SelectCell (i, 4);
                    return false;
                }
      		}
		}
		
		return true;
	}
	
	
	function validateForm(sheetObj,formObj,sAction){

		with(formObj){
		   
		}

		return true;
	}
	
	function trim(str) {
		return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
	}
	
