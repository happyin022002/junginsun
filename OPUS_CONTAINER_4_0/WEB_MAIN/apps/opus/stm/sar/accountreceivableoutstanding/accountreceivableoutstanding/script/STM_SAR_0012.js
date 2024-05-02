/*=========================================================
*@LastVersion : 1.0
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0012.js
*@FileTitle  : Receipt Outstanding Search Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/08
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
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
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
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
 				case "btn_OK":
 					var sCheckRows = sheetObject1.FindCheckedRow("checkbox");
 					if(ComIsEmpty(sCheckRows)) {
 						ComShowCodeMessage("COM12114", "row");
 						return;
 					}
 					doActionIBSheet(sheetObject1, formObj, IBSAVE);
 					ComClosePopup();
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
				case "btns_calendar1":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.as_of_date, 'yyyy-MM-dd');
					break;	
				case "btns_calendar2":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.if_from_dt, 'yyyy-MM-dd');
					break;	
				case "btns_calendar3":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.if_to_dt, 'yyyy-MM-dd');
					break;	
				case "btns_cust":
					var cust_cnt_cd=formObj.bil_to_cust_cnt_cd.value;
					var cust_seq=formObj.bil_to_cust_seq.value;
					var classId="STM_SAR_9003";
					var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
					ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 400, 'getSTM_SAR_9003', '0,0', true, false);
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
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		
		document.form.bil_to_cust_cnt_cd.focus();

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
			        var HeadTitle1="|Sel|Rhq|SmryCd|OtsCd|RepOfcCd|B/L No|Invoice No|Booking No|Office|Source|Actual Cust|Customer Name|Shipper|V.V.D|Charge|CUR.|Outstanding Amount|Local Amount|USD Amount|Due Date|Over Due|Remark|RCT_APLY_HDR_SEQ|RCT_APLY_FLG|OFC_CD|TRNK_VVD_CD|SAIL_ARR_DT|IO_BND_CD|SREP_CD|XCH_RT_TP_CD|XCH_RT_DT|CR_FLG|AR_FINC_SRC_CD|MAX_AR_IF_NO|INV_DT|RCT_APLY_CHG_CD|RCT_APLY_SRC_CURR_CD|OTS_APLY_AMT|OTS_XCH_RT|RCT_APLY_XCH_RT|RCT_CURR_CD|RCT_APLY_AMT|DP_PRCS_KNT|BIL_TO_CUST_CNT_CD|BIL_TO_CUST_SEQ|HDR_DUP_FLG";
			        var headCount=ComCountHeadTitle(HeadTitle1);
	
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1, FrozenCol:8 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"checkbox" },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ots_smry_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ots_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rep_ots_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ots_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ots_src_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"shp_to_cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"locl_vvd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chg_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bl_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"ots_bal_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"locl_bal_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"usd_bal_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"due_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"over_due",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ots_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_hdr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_flg",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trnk_vvd_cd",     	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sail_arr_dt",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",     		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"xch_rt_tp_cd",     	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"xch_rt_dt",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cr_flg",      		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ar_finc_src_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"max_ar_if_no",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_dt",     			  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_chg_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_src_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ots_aply_amt",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ots_xch_rt",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_curr_cd",     	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rct_aply_amt",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				               {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dp_prcs_knt",      	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        		   {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        		   {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bil_to_cust_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        		   {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hdr_dup_flg",       	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			         
			        InitColumns(cols);
	
			        SetEditable(1);
			        SetColProperty("due_dt", {Format:"####-##-##"} );
			        SetSheetHeight(300);
				}
			    break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH_ASYNC01: 
				//retrieve OTS Type List
				var arrStr=SarGetComboItems(sheetObj, "ACCT CTNT3");
				MakeSrcTypeComboObject(tj_src_nm, arrStr);
				//retrieve AR Office List 	
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"ots_ofc_cd");
				var arrStr=sStr.split("|");
				MakeOtsOfcComboObject(ots_ofc_cd, arrStr);
				ots_ofc_cd.SetSelectText(formObj.rct_ofc_cd.value);
				//retrieve Local Time
				formObj.f_cmd.value=SEARCH07;
				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"lcl_time");
				formObj.as_of_date.value=ComGetMaskedValue(sStr, "ymd");
				formObj.if_from_dt.value=ComGetMaskedValue(sStr, "ymd");
				formObj.if_to_dt.value=ComGetMaskedValue(sStr, "ymd");
				//retrieve MDM Charge List 	
				formObj.f_cmd.value=SEARCH12;
				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"chg_list");
				var arrStr=sStr.split("|");
				MakeChargeComboObject(chg_tp_cd, arrStr);
				//retrieve OTS Source List
				var arrStr=SarGetComboItems(sheetObj, "OTS SRC CD");
				MakeSrcTypeComboObject(ots_src_cd, arrStr);
				
				bkg_io_bnd_cd.SetColWidth(0, "0");
				bkg_io_bnd_cd.SetColWidth(1, "74");
				if ( formObj.local_chg_flag.value == "Y" ) {
					var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE");
			 		SarAddComboItem(bkg_io_bnd_cd, strBoundCombo, "2", "ALL", "A");	
			 		if(formObj.invoice_type.value == "NFRT" && ComTrim(formObj.bound_type.value) == "I" ) { 
			 			bkg_io_bnd_cd.SetSelectText("ALL");
			 		} else {
			 			bkg_io_bnd_cd.SetSelectCode(ComTrim(formObj.bound_type.value));
			 		}
			 		bkg_io_bnd_cd.SetEnable(false);	
			 		ots_ofc_cd.SetEnable(false);	
				} else {
					var strBoundCombo=SarGetComboItems(sheetObjects[0], "BOUND TYPE&attr_ctnt1=A");
			 		SarAddComboItem(bkg_io_bnd_cd, strBoundCombo, "2", "ALL", "A");	
			 		bkg_io_bnd_cd.SetSelectText("ALL");
			 		bkg_io_bnd_cd.SetEnable(true);
			 		ots_ofc_cd.SetEnable(true);	
				}
				
				break;
			case IBSEARCH_ASYNC02:	//Search Customer Info
				formObj.f_cmd.value=SEARCH06;
				formObj.cust_cnt_cd.value=formObj.bil_to_cust_cnt_cd.value;
				formObj.cust_seq.value=formObj.bil_to_cust_seq.value;
				var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowMessage(SarShowXmlMessage(sXml));
     				formObj.bil_to_cust_cnt_cd.value="";
     				formObj.bil_to_cust_seq.value="";
     				formObj.cust_nm.value="";
     				formObj.bil_to_cust_cnt_cd.focus();
     			}else{
					formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
     			}
				break;
			case IBSEARCH: // RETRIEVE 
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				setTimeout( function () {
					formObj.f_cmd.value=SEARCH;
					
					if(formObj.ots_rct_tmp_seq.value == "undefined") formObj.ots_rct_tmp_seq.value = "";
						
				    if (formObj.ofst_chk.checked) {
				    	formObj.ofst_chk.value="Y";
				    } else {
				    	formObj.ofst_chk.value="N";
				    }
				
					var sParam=FormQueryString(formObj);
					var sParam2=ComGetSaveString(parent.sheetObjects[1], true, true);
					sParam2=ComSetPrifix(sParam2, "sheet2_");
					sParam=sParam + "&" + sParam2;
					
					var sXml=sheetObj.GetSearchData("STM_SAR_0012GS.do", sParam);
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					formObj.ots_rct_tmp_seq.value = ComGetEtcData(sXml,"ots_rct_tmp_seq");
					parent.document.form.ots_rct_tmp_seq.value = ComGetEtcData(sXml, "ots_rct_tmp_seq");
					ComOpenWait(false);	
				} , 100);	
				break;
			case IBSAVE: // SAVE				
				formObj.f_cmd.value=MULTI;
				if(formObj.ots_rct_tmp_seq.value == "undefined") formObj.ots_rct_tmp_seq.value = "";
		        var sParam=FormQueryString(formObj);
		        var sParam1=ComGetSaveString(sheetObj, true, false, "checkbox");
				sParam1=ComSetPrifix(sParam1, "sheet1_");
				sParam = sParam + "&" + sParam1;
				sXml=sheetObj.GetSaveData("STM_SAR_0012GS.do", sParam);
	
			
				if(SarShowXmlMessage(sXml) != "") {
     				ComShowMessage(SarShowXmlMessage(sXml));
				}	
				
				parent.document.form.ots_rct_tmp_seq.value = ComGetEtcData(sXml, "ots_rct_tmp_seq");
				parent.getSTM_SAR_0012();
				break;
		}
	}
	/**
	 * function called when combo box ots_ofc_cd change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author Park sung yong
	 * @version 2014.03.26
	 */	
	function ots_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		var formObj=document.form;
		var arrStr=newCode.split("^");
		formObj.ofc_cd.value=arrStr[0];
		formObj.rhq_cd.value=arrStr[2];
		formObj.ots_smry_cd.value=arrStr[3]; 
		formObj.ots_cd.value=arrStr[4]; 
		formObj.rep_ots_ofc_cd.value=arrStr[5];
		if(arrStr[15] == "AGT") tj_src_nm.SetSelectCode("AGENT");
		else tj_src_nm.SetSelectCode("");
		var otsSmryCd=formObj.ots_smry_cd.value;
		if(otsSmryCd == "BL" || otsSmryCd == ""){
			document.all.item("bl_label").style.display="";	
			document.all.item("inv_label").style.display="none";	
			document.all.item("ofst_label").style.display="none";	
			document.all.item("ofst_chk").style.display="none";	
		} else if(otsSmryCd == "INV"){
			document.all.item("bl_label").style.display="none";	
			document.all.item("inv_label").style.display="";
			if(formObj.rct_tp_cd.value == "OFF"){
				document.all.item("ofst_label").style.display="";	
				document.all.item("ofst_chk").style.display="";
			} else {
				document.all.item("ofst_label").style.display="none";	
				document.all.item("ofst_chk").style.display="none";	
			}
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
	 * @author park sung yong
	 * @version 2014.03.26
	 */
  	function initCombo(comboObj, comboNo) {
		/*switch (comboObj.options.id) {
			case "bkg_io_bnd_cd":
				with (comboObj) {
					InsertItem(0, "ALL",    "A");
		            InsertItem(1, "O/B",    "O");
		            InsertItem(2, "I/B",    "I");
		    		SetMultiSelect(0);
//no support[check again]CLT 		    		UseCode=true;
		    		//LineColor = "#ffffff";
		    		SetColAlign(0, "left");
		    		SetMultiSeparator(",");
		    		SetDropHeight(190);
		    		SetSelectCode("A");
				}
			break;
		}*/
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
		//axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		//axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		//axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
	
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}

    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "bil_to_cust_cnt_cd":
				if (formObj.bil_to_cust_cnt_cd.value == '') {
					formObj.bil_to_cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
				break;
		
			case "bil_to_cust_seq":
				if (formObj.bil_to_cust_cnt_cd.value != '' && formObj.bil_to_cust_seq.value != '') {
					var valueCustSeq=formObj.bil_to_cust_seq.value;
					formObj.bil_to_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				} else {
					formObj.cust_nm.value = "";
				}
				break;
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
		formObj.bil_to_cust_cnt_cd.value=colArray[8];
		formObj.bil_to_cust_seq.value=ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value=colArray[4];
	}
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeOtsOfcComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.03.24
	 */
	function MakeOtsOfcComboObject(cmbObj, arrStr) {
		for (var i=1; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("^");
			var var_ots_ofc_cd=arrStr2[0];
			cmbObj.InsertItem(i-1, var_ots_ofc_cd, arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeChargeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.06.19
	 */
	function MakeChargeComboObject(cmbObj, arrStr) {
		for (var i=0; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	/**
	 * create combo box<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeSrcTypeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Park sung yong
	 * @version 2014.06.19
	 */
	function MakeSrcTypeComboObject(cmbObj, arrStr) {
		cmbObj.InsertItem(0, "", "");	
		for (var i=0; i < arrStr.length; i++ ) {
			var arrStr2=arrStr[i].split("=");
			cmbObj.InsertItem(i+1, arrStr2[0], arrStr2[0]);			 
		}
		cmbObj.SetDropHeight(190);
	}  
	
	/**
	 * function called when combo box bkg_io_bnd_cd change<br>
	 * @param object comboObj
	 * @param String value
	 * @param String text
	 * @author clt
	 * @version 2014.11.20
	 */	
	function bkg_io_bnd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(newCode == "L") {
			tj_src_nm.SetEnable(false);
		} else {
			tj_src_nm.SetEnable(true);
		}
	}	
