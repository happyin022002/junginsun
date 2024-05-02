/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0161.js
*@FileTitle  : Disposal Invoice Issue & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0161 : business script for EES_MNR_0161.
     */

// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var initLoader=0;
//save=1, delete=2, confirm=3, Web Invoice Reject=4
var saveType="";
var invInfoClearYN="";
var invNo=""
var PrefixSheet2="sheet2_";
var saveRet="";
var saveEndYN="";
var currPrcsKnt="0";
var invDtCheckFlg=true;
var strMnrOfficeLevel="";	// Office level of login user : HO level -> L1, RHQ level -> L2, Office level -> L3 (MnrOfficeLevel reference at CoMnr.js)
// Event handler processing by button click event */
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
				case "btn_New_All":
					doActionIBSheet(sheetObjects[2],document.form,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[3],document.form,IBSAVE);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[3],document.form,IBDELETE);
					break;
				case "btn_Confirm":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC01);
					break;
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC04);
					break;
				case "btn_Preview":
					var rdParam='/rv inv_no[' + formObject.input_inv_no.value + '] user_nm[' + self_usr_nm + ']';
					formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0185.mrd";
					formObject.com_mrdArguments.value=rdParam;
					formObject.com_mrdBodyTitle.value="Disposal Invoice";
					var sFeatures="resizable=yes,width=800,height=600"
					ComOpenRDPopup(sFeatures);
					break;
				case "btn_Retrieve":
					var idx=combo_kind.GetSelectIndex();
					doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
					break;
				case "btn_New":
					setInvoiceListClear();
					break;
                case "btn_t1_DetailRetrieve":
					tabObjects[0].SetSelectedIndex(0);
					doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC02);
					break;
                case "btn_t2_DetailRetrieve":
					tabObjects[0].SetSelectedIndex(1);
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
					break;
                case "btn_Store":
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC05);
					break;
                case "btn_Del":
					if(beforetab=="0"){
						MnrRowDelete(sheet1, "Check");
					}else{
						MnrRowDelete(sheet2, PrefixSheet2+"Check");
					}
	                break;
				case "btn_DownExcel":
					if(beforetab=="0"){
						if(sheetObjects[2].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1 });
							}
					}else{
						if(sheetObjects[3].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[3].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[3]), SheetDesign:1,Merge:1 });
							}
					}
					break;
				case "btn_inv_dt":
					var cal=new ComCalendar();
					cal.setEndFunction("chg_cal_inv_dt_OnChange");
					cal.select(form.inv_dt, 'yyyy-MM-dd');
					break;
				case "btn_due_dt":
					var cal=new ComCalendar();
 					cal.select(form.inv_due_dt, 'yyyy-MM-dd');
					break;
				case "btn_t1_calendar":
					var cal=new ComCalendarFromTo();
 					cal.select(form.t1_from_dt,  form.t1_to_dt,  'yyyy-MM-dd');
					break;
				case "btn_t2_calendar":
					var cal=new ComCalendarFromTo();
 					cal.select(form.t2_from_dt,  form.t2_to_dt,  'yyyy-MM-dd');
					break;
		        case "btn_t1_req_multy":
                    rep_Multiful_inquiry("t1_mnr_ord_seq");
					break;
		        case "btn_t2_req_multy":
                    rep_Multiful_inquiry("t2_mnr_ord_seq");
					break;
				case "btn_t1_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_t2_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		initControl()
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	/**
     * setting Tab
     * 
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
//no support[check again]CLT 					BaseColor="255,255,255";
					InsertItem( "Invoice Detail List" , "");
					InsertItem( "Verified List" , "");
                }
                break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
     * setting IBCombo basic
     * @param	{IBCombo}	comboObj	initial setting comboObject
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
  		var cnt=0 ;
  	    var formObject=document.form
  	    switch(comboNo) {
  	    	case 1:
  	            with (comboObj) {
  	    		SetColAlign(0, "left");
  			        //SetColWidth("75")
					SetUseAutoComplete(1);
  		        }
  	            break;
  	    	case 2:
  	            with (comboObj) {
  	    		SetColAlign(0, "left");
  		        }
  	            break;
  	    	case 3:
  	            with (comboObj) {
  	    		SetColAlign(0, "left");
  		        }
  	            break;
  	    	case 4:
  	            with (comboObj) {
					SetMultiSeparator("|");
					SetTitle("Code|Name");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "70");
					SetColWidth(1, "160");
  		        }
  	            break;
  	     }
  	}
  /**
     * setting sheet initial values and header 
     * param : sheetObj ==> sheetObject, sheetNo ==> sheetObject tag serial number
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
             case "t1sheet1":
                with (sheetObj) {
	                 var HeadTitle="|Sel|Seq.|Buyer Name|Buyer Type|Disposal No.|App Date|Q'ty|Currency|Amount"
	                 var headCount=ComCountHeadTitle(HeadTitle);
	                 (headCount + 13, 0, 0, true);
	
	                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_knd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"apro_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"part_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_bil_to_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"buyer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chg_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 	InitColumns(cols);
	
	                 	SetEditable(1);
	                    SetSelectionMode(smSelectionCol);
	                    SetCountPosition(0);
	                    SetSheetHeight(182);
				}
				break;
             case "t2sheet1":
                with (sheetObj) {
	                 var HeadTitle="|Sel|Seq.|Buyer Name|Buyer Type|Invoic No.|Inv Amt|V.A.T|W.H.T|G.Amount|G.AMT(VAT Only)|Status"
	                 var headCount=ComCountHeadTitle(HeadTitle);
	                 (headCount + 19, 0, 0, true);
	
	                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);

	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_prnr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_knd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vat",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"wht",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"g_vat_curr_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_bil_to_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"buyer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rcv_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chg_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vat_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chg_xch_rt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vat_dp_prcs_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 	InitColumns(cols);

                 	SetEditable(1);
                 	SetEditableColorDiff(0);
                 	SetCountPosition(0);
                    SetSelectionMode(smSelectionCol);
                    SetSheetHeight(182);
				}
				break;
			case "sheet1":
                with (sheetObj) {
	                var HeadTitle1="|Sel|seq.|Buyer|Disposal No.|Release No|EQ No.|Qty|TP/SZ|Cur|Amount|Sold Yard|Sold Date|Remark(s)|System Verify Result";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                (headCount + 8, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Check",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"disp_rlse_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"disp_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",              KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"disp_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"disp_sold_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"mnr_disp_dtl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"rcv_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_ofc_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"disp_dtl_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_wo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		                 ];
	                 
	                InitColumns(cols);
	                SetCountPosition(0);
	                SetEditable(1);
	                SetSheetHeight(182);
				}
				break;
			case "sheet2":
                 with (sheetObj) {
	                var HeadTitle1="|Sel|seq.|Buyer|Disposal No.|Release No.|EQ No.|Qty|TP/SZ|Cur|Amount|Sold Yard|Sold Date|Remark(s)|System Verify Result";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                (headCount + 8, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"ibflag" },
						{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"Check",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"Seq" },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_prnr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"disp_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"disp_rlse_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"disp_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"inv_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"disp_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"disp_sold_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_disp_dtl_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_vrfy_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rcv_inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_ord_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_ord_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"disp_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_wo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rpr_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rpr_rqst_ver_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(182);
				}
				break;
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
    /**
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
   /**
    * handling SearchEnd event on t2sheet1.
    * @param sheetObj
    * @return
    */
    function t2sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
			//retrieving after saving
			if(saveType!="" && saveEndYN=="Y"){
				sheetObjects[1].SetCellValue(1,"sel","1",0);
				tabObjects[0].SetSelectedIndex(1);
				saveRet="Y";
				doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
			}
			saveEndYN=="";
		
		}
    }
   /**
    * handling SearchEnd event on sheet1.
    * @param sheetObj
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
	    	for(i=sheetObj.LastRow()- 1; i > 0 ; i--){
	    		if(sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd")!="SS"){
					sheetObj.SetCellEditable(i, "Check",0);
					sheetObj.SetRowBackColor(i,"#F7E5E1");
				}
			}
	    	sheetObj.SetSumValue("Seq", "TOTAL");
		}
    }
   /**
    * handling SearchEnd event on sheet2.
    * @param sheetObj
    * @return
    */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
	    	for(i=sheetObj.LastRow()- 1; i > 0 ; i--){
	    		if(sheetObj.GetCellValue(i,  PrefixSheet2+"mnr_vrfy_tp_cd")!="SS"){
					sheetObj.SetCellEditable(i, PrefixSheet2+"Check",0);
					sheetObj.SetRowBackColor(i,"#F7E5E1");
				}
			}
	    	sheetObj.SetSumValue("Seq", PrefixSheet2+"TOTAL");
		}
    }
	/**
    * handling Change event on sheet2.
    * @param sheetObj
    * @return
    */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col)  == PrefixSheet2 + "inv_amt"){
			formObj.amt.value=sheetObj.GetSumValue(0,"sheet2_inv_amt");
			chkCurrXchRt();
		}
	}
	/**
	 * for Calendar INV DT
	 */
	function chg_cal_inv_dt_OnChange(){
		var formObj=document.form;
		if(formObj.inv_dt.value != ""){
			var retVal="";
			retVal=MnrGetCurrXchRt2(sheetObjects[0],formObj.inv_dt.value.replace(/-/g,"").substr(0,6),formObj.curr_cd.value,chg_curr_cd.GetSelectCode(),"1");
			retVal=retVal.split(",");
			formObj.conv_dp_prcs_knt.value=retVal[1];
			formObj.chg_xch_rt.value=retVal[0];
			//changing dp_prcs from retrieving exchange rate
			if(formObj.conv_dp_prcs_knt.value == "0"){
				formObj.vat.dataformat="int";
				formObj.g_vat_curr_amt.dataformat="int";
				formObj.vat.maxLength=15;
				formObj.g_vat_curr_amt.maxLength=15;
			} else {
				formObj.vat.dataformat="float";
				formObj.g_vat_curr_amt.dataformat="float";
				formObj.vat.maxLength=18;
				formObj.g_vat_curr_amt.maxLength=18;
			}
			if(chg_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
			    //setting defalt of retrieving value
				MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
			} else {
				//setting EX.rate = 1
				formObj.chg_xch_rt.value="1";
				MnrFormSetReadOnly(formObj,true,"chg_xch_rt");
				//setting amount = ""
				formObj.g_vat_curr_amt.value="";
			}
			chkCurrXchRt();
		}
	}
   /**
    * loading message after saving
    * @param sheetObj
    * @param ErrMsg
    * @return
    */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if(saveType=="1"){
				ComShowCodeMessage("MNR00085");
			}else if(saveType=="2"){
				ComShowCodeMessage("MNR00090","Invoice ");
				doActionIBSheet(sheetObjects[3],document.form,IBCLEAR);
			}else if(saveType=="3"){
				ComShowCodeMessage("MNR00086");
				ComBtnDisable('btn_Save');
				ComBtnDisable('btn_Delete');
				ComBtnEnable('btn_Confirm');
				MnrBtnRename("btn_Confirm","btn_Cancel","Cancel");
			}else if(saveType=="4"){
				ComShowCodeMessage("MNR00094");
			}else if(saveType=="5"){ //calcel
				ComShowCodeMessage("MNR00300");
				ComBtnDisable('btn_Save');
				ComBtnDisable('btn_Delete');
				ComBtnDisable('btn_Confirm');
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
			}
			saveEndYN="Y";
			combo_kind.SetSelectCode("CO");
			var idx=combo_kind.GetSelectIndex();
			doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
		} else {
//	  		ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	 /**
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="";
    	objs[beforetab].style.display="none";
    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	/**
	 * combo_kind Change event
	 * @param {IBMultiCombo}  comboObj ComboObject
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */
    //[2:56:25 PM] Tuấn Lực Dương: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	function combo_kind_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var kind=comboObj.GetSelectIndex();
		changeKind(kind);
		if(kind=="0" || kind=="1"){
			ComBtnEnable('btn_Store');
		}else{
			ComBtnDisable('btn_Store');
		}
	}
	/**
	 * chg_curr_cd Change event
	 * @param {IBMultiCombo}  comboObj ComboObject
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */
	function chg_curr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		if(invDtCheckFlg){
			if(formObj.inv_dt.value==""){
				ComShowCodeMessage("MNR00172","Invoice DT ");
				comboObj.code2="";
				ComSetFocus(formObj.inv_dt);
				return false;
			}
			if(formObj.inv_dt.value.replace(/-/g,"") > ComGetNowInfo().replace(/-/g,"")){
				ComShowCodeMessage("MNR00235");
				formObj.inv_dt.value="";
				return false;
			}
		}
		var retVal="";
		retVal=MnrGetCurrXchRt2(sheetObjects[0],formObj.inv_dt.value.replace(/-/g,"").substr(0,6),formObj.curr_cd.value,chg_curr_cd.GetSelectCode(),"1");
		retVal=retVal.split(",");
		formObj.conv_dp_prcs_knt.value=retVal[1];
		formObj.chg_xch_rt.value=retVal[0];
		//changing dp_prcs from retrieving exchange rate
		if(formObj.conv_dp_prcs_knt.value == "0"){
			formObj.vat.dataformat="int";
			formObj.g_vat_curr_amt.dataformat="int";
			formObj.vat.maxLength=15;
			formObj.g_vat_curr_amt.maxLength=15;
		} else {
			formObj.vat.dataformat="float";
			formObj.g_vat_curr_amt.dataformat="float";
			formObj.vat.maxLength=18;
			formObj.g_vat_curr_amt.maxLength=18;
		}
		if(chg_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
		    //setting defalt of retrieving value
			MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
		} else {
			//setting EX.rate = 1
			formObj.chg_xch_rt.value="1";
			MnrFormSetReadOnly(formObj,true,"chg_xch_rt");
			//setting amount = ""
			formObj.g_vat_curr_amt.value="";
		}
		if(comboObj.GetSelectCode()== "KRW"){
			formObj.vat_xch_rt.value="0.1";
		} else {
			formObj.vat_xch_rt.value="0";
		}
		chkCurrXchRt();
	}
  	/**
     * handling sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //retrieving
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					setInvoiceListValue();
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("EES_MNR_0161GS.do",FormQueryString(formObj) );
				}
                break;
	 		case IBSEARCH_ASYNC02:  //Disposal Detail Retrieve
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					setInvoiceInfomationClear();
					setInvoiceListValue();
					formObj.f_cmd.value=SEARCH01;
					var sParam=ComGetSaveString(sheetObjects[0]);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);
					if(invInfoClearYN!="N"){
						var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
						for(var i=1; i <= sheetObjects[0].RowCount(); i++){
							if(sheetObjects[0].GetCellValue(i,"sel") == 1){
								currPrcsKnt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"dp_prcs_knt");
								if(currPrcsKnt=="0"){
									var info = {format:"Int"};
//									var info = {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",              KeyField:1,   CalcLogic:"",   Format:"Int",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 };
//									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 				true,         	"",      dfInteger, 	0,     true,       true, 17);
//									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 	true,         	"",      dfInteger, 	0,     true,       true, 17);
									
									sheetObjects[2].InitCellProperty(0, "inv_amt", info);
									sheetObjects[3].InitCellProperty(0, PrefixSheet2+"inv_amt", info);
								}else{
									var info = {format:"Float"};
//									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 				true,         	"",      dfFloat, 	2,     true,       true, 17);
//									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 	true,         	"",      dfFloat, 	2,     true,       true, 17);
									
									sheetObjects[2].InitCellProperty(0, "inv_amt", info);
									sheetObjects[3].InitCellProperty(0, PrefixSheet2+"inv_amt", info);
								}
								ComSetObjValue(formObj.iss_ofc_cd, currOfcCd);
								ComSetObjValue(formObj.curr_cd, sheetObjects[0].GetCellValue(i,"curr_cd"));
								ComSetObjValue(formObj.bank_nm, sheetObjects[0].GetCellValue(i,"bank_nm"));
								ComSetObjValue(formObj.bank_acct_no, sheetObjects[0].GetCellValue(i,"bank_acct_no"));
								ComSetObjValue(formObj.mnr_bil_to_nm, sheetObjects[0].GetCellValue(i,"mnr_bil_to_nm"));
								ComSetObjValue(formObj.buyer_cd, sheetObjects[0].GetCellValue(i,"buyer_cd"));
								ComSetObjValue(formObj.buyer_nm, sheetObjects[0].GetCellValue(i,"mnr_prnr_lgl_eng_nm"));
								ComSetObjValue(formObj.buyer_type, sheetObjects[0].GetCellValue(i,"mnr_prnr_knd_nm"));
								ComSetObjValue(formObj.mnr_prnr_tp_cd, sheetObjects[0].GetCellValue(i,"mnr_prnr_tp_cd"));
								if(currPrcsKnt=="0"){
									formObj.amt.dataformat="int";
									formObj.wht.dataformat="int";
									formObj.g_amt.dataformat="int";
									formObj.amt.maxLength=15;
									formObj.wht.maxLength=15;
									formObj.g_amt.maxLength=15;
								}else{
									formObj.amt.dataformat="float";
									formObj.wht.dataformat="float";
									formObj.g_amt.dataformat="float";
									formObj.amt.maxLength=18;
									formObj.wht.maxLength=18;
									formObj.g_amt.maxLength=18;
								}
								break;
							}
						}
						sheetObj.LoadSearchData(sXml,{Sync:0} );
					}
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						ComBtnDisable('btn_Confirm');
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						if(strMnrOfficeLevel=="L3"){
							ComBtnEnable('btn_Confirm');
						}else{
							ComBtnDisable('btn_Confirm');
						}
					}
				}
                break;
	 		case IBSEARCH_ASYNC03:  //Invoice Detail Retrieve
          	    // handling after Save
         		if(saveRet=="Y") {
					invInfoClearYN="Y"
					setInvoiceInfomationClear();
				}else{
					if(formObj.rcv_inv_seq.value != ""){
						if(ComShowCodeConfirm("MNR00230")){
							invInfoClearYN="Y"
							setInvoiceInfomationClear();
						}else{
							invInfoClearYN="N"
						}
					}
				}
				saveRet=="N";
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[2].RemoveAll();
					if(invInfoClearYN!="N"){
						sheetObjects[3].RemoveAll();
					}
					setInvoiceListValue();
					formObj.f_cmd.value=SEARCH01;
					var sParam=ComGetSaveString(sheetObjects[1]);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
					if(invInfoClearYN!="N"){
						for(var i=1; i <= sheetObjects[1].RowCount(); i++){
							if(sheetObjects[1].GetCellValue(i,"sel") == 1){
								combo_status.SetSelectCode(sheetObjects[1].GetCellValue(i,"mnr_inv_sts_cd"));
								ComSetObjValue(formObj.curr_cd, sheetObjects[1].GetCellValue(i,"curr_cd"));
								ComSetObjValue(formObj.bank_nm, sheetObjects[1].GetCellValue(i,"bank_nm"));
								ComSetObjValue(formObj.bank_acct_no, sheetObjects[1].GetCellValue(i,"bank_acct_no"));
								ComSetObjValue(formObj.mnr_bil_to_nm, sheetObjects[1].GetCellValue(i,"mnr_bil_to_nm"));
								ComSetObjValue(formObj.buyer_cd, sheetObjects[1].GetCellValue(i,"buyer_cd"));
								ComSetObjValue(formObj.buyer_nm, sheetObjects[1].GetCellValue(i,"mnr_prnr_lgl_eng_nm"));
								ComSetObjValue(formObj.buyer_type, sheetObjects[1].GetCellValue(i,"mnr_prnr_knd_nm"));
								ComSetObjValue(formObj.mnr_prnr_tp_cd, sheetObjects[1].GetCellValue(i,"mnr_prnr_tp_cd"));
								ComSetObjValue(formObj.input_inv_no, sheetObjects[1].GetCellValue(i,"inv_no"));
								ComSetObjValue(formObj.inv_dt, sheetObjects[1].GetCellValue(i,"inv_dt"));
								ComSetObjValue(formObj.inv_due_dt, sheetObjects[1].GetCellValue(i,"inv_due_dt"));
								ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[1].GetCellValue(i,"mnr_inv_rmk"));
								ComSetObjValue(formObj.vat_xch_rt, MnrAddComma(sheetObjects[1].GetCellValue(i,"vat_xch_rt"), "#,###.000"));
								ComSetObjValue(formObj.iss_ofc_cd, sheetObjects[1].GetCellValue(i,"iss_ofc_cd"));
								ComSetObjValue(formObj.rcv_inv_seq, sheetObjects[1].GetCellValue(i,"rcv_inv_seq"));
								ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[1].GetCellValue(i,"mnr_inv_sts_cd"));
								ComSetObjValue(formObj.ref_no, sheetObjects[1].GetCellValue(i,"mnr_inv_ref_no"));
								currPrcsKnt=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"dp_prcs_knt");
								if(currPrcsKnt=="0"){
//									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 			true,         	"",      dfInteger, 	0,     true,       true, 17);
//									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 			true,         	"",      dfInteger, 	0,     true,       true, 17);
									sheetObjects[2].InitCellProperty(0, "inv_amt", info);
									sheetObjects[3].InitCellProperty(0, PrefixSheet2+"inv_amt", info);
									
									formObj.amt.dataformat="int";
									formObj.wht.dataformat="int";
									formObj.g_amt.dataformat="int";
									formObj.amt.maxLength=15;
									formObj.wht.maxLength=15;
									formObj.g_amt.maxLength=15;
									ComSetObjValue(formObj.amt, ComAddComma2(sheetObjects[1].GetCellValue(i,"inv_amt").toString(), "#,###"));
									ComSetObjValue(formObj.wht, ComAddComma2(sheetObjects[1].GetCellValue(i,"wht").toString(), "#,###"));
									ComSetObjValue(formObj.g_amt, ComAddComma2(sheetObjects[1].GetCellValue(i,"ttl_amt").toString(), "#,###"));
								} else {
//									sheetObjects[2].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     "inv_amt", 			true,         	"",      dfFloat, 	2,     true,       true, 17);
//									sheetObjects[3].InitDataProperty(0, 11 , dtAutoSumEx,  	60,		daRight,   	true,     PrefixSheet2+"inv_amt", 			true,         	"",      dfFloat, 	2,     true,       true, 17);
									sheetObjects[2].InitCellProperty(0, "inv_amt", info);
									sheetObjects[3].InitCellProperty(0, PrefixSheet2+"inv_amt", info);
									
									formObj.amt.dataformat="float";
									formObj.wht.dataformat="float";
									formObj.g_amt.dataformat="float";
									formObj.amt.maxLength=18;
									formObj.wht.maxLength=18;
									formObj.g_amt.maxLength=18;
									var temp = ComAddComma2(sheetObjects[1].GetCellValue(i,"inv_amt").toString(), "#,###.00");
									ComSetObjValue(formObj.amt, temp);
									ComSetObjValue(formObj.wht, ComAddComma2(sheetObjects[1].GetCellValue(i,"wht").toString(), "#,###.00"));
									ComSetObjValue(formObj.g_amt, ComAddComma2(MnrMakeRound(sheetObjects[1].GetCellValue(i,"ttl_amt").toString(),2), "#,###.00"));
								}
								var vatCurrPrcsKnt=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"vat_dp_prcs_knt");
								formObj.conv_dp_prcs_knt.value=vatCurrPrcsKnt;
								if(vatCurrPrcsKnt=="0"){
									formObj.vat.dataformat="int";
									formObj.vat.maxLength=15;
									ComSetObjValue(formObj.vat, ComAddComma2(sheetObjects[1].GetCellValue(i,"vat").toString(), "#,###"));
									formObj.g_vat_curr_amt.dataformat="int";
									formObj.g_vat_curr_amt.maxLength=15;
									if(sheetObjects[1].GetCellValue(i,"g_vat_curr_amt") != ""){
										ComSetObjValue(formObj.g_vat_curr_amt, ComAddComma2(sheetObjects[1].GetCellValue(i,"g_vat_curr_amt").toString(), "#,###"));
									}
								} else {
									formObj.vat.dataformat="float";
									formObj.vat.maxLength=18;
									ComSetObjValue(formObj.vat, MnrAddComma(sheetObjects[1].GetCellValue(i,"vat").toString(), "#,###.000"));
									formObj.g_vat_curr_amt.dataformat="float";
									formObj.g_vat_curr_amt.maxLength=18;
									if(sheetObjects[1].GetCellValue(i,"g_vat_curr_amt") != ""){
										ComSetObjValue(formObj.g_vat_curr_amt, MnrAddComma(sheetObjects[1].GetCellValue(i,"g_vat_curr_amt").toString(), "#,###.000"));
									}
								}
								//setting VAT CURR reference
								chg_curr_cd.SetSelectCode(sheetObjects[1].GetCellValue(i,"chg_curr_cd"),false);
								ComSetObjValue(formObj.chg_xch_rt, ComAddComma2(sheetObjects[1].GetCellValue(i,"chg_xch_rt").toString(), "#,###.00"));
								if(chg_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
									MnrFormSetReadOnly(formObj,false,"chg_xch_rt");
								} else {
									MnrFormSetReadOnly(formObj,true,"chg_xch_rt");
								}
								break;
							}
						}
						var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
						sheetObj.LoadSearchData(sXml,{Sync:0} );
					}
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						ComBtnEnable('btn_Confirm');
						MnrBtnRename("btn_Confirm","btn_Cancel","Cancel");
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
						if(strMnrOfficeLevel=="L3" || strMnrOfficeLevel=="L1"){
							ComBtnEnable('btn_Confirm');
						}else{
							ComBtnDisable('btn_Confirm');
						}
					}
				}
                break;
			case IBSEARCH_ASYNC05:      //Store
	          	if(validateForm(sheetObj,formObj,sAction)){
					tabObjects[0].SetSelectedIndex(1);
					ComSheet2SheetCheck(sheetObjects[2], sheetObjects[3], "Check");
					sheetObjects[3].ColumnSort(PrefixSheet2+"Seq", "ASC");
					formObj.amt.value=sheetObjects[3].GetSumValue(0,"sheet2_inv_amt");
					invDtCheckFlg=false;
					chg_curr_cd.SetSelectCode(sheetObjects[0].GetCellValue(1,"chg_curr_cd"));
					invDtCheckFlg=true;
					chkCurrXchRt();
				}
				break;
	 		case IBSAVE:        // Save
	          	if(validateForm(sheetObj,formObj,sAction)){
					saveType="1";
					formObj.mnr_inv_sts_cd.value="HS";
					formObj.mnr_grp_tp_cd.value="DSP";
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));
							combo_status.SetSelectCode(formObj.mnr_inv_sts_cd.value);
						}
					}
					sheetObj.LoadSaveData(sXml);
				}
                break;
	 		case IBSEARCH_ASYNC01:        //Confirm
	          	if(validateForm(sheetObj,formObj,sAction)){
					//checking whether Confirm
					if(!ComShowCodeConfirm("MNR00197")){return false;}
					saveType="3";
					formObj.mnr_inv_sts_cd.value="HC"; //Confirm,Cancel
					formObj.mnr_grp_tp_cd.value="DSP";
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj)+"&"+ ComGetPrefixParam(PrefixSheet2);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));
							combo_status.SetSelectCode(formObj.mnr_inv_sts_cd.value);
						}
					}
					sheetObj.LoadSaveData(sXml);
				}
                break;
	 		case IBSEARCH_ASYNC04:        //Cancel
	          	if(validateForm(sheetObj,formObj,sAction)){
					//checking whether Confirm
					if(!ComShowCodeConfirm("MNR00299")){return false;}
					saveType="5";
					formObj.mnr_inv_sts_cd.value="HC";  //Confirm,Cancel
					formObj.cancel_yn.value="Y";
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj)+"&"+ ComGetPrefixParam(PrefixSheet2);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
						if(State == "S"){
							ComSetObjValue(formObj.rcv_inv_seq, ComGetEtcData(sXml, "rcv_inv_seq"));
							ComSetObjValue(formObj.input_inv_no, ComGetEtcData(sXml, "input_inv_no"));
							combo_status.SetSelectCode("HS");
						}
					}
					sheetObj.LoadSaveData(sXml);
				}
                break;
	 		case IBDELETE:        //deleting
	          	if(validateForm(sheetObj,formObj,sAction)){
					//checking whether deleting
					if(!ComShowCodeConfirm("MNR00088")){return false;}
					saveType="2";
					formObj.f_cmd.value=REMOVE;
					var sParam=ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0161GS.do", sParam);
			    	sheetObj.LoadSaveData(sXml);
				}
                break;
			case IBCLEAR:      // initializing
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
					//setting on strMnrOfficeLevel and retrieving Office Level
					MnrOfficeLevel(currOfcCd,rhqOfcCd);
					//retrieving common combo.
					var sCondition=new Array (
						new Array("MnrGenCd","CD00046", "COMMON"),	//Disposal Invoice Search Type
						new Array("MnrGenCd","CD00027", "COMMON"),	//Repair Invoice Status Code
						new Array("MnrGenCd","CD00004", "COMMON"),	//System Verification Result Code
						new Array("MdmCurrency","","COMMON"),
						new Array("MnrGenCd","CD00034", "COMMON")
					);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//setting combo(Eq Kind,Agreement Office)
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//initializing sheet combo
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Disposal Invoice Search Type
								if(i==0) {
									combo_kind.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 1){
										combo_kind.SetSelectCode(tempText[0]);
									}
								//Repair Invoice Status Code
								} else if(i==1){
									combo_status.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){
										combo_status.InsertItem(0, "NEW" ,"NEW");
										combo_status.SetSelectCode("NEW");
										combo_status.SetEnable(0);
									}
								}else if(i==3){
									chg_curr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}else if(i==4){
									combo_buyer_type.InsertItem(j, tempText[1] ,tempText[0]);
								}
							}
							//System Verification Result Code
							if(i==2) {
								sheetObjects[2].SetColProperty(0,"mnr_vrfy_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
								sheetObjects[3].SetColProperty(0,PrefixSheet2+"mnr_vrfy_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}
						}
					}
				}
				initLoader=1;
				setInvoiceListClear();
				setInvoiceInfomationClear();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
				ComBtnDisable('btn_Confirm');
				if(strMnrOfficeLevel=="L1"){
//					combo_buyer_type.SetSelectCode("G",false);
					combo_buyer_type.SetSelectCode("L",false);
					combo_buyer_type.SetEnable(0);
					ComBtnEnable('btn_Confirm');
				}else if(strMnrOfficeLevel=="L2"){
//					combo_buyer_type.DeleteItem(combo_buyer_type.FindItem("Global Partner", 0, true));
//					combo_buyer_type.SetSelectCode("R",false);
					combo_buyer_type.SetSelectCode("L",false);
					combo_buyer_type.SetEnable(0);
				}else{
					combo_buyer_type.SetSelectCode("L",false);
					combo_buyer_type.SetEnable(0);
					ComBtnEnable('btn_Confirm');
				}
				
				break;
        }
    }
    /**
     * handling process for sheet
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(sAction==IBSEARCH) { //Retrive
		    //cboCode=combo_kind.GetSelectCode();
		}else if(sAction==IBSEARCH_ASYNC02) { //Disposal Detail Retrieve
			var buyerCd="";
			var selChk="";
			var currCd="";
			for(var i=1; i <= sheetObjects[0].RowCount(); i++){
				if(sheetObjects[0].GetCellValue(i,"sel") == 1){
					selChk="Y";
					buyerCd=sheetObjects[0].GetCellValue(i,"buyer_cd");
					currCd=sheetObjects[0].GetCellValue(i,"curr_cd");
					break;
				}
			}
			if(selChk==""){
				ComShowCodeMessage("MNR00038");
				return false;
			}
			for(var i=1; i <= sheetObjects[0].RowCount(); i++){
				if(sheetObjects[0].GetCellValue(i,"sel") == 1){
					if(buyerCd!=sheetObjects[0].GetCellValue(i,"buyer_cd")){
						ComShowCodeMessage("MNR00098",buyerCd,sheetObjects[0].GetCellValue(i,"buyer_cd"));
						return false;
					}
					if(formObj.buyer_cd.value!="" && formObj.buyer_cd.value!=sheetObjects[0].GetCellValue(i,"buyer_cd")){
						ComShowCodeMessage("MNR00098",formObj.buyer_cd.value,sheetObjects[0].GetCellValue(i,"buyer_cd"));
						return false;
					}
					if(currCd!=sheetObjects[0].GetCellValue(i,"curr_cd")){
						ComShowCodeMessage("MNR00098",currCd,sheetObjects[0].GetCellValue(i,"curr_cd"));
						return false;
					}
					if(formObj.curr_cd.value!="" && formObj.curr_cd.value!=sheetObjects[0].GetCellValue(i,"curr_cd")){
						ComShowCodeMessage("MNR00098",formObj.curr_cd.value,sheetObjects[0].GetCellValue(i,"curr_cd"));
						return false;
					}
				}
			}
		}else if(sAction==IBSEARCH_ASYNC03) { //Invoice Detail Retrieve
			var selChk="";
			for(var i=1; i <= sheetObjects[1].RowCount(); i++){
				if(sheetObjects[1].GetCellValue(i,"sel") == 1){
					selChk="Y";
					break;
				}
			}
			if(selChk==""){
				ComShowCodeMessage("MNR00038");
				return false;
			}
		}else if(sAction==IBSEARCH_ASYNC05) {  //Store
			var chk=""
			for(var i=1; i <= (sheetObjects[2].RowCount()+ 1); i++){
				if(sheetObjects[2].GetCellValue(i,"inv_amt") <= 0 && sheetObjects[2].GetCellValue(i,"Check")==1){
					ComShowCodeMessage("MNR00175","Invoice Amount ");
					return false;
				}
				if(sheetObjects[2].GetCellValue(i,"Check")==1){
					chk="Y"
				}
			}
			if (chk==""){
				ComShowCodeMessage("MNR00097");
				return false;
			}
		}else if(sAction==IBSAVE) {
			if(sheetObjects[3].RowCount()<1){
				ComShowCodeMessage("MNR00281");
				return false;
			}
			var	tot=0;
			for(var i=1; i <= (sheetObjects[3].RowCount()); i++){
				tot +=  eval(sheetObjects[3].GetCellValue(i, PrefixSheet2+"inv_amt"));
				if(sheetObjects[3].GetCellValue(i,PrefixSheet2+"inv_amt") <= 0){
					ComShowCodeMessage("MNR00175","Invoice Amount ");
					return false;
				}
			}
			if(tot < 1){
				ComShowCodeMessage("MNR00175","Invoice Amount ");
				return false;
			}
			if(formObj.inv_dt.value==""){
				ComShowCodeMessage("MNR00172","Receive DT ");
				ComSetFocus(formObj.inv_dt);
				return false;
			}
			if(formObj.inv_due_dt.value==""){
				ComShowCodeMessage("MNR00172","Issue DT ");
				ComSetFocus(formObj.inv_due_dt);
				return false;
			}
			if(formObj.amt.value==""){
				ComShowCodeMessage("MNR00172","INV AMT ");
				ComSetFocus(formObj.amt);
				return false;
			}
			if(formObj.vat.value==""){
				ComShowCodeMessage("MNR00172","V.A.Tax ");
				ComSetFocus(formObj.vat);
				return false;
			}
			if(formObj.wht.value==""){
				ComShowCodeMessage("MNR00172","W.H.Tax ");
				ComSetFocus(formObj.wht);
				return false;
			}
		}
		else if(sAction==IBSEARCH_ASYNC01) {  //Confirm
			if(sheetObjects[3].RowCount()<1){
				ComShowCodeMessage("MNR00281");
				return false;
			}
			var	tot=0;
			for(var i=1; i <= (sheetObjects[3].RowCount()); i++){
				tot +=  sheetObjects[3].GetCellValue(i, PrefixSheet2+"inv_amt")*100;
				if(sheetObjects[3].GetCellValue(i,PrefixSheet2+"inv_amt") <= 0){
					ComShowCodeMessage("MNR00175","Invoice Amount ");
					return false;
				}
			}
			if(parseFloat(formObj.amt.value.replace(/,/g,""))!=tot/100){
				ComShowCodeMessage("MNR00280");
				ComSetFocus(formObj.amt);
				return false;
			}
			if(tot < 1){
				ComShowCodeMessage("MNR00175","Invoice Amount ");
				return false;
			}
			if(formObj.inv_dt.value==""){
				ComShowCodeMessage("MNR00172","Receive DT ");
				ComSetFocus(formObj.inv_dt);
				return false;
			}
			if(formObj.inv_due_dt.value==""){
				ComShowCodeMessage("MNR00172","Issue DT ");
				ComSetFocus(formObj.inv_due_dt);
				return false;
			}
			if(formObj.amt.value==""){
				ComShowCodeMessage("MNR00172","INV AMT ");
				ComSetFocus(formObj.amt);
				return false;
			}
			if(formObj.vat.value==""){
				ComShowCodeMessage("MNR00172","V.A.Tax ");
				ComSetFocus(formObj.vat);
				return false;
			}
			if(formObj.wht.value==""){
				ComShowCodeMessage("MNR00172","W.H.Tax ");
				ComSetFocus(formObj.wht);
				return false;
			}
		}
		else if(sAction==IBSEARCH_ASYNC04) {  //Cancel
			if(sheetObjects[3].RowCount()<1){
				ComShowCodeMessage("MNR00281");
				return false;
			}
		}
		else if(sAction==IBDELETE) {
			if(formObj.input_inv_no.value==""){
				ComShowCodeMessage("MNR00089");
				return false;
			}
			
			for(var i=1; i <= (sheetObjects[3].RowCount()); i++){
				if(sheetObjects[3].GetCellValue(i, "sheet2_disp_sold_dt") != ""){
					ComShowCodeMessage("MNR00387");
					return false;
				}
			}
		}	
        return true;
    }
	/**
     * event in case of choose Select
     * activating selected tab items.
     */
    function changeKind(nItem)
    {
    	if(nItem==0){
    		$("#selectLayer").css("display","inline");
    		$("#selectLayer2").css("display","");
    		$("#selectLayer1").css("display","none");
    		$("#selectLayer3").css("display","none");
    		document.getElementById("buyerTp").style.display =  "";
    	}else{
    		$("#selectLayer").css("display","none");
    		$("#selectLayer2").css("display","none");
    		$("#selectLayer1").css("display","inline");
    		$("#selectLayer3").css("display","");
    		document.getElementById("buyerTp").style.display =  "none";
    	}
        //var objs=document.all.item("selectLayer");
//		for (var i=0; i < objs.length; i ++){
//			if (i != nItem) {
//				objs[i].style.display="none";
//			}else{
//				objs[nItem].style.display="Inline";
//			}
//		}
		
    }
	/**
	 * getting rep_Multiful_inquiry
	 * 
	 * Location : in case of Single choice
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//initializing
		eval("document.form." + ret_val + ".value='';");
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//clearing comma(,)
		if (tempText != "")
	        tempText=tempText.substr(0, tempText.length - 1);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/**
	 * (Service Provider) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			var idx=combo_kind.GetSelectIndex();
			if(idx=="0"){
				formObj.t1_mnr_prnr_cnt_cd.value=aryPopupData[0][3].substring(0,2);
				formObj.t1_mnr_prnr_seq.value=aryPopupData[0][3].substring(2);
				formObj.t1_mnr_prnr_cnt_nm.value=aryPopupData[0][4];
			}else if(idx=="1"){
				formObj.t2_mnr_prnr_cnt_cd.value=aryPopupData[0][3].substring(0,2);
				formObj.t2_mnr_prnr_seq.value=aryPopupData[0][3].substring(2);
				formObj.t2_mnr_prnr_cnt_nm.value=aryPopupData[0][4];
			}
		}
	}
	function setInvoiceListValue() {
		var formObj=document.form;
		var idx=combo_kind.GetSelectIndex();
		if(idx=="0"){
			ComSetObjValue(formObj.from_dt, formObj.t1_from_dt.value);
			ComSetObjValue(formObj.to_dt, formObj.t1_to_dt.value);
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t1_mnr_ord_seq.value);
			ComSetObjValue(formObj.vndr_seq, formObj.t1_mnr_prnr_cnt_cd.value + formObj.t1_mnr_prnr_seq.value);
		}else if(idx=="1"){
			ComSetObjValue(formObj.from_dt, formObj.t2_from_dt.value);
			ComSetObjValue(formObj.to_dt, formObj.t2_to_dt.value);
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t2_mnr_ord_seq.value);
			ComSetObjValue(formObj.vndr_seq, formObj.t2_mnr_prnr_cnt_cd.value + formObj.t2_mnr_prnr_seq.value);
		}
		ComSetObjValue(formObj.inv_sch_type_code, combo_kind.GetSelectCode());
		formObj.mnr_prnr_knd_cd.value=combo_buyer_type.GetSelectCode();
	}
	function setInvoiceListClear() {
		var formObj=document.form;
		formObj.t1_from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t1_to_dt.value=ComGetNowInfo();
		formObj.t2_from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t2_to_dt.value=ComGetNowInfo();
		ComClearManyObjects(
		     formObj.t1_mnr_ord_seq
			,formObj.t2_mnr_ord_seq
			,formObj.t1_mnr_prnr_cnt_cd
			,formObj.t1_mnr_prnr_seq
	     	,formObj.t1_mnr_prnr_cnt_nm
			,formObj.t2_mnr_prnr_cnt_cd
			,formObj.t2_mnr_prnr_seq
	     	,formObj.t2_mnr_prnr_cnt_nm
		)
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		combo_kind.SetSelectCode("MI");
		saveEndYN="";
		saveType="";
		invInfoClearYN="";
	}
	function setInvoiceInfomationClear() {
		var formObj=document.form;
		ComClearManyObjects(
		     formObj.input_inv_no
			,formObj.inv_dt
			,formObj.inv_due_dt
			,formObj.curr_cd
			,formObj.iss_ofc_cd
			,formObj.ref_no
			,formObj.buyer_cd
			,formObj.buyer_nm
			,formObj.buyer_type
			,formObj.mnr_grp_tp_cd
			,formObj.mnr_prnr_tp_cd
			,formObj.bank_nm
			,formObj.bank_acct_no
			,formObj.mnr_bil_to_nm
			,formObj.amt
			,formObj.vat
			,formObj.wht
			,formObj.g_amt
			,formObj.mnr_inv_rmk
			,formObj.g_vat_curr_amt
			,formObj.vat_xch_rt
		)
		combo_status.SetSelectCode("NEW");
		chg_curr_cd.SetSelectCode(-1,false);
		formObj.rcv_inv_seq.value="";
		formObj.mnr_inv_sts_cd.value="";
		formObj.cancel_yn.value="";
		formObj.chg_xch_rt.value="";
		formObj.g_vat_curr_amt.value="";
		formObj.amt.value="0.00";
		formObj.vat.value="0.00";
		formObj.g_amt.value="0.00";
		formObj.wht.value="0.00";
		formObj.vat_xch_rt.value="0.000";
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
	}
	function setCustomerName(tabIdx){
		MnrWaitControl(true);
		sheetObjects[0].SetEnable(0);
		var formObj=document.form;
		if(tabIdx="t1"){
			var CustCd=formObj.t1_mnr_prnr_cnt_cd.value;
			var CustSeq=formObj.t1_mnr_prnr_seq.value;
		}else{
			var CustCd=formObj.t2_mnr_prnr_cnt_cd.value;
			var CustSeq=formObj.t2_mnr_prnr_seq.value;
		}
		if(CustCd =="" || CustSeq =="" )
		{
			sheetObjects[0].SetEnable(1);
			MnrWaitControl(false);
			return;
		}
		var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],CustCd,CustSeq);
		var arrResult=MnrXmlToArray(sXml);
		if(arrResult != null){
			for(var i=0; i < arrResult.length;i ++){
       			if(tabIdx="t1"){
					formObj.t1_mnr_prnr_seq.value=arrResult[i][4];
	         		formObj.t1_mnr_prnr_cnt_nm.value=arrResult[i][10];
	         		formObj.t1_mnr_prnr_cnt_nm.title=arrResult[i][10];
				}else{
					formObj.t2_mnr_prnr_seq.value=arrResult[i][4];
	         		formObj.t2_mnr_prnr_cnt_nm.value=arrResult[i][10];
	         		formObj.t2_mnr_prnr_cnt_nm.title=arrResult[i][10];
				}
				break;
			}
		}else{
			ComShowCodeMessage("MNR00121");
   			if(tabIdx="t1"){
				formObj.t1_mnr_prnr_cnt_cd.value="";
				formObj.t1_mnr_prnr_seq.value="";
	     		formObj.t1_mnr_prnr_cnt_nm.value="";
	     		formObj.t1_mnr_prnr_cnt_nm.title="";
	     		ComSetFocus(formObj.t1_mnr_prnr_cnt_cd);
			}else{
				formObj.t2_mnr_prnr_cnt_cd.value="";
				formObj.t2_mnr_prnr_seq.value="";
	     		formObj.t2_mnr_prnr_cnt_nm.value="";
	     		formObj.t2_mnr_prnr_cnt_nm.title="";
	     		ComSetFocus(formObj.t2_mnr_prnr_cnt_cd);
			}
		}
		sheetObjects[0].SetEnable(1);
		MnrWaitControl(false);
	}
	function chkCurrXchRt(){
		var formObj=document.form;
		var invTotAmt="";
		var whtTaxAmt="";
		var vatXchRt="";
		var chgXchRt="";
		var val=formObj.vat_xch_rt.value.split(".");
		var val1=val[0];
		var val2=val[1];
		if(val2 == undefined) val2="0";
		if(val1.length >= 15){
			formObj.vat_xch_rt.value=val1.substr(0,15) + "." + val2
		}
		vatXchRt=formObj.vat_xch_rt.value.replace(/,/g,"")/100;
		formObj.vat_xch_rt.value=MnrAddComma(formObj.vat_xch_rt.value , "#,###.000")
		if(vatXchRt=="") vatXchRt="0.000";
		if(chg_curr_cd.GetSelectCode()!= "" && formObj.chg_xch_rt.value == ""){
			formObj.chg_xch_rt.value="0.00";
		}
		val=formObj.chg_xch_rt.value.split(".")
		val1=val[0];
		val2=val[1];
		if(val2 == undefined) val2="0";
		if(val1.length >= 15){
			formObj.chg_xch_rt.value=val1.substr(0,15) + "." + val2
		}
		chgXchRt=formObj.chg_xch_rt.value.replace(/,/g,"");
		formObj.chg_xch_rt.value=ComAddComma2(formObj.chg_xch_rt.value, "#,###.00");
		if(currPrcsKnt=="0"){
			if(formObj.amt.value.length >= 15){
				formObj.amt.value=formObj.amt.value.substr(0,15)
			}
			invTotAmt=formObj.amt.value.replace(/,/g,"");
			formObj.amt.value=ComAddComma2(formObj.amt.value , "#,###")
			if(invTotAmt == "") invTotAmt="0";
			if(formObj.wht.value.length >= 15){
				formObj.wht.value=formObj.wht.value.substr(0,15)
			}
			whtTaxAmt=formObj.wht.value.replace(/,/g,"");
			formObj.wht.value=ComAddComma2(formObj.wht.value, "#,###")
			if(whtTaxAmt == "")	whtTaxAmt="0";
			if(formObj.curr_cd.value == chg_curr_cd.GetSelectCode()){
			//Invoice + vat
				formObj.g_amt.value=MnrMakeRound(parseFloat(parseFloat(invTotAmt) + (parseFloat(invTotAmt) * parseFloat(vatXchRt)) - parseFloat(whtTaxAmt)),0);
			} else {
			//Invoice 
				formObj.g_amt.value=MnrMakeRound(parseFloat(invTotAmt)-parseFloat(whtTaxAmt),0);
			}
			formObj.g_amt.value=ComAddComma2(formObj.g_amt.value, "#,###");
		} else {
			var val=formObj.amt.value.split(".");
			var val1=val[0];
			var val2=val[1];
			if(val2 == undefined) val2="0";
			if(val1.length >= 15){
				formObj.amt.value=val1.substr(0,15) + "." + val2
			}
			invTotAmt=formObj.amt.value.replace(/,/g,"");
			formObj.amt.value=ComAddComma2(formObj.amt.value , "#,###.00")
			if(invTotAmt=="") invTotAmt="0.00";
			val=formObj.wht.value.split(".")
			val1=val[0];
			val2=val[1];
			if(val2 == undefined) val2="0";
			if(val1.length >= 15){
				formObj.wht.value=val1.substr(0,15) + "." + val2
			}
			whtTaxAmt=formObj.wht.value.replace(/,/g,"");
			formObj.wht.value=ComAddComma2(formObj.wht.value, "#,###.00")
			if(whtTaxAmt == "")	whtTaxAmt="0.00";
			if(formObj.curr_cd.value == chg_curr_cd.GetSelectCode()){
			// Invoice + vat
				formObj.g_amt.value=MnrMakeRound(parseFloat(parseFloat(invTotAmt) + (parseFloat(invTotAmt) * parseFloat(vatXchRt)) - parseFloat(whtTaxAmt)),2);
			} else {
			// Invoice 
				formObj.g_amt.value=MnrMakeRound(parseFloat(invTotAmt)-parseFloat(whtTaxAmt),2);
			}
			formObj.g_amt.value=ComAddComma2(formObj.g_amt.value, "#,###.00");
		}
		//changing dp_prcs from retrieving exchange rate
		if(formObj.conv_dp_prcs_knt.value == "0"){
			formObj.vat.value=MnrMakeRound(parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))),0);
			formObj.g_vat_curr_amt.value=MnrMakeRound(parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))),0);
			formObj.vat.value=ComAddComma2(formObj.vat.value, "#,###");
			formObj.g_vat_curr_amt.value=ComAddComma2(formObj.g_vat_curr_amt.value, "#,###");
		} else {
			formObj.vat.value=MnrMakeRound(parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))),3);
			formObj.g_vat_curr_amt.value=MnrMakeRound(parseFloat((parseFloat(invTotAmt) * parseFloat(vatXchRt) * parseFloat(chgXchRt))),3);
//			formObj.vat.value=ComAddComma2(formObj.vat.value, "#,###.000");
//			formObj.g_vat_curr_amt.value=ComAddComma2(formObj.g_vat_curr_amt.value, "#,###.000");
		}
		//does not show g_vat_curr_amt in case of inv curr is equal to vat curr
		if(chg_curr_cd.GetSelectCode()== formObj.curr_cd.value){
			formObj.g_vat_curr_amt.value="";
		}
	}
	function initControl() {
	    //handling Axon event. eventcatch
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	//    axon_event.addListenerFormat('focus',   'obj_activate',    form);                     
		axon_event.addListenerFormat('change',	 'obj_change',	form); 
	}
	/**
	 * HTML Control deactivate event <br>
	 **/
	function obj_deactivate(){
		obj=ComGetEvent();
	    ComChkObjValid(ComGetEvent());
	}
	/**
	 * HTML Control activate event <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
		var obj=ComGetEvent();
		var formObj=document.form;
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vat_xch_rt":
	    		case "chg_xch_rt":
	    		case "wht":
					ComSetFocus(obj);
					break;
			}
		}
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "t1_mnr_prnr_seq":
					setCustomerName('t1');
				   	break;
	    		case "t2_mnr_prnr_seq":
	        		setCustomerName('t2');
				   	break;
	    		case "vat_xch_rt":
					chkCurrXchRt();
				   	break;
	    		case "chg_xch_rt":
					chkCurrXchRt();
				   	break;
	    		case "wht":
					chkCurrXchRt();
				   	break;
	    		case "inv_dt":
					MnrChkDateValid(formObj.inv_dt,"Invoice DT");
					var prevChgCurrCd=chg_curr_cd.GetSelectCode();
					if(prevChgCurrCd != ""){
						chg_curr_cd.SetSelectCode(-1,false);
						chg_curr_cd.SetSelectCode(prevChgCurrCd);
					}
					chkCurrXchRt();
				   	break;
	    		case "inv_due_dt":
					MnrChkDateValid(formObj.inv_due_dt,"Due DT");
				   	break;
			}
	    }
	}
	/**
	 * HTML Control keypress event <br>
	 **/