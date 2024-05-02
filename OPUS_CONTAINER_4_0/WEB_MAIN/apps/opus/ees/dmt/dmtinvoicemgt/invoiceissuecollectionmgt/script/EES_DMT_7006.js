/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7006.js
*@FileTitle  : Fax/E-mail Sending History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    
    var DEF_SHEET_HEIGHT = 445;
    var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 107;
    
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
    // Event handler processing by button name
    function processButtonClick(){
        /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btns_calendar":
                    if ( document.form.selectOpt[0].checked ) {
                        var cal=new ComCalendarFromTo();
                        cal.select(formObject.sndfrdt, formObject.sndtodt, 'yyyy-MM-dd');
                    }
                    break;
                case "btn_downexcel":
                	if(sheetObjects[0].RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
                	}
                	
                	break;
                case "btn_retrieve":
                    doActionIBSheet ( sheetObjects[0] , formObject , IBSEARCH );
                    break;
                case "btn_new":
                    var formObj=document.form;
                    ComResetAll();
                    DmtComSetClassManyObjects('input1', formObj.sndfrdt, formObj.sndtodt);
                    //var CURR_DATE = ComGetNowInfo();
                    var CURR_DATE=DmtComOfficeCurrDate(sheetObjects[0], formObj);
                    var fmDt=ComGetDateAdd(CURR_DATE, "M", -1);
                    var toDt=CURR_DATE;
                    ComSetObjValue(formObj.sndfrdt, fmDt);
                    ComSetObjValue(formObj.sndtodt, toDt);
                    doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
                    document.form.sndrnmm.value="";
                    document.form.sndrcdd.value="";
                    document.form.invoice.value="";
                    document.form.payercd.value="";
                    document.form.payernm.value="";                    
                    document.form.sndfrdt.readOnly=false;
                    document.form.sndtodt.readOnly=false;
                    document.form.sndrcdd.readOnly=false;
                    comboObjects[0].SetEnable(1);
                    document.form.sndfrdt.className='input1';
                    document.form.sndtodt.className='input1';
                    document.form.sndrcdd.className='input';
                    document.form.invoice.readOnly=true;
                    document.form.invoice.className='input2';
                    document.form.payercd.readOnly=true;
                    document.form.payernm.readOnly=true;
                    document.form.payercd.className='input2';
                    document.form.payernm.className='input2';
                    document.form.sndrcdd.value="";
                    document.form.invoice.value="";
                    document.form.payercd.value="";
                    document.form.payernm.value="";
                    break;
                case "btn_minimize":
                    var schCondDiv=document.getElementById("sch_cond_div");
                    if(schCondDiv.style.display == 'block') {   
                        schCondDiv.style.display='none';
                        sheetObjects[0].SetSheetHeight(MAX_SHEET_HEIGHT);
                    } else {
                        schCondDiv.style.display='block';
                        sheetObjects[0].SetSheetHeight(DEF_SHEET_HEIGHT);
                    }
                    break;
                case "btns_payer_cd":
                    if ( document.form.selectOpt[2].checked ) {
                        openPopup("payercd","");
                    }
                    break; 
                case "btns_inv_no":
                    if ( document.form.selectOpt[1].checked ) {
                        openPopup('invoice');
                    }
                    break; 
                case "btns_sender_cd":
                    if ( document.form.selectOpt[0].checked ) {
                        openPopup("sndrnmm","");
                    }
                    break; 
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
    }
    
    /**
    * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
    */
    function loadPage() {
        var formObj=document.form;
        if( formObj.h_jspno.value != "" && formObj.h_jspno.value != "EES_DMT_7006" ) {
            //btnCloseLayer.style.display  = "inline";
        }        
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initCombo(comboObjects[0],1);
        initControl();
        var formObj=document.form;
        DmtComSetClassManyObjects('input1', formObj.sndfrdt, formObj.sndtodt);
        //var CURR_DATE = ComGetNowInfo();
        var CURR_DATE=DmtComOfficeCurrDate(sheetObjects[0], formObj);
        var fmDt=ComGetDateAdd(CURR_DATE, "M", -1);
        var toDt=CURR_DATE;
        ComSetObjValue(formObj.sndfrdt, fmDt);
        ComSetObjValue(formObj.sndtodt, toDt);
        doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
        comboObjects[0].SetSelectCode("All");
        document.form.sndfrdt.readOnly=false;
        document.form.sndtodt.readOnly=false;
        document.form.sndrcdd.readOnly=false;
        comboObjects[0].SetEnable(1);
        document.form.sndfrdt.className='input1';
        document.form.sndtodt.className='input1';
        document.form.sndrcdd.className='input';
        document.form.invoice.readOnly=true;
        document.form.invoice.className='input2';
        document.form.payercd.readOnly=true;
        document.form.payernm.readOnly=true;
        document.form.shttppp.disabled=true;
        document.form.payercd.className='input2';
        document.form.payernm.className='input2';
        document.form.shttppp.className='input2';
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_calendar);
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sntoff);
        ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sender_cd);
        ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
        ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
        if ( document.form.h_jspno.value != "EES_DMT_7006" ) {
            if ( document.form.h_jspno.value == "EES_DMT_4011" ) {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=true;
                document.form.invoice.className='input2';
                document.form.payercd.readOnly=false;
                document.form.payernm.readOnly=true;
                document.form.payercd.className='input1';
                document.form.payernm.className='input2';
                document.form.selectOpt[2].checked=true;
                document.form.shttppp.value="O";
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                var opener_obj=window.dialogArguments;
                if(!opener_obj) opener_obj = parent;
                document.form.payercd.value=opener_obj.document.form.payc.value;
                document.form.payernm.value=opener_obj.document.form.payn.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else if ( document.form.h_jspno.value == "EES_DMT_3109" ) {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=true;
                document.form.invoice.className='input2';
                document.form.payercd.readOnly=false;
                document.form.payernm.readOnly=true;
                document.form.payercd.className='input1';
                document.form.payernm.className='input2';
                document.form.selectOpt[2].checked=true;
                document.form.shttppp.value="D";
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                var opener_obj=window.dialogArguments;
                if (!opener_obj) opener_obj = parent;
                document.form.payercd.value=opener_obj.document.form.payer_cd.value;
                document.form.payernm.value=opener_obj.document.form.payer_nm.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else if ( document.form.h_jspno.value == "EES_DMT_3108" ) {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=true;
                document.form.invoice.className='input2';
                document.form.payercd.readOnly=false;
                document.form.payernm.readOnly=true;
                document.form.payercd.className='input1';
                document.form.payernm.className='input2';
                document.form.selectOpt[2].checked=true;
                document.form.shttppp.value="G";
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);
                var opener_obj=window.dialogArguments;
                if (!opener_obj) opener_obj = parent;
                document.form.payercd.value=opener_obj.document.form.payer_cd.value;
                document.form.payernm.value=opener_obj.document.form.payer_nm.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            } else {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=false;
                document.form.invoice.className='input1';
                document.form.payercd.readOnly=true;
                document.form.payernm.readOnly=true;
                document.form.payercd.className='input2';
                document.form.payernm.className='input2';
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
                document.form.selectOpt[1].checked=true;
                document.form.invoice.value=document.form.h_invoice.value;
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    
    function initControl() {
        //axon_event.addListener('blur',  'obj_blur', 'sndfrdt', 'sndtodt' );   
        //axon_event.addListener('blur',  'obj_blur2', 'payercd');   
        //axon_event.addListener('focus', 'obj_focus', 'sndfrdt', 'sndtodt');
        //axon_event.addListenerFormat('keypress','obj_keypress', document.form);
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListener('click', 'obj_click', 'form');
    }
    
    function obj_click(){
        var obj=event.srcElement;
        if(obj.name == 'selectOpt') {
            if ( ComGetObjValue( obj ) == "0" ) {
                //var CURR_DATE = ComGetNowInfo();
                var CURR_DATE=DmtComOfficeCurrDate(sheetObjects[0], document.form);
                var fmDt=ComGetDateAdd(CURR_DATE, "M", -1);
                var toDt=CURR_DATE;
                ComSetObjValue(document.form.sndfrdt, fmDt);
                ComSetObjValue(document.form.sndtodt, toDt);
                doActionIBCombo(sheetObjects[0], document.form, comboObjects[0], SEARCHLIST02);
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                document.form.invoice.value="";
                document.form.payercd.value="";
                document.form.payernm.value=""; 
                document.form.shttppp.value="";
                document.form.sndfrdt.readOnly=false;
                document.form.sndtodt.readOnly=false;
                document.form.sndrcdd.readOnly=false;
                comboObjects[0].SetEnable(1);
                document.form.sndfrdt.className='input1';
                document.form.sndtodt.className='input1';
                document.form.sndrcdd.className='input';
                document.form.invoice.readOnly=true;
                document.form.invoice.className='input2';
                document.form.payercd.readOnly=true;
                document.form.shttppp.readOnly=true;
                document.form.payernm.disabled=true;
                document.form.payercd.className='input2';
                document.form.payernm.className='input2';
                document.form.shttppp.className='input2';
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);                
            } else if ( ComGetObjValue( obj ) == "1" ) {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=false;
                document.form.invoice.className='input1';
                document.form.payercd.readOnly=true;
                document.form.payernm.readOnly=true;
                document.form.shttppp.disabled=true;
                
                document.form.payercd.className='input2';
                document.form.payernm.className='input2';
                document.form.shttppp.className='input2';
                
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                document.form.payercd.value="";
                document.form.payernm.value="";
                document.form.shttppp.value="";
                
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_payer_cd);
            } else if ( ComGetObjValue( obj ) == "2" ) {
                document.form.sndfrdt.readOnly=true;
                document.form.sndtodt.readOnly=true;
                document.form.sndrcdd.readOnly=true;
                comboObjects[0].SetEnable(0);
                document.form.sndfrdt.className='input2';
                document.form.sndtodt.className='input2';
                document.form.sndrcdd.className='input2';
                document.form.invoice.readOnly=true;
                document.form.invoice.className='input2';
                document.form.payercd.readOnly=false;
                document.form.payernm.readOnly=true;
                document.form.shttppp.disabled=false;
                document.form.payercd.className='input1';
                document.form.payernm.className='input2';
                document.form.shttppp.className='input';
                document.form.sndfrdt.value="";
                document.form.sndtodt.value="";
                document.form.sndrcdd.value="";
                document.form.sndrnmm.value="";
                document.form.invoice.value="";
                comboObjects[0].SetSelectCode(-1);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_calendar);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sntoff);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_sender_cd);
                ComEnableManyObjects(false, document.form.tempuser, document.form.btns_inv_no);
                ComEnableManyObjects(true, document.form.tempuser, document.form.btns_payer_cd);  
            }
        }
    }
    
    function obj_blur(){
        var obj=event.srcElement;
        ComChkObjValid(obj);
    }
    
    function obj_blur2(){
        var obj=event.srcElement;
        if(obj.name == 'payercd') {
            doActionText(sheetObjects[0], document.form, obj, SEARCH20);
        }
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
        var obj=event.srcElement;
        ComClearSeparator(obj);
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
    
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
        	case "engup":
                ComKeyOnlyAlphabet('uppernum', ',');
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                ComKeyOnlyNumber(event.srcElement);
        }
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
            case "sheet1":
            	with(sheetObj){
            		var HeadTitle1="Seq.|INV No./Payer|Type|Fax/E-mail|Result|Sent Date|Sent Office|Sender ID|Sender Name|";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"invnoo",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"shtype",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"faxeml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
            		             {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"rstmsg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
            		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"snddat",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sndoff",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sndrid",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"sndrnm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"payerr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetEllipsis(1);
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
                if(!validateForm(sheetObj,formObj,sAction)) return;
                formObj.f_cmd.value=SEARCH;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
//parameter changed[check again]CLT
                sheetObj.DoSearch("EES_DMT_7006GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
        }
    }
    
    /**
     * Combo basic setting
     * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
     * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form;
        switch(comboObj.id) {  
            case "office": 
                with (comboObj) { 
                    //MultiSelect = false;
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetDropHeight(160);
                    SetColBackColor(0,"#CCFFFD");
                    ValidChar(2); 
                    SetMaxLength(5);
                }
            break;
        }
    }
    
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        formObj.f_cmd.value=formCmd;

        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        switch(formCmd) {
	        case COMMAND06: // RHQ
	        	with (comboObj) { 
	            	RemoveAll();
	                SetMultiSelect(0);
	                SetColWidth(0, "45");
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
                    var comboItems=data.split("|");
                    for (var i=0 ; i < comboItems.length ; i++) {
                        comboObj.InsertItem(i, comboItems[i], comboItems[i]);       
                    }
                    var usr_ofc_cd=document.form.h_user_office.value;
                    comboObjects[0].SetSelectCode(usr_ofc_cd);
                    if(comboObjects[0].GetSelectCode()!= usr_ofc_cd) {
                        comboObjects[0].InsertItem(0, usr_ofc_cd, usr_ofc_cd);
                        comboObjects[0].SetSelectCode(usr_ofc_cd);
                    }
                }
                break;
                
            case COMMAND01: // Incl. Sub Office
            	if (sXml != undefined && sXml != '') {
            		var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
                    var comboObj=comboObjects[0];
                    if(ofc_cds != '') 
                    	comboObj.SetSelectCode(ofc_cds);
                    var usr_ofc_cd=document.form.h_user_office.value;
                        comboObjects[0].SetSelectCode(usr_ofc_cd);
                }else{
                	var usr_ofc_cd=document.form.h_user_office.value;
                    comboObjects[0].SetSelectCode(usr_ofc_cd);
                }                
                break;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
            	case IBSEARCH:
                    if ( document.form.selectOpt[0].checked ) {
                        if(!ComIsDate(sndfrdt)) {
                            ComAlertFocus(sndfrdt, ComGetMsg('COM12134', 'Period From Date'));
                            return false;
                        }
                        if(!ComIsDate(sndtodt)) {
                            ComAlertFocus(sndtodt, ComGetMsg('COM12134', 'Period To Date'));
                            return false;
                        }
                        var startDt=ComGetUnMaskedValue(sndfrdt, 'ymd');
                        var endDt=ComGetUnMaskedValue(sndtodt, 'ymd');
                        if (ComChkPeriod(startDt, endDt) == 0) {
                            ComShowCodeMessage("DMT01020");
                            return false;
                        }
                        // DEM/DET Office
                        var ofcCd=comboObjects[0].GetSelectCode();
                        if(ComIsEmpty(ofcCd)) {
                            ComShowCodeMessage('COM12113', "DEM/DET Office");
                            return false;
                        }
                        ComSetObjValue(sndoffc, ofcCd);
                        document.form.seloptt.value="0";
                    } else if ( document.form.selectOpt[1].checked ) {
                        var invno=document.form.invoice.value;
                        if(ComIsEmpty(invno)) {
                            ComShowCodeMessage('DMT03028', "Invoice No");
                            return false;
                        }
                        ComSetObjValue(sndoffc, "");
                        document.form.seloptt.value="1";
                    } else if ( document.form.selectOpt[2].checked ) {
                        var payer=document.form.payercd.value;
                        if(ComIsEmpty(payer)) {
                            ComShowCodeMessage('DMT03028', "Payer");
                            return false;
                        }
                        ComSetObjValue(sndoffc, "");
                        document.form.seloptt.value="2";
                    }
                    break;
    		} // switch - end
    	} // with - end
        return true;
    }
    
    function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg){
        with(sheetObj){
        }
    }
    
    function keyPress() {
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    document.onkeypress=keyPress ;
    function openPopup(flag, arg) {
    	var sheetObj=sheetObjects[0];
        var formObj=document.form;
        var sUrl='';
        var sWidth='';
        var sHeight='';
        with(sheetObj) {
        	switch(flag) {
            	case 'payercd':       // Customer Inquiry Popup
            		ComOpenPopup('COM_ENS_041.do', 770, 470, "getPayerCd", "1,0,1,1,1,1,1", true);
            		break;
                case 'sndrnmm':        // Issue Name Inquiry Popup
                    ComOpenPopup('COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
                    break;
                case 'invoice':        // CNTR No.
                	var returntitle='Invoice No.';
                	var param="?returnval=" + flag + "&returntitle=" + returntitle;
                    //ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                	ComOpenPopup('EES_DMT_MULTI.do'+param, 460, 400, 'getDmt_Multi', '0,1', true);
                    break;
        	} // switch-end
        } // with-end
        if(sUrl != '') {
            var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
            ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
        }
    }
    
    function getDmt_Multi(rArray, return_val) {
        var targObj=eval("document.form." + return_val);
        var retStr=rArray.toString().toUpperCase();
        ComSetObjValue(targObj, retStr);
    }
    
    function getPayerCd(aryPopupData) {
        document.form.payercd.value=aryPopupData[0][3];
        document.form.payernm.value=aryPopupData[0][4];
    }
    
    function setUsrNm(aryPopupData){
        document.form.sndrnmm.value=aryPopupData[0][5];
        document.form.sndrcdd.value=aryPopupData[0][4];
    }
    
    //Payer check
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.payercd)));
        if(cust_len == 0) {
            ComSetObjValue(formObj.payernm, "");
            return;
        }
        if(cust_len == 6) {
            ComSetObjValue(formObj.s_cust_gubun, "1");
            ComSetObjValue(formObj.s_cust_cd, formObj.payercd.value);
        }else if(cust_len > 6) {
            ComSetObjValue(formObj.s_cust_gubun, "2");
            ComSetObjValue(formObj.s_cust_cd, formObj.payercd.value);
        }else {
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.payercd, "");
            ComSetObjValue(formObj.payernm, "");
            ComSetFocus(formObj.payercd);
            ComShowCodeMessage("COM12143", "Payer", "6");
            return;
        }
        ComSetObjValue(formObj.f_cmd, formCmd);
//parameter changed[check again]CLT
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if( cust_nm == null || cust_nm == "" ) {
            ComShowCodeMessage("COM132201", "Payer", "8");
            ComSetFocus(formObj.payercd);
                document.form.s_cust_gubun.value="";
                document.form.payercd.value="";
                document.form.payernm.value="";                
        }else{
            ComSetObjValue(formObj.payernm, cust_nm);
            document.form.payercd.value=cust_cd;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            var colName = ColSaveName(MouseCol());
            var msg = "";
            switch(colName) {
                case "faxeml":
                	msg = GetCellValue(MouseRow(), MouseCol());
                	break;
                case "rstmsg":
                	msg = GetCellValue(MouseRow(), MouseCol());
                	break;
                default:
                    msg="";
                	break;
            } 
            //ToolTipOption = "balloon:true;width:200";
            SetToolTipText(MouseRow(), MouseCol(), msg);
        }
    }