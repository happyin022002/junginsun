// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;
var sRow = 0;

/*
 *Event handler processing by button click event
 */
document.onclick = processButtonClick;

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
function loadPage(account_code, account_name) {
    for(i=0;i<sheetObjects.length;i++){
        //Changing Start Environment Setting Method's Name
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1,account_code, account_name);

        //Adding Last Environment Setting method
        ComEndConfigSheet(sheetObjects[i]);
    }

    // Subj.Month Date Setting
    var formObj = document.form;
    formObj.comm_yrmon.value = ComGetNowInfo("ym");
    
    // Retrieving AR_OFC on loading the first page
    if(formObj.ar_ofc_cd.value != ""){
        ar_ofc_cd_OnChange();
    }   
    
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,account_code,account_name) {
    var cnt = 0;
    var formObj = document.form;    
    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                //setting height
                style.height = GetSheetHeight(15);

                //Whole setting width
                SheetWidth = mainTable.clientWidth;

                //setting Host information[mandatory][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //Whole Merge kind [Optional, Default msNone]
                MergeSheet = msHeaderOnly;

                //Edit kind [Optional, Default false]
                Editable = true;

                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(27, 5, 0, true);

                //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false, false);

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                var HeadTitle = "DEL|STS|CHK|No.|Acct.|Description|vdCnt|Office|Vendor|Name|City|Center|Apply\nDate|VVD|Cur|PYMT AMT|Ex. Rate|USD AMT|Approval\nDate|bkgNo|bkgNoS|agnCd|bndCd|tpCd|acSeq|Status|Remarks";
                InitHeadRow(0, HeadTitle, true);

                //Data  properties    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtDelCheck,  40,    daCenter,  false,    "del",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
                InitDataProperty(0, cnt++, dtCheckBox,  40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtSeq,       30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtCombo,     60,    daCenter,  true,     "comm_stnd_cost_cd",   false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "otr_comm_acct_ctnt",   true,     "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "vndr_cnt_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtPopup,      60,    daCenter,  true,     "ofc_cd",  false,    "",         dfNone,     0,         false,      true);
				InitDataProperty(0, cnt++, dtPopup,     70,    daCenter,  true,     "vndr_seq",  false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "vndr_lgl_eng_nm",   false,    "",         dfNone,     0,          false,      false);                
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_occr_info_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "ap_ctr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "aply_dt", true,     "",         dfDateYmd,  0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      90,    daCenter,  true,     "vvd",    true,     "",         dfNone,     0,          true,       true, 10);
                InitDataProperty(0, cnt++, dtCombo,     45,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_locl_comm_amt", true,     "",         dfFloat,    2,          true,       true);
                InitDataProperty(0, cnt++, dtData,      60,    daRight,   true,     "mon_xch_rt",  false,    "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_comm_amt", true,     "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "ac_apro_dt", false,    "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkgNoS", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_tp_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_proc_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daLeft,    true,     "comm_proc_sts_rsn", false,    "",         dfNone,     0,          false,      false);
				
				//Setting Column properties
				InitDataValid(0, "otr_comm_acct_ctnt",  vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?");	//Description column : English + Number + special key: : Only Possible to Input
                //InitDataValid(0, "ofc_cd", vtEngUpOther, "");			//Office 컬럼은 Upper case in English: : Only Possible to Input
                //InitDataValid(0, "vndr_seq", vtEngUpOther, "1234567890");	//Upper case in English + Number: : Only Possible to Input
                InitDataCombo(0, "curr_cd", currText, currCode, "USD");
                //Setting Combo properties
                //InitDataCombo(0, "acct", "512611|512621|512631|512641|512661|512691", "512611|512621|512631|512641|512661|512691","512691");
                //InitDataCombo(0, "acct", "512691", "512692","512693");
                InitDataCombo(0, "comm_stnd_cost_cd", account_code, account_code);
                //Whole Optional event doesn't occur
                AllowEvent4CheckAll = false; 
                
                CountPosition = 0;                
                
            }
            break;
    }
}

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

            case "btn_save":
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

            case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
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
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}

/*
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //Retrieve

            if(!validateForm(sheetObj,formObj,sAction)) return false;
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0042GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,4) = "TOTAL";
            break;

        case IBSAVE:        //Save
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESM_AGT_0042GS.do", agtQryStr(formObj));
            
            //Save후 재Retrieve
//            formObj.f_cmd.value = SEARCH;
//            sheetObj.DoSearch4Post("ESM_AGT_042GS.do", agtQryStr(formObj));
//            sheetObj.SumText(0,1) = "";
//            sheetObj.SumText(0,4) = "TOTAL";
            break;

		case IBSEARCH_ASYNC03:	//Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0042GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,1) = "";
			sheetObj.SumText(0,4) = "TOTAL";
			break;
		
        case IBDOWNEXCEL:	//Excel Download
			sheetObj.SpeedDown2Excel(-1);
			break;
			
		case IBINSERT:      //Adding Row
            if(!validateForm(sheetObj,formObj,sAction)) return false;
           
            formObj.gubun.value = "IN";
            
            //At the forst row of the Grid Adding Row
            var insRow = sheetObj.DataInsert(0);
            var yyyymm = ComTrimAll(formObj.comm_yrmon.value,'-');
            var currCombo = "USD|" + formObj.param8.value;
            sRow = insRow;
            sheetObj.CellValue2(insRow, "vndr_cnt_cd") = formObj.param3.value;
            sheetObj.CellValue2(insRow, "vndr_seq") = formObj.param4.value;
            sheetObj.CellValue2(insRow, "vndr_lgl_eng_nm")  = formObj.param5.value;
            sheetObj.CellValue2(insRow, "ofc_cd") = formObj.param6.value;
            sheetObj.CellValue2(insRow, "comm_occr_info_cd")  = formObj.param7.value;
            sheetObj.CellValue2(insRow, "ap_ctr_cd")  = formObj.param8.value;
            sheetObj.CellValue2(insRow, "curr_cd")  = formObj.param9.value;
            sheetObj.CellValue2(insRow, "mon_xch_rt") = formObj.param10.value;
            sheetObj.CellValue2(insRow, "vvd")   = "CNTC" + yyyymm.substring(2,6) + "MM";
            sheetObj.CellValue(insRow, "aply_dt") = ComGetNowInfo();
            sheetObj.SumText(0,1) = "";
            sheetObj.SumText(0,4) = "TOTAL";
            sheetObj.SelectCell(insRow, "otr_comm_acct_ctnt");
            break;
    }
	
	//Showing the color according to the status
	var rows = sheetObj.RowCount;
	for(var i=0; i<rows; i++){
		sts = sheetObj.CellValue(i+1,"comm_proc_sts_cd");
		if(sts == "IC"){
			sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
		}
	}
}

/**
 * Retrieving Vendor, Vendor Name, Office, City, Cente information on changing A/R Office
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];
    var arOfcCd = formObj.ar_ofc_cd.value;

    formObj.param1.value = arOfcCd;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0042FR.do";
    formObj.submit();
    
    //Grid  Initialization
    sheetObj.RemoveAll();
}

/*
 * Office information check
 */
function checkOfficeInfo(){
    var formObj = document.form;
	var vendor = formObj.param4.value;
    var arOfcCd = formObj.ar_ofc_cd.value;

    if(vendor == ""){
    	ComShowMessage(ComGetMsg("AGT10025", arOfcCd, "", ""));
    	formObj.ar_ofc_cd.value = "";
    	formObj.param1.value = "";
    }
}

/*
 * Implementing on changing column value at the Grid
 */
function sheet1_OnChange(sheetObj, row, col) {
	var formObj = document.form;
	var colNm =	sheetObj.ColSaveName(col);
	var yyyymm = ComTrimAll(formObj.comm_yrmon.value, '-');

//    if(sheetObj.CellValue(row, "iflag") == "I"){
//        if(formObj.office_code.value.length == 6){
//            sheetObj.CellEditable(row, "vndr_seq") = true;
//            sheetObj.CellEditable(row, "curr_cd") = true;
//        }
//    }
	
    if(colNm == "vvd"){
       // if(!validateForm(sheetObj,formObj,IBINSERT)) return false;
        sRow = row;
        var vvd = sheetObj.CellValue(row, "vvd");
        var vvdLen = vvd.length;
        if(vvdLen < 10 ){          
          ComShowMessage(ComGetMsg("AGT10017", "VVD", "", ""));
          sheetObj.SelectCell(row,"vvd",true,"CNTC" + yyyymm.substring(2,6) + "MM");
          return false;
        }
        
        if(vvd.substring(0,4) != "CNTC" ){     
          ComShowMessage(ComGetMsg("AGT10017", "VVD", "", ""));
          sheetObj.SelectCell(row,"vvd",true,"CNTC" + yyyymm.substring(2,6) + "MM");
          return false;
        }
        

    }
    
    if(colNm == "ofc_cd"){
        if(!validateForm(sheetObj,formObj,IBINSERT)) return false;
        sRow = row;
        var arOfcCd = sheetObj.CellValue(row, "ofc_cd");
        formObj.gubun.value = "RE";
        
        formObj.param1.value = arOfcCd;
        formObj.target = "frmHidden";
        formObj.action = "ESM_AGT_0042FR.do";
        formObj.submit();

    } 
	
	/*
	if(colNm == "aply_dt"){
		sRow = row;
		var aply_dt = sheetObj.CellValue(row, "aply_dt");
		formObj.param1.value = sheetObj.CellValue(row, "ofc_cd");
		formObj.gubun.value = "IN";
		
		formObj.param2.value = aply_dt;
	    formObj.target = "frmHidden";
	    formObj.action = "ESM_AGT_0042FR2.do";
	    formObj.submit();
	}
	*/
	// Resetting xchRt on changing Cur
	if(colNm == "aply_dt" || colNm == "curr_cd"){
	    sRow = row;
	    var curr = sheetObj.CellValue(row, "curr_cd");
	    var aplyDt = sheetObj.CellValue(row, "aply_dt");
	    formObj.gubun.value = "IN";
	    
	    formObj.param2.value = aplyDt;
	    formObj.param9.value = curr;
	    formObj.target = "frmHidden";
	    formObj.action = "ESM_AGT_0042FR2.do";
	    formObj.submit();
	    
	}
	
	//Recalculating USD AMT on changing LCL AMT
	if(colNm == "act_locl_comm_amt"){
		sheetObj.CellValue2(row, "act_comm_amt") = sheetObj.CellValue(row, "act_locl_comm_amt") / sheetObj.CellValue(row, "mon_xch_rt");
	}
	
	//Recalculating LCL AMT on changing USD AMT
	if(colNm == "act_comm_amt"){
		sheetObj.CellValue2(row, "act_locl_comm_amt") = sheetObj.CellValue(row, "act_comm_amt") * sheetObj.CellValue(row, "mon_xch_rt");
	}
	
	formObj.gubun.value = "IN";
}

/*
 * Setting the CUR to Grid
 */
function setXchRt(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.param1.value;
	var mon_xch_rt = formObj.param10.value;
	
	if(mon_xch_rt == "" || mon_xch_rt == "0"){
    	ComShowMessage(ComGetMsg("AGT10026", arOfcCd, mon_xch_rt, ""));
    }else{
    	sheetObj.CellValue2(sRow, "mon_xch_rt") = mon_xch_rt;
    	
    	var act_locl_comm_amt = sheetObj.CellValue(sRow, "act_locl_comm_amt");
    	var act_comm_amt = sheetObj.CellValue(sRow, "act_comm_amt");
    	
    	if(act_comm_amt > 0){
    		sheetObj.CellValue2(sRow, "act_locl_comm_amt") = act_comm_amt * mon_xch_rt;
    	}else{
    		sheetObj.CellValue2(sRow, "act_comm_amt") = act_locl_comm_amt / mon_xch_rt;
    	}
	}
}

/*
 * Setting the CUR to Grid
 */
function setValue(){    
    
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.ar_ofc_cd.value;
	var mon_xch_rt = formObj.param10.value;
	
	var yyyymm = removeDash(formObj.comm_yrmon.value);
    var currCombo = "USD|" + formObj.param8.value;
	
	sheetObj.CellValue2(sRow, "vndr_cnt_cd") = formObj.param3.value;
    sheetObj.CellValue2(sRow, "vndr_seq") = formObj.param4.value;
    sheetObj.CellValue2(sRow, "vndr_lgl_eng_nm")  = formObj.param5.value;
    sheetObj.CellValue2(sRow, "ofc_cd") = formObj.param6.value;
    sheetObj.CellValue2(sRow, "comm_occr_info_cd")  = formObj.param7.value;
    sheetObj.CellValue2(sRow, "ap_ctr_cd")  = formObj.param8.value;
    sheetObj.CellValue2(sRow, "curr_cd")  = formObj.param9.value;
    sheetObj.CellValue2(sRow, "mon_xch_rt") = formObj.param10.value;
    sheetObj.CellValue2(sRow, "vvd")   = "CNTC" + yyyymm.substring(2,6) + "MM";
    sheetObj.CellValue(sRow, "aply_dt") = ComGetNowInfo();
    sheetObj.SumText(0,1) = "";
    sheetObj.SumText(0,4) = "TOTAL";
    sheetObj.SelectCell(sRow, "otr_comm_acct_ctnt");
    
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!isNumber(iPage)) {
//            return false;
//        }

        switch(sAction) {
            case IBSEARCH:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
                break;

            case IBSAVE:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }

                var cnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");
                if(cnt < 1){
                    ComShowMessage(ComGetMsg("AGT10010", "", "", ""));
                    return false;
                }
                break;

			case IBSEARCH_ASYNC03:	//Request
				if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
                
                //Status check
				var rows = sheetObj.RowCount;
				for(var i=0; i<rows; i++) {
					if(sheetObj.CellValue(i+1,"chk") == 1){
				    	status = sheetObj.CellValue(i+1,"comm_proc_sts_cd");
				    	if(status != "CS" && status != "CA"){
				    		ComShowMessage(ComGetMsg("AGT10028", i+1, "Request", ""));
							return false;
						}
		     		}
		  		}
		  		break;

            case IBINSERT:
                if(ar_ofc_cd.value == ""){
                    ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
                    formObj.ar_ofc_cd.focus();
                    return false;
                }
                break;
        }
    }

    return true;
}

/**
 * Calling Biz common pop-up from the sheet
 * - ComOpenPopup() call : sending row, col information to the Parameter  
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;

	//Vendor Popup Click
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
        var vndr_cd = sheetObj.CellValue(row,col);
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_0C1";
	    var param = '?vndr_cd=' + vndr_cd + '&ofc_cd=N';
	    var chkStr = dispaly.substring(0,3);          
        if(chkStr == "1,0") {
        	//Radio PopUp  
           	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 705, 470, 'getESM_AGT_0042_1', dispaly, true, false, row, col, 0);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
        	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row Optional PopUp
        	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }
        */
    }else if (sheetObj.ColSaveName(col) == "ofc_cd") {
        var ofc_cd = sheetObj.CellValue(row,col);
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_071";
        var sheet = "1";
        var ofc_pts_cd = "N";
    	var param = '?sheet='+sheet+'&classId='+classId+'&ofc_cd='+ofc_cd+"&ofc_pts_cd="+ofc_pts_cd;    	
	    var chkStr = dispaly.substring(0,3);          
        
        if(chkStr == "1,0") {
        	//Radio PopUp  
           	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 470, 'getESM_AGT_0042_2', dispaly, true, false, row, col);
        	//ComOpenPopup('/opuscntr/ESM_AGT_0047.do' + param, 770, 470, '', dispaly, true, false, row, col);
        } 
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
        	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row Optional PopUp
        	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
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
 * Vendor : In case of single Optional by Radio buttons at Pop-up..
 */
function getESM_AGT_0042_1(rowArray, row, col, sheetIdx) {
    var sheetObj = sheetObjects[0];
    sRow = row;
	var colArray = rowArray[0];
	sheetObj.CellValue2(row, col) = colArray[2];
	sheetObj.CellValue2(row, "vndr_cd") = colArray[7];
	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
	sheetObj.CellValue2(row, "vndr_lgl_eng_nm") = colArray[4];
}

/**
 * COM_ENS_071 : Only one is checked to Optional at the Pop-up..
 */
function getESM_AGT_0042_2(rowArray, row, col) {
 	
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
    var arrayLen = rowArray.length;
    var cellVal = "";
    sRow = row;

    var colArray = rowArray[0];
	sheetObj.CellValue2(row, "ofc_cd") = colArray[3];
//	sheetObj.CellValue2(row, "vndr_lgl_eng_nm") = colArray[4];

//	if(!validateForm(sheetObj,formObj,IBINSERT)) return false;

    var arOfcCd = sheetObj.CellValue(row, "ofc_cd");
    formObj.gubun.value = "RE";
    
    formObj.param1.value = arOfcCd;
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0042FR.do";
    formObj.submit();

}
