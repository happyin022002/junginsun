/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0462.js
 *@FileTitle  :
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//Common global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var state="";

	//Event handler processing by button click event */
	document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		/** **************************************************** */
		var frmObj = document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject2, frmObj, IBSEARCH);
				// doActionIBSheet(sheetObject3, frmObj, IBSEARCH);
				break;
			case "btn_new":
				frmObj.reset();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				sheetObject4.RemoveAll();
				frmObj.in_vvd_cd.disabled = false;
				frmObj.in_vvd_cd.className = "input1";
				frmObj.in_pod_cd.disabled = false;
				frmObj.in_pod_cd.className = "input1";
				frmObj.in_pol_cd.disabled = false;
				frmObj.in_pol_cd.className = "input";
				frmObj.in_bl_type.disabled = false;
				frmObj.in_bl_type.className = "input";
				break;
			case "btn_datadl":
				doActionIBSheet(sheetObject2, frmObj, COMMAND01);
				break;
			case "btn_print":
				doActionIBSheet(sheetObject4, frmObj, COMMAND02);
				break;
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
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();
		document.form.in_vvd_cd.focus();
	}


	/**
	 * registering initial event
	 */
	function initControl() {
		DATE_SEPARATOR="-";
		var formObject=document.form;

		axon_event.addListener('keydown', 'ComKeyEnter', 'form');

		// axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		ComBtnDisable("btn_print");
	}


//	/**
//	 * 조회조건 입력할 때 처리
//	 */
//	function obj_KeyUp() {
//		var formObject=document.form;
//		var srcName=ComGetEvent("name");
//		var srcMaxLength= ComGetEvent("maxlength");
//		var srcValue= ComGetEvent("value");
//		if (ComChkLen(srcValue, srcMaxLength) == "2") {
//			ComSetNextFocus();
//		}
//	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": // sheet1 init
			with(sheetObj){
				var HeadTitle1="|Seq.|POL|ETD|POD|ETA|BDR|BDR Time|Sub B/L Total";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Seq",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:205,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"bdr_time",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_count",   Edit:0 },

							{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"con_vvd",     Edit:0 } ];
				InitColumns(cols);
				SetEditable(0);
				SetCountPosition(0);
				SetSheetHeight(100);

				}
			break;

		case "t1sheet1": // t1sheet1 init
			with(sheetObj){
				var HeadTitle1="|Seq.|Sel.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|M|D|BDR|C/A No.|vvd_pol_cd";
				var HeadTitle2="|Seq.||B/L No.|BKG No.|AMR|I/F|L/T|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|M|D|BDR|C/A No.|vvd_pol_cd";

				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
								{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",          Edit:0 },
							{Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",        Edit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"a_s",          Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"i_f",          Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"l_t",          Edit:0 },
							{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_cd",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",   Edit:0 },
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",      Edit:0,   Format:"NullInteger" },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",    Edit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"act_wgt",      Edit:0,   Format:"NullFloat",   PointCount:3},
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",    Edit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",     Edit:0,   Format:"NullFloat",   PointCount:3},
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm1",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr1",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm2",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr2",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm3",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr3",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mk_desc",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_desc",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bdr_cng_flg",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:1,   SaveName:"corr_no",      Edit:0 },

							{Type:"Text",      Hidden:1,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"vvd_pol_cd" } ];
				InitColumns(cols);
				SetEditable(1);
				SetRangeBackColor(1,1,1,30,"#555555");
				SetCountPosition(0);
				SetSheetHeight(225);
				}
			break;

		case "t2sheet1": // t2sheet1 init
			with(sheetObj){
				var HeadTitle1="|Seq.|B/L No.|Container|Container|Container|Container|Container|cntr_knt";
				var HeadTitle2="|Seq.|B/L No.|No.|SEAL No.|P|R|D|cntr_knt";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
								{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag"       },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq"          },
							{Type:"Text",      Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:"bl_no"        },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no"      },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_seal_no" },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_prt_flg" },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd"  },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd"   },

							{Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_knt"     } ];
				InitColumns(cols);
				SetEditable(0);
				SetCountPosition(0);
				SetRangeBackColor(1,1,1,30,"#555555");
				SetSheetHeight(225);
				}
			break;

		case "sheet2": // t1sheet1 init
			with(sheetObj){
				var HeadTitle1="Seq.|B/L No.|I/F|L/T|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|BDR|C/A No.|M|D|CNTR_NO|SEAL_NO|vvd_pol_cd";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);

				var cols = [{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",         Edit:0 },
							{Type:"Text",      Hidden:0,  Width:23,   Align:"Center",  ColMerge:1,   SaveName:"i_f",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:23,   Align:"Center",  ColMerge:1,   SaveName:"l_t",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_cd",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",    Edit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",       Edit:0,   Format:"NullInteger" },
							{Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",     Edit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"act_wgt",       Edit:0,   Format:"NullFloat",   PointCount:3 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",     Edit:0 },
							{Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",      Edit:0,   Format:"NullFloat",   PointCount:3 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm1",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr1",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm2",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr2",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm3",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:21,   Align:"Center",  ColMerge:1,   SaveName:"cust_addr3",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bdr_cng_flg",   Edit:0 },
							{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"corr_no",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mk_desc",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_desc",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",  Edit:0 },

							{Type:"Text",      Hidden:1,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"vvd_pol_cd" } ];
				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(0);
				SetSheetHeight(225);
				}
			break;
		}
	}


	/**
	 * Sheet process handling
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: // Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0462GS.do",FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				}
				if (arrXml.length > 1) {
					sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				}
				if (arrXml.length > 2) {
					sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
				}
				if (arrXml.length > 3) {
					sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
				}
				state=sheetObjects[0].GetEtcData("TRANS_RESULT_KEY");
				if (state == "S") {
					sheetObj.CheckAll("chk",0);
					var rowCnt=sheetObj.RowCount();
					if (rowCnt == 0) {
						ComBtnDisable("btn_print");
					} else {
						ComBtnEnable("btn_print");
					}
				}
				formObj.totalCount.value=sheetObjects[0].GetEtcData("total_count");
				//var wgtErrBkgNo = sheetObjects[0].EtcData("wgt_err_bkg_no");
				//if ( wgtErrBkgNo.length > 0 )
				//{
				//	ComShowCodeMessage('BKG95001', 'Weight digit is mismach. \n','(Booking No: '+wgtErrBkgNo+' )');
				//}
				// sheetObjects[1].RowMerge(11) = true;
				// alert(sheetObjects[1].RowCount);
				for ( var i=2; i <= sheetObjects[1].RowCount()+ 1; i++) {
					if (sheetObjects[1].GetCellValue(i, "mk_desc") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "mk_desc","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cmdt_desc") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cmdt_desc","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_nm1") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_nm1","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_addr1") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_addr1","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_nm2") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_nm2","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_addr2") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_addr2","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_nm3") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_nm3","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "cust_addr3") == "N") {
						sheetObjects[1].SetCellFont("FontColor", i, "cust_addr3","#FF0000");
					}
					if (sheetObjects[1].GetCellValue(i, "seq") == "") {
						sheetObjects[1].SetCellEditable(i, "chk",0);
					}
				}
				ComOpenWait(false);
			}
			break;

		case COMMAND01: // Data Download
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoSave("ESM_BKG_0462GS.do", {Param:FormQueryString(formObj), Col:-1, Quest:1, UrlEncode:1, Sync:1});
			}
			break;

		case COMMAND02: // RD
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWindowCenter("ESM_BKG_5015.do?pgmNo=ESM_BKG_5015", "5015", 900, 630, false);
			}
			break;
		}
	}


	/**
	 * handling event after searching
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (ComOpenWait(true)) ComOpenWait(false);
		if (Code < 0) return;
		var frmObj =  document.form;
		frmObj.in_vvd_cd.className = "input2";
		frmObj.in_vvd_cd.disabled = true;
		frmObj.in_pod_cd.className = "input2";
		frmObj.in_pod_cd.disabled = true;
		frmObj.in_pol_cd.className = "input2";
		frmObj.in_pol_cd.disabled = true;
		frmObj.in_bl_type.className = "input2";
		frmObj.in_bl_type.disabled = true;

	}


	/**
	 * handling event after saving
	 */
	function t1sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (ComOpenWait(true)) ComOpenWait(false);
		if (Code < 0) return;
		ComShowMessage("Customs Data Created");
		// Retrieve after saving
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}


	/**
	 * Register as array  to IBTab Object
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}


	/**
	 * initializing Tab
	 * setting Tab items
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
				InsertItem( "B/L List", "");
				InsertItem( "CNTR List", "");
			}
			break;
		}
		tabObj.SetSelectedIndex(0);
	}


	/**
	 * handling event after changing on Tab
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		beforetab=nItem;
	}


	/**
	 * check the validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00251');
				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00252');
				formObj.in_pod_cd.focus();
				return false;
			}
			return true;
			break;
		case COMMAND01:
			if (sheetObj.CheckedRows("chk") < 1) {
				ComShowCodeMessage("BKG00249");    // "No Selected Row"
				return false;
			}
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00251');
				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00252');
				formObj.in_pod_cd.focus();
				return false;
			}
			var chkdRowArray=sheetObj.FindCheckedRow("chk").split("|");
			for (var k in chkdRowArray) {
				var sht3RowNum=sheetObjects[2].FindText("bl_no", sheetObj.GetCellValue(chkdRowArray[k], "bl_no"));
				if (sheetObjects[2].GetCellValue(sht3RowNum, "cntr_knt") > 100) {
					ComShowCodeMessage("BKG02220");    // "There is a B/L with more than 101 containers."
					tabObjects[0].SetSelectedIndex(1);
					sheetObjects[2].SelectCell(sht3RowNum, "bl_no");
					return false;
				}
			}
			return true;
			break;
		case COMMAND02:
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00251');
				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
				ComShowCodeMessage('BKG00252');
				formObj.in_pod_cd.focus();
				return false;
			}
			return true;
			break;
		}
	}