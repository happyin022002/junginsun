/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0596.js
*@FileTitle  : Manual BDR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
				case "btn_CheckAll":
					sheetObject.CheckAll("Check",1,1);
					break;
				case "btn_UncheckAll":
					sheetObject.CheckAll("Check",0,1);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObject, IBSEARCH);
					break;
				case "btn_BKGBDR":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
					break;
				case "btn_VVDBDR":
					doActionIBSheet(sheetObject, formObject, IBCREATE);
					break;
				case "btn_C_BKGBDR":
					doActionIBSheet(sheetObject, formObject, REMOVE);
					break;
				case "btn_C_VVDBDR":
					doActionIBSheet(sheetObject, formObject, REMOVELIST);
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     * @param sheet_obj IBSheet Object
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
		initControl();
		// 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	 * init control
	 */
	function initControl() {
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- Key Press
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		ComBtnDisable("btn_C_BKGBDR");
		ComBtnDisable("btn_C_VVDBDR");
//		formObject.vvd_cd.focus();
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param sheetObj sheet Object
     * @param sheetNo 
     */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
			case "sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel.|No.|Booking No.|Booking No.|B/L No.|T. VVD|T. Lane|POL|POD|ETD|+@|BDR Date|BDR|By|Office|BKG By|BKG Office|VVD By|VVD Office|VSL Cd|Skd Voy No.|Skd Dir Cd|VPS PORT CD|Total Booking|BDR Booking|Obl Iss Flag";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
					 {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"etd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bdr_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bdr_date",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bdr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_bdr_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"vvd_bdr_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vvd_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vps_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tot_booking_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"btr_booking_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"obl_iss_flag",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetEditable(1);
					SetColProperty("etd_dt", {Format:"####-##-####:##"} );
					SetColProperty("bdr_date", {Format:"####-##-####:##"} );
					SetSheetHeight(382);
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
					ComBtnDisable("btn_BKGBDR");
					ComBtnDisable("btn_VVDBDR");
					ComBtnDisable("btn_C_BKGBDR");
					ComBtnDisable("btn_C_VVDBDR");
					sheetObj.DoSearch("ESM_BKG_0596GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
					
				}
				break;
			case IBSAVE: //BKG_BDR
				if (ComIsBtnEnable("btn_BKGBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					if (ComShowCodeConfirm("BKG80841")) {
						formObj.f_cmd.value=MULTI01;
						sheetObj.DoSave("ESM_BKG_0596GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
			case IBCREATE: //VVD_BDR
				if (ComIsBtnEnable("btn_VVDBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					if (ComShowCodeConfirm("BKG80842")) {
						formObj.f_cmd.value=MULTI02;
						var SaveXml=sheetObj.GetSaveData("ESM_BKG_0596GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(SaveXml);
					}
				}
				break;
			case REMOVE: //BKG_BDR CANCEL
				if (ComIsBtnEnable("btn_C_BKGBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					if (ComShowCodeConfirm("BKG80841")) {
						formObj.f_cmd.value=MULTI03;
						sheetObj.DoSave("ESM_BKG_0596GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
			case REMOVELIST: //VVD_BDR CANCEL
				if (ComIsBtnEnable("btn_C_VVDBDR") == false) {
					break;
					return;
				}
				if (validateForm(sheetObj, formObj, sAction)) {
					if (ComShowCodeConfirm("BKG80842")) {
						formObj.f_cmd.value=MULTI04;
						var SaveXml=sheetObj.GetSaveData("ESM_BKG_0596GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(SaveXml);
						if (sheetObj.GetEtcData("TRANS_RESULT_KEY") == 'S') {
					 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						} 
					}
				}
				break;	
		}
	}
	/**
	 * handling process after ending sheet1 retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */  
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;		
		with (sheetObj) {
			ComSetObjValue(formObj.vvd_bdr, GetEtcData("vvd_bdr"));
			ComSetObjValue(formObj.tot_booking_cnt, GetEtcData("total_booking_cnt"));
			ComSetObjValue(formObj.btr_booking_cnt, GetEtcData("btr_booking_cnt"));
			
			if (GetEtcData("total_booking_cnt") == GetEtcData("btr_booking_cnt")) {
				//ComSetObjValue(formObj.vvd_bdr, "Yes");
				ComBtnDisable("btn_BKGBDR");
				ComBtnDisable("btn_VVDBDR");
			} else {
				//ComSetObjValue(formObj.vvd_bdr, "No");
				ComBtnEnable("btn_BKGBDR");
				ComBtnEnable("btn_VVDBDR");
			}
			if (RowCount()> 0 && ComGetObjValue(formObj.bdr_flg) == "Y") {
				ComBtnEnable("btn_C_BKGBDR");
				ComBtnEnable("btn_C_VVDBDR");
				ComBtnDisable("btn_BKGBDR");
				ComBtnDisable("btn_VVDBDR");
			}else if (RowCount()== 0 && ComGetObjValue(formObj.bdr_flg) == "Y") {
				ComBtnEnable("btn_C_VVDBDR");
			} else {
				ComBtnDisable("btn_C_BKGBDR");
				ComBtnDisable("btn_C_VVDBDR");
			}

			
//			if (ComGetObjValue(formObj.bkg_no) != "") {
//				ComBtnDisable("btn_VVDBDR");
//				ComBtnDisable("btn_C_VVDBDR");
//			}
			if (RowCount()> 0){
				ComSetObjValue(formObj.vsl_cd,GetCellValue(1, "vsl_cd"));
				ComSetObjValue(formObj.skd_voy_no,GetCellValue(1, "skd_voy_no"));
				ComSetObjValue(formObj.skd_dir_cd,GetCellValue(1, "skd_dir_cd"));
				ComSetObjValue(formObj.vps_port_cd,GetCellValue(1, "vps_port_cd"));
				ComSetObjValue(formObj.vvd_cd,GetCellValue(1, "vvd_cd"));
				ComSetObjValue(formObj.pol_cd,GetCellValue(1, "pol_cd"));
				ComSetObjValue(formObj.pod_cd,GetCellValue(1, "pod_cd"));
			}else{
				ComSetObjValue(formObj.vsl_cd,"");
				ComSetObjValue(formObj.skd_voy_no,"");
				ComSetObjValue(formObj.skd_dir_cd,"");
				ComSetObjValue(formObj.vps_port_cd,"");
			}
			for ( var i=1; i <= LastRow(); i++) {
				if (GetCellValue(i, "bdr_flg") == "Y") {
					SetCellValue(i, "Check","Y",0);
					SetCellValue(i, "ibflag","R",0);
					SetCellEditable(i, "Check",0);
				}
				if (ComGetObjValue(formObj.bdr_flg) == "Y") {
					SetCellValue(i, "Check","",0);
					SetCellValue(i, "ibflag","R",0);
					SetCellEditable(i, "Check",1);
				}
				SetDataLinkMouse("bkg_no",1);
				SetColFontUnderline("bkg_no",1);
				SetColFontColor("bkg_no","#027E94");
			}
		}
	}
	/**
     * handling process after ending sheet1 save
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
		if (sheetObj.GetEtcData("TRANS_RESULT_KEY") == 'S') {
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 	 	
    }
	/**
     * Sheet1 click event handling
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		var colName=sheetObj.ColSaveName(Col);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(Value);
 		}
 	}
	/**
	* handling process for input validation
	* @param sheetObj sheet Object
	* @param formObj  form Object
	* @param sAction 
	*/
	function validateForm(sheetObj, formObj, sAction) {
		if (ComGetObjValue(formObj.bkg_no) != ""	) {
			formObj.vvd_cd.required=null;
			formObj.pol_cd.required=null;
			formObj.pod_cd.required=null;
		}
		if (ComGetObjValue(formObj.bkg_no) == ""	) {
			formObj.vvd_cd.required=true;
			formObj.pol_cd.required=true;
			formObj.pod_cd.required=true;
			if (ComGetObjValue(formObj.vvd_cd) == "" 
					|| ComGetObjValue(formObj.pol_cd) == "" 
						|| ComGetObjValue(formObj.pod_cd) == ""){
				ComShowCodeMessage('BKG00626', 'VVD,POL,POD or BKG No.');
				if (ComGetObjValue(formObj.vvd_cd) == ""){ 
					formObj.vvd_cd.focus();
				}else if (ComGetObjValue(formObj.pol_cd) == ""){ 
					formObj.pol_cd.focus();
				}else if (ComGetObjValue(formObj.pod_cd) == ""){ 
					formObj.pod_cd.focus();	
				}
				return false;
			}
		}
		if (!ComChkValid(formObj))
			return false;
		return true;
	}