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
    	 var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObj,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObj.reset();
    				reSetDate();
    				break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObj,IBSAVE);
    				break;

    			case "btn_recalculate":
    				 doActionIBSheet(sheetObject,formObj,IBRECALCULATE);
    				 break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
    				break;

                case "btn_cal_fr":
                	var cal = new ComCalendar();
    				 cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
                    break;

                case "btn_cal_to":
                	var cal = new ComCalendar();
                    cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
                    break;

    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111", "", "", "");
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

        // S/A Date Unit Date Setting
        var formObj = document.form;
        today = ComGetNowInfo();
        frday = ComGetDateAdd(today, "D", -15);
        formObj.search_dt_fr.value = frday;
        formObj.search_dt_to.value = today;

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
    				InitRowInfo( 2, 1, 9, 100);

    				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(35, 4, 0, true);

    				// setting function handling header
    				//InitHeadMode(true, true, true, true, false, false) ;
    				InitHeadMode(true, true, true, true, false, false) ;

    				var HeadTitle = "Del.|STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Vendor|F.F Name|BL NO.|BKG NO.|BKG STS|ETD|CRE DT|FMC|REF No.|Freight Status|Freight Status|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|Prev AMT|CA DIFF|Status|Remarks|AP IF DT";
    				var HeadTitle1 = "Del.|STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Vendor|F.F Name|BL NO.|BKG NO.|BKG STS|ETD|CRE DT|FMC|REF No.|Commissionable|Rate|Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|Commission|Prev AMT|CA DIFF|Status|Remarks|AP IF DT";

    				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//Data  properties    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "checkDel",            false,         "",        dfNone,          0,     true,       false,    -1,       false,      true,      "",     false);
    				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",              false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtCheckBox,   45,    daCenter,   true,    "check",               false,          "",       dfNone,          0,     true,       true);
    				InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "seq",                 false,         "",        dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "brog_seq",            false,         "",        dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_fwrd_cnt_seq",    false,          "",       dfNone,          0,     true,       false,       8);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "vndr_cnt_seq",        false,          "",       dfNone,          0,     true,       false,       6);
    				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     true,    "cust_lgl_eng_nm",     false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bl_no",               false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bkg_no",          false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "vsl_dep_dt",          false,          "",       dfDateYmd,       0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "cre_dt",              false,          "",       dfDateYmd,       0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   true,    "fmc_no",              false,          "",       dfNone,          0,     true,       false,      10);
    				InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   true,    "brog_ref_no",         false,          "",       dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtData,      100,    daRight,    true,    "act_comm_able",       false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "brog_bkg_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "act_comm_amt",        false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_bx_qty",          false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "brog_bx_rt",          false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_teu_qty",         false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "brog_teu_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_feu_qty",         false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "brog_feu_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_qty",          false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "brog_rf_rt",          false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "cntr_comm_amt",       false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "act_pre_comm_amt",    false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daRight,    true,    "act_if_comm_amt",     false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "comm_proc_sts_cd",    false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,      350,    daLeft,     true,    "comm_proc_rslt_rsn",  false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "brog_if_dt",          false,          "",       dfDateYmd,       0,     false,      false);

    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cnt_cd",         false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cust_seq",       false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_rt_seq",         false,          "",       dfNone,          0,     false,      false);

                    InitDataValid(0, "frt_fwrd_cnt_seq", vtEngUpOther, "0123456789*");	// Upper case in English, Number: : Only Possible to Input
                    InitDataValid(0, "vndr_cnt_seq", vtNumericOnly);	// Number: : Only Possible to Input
                    InitDataValid(0, "fmc_no", vtEngUpOther, "0123456789* ");	// Upper case in English, Number: : Only Possible to Input
                    //InitDataValid(0, "vndr_cnt_seq", vtEngUpOther, "0123456789");	// Upper case in English, Number: : Only Possible to Input

    				RangeBackColor(1,14,1,25) = RgbColor(222, 251, 248);   // OPUS
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
    			//chkbl_no();
    			if(formObj.bl_no.value.trim().length > 0){
            		setBlNoRetrieve(formObj.bl_no);
            	}
    			
                formObj.f_cmd.value = SEARCH;
                selectVal = agtQryStr(formObj);
                sheetObj.DoSearch4Post("ESM_AGT_0013GS.do", selectVal);
                break;

           case IBSAVE:        //Save
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_AGT_0013GS.do", agtQryStr(formObj));
                break;

           case IBRECALCULATE:	//re-calculate
                formObj.f_cmd.value = REPLY;
                var cnt = sheetObj.CheckedRows("check");
                //200 check
				if(cnt > 200){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", "");
					return false;
				}

                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("AGT10023", "Re-calculate "+ cnt, "re-calculate?", "") == 1) {
                        sheetObj.DoSave("ESM_AGT_0013GS.do", agtQryStr(formObj), "check", false);
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

        if(sheetObj.ColSaveName(Col) != "frt_fwrd_cnt_seq" && sheetObj.ColSaveName(Col) != "vndr_cnt_seq" && sheetObj.ColSaveName(Col) != "fmc_no") {
            var bl_no = sheetObj.CellValue(Row, "bl_no");
            var bkg_no = sheetObj.CellValue(Row, "bkg_no");
            var agmt_cnt_cd = sheetObj.CellValue(Row, "agmt_cnt_cd");
            var agmt_cust_seq = sheetObj.CellValue(Row, "agmt_cust_seq");
            var agmt_rt_seq = sheetObj.CellValue(Row, "agmt_rt_seq");

            var str = "agt_win_14";
        	var width = 900;
        	var height = 640;
        	//var func = "";
            //var display = "0,0,1";
            var url = "ESM_AGT_0014.do";

            url += "?bl_no="+bl_no + "&bkg_no="+bkg_no + "&agmt_cnt_cd="+agmt_cnt_cd + "&agmt_cust_seq="+agmt_cust_seq + "&agmt_rt_seq="+agmt_rt_seq +"&sheet=4";

            //ComOpenWindowCenter(url, str, width, height, "N");
            ComOpenWindow(url, str, "resizable=yes,width=900,height=640");
            
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
            var display ='1,0,1,1,1,1,1,1';
            var url = "COM_ENS_041.do";
            ComOpenPopup(url, width, height, func, display, true, false, Row, Col, 0);
            
    	}
    }

    /**
     * Grid OnChange Event 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

       var form1 = document.hiddenF;

       with(sheetObj) {
           if( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

               Value = Value.trim();

               if( checkCustomer(Value) == true ) {

                   var seq = Value.substring(2);

                   if( seq == 999999 ) {
                       //CellValue2(Row, Col+2) = "REP. CUSTOMER";
                       CellValue2(Row, Col+2) = "";
                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+2);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       DoRowSearch("ESM_AGT_COM.do", agtQryStr(form1));
                       CellValue2(Row, parseInt(Col)+2) = EtcData("cust_nm");
                   }
               } else {
    			   CellValue2(Row, Col) = "";
    			   CellValue2(Row, Col+2) = "";
                   SelectCell(Row, Col);
               }
               /*
               if( Value != "" && (Value != "*000000" || Value != "*0") ) {

                   if( checkCustomer(Value) == true ) {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+2);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                   } else {
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, Col+2) = "";
                       SelectCell(Row, Col);
                   }

               } else {
                   CellValue2(Row, Col) = "";
                   CellValue2(Row, Col+2) = "";
                   SelectCell(Row, Col);
               }
               */
           }
           /*
            if( ColSaveName(Col) == "checkDel"
                || ColSaveName(Col) == "frt_fwrd_cnt_seq"
                || ColSaveName(Col) == "vndr_cnt_seq" )
            {
                ReturnCellData(Row, "check");
            }
            */
        }
    }

    /**
     * Setting the returned value to the cell after retrieving from Pop-up 
     */
    function sheet1_setFFCntSeq(rowArray, row, col, sheetIdx) {
    	 
        var sheetObj = sheetObjects[0];
    	var colArray = rowArray[0];
    	
    	var cnt_cd = colArray[3].substring(0, 2);
    	var cust_seq = colArray[3].substring(2);
    	
     	sheetObj.CellValue2(row, col) = cnt_cd + ComLpad(cust_seq,   6, "0");
    	sheetObj.CellValue2(row, parseInt(col)+2) = colArray[4];

    }
     
    function sheet1_OnSearchEnd(sheetObj,errMsg){
    	if(sheetObj.RowCount > 0){
	    	for(var i=1;i<= sheetObj.RowCount+1;i++){
	    		if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CE"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
	    		}else if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CM"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
	    		}
	    	}
    	}
   		if(errMsg!=null){
   			ComShowMessage(errMsg);
   		}

   	}
    function sheet1_OnSaveEnd(sheetObj,errMsg){
    	if(sheetObj.RowCount > 0){
	    	for(var i=1;i<= sheetObj.RowCount+1;i++){
	    		if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CE"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
	    		}else if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CM"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
	    		}
	    	}
    	}
   		if(errMsg!=null){
   			ComShowMessage(errMsg);
   		}

   	}
    /**
     * Save/re_calculate button Validation Process
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;
        Value = Value.trim();

        if( f_cmd == MULTI ) {

        	with(sheetObj) {

                if( RowStatus(Row).toUpperCase() == "U" ) {

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
            	    } else if ( ColSaveName(Col) == "vndr_cnt_seq" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "Vendor", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
/*
                        } else {
                            if( checkCustomer(Value) == false ) {
                			    ComShowCodeMessage("AGT10017", "Vendor", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
                            }
*/
                        }
            	    } else if ( ColSaveName(Col) == "fmc_no" ) {
                        //ValidateFail = true;
                        SelectCell(Row, Col);
            	    }
                }
        	}
    	}
    }

    /**
     * Checking mandatoryInsert on Retrieving
     */
    function chkValidSearch(){
    	 return true;
        var formObj = document.form;

        formObj.bl_no.value= formObj.bl_no.value.trim().toUpperCase();
        formObj.bl_nos.value = formObj.bl_nos.value.trim().toUpperCase();
        formObj.vvd.value= formObj.vvd.value.trim().toUpperCase();
        formObj.ff_cnt_cd.value = formObj.ff_cnt_cd.value.trim().toUpperCase();

        var bl_no = formObj.bl_no.value;
        var bl_nos = formObj.bl_nos.value;
        var ff_cnt_seq = formObj.ff_cnt_cd.value.trim();
        var ff_cust_seq = "";

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
//                formObj.search_dt_fr.value = "";
//                formObj.search_dt_to.value = "";
            }
        }

        var search_dt_fr = formObj.search_dt_fr.value.trim();
        var search_dt_to = formObj.search_dt_to.value.trim();

        if( formObj.bl_nos.value == "" ) {
    		if ( search_dt_fr == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_fr.focus();
    			return false;
    		}
    		if ( search_dt_to == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_to.focus();
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
    	    if(!chkValidSearch()) return false;
    	}

    	return true;
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
    	var display ='1,0,1,1,1,1,1,1';
    	//url = url + "?cust_cd="+cust_cd;
    	//comPopup(url, width, height, func, display, bModal, b2ndSheet);
    	ComOpenPopup(url, width, height, func, display, true, false);
    }

    /**
     * Setting Returned Calue after Retrieving F.Forwarder
     */
    function setForwarder(rowArray, row, col) {
    	var colArray = rowArray[0];

    	document.form.ff_cnt_cd.value = colArray[3];
    }

    /**
     * Setting the user inserted BL NO 
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

                if(ComTrim(form.bl_nos.value).length > 0) {
                	form.search_dt_fr.value = "";
                    form.search_dt_to.value = "";
                }
            }
        }
    }

    /**
     * Deleting Date after inserting BL No.
     */
    function setDateEmpty() {

        var form = document.form;
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
            form.search_dt_fr.value = "";
            form.search_dt_to.value = "";
        }else{
        	today = ComGetNowInfo();
            frday = ComGetDateAdd(today, "D", -15);
            form.search_dt_fr.value = frday;
            form.search_dt_to.value = today;
        }
    }

    /**
     * ReSet date.
     */
    function reSetDate() {
        form.search_dt_fr.value = frday;
        form.search_dt_to.value = today;
    }
     /**
      * Inputbox when Enter Key Event occurs in Inpubox, implement Retrieve event.
      * @param    : obj => object
      * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnterOffice(this)"  >
      */
     function checkEnterOffice(obj) {

         obj.value = obj.value.trim().toUpperCase();

         if ( window.event.keyCode == 13 ) {
     	    obj.blur(); // Update Date Retrieve
     	    document.btn_retrieve.click(); // Retrieve 
         }

         return true;
     }
      /**
       * Retrieving after Setting the Bl no. on Clicking Retrieve button
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
