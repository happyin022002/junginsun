/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4009.js
*@FileTitle  : OTS Inquiry by Customer & Issue(Outstanding Inquiry by Customer & Issue)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================**/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    
	// common global variables

	var sheetObjects=new Array();
	var sheetCnt=0;
	
    var comboObjects=new Array();
    var comboCnt=0;
    
    var COMMON_TARIFF_CD="common_tariff_cd"; 
    var USER_TARIFF_TYPE="user_tariff_type"; 
    var USER_TARIFF_TYPE_CD;
    var ROWMARK="|";
    var FIELDMARK="=";
    var set_day=180;
    var USR_TRF_TP;
    var DEF_SHEET_HEIGHT = 415;
    
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
         try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btns_payer_cd":
                    openPopup('payc');
                break;
                case "btns_cust_cd":
                    openPopup('cuno');
                break;
                case "btn1_excel":
                    if( sheetObjects[0].RowCount()== 0 ) {
                        ComBtnDisable("btn1_excel");
                        return;
                    }
                    /*if(sheetObject1.RowCount() < 1){//no data						
                    	ComShowCodeMessage("COM132501");
                    }else{
                    	sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
                    }*/
                    sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
                break;
                case "btn1_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
                case "btn1_new":
                    var formObject=document.form;
                    formObject.reset();
                    formObject.combo2.focus();
//                    var data = getDefaultDate(set_day).split("|");
//                    formObject.frdt.value = data[1].substring(0,8)+data[0].substring(8,10);
//                    formObject.todt.value = data[0];
					var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject);
					var fmMvmtDt=ComGetDateAdd(formObject.ofcCurrDate, "D", -180);
					var toMvmtDt=ofcCurrDate;
					ComSetObjValue(formObject.frdt, fmMvmtDt);
					ComSetObjValue(formObject.todt, toMvmtDt);
                    sheetObject1.RemoveAll();
                    for(var k=0;k<comboObjects.length;k++){
                        //initCombo(comboObjects[k],k+1);
                        comboObjects[k].SetSelectCode("-1");
                        comboObjects[k].RemoveAll();
                    }                    
                    for(var k=0;k<comboObjects.length;k++){
                        initCombo(comboObjects[k],k+1);
                    }
                    //comboObjects[1].Code2 = formObj.usr_trf_tp.value;
	                ComBtnDisable("btn1_detail");
	                ComBtnDisable("btn1_fax_send");
	                ComBtnDisable("btn1_email_send");
	                ComBtnDisable("btn1_excel");                     
                break;
                case "btn1_detail":
                    if( sheetObjects[0].RowCount()== 0 ) {
                        ComBtnDisable("btn1_detail");
                        return;
                    }
                    document.form.chk_payer.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 2);
                    document.form.chk_payer2.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 3);
                    //document.form.tftp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 10);
                    document.form.tftp.value=comboObjects[1].GetSelectCode();
                    ComSetObjValue( formObject.isof , comboObjects[0].GetSelectCode());
                    ComSetObjValue( formObject.arif , comboObjects[2].GetSelectCode());
                    ComSetObjValue( formObject.cutp , comboObjects[3].GetSelectCode());
                    var tArif=formObject.arif.value;
                    var logInOff=document.form.h_rhq_off.value;
//                    if ( logInOff != "NYCNA" && logInOff != "SELHO" ) {
//                        if ( tArif == "A" ) {
//                            tArif = "Y,N";
//                        }
//                    }               
                    if ( tArif == "A" ) {
                    	tArif="Y,N";
                    }
                    var param="?isof=" + formObject.isof.value +
                                "&tftp=" + formObject.tftp.value +
                                "&frdt=" + formObject.frdt.value +
                                "&todt=" + formObject.todt.value +
                                "&arif=" + tArif +
                                "&payc=" + formObject.chk_payer.value +
                                "&cutp=" + formObject.cutp.value +
                                "&cuno=" + formObject.cuno.value +
                                "&cude=" + formObject.cude.value +
                                "&scno=" + formObject.scno.value +
                                "&rfan=" + formObject.rfan.value + 
                                "&payn=" + formObject.chk_payer2.value ;
                    ComOpenPopup( "EES_DMT_4011.do"+param , "1030", "700", "" , "0,1", true);
                break;
                case "btns_calendarfm":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                case "btns_calendarto":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                case "btn1_email_send":
                	if(sheetObject1.RowCount() < 1){//no data						
                		return false;
                    }else{
                    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
                    }
                	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
                break;
                case "btn1_fax_send":
                	if(sheetObject1.RowCount() < 1){//no data						
                    	return false;
                    }else{
                    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
                    }
                    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
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
    function openPopup(flag, arg) {
        var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var sUrl='';
        var sWidth='';
        var sHeight='';
        with(sheetObj) {
            switch(flag) {
                case 's_bkg_no':        
                case 's_bl_no':     
                case 's_cntr_no':  
                    var param="?returnval=" + flag;
                    ComOpenPopup('EES_MNR_MULTI.do'+param, 400, 380, 'getMnr_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
                case 'payc':       // Customer Inquiry Popup
                    ComOpenPopup('COM_ENS_041.do', 770, 485, "getPayerCd", "1,0,1,1,1,1,1", true);
                break;
                case 'cuno':       // Customer Inquiry Popup
                    ComOpenPopup('COM_ENS_041.do', 770, 485, "getCustCd", "1,0,1,1,1,1,1", true);
                break;
            } // switch-end
        } // with-end
    }
    function getPayerCd(aryPopupData) {
        document.form.payc.value=aryPopupData[0][3];
        document.form.payn.value=aryPopupData[0][4];
    }  
    function getCustCd(aryPopupData) {
        document.form.cuno.value=aryPopupData[0][3];
        document.form.cude.value=aryPopupData[0][4];
    }      
    /**
     * Register as an array IBSheet Object
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
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        initControl();
        var formObject=document.form; 
//        var data = getDefaultDate(set_day).split("|");
//        formObject.frdt.value = data[1].substring(0,8)+data[0].substring(8,10);
//        formObject.todt.value = data[0];
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject);
		var fmMvmtDt=ComGetDateAdd(formObject.ofcCurrDate, "D", -180);
		var toMvmtDt=ofcCurrDate;
		ComSetObjValue(formObject.frdt, fmMvmtDt);
		ComSetObjValue(formObject.todt, toMvmtDt); 
        comboObjects[1].SetSelectCode(USER_TARIFF_TYPE_CD,false);
        //sheet1_OnSearchEnd();
        ComBtnDisable("btn1_detail");
        ComBtnDisable("btn1_fax_send");
        ComBtnDisable("btn1_email_send");
        ComBtnDisable("btn1_excel");   
//        combo2.SetBackColor("#e9f4ff");
//        combo1.SetBackColor("#e9f4ff");
//        combo3.SetBackColor("#e9f4ff");
    }
    function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); 
//        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form );
        //axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
    }
    function obj_blur(){
        var obj=ComGetEvent();
        if ( ( obj.name == 'frdt' || obj.name == 'todt' ) && document.form.frdt.value != "" && document.form.todt.value != "" ) {
            ComChkObjValid(obj);
        }else if(obj.name == 'payc') {
            doActionText(sheetObjects[0], document.form, obj, SEARCH20);
        }else if(obj.name == 'cuno') {
            doActionText2(sheetObjects[0], document.form, obj, SEARCH19);
        }
    }
    function obj_focus() {
        ComClearSeparator(ComGetEvent());
        ComSetFocus(ComGetEvent());
    }
    function obj_keypress() {
         switch(ComGetEvent("dataformat")){
            case "engup":
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "engup2":
                DmtComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                ComKeyOnlyNumber(ComGetEvent());
                break;
            default:
                ComKeyOnlyNumber(ComGetEvent());
         }
     }
    /** 
     * Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++]=combo_obj;  
    }
    /**
     * Combo basic setting
     * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
     * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
     */ 
    function initCombo(comboObj, comboNo) {
        var formObject=document.form
        switch(comboNo) {  
            case 1: // TARIFF TYPE
                with (comboObj) { 
                    SetMultiSelect(1);
                    //UseAutoComplete = true; 
                    SetColAlign(0, "left");
                    SetColAlign(1, "left");
                    SetColWidth(0, "60");
                    SetColWidth(1, "300");
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
                    ValidChar(2);
                    //no support[check again]CLT IMEMode=0;                    
                    SetDropHeight(160);
                    SetMaxLength(6);
                }
                doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
            break; 
            case 2: // ISSUE OFFICE
                with (comboObj) { 
                    SetMultiSelect(1);
                    SetColAlign(0, "left");
                    SetColAlign(1, "left");
                    SetColWidth(0, "50");
                    SetColWidth(1, "300");
                    SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
                }
                doActionIBCombo(sheetObjects[0], formObject, SEARCHLIST);
            break;
            case 3: // AR IF
                var logInOff=document.form.h_rhq_off.value;
//                if ( logInOff == "NYCNA" || logInOff == "SELHO" ) {
//                    with (comboObj) { 
//                        MultiSelect = true; 
//                        SetColAlign("left|left");   
//                        SetColWidth("100|300");
//                        DropHeight = 160;
//                    }
//                    comboObj.InsertItem( 0 , "All|"                                               , "A" );
//                    comboObj.InsertItem( 1 , "No|"                                                , "N" );
//                    comboObj.InsertItem( 2 , "Yes|"                                               , "Y" );
//                    comboObj.InsertItem( 3 , "Hold|All Reasons"                                   , "H" );
//                    comboObj.InsertItem( 4 , "Hold(Litigation)|Collection Agency/Litigation Only" , "L" );
//                    comboObj.Code2 = "N";                    
//                } else {
                    with (comboObj) { 
                        SetMultiSelect(0);
                        //UseAutoComplete = true; 
                        SetColAlign(0, "left");
                        SetColWidth(0, "100");
                        SetDropHeight(160);
    					SetColBackColor(0,"#CCFFFD");
                    }
                    comboObj.InsertItem( 0 , "All|" , "A" );
                    comboObj.InsertItem( 1 , "No|"  , "N" );
                    comboObj.InsertItem( 2 , "Yes|" , "Y" );
                    comboObj.SetSelectCode("N",false);
//                }
            break;
            case 4: // CUSTOMER TYPE
                with (comboObj) { 
                    SetMultiSelect(1);
                	SetMultiSeparator(",");
                    //UseAutoComplete = true; 
                    SetColAlign(0, "left");
                    SetColAlign(1, "left");
                    SetColWidth(0, "60");
                    SetColWidth(1, "300");
                    SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
                }
                comboObj.InsertItem( 0 , "All"  , "A" );
                comboObj.InsertItem( 1 , "SHPR" , "S" );
                comboObj.InsertItem( 2 , "CNEE" , "C" );
                comboObj.InsertItem( 3 , "NTFY" , "N" );
                comboObj.SetSelectCode("A,S,C,N",false);
                comboObj.SetItemCheck(0,1); //add
				comboObj.SetItemCheck(1,1); //add
				comboObj.SetItemCheck(2,1); //add
				comboObj.SetItemCheck(3,1); //add
            break;
         } 
    }
    function doActionIBCombo(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
                case SEARCHLIST:  
                    var comboObj=comboObjects[1];
                    formObj.f_cmd.value=SEARCHLIST;                     
                    var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    // Tariff type comboList
                    var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
                    if (data != undefined && data != '') {
                        var comboItems=data.split(ROWMARK);
                        addComboItem(comboObj,comboItems);
                        comboItem=comboItems[0].split(FIELDMARK);
                    }
                    var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
                    if(data2 == ''){
                    	data2='CTIC,DMIF';
                    	comboObj.SetItemCheck(1,1); //add
    					comboObj.SetItemCheck(5,1); //add
                    }
                    comboObj.SetSelectCode(data2, false);
                    USR_TRF_TP=data2;
                    formObj.usr_trf_tp.value=data2;
                    USER_TARIFF_TYPE_CD=data2;
                    with (comboObj) {	                
                    	SetMultiSeparator(",");	                 
                    }
                break;
                
                case IBSEARCH_ASYNC02:
                    //2. Office comboList
                    formObj.f_cmd.value=SEARCHLIST02;                     
                    var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
                    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
                    if (ofc_cds != undefined && ofc_cds != '') {
                    	var comboObj=comboObjects[0];
                    	var usrOfcCd=ComGetObjValue(formObj.h_user_office);
     					var idx=0;
     					if(ofc_cds.indexOf(usrOfcCd) == -1) {
     						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
     						idx=1;
     					}
     					var comboCodeArr=ofc_cds.split("|");
                        var comboTextArr=ofc_nms.split("|");
                        for (var i=0 ; i < comboTextArr.length ; i++) {
                            comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);                        	
                        }                        
                        comboObj.SetSelectCode(usrOfcCd);
                    }
                    with (comboObj) {	                
                    	SetMultiSeparator(",");	                 
                    }
                break;
                
                case IBSEARCH_ASYNC03:
                    //3. Sub Office comboList                	
                    formObj.f_cmd.value=COMMAND01;                     
                    var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
        	 		if (subOfcCds != undefined && subOfcCds != '') {
        	 			var comboObj=comboObjects[0];
        	 			var usrOfcCd=ComGetObjValue(formObj.h_user_office);        	 			
    					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1){
    						subOfcCds=usrOfcCd + ',' + subOfcCds;
    					}
    					comboObj.SetSelectCode(subOfcCds, false);
    		 		}
        	 		/*with (comboObj) {	                
        	 			SetMultiSeparator(",");	                 
        	 		}*/
        	 		break;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    function addComboItem(comboObj,comboItems) {
        comboObj.InsertItem(0, "All|All", "All");
        for (var i=0 ; i < comboItems.length ; i++) {        	
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);            
        }
        /*with (comboObj) {	                
 			SetMultiSeparator(",");	                 
 		}*/
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
            case "sheet1":      // sheet1 init
                with(sheetObj){		                
		              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle="|Seq.|Payer CD|Payer Name|Count|Cur.|Billing AMT|TAX AMT|Payable AMT|usrflg|dmifyn|dticyn|dmofyn|dtocyn|cticyn|ctocyn";
		              var headCount=ComCountHeadTitle(HeadTitle);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"CheckBox",  KeyField:0 },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payerc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:1,   SaveName:"payern",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"invocn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"invocr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"bllamt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"taxamt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:140,  Align:"Right",   ColMerge:1,   SaveName:"totamt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"useflg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmifyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dticyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmofyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dtocyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cticyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctocyn",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 } ];
		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetCountPosition(0);
		              //no support[check again]CLT ToolTipOption="balloon:true;width:50;";
		              SetToolTipText(0,"invocn","Count of Invoices");
		              SetSheetHeight(DEF_SHEET_HEIGHT);
              	}
                break;
        }
    }
  // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      
                if ( validateForm(sheetObj,formObj,sAction) ) {               	
                    formObj.f_cmd.value=SEARCH;
                    //sheetObj.Reset();
                    //initSheet(sheetObj, 0); //offsetHeight 속성을 못 가지고 온다는 메시지 뜸                    
                    ComSetObjValue( formObj.isof , comboObjects[0].GetSelectCode());
                    ComSetObjValue( formObj.tftp , comboObjects[1].GetSelectCode());
                    var logInOff=document.form.h_rhq_off.value;                    
                    /*if ( logInOff == "NYCNA" || logInOff == "SELHO" ) {
                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
                    } else {*/                    
	                    if ( comboObjects[2].GetSelectCode()== "A" ) {
	                        ComSetObjValue( formObj.arif , "Y,N" );                            
	                    } else {
	                        ComSetObjValue( formObj.arif , comboObjects[2].GetSelectCode());
	                    }	                   
                    /*}*/                   
                    ComSetObjValue( formObj.cutp , comboObjects[3].GetSelectCode());
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);                   
//                    sheetObj.DoSearch("EES_DMT_4009GS.do", FormQueryString(formObj)  );
                    var sXml=sheetObj.GetSearchData("EES_DMT_4009GS.do", FormQueryString(formObj) );
                    sheetObj.LoadSearchData(sXml,{Sync:1} );
                    
                    sheetObj.SetHeaderCheck(0, "CheckBox", false);
                    ComOpenWait(false);
                }
            break;
            case IBSEARCH_ASYNC04: // SEND2EAMIL ALL OF THEM
	            if(sheetObj.CheckedRows("CheckBox") == 0) {
	     			ComShowCodeMessage('COM12114', 'payer code');
	     			return;
	     		}            
            	if(!ComShowCodeConfirm('DMT01139')){
            		return false;
            	}
            	var today=new Date();
            	var year=today.getYear();
            	var month=today.getMonth() + 1;
            	var day=today.getDate();
            	if (month < 10) {
            		month="0" + month;
            	}
            	if (day < 10) {
            		day="0" + day;
            	}
            	var currDate=year + "-" + month + "-" + day;
            	ComSetObjValue( formObj.rd_fxeml_eml_atch_file , currDate );
                    ComSetObjValue( formObj.isof , comboObjects[0].GetSelectCode());
                    ComSetObjValue( formObj.tftp , comboObjects[1].GetSelectCode());
                    var logInOff=document.form.h_rhq_off.value;
//                    if ( logInOff == "NYCNA" || logInOff == "SELHO" ) {
//                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
//                    } else {
                        if ( comboObjects[2].GetSelectCode()== "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].GetSelectCode());
                        }
//                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].GetSelectCode());
//                var comboTariff = (formObj.tftp.value).split(",");
//                for (var i = 0 ; i < comboTariff.length ; i++) {
//                    if ( comboTariff[i] != "All" ){
//                        document.form.trftpp.value = comboTariff[i];
//                        formObj.f_cmd.value = SEARCH;
//                        var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
//                        var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
//                        if ( rtnRemark == undefined || rtnRemark == '' ) {
//                            ComShowCodeMessage("DMT01120","["+comboTariff[i]+"]");
//                            return false;
//                        }
//                        
//                    }
//                }
//////////////// Sheet Set Check!!
                    var dmif_cnt=0;
                    var dtic_cnt=0;
                    var dmof_cnt=0;
                    var dtoc_cnt=0;
                    var ctic_cnt=0;
                    var ctoc_cnt=0;
                    for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                    	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                    		dmif_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dmifyn"));
                    		dtic_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dticyn"));
                    		dmof_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dmofyn"));
                    		dtoc_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dtocyn"));
                    		ctic_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"cticyn"));
                    		ctoc_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"ctocyn"));
                        }
                    }
                    if(dmif_cnt > 0) {
                    	document.form.trftpp.value="DMIF";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMIF]");
                    		return false;
                    	}
                    }
                    if(dtic_cnt > 0) {
                    	document.form.trftpp.value="DTIC";
                    	formObj.f_cmd.value=SEARCH;
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTIC]");
                    		return false;
                    	}
                    }
                    if(dmof_cnt > 0) {
                    	document.form.trftpp.value="DMOF";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMOF]");
                    		return false;
                    	}
                    }
                    if(dtoc_cnt > 0) {
                    	document.form.trftpp.value="DTOC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTOC]");
                    		return false;
                    	}
                    }
                    if(ctic_cnt > 0) {
                    	document.form.trftpp.value="CTIC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTIC]");
                    		return false;
                    	}
                    }
                    if(ctoc_cnt > 0) {
                    	document.form.trftpp.value="CTOC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTOC]");
                    		return false;
                    	}
                    }
 ////////////////// Sheet Set Check!! END............
                var tPayerCd="";
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                		tPayerCd=sheetObjects[0].GetCellValue(z01,2) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value=tPayerCd;
                var tPayerNm="";
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                		tPayerNm=ComReplaceStr( sheetObjects[0].GetCellValue(z01,3) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value=tPayerNm;
                var tTariff="";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
//                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
//                        tTariff = sheetObjects[0].CellValue(z01,10) + "," + tTariff;
//                    }
//                }
                if(dmif_cnt > 0) {
                	tTariff="DMIF" + "," + tTariff;
                }
                if(dtic_cnt > 0) {
                	tTariff="DTIC" + "," + tTariff;
                }
                if(dmof_cnt > 0) {
                	tTariff="DMOF" + "," + tTariff;
                }
                if(dtoc_cnt > 0) {
                	tTariff="DTOC" + "," + tTariff;
                }
                if(ctic_cnt > 0) {
                	tTariff="CTIC" + "," + tTariff;
                }
                if(ctoc_cnt > 0) {
                	tTariff="CTOC" + "," + tTariff;
                }
                document.form.tarfMail.value=tTariff;
                formObj.f_cmd.value=SEARCH08;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);                 
                var sXml08=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                ComOpenWait(false);
                alert(dmtGetMsgText(sXml08));
            break;
            case IBSEARCH_ASYNC05: // SEND2FAX ALL OF THEM
	            if(sheetObj.CheckedRows("CheckBox") == 0) {
	     			ComShowCodeMessage('COM12114', 'payer code');
	     			return;
	     		} 
	            if(!ComShowCodeConfirm('DMT01140')) return false;
                    ComSetObjValue( formObj.isof , comboObjects[0].GetSelectCode());
                    ComSetObjValue( formObj.tftp , comboObjects[1].GetSelectCode());
                    var logInOff=document.form.h_rhq_off.value;
//                    if ( logInOff == "NYCNA" || logInOff == "SELHO" ) {
//                        ComSetObjValue( formObj.arif , comboObjects[2].Code );
//                    } else {
                        if ( comboObjects[2].GetSelectCode()== "A" ) {
                            ComSetObjValue( formObj.arif , "Y,N" );                            
                        } else {
                            ComSetObjValue( formObj.arif , comboObjects[2].GetSelectCode());
                        }
//                    }
                    ComSetObjValue( formObj.cutp , comboObjects[3].GetSelectCode());
//                var comboTariff = (formObj.tftp.value).split(",");
//                for (var i = 0 ; i < comboTariff.length ; i++) {
//                    if ( comboTariff[i] != "All" ){
//                        document.form.trftpp.value = comboTariff[i];
//                        formObj.f_cmd.value = SEARCH;
//                        var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
//                        var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
//                        if ( rtnRemark == undefined || rtnRemark == '' ) {
//                            ComShowCodeMessage("DMT01120","["+comboTariff[i]+"]");
//                            return false;
//                        }
//                    }
//                }
   //////////////// Sheet Set Check!!
                    var dmif_cnt=0;
                    var dtic_cnt=0;
                    var dmof_cnt=0;
                    var dtoc_cnt=0;
                    var ctic_cnt=0;
                    var ctoc_cnt=0;
                    for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                    	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                    		dmif_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dmifyn"));
                    		dtic_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dticyn"));
                    		dmof_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dmofyn"));
                    		dtoc_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"dtocyn"));
                    		ctic_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"cticyn"));
                    		ctoc_cnt+= parseInt(sheetObjects[0].GetCellValue(z01,"ctocyn"));
                        }
                    }
                    if(dmif_cnt > 0) {
                    	document.form.trftpp.value="DMIF";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMIF]");
                    		return false;
                    	}
                    }
                    if(dtic_cnt > 0) {
                    	document.form.trftpp.value="DTIC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTIC]");
                    		return false;
                    	}
                    }
                    if(dmof_cnt > 0) {
                    	document.form.trftpp.value="DMOF";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DMOF]");
                    		return false;
                    	}
                    }
                    if(dtoc_cnt > 0) {
                    	document.form.trftpp.value="DTOC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[DTOC]");
                    		return false;
                    	}
                    }
                    if(ctic_cnt > 0) {
                    	document.form.trftpp.value="CTIC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTIC]");
                    		return false;
                    	}
                    }
                    if(ctoc_cnt > 0) {
                    	document.form.trftpp.value="CTOC";
                    	formObj.f_cmd.value=SEARCH;                     	
                    	var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                    	var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    	if ( rtnRemark == undefined || rtnRemark == '' ) {
                    		ComShowCodeMessage("DMT01120","[CTOC]");
                    		return false;
                    	}
                    }
 ////////////////// Sheet Set Check!! END............
                var tPayerCd="";
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                		tPayerCd=sheetObjects[0].GetCellValue(z01,2) + "," + tPayerCd;
                    }
                }
                document.form.paycMail.value=tPayerCd;
                var tPayerNm="";
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,0) == 1 ) {
                		tPayerNm=ComReplaceStr( sheetObjects[0].GetCellValue(z01,3) , "'" , " " ) + "|" + tPayerNm;
                    }
                }
                document.form.paynMail.value=tPayerNm;
                var tTariff="";
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
//                    if ( sheetObjects[0].CellValue(z01,0) == 1 ) {
//                        tTariff = sheetObjects[0].CellValue(z01,10) + "," + tTariff;
//                    }
//                }
                if(dmif_cnt > 0) {
                	tTariff="DMIF" + "," + tTariff;
                }
                if(dtic_cnt > 0) {
                	tTariff="DTIC" + "," + tTariff;
                }
                if(dmof_cnt > 0) {
                	tTariff="DMOF" + "," + tTariff;
                }
                if(dtoc_cnt > 0) {
                	tTariff="DTOC" + "," + tTariff;
                }
                if(ctic_cnt > 0) {
                	tTariff="CTIC" + "," + tTariff;
                }
                if(ctoc_cnt > 0) {
                	tTariff="CTOC" + "," + tTariff;
                }                
                document.form.tarfMail.value=tTariff;
                formObj.f_cmd.value=SEARCH09;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);                 
                var sXml09=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                ComOpenWait(false);
                alert(dmtGetMsgText(sXml09));
            break;
        }
    }
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(ComTrim(ComGetObjValue(combo2)) == "") {
                ComAlertFocus(combo2, ComGetMsg('DMT02002', "Issue Office"));
                return false;
            }
            if(ComTrim(ComGetObjValue(combo1)) == "") {
                ComAlertFocus(combo1, ComGetMsg('DMT02002', "Tariff Type"));
                return false;
            }
            if(ComTrim(ComGetObjValue(combo3)) == "") {
                ComAlertFocus(combo3, ComGetMsg('DMT02002', "A/R I/F"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.frdt)) == "") {
                ComAlertFocus(formObj.frdt, ComGetMsg('DMT02002', "Issued Date"));
                return false;
            }
            if(ComTrim(ComGetObjValue(formObj.todt)) == "") {
                ComAlertFocus(formObj.todt, ComGetMsg('DMT02002', "Issued Date"));
                return false;
            }
        }
        return true;
    }
    function doInclSubOfc() {
        var formObj=document.form;
        if (formObj.chk_sub_ofc.checked) { // Sub Office included
            if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
                ComShowCodeMessage('COM12113', "DEM/DET Office");
                formObj.chk_sub_ofc.checked=false;
                return;
            }
            formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
            formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);
            doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
        } 
        else {
            comboObjects[0].SetSelectIndex(-1);
            comboObjects[0].SetSelectCode(formObj.tmp_ofc_cd.value);
        }
    }
    function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
        if ( KeyCode == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }    
    //Multi Combo click event
//    function combo1_OnCheckClick(comboObj, index, code) {
//        if(index==0) {
//            //checked
//            var bChk=comboObj.GetItemCheck(index);
//            for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//                comboObj.SetItemCheck(i,bChk);
//            }
//        } else {
//            comboObj.SetItemCheck(0,0);
//        }
//    }   
    //Multi Combo click event
    function combo3_OnCheckClick(comboObj, index, code) {
        if(index==0) {
            //checked
            var bChk=comboObj.GetItemCheck(index);
            for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
                comboObj.SetItemCheck(i,bChk);
            }
        } else {
            comboObj.SetItemCheck(0,0);
        }
    }  
    //Multi Combo click event
//    function combo4_OnCheckClick(comboObj, index, code) {
//        if(index==0) {
//            //checked
//            var bChk=comboObj.GetItemCheck(index);
//            for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//                comboObj.SetItemCheck(i,bChk);
//            }
//        } else {
//            comboObj.SetItemCheck(0,0);
//        }        
//    }      
    function combo2_OnCheckClick(comboObj, index, code) {
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
	// Multi Combo KeyDown Event Catch 
 	function combo2_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if (formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
    function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
        with (sheetObj) {
            if ( RowCount()<= 0 ) {
                ComBtnDisable("btn1_detail");
                ComBtnDisable("btn1_fax_send");
                ComBtnDisable("btn1_email_send");
                ComBtnDisable("btn1_excel");                
                return; 
            }
            for ( var x=1 ; x < LastRow(); x++ ) {
            	if ( GetCellValue( x , 9 ) == "Y" ) {
                    SetToolTipText( x , 2 ,"Payer Code not available any more");                     
                    SetCellFontColor( x , 2 ,"#DC0000");
                }
            }            
            ComBtnEnable("btn1_detail");
            ComBtnEnable("btn1_fax_send");
            ComBtnEnable("btn1_email_send");
            ComBtnEnable("btn1_excel");             
            SetSumText( 0 , "SEQ"      ,"Total");
            SetCellAlign( 0 , "SEQ"      ,"Center");
        }
    }    
    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
    	document.form.chk_payer.value=sheetObjects[0].GetCellValue(sheetObjects[0].MouseRow(), 2);
    	document.form.chk_payer2.value=sheetObjects[0].GetCellValue(sheetObjects[0].MouseRow(), 3);
    }
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        var formObject=document.form;
        document.form.chk_payer.value=sheetObjects[0].GetCellValue(sheetObjects[0].MouseRow(), 2);
        document.form.chk_payer2.value=sheetObjects[0].GetCellValue(sheetObjects[0].MouseRow(), 3);
//            document.form.tftp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow , 10);
        document.form.tftp.value=comboObjects[1].GetSelectCode();
        ComSetObjValue( formObject.isof , comboObjects[0].GetSelectCode());
        ComSetObjValue( formObject.arif , comboObjects[2].GetSelectCode());
        ComSetObjValue( formObject.cutp , comboObjects[3].GetSelectCode());
        var tArif=formObject.arif.value;
        var logInOff=document.form.h_rhq_off.value;
//                    if ( logInOff != "NYCNA" && logInOff != "SELHO" ) {
//                        if ( tArif == "A" ) {
//                            tArif = "Y,N";
//                        }
//                    }   
        if ( tArif == "A" ) {
        	tArif="Y,N";
        }
        var param="?isof=" + formObject.isof.value +
                    "&tftp=" + formObject.tftp.value +
                    "&frdt=" + formObject.frdt.value +
                    "&todt=" + formObject.todt.value +
                    "&arif=" + tArif +
                    "&payc=" + formObject.chk_payer.value +
                    "&cutp=" + formObject.cutp.value +
                    "&cuno=" + formObject.cuno.value +
                    "&cude=" + formObject.cude.value +
                    "&scno=" + formObject.scno.value +
                    "&rfan=" + formObject.rfan.value +
                    "&payn=" + formObject.chk_payer2.value ;
        ComOpenPopup( "EES_DMT_4011.do"+param , 1030, 720 , "" , "0,1" , true );
    }
    //Payer check
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.payc)));
        if(cust_len == 0) {
            ComSetObjValue(formObj.payn, "");
            return;
        }
        if(cust_len == 6) {
            ComSetObjValue(formObj.s_cust_gubun, "1");
            ComSetObjValue(formObj.s_cust_cd, formObj.payc.value);
        }else if(cust_len > 6) {
            ComSetObjValue(formObj.s_cust_gubun, "2");
            ComSetObjValue(formObj.s_cust_cd, formObj.payc.value);
        }else {
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.payc, "");
            ComSetObjValue(formObj.payn, "");
            ComSetFocus(formObj.payc);
            ComShowCodeMessage("COM12143", "Payer", "6");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);         
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if(cust_nm == null || cust_nm == "") {
            ComShowCodeMessage("COM132201", "Payer", "8");
            ComSetFocus(formObj.payc);
                document.form.s_cust_gubun.value="";
                document.form.payc.value="";
                document.form.payn.value="";                
        }else{
            ComSetObjValue(formObj.payn, cust_nm);
            document.form.payc.value=cust_cd;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    //Customer check
    function doActionText2(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.cuno)));
        var tCuno=ComGetObjValue(formObj.cuno);
        if(cust_len == 0) {
            ComSetObjValue(formObj.cude, "");
            return;
        }
        if(cust_len == 2) {
            ComSetObjValue(formObj.cust_cnt_cd, tCuno);
            ComSetObjValue(formObj.cust_seq   , "0000");
        }else if(cust_len > 2) {
            ComSetObjValue(formObj.cust_cnt_cd, tCuno.substring(0,2));
            ComSetObjValue(formObj.cust_seq   , tCuno.substring(2,cust_len));
        }else {
            ComSetObjValue(formObj.cust_cnt_cd, "");
            ComSetObjValue(formObj.cust_seq   , "");
            ComSetFocus(formObj.cuno);
            ComShowCodeMessage("COM12143", "Customer Code ", "8");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);         
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_nm=ComGetEtcData(sXml, "CUST_NM");
        if(cust_nm == null || cust_nm == "") {
            ComShowCodeMessage("COM132201", "Customer Code", "8");
            document.form.cuno.value="";
            document.form.cude.value="";
            document.form.cust_cnt_cd.value="";
            document.form.cust_seq.value="";
            ComSetFocus(formObj.cuno);
        }else{
            ComSetObjValue(formObj.cude, cust_nm);
            //document.form.payc.value = cust_cd;
        }
        sheetObj.SetWaitImageVisible(1);
    }    
    function keyPress() {
        var obj=event.srcElement;
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            if ( obj.name == "payc" || obj.name == "cuno" ) {
                if(obj.name == 'payc') {
                    doActionText(sheetObjects[0], document.form, obj, SEARCH20);
                }else if(obj.name == 'cuno') {
                    doActionText2(sheetObjects[0], document.form, obj, SEARCH19);
                }                
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    document.onkeypress=keyPress ;
    function open5101(){ // HOLD REASON ENTRY
        ComOpenPopupWithTarget('EES_DMT_5101.do?invoiceNo=LGT025949', 540, 380, "", "0,1,1,1,1,1,1", true);
    }
	function dmtGetMsgText(xmlStr){
	    try {
	    	return ComGetSelectSingleNode(xmlStr, "MESSAGE");
	    	/*
	        var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
	        var xmlDoc = ComGetXmlDoc(xmlStr);
		    xmlDoc.loadXML(xmlStr);
		    var xmlRoot=xmlDoc.documentElement;
		    if(xmlRoot == null) return;
		    var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
	        if(msgNode == null){ 
	        	return;
	        }else{
	        	return msgNode.firstChild.nodeValue;
	        }*/
	   } catch(err) { ComFuncErrMsg(err.message); }
	}
	

	 var selComboIndex, selComboCode;
	 function combo1_OnSelect(comboObj ,index, code) {
	  selComboIndex = index;
	  selComboCode = code;
	 }
	 function combo1_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }
	 function combo4_OnSelect(comboObj ,index, code) {
		  selComboIndex = index;
		  selComboCode = code;
	 }
	 function combo4_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }
	 
