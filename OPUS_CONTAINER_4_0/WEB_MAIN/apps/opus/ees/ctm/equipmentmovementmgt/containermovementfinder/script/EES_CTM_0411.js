/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0411.js
*@FileTitle : Detail Form
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event  */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                 case "btn_retrieve":
                     if (!checkFormField()) return;
                     doActionIBSheet(sheetObject1,formObject,IBSEARCH, 1);
                     break;
                 case "btn_eachbkg":
                    ComOpenPopup("/opuscntr/EES_CTM_0409_POP.do?" +  "bkg_no=" + sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "bkg_no"), 1020, 600, "", "0,1");
                     break;
                  case "btn_print":                  
                    if( sheetObject2.RowCount()==0 ) {
                        errMsg='No data to print.';
                        ComShowMessage(errMsg);
                        return;
                    }
                    ComOpenPopup("/opuscntr/EES_CTM_0459_POP.do", 900, 710, "", "0,1");
                    break;
                 case "btn_downexcel":
                     if(sheetObjects[1].RowCount() < 1){
                            ComShowCodeMessage("COM132501");
                        }else{
                            sheetObjects[1].Down2Excel({ HiddenColumn:-1});
                        }
                     break;
                 case "btn_clm":
//                     row=sheetObjects[1].GetSelectRow();
//                     cntrno=sheetObjects[1].GetCellValue(row, "cntr_no");
//                     cnmvyr=sheetObjects[1].GetCellValue(row, "cnmv_yr");
//                     cnmvid=sheetObjects[1].GetCellValue(row, "cnmv_id_no");
//                     url="EES_CTM_0443.do?cntr_no=" + cntrno + "&cnmv_yr=" + cnmvyr + "&cnmv_id_no=" + cnmvid;
//                     rtnValue=ComOpenPopup(url, 1000, 550, "", "0,1", true);
//                     break;
//                	 CSR #7277 CLM 관련 수정 by 2015/09/23 황미연
                	if (!checkFormField()) return;
 			  		goESD_SCE_0044(sheetObject1) ;
 			  		break;
                 case "btn_Calendar2":
                    var cal=new ComCalendarFromTo();
                        cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                     break;
                case "btn_del":
                    cntr_no=document.form.p_cntrno.value;
//                    chk_val=document.form.check_digit.value;
                    tpsz_cd=document.form.ctnr_tpsz_cd.value;
                    p_date2=document.form.p_date2.value;
                    p_date1=document.form.p_date1.value;
                    ComOpenPopup("/opuscntr/EES_CTM_0415_POP.do" +
                                 "?p_cntrno=" + cntr_no +
                                 "&ctnr_tpsz_cd=" + tpsz_cd + "&p_date2=" + p_date2 +
                                 "&p_date1=" + p_date1, 1020, 600, "", "0,1");
                     break;
                case "btn_close":
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
        for (i=0;i<sheetObjects.length;i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        setEventProcess();
        doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
        if (document.form.p_cntrno.value != "") {
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH, 1);
        }
        // document.form.p_cntrno.focus();
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
                        var HeadTitle="CYC|T/VVD|POR|POL|Relay|POD|DEL|Booking No.|TP|B/L No.|Commodity|Commodity|Commodity";
                        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                        var headers = [ { Text:HeadTitle, Align:"Center"} ];
                        InitHeaders(headers, info);
                        var cols = [ {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vl",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"relay",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                        InitColumns(cols);
                        SetEditable(0);
                        SetShowButtonImage(2);
                        SetSheetHeight(200);
                    }
                 break;
              case 2:      //sheet2 init
                    with(sheetObj){
                        var HeadTitle="Seq.|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|EQR Ref. No.|F/M|I/O|MSG|TP|HR|HB|D|E|R|R|SP|DM|DM Flg DT|DM Unflg DT|S/P|S/P|SCAC|EDI STOWAGE|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)|Office|User Name|Remark(s)|ext";
                        var sTipAF="[ Auto Flag ]" +
                        "<br>A : Missing status automatically created by system" +
                        "<br>C : (International) \"TS, IC, MT\" status automatically created after \"VD\"" +
                        "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      (USA domestic) \"CM\" status automatically created after \"CD\"" +
                        "<br>N : When \"A\" status is modified manually, \"A\" becomes \"N\" status" +
                        "<br>M : Added status" + 
                        "<br>U : Status updated due to the next status" +
                        "<br>E : Status created by Master/Lease" +
                        "<br>S : When \"A\" status is modified by EDI message, \"A\" becomes \"S\" status";
                        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                        var headers = [ { Text:HeadTitle, Align:"Center"} ];
                        InitHeaders(headers, info);
                        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" },
                               {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_co_cd" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, ToolTipText:sTipAF },
                               {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd" },
                               {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd" },
                               {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",            KeyField:0,   CalcLogic:"",   Format:"YmdHm" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_id" },
                               {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                               {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg", ToolTipText:"Bound indicator" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"[ Cargo type ] <br>F: Full, P: Reposition, R: Revenue" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Hanger Rack, Y" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Hanger Bar" },
                               {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Disposal Candidate, Y" },
                               {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Immediate Exit, Y" },
                               {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Re-stuffing, F(From), T(To)" },
                               {Type:"Text",     Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Re-furbishing, Y" },
                               {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Special, Y" },
                               {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Damage, Y" },
                               {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Damage Flag Date"},
                               {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0, ToolTipText:"Damage Unflag Date"},
                               {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm" },
                               {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"usa_edi_cd" },
                               {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_stwg_psn_ctnt" },
                               {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no" },
                               {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
                               {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
                               {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm" },
                               {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm" },
                               {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHm" },
                               {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"YmdHm" },
                               {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" },
                               {Type:"Text",     Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm" },
                               {Type:"Text",     Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk" },
                               {Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ext" },
                               {Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                               {Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
                               {Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" } ];
                        InitColumns(cols);
                        SetEditable(0);
                        //SetColProperty("cnmv_evnt_dt", {Format:"####-##-####:##"} );
                        //SetColProperty("upd_locl_dt", {Format:"####-##-####:##"} );
                        //SetColProperty("cre_locl_dt", {Format:"####-##-####:##"} );
                        //SetColProperty("upd_dt", {Format:"####-##-####:##"} );
                        //SetColProperty("cre_dt", {Format:"####-##-####:##"} );
//                        SetSheetHeight(300);
                        resizeSheet();
                    }
                 break;
         }
     }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if (validateForm(sheetObj,formObj,sAction)) {
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    cntrNo=formObj.p_cntrno.value;
                    sheetObjects[0].SetWaitImageVisible(0);
                    sheetObjects[1].SetWaitImageVisible(0);
                    ComOpenWait(true);
                    formObj.f_cmd.value=SEARCH;
                    sheetObj.SetDataAutoTrim(0);
                    xml=sheetObj.GetSearchData("EES_CTM_0430GS.do", FormQueryString(formObj));
                    rtnValue=xml.split("|$$|")
                    sheetObjects[0].LoadSearchData(rtnValue[1],{Sync:1} );
                    sheetObjects[1].LoadSearchData(rtnValue[0],{Sync:1} );
                    lastCnt=sheetObjects[1].LastRow();
                    // sheetObjects[0].SelectRow(lastCnt);
                    sheetObjects[1].SelectCell(lastCnt, 0);
                    sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), 0);
                    for (i=1; i <= sheetObjects[1].LastRow(); i++) {
                        if (sheetObjects[1].GetCellValue(i, "ext") == 'Y'){}
                            sheetObjects[1].SetCellBackColor(i,"Seq","#A478FF");
                    }
                    vr=sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(), "ext");
                    lastRow=sheetObjects[0].LastRow();
                    sheetObjects[0].SetCellFont("FontBold", 1, "bkg_no", lastRow, "bkg_no",1);
                    sheetObjects[0].SetColFontColor("bkg_no","#0000FF");
                    sheetObjects[0].SetColFontUnderline("bkg_no",1);
                    sheetObjects[0].SetDataLinkMouse("bkg_no",1);
//                    if (vr == 'Y') {
//                        ComBtnEnable("btn_clm");
//                    } else {
//                        ComBtnDisable("btn_clm");
//                    }
                    ComOpenWait(false);
                    sheetObjects[0].SetWaitImageVisible(1);
                    sheetObjects[1].SetWaitImageVisible(1);
                }
                break;
            case COMMAND05:
                    formObj.cnt_cd.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do?f_cmd=" + COMMAND05), "rtnValue");
                break;
        }
    }
    
    function goESD_SCE_0044(sheetObj){
	    var formObj=document.form ;
	    var cntrNO=formObj.p_cntrno.value;
	    var tpszCd=formObj.ctnr_tpsz_cd.value;
	    var paramUrl="cntr_no="+cntrNO+"&tpsz_cd="+tpszCd;
	    var newWin= ComOpenWindow("ESD_SCE_0044.do?"+paramUrl,  "clm_win",  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:1000px;dialogHeight:525px" , true);
	}
    
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
     
//    function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
//        vr=sheetObjects[1].GetCellValue(Row, "ext");
//        if (vr == 'Y') {
//            ComBtnEnable("btn_clm");
//        } else {
//            ComBtnDisable("btn_clm");
//        }
//    }
     
    function sheet2_OnMouseMove(sheetObj,Button,Shift, X, Y) {
        sheetObj.SetToolTipText(0, "ob_cntr_flg","Bound indicator");
        sheetObj.SetToolTipText(0, "bkg_cgo_tp_cd","Cargo type, F: Full, P: Reposition, R: Revenue");
        sheetObj.SetToolTipText(0, "cntr_dmg_flg","Damage, Y");
        sheetObj.SetToolTipText(0, "cntr_hngr_rck_cd","Hanger rack, Y");
        sheetObj.SetToolTipText(0, "cntr_hngr_bar_atch_knt","Hanger Bar");
        sheetObj.SetToolTipText(0, "cntr_disp_flg","Disposal Candidate, Y");
        sheetObj.SetToolTipText(0, "imdt_ext_flg","Immediate Exit, Y");
        sheetObj.SetToolTipText(0, "cntr_xch_cd","Re-stuffing, Y");
        sheetObj.SetToolTipText(0, "cntr_rfub_flg","Special, Y");
    }
    
    function sheet2_OnDblClick(sheetObj, Row, Col) {
//        row=sheetObjects[1].GetSelectRow();
//        vr=sheetObjects[1].GetCellValue(row, "ext");
//        if (vr != 'Y') return;
//        cntrno=sheetObjects[1].GetCellValue(row, "cntr_no");
//        cnmvyr=sheetObjects[1].GetCellValue(row, "cnmv_yr");
//        cnmvid=sheetObjects[1].GetCellValue(row, "cnmv_id_no");
//        url="EES_CTM_0443.do?cntr_no=" + cntrno + "&cnmv_yr=" + cnmvyr + "&cnmv_id_no=" + cnmvid;
//        rtnValue=ComOpenPopup(url ,1000, 550, "", "0,1", true);
        goESD_SCE_0044(sheetObj);
    }
    
    /**
     * calling Bkg Inquiry
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var SaveName=sheetObj.ColSaveName(Col);
        if (SaveName != 'bkg_no') return;
        var bkgNo=sheetObj.GetCellValue(Row, SaveName);
        var param="?bkg_no="+ bkgNo
                  + "&isPop=N"
                  + "&pgmNo=ESM_BKG_0079_Q_POP";
        ComOpenPopup("/opuscntr/ESM_BKG_0079_Q_POP.do" + param, 1300, 730, "", "0,1");
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[1]);
    }
