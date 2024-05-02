/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1066.js
*@FileTitle : Pick up No Notice Manual Send
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
							  MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
							  Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
	/**
	 * @fileoverview
	 * @author
	 */
	/**
	 * @extends
	 * @class esm_bkg_1066 : esm_bkg_1066 - task script definition for screen
	 */
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var receiverList=new Array();
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name <br>
	 *
	 * @return void
	 * @author
	 * @version
	 */
	function processButtonClick(){
		/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "img_dt":
				ComSetObjValue(formObject.sch_tp_cd, "ATA");
				setMandantorySearchType();
				var cal=new ComCalendarFromTo();
				cal.select(formObject.dt_s, formObject.dt_e, 'yyyy-MM-dd');
				break;
			case "img_mvmt_dt":
				ComSetObjValue(formObject.sch_tp_cd, "MVMT");
				setMandantorySearchType();
				var cal=new ComCalendarFromTo();
				cal.select(formObject.dt_mvmt_s, formObject.dt_mvmt_e, 'yyyy-MM-dd');
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBRESET);
				break;
			case "btn_PickUpNoUpload":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC06);
				break;
			case "btn_History":			// History 버튼 추가
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC13);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_StopSend":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC11);
				break;
			case "btn_ResumeSend":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC12);
				break;
			case "btn_Fax":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
				break;
			case "btn_Email":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
				break;
			case "btn_Preview":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC03);
				break;
			case "btn_ManualSetup":
				ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0993.do', 1006, 360, "", "none", true);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				break;
			case "btn_SendHistory":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC04);
				break;
			case "btn_ReceiverSetup":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC05);
				break;
			case "btn_FormSetup":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC08);
				break;
			case "btn_CustomerInfo":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC09);
				break;
			case "btn_MasterData":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC10);
				break;
			case "btn_MultiContact":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC14);
				break;
			case "btn_RailAMSHistory":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC15);
				break;
			case "btn_UsIor":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC16);
				break;
			case "btn_Close":
				ComClosePopup();
				break;
			 } // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * registering IBSheet Object as list<br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 *
	 * @param {IBSheet} sheet_obj
	 * @return
	 */
   function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
   }
   /**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen. <br>
	*
	* @return
	*/
	function loadPage() {
		var formObj=document.form;
		fnInSetComboBox(formObj.mvmt_cd, evtCode, evtValue, "|", "", "ALL", true, "");
		fnInSetComboBox(formObj.ntc_tp_cd, evtTypeCode, evtTypeValue, "|", "", "All", true, "");
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		initControl();
		if (document.form.bl_no.value != "") {
			initForm("BL");
		} else {
			initForm();
		}
		if (document.form.bl_no.value != "" && ComGetObjValue(document.form.sch_tp_cd) == "BL") {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		document.form.ntc_tp_cd.selectedIndex = 0;
		document.form.mvmt_cd.selectedIndex = 0;
	}
	/**
	 * Form data initialization task. value initialization
	 *
	 * @param {string} flag
	 * @return
	 */
	function initForm(flag) {
		with(document.form) {
			var endDay=ComGetDateAdd(endDay, "D", 6, "-");
			var startDay=ComGetNowInfo("ymd", "-");
			dt_s.value=startDay;
			dt_e.value=endDay;
			dt_mvmt_s.value=startDay;
			dt_mvmt_e.value=endDay;
			tm_mvmt_s.value="00:00";
			tm_mvmt_e.value="23:59";
			mvmt_cd.value="";
			dt_tp_cd.value="SENT";
			eq_ofc_cd.value="";
			upd_usr_id.value="";
			snd_sts_cd.value="";
			ntc_tp_cd.value="";
			foc_tp_cd.value="";
			rail_co_cd.value="";
			ow_flag.checked=false;
			contact_flag.checked=false;
			stop_flag.checked=false;
			if (flag != null && flag == "BL") {
				ComSetObjValue(sch_tp_cd, "BL");
			} else {
				bl_no.value="";
				ComSetObjValue(sch_tp_cd, "DATE");
			}
			setMandantorySearchType();
			fncEnableFocType(ntc_tp_cd.value);
		}
	}
	/**
	 * Enroll HTML eag event <br>
	 *
	 * @return
	 */
	function initControl() {

		axon_event.addListener("click","obj_click", "sch_tp_cd", "dt_s", "dt_e", "bl_no", "mvmt_cd", "dt_mvmt_s", "dt_mvmt_e", "tm_mvmt_s", "tm_mvmt_e");
		axon_event.addListener("blur","obj_deactivate", "dt_s", "dt_e", "dt_mvmt_s", "dt_mvmt_e", "tm_mvmt_s", "tm_mvmt_e");
		axon_event.addListener("change","obj_change", "ntc_tp_cd");
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * Click event handling.<br>
	 *
	 * @return
	 */
	function obj_click() {
		var formObject=document.form;
		switch(ComGetEvent("name")) {
		case "sch_tp_cd":
			setMandantorySearchType();
			break;
		case "dt_s":
		case "dt_e":
			ComSetObjValue(formObject.sch_tp_cd, "DATE");
			setMandantorySearchType();
			break;
		case "mvmt_cd":
		case "dt_mvmt_s":
		case "dt_mvmt_e":
		case "tm_mvmt_s":
		case "tm_mvmt_e":
			ComSetObjValue(formObject.sch_tp_cd, "MVMT");
			setMandantorySearchType();
			break;
		case "bl_no":
			ComSetObjValue(formObject.sch_tp_cd, "BL");
			setMandantorySearchType();
			break;
		}
	}
	/**
	 * Blue event handling<br>
	 *
	 * @return
	 */
	function obj_deactivate() {
		switch(event.srcElement.name) {
			case "dt_s":
			case "dt_e":
			case "dt_mvmt_s":
			case "dt_mvmt_e":
			case "tm_mvmt_s":
			case "tm_mvmt_e":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	/**
	 * Change event handling<br>
	 *
	 * @return
	 */
	function obj_change() {
		switch(event.srcElement.name) {
			case "ntc_tp_cd":
				fncEnableFocType(event.srcElement.value);
				break;
		}
	}
	/**
	* FOC search condition Enable/Disable handling<br>
	*
	* @param {string}
	* @return
	*/
	function fncEnableFocType(val) {
		with (document.form) {
			if (val == "FC" || val == "TO") {
				foc_tp_cd.disabled=false;
			} else {
				foc_tp_cd.disabled=true;
				foc_tp_cd.value="";
			}
		}
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
	 * initializing Tab <br>
	 * setting Tab items <br>
	 *
	 * @param {object}
	 * @param {int}
	 * @return
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( "Pick up Data" , "");
					InsertItem( "Fax" , "");
					InsertItem( "E-Mail" , "");
				}
				break;
		}
	}
	/**
	 * Event when clicking Tab <br>
	 * activating selected tab items<br>
	 *
	 * @param {object}
	 * @param {int}
	 * @return
	 */
	function tab1_OnChange(tabObj , nItem) {
		//var btnObj = document.getElementById("btn_Setup");
		with (sheetObjects[0]) {
			RenderSheet(0);
			switch(nItem) {
				case 0:
					ComBtnDisable("btn_ReceiverSetup");
					ComBtnDisable("btn_Fax");
					ComBtnDisable("btn_Email");
					SetColHidden("rail_lod_dt",0);
					SetColHidden("pkup_aval_dt",0);
					SetColHidden("lst_free_dt",0);
					SetColHidden("pkup_yd_cd",0);
					SetColHidden("rtn_yd_cd",0);
					SetColHidden("pkup_no_upld_dt",0);
					SetColHidden("pkup_no_upld_via",0);
					SetColHidden("pkup_no_upld_usr_id",0);
					SetColHidden("pod_cd",0);
					SetColHidden("ibd_trsp_hub_cd",0);
					SetColHidden("del_cd",0);
					SetColHidden("nvocc_file_no",0);
					SetColHidden("de_term_cd",0);
					SetColHidden("dor_trkr_wo_flg",0);
					SetColHidden("rout_gid_desc",0);
					SetColHidden("vvd_id",0);
					SetColHidden("over_wgt_flg",1);
					SetColHidden("cntr_wgt",1);
					SetColHidden("sn",1);
					SetColHidden("bkg_cust_tp_cd",1);
					SetColHidden("cust_cd",1);
					SetColHidden("cust_nm",1);
					SetColHidden("pkup_ntc_fom_cd_show",1);
					SetColHidden("bl",1);
					SetColHidden("eclz_obl_cpy_flg",1);
					SetColHidden("mnl_flg_show",1);
					SetColHidden("c1_fax_no_chk",1);
					SetColHidden("c1_fax_no",1);
					SetColHidden("c2_fax_no_chk",1);
					SetColHidden("c2_fax_no",1);
					SetColHidden("b1_fax_no_chk",1);
					SetColHidden("b1_fax_no",1);
					SetColHidden("b2_fax_no_chk",1);
					SetColHidden("b2_fax_no",1);
					SetColHidden("an_fax_no_chk",1);
					SetColHidden("an_fax_no",1);
					SetColHidden("fax_snd_dt",1);
					SetColHidden("c1_ntc_eml_chk",1);
					SetColHidden("c1_ntc_eml",1);
					SetColHidden("c2_ntc_eml_chk",1);
					SetColHidden("c2_ntc_eml",1);
					SetColHidden("b1_ntc_eml_chk",1);
					SetColHidden("b1_ntc_eml",1);
					SetColHidden("b2_ntc_eml_chk",1);
					SetColHidden("b2_ntc_eml",1);
					SetColHidden("an_ntc_eml_chk",1);
					SetColHidden("an_ntc_eml",1);
					SetColHidden("eml_snd_dt",1);
					SetColHidden("diff_rmk",1);
					break;
				case 1:
					ComBtnEnable("btn_ReceiverSetup");
					ComBtnEnable("btn_Fax");
					ComBtnDisable("btn_Email");
					SetColHidden("rail_lod_dt",1);
					SetColHidden("pkup_aval_dt",1);
					SetColHidden("lst_free_dt",1);
					SetColHidden("pkup_yd_cd",1);
					SetColHidden("rtn_yd_cd",1);
					SetColHidden("pkup_no_upld_dt",1);
					SetColHidden("pkup_no_upld_via",1);
					SetColHidden("pkup_no_upld_usr_id",1);
					SetColHidden("pod_cd",1);
					SetColHidden("ibd_trsp_hub_cd",1);
					SetColHidden("del_cd",1);
					SetColHidden("nvocc_file_no",1);
					SetColHidden("de_term_cd",1);
					SetColHidden("dor_trkr_wo_flg",1);
					SetColHidden("rout_gid_desc",1);
					SetColHidden("vvd_id",1);
					SetColHidden("over_wgt_flg",0);
					SetColHidden("cntr_wgt",0);
					SetColHidden("sn",0);
					SetColHidden("bkg_cust_tp_cd",0);
					SetColHidden("cust_cd",0);
					SetColHidden("cust_nm",0);
					SetColHidden("pkup_ntc_fom_cd_show",0);
					SetColHidden("bl",0);
					SetColHidden("eclz_obl_cpy_flg",0);
					SetColHidden("mnl_flg_show",0);
					SetColHidden("c1_fax_no_chk",0);
					SetColHidden("c1_fax_no",0);
					SetColHidden("c2_fax_no_chk",0);
					SetColHidden("c2_fax_no",0);
					SetColHidden("b1_fax_no_chk",0);
					SetColHidden("b1_fax_no",0);
					SetColHidden("b2_fax_no_chk",0);
					SetColHidden("b2_fax_no",0);
					SetColHidden("an_fax_no_chk",0);
					SetColHidden("an_fax_no",0);
					SetColHidden("fax_snd_dt",0);
					SetColHidden("c1_ntc_eml_chk",1);
					SetColHidden("c1_ntc_eml",1);
					SetColHidden("c2_ntc_eml_chk",1);
					SetColHidden("c2_ntc_eml",1);
					SetColHidden("b1_ntc_eml_chk",1);
					SetColHidden("b1_ntc_eml",1);
					SetColHidden("b2_ntc_eml_chk",1);
					SetColHidden("b2_ntc_eml",1);
					SetColHidden("an_ntc_eml_chk",1);
					SetColHidden("an_ntc_eml",1);
					SetColHidden("eml_snd_dt",1);
					SetColHidden("diff_rmk",0);
					break;
				case 2:
					ComBtnEnable("btn_ReceiverSetup");
					ComBtnDisable("btn_Fax");
					ComBtnEnable("btn_Email");
					SetColHidden("rail_lod_dt",1);
					SetColHidden("pkup_aval_dt",1);
					SetColHidden("lst_free_dt",1);
					SetColHidden("pkup_yd_cd",1);
					SetColHidden("rtn_yd_cd",1);
					SetColHidden("pkup_no_upld_dt",1);
					SetColHidden("pkup_no_upld_via",1);
					SetColHidden("pkup_no_upld_usr_id",1);
					SetColHidden("pod_cd",1);
					SetColHidden("ibd_trsp_hub_cd",1);
					SetColHidden("del_cd",1);
					SetColHidden("nvocc_file_no",1);
					SetColHidden("de_term_cd",1);
					SetColHidden("dor_trkr_wo_flg",1);
					SetColHidden("rout_gid_desc",1);
					SetColHidden("vvd_id",1);
					SetColHidden("over_wgt_flg",0);
					SetColHidden("cntr_wgt",0);
					SetColHidden("sn",0);
					SetColHidden("bkg_cust_tp_cd",0);
					SetColHidden("cust_cd",0);
					SetColHidden("cust_nm",0);
					SetColHidden("pkup_ntc_fom_cd_show",0);
					SetColHidden("bl",0);
					SetColHidden("eclz_obl_cpy_flg",0);
					SetColHidden("mnl_flg_show",0);
					SetColHidden("c1_fax_no_chk",1);
					SetColHidden("c1_fax_no",1);
					SetColHidden("c2_fax_no_chk",1);
					SetColHidden("c2_fax_no",1);
					SetColHidden("b1_fax_no_chk",1);
					SetColHidden("b1_fax_no",1);
					SetColHidden("b2_fax_no_chk",1);
					SetColHidden("b2_fax_no",1);
					SetColHidden("an_fax_no_chk",1);
					SetColHidden("an_fax_no",1);
					SetColHidden("fax_snd_dt",1);
					SetColHidden("c1_ntc_eml_chk",0);
					SetColHidden("c1_ntc_eml",0);
					SetColHidden("c2_ntc_eml_chk",0);
					SetColHidden("c2_ntc_eml",0);
					SetColHidden("b1_ntc_eml_chk",0);
					SetColHidden("b1_ntc_eml",0);
					SetColHidden("b2_ntc_eml_chk",0);
					SetColHidden("b2_ntc_eml",0);
					SetColHidden("an_ntc_eml_chk",0);
					SetColHidden("an_ntc_eml",0);
					SetColHidden("eml_snd_dt",0);
					SetColHidden("diff_rmk",0);
				break;
			}
			RenderSheet(1);
		}
	}
	/**
	 * setting sheet initial values and header<br>
	 * adding case as numbers of counting sheets <br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {number}  sheetNo
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
		case "sheet1":
			with(sheetObj){
					 var HeadTitle1=
					 "||Show PU#|Seq.|bkg No|ntcSeq|Type|MVMT|B/L No.|Cancel|Container|Over|Weight(LBS)|Rail Load Date|" +
					 "Available Date|Last Free Date|Pick-up No|Pick-up YD|Flag|Return YD|F|O|C|Customs|" +
					 "Receive DT|Via|Sender|POD|CLOC|DEL|Filer|Term|Door W/O|Route Guide|VVD|" +
					 "SN|TP|cntCd|custSeq|Code|Customer Name|formCd|Form|B/L|Verify||" +
					 "CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|" +
					 "Broker #1|Broker #1|Broker #1|Broker #1|Broker #2|Broker #2|Broker #2|Broker #2|" +
					 "One Time Only|One Time Only|One Time Only|One Time Only|Sent Date|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|CNEE/NTFY|" +
					 "CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|CNEE/NTFY #2|Broker #1|Broker #1|Broker #1|Broker #1|" +
					 "Broker #2|Broker #2|Broker #2|Broker #2|One Time Only|One Time Only|One Time Only|One Time Only|Sent Date|Remark(s)|" +
					 "Send Sts.|Sent DT|Sent ID|Stop Auto Send|Stop ID|Resume Auto Send|Resume ID||||";
					 var headCount=ComCountHeadTitle(HeadTitle1);

					 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

					 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					 InitHeaders(headers, info);

					 var cols = [{Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                  Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"show_pu_flg",          Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
								 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ntc_seq",              Format:"",        Edit:0 },
								 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_tp_cd",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"edi_322_mvmt_cd",      Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_snd_sts_cd",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"over_wgt_flg",         Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",             Format:"Integer", Edit:0 },
								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rail_lod_dt",          Format:"YmdHm",   Edit:0 },

								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pkup_aval_dt",         Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"lst_free_dt",          Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no",              Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_yd_cd",           Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pkup_yd_cd_flg",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rtn_yd_cd",            Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",          Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"obl_clt_flg",          Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_flg",        Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_cd",         Format:"",        Edit:0 },

								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pkup_no_upld_dt",      Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no_upld_via",     Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pkup_no_upld_usr_id",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibd_trsp_hub_cd",      Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"nvocc_file_no",        Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",           Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dor_trkr_wo_flg",      Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:800,  Align:"Left",    ColMerge:1,   SaveName:"rout_gid_desc",        Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_id",               Format:"",        Edit:0 },

								 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"snd_yn",               Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",          Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",             Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",              Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:215,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",              Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_fom_cd",      Format:"",        Edit:0 },
								 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pkup_ntc_fom_cd_show", Format:"",        Edit:1 },
								 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eclz_obl_cpy_flg",     Format:"",        Edit:1 },
								 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg_show",         Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mnl_flg",              Format:"",        Edit:0 },

								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_fax_no_chk",        Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"c1_fax_no",            Format:"",        Edit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_fax_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_fax_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_fax_no_chk",        Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"c2_fax_no",            Format:"",        Edit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_fax_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_fax_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_fax_no_chk",        Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"b1_fax_no",            Format:"",        Edit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_fax_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_fax_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_fax_no_chk",        Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"b2_fax_no",            Format:"",        Edit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_fax_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_fax_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_fax_no_chk",        Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"an_fax_no",            Format:"",        Edit:1,   EditLen:20 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_fax_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_fax_snd_flg",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_snd_dt",           Format:"YmdHm",   Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_ntc_eml_chk",       Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"c1_ntc_eml",           Format:"",        Edit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_eml_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c1_eml_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_ntc_eml_chk",       Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"c2_ntc_eml",           Format:"",        Edit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_eml_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"c2_eml_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_ntc_eml_chk",       Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"b1_ntc_eml",           Format:"",        Edit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_eml_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b1_eml_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_ntc_eml_chk",       Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"b2_ntc_eml",           Format:"",        Edit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_eml_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"b2_eml_snd_flg",       Format:"",        Edit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_ntc_eml_chk",       Format:"",        Edit:1,   EditLen:-1 },
								 {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"an_ntc_eml",           Format:"",        Edit:1,   EditLen:200 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_eml_ntc_snd_rslt",  Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"an_eml_snd_flg",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dt",           Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",             Format:"",        Edit:1,   EditLen:4000 },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"snd_sts_desc",         Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",               Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",           Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"auto_snd_stop_dt",     Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"auto_snd_stop_usr_id", Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"auto_snd_resm_dt",     Format:"YmdHm",   Edit:0 },
								 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"auto_snd_resm_usr_id", Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",   Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",          Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",       Format:"",        Edit:0 },
								 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cop_pkup_yd_cd",       Format:"",        Edit:0 }];

					 InitColumns(cols);

					 SetEllipsis(1);
					 SetEditable(1);
					/* SetColProperty("rail_lod_dt", {Format:"####-##-####:##"} );
					 SetColProperty("pkup_aval_dt", {Format:"####-##-##"} );
					 SetColProperty("lst_free_dt", {Format:"####-##-##"} );
					 SetColProperty("pkup_no_upld_dt", {Format:"####-##-####:##"} );
					 SetColProperty("fax_snd_dt", {Format:"####-##-####:##"} );
					 SetColProperty("eml_snd_dt", {Format:"####-##-####:##"} );
					 SetColProperty("snd_dt", {Format:"####-##-####:##"} );
					 SetColProperty("auto_snd_stop_dt", {Format:"####-##-####:##"} );
					 SetColProperty("auto_snd_resm_dt", {Format:"####-##-####:##"} );*/
					 //conversion of function[check again]CLT                 InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
					 //conversion of function[check again]CLT                 InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "0123456789");
					 //conversion of function[check again]CLT                 InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789/");
					 //conversion of function[check again]CLT                 InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
					 //conversion of function[check again]CLT                 InitDataValid(0, "c1_fax_no", vtNumericOther, "-");
					 //conversion of function[check again]CLT                 InitDataValid(0, "c2_fax_no", vtNumericOther, "-");
					 //conversion of function[check again]CLT                 InitDataValid(0, "b1_fax_no", vtNumericOther, "-");
					 //conversion of function[check again]CLT                 InitDataValid(0, "b2_fax_no", vtNumericOther, "-");
					 //conversion of function[check again]CLT                 InitDataValid(0, "an_fax_no", vtNumericOther, "-");
					SetColProperty("pkup_ntc_fom_cd_show", {ComboText:evtEventValue, ComboCode:evtEventCode} );
					SetColProperty("pkup_ntc_tp_cd", {ComboText:evtTypeValue, ComboCode:evtTypeCode} );
					SetColProperty("eclz_obl_cpy_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
					SetBasicImeMode(imeEng);
					SetSheetHeight(430);
					SetAutoRowHeight(0);
				 }
			break;
		}
	}
	/**
	 * handling sheet process <br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {object}  formObj
	 * @param {string}  sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetDataAutoTrim(0);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
		// Reset
		case IBRESET:
			sheetObj.RemoveAll();
			initForm();
			break;
			// SEARCH
		case IBSEARCH:
			if (validateForm(sheetObj,formObj,sAction) == false) break;
			ComOpenWait(true);
			sheetObj.SetHeaderCheck(0, "chk",0);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_1066GS.do", FormQueryString(formObj), {Sync:1});
			break;
			// SAVE
		case IBSAVE:
			var sXml="";
			if (validateForm(sheetObj,formObj,sAction) == false) break;
			var sParamSheet1=sheetObj.GetSaveString(false, true, "chk");
			var sParamSheet2=sheetObj.GetSaveString(false, true, "mnl_flg");
			if (sParamSheet1 == "" && sParamSheet2 == "") {
				ComShowCodeMessage("BKG00743");
				break;
			}
			ComOpenWait(true);
			// Save
			if (sParamSheet1 != "") {
				formObj.f_cmd.value=MULTI;
				var sParam=FormQueryString(formObj);
				sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
				sXml=sheetObj.GetSaveData("ESM_BKG_1066GS.do", sParam);
				if (sParamSheet2 == "") sheetObj.LoadSaveData(sXml);
				if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F") {
					ComOpenWait(false);
					break;
				}
			}
			// Verify
			if (sParamSheet2 != "") {
				formObj.f_cmd.value=MULTI20;
				sParam=FormQueryString(formObj);
				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
				sXml=sheetObj.GetSaveData("ESM_BKG_1066GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			}
			sheetObj.SetHeaderCheck(0, "chk",0);
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
			break;
		case IBSEARCH_ASYNC01: // Fax sending
		case IBSEARCH_ASYNC02: // Email sending
			if (validateForm(sheetObj,formObj,sAction) == false) break;
			ComOpenWait(true);
			for(var i=0; i < sheetObj.RowCount(); i++) {
			if(sheetObj.GetCellValue(i+1, "chk") == "1") {
			if (sheetObj.GetCellValue(i+1, "pkup_ntc_fom_cd_show") != "" &&
			sheetObj.GetCellValue(i+1, "pkup_ntc_fom_cd") != sheetObj.GetCellValue(i+1, "pkup_ntc_fom_cd_show")) {
			sheetObj.SetCellValue(i+1, "pkup_ntc_fom_cd",sheetObj.GetCellValue(i+1, "pkup_ntc_fom_cd_show"),0);
								}
			sheetObj.SetCellValue(i+1, "mnl_flg",sheetObj.GetCellValue(i+1, "mnl_flg_show") == 1 ? "Y" : "N",0);
				}
			}
			if (sAction == IBSEARCH_ASYNC01) formObj.f_cmd.value=MULTI01;
			else formObj.f_cmd.value=MULTI02;
			var sParam=FormQueryString(formObj);
			var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
			if (sParamSheet != "") {
				sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
			}
			sheetObj.SetHeaderCheck(0, "chk",0);
			var sXml=sheetObj.GetSaveData("ESM_BKG_1066GS.do", sParam);
			//if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowCodeMessage("BKG00496");
			}
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
			break;
		 // Stop Send
		case IBSEARCH_ASYNC11:
			// Resume Send
		case IBSEARCH_ASYNC12:
			if (validateForm(sheetObj,formObj,sAction) == false) break;
			ComOpenWait(true);
			if (sAction == IBSEARCH_ASYNC11) formObj.f_cmd.value=MULTI11;
			else formObj.f_cmd.value=MULTI12;
			var sParam=FormQueryString(formObj);
			var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
			if (sParamSheet != "") {
				sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
			}
			sheetObj.SetHeaderCheck(0, "chk",0);
			var sXml=sheetObj.GetSaveData("ESM_BKG_1066GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
			break;
			// Preview
		case IBSEARCH_ASYNC03:

			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var sRowStr=sheetObj.GetSelectionRows("/");
			// make java script array
			var arr=sRowStr.split("/");
			if (arr.length < 1) {
				ComShowCodeMessage("BKG00149");
				break;
			} else if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var vRow=arr[0];
			if (sheetObj.GetCellValue(vRow,"ntc_seq") == "") {
				ComShowCodeMessage("BKG00178");
				break;
			}
			var usr_id=formObj.usr_id.value;
			var ofc_cd=formObj.usr_ofc_cd.value;
			var bkg_no=sheetObj.GetCellValue(vRow, "bkg_no");
			var ntc_seq=sheetObj.GetCellValue(vRow, "ntc_seq");
			var pkup_ntc_fom_cd=sheetObj.GetCellValue(vRow, "pkup_ntc_fom_cd_show");
			var pkup_yd_cd=sheetObj.GetCellValue(vRow, "pkup_yd_cd");
			var pod_cd  =sheetObj.GetCellValue(vRow, "pod_cd");
			var del_cd  =sheetObj.GetCellValue(vRow, "del_cd");
			var rtn_yd_cd=sheetObj.GetCellValue(vRow, "rtn_yd_cd");
			var rmk=sheetObj.GetCellValue(vRow, "diff_rmk").replace("'","''");
			var show_pu=sheetObj.GetCellValue(vRow, "show_pu_flg");

			if((pkup_yd_cd !="" && pkup_yd_cd == "CAHAL01") || pod_cd.substring(0,2) == "CA" && del_cd.substring(0,2) =="CA"){
			 formObj.com_mrdTitle.value="PickUp Notice";
			 formObj.com_mrdBodyTitle.value="PickUp Notice";
			 formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5032.mrd";
			 formObj.com_mrdArguments.value="/rv bkg_no['" + bkg_no + "'] ntc_seq[''] usr_id['" + usr_id + "'] " +
												 "ofc_cd['" + ofc_cd + "'] p_pkup_ntc_fom_cd['" + pkup_ntc_fom_cd + "'] " +
												 "p_pkup_yd_cd['" + pkup_yd_cd + "'] p_rtn_yd_cd['" + rtn_yd_cd + "'] p_rmk['" + rmk + "'] " +
												 "form_showPuFlg['" + show_pu + "']";

			}
			else{
			formObj.com_mrdTitle.value="PickUp Notice";
			formObj.com_mrdBodyTitle.value="PickUp Notice";
			formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/ESM_BKG_5018.mrd";
			formObj.com_mrdArguments.value="/rv bkg_no['" + bkg_no + "'] ntc_seq[''] usr_id['" + usr_id + "'] " +
											 "ofc_cd['" + ofc_cd + "'] p_pkup_ntc_fom_cd['" + pkup_ntc_fom_cd + "'] " +
											 "p_pkup_yd_cd['" + pkup_yd_cd + "'] p_rtn_yd_cd['" + rtn_yd_cd + "'] p_rmk['" + rmk + "'] " +
											 "form_showPuFlg['" + show_pu + "']";
			}

			ComOpenRDPopup();
			break;
			// EXCEL DOWNLOAD
		case IBDOWNEXCEL:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00109");
				break;
			}
//     	    sheetObj.Down2Excel({ HiddenColumn:1});
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
			// History
		case IBSEARCH_ASYNC04:
			var bl_no="";
			if (sheetObj.RowCount()> 0) {
				var sRowStr=sheetObj.GetSelectionRows("/");
				//make java script array
				var arr=sRowStr.split("/");
				if (arr.length < 1) {
					ComShowCodeMessage("BKG00149");
					break;
				} else if (arr.length > 1) {
					ComShowCodeMessage("BKG40075");
					break;
				}
				bl_no=sheetObj.GetCellValue(arr[0], "bl_no");
			}
			var param="&autoSearchFlg=Y&sch_tp=B&bl_no=" + bl_no;
			ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0414_POP.do?pgmNo=ESM_BKG_0414&mainPage=false' + param, 1200, 700, "", "none", false);
			break;
			// Data Setup
		case IBSEARCH_ASYNC07:
			var iCheckRow=sheetObj.CheckedRows("chk");
			if (iCheckRow < 1) {
				ComShowCodeMessage("BKG00149");
				break;
			}
			var resultObj=ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1065.do', 450, 250, "", "none", false);
			if (resultObj != null) {
				ComOpenWait(true);
				fncSetInfo(sheetObj, resultObj);
				ComOpenWait(false);
			}
			break;
			// Receiver Setup
		case IBSEARCH_ASYNC05:
			if (validateForm(sheetObj,formObj,sAction) == false) break;
			receiverList=fncGetReceiverInfo();
			ComOpenPopup('/opuscntr/ESM_BKG_0995.do', 906, 400, "receiverSetup", "1,0,1,1,1,1,1", false);
			break;
			// Form Setup
		case IBSEARCH_ASYNC08:
			//ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1034_POP.do?pgmNo=ESM_BKG_1034&mainPage=false', 1100, 550, "", "none", false);
			ComOpenPopup('/opuscntr/ESM_BKG_1034_POP.do?pgmNo=ESM_BKG_1034&mainPage=false', 1100, 550, "PopupEsmBkg1066", "1,0,1,1,1,1,1", false);
			break;
			// Customer Info
		case IBSEARCH_ASYNC09:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var sRowStr=sheetObj.GetSelectionRows("/");
			//make java script array
			var arr=sRowStr.split("/");
			if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var param="&bkg_no=" + sheetObj.GetCellValue(arr[0], "bkg_no");
			ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0242.do?pgmNo=ESM_BKG_0242' + param, 570, 380, "", "none", true);
			break;
			// Master Data
		case IBSEARCH_ASYNC10:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var sRowStr=sheetObj.GetSelectionRows("/");
			//make java script array
			var arr=sRowStr.split("/");
			if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var param="&autoSearchFlg=Y" +
				"&cust_cnt_cd=" + sheetObj.GetCellValue(arr[0], "cust_cnt_cd") +
				"&cust_seq=" + ComLpad(sheetObj.GetCellValue(arr[0], "cust_seq"),6,"0");
			ComOpenPopupWithTarget('/opuscntr/ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240' + param, 1024, 670, "", "none", true);
			break;
			// Multi-Contact
		case IBSEARCH_ASYNC14:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var sRowStr=sheetObj.GetSelectionRows("/");
			//make java script array
			var arr=sRowStr.split("/");
			if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var param="&cust_cnt_cd=" + sheetObj.GetCellValue(arr[0], "cust_cnt_cd") +
			"&cust_seq=" + ComLpad(sheetObj.GetCellValue(arr[0], "cust_seq"),6,"0") +
			"&cust_nm=" + sheetObj.GetCellValue(arr[0], "cust_nm");
			ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1044.do?pgmNo=ESM_BKG_1044' + param, 800, 380, "", "none", true);
			break;
			// Rail AMS History
		case IBSEARCH_ASYNC15:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var sRowStr=sheetObj.GetSelectionRows("/");
			//make java script array
			var arr=sRowStr.split("/");
			if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var param="&cntr_no=" + sheetObj.GetCellValue(arr[0], "cntr_no") + "&vvd=" + sheetObj.GetCellValue(arr[0], "vvd_id");

			ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1037.do?pgmNo=ESM_BKG_1037' + param, 1024, 610, "", "none", false);
			break;
		case IBSEARCH_ASYNC16:
			var param="&eq_ofc_cd=" + formObj.usr_ofc_cd.value;
			ComOpenPopupWithTarget('/opuscntr/ESD_SCE_0056_POP.do?pgmNo=ESD_SCE_0056' + param, 1024, 610, "", "none", false);
			break;
			// PickUp No Upload
		case IBSEARCH_ASYNC06:
			var bl_no="";
			if (sheetObj.RowCount()> 0) {
				var sRowStr=sheetObj.GetSelectionRows("/");
				//make java script array
				var arr=sRowStr.split("/");
				if (arr.length >= 1) {
					bl_no=sheetObj.GetCellValue(arr[0], "bl_no");
				}
			}
			var param="&popUp=Y&sch_tp_cd=BL&bl_no=" + bl_no;
			//ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1063_POP.do?pgmNo=ESM_BKG_1063&mainPage=false' + param, 1110, 700, "NoticeSend", "none", false);
			ComOpenWindowCenter('/opuscntr/ESM_BKG_1063_POP.do?pgmNo=ESM_BKG_1063&mainPage=false' + param, 'NoticeSend', 1110, 570, false, false);

			break;
		case IBSEARCH_ASYNC13:
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var arr=(sheetObj.GetSelectionRows("/")).split("/");
			if (arr.length < 1) {
				ComShowCodeMessage("BKG00149");
				break;
			} else if (arr.length > 1) {
				ComShowCodeMessage("BKG40075");
				break;
			}
			var vRow=arr[0];
			var param="&bkg_no=" + sheetObj.GetCellValue(vRow, "bl_no") +
			"&cntr_no=" + sheetObj.GetCellValue(vRow, "cntr_no") +
			"&ofc_cd=" + sheetObj.GetCellValue(vRow, "eq_ctrl_ofc_cd");
			//ComOpenPopupWithTarget('/opuscntr/ESM_BKG_1067.do?pgmNo=ESM_BKG_1067'+param, 906, 460, "", "none", true);
			ComOpenWindowCenter("/opuscntr/ESM_BKG_1067.do?"+param, "History", 1250 ,510,false, false);
			break;

		}
	}
	function receiverSetup(resultList) {
		ComOpenWait(true);
		fncSetReceiverInfo(resultList);
		ComOpenWait(false);
	}
	/**
	 * Sheet1 DblClick event handling<br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		with(sheetObj) {
			// showing Pickup No as double click
			switch (ColSaveName(Col)) {
			case "diff_rmk":
				SetCellEditable(Row, Col,0);
				ComShowMemoPad(sheetObj, Row, Col, false, 450,60);
				SetCellEditable(Row, Col,1);
				break;
			case "cust_nm":
				if(sheetObj.GetRowHeight(Row) == 20){
					sheetObj.SetRowHeight(Row,0);
				} else {
					sheetObj.SetRowHeight(Row,20);
				}
				break;
			}
		}
	}
	/**
	 * Sheet1 Key Down event  handling<br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @param {string}  Value
	 * @return
	 */
//    function sheet1_OnKeyDown(sheetObj, Row, Col, Value) {
////    	with(sheetObj) {
////    		switch(ColSaveName(Col)) {
////    		case "c1_fax_no":
////    		case "c2_fax_no":
////    		case "b1_fax_no":
////    		case "b2_fax_no":
////    		case "an_fax_no":
////    		case "c1_ntc_eml":
////    		case "c2_ntc_eml":
////    		case "b1_ntc_eml":
////    		case "b2_ntc_eml":
////    		case "an_ntc_eml":
////    			SetCellValue(Row, "chk",1,0);
////    			SetCellValue(Row, (Col - 1),1,0);
////    			break;
////    		}
////    	}
//    }
	/**
	 *  If Row check box has changed, row about email/fax uncheck
	 *
	 *
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @param {string}  checkValue
	 * @return
	 */
	function fncChangeSubCheckBox(sheetObj, Row, Col, checkValue) {
		with(sheetObj) {
			// In case of Check, if there is Fax/Email value, Check
			if (checkValue == 1)
			{
				//CellValue2(i+1, "mnl_flg_show") = checkValue;
				// Fax Notice
			if (GetCellEditable(Row, "c1_fax_no_chk") && GetCellValue(Row, "c1_fax_no") != "") SetCellValue(Row, "c1_fax_no_chk",checkValue,0);
			if (GetCellEditable(Row, "c2_fax_no_chk") && GetCellValue(Row, "c2_fax_no") != "") SetCellValue(Row, "c2_fax_no_chk",checkValue,0);
			if (GetCellEditable(Row, "b1_fax_no_chk") && GetCellValue(Row, "b1_fax_no") != "") SetCellValue(Row, "b1_fax_no_chk",checkValue,0);
			if (GetCellEditable(Row, "b2_fax_no_chk") && GetCellValue(Row, "b2_fax_no") != "") SetCellValue(Row, "b2_fax_no_chk",checkValue,0);
			if (GetCellEditable(Row, "an_fax_no_chk") && GetCellValue(Row, "an_fax_no") != "") SetCellValue(Row, "an_fax_no_chk",checkValue,0);
							// Email Notice
			if (GetCellEditable(Row, "c1_ntc_eml_chk") && GetCellValue(Row, "c1_ntc_eml") != "") SetCellValue(Row, "c1_ntc_eml_chk",checkValue,0);
			if (GetCellEditable(Row, "c2_ntc_eml_chk") && GetCellValue(Row, "c2_ntc_eml") != "") SetCellValue(Row, "c2_ntc_eml_chk",checkValue,0);
			if (GetCellEditable(Row, "b1_ntc_eml_chk") && GetCellValue(Row, "b1_ntc_eml") != "") SetCellValue(Row, "b1_ntc_eml_chk",checkValue,0);
			if (GetCellEditable(Row, "b2_ntc_eml_chk") && GetCellValue(Row, "b2_ntc_eml") != "") SetCellValue(Row, "b2_ntc_eml_chk",checkValue,0);
			if (GetCellEditable(Row, "an_ntc_eml_chk") && GetCellValue(Row, "an_ntc_eml") != "") SetCellValue(Row, "an_ntc_eml_chk",checkValue,0);
			}
			else
			{
				// Fax Notice
				SetCellValue(Row, "c1_fax_no_chk",checkValue,0);
				SetCellValue(Row, "c2_fax_no_chk",checkValue,0);
				SetCellValue(Row, "b1_fax_no_chk",checkValue,0);
				SetCellValue(Row, "b2_fax_no_chk",checkValue,0);
				SetCellValue(Row, "an_fax_no_chk",checkValue,0);
				// Email Notice
				SetCellValue(Row, "c1_ntc_eml_chk",checkValue,0);
				SetCellValue(Row, "c2_ntc_eml_chk",checkValue,0);
				SetCellValue(Row, "b1_ntc_eml_chk",checkValue,0);
				SetCellValue(Row, "b2_ntc_eml_chk",checkValue,0);
				SetCellValue(Row, "an_ntc_eml_chk",checkValue,0);
			}
		}
	}
	/**
	* If Row check box has changed, changing check mark for BL
	* @param {ibsheet} sheetObj
	* @param {int}     Row
	* @param {int}     Col
	* @param {string}  checkValue
	* @return
	*/
	function fncChangeCheckBoxByBL(sheetObj, Row, Col, checkValue) {
		with(sheetObj) {
			var bl_no=GetCellValue(Row, "bl_no");
			var bkg_cust_tp_cd=GetCellValue(Row, "bkg_cust_tp_cd");
			for (var i=0; i<RowCount(); i++) {
				// Per unit of BL-mail / fax Edit
				if (GetCellValue(i+1, "bl_no") == bl_no && GetCellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
					SetCellValue(i+1, "chk",checkValue,0);
					//if (checkValue == 1) CellValue2(i+1, "mnl_flg_show") = checkValue;
					fncChangeSubCheckBox(sheetObj, i+1, Col, checkValue);
				}
			}
		}
	}
	/**
	 * If Fax/Email  check box has changed, changing check mark for BL
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @param {string}  checkValue
	 * @return
	 */
	function fncChangeSubCheckBoxByBL(sheetObj, Row, Col, checkValue) {
		with(sheetObj) {
			var bl_no=GetCellValue(Row, "bl_no");
			var bkg_cust_tp_cd=GetCellValue(Row, "bkg_cust_tp_cd");
			for (var i=0; i<RowCount(); i++) {
				// Per unit of BL-mail / fax Edit
				if (GetCellValue(i+1, "bl_no") == bl_no && GetCellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
					if (checkValue == 1) SetCellValue(i+1, "chk",checkValue,0);
					SetCellValue(i+1, Col,checkValue,0);
				}
			}
		}
	}
	/**
	 * Row E-mail / fax, if the change occurred ,customer for the same email / fax to the batch of changes.
	 *
	 *
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @param {string}  Value
	 * @return
	 */
	function fncChangeSendInfoByBL(sheetObj, Row, Col, Value) {
		with(sheetObj) {
			var colName=ColSaveName(Col);
			var bl_no=GetCellValue(Row, "bl_no");
			var bkg_cust_tp_cd=GetCellValue(Row, "bkg_cust_tp_cd");
			for (var i=0; i<RowCount(); i++) {
				// Per unit of BL-mail / fax Edit
				if (GetCellValue(i+1, "bl_no") == bl_no && GetCellValue(i+1, "bkg_cust_tp_cd") == bkg_cust_tp_cd) {
					if (Value != "") SetCellValue(i+1, "chk",1,0);
					if (Value == "") {
						SetCellValue(i+1, colName+"_chk",0,0);
					} else {
						SetCellValue(i+1, colName+"_chk",1,0);
					}
					SetCellValue(i+1, colName,Value,0);
				}
			}
		}
	}
	/**
	 * Sheet1 changing event handling<br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {int}     Row
	 * @param {int}     Col
	 * @param {string}  Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		with(sheetObj) {
			var colName=ColSaveName(Col);
			var bl_no=GetCellValue(Row, "bl_no");
			switch (ColSaveName(Col)) {
			case "chk":
				fncChangeCheckBoxByBL(sheetObj, Row, Col, Value);
				break;
			case "mnl_flg_show":
				var mnl_flg="";
				if (Value == CellSearchValue(Row, Col)) mnl_flg="";
				else mnl_flg=Value == 1 ? "Y" : "N";
				SetCellValue(Row, "mnl_flg",mnl_flg,0);
				break;
			case "c1_fax_no_chk":
			case "c2_fax_no_chk":
			case "b1_fax_no_chk":
			case "b2_fax_no_chk":
			case "an_fax_no_chk":
			case "c1_ntc_eml_chk":
			case "c2_ntc_eml_chk":
			case "b1_ntc_eml_chk":
			case "b2_ntc_eml_chk":
			case "an_ntc_eml_chk":
				fncChangeSubCheckBoxByBL(sheetObj, Row, Col, Value);
				break;
			case "c1_fax_no":
			case "c2_fax_no":
			case "b1_fax_no":
			case "b2_fax_no":
			case "an_fax_no":
			case "c1_ntc_eml":
			case "c2_ntc_eml":
			case "b1_ntc_eml":
			case "b2_ntc_eml":
			case "an_ntc_eml":
			case "pkup_ntc_fom_cd_show":
			case "eclz_obl_cpy_flg":
			case "diff_rmk":
				fncChangeSendInfoByBL(sheetObj, Row, Col, Value);
				break;
			}
		}
	}
	/**
	 * handling process for input validation <br>
	 *
	 * @param {ibsheet} sheetObj
	 * @param {object}  formObj
	 * @param {string}  sAction
	 * @return boolean Form
	 */
	function validateForm(sheetObj,formObj,sAction) {
		with(sheetObj) {
			switch(sAction) {
			case IBSEARCH:
				if (!ComChkValid(formObj)) return false;
				if(ComGetObjValue(formObj.sch_tp_cd) == "DATE") {
					if(ComGetDaysBetween(formObj.dt_s.value, formObj.dt_e.value) > 7) {
						ComShowCodeMessage("BKG40008", "7");
						ComSetFocus(formObj.dt_s);
						return false;
					}
				}
				else if(ComGetObjValue(formObj.sch_tp_cd) == "MVMT") {
					if(ComGetDaysBetween(formObj.dt_mvmt_s.value, formObj.dt_mvmt_e.value) > 7) {
						ComShowCodeMessage("BKG40008", "7");
						ComSetFocus(formObj.dt_mvmt_s);
						return false;
					}
				}
				break;
			case IBSAVE:
				for(var i=0; i <RowCount(); i++) {
						if(GetRowStatus(i+1) == "U") {
						// E-mail form check
						if (GetCellValue(i+1, "c1_ntc_eml") != "" && ComIsEmailAddr(GetCellValue(i+1, "c1_ntc_eml")) == false) {
							ComShowCodeMessage("BKG00366");
							SelectCell(i+1, "c1_ntc_eml");
							return false;
						}
						if (GetCellValue(i+1, "c2_ntc_eml") != "" && ComIsEmailAddr(GetCellValue(i+1, "c2_ntc_eml")) == false) {
							ComShowCodeMessage("BKG00366");
							SelectCell(i+1, "c2_ntc_eml");
							return false;
						}
						if (GetCellValue(i+1, "b1_ntc_eml") != "" && ComIsEmailAddr(GetCellValue(i+1, "b1_ntc_eml")) == false) {
							ComShowCodeMessage("BKG00366");
							SelectCell(i+1, "b1_ntc_eml");
							return false;
						}
						if (GetCellValue(i+1, "b2_ntc_eml") != "" && ComIsEmailAddr(GetCellValue(i+1, "b2_ntc_eml")) == false) {
							ComShowCodeMessage("BKG00366");
							SelectCell(i+1, "b2_ntc_eml");
							return false;
						}
						if (GetCellValue(i+1, "an_ntc_eml") != "" && ComIsEmailAddr(GetCellValue(i+1, "an_ntc_eml")) == false) {
							ComShowCodeMessage("BKG00366");
							SelectCell(i+1, "an_ntc_eml");
							return false;
						}
					}
				}
				break;
				// Fax Send
			case IBSEARCH_ASYNC01:
				//read checked row number. result->"3|5|10|"
				var sCheckRow=FindCheckedRow("chk");
				var arrRow=sCheckRow.split("|");
				//if (arrRow.length < 1) {
				if (sCheckRow == "" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
				var checked=0;
				for (var i=0; i<RowCount(); i++) {
					checked=0;
					if (GetCellValue(i+1, "chk") == "1") {
						if (GetCellValue(i+1, "c1_fax_no_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "c1_fax_no") == "") {
								ComShowCodeMessage("BKG00577");
								SelectCell(i+1, "c1_fax_no");
								return false;
							}
						}
						if (GetCellValue(i+1, "c2_fax_no_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "c2_fax_no") == "") {
								ComShowCodeMessage("BKG00577");
								SelectCell(i+1, "c2_fax_no");
								return false;
							}
						}
						if (GetCellValue(i+1, "b1_fax_no_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "b1_fax_no") == "") {
								ComShowCodeMessage("BKG00577");
								SelectCell(i+1, "b1_fax_no");
								return false;
							}
						}
						if (GetCellValue(i+1, "b2_fax_no_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "b2_fax_no") == "") {
								ComShowCodeMessage("BKG00577");
								SelectCell(i+1, "b2_fax_no");
								return false;
							}
						}
						if (GetCellValue(i+1, "an_fax_no_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "an_fax_no") == "") {
								ComShowCodeMessage("BKG00577");
								SelectCell(i+1, "an_fax_no");
								return false;
							}
						}
						if (checked == 0) {
							ComShowCodeMessage("BKG40018");
							return false;
						}

						// DAte form check
						if (GetCellValue(i+1, "pkup_aval_dt") != "" && ComIsDateTime2(GetCellValue(i+1, "pkup_aval_dt"),"ymdhm") == false) {
							ComShowCodeMessage("BKG00921");
							SelectCell(i+1, "pkup_aval_dt");
							return false;
						}
						if (GetCellValue(i+1, "lst_free_dt") != "" && ComIsDateTime2(GetCellValue(i+1, "lst_free_dt"),"ymdhm") == false) {
							ComShowCodeMessage("BKG00921");
							SelectCell(i+1, "lst_free_dt");
							return false;
						}
						if (GetCellValue(i+1, "pkup_aval_dt") != "" && GetCellValue(i+1, "lst_free_dt") != "") {
							if (ComGetDaysBetween(GetCellValue(i+1, "pkup_aval_dt"), GetCellValue(i+1, "lst_free_dt")) <0) {
								ComShowCodeMessage("BKG40016");
								SelectCell(i+1, "lst_free_dt");
								return false;
							}
						}
						if (GetCellValue(i+1, "cop_pkup_yd_cd") != GetCellValue(i+1, "pkup_yd_cd")) {
							ComShowMessage("Please check the Pick Up Yard from COP data");
							return false;
						}
					}
				}
				break;
				// Email Send
			case IBSEARCH_ASYNC02:
				//read checked row number. result->"3|5|10|"
				var sCheckRow=FindCheckedRow("chk");
				var arrRow=sCheckRow.split("|");
				//if (arrRow.length < 1) {
				if (sCheckRow == "" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
				var checked=0;
				for (var i=0; i<RowCount(); i++) {
					checked=0;
					if (GetCellValue(i+1, "chk") == "1") {
						if (GetCellValue(i+1, "c1_ntc_eml_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "c1_ntc_eml") == "" || ComIsEmailAddr(GetCellValue(i+1, "c1_ntc_eml")) == false) {
								ComShowCodeMessage("BKG00366");
								SelectCell(i+1, "c1_ntc_eml");
								return false;
							}
						}
						if (GetCellValue(i+1, "c2_ntc_eml_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "c2_ntc_eml") == "" || ComIsEmailAddr(GetCellValue(i+1, "c2_ntc_eml")) == false) {
								ComShowCodeMessage("BKG00366");
								SelectCell(i+1, "c2_ntc_eml");
								return false;
							}
						}
						if (GetCellValue(i+1, "b1_ntc_eml_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "b1_ntc_eml") == "" || ComIsEmailAddr(GetCellValue(i+1, "b1_ntc_eml")) == false) {
								ComShowCodeMessage("BKG00366");
								SelectCell(i+1, "b1_ntc_eml");
								return false;
							}
						}
						if (GetCellValue(i+1, "b2_ntc_eml_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "b2_ntc_eml") == "" || ComIsEmailAddr(GetCellValue(i+1, "b2_ntc_eml")) == false) {
								ComShowCodeMessage("BKG00366");
								SelectCell(i+1, "b2_ntc_eml");
								return false;
							}
						}
						if (GetCellValue(i+1, "an_ntc_eml_chk") == "1") {
							checked++;
							if (GetCellValue(i+1, "an_ntc_eml") == "" || ComIsEmailAddr(GetCellValue(i+1, "an_ntc_eml")) == false) {
								ComShowCodeMessage("BKG00366");
								SelectCell(i+1, "an_ntc_eml");
								return false;
							}
						}
						if (checked == 0) {
							ComShowCodeMessage("BKG40019");
							return false;
						}

						// Date form check
						if (GetCellValue(i+1, "pkup_aval_dt") != "" && ComIsDateTime2(GetCellValue(i+1, "pkup_aval_dt"),"ymdhm") == false) {
							ComShowCodeMessage("BKG00921");
							SelectCell(i+1, "pkup_aval_dt");
							return false;
						}
						if (GetCellValue(i+1, "lst_free_dt") != "" && ComIsDateTime2(GetCellValue(i+1, "lst_free_dt"),"ymdhm") == false) {
							ComShowCodeMessage("BKG00921");
							SelectCell(i+1, "lst_free_dt");
							return false;
						}

						if (GetCellValue(i+1, "pkup_aval_dt") != "" && GetCellValue(i+1, "lst_free_dt") != "") {
							if (ComGetDaysBetween(GetCellValue(i+1, "pkup_aval_dt"), GetCellValue(i+1, "lst_free_dt")) <0) {
								ComShowCodeMessage("BKG40016");
								SelectCell(i+1, "lst_free_dt");
								return false;
							}
						}
						if (GetCellValue(i+1, "cop_pkup_yd_cd") != GetCellValue(i+1, "pkup_yd_cd")) {
							ComShowMessage("Please check Pick Up Yard from COP data");
							return false;
						}
					}
				}
				break;
				// Stop Send
			case IBSEARCH_ASYNC11:
				// Resume Send
			case IBSEARCH_ASYNC12:
				//read checked row number. result->"3|5|10|"
				var sCheckRow=FindCheckedRow("chk");
				var arrRow=sCheckRow.split("|");
				if (sCheckRow == "" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
				break;
				// Receiver Setup
			case IBSEARCH_ASYNC05:
				//read checked row number. result->"3|5|10|"
				var sCheckRow=FindCheckedRow("chk");
				var arrRow=sCheckRow.split("|");
				//if (arrRow.length < 0) {
				if (sCheckRow == "" ) {
					ComShowCodeMessage("BKG00249");
					return false;
				}
				break;
			}
		}
		return true;
	}
	/**
	 *  create sender information<br>
	 *
	 * @return array.
	 */
	function fncGetReceiverInfo() {
		var arrInfo=new Array();
		var info=null;
		var idx=0;
		with (sheetObjects[0]) {
			for (var i=0; i<RowCount(); i++) {
				if (GetCellValue(i+1, "chk") == "0") continue;
				info=new Object();
				info.seq=GetCellValue(i+1, "seq");
				info.bl_no=GetCellValue(i+1, "bl_no");
				info.cntr_no=GetCellValue(i+1, "cntr_no");
				info.cust_nm=GetCellValue(i+1, "cust_nm");
				info.c2_fax_no=GetCellValue(i+1, "c2_fax_no");
				info.c2_fax_snd_flg=GetCellValue(i+1, "c2_fax_snd_flg");
				info.b1_fax_no=GetCellValue(i+1, "b1_fax_no");
				info.b1_fax_snd_flg=GetCellValue(i+1, "b1_fax_snd_flg");
				info.b2_fax_no=GetCellValue(i+1, "b2_fax_no");
				info.b2_fax_snd_flg=GetCellValue(i+1, "b2_fax_snd_flg");
				info.c2_ntc_eml=GetCellValue(i+1, "c2_ntc_eml");
				info.c2_eml_snd_flg=GetCellValue(i+1, "c2_eml_snd_flg");
				info.b1_ntc_eml=GetCellValue(i+1, "b1_ntc_eml");
				info.b1_eml_snd_flg=GetCellValue(i+1, "b1_eml_snd_flg");
				info.b2_ntc_eml=GetCellValue(i+1, "b2_ntc_eml");
				info.b2_eml_snd_flg=GetCellValue(i+1, "b2_eml_snd_flg");
				arrInfo[idx++]=info;
			}
		}
		return arrInfo;
	}
	/**
	 * sender Information changing <br>
	 *
	 * @param {array}
	 */
	function fncSetReceiverInfo(arrInfo) {
		with (sheetObjects[0]) {
			var info=null;
			var vRow=-1;
			for (var i=0; i<arrInfo.length; i++) {
				info=arrInfo[i];
				vRow=FindText("seq", info.seq);
				if (GetCellValue(vRow, "chk") == "0") {
					alert("Error!!");
					return;
				}
				//Manual or the Sent status can be modified, so if you create a new Data
				if (GetCellValue(vRow, "pkup_ntc_tp_cd") == "MA" ||
						GetCellValue(vRow, "pkup_ntc_snd_sts_cd") == "Y") {
					SetCellValue(vRow, "pkup_ntc_fom_cd_show",info.fom_cd,0);
				}
				if (GetCellValue(vRow, "c2_fax_snd_flg") != "N") {
					SetCellValue(vRow, "c2_fax_no",info.c2_fax_no,0);
					if (GetCellValue(vRow, "c2_fax_no") == "") SetCellValue(vRow, "c2_fax_no_chk",0,0);
					else SetCellValue(vRow, "c2_fax_no_chk",1,0);
				}
				if (GetCellValue(vRow, "b1_fax_snd_flg") != "N") {
					SetCellValue(vRow, "b1_fax_no",info.b1_fax_no,0);
					if (GetCellValue(vRow, "b1_fax_no") == "") SetCellValue(vRow, "b1_fax_no_chk",0,0);
					else SetCellValue(vRow, "b1_fax_no_chk",1,0);
				}
				if (GetCellValue(vRow, "b2_fax_snd_flg") != "N") {
					SetCellValue(vRow, "b2_fax_no",info.b2_fax_no,0);
					if (GetCellValue(vRow, "b2_fax_no") == "") SetCellValue(vRow, "b2_fax_no_chk",0,0);
					else SetCellValue(vRow, "b2_fax_no_chk",1,0);
				}
				if (GetCellValue(vRow, "c2_eml_snd_flg") != "N") {
					SetCellValue(vRow, "c2_ntc_eml",info.c2_ntc_eml,0);
					if (GetCellValue(vRow, "c2_ntc_eml") == "") SetCellValue(vRow, "c2_ntc_eml_chk",0,0);
					else SetCellValue(vRow, "c2_ntc_eml_chk",1,0);
				}
				if (GetCellValue(vRow, "b1_eml_snd_flg") != "N") {
					SetCellValue(vRow, "b1_ntc_eml",info.b1_ntc_eml,0);
					if (GetCellValue(vRow, "b1_ntc_eml") == "") SetCellValue(vRow, "b1_ntc_eml_chk",0,0);
					else SetCellValue(vRow, "b1_ntc_eml_chk",1,0);
				}
				if (GetCellValue(vRow, "b2_eml_snd_flg") != "N") {
					SetCellValue(vRow, "b2_ntc_eml",info.b2_ntc_eml,0);
					if (GetCellValue(vRow, "b2_ntc_eml") == "") SetCellValue(vRow, "b2_ntc_eml_chk",0,0);
					else SetCellValue(vRow, "b2_ntc_eml_chk",1,0);
				}
			}
		}
	}
	/**
	 * click row's AVL DT, FRE DT, Pick-up YD, Return YD setting information
	 * change to object information
	 *
	 * @param sheetObj
	 * @param infoObj
	 * @return
	 */
	function fncSetInfo(sheetObj, infoObj) {
		with(sheetObj) {
			var idx=0;
			var sRow=FindCheckedRow("chk");
			var arrRow=sRow.split("|");
			if ( sRow != "") {
				for (i=0; i<arrRow.length-1; i++) {
					idx=arrRow[i];
					if (GetCellValue(idx, "chk") != "1") continue;
					if (infoObj.avl_dt != "") {
						SetCellValue(idx, "pkup_aval_dt",infoObj.avl_dt,0);
					}
					if (infoObj.fre_dt != "") {
						SetCellValue(idx, "lst_free_dt",infoObj.fre_dt,0);
					}
					if (infoObj.pkup_yd_cd != "") {
						SetCellValue(idx, "pkup_yd_cd",infoObj.pkup_yd_cd,0);
					}
					if (infoObj.rtn_yd_cd != "") {
						SetCellValue(idx, "rtn_yd_cd",infoObj.rtn_yd_cd,0);
					}
				}
			}
		}
	}
	/**
	 * setiing necessary condition
	 */
	function setMandantorySearchType() {
		with(document.form) {
			setNotRequiredObject(dt_s, dt_e, bl_no, dt_mvmt_s, dt_mvmt_e, tm_mvmt_s, tm_mvmt_e);
			var schVal=ComGetObjValue(sch_tp_cd);
			if (schVal == "DATE") {
				setRequiredObject(dt_s, dt_e);
			} else if (schVal == "BL") {
				setRequiredObject(bl_no);
			} else if (schVal == "MVMT") {
				setRequiredObject(dt_mvmt_s, dt_mvmt_e, tm_mvmt_s, tm_mvmt_e);
			} else {
			}
		}
	}
	/**
	 * setting necessary condition
	 *
	 * @param
	 */
	function setRequiredObject() {
		for(var i=0; i<arguments.length; i++) {
			setRequiredMode(arguments[i], true);
		}
		if (arguments.length == 1)
			arguments[0].focus();
	}
	/**
	 * setting that it is not necessary condition
	 *
	 * @param
	 * @return
	 */
	function setNotRequiredObject() {
		for(var i=0; i<arguments.length; i++) {
			setRequiredMode(arguments[i], false);
		}
	}
	/**
	 * Object Required attribute setting
	 *
	 * @param obj
	 * @param requireMode
	 * @return
	 */
	function setRequiredMode(obj, requireMode) {
		if (requireMode == true) {
			obj.setAttribute("required", true);
		} else {
			obj.removeAttribute("required");
		}
	}
	/**
	 * Search End Event Handling
	 */
 function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	ComOpenWait(false);
	if (sheetObj.RowCount()> 0) {
		sheetObj.CheckAll("show_pu_flg",1);
	}
}