/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName:  : ESM_BKG_0568.js
*@FileTitle  : C/A Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
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
 * @class ESM_BKG_0568 : EBM_BKG_0568 - task script definition for screen
 */
	
	// public variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
function processButtonClick() {
	/**
	 * *** If sheets are more than 2 in one tab, use additional sheet variables
	 * ****
	 */
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, INIT);
			break;
		case "btn_new":
			ComResetAll();
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_excel":
			if(sheetObject.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				//sheetObject.Down2Excel({ HiddenColumn:-1});
				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
			}
			
			break;
		case "btn_CheckAll":
			checkAll("1");
			break;
		case "btn_UncheckAll":
			checkAll("0");
			break;
		case "btn_print":
			if (!validateForm(sheetObjects[0], document.form, IBSAVE))
				return;
			goPrint("1");
			break;
		case "btn_BLInquiry":
			pageLink("1");
			break;
		case "btn_CntrInquiry":
			pageLink("2");
			break;
		case "btn_UncheckAll2":
			alert(srcName);
			break;
		case "btn_DownExcel2":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				//sheetObject1.Down2Excel({ HiddenColumn:-1});
				sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
			}
			
			break;
		case "btn_PrintPreview":
			alert(srcName);
			break;
		case "btn_print2":
			goPrint("2"); // 2010.04.22수정 >> 2010.04.23수정 원복
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing
	 * batch processing with other items defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		document.form.from_date.value=getCalculatedDate(0, 0, -7, "-");
		document.form.from_time.value="00:00";
		document.form.to_date.value=getCalculatedDate(0, 0, 0, "-");
		document.form.to_time.value="23:59";
	}
	/**
	 * process when you enter retrieve condition
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	/**
	 * load HTML Control event on the page <br>
	 * {@link #loadPage}call the function and init IBSheet Object <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects
	 */
	function initControl() {
		var formObject=document.form;
		// Axon Event process1 Event catch(Develoer can change)
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // -
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); 
//		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - in
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
//		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		
	}
	/**
	 * control keyboard input onkeypress event of HTML Control
	 */
//	function obj_keypress() {
//		switch (event.srcElement.dataformat) {
//		case "int":
//			// only num
//			ComKeyOnlyNumber(event.srcElement);
//			break;
//		case "float":
//			// num+"."
//			ComKeyOnlyNumber(event.srcElement, ".");
//			break;
//		case "eng":
//			// eng -> ComKeyOnlyAlphabet('num');
//			ComKeyOnlyAlphabet();
//			break;
//		case "engdn":
//			// lower eng -> ComKeyOnlyAlphabet('lowernum');
//			ComKeyOnlyAlphabet('lower');
//			break;
//		case "engup":
//			// English to enter uppercase letters, uppercase letters+number ->
//			// ComKeyOnlyAlphabet('uppernum');
//			ComKeyOnlyAlphabet('upper');
//			break;
//		case "engupnum":
//			// English to enter uppercase letters, uppercase letters+number ->
//			// ComKeyOnlyAlphabet('uppernum');
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		default:
//			// enter just number
//			ComKeyOnlyNumber(event.srcElement);
//		}
//	}
	/**
	 * setting sheet initial values and header
	 * 
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
	      if (location.hostname != "")
	      var HeadTitle1="CHK|Seq.|B/L No.|Filer|BKG No.|C/A No.|C/A Date|C/A OFC|Reason|Reason|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|KIND|Remark(s)";
	      var HeadTitle2="CHK|Seq.|B/L No.|Filer|BKG No.|C/A No.|C/A Date|C/A OFC|Code|Name|A|B|C|D|E|F|G|H|I|J|K|Remark(s)";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (28, 0, 0, false);
	
	      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"CheckBox",Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"NV",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"corr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"corr_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"CAOFC",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Reason1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"Reason2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_A",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_B",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_C",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_D",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_E",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_F",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_G",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_H",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_I",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_J",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"KIND_K",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"bkg_corr_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"vvd" },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"chk_tp" },
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(200);
	      
	      SetMergeCell(0, 0, 2, 1);
	      SetMergeCell(0, 1, 2, 1);
	      SetMergeCell(0, 2, 2, 1);
	      SetMergeCell(0, 3, 2, 1);
	      SetMergeCell(0, 4, 2, 1);
	      SetMergeCell(0, 5, 2, 1);
	      SetMergeCell(0, 6, 2, 1);
	      SetMergeCell(0, 7, 2, 1);
	      SetMergeCell(0, 21, 2, 1);
	      SetRangeBackColor(1, 8, 1, 20,"#777777");
	      SetEditable(1);
	      }
			break;
		case "sheet2":
		    with(sheetObj){
	       
	      if (location.hostname != "")
	      (4, 0, 0, true);
	      var HeadTitle1="|Correction Items|New|Old";
	
	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0, Width:320,  Align:"Center",  ColMerge:1,   SaveName:"his_cate_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:330,  Align:"Center",  ColMerge:1,   SaveName:"crnt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:330,  Align:"Center",  ColMerge:1,   SaveName:"pre_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetSheetHeight(180);
	      SetEditable(1);
	      ComResizeSheet(sheetObj);
	            }
			break;
		}
	}
// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case INIT: // retrieve
			if (!validateForm(sheetObj, formObj, sAction))
				return;
			formObj.from_dt.value=formObj.from_date.value + " " + formObj.from_time.value;
			formObj.to_dt.value=formObj.to_date.value + " " + formObj.to_time.value;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0568GS.do",FormQueryString(formObj));
			if (sheetObj.SearchRows()> 0) {
				formObj.bl_no2.value=sheetObj.GetCellValue(3, "bl_no");
				formObj.bkg_no.value=sheetObj.GetCellValue(3, "bkg_no");
				formObj.corr_no.value=sheetObj.GetCellValue(3, "corr_no");
				formObj.vvd2.value=sheetObj.GetCellValue(3, "vvd");
				formObj.pol.value=sheetObj.GetCellValue(3, "pol_cd");
				formObj.pod.value=sheetObj.GetCellValue(3, "pod_cd");
				doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
			}
			break;
		case IBSAVE: // Save
			var chkFlg=false;
			var SaveStr=sheetObj.GetSaveString(false);
			if (SaveStr != "")
				chkFlg=true;
			if (chkFlg) {
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
				var searchXml=sheetObj.GetSaveData("ESM_BKG_0568GS.do", sParam);
				if (ComGetEtcData(searchXml, "success_yn") == "Y") {
					ComShowCodeMessage('COM130102', 'Data');
				}
			}
			var chkFlg2=false;
			if (formObj.cnt_cd.value == 'CA' || formObj.cnt_cd.value == 'US') {
				for ( var i=2; i <= sheetObj.LastRow(); i++) {
					if (sheetObj.GetCellValue(i, "Chk") == '1') {
						chkFlg2=true;
						sheetObj.SetRowStatus(i,"I");
					}
				}
				if (chkFlg2) {
					if (ComShowCodeConfirm("BKG08100")) {// Do you want to trans
															// to Customs
						doActionIBSheet(sheetObjects[0], formObj, COMMAND02);
					}
				}
			}
			if (!chkFlg && !chkFlg2) {
				ComShowCodeMessage("BKG00743");// There is no updated data to save.
			}
			break;
		case COMMAND01: // retrieve
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			sheetObj.DoSearch("ESM_BKG_0568GS.do",FormQueryString(formObj) );
			break;
		case COMMAND02: //
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=COMMAND02;
			var sParam=ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
			var searchXml=sheetObj.GetSaveData("ESM_BKG_0568GS.do", sParam);
			if (ComGetEtcData(searchXml, "success_yn") == "Y") {
				ComShowCodeMessage('COM130102', 'trans to Customs');
				doActionIBSheet(sheetObjects[0], document.form, INIT);
			} else {
				ComShowCodeMessage("BKG00571");// Please clear error data and try
												// again.
			}
			break;
		}
		ComOpenWait(false);
	}
/**
 * handling process for input validation
 */
	function validateForm(sheetObj, formObj, sAction) {
		if (formObj.pk_tp[0].checked == true) {
			if (formObj.from_date.value == '' || formObj.to_date.value == '' || formObj.from_time.value == ''
					|| formObj.to_time.value == '') {
				ComShowCodeMessage("BKG00499");// Period are mandatory items.
				formObj.from_date.focus();
				return false;
			}
			if ((formObj.cnt_cd.value == "US" || formObj.cnt_cd.value == "CA") && formObj.pod_cd.value == '') {
				ComShowCodeMessage("BKG00137");// POL/POD is not available
				formObj.pod_cd.focus();
				return false;
			}
		}
		if (formObj.pk_tp[1].checked == true && (formObj.vvd.value == '' || formObj.pod_cd.value == '')) {
			if (formObj.vvd.value == '') {
				ComShowCodeMessage("BKG00007");// VVD is not available !
				formObj.vvd.focus();
				return false;
			}
			if ((formObj.cnt_cd.value == "US" || formObj.cnt_cd.value == "CA") && formObj.pod_cd.value == '') {
				ComShowCodeMessage("BKG00137");// POL/POD is not available
				formObj.pod_cd.focus();
				return false;
			}
		}
		if (formObj.pk_tp[2].checked == true && formObj.bl_no.value == '') {
			ComShowCodeMessage("BKG00609");// Please, Check BL No !
			formObj.bl_no.focus();
			return false;
		}
		if (formObj.from_dt.value == '' && formObj.to_dt.value != '') {
			ComShowCodeMessage("BKG00499");// Period are mandatory items.
			formObj.from_dt.focus();
			return false;
		}
		if (formObj.from_dt.value != '' && formObj.to_dt.value == '') {
			ComShowCodeMessage("BKG00499");// Period are mandatory items.
			formObj.to_dt.focus();
			return false;
		}
		if (formObj.pk_tp[2].checked == false) {
			if (formObj.cnt_cd.value == 'KR' && formObj.pod_cd.value == '') {
				ComShowCodeMessage("BKG00210");// POL/POD is not available
				formObj.pod_cd.focus();
				return false;
			}
		}
		return true;
	}
	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
	formObj.bl_no2.value=sheetObj.GetCellValue(Row, "bl_no");
	formObj.bkg_no.value=sheetObj.GetCellValue(Row, "bkg_no");
	formObj.corr_no.value=sheetObj.GetCellValue(Row, "corr_no");
	formObj.vvd2.value=sheetObj.GetCellValue(Row, "vvd");
	formObj.pol.value=sheetObj.GetCellValue(Row, "pol_cd");
	formObj.pod.value=sheetObj.GetCellValue(Row, "pod_cd");
		doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
	}
	/*
	 * function sheet2_OnSearchEnd(sheetObj, ErrMsg) { with(sheetObj) { for(var i=1;
	 * i <= LastRow(); i ++) { if ("Remark" == GetCellValue(i, "Items"))
	 * SetCellEditable(i, "New",1); } } } /** Calculate Date function
	 */
	function getCalculatedDate(iYear, iMonth, iDay, seperator) {
		// get Date object
		var gdCurDate=new Date();
		// Calculate Date
		gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
		gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
		gdCurDate.setDate(gdCurDate.getDate() + iDay);
		// get variables
		var giYear=gdCurDate.getFullYear();
		var giMonth=gdCurDate.getMonth() + 1;
		var giDay=gdCurDate.getDate();
		// Month, and day two-digit adjusted with precision.
		giMonth="0" + giMonth;
		giMonth=giMonth.substring(giMonth.length - 2, giMonth.length);
		giDay="0" + giDay;
		giDay=giDay.substring(giDay.length - 2, giDay.length);
		return giYear + seperator + giMonth + seperator + giDay;
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			var redColor="#FF0000";
			var blueColor="#0000FF";
			for ( var i=2; i <= LastRow(); i++) {
				if ("Y" == GetCellValue(i, "KIND_A")) {
				 SetCellFontColor(i, "KIND_A",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_B")) {
				 SetCellFontColor(i, "KIND_B",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_C")) {
				 SetCellFontColor(i, "KIND_C",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_D")) {
				 SetCellFontColor(i, "KIND_D",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_E")) {
				 SetCellFontColor(i, "KIND_E",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_F")) {
				 SetCellFontColor(i, "KIND_F",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_G")) {
				 SetCellFontColor(i, "KIND_G",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_H")) {
				SetCellFontColor(i, "KIND_H",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_I")) {
				SetCellFontColor(i, "KIND_I",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_J")) {
				SetCellFontColor(i, "KIND_J",redColor);
							}
				if ("Y" == GetCellValue(i, "KIND_K")) {
				SetCellFontColor(i, "KIND_K",redColor);
				}
				
				if(GetCellValue(i, "Seq").search("VVD") > 0){
		      		var info = {Type: "Text"};
		      		InitCellProperty( i, "Chk", info);
		      		SetCellValue(i , "Chk" ,GetCellValue( i,"Seq"));
		      		SetMergeCell(i, 0, 1, 28);
				} 
			}
		}
	}
	/**
	 * CHECK BOX >>> CHECKALL,UNCHECKALL
	 */
	function checkAll(value) {
		var sheetObj=sheetObjects[0];
		for ( var i=1; i <= sheetObj.LastRow(); i++) {
	if (sheetObj.GetCellValue(i, "chk_tp") == "C") {
				sheetObj.SetCellValue(i, 0,value,0);
			}
		}
	}
	/**
	 * Link setting according to Login Office
	 */
	function pageLink(tp) {
		var formObj=document.form;
		if (formObj.bkg_no.value == '') {
			ComShowCodeMessage("BKG00280");// Duplicate Bkg No! Please try again.
			return;
		}
		var cntCd=formObj.cnt_cd.value;
		var param='';
		if (cntCd == 'KR') {
			param='?bl_no=' + formObj.bl_no2.value + '&vvd=' + formObj.vvd2.value + "&pol_cd=" + formObj.pol.value + "&pod_cd="
					+ formObj.pod.value + "&port_cd=" + formObj.pod_cd.value + "&io_bnd_cd=I&mode=EDIT&in_type=&cstms_decl_tp_cd=I";
		} else {
			param='?bkg_no=' + formObj.bkg_no.value + '&bl_no=' + formObj.bl_no2.value + '&corr_no=' + formObj.corr_no.value;
		}
		if (tp == '1') {// B/L Inquiry
			if (cntCd == 'US') {
				ComOpenWindow("/opuscntr/ESM_BKG_0034_POP.do" + param + "&tab=1&pgmNo=ESM_BKG_0034-01", "PopupEsmBkg0034",
						"width=1250, height=700, scrollbars=yes", false);
				
//				ComOpenWindowCenter("ESM_BKG_0034_POP.do?pgmNo=ESM_BKG_0034-01" + "&" + param, "ESM_BKG_0034", 1250, 700, false);
				
			} else if (cntCd == 'CA') {
				ComOpenWindow("/opuscntr/ESM_BKG_0029_POP.do" + param + "&tab=1&pgmNo=ESM_BKG_0029", "PopupEsmBkg0029",
						"width=1250, height=700, scrollbars=yes", false);
			} else {
				ComOpenWindow("/opuscntr/ESM_BKG_0570.do" + param + "&tab=1&pgmNo=ESM_BKG_0570", "PopupEsmBkg0570",
						"width=1250, height=700, scrollbars=yes", false);
			}
		} else {// CNTR Inquiry
			if (cntCd == 'US') {
				// ComOpenWindow("/opuscntr/ESM_BKG_0518.do" + param +
				// "&tab=2&pgmNo=ESM_BKG_0518", "PopupEsmBkg0518", "width=1100,
				// height=650, scrollbars=yes", false);
				ComOpenWindow("/opuscntr/ESM_BKG_0037.do" + param + "&tab=2&pgmNo=ESM_BKG_0037", "PopupEsmBkg0037",
						"width=620, height=400, scrollbars=no", false);
			} else if (cntCd == 'CA') {
				ComOpenWindow("/opuscntr/ESM_BKG_0037.do" + param + "&tab=2&pgmNo=ESM_BKG_0037", "PopupEsmBkg0037",
						"width=1100, height=650, scrollbars=yes", false);
			} else {
				ComOpenWindow("/opuscntr/ESM_BKG_0570.do" + param + "&tab=3&pgmNo=ESM_BKG_0570", "PopupEsmBkg0570",
						"width=1100, height=650, scrollbars=yes", false);
			}
		}
	}
	/**
	 * type setting
	 */
	function changeTP(tp) {
		var formObj=document.form;
		if (tp == '0') {
			formObj.pk_tp[0].checked=true;
		} else if (tp == '1') {
			formObj.pk_tp[1].checked=true;
		} else if (tp == '2') {
			formObj.pk_tp[2].checked=true;
		}
	}
	/**
	 * Remark MemoPad
	 */
	function sheet1_OnClick(sheetObj, row, col, value) {
		// showing MemoPad
	if (sheetObj.ColSaveName(col) == "bkg_corr_rmk" && sheetObj.GetCellValue(row, "chk_tp") == "C") {
			ComShowMemoPad(sheetObj, null, null, null, null, null, 1000);
		}
	}
	/**
	 * RD(Report Designer) Print
	 */
	function goPrint(tp) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if (tp == "1") {
			var ca_from_dt="";
			var ca_to_dt="";
			var vvd="";
			var pod=formObj.pod_cd.value;
			var pod_tp="";
			var del="";
			var bl_no="";
			var where="";
			var cnt_cd=formObj.cnt_cd.value;
			if (formObj.pk_tp[0].checked == true) {
				ca_from_dt=formObj.from_date.value + " " + formObj.from_time.value;
				ca_to_dt=formObj.to_date.value + " " + formObj.to_time.value;
			} else if (formObj.pk_tp[1].checked == true) {
				vvd=formObj.vvd.value;
				del=formObj.del_cd.value;
			} else if (formObj.pk_tp[2].checked == true) {
				bl_no=formObj.bl_no.value;
			}
			pod_tp="BKG";
			var rdPath="apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_5031.mrd";
			formObj.com_mrdTitle.value="C/A Report(I/B)";
			formObj.com_mrdBodyTitle.value="C/A Report(I/B)";
			formObj.com_mrdPath.value=rdPath;
			formObj.com_mrdArguments.value="/rv CA_FROM_DT[" + ca_from_dt + "] CA_TO_DT[" + ca_to_dt + "] VVD[" + vvd + "] POD_CD["
					+ pod + "] POD_TP[" + pod_tp + "] DEL_CD[" + del + "] BL_NO[" + bl_no + "] CNT_CD[" + cnt_cd + "] PK_TP["
					+ ComGetObjValue(formObj.pk_tp) + "]";
		} else {
			var bkg_no="";
			var ca_no="";
			if(sheetObj.RowCount()>0)
				{
						if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no") == "" || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no").indexOf("VVD") > -1) 
						{
							bkg_no=sheetObj.GetCellValue(3, "bkg_no");
							ca_no=sheetObj.GetCellValue(3, "corr_no");
							doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
						} 
						else 
						  {
							bkg_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no")
							ca_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "corr_no");
						}
				}
			else
				{
					bkg_no=sheetObj.GetCellValue(0, "bkg_no")
					ca_no=sheetObj.GetCellValue(0, "corr_no");
					doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
				
				}
			var rdPath="apps/opus/esm/bkg/bookingcorrection/bdrcorrection/report/ESM_BKG_0182.mrd";
			formObj.com_mrdTitle.value="C/A Report(I/B)";
			formObj.com_mrdBodyTitle.value="C/A Report(I/B)";
			formObj.com_mrdPath.value=rdPath;
			formObj.com_mrdArguments.value="/rp ['" + bkg_no + "'] ['" + ca_no + "'] /riprnmargin";
		}
		ComOpenRDPopup();
	}
