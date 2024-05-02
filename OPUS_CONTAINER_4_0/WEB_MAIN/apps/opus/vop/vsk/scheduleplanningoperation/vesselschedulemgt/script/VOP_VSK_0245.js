/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0245.jsp
*@FileTitle  : Port Skip Recorder for Statistics
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_ok":
					var row=sheetObject1.GetSelectRow();
					var col=sheetObject1.GetSelectCol();
					doReturnValue(sheetObject1, row, col);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
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
    function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
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
		parentSkipPort(sheetObjects[0], "OPEN");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
		        var HeadTitle1="|Skip\nPort Code|T/S\nPort Code|Report|Force Majeure|Reason|Reason|Reason|Reason";
		        var HeadTitle2="|Skip\nPort Code|T/S\nPort Code|Report|Force Majeure|Port|Code|Hours|Remark(s)";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:75 });
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		               {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port_list",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"usd_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rsn_port_list",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl_dlay_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		               {Type:"Text",      Hidden:0, Width:95,   Align:"Left",    ColMerge:1,   SaveName:prefix+"win_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"port_skp_rsn_offr_rmk", KeyField:0, CalcLogic:"", Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		               {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"vps_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rsn_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rsn_skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rsn_skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rsn_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetImageList(0,"img/btns_search.gif");
		        SetColProperty(prefix+"usd_flg", {ComboText:"YES|NO", ComboCode:"Y|N"} );
		        SetColProperty(prefix+"port_skp_tp_cd", {ComboText:"YES|NO", ComboCode:"F|I"} );
		        SetRangeBackColor(1, 3, 1, 8,"#777777");
		        SetShowButtonImage(2);
		        SetSheetHeight(170);
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH;
					var sParam=ComGetSaveString(sheetObjects);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("VOP_VSK_0245GS.do", sParam);
					setHtmlSheet(sXml, sheetObj);
				}
				break;
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true; 
    }
    /**
     * process after retrieve.
     * @param xmlStr
     * @param sheetObj
     * @return
     */
	function setHtmlSheet(sXml, sheetObj){
		if(sXml == null  || sXml == "") return;
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
		var idx=0;
		var code=" |" + ComGetEtcData(sXml, "code");
		var code_desc=" |" + ComGetEtcData(sXml, "code_desc");
		for(var i=headCnt; i<=totCnt; i++){
			var tsPortCd=" |" + ComGetEtcData(sXml, "ts_port_cd"+idx);
			var tsPortInfo=" \t \t \t |" + ComGetEtcData(sXml, "ts_port_info"+idx);
			var reasonPortCd=" |" + ComGetEtcData(sXml, "reason_port_cd"+idx);
			var reasonPortInfo=" \t \t \t |" + ComGetEtcData(sXml, "reason_port_info"+idx);
			sheetObj.CellComboItem(i,prefix+"ts_port_list", {ComboText:tsPortInfo, ComboCode:ComReplaceStr(tsPortInfo)} );
			sheetObj.CellComboItem(i,prefix+"rsn_port_list", {ComboText:reasonPortInfo, ComboCode:ComReplaceStr(reasonPortInfo)} );
			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
			sheetObj.CellComboItem(i,prefix+"vsl_dlay_rsn_cd", {ComboText:code_desc, ComboCode:code} );
			idx++;
		}
		parentSkipPort(sheetObj, "");
	}
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnClick(sheetObj, Row, Col) {
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		var sXml=null;
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"win_rmk"){
//				ComShowMemoPad(sheetObj, Row, Col, false, 120, 160);
//				var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, prefix+"vps_rmk"));
				var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, prefix+"port_skp_rsn_offr_rmk"));
//				if(sheetObj.CellEditable(Row, prefix+"win_rmk") == false){
//					sUrl = sUrl + "&readonly=true";
//				}
//				var rVal=ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
//				if(rVal || rVal == ""){
//					sheetObj.SetCellValue(Row, prefix+"vps_rmk",rVal,0);
//					sheetObj.SetCellValue(Row, prefix+"win_rmk",rVal.replace(/\n/g, "").replace(/\r/g, ""),0);
//				}
				ComOpenPopup(sUrl, 342, 350, "returnRemarkHelp", "0,0", true);
			}
		}
	}
	
	/**
	 * Handling data from Remark Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnRemarkHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
		var rtnDatas=rtnObjs;
		
		if(rtnDatas.length > 0){
			if(rtnDatas || rtnDatas == ""){
//				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"vps_rmk", rtnDatas,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"port_skp_rsn_offr_rmk", rtnDatas,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"win_rmk", rtnDatas.replace(/\n/g, "").replace(/\r/g, ""),0);
			}
		}
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"ts_port_list"){
				var arrSelText=selectPortCell(sheetObj, Row, Col);
				sheetObj.SetCellValue(Row, prefix+"ts_skd_voy_no",arrSelText[0],0);
				sheetObj.SetCellValue(Row, prefix+"ts_skd_dir_cd",arrSelText[1],0);
				//sheetObj.SetCellValue(Row, prefix+"ts_port_cd",arrSelText[2],0);
				sheetObj.SetCellValue(Row, prefix+"ts_clpt_ind_seq",arrSelText[3],0);
			}else if(colName == prefix+"rsn_port_list"){
				var arrSelText=selectPortCell(sheetObj, Row, Col);
				sheetObj.SetCellValue(Row, prefix+"ts_port_cd",arrSelText[0],0);
				sheetObj.SetCellValue(Row, prefix+"rsn_skd_voy_no",arrSelText[0],0);
				sheetObj.SetCellValue(Row, prefix+"rsn_skd_dir_cd",arrSelText[1],0);
				sheetObj.SetCellValue(Row, prefix+"rsn_port_cd",arrSelText[2],0);
				sheetObj.SetCellValue(Row, prefix+"rsn_clpt_ind_seq",arrSelText[3],0);
			}
		}
	}
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	}
	/**
	 * Returning selected T/S Port and Reason Port as array type
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function selectPortCell(sheetObj, Row, Col){
		var sText=sheetObj.GetComboInfo(Row, Col, "Text");
		var arrText=sText.split("|");
		var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var arrSelText=arrText[idx].split("\t");
		return arrSelText;
	}
	/**
	 * Returning VVD of inputted ROW to parent screen
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function doReturnValue(sheetObj, Row, Col){
		
		var prefix=sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows();
		var totCnt  = sheetObj.LastRow();
		for (var nRow = headCnt; nRow <= totCnt; nRow++) {
			if (sheetObj.GetCellValue(nRow, prefix+"usd_flg") == "Y" && sheetObj.GetCellValue(nRow, prefix+"vsl_dlay_rsn_cd") == "") {
				ComShowCodeMessage('VSK00027', "Reason Code");
				
				sheetObj.SelectCell(nRow, prefix+"vsl_dlay_rsn_cd");
				return;
			}
		}
		comPopupOK();
	}
	/**
	 * Getting Skip Port from parent screen
	 * @param currSheetObj
	 * @param flag
	 * @return
	 */
	function parentSkipPort(sheetObj, flag){
		var opner=window.dialogArguments;
		if (!opener) opener=parent; //이 코드 추가할것
		var pSheetObj=opener.sheet1; // 2014.08.22
		var pPrefix=pSheetObj.id+"_";
		var pSelRow=pSheetObj.GetSelectRow();
		var prefix=sheetObj.id+"_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var skipRows=getSkipPortRows(pSheetObj);
		var usdFlg="N";
		var portSkpTpCd="I";
		if(flag == "OPEN"){
			// Setting parameter to get combo data from Pop up
			if(skipRows){
				if(skipRows.length > 0){
					for(var i=0; i<skipRows.length; i++){
						sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(sheetObj.LastRow(), prefix+"vsl_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"vsl_cd"),0);
						sheetObj.SetCellValue(sheetObj.LastRow(), prefix+"skd_voy_no",pSheetObj.GetCellValue(skipRows[i], pPrefix+"skd_voy_no"),0);
						sheetObj.SetCellValue(sheetObj.LastRow(), prefix+"skd_dir_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"skd_dir_cd"),0);
					}
				}
			}
		}
		else{
			if(skipRows){
				if(skipRows.length > 0){
					for(var i=0; i<skipRows.length; i++){
						if(pSheetObj.GetCellValue(skipRows[i], pPrefix+"usd_flg") == "Y"){
							usdFlg="Y";
						}else{
							usdFlg="N";
						}
						if(pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_tp_cd") == "F"){
							portSkpTpCd="F";
						}else{
							portSkpTpCd="I";
						}
						
						sheetObj.SetCellValue(i+headCnt, prefix+"vps_port_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"vps_port_cd"),0);
						var tsPortVal=pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_skd_voy_no")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_skd_dir_cd")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_port_cd")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_clpt_ind_seq");
						sheetObj.SetCellValue(i+headCnt, prefix+"ts_port_list",tsPortVal,0);
						sheetObj.SetCellValue(i+headCnt, prefix+"usd_flg",usdFlg,0);
						sheetObj.SetCellValue(i+headCnt, prefix+"port_skp_tp_cd",portSkpTpCd,0);
						var rsnPortVal=pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_skd_voy_no")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_skd_dir_cd")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk")
						+ pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_clpt_ind_seq");
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_port_list",rsnPortVal,0);
						sheetObj.SetCellValue(i+headCnt, prefix+"vsl_dlay_rsn_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_rsn_cd"),0);//combo
//						sheetObj.SetCellValue(i+headCnt, prefix+"delay_date",pSheetObj.GetCellValue(skipRows[i], pPrefix+"delay_date"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"ttl_dlay_hrs",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ttl_dlay_hrs"),0);
//						sheetObj.SetCellValue(i+headCnt, prefix+"win_rmk",pSheetObj.GetCellValue(skipRows[i], pPrefix+"vps_rmk").replace(/\n/g, "").replace(/\r/g, ""),0);;
//						sheetObj.SetCellValue(i+headCnt, prefix+"vps_rmk",pSheetObj.GetCellValue(skipRows[i], pPrefix+"vps_rmk"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"win_rmk",pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk").replace(/\n/g, "").replace(/\r/g, ""),0);;
						sheetObj.SetCellValue(i+headCnt, prefix+"port_skp_rsn_offr_rmk",pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"vsl_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"vsl_cd"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"skd_voy_no",pSheetObj.GetCellValue(skipRows[i], pPrefix+"skd_voy_no"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"skd_dir_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"skd_dir_cd"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_port_list",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_port_cd"),0);//combo
						sheetObj.SetCellValue(i+headCnt, prefix+"ts_port_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_port_cd"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"ts_skd_voy_no",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_skd_voy_no"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"ts_skd_dir_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_skd_dir_cd"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"ts_clpt_ind_seq",pSheetObj.GetCellValue(skipRows[i], pPrefix+"ts_clpt_ind_seq"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_port_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"port_skp_rsn_offr_rmk"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_skd_voy_no",pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_skd_voy_no"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_skd_dir_cd",pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_skd_dir_cd"),0);
						sheetObj.SetCellValue(i+headCnt, prefix+"rsn_clpt_ind_seq",pSheetObj.GetCellValue(skipRows[i], pPrefix+"rsn_clpt_ind_seq"),0);
					}
				}
			}
		}
	}
	/**
	 * Getting activated sheet from parent screen
	 * @return
	 */
	function getParentSheet(){
		var opner=window;
		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 1){
				for(var i=0; i<opner.sheetObjects.length; i++){
					//0015
					if(opner.document.form.rdo_tran[0].checked){
						return opner.sheetObjects[0];
					}else{
						return opner.sheetObjects[1];
					}
				}
			}else{
				return opner.sheetObjects[0];
			}
		}
		return opner.sheetObjects[0];
	}
	/**
	 * Returning Skip or selected Row
	 * @param sheetObj
	 * @return
	 */
	function getSkipPortRows(sheetObj){
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=sheetObj.LastRow();
		var prefix=sheetObj.id + "_";
		var skipRows=new Array();
		var idx=0;
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"
				|| i == sheetObj.GetSelectRow()){
				skipRows[idx]=i;
				idx++;
			}
		}
		return skipRows;
	}