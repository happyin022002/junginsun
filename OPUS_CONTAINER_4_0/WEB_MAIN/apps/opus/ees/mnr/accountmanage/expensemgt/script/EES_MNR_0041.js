/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0041.js
*@FileTitle  : MNR Invoice Creation & Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var initLoader=0;
//save=1, delete=2, confirm=3, Web Invoice Reject=4 , AP cancel=5
var saveType="";
var invInfoClearYN="";
var invNo=""
var PrefixSheet2="sheet2_";
var saveRet="";
var currPrcsKnt="0";
var saveEndYN="";
var chkVerifyConv="";
var solFlg = "N";
var sol_inv_no = "";
//CD00089 + CD00090 : Americas
var isAmerican=false;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
          	switch(srcName) {
				case "btn_AllNew":
					doActionIBSheet(sheetObjects[3],document.form,IBCLEAR);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[4],document.form,IBSAVE);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObjects[4],document.form,IBDELETE);
					break;
				case "btn_Confirm":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC05);
					break;
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC08);
					break;
				case "btn_Return":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC06);
					break;
				case "btn_Retrieve":
					var idx=comboObjects[0].GetSelectIndex();
					doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[3],document.form,IBCLEAR);
//					setInvoiceListClear();
					break;
				case "btn_t1_Clear":
					doActionIBSheet(sheetObjects[3],document.form,IBRESET);
					break;
				case "btn_t2_Clear":
					doActionIBSheet(sheetObjects[3],document.form,IBRESET);
					break;
				case "btn_t3_Clear":
					doActionIBSheet(sheetObjects[3],document.form,IBRESET);
					break;
                case "btn_t1_DetailRetrieve":
					tabObjects[0].SetSelectedIndex(0);
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC02);
					break;
                case "btn_t2_DetailRetrieve":
					tabObjects[0].SetSelectedIndex(0);
					doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
					break;
                case "btn_t3_DetailRetrieve":
					tabObjects[0].SetSelectedIndex(1);
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC04);
					break;
                case "btn_Store":
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC07);
					break;
                case "btn_Del":
					if(beforetab=="0"){
						MnrRowDelete(sheetObjects[3], "Check");
					}else{
						MnrRowDelete(sheetObjects[4], PrefixSheet2+"Check");
					}
	                break;
				case "btn_Convert":
					doActionIBSheet(sheetObjects[6],document.form,IBSEARCH_ASYNC09);
					break;
				case "btn_RepairDetail":
					var woType="";
					var eqNo="";
					var rpr_rqst_seq="";
					var rpr_rqst_ver_no="";
					var eq_knd_cd="";
					var reqStr="";
					var mnrOrdOfcCtyCd="";
					var mnrOrdSeq="";
					var costOfcCd="";
					if(beforetab=="0"){
					woType=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"mnr_wo_tp_cd")
					eqNo=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"eq_no")
					rpr_rqst_seq=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"rpr_rqst_seq")
					rpr_rqst_ver_no=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"rpr_rqst_ver_no")
					eq_knd_cd=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"eq_knd_cd")
					mnrOrdOfcCtyCd=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"mnr_ord_ofc_cty_cd");
					mnrOrdSeq=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"mnr_ord_seq");
					costOfcCd=sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(),"cost_ofc_cd");
					}else{
					woType=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"mnr_wo_tp_cd")
					eqNo=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"eq_no")
					rpr_rqst_seq=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"rpr_rqst_seq")
					rpr_rqst_ver_no=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"rpr_rqst_ver_no")
					eq_knd_cd=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"eq_knd_cd")
					mnrOrdOfcCtyCd=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"mnr_ord_ofc_cty_cd");
					mnrOrdSeq=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"mnr_ord_seq");
					costOfcCd=sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(),PrefixSheet2+"cost_ofc_cd");
					}
					if(woType == 'EST'){
						if(MnrNullToBlank(eqNo) != ''){
							ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+eqNo+"&rpr_rqst_seq="+rpr_rqst_seq+"&rpr_rqst_ver_no="+rpr_rqst_ver_no+"&eq_knd_cd=" + eq_knd_cd+"&spp_type=N", 1024, 768, '', '0,0', false);
						}
					}else if(woType == 'SPL'){
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/opuscntr/EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 690, '', '0,0', true);
						}
					}else if(woType == 'EXT'){
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/opuscntr/EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 950, 550, '', '0,0', true);
						}
					}else if(woType == 'RFS'){
						if(MnrNullToBlank(mnrOrdOfcCtyCd) != ''&& MnrNullToBlank(mnrOrdSeq) != ''){
							ComOpenPopup('/opuscntr/EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 600, '', '0,0', true);
						}
					}
					break;
				case "btn_DownExcel":
					
					if(beforetab=="0"){
						if(sheetObjects[3].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[3].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[3]), SheetDesign:1,Merge:1 });
						}
					}else{
						if(sheetObjects[4].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[4].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[4]), SheetDesign:1,Merge:1 });
						}
					}
					break;
				case "btn_LoadExcel":
					var reqStr=""
					reqStr="vndr_seq=" + form.ord_vndr_seq.value;
					reqStr += "&wo_ofc_cd=" + wo_ofc_cd.GetSelectCode();
					ComOpenPopup('/opuscntr/EES_MNR_0143.do?'+reqStr, 810, 550, 'getEES_MNR_0143', '0,1', true);
					break;
				case "btn_rcv_dt":
					var cal=new ComCalendar();
					cal.setEndFunction("chkCurrXchRt");
 					cal.select(form.rcv_dt, 'yyyy-MM-dd');
					break;
				case "btn_eff_dt":
					var cal=new ComCalendar();
 					cal.select(form.eff_dt, 'yyyy-MM-dd');
					break;
				case "btn_isu_dt":
					var cal=new ComCalendar();
					cal.setEndFunction("chkIssDt");
 					cal.select(form.iss_dt, 'yyyy-MM-dd');
					break;
				case "btn_t1_calendar":
					var cal=new ComCalendarFromTo();
 					cal.select(form.t1_from_dt,  form.t1_to_dt,  'yyyy-MM-dd');
					break;
				case "btn_t2_calendar":
					var cal=new ComCalendarFromTo();
 					cal.select(form.t2_from_dt,  form.t2_to_dt,  'yyyy-MM-dd');
					break;
				case "btn_t3_calendar":
					var cal=new ComCalendarFromTo();
 					cal.select(form.t3_from_dt,  form.t3_to_dt,  'yyyy-MM-dd');
					break;
		        case "btn_t1_req_multy":
                    rep_Multiful_inquiry("t1_mnr_ord_seq");
					break;
		        case "btn_t2_req_multy":
                    rep_Multiful_inquiry("t2_mnr_ord_seq");
					break;
		        case "btn_t3_req_multy":
                    rep_Multiful_inquiry("t3_mnr_ord_seq");
					break;
				case "btn_t1_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_t2_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_t3_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_vndr":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Pay_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_LoadExcel_popup":
					ComOpenPopup('/opuscntr/EES_MNR_0248.do', 1000, 600, null, '1,0,1,1,1,1,1,1',  true);
					
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
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
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
			tabObjects[k].SetSelectedIndex(0);
		}
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrBtnRename("btn_Calcle","btn_New_All","AP Cancel");
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
                    //no support[check again]CLT 					BaseColor="255,255,255";
                    InsertItem( "Invoice Detail List" , "");
                    InsertItem( "Verified List" , "");
                }
                break;
        }
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
  	            with (comboObj) {
  	    		SetColAlign(0, "left");
  			        //SetColWidth("75")
					SetUseAutoComplete(1);
  		        }
  	            break;
	        case 2:
	           	with (comboObj) {
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
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
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
             case "t1sheet1":
            	    with(sheetObj){
                 
               var HeadTitle="|Sel|Seq.|W/O Office|S/P Code|S/P Name|INV Type|INV No.|Creation DT|AMT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Status"
               var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 13, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"wo_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mnr_wrk_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sls_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_term_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               SetSheetHeight(182);
               SetEditable(1);
                     }


				break;
             case "t2sheet1":
            	    with(sheetObj){
                 
               var HeadTitle="|Sel|Seq.|W/O Office|S/P Code|S/P Name|W/O Type|W/O No.|W/O AMT|Creation DT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Issue From"
               var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 4, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"wo_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"mnr_wrk_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vat",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sls_tax_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wht",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Combo",      Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inp_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_prcs_knt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_term_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                
               InitColumns(cols);
               var info = {ComboText:"OPUS|NEW PORT|SEA ONLINE", ComboCode:"|N|S"};
               SetColProperty(0, "mnr_inp_tp_cd", info);
               SetSheetHeight(182);
               SetEditable(1);
                     }


				break;
             case "t3sheet1":
            	    with(sheetObj){
                 
               var HeadTitle="|Sel|Seq.|INV Office|S/P Code|S/P Name|INV Type|INV No.|Creation DT|AMT|V.A.T|Sales\nTax|W.H.T|Invoice\nTotal|Status"
               var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 14, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"wo_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_wrk_amt",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"sls_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_term_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_rgst_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mnr_prnr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"pay_vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               SetSheetHeight(182);
               SetEditable(1);
                     }


				break;
			case "sheet1":
			    with(sheetObj){
		        
		      var HeadTitle1="|Sel|Seq.|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|System Verify\nResult";
		      var HeadTitle2="|Sel|Seq.|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|System Verify\nResult";
		      var headCount=ComCountHeadTitle(HeadTitle1);
//		      (headCount + 9 , 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Check",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_wo_tp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"wo_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"cost_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"wo_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rpr_rslt_dt",         KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"mnr_expn_dtl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cost_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"inv_curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"AutoSum",   Hidden:1, Width:85,   Align:"Right",   ColMerge:1,   SaveName:"inv_adj_bzc_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ord_dtl_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_wo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_ver_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"cost_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"dp_prcs_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_conv_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
		       
		      InitColumns(cols);
		      SetSheetHeight(180);
		      SetEditable(1);
		            }


				break;
			case "sheet2":
			    with(sheetObj){
		        
		      var HeadTitle1="|Del|Seq.|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|EX.Rate Adj|System Verify\nResult";
		      var HeadTitle2="|Del|Seq.|W/O\nType|W/O\nNo.|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Repair\nDate|Extra\nItem|Extra\nQ'ty|INV NO|W/O\nCurr|W/O\nAmount|INV\nCurr|INV\nAmount|EX.Rate Adj|System Verify\nResult";
		      var headCount=ComCountHeadTitle(HeadTitle1);
//		      (headCount + 9, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"Check",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"Seq" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"mnr_wo_tp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"wo_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rqst_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"cost_dtl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"wo_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:PrefixSheet2+"rpr_rslt_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_expn_dtl_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"rpr_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"cost_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"inv_curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:85,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"inv_adj_bzc_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_vrfy_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_ord_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"ord_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"mnr_wo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rpr_rqst_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"rpr_rqst_ver_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"cost_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:PrefixSheet2+"dp_prcs_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:PrefixSheet2+"inv_conv_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
		       
		      InitColumns(cols);
		      SetSheetHeight(180);
		      SetEditable(1);
		      SetShowButtonImage(1);
		      }


				break;
			case "sheet3":
			    with(sheetObj){
		       
		      var HeadTitle="|W/O No.|Gamnt"
		      var headCount=ComCountHeadTitle(HeadTitle);
		      (headCount, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"g_amnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      sheetObj.SetVisible(false);
		      SetEditable(1);
		  
		            }


				break;
			case "sheet4":
			    with(sheetObj){
		   
		      (7, 0, 0, true);
		      var HeadTitle="|Seq.|W/O Amt|W/O Curr|INV Curr|Inv Amt|Point";

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",       KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      sheetObj.SetVisible(false);
		      SetEditable(1);
		      SetEditableColorDiff(0);
		      SetSelectionMode(smSelectionRow);
		      }


				break;
        }
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
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
   /**
    * Event handling of search end of t3sheet1
    * @param sheetObj
    * @return
    */
    function t3sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
			if(saveType!="" && saveEndYN=="Y"){
				sheetObjects[2].SetCellValue(1,"sel","1",0);
				tabObjects[0].SetSelectedIndex(1);
				saveRet="Y";
				doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC04);
			}
			if(solFlg == "Y"){
				for(var i=sheetObjects[2].HeaderRows(); i<=sheetObjects[2].LastRow(); i++){
					if(sheetObjects[2].GetCellValue(i, "wo_no") == sol_inv_no){
						sheetObjects[2].SetCellValue(i,"sel","1",0);
					}
				}
				tabObjects[0].SetSelectedIndex(1);
				doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC04);
				solFlg = "N"
				sol_inv_no = "";
			}
			
			saveEndYN=="";
		}
    }
   /**
    * Event handling of search end of sheet1
    * @param sheetObj
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
			var formObj=document.form;
			
	    	for(i=sheetObj.LastRow()- 1; i > 1 ; i--){
	    		if(sheetObj.GetCellValue(i,  "mnr_vrfy_tp_cd")!="SS"){
					sheetObj.SetCellEditable(i, "Check",0);
					sheetObj.SetRowBackColor(i,"#F7E5E1");
				}
//	    		if( sheetObj.GetCellValue(i,"mnr_wo_tp_cd") != "EST"){
//	    			sheetObj.SetCellValue(i,"rpr_rslt_dt",sheetObj.GetCellValue(i,"wo_dt"));
//	    		}
	    		sheetObj.SetCellValue(i,"inv_curr_cd",formObj.curr_cd.value,0);
			}
			
			//In case of load excel
			if(formObj.pay_inv_seq.value==""){
				var cnt=0;
				var gAmt=0;
				var invAmt=0;
				for(i=sheetObjects[5].LastRow(); i > 0 ; i--){
					cnt=0;
					gAmt=0;
					invAmt=0;
					gAmt=gAmt + parseFloat(sheetObjects[5].GetCellValue(i,  "g_amnt"));
					for(j=sheetObj.LastRow(); j > 1 ; j--){
						if(sheetObj.GetCellValue(j,  "wo_no")==sheetObjects[5].GetCellValue(i,  "wo_no")){
							cnt=cnt + 1;
						}
					}
					for(j=sheetObj.LastRow(); j > 1 ; j--){
						if(sheetObj.GetCellValue(j,  "wo_no")==sheetObjects[5].GetCellValue(i,  "wo_no")){
							sheetObj.SetCellValue(j,  "inv_amt",sheetObjects[5].GetCellValue(i,  "g_amnt")/cnt);
							invAmt=invAmt + parseFloat(sheetObj.GetCellValue(j,  "inv_amt"));
						}
					}
					if((gAmt*100)/100 > (invAmt*100)/100){
						sheetObj.SetCellValue(sheetObj.LastRow()- 1,  "inv_amt",sheetObj.GetCellValue(sheetObj.LastRow()- 1,  "inv_amt") - (gAmt - invAmt));
					}else{
						sheetObj.SetCellValue(sheetObj.LastRow()- 1,  "inv_amt",sheetObj.GetCellValue(sheetObj.LastRow()- 1,  "inv_amt") - (invAmt - gAmt));
					}
				}
			}
			sheetObj.SetSumValue("Seq", "TOTAL");
		}
    }
   /**
    * Event handling of double-click of sheet2
    * @param sheetObj
    * @return
    */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()>0){
			var formObj=document.form;
			for(i=2; i<sheetObj.RowCount()+ 2; i++){
				if(sheetObj.GetCellValue(i,  PrefixSheet2+"mnr_vrfy_tp_cd")!="SS"){
					sheetObj.SetCellEditable(i, PrefixSheet2+"Check",0);
					sheetObj.SetRowBackColor(i,"#F7E5E1");
				}
				sheetObj.SetCellValue(i,PrefixSheet2+"inv_curr_cd",formObj.curr_cd.value,0);
				
				if(sheetObj.GetCellValue(i,PrefixSheet2+"inv_curr_cd") != sheetObj.GetCellValue(i,PrefixSheet2+"curr_cd")){
					if(combo2.GetSelectCode() == "HS"){
						sheetObj.SetCellEditable(i, PrefixSheet2+"inv_adj_bzc_amt",1);
					}else{
						sheetObj.SetCellEditable(i, PrefixSheet2+"inv_adj_bzc_amt",0);
					}
				}else{
					sheetObj.SetCellEditable(i, PrefixSheet2+"inv_adj_bzc_amt",0);
				}
			}
			
			MnrRowDelete(sheetObjects[3], "Check");
			//ComSheet2SheetCheck(formObj.sheet1, formObj.sheet2, "Check");
			//formObj.sheet2.ColumnSort(PrefixSheet2+"Seq", "ASC")
//			for(var i=2; i <= (sheetObj.RowCount()+ 1); i++){
//				if(sheetObj.GetCellValue(i,PrefixSheet2+"mnr_wo_tp_cd") == "EST"){
//					sheetObj.SetCellEditable(i,PrefixSheet2+"rpr_rslt_dt",true);
//				}
//			}
			sheetObj.SetSumValue(PrefixSheet2+"Seq", "Total");
    		
			if(sheetObjects[6].RowCount()>0){
				chkVerifyConv="Y";
				doActionIBSheet(sheetObjects[6],document.form,IBSEARCH_ASYNC09);
			}
			calcGamount();
		}
    }
   /**
    * Loading message after saving (save=1, delete=2, confirm=3, Web Invoice Reject=4 , AP cancel=5)
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
				MnrBtnRename("btn_Confirm","btn_Cancel","AP Cancel");
				ComBtnEnable("btn_cancel")
			}else if(saveType=="4"){
				ComShowCodeMessage("MNR00094");
			}else if(saveType=="5"){
				ComShowCodeMessage("MNR00300");
				ComBtnEnable('btn_Save');
				ComBtnEnable('btn_Delete');
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
				ComBtnEnable('btn_Confirm');
			}
			saveEndYN="Y";
			comboObjects[0].SetSelectCode("CO");
			var idx=comboObjects[0].GetSelectIndex();
			document.form.mnr_inv_sts_cd.value="";
			doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
		} else {
	  		ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
    
    /**
     * Event handling of popup-click of sheet2
     * @param sheetObj
     * @return
     */
 	function sheet1_OnPopupClick(sheetObj, Row,Col){
 		if (sheetObj.ColSaveName(Col) != "rpr_rslt_dt") return;
 		var cal=new ComCalendarGrid();
 		cal.setEndFunction("setGetRowBackColorChange");
 		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
 	}
 	
   /**
    * Event handling of popup-click of sheet2
    * @param sheetObj
    * @return
    */
	function sheet2_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != PrefixSheet2+"rpr_rslt_dt") return;
		var cal=new ComCalendarGrid();
		cal.setEndFunction("setGetRowBackColorChange");
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
   /**
    * Event handling of change of sheet2
    * @param sheetObj
    * @return
    */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var formObj=document.form;
		if(sheetObj.ColSaveName(Col)==PrefixSheet2 + "rpr_rslt_dt"){
			setGetRowBackColorChange();
		} else if(sheetObj.ColSaveName(Col)  == PrefixSheet2 + "inv_amt"){
			calcGamount();
		} else if(sheetObj.ColSaveName(Col)  == PrefixSheet2 + "inv_adj_bzc_amt"){
  			var invConvAmt = sheetObjects[4].GetCellValue(Row, "sheet2_inv_conv_amt");
  			var adjAmt = sheetObjects[4].GetCellValue(Row, "sheet2_inv_adj_bzc_amt");
  				
  			sheetObjects[4].SetCellValue(Row, "sheet2_inv_amt", invConvAmt+adjAmt);
  			calcGamount();
		}
	}
    function sheet4_OnSaveEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()>0){
			var formObj=document.form;
	    	for(i=sheetObj.LastRow(); i > 0 ; i--){
	    		currPrcsKnt=sheetObj.GetCellValue(i,  "inp_msg5")
				if(currPrcsKnt=="0"){
					var info = {Format:"Int", PointCount:0};
					sheetObjects[3].SetColProperty(0, "inv_amt", info);
					sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
					sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
					formObj.sls_tax_amt.dataformat="int";
					formObj.bzc_amt.dataformat="int";
					formObj.vat_amt.dataformat="int";
					formObj.ttl_amt.dataformat="int";
					formObj.whld_tax_amt.dataformat="int";
					formObj.sls_tax_amt.maxLength=15;
					formObj.bzc_amt.maxLength=15;
					formObj.vat_amt.maxLength=15;
					formObj.ttl_amt.maxLength=15;
					formObj.whld_tax_amt.maxLength=15;
					formObj.sls_tax_amt.value="0";
					formObj.bzc_amt.value="0";
					formObj.vat_amt.value="0";
					formObj.ttl_amt.value="0";
					formObj.whld_tax_amt.value="0";
				}else{
					var info = {Format:"Float", PointCount:parseInt(currPrcsKnt)};
					sheetObjects[3].SetColProperty(0, "inv_amt", info);
					sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
					sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
					formObj.sls_tax_amt.dataformat="float";
					formObj.bzc_amt.dataformat="float";
					formObj.vat_amt.dataformat="float";
					formObj.ttl_amt.dataformat="float";
					formObj.whld_tax_amt.dataformat="float";
					formObj.sls_tax_amt.maxLength=18;
					formObj.bzc_amt.maxLength=18;
					formObj.vat_amt.maxLength=18;
					formObj.ttl_amt.maxLength=18;
					formObj.whld_tax_amt.maxLength=18;
					formObj.sls_tax_amt.value="0.00";
					formObj.bzc_amt.value="0.00";
					formObj.vat_amt.value="0.00";
					formObj.ttl_amt.value="0.00";
					formObj.whld_tax_amt.value="0.00";
				}
	    		sheetObjects[4].SetCellValue(i + 1,  PrefixSheet2+"inv_amt",sheetObj.GetCellValue(i,  "inp_msg4"),0);
			}
			formObj.curr_cd.value=target_curr_cd.GetSelectCode();
		}
	}
	 /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem){
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important logic --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	/**
	 * combo1 : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		var kind=comboObj.GetSelectIndex();
		changeKind(kind);

		setInvoiceInfomationClear();

		setInvoiceTaxOpt();
		sheetObjects[4].SetColHidden(PrefixSheet2+"inv_no", 1);

		MnrWaitControl(false);
		MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
		ComBtnDisable('btn_Return');

//		if(kind=="0" || kind=="1"){
//			ComBtnEnable('btn_Store');
//		}else{
//			ComBtnDisable('btn_Store');
//		}
	}
	/**
	 * target_curr_cd : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function target_curr_cd_OnChange(comboObj,Index_Code, Text){
		chkCurrXchRt();
	}
  	/**
     * Sheet processing-related processes
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
          	case IBSEARCH:      //Retrieving
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					setInvoiceListValue();
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("EES_MNR_0041GS.do",FormQueryString(formObj) );
				}
                break;
          	case IBSEARCH_ASYNC02:      //Web Import detail
				if(formObj.pay_inv_seq.value != ""){
					if(ComShowCodeConfirm("MNR00230")){
						invInfoClearYN="Y"
						setInvoiceInfomationClear();
					}else{
						invInfoClearYN="N"
					}
				}
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[3].RemoveAll();
					setInvoiceListValue();
					if(invInfoClearYN!="N"){
						for(var i=1; i <= sheetObjects[0].RowCount(); i++){
							if(sheetObjects[0].GetCellValue(i,"sel") == 1){
								currPrcsKnt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"dp_prcs_knt");
								if(currPrcsKnt=="0"){
									var info = {Format:"Int", PointCount:0};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}else{
									var info = {format:"Float", PointCount:parseInt(currPrcsKnt)};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}
									combo2.SetSelectCode(sheetObjects[0].GetCellValue(i,"mnr_inv_sts_cd"));
									ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[0].GetCellValue(i,"vndr_seq"));
									ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[0].GetCellValue(i,"vndr_lgl_eng_nm"));
									ComSetObjValue(formObj.mnr_prnr_seq, sheetObjects[0].GetCellValue(i,"mnr_prnr_seq"));
									ComSetObjValue(formObj.vndr_nm, sheetObjects[0].GetCellValue(i,"pay_vndr_lgl_eng_nm"));
																	ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
									ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[0].GetCellValue(i,"pay_term_dys"));
									ComSetObjValue(formObj.curr_cd, sheetObjects[0].GetCellValue(i,"curr_cd"));
																	target_curr_cd.SetSelectCode(formObj.curr_cd.value,false);
									ComSetObjValue(formObj.inv_no, sheetObjects[0].GetCellValue(i,"wo_no"));
									ComSetObjValue(formObj.inv_status, sheetObjects[0].GetCellValue(i,"mnr_inv_sts_nm"));
									ComSetObjValue(formObj.rcv_dt, sheetObjects[0].GetCellValue(i,"rcv_dt"));
									ComSetObjValue(formObj.iss_dt, sheetObjects[0].GetCellValue(i,"iss_dt"));
									ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[0].GetCellValue(i,"mnr_inv_rmk"));
									ComSetObjValue(formObj.pay_inv_seq, sheetObjects[0].GetCellValue(i,"pay_inv_seq"));
									ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[0].GetCellValue(i,"mnr_inv_sts_cd"));
								break;
							}
						}
						formObj.f_cmd.value=SEARCH01;
						var sParam=ComGetSaveString(sheetObjects[0]);
						sParam += "&" + FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", sParam);
						currPrcsKnt=ComGetEtcData(sXml, "dp_prcs_knt");
						if(currPrcsKnt=="0"){
							var info = {Format:"Int", PointCount:0};
							sheetObjects[3].SetColProperty(0, "inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
							formObj.sls_tax_amt.dataformat="int";
							formObj.bzc_amt.dataformat="int";
							formObj.vat_amt.dataformat="int";
							formObj.ttl_amt.dataformat="int";
							formObj.whld_tax_amt.dataformat="int";
							formObj.sls_tax_amt.maxLength=15;
							formObj.bzc_amt.maxLength=15;
							formObj.vat_amt.maxLength=15;
							formObj.ttl_amt.maxLength=15;
							formObj.whld_tax_amt.maxLength=15;
							ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"sls_tax_amt"), "#,###"));
							ComSetObjValue(formObj.bzc_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"mnr_wrk_amt"), "#,###"));
							ComSetObjValue(formObj.vat_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"vat_amt"), "#,###"));
							ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"whld_tax_amt"), "#,###"));
							ComSetObjValue(formObj.ttl_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"ttl_amt"), "#,###"));
						}else{
							var info = {format:"Float", PointCount:parseInt(currPrcsKnt)};
							sheetObjects[3].SetColProperty(0, "inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
							formObj.sls_tax_amt.dataformat="float";
							formObj.bzc_amt.dataformat="float";
							formObj.vat_amt.dataformat="float";
							formObj.ttl_amt.dataformat="float";
							formObj.whld_tax_amt.dataformat="float";
							formObj.sls_tax_amt.maxLength=18;
							formObj.bzc_amt.maxLength=18;
							formObj.vat_amt.maxLength=18;
							formObj.ttl_amt.maxLength=18;
							formObj.whld_tax_amt.maxLength=18;
							ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"sls_tax_amt"), "#,###.00"));
							ComSetObjValue(formObj.bzc_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"mnr_wrk_amt"), "#,###.00"));
							ComSetObjValue(formObj.vat_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"vat_amt"), "#,###.00"));
							ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"whld_tax_amt"), "#,###.00"));
							ComSetObjValue(formObj.ttl_amt, ComAddComma2(sheetObjects[0].GetCellValue(i,"ttl_amt"), "#,###.00"));
						}
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save')
						ComBtnDisable('btn_Delete')
						ComBtnDisable('btn_Confirm')
					}else{
						ComBtnEnable('btn_Save')
						ComBtnEnable('btn_Delete')
						ComBtnEnable('btn_Confirm')
					}
					if(comboObjects[0].GetSelectIndex()=="0"){
						ComBtnEnable('btn_Return')
					}else{
						ComBtnDisable('btn_Return')
					}
				}
          		break;
          	case IBSEARCH_ASYNC03:      //Work Order Detail
	          	if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[3].RemoveAll();
					setInvoiceListValue();
					if(invInfoClearYN!="N"){
						for(var i=1; i <= sheetObjects[1].RowCount(); i++){
							if(sheetObjects[1].GetCellValue(i,"sel") == 1){
								//Retrieving combo data
								var sCondition=new Array (
										new Array("PrntVndrSeq",sheetObjects[1].GetCellValue(i,"vndr_seq"), "COMMON")
								);
								var comboList=MnrComSearchCombo(sheetObj,sCondition);
								//Setting combo
								for(var k=0; k < comboList.length;k++){
									if(comboList[k] != null){
										//Initializing each combo of sheets
										for(var j=0; j < comboList[k].length;j++){
											var tempText=comboList[k][j].split("|");
											if(k==0) {
												formObj.mnr_prnr_seq.value=tempText[0];
												formObj.vndr_nm.value=tempText[1];
											}
										}
									}
								}
								ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[1].GetCellValue(i,"vndr_seq"));
								ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[1].GetCellValue(i,"vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
								ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[1].GetCellValue(i,"pay_term_dys"));
								if(formObj.pay_inv_seq.value==""){
									ComSetObjValue(formObj.curr_cd, sheetObjects[1].GetCellValue(i,"curr_cd"));
									target_curr_cd.SetSelectCode(formObj.curr_cd.value,false);
								}
								if(target_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
									target_curr_cd.SetSelectCode(formObj.curr_cd.value,false);
								}
								currPrcsKnt=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"dp_prcs_knt");
								if(currPrcsKnt=="0"){
									var info = {Format:"Int", PointCount:0};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}else{
									var info = {format:"Float", PointCount:parseInt(currPrcsKnt)};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}
								break;
							}
						}
						formObj.f_cmd.value=SEARCH01;
						var sParam=ComGetSaveString(sheetObjects[1]);
						sParam += "&" + FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", sParam);
						currPrcsKnt=ComGetEtcData(sXml, "dp_prcs_knt");
						if(currPrcsKnt=="0"){
							var info = {Format:"Int", PointCount:0};
							sheetObjects[3].SetColProperty(0, "inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
							formObj.sls_tax_amt.dataformat="int";
							formObj.bzc_amt.dataformat="int";
							formObj.vat_amt.dataformat="int";
							formObj.ttl_amt.dataformat="int";
							formObj.whld_tax_amt.dataformat="int";
							formObj.sls_tax_amt.maxLength=15;
							formObj.bzc_amt.maxLength=15;
							formObj.vat_amt.maxLength=15;
							formObj.ttl_amt.maxLength=15;
							formObj.whld_tax_amt.maxLength=15;
							ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(MnrNullToZero(formObj.sls_tax_amt.value), "#,###"));
							ComSetObjValue(formObj.bzc_amt, ComAddComma2(MnrNullToZero(formObj.bzc_amt.value), "#,###"));
							ComSetObjValue(formObj.vat_amt, ComAddComma2(MnrNullToZero(formObj.vat_amt.value), "#,###"));
							ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(MnrNullToZero(formObj.whld_tax_amt.value), "#,###"));
							ComSetObjValue(formObj.ttl_amt, ComAddComma2(MnrNullToZero(formObj.ttl_amt.value), "#,###"));
						}else{
							var info = {format:"Float", PointCount:parseInt(currPrcsKnt)};
							sheetObjects[3].SetColProperty(0, "inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
							sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
							formObj.sls_tax_amt.dataformat="float";
							formObj.bzc_amt.dataformat="float";
							formObj.vat_amt.dataformat="float";
							formObj.ttl_amt.dataformat="float";
							formObj.whld_tax_amt.dataformat="float";
							formObj.sls_tax_amt.maxLength=18;
							formObj.bzc_amt.maxLength=18;
							formObj.vat_amt.maxLength=18;
							formObj.ttl_amt.maxLength=18;
							formObj.whld_tax_amt.maxLength=18;
							ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(MnrNullToZero(formObj.sls_tax_amt.value), "#,###.00"));
							ComSetObjValue(formObj.bzc_amt, ComAddComma2(MnrNullToZero(formObj.bzc_amt.value), "#,###.00"));
							ComSetObjValue(formObj.vat_amt, ComAddComma2(MnrNullToZero(formObj.vat_amt.value), "#,###.00"));
							ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(MnrNullToZero(formObj.whld_tax_amt.value), "#,###.00"));
							ComSetObjValue(formObj.ttl_amt, ComAddComma2(MnrNullToZero(formObj.ttl_amt.value), "#,###.00"));
						}
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save')
						ComBtnDisable('btn_Delete')
						ComBtnDisable('btn_Confirm')
					}else{
						ComBtnEnable('btn_Save')
						ComBtnEnable('btn_Delete')
						ComBtnEnable('btn_Confirm')
					}
					if(comboObjects[0].GetSelectIndex()=="0"){
						ComBtnEnable('btn_Return')
					}else{
						ComBtnDisable('btn_Return')
					}
				}
          		break;
          	case IBSEARCH_ASYNC04:      //Invoice Detail
         		if(saveRet=="Y") {
					invInfoClearYN="Y"
					setInvoiceInfomationClear();
				} else {
					if(formObj.pay_inv_seq.value != ""){
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
					sheetObjects[3].RemoveAll();
					if(invInfoClearYN!="N"){
						sheetObjects[4].RemoveAll();
					}
					setInvoiceListValue();
					formObj.f_cmd.value=SEARCH01;
					var sParam=ComGetSaveString(sheetObjects[2]);
					sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
					if(invInfoClearYN!="N"){
						for(var i=1; i <= sheetObjects[2].RowCount(); i++){
							if(sheetObjects[2].GetCellValue(i,"sel") == 1){
								currPrcsKnt=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(),"dp_prcs_knt");
								if(currPrcsKnt=="0"){
									var info = {Format:"Int", PointCount:0};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[3].SetColProperty(0, "cost_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"cost_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}else{
									var info = {format:"Float", PointCount:parseInt(currPrcsKnt)};
									sheetObjects[3].SetColProperty(0, "inv_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
									sheetObjects[3].SetColProperty(0, "cost_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"cost_amt", info);
									sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
								}
									combo2.SetSelectCode(sheetObjects[2].GetCellValue(i,"mnr_inv_sts_cd"));
									ComSetObjValue(formObj.ord_vndr_seq, sheetObjects[2].GetCellValue(i,"vndr_seq"));
									ComSetObjValue(formObj.ord_vndr_seq_nm, sheetObjects[2].GetCellValue(i,"vndr_lgl_eng_nm"));
									ComSetObjValue(formObj.mnr_prnr_seq, sheetObjects[2].GetCellValue(i,"mnr_prnr_seq"));
									ComSetObjValue(formObj.vndr_nm, sheetObjects[2].GetCellValue(i,"pay_vndr_lgl_eng_nm"));
																	ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
									ComSetObjValue(formObj.gen_pay_term_cd, sheetObjects[2].GetCellValue(i,"pay_term_dys"));
									ComSetObjValue(formObj.curr_cd, sheetObjects[2].GetCellValue(i,"curr_cd"));
																	target_curr_cd.SetSelectCode(formObj.curr_cd.value,false);
									ComSetObjValue(formObj.inv_no, sheetObjects[2].GetCellValue(i,"wo_no"));
									ComSetObjValue(formObj.inv_status, sheetObjects[2].GetCellValue(i,"mnr_inv_sts_nm"));
									ComSetObjValue(formObj.rcv_dt, sheetObjects[2].GetCellValue(i,"rcv_dt"));
									ComSetObjValue(formObj.iss_dt, sheetObjects[2].GetCellValue(i,"iss_dt"));
								if(currPrcsKnt=="0"){
									formObj.sls_tax_amt.dataformat="int";
									formObj.bzc_amt.dataformat="int";
									formObj.vat_amt.dataformat="int";
									formObj.ttl_amt.dataformat="int";
									formObj.whld_tax_amt.dataformat="int";
									formObj.sls_tax_amt.maxLength=15;
									formObj.bzc_amt.maxLength=15;
									formObj.vat_amt.maxLength=15;
									formObj.ttl_amt.maxLength=15;
									formObj.whld_tax_amt.maxLength=15;
									ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"sls_tax_amt"), "#,###"));
									ComSetObjValue(formObj.bzc_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"mnr_wrk_amt"), "#,###"));
									ComSetObjValue(formObj.vat_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"vat_amt"), "#,###"));
									ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"whld_tax_amt"), "#,###"));
									ComSetObjValue(formObj.ttl_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"ttl_amt"), "#,###"));
								}else{
									formObj.sls_tax_amt.dataformat="float";
									formObj.bzc_amt.dataformat="float";
									formObj.vat_amt.dataformat="float";
									formObj.ttl_amt.dataformat="float";
									formObj.whld_tax_amt.dataformat="float";
									formObj.sls_tax_amt.maxLength=18;
									formObj.bzc_amt.maxLength=18;
									formObj.vat_amt.maxLength=18;
									formObj.ttl_amt.maxLength=18;
									formObj.whld_tax_amt.maxLength=18;
									ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"sls_tax_amt"), "#,###.00"));
									ComSetObjValue(formObj.bzc_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"mnr_wrk_amt"), "#,###.00"));
									ComSetObjValue(formObj.vat_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"vat_amt"), "#,###.00"));
									ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"whld_tax_amt"), "#,###.00"));
									ComSetObjValue(formObj.ttl_amt, ComAddComma2(sheetObjects[2].GetCellValue(i,"ttl_amt"), "#,###.00"));
																	}
									ComSetObjValue(formObj.mnr_inv_rmk, sheetObjects[2].GetCellValue(i,"mnr_inv_rmk"));
									ComSetObjValue(formObj.pay_inv_seq, sheetObjects[2].GetCellValue(i,"pay_inv_seq"));
									ComSetObjValue(formObj.mnr_inv_sts_cd, sheetObjects[2].GetCellValue(i,"mnr_inv_sts_cd"));
									ComSetObjValue(formObj.inv_rgst_no, sheetObjects[2].GetCellValue(i,"inv_rgst_no"));
								break;
							}
						}
						var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", sParam);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
					if(formObj.mnr_inv_sts_cd.value=="HC"){
						ComBtnDisable('btn_Save');
						ComBtnDisable('btn_Delete');
						MnrBtnRename("btn_Confirm","btn_Cancel","AP Cancel");
						ComBtnEnable("btn_Cancel");
					}else{
						ComBtnEnable('btn_Save');
						ComBtnEnable('btn_Delete');
						MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
						ComBtnEnable('btn_Confirm');
					}
					if(comboObjects[0].GetSelectIndex()=="0"){
						ComBtnEnable('btn_Return')
					}else{
						ComBtnDisable('btn_Return')
					}
				}
          		break;
	 		case IBSAVE:        // Save
	          	if(validateForm(sheetObj,formObj,sAction)){
					saveType="1";
					formObj.mnr_inv_sts_cd.value="HS";
					formObj.mnr_grp_tp_cd.value="RPR";
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
						if(State == "S"){
							ComSetObjValue(formObj.pay_inv_seq, ComGetEtcData(sXml, "pay_inv_seq"));
							combo2.SetSelectCode(formObj.mnr_inv_sts_cd.value);
						}
					}
					sheetObj.LoadSaveData(sXml);
				}
                break;
          	case IBSEARCH_ASYNC05:      //Confirm
	          	if(validateForm(sheetObj,formObj,sAction)){
					if(!ComShowCodeConfirm("MNR00330","Confirm")){return false;}
					saveType="3";
					formObj.mnr_inv_sts_cd.value="HC";
					formObj.mnr_grp_tp_cd.value="RPR";
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj,true,true);
			    	if (sParam == "") return;
			    	sParam += "&" + FormQueryString(formObj) +"&"+ ComGetPrefixParam(PrefixSheet2);
			    	var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", sParam);
					if(MnrComGetErrMsg(sXml) == null){
						var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
						if(State == "S"){
							ComSetObjValue(formObj.pay_inv_seq, ComGetEtcData(sXml, "pay_inv_seq"));
							combo2.SetSelectCode(formObj.mnr_inv_sts_cd.value);
						}
					}
					sheetObj.LoadSaveData(sXml);
				}
          		break;
			case IBSEARCH_ASYNC06:      //Reject
	          	if(validateForm(sheetObj,formObj,sAction)){
					if(!ComShowCodeConfirm("MNR00092")){return;}
					saveType="4";
					formObj.mnr_inv_sts_cd.value="HJ";
					formObj.f_cmd.value=MULTI;
					var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", FormQueryString(formObj));
					combo2.SetSelectCode(formObj.mnr_inv_sts_cd.value);
					sheetObj.LoadSaveData(sXml);
				}
				break;
			case IBSEARCH_ASYNC07:      //Store
	          	if(validateForm(sheetObj,formObj,sAction)){
	          		tabObjects[0].SetSelectedIndex(1);
					
					var sXml=MnrGetDataSearchXml(sheetObjects[3], sheetObjects[4]);
					sheetObjects[4].LoadSearchData(sXml,{Sync:1} );
				}
				break;
	 		case IBDELETE:        //Deleting
	          	if(validateForm(sheetObj,formObj,sAction)){
	 				if(!ComShowCodeConfirm("MNR00088")){return false;}
	 				ComOpenWait(true);
					saveType="2";
					formObj.f_cmd.value=REMOVE;
					var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveData(sXml);
					ComOpenWait(false);
				}
                break;
	 		case IBSEARCH_ASYNC08:        //AP calcel
	          	if(validateForm(sheetObj,formObj,sAction)){
	 				if(!ComShowCodeConfirm("MNR00299")){return false;}
					saveType="5";
					formObj.f_cmd.value=REMOVE;
					formObj.mnr_inv_sts_cd.value="HS";
					var sXml=sheetObj.GetSaveData("EES_MNR_0041GS.do", FormQueryString(formObj));
					combo2.SetSelectCode(formObj.mnr_inv_sts_cd.value);
					sheetObj.LoadSaveData(sXml);
				}
                break;
	 		case IBSEARCH_ASYNC09:        //Changing rate of exchange
	          	if(validateForm(sheetObj,formObj,sAction)){
					if(formObj.conv_dp_prcs_knt.value!=""){
						currPrcsKnt=formObj.conv_dp_prcs_knt.value
					}
					if(currPrcsKnt=="0"){
						var info = {Format:"Int", PointCount:0};
						sheetObjects[3].SetColProperty(0, "inv_amt", info);
						sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
						sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
						formObj.sls_tax_amt.dataformat="int";
						formObj.bzc_amt.dataformat="int";
						formObj.vat_amt.dataformat="int";
						formObj.ttl_amt.dataformat="int";
						formObj.whld_tax_amt.dataformat="int";
						formObj.sls_tax_amt.maxLength=15;
						formObj.bzc_amt.maxLength=15;
						formObj.vat_amt.maxLength=15;
						formObj.ttl_amt.maxLength=15;
						formObj.whld_tax_amt.maxLength=15;
						var aFloat=parseFloat(formObj.vat_amt.value.replace(/,/g,""));
						var bFloat=parseFloat(formObj.curr_rt.value.replace(/,/g,""));
						var vatAmt=MnrMakeRound(parseFloat(aFloat * bFloat),0);
						formObj.vat_amt.value=vatAmt;
						formObj.vat_amt.value=ComAddComma2(formObj.vat_amt.value, "#,###");
						var aFloat=parseFloat(formObj.whld_tax_amt.value.replace(/,/g,""));
						var whldTaxAmt=MnrMakeRound(parseFloat(aFloat * bFloat),0);
						formObj.whld_tax_amt.value=whldTaxAmt;
						formObj.whld_tax_amt.value=ComAddComma2(formObj.whld_tax_amt.value, "#,###");
						var aFloat=parseFloat(formObj.ttl_amt.value.replace(/,/g,""));
						var ttlAmt=MnrMakeRound(parseFloat(aFloat * bFloat),0);
						formObj.ttl_amt.value=ttlAmt;
						formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###");
						var aFloat=parseFloat(formObj.sls_tax_amt.value.replace(/,/g,""));
						var slsTaxAmt=MnrMakeRound(parseFloat(aFloat * bFloat),0);
						formObj.sls_tax_amt.value=slsTaxAmt;
						formObj.sls_tax_amt.value=ComAddComma2(formObj.sls_tax_amt.value, "#,###");
					}else{
						var info = {Format:"Float", PointCount:parseInt(currPrcsKnt)};
						sheetObjects[3].SetColProperty(0, "inv_amt", info);
						sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
						sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
						formObj.sls_tax_amt.dataformat="float";
						formObj.bzc_amt.dataformat="float";
						formObj.vat_amt.dataformat="float";
						formObj.ttl_amt.dataformat="float";
						formObj.whld_tax_amt.dataformat="float";
						formObj.sls_tax_amt.maxLength=18;
						formObj.bzc_amt.maxLength=18;
						formObj.vat_amt.maxLength=18;
						formObj.ttl_amt.maxLength=18;
						formObj.whld_tax_amt.maxLength=18;
						var aFloat=parseFloat(formObj.vat_amt.value.replace(/,/g,""));
						var bFloat=parseFloat(formObj.curr_rt.value.replace(/,/g,""));
						var vatAmt=MnrMakeRound(parseFloat(aFloat * bFloat),parseInt(currPrcsKnt));
						formObj.vat_amt.value=vatAmt;
						formObj.vat_amt.value=ComAddComma2(formObj.vat_amt.value, "#,###.00");
						var aFloat=parseFloat(formObj.whld_tax_amt.value.replace(/,/g,""));
						var whldTaxAmt=MnrMakeRound(parseFloat(aFloat * bFloat),parseInt(currPrcsKnt));
						formObj.whld_tax_amt.value=whldTaxAmt;
						formObj.whld_tax_amt.value=ComAddComma2(formObj.whld_tax_amt.value, "#,###.00");
						var aFloat=parseFloat(formObj.ttl_amt.value.replace(/,/g,""));
						var ttlAmt=MnrMakeRound(parseFloat(aFloat * bFloat),2);
						formObj.ttl_amt.value=ttlAmt;
						formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###.00");
						var aFloat=parseFloat(formObj.sls_tax_amt.value.replace(/,/g,""));
						var slsTaxAmt=MnrMakeRound(parseFloat(aFloat * bFloat),parseInt(currPrcsKnt));
						formObj.sls_tax_amt.value=slsTaxAmt;
						formObj.sls_tax_amt.value=ComAddComma2(formObj.sls_tax_amt.value, "#,###.00");
					}

					for(var i=2; i <= (sheetObjects[3].RowCount()+ 1); i++){
						var aFloat=parseFloat(sheetObjects[3].GetCellValue(i,"inv_amt"));
						var bFloat=parseFloat(formObj.curr_rt.value.replace(/,/g,""));
						var invAmt=MnrMakeRound(parseFloat(aFloat * bFloat),parseInt(currPrcsKnt));
						sheetObjects[3].SetCellValue(i,"inv_amt",invAmt,0);
						sheetObjects[3].SetCellValue(i,"inv_curr_cd",target_curr_cd.GetSelectCode(),0);
					}
					for(var i=2; i <= (sheetObjects[4].RowCount()+ 1); i++){
						var aFloat=parseFloat(sheetObjects[4].GetCellValue(i,PrefixSheet2+"inv_amt"));
						var bFloat=parseFloat(formObj.curr_rt.value.replace(/,/g,""));
						var invAmt=MnrMakeRound(parseFloat(aFloat * bFloat),parseInt(currPrcsKnt));
						sheetObjects[4].SetCellValue(i,PrefixSheet2+"inv_amt",invAmt,0);
						sheetObjects[4].SetCellValue(i,PrefixSheet2+"inv_conv_amt",invAmt,0);
						sheetObjects[4].SetCellValue(i,PrefixSheet2+"inv_adj_bzc_amt",0,0);
						sheetObjects[4].SetCellValue(i,PrefixSheet2+"inv_curr_cd",target_curr_cd.GetSelectCode(),0);
						sheetObjects[4].SetCellEditable(i, PrefixSheet2+"inv_adj_bzc_amt", 1);
					}
					
					formObj.curr_cd.value=target_curr_cd.GetSelectCode();
					formObj.curr_rt.value=1;
					calcGamount();
				}
                break;
			case IBCLEAR:      // Initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//Retrieving combo data
					var sCondition=new Array (
						new Array("MnrGenCd","CD00026", "COMMON"),	//Repair Invoice Search Type
						new Array("MnrGenCd","CD00027", "COMMON"),	//Repair Invoice Status Code
						new Array("MnrGenCd","CD00004", "COMMON"),	//System Verification Result Code
						new Array("MdmOrganization","RPRINV",currOfcCd),
						new Array("MdmCurrency","","COMMON")
					);
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//Setting combo
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//Initializing each combo of sheets
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Repair Invoice Search Type
								if(i==0) {
									comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 1){
										comboObjects[0].SetSelectCode(tempText[0]);
									}
								//Repair Invoice Status Code
								} else if(i==1){
									combo2.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){
										combo2.InsertItem(0, "NEW" ,"NEW");
										combo2.SetSelectCode("NEW");
										combo2.SetEnable(0);
									}
								}else if(i==3){
									wo_ofc_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}else if(i==4){
									target_curr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								}
							}
							//System Verification Result Code
							if(i==2) {
								sheetObjects[3].SetColProperty(0,"mnr_vrfy_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
								sheetObjects[4].SetColProperty(0,PrefixSheet2+"mnr_vrfy_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							}
							if(i==3) {
								if(comboList[i].length == 1){
									wo_ofc_cd.SetSelectCode(tempText[0]);
								}else{
									wo_ofc_cd.SetSelectCode(currOfcCd);
								}
							}
						}
					}
				}
				initLoader=1;
				setInvoiceListClear();
				setInvoiceInfomationClear();
				setInvoiceTaxOpt();
				sheetObjects[4].SetColHidden(PrefixSheet2+"inv_no",1);
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
				ComBtnDisable('btn_Return');
				break;
			case IBRESET:      // Initializing exclude invoice list
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				//setInvoiceListClear();
				setInvoiceInfomationClear();
				setInvoiceTaxOpt();
				sheetObjects[4].SetColHidden(PrefixSheet2+"inv_no",1);
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				MnrBtnRename("btn_Cancel","btn_Confirm","Confirm");
				ComBtnDisable('btn_Return');
				break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
			if(sAction==IBSEARCH) { //Retrive
			    var cboCode=formObj.combo1.value;
				if(cboCode=="WI"){
					if(ComGetDaysBetween(formObj.t1_from_dt.value, formObj.t1_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","Req. Date","3Months")
						return false;
					}
				}else if (cboCode=="MI"){
					if(ComGetDaysBetween(formObj.t2_from_dt.value, formObj.t2_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","W/O Date","3Months")
						return false;
					}
					var arrWoNo=formObj.t2_mnr_ord_seq.value.split(",");
					if(arrWoNo!=""){
						for(i=0;i<arrWoNo.length;i++){
							if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
								ComShowCodeMessage("MNR00010","W/O No");
								return false;
							}
						}
					}
				}else if(cboCode=="CO"){
					if(ComGetDaysBetween(formObj.t3_from_dt.value, formObj.t3_to_dt.value) > 90){
						ComShowCodeMessage("MNR00325","INV Date","3Months")
						return false;
					}
				}
			}else if(sAction==IBSEARCH_ASYNC03) { //Work Order Detail
				var updateCnt = sheetObjects[1].RowCount("U");
				if(updateCnt == 0 ){
					ComShowCodeMessage("MNR00038");
					return false;
				}else if(updateCnt > 1000){
					ComShowCodeMessage("MNR00365");
					return false;
				}
				var vend_seq="";
				for(var i=1; i <= sheetObjects[1].RowCount(); i++){
					if(sheetObjects[1].GetCellValue(i,"sel") == 1){
						vend_seq=sheetObjects[1].GetCellValue(i,"vndr_seq");
						break;
					}
				}
				for(var i=1; i <= sheetObjects[1].RowCount(); i++){
					if(sheetObjects[1].GetCellValue(i,"sel") == 1){
						if(vend_seq!=sheetObjects[1].GetCellValue(i,"vndr_seq")){
							ComShowCodeMessage("MNR00098",vend_seq,sheetObjects[1].GetCellValue(i,"vndr_seq"));
							return false;
						}
//						if(formObj.ord_vndr_seq.value!="" && formObj.ord_vndr_seq.value!=sheetObjects[1].GetCellValue(i,"vndr_seq")){
//							ComShowCodeMessage("MNR00098",formObj.ord_vndr_seq.value,sheetObjects[1].GetCellValue(i,"vndr_seq"));
//							return false;
//						}
					}
				}
			}else if(sAction==IBSEARCH_ASYNC04) { //Retrieving Invoice Detail
				if (invInfoClearYN!='N'){
					var selChk="";
					for(var i=1; i <= sheetObjects[2].RowCount(); i++){
						if(sheetObjects[2].GetCellValue(i,"sel") == 1){
							selChk="Y";
							break;
						}
					}
					if(selChk==""){
						ComShowCodeMessage("MNR00038");
						return false;
					}
				}
			}else if(sAction==IBSAVE) {//save
				if(sheetObjects[4].RowCount()<1){
					ComShowCodeMessage("MNR00281");
					return false;
				}
				var	tot=0;
				
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice No ");
					ComSetFocus(formObj.inv_no);
					return false;
				}
				if(formObj.mnr_prnr_seq.value==""){
					ComShowCodeMessage("MNR00036","Pay S/P ");
					return false;
				}
				if(formObj.rcv_dt.value==""){
					ComShowCodeMessage("MNR00172","Receive DT ");
					ComSetFocus(formObj.rcv_dt);
					return false;
				}
				if(formObj.iss_dt.value==""){
					ComShowCodeMessage("MNR00172","Issue DT ");
					ComSetFocus(formObj.iss_dt);
					return false;
				}
				if(formObj.bzc_amt.value==""){
					ComShowCodeMessage("MNR00172","INV AMT ");
					ComSetFocus(formObj.bzc_amt);
					return false;
				}
				if(formObj.sls_tax_amt.value==""){
					ComShowCodeMessage("MNR00172","SALES TAX AMT ");
					ComSetFocus(formObj.sls_tax_amt);
					return false;
				}
				if(formObj.vat_amt.value==""){
					ComShowCodeMessage("MNR00172","V.A.Tax ");
					ComSetFocus(formObj.vat_amt);
					return false;
				}
				if(formObj.whld_tax_amt.value==""){
					ComShowCodeMessage("MNR00172","W.H.Tax ");
					ComSetFocus(formObj.whld_tax_amt);
					return false;
				}
				var rcvDt=formObj.rcv_dt.value.replace(/-/g,"");
				var issDt=formObj.iss_dt.value.replace(/-/g,"");
				var toDay=ComGetNowInfo().replace(/-/g,"");
				if(issDt > toDay){
					ComShowCodeMessage("MNR00233");
					return false;
				}
				if(issDt > rcvDt){
					ComShowCodeMessage("MNR00234");
					return false;
				}
				if(rcvDt > toDay){
					ComShowCodeMessage("MNR00235");
					return false;
				}
				//Validating value
				var ttlAmt="0";
				var calAmt="0";
				if(currPrcsKnt=="0"){
					var bzcAmt=MnrMakeRound(parseFloat(formObj.bzc_amt.value.replace(/,/g,"")),0);
					var slsTaxAmt=MnrMakeRound(parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")),0);
					var vatAmt=MnrMakeRound(parseFloat(formObj.vat_amt.value.replace(/,/g,"")),0);
					var whldTaxAmt=MnrMakeRound(parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")),0);
					calAmt=MnrMakeRound(parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)),0);
					ttlAmt=MnrMakeRound(parseFloat(formObj.ttl_amt.value.replace(/,/g,"")),0);
				}else{
					var bzcAmt=MnrMakeRound(parseFloat(formObj.bzc_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var slsTaxAmt=MnrMakeRound(parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var vatAmt=MnrMakeRound(parseFloat(formObj.vat_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var whldTaxAmt=MnrMakeRound(parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					calAmt=MnrMakeRound(parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)),parseInt(currPrcsKnt));
					ttlAmt=MnrMakeRound(parseFloat(formObj.ttl_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
				}
				if(calAmt != ttlAmt ){
					ComShowCodeMessage("MNR00280");
					ComSetFocus(formObj.ttl_amt);
					return false;
				}
				
				for(var i=2; i <= (sheetObjects[4].RowCount()+ 1); i++){
					tot +=  eval(sheetObjects[4].GetCellValue(i, PrefixSheet2+"inv_amt"));
					if(sheetObjects[4].GetCellValue(i,PrefixSheet2+"rpr_rslt_dt") == ""){
						ComShowCodeMessage("MNR00295");
						return false;
					}
					sheetObjects[4].SetRowStatus(i,"I");
				}
			}
			else if(sAction==IBSEARCH_ASYNC05) {//Confirm
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice Data ");
					return false;
				}
				if(sheetObjects[4].RowCount()<1){
					ComShowCodeMessage("MNR00281");
					return false;
				}
				
				if(formObj.mnr_prnr_seq.value==""){
					ComShowCodeMessage("MNR00036","Pay S/P ");
					return false;
				}
				var rcvDt=formObj.rcv_dt.value.replace(/-/g,"");
				var issDt=formObj.iss_dt.value.replace(/-/g,"");
				var toDay=ComGetNowInfo().replace(/-/g,"");
				if(issDt > toDay){
					ComShowCodeMessage("MNR00233");
					return false;
				}
				if(issDt > rcvDt){
					ComShowCodeMessage("MNR00234");
					return false;
				}
				if(rcvDt > toDay){
					ComShowCodeMessage("MNR00235");
					return false;
				}
				//Validating value
				var ttlAmt="0";
				var calAmt="0";
				if(currPrcsKnt=="0"){
					var bzcAmt=MnrMakeRound(parseFloat(formObj.bzc_amt.value.replace(/,/g,"")),0);
					var slsTaxAmt=MnrMakeRound(parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")),0);
					var vatAmt=MnrMakeRound(parseFloat(formObj.vat_amt.value.replace(/,/g,"")),0);
					var whldTaxAmt=MnrMakeRound(parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")),0);
					calAmt=MnrMakeRound(parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)),0);
					ttlAmt=MnrMakeRound(parseFloat(formObj.ttl_amt.value.replace(/,/g,"")),0);
				}else{
					var bzcAmt=MnrMakeRound(parseFloat(formObj.bzc_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var slsTaxAmt=MnrMakeRound(parseFloat(formObj.sls_tax_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var vatAmt=MnrMakeRound(parseFloat(formObj.vat_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					var whldTaxAmt=MnrMakeRound(parseFloat(formObj.whld_tax_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
					calAmt=MnrMakeRound(parseFloat(parseFloat(bzcAmt) + parseFloat(vatAmt) - parseFloat(whldTaxAmt)),parseInt(currPrcsKnt));
					ttlAmt=MnrMakeRound(parseFloat(formObj.ttl_amt.value.replace(/,/g,"")),parseInt(currPrcsKnt));
				}
				if(calAmt != ttlAmt ){
					ComShowCodeMessage("MNR00280");
					ComSetFocus(formObj.ttl_amt);
					return false;
				}
				
				for(var i=2; i <= (sheetObjects[4].RowCount()+ 1); i++){
				    if(sheetObjects[4].GetCellValue(i,PrefixSheet2+"mnr_wo_tp_cd") == "EST" && sheetObjects[4].GetCellValue(i,PrefixSheet2+"rpr_rslt_dt") == ""){
						ComShowCodeMessage("MNR00172","Repair Date ");
						return false;
					}
				    sheetObjects[4].SetRowStatus(i,"I");
				}
			}
			else if(sAction==IBSEARCH_ASYNC06) {//Reject
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00172","Invoice Data ");
					return false;
				}
				var rcvDt=formObj.rcv_dt.value.replace(/-/g,"");
				var issDt=formObj.iss_dt.value.replace(/-/g,"");
				var toDay=ComGetNowInfo().replace(/-/g,"");
				if(issDt > toDay){
					ComShowCodeMessage("MNR00233");
					return false;
				}
				if(issDt > rcvDt){
					ComShowCodeMessage("MNR00234");
					return false;
				}
				if(rcvDt > toDay){
					ComShowCodeMessage("MNR00235");
					return false;
				}
			}
			else if(sAction==IBDELETE) {
				if(formObj.inv_no.value==""){
					ComShowCodeMessage("MNR00089");
					return false;
				}
			}
			else if(sAction==IBSEARCH_ASYNC07) {  //Stroe
				if(tabObjects[0].GetSelectedIndex() == 0){
					var chk=""
						for(var i=2; i <= (sheetObjects[3].RowCount()+ 1); i++){
							if(sheetObjects[3].GetCellValue(i,"Check")==1){
								chk="Y"
							}
						}
						if (chk==""){
							ComShowCodeMessage("MNR00097");
							return false;
						}
						var isDupWo=false;
						var DupWo="";
						for(var i=2; i <= (sheetObjects[3].RowCount()+ 1); i++){
							for(var j=2; j <= (sheetObjects[4].RowCount()+ 1); j++){
								if(sheetObjects[3].GetCellValue(i,"Check") == 1){
									if(sheetObjects[3].GetCellValue(i,"wo_no") ==  sheetObjects[4].GetCellValue(j,PrefixSheet2+"wo_no") && sheetObjects[3].GetCellValue(i,"ord_dtl_seq")==  sheetObjects[4].GetCellValue(j,PrefixSheet2+"ord_dtl_seq")){
										isDupWo=true;
										if(DupWo == ""){
											DupWo=sheetObjects[3].GetCellValue(i,"wo_no");
										} else {
											DupWo=DupWo + "," + sheetObjects[3].GetCellValue(i,"wo_no");
										}
									}
									if(sheetObjects[3].GetCellValue(i,"inv_curr_cd") !=  sheetObjects[4].GetCellValue(j,PrefixSheet2+"inv_curr_cd")){
										ComShowCodeMessage("MNR00025", "INV Curr ");
										return false;
									}
								}
							}
						}
						if(isDupWo){
							ComShowCodeMessage("MNR00178","Verified List ","W/O no",DupWo);
							return false;
						}
				}
				
			}
			else if(sAction==IBSEARCH_ASYNC09) {  //Changing rate of exchange
				if(chkVerifyConv==""){
					if(sheetObjects[4].RowCount()<1){
						ComShowCodeMessage("MNR00281");
						return false;
					}
					if(formObj.rcv_dt.value==""){
						ComShowCodeMessage("MNR00172","Receive DT ");
						ComSetFocus(formObj.rcv_dt);
						return false;
					}
					if(formObj.iss_dt.value==""){
						ComShowCodeMessage("MNR00172","Issue DT ");
						ComSetFocus(formObj.iss_dt);
						return false;
					}
					var rcvDt=formObj.rcv_dt.value.replace(/-/g,"");
					var issDt=formObj.iss_dt.value.replace(/-/g,"");
					var toDay=ComGetNowInfo().replace(/-/g,"");
					if(issDt > toDay){
						ComShowCodeMessage("MNR00233");
						return false;
					}
					if(issDt > rcvDt){
						ComShowCodeMessage("MNR00234");
						return false;
					}
					if(rcvDt > toDay){
						ComShowCodeMessage("MNR00235");
						return false;
					}
					if(formObj.curr_rt.value =="" || formObj.curr_rt.value =="0" || formObj.curr_rt.value =="0.00"){
						ComShowCodeMessage("MNR00175", "EX.Rate");
						return false;
					}
					for(var j=2; j <= (sheetObjects[4].RowCount()+ 1); j++){
						if(sheetObjects[4].GetCellValue(j,PrefixSheet2+"inv_curr_cd")!=formObj.curr_cd.value){
							ComShowCodeMessage("MNR00025", "INV Curr ");
							return false;
						}
					}
					if(sheetObjects[4].RowCount()>0){
						if(!ComShowCodeConfirm("MNR00328",formObj.curr_cd.value,target_curr_cd.GetSelectCode())){return false;}
					}
				}
			}
        return true;
    }
	/**
     * Activating tab for selected
     */
    function changeKind(nItem)
    {
        var objs = $(".hideShow");
		for (var i=0; i < objs.length; i ++){
			if (i != nItem) {
				objs[i].style.display="none";
				$(".hideShow_"+ i +"_sheet").css("display","none");
			}else{
				objs[nItem].style.display="block";
				$(".hideShow_"+ nItem +"_sheet").css("display","block");
			}
		}
			
		var obj = $(".selectComboLayer");
		
		if(nItem=="2"){
			$(obj).css("visibility","hidden");
		}else{
			$(obj).css("visibility","visible");
		}
    }
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		eval("document.form." + ret_val + ".value='';");
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		if (tempText != "")
	        tempText=tempText.substr(0, tempText.length - 1);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			var idx=combo1.GetSelectIndex();
			if(idx=="0"){
				formObj.t1_vndr_seq.value=aryPopupData[0][2];
				formObj.t1_vndr_lgl_eng_nm.value=aryPopupData[0][4];
			}else if(idx=="1"){
				formObj.t2_vndr_seq.value=aryPopupData[0][2];
				formObj.t2_vndr_lgl_eng_nm.value=aryPopupData[0][4];
			}else{
				formObj.t3_vndr_seq.value=aryPopupData[0][2];
				formObj.t3_vndr_lgl_eng_nm.value=aryPopupData[0][4];
			}
		}
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Pay_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.mnr_prnr_seq.value=aryPopupData[0][2];
			formObj.vndr_nm.value=aryPopupData[0][4];
		}
	}
	
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_InvCrr(inv_no) {
		var formObj=document.form;
		
		solFlg = "Y";
		sol_inv_no = inv_no;
		comboObjects[0].SetSelectCode("CO");
		var idx=comboObjects[0].GetSelectIndex();
		doActionIBSheet(sheetObjects[3],document.form,IBRESET);
		doActionIBSheet(sheetObjects[idx],document.form,IBSEARCH);
		
	}
	
	/**
	 * Checking vndr_seq
	 */
	function vndr_seq_confirm(obj){
		var formObj=document.form;
		if(obj.value != ""){
			//Retrieving service provider
			var sCondition=new Array (new Array("MdmVendor",obj.value,"COMMON"))
			//Setting when returned data exist
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			if(comboList[0] != null){
				var tempText=comboList[0][0].split("|");
				if(obj.name=="t1_vndr_seq"){
					formObj.t1_vndr_lgl_eng_nm.value=tempText[1];
				}else if(obj.name=="t2_vndr_seq"){
					formObj.t2_vndr_lgl_eng_nm.value=tempText[1];
				}else if(obj.name=="t3_vndr_seq"){
					formObj.t3_vndr_lgl_eng_nm.value=tempText[1];
				}else if(obj.name=="mnr_prnr_seq"){
					formObj.vndr_nm.value=tempText[1];
				}
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				if(obj.name=="t1_vndr_seq"){
					ComSetObjValue(formObj.t1_vndr_lgl_eng_nm, "");
					ComSetObjValue(formObj.t1_vndr_seq, "");
					ComSetFocus(formObj.t1_vndr_seq);
				}else if(obj.name=="t2_vndr_seq"){
					ComSetObjValue(formObj.t2_vndr_lgl_eng_nm, "");
					ComSetObjValue(formObj.t2_vndr_seq, "");
					ComSetFocus(formObj.t2_vndr_seq);
				}else if(obj.name=="t3_vndr_seq"){
					ComSetObjValue(formObj.t3_vndr_lgl_eng_nm, "");
					ComSetObjValue(formObj.t3_vndr_seq, "");
					ComSetFocus(formObj.t3_vndr_seq);
				}else if(obj.name=="mnr_prnr_seq"){
					ComSetObjValue(formObj.vndr_nm, "");
					ComSetObjValue(formObj.mnr_prnr_seq, "");
					ComSetFocus(formObj.mnr_prnr_seq);
				}
			}
		}
	}
	function setInvoiceListValue() {
		var formObj=document.form;
		var kind=combo1.GetSelectCode();
		if(kind=="WI"){
			ComSetObjValue(formObj.from_dt, formObj.t1_from_dt.value);
			ComSetObjValue(formObj.to_dt, formObj.t1_to_dt.value);
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t1_mnr_ord_seq.value);
			ComSetObjValue(formObj.vndr_seq, formObj.t1_vndr_seq.value);
		}else if(kind=="MI"){
			ComSetObjValue(formObj.from_dt, formObj.t2_from_dt.value);
			ComSetObjValue(formObj.to_dt, formObj.t2_to_dt.value);
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t2_mnr_ord_seq.value);
			ComSetObjValue(formObj.vndr_seq, formObj.t2_vndr_seq.value);
		}else if(kind=="CO"){
			ComSetObjValue(formObj.from_dt, formObj.t3_from_dt.value);
			ComSetObjValue(formObj.to_dt, formObj.t3_to_dt.value);
			ComSetObjValue(formObj.mnr_ord_seq, formObj.t3_mnr_ord_seq.value);
			ComSetObjValue(formObj.vndr_seq, formObj.t3_vndr_seq.value);
		}
		ComSetObjValue(formObj.inv_sch_type_code, combo1.GetSelectCode());
	}
	function setInvoiceListClear() {
		var formObj=document.form;
		formObj.t1_from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t1_to_dt.value=ComGetNowInfo();
		formObj.t2_from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t2_to_dt.value=ComGetNowInfo();
		formObj.t3_from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -30);
		formObj.t3_to_dt.value=ComGetNowInfo();
		ComClearManyObjects(
			formObj.t1_mnr_ord_seq
			,formObj.t2_mnr_ord_seq
			,formObj.t3_mnr_ord_seq
			,formObj.t1_vndr_seq
			,formObj.t1_vndr_lgl_eng_nm
			,formObj.t2_vndr_seq
			,formObj.t2_vndr_lgl_eng_nm
			,formObj.t3_vndr_seq
			,formObj.t3_vndr_lgl_eng_nm)
//		for(var i = 0; i < sheetObjects.length; i++){
//			sheetObjects[i].RemoveAll();
//		}
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		tabObjects[0].SetSelectedIndex(0);
		combo1.SetSelectCode("MI");
		wo_ofc_cd.SetSelectCode(currOfcCd);
		saveEndYN="";
		saveType="";
		invInfoClearYN="";
	}
	function setInvoiceInfomationClear() {
		var formObj=document.form;
		ComClearManyObjects(
			formObj.inv_no
			,formObj.rcv_dt
			,formObj.iss_dt
			,formObj.ord_vndr_seq
			,formObj.ord_vndr_seq_nm
			,formObj.mnr_prnr_seq
			,formObj.vndr_nm
			,formObj.agmt_ofc_cd
			,formObj.curr_cd
			,formObj.gen_pay_term_cd
			,formObj.mnr_inv_rmk
			,formObj.sls_tax_amt
			,formObj.bzc_amt
			,formObj.vat_amt
			,formObj.ttl_amt
			,formObj.whld_tax_amt
			,formObj.curr_rt
		);
		combo2.SetSelectCode("NEW");
		target_curr_cd.SetSelectCode("",false);
		formObj.inv_status.value="NEW"
		formObj.pay_inv_seq.value="";
		formObj.mnr_inv_sts_cd.value="";
		formObj.inv_rgst_no.value="";
		formObj.conv_dp_prcs_knt.value="";
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		sheetObjects[5].RemoveAll();
		sheetObjects[6].RemoveAll();
	}
	function calcGamount() {
		var formObj=document.form;
		if(currPrcsKnt=="0"){
			if(formObj.vat_amt.value.length >= 15){
				formObj.vat_amt.value=formObj.vat_amt.value.substr(0,15)
			}
			vat=formObj.vat_amt.value.replace(/,/g,"");
			formObj.vat_amt.value=ComAddComma2(formObj.vat_amt.value, "#,###")
			if(vat=="") vat="0";
			if(formObj.whld_tax_amt.value.length>=15){
				formObj.whld_tax_amt.value=formObj.whld_tax_amt.value.substr(0,15)
			}
			wht=formObj.whld_tax_amt.value.replace(/,/g,"");
			formObj.whld_tax_amt.value=ComAddComma2(formObj.whld_tax_amt.value, "#,###")
			if(wht=="")	wht="0";
			if(formObj.sls_tax_amt.value.length>=15){
				formObj.sls_tax_amt.value=formObj.sls_tax_amt.value.substr(0,15)
			}
			sta=formObj.sls_tax_amt.value.replace(/,/g,"");
			formObj.sls_tax_amt.value=ComAddComma2(formObj.sls_tax_amt.value, "#,###")
			if(sta=="")	sta="0";
			var amt=MnrMakeRound(parseFloat(parseFloat(sheetObjects[4].GetSumValue(0,PrefixSheet2+"inv_amt")) + parseFloat(sta)),0);
			formObj.bzc_amt.value=ComAddComma2(amt, "#,###");
			if(!isAmerican){
				formObj.ttl_amt.value=Math.round((parseFloat(amt) + parseFloat(vat) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###")
			}else{
				formObj.ttl_amt.value=Math.round((parseFloat(amt) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###")
			}
		}else{
			val=formObj.vat_amt.value.split(".")
			val1=val[0];
			val2=val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.vat_amt.value=val1.substr(0,15) + "." + val2
			}
			vat=formObj.vat_amt.value.replace(/,/g,"");
			formObj.vat_amt.value=ComAddComma2(formObj.vat_amt.value, "#,###.00")
			if(vat=="") vat="0.00";
			val=formObj.whld_tax_amt.value.split(".")
			val1=val[0];
			val2=val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.whld_tax_amt.value=val1.substr(0,15) + "." + val2
			}
			wht=formObj.whld_tax_amt.value.replace(/,/g,"");
			formObj.whld_tax_amt.value=ComAddComma2(formObj.whld_tax_amt.value, "#,###.00")
			if(wht=="")	wht="0.00";
			val=formObj.sls_tax_amt.value.split(".")
			val1=val[0];
			val2=val[1];
			if(val2 == undefined) val2="0";
			if(val1.length>=15){
				formObj.sls_tax_amt.value=val1.substr(0,15) + "." + val2
			}
			sta=formObj.sls_tax_amt.value.replace(/,/g,"");
			formObj.sls_tax_amt.value=ComAddComma2(formObj.sls_tax_amt.value, "#,###.00")
			if(sta=="")	sta="0.00";
			var amt=MnrMakeRound(parseFloat(parseFloat(sheetObjects[4].GetSumValue(0,PrefixSheet2+"inv_amt")) + parseFloat(sta)),parseInt(currPrcsKnt));
			formObj.bzc_amt.value=ComAddComma2(amt, "#,###.00");
			if(!isAmerican){
				formObj.ttl_amt.value=Math.round((parseFloat(amt) + parseFloat(vat) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###.00");
			}else{
				formObj.ttl_amt.value=Math.round((parseFloat(amt) - parseFloat(wht))*1000)/1000;
				formObj.ttl_amt.value=ComAddComma2(formObj.ttl_amt.value, "#,###.00");
			}
		}
	}
	function setInvoiceTaxOpt() {
		//Retrieving americas office
		var sCondition=new Array (
			new Array("MnrGenCd","CD00089", "COMMON"),
			new Array("MnrGenCd","CD00090", "COMMON")
		);
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition)
		var isAmeOfc=false;
		for(var j=0; j < comboList[0].length;j++){
			var tempText=comboList[0][j].split("|");
			if(currOfcCd == tempText[0]){
				isAmeOfc=true;
				isAmerican=true;
				break;
			}
		}
		var formObj=document.form;
		if(isAmeOfc){
			MnrFormSetReadOnly(formObj,true,"vat_amt");
			MnrFormSetReadOnly(formObj,false,"sls_tax_amt");
		} else {
			MnrFormSetReadOnly(formObj,false,"vat_amt");
			MnrFormSetReadOnly(formObj,true,"sls_tax_amt");
		}
		var isBothOfc=false;
		for(var j=0; j < comboList[1].length;j++){
			var tempText=comboList[1][j].split("|");
			if(currOfcCd == tempText[0]){
				isBothOfc=true;
				isAmerican=true;
				break;
			}
		}
		var formObj=document.form;
		if(isBothOfc){
			MnrFormSetReadOnly(formObj,false,"vat_amt");
			MnrFormSetReadOnly(formObj,false,"sls_tax_amt");
		}
	}
	/**
	 * getEES_MNR_143 : Processing by received value of pop-up screen
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	function getEES_MNR_0143(rArray,ret_val){
    	var formObj=document.form;
		var firstSelect=0;
		comboValue=ret_val[0];
		if(formObj.ord_vndr_seq.value!="" && formObj.ord_vndr_seq.value!=ret_val[0]){
			ComShowCodeMessage("MNR00098",formObj.ord_vndr_seq.value,ret_val[0]);
			return false;
		}
		for(var i=0;i <  rArray.length;i++){
			var Row=sheetObjects[5].DataInsert(-1);
			if(i == 0)
				firstSelect=Row;
			sheetObjects[5].SetCellValue(Row,"wo_no",rArray[i][0],0);
			sheetObjects[5].SetCellValue(Row,"g_amnt",rArray[i][2],0);
 		}
		formObj.f_cmd.value=SEARCH01;
		sheetObjects[3].RemoveAll();
		if(formObj.pay_inv_seq.value==""){
				ComSetObjValue(formObj.ord_vndr_seq, ret_val[0]);
				ComSetObjValue(formObj.ord_vndr_seq_nm, ret_val[1]);
				ComSetObjValue(formObj.mnr_prnr_seq, ret_val[0]);
				ComSetObjValue(formObj.vndr_nm, ret_val[1]);
				ComSetObjValue(formObj.agmt_ofc_cd, currOfcCd);
				ComSetObjValue(formObj.gen_pay_term_cd, ret_val[2]);
				ComSetObjValue(formObj.curr_cd, ret_val[3]);
				target_curr_cd.SetSelectCode(formObj.curr_cd.value, false);
		}
		if(target_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
			target_curr_cd.SetSelectCode(formObj.curr_cd.value,false);
		}
		comboObjects[0].SetSelectCode("MI");
		ComSetObjValue(formObj.inv_sch_type_code, combo1.GetSelectCode());
		tabObjects[0].SetSelectedIndex(0);
		var sParam=ComGetSaveString(sheetObjects[5]);
		if (sParam == "") return;
		sParam += "&" + FormQueryString(formObj);
		var sXml=sheetObjects[3].GetSaveData("EES_MNR_0041GS.do", sParam);
		currPrcsKnt=ComGetEtcData(sXml, "dp_prcs_knt");
		if(currPrcsKnt=="0"){
			var info = {Format:"Int", PointCount:0};
			sheetObjects[3].SetColProperty(0, "inv_amt", info);
			sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
			sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
			formObj.bzc_amt.dataformat="int";
			formObj.vat_amt.dataformat="int";
			formObj.ttl_amt.dataformat="int";
			formObj.whld_tax_amt.dataformat="int";
			formObj.sls_tax_amt.dataformat="int";
			formObj.bzc_amt.maxLength=15;
			formObj.vat_amt.maxLength=15;
			formObj.ttl_amt.maxLength=15;
			formObj.whld_tax_amt.maxLength=15;
			formObj.sls_tax_amt.maxLength=15;
			ComSetObjValue(formObj.bzc_amt, ComAddComma2(MnrNullToZero(formObj.bzc_amt.value), "#,###"));
			ComSetObjValue(formObj.vat_amt, ComAddComma2(MnrNullToZero(formObj.vat_amt.value), "#,###"));
			ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(MnrNullToZero(formObj.whld_tax_amt.value), "#,###"));
			ComSetObjValue(formObj.ttl_amt, ComAddComma2(MnrNullToZero(formObj.ttl_amt.value), "#,###"));
			ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(MnrNullToZero(formObj.sls_tax_amt.value), "#,###"));
		}else{
			var info = {Format:"Float", PointCount:parseInt(currPrcsKnt)};
			sheetObjects[3].SetColProperty(0, "inv_amt", info);
			sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_amt", info);
			sheetObjects[4].SetColProperty(0, PrefixSheet2+"inv_adj_bzc_amt", info);
			formObj.bzc_amt.dataformat="float";
			formObj.vat_amt.dataformat="float";
			formObj.ttl_amt.dataformat="float";
			formObj.whld_tax_amt.dataformat="float";
			formObj.sls_tax_amt.dataformat="float";
			formObj.bzc_amt.maxLength=18;
			formObj.vat_amt.maxLength=18;
			formObj.ttl_amt.maxLength=18;
			formObj.whld_tax_amt.maxLength=18;
			formObj.sls_tax_amt.maxLength=18;
			ComSetObjValue(formObj.bzc_amt, ComAddComma2(MnrNullToZero(formObj.bzc_amt.value), "#,###.00"));
			ComSetObjValue(formObj.vat_amt, ComAddComma2(MnrNullToZero(formObj.vat_amt.value), "#,###.00"));
			ComSetObjValue(formObj.whld_tax_amt, ComAddComma2(MnrNullToZero(formObj.whld_tax_amt.value), "#,###.00"));
			ComSetObjValue(formObj.ttl_amt, ComAddComma2(MnrNullToZero(formObj.ttl_amt.value), "#,###.00"));
			ComSetObjValue(formObj.sls_tax_amt, ComAddComma2(MnrNullToZero(formObj.sls_tax_amt.value), "#,###.00"));
		}
		sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
		sheetObjects[5].RemoveAll();
    }
	function setGetRowBackColorChange(){
		var Row=sheetObjects[4].GetSelectRow();
		if(sheetObjects[4].GetCellValue(Row,  PrefixSheet2+"rpr_rslt_dt")==""){
			sheetObjects[4].SetRowBackColor(Row,"#F7E5E1");
		}else{
			sheetObjects[4].SetRowBackColor(Row,"#FFFFFF");
		}
	}
	function chkCurrXchRt(){
		var formObj=document.form;
		if(formObj.rcv_dt.value==""){
			ComShowCodeMessage("MNR00172","Receive DT ");
			ComSetFocus(formObj.rcv_dt);
			return false;
		}
		var rcvDt=formObj.rcv_dt.value.replace(/-/g,"");
		var toDay=ComGetNowInfo().replace(/-/g,"");
		if(rcvDt > toDay){
			ComShowCodeMessage("MNR00235");
			formObj.rcv_dt.value="";
			return false;
		}
		if(target_curr_cd.GetSelectCode()!= formObj.curr_cd.value){
		    var retVal="";
			formObj.curr_rt.dataformat="float";
			retVal=MnrGetCurrXchRt(sheetObjects[0],formObj.rcv_dt.value.replace(/-/g,"").substr(0,6),target_curr_cd.GetSelectCode(),formObj.curr_cd.value);
			retVal=retVal.split(",");
			formObj.curr_rt.value=retVal[0];
			formObj.conv_dp_prcs_knt.value=retVal[1];
			ComSetObjValue(formObj.curr_rt, ComAddComma2(formObj.curr_rt.value, "#,###.00"));
		}else{
			formObj.curr_rt.value="1";
		}
	}
	function chkIssDt(){
		var formObj=document.form;
		var issDt=formObj.iss_dt.value.replace(/-/g,"");
		var toDay=ComGetNowInfo().replace(/-/g,"");
		if(issDt > toDay){
			ComShowCodeMessage("MNR00233");
			formObj.iss_dt.value="";
			return false;
		}
	}
    function MnrGetDataSearchXml(sheet_obj, sheet2_obj)  {
      var rowXml="";
      var allXml="<?xml version='1.0'  ?>\n<SHEET>\n  <DATA TOTAL='"+ (sheet2_obj.GetTotalRows()+sheet_obj.GetTotalRows()) +"'>\n";
	  var chk="";
      for (ir=2; ir <= sheet_obj.LastRow()- 1; ir++) {
        rowXml="    <TR>";
		chk="";
        for (ic=0; ic<= sheet_obj.LastCol(); ic++) {
        	var sValue=String(sheet_obj.GetCellValue(ir,ic));
		  if(ic==1 && sValue=="1"){
			sValue="0";
			chk="Y";
          }
          //Making CDATA section (&, <, >)
          if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
            sValue="<![CDATA[" + sValue + "]]>";
          }
          //Making xml document
          rowXml += "<TD>" + sValue + "</TD>";
        }
        rowXml += "</TR>\n";
		if(chk=="Y"){
	 		allXml += rowXml;
		}
      }
      for (ir=2; ir <= sheet2_obj.LastRow()- 1; ir++) {
        rowXml="    <TR>";
        for (ic=0; ic<= sheet2_obj.LastCol(); ic++) {
        	var sValue=String(sheet2_obj.GetCellValue(ir,ic));
		  if(ic==1 && sValue=="1"){
			sValue="0";
          }
          //Making CDATA section (&, <, >)
          if (sValue.indexOf("&") > -1 || sValue.indexOf("<") > -1 || sValue.indexOf(">") > -1) {
            sValue="<![CDATA[" + sValue + "]]>";
          }
          //Making xml document
          rowXml += "<TD>" + sValue + "</TD>";
        }
        rowXml += "</TR>\n";
	 	allXml += rowXml;
      }
      allXml += "  </DATA>\n</SHEET>";
      return allXml;
    }
	function initControl() {
	    //Axon event handling 1. Catching event
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	    //axon_event.addListenerFormat('focus',   'obj_activate',    form);
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
		axon_event.addListenerFormat('change',	 'obj_change',	form);
	}
	/**
	 * Disable event handling <br>
	 **/
	function obj_deactivate(){
		obj=ComGetEvent()
 	    ComChkObjValid(event.srcElement);
	}
	/**
	 * Enable event handling <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
		var obj=ComGetEvent()
		var formObj=document.form;
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "ttl_amt":
	    		case "vat_amt":
	    		case "sls_tax_amt":
	    		case "whld_tax_amt":
					ComSetFocus(obj);
					break;
			}
		}
	}
	function obj_change(){
		var obj=ComGetEvent()
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "t1_vndr_seq":
	        		vndr_seq_confirm(formObj.t1_vndr_seq);
				   	break;
	    		case "t2_vndr_seq":
	        		vndr_seq_confirm(formObj.t2_vndr_seq);
				   	break;
	    		case "t3_vndr_seq":
	        		vndr_seq_confirm(formObj.t3_vndr_seq);
				   	break;
	    		case "mnr_prnr_seq":
	        		vndr_seq_confirm(formObj.mnr_prnr_seq);
				   	break;
	    		case "bzc_amt":
	        		calcGamount();
				   	break;
	    		case "vat_amt":
	        		calcGamount();
				   	break;
	    		case "whld_tax_amt":
	        		calcGamount();
				   	break;
	    		case "sls_tax_amt":
	        		calcGamount();
				   	break;
	    		case "rcv_dt":
					MnrChkDateValid(formObj.rcv_dt,"Receive DT");
					chkCurrXchRt();
				   	break;
	    		case "inv_no":  
	    			
	    			var invNo = checkInvoiceNo(sheetObj,formObj.inv_no.value,formObj.mnr_prnr_seq.value,formObj.pay_inv_seq.value);
	    			
	    			if(invNo != null && invNo != ""){
//	    				ComShowCodeMessage("MNR00371");
	    				formObj.inv_no.value = "";
	    				formObj.inv_no.focus();
	    			}
	    			break;
	    		case "iss_dt":
					MnrChkDateValid(formObj.iss_dt,"Issue DT");
					var issDt=formObj.iss_dt.value.replace(/-/g,"");
					var toDay=ComGetNowInfo().replace(/-/g,"");
					if(issDt > toDay){
						ComShowCodeMessage("MNR00233");
						formObj.iss_dt.value="";
						return false;
					}
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "t1_vndr_seq":
					ComSetObjValue(formObj.t1_vndr_lgl_eng_nm,"")
				   	break;
	    		case "t2_vndr_seq":
					ComSetObjValue(formObj.t2_vndr_lgl_eng_nm,"")
				   	break;
	    		case "t3_vndr_seq":
					ComSetObjValue(formObj.t3_vndr_lgl_eng_nm,"")
				   	break;
	    		case "mnr_prnr_seq":
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;
			}
		}
	}
	/**
	 * Keypress event handling <br>
	 **/
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "int":
//	            if(obj.name=="bzc_amt" || obj.name=="vat_amt" || obj.name=="sls_tax_amt" || obj.name=="whld_tax_amt" || obj.name=="ttl_amt"){
//					ComKeyOnlyNumber(obj, "-");
//				} else {
//					ComKeyOnlyNumber(obj);
//				}
//	            break;
//	        case "float":
//	            if(obj.name=="bzc_amt" || obj.name=="vat_amt" || obj.name=="sls_tax_amt" || obj.name=="whld_tax_amt" || obj.name=="ttl_amt"){
//					ComKeyOnlyNumber(obj, "-.");
//				} else {
//					ComKeyOnlyNumber(obj, ".");
//				}
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//				break;
//	        case "engup":
//	            if(obj.name=="t1_vndr_seq"){
//					ComKeyOnlyNumber(obj);
//				}else if(obj.name=="t2_vndr_seq"){
//					ComKeyOnlyNumber(obj);
//				}else if(obj.name=="t3_vndr_seq"){
//					ComKeyOnlyNumber(obj);
//				}else if(obj.name=="mnr_prnr_seq"){
//					ComKeyOnlyNumber(obj);
//				}else if(obj.name=="inv_no"){
//					ComKeyOnlyAlphabet('uppernum','45');
//				}else if(obj.name=="t1_mnr_ord_seq"){
//					ComKeyOnlyAlphabet('uppernum','44|45');
//				}else if(obj.name=="t2_mnr_ord_seq"){
//					ComKeyOnlyAlphabet('uppernum','44');
//				}else if(obj.name=="t3_mnr_ord_seq"){
//					ComKeyOnlyAlphabet('uppernum','44|45');
//				}else{
//					ComKeyOnlyAlphabet('uppernum');
//				}
//	        break;
//	    }
//	}
