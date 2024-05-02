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

				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn2_Row_Copy":
					doActionIBSheet(sheetObject,formObject,IBCOPYROW);
					break;

				case "btn2_Row_Add":
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
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|SEQ|F.Fowarder|Name|Shipper|Name";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "del",            false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false, "ibflag",         false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,   true,    "seq",            false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit, 130,    daCenter,   true, "cust_cd",         true,          "",       dfEngUpKey,     0,     true,       true,          8);
					InitDataProperty(0, cnt++ , dtData,      170,    daLeft,     true, "cust_nm",        false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 130,    daCenter,   true, "shpr_cd",         true,          "",       dfEngUpKey,     0,     true,       true ,         8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     true, "shpr_nm",        false,          "",       dfNone,          0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "cust_cnt_cd",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    170,    daCenter,   true, "cust_seq",       false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "shpr_cnt_cd",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    150,    daCenter,   true, "shpr_seq",       false,          "",       dfNone,          0,     true,       true);
					
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "cust_cnt_cd2",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    170,    daCenter,   true, "cust_seq2",       false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    130,    daCenter,   true, "shpr_cnt_cd2",    false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    150,    daCenter,   true, "shpr_seq2",       false,          "",       dfNone,          0,     true,       true);
                    
                    InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");//Upper case in English + Number: : Only Possible to Input
                    InitDataValid(0, "cust_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //Insert except in the case of KOREAN
                    InitDataValid(0, "shpr_cd", vtEngUpOther, "1234567890");//Upper case in English + Number: : Only Possible to Input
                    InitDataValid(0, "shpr_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //Insert except in the case of KOREAN
                    //CountPosition  = 0;
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
				sheetObj.DoSearch4Post("ESM_AGT_0026GS.do", agtQryStr(formObj));
				break;
				
		   case IBSAVE:		//Save
				if(!validateForm(sheetObj,formObj,sAction))	return false;
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0026GS.do", agtQryStr(formObj));
				break;
								
		   case IBINSERT:		//Insert
				var Row = sheetObj.DataInsert();
				break;

		   case IBCOPYROW:        //Row Copy
			  sheetObj.DataCopy();
			  break;

		   case IBDOWNEXCEL:        //Excel Download
			  sheetObj.SpeedDown2Excel(-1);
			  break;
		}
	}

    function sheet1_OnPopupClick(sheetObj, row, col){
    	var formObj = document.form;
       //F.Forwarder Popup Click   
	    if (sheetObj.ColSaveName(col) == "cust_cd" || sheetObj.ColSaveName(col) == "shpr_cd") {
	        var cust_cd = sheetObj.CellValue(row, col).substring(0,2);
	        if(cust_cd == ""){
	        	cust_cd = formObj.cust_cnt_cd.value
	        }
	        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
	        var classId = "COM_ENS_041";
		    var param = '?cust_cd=' + cust_cd;
			var chkStr = dispaly.substring(0,3) ;         
	        
	        if(chkStr == "1,0") {
	        	// Radio PopUp  
	        	ComOpenPopup('/opuscntr/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_026_1', dispaly, true, false, row, col, 0);
	        //} else if(chkStr == "0,1") {
	            // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
	        	//comPopupInSheet('/opuscntr/COM_ENS_051.do' + param, 770, 470, 'getESM_AGT_025_2', dispaly, sheetIdx, row, col);
	        //} else if(chkStr == "0,0") {
	           	// Row Optional PopUp
	        //	comPopupInSheet('/opuscntr/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_3', dispaly, row, col);
	        } else if(chkStr == "1,1"){
	           	return;
	        } else {
	           	return;
	        }
	    }
    }
    
    /**
	 * F.Forwarder(Customer) : In case of single Optional by Radio buttons at Pop-up..
	 */
	function getESM_AGT_026_1(rowArray, row, col) {
	    var sheetObj = sheetObjects[0];
	    
		var colArray = rowArray[0];
//		alert(colArray[3]+":"+colArray[4]);
		if(sheetObj.ColSaveName(col) == "cust_cd"){
			sheetObj.CellValue(row, "cust_cd") = colArray[3];
			sheetObj.CellValue(row, "cust_nm") = colArray[4];
		}
		
		if(sheetObj.ColSaveName(col) == "shpr_cd"){
			sheetObj.CellValue(row, "shpr_cd") = colArray[3];
			sheetObj.CellValue(row, "shpr_nm") = colArray[4];
		}
	}

   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
		}

		return true;
	}
	
	function sheet1_OnChange(sheetObj, row, col) {
		if (sheetObj.ColSaveName(col) == "cust_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
		if (sheetObj.ColSaveName(col) == "shpr_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
	}
	
