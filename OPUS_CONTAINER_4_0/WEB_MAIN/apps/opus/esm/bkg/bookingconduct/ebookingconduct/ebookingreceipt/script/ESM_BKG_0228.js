/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0228.js
*@FileTitle  : e-Booking n SI Process
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	var comboObjects=new Array();
	var combo1=null;
	var comboCnt=0;
	var arrMultiCombo;
	var arrWindow=new Array(null,null); 
	var viewType = null;
	// esm_bkg_0229 popup Count
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
				break;
			case "btn_new":
				ComClearObject(formObject.rqst_from_dt);
				ComClearObject(formObject.rqst_to_dt);
				ComClearObject(formObject.vvd);
				ComClearObject(formObject.chn_agn_cd);
				ComClearObject(formObject.set_slct_flg);
				ComClearObject(formObject.xter_rqst_no);
				ComClearObject(formObject.xter_rqst_seq);
				xter_rqst_via_cd.SetSelectCode("");
				doc_tp_cd.SetSelectCode("");
				ComClearObject(formObject.origin);
				delivery.SetSelectCode("");
				ComClearObject(formObject.bkg_no);
				xter_bkg_rqst_sts_cd.SetSelectCode("");
				ComClearObject(formObject.hndl_ofc_cd);
				ComClearObject(formObject.pol_cd);
				ComClearObject(formObject.pod_cd);
				ComClearObject(formObject.po_no);
				bkg_upld_sts_cd.SetSelectCode("");
				ComClearObject(formObject.ofc_cd);
				ComClearObject(formObject.por_cd);
				ComClearObject(formObject.del_cd);
				bkg_cust_tp_cd.SetSelectCode("S");
				ComClearObject(formObject.cust_cnt_cd);
				ComClearObject(formObject.cust_seq);
				ComClearObject(formObject.cust_nm);
				ComClearObject(formObject.xter_sndr_id);
				ComClearObject(formObject.cntc_eml);
				break; 
			case "btn_SRCH_SET":
				doActionIBSheet(sheetObjects[0],document.form,"btn_SRCH_SET","","");
				break;
			case "btn_exceldown":
				if (sheetObjects[0].RowCount() < 1){//no data
	       	     ComShowCodeMessage("COM132501");
	       	    } else{
	       	    	doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
	       	    }
				break;
			case "btn_preview":
				doActionIBSheet(sheetObjects[0],document.form,"btn_preview","","");
				break;
			case "btn_previewprint":
				doActionIBSheet(sheetObjects[0],document.form,"btn_previewprint","","");
				break;
			case "btn_upload":
				doActionIBSheet(sheetObjects[0],document.form,"btn_upload","","");
				break;
			case "btn_reject":
				doActionIBSheet(sheetObjects[0],document.form,"btn_reject","","");
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01,"","");
				break;
			case "btn_pending":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02,"","");
				break;
			case "btns_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt,'yyyy-MM-dd');
				break;
			case "btn_bkg_no_save":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03,"","");
				break;
			case "btn_reroute":
				doActionIBSheet(sheetObjects[0],document.form,"btn_reroute","","");
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
	 * registering Combo Object as list
	 * @param combo_obj Combo Object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	function initCombo(comboObj) {
	 //no support[check again]CLT 	comboObj.LineColor="#ffffff";
	 	comboObj.SetColAlign(0, "0");
	 	comboObj.SetColAlign(0, "1");
	 	if (comboObj==comboObjects[comboObjects.length-1]) {
		 	comboObj.SetMultiSelect(0);
			comboObj.SetMultiSeparator("|");
	 	} else {
	 	 	comboObj.SetMultiSelect(1);
	 	 	comboObj.SetMultiSeparator(",");
	 	}
	 	
	 	comboObj.SetColWidth(0, 40);
	 	comboObj.SetColWidth(1, 100);


	}    
	function initControl() {
		var formObject=document.form;
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
		// Axon Event Processing 1. Events catch (developers change)
		applyShortcut();
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
		combo1=comboObjects[0];
		comboCnt=comboObjects.length;
		// IBMultiCombo initialization
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
		document.form.btn_reroute.disabled = true;
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR,"","");
		document.form.sXml.value=null;
		initControl();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1: 
			with(sheetObj){
				var HeadTitle1="|Chk|Seq.|Doc\nType|Booking|Booking|Booking|B/L No|B/L\nType|Request|Request|Request|Request|Request|Request|Customer|Customer|Customer|Handling\nOffice|Origin|Delivery|POR|POR|POL|POD|DEL|DEL|Ship Date|Vessel|Vessel|Vessel|P/O No.|E-mail|Upload to OPUS|Upload to OPUS|Upload to OPUS|EDI ID|Sales Confirm|Sales Confirm|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd|pol|pod|Reject Reason|Cust Ref No|Xter Rqst Seq|bl_prf_shpr_flg|Change Office|Change Office|Change Office||||Vessel Service Lane|Booking Container size type|Request Container size type|xter rqst no";
				var HeadTitle2="|Chk|Seq.|Doc\nType|No.|U/L|ST|B/L No|B/L\nType|Date|No.|No.|Seq.|ST|Via|Shipper|Consignee|Forwarder|Handling\nOffice|Origin|Delivery|Code|Name|POL|POD|Code|Name|Ship Date|Code|Name|Voyage|P/O No.|E-mail|Office|Staff|Action Date|EDI ID|Confirm|By|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd|pol|pod|Reject Reason|Cust Ref No|Xter Rqst Seq|bl_prf_shpr_flg|Office|Staff|Action Date||||Vessel Service Lane|Booking Container size type|Request Container size type|xter rqst no";
//				SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataGetGetRowMerge:1 } );
				SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20} );
				var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers=[ { Text:HeadTitle1, Align:"Center"},
				              { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols=[ {Type:"Status",    Hidden:1, Width:30,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg" },
							{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
							{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"doc_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N", InputCaseSensitive:1 },
							{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_upld_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bl_iss_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_no2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"snaccs_split_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"xter_bkg_rqst_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_via_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"sh_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cn_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ff_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"hndl_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"origin",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"delivery",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"xter_por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"xter_por_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"xter_pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"xter_pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"xter_del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"xter_del_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dep_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"vsl_eng_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"po_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cntc_eml",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upld_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upld_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"xter_sndr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rqst_acpt_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"xter_rqst_acpt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"upld_usr_nm" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"xter_rqst_acpt_usr_nm" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"rqst_no" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"rqst_seq" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"sender_id" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vvd" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"xter_pol_nm" },
							{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"xter_pod_nm" },
							{Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"xter_rjct_rsn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cust_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"xter_rqst_rvis_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_prf_shpr_flg"},
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pre_hndl_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cng_hndl_ofc_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cng_hndl_ofc_upd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:140,   Align:"Center",  ColMerge:1,   SaveName:"new_ofc_cd"},
							{Type:"Text",      Hidden:1, Width:140,   Align:"Center",  ColMerge:1,   SaveName:"doc_tp"},
							{Type:"Text",      Hidden:1, Width:140,   Align:"Center",  ColMerge:1,   SaveName:"new_email"},
							
							{Type:"Text",      Hidden:0, Width:140,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cntr_tp_sz",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"rqst_cntr_tp_sz",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							];
				InitColumns(cols);
//				SetDataLinkMouse("xter_rqst_acpt_usr_id");
//				SetDataLinkMouse("upld_usr_id");
//				SetDataLinkMouse("upld_usr_nm");
				SetSheetHeight(355);
			}
			break;
		}
	}
	
	    function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
	        switch(sAction) {
			case IBSEARCH:      //Retrieve
				document.form.sXml.value=null;
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (sheetObj.id == "sheet1") {
	        		sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
		        	formObj.f_cmd.value=SEARCH;
		        	ComSearchAsync("ESM_BKG_0228GS.do", FormQueryString(formObj)+"&"+ "page_no=1", searchEnd);
				}
				break;
				
			case IBCLEAR:      //OPEN			
				initCom(formObj);
				ComClearObject(formObj.xter_rqst_no);
				ComClearObject(formObj.xter_rqst_seq);
				ComClearObject(formObj.set_slct_flg);
				ComClearObject(xter_bkg_rqst_sts_cd);
				ComClearObject(bkg_upld_sts_cd);
				ComClearObject(xter_rqst_via_cd);
				ComClearObject(doc_tp_cd);
				ComClearObject(delivery);
				ComClearObject(formObj.bkg_no);
				ComClearObject(formObj.po_no);
				ComClearObject(formObj.por_cd);
				ComClearObject(formObj.pol_cd);
				ComClearObject(formObj.pod_cd);
				ComClearObject(formObj.del_cd);
				ComClearObject(formObj.origin);
				ComClearObject(formObj.hndl_ofc_cd);
				bkg_cust_tp_cd.SetSelectCode("S");
				ComClearObject(formObj.cust_cnt_cd);
				ComClearObject(formObj.cust_seq);
				ComClearObject(formObj.cust_nm);
				ComClearObject(formObj.cntc_eml);
				ComClearObject(formObj.xter_sndr_id);
				ComClearObject(formObj.ofc_cd);
				formObj.rqst_from_dt.value=ComGetDateAdd(null, "d", -1, "-");
				formObj.rqst_to_dt.value=ComGetNowInfo();
				formObj.hndl_ofc_cd.value=formObj.usr_ofc_cd.value;
				sheetObj.RemoveAll();

	        	formObj.f_cmd.value=SEARCH03;
	        	var sXml=sheetObj.GetSearchData("ESM_BKG_0228GS.do", FormQueryString(formObj));
				if(ComGetEtcData(sXml, "authYn") =="Y") document.form.btn_reroute.disabled = false;

				break;
				
			case "btn_SRCH_SET": 
				var param="";
		 		ComOpenPopup("ESM_BKG_0232.do" + param, 825, 400, "PopupEsmBkg0232", "1,0", true);
				break;
				
			case "btn_exceldown":      //Excel down
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({HiddenColumn: 1, DownRows:"Visible"});
				}
				break;
				
			case "btn_preview":   
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				 rdOpen("preview");
				break;
			case "btn_previewprint": 
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				rdOpen("print");
				break;
				
			case "btn_upload":      //Upload
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				var param="";
				var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
				var chkRow=chkRowArr.split("|");
				//select doc type 체크 추가
				chkDocType(sheetObj, chkRow[0]); 		
				//openUploadWindow(sheetObj, chkRow[0]);
				break;
				
			case "btn_reject":      //Reject
				if(!validateForm(sheetObj,formObj,sAction))  return false;
					var formObj=document.form;
					var blprfshprflg=null;
					var bkgNo=null;
					var rqstNo=null;
					var rqstSeq=null;
					var senderId=null;
					var cntcEml=null;
					var docTpCd=null;
					var xterBkgRqstStsCd = null;
					
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
				for (var idx=0; idx<arrRow.length; idx++) {
					bkgNo = sheetObj.GetCellValue(arrRow[idx], "bkg_no");
					rqstNo = sheetObj.GetCellValue(arrRow[idx], "xter_rqst_no");
					rqstSeq = sheetObj.GetCellValue(arrRow[idx], "xter_rqst_seq");
					senderId = sheetObj.GetCellValue(arrRow[idx], "xter_sndr_id");
					cntcEml = sheetObj.GetCellValue(arrRow[idx], "cntc_eml");
					blprfshprflg = sheetObj.GetCellValue(arrRow[idx], "bl_prf_shpr_flg");
					docTpCd = sheetObj.GetCellValue(arrRow[idx], "doc_tp_cd");
					xterBkgRqstStsCd = sheetObj.GetCellValue(arrRow[idx], "xter_bkg_rqst_sts_cd");
					
					formObj.vvd2.value=sheetObj.GetCellValue(arrRow[idx], "vvd");
					formObj.vsl_nm2.value=sheetObj.GetCellValue(arrRow[idx], "vsl_eng_nm");
					formObj.bkg_por_cd2.value=sheetObj.GetCellValue(arrRow[idx], "xter_por_cd");
					formObj.por_nm2.value=sheetObj.GetCellValue(arrRow[idx], "xter_por_nm");
					formObj.bkg_pol_cd2.value=sheetObj.GetCellValue(arrRow[idx], "xter_pol_cd");
					formObj.pol_nm2.value=sheetObj.GetCellValue(arrRow[idx], "xter_pol_nm");
					formObj.bkg_pod_cd2.value=sheetObj.GetCellValue(arrRow[idx], "xter_pod_cd");
					formObj.pod_nm2.value=sheetObj.GetCellValue(arrRow[idx], "xter_pod_nm");
					formObj.bkg_del_cd2.value=sheetObj.GetCellValue(arrRow[idx], "xter_del_cd");
					formObj.del_nm2.value=sheetObj.GetCellValue(arrRow[idx], "xter_del_nm");
				}
				var param="?xter_bkg_rqst_sts_cd=" + xterBkgRqstStsCd + "&doc_tp_cd=" + docTpCd + "&bkg_no="+bkgNo+"&rqst_no="+encodeURIComponent(rqstNo)+"&rqst_seq="+rqstSeq+"&sender_id="+senderId+"&cntc_eml="+cntcEml + "&bl_prf_shpr_flg=" + blprfshprflg;
				ComOpenWindowCenter("/opuscntr/ESM_BKG_0902.do" + param, "	", 500, 500, true);
				break;
				
			case "btn_reroute":   
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				var param="";
		 		ComOpenPopup("ESM_BKG_0235.do" + param, 825, 420, "callBack0235", "1,0", true);
				break;

			case IBSEARCH_ASYNC01:        //Delete
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				if (sheetObj.id == "sheet1") {
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					var iRow=0;
					for (var idx=0; idx<arrRow.length; idx++) {
						iRow=arrRow[idx];
						sheetObj.SetCellValue(iRow, "rqst_no",sheetObj.GetCellValue(iRow, "xter_rqst_no"));
						sheetObj.SetCellValue(iRow, "rqst_seq",sheetObj.GetCellValue(iRow, "xter_rqst_seq"));
						sheetObj.SetCellValue(iRow, "sender_id",sheetObj.GetCellValue(iRow, "xter_sndr_id"));
						sheetObj.SetCellValue(iRow, "ibflag", "U");
					}
					formObj.f_cmd.value=MODIFY01;
					var quest = sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY01 , "slct_flg", true, true);
					if(quest){
						for (var idx=0; idx<arrRow.length; idx++) {
		            		sheetObj.SetCellValue(arrRow[idx], "bkg_upld_sts_cd",'D');
		            	}
					}
		        }
			break;
			
			case IBSEARCH_ASYNC02:        //Pending
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				if (sheetObj.id == "sheet1") {
					for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
						sheetObj.SetRowStatus(i,"R");
					}
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					var iRow=0;
					for (var idx=0; idx<arrRow.length; idx++) {
						iRow=arrRow[idx];
						sheetObj.SetRowStatus(iRow,"U");
						sheetObj.SetCellValue(iRow, "rqst_no",sheetObj.GetCellValue(iRow, "xter_rqst_no"));
						sheetObj.SetCellValue(iRow, "rqst_seq",sheetObj.GetCellValue(iRow, "xter_rqst_seq"));
						sheetObj.SetCellValue(iRow, "sender_id",sheetObj.GetCellValue(iRow, "xter_sndr_id"));
					}
					formObj.f_cmd.value=MODIFY02;
					//sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY02, "slct_flg", true, true);
					sheetObj.DoSave("ESM_BKG_0228GS.do", {Param: "f_cmd=" + MODIFY02,Col:"slct_flg",Quest:"false",UrlEncode:"true", Sync:1});
					

					
					for (var idx=0; idx<arrRow.length; idx++) {
		    			sheetObj.SetCellValue(arrRow[idx], "bkg_upld_sts_cd",'P');
		    		}
	        	}
			break;
			
	    	case IBSEARCH_ASYNC03:        //Booking No Save
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				if (sheetObj.id == "sheet1") {
					var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
					sheetObj.SetRowStatus(chkRow,"U");
					sheetObj.SetCellValue(chkRow, "rqst_no",sheetObj.GetCellValue(chkRow, "xter_rqst_no"));
					sheetObj.SetCellValue(chkRow, "rqst_seq",sheetObj.GetCellValue(chkRow, "xter_rqst_seq"));
					sheetObj.SetCellValue(chkRow, "sender_id",sheetObj.GetCellValue(chkRow, "xter_sndr_id"));
					formObj.f_cmd.value=MODIFY03;
					var sXml=sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY03, "slct_flg", true, true);
		    	}
				break;

	    	case IBSEARCH_ASYNC04:        //re-route
				if(!validateForm(sheetObj,formObj,sAction))  return false;
				if (sheetObj.id == "sheet1") {
					var chkRowArr=sheetObj.FindCheckedRow("slct_flg");
					var chkRow=chkRowArr.split("|");
					for (var idx=0; idx<chkRow.length; idx++) {
						sheetObj.SetRowStatus(chkRow[idx],"U");
						sheetObj.SetCellValue(chkRow[idx], "rqst_no",sheetObj.GetCellValue(chkRow[idx], "xter_rqst_no"));
						sheetObj.SetCellValue(chkRow[idx], "rqst_seq",sheetObj.GetCellValue(chkRow[idx], "xter_rqst_seq"));
						sheetObj.SetCellValue(chkRow[idx], "sender_id",sheetObj.GetCellValue(chkRow[idx], "xter_sndr_id"));
						sheetObj.SetCellValue(chkRow[idx], "doc_tp_cd",sheetObj.GetCellValue(chkRow[idx], "doc_tp_cd"));
						sheetObj.SetCellValue(chkRow[idx], "doc_tp",sheetObj.GetCellValue(chkRow[idx], "doc_tp_cd"));
					}
					formObj.f_cmd.value=MODIFY05;
					var sXml=sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY05, "slct_flg", true, true);
//					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
		    	}
				break;
	        }
	    }
	    
	    /**
	     * 
	     * @param sXml
	     */
		function searchEnd(sXml){
			ComOpenWait(false);
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == 'S'){
				sheetObjects[0].LoadSearchData(sXml);
			}
		}
	    
		function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	    	var bColor="#0000FF";
	    	var rColor="#FF0000";
	    	for(var i=2;i<sheetObjects[0].RowCount()+ 2;i++) {
	    		if (sheetObjects[0].GetCellValue(i, "bkg_upld_sts_cd") == "R" || sheetObjects[0].GetCellValue(i, "bkg_upld_sts_cd") == "D") {
		    		sheetObjects[0].SetRowFontColor(i,rColor);
	    		} else if (sheetObjects[0].GetCellValue(i, "bkg_upld_sts_cd") == "N" || sheetObjects[0].GetCellValue(i, "bkg_upld_sts_cd") == "P") {
		    		sheetObjects[0].SetRowFontColor(i,bColor);
		    	}
	    	}	
	    }
		
	    function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	    	ComOpenWait(false);
	        switch(document.form.f_cmd.value) {
	            case MODIFY01:
	                var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
	                var arrRow=iCheckRow.split("|");
	            	for (var idx=0; idx<arrRow.length - 1; idx++) {
	            		sheetObj.SetCellValue(arrRow[idx], "bkg_upld_sts_cd",'D');
	            	}
	            	break;
	            case MODIFY02:
	                var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
	                var arrRow=iCheckRow.split("|");
	    			for (var idx=0; idx<arrRow.length - 1; idx++) {
	    				sheetObj.SetCellValue(arrRow[idx], "bkg_upld_sts_cd",'P');
	    			}
	            	break;
	            case MODIFY03:
	    			if (code >= 0) {
	    				ComBkgSaveCompleted();
	    			} else {
	    				ComShowMessage(msgs['BKG00167']);
	    			}
	                break;
	        }
	    }
	    
		function openUploadWindow(sheetObj, row) {
			/*
			if ( encodeURIComponent(sheetObj.GetCellValue(row, "xter_sndr_id") == "SEANACCS" )) {
				ComOpenWait(true);
				var param01="f_cmd="+SEARCH02 + "&xter_rqst_no=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_rqst_no")) + "&xter_sndr_id=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_sndr_id")) + "&xter_rqst_seq=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_rqst_seq"))
				var sXml=sheetObj.GetSearchData("ESM_BKG_0228GS.do", param01);
				ComOpenWait(false);
				if(ComGetEtcData(sXml, "xterCreFlag") =="Y"){
					ComShowCodeMessage( "BKG02068", "Creation"  );
					return false;
				}
				if(ComGetEtcData(sXml, "xterSrFlag") =="Y"){
					ComShowCodeMessage( "BKG02068", "Previous"  );
					return false;
				}
			}
			*/
			var param="?rqst_no=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_rqst_no")) + "&rqst_seq=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_rqst_seq")) + "&sender_id=" + encodeURIComponent(sheetObj.GetCellValue(row, "xter_sndr_id")) + "&bkg_no=" + encodeURIComponent(sheetObj.GetCellValue(row, "bkg_no"))+ "&doc_tp_cd=" + encodeURIComponent(sheetObj.GetCellValue(row, "doc_tp_cd"));
			var date=new Date();
			var toDay=date.getYear()+""+ (date.getMonth()+1)+""+ date.getDate()+""+date.getHours()+""+date.getMinutes()+""+date.getSeconds();
			var winIdx=openUploadWindowCheck();
			if ( winIdx == 99){
				ComShowMessage(msgs['BKG95043']);
				return false;
			} else{
				var sFeatures = "status=no, resizable=no, scrollbars=0, width=" + screen.availWidth + ", height=" + (screen.availHeight - 60) + ", left=0, top=0";
//				arrWindow[winIdx]=ComOpenWindowCenter("ESM_BKG_0229.do" + param, "PopupEsmBkg0229" + toDay, screen.availWidth, screen.availHeight - 40, false);
				arrWindow[winIdx] = ComOpenWindow("ESM_BKG_0229.do" + param, "PopupEsmBkg0229" + toDay, sFeatures, false);
			}
		}
		
		function openUploadWindowCheck(){
			 for (var idx=0; idx< arrWindow.length ; idx++) {
				 if(arrWindow[idx] == null || arrWindow[idx].closed) 
					 return idx;
			 }
			 return 99;
		}
		/*
		 * Values ??of conditions all initialization 
		 * */
	    function initCom(formObject){    	
			var sXml=ComGetObjValue(formObject.sXml);
			arrMultiCombo=sXml.split(iterator); 
			ComXml2ComboItem(arrMultiCombo[0], xter_bkg_rqst_sts_cd, "val", "val|desc");
			ComXml2ComboItem(arrMultiCombo[1], bkg_upld_sts_cd, "val", "val|desc");
			bkg_upld_sts_cd.SetItemCheck(0,1);
			bkg_upld_sts_cd.SetItemCheck(2,1);
			ComXml2ComboItem(arrMultiCombo[2], xter_rqst_via_cd, "val", "val|desc");
			ComXml2ComboItem(arrMultiCombo[3], doc_tp_cd, "val", "val|desc");
			ComXml2ComboItem(arrMultiCombo[4], delivery, "val", "val|desc");
			ComBkgXml2ComboItem(arrMultiCombo[5], bkg_cust_tp_cd, "val", "name");
			bkg_cust_tp_cd.SetDropHeight(bkg_cust_tp_cd.GetItemCount()*bkg_cust_tp_cd.GetItemHeight()+1);
	    }
	    /**
	     * handling process for input validation
	     */
	 function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:
				if( formObj.rqst_from_dt.value == "" ){
					ComShowCodeMessage( "COM12114", "Request DT"  );
					// formObj.rqst_from_dt.focus();
					return false;
				}
				if( formObj.rqst_to_dt.value == "" ){
					ComShowCodeMessage( "COM12114", "Request DT"  );
					// formObj.rqst_to_dt.focus();
					return false;
				}
				if (formObj.rqst_from_dt.value != "" && formObj.rqst_to_dt.value != "") {
					if (ComGetDaysBetween(formObj.rqst_from_dt,formObj.rqst_to_dt) < 0) {
						ComShowMessage(msgs['BKG00112']);
						return false;
					}
				}
				break;
			case "btn_preview":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
				break;
			case "btn_previewprint":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				break;
			case "btn_upload":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
				break;
			case "btn_reject":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				} else {
					if (sheetObj.CheckedRows("slct_flg") > 1) {
						ComShowMessage(msgs['BKG00362']);
						return false;
					}
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					for (var idx=0; idx<arrRow.length; idx++) {
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
							ComShowMessage(msgs['BKG00471']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
							ComShowMessage(msgs['BKG00473']);
							return false;
						}
					}
				}
				break;
			case "btn_reroute":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				} else {
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					for (var idx=0; idx<arrRow.length; idx++) {
						if (sheetObj.GetCellValue(arrRow[idx], "doc_tp_cd") == "S") {
							ComShowMessage(msgs['BKG08328']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_sts_cd") != "" || (sheetObj.GetCellValue(arrRow[idx], "xter_rqst_via_cd") == "WEB" && sheetObj.GetCellValue(arrRow[idx], "xter_sndr_id") != "PEGASUS" )) {
							ComShowMessage(msgs['BKG08327']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "R" || sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
							ComShowMessage(msgs['BKG08329']);
							return false;
						}
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				} else {
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					for (var idx=0; idx<arrRow.length; idx++) {
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
							ComShowMessage(msgs['BKG00471']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
							ComShowMessage(msgs['BKG00473']);
							return false;
						}
					}
				}			
				break;
			case IBSEARCH_ASYNC02:
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				} else {
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					for (var idx=0; idx<arrRow.length; idx++) {
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
							ComShowMessage(msgs['BKG00471']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
							ComShowMessage(msgs['BKG00473']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "P") {
							ComShowMessage(msgs['BKG00472']);
							return false;
						}
					}
				}
				break;
			case IBSEARCH_ASYNC03:
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				} else {
					if (sheetObj.CheckedRows("slct_flg") > 1) {
						ComShowMessage(msgs['BKG00362']);
						return false;
					}
					var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
					var arrRow=iCheckRow.split("|");
					for (var idx=0; idx<arrRow.length; idx++) {
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
							ComShowMessage(msgs['BKG00471']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
							ComShowMessage(msgs['BKG00473']);
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "bkg_upld_sts_cd") == "F") {
							ComShowCodeMessage("BKG02049");
							return false;
						}
						if (sheetObj.GetCellValue(arrRow[idx], "xter_sndr_id") != "SEANACCS") {
							ComShowCodeMessage("BKG02060");
							return false;
						}
					}
				}
				break;
			}
		}
	    return true;
	}
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row=MouseRow();
			var colName=ColSaveName(MouseCol());
			if ( "xter_rqst_acpt_usr_id"== colName) {
			} else if ("upld_usr_id" == colName) {
			}
		}
	}
	/**
	 * sheet double click Event
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj, row, col) {
		if ( col != 1 ) {
			//Doc Type check후 Upload
			chkDocType(sheetObj, row);
			//openUploadWindow(sheetObj, row);
		}
	}
	
	 function chkDocType(sheetObj, Row){ 
		 //var formObj = document.form;
		 if( sheetObj.GetCellValue(Row, "doc_tp_cd") == 'F'){
			  if( ComShowConfirm(ComGetMsg("BKG01167")) ){
				  executeUpload(sheetObj, Row);
			  }
		 }else{
			 openUploadWindow(sheetObj, Row);
		 }

	 }
	 
	 function executeUpload(sheetObj, Row){
		 var sheetParam = "";
		 sheetParam = "&call_pgm_type="+sheetObj.GetCellValue(Row, "doc_tp_cd")
			+ "&bkg_no="+sheetObj.GetCellValue(Row, "bkg_no")
			+ "&xter_sndr_id="+sheetObj.GetCellValue(Row, "xter_sndr_id")
			+ "&xter_rqst_no="+sheetObj.GetCellValue(Row, "xter_rqst_no")
			+ "&xter_rqst_seq="+sheetObj.GetCellValue(Row, "xter_rqst_seq")
			
			var sXml = sheetObj.GetSaveData('ESM_BKG_0228GS.do', "f_cmd= "+MODIFY04 + sheetParam);
		 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", "");
	 }
	
	 var selComboIndex, selComboCode;
	 function xter_rqst_via_cd_OnSelect(comboObj, index, code) {
		 selComboIndex = index;
		 selComboCode = code;
	 }
	 function xter_rqst_via_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
		 //ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
		 document.form.xter_rqst_via_cd_text.value = comboObj.GetSelectCode();
	 }
	 function xter_rqst_via_cd_OnBlur(comboObj) {
		 //ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
		 document.form.xter_rqst_via_cd_text.value = comboObj.GetSelectCode();
	 }
	 
	 function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		 ComOpenWait(false);
		 alert("Data was saved successfully.");
	 }
	 
	function callBack0235(rArray) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if (rArray != null) {
			var iCheckRow=sheetObj.FindCheckedRow("slct_flg");
			var arrRow=iCheckRow.split("|");
			for (var idx=0; idx<arrRow.length; idx++) {
				sheetObj.SetCellValue(arrRow[idx], "pre_hndl_ofc_cd", sheetObj.GetCellValue(arrRow[idx], "hndl_ofc_cd"));
				sheetObj.SetCellValue(arrRow[idx], "cng_hndl_ofc_usr_id", formObj.usr_id.value);
				sheetObj.SetCellValue(arrRow[idx], "cng_hndl_ofc_upd_dt", rArray[0][6]);
				sheetObj.SetCellValue(arrRow[idx], "hndl_ofc_cd", rArray[0][2]);
				sheetObj.SetCellValue(arrRow[idx], "new_ofc_cd", rArray[0][2]);
	    		if (sheetObj.GetCellValue(arrRow[idx], "doc_tp_cd") == "B") {
					sheetObj.SetCellValue(arrRow[idx], "new_email", rArray[0][4]);
	    		}else{
					sheetObj.SetCellValue(arrRow[idx], "new_email", rArray[0][5]);
	    		}
	    		
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04,"","");
		}	
	}
	
	/**
 	 * RD 파라미터
 	 * @param viewType
 	 * @returns {Array}
 	 */
	function getRdData(viewType){
		var rdData = [];
		var sheetObj = sheetObjects[0];
		var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		var rdUrl = "apps/opus/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
		if(viewType == "print"){
			var rdParams = [];
			for (var idx = 0; idx < chkRow.length; idx++) {
				var rdParam = "/rv " + "frm1_sender_id["+sheetObj.GetCellValue(chkRow[idx], "xter_sndr_id")+"] frm1_rqst_no["+sheetObj.GetCellValue(chkRow[idx], "xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.GetCellValue(chkRow[idx], "xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.GetCellValue(chkRow[idx], "bkg_no")+"]";
				var rdFile = null;
				if ( sheetObj.GetCellValue(chkRow[idx], "doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
				else rdFile = "ESM_BKG_0230S.mrd";
				rdParams.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile});
			}
			rdData.push(rdParams);
		}else{
			var rdParam = "/rv " + "frm1_sender_id["+sheetObj.GetCellValue(chkRow[0], "xter_sndr_id")+"] frm1_rqst_no["+sheetObj.GetCellValue(chkRow[0], "xter_rqst_no")+"] frm1_rqst_seq["+sheetObj.GetCellValue(chkRow[0], "xter_rqst_seq")+"] frm1_bkg_no["+sheetObj.GetCellValue(chkRow[0], "bkg_no")+"]";
			var rdFile = null;
			if ( sheetObj.GetCellValue(chkRow[0], "doc_tp_cd") == "B" ) rdFile = "ESM_BKG_0230B.mrd";
			else rdFile = "ESM_BKG_0230S.mrd";
			rdData.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile, 'width' : 800, 'height' : 600});
		}
		return rdData;
	}