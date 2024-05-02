// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

/*
 * Adding IBSheet Action
 */
var IBRECALCULATE = 20; //re-calculate

/*
 *Event handler processing by button click event
 */
document.onclick = processButtonClick;

    /* Event handler processing by button name */
    function processButtonClick(){
    	 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
    	 var sheetObject = sheetObjects[0];

    	 /*******************************************************/
    	 var formObject = document.form;

//    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				reSetDate();
    				break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;

    			case "btns_calendar1":
    				var cal = new ComCalendar();
    				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
    				break;

    			case "btns_calendar2":
    				var cal = new ComCalendar();
    				cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
                    break;

    			case "btn_recalculate":
    				 doActionIBSheet(sheetObject,formObject,IBRECALCULATE);
    				 break;

    		} // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowCodeMessage("COM12111", "", "", "");
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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

    	// S/A Date Unit Date Setting	
    	var formObj = document.form;
    	var today = ComGetNowInfo();
    	var frday = ComGetDateAdd(null, "D", -15);
    	formObj.search_dt_fr.value = frday;
    	formObj.search_dt_to.value = today;
    	formObj.ar_ofc_cd.focus();

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
    				style.height = GetSheetHeight(14) ;
    				//Whole setting width
    				SheetWidth = mainTable.clientWidth;

    				//setting Host information[mandatory][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//Whole Merge kind [Optional, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   //Edit kind [Optional, Default false]
    				Editable = true;

    				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(2, 1, 9, 100);

    				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(42, 4 , 0, true);

    				// setting function handling header
    				InitHeadMode(true, true, true, true, false,false) ;

    				var HeadTitle = "STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Name|BL NO.|BKG NO.|BKG STS|ETD|BL AMT|Curr|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|Prev AMT|AMT DIFF|Reason|Status|Remarks|AR IF DT";
    				var HeadTitle1 = "STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Name|BL NO.|BKG NO.|BKG STS|ETD|BL AMT|Curr|Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|Commission|Prev AMT|AMT DIFF|Reason|Status|Remarks|AR IF DT";

    				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                 KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				//InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "checkDel",            false,          "",       dfNone,   		0,     true,        false,     -1,      false,       true,      "",     false);
    				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",              false,          "",       dfNone,   		0,     false,       false);
    				InitDataProperty(0, cnt++ , dtCheckBox,   45,    daCenter,   true,    "check",               false,          "",       dfNone,          0,     true,        true);
    				InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "seq",                 false,          "",       dfNone,          0,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "fac_seq",             false,          "",       dfNone,          0,     false,        false);
    				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_fwrd_cnt_seq",    false,          "",       dfNone,          0,     false,       false,       8);
    				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     true,    "cust_lgl_eng_nm",     false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bl_no",               false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bkg_no",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "vsl_dep_dt",          false,          "",       dfDateYmd,       0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bl_comm_amt",         false,          "",       dfFloat,         2,     false,        false);

    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "curr_cd",             false,          "",       dfNone,          0,     false,       false);

    				InitDataProperty(0, cnt++ , dtData,      100,    daRight,    true,    "act_comm_amt",        false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_bx_qty",          false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_bx_rt",           false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_teu_qty",         false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_teu_rt",          false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_feu_qty",         false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_feu_rt",          false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_teu_qty",      false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_rf_teu_rt",       false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_feu_qty",      false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_rf_feu_rt",       false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "cntr_comm_amt",       false,          "",       dfFloat,         2,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "act_pre_comm_amt",    false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     60,    daRight,    true,    "act_if_comm_amt",     false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,    240,    daLeft,     true,    "fac_rmk",             false,          "",       dfNone,          0,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "comm_proc_sts_cd",    false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,      350,    daLeft,     true,    "comm_proc_rslt_rsn",  false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "fac_if_dt",           false,          "",       dfDateYmd,       0,     false,       false);

    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "sls_ofc_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "bkg_no_split",        false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_ofc_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cnt_cd",         false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cust_seq",       false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_rt_seq",         false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_div_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_div_cd_1",        false,          "",       dfNone,          0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "old_act_comm_amt",    false,          "",       dfFloat,         2,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_if_usr_id",       false,          "",       dfNone,          0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_if_dt_1",         false,          "",       dfNone,          0,     false,       false);

                    InitDataValid(0, "frt_fwrd_cnt_seq", vtEngUpOther, "0123456789*");	// Upper case in English, Number: : Only Possible to Input

    				RangeBackColor(1,11,1,22) = RgbColor(222, 251, 248);   // OPUS
    				HeadRowHeight = 20 ;
    				HeadRowHeight = 21;
    			}
    			break;

    	}
    }

    /**
     * handling process for Sheet
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:		//Retrieve
    			if(!validateForm(sheetObj,formObj,sAction)) {
    			    return false;
    			}

            	if(formObj.bl_no.value.trim().length > 0){
            		setBlNoRetrieve(formObj.bl_no);
            	}
 
                formObj.f_cmd.value = SEARCH;
                selectVal = agtQryStr(formObj);
                
                sheetObj.DoSearch4Post("ESM_AGT_0033GS.do", selectVal);
                break;

           case IBSAVE:        //Save
                checkSaveData(sheetObj, sAction);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_AGT_0033GS.do", agtQryStr(formObj));
                break;

           case IBRECALCULATE:	//re-calculate
                formObj.f_cmd.value = SEARCH01;
                var cnt = sheetObj.CheckedRows("check");
                //Impossible to implement over 1,000 rows
				if(cnt > 1000){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "Under 1,000 B/Ls at a time when you re-calculate.", "", "");
					return false;
				}

				if( cnt > 0 ) {
                    if(ComShowCodeConfirm("AGT10023", "Re-calculate "+ cnt, "re-calculate?", "") == 1) {
                        sheetObj.DoSave("ESM_AGT_0033GS.do", agtQryStr(formObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("AGT10022", "re-calculate.", "", "");
                }
                break;

            case IBDOWNEXCEL:        //Excel Download
                sheetObj.SpeedDown2Excel(-1);
                break;
            

        }
    }

    /**
     * Grid OnDblClick Event 
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {

        var saveNm = sheetObj.ColSaveName(Col);

        if( saveNm != "bl_comm_amt" && saveNm != "act_comm_amt" && saveNm != "cntr_comm_amt" && saveNm != "fac_rmk") {
            var bl_no = sheetObj.CellValue(Row, "bl_no");
            var bkg_no = sheetObj.CellValue(Row, "bkg_no");
            var fac_ofc_cd = sheetObj.CellValue(Row, "fac_ofc_cd");
            var agmt_cnt_cd = sheetObj.CellValue(Row, "agmt_cnt_cd");
            var agmt_cust_seq = sheetObj.CellValue(Row, "agmt_cust_seq");
            var agmt_rt_seq = sheetObj.CellValue(Row, "agmt_rt_seq");

            var str = "agt_win_15";
        	var width = 905;
        	var height = 600;
        	//var func = "";
            //var display = "0,0,1";
            var url = "ESM_AGT_0015.do";

            url += "?bl_no="+bl_no + "&bkg_no="+bkg_no + "&fac_ofc_cd="+fac_ofc_cd + "&agmt_cnt_cd="+agmt_cnt_cd + "&agmt_cust_seq="+agmt_cust_seq + "&agmt_rt_seq="+agmt_rt_seq+"&sheet=4";

            ComOpenWindowCenter(url, str, width, height, "N");
        	//comPopupInSheet(url, width, height, func, display, Row, Col, false, false);
        }
    }

    /**
     * Grid OnPopupClick Event 
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {

    	if ( sheetObj.ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

    	    var cust_cd = "";
    		var width = 775;
    		var height = 482;
    		var func = "sheet1_setFFCntSeq";
            var display = "1,0,1";
            var url = "COM_ENS_041.do";

    		comPopupInSheet(url, width, height, func, display, Row, Col, true, false);

    	}
    }

    /**
     * Grid OnChange Event 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

       var form1 = document.hiddenF;

       with(sheetObj) {
/*
           if( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

               Value = Value.trim();

               if( checkCustomer(Value) == true ) {

                   var seq = Value.substring(2);

                   if( seq == 999999 ) {
                       CellValue2(Row, Col+1) = "REP. CUSTOMER";
                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+1);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                   }
               } else {
    			   CellValue(Row, Col) = "";
    			   CellValue(Row, Col+1) = "";
                   SelectCell(Row, Col);
               }
           }
*/
           if( ColSaveName(Col) == "bl_comm_amt" || ColSaveName(Col) == "act_comm_amt" || ColSaveName(Col) == "cntr_comm_amt" ) {

               var fComm_amt = 0;
               var fAct_pre_comm_amt = 0;
               var fAct_if_comm_amt = 0;
               var fOld_act_comm_amt = 0;

               var act_pre_comm_amt = CellValue(Row, "act_pre_comm_amt").trim();
               var act_if_comm_amt = CellValue(Row, "act_if_comm_amt").trim();
               var old_act_comm_amt = CellValue(Row, "old_act_comm_amt").trim();

               if(trim(Value) != "") {
                   fComm_amt = parseFloat(trim(Value));
               }
               if(act_pre_comm_amt != "") {
                   fAct_pre_comm_amt = parseFloat(act_pre_comm_amt);
               }
               if(old_act_comm_amt != "") {
                   fOld_act_comm_amt = parseFloat(old_act_comm_amt);
               }

               if(fComm_amt == 0) {
                    if( ColSaveName(Col) == "bl_comm_amt" ) {
                        ComShowCodeMessage("AGT10032", "", "", "");
                    } else {
    			        ComShowCodeMessage("AGT10031", "", "", "");
                    }
                    SelectCell(Row, Col);
                    return false;
               }

               fAct_if_comm_amt = fComm_amt - fAct_pre_comm_amt

               if( fComm_amt != fOld_act_comm_amt ) {
                   CellValue2(Row, "act_pre_comm_amt") = fOld_act_comm_amt;
                   CellValue2(Row, "act_if_comm_amt") = fAct_if_comm_amt;
               } else {
                   ReturnCellData(Row, "act_pre_comm_amt");
                   ReturnCellData(Row, "act_if_comm_amt");
               }
           }
        }
    }

    /**
     * Setting the returned value to the cell after retrieving from Pop-up 
     */
    function sheet1_setFFCntSeq(rowArray, row, col) {
        var sheetObj = sheetObjects[0];

    	var colArray = rowArray[0];

    	var cnt_cd = colArray[3].substring(0, 2);
    	var cust_seq = colArray[3].substring(2);

     	sheetObj.CellValue2(row, col) = cnt_cd + fullZero(cust_seq, 6);
    	sheetObj.CellValue(row, col+1) = colArray[4];
    }

    /**
     * Save/re_calculate button Validation Process
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;

        if( f_cmd == MULTI ) {

            var fValue = 0;
            Value = Value.trim();

        	with(sheetObj) {

        	    var ibStatus = RowStatus(Row);

                if( ibStatus.toUpperCase() == "U" ) {
/*
            	    if ( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "F/Forwarder", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
                        } else {
                            if( checkCustomer(Value) == false ) {
                			    ComShowCodeMessage("AGT10017", "F/Forwarder", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
                            }
                        }
            	    }
*/
            	    if( ColSaveName(Col) == "bl_comm_amt" ) { 
            	        var fac_div_cd = CellValue(Row, "fac_div_cd");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd == "BL") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10032", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }

            	    } else if( ColSaveName(Col) == "act_comm_amt" ) { 
            	        var fac_div_cd = CellValue(Row, "fac_div_cd");
            	        var fac_div_cd_1 = CellValue(Row, "fac_div_cd_1");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd_1 == "B" && fac_div_cd != "BL") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10031", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }

            	    } else if( ColSaveName(Col) == "cntr_comm_amt" ) { 
            	        var fac_div_cd_1 = CellValue(Row, "fac_div_cd_1");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd_1 == "C") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10031", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }
            	    } else if( ColSaveName(Col) == "fac_rmk" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "Reason", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
                        }
            	    }
                }
        	}
        }
    }

    /**
     * Office Optional
     */
    function rdoOfficeOpt_onClick(obj) {

        var val = obj.value;

        if( obj.checked == true ) {
            if( val == "A" ) {
                document.all.div_sub_ofc.style.display = "none";
                document.all.div_ar_ofc.style.display = "block";

                // Initialization to AR Office
                document.form.ar_ofc_cd.value = document.form.arOfcCd.value;

                var idx = document.form.ar_ofc_cd.selectedIndex;

                // If AR Office doesn't exist, setting first Index to Optional mode.
                if( !(idx >= 0) ) {
                    document.form.ar_ofc_cd.selectedIndex = 0;
                }
            } else {
                document.all.div_ar_ofc.style.display = "none";
                document.all.div_sub_ofc.style.display = "block";

                // Initialization to AR Office
                document.form.agn_cd.value = document.form.arOfcCd.value;

                var idx = document.form.agn_cd.selectedIndex;

                // If Sales Office doesn't exist, setting first Index to Optional mode. 
                if( !(idx >= 0) ) {
                    document.form.agn_cd.selectedIndex = 0;
                }
            }
        }
    }

    /**
     * Checking mandatoryInsert on Retrieving
     */
    function chkValidSearch(){

        var ofcObj;
        var formObj = document.form;

        if( formObj.ofc_option[0].checked == true ) {
            ofcObj = formObj.ar_ofc_cd;
        } else {
            ofcObj = formObj.agn_cd;
        }

        formObj.bl_no.value= formObj.bl_no.value.trim().toUpperCase();
        formObj.bl_nos.value = formObj.bl_nos.value.trim().toUpperCase();
        formObj.vvd.value= formObj.vvd.value.trim().toUpperCase();
        formObj.ff_cnt_cd.value = formObj.ff_cnt_cd.value.trim().toUpperCase();

        var ofcCd = ofcObj.value.trim();
        var bl_no = formObj.bl_no.value;
        var bl_nos = formObj.bl_nos.value;
        var ff_cnt_seq = formObj.ff_cnt_cd.value.trim();
        var ff_cust_seq = "";

        if( ofcCd == "" ) {
    		    ComShowCodeMessage("COM12113", "Office", "", "");
    		    ofcObj.focus();
    			return false;
        } else {
            formObj.agn_cd.value = ofcCd;
        }

        if(bl_nos.length > 0 || bl_no.length > 0) {

            if(bl_no.length > 0) {
                if(bl_nos.length > 0) {
                    formObj.bl_nos.value = bl_nos + "," + bl_no;
                } else {
                    formObj.bl_nos.value = bl_no;
                }
            } else {
                formObj.bl_nos.value = bl_nos;
            }

            formObj.bl_no.value = "";

            if(formObj.bl_nos.value.length > 0) {
                //formObj.search_dt_fr.value = "";
                //formObj.search_dt_to.value = "";
            }
        }

        var selFromDt = formObj.search_dt_fr.value.trim();
        var selToDt = formObj.search_dt_to.value.trim();

        if( formObj.bl_nos.value == "" ) {
    		if ( selFromDt == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_fr.focus();
    			return false;
    		}
    		if ( selToDt == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.selToDt.focus();
    			return false;
    		}
        }

	    if ( ff_cnt_seq.length > 2 ) {

            ff_cust_seq = ff_cnt_seq.substring(2, ff_cnt_seq.length);

            if(isNumber2(ff_cust_seq) == false) {
			    ComShowCodeMessage("AGT10017", "F/Forwarder", "", "");
			    formObj.ff_cnt_cd.focus();
				return false;
			}
	    }

    	return true;
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	   // if(!ComChkValid()) return false;
    	}

    	return true;
    }

    /**
     * handling process for input validation
     */
    function checkSaveData(sheetObj, sAction){
        if( sAction == IBSAVE ) {
            with(sheetObj) {
                for(var i=2; i<Rows; i++) {
                    if(CellValue(i, "check") == 1) {
                        ReturnCellData(i, "check");
                    }
                }
            }
        }
    }

	/**
	 * Office Retrieve pop-up open
	 */
	function openWindowOffice(formObj) {
		var url = "COM_ENS_071.do";
		var width = 775;
		var height = 460;
		var func = "setOfficeCd";
		var display = "1,0,1";
		comPopup(url, width, height, func, display, true, false);
	}

	/**
	 * Setting Returned Value after Retieving Office.
	 */
	function setOfficeCd(rowArray, row, col) {
		var colArray = rowArray[0];

		document.form.selOfficeCd.value = colArray[3];
	}

    /**
     * F.Forwarder Retrieve pop-up open
     */
    function openWindowCustomer(formObj) {
    	//var cust_cd = "US"; // Default setting
    	var url = "COM_ENS_041.do";
    	var width = 775;
    	var height = 484;
    	var func = "setForwarder";
    	var display = "1,0,1,1,1,1,1,1";
    	//url = url + "?cust_cd="+cust_cd;
    	//comPopup(url, width, height, func, display, bModal, b2ndSheet);
    	ComOpenPopup(url, width, height, func, display, true, false);
    }

    /**
     * Setting Returned Value after Retrieving F.Forwarder
     */
    function setForwarder(rowArray, row, col) {
    	var colArray = rowArray[0];

    	document.form.ff_cnt_cd.value = colArray[3];
    }

    /**
     * Setting user inserted BL NO.
     */
    function setBlNo(obj) {
        var form = document.form;
        var bl_no = obj.value.trim().toUpperCase();
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if (window.event.keyCode==13) {
            if(bl_no.length > 0) {

                if(bl_no_list.length > 0) {
                    form.bl_nos.value = bl_no_list + "," + bl_no;
                } else {
                    form.bl_nos.value = bl_no;
                }

                obj.value = "";

                if(form.bl_nos.value.trim().length > 0) {
                    //form.search_dt_fr.value = "";
                    //form.search_dt_to.value = "";
                }
            }
        }
    }
     /**
      * Retrieving after Setting user inserted BL NO.
      */
     function setBlNoRetrieve(obj) {
         var form = document.form;
         var bl_no = obj.value.trim().toUpperCase();
         var bl_no_list = form.bl_nos.value.trim().toUpperCase();

             if(bl_no_list.length > 0) {
                 form.bl_nos.value = bl_no_list + "," + bl_no;
             } else {
                 form.bl_nos.value = bl_no;
             }

             obj.value = "";
     }

    /**
     * Deleting Date after inserting BL No.
     */
    function setDateEmpty() {

        var form = document.form;
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
        //    form.search_dt_fr.value = "";
        //    form.search_dt_to.value = "";
        }
    }

    /**
     * Resetting Date to SYSDATE
     */
    function reSetDate() {
        form.search_dt_fr.value = fromDate;
        form.search_dt_to.value = toDate;
    }
     /**
      * Setting user inserted BL NO
      */
     function setBlNos(obj) {
          var form = document.form;
          form.bl_nos.value = obj.value.trim().toUpperCase();
      }
