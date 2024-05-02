/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0036.js
*@FileTitle  : Port Tariff 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class VOP_PSO_0036 : business script for VOP_PSO_0036
 */
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var gColumnCountInSheet6=0;	//Column Count of sheet6
	var updatedBys=new Array();
	var updatedDates=new Array();
	var updMnuNos=new Array();//2016.11.22 Add version 에 따른 Simple/Complex 구분값 (1/2)
	var LANE="lane";
	var ROWMARK="|";
	var FIELDMARK=",";
	var myDiv0211="";
	var myDiv0212="";
	
	var gRateFormat4 = "#,###.####";
	var gRateFormat = "#,###.##########";
	var gRateFormatZero10 = "#,##0.##########";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_port_cd":
				var sUrl="/opuscntr/VOP_VSK_0043.do";//?op=0043";
				//ComOpenPopup(sUrl, 805, 510, "portCallBack", "0,0", true);
				ComOpenPopup(sUrl, 805, 510, "portCallBack", "0,0,1,1,1,1,1,1", true);
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
			case "btn_New":
				clearCondition(document.form);
				break;
				
			case "btn1_Tariff_Update":
				moveToUpdate(sheetObjects[0]);
				break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	* port code CallBack event
	*/
	function portCallBack(rtnVal) {
		if(rtnVal){
			document.form.port_cd.value=rtnVal;
			loadTerminal();
		}
	}

	/**
	 * Move Screen for Tariff Update
	 * @param mode ( 1 : simple Tariff - move to 0002, 2: complex Tariff - move to 0004
	 */
	function moveToUpdate(sheetObj){
		var formObj=document.form;
		var params="parentPgmNo=VOP_PSO_M001&moved_from=0036";
		if(sheetObj != "undefined" && sheetObj.RowCount()> 0){
			//var mode=sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_upd_mnu_no");			

	        var tmpUpdMnuNo = sheetObj.GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_upd_mnu_no");
	        var tmpUpdMnuNoByVer = updMnuNos[comboVer.GetSelectIndex()];
	        var mode = ComIsEmpty(tmpUpdMnuNoByVer) ? tmpUpdMnuNo : tmpUpdMnuNoByVer;
		    
			params += "&moved_params=";
			params += "port_cd::" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_yd_cd").substring(0, 5);
			params += "||" + "year::" + formObj.year.value;
			params += "||" + "yd_cd::" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_yd_cd").substring(5);
			params += "||" + "acct_cd::" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_acct_cd"); 
			params += "||" + "cost_cd::" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_lgs_cost_cd"); 
			params += "||" + "vndr_seq::" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_vndr_seq");
			params += "||" + "from_date::" + formObj.eff_dt.value.substring(0,10);
			params += "||" + "to_date::" + formObj.eff_dt.value.substring(11);
			if(mode == "1"){
				params += "&pgmNo=VOP_PSO_0002";
				this.location="/opuscntr/VOP_PSO_0002.do" + "?" + params;
			} else if(mode == "2"){
				params += "&pgmNo=VOP_PSO_0004";
				this.location="/opuscntr/VOP_PSO_0004.do" + "?" + params;
			}
			
		}else {
			params += "&pgmNo=VOP_PSO_0002";
			this.location="/opuscntr/VOP_PSO_0002.do" + "?" + params;
		}
		
	}
	/**
	 * in case New Button Click, Initializing Conditions
	 * @param formObj
	 * @return
	 */
	function clearCondition(formObj, option){
		//ComboObject Clear
		for(var k=0;k<comboObjects.length;k++){
			comboObjects[k].RemoveAll();
		}
		if(option == undefined || option == ""){
			formObj.reset();
			//Setting current year
			setToday(formObj.year, "y");
			//focus on port_cd
			formObj.port_cd.focus();
		}
		formObj.eff_dt.value="";
		myDiv0211.style.display="inline";
		myDiv0212.style.display="none";
		sheetObjects[0].RemoveAll();
		f_RemoveSheets();
		gSheet1SelRow="";
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
	 * registering IBCombo Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
		comboObjects[comboCnt++]=combo_obj;  
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();  
		myDiv0211=document.getElementById("myDiv0211");
		myDiv0212=document.getElementById("myDiv0212");
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	/**
	 * setting combo initial values and header
	 * param : comboObj, comboNo
	 * adding case as numbers of counting combos
	 */ 
	function initCombo(comboObj, comboNo) {
		var formObject=document.form
		switch(comboNo) {  
			case 1: 
				with (comboObj) { 
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "300");
					SetDropHeight(190);
					ValidChar(2, 3);
				}
				break;
			case 2:
				break;
			case 3:
				break;
		} 
	}
	/**
	 * registering initial event
	 */
	function initControl(){
		var formObj=document.form;
		setToday(formObj.year, "y");
		//axon_event.addListener('keydown', 'obj_keydown', form);
		axon_event.addListenerForm('change', 'obj_change', form);
	//	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	//	axon_event.addListenerForm('keyup', 'obj_keyup', form);
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm  ('paste', 'obj_paste', form);
		axon_event.addListenerForm  ('drop', 'obj_drop', form); 
		BEFORE_PORT_CD = "";
	}
	

	/** 
	 * Handling activate event
	 */
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}

	function obj_change(){
		var formObject=document.form;
		var sheetObj=sheetObjects[0];
		/*******************************************************/
		var srcName=ComGetEvent("name");
				if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "vsl_cd":
			break;
		case "year":
			if(validateForm(sheetObj, formObject, "port_cd_change")){
				clearCondition(formObject, "data");
				loadTerminal();
			}
			break;
		case "port_cd":
			/*
			 * 1. length of Lane Code < 3, Setting null
			 * 2. length of Lane Code >= 3, Calling Server
			 */
			if(BEFORE_PORT_CD == formObject.port_cd.value) return;
			
			if(validateForm(sheetObj, formObject, "port_cd_change")){
				clearCondition(formObject, "data");
				loadTerminal();
				//comboObjects[0].focus();
			}
			isRmkModFlg="Y";
			break;
		case "pf_svc_tp_cd":
		case "skd_rmk":
			isRmkModFlg="Y";
			break;
		} 
	}

	function obj_paste(){
		var eleObj=event.srcElement;
		var formObj=document.form;
		switch (eleObj.name) {
			case "port_cd":
				gf_SetControlPastePattern(event, "A");
				break;	
			case "year":
				gf_SetControlPastePattern(event, "0");
				break;				
		}
	}
	function obj_drop(){
		event.returnValue=false;
	}

	function loadTerminal(code) {
		var formObject=document.form;
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObjects[0],COMMAND01,LANE,code);
	}
	// Retrieving Lane SVC Type
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH: 
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1") {		
						comboObjects[0].RemoveAll();
						comboObjects[1].RemoveAll();
						comboObjects[2].RemoveAll();
						formObj.updated_by.value="";
						formObj.updated_date.value="";
						//SheetObject Clear
						for(i=0;i<sheetObjects.length;i++){
							sheetObjects[i].RemoveAll();
						}	
						formObj.f_cmd.value=COMMAND01;
						var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
						var comboData=ComGetEtcData(sXml, sComboKey);
						var comboItems=null;
						if(comboData != null && comboData != ""){
							comboItems=comboData.split(ROWMARK);
							//addComboItem(comboObjects[0],comboItems);	//Origin
							addComboItem(comboObjects[0],comboItems, 3);
						} else{
							formObj.port_cd.value="";
							ComSetFocus(formObj.port_cd);
						}
					}
				}
			break;
		}
	}
	/**
	 * Adding data to combo
	 */	
	function addComboItem(comboObj,comboItems, mode) {
		comboObj.SetSelectIndex(-1,false);
		comboObj.RemoveAll();
		
		//2016.11.22 Add 초기화.
		updatedBys    = []; //Updated By User Array 초기화.
		updatedDates  = []; //Updated By Date Array 초기화.
		updMnuNos     = []; //Simple, Complex 구분 Array 초기화.
		
		for (var i=0 ; i < comboItems.length ; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			if(mode == 1){
				comboObj.InsertItem(i, comboItem[0], comboItem[2]);
				updatedBys[i]=comboItem[3];
				updatedDates[i]=comboItem[4];
				updMnuNos[i]=comboItem[5]; //2016.11.22 Add
			} else if(mode == 0){
				comboObj.InsertItem(i, comboItem[0], comboItem[1]);
			} else{
				comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
			}
		}   		
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
		case "sheet1":
		    with(sheetObj){
		      var HeadTitle1="|Terminal\nCode|Account\nCode|Cost\nCode|Curr.|Service Provider|Service Provider|hmnuno|CostCodeName|AccountName";
		      var HeadTitle2="|Terminal\nCode|Account\nCode|Cost\nCode|Curr.|No.|Name|hmnuno|CostCodeName|AccountName";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",        		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",      		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_cd",  		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",  	  		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",     		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_abbr_nm", 		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no", 		KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_eng_nm",   		KeyField:0,   CalcLogic:"",   Format:"" } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(548);
		      SetActionMenu("Copy");
	         }
			break;
			
		case "sheet2"://simple base
		    with(sheetObj){
		      var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Regular\nValue|Formula Condition|Formula Condition|Alias|||Compulsory";
		      var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|Regular\nValue|ID|Description|Alias|||Compulsory";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
		             {Type:"Combo",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             //{Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             //{Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",  UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",  UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"regular_value",   KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		             {Type:"Text",     Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",     Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",     Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg" } ];
		      InitColumns(cols);
		      SetEditable(0);
	          SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Range2\tRangeRateOnly|Fixed\tObjectXFixedRate", ComboCode:"R|S|F"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(150);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      	}
			break;
			
		case "sheet3"://simple surcharge
		    with(sheetObj){
		      var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet2_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Combo",   Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,	UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no"  },
		             {Type:"Text",    Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		             {Type:"Text",    Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            	PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",    Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		             {Type:"Combo",   Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option"  } ];
		      InitColumns(cols);
		      SetEditable(0);
	          SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(115);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
		  break;
		  
		case "sheet4"://simple discount
		    with(sheetObj){
		      var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet3_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Combo",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",  Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",   Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		             {Type:"Text",   Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",   Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		             {Type:"Text",   Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",   Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		             {Type:"Combo",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		      InitColumns(cols);
		      SetEditable(0);
	          SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(130);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
		  break;	
		  
		case "sheet5":
		    with(sheetObj){
		      var HeadTitle1="|D/F|Formula|Formula|Condition|Condition|Compulsory|UK";
		      var HeadTitle2="|D/F|ID|DESC| ID|DESC|Compulsory|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0} ); 
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
		             {Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"default2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, HeaderCheck:0 },
		             {Type:"Popup",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"foml_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cpls_flg" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetShowButtonImage(1);
		      SetSheetHeight(155);
		      SetCountPosition(0);
		      //SetFocusAfterProcess(0);
			}
			break;
			
		case "sheet6"://복합 우측 Sheet
		    with(sheetObj){
		      var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		      var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColumnCountInSheet6=headCount;
		      var prefix="sheet2_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
		             {Type:"Combo",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",    Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",     Hidden:1,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Fixed\tObjectXFixedRate", ComboCode:"R|F"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(220);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      	}
			break;
			
		case "sheet7":				//Ragular Value
		    with(sheetObj){
		      var HeadTitle1="Regular Value|Regular Value|Regular Value|Regular Value";
		      var HeadTitle2="Object|UOM|Value|UOM CD";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet3_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      
		      var cols = [ 
		                 {Type:"Text",   Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
			             {Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",   Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"regular_value",      KeyField:0,   CalcLogic:"",   Format:"",   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",   Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",   UpdateEdit:1,   InsertEdit:1,   EditLen:14 }];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(165);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	         }
			break;
			
		case "sheet8"://복합 surcharge
		    with(sheetObj){
		      var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet4_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		             {Type:"Combo",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		      InitColumns(cols);
		      SetEditable(0);
	          SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(130);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
		  break;
		  
		case "sheet9"://복합 discount
		    with(sheetObj){
		      var HeadTitle1="Method|Rate|Formula ID|Formula Description|Formula Condition|Formula Condition|Alias|SUM.Option";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet5_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Combo",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"method_code" },
		             {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",  KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10,  UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"formula_no" },
		             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",   KeyField:0 },
		             {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_als_nm" },
		             {Type:"Combo",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sum_option" } ];
		      InitColumns(cols);
		      SetEditable(0);
	          SetColProperty(prefix+"method_code", {ComboText:"Amount|Percent", ComboCode:"A|R"} );
		      SetColProperty(prefix+"sum_option", {ComboText:"ALL|MAX|MIN", ComboCode:"6|7|8"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(130);
		      SetCountPosition(0);
		      SetFocusAfterProcess(0);
	      }
		break;
		
		case "sheet10":		//Base Dummy
		    with(sheetObj){
		      var HeadTitle1="Seq.|Object|Unit of\nMeasure|Rate\nType|Range|Range|Currency|Rate|Rate Condition|Rate Condition|||Alias|UK";
		      var HeadTitle2="Seq.|Object|Unit of\nMeasure|Rate\nType|From|To|Currency|Rate|ID|Description|||Alias|UK";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet6_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ 
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_dsp" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"object_code_dsp" },
		             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rate_code" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_from",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"range_to",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"currency",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rate_value",      KeyField:0,   CalcLogic:"",   Format:gRateFormatZero10, UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Popup",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"condition",       KeyField:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cond_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"object_name" },
		             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"uom" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"cons_als_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"uk",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetColProperty(prefix+"rate_code", {ComboText:"Range1\tObjectXRangeRate|Fixed\tObjectXFixedRate", ComboCode:"R|F"} );
		      SetShowButtonImage(1);
		      SetSheetHeight(212);
	      }
		break;	
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieving
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH;//PortCharge List Retrieving 
				formObj.yd_cd.value=formObj.port_cd.value + comboObjects[0].GetSelectCode();
				f_RemoveSheets(); 
				sheetObj.DoSearch("VOP_PSO_0036GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_") );
			break;
			
			case SEARCH01://VerClick Version()List Query
				comboObjects[1].RemoveAll();
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_");
				var sXml=sheetObj.GetSearchData("VOP_PSO_0036GS.do", sParam);
				sheetObjects[0].SetWaitImageVisible(0);
				var comboData=ComGetEtcData(sXml, LANE); 
				var comboItems=null;
				if(comboData != null && comboData != ""){
					comboItems=comboData.split(ROWMARK);
					addComboItem(comboObjects[1],comboItems, 0);
					comboObjects[1].SetSelectIndex(0);
				}
			break;
			
			case SEARCH02://in case EffectiveDate List Click, Version()Query
				comboObjects[2].RemoveAll();
				formObj.f_cmd.value=SEARCH02;
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_");
				var sXml=sheetObj.GetSearchData("VOP_PSO_0036GS.do", sParam);
				var comboData=ComGetEtcData(sXml, LANE);
				var comboItems=null;
				if(comboData != null && comboData != ""){
					comboItems=comboData.split(ROWMARK);
					addComboItem(comboObjects[2],comboItems, 1);
					comboObjects[2].SetSelectIndex(0);
				}
			break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if (formObj.port_cd.value == "") {
				ComShowCodeMessage("PSO00003", "Port");
				return false;
			}
			if (year.value == "") {
				ComShowCodeMessage("PSO00003", "Year");
				return false;
			}
		}
		switch (sAction) {
		case "port_cd_change": //port_cd onChange Event
		if (!ComIsNull(formObj.port_cd.value)) {
			if (formObj.port_cd.value.length < 5) {
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value="";
				return false;
			}
		} else {
			comboObjects[0].RemoveAll();
			// SheetObject Clear
			for (i=0; i < sheetObjects.length; i++) {
				sheetObjects[i].RemoveAll();
			}
			return false;
		}
		break;
		}
		return true;
	}
	function sheet2_OnSearchEnd(sheetObj){
		f_AfterRetrieve(1);
		sheetObjects[0].SetFocus();
		var prefix = "sheet1_";
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			//Time 일대 포맷을 마추기 위해 4자리 pad 처리.
			tmpObjectCodeDsp		=sheetObj.GetCellValue(i, prefix + "object_code_dsp");
			if("TIME" == tmpObjectCodeDsp){
				var tmpRangeFrByTm = sheetObj.GetCellValue(i, prefix + "range_from" )+"";
				var tmpRangeToByTm = sheetObj.GetCellValue(i, prefix + "range_to" )+"";
				
				sheetObj.SetCellValue(i, prefix + "range_from"	,ComLpad(tmpRangeFrByTm,4, "0"), 0);
				sheetObj.SetCellValue(i, prefix + "range_to"	,ComLpad(tmpRangeToByTm,4, "0"), 0);
			}
			
			f_SetMeasUnitByRow(sheetObj, i);
		}
	}
	function sheet5_OnSearchEnd(sheetObj){
	    //sheetObjects[9].RemoveAll();
		if(sheetObjects[0+4].RowCount()> 0){
		    var tmpUk = sheetObjects[0+4].GetCellValue(sheetObjects[0+4].HeaderRows(), "sheet1_uk");
			f_CopyDummy2Base(tmpUk);
		}
		f_AfterRetrieve(2);
	}
	function sheet7_OnSearchEnd(sheetObj){
		f_SetRagularMeasUnit(sheetObj);
	}
	function sheet6_OnSearchEnd(sheetObj){
		sheetObjects[0].SetFocus();
		var prefix = "sheet2_";
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			//Time 일대 포맷을 마추기 위해 4자리 pad 처리.
			tmpObjectCodeDsp		=sheetObj.GetCellValue(i, prefix + "object_code_dsp");
			if("TIME" == tmpObjectCodeDsp){
				var tmpRangeFrByTm = sheetObj.GetCellValue(i, prefix + "range_from" )+"";
				var tmpRangeToByTm = sheetObj.GetCellValue(i, prefix + "range_to" )+"";
				
				sheetObj.SetCellValue(i, prefix + "range_from"	,ComLpad(tmpRangeFrByTm,4, "0"), 0);
				sheetObj.SetCellValue(i, prefix + "range_to"	,ComLpad(tmpRangeToByTm,4, "0"), 0);
			}
			
			f_SetMeasUnitByRow(sheetObj, i);
		}
	}
	function sheet9_OnSearchEnd(sheetObj){
	    var tmpUk = sheetObjects[4].GetCellValue(sheetObjects[4].GetSelectRow(), "sheet1_uk");

		f_CopyDummy2Base(tmpUk);		//Copying to Base
	}
	/**
	 * process after retrieve sheet1
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		f_RemoveSheets();
		if(sheetObj.RowCount()> 0 && formObj.f_cmd.value == SEARCH ){
			formObj.yd_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_yd_cd");
			formObj.vndr_seq.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_vndr_seq");
			formObj.lgs_cost_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_lgs_cost_cd");
			doActionIBSheet(sheetObjects[0],formObj,SEARCH01);		
		} else{
			myDiv0211.style.display="inline";
			myDiv0212.style.display="none";
		}
		
		
	}
	/**
	 * Handling sheet1 click event
	 */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		f_RemoveSheets();
		formObj.yd_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_yd_cd");
		formObj.vndr_seq.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_vndr_seq");
		formObj.lgs_cost_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet_lgs_cost_cd");
		doActionIBSheet(sheetObjects[0],formObj,SEARCH01);	
		
	}
    
	/**
	 * in case Effective Date Change, Retrieving Version
	 * @param Combo
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function combo2_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
		var formObj=document.form;
		formObj.eff_dt.value=newtext;
		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);	
	}
	/**
	 * in case Vesrion Change, Retrieving Tariff Information
	 * @param Combo
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function comboVer_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
		var formObj=document.form;
		formObj.updated_by.value=updatedBys[obj.GetSelectIndex()];
		formObj.updated_date.value=updatedDates[obj.GetSelectIndex()];
		//SEARCH03
		formObj.combo1.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_yd_cd").substring(5);
		formObj.combo3.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_lgs_cost_cd");
		formObj.combo5.value=newtext;
		var dates=comboObjects[1].GetSelectText().split('~');
		if(dates.length>=2){
			formObj.from_date.value=dates[0];
			formObj.to_date.value=dates[1];
		}
		//var mode=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_upd_mnu_no");
		var tmpUpdMnuNo = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_upd_mnu_no");
		var tmpUpdMnuNoByVer = updMnuNos[obj.GetSelectIndex()];
		var mode = ComIsEmpty(tmpUpdMnuNoByVer) ? tmpUpdMnuNo : tmpUpdMnuNoByVer;
		
		
		//Dummy > Base Delete/Add/Copy 하기 위해서 초기화를 해주어야 한다.
		f_RemoveSheets();
		
		if(mode=="1"){
			var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet3_" ); 
			myDiv0212.style.display="none";	
			myDiv0211.style.display="inline";	
		
			var param  = "f_cmd="     + SEARCH;				//Command
			param += "&port_cd="  + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_yd_cd");	//Port(7자리)
			param += "&combo1="   + "";			//Yard 
			param += "&vndr_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_vndr_seq");	//Service Provider
			param += "&combo3="   + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_lgs_cost_cd");	//Cost
			param += "&combo4="   + comboObjects[2].GetSelectCode(); 		//Version 
			//param += "&year="     + formObj.year.value; 	//Year
			param += "&from_date="+ formObj.eff_dt.value.substring(0,10);
			param += "&to_date="  + formObj.eff_dt.value.substring(11);
			param += "&uid="      + "0002"; 				//UID 
		
			var sXml=sheetObjects[0].GetSearchData("VOP_PSO_0002GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");    
			sheetObjects[1].SetWaitImageVisible(1);//Div1 : sheet1
			sheetObjects[2].SetWaitImageVisible(0);//Div1 : sheet2
			sheetObjects[3].SetWaitImageVisible(0);//Div1 : sheet3
			sheetObjects[1].LoadSearchData(arrXml[0]);
			sheetObjects[2].LoadSearchData(arrXml[1]);
			sheetObjects[3].LoadSearchData(arrXml[2]);
			//Enable to 1st row
			setEnableControl4Columns(sheetObjects[1], aryPrefix[0]+"object|" + aryPrefix[0]+"object_code|" + aryPrefix[0]+"rate_code|" + aryPrefix[0]+"regular_value|" + aryPrefix[0]+"condition");
//			f_AfterRetrieve(1);
		} else if(mode=="2"){
			var aryPrefix=new Array( "sheet1_", "sheet6_", "sheet3_", "sheet4_", "sheet5_" );
			myDiv0211.style.display="none";	
			myDiv0212.style.display="inline";	
			var param  = "f_cmd="     + SEARCH;				//Command
			param += "&port_cd="  + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_yd_cd");	//Port(length:7)
			param += "&combo1="   + "";			//Yard 
			param += "&vndr_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_vndr_seq");	//Service Provider
			param += "&combo3="   + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet_lgs_cost_cd");	//Cost
			param += "&combo4="   + comboObjects[2].GetSelectCode(); 		//Version 
			//param += "&year="     + formObj.year.value; 	//Year
			param += "&from_date="+ formObj.eff_dt.value.substring(0,10);
			param += "&to_date="  + formObj.eff_dt.value.substring(11);
			param += "&uid="      + "0004"; 				//UID 
			var sXml = sheetObjects[0].GetSearchData("VOP_PSO_0004GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");  	
			//before Div2, 4 sheets are drawn
			sheetObjects[0+4].SetWaitImageVisible(1);
			sheetObjects[5+4].SetWaitImageVisible(0);
			sheetObjects[2+4].SetWaitImageVisible(0);
			sheetObjects[3+4].SetWaitImageVisible(0);
			sheetObjects[4+4].SetWaitImageVisible(0);
			sheetObjects[0+4].LoadSearchData(arrXml[0], {Sync:1});
			sheetObjects[5+4].LoadSearchData(arrXml[1], {Sync:1});
			sheetObjects[2+4].LoadSearchData(arrXml[2], {Sync:1});
			sheetObjects[3+4].LoadSearchData(arrXml[3], {Sync:1});
			sheetObjects[4+4].LoadSearchData(arrXml[4], {Sync:1});
			
			/*if(sheetObjects[0+4].RowCount()> 0){
	            var tmpUk = sheetObjects[0+4].GetCellValue(sheetObjects[0+4].HeaderRows(), "sheet1_uk");
	            f_CopyDummy2Base(tmpUk);
	        }
	        f_AfterRetrieve(2);*/
		}
	}
	/**
	 * Row change
	 */ 
	function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var formObj=document.form;
		if(OldRow == NewRow){
			return;
		}
		f_RemoveDummyByBase(sheetObj.GetCellValue(OldRow, "sheet1_uk"));	//Deleting to Dummy
		f_CopyBase2Dummy(sheetObj.GetCellValue(OldRow, "sheet1_uk"));		//Addting to Dummy
		f_CopyDummy2Base(sheetObj.GetCellValue(NewRow, "sheet1_uk"));		//Copying to Base
		document.getElementById("foml_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_foml_desc");
		document.getElementById("cond_desc").innerHTML=sheetObj.GetCellValue(NewRow, "sheet1_cond_desc");
	}   
	function f_RemoveSheets(){
		var formObj=document.form;
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		sheetObjects[5].RemoveAll();
		sheetObjects[6].RemoveAll();
		sheetObjects[7].RemoveAll();
		sheetObjects[8].RemoveAll();
		sheetObjects[9].RemoveAll();
		//formObj.foml_desc.value = "";
		document.getElementById("foml_desc").innerHTML="";
		//formObj.cond_desc.value = "";
		document.getElementById("cond_desc").innerHTML="";
	}       
	function setEnableControl4Columns(sheetObj, cols){
		var formObj=document.form;
		var arrCol=cols.split("|");
		for(row=sheetObj.HeaderRows(); row<sheetObj.HeaderRows()+ sheetObj.RowCount(); row++){
			if(row > sheetObj.HeaderRows()){
				for(i=0; i<arrCol.length; i++){
					sheetObj.SetCellEditable(row, arrCol[i],0);
				}
				sheetObj.SetCellValue(row, "sheet1_seq","",0);
				sheetObj.SetCellValue(row, "sheet1_object_dsp","",0);
				sheetObj.SetCellValue(row, "sheet1_object_code_dsp","",0);
				sheetObj.SetCellValue(row, "sheet1_rate_code","",0);
				sheetObj.SetCellValue(row, "sheet1_regular_value","",0);
				sheetObj.SetCellValue(row, "sheet1_condition","",0);
				sheetObj.SetCellValue(row, "sheet1_cond_desc","",0);
			} else{
				for(i=0; i<arrCol.length; i++){
					sheetObj.SetCellEditable(row, arrCol[i],1);
				}		
			}
		}
		//Compulsory
		if(sheetObjects[0].RowCount()> 0){
			if(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_cpls_flg") == "Y"){
				formObj.cpls_flg.checked=true;
			} else{			
				formObj.cpls_flg.checked=false;
			}
		} else{
			formObj.cpls_flg.checked=false;
		}
	}
	/*
	* Copying Sheet6 to Sheet10
	*/
	function f_CopyBase2Dummy(oldUk){
		var sXml=f_MakeSearchXml4CopyBase2Dummy(oldUk);
		sheetObjects[9].SetWaitImageVisible(0);
		sheetObjects[9].LoadSearchData(sXml,{Append:1} );
	}
	/*
	* Copying Sheet10 to Sheet6
	*/
	function f_CopyDummy2Base(uk){
	    var sXml=f_MakeSearchXml4CopyDummy2Base(uk);
		sheetObjects[5].LoadSearchData(sXml);
	}
	/*
	* Deleting sheet6 data in Sheet10
	*/
	function f_RemoveDummyByBase(uk){
		var xxx=ComFindAll(sheetObjects[9], "sheet6_uk", uk) + "";
		if(xxx == "-1"){
			return;
		}
		var zzz=xxx.split("|");
		if(zzz.length == 0){
			return;
		}
		//UK row Deleting
		sheetObjects[9].RenderSheet(0);
		for( var i=Number(zzz[zzz.length-1]); i>=Number(zzz[0]); i-- ) {
			sheetObjects[9].RowDelete( i, false );
		}
		sheetObjects[9].RenderSheet(1);
	}
	
	function f_AfterRetrieve(div){
		var formObj=document.form;
		var sheetObj=div == 1 ? sheetObjects[1] : sheetObjects[4];
		//Compulsory
		if(sheetObj.RowCount()> 0){
			if(sheetObj.GetCellValue(sheetObj.HeaderRows(), "sheet1_cpls_flg") == "Y"){
				formObj.cpls_flg.checked=true;
			} else{			
				formObj.cpls_flg.checked=false;
			}
		} else{
			formObj.cpls_flg.checked=false;
		}
		
	}
	/**
	 * 
	 */ 
	function f_MakeSearchXml4CopyDummy2Base(uk)  {
		 var sheetObj=sheetObjects[9];
		 try {
//			 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
//				 return "";
//			 }
			 if (!sheetObj || !sheetObj.IBSheetVersion){
				 return "";
			 }
			 var allXml="";
			 var hColSep="|";
			 var sColSep="☜☞";
			 var sColOrder="";
			 var aryTD=new Array(gColumnCountInSheet6);
			 for(var i=0; i < gColumnCountInSheet6; i++){
				 aryTD[i]=sheetObj.ColSaveName(i).replace(/sheet6/g, "sheet2");
			 }
			 sColOrder=aryTD.join(hColSep);
			 allXml="<?xml version='1.0'  ?>\n" 
				 + "<SHEET>\n";
			 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
			 var arrRow=new Array();
			 var k=0;
			 for( var i=sheetObj.HeaderRows(); i<sheetObj.RowCount()+ sheetObj.HeaderRows(); i++ ) {
				 if(sheetObj.GetCellValue(i, "sheet6_uk") == uk){
					 arrRow[k]=i;
					 k++;
				 }
			 }
			 if(arrRow.length != 0){
				 var aryTR=new Array(arrRow.length);
				 for(var ir=0; ir<arrRow.length; ir++){
					 for(var ic=0; ic<gColumnCountInSheet6; ic++){
						 aryTD[ic]=String(sheetObj.GetCellValue(arrRow[ir], ic));
					 }
					 aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
				 }
				 allXml += aryTR.join("\n");
			 }
			 allXml += "  \n</DATA>\n"
				 +  "</SHEET>";
			 return allXml;
		 } catch(err) { ComFuncErrMsg(err.message); }
	}  
	/**
	 * 
	 */ 
	function f_MakeSearchXml4CopyBase2Dummy(oldUk)  {
		 var sheetObj=sheetObjects[5];
		 try {
			 //Checking validation
//			 if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
//				 return "";
//			 }
			 if (!sheetObj || !sheetObj.IBSheetVersion){
				 return "";
			 }
			 var allXml="";
			 var hColSep="|";
			 var sColSep="☜☞";
			 var sColOrder="";
			 var aryTD=new Array(gColumnCountInSheet6);
			 for(var i=0; i < gColumnCountInSheet6; i++){
				 aryTD[i]=sheetObj.ColSaveName(i).replace(/sheet2/g, "sheet6");
			 }
			 sColOrder=aryTD.join(hColSep);
			 allXml="<?xml version='1.0'  ?>\n" 
				 + "<SHEET>\n";
			 allXml += "  <DATA COLORDER='" + sColOrder + "' COLSEPARATOR='" + sColSep + "'>\n";
			 var arrRow=new Array();
			 //var k=0;
			 for( var i=sheetObj.HeaderRows(); i<sheetObj.RowCount() + sheetObj.HeaderRows(); i++ ) {
			     /*if(sheetObj.GetCellValue(i, "sheet2_uk") == oldUk){
                     arrRow[k]=i;
                     k++;
                 }*/
			     
			     arrRow[i-sheetObj.HeaderRows()]=i;
			 }
			 if(arrRow.length != 0){
				 var aryTR=new Array(arrRow.length);
				 for(var ir=0; ir<arrRow.length; ir++){
					 for(var ic=0; ic<gColumnCountInSheet6; ic++){
						 aryTD[ic]=String(sheetObj.GetCellValue(arrRow[ir], ic));
					 }
					 aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
				 }
				 allXml += aryTR.join("\n");
			 }
			 allXml += "  \n</DATA>\n"
				 +  "</SHEET>";
			 return allXml;
		 } catch(err) { ComFuncErrMsg(err.message); }
	}
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        if(prefix+"acct_cd" == selColName){
        	sText=sheetObj.GetCellText(Row,prefix+"acct_eng_nm");    
        }else if(prefix+"lgs_cost_cd" == selColName){
        	sText=sheetObj.GetCellText(Row,prefix+"lgs_cost_full_nm");        	
        }else{
        	sText=sheetObj.GetCellText(Row,Col);
        }
        
        if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }
    }	
	
    function sheet1_OnLoadFinish(sheetObj){ 
    	var formObj=document.form;
    	formObj.port_cd.focus();
    	var movedFrom=formObj.moved_from.value;
    	var movedParams=formObj.moved_params.value;
    	if(movedFrom != ""){
    		if(movedParams != ""){
    			f_RetrieveMovedFrom(movedParams);
    		}
    	}
    	formObj.moved_from.value="";
    	formObj.moved_params.value="";
    } 

    /********************************************************************************************************************
     * calling from 'Tariff Update' in VOP_PSO_0036
     * Setting conditions and Retrieving data
     ********************************************************************************************************************/
	/*
    params += "port_cd::" + varPortCd;
	params += "||" + "port_cd1::" + varPortCd1;
	params += "||" + "year::" + varYear;
	params += "||" + "eff_dt::" + varEffDt;
	params += "||" + "acct_cd::" + varAcctCd; 
	params += "||" + "cost_cd::" + varCostCd; 
	params += "||" + "vndr_seq::" + varVndrSeq;
	*/
    var BEFORE_PORT_CD = "";
    function f_RetrieveMovedFrom(movedParams){
    	var formObj=document.form; 
    	var arrMovedParams=movedParams.split("||");	//key::val
    	var iKeyCnt = 0;
    	for(var idx=0; idx<arrMovedParams.length; idx++){
    		var key_val=arrMovedParams[idx].split("::");
    		var key=key_val[0];
    		var val=key_val[1];
    		//Port
    		if(key == "port_cd"){
    			formObj.port_cd.value=val;
    			clearCondition(formObj, "data");
	    		loadTerminal();
    			BEFORE_PORT_CD = formObj.port_cd.value;
    			//doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
    			
    			iKeyCnt++;
    		}
    		//Year
    		if(key == "yd_cd"){			
    			comboObjects[0].SetSelectCode(val);
    			iKeyCnt++;
    		}
    		//Year
    		if(key == "year"){
    			//val is null 일대는 현재 년도를 넣는다.
    			formObj.year.value=val;
    			
    			if(ComIsEmpty(formObj.year)){
    				setToday(formObj.year, "y");
    			}
    			
    			iKeyCnt++;
    		}
    		/*//Yard
    		if(key == "yd_cd"){
    			comboObjects[0].SetSelectCode(val);
    		}
    		//Account
    		if(key == "acct_cd"){
    			comboObjects[1].SetSelectCode(val);
    		}
    		//Cost
    		if(key == "cost_cd"){
    			comboObjects[2].SetSelectCode(val);
    		}
    		//Service Provider
    		if(key == "vndr_seq"){					
    			formObj.vndr_seq.value=val;
    			doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
    		}*/
    	}
    	ComOpenWait(true);
    	//searchVersion();
    	if(iKeyCnt > 0 && formObj.port_cd.value!="" && formObj.year.value!=""){
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    	}
    	ComOpenWait(false);
    }
    //복합 우측 Grid
    function sheet6_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet2_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }        
    }
    
    //Surcharge Grid
    function sheet8_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet4_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }        
    }
    

    //Discount Grid
    function sheet9_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet5_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }
    }
    
    //simple base Grid
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet1_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }        
    }
    
    //simple Surcharge Grid
    function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet2_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }        
    }
    

    //simple Discount Grid
    function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix="sheet3_";
        var sText = "";
        var selColName = sheetObj.CellSaveName (Row, Col);
        sText = sheetObj.GetCellText(Row,selColName)
    	if(sText != ""){
        	sheetObj.SetToolTipText(Row,Col,sText);
        }
    }
    
    //Unit Code에 따른 Cell Property 설정.
	function f_SetRagularMeasUnit(sheetObj){
		var prefix=sheetObj.id+"_";
		//단위별 포맷을 잡아 준다. pso_meas_ut_cd regular_value
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			var tmpUom = sheetObj.GetCellValue(i, prefix+"pso_meas_ut_cd");
			
			if(Number(tmpUom) <= 10){
				sheetObj.InitCellProperty(i, prefix + "regular_value",{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
			}else if(Number(tmpUom) == 14){
				sheetObj.InitCellProperty(i, prefix + "regular_value",{ Type:"Date",Align:"Center",Format:"Hm"} );
			}else{
				sheetObj.InitCellProperty(i, prefix + "regular_value",{ Type:"Text",Align:"Left",Format:""} );
			}
		}
	}
	//단위별 포맷을 잡아 준다. pso_meas_ut_cd regular_value
	function f_SetMeasUnitByRow(sheetObj, row){
		var sheetid=sheetObj.id;
		switch(sheetid) {
			case "sheet2": 
				var prefix			= "sheet1_";
				var tmpObjCdDsp		= sheetObj.GetCellValue(row, prefix+"object_code_dsp");

				var tmpRateCode 	= sheetObj.GetCellValue(row, prefix+"rate_code");
				var tmpRangeFormat	= "NullFloat";
				
				if(tmpRateCode == "F"){
					tmpRangeFormat		= "NullFloat";
				}else{ //S, R
					tmpRangeFormat		= gRateFormat4;
				}
				
				if("TIME" == tmpObjCdDsp){
					sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Date",Align:"Center",Format:"Hm"} );
					sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Date",Align:"Center",Format:"Hm"} );

					sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
					sheetObj.InitCellProperty(row, prefix + "regular_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat4} );
				}else{
					sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
					sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
					
					sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
					sheetObj.InitCellProperty(row, prefix + "regular_value"	,{ Type:"Float",Align:"Right",Format:gRateFormat4} );
				}
				
				break;	
			case "sheet6": 
				var prefix			= "sheet2_";
				var tmpObjCdDsp		= sheetObj.GetCellValue(row, prefix+"object_code_dsp");

				var tmpRateCode 	= sheetObj.GetCellValue(row, prefix+"rate_code");
				var tmpRangeFormat	= "NullFloat";
				
				if(tmpRateCode == "F"){
					tmpRangeFormat		= "NullFloat";					
				}else{ //S, R
					tmpRangeFormat		= gRateFormat4;
				}
				
				if("TIME" == tmpObjCdDsp){
					sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Date",Align:"Center",Format:"Hm"} );
					sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Date",Align:"Center",Format:"Hm"} );

					sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
				}else{
					sheetObj.InitCellProperty(row, prefix + "range_from"	,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
					sheetObj.InitCellProperty(row, prefix + "range_to"		,{ Type:"Float",Align:"Right",Format:tmpRangeFormat} );
					
					sheetObj.InitCellProperty(row, prefix + "rate_value"	,{ Type:"Float",Align:"Right",Format:gRateFormatZero10} );
				}
				
				break;	
		}
	}