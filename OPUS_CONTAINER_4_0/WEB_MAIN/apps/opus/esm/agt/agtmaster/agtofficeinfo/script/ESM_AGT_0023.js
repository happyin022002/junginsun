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
					InitColumnInfo(13, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|POD|S.Lane|Agent Code|Office||Vendor Code|Vendor Name|Customer Code|Del|pod_cd_real|rlane_cd_real";
//					var HeadTitle = "STS|POD|S.Lane|Agent Code|Office|*|Vendor Code|Vendor Name|Customer Code|Del|*|*";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  	DATATYPE,   WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,      		KEYFIELD,	CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30, daCenter,  false,          "",        false,          "",     dfNone,   		 0,      true,       true);
					InitDataProperty(0, cnt++ , dtStatus,  	30, 	daCenter,  	false,    	"ibflag",       	false,      "",     	dfNone,   	0,     		false,      true);
					InitDataProperty(0, cnt++ , dtData,     70, 	daCenter,   true,    	"pod_cd",        	true,       "", 		dfEngUpKey, 0,      	true,       true,       5);
					InitDataProperty(0, cnt++ , dtData,     70, 	daCenter,   true,  		"slan_cd",        	true,       "", 		dfEngUpKey, 0,      	true,       true,       3);
					InitDataProperty(0, cnt++ , dtData,     90, 	daCenter,   true,    	"agn_cd",        	true,       "", 		dfEngUpKey, 0,      	true,       true,       5);
					InitDataProperty(0, cnt++ , dtData,     80, 	daCenter,   true, 		"agn_finc_ofc_cd",  true,       "", 		dfEngUpKey, 0,     		false,      false,      5);
					InitDataProperty(0, cnt++ , dtHidden,   80, 	daCenter,   true, 		"agn_vndr_cnt_cd",  true,       "", 		dfEngUpKey, 0,     		false,      false);
					InitDataProperty(0, cnt++ , dtData,     100, 	daCenter,   true, 		"agn_vndr_seq",     true,       "", 		dfEngUpKey, 0,      	true,      	true,		6);
					InitDataProperty(0, cnt++ , dtData,     320, 	daLeft,     true, 		"vndr_nm",          false,      "", 		dfEngUpKey, 0,      	false,      false);
					InitDataProperty(0, cnt++ , dtData,     120, 	daCenter,   true, 		"cust_cd",       	true,       "", 		dfEngUpKey, 0,      	true,       true,       8);
                    InitDataProperty(0, cnt++ , dtData,     40, 	daCenter,   true, 		"delt_flg",         false,      "", 		dfEngUpKey, 0,      	false,      false);
//                    
                    InitDataProperty(0, cnt++ , dtHidden,   110, 	daCenter,   true, 		"old_pod_cd",    	false,      "",     	dfNone,     0,      	true,       true);
                  	InitDataProperty(0, cnt++ , dtHidden,   110, 	daCenter,   true, 		"old_slan_cd",  	false,      "",     	dfNone,     0,      	true,       true);
//				
                    InitDataValid(0, "pod_cd", vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
					InitDataValid(0, "slan_cd",vtEngUpOther, "1234567890");	//Upper case in English: : Only Possible to Input
					InitDataValid(0, "agn_cd", vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
	                InitDataValid(0, "agn_vndr_seq", vtNumericOnly, "");//Number: : Only Possible to Input
	                InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");//Upper case in English + Number: : Only Possible to Input
	                InitDataCombo(0, "delt_flg", "Y|N", "Y|N","N");
                    //CountPosition  = 0 ;

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
				sheetObj.DoSearch4Post("ESM_AGT_0023GS.do", agtQryStr(formObj));
				break;
			case IBSAVE:        //Save
			  if(!validateForm(sheetObj,formObj,sAction)) return false;
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_AGT_0023GS.do", agtQryStr(formObj));
                //Save후 Retrieve
//                formObj.f_cmd.value = SEARCH;
//				sheetObj.DoSearch4Post("ESM_AGT_0023GS.do", agtQryStr(formObj));
				break;
		   case IBINSERT:      // Insert
				var Row = sheetObj.DataInsert();
				sheetObj.CellValue2(Row, "agn_finc_ofc_cd") = formObj.agn_finc_ofc_cd.value;
				sheetObj.CellValue2(Row, "delt_flg") = "N";
				sheetObj.SelectCell(Row, 1);
				break;

		   case IBDOWNEXCEL:        //Excel Download
			  sheetObj.SpeedDown2Excel(-1);
			  break;
		}
	}
	

   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		var rt = true;
		var checkRow = sheetObj.SelectRow;
		switch(sAction) {
			case IBSAVE:
				for(var i = 1; i <= sheetObj.RowCount; i ++){
					if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
						var chn_slan_cd_check1 = sheetObj.CellValue(i,"slan_cd");
						var chn_pod_cd_check1 = sheetObj.CellValue(i,"pod_cd");
					}else{
						var chn_slan_cd_check2 = sheetObj.CellValue(i,"slan_cd");
						var chn_pod_cd_check2 = sheetObj.CellValue(i,"pod_cd");
					}
					if(chn_slan_cd_check1 == chn_slan_cd_check2 && chn_pod_cd_check1 == chn_pod_cd_check2){
						    ComShowMessage(ComGetMsg('AGT00083', '"'+chn_pod_cd_check1+"','"+chn_slan_cd_check1+'" '));
//							sheetObj.SelectCell(i, "slan_cd");
				        return false;
					}
				}
				
//				for(var i = 1; i <= sheetObj.RowCount; i ++){
//					if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
//						var chn_agn_cd_check1 = sheetObj.CellValue(i,"agn_vndr_seq");
//					}else{
//						var chn_agn_cd_check2 = sheetObj.CellValue(i,"agn_vndr_seq");
//					}
//					if(chn_agn_cd_check1 == chn_agn_cd_check2){
//						ComShowMessage(ComGetMsg('AGT00080', '"'+chn_agn_cd_check1+'" '));
////						sheetObj.SelectCell(i, "agn_vndr_seq");
//				        return false;
//					}
//				}
			break;
		}

		return rt;
	}
	
	function sheet1_OnChange(sheetObj, row, col) {
		if (sheetObj.ColSaveName(col) == "agn_vndr_cnt_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		
		if (sheetObj.ColSaveName(col) == "cust_cd") {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
			var custCd = sheetObj.CellValue(row, col);
			if(!ComIsAlphabet(custCd.substring(0,2)) || !ComIsNumber(custCd.substring(2))){
				ComShowCodeMessage('AGT00081', 'Customer CD','','');
				sheetObj.CellValue2(row, col) = "";
			}
		}
	}
