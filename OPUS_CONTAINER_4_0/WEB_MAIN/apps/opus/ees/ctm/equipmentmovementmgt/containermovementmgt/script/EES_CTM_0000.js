/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_ctm_0000.js
*@FileTitle  : GATENEW Test
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_ctm_0000 : business script for ees_ctm_0000 
     */
    function ees_ctm_0000() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
 document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_save":
                    sheetObjects[0].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    sheetObjects[0].RemoveAll();
                    doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);   
                    ComOpenWait(false);
                    sheetObjects[0].SetWaitImageVisible(1);
                   break;
                case "btn_new":
                    ComResetAll();
                    sheetObjects[0].SetRowStatus(sheetObjects[0].DataInsert(),"R");
                    break;
            } // end switch
        } catch(e) {
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        sheetObjects[0].SetRowStatus(sheetObjects[0].DataInsert(),"R");
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="|SEQ|Msg Id|Muid Area|Cntr Number|Term Id|Event Yard|Event Date|Gate IO|Cont Stat|Sight Cd|Chss Code|Call Sign No|Lloyd No|Bl No|Pol|Pod|Dest Loc|Seal No|Dmg Flag|Pickup No|Mg Set|Bkg Number|Mvmt Status";
		             SetEditEnterBehavior("tab");
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"msg_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"muid_area",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_number",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"term_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"event_yard",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"event_date",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gate_io",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cont_stat",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sight_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"call_sign_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lloyd_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_loc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"seal_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pickup_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mg_set",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_number0",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_status",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetDataAutoTrim(1);
		             SetColProperty("event_date", {Format:"####/##/####:##:##"} );
		             SetCountPosition(0);
		             SetSheetHeight(200);
		             SetSelectionMode(smSelectionList);
		             
		             //conversion of function[check again]CLT                     InitDataValid(0, "msg_id", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "muid_area", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "cntr_number", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "term_id", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "event_yard", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "mvmt_status", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "gate_io", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "cont_stat", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "sight_cd", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "chss_code", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "call_sign_no", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "lloyd_no", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "bl_no", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "pol", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "pod", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "dest_loc", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "seal_no", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "dmg_flag", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "pickup_no", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "mg_set", vtEngUpOther, "1234567890");
		             //conversion of function[check again]CLT                     InitDataValid(0, "bkg_number0", vtEngUpOther, "1234567890");
		             }
                	 break;
            case 2:      //sheet2 init
                with(sheetObj){
		             var HeadTitle="Seq.|Mvmt Status|Result Message|Result Message|Bkg Number|Edi Id|Msg Id|Muid Area|Muid Dt|Muid Seq|Vessel|Voyage|Dir";
		             SetEditEnterBehavior("tab");
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"edi_mvmt_sts_cd",       KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_rslt_cd",      KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_edi_rmk",          KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_tp_cd",        KeyField:1 },
		                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id",    KeyField:1 },
		                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_area_cd",  KeyField:1 },
		                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_yrmondy",  KeyField:1 },
		                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_seq",      KeyField:1 },
		                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_vsl_cd",           KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_voy_no",       KeyField:0 },
		                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd",       KeyField:0 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(0);
		             SetDataAutoTrim(1);
		             SetCountPosition(0);
		             SetSheetHeight(150);
		             SetSelectionMode(smSelectionList);
                     }
                	 break;
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSAVE:    
                if (validateForm(sheetObj,frmObj,sAction)) {
                    if (frmObj.input_radio[0].checked && !sheetObj.IsDataModified()) {
                        alert("Sheet에 저장할 DATA가 없습니다.");
                        return;
                    } else if (frmObj.input_radio[1].checked && frmObj.mq_text.value.trim() == "") {
                        alert("MQ_Text에 저장할 DATA가 없습니다.");
                        return;
                    }
                    sheetObjects[1].RemoveAll();
                    frmObj.f_cmd.value=MULTI;
                    var saveXml=sheetObjects[0].GetSaveData("EES_CTM_0000GS.do", sheetObjects[0].GetSaveString() + "&" + FormQueryString(frmObj));
                    saveXml=ComReplaceStr(saveXml, "^#^", "'");
                    sheetObjects[1].LoadSearchData(saveXml,{Sync:1} );
                }
                break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,frmObj,sAction){
        with(frmObj){
        }
        return true;
    }
