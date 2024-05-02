/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4006.js
*@FileTitle  : Manual Invoice Report by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================**/

/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    
	// Common Global variables

	var sheetObjects=new Array();
	var sheetCnt=0;
	
	var comboObjects=new Array();
	var comboCnt=0;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btns_calendar":
                        var cal=new ComCalendarFromTo();
                        cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
                break;
                case "btn_downexcel":
                	if(sheetObjects[0].RowCount() < 1){//no data						
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
                	}               	
                break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
                case "btn_new":
                	sheetObjects[0].RemoveAll();
                	
                    var formObj=document.form;
                    ComResetAll();
                    DmtComSetClassManyObjects('input1', formObj.fm_dt, formObj.to_dt);
                    var ofcCurrDate=DmtComOfficeCurrDate(sheetObject1, formObject);
                    // set Period
                    var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
                    var toDt=ofcCurrDate;
                    ComSetObjValue(formObj.fm_dt, fmDt);
                    ComSetObjValue(formObj.to_dt, toDt);
                    ofc_rdo_flg_click();
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                    comboObjects[1].SetSelectCode("All");
                break;
                case "btn_minimize":
                    var schCondDiv=document.getElementById("sch_cond_div");
                    if(schCondDiv.style.display == 'block') {   // conditions 
                        schCondDiv.style.display='none';
                        sheetObjects[0].SetSheetHeight(500);
                    } else {
                        schCondDiv.style.display='block';
                        sheetObjects[0].SetSheetHeight(405);
                    }
                break;
                case "btn_detatil":
                    doProcessPopup(srcName);
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
    // pop up
    function doProcessPopup(srcName) {
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var sUrl='';
        var sWidth='';
        var sHeight='';
        with(sheetObj) {
            switch(srcName) {
                case 'btn_detatil':
                    if(CheckedRows("Check") == 0) {
                        ComShowCodeMessage('COM12114', 'Manual Invoice');
                        return;
                    }
                    var chkCnt=0;
                    var chkRows=FindCheckedRow("Check").split("|");
                    var prevOfcCd=GetCellValue(chkRows[0], "office");
                    var chkRsnCd='';
                    var chkCurCd='';
                    for(var i=0; i < chkRows.length-1; i++) {
                    	var currOfcCd=GetCellValue(chkRows[i], "office");
                        // Multiple selection is possible only for an Office (Office of the items that you select a different check)
                        if(currOfcCd != prevOfcCd) {
                            ComShowCodeMessage('DMT01066');
                            return;
                        }
                        var rsnCd=GetCellValue(chkRows[i], "reasonn");
                        chkRsnCd += ',' + rsnCd; 
                        var curCd=GetCellValue(chkRows[i], "cur");
                        chkCurCd += ',' + curCd; 
                    }
                    var fmdt=formObj.fm_dt.value;
                    var todt=formObj.to_dt.value;
                    var ofcflg=ComGetObjValue(formObj.ofc_rdo_flg);
                    var paramVal='?fmdt='+fmdt+'&todt='+todt+'&ofcflg='+ofcflg+'&office='+prevOfcCd+'&reason='+chkRsnCd+'&selcur='+chkCurCd+'&issoff=&jspno=4006';
                    sUrl='EES_DMT_4007.do' + paramVal;
                break;
            }
        }
        //ComOpenPopupWithTarget( sUrl , 905 , 600 , "" , "0,1,1,1,1,1,1" , true );
        ComOpenPopupWithTarget( sUrl , "1280", "720", "", "0,1,1,1,1,1,1", true);
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
        // IBMultiCombo initializing 
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        //initializing html control event
        initControl();
        var formObj=document.form;
        DmtComSetClassManyObjects('input1', formObj.fm_dt, formObj.to_dt);
        var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj);
        // set Period
        var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
        var toDt=ofcCurrDate;
        ComSetObjValue(formObj.fm_dt, fmDt);
        ComSetObjValue(formObj.to_dt, toDt);
        ofc_rdo_flg_click();                
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);        
        comboObjects[1].SetSelectCode("All");
    }
   // event function
    function initControl() {
//        axon_event.addListener('blur',  'obj_blur', 'to_mvmt_mon', 'fm_dt', 'to_dt');   //- out of focus
//        axon_event.addListener('focus', 'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt');  // Get focus
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- on press keyboard
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListener('click', 'ofc_rdo_flg_click', 'ofc_rdo_flg');        // DEM/DET Office ratido button click
//        axon_event.addListener('click', 'dt_flg_click', 'dt_flg');          // Date ratido button click
//        axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox click
    }
    // DEM/DET Office Radio Button click event 
    function ofc_rdo_flg_click() {    	
        var formObj=document.form;
        var ofcFlg=ComGetObjValue(formObj.ofc_rdo_flg);
        var comboObj=comboObjects[0];
        
        if (ofcFlg == 'R') {
            // RHQ
            doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
            ComEnableObject(formObj.chk_sub_ofc, false);
            ComEnableObject(formObj.office, false);
            ComClearObject(formObj.chk_sub_ofc);
            // RHQ is selected, the Default login area RHQ Office Code
            var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
            var headOffice=ComGetObjValue(formObj.head_office);
            if(usrRhqOfcCd == headOffice){
                usrRhqOfcCd="All";
            }
            else{            	
                comboObj.SetEnable(0);
            }
            ComSetObjValue(comboObj, usrRhqOfcCd);
            formObj.grpbyor.disabled=false;
        } 
        else {
            // Office        	
            comboObj.SetEnable(1);
            doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
            ComEnableObject(formObj.chk_sub_ofc, true);            
            formObj.grpbyor.disabled=true;
            formObj.grpbyor.value="0";            
        }
    }
   // out of focus
    function obj_blur(){
        //check inputing Validation + Inserting separator 
        var obj=event.srcElement;
        ComChkObjValid(obj);
    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj=event.srcElement;
        ComClearSeparator(obj);
        //If you have a block of text so as to choose.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    //business javascript OnKeyPress event handling
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            /*
            case "engup":
                // upper case + numbers 
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                //only numbers
                ComKeyOnlyNumber(event.srcElement);
                break;
            */
            default:
                // only numbers(integer, date, time)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    /*
     * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
     */
	function doInclSubOfc() {
    	 var formObj=document.form;
    	 if (formObj.chk_sub_ofc.checked) { // Sub Office 
	          if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
	              ComShowCodeMessage('COM12113', "DEM/DET Office");
	              formObj.chk_sub_ofc.checked=false;
	              return;
	          }
	          formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
	          formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);
	          doActionIBCombo( sheetObjects[0] , formObj , comboObjects[0] , IBSEARCH_ASYNC03);
	      } else {
	    	  comboObjects[0].SetSelectIndex(-1);
	    	  comboObjects[0].SetSelectCode(formObj.tmp_ofc_cd.value);
	      }
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
                with(sheetObj){		                
		              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              //(21, 0, 0, true);
		              sheetObj.FrozenCols=5;
		              var HeadTitle=" ||Seq.|Office|Reason for Manual Invoice|TTL INV Q'TY|Cur.|TTL Billing AMT|DMIF|DMIF|DTIC|DTIC|DMOF|DMOF|DTOC|DTOC|CTIC|CTIC|CTOC|CTOC|";
		              var HeadTitle2=" ||Seq.|Office|Reason for Manual Invoice|TTL INV Q'TY|Cur.|TTL Billing AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|INV|AMT|";
		
		              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Check",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"office",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:175,  Align:"Left",    ColMerge:1,   SaveName:"reason",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttlinvqty",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cur",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttlbllamt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dmifinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"dmifamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dticinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"dticamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dmofinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"dmofamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dtocinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"dtocamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cticinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cticamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ctocinv",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ctocamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"reasonn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

		              InitColumns(cols);
		              ShowSubSum([{StdCol:"office", SumCols:"ttlinvqty|ttlbllamt|dmifinv|dmifamt|dticinv|dticamt|dmofinv|dmofamt|dtocinv|dtocamt|cticinv|cticamt|ctocinv|ctocamt", Sort:true, ShowCumulate:false, CaptionCol:-1, OtherColText:"Check=;office=%s;cur=;seq=S.TTL"}]);
		              		
		              SetEditable(1);
		              //no support[check again]CLT ToolTipOption="balloon:true;width:50;";
		              SetToolTipText(0,"ttlinvqty","Total No. of Invoices");
		              SetSheetHeight(440);
              	}
            	break;
        }
    }
   // Process of Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:     // Search
                if(!validateForm(sheetObj,formObj,sAction)) return;
                
                sheetObj.RemoveAll();
                
                formObj.f_cmd.value=SEARCH;
                formObj.ofc_flg.value=ComGetObjValue(formObj.ofc_rdo_flg);
                sheetObj.SetWaitImageVisible(0);
                
                ComOpenWait(true);
                var sXml = sheetObj.GetSearchData("EES_DMT_4006GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml, {Sync:1});                
                ComOpenWait(false);
            break;
            
            case IBSEARCH_ASYNC01:              
                formObj.f_cmd.value=SEARCH01;                 
                var sXml=sheetObj.GetSearchData("EES_DMT_4006GS.do", FormQueryString(formObj));
                if (sXml != undefined && sXml != '') {             
                    comboObjects[1].RemoveAll();
                    comboObjects[1].SetMultiSelect(0);
                    comboObjects[1].SetColWidth(0, "320");
                    comboObjects[1].ValidChar(2); 
                    //MaxLength = 6;
                    var data=ComGetEtcData(sXml, "reasoncd");
                    var data2=data.split("^");
                    if (data2 != undefined && data2 != '') {
                        comboObjects[1].InsertItem(0, "All", "All");
                        for (var i18=0 ; i18 < data2.length-1 ; i18++) {
                            var comboItems=data2[i18].split("||");
                            comboObjects[1].InsertItem(i18+1, comboItems[1], comboItems[0]);     
                        }
                    }
                }                
            break;
         }
     }
     /**
     * Initializing Combo 
     * param : comboObj , comboNo
     *  adding case as numbers of counting Combos
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form;

        switch(comboObj.options.id) {  

        	case "office":
                with (comboObj) {
                    //MultiSelect = false;
                    SetUseAutoComplete(1);
                    SetColBackColor(0,"#CCFFFD");
                    SetColAlign(0, "left");
                    //SetColWidth(0, "350");
                    SetDropHeight(160);
                    ValidChar(2); // use upper case
                    SetMaxLength(5);
                    SetMultiSeparator(",");
                }
            break;
            
            case "reasoncd":
                with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
                    SetColBackColor(0,"#CCFFFD");  
                    SetColAlign(0, "left");
                    SetColWidth(0, "350");
                    SetDropHeight(200);
                    ValidChar(2); // use upper case
                    // MaxLength = 5;
                }
            break;
        }
    }
    // Search IBCombo data and setting
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
         sheetObj.ShowDebugMsg(false);
         sheetObj.SetWaitImageVisible(0);
         formObj.f_cmd.value=formCmd;
         switch(formCmd) {
            case COMMAND06: // RHQ
                with (comboObj) { 
                    RemoveAll();
                    SetMultiSelect(0);
                    SetColWidth(0, "60");
                    ValidChar(2);   // 
                    //MaxLength = 6;
                }             	
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
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
                    SetMultiSeparator(",");
                    SetMultiSelect(1);                    
                    SetColWidth(0, "90");
                    ValidChar(2, 2); 
                }             	
                var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var data=ComGetEtcData(sXml, "OFC_CD");
                if (data != undefined && data != '') {
                	var usrOfcCd=ComGetObjValue(formObj.h_user_office);
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
            	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
            	if (sXml != undefined && sXml != '') {
                    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
                    var comboObj=comboObjects[0];
                    if(ofc_cds != '') 
                        comboObj.SetSelectCode(ofc_cds);
                    var usr_ofc_cd=document.form.h_user_office.value;
                    comboObjects[0].SetSelectCode(usr_ofc_cd, false);
                }else{
                    var usr_ofc_cd=document.form.h_user_office.value;
                    comboObjects[0].SetSelectCode(usr_ofc_cd, false);
                }                
                break;
            case IBSEARCH_ASYNC03:      
                //3. Sub Office comboList
                formObj.f_cmd.value=COMMAND01;                 
                var sXml2=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                var subOfcCds=ComGetEtcData(sXml2, "OFC_CD");
                if (subOfcCds != undefined && subOfcCds != '') {
    	 			var usrOfcCd=ComGetObjValue(formObj.h_user_office);
					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds=usrOfcCd + ',' + subOfcCds;
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
                break;
         }
         sheetObj.SetWaitImageVisible(1);
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             switch(sAction) {
                case IBSEARCH:
                    var dtFlg="P";
                    if(dtFlg == 'M') {
                        if(!ComIsDate(to_mvmt_mon, "ym")) {
                            ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Date Month'));
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
                    var ofcCd=comboObjects[0].GetSelectCode();
                    if(ComIsEmpty(ofcCd)) {
                        ComShowCodeMessage('COM12113', "DEM/DET Office");
                        return false;
                    }
                    ComSetObjValue(ofc_cd, ofcCd);
                    break;
            } // switch - end
         } // with - end
         return true;
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
   		if (formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
    function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg){
        with(sheetObj){
            SetSumText(0, "seq","TTL");
        }
    }
    function keyPress() {
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    document.onkeypress=keyPress ;    
