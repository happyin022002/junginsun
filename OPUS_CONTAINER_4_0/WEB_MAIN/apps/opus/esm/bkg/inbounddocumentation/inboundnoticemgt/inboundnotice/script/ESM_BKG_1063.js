/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 	 : ESM_BKG_1063.js
*@FileTitle : Pick up down-load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
   /**
	 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
	 * @author
	 */
	/**
	 * @extends
	 * @class ESM_BKG_1063 : ESM_BKG_1063 business script for
	 */

	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var initManual0=false;
	var initManual1=false;
	var jobId="";
	var timeId="";
	var monCnt=0; // Limited to 10 minutes(600sec/3sec=200 times)
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name <br>
	 *
	 * @return
	 */
	function processButtonClick() {
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (tabObjects[0].GetSelectedIndex() == 0) {
			sheetObj=sheetObjects[0];
		} else if (tabObjects[0].GetSelectedIndex() == 1) {
			sheetObj=sheetObjects[1];
		}
		try {
			var srcName=ComGetEvent("name");
			var obj = event.target || event.srcElement;
			if ($(obj).prop("disabled")) return;
			switch(srcName) {
			case "img_dt":
				ComSetObjValue(formObj.sch_tp_cd, "ATA");
				setMandantorySearchType();
				var cal = new ComCalendarFromTo();
				cal.select(formObj.dt_s, formObj.dt_e, 'yyyy-MM-dd');
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObj, formObj, IBRESET);
				break;
			case "btn_Upload":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_DownExcel":
				if (sheetObj.RowCount() < 1) {//no data
					ComShowCodeMessage("COM132501");
				} else{
					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				}
				break;
			case "btn_RtnYD":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC05);
				break;
			case "btn_Batch":
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC06);
				break;
			case "btn_Close":
				ComClosePopup();
				break;
			case "sch_tp_cd":
				setMandantorySearchType();
				break;
			case "vvd":
				ComSetObjValue(formObj.sch_tp_cd, "VVD");
				setMandantorySearchType();
				break;
			case "dt_s":
			case "dt_e":
				ComSetObjValue(formObj.sch_tp_cd, "ATA");
				setMandantorySearchType();
				break;
			case "disp_bl_no":
				ComSetObjValue(formObj.sch_tp_cd, "BL");
				break;
			case "btn_multBlNo":
				if ($("#btn_multBlNo").is(":disabled")) return;
				ComSetObjValue(formObj.sch_tp_cd, "BL");
				var stop = $("#disp_bl_no").offset().top;
				var sleft = $("#disp_bl_no").offset().left;
				layList.style.left = sleft+"px";
				if (document.form.popUp.value == "Y") {
					layList.style.top = (stop+25)+"px";
				} else {
					layList.style.top = stop+"px";
				}
				if (!$("#layList").is(":visible")) {
					$("#layList").show();
				} else {
					$("#layList").hide();
				}
				break;
			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * registering IBSheet Object as list<br>
	 * adding process for list in case of needing batch processing with other items <br>
	 * defining list on the top of source <br>
	 *
	 * @param {IBSheet} sheet_obj mandatory, IBSheet control
	 * @return
	 */
	function setSheetObject(sheet_obj) {
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
		for(var i=0;i<sheetObjects.length;i++) {
			//khlee- Preferences change the name of the function to start
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			//khlee- The final configuration functions added
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();

		if (document.form.popUp.value == "Y") {
			initManual1=false;
			ComSetObjValue(document.form.sch_tp_cd, document.form.p_sch_tp_cd.value);
			setMandantorySearchType();
			document.form.disp_bl_no.value = document.form.p_bl_no.value;
			if (document.form.disp_bl_no.value != "") {
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			}
		}

	jqueryEvent();
	}

	/**
	 * HTML tags will register an event. <br>
	 *
	 * @return
	 */
	function initControl() {
		axon_event.addListener("blur", "obj_deactivate", "dt_s", "dt_e");
//		axon_event.addListener("change", "obj_change", "cre_tp_cd1", "cre_tp_cd2");
	}
	/**
	 *Handle the Blur event.<br>
	 *
	 * @return
	 */
	function obj_deactivate() {
		switch (event.srcElement.name) {
			case "dt_s":
			case "dt_e":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
	/**
	 * setting sheet initial values and header<br>
	 * adding case as numbers of counting sheets <br>
	 *
	 * @param {ibsheet} sheetObj mandatory, IBSheet Object
	 * @param {number}  sheetNo mandatory, IBSheet Object serial number
	 * @return
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "t1sheet1":
				break;
			case "t2sheet1":
			case "t2sheet2":
				with(sheetObj) {

					var HeadTitle1="|Chk|Seq.|Bkg No|B/L No.|Container|TP|AVL DT|FRE DT|Pick up No.|PICK YD|RTN YD|F|O|C|Update DT|Update OFC|Update USER|SN||POD|DEL|TERM|ETA DT||||VSL|DEP DT|ARR DT";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:6, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",     Hidden:1, Width:30,  Align:"Center", SaveName:"ibflag" },
								{Type:"DummyCheck", Hidden:0, Width:30,  Align:"Center", SaveName:"chk",                Format:"",       Edit:1 },
								{Type:"Seq",        Hidden:0, Width:30,  Align:"Center", SaveName:"seq" },
								{Type:"Text",       Hidden:1, Width:60,  Align:"Center", SaveName:"bkg_no",             Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"bl_no",              Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"cntr_prt_flg",       Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"cntr_no",            Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:40,  Align:"Center", SaveName:"cntr_tpsz_cd",       Format:"",       Edit:0 },
								{Type:"Date",       Hidden:0, Width:80,  Align:"Center", SaveName:"pkup_aval_dt",       Format:"Ymd",    Edit:0 },
								{Type:"Date",       Hidden:0, Width:80,  Align:"Center", SaveName:"lst_free_dt",        Format:"Ymd",    Edit:0 },
								{Type:"Text",       Hidden:0, Width:80,  Align:"Center", SaveName:"pkup_no",            Format:"",       Edit:1, EditLen:20 },
								{Type:"Text",       Hidden:0, Width:70,  Align:"Center", SaveName:"pkup_yd_cd",         Format:"",       Edit:1, EditLen:7 },
								{Type:"Text",       Hidden:0, Width:70,  Align:"Center", SaveName:"rtn_yd_cd",          Format:"",       Edit:1, EditLen:7 },
								{Type:"Text",       Hidden:0, Width:20,  Align:"Center", SaveName:"frt_clt_flg",        Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:20,  Align:"Center", SaveName:"obl_rdem_flg",       Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:20,  Align:"Center", SaveName:"cstms_clr_cd",       Format:"",       Edit:0 },
								{Type:"Date",       Hidden:0, Width:140, Align:"Center", SaveName:"pkup_upd_dt",        Format:"YmdHms", Edit:0 },
								{Type:"Text",       Hidden:0, Width:90,  Align:"Center", SaveName:"ofc_cd",             Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"pkup_upd_usr_id",    Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:25,  Align:"Center", SaveName:"pkup_ntc_snd_yn",    Format:"",       Edit:0 },
								{Type:"Text",       Hidden:1, Width:25,  Align:"Center", SaveName:"pkup_ntc_snd_knt",   Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:60,  Align:"Center", SaveName:"pod_cd",             Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:60,  Align:"Center", SaveName:"ibd_trsp_hub_cd",    Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:60,  Align:"Center", SaveName:"del_cd",             Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:50,  Align:"Center", SaveName:"usa_cstms_file_cd",  Format:"",       Edit:0 },
								{Type:"Text",       Hidden:0, Width:60,  Align:"Center", SaveName:"de_term_cd",         Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:230, Align:"Left",   SaveName:"route_guide",        Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:120, Align:"Center", SaveName:"rail_move",          Format:"",       Edit:0 },
//								{Type:"Text",       Hidden:0, Width:120, Align:"Center", SaveName:"truck_move",         Format:"",       Edit:0 },
								{Type:"Date",       Hidden:0, Width:120, Align:"Center", SaveName:"ata_dt",             Format:"YmdHm",  Edit:0 },
								{Type:"Text",       Hidden:1, Width:60,  Align:"Center", SaveName:"vsl_cd" },
								{Type:"Text",       Hidden:1, Width:60,  Align:"Center", SaveName:"skd_voy_no" },
								{Type:"Text",       Hidden:1, Width:60,  Align:"Center", SaveName:"skd_dir_cd" },
								{Type:"Text",       Hidden:0, Width:100, Align:"Center", SaveName:"vvd",                Format:"",       Edit:0 },
								{Type:"Date",       Hidden:1, Width:70,  Align:"Center", SaveName:"rail_dep_dt" },
								{Type:"Date",       Hidden:1, Width:70,  Align:"Center", SaveName:"rail_arr_dt" } ];

			 InitColumns(cols);
			 SetEditable(1);
//             SetColProperty("pkup_aval_dt", {Format:"####-##-##"} );
//             SetColProperty("lst_free_dt", {Format:"####-##-##"} );
//             SetColProperty("pkup_upd_dt", {Format:"####-##-####:##"} );
//             SetColProperty("ata_dt", {Format:"####-##-####:##:##"} );
			 SetColProperty("rail_dep_dt", {Format:"####-##-####:##:##"} );
			 SetColProperty("rail_arr_dt", {Format:"####-##-####:##:##"} );
			 if (sheetID == "t2sheet1")
				SetSheetHeight(440);
			 else SetVisible(false);
			 //conversion of function[check again]CLT                     InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789");
			 //conversion of function[check again]CLT                     InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
			 //conversion of function[check again]CLT                     InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "0123456789");
			 }
			 break;
		}
	}
	/**
	 * Sheet handling process <br>
	 *
	 * @param {ibsheet} sheetObj  mandatory, IBSheet Object
	 * @param {object}  formObj   mandatory, HTML Form Object
	 * @param {string}  sAction   mandatory, Action Name
	 * @param {String}  CondParam mandatory, Server transfers information
	 * @param {int}     PageNo    Select, Page Numbers
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
		// New
		case IBRESET:
			if (sheetObj.IsDataModified()) {
				if (ComShowCodeConfirm("BKG00254") ) {
					doActionIBSheet(sheetObj, formObj, IBSAVE);
					break;
				}
			}
			sheetObj.RemoveAll();
//    		initForm();
			break;

			//Retrieve
		case IBSEARCH:
			if (!validateForm(sheetObj, formObj, sAction)) break;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			formObj.bl_nos.value = (formObj.disp_bl_no.value + $("#mult_bl_no").val());
			sheetObj.DoSearch("ESM_BKG_1063_01GS.do", FormQueryString(formObj)+"&"+"page_no=1", {Append:false} );
			ComOpenWait(false);
			break;
		case IBSEARCHAPPEND:
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_1063_01GS.do", CondParam+"&"+"page_no="+PageNo, {Append:true} );
//            fncSetFilter();
			ComOpenWait(false);
			break;
			// Upload
		case IBSEARCH_ASYNC01:
			ComOpenPopupWithTarget("ESM_BKG_1064_POP.do", 1000, 524, "", "none", false);
			break;

			// RTN YD
		case IBSEARCH_ASYNC05:
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
			var param="&pod_cd=" + sheetObj.GetCellValue(vRow, "pod_cd") +
			"&del_cd=" + sheetObj.GetCellValue(vRow, "del_cd");
			ComOpenPopupWithTarget("ESM_BKG_1058_POP.do?pgmNo=ESM_BKG_1058&mainPage=false"+param, 1024, 670, "", "none", true);
			break;
//		case IBDOWNEXCEL:
//			if (sheetObj.id == "t1sheet1") {
//				ComOpenWait(true);
//				sheetObj.Down2Excel({ HiddenColumn:-1});
//				ComOpenWait(false);
//			} else if (sheetObj.id == "t2sheet1") {
//				if (sheetObj.RowCount()== 0) {
//					ComShowCodeMessage("BKG00395");
//					break;
//				}
//				if (!validateForm(sheetObj, formObj, sAction)) break;
//				ComOpenWait(true);
//				formObj.f_cmd.value=SEARCH01;
//				sheetObjects[2].DoSearch("ESM_BKG_1063_01GS.do", FormQueryString(formObj) + "&excel_flg=Y" );
//			}
//			break;
		case IBSAVE:
			var iCheckRow=sheetObj.CheckedRows("chk");
			if (iCheckRow < 1) {
				ComShowCodeMessage("BKG00149");
				break;
			}
			if (!validateForm(sheetObj, formObj, sAction)) break;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sParam=FormQueryString(formObj);
			var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
			if (sParamSheet == "") {
				ComShowCodeMessage("COM130503");
				ComOpenWait(false);
				break;
			} else {
				sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
			}
			sXml=sheetObj.GetSaveData("ESM_BKG_1063GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
			if (sheetObj.id == "t1sheet1") {
				if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
					for(var i=sheetObj.RowCount(); i>=0; i--) {
						if (sheetObj.GetCellValue(i+1, "chk") == "1") {
							sheetObj.RowDelete(i+1, false);
						}
					}
				}
				ComOpenWait(false);
			} else if (sheetObj.id == "t2sheet1") {
				ComOpenWait(false);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
			// Execute Batch
		case IBSEARCH_ASYNC06:
			ComOpenWait(true);
			// 1. ESM_BKG_B019 Check
			var sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B019";
			var sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml, "BATCH_STATUS");
				if (isRunning == "true") {
					ComShowCodeMessage("BKG43043");
					ComOpenWait(false);
					break;
				}
			} else {
				ComBkgErrMessage(sheetObj, sXml);
				ComOpenWait(false);
				break;
			}
			// 2. ESM_BKG_B012 Check
			sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B012";
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml, "BATCH_STATUS");
				if (isRunning == "true") {
					ComShowCodeMessage("BKG43043");
					ComOpenWait(false);
					break;
				}
			} else {
				ComBkgErrMessage(sheetObj, sXml);
				ComOpenWait(false);
				break;
			}
			// 3. ESM_BKG_B015 Check
			sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B015";
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml, "BATCH_STATUS");
				if (isRunning == "true") {
					ComShowCodeMessage("BKG43043");
					ComOpenWait(false);
					break;
				}
			} else {
				ComBkgErrMessage(sheetObj, sXml);
				ComOpenWait(false);
				break;
			}
			formObj.f_cmd.value=SEARCH03;
			sParam=FormQueryString(formObj);
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				monCnt=1;
				jobId=ComGetEtcData(sXml, "JOB_ID");
				timeId=setTimeout("monitoringBatchJob()", 1000*3);
			} else {
				ComBkgErrMessage(sheetObj, sXml);
				ComOpenWait(false);
			}
			break;
			// Monitor Batch Status
		case IBSEARCH_ASYNC07:
			var sParam="&f_cmd=" + SEARCH04 + "&job_id=" + jobId;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var jobStatus=ComGetEtcData(sXml, "BATCH_STATUS");
				if (jobStatus == "0" || jobStatus == "1" || jobStatus == "3" || jobStatus == "10") { // None. Running or Starting or Restart
					if (monCnt < 200) { // Limited to 10 minutes, monitoring.(3sec*200=10min)
						monCnt++;
						// Continued monitoring
						timeId=setTimeout("monitoringBatchJob()", 1000*3);
					} else {
						ComOpenWait(false);
					}
				} else {
					ComOpenWait(false);
					alert(getBatchStatusDesc(jobStatus));
				}
			} else {
				ComBkgErrMessage(sheetObj, sXml);
				ComOpenWait(false);
			}
			break;
		}
	}
	/**
	 * Register as array  to IBTab Object<br>
	 * adding process for list in case of needing batch processing with other items <br>
	 * defining list on the top of source <br>
	 *
	 * @param {object} tab_obj mandatory, Tab Control
	 * @return
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}


	/**
	 * Event when clicking Tab <br>
	 * activating selected tab items <br>
	 *
	 * @param {object} tabObj mandatory, Tab Control
	 * @param {int}    nItem  mandatory, Tab The serial number objects
	 * @return
	 */
//    function tab1_OnChange(tabObj, nItem)
//    {
//        var objs=document.all.item("tabLayer");
//        objs[nItem].style.display="Inline";
//        objs[beforetab].style.display="none";
//        //--------------- Importance --------------------------//
//        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//        //------------------------------------------------------//
//        beforetab=nItem;
//        if (nItem == 0) {
//        	ComBtnEnable("btn_Upload");
//        	ComBtnDisable("btn_Retrieve");
//        	if (!initManual0) {
//           	    initForm();
//           	    initManual0=true;
//        	}
//        	document.getElementById("div_cre_tp1").style.display="Inline";//div_cre_tp1.style.display="";
//        	document.getElementById("div_cre_tp2").style.display="none";//div_cre_tp2.style.display="none";
//
//        } else {
//        	ComBtnEnable("btn_Retrieve");
//        	ComBtnDisable("btn_Upload");
//        	if (!initManual1) {
//           	    initForm();
//           	    initManual1=true;
//        	}
//        	document.getElementById("div_cre_tp1").style.display="none";//div_cre_tp1.style.display="none";
//        	document.getElementById("div_cre_tp2").style.display="Inline";//div_cre_tp2.style.display="";
//        }
////        fncSetFilter();
//    }
	 /**
	 * Events that occur When was correcting the vertical scroll bar at the end <br>
	 * <br><b>Example : </b>
	 * <pre>
	 * </pre>
	 * @param {Object} sheetObj mandatory, Sheet
	 * @param {String} CondParam mandatory, Query
	 * @param {int} PageNo mandatory, next Page no
	 * @param {int} OnePageRows mandatory, page size
	 * @return void
	 */
	function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	 /**
	  * Search at the end of the Excel  event-handling .(Excel)<br>
	  * <br><b>Example : </b>
	  * <pre>
	  * </pre>
	  * @param {Object} sheetObj mandatory, Sheet Object
	  * @param {String} errStr mandatory, The message String
	  * @returns void
	  */
//     function t2sheet2_OnSearchEnd(sheetObj, errXml) {
//    	 sheetObj.Down2Excel({ HiddenColumn:-1});
//     	ComOpenWait(false);
//     }
	/**
	 * handling process for input validation <br>
	 *
	 * @param {ibsheet} sheetObj mandatory, IBSheet Object
	 * @param {object}  formObj  mandatory, HTML Form Object
	 * @param {string}  sAction  mandatory, Action Name
	 * @return boolean Form Returns whether the object is validated. (valid true -> true, valid false -> false)
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with(sheetObj) {
			switch(sAction) {
				case IBSEARCH:
					if (!ComChkValid(formObj)) return false;
					if (ComGetObjValue(formObj.sch_tp_cd) == "ATA") {
						if (ComGetDaysBetween(formObj.dt_s.value, formObj.dt_e.value) > 7) {
							ComShowCodeMessage("BKG40008", "7");
							ComSetFocus(formObj.dt_s);
							return false;
						}
					}
					if ((ComIsEmpty(formObj.vvd)) && (ComIsEmpty(formObj.disp_bl_no)) && (ComIsEmpty($("#mult_bl_no").val()))) {
						ComShowCodeMessage("BKG95025", "VVD or B/L No.");
						return false;
					}
					if ((!ComIsEmpty(formObj.vvd)) && (ComIsEmpty(formObj.pod_cd))) {
						ComShowCodeMessage("BKG95025", "Discharging Port");
						return false;
					}
					if ($("#mult_bl_no").val().indexOf("'") != -1) {
						ComShowCodeMessage('BKG00445', "only alphanumeric characters in B/L No.");
						return false;
					}
					duplicateBlNoCheck();
					if ($('#rows').css("color").indexOf('255') > 0) {
						ComShowMessage('You can input B/L No. up to 100 Maximum. Please kindly check B/L No. again.');
						$("#layList").show();
						return false;
					}
					break;

				case IBDOWNEXCEL:
					if (!ComChkValid(formObj)) return false;
					if (ComGetObjValue(formObj.sch_tp_cd) == "ATA") {
						if (ComGetDaysBetween(formObj.dt_s.value, formObj.dt_e.value) > 7) {
							ComShowCodeMessage("BKG40008", "7");
							ComSetFocus(formObj.dt_s);
							return false;
						}
					}
					break;
			}
		}
		return true;
	}
	/**
	 * AVL_DT, FRE_DT, PICK_YD, RTN_YD  and  "Data Setup" pop-up screen, fixed in
	 * Checking a batch of BL applies.<br>
	 *
	 * @param {ibsheet} sheetObj mandatory, IBSheet Object
	 * @param {object}  infoObj  mandatory, Data Setup
	 * @return
	 */
	function fncSetInfo(sheetObj, infoObj) {
		with(sheetObj) {
			var idx=0;
			for (var i=0; i<RowCount(); i++) {
				idx=i+1;
				if (GetCellValue(idx, "chk") != "1") continue;
				if (infoObj.avl_dt != "") {
					SetCellValue(idx, "pkup_aval_dt", infoObj.avl_dt, 0);
				}
				if (infoObj.fre_dt != "") {
					SetCellValue(idx, "lst_free_dt", infoObj.fre_dt, 0);
				}
				if (infoObj.pkup_yd_cd != "") {
					SetCellValue(idx, "pkup_yd_cd", infoObj.pkup_yd_cd, 0);
				}
				if (infoObj.rtn_yd_cd != "") {
					SetCellValue(idx, "rtn_yd_cd", infoObj.rtn_yd_cd, 0);
				}
			}
		}
	}
	/**
	 * copy sheets after  Read the information  in the array
	 *
	 * @param {array} infos mandatory.
	 * @return
	 */
	function fncSetPkupNo(infos) {
		var info=null;
		var idx=-1;
		var sheetObj=sheetObjects[0];
		if (infos == null) return;
		with (sheetObj) {
			for (var i=0; i<infos.length; i++) {
				info=infos[i];
				idx=DataInsert();
				SetCellValue(idx, "chk", info.chk, 0);
				SetCellValue(idx, "bkg_no", info.bkg_no, 0);
				SetCellValue(idx, "bl_no", info.bl_no, 0);
				SetCellValue(idx, "cntr_prt_flg", info.cntr_prt_flg, 0);
				SetCellValue(idx, "cntr_no", info.cntr_no, 0);
				SetCellValue(idx, "cntr_tpsz_cd", info.cntr_tpsz_cd, 0);
				SetCellValue(idx, "pkup_aval_dt", info.pkup_aval_dt, 0);
				SetCellValue(idx, "lst_free_dt", info.lst_free_dt, 0);
				SetCellValue(idx, "pkup_no", info.pkup_no, 0);
				SetCellValue(idx, "pkup_yd_cd", info.pkup_yd_cd, 0);
				SetCellValue(idx, "rtn_yd_cd", info.rtn_yd_cd, 0);
				SetCellValue(idx, "frt_clt_flg", info.frt_clt_flg, 0);
				SetCellValue(idx, "obl_rdem_flg", info.obl_rdem_flg, 0);
				SetCellValue(idx, "cstms_clr_cd", info.cstms_clr_cd, 0);
				SetCellValue(idx, "pkup_cre_dt", info.pkup_cre_dt, 0);
				SetCellValue(idx, "ofc_cd", info.ofc_cd, 0);
				SetCellValue(idx, "pkup_cre_usr_id", info.pkup_cre_usr_id, 0);
				SetCellValue(idx, "pkup_ntc_snd_knt", info.pkup_ntc_snd_knt, 0);
				SetCellValue(idx, "pod_cd", info.pod_cd, 0);
				SetCellValue(idx, "ibd_trsp_hub_cd", info.ibd_trsp_hub_cd, 0);
				SetCellValue(idx, "del_cd", info.del_cd, 0);
				SetCellValue(idx, "usa_cstms_file_cd", info.usa_cstms_file_cd, 0);
				SetCellValue(idx, "de_term_cd", info.de_term_cd, 0);
				SetCellValue(idx, "route_guide", info.route_guide, 0);
				SetCellValue(idx, "rail_move", info.rail_move, 0);
				SetCellValue(idx, "truck_move", info.truck_move, 0);
				SetCellValue(idx, "ata_dt", info.ata_dt, 0);
				SetCellValue(idx, "vsl_cd", info.vsl_cd, 0);
				SetCellValue(idx, "skd_voy_no", info.skd_voy_no, 0);
				SetCellValue(idx, "skd_dir_cd", info.skd_dir_cd, 0);
				SetCellValue(idx, "vvd", info.vvd, 0);
				SetCellValue(idx, "rail_dep_dt", info.rail_dep_dt, 0);
				SetCellValue(idx, "rail_arr_dt", info.rail_arr_dt, 0);
			}
			if (sheetObj.RowCount()> 1) SetSelectRow(1);
//        	fncSetFilter();
		}
	}
	/**
	 * Conditions set<br>
	 *
	 * @return
	 */
	function setMandantorySearchType() {
		with(document.form) {
			setNotRequiredObject(vvd, dt_s, dt_e, disp_bl_no);
			var schVal=ComGetObjValue(sch_tp_cd);
			if (schVal == "VVD") {
				setRequiredObject(vvd);
			} else if (schVal == "ATA") {
				setRequiredObject(dt_s, dt_e);
//			} else if (schVal == "BL") {
//				setRequiredObject(disp_bl_no);
//			} else {
//				setRequiredObject(cntr_no_nonbit);
			}
		}
	}
	/**
	 * mandatory Search condition setting
	 *
	 * @param [...] Variable  arguments
	 */
	function setRequiredObject() {
		for(var i=0; i<arguments.length; i++) {
			setRequiredMode(arguments[i], true);
		}
		if (arguments != null & arguments.length == 1)
			arguments[0].focus();
	}
	/**
	 * mandatory not Search condition setting
	 *
	 * @param [...] Variable  arguments
	 * @return
	 */
	function setNotRequiredObject() {
		for(var i=0; i<arguments.length; i++) {
			setRequiredMode(arguments[i], false);
		}
	}
	/**
	 * Object  Required property setting
	 *
	 * @param obj
	 * @param requireMode
	 * @return
	 */
	function setRequiredMode(obj, requireMode) {
		if (requireMode) {
			obj.setAttribute("required", true);
		} else {
			obj.removeAttribute("required");
		}
	}
	/**
	 * Container No. CheckDigit setting.<br>
	 *
	 * @param {object} obj         mandatory
	 * @param {string} bitTarget   mandatory
	 * @param {string} valueTarget mandatory
	 * @return
	 */
	function CheckDigitSplit(obj, bitTarget, valueTarget) {
		var cntrNo=obj.value;
		with (document.form) {
			if (cntrNo.length < 10) {
				eval(bitTarget).value='';
				eval(valueTarget).value=cntrNo;
				return;
			}
			var sum=ComGetCntrChkDgt(cntrNo.substr(0, 10));
			var mod=sum % 11;
			if (mod == 10) mod=0;
			if (isNaN(mod)) {
				eval(bitTarget).value='';
				eval(valueTarget).value=obj.value;
			} else {
				obj.value=cntrNo.substr(0, 10);
				eval(bitTarget).value=mod;
				eval(valueTarget).value=obj.value + mod;
			}
		}
	}
	/**
	 * Monitoring batch status
	 * @return
	 */
	function monitoringBatchJob() {
		var sheetObj=null;
		if (tabObjects[0].SetSelectedIndex() == 0) {
			sheetObj=sheetObjects[0];
		}
		else if (tabObjects[0].SetSelectedIndex() == 1) {
			sheetObj=sheetObjects[1];
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
	}
	/**
	 * brings batch status Description
	 * @param {string} status
	 * @return {string} batch status Description
	 */
	function getBatchStatusDesc(status) {
		/*
			Status Code
		status	1	RUNNING
		status	3	STARTING
		status	4	SUCCESS
		status	5	FAILURE
		status	6	TERMINATED
		status	7	ON_ICE
		status	8	INACTIVE
		status	9	ACTIVATED
		status	10	RESTART
		status	11	ON_HOLD
		status	12	QUE_WAIT
		*/
		var desc="";
		if (status == "1") {
			desc="Running";
		} else if (status == "3") {
			desc="Starting";
		} else if (status == "4") {
			desc="Success";
		} else if (status == "5") {
			desc="Fail";
		} else if (status == "6") {
			desc="Terminated";
		} else if (status == "7") {
			desc="On Ice";
		} else if (status == "8") {
			desc="Inactive";
		} else if (status == "9") {
			desc="Activated";
		} else if (status == "10") {
			desc="Restart";
		} else if (status == "11") {
			desc="On Hold";
		} else if (status == "12") {
			desc="Que Wait";
		} else {
			desc="Undefined status:" + status + "";
		}
		return desc;
	}
	function jqueryEvent() {
		$("#disp_bl_no").keyup(function() {
			if ($(this).val() != "") {
				multiBlTextArea(1);
			}
		});
		$("#mult_bl_no").keyup(function() {multiBlTextArea(2);});
		$("#mult_bl_no").focusout(function() {$("#layList").hide();});
	}
	
	var lines = 100;
	function multiBlTextArea(type) {


		if (type == 1) {
			$("#mult_bl_no").val("");
			$("#layList").hide();
			$("#btn_multBlNo").css({'background':'url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat', 'background-color':'#ffffff'});
		} else if (type == 2) {
			$("#disp_bl_no").val("");
			$("#btn_multBlNo").css({'background':'url(./style/images/theme_default/sprite_common.png) -152px -157px no-repeat', 'background-color':'#ffffff'});
		}

		if ($("#mult_bl_no").val() != "") {
			var newLines = $("#mult_bl_no").val().split("\n").length;
			$("#rows").text(leadingZeros(newLines, 3));
			if (newLines > lines) {
				$("#rows").css('color', 'red');
			} else {
				$("#rows").css('color', '');
			}
		} else{
			$("#rows").css('color', '');
			$("#rows").text(leadingZeros(0, 3));
		}
	}
	function duplicateBlNoCheck() {
		/* B/L list */
		var blNoList = $("#mult_bl_no").val().split("\n");
		var str = $("#mult_bl_no").val();
		/* 중복된 B/L 저장 */
		var duplicateBlNo = new Array();
		var duplicateStr = "";
		var newBlNo = "";
	//	var newBlNo = "";
		/* 중복 B/L 체크 */
		for (var i = 0; i < blNoList.length; i++) {
			/* 값이 없으면 skip */
			if (blNoList[i] == "") continue;
			/* 해당 B/L가 중복됐는지 확인 */
			var blNo = blNoList[i].split(" ").join("");
			var tempCheck = str.split(blNo);
			/* length가 2보다 크면 중복된 B/L */
			if (tempCheck.length > 2) {
				var temp = false;
				/* 중복된 B/L가 이미 처리됐는지 확인 */
				for (var j = 0; j < duplicateBlNo.length; j++) {
					if (duplicateBlNo[j] == blNo) {
						temp = true;
						break;
					}
				}
				/* B/L 저장 */
				if (!temp) {
					if (duplicateBlNo.length > 0) duplicateStr += ", ";
					duplicateStr += blNo;
					duplicateBlNo[duplicateBlNo.length] = blNo;
				}
			}
			/* 중복되지 않은 B/L */
			else{
				
				newBlNo += blNo + "\n";
			}
		}

		if (duplicateBlNo.length > 0) {
			duplicateStrMsg(duplicateStr);
			for (var i = 0; i < duplicateBlNo.length; i++) {
				newBlNo += duplicateBlNo[i];
				if((i+1) < duplicateBlNo.length) newBlNo += "\n";
			}
			$("#mult_bl_no").val(newBlNo);
			if($("#mult_bl_no").val() != ""){
				var newLines = $("#mult_bl_no").val().split("\n").length;
	    		$("#rows").text(leadingZeros(newLines, 3));
	    		if(newLines > lines) {
	    			$("#rows").css('color', 'red');
	            }else {
	            	$("#rows").css('color', '');
	            }
	    	}else{
	    		$("#rows").css('color', '');
				$("#rows").text(leadingZeros(0, 3));
	    	}
		}

		$("#layList").hide();
	}
	
	function leadingZeros(n, digits) {
		var zero = '';
		n = n.toString();
		if (n.length < digits) {
			for (var i = 0; i < digits - n.length; i++) {
				zero += '0';
			}
		}
		return zero + n;
	}
	/**
	 * 중복 메세지
	 */
	function duplicateStrMsg(duplicateStr) {
		ComShowMessage('B/L No is duplicated.\n' + duplicateStr);
	}
