/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3014.jsp
*@FileTitle  : TRI Creation & Amendment - Publication
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class Commodity Group : business script for Commodity Group 
     */
    function ESM_PRI_3014() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var uploadObjects=new Array();
    var uploadCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var beforeIndex=-1;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick() {
        var sheetObject1=sheetObjects[0];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_delete":
                    doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
                    break;
                case "btn_send":
                    doActionIBSheet(sheetObjects[0], document.form, IBLOADEXCEL);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
                    break;
                case "btn_close":
  ComClosePopup(); 
                    break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * setting IBUpload Object with uploadObjects array <br>
     **/
    function setUploadObject(uploadObj) {
        uploadObjects[uploadCnt++]=uploadObj;
    }
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
        for (i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //setting UPLOAD  
        for ( var i=0; i < uploadObjects.length; i++) {
            //1. basic setting
            ComConfigUpload(uploadObjects[i], "/opuscntr/ESM_PRI_3014GS.do");
            //2. initializing Upload 
            //initUpload(uploadObjects[i],i+1);
        }
        uploadObjects[0].AutoConfirm="UP_OVERWRITE_NO DELETE_NO";
        try {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        case "sheet1":
            with (sheetObj) {
                // setting height
        	
        	if (location.hostname != "")
        	var HeadTitle="|Sel.|Seq.|Tariff Code|Tariff Rate Item\n(TRI)|Current\nStatus|Commodity|Route|Route|Route|Route|Rate to be\nDeleted|Rate Basis|Per|Cargo\nType|Cur.|Rate|Note|Effective\nDate|Expiration\nDate|tri_prop_no|amdt_seq";
        	var HeadTitle1="|Sel.|Seq.|Tariff Code|Tariff Rate Item\n(TRI)|Current\nStatus|Commodity|Origin|Origin Via|Dest Via|Dest|Rate to be\nDeleted|Rate Basis|Per|Cargo\nType|Cur.|Rate|Note|Effective\nDate|Expiration\nDate|tri_prop_no|amdt_seq";
        	var headCount=ComCountHeadTitle(HeadTitle);
        	(headCount, 0, 0, true);

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	var headers = [ { Text:HeadTitle, Align:"Center"},
        	                { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trf_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tri_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cur_status",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"org_rout_pnt_loc_nm_snd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"org_rout_via_port_nm_snd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"dest_rout_via_port_nm_snd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"dest_rout_pnt_loc_nm_snd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_deleted",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rt_basis",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
        	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",                KeyField:0,   CalcLogic:"",   Format:"" },
        	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",                   KeyField:0,   CalcLogic:"",   Format:"" } ];
        	 
        	InitColumns(cols);
        	SetSheetHeight(320);
        	SetEditable(1);
//        	SetWaitImageVisible()(0);
//        	SetCountPosition()(0);
//        	SetAutoRowHeight()(1);
//        	SetShowButtonImage()(2);
            }
            break;
        }
    }
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
         try {
             if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                 ComOpenWait(true);
             }
            sheetObj.ShowDebugMsg(false);
            switch (sAction) {
                case IBSEARCH: // retrieve
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    var sXml=dialogArguments.getSheetXml(0);
                    sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
                    sheetObjects[0].CheckAll("chk",0);
                    ComOpenWait(false);
                    break;
                case IBDELETE: 
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    if (!ComPriConfirmDelete()) {
                        return false;
                    }
                    if (sheetObj.CheckedRows("chk") <= 0) {
                        sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
                    } else {
                        var iCheckRow=sheetObj.FindCheckedRow("chk");
                        var arrRow=iCheckRow.split("|");
                        for (var i=arrRow.length-2, n=0 ; i >= n ; i--) {
                            sheetObj.RowDelete(arrRow[i], false);
                        }
                    }
                    break;
                case IBLOADEXCEL: // Down Excel, Upload Excel, Send Mail
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    if (!ComShowCodeConfirm("PRI00118")) {
                        return false;
                    }
                    var dt=new Date();
                    var tm=dt.getYear()+ComLpad((dt.getMonth()+1),2,"0")+ComLpad(dt.getDate(), 2, "0")+ComLpad(dt.getHours(), 2, "0")+ComLpad(dt.getMinutes(), 2, "0")+ComLpad(dt.getSeconds(), 2, "0")+ComLpad(dt.getMilliseconds(), 3, "0");
//                    var excelname = "C:\\Windows\\Temp\\TRI_LIST_"+tm+".xls";
                    var excelname="C:\\temp\\TRI_LIST_"+tm+".xls";
                    // 1. Excel Download
                     sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,FileName:"excelname",TreeLevel:false});
//                    sheetObj.Down2Excel(-1, false, false, true, excelname, "apps/opus/esm/pri/triproposal/triproposal/script/ESM_PRI_3014.xml", false, false, "", false, "chk");
                    // 2. Excel Upload
                    var upObj=uploadObjects[0];
                    upObj.Files="";  
                    upObj.AddFile(excelname);
                    formObj.f_cmd.value=MULTI;
                    var sParam=sheetObj.GetSaveString(true);
                    sParam += "&" + FormQueryString(formObj);
                    upObj.ExtendParam=sParam; //param값 추가
                    upObj.ParamDecoding=true;
                    var sXml=upObj.DoUpload(true);
                    if (sXml.length > 0) {
                         sheetObj.LoadSaveData(sXml);
                    }
                    ComOpenWait(false);
                    break;
                case IBDOWNEXCEL: // Down
                    ComOpenWait(true);
                    if (!validateForm(sheetObj, document.form, sAction)) {
                        return false;
                    }
                    // 1. Excel Download
                    sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                    ComOpenWait(false);
                    break;
            }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * calling function when occurring OnSaveEnd event  <br>
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj=document.form;
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
            dialogArguments.reloadRate();
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            case IBSEARCH: //
                break;
            case IBDELETE: //
                if (sheetObj.RowCount()== 0) {
                    ComShowCodeMessage("PRI00011");
                    return false;
                }
                break;
            case IBLOADEXCEL: //
            case IBDOWNEXCEL: //
                if (sheetObj.RowCount()== 0) {
                    ComShowCodeMessage("PRI00018");
                    return false;
                }
                break;
        }
        return true;
    }
