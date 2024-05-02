/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4010.js
*@FileTitle : E-Service Compensation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends Pri
     * @class ESM_PRI_4010:business script for  ESM_PRI_4010 
     */
    function ESM_PRI_4010() {
        this.setSheetObject 		= setSheetObject;
        this.setComboObject         = setComboObject;
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.initCombo              = initCombo;
        this.initControl            = initControl;
        this.processButtonClick		= processButtonClick;
        this.doActionIBSheet 		= doActionIBSheet;
    }

    //  ===================================================================================
    //  Global Variable
    //  ===================================================================================
    //  Common Global variable
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;

    var comboObjects = new Array();
    var comboCnt = 0;

    //  Global Variable
    var gCurrRow1 = 0;
    var gCurrDate;

    /** 
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : IBSheet Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * registering IBCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items</b> 
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function loadPage() {
        var form = document.form;	

        comboCnt = comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }

        sheet1 = sheetObjects[0];
        sheetCnt = sheetObjects.length;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }    

        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);    
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	    	

        initIBComboItem();

        sheet1.WaitImageVisible = false;

        form.eff_dt.value = ComGetNowInfo('ymd', '-');
        gCurrDate = ComGetNowInfo('ymd', '-');

    }

    /**
     * Setting item to IBMultiCombo. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );    
        ComPriTextCode2ComboItem(chargeComboValue,   chargeComboText,   getComboObject(comboObjects, 'chg_cd'), "|", "\t" );    
        ComPriTextCode2ComboItem(ctrtTypeCode, ctrtTypeText, getComboObject(comboObjects, 'prc_ctrt_tp_cd') ,"|","\t" );

        form.prc_ctrt_tp_cd.Code2 = "R";
        form.prc_ctrt_tp_cd.enable = false;
    }

    /** 
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {sheetObj} sheetObj : Sheet Object
     * @param {int} sheetNo : Sheet Object Tag's ID Serial No  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                    //setting height
                    style.height = 440;
                    //setting width
                    SheetWidth = mainTable.clientWidth;
                    //setting Host information[Mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //Merge Type [Selection, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //Editable [Selection, Default false]
                    //Editable = false;
                    Editable = false;
                    //setting Row information[Mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    var HeadTitle1 = "Scope|Origin|Dest.|RFA No.|E-SVC Type|E-SVC Type|E-SVC Type|Charge|Discount|Discount|Discount|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate|cmpn_rmk_tooltip";
                    var HeadTitle2 = "Scope|Origin|Dest.|RFA No.|Web|EDI|Desk\nTop|Charge|Cur.|Amount|Percentage|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate|cmpn_rmk_tooltip";
                    //setting Column information[Mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //setting function handling header
                    InitHeadMode(true, true, false, true, false, false);
                    //setting header Row information[Mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  Data Property         ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME             ,KEYFIELD,CALCULOGIC  ,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData           ,55     ,daCenter    ,true      ,"svc_scp_cd"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,40     ,daCenter    ,true      ,"org_rgn_cd"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,40     ,daCenter    ,true      ,"dest_rgn_cd"         ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,80     ,daCenter    ,true      ,"sc_no"               ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_w"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_e"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_d"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,60     ,daCenter    ,true      ,"chg_cd"              ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,30     ,daCenter    ,true      ,"curr_cd"             ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,110    ,daCenter    ,true      ,"dc_amt"              ,false  ,""          ,dfNullFloat      ,2         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"dc_per"              ,false  ,""          ,dfNullInteger    ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"eff_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,75     ,daCenter    ,true      ,"exp_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,200    ,daLeft      ,true      ,"cmpn_rmk"            ,false  ,""          ,dfNone           ,0         ,false     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,68     ,daCenter    ,true      ,"upd_usr_id"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,65     ,daCenter    ,true      ,"upd_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtHidden         ,200    ,daLeft      ,true      ,"cmpn_rmk_tooltip"    ,false  ,""          ,dfNone           ,0         ,false     ,false);

                    //WordWrap = true;
                    Ellipsis = true;
                    AutoRowHeight = false;
                    ToolTipOption = "balloon:true;width:600;icon:0";

                }
                break;
        }

    }

    /** 
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : Sheet Object
     * @param {int} comboNo : Combo Object Tag's ID Serial No  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2);    // Only upper case
                    MaxLength = 3;     
                }
                break;

            case "chg_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // Only upper case
                    MaxLength = 3;     
                }
                break;

            case "org_rgn_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 10;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // Only upper case
                    MaxLength = 3;     
                }
                break;

            case "dest_rgn_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 10;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // Only upper case
                    MaxLength = 3;     
                }
                break;
                
            case "prc_ctrt_tp_cd":
                with(comboObj) {
                    Style = 1;
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = false;
                    SetColWidth("18|50");
                }
                break;
        }
    }      

    //  ===================================================================================
    //  Event handler processing by button click event
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function processButtonClick(){
        var form = document.form;
        try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;
			
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    break;
                case "btn_new":
                    form.sc_no.value = "";
                    form.svc_scp_cd.Code = "";
                    form.svc_scp_nm.value = "";
                    form.chg_cd.Code = "";
                    //form.prc_ctrt_tp_cd.Code = "";
                    form.org_rgn_cd.RemoveAll();
                    form.org_rgn_cd.DropHeight = 10;
                    form.org_rgn_cd.InsertItem(0, "", "");
                    form.dest_rgn_cd.RemoveAll();
                    form.dest_rgn_cd.DropHeight = 10;
                    form.dest_rgn_cd.InsertItem(0, "", "");		
                    form.eff_dt.value = gCurrDate;
                    sheet1.RemoveAll();
                    break;
                case "btns_calendar": 
                    var cal = new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;

            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * EventHandler for Object's Keypress<br>
     * Checking a validation about inputed data by object's dataformat<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj = ComGetEvent();
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": 
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "uppernum": //only upper case , numbers
                ComKeyOnlyAlphabet('uppernum'); 
                break;
            default:
                ComKeyOnlyNumber(event.srcElement);
            break;
        }
    }

    /**
     * Handling OnBeforeActivate event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2010.02.26
     */      
    function obj_activate() {
        ComClearSeparator (event.srcElement);
    }

    /** 
     * Handling Onbeforedeactivate event<br>
     *  Checking a validation about inputed data by object's dataformat  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        var objValue;
        switch(srcName) {
            case "sc_no":
                /*
			objValue = formObj.value; 
			if(objValue.length > 0 && objValue.length < 9){
				ComShowCodeMessage("PRI02013");
				ComSetFocus(formObj);
			}
                 */
                break;
                //case "eff_dt":
                //ComChkObjValid(formObj); 
                //break;
            case "svc_scp_cd":
                break;
            default :
                ComChkObjValid(formObj);
        }
    }

    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     * svc_scp_cd_OnChange event handler <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : Combo Object                                               
     * @param  {IBMultiCombo} objCd : Selected code value                                             
     * @param  {IBMultiCombo} objTxt :Selected code text                                    
     * @return N/A                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */  
    function svc_scp_cd_OnChange(comboObj, Code, Text) {
        var form = document.form;
        var cText = comboObj.GetText(Code, 1);
        form.svc_scp_nm.value = cText;
    }

    /**                                                                                            
     * svc_scp_cd_OnBlur  event handler  <br>
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : Combo Object                                               
     * @return N/A                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */                   
    function svc_scp_cd_OnBlur(comboObj) {
        var form = document.form;
        var comboOrgRgnCd = form.org_rgn_cd;
        var comboDestRgnCd = form.dest_rgn_cd;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        var code = comboObj.Code;
        if (code != null && code != "") {
            doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01);
        }else{
            comboOrgRgnCd.RemoveAll();
            comboDestRgnCd.RemoveAll();
        }
    }

    /** 
     * Calling Retrieving and saving function<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} comboObj : Combo Object
     * @param  {form} formObj : HTML Form control
     * @param  {int} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH: 

                ComOpenWait(true);

                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_4009GS.do", FormQueryString(formObj));
                setToolTip(sheetObj, formObj, sAction);

                ComOpenWait(false);

                break;

            case IBSEARCH_ASYNC01: //Retrieving origin, dest Combo

                formObj.f_cmd.value = SEARCH01;
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", FormQueryString(formObj));
                var arrData = ComPriXml2Array(sXml, "rgn_cd|rgn_nm|org_dest_cd"); //"☜☞"
                var arrRow;
                var comboOrgRgnCd = formObj.org_rgn_cd;
                var comboDestRgnCd = formObj.dest_rgn_cd;
                comboOrgRgnCd.RemoveAll();
                comboDestRgnCd.RemoveAll();
                comboOrgRgnCd.InsertItem(0, "", "");
                comboDestRgnCd.InsertItem(0,  "", "");
                for(var i = 0; i < arrData.length; i++) {
                    arrRow = arrData[i];
                    if(arrRow[2] == "O") {
                        comboOrgRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    } else if (arrRow[2] == "D") {
                        comboDestRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    }
                }

                break;

        }
    }
    //  ===================================================================================
    //  User Function
    //  ===================================================================================
    /**
     * Setting tool-tip for sheet1 Remark(s)<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.14
     */
    function setToolTip (sheetObj) {
        var startRow = sheet1.HeaderRows;
        var endRow = sheet1.HeaderRows() + sheet1.RowCount();
        for (var i = startRow; i < endRow; i++) {
            sheet1.SetToolTipText(i, "cmpn_rmk", sheet1.GetCellValue(i, "cmpn_rmk"));
        }
    }