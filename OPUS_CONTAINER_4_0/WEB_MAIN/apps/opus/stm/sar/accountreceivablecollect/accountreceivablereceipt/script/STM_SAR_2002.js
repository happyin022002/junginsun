/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2002.js
*@FileTitle  : Receipt Inquiry(Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;				
 ***************************************************************************************/
    /**
     * @extends 
     * @class Receipts : business script for STM_SAR_0012
     */

 // common global variable
//    var gCurRow = 0;
//    var prefix = "sheet1_";
	var sheetObjects=new Array();
	var sheetCnt=0;	
	var comboObjects=new Array();
	var comboCnt=0;
    var selOfcCds="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var formObj=document.form;
		var sheetObject1=sheetObjects[0];
     	try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					date_condition();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_new":
					removeAll(formObj);
					break;
				case "btn_downexcel":
					if(sheetObjects[0].RowCount() < 1){//no data
               		 ComShowCodeMessage("COM132501");
					}else{
						if(sheetObj.RowCount() >= sheetObj.GetTotalRows() ) {
							sheetObjects[0].Down2Excel();
						} else {
							ComShowCodeMessage("SAR00072");  //To retrieve all data, please scroll down to the bottom and click down excel.
						}
						
					}
	    	    	break;					
				case "btns_calendar3":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.cond_dt_fm, 'yyyy-MM-dd');
					break;	
				case "btns_calendar4":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.cond_dt_to, 'yyyy-MM-dd');
					break;	
				case "btns_cust":
					var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
					var cust_seq=formObj.rct_cust_seq.value;
					var classId="STM_SAR_9003";
					var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 400, 'getSTM_SAR_9003', '0,0', true, false);
					break;					
				case "btns_cust_info":
					var formObject=document.form; 
					if(formObject.rct_cust_cnt_cd.value != "" && formObject.rct_cust_seq.value != "") {
						var param='?cust_cnt_cd='+formObject.rct_cust_cnt_cd.value+'&cust_seq='+formObject.rct_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
						ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1150, 650, 'getPopData', '0,0', true, false, "", "", 0);
					}
					break; 
				case "btn_multi_office_popup":  
					//--  if  not required :  var param = "";  
					var param=selOfcCds;				
					var popupMultiWin=ComOpenPopup('/opuscntr/STM_SAR_0003.do' + param, 400, 650, 'getSTM_SAR_0003', '0,1', true, false);
//					popupMultiWin.focus();
					break;				
				case "btns_bank":
					if (!validateForm(sheetObject1,formObj,IBSEARCH)) break;	
					date_condition();
					var rct_dt_fm=formObj.rct_dt_fm.value;
					var rct_dt_to=formObj.rct_dt_to.value;
					var rct_dps_dt_fm=formObj.rct_dps_dt_fm.value;
					var rct_dps_dt_to=formObj.rct_dps_dt_to.value;
					var rct_ofc_cd=formObj.rct_ofc_cd.value;
					var rct_sts_cd=formObj.rct_sts_cd.value;
					var rct_unpay_sts_flg=formObj.rct_unpay_sts_flg.value;
					var classId="STM_SAR_0005";
					var param='?ui_type=I&fm_rct_dt='+rct_dt_fm+'&to_rct_dt='+rct_dt_to+'&dep_fr_dt='+ rct_dps_dt_fm + '&dep_to_dt='+ rct_dps_dt_to + '&rct_ofc_cd='+ rct_ofc_cd + '&rct_sts_cd='+ rct_sts_cd + '&rct_unpay_sts_flg='+ rct_unpay_sts_flg + '&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_0005.do' + param, 500, 470, 'getSTM_SAR_0005', '0,0', true, false);
					break;	
				case "btns_search_usrid":
					var rct_dt_fm=formObj.rct_dt_fm.value;
					var rct_dt_to=formObj.rct_dt_to.value;
					var rct_dps_dt_fm=formObj.rct_dps_dt_fm.value;
					var rct_dps_dt_to=formObj.rct_dps_dt_to.value;
					var classId="STM_SAR_0014";
					var param='?fm_rct_dt='+rct_dt_fm+'&to_rct_dt='+rct_dt_to+'&dep_fr_dt='+ rct_dps_dt_fm + '&dep_to_dt='+ rct_dps_dt_to +'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_0014.do' + param, 600, 530, 'getSTM_SAR_0014', '0,0', true, false);
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
		initControl();
		for(var k=0;k<comboObjects.length;k++){
//			initCombo(comboObjects[k],k+1);
		}	
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		document.form.rct_cust_cnt_cd.focus();
		
		selOfcCds = "?selOfcCds=" + ComReplaceStr(document.form.rct_ofc_cd.value, "'", "");
		if(document.form.call_yn.value == "Y"){
			if(document.form.req_rct_dt.value != ""){ 
				var reqDate = document.form.req_rct_dt.value; 
				document.form.cond_dt_fm.value = ComGetDateAdd(reqDate, "d", -15);
				document.form.cond_dt_to.value = ComGetDateAdd(reqDate, "d", 15);
			} 
			date_condition();
			//sheetObjects[0].RenderSheet(0);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  
			//sheetObjects[0].RenderSheet(1);  
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
			case 1:      // sheet1 init
				with (sheetObj) {
					var HeadTitle1="|Office|Receipt No|Cheque No|ASA No|Receipt\nCust Code|Receipt\nCust Name|Outstanding\nCust Code|Outstanding\nCust Name|Bank\nAccount|Receipt\nCurrency|Receipt\nAmount|Bank CHG\nAmount|Receipt Type|Receipt Date|Deposit Date|User ID|B/L No|BKG No|Shipper\nCust Code|Shipper\nCust Name|Consignee\nCust Code|Consignee\nCust Name|Invoice No|Outstanding\nOffice|Lane|SCP|S/A Date|VVD|Vessel Name|Bound|POL|POD|Collection\nTerm|Reverse\nFlag|Write-Off\nCode|Charge|Source\nCurrency|Outstanding\nBalance AMT|Outstanding\nApply AMT|Target\nCurrency|Receipt Apply\nEX. Rate|Receipt\nApply AMT|Cancel\nReason|Cancel\nDate|Cancel Remark|Cancel User ID|Invoice\nIssue Date";
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
			        
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rct_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"rct_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"chq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"asa_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rct_cust_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rct_cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ots_cust_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ots_cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"bank_acct_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rct_amt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bank_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_dps_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               //{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"s_cust_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"s_cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"c_cust_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"c_cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ots_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sail_arr_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"locl_vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:140,   Align:"Left",  ColMerge:0,   SaveName:"vsl_nm",           	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"clt_term",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rvs_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrtf_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_src_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ots_bal_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ots_aply_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_tgt_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rct_aply_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"rct_aply_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_rsn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rct_cxl_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"rct_cxl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cxl_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        InitColumns(cols);
			        SetEditable(1);
			        SetColProperty("rct_dt", {Format:"Ymd"} );
			        SetColProperty("rct_dps_dt", {Format:"Ymd"} );
			        SetColProperty("rct_cxl_dt", {Format:"Ymd"} );
			        SetColProperty("inv_dt", {Format:"Ymd"} );
			        //SetSheetHeight(360);
			        SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			        
			        resizeSheet();
				}
			    break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {				
			case IBSEARCH: // RETRIEVE 
				if (!validateForm(sheetObj,formObj,sAction)) {		 				
					return false;
				}				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				iPageNo = 1;
				setTimeout( function () {  
					formObj.f_cmd.value=SEARCH;
	 				var sXml=sheetObj.GetSearchData("STM_SAR_2002GS.do", FormQueryString(formObj)+"&i_page="+iPageNo);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					//sheetObj.DoSearch("STM_SAR_2002GS.do", FormQueryString(formObj) );
					ComOpenWait(false); 
			    } , 100);		
				break;		
			case IBSEARCHAPPEND: // 
				if (!validateForm(sheetObj,formObj,IBSEARCH)) {		 				
					return false;
				}	
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				
				setTimeout( function () {  
					formObj.f_cmd.value=SEARCH;
	 				var sXml=sheetObj.GetSearchData("STM_SAR_2002GS.do", FormQueryString(formObj)+"&i_page="+PageNo, {Append:true});
					sheetObj.LoadSearchData(sXml,{Sync:0,Append:1} );
					//sheetObj.DoSearch("STM_SAR_2002GS.do", FormQueryString(formObj)+"&i_page="+PageNo, {Append:true});
					ComOpenWait(false); 
			    } , 100);		
				break;		
			case IBSEARCH_ASYNC01:
				//retrieve login AR Office	
				formObj.f_cmd.value=SEARCH03;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
				var arrStr=sStr.split("|");
				var arrStr2=arrStr[1].split("^");
				formObj.rct_ofc_cd.value="'" + arrStr2[1] + "'";
				formObj.rct_ofc_cd1.value="'" + arrStr2[1] + "'";
				var arrStr=SarGetComboItems(sheetObj, "RECEIPT TYPE");				
				MakeRctTypeComboObject(rct_tp_cd, arrStr);
				var arrStr=SarGetComboItems(sheetObj, "RECEIPT CANCEL REASON");
				MakeCxlRsnComboObject(rct_cxl_rsn_cd, arrStr);
				//retrieve Local Time
				formObj.f_cmd.value=SEARCH07;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"lcl_time");
				formObj.cond_dt_fm.value=ComGetMaskedValue(sStr, "ymd");
				formObj.cond_dt_to.value=ComGetMaskedValue(sStr, "ymd");
				break;		
			case IBSEARCH_ASYNC02:	//Search Customer Info
				formObj.f_cmd.value=SEARCH06;
				formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
				formObj.cust_seq.value=formObj.rct_cust_seq.value;
 				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowMessage(SarShowXmlMessage(sXml));
     				ComClearObject(formObj.rct_cust_cnt_cd);
     				ComClearObject(formObj.rct_cust_seq);
     				ComClearObject(formObj.cust_nm);
     				formObj.rct_cust_cnt_cd.focus();
     			}else{
					formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
     			}
				break;
		}
	}
	
	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
	    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) { 
	    	return;
	    } else {
	    	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	    }
	}

	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: //retrieve
				if(ComIsEmpty(formObj.cond_dt_fm)){
					ComShowCodeMessage("COM130403", "Date");
					ComSetFocus(formObj.cond_dt_fm);
					return false;
				}
				if(ComIsEmpty(formObj.cond_dt_to)){
					ComShowCodeMessage("COM130403", "Date");
					ComSetFocus(formObj.cond_dt_to);
					return false;
				}
				if(formObj.rct_ofc_cd1.value == ""){
					ComShowCodeMessage("COM12113", "Office");
					ComSetFocus(document.all.item("rct_ofc_cd1"));
					return false;
				}
				break;
			case IBSAVE: //SAVE
				break;
		}
		return true;
	}
	/**
	 * loading HTML Control event <br>
	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sequence number in sheetObjects array
	 **/
	function initControl() {
		var formObj=document.form;
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('upper'); 
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum'); 
				break;
			case "num":
	        	//only number
				ComKeyOnlyNumber('num');
	            break;
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(ComGetEvent(), "-");
				break;
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "float":
				ComKeyOnlyNumber(ComGetEvent(), "-.");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet('upper');
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(ComGetEvent());
		}
	}    
	/** 
	 * init combo<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return none
	 * @see #
	 * @author yhha
	 * @version 2014 04 29 
	 */
		function initCombo(comboObj, comboNo) {
			switch (comboObj.id) {
				case "rct_tp_cd":
					with (comboObj) {
						InsertItem(0, "Unapplied", "Unapplied");
			            InsertItem(1, "Cancel",    "C");
			            InsertItem(2, "BTR",       "BTR");
			            Code="BTR";
			    		SetMultiSelect(0);
//no support[check again]CLT 			    		UseCode=true;
			    		//LineColor = "#ffffff";
			    		SetColAlign(0, "left");
			    		SetMultiSeparator(",");
			    		SetDropHeight(190);
					}
				break;
			}
		}	
    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
		var formObj=document.form;
		switch (ComGetEvent("name")) {
			case "cond_dt_fm":
				var condDtFm=ComReplaceStr(ComGetEvent("name"),"-","");
				if (condDtFm.length == 8) {
					formObj.cond_dt_to.focus();
				}
	 		break;
			case "cond_dt_to":
				var condDtTo=ComReplaceStr(ComGetEvent("name"),"-","");
				if (condDtTo.length == 8) {
					formObj.rct_cust_cnt_cd.focus();
				}
	 		break;
			case "rct_cust_cnt_cd":
				var rctCustCntCd=ComGetEvent("name");
				if (rctCustCntCd.length == 2) {
					formObj.rct_cust_seq.focus();
				}
	 		break;
		}
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
       	switch(ComGetEvent("name")){ 	    	
       		case "cond_dt_fm":
       			ComClearSeparator(ComGetEvent());
       			break;
       		case "cond_dt_to":
       			ComClearSeparator(ComGetEvent());
       			break;
       	}
//       	event.srcElement.select();
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    	 ComChkObjValid(ComGetEvent());
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
//    function obj_deactivate(){
//		var obj=ComGetEvent();
//	    var formObj=document.form;
//		switch(ComGetEvent("name")){ 	    	
//	   		case "inv_dt_fr":
//	   			ComAddSeparator(obj, "ymd");
//	   			break;
//	   		case "inv_dt_to":
//	   			ComAddSeparator(obj, "ymd");
//	   			break;
//	   		case "gl_dt_fr":
//	   			ComAddSeparator(obj, "ymd");
//	   			break;
//	   		case "gl_dt_to":
//	   			ComAddSeparator(obj, "ymd");
//	   			break;	
//		}
//	}
	function obj_deactivate(){
		var obj=ComGetEvent();
	    var formObj=document.form;
		switch(ComGetEvent("name")){
			case "cond_dt_fm":
				ComChkObjValid(ComGetEvent());
				ComAddSeparator(obj, "ymd");
				break;
			case "cond_dt_to":
				ComChkObjValid(ComGetEvent());
				ComAddSeparator(obj, "ymd");
				break;
			case "rct_amt1":
				ComChkObjValid(ComGetEvent());
				break;
			case "rct_amt2":
				ComChkObjValid(ComGetEvent());
				break;
		}
	}
	function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_cnt_cd":
				if (formObj.rct_cust_cnt_cd.value == '') {
					formObj.rct_cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
				break;
				
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else {
					formObj.cust_nm.value = "";
				}
				break;
		}
	}
	/** 
	 * date type on change
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param     
	 * @return none
	 * @see #
	 * @author yhha
	 * @version 2014.04.30
	 */	
	function date_condition(){
		var frm=document.form;
	    var rctDtTpCd=ComGetObjValue(frm.rct_dt_tp_cd);
	    if (rctDtTpCd == "RECEIPT"){
	    	frm.rct_dt_fm.value=frm.cond_dt_fm.value;
	    	frm.rct_dt_to.value=frm.cond_dt_to.value;
	    	frm.rct_dps_dt_fm.value="";
	    	frm.rct_dps_dt_to.value="";
	    } else {	    	
	    	frm.rct_dt_fm.value="";
	    	frm.rct_dt_to.value="";
	    	frm.rct_dps_dt_fm.value=frm.cond_dt_fm.value;
	    	frm.rct_dps_dt_to.value=frm.cond_dt_to.value;
	    }
	}	
	/** 
	 * call method when select event on popup(STM_SAR_9003)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function getSTM_SAR_9003(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.rct_cust_cnt_cd.value=colArray[8];
		formObj.rct_cust_seq.value=ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value=colArray[4];
	}
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeRctOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeRctOfcComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("^");
			var ots_ofc_cd=arrStr2[0];
			cmbObj.InsertItem(i-1, ots_ofc_cd, arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeCurrCdComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeCurrCdComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/** 
	 * call method when select event on popup(FNS_INV_0086)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author yhha
	 * @version 2014.04.21
	 */
	function getSTM_SAR_0014(rowArray) {
		var colArray=rowArray[0];
		var formObj=document.form;
		formObj.usr_id.value=colArray[1];
	}	
	/** 
	 * call method when select event on popup(STM_SAR_0003)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray   
	 * @return none
	 * @see #
	 * @author yhha
	 * @version 2014.04.21
	 */
	function getSTM_SAR_0003(data) {
	    // 반환 index 
		 //      data[0 ] =  ibflag
		 //  data[1 ] =  checkbox
		 //  data[2 ] =  OTS_OFC_CD   
		 //  data[3 ] =  ofc_brnc_agn_tp_cd
		 //  data[4 ] =  rhq_cd           
		 //  data[5 ] =  ar_curr_cd
		 //  data[6 ] =  ots_smry_cd
		 //  data[7 ] =  dp_prcs_knt
		 //  data[8 ] =  bank_ctrl_cd
		 //  data[9 ] =  ofc_entr_lvl_cd
		 //  data[10] =  ar_ofc_cd
		 //  data[11] =  ots_cd
		 //  data[12] =  rct_tp_cd
		 //  data[13] =  rep_ots_ofc_cd
		 //  data[14] =  rct_unapy_flg
		//alert("000000000000000");  
	    var multiOfcCd="";
	    selOfcCds = "";
	    
	    for(var i=0; i < data.length; i++) {
	        var row=data[i];
	        if (i > 0 ) {        	
	        	multiOfcCd +=  " , '" + row[2] +"'";
	        	selOfcCds +=  "&selOfcCds=" + row[2];
	        } else {
	        	multiOfcCd +=  "'" + row[2] +"'";
	        	selOfcCds +=  "?selOfcCds=" + row[2];
	        }    
	    }
	    var frm=document.form;
	    frm.rct_ofc_cd.value=multiOfcCd;
	    frm.rct_ofc_cd1.value=multiOfcCd;
	    //alert("frm.rct_ofc_cd.value= " + frm.rct_ofc_cd.value + "  , selOfcCds = "+ selOfcCds);
	}
		/** 
		 * call method when select event on popup(STM_SAR_0005)<br>
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  {array} rowArray   
		 * @return none
		 * @see #
		 * @author yhha
		 * @version 2014.04.21
		 */
		function getSTM_SAR_0005(rowArray) {
			var colArray=rowArray[0];
			var formObj=document.form;
			formObj.bank_acct_seq.value=colArray[5];	
			formObj.bank_acct_name.value=colArray[1];	
		}	    
		/**
		 * create combo box<br>
		 * <br><b>Example : </b>
		 * <pre>
		 *    MakeRctTypeComboObject(cmbObj, arrStr);
		 * </pre>
		 * @param object cmbObj
		 * @param String arrStr
		 * @author yhha
		 * @version 2014.04.29
		 */
		function MakeRctTypeComboObject(cmbObj, arrStr) {
			for (var i=0; i < arrStr.length; i++ ) {
				var arrStr2=arrStr[i].split("=");
				cmbObj.InsertItem(i, arrStr2[0], arrStr2[0]);
			}
			cmbObj.SetDropHeight(190);
		}	
		
		function MakeCxlRsnComboObject(cmbObj, arrStr) {
			cmbObj.InsertItem(0, "", "");		
			for (var i=0; i < arrStr.length; i++ ) {
				var arrStr2=arrStr[i].split("=");
				cmbObj.InsertItem(i+1, arrStr2[0] + "|" +  arrStr2[1], arrStr2[0]);			 
			}
			cmbObj.SetDropHeight(190);
		} 
		
		/** 
		 * Initialize screen.<br>
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  {object} formObj  
		 * @return none.
		 */
		function removeAll(formObj) {
			var sheetObject1=sheetObjects[0];
			var formObj=document.form;
			formObj.reset();
			sheetObject1.RemoveAll();
			comboObjects[0].RemoveAll();
			doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC01);
			formObj.rct_cust_cnt_cd.focus();
		}

		function resizeSheet(){
			ComResizeSheet(sheetObjects[0]);
		}