/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3522.js
*@FileTitle  : Inland Rates Excel Imports
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	// Check uploaded data
	var ERR_FLG="";
	// The error data has happened during excel checking. Use it when moves to Tab.
	var TAB_DATA="";
	var trfCdNm = "";
	
	var returnData=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	/**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
   	 * @author 
   	 * @version 2010.10.13
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					if(returnData) {
						ComPopUpReturnValue(returnData); 
					}
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_rowdelete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
				case "btn_loadexcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break; 
				case "btn_check":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_close":
					ComClosePopup(); 
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
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items<br>
	* defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj mandatory IBSheet Object
	* @return void
   	* @author 
   	* @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2010.10.13
    */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
		if (!opener) opener = window.opener;
		if (!opener) opener = parent;
		
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			sheetObjects[i].XmlHttpVer=2;
		}
		trfCdNm = opener.trf_cd_nm.value
		// Column Setting
		initLocationSheetColumn();
	    // Button Initialize
	    toggleButtons("INIT");
	}
	
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
   	 * @author 
   	 * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
     		case "sheet1":	//location information
	     		with(sheetObj){
		        	
	        	    var HeadTitle1="Flag| | | | | | | | | | | | | " +
	        	      	"|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
	        	    var HeadTitle2="Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" +
	        	    	"|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
	        	    var headCount=ComCountHeadTitle(HeadTitle1);
	
	        	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1, ComboMaxHeight:250 } );
	
	        	    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	        	    var headers = [ { Text:HeadTitle1, Align:"Center"},
	        	                  { Text:HeadTitle2, Align:"Center"} ];
	        	    InitHeaders(headers, info);
	
	        	    var cols = [ {Type:"Status",	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	        	                 {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	        	                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_rt_seq" },
	        	                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_bse_loc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	        	                 {Type:"Text",      Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"inlnd_rt_bse_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_bse_loc_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_via_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	        	                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_inlnd_rt_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_min_lmt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	        	                 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_lmt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	        	                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rt_lmt_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_one_wy_bx_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_one_wy_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_one_wy_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_one_wy_40ft_hc_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_one_wy_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_bx_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_20ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_40ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_40ft_hc_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_45ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	        	                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
	        	       
	        	    InitColumns(cols);
	
	        	    SetEditable(1);
	        	                                    SetWaitImageVisible(0);
	        	    SetShowButtonImage(2);
	        	    //SetAutoRowHeight(0);
	        	    resizeSheet(); //SetSheetHeight(460);
	      	        
	      	        SetColProperty("inlnd_rt_term_cd", {ComboText:inlndRtTermCdComboText, ComboCode:inlndRtTermCdComboValue} );
		        	SetColProperty("prc_inlnd_rt_trsp_mod_cd", {ComboText:prcRrspModCdComboText, ComboCode:prcRrspModCdComboValue} );
		        	SetColProperty("inlnd_rt_lmt_wgt_ut_cd", {ComboText:inlndRtLmtWgtUtCdComboText, ComboCode:inlndRtLmtWgtUtCdComboValue} );
		        	SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText, ComboCode:prcCgoTpCdComboValue} );
		        	SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
		        	
	     		}
	     		break;
     	}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

	
  /**
   * Handling sheet's processes <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj mandatory html form object
   * @param {int} sAction mandatory,Constant Variable
   * @return void
   * @author 
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {	 				
	 			case IBSEARCH: // Check
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				ComOpenWait(true);	 				
	 				ComShowCodeMessage("PRI06013");
	 				// When MS-Excel file checking, Set Mandatory input option to False.
	 				setKeyField();	 				
					// Error Data makes Red
					checkValidationAllData(sheetObj);
	 				break;
	 			case IBSAVE: // Save						
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				ComOpenWait(true);	 				
	 				if (!ComPriConfirmSave()) {
	  					return false;
	  				}
					var sParam="f_cmd=" + MULTI;
					sParam=sParam + "&trf_pfx_cd=" 		+ formObj.trf_pfx_cd.value;
					sParam=sParam + "&trf_no=" 			+ formObj.trf_no.value;
					sParam=sParam + "&trf_inlnd_seq=" 	+ formObj.trf_inlnd_seq.value;
					sParam=sParam + "&amdt_seq=" 			+ formObj.amdt_seq.value;
					sParam=sParam + "&n1st_cmnc_amdt_seq="+ formObj.amdt_seq.value;
					sParam=sParam + "&src_info_cd=" 		+ "NW";
					sParam=sParam + "&excel_flg=" 		+ "Y";
					// When Checking is completed, status of all data is "R". so, return all data.
	  				var sParamSheet1=sheetObj.GetSaveString(true);
	  				if (sParamSheet1 != "") {
	  					sParam=sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
//parameter changed[check again]CLT
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_3522GS.do", sParam);
//parameter changed[check again]CLT
	  				sheetObj.LoadSaveData(sXml);
	  				
	 				break;
	        	case IBLOADEXCEL:
		        	if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
		        	}
		        	ComOpenWait(true);
		        	if (!ComShowCodeConfirm("PRI06011")) {
						return false;
					}
		        	sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
		        	sheetObj.CheckAll("chk",0);
		        	//  because n1st_cmnc_amdt_seq data is not exists at excel file to upload
		        	changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
	        		// When ComboBox checked 
		    		sheetObj.RenderSheet(0);
		        	for ( var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
		        		if(formObj.amdt_seq.value > 0) {
		        			sheetObj.SetRowFontColor(i,"#FF0000");
		        		}
		        		if (sheetObj.GetCellValue(i, "inlnd_rt_term_cd") == ""
		     					&& ComTrim(sheetObj.GetCellText(i, "inlnd_rt_term_cd")) != "") {
		     				sheetObj.SetCellValue(i, "inlnd_rt_term_cd",sheetObj.GetCellText(i, "inlnd_rt_term_cd"),0);
		     			}
		        		if (sheetObj.GetCellValue(i, "prc_inlnd_rt_trsp_mod_cd") == ""
		     					&& ComTrim(sheetObj.GetCellText(i, "prc_inlnd_rt_trsp_mod_cd")) != "") {
		     				sheetObj.SetCellValue(i, "prc_inlnd_rt_trsp_mod_cd",sheetObj.GetCellText(i, "prc_inlnd_rt_trsp_mod_cd"),0);
		     			}
		        		if (sheetObj.GetCellValue(i, "inlnd_rt_lmt_wgt_ut_cd") == ""
		     					&& ComTrim(sheetObj.GetCellText(i, "inlnd_rt_lmt_wgt_ut_cd")) != "") {
		     				sheetObj.SetCellValue(i, "inlnd_rt_lmt_wgt_ut_cd",sheetObj.GetCellText(i, "inlnd_rt_lmt_wgt_ut_cd"),0);
		     			}
		        		if (sheetObj.GetCellValue(i, "prc_cgo_tp_cd") == ""
		     					&& ComTrim(sheetObj.GetCellText(i, "prc_cgo_tp_cd")) != "") {
		     				sheetObj.SetCellValue(i, "prc_cgo_tp_cd",sheetObj.GetCellText(i, "prc_cgo_tp_cd"),0);
		     			}
		     			sheetObj.SetRowStatus(i,"R");
		        	}
		        	sheetObj.RenderSheet(1);
		        	// Button Control
		     		toggleButtons("LOAD");		        	
					break;
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					var idx=sheetObj.DataInsert();
					sheetObj.SelectCell(idx, "inlnd_rt_bse_loc_cd");
		 			if(formObj.amdt_seq.value > 0) {
		 				sheetObj.SetRowFontColor(idx,"#FF0000");
		 			}
	    			//Highlighting
		 			changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
	 				break;
				case IBDELETE: // Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					// Selected  Row List ////////////////////////////////					
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					for(var i=chkArr.length-1; i >= 0; i--){
						sheetObj.RowDelete(Number(chkArr[i]), false);
					}
					break;						
	 		}
 		} catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
 			}
 		} finally {
 			 ComOpenWait(false);
 		}
 	}
 	
 	/**
     * OnSaveEnd 시 발생한다.<br>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Code,Msg    
     * @return 없음
     * @author SHKIM
     * @version 2012.04.17
     */
 	function sheet1_OnSaveEnd(sheetObj, Code , Msg)  {
 		if (Code >= 0) {
 			returnData=true;
 		}
 	}
 	
 	/**
     * OnLoadExcel 시 발생한다.<br>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Code
     * @param {String} Msg   
     * @version 2012.04.17
     */
 	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;	
	} 	
 	
 	function tmp_object(sheet, row, col){
		this.sheet = sheet;
		this.row = row;
		this.col = col;
	}
	var G_TMP_OBJECT;
	
	 /**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2010.11.05
     */
	function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
		var colname=sheetObj.ColSaveName(Col);
 	    var formObj=document.form;
 	   G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
      	switch(colname)
      	{  	    		
  	    	case "inlnd_rt_bse_loc_cd":
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?"
  	    			//sUrl += "f_cmd="+ SEARCH01;
  	    			sUrl += "location_cmd=L";
	  			ComOpenPopup(sUrl, 700, 290, "callbackBse", "0,1", false);
  	  			break;
  	    	case "inlnd_rt_via_loc_cd":	
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	    			//sUrl += "&f_cmd="+ SEARCH01;
	    			sUrl += "&location_cmd=L";
	    			sUrl += "&func=callbackVia";
	  			ComOpenPopup(sUrl, 700, 290, "callbackVia", "0,1", false);
	  			
  				break;  		
      	}
	}
	
	function callbackBse(rtnVal) {
		if (rtnVal != null){
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "inlnd_rt_bse_loc_cd", rtnVal.cd,0);
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "inlnd_rt_bse_loc_nm", rtnVal.nm,0);
//			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "inlnd_rt_bse_loc_zip_cd", rtnVal.zip_cd,0);
		}
	}
	
	function callbackVia(rtnVal) {
		if (rtnVal != null){
			G_TMP_OBJECT.sheet.SetCellValue(G_TMP_OBJECT.row, "inlnd_rt_via_loc_cd",rtnVal.cd,0);
		}
	}
	
    /**
     * Calling Function in case of OnChange event <br>
     * showing Description<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2010.11.05
     */  
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		switch(colName)
     	{
 			case "inlnd_rt_bse_loc_cd":
 	    		if (Value.length > 1){
 	    			var sParam="f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
//parameter changed[check again]CLT  	  				
 	    				var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", sParam);
 	  				var arrData=ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				if (arrData != null && arrData.length > 0){	   	  				
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd",arrData[0][0],0);
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm",arrData[0][1],0);
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd",arrData[0][2],0);
					}else{
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd","",0);
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm","",0);
						sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd","",0);
	  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_cd","",0);
					sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_nm","",0);
					sheetObj.SetCellValue(Row, "inlnd_rt_bse_loc_zip_cd","",0);
  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
 	    		}
 	    		break;
 			case "inlnd_rt_via_loc_cd":	    		
 	    		if (Value.length > 1){
 	    			var sParam="f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
//parameter changed[check again]CLT
 	    				var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", sParam);
 	  				var arrData=ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				if (arrData != null && arrData.length > 0){
						sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd",arrData[0][0],0);
					}else{
						sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd","",0);
	  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.SetCellValue(Row, "inlnd_rt_via_loc_cd","",0);
  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
 	    		}
 	    		break;	
     	}
 	}
    
    /**
     * calling Event when keyboard press data cell <br> 
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {Long} Row mandatory , Row Index of cell that event triggered
     * @param {Long} Col mandatory , Column Index of cell that event triggered
     * @param   {Integer} KeyCode Mandatory ASCII code value
     * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
     * @return void
     * @author 
     * @version 2010.12.10
     */ 
     function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {    	
         if (ERR_FLG && KeyCode == 9) {
        	 searchTabCell(sheetObj, Row, Col);
         }
     }
     
     /**
      * Explore to cell in Excel error data using tab key <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {Long} Row mandatory , Row Index of cell that event triggered
      * @param {Long} Col mandatory , Column Index of cell that event triggered
      * @return void
      * @author 
      * @version 2010.12.10
      */ 
     function searchTabCell(sheetObj, Row, Col) {    	 
    	 var Arr=TAB_DATA.split("|");
    	 var vCell="";
    	 var sRow=0;
    	 var sCol=0;
    	 for(var i=0; i<Arr.length - 1; i++) {
    		 vCell=Arr[i].split(",");
    		 sRow=parseInt(vCell[0]) + sheetObj.HeaderRows();
    		 sCol=parseInt(vCell[1]);
    		 if(Row < sRow) {  
    			 if (sheetObj.GetCellBackColor(sRow, sCol).toUpperCase() == "#FFFF00") {
                     sheetObj.SelectCell(sRow, sCol, false);
                     break;
                 }
    		 } else if(Row == sRow && Col-1 < sCol) {
    			 if (sheetObj.GetCellBackColor(sRow, sCol).toUpperCase() == "#FFFF00") {
                     sheetObj.SelectCell(sRow, sCol, false);
                     break;
                 }
    		 }
    		 if(i == Arr.length - 2) {
    			 searchTabCell(sheetObj, sheetObj.HeaderRows(), 1);
    		 }
    	 }   
     }
     
     /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
   	 * @author 
   	 * @version 2010.10.13
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // Check
 			if(getValidRowCount(sheetObj) < 1) {
 				return false;
 			}
			break;
   		case IBSAVE: 
			/////////////////////////////////////////////////////////////////////
	        // update date checking
	        if( checkChangingUpdateDate(sheetObjects[0], "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;
   		case IBINSERT: // Row Add
 			break;
 		case IBDELETE: // Row Delete
 			if(getValidRowCount(sheetObj) < 1) {
 				return false;
 			}
 			break;
    	case IBLOADEXCEL:    		
 			break;
 		}
 		return true;
 	}
	
 	/**
 	 * Initialize title of Sheet <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @return void
   	 * @author 
   	 * @version 2010.11.13
 	 */
 	function initLocationSheetColumn() {
 		var formObj=document.form;
 		var inlndColNm=trfCdNm;
 		var sheetObj=sheetObjects[0];
 		sheetObj.SetCellText(0, 1 ,inlndColNm);
 		sheetObj.SetCellText(0, 2 ,inlndColNm);
		sheetObj.SetCellText(0, 3 ,inlndColNm);
		sheetObj.SetCellText(0, 4 ,inlndColNm);
		sheetObj.SetCellText(0, 5 ,inlndColNm);
		sheetObj.SetCellText(0, 6 ,inlndColNm);
		sheetObj.SetCellText(0, 7 ,inlndColNm);
		sheetObj.SetCellText(0, 8 ,inlndColNm);
		sheetObj.SetCellText(0, 9 ,inlndColNm);
		sheetObj.SetCellText(0, 10 ,inlndColNm);
		sheetObj.SetCellText(0, 11 ,inlndColNm);
		sheetObj.SetCellText(0, 12 ,inlndColNm);
		sheetObj.SetCellText(0, 13 ,inlndColNm);
 	}
 	
 	/**
 	 * Controlling all buttons as enable/Disable<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {string} mode Mandatory,user mode or authority
 	 * @param {string} flag Optional Button Activation Control
   	 * @author 
   	 * @version 2010.10.13
 	 */
 	function toggleButtons(flag) {
 		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		try {
 			ComBtnDisable("btn_save"); 			
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowdelete");
 			ComBtnDisable("btn_loadexcel");
 			ComBtnDisable("btn_check");
 			ComBtnEnable("btn_close");
 			switch (flag) {
 			case "SUCCEED":
				ComBtnEnable("btn_save");
				break;
			case "FAIL":
				ComBtnEnable("btn_loadexcel");
				ComBtnEnable("btn_check"); 			
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
			case "LOAD":
				ComBtnEnable("btn_loadexcel");
				ComBtnEnable("btn_check");	
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
			case "INIT":
				ComBtnEnable("btn_loadexcel");	
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
 	 		default:
 	 			ComBtnEnable("btn_loadexcel");	
 	 			ComBtnEnable("btn_rowadd");
 	 			ComBtnEnable("btn_rowdelete");
 	 			break;
 	 		} 			
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
 		}
 	}
 	
   /**
    * checking whether other user modified datas already about same s/c no.<BR>
    * Checking whether data modified by other user <br> 
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj sheet object contains update date and key
    * @param {String} checkTpCd ,code to be define table to check update date
    *  
    * @return boolean , true :modified, false: not modified
    * @author 
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	var formObj=document.form;
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
        // update date checking
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+formObj.trf_pfx_cd.value
	        + "&key2="+formObj.trf_no.value
	        + "&key3="+formObj.amdt_seq.value
	        + "&key4="+formObj.trf_inlnd_seq.value
	        + "&upd_dt="+formObj.upd_dt.value;
//parameter changed[check again]CLT
	        var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        // Retrieve Detail data when there is no modified on main.
	        if(!returnValue && sheetObjects[0].IsDataModified()) {
	        	checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND_RT&page_name=Inland Rates Location"
		        + "&key1="+formObj.trf_pfx_cd.value
		        + "&key2="+formObj.trf_no.value
		        + "&key3="+formObj.amdt_seq.value
		        + "&key4="+formObj.trf_inlnd_seq.value
		        + "&upd_dt="+formObj.dtl_upd_dt.value;
//parameter changed[check again]CLT
	        	var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
		        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
		        	sheetObj.LoadSearchData(cXml,{Sync:1} );
		        	ComOpenWait(false); //->waiting->End
		        	returnValue=true;
		        }
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
   
   /**
	* The function calls after Check button event. When Error Data exists, make BGColor of Sheet yellow.<br>
	* <br><b>Example :</b>
	* <pre>
	* 
	* </pre>
	* @param {ibsheet} sheetObj mandatory IBSheet Object
	* @return void
	* @author 
	* @version 2010.11.08
	*/
	function checkValidationAllData(sheetObj) {
		var check="";
		TAB_DATA=""; // Initialize Tab Data
		// Setting color to Error Cell
		var color="#FFFF00"; // YELLOW
		sheetObj.CheckAll("chk",0);
		clearTooltip();
		// Do not Duplicate Check. - When Hub or Depot is exists, the rate could be diffenrent
		check=checkDBCodeExist(sheetObj, color);
		if (check != "") {		
			TAB_DATA=check;
			ERR_FLG="Y";
			toggleButtons("FAIL");
		} else {
			TAB_DATA="";
			ERR_FLG="N";
			//Process All Cell make Read-Only
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				sheetObj.SetRowEditable(i,0 );
			}
			toggleButtons("SUCCEED");
			// When MS-Excel file checking, Set Mandatory input option to True.
			setKeyField();			
		}
	}
	
    /**
     * Amending <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} Row Mandatory,  Cell's Row Index
     * @param {int} Col Mandatory,  Cell's Col Index
     * @return void
   	 * @author 
   	 * @version 2010.11.08
     */         	
	function getTabString(sheetObj, Row, Col) {
		var sCell="";
		sCell=Row + "," + Col + "|"; 		
		return sCell;
	}
	
	/**
	 * validation function of excel file loading <br>
	 * existing error data, changed color <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		checkDBCodeExist(sheetObj, formObj);
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {object} color Mandatory IBSheet RgbColor
	 * @return check
	 * @author 
	 * @version 2010.11.25
	 */
	function checkDBCodeExist(sheetObj, color) {
		var formObj=document.form;
		var check="";
		//ComOpenWait(true);	
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		var sParamSheet="";
		// If Error occurred, the rows that occurred error makes select
		// First error checking is whole checking
		if(ERR_FLG == "Y") {
			sParamSheet=sheetObj.GetSaveString(false);
		} else {
			sParamSheet=sheetObj.GetSaveString(true);
		}
		if (sParamSheet != "") {
			sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		} else {
			return "ERROR";
		}
//parameter changed[check again]CLT
		var sXml=sheetObj.GetSearchData("ESM_PRI_3522GS.do", sParam);
		var arrErr=ComPriXml2Array(sXml, "etc1|etc2|etc4|etc5|cd|nm|etc3");
		////////////////////////////////////////////////////
		// Initialize status of Row that occurred error. The value is 'R'
		var sRow=sheetObj.FindStatusRow("U|I");
        // Create array using received result 
        var arrRow=sRow.split(";");            
        for (var idx=0; idx<arrRow.length-1; idx++) { 
        	sheetObj.SetRowStatus(arrRow[idx],"R");
        }
		////////////////////////////////////////////////////
        if (arrErr != null && arrErr.length > 0) {        	
        	for (var i=0; i < arrErr.length; i++) {
        		if(ERR_FLG == "Y") {
        			// etc3 is sequence number of sheet
        			sheetObj.SetCellValue(parseInt(arrErr[i][6]) + sheetObj.HeaderRows()- 1, "ibflag", "U");
        			add2Tooltip(parseInt(arrErr[i][6]) + sheetObj.HeaderRows()- 1, arrErr[i][1], ComGetMsg(arrErr[i][2], "input", arrErr[i][5]));
            		check += getTabString(sheetObj, parseInt(arrErr[i][6]) - 1, parseInt(arrErr[i][3]));
        		} else {
        			sheetObj.SetCellValue(parseInt(arrErr[i][0]) + sheetObj.HeaderRows(),"ibflag", "U");
            		// Rewrite when the message is several 
            		add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows(), arrErr[i][1], ComGetMsg(arrErr[i][2], "input", arrErr[i][5]));
            		check += getTabString(sheetObj, parseInt(arrErr[i][0]), parseInt(arrErr[i][3]));
        		}
        	}
        }
		return check;
	}
	
	/**
	 * After Checking the uploaded file, Initialize tooltip and color <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2010.11.25
	 */	
	function clearTooltip() {
    	var sheetObj=sheetObjects[0];
    	var n=sheetObj.HeaderRows()+sheetObj.RowCount();
    	var m=sheetObj.LastCol();
    	var i=sheetObj.HeaderRows();
    	var j=0;
        for (i=sheetObj.HeaderRows(); i < n; i++) {
        	if(sheetObj.GetRowStatus(i) == "U") {
	            for (j=0 ; j <= m ; j++) {
	                if (sheetObj.GetToolTipText(i, j) != "") {
		                sheetObj.SetCellBackColor(i, j,sheetObj.GetEditableColor());
		                sheetObj.SetToolTipText(i, j,"");
		            }	
	            }
        	}
        }
	}
	
    /**
     * Set Tooltip & Color of IbSheet's Cell<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} Row Mandatory,  Cell's Row Index
     * @param {int} Col Mandatory,  Cell's Col Index
     * @param {string} msg Mandatory, Tooltip Message
     * @return void
   	 * @author 
   	 * @version 2010.11.08
     */   
	function add2Tooltip(row, col, msg) {
		var sheetObj=sheetObjects[0];
		var toolTip = sheetObj.GetToolTipText(row, col) + "\n- " +  msg;
		
		sheetObj.SetCellBackColor(row, col,"#FFFF00");
		sheetObj.SetToolTipText(row, col, toolTip);
	}
	
    /**
     * Initialize value of flag by Excel upload<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return void
   	 * @author 
   	 * @version 2010.11.08
     */       
	function initExcelFlag() {
		ERR_FLG="";
		clearTooltip();
	}
	
   /**
	* Setting SHEET header Mandatory Option. <br>
	* <br><b>Example :</b>
	* <pre>
	*    setKeyField(true);
	* </pre>
	* @return void
	* @author 
	* @version 2010.12.10
	*/
	function setKeyField() {
		var sheetObj=sheetObjects[0];
		var tFlag=sheetObj.GetCellProperty(0, 3, dpKeyField);
 		if(tFlag) {
 			sheetObj.InitDataProperty(0, 3, dtPopupEdit,	80,	daCenter,	true,	"inlnd_rt_bse_loc_cd",	false,	"",	dfNone,	0,	true,	true,	5);
 			sheetObj.InitDataProperty(0, 13,	dtCombo,	75, daCenter,	true,	"curr_cd",     			false,	"",	dfNone,	0,	true,	true);
 		}
	}	
