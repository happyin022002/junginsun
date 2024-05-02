/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1801.jsp
*@FileTitle  : Pegasus XML Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var rdObjects=new Array();
	var rdCnt=0;
	var iterator="|$$|";
	var comboObjects=new Array();
	var combo1=null;
	var comboCnt=0;
	var arrMultiCombo;
	var arrWindow=new Array(null,null); 
	// esm_bkg_0229 popup Count
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
				break;
			case "btn_new":
				formObject.rcv_from_dt.value=ComGetDateAdd(null, "d", -1, "-");
				formObject.rcv_to_dt.value=ComGetNowInfo();
				ComClearObject(formObject.rqst_no);
				ComClearObject(formObject.msg_seq);
				ComClearObject(formObject.msg_desc);
				upld_cd.SetSelectIndex(0);
				break; 
			case "btn_exceldown":
				if (sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
	       	    } else{
	       	    	doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
	       	    }
				break;
			case "btn_upload":
				doActionIBSheet(sheetObjects[0],document.form,"btn_upload","","");
				break;
			case "btn_xmlview":
				doActionIBSheet(sheetObjects[0],document.form,"btn_xmlview","","");
				break;
			case "btns_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.rcv_from_dt, formObject.rcv_to_dt,'yyyy-MM-dd');
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering Combo Object as list
	 * @param combo_obj Combo Object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	function initCombo(comboObj) {
		addComboItem(comboObj, "|Y|N|M", "ALL|Y|N|M");
		comboObj.SetColWidth(0, "80");
		comboObj.SetSelectIndex(0);
	}    
	
	function initControl() {
		var formObject=document.form;
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
		applyShortcut();
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
		combo1=comboObjects[0];
		comboCnt=comboObjects.length;
		// IBMultiCombo initialization
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR,"","");
		document.form.sXml.value=null;
		initControl();
//		initRdConfig(rdObjects[0]);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1: 
			with(sheetObj){
				var HeadTitle1="|Chk|Msg Seq|RCV Date(KST)|Upload|Msg Type|Request No. / VGM Doc ID.|Flat File";
				SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20} );
				var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers=[ { Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);
				var cols=[ {Type:"Status",     Hidden:1, Width:30,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Radio",     Hidden:0, Width:60,   	Align:"Center",  ColMerge:1,   SaveName:"slct_flg" },
							{Type:"Text",      Hidden:0, Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"bkg_xter_rcv_msg_seq",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:150,		Align:"Center",  ColMerge:1,   SaveName:"cre_dt",              		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:60,  	Align:"Center",  ColMerge:0,   SaveName:"upld_flg",            		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:100,   	Align:"Center",  ColMerge:0,   SaveName:"msg_type",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:170,   	Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_no",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0, Width:100,   	Align:"Left",    ColMerge:1,   SaveName:"xml_and_edi_msg_desc",	   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							];
				InitColumns(cols);
				SetSheetHeight(355);
			}
			break;
		}
	}
	
	    function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
	        switch(sAction) {
			case IBSEARCH:      //Retrieve
				document.form.sXml.value=null;
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if (sheetObj.id == "sheet1") {
	        		sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
		        	formObj.f_cmd.value=SEARCH;
		        	sheetObj.DoSearch("ESM_BKG_1801GS.do", FormQueryString(formObj)+"&"+ "page_no=1" ,{Sync:2} );
				}
				break;
				
			case IBCLEAR:      //OPEN			
//				ComClearObject(formObj.rqst_no);
//				ComClearObject(formObj.msg_seq);
//				ComClearObject(formObj.msg_desc);
//				upld_cd.SetSelectIndex(0);
//				formObj.rcv_from_dt.value=ComGetDateAdd(null, "d", -1, "-");
//				formObj.rcv_to_dt.value=ComGetNowInfo();
//				sheetObj.RemoveAll();
				break;
				
			case "btn_exceldown":      //Excel down
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), Merge:1, SheetDesign:1 });
				}
				break;
				
			case "btn_upload":      //Upload
				if(!validateForm(sheetObj,formObj,sAction))  return false;
		        for (var i=2; i <= sheetObjects[0].LastRow(); i ++) {
		    		if (sheetObjects[0].GetCellValue(i,"slct_flg") == "1") {
		    			formObj.rcv_seq.value = sheetObjects[0].GetCellValue(i, "bkg_xter_rcv_msg_seq");
		    			formObj.xml_desc.value = sheetObjects[0].GetCellValue(i, "xml_and_edi_msg_desc");
		    		}
		        }
				formObj.f_cmd.value=MULTI01;
	 			var sXml=sheetObj.GetSaveData("ESM_BKG_1801GS.do", FormQueryString(formObj));
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComShowCodeMessage("BKG00166");
				}else{
					ComShowCodeMessage("BKG00167");										
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"","");
				break;

			case "btn_xmlview": 
				var msgSeq = "";
				if(!validateForm(sheetObj,formObj,sAction))  return false;
		        for (var i=2; i <= sheetObjects[0].LastRow(); i ++) {
		    		if (sheetObjects[0].GetCellValue(i,"slct_flg") == "1") {
		    			msgSeq = sheetObjects[0].GetCellValue(i, "bkg_xter_rcv_msg_seq");
		    		}
		        }
				
				var param="?msg_seq="+msgSeq;
		 		ComOpenPopup("ESM_BKG_1802.do" + param, 825, 550, "", "1,0", true);
				break;
				
	        }
	    }

	    /**
	     * handling process for input validation
	     */
	    function validateForm(sheetObj,formObj,sAction){
	    	with(formObj){
	    		switch(sAction) {
	    			case IBSEARCH:
	    				if( formObj.rcv_from_dt.value == "" ){
	    					ComShowCodeMessage( "COM12114", "RCV DT"  );
	    					return false;
	    				}
	    				if( formObj.rcv_to_dt.value == "" ){
	    					ComShowCodeMessage( "COM12114", "RCV DT"  );
	    					return false;
	    				}
	    				if (formObj.rcv_from_dt.value != "" && formObj.rcv_to_dt.value != "") {
	    					if (ComGetDaysBetween(formObj.rcv_from_dt,formObj.rcv_to_dt) < 0) {
	    						ComShowMessage(msgs['BKG00112']);
	    						return false;
	    					}
	    				}
	    				break;

	    			case "btn_upload":
	    				if (sheetObj.CheckedRows("slct_flg") == 0) {
	    					ComShowMessage(msgs['BKG00155']);
	    					return false;
	    				}
	    				break;	    				
	    				
	    			case "btn_xmlview":
	    				if (sheetObj.CheckedRows("slct_flg") == 0) {
	    					ComShowMessage(msgs['BKG00155']);
	    					return false;
	    				}
	    				break;	    				
	    				
	    		}
	    	}
	    	return true;
	    }

	    /**
	     * Add Combo 
	     */	
	    function addComboItem(comboObj, itemValStr, itemTxtStr) {
	     	var itemValArr=itemValStr.split("|");
	        var itemTxtArr=itemTxtStr.split("|");
	     	for (var i=0; i<itemValArr.length; i++) {
	     		comboObj.InsertItem(i, itemTxtArr[i], itemValArr[i]);    	
	        }
	    }
	    
		function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	    	ComOpenWait(false);
	    }

		function sheet1_OnClick(sheetObj, row, col, val) {
			if ( col == 1) {
				if (sheetObjects[0].GetCellValue(row, "slct_flg") == "1" && sheetObjects[0].GetCellValue(row, "upld_flg") != "N") {
					document.form.btn_upload.disabled=true;			
				}else{
					document.form.btn_upload.disabled=false;				
				}
			}			
		}
		