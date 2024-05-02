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

				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_ok":
					comPopupOK();
				  break;

				case "btn_close":
					  window.close();
				  break;


			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
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
		
		var formObject = document.form;
		var sheetObject = sheetObjects[0];		
		if(formObject.agn_seq.value != ""){
            doActionIBSheet(sheetObject,formObject,IBSEARCH);            
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
					style.height = GetSheetHeight(6) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					if(document.form.pageType.value != "Inquiry"){
						Editable = true;
					}else{
						Editable = false;
					}

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|No|Information";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,    "",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,   true,    "",     false,          "",       dfNone,         0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "info_no",     false,          "",       dfNone,         0,     true,       true);
					
					InitDataValid(0, "info_no", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //Insert except in the case of KOREAN
				}
				break;

		}
	}

  // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

		   case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			if(formObj.otr_ref_div_cd.value == "SCNO"){
    			    formObj.f_cmd.value = SEARCH01;
    			}else if(formObj.otr_ref_div_cd.value == "RFAN"){
    			    formObj.f_cmd.value = SEARCH02;
    			}else if(formObj.otr_ref_div_cd.value == "SCOF"){
    			    formObj.f_cmd.value = SEARCH03;
    			}else if(formObj.otr_ref_div_cd.value == "RFAO"){
    			    formObj.f_cmd.value = SEARCH04;
    			}else if(formObj.otr_ref_div_cd.value == "LANE"){
    			    formObj.f_cmd.value = SEARCH05;
    			}else if(formObj.otr_ref_div_cd.value == "VSSL"){
    			    formObj.f_cmd.value = SEARCH06;
    			}
    			sheetObj.DoSearch4Post("ESM_AGT_0037GS.do", agtQryStr(formObj));				
				break;

		   case IBINSERT:      // Insert
				sheetObj.DataInsert();
				break;
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
