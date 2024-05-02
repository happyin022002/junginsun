/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0017.js
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_pso_0017 : business script for vop_pso_0017
     */
    function vop_pso_0017() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject; //combo Object setting
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initCombo=initCombo;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnClick=sheet1_OnClick;
    }
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var LANE="vendor";
    var ROWMARK="|";
    var FIELDMARK="↕";//""
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
             var sheetObject1=sheetObjects[0];
             var comboObject1=comboObjects[0]; 
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
	            switch(srcName) {
	            	  case "btn_New"://Initializing Conditions
	            	  		formObject.reset();
	            	  		setToday(document.form.revyrmon, "ym");
	            	  		comboObjects[0].SetSelectCode("");
	            	  		sheetObject1.RemoveAll();
	            	  		break;
			          case "btn_Retrieve":
			        	  	//Checking WorkMonth
			        	  	if(formObject.revyrmon.value == "" || formObject.revyrmon.value == undefined){
			        	  		ComShowCodeMessage("PSO00003", "Work Month");  
			        	  		formObject.revyrmon.focus();
			        	  		return;
			        	  	}
			        	  	//Setting IBCOMBO value to vndr_seq parameter
			        	  	formObject.vndr_seq.value=comboObject1.GetSelectCode();
			        	  	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;
			          case "btns_calendar":
			        	  openCalendar("ym");
			        	  break;
			          case "btns_search":
			        	  openLaneCode();
			        	  break;
		        	  default : break;
	            } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
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
    function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
     * registering IBCombo Object as list
     * param : combo_obj
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		sheet1_OnLoadFinish(sheet1);
		/*
		 for(i=0;i<sheetObjects.length;i++){
		 doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		 }
		 */
		initControl();
		
	}
	/**
	 * Handling sheet1 load finish event
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		for ( var k=0; k < comboObjects.length; k++) {
			
			initCombo(comboObjects[k], k + 1);
		}
		//
	}
	/**
	 * setting combo initial values and header
   * param : comboObj, comboNo
   * adding case as numbers of counting combos
	 */
	function initCombo(comboObj, comboNo) {
		var formObject=document.form
		switch (comboNo) {
		case 1:
			with (comboObj) {
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetMultiSeparator("|");// Separator
				// SetColAlign("left|left");
				// SetColWidth("30|150");
				// BackColor = "#CCFFFD";
				// FontColor = "#FB1901";
				// ColBackColor(0) = "#CCFFFD";
				// ColFontColor(0) = "#FB1901";
				// ColBackColor(1) = "#CCFFFD";
				// ColFontColor(1) = "#FB1901";
				// DropHeight = 160;
			}
			doActionIBCombo(sheetObjects[0], formObject, IBSEARCH, comboObj, LANE);
			break;
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetid=sheetObj.id;
		switch (sheetid) {
		case "sheet1":
		    with(sheetObj){
	       
	      var HeadTitle1="|Sel.|Pay To|Lane|VVD|Transit Date|Payable Due\nDate|Advance Payment\nStatus|adv_sts_txt|ADV Payment\nRev.Month|Invoice\nStatus|inv_sts_txt|Invoice\nRev.Month|Result|vnderSEq|callSeq|ydCd";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      
	      var prefix="sheet1_";

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_to",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trns_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"py_due_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Image",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"adv_py_sts",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"adv_py_sts_txt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"adv_py_rev_mon", KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Image",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_sts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_sts_txt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_rev_mon",    KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"rslt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"call_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	       
	      InitColumns(cols);

	      SetEditable(0);
	      SetImageList(0,"img/btng_ready.gif");//READY
	      SetImageList(1,"img/btng_requested.gif");//READY
	      SetImageList(2,"img/btng_requested2.gif");//READY
	      SetImageList(3,"img/btng_requested3.gif");//READY
	      SetImageList(4,"img/btng_requested4.gif");//READY
	      SetImageList(5,"img/btng_requested5.gif");//READY
	      SetImageList(6,"img/btng_requested6.gif");//READY
	      SetImageList(7,"img/btng_requested7.gif");//READY
	      SetImageList(8,"img/btng_requested8.gif");//READY
	      SetImageList(9,"img/btng_requested9.gif");//READY
	      SetImageList(10,"img/btng_approved.gif");//RECEIVED2
	      SetImageList(11,"img/btng_complete.gif");//RECEIVED
	      SetImageList(12,"img/btng_paid.gif");//COMPLETED
	      resizeSheet();
		
		}
		break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
		case IBSEARCH: //Retrieving
			formObj.f_cmd.value=SEARCH;
			if (validateForm(sheetObj, formObj, sAction))
				if (sheetObj.id == "sheet1"){
					ComOpenWait(true);
					sheetObj.DoSearch("VOP_PSO_0017GS.do", FormQueryString(formObj ) + "&" + ComGetPrefixParam("sheet1_"));
					ComOpenWait(false);
				}
			break;
		}
	}
	// Retrieving Lane SVC Type
	function doActionIBCombo(sheetObj, formObj, sAction, sComboObj, sComboKey) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
		case IBSEARCH: // Retrieving
			if (validateForm(sheetObj, formObj, sAction))
				if (sheetObj.id == "sheet1") {
					//Initializing combo field
					sComboObj.RemoveAll();
					formObj.f_cmd.value=COMMAND01;
					// var sXml = sheetObj.GetSearchXml("VSK_COMGS.do",
					// FormQueryString(formObj));
//						var sXml=sheetObj.GetSearchData("VOP_PSO_0017GS.do",FormQueryString(formObj));
//					var aa = ComGetEtcData(sXml, sComboKey) + "";
					var etcData = ComSearchEtcData(sheetObj, "VOP_PSO_0017GS.do", FormQueryString(formObj), sComboKey);
					var comboItems= etcData.split(ROWMARK);
					addComboItem(sComboObj, comboItems);
				}
			;
			break;
		}
	}
	/**
	 * Adding data to combo
	 */
	function addComboItem(comboObj, comboItems) {
		for ( var i=0; i < comboItems.length; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}
		//comboObj.InsertItem(0, "ALL","");
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			//                if (!isNumber(formObj.iPage)) {
			//                    return false;
			// }
		}
		return true;
	}
	/**
	 * 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//        	alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
		var url="";
		var imgValue="";
		var formObject=document.form;
		switch (Col) {
			case 7://Request advance
				imgValue = sheetObj.GetCellValue(Row, Col+1);
				
				if (imgValue == "" || imgValue == null || imgValue == "undefined" || imgValue == "-1"
					|| imgValue == "0") {
					return;
				}
				
				url="/opuscntr/VOP_PSO_0018.do?vvd="
					+ sheetObj.GetCellValue(Row, 'sheet1_vvd') + "&ydCd="
					+ sheetObj.GetCellValue(Row, 'sheet1_yd_cd')
					+ "&callSeq="
					+ sheetObj.GetCellValue(Row, 'sheet1_call_seq')
					+ "&vndrSeq="
					+ sheetObj.GetCellValue(Row, 'sheet1_vndr_seq')
					//						+ "&dueDt=" 
					//						+ sheetObj.CellValue(Row, 'py_due_dt')
					+ "&revYrmon="
					+ sheetObj.GetCellValue(Row, 'sheet1_adv_py_rev_mon')
					+ "&row=" + Row + "&col=" + Col + "&sts="
					+ sheetObj.GetCellValue(Row, 'sheet1_adv_py_sts_txt');

				ComOpenPopup(url, 1024, 480, '', '0,0', true, true);

				break;
			case 10://Invoice
				imgValue = sheetObj.GetCellValue(Row, Col+1);
				
				if (imgValue == "" || imgValue == null || imgValue == "undefined" || imgValue == "-1"
					|| imgValue == "0") {
					return;
				}
				
				url="/opuscntr/VOP_PSO_0019.do?vvd="
						+ sheetObj.GetCellValue(Row, 'sheet1_vvd') + "&ydCd="
						+ sheetObj.GetCellValue(Row, 'sheet1_yd_cd') + "&callSeq="
						+ sheetObj.GetCellValue(Row, 'sheet1_call_seq') + "&vndrSeq="
						+ sheetObj.GetCellValue(Row, 'sheet1_vndr_seq') + "&trnsDt="
						+ sheetObj.GetCellValue(Row, 'sheet1_trns_dt') + "&revYrmon="
						+ formObject.revyrmon.value.replace(/-/gi, "") + "&row="
						+ Row + "&col=" + Col + "&sts="
						+ sheetObj.GetCellValue(Row, 'sheet1_inv_sts_txt');

				ComOpenPopup(url, 1054, 540, '', '0,0', true, true);

				break;
			default:
				break;
			}//end of switch
		return;
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	}
	/**
	 * Setting Advance payment data in popup
	 * call by vop_pso_0018
	 * @return
	 */
	function setAdvPyStatus(sts, row, col, duedt) {
		//        	 alert("setAdvPyStatus:="+sts+"Row:="+row+"Col:="+col);
		if (sts =="A") {
			sheetObjects[0].SetCellValue(row, col,10);
			if (duedt !== "" && duedt !== undefined)
				sheetObjects[0].SetCellValue(row, col - 1,duedt);
		} else if (sts =="R") {
			sheetObjects[0].SetCellValue(row, col,0);
			sheetObjects[0].SetCellValue(row, "sheet1_rslt","Rejected");
			sheetObjects[0].SetCellValue(row, col - 1,"");// Due_DT Clear
		}
	}
	/**
	 * Setting Invoice Status
	 * call by vop_pso_0019
	 * @param sts
	 * @param row
	 * @param col
	 * @param duedt
	 * @return
	 */
	function setInvStatus(sts, row, col, duedt) {
		//        	 alert("setAdvPyStatus:="+sts+"Row:="+row+"Col:="+col);
		if (sts =="A") {
			sheetObjects[0].SetCellValue(row, col,10);
		} else if (sts =="R") {
			sheetObjects[0].SetCellValue(row, col,0);
			sheetObjects[0].SetCellValue(row, "sheet1_rslt","Rejected");
		}
	}
	/**
	 * registering initial event
	 */
	function initControl() {
		axon_event.addListenerForm('change', 'obj_change', form);
//		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//		axon_event.addListenerFormat('blur', 'obj_deactivate', form);
//		axon_event.addListenerFormat('focus', 'obj_activate', form);
		// Today Setting ..
		setToday(document.form.revyrmon, "ym");
		document.form.revyrmon.focus();
	}
	function obj_change() {
		var formObject=document.form;
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "port_cd":
				formObject.loc_cd.value=formObject.port_cd.value.substring(0, 5);
				formObject.vndr_seq.value="";// Clearing vndr_seq
				doActionIBCombo(sheetObjects[0], formObject, IBSEARCH,
						comboObjects[0], LANE);
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
//	function obj_deactivate() {
//		ComChkObjValid(event.srcElement);
//	}
//	function obj_activate() {
//		ComClearSeparator(event.srcElement);
//	}
	function openCalendar(mode) {
		switch (mode) {
		case "ym":
			var cal=new ComCalendar();
			cal.setDisplayType('month');
			cal.select(document.form.revyrmon, "yyyy-MM");
			break;
		default:
			break;
		}
	}

	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
	