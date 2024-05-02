/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0071.js
*@FileTitle  : BDR Status Inquiry 
*@author     : CLT
*@version    : 
*@since      : 2014/05/05
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_bkg_0071 : business script for esm_bkg_0071
     */
	
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboCnt=0;
	var comboObjects=new Array();
	var bMultiComboDataAdded=false;
	var bMultiComboDataAdded2=false;
	var prefix="sheet1_";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var comboObject1=comboObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			 if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
			case "btn_BKGList":
					if (sheetObject1.RowCount()>0){
						sheet1_OnDblClick(sheetObject1, sheetObject1.GetSelectRow(), 1);}
					else
					{
						sheet1_OnDblClick(sheetObject1, 0, 1);
					}
					break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel({ HiddenColumn:-1,TreeLevel:false,Merge:1,AutoSizeColumn:1,DownCols: makeHiddenSkipCol(sheetObject1)});
					}
					
					break;
				case "btn_bdrdate":
					var cal=new ComCalendar();
					cal.select(formObject.bdr_dt, 'yyyy-MM-dd');
					break;
				case "btn_period":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
		// initializing MultiCombo
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], comboObjects[k].id);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		form.vvd_cd.focus();
	}
	function initControl() {
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); // -
		axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', formObject); // -
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); // -
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
//	function bkg_keypress() {
//		switch (event.srcElement.dataformat) {
//			case "ymd":
//				// number
//				ComKeyOnlyNumber(event.srcElement, "-");
//				break;
//			case "engup":
//				// capital English
//				ComKeyOnlyAlphabet('upper');
//				break;
//			case "engupnum":
//				// number+capital English
//				ComKeyOnlyAlphabet('uppernum');
//				break;
//			case "num":
//				// number
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//			default:
//		}
//	}
	/**
	 * onBlur event
	 */
	function bkg_deactivate() {
		var formObj=document.form;
//		switch (event.srcElement.getAttribute("name")) {
		switch (ComGetEvent("name")) {
			case "bdr_dt":
				ComAddSeparator(ComGetEvent());
				break;
			case "from_dt":
				ComAddSeparator(ComGetEvent());
				break;
			case "to_dt":
				ComAddSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	/**
	 * onFocus event - checking Validation
	 */
	function bkg_activate() {
		switch (ComGetEvent("name")) {
			case "bdr_dt":
				ComClearSeparator(ComGetEvent());
				break;
			case "from_dt":
				ComClearSeparator(ComGetEvent());
				break;
			case "to_dt":
				ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: // 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				ComOpenWait(true);
				
				setTimeout( function () { //@ setTimeout ###########################################################				
							formObj.f_cmd.value=SEARCH;
							var sXml=sheetObj.GetSearchData("ESM_BKG_0071GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
							sheetObjects[0].SetWaitImageVisible(0);
							sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
							formObj.runtime.value=ComGetEtcData(sXml, "runtime");

							ComOpenWait(false);

				} , 100);//@ setTimeout end ###########################################################
				break;
			case SEARCH01: // 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				ComOpenWait(true);
				
				setTimeout( function () { //@ setTimeout ###########################################################
					
							formObj.f_cmd.value=SEARCH01;
							var sXml=sheetObj.GetSearchData("ESM_BKG_0071GS.do", FormQueryString(formObj));
							var arrXml=sXml.split("|$$|");
							var arrData=ComXml2ComboItem(arrXml[0], slan_cd, "vsl_slan_cd", "vsl_slan_cd");
							var p_skd_dir_cd="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR><![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR><![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR><![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
							var arrData=ComXml2ComboItem(p_skd_dir_cd, skd_dir_cd, "val", "name");
							
							ComOpenWait(false);

				} , 100);//@ setTimeout end ###########################################################
							
				break;
			case IBDOWNEXCEL: // 
				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
		}
	}
	/**
      * setting sheet initial values and header
      * param : comboObj, comboid
      * adding case as numbers of counting combos
	 */
	function initCombo(comboObj, comboid) {
		var formObject=document.form
		switch (comboid) {
			case "slan_cd":
				with (comboObj) {
					// BackColor = "#CCFFFD";
					SetDropHeight(100);
					SetMultiSelect(0);
					SetUseEdit(1);
					SetMaxSelect(1);
				}
				break;
		}
	}
	/**
    * registering IBCombo Object as list
    * @param combo_obj
    * @return
    */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * MultiCombo - changing input values in capital letters
	 * 
	 * @param comboObj
	 * @return
	 */
	function slan_cd_OnChange(comboObj) {
		var formObject=document.form;
		// changing input value in capital letters
		var comboText=comboObj.GetSelectText().toUpperCase();
		// deleting in case of existing
		if (bMultiComboDataAdded) {
			comboObj.DeleteItem(0);
			bMultiComboDataAdded=false;
		}
		// returning in case of existing input value at COMBO
		if (comboObj.FindItem(comboText, 0) == -1) {
			comboObj.SetSelectText("",false);
			return;
		}
//		comboObj.InsertItem(0, comboText, comboText);
		bMultiComboDataAdded=true; // whether input value at COMBO registered 
		comboObj.SetSelectText(comboText,false);// selecting input value of COMBO
	}
	/**
	 * MultiCombo - changing input values in capital letters
	 * 
	 * @param comboObj
	 * @return
	 */
	function skd_dir_cd_OnChange(comboObj) {
		var formObject=document.form;
		// changing input value in capital letters
		var comboText=comboObj.GetSelectText().toUpperCase();
		// deleting in case of existing
		//if (bMultiComboDataAdded2) {
			//comboObj.DeleteItem(0);
	//		bMultiComboDataAdded2=false;
		//}
		// returning in case of existing input value at COMBO
		if (comboObj.FindItem(comboText, 0) != -1) {
			//comboObj.SetSelectText("",false);
			return;
		}
		bMultiComboDataAdded2=true; // whether input value at COMBO registered
		comboObj.SetSelectText(comboText,false);// selecting input value of COMBO
		//comboObj.InsertItem(0, comboCode, comboText);
	}
	/*
	 * double click event - sheet
	 */
	function sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
		var vvd_cd=sheetObj.GetCellValue(rowIdx, prefix + "vvd_cd");
		var pol_cd=sheetObj.GetCellValue(rowIdx, prefix + "pol_cd");
		var pod_cd=sheetObj.GetCellValue(rowIdx, prefix + "pod_cd");
		comBkgCallPop0727("setCallBack0727", vvd_cd, pol_cd, pod_cd);
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (ComIsNull(formObj.vvd_cd)) {
					ComShowCodeMessage('BKG00227');
					formObj.vvd_cd.focus();
					return false;
				}
				if (formObj.vvd_cd.value.length != 9) {
					ComShowCodeMessage('BKG00538');
					formObj.vvd_cd.focus();
					return false;
				}
				if (!dateCheck(formObj.bdr_dt)) {
					ComShowCodeMessage('BKG00921')
					formObj.bdr_dt.focus();
					return false;
				}
				if (!dateCheck(formObj.from_dt)) {
					ComShowCodeMessage('BKG00921')
					formObj.from_dt.focus();
					return false;
				}
				if (!dateCheck(formObj.to_dt)) {
					ComShowCodeMessage('BKG00921')
					formObj.to_dt.focus();
					return false;
				}
				if(ComChkPeriod(formObj.from_dt.value, formObj.to_dt.value) < 1) {
					ComShowCodeMessage("COM132002");
					formObj.from_dt.focus();
					return false;
				}
				/*
				 * if (!dateCheckUsa(formObj.bdr_dt)) {
				 * ComShowCodeMessage('BKG00920') formObj.bdr_dt.focus(); return
				 * false; } if (!dateCheckUsa(formObj.from_dt)) {
				 * ComShowCodeMessage('BKG00920') formObj.from_dt.focus(); return
				 * false; } if (!dateCheckUsa(formObj.to_dt)) {
				 * ComShowCodeMessage('BKG00920') formObj.to_dt.focus(); return
				 * false; }
				 */
				break;
			case IBSAVE:
				var prefix="sheet1_";
				for ( var i=sheetObj.HeaderRows(); i <= sheetObj.RowCount()+ sheetObj.HeaderRows()- 1; i++) {
					var vUsrId=sheetObj.GetCellValue(i, prefix + "usr_id");
					if (sheetObj.GetCellValue(i, prefix + "ibflag") != "R") {
						if (ComIsNull(vUsrId)) {
							ComShowCodeMessage('BKG00768', 'User ID');
							return false;
						}
					}
				}
				break;
		}
		return true;
	}
	/**
	 * checking date format
	 */
	function dateCheck(dateobj) {
		if (dateobj.value == "")
			return true;// 
		return ComIsDate(dateobj.value);
	}
	/**
	 * checking form input validation
	 */
	function dateCheckUsa(dateobj) {
		var arrMon={
			Jan :'01',
			Feb :'02',
			Mar :'03',
			Apr :'04',
			May :'05',
			Jun :'06',
			Jul :'07',
			Aug :'08',
			Sep :'09',
			Oct :'10',
			Nov :'11',
			Dec :'12'
		}
		var date=dateobj.value;
		if (date == "")
			return true;// 
		// 			
		var reg=/(^\d{2})([A-Za-z]{3})(\d{2})/; // 
		if (reg.test(date)) {// checking date format
			var day=RegExp.$1;
			var mon=RegExp.$2;
			var year=RegExp.$3;
			if (arrMon[mon] == undefined) {// in case of wrong month
				return false;
			}
			if (year >= 50) {// 
				if (ComIsDate('19' + year + arrMon[mon] + day))
					return true;
			} else {
				if (ComIsDate('20' + year + arrMon[mon] + day))
					return true;
			}
		}// 
		return false;
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix="sheet1_";
		var formObject=document.form;
		if (sheetObj.ColSaveName(Col) == prefix + "usr_id") {
			formObject.ch_usr_id.value=Value;
			doActionIBSheet(sheetObj, formObject, SEARCH01, Row, Col);
		}
	}
	function isNullEtcData(xmlStr) {
		var rtn=false;
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if (xmlRoot == null)
			return true;
		var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if (etcDataNode == null)
			return true;
		var etcNodes=etcDataNode.childNodes;
		if (etcNodes == null)
			return true;
		if (etcNodes.length == 0)
			rtn=true;
		return rtn;
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
	/**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetObj.id) {
			case "sheet1":
			    with(sheetObj){
		        
		      if (location.hostname != "")
		      var HeadTitle1="|Lane|Dir|V.V.D|POL|POL/ETD|POD|TRUNK|TRUNK|TRUNK|FEEDER|FEEDER|FEEDER";
		      var HeadTitle2="|Lane|Dir|V.V.D|POL|POL/ETD|POD|Day|BDR Time|BDR|Day|BDR Time|BDR";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trnk_bdr_dys", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trnk_bdr_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trnk_bdr_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fdr_bdr_dys",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fdr_bdr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fdr_bdr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      //SetSheetHeight(410);
		      SetEditable(0);
		      SetRangeBackColor(1,6,1,12,"#555555");
		      resizeSheet();
		      }
				break;
		}
	}
  