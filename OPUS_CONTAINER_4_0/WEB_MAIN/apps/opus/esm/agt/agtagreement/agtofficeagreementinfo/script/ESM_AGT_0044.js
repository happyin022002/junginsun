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
                case "cnt_btn":         
                	with(formObject)
                	{    	    
                	    var v_cnt_cd = vndr_cnt_cd.value;
                	    var classId = "COM_ENS_0M1";
            		    var param = '?cnt_cd='+v_cnt_cd+'&classId='+classId;
            		    var v_display = "1,0,1,1,1,0,0";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {
            		    	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 565, 480, 'getCOM_ENS_0M1_1', v_display, true);
            		    } else {
            			    return;
            		    }
                	}
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_ok":
				    doActionIBSheet(sheetObject,formObject,COMMAND01);					  
				  break;

				case "btn_close":
					  window.close();
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
					style.height = GetSheetHeight(17) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Chk.|STS|No|Agreement No.|Agreement No.|Vendor|Vendor|Office|Name|Del";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtRadioCheck, 30,    daCenter,  false,  "radio",      false ,         "",       dfNone,   		 0,     true,       true);
 				    InitDataProperty(0, cnt++ , dtHiddenStatus,30,   daCenter,  false, "ibflag",      false,          "",       dfNone,   		 0,     false,      true);
 				    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   true,    "",         false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   true, "agmt_ofc_cty_cd",     false,           "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true, "agn_agmt_seq",    false,           "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   true, "vndr_cnt_cd",     false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true, "vndr_seq",    false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   true, "agmt_ofc_cd",      false,          "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      250,    daLeft,   true, "vndr_lgl_eng_nm", false,      "",       dfNone,          0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true, "delt_flg",    false,          "",       dfNone,          0,     false,      true);
                    //CountPosition  = 0;
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
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0044GS.do", agtQryStr(formObj));
				break;
			
			case COMMAND01:       //Agreement Copy
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = COMMAND01;
				var parameter = agtQryStr(formObj);
				parameter = parameter + '&' + sheetObj.GetSaveString(false);
				var sXml = sheetObj.GetSearchXml("ESM_AGT_0044GS.do", parameter);
				if(sXml.indexOf('<MESSAGE>') < 0)
				{
					comPopupOK();
				}else{
					ComShowMessage(ComGetMsg('AGT00078'));
				}

				break;
		}
	}
	
	function sheet1_OnDblClick(sheetObj, row, col, value) {
        var formObject = document.form;
        var agmt_ofc_cty_cd = sheetObj.CellValue(row, "agmt_ofc_cty_cd");
        var agn_agmt_seq = sheetObj.CellValue(row, "agn_agmt_seq");
//        formObject.agreement_no.value = agmt_cd + agmt_seq;
        /*
        if(sheetObject1.CellValue(row,dibflag") == "R"){
            formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(row,"agn_agmt_ver_seq");
            doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
            formObject.current.value = formObject.agn_agmt_ver_seq.value;
            formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
        }
        */
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
    }

    /**
     * Setting Returned Value after Retieving Office.
     */
    function setOffice(rowArray, row, col) {
    	var colArray = rowArray[0];
    	document.form.s_agmt_ofc_cd.value = colArray[3];
    }
	/**
     * In case of single Optional by Radio buttons at Pop-up..
     */
    function getCOM_ENS_0M1_1(rowArray) {
    	
    	var colArray = rowArray[0];	
    	document.all.vndr_cnt_cd.value = colArray[3];
    }

   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){

		switch(sAction) {

			case IBSEARCH:
        		with(formObj){
                    if (formObj.vndr_cnt_cd.value == "") {
                    	ComShowCodeMessage('AGT10001','Country Code'); 
                       formObj.vndr_cnt_cd.focus();
                       return false;
                    }
        		}
        		break;
		    case COMMAND01:
		    	if(sheetObj.RowCount == 0){
        	    	ComShowCodeMessage('AGT10002','Agent Vendor List');
        	        return false;
        	    }
		        var chkRowCnt = sheetObj.CheckedRows(0);             
        		var chkRow = sheetObj.FindCheckedRow(0);
        		chkRow = chkRow.substr(0, chkRow.length -1);
                
        		if(chkRowCnt > 0){
        		    if(sheetObj.CellValue(chkRow, "agmt_ofc_cty_cd") == "" || sheetObj.CellValue(chkRow, "agn_agmt_seq") == ""){
        		    	ComShowCodeMessage('AGT10010','Agreement No');
        	           return false;
        	        }
        		}else{
        			ComShowCodeMessage('COM12113','checkbox');
        	        return false;
        		}
        	    
		        break;       		
       	}
       				
		return true;
	}
    