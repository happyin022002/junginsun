/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1002.js
*@FileTitle  : Basic Tariff Creation - Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//  Business Global Variables
	var ROWMARK="|";
	var FIELDMARK="=";
	var PERIOD_GAP=15;
	var IBNEXT=51;
	var cmnc_hr_array=new Array("01","02","03","04","05","06","07","08","09","10"
								  ,"11","12","13","14","15","16","17","18","19","20","21","22","23");
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		/*******************************************************/
		var formObject=document.form;
    	try {
            var srcObj=window.event.srcElement;
            var srcName=ComGetEvent("name");
    		switch(srcName) {
	         	case "btns_clendar1": //Calendar button
                    if(ComIsBtnEnable(srcName)) {
//	         		if(srcObj.style.cursor == "hand") {
	         			var cal=new ComCalendar();
    					cal.select(formObject.eff_dt, 'yyyy-MM-dd');
	         		}
					break;
		        case "btns_clendar2": //Calendar button
                    if(ComIsBtnEnable(srcName)) {
//		        	if(srcObj.style.cursor == "hand") {
		                var cal=new ComCalendar();
		                cal.select(formObject.exp_dt, 'yyyy-MM-dd');
		        	}
	                break;
		        case "btn_add":
                    if(ComIsBtnEnable(srcName)) {
//		        	if(srcObj.style.cursor == "hand") {
		        		ComSheet2SheetCheck(sheetObject1, sheetObject2, "checkBox");
		        		sheetObject1.SetHeaderCheck(0, "checkBox", false);
		        		sheetObject2.SetHeaderCheck(0, "checkBox", false);
		        	}
	                break;
		        case "btn_del":
                    if(ComIsBtnEnable(srcName)) {
//		        	if(srcObj.style.cursor == "hand") {
		        		ComSheet2SheetCheck(sheetObject2, sheetObject1, "checkBox");
		        		sheetObject1.SetHeaderCheck(0, "checkBox", false);
		        		sheetObject2.SetHeaderCheck(0, "checkBox", false);
		        	}
	                break;
				case "btn_rowadd":
		        	if(ComIsBtnEnable(srcName)) {
		        		doActionIBSheet(sheetObject3,formObject,IBINSERT);
		        	}
					break;
				case "btn_rowdelete":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
					}
					break;
				case "btn_rowadd2":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
					}
					break;
				case "btn_rowdelete2":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
					}
					break;
				case "btn_save":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;
				case "btn_next":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject2,formObject,IBNEXT);
					}
					break;
				case "btn_close":
//					ComClosePopup(); 
					ComPopUpReturnValue("Y");
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    initAxonControl();
	    var formObj=document.form;
    	var today="";
    	var v_dmdt_bzc_trf_grp_nm="";
		searchCurrencyList(ComGetObjValue(formObj.cvrg_cnt_cd));
		wknd1.innerHTML=ComGetObjValue(formObj.wknd1);
		wknd2.innerHTML=ComGetObjValue(formObj.wknd2);
        //Update
    	if(ComGetObjValue(formObj.button_mode) == "U" ) {
    		setIntitUpdate();
            //TRF_RGN, TRF_GRP Select .
            for(var i=0; i < sheetObjects.length; i++){
    			if( i == 0) continue;
                doActionIBSheet(sheetObjects[i],formObj,IBSEARCH);
            }
            v_dmdt_bzc_trf_grp_nm=ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm);
            //
//            ComEnableObject(formObj.btn_add, false);
//        	ComEnableObject(formObj.btn_del, false);
            ComEnableObject(formObj.btn_add, true);
        	ComEnableObject(formObj.btn_del, true);
        	changeGroupType(formObj.dmdt_trf_grp_tp_cd);
        //Expire
    	}else if(ComGetObjValue(formObj.button_mode) == "E" ){
    		setInitExpire();
    		for(var i=0; i < sheetObjects.length; i++){
    			if( i == 0) continue;
                doActionIBSheet(sheetObjects[i],formObj,IBSEARCH);
            }
            v_dmdt_bzc_trf_grp_nm=ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm);
    		changeGroupType(formObj.dmdt_trf_grp_tp_cd);
    	//Create
    	}else if(ComGetObjValue(formObj.button_mode) == "C" ){
    		setInitCreate();
            //for(var i=0;i<sheetObjects.length;i++){
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            //}
            formObj.dmdt_chg_cmnc_tp_cd.selectedIndex=-1;
    	}
    	ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, v_dmdt_bzc_trf_grp_nm);
    	//cvrg region, state 
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_ste_cd));
    	} else {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd,  ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
    	//org_dest region, state 
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_ste_cd));
    	} else {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd,  ComGetObjValue(formObj.org_dest_rgn_cd));
    	}	    
    }
	function initAxonControl() { 
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); // out of focus
//		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus
//		axon_event.addListenerFormat('keypress','obj_keypress', document.form); // Keyboard input
	}
//	function obj_activate() {
//		
//	    obj = event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus = obj.dataformat;
//
//	    switch(obj.dataformat) {
//        case "engup":
//          	ComKeyOnlyAlphabet('uppernum');          
//            break;   
//	    }   
//	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        ComClearSeparator(event.srcElement);
    	//alert("focus_in");
    }
   // out of focus
    function obj_blur(){
    	//check inputing Validation + Inserting separator 
		var obj=event.srcElement;
		if(obj.name != "dmdt_bzc_trf_grp_nm")
			ComChkObjValid(obj);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                var HeadTitle="||CNTR Type|Cargo Type|cntr_code|cargo_code";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"checkBox" },
                    {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                    {Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd" },
                    {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_cd" } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(204);
               }
                break;
            case 2:      // sheet2 init
                with (sheetObj) {
                var HeadTitle="||CNTR Type|Cargo Type|cntr_code|cargo_code";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"checkBox" },
                    {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
                    {Type:"Text",      Hidden:1, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd" },
                    {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_cd" } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(202);
			   }
                break;
            case 3:      // sheet3 init
                with (sheetObj) {
                var HeadTitle="|CNTR Q'ty|CNTR Q'ty|Free Day|";
                var HeadTitle2="|From|Up To|Free Day|";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_fm_qty",   KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
                    {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_to_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Int",       Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",      KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                    {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trf_ft_seq" } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(162);
			   }
                break;
            case 4:      // sheet4 init
                with (sheetObj) {
                var HeadTitle="|Over Day|Over Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day|";
                var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT|";
                var headCount=ComCountHeadTitle(HeadTitle);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ft_ovr_dys",        KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                 {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ft_und_dys",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                 {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:"cntr_20ft_rt_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                 {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:"cntr_40ft_rt_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                 {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:"cntr_hc_rt_amt",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                 {Type:"Float",     Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:"cntr_45ft_rt_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
                 {Type:"Text",      Hidden:1, Width:115,  Align:"Right",   ColMerge:0,   SaveName:"trf_rt_seq" } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(162);
			   }
                break;
        }
    }
	function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
			//Tariff Type 
			case IBSEARCH:
				var comboDatas;
				switch(sComboAction) {
					//3-1.Currency 
					case COMMAND05:
						//1.Inquiry ago, the parameter is set to a value type or allows selected.
						ComSetObjValue(formObj.f_cmd, COMMAND05);
						//2.Inquiry as a query is run conditions
						var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
						ComClearCombo(formObj.currency);
						comboDatas=ComGetEtcData(sXml, sComboKey);
						if (comboDatas != undefined) {
							comboDatas="=|" + comboDatas;
							addComboItem(formObj.currency,comboDatas,true);
						}
						break;		
				};
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }	
	  // Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
			case IBSEARCH:      // Retrieve
				if(sheetObj.id == "sheet1") {
					if(ComGetObjValue(formObj.button_mode) == "C") {
						ComSetObjValue(formObj.f_cmd, SEARCH);
					}else{
						ComSetObjValue(formObj.f_cmd, SEARCH04);
					}
                    //ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj) );
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    //ComOpenWait End
                    ComOpenWait(false);
                    //TOTAL COUNT = 0,  Next button deactivating 
					if(sheetObj.GetTotalRows()== 0) {
						ComBtnDisable("btn_next");
					}
				} else if(sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					setParameters(SEARCH01);	//
                    //ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
					//searxh
                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
                    //ComOpenWait End
                    ComOpenWait(false);
					//FormSetting
					ComSetObjValue(formObj.cmnc_hr, 	ComTrim(ComGetEtcData(sXml, "cmnc_hr")));
					ComSetObjValue(formObj.curr_cd, 	ComTrim(ComGetEtcData(sXml, "curr_cd")));
					ComSetObjValue(formObj.currency, 	ComTrim(ComGetEtcData(sXml, "curr_cd")));
					ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, ComTrim(ComGetEtcData(sXml, "dmdt_bzc_trf_grp_nm")));
					ComSetObjValue(formObj.dmdt_chg_cmnc_tp_cd, ComTrim(ComGetEtcData(sXml, "dmdt_chg_cmnc_tp_cd")));
					ComSetObjValue(formObj.dmdt_trf_grp_tp_cd, 	ComTrim(ComGetEtcData(sXml, "dmdt_trf_grp_tp_cd")));
					if(ComGetObjValue(formObj.button_mode) == "C") {
						ComSetObjValue(formObj.eff_dt, 		"");
					}else{
						ComSetObjValue(formObj.eff_dt, 		ComTrim(ComGetEtcData(sXml, "eff_dt")));
					}
					ComSetObjValue(formObj.exp_dt, 		ComTrim(ComGetEtcData(sXml, "exp_dt")));
					if(ComTrim(ComGetEtcData(sXml, "xcld_hol_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_hol_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_hol_flg, "");
					}
					if(ComTrim(ComGetEtcData(sXml, "xcld_sat_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_sat_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_sat_flg, "");
					}
					if(ComTrim(ComGetEtcData(sXml, "xcld_sun_flg")) == "Y") {
						ComSetObjValue(formObj.xcld_sun_flg, "Y");
					}else{
						ComSetObjValue(formObj.xcld_sun_flg, "");
					}
				} else if(sheetObj.id == "sheet3") {
					if(ComGetObjValue(formObj.button_mode) == "U") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setParameters(SEARCH02);		
		                    //ComOpenWait Start
		                    sheetObj.SetWaitImageVisible(0);
		                    ComOpenWait(true);
		                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj) );
							sheetObj.LoadSearchData(sXml,{Sync:1} );
		                    //ComOpenWait End
		                    ComOpenWait(false);
		                    sheetObj.SetCellValue(sheetObj.LastRow(), "ft_to_qty","");
						}
					}else if(ComGetObjValue(formObj.button_mode) == "E") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setParameters(SEARCH02);		
							//ComOpenWait Start
		                    sheetObj.SetWaitImageVisible(0);
		                    ComOpenWait(true);
		                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj) );
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							//ComOpenWait End
		                    ComOpenWait(false);
							sheetObj.SetCellValue(sheetObj.LastRow(), "ft_to_qty","");
						}
					}
				} else if(sheetObj.id == "sheet4") {
					if(ComGetObjValue(formObj.button_mode) == "U") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setParameters(SEARCH03);		
							//ComOpenWait Start
		                    sheetObj.SetWaitImageVisible(0);
		                    ComOpenWait(true);
		                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj) );
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							//ComOpenWait End
		                    ComOpenWait(false);
		                    sheetObj.SetCellValue(sheetObj.LastRow(), "ft_und_dys","");
						}
					}else if(ComGetObjValue(formObj.button_mode) == "E") {
						if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setParameters(SEARCH03);		
							//ComOpenWait Start
		                    sheetObj.SetWaitImageVisible(0);
		                    ComOpenWait(true);
		                    var sXml=sheetObj.GetSearchData("EES_DMT_1002GS.do", FormQueryString(formObj) );
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							//ComOpenWait End
		                    ComOpenWait(false);
							sheetObj.SetCellValue(sheetObj.LastRow(), "ft_und_dys","");
						}
					}
				}
				break;
			case IBINSERT:
				if (sheetObj.id == "sheet3") {
					var row=sheetObj.DataInsert(-1);
					//first row
					if(row == 2) {
						sheetObj.SetCellValue(row, "ft_fm_qty",1,0);
						sheetObj.SelectCell(row, "ft_to_qty");
					} else {
						//Up to : Row Add  
						if(sheetObj.GetCellValue(row - 1, "ft_to_qty") == "") {
							ComShowCodeMessage("DMT02002", "Up to");
							sheetObj.RowDelete(-1,false);
						}else{
							var value=parseInt(sheetObj.GetCellValue(row - 1, "ft_to_qty")) + 1;;
							sheetObj.SetCellValue(row, "ft_fm_qty",value,0);
							sheetObj.SelectCell(row, "ft_to_qty");
						}
					}
				} else if(sheetObj.id == "sheet4") {
					var row=sheetObj.DataInsert(-1);
					//first row
					if(row == 2) {
						sheetObj.SetCellValue(row, "ft_ovr_dys",1,0);
						sheetObj.SelectCell(row, "ft_und_dys");
					} else {
						///Up to : Row Add   
						if(sheetObj.GetCellValue(row - 1, "ft_und_dys") == "") {
							ComShowCodeMessage("DMT02002", "Up to");
							sheetObj.RowDelete(-1,false);
						}else{
							var value=parseInt(sheetObj.GetCellValue(row - 1, "ft_und_dys")) + 1;
							sheetObj.SetCellValue(row, "ft_ovr_dys",value,0);
							sheetObj.SelectCell(row, "ft_und_dys");
						}
					}
				}
				break;
			case IBDELETE:
				if (sheetObj.id == "sheet3") { 
					sheetObj.RowDelete(sheetObj.RowCount()+1, false);
				} else if(sheetObj.id == "sheet4") {
					sheetObj.RowDelete(sheetObj.RowCount()+1, false);
				}
				break;
			case IBSAVE:        // save
				if(ComGetObjValue(formObj.button_mode) == "C") {
					ComSetObjValue(formObj.f_cmd, MULTI);
					setParameters(MULTI);
				}else if(ComGetObjValue(formObj.button_mode) == "U") {
					ComSetObjValue(formObj.f_cmd, MULTI01);
					setParameters(MULTI01);
				}else if(ComGetObjValue(formObj.button_mode) == "E") {
					ComSetObjValue(formObj.f_cmd, MULTI02);
					setParameters(MULTI02);
				}
				if(!validateForm(sheetObj,formObj,sAction)) return;
				//Free Time 0 
				var ft_day_zero_check=false;
				if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U") {
					if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
						for(var i=2 ; i < sheetObjects[2].RowCount()+2; i++) {
							if(sheetObjects[2].GetCellValue(i, "ft_dys") == 0) {
								ft_day_zero_check=true;
								break;
							}
						}
					}
				}
				if(ft_day_zero_check) {
					if(!ComShowCodeConfirm('DMT01138')) return false;
				}
				//
				sheetObjects[2].SetCellValue(sheetObjects[2].LastRow(), "ft_to_qty",0,0);
				sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(), "ft_und_dys",0,0);
				var sParam1=sheetObjects[1].GetSaveString(true);
				var sParam2=sheetObjects[2].GetSaveString(true);
				var sParam3=sheetObjects[3].GetSaveString(true);
				var sParam4=FormQueryString(formObj);
				sheetObjects[2].SetCellValue(sheetObjects[2].LastRow(), "ft_to_qty","",0);
				sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(), "ft_und_dys","",0);
				sParam1=ComSetPrifix(sParam1, "grid1") + "&";
				sParam2=ComSetPrifix(sParam2, "grid2") + "&";
				sParam3=ComSetPrifix(sParam3, "grid3") + "&";
				var sParam=sParam1 + sParam2 + sParam3 + FormQueryString(formObj);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("EES_DMT_1002GS.do", sParam);
				//3.Save and processing results
                sheetObj.LoadSaveData(sXml);
                //ComOpenWait End
                ComOpenWait(false);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				if(ComGetObjValue(formObj.success_yn) == "Y"){
					//////////////////////////////////////////////////////
					if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U" ){
						sheetObjects[1].RemoveAll();
						ComBtnDisable("btn_save");
						if(sheetObj.RowCount()== 0){
							ComBtnDisable("btn_next");
						}else{
							ComBtnEnable("btn_next");
						}
						if(ComGetObjValue(formObj.button_mode) == "U"){
							ComSetObjValue(formObj.button_mode, "C");
						}
					}else{
						//sheetObjects[0].RemoveAll();
						ComBtnDisable("btn_save");
						if(sheetObj.RowCount()== 0){
							ComBtnDisable("btn_next");
						}else{
							ComBtnEnable("btn_next");
						}
					}
					////////////////////////////////////////////
				}else{
					ComBtnEnable("btn_save");
					ComBtnDisable("btn_next");
				}
				break;
			case IBNEXT:
				for(var i=sheetObj.GetTotalRows()+1 ; i > 0 ; i--) {
					sheetObj.RowDelete(-1,false);
				}
				ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "");
				//ComSetObjValue(formObj.eff_dt, 	ComGetObjValue(formObj.eff_dt));
				ComSetObjValue(formObj.exp_dt, 	"");
				//ComSetObjValue(formObj.cmnc_hr, ComGetObjValue(formObj.cmnc_hr));
				//ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.curr_cd));
				formObj.xcld_hol_flg.checked=false;
				formObj.xcld_sat_flg.checked=false;
				formObj.xcld_sun_flg.checked=false;
				formObj.dmdt_trf_grp_tp_cd.selectedIndex=0;
				//formObj.dmdt_chg_cmnc_tp_cd.selectedIndex 	= -1;
				//formObj.currency.selectedIndex 				= -1;
				changeGroupType(formObj.dmdt_trf_grp_tp_cd);
				for(var i=sheetObjects[2].RowCount()+1 ; i > 0 ; i--) {
					sheetObjects[2].RowDelete(i,0);
				}
				for(var i=sheetObjects[3].RowCount()+1 ; i > 0 ; i--) {
					sheetObjects[3].RowDelete(i,0);
				}
				ComBtnEnable("btn_save");
				if(sheetObjects[0].RowCount()== 0){
					ComBtnDisable("btn_next");
				}else{
					ComBtnEnable("btn_next");
				}
				break;
        }
    }
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		var currency=ComGetObjValue(formObj.currency);
		ComSetObjValue(formObj.curr_cd, ComGetObjValue(formObj.currency));	//curr_cd
	}	
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSAVE:
    				//Create, Update
    				if(ComGetObjValue(formObj.button_mode) == "C" || ComGetObjValue(formObj.button_mode) == "U") {
    					//Billable, Group Name
    					if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd)=="B" && ComGetObjValue(formObj.dmdt_bzc_trf_grp_nm) == "") {
							ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('DMT02002', "Group Name"));
							return false;
						}
    					//Effective DT
	    				if(ComGetObjValue(formObj.eff_dt) == "") {
	    					ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('DMT02002', "Effective DT"));
							return false;
	    				}
	    				//Billable 
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd)=="B") {
		    				if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "") {
		    					ComAlertFocus(formObj.dmdt_chg_cmnc_tp_cd, ComGetMsg('DMT02002', "F/Time Commence"));
								return false;
		    				}
		    				if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "3") {
		    					if(ComGetObjValue(formObj.cmnc_hr) == "") {
		    						ComAlertFocus(formObj.cmnc_hr, ComGetMsg('DMT02002', "F/Time Commence Hour"));
									return false;
		    					}
		    				}
		    				if(ComTrim(ComGetObjValue(formObj.currency)) == "") {
		    					ComAlertFocus(formObj.currency, ComGetMsg('DMT02002', "Currency"));
								return false;
		    				}
	    				}
	    				//combination= 0, can not save
	    				if(sheetObjects[1].GetTotalRows()== 0) {
	    					ComShowCodeMessage("DMT02002", "CNTR, CGO Type");
	    					return false;
	    				}
	    				//Billable 
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
	    					if(sheetObjects[2].RowCount()== 0 ) {
	    						ComShowCodeMessage("DMT02002", "F/Time");
	    						return false;
	    					}
	    					if(sheetObjects[3].RowCount()== 0 ) {
	    						ComShowCodeMessage("DMT02002", "Rate");
	    						return false;
	    					}
	    				}
	    				//Billable 
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
		    				//F/Time Exclusion check 
		    				for(var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
		    					if(sheetObjects[2].GetCellValue(i, "ft_fm_qty") == "") {
		    						ComShowCodeMessage("DMT02002", "CNTR Q'ty From");
		    						sheetObjects[2].SelectCell(i, "ft_fm_qty");
		    						return false;
		    					}
		    					if(i != parseInt(sheetObjects[2].LastRow())) {
		    						if(sheetObjects[2].GetCellValue(i, "ft_to_qty") == "") {
		    							ComShowCodeMessage("DMT02002", "CNTR Q'ty Up To");
			    						sheetObjects[2].SelectCell(i, "ft_to_qty");
			    						return false;
			    					}	
		    					}
//		    					if(sheetObjects[2].CellValue(i, "ft_dys") == 0) {
//		    						ComShowCodeMessage("DMT02002", "Free Day");
//		    						sheetObjects[2].SelectCell(i, "ft_dys");
//		    						return false;
//		    					}	    					
		 					}
		    				//F/Time Commence check
		    				for(var i=sheetObjects[3].HeaderRows(); i<= sheetObjects[3].LastRow(); i++) {
		    					if(sheetObjects[3].GetCellValue(i, "ft_ovr_dys") == "") {
		    						ComShowCodeMessage("DMT02002", "Over Day From");
		    						sheetObjects[3].SelectCell(i, "ft_ovr_dys");
		    						return false;
		    					}
		    					if(i != parseInt(sheetObjects[3].LastRow())) {
		    						if(sheetObjects[3].GetCellValue(i, "ft_und_dys") == "") {
		    							ComShowCodeMessage("DMT02002", "Over Day Up To");
			    						sheetObjects[3].SelectCell(i, "ft_und_dys");
			    						return false;
			    					}
		    					}
		    					if(sheetObjects[3].GetCellValue(i, "cntr_20ft_rt_amt") < 0) {
		    						ComShowCodeMessage("DMT01128", "Rate Per Day 20FT", "0");
		    						sheetObjects[3].SelectCell(i, "cntr_20ft_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].GetCellValue(i, "cntr_40ft_rt_amt") < 0) {
		    						ComShowCodeMessage("DMT01128", "Rate Per Day 40FT", "0");
		    						sheetObjects[3].SelectCell(i, "cntr_40ft_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].GetCellValue(i, "cntr_hc_rt_amt") < 0) {
		    						ComShowCodeMessage("DMT01128", "Rate Per Day H/C", "0");
		    						sheetObjects[3].SelectCell(i, "cntr_hc_rt_amt");
		    						return false;
		    					}
		    					if(sheetObjects[3].GetCellValue(i, "cntr_45ft_rt_amt") < 0) {
		    						ComShowCodeMessage("DMT01128", "Rate Per Day 45FT", "0");
		    						sheetObjects[3].SelectCell(i, "cntr_45ft_rt_amt");
		    						return false;
		    					}
		    					// 
//		    					if(i > sheetObjects[3].HeaderRows()) {
//			    					if(sheetObjects[3].GetCellValue(i, "cntr_20ft_rt_amt") < sheetObjects[3].GetCellValue(i-1, "cntr_20ft_rt_amt")) {
//			    						ComShowCodeMessage("DMT01128", "Rate Per Day 20FT", "previous Over Day's rate");
//			    						sheetObjects[3].SelectCell(i, "cntr_20ft_rt_amt");
//			    						return false;
//			    					}
//			    					if(sheetObjects[3].GetCellValue(i, "cntr_40ft_rt_amt") < sheetObjects[3].GetCellValue(i-1, "cntr_40ft_rt_amt")) {
//			    						ComShowCodeMessage("DMT01128", "Rate Per Day 40FT", "previous Over Day's rate");
//			    						sheetObjects[3].SelectCell(i, "cntr_40ft_rt_amt");
//			    						return false;
//			    					}
//			    					if(sheetObjects[3].GetCellValue(i, "cntr_hc_rt_amt") < sheetObjects[3].GetCellValue(i-1, "cntr_hc_rt_amt")) {
//			    						ComShowCodeMessage("DMT01128", "Rate Per Day H/C", "previous Over Day's rate");
//			    						sheetObjects[3].SelectCell(i, "cntr_hc_rt_amt");
//			    						return false;
//			    					}
//			    					if(sheetObjects[3].GetCellValue(i, "cntr_45ft_rt_amt") < sheetObjects[3].GetCellValue(i-1, "cntr_45ft_rt_amt")) {
//			    						ComShowCodeMessage("DMT01128", "Rate Per Day 45FT", "previous Over Day's rate");
//			    						sheetObjects[3].SelectCell(i, "cntr_45ft_rt_amt");
//			    						return false;
//			    					}
//		    					}
		 					}
	    				}
	    				//Billable
	    				if(ComGetObjValue(formObj.dmdt_trf_grp_tp_cd) == "B") {
	    					var last_ft_to_qty=sheetObjects[2].GetCellValue(sheetObjects[2].LastRow(), "ft_to_qty" );
	    					var last_ft_und_dys=sheetObjects[3].GetCellValue(sheetObjects[3].LastRow(), "ft_und_dys" );
		    				if(last_ft_to_qty != "" || last_ft_to_qty != 0) {
		    					ComShowCodeMessage("DMT00149");
		    					//sheetObjects[2].CellValue2(sheetObjects[2].LastRow, "ft_to_qty" ) = "";
		    					return false;
		    				}
		    				if(last_ft_und_dys != "" || last_ft_und_dys != 0) {
		    					ComShowCodeMessage("DMT00150");
		    					//sheetObjects[3].CellValue2(sheetObjects[3].LastRow, "ft_und_dys" ) = "";
		    					return false;
		    				}
		    				//F/Time Exclusion : From, UpTo Data Check
		    				for(var i=sheetObjects[2].HeaderRows(); i < sheetObjects[2].LastRow(); i++) {
		    					if(ComParseInt(sheetObjects[2].GetCellValue(i, "ft_fm_qty")) > ComParseInt(sheetObjects[2].GetCellValue(i, "ft_to_qty"))) {
		    						ComShowCodeMessage("DMT01032", "[CNTR Q'ty] ");
		    						sheetObjects[2].SetCellValue(i, "ft_to_qty","",0);
		    						return false;
		    					}
		 					}
		    				//F/Time Commence : From, UpTo Data Check 
		    				for(var i=sheetObjects[3].HeaderRows(); i < sheetObjects[3].LastRow(); i++) {
		    						if(ComParseInt(sheetObjects[3].GetCellValue(i, "ft_ovr_dys")) > ComParseInt(sheetObjects[3].GetCellValue(i, "ft_und_dys"))) {
		    						ComShowCodeMessage("DMT01032", "[Over Day] ");
		    						sheetObjects[3].SetCellValue(i, "ft_und_dys","",0);
		    						return false;
		    					}
		 					}		    				
	    				}
	    			//Expire
    				}else if(ComGetObjValue(formObj.button_mode) == "E") {
    					if(ComGetObjValue(formObj.eff_dt) == "") {
	    					ComAlertFocus(formObj.dmdt_trf_grp_tp_cd, ComGetMsg('COM12113', "Effective Date"));
							return false;
	    				}
    					//exp_dt >= eff_dt 
    					var from_dt=ComGetObjValue(formObj.eff_dt);
    					var to_dt=ComGetObjValue(formObj.exp_dt);
    					if(ComChkPeriod(from_dt, to_dt) == 0) {
    						ComAlertFocus(formObj.exp_dt, ComGetMsg('COM12133', "Expiration Date", "Effective Date", "greater than or equal"));
							return false;
    					}
    				}
    				break;
    		}
        }
        return true;
    }
    /**
     * add data  combo field 
     */	
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			comboItems=comboDatas.split(ROWMARK);	
	    	for (var i=0 ; i < comboItems.length ; i++) {
    			comboItem=comboItems[i].split(FIELDMARK);
				val=comboItem[0];
				txt=isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
    		}
		}   		
	}
    /**
     * Search Currency of Rate Adjustment Sheet
     */	
	function searchCurrencyList(cnt_cd) {
		var sheetObj=sheetObjects[3];
		var formObj=document.form;
		ComSetObjValue(formObj.cnt_cd, cnt_cd);
		doActionIBCombo(sheetObj,formObj,IBSEARCH,COMMAND05,"CURRENCY");
	}
	/**
	 * Group Type: If Billable, activating. If Exempted deactivating
	 * @param object
	 * @return
	 */
    function changeGroupType(object) {
    	var formObj=document.form;
    	if(ComGetObjValue(object) == "B") {
    		//Expire
    		if(ComGetObjValue(formObj.button_mode) == "E") {
    			ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, false);
	   			ComEnableObject(formObj.xcld_sat_flg, false);
	   			ComEnableObject(formObj.xcld_sun_flg, false);
	   			ComEnableObject(formObj.xcld_hol_flg, false);
	   			//F/Time Commence
	   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
   				ComEnableObject(formObj.cmnc_hr, false);
   				formObj.cmnc_hr.className="input2";
	   			ComEnableObject(formObj.currency, false);
	   			//CNTR QTY activating 
				sheetObjects[2].SetEditable(0);
	   			//Over Day activating 
				sheetObjects[3].SetEditable(0);
				//RowAdd
				ComBtnDisable("btn_rowadd");
				ComBtnDisable("btn_rowdelete");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_rowdelete2");
				formObj.dmdt_bzc_trf_grp_nm.className="input2";
	   			formObj.dmdt_chg_cmnc_tp_cd.className="input2";
	   			formObj.currency.className="input2";
    		}else {
				ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, true);
	   			ComEnableObject(formObj.xcld_sat_flg, true);
	   			ComEnableObject(formObj.xcld_sun_flg, true);
	   			ComEnableObject(formObj.xcld_hol_flg, true);
	   			//F/Time Commence
	   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
	   			if(ComGetObjValue(formObj.dmdt_chg_cmnc_tp_cd) == "3") {
	   				ComEnableObject(formObj.cmnc_hr, true);
	   				formObj.cmnc_hr.className="input1";
	   			} else {
	   				ComEnableObject(formObj.cmnc_hr, false);
	   				formObj.cmnc_hr.className="input2";
	   			}
	   			ComEnableObject(formObj.currency, true);
	   			//CNTR QTY activating 
				sheetObjects[2].SetEditable(1);
	   			//Over Day activating 
				sheetObjects[3].SetEditable(1);
				//RowAdd
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				ComBtnEnable("btn_rowadd2");
				ComBtnEnable("btn_rowdelete2");
				ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "");
	   			formObj.dmdt_bzc_trf_grp_nm.className="input1";
	   			formObj.dmdt_chg_cmnc_tp_cd.className="input1";
	   			formObj.currency.className="input1";
    		}
    	}else if(ComGetObjValue(object) == "N"){
   			ComEnableObject(formObj.dmdt_bzc_trf_grp_nm, false);
   			ComEnableObject(formObj.xcld_sat_flg, false);
   			ComEnableObject(formObj.xcld_sun_flg, false);
   			ComEnableObject(formObj.xcld_hol_flg, false);
   			//F/Time Commence
   			ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
   			ComEnableObject(formObj.cmnc_hr, false);
   			ComEnableObject(formObj.currency, false);
   			//CNTR QTY activating 
			sheetObjects[2].SetEditable(0);
   			//Over Day activating 
			sheetObjects[3].SetEditable(0);
			//RowAdd
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_rowdelete2");
			//Group Name Expemted
			ComSetObjValue(formObj.dmdt_bzc_trf_grp_nm, "Exempted");
   			formObj.dmdt_bzc_trf_grp_nm.className="input2";
			//F/Time Exclusion
			ComSetObjValue(formObj.xcld_sat_flg, "");
			ComSetObjValue(formObj.xcld_sun_flg, "");
			ComSetObjValue(formObj.xcld_hol_flg, "");
			//for(var i = sheetObjects[2].TotalRows+1 ; i > 1 ; i--) {
			for(var i=sheetObjects[2].RowCount()+1 ; i > 1 ; i--) {
				sheetObjects[2].SetRowHidden(i,1);
				//sheetObjects[2].RowDelete(-1,false);
				sheetObjects[2].SetRowStatus(i,"D");
			}
			//F/Time Commence
			formObj.dmdt_chg_cmnc_tp_cd.selectedIndex=-1;
			formObj.currency.selectedIndex=-1;
			//myCombo.Code = -1;
			ComSetObjValue(formObj.cmnc_hr, "");
			//ComSetObjValue(formObj.currency, "");
			//for(var i = sheetObjects[3].TotalRows+1 ; i > 1 ; i--) {
			for(var i=sheetObjects[3].RowCount()+1 ; i > 1 ; i--) {
				sheetObjects[3].SetRowHidden(i,1);
				//sheetObjects[3].RowDelete(-1,false);
				sheetObjects[3].SetRowStatus(i,"D");
			}
    	}
    }
    /**
     * F/Time Commence set
     * @param object
     * @return
     */
    function changeGroupCd1(object) {
    	var formObj=document.form;
    	if(ComGetObjValue(object) == "3") {
    		ComEnableObject(formObj.cmnc_hr, true);
			formObj.cmnc_hr.className="input1";
    	} else {
    		ComEnableObject(formObj.cmnc_hr, false);
			formObj.cmnc_hr.className="input2";
			ComSetObjValue(formObj.cmnc_hr, "");
    	}
    }
    function changeCmncHr() {
    	var formObj=document.form;
    	var tempCheck=false;
    	for(var i=0 ; i< cmnc_hr_array.length; i++) {
    		if(ComGetObjValue(formObj.cmnc_hr) == cmnc_hr_array[i]) {
    			tempCheck=true;
    			break;
    		}
    	}
    	if(!tempCheck) {
			ComShowCodeMessage("COM12187","01 ~ 23");
			ComClearObject(formObj.cmnc_hr);
			ComSetFocus(formObj.cmnc_hr);
			return;
    	}
    }
    /**
     * 
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function sheet1_OnClick(sheetObj, row, col, Value) {
        if(sheetObj.ColSaveName(col) == "checkBox")
              ComSyncAllCheck(sheetObj, col, Value);
    }
    function sheet2_OnClick(sheetObj, row, col, Value) {
        if(sheetObj.ColSaveName(col) == "checkBox")
             ComSyncAllCheck(sheetObj, col, Value);
    }
    //F/Time Exclusion After you change the value, the event-handling
    function sheet3_OnAfterEdit(sheetObj, row, col) {
    	var sName=sheetObj.ColSaveName(col);
    	var value=sheetObj.GetCellValue(row, col);
    	if(sName == "ft_to_qty") {
    		var ft_to_num=parseInt(sheetObj.GetCellValue(row, "ft_to_qty"));
    		var ft_fm_num=parseInt(sheetObj.GetCellValue(row, "ft_fm_qty"));
			if(ft_fm_num > ft_to_num) {
				ComShowCodeMessage("DMT01032", "[CNTR Q'ty] ");
				sheetObj.SetCellValue(row, "ft_to_qty","",0);
				return;
			}
			sheetObj.SetCellValue(row+1, "ft_fm_qty",parseInt(sheetObj.GetCellValue(row, "ft_to_qty")) + 1,0);
    	}
    }
    //F/Time Commence After you change the value, the event-handling
    function sheet4_OnAfterEdit(sheetObj, row, col) {
    	var sName=sheetObj.ColSaveName(col);
    	var value=sheetObj.GetCellValue(row, col);
    	if(sName == "ft_und_dys") {
    		var ft_ovr_num=parseInt(sheetObj.GetCellValue(row, "ft_ovr_dys"));
    		var ft_und_num=parseInt(sheetObj.GetCellValue(row, "ft_und_dys"));
			if( ft_ovr_num > ft_und_num) {
				ComShowCodeMessage("DMT01032", "[Over Day] ");
				sheetObj.SetCellValue(row, "ft_und_dys","",0);
				return;
			}
			sheetObj.SetCellValue(row+1, "ft_ovr_dys",parseInt(sheetObj.GetCellValue(row, "ft_und_dys")) + 1,0);
    	}
    }
    /**
	 * sheet1 Processing after Retrieving
	 */
	function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
	}
    /**
     * Expire Button Click
     */
    function setInitExpire() {
    	var formObj=document.form;
    	//set
    	if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA" ) {
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd, ComGetObjValue(formObj.org_dest_ste_cd));
    	}else{
    		ComSetObjValue(formObj.org_dest_rgn_ste_cd, ComGetObjValue(formObj.org_dest_rgn_cd));
    	}
    	if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA" ) {
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComGetObjValue(formObj.cvrg_ste_cd));
    	}else{
    		ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComGetObjValue(formObj.cvrg_rgn_cd));
    	}
		ComEnableObject(formObj.btns_clendar1, false);
		ComEnableObject(formObj.btns_clendar2, true);
		ComEnableObject(formObj.btn_add, false);
		ComEnableObject(formObj.btn_del, false);
    	//비activating 
		formObj.dmdt_trf_grp_tp_cd.disabled=true;
		formObj.dmdt_bzc_trf_grp_nm.readOnly=true;
		formObj.eff_dt.readOnly=true;
		formObj.exp_dt.readOnly=false;
		formObj.dmdt_chg_cmnc_tp_cd.disabled=true;
		formObj.cmnc_hr.readOnly=true;
		formObj.currency.disabled=true;
		formObj.dmdt_trf_grp_tp_cd.className="input2";
		formObj.dmdt_bzc_trf_grp_nm.className="input2";
		formObj.eff_dt.className="input2";
		formObj.exp_dt.className="input1";
		formObj.dmdt_chg_cmnc_tp_cd.className="input2";
		formObj.cmnc_hr.className="input2";
		formObj.currency.className="input2";
		//Button
		ComBtnDisable("btn_rowadd");
		ComBtnDisable("btn_rowdelete");
		ComBtnDisable("btn_rowadd2");
		ComBtnDisable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, false);
		ComEnableObject(formObj.cmnc_hr, false);
		ComEnableObject(formObj.currency, false);
		ComEnableObject(formObj.xcld_sat_flg, false);
		ComEnableObject(formObj.xcld_sun_flg, false);
		ComEnableObject(formObj.xcld_hol_flg, false);
		for(var i=0; i < sheetObjects.length ; i++) {
			sheetObjects[i].SetEditable(0);
		}
    }
    function setIntitUpdate() {
    	var formObj=document.form;
		ComEnableObject(formObj.btns_clendar1, true);
		ComEnableObject(formObj.btns_clendar2, false);
		ComEnableObject(formObj.btn_add, true);
		ComEnableObject(formObj.btn_del, true);
		formObj.eff_dt.readOnly=false;
		formObj.exp_dt.readOnly=true;
		//Button
		ComBtnEnable("btn_rowadd");
		ComBtnEnable("btn_rowdelete");
		ComBtnEnable("btn_rowadd2");
		ComBtnEnable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
		ComEnableObject(formObj.cmnc_hr, true);
		ComEnableObject(formObj.currency, true);
		//
    }
    function setInitCreate() {
    	var formObj=document.form;
    	ComEnableObject(formObj.btns_clendar1, true);
   		formObj.eff_dt.readOnly=false;
		ComEnableObject(formObj.btns_clendar2, false);
		formObj.exp_dt.readOnly=true;
		ComEnableObject(formObj.btn_add, true);
		ComEnableObject(formObj.btn_del, true);
		//Button
		ComBtnEnable("btn_rowadd");
		ComBtnEnable("btn_rowdelete");
		ComBtnEnable("btn_rowadd2");
		ComBtnEnable("btn_rowdelete2");
		ComBtnDisable("btn_next");
		// F/Time Commence 
		ComEnableObject(formObj.dmdt_chg_cmnc_tp_cd, true);
		ComEnableObject(formObj.cmnc_hr, false);
		ComEnableObject(formObj.currency, true);
		formObj.dmdt_chg_cmnc_tp_cd.className="input1";
		formObj.cmnc_hr.className="input2";
		formObj.currency.className="input1";
    }
    //onUnLoad Event
    function unLoadPage(){
		window.returnValue="Y";
    }
