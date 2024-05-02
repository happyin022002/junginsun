/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0002.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isCA_Usr;
var sheet2HeadCount;
var vPolCd="";
var vPodCd="";
var vCstmsPortCd="";
var vRow="";
var intervalId="";

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name
 */
function processButtonClick() {
    /* */
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
        switch (srcName) {
        case "btn_retrieve":
        	sheetObjects[0].RemoveAll();
        	sheetObjects[1].RemoveAll();
            doActionIBSheet(sheetObjects[0], document.form, SEARCH);
            break;
        case "btn_delete":
            doActionIBSheet(sheetObject, formObject, MODIFY);
            break;
        case "btn_downexcel":
        	 if(sheetObjects[0].RowCount() < 1){
    			ComShowCodeMessage("COM132501");
    		}else{
//    			sheetObjects[0].Down2Excel({ HiddenColumn:-1,TreeLevel:false});
//    			sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
    			sheetObjects[0].Down2Excel({FileName : 'A6A VVD', DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1, Merge:1});
    		}
        	 
//        	 if(sheetObjects[1].RowCount() < 1){
//     			ComShowCodeMessage("COM132501");
//     		}else{
//    			sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
//     		}
            
            break;
        case "btn_addbl":
            if (validateForm(sheetObjects[1], formObject, COMMAND01)) {
                var row=sheetObjects[0].GetSelectRow();
                var vvd=sheetObjects[0].GetCellValue(row, "vvd_cd");
                var pol=sheetObjects[0].GetCellValue(row, "pol_cd");
                var pod=sheetObjects[0].GetCellValue(row, "pod_cd");
                var eta=sheetObjects[0].GetCellValue(row, "eta_dt");
                var pgmNo="pgmNo=ESM_BKG_0029";
                if (isCA_Usr) {
                    pgmNo="pgmNo=ESM_BKG_0029_2";
                }
                ComOpenWindowCenter("/opuscntr/ESM_BKG_0029_POP.do?mainPage=false&" + pgmNo + "&type=add&vvd=" + vvd + "&pod=" + pod + "&eta=" + eta, "0029", 1200, 750);
            }
            break;
        case "btn_editbl":
            if (validateForm(sheetObjects[1], formObject, COMMAND02)) {
                sheet2_OnDblClick(sheetObjects[1], sheetObjects[1].GetSelectRow(), 1);
            }
            break;
        case "btn_transmit":
            doActionIBSheet(sheetObject, formObject, MULTI);
            break;
        case "btn_terminal":
            document.form.terminal_auto_snd.value="";
            doActionIBSheet(sheetObject, formObject, MULTI02);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComFuncErrMsg(e);
        } else {
            ComFuncErrMsg(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param isCA_Usr : canada user flag
 */
function loadPage(isCA_Usr) {
    this.isCA_Usr=isCA_Usr
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
        sheetObjects[i].SetWaitImageVisible(0);
    }
    document.form.vvd_cd.focus();
    axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//    axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNoin
 * adding case as numbers of counting sheets
 * @param sheetObj 
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {
    case "sheet1": //sheet1 init
        with(sheetObj){
            var HeadTitle1="Seq.|VVD|POL|POD|ETA|FROB|Customs|SENT TIME|A6A|CNTR COUNT|B/L COUNT|etl_dt|bdr_flg|Terminal";
            var headCount=ComCountHeadTitle(HeadTitle1);
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq.",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"frob_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cstms_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mf_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a6a",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"etl_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pa",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                                   
            InitColumns(cols);
            
            SetEditable(0);
            SetSheetHeight(135);
        }

        break;
    case "sheet2": //sheet2 init
        with(sheetObj){
            var HeadTitle1="||Seq.|B/L No.|POL|POD|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|B/L Marks & Description|SHPR|SHPR|SHPR|SHPR|SHPR|SHPR|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|Booking Container|Booking Container|Booking Container|Booking Container|Container Manifest|Container Manifest|Container Manifest|Container Manifest|EDI|Sent Time||||||";
            var HeadTitle2="||Seq.|B/L No.|POL|POD|DEL|HUB|FILER|T/M|PK|WT|LOC OF GOODS|NM|AD|City|State|CNT|ZIP|NM|AD|City|State|CNT|ZIP|NM|AD|City|State|CNT|ZIP|Container|Seal|Rail AMS File No.|P/MIB No.|PK|WT|MK|DS|EDI|Sent Time||||||";
            var headCount=ComCountHeadTitle(HeadTitle1) + 2;
            sheet2HeadCount=ComCountHeadTitle(HeadTitle2);

            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
            
//            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_no2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0 },
                        {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_cnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hub_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ibd_loc_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cty_nm3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_ste_cd3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_zip_id3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seal_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"rail_crr_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usa_ib_trsp_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mk_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"edi",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"sent_time",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hbl_count",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mbl1_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mbl2_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mbl3_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bl_tot_count",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"error",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mh",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                               
                        InitColumns(cols);
                        
                        SetEditable(0);
                        SetCountPosition(0);
                        SetSheetHeight(300);
        }

        break;
    case 3: //sheet3 init
        with(sheetObj){
            var HeadTitle="RESULT";
            var headCount=ComCountHeadTitle(HeadTitle);
    
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
    
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
    
            var cols = [ {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"key",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
            InitColumns(cols);
            
            SetEditable(1);
            SetSheetHeight(100);
        }

    }
}

/**
 * handling process for Sheet
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case SEARCH:
        //first retrieving, setting data on sheet2 in case of Canada user
        if (validateForm(sheetObj, formObj, sAction)) {
            ComOpenWait(true);
//            initSheet(sheetObjects[1], 1);
            for (i=0; i < formObj.elements.length; i++) {
                if (formObj.elements[i].readOnly == true) {
                    formObj.elements[i].value="";
                }
            }
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_0002GS.do", FormQueryString(formObj) );
            
//            formObj.f_cmd.value = SEARCH;
//			sheetObj.DoSearch("ESM_BKG_0002GS.do", FormQueryString(formObj));
//			formObj.etl_dt.value = sheetObjects[0].CellValue(1, "etl_dt");
//			for (var i=1; i<sheetObj.RowCount+1;i++) {
//				sheetObj.CellFont("FontBold", i, 7) = true; 
//				sheetObj.CellFont("FontBold", i, 8) = true;
//			}
//			if (sheetObj.RowCount == 1)
//			{
//				sheet1_OnDblClick(sheetObj, 1, 1);
//			}            
            
        }
        break;
    case MODIFY: //Delete
        if (validateForm(sheetObjects[1], formObj, sAction)) {
            if (ComShowCodeConfirm("BKG00393")) {
                ComOpenWait(true);
                formObj.f_cmd.value=MODIFY;
                var sParam="bl_no=" + sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "bl_no") + "&f_cmd=" + MODIFY;
                var sXml=sheetObjects[1].GetSaveData("ESM_BKG_0002GS.do", sParam);
                if (ComBkgErrMessage(sheetObjects[1], sXml)) {
                    var row=sheetObjects[0].GetSelectRow();
                    doActionIBSheet(sheetObjects[0], document.form, SEARCH);
                    sheet1_OnDblClick(sheetObjects[0], row, 1);
                }
            }
        }
        break;
    case MULTI: //Transmit
        if (validateForm(sheetObjects[1], formObj, sAction)) {
            ComOpenWait(true);
            var sParam="f_cmd=" + MULTI;
            var sPreBlNo="";
            for ( var i=2; i < sheetObjects[1].RowCount()+ 2; i++) {
                if (sPreBlNo != sheetObjects[1].GetCellValue(i, "bl_no")) {
                    sParam=sParam + "&bl_no=" + sheetObjects[1].GetCellValue(i, "bl_no");
                    sPreBlNo=sheetObjects[1].GetCellValue(i, "bl_no");
                }
            }
            ComOpenWait(true, true);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0002GS.do", sParam);

            // BackEndJob every 3 seconds in case of possibility to take more than 30 seconds.
            var key=ComGetEtcData(sXml, "KEY");
            intervalId=setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
        }
        break;
    case MULTI02:
        if (validateForm(sheetObjects[1], formObj, sAction)) {
            var sParam="f_cmd=" + MULTI + "&type=Terminal&terminal_auto_snd="+formObj.terminal_auto_snd.value;
            var sPreBlNo="";
            var iCnt=0;
            for ( var i=2; i < sheetObjects[1].RowCount()+ 2; i++) {
                // no transmit Terminal in case of EMPTY BL
                if (sheetObjects[1].GetCellValue(i, "full_mty_cd") == "M") {
                    continue;
                }
                if (sPreBlNo != sheetObjects[1].GetCellValue(i, "bl_no")) {
                    sParam=sParam + "&bl_no=" + sheetObjects[1].GetCellValue(i, "bl_no");
                    sPreBlNo=sheetObjects[1].GetCellValue(i, "bl_no");
                    iCnt++;
                }
            }
            if (iCnt == 0) {
                ComShowCodeMessage("BKG01096");
                return;
            }
            ComOpenWait(true);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0002GS.do", sParam);
            // BackEndJob every 3 seconds in case of possibility to take more than 30 seconds.
            var key=ComGetEtcData(sXml, "KEY");
            intervalId=setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
        }
        break;
    }
}

function sheet1_OnSearchEnd(sheetObj){
	
	var formObj = document.form;
	//getCellValue -1 check
	if (sheetObjects[0].GetCellValue(1, "etl_dt") != "-1") {
		formObj.etl_dt.value=sheetObjects[0].GetCellValue(1, "etl_dt");
	}
	
    for (var i=1; i<sheetObj.RowCount()+1;i++) {
        sheetObj.SetCellFont("FontBold", i, 7,1);
        sheetObj.SetCellFont("FontBold", i, 8,1);
    }
    
    if (sheetObj.RowCount()== 1) {
        sheet1_OnDblClick(sheetObj, 1, 1);
    }else{
    	 ComOpenWait(false);
    }
}

/**
 * checking if saving process is completed because it will be done by BackEndJob 
 * @param sheetObj 
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
    var sXml=sheetObj.GetSearchData("ESM_BKG_0002GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    // ending waiting status in case of error
    if (!ComBkgErrMessage(sheetObj, sXml)) {
        clearInterval(intervalId);
        ComOpenWait(false);
        return;
    }
    if (sJbStsFlg == "SUCCESS") {
        clearInterval(intervalId);
        // success
        ComShowMessage(ComResultMessage(sXml));
        // retrieving sheet1, sheet2
        doActionIBSheet(sheetObjects[0], document.form, SEARCH);
        sheet1_OnDblClick(sheetObjects[0], vRow, 1);
        sheetObjects[0].SetSelectRow(vRow);
        ComOpenWait(false);
        return;
    } else if (sJbStsFlg == "FAIL") {
        //error
        clearInterval(intervalId);
        ComShowMessage(ComResultMessage(sXml));
        ComOpenWait(false);
        return;
    }
 }

/**
 * checking if saving process is completed because it will be done by BackEndJob 
 * for auto transmit of Terminal
 * @param sheetObj 
 * @param sKey BackEndJob Key
 */
function doActionValidationResult2(sheetObj, sKey) {
    var sXml=sheetObj.GetSearchData("ESM_BKG_0002GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    // ending waiting status in case of error
    if (!ComBkgErrMessage(sheetObj, sXml)) {
        clearInterval(intervalId);
        ComOpenWait(false);
        return;
    }
    if (sJbStsFlg == "SUCCESS") {
        var iCnt=0;
        for ( var i=2; i < sheetObjects[1].RowCount()+ 2; i++) {
            // no transmit Terminal in case of EMPTY BL
            if (sheetObjects[1].GetCellValue(i, "full_mty_cd") == "M") {
                continue;
            }
            iCnt++;
        }
        if (iCnt == 0) {
            clearInterval(intervalId);
            // success
            ComShowMessage(ComResultMessage(sXml));
            // retrieving sheet1, sheet2
            doActionIBSheet(sheetObjects[0], document.form, SEARCH);
            sheet1_OnDblClick(sheetObjects[0], vRow, 1);
            ComOpenWait(false);
        } else {
            // transmitting terminal.
            clearInterval(intervalId);
            document.form.terminal_auto_snd.value="A6A_AUTO";
            doActionIBSheet(sheetObjects[0], document.form, MULTI02);
        }
        return;
    } else if (sJbStsFlg == "FAIL") {
        //error
        clearInterval(intervalId);
        ComShowMessage(ComResultMessage(sXml));
        ComOpenWait(false);
        return;
    }
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj 
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case SEARCH:
        if (!ComChkValid(formObj))
            return false;
        if (isCA_Usr) {
            if (ComIsEmpty(formObj.pod_cd) && ComIsEmpty(formObj.cstms_port_cd)) {
                ComShowMessage("POD or Customs" + Msg_Required);
                formObj.pod_cd.focus();
                return false;
            }
        }
        break;
    case MODIFY: //Delete
    case COMMAND02: //EDIT BL
        if (sheetObjects[1].RowCount()<= 0) {
            ComShowCodeMessage("BKG00395");
            return false;
        }
        break;
    case COMMAND01: //ADD BL
        if (sheetObjects[0].RowCount()<= 0) {
            ComShowCodeMessage("BKG00395");
            return false;
        }
        break;
    case MULTI:
        if (sheetObjects[1].RowCount()<= 0) {
            ComShowCodeMessage("BKG00395");
            return false;
        }
        var error = false;
        var empty = 0;
        for (var i=sheetObj.HeaderRows();i<=sheetObj.LastRow(); i++)
    	{
        	if (sheetObj.GetCellValue(i, "error") == 'E')
    		{
        		error = true;
    		}
        	if (sheetObj.GetCellValue(i, "full_mty_cd") == "M")
    		{
        		empty++;
    		}
    	}
        var msgType = "A6A";
        if (empty == sheetObj.RowCount()) msgType = "E10";
        
        if (error) {
            if (!ComShowCodeConfirm("BKG00397"))
                return false;
        }
        else {
            if (!ComShowCodeConfirm("BKG01023", msgType, "Canada Customs")) 
                return false;
        }
    
        break;
    case MULTI02:
        if (sheetObjects[1].RowCount()<= 0) {
            ComShowCodeMessage("BKG00395");
            return false;
        }
        if (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "pod_cd").substr(0,2) != 'CA')
    	{
			ComShowCodeMessage('BKG00388', 'POD should be Canada for Terminal EDI');
        	return false;
    	}
        if (!ComShowCodeConfirm("BKG01023", "PA", "Terminal")) {
            return false;
        }
        break;
    }
    return true;
}

/**
 * double click event
 * @param sheetObj 
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
    ComOpenWait(true);
    var pod_cd=sheetObj.GetCellValue(row, "pod_cd");
    var pol_cd=sheetObj.GetCellValue(row, "pol_cd");
    var frob_flg=sheetObj.GetCellValue(row, "frob_flg");
    var cstms_port_cd=sheetObj.GetCellValue(row, "cstms_port_cd");
    document.form.f_cmd.value=SEARCH01;
//    sheetObjects[1].DoSearch("ESM_BKG_0002GS.do?pol_cd=pol_cd&pod_cd=pod_cd&frob_flg=frob_flg&cstms_port_cd=cstms_port_cd", FormQueryString(document.form) );
    
    sheetObjects[1].DoSearch("ESM_BKG_0002GS.do?pol_cd=" + pol_cd + "&pod_cd=" + pod_cd + "&frob_flg=" + frob_flg + "&cstms_port_cd="
			+ cstms_port_cd, FormQueryString(document.form));
 
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	   setCellFontColor(sheetObjects[1], sheetObjects[1].RowCount(), sheet2HeadCount);
	    if (sheetObjects[1].RowCount()> 0) {
	        IBS_CopyRowToForm(sheetObjects[1], document.form, 2, "frm_");
	        sheet2_OnClick(sheetObjects[1], 2, 1)
	    }
	    if (!isCA_Usr && sheetObjects[0].GetCellValue(1, "bdr_flg") == "Y") {
	        ComBtnDisable("btn_transmit");
	        ComBtnDisable("btn_terminal");
	    }
	    ComOpenWait(false);
}

/**
 * Sheet2 - double click event
 * @param sheetObj
 * @param row row Index
 * @param col col Index
 */
function sheet2_OnDblClick(sheetObj, Row, Col) {
    var bl_no=sheetObjects[1].GetCellValue(Row, "bl_no");
    var params="?mainPage=false&type=edit&bl_no=" + bl_no;
    if (isCA_Usr) {
        params=params + "&pgmNo=ESM_BKG_0029_2";
    } else {
        params=params + "&pgmNo=ESM_BKG_0029";
    }
    ComOpenWindowCenter("/opuscntr/ESM_BKG_0029_POP.do" + params, "0029", 1200, 750);
}

/**
 * Sheet1 click event
 * @param sheetObj 
 * @param row row Index
 * @param col col Index
 */
function sheet2_OnClick(sheetObj, row, col) {
    /**
     * applying same color in case of same BL No. default background color - white
     */
//    var bl_no=sheetObj.GetCellValue(row, "bl_no")
//    for ( var i=2; i < sheetObj.RowCount()+ 2; i++) {
//        if (sheetObj.GetCellValue(i, "bl_no") == bl_no) {
//            sheetObj.SetRowBackColor(i,"#E7FAF6");
//        } else {
//            sheetObj.SetRowBackColor(i,"#FFFFFF");
//        }
//    }
}

/**
 * changing font color of BL in case of error
 * @param sheetObj 
 * @param rowCount Row Count
 * @param colCount Col Count
 * @return
 */
function setCellFontColor(sheetObj, rowCount, colCount) {
//    var vErrorData=false;
    for ( var i=1; i <= rowCount + 1; i++) {
        for ( var j=1; j <= colCount; j++) {
            if (sheetObj.GetCellValue(i, j) == "N") {
                sheetObj.SetCellFontColor(i, j,"#FF0000");
//                vErrorData=true;
            }
        }
        if (sheetObj.GetCellValue(i, "mh") == "H") {
            sheetObj.SetCellFontColor(i, "bl_no","#0000FF");
        }
    }
//    if (vErrorData)
//        document.form.error_data.value="true";
}

/**
 * when inputting search condition
 */
function obj_KeyUp() {
    var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    //var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcMaxLength=ComGetEvent("maxlength");
    //var srcValue=window.event.srcElement.getAttribute("value");
    var srcValue=ComGetEvent("value");
    if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
    }
}

/**
 * 엑셀 및 텍스트 파일이 다운로드 완료 되었을때 이벤트가 발생한다.
 * @param downloadType
 * @param result
 */
function sheet1_OnDownFinish(downloadType, result) {
	if(sheet2.RowCount() < 1 ){//no data sheet1	
		ComShowCodeMessage("BKG00155");
	}else{
		sheet2.SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");
		sheet2.Down2Excel({FileName : 'A6A BL LIST', DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1, Merge:1});
//		sheet2.SetHeaderBackColor("#333333");
	}
}