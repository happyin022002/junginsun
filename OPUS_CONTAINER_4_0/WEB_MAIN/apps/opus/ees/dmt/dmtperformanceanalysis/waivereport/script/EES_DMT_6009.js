/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6009.js
*@FileTitle  : Waive Report by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    // Common Global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
    // Event handler processing by button name
    function processButtonClick(){
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        try {
            var srcObj=ComGetEvent();
            var srcName= ComGetEvent("name");
                switch(srcName) {
                    case "btns_calendar":
                        var cal=new ComCalendarFromTo();
                        cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
                    	break;
                    case "btn_retrieve":
                        doActionIBSheet(sheetObj,formObj,IBSEARCH);
                    	break;
                    case "btn_new":
                        doInit();
                        break;
                    case "btn_minimize":
                        var schCondDiv=document.getElementById("sch_cond_div");
                        if(schCondDiv.style.display == 'block') {
                            schCondDiv.style.display='none';
                        } else {
                            schCondDiv.style.display='block';
                        }
                        break;
                    case "btn_downexcel":
                    	if(sheetObj.RowCount() < 1){//no data
                    		ComShowCodeMessage("COM132501");
                    	}else{
                    		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                    	}
                    	break;
                    case "btns_ctrt_ofc":
                        var ofcFlg=ComGetObjValue(formObj.ofc_flg2);
                        if ( ofcFlg == "O" ) {                        
                            ComOpenPopup('COM_ENS_071.do', 770, 476, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
                        }
                        break;
                    case "btn_detail":
                    	openDetailPopup(sheetObj, formObj);
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
    
    function getCtrtOfcCd(aryPopupData) {
        document.form.ofc_cd2.value=aryPopupData[0][3];
        var ofcFlg=ComGetObjValue(document.form.ofc_flg2);
        if ( ofcFlg == "R" ) {
            ComboObjects[1].SetSelectCode(aryPopupData[0][3]);
        } else if ( ofcFlg == "O" ) {
            document.form.location.value=aryPopupData[0][3];
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
    
    //comboObjects array generated in the registration page to IB Combo Object
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
        //IBMultiCombo initializing
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        //initializing html control event
        initControl();
        ComBtnDisable("btn_downexcel");
        ComBtnDisable("btn_detail");
        document.form.slctofccd.value="";
        document.form.location.value=document.form.usr_ofc_cd.value;
        
        onLoadFinish();
    }
    
    function onLoadFinish() {
        var formObj=document.form
        sheetObjects[0].SetWaitImageVisible(0);
        // Search Tariff Type MultiCombo List
        doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);
        //OPENscreen 
        doInit();
        sheetObjects[0].SetWaitImageVisible(1);
    } 
    
    // Event-handling function declarations
    function initControl() {
         axon_event.addListener('blur',  'obj_blur', 'to_mvmt_mon', 'fm_dt', 'to_dt'); // out of focus
//         axon_event.addListener('focus', 'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt'); // Get focus
         axon_event.addListenerFormat('keypress','obj_keypress', document.form); // Keyboard input
         axon_event.addListenerFormat('keypress','keyPress', document.form); // Keyboard input
         axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//        axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
		//        axon_event.addListener('click', 'ofc_flg2_click', 'ofc_flg2');
		//        axon_event.addListener('click', 'dt_flg_click', 'dt_flg');
		//        axon_event.addListener('change', 'reqapp_change', 'reqapp');
    }
    
	function reqapp_change() {
		var formObj=document.form;
		var obj=formObj.reqapp;
		if(ComGetObjValue(obj) == 'A') {	// (A: Approval / R: Request)
			if(ComGetObjValue(formObj.ofc_flg2) == 'O') {
				ComSetObjValue(formObj.ofc_flg2, "R");
				ofc_flg2_click();
			}
			ComEnableObject(formObj.ofc_flg2[1], false);
		} else {
			ComEnableObject(formObj.ofc_flg2[1], true);
		}
	}
	
    // initializing Screen
    function doInit() {
        var formObj=document.form;
        ComResetAll();
        // To MVMT Date: Retrieving conditions initializing
        dt_flg_click();
        // DEM/DET Office: Retrieving conditions initializing (Default: RHQ)
        if(formObj.ofc_flg2[1].disabled)
        	ComEnableObject(formObj.ofc_flg2[1], true);
        
        ofc_flg2_click();
        ofc_flg_click();
        
        ComBtnDisable("btn_downexcel");
      	ComBtnDisable("btn_detail");        
        document.form.slctofccd.value="";
        document.form.location.value=document.form.usr_ofc_cd.value; 
        
        cntr_type.SetSelectIndex(0);
    }
    
    function dt_flg_click() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        with(formObj) {
            var dtFlg=ComGetObjValue(dt_flg);
            var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
            if(dtFlg == 'M') {
                ComEnableObject(to_mvmt_mon, true);
                ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
                DmtComSetClassManyObjects('input1', to_mvmt_mon);
                DmtComSetClassManyObjects('input2', fm_dt, to_dt);
                //ComSetObjValue(to_mvmt_mon, ComGetNowInfo("ym"));
    	 		ComSetObjValue(to_mvmt_mon, ofcCurrDate.substring(0, 7));
                ComClearManyObjects(fm_dt, to_dt);
            } else {
                ComEnableObject(to_mvmt_mon, false);
                ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
                DmtComSetClassManyObjects('input1', fm_dt, to_dt);
                DmtComSetClassManyObjects('input2', to_mvmt_mon);
                // set Period
                var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
                var toDt=ofcCurrDate;
                ComSetObjValue(fm_dt, fmDt);
                ComSetObjValue(to_dt, toDt);
                ComClearManyObjects(to_mvmt_mon);
            }
        } // with-end
    }
    
    // DEM/DET Office Radio Button click event handling
    function ofc_flg_click() {
        var formObj=document.form;
        var ofcFlg=ComGetObjValue(formObj.ofc_flg);
        var comboObj=comboObjects[2];
        if(ofcFlg == 'R') {
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComEnableObject(formObj.chk_sub_ofc, false);
            ComClearObject(formObj.chk_sub_ofc);
            // RHQ is selected, the Default login area RHQ Office Code
            var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
            var headOffice=ComGetObjValue(formObj.head_office);
            if(usrRhqOfcCd == headOffice)
                usrRhqOfcCd="All";
            ComSetObjValue(comboObj, usrRhqOfcCd);
        } else {
            // Office
            doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            ComEnableObject(formObj.chk_sub_ofc, true);
        }
    }
    
    // DEM/DET Office Radio Button click event handling
    function ofc_flg2_click() {
        var formObj=document.form;
        var ofcFlg=ComGetObjValue(formObj.ofc_flg2);
        var comboObj=comboObjects[1];
        if(ofcFlg == 'R') {
            div_ofc2_txt.style.display="none";
            div_ofc2_com.style.display="";            
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComBtnDisable("btns_ctrt_ofc");
            // RHQ is selected, the Default login area RHQ Office Code
            var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
            var headOffice=ComGetObjValue(formObj.head_office);
            if(usrRhqOfcCd == headOffice)
                usrRhqOfcCd="All";
            ComSetObjValue(comboObj, usrRhqOfcCd);
            document.form.location.value="";
            document.form.grp_flg.disabled=false;
            ComEnableManyObjects(false, document.form.tempuser, document.form.btns_ctrt_ofc);
        } else {
            // Office
            div_ofc2_txt.style.display="";
            div_ofc2_com.style.display="none";
            ComBtnEnable("btns_ctrt_ofc");
            comboObjects[1].SetSelectCode(-1);
            document.form.grp_flg.disabled=true;
            document.form.grp_flg.value="O";
            ComEnableManyObjects(true, document.form.tempuser, document.form.btns_ctrt_ofc);
            document.form.location.value=document.form.usr_ofc_cd.value; 
        }
    }
    
    // out of focus
    function obj_blur(){
        //check inputing Validation + Inserting separator 
        var obj= ComGetEvent();
        ComChkObjValid(obj);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj=ComGetEvent();
        ComClearSeparator(obj);
        //If you have a block of text so as to choose.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
    //business javascript OnKeyPress event handling
//    function obj_keypress() {
//         switch(ComGetEvent().dataformat){
//            case "engup":
//                // upper case + numbers 
//                ComKeyOnlyAlphabet('uppernum', ',');
//                break;
//            case "int":
//                //only numbers
//                ComKeyOnlyNumber(ComGetEvent());
//                break;
//            default:
//                // only numbers(integer, date, time)
//                ComKeyOnlyNumber(ComGetEvent());
//         }
//     }
    
    /*
     * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
     */
    function doInclSubOfc() {
        var formObj=document.form;
        var comboObj=comboObjects[2];
        if (formObj.chk_sub_ofc.checked) {   // Sub Office 
            if (ComIsEmpty(comboObj.GetSelectCode())) {
                ComShowCodeMessage('COM12113', "Office");
                formObj.chk_sub_ofc.checked=false;
                return;
            }
            formObj.ofc_cd.value=ComGetObjValue(comboObj);
            formObj.tmp_ofc_cd.value=ComGetObjValue(comboObj);
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
        } else {
            ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
        }
    }
    
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            		var HeadTitle1="||Seq.|Request|Tariff|S/C No.|RFA No.|Customer|Customer|Cur.|Incurred|Incurred|CMDT Exception|CMDT Exception|Exception(A)|Exception(A)|Discount(B)|Discount(B)|Waived Total(A+B)|Waived Total(A+B)|Waived Total(A+B)";
            		var HeadTitle2="||Seq.|Request|Tariff|S/C No.|RFA No.|Code|Name|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|vs. Incurred";
            		var headCount=ComCountHeadTitle(HeadTitle1);
            		var avgLine="Trunc ( ( ( |amt5| / |amt1| ) * 100 ), 2 )";
            		SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
            		InitHeaders(headers, info);
            		var cols = [ {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"localcur",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"office",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tariff",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
            		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scno",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfano",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cuscode",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cusname",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cur",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"cntr1",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt1",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"cntr2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt2",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"cntr3",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt3",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"cntr4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt4",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"cntr5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"amt5",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"incurred",  KeyField:0,   CalcLogic:avgLine,Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
            		InitColumns(cols);
            		SetEditable(1);
//                  SetExtendLastCol(0);
                    SetSheetHeight(430);
              	}
                break;
        }
    }
    
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      // Retrieve
                if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value=SEARCH;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                var sXml=sheetObj.GetSearchData("EES_DMT_6009GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false);
            break;
            
            case IBSAVE:        // save
              if(validateForm(sheetObj,formObj,sAction))
            break;
              
            case IBINSERT:      // insert
            break;
        }
    }
    
    /**
     * Initializing Combo 
     * param : comboObj , comboNo
     * adding case as numbers of counting Combos 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form;
        switch(comboObj.options.id) {  
            case "office": 
                with (comboObj) {
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetDropHeight(160);
                    SetColBackColor(0,"#CCFFFD");
                }
            break;
            
            case "office2": 
                with (comboObj) {
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetDropHeight(160);
                    SetColBackColor(0,"#CCFFFD");
                }
            break;
            
            case "tariff_type":
                with (comboObj) { 
                    SetMultiSelect(1);
                    SetMultiSeparator(","); 
                    SetColAlign(0, "left");
                    SetColWidth(0, "100");
                    SetDropHeight(160);
                    SetColBackColor(0,"#CCFFFD");
                }
            break;
            
            case "cntr_type":
                with (comboObj) { 
                    SetMultiSelect(0);
                    SetColAlign(0, "left");
                    SetColWidth(0, "125");
                    SetDropHeight(160);
                }
                comboObj.InsertItem(0, "All",       "A");
                comboObj.InsertItem(1, "Dry",       "D");
                comboObj.InsertItem(2, "Reefer",    "R");
                comboObj.InsertItem(3, "Special",   "S");
                comboObjects[3].SetSelectCode("A");
            break;
        }
    }
    
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg(false);
         sheetObj.SetWaitImageVisible(0);
         formObj.f_cmd.value=formCmd;
         var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
         switch(formCmd) {
            case SEARCHLIST:    // tariff type
                var data=ComGetEtcData(sXml, "common_tariff_cd");
                if (data != undefined && data != '') {
                    comboObj.InsertItem(0, "All", "All");
                    var comboItems=data.split("|");
                    for(var i=0; i < comboItems.length; i++) {
                        var item=comboItems[i].split("=");
                        comboObj.InsertItem(i+1, item[0], item[0]);
                    }
                }
            break;
            
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    SetMultiSelect(0);
                    SetColWidth(0, "80");
                    ValidChar(2);
                }
                
                var data=ComGetEtcData(sXml, "common_cd");
                if (data != undefined && data != '') {
                    var comboItems=data.split("|");
                    comboObj.InsertItem(0, "All", "All");
                    for (var i=0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);     
                    }
                }
            break;
            
            case SEARCHLIST02: // Office
                with (comboObj) { 
                    RemoveAll();
                    SetMultiSelect(1);
                    SetColWidth(0, "95");
                    ValidChar(2, 2);
                }
                
                var data=ComGetEtcData(sXml, "OFC_CD");
                if (data != undefined && data != '') {
                	var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 					var idx=0;
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx=1;
 					}
 		    	    var comboItems=data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
	    	  		comboObj.SetSelectCode(usrOfcCd, false);
                }
            break;
            
            case COMMAND01: // Incl. Sub Office
	            var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
		 		if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds=usrOfcCd + ',' + subOfcCds;
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
            break;
         }
         sheetObj.SetWaitImageVisible(1);
    }
    
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) {
                case IBSEARCH:
                    var dtFlg=ComGetObjValue(dt_flg);
                    if(dtFlg == 'M') {
                        if(!ComIsDate(to_mvmt_mon, "ym")) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date Month'));
                            return false;
                        }
                        var toMvmtMon=ComGetUnMaskedValue(to_mvmt_mon, 'ym');
                        var lastDay=ComGetLastDay(ComParseInt(toMvmtMon.substring(0, 4)), ComParseInt(toMvmtMon.substring(4)));
                        var startDt=toMvmtMon + '01';
                        var endDt=toMvmtMon + '' + lastDay;
                        ComSetObjValue(start_dt, startDt);
                        ComSetObjValue(end_dt, endDt);
                    } else {
                        if(!ComIsDate(fm_dt)) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
                            return false;
                        }
                        if(!ComIsDate(to_dt)) {
                            ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
                            return false;
                        }
                        var startDt=ComGetUnMaskedValue(fm_dt, 'ymd');
                        var endDt=ComGetUnMaskedValue(to_dt, 'ymd');
                        /*
                        ComChkPeriod(fromDate, toDate)
                        0 : fromDate > toDate
                        1 : fromDate < toDate
                        2 : fromDate=toDate
                        */
                        // Check period
                        if (ComChkPeriod(startDt, endDt) == 0) {
                            ComShowCodeMessage("DMT01020");
                            return false;
                        }
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
                        ComSetObjValue(start_dt, startDt);
                        ComSetObjValue(end_dt, endDt);
                    }
                    // DEM/DET Office
                    var ofcFlg=ComGetObjValue(formObj.ofc_flg2);
                    if ( ofcFlg == "R" ) {
                        var ofcCd2=comboObjects[1].GetSelectCode();
                        if(ComIsEmpty(ofcCd2)) {
                            ComShowCodeMessage('COM12113', "Waive Office");
                            return false;
                        }
                        ComSetObjValue(ofc_cd2, ofcCd2);
                    } else if ( ofcFlg == "O" ) {
                        var ofcCd2=document.form.location.value;
                        if(ComIsEmpty(ofcCd2)) {
                            ComShowCodeMessage('COM12113', "Waive Office");
                            return false;
                        }
                        ComSetObjValue(ofc_cd2, ofcCd2);
                    }
                    var ofcCd=comboObjects[2].GetSelectCode();
                    if(ComIsEmpty(ofcCd)) {
                        ComShowCodeMessage('COM12113', "DEM/DET Office");
                        return false;
                    }
                    ComSetObjValue(ofc_cd, ofcCd);
                    // Tariff Type
                    var trfCd=comboObjects[0].GetSelectCode();
                    if(ComIsEmpty(trfCd)) {
                        ComShowCodeMessage('COM12113', "Tariff Type");
                        return false;
                    }
                    if(trfCd.indexOf('All') != -1)
                        trfCd=ComReplaceStr(trfCd, "All,", "");
                    ComSetObjValue(dmdt_trf_cd, trfCd);
                    // CNTR Type
                    var cntrType2=comboObjects[3].GetSelectCode();
                    if(ComIsEmpty(cntrType2)) {
                        ComShowCodeMessage('COM12113', "CNTR Type");
                        return false;
                    }
                    ComSetObjValue(dmdt_cntr_tp_cd, cntrType2);
                    break;
            } // switch - end
        } // with(formObj) - end
        return true;
    }
    
    /*
     * Pop-up call processing
     */
    function doProcessPopup(srcName) {
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var sUrl='';
        var sWidth='';
        var sHeight='';
        var paramVal='';
        with(sheetObj) {
            if(CheckedRows("chk") == 0) {
                ComShowCodeMessage('COM12114', 'Detail Charge');
                return;
            }
            var chkCnt=0;
            var chkRows=FindCheckedRow("chk").split("|");
            var prevOfcCd=GetCellValue(chkRows[0], "ofc_cd");
            var chkTrfCd='';
            for(var i=0; i < chkRows.length-1; i++) {
            	var currOfcCd=GetCellValue(chkRows[i], "ofc_cd");
                // Multiple selection is possible only for an Office (Office of the items that you select a different check)
                if(currOfcCd != prevOfcCd) {
                    ComShowCodeMessage('DMT01066');
                    return;
                }
                var trfCd=GetCellValue(chkRows[i], "dmdt_trf_cd");
                chkTrfCd += ',' + trfCd; 
            }
            chkTrfCd=chkTrfCd.substring(1);
            var startDt=ComGetObjValue(formObj.start_dt);
            var endDt=ComGetObjValue(formObj.end_dt);
            var grpFlg=ComGetObjValue(formObj.grp_flg);
            var cntrTp=ComGetObjValue(formObj.dmdt_cntr_tp_cd);
            paramVal="?start_dt=" + startDt + "&end_dt=" + endDt + "&grp_flg=" + grpFlg
                        + "&ofc_cd=" + prevOfcCd + "&dmdt_trf_cd=" + chkTrfCd + "&dmdt_cntr_tp_cd=" + cntrTp;
            var dtlFlg='';
            switch(srcName) {
                case 'btn_Detail':
                    break;
                case 'btn_DetailA':
                    dtlFlg='A';
                    break;
                case 'btn_DetailB':
                    dtlFlg='B';
                    break;
                case 'btn_DetailC':
                    dtlFlg='C';
                    break;
            }
        }
        sUrl='EES_DMT_6002.do' + paramVal + "&dtl_flg=" + dtlFlg;
        sWidth='1020';
        sHeight='567';
        var sWinName=ComReplaceStr(sUrl, '.do', '');
        ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
    }
    
    // Office IBMultiCombo Initialization
    function initComboValue_tariff_type() {
        ComSetObjValue(comboObjects[0], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
    }
    
    // CNTR Type IBMultiCombo Initialization
    function initComboValue_cntr_type() {
        ComSetObjValue(comboObjects[2], "A");
    }
    
    //Tariff Type IBMultiCombo click event
	function tariff_type_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.GetSelectCode();
	    if (index == 0) {
	    	var bChk=comboObj.GetItemCheck(index);
    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    			comboObj.SetItemCheck(i, bChk, false);
	    	}
	    } 
	    else if (comboObj.GetItemCheck(0)) {
			comboObj.SetItemCheck(0, 0, false);
	    } 
	    else if (isTariffAllCheck(comboObj)) {
	    	comboObj.SetItemCheck(0, 1, false);
	    }
	}    

	function isTariffAllCheck(comboObj) {
		var allTariffCnt = comboObj.GetItemCount();
		var selTariffCnt = 0;
		for (var i = 1; i < allTariffCnt; i++) {	// All 항목은 제외
			if (comboObj.GetItemCheck(i)) selTariffCnt++;
		}
		
		return selTariffCnt == allTariffCnt-1;		// 선택항목에서 All 항목은 제외
	}	
	
    // 'Incl. Sub Office 'check box is checked in, Office Multi Select combo should not be permitted.
    function office_OnCheckClick(comboObj, index, code) {
        var formObj=document.form;
        if (formObj.chk_sub_ofc.checked) {
   			if (comboObj.GetItemCheck(index)) {
   				comboObj.SetItemCheck(index, 0, false);
   			}
   			else {
   				comboObj.SetItemCheck(index, 1, false);
   			}
   			ComShowCodeMessage('DMT00107');
   		}
    }
	 
    // multi combo KeyDown Event Catch
    function office_OnKeyDown(comboObj, keycode, shift) {
        var formObj=document.form;
        if(formObj.chk_sub_ofc.checked) {
            ComShowCodeMessage('DMT00107');
        }
    }
    
    function sheet1_OnBeforeCheck( sheetObj , Row , Col ) {
        with (sheetObj) {
            if ( Row > 1 && Col == 0 ) {
                var tCntChkd=0;
                for ( var x=2 ; x < LastRow(); x++ ) {
                	if ( GetCellValue( x , 0 ) == 1 ) {
                        tCntChkd++;
                    }
                }
                if ( tCntChkd == 0 ) {
                    document.form.slctofccd.value="";
                }
                var tSlctOfcCd=document.form.slctofccd.value;
                if ( tSlctOfcCd == '' ) {
                    document.form.slctofccd.value=GetCellText( Row , "office" );
                } else {
                    if ( tSlctOfcCd != GetCellText( Row , "office" ) ) {
                        ComShowCodeMessage('DMT01066');
                        AllowCheck(false);
                    }
                }
            }
        }
    }
    
    function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg)
    {
        with(sheetObj)
        {
            sheetObj.ShowSubSum([{StdCol:"office", SumCols:"cntr1|amt1|cntr2|amt2|cntr3|amt3|cntr4|amt4|cntr5|amt5", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"chk=;office=%s;tariff=;cur=;seq=S.TTL;incurred=Trunc(((|amt5|/|amt1|)*100),2)"}]);
            sheetObj.ShowSubSum([{StdCol:"tariff", SumCols:"cntr1|amt1|cntr2|amt2|cntr3|amt3|cntr4|amt4|cntr5|amt5", Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:"chk=;office=%s;tariff=%s;cur=;seq=S.TTL;incurred=Trunc(((|amt5|/|amt1|)*100),2)"}]);
            SetSumText(0, "seq","TTL");
            
            if ( RowCount() <= 0 ) {
                ComBtnDisable("btn_downexcel");
                ComBtnDisable("btn_detail");
                return; 
            }            
            if ( ComGetObjValue(document.form.reqapp) == "R" ) {
                SetCellValue(0,3,"Request",0);
                SetCellValue(1,3,"Request",0);
            } else {
                SetCellValue(0,3,"Approval",0);
                SetCellValue(1,3,"Approval",0);
            }
//            alert(LastRow());
//            var p;
//            for ( var x=2 ; x < LastRow(); x++ ) {
//            	alert("11111:"+x+" - "+LastCol());
//            	var tCVAL=GetCellValue(x,LastCol());
//            	alert("22222:"+x+" - "+tCVAL);
//            	alert("333333:"+tCVAL.split("."));
//                p=tCVAL.split(".");
//            	alert("44444");
//                p[0]=ComAddComma(p[0]);
//                if ( p.length == 1 ) {
//                    SetCellText(x,LastCol() ,p[0]+".00%");
//                } else if (p.length == 2) {
//                    if ( p[1].length == 1 ) {
//                        SetCellText(x,LastCol() ,p[0]+"."+p[1]+"0%");
//                    } else {
//                        SetCellText(x,LastCol() ,p[0]+"."+p[1]+"%");
//                    }
//                } else {
//                    SetCellText(x,LastCol() ,"");
//                }                    
//            }
            SetSumValue(0,LastCol(),DmtAddComma( ComRound ( GetSumValue(0,"amt5") / GetSumValue(0,"amt1") * 100 ) + "" , "#,###.00"));
            SetSumText(0,LastCol(),GetSumValue(0,LastCol())+"%");
            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_detail");
            document.form.slctofccd.value="";
        }
    }
    
    //That occurs when you move your mouse over the Event Sheet
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            var colName=ColSaveName(MouseCol());        // SaveName
            var msg="";
            switch(colName) {
                case "cntr1":
                case "amt1":
                    msg="DEM/DET Incurrence per Basic Tariff";
                break;
                case "cntr2":
                case "amt2":
                    msg="Exception per Commodity Exception Tariff";
                break;
                case "cntr3":
                case "amt3":
                    msg="Exception per S/C Exception Tariff/Before Booking";
                break;
                case "cntr4":
                case "amt4":
                    msg="Discount per After Booking";
                break;
                case "cntr5":
                case "amt5":
                case "incurred":
                    msg="Exception + Discount";
                break;
                default:
                    msg="";
                break;
            }
            //ToolTipOption = "balloon:true;width:50;";
            SetToolTipText(MouseRow(), MouseCol(), msg);
        }
    }
    
    function keyPress() {
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    document.onkeypress=keyPress ;
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	// Waive Report by Office - Detail 팝업화면 호출
    	openDetailPopup(sheetObj, document.form);
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
        	var formObj=document.form;
            document.form.slcttrfcd.value=sheetObj.GetCellValue( Row , "tariff" );
            document.form.slctscno .value=sheetObj.GetCellValue( Row , "scno" );
            document.form.slctrfano.value=sheetObj.GetCellValue( Row , "rfano" );
            document.form.slctofccd.value=sheetObj.GetCellValue( Row , "office" );
            document.form.curr_flg2.value=sheetObj.GetCellValue( Row , "localcur" );
        }
    }
    
    function DmtAddComma(obj,sFormat)
    {
        try {
            var sVal=getArgValue(obj);
            switch(sFormat)
            {
                case "#,###" :
                        return ComAddComma(sVal);
                case "#,###.0" :
                        p=sVal.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".0";
                        else if (p.length == 2) return p[0]+"."+p[1];
                        else return "";
                case "#,###.00" :
                        p=sVal.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) {
                            return p[0]+".00";
                        } else if (p.length == 2) {
                            if ( p[1].length == 1 ) {
                                return p[0]+"."+p[1]+"0";                                
                            } else {
                                return p[0]+"."+p[1];
                            }
                        } else {
                            return "";
                        }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    function openDetailPopup(sheetObj, formObj) {
    	
		formObj.slcttrfcd.value = sheetObj.GetCellValue( sheetObj.GetSelectRow(), "tariff" );
		formObj.slctscno .value = sheetObj.GetCellValue( sheetObj.GetSelectRow(), "scno" );
		formObj.slctrfano.value = sheetObj.GetCellValue( sheetObj.GetSelectRow(), "rfano" );
		formObj.slctofccd.value = sheetObj.GetCellValue( sheetObj.GetSelectRow(), "office" );
		formObj.curr_flg2.value = sheetObj.GetCellValue( sheetObj.GetSelectRow(), "localcur" );
		
        var param = "?fm_dt="     + formObj.start_dt.value  +
                    "&to_dt="     + formObj.end_dt.value    +
                    "&slctofccd=" + formObj.slctofccd.value +
                    "&reqapp="    + formObj.reqapp.value    +
                    "&ofc_flg2="  + ComGetObjValue(formObj.ofc_flg2) +
                    "&ofc_cd2="   + ComGetObjValue(formObj.ofc_cd2)  +
                    "&slctTrfCd=" + formObj.slcttrfcd.value +
                    "&slctScNo="  + formObj.slctscno.value  +
                    "&curr_flg="  + formObj.curr_flg2.value +
                    "&dmdt_cntr_tp_cd="  + formObj.dmdt_cntr_tp_cd.value  +
                    "&slctRfaNo=" + formObj.slctrfano.value ;
					
        ComOpenPopup("EES_DMT_6010.do"+param, "1220", "700", "", "1,0,1,1,1,1,1,1", true);    	
    }
