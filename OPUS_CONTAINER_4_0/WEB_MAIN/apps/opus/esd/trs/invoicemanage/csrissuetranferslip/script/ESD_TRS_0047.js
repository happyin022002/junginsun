/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0047.js
*@FileTitle  : CSR I/F Status Inquiry  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------From here the common JavaScript function is defined.------------------*/
/**
 * @extends 
 * @class ESD_TRS_0047 : business script for ESD_TRS_0047
 */
/*------------------From here the common JavaScript function is defined.     ------------------*/
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btns_multisearch":
                    OnPopupClick();
                break;
                case "btns_calendar":
                    getCalendar();
                     break;
                case "btn_retrieve":
                	if (  ComIsEmpty(formObject.mult_csr_no))
                	{  
                    	if (  ComIsEmpty(formObject.fm_eff_dt))
                    	{
                        	ComShowCodeMessage("COM12114" , "From");
                        	return;
                    	}
                     	if (ComIsEmpty(formObject.to_eff_dt))
                    	{
                        	ComShowCodeMessage("COM12114" , "To");
                        	return;
                    	}
                    }
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
				case "btn_new":
					sheetObject.RemoveAll();
					formObject.reset();
					break;
                case "btng_viewapprovalstep":  
            	    var selRow=sheetObject.GetSelectRow();
        	        if(selRow == 0) {
        	            ComShowCodeMessage("COM12176");
        	            return;
        	        }
        	        var height=screen.height; 
                	var width=screen.width;
      	            var w=615;
                    var h=280;
                    var leftpos=width/2 - w/2; 
                	var toppos=height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	if (sheetObject.GetCellValue(selRow, 'csr_number') == undefined || sheetObject.GetCellValue(selRow, 'csr_number') == null ){
                        errMsg=ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}                	
                	var apro_rqst_no=sheetObject.GetCellValue(selRow, "apro_rqst_no");
					if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no == ''||apro_rqst_no == -1 ){
						ComShowCodeMessage('TES40041','Approval Request No');
						return false;
					}                	
                    var url="/opuscntr/COM_ENS_0W1.do?apro_rqst_no="+apro_rqst_no;
                     ComOpenWindow(url,  "COM_ENS_0W1",  "width=640; height=250; help=no; status=no; resizable=no; scroll=no" , false);
        	        break;
                case "btng_editapprovalstep":  
            	    var selRow=sheetObject.GetSelectRow();
        	        if(selRow == 0) {
        	        	ComShowCodeMessage("COM12176");
        	            return;
        	        }
        	        var height=screen.height; 
                	var width=screen.width;
      	            var w=615;
                    var h=280;
                    var leftpos=width/2 - w/2; 
                	var toppos=height/2 - h/2; 
                	if(leftpos<0) leftpos=0;
                	if(toppos<0) toppos=0;
                	if (   sheetObject.GetCellValue(selRow, 'csr_number') == undefined
                			|| sheetObject.GetCellValue(selRow, 'csr_number') == null ){
                        errMsg=ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}                	
                	var apro_rqst_no=sheetObject.GetCellValue(selRow, "apro_rqst_no");
					if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no == ''){
						ComShowCodeMessage('TRS90394','Approval Request No');
						return false;
					}                	
					var v_if_sts=sheetObjects[0].GetCellValue(selRow, 'if_sts_indicator');
                    if(v_if_sts == 'AR') {
                    	var v_csr_no=sheetObject.GetCellValue(selRow, 'csr_number');
                        var v_ofc_cd=document.form.cost_ofc_cd.value;
                        var param='?mode=save&ofc_cd='+v_ofc_cd+'&csr_no='+v_csr_no+'&sub_sys_cd=TRS&classId=COM_ENS_0T1&target_obj_nm=apro_step';
                        ComOpenPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 450, '', 'none', true);
                    }else{
                        ComShowCodeMessage('COM12113','Approval Request Status');
                    }
        	        break;
                case "btng_csrformat":
                    if (sheetObjects[0].RowCount()<= 0){
						return false;
					}
					if (sheetObjects[0].GetSelectRow()== undefined || sheetObjects[0].GetSelectRow()== null || sheetObjects[0].GetSelectRow()== 0){
                        errMsg=ComGetMsg("TRS90036");
                        ComShowMessage(errMsg);
						return false;
					}
					if (   sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number') == undefined	|| sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number') == null ){
                        errMsg=ComGetMsg("TRS90199");
                        ComShowMessage(errMsg);
						return false;
					}
                    doActionIBSheet1(sheetObject2, formObject, IBSEARCH);
                    break;
                case "btng_invoicelistinquiry":
                    if (sheetObjects[0].RowCount()<= 0){
						return false;
					}
					if (sheetObjects[0].GetSelectRow()==undefined || sheetObjects[0].GetSelectRow()==null || sheetObjects[0].GetSelectRow()==0){
                        errMsg=ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
						return false;
					}
					if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_number')==undefined ||
							sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_number')==null) {
                        errMsg=ComGetMsg("TRS90199" );
                        ComShowMessage(errMsg);
						return false;
					}
//					ComOpenPopup('/opuscntr/ESD_TRS_0960.do?csr_no='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number')+'&mode=trs', 800, 495, '','1,0,1,1,1,1,1,1', 0);
					ComOpenWindow('ESD_TRS_0960.do?csr_no='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number')+'&mode=trs',"ESD_TRS_0960", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:450px",true);
					break;
                case "btng_csrcancel":
                    if (sheetObjects[0].RowCount()<= 0){
						return false;
					}
					if (sheetObjects[0].GetSelectRow()== undefined || sheetObjects[0].GetSelectRow()== null || sheetObjects[0].GetSelectRow()== 0){
                        errMsg=ComGetMsg("TRS90036" );
                        ComShowMessage(errMsg);
						return false;
					}
					if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number') == undefined ||
							sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number') == null ){
                        errMsg=ComGetMsg("TRS90199" );
                        ComShowMessage(errMsg);
						return false;
					}
		            /** CSR INTERFACE STATUS CODE LIST
		             * --------------------------------
		             * DA
		             * AR
		             * IF_SUCCESS
		             * IF_ERROR
		             * AP_REJECTED
		             */
					var ifStatIndicator=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_sts_indicator');
				    /* AP_REJECTED + DA */
				    if ( ifStatIndicator == 'AP_REJECTED' || ifStatIndicator == 'DA' ) {
				    	ComOpenPopup('/opuscntr/ESD_TRS_0048.do?csr_no='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number')+"&rows="+sheetObjects[0].GetSelectRow(), 795,500,'', '1,0,1,1,1,1,1,1', 1);
                    /* IF_ERROR */
				    } else if ( ifStatIndicator == 'IF_ERROR' ) {
				        if(confirm('Selected CSR will cancel.\n\nAre you sure to proceed?')) {
				            doActionIBSheet(sheetObject, formObject, IBSAVE);
				        }
						return false;
				    /* AR + IF_SUCCESS + 'Approved' */
				    } else if ( ifStatIndicator == 'AR' ) {
				        if(confirm('Selected CSR will cancel.\n\nAre you sure to proceed?')) {
				            doActionIBSheet(sheetObject, formObject, 'IBSAVE2');
				        }
						return false;
				    /* IF_SUCCESS + 'Approved' */
				    } else {
                        errMsg=ComGetMsg("TRS90206" );
                        ComShowMessage(errMsg);
                        return false;
				    }
				    break;
				case "btng_downexcel1":
					if(sheetObject.RowCount() < 1) { //no data
						ComShowCodeMessage("COM132501");
					} else {
//						sheetObject.Down2Excel({ HiddenColumn:true});
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), SheetDesign:1, Merge:1 });	
					}
				    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                errMsg=ComGetMsg("TRS90392" );
                ComShowMessage(errMsg);
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
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
		              var HeadTitle1="CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|CSR\nCreated Time|CSR Requested|CSR Requested|CSR Approved/ Disapproved|CSR Approved/ Disapproved|No of Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|Date Of Tax|ASA No." ;
		              var HeadTitle2="CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|CSR\nCreated Time|ID|Name|ID|Name|No of Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|Date Of Tax|ASA No." ;
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ 	 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"csr_number",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"if_sts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"if_sts_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"if_err_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"csr_cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"rqst_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"rqst_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"apro_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_cnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"py_due_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:"pay_grp_lu_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"date_of_tax",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"asa_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"if_sts_indicator",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:1,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(0);
//		              SetSheetHeight(400);
		              resizeSheet();
		              SetColProperty("if_sts_dt", {Format:"####-##-## ##:##:##"} );
		              SetColProperty("csr_cre_dt", {Format:"####-##-## ##:##:##"} );
		              }
                break;
           case 2:      //sheet1 init
        	    with(sheetObj){
		             var HeadTitle="csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt" ;
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pre_csr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_prpd_dy",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_to",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_csr_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_group",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_evi_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_due_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_asa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"apro_step",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_title",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail5",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail6",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_mail7",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		             SetEditable(1);
                   }
                break; 
            case 3:      //sheet1 init
                with(sheetObj){
			             var HeadTitle="char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_chart_of_account",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_account_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pre_gl_date",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_city",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_debit",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_credit",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
                      }
                break;      
        }
    }
    /*
     * handling of Sheet 
     */    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:
                formObj.f_cmd.value=SEARCHLIST;
                sheetObj.DoSearch("ESD_TRS_0047GS.do", TrsFrmQryString(formObj) );
			    break;
            case IBSAVE:        //if err cancel
   				formObj.f_cmd.value=MULTI19;
   				formObj.csr_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),'csr_number');
   				var sXml=sheetObj.GetSaveData("ESD_TRS_0047GS.do", TrsFrmQryString(formObj));
   				sheetObj.LoadSaveData(sXml,true);
                break;
            case 'IBSAVE2':    //approval request cancel
   				formObj.f_cmd.value=MULTI20;
   				formObj.csr_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),'csr_number');
   				var sXml=sheetObj.GetSaveData("ESD_TRS_0047GS.do", TrsFrmQryString(formObj));
   				sheetObj.LoadSaveData(sXml,true);
                break;
           case IBINSERT:
                sheetObj.DataInsert();
                break;
           case IBCOPYROW:
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:
//        	   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });	
              break;
           case IBLOADEXCEL:
        	   sheetObj.LoadExcel();
              break;
        }
    }
    /*
     * handling of Sheet 
     */    
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:
        	   formObj.csr_no.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_number');
               	formObj.f_cmd.value=SEARCH01;                  
               	sheetObjects[2].DoSearch("ESD_TRS_0047PreView.do", TrsFrmQryString(formObj) );
                break;        
       }
    } 
    function sheet1_OnSaveEnd(sheetObj , ErrMsg)
    {
        if ( ErrMsg != "") return;
        doActionIBSheet(sheetObj , document.form, IBSEARCH);
    }
    function sheet3_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=null && errMsg != 0 && errMsg != ""){
            ComShowMessage(errMsg);
        }
        var previewFlg="";
        var pre_title="";
		var pre_csr_no=sheetObj.GetEtcData("pre_csr_no");
		var pre_office=sheetObj.GetEtcData("pre_office");
		var pre_prpd_dy=sheetObj.GetEtcData("pre_prpd_dy");
		var pre_pay_to=sheetObj.GetEtcData("pre_pay_to");
		var pre_csr_type=sheetObj.GetEtcData("pre_csr_type");
		var pre_desc=sheetObj.GetEtcData("pre_desc");
		var pre_pay_group=sheetObj.GetEtcData("pre_pay_group");
		var pre_evi_tp=sheetObj.GetEtcData("pre_evi_tp");
		var pre_due_date=sheetObj.GetEtcData("pre_due_date");
		var pre_asa_no=sheetObj.GetEtcData("pre_asa_no");
		var pre_inv_dt=sheetObj.GetEtcData("pre_inv_dt");
		var pre_curr_cd=sheetObj.GetEtcData("pre_curr_cd");
		var pre_amt=sheetObj.GetEtcData("pre_amt");
		var pre_pay_curr_cd=sheetObj.GetEtcData("pre_pay_curr_cd");
		var pre_pay_amt=sheetObj.GetEtcData("pre_pay_amt");
		var pre_evi_tp_count=sheetObj.GetEtcData("pre_evi_tp_count");
		var apro_step=sheetObj.GetEtcData("pre_appro_by");
		//N200902170070 2009-02-23 : CSR Check Mailing Address
		var chk_mail=sheetObj.GetEtcData("chk_mail");
		var chk_mail1=sheetObj.GetEtcData("chk_mail1");
		var chk_mail2=sheetObj.GetEtcData("chk_mail2");
		var chk_mail3=sheetObj.GetEtcData("chk_mail3");
		var chk_mail4=sheetObj.GetEtcData("chk_mail4");
		var chk_mail5=sheetObj.GetEtcData("chk_mail5");
		var chk_mail6=sheetObj.GetEtcData("chk_mail6");
		var chk_mail7=sheetObj.GetEtcData("chk_mail7");
		if(pre_amt==0 || pre_amt=="0" || pre_amt=="0.00"){
				pre_title="TRANSFER SLIP";
		}else{
				pre_title="CONSULTATION SLIP";
		}	
		sheetObjects[1].RemoveAll();
		sheetObjects[1].DataInsert(-1);
        sheetObjects[1].SetCellValue(1,"pre_csr_no",pre_csr_no);
        sheetObjects[1].SetCellValue(1,"pre_office",pre_office);
        sheetObjects[1].SetCellValue(1,"pre_prpd_dy",pre_prpd_dy);
        sheetObjects[1].SetCellValue(1,"pre_pay_to",pre_pay_to);
        sheetObjects[1].SetCellValue(1,"pre_csr_type",pre_csr_type);
        sheetObjects[1].SetCellValue(1,"pre_desc",pre_desc);
        sheetObjects[1].SetCellValue(1,"pre_pay_group",pre_pay_group);
        sheetObjects[1].SetCellValue(1,"pre_evi_tp",pre_evi_tp+"/"+pre_evi_tp_count);
        sheetObjects[1].SetCellValue(1,"pre_due_date",pre_due_date);
        sheetObjects[1].SetCellValue(1,"pre_asa_no",pre_asa_no);
        sheetObjects[1].SetCellValue(1,"pre_inv_dt",pre_inv_dt);
        sheetObjects[1].SetCellValue(1,"pre_curr_cd",pre_curr_cd);
        sheetObjects[1].SetCellValue(1,"pre_amt",pre_amt);
        sheetObjects[1].SetCellValue(1,"pre_pay_curr_cd",pre_pay_curr_cd);
        sheetObjects[1].SetCellValue(1,"pre_pay_amt",pre_pay_amt); 
        sheetObjects[1].SetCellValue(1,"apro_step",apro_step);
        sheetObjects[1].SetCellValue(1,"pre_title",pre_title);
        //N200902170070 2009-02-23 : CSR Check Mailing Address
        sheetObjects[1].SetCellValue(1,"chk_mail",chk_mail);
        sheetObjects[1].SetCellValue(1,"chk_mail1",chk_mail1);
        sheetObjects[1].SetCellValue(1,"chk_mail2",chk_mail2);
        sheetObjects[1].SetCellValue(1,"chk_mail3",chk_mail3);
        sheetObjects[1].SetCellValue(1,"chk_mail4",chk_mail4);
        sheetObjects[1].SetCellValue(1,"chk_mail5",chk_mail5);
        sheetObjects[1].SetCellValue(1,"chk_mail6",chk_mail6);
        sheetObjects[1].SetCellValue(1,"chk_mail7",chk_mail7);
        if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
         		previewFlg="krjp";
        }
		ComOpenPopup('/opuscntr/ESD_TRS_0036.do?previewFlg='+previewFlg, 800,720,'', '1,0,1,1,1,1,1,1');
    }			
	function OnPopupClick()
	{
			var formObject=document.form;
			var cmdt_cd_val="";
			var rep_cmdt_cd_val="";
			var cmdt_desc_val="";
			var classId="getCOM_ENS_so";
			var xx1="";  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";
	        var title="CSR NO.";
			var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title+ "&pgmNo=ESD_TRS_0047";
			ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 390, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	function getTRS_ENS_906(rowArray,returnval) {
		var formObject=document.form;
			var x1=document.form.mult_csr_no.value;
			if(x1==""){
				document.form.mult_csr_no.value=rowArray;
				formObject.mult_csr_no.focus();
			}else{
				document.form.mult_csr_no.value=rowArray;
				formObject.mult_csr_no.focus();
			}
	}
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
            objs.style.display="none";
            //no support[check again]CLT sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
            sheetObjects[0].focus();
            //no support[check again]CLT sheetObjects[0].ViewRows=20;
        }
        else
        {
            objs.style.display="inline";
            //no support[check again]CLT sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
            sheetObjects[0].focus();
            //no support[check again]CLT sheetObjects[0].ViewRows=10;
        }
    }
/**
	 * pass the regular expression object is suitable for even the real date type is checked.<br>  
	 * Example: 2006-11-00 to pass the regular expression, but is in fact an invalid date.<br>
	 * 
	 * @param {String}	str_date	Date
	 * @param {String}	del			delete Separator
	 **/
function isValidDateObject(str_date, del){
    if (del==undefined || del==null || del.trim()==''){del='-';}
    var arr_date=str_date.split(del);
    var obj_date=new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
    var result=(1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1) && 1*arr_date[2]==obj_date.getDate());
    if (result){return true;
    } else {return false; 
    }
}
	function validateDateObj(obj){
		if (obj.readOnly==true){return false;}
		obj.value=ComTrim(obj.value);
		if (obj.value==null || ComTrim(obj.value)==''){return false;}
		if (!checkPeriodFormat(obj.value) || !isValidDateObject(obj.value,'-')){
                errMsg=ComGetMsg("TRS90070" );
                ComShowMessage(errMsg);
			obj.focus();
			return false;
		}
		var formObj=document.form;
		if (formObj.fm_eff_dt.value!=null && ComTrim(formObj.fm_eff_dt.value)!='' && 
			formObj.to_eff_dt.value!=null && ComTrim(formObj.to_eff_dt.value)!='' && 
			!isValFmTo(formObj.fm_eff_dt.value, formObj.to_eff_dt.value)){
                errMsg=ComGetMsg("TRS90118" );
                ComShowMessage(errMsg);
			return false;
		}
		return true;
	}
	function isValFmTo(fmDt, toDt){
		if (fmDt==undefined || fmDt==null || ComTrim(fmDt)=='' || toDt==undefined || toDt==null || ComTrim(toDt)==''){
			return false;
		}
		var str_fmDt=fmDt.replace(/-/gi,'');
		var str_toDt=toDt.replace(/-/gi,'');
		if (isNaN(str_fmDt) || isNaN(str_toDt) || ComTrim(str_fmDt).length!=8 || ComTrim(str_toDt).length!=8) {
			return false;
		}
		if (parseInt(str_toDt,10) - parseInt(str_fmDt,10) <= 0){
			return false;
		}
		return true;
	}
	function checkPeriodFormat(prd_dt){
		var date_regexp=/(^\d{4}\-\d{2}\-\d{2}$)/;
		if (!checkFormat(prd_dt, date_regexp)){	return false;
		} else { return true;
		}
	}
    function checkFormat(src, regexp){
		if (src==null || src=='' || regexp==null || regexp==''){return false;}
		result=(regexp.test(src));
		if (!result){return false;
		} else {return true;
		}
	}
    function getCalendar() {
		var cal=new ComCalendarFromTo();
    	cal.displayType="date";
    	cal.select(document.form.fm_eff_dt, document.form.to_eff_dt, 'yyyy-MM-dd');
    }
    function isNum(obj){
    	if (!ComIsNumber(obj)){
    		obj.value='';
    	}
    }
    
  //UI 표준화관련 하단 여백 설정
    function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    }   
