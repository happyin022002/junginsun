/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0367_01.js
*@FileTitle  : P/O & Other No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var log_script=false;
	// checking input condition about PO & Other No.
	var po_cust_flag='N';
	var po_ref_flag='N';
	var po_ref_dtl_flag='N';
	var isInquiry=false;

	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj
	 * @return 
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
		if(!opener) opener=window.dialogArguments;
		if(!opener) opener=parent;
		isInquiry=opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);
		if (document.form.bkg_no.value == '' && document.form.xter_rqst_no.value == '') {
			ComShowCodeMessage("BKG00463");
			ComClosePopup(); 
		}
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1)
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
		initControl();
		initCombo();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * initializing initControl 
	 */
	function initControl() {
		DATE_SEPARATOR="-";
		var formObj=document.form;
		if ('S' == ComGetObjValue(formObj.popuptpcd) || 'E' == ComGetObjValue(formObj.popuptpcd) || isInquiry) {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn1_Row_Add");
			ComBtnDisable("btn1_Row_Delete");
			ComBtnDisable("btn2_Row_Add");
			ComBtnDisable("btn2_Row_Delete");
			ComBtnDisable("btn3_Row_Add");
			ComBtnDisable("btn3_Row_Delete");
			if (isInquiry) {
				ComBtnDisable("btn2_Copy_from");
			}
		}
	}
	/**
	 * initCombo event handling<br>
	 * @param 
	 * @exception EventException
	 */
	function initCombo(){
		var formObj=document.form;
		ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
		try {
			var param=FormQueryString(formObj);
			param=param + "&cm_code=CD00775";
	 		var sXml=sheetObjects[1].GetSearchData("ESM_Booking_UtilGS.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml[0].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
				sheetObjects[1].SetColProperty("sheet2_wgt_ut_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			}
			var param=FormQueryString(formObj);
			param=param + "&cm_code=CD01116";
	 		var sXml=sheetObjects[1].GetSearchData("ESM_Booking_UtilGS.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml[0].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
				sheetObjects[1].SetColProperty("sheet2_meas_ut_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			}
			
			ComSetObjValue(formObj.f_cmd, SEARCH02);
			var param=FormQueryString(formObj);
	 		var sXml=sheetObjects[3].GetSearchData("ESM_BKG_0367_01GS.do", param);
			var arrCombo=ComXml2ComboString(sXml, "val", "name");
			if(arrCombo != undefined){
				ComSetObjValue(formObj.cb_cntr_no, arrCombo[0]);
				sheetObjects[3].SetColProperty("sheet4_cntr_no", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			}
			
		} catch (ex) {
			bkg_error_alert('', ex);
			return false;
		}
		return true;
	}
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1": //t1sheet1 init : PO/No by CNTR / Item : Container PO 
		    with(sheetObj){
		      var HeadTitle1="|Container No.|P/O No. (by CNTR)";
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [
		                 {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		                 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"c_cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt", KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no_split" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_mf_wgt" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_qty" } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetCountPosition(0);
		      SetSheetHeight(170);
			}
			break;
		case "sheet2": // PO/No by CNTR / Item : PO by Item
			  with(sheetObj){
			      var HeadTitle1=" |P/O No.(by Item)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";
			      var prefix="sheet2_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
			             {Type:"Text",      Hidden:0,  Width:99,   Align:"Left",    ColMerge:1,   SaveName:prefix+"po_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:prefix+"itm_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"itm_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:prefix+"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
			             {Type:"PopupEdit", Hidden:0,  Width:25,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pck_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Combo",     Hidden:0,  Width:35,   Align:"Left",    ColMerge:0,   SaveName:prefix+"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:prefix+"meas_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
			             {Type:"Combo",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"meas_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no_split" },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetDataAutoTrim(1);
			      SetColProperty(0,prefix + "pck_tp_cd" , {AcceptKeys:"E",InputCaseSensitive:1});
			      SetColProperty(0,prefix + "itm_no" , {AcceptKeys:"N"});
			      SetDataLinkMouse(prefix + "pck_tp_cd",1);
			      SetDataLinkMouse(prefix + "wgt_ut_cd",1);
			      SetDataLinkMouse(prefix + "meas_ut_cd",1);
			      SetCountPosition(0);
			      SetSheetHeight(170);
	    	}
			break;
		case "sheet3": //t1sheet2 init : Ship ID
		    with(sheetObj){
			      var HeadTitle1="|Ship ID (Delivery No.)|Part No.|Copy to Description";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet3_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:1,   SaveName:prefix+"de_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"prt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no_split" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no" } ];
			     InitColumns(cols);
			     SetEditable(1);
			     SetCountPosition(0);
		         SetSheetHeight(170);
			}
	
			break;
		case "sheet4": //t1sheet1 init : MRN. UCR No
		    with(sheetObj){
			      var HeadTitle1="||SEQ|REF NO|Container No|MRN No./UCR No.|MRN No./UCR No.";
			      var prefix="sheet4_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 , ComboMaxHeight:200} );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq"},
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_no"},
			             {Type:"ComboEdit", Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no"},
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_ref_tp_cd" },
			             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_flg" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"old_bkg_ref_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"old_cust_ref_no_ctnt" }];
			      
			     InitColumns(cols);
			     SetEditable(1);
			     SetColProperty(prefix+"bkg_ref_tp_cd", {ComboText:"|MRN|UCR", ComboCode:"|CMRN|CUCR"} );
			     SetCountPosition(0);
		         SetSheetHeight(170);


	        }
			break;
		case "sheet5": //t1sheet1 init
		    with(sheetObj){
			      var HeadTitle1="||||";
			      var prefix="sheet5_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no_split" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no_tp" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_ref_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetCountPosition(0);
			      SetVisible(0);
	        }
			break;
		case "sheet6": //t1sheet6 init - sheet4 hidden
		    with(sheetObj){
				  																																																																																																																																																																																																																																			
				var HeadTitle1="||SEQ|REF NO|Container No|MRN No./UCR No.|MRN No./UCR No.";
				var prefix="sheet6_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				{Type:"Text", 	   Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_no"},
				{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"cntr_no" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"bkg_ref_tp_cd" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_ref_no_ctnt" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_flg" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ref_seq" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"old_bkg_ref_tp_cd" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"old_cust_ref_no_ctnt" }];
				  
				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(0);
				SetSheetHeight(170);
				SetVisible(0);
			     
	        }
			break;
		}
		
	}
	/**
	 * column related sheet onClick action event handling
	 */
	function sheet1_OnClick(sheetObject, Row, Col, Value) {
		var formObj=document.form;
		var sXml=null;
		var prefix=sheetObject.id + "_";
		try {
			var target_value=sheetObject.GetCellText(Row, prefix + "c_cntr_no");
			formObj.cntr_no.value=target_value;
			formObj.pck_qty.value=sheetObject.GetCellText(Row, prefix + "pck_qty").comma();
			formObj.cntr_mf_wgt.value=sheetObject.GetCellText(Row, prefix + "cntr_mf_wgt").comma();
			formObj.meas_qty.value=sheetObject.GetCellText(Row, prefix + "meas_qty").comma();
			if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
				filteredDataSum(sheetObjects[1]);
			}
	
		} catch (ex) {
			bkg_error_alert('', ex);
			return false;
		}
	}
	/**
	 * setting Sheet2 OnKeyUp attribute
	 * 
	 *function sheet2_OnKeyUp(Row, Col, KeyCode, Shift){
	 *	filteredDataSum(sheetObjects[1]);
	 *}
	 */
	/**
	 * event in case of changing data of cell<br>
	 * 
	 * @param sheetObject
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet2_OnChange(sheetObject, Row, Col, Value) {
		filteredDataSum(sheetObjects[1]);
	}
	/**
	 * Sheet관련 화면 구성 hidden 속성설정하기 : container번호로 필터링하기  
	 * 
	 */
	var item_cnt=0;
	function filteredData(sheetObj, tmp_name, tmp_value) {
		item_cnt=0;
		var cnt=sheetObj.LastRow();
		for (ix=1; ix <= cnt; ix++) {
			if (sheetObj.GetRowStatus(ix) == 'D') {
			} else if (sheetObj.GetCellValue(ix, tmp_name) == tmp_value) {
				sheetObj.SetRowHidden(ix,0);
				item_cnt++;
			} else {
				sheetObjects[2].CheckAll("sheet3_check",0,1);
				sheetObj.SetRowHidden(ix,1);
			}
		}
		return true;
	}
	/**
	 * button activating/deactivating 
	 */
	function button_ComBtnDisable(sheetObj) {
		if (!isInquiry) {
			var formObj=document.form;
			var cnt=sheetObj.GetTotalRows();
			if (cnt > 0) {
				ComBtnDisable("btn2_Copy_from");
			} else {
				ComBtnEnable("btn2_Copy_from");
			}
		}
	}
	/**
	 * event after Sheet retrieve
	 */
	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
	}
	
	function sheet4_OnChange(sheetObj, row, col, val) {
//		var red_font = "#FF0000";
//		var prefix="sheet4_";
//		var formObj = document.form;
//		var arr_cntr=ComGetObjValue(formObj.cb_cntr_no).split("|");
//		var cntr_flg = 0;
//		if(col == "2"){
//			if(arr_cntr.length>0){
//				for(var i=0; i < arr_cntr.length; i++){
//					if(arr_cntr[i] == val)	cntr_flg++;
//				}
//				if(cntr_flg==0){
//					sheetObj.SetCellFontColor(row, col, red_font);
//				}else{
//					sheetObj.SetCellFontColor(row, col, "");
//				}
//			}else{
//				sheetObj.SetCellFontColor(row, col, red_font);
//			}
//		}
	}
	
	function sheet4_OnAfterEdit(sheetObj, Row, Col){
		var prefix="sheet4_";
		var col_name=sheetObj.ColSaveName(Col);
		switch(col_name) {
			case prefix+"cust_ref_no_ctnt":
				var str = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(str), 0);
			break;
		}
	}
	/**
	 *  filtered Data sum
	 */
	function filteredDataSum(sheetObj) {
		var prefix="sheet2_";
		var formObj=document.form;
		var cnt=sheetObj.LastRow();
		var sum1=0, sum2=0, sum3=0;
		try {
			for (i=1; i <= cnt; i++) {
				if (sheetObj.GetRowHidden(i) == false) {
				sum1 += Number(sheetObj.GetCellValue(i, prefix + "pck_qty"));
				sum2 += Number(sheetObj.GetCellValue(i, prefix + "cntr_wgt"));
				sum3 += Number(sheetObj.GetCellValue(i, prefix + "meas_qty"));
				}
			}
			var style_p=formObj.t_pck_qty.style;
			var style_c=formObj.t_cntr_mf_wgt.style;
			var style_m=formObj.t_meas_qty.style;
			
			if (sum1 != formObj.pck_qty.value) {
				style_p.color='#ff0000';
			} else {
				style_p.color='#000000';
			}
			if (sum2 != formObj.cntr_mf_wgt.value) {
				style_c.color='#ff0000';
			} else {
				style_c.color='#000000';
			}
			if (sum3 != formObj.meas_qty.value) {
				style_m.color='#ff0000';
			} else {
				style_m.color='#000000';
			}
			formObj.t_pck_qty.value=String(sum1).comma();
			formObj.t_cntr_mf_wgt.value=String(sum2).comma();
			formObj.t_meas_qty.value=String(sum3).comma();
		} catch (ex) {
			bkg_error_alert('filteredDataSum', ex);
			return false;
		}
	}
	/**
	 * initializing page 1 data 
	 */
	function setSearch_Init_Page1() {
		var formObj=document.form;
		var sObject=sheetObjects[4];
		var prefix='sheet5_';
		var isfirst=true;
		var c_row=sObject.LastRow();
		formObj.vbkg_no.value=formObj.bkg_no.value;
		for ( var row=1; row <= c_row; row++) {
			if (isfirst) {
				var bkg_no=sObject.GetCellValue(row, prefix + "bkg_no");
				var bl_no=sObject.GetCellValue(row, prefix + "bl_no");
				var bl_no_tp=sObject.GetCellValue(row, prefix + "bl_no_tp");
				formObj.vbl_no.value=bl_no + bl_no_tp;
				isfirst=false;
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'BKPO') {
				formObj.bkpo.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'LCNO') {
				formObj.lcno.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'HINV') {
				formObj.hinv.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'LCDT') { // YYYY-MM-DD 
				formObj.lcdt.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt").getDataString();
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'HPDP') {
				formObj.hpdp.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'OTHR') {
				formObj.othr.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'POYN') {
				po_ref_flag=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'DTYN') {
				po_ref_dtl_flag=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd") == 'INCO') {
				formObj.inco.value=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
			}
		}
	}
	String.prototype.comma=function() {
		tmp=this.split('.');
		var str=new Array();
		var v=tmp[0].replace(/,/gi, ''); 
		for ( var i=0; i <= v.length; i++) { 
			str[str.length]=v.charAt(v.length - i); 
			if (i % 3 == 0 && i != 0 && i != v.length) { 
				str[str.length]='.'; 
			}
		}
		str=str.reverse().join('').replace(/\./gi, ','); 
		return (tmp.length == 2) ? str + '.' + tmp[1] : str;
	}
	String.prototype.getDataString=function(dateFormat) {
		if (this == '')
			return '';
		return this.substring(0, 4) + "-" + this.substring(4, 6) + "-" + this.substring(6, 8);
	}
	/**
	 * manage Mandatory Item of SPO No.
	 * 
	 */
	var man_POB=false; // P/O No (by BKG)
	var man_POC=false; // P/O Nl ( by CNTR)
	var man_POM=false; // P/O No (by ITEM)
	var man_INV=false; // Invoice No.
	var man_DPT=false; // Department No
	var man_LCN=false; // L/C No
	var man_SHP=false; // Ship ID
	var man_PRT=false; // Part No
	var man_INC=false; // Incoterms
	function filtereMandatory_Item(man_Item) {
		// Mandatory Item String
		var sManItmDesc="";
		if (man_Item == undefined || man_Item == '')
			return false;
		try {
			var ifilter=man_Item.split(",");
			for ( var inx=0; inx < ifilter.length; inx++) {
				if ('POB' == ifilter[inx]) {
					man_POB=true;
					sManItmDesc += " P/O No.(by BKG),"
				}
				if ('POC' == ifilter[inx]) {
					man_POC=true;
					sManItmDesc += " P/O No.(by CNTR),"
				} 
				if ('POM' == ifilter[inx]) {
					man_POM=true;
					sManItmDesc += " P/O No.(by Item)," 
				} 
				if ('INV' == ifilter[inx]) {
					man_INV=true;
					sManItmDesc += " Invoice No.," 
				} 
				if ('DPT' == ifilter[inx]) {
					man_DPT=true;
					sManItmDesc += " Department No.," 
				} 
				if ('LCN' == ifilter[inx]) {
					man_LCN=true;
					sManItmDesc += " L/C No.," 
				} 
				if ('SHP' == ifilter[inx]) {
					man_SHP=true;
					sManItmDesc += " Ship ID," 
				} 
				if ('PRT' == ifilter[inx]) {
					man_PRT=true;
					sManItmDesc += " Part No.," 
				} 
				if ('INC' == ifilter[inx]) {
					man_INC=true;
					sManItmDesc += " Incoterms," 
				} 
			}
			if (sManItmDesc.length>0) {
				document.all.manItmLayer.style.display="Inline";
				document.all.vManItm.value="*Mandatory Item :" + sManItmDesc.substring(0,sManItmDesc.length-1);
				po_cust_flag='Y';
			} else {
				document.all.manItmLayer.style.display="none";
				po_cust_flag='N';
			}
			return true;
		} catch (ex) {
			bkg_error_alert('', ex);
			return false;
		}
	}
	/**
	 * manage Mandatory Item of SPO No.
	 */
	function validate_Mandatory_Item() {
		var formObj=document.form;
		var bkpo=ComGetObjValue(formObj.bkpo);
		var lcno=ComGetObjValue(formObj.lcno);
		var hinv=ComGetObjValue(formObj.hinv);
		var hpdp=ComGetObjValue(formObj.hpdp);
		var inco=ComGetObjValue(formObj.inco);
		if (man_POB) { 
			if (bkpo == '') {
				ComShowCodeMessage("BKG00888", "P/O No");
				formObj.bkpo.focus();
				return false;
			}
		}
		if (man_LCN) {
			if (lcno == '') {
				ComShowCodeMessage("BKG00888", "L/C No");
				formObj.lcno.focus();
				return false;
			}
		}
		if (man_INV) {
			if (hinv == '') {
				ComShowCodeMessage("BKG00888", "Invoice No");
				formObj.hinv.focus();
				return false;
			}
		}
		if (man_DPT) {
			if (hpdp == '') {
				ComShowCodeMessage("BKG00888", "Department No");
				formObj.hpdp.focus();
				return false;
			}
		}
		if (man_INC) {
			if (inco == '') {
				ComShowCodeMessage("BKG00888", "Incoterms");
				formObj.inco.focus();
				return false;
			}
		}
		if (man_POC) {
			var sObject=sheetObjects[0];
			var prefix=sObject.id + "_";
			var c_row=sObject.LastRow();
			for ( var row=1; row <= c_row; row++) {
				if ('' == sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt")) {
					ComShowCodeMessage("BKG00888", sObject.GetCellValue(row, prefix + "cntr_no") + "  P/O No(by CNTR)");
					sObject.SelectCell(row, prefix + "cust_ref_no_ctnt", true);
					return false;
				}
			}
		}
		if (man_POM) {
			var sObject=sheetObjects[1];
			var prefix=sObject.id + "_";
			var c_row=sObject.LastRow();
			for ( var row=1; row <= c_row; row++) {
				if ('' == sObject.GetCellValue(row, prefix + "po_no")) {
					ComShowCodeMessage("BKG00888", row + " row P/O No(by ITEM)");
					sObject.SelectCell(row, prefix + "po_no", true);
					return false;
				}
			}
		}
		return true;
	}
	
	function validate_sheet4(){
		var sheetObj = sheetObjects[3];
		var temp_cntr = "";
		var temp_ref_tp = "";
		var prefix    = "sheet4_";
		var chk_flg = false;
		for(var i=1;i<sheetObj.RowCount()+1;i++){
			if(sheetObj.GetCellValue(i, prefix+"bkg_ref_tp_cd") == ""){
				ComShowCodeMessage("BKG95031", "[MRN/UCR]");
				return false;
			}else if(sheetObj.GetCellValue(i, prefix+"ref_no") == ""){
				ComShowCodeMessage("BKG06133", "[REF NO]");//  msgs['BKG06133'] = "{?msg1} is empty.";
				return false;
			}else if(sheetObj.GetCellValue(i, prefix+"cust_ref_no_ctnt") == ""){
				ComShowCodeMessage("BKG06133", "[MRN No./UCR No.]");//  msgs['BKG06133'] = "{?msg1} is empty.";
				return false;
			}
		}
		
		for(var i=1;i<sheetObj.RowCount()+1;i++){
			temp_cntr	= sheetObj.GetCellValue(i, prefix+"cntr_no");
			temp_ref_tp = sheetObj.GetCellValue(i, prefix+"bkg_ref_tp_cd");
			if(sheetObj.GetCellValue(i, prefix+"ibflag") == "D" || temp_cntr == ""){	//2015.12.10. CNTR_NO가 없으면 중복체크로직 제외
				continue;
			}
			
			for(var j=i+1;j<sheetObj.RowCount()+1;j++){
				if(sheetObj.GetCellValue(j, prefix+"ibflag") == "D"){
					continue;
				}
				if(temp_cntr == sheetObj.GetCellValue(j, prefix+"cntr_no") && temp_ref_tp == sheetObj.GetCellValue(j, prefix+"bkg_ref_tp_cd")){
					chk_flg= true;
					break;
				}
			}
		}
		
		//Special character check....
		for(var i=1;i<sheetObj.RowCount()+1;i++){
			var str = sheetObj.GetCellValue(i, prefix+"cust_ref_no_ctnt");
			sheetObj.SetCellValue(i, prefix+"cust_ref_no_ctnt", chekcSpecialValue(str), 0);
		}
		
		if(chk_flg){
			ComShowCodeMessage("BKG00965", temp_cntr);
			return false;
		}
		return true;
	}
	/**
	 * handling sheet process
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return void 
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_", "sheet6_");
		var prefix=sheetObj.id + "_";
		switch (sAction) {
		case IBSEARCH: //retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
			}
			ComSetObjValue(formObj.f_cmd, SEARCH);
	 		var sXml=sheetObj.GetSearchData("ESM_BKG_0367_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	 		var arrXml=sXml.split("|$$|");
			var result=ComGetEtcData(arrXml[0], "TRANS_RESULT_KEY");
			var cntr_duplicated=ComGetEtcData(arrXml[0], "CNTR_DUPLICATED");
			if (document.form.bkg_no.value != '') {
				if(result == 'F'){
					setSearch_Init_Page1();
					ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
					ComClosePopup(); 
				}
			}
			for ( var inx=0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchData(arrXml[inx], {Sync:1} );
			}
			var man_Item=ComGetEtcData(arrXml[0], "man_Item");
			if (filtereMandatory_Item(man_Item)) {
			}
			;
			
			if(sheetObjects[0].RowCount()> 0) {
				ComSetObjValue(formObj.cntr_no, sheetObjects[0].GetCellText(1, prefix + "c_cntr_no"));
				ComSetObjValue(formObj.pck_qty, sheetObjects[0].GetCellText(1, prefix + "pck_qty").comma());
				ComSetObjValue(formObj.cntr_mf_wgt, sheetObjects[0].GetCellText(1, prefix + "cntr_mf_wgt").comma());
				ComSetObjValue(formObj.meas_qty, sheetObjects[0].GetCellText(1, prefix + "meas_qty").comma());
			}
			setSearch_Init_Page1();
			var target_value=ComGetObjValue(formObj.cntr_no);
			if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
				filteredDataSum(sheetObjects[1]);
			}
	
			if (button_ComBtnDisable(sheetObjects[1])) {
			}
//			var red_font = "#FF0000";

			for( var inx=1; inx < sheetObjects[3].RowCount()+1; inx++) {
				if(parseInt(sheetObjects[3].GetCellValue(inx, "sheet4_cntr_flg")) == 0){
					sheetObjects[3].SetCellValue(inx, "sheet4_cntr_no", sheetObjects[5].GetCellValue(inx, "sheet6_cntr_no"));
//					sheetObjects[3].SetCellFontColor(inx, "sheet4_cntr_no", red_font);
				}
			}
			if(cntr_duplicated=="Y"){
				document.getElementById("div_Cntr_Del").style.visibility="visible";
			}else{
				document.getElementById("div_Cntr_Del").style.visibility="hidden";
			}
			break;
		case SEARCH01: // retrieve to copy from CM Info to PO & Other No
			if (validateForm(sheetObj, formObj, sAction)) {
			}
			ComSetObjValue(formObj.f_cmd, SEARCH01);
	 		var sXml=sheetObj.GetSearchData("ESM_BKG_0367_01GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet2_'));
			sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
			var target_value=ComGetObjValue(formObj.cntr_no);
			if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
				filteredDataSum(sheetObjects[1]);
			}
			ComBtnDisable("btn2_Copy_from");
			break;
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction)) {
			}// validation check 
			if (!validate_Mandatory_Item()) {
				return;
			}
			if (setSheetByBkg()) {
			}
			
			//sheet4 validation check
			if (!validate_sheet4()){
				return;
			}
			ComSetObjValue(formObj.f_cmd, MULTI);
			
			//CNTR_NO가 공백으로 할때 상태가 바뀌지 않아서 강제로 처리함.
			for(var i=1; i<sheetObjects[3].RowCount()+1; i++){
				if(sheetObjects[3].GetCellValue(i, "sheet4_cntr_no")=="" && sheetObjects[3].GetRowStatus(i)=="R"){
					sheetObjects[3].SetRowStatus(i,"U");
				}
			}
			
			var sParam=ComGetSaveString(sheetObjects);

			if (sParam == "")
				return;
			sParam += "&" + FormQueryString(formObj);
			sParam += "&" + ComGetPrefixParam(aryPrefix);
			if (!ComShowConfirm(ComGetMsg("BKG00350"))) {
				return;
			}
	 		var sXml=sheetObj.GetSaveData("ESM_BKG_0367_01GS.do", sParam);
			var xml="<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA></ETC-DATA><MESSAGE></MESSAGE></RESULT>";
	 		sheetObjects[0].LoadSaveData(sXml);
			break;
		case IBINSERT:
			if (sheetObjects[0].RowCount()== 0 && sheetObj.id == "sheet2")
				return;
			if(sheetObj.id == "sheet2" || sheetObj.id == "sheet3"){
				var Row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(Row, sheetObj.id + "_cntr_no",ComGetObjValue(formObj.cntr_no));
			}else if(sheetObj.id == "sheet4"){
				var nRow = sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(nRow, prefix+"ucr_tp_cd", "CUCR");
				sheetObj.SetCellValue(nRow, prefix+"mrn_tp_cd", "CMRN");
				sheetObj.SetCellValue(nRow, prefix+"bkg_no", formObj.bkg_no.value);
			}
			break;
		case IBDELETE: 
			var sheet1_sel_row = 0;
			if (sheetObj.id == "sheet1"){
				sheet1_sel_row = sheetObj.GetSelectRow();
			}
			
			if (sheetObjects[0].RowCount()== 0 && sheetObj.id == "sheet2")
				return;
			if (sheetObj.FindCheckedRow(prefix + "del_chk") != "") {
				ComRowHideDelete(sheetObj, prefix + "del_chk");
			} else {
				ComShowMessage(ComGetMsg("COM12189"));
			}
			if (sheetObj.id == "sheet1"){
				if(sheetObj.GetSelectRow() != sheet1_sel_row){
					//Change display of detail
					sheet1_OnClick(sheetObj, sheetObj.GetSelectRow(), 0, "");
				}
			}else if (sheetObj.id != "sheet4"){
				filteredDataSum(sheetObjects[1]);
			}
			break;
		}
	}
	/**
	 *  event handling when Sheet saved
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
	/**
	 * calling Package Code and Description .<br>
	 * @param  pck_tp_cd
	 */
	var current_Row='';
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		current_Row=Row;
		comBkgCallPop0696("setCallBack0696", sheetObj.GetCellValue(Row, "sheet2_pck_tp_cd"));
	}
	/**
	 * search Package Code and Description<br>
	 * @param {arry} aryPopupData
	 */
	function setCallBack0696(returnVal) {
		sheetObjects[1].SetCellValue(current_Row, "sheet2_pck_tp_cd",returnVal.cd);  
	}
	/**
	 * booking info set and save 
	 */
	function setSheetByBkg() {
		var formObj=document.form;
		var v_bkpo=formObj.bkpo.value;
		var v_lcno=formObj.lcno.value;
		var v_hinv=formObj.hinv.value;
		var v_lcdt=formObj.lcdt.value.split('-').join("");
		var v_hpdp=formObj.hpdp.value;
		var v_othr=formObj.othr.value;
		var v_inco=formObj.inco.value;
		try {
			if (!isSheetModify('BKPO', v_bkpo)) {
				isSheetInsert('BKPO', v_bkpo);
			}
			if (!isSheetModify('LCNO', v_lcno)) {
				isSheetInsert('LCNO', v_lcno);
			}
			if (!isSheetModify('HINV', v_hinv)) {
				isSheetInsert('HINV', v_hinv);
			}
			if (!isSheetModify('LCDT', v_lcdt)) {
				isSheetInsert('LCDT', v_lcdt);
			}
			if (!isSheetModify('HPDP', v_hpdp)) {
				isSheetInsert('HPDP', v_hpdp);
			}
			if (!isSheetModify('OTHR', v_othr)) {
				isSheetInsert('OTHR', v_othr);
			}
			if (!isSheetModify('INCO', v_inco)) { 
				isSheetInsert('INCO', v_inco);
			}
		} catch (ex) {
			bkg_error_alert('setSheetByBkg', ex);
			return false;
		}
		return true;
	}
	 /**
	  * checking Validation at onblur event of HTML Control <br>
	  **/
	 function obj_activate() {
	 	switch (ComGetEvent().name) {
	 		case "lcdt":
	 			ComClearSeparator(ComGetEvent());
	 			break;	
	 		default:
	 			break;
	 	}	
	 }
	 /**
	  * checking Validation at onblur event of HTML Control <br>
	  **/
	 function obj_deactivate() {
	 	 var formObj=document.form;
	 	switch (ComGetEvent().name) {
			case "lcdt":
				ComAddSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	/**
	 * additional process in case of existing data
	 * @param _var1
	 * @param _var2
	 */
	function isSheetInsert(_var1, _var2) {
		var formObj=document.form;
		var sObject=sheetObjects[4];
		var prefix='sheet5_';
		try {
			var row=sObject.DataInsert(-1);
			sObject.SetCellValue(row, prefix + "bkg_no",formObj.bkg_no.value);
			sObject.SetCellValue(row, prefix + "bkg_ref_tp_cd",_var1);
			sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
		} catch (ex) {
			bkg_error_alert('isSheetInsert', ex);
			return false;
		}
	}
	/**
	 * modifiy process in case of existing data
	 */
	function isSheetModify(_var1, _var2) {
		var sObject=sheetObjects[4];
		var prefix='sheet5_';
		var r_flag=false;
		var c_row=sObject.LastRow();
		try {
			for ( var row=1; row <= c_row; row++) {
				//update
				var v_bkg_ref_tp_cd=sObject.GetCellValue(row, prefix + "bkg_ref_tp_cd");
				var v_cust_ref_no_ctnt=sObject.GetCellValue(row, prefix + "cust_ref_no_ctnt");
				if (_var1 == 'BKPO' && v_bkg_ref_tp_cd == 'BKPO') {
					if (v_cust_ref_no_ctnt != _var2) {
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'LCNO' && v_bkg_ref_tp_cd == 'LCNO') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update LCNO'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'HINV' && v_bkg_ref_tp_cd == 'HINV') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update HINV'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'LCDT' && v_bkg_ref_tp_cd == 'LCDT') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update LCDT'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'HPDP' && v_bkg_ref_tp_cd == 'HPDP') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update HPDP'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'OTHR' && v_bkg_ref_tp_cd == 'OTHR') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update OTHR'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
				if (_var1 == 'INCO' && v_bkg_ref_tp_cd == 'INCO') {
					if (v_cust_ref_no_ctnt != _var2) { //alert('update INCO'+row);
						sObject.SetCellValue(row, prefix + "cust_ref_no_ctnt",_var2);
						sObject.SetRowStatus(row,"U");
					} else {
						sObject.SetRowStatus(row,"R");
					}
					r_flag=true;
					break;
				}
			}
		} catch (ex) {
			bkg_error_alert('isSheetModify', ex);
			return false;
		}
		return r_flag;
	}
	/**
	 * Event handler processing by button name
	 */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var sheetObject6=sheetObjects[5];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn1_Row_Add":
				doActionIBSheet(sheetObject2, formObject, IBINSERT);
				break;
			case "btn2_Row_Add":
				doActionIBSheet(sheetObject3, formObject, IBINSERT);
				break;
			case "btn3_Row_Add":
				doActionIBSheet(sheetObject4, formObject, IBINSERT);
				break;
			case "btn1_Cntr_Delete": // P/O No by CNT / Item : CNTR Delete
				if(validateForm(sheetObject1, formObject, IBDELETE)){
					doActionIBSheet(sheetObject1, formObject, IBDELETE);					
				}
				break;
			case "btn1_Row_Delete":
				doActionIBSheet(sheetObject2, formObject, IBDELETE);
				break;
			case "btn2_Row_Delete":
				doActionIBSheet(sheetObject3, formObject, IBDELETE);
				break;
			case "btn3_Row_Delete":
				doActionIBSheet(sheetObject4, formObject, IBDELETE);
				break;
			case "btn2_Copy_from":
				if (ComIsBtnEnable("btn2_Copy_from"))
					doActionIBSheet(sheetObject1, formObject, SEARCH01);
				break;
			case "btn2_Copy_Desc":
				copyToDescShip();
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
			case "btn_Calendar": //calender button
				var cal=new ComCalendar();
				cal.select(formObject.lcdt, 'yyyy-MM-dd');
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
			} // end switch
		} catch (ex) {
			if (ex == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				alert(ex.message);
			}
			bkg_error_alert('', ex);
		}
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		
		var sheetID=sheetObj.id;
		switch(sAction) {
			case IBDELETE:
				switch(sheetID) {
					case "sheet1":
						//Allow to delete only duplicated container
						var delRow = sheetObj.FindCheckedRow("sheet1_del_chk");
						var check_ok = false;
						if(delRow!=""){
							var arrDelRow = delRow.split("|");
							for(var j=0; j<arrDelRow.length; j++){
								var cntr_no = sheetObj.GetCellValue(arrDelRow[j], "sheet1_cntr_no");
								check_ok = false;
								for(k=1; k<=sheetObj.RowCount();k++){
									if((sheetObj.GetCellValue(k, "sheet1_cntr_no")==cntr_no) && (sheetObj.GetRowStatus(k)!="D") && (sheetObj.GetCellValue(k, "sheet1_del_chk")!=1)){
										check_ok = true;
										break;
									}
								}
								if(!check_ok){
									ComShowMessage(ComGetMsg("BKG01196"));
									return false;
								}
							}
						}
						break;
				}
			break;
		}
		return true;
	}
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * Tab option
	 * setting tab list
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				InsertItem( "P/O No by CNTR / Item", "");
				InsertItem( "Ship ID", "");
				InsertItem( "MRN. UCR No", "");
			}
			break;
		}
	}
	/**
	 * activating tab when click tab	
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		// --------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab=nItem;
	}
	function bkg_error_alert(msg, ex) {
		alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
	}
	/**
	 * activating tab when click tab
	 */
	function copyToDesc(chkObj) {
//		if (!opener) opener=window.dialogArguments;
		var localopener = (opener || parent);
		var formObj = document.form;
		var result_msg='';
	    if (chkObj.checked) {
			if (chkObj.name == "check_bkpo") {
				result_msg=result_msg + "\n P/O No:" + form.bkpo.value;			
			}
			if (chkObj.name == "check_lcno") {
				result_msg=result_msg + "\n L/C No:" + form.lcno.value;
			}
			if (chkObj.name == "check_hinv") {
				result_msg=result_msg + "\n Invoice No:" + form.hinv.value;
			}
			if (chkObj.name == "check_lcdt") {
				result_msg=result_msg + "\n L/C Date:" + form.lcdt.value;
			}
			if (chkObj.name == "check_hpdp") {
				result_msg=result_msg + "\n Department No:" + form.hpdp.value;
			}
			if (chkObj.name == "check_othr") {
				result_msg=result_msg + "\n Other Ref. No:" + form.othr.value;
			}	
			if (chkObj.name == "check_inco") {
				result_msg=result_msg + "\n Incoterms:" + form.inco.value;
			}		
			if (result_msg.length > 0) {
				if (formObj.callback_func.value != '') {
					eval('localopener.'+formObj.callback_func.value)(po_cust_flag, po_ref_flag, po_ref_dtl_flag, result_msg);
				}
			}
	    }
	}
	/**
	 * event in case of changing data of cell <br>
	 * 
	 * @param sheetObject
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function copyToDescShip() {
		var formObj = document.form;
		var localopener = (opener || parent);
		var prefix='sheet3_';
		var ship_result_msg='';
		var part_result_msg='';
		var result_msg='';
	 	for(var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].RowCount(); i++){
			if (sheetObjects[2].GetCellValue(i, prefix + "del_chk") == 1) {
				ship_result_msg=ship_result_msg + sheetObjects[2].GetCellValue(i, prefix + "de_no") + ",";
				part_result_msg=part_result_msg + sheetObjects[2].GetCellValue(i, prefix + "prt_no") + ",";
			}
	 	}
		if (formObj.callback_func.value != '') {
			if (ship_result_msg.length > 0){
				ship_result_msg="\n Ship ID:" + ship_result_msg.substring(0, ship_result_msg.length -1);
			}
			if (part_result_msg.length > 0){
				part_result_msg="\n Part No:" + part_result_msg.substring(0, part_result_msg.length -1);
			}
			result_msg=ship_result_msg + part_result_msg;
			if (result_msg.length > 0)
				eval('localopener.'+formObj.callback_func.value)(po_cust_flag, po_ref_flag, po_ref_dtl_flag, result_msg);
		}
	}
