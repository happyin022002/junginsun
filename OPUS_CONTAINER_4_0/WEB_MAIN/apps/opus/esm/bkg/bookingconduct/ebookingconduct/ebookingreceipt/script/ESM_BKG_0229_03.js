/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_03.js
*@FileTitle  : e-Booking & SI Process Detail(CONTAINER) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// public variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	var isCopy="false";
	var pkgPosition=0;
	var wgt_cd_list="";
	var wgt_nm_list="";
	var meas_cd_list="";
	var meas_nm_list="";
	var rcv_term_cd_list="";
	var de_term_cd_list=""; 
	var t3Xml="";
	var vgmCheckData="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case IBCLEAR:
					doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
					break;
				case "btn_cancelcopydata":
					parent.document.form.containerTabCancel.value="Y";
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					isCopy="false";
					top.isCopyAllRequested=false;
					break;
				case "btn_datacopytoopus":
					if (isCopy == "false") {
						dataCopy('0229_03');
					}
					break;
				case "btn_upload":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
	 * initializing sheet implementing onLoad event handler in body tag 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
			// IBMultiCombo
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		
		initControl();
	}
	function initControl() {
		var formObject=document.form;
		// Axon Event process1 Event catch(Develoer can change)
		// Axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
		// in case of keyboard input
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
		// Axon_event.addListenerForm('focus', 'form1_focus', document.form);
		// Axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
	    axon_event.addListenerForm('change', 'form1_change', document.form);
		applyShortcut();
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * 
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	  * setting combo initial values and header 
	  * 
	  * @param {IBMultiCombo}
	  *            comboObj comboObj
	  */
	 function initCombo(comboObj) {
	 	comboObj.SetMultiSelect(0);
	 	comboObj.SetColAlign(0, "left");
	 	comboObj.SetColAlign(1, "left");
	 	comboObj.SetMultiSeparator("|");
	 }
	 /**
	  * registering IBCombo Object as list
	  * 
	  * @param {IBMultiCombo}
	  *            combo_obj IBMultiCombo Object
	  */
	 function setComboObject(combo_obj) {
	 	comboObjects[comboCnt++]=combo_obj;
	 }
	/**
	 * setting sheet initial values and header param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 adding case as numbers of counting sheets
	 */
	 function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":// OPUS cntr
		      with(sheetObj){
		         var HeadTitle1="left_seq|right_seq|ibflag|dp_seq|bkg_no|cntr_cfm_flg|cntr_no_old|cntr_no|cntr_tpsz_cd|seal1|seal2|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|rcv|dlv|cntr_prt_flg|vol|as|cnmv_sts_cd|hngr|dg|bb|ak|rc|rd|soc|org_yd|rcv_dt|diff_rmk|po_no|vgm_wgt|vgm_wgt_ut_cd|vgm_check";
		         var headCount=ComCountHeadTitle(HeadTitle1);
		         var prefix="sheet1_";
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"left_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"right_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_dp_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no_old",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"adv_shtg_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hngr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rd_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"soc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cgo_rcv_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"po_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"vgm_check",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
		             ];
		         InitColumns(cols);
		         SetEditable(0);
		         SetColProperty("cgo_rcv_dt", {Format:"####-##-####:##"} );
		         SetVisible(0);
		         SetSheetHeight(200);
				}
			break;
		case "sheet2": //OPUS seal
		    with(sheetObj){
			      var HeadTitle1="||bkg no|cntr no|Seal Seq.|Seal No|knd_cd|pty_tp|pty_nm|Print";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet2_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sel" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"cntr_seal_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"cntr_seal_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seal_knd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seal_pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"seal_pty_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Right",   ColMerge:0,   SaveName:"prn_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
			      SetSheetHeight(200);
	            }
			break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = 1;
		switch (sAction) {
		case IBSAVE:
//			doCntrSaveCopy();
			var params=getSaveStringForUpload();
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0229_03GS.do", params);
			var rMsg=ComResultMessage(sXml);
			if (rMsg == '') {
				sheetObjects[0].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
				sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
			} else {
				sheetObj.LoadSaveData(sXml);
			}
			break;
		case IBCLEAR: // retrieve		
			if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
				var formObj2=document.form2;
				var obj=null;
				var objNm=null;
				var obj2=null;
				var objNm2=null;
				for ( var i=0; i < formObj.elements.length; i++) {
					if (formObj.elements[i].name.indexOf("pck_qty") == 0)
						formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,##0");
					if (formObj.elements[i].name.indexOf("cntr_wgt") == 0)
						formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###.000");
					if (formObj.elements[i].name.indexOf("meas_qty") == 0)
						formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,###.000");				
				}
				for ( var j=0; j < formObj2.elements.length; j++) {
					if (formObj2.elements[j].name.indexOf("pck_qty") == 0)
						formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,##0");
					if (formObj2.elements[j].name.indexOf("cntr_wgt") == 0)
						formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###.000");
					if (formObj2.elements[j].name.indexOf("meas_qty") == 0)
						formObj2.elements[j].value=ComAddComma(formObj2.elements[j].value, "#,###.000");
				}
				var sameCntr=false;
				for ( var i=0; i < formObj2.elements.length; i++) {
					if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
						obj=(formObj2.elements[i].name).split("__");
						objNm=obj[0];
						if (objNm == "cntr_no") {
							var sameCntrSeq=findSameCntr(formObj, formObj2.elements[i].value);
							if(sameCntrSeq > 0){
								sameCntr=false;
							} else {
								sameCntrr=true;
							}			
							if (sameCntr) {
								compareCntr(obj2[1], obj[1]);
							}
						}
					}
				}
				var sXml=formObj.sXml.value;
				var arrXml=sXml.split("|$$|");
				for ( var i=0; i < arrXml.length; i++) {
					//sheetObjects[i].RenderSheet(0);
					if(sheetObjects[i]){
						if (i > 0) {
							sheetObjects[i].SetWaitImageVisible(0);
						}
						sheetObjects[i].RemoveAll();
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					}
					//sheetObjects[i].RenderSheet(1);
				}
				for ( var i=1; i < sheetObjects[0].LastRow(); i++){
					if (sheetObjects[0].GetCellValue(i, "cntr_cfm_flg") == "Y"){
						sheetObjects[0].SetCellValue(i, "cntr_cfm_flg","1",0);
					} else {
						sheetObjects[0].SetCellValue(i, "cntr_cfm_flg","0",0);
					}
				}
				var leftSeq=0;
				var rowStatus="";
				for ( var i=0; i < formObj.elements.length; i++) {
					if (formObj.elements[i].name.indexOf("pck_qty") == 0) {
						leftSeq++;
						rowStatus=sheetObjects[0].GetRowStatus(leftSeq);
						sheetObjects[0].SetCellValue(leftSeq, "left_seq",leftSeq,0);
						sheetObjects[0].SetRowStatus(leftSeq,rowStatus);
					}
				}
				for ( var i=0; i < formObj.elements.length; i++) {
					if (formObj.elements[i].name.indexOf("pck_qty") == 0) {
						formObj.elements[i].value=ComAddComma(formObj.elements[i].value, "#,##0");
					}
					if (formObj.elements[i].name.indexOf("meas_qty") == 0) {
						formObj.elements[i].value=makeComma(formObj.elements[i].value.replace(/,/g, ""));
					}
					if (formObj.elements[i].name.indexOf("cntr_wgt") == 0) {
						formObj.elements[i].value=makeComma(formObj.elements[i].value.replace(/,/g, ""));
					}
					if (formObj.elements[i].name.indexOf("vgm_wgt") == 0 && formObj.elements[i].name.indexOf("vgm_wgt_ut_cd") == -1) {
						formObj.elements[i].value=makeComma(formObj.elements[i].value.replace(/,/g, ""));
					}
					if (formObj.elements[i].name.indexOf("rcv_term_cd") == 0) {
						if ( ComGetObjValue(parent.frames["t1frame"].form.rcv_term_cd) == "M" ) {
							formObj.elements[i].disabled=false;
						} else {
							formObj.elements[i].disabled=true;
						}
					}
					if (formObj.elements[i].name.indexOf("de_term_cd") == 0) {
						if ( ComGetObjValue(parent.frames["t1frame"].form.de_term_cd) == "M" ) {
							formObj.elements[i].disabled=false;
						} else {
							formObj.elements[i].disabled=true;
						}
					}
				}  
				for ( var i=0; i < formObj2.elements.length; i++) {
					if (formObj2.elements[i].name.indexOf("pck_qty") == 0) {
						formObj2.elements[i].value=ComAddComma(formObj2.elements[i].value, "#,##0");
					}
					if (formObj2.elements[i].name.indexOf("meas_qty") == 0) {
						formObj2.elements[i].value=makeComma(formObj2.elements[i].value.replace(/,/g, ""));
					}
					if (formObj2.elements[i].name.indexOf("cntr_wgt") == 0) {
						formObj2.elements[i].value=makeComma(formObj2.elements[i].value.replace(/,/g, ""));
					}
					if (formObj2.elements[i].name.indexOf("vgm_wgt") == 0 && formObj2.elements[i].name.indexOf("vgm_wgt_ut_cd") == -1) {
						formObj2.elements[i].value=makeComma(formObj2.elements[i].value.replace(/,/g, ""));
					}
				}
			}
			if(parent.document.form.containerTabCancel.value=="Y"){
				//ComBtnColor("btn_cancelcopydata", "blue");
				//ComBtnColor("btn_datacopytoopus", "#737373");
				
				document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;;font-weight:bold;";
				document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;;font-weight:normal;";
				parent.document.form.containerTabCancel.value="N";
			}
			if(top.document.form.tabload3.value == "COPY"){
				dataCopy('0229_03');
			}
			top.document.form.tabload3.value="LOAD";
			
			if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_03');
			break;
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH02;
			formObj.method="post";

			parent.frames['t3frame'].location.reload();
			break;
		
		case IBSEARCH_ASYNC02: // Data Copy
			// DHTML table creation
			var insTableDiv="";
			var maxSeq=0;
			if (sheetObjects[0].RowCount()> 0) {
				maxSeq=sheetObjects[0].RowCount();
			}
			// container comparison
			var formObj2=document.form2;
			var obj=null;
			var objNm=null;
			var obj2=null;
			var objNm2=null;
			var isInsert="init";
			if (maxSeq > 0) {
				for ( var i=0; i < formObj2.elements.length; i++) {
					if ((formObj2.elements[i].name).indexOf("__") > 0) {
						obj=(formObj2.elements[i].name).split("__");
						objNm=obj[0];
						if (objNm == "cntr_no") {
							for ( var j=0; j < formObj.elements.length; j++) {
								if ((formObj.elements[j].name).indexOf("__") > 0) {
									obj2=(formObj.elements[j].name).split("__");
									objNm2=obj2[0];
									if (objNm2 == "cntr_no") {
										if (formObj2.elements[i].value == formObj.elements[j].value) {
											isInsert="false";
											break;
										} else {
											isInsert="true";
										}
									}
								}
							}
							if (isInsert=="true") {
								maxSeq++;
								var insTableDiv=createTable(maxSeq);
								$("#INS_TABLES").append(insTableDiv);
								createCntr(maxSeq, obj[1]);
							} else if(isInsert=="false"){
								updateCntr(obj2[1], obj[1]);
								compareCntr(obj2[1], obj[1]);
							}
						}
					}
				}
			} else {
				for ( var i=0; i < formObj2.elements.length; i++) {
					if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
						obj=(formObj2.elements[i].name).split("__");
						objNm=obj[0];
						if (objNm == "cntr_no") {
							maxSeq++;
							var insTableDiv=createTable(maxSeq);
							$("#INS_TABLES").append(insTableDiv);
							createCntr(maxSeq, obj[1]);
						}
					}
				}
			}
			var seq=1;
			for ( var i=0; i < formObj.elements.length; i++) {
				if ( document.form.fnl_cfm_flg.value != "Y" ) {
					var objNm=(formObj.elements[i].name).split("__");
					if (objNm[0] == "cntr_seq") {
						formObj.elements[i].value=seq++;
					} else if (objNm[0] == "rcv_term_cd"){
						if ( ComGetObjValue(parent.frames["t1frame"].form.rcv_term_cd) == "M" ) {
							formObj.elements[i].disabled=false;
						} else {
							formObj.elements[i].disabled=true;
							formObj.elements[i].value=ComGetObjValue(parent.frames["t1frame"].document.form.rcv_term_cd);
						}
					} else if (objNm[0] == "de_term_cd"){
						if ( ComGetObjValue(parent.frames["t1frame"].form.de_term_cd) == "M" ) {
							formObj.elements[i].disabled=false;
						} else {
							formObj.elements[i].disabled=true;
							formObj.elements[i].value=ComGetObjValue(parent.frames["t1frame"].document.form.de_term_cd);
						}
					}
				} else {
					if (objNm[0] == "rcv_term_cd"){
						formObj.elements[i].disabled=false;
					} else if (objNm[0] == "de_term_cd"){
						formObj.elements[i].disabled=false;
					}
				}
			}
			isCopy="true";
			initControl();
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSAVE:
				var dmgFlgCheckCntrNo = '';
				var count = sheetObjects[1].RowCount();
				for (var i = 0; i < count; i++) {
					var sealNo = sheetObjects[1].GetCellValue(i, "cntr_seal_no");
					if(sealNo != null && sealNo.length > 15){
						ComShowMessage('[' + sealNo + '] Seal No must be shorter than 15 characters long.');
						return false;
					}
				}
				
				var cntrSheet = sheetObjects[0];
				//var cntrCount=cntrSheet.RowCount()+ 1;
				var cntrCount=sheetObjects[0].RowCount();
				for (ir=1; ir <= cntrCount; ir++) {
					if (cntrSheet.GetCellValue(ir, "ibflag") != 'D') {
						try{
							if(cntrSheet.GetCellValue(ir, "ibflag") == 'I'){
								var cntNoDmgCk = cntrSheet.GetCellValue(ir, "cntr_no");
								var param = "f_cmd=" + SEARCH03 + "&sheet1_cntr_no=" + cntNoDmgCk + "&sheet1_ibflag=I";
								var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0079_04GS.do", param);
								var dmg_flg = ComGetEtcData(sXml, "DMG_FLG");
								if(dmg_flg == 'Y'){
									dmgFlgCheckCntrNo += cntNoDmgCk + ",";
								}
							}
						}catch (e) { }
						/* cntr_prt_flg 체크되어있지 않을시 bkgNo, cntrNo 조희한 결과에따라 메세지 확인 */
						if(eval("formObj.cntr_prt_flg__" + ir) != undefined){
							var cntr_prt_flg = eval("formObj.cntr_prt_flg__" + ir + ".checked");
							if(!cntr_prt_flg){
								formObj.f_cmd.value = SEARCH;
								var param = "f_cmd=" + SEARCH02 + "&cntr_no=" + cntrSheet.GetCellValue(ir, "cntr_no") + "&bkg_no=" + cntrSheet.GetCellValue(ir, "bkg_no");
								var sXml = sheetObjects[0].GetSaveData("ESM_BKG_0229_03GS.do", param);
								var bkgNo = ComGetEtcData(sXml, "bkgNo");
								if(bkgNo != ""){
									ComShowCodeMessage("BKG00949", cntrSheet.GetCellValue(ir, "cntr_no"), bkgNo);
									ComSetFocus(eval("formObj.cntr_prt_flg__" + ir));
									return false;
								}
							}
						}
						
						if (cntrSheet.GetCellValue(ir, "ibflag") == 'I') {
							if ( document.form.fnl_cfm_flg.value == "Y" ) {
								ComShowMessage(ComGetMsg("BKG02059",cntrSheet.GetCellValue(ir, "cntr_no")));
								return false;
							}
						}
						if (cntrSheet.GetCellValue(ir, "cntr_no") == '') {
							ComShowMessage(ComGetMsg("BKG00888", "cntr_no"));
							ComSetFocus(eval("formObj.cntr_no__" + ir));
							return false;
						}
						if(!ComIsEmpty(cntrSheet.GetCellValue(ir, "pck_qty"))){
							if(BkgParseInt(cntrSheet.GetCellValue(ir, "pck_qty")) < 0){
								ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
								ComSetFocus(eval("formObj.pck_qty__" + ir));
								return false;
							} else if(BkgParseInt(cntrSheet.GetCellValue(ir, "pck_qty")) == 0 && cntrSheet.GetCellValue(ir, "bb_cgo_flg") == 0){
								ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
								ComSetFocus(eval("formObj.pck_qty__" + ir));
								return false;
							}
							if(ComIsEmpty(cntrSheet.GetCellValue(ir, "pck_tp_cd"))){
								ComShowMessage(ComGetMsg("BKG00888", "pck_tp_cd"));
								ComSetFocus(eval("formObj.pck_tp_cd__" + ir));
								return false;
							}						
						}
					}	
				}
				if(dmgFlgCheckCntrNo != ''){
					if(!ComShowConfirm(dmgFlgCheckCntrNo.substring(0, dmgFlgCheckCntrNo.length-1) + '\n' + ComGetMsg('BKG08354'))) return false;
				}
				break;
		}
		return true;
	}
	function validateForUpload() {
		doCntrSaveCopy();
		return validateForm(sheetObjects[0], document.form, IBSAVE);
	}
	/**
	 * Calling after upload click
	 */
	function getSaveStringForUpload() {
		var formObj=document.form;
		var sXml=formObj.sXml.value;
		formObj.sXml.value="";
		//doCntrSaveCopy();
		formObj.f_cmd.value=MULTI;
		var params=FormQueryString(formObj);
		for ( var i=1; i <= sheetObjects[0].RowCount(); i++){
			if (sheetObjects[0].GetCellValue(i, "cntr_no") == ""){
				sheetObjects[0].RowDelete(i, 0);
			}
		}
		params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_");
		params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_");
		formObj.sXml.value=sXml;
		return params;
	}
	
	function dataCopy(cell) {
		if(parent.document.form.doc_tp_cd.value == 'B' && cell == undefined) return;
			
		document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;;font-weight:bold;";
		document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;;font-weight:normal;";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);

	}
	
	function setCopyFlag(flag){
		isCopy=flag;
	}
	function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
		var formObj=document.form;
		var formObj2=document.form2;
		var tmp=eval(eBkgItemNm);
		if (bkgValue != eBkgValue) {
			tmp.style.color="blue"
		} else {
			tmp.style.color="#606060";
		}	
	}
	//color comparison handling
	function compareCntr(leftSeq, rightSeq) {
		if(leftSeq==0||rightSeq==0) return;
		var formObj=document.form;
		var formObj2=document.form2;
		setCntrDiffCheckColor(eval("formObj.cntr_no__" + leftSeq).value, eval("formObj2.cntr_no__" + rightSeq).value, ("formObj2.cntr_no__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" + leftSeq).value, eval("formObj2.cntr_tpsz_cd__" + rightSeq).value, ("formObj2.cntr_tpsz_cd__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.pck_qty__" + leftSeq).value, eval("formObj2.pck_qty__" + rightSeq).value, ("formObj2.pck_qty__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.pck_tp_cd__" + leftSeq).value, eval("formObj2.pck_tp_cd__" + rightSeq).value, ("formObj2.pck_tp_cd__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.cntr_wgt__" + leftSeq).value, eval("formObj2.cntr_wgt__" + rightSeq).value, ("formObj2.cntr_wgt__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.wgt_cd__" + leftSeq).value, eval("formObj2.wgt_cd__" + rightSeq).value, ("formObj2.wgt_cd__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.meas_qty__" + leftSeq).value, eval("formObj2.meas_qty__" + rightSeq).value, ("formObj2.meas_qty__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.meas_cd__" + leftSeq).value, eval("formObj2.meas_cd__" + rightSeq).value, ("formObj2.meas_cd__" + rightSeq));
		setCntrDiffCheckColor(eval("formObj.po_no__" + leftSeq).value, eval("formObj2.po_no__" + rightSeq).value, ("formObj2.po_no__" + rightSeq));
	}
	//Container list Copy to sheet for store 
	function doCntrSaveCopy() {
		var formObj=document.form;
		var obj=null;
		var objNm=null;
		var objSeq=null;
		var objVal=null;
		var objCode=null;
		var cntrNo=null;
		var ibflag=null;
		var sealSeq=0;
		var i=0;
		var seal_cunt_flg="N";
		var cntr_no=new Array();
		var cntr_seal_no=new Array();
		var seal_knd_cd=new Array();
		var seal_pty_tp_cd=new Array();
		var seal_pty_nm=new Array();
		var prn_flg=new Array();
		var cntrSheetRows=sheetObjects[0].LastRow();
		var sealSheetRows=sheetObjects[1].LastRow();
	    for( i=0; i <sealSheetRows; i++ ){
	    	cntr_no[i]=sheetObjects[1].GetCellValue(i, "cntr_no");
	    	cntr_seal_no[i]=sheetObjects[1].GetCellValue(i, "cntr_seal_no");
	    	seal_knd_cd[i]=sheetObjects[1].GetCellValue(i, "seal_knd_cd");
	    	seal_pty_tp_cd[i]=sheetObjects[1].GetCellValue(i, "seal_pty_tp_cd");
	    	seal_pty_nm[i]=sheetObjects[1].GetCellValue(i, "seal_pty_nm");
	    	prn_flg[i]=sheetObjects[1].GetCellValue(i, "prn_flg");
	    } 
		sheetObjects[1].RemoveAll();
		for ( i=0; i < formObj.elements.length; i++) {
			if ((formObj.elements[i].name).indexOf("__") > 0) {
				obj=(formObj.elements[i].name).split("__");
				objNm=obj[0];
				objSeq=obj[1];
				
				
				objSeq = sheetObjects[0].FindText("left_seq", objSeq);
				
				objVal=formObj.elements[i].value;
				if (objNm == "ibflag") {
					ibflag=objVal;
					if (sheetObjects[0].GetCellValue(objSeq, "ibflag") != "D") {
						sheetObjects[0].SetRowStatus(objSeq,objVal);
					}
				}
				sheetObjects[0].SetCellValue(objSeq, "sel","N");
				sheetObjects[0].SetCellValue(objSeq, "bkg_no",formObj.bkg_no.value);
				if (objNm == "cntr_no") {
					cntrNo=objVal;
					sheetObjects[0].SetCellValue(objSeq, "cntr_no",objVal);
					sheetObjects[0].SetCellValue(objSeq, "cntr_no_old",objVal);
					
					if(cntrNo != null && cntrNo != ''){
						var vgmTemp = [];
						if(vgmCheckData.indexOf(',') > -1){
							vgmTemp = vgmCheckData.split(',');
						}
						for (var j = 0; j < vgmTemp.length; j++) {
							if(vgmTemp[j] != '' && vgmTemp[j].indexOf("=") > -1){
								var cntrTemps = vgmTemp[j].split("=");
								if(cntrTemps[0] == cntrNo){
									sheetObjects[0].SetCellValue(objSeq, "vgm_check", cntrTemps[1]);
									break;
								}
							}
						}
					}
				}
				if (objNm == "cntr_tpsz_cd")	sheetObjects[0].SetCellValue(objSeq, "cntr_tpsz_cd",objVal);
				if (objNm == "po_no")       	sheetObjects[0].SetCellValue(objSeq, "po_no",objVal);
				if (objNm == "pck_qty") 		sheetObjects[0].SetCellValue(objSeq, "pck_qty",(objVal).replaceStr(","));
				if (objNm == "pck_tp_cd") 		sheetObjects[0].SetCellValue(objSeq, "pck_tp_cd",objVal);
				if (objNm == "cntr_wgt") 		sheetObjects[0].SetCellValue(objSeq, "cntr_wgt",(objVal).replaceStr(","));
				if (objNm == "wgt_cd") 			sheetObjects[0].SetCellValue(objSeq, "wgt_ut_cd",objVal);
				if (objNm == "meas_qty") 		sheetObjects[0].SetCellValue(objSeq, "meas_qty",(objVal) .replaceStr(","));
				if (objNm == "meas_cd") 		sheetObjects[0].SetCellValue(objSeq, "meas_ut_cd",objVal);
				if (objNm == "rcv_term_cd") 	sheetObjects[0].SetCellValue(objSeq, "rcv_term_cd",objVal);
				if (objNm == "de_term_cd") 		sheetObjects[0].SetCellValue(objSeq, "de_term_cd",objVal);
				if (objNm == "vgm_wgt") 		sheetObjects[0].SetCellValue(objSeq, "vgm_wgt",objVal);
				if (objNm == "vgm_wgt_ut_cd") 	sheetObjects[0].SetCellValue(objSeq, "vgm_wgt_ut_cd",objVal);
				
				if (objNm == "cntr_prt_flg") {
					sheetObjects[0].SetCellValue(objSeq, "cntr_prt_flg",(formObj.elements[i].checked)?"1":"0");
				}
				if (objNm == "cntr_seal_no") {
					seal_cunt_flg="N";
					for ( var j=0; j < formObj.elements[i].length; j++) {
						sheetObjects[1].DataInsert(-1);
						sealSeq++;
						if (j == 0) sheetObjects[0].SetCellValue(objSeq, "seal_no1",formObj.elements[i].options[j].value);
						if (j == 1) sheetObjects[0].SetCellValue(objSeq, "seal_no2",formObj.elements[i].options[j].value);
						sheetObjects[1].SetCellValue(sealSeq, "bkg_no",formObj.bkg_no.value);
						sheetObjects[1].SetCellValue(sealSeq, "cntr_no",cntrNo);
						sheetObjects[1].SetCellValue(sealSeq, "cntr_seal_seq",j + 1);
						sheetObjects[1].SetCellValue(sealSeq, "cntr_seal_no",formObj.elements[i].options[j].value);
						for( var k=0; k <sealSheetRows; k++ ){
							if ( cntrNo == cntr_no[k] && sheetObjects[1].GetCellValue(sealSeq, "cntr_seal_no") == cntr_seal_no[k] ){
								sheetObjects[1].SetCellValue(sealSeq, "seal_knd_cd",seal_knd_cd[k]);
								sheetObjects[1].SetCellValue(sealSeq, "seal_pty_tp_cd",seal_pty_tp_cd[k]);
								sheetObjects[1].SetCellValue(sealSeq, "seal_pty_nm",seal_pty_nm[k]);
								sheetObjects[1].SetCellValue(sealSeq, "prn_flg",prn_flg[k]);
								seal_cunt_flg="Y";
							}
					    }
						if ( seal_cunt_flg != "Y" ) {
							sheetObjects[1].SetRowStatus(sealSeq,"I");
						} else {
							sheetObjects[1].SetRowStatus(sealSeq,ibflag);
						}						
					}
				}
			}
		}
		var cntrCnt=0;
		for ( var i=1; i < sheetObjects[0].LastRow(); i++){
			cntrCnt=0;
			if (sheetObjects[0].GetCellValue(i, "ibflag") == "D"){
				for ( var j=1; j < sheetObjects[0].LastRow(); j++){
					if (sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[0].GetCellValue(j, "cntr_no")){
						cntrCnt++;
					}
				}
			}
			if ( cntrCnt > 1 ){
				sheetObjects[0].SetRowStatus(i,"");
				for ( var j=1; j < sheetObjects[0].LastRow(); j++){
					if (sheetObjects[0].GetCellValue(j, "ibflag") == "I"){
						sheetObjects[0].SetRowStatus(j,"U");
					}
				}
			}
		}	
	}
	//  add new list to Container
	function doAddCntrCopy(leftSeq, rightSeq) {
		var formObj=document.form;
		var formObj2=document.form2;
		var Row=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(Row, "left_seq",leftSeq);
		sheetObjects[0].SetCellValue(Row, "right_seq",rightSeq);
		sheetObjects[0].SetRowStatus(Row,"I");
		sheetObjects[0].SetCellValue(Row, "sel","N");
		sheetObjects[0].SetCellValue(Row, "cntr_cfm_flg","Y");
		sheetObjects[0].SetCellValue(Row, "bkg_no",formObj.bkg_no.value);
		sheetObjects[0].SetCellValue(Row, "cntr_no",eval("formObj2.cntr_no__"		+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "cntr_no_old",eval("formObj2.cntr_no__"		+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "cntr_tpsz_cd",eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "seal_no1",eval("formObj2.cntr_seal_no__"+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "pck_qty",(eval("formObj2.pck_qty__"		+ rightSeq).value).replaceStr(","));
		sheetObjects[0].SetCellValue(Row, "pck_tp_cd",eval("formObj2.pck_tp_cd__"	+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "cntr_wgt",(eval("formObj2.cntr_wgt__"	+ rightSeq).value).replaceStr(","));
		sheetObjects[0].SetCellValue(Row, "wgt_ut_cd",eval("formObj2.wgt_cd__"		+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "meas_qty",(eval("formObj2.meas_qty__"	+ rightSeq).value).replaceStr(","));
		sheetObjects[0].SetCellValue(Row, "meas_ut_cd",eval("formObj2.meas_cd__"		+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "po_no",eval("formObj2.po_no__"		+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "rcv_term_cd",eval("formObj2.rcv_term_cd__"	+ rightSeq).value);
		sheetObjects[0].SetCellValue(Row, "de_term_cd",eval("formObj2.de_term_cd__"	+ rightSeq).value);
		
	}
	//showing deleted cntr 
	function doDeleteCntrAppend(seq) {
		var formObj=document.form;
		var foundRow=sheetObjects[0].FindText("left_seq", seq);
		sheetObjects[0].SetRowStatus(foundRow,"D");
	}
	// add cntr 
	function createTable(seq) {
		var insTableDiv="";
		insTableDiv += "<div id='table_" + seq + "'>\n";
		insTableDiv += "</div>\n";
		return insTableDiv;
	}
	//copy eSVC cntr to bkg
	function createCntr(leftSeq, rightSeq) {
	    var formObj2=document.form2;
	    var tabSeq="table_" + leftSeq;
	    var dyntbl1=document.getElementById(tabSeq);
	    dyntbl1.innerHTML="";
	    var oCell1="";
	    var oCell2="";
	    var wgt_cdArr=wgt_cd_list.split("|");
	    var wgt_nmArr=wgt_nm_list.split("|");
	    var meas_cdArr=meas_cd_list.split("|");
	    var meas_nmArr=meas_nm_list.split("|");
	    var rcv_term_cdArr=rcv_term_cd_list.split("|");
	    var de_term_cdArr=de_term_cd_list.split("|");

	    var colGrStr =
	        '<colgroup>\n' +
	        '	<col width="60" />' +
	        '	<col width="140" />' +
	        '	<col width="70" />' +
	        '	<col width="100" />' +
	        '	<col width="50" />' +
	        '	<col width="*" />' +
	        '</colgroup>\n';
	    oCell1 += "<input type=\"hidden\" name=\"ibflag__" + leftSeq + "\" value=\"I\">\n";
	    oCell1 += "<table id=\"table" + leftSeq + "\" >";
	    oCell1 += colGrStr;
	    //ROW1 (S)
	    oCell1 += "<tr>\n";
	    oCell1 += "<th><input type=\"text\" name=\"cntr_seq__" + leftSeq + "\" style=\"width:25px;\" class=\"input\" value=\"" + leftSeq  + "\" readOnly>CNTR No.</th>\n";
	    oCell1 += "<input type=\"hidden\" name=\"cntr_no_hidden__" + leftSeq + "\" value=\"" + eval("formObj2.cntr_no__" + rightSeq).value + rightSeq + "\" readOnly></td>\n";
	    oCell1 += "<td><input type=\"text\" name=\"cntr_no__" + leftSeq + "\" style=\"width:90px;\" maxlength=\"14\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.cntr_no__" + rightSeq).value + "\" onChange=\"javascript:changeCntrTpszCd(this);\">" 
	    		+ "<input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq + "\" style=\"width:31px;\" maxlength=\"4\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\" ></td>\n";
	    oCell1 += "<th>Seal No.</th>\n";
	    oCell1 += "<td>" +
	    		"<div class='select-editable'>" +
	    		"<select name=\"cntr_seal_no__" + leftSeq + "\" id=\"cntr_seal_no__" + leftSeq + "\" style=\"width:135px;\" onchange='sealNoChange(this," + leftSeq + ")'>\n"
	    for ( var i=0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
	        oCell1 += "<option value=\"" + eval("formObj2.cntr_seal_no__" + rightSeq).options[i].value + "\">" + eval("formObj2.cntr_seal_no__" + rightSeq).options[i].text  + "</option>\n";
	    }
	    oCell1 += "</select>";
	    
	    var cntrSealNo = eval("formObj2.cntr_seal_no__" + rightSeq).options[0]==undefined?"":eval("formObj2.cntr_seal_no__" + rightSeq).options[0].value;
	    oCell1 += "<input type='text' class='input' id='seal_no_text_" + leftSeq + "' onchange='javascript:sealNoCheck(this, " + leftSeq + ");' value='" + cntrSealNo + "' />" +
	    		"</div>";
	    oCell1 += "</td>\n";
	    oCell1 += "<th><label for=\"cntr_prt_flg__" + leftSeq + "\"><strong>P</strong></label><input type=\"checkbox\" value=\"\" class=\"trans\" name=\"cntr_prt_flg__" + leftSeq + "\" id=\"cntr_prt_flg__" + leftSeq + "\" /></th></tr>\n";
	    
	    //ROW1 (E)
	   
	    //ROW2 (S)
	    oCell1 += "<tr>\n";
	    oCell1 += "<th>Package</th>\n";
	    oCell1 += "<td><input type=\"text\" name=\"pck_qty__" + leftSeq + "\" id=\"pck_qty__" + leftSeq + "\" style=\"width:65px;text-align:right\" dataformat=\"int\" class=\"input\" value=\""
	            + eval("formObj2.pck_qty__" + rightSeq).value + "\"><input type=\"text\" maxlength=\"2\" name=\"pck_tp_cd__"
	            + leftSeq + "\" style=\"width:27px;\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.pck_tp_cd__" + rightSeq).value + "\">"
	            + "<button type=\"button\" class=\"input_seach_btn\" onclick=\"javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__" + leftSeq + ".value, '" + leftSeq + "');\"></button></td>\n"
	    oCell1 += "<th>Weight</th>\n";
	    oCell1 += "<td><input type=\"text\" name=\"cntr_wgt__" + leftSeq + "\" id=\"cntr_wgt__" + leftSeq + "\" style=\"width:70px;text-align:right\" dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\"" + eval("formObj2.cntr_wgt__" + rightSeq + "").value + "\">";
	    oCell1 += "<select name=\"wgt_cd__" + leftSeq + "\" id=\"wgt_cd__" + leftSeq + "\" style=\"width:60px;\" class=\"input\">\n";
	    for ( var i=0; i < wgt_cdArr.length; i++) {
	        if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
	            continue;
	        if (wgt_cdArr[i] == eval("formObj2.wgt_cd__" + rightSeq).value) {
	            oCell1 += "<option value=\"" + wgt_cdArr[i] + "\" selected>" + wgt_nmArr[i] + "</option>\n";
	        } else {
	            oCell1 += "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i] + "</option>\n";
	        }
	    }
	    oCell1 += "</select></td>";
	    oCell1 += "<th>VGM</th>";
	    oCell1 += "<td><input type=\"text\" style=\"width:70px;text-align:right\" class=\"input2\" readOnly>";
	    oCell1 += "<input type=\"text\" style=\"width:44px;\" class=\"input2\" readOnly>\n";
	    oCell1 += "</td>";
	    oCell1 += "</tr>\n";
	    
	    //ROW2 (E)
	    
	    //ROW3 (S)
	    oCell1 += "<tr>";
	    oCell1 += "<th>Measure</th>\n";
	    oCell1 += "<td><input type=\"text\" name=\"meas_qty__" + leftSeq + "\" id=\"meas_qty__" + leftSeq + "\" style=\"width:65px;text-align:right\"dataformat=\"float\" pointcount=\"3\" class=\"input\" value=\"" + eval("formObj2.meas_qty__" + rightSeq).value + "\">";
	    oCell2 += "<select name=\"meas_cd__" + leftSeq + "\" id=\"meas_cd__" + leftSeq + "\" style=\"width:56px;\" class=\"input\">\n";
	    for ( var j=0; j < meas_cdArr.length; j++) {
	        if (meas_cdArr[j] == '' && meas_nmArr[j] == '')
	            continue;
	        if (meas_cdArr[j] == eval("formObj2.meas_cd__" + rightSeq).value) {
	            oCell2 += "<option value=\"" + meas_cdArr[j] + "\" selected>" + meas_nmArr[j] + "</option>\n";
	        } else {
	            oCell2 += "<option value=\"" + meas_cdArr[j] + "\">" + meas_nmArr[j] + "</option>\n";
	        }
	    }
	    oCell2 += "</select>\n";
	    oCell2 += "</td>\n";
	    oCell2 += "<th>RD Term</th>\n";
	    oCell2 += "<td>\n";
	    oCell2 += "<select name=\"rcv_term_cd__" + leftSeq + "\" style=\"width:70px;\" class=\"input\">\n";
	    for ( var j=0; j < rcv_term_cdArr.length; j++) {
	        if (rcv_term_cdArr[j] == '') continue;
	        if (rcv_term_cdArr[j] == ComGetObjValue(parent.frames["t1frame"].form.rcv_term_cd)) {
	            oCell2 += "<option value=\"" + rcv_term_cdArr[j] + "\" selected>" + rcv_term_cdArr[j] + "</option>\n";
	        } else {
	            oCell2 += "<option value=\"" + rcv_term_cdArr[j] + "\">" + rcv_term_cdArr[j] + "</option>\n";
	        }
	    }
	    oCell2 += "</select>";
	    oCell2 += "<select name=\"de_term_cd__" + leftSeq + "\" style=\"width:60px;\" class=\"input\">\n";
	    for ( var j=0; j < de_term_cdArr.length; j++) {
	        if (de_term_cdArr[j] == '') continue;
	        if (de_term_cdArr[j] == ComGetObjValue(parent.frames["t1frame"].form.de_term_cd)) {
	            oCell2 += "<option value=\"" + de_term_cdArr[j] + "\" selected>" + de_term_cdArr[j] + "</option>\n";
	        } else {
	            oCell2 += "<option value=\"" + de_term_cdArr[j] + "\">" + de_term_cdArr[j] + "</option>\n";
	        }
	    }
	    oCell2 += "</select>\n";
	    oCell2 += "</td>\n";
	    oCell2 += "<td colspan=\"2\">\n";
	    oCell2 += "<div class=\"specialCls\">\n";
	    oCell2 += "<button style=\"cursor: pointer;\" type=\"button\" class=\"btn_etc\" name=\"btn_delete\" onclick=\"btn_deleteTable('table_" + leftSeq + "','" + leftSeq + "')\">Delete</button>";
	    oCell2 += "</div></td></tr>\n";
	   
	    //ROW3 (S)
	    oCell2 += "<tr><td><input type=\"hidden\" name=\"po_no__" + leftSeq + "\" style=\"width:117px;\" maxlength=\"20\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.po_no__" + rightSeq).value + "\"></td></tr>\n";
	    oCell2 += "</table>\n";
	    dyntbl1.innerHTML=oCell1+oCell2;
	    doAddCntrCopy(leftSeq, rightSeq);
	}
	
	function updateCntr(leftSeq, rightSeq) {
		var formObj=document.form;
		var formObj2=document.form2;
		if ( document.form.fnl_cfm_flg.value != "Y" ) {
			if (eval("formObj2.cntr_no__" + rightSeq).value != null && eval("formObj2.cntr_no__" + rightSeq).value != '')
				eval("formObj.cntr_no__" + leftSeq).value=eval("formObj2.cntr_no__"+ rightSeq).value;
			if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
				eval("formObj.cntr_tpsz_cd__" + leftSeq).value=eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value;
			if (eval("formObj2.prt_flg__" + rightSeq).value != null && eval("formObj2.prt_flg__" + rightSeq).value != '')
				eval("formObj.cntr_prt_flg__" + leftSeq).value=eval("formObj2.prt_flg__"+ rightSeq).value;
			if(eval("formObj.cntr_prt_flg__" + leftSeq).value=="Y"){
				eval("formObj.cntr_prt_flg__" + leftSeq).checked=true;
			} else {
				eval("formObj.cntr_prt_flg__" + leftSeq).checked=false;
			}
		}
		if (eval("formObj2.pck_qty__" + rightSeq).value != null && eval("formObj2.pck_qty__" + rightSeq).value != '')
			eval("formObj.pck_qty__" + leftSeq).value=eval("formObj2.pck_qty__"+ rightSeq).value;
		if (eval("formObj2.pck_tp_cd__" + rightSeq).value != null && eval("formObj2.pck_tp_cd__" + rightSeq).value != '')
			eval("formObj.pck_tp_cd__" + leftSeq).value=eval("formObj2.pck_tp_cd__"+ rightSeq).value;
		if (eval("formObj2.cntr_wgt__" + rightSeq).value != null && eval("formObj2.cntr_wgt__" + rightSeq).value != '')
			eval("formObj.cntr_wgt__" + leftSeq).value=eval("formObj2.cntr_wgt__"+ rightSeq).value;
		if (eval("formObj2.meas_qty__" + rightSeq).value != null && eval("formObj2.meas_qty__" + rightSeq).value != '')
			eval("formObj.meas_qty__" + leftSeq).value=eval("formObj2.meas_qty__"+ rightSeq).value;
		if (eval("formObj2.po_no__" + rightSeq).value != null && eval("formObj2.po_no__" + rightSeq).value != '')
			eval("formObj.po_no__" + leftSeq).value=eval("formObj2.po_no__"+ rightSeq).value;
		var sealNoObj=document.getElementById(eval("formObj.cntr_seal_no__"+ leftSeq).name);
		for ( var i=0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
			if (eval("formObj2.cntr_seal_no__" + rightSeq).value != null && eval("formObj2.cntr_seal_no__" + rightSeq).value != '') {
				sealNoObj.length=0;	
			}
		}
		if ( sealNoObj.length == 0 ) {
			for ( var i=0; i < eval("formObj2.cntr_seal_no__" + rightSeq).length; i++) {
				if (eval("formObj2.cntr_seal_no__" + rightSeq).value != null && eval("formObj2.cntr_seal_no__" + rightSeq).value != '') {
					var opt=document.createElement("option");
					opt.value=eval("formObj2.cntr_seal_no__" + rightSeq).options[i].value;
					opt.text=eval("formObj2.cntr_seal_no__" + rightSeq).options[i].text;
					sealNoObj.add(opt);
				}
			}
		}
		if (eval("formObj2.cntr_seal_no__" + rightSeq).value != null && eval("formObj2.cntr_seal_no__" + rightSeq).value != '') {
			for ( var j=0; j < eval("formObj.cntr_seal_no__" + leftSeq).length; j++) {
				if (eval("formObj.cntr_seal_no__" + leftSeq)[j].value == eval("formObj2.cntr_seal_no__" + rightSeq).value) {
					eval("formObj.cntr_seal_no__" + leftSeq).selectedIndex=j;
					break;
				}
			}
		}
		if (eval("formObj2.wgt_cd__" + rightSeq).value != null && eval("formObj2.wgt_cd__" + rightSeq).value != '') {
			for ( var j=0; j < eval("formObj.wgt_cd__" + leftSeq).length; j++) {
				if (eval("formObj.wgt_cd__" + leftSeq)[j].value == eval("formObj2.wgt_cd__" + rightSeq).value) {
					eval("formObj.wgt_cd__" + leftSeq).selectedIndex=j;
					break;
				}
			}
		}
		if (eval("formObj2.meas_cd__" + rightSeq).value != null && eval("formObj2.meas_cd__" + rightSeq).value != '') {
			for ( var k=0; k < eval("formObj.meas_cd__" + leftSeq).length; k++) {
				if (eval("formObj.meas_cd__" + leftSeq)[k].value == eval("formObj2.meas_cd__" + rightSeq).value) {
					eval("formObj.meas_cd__" + leftSeq).selectedIndex=k;
					break;
				}
			}
		}
		try{
			$("#seal_no_text_" + leftSeq).val( eval("formObj2.cntr_seal_no__" + rightSeq).value);
		}catch (e) {
		}
	}
	
	function findSameCntr(formObj, cntrNo){
		var formObj1=document.form;
		var formObj2=document.form2;
		var obj=null;
		for ( var j=0; j < formObj.elements.length; j++) {
			if (formObj.elements[j].type == "text" && (formObj.elements[j].name).indexOf("__") > 0) {
				obj=(formObj.elements[j].name).split("__");
				if (obj[0] == "cntr_no") {
					if (cntrNo == eval(((formObj == formObj1)?"document.form.cntr_no__":"document.form2.cntr_no__") + obj[1]).value) {
						break;
					}
				}
			}
		}
		if(obj!=null&&obj[1]>0){
			return obj[1];
		} else {
			return 0;
		}
	}
	
	function btn_deleteTable(tableId, tableSeq) {
		var formObj = document.form;
		var seq = 1;
		doDeleteCntrAppend(tableSeq);
		
		
		$( "#" + tableId ).remove();
//		var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
//		var rowCount = tbody.rows.length;
//		while (rowCount > 0) {
//			tbody.deleteRow(rowCount - 1);
//			rowCount--;
//		}

		for ( var i = 0; i < formObj.elements.length; i++) {
			var objNm = (formObj.elements[i].name).split("__");
			if (objNm[0] == "cntr_seq") {
				formObj.elements[i].value = seq++;
			}
		}
	}
	
	function deleteAllTable() {
		var formObj=document.form;
		for ( var i=0; i < formObj.elements.length; i++) {
			if ((formObj.elements[i].name).indexOf("table") == 0) {
				btn_deleteTable(formObj.elements[i].value);
			}
		}
	}
	
	function changeCntrTpszCd(obj) {	
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var srcName=obj.name;
	    var seq=(obj.name).split("__")[1];    
		var cntr_no=obj.value;
		if(cntr_no == "") return false;
		if(!isNaN(cntr_no) && cntr_no.length==7){
			if(confirm(ComGetMsg("BKG00172"))){
				cntr_no="HJCU" + cntr_no;
				obj.value=cntr_no;
				sheetObj.SetCellValue(seq, "cntr_no",cntr_no,0);
			}
		}
		for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++){
			var tmpNo=sheetObj.GetCellValue(ir, "cntr_no");
			var tmpDelSt=sheetObj.GetRowStatus(ir);
			if(ir==seq) continue;
			if(cntr_no == tmpNo && tmpDelSt != "D"){
				ComShowMessage(ComGetMsg("BKG00965", cntr_no));
				obj.value="";
				sheetObj.SetCellValue(seq, "cntr_no","",0);
				ComSetFocus(srcName);
				return false;
			}
		}
		formObj.f_cmd.value=SEARCH01;
		var param="f_cmd=" + formObj.f_cmd.value + "&cntr_no=" + cntr_no;	
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0229_03GS.do", param);
		var cntrTpszCd=ComGetEtcData(sXml, "cntr_tpsz_cd");
		if (cntrTpszCd == "null" || cntrTpszCd == "") {
			return;
		}
		var cntrTpszCdObj=eval("formObj.cntr_tpsz_cd__" + seq);
		cntrTpszCdObj.value=cntrTpszCd;
		var cntr_no=ComGetEtcData(sXml, "cntr_no");
		var cntrNo=eval("formObj.cntr_no__" + seq);
		cntrNo.value=cntr_no;
	}
	function form1_change(){
		var formObj=document.form;
	    var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName) || srcName == '') return false;
		var srcValue=event.srcElement.getAttribute("value");
		var sheetObj=sheetObjects[0];
		var obj=(srcName).split("__");
		var col_save_name=obj[0];
	    var row=obj[1];
	    var bkg_no=formObj.bkg_no.value;
	    var cntr_no=sheetObj.GetCellValue(row, "cntr_no");
	    switch(col_save_name){	
			case "cntr_no":
				if(cntr_no == '') {
					return false;
				}			
				break;
			case "meas_qty":/* Measure */
				if(sheetObj.GetCellValue(row, "meas_qty") >= 1000){
					ComShowMessage(ComGetMsg("BKG00174"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}
				document.getElementById(srcName).value=makeComma(document.getElementById(srcName).value.replace(/,/g, ""));
				break;
			case "cntr_wgt":/* Weight */
				document.getElementById(srcName).value=makeComma(document.getElementById(srcName).value.replace(/,/g, ""));
				break;
			case "pck_qty":/* pck_qty */
				document.getElementById(srcName).value=ComAddComma(document.getElementById(srcName).value, "#,##0");
				break;
			case "vgm_wgt":/* Weight */
				document.getElementById(srcName).value=makeComma(document.getElementById(srcName).value.replace(/,/g, ""));
	    }
		isCopy="false";
	    compareCntr(row, findSameCntr(document.form2, cntr_no));
	}

	function form1_blur() {
		ComChkObjValid(event.srcElement);
	}
	function comBkgCallPop0696_position(funcNm, val, pos) {
	 	pkgPosition=pos;
	 	comBkgCallModal0696(funcNm, val);
	}
	function setCallBack0696(aryPopupData) {
	 	var formObj=document.form;
	 	eval("formObj.pck_tp_cd__" + pkgPosition).value=aryPopupData.cd;
	}
	function makeComma2(obj) {
		var val=makeComma(obj.value);
		obj.value=val;
	}
	function makeComma(srcValue) {
		var arrVal=srcValue.split(".");
		if (arrVal.length > 1) {
			srcValue=makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
		} else {
			srcValue=makeCommaRun(arrVal[0]) + ".000";
		}
		return srcValue;
	}
	function makeCommaRun(srcValue) {
		srcValue=srcValue.replace(/\D/g, "");
		if (srcValue.length > 9) {
			srcValue=srcValue.substring(0, 9);
		}
		l=srcValue.length - 3;
		while (l > 0) {
			srcValue=srcValue.substr(0, l) + "," + srcValue.substr(l);
			l -= 3;
		}
		return srcValue;
	}
	
	function sealNoCheck(object, index){
		var sealNo = eval("document.form.cntr_seal_no__" + index);
		var selectNum = $("#cntr_seal_no__" + index + " option").index($("#cntr_seal_no__" + index + " option:selected"));
		if(object.value !=  $("#cntr_seal_no__" + index).val()){
			$("#cntr_seal_no__" + index + " option:eq(" + selectNum + ")").replaceWith("<option value='" + object.value + "'>" + object.value + "</option>");
		}
		$("#cntr_seal_no__" + index + " option:eq(" + selectNum + ")").attr("selected", "selected");
	}
	
	function sealNoChange(object, index){
		$("#seal_no_text_" + index).val(object.value);
	}