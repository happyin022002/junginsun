/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0032.js
*@FileTitle  : Sublet Revenue
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17 
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0032 : esm_fms_0032 definition of biz script for creation screen
     */

// common global variables 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObject=document.form;
    try {
    	var srcName=ComGetEvent("name");
    	if(ComGetBtnDisable(srcName)) return false;
    	switch(srcName) {
    		case "btn_new":
    			if(!initConfirm()) return;
    			ComBtnEnable("btn_hire");
    			ComBtnEnable("btn_bodBor");
    			clearAll(); //NYK Modify 2014.10.21
    			break;
    		case "btn_save":
    			doActionIBSheet(sheetObject,formObject,IBSAVE);
    			inputReadOnly("1");
    			break;
			case "btn_hire":
				//if(!initConfirm()) return;
				//NYK Modify 2014.10.27
				initHireAndBorBodButton();
				//ComBtnDisable("btn_bodBor");
				if(validateForm(sheetObject,formObject)) {
					initHireAndBorBodData("HIR"); // Data init
    				var param=FormQueryString(form);
    				//ComOpenWindowCenter("ESM_FMS_0034.do?" + param, "ESM_FMS_0034", 900, 435, false);
    				ComOpenWindowCenter("ESM_FMS_0034.do?" + param, "ESM_FMS_0034", 1150, 435, true);
				}
				break;
			case "btn_bodBor":
				//if(!initConfirm()) return;
				//NYK Modify 2014.10.27
				initHireAndBorBodButton();
				//ComBtnDisable("btn_hire");
				if(validateForm(sheetObject,formObject)) {
					initHireAndBorBodData("OIL"); // Data init
    				//var param=FormQueryString(form);
    				var flet_ctrt_no=formObject.flet_ctrt_no.value;
	        		var csr_curr_cd=formObject.csr_curr_cd.value;
	        		var flet_ctrt_tp_cd = formObject.param_flet_ctrt_tp_cd.value;
	        		
	        		//NYK Modify 2014.10.22
	        		var param = "";
	        			param +="flet_ctrt_no="+flet_ctrt_no;
	        		    param +="&csr_curr_cd="+csr_curr_cd;
	        		    param +="&apro_flg=";
	        		    param +="&flet_ctrt_tp_cd="+flet_ctrt_tp_cd;
	        		    param +="&call_slip_tp_cd="+gCallSlipTpCdRevenue; // 수입에서 Call
	        		
	        		ComOpenPopup("ESM_FMS_0027.do?"+param, 900, 378, "setBodBor", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0027");
	        		//ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd+"&apro_flg=Y", 900, 378, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
    				//ComOpenWindowCenter("ESM_FMS_0034.do?" + param, "ESM_FMS_0034", 900, 415, false);
				}
        		//var flet_ctrt_no = formObject.flet_ctrt_no.value;
        		//var csr_curr_cd = formObject.csr_curr_cd.value;
        		//ComOpenPopup("ESM_FMS_0027.do?flet_ctrt_no="+flet_ctrt_no+"&csr_curr_cd="+csr_curr_cd, 900, 358, "setBodBor", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0027");
        		break;
			case "btn_slip":
				ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "esm_fms_0041_1", 1024, 700, false);
				//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
				break;
			case "btn_print":
				rdOpen(document.form);
				break;
			case "btn_vslCd":
 				//ComOpenPopup("ESM_FMS_0022.do", 520, 470, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
 				ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
 				break;
			case "btn_fletCtrtNo":
 				if(formObject.vsl_cd.value == "") {
 					ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
 					return;
 				}
 				clearAll("CTRT"); //NYK Modify 2014.10.21
 				var param="typeFlag=" + "TI|TO" + "&vsl_cd=" + formObject.vsl_cd.value;
 				ComOpenPopup("ESM_FMS_0023.do?" + param, 520, 415, "setContractNo", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0023");
 				break;
			case "btn_effDt":
				var cal=new ComCalendar();
				cal.setDisplayType('date');
				cal.setEndFunction('eff_dt_change');
				cal.select(form.eff_dt, 'yyyy-MM-dd');
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
 * * adding first-served functions after loading screen. 
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
 		ComConfigSheet (sheetObjects[i] );
 		initSheet(sheetObjects[i],i+1);
 		ComEndConfigSheet(sheetObjects[i]);
 	}
	initControl();
	setSlpIssDt();
	initDefaultDate();//NYK Modify 2014.10.15
	
	resizeSheet();    	
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
		    with(sheetObj){
	    	      var HeadTitle="|Seq|Account Code|Customer Code|Customer Code|Center Code|City|Eff. Date|Slip Amount|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_seq_no|csr_curr_cd|trns_curr_cd|trns_amt|inv_seq|slp_iss_dt|vvd_eff_dt|vvd_exp_dt|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|bnk_seq|pop_gb";
	    	      var HeadTitle2="|Seq|Description|Description|Description|Description|VVD Code|Key Number|Key Number|slp_tp_cd|slp_func_cd|slp_ofc_cd|slp_seq_no|csr_curr_cd|trns_curr_cd|trns_amt|inv_seq|slp_iss_dt|vvd_eff_dt|vvd_exp_dt|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|bnk_seq|pop_gb";
	    	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"},
	    	                  { Text:HeadTitle2, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	
	    	      var cols = [
	    	                  	[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	    	                    {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"NONE" },
	    	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Float",     Hidden:0,  Width:180,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_func_cd",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_seq_no",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trns_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trns_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_iss_dt",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_eff_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",          KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",    KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flet_iss_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bnk_seq",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pop_gb",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ]
			    	             ,
			    	             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag1" },
			    	                {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"NONE" },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc1",        KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc2",        KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"csr_desc3",        KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",     PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",   Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:"to_inv_no1",       KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_tp_cd1",       KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_func_cd1",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_ofc_cd1",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_seq_no1",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd1",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"trns_curr_cd1",    KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"trns_amt1",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_seq1",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"slp_iss_dt1",      KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_eff_dt1",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_exp_dt1",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"csr_no1",          KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no1",    KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"flet_iss_tp_cd1",  KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_dtl_seq1",     KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bnk_seq1",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			    	                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pop_gb1",         KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ]
	    	      ];
	    	       
	    	      InitColumns(cols , 2);		
	    	      SetEditable(1);		    	
	    	      SetSheetHeight(280);
	      }
			break;
	}
}
/**
 *  Handling IBSheet's process(Retrieve, Save)<br>
 **/
function doActionIBSheet(sheetObj, formObj, sAction, objNm) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      
    		if(objNm == "flet_ctrt_tp_nm") {
    			//NYK Modify 2014.10.27
    			var f_query = "";					
				f_query += "f_cmd=" + SEARCH02; 
				f_query += "&flet_ctrt_no="+formObj.flet_ctrt_no.value;	 			
				f_query += "&call_slip_tp_cd="+gCallSlipTpCdRevenue; //수입,비용 전표구분.
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);
				
				var fletCtrtTpCd=ComGetEtcData(sXml, "fletCtrtTpCd");
				var fletCtrtTpNm=ComGetEtcData(sXml, "fletCtrtTpNm");
				var custCntCd=ComGetEtcData(sXml, "CustCntCd");
				var custSeq=ComGetEtcData(sXml, "CustSeq");
				var custLglEngNm=ComGetEtcData(sXml, "CustLglEngNm");
				
				if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != ""){
					formObj.flet_ctrt_tp_nm.value=fletCtrtTpNm;
					formObj.param_flet_ctrt_tp_cd.value=fletCtrtTpCd;
					formObj.ownr_cd.value=custCntCd;
   					formObj.ownr_seq.value=custSeq;
   					formObj.ownr_nm.value=custLglEngNm;
				}
				
				initHireAndBorBodButton();
				
    			/* NYK Modify 2014.10.27
	 			formObj.f_cmd.value=SEARCH04;
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do", FormQueryString(formObj));
	   			var ctrtType=ComGetEtcData(sXml, "ctrtType");
	   			if(typeof ctrtType != "undefined" && ctrtType != "") {
	   				formObj.flet_ctrt_tp_nm.value=ctrtType;
	   				var param="f_cmd=" + SEARCH01 + "&flet_ctrt_no=" + form.flet_ctrt_no.value;
	   				var sXml=sheetObj.GetSearchData("ESM_FMS_0032GS.do", param);
	   				if(typeof ctrtType != "undefined" && ctrtType != "") {
	   					formObj.ownr_cd.value=ComGetEtcData(sXml, "CustCntCd");
	   					formObj.ownr_seq.value=ComGetEtcData(sXml, "CustSeq");
	   					formObj.ownr_nm.value=ComGetEtcData(sXml, "CustLglEngNm");
	   				}else{//NYK Modify 2014.10.21
	   					formObj.ownr_cd.value = "";
	   					formObj.ownr_seq.value = "";
	   					formObj.ownr_nm.value = "";
	   				}
				}
				*/
			} else if(objNm == "vsl_cd") {
    			formObj.f_cmd.value=SEARCH01;
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", FormQueryString(formObj));
	   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
	   				formObj.vsl_eng_nm.value=vslEngNm;
	   				form.flet_ctrt_no.value="";
     				form.flet_ctrt_tp_nm.value="";
     				
     				initDefaultContractNo(); //NYK Modify 2014.10.21
				} else {
					formObj.vsl_cd.value="";
					form.flet_ctrt_no.value="";
     				form.flet_ctrt_tp_nm.value="";
					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
				}
			} else if(objNm == "csr_curr_cd") {
				form.f_cmd.value=SEARCH01;
				var param="f_cmd=" +  form.f_cmd.value + "&curr_cd=" + form.csr_curr_cd.value;
				var sXml=sheetObj.GetSearchData("ESM_FMS_0076GS.do", param);
	   			var currNm=ComGetEtcData(sXml, "currCd");
	   			if(typeof currNm == "undefined" || currNm == "" ) {
	   				form.csr_curr_cd.value="";
	   				ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS00006", "Currency"));
	   			}
			} else if(objNm == "eff_dt") {
	   			formObj.f_cmd.value=SEARCH09;
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(form),"-",""));
 		   		
	   			var closFlg=ComGetEtcData(sXml, "clos_yn");
	   			var effDt=ComGetEtcData(sXml, "eff_dt");
	   			var oldEffDt=ComGetUnMaskedValue(formObj.eff_dt, "ymd");
			
	   			if (closFlg=="C"){
					//closed, and open item not exists
					if (ComTrim(effDt) == ""){
						//ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS20009"), oldEffDt.substring(0,6));
						ComShowCodeMessage("FMS20009", oldEffDt.substring(0,6));
						formObj.eff_dt.value="";
						return;					
					}
					//closed, and user confirmed, setting next month 1 day
					if (ComShowCodeConfirm('FMS20010',oldEffDt, effDt)){
						formObj.eff_dt.value=effDt;

						//Set Sheet
						setSheetSlpEffDtChange(sheetObj);
					}else{
						formObj.eff_dt.value="";
					}
				//before closing month, and before closing previous month
				}else if (closFlg=="X"){
					//Two or more un-closed month exist ! Do you want ignore it 
					//if (!ComShowCodeConfirm("FMS20011")){
					//	formObj.eff_dt.value="";
					//	formObj.eff_dt.focus();
					//}
					//Set Sheet
					setSheetSlpEffDtChange(sheetObj);
				//in case of not existing data
				}else if (closFlg=="E"){
					ComShowCodeMessage("FMS20012", oldEffDt.substring(0,6));
					formObj.eff_dt.value="";
				}else{
					//dumy
					//Set Sheet
					setSheetSlpEffDtChange(sheetObj);
				}
			} else if(objNm == "vvd_cd") {
				formObj.f_cmd.value=SEARCH06;
				var param="f_cmd=" + formObj.f_cmd.value + "&vvd_cd=" + formObj.vvd_cd.value;
				var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
				if(CoFmsShowXmlMessage(sXml) != "") {
					formObj.vvd_cd.value="";
					ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
				} else {
					var vvdCd=formObj.vvd_cd.value;
					//NYK Modify 2014.10.27
					var tmpContractType = formObj.flet_ctrt_tp_nm.value;
					var selFletCtrtTpCd = formObj.param_flet_ctrt_tp_cd.value;
			    	if(selFletCtrtTpCd == gFletCtrtTpCdTI){
			    		formObj.csr_desc.value = vvdCd.substring(0,4);
			    	}else{
			    		formObj.csr_desc.value = vvdCd.substring(0,4) + " " +vvdCd.substring(4,6)+"/"+vvdCd.substring(6,8)+" "+tmpContractType+" Revenue";
			    	}						
					/*
					formObj.csr_desc.value=vvdCd.substring(0,4) + " " +
											 //vvdCd.substring(4,6) + "년 " +
											 vvdCd.substring(4,6) + "/" +
											 //vvdCd.substring(6,8) + "월 " + "대선료 채권 계상";
											 vvdCd.substring(6,8) + " TC/O Revenue";*/
				}
			}
 			break;
		case IBSAVE:        
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value=MULTI;
				
				var param=FormQueryString(formObj) + "&" + ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_");
				var sXml=sheetObj.GetSaveData("ESM_FMS_0032GS.do", param);
				sheetObj.LoadSaveData(sXml);
			}
			break;
        	
		case IBSEARCH_ASYNC01: //NYK Modify 2014.10.14
			sheetObj.SetWaitImageVisible(0);
			var f_query = "";					
			f_query += "f_cmd=" + SEARCH; 
			f_query += "&csr_type="+formObj.csr_type.value;	 			
			f_query += "&slp_ofc_cd="+formObj.slp_ofc_cd.value; 
			
			var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

   			var varRqstDt = ComGetEtcData(sXml, "rqst_dt");
   			var varEffDt = ComGetEtcData(sXml, "eff_dt");

   			if(typeof varEffDt != "undefined" && varEffDt != "" ) {
				formObj.eff_dt.value = ComGetMaskedValue(varEffDt,"ymd");
			}
			sheetObj.SetWaitImageVisible(1);
			
			eff_dt_change();
			break;
        	
		case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
			if(formObj.vsl_cd.value == "") return;				
			var f_query = "";					
			f_query += "f_cmd=" + SEARCH01; 
			f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
			f_query += "&type_flag="+gFletCtrtTpCdAll;  			
			f_query += "&order_priority="+gOrderPriorityTO; 
			
			var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
   			
   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
				formObj.flet_ctrt_no.value = varFletCtrtNo;
			}else{
				ComShowCodeMessage("FMS20001","Agreement");
				clearAll();
				return;
			}
			if(formObj.flet_ctrt_no.value != ""){
				contract_no_change();
			}
			break;
	}
}
/**
 * Handling process for input validation<br>
 */
function validateForm(sheetObj,formObj,sAction){
	if (!ComChkValid(formObj)) {
 		return false;
  	}
	if(sAction == IBSAVE) {
		//NYK Modify 2014.10.28
		if(formObj.csr_desc.value == "") {
			ComAlertFocus(formObj.csr_desc, ComGetMsg("FMS01444"));
    		return false;
		}
		
    	if(sheetObjects[0].RowCount()== 0) {
  			ComShowCodeMessage("FMS00007");
  			return false;
  		}
    	// --------------------------------------------------
		//  Checking to prevent inserting decimal point in case Currency is KRW or JPY
		// --------------------------------------------------
    	for(var row=2; row<=sheetObj.LastRow(); row++) {
    		if(row%2 == 0) {
				var currCd=form.csr_curr_cd.value;
				if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
					var carAmt=sheetObj.GetCellValue(row, "csr_amt").replace(/,/g,'');
					if(carAmt%parseInt(carAmt)) {
						ComShowCodeMessage("FMS01476");
 						sheetObj.SelectCell(row, "csr_amt");
						return false;
					}
				}
    		}
    	}
    	// --------------------------------------------------
	}
 	return true;
}
/**
 * Setting Data retrieved on Hire Statement PopUp<br>
 * @param {arry} aryPopupData
 */
function setHireStatement(aryPopupData) {
	//sheetObjects[0].RemoveAll();
	/*var iStartIdx = sheetObjects[0].LastRow();
	var iEndIdx = sheetObjects[0].HeaderRows();
	//for (var ir=sheetObjects[0].LastRow(); ir>=2; ir--) {
	for (var ir=iStartIdx; ir >= iEndIdx; ir--) {
		if(sheetObjects[0].GetCellValue(ir,"bnk_seq") == "" || sheetObjects[0].GetCellValue(ir,"bnk_seq1") == "") {
			sheetObjects[0].RowDelete(ir,false);
 			//sheetObjects[0].RowHidden(ir)= true;
 			//sheetObjects[0].RowStatus(ir)= "D";
			ir--; // 2개 Row로 생성되므로 지울때는 Index를 -1 해주어야 함.
		}
	}*/
	var seqNo=sheetObjects[0].RowCount();
	var csrAmt=0;
	for(var i=0; i<aryPopupData.length; i++) {
		var hirRevenueData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"slp_tp_cd",form.slp_tp_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd",form.slp_func_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd",form.slp_ofc_cd.value,0);
		var slpSeqNo;
		seqNo++;
		//NYK Modify 2014.10.27
		slpSeqNo = ComLpad(seqNo,4,"0");//4자리 0 Padding.
		/*
		if(seqNo.toString().length == 1) {
			slpSeqNo="000" + seqNo;
		} else if(seqNo.toString().length == 2) {
			slpSeqNo="00" + seqNo;
		} else if(seqNo.toString().length == 3) {
			slpSeqNo="0" + seqNo;
		} else {
			slpSeqNo=seqNo;
		}*/
		sheetObjects[0].SetCellValue(row,"slp_seq_no"	,slpSeqNo,0);
		sheetObjects[0].SetCellValue(row,"acct_cd"		,gAcctCdByDebit,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd"		,hirRevenueData.ar_ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd"	,hirRevenueData.loc_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_curr_cd"	,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"csr_amt"		,hirRevenueData.inv_amt,0);
		//sheetObjects[0].CellValue2(row,"cust_cnt_cd") = hirRevenueData.cust_cnt_cd;			
		//sheetObjects[0].CellValue2(row,"cust_seq") = hirRevenueData.cust_seq;
		sheetObjects[0].SetCellValue(row,"cust_cnt_cd"	,form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"cust_seq"		,form.ownr_seq.value,0);
		sheetObjects[0].SetCellValue(row,"trns_curr_cd"	,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt"	,form.slp_iss_dt.value,0);
		sheetObjects[0].SetCellValue(row,"vvd_eff_dt"	,hirRevenueData.eff_dt,0);
		sheetObjects[0].SetCellValue(row,"vvd_exp_dt"	,hirRevenueData.exp_dt,0);
		sheetObjects[0].SetCellValue(row,"trns_amt"		,hirRevenueData.inv_amt,0);
		sheetObjects[0].SetCellValue(row,"inv_seq"		,hirRevenueData.inv_seq,0);
		sheetObjects[0].SetCellValue(row,"eff_dt"		,form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no"	,hirRevenueData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"flet_iss_tp_cd",hirRevenueData.flet_iss_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"inv_dtl_seq"	,hirRevenueData.inv_dtl_seq,0);
		sheetObjects[0].SetCellValue(row,"pop_gb","HIR"	,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc"	,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc1"	,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc2"	,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc3"	,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no"	,hirRevenueData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no1"	,hirRevenueData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"vvd_cd"		,form.vvd_cd.value,0);
		sheetObjects[0].SetCellValue(row+1,"pop_gb1"	,"HIR",0);
		sheetObjects[0].SetMergeCell(row+1, 2, 1, 4);
		sheetObjects[0].SetMergeCell(row+1, 7, 1, 2);

		csrAmt=csrAmt + parseFloat(hirRevenueData.inv_amt);
		//sheetObjects[0].SetCellFont("FontName", row, "slp_loc_cd","Courier New");
		//sheetObjects[0].SetCellFont("FontName", row+1, "vvd_cd","Courier New");
	}
	form.tot_hire_amt.value=CoFmsRound(csrAmt, 2);
	if(form.tot_bnk_amt.value == "") {
		form.rqst_amt.value=CoFmsRound(csrAmt, 2);
		form.dr_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));	// Creditor
		form.cr_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));	// Debtor
	} else {
		var totBnkAmt = 0;
		if(form.tot_bnk_amt.value != ""){
			totBnkAmt = parseFloat(form.tot_bnk_amt.value);
		}
		form.rqst_amt.value=CoFmsRound(totBnkAmt, 2) + CoFmsRound(csrAmt, 2);
		form.dr_amt.value=ComAddComma(CoFmsRound(totBnkAmt, 2) + CoFmsRound(csrAmt, 2));	// Creditor
		form.cr_amt.value=ComAddComma(CoFmsRound(totBnkAmt, 2) + CoFmsRound(csrAmt, 2));	// Debtor
	}
	for(var i=0; i<aryPopupData.length; i++) {
		var hirRevenueData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"slp_tp_cd"	,form.slp_tp_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd"	,form.slp_func_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd"	,form.slp_ofc_cd.value,0);
		var slpSeqNo;
		seqNo++;
		//NYK Modify 2014.10.27
		slpSeqNo = ComLpad(seqNo,4,"0");//4자리 0 Padding.

		sheetObjects[0].SetCellValue(row,"slp_seq_no"		,slpSeqNo,0);
		sheetObjects[0].SetCellValue(row,"acct_cd"			,gAcctCdByHireRevenue,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd"			,hirRevenueData.ar_ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd"		,hirRevenueData.loc_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_curr_cd"		,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"csr_amt"			,hirRevenueData.inv_amt,0);
		//sheetObjects[0].CellValue2(row,"cust_cnt_cd") = hirRevenueData.cust_cnt_cd;			
		//sheetObjects[0].CellValue2(row,"cust_seq") = hirRevenueData.cust_seq;
		sheetObjects[0].SetCellValue(row,"cust_cnt_cd"		,form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"cust_seq"			,form.ownr_seq.value,0);
		sheetObjects[0].SetCellValue(row,"trns_curr_cd"		,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt"		,form.slp_iss_dt.value,0);
		sheetObjects[0].SetCellValue(row,"vvd_eff_dt"		,hirRevenueData.eff_dt,0);
		sheetObjects[0].SetCellValue(row,"vvd_exp_dt"		,hirRevenueData.exp_dt,0);
		sheetObjects[0].SetCellValue(row,"trns_amt"			,hirRevenueData.inv_amt,0);
		sheetObjects[0].SetCellValue(row,"inv_seq"			,hirRevenueData.inv_seq,0);
		sheetObjects[0].SetCellValue(row,"eff_dt"			,form.eff_dt.value,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no"		,hirRevenueData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"flet_iss_tp_cd"	,hirRevenueData.flet_iss_tp_cd,0);
		sheetObjects[0].SetCellValue(row,"inv_dtl_seq"		,hirRevenueData.inv_dtl_seq,0);
		sheetObjects[0].SetCellValue(row,"pop_gb"			,"HIR",0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc"		,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc1"		,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc2"		,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc3"		,hirRevenueData.inv_desc,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no"		,hirRevenueData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no1"		,hirRevenueData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"pop_gb1"		,"HIR",0);
		sheetObjects[0].SetMergeCell(row+1, 2, 1, 4);
		sheetObjects[0].SetMergeCell(row+1, 7, 1, 2);
		sheetObjects[0].SetCellValue(row+1,"vvd_cd"			,form.vvd_cd.value,0);
		//sheetObjects[0].SetCellFont("FontName", row, "slp_loc_cd","Courier New");
		//sheetObjects[0].SetCellFont("FontName", row+1, "vvd_cd","Courier New");
	}
	inputReadOnly("1");
}
/**
 * Setting Data retrieved on BOD, BOR Settlement PopUp
 * @param {arry} aryPopupData
 */
function setBodBor(aryPopupData) {
    /*for (var ir=sheetObjects[0].LastRow(); ir > sheetObjects[0].HeaderRows(); ir--) {
    	if(sheetObjects[0].GetCellValue(ir,"bnk_seq") != "" || sheetObjects[0].GetCellValue(ir,"bnk_seq1") != "") {
			sheetObjects[0].RowDelete(ir,false);
 			//sheetObjects[0].RowHidden(ir)= true;
 			//sheetObjects[0].RowStatus(ir)= "D";
			ir--; // 2개 Row로 생성되므로 지울때는 Index를 -1 해주어야 함.
		}
	}*/
    var seqNo=sheetObjects[0].RowCount();

	var csrAmt=0;
	var selFletCtrtTpCd = document.form.param_flet_ctrt_tp_cd.value;
	
	for(var i=0; i<aryPopupData.length; i++) {
		var bodBorData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"slp_tp_cd"	,form.slp_tp_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd"	,form.slp_func_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd"	,form.slp_ofc_cd.value,0);
		var slpSeqNo;
		seqNo++;
		slpSeqNo = ComLpad(seqNo,4,"0");//4자리 0 Padding.

		sheetObjects[0].SetCellValue(row,"slp_seq_no"	,slpSeqNo,0);
		sheetObjects[0].SetCellValue(row,"acct_cd"		,gAcctCdByDebit,0);
		sheetObjects[0].SetCellValue(row,"cust_cnt_cd"	,form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"cust_seq"		,form.ownr_seq.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd"		,bodBorData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd"	,bodBorData.slp_loc_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_curr_cd"	,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"trns_curr_cd"	,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt"	,form.slp_iss_dt.value,0);
		sheetObjects[0].SetCellValue(row,"trns_amt"		,bodBorData.bnk_amt,0);
		sheetObjects[0].SetCellValue(row,"eff_dt"		,form.eff_dt.value,0);
		//NYK Modify 2014.10.27
		if(selFletCtrtTpCd == gFletCtrtTpCdTO){
			if(bodBorData.bnk_tp_cd == "BOD") {
				sheetObjects[0].SetCellValue(row,"csr_amt"	,bodBorData.bnk_amt,0);
			} else {
				sheetObjects[0].SetCellValue(row,"csr_amt"	,-bodBorData.bnk_amt,0);
			}
		}else{
			sheetObjects[0].SetCellValue(row,"csr_amt"	,bodBorData.bnk_amt,0);
		}
		sheetObjects[0].SetCellValue(row,"bnk_seq"		,bodBorData.bnk_seq,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no"	,bodBorData.flet_ctrt_no,0);
		sheetObjects[0].SetCellValue(row,"pop_gb"		,"OIL",0);
		//sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = bodBorData.flet_src_tp_cd;
		sheetObjects[0].SetCellValue(row+1,"csr_desc"	,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc1"	,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc2"	,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc3"	,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no"	,bodBorData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no1"	,bodBorData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"vvd_cd"		,bodBorData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row+1,"bnk_seq1"	,bodBorData.bnk_seq,0);
		sheetObjects[0].SetCellValue(row+1,"pop_gb1"	,"OIL",0);
		
		sheetObjects[0].SetMergeCell(row+1, 2, 1, 4);
		sheetObjects[0].SetMergeCell(row+1, 7, 1, 2);
		
		csrAmt=csrAmt + parseFloat(sheetObjects[0].GetCellValue(row,"csr_amt"));
		//sheetObjects[0].SetCellFont("FontName", row, "slp_loc_cd","Courier New");
		//sheetObjects[0].SetCellFont("FontName", row+1, "vvd_cd","Courier New");
	}
	form.tot_bnk_amt.value=CoFmsRound(csrAmt, 2);
	
	if(form.tot_hire_amt.value == "") {
		form.rqst_amt.value=CoFmsRound(csrAmt, 2);
		form.dr_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));	// Creditor
		form.cr_amt.value=ComAddComma(CoFmsRound(csrAmt, 2));	// Debtor
	} else {
		var totHireAmt = 0;
		if(form.tot_hire_amt.value != ""){
			totHireAmt = parseFloat(form.tot_hire_amt.value);
		}
		form.rqst_amt.value=CoFmsRound(totHireAmt, 2) + CoFmsRound(csrAmt, 2);
		form.dr_amt.value=ComAddComma(CoFmsRound(totHireAmt, 2) + CoFmsRound(csrAmt, 2));	// Creditor
		form.cr_amt.value=ComAddComma(CoFmsRound(totHireAmt, 2) + CoFmsRound(csrAmt, 2));	// Debtor
	}
	for(var i=0; i<aryPopupData.length; i++) {
		var bodBorData=aryPopupData[i];
		var row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(row,"slp_tp_cd"		,form.slp_tp_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_func_cd"		,form.slp_func_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_ofc_cd"		,form.slp_ofc_cd.value,0);
		var slpSeqNo;
		seqNo++;
		slpSeqNo = ComLpad(seqNo,4,"0");//4자리 0 Padding.

		sheetObjects[0].SetCellValue(row,"slp_seq_no"		,slpSeqNo,0);
		sheetObjects[0].SetCellValue(row,"acct_cd"			,gAcctCdByBunker,0);
		sheetObjects[0].SetCellValue(row,"cust_cnt_cd"		,form.ownr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"cust_seq"			,form.ownr_seq.value,0);
		sheetObjects[0].SetCellValue(row,"ctr_cd"			,bodBorData.ctr_cd,0);
		sheetObjects[0].SetCellValue(row,"slp_loc_cd"		,bodBorData.slp_loc_cd,0);
		sheetObjects[0].SetCellValue(row,"csr_curr_cd"		,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"trns_curr_cd"		,form.csr_curr_cd.value,0);
		sheetObjects[0].SetCellValue(row,"slp_iss_dt"		,form.slp_iss_dt.value,0);
		sheetObjects[0].SetCellValue(row,"trns_amt"			,bodBorData.bnk_amt,0);
		sheetObjects[0].SetCellValue(row,"eff_dt"			,form.eff_dt.value,0);
		//NYK Modify 2014.10.27
		if(selFletCtrtTpCd == gFletCtrtTpCdTO){
			if(bodBorData.bnk_tp_cd == "BOD") {
				sheetObjects[0].SetCellValue(row,"csr_amt"	,bodBorData.bnk_amt,0);
			} else {
				sheetObjects[0].SetCellValue(row,"csr_amt"	,-bodBorData.bnk_amt,0);
			}
		}else{
			sheetObjects[0].SetCellValue(row,"csr_amt"		,bodBorData.bnk_amt,0);
		}
		sheetObjects[0].SetCellValue(row,"bnk_seq"			,bodBorData.bnk_seq,0);
		sheetObjects[0].SetCellValue(row,"flet_ctrt_no"		,bodBorData.flet_ctrt_no,0);
		//sheetObjects[0].CellValue2(row,"flet_iss_tp_cd") = bodBorData.flet_src_tp_cd;
		sheetObjects[0].SetCellValue(row,"pop_gb"			,"OIL",0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc"		,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc1"		,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc2"		,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"csr_desc3"		,bodBorData.bnk_desc,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no"		,bodBorData.to_inv_no,0);
		sheetObjects[0].SetCellValue(row+1,"to_inv_no1"		,bodBorData.to_inv_no,0);
		//Account Code = gAcctCdByBunker then null
		sheetObjects[0].SetCellValue(row+1,"vvd_cd"			,bodBorData.vvd_bunker,0);
		sheetObjects[0].SetCellValue(row+1,"bnk_seq1"		,bodBorData.bnk_seq,0);
		sheetObjects[0].SetCellValue(row+1,"pop_gb1"		,"OIL",0);
		
		sheetObjects[0].SetMergeCell(row+1, 2, 1, 4);
		sheetObjects[0].SetMergeCell(row+1, 7, 1, 2);
		
		//sheetObjects[0].SetCellFont("FontName", row, "slp_loc_cd","Courier New");
		//sheetObjects[0].CellFont("FontName", row+1, "vvd_cd") = "Courier New";
	}
	inputReadOnly("1");
}
/**
 * Setting Vessel Code and Name selected in Vessel Code PopUp into Form item <br>
 * @param {arry} aryPopupData
 */
function setVslCd(aryPopupData) {
	form.vsl_cd.value=aryPopupData[0][2];
	form.vsl_eng_nm.value=aryPopupData[0][3];
	
	//NYK Modify 2014.10.21
	if(form.vsl_cd.value != ""){
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
	}
}
/**
 * Setting Contract No. selected in Contract Code PopUp into Form item <br>
 * @param {arry} aryPopupData
 */
function setContractNo(aryPopupData){
	form.flet_ctrt_no.value=aryPopupData[0][3];
	contract_no_change();
}

//NYK Modify 2014.10.21
function contract_no_change() {
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"flet_ctrt_tp_nm");
}

/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
	axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form Code Handling to OnChange Event of All Controls
}


/**
 * Checking Vessel Code, Currency, Eff Date, VVD Validation in onchange Event of HTML Control <br>
 */
function obj_change() {
	var sName = ComGetEvent("name");
	if((sName == "vsl_cd") && (form.vsl_cd.value.length == 4)) {
    	form.vsl_eng_nm.value="";
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
	} else if((sName == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"csr_curr_cd");
	} else if((sName == "eff_dt")) {
		if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
    	}
	} else if((sName == "vvd_cd") && (form.vvd_cd.value.length == 10)) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vvd_cd");
	}
}
/**
 * Checking Validation in ondeactivate Event of HTML Control <br>
 **/
//    function obj_deactivate(){
//    	ComChkObjValid(ComGetEvent());
//    }
/**
 * Setting current date into slp_iss_dt<br>
 */
function setSlpIssDt() {
	document.form.slp_iss_dt.value = ComFmsCurrentDate();
}
/**
 * Checking whether to go ahead when other work is occured in case changed data is existing<br>
 **/
function initConfirm() {
	var okYn=true;
 	if(sheetObjects[0].IsDataModified()) {
 		var okYn=ComShowCodeConfirm("FMS00002");
 	}
 	return okYn;
}
/**
 * Setting using of the Object by Condition<br>
 **/
function inputReadOnly(flag) {
	if(flag == "1") {
		form.vsl_cd.readOnly=true;
		form.csr_curr_cd.readOnly=true;
		form.vvd_cd.readOnly=true;
		form.eff_dt.readOnly=true;
		form.btn_fletCtrtNo.style.cursor="default";
		document.all.name="no_btn_fletCtrtNo";
		form.btn_vslCd.style.cursor="default";
		document.all.name="no_btn_effDt";
		form.btn_effDt.style.cursor="default";
		document.all.name="no_btn_effDt";
	} else {
		form.vsl_cd.readOnly=false;
		form.csr_curr_cd.readOnly=false;
		form.vvd_cd.readOnly=false;
		form.eff_dt.readOnly=false;
		form.btn_fletCtrtNo.style.cursor="hand";
		document.all.name="btn_fletCtrtNo";
		form.btn_vslCd.style.cursor="hand";
		document.all.name="btn_effDt";
		form.btn_effDt.style.cursor="hand";
		document.all.name="btn_effDt";
    	ComBtnEnable("btn_save");
    	ComBtnEnable("btn_hire");
    	ComBtnEnable("btn_bodBor");
	}
}
/**
 * Setting Bond No<br>
 */
function sheet1_OnSaveEnd(ErrMsg) {
	if(sheetObjects[0].RowCount()> 0) {
		if(sheetObjects[0].GetCellValue(2, "csr_no") != "") {
			form.csr_no.value=sheetObjects[0].GetCellValue(2, "csr_no");
  	    	ComBtnDisable("btn_save");
  	    	ComBtnDisable("btn_hire");
  	    	ComBtnDisable("btn_bodBor");
		}
    } else {
    	form.rqst_amt.value="0";
    }
}

/**
 * Printing Slip<br>
 */
function rdOpen(formObject){
	if(sheetObjects[0].RowCount() == 0) {
		ComShowCodeMessage("FMS00015");
		return;
	}
	
	if(formObject.csr_no.value == "") {
		ComShowCodeMessage("FMS00015");
		return;
	}
	
	var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
	var rdFile = 'apps/opus/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';

	formObject.com_mrdPath.value = rdFile;
	formObject.com_mrdArguments.value = rdParam;
    ComOpenRDPopup();
}
/**
 * Excuting Change Event in case of setting date by Calendar Object<br>
 */
function eff_dt_change() {
	if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
  	}else{
  		ComAlertFocus(form.eff_dt, ComGetMsg("FMS01565"));
  	}   		
}

//NYK Modify 2014.10.14
function initDefaultDate(){
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);    	
}


function clearAll(flag){
	//NYK Modify 2014.10.21
	switch(flag){
		case "CTRT" :
			var tmpVslCd = form.vsl_cd.value;
			var tmpVslEngNm = form.vsl_eng_nm.value;
			ComResetAll();
			form.vsl_cd.value = tmpVslCd;
			form.vsl_eng_nm.value = tmpVslEngNm;
			break;
		default :
			ComResetAll();
			break;
	}
	setSlpIssDt();
     
    //NYK Modify 2014.10.14
	initDefaultDate();
	
	inputReadOnly("0");
}

//NYK Modify 2014.10.21
function initDefaultContractNo(){
  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
}

//NYK Modify 2014.20.27
function initHireAndBorBodButton(){
	var formObj = document.form;
	var selFletCtrtTpCd = formObj.param_flet_ctrt_tp_cd.value;
	if(selFletCtrtTpCd == gFletCtrtTpCdTI){
		//TI
		ComBtnDisable("btn_hire");
		ComBtnEnable("btn_bodBor");    		
	}else if(selFletCtrtTpCd == gFletCtrtTpCdTO){
		//TO : hire, Bod/Bor 활성화.
		ComBtnEnable("btn_hire");
		ComBtnEnable("btn_bodBor");    		
	}    	
}

function initHireAndBorBodData(flg){
	//Sheet Remove
	for (var i=sheetObjects[0].LastRow(); i >= sheetObjects[0].HeaderRows(); i--){
		if((i%2 == 1) && sheetObjects[0].GetCellValue(i,"pop_gb1") == flg) {
			sheetObjects[0].RowDelete(i , 0);
			sheetObjects[0].RowDelete(i-1 , 0);
			i--;
		}
	}
	
	//Total Amount init
	setTotalAmount();
}

function setTotalAmount(flag) {
	var tmpTotHireAmt = 0;
	var tmpTotBnkAmt = 0;
	var tmpTotCsrAmt = 0;
	for(var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].LastRow(); i=i+2){
		var tmpPopGb = sheetObjects[0].GetCellValue(i,"pop_gb");
		var tmpCsrAmt =  CoFmsRound(parseFloat(sheetObjects[0].GetCellValue(i,"csr_amt")), 2);
		var tmpAcctCd =  sheetObjects[0].GetCellValue(i,"acct_cd");
		var tmpCsrNo =  sheetObjects[0].GetCellValue(i,"csr_no");
		if(gAcctCdByDebit == tmpAcctCd){
			if("HIR" == tmpPopGb || "" != tmpCsrNo){
 				tmpTotHireAmt = CoFmsRound(tmpTotHireAmt,2) + tmpCsrAmt;
 			}else if("OIL" == tmpPopGb || "" != tmpCsrNo){
 				tmpTotBnkAmt = CoFmsRound(tmpTotBnkAmt,2) + tmpCsrAmt;
 			}
 			
 			tmpTotCsrAmt = CoFmsRound(tmpTotCsrAmt, 2) + tmpCsrAmt;
		}
	}
	
	if(tmpTotHireAmt == 0) tmpTotHireAmt = "";
	if(tmpTotBnkAmt == 0) tmpTotBnkAmt = "";
	if(tmpTotCsrAmt == 0) tmpTotCsrAmt = "";
	
	document.form.tot_hire_amt.value 	= tmpTotHireAmt;
	document.form.tot_bnk_amt.value  	= tmpTotBnkAmt;
	document.form.rqst_amt.value		= tmpTotCsrAmt;
	
	document.form.dr_amt.value			= tmpTotCsrAmt;
	document.form.cr_amt.value			= tmpTotCsrAmt;
}

function setSheetSlpEffDtChange(sheetObj){
	var formObj = document.form;	
	//Sheet Set.
	if(sheetObj.RowCount()> 0) {
		for(var ir=sheetObj.HeaderRows(); ir < sheetObj.LastRow(); ir=ir+2){
			sheetObj.SetCellValue(ir,"eff_dt",formObj.eff_dt.value, 0);
		}
	}
	
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i], 90);
    }
}
    