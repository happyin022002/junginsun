/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3107.jsp
*@FileTitle  : Calculation Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
             /***** Tab sheets per case more than two additional sheets are used to specify a variable  *****/
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_Close":
  ComClosePopup(); 
						break;
				} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
	}
    /**
     * IRegister as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	   * initializing sheet
       * implementing onLoad event handler in body tag
       * adding first-served functions after loading screen.
	  */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    sheet4_OnLoadFinish(sheet4);
	}
	// IBSheet using Object tag on the page creates an instance of the Event will occur when you complete.
	function sheet4_OnLoadFinish() {
 		//sheetObjects[0].WaitImageVisible = false;
 		var formObj=document.form;
   		var sheetObj=sheetObjects[0];
	    doActionIBSheet(sheetObj, formObj, IBSEARCH);
 	}
 	/**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":	// Basic Tariff
                with(sheetObj){
		             var HeadTitle1="|Basic Tariff|Basic Tariff|F/D|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Rate per Day|Rate per Day|Rate per Day|Charge Calculation";
		             var HeadTitle2="|Appl. Date|Coverage|F/D|SAT|SUN|H/day|Over|Cur.|Over Day|Rate|Charge Calculation";
		             SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                             { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_aply_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cvrg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y" },
		                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y" },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_ft_ovr_dys",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ft_ovr_und_dys",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ft_rt_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bzc_chg_calc",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(130);
                  }
                break;
            case "sheet2":	// Commodity Exception Tariff
                with(sheetObj){
		              var HeadTitle1="|CMDT Exception Tariff|CMDT Exception Tariff|CMDT Exception Tariff|Add Day|Total Day|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Cur.|Amount per CMDT Tariff";
		              var HeadTitle2="|Appl. Date|CMDT|Rep.|Add Day|Total Day|SAT|SUN|H/day|Over|Cur.|Amount per CMDT Tariff";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_expt_aply_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rep_cmdt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"add_dys",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dys",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_ovr_dys",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"cmdt_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(130);
                    }
                break;
            case "sheet3":	// S/C or RFA Exception
                with(sheetObj){
		            var HeadTitle1="|S/C or RFA Exception|S/C or RFA Exception|Request|APVL|Add|Total|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Rate Adjustment|Rate Adjustment|Cur.|Amount per S/C or RFA";
		            var HeadTitle2="|Appl. Date|S/C or APVL No.|Request|APVL|Add|Total|SAT|SUN|H/day|Over|Cur.|First Tier Rate|Cur.|Amount per S/C or RFA";
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_expt_aply_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"sc_apvl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"add_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_expt_ovr_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ft_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rqst_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"apro_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"prop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rfa_expt_dar_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		            InitColumns(cols);
		            SetEditable(1);
                    SetShowButtonImage(2);
                    SetSheetHeight(130);
            }


                break;
            case "sheet4":	// After Booking
                with(sheetObj){
		             var HeadTitle1="|After Booking|Request|APVL|Add Day|Total Day|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over Day|D/C per Container|D/C per Container|D/C per Container";
		             var HeadTitle2="|Approval No.|Request|APVL|Add Day|Total Day|SAT|SUN|H/day|Over Day|Cur.|Amount|Ratio(%)";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                       { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"aft_expt_apro_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"add_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ttl_dys",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0, TrueValue : "Y"  },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aft_expt_ovr_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"dc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dc_rto",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rqst_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"apro_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(130);
             }
                break;
            case "sheet5":	// Clock Stop
                with(sheetObj){
		             var HeadTitle1="|Clock Stop No.|From Date|To Date|Stop Day|Remark(s)";
		             var headCount=ComCountHeadTitle(HeadTitle1);
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"clk_stop_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clk_stop_fm_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clk_stop_to_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stop_day",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"clk_stop_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(130);
                      }
                break; 
        }
    }
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	       case IBSEARCH:      //retrieving
	       		//if(!validateForm(sheetObj,formObj,sAction)) return;
	       		sheetObj.SetWaitImageVisible(0);
	       		sheetObjects[0].SetWaitImageVisible(0);
	       		sheetObjects[1].SetWaitImageVisible(0);
	       		sheetObjects[2].SetWaitImageVisible(0);
	       		sheetObjects[3].SetWaitImageVisible(0);
	       		sheetObjects[4].SetWaitImageVisible(0);
	       		ComOpenWait(true);
	       		formObj.f_cmd.value=SEARCH;
                sheetObj.SetDataAutoTrim(0);
                var sXml=sheetObj.GetSearchData("EES_DMT_3107GS.do", FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
                sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
                sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
                sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
                ComOpenWait(false);
                var bzcTrfCurrCd=ComGetEtcData(arrXml[0], "bzc_trf_curr_cd");
                var orgChgAmt=ComGetEtcData(arrXml[0], "org_chg_amt");
                var cmdtExptAmt=ComGetEtcData(arrXml[0], "cmdt_expt_amt");
                var scRfaExptAmt=ComGetEtcData(arrXml[0], "sc_rfa_expt_amt");
                var aftExptDcAmt=ComGetEtcData(arrXml[0], "aft_expt_dc_amt");
                var bilAmt=ComGetEtcData(arrXml[0], "bil_amt");
                var arrObj=formObj.bzc_trf_curr_cd;
                for(var i=0; i < arrObj.length; i++) {
                	arrObj[i].value=bzcTrfCurrCd;
                }
                if(cmdtExptAmt == '') cmdtExptAmt='0';
                ComSetObjValue(formObj.org_chg_amt, 	ComAddComma2(orgChgAmt+'', "#,###.00"));
                ComSetObjValue(formObj.cmdt_expt_amt, 	ComAddComma2(cmdtExptAmt+'', "#,###.00"));
                ComSetObjValue(formObj.sc_rfa_expt_amt, ComAddComma2(scRfaExptAmt+'', "#,###.00"));
                ComSetObjValue(formObj.aft_expt_dc_amt, ComAddComma2(aftExptDcAmt+'', "#,###.00"));
                ComSetObjValue(formObj.bil_amt,			ComAddComma2(bilAmt+'', "#,###.00"));
	            break;
	    }
	}
	// Adding a column for Grid balloon
	function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
  			Row=MouseRow();
  			Col=MouseCol();
  			if (Row > 0) {
  				var colSaveNm = ColSaveName(Col);
  				if (colSaveNm == 'rqst_ofc_cd') {
  					SetToolTipText(Row, Col, GetCellValue(Row, "rqst_usr_nm"));
  				}
  				else if (colSaveNm == 'apro_ofc_cd') {
  					SetToolTipText(Row, Col, GetCellValue(Row, "apro_usr_nm"));
  				}
  				else {
  					SetToolTipText(Row, Col, "");
  				}
  			}
  		}
  	}
	// Mouse click in the data area that occurs when cells Event
	//function sheet3_OnClick(sheetObj, row, col, value, cellX, cellY, cellW, cellH) {
	// Data cells that occurs when a pop-up button is pressed Event
	function sheet3_OnPopupClick(sheetObj, row, col) {
		with(sheetObj){
			// S/C or APVL No. 데이터셀 더블 클릭시
			if(ColSaveName(col) == 'sc_apvl_no') {
				var scApvlNo=GetCellValue(row, col);
				if(scApvlNo == '') return;
				if(scApvlNo.length <= 10) {
					// S/C Exception Entry Screen call
					var propNo=GetCellValue(row, "prop_no");
					ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=3107', 1020, 710, "findCustomer", "1,0,1,1,1,1,1", true);
				} else {
					//  Before Booking Approval Screen call
					var srcName='sheet3';
					var darNo=GetCellValue(row, "rfa_expt_dar_no");
					ComOpenPopup('EES_DMT_2005P.do?dar_no=' + darNo + '&caller=3107&sheetId=' + srcName, 1020, 645, "findCustomer", "1,0,1,1,1,1,1", true);
				}
			}
		} // with end
	}
	// Grid Adding a column for the balloon
	function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
  		with(sheetObj){
  			Row=MouseRow();
  			Col=MouseCol();
  			if (Row > 0) {
  				var colSaveNm = ColSaveName(Col);
  				if (colSaveNm == 'rqst_ofc_cd') {
  					SetToolTipText(Row, Col, GetCellValue(Row, "rqst_usr_nm"));
  				}
  				else if (colSaveNm == 'apro_ofc_cd') {
  					SetToolTipText(Row, Col, GetCellValue(Row, "apro_usr_nm"));
  				}
  				else {
  					SetToolTipText(Row, Col, "");
  				}
  			}
  		}
  	}
	/**
	 * Screen form validation process for processing the input values
	 */
	function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
	    }
	    return true;
	}
	/* developers work end */
