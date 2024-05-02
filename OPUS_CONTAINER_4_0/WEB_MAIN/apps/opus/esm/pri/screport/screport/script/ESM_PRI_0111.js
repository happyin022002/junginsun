/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName :  ESM_PRI_0111.js
*@FileTitle  : S/C Performance Summary - View B/L 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
/**
 * @fileoverview S/C Performance Summary - Business Script for View B/L 
 * @author 
 */
    /**
     * @extends Pri
     * @class ESM_PRI_0111 : Business Script for ESM_PRI_0111
     */
    function ESM_PRI_0111() {
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.processButtonClick=processButtonClick;
        this.doActionIBSheet=doActionIBSheet;
    }
    //  ===================================================================================
    // Global Variable
    //  ===================================================================================
    // Global Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    // Global Variable
    //  ===================================================================================
    //  Initializing page
    //  ===================================================================================
    /** 
     * registering IBSheet Object as list</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */ 
    function loadPage() {
        var form=document.form;	
        sheet1=sheetObjects[0];
        sheet2=sheetObjects[1];
        sheetCnt=sheetObjects.length ;
        //Initializing IBSheet
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheet1.SetWaitImageVisible(0);
if(form.sc_no.value==""){  ComClosePopup(); }
        doActionIBSheet(sheet2, form, IBBATCH);    
    }
    /** 
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets  <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : sheet Object
     * @param {int} sheetNo : Sheet Serial No  
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
	                var HeadTitle1="Seq.|B/L No.|VVD|Shipper|Consignee|Notify|F/Forwarder|A/Notify|A/Customer|Commodity|POR|POL|POD|DEL|B/L Onboard\nDate|Container No.|CNTR TP|FEU|Vol.";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"s_cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"c_cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"n_cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"f_cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"a_cust_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"act_cust_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bl_obrd_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"AutoSum",   Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetAutoSumPosition(1);
	                SetSheetHeight(400);
                }
                break;
            case "sheet2": // For find_text
                with (sheet2) {
	                var HeadTitle1="f_text1"
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetVisible(0);//Usingitforbackendjobalso.RefertoESM_PRI_0015UI
                    var idx=sheet2.DataInsert();
	                SetSheetHeight(80);
                }
                break;
        }
    }
    //  ===================================================================================
    // Process Button Event
    //  ===================================================================================
    document.onclick=processButtonClick;
    /** 
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void  
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */ 
    function processButtonClick(){
        var form=document.form;
        var rdoDateObj=form.rdoDate;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btn_retrieve":
                    //doActionIBSheet(sheet1, form, IBSEARCH);
                    doActionIBSheet(sheet2, form, IBBATCH);
                    break;
                case "btn_excel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;
                case "btn_close":
  ComClosePopup(); 
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    //  ===================================================================================
    // Retrieve/Save at Server
    //  ===================================================================================
    /** 
     * Retrieivng and saving <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object  
     * @param  {object} formObj :form Object
     * @param  {sAction} sAction Mandatory ,Process Contant value
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBBATCH: //backendjob
                try {
                    ComOpenWait(true);
                    sheet1.SetWaitImageVisible(0);
                    sheet2.SetWaitImageVisible(0);
                    formObj.f_cmd.value=COMMAND01;
                    var sXml=sheet2.GetSearchData("ESM_PRI_0111GS.do", FormQueryString(formObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheet2.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); // after 3 seconds
                        // recursive calling
                        // Execute - Recursive Call
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e.message);
                    ComOpenWait(false);
                }
                break;
            case IBSEARCH: 
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                sheet1.DoSearch("ESM_PRI_0111GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:      //download excel
                //SpeedDown2Excel(-1);
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
                sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
                break;
        }
    }
    /** 
     * Checking if BackEndJob Status='3' <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function getBackEndJobStatus() {
        try {
            var form=document.form;	
            form.f_cmd.value=SEARCH;
            var sXml=sheet2.GetSearchData("ESM_PRI_0111GS.do", FormQueryString(form));
            var jobState=ComGetEtcData(sXml, "jb_sts_flg");
            if (jobState == "3") {
                getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { 
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338']='Failed to download. Please try again.';
                clearInterval(timer);	
                ComOpenWait(false);	
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339']='Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);	
            }
        }catch(e){
            ComShowMessage(e.message);
            ComOpenWait(false);
        }
    }
    /** 
     * downloading result file of BackEndJob<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function getBackEndJobLoadFile() {
        try {	
            var form=document.form;
            form.f_cmd.value=SEARCHLIST;
            //var sXml = sheet1.GetSearchXml("ESM_PRI_0111GS.do", FormQueryString(form));
            //sheet1.LoadSearchXml(sXml);
            // For DoSearch4Fx
            //no support[check again]CLT sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOCALC";
            sheet1.DoSearchFx("ESM_PRI_0111GS.do", FormQueryString(form) );
//            sheet1.DoSearch("ESM_PRI_0111GS.do", FormQueryString(form));
            //form.result.value = ComGetEtcData(sXml, "RESULT");
        }catch(e){
            ComShowMessage(e.message);
        }finally{        	
            ComOpenWait(false);        		
        }
    }
    
    
    function sheet1_OnSearchEnd(sheetObj,errMsg){
    	sheetObj.SetSumText(0, "seq", "TOTAL");
    }
