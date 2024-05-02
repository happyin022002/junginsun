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
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //Changing Start Environment Setting Method's Name
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);

        //Adding Last Environment Setting method
        ComEndConfigSheet(sheetObjects[i]);
    }

    // Subj.Month Date Setting
    var formObj = document.form;
    formObj.comm_yrmon.value = ComGetNowInfo("ym" ) 
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
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //Whole Merge kind [Optional, Default msNone]
                MergeSheet = msHeaderOnly;

                //Edit kind [Optional, Default false]
                Editable = true;

                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(23, 5, 0, true);

                //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false, false);

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                var HeadTitle = "STS|CHK|No.|Acct.|Description|Vendor|Name|Office|City|Center|Apply\nDate|VVD|Cur|PYMT AMT|Ex. Rate|USD AMT|Approval\nDate|||||Status|Remark";
                InitHeadRow(0, HeadTitle, true);

                //Data  properties    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
                InitDataProperty(0, cnt++, dtCheckBox,  40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtSeq,       30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          true,       true);
                InitDataProperty(0, cnt++, dtData,      60,    daCenter,  true,     "comm_stnd_cost_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "otr_comm_acct_ctnt",   true,     "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "vndr_seq",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      150,   daLeft,    true,     "ofc_eng_nm",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      60,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_occr_info_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "ap_ctr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "aply_dt", true,     "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,     "vvd",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,      40,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_if_locl_comm_amt", true,     "",         dfFloat,    2,          true,       true);
                InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "mon_xch_rt",  false,    "",         dfFloat,    2,          false,      false);
                InitDataProperty(0, cnt++, dtAutoSumEx, 80,    daRight,   true,     "act_if_comm_amt", true,     "",         dfFloat,    2,          false,       false);
                InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,     "ac_apro_dt", false,    "",         dfDateYmd,  0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "bkgNoS", false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_tp_cd",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
//                InitDataProperty(0, cnt++, dtHidden,    70,    daCenter,  true,     "vndr_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      50,    daCenter,  true,     "comm_proc_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daLeft,    true,     "comm_proc_sts_rsn", false,    "",         dfNone,     0,          false,      false);
				
				//Setting Column  properties
				InitDataValid(0, "otr_comm_acct_ctnt",  vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?");	//Description column : English + Number + special key: : Only Possible to Input
                //InitDataValid(0, "ofcCd", vtEngUpOther, "");			//Office column : Upper case in English: : Only Possible to Input

                //Setting Combo properties
                //InitDataCombo(0, "acct", "512611|512621|512631|512641|512661|512691", "512611|512621|512631|512641|512661|512691","512691");
                //InitDataCombo(0, "curr", "USD", "USD", "USD");
                
                //Whole Optional event doesn't occur
                AllowEvent4CheckAll = false; 
                
                CountPosition  = 0 ;
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

            case "btn_reject":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;

			case "btn_audit":
                doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
                break;

            case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
				break;

            case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
        case IBSEARCH:      //retrieve
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = SEARCH;
//            alert(agtQryStr(formObj));
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBSAVE:        //save
            if(!validateForm(sheetObj,formObj,sAction)) return false;

            formObj.f_cmd.value = MULTI;
            sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
            
            //Save후 재Retrieve
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBSEARCH_ASYNC01:	//reject
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBSEARCH_ASYNC02:  //Approval
            if(!validateForm(sheetObj,formObj,sAction)) return false;

			//sbOfc
			var chkRow = sheetObj.FindCheckedRow("chk");
			var arrRow = chkRow.split("|");
			sbOfc = sheetObj.CellValue(arrRow[0],"agn_cd");
			var expType = formObj.exp_type.value;
            scnId = "OTHER";
            arOfc = formObj.ar_ofc_cd.value;
            sbOfc = formObj.s_agn_cd.value;
            var comm_yrmon = formObj.comm_yrmon.value;
            saDate = comm_yrmon.replace('-','')+ "31";
            var rArray = getCheckedRows(sheetObj, "chk");
            
            var args = new Array();
  			args["scnId"] = scnId;
			args["arOfc"] = arOfc;
			args["sbOfc"] = sbOfc;
			args["saDate"] = saDate;
			args["expType"] = expType;
			args["bkg_no"] = sheetObj.CellValue(arrRow[0],"bkg_no");
			args["io_bnd_cd"] = sheetObj.CellValue(arrRow[0],"io_bnd_cd");
			args["ac_tp_cd"] = sheetObj.CellValue(arrRow[0],"ac_tp_cd");
			args["acSeq"] = sheetObj.CellValue(arrRow[0],"ac_seq");
			args["sheet"] = rArray.toString();
			
			window.showModalDialog("ESM_AGT_0036.do", args, "scroll:no");
            //Retrieve after Approval
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
            break;

        case IBCLEAR:	//cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESM_AGT_0016GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,3) = "TOTAL";
			break;
		
		case IBDOWNEXCEL:	//excel down
			sheetObj.SpeedDown2Excel(-1);
			break;
    }
}

/*
 * Retrieving key value of Optional row(s) for Approval
 */
function getCheckedRows(sheetObj, colName) {
    var checkRows;
    var colsCnt = sheetObj.LastCol + 1;
    var rows = sheetObj.Rows;
    var rArray = null; //Array having Row data
    var bkg_no;
    var bkg_no_tmp;
    var bkg_no_len = 0;

    checkRows = sheetObj.CheckedRows(colName);

    if(checkRows == 0){
        return null;
    }else{
        var idx = 0;
        rArray = new Array(checkRows);

        for(var i=0; i<rows; i++) {
            if(sheetObj.CellValue(i,colName) == 1) {
                //rArray[idx++] = sheetObj.CellValue(i,"bkgNo") + sheetObj.CellValue(i,"agnCd") + sheetObj.CellValue(i,"bndCd") + sheetObj.CellValue(i,"acSeq");
                bkg_no = "";
			    bkg_no_split = "  ";
			    bkg_no_tmp = "";
                bkg_no_len = 0;
                bkg_no_tmp = sheetObj.CellValue(i,"bkg_no");
                bkg_no_len = bkg_no_tmp.length;
                
                if(bkg_no_len > 11){
                    bkg_no = bkg_no_tmp.substring(0,11);
                	bkg_no = bkg_no_tmp;
//                    bkg_no_split = bkg_no_tmp.substring(11,13);
                }else{
                    bkg_no = bkg_no_tmp;
//                    bkg_no_split = "  ";
                }
                
//                rArray[idx++] = bkg_no + "_" + bkg_no_split + "_"+ sheetObj.CellValue(i,"agn_cd") + "_"  + sheetObj.CellValue(i,"io_bnd_cd") + "_"  + sheetObj.CellValue(i,"ac_seq");
                rArray[idx++] = bkg_no + sheetObj.CellValue(i,"agn_cd") + sheetObj.CellValue(i,"io_bnd_cd") +  sheetObj.CellValue(i,"ac_seq");
            }
        }

        return rArray;
    }
}

/**
 * Retrieving Vendor, Vendor Name, Office, City, Cente information on changing A/R Office
 */
function cbArOfcCd_OnChange(obj){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
    
//    var arOfcCd = formObj.cbArOfcCd.value;
    var arOfcCd = formObj.ar_ofc_cd.value;
    formObj.param1.value = arOfcCd;
//    formObj.param3.value = "cbSbOfcCd";
    formObj.param3.value = "s_agn_cd";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0016FR.do";
    formObj.submit();
    
    //Grid Initialization
    sheetObj.RemoveAll();
}

/**
 * Initializing the grid on changing Subject Office.
 */
function cbSbOfcCd_OnChange(obj){
    var sheetObj = sheetObjects[0];
    
    //Grid Reset
	sheetObj.RemoveAll();
}

/*
 * Checking Office information
 */
function checkOfficeInfo(){
    var formObj = document.form;
	var vendor = formObj.param3.value;

    if(vendor == ""){
    	ComShowMessage(ComGetMsg("AGT10025", arOfcCd, "", ""));
    	formObj.cbArOfcCd.value = "";
    	formObj.param1.value = "";
    }
}

/*
 * Implementing on changing column value at the Grid
 */
function sheet1_OnChange(sheetObj, row, col) {
	var formObj = document.form;
	
	var comm_proc_sts_cd = sheetObj.CellValue(row,"comm_proc_sts_cd");
	var colNm =	sheetObj.ColSaveName(col);
	
	//Impossible to modify or delete for already approved rows
	if(comm_proc_sts_cd == "AS" || comm_proc_sts_cd == "IF"){
		if(colNm != "chk"){
			showErrMessage(getMsg("AGT10011", "", "", ""));
			sheetObj.ReturnCellData(row, "comm_stnd_cost_cd");
			sheetObj.ReturnCellData(row, "otr_comm_acct_ctnt");
			sheetObj.ReturnCellData(row, "aply_dt");
			sheetObj.ReturnCellData(row, "vvd");
			sheetObj.ReturnCellData(row, "curr_cd");
			sheetObj.ReturnCellData(row, "act_if_locl_comm_amt");
			sheetObj.ReturnCellData(row, "act_if_comm_amt");
			return;
		}
	
	}else{
		//Apply Date is changed then reset xchRt
		if(colNm == "aply_dt"){
			sRow = row;
			var aplyDt = sheetObj.CellValue(row, "aply_dt");
			
			formObj.param2.value = aplyDt;
		    formObj.target = "frmHidden";
		    formObj.action = "ESM_AGT_0016FR2.do";
		    formObj.submit();
		}
		
		//LCL AMT is changed then recalculate USD AMT
		if(colNm == "act_if_locl_comm_amt"){
			sheetObj.CellValue2(row, "act_if_comm_amt") = sheetObj.CellValue(row, "act_if_locl_comm_amt") / sheetObj.CellValue(row, "mon_xch_rt");
		}
				
		//USD AMT is changed then recalculate LCL AMT
		if(colNm == "act_if_comm_amt"){
			sheetObj.CellValue2(row, "act_if_locl_comm_amt") = sheetObj.CellValue(row, "act_if_comm_amt") * sheetObj.CellValue(row, "mon_xch_rt");
		}
	}
}

/*
 * Setting the CUR to Grid
 */
function setXchRt(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var arOfcCd = formObj.ar_ofc_cd.value;
	var xchRt = formObj.param9.value;
	alert(xchRt);
	if(xchRt == "" || xchRt == "0"){
		ComShowMessage(ComGetMsg("AGT10026", arOfcCd, xchRt, ""));
    }else{
    	sheetObj.CellValue2(sRow, "mon_xch_rt") = xchRt;
    	
    	var act_locl_comm_amt = sheetObj.CellValue(sRow, "act_locl_comm_amt");
    	var act_comm_amt = sheetObj.CellValue(sRow, "act_comm_amt");
    	
    	if(usdAmt > 0){
    		sheetObj.CellValue2(sRow, "act_locl_comm_amt") = act_comm_amt * xchRt;
    	}else{
    		sheetObj.CellValue2(sRow, "act_comm_amt") = act_locl_comm_amt / xchRt;
    	}
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
//        if (!ComIsNumber(iPage)) {
//            return false;
//        }
    	
        switch(sAction) {
            case IBSEARCH:	//Retrieve
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }
       
                break;

            case IBSAVE:	//Save
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
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
                
                //Approval check
				var rows = sheetObj.RowCount;
				
				for(var i=0; i<rows; i++) {
					var flag = sheetObj.CellValue(i+1,"ibflag");
				    if(flag == "U" || flag == "D" || flag == "I"){
				    	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){
				    		ComShowMessage(ComGetMsg("AGT10018", i+1, "SAVE", ""));
				    		
				    		formObj.f_cmd.value = SEARCH;
			                sheetObj.DoSearch4Post("ESM_AGT_0016GS.do", agtQryStr(formObj));
			                sheetObj.SumText(0,0) = "";
			                sheetObj.SumText(0,3) = "TOTAL";
			                
							return false;
						}
		     		}
		  		}
								
		  		break;

			case IBSEARCH_ASYNC01:	//Reject
				//Optional check
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for reject", "", ""));
					return false;
				}	  
		     	
		     	//Status check
		     	var rows = sheetObj.RowCount;
			    for(var i=0; i<rows; i++) {
		            if(sheetObj.CellValue(i+1,"chk") == "1"){
		            	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){ //(kevin) Request에서만 Reject할 수 있음
		            		ComShowMessage(ComGetMsg("AGT10027", "Reject", "", ""));
			                return false;
			            }
		            }
		        }
		        break; 
				
			case IBSEARCH_ASYNC02:	//Audit
                if(ar_ofc_cd.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
//                    formObj.cbArOfcCd.focus();
                    formObj.ar_ofc_cd.focus();
                    return false;
                }

                if(comm_yrmon.value == ""){
                	ComShowMessage(ComGetMsg("COM12113", "Subj.Month", "", ""));
                    formObj.comm_yrmon.focus();
                    return false;
                }

                var checkCnt = sheetObj.CheckedRows("chk");
                if(checkCnt < 1){
                	ComShowMessage(ComGetMsg("COM12113", "row for audit", "", ""));
                    return false;
                }
                
                var rows = sheetObj.RowCount;
			    for(var i=0; i<rows; i++) {
		            if(sheetObj.CellValue(i+1,"chk") == "1"){
		            	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "AS" || sheetObj.CellValue(i+1,"comm_proc_sts_cd") == "IF"){
		            		ComShowMessage(ComGetMsg("AGT10012", i+1, "", ""));    
			                return false;
			            }
		            }
		        }
                break;

            case IBCLEAR:	//cancel
				//Optional check
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}	  
		     	
		     	//Approval check
				var rows = sheetObj.RowCount;
				
				for(var i=0; i<rows; i++) {
				    if(sheetObj.CellValue(i+1,"chk") == 1){
				    	if(sheetObj.CellValue(i+1,"comm_proc_sts_cd") != "AS"){ 
				    		ComShowMessage(ComGetMsg("AGT10013", i+1, "", "")); 
							return false;
						}
		     		}
		  		}
		     	break; 
        }
    }

    return true;
}

/**
 * Exp. Type is changed then implement Grid Initialization
 */
function expType_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
	sheetObj1.RemoveAll();
//	currentRow = 0;
}