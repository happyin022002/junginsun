/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variables
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    var blInfo_no       = 0;
    var euDoRlseStsCntr = 1;
    var euDoRlseStsBl   = 2;
    var demInfo         = 3;
    var demDtl          = 4;
    var totBlbAmt       = 5;
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    var previewSheet = 1;
    document.onclick = processButtonClick;
    function processButtonClick(){
        var param=null;
        var sc_no=null;
        var cntr_no=null;
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(!ComIsBtnEnable(srcName)){
                return;
            }
            switch(srcName) {
                case "img_exp_del_dt":
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;
                case "btn_cct":
					blOutstandingAmountPopOpen(true);
                break;
                case "btn_third_cct":
					blOutstandingAmountPopOpen(false);
                break;
                
                case "btn_tpb":
                    var frDate = ComGetDateAdd(null, "D", -60);
                    var toDate = ComGetNowInfo("ymd", "");
                    var otsStsCd = "";

                    if (document.form.tpb_status.value == "1") {
                    	otsStsCd = "P";
                    } else {
                    	otsStsCd = "T";
                    }

                    var condition = "?";
                    	condition += "s_state=BKG";
                    	condition += "&s_bkg_no_all="+sheetObjects[blInfo_no].GetCellValue(1, "blInfo_bkg_no");
                    	condition += "&s_bl_no_all="+sheetObjects[blInfo_no].GetCellValue(1, "blInfo_bl_no");
                    	condition += "&s_ots_sts_cd=" + otsStsCd;
                    	condition += "&pgmNo=ESD_TPB_0134";

                    ComOpenWindowCenter('ESD_TPB_0134.do'+condition, 'TPB', 1024, 318, true);
                    
                    break;
                case "btn_bl_surr_rmk":
                    var condition="?";
                    condition += "bkg_no="+sheetObjects[0].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&isPopUp=Y&inquery_only=Y"+ "&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('ESM_BKG_0400_POP.do'+condition, 'bl_surr_rmk', 900, 300, true);
                break;
                case "btn_dem_retrieve":
                	doActionIBSheet(sheetObjects[0], formObject,COMMAND05);
                	break;
                case "btn_dmdt":
                	var bkgNo=sheetObjects[0].GetCellValue(1, "blInfo_bkg_no");
                	var blNo=sheetObjects[0].GetCellValue(1, "blInfo_bl_no");
                    var trfCd=formObject.demur_type.value
                    var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd+ "&pgmNo=EES_DMT_3002P";
                    ComOpenWindowCenter('EES_DMT_3002P.do' + paramVal, 'dmdt', 1050, 670, false,"yes");
                	break;
               case "btn_save":
					doActionIBSheet(sheetObjects[0], formObject,IBSAVE);
					break;
               case "btn_bl_surr_rmk":
                   var condition="?";
                   condition += "bkg_no="+ sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                       condition += "&inquery_only=Y";
                       condition += "&pgmNo=ESM_BKG_0400";
                   ComOpenWindowCenter('/opuscntr/ESM_BKG_0400_POP.do'+ condition, 'bl_surr_rmk', 900, 300, false);
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
        	if (sheetObjects[i].id == "euDoRlseStsBl" || sheetObjects[i].id == "euDoRlseStsCntr" || sheetObjects[i].id == "demInfo") {
            	ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
        	} else {
                initSheet(sheetObjects[i],i+1);
        	}
        }
        initControl();
    	ComSetUIItem(sheetObjects[0], document.form, "BKG", "ESM_BKG_0292_02");
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        } 
    }
  	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
    **/
    function initControl() {
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var prefix="";
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "blInfo":
                with(sheetObj){
		              var HeadTitle=" |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL TP CD|DSCH_LOC|OBL_ISS_RMK" +
		              " |INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|SPLIT_FLG" +
		              " |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | | | | | | | |" +
		              " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
		              var prefix="blInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_split_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(0);
		              SetVisible(0);
                    }
                break;
            case "euDoRlseStsBl":
                with(sheetObj){
	              var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE STS CTNT";
	              var prefix="euDoRlseStsBl_";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(150);
              }
            break;
            case "euDoRlseStsCntr":
                with(sheetObj){
	              var HeadTitle=" |CNTR No|Status CD|Status|D/O No.|Update Time|User ID|OFC CD|Bkg No|STS SEQ|SEQ";
	              var prefix="euDoRlseStsCntr_";
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetVisible(0);
	              SetSheetHeight(150);
              	}
            break;
            case "demInfo":
                /****************************************************************
                //DEM.DET I/F
                *****************************************************************/
                with(sheetObj){
	              var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
	              var prefix="demInfo_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fx_ft_ovr_dys",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bzc_trf_curr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                     {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                     {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                     
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(0);
//	              SetSheetHeight(150);
	              resizeIfSheet();
                }
            break;
            case "demDtl":
                with(sheetObj){
	              var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
	              var prefix="demDtl_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(0);
	              SetVisible(0);
                }
            break;
            case "totBlbAmt":
                with(sheetObj){
		              var HeadTitle1="|curr_cd|tot_bil_amt";
		              prefix="totBlbAmt_";
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetVisible(0);
                    }
                break;
        }
    }
    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      // retrieve
            	ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var aryPrefix=new Array("blInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix String array
                 var sXml=sheetObj.GetSearchData("ESM_BKG_0292_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                if(undefined != ComGetEtcData(arrXml[0], "splitFlg") && ComGetEtcData(arrXml[0], "splitFlg") != 'null'){
              	  var splitFlg=ComGetEtcData(arrXml[0], "splitFlg");
              	  if (splitFlg == "N") {
              		  sheetObjects[2].SetVisible(1);
              		  sheetObjects[1].SetVisible(0);
              		  document.form.split_flg[0].checked=true;
              	  } else {
              		  sheetObjects[2].SetVisible(0);
              		  sheetObjects[1].SetVisible(1);
              		  document.form.split_flg[1].checked=true;
              	  }
                }
                if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
                    formObj.demur_type.value=ComGetEtcData(arrXml[0], "demurType");
                }
                for(var idx=0; idx < arrXml.length; idx++){
                    sheetObjects[idx].LoadSearchData(arrXml[idx]);
                }
                ComOpenWait(false);
                break;
            case COMMAND05: //DEM Retrieve
	            if(!validateForm(sheetObj,formObj,sAction)){
	            	return;
	            }
	            ComOpenWait(true);
	            
	            setTimeout( function () { //@ setTimeout ###########################################################
	            	
	                formObj.f_cmd.value=SEARCH;
	                var aryPrefix=new Array("blInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "demInfo_", "demDtl_", "totBlbAmt_"); //prefix 문자열 배열
 	                var sXml=sheetObj.GetSearchData("ESM_BKG_0292_02GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	                var arrXml=sXml.split("|$$|");
	                var t3Idx=blInfo_no;
	                for(var idx=3; idx < arrXml.length; idx++){
	                	t3Idx=blInfo_no + idx;
	                    sheetObjects[t3Idx].LoadSearchData(arrXml[idx],{Sync:1} );
	                }
	                
	                if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
	                	formObject.demur_type.value=ComGetEtcData(arrXml[0], "demurType");
	                }
	            
	            } , 100);//@ setTimeout end ###########################################################
	            break;
            case IBSAVE:   // retrieve
	            if(validateForm(sheetObj, formObj, sAction)){
	                formObj.f_cmd.value=MODIFY;
	                CopyFormToRow(formObj, sheetObjects[0], 1, "");
	                sheetObjects[0].SetRowStatus(1,"U");
	                var sParam1=sheetObjects[0].GetSaveString();   //EU D/O Release Reference 정보
	                if(! sheetObjects[0].IsDataModified()){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }
	                var bkgNo=sheetObjects[0].GetCellValue(1, "blInfo_bkg_no");
	                if( !ComShowCodeConfirm('COM12147') ){
	                    return false;
	                }
	                var aryPrefix=new Array("blInfo_");    
	                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
 	                var sXml=sheetObjects[0].DoSave("ESM_BKG_0292_02GS.do", sparam);
	            }
	            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var oForm=document.form;
    	switch(sAction) {
        case COMMAND05:
        	if(!ComChkObjValid(oForm.exp_del_dt)) {
                return false;
            }
            var toDay=ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }
        	return true;
            break;
        }
        return true;
    }
    /**
     * HTML Control onkeypress event
     * @param void
     * @return void
     * @author
     * @version 2009.11.01
     **/
//    function obj_keypress(){
//    	var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//        var srcName=ComGetEvent("name");
//        if (keyCode == 13 && srcName == 'exp_del_dt') {
//        	if(sheetObjects[0].GetCellValue(1,"blInfo_bkg_no") != undefined){
//                 doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
//             }
//        }
//        if(srcName == 'exp_del_dt'){
//            ComKeyOnlyNumber(event.srcElement);
//        }
//    	switch(event.srcElement.dataformat){
//            case "float":
//                ComKeyOnlyNumber(event.srcElement, ".");
//                break;
//            case "eng":
//                //ComKeyOnlyAlphabet();
//                ComKeyOnlyAlphabet('uppernum');
//                break;
//            case "engdn":
//                ComKeyOnlyAlphabet('lower');
//                break;
//            case "engup":
//                ComKeyOnlyAlphabet('upper');
//                break;
//            default:
//                ComKeyOnlyNumber(event.srcElement);
//        }
//    }
    /**
     * Form Object Deactive event
     * @return
     */
    function obj_deactivate(){
        var objName=event.srcElement.name;
        var formObj=document.form;
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
        }
    }

    /**
     * S/O Info value Clear
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnCargoClear() {
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if (document.form.getElementsByTagName("input")[i].name.substr(0, 12) == "frm_t1sheet1") {
            	document.form.getElementsByTagName("input")[i].value="";
            }
        }
        var selOtsAmt=document.form.t3_tot_ots_amt;
        for (i=selOtsAmt.length-1; i>=0; i--){
        	selOtsAmt.options[i]=null
        }
        var selDemAmt=document.form.t3_tot_bil_amt;
        for (i=selDemAmt.length-1; i>=0; i--){
            selDemAmt.options[i]=null
        }
        fnAllSheetClear();
    }
    /**
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSearch() {
    	fnCargoClear();
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
    }
    // make select box
    function t3addSel(sheetObj) {
        var sel=document.form.t3_tot_ots_amt;
        var formObj = document.form;
        var prefix="blInfo_";
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='C'){
            // btn_cct disable
            formObj.div_btn_cct.style.visibility="hidden";
            formObj.div_btn_third_cct.style.visibility="hidden";
        } else if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='N'){
            // btn_cct, div_btn_third_cct visible
        	if (sheetObj.GetCellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
              formObj.div_btn_cct.style.visibility="visible";
            }else {
              formObj.div_btn_cct.style.visibility="hidden";
            }
        	if (sheetObj.GetCellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
              formObj.div_btn_third_cct.style.visibility="visible";
            } else {
              formObj.div_btn_third_cct.style.visibility="hidden";
            }
        } else {
        	document.form['t3_tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
			formObj.t3_tot_ots_amt.className="input2_1";
            // btn_cct disable
            formObj.div_btn_cct.style.visibility="hidden";
            formObj.div_btn_third_cct.style.visibility="hidden";
            return;
        }
        var unit="";
        var amount="";
        var colorFlg="";
        for (j=0; j<5; j++){
        	unit=sheetObj.GetCellValue(1, "blInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        	amount=sheetObj.GetCellValue(1, "blInfo_"+"tot_ots_amt"+parseInt(j+1));
            if(! ComIsEmpty(unit)){
            	if (amount != 0) {
            		colorFlg="Y";
            	}
            	document.form['t3_tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);                
            }
        }
        if (colorFlg == "Y") {
        	formObj.t3_tot_ots_amt.className="input2_1";
        } else {
        	formObj.t3_tot_ots_amt.className="input2";
        }
    }

    /**
     * process after blInfo save 
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
             fnSearch();
    }
    /**
     *  process after EU D/O Release retrieveing
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){
    	//Wait Image Show Hidden
        ComOpenWait(false);
        var formObj = document.form;
        document.form.blInfo_inter_rmk.value="";
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, formObj, "");
                formObj.bkg_no.value=sheetObj.GetCellValue(1,"blInfo_bkg_no");
                formObj.bl_no.value=sheetObj.GetCellValue(1,"blInfo_bl_no");
                if (sheetObj.GetCellValue(1, "blInfo_do_hld_flg") == "") {
             	    sheetObj.SetCellValue(1, "blInfo_do_hld_flg","N",0);
             	}
                // refInfo ==> blInfo
                if(sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='N'){
                    formObj.hold_flag.className="input2";
                }else if(sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='Y'){
                    formObj.hold_flag.className="input2_1";
                    formObj.hold_flag.value='Hold';
                }else{
                    formObj.hold_flag.className="input2";
                }
                if (document.form.blInfo_bl_tp_cd.value == "") {
                    document.form.blInfo_bl_tp_cd.value="B";
                }
                if( formObj.blInfo_obl_rdem_flg.value =='Y'){
                    formObj.blInfo_obl_rdem_flg.style.color='blue';
                }else if(formObj.blInfo_obl_rdem_flg.value =='N'){
                    formObj.blInfo_obl_rdem_flg.style.color='red';
                }
//                formObj.pre_ctnt.value=formObj.blInfo_obl_rdem_knt.value;
//                if (sheetObj.GetCellValue(1, "blInfo_bl_tp_cd") == "S") {
//                    formObj.bl_surr_rmk_flg.value="Y";
//                    formObj.div_btn_bl_surr_flg.style.visibility="visible";
//                } else {
//                    formObj.bl_surr_rmk_flg.value="";
//                    formObj.div_btn_bl_surr_flg.style.visibility="hidden";
//                }
                //D/O EVENT에서 변경되기 전의 값 -->
                document.getElementById("pre_ctnt").value = document.getElementById("blInfo_obl_rdem_knt").value;

                // BL이 Surrender이면 OB/L Received쪽  Remark조회 버튼을 enable 및 필드는 Y로 Setting, 아닐경우 button disable (add by mgpark)
                if (sheetObj.GetCellValue(1, "blInfo_bl_tp_cd") == "S") {
                    document.getElementById("bl_surr_rmk_flg").value = "Y";
                    ComBtnEnable("btn_bl_surr_rmk");
                    document.getElementById("btn_bl_surr_rmk").style.visibility="visible";
                } else {
                    document.getElementById("bl_surr_rmk_flg").value = "";
                    ComBtnDisable("btn_bl_surr_rmk");
                    document.getElementById("btn_bl_surr_rmk").style.visibility="hidden";
                }
                
                
                // otsRcvInfo ==> blInfo
                t3addSel(sheetObj);
                ComBtnEnable("btn_cct");
                ComBtnEnable("btn_third_cct");
                ComBtnEnable("btn_erp");
                if( formObj.blInfo_tot_ots_sts_cd.value =='Y'){
                    formObj.blInfo_tot_ots_sts_cd.style.color='blue';
                }else if(formObj.blInfo_tot_ots_sts_cd.value =='N'){
                    formObj.blInfo_tot_ots_sts_cd.style.color='red';
                }
            }
            /*************************************************************
                TPB 0 : red 1 : green -1 : gray
            *************************************************************/
            ComBtnEnable("btn_erp");
            ComBtnEnable("btn_dem_retrieve");
            ComBtnEnable("btn_dmdt");
            ComBtnEnable("btn_history");
        } else {
       	  	fnAllSheetClear();
        }
    }
    /**
     * Process after Hidden IBSheet retrieve
     */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
        var sel=document.form.t3_tot_bil_amt;
        var formObj = document.form;
        for (i=sel.length-1; i>=0; i--){
        	sel.options[i]=null
        }
        var currCd="";
        var bilAmt="";
        var demSts=false;
        if (sheetObj.RowCount()> 0) {
        	for (j=0; j<sheetObj.RowCount(); j++){
        		currCd=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
        		bilAmt=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");
        		if (parseInt(bilAmt) > 0) {
        			demSts=true;
        		}
        		document.form['t3_tot_bil_amt'][j]=new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
       	  	}
       	  	if (demSts == true) {
       	  		formObj.demur_sts.value="N";
                formObj.demur_sts.style.color='red';
                formObj.t3_tot_bil_amt.className="input2_1";
       	  	} else {
       	  		formObj.demur_sts.value="Y";
                formObj.demur_sts.style.color='blue';
                formObj.t3_tot_bil_amt.className="input2";
       	  	}
        } else {
        	formObj.demur_sts.value="Y";
            formObj.demur_sts.style.color='blue';
            document.form['t3_tot_bil_amt'][0]=new Option('0');
            formObj.t3_tot_bil_amt.className="input2";
        }
    }
    /**
     * Process after Hidden IBSheet retriveve
     */
    function euDoRlseStsCntr_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
        if (ErrMsg == "") {
       	    if (document.form.blInfo_do_split_flg.value == "N") return;
       	    if(sheetObj.RowCount()> 0){
                for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                	if(sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") != 'C'){
		
                		formObj.rlse_sts_cd.value=sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }
                    if(idx == sheetObj.RowCount()){
                    	formObj.last_rlse_sts_cd.value=sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }
                }
                formObj.h_do_no.value=sheetObj.GetCellValue(1, "euDoRlseStsCntr_do_no");
                var headRow=sheetObjects[1].HeaderRows();
                var splitYn=false;
                for(var idx=headRow; idx <= sheetObjects[1].LastRow(); idx++){
                	if (sheetObjects[1].GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") == "R") {
                		splitYn=true;
                	}
                }
                if(splitYn == false){
                    document.form.split_flg[0].disabled=false;
                    document.form.split_flg[1].disabled=false;
                } else {
               	  	document.form.split_flg[0].disabled=true;
               	  	document.form.split_flg[1].disabled=true;
                }
                formObj.pre_ctnt.value=sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
            }
        }
    }
    /**
     * Process after Hidden IBSheet retrieve
     */
    function euDoRlseStsBl_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
        if (ErrMsg == "") {
	        if (document.form.blInfo_do_split_flg.value == "Y") return;
	        if(sheetObj.RowCount()> 0){
	            for(var idx=1; idx <= sheetObj.RowCount(); idx++){
	            	if(sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd") != 'C'){
	            		formObj.rlse_sts_cd.value=sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
	                }
	                if(idx == sheetObj.RowCount()){
	                	formObj.last_rlse_sts_cd.value=sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
	                }
	            }
	            formObj.h_do_no.value=sheetObj.GetCellValue(1, "euDoRlseStsBl_do_no");
	            if(sheetObj.RowCount()== 1 && sheetObj.GetCellValue(1, "euDoRlseStsBl_rlse_sts_cd") == 'C'){
		        	document.form.split_flg[0].disabled=false;
		            document.form.split_flg[1].disabled=false;
		        } else {
		        	document.form.split_flg[0].disabled=true;
		            document.form.split_flg[1].disabled=true;
		        }
	            formObj.pre_ctnt.value=sheetObj.GetCellValue(1, "euDoRlseStsBl_rlse_sts_cd");
            }
        }
    }
     /**
      * CCT,Third Office(CCT) <br>
      */
     function blOutstandingAmountPopOpen(flag){
         var maxRow=sheetObjects[0].LastRow();
         var cellValue="";
         var prefix="blInfo_";
         var curr_cd="";
         var ots_amt=0;
         var strXmlBody="";
         var xmlCnt=0;
         for(i=1;i <= maxRow ; i++){
             //text color setting
             for(var q=1;q<6;q++){
                 if (flag == true) { // CCT
                	 if (sheetObjects[0].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                		 curr_cd=sheetObjects[0].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
                		 ots_amt=sheetObjects[0].GetCellValue(i, prefix + "cct_ots_amt" + q);
                         strXmlBody=strXmlBody + "<TR><![CDATA[" + curr_cd + "☜☞" + ots_amt + "☜☞]]></TR>";
                         xmlCnt=parseInt(xmlCnt) + 1;
                     }
                 } else {            // Third Office(CCT)
                	 if (sheetObjects[0].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                		 curr_cd=sheetObjects[0].GetCellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                		 ots_amt=sheetObjects[0].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q);
                         strXmlBody=strXmlBody + " <TR><![CDATA[" + curr_cd + "☜☞" + ots_amt + "☜☞]]></TR>";
                         xmlCnt=parseInt(xmlCnt) + 1;
                     }
                 }
             }
         }
         if (parseInt(xmlCnt) > 0) {
             var sXml="";
             sXml="<SHEET> ";
             sXml=sXml + "<DATA COLORDER='otsRcvPop_curr_cd|otsRcvPop_ibflag|otsRcvPop_tot_ots_amt|otsRcvPop_pagerows|' COLSEPARATOR='☜☞' TOTAL='" + xmlCnt + "'>"
             sXml=sXml + strXmlBody;
             sXml=sXml + "</DATA> </SHEET>";
             document.form.oaXmlData.value=sXml;
             ComOpenWindowCenter("ESM_BKG_1022.do", "CCT", 400, 320, true);
             
         }
     }
    function setSplitFlag(splitFlg) {
	   	if (splitFlg == "N") {
	   		sheetObjects[2].SetSheetHeight(66,1);
	   		sheetObjects[1].SetSheetHeight(0,1);
	   		document.form.blInfo_do_split_flg.value="N";
	    } else {
	       	document.form.blInfo_do_split_flg.value="Y";
	   		sheetObjects[2].SetSheetHeight(0,1);
	   		sheetObjects[1].SetSheetHeight(66,1);
	   	}
    }
    function fnAllSheetClear() {
    	for(i=0; i<sheetObjects.length; i++){
    		sheetObjects[i].RemoveAll();
    	}
    }
    function fncTextareaMaxLine(obj) {
        var str_line=obj;
        line=str_line.split("\r\n");
        ln=line.length;
        if(ln == 5 && event.keyCode == 13){
            event.returnValue=false;
        }
    }
    /**
    * Process After Hidden IBSheet Retrieveing
    */
    function demInfo_OnSearchEnd(sheetObj){
        ComOpenWait(false);
    }
    /**
    * Process After Hidden IBSheet Retrieveing
    */
    function demDtl_OnSearchEnd(sheetObj){
        var invTotBilAmt=0;
        var fist_cntr_no=sheetObjects[3].GetCellValue(1, "demInfo_cntr_no");
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	if(fist_cntr_no != sheetObjects[4].GetCellValue(idx, "demDtl_cntr_no")){
                sheetObjects[4].SetRowHidden(idx,1);
            }
        }
   }
    /**
    * Grid OnClick event
    */
   function demInfo_OnDblClick(sheetObj, row, col){
	   var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
       demDtlPopOpen(click_cntr_no);
   }
    /**
     * DEM.DET detail Info.
     */
    function demDtlPopOpen(cntr_no){
        var sXml=IBS_GetDataSearchXml(sheetObjects[4]);
        document.form.demDtlXmlData.value=sXml;
        var condition="?";
            condition += "cntr_no="+cntr_no;
        ComOpenWindowCenter('ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }
    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
     		document.form.bkg_no.value=bkg_no;
     		fnSearch();
        }
    }

    function resizeIfSheet(){
       ComResizeSheet(sheetObjects[3], 90);
   } 