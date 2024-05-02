/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0415.js
*@FileTitle : Deleted CNTR MVMT History
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
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObject, frmObj, IBSEARCH);
                    break;
                case "btn_new":
                    ComResetAll();
                    frmObj.p_cntrno.focus();
                    break;
                case "btn_close":
                	ComClosePopup(); 
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
        for (i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // CTM-COMMON
        setEventProcess();
        if (document.form.p_cntrno.value && document.form.ctnr_tpsz_cd.value)
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        // focusing on page loading
        document.form.p_cntrno.focus();
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
                              
              var HeadTitle="|CYC|C|STS|A/F|Origin YD|Return YD|Event Date|VVD Code|Booking No.|Booking No.|B/L No.|EQR Ref. No.|F/M|I/O|MSG|TP|D|E|R|R|SP|DM|DM Flg DT|DM Unflg DT|";
              HeadTitle += "S/P|S/P|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Update Date (L)|Creation Date (L)|Update Date (S)|Creation Date (S)|Delete Date (S)|DEL User ID|DEL User Name|Remark(s)";

             
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"HidSta" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_cyc_no" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_co_cd" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cre_tp_cd" },
                     {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd" },
                     {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdr_cd" },
                     {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_knt" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mty_pln_no" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ob_cntr_flg" },
                     {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_edi_msg_tp_id" },
                     {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd" },
                     {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_disp_flg" },
                     {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"imdt_ext_flg" },
                     {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_xch_cd",      ToolTipText:"Re-stuffing, F(From), T(To)" },
                     {Type:"Text",     Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rfub_flg" },
                     {Type:"Text",     Hidden:1,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg" },
                     {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dmg_flg" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt"},
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt"},
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm" },
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"chss_no" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no" },
                     {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"wbl_no" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_locl_dt" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_locl_dt" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt" },
                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"delt_dt" },
                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"delt_usr_id" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk" } ];
               
              InitColumns(cols);
              
              SetEditable(0);
              SetCountPosition(0);
//              SetSheetHeight(442);
              resizeSheet();
                    }


                break;
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    frmObj.f_cmd.value=SEARCH;
                     sheetObj.DoSearchFx("EES_CTM_0415GS.do", FormQueryString(frmObj) );
                }
                break;
        }
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, frmObj, sAction){
        with (frmObj) {
        }
        return true;
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}