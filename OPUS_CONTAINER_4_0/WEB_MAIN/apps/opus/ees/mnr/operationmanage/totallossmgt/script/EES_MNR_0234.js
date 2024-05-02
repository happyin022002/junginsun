/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0234.jsp
*@FileTitle  : Total Loss Detail Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0234 : EES_MNR_0234 - Defining a script used by screen
 */
function EES_MNR_0234() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* ********* General Functions ************* */
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Using for upload file
	var uploadObjects=new Array();
	var uploadCnt=0;
	var uploadFileSeq="";
	//History Seq Saving variable
	var historyMnrStsRefNo="";
	var sSaveRtnXml="";
	var nowLoad=0;
	var currTtlLssNo="";
	var currTtlLssDtlSeq="";
	//Corporate Headquarters Code
	var HOOfc="";
	var actionType="";
	var nowLoad=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Close":
						ComClosePopup(); 
						break;
					/** (Tab) 3rd Party (S) **/
					case "btn_t2InvoicePreview":
						if(sheetObjects[2].RowCount()>0)
						{
							var row=sheetObjects[2].GetSelectRow();
							var rdParam='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							rdParam +=   'inv_no[' + sheetObjects[2].GetCellValue(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
							rdParam +=   'payer_code[' + sheetObjects[2].GetCellValue(row,"payer_code") + '] ';
							rdParam +=   'curr_cd[' + sheetObjects[2].GetCellValue(row,"curr_cd") + '] ';
							rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
							rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
							formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";
							formObject.com_mrdArguments.value=rdParam;
							formObject.com_mrdBodyTitle.value="TotalLoss Invoice";
							ComOpenRDPopup();
						}
						break;
					/** (Tab) 3rd Party (E) **/
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	//Setting button
    	MnrWaitControl(true);
    	nowLoad=1;
		//Axon Initializing event
		initControl();
		//IBMultiCombo Initializing
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
    	// IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBTab Initializing
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
            tabObjects[k].SetSelectedIndex(0);
        }
		//Initializing of file upload: 
        // Common처리 필요 
		// ComConfigUpload(uploadObjects[0], "/opuscntr/MNR_INTGS.do");    	
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
  	/**  
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
			case 2:
	    	case 3:
	    	case 4:
	            with (comboObj) {
	    		SetColAlign(0, "left");
				   SetDropHeight(160);
		        }
	            break;
	     }
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
	            with (sheetObj) {
	                // Setting height
//				SetSheetHeight(0);
				var HeadTitle1="||||||||||||||";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ofc_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_dt" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_sts_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_rsn_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dt" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"apro_ofc_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_seq" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_cd" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_nm" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_dt" } ];
				 
				InitColumns(cols);
				SetVisible(0);
				SetEditable(0);
//				SetCountPosition()(0);
				}
	            break;
			case "sheet2":
                with (sheetObj) {
                    // Setting height
//				SetSheetHeight(0);
				var HeadTitle1="|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible\nOFC|D.V Exnpense|D.V Exnpense|D.V Exnpense|D.V Exnpense|3rd Party|3rd Party|Disposal|Disposal|Scrapping|Scrapping|Insurance|Insurance";
				var HeadTitle2="|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible\nOFC|EQ Q'ty|Expense|Recovery|Balance|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount + 6, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
				                { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:108,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:73,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dv_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_recovery",         KeyField:0,   CalcLogic:"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_balance",          KeyField:0,   CalcLogic:"|dv_exp|-|dv_recovery|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"tp_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"tp_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ds_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ds_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sc_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"sc_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ir_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ir_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_dtl_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 
				InitColumns(cols);
				SetVisible(0);
				SetEditable(0);
//				SetCountPosition()(0);

				}
                break;
            case "t1sheet1":
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle1="|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Payer Code|Payer Name|Invoice No.|CURR|Pay Amount|EQ Status|Close Type|Close Date|Remark";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	(headCount + 18, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
//            	             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inv_rgst_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"pay_inv_seq" },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mnr_swift_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(170);
            	SetEditable(0);
//            	SetCountPosition()(0);
            	SetSumText(0, "seq", "TOTAL");

				}
                break;
            case "t2sheet1":
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle1="|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Responsible\nOFC|Payer Code|Payer Name|CURR|3rd Amount|TPB No.|Bank Name|Bank Account|Swift Code|Remark";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	(headCount + 12, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"dpc_val_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Popup",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"mnr_swift_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(170);
            	SetEditable(0);
//            	SetCountPosition()(0);
            	SetColHidden("dpc_val_amt",1);
//            	SetShowButtonImage()(0);


				}
                break;
            case "t3sheet1":
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle1="|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	(headCount + 10, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
            	             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(170);
            	SetEditable(0);
//            	SetCountPosition()(0);


				}
                break;
            case "t4sheet1":
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle1="|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	(headCount + 8, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Float",     Hidden:0,  Width:160,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
            	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(170);
            	SetEditable(0);
//            	SetCountPosition()(0);


				}
                break;
            case "t5sheet1":
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle1="|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Remark";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	(headCount + 4, 0, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
            	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(170);
            	SetEditable(0);
//            	SetCountPosition()(0);
            	SetColHidden("dpc_val_amt",1);


				}
                break;
			case "sheet3":
                with (sheetObj) {
                    // Setting height
				
				var HeadTitle1="|Seq.|Type|Date|Curr.|Amount|Pay Method|CSR No.|Check No.|Inv No.|EQ No|Evidence No|Remark(s)";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount + 6, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:82,   Align:"Center",  ColMerge:1,   SaveName:"clt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"clt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inv_pay_mzd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"evidence",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_clt_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_clt_seq" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"clt_stl_flg" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"clt_ofc_cd" },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"chk_trns_no" } ];
				 
				InitColumns(cols);
				SetSheetHeight(170);
				SetEditable(0);
//				SetCountPosition()(0);
//				SetEditableColorDiff()(1);
//				SetShowButtonImage()(2);
//				SetSelectionMode()(smSelectionRow);


				}
                break;
			case "sheet4":
                with (sheetObj) {
                    // Setting height
				
				var HeadTitle1="|Seq|Date|Remark(s)|Creation Office|Creation User";
				var headCount=ComCountHeadTitle(HeadTitle1);
				(headCount+3, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mnr_sts_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_ref_no" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_dtl_seq" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_grp_tp_cd" } ];
				 
				InitColumns(cols);
				SetSheetHeight(130);
				SetEditable(0);
//				SetCountPosition()(0);
//				SetShowButtonImage()(2);


				}
                break;
			case "sheet5":
                with (sheetObj) {
					var prefix="";
					// Setting height
					
					var HeadTitle1="|Evidence Attached|Evidence Attached|Evidence Attached";
					var HeadTitle2="|Sel|File|Download";
					var headCount=ComCountHeadTitle(HeadTitle1);
					(8, 0, 0, true);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
					                { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
					             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
					             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					 
					InitColumns(cols);
					SetSheetHeight(130);
					SetEditable(0);
//					SetCountPosition()(0);
					SetImageList(0,"img/ico_attach.gif");
//					SetShowButtonImage()(1);
				}
                break;
        }
    }
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "D.V Expense", "");
					InsertItem( "3rd Party", "");
					InsertItem( "Disposal", "");
//					InsertItem( "Scrapping", "");
//					InsertItem( "Insurance", "");
                }
                break;
         }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	 //   axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }
	/**
	 * Initializing of IBUpload Object
	*/
	function initUpload(uploadObj, uploadNo) {
	   uploadObj.Files="";
	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
	 * Assigning array of IBUpload object
	 * Array defined at the top of the source
	*/
	function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++]=uploadObj;
	}
	
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "engup":
	         	if(obj.name == "in_ttl_lss_no"){
					ComKeyOnlyAlphabet('uppernum','45|44');
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change()
	{
		ComChkObjValid(event.srcElement);
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" )
		{
			switch(ComGetEvent("name"))
			{
			case "respb_ofc_cd":
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;
			case "ttl_lss_cfm_dt":
				if(nowLoad != 0) return;
//			    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
//			    sheetObjects[1].SetCellValue(Row,"ttl_lss_cfm_dt",formObj.ttl_lss_cfm_dt.value);
				break;
			}
		}
	}
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important logic --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
		var sheetObj=sheetObjects[nItem + 1];
		if((sheetObj.RowCount() - sheetObj.RowCount("D")) > 0){
			var Row=sheetObj.GetSelectRow();
			var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
			currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
			currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
			var newSeq=1;
			for(var x=1 ; x <= sheetObjects[6].RowCount();x++){
				with(sheetObjects[6]){
					if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
						var seq = String(newSeq);
						SetRowHidden(x,0);
						SetCellValue(x,"seq", seq ,0);
						newSeq = newSeq + 1;
					} else {
						SetRowHidden(x,1);
					}
				}
			}
		} else {
			for(var x=1 ; x <= sheetObjects[6].RowCount();x++){
				sheetObjects[6].SetRowHidden(x,1);
			}
			currTtlLssNo="";
			currTtlLssDtlSeq="";
		}
//		if(nItem==1)
//		{
//			ComBtnEnable("btn_t" + (nItem + 1) + "InvoicePreview");
//		}else{
//			ComBtnDisable("btn_t" + (nItem + 1) + "InvoicePreview");
//		}
    	if(document.form.ttl_lss_sts_cd.value=="HE") //In case of completed status
    	{
			ComBtnDisable("btn_Col_Add");
			ComBtnDisable("btn_Col_Delete");
    	}else{
    		if(nItem==0) //In case of Selected DV tab
    		{
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
    		}else{
    			ComBtnEnable("btn_Col_Add");
    			ComBtnEnable("btn_Col_Delete");
    		}
    	}
    }
	/**
	 * Event handling of OnSearchEnd of sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		//Setting value of header
	    var Row=sheetObj.FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
	    if(Row >0)
	    {
	    	sheetObj.SetSelectRow(Row);
	    }else{
	    	return false;
	    }
		var ttlLssNo=sheetObj.GetCellValue(Row, "ttl_lss_no");			//REQ OFC
		var rqstOfcCd=sheetObj.GetCellValue(Row, "rqst_ofc_cd");			//REQ OFC
		var respbOfcNm=sheetObj.GetCellValue(Row, "respb_ofc_nm");          //Responsible\nOFC NM
		var rqstDt=sheetObj.GetCellValue(Row, "rqst_dt"); 				//REQ DT
		var ttlLssStsCd=sheetObj.GetCellValue(Row, "ttl_lss_sts_cd");		//Status
		var ttlLssRsnCd=sheetObj.GetCellValue(Row, "ttl_lss_rsn_cd");		//Main Reason
		var ttlLssDtlRsnCd=sheetObj.GetCellValue(Row, "ttl_lss_dtl_rsn_cd");	//Sub Reason
		var ttlLssDt=sheetObj.GetCellValue(Row, "ttl_lss_dt");			//TLL DT
		var aproOfcCd=sheetObj.GetCellValue(Row, "apro_ofc_cd");			//APP OFC
		var fileSeq=sheetObj.GetCellValue(Row, "file_seq");				//File Seq
		var mnrStsRefNo=sheetObj.GetCellValue(Row, "mnr_sts_ref_no");		//mnr_sts_ref_no
		formObj.ttl_lss_no.value=ttlLssNo;			//TTL NO
		formObj.rqst_ofc_cd.value=rqstOfcCd;		//REQ OFC
		formObj.respb_ofc_nm.value=respbOfcNm;		//Responsible\nOFC NM
		formObj.rqst_dt.value=rqstDt; 			//REQ DT
		formObj.ttl_lss_sts_cd.value=ttlLssStsCd; 		//Status
		formObj.ttl_lss_rsn_cd.value=ttlLssRsnCd; 		//Main Reason
		formObj.ttl_lss_dtl_rsn_cd.value=ttlLssDtlRsnCd;	//Sub Reason
		formObj.ttl_lss_dt.value=ttlLssDt;			//TLL DT
		formObj.apro_ofc_cd.value=aproOfcCd;		//APP OFC
		formObj.mnr_sts_ref_no.value=mnrStsRefNo;   	//History key
		//Retrieving file list
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[8].LoadSearchData(fileXml,{Sync:1} );
			}
		}
		//Retrieving history list
		if(mnrStsRefNo != "" && mnrStsRefNo != null){
			historyMnrStsRefNo=mnrStsRefNo;
			var sXml=MnrStatusHistorySearch(sheetObjects[8], mnrStsRefNo);
			sheetObjects[7].LoadSearchData(sXml,{Sync:1} );
		}
	}
	/**
	 * Event handling of OnSearchEnd of sheet3
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount() > 0){
			document.form.tCollectionTotal.value=sheetObj.ComputeSum('|clt_amt|');
			ComAddSeparator(document.form.tCollectionTotal, "float");
		}else{
			document.form.tCollectionTotal.value= 0;
		}
		setCalculateTotalSum();
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
				//Combo data of sheet retrieving and setting
				setSheetCombo(sheetObj);
				formObj.reset();
				//Value setting of initialize
				//TLL No
				formObj.ttl_lss_no.value="";
//				document.form.t1LossTotal.value="";     //Loss Total
//				document.form.t1RecPlnTotal.value="";   //Recovery Plan Total
//				document.form.t1BalanceTotal.value="";  //Balance Total
				var toDay=ComGetNowInfo("ymd");
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";
				//Value setting of initialize
				uploadFileSeq="";
				historyMnrStsRefNo="";
//	        	if(HOOfc != currOfcCd)
//	        	{
//	        		sheetObjects[1].SetEditable(0);
//	        	}
	    		MnrWaitControl(false);
				ComBtnDisable("btn_t1InvoicePreview"); //D.V Expense tab Invoice Preview Btn disabled
				sheetObj.SetWaitImageVisible(1);
		    	doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);
	    		nowLoad=0;
	    		break;
        	//Retrieving
            case IBROWSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    	    		// Initializing all sheet
    	    		for (var i=2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    				formObj.f_cmd.value=SEARCH;
					//Retrieving multi data
 					var sXml=sheetObj.GetSearchData("EES_MNR_0234GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){
						if(i == 6){
							var tempStr=arrXml[i];
							tempStr=tempStr.replace(/<TR>/g,'<TR HIDDEN="TRUE">');
							arrXml[i]=tempStr;
						}
						if(i == 0){
							sheetObjects[0].LoadSearchData(arrXml[i],{Sync:1} );
						} else {
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
					}
					//Selecting first row of sheet
					tabObjects[0].SetSelectedIndex(0);
					if((sheetObj.RowCount - sheetObj.RowCount("D")) > 0){
						sheetObjects[1].SelectCell(1,2);
						var dtlSeq=sheetObjects[1].GetCellValue(1,"ttl_lss_dtl_seq");
						currTtlLssNo=sheetObjects[1].GetCellValue(1,"ttl_lss_no");
						currTtlLssDtlSeq=sheetObjects[1].GetCellValue(1,"ttl_lss_dtl_seq");
						var newSeq=1;
						for(var x=1 ; x <= sheetObjects[6].RowCount();x++){
							with(sheetObjects[6]){
								if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
									sheetObjects[6].SetCellValue(x,"seq",newSeq++,0);
									sheetObjects[6].SetRowHidden(x,0);
								} else {
									sheetObjects[6].SetRowHidden(x,1);
								}
							}
						}
					} else {
						for(var x=1 ; x <= sheetObjects[6].RowCount();x++){
							sheetObjects[6].SetRowHidden(x,1);
						}
						currTtlLssNo="";
						currTtlLssDtlSeq="";
					}
	            }
                break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        var formObj=document.form;
		with(formObj){
    		//Retrieving check
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
        }
        return true;
    }
	/**
	 * Loss Total : Pay amount sum of DV
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].GetSelectedIndex()+ 1;
       var sheetIndex=1;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount()>0)
			{
				calFlag=true;
				break;
			}
		}
		if(calFlag==true)
		{
		    var tLossTotal=0;
		    var thrdAmtTotal=0;
		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;
            for(var i=sheetIndex;i<sheetIndex + 5;i++)
            {
			    if(sheetObjects[i].RowCount()>0)
			    {
					for(var j=sheetObjects[i].HeaderRows();j<=sheetObjects[i].LastRow();j++)
					{
						if(sheetObjects[i].GetCellValue(j,"ibflag")!="D" && sheetObjects[i].GetCellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DV"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
								tLossTotal=getFloatSumData(tLossTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="TP"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
								thrdAmtTotal=getFloatSumData(thrdAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DS"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
								disposalAmtTotal=getFloatSumData(disposalAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
								disposalPlanAmtTotal=getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt"));
								} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="SC"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
								scrapIncomeAmtTotal=getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
								scrapCostAmtTotal=getFloatSumData(scrapCostAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="IR"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
								requestAmtTotal=getFloatSumData(requestAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								}
						}
					}
			    }
            }
            
//            var tempStr=ComAddComma2((tLossTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "LossTotal.value=tempStr;");
//			//Recovery Plan Total(tRecPlnTotal)
//		    var tRecPlnTotal=parseFloat(MnrMakeRound(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)),2));
//			tempStr=ComAddComma2((tRecPlnTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "RecPlnTotal.value=tempStr;");
//			//Balance Total(tBalanceTotal)
//		    var tBalanceTotal=getFloatSumData(tRecPlnTotal,tLossTotal);
//			tempStr=ComAddComma2((tBalanceTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "BalanceTotal.value=tempStr;");
			
			
//            if(String(tLossTotal).indexOf(".") != -1)
//            {
//            	var decimalLen=String(tLossTotal).length-String(tLossTotal).indexOf(".")+1;
//            	if(decimalLen>2)
//            	{
//            		tLossTotal=String(tLossTotal).substring(0,String(tLossTotal).indexOf(".")+3);
//            	}
//            }
//			document.form.t1LossTotal.value=tLossTotal;
//			ComAddSeparator(document.form.t1LossTotal, "float");
//		    var tRecPlnTotal=thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal;
//            if(String(tRecPlnTotal).indexOf(".") != -1)
//            {
//            	var decimalLen=String(tRecPlnTotal).length-String(tRecPlnTotal).indexOf(".")+1;
//            	if(decimalLen>2)
//            	{
//            		tRecPlnTotal=String(tRecPlnTotal).substring(0,String(tRecPlnTotal).indexOf(".")+3);
//            	}
//            }
//		    document.form.t1RecPlnTotal.value=tRecPlnTotal;
//			ComAddSeparator(document.form.t1RecPlnTotal, "float");
//		    var tBalanceTotal=tRecPlnTotal-tLossTotal;
//            if(String(tBalanceTotal).indexOf(".") != -1)
//            {
//            	var decimalLen=String(tBalanceTotal).length-String(tBalanceTotal).indexOf(".")+1;
//            	if(decimalLen>2)
//            	{
//            		tBalanceTotal=String(tBalanceTotal).substring(0,String(tBalanceTotal).indexOf(".")+3);
//            	}
//            }
//			document.form.t1BalanceTotal.value=tBalanceTotal;
//			ComAddSeparator(document.form.t1BalanceTotal, "float");
		}
	}
	/**
	 * Setting and initializing of sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheetCombo(sheetObj) {
		var formObj=document.form;
		//Retrieving sheet
		var sCondition=new Array (
			new Array("MdmCurrency","", "COMMON")		//Currency
			,new Array("MnrGenCd","CD00071", "COMMON")  //The previous state CD00042
			,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00050", "COMMON")  //Total Collection Type
			,new Array("ComIntgCd","CD00809","COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00039", "COMMON")  //Total Loss Status
			,new Array("MnrGenCd","TR", "COMMON")  //Main Reason
			,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
			,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
			,new Array("MnrGenCd","HOOFC", "COMMON")    //HOOfc Code
			,new Array("MnrGenCd","SELHO","CUSTOM9")	//Eq Kind
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		//Setting sheet
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i < comboList.length; i++) {
			//Initializing each combo of sheets
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault="";
			for(var j=0; j < comboList[i].length; j++){
				var tempText=comboList[i][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(i==9)
				{
					HOOfc=tempText[0];
				}
				if(j == 0){
					sheetComboDefault=tempText[0];
				}
			}
			//Setting combo of sheet of tab
			for(var k=1; k < 8; k++)
			{
				if(i == 0) {
					sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
				} else if(i == 1) {
					if(k == 1) {
					    sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 2) {
					if(k == 2) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 3) {
					if(k == 6) {
						//sheetObjects[k].InitDataCombo (0, "ttl_lss_clt_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 4) {
					if(k == 6) {
						sheetObjects[k].InitDataCombo (0, "inv_pay_mzd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}  else if(i == 7) {
					if(k == 5) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 8) {
					if(k == 1) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_cmpl_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 10){
					if(k != 6 ) {
						sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
			}
		}
	}
	/**
     * Event handling of click of sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected row
     * @param {ibsheet} Col     	Selected column
     * @param {String} 	Value     	File name
     **/
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	
	function getFloatSumData(a,b){
		var aFloat=parseFloat(a + "");
		var bFloat=parseFloat(b + "");
		var sumResult=MnrMakeRound(parseFloat(aFloat + bFloat),2);
		return  parseFloat(sumResult + "");
	}
	
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount() > 0){
			sheetObj.SetSumText(0, "eq_knd_cd", "TOTAL");
		}
	}
	
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount() > 0){
			sheetObj.SetSumText(0, "eq_knd_cd", "TOTAL");
		}
	}
	
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount() > 0){
			sheetObj.SetSumText(0, "eq_knd_cd", "TOTAL");
		}
	}
