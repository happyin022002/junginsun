/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0123.js
*@FileTitle  : Wharfage Cargo Classification - Add Booking Data
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================**/

/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/

	/* Start of developer's work*/

	// global variable
	var tabObjects=new Array();
	var tabCnt=0;

	var beforetab=1;

	var sheetObjects=new Array();
	var sheetCnt=0;

	var vvd;
	var portCd;
	var whfBndCd;
	var whfRate;
	var CustArry=new Array();
	var isUpdInt='U';

	// Event handler processing by button click event */
	document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		/** *** using extra sheet valuable if there are more 2 sheets **** */
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
				break;
			case "btn_add1":
				sheetObject1.DataInsert(-1);
				break;
			case "btn_del1":
				doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
				break;
			case "btn_add2":
				sheetObjects[1].DataInsert(-1);
				break;
			case "btn_del2":
				doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
				break;
			case "btn_close":
				ComClosePopup();
				break;
			case "btn_new1":
				sheetObjects[0].RemoveAll();
				sheetObjects[0].DataInsert(-1);
				break;
			case "btn_new2":
				sheetObjects[1].RemoveAll();
				sheetObjects[1].DataInsert(-1);
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
	 *  adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
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
		// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();

		// if( '' != document.form.bl_no.value )
		// isUpdInt = 'I';
	}


	/**
	 * Dynamic loading the event of  HTML Control in the page <br>
	 * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
	 *
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects
	 */
	function initControl() {
		var formObject=document.form;
		// Axon
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		ComSetObjValue(formObject.frm_whf_bnd_cd, formObject.whf_bnd_cd.value);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 *  adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": // sheet1 init
			with(sheetObj){
				  //if (location.hostname != "")
				  //no support[check again]CLT 					InitHostInfo(location.hostname, location.port, page_path);
				  var HeadTitle1="|Sel.|Seq.|Container No.|TP|Seal No.|F/M";
				  var prefix='sheet1_';

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"SEQ",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
						 {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_seal_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];

				  InitColumns(cols);
				  SetEditable(1);
				  SetSheetHeight(160);
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "cntr_no", vtEngUpOther, "0123456789");
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "cntr_tpsz_cd", vtEngUpOther,	"0123456789");
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "cntr_seal_no", vtEngUpOther, "0123456789");
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "fm", vtEngUpOther, "");
			}
			break;
		case "sheet2": // sheet2 init
			with(sheetObj){
				  //if (location.hostname != "")
				  //no support[check again]CLT 					InitHostInfo(location.hostname, location.port, page_path);
				  var HeadTitle1="|Sel.|TP|Customer Name|Customer Address";
				  var prefix='sheet2_';

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
						 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_cust_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
						 {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
						 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 } ];

				  InitColumns(cols);

				  SetEditable(1);
						//conversion of function[check again]CLT 				InitDataValid(0, prefix + "bkg_cust_tp_cd", vtEngUpOther, "");
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "cust_nm", vtEngUpOther, "0123456789");
				  //conversion of function[check again]CLT 				InitDataValid(0, prefix + "cust_addr", vtEngUpOther, "0123456789");
				  SetAutoRowHeight(0);
				  SetSheetHeight(160);
			}
			break;
		case "sheet3": // sheet2 init
			with(sheetObj){
				  //if (location.hostname != "")
				  //no support[check again]CLT 					InitHostInfo(location.hostname, location.port, page_path);
				  var HeadTitle1="|bl_no|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|bkg_sts_cd|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|revenue|amount|whf_bnd_cd|port_cd";
				  var prefix='sheet3_';

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",        Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",       Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",  Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",      Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",    Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"act_wgt",      Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",    Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",     Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"revenue",      Format:"",      Edit:1 },
						 {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"amount",       Format:"Float", Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"whf_bnd_cd",   Format:"",      Edit:1 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",      Format:"",      Edit:1 } ];

				  InitColumns(cols);
				  SetEditable(1);
//			      SetSheetHeight(200);
				  resizeSheet();
			}
			break;
		}
	}
	// handling of Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: // search
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.frm_pol_cd.value='';
				formObj.frm_pod_cd.value='';
				formObj.frm_por_cd.value='';
				formObj.frm_del_cd.value='';
				formObj.frm_bkg_sts_cd.value='';
				formObj.frm_rcv_term_cd.value='';
				formObj.frm_de_term_cd.value='';
				formObj.frm_pck_qty.value='';
				formObj.frm_pck_tp_cd.value='';
				formObj.frm_act_wgt.value='';
				formObj.frm_wgt_ut_cd.value='';
				formObj.frm_meas_qty.value='';
				formObj.frm_meas_ut_cd.value='';
				formObj.frm_revenue.value='';
				formObj.frm_amount.value='';
				formObj.f_cmd.value=SEARCH;
				var aryPrefix=new Array("sheet1_", "sheet2_", ""); // prefix
				// String list
				var sXml=sheetObj.GetSearchData("ESM_BKG_0123GS.do",
						FormQueryString(formObj) + "&"
								+ ComGetPrefixParam(aryPrefix));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 2) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
				}
				if (sheetObjects[2].RowCount()> 0) {
					IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
					$("[name='frm_pck_qty']").val(CommaInputWithPoint(
							$("[name='frm_pck_qty']").val(), 3));
					$("[name='frm_act_wgt']").val(ComAddComma3(
							CommaInputWithPoint(
									$("[name='frm_act_wgt']").val(), 3),
							"#,###.000"));
					$("[name='frm_meas_qty']").val(ComAddComma3(
							CommaInputWithPoint(
									$("[name='frm_meas_qty']").val(), 3),
							"#,###.000"));
					$("[name='frm_revenue']").val(ComAddComma3(
							$("[name='frm_revenue']").val(), "#,###.000"));
					$("[name='frm_amount']").val(CommaInputWithPoint(
							$("[name='frm_amount']").val(), 3));
	/*				document.getElementById("vvd").value=document
							.getElementById("vsl_cd").value.
							+ document.getElementById("skd_voy_no").value
							+ document.getElementById("skd_dir_cd").value;*/
	/*				document.getElementById("frm_port_cd").value=document
							.getElementById("frm_pol_cd").value;
					document.getElementById("frm_bkg_no").value=document
							.getElementById("frm_bkg_no").value;
					document.getElementById("frm_bl_no").value=document
							.getElementById("frm_bl_no").value;*/
				}
				/*
				 * to check duplication of data
				 */
				for ( var i=1; i < sheetObjects[1].RowCount()+ 1; i++) {
					CustArry[i - 1]=sheetObjects[1].GetCellValue(i, 2);
				}
				/*
				 * to save all data, when BL is added, set IBFLAG to 'U'
				 */
				for ( var m=0; m < sheetObjects[0].RowCount(); m++) {
					sheetObjects[0].SetCellValue(m + 1, 0,'U',0);
				}
				for ( var j=0; j < sheetObjects[1].RowCount(); j++) {
					sheetObjects[1].SetCellValue(j + 1, 0,'U',0);
				}
			}
			break;
		case IBSAVE: // save
			if (validateForm(sheetObj, formObj, sAction)) {
				IBS_CopyFormToRow(formObj, sheetObjects[2], 1, "frm_");
				sheetObjects[2].SetCellValue(1, "vsl_cd",formObj.vvd.value.substring(0, 4),0);
				sheetObjects[2].SetCellValue(1, "skd_voy_no",formObj.vvd.value.substring(4, 8),0);
				sheetObjects[2].SetCellValue(1, "skd_dir_cd",formObj.vvd.value.substring(8, 9),0);
				sheetObjects[2].SetCellValue(1, "port_cd",formObj.port_cd.value,0);
				sheetObjects[2].SetCellValue(1, 'amount',sheetObjects[2].GetCellValue(1, 'amount').split(",").join(""));
				formObj.f_cmd.value=MULTI;
				var sParam1=sheetObjects[0].GetSaveString();
				var sParam2=sheetObjects[1].GetSaveString();
				var sParam3=sheetObjects[2].GetSaveString();
				var aryPrefix=new Array("sheet1_", "sheet2_", ""); // prefix
				// String list
				var sParam=ComGetSaveString(sheetObjects);
				sParam=sParam + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
				//alert(sParam);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0123GS.do", sParam);
				//after finishing the handling of transaction target data from XML String parameter,  OnSaveEnd Event is called
				sheetObjects[0].LoadSaveData(sXml);
				sXml=ComDeleteMsg(sXml); // to display the message once, using this
				sheetObjects[1].LoadSaveData(sXml);
				sheetObjects[2].LoadSaveData(sXml);
				opener.addRowSheet1(sheetObjects[2].GetCellValue(1, "bl_no"),
						sheetObjects[2].GetCellValue(1, "bkg_no"), sheetObjects[2].GetCellValue(1, "vsl_cd")
						+ sheetObjects[2].GetCellValue(1, "skd_voy_no")
						+ sheetObjects[2].GetCellValue(1, "skd_dir_cd"),
						sheetObjects[2].GetCellValue(1, "pol_cd"), sheetObjects[2].GetCellValue(1, "pod_cd"), formObj.whf_bnd_cd.value);
				ComClosePopup();
			}
			break;
		case IBDELETE: // delete
			var checked=0;
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, 1) == '1') {
					checked=1;
					if (sheetObj.GetCellValue(i, 0) != "I") {
						sheetObj.SetRowHidden(i,1);
						sheetObj.SetRowStatus(i,"D");
					} else {
						if (sheetObj.GetCellValue(i, 1) == '1') {
							sheetObj.SetRowStatus(i,"D");
							i--;
						}
					}
				}
			}
			if (checked == 0)
				ComShowCodeMessage('BKG00249');
			break;

		case IBDOWNEXCEL:
			if (sheetObj.RowCount()> 0){
				sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
			}else{
				ComShowCodeMessage('BKG00389');
			}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
		/*
		 * if ('y' == formObj.popup.value && (formObj.bl_no.value == "" ||
		 * formObj.bkg_no.value == "")) { formObj.popup.value = ''; return false; }
		 */
			if (formObj.frm_bl_no.value == "" && formObj.frm_bkg_no.value == "") {
				if (formObj.frm_bl_no.value == "") {
					ComShowCodeMessage("BKG00887", "B/L No");
					return false;
				}
				if (formObj.frm_bkg_no.value == "") {
					ComShowCodeMessage("BKG00887", "BKG No");
					return false;
				}
			}
			return true;
			break;
		case IBSAVE: // save
			if (formObj.frm_bl_no.value == "" || formObj.frm_bkg_no.value == "") {
				ComShowCodeMessage('BKG00104');
				return false;
			}
			if ((!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified())) {
				ComShowCodeMessage('BKG00743');
				return false;
			}
			/*
			 * check mandatory input
			 */
			if (sheetObjects[0].IsDataModified()== false) {
				var chk1=0;
				for ( var i=0; i < sheetObjects[0].RowCount(); i++) {
					if (sheetObjects[0].GetCellValue(i + 1, 0) == 'U' || sheetObjects[0].GetCellValue(i + 1, 0) == 'I') {
						if (sheetObjects[0].GetCellValue(i + 1, 3) == '') {
							ComShowCodeMessage('BKG00715', 'Container No');
							return false;
						}
						chk1=1;
					}
				}
				if (chk1 == 0) {
					ComShowCodeMessage('BKG00358');
					return false;
				}
				/*
				 * checking data duplication
				 */
				var CntrArry=new Array();
				var CntrArry2=new Array();
				var cntrCnt=0;
				for ( var i=0; i < sheetObjects[0].RowCount(); i++) {
					if ('I' == sheetObjects[0].GetCellValue(i + 1, 0) || 'U' == sheetObjects[0].GetCellValue(i + 1, 0)) {
						CntrArry[cntrCnt]=sheetObjects[0].GetCellValue(i + 1, 3);
						CntrArry2[cntrCnt]=sheetObjects[0].GetCellValue(i + 1, 3);
						cntrCnt++;
					}
				}
				for ( var j=0; j < CntrArry.length; j++) {
					var duCnt=0;
					for ( var h=0; h < CntrArry2.length; h++) {
						if (CntrArry[j] == CntrArry2[h]) {
							duCnt++;
						}
					}
					// alert(duCnt);
					if (duCnt >= 2) {
						ComShowCodeMessage('BKG00764', 'Container No');
						return false;
					}
				}
			}
			/*
			 * checking mandatory data
			 */
			if (sheetObjects[1].IsDataModified()) {
				var chk2=0;
				for ( var i=0; i < sheetObjects[1].RowCount(); i++) {
					if (sheetObjects[1].GetCellValue(i + 1, 0) == 'U' || sheetObjects[1].GetCellValue(i + 1, 0) == 'I') {
						if (sheetObjects[1].GetCellValue(i + 1, 2) == '') {
							ComShowCodeMessage('BKG00715', 'TP');
							return false;
						}
						chk2=1;
					}
				}
				if (chk2 == 0) {
					ComShowCodeMessage('BKG00358');
					return false;
				}
				/*
				 * checking data duplication
				 */
				var TempArry=new Array();
				var TempArry2=new Array();
				var tempCnt=0;
				for ( var i=0; i < sheetObjects[1].RowCount(); i++) {
					if ('I' == sheetObjects[1].GetCellValue(i + 1, 0) || 'U' == sheetObjects[1].GetCellValue(i + 1, 0)) {
						TempArry[tempCnt]=sheetObjects[1].GetCellValue(i + 1, 2);
						TempArry2[tempCnt]=sheetObjects[1].GetCellValue(i + 1, 2);
						tempCnt++;
					}
				}
				for ( var j=0; j < TempArry.length; j++) {
					var duCnt=0;
					for ( var h=0; h < TempArry2.length; h++) {
						if (TempArry[j] == TempArry2[h]) {
							duCnt++;
						}
					}
					if (duCnt >= 2) {
						ComShowCodeMessage('BKG00764', 'TP');
						return false;
					}
				}
			}
			// checking the bound code
			if ('' == formObj.frm_whf_bnd_cd.value) {
				ComShowCodeMessage('BKG00715', 'Tran Mode');
				return false;
			}
			return true;
			break;
		case IBDELETE: // save
			if (formObj.port_cd.value == "") {
				ComShowCodeMessage('BKG00266');
				formObj.port_cd.focus();
				return false;
			}
			return true;
			break;
		}
	}
	/**
	 * checking the point number
	 */
	function PointNumberFixed() {
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		document.getElementsByName(srcName).value=CommaInputWithPoint(srcValue, 3);
	}
	/* Start of developer's work*/
	function resizeSheet(){
		ComResizeSheet(sheetObjects[2]);
	}
