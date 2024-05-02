/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0210.js
*@FileTitle  : Customs Data Download
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
*/

/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var isLoaded=false;
	var vPod="";
	var vPol="";
	var intervalId="";
	var vStartRow=2;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 *  Event handler processing by button name
	 */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1= sheetObjects[0];
		var sheetObject2= sheetObjects[1];
		var sheetObject3= sheetObjects[2];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				break;
			case "btn_datadl":
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
			case "btn_edi":
				doActionIBSheet(sheetObject2, formObject, SEARCH01);
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObject1, formObject, MULTI05);
			break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}

	/**
	 * handling buttons on loading
	 */
	function SetButtonStatus(){
			// Customs Common Code 테이블의 NA_STAFF 인 경우에만 Data Delete 버튼 활성화
			if(sheetObjects[0].GetCellValue(1, "na_stf_flg")=="Y"){
				document.getElementById("btn_Delete").style.display='';
			}else{
				document.getElementById("btn_Delete").style.display='none';
			}
		}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		if (document.form.customs.value.substring(0, 6) == 'Origin') {
			ComBtnDisable("btn_edi");
		}
		//handling event
		axon_event.addListenerForm("click", "obj_Click", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		document.form.vvd.focus();
	}

	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 * @param sheetObj sheet Object
	 * @param sheetNo sequence of sheet Object tag
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet0":      //sheet0 init
				with(sheetObj){
				  var HeadTitle=" |Seq.|POL|ETD|POD|ETA|T.BDR|BDR Time|Full|Empty|Total M.B/L|Total H.B/L";
				  var headCount=ComCountHeadTitle(HeadTitle) + 1;
				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);
				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"Seq"},
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bdr_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ful_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"emp_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"tot_mbl",     KeyField:0,   CalcLogic:"|8|+|9|",Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"tot_hbl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"clpt_seq" },
						 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"na_stf_flg" }];
				  InitColumns(cols);
				  SetEditable(1);
				  SetColProperty("vps_etd_dt", {Format:"####-##-####:##"} );
				  SetColProperty("vps_eta_dt", {Format:"####-##-####:##"} );
				  SetColProperty("bdr_dt", {Format:"####-##-####:##"} );
				  SetSheetHeight(158);
			  }
		 break;

		 case "sheet2":      //sheet2 init
				with(sheetObj){
				   var HeadTitle1=" ||Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|BDR|C/A No.|Terminal EDI|Terminal EDI||||";
				   var HeadTitle2=" ||Seq.|B/L No.|BKG_NO|Cntr Mf No.|Filer|Empty|I/F|Error|POL|POD|Package|Package|Weight|Weight|N|A|N|A|N|A|BDR|C/A No.|EDI|Sent Time|DEL_CD|POD_NOD_CD|DEL_NOD_CD|BL_TYPE";
				   var headCount=ComCountHeadTitle(HeadTitle1) + 3;
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"},
								   { Text:HeadTitle2, Align:"Center"} ];
				   InitHeaders(headers, info);
				   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						  {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk", Sort:0 },
						  {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
						  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bl_nos",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"filer",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"emp_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"if_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"err_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"act_wgt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"shpr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"shpr_ad",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"cnee_ad",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ntfy_ad",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ca_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"edi_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_snd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"pod_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"bl_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"bkg_del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						  {Type:"Text",      Hidden:1, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"act_file_skd_dir_cd" } ];
				   InitColumns(cols);
				   SetEditable(1);
//			       SetColProperty("edi_snd_dt", {Format:"####-##-####"} );
				   SetColProperty("edi_snd_dt", {Format:"YmdHm"} );
				   SetCountFormat("[SELECTDATAROW / TOTALROWS]");
				   SetSheetHeight(300);
		   }
		break;
		case "sheet3":      //sheet3 init
			with(sheetObj){
				 var HeadTitle="RESULT";
				 var headCount=ComCountHeadTitle(HeadTitle);
				 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				 var headers = [ { Text:HeadTitle, Align:"Center"} ];
				 InitHeaders(headers, info);
				 var cols = [ {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"key",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 InitColumns(cols);
				 SetEditable(1);
				 SetSheetHeight(100);
			}
		break;

		case "sheet1":      //sheet1 init
			  with(sheetObj){
				 var HeadTitle2="||Error|CNTR_NO|BKG_NO|BL_NO|POL|POD";
				 var headCount2=ComCountHeadTitle(HeadTitle2);
				 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				 var headers = [ { Text:HeadTitle2, Align:"Center"} ];
				 InitHeaders(headers, info);
				 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
					 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"err_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 InitColumns(cols);
				 SetEditable(1);
				 SetSheetHeight(100);
			  }
		break;
		}
	}
	var allChkFlg=false;
	var allChk=0;
	/**
	 * handling of Sheet
	 * @param sheetObj Sheet
	 * @param formObj form Object
	 * @param sAction code
	 * @param tabno tab number
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
			case IBSEARCH: //search
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				ComOpenWait(true, true);
				sheetObj.RenderSheet(0);
				formObj.f_cmd.value=SEARCH;
				var vvd=formObj.vvd.value.trim();
				formObj.vsl_cd.value=vvd.substring(0, 4);
				formObj.skd_voy_no.value=vvd.substring(4, 8);
				formObj.skd_dir_cd.value=vvd.substring(8, 9);
				formObj.sheet_id.value=sheetObjects[0].id; // sheet0
				var sXml=sheetObj.GetSearchData("ESM_BKG_0210GS.do", FormQueryString(formObj));
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.RenderSheet(1);
				if (State == "S") {
					if (formObj.customs.value.substring(0, 6) == 'Origin') {
						sheetObj.ColumnSort("vps_etd_dt", "ASC");
					} else {
						sheetObj.ColumnSort("vps_eta_dt", "ASC");
					}
				}else{
					sheetObj.RemoveAll();
				}
				sheetObjects[1].CheckAll("Chk",0,1);
				sheetObjects[1].RemoveAll();
				formObj.mbl_tot.value="";
				formObj.hbl_tot.value="";
				formObj.bl_ttl.value="";
				formObj.total.value="0";
				if (formObj.pol_cd.value != "" && formObj.pod_cd.value != "") {
					if (sheetObj.RowCount()> 0) {
						sheet0_OnDblClick(sheetObj, 1, 1);
					}
					else{
						ComOpenWait(false);
					}
				}
				else{
					ComOpenWait(false);
				}
				break;

			case IBSEARCHAPPEND: // searching grid
				if (formObj.pol_cd.value == "" || formObj.pod_cd.value == "") {
					ComOpenWait(true);
				}
				formObj.f_cmd.value=SEARCH;
				sheetObj.CheckAll("Chk",0,1);
				formObj.selected.value="";
				formObj.sheet_id.value=sheetObjects[1].id;  // sheet2
				formObj.mbl_tot.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tot_mbl");
				formObj.hbl_tot.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tot_hbl");
				formObj.bl_ttl.value=parseInt(formObj.mbl_tot.value) + parseInt(formObj.hbl_tot.value);
				if(formObj.bl_ttl.value != "NaN") {
					formObj.total.value=formObj.bl_ttl.value;
				} else {
					formObj.total.value="0";
				}
				var vClptSeq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "clpt_seq");
				var sXml=sheetObjects[1].GetSearchData("ESM_BKG_0210GS.do?pol_cd=" + vPol + "&pod_cd=" + vPod + "&clpt_seq="+ vClptSeq, FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				sheetObjects[1].LoadSearchData(arrXml[0],{Sync:0} );
				sheetObjects[1].ColumnSort("bl_nos", "ASC");
				allChkFlg=false;
				allChk=0;
				ComOpenWait(false);
				sheetObjects[3].LoadSearchData(arrXml[1],{Sync:0} );
				break;

			case IBSAVE: // Data Download
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				ComOpenWait(true);
				var sParam;
				if (sheetObjects[0].CheckedRows(1) > 0) {
					formObj.f_cmd.value=MULTI;
					sParam=ComGetSaveString(sheetObjects[0]) + "&" + FormQueryString(formObj);
				} else if (sheetObjects[1].CheckedRows(1) > 0) {
					formObj.f_cmd.value=ADD;
					if(formObj.pol_cd.value == ""){
						formObj.v_pol.value=vPol;
					}
					if(formObj.pod_cd.value == ""){
						formObj.v_pod.value=vPod;
					}
					if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
						for(var i=2; i<sheetObjects[1].RowCount()+2; i++) {
							if (sheetObjects[1].GetCellValue(i, "Chk") == 1) {
								sheetObjects[1].SetCellValue(i, "act_file_skd_dir_cd",formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value,0);
							}
						}
					}
					sParam=ComGetSaveString(sheetObjects[1]) + "&" + FormQueryString(formObj);
				}
				var sXml=sheetObj.GetSaveData("ESM_BKG_0210GS.do", sParam);
				if (ComBkgErrMessage(sheetObjects[0], sXml)) {
					var key=ComGetEtcData(sXml, "KEY");
					intervalId=setInterval("doActionValidationResult('" + key + "');", 3000);
				} else {
					ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL: // EXCEL DOWNLOAD
				if (sheetObjects[0].RowCount()== 0) {
					ComShowCodeMessage("BKG00109");
					return;
				} else {
					sheetObjects[0].Down2Excel({FileName : 'DL SUMMARY', DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
				}

				break;

			case SEARCH01: //transmitting EDI
				var sheet=sheetObjects[0];
				var param="";
				if(!formObj.chkAllPol.checked){
					// checking Container if B/L is checked
					checkCntrNo(sheetObjects[3]);
				}

				if (formObj.chkAllPol.checked) {
					sheetObjects[3].CheckAll("del_chk", 1, 1);
				}

				if (sheetObjects[1].CheckedRows("Chk") == 0 || sheetObjects[3].CheckedRows("del_chk") == 0) {
					if(!formObj.chkAllPol.checked){
						ComShowCodeMessage('BKG00249', ''); // No Seleted Row.
						return false;
					}
					else{
						param="&allPol=Y";
					}
				}
				param=param + "&inListType=D&inVvdCd=" + formObj.vvd.value +  "&inPodCd=" + sheet.GetCellValue(sheet.GetSelectRow(), "pod_cd") + "&inBkgCgoTpCd=" + formObj.bkg_cgo_tp_cd.value;
				ComOpenWindowCenter("ESM_BKG_0723.do?pgmNo=ESM_BKG_0723"+param, "edi", 500, 450, true);
				break;

			case SEARCH03:
				formObj.f_cmd.value=SEARCH;
				formObj.sheet_id.value=sheetObjects[3].id; // sheet1
				ComOpenWait(true, true);
				if(formObj.chkAllPol.checked){
					sheetObj.DoSearch("ESM_BKG_0210GS.do?clpt_seq=vClptSeq", FormQueryString(formObj) + "&all_pol=Y" );
				}
				ComOpenWait(false);
				break;
			case MULTI05: // 데이터 삭제
				if (!validateForm(sheetObj, formObj, sAction)) {
					return;
				}
				if (sheetObjects[1].CheckedRows(1) < 1){
					ComShowCodeConfirm("COM12113","check box.") //  'Please select {?msg1}';
					return false;
				}else{
					if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
					formObj.f_cmd.value=MULTI05;
					if(formObj.pol_cd.value == ""){
						formObj.v_pol.value=vPol;
					}
					if(formObj.pod_cd.value == ""){
						formObj.v_pod.value=vPod;
					}
					if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
						for(var i=2; i<sheetObjects[1].RowCount()+2; i++) {
							if (sheetObjects[1].GetCellValue(i, "Chk") == 1) {
								sheetObjects[1].SetCellValue(i, "act_file_skd_dir_cd",formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value,0);
							}
						}
					}
					sParam=ComGetSaveString(sheetObjects[1]) + "&" + FormQueryString(formObj);
				}
				var sXml=sheetObj.GetSearchData("ESM_BKG_0210GS.do", sParam);
				sheetObj.LoadSearchData(sXml , {Sync:1} );
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			}
	}
	/**
	 * checking Logic which success to save (because it is BackEndJob)
	 * @param sKey BackEndJob Key
	 */
	function doActionValidationResult(sKey) {
		var sXml = sheetObjects[2].GetSearchData("ESM_BKG_0210GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
		var sJbStsFlg= ComGetEtcData(sXml, "jb_sts_flg");
		if (!ComBkgErrMessage(sheetObjects[2], sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			//  showing success message
			ComShowMessage(ComResultMessage(sXml));
			// sheet2 retrieve
			sheetObjects[1].RemoveAll();
			document.form.selected.value="0";
			if (document.form.f_cmd.value == MULTI) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", 1);
			} else {
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCHAPPEND, "", 1);
			}
			return;
		} else if (sJbStsFlg == "FAIL") {
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowCodeMessage('BKG95019');  // Failed to download. Please try again.
		}
	}
	/**
	 * handling process for input validation
	 * @param sheetObj Sheet
	 * @param formObj form object
	 * @param sAction code
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH: // search
				if (!ComChkRequired(formObj))
					return false;
				return true;
				break;

			case IBSAVE:
				if (sheetObjects[1].CheckedRows(1) == 0) {
					ComShowCodeMessage('BKG00333'); // Nothing To Select
					return false;
				}
				if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
					if (sheetObjects[1].GetCellValue(2, "pol_cd").substring(0,2) == 'CA') {
						var vActFlg=true;
						var vActDirCd="";
						for ( var i=2; i < sheetObjects[1].RowCount()+ 2; i++) {
							if (sheetObjects[1].GetCellValue(i, "act_file_skd_dir_cd") != "") {
								vActDirCd=sheetObjects[1].GetCellValue(i, "act_file_skd_dir_cd");
								break;
							}
						}
						if (vActDirCd != "" && vActDirCd != formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value) {
							if (ComShowCodeConfirm('BKG04022', formObj.act_file_skd_dir_cd[formObj.act_file_skd_dir_cd.selectedIndex].value)) {
								sheetObjects[1].CheckAll("Chk",1);
								return true;
							} else {
								return false;
							}
						}
					}
				}
				if (!ComShowCodeConfirm("BKG00350")) {
					return false;
				}
				break;
			}
		return true;
	}
	/**
	 *  handling after searching
	 * @param sheetObj Sheet
	 * @param ErrMsg error message
	 */
	function sheet0_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (document.form.customs.value.substring(0, 6) == 'Origin') {
				sheetObj.ColumnSort("vps_etd_dt", "ASC");
			} else {
				sheetObj.ColumnSort("vps_eta_dt", "ASC");
			}
		}
		document.form.selected.value="";
		if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
			document.form.act_file_skd_dir_cd[0].selected=true;
		}
		if (sheetObj.RowCount()> 0) {
			sheetObj.SetSumText("Seq","TOTAL");
			sheetObj.SetCellAlign(sheetObj.LastRow(), "bdr_dt","Center");
		}
		SetButtonStatus();
	}
	/**
	 * searching detail
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	function sheet0_OnDblClick(sheetObj, Row, Col) {
		sheetObjects[1].RemoveAll();
		vPod=sheetObj.GetCellValue(Row, "pod_cd");
		vPol=sheetObj.GetCellValue(Row, "pol_cd");
		if(document.form.chkAllPol != undefined && document.form.chkAllPol.checked){
			document.form.chkAllPol.checked=false;
		}
		if (document.form.customs.value == 'Origin US' || document.form.customs.value == 'US') {
			if (vPol.substring(0,2) == 'CA')
			{
				if (document.form.vvd.value.substring(8) == "E")
				{
					document.form.act_file_skd_dir_cd[2].selected=true;
				}
				else
				{
					document.form.act_file_skd_dir_cd[1].selected=true;
				}
			}
		}
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCHAPPEND, FormQueryString(document.form), 1);
	}
	/**
	 * Booking Creation
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	function sheet2_OnDblClick(sheetObj, Row, Col) {
		if (sheetObj.ColSaveName(Col) != "bl_nos") return;
		//ComBkgCall0079(sheetObj.GetCellValue(Row, "bkg_no"));

		comBkgCallPopBkgDetail(sheetObj.GetCellValue(Row, "bkg_no"));
	}

	var vDisableChkCnt=0;
	/**
	 * sheet2(searching detail)  in case of BDR or error after searching, handling of check box
	 * @param sheetObj Sheet
	 * @param ErrMsg error message
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		vDisableChkCnt=0;
		//after BDR, in case of Origin menu,  check box Disabled -- 고객 요청으로 삭제
		var sheet0=sheetObjects[0];
		if (document.form.customs.value.substring(0, 6) == 'Origin') {
//			var findIdx=sheet0.findText("pod_cd", vPod);
			var findIdx=ComFindText(sheet0, "pod_cd", vPod);
		}
		for (i=2; i < sheetObj.RowCount()+ 2; i++) {
			// 2016.05.20 Jenny Acpal, Pushkar, Rachel 의 요청으로 삭제 (BP #12262)
//			if(sheet0.GetCellText(findIdx, "bdr_flg") == 'Y'){
//				sheetObj.SetCellValue(i, "Chk",'0',0);
//				sheetObj.SetCellEditable(i, "Chk",0);
//				vDisableChkCnt++;
//			}
			//in case of error, check box Disabled
			if (sheetObj.GetCellValue(i, "err_cd") != "") {
				sheetObj.SetToolTipText(i, "err_cd",error_desc(sheetObj.GetCellValue(i, "err_cd")));
				sheetObj.SetCellValue(i, "Chk",'0',0);
				sheetObj.SetCellEditable(i,"Chk",0);
				vDisableChkCnt++;
			}
			switch (sheetObj.GetCellText(i, "filer")) {
			case '1':
				sheetObj.SetToolTipText(i, "filer",'CARRIER’S FILING NVOCC');
				break;
			case '2':
				sheetObj.SetToolTipText(i, "filer",'SELF-FILING NVOCEE');
				break;
			case '3':
				sheetObj.SetToolTipText(i, "filer",'NOT APPLICABLE');
				break;
			}
		}
		//in case of HB/L, blue font
		var blueColor="#0000FF";
		for (i=2; i < sheetObj.RowCount()+ 2; i++) {
			if (sheetObj.GetCellText(i, "cntr_mf_no") != '')
				sheetObj.SetCellFontColor(i, "bl_nos",blueColor);
		}
		//red font
		var redColor="#FF0000";
		for (i=2; i < sheetObj.RowCount()+ 2; i++) {
			for (j=16; j < 28; j++) {
				//Customer = N
				if (sheetObj.GetCellText(i, j) == 'N') {
					sheetObj.SetCellFontColor(i, j,redColor);
				}
			}
			sheetObj.SetCellFontColor(i, "err_cd",redColor);
			sheetObj.SetCellFontUnderline(i, "err_cd",1);
			sheetObj.SetCellFontUnderline(i, "bl_nos",1);
		}
	}
	/**
	 * showing Mouse tool tip
	 * @param sheetObj sheet Object
	 * @param Button direction of mouse
	 * @param Shift Shift - 1, Ctrl -  2, ETC. 0
	 * @param X X coordinate
	 * @param Y Y coordinate
	 */
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		// getting value , Mouse Row,  Mouse column
		Row=sheetObj.MouseRow();
		Col=sheetObj.MouseCol();
		sText=sheetObj.GetCellText(Row, Col);
		// MouseToolTip
		// MouseToolTipText = sText;
		if (sheetObj.ColSaveName(Col) == "err_cd" && sText != "") {
			sheetObj.SetMousePointer("Hand");
		} else if (sheetObj.ColSaveName(Col) == "bl_nos") {
			sheetObj.SetMousePointer("Hand");
		} else {
			sheetObj.SetMousePointer("Default");
		}
	}
	/**
	 * sheet2 setting check flag, in case of checking all box setting check flag, in case of checking all box
	 * @param sheetObj  sheet Object
	 * @param Button direction of mouse
	 * @param Shift Shift - 1, Ctrl -  2, ETC. 0
	 * @param X X coordinate
	 * @param Y Y coordinate
	 */
	function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		if ((sheetObj.MouseRow()== 0 || sheetObj.MouseRow()== 1) && sheetObj.MouseCol()== 1) {
			allChkFlg=true;
			if(allChk == 0) {
				allChk=1;
			}else{
				allChk=0;
			}
		}
		else {
			allChkFlg=false;
			if (Shift != 1) {
				vStartRow=sheetObj.MouseRow();
			}
		}
	}
	/**
	 * sheet2 setting the number of check in case of checking all box
	 * @param sheetObj sheet Object
	 * @param Button  direction of mouse
	 * @param Shift Shift - 1, Ctrl -  2, ETC. 0
	 * @param X X coordinate
	 * @param Y Y coordinate
	 */
	function sheet2_OnMouseUp(sheetObj, Button, Shift, X, Y) {
		var formObj=document.form;
		if (allChkFlg)
		{
			if (sheetObj.CheckedRows("Chk") > 0){
				formObj.selected.value=parseInt(formObj.bl_ttl.value) - vDisableChkCnt;
			}
			else {
				formObj.selected.value="0";
			}
		}

		if (Shift == 1) {
			for ( var i=vStartRow; i <= sheetObj.GetSelectRow(); i++) {
				if (sheetObj.GetCellEditable(i, "Chk")) {
					sheetObj.SetCellValue(i, "Chk","1",0);
				}
			}
		}
	}
	/**
	 * sheet2 setting the number of BL which is checked at B/L Count
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 * @param Value changing
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		if (!allChkFlg) {
			formObj.selected.value=sheetObj.CheckedRows("Chk");
		}

		if (formObj.selected.value != formObj.bl_ttl.value) {
			formObj.selected.style.color="red";
			formObj.selected.style.fontWeight="bold";
		} else {
			formObj.selected.style.color="black";
			formObj.selected.style.fontWeight="normal";
		}
	}

	function sheet2_OnCheckAllEnd(sheetObj){
		var formObj=document.form;
		formObj.selected.value=sheetObj.CheckedRows("Chk");

		if (formObj.selected.value != formObj.bl_ttl.value) {
			formObj.selected.style.color="red";
			formObj.selected.style.fontWeight="bold";
		} else {
			formObj.selected.style.color="black";
			formObj.selected.style.fontWeight="normal";
		}
	}
	/**
	 * in case of transmitting Terminal EDI, checking  CntrNo
	 * @param sheetObj sheet Object
	 */
	function checkCntrNo(sheetObj){
		var formObj=document.form;
		var idx;
		var bkgNo;
		sheetObject1= sheetObjects[0];
		sheetObj.CheckAll("del_chk",0,1);
		for ( var h=2; h<=sheetObjects[1].RowCount()+2; h++ ){
			if(sheetObjects[1].GetCellValue(h, "Chk") == 0) continue;
			bkgNo=sheetObjects[1].GetCellValue(h, "bkg_no");
			idx=sheetObj.FindText("bkg_no", bkgNo);
			for ( var i=idx; i<= sheetObj.RowCount(); i++ ){
				if(sheetObj.GetCellValue(i, "bkg_no") != bkgNo) break;
				sheetObj.SetCellValue(i, "del_chk",sheetObjects[1].GetCellValue(h, "Chk"),0);
			}
		}
	}
	/**
	 * error code
	 * @param error_type error type
	 */
	function error_desc(error_type) {
		var error_desc;
		switch (error_type) {
		case "B":
			error_desc="B/L No.is not Assigned";
			break;
		case "S":
			error_desc="BKG Status is not Firmed";
			break;
		case "H":
			error_desc="H.B/L & AMS File No.is missing for Filer Type '01'";
			break;
		case "C":
			error_desc="Container No.or Seal No. is missing";
			break;
		case "P":
			error_desc="Piece count un-match (M.B/L & H.B/L TTL vs. C/M Sum ) or C/M is missing";
			break;
		case "F":
			error_desc="Filer Type is missing";
			break;
		case "A":
			error_desc="Consignee(or Notify in case of “To Order”) information is missing";
			break;
		}
		return error_desc;
	}

	/**
	 * in case of transmitting the Terminal EDI , checking All Pol , in case of unchecked, searching Container
	 */
	function obj_Click() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if (srcName == "chkAllPol") {
			if(sheetObjects[0].GetTotalRows()== 0) {
				formObject.chkAllPol.checked=false;
				ComShowCodeMessage('BKG00882'); // Please retrieve data first.
				return;
			}
			if(sheetObjects[1].GetTotalRows()> 0) {
				sheetObjects[1].CheckAll("Chk",0,1);
			}
			if (formObject.chkAllPol.checked)
				doActionIBSheet(sheetObjects[3], formObject, SEARCH03);
		}
	}

	function sheet2_OnSort(Col, SortArrow){
		sheet2.ReNumberSeq();
	}

	function sheet0_OnDownFinish(downloadType, result) {

		if (sheetObjects[1].RowCount()> 0) {
			sheetObjects[1].SetDown2ExcelUrl("/opuscntr/js/ibsheet/jsp/Down2Excel2.jsp");
			sheetObjects[1].Down2Excel({FileName : 'DL BL LIST', DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
		} else {
			 ComShowCodeMessage("COM132501");
		}



	}
