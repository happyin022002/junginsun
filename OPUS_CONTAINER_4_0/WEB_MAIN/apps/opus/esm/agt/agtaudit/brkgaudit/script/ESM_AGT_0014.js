// Common Global Variables
var sheetObjects = new Array();
var sheetCnt = 0;

/*
 * Adding IBSheet Action
 */
var IBRATESEARCH = 20; //Rate Information Retrieve

/*
 *Event handler processing by button click event
 */
document.onclick = processButtonClick;

    /* Event handler processing by button name */
    function processButtonClick(){
    	 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
		 var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3];

    	 /*******************************************************/
    	 var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject4,formObject,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObject1.RemoveAll();
    				sheetObject2.RemoveAll();
    				sheetObject3.RemoveAll();
    				sheetObject4.RemoveAll();
    				formObject.bl_no.value = "";
    				formObject.bkg_no.value = "";
    				formObject.reset();
    				break;

				 case "btn_close":
					self.close();
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
	function loadPage(grpTpCode, grpTpText, brogDivCode, brogDivText) {
		var formObject = document.form;
		for(i=0;i<sheetObjects.length;i++){

		//khlee-Changing Start Environment Setting Method's Name
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i+1, grpTpCode, grpTpText, brogDivCode, brogDivText);
		//khlee-Adding Last Environment Setting method
			ComEndConfigSheet(sheetObjects[i]);
		}
		formObject.bl_no.value = formObject.hdn_bl_no.value;
		formObject.bkg_no.value = formObject.hdn_bkg_no.value;
		doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
	}

    /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo, grpTpCode, grpTpText, brogDivCode, brogDivText) {

		var cnt = 0;

		switch(sheetNo) {

		    case 1:      //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(6) ;
					//Whole setting width
					SheetWidth = 120;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = false;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false, false) ;

					var HeadTitle = "CHG|AMT";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,   true,    "chg_cd",     false,          "",       dfNone,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      70,    daRight,    true,    "bkg_chg_amt",     false,          "",       dfFloat,        2,     true,       true);

                    RangeBackColor(0,0,0,1) = RgbColor(222, 251, 248);   // OPUS

                    CountPosition  = 0;
				}

				break;

			case 2:      //sheet2 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(6) ;
					//Whole setting width
					SheetWidth = mainTable1.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = false;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 1 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "CA\nSEQ|Freight Status|Freight Status|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|AMT DIFF|Calc Date|Status|Remark|IF Date";
					var HeadTitle1 = "CA\nSEQ|Commissionable|Rate|Commission|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|Commission|AMT DIFF|Calc Date|Status|Remark|IF Date";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "brog_seq",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      110,    daRight,   true,    "act_comm_able",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "brog_bkg_rt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       80,    daRight,   true,    "act_comm_amt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_bx_qty",     false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "brog_bx_rt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_teu_qty",     false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "brog_teu_rt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_feu_qty",     false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "brog_feu_rt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "bkg_rf_qty",     false,          "",       dfFloat,         1,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,   true,    "brog_rf_rt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       80,    daRight,   true,    "cntr_comm_amt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,   true,    "act_if_comm_amt",     false,          "",       dfFloat,         2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "cre_dt",     false,          "",       dfDateYmd,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "comm_proc_sts_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      300,    daLeft,    true,    "comm_proc_rslt_rsn",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "brog_if_dt",     false,          "",       dfDateYmd,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_cnt_cd",     false,          "",       dfNone,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_cust_seq",   false,          "",       dfNone,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "agmt_rt_seq",     false,          "",       dfNone,       0,     true,       true);

					RangeBackColor(1,1,1,12) = RgbColor(222, 251, 248);

					CountPosition  = 0 ;

					HeadRowHeight  = 10;
				}
				break;

			case 3:      //sheet3 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(3) ;
					//Whole setting width
					SheetWidth = mainTable2.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = false;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(26, 2 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   false,    "seq",                 false,    "",         dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "brog_cnt_cust_seq",   false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "brog_cnt_cust_nm",    false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "shpr_cnt_seq",        false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_cnt_nm",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "por_grp_tp_cd",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "por_rout_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pol_grp_tp_cd",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pol_rout_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pod_grp_tp_cd",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pod_rout_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fm_eff_dt",           false,    "",         dfDateYmd,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "to_eff_dt",           false,    "",         dfDateYmd,       0,     false,      false);
      				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "sc_no",               false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no",              false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,     100,    daCenter,   false,    "cmdt_tp_cd",          false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "cmdt_cd",             false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     false,    "cmdt_nm",             false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "brog_div_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "bkg_brog_rt",         false,    "",         dfFloat,         3,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_bx_rt",          false,    "",         dfFloat,         3,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_teu_rt",         false,    "",         dfFloat,         3,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_feu_rt",         false,    "",         dfFloat,         3,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_rf_rt",          false,    "",         dfFloat,         3,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daLeft,     false,    "brog_chg_ctnt",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "brog_knd_cd",         false,    "",         dfNone,          0,     false,      false);

					InitDataCombo (0,"por_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pol_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pod_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"brog_div_cd",brogDivCode,brogDivCode);
					InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");

					CountPosition  = 0 ;
				}

				break;
			case 4:      //sheet3 init
				with (sheetObj) {
					// setting height
//					style.height = GetSheetHeight(3) ;
					//Whole setting width
//					SheetWidth = mainTable2.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = false;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(18, 2 , 0, true);

					// setting function handling header
//					InitHeadMode(true, true, false, true, false,false) ;

//					var HeadTitle = "SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,        30,    daCenter,   false,   "vsl_dep_dt",                 false,    "",         dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "bkg_no",   			  false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "bl_no",    false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "shpr_cnt_seq",        false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_nm",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "frt_fwrd_cnt_seq",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "vndr_cnt_seq",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "frt_fwrd_nm",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "comm_vsl",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      90,    daCenter,   false,    "bkg_por_cd",       false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_pol_cd",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_pod_cd",           false,    "",         dfDateYmd,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "bkg_del_cd",           false,    "",         dfDateYmd,       0,     false,      false);
      				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "brog_ref_no",               false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fmc_no",              false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,     100,    daCenter,   false,    "sc_no",          false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no",             false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     false,    "brog_knd_cd",             false,    "",         dfNone,          0,     false,      false);
					
					CountPosition  = 0 ;
				}

				break;

		}
	}

    /*
     * handling process for Sheet
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheetObj.ShowDebugMsg = false;
       
	    
        switch(sAction) {
        	
        
            case IBSEARCH:		//Retrieve
//            	
        	    
    			if(!validateForm(sheetObj,formObj,sAction)) {
    			    return false;
    			}
                formObj.f_cmd.value = SEARCH;
                var sheetObj1 = sheetObjects[0];
    	        var sheetObj2 = sheetObjects[1];
    	        var sheetObj4 = sheetObjects[3];
    	        
                sheetObj4.DoSearch4Post("ESM_AGT_0014GS.do", agtQryStr(formObj));
                formObj.vsl_dep_dt.value = sheetObj4.CellValue(1, "vsl_dep_dt");
                formObj.shpr_cnt_seq.value = sheetObj4.CellValue(1, "shpr_cnt_seq");
                formObj.shpr_nm.value = sheetObj4.CellValue(1, "shpr_nm");
                formObj.frt_fwrd_cnt_seq.value = sheetObj4.CellValue(1, "frt_fwrd_cnt_seq");
                formObj.vndr_cnt_seq.value = sheetObj4.CellValue(1, "vndr_cnt_seq");
                formObj.frt_fwrd_nm.value = sheetObj4.CellValue(1, "frt_fwrd_nm");
                formObj.comm_vsl.value = sheetObj4.CellValue(1, "comm_vsl");
                formObj.bkg_por_cd.value = sheetObj4.CellValue(1, "bkg_por_cd");
                formObj.bkg_pol_cd.value = sheetObj4.CellValue(1, "bkg_pol_cd");
                formObj.bkg_pod_cd.value = sheetObj4.CellValue(1, "bkg_pod_cd");
                formObj.bkg_del_cd.value = sheetObj4.CellValue(1, "bkg_del_cd");
                formObj.brog_ref_no.value = sheetObj4.CellValue(1, "brog_ref_no");
                formObj.fmc_no.value = sheetObj4.CellValue(1, "fmc_no");
                formObj.sc_rfa_no.value = sheetObj4.CellValue(1, "sc_no")+"/"+sheetObj4.CellValue(1, "rfa_no");
                formObj.brog_knd_cd.value = sheetObj4.CellValue(1, "brog_knd_cd");
                
                formObj.f_cmd.value = SEARCH01;
                sheetObj1.DoSearch4Post("ESM_AGT_0014GS.do", agtQryStr(formObj));
                
                formObj.f_cmd.value = SEARCH02;
                sheetObj2.DoSearch4Post("ESM_AGT_0014GS.do", agtQryStr(formObj));
    			break;

		   case IBRATESEARCH:      //Retrieve
			   	formObj.f_cmd.value = SEARCH03;
			   	var sheetObj3 = sheetObjects[2];
    			sheetObj3.DoSearch4Post("ESM_AGT_0014GS2.do", agtQryStr(formObj));
				break;

        }
    }

    /**
     * Checking mandatoryInsert on Retrieving
     */
    function chkValidSearch(){

        var formObj = document.form;

        var bl_no = formObj.bl_no.value;
        var bkg_no = formObj.bkg_no.value;

        if( bl_no == "" && bkg_no == "" ) {

        	ComShowMessage(ComGetMsg("COM12138", "B/L", "Booking No", ""));
            formObj.bl_no.focus();
   			return false;
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
    function sheet4_OnSearchEnd(ErrMsg){
    	var formObject = document.form;
    	if(sheetObjects[3].RowCount == 0){
    		sheetObjects[3].CellValue(1, "vsl_dep_dt") = "";
    	}
    }
    /**
     * Grid OnDblClick Event 
     */
    function sheet2_OnDblClick(sheetObj, Row, Col) {

        var sheetObject2 = sheetObjects[2];
        var formObj = document.form;
        formObj.brog_cnt_cd.value = sheetObjects[1].CellValue(Row, "agmt_cnt_cd");
        formObj.brog_cust_seq.value = sheetObjects[1].CellValue(Row, "agmt_cust_seq");
        formObj.brog_rt_seq.value = sheetObjects[1].CellValue(Row, "agmt_rt_seq");
        doActionIBSheet(sheetObjects[2], formObj, IBRATESEARCH);

    }